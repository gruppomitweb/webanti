function gasplib_PS(nLen,nDec) {  
  return this.Picture(nLen,nDec,',');  
}

function gasplib_PG(nLen,nDec) {  
  return this.Picture(nLen,nDec,'');
}

function gasplib_Picture(nLen,nDec,cSep) {
    var pict='';
    // parte decimale
    if (nDec > 0) {
	    pict = '.';
	    for(i = 0; i < nDec; i++) {
		    pict = pict + '9';
	    }
    }
    // parte intera
    for(i = 0; i < (nLen-nDec); i++) {      
      if (i % 3 == 0 && i > 0) pict= cSep + pict
      pict = '9'+pict;      
    }    
 return(pict);
}

function gasplib_Transform(nNumber, sPicture) {
  return Format(nNumber, 0, 0, sPicture);
}

function gasplib_ConvData(data){
  var gg = new String();
  var mm = new String();
  var aa = new String();
  var risultato = new String();

  aa = data.substr(0,4);
  mm = data.substr(4,2);
  gg = data.substr(6,2);

  risultato = gg + "/" + mm + "/" + aa;

  return(risultato);
}

function gasplib_SystemTimeMillis() {
  return(-1);
}

//Funzione che blocca l'esecuzione della funzione che la chiama finché passa il tempo
function pause(numberMillis) {
  var closeString = 'window.setTimeout(function () { window.close(); }, ' + numberMillis + ');';
  //Il codice HTML da visualizzare dentro il dialog
  var waitString = "<html><head><title>Attendere...</title></head><body bgcolor=#eceaea><table width=100% height=100% border=0><tr><td align=center valign=middle style=\"font-family:arial\">Attendere il caricamento del figlio ...</td></tr></table></body><script>"+closeString+"</script></html>";
  var result
  if(IsIE()) {
    //Se volete che il dialog non si vede, usare la seguente riga
    //result=window.showModalDialog('javascript:document.writeln("<script>' + closeString + '<' + '/script>")');

    //Se volete che il dialog si vede, usare la seguente riga
    result=window.showModalDialog("javascript:document.writeln('"+waitString+"')",null,"dialogHeight:50px;dialogWidth:320px;status:no;help:no");
  }
  else if(IsNetscape() || IsMozilla()) {
    //It requires a trusted script.
    result=openDialog('javascript:document.writeln("<script>' + closeString + '<' + '/script>"', 'pauseDialog', 'modal=1,width=10,height=10');
  }
}

function checkAndLoadChild(childName) {
  //Controllo se il figlio e caricato oppure no. Il tag iframe ha il nome del figlio in minuscolo
  if(Eq(CtrlById(Lower(childName)).src,'')) {
    //Se non è caricato, lo carico. La servlet è in minuscolo mentre per GetLinkPCKeys deve coincidere
    CtrlById(Lower(childName)).src=Lower(childName)+'?m_bInnerChild=true'+GetLinkPCKeys(childName)
    //Fermo l'esecuzione delle funzione per 1500 millsecondi
    pause(1500);
  }
}

//---Start function: AppendDetailRow
function gasplib_AppendDetailRow(AFields, AFieldValues) {
  var res = false;
  var newRowIndex = CtrlById('GridTable').rows.length - 1;
  if ( ! ActivateNextRow(newRowIndex)) return (false);
  if ( ! gasplib_WriteDetailFields(newRowIndex+1, AFields, AFieldValues)) return (false);
  /*
  SetModified(false);
  DoUpdate(true);
  */
  return(true);
}
//---End function

//---Start function: DateDiff
function gasplib_DateDiff(ADate1, ADate2) {
  var res = 0;
  if ( ( typeof ADate1 == 'undefined' ) || ( typeof ADate2 == 'undefined' ))
     return res;
  if ( ( typeof ADate1 == 'object' ) && ( ADate1.constructor == Date ))
     datDate1 = ADate1;
  else
     datDate1= Date.parse(ADate1);
  if ( ( typeof ADate2 == 'object' ) && ( ADate2.constructor == Date ))
     datDate2 = ADate2;
  else
     datDate2= Date.parse(ADate2);
  res = ((datDate2-datDate1)/(24*60*60*1000))
  return res;
}
//---End function

//---Start function: Evaluator
function gasplib_Evaluator(AInstruction) {
  var res = "";
  eval(AInstruction);
  return res;
}
//---End function

//---Start function: FillArrayRows
function gasplib_FillArrayRows(AFromRow, AToRow, AColsName, AColsValues) {
  if ( AToRow == -1 )
     AToRow = m_oTrs.length;
  for ( key=AFromRow; key<AToRow; key++ ) {
    retVal = gasplib_WriteDetailFields(ARow, AColsName, AColsValues);
  }
}
//---End function

//---Start function: GetParentVariableDate
function gasplib_GetParentVariableDate( AVarName ) {
var RetVal = new Date();
var command;

  if (( parent == null ) && ( opener == null ))
    return null;
  if ( parent != null )
    op = parent;
  if ( opener != null )
    op = opener;
  command = "RetVal = new Date('" + op[AVarName] + "');"
  eval(command);
  return(RetVal);

}
//---End function

//---Start function: GetParentVariableNumber
function gasplib_GetParentVariableNumber(AVarName) {
var RetVal = 0;
var command;
  if (( parent == null ) && ( opener == null ))
    return null;
  if ( parent != null )
    op = parent;
  if ( opener != null )
    op = opener;
  command = "RetVal = '" + op[AVarName] + "';";
  eval(command);
  return(RetVal);
}
//---End function

//---Start function: GetParentVariableString
function gasplib_GetParentVariableString(AVarName) {
  var RetVal;
  var command;
  if (( parent == null ) && ( opener == null ))
    return null;
  if ( parent != null )
    op = parent;
  if ( opener != null )
    op = opener;
  command = "RetVal = '" + op[AVarName] + "';";
  eval(command);
  return(RetVal);
}
//---End function

//---Start function: GetSon
//ATTENZIONE: il nome del figlio che viene passato alla funzione deve identico a quello inserito nella pagina
//            con i caratteri minuscoli e maiuscoli
function gasplib_GetSon(SonName) {
  var RetVal;
  var toEvaluate;
  var command;
  var theObj;

  RetVal = null;

  //Controllo il caricamento del figlio
  checkAndLoadChild(SonName);

  toEvaluate = "theObj = parent.frames.main.frames." + Lower(SonName);
  eval (toEvaluate);
  if ( ( typeof theObj == 'undefined' ) || ( theObj == null ) ){
    toEvaluate = "theObj = m_o" + Lower(SonName);
    eval(toEvaluate);
    if ( ( typeof theObj == 'undefined' ) || ( theObj == null ) )
      return( RetVal );
    else {
      return(theObj);
    }
  } else {
      return(theObj);
  }
}
//---End function

//---Start function: GetSonVariable
//ATTENZIONE: il nome del figlio che viene passato alla funzione deve identico a quello inserito nella pagina
//            con i caratteri minuscoli e maiuscoli
function gasplib_GetSonVariable(AVarName, SonName) {
  var RetVal;
  var toEvaluate;
  var command;
  var theObj;
  RetVal = "";

  //Controllo il caricamento del figlio
  checkAndLoadChild(SonName);

  // Test a iframe
  toEvaluate = "theObj = parent.frames.main.frames." + Lower(SonName);
  eval (toEvaluate);
  if ( ( typeof theObj == 'undefined' ) || ( theObj == null ) ){
    toEvaluate = "theObj = m_o" + Lower(SonName);
    //alert(toEvaluate);
    eval(toEvaluate);
    //alert(theObj);
    //alert("testing window... " + toEvaluate);
    if ( ( typeof theObj == 'undefined' ) || ( theObj == null ) )
      return( RetVal );
    else {
      //m_oTrs[0].ID
      //alert("in window");
      command = "RetVal = m_o" + Lower(SonName) + "." + AVarName;
      //alert(command);
      eval(command);
      //alert(RetVal);
      return(RetVal);
    }
  } else {
    //alert("in frame");
    command = "RetVal = " + theObj.name + "." + AVarName;
    //alert(command);
    eval(command);
    //alert(RetVal);
    return(RetVal);
  }

}
//---End function

//---Start function: GetSonVariableDate
//ATTENZIONE: il nome del figlio che viene passato alla funzione deve identico a quello inserito nella pagina
//            con i caratteri minuscoli e maiuscoli
function gasplib_GetSonVariableDate(AVarName, SonName) {
  var RetVal;
  var toEvaluate;
  var command;
  var theObj;
  var theval;

  RetVal = new Date();

  //Controllo il caricamento del figlio
  checkAndLoadChild(SonName);

  // Test a iframe
  toEvaluate = "theObj = parent.frames.main.frames." + Lower(SonName);
  eval (toEvaluate);
  if ( ( typeof theObj == 'undefined' ) || ( theObj == null ) ){
    toEvaluate = "theObj = m_o" + Lower(SonName);
    //alert(toEvaluate);
    eval(toEvaluate);
    //alert(theObj);
    //alert("testing window... " + toEvaluate);
    if ( ( typeof theObj == 'undefined' ) || ( theObj == null ) )
      return( RetVal );
    else {
      //m_oTrs[0].ID
      //alert("in window");
      command = "theval = m_o" + Lower(SonName) + "." + AVarName;
      eval(command);
      //alert(theval);
      command = "RetVal = new Date('" + theval + "');"
      //alert(command);
      eval(command);
      //alert(RetVal);
      return(RetVal);
    }
  } else {
    //alert("in frame");
    command = "theval = " + theObj.name + "." + AVarName;
    eval(command);
    //alert(theval);
    command = "RetVal = new Date('" + theval  + "');"
    //alert(command);
    eval(command);
    //alert(RetVal);
    return(RetVal);
  }
}
//---End function

//---Start function: GetSonVariableNumber
//ATTENZIONE: il nome del figlio che viene passato alla funzione deve identico a quello inserito nella pagina
//            con i caratteri minuscoli e maiuscoli
function gasplib_GetSonVariableNumber(AVarName, SonName) {
  var RetVal;
  var toEvaluate;
  var command;
  var theObj;
  RetVal = 0;

  //Controllo il caricamento del figlio
  checkAndLoadChild(SonName);

  // Test a iframe
  toEvaluate = "theObj = parent.frames.main.frames." + Lower(SonName);
  eval (toEvaluate);
  if ( ( typeof theObj == 'undefined' ) || ( theObj == null ) ){
    toEvaluate = "theObj = m_o" + Lower(SonName);
    //alert(toEvaluate);
    eval(toEvaluate);
    //alert(theObj);
    //alert("testing window... " + toEvaluate);
    if ( ( typeof theObj == 'undefined' ) || ( theObj == null ) )
      return( RetVal );
    else {
      //m_oTrs[0].ID
      //alert("in window");
      command = "RetVal = m_o" + Lower(SonName) + "." + AVarName + "';"
      //alert(command);
      eval(command);
      //alert(RetVal);
      return(RetVal);
    }
  } else {
    //alert("in frame");
    command = "RetVal = " + theObj.name + "." + AVarName + ";"
    //alert(command);
    eval(command);
    //alert(RetVal);
    return(RetVal);
  }
}
//---End function

//---Start function: GetSonVariableString
//ATTENZIONE: il nome del figlio che viene passato alla funzione deve identico a quello inserito nella pagina
//            con i caratteri minuscoli e maiuscoli
function gasplib_GetSonVariableString(AVarName, SonName) {
  var RetVal="";
  var toEvaluate;
  var command;
  var theObj;

  //Controllo il caricamento del figlio
  checkAndLoadChild(SonName);
  toEvaluate = "theObj = parent.frames.main.frames." + Lower(SonName);
  eval(toEvaluate);

  if (( typeof theObj == 'undefined') || (theObj == null )){
    toEvaluate = "theObj = m_o" + Lower(SonName);
    eval(toEvaluate);
    if ((typeof theObj=='undefined') || (theObj==null))
      return(RetVal);
    else {
      command = "RetVal = m_o" + Lower(SonName) + "." + AVarName + "';"
      eval(command);
      return(RetVal);
    }
  } else {
    command = "RetVal = " + theObj.name + "." + AVarName + ";"
    eval(command);
    return(RetVal);
  }
}
//---End function

//---Start function: RefreshSon
function gasplib_RefreshSon(ASonName) {
var theObj;
var toEvaluate;

  theObj = gasplib_GetSon(ASonName);
  if ( ( typeof theObj == 'undefined' ) || ( theObj == null ) ){
    alert("La finestra " + ASonName + " non è presente!!!");
  } else {
    toEvaluate = "theObj.document.refresh();";
    eval(toEvaluate);
  }
}
//---End function

//---Start function: SetDetailRowEditable
function gasplib_SetDetailRowEditable(ARow) {
var maxIndexValue = Rows() - 1;
var objTable = CtrlById('GridTable');
  // Se non si è in stato di edit o di insert (rispetto al documento intero, non alla
  // singola riga) esce con false.
  if ( Ne(m_cFunction,'edit') &&  Ne(m_cFunction,'new') ) return(false);

  // Se si tratta di una riga 'nuova' l'indice della riga corrente è
  // uguale al numero di righe (N.B. l'indice parte da 0). Quindi il controllo
  // sulla correttezza dell'indice deve essere fatto solo se cerco di settare
  // valori su di una riga diversa da quella corrente; inoltre si dovrà 'selezionare'
  // la riga indicata.
  if ( Ne(ARow,m_nCurrentRow)) {
     if ((Gt(ARow,maxIndexValue )) || ( Lt(ARow, 0 )) ) return(false);
     ActivateNextRow(ARow-1);
     //PerformClick(objTable.rows[ARow].children[0].children[0]);
     // Se il PerformClick() non è andato a buon fine vuol dire che la
     // riga corrente non è valida e non mi ha permesso di selezionare
     // quella che voglio modificare, esce con false
     if ( Ne(ARow,m_nCurrentRow)) return(false);
  }

  return(true);
}
//---End function

//---Start function: SetDetailRowValue
function gasplib_SetDetailRowValue(AColName) {
  var res = "";
  var command;

  if ( m_nCurrentRow <= 0 )
    return res;
  command = "res = m_oTrs[m_nCurrentRow]." + AColName + ";";
  eval(command);
  return res;
}
//---End function

//---Start function: SetVarNamed
function gasplib_SetVarNamed(AVarName, AVarVal) {
   //alert(AVarVal);
   eval(AVarName + " = '" + AVarVal + "'");
   SetModified();
   DoUpdate(true);
}
//---End function

//---Start function: WriteDetailField
function gasplib_WriteDetailField(ARow, AFieldName, AFieldValue ) {
  var retVal = gasplib_WriteDetailFields(ARow,new Array(AFieldName), new Array(AFieldValue));

/*
var command = "retVal = Set_" + AFieldName + "(\"" + AFieldValue + "\")";
var savedRow = m_nCurrentRow;
var retVal = true;

  if (! gasplib_SetDetailRowEditable(ARow)) return(false);

  // Eseguo il settaggio vero e proprio del campo in questione
  retVal = false;
  eval(command);

  // Se è andato tutto bene cerco di ripristinare la riga corrente
  // salvata all'entrata di questa routine
  if (retVal) gasplib_SetDetailRowEditable(savedRow);
*/
  return (retVal);
}
//---End function

//---Start function: WriteDetailFields
function gasplib_WriteDetailFields(ARow, AFields, AFieldValues) {
  var retVal;
  var esitoFinale = true;
  var savedRow = m_nCurrentRow;
  var i;
  var command = "";

  if (! gasplib_SetDetailRowEditable(ARow)) return(false);
  retVal = true;
  for (i = 0; i < AFields.length; i++) {
    command = "retVal = Set_" + AFields[i] + "(\"" + AFieldValues[i] + "\")";
    eval(command);
    esitoFinale = ((esitoFinale) && (retVal));
    //if (!retVal) break;
  }
  if (esitoFinale) gasplib_SetDetailRowEditable(savedRow);

  return (esitoFinale);
}
//---End function

//---Start function: MakeGASPLib
function MakeGASPLib() {
  this.AppendDetailRow=gasplib_AppendDetailRow
  this.DateDiff=gasplib_DateDiff
  this.Evaluator=gasplib_Evaluator
  this.FillArrayRows=gasplib_FillArrayRows
  this.GetParentVariableDate=gasplib_GetParentVariableDate
  this.GetParentVariableNumber=gasplib_GetParentVariableNumber
  this.GetParentVariableString=gasplib_GetParentVariableString
  this.GetSon=gasplib_GetSon
  this.GetSonVariable=gasplib_GetSonVariable
  this.GetSonVariableDate=gasplib_GetSonVariableDate
  this.GetSonVariableNumber=gasplib_GetSonVariableNumber
  this.GetSonVariableString=gasplib_GetSonVariableString
  this.RefreshSon=gasplib_RefreshSon
  this.SetDetailRowEditable=gasplib_SetDetailRowEditable
  this.SetDetailRowValue=gasplib_SetDetailRowValue
  this.SetVarNamed=gasplib_SetVarNamed
  this.WriteDetailField=gasplib_WriteDetailField
  this.WriteDetailFields=gasplib_WriteDetailFields
  this.PS=gasplib_PS;
  this.PG=gasplib_PG;
  this.Picture=gasplib_Picture;
  this.ConvData=gasplib_ConvData;
  this.Transform=gasplib_Transform;
  
}
//---End function

var GASPLib = new MakeGASPLib()
