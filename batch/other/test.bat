@echo off
rem set aa=abcde
rem echo aa = %aa%
rem set "aa=%aa:abc=xyz%"
rem echo aa = %aa%
rem ping 127.0.0.1 -n 6 > nul
rem set try_count=1
rem echo %try_count%
rem set/a try_count+=1
rem echo %try_count%

rem cd /d %~dp0

set /a f_vm=0
set /a f_js=0
set /a f_css=0
set /a f_png=0

set /a x=f_vm "|" f_js "|" f_css "|" f_png

echo %x%


pause