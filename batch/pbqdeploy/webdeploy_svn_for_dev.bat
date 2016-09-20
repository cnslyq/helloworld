echo off
setlocal enabledelayedexpansion
set build_setup=build.properties
set from_desc=Please input from version : 
set to_desc=Please input to version : 
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
echo *************************************************************************
echo;
echo Please be noticed, this program will move vm ^& js to 10.1.110.24 ^^!^^!
echo;
echo *************************************************************************
echo;

rem set from_version=57691
rem set to_version=57684
if %old_from_version% neq -1 (
	set from_desc="Please input from version (%old_from_version%) : "
	set to_desc="Please input to version (%old_to_version%) : "
) else (
	set from_desc="Please input from version : "
	set to_desc="Please input to version : "
)
set /p from_version=%from_desc%
if %from_version% equ 0 exit
set /p to_version=%to_desc%
if %to_version% equ 0 exit
if %from_version% equ "" if %old_from_version% neq -1 set from_version=%old_from_version%
if %to_version% equ "" if %old_to_version% neq -1 set to_version=%old_to_version%

svn diff --summarize -r %from_version%:%to_version% > webdeploy_files.txt
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

echo;
echo The below files will be moved to 10.1.110.24 ^^!^^!
echo;
for /f "tokens=1,2 delims= " %%i in (webdeploy_files.txt) do (
	echo   %%j
)
echo;
set /p confirm_opt=Are you sure ? 
if %confirm_opt% neq yes goto inputno

for /f "tokens=1,2 delims= " %%i in (webdeploy_files.txt) do (
	echo;
	set full_name=%webproxy_root_path%\%%j

	rem check file type in (vm, js)
	call :getextension !full_name!
	if !file_suffix! equ .vm (set /a m=1) else set /a m=0
	if !file_suffix! equ .js (set /a n=1) else set /a n=0
	
	set /a x=m "|" n
	if !x! equ 1 (
		call :getpath !full_name!
		rem pscp -pw purang D:\purang\SVN\04source\webproxy\src\main\webapp\template\report\reportview.vm root@10.1.110.24:/opt/tomcat/webapps/ROOT/template/report/
		pscp -pw %dev_user_pwd% !full_name! %dev_user_id%@%dev_tomcat_server_ip%:%dev_tomcat_deploy_path%!file_path!
	) else (
		call :getname !full_name!
		echo !file_name! has been ignored.
	)
)

goto inputno

:getextension
set file_suffix=%~x1
goto :EOF

:getpath
set file_path=%~dp1
set file_path=!file_path:%webproxy_root_path%%webproxy_web_path%=!
set file_path=!file_path:\=/!
goto :EOF

:getname
set file_name=%~nx1
goto :EOF
