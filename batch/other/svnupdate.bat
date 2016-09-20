@echo off
setlocal enabledelayedexpansion
set build_setup=build.properties

for /f "tokens=1,2 delims==" %%i in (%build_setup%) do (
	set %%i=%%j
)

d:
for /D %%i in (%source_root_path%*) do (
	call svn update %%i
)

pause;