echo off
setlocal enabledelayedexpansion
set project_list=project.properties
set build_setup=build.properties
set project_name=""
set desc=Please Input Project No : 

for /f "tokens=1,2 delims==" %%i in (%build_setup%) do (
	set %%i=%%j
)

:inputno
set project_no=""
cd /d %~dp0
echo;
echo;
echo Project List :
for /f "tokens=1,2 delims==" %%i in (%project_list%) do (
	set %%i=%%j
	echo   No : %%j    Name : %%i
)
echo;

if %project_name% neq "" (
	set desc="Please Input Project No (%project_oldno%) : "
) else (
	set desc="Please Input Project No : "
)
set /p project_no=%desc%

if %project_no% equ 0 exit

if %project_no% equ "" if %project_name% neq "" goto pbqdeploy

for /f "tokens=1,2 delims==" %%i in (%project_list%) do (
	set %%i=%%j
	if %project_no% equ %%j (
		set project_name=%%i
		set project_oldno=%project_no%
		goto pbqdeploy
	)
)

set project_no=%project_oldno%
echo;
echo Wrong Project No ^^!^^!
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

