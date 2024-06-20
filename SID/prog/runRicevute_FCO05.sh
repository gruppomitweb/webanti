PASSWORD=""
args=("$@")
argstart=$(($OPTIND-1))
if [ "${args[$argstart]}" == "" ]; then
        echo "Inserire la password dell'ambiente di sicurezza: "
        read ipassword
        if [ "$ipassword" == "" ]; then
         echo "La password è un dato obbligatorio"
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

export CLASSPATH=$CLASSPATH:$CFGBPATH/servizio_FCO05.properties

echo $CLASSPATH

/usr/bin/java -cp $CLASSPATH it.sogei.telematici.sid.RunRicevute FCO05 $PASSWORD
