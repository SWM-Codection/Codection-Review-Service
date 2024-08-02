@echo off

set DEST_DIR="%USERPROFILE%\.codection\test"

if not exist "%DEST_DIR%" (
    mkdir "%DEST_DIR%"
    git clone "https://github.com/SWM-Codection/Git-Test.git" "%DEST_DIR%"
)
