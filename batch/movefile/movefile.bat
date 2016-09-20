echo off
setlocal enabledelayedexpansion

set file_list=file_list.txt
set source_path=D:\purang\SVN\08Branch\160705_store\
set target_path=D:\purang\SVN\04source\

set j=0
for /f "delims=""" %%i in (%file_list%) do (
	set /a j+=1
	set con!j!=%%i
	call set file_name=%%con!j!%%
	call set source_file=!source_path!!file_name!
	call set target_file=!target_path!!file_name!
	rem echo !source_file!
	rem echo !target_file!
	rem copy file_list.txt !target_path!
	copy !source_file! !target_file!
)

pause
