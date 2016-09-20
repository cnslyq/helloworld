echo off
setlocal enabledelayedexpansion
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
set /p confirm_opt=Are you sure ? 
if %confirm_opt% neq yes exit

for /f %%i in (modified_file_list.txt) do (
	echo;
	set full_name=%webproxy_root_path%\%%i
	set full_name=!full_name:/=\!
	rem check file type in (vm, js)
	call :getextension !full_name!
	if !file_suffix! equ .vm (set /a m=1) else set /a m=0
	if !file_suffix! equ .js (set /a n=1) else set /a n=0
	
	set /a x=m "|" n
	if !x! equ 1 (
		call :getpath !full_name!
		rem pscp -pw purang D:\purang\SVN\04source\webproxy\src\main\webapp\template\report\reportview.vm root@10.1.110.24:/opt/tomcat/webapps/ROOT/template/report/
		pscp -pw %dev_user_pwd% !full_name! %dev_user_id%@%dev_tomcat_server_ip%:%dev_tomcat_deploy_path%!file_path!
	) else (
		call :getname !full_name!
		echo !file_name! has been ignored.
	)
)

goto inputno
exit

:getextension
set file_suffix=%~x1
goto :EOF

:getpath
set file_path=%~dp1
set file_path=!file_path:%webproxy_root_path%%webproxy_web_path%=!
set file_path=!file_path:\=/!
goto :EOF

:getname
set file_name=%~nx1
goto :EOF
