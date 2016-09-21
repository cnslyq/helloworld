rem /**
rem  *
rem  * This script is used to deploy files to DEV(10.1.110.24).
rem  * 
rem  * Input parameters,
rem  * %1 full name, e.g. D:\purang\SVN\04source\webproxy\src\main\webapp\template\report\eba_new\Eba_DayCheck_BillManage_BaoLi.vm
rem  * %2 root path, e.g. D:\purang\SVN\04source\webproxy
rem  *
rem  */

set full_name=%1
set source_path=%2
rem check file type in (vm, js)
call :getextension %full_name%
if %file_suffix% equ .vm (set /a m=1) else set /a m=0
if %file_suffix% equ .js (set /a n=1) else set /a n=0

set /a x=m "|" n
if %x% equ 1 (
	call :getpath %full_name%
	rem check path exists
	for /f "delims=" %%i in ('plink -pw %dev_user_pwd% %dev_user_id%@%dev_tomcat_server_ip% "ls %dev_tomcat_deploy_path%!file_path!;echo $?"') do (set pbqnumber=%%i)
	if !pbqnumber! equ 2 (
		plink -pw %dev_user_pwd% %dev_user_id%@%dev_tomcat_server_ip% "mkdir %dev_tomcat_deploy_path%!file_path!"
	)
	rem pscp -pw purang D:\purang\SVN\04source\webproxy\src\main\webapp\template\report\reportview.vm root@10.1.110.24:/opt/tomcat/webapps/ROOT/template/report/
	pscp -pw %dev_user_pwd% %full_name% %dev_user_id%@%dev_tomcat_server_ip%:%dev_tomcat_deploy_path%!file_path!
) else (
	call :getname %full_name%
	echo !file_name! has been ignored.
)
goto :EOF

:getextension
set file_suffix=%~x1
if not defined file_suffix (
    set file_suffix=""
)
goto :EOF

:getpath
set file_path=%~dp1
set file_path=!file_path:%source_path%%webproxy_web_path%=!
set file_path=!file_path:\=/!
goto :EOF

:getname
set file_name=%~nx1
goto :EOF
