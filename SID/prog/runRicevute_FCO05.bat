echo off
@ECHO OFF
REM - LABEL INDICATING THE BEGINNING OF THE DOCUMENT.
:BEGIN
CLS
SET PASS=%1

IF [%PASS%] == [] GOTO VOIDP

GOTO END
:VOIDP
SET /p PASS="Inserire la password dell'ambiente di sicurezza (in maiuscolo): " %=%
IF [%PASS%] == [] GOTO PASSVOID

GOTO END

:PASSVOID
ECHO "La password e' un dato obbligatorio"
GOTO VOIDP

:END

set _JAVA_PATH="Inserire il path della JRE"
set _LIBPATH=..\lib\
set _CFGBPATH=..\prog\cfg

set _CLASSPATH=..\sid.jar

set _CLASSPATH=%_CLASSPATH%;%_LIBPATH%\*

set _CLASSPATH=%_CLASSPATH%;%_CFGBPATH%\servizio_FCO05.properties

echo _CLASSPATH=%_CLASSPATH%

%_JAVA_PATH%\java -ms30M -mx800M -cp %_CLASSPATH% it.sogei.telematici.sid.RunRicevute FCO05 %PASS%


PAUSE
