echo off

set _JAVA_PATH=%1
set _LIBPATH=..\lib
set _CFGBPATH=..\prog\cfg

set _CLASSPATH=..\sid.jar

set _CLASSPATH=%_CLASSPATH%;%_LIBPATH%\*
set _CLASSPATH=%_CLASSPATH%;%_CFGBPATH%\servizio_%2.properties

%1\bin\java -ms30M -mx800M -cp %_CLASSPATH% it.sogei.telematici.sid.RunPredisposizione %2  %3