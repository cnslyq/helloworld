echo off
setlocal enabledelayedexpansion
set build_setup=build.properties

for /f "tokens=1,2 delims==" %%i in (%build_setup%) do (
	set %%i=%%j
)

rem plink -pw %dev_user_pwd% %dev_user_id%@%dev_tomcat_server_ip% "mkdir %dev_tomcat_deploy_path%/template/report/test"
rem for /f "delims=" %%i in ('plink -pw %dev_user_pwd% %dev_user_id%@%dev_server_ip% "ls %dev_deploy_path%/test;echo $?"') do (set pbqnumber=%%i)
rem echo %pbqnumber%

set current_path=%~dp0%tempdir%
rem del /f /s /q %current_path%%tempdir%
rd /q /s %current_path%

cd /d %webproxy_root_path%

set from_version=57684
set to_version=57795

rem export diff files
for /f "delims=" %%i in (webdeploy_files.txt) do (
    call :export %%i
)
goto :EOF

:export
set fullpath=%svn_url%%2
set "fullpath=%fullpath:\=/%"
set filename=%~nx2
set filepath=%2
set "filepath=!filepath:%filename%=!"
if not exist %current_path%%filepath% mkdir %current_path%%filepath%
svn export -r %to_version% %fullpath% %current_path%%filepath%%filename%
goto :EOF
