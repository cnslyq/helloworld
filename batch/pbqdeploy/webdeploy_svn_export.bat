rem /**
rem  *
rem  * This script is used to export the version file from svn.
rem  * 
rem  * Input parameter,
rem  * %1 target version
rem  *
rem  */

set to_version=%1
set current_path=%~dp0%tempdir%\
rem del /f /s /q %current_path%\%tempdir%
rd /q /s %current_path%

cd /d %webproxy_root_path%
rem export diff files
for /f "delims=" %%i in (%webdeploy_file_list%) do (
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
