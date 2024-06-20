#!/bin/bash


export JAVA_HOME="/usr/lib/jvm/java-8-openjdk-amd64/jre/bin"
export LIBPATH=../lib
export WORKDIR=SID-GestioneFlussi/prog
export CFGBPATH=SID-GestioneFlussi/prog/cfg

export CLASSPATH=$CLASSPATH:$WORKDIR.:../sid.jar
export CLASSPATH=$CLASSPATH:$LIBPATH/*

export CLASSPATH=$CLASSPATH:$WORKDIR/


echo $CLASSPATH

/usr/bin/java -cp $CLASSPATH it.sogei.telematici.sid.SidView 

