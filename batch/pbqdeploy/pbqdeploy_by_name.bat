echo off
setlocal enabledelayedexpansion

rem /**
rem  *
rem  * This script is used to deploy pbq in the local environment by entering the name.
rem  *
rem  */

set project_list=project.properties
set build_setup=build.properties
set project_name=""
set desc=Please Input Project Name : 

for /f "tokens=1,2 delims==" %%i in (%build_setup%) do (
	set %%i=%%j
)

:inputno
cd /d %~dp0
echo;
echo;

if %project_name% neq "" (
	set desc="Please Input Project Name (%project_name%) : "
) else (
	set desc="Please Input Project Name : "
)
set /p input_name=%desc%

if %input_name% equ "" if %project_name% neq "" goto pbqdeploy

for /d %%i in (%source_root_path%*) do (
	set filepath=%%i
	set "filepath=!filepath:%source_root_path%=!"
	if !input_name! equ !filepath! (
		set project_name=!input_name!
		goto pbqdeploy
	)
)

echo;
echo Wrong Project Name ^^!^^!
echo;
goto inputno

:pbqdeploy
set source_path=%source_root_path%%project_name%
set source_file=%source_root_path%%project_name%%source_pbq_folder%%project_name%%source_file_name_suffix%
set target_path=%target_root_path%%target_pbq_path%

cd /d %source_path%
call mvn install

move %source_file% %target_path%
rem del %source_file%

goto inputno

