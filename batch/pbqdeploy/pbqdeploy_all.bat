@echo off
setlocal enabledelayedexpansion

rem /**
rem  *
rem  * This script is used to deploy all the pbqs in the local environment.
rem  * 
rem  * Please be noticed, it's not recommended to be used as it is likely to throw an exception.
rem  *
rem  */

set build_setup=build.properties

echo;
echo This batch will 'svn update' and 'mvn install' all the projects.
set /p confirm_opt=Are you sure ? 

if %confirm_opt% neq yes exit

for /f "tokens=1,2 delims==" %%i in (%build_setup%) do (
	set %%i=%%j
)
set target_path=%target_root_path%%target_pbq_path%
rem echo %target_path%

for /D %%i in (%source_root_path%*) do (
	call svn update %%i
	
	if %%i neq %source_root_path%pbq if %%i neq %source_root_path%webproxy if %%i neq %source_root_path%purang-storm (
		set source_path=%%i
		set source_file=%%i%source_pbq_folder%%file_name%
		
		cd /d !source_path!
		call mvn install
		move !source_file! !target_path!
	)
)

pause;