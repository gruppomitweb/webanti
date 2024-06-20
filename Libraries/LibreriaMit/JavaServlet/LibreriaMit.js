(function() {//MakeLibreriaMit
function ReadVisualQuery(cCmd, cParam)
{
  // Valorizzazione dei parametri
  // cCmd: Nome della Visual Query da eseguire (Senza Suffisso)
  // CParam: Stringa Elenco dei parametri da passare alla query
  // Indicare senza w_;
  // se più di 1 separati da virgola; ''=Nessuno
  var strparms='';
  // Interpreta i Parametri per la VQuery
  if(!Empty(cParam)) {
    var aparms=cParam.split(',');
    for(var i=0;i<aparms.length;i++) {
      if(Trim(aparms[i])!='') {
        //prende i valori dai relativi textbox
        get_par=URLenc(aparms[i]);
        strparms+='&w_'+get_par+'='+CtrlByName(get_par).value;
      }
    }
  }
  // Istanzia l'Oggetto per la gestione delle richieste al Server
  var url = new JSURL('../servlet/SQLDataProviderServer?rows=10000&startrow=0&sqlcmd='+URLenc(cCmd)+strparms,true);
  // Invia la richiesta al Server (Ritorna un Array)
  var output=url.Response();
  var Data = eval(output);
  //Prende il secondo elelemto dell'array, dal momento che il primo elemento
  //contiene la struttura della risposta della query
  Data=Data.pop();
  //Eliminiamo l'ultimo elemento dell'array che contiene dei codici di controllo
  var dummy = Data.pop();
  //Ritorna: Data=Array bidimensionale contenente cursore query
  //Data[Numero Record][Posizione Campo]
  //Data.length: Ritorna il numero di record letti dalla query. 
  return Data;
} 


//---Start function: CalcCond
function libreriamit_CalcCond(oVal,xVal) {
  if (Empty(oVal) && ! Empty(xVal)){
    w_attsel = w_attsel + 1    
  }  
  if (Empty(xVal) && ! Empty(oVal)) {
    w_attsel = w_attsel - 1
  }
}
//---End function

//---Start function: CloseLine
function libreriamit_CloseLine() {
  var res = Chr(13)+Chr(10);
  return res;
}
//---End function

//---Start function: FreeMem
function libreriamit_FreeMem() {
}
//---End function

//---Start function: GeneraCodice
function libreriamit_GeneraCodice(numeroCaratteriRandom, conSpeciali, conTimeStamp, separatore) {
  var res = "";
  return res;
}
//---End function

//---Start function: NewStato
function libreriamit_NewStato(cTbRif, cFlag) {
  var res = "!";
  var _oper = "ABCDEFGHI"
  var _fraz = "JLMNOTUV?"
  if (cTbRif == 'OPERAZBO') {
    for (i=1;i<=9;i++) {
      if (i == Val(cFlag)) {
        res = Substr(_oper,i,1)
      }
    }
  }
  else {
    for (i=1;i<=9;i++) {
      if (i == Val(cFlag)) {
        res = Substr(_fraz,i,1)
      }
    }    
  }  
  return res;
}
//---End function

//---Start function: Occurs
function libreriamit_Occurs(cOrigin, cSearch) {
  var result = 0;
  var len = cSearch.length;
	if (len > 0) {  
	  var start = cOrigin.indexOf(cSearch);
		while (start != -1) {
				result++;
				start = cOrigin.indexOf(cSearch, start+len);
	  }
  }
  return result;
}
//---End function

//---Start function: SpacePad
function libreriamit_SpacePad(cStringa, nLen) {
  var res = "";
  res = res = Left(LRTrim(Left(cStringa,nLen))+Space(nLen),nLen);
  return res;
}
//---End function

//---Start function: StatoReg
function libreriamit_StatoReg(cTbRif, nStato) {
  var res = nStato;
//  if (cTbRif == 'RAPOPEBO') {
//    if (nStato == '1') {
//      res = 'M'
//    }  
//    else if (nStato == '2') {
//      res = 'C'
//    }  
//    else if (nStato == '3') {
//      res = 'V'
//    }  
//    else {
//      res = 'B'
//    }
//    res = nStato
//  }
  if (cTbRif == 'SIMINFBO') {
    if (nStato == '1') {
      res = 'M'
    }  
    else if (nStato == '2') {
      res = 'C'
    }  
    else if (nStato == '3') {
      res = 'V'
    }  
    else {
      res = 'B'
    }
  }
  if (cTbRif == 'OPERAZBO') {
    if (nStato == '1') {
      res = 'P'
    }  
    else if (nStato == '2') {
      res = 'Q'
    }  
    else if (nStato == '3') {
      res = 'R'
    }  
    else {
      res = 'S'
    }
  }
  if (cTbRif == 'FRAZIOBO') {
    if (nStato == '1') {
      res = 'K'
    }  
    else if (nStato == '2') {
      res = 'X'
    }  
    else if (nStato == '3') {
      res = 'Y'
    }  
    else {
      res = 'Z'
    }
  }  
  if (cTbRif == 'SIMOPEBO') {
    if (nStato == '1') {
      res = 'P'
    }  
    else if (nStato == '2') {
      res = 'Q'
    }  
    else if (nStato == '3') {
      res = 'R'
    }  
    else {
      res = 'S'
    }
  }
  return res;
}
//---End function

//---Start function: TestAscii
function libreriamit_TestAscii(sStringa, sCharSet) {
  var res = false;
  return res;
}
//---End function

//---Start function: URL_enc
function libreriamit_URL_enc(pValue) {
  var e=Lower(document.charset)
  return Strtran(Strtran(escape(pValue),"+","%2B"),"%u20AC",e=='utf-8'?"%E2%82%AC":(e=='iso-8859-15'?"%A4":"%80"))
}
//---End function

//---Start function: UTFtoISO
function libreriamit_UTFtoISO(s1) {
  var res = "";
  return res;
}
//---End function

//---Start function: UniqueId
function libreriamit_UniqueId() {
  var res = ""
  for (var i=0; i<10; i++) {
     res=res + String.fromCharCode(Math.random()*26+97)
  }   
  return res
}
//---End function

//---Start function: cWarnOpe
function libreriamit_cWarnOpe(cErrMsg, cTipCon) {  var res = "";  if (Empty(cErrMsg)){}  else { alert(cErrMsg)  }  if(cTipCon == "S" || cTipCon == 'N' || cTipCon == ' ')  { res="P"  }  else  { res="E"  }  return res;  }
//---End function

//---Start function: cWarning
function libreriamit_cWarning(cErrMsg) {  var res = "";  if (Empty(cErrMsg)){}  else { alert(cErrMsg)  }  return res;  }
//---End function

//---Start function: inter_art1
function libreriamit_inter_art1(pTipo) {
  var res = false;
  if(At(pTipo,"|02|03|04|06|07|11|16|18|46|47|49|81|92")>0)
    res=true;
  return res;
}
//---End function

//---Start function: isAlpha
function libreriamit_isAlpha(pString) {
  var res = false;
  return res;
}
//---End function

//---Start function: isAlphaNum
function libreriamit_isAlphaNum(pStringa) {
  var res = false;
  return res;
}
//---End function

//---Start function: isNumeric
function libreriamit_isNumeric(pString) {
  var res = false;
  return res;
}
//---End function

//---Start function: nextUID
function libreriamit_nextUID() {
  var res = "";
  return res;
}
//---End function

//---Start function: uuidToStr15
function libreriamit_uuidToStr15(uuid) {
  var res = "";
  return res;
}
//---End function

//---Start function: MakeLibreriaMit
function MakeLibreriaMit() {
  this.CalcCond=libreriamit_CalcCond
  this.CloseLine=libreriamit_CloseLine
  this.FreeMem=libreriamit_FreeMem
  this.GeneraCodice=libreriamit_GeneraCodice
  this.NewStato=libreriamit_NewStato
  this.Occurs=libreriamit_Occurs
  this.SpacePad=libreriamit_SpacePad
  this.StatoReg=libreriamit_StatoReg
  this.TestAscii=libreriamit_TestAscii
  this.URL_enc=libreriamit_URL_enc
  this.UTFtoISO=libreriamit_UTFtoISO
  this.UniqueId=libreriamit_UniqueId
  this.cWarnOpe=libreriamit_cWarnOpe
  this.cWarning=libreriamit_cWarning
  this.inter_art1=libreriamit_inter_art1
  this.isAlpha=libreriamit_isAlpha
  this.isAlphaNum=libreriamit_isAlphaNum
  this.isNumeric=libreriamit_isNumeric
  this.nextUID=libreriamit_nextUID
  this.uuidToStr15=libreriamit_uuidToStr15
}
//---End function

arguments[0].LibreriaMit = new MakeLibreriaMit()
})(window);//MakeLibreriaMit
