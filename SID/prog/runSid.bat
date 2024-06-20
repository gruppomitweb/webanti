@ECHO OFF
REM - LABEL INDICATING THE BEGINNING OF THE DOCUMENT.

CLS


rem echo off

set _JAVA_PATH="Inserire il percorso della jre"
rem set _LIBPATH=.\lib
rem set _CFGBPATH=.\cfg
set _LIBPATH=..\lib
set _CFGBPATH=..\prog\cfg

set _CLASSPATH=..\sid.jar

set _CLASSPATH=%_CLASSPATH%;%_LIBPATH%\*


%_JAVA_PATH%\java -ms30M -mx800M -cp %_CLASSPATH%  it.sogei.telematici.sid.SidView

PAUSE
