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
set try_count=0
set project_no=""
cd /d %~dp0
echo;
echo *************************************************************************
echo;
echo Please be noticed, this program will deploy pbq to 10.1.110.22 ^^!^^!
echo;
echo *************************************************************************
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

cd /d %source_path%
call mvn install

rem pscp D:\purang\SVN\04source\pbq-eba-apply\target\pbq-eba-apply_0.0.1.v20160831-1049-release.tar.gz root@10.1.110.22:/opt/pbq/deploy
pscp -pw %dev_user_pwd% %source_file% %dev_user_id%@%dev_server_ip%:%dev_deploy_path%
del %source_file%

:checkexist
for /f "delims=" %%i in ('plink -pw %dev_user_pwd% %dev_user_id%@%dev_server_ip% "ls %dev_deploy_path% -1|wc -l"') do (set pbqnumber=%%i)
if %pbqnumber% equ 0 (
	echo;
	echo The pbq has been deployed successfully ^^!
	echo;
	goto inputno
) else (
	if %try_count% equ 5 (
		echo;
		echo The pbq has been moved to 10.1.110.22 but not been deployed. Please check on the server directly ^^!
		echo;
		goto inputno
	) else (
		echo;
		echo The pbq has not been deployed. Please wait ...
		set/a try_count+=1
		ping 127.0.0.1 -n 6 > nul
		goto checkexist
	)
)




