export JAVA_HOME=/Library/Internet Plug-Ins/JavaAppletPlugin.plugin/Contents/Home/bin
export JAVA_HOME="Inserire il percorso della jre"
export LIBPATH=../lib
export WORKDIR=../prog
export CFGBPATH=../prog/cfg

export CLASSPATH=$CLASSPATH:$WORKDIR.:../sid.jar

export CLASSPATH=$CLASSPATH:$LIBPATH/*

export CLASSPATH=$CLASSPATH:$CFGBPATH/servizio_ARU00.properties

export CLASSPATH=$CLASSPATH:$WORKDIR/


echo $CLASSPATH

/usr/bin/java -cp $CLASSPATH it.sogei.telematici.sid.RunRicevute ARU00

