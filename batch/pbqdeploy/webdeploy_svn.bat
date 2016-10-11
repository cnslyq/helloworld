echo off
setlocal enabledelayedexpansion

rem /**
rem  *
rem  * This script is used to deploy webproxy files(vm & js) to multiplicate environment.
rem  *
rem  * It will compare the diff files between 2 versions and deploy the target version file.
rem  *
rem  */

set build_setup=build_webproxy.properties
set from_desc=Please input old version : 
set to_desc=Please input target version : 
set old_from_version=-1
set old_to_version=-1

for /f "tokens=1,2 delims==" %%i in (%build_setup%) do (
	set %%i=%%j
)

:inputno
set from_version=""
set to_version=""
set confirm_opt=""
cd /d %webproxy_root_path%
echo;
echo ******************************************************************************
echo;
echo Please be noticed, vm ^& js will be moved to the %env% environment (!%env%_tomcat_server_ip!) ^^!^^!
echo;
echo ******************************************************************************
echo;

rem set from_version=57684
rem set to_version=57795
if %old_from_version% neq -1 (
	set from_desc="Please input old version (%old_from_version%) : "
	set to_desc="Please input target version (%old_to_version%) : "
) else (
	set from_desc="Please input old version : "
	set to_desc="Please input target version : "
)
set /p from_version=%from_desc%
if %from_version% equ 0 exit
set /p to_version=%to_desc%
if %to_version% equ 0 exit
if %from_version% equ "" if %old_from_version% neq -1 set from_version=%old_from_version%
if %to_version% equ "" if %old_to_version% neq -1 set to_version=%old_to_version%

svn diff --summarize -r %from_version%:%to_version% > %webdeploy_file_list%
if %errorlevel% neq 0 (
	if %old_from_version% neq -1 (
		set from_version=%old_from_version%
		set to_version=%old_to_version%
	)
	echo Wrong version ^^!^^! Please re-input.
	goto inputno
) else (
	set old_from_version=%from_version%
	set old_to_version=%to_version%
)

rem svn export
call %~dp0\webdeploy_svn_export %to_version%

echo;
echo SVN Export File List : 
echo;
for /f "tokens=1,2 delims= " %%i in (%webdeploy_file_list%) do (
	echo   %%j
)
echo;
set /p confirm_opt=The above files will be moved. Are you sure ? 
if %confirm_opt% neq yes goto inputno

rem move files to 24
for /f "tokens=1,2 delims= " %%i in (%webdeploy_file_list%) do (
	echo;
	rem set full_name=%webproxy_root_path%\%%j
	set full_name=%~dp0%tempdir%\%%j
	call %~dp0\webdeploy_pscp.bat !full_name! %~dp0%tempdir%
)

goto inputno
