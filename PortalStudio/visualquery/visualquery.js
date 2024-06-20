/* exported
    currentTableIndex showAll vdmObj curtbl

    openQueryFile openUnionQuery OpenCorrespondingQry callResizeFunction inputs_setOnFocus
    SortTableList SortFieldList GetFunctionsForExpBuilder getFieldsOfTables GetFunctionsForExpBuilder
    GetVariablesForExpBuilder getParametersOfQueries EditQuery loadValue DoOperation AddListQuery
    AddTempTable SelectConfigurationFileName AddBOTable AddBO DoLoad RemoteServer_change
    RefreshRemoteParameters Help FocusAliasTable SetTableValues DeleteTable AddBlankField AddBlankCalculatedField changeCustom
    SetFieldCombo AddBlankJoin AddBlankFilter FilterExampleAction AddBlankParameter SetNameParamValue
    FocusNameParam DeleteParam SetParamCombo ExpressionBuilderReturn GetExpressionFromId getOfflineModule
    closePreview Find setFading compareQuery AddStoredProcedure HelpQuery
 */


// This array holds all table data            |
// index      field info                      |
//   0        table name                      |
//   1        table desc                      |
//   2        array of all fields             |
//      |~>                                   |
//         0       field name                 |
//         1       field description          |
//         2       field type                 |
//         3       field len                  |
//         4       field dec                  |
//         5       index (0 se non ? indice)  |
//         6       privacy                    |
//         7       identifier                 |
//   3        array of all relation           |
//         0       Description                |
//         1       Linked Field               |
//         2       Linked Table               |
//         3       Linked Table Field         |
//         4       Join Type                  |
//         5       Relation Type              |
//   4        table physical name             |
var allTables=new Array();
var currentTableIndex=-1;
var currentFieldId='';
var currentParmId='';
var timeout;
var vqr_regexp = new RegExp("(.+)\\.VQR(\\?(.*))?",'i')
var vqr_regexp_without_vqr = new RegExp("([^?]+)(\\?(.*))?",'i')
// This array holds tables selected for query |
// index      field info                      |
//   0        table index in allTables        |
//   1        table name                      |
//   2        table desc                      |
//   3        table alias                     |
//   4        table internal id               |
//   5        temp table option               |
//var tables=new Array();

// This array takes orderby field indexes     |
//  **** GENERATED WHILE DRAWING ONLY  ****   |
// index      field info                      |
//   0        index in selectedFields         |
//   1        order to sort (asc/desc)        |
//var orderby=new Array();

// This array takes orderby field indexes     |
//  **** GENERATED WHILE DRAWING ONLY  ****   |
// index      field info                      |
//   0        index in selectedfields         |
//var groupby=new Array();

// This array holds selected fields as: |
//   0       table index in tables (old)|
//   1       field name                 |
//   2       field description          |
//   3       field type                 |
//   4       field len                  |
//   5       field dec                  |
//   6       field alias                |
//   7       orderby position           |
//   8       orderby order(0=asc,1=desc)|
//   9       groupby position           |
//var selectedFields=new Array();

// Array to hold join variables         |
//   0    Description                   |
//   1    Expression                    |
//   2    Type                          |
//   3    Table 1                       |
//   4    Table 2                       |
//   5    Table Idx                     |
//   6    Relation Idx                  |
//var join=new Array();

// Array to hold filter variables       |
//   0    Field name                    |
//   1    Not                           |
//   2    Operation                     |
//   3    Const                         |
//   4    Logic operation               |
//   5    Having                        |
//var filter=new Array();

// Array to hold parameter variables    |
//   0    Field name                    |
//   1    Description                   |
//   2    Type                          |
//   3    Length                        |
//   4    Decimal length                |
//   5    Remove on empty               |
//   6    Default on Empty              |
//   7    Keep spaces
//var parameter=new Array();

var iid=-1;            //Starts 0 for first table and increases
//var currentTable=-1;   //L'indice della tabelle selezionata nella sezione TABLES
//var currentField=-1;   //L'indice del campo selezionato nella sezione FIELDS
//var currentJoin=-1;    //L'indice della relazione selezionata nella sezione JOIN
//var currentFilter=-1;  //L'indice del filtro selezionato nella sezione FILTERS
//var currentParam=-1;   //L'indice del parametro selezionato nella sezione PARAMETERS
var m_bUpdated=false;  //Lo stato della query: modificato o meno
var m_cFilename=null;
var m_cQueryToCompare=null;
var m_nFileVersion=null;
var m_nFrontendPort=null;
var m_bOfflineMode=false;
var addingRelations=false;
var closeAfterSave=false;
var dictionaryopen=true;
var previewOpen=false;

//var allVqrFiles = "";
var tempFilename="";        //Il nome del file selezionato
var tempRemote_server="";   //Il nome del server da cui leggere la query da importare
var tempRemote_user="";     //Il nome dell'utente con cui loggarsi sul server remoto
var tempRemote_password=""; //La password per loggarsi sul server remoto
var tempRemote_company="";  //la company da usare sul server remoto
var tempRemote_instance=""; //L'istanza su cui loggarsi sul server remotot
var tempRemote_mode="";     //Il modo di serializzazione della query
var fileDialogOperation=""; //L'oprazione da eseguire dopo la selezione di un file
var sqlOperation, showAll, parametersValue={}, vdmObj;

//variabili per la funzione di ricerca
var lastFoundTableIdx=-1,lastFoundFieldIdx=-1;
var tableDesc="",tableName="",fieldDesc="",fieldName="";

var CSV_SEP="#!$";

var exampleInput;
var sort_all;
var TabPanel;
var TabPanelGroupPivot;
var o_dictTables, o_dictFields, o_dictRelations;
var fieldsOf="",lastTableAlias="";
var changedCustom=false;
var sitepainterSqlFunctions=[
                    ["30DAYSBEFORE","(varname)","Restituisce la data di 30 giorni prima rispetto a oggi o, se specificato, della data contenuta della variabile globale con nome <b>varname</b>."],
                    ["30DAYSAFTER","(varname)","Restituisce la data di 30 giorni dopo rispetto a oggi o, se specificato, della data contenuta della variabile globale con nome <b>varname</b>."],
                    ["60DAYSBEFORE","(varname)","Restituisce la data di 60 giorni prima rispetto a oggi o, se specificato, della data contenuta della variabile globale con nome <b>varname</b>."],
                    ["60DAYSAFTER","(varname)","Restituisce la data di 60 giorni dopo rispetto a oggi o, se specificato, della data contenuta della variabile globale con nome <b>varname</b>."],
                    ["90DAYSBEFORE","(varname)","Restituisce la data di 90 giorni prima rispetto a oggi o, se specificato, della data contenuta della variabile globale con nome <b>varname</b>."],
                    ["90DAYSAFTER","(varname)","Restituisce la data di 90 giorni dopo rispetto a oggi o, se specificato, della data contenuta della variabile globale con nome <b>varname</b>."],
                    ["AT","(what,string)","Restituisce la posizione della stringa <b>what</b> nella stringa <b>string</b>."],
                    ["CASE","(exp, when, then, ..., else)","Corrisponde al costrutto:<br>CASE<br>&nbsp;WHEN <b>exp</b>=<b>when</b> THEN <b>then</b><br>&nbsp;...<br>&nbsp;ELSE <b>else</b>"],
                    ["CASE2","(exp, then, exp, then, ..., else)","Corrisponde al costrutto:<br>CASE<br>&nbsp;WHEN (<b>exp</b>) THEN <b>then</b><br>&nbsp;WHEN (<b>exp</b>) THEN <b>then</b><br>&nbsp;...<br>&nbsp;ELSE <b>else</b>"],
                    ["CASTTOCHAR","(exp, length)","Effettua il cast a tipo CHAR del valore <b>exp</b>. Se non specificato la lunghezza di default \xe8 20.<br>Nel caso in cui la lunghezza sia minore di quella effettiva il database potrebbe generare un errore di conversione."],
                    ["CASTTOVARCHAR","(exp, length)","Effettua il cast a tipo VARCHAR del valore <b>exp</b>. Se non specificato la lunghezza di default \xe8 20.<br>Nel caso in cui la lunghezza sia minore di quella effettiva il database potrebbe generare un errore di conversione."],
                    ["CEIL","(numeric)","Restituisce il pi\xf9 piccolo intero maggiore o uguale del numero indicato."],
                    ["CHR","(numeric)","Ritorna il carattere corrispondente al valore specificato secondo la codifica ASCII."],
                    ["COMPANYCODE","()","Restituisce il codice dell'azienda (carattere di 10)."],
                    ["COMMUNICATIONGROUPS","()","Restituisce una stringa con l'elenco dei codici dei gruppi di comunicazione, separato da virgola, a cui appartiene l'utente loggato."],
                    ["CONCAT","","Concatena due stringhe o campi che siano comunque di tipo carattere. La funzione deve essere scritta nella seguente forma:<br><b>exp1</b>[CONCAT()]<b>exp2</b>"],
                    ["CURRENTDATE","()","Restituisce la data corrente."],
                    ["CURRENTDATETIME","()","Restituisce la data e ora corrente."],
                    ["DATE","('YYYY-MM-DD')","Converte il parametro in una costante data; il parametro deve essere una stringa racchiusa tra apici singoli della seguente forma:<br><b>cExp</b> = 'YYYY-MM-DD' o 'DD-MM-YYYY'.<br>I segni (-) possono eventualmente sostituiti dal segno (/).<br>Nel caso in cui il parametro sia una espressione calcolata il risultato deve essere nella forma 'YYYY-MM-DD'."],
                    ["DATEADD","(datepart,numeric,date)","Restituisce la somma della data specificata in <b>date</b> con l'intervallo specificato in <b>numeric</b>. La parte che si intende sommare deve essere specificata con il parametro <b>datepart</b>.<br>Il parametro <b>datepart</b> riconosce i seguenti parametri: second, minute, hour, day, week, month, year."],
                    ["DATETIME","('YYYY-MM-DD hh:mm:ss')","Converte il parametro in una costante timestamp; il parametro deve essere una stringa racchiusa tra apici singoli della seguente forma:<br><b>cExp</b> = 'YYYY-MM-DD hh:mm:ss' o 'DD-MM-YYYY hh:mm:ss'.<br>I segni (-) possono eventualmente sostituiti dal segno (/).<br>Nel caso in cui il parametro sia una espressione calcolata il risultato deve essere nella forma 'YYYY-MM-DD hh:mm:ss'."],
                    ["DAY","(date)","Restituisce il valore numerico del giorno espresso in <b>date</b>."],
                    ["DAYOFWEEK","(date,weekdaystart)","Restituisce il valore numerico del giorno della settimana (1=Luned\xec,...7=Domenica) espresso in <b>date</b>.Se si vuole far partire la settimana da un giorno diverso si imposta il valore di <b>weekdaystart</b> con 2=Martedi',3=Mercoledi',..."],
                    ["DIFFDAY","(date,date)","Restituisce il numero di giorni di differenza tra le 2 <b>date</b> passate come parametri."],
                    ["DTOC","(date)","Trasforma un campo Date <b>date</b> in una stringa con formato DD-MM-YYYY"],
                    ["FIRSTDAYCURRENTYEAR","()","Restituisce la data del primo giorno dell'anno della data corrente."],
                    ["FIRSTDAYNEXTYEAR","()","Restituisce la data del primo giorno dell'anno successivo rispetto alla data corrente."],
                    ["FIRSTDAYPREVYEAR","()","Restituisce la data del primo giorno dell'anno precedente rispetto alla data corrente."],
                    ["FIRSTDAYCURRENTMONTH","()","Restituisce la data del primo giorno del mese della data corrente."],
                    ["FIRSTDAYNEXTMONTH","()","Restituisce la data del primo giorno del mese successivo alla data corrente."],
                    ["FIRSTDAYPREVMONTH","()","Restituisce la data del primo giorno del mese precedente alla data corrente."],
                    ["FIRSTDAYYEAROF","(varname)","Restituisce la data del primo giorno dell'anno della data contenuta nella globale con nome <b>varname</b> o nel parametro di query ?<b>varname</b>."],
                    ["FIRSTDAYNEXTYEAROF","(varname)","Restituisce la data del primo giorno dell'anno successivo rispetto alla data contenuta nella globale con nome <b>varname</b> o nel parametro di query ?<b>varname</b>."],
                    ["FIRSTDAYPREVYEAROF","(varname)","Restituisce la data del primo giorno dell'anno precedente rispetto alla data contenuta nella globale con nome <b>varname</b> o nel parametro di query ?<b>varname</b>."],
                    ["FIRSTDAYMONTHOF","(varname)","Restituisce la data del primo giorno del mese della data contenuta nella globale con nome <b>varname</b> o nel parametro di query ?<b>varname</b>."],
                    ["FIRSTDAYNEXTMONTHOF","(varname)","Restituisce la data del primo giorno del mese successivo alla data contenuta nella globale con nome <b>varname</b> o nel parametro di query ?<b>varname</b>."],
                    ["FIRSTDAYPREVMONTHOF","(varname)","Restituisce la data del primo giorno del mese precedente alla data contenuta nella globale con nome <b>varname</b> o nel parametro di query ?<b>varname</b>."],
                    ["FLOOR","(numeric)","Restituisce il pi\xf9 grande intero minore o uguale del numero indicato."],
                    ["FUEXTCATEGORY","(urlmodel,webpath,language,pagealias,categoryid,categoryalias,pathalias,parameters)","Crea un link ad una categoria nel modello di navigazione indicato in <b>urlmodel</b>."],
                    ["FUEXTCONTENT","(urlmodel,webpath,language,pagealias,categoryid,categoryalias,contentid,contentalias,pathalias,parameters)","Crea un link ad un contenuto o articolo nel modello di navigazione indicato in <b>urlmodel</b>."],
                    ["FUEXTPAGE","(urlmodel,webpath,language,pagealias,pathalias,parameters)","Crea un link ad una pagina nel modello di navigazione indicato in <b>urlmodel</b>."],
                    ["GLOBALMACRO","(varname)","Effettua la macro sostituzione del valore della variabile globale <b>varname</b>."],
                    ["GLOBALVAR","(varname)","Restituisce il valore della variabile globale <b>varname</b>."],
                    ["IIF","(exp, then, exp, then, ..., else)","Corrisponde al costrutto:<br>CASE<br>&nbsp;WHEN (<b>exp</b>) THEN <b>then</b><br>&nbsp;WHEN (<b>exp</b>) THEN <b>then</b><br>&nbsp;...<br>&nbsp;ELSE <b>else</b>"],
                    ["J","(json_field,attribute)","Ritorna il valore dell'attributo <b>attribute</b> letto dal campo <b>json_field</b>."],
                    ["JSON","(key,value,key,value..)","Restituisce un oggetto JSON composto dalle coppie <b>key</b> : <b>value</b>"],
                    ["LEFT","(char,numeric)","Estrae da <b>char</b> un numero <b>numeric</b> di caratteri a partire dall'inizio della stringa."],
                    ["LEN","(any)","Ritorna la lunghezza di <b>any</b>."],
                    ["LTRIM","(char)","Elimina gli spazi iniziali da <b>char</b>."],
                    ["LOWER","(str)","Rende la stringa <b>str</b> minuscola."],
                    ["MACRO","(any)","Effettua la macro sostituzione del parametro <b>any</b> nel punto dove viene inserita."],
                    ["MACROROUTINE","(routineName,parameters)","Ritorna il risultato della routine <b>routineName</b>. <br /> La routine deve essere di tipo funzione e deve ritornare una stringa."],
                    ["UNSAFEMACRO","(any)","Effettua la macro sostituzione del parametro <b>any</b> nel punto dove viene inserita.<br />Utilizzando questo metodo non vengono effettuati controlli di sicurezza, se utilizzato ci si apre ad eventuali vulnerabilit\xe0 per possibili attacchi all'applicativo."],
                    ["MONTH","(date)","Restituisce il valore numerico del mese espresso in <b>date</b>."],
                    ["NOTEMPTYSTR","(char)","Verifica se <b>char</b> \xe8 una stringa vuota."],
                    ["NOTEMPTYNUM","(numeric)","Verifica se <b>numeric</b> \xe8 nullo."],
                    ["NOTEMPTYDATE","(date)","Verifica se <b>date</b> \xe8 una data vuota."],
                    ["NVL","(any,any)","Restituisce il primo argomento non NULL (da sinistra a destra); ammette solo due argomenti."],
                    ["PARAM2IN","(?param)","Effettua la macro sostituzione del parametro <b>param</b> controllando che il valore sia valido per una lista di valori per l'operatore IN.<br>param pu\xf2 assumere due tipologie di valori:<ul><li>una lista di valori. In tal caso, la chiamata alla funzione PARAM2IN <b>dovr\xe0</b> essere contenuta all'interno di parentesi tonde. Per esempio: ([PARAM2IN(?param)]);</li><li>il nome di una query. In tal caso, non sono necessarie le parentesi tonde esterne.</li></ul>"],
                    ["PARAM2TBL","(?param, admittedList ... )","Effettua la macro sostituzione del parametro <b>param</b> controllando che il valore sia valido per un nome di tabella. E' possibile aggiungere una lista (separata da virgola) di elementi ammissibili per il valore passato, e' possibile inserire come elemento ammesso anche una espressione regolare che deve essere inserita tra slash (es. /PREFISSOTABELLA.*/"],
                    ["RANDOM","()","Restituisce un numero casuale."],
                    ["REPLACE","(string,string,string,numeric)","Sostituisce nel primo parametro tutte le occorrenze del secondo parametro con il terzo parametro.<br />Se viene specificato il quarto parametro la stringa viene tagliata in modo automatico alla lunghezza specificata. <br /> <b>Attenzione:</b> alcuni database trasformano il risultato della REPLACE in un varchar/text di massima lunghezza causando rallentamenti in caso di operazioni che coinvolgono tabelle temporanee. Si consiglia quindi di specificare la lunghezza desiderata."],
                    ["RIGHT","(char,numeric)","Estrae da <b>char</b> un numero <b>numeric</b> di caratteri a partire dalla fine della stringa."],
                    ["ROUND","(numeric,numeric)","Esegue l'approssimazione di un numero per x cifre decimali."],
                    ["RTRIM","(char)","Elimina gli spazi finali da <b>char</b>."],
                    ["SPACE0","()","Restituisce una costante stringa vuota indipendentemente dal database."],
                    ["SPACES","(numeric)","Restituisce una stringa di <b>numeric</b> spazi."],
                    ["STOREDPROCEDURE","(function_name,param1,param2)","Richiama la funzione <b>function_name</b> passando i parametri specificati."],
                    ["STR","(numeric)","Converte <b>numeric</b> in stringa."],
                    // ["STUFF","(string,start,length,replaceWith_string)","Inserisce una stringa in una altra elimando un numero di caratteri specificato nella posizione inziale della prima stringa e inserendo la seconda in tale posizione."],
                    ["SUBSTR","(string,numeric1,numeric2)","Estrae da <b>string</b> un numero <b>numeric2</b> di caratteri a partire dall'<b>numeric1</b>-esimo; se <b>numeric2</b> viene omesso, vengono estratti tutti i caratteri dall'<b>numeric1</b>-esimo alla fine (destra) di string."],
                    ["T","(fieldname)","Nel caso siano presenti dei campi multilingua, seleziona il campo <b>fieldname</b> nella lingua dell'utente corrente, se il campo \xe8 vuoto restituisce il campo base."],
                    ["T2","(fieldname)","Nel caso siano presenti dei campi multilingua, seleziona il campo <b>fieldname</b> nella lingua dell'utente corrente."],
                    ["T!","(fieldname,fieldlanguage)","Nel caso siano presenti dei campi multilingua, seleziona il campo <b>fieldname</b> nella lingua specificata in <b>fieldlanguage</b>."],
                    ["TRANSLATE","(string)","Traduce <b>string</b>, applicando la traduzione impostata per il valore passato come parametro nel Translation Manager di SITEPAINTER."],
                    ["TRIM","(char)","Elimina gli spazi iniziali e finali da <b>char</b>."],
                    ["TTOC","(date)","Trasforma un campo DateTime <b>date</b> in una stringa con formato DD-MM-YYYY hh:mm:ss"],
                    ["UPPER","(str)","Rende la stringa <b>str</b> maiuscola."],
                    ["USERCODE","()","Restituisce il codice utente (numerico di 4)."],
                    ["USERGROUPS","()","Restituisce una stringa con l'elenco dei codici dei gruppi, separato da virgola, a cui appartiene l'utente loggato.<br>Se l'utente non ha gruppi associati oppure non \xe8 loggato, la funzione restituisce la stringa \"-1\" (gruppo non valido)."],
                    ["USERROLES","()","Restituisce una stringa con l'elenco delle descrizioni dei ruoli, separato da virgola, assegnati all'utente loggato.<br>Se l'utente non ha ruoli assegnati oppure non \xe8 loggato, la funzione restituisce la stringa vuota \"\" (ruolo non valido)."],
                    ["VAL","(char)","Ritorna il valore numerico di <b>char</b> come float."],
                    ["WEEK","(date)","Ritorna il numero della settimana dell'anno della data specificata."],
                    ["X","(xml_field,attribute)","Ritorna il valore dell'attributo <b>attribute</b> letto dal campo <b>xml_field</b>."],
                    ["XM","(xml_field,attribute)","Ritorna il valori multipli dell'attributo <b>attribute</b> letto dal campo <b>xml_field</b>."],
                    ["XP","(xml_field,path)","Ritorna il valore dell'attributo dal percorso XML <b>path</b> letto dal campo <b>xml_field</b>."],
                    ["YEAR","(date)","Restituisce il valore numerico dell'anno espresso in <b>date</b>."],
                    ["ZEROFILL","(num,string)","Il valore <b>string</b> viene riempito a sinistra con degli 0 per arrivare alla lunghezza di <b>num (default 10)</b>."]
                   ];
var aggregateSqlFunctions=[
                    ["AVG","(expression)","Restituisce la media dei valori presenti nel campo passato."],
                    ["COUNT","(expression)","Restituisce il numero di record presenti."],
                    ["JSON_AGG","(key,value,key,value..)","Crea un array di oggetti."],
                    ["MAX","(expression)","Restituisce il valore massimo tra i presenti."],
                    ["MIN","(expression)","Restituisce il valore minimo tra i presenti."],
                    ["SUM","(expression)","Restituisce la somma di tutti i valori presenti"],
                    ["STRING_AGG","(expression, separator [order_by_clause])","Concatena una lista di stringhe separandole con la stringa specificata. La lista viene ordinata in base all'ordinamento espresso."]
                   ];
var variablesSync=[
                    ["p_CPSyncTimestamp","","p_CPSyncTimestamp : Synchronization parameter - T(14,0)<br>Consente di recuperare le tuple per cui il valore di modifica cpupdtms ? maggiore o uguale al valore del parametro p_CPSyncTimestamp passato.<br><i>Es: <nometabella>.cpupdtms>=?p_CPSyncTimestamp<\i>"]
                   ];

var randomKey=LibJavascript.AlfaKeyGen(10); // chiave casuale utilizzata per il nome da dare alle pagine sql.jsp

var toolbars={}
var unionQuery='';
var lastTableSelected=null;
function GetFunctionsForExpBuilder(){
  //[{name:"sitepainterSqlFunctions",desc:"SitePAINTER SQL Functions",prefix:"[",postfix:"()]",functions:[["nome","parametri","descrizione lunga"],["nome2","parametri2","descrizione lunga"]]}]
  var functions=[];
  functions.push({name:"sitepainterSqlFunctions",desc:"SitePAINTER SQL Functions",prefix:"[",postfix:"()]",functions:sitepainterSqlFunctions});
  functions.push({name:"aggregateSqlFunctions",desc:"Aggregate SQL Functions",prefix:"[",postfix:"()]",functions:aggregateSqlFunctions});
  return functions;
}
function getFieldsOfTables(){
  //[{name:"tabella",desc:"tabellina",prefix:"tabella.",postfix:"",fields:[["nome","descrizione","tipo(lunghezza,decimali)"],["nome2","descrizione2","tipo2(lunghezza2,decimali2)"]]}}]
  var fieldsOfTable=[];

  //richiede al server i campi delle tabelle coinvonte nella query
  $$('#tables_ul li').each(function (el) {
    var tblIdx = el.get("idxTable")
    if (tblIdx!=-1){
      FetchData(tblIdx);
      var tblName = el.getElement("input[name=alias]").get('value');
      var curTable = {name:tblName,desc:el.getElement("input[name=desc]").get('value'),prefix:tblName+".",postfix:"",fields:[]};
      var tblFields=allTables[tblIdx][2].slice(); //Tabella dei campi della tabella selezionata
      tblFields.sort(function(e1,e2){return(e1[0]<=e2[0]?-1:1);});
      tblFields.each(function (fld) {
        curTable.fields.push([fld[0],fld[1],fld[2] + "(" + fld[3] + "," + fld[4] + ")",fld[5]]);
      });
      fieldsOfTable.push(curTable);
    }
  });
  //ordina in base alla descrizione
  fieldsOfTable.sort(function(e1,e2){return(e1.desc<=e2.desc?-1:1);});
  return fieldsOfTable;
}

function GetVariablesForExpBuilder(){
  var variables=[];
  variables.push({name:"variablesSync",desc:"Synchronization variable",prefix:"",postfix:"",functions:variablesSync});
  return variables;
}

function getParametersOfQueries(){
}

function New(){
  CheckQueryModified();
  BlankAllLists();
  Ctrl("chk_distinct").checked = false;
  Ctrl("chk_union_all").checked = false;
  Ctrl("chk_multi_company").checked = false;
  Ctrl("chk_public").checked = false;
  Ctrl("chk_batch").checked = false;
  Ctrl("chk_cache").selectedIndex = 0;
  Ctrl("cache_duration").value = "10";
  Ctrl("security_roles").value = "";
  Ctrl("security_key").value = "";
  Ctrl("remote_server").value = "";
  Ctrl("remote_vqr_name").value = "";
  SetRemoteUser("");
  SetRemotePassword("");
  Ctrl("remote_company").value = "";
  Ctrl("remote_instance").value = "";
  Ctrl("remote_mode").value = "native";
  Ctrl("chk_remove_filter").checked = false;
  Ctrl("chk_use_orderby").checked = true;
  Ctrl("notes").value = "";
  window.location = "index.jsp"+(offlinemode?"?offlinemode=true":'');
}

function Open(){
  CheckQueryModified();
  var height = 500;
  var width = 950;
  var left = (screen.width)?(screen.width-width)/2:100;
  var top = (screen.height)?(screen.height-height-100)/2:100;
  openSPModalLayer("../portalstudio/open.jsp?tool=visualquery&onetool=true&callerFunction=openQueryFile&SPModalLayerId=visualquerySPModalLayer", top, left, width, height, false, 1, false,false)
}

function openQueryFile(a,queryname,parameters){
  m_cFilename = queryname;
  OpenFile(parameters);
}

function Save(then){
  if (m_bUpdated){
    old_name=m_cFilename;
    SaveFile(then);
  } else PSAlert.alert('Query not modified.')
}

function CheckQueryModified(){
  if (m_bUpdated){
    var askSave = confirm("Query has been modified.\nClick OK to save it.\nClick Cancel to ignore changes.");
    if (askSave){
      old_name=m_cFilename;
      SaveFile();
    }
  }
}

function EditQuery() {
  var i;
  var vqr_union_name = Ctrl("union_file").value;
  if (!vqr_union_name)
    PSAlert.alert("No query selected.");
  else {
    vqr_union_name=vqr_union_name.trim().split(/ *; */);
    if (vqr_union_name.length==1)
      openQuery(-1,vqr_union_name[0]);
    else {
      var table=Ctrl("unionQueryTable"),inner='';
      var vqrs = {};
      for (i=0; i<vqr_union_name.length;i++){
        var filename=vqr_union_name[i], regexpres;
        if((regexpres = filename.match(vqr_regexp_without_vqr))!=null){
          filename=regexpres[1];
        }
        vqrs[filename]=true;
      }
      vqrs = Object.keys(vqrs);
      if (vqrs.length==1) {
        openQuery(-1,vqrs[0]);
      }
      for (i=0; i<vqrs.sort().length;i++){
        inner+="<tr><td ondblclick='openUnionQuery(this)' onclick='selectUnionQuery(this)'>"+vqrs[i]+"</td></tr>";
      }
      table.innerHTML=inner;
      toggleMaskUnion();
    }
  }
}

function selectUnionQuery(el){
  if (unionQuery)
    unionQuery.removeClass('selected')
  unionQuery=el;
  unionQuery.addClass('selected')
}

function openUnionQuery(_query){
  unionQuery=_query||unionQuery
  if (unionQuery)
    openQuery(-1,unionQuery.innerText)
  toggleMaskUnion()
}

function toggleMaskUnion(){
  var mask=Ctrl('unionQueryDiv');
  if (mask.style.visibility=='visible'){
    mask.style.visibility='hidden'
  }
  else {
    unionQuery='';
    selectUnionQuery(Ctrl("unionQueryTable").getElementsByTagName("td")[0])
    mask.style.visibility='visible'
    mask.style.bottom='12px';
    mask.style.left='240px';
  }
}


function GetMultiCompany(){
  return Ctrl("chk_multi_company").checked;
}

function GetFilename(operation){
  fileDialogOperation = operation;
  tempRemote_server = Ctrl("remote_server").value;
  tempRemote_user = GetRemoteUser();
  tempRemote_password = Ctrl("remote_password").value;
  tempRemote_company = Ctrl("remote_company").value;
  tempRemote_instance = Ctrl("remote_instance").value;
  tempRemote_mode = Ctrl("remote_mode").value;
  var height = 500;
  var width = 500;
  var left = (screen.width)?(screen.width-width)/2:100;
  var top = (screen.height)?(screen.height-height-100)/2:100;
  if (operation=='import' || operation=='testconfiguration')
    openSPModalLayer("../visualquery/filelist.htm", top, left, width, height, true, 1, false,false)
  else
    openSPModalLayer("../maskparameters/SPMaskParametersConfigurator_list.jsp?action=queryName&SPModalLayerId=querySPModalLayer"+(offlinemode?"&offlinemode=true":""), top, left, width, height, false, 1, false,false)
}

function loadValue(action,value){
  tempFilename=value;
  switch (fileDialogOperation){
    case "open":
      m_cFilename = tempFilename;
      OpenFile();
      break;
    case "saveas":
      old_name= m_cFilename;
      m_cFilename = tempFilename;
      currentname = m_cFilename;
      SaveFile()
      break;
    case "union":
      SetUnionFile();
      break;
    case "filters":
      GetFiltersFile();
      break;
    case "temptable":
      SetTempTable();
      break;
    case "listQuery":
      Ctrl("listQuery").value=tempFilename;
      break;
    case "queryToCompare":
      Ctrl("queryToCompare").value=tempFilename;
      break;
  }
  currentname=m_cFilename;
}

function DoOperation(){
  switch (fileDialogOperation){
    case "import":
      ImportFile();
      break;
    case "testconfiguration":
      Ctrl("configurationFileName").value=tempFilename;
      break;
  }
}

function AddListQuery(){
  GetFilename("listQuery");
}

/* Apre un file VQR e lo visualizza */
function OpenFile(parameters){
  if (m_cFilename!=null){
    m_cFilename = LTrim(m_cFilename, '/');
    currentname=m_cFilename;
    var updateTable=false;
    if (parameters){
      updateTable=offlinemode!=parameters.offlinemode
      offlinemode=parameters.offlinemode;
      document.getElementById('customQry').checked=parameters.custom;
    }
    var vqr = new JSURL("../servlet/SPVQRProxy?action=open&filename="+m_cFilename+(offlinemode?"&offlinemode=true":'')+"&custom="+document.getElementById('customQry').checked, true).Response();
    if (Empty(vqr))
      PSAlert.alert('Query not found')
    if (updateTable)
      addTables();
    BlankAllLists();
    FillVQRVariables('open', vqr);
    Public_Modified();
    Cache_Modified();
  }
}
var old_name;
function SaveFile(then){
  if (m_cFilename!=null){
    m_cFilename=Trim(m_cFilename);
    currentname=m_cFilename;
    var ProceedSave=false;
    var forceSave=false;
    if (changedCustom)
      forceSave=true;
    if(fileDialogOperation=="saveas"){
      if(!EmptyString(m_cFilename)){
        var found = parseInt((new JSURL("../servlet/SPVQRProxy?action=exists&m_cFilename="+m_cFilename+(offlinemode?"&offlinemode=true":'')+"&custom="+document.getElementById('customQry').checked,true)).Response())
        if(found!=-1){
          if (found){
            ProceedSave=confirm("File already exists, overwrite?")
            forceSave=true;
          }
          else ProceedSave=true;

          // ProceedSave = found ? confirm("File already exists, overwrite?") : true;

        }else{
          PSAlert.alert("Server side error.");
        }
        fileDialogOperation="";
      }else{
        PSAlert.alert("Empty VQR name: please choose a valid name.")
      }
    } else {
      ProceedSave=true;
    }
    if(ProceedSave){
      SavingAlert(true,'saving vqr...');
      if(parent) parent.is_Saving=true;
      //Salvataggio a seguito di un CLOSE
      if (then=="close"){
        closeAfterSave=true;
      }
        SaveFile2.delay(200,window,forceSave);
    }else
      m_cFilename=old_name;
      currentname=m_cFilename;
  } else {
    GetFilename.delay(1,window,"saveas");
  }
}
function SaveFile2(forceSave){
  var output='';
  var url = new JSURL("../servlet/SPVQRProxy?m_cFilename="+m_cFilename+(m_nFrontendPort?"&frontendport="+m_nFrontendPort:"") +
    (m_bOfflineMode?'&offlinemode=true':'') +
    "&m_cAction=save" +
    "&m_cWv=" + URLenc(FillVQRVariables('save',null,null,true)) +
    "&forceSave=" + forceSave +
    "&custom="+document.getElementById('customQry').checked +
    "&m_cID=" + cmdhash
    ,true);
  output=url.Response()
  if(output){
    if (output.indexOf('ok')!=-1){
      NotifySave('ok')
    }
    else NotifySave(output);
  }
  if (output.indexOf('ok')==-1)
    PSAlert.alert(output);
  else
    m_nFileVersion=parseInt(Right(output,output.length-15))
  if(parent) parent.is_Saving=false;
  if(Empty(old_name) || old_name!=m_cFilename){
    if (window.history.pushState) {
      window.history.pushState(m_nFileVersion, m_cFilename+" - VisualQuery", "index.jsp?filename="+m_cFilename+(offlinemode?"&offlinemode=true":''));
    } else
      window.location.href=SPWebRootURL+'/visualquery/index.jsp?filename='+m_cFilename+(offlinemode?"&offlinemode=true":'');
  }
}

function ImportFile(){
  Ctrl("remote_server").value = tempRemote_server;
  SetRemoteUser(tempRemote_user);
  SetRemotePassword(tempRemote_password);
  Ctrl("remote_company").value = tempRemote_company;
  Ctrl("remote_instance").value = tempRemote_instance;
  Ctrl("remote_mode").value = tempRemote_mode;
  Ctrl("remote_vqr_name").value = tempFilename;
  SetUpdated();
}
var notimooManager;
function NotifySave(result) {
 switch(result) {
  case 'ok':
   m_bUpdated=false;
   if(closeAfterSave)
    window.parent.closeCurrentObj();
   else {
    if(window.parent.changeName)
      window.parent.changeName(m_cFilename,{custom:document.getElementById('customQry').checked,offlinemode:offlinemode},Strtran(window.frameElement.id,'portalstudioframe',''));
   }
  if(window.parent.AddRecentOpen) window.parent.AddRecentOpen("visualquery",m_cFilename,{custom:document.getElementById('customQry').checked,offlinemode:offlinemode})
  SavingAlert(false);
   notimooManager.show({
	   title:'Notification message',
	   message: 'vqr saved!',
	   visibleTime: 2000,
	   width:200
  });
   break;
  case 'no_filename':
   SavingAlert(false);
   m_nFileVersion--;
   break;
  case 'error':
   SavingAlert(false);
   m_nFileVersion--;
   PSAlert.alert("Error: unable to save file.");
   break;
  default:
   SavingAlert(false);
   m_nFileVersion--;
   break;
 }
}

function ToggleSearchPanel(e){
  e = (e)? e: window.event;
  Ctrl("searchPanel").style.visibility=(Ctrl("searchPanel").style.visibility=="hidden"?"visible":"hidden");
  Ctrl("searchPanel").style.left=e.clientX+'px';
  Ctrl("searchPanel").style.top=(e.clientY+30)+'px';
}

function AddTempTable(){
  GetFilename("temptable");
}

function SelectConfigurationFileName(){
  GetFilename("testconfiguration");
}

function AddBOTable(){
  tempRemote_server = Ctrl("remote_server").value;
  tempRemote_user = GetRemoteUser();
  tempRemote_password = Ctrl("remote_password").value;
  tempRemote_company = Ctrl("remote_company").value;
  tempRemote_instance = Ctrl("remote_instance").value;
  tempRemote_mode = Ctrl("remote_mode").value;
  var height = 510;
  var width = 450;
  var left = (screen.width)?(screen.width-width)/2:100;
  var top = (screen.height)?(screen.height-height)/2:100;
  openSPModalLayer("../jsp-system/SPVQREditorSelectBO_portlet.jsp?callerFunction=AddBO"+(offlinemode?"&offlinemode=true":''), top, left, width, height, true, 1, false,false)
}
function AddBO(BO,module){
  tempFilename=BO;
  SetTempTable(module);
}

function updateFieldsQuery(idx){
  allTables[idx][2]=null;
  o_dictTables.setSelectedRow(idx);
}

function openQuery(idx,queryName){
  if (idx!=-1)
    queryName=allTables[idx][0];
  if(parent && parent.newCurrentObj!=null && window.parent.location.href.indexOf("portalstudio.jsp") != -1){
    var found = parseInt((new JSURL("../servlet/SPVQRProxy?action=exists&m_cFilename="+Lower(queryName)+(offlinemode?"&offlinemode=true":'')+"&custom=true",true)).Response())
    parent.newCurrentObj(Lower(queryName),"visualquery",{custom:found!=0,offlinemode:offlinemode});
  }
  else
    window.open("../visualquery/index.jsp?filename="+queryName+(offlinemode?"&offlinemode=true":''),"visualquery","resizable=yes,status=no,toolbar=no,menubar=no,location=no");
}

function SetTempTable(module,dontAlert){
  var idx=-1;
  if(Upper(Left(tempFilename,3))!="BO:" && Upper(Left(tempFilename,16))!="STOREDPROCEDURE:")
    tempFilename=Upper(tempFilename);

  for(var i=0;i<allTables.length && idx==-1;i++){
    if(tempFilename==allTables[i][0])
      idx=i;
  }
  if(idx==-1){
    idx=allTables.length;
    if(Upper(Left(tempFilename,3))!="BO:" && Upper(Left(tempFilename,16))!="STOREDPROCEDURE:"){
      allTables[idx]=new Array(tempFilename,tempFilename+".VQR");
      DrawDictTablesRow(tempFilename+".VQR","","")
      o_dictTables.refresh();
      o_dictTables.setSelectedRow(idx);
      var subQuery=o_dictTables.getSelectedRowHtml(0);
      var editQueryBtn=new Element('span',{
        type:'button',
        'class':'editQueryBtn'
      }).inject(subQuery);
      editQueryBtn.addEvent('click',function(){openQuery(idx)});
      var updateFieldsQueryBtn=new Element('span',{
        type:'button',
        'class':'updateFieldsQueryBtn'
      }).inject(subQuery);
      updateFieldsQueryBtn.addEvent('click',function(){updateFieldsQuery(idx)});
    }
    else {
      allTables[idx]=new Array(tempFilename,tempFilename);
      DrawDictTablesRow(tempFilename,"",module||"")
      o_dictTables.refresh();
      o_dictTables.setSelectedRow(idx);
    }
  }
  else if (!dontAlert) {
    PSAlert.alert("Duplicated table name.");
  }
  return idx;
}

function addTables(){
  allTables=[];
  o_dictTables.deleteAllItem();
  GetTables(); //Richiede la lista delle tabelle al server e li salva nell'array "allTables"
  for (var i=0; i<allTables.length; i++){
    o_dictTables.addStringRow([allTables[i][1], allTables[i][4],allTables[i][5]]);
  }
  o_dictTables.addRows();
}

function AddStoredProcedure(){
  tempFilename=Ctrl('storedProcedureName').value;
  if (!Empty(tempFilename)){
    tempFilename="STOREDPROCEDURE:"+tempFilename;
    SetTempTable();
  }
  toggleStoredProcedureDiv();
}

function toggleStoredProcedureDiv(){
  var div=Ctrl("maskStoredProcedure");
  if (div.style.display=='none')
    div.style.display='block';
  else div.style.display='none'
}

function DoLoad(filename, frontendport, custom, offlinemode){

  this.PSToolbarPreview = [
  { 'id': 'btn_new'
      , 'class_name': 'btn'
      , 'action': function(e){ New(e) }
      , 'image': './images/bot_qd_new.png'
      , 'title': 'New'
    },
    { 'id': 'btn_open'
      , 'class_name': 'btn'
      , 'action': function(e){ Open(e) }
      , 'image': './images/bot_qd_open.png'
      , 'title': 'Open'
    },
    { 'id': 'btn_save'
      , 'class_name': 'btn'
      , 'action': function(e){ Save(e) }
      , 'image': './images/bot_qd_save.png'
      , 'title': 'Save'
    },
    { 'id': 'btn_saveAs'
      , 'class_name': 'btn'
      , 'action': function(){ GetFilename('saveas') }
      , 'image': './images/bot_qd_saveas.png'
      , 'title': 'Save as'
    },

      {
        'isSeparator': true
      },

     { 'id': 'btn_find'
      , 'class_name': 'btn'
      , 'action': function(e){ ToggleSearchPanel(e) }
      , 'image': '../portalstudio/images/panel/search.png'
      , 'title': 'Search'
    },

      {
        'isSeparator': true
      },
    { 'id': 'btn_execute'
      , 'class_name': 'btn'
      , 'action': function(e){ executeQuery(e);  }
      , 'image': './images/bot_qd_run.png'
      , 'title': 'Execute query'
    },{ 'id': 'btn_showSQL'
      , 'class_name': 'btn'
      , 'action': function(e){ showSQLPhrase(e); }
      , 'image': './images/bot_qd_sql.png'
      , 'title': 'Show SQL phrase'
    },{ 'id': 'btn_analyze'
      , 'class_name': 'btn'
      , 'action': function(e){ analyze(e); }
      , 'image': './images/bot_qd_analyze.png'
      , 'title': 'Analyze SQL phrase'
    },{ 'id': 'btn_compareQuery'
      , 'class_name': 'btn'
      , 'action': function(e){ toggleMaskCompareQuery(e); }
      , 'image': '../maskparameters/images/check_field.png'
      , 'title': 'Compare query'
    },{ 'id': 'btn_VZM'
      , 'class_name': 'btn'
      , 'action': function(){ CreateVZMConfig(); }
      , 'image': './images/bot_qd_vzm.png'
      , 'title': 'Create VZM configuration'
    }

  ]

  if (IsQueryTestInstalled){
    PSToolbarPreview.push(
      { 'id': 'btn_test'
      , 'class_name': 'btn'
      , 'action': function(){ toggleTestConfiguration(); }
      , 'image': './images/bot_qd_test.png'
      , 'title': 'Create test configuration'
      }
    )
  }

  if (addSecurityBtn){
    PSToolbarPreview.push(
      { 'id': 'btn_security'
      , 'class_name': 'btn'
      , 'action': function(){SetSecurity();}
      , 'image': './images/bot_qd_security.png'
      , 'title': 'Security'
      }
    )
  }
  var smartToolbar = [
    { 'id': 'btn_save'
      , 'class_name': 'btn'
      , 'action': function(e){ Save(e) }
      , 'image': './images/bot_qd_save.png'
      , 'title': 'Save'
    },{ 'id': 'btn_showSQL'
      , 'class_name': 'btn'
      , 'action': function(e){ showSQLPhrase(e); }
      , 'image': './images/bot_qd_sql.png'
      , 'title': 'Show SQL phrase'
    },{ 'id': 'btn_analyze'
      , 'class_name': 'btn'
      , 'action': function(e){ analyze(e); }
      , 'image': './images/bot_qd_analyze.png'
      , 'title': 'Analyze SQL phrase'
    }
  ]
  toolbars.preview = new SPToolbar( simplemode ? smartToolbar : PSToolbarPreview, 'sptoolbar_preview', {
    elementToShow: 'all'
  });


  if ('setTitle' in parent) {
    toolbars.preview.removeElement("btn_new");
    toolbars.preview.removeElement("btn_open");
    toolbars.preview.removeElement("btn_save");
    toolbars.preview.removeElement("btn_saveAs");
    toolbars.preview.removeElement("separator1");
  }

  document.getElementById('customQry').checked=custom=='true';
  var customQry=false;
  if (!Empty(filename)){
    var found;
    if (custom=='true' || Empty(custom)){ // controllo che esista effettivamente altrimenti carico quella normale
      found = parseInt((new JSURL("../servlet/SPVQRProxy?action=exists&m_cFilename="+filename+(offlinemode?"&offlinemode=true":'')+"&custom=true",true)).Response())
      if (found==1){
        found = parseInt((new JSURL("../servlet/SPVQRProxy?action=exists&m_cFilename="+filename+(offlinemode?"&offlinemode=true":'')+"&custom=false",true)).Response())
        customQry=true;
        if (found==1){
          document.getElementById('correspondingQry').style.visibility='visible';
          document.getElementById('correspondingQry').value='Open default query';
        }
      }
    }
    else if (custom=='false' || Empty(custom)){
      found = parseInt((new JSURL("../servlet/SPVQRProxy?action=exists&m_cFilename="+filename+(offlinemode?"&offlinemode=true":'')+"&custom=true",true)).Response())
      if (found==1){
        document.getElementById('correspondingQry').style.visibility='visible';
        document.getElementById('correspondingQry').value='Open custom query';
      }
    }
  }
  if (Empty(custom))
    document.getElementById('customQry').checked=customQry;
  //Se il Visual Query viene caricato fuori dal Portal Studio, visualizzo i bottoni di gestione file
  var standalone=false;
  if ( 'setTitle' in parent) {
    parent.setTitle(this);
  } else {
    // Ctrl("StandaloneToolbar").style.display = "inline-block";
    standalone=true;
  }
  //Modifico l'altezza delle tabelle di DictTables e DictFields in relazione della grandezza della finestra
  AdjustDictionaryPanletHeight();
  TabPanelGroupPivot.refresh();
  TabPanel.refresh();
  if(simplemode){
    loadDataFromPortlet()
  } else {
  addTables();
  }
  m_bUpdated = false;
  if (!Empty(filename)){
    m_cFilename = filename;
    m_cFilename = Strtran(Strtran(m_cFilename, ".vqr", ""),".VQR","");
    currentname = m_cFilename;
    OpenFile();
    if(standalone) document.title=m_cFilename+" - VisualQuery";
  }
  if (!Empty(frontendport)) {
    m_nFrontendPort = frontendport;
  }
  if(typeof offlinemode!=='undefined') {
    m_bOfflineMode = offlinemode;
  }
  document.body.onhelp=CancelHelp;
  Ctrl('cache_duration').onkeypress=CheckNum;
  SelectRemoteMode_change();
  SetEditUnionVQR();
  //window.setTimeout('inputs_setOnFocus()',100);
  document.getElementById("notes").addEvent("focus",function(){
    o_dictTables.deactivateKeyboard();
    o_dictFields.deactivateKeyboard();
    o_dictRelations.deactivateKeyboard();
  });
}

function OpenCorrespondingQry(){
  var custom=document.getElementById('correspondingQry').value.indexOf('custom')!=-1
 if(parent && parent.newCurrentObj!=null && window.parent.location.href.indexOf("portalstudio.jsp") != -1){
    parent.newCurrentObj(m_cFilename,"visualquery",{offlinemode:offlinemode,custom:custom});
  }
  else
    window.open("../visualquery/index.jsp?filename="+m_cFilename+(offlinemode?"&offlinemode=true":'')+"&custom="+custom,"visualquery","resizable=yes,status=no,toolbar=no,menubar=no,location=no");
}

function callResizeFunction(){
  // if (Browser.ie && Browser.version<9)
    timeout=setTimeout(AdjustDictionaryPanletHeight,10);
  // else AdjustDictionaryPanletHeight();
}
function inputs_setOnFocus(){
  var inputs = document.getElementsByTagName('input');
  for(var i=0,input; input = inputs[i++];){ // eslint-disable-line no-cond-assign
    if (input.type=="text"){
      LibJavascript.Events.addEvent(input, 'focus',
        (function(input){
          return function(){
            input.select();
          }
        })(input)
      );
    }
  }
}

function EnableBtnRemoteImport() {
  Ctrl('import_remote_vqr').disabled = Empty(Ctrl('remote_server').value) || Ctrl('remote_mode').value!='native';
}

function SelectRemoteMode_change() {
  var isNative = Ctrl('remote_mode').value=='native';
  Ctrl('lbl_remoteServer').innerHTML = isNative ? 'Server:' : 'End point:';
  Ctrl('remote_vqr_name').disabled = !isNative;
  Ctrl('remote_user').disabled = !isNative;
  Ctrl('remote_password').disabled = !isNative;
  Ctrl('remote_company').disabled = !isNative;
  Ctrl('remote_instance').disabled = !isNative;
  EnableBtnRemoteImport();
}

function RemoteServer_change(){
  EnableBtnRemoteImport();
}

function RefreshRemoteParameters(){
  //TBD
}

function HelpQuery(){
  var prop="visualquery_query_"+TabPanel.currentTab.title.getAttribute('helpProp'),i;
  if(typeof(anchorToFeature)!='undefined'){
    if(prop in anchorToFeature)
      i=anchorToFeature[prop];
    else i=anchorToFeature["visualquery_query"];
    windowOpenForeground(m_cHelpUrl+'help/portalstudio/ps_urg_navigator.htm?'+URLenc(i+'||'+prop),'','toolbar=0,menubar=0,directories=0,width=720,height=600,resizable=1,scrollbars=1',null,null,null,true);
  }
  else Help()
}

function Help(){
  windowOpenForeground(m_cHelpUrl+'help/portalstudio/ps_urg_navigator.htm?'+URLenc('Cap06/vquery.htm||VisualQuery'),'','toolbar=0,menubar=0,directories=0,width=720,height=600,resizable=1,scrollbars=1');
}
function AdjustDictionaryPanletHeight() {
  var ulContainerH, ulMiddleContainerH;
  if (timeout)
    clearTimeout(timeout);
  if (previewOpen){
    var w=window.getSize().x-8, h=window.getSize().y-10;
    document.getElementById('preview_wrapper').setStyles({'width': w,'height':h,'left':4,'top':4});
    document.getElementById('iframe_wrapper').setStyles({'width': w-10,'height':h-30});
    document.getElementById('preview').setStyles({'width': w-20,'height':h-40});
  }
  if (dictionaryopen){
    ulContainerH=203;
    Ctrl('tabPanelGroupPivot').style.height='auto';
    $$(".ulContainer").each(function(el){
      el.style.height=ulContainerH+'px';
    });
    var tabContainerH=ulContainerH+20+32;
     $$(".tabContainer").each(function(el) {
      el.style.height=tabContainerH+'px';
    });
    $$(".ulMiddleContainer").each(function(el){
      el.style.height='89px';
    });
    $$(".queryPanelTable").each(function(el){
      el.style.height='230px';
    });

    //sistemo le larghezze
    var queryPanelW=Ctrl('queryPanel').offsetWidth;
    Ctrl('FieldsContainer').style.width=(queryPanelW-404)+'px'
    Ctrl('tabPanelGroupPivot').style.left=(Ctrl('FieldsContainer').offsetWidth)+'px';
    Ctrl('tabContents').style.width=(Ctrl('dictionaryPanel').offsetWidth-4)+'px';
    Ctrl('tabPanel').style.width=(Ctrl('dictionaryPanel').offsetWidth-2)+'px';

    if (Ctrl('tabPanelGroupPivot').offsetHeight>24)
      Ctrl('tabPanelGroupPivot').style.height=(Ctrl('tabPanelGroupPivot').offsetHeight-24)+'px';
    else Ctrl('tabPanelGroupPivot').style.height='0px';

    var dictPanelH=GetWindowSize().h-Ctrl("queryPanel").offsetHeight-40;
    if (dictPanelH>0)
      Ctrl("dictionaryPanel").style.height=dictPanelH+'px';
    Ctrl("dictionaryPanel").style.minHeight='192px';
    Ctrl("dictPanelRelDiv").style.height = 62+'px';
    Ctrl("dictPanelRelTr").style.height = 62+'px';
    var dictPanelCaptionH = 30; // dictionary
    var dictPanelTableTitleH = Ctrl("dictPanelTitleTr").offsetHeight; //tables
    var dictPanelRelTitleH = Ctrl("dictPanelRelTitleTr").offsetHeight; //relations
    var dictPanelRelDivH = Ctrl("dictPanelRelDiv").offsetHeight;//relazioni
    var dictPanelTableTitDiv = Ctrl("dictFieldsDivTit").offsetHeight; //desc name module
    var tlbopencloseDiv = Ctrl("tableopenclose").offsetHeight;//openclose
    var dictPanelTableDivH = dictPanelH-(dictPanelCaptionH+dictPanelTableTitleH+dictPanelRelTitleH+dictPanelRelDivH+dictPanelTableTitDiv+tlbopencloseDiv);
    if(dictPanelTableDivH>30){//basta restringere la lista delle tabelle
      Ctrl("dictTablesDiv").style.height = dictPanelTableDivH+'px';
      Ctrl("dictFieldsDiv").style.height = dictPanelTableDivH+'px';
    }
    else {
      Ctrl("dictTablesDiv").style.height='30px'
      Ctrl("dictFieldsDiv").style.height='30px'
      var totalHeight=dictPanelCaptionH+dictPanelTableTitleH+30+62+dictPanelRelTitleH+dictPanelTableTitDiv+tlbopencloseDiv+Ctrl("queryPanel").offsetHeight+10;
      if (totalHeight-GetWindowSize().h>0){
        if (totalHeight-GetWindowSize().h<=32){
          Ctrl("dictPanelRelDiv").style.height=(dictPanelRelDivH-(totalHeight-GetWindowSize().h))+'px';
          Ctrl("dictPanelRelTr").style.height=(dictPanelRelDivH-(totalHeight-GetWindowSize().h))+'px';
        }
        else {
          Ctrl("dictPanelRelDiv").style.height='30px';
          Ctrl("dictPanelRelTr").style.height='30px';
          totalHeight-=32;
          if (totalHeight-GetWindowSize().h>0){
            // si restringe il queryPanel
            ulContainerH=Max(203-(totalHeight-GetWindowSize().h),86)
            $$(".ulContainer").each(function(el){
              el.style.height=ulContainerH+'px';
            });

            $$(".tabContainer").each(function(el) {
              el.style.height=(ulContainerH+20+32)+'px';
            });
            ulMiddleContainerH=ulContainerH-20;
            ulMiddleContainerH=(ulMiddleContainerH/2)-2;
            $$(".ulMiddleContainer").each(function(el){
              el.style.height=ulMiddleContainerH+'px';
            })
            $$(".queryPanelTable").each(function(el){
              el.style.height=(230-(203-ulContainerH))+'px';
            });
          }
        }
      }
    }
  }
  else {
    Ctrl('tabPanelGroupPivot').style.left=(Ctrl('FieldsContainer').offsetWidth+2)+'px';
    Ctrl('tabPanelGroupPivot').style.height='auto';
    ulContainerH=Max(GetWindowSize().h-200,86);
    $$(".ulContainer").each(function(el) {
      el.style.height=ulContainerH+'px';
    });

     $$(".tabContainer").each(function(el) {
      el.style.height=(ulContainerH+20+32)+'px';
    });
     ulMiddleContainerH=Max(GetWindowSize().h-200,86)-20;
    ulMiddleContainerH=(ulMiddleContainerH/2)-2;
    $$(".ulMiddleContainer").each(function(el) {
      el.style.height=ulMiddleContainerH+'px';
    });
    if (Ctrl('tabPanelGroupPivot').offsetHeight>24)
      Ctrl('tabPanelGroupPivot').style.height=(Ctrl('tabPanelGroupPivot').offsetHeight-24)+'px';
    else Ctrl('tabPanelGroupPivot').style.height='0px';
  }
  //sistemo la posizione della maschera dei tipi se visibile
  var maskType=document.getElementById('maskType')
  if (maskType.style.visibility=='visible'){
    var position=maskType.getPosition()
    if ((position.x+maskType.getSize().x)>window.getSize().x)
      position.x=window.getSize().x-maskType.getSize().x
    if ((position.y+maskType.getSize().y)>window.getSize().y)
       position.y=window.getSize().y-maskType.getSize().y
    maskType.setStyles({
      top:position.y,
      left:position.x
    })
  }

  var maskTestConf=document.getElementById('maskTestConf');
  if (maskTestConf){
    if (maskTestConf.style.visibility=='visible')
      maskTestConf.style.left=Ctrl("dictPanelCaptionTr").offsetWidth-maskTestConf.offsetWidth+13+'px';
  }
  if (Ctrl('NoteTab').offsetHeight>5)
  Ctrl('notes').style.height=(Ctrl('NoteTab').offsetHeight-5)+'px';
}

// var saving, savingpic;
function SavingAlert(show,msg){
	if(show){
     notimooManager = new Notimoo({});
		 notimooManager.show({
		   title:'Notification message',
		   message: msg||'saving vqr...',
		   sticky : true,
		   width:200,
		   height:40
		});
	}else{
		 notimooManager.close(notimooManager.elements[0]);
	}
}

function GetTables(){
  var oTable;
  var tablesCSV = new JSURL("../servlet/SPXDCProxy?action=tables&tmptbl=true&offlinemode="+offlinemode, true);
  tablesCSV = tablesCSV.Response();

  //Se mancano le librerie sul server
  if (At("ACCESS DENIED", tablesCSV)>0){
    PSAlert.alert("Access Denied.");
  }
  else if (At("ClassNotFoundException: SPXDCProxy", tablesCSV)>0){
    PSAlert.alert("Installation incomplete.");
  } else {
    var oTables = tablesCSV.split(CSV_SEP);
    if (oTables[0]=="* --- Visual Query Tables 1.0 ---*") {
      for (var i=1; i<oTables.length; i++){
        oTable = oTables[i].split("|");
        allTables[i-1] = new Array(oTable[0], oTable[1], null, null, oTable[2], oTable[3]);
      }
      allTables.sort(TablesSortFunc);
    }
    else {
      PSAlert.alert("Server Error:\n\n"+tablesCSV);
    }
  }
}

function DrawDictTablesRow(tDesc, tName, tModule){
  /*var openWizardField = new Element('div',{
    'class':'btnWizardField'
  }).inject(newCell)
  openWizardField.addEvents({
    'click':function(){
      toggleWizardField();
    }
  })*/
  o_dictTables.addRow([tDesc,tName,tModule]);
}


function SortTableList(sortby){
  o_dictTables.sort(sortby);
}
function SortFieldList(sortby){
  o_dictFields.sort(sortby)
}

function TablesSortFunc(a, b){
  var aa = a[1].toLowerCase();
  var bb = b[1].toLowerCase();
  if (aa > bb) return 1;
  if (aa < bb) return -1;
  return 0;
}

function UpdateFieldsAndRelations(){
  if (o_dictTables.getSelectedRow()>-1){
    Ctrl("lbl_fields").innerHTML = "Fields of " + allTables[o_dictTables.getSelectedRow()][1];
    fieldsOf=allTables[o_dictTables.getSelectedRow()][1];
    lastTableAlias=""
    Ctrl("lbl_relations").innerHTML = "Relations of " + allTables[o_dictTables.getSelectedRow()][1];
    GetFieldsAndRelations(o_dictTables.getSelectedRow());
  }
}

function GetFieldsAndRelations(ofTable){
  var i;
  FetchData(ofTable);
  o_dictFields.deleteAllItem();
  for (i=0; i<allTables[ofTable][2].length; i++)
    o_dictFields.addStringRow([allTables[ofTable][2][i][1],allTables[ofTable][2][i][0],allTables[ofTable][2][i][2]+'('+allTables[ofTable][2][i][3]+','+allTables[ofTable][2][i][4]+')',allTables[ofTable][2][i][5]])

  o_dictRelations.deleteAllItem();
  for (i=0; i<allTables[ofTable][3].length; i++)
    o_dictRelations.addStringRow([allTables[ofTable][3][i][0]])

  o_dictFields.addRows();
  o_dictRelations.addRows();
}

/* Carica le proprietà della tabella dal server se é la prima volta che viene selezionata */
function FetchData(ofTable){
  if (ofTable>-1 && allTables[ofTable][2]==null){
    var oField, oRelation, i, rows;

    if(RAt(".VQR", allTables[ofTable][1])){
      allTables[ofTable][2] = new Array();
      oField = new JSURL("../servlet/SPVQRProxy?action=fields&filename="+allTables[ofTable][0]+(offlinemode?"&offlinemode=true":''), true);
      oField = oField.Response();

      var l_oFields = new TrsJavascript();
      l_oFields.reset();
      l_oFields.SetRow(0);
      l_oFields.BuildProperties(oField);
      var errorMsg=GetProperty(l_oFields,'errorMsg','C')
      if (errorMsg!="")
        alert(errorMsg)
      rows = GetProperty(l_oFields,'Rows','N');
      for(i=0;i<rows;i++){
        l_oFields.SetRow(i);
        allTables[ofTable][2][i] = new Array(GetProperty(l_oFields,'alias','C'),GetProperty(l_oFields,'desc','C'),GetProperty(l_oFields,'type','C'),GetProperty(l_oFields,'len','N'),GetProperty(l_oFields,'dec','N'),0,GetProperty(l_oFields,'privacy','N'),GetProperty(l_oFields,'identifier','L'));
      }
      //Non ci sono relazione per le tablelle temporanee
      allTables[ofTable][3] = new Array();
    }
    else {
      var fieldsCSV = new JSURL("../servlet/SPXDCProxy?action=fields&table=" + allTables[ofTable][0]+"&offlinemode="+offlinemode+"&format=properties", true);
      fieldsCSV = fieldsCSV.Response();
      allTables[ofTable][2] = new Array();
      if (At(fieldsCSV,'* --- Visual Query Fields 1.0 ---*'+CSV_SEP)==0){
        var oFields = new TrsJavascript();
        oFields.reset();
        oFields.SetRow(0);
        oFields.BuildProperties(Strtran(fieldsCSV,'* --- Visual Query Fields 1.0 ---*'+CSV_SEP,''));
        rows=GetProperty(oFields,'Rows','N');
        for(i=0;i<rows;i++){
          oFields.SetRow(i);
          let exp = GetProperty(oFields,'exp','C');
          if (! (exp.startsWith('[J(') || exp.startsWith('[X('))) {
            exp = GetProperty(oFields,'alias','C');
          }
          allTables[ofTable][2][i] = new Array(exp,GetProperty(oFields,'desc','C'),GetProperty(oFields,'type','C'),GetProperty(oFields,'len','N'),GetProperty(oFields,'dec','N'),GetProperty(oFields,'index','N'),GetProperty(oFields,'privacy','N'),GetProperty(oFields,'identifier','L'));
        }
      }
      else allTables[ofTable][2][0] = new Array ("Server Error", "Server Error", "", "", "",0,0,false);

      var relationsCSV = new JSURL("../servlet/SPXDCProxy?action=relations&table=" + allTables[ofTable][0]+"&offlinemode="+offlinemode, true);
      relationsCSV = relationsCSV.Response();

      var oRelations = relationsCSV.split(CSV_SEP);
      allTables[ofTable][3] = new Array();
      var allRelations2 = allTables[ofTable][3];

      if (oRelations[0]=="* --- Visual Query Relations 1.0 ---*") {
        for (i=1; i<oRelations.length && Len(relationsCSV) > 0; i++){
          oRelation = oRelations[i].split("|");
          allRelations2[i-1] = new Array (oRelation[0],oRelation[1],oRelation[2],oRelation[3],oRelation[4],oRelation[5]);
        }
      }
      else {
        allRelations2[0] = new Array("Server Error","","","","","");
      }
    }
  }
}

//------------------------- TABLES ----------------------------------
/* Aggiunge una tabella da quelle nella lista alla query */
function AddTable(){
  AddTableByIdx(o_dictTables.getSelectedRow());
  if (TabPanel.getSelectedTab()!=0)
    TabPanel.setSelectedTab(0); //Seleziono la sezione TABLES
}

function AddTableByIdx(dictTableIdx){
  var tblDesc="", tblAlias="";
  var tblsNum=0;

  $$('#tables_ul li input[name=name]').each(function(el) {
    if (el.value==allTables[dictTableIdx][0]) tblsNum++;
    if (tblsNum > 0){
      tblDesc="("+tblsNum+")";
      tblAlias=tblsNum;
    }
  });

  var tblName=allTables[dictTableIdx][0], _tblName=tblName;
  tblDesc=allTables[dictTableIdx][1]+(Lower(Right(allTables[dictTableIdx][1],4))=='.vqr'?'':tblDesc);
  if(Upper(Left(allTables[dictTableIdx][0],3))=="BO:"){
    tblAlias=Substr(allTables[dictTableIdx][0],4).split("->")[0]+tblAlias;
  }
  else if (Upper(Left(allTables[dictTableIdx][0],16))=="STOREDPROCEDURE:"){
    tblAlias=Substr(tblName,17);
    tblDesc=tblName;
    tblName="[STOREDPROCEDURE("+tblAlias+")]";
  }
  else {
    tblAlias=allTables[dictTableIdx][0]+tblAlias;
  }
  var curtbl = new Array(dictTableIdx, tblName, tblDesc, tblAlias, ++iid, "*")
  DrawTable(curtbl);
  if (!addingRelations) //??
    AddRelatedTables(_tblName);
  if (! (Browser.ie && Browser.version<9))
    document.getElementById("tables_ul").nanoScrollerMT();

  // devo aggiornare le combo delle join esistenti
  $$('#joins_ul li').each(function(el) {
    var insert=true;
    var options=el.getElement("select[name=tb1]").options;
    for (var i=0; i<options.length && insert; i++){
      if (options[i].value==tblAlias){
        insert=false;
      }
    }
    if (insert){
      el.getElement("select[name=tb1]").adopt(new Element('option',{
        'text':tblAlias,
        'title':tblAlias
      }));
      el.getElement("select[name=tb2]").adopt(new Element('option',{
        'text':tblAlias,
        'title':tblAlias
      }));
    }
  });
  SetUpdated();
  lastTableAlias=tblAlias;
  return curtbl;
}

function GetTableIdx(tblName){
  var idx=-1;
  for (var i=0; i<allTables.length && idx==-1; i++){
    if (allTables[i][0]==tblName)
      idx=i;
  }
  return idx;
}

function AddRelatedTables(tblName){
  var tblIdx=GetTableIdx(tblName);
  FetchData(tblIdx);
  var tblRelations=allTables[tblIdx][3]; //Tabella delle relazioni della tabella selezionata

  //Per ogni relazione della tabella aggiunta, se la tabella coinvolta nella relazione è già aggiunta nella query,
  //aggiungo la relazione di join
  for (var i=0; i<tblRelations.length; i++){
    $$('#tables_ul li input[name=name]').each(function(tbl) {
      if (tblRelations[i][2]==tbl.value && tbl.value!=tblName){
        AddJoin2(i, tblIdx, false)
      }
    });
  }
}

function SelectDictionaryTable(tableIdx,totalId) {
  if(tableIdx!=-1){
    if(o_dictTables.getSelectedRow() != tableIdx)
      o_dictTables.setSelectedRow(tableIdx);
    lastTableAlias=document.getElementById("tables_ul").getElement("li[totalid="+totalId+"]").getElement("input[name=alias]").get("value");
    Ctrl("lbl_fields").innerHTML="Fields of "+fieldsOf+" alias "+lastTableAlias;
 }
}

/* Visualizza le tabelle selezionate */
function DrawTable(dataForTable){
  var myul = document.getElementById("tables_ul");
  var key = LibJavascript.AlfaKeyGen(10);

  var li = new Element('li', {id:'table_'+key,idxTable:dataForTable[0], totalid:dataForTable[4]});

  var liHtml = "<span class='handler floatLeft'><span>move</span></span>";

  //Table Description
  liHtml += "<input type=\"text\" value=\"" + dataForTable[2] + "\" onchange=\"SetUpdated()\" onfocus=\"SelectTable(this)\" name=\"desc\" style=\"width:32%;\">";

  //Table Alias
  liHtml += "<input type=\"text\" value=\"" + dataForTable[3] + "\" onchange=\"SetTableValues(this)\" onfocus=\"FocusAliasTable(this)\" name=\"alias\" style=\"width:30%;\">";

  //Table Name
  liHtml += "<input type=\"text\" value=\"" + dataForTable[1] + "\" onchange=\"SetUpdated()\" onfocus=\"SelectTable(this)\" name=\"name\" style=\"width:20%;\">";

  //TempTable option
  liHtml += DrawTempTableTypeCombo(dataForTable);

  //Table Del Icon
  liHtml += "<span class=\"deleteIcon\" onclick=\"DeleteTable('"+key+"')\" icon-data='&#xe6a8;' style='margin-left:15px;'></span>";

  li.set('html',liHtml);
  li.addEvent('click', function() {
    lastTableSelected=this;
    SelectDictionaryTable(this.get('idxTable'),this.get('totalid'));
  });
  myul.adopt(li);
  sort_all.addItems(li);
}
function FocusAliasTable(el) {
  el=document.id(el);
  el.set('oldValue',el.get('value'));
  SelectTable(el);
}
function SetTableValues(el) {
  el = document.id(el);
  var oldValue = el.get('oldValue');
  var sel = new Element('select').setStyles({width:90});

  $$('#tables_ul li input[name=alias]').each(function(inp) {
    sel.adopt(new Element('option',{value:inp.value,text:inp.value}));
  });
  $$("#joins_ul li select").each(function(oldsel){
    if (oldsel.get('name')=='tb1' || oldsel.get('name')=='tb2') {
      var newvalue = oldsel.getSelected()[0].get('value');
      if (newvalue == oldValue) newvalue = el.get('value');
      var newselect = sel.clone().addEvent('change',SetUpdated).set('name',oldsel.get('name')).set('value',newvalue);
      newselect.replaces(oldsel);
    }
  });

  lastTableAlias=el.get('value');
  $$("#fields_ul li input[name=name]").each(function(field){
    if (field.get("value").indexOf(oldValue+".")==0)
      field.set("value",field.get("value").replace(oldValue,lastTableAlias));
  })
  $$("#filters_ul li input[name=field]").each(function(field){
    if (field.get("value").indexOf(oldValue+".")==0)
      field.set("value",field.get("value").replace(oldValue,lastTableAlias));
  })
  el.set('oldValue',lastTableAlias);
  Ctrl("lbl_fields").innerHTML="Fields of "+fieldsOf+" alias "+lastTableAlias;
  SetUpdated();
}

function SelectTable(t) {
  var item=t;
  while(item.tagName.toLowerCase()!='li')
    item=item.parentNode;
  document.id(item).fireEvent('click');
}

function DrawTempTableTypeCombo(table){
  var types1 = new Array("", "Use Temporary Table (CTE)", "Use Routine", "CTE MATERIALIZED", "CTE NOT MATERIALIZED");
  var types2 = new Array("*", ""                        , "+"          , "#"               , "$" );
  var selRet="&nbsp;";

  if (table[2].match(vqr_regexp)!=null) {
    selRet="<select style=\"width:14%;\" name=\"tt_type\" onchange=\"SetUpdated()\">";

    for (var j=0; j<types1.length; j++){
      var sSelected = table[5]==types2[j] ? " selected" : "";
      selRet += "<option" + sSelected + " value=\"" + types2[j] + "\">" + types1[j] + "</option>\n";
    }
    selRet += "</select>";
  } else {
    selRet = "<span style=\"width:14%;display:inline-block;\"></span>";
  }
  return selRet;
}

/* Rimuove una tabella dalla sezione TABLES rimuovendo tutte le sue presenze nelle altre sezioni */
function DeleteTable(key){
  var fieldPrefix, i;
  var curTable = document.getElementById('table_'+key);
  if (curTable === lastTableSelected) {
    lastTableSelected = null;
  }
  var curAlias = curTable.getElement("input[name=alias]").get('value');
  var itemsToDelete=[];
  $$('.FieldsValue').each(function(el) {
    var fieldvalue = el.get('value');
    if(Left(fieldvalue,3)=="[X(")
      fieldPrefix="[X(";
    else if(Left(fieldvalue,3)=="[J(")
      fieldPrefix="[J(";
    else
      fieldPrefix="";

    if((fieldvalue).split(".")[0]==fieldPrefix+curAlias){
      itemsToDelete.push(el.id);
    }
  });
  for (i=0;i<itemsToDelete.length;i++) {
    DeleteField(Strtran(itemsToDelete[i],'fld_name_',''),true);
  }
  itemsToDelete=[];
  $$('#joins_ul li').each(function(el) {
    if(el.getElement("select[name=tb1]").getSelected()[0].get('value')==curAlias || el.getElement("select[name=tb2]").getSelected()[0].get('value')==curAlias){
      itemsToDelete.push(el.id);
    }
  });
  for (i=0;i<itemsToDelete.length;i++) {
    DeleteJoin(Strtran(itemsToDelete[i],'join_',''));
  }

  itemsToDelete=[];
  $$('#filters_ul li').each(function(el) {
    if ((el.getElement("input[name=field]").get('value')).split(".")[0]==curAlias)
      itemsToDelete.push(el.id);
  });
  for (i=0;i<itemsToDelete.length;i++) {
    DeleteFilter(Strtran(itemsToDelete[i],'filter_',''));
  }

  DeleteItem(curTable);
  if (! (Browser.ie && Browser.version<9))
    document.getElementById("tables_ul").nanoScrollerMT();

  lastTableAlias="";
  Ctrl("lbl_fields").innerHTML="Fields of "+fieldsOf;

  //devo aggiornare le combo con le liste delle tabelle delle join esistenti
  $$('#joins_ul li').each(function(el) {
    var i,
     options=el.getElement("select[name=tb1]").options;
    for (i=0; i<options.length; i++){
      if (options[i].value==curAlias){
        document.id(options[i]).destroy();
      }
    }
    options=el.getElement("select[name=tb2]").options;
    for (i=0; i<options.length; i++){
      if (options[i].value==curAlias){
        document.id(options[i]).destroy();
      }
    }
  });

}

function SetUnionFile(){
  Ctrl("union_file").value=Empty(Ctrl("union_file").value) ? tempFilename : Ctrl("union_file").value+';'+tempFilename;
  SetEditUnionVQR();
  SetUpdated();
}

function SetEditUnionVQR() {
  if(!Empty(Ctrl("union_file").value)) Ctrl("union_file_open").style.display="inline-block";
  else Ctrl("union_file_open").style.display="none";
}

function CheckTableUsed(tblName){
  var used=false;
  $$('#tables_ul li input[name=name]').each(function(el) {
    if (el.get('value')==tblName)
      used=true;
  });
  return used;
}
function GetLastTableAlias(tblName) {
  if (lastTableSelected!=null && lastTableSelected.getElement("input[name=name]").get('value') == tblName) // && lastTableSelected.get('idxTable')==o_dictTables.getSelectedRow()
    return document.getElementById("tables_ul").getElement("li[totalid="+lastTableSelected.get('totalId')+"]").getElement("input[name=alias]").get("value");
  var maxiid=-1;
  var alias;
  $$('#tables_ul li').each(function(el) {
    if (el.getElement("input[name=name]").get('value') == tblName && parseInt(el.get('totalid'))>maxiid) {
      alias = el.getElement("input[name=alias]").get('value');
      maxiid = parseInt(el.get('totalid'));
    }
  });
  return alias;
}

//------------------------ FIELDS -----------------------------------
function AddField(){
  var tblIdx=o_dictTables.getSelectedRow(); //Indice della tabella selezionata
  var fldIdx=o_dictFields.getSelectedRow(); //Indice del campo selezionato


  if(TabPanel.getSelectedTab()==4){ //Filter
    AddFieldToFilter(tblIdx,fldIdx);
    return;
  }
  if(TabPanel.getSelectedTab()==5){ //Parameter
    AddFieldToParam(tblIdx,fldIdx);
    return;
  }

  var fldName,fldAlias;
  var fldInfo=allTables[tblIdx][2][fldIdx];
      //  fldInfo                        |
      //     0       field name          |
      //     1       field description   |
      //     2       field type          |
      //     3       field size          |
      //     4       decimal size        |
      //     5       index               |
      //     6       privacy             |
      //     7       identifier          |

  var aliasTable;

  if(!CheckTableUsed(allTables[tblIdx][0])){
    aliasTable = AddTableByIdx(tblIdx)[3];
  } else  {
    aliasTable = GetLastTableAlias(allTables[tblIdx][0]);
  }

  if (fldInfo[0].startsWith('[J(') || fldInfo[0].startsWith('[X(')) {
    fldName = fldInfo[0];
    fldAlias = fldName.substring(fldName.indexOf(',') +1, fldName.length-2);
  }
  else {
    fldAlias=fldInfo[0];
    fldName = aliasTable + "." + (/* simplemode ? Lower(fldAlias) : */ fldAlias);
  }
  var find=false
  $$('.FieldsValue').each(function(el) {
    if (Lower(fldName) == Lower(el.get('value'))){
      find=true;
      return
    }
  });
  if(find){
    var addFieldAgain=confirm("Field already exist, add again?");
    if(!addFieldAgain) return;
  }
  var listAlias=[],i=0
  $$('.floatRight input[name="alias"]').each(function(el) {
    listAlias[i]=Lower(el.get('value'));
    i++;
  });
  i=1;
  var tmpFldAlias=fldAlias;
  while (LibJavascript.Array.indexOf(listAlias,Lower(fldAlias))!=-1){
    fldAlias=tmpFldAlias+i;
    i++;
  }
  DrawField(new Array(0,fldName,fldInfo[1],fldInfo[2],fldInfo[3],fldInfo[4],fldAlias,fldInfo[6],fldInfo[7],"","",fldIdx,false));
  if (TabPanel.getSelectedTab()!=1)
    TabPanel.setSelectedTab(1);
  SetUpdated();
}


function AddBlankField(){
  DrawField(new Array(-1,"","New Field","C","10","0","",0,false,"","",-1,false));
  SetUpdated();
}

function AddBlankCalculatedField(){
  DrawField(new Array(-1,"","New Field","C","10","0","",0,false,"","",-1,true));
  SetUpdated();
}

function SetUpdated() {
 m_bUpdated=true;
}

function changeCustom(){
  changedCustom=!changedCustom;
  SetUpdated();
}

function DrawField(dataForField){
  // 1: exp, 2: desc, 3:type, 4:len, 5:dec, 6:alias, 7:privacy, 8: identifier, 9:default value, 10:use default when, 11:index, 12:calculated field
  var myul = dataForField[12]?document.getElementById("calculatedFields_ul"):document.getElementById("fields_ul");
  var key = LibJavascript.AlfaKeyGen(10);

  var li = new Element('li', {id:'field_'+key});
  var NameColumnWidth = 190;

  var liHtml = "<span class='handler floatLeft'><span>move</span></span>";

  //Field Description
  liHtml += "<input id=\"fld_descr_"+key+"\" class='floatLeft' type=\"text\" value=\"" + ToHTML(dataForField[2]) + "\" name=\"desc\" style=\"min-width:150px; width:150px; position:absolute;\" onchange=\"SetUpdated()\">";

  //Field Name
  liHtml += "<div class=\"BoxExpander\"><input type=\"text\" value=\"" + ToHTML(dataForField[1]) + "\" name=\"name\" id=\"fld_name_" + key + "\" class=\"FieldsValue\" style=\"min-width: " + NameColumnWidth + "px;\" onchange=\"SetUpdated()\"/></div>";

  liHtml += "<div style='position:absolute; right:0;'>";

  if (!dataForField[12]){
    //Field Name Expression Builder Button
    liHtml += "<span onclick=\"ExpressionBuilder('fld_name_"+key+"')\" class='expressionBuilder' icon-data='&#xe603;'></span>";
  }


  var w=dataForField[12]?173:120;
  //Field Alias
  liHtml += "<input type=\"text\" value=\"" + ToHTML(dataForField[6]) + "\" name=\"alias\" style=\"min-width:"+w+"px; width:"+w+"px;\" onchange=\"SetUpdated()\">";

  // Field Type
  liHtml+="<div class='FieldType' onclick='toggleMaskType(\""+(dataForField[12]?"CalculatedField":"Field")+"\",\""+key+"\")'><span id='fld_type_"+key+"'>"+ ToHTML(dataForField[3])+"</span>(<span id='fld_len_"+key+"'>"+dataForField[4]+"</span>,<span id='fld_dec_"+key+"'>"+ToHTML(dataForField[5])+"</span>)</div>";

  //Default value
  liHtml+="<input type='hidden' id='fld_def_value_"+key+"' name='defaultValue' value='"+ToHTML(dataForField[9])+"'>";

  //Use default when
  liHtml+="<input type='hidden' id='fld_use_def_when_"+key+"' name='useDefaultWhen' value='"+ToHTML(dataForField[10])+"'>";

  // Data sensibility
  liHtml+="<input type='hidden' id='fld_privacy_"+key+"' name='privacy' value='"+ToHTML(dataForField[7])+"'>";

  // Data identifier
  liHtml += "<input type='hidden' id='fld_identifier_" + key + "' name='identifier' value='" + ToHTML(dataForField[8]) + "'>";

  // Data index
  liHtml += "<input type='hidden' id='fld_index_" + key + "' name='index' value='" + ToHTML(dataForField[11]) + "'>";

  if (!dataForField[12]){
    //Fields Open mask
    liHtml += "<span class='openMaskType' onclick='toggleMaskType(\"Field\",\""+key+"\")' icon-data='&#xe68e;'></span>";
  }

  //Fields Del Icon
  liHtml += "<span class=\"deleteIcon\" onclick=\"DeleteField('"+key+"')\" icon-data='&#xe6a8;'></span>";

  if (!dataForField[12])
    liHtml += "<span class=\"mover\" onclick=\"javascript:void(0)\" title=\"Move field to Orderby or Groupby zone\" icon-data='&#xe72b;'></span>"
  liHtml += "</div>";
  liHtml += "<div style='clear:both;'></div>"
  li.set('html',liHtml);
  var alias =  li.getElement('input[name=alias]');
  var expr = li.getElementById("fld_name_"+key);
  if (!dataForField[12]){
    expr.addEvent('change', function() {
      ModifyOBGBExpr(key,this.get('value'),alias.get('value'),'groupby');
      ModifyOBGBExpr(key,this.get('value'),alias.get('value'),'orderby');
      ModifyOBGBExpr(key,this.get('value'),alias.get('value'),'pivotFields');
      ModifyOBGBExpr(key,this.get('value'),alias.get('value'),'pivotData');
    });
    alias.addEvent('change', function() {
      ModifyOBGBExpr(key,expr.get('value'),this.get('value'),'groupby');
      ModifyOBGBExpr(key,expr.get('value'),this.get('value'),'orderby');
      ModifyOBGBExpr(key,expr.get('value'),this.get('value'),'pivotFields');
      ModifyOBGBExpr(key,expr.get('value'),this.get('value'),'pivotData');
    });

    li.getElementById("fld_descr_"+key).addEvent('change', function() {
      ModifyOBGBDescr(key,this.get('value'),'groupby');
      ModifyOBGBDescr(key,this.get('value'),'orderby');
      ModifyOBGBDescr(key,this.get('value'),'pivotData');
      ModifyOBGBDescr(key,this.get('value'),'pivotFields');
    });
    var mover = li.getElement("span.mover");
    mover.addEvent("mousedown", function(event) {
      event.stop();
      var pos = this.getCoordinates();
      var clone = new Element('span',{'class':'dragged'}).setStyles({'z-index':999,'top':pos.top,'left':pos.left+10,'cursor':'default'}).set('text',alias.get('value'));
      clone.inject(document.body);
      var elementsDrop = [document.getElementById('orderby_ul'),document.getElementById('groupby_ul'),document.getElementById('pivotFields_ul'),document.getElementById('pivotData_ul')];
      var drag = new Drag.Move(clone, {

        droppables: elementsDrop,

        onBeforeStart: function() {
          elementsDrop.each(function(el) {
            el.addClass('droppable');
          })
        },
        onDrop: function(dragging, drop){
          dragging.destroy();
          elementsDrop.each(function(el) {
            el.removeClass('droppable');
          });

          if (drop != null){
            if (drop.get('id')=='orderby_ul') DrawSingleOrderBy(key);
            else if (drop.get('id')=='groupby_ul') DrawSingleGroupBy(key);
            else if (drop.get('id')=='pivotFields_ul') DrawSinglePivotFields(key);
            else if (drop.get('id')=='pivotData_ul') DrawSinglePivotData(key);
            drop.removeClass('selectedDrop');
            drop.highlight('#7389AE', '#FFF');
            SetUpdated();
          }
        },
        onEnter: function(dragging, drop){
          drop.addClass('selectedDrop');
        },
        onLeave: function(dragging, drop){
          drop.removeClass('selectedDrop');
        },
        onCancel: function (/*dragging*/) {
          clone.destroy();
          elementsDrop.each(function(el) {
            el.removeClass('droppable');
          });
        }
      });
      drag.start(event);
    });

  }
    myul.adopt(li);
    sort_all.addItems(li);
  if (! (Browser.ie && Browser.version<9))
    myul.nanoScrollerMT();
}


var ChangeTypeField =function (){
  Ctrl('fld_type_'+currentFieldId).innerHTML=document.getElementById('mask_type').getElement('select').getSelected()[0].get('value');
  Ctrl('fld_len_'+currentFieldId).innerHTML=document.getElementById('mask_fld_len_'+currentFieldId).get('value');
  Ctrl('fld_dec_'+currentFieldId).innerHTML=document.getElementById('mask_fld_dec_'+currentFieldId).get('value');
  Ctrl('fld_def_value_'+currentFieldId).value=document.getElementById('mask_fld_default_value_'+currentFieldId).get('value');
  Ctrl('fld_use_def_when_'+currentFieldId).value=document.getElementById('mask_fld_use_default_when_'+currentFieldId).get('value');
  Ctrl('fld_privacy_'+currentFieldId).value=document.getElementById('mask_privacy_'+currentFieldId).get('value');
  Ctrl('fld_identifier_'+currentFieldId).value=document.getElementById('mask_fld_identifier_'+currentFieldId).get('checked');
  toggleMaskType();
}

var ChangeTypeParm =function (){
  Ctrl('parm_type_'+currentParmId).innerHTML=document.getElementById('mask_type').getElement('select').getSelected()[0].get('value');
  Ctrl('parm_len_'+currentParmId).innerHTML=document.getElementById('mask_parm_len_'+currentParmId).get('value');
  Ctrl('parm_dec_'+currentParmId).innerHTML=document.getElementById('mask_parm_dec_'+currentParmId).get('value');
  Ctrl('keep_spaces_'+currentParmId).value=document.getElementById('mask_param_keep_spaces_'+currentParmId).get('checked');
  toggleMaskType();
}

function tabMaskType(tabName){
  document.getElementById('content_tab_type').style.display=tabName=='type'?'block':'none';
  document.getElementById('content_tab_default').style.display=tabName=='default'?'block':'none';
  document.getElementById('content_tab_privacy').style.display=tabName=='privacy'?'block':'none';
  document.getElementById('tab_type').className='prop_tab';
  document.getElementById('tab_default').className='prop_tab';
  document.getElementById('tab_privacy').className='prop_tab';
  document.getElementById('tab_'+tabName).addClass('selected')
}

function toggleMaskType(name,key){
  var type, lenDisabled, decDisabled, positionDivType, position;
  var btn=document.getElementById('btnChangeType');
  btn.removeEvent('click',ChangeTypeField)
  btn.removeEvent('click',ChangeTypeParm)
  var maskType=document.getElementById('maskType');
  if (name=='Field' || name=='CalculatedField'){
    if (maskType.style.visibility=='visible' && (!key || key==currentFieldId)){
      maskType.style.visibility='hidden';
      maskType.setStyles({
        top:0,
        left:0
      })
    }
    else{
      currentFieldId=key;
      if (name=='Field'){
        Ctrl('mask_privacy_tr').style.display='';
        Ctrl('mask_identifier_tr').style.display='';
        Ctrl('mask_default_value_div').style.display='';
        Ctrl('mask_use_default_when_div').style.display='';
        Ctrl('maskTypeTab').style.display='';
        Ctrl('mask_keep_spaces_tr').style.display='none';
      }
      else {
        Ctrl('mask_privacy_tr').style.display='none';
        Ctrl('mask_identifier_tr').style.display='none';
        Ctrl('mask_use_default_when_div').style.display='none';
        Ctrl('maskTypeTab').style.display='none';
        Ctrl('mask_keep_spaces_tr').style.display='none';
      }

      maskType.style.visibility='visible';

      Ctrl('maskTypeTitle').innerHTML=document.getElementById('field_'+currentFieldId).getElement('[name=alias]').get('value');

      //Field Type
      type=document.getElementById('fld_type_'+currentFieldId).get('text');
      Ctrl('mask_type').innerHTML = DrawTypeCombo(type, "Field", key);

      lenDisabled=(type=="D"||type=="L"||type=="T")
      Ctrl('mask_len').innerHTML="<input id='mask_fld_len_"+key+"'"+(lenDisabled?" readOnly":"")+" type=\"text\" value=\"" + document.getElementById('fld_len_'+currentFieldId).get('text') + "\" name=\"len\" size='1' onkeypress=CheckNum onchange=\"SetUpdated()\">";

      decDisabled=(type!="N")
      Ctrl('mask_dec').innerHTML= "<input id='mask_fld_dec_"+key+"'"+(decDisabled?" readOnly":"")+" type=\"text\" value=\"" + document.getElementById('fld_dec_'+currentFieldId).get('text') + "\" name=\"dec\" size='1' onkeypress=CheckNum onchange=\"SetUpdated()\">";
      btn.addEvent('click',ChangeTypeField)

      Ctrl('mask_default_value').innerHTML= "<input id='mask_fld_default_value_"+key+"' type=\"text\" value=\"" + document.getElementById('fld_def_value_'+currentFieldId).get('value') + "\" name=\"defaultValue\" size='25' onchange=\"SetUpdated()\">";
      Ctrl('mask_use_default_when').innerHTML= "<input id='mask_fld_use_default_when_"+key+"' type=\"text\" value=\"" + document.getElementById('fld_use_def_when_'+currentFieldId).get('value') + "\" name=\"useDefaultWhen\" size='25' onchange=\"SetUpdated()\">";


      Ctrl('mask_privacy').innerHTML = DrawDataSensibilityCombo(document.getElementById('fld_privacy_'+currentFieldId).value, key);
      Ctrl('mask_identifier').innerHTML = "<input id='mask_fld_identifier_"+key+"' type='checkbox' value='' name='identifier' onchange='SetUpdated()' style='vertical-align:text-bottom; width:auto;' "+(document.getElementById('fld_identifier_'+currentFieldId).value=="true"?"checked":"")+">";

      //posizionamento maschera
      positionDivType=document.getElementById('fld_type_'+currentFieldId).getPosition();
      position=positionDivType;
      position.x-=(maskType.getSize().x+10)
      if (position.y+maskType.getSize().y>window.getSize().y)
        position.y=window.getSize().y-maskType.getSize().y
      maskType.setStyles({
        top:position.y,
        left:position.x
      })
    }
    tabMaskType('type');
  }
  else if (name=='Param'){
    if (maskType.style.visibility=='visible' && (!key || key==currentParmId)){
      maskType.style.visibility='hidden';
      maskType.setStyles({
        top:0,
        left:0
      })
    }
    else{
      currentParmId=key;
      Ctrl('mask_privacy_tr').style.display='none';
      Ctrl('mask_identifier_tr').style.display='none';
      Ctrl('mask_default_value_div').style.display='none';
      Ctrl('mask_use_default_when_div').style.display='none';
      Ctrl('maskTypeTab').style.display='none';
		Ctrl('mask_keep_spaces_tr').style.display='';

      maskType.style.visibility='visible';

      Ctrl('maskTypeTitle').innerHTML=document.getElementById('param_'+currentParmId).getElement('[name=name]').get('value');

     //Param Type
      type=document.getElementById('parm_type_'+currentParmId).get('text');
      Ctrl('mask_type').innerHTML = DrawTypeCombo(type, name, key);

      lenDisabled=(type=="D"||type=="L"||type=="T")
      Ctrl('mask_len').innerHTML="<input id='mask_parm_len_"+key+"'"+(lenDisabled?" readOnly":"")+" type=\"text\" value=\"" + document.getElementById('parm_len_'+currentParmId).get('text') + "\" name=\"len\" size='1' onkeypress=CheckNum onchange=\"SetUpdated()\">";

      decDisabled=(type!="N")
      Ctrl('mask_dec').innerHTML= "<input id='mask_parm_dec_"+key+"'"+(decDisabled?" readOnly":"")+" type=\"text\" value=\"" + document.getElementById('parm_dec_'+currentParmId).get('text') + "\" name=\"dec\" size='1' onkeypress=CheckNum onchange=\"SetUpdated()\">";
      Ctrl('mask_keep_spaces').innerHTML = "<input id='mask_param_keep_spaces_"+key+"' type='checkbox' value='' name='keepSpaces' onchange='SetUpdated()' style='vertical-align:text-bottom; width:auto;' "+(document.getElementById('keep_spaces_'+currentParmId).value=="true"?"checked":"")+">";
      btn.addEvent('click',ChangeTypeParm)

      //posizionamento maschera
      positionDivType=document.getElementById('parm_type_'+currentParmId).getPosition();
      position=positionDivType;
      position.x-=(maskType.getSize().x+10)
      if (position.y+maskType.getSize().y>window.getSize().y)
        position.y=window.getSize().y-maskType.getSize().y
      maskType.setStyles({
        top:position.y,
        left:position.x
      })
      tabMaskType('type');
    }
  }
  else { // ho premuto la 'x'
    maskType.style.visibility='hidden';
    maskType.setStyles({
      top:0,
      left:0
    })
  }
}

function DrawDataSensibilityCombo(preselected,id){
  var sel = "<select id='mask_privacy_"+id+"' name=\"fprivacy\" onchange='SetUpdated()'>";
  var privacy=["Not defined","Ruled-Health","Ruled-Sensible","Ruled-Judicial","Ruled-Personal","Ruled-Specific Risk","Private","Public","Profiled","Secret"]

  for (var j=0; j<privacy.length; j++){
    var sSelected = (preselected==j) ? " selected" : "";
    sel += "<option" + sSelected + " value=\"" + j + "\">" + privacy[j] + "</option>\n";
  }
  sel += "</select>";
  return sel;
}

function DrawTypeCombo(preselected, returnFunc, id, cssClass){
  if (!cssClass) cssClass="";
  var selRet = "<select id='mask_type_"+id+"' class='"+cssClass+"' onchange=\"Set"+returnFunc+"Combo('"+id+"')\" name=\"ftype\">";
  var types1 = new Array("Char", "Numeric", "Date", "Logic", "Memo", "DateTime");
  var types2 = new Array("C"   , "N"      , "D"   , "L"    , "M"   , "T"       );

  for (var j=0; j<types1.length; j++){
    var sSelected = (Upper(preselected)==Upper(types2[j])) ? " selected" : "";
    selRet += "<option" + sSelected + " value=\"" + types2[j] + "\">" + types1[j] + "</option>\n";
  }
  selRet += "</select>";
  return selRet;
}

function DeleteField(id, notAskConfirm){
  if (notAskConfirm || confirm("Do you want delete field?")) {
    var curField = document.getElementById('field_'+id);
    DeleteItem(curField);
    if (! (Browser.ie && Browser.version<9))
      document.getElementById("fields_ul").nanoScrollerMT();
    DeleteOrderBy(id);
    DeleteGroupBy(id);
    DeletePivotData(id);
    DeletePivotFields(id);
  }
}

/* La chiamata viene costruita in DrawTypeCombo */
function SetFieldCombo(id){
  var cboValue = document.getElementById("mask_type_"+id).getSelected()[0].get('value');
  var lenObj = Ctrl("mask_fld_len_"+id)
  var decObj = Ctrl("mask_fld_dec_"+id)
  switch (cboValue) {
    case 'M':
    case 'C':
      decObj.value="0";
      lenObj.readOnly=false;
      decObj.readOnly="true"
    break;
    case 'N':
      lenObj.readOnly=false;
      decObj.readOnly=false;
    break;
    case 'D':
      lenObj.value="8";
      decObj.value="0";
      lenObj.readOnly="true";
      decObj.readOnly="true";
    break;
    case 'L':
      lenObj.value="1";
      decObj.value="0";
      lenObj.readOnly="true";
      decObj.readOnly="true";
    break;
    case 'T':
      lenObj.value="14";
      decObj.value="0";
      lenObj.readOnly="true";
      decObj.readOnly="true";
    break;
  }
  SetUpdated();
}

function ModifyOBGBDescr(key,value,zoneType) {
  var el = document.getElementById(zoneType+'_'+key);
  if (el) {
    var span = el.getElement("span.desc");
    span.set('text',value);
  }
}

function ModifyOBGBExpr(key,name,alias,zoneType) {
  var el = document.getElementById(zoneType+'_'+key);
  if (el) {
    var span = el.getElement("div.field");
    span.set('text',GetFieldAlias(name, alias));
  }
}

function DrawSinglePivotFields(key){
  var myul=document.getElementById("pivotFields_ul");
  var curPivotField=myul.getElement('li[id=pivotFields_'+key+']');
  if (curPivotField!=null) return;
  var curPivotData=document.getElementById("pivotData_ul").getElement('li[id=pivotData_'+key+']');
  if (curPivotData!=null) return; // non posso avere gli stessi campi nel pivotField e pivotData
  var field=document.getElementById('field_'+key);
  var li=new Element('li',{id:'pivotFields_'+key});
  var liHtml = "<span class='handler floatLeft'><span>move</span></span>";
  liHtml+="<span class='textClipped floatLeft desc' style='width:120px;'>"+field.getElement('input[name=desc]').get('value')+"</span>"
  liHtml += "<div style=\"position:absolute;display:inline-block;left:155px;right:87px;min-width:100px;\" class='textClipped field'>"+GetFieldAlias(field.getElement('input[name=name]').get('value'), field.getElement('input[name=alias]').get('value'))+"</div>"
  liHtml += "<span class=\"floatRight deleteIcon\" onclick=\"DeletePivotFields('"+key+"')\" icon-data='&#xe6a8;' style='margin-right:2px;'></span>";
  liHtml += "<div style='clear:both;'></div>"
  li.set('html',liHtml);
  myul.adopt(li);
  sort_all.addItems(li);
  if (! (Browser.ie && Browser.version<9))
    myul.nanoScrollerMT();
}

function DeletePivotFields(key){
  var curPivotField = document.getElementById('pivotFields_'+key);
  if (curPivotField) {
    DeleteItem(curPivotField);
    if (! (Browser.ie && Browser.version<9))
      document.getElementById("pivotFields_ul").nanoScrollerMT();
  }
}

function DrawSinglePivotData(key, aggregateFunc){
  if (!aggregateFunc) aggregateFunc = 'SUM';
  var myul=document.getElementById("pivotData_ul");
  var curPivotData=myul.getElement('li[id=pivotData_'+key+']');
  if (curPivotData!=null) return;
  var curPivotField=document.getElementById("pivotFields_ul").getElement('li[id=pivotFields_'+key+']');
  if (curPivotField!=null) return; //non posso avere gli stessi campi nel pivot field e pivot data
  var field=document.getElementById('field_'+key);
  var li=new Element('li',{id:'pivotData_'+key});
  var liHtml = "<span class='handler floatLeft'><span>move</span></span>";
  liHtml+="<span class='textClipped floatLeft desc' style='width:120px;'>"+field.getElement('input[name=desc]').get('value')+"</span>"
  liHtml += "<div style=\"position:absolute;display:inline-block;left:155px;right:87px;min-width:100px;\" class='textClipped field'>"+GetFieldAlias(field.getElement('input[name=name]').get('value'), field.getElement('input[name=alias]').get('value'))+"</div>"
  liHtml += "<div class=\"floatRight\">";
  liHtml += "<select class='aggregateFunc' onChange='SetUpdated();'><option "+(aggregateFunc=='AVG'?"selected ":"")+"value=\"AVG\">AVG</option><option "+(aggregateFunc=='MAX'?"selected ":"")+"value=\"MAX\">MAX</option><option "+(aggregateFunc=='MIN'?"selected ":"")+"value=\"MIN\">MIN</option><option "+(aggregateFunc=="SUM"?"selected ":"")+"value=\"SUM\">SUM</option><option "+(aggregateFunc=="COUNT"?"selected ":"")+"value=\"COUNT\">COUNT</option></select>";
  liHtml += "<span class=\"deleteIcon\" onclick=\"DeletePivotData('"+key+"')\" icon-data='&#xe6a8;' style='margin-right:4px;margin-left:4px;'></span>";
  liHtml += "</div>";
  liHtml += "<div style='clear:both;'></div>"
  li.set('html',liHtml);
  myul.adopt(li);
  sort_all.addItems(li);
  if (! (Browser.ie && Browser.version<9))
    myul.nanoScrollerMT();
}

function DeletePivotData(key){
  var curPivotData = document.getElementById('pivotData_'+key);
  if (curPivotData) {
    DeleteItem(curPivotData);
    if (! (Browser.ie && Browser.version<9))
      document.getElementById("pivotData_ul").nanoScrollerMT();
  }
}

function DrawSingleOrderBy(key, orderby){
    if (!orderby) orderby = "Ascending";
    var myul = document.getElementById("orderby_ul");
    var curOrderBy = myul.getElement('li[id=orderby_'+key+']');
    if (curOrderBy != null) return;

    var field = document.getElementById('field_'+key);
    var li = new Element('li', {id:'orderby_'+key});
    var liHtml = "<span class='handler floatLeft'><span>move</span></span>";

    //OrderBy Description
    liHtml += "<span class='textClipped floatLeft desc' style='width:120px;'>"+field.getElement('input[name=desc]').get('value')+"</span>"
    //OrderBy tablename.fieldname
    liHtml += "<div style=\"position:absolute;display:inline-block;left:155px;right:87px;min-width:100px;\" class='textClipped field'>"+GetFieldAlias(field.getElement('input[name=name]').get('value'), field.getElement('input[name=alias]').get('value'))+"</div>"

    liHtml += "<div class=\"floatRight\">";
    //Order
    liHtml += "<select class='order' onChange='SetUpdated();'><option "+(orderby=="Ascending"?"selected ":"")+"value=\"Ascending\">Asc</option><option "+(orderby=="Descending"?"selected ":"")+"value=\"Descending\">Desc</option></select>";

    //Order By Del
    liHtml += "<span class=\"deleteIcon\" onclick=\"DeleteOrderBy('"+key+"')\" icon-data='&#xe6a8;' style='margin-right:2px;'></span>";

    liHtml += "</div>";
    liHtml += "<div style='clear:both;'></div>"
    li.set('html',liHtml);
    myul.adopt(li);
    sort_all.addItems(li);
    if (! (Browser.ie && Browser.version<9))
      myul.nanoScrollerMT();
}

function GetFieldAlias(fldName, fldAlias){
  if (Empty(fldAlias)) return fldName;
  else return fldAlias;
}

function DeleteOrderBy(key){
  var curOrderby = document.getElementById('orderby_'+key);
  if (curOrderby) {
    DeleteItem(curOrderby);
    if (! (Browser.ie && Browser.version<9))
      document.getElementById("orderby_ul").nanoScrollerMT();
  }
}

function DrawSingleGroupBy(key) {
    var myul = document.getElementById("groupby_ul");
    var curGroupBy = myul.getElement('li[id=groupby_'+key+']');
    if (curGroupBy != null) return;

    var field = document.getElementById('field_'+key);
    var li = new Element('li', {id:'groupby_'+key});
    var liHtml = "<span class='handler floatLeft'><span>move</span></span>";

    //GroupBy Description
    liHtml += "<span class='textClipped floatLeft desc' style='width:120px;'>"+field.getElement('input[name=desc]').get('value')+"</span>"
    //GroupBy tablename.fieldname
    liHtml += "<div class=\"textClipped field\" style='position:absolute;display:inline-block;left:155px;right:35px;min-width:100px;'>"+GetFieldAlias(field.getElement('input[name=name]').get('value'), field.getElement('input[name=alias]').get('value'))+"</div>"

    //Group By Del
    liHtml += "<span class=\"floatRight deleteIcon\" onclick=\"DeleteGroupBy('"+key+"')\" icon-data='&#xe6a8;' style='margin-right:2px;'></span>";
    liHtml += "<div style='clear:both;'></div>"
    li.set('html',liHtml);
    myul.adopt(li);
    sort_all.addItems(li);
    if (! (Browser.ie && Browser.version<9))
      myul.nanoScrollerMT();
}

function DeleteGroupBy(key){
  var curGroupby = document.getElementById('groupby_'+key);
  if (curGroupby) {
    DeleteItem(curGroupby);
    if (! (Browser.ie && Browser.version<9))
      document.getElementById("groupby_ul").nanoScrollerMT();
  }
}

function GetFieldUsedKey(fldName){
  var idFound = null
  $$('#fields_ul li').each(function(li) {
    if (li.getElement('input[name=name]').get('value') == fldName ||  li.getElement('input[name=alias]').get('value') == fldName) {
      idFound = Right(li.id,Len(li.id)-6);
      return;
    }
  });
  return idFound;
}

//------------------------ JOIN -----------------------------------
function AddBlankJoin(){
  DrawSingleJoin(new Array("","","Left outer","","","",""));
  SetUpdated();
}

function AddJoin(){
  var relIdx=parseInt(o_dictRelations.getSelectedRow());
  if (relIdx<0) return;
  var tblIdx = parseInt(o_dictTables.getSelectedRow());
  AddJoin2(relIdx, tblIdx, true);
  TabPanel.setSelectedTab(3);
  SetUpdated();
}

function AddJoin2(relIdx, tblIdx, addTables){
  var relatedTableIdx = -1;
  var relationInfo = allTables[tblIdx][3][relIdx];
  var tbl1Alias, tbl2Alias, expression;
  if (addTables){
    if (!CheckTableUsed(relationInfo[2])){
      relatedTableIdx=GetTableIdx(relationInfo[2]);
      AddTableByIdx(relatedTableIdx);
    }
    if (!CheckTableUsed(allTables[tblIdx][0])){
      AddTableByIdx(tblIdx);
    }
  }
  if (relatedTableIdx==-1)
    relatedTableIdx=GetTableIdx(relationInfo[2]);

  if (relationInfo[5]==1){
    tbl1Alias = GetLastTableAlias(relationInfo[2]);
    tbl2Alias = GetLastTableAlias(allTables[tblIdx][0]);
    expression = CreateJoinExp(relationInfo[3], relationInfo[1], tbl1Alias, tbl2Alias);
  } else {
    tbl1Alias = GetLastTableAlias(allTables[tblIdx][0]);
    tbl2Alias = GetLastTableAlias(relationInfo[2]);
    expression = CreateJoinExp(relationInfo[1], relationInfo[3], tbl1Alias, tbl2Alias);
  }

  var addJoin = true;
  $$('#joins_ul li').each(function (el) {
    var tb1 = el.getElement("select[name=tb1]").getSelected()[0].get('value');
    var tb2 = el.getElement("select[name=tb2]").getSelected()[0].get('value');
    if (Upper(tbl1Alias)==Upper(tbl2Alias) || (Upper(tb1)==Upper(tbl1Alias) && Upper(tb2)==Upper(tbl2Alias)) || (Upper(tb1)==Upper(tbl2Alias) && Upper(tb2)==Upper(tbl1Alias))){
      addJoin = false;
    }
  });
  if (addJoin) {
    var relationDesc="";
    for(var i=0; i<allTables[relatedTableIdx][3].length && relationDesc==""; i++){
      if(allTables[relatedTableIdx][3][i][2]==allTables[tblIdx][0])
        relationDesc=allTables[relatedTableIdx][3][i][0];
    }
    DrawSingleJoin(new Array(relationDesc, expression, relationInfo[4], tbl1Alias, tbl2Alias, tblIdx, relIdx));
  }
}

function CreateJoinExp(tbl1Fields, tbl2Fields, tbl1Alias, tbl2Alias){
  tbl1Fields=tbl1Fields+",";
  tbl2Fields=tbl2Fields+",";
  var posVir1 = At(',',tbl1Fields);
  var posVir2 = At(',',tbl2Fields);
  var fld1, fld2, res="";

  while(posVir1>0){
    fld1=Left(tbl1Fields,posVir1-1);
    fld2=Left(tbl2Fields,posVir2-1);
    tbl1Fields=Substr(tbl1Fields,posVir1+1)
    tbl2Fields=Substr(tbl2Fields,posVir2+1)
    if(!Empty(res))
      res+=" and ";
    res+=tbl1Alias+"."+fld1+"="+tbl2Alias+"."+fld2;
    posVir1 = At(',',tbl1Fields);
    posVir2 = At(',',tbl2Fields);
  }
  return res;
}

function DeleteJoin(id){
  var curJoin = document.getElementById('join_'+id);
  DeleteItem(curJoin);
  if (! (Browser.ie && Browser.version<9))
    document.getElementById("joins_ul").nanoScrollerMT();
}

function DrawSingleJoin(currentJoin){
  var myul = document.getElementById("joins_ul");
  var key = LibJavascript.AlfaKeyGen(10);

  var li = new Element('li', {id:'join_'+key});

  var DescColumnWidth = 232
  var ExprColumnWidth = 358

  var liHtml = "<span class='handler floatLeft'><span>move</span></span>";

  //Join Description
  liHtml += "<input class=\"floatLeft\" type=\"text\" value=\"" + ToHTML(currentJoin[0]) + "\" onchange=\"SetUpdated()\" name=\"desc\" style=\"width:25%;min-width: "+DescColumnWidth+"px\">";

  //Join Expression
  liHtml += "<div class=\"BoxExpander\" style=\"left:25%;right:320px;margin-left:20px;\"><input id=\"join_exp_"+key+"\" type=\"text\" value=\"" + ToHTML(currentJoin[1]) + "\" onchange=\"SetUpdated()\" name=\"exp\" style=\"width:100%;min-width: "+ExprColumnWidth+"px\"></div>";

  liHtml += "<div class=\"floatRight\">";
  //Join Expression Expression Builder Button
  liHtml += "<span onclick=\"ExpressionBuilder('join_exp_"+key+"')\" class='expressionBuilder' icon-data='&#xe603' style='margin-right:6px;'></span>";

  //Join Type
  liHtml += DrawJoinTypeCombo(currentJoin[2]);

  //Join Table 1
  liHtml += DrawTableCombo(currentJoin[3], "tb1");

  //Join Table 2
  liHtml += DrawTableCombo(currentJoin[4], "tb2");

  //Join Del
  liHtml += "<span class=\"deleteIcon\" onclick=\"DeleteJoin('"+key+"')\" icon-data='&#xe6a8;' style='margin-left:8px; margin-right:5px;'></span>";

  liHtml += "</div><div style=\"clear:both;\"></div>";
  li.set('html',liHtml);
  myul.adopt(li);
  sort_all.addItems(li);
  if (! (Browser.ie && Browser.version<9))
    myul.nanoScrollerMT();
}

function DrawTableCombo(preselected, wTbl){
  var selRet = "<select style=\"width:90px;\" onchange=\"SetUpdated()\" name=\"" + wTbl + "\"><option></option>";
  $$('#tables_ul li input[name=alias]').each(function(el) {
    var sSelected = (preselected==el.get('value')) ? " selected":"";
    selRet += "<option" + sSelected + "  title=\""+ el.get('value') +"\">" + el.get('value') + "</option>\n";
  });
  selRet += "</select>";
  return selRet;
}

function DrawJoinTypeCombo(preselected){
  var selRet = "<select style=\"width: 85px;\" onchange=\"SetUpdated()\" name=\"jtype\" style=\"width: 100%\">";
  var types = new Array("Left outer", "Right outer", "Inner", "Full", "Where");
  for (var j=0; j<types.length; j++){
    var sSelected = (Upper(preselected)==Upper(types[j])) ? " selected":"";
    selRet += "<option" + sSelected + ">" + types[j] + "</option>\n";
  }
  selRet += "</select>";
  return selRet;
}

//------------------------ FILTERS -----------------------------------
function AddBlankFilter(){
  DrawSingleFilter(new Array("", false, "=", "", "AND", false,""));
  SetUpdated();
}

function AddFieldToFilter(tblIdx,fldIdx){
  var fldInfo,fldName;

  var aliasTable;
  if(!CheckTableUsed(allTables[tblIdx][0])){
    aliasTable = AddTableByIdx(tblIdx)[3];
  } else  {
    aliasTable = GetLastTableAlias(allTables[tblIdx][0]);
  }

  fldInfo=allTables[tblIdx][2][fldIdx];
  if (fldInfo[0].startsWith('[J(') || fldInfo[0].startsWith('[X(')) {
    fldName = fldInfo[0];
  }
  else {
    fldName=aliasTable+"."+(/* simplemode ? Lower(fldInfo[0]) : */ fldInfo[0]);
  }
  DrawSingleFilter(new Array(fldName,false,"=","","AND",false,""));
  SetUpdated();
}

function DrawSingleFilter(filterData){
  var myul = document.getElementById("filters_ul");
  var key = LibJavascript.AlfaKeyGen(10);

  var li = new Element('li', {id:'filter_'+key});
  var NameColumnWidth = 232;
  var SampColumnWidth = 280;


  var liHtml = "<span class='handler floatLeft'><span>move</span></span>";

  //Filter Field Name

  liHtml += "<input class=\"floatLeft\" id=\"filter_fld_"+key+"\" type=\"text\" value=\"" + ToHTML(filterData[0]) + "\" onchange=\"SetUpdated()\" name=\"field\" style=\"width: "+NameColumnWidth+"px;width:25%; margin-right:5px;\">";

  //Filter Field Name Expression Builder button
  liHtml += "<span onclick=\"ExpressionBuilder('filter_fld_"+key+"')\" class='expressionBuilder floatLeft' icon-data='&#xe603' style='margin-top:5px;'></span>";

  //Filter NOT
  var notChecked = (filterData[1] == true) ? " checked":"";
  liHtml += "<div style='display:inline-block;'><input  type=\"checkbox\"" + notChecked + " name=\"not\" onchange=\"SetUpdated()\">Not</div>";

  //Filter criteria
  liHtml += DrawCriteriaCombo(filterData[2]);

  //Filter example
  liHtml += "<div class=\"BoxExpander\" style=\"left:calc(175px + 25%);right:430px;\"><input id=\"filter_example_"+key+"\" type=\"text\" value=\"" + ToHTML(filterData[3]) + "\" onchange=\"SetUpdated()\" name=\"example\" style=\"width:100%;\"></div>";

  liHtml += "<div class=\"floatRight\">";

  //Filter example Expression Builder button
  liHtml += "&nbsp;<span onclick=\"FilterExampleAction('"+key+"')\" class='expressionBuilder' icon-data='&#xe603;' style='margin-right:4px;'></span>";

  //Use filter when
  liHtml += "<input id=\"use_filter_when_"+key+"\" type=\"text\" value=\"" + ToHTML(filterData[6]) + "\" onchange=\"SetUpdated()\" name=\"useFilterWhen\" style=\"width: "+SampColumnWidth+"px;\">";

  //Filter logical
  var andChecked = (filterData[4]== "AND") ? " selected":"";
  var orChecked  = (filterData[4]== "OR") ? " selected":"";
  liHtml += "<select name=\"logical\" onchange=\"SetUpdated()\"><option" + andChecked + ">AND</option><option" + orChecked + ">OR</option></select>";

  //Filter having
  var havingChecked = (filterData[5]==true) ? " checked":""
  liHtml += "<input type=\"checkbox\"" + havingChecked + " name=\"having\" onchange=\"SetUpdated()\">Having"

  //Filter Del
  liHtml += "<span class=\"deleteIcon\" onclick=\"DeleteFilter('"+key+"')\" icon-data='&#xe6a8;'></span>";

  liHtml += "</div><div style=\"clear:both;\"></div>";

  li.set('html',liHtml);
  myul.adopt(li);
  sort_all.addItems(li);
  if (! (Browser.ie && Browser.version<9))
    myul.nanoScrollerMT();
}

function FilterExampleAction(key) {
  var curFilter = document.getElementById("filter_"+key);
  if (FilterUsesFile(curFilter.getElement("select[name=criteria]").getSelected()[0].get('value'),curFilter.getElement("input[name=example]").get('value'))) {
    exampleInput = 'filter_example_'+key;
    GetFilename('filters');
  } else {
    ExpressionBuilder('filter_example_'+key)
  }
}
function FilterUsesFile(criteria,value){
  var criterias = new Array("in", "not in", "exists", "not exists", "> all", "> any", "< all", "< any", ">= all", ">= any", "<= all", "<= any", "<> all", "<> any");
  return LibJavascript.Array.indexOf(criterias,criteria)>=0 && Left(value,1)!="(";
}

function DrawCriteriaCombo(preselected){
  var selRet = "<select style=\"display:inline-block;\" name=\"criteria\" onchange=\"SetUpdated()\">";
  var criterias = new Array("=", "like", ">", "<", ">=", "<=", "<>", "in", "not in", "exists", "not exists", "between", "not between", "is null", "is not null", "> all", "> any", "< all", "< any", ">= all", ">= any", "<= all", "<= any", "<> all", "<> any");
  for (var j=0; j<criterias.length; j++){
    var sSelected = (Upper(preselected) == Upper(criterias[j])) ? " selected":"";
    selRet += "<option" + sSelected + ">" + (criterias[j]) + "</option>\n";
  }
  selRet += "</select>";
  return selRet;
}

function DeleteFilter(id){
  var curFilter = document.getElementById('filter_'+id);
  DeleteItem(curFilter);
  if (! (Browser.ie && Browser.version<9))
    document.getElementById("filters_ul").nanoScrollerMT();
}

function GetFiltersFile(){
  document.id(exampleInput).value = tempFilename;
}

//------------------------ PARAMETERS -----------------------------------
function AddBlankParameter(){
  DrawSingleParameter(new Array("", "", "C", "0", "0", false,"","",false));
  SetUpdated();
}

function AddFieldToParam(tblIdx,fldIdx){
  var fldInfo;
  var fldName,fldAlias,pname;

  var aliasTable;
  if(!CheckTableUsed(allTables[tblIdx][0])){
    aliasTable = AddTableByIdx(tblIdx)[3];
  } else  {
    aliasTable = GetLastTableAlias(allTables[tblIdx][0]);
  }
  fldInfo=allTables[tblIdx][2][fldIdx];
  // 0  Field name        |
  // 1  Description       |
  // 2  Type              |
  // 3  Length            |
  // 4  Decimal length    |
  // 5  Remove on empty   |

  if (fldInfo[0].startsWith('[J(') || fldInfo[0].startsWith('[X(')) {
    fldName = fldInfo[0];
    fldAlias = fldName.substring(fldName.indexOf(',') +1, fldName.length-2);
  }
  else {
    fldAlias=fldInfo[0];
    fldName = aliasTable + "." + (/* simplemode ? Lower(fldAlias) : */ fldAlias);
  }

  pname="p"+fldAlias;
  /* Controllo se il campo era stato aggiunto in precedenza, in questo caso, aggiungo il numero */
  var numPar=0;
  var paramSuffix;
  $$('#parameters_ul input[name=name]').each(function(el) {
    if(Substr(el.get('value'),1,Len(pname))==pname) {
      paramSuffix=Substr(el.get('value'),Len(pname)+1); //caso: CodArt e CodArtOrd hanno lo stesso inizio
      if(Empty(paramSuffix) || paramSuffix>0) numPar++;
    }
  });
  if(numPar>0) pname+=numPar;

  DrawSingleParameter(new Array(pname,fldInfo[1],fldInfo[2],fldInfo[3],fldInfo[4],false,"","",false));
  DrawSingleFilter(new Array(fldName,false,"=","?"+pname,"AND",false,""));
  SetUpdated();
}

function DrawSingleParameter(currentParam){
  var myul = document.getElementById("parameters_ul");
  var key = LibJavascript.AlfaKeyGen(10);

  var li = new Element('li', {id:'param_'+key});

  var NameColumnWidth = 220, DescColumnWidth = 250;

  var liHtml = "<span class='handler floatLeft'><span>move</span></span>";

  //Param Field Name
  liHtml += "<input class=\"floatLeft\" type=\"text\" value=\"" + currentParam[0] + "\" name=\"name\" onchange=\"SetNameParamValue(this)\" onfocus=\"FocusNameParam(this)\" style=\"min-width: "+NameColumnWidth+"px;width:20%;\">";

  //Param desc
  liHtml += "<input type=\"text\" value=\"" + currentParam[1] + "\" name=\"desc\" onchange=\"SetUpdated()\" style=\"min-width: "+DescColumnWidth+"px;width:20%;\">";
  //Param type
  liHtml+="<div class='FieldType' onclick='toggleMaskType(\"Param\",\""+key+"\")' style='padding-left:0px; padding-right:5px;'><span id=parm_type_"+key+">"+currentParam[2]+"</span>(<span id=parm_len_"+key+">"+currentParam[3]+"</span>,<span id=parm_dec_"+key+">"+currentParam[4]+"</span>)</div>"


  liHtml += "<div class=\"BoxExpander\" style=\"left:max(calc(40% + 65px), 525px);right:80px;\">";

  //Check expression
  liHtml+="<input type=\"text\" value=\"" + currentParam[7] + "\" name=\"checkExpr\" onchange=\"SetUpdated()\" id=\"check_expression_"+key+"\" style=\"min-width:200px;width:50%\">";

  //Default on empty
  liHtml+="<input type=\"text\" value=\"" + currentParam[6] + "\" name=\"defOnEmpty\" onchange=\"SetUpdated()\" id=\"default_on_empty_"+key+"\" style=\"min-width:200px;width:50%\">";

  liHtml+="</div>"

  liHtml += "<div class=\"floatRight\" style=''>";

  liHtml += "&nbsp;<span onclick=\"ExpressionBuilder('default_on_empty_"+key+"')\" class='expressionBuilder' icon-data='&#xe603;' style='margin-right:9px;'></span>";


  //Param remove on empty
  var havingChecked = (currentParam[5] == true) ? " checked":"";
  liHtml += "<input name=\"remove\" type=\"checkbox\"" + havingChecked + " onchange=\"SetUpdated()\">";

// Keep spaces
  liHtml+="<input type='hidden' id='keep_spaces_"+key+"' name='keepSpaces' value='"+currentParam[8]+"'>";
  //Param Del
  liHtml += "<span class=\"deleteIcon\" onclick=\"DeleteParam('"+key+"')\" icon-data='&#xe6a8;' style='margin-right:18px;'></span>";

  liHtml += "</div><div style=\"clear:both;\"></div>";

  li.set('html',liHtml);
  myul.adopt(li);
  sort_all.addItems(li);
  if (! (Browser.ie && Browser.version<9))
    myul.nanoScrollerMT();
}

function SetNameParamValue(el) {
  var oldValue = el.get('oldValue');
  var newValue = el.get('value');
  $$('#filters_ul input[name=example]').each(function(el) {
    if (el.get('value')=="?"+oldValue)
      el.value = "?"+newValue;
  });
  el.set('oldValue',newValue);
  SetUpdated();
}

function FocusNameParam(el) {
  el.set('oldValue',el.get('value'));
}

function DeleteParam(key){
  var curParam = document.getElementById('param_'+key);
  var pname = "?"+curParam.getElement("input[name=name]").get('value');
  $$('#filters_ul input[name=example]').each(function(el) {
    if (el.get('value')==pname) DeleteFilter(Right(el.id,Len(el.id)-Len('filter_example_')));
  });
  DeleteItem(curParam);
  if (! (Browser.ie && Browser.version<9))
    document.getElementById("parameters_ul").nanoScrollerMT();
}

function SetParamCombo(id){
  var cboValue = document.getElementById("mask_type_"+id).getSelected()[0].get('value');
  var lenObj = Ctrl("mask_parm_len_"+id)
  var decObj = Ctrl("mask_parm_dec_"+id)
  switch (cboValue) {
    case 'M':
    case 'C':
      decObj.value="0";
      lenObj.readOnly=false;
      decObj.readOnly="true"
    break;
    case 'N':
      lenObj.readOnly=false;
      decObj.readOnly=false;
    break;
    case 'D':
      lenObj.value="8";
      decObj.value="0";
      lenObj.readOnly="true";
      decObj.readOnly="true";
    break;
    case 'L':
      lenObj.value="1";
      decObj.value="0";
      lenObj.readOnly="true";
      decObj.readOnly="true";
    break;
    case 'T':
      lenObj.value="14";
      decObj.value="0";
      lenObj.readOnly="true";
      decObj.readOnly="true";
    break;
  }
  SetUpdated();
}

function AppendQueryParameter(parameters,queryname,ignore) {
  var url = new JSURL("../servlet/SPVQRProxy?action=vqrparameters&filename="+URLenc(queryname)+
                                           "&offlinemode="+URLenc(offlinemode) +
                                           (ignore ? '&ignoreparameters='+URLenc(ignore): ''),true);
  var output=url.Response();
  output = JSON.parse(output);
  var bExists, i , j;
  for (i=0;i<output.length;i++) {
    // if (ignore!=null && ignore.indexOf(output[i][0])==-1) { //escludo i parametri da ignorare
    bExists=false;
    for (j=0; j<parameters.length && !bExists; j++){
      if (parameters[j][0]==output[i][0])
        bExists=true;
    }
    if (!bExists)
      parameters.push(output[i]);
    // }
  }

}
/* Metodo che restituisce un'array contenente tutti i parametri usati nella query */
function GetParametersArray(){
  var parameters = new Array();

  //I parametri usati direttamente
  $$('#parameters_ul li').each(function (li) {
    var id=li.id.split('_')[1];
    parameters.push(new Array(li.getElement('input[name=name]').get('value'),li.getElement('input[name=desc]').get('value'),li.getElementById('parm_type_'+id).get('html'),li.getElementById('parm_len_'+id).get('html'),li.getElementById('parm_dec_'+id).get('html'),li.getElement('input[name=remove]').checked,li.getElementById('default_on_empty_'+id).get('html'),li.getElementById('check_expression_'+id).get('html'),li.getElementById('keep_spaces_'+id).get('value')));

  });

  if (GetMultiCompany()) {
    parameters.push(new Array('companylist','Company List','M','10','0','','','',false))
  }

  //I parametri presenti nelle query in Union
  if(!Empty(Ctrl("union_file").value)){
    var unions=Ctrl("union_file").value.split(";");
    for (var j=0; j<unions.length; j++){
      AppendQueryParameter(parameters,unions[j],[]);
    }
  }

  //I parametri presenti in subquery
  $$('#filters_ul li').each(function(curFilter) {
    var example = curFilter.getElement("input[name=example]").get('value')
    if (FilterUsesFile(curFilter.getElement("select[name=criteria]").getSelected()[0].get('value'),example)) {
      AppendQueryParameter(parameters,example,[]);
    }
  });

  //I parametri presenti nelle tabelle temporanee create da query con parametri
  $$('#tables_ul li input[name=desc]').each(function(el) {
    var regexpres;
    if((regexpres = el.get('value').match(vqr_regexp))!=null){
      var filename=regexpres[1];
      // var ignore = [];
      // if ( regexpres[3] ) {
        // ignore = regexpres[3].split(',');
        // for (var l=0;l<ignore.length;l++) {
          // ignore[l] = ignore[l].split(':=')[0];
        // }
      // }
      AppendQueryParameter(parameters,filename,/*ignore*/regexpres[3]||'');
    }
  });
  return parameters;
}

//--------------------------------------------------------------------------------------
function DeleteItem(itm) {
  itm.dispose();
  sort_all.removeItems(itm);
  itm.destroy();
  SetUpdated();
}
function ExpressionBuilder(id){
  var height = 400;
  var width = 600;
  var left = (screen.width)?(screen.width-width)/2:100;
  var top = (screen.height)?(screen.height-height-(height/4))/2:100;

  if (IsNetscape() || IsMozilla()) {
    width+=5; //Per Netscape e Mozilla, il width e height sono leggermente diversi
    height+=4;
  }
  openSPModalLayer("../portalstudio/expression_builder.jsp?ExpressionID="+URLenc(id)+"&callerFunction=ExpressionBuilderReturn&SPModalLayerId=vqrSPModalLayer&tool=visualquery", top, left, width, height, true, 1, false,false)
}

function ExpressionBuilderReturn(id, value){
  if (id) {
    var el = document.getElementById(id);
    if (el)
      el.value=value;
  }
  SetUpdated();
}
function GetExpressionFromId(id) {
  if (id) {
    var el = document.getElementById(id);
    if (el)
      return el.value;
  }
  return "";
}

function getOfflineModule(){
  var idx=$$('#tables_ul li')[0].get("idxTable");
  if (allTables[idx][5]) {
    return Strtran(allTables[idx][5],'.offline','');
  } else {
    return sessionStorage.getItem( "entryPointName" )||'plan';
  }
}

/* Carica i dati della query in un oggetto Properties */
function FillVQRVariables(action, prop, mode,incrementVersion){
  var i;
  var l_oVqr = new TrsJavascript();
  l_oVqr.reset();
  l_oVqr.SetRow(0);

  var l_oTables = new TrsJavascript();
  l_oTables.reset();
  l_oTables.SetRow(0);

  var l_oFields = new TrsJavascript();
  l_oFields.reset();
  l_oFields.SetRow(0);

  var l_oRelations = new TrsJavascript();
  l_oRelations.reset();
  l_oRelations.SetRow(0);

  var l_oFilters = new TrsJavascript();
  l_oFilters.reset();
  l_oFilters.SetRow(0);

  var l_oOrderBy = new TrsJavascript();
  l_oOrderBy.reset();
  l_oOrderBy.SetRow(0);

  var l_oGroupBy = new TrsJavascript();
  l_oGroupBy.reset();
  l_oGroupBy.SetRow(0);

  var l_oPivotFields = new TrsJavascript();
  l_oPivotFields.reset();
  l_oPivotFields.SetRow(0);

  var l_oPivotData = new TrsJavascript();
  l_oPivotData.reset();
  l_oPivotData.SetRow(0);

  var l_oParameters = new TrsJavascript();
  l_oParameters.reset();
  l_oParameters.SetRow(0);

  var l_oOther = new TrsJavascript();
  l_oOther.reset();
  l_oOther.SetRow(0);

  if(Eq(action, 'open')){
    var rows,idx,tttype,tName,tDesc, regexpres;
    if(simplemode){
      l_oVqr.BuildProperties(prop,true);
    } else {
    l_oVqr.BuildProperties(prop);
    }
    l_oTables.BuildProperties(GetProperty(l_oVqr,'tables','C'));
    l_oFields.BuildProperties(GetProperty(l_oVqr,'fields','C'));
    l_oRelations.BuildProperties(GetProperty(l_oVqr, 'relations', 'C'));
    if(simplemode){
      l_oFilters.BuildProperties(GetProperty(l_oVqr,'wheres','C'));
    }else {
      l_oFilters.BuildProperties(GetProperty(l_oVqr,'filters','C'));
    }
    l_oOrderBy.BuildProperties(GetProperty(l_oVqr,simplemode?'orderBy':'orderby','C'));
    l_oGroupBy.BuildProperties(GetProperty(l_oVqr,simplemode?'groupBy':'groupby','C'));
    l_oPivotFields.BuildProperties(GetProperty(l_oVqr,'pivot_fields','C'));
    l_oPivotData.BuildProperties(GetProperty(l_oVqr,'pivot_data','C'));
    l_oParameters.BuildProperties(GetProperty(l_oVqr,'parameters','C'));
    //Tabelle
    rows=GetProperty(l_oTables,'Rows','N');
    for(i=0;i<rows;i++){
      l_oTables.SetRow(i);
      tDesc=GetProperty(l_oTables,'desc','C');
      tName=GetProperty(l_oTables,'name','C');

      if((regexpres = tDesc.match(vqr_regexp))!=null){ //Se una query utilizza VQR temporanee
        tempFilename=regexpres[1];
        idx=SetTempTable(null,true);
      }
      else if(Upper(Left(tDesc,3))=="BO:"){ //Se una query utilizza una BO Query
        tempFilename=tName;
        var module = new JSURL("../servlet/SPXDCProxy?action=procedure_module&table="+tempFilename.substring(3)+"&offlinemode="+offlinemode).Response();
        module=module!='ACCESS DENIED'?module:'';
        idx=SetTempTable(module,true);
      }
      else if (Upper(Left(tDesc,16))=="STOREDPROCEDURE:"){
        tempFilename=tDesc;
        idx=SetTempTable("",true);
      }
      else {
        idx=GetTableIdx(tName);
      }
      tttype=Right(tName,1);
      if(tttype!="+" && tttype!="*" && tttype!="#" && tttype!="$") tttype="";
      else tName=Left(tName,Len(tName)-1);

      DrawTable(new Array(idx,tName,tDesc,GetProperty(l_oTables,'alias','C'),i,tttype));
      FetchData(idx);

      iid=i; //table index in the array
    }

    //Campi
    rows = GetProperty(l_oFields,'Rows','N');
    for (i=0; i<rows; i++){
      l_oFields.SetRow(i);
      DrawField(new Array(-1, GetProperty(l_oFields,'exp','C'), GetProperty(l_oFields,'desc','C'), GetProperty(l_oFields,'type','C'), GetProperty(l_oFields,'len','N'), GetProperty(l_oFields,'dec','N'), GetProperty(l_oFields,'alias','C'), GetProperty(l_oFields,'privacy','N'), GetProperty(l_oFields,'identifier','L'), GetProperty(l_oFields,'defaultValue','C'), GetProperty(l_oFields,'useDefaultWhen','C'), GetProperty(l_oFields, 'index', 'N'), GetProperty(l_oFields, 'calculated', 'L')));
    }

    //Relazioni
    rows = GetProperty(l_oRelations,'Rows','N');
    for (i=0; i<rows; i++){
      l_oRelations.SetRow(i);
      DrawSingleJoin(new Array(GetProperty(l_oRelations,'desc','C'), GetProperty(l_oRelations,'exp','C'), GetProperty(l_oRelations,'type','C'), GetProperty(l_oRelations,'alias1','C'), GetProperty(l_oRelations,'alias2','C')));
    }

    //Filtri
    rows = GetProperty(l_oFilters,'Rows','N');
    for (i=0; i<rows; i++){
      l_oFilters.SetRow(i);
      DrawSingleFilter(new Array(GetProperty(l_oFilters,'field','C'), (GetProperty(l_oFilters,'not','C')=='Not' ? true : false), GetProperty(l_oFilters,'op','C'), GetProperty(l_oFilters,'const','C'), GetProperty(l_oFilters,'lOp','C'), (GetProperty(l_oFilters,'having','C')=='Having' ? true : false),GetProperty(l_oFilters,'useFilterWhen','C')));
    }

    //OrderBy
    rows = GetProperty(l_oOrderBy,'Rows','N');
    var field, fieldKey, order;
    for (i=0; i<rows; i++){
      l_oOrderBy.SetRow(i);
      field = GetProperty(l_oOrderBy,'field','C');
      order = GetProperty(l_oOrderBy,'order','C');
      fieldKey = GetFieldUsedKey(field);
      if (fieldKey != null){
        DrawSingleOrderBy(fieldKey,order);
      }
    }

    //GroupBy
    rows = GetProperty(l_oGroupBy,'Rows','N');
    for (i=0; i<rows; i++){
      l_oGroupBy.SetRow(i);
      field = GetProperty(l_oGroupBy,'field','C');
      fieldKey = GetFieldUsedKey(field);
      if (fieldKey != null){
        DrawSingleGroupBy(fieldKey);
      }
    }

    // Pivot Field
    rows = GetProperty(l_oPivotFields,'Rows','N');
    for (i=0; i<rows; i++){
      l_oPivotFields.SetRow(i);
      field = GetProperty(l_oPivotFields,'field','C');
      fieldKey = GetFieldUsedKey(field);
      if (fieldKey != null){
        DrawSinglePivotFields(fieldKey);
      }
    }

    // Pivot Data
    rows = GetProperty(l_oPivotData,'Rows','N');
    l_oPivotData.SetRow(0)
    Ctrl('pivotType').value=GetProperty(l_oPivotData,'pivotType','N');
    Ctrl('listQuery').value=GetProperty(l_oPivotData,'pivotListQry','C');
    var aggregateFunc;
    for (i=0; i<rows; i++){
      l_oPivotData.SetRow(i);
      field = GetProperty(l_oPivotData,'data','C');
      aggregateFunc=GetProperty(l_oPivotData,'aggregateFunc','C');
      fieldKey = GetFieldUsedKey(field);
      if (fieldKey != null){
        DrawSinglePivotData(fieldKey,aggregateFunc);
      }
    }

    //Parametri
    rows = GetProperty(l_oParameters,'Rows','N');
    for (i=0; i<rows; i++){
      l_oParameters.SetRow(i);
      DrawSingleParameter(new Array(GetProperty(l_oParameters,'field','C'),GetProperty(l_oParameters,'desc','C'),GetProperty(l_oParameters,'type','C'),GetProperty(l_oParameters,'len','C'),GetProperty(l_oParameters,'dec','C'),(GetProperty(l_oParameters,'remove','C')=='Remove' ? true : false),GetProperty(l_oParameters,'defaultOnEmpty','C'),GetProperty(l_oParameters,'checkExpression','C'),GetProperty(l_oParameters,'keepSpaces','L')));
    }

    l_oOther.BuildProperties(GetProperty(l_oVqr,'union','C'));
    Ctrl("union_file").value = GetProperty(l_oOther,'union','C');

    l_oOther.BuildProperties(GetProperty(l_oVqr,'union_all','C'));
    Ctrl("chk_union_all").checked = GetProperty(l_oOther,'union_all','L');

    l_oOther.BuildProperties(GetProperty(l_oVqr,'multi_company','C'));
    Ctrl("chk_multi_company").checked = GetProperty(l_oOther,'multi_company','L');

    l_oOther.BuildProperties(GetProperty(l_oVqr,'default_companyList','C'));
    Ctrl("default_companyList").value = GetProperty(l_oOther,'default_companyList','C');

    l_oOther.BuildProperties(GetProperty(l_oVqr,'security_roles','C'));
    Ctrl("security_roles").value = GetProperty(l_oOther,'security_roles','C');

    l_oOther.BuildProperties(GetProperty(l_oVqr,'accessibility','C'));
    Ctrl("chk_public").checked = GetProperty(l_oOther,'public','L');
    Ctrl("chk_batch").checked = GetProperty(l_oOther,'batch','L');
    Ctrl("chk_cache").selectedIndex = GetProperty(l_oOther,'cache','N');
    Ctrl('cache_duration').value = GetProperty(l_oOther,'cache_duration','N');
    Ctrl("security_key").value = GetProperty(l_oOther,'security_key','C');
    Ctrl("remote_server").value = GetProperty(l_oOther,'remote_server','C');
    Ctrl("remote_vqr_name").value = GetProperty(l_oOther,'remote_vqr_name','C');
    SetRemoteUser(GetProperty(l_oOther,'remote_user','C'));
    SetRemotePassword(GetProperty(l_oOther,'remote_password','C'));
    Ctrl("remote_company").value = GetProperty(l_oOther,'remote_company','C');
    Ctrl("remote_instance").value = GetProperty(l_oOther,'remote_instance','C');
    Ctrl("remote_mode").value = GetProperty(l_oOther,'remote_mode','C')||"native";

    l_oOther.BuildProperties(GetProperty(l_oVqr,'distinct','C'));
    Ctrl("chk_distinct").checked = Eq(GetProperty(l_oOther,'distinct','C'), "Distinct");

    l_oOther.BuildProperties(GetProperty(l_oVqr,'remove_filter','C'));
    Ctrl("chk_remove_filter").checked = GetProperty(l_oOther,'remove_filter','L');

    l_oOther.BuildProperties(GetProperty(l_oVqr,'use_orderby','C'));
    Ctrl("chk_use_orderby").checked = GetProperty(l_oOther,'use_orderby','L');

    l_oOther.BuildProperties(GetProperty(l_oVqr,'version','C'));

    m_nFileVersion = GetProperty(l_oOther,'version','N');

    l_oOther.BuildProperties(GetProperty(l_oVqr,'notes','C'));
    Ctrl("notes").value = GetProperty(l_oOther,'notes','C');

    l_oOther.BuildProperties(GetProperty(l_oVqr,'privacy','C'));
    Ctrl("privacy").value = GetProperty(l_oOther,'privacy','N');

  }
  else if(Eq(action, 'save')){
    if (simplemode || offlinemode && mode=='json') {
      l_oTables = new TrsArrayForOffline();
      l_oTables.reset();
      l_oTables.SetRow(0);

      l_oFields = new TrsArrayForOffline();
      l_oFields.reset();
      l_oFields.SetRow(0);

      l_oRelations = new TrsArrayForOffline();
      l_oRelations.reset();
      l_oRelations.SetRow(0);

      l_oFilters = new TrsArrayForOffline();
      l_oFilters.reset();
      l_oFilters.SetRow(0);

      l_oOrderBy = new TrsArrayForOffline();
      l_oOrderBy.reset();
      l_oOrderBy.SetRow(0);

      l_oGroupBy = new TrsArrayForOffline();
      l_oGroupBy.reset();
      l_oGroupBy.SetRow(0);

      l_oPivotFields = new TrsArrayForOffline();
      l_oPivotFields.reset();
      l_oPivotFields.SetRow(0);

      l_oPivotData = new TrsArrayForOffline();
      l_oPivotData.reset();
      l_oPivotData.SetRow(0);

      l_oParameters = new TrsArrayForOffline();
      l_oParameters.reset();
      l_oParameters.SetRow(0);
    }
    i=1;
    $$('#tables_ul li').each(function (el) {
      var desc = el.getElement('input[name=desc]');
        l_oTables.setValue('desc', WtA(desc.get('value'), 'C'));
      el.getElements('input').each(function (inp) {
        switch (inp.name) {
          case 'alias':
            l_oTables.setValue('alias', WtA(inp.get('value'), 'C'));
            break;
          case 'name':
            l_oTables.setValue('name', WtA(inp.get('value')+(desc.get('value').match(vqr_regexp)!=null ? el.getElement("select[name=tt_type]").getSelected()[0].get('value') : ""), 'C'));
        }
      });
      l_oTables.SetRow(i++); //Imposto quello successivo per avere il numero di righe
    });
    i=1;
    $$('#fields_ul li').each(function (el) {
      el.getElements('input').each(function (inp) {
        switch (inp.name) {
          case 'desc':
            l_oFields.setValue('desc', WtA(inp.get('value'), 'C'));
            break;
          case 'name':
            l_oFields.setValue('exp', WtA(inp.get('value'), 'C'));
            break;
          case 'alias':
            l_oFields.setValue('alias', WtA(inp.get('value'), 'C'));
            break;
          case 'privacy':
            l_oFields.setValue('privacy', WtA(inp.get('value'), 'N'));
            break;
          case 'identifier':
            l_oFields.setValue('identifier', WtA(inp.get('value'), 'L'));
            break;
          case 'index':
            l_oFields.setValue('index', WtA(inp.get('value'), 'N'));
            break;
          case 'defaultValue':
            l_oFields.setValue('defaultValue', WtA(inp.get('value'), 'C'));
            break;
          case 'useDefaultWhen':
            l_oFields.setValue('useDefaultWhen', WtA(inp.get('value'), 'C'));
            break;
        }
      });

      el.getElements('span').each(function(inp){
        if (inp.id!=''){
          if (inp.id.indexOf('fld_len')==0)
            l_oFields.setValue('len', WtA(inp.get('text'), 'N'))
          else if (inp.id.indexOf('fld_dec')==0)
            l_oFields.setValue('dec', WtA(inp.get('text'), 'N'))
          else if (inp.id.indexOf('fld_type')==0)
            l_oFields.setValue('type', WtA(inp.get('text'), 'C'));
        }
      });
      l_oFields.setValue('calculated', 'false');
      l_oFields.SetRow(i++);
    });

    $$('#calculatedFields_ul li').each(function (el) {
      el.getElements('input').each(function (inp) {
        switch (inp.name) {
          case 'desc':
            l_oFields.setValue('desc', WtA(inp.get('value'), 'C'));
            break;
          case 'name':
            l_oFields.setValue('exp', WtA(inp.get('value'), 'C'));
            break;
          case 'alias':
            l_oFields.setValue('alias', WtA(inp.get('value'), 'C'));
            break;
          case 'privacy':
            l_oFields.setValue('privacy', WtA(inp.get('value'), 'N'));
            break;
          case 'identifier':
            l_oFields.setValue('identifier', WtA(inp.get('value'), 'L'));
            break;
          case 'index':
            l_oFields.setValue('index', WtA(inp.get('value'), 'N'));
            break;
          case 'defaultValue':
            l_oFields.setValue('defaultValue', WtA(inp.get('value'), 'C'));
            break;
          case 'useDefaultWhen':
            l_oFields.setValue('useDefaultWhen', WtA(inp.get('value'), 'C'));
            break;
        }
      });

      el.getElements('span').each(function(inp){
        if (inp.id!=''){
          if (inp.id.indexOf('fld_len')==0)
            l_oFields.setValue('len', WtA(inp.get('text'), 'N'))
          else if (inp.id.indexOf('fld_dec')==0)
            l_oFields.setValue('dec', WtA(inp.get('text'), 'N'))
          else if (inp.id.indexOf('fld_type')==0)
            l_oFields.setValue('type', WtA(inp.get('text'), 'C'));
        }
      });
      l_oFields.setValue('calculated', 'true');
      l_oFields.SetRow(i++);
    });

    i=1;
    $$('#joins_ul li').each(function (el) {
      el.getElements('input').each(function (inp) {
        switch (inp.name) {
          case 'desc':
            l_oRelations.setValue('desc', WtA(inp.get('value'), 'C'));
            break;
          case 'exp':
            l_oRelations.setValue('exp', WtA(inp.get('value'), 'C'));
            break;
        }
      });
      el.getElements('select').each(function (inp) {
        switch (inp.name) {
          case 'jtype':
            l_oRelations.setValue('type', WtA(inp.getSelected()[0].get('value'), 'C'));
            break;
          case 'tb1':
            l_oRelations.setValue('alias1', WtA(inp.getSelected()[0].get('value'), 'C'));
            break;
          case 'tb2':
            l_oRelations.setValue('alias2', WtA(inp.getSelected()[0].get('value'), 'C'));
            break;
        }
      });
      l_oRelations.SetRow(i++);
    });
    i=1;
    $$('#filters_ul li').each(function (el) {
      el.getElements('input').each(function (inp) {
        switch (inp.name) {
          case 'field':
            l_oFilters.setValue('field', WtA(inp.get('value'), 'C'));
            break;
          case 'not':
            l_oFilters.setValue('not', WtA((inp.checked ? "Not" : ""), 'C'));
            break;
          case 'example':
            l_oFilters.setValue('const', WtA(inp.get('value'), 'C'));
            break;
          case 'having':
            l_oFilters.setValue('having', WtA((inp.checked ? "Having" : ""), 'C'));
            break;
          case 'useFilterWhen':
            l_oFilters.setValue('useFilterWhen', WtA(inp.get('value'), 'C'));
            break;
        }
      });
      el.getElements('select').each(function (inp) {
        switch (inp.name) {
          case 'criteria':
          l_oFilters.setValue('op', WtA(inp.getSelected()[0].get('value'), 'C'));
          case 'logical':
            l_oFilters.setValue('lOp', WtA(inp.getSelected()[0].get('value'), 'C'));
        }
      });
      l_oFilters.SetRow(i++);
    });
    i=1;
    $$('#orderby_ul li').each(function (el) {
      l_oOrderBy.setValue('desc', WtA(el.getElement('span.desc').get('text'), 'C'));
      l_oOrderBy.setValue('field', WtA(el.getElement('div.field').get('text'), 'C'));
      l_oOrderBy.setValue('order', WtA(el.getElement('select.order').getSelected()[0].get('value'), 'C'));
      l_oOrderBy.SetRow(i++);
    });
    i=1;
    $$('#groupby_ul li').each(function (el) {
      l_oGroupBy.setValue('desc', WtA(el.getElement('span.desc').get('text'), 'C'));
      l_oGroupBy.setValue('field', WtA(el.getElement('div.field').get('text'), 'C'));
      l_oGroupBy.SetRow(i++);
    });

    i=1;
    $$('#pivotFields_ul li').each(function (el) {
      l_oPivotFields.setValue('field', WtA(el.getElement('div.field').get('text'), 'C'));
      l_oPivotFields.SetRow(i++);
    });

    i=1;
    $$('#pivotData_ul li').each(function (el) {
      l_oPivotData.setValue('data', WtA(el.getElement('div.field').get('text'), 'C'));
      l_oPivotData.setValue('aggregateFunc', WtA(el.getElement('select.aggregateFunc').getSelected()[0].get('value'), 'C'));
      l_oPivotData.SetRow(i++);
    });

    i=1;
    $$('#parameters_ul li').each(function (el) {
      el.getElements('input').each(function (inp) {
        switch (inp.name) {
          case 'name':
            l_oParameters.setValue('field', WtA(inp.get('value'), 'C'));
            break;
          case 'desc':
            l_oParameters.setValue('desc', WtA(inp.get('value'), 'C'));
            break;
           case 'remove':
            l_oParameters.setValue('remove', WtA((inp.checked ? "Remove" : ""), 'C'));
            break;
          case 'defOnEmpty':
            l_oParameters.setValue('defaultOnEmpty', WtA(inp.get('value'), 'C'));
            break;
          case 'checkExpr':
              l_oParameters.setValue('checkExpression', WtA(inp.get('value'), 'C'));
              break;
          case 'keepSpaces':
            l_oParameters.setValue('keepSpaces', WtA(inp.get('value'), 'L'));
            break;
        }
      });

      el.getElements('span').each(function(inp){
        if (inp.id!=''){
          if (inp.id.indexOf('parm_len')==0)
            l_oParameters.setValue('len', WtA(inp.get('text'), 'C'))
          else if (inp.id.indexOf('parm_dec')==0)
            l_oParameters.setValue('dec', WtA(inp.get('text'), 'C'))
          else if (inp.id.indexOf('parm_type')==0)
            l_oParameters.setValue('type', WtA(inp.get('text'), 'C'));
        }
      });


      l_oParameters.SetRow(i++);
    });

    if (simplemode || offlinemode && mode=='json') {
      var myObj = {};
      myObj.tables = l_oTables.returnArray();
      myObj.fields = l_oFields.returnArray();
      myObj.relations = l_oRelations.returnArray();
      myObj.wheres = l_oFilters.returnArray();
      myObj.orderBy = l_oOrderBy.returnArray();
      myObj.groupBy = l_oGroupBy.returnArray();
      myObj.parameters = l_oParameters.returnArray();
      myObj.distinct = WtA(Ctrl("chk_distinct").checked ? "Distinct" : "", 'C');
      myObj.remove_filter = (Ctrl("chk_remove_filter").checked ? true : false);
      myObj.union = WtA(Ctrl("union_file").value, 'C');
      myObj.union_all = (Ctrl("chk_union_all").checked ? true : false);
      myObj.use_orderby = (Ctrl("chk_use_orderby").checked ? true : false);
      return JSON.stringify(myObj);
    } else {
      //Carico l'oggetto principale
      l_oVqr.setValue('l_oTables', l_oTables.asString());
      l_oVqr.setValue('l_oFields', l_oFields.asString());
      l_oVqr.setValue('l_oRelations', l_oRelations.asString());
      l_oVqr.setValue('l_oFilters', l_oFilters.asString());
      l_oVqr.setValue('l_oOrderBy', l_oOrderBy.asString());
      l_oVqr.setValue('l_oGroupBy', l_oGroupBy.asString());
      l_oVqr.setValue('l_oParameters', l_oParameters.asString());
      l_oVqr.setValue('l_oPivotFields', l_oPivotFields.asString());
      l_oVqr.setValue('l_oPivotData', l_oPivotData.asString());
      l_oVqr.setValue('pivotType', WtA(document.getElementById('pivotType').value,'N'));
      l_oVqr.setValue('pivotListQry', WtA(Ctrl("listQuery").value,'C'))
      l_oVqr.setValue('distinct', WtA(Ctrl("chk_distinct").checked ? "Distinct" : "", 'C'));
      l_oVqr.setValue('remove_filter', WtA(Ctrl("chk_remove_filter").checked ? true : false, 'L'));
      l_oVqr.setValue('use_orderby', WtA(Ctrl("chk_use_orderby").checked ? true : false, 'L'));

      //Incremento la versione del file ad ogni salvataggio
      if (incrementVersion)
        m_nFileVersion++;
      l_oVqr.setValue('version', WtA(m_nFileVersion||0, 'N'));
      l_oVqr.setValue('union', WtA(Ctrl("union_file").value, 'C'));
      l_oVqr.setValue('union_all', WtA(Ctrl("chk_union_all").checked ? true : false, 'L'));
      l_oVqr.setValue('multi_company', WtA(Ctrl("chk_multi_company").checked ? true : false, 'L'));
      l_oVqr.setValue('default_companyList', WtA(Ctrl("default_companyList").value, 'C'));
      l_oVqr.setValue('security_roles', WtA(Ctrl("security_roles").value, 'C'));
      l_oVqr.setValue('public', WtA(Ctrl("chk_public").checked ? true : false, 'L'));
      l_oVqr.setValue('batch', WtA(Ctrl("chk_batch").checked ? true : false, 'L'));
      l_oVqr.setValue('cache', WtA(Ctrl("chk_cache").selectedIndex, 'N'));
      l_oVqr.setValue('cache_duration', WtA(Ctrl("cache_duration").value, 'N'));
      l_oVqr.setValue('security_key', WtA(Ctrl("security_key").value, 'C'));
      l_oVqr.setValue('remote_server', WtA(Ctrl("remote_server").value, 'C'));
      l_oVqr.setValue('remote_vqr_name', WtA(Ctrl("remote_vqr_name").value, 'C'));
      l_oVqr.setValue('remote_user', WtA(GetRemoteUser(), 'C'));
      l_oVqr.setValue('remote_password', WtA(Ctrl("remote_password").value, 'C'));
      l_oVqr.setValue('remote_company', WtA(Ctrl("remote_company").value, 'C'));
      l_oVqr.setValue('remote_instance', WtA(Ctrl("remote_instance").value, 'C'));
      l_oVqr.setValue('remote_mode', WtA(Ctrl("remote_mode").value, 'C'));
      l_oVqr.setValue('notes', WtA(Ctrl("notes").value, 'C'));
      l_oVqr.setValue('privacy', WtA(Ctrl("privacy").value, 'N'));
      return l_oVqr.asString(1);
    }

  }
}

function TrsArrayForOffline() {
  var myObj = [];
  var curIdx = 0;
  this.setValue = function (id, value) {
    if (!myObj[curIdx]) myObj[curIdx] = {};
    myObj[curIdx][id] = value;
  }
  this.reset = function () {
    myObj = [];
  }
  this.SetRow = function (idx) {
    curIdx = idx;
  }
  this.returnArray = function() {
    return myObj;
  }
}

var OBF_REMOTEUSER = "[ OBFUSCATED USERNAME ]";
function GuessIsObfuscated(str) {
  return str.length>255 && str.match(/%[a-f0-9]{2}/i);
}
function SetRemoteUser(user) {
  var ctrl = Ctrl("remote_user");
  if ( IsA(user, 'C') ) {
    if ( GuessIsObfuscated(user) ) {
      ctrl.value = OBF_REMOTEUSER;
    } else {
      ctrl.value = user;
    }
    ctrl.setAttribute("remote_user", user);
  } else {
    ctrl.value = "";
    ctrl.setAttribute("remote_user", "");
  }
}
function GetRemoteUser(){
  var ctrl = Ctrl("remote_user");
  if ( ctrl.value!=OBF_REMOTEUSER ) {
    return ctrl.value;
  }
  return ctrl.getAttribute("remote_user");
}
function IsAParameter(str) {
  return str.match(/^\?/) && !GuessIsObfuscated(str);
}
function SetRemotePassword(password) {
  var ctrl = Ctrl("remote_password");
  ctrl.value = password || "";

  if ( SetRemotePassword.QueryChangeType(ctrl.value) ) {
    SetRemotePassword.SetType(IsAParameter(ctrl.value) ? "text" : "password");
  }
}

SetRemotePassword.QueryChangeType = function(password){
  return (IsAParameter(password) && Ctrl("remote_password").type!="text")
         ||
         (!IsAParameter(password) && Ctrl("remote_password").type=="text");
};

SetRemotePassword.SetType = function(type) {
  try {
    Ctrl("remote_password").type = type;
  } catch(e) { //IE
    //aggiunge il pulsante per rivelare la pwd
    var revealer = document.createElement("input");
    revealer.id = "remote_password_revealer";
    revealer.type = "button";
    revealer.className = "bottoni";
    revealer.style.height = "22px";
    revealer.style.width = "18px";
    revealer.value = "?";
    revealer.title = "Reveal password parameter";
    Ctrl("remote_password").parentNode.appendChild(revealer);

    //ridefinisce le funzioni
    SetRemotePassword.SetType = function(type) {
      var revealer = Ctrl("remote_password_revealer");
      revealer.onclick = type=='text' ? new Function("PSAlert.alert('Parameter used for remote password: '+Ctrl('remote_password').value)") : '';
      revealer.style.display = type=='text' ? '' : 'none';
    };
    SetRemotePassword.QueryChangeType = function(password) {
      var revealer = Ctrl("remote_password_revealer");
      return (IsAParameter(password) && revealer.style.display=='none')
             ||
             (!IsAParameter(password) && revealer.style.display!='none');
    };

    //esegue nuova versione
    SetRemotePassword.SetType(type);
  }
};

function openPreview(text){
  var preview=document.getElementById('preview');
  var preview_wrapper=document.getElementById('preview_wrapper');
  var iframe_wrapper=document.getElementById('iframe_wrapper');
  var morphP;
  if (! (Browser.ie && Browser.version<9))
    morphP= new Fx.Morph(preview_wrapper,{ 'duration':'400',transition:Fx.Transitions.easeOut});
  function showPreview(){
    preview_wrapper.setStyles({'width': window.getSize().x-8,'height':window.getSize().y-10,'left':4,'top':4});
    iframe_wrapper.setStyles({'height': window.getSize().y-40,'width':window.getSize().x-18});
    preview.setStyles({'height': window.getSize().y-50,'width':window.getSize().x-28});
    preview.src="./sql.jsp";
    preview_wrapper.style.display='block';
    if ((! (Browser.ie && Browser.version<9)) && (!previewOpen)){
      morphP.start({'left':4});
      preview_wrapper.style.display='block'
    }
    else preview_wrapper.style.left=4+'px'
    preview.style.display='block';
    if (! (Browser.ie && Browser.version<9)){
      preview.style.opacity=0;
    }
    previewOpen=true;
  }
  if (previewOpen){
    showPreview();
    preview.style.opacity=1;
    document.getElementById('dictionaryTitle').set('text',text);
  }
  else {
     showPreview()
    if (!(Browser.ie && Browser.version<9))
      preview.morph({opacity:1})
    else{
      preview.style.opacity=1;
      preview.style.visibility='visible';
    }
    document.getElementById('dictionaryTitle').set('text',text);
  }
}

function closePreview(){
  var preview=document.getElementById('preview');
  var preview_wrapper=document.getElementById('preview_wrapper');
  var morphP;
  if (!(Browser.ie && Browser.version<9)){
    morphP= new Fx.Morph(preview_wrapper,{ 'duration':'400',transition:Fx.Transitions.easeOut});
    morphP.start({'left': window.getSize().x}).chain(function (){preview_wrapper.style.display='none';preview.src='';});
  }
  else {
    preview_wrapper.style.display='none';
    preview.src='';
  }
  document.getElementById('dictionaryTitle').set('text','Dictionary')
  previewOpen=false;
}

function ShowSQL(popup){
  if($$('#tables_ul li').length==0 && Empty(Ctrl("remote_server").value) ){
    PSAlert.alert("Query empty!")
  }
  else {
    sqlOperation = "sqlPhrase";
    if (popup){
      var height = 580;
      var width = 515;
      var left = (screen.width)?(screen.width-width)/2:100;
      var top = (screen.height)?(screen.height-height)/2:100;
      window.open("sql.jsp",randomKey+'_'+sqlOperation,"height="+height+",width="+width+",left="+left+",top="+top+",resizable=yes,scrollbars=yes");
    }
    else {
      openPreview('SQL phrase');
    }
  }
}

function AnalyzeSQL(popup){
  if($$('#tables_ul li').length==0 && Empty(Ctrl("remote_server").value) ){
    PSAlert.alert("Query empty!")
  }
  else {
     sqlOperation = "sqlAnalyze";
    if (popup){
      var height = 580;
      var width = 515;
      var left = (screen.width)?(screen.width-width)/2:100;
      var top = (screen.height)?(screen.height-height)/2:100;
      window.open("sql.jsp",randomKey+'_'+sqlOperation,"height="+height+",width="+width+",left="+left+",top="+top+",resizable=yes,scrollbars=yes");
    }
    else {
      openPreview('SQL analyze');
    }
  }
}

function toggleTestConfiguration(){
  var maskTestConf=Ctrl("maskTestConf");
  var modifyParValue=document.getElementById("modifyParValue");
  var saveParametersTr= Ctrl("saveParametersTr")
  if (maskTestConf.style.visibility=="hidden"){
    var parameters=this.GetParametersArray()
    maskTestConf.style.visibility="visible";
    maskTestConf.style.left=Ctrl("dictPanelCaptionTr").offsetWidth-maskTestConf.offsetWidth+13+'px';
    if (parameters.length==0)
      saveParametersTr.style.visibility="hidden";
    else {
      saveParametersTr.style.visibility="visible";
      document.getElementById("saveParameters").set('checked',false)
      }
  }
  else{
    maskTestConf.style.visibility="hidden";
    modifyParValue.style.visibility="hidden";
    saveParametersTr.style.visibility="hidden";
  }
}

function ExecuteSQL(p_lShowAll,popup){
  if( $$('#tables_ul li').length==0 && Empty(Ctrl("remote_server").value) ) {
    PSAlert.alert("Query empty!")
  }
  else {
    sqlOperation = "sqlQuery";
    showAll = p_lShowAll;
    if (popup){
      var height = 580;
      var width = 515;
      var left = (screen.width)?(screen.width-width)/2:100;
      var top = (screen.height)?(screen.height-height)/2:100;
      window.open("../visualquery/sql.jsp", randomKey+'_'+sqlOperation, "height="+height+",width="+width+",left="+left+",top="+top+",resizable=yes,scrollbars=yes");
    }
    else {
      openPreview('Execute SQL')
    }
  }
}

 function Find(findNext){
  var tablesStop, i, reName, reDesc;

  if(typeof(findNext)=="undefined"){
    tableDesc=Ctrl("tableDesc").value;
    tableName=Ctrl("tableName").value;
    fieldDesc=Ctrl("fieldDesc").value;
    fieldName=Ctrl("fieldName").value;
    lastFoundTableIdx=-1;
    lastFoundFieldIdx=-1;
  }
  if(lastFoundFieldIdx==-1){
    try {
      reName = new RegExp(tableName);
    } catch (e) { reName = null; }
    try {
      reDesc = new RegExp(tableDesc);
    } catch (e) { reDesc = null; }
    if(tableDesc!=""){
      tablesStop=false;
      for(i=lastFoundTableIdx+1;i<allTables.length && !tablesStop;i++){
        if (reDesc && reDesc.test(allTables[i][1]) || !reDesc && Lower(Left(allTables[i][1],Len(tableDesc)))==Lower(tableDesc)){
          if(tableName!=""){
            if (reName && reName.test(allTables[i][0]) || !reName && Lower(Left(allTables[i][0],Len(tableName)))==Lower(tableName)){
              lastFoundTableIdx=i;
              tablesStop=true;
            }
          }
          else{
            lastFoundTableIdx=i;
            tablesStop=true;
          }
        }
      }
    }
    else if(tableName!=""){
      tablesStop=false;
      for(i=lastFoundTableIdx+1;i<allTables.length && !tablesStop;i++){
        if (reName && reName.test(allTables[i][0]) || !reName && Lower(Left(allTables[i][0],Len(tableName)))==Lower(tableName)){
          lastFoundTableIdx=i;
          tablesStop=true;
        }
      }
    }
    if(tablesStop){
      o_dictTables.setSelectedRow(lastFoundTableIdx);
    }
  }

  if(fieldDesc!="" || fieldName!=""){
    var tableToSearch=-1;

    if(o_dictTables.getSelectedRow()>-1){
      tableToSearch=o_dictTables.getSelectedRow();
      var fieldFound=false;

      try {
        reName = new RegExp(fieldName);
      } catch (e) { reName = null; }
      try {
        reDesc = new RegExp(fieldDesc);
      } catch (e) { reDesc = null; }

      for(i=lastFoundFieldIdx+1;i<allTables[tableToSearch][2].length && !fieldFound;i++){
        fieldFound=false;
        if(fieldDesc!=""){
          fieldFound=reDesc && reDesc.test(allTables[tableToSearch][2][i][1]) || !reDesc && Lower(Left(allTables[tableToSearch][2][i][1],Len(fieldDesc)))==Lower(fieldDesc);
        }
        if((fieldName!="" && fieldFound) || (fieldName!="" && fieldDesc=="")){
          fieldFound=reName && reName.test(allTables[tableToSearch][2][i][0]) || !reName && Lower(Left(allTables[tableToSearch][2][i][0],Len(fieldName)))==Lower(fieldName);
        }
        if(fieldFound){
          lastFoundFieldIdx=i;
          o_dictFields.setSelectedRow(lastFoundFieldIdx);
        }
      }
    }
    else{
      PSAlert.alert("No table selected to search in.");
    }
    if(!fieldFound){
      lastFoundFieldIdx=-1;
    }
  }

  if(lastFoundFieldIdx==-1 && !tablesStop){
    lastFoundTableIdx=-1;
    PSAlert.alert("No more occurrences");
  }
 }

function CreateVZMConfig(){
  var tablesForVZM=function(){
    var res=[];
    $$('#tables_ul input[name=name]').each(function (el) {
      res.push(new Array(el.get('value'),el.get('value')));
    });
    if(!EmptyArray(res)){
      return res;
    }
    var selTableIdxs=o_dictTables.getSelectedRow();
    if(!EmptyArray(selTableIdxs)){
      for(var i=0,l=selTableIdxs.length; i<l; i++){
        res.push(new Array(allTables[selTableIdxs[i]][0],allTables[selTableIdxs[i]][0]));
      }
    }
    return res;
  }

  var vzmTables=tablesForVZM();
  if(EmptyArray(vzmTables)){
    PSAlert.alert('Please select the table unpon to build the zoom configuration.');
  }else{
     windowOpenForeground("../jsp-system/SPMakeVzmFromVqr_portlet.jsp?Vqr="+(Trim(m_cFilename)||'')+'&Tables='+escape(toJSONString(vzmTables))+'&offlinemode='+(offlinemode?"true":'false'),'SPMakeVzmFromVqr','height=220,width=375,top=100,left=100,directories=no,location=no,menubar=no,toolbar=no,resizable=yes');
  }
}

function SetSecurity(){
  if(!EmptyString(m_cFilename)){
    var top=100, left=100, width=524,height=400;
    openSPModalLayer("../servlet/SPManageQuerySecurity?progname=vqr/"+Trim(m_cFilename), top, left, width, height, true, 1, false,false)
  }
}

function Public_Modified(){
  Ctrl("security_roles").disabled=Ctrl("security_key").disabled=Ctrl("chk_public").checked;
  BOSecurity_Modified();
}
function Cache_Modified(){
  Ctrl("cache_duration").disabled=!Ctrl("chk_cache").selectedIndex;
}
function BOSecurity_Modified(){
  Ctrl("security_roles").disabled=!Empty(Ctrl("security_key").value);
}
function BlankAllLists() {
  document.getElementById('tables_ul').empty();
  document.getElementById('fields_ul').empty();
  document.getElementById('orderby_ul').empty();
  document.getElementById('groupby_ul').empty();
  document.getElementById('pivotData_ul').empty();
  document.getElementById('pivotFields_ul').empty();
  document.getElementById('joins_ul').empty();
  document.getElementById('filters_ul').empty();
  document.getElementById('parameters_ul').empty();
}
  function executeQuery(e){
    if (Browser.ie && Browser.version<9){
      switch (e.button){
        case 1:
          if (e.ctrlKey)
            ExecuteSQL(false,true);
          else ExecuteSQL(false,false);
          break;
        case 4:
          ExecuteSQL(false,true);
      }
    }
    else {
      switch (e.button){
        case 0:
          if (e.ctrlKey)
            ExecuteSQL(false,true);
          else ExecuteSQL(false,false);
          break;
        case 1:
          ExecuteSQL(false,true);
      }
    }
    return false;
  }

  function showSQLPhrase(e){
    if (Browser.ie && Browser.version<9){
      switch (e.button){
        case 1:
          if (e.ctrlKey)
            ShowSQL(true);
          else ShowSQL(false);
          break;
        case 4:
          ShowSQL(true);
      }
    }
    else {
      switch (e.button){
        case 0:
          if (e.ctrlKey)
            ShowSQL(true);
          else ShowSQL(false);
          break;
        case 1:
          ShowSQL(true);
      }
    }
    return false;
  }

  function analyze(e){
    if (Browser.ie && Browser.version<9){
      switch (e.button){
        case 1:
          if (e.ctrlKey)
            AnalyzeSQL(true);
          else AnalyzeSQL(false);
          break;
        case 4:
          AnalyzeSQL(true);
      }
    }
    else {
      switch (e.button){
        case 0:
          if (e.ctrlKey)
            AnalyzeSQL(true);
          else AnalyzeSQL(false);
          break;
        case 1:
          AnalyzeSQL(true);
      }
    }
    return false;
  }

  function toggleMaskCompareQuery(){
    var maskQueryCompare=Ctrl("maskQueryCompare");
    if (maskQueryCompare.style.display=="none"){
      this.GetParametersArray()
      maskQueryCompare.style.display="block";
    }
    else{
      maskQueryCompare.style.display="none";
    }
  }

  function compareQuery(){
    sqlOperation = "checkquery"
    m_cQueryToCompare=Ctrl("queryToCompare").value
    if (!Empty(m_cQueryToCompare)){
      toggleMaskCompareQuery();
      openPreview('Compare query');
    }
    else PSAlert.alert("Query name is empty");
  }

window.addEvent('domready', function () {


  sort_all = new Sortables('#fields_ul, #orderby_ul, #groupby_ul, #joins_ul, #filters_ul, #parameters_ul', {constrain: true, handle:'.handler', clone:function(){return new Element('div');}})
  sort_all.addEvent('start', function(el/*, clone*/) {
    if (!this.list.scroller)
      this.list.scroller=new Scroller(this.list);
    this.list.scroller.start();
    el.addClass("dragging");
  });
  sort_all.addEvent('complete', function(el/*,clone*/) {
    if (this.list.scroller)
      this.list.scroller.stop();
    el.removeClass("dragging");
  });
  sort_all.addEvent('sort', function() {
    SetUpdated();
  });
  document.getElementById('tableopenclose').addEvents({
    'click':function(){
      hideDictionaryTable();
    }
  });

  TabPanelGroupPivot=new TabsMT('tabListGroupPivot','tabContentsGroupPivot',{clickFunc:function(index){
    if (index==0)
      $$(".mover").each(function(el) {
        el.title='Move field to Orderby or Groupby zone'
      });
    else
      $$(".mover").each(function(el) {
        el.title='Move field to Pivot or Data zone'
      });
  }});
  TabPanel=new TabsMT('tabList','tabContents',{clickFunc:function(index){
    switch(index) {
      case 0:
        AdjustDictionaryPanletHeight();
        if (! (Browser.ie && Browser.version<9))
          document.getElementById("tables_ul").nanoScrollerMT();
        break;
      case 1:
        AdjustDictionaryPanletHeight();
        TabPanelGroupPivot.refresh();
        if (! (Browser.ie && Browser.version<9)){
          document.getElementById("fields_ul").nanoScrollerMT();
          document.getElementById("groupby_ul").nanoScrollerMT();
          document.getElementById("orderby_ul").nanoScrollerMT();
          document.getElementById("pivotFields_ul").nanoScrollerMT();
          document.getElementById("pivotData_ul").nanoScrollerMT();
        }
        break;
      case 2:
        AdjustDictionaryPanletHeight();
        if (! (Browser.ie && Browser.version<9))
          document.getElementById("joins_ul").nanoScrollerMT();
        break;
      case 3:
        AdjustDictionaryPanletHeight();
        if (! (Browser.ie && Browser.version<9))
          document.getElementById("filters_ul").nanoScrollerMT();
        break;
      case 4:
        AdjustDictionaryPanletHeight();
        if (! (Browser.ie && Browser.version<9))
          document.getElementById("parameters_ul").nanoScrollerMT();
        break;
      case 6:
        AdjustDictionaryPanletHeight();
        break;
    }
  }});

  o_dictTables = new VQRSelectableList("dictTablesDiv",{
    clickFunc:UpdateFieldsAndRelations,
    doubleClickFunc:AddTable,
    classCSS:[{
      width:simplemode?"100%":'40%',
      selectedItem:'selectedItem',
      itemList:'itemListLeft'
    },
    {
      width:'35%',
      selectedItem:'selectedItem',
      itemList:'itemListRight'
    },
    {
      width:'25%',
      selectedItem:'selectedItem',
      itemList:'itemListRight'
    }],
    nList:simplemode?1:3,
    scroll:true
  });
  o_dictFields = new VQRSelectableList("dictFieldsDiv",{
    doubleClickFunc:AddField,
    classCSS:[{
      width:'52%',
      selectedItem:'selectedItem',
      itemList:'itemListLeft'
    },
    {
      width:'31%',
      selectedItem:'selectedItem',
      itemList:'itemListRight'
    },
    {
      width:'13%',
      selectedItem:'selectedItem',
      itemList:'itemListRight'
    },
    {
      width:'4%',
      selectedItem:'selectedItem',
      itemList:'itemListRight'
    }],
    nList:4,
    scroll:true
  });
  o_dictRelations = new VQRSelectableList("dictPanelRelDiv",{
    doubleClickFunc:AddJoin,
    classCSS:[{
      width:'100%',
      selectedItem:'selectedItem',
      itemList:'itemListLeft'
    }],
    scroll:true
  });

  document.getElementById('dictPanelTitleTableContainer').morphEffect = new Fx.Morph(document.getElementById('dictPanelTitleTableContainer'), {duration: 400,transition: Fx.Transitions.linear});
  if (! (Browser.ie && Browser.version<9))
    $$(".ulMiddleContainer, .ulContainer").nanoScrollerMT();

  if(IsQueryTestInstalled){ // se c'é il modulo di test sulle query

    document.getElementById("saveParameters").addEvent("change", function(){
      if (this.get('checked'))
        Ctrl("modifyParValue").style.visibility="visible";
      else
        Ctrl("modifyParValue").style.visibility="hidden";
    });
    document.getElementById("modifyParValue").addEvent('click',function(){
      if (m_cFilename!=null){
        sqlOperation = "testConfiguration";
        var testConfigurationFile=document.getElementById("configurationFileName").get('value');
        if (testConfigurationFile!=""){
          openPreview('Parameters for configuration test');
          toggleTestConfiguration() //nascondo la maschera di configurazione
        }
        else
          PSAlert.alert("Configuration file name is empty");
      }
      else
        PSAlert.alert("Query not saved");
    })
    document.getElementById("saveTestConf").addEvent('click',function(){
      SaveTestConfigurationFile();
    });
  }

  document.onkeydown = function (e) {
    if (e.ctrlKey && e.keyCode === 83) { // CTRL+S: salva
      e.preventDefault();
      e.stopPropagation();
      if (parent.saveTool) parent.saveTool();
      return false;
    }
  };
});

function SaveTestConfigurationFile(){
  var testConfigurationFile=document.getElementById("configurationFileName").get('value');
  if (m_cFilename!=null){
    if (testConfigurationFile!=""){
      var parametersURL="action=testConfiguration&m_cFileName="+m_cFilename+"&m_cConfigurationFileName="+testConfigurationFile;
      if (document.getElementById("saveParameters").get("checked")){
        parametersURL+="&m_cParams="+URLenc(FillParameterProps());
        for (var el in parametersValue){
          parametersURL+="&"+el+"="+parametersValue[el];
        }
      }
      else parametersURL+="&m_lSaveParameter=false";
      SavingAlert(true,'Saving configuration file..')
      SaveTestConfigurationFile2(parametersURL);
    }
    else
      PSAlert.alert("Error: Configuration file name is empty");
  }
  else
    PSAlert.alert("Error: Query not saved");
}

function SaveTestConfigurationFile2(parametersURL){
  var testConfiguration= new JSURL("../servlet/SPVQRProxy?"+parametersURL, false).Response();
  toggleTestConfiguration() //nascondo la maschera di configurazione
  SavingAlert(false);
  if (testConfiguration=="1"){
    notimooManager.show({
      title:'Notification message',
      message: 'Configuration file saved',
      visibleTime: 2000,
      width:200
    });
  }
  else
    PSAlert.alert("Error: Unable to save configuration file");
}

function FillParameterProps(){
  var parameters=GetParametersArray();
  var l_oParameters = new TrsJavascript();
  l_oParameters.reset();
  l_oParameters.SetRow(0);
  for (var i=0; i<parameters.length; i++) {
    l_oParameters.setValue('field', WtA(parameters[i][0], 'C'));
    l_oParameters.setValue('desc', WtA(parameters[i][1], 'C'));
    l_oParameters.setValue('type', WtA(parameters[i][2], 'C'));
    l_oParameters.setValue('len', WtA(parameters[i][3], 'C'));
    l_oParameters.setValue('dec', WtA(parameters[i][4], 'C'));
    l_oParameters.setValue('remove', WtA((parameters[i][5] ? "Remove" : ""), 'C'));
    l_oParameters.setValue('defaultOnEmpty', WtA(parameters[i][6], 'C'));
    l_oParameters.setValue('checkExpression', WtA(parameters[i][7], 'C'));
    l_oParameters.SetRow(i+1);
  }
  return  l_oParameters.asString();
}

function hideDictionaryTable(){
  var panel = document.getElementById("dictionaryPanel");
  var tBig = document.getElementById("dictPanelTitleTableContainer");
  var elem = document.getElementById("tableopenclose");
  // var btn = document.getElementById("FindBtn");

	//var wrapper = $("wrapAll");
  if(dictionaryopen){
    dictionaryopen=false;
    panel.style.height='auto';
    panel.style.minHeight='0px'
    elem.getElement('div').style.backgroundPosition="bottom";
    tBig.morphEffect.start({
      'height':0
		}).chain(function(){
      AdjustDictionaryPanletHeight();
      if (! (Browser.ie && Browser.version<9))
        $$(".ulMiddleContainer, .ulContainer").nanoScrollerMT();
    });
    // btn.morph({opacity:0})
	}else{
    dictionaryopen=true;
    elem.getElement('div').style.backgroundPosition="top";
    $$(".ulContainer").each(function(el) {
      el.style.height='';
    });
    $$(".ulMiddleContainer").each(function(el) {
      el.style.height='';
    });
    tBig.morphEffect.start({
      'height':GetWindowSize().h-380
    }).chain(function(){
      tBig.style.height='';
      panel.style.height='';
      //reset delle altezze dei contenitori
      AdjustDictionaryPanletHeight();
      if (! (Browser.ie && Browser.version<9))
        $$(".ulMiddleContainer, .ulContainer").nanoScrollerMT();
    });
    // btn.morph({opacity:1})
  }
}

var PSAlert=new function(){
  this.t=null;
	return {
		alert:
			function(m,c){
				var d=this.main.document;
        var b;
        if(Ctrl("PSAlert")){
          b = Ctrl("PSAlert");
          b.style.display='block';
          setOpacity(b,0.8);
        }else{
				  b=d.createElement('div');
			  	b.id='PSAlert';
				  // insert in to body
				  b=d.body.insertBefore(b,d.body.firstChild);
          b.className=c||'';
          b.className='notimoo';
          b.style.cssText='position:absolute;';
          b.style.textAlign='center';
          b.style.width='20%';
          b.style.marginLeft='40%';
          b.style.marginRight='40%';
          b.style.top='300px';
          b.style.zIndex='1001';
          setOpacity(b,0.8);
          // classname not passed, set defaults
          if(b.className.length==0){
            b.style.padding='8px 8px';
            b.style.border='1px solid #888888';
            b.style.backgroundColor='#FFFFFF';
            b.style.fontFamily='lucida grande,Verdana,taohma';
            b.style.fontWeight='bold';
            b.style.color='#888888';
            b.style.fontSize='12px';
            b.style.lineHeight='24px';
            b.style.display='block';
          }
        }
				// write HTML fragment to it
        b.innerHTML="<div style='background:URL(../portalstudio/images/warning.png) no-repeat;height:24px;width:24px;margin-left:auto;margin-right:auto'></div> ";
				b.innerHTML+="<div>"+m+"</div>";
				// fadeout block if supported
        this.b=b;
        if(this.t)clearTimeout(this.t);
        if(FadingId)clearInterval(FadingId);
        this.t=setTimeout("setFading(PSAlert.b,80,0,700,'function(){PSAlert.main.document.body.removeChild(PSAlert.b);}')",1200);
			}  ,
		init:
			function(w,s){
				// save window
				this.main=w;
				this.classname=s||'';
			}
		// shutdown Alert object
    /*
		shut:
			function(){
				// if redifine set
				if(this._alert!=null){
					// restore old alert function
					this.main.alert=this._alert;
					// unset placeholder
					this._alert=null;
				}
			}
    */
	};
};
// apply a fading effect to an object
// by applying changes to its style
// @o = object style
// @b = begin opacity
// @e = end opacity
// @d = duration (millisec)
// @f = function (optional)
var FadingId=null;
function setFading(o,b,e,d,f){
 //setOpacity(o,0);
	FadingId=setInterval(
		function(){
			b=stepFX(b,e,2);
			setOpacity(o,b/100);
			if(b==e){
				if(FadingId){clearInterval(FadingId);FadingId=null;}
				if(typeof f=='function'){f();}
        o.style.display='none';
			}
		},d/50
	);
}
// set opacity for element
// @e element
// @o opacity
function setOpacity(e,o){
	// for IE
	e.style.filter='alpha(opacity='+o*100+')';
	// for others
	e.style.opacity=o;
}
// increment/decrement value in steps
// checking for begin and end limits
//@b begin
//@e end
//@s step
function stepFX(b,e,s){
	return b>e?b-s>e?b-s:e:b<e?b+s<e?b+s:e:b;
}
PSAlert.init(window, '');
document.addEventListener('DOMContentLoaded', function(){
  if(simplemode){
    // Ctrl("toolbar").style.display ="none";
    Ctrl("tableopenclose").style.display ="none";
    Ctrl("addbo").style.display ="none";
    Ctrl("addquery").style.display ="none";
    Ctrl("dictPanelRelTitleTable").style.display ="none";
    Ctrl("dictPanelRelTr").style.display ="none";
    Ctrl("access_tab").style.display ="none";
    Ctrl("note_tab").style.display ="none";
    Ctrl("union_label").style.display ="none";
    Ctrl("union_file").style.display ="none";
    Ctrl("search_union_file").style.display ="none";
    Ctrl("chk_union_all_label").style.display ="none";
    Ctrl("chk_union_all").style.display ="none";
    Ctrl("chk_multi_company").style.display ="none";
    Ctrl("chk_multi_company_label").style.display ="none";
    Ctrl("default_companyList").style.display ="none";
    Ctrl("default_companyList_label").style.display ="none";
    Ctrl("customQry").style.display ="none";
    Ctrl("customQry_label").style.display ="none";
    Ctrl("correspondingQry").style.display ="none";
    Ctrl("contentTable").setAttribute("colspan",1);
    Ctrl("title_tables").style.width = "39%";
    Ctrl("title_fields").style.width = "59%";
    Ctrl("tables_descr_title").style.display ="none";
    Ctrl("tables_name_title").style.width ="100%";
    Ctrl("tables_module_title").style.display ="none";
    Ctrl("addstoredprocedure").style.display ="none";
  }
})

function loadDataFromPortlet() {
  if( Empty(item_index) ){
    PSAlert.alert('Error with ctrl index');
    return;
  }

  allTables=[];
  o_dictTables.deleteAllItem();
  // GetTables(); //Richiede la lista delle tabelle al server e li salva nell'array "allTables"

  var base_ctrl = parent.itemsHTML[item_index];
  var dataproviders = base_ctrl.dataproviders.split(',').map(function(el){
    return parent.itemsHTML.filter(function(it){return it.name==el})[0];
  });

  //TABELLE
  var i;
  for( i=0; i<dataproviders.length; i++){
    var qr = dataproviders[i].query;
    allTables.push([qr,dataproviders[i].name +"[" + qr + "]",null,null,"",""]);
  }
  for ( i=0; i<allTables.length; i++){
    o_dictTables.addStringRow([allTables[i][1], allTables[i][4],allTables[i][5]]);
  }
  o_dictTables.addRows();
  //QUERY
  var JSONqueryStr = base_ctrl[item_prop];
  if( !Empty(JSONqueryStr) ){
    try{JSON.parse(JSONqueryStr);}catch(e){PSAlert.alert("Json query corrupted!")}
    FillVQRVariables('open',JSONqueryStr);
  }


  FetchData = function(idx){
    var fields = parent.GetQueryFields(allTables[idx][0],true);
    allTables[idx][2] = [];
    allTables[idx][3] = [];
    for(var i=0; i< fields[0].length; i++){
      allTables[idx][2].push([fields[0][i],fields[1][i],fields[2][i],0,0,0,0,false]);
    }
  }
  Save = function(){
   base_ctrl[item_prop] = FillVQRVariables('save');
   parent.Properties();
   window.close();
  }
}
