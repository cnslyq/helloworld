echo off
setlocal enabledelayedexpansion

rem /**
rem  *
rem  * This script is used to download logs from dev servers(10.1.110.21, 22, 24).
rem  *
rem  */

set build_setup=build.properties
for /f "tokens=1,2 delims==" %%i in (%build_setup%) do (
	set %%i=%%j
)

rd /q /s %~dp0%locate_log_path%

rem download pbq log
echo Downloading pbq log from !%env%_pbq_server_ip! ...
call :download pbq
echo;

rem download tomcat log
echo Downloading tomcat log from !%env%_tomcat_server_ip! ...
call :download tomcat
echo;

rem download storm log
for /l %%i in (1, 1, 5) do (
	if defined %env%_storm_server_ip_%%i (
		echo Downloading storm log from !%env%_storm_server_ip_%%i! ...
		call :download storm %%i
		echo;
	)
)

pause
goto :EOF

:download
set type=%1
set idx=%2
if defined idx (
	set locate_path=%~dp0%locate_log_path%\!%env%_%type%_server_ip_%idx%!
) else (
	set locate_path=%~dp0%locate_log_path%\!%env%_%type%_server_ip!
)
if not exist %locate_path% mkdir %locate_path%

rem pscp -pw !%env%_pbq_user_pwd! !%env%_pbq_user_id!@!%env%_pbq_server_ip!:!%env%_pbq_log! %~dp0/logs
if defined idx (
	for /f "delims=" %%i in ('plink -pw !%env%_%type%_user_pwd_%idx%! !%env%_%type%_user_id_%idx%!@!%env%_%type%_server_ip_%idx%! "find !%env%_%type%_log_path! -name !%env%_%type%_log_file! -type f -mmin %last_modified_min%"') do (
		pscp -pw !%env%_%type%_user_pwd_%idx%! !%env%_%type%_user_id_%idx%!@!%env%_%type%_server_ip_%idx%!:%%i %locate_path%
	)
) else (
	pscp -pw !%env%_%type%_user_pwd! !%env%_%type%_user_id!@!%env%_%type%_server_ip!:!%env%_%type%_log_path!!%env%_%type%_log_file! %locate_path%
)
goto :EOF
