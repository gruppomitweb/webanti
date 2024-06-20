#!/bin/bash
export JAVA_HOME=$1
export LIBPATH=../lib
export WORKDIR=../prog
export CFGBPATH=../prog/cfg
export CLASSPATH=$CLASSPATH:$WORKDIR.:../sid.jar
export CLASSPATH=$CLASSPATH:$LIBPATH/*
export CLASSPATH=$CLASSPATH:$CFGBPATH/servizio_$2.properties
export CLASSPATH=$CLASSPATH:$WORKDIR/

$1 -cp $CLASSPATH it.sogei.telematici.sid.RunPredisposizione $2 $3