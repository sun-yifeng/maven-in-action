@echo off
rem create by sunyf https://blog.csdn.net/u011990675/article/details/80066897
  
rem 这里写你的仓库路径
set REPOSITORY_PATH=C:\Users\sunyifeng\.m2\repository
rem 正在搜索...
for /f "delims=" %%i in ('dir /b /s "%REPOSITORY_PATH%\*lastUpdated*"') do (
    echo %%i
    del /s /q "%%i"
)
rem 搜索完毕
pause