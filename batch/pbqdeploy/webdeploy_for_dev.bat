echo off
setlocal enabledelayedexpansion

rem /**
rem  *
rem  * This script is used to deploy webproxy files(vm & js) to the DEV(10.1.110.24) environment.
rem  * 
rem  * Please enter modified file list into modified_file_list.txt before you execute this script.
rem  *
rem  */

set build_setup=build.properties

for /f "tokens=1,2 delims==" %%i in (%build_setup%) do (
	set %%i=%%j
)

echo;
echo *************************************************************************
echo;
echo Please be noticed, this program will move vm ^& js to 10.1.110.24 ^^!^^!
echo;
echo *************************************************************************
:inputno
echo;
pause
echo;
echo Modified File List : 
echo;
for /f %%i in (modified_file_list.txt) do (
	echo   %%i
)
echo;
set /p confirm_opt=The above files will be moved. Are you sure ? 
if %confirm_opt% neq yes exit

for /f %%i in (modified_file_list.txt) do (
	echo;
	set full_name=%webproxy_root_path%\%%i
	set full_name=!full_name:/=\!
	call webdeploy_pscp.bat !full_name! %webproxy_root_path%
)

goto inputno
pause
