@echo off
echo ## EXE File Execution [%date% %time%]

cd D:
if %errorlevel% == 0 (echo Result: Succeeded!!!) else (echo Result: Failed!!! )
echo Return Code is :%errorlevel%

echo.
echo.

cd D:\test
if %errorlevel% == 0 (echo Result: Succeeded!!!) else (echo Result: Failed!!! )
echo Return Code is :%errorlevel%

pause;