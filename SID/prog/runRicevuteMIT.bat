echo off

set _LIBPATH=..\lib
set _CFGBPATH=..\prog\cfg

set _CLASSPATH=..\sid.jar

set _CLASSPATH=%_CLASSPATH%;%_LIBPATH%\*

set _CLASSPATH=%_CLASSPATH%;%_CFGBPATH%\servizio_%2.properties

echo _CLASSPATH=%_CLASSPATH%

%1 -ms30M -mx800M -cp %_CLASSPATH% it.sogei.telematici.sid.RunRicevute %2 %3