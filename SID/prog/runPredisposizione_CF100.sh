PASSWORD=""
args=("$@")
argstart=$(($OPTIND-1))
if [ "${args[$argstart]}" == "" ]; then
echo "Inserisci la password: "
read ipassword
if [ "$ipassword" == "" ]; then
echo "Occorre inserire la password"
exit 0
fi
PASSWORD=$ipassword
else
PASSWORD=${args[$argstart]}
fi


export JAVA_HOME="Inserire il percorso della jre"
export LIBPATH=../lib
export WORKDIR=../prog
export CFGBPATH=../prog/cfg

export CLASSPATH=$CLASSPATH:$WORKDIR.:../sid.jar

export CLASSPATH=$CLASSPATH:$LIBPATH/*

export CLASSPATH=$CLASSPATH:$CFGBPATH/servizio_CF100.properties

#echo $CLASSPATH

/usr/bin/java -cp $CLASSPATH it.sogei.telematici.sid.RunPredispozione CF100 $PASSWORD

