@echo off
set a="E:\Program Files\Image-Line\FL Studio 9\FL.exe"
set b="E:\Program Files\Image-Line\FL Studio 9\Plugins\VST\Revitar20\Effects\GuitarRig\GuitarRig-Revitar2Companion Bank.bnk"
call :getname %a%
rem call :getname %b%
echo %var%
pause
exit

:getname
set var=%~nx1