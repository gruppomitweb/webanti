echo off

set _JAVA_PATH=inserire il path della JRE
set _LIBPATH=..\lib\
set _CFGBPATH=..\prog\cfg

set _CLASSPATH=..\sid.jar

set _CLASSPATH=%_CLASSPATH%;%_LIBPATH%\*

set _CLASSPATH=%_CLASSPATH%;%_CFGBPATH%\servizio_ARU00.properties

echo _CLASSPATH=%_CLASSPATH%

%_JAVA_PATH%\java -ms30M -mx800M -cp %_CLASSPATH% it.sogei.telematici.sid.RunRicevute ARU00


PAUSE