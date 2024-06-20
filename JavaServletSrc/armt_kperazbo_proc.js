function FillCombosValues() {
FillCombo('AQSAREJVST','AQSAREJVST');
FillCombo('HNMYJPHSQN','HNMYJPHSQN');
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('YLIKFVPZJA',function(){return WtH(w_DATAOPE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAOPE);
SPBOUILib.SetInputValue('OEIKQOZMYJ',function(){return WtH(w_DATAREG,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAREG);
if(c=Ctrl('PURPSXEVAI')) selectCombo(c,w_FLAGCONT,'C')
SPBOUILib.SetInputValue('UJRFWINIVQ',function(){return WtH(w_TIPOOPRAP,'C',2,0,'')},w_TIPOOPRAP);
SPBOUILib.SetInputValue('SQVJLYRFKQ',function(){return WtH(w_CODANA,'C',4,0,'')},w_CODANA);
SPBOUILib.SetInputValue('SRWWPHPCUB',function(){return WtH(w_CODVOC,'C',2,0,'')},w_CODVOC);
if(c=Ctrl('LJBMCCABSS')) selectCombo(c,w_appolire,'C')
SPBOUILib.SetInputValue('MKCXJZEKIG',function(){return WtH(w_VALUTA,'C',3,0,'')},w_VALUTA);
SPBOUILib.SetInputValue('YTCDGCPEDJ',function(){return WtH(w_CAMBIO,'N',9,4,'9999.9999')},w_CAMBIO);
SPBOUILib.SetInputValue('EDIXWZNSIC',function(){return WtH(w_xTOTLIRE,'N',15,2,'999,999,999,999.99')},w_xTOTLIRE);
SPBOUILib.SetInputValue('CTORYEJVDR',function(){return WtH(w_xTOTCONT,'N',15,2,'999,999,999,999.99')},w_xTOTCONT);
SPBOUILib.SetInputValue('RZIQZFKPUE',function(){return WtH(w_RAPPORTO,'C',25,0,'')},w_RAPPORTO);
SPBOUILib.SetInputValue('QBLXDBODXR',function(){return WtH(w_CONNESCLI,'C',16,0,'')},w_CONNESCLI);
SPBOUILib.SetInputValue('TCOTJNZLGM',function(){return WtH(w_CONNESOPER,'C',16,0,'')},w_CONNESOPER);
if(c=Ctrl('AQSAREJVST')) selectCombo(c,w_TIPOLEG,'C')
if(c=Ctrl('JGKMKQMAHS')) ChkboxCheckUncheck(c,'S',w_PAGASOGOP)
if(c=Ctrl('JGKMKQMAHS')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('ULVCBLFVEU',function(){return WtH(w_CONNESBEN,'C',16,0,'')},w_CONNESBEN);
SPBOUILib.SetInputValue('HWFHDWYMIU',function(){return WtH(w_CONNALTRO,'C',16,0,'')},w_CONNALTRO);
SPBOUILib.SetInputValue('AWPNTOJIRR',function(){return WtH(w_C_RAG,'C',70,0,'@!')},w_C_RAG);
SPBOUILib.SetInputValue('ODAYKSRECA',function(){return WtH(w_C_CTA,'C',30,0,'@!')},w_C_CTA);
SPBOUILib.SetInputValue('NOTZPDMYIA',function(){return WtH(w_C_PRV,'C',2,0,'')},w_C_PRV);
SPBOUILib.SetInputValue('RDAVOEETJG',function(){return WtH(w_C_CAP,'C',5,0,'')},w_C_CAP);
SPBOUILib.SetInputValue('BOTAJBWHHY',function(){return WtH(w_C_CAB,'C',6,0,'')},w_C_CAB);
SPBOUILib.SetInputValue('VYLHWTRQNX',function(){return WtH(w_C_IND,'C',35,0,'')},w_C_IND);
SPBOUILib.SetInputValue('YVIKEGPYPM',function(){return WtH(w_C_STA,'C',3,0,'')},w_C_STA);
if(c=Ctrl('HNMYJPHSQN')) selectCombo(c,w_TIPOINT2,'C')
SPBOUILib.SetInputValue('CDJFSCCGNX',function(){return WtH(w_CODINT2,'C',11,0,'')},w_CODINT2);
SPBOUILib.SetInputValue('VYDRMHACRY',function(){return WtH(w_DESCINTER,'C',50,0,'')},w_DESCINTER);
SPBOUILib.SetInputValue('NYRJHOZOON',function(){return WtH(w_PAESE,'C',3,0,'')},w_PAESE);
SPBOUILib.SetInputValue('NZZUAIJFDU',function(){return WtH(w_C_RAPPORTO,'C',25,0,'')},w_C_RAPPORTO);
SPBOUILib.SetInputValue('YQINIDXZSL',function(){return WtH(w_CODCAB2,'C',6,0,'')},w_CODCAB2);
SPBOUILib.SetInputValue('ACAPFGYRVI',function(){return WtH(w_PROV2,'C',2,0,'')},w_PROV2);
SPBOUILib.SetInputValue('FFCAGQAZHK',function(){return WtH(w_DESC2,'C',30,0,'')},w_DESC2);
SPBOUILib.SetInputValue('GXMZZZHVBR',function(){return WtH(w_ZCPARTE,'C',69,0,'')},w_ZCPARTE);
SPBOUILib.SetInputValue('NHERHRZTFP',function(){return WtH(w_IDBASE,'C',10,0,'')},w_IDBASE);
SPBOUILib.SetInputValue('XYMCLUECBD',function(){return WtH(w_NUMPROG,'C',11,0,'')},w_NUMPROG);
SPBOUILib.SetInputValue('WJSVGWKSFC',function(){return WtH(w_CODINTER,'C',11,0,'')},w_CODINTER);
SPBOUILib.SetInputValue('AVHTGZTOSZ',function(){return WtH(w_CODDIPE,'C',6,0,'')},w_CODDIPE);
SPBOUILib.SetInputValue('RLUMBFHPUD',function(){return WtH(w_DESCCIT,'C',30,0,'')},w_DESCCIT);
SPBOUILib.SetInputValue('QNNLSEAZHF',function(){return WtH(w_SEGNO,'C',1,0,'')},w_SEGNO);
var tmp_XLNVLBYVQX = ToHTag(AsControlValue((Ge(w_DATAOPE,CharToDate('20020101')) || Le(w_datpaseuro,w_DATAOPE)?'Totale Euro:':'Totale Lire:')));
if (Ne(e_XLNVLBYVQX,tmp_XLNVLBYVQX)) {
SPBOUILib.SetLabelValue('XLNVLBYVQX','innerHTML',tmp_XLNVLBYVQX);
e_XLNVLBYVQX=tmp_XLNVLBYVQX;
}
var tmp_WDLBZTAAWH = ToHTag(AsControlValue(w_desccauana));
if (Ne(e_WDLBZTAAWH,tmp_WDLBZTAAWH)) {
SPBOUILib.SetLabelValue('WDLBZTAAWH','innerHTML',tmp_WDLBZTAAWH);
e_WDLBZTAAWH=tmp_WDLBZTAAWH;
}
var tmp_BPBCTQXMMG = ToHTag(AsControlValue(w_xdesccausin));
if (Ne(e_BPBCTQXMMG,tmp_BPBCTQXMMG)) {
SPBOUILib.SetLabelValue('BPBCTQXMMG','innerHTML',tmp_BPBCTQXMMG);
e_BPBCTQXMMG=tmp_BPBCTQXMMG;
}
var tmp_GPOZOSEFSD = ToHTag(AsControlValue(w_descdiv));
if (Ne(e_GPOZOSEFSD,tmp_GPOZOSEFSD)) {
SPBOUILib.SetLabelValue('GPOZOSEFSD','innerHTML',tmp_GPOZOSEFSD);
e_GPOZOSEFSD=tmp_GPOZOSEFSD;
}
var tmp_PXKFPRTVXX = ToHTag(AsControlValue(w_xragsocper));
if (Ne(e_PXKFPRTVXX,tmp_PXKFPRTVXX)) {
SPBOUILib.SetLabelValue('PXKFPRTVXX','innerHTML',tmp_PXKFPRTVXX);
e_PXKFPRTVXX=tmp_PXKFPRTVXX;
}
var tmp_UWUWSYENHG = ToHTag(AsControlValue(w_xdescrap));
if (Ne(e_UWUWSYENHG,tmp_UWUWSYENHG)) {
SPBOUILib.SetLabelValue('UWUWSYENHG','innerHTML',tmp_UWUWSYENHG);
e_UWUWSYENHG=tmp_UWUWSYENHG;
}
var tmp_QGPWBVUZYW = ToHTag(AsControlValue(w_xragsocct));
if (Ne(e_QGPWBVUZYW,tmp_QGPWBVUZYW)) {
SPBOUILib.SetLabelValue('QGPWBVUZYW','innerHTML',tmp_QGPWBVUZYW);
e_QGPWBVUZYW=tmp_QGPWBVUZYW;
}
var tmp_USZXRLYSFT = ToHTag(AsControlValue(w_xragsocben));
if (Ne(e_USZXRLYSFT,tmp_USZXRLYSFT)) {
SPBOUILib.SetLabelValue('USZXRLYSFT','innerHTML',tmp_USZXRLYSFT);
e_USZXRLYSFT=tmp_USZXRLYSFT;
}
var tmp_BLXOBUQVYE = ToHTag(AsControlValue(w_xDescDipe));
if (Ne(e_BLXOBUQVYE,tmp_BLXOBUQVYE)) {
SPBOUILib.SetLabelValue('BLXOBUQVYE','innerHTML',tmp_BLXOBUQVYE);
e_BLXOBUQVYE=tmp_BLXOBUQVYE;
}
var tmp_THOGQCLBJA = ToHTag(AsControlValue(w_xdes1));
if (Ne(e_THOGQCLBJA,tmp_THOGQCLBJA)) {
SPBOUILib.SetLabelValue('THOGQCLBJA','innerHTML',tmp_THOGQCLBJA);
e_THOGQCLBJA=tmp_THOGQCLBJA;
}
if(c=Ctrl('QSRYXQJCBZ')) selectCombo(c,w_FLAGFRAZ,'C')
SPBOUILib.SetInputValue('VYBZEWHKFF',function(){return WtH(w_DATARETT,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATARETT);
SPBOUILib.SetInputValue('MSGBKOOAOY',function(){return WtH(w_COLLEG,'C',11,0,'')},w_COLLEG);
SPBOUILib.SetInputValue('OJGQABFSYN',function(){return WtH(w_PROVINCIA,'C',2,0,'')},w_PROVINCIA);
SPBOUILib.SetInputValue('OZEOCQRSEQ',function(){return WtH(w_CODCAB,'C',6,0,'')},w_CODCAB);
var tmp_PDLOBCDELX = ToHTag(AsControlValue(w_xragsocalt));
if (Ne(e_PDLOBCDELX,tmp_PDLOBCDELX)) {
SPBOUILib.SetLabelValue('PDLOBCDELX','innerHTML',tmp_PDLOBCDELX);
e_PDLOBCDELX=tmp_PDLOBCDELX;
}
var tmp_MYPLEXWRTO = ToHTag(AsControlValue(w_xdescpaese2));
if (Ne(e_MYPLEXWRTO,tmp_MYPLEXWRTO)) {
SPBOUILib.SetLabelValue('MYPLEXWRTO','innerHTML',tmp_MYPLEXWRTO);
e_MYPLEXWRTO=tmp_MYPLEXWRTO;
}
var tmp_POOUDEGCOH = ToHTag(AsControlValue(w_xdciticon));
if (Ne(e_POOUDEGCOH,tmp_POOUDEGCOH)) {
SPBOUILib.SetLabelValue('POOUDEGCOH','innerHTML',tmp_POOUDEGCOH);
e_POOUDEGCOH=tmp_POOUDEGCOH;
}
SPBOUILib.SetInputValue('JDTKGSGMAF',function(){return WtH(w_MTCN,'C',10,0,'')},w_MTCN);
SPBOUILib.SetInputValue('HELEAXSQUV',function(){return WtH(w_prova,'N',15,0,'')},w_prova);
var tmp_ESVLUSNYWB = ToHTag(AsControlValue(w_dessta));
if (Ne(e_ESVLUSNYWB,tmp_ESVLUSNYWB)) {
SPBOUILib.SetLabelValue('ESVLUSNYWB','innerHTML',tmp_ESVLUSNYWB);
e_ESVLUSNYWB=tmp_ESVLUSNYWB;
}
SPBOUILib.SetInputValue('AKAVLTKFQJ',function(){return WtH(w_CODINTER,'C',11,0,'')},w_CODINTER);
SPBOUILib.SetInputValue('VFSCXTRPBT',function(){return WtH(w_CODDIPE,'C',6,0,'')},w_CODDIPE);
SPBOUILib.SetInputValue('DYLLKXEEFX',function(){return WtH(w_DESCCIT,'C',30,0,'')},w_DESCCIT);
var tmp_MCIRMMHGPK = ToHTag(AsControlValue(w_xDescDipe));
if (Ne(e_MCIRMMHGPK,tmp_MCIRMMHGPK)) {
SPBOUILib.SetLabelValue('MCIRMMHGPK','innerHTML',tmp_MCIRMMHGPK);
e_MCIRMMHGPK=tmp_MCIRMMHGPK;
}
SPBOUILib.SetInputValue('BLITNRBDXW',function(){return WtH(w_PROVINCIA,'C',2,0,'')},w_PROVINCIA);
SPBOUILib.SetInputValue('GNRCJTZWLH',function(){return WtH(w_CODCAB,'C',6,0,'')},w_CODCAB);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay('YORQOIOBQN_DIV',IsHiddenByStateDriver('box_YORQOIOBQN'));
SetDisplay('BOYWPGJEEZ_DIV',IsHiddenByStateDriver('box_BOYWPGJEEZ'));
SetDisplay('XLSSDAVPDH_DIV',IsHiddenByStateDriver('box_XLSSDAVPDH'));
SetDisplay('ZPEPXLSZFA_DIV',IsHiddenByStateDriver('box_ZPEPXLSZFA'));
SetDisplay('YIVWPEZXIF_DIV',IsHiddenByStateDriver('box_YIVWPEZXIF'));
SetDisplay(Ctrl('NHERHRZTFP'),Eq(1,1) || IsHiddenByStateDriver('IDBASE'));
SetDisplay(Ctrl('QSRYXQJCBZ'),Eq(w_FLAGFRAZ,'1') || IsHiddenByStateDriver('FLAGFRAZ'));
SetDisplay(Ctrl('JHWWHHXDJI'),Eq(w_FLAGFRAZ,'1'));
SetDisplay(Ctrl('AWTMZMTFUL'),Ne(w_FLAGFRAZ,'1'));
SetDisplay(Ctrl('VYBZEWHKFF'),Eq(1,1) || IsHiddenByStateDriver('DATARETT'));
SetDisplay(Ctrl('MSGBKOOAOY'),Eq(w_FLAGFRAZ,'0') || IsHiddenByStateDriver('COLLEG'));
SetDisplay(Ctrl('MSGBKOOAOY_ZOOM'),Eq(w_FLAGFRAZ,'0'));
SetDisplay(Ctrl('WTYYEQYAIU'),Eq(w_FLAGFRAZ,'0'));
SetDisplay(Ctrl('KMXZXPWLPX'),Ne(w_gFlgDoc,'S'));
SetDisplay(Ctrl('JDTKGSGMAF'),Ne(w_gFlgWU,'S') || IsHiddenByStateDriver('MTCN'));
SetDisplay(Ctrl('EOJCZFADSY'),Ne(w_gFlgWU,'S'));
SetDisplay('BDZUATYPMW_DIV',IsHiddenByStateDriver('box_BDZUATYPMW'));
SetDisplay('EBQBWEDRVH_DIV',IsHiddenByStateDriver('box_EBQBWEDRVH'));
SetDisplay('GPZQGPPLEB_DIV',IsHiddenByStateDriver('box_GPZQGPPLEB'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["CAMBIO"]=['HTLKHJWKEZ'];
HideUI.lblids["CODANA"]=['RPGHLQLUDI'];
HideUI.lblids["CODCAB"]=['QGKAQODPMV','ENBRMMDVUP'];
HideUI.lblids["CODCAB2"]=['GXGGXKSESA'];
HideUI.lblids["CODDIPE"]=['XVRJYSKGWZ','JNCPEWXCUN'];
HideUI.lblids["CODINT2"]=['LNONRUGLMW'];
HideUI.lblids["CODINTER"]=['VREPXJWJVS','LOEAMXUYLA'];
HideUI.lblids["CODVOC"]=['GVUCGWQOGG'];
HideUI.lblids["COLLEG"]=['WTYYEQYAIU'];
HideUI.lblids["CONNALTRO"]=['OQXSPVCWCC'];
HideUI.lblids["CONNESBEN"]=['LZDWHHTSGR'];
HideUI.lblids["CONNESCLI"]=['NUEFWOMRRX'];
HideUI.lblids["CONNESOPER"]=['IINONMZPLB'];
HideUI.lblids["C_CAB"]=['WHMXTGXWGC'];
HideUI.lblids["C_CAP"]=['GDOCAGKROT'];
HideUI.lblids["C_CTA"]=['XPSQTBKQQZ'];
HideUI.lblids["C_IND"]=['TWTXGZJTAR'];
HideUI.lblids["C_PRV"]=['SBJQIAQUCN'];
HideUI.lblids["C_RAG"]=['PFEQRACAUA'];
HideUI.lblids["C_RAPPORTO"]=['UBVWWLXEKS'];
HideUI.lblids["C_STA"]=['RZBLEGCFJJ'];
HideUI.lblids["DATAOPE"]=['HVHVAYPDJE'];
HideUI.lblids["DATAREG"]=['IKBMEWKQJW'];
HideUI.lblids["DESC2"]=['ZTIARSVAXX'];
HideUI.lblids["DESCCIT"]=['IJHBNGIMWX','CTLYJMTHDV'];
HideUI.lblids["DESCINTER"]=['MZACLGVARN'];
HideUI.lblids["FLAGCONT"]=['GVTXMEILAZ'];
HideUI.lblids["FLAGFRAZ"]=['JHWWHHXDJI'];
HideUI.lblids["MTCN"]=['EOJCZFADSY'];
HideUI.lblids["NUMPROG"]=['KDUGHGZUUG'];
HideUI.lblids["PAESE"]=['JJLAKRDJXU'];
HideUI.lblids["PROV2"]=['IDAYTSKPPF'];
HideUI.lblids["PROVINCIA"]=['WPNDWMVHEX','JWSDOSRGAG'];
HideUI.lblids["RAPPORTO"]=['EXIXNLTCBE'];
HideUI.lblids["SEGNO"]=['PQFNSCNIRZ'];
HideUI.lblids["TIPOINT2"]=['CFRJFQBTVV'];
HideUI.lblids["TIPOLEG"]=['VECGHPFLII'];
HideUI.lblids["TIPOOPRAP"]=['KMCNAWQHKV'];
HideUI.lblids["VALUTA"]=['UIZWPHSLNT'];
HideUI.lblids["ZCPARTE"]=['IMHKHLSVQZ'];
HideUI.lblids["appolire"]=['EQARGRKLGY'];
HideUI.lblids["xTOTCONT"]=['IDTBMNCIOX'];
HideUI.lblids["xTOTLIRE"]=['XLNVLBYVQX'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
cond= ! (Empty(w_C_RAG));
if (Ne(o_ZPEPXLSZFA_expand,cond)) {
ExpandCollapsibleBox('ZPEPXLSZFA',cond);
o_ZPEPXLSZFA_expand=cond;
}
cond= ! (Empty(w_C_RAG));
if (Ne(o_YIVWPEZXIF_expand,cond)) {
ExpandCollapsibleBox('YIVWPEZXIF',cond);
o_YIVWPEZXIF_expand=cond;
}
}
function YLIKFVPZJA_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('YLIKFVPZJA'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('YLIKFVPZJA').value=ApplyPictureToDate(Ctrl('YLIKFVPZJA').value,TranslatePicture(datePattern),'YLIKFVPZJA');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('YLIKFVPZJA'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('YLIKFVPZJA');
}
}
}
SetActiveField(Ctrl('YLIKFVPZJA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAOPE','D',w_DATAOPE,HtW(Ctrl('YLIKFVPZJA').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAOPE(HtW(Ctrl('YLIKFVPZJA').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function YLIKFVPZJA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YLIKFVPZJA'))) {
DisplayErrorMessage();
}
if ( ! (GetDisabled('YLIKFVPZJA'))) {
if (Eq(w_DATAOPE,NullDate()) && Eq(_tracker.ctrl,null)) {
Ctrl('YLIKFVPZJA').value=WtH(SystemDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
} else {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('YLIKFVPZJA',w_DATAOPE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
}
m_oEnteredInDate=Ctrl('YLIKFVPZJA');
SetActiveField(Ctrl('YLIKFVPZJA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YLIKFVPZJA'),e);
}
function OEIKQOZMYJ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('OEIKQOZMYJ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('OEIKQOZMYJ').value=ApplyPictureToDate(Ctrl('OEIKQOZMYJ').value,TranslatePicture(datePattern),'OEIKQOZMYJ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('OEIKQOZMYJ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('OEIKQOZMYJ');
}
}
}
SetActiveField(Ctrl('OEIKQOZMYJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAREG','D',w_DATAREG,HtW(Ctrl('OEIKQOZMYJ').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAREG(HtW(Ctrl('OEIKQOZMYJ').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function OEIKQOZMYJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OEIKQOZMYJ'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('OEIKQOZMYJ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('OEIKQOZMYJ',w_DATAREG,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('OEIKQOZMYJ');
SetActiveField(Ctrl('OEIKQOZMYJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OEIKQOZMYJ'),e);
}
function PURPSXEVAI_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLAGCONT','C',w_FLAGCONT,HtW(getComboValue(Ctrl('PURPSXEVAI')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLAGCONT(HtW(getComboValue(Ctrl('PURPSXEVAI')),'C'),null,e);
return l_bSetResult;
}
}
function PURPSXEVAI_OnFocus(e) {
SetActiveField(Ctrl('PURPSXEVAI'),true);
}
function PURPSXEVAI_OnBlur(e) {
SetActiveField(Ctrl('PURPSXEVAI'),false);
}
function UJRFWINIVQ_Valid(e) {
SetActiveField(Ctrl('UJRFWINIVQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOOPRAP','C',w_TIPOOPRAP,HtW(Ctrl('UJRFWINIVQ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOOPRAP(HtW(Ctrl('UJRFWINIVQ').value,'C'),null,e);
return l_bSetResult;
}
}
function UJRFWINIVQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UJRFWINIVQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UJRFWINIVQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UJRFWINIVQ'),e);
}
function UJRFWINIVQ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('UJRFWINIVQ')),'linkview_UJRFWINIVQ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function SQVJLYRFKQ_Valid(e) {
SetActiveField(Ctrl('SQVJLYRFKQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODANA','C',w_CODANA,HtW(Ctrl('SQVJLYRFKQ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODANA(HtW(Ctrl('SQVJLYRFKQ').value,'C'),null,e);
return l_bSetResult;
}
}
function SQVJLYRFKQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SQVJLYRFKQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SQVJLYRFKQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SQVJLYRFKQ'),e);
}
function SQVJLYRFKQ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('SQVJLYRFKQ')),'linkview_SQVJLYRFKQ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function SRWWPHPCUB_Valid(e) {
SetActiveField(Ctrl('SRWWPHPCUB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODVOC','C',w_CODVOC,HtW(Ctrl('SRWWPHPCUB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODVOC(HtW(Ctrl('SRWWPHPCUB').value,'C'),null,e);
return l_bSetResult;
}
}
function SRWWPHPCUB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SRWWPHPCUB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SRWWPHPCUB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SRWWPHPCUB'),e);
}
function SRWWPHPCUB_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('SRWWPHPCUB')),'linkview_SRWWPHPCUB','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function LJBMCCABSS_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('appolire','C',w_appolire,HtW(getComboValue(Ctrl('LJBMCCABSS')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_appolire(HtW(getComboValue(Ctrl('LJBMCCABSS')),'C'),null,e);
return l_bSetResult;
}
}
function LJBMCCABSS_OnFocus(e) {
SetActiveField(Ctrl('LJBMCCABSS'),true);
}
function LJBMCCABSS_OnBlur(e) {
SetActiveField(Ctrl('LJBMCCABSS'),false);
}
function MKCXJZEKIG_Valid(e) {
SetActiveField(Ctrl('MKCXJZEKIG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('VALUTA','C',w_VALUTA,HtW(Ctrl('MKCXJZEKIG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VALUTA(HtW(Ctrl('MKCXJZEKIG').value,'C'),null,e);
return l_bSetResult;
}
}
function MKCXJZEKIG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MKCXJZEKIG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MKCXJZEKIG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MKCXJZEKIG'),e);
}
function MKCXJZEKIG_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('MKCXJZEKIG')),'linkview_MKCXJZEKIG','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function YTCDGCPEDJ_Valid(e) {
SetActiveField(Ctrl('YTCDGCPEDJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CAMBIO','N',w_CAMBIO,HtW(Ctrl('YTCDGCPEDJ').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAMBIO(HtW(Ctrl('YTCDGCPEDJ').value,'N'),null,e);
return l_bSetResult;
}
}
function YTCDGCPEDJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YTCDGCPEDJ'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('YTCDGCPEDJ',w_CAMBIO,'N',9,4,'9999.9999');
SetActiveField(Ctrl('YTCDGCPEDJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YTCDGCPEDJ'),e);
}
function YTCDGCPEDJ_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("9999.9999"));
}
function EDIXWZNSIC_Valid(e) {
SetActiveField(Ctrl('EDIXWZNSIC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('xTOTLIRE','N',w_xTOTLIRE,HtW(Ctrl('EDIXWZNSIC').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_xTOTLIRE(HtW(Ctrl('EDIXWZNSIC').value,'N'),null,e);
return l_bSetResult;
}
}
function EDIXWZNSIC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EDIXWZNSIC'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('EDIXWZNSIC'))) {
SPBOUILib.WtH('EDIXWZNSIC',w_xTOTLIRE,'N',15,2,'999999999999.99');
}
SetActiveField(Ctrl('EDIXWZNSIC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EDIXWZNSIC'),e);
}
function EDIXWZNSIC_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999.99"));
}
function CTORYEJVDR_Valid(e) {
SetActiveField(Ctrl('CTORYEJVDR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('xTOTCONT','N',w_xTOTCONT,HtW(Ctrl('CTORYEJVDR').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_xTOTCONT(HtW(Ctrl('CTORYEJVDR').value,'N'),null,e);
return l_bSetResult;
}
}
function CTORYEJVDR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CTORYEJVDR'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('CTORYEJVDR'))) {
SPBOUILib.WtH('CTORYEJVDR',w_xTOTCONT,'N',15,2,'999999999999.99');
}
SetActiveField(Ctrl('CTORYEJVDR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CTORYEJVDR'),e);
}
function CTORYEJVDR_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999.99"));
}
function RZIQZFKPUE_Valid(e) {
SetActiveField(Ctrl('RZIQZFKPUE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RAPPORTO','C',w_RAPPORTO,HtW(Ctrl('RZIQZFKPUE').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAPPORTO(HtW(Ctrl('RZIQZFKPUE').value,'C'),null,e);
return l_bSetResult;
}
}
function RZIQZFKPUE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RZIQZFKPUE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RZIQZFKPUE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RZIQZFKPUE'),e);
}
function RZIQZFKPUE_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('RZIQZFKPUE')),'linkview_RZIQZFKPUE','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function QBLXDBODXR_Valid(e) {
SetActiveField(Ctrl('QBLXDBODXR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CONNESCLI','C',w_CONNESCLI,HtW(Ctrl('QBLXDBODXR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONNESCLI(HtW(Ctrl('QBLXDBODXR').value,'C'),null,e);
return l_bSetResult;
}
}
function QBLXDBODXR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QBLXDBODXR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QBLXDBODXR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QBLXDBODXR'),e);
}
function QBLXDBODXR_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('QBLXDBODXR')),'linkview_QBLXDBODXR','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function TCOTJNZLGM_Valid(e) {
SetActiveField(Ctrl('TCOTJNZLGM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CONNESOPER','C',w_CONNESOPER,HtW(Ctrl('TCOTJNZLGM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONNESOPER(HtW(Ctrl('TCOTJNZLGM').value,'C'),null,e);
return l_bSetResult;
}
}
function TCOTJNZLGM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TCOTJNZLGM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TCOTJNZLGM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TCOTJNZLGM'),e);
}
function TCOTJNZLGM_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('TCOTJNZLGM')),'linkview_TCOTJNZLGM','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function AQSAREJVST_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOLEG','C',w_TIPOLEG,HtW(getComboValue(Ctrl('AQSAREJVST')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOLEG(HtW(getComboValue(Ctrl('AQSAREJVST')),'C'),null,e);
return l_bSetResult;
}
}
function AQSAREJVST_OnFocus(e) {
SetActiveField(Ctrl('AQSAREJVST'),true);
}
function AQSAREJVST_OnBlur(e) {
SetActiveField(Ctrl('AQSAREJVST'),false);
}
function JGKMKQMAHS_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('PAGASOGOP','C',w_PAGASOGOP,ChkboxValueAssign(Ctrl('JGKMKQMAHS'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PAGASOGOP(ChkboxValueAssign(Ctrl('JGKMKQMAHS'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function JGKMKQMAHS_OnFocus(e) {
SetActiveField(Ctrl('JGKMKQMAHS'),true);
}
function JGKMKQMAHS_OnBlur(e) {
SetActiveField(Ctrl('JGKMKQMAHS'),false);
}
function ULVCBLFVEU_Valid(e) {
SetActiveField(Ctrl('ULVCBLFVEU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CONNESBEN','C',w_CONNESBEN,HtW(Ctrl('ULVCBLFVEU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONNESBEN(HtW(Ctrl('ULVCBLFVEU').value,'C'),null,e);
return l_bSetResult;
}
}
function ULVCBLFVEU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ULVCBLFVEU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ULVCBLFVEU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ULVCBLFVEU'),e);
}
function ULVCBLFVEU_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('ULVCBLFVEU')),'linkview_ULVCBLFVEU','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function HWFHDWYMIU_Valid(e) {
SetActiveField(Ctrl('HWFHDWYMIU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CONNALTRO','C',w_CONNALTRO,HtW(Ctrl('HWFHDWYMIU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONNALTRO(HtW(Ctrl('HWFHDWYMIU').value,'C'),null,e);
return l_bSetResult;
}
}
function HWFHDWYMIU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HWFHDWYMIU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HWFHDWYMIU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HWFHDWYMIU'),e);
}
function HWFHDWYMIU_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('HWFHDWYMIU')),'linkview_HWFHDWYMIU','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function AWPNTOJIRR_Valid(e) {
SetActiveField(Ctrl('AWPNTOJIRR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_RAG','C',w_C_RAG,HtW(Ctrl('AWPNTOJIRR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_RAG(HtW(Ctrl('AWPNTOJIRR').value,'C'),null,e);
return l_bSetResult;
}
}
function AWPNTOJIRR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AWPNTOJIRR'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('AWPNTOJIRR',w_C_RAG,'C',70,0,'@!');
SetActiveField(Ctrl('AWPNTOJIRR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AWPNTOJIRR'),e);
}
function AWPNTOJIRR_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function ODAYKSRECA_Valid(e) {
SetActiveField(Ctrl('ODAYKSRECA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_CTA','C',w_C_CTA,HtW(Ctrl('ODAYKSRECA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_CTA(HtW(Ctrl('ODAYKSRECA').value,'C'),null,e);
return l_bSetResult;
}
}
function ODAYKSRECA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ODAYKSRECA'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('ODAYKSRECA',w_C_CTA,'C',30,0,'@!');
SetActiveField(Ctrl('ODAYKSRECA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ODAYKSRECA'),e);
}
function ODAYKSRECA_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function ODAYKSRECA_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('ODAYKSRECA')),'linkview_ODAYKSRECA','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function NOTZPDMYIA_Valid(e) {
SetActiveField(Ctrl('NOTZPDMYIA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_PRV','C',w_C_PRV,HtW(Ctrl('NOTZPDMYIA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_PRV(HtW(Ctrl('NOTZPDMYIA').value,'C'),null,e);
return l_bSetResult;
}
}
function NOTZPDMYIA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NOTZPDMYIA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NOTZPDMYIA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NOTZPDMYIA'),e);
}
function RDAVOEETJG_Valid(e) {
SetActiveField(Ctrl('RDAVOEETJG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_CAP','C',w_C_CAP,HtW(Ctrl('RDAVOEETJG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_CAP(HtW(Ctrl('RDAVOEETJG').value,'C'),null,e);
return l_bSetResult;
}
}
function RDAVOEETJG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RDAVOEETJG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RDAVOEETJG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RDAVOEETJG'),e);
}
function BOTAJBWHHY_Valid(e) {
SetActiveField(Ctrl('BOTAJBWHHY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_CAB','C',w_C_CAB,HtW(Ctrl('BOTAJBWHHY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_CAB(HtW(Ctrl('BOTAJBWHHY').value,'C'),null,e);
return l_bSetResult;
}
}
function BOTAJBWHHY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BOTAJBWHHY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BOTAJBWHHY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BOTAJBWHHY'),e);
}
function VYLHWTRQNX_Valid(e) {
SetActiveField(Ctrl('VYLHWTRQNX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_IND','C',w_C_IND,HtW(Ctrl('VYLHWTRQNX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_IND(HtW(Ctrl('VYLHWTRQNX').value,'C'),null,e);
return l_bSetResult;
}
}
function VYLHWTRQNX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VYLHWTRQNX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VYLHWTRQNX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VYLHWTRQNX'),e);
}
function YVIKEGPYPM_Valid(e) {
SetActiveField(Ctrl('YVIKEGPYPM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_STA','C',w_C_STA,HtW(Ctrl('YVIKEGPYPM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_STA(HtW(Ctrl('YVIKEGPYPM').value,'C'),null,e);
return l_bSetResult;
}
}
function YVIKEGPYPM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YVIKEGPYPM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YVIKEGPYPM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YVIKEGPYPM'),e);
}
function YVIKEGPYPM_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('YVIKEGPYPM')),'linkview_YVIKEGPYPM','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function HNMYJPHSQN_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOINT2','C',w_TIPOINT2,HtW(getComboValue(Ctrl('HNMYJPHSQN')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOINT2(HtW(getComboValue(Ctrl('HNMYJPHSQN')),'C'),null,e);
return l_bSetResult;
}
}
function HNMYJPHSQN_OnFocus(e) {
SetActiveField(Ctrl('HNMYJPHSQN'),true);
}
function HNMYJPHSQN_OnBlur(e) {
SetActiveField(Ctrl('HNMYJPHSQN'),false);
}
function CDJFSCCGNX_Valid(e) {
SetActiveField(Ctrl('CDJFSCCGNX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODINT2','C',w_CODINT2,HtW(Ctrl('CDJFSCCGNX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODINT2(HtW(Ctrl('CDJFSCCGNX').value,'C'),null,e);
return l_bSetResult;
}
}
function CDJFSCCGNX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CDJFSCCGNX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CDJFSCCGNX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CDJFSCCGNX'),e);
}
function CDJFSCCGNX_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('CDJFSCCGNX')),'linkview_CDJFSCCGNX','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function VYDRMHACRY_Valid(e) {
SetActiveField(Ctrl('VYDRMHACRY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCINTER','C',w_DESCINTER,HtW(Ctrl('VYDRMHACRY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCINTER(HtW(Ctrl('VYDRMHACRY').value,'C'),null,e);
return l_bSetResult;
}
}
function VYDRMHACRY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VYDRMHACRY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VYDRMHACRY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VYDRMHACRY'),e);
}
function NYRJHOZOON_Valid(e) {
SetActiveField(Ctrl('NYRJHOZOON'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PAESE','C',w_PAESE,HtW(Ctrl('NYRJHOZOON').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PAESE(HtW(Ctrl('NYRJHOZOON').value,'C'),null,e);
return l_bSetResult;
}
}
function NYRJHOZOON_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NYRJHOZOON'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NYRJHOZOON'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NYRJHOZOON'),e);
}
function NYRJHOZOON_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('NYRJHOZOON')),'linkview_NYRJHOZOON','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function NZZUAIJFDU_Valid(e) {
SetActiveField(Ctrl('NZZUAIJFDU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_RAPPORTO','C',w_C_RAPPORTO,HtW(Ctrl('NZZUAIJFDU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_RAPPORTO(HtW(Ctrl('NZZUAIJFDU').value,'C'),null,e);
return l_bSetResult;
}
}
function NZZUAIJFDU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NZZUAIJFDU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NZZUAIJFDU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NZZUAIJFDU'),e);
}
function YQINIDXZSL_Valid(e) {
SetActiveField(Ctrl('YQINIDXZSL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODCAB2','C',w_CODCAB2,HtW(Ctrl('YQINIDXZSL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODCAB2(HtW(Ctrl('YQINIDXZSL').value,'C'),null,e);
return l_bSetResult;
}
}
function YQINIDXZSL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YQINIDXZSL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YQINIDXZSL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YQINIDXZSL'),e);
}
function YQINIDXZSL_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('YQINIDXZSL')),'linkview_YQINIDXZSL','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function ACAPFGYRVI_Valid(e) {
SetActiveField(Ctrl('ACAPFGYRVI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PROV2','C',w_PROV2,HtW(Ctrl('ACAPFGYRVI').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PROV2(HtW(Ctrl('ACAPFGYRVI').value,'C'),null,e);
return l_bSetResult;
}
}
function ACAPFGYRVI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ACAPFGYRVI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ACAPFGYRVI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ACAPFGYRVI'),e);
}
function FFCAGQAZHK_Valid(e) {
SetActiveField(Ctrl('FFCAGQAZHK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESC2','C',w_DESC2,HtW(Ctrl('FFCAGQAZHK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESC2(HtW(Ctrl('FFCAGQAZHK').value,'C'),null,e);
return l_bSetResult;
}
}
function FFCAGQAZHK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FFCAGQAZHK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FFCAGQAZHK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FFCAGQAZHK'),e);
}
function GXMZZZHVBR_Valid(e) {
SetActiveField(Ctrl('GXMZZZHVBR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ZCPARTE','C',w_ZCPARTE,HtW(Ctrl('GXMZZZHVBR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ZCPARTE(HtW(Ctrl('GXMZZZHVBR').value,'C'),null,e);
return l_bSetResult;
}
}
function GXMZZZHVBR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GXMZZZHVBR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GXMZZZHVBR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GXMZZZHVBR'),e);
}
function NHERHRZTFP_Valid(e) {
SetActiveField(Ctrl('NHERHRZTFP'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('NHERHRZTFP') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('IDBASE','C',w_IDBASE,HtW(Ctrl('NHERHRZTFP').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDBASE(HtW(Ctrl('NHERHRZTFP').value,'C'),null,e);
return l_bSetResult;
}
}
function NHERHRZTFP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NHERHRZTFP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NHERHRZTFP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NHERHRZTFP'),e);
}
function AVHTGZTOSZ_Valid(e) {
SetActiveField(Ctrl('AVHTGZTOSZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODDIPE','C',w_CODDIPE,HtW(Ctrl('AVHTGZTOSZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODDIPE(HtW(Ctrl('AVHTGZTOSZ').value,'C'),null,e);
return l_bSetResult;
}
}
function AVHTGZTOSZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AVHTGZTOSZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('AVHTGZTOSZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AVHTGZTOSZ'),e);
}
function AVHTGZTOSZ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('AVHTGZTOSZ')),'linkview_AVHTGZTOSZ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function QSRYXQJCBZ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLAGFRAZ','C',w_FLAGFRAZ,HtW(getComboValue(Ctrl('QSRYXQJCBZ')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLAGFRAZ(HtW(getComboValue(Ctrl('QSRYXQJCBZ')),'C'),null,e);
return l_bSetResult;
}
}
function QSRYXQJCBZ_OnFocus(e) {
SetActiveField(Ctrl('QSRYXQJCBZ'),true);
}
function QSRYXQJCBZ_OnBlur(e) {
SetActiveField(Ctrl('QSRYXQJCBZ'),false);
}
function VYBZEWHKFF_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('VYBZEWHKFF'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('VYBZEWHKFF').value=ApplyPictureToDate(Ctrl('VYBZEWHKFF').value,TranslatePicture(datePattern),'VYBZEWHKFF');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('VYBZEWHKFF'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('VYBZEWHKFF');
}
}
}
SetActiveField(Ctrl('VYBZEWHKFF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATARETT','D',w_DATARETT,HtW(Ctrl('VYBZEWHKFF').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATARETT(HtW(Ctrl('VYBZEWHKFF').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function VYBZEWHKFF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VYBZEWHKFF'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('VYBZEWHKFF',w_DATARETT,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('VYBZEWHKFF');
SetActiveField(Ctrl('VYBZEWHKFF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VYBZEWHKFF'),e);
}
function MSGBKOOAOY_Valid(e) {
SetActiveField(Ctrl('MSGBKOOAOY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('COLLEG','C',w_COLLEG,HtW(Ctrl('MSGBKOOAOY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_COLLEG(HtW(Ctrl('MSGBKOOAOY').value,'C'),null,e);
return l_bSetResult;
}
}
function MSGBKOOAOY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MSGBKOOAOY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MSGBKOOAOY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MSGBKOOAOY'),e);
}
function MSGBKOOAOY_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('MSGBKOOAOY')),'linkview_MSGBKOOAOY','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function href_KMXZXPWLPX() {
var l_oWv = InitWvApplet();
l_oWv.setValue('CONNES',AsAppletValue(w_CONNESDOC));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('CONNES'));
_modifyandopen('armt_kersonbo'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=view&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function JDTKGSGMAF_Valid(e) {
SetActiveField(Ctrl('JDTKGSGMAF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('MTCN','C',w_MTCN,HtW(Ctrl('JDTKGSGMAF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_MTCN(HtW(Ctrl('JDTKGSGMAF').value,'C'),null,e);
return l_bSetResult;
}
}
function JDTKGSGMAF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JDTKGSGMAF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JDTKGSGMAF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JDTKGSGMAF'),e);
}
function VFSCXTRPBT_Valid(e) {
SetActiveField(Ctrl('VFSCXTRPBT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODDIPE','C',w_CODDIPE,HtW(Ctrl('VFSCXTRPBT').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODDIPE(HtW(Ctrl('VFSCXTRPBT').value,'C'),null,e);
return l_bSetResult;
}
}
function VFSCXTRPBT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VFSCXTRPBT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VFSCXTRPBT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VFSCXTRPBT'),e);
}
function VFSCXTRPBT_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('VFSCXTRPBT')),'linkview_VFSCXTRPBT','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
linkpc_url.u('BOAFVDQFRN',function(){return 'ardt_clientisara?m_bInnerChild=true'+GetLinkPCKeys('ardt_clientisara')+'&m_bRowsChild='+EnableChild('ardt_clientisara')})
_ResetTracker();
function setEventHandlers() {
var c;
function KMXZXPWLPX_wrap_OnClick(event) {
return href_KMXZXPWLPX();
}
SPBOUILib.SetImageClick('KMXZXPWLPX',KMXZXPWLPX_wrap_OnClick);
function KMXZXPWLPX_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('KMXZXPWLPX',KMXZXPWLPX_wrap_OnKeyDown);
if (Ne(m_cFunction,'view')) {
function YLIKFVPZJA_wrap_Valid(event) {
return YLIKFVPZJA_Valid(event);
}
SPBOUILib.SetInputExit('YLIKFVPZJA',YLIKFVPZJA_wrap_Valid);
function YLIKFVPZJA_wrap_OnFocus(event) {
return YLIKFVPZJA_OnFocus(event);
}
SPBOUILib.SetInputEnter('YLIKFVPZJA',YLIKFVPZJA_wrap_OnFocus);
function YLIKFVPZJA_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('YLIKFVPZJA',YLIKFVPZJA_wrap_OnKeyPress);
function YLIKFVPZJA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('YLIKFVPZJA',YLIKFVPZJA_wrap_OnKeyDown);
function OEIKQOZMYJ_wrap_Valid(event) {
return OEIKQOZMYJ_Valid(event);
}
SPBOUILib.SetInputExit('OEIKQOZMYJ',OEIKQOZMYJ_wrap_Valid);
function OEIKQOZMYJ_wrap_OnFocus(event) {
return OEIKQOZMYJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('OEIKQOZMYJ',OEIKQOZMYJ_wrap_OnFocus);
function OEIKQOZMYJ_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('OEIKQOZMYJ',OEIKQOZMYJ_wrap_OnKeyPress);
function OEIKQOZMYJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('OEIKQOZMYJ',OEIKQOZMYJ_wrap_OnKeyDown);
function PURPSXEVAI_wrap_Valid(event) {
return PURPSXEVAI_Valid(event);
}
SPBOUILib.SetComboChange('PURPSXEVAI',PURPSXEVAI_wrap_Valid);
function PURPSXEVAI_wrap_OnFocus(event) {
return PURPSXEVAI_OnFocus(event);
}
SPBOUILib.SetInputEnter('PURPSXEVAI',PURPSXEVAI_wrap_OnFocus);
function PURPSXEVAI_wrap_Blur(event) {
return PURPSXEVAI_OnBlur(event);
}
SPBOUILib.SetInputExit('PURPSXEVAI',PURPSXEVAI_wrap_Blur);
function UJRFWINIVQ_wrap_Valid(event) {
return UJRFWINIVQ_Valid(event);
}
SPBOUILib.SetInputExit('UJRFWINIVQ',UJRFWINIVQ_wrap_Valid);
function UJRFWINIVQ_wrap_OnFocus(event) {
return UJRFWINIVQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('UJRFWINIVQ',UJRFWINIVQ_wrap_OnFocus);
function UJRFWINIVQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UJRFWINIVQ',UJRFWINIVQ_wrap_OnKeyDown);
function UJRFWINIVQ_ZOOM_setHandlers() {
function UJRFWINIVQ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?UJRFWINIVQ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('UJRFWINIVQ_ZOOM',UJRFWINIVQ_ZOOM_wrap_OnClick);
function UJRFWINIVQ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('UJRFWINIVQ_ZOOM',UJRFWINIVQ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('UJRFWINIVQ',UJRFWINIVQ_ZOOM_setHandlers);
function SQVJLYRFKQ_wrap_Valid(event) {
return SQVJLYRFKQ_Valid(event);
}
SPBOUILib.SetInputExit('SQVJLYRFKQ',SQVJLYRFKQ_wrap_Valid);
function SQVJLYRFKQ_wrap_OnFocus(event) {
return SQVJLYRFKQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('SQVJLYRFKQ',SQVJLYRFKQ_wrap_OnFocus);
function SQVJLYRFKQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SQVJLYRFKQ',SQVJLYRFKQ_wrap_OnKeyDown);
function SQVJLYRFKQ_ZOOM_setHandlers() {
function SQVJLYRFKQ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?SQVJLYRFKQ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('SQVJLYRFKQ_ZOOM',SQVJLYRFKQ_ZOOM_wrap_OnClick);
function SQVJLYRFKQ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('SQVJLYRFKQ_ZOOM',SQVJLYRFKQ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('SQVJLYRFKQ',SQVJLYRFKQ_ZOOM_setHandlers);
function SRWWPHPCUB_wrap_Valid(event) {
return SRWWPHPCUB_Valid(event);
}
SPBOUILib.SetInputExit('SRWWPHPCUB',SRWWPHPCUB_wrap_Valid);
function SRWWPHPCUB_wrap_OnFocus(event) {
return SRWWPHPCUB_OnFocus(event);
}
SPBOUILib.SetInputEnter('SRWWPHPCUB',SRWWPHPCUB_wrap_OnFocus);
function SRWWPHPCUB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SRWWPHPCUB',SRWWPHPCUB_wrap_OnKeyDown);
function SRWWPHPCUB_ZOOM_setHandlers() {
function SRWWPHPCUB_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?SRWWPHPCUB_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('SRWWPHPCUB_ZOOM',SRWWPHPCUB_ZOOM_wrap_OnClick);
function SRWWPHPCUB_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('SRWWPHPCUB_ZOOM',SRWWPHPCUB_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('SRWWPHPCUB',SRWWPHPCUB_ZOOM_setHandlers);
function LJBMCCABSS_wrap_Valid(event) {
return LJBMCCABSS_Valid(event);
}
SPBOUILib.SetComboChange('LJBMCCABSS',LJBMCCABSS_wrap_Valid);
function LJBMCCABSS_wrap_OnFocus(event) {
return LJBMCCABSS_OnFocus(event);
}
SPBOUILib.SetInputEnter('LJBMCCABSS',LJBMCCABSS_wrap_OnFocus);
function LJBMCCABSS_wrap_Blur(event) {
return LJBMCCABSS_OnBlur(event);
}
SPBOUILib.SetInputExit('LJBMCCABSS',LJBMCCABSS_wrap_Blur);
function MKCXJZEKIG_wrap_Valid(event) {
return MKCXJZEKIG_Valid(event);
}
SPBOUILib.SetInputExit('MKCXJZEKIG',MKCXJZEKIG_wrap_Valid);
function MKCXJZEKIG_wrap_OnFocus(event) {
return MKCXJZEKIG_OnFocus(event);
}
SPBOUILib.SetInputEnter('MKCXJZEKIG',MKCXJZEKIG_wrap_OnFocus);
function MKCXJZEKIG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MKCXJZEKIG',MKCXJZEKIG_wrap_OnKeyDown);
function MKCXJZEKIG_ZOOM_setHandlers() {
function MKCXJZEKIG_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?MKCXJZEKIG_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('MKCXJZEKIG_ZOOM',MKCXJZEKIG_ZOOM_wrap_OnClick);
function MKCXJZEKIG_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('MKCXJZEKIG_ZOOM',MKCXJZEKIG_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('MKCXJZEKIG',MKCXJZEKIG_ZOOM_setHandlers);
function YTCDGCPEDJ_wrap_Valid(event) {
return YTCDGCPEDJ_Valid(event);
}
SPBOUILib.SetInputExit('YTCDGCPEDJ',YTCDGCPEDJ_wrap_Valid);
function YTCDGCPEDJ_wrap_OnFocus(event) {
return YTCDGCPEDJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('YTCDGCPEDJ',YTCDGCPEDJ_wrap_OnFocus);
function YTCDGCPEDJ_wrap_OnKeyPress(event) {
return YTCDGCPEDJ_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('YTCDGCPEDJ',YTCDGCPEDJ_wrap_OnKeyPress);
function YTCDGCPEDJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YTCDGCPEDJ',YTCDGCPEDJ_wrap_OnKeyDown);
function EDIXWZNSIC_wrap_Valid(event) {
return EDIXWZNSIC_Valid(event);
}
SPBOUILib.SetInputExit('EDIXWZNSIC',EDIXWZNSIC_wrap_Valid);
function EDIXWZNSIC_wrap_OnFocus(event) {
return EDIXWZNSIC_OnFocus(event);
}
SPBOUILib.SetInputEnter('EDIXWZNSIC',EDIXWZNSIC_wrap_OnFocus);
function EDIXWZNSIC_wrap_OnKeyPress(event) {
return EDIXWZNSIC_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('EDIXWZNSIC',EDIXWZNSIC_wrap_OnKeyPress);
function EDIXWZNSIC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('EDIXWZNSIC',EDIXWZNSIC_wrap_OnKeyDown);
function CTORYEJVDR_wrap_Valid(event) {
return CTORYEJVDR_Valid(event);
}
SPBOUILib.SetInputExit('CTORYEJVDR',CTORYEJVDR_wrap_Valid);
function CTORYEJVDR_wrap_OnFocus(event) {
return CTORYEJVDR_OnFocus(event);
}
SPBOUILib.SetInputEnter('CTORYEJVDR',CTORYEJVDR_wrap_OnFocus);
function CTORYEJVDR_wrap_OnKeyPress(event) {
return CTORYEJVDR_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('CTORYEJVDR',CTORYEJVDR_wrap_OnKeyPress);
function CTORYEJVDR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CTORYEJVDR',CTORYEJVDR_wrap_OnKeyDown);
function RZIQZFKPUE_wrap_Valid(event) {
return RZIQZFKPUE_Valid(event);
}
SPBOUILib.SetInputExit('RZIQZFKPUE',RZIQZFKPUE_wrap_Valid);
function RZIQZFKPUE_wrap_OnFocus(event) {
return RZIQZFKPUE_OnFocus(event);
}
SPBOUILib.SetInputEnter('RZIQZFKPUE',RZIQZFKPUE_wrap_OnFocus);
function RZIQZFKPUE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RZIQZFKPUE',RZIQZFKPUE_wrap_OnKeyDown);
function RZIQZFKPUE_ZOOM_setHandlers() {
function RZIQZFKPUE_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?RZIQZFKPUE_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('RZIQZFKPUE_ZOOM',RZIQZFKPUE_ZOOM_wrap_OnClick);
function RZIQZFKPUE_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('RZIQZFKPUE_ZOOM',RZIQZFKPUE_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('RZIQZFKPUE',RZIQZFKPUE_ZOOM_setHandlers);
function QBLXDBODXR_wrap_Valid(event) {
return QBLXDBODXR_Valid(event);
}
SPBOUILib.SetInputExit('QBLXDBODXR',QBLXDBODXR_wrap_Valid);
function QBLXDBODXR_wrap_OnFocus(event) {
return QBLXDBODXR_OnFocus(event);
}
SPBOUILib.SetInputEnter('QBLXDBODXR',QBLXDBODXR_wrap_OnFocus);
function QBLXDBODXR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QBLXDBODXR',QBLXDBODXR_wrap_OnKeyDown);
function QBLXDBODXR_ZOOM_setHandlers() {
function QBLXDBODXR_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?QBLXDBODXR_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('QBLXDBODXR_ZOOM',QBLXDBODXR_ZOOM_wrap_OnClick);
function QBLXDBODXR_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('QBLXDBODXR_ZOOM',QBLXDBODXR_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('QBLXDBODXR',QBLXDBODXR_ZOOM_setHandlers);
function TCOTJNZLGM_wrap_Valid(event) {
return TCOTJNZLGM_Valid(event);
}
SPBOUILib.SetInputExit('TCOTJNZLGM',TCOTJNZLGM_wrap_Valid);
function TCOTJNZLGM_wrap_OnFocus(event) {
return TCOTJNZLGM_OnFocus(event);
}
SPBOUILib.SetInputEnter('TCOTJNZLGM',TCOTJNZLGM_wrap_OnFocus);
function TCOTJNZLGM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TCOTJNZLGM',TCOTJNZLGM_wrap_OnKeyDown);
function TCOTJNZLGM_ZOOM_setHandlers() {
function TCOTJNZLGM_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?TCOTJNZLGM_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('TCOTJNZLGM_ZOOM',TCOTJNZLGM_ZOOM_wrap_OnClick);
function TCOTJNZLGM_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('TCOTJNZLGM_ZOOM',TCOTJNZLGM_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('TCOTJNZLGM',TCOTJNZLGM_ZOOM_setHandlers);
function AQSAREJVST_wrap_Valid(event) {
return AQSAREJVST_Valid(event);
}
SPBOUILib.SetComboChange('AQSAREJVST',AQSAREJVST_wrap_Valid);
function AQSAREJVST_wrap_OnFocus(event) {
return AQSAREJVST_OnFocus(event);
}
SPBOUILib.SetInputEnter('AQSAREJVST',AQSAREJVST_wrap_OnFocus);
function AQSAREJVST_wrap_Blur(event) {
return AQSAREJVST_OnBlur(event);
}
SPBOUILib.SetInputExit('AQSAREJVST',AQSAREJVST_wrap_Blur);
function JGKMKQMAHS_wrap_Valid(event) {
return JGKMKQMAHS_Valid(event);
}
SPBOUILib.SetCheckboxClick('JGKMKQMAHS',JGKMKQMAHS_wrap_Valid);
function JGKMKQMAHS_wrap_OnFocus(event) {
return JGKMKQMAHS_OnFocus(event);
}
SPBOUILib.SetInputEnter('JGKMKQMAHS',JGKMKQMAHS_wrap_OnFocus);
function JGKMKQMAHS_wrap_Blur(event) {
return JGKMKQMAHS_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('JGKMKQMAHS',JGKMKQMAHS_wrap_Blur);
function ULVCBLFVEU_wrap_Valid(event) {
return ULVCBLFVEU_Valid(event);
}
SPBOUILib.SetInputExit('ULVCBLFVEU',ULVCBLFVEU_wrap_Valid);
function ULVCBLFVEU_wrap_OnFocus(event) {
return ULVCBLFVEU_OnFocus(event);
}
SPBOUILib.SetInputEnter('ULVCBLFVEU',ULVCBLFVEU_wrap_OnFocus);
function ULVCBLFVEU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ULVCBLFVEU',ULVCBLFVEU_wrap_OnKeyDown);
function ULVCBLFVEU_ZOOM_setHandlers() {
function ULVCBLFVEU_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ULVCBLFVEU_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('ULVCBLFVEU_ZOOM',ULVCBLFVEU_ZOOM_wrap_OnClick);
function ULVCBLFVEU_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('ULVCBLFVEU_ZOOM',ULVCBLFVEU_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('ULVCBLFVEU',ULVCBLFVEU_ZOOM_setHandlers);
function HWFHDWYMIU_wrap_Valid(event) {
return HWFHDWYMIU_Valid(event);
}
SPBOUILib.SetInputExit('HWFHDWYMIU',HWFHDWYMIU_wrap_Valid);
function HWFHDWYMIU_wrap_OnFocus(event) {
return HWFHDWYMIU_OnFocus(event);
}
SPBOUILib.SetInputEnter('HWFHDWYMIU',HWFHDWYMIU_wrap_OnFocus);
function HWFHDWYMIU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HWFHDWYMIU',HWFHDWYMIU_wrap_OnKeyDown);
function HWFHDWYMIU_ZOOM_setHandlers() {
function HWFHDWYMIU_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?HWFHDWYMIU_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('HWFHDWYMIU_ZOOM',HWFHDWYMIU_ZOOM_wrap_OnClick);
function HWFHDWYMIU_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('HWFHDWYMIU_ZOOM',HWFHDWYMIU_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('HWFHDWYMIU',HWFHDWYMIU_ZOOM_setHandlers);
function AWPNTOJIRR_wrap_Valid(event) {
return AWPNTOJIRR_Valid(event);
}
SPBOUILib.SetInputExit('AWPNTOJIRR',AWPNTOJIRR_wrap_Valid);
function AWPNTOJIRR_wrap_OnFocus(event) {
return AWPNTOJIRR_OnFocus(event);
}
SPBOUILib.SetInputEnter('AWPNTOJIRR',AWPNTOJIRR_wrap_OnFocus);
function AWPNTOJIRR_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('AWPNTOJIRR',AWPNTOJIRR_wrap_OnKeyPress);
function AWPNTOJIRR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AWPNTOJIRR',AWPNTOJIRR_wrap_OnKeyDown);
function ODAYKSRECA_wrap_Valid(event) {
return ODAYKSRECA_Valid(event);
}
SPBOUILib.SetInputExit('ODAYKSRECA',ODAYKSRECA_wrap_Valid);
function ODAYKSRECA_wrap_OnFocus(event) {
return ODAYKSRECA_OnFocus(event);
}
SPBOUILib.SetInputEnter('ODAYKSRECA',ODAYKSRECA_wrap_OnFocus);
function ODAYKSRECA_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('ODAYKSRECA',ODAYKSRECA_wrap_OnKeyPress);
function ODAYKSRECA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ODAYKSRECA',ODAYKSRECA_wrap_OnKeyDown);
function ODAYKSRECA_ZOOM_setHandlers() {
function ODAYKSRECA_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ODAYKSRECA_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('ODAYKSRECA_ZOOM',ODAYKSRECA_ZOOM_wrap_OnClick);
function ODAYKSRECA_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('ODAYKSRECA_ZOOM',ODAYKSRECA_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('ODAYKSRECA',ODAYKSRECA_ZOOM_setHandlers);
function NOTZPDMYIA_wrap_Valid(event) {
return NOTZPDMYIA_Valid(event);
}
SPBOUILib.SetInputExit('NOTZPDMYIA',NOTZPDMYIA_wrap_Valid);
function NOTZPDMYIA_wrap_OnFocus(event) {
return NOTZPDMYIA_OnFocus(event);
}
SPBOUILib.SetInputEnter('NOTZPDMYIA',NOTZPDMYIA_wrap_OnFocus);
function NOTZPDMYIA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NOTZPDMYIA',NOTZPDMYIA_wrap_OnKeyDown);
function RDAVOEETJG_wrap_Valid(event) {
return RDAVOEETJG_Valid(event);
}
SPBOUILib.SetInputExit('RDAVOEETJG',RDAVOEETJG_wrap_Valid);
function RDAVOEETJG_wrap_OnFocus(event) {
return RDAVOEETJG_OnFocus(event);
}
SPBOUILib.SetInputEnter('RDAVOEETJG',RDAVOEETJG_wrap_OnFocus);
function RDAVOEETJG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RDAVOEETJG',RDAVOEETJG_wrap_OnKeyDown);
function BOTAJBWHHY_wrap_Valid(event) {
return BOTAJBWHHY_Valid(event);
}
SPBOUILib.SetInputExit('BOTAJBWHHY',BOTAJBWHHY_wrap_Valid);
function BOTAJBWHHY_wrap_OnFocus(event) {
return BOTAJBWHHY_OnFocus(event);
}
SPBOUILib.SetInputEnter('BOTAJBWHHY',BOTAJBWHHY_wrap_OnFocus);
function BOTAJBWHHY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BOTAJBWHHY',BOTAJBWHHY_wrap_OnKeyDown);
function VYLHWTRQNX_wrap_Valid(event) {
return VYLHWTRQNX_Valid(event);
}
SPBOUILib.SetInputExit('VYLHWTRQNX',VYLHWTRQNX_wrap_Valid);
function VYLHWTRQNX_wrap_OnFocus(event) {
return VYLHWTRQNX_OnFocus(event);
}
SPBOUILib.SetInputEnter('VYLHWTRQNX',VYLHWTRQNX_wrap_OnFocus);
function VYLHWTRQNX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VYLHWTRQNX',VYLHWTRQNX_wrap_OnKeyDown);
function YVIKEGPYPM_wrap_Valid(event) {
return YVIKEGPYPM_Valid(event);
}
SPBOUILib.SetInputExit('YVIKEGPYPM',YVIKEGPYPM_wrap_Valid);
function YVIKEGPYPM_wrap_OnFocus(event) {
return YVIKEGPYPM_OnFocus(event);
}
SPBOUILib.SetInputEnter('YVIKEGPYPM',YVIKEGPYPM_wrap_OnFocus);
function YVIKEGPYPM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YVIKEGPYPM',YVIKEGPYPM_wrap_OnKeyDown);
function YVIKEGPYPM_ZOOM_setHandlers() {
function YVIKEGPYPM_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?YVIKEGPYPM_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('YVIKEGPYPM_ZOOM',YVIKEGPYPM_ZOOM_wrap_OnClick);
function YVIKEGPYPM_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('YVIKEGPYPM_ZOOM',YVIKEGPYPM_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('YVIKEGPYPM',YVIKEGPYPM_ZOOM_setHandlers);
function HNMYJPHSQN_wrap_Valid(event) {
return HNMYJPHSQN_Valid(event);
}
SPBOUILib.SetComboChange('HNMYJPHSQN',HNMYJPHSQN_wrap_Valid);
function HNMYJPHSQN_wrap_OnFocus(event) {
return HNMYJPHSQN_OnFocus(event);
}
SPBOUILib.SetInputEnter('HNMYJPHSQN',HNMYJPHSQN_wrap_OnFocus);
function HNMYJPHSQN_wrap_Blur(event) {
return HNMYJPHSQN_OnBlur(event);
}
SPBOUILib.SetInputExit('HNMYJPHSQN',HNMYJPHSQN_wrap_Blur);
function CDJFSCCGNX_wrap_Valid(event) {
return CDJFSCCGNX_Valid(event);
}
SPBOUILib.SetInputExit('CDJFSCCGNX',CDJFSCCGNX_wrap_Valid);
function CDJFSCCGNX_wrap_OnFocus(event) {
return CDJFSCCGNX_OnFocus(event);
}
SPBOUILib.SetInputEnter('CDJFSCCGNX',CDJFSCCGNX_wrap_OnFocus);
function CDJFSCCGNX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CDJFSCCGNX',CDJFSCCGNX_wrap_OnKeyDown);
function CDJFSCCGNX_ZOOM_setHandlers() {
function CDJFSCCGNX_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?CDJFSCCGNX_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('CDJFSCCGNX_ZOOM',CDJFSCCGNX_ZOOM_wrap_OnClick);
function CDJFSCCGNX_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('CDJFSCCGNX_ZOOM',CDJFSCCGNX_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('CDJFSCCGNX',CDJFSCCGNX_ZOOM_setHandlers);
function VYDRMHACRY_wrap_Valid(event) {
return VYDRMHACRY_Valid(event);
}
SPBOUILib.SetInputExit('VYDRMHACRY',VYDRMHACRY_wrap_Valid);
function VYDRMHACRY_wrap_OnFocus(event) {
return VYDRMHACRY_OnFocus(event);
}
SPBOUILib.SetInputEnter('VYDRMHACRY',VYDRMHACRY_wrap_OnFocus);
function VYDRMHACRY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VYDRMHACRY',VYDRMHACRY_wrap_OnKeyDown);
function NYRJHOZOON_wrap_Valid(event) {
return NYRJHOZOON_Valid(event);
}
SPBOUILib.SetInputExit('NYRJHOZOON',NYRJHOZOON_wrap_Valid);
function NYRJHOZOON_wrap_OnFocus(event) {
return NYRJHOZOON_OnFocus(event);
}
SPBOUILib.SetInputEnter('NYRJHOZOON',NYRJHOZOON_wrap_OnFocus);
function NYRJHOZOON_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NYRJHOZOON',NYRJHOZOON_wrap_OnKeyDown);
function NYRJHOZOON_ZOOM_setHandlers() {
function NYRJHOZOON_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?NYRJHOZOON_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('NYRJHOZOON_ZOOM',NYRJHOZOON_ZOOM_wrap_OnClick);
function NYRJHOZOON_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('NYRJHOZOON_ZOOM',NYRJHOZOON_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('NYRJHOZOON',NYRJHOZOON_ZOOM_setHandlers);
function NZZUAIJFDU_wrap_Valid(event) {
return NZZUAIJFDU_Valid(event);
}
SPBOUILib.SetInputExit('NZZUAIJFDU',NZZUAIJFDU_wrap_Valid);
function NZZUAIJFDU_wrap_OnFocus(event) {
return NZZUAIJFDU_OnFocus(event);
}
SPBOUILib.SetInputEnter('NZZUAIJFDU',NZZUAIJFDU_wrap_OnFocus);
function NZZUAIJFDU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NZZUAIJFDU',NZZUAIJFDU_wrap_OnKeyDown);
function YQINIDXZSL_wrap_Valid(event) {
return YQINIDXZSL_Valid(event);
}
SPBOUILib.SetInputExit('YQINIDXZSL',YQINIDXZSL_wrap_Valid);
function YQINIDXZSL_wrap_OnFocus(event) {
return YQINIDXZSL_OnFocus(event);
}
SPBOUILib.SetInputEnter('YQINIDXZSL',YQINIDXZSL_wrap_OnFocus);
function YQINIDXZSL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YQINIDXZSL',YQINIDXZSL_wrap_OnKeyDown);
function YQINIDXZSL_ZOOM_setHandlers() {
function YQINIDXZSL_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?YQINIDXZSL_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('YQINIDXZSL_ZOOM',YQINIDXZSL_ZOOM_wrap_OnClick);
function YQINIDXZSL_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('YQINIDXZSL_ZOOM',YQINIDXZSL_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('YQINIDXZSL',YQINIDXZSL_ZOOM_setHandlers);
function ACAPFGYRVI_wrap_Valid(event) {
return ACAPFGYRVI_Valid(event);
}
SPBOUILib.SetInputExit('ACAPFGYRVI',ACAPFGYRVI_wrap_Valid);
function ACAPFGYRVI_wrap_OnFocus(event) {
return ACAPFGYRVI_OnFocus(event);
}
SPBOUILib.SetInputEnter('ACAPFGYRVI',ACAPFGYRVI_wrap_OnFocus);
function ACAPFGYRVI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ACAPFGYRVI',ACAPFGYRVI_wrap_OnKeyDown);
function FFCAGQAZHK_wrap_Valid(event) {
return FFCAGQAZHK_Valid(event);
}
SPBOUILib.SetInputExit('FFCAGQAZHK',FFCAGQAZHK_wrap_Valid);
function FFCAGQAZHK_wrap_OnFocus(event) {
return FFCAGQAZHK_OnFocus(event);
}
SPBOUILib.SetInputEnter('FFCAGQAZHK',FFCAGQAZHK_wrap_OnFocus);
function FFCAGQAZHK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FFCAGQAZHK',FFCAGQAZHK_wrap_OnKeyDown);
function GXMZZZHVBR_wrap_Valid(event) {
return GXMZZZHVBR_Valid(event);
}
SPBOUILib.SetInputExit('GXMZZZHVBR',GXMZZZHVBR_wrap_Valid);
function GXMZZZHVBR_wrap_OnFocus(event) {
return GXMZZZHVBR_OnFocus(event);
}
SPBOUILib.SetInputEnter('GXMZZZHVBR',GXMZZZHVBR_wrap_OnFocus);
function GXMZZZHVBR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('GXMZZZHVBR',GXMZZZHVBR_wrap_OnKeyDown);
function NHERHRZTFP_wrap_Valid(event) {
return NHERHRZTFP_Valid(event);
}
SPBOUILib.SetInputExit('NHERHRZTFP',NHERHRZTFP_wrap_Valid);
function NHERHRZTFP_wrap_OnFocus(event) {
return NHERHRZTFP_OnFocus(event);
}
SPBOUILib.SetInputEnter('NHERHRZTFP',NHERHRZTFP_wrap_OnFocus);
function NHERHRZTFP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NHERHRZTFP',NHERHRZTFP_wrap_OnKeyDown);
function AVHTGZTOSZ_wrap_Valid(event) {
return AVHTGZTOSZ_Valid(event);
}
SPBOUILib.SetInputExit('AVHTGZTOSZ',AVHTGZTOSZ_wrap_Valid);
function AVHTGZTOSZ_wrap_OnFocus(event) {
return AVHTGZTOSZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('AVHTGZTOSZ',AVHTGZTOSZ_wrap_OnFocus);
function AVHTGZTOSZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AVHTGZTOSZ',AVHTGZTOSZ_wrap_OnKeyDown);
function AVHTGZTOSZ_ZOOM_setHandlers() {
function AVHTGZTOSZ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?AVHTGZTOSZ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('AVHTGZTOSZ_ZOOM',AVHTGZTOSZ_ZOOM_wrap_OnClick);
function AVHTGZTOSZ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('AVHTGZTOSZ_ZOOM',AVHTGZTOSZ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('AVHTGZTOSZ',AVHTGZTOSZ_ZOOM_setHandlers);
function QSRYXQJCBZ_wrap_Valid(event) {
return QSRYXQJCBZ_Valid(event);
}
SPBOUILib.SetComboChange('QSRYXQJCBZ',QSRYXQJCBZ_wrap_Valid);
function QSRYXQJCBZ_wrap_OnFocus(event) {
return QSRYXQJCBZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('QSRYXQJCBZ',QSRYXQJCBZ_wrap_OnFocus);
function QSRYXQJCBZ_wrap_Blur(event) {
return QSRYXQJCBZ_OnBlur(event);
}
SPBOUILib.SetInputExit('QSRYXQJCBZ',QSRYXQJCBZ_wrap_Blur);
function VYBZEWHKFF_wrap_Valid(event) {
return VYBZEWHKFF_Valid(event);
}
SPBOUILib.SetInputExit('VYBZEWHKFF',VYBZEWHKFF_wrap_Valid);
function VYBZEWHKFF_wrap_OnFocus(event) {
return VYBZEWHKFF_OnFocus(event);
}
SPBOUILib.SetInputEnter('VYBZEWHKFF',VYBZEWHKFF_wrap_OnFocus);
function VYBZEWHKFF_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('VYBZEWHKFF',VYBZEWHKFF_wrap_OnKeyPress);
function VYBZEWHKFF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('VYBZEWHKFF',VYBZEWHKFF_wrap_OnKeyDown);
function MSGBKOOAOY_wrap_Valid(event) {
return MSGBKOOAOY_Valid(event);
}
SPBOUILib.SetInputExit('MSGBKOOAOY',MSGBKOOAOY_wrap_Valid);
function MSGBKOOAOY_wrap_OnFocus(event) {
return MSGBKOOAOY_OnFocus(event);
}
SPBOUILib.SetInputEnter('MSGBKOOAOY',MSGBKOOAOY_wrap_OnFocus);
function MSGBKOOAOY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MSGBKOOAOY',MSGBKOOAOY_wrap_OnKeyDown);
function MSGBKOOAOY_ZOOM_setHandlers() {
function MSGBKOOAOY_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?MSGBKOOAOY_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('MSGBKOOAOY_ZOOM',MSGBKOOAOY_ZOOM_wrap_OnClick);
function MSGBKOOAOY_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('MSGBKOOAOY_ZOOM',MSGBKOOAOY_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('MSGBKOOAOY',MSGBKOOAOY_ZOOM_setHandlers);
function JDTKGSGMAF_wrap_Valid(event) {
return JDTKGSGMAF_Valid(event);
}
SPBOUILib.SetInputExit('JDTKGSGMAF',JDTKGSGMAF_wrap_Valid);
function JDTKGSGMAF_wrap_OnFocus(event) {
return JDTKGSGMAF_OnFocus(event);
}
SPBOUILib.SetInputEnter('JDTKGSGMAF',JDTKGSGMAF_wrap_OnFocus);
function JDTKGSGMAF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JDTKGSGMAF',JDTKGSGMAF_wrap_OnKeyDown);
function VFSCXTRPBT_wrap_Valid(event) {
return VFSCXTRPBT_Valid(event);
}
SPBOUILib.SetInputExit('VFSCXTRPBT',VFSCXTRPBT_wrap_Valid);
function VFSCXTRPBT_wrap_OnFocus(event) {
return VFSCXTRPBT_OnFocus(event);
}
SPBOUILib.SetInputEnter('VFSCXTRPBT',VFSCXTRPBT_wrap_OnFocus);
function VFSCXTRPBT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VFSCXTRPBT',VFSCXTRPBT_wrap_OnKeyDown);
function VFSCXTRPBT_ZOOM_setHandlers() {
function VFSCXTRPBT_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?VFSCXTRPBT_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('VFSCXTRPBT_ZOOM',VFSCXTRPBT_ZOOM_wrap_OnClick);
function VFSCXTRPBT_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('VFSCXTRPBT_ZOOM',VFSCXTRPBT_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('VFSCXTRPBT',VFSCXTRPBT_ZOOM_setHandlers);
if (m_bExtended) {
SetEventsAndStylesToExtendedFields();
}
}
if (Eq(m_cFunction,'query') && Ne(document.FrmToolbar,null)) {
document.FrmToolbar.pos.onkeypress=RecPositionInput;
document.FrmToolbar.pos.onblur=SelectRecord;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
}
function SetLastFocusedOnParent() {
// used only in child entities
}
function DoUpdate(p_bResult) {
if (Ne(m_cFunction,'query') && Ne(m_cFunction,'view')) {
Calculate();
SaveDependsOn();
SetControlsValue();
SetDynamicClasses();
SetDynamicTooltip();
EnableControlsUnderCondition();
SaveLabelDependsOn();
}
if ( ! (p_bResult)) {
DisplayErrorMessage();
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.edit={"page_1":["YLIKFVPZJA"],"page_2":["VFSCXTRPBT"]};
FocusFirstComponent.query={"page_1":["YLIKFVPZJA"],"page_2":["VFSCXTRPBT"]};
FocusFirstComponent.otherwise={"page_1":["YLIKFVPZJA"],"page_2":["VFSCXTRPBT"]};
function Help() {
windowOpenForeground('../doc/armt_kperazbo_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_ardt_clientisara() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_2')) {
if (ChildToLoad('BOAFVDQFRN')) {
LoadContext.lc(1,'BOAFVDQFRN');
} else {
LibJavascript.RefreshChildGrid('BOAFVDQFRN');
}
}
}
GetLayerID.Layers.push({"id":"XLSSDAVPDH","name":"box_XLSSDAVPDH"});
GetLayerID.Layers.push({"id":"ZPEPXLSZFA","name":"box_ZPEPXLSZFA"});
GetLayerID.Layers.push({"id":"YIVWPEZXIF","name":"box_YIVWPEZXIF"});
function DeclareWVs() {
var a = arguments;
w_DATAOPE=a[0];
w_CDATOPE=a[1];
w_DATAREG=a[2];
w_FLAGCONT=a[3];
w_TIPOOPRAP=a[4];
w_CODANA=a[5];
w_CODVOC=a[6];
w_FLAGFRAZ=a[7];
w_FLAGLIRE=a[8];
w_VALUTA=a[9];
w_CAMBIO=a[10];
w_TOTLIRE=a[11];
w_TOTCONT=a[12];
w_RAPPORTO=a[13];
w_CONNESCLI=a[14];
w_CONNESOPER=a[15];
w_TIPOLEG=a[16];
w_PAGASOGOP=a[17];
w_CONNESBEN=a[18];
w_CONNALTRO=a[19];
w_C_RAG=a[20];
w_C_CTA=a[21];
w_C_PRV=a[22];
w_C_CAP=a[23];
w_C_CAB=a[24];
w_C_IND=a[25];
w_C_STA=a[26];
w_TIPOINT2=a[27];
w_CODINT2=a[28];
w_DESCINTER=a[29];
w_PAESE=a[30];
w_C_RAPPORTO=a[31];
w_CODCAB2=a[32];
w_PROV2=a[33];
w_DESC2=a[34];
w_ZCPARTE=a[35];
w_IDBASE=a[36];
op_IDBASE=a[37];
w_NUMPROG=a[38];
op_NUMPROG=a[39];
w_CODINTER=a[40];
w_TIPOINF=a[41];
w_IDEREG=a[42];
w_CODDIPE=a[43];
w_DESCCIT=a[44];
w_FLAGRAP=a[45];
w_OPRAP=a[46];
w_SEGNO=a[47];
w_OPERAZMOD=a[48];
w_RAPPORTBEN=a[49];
w_OPERATORE=a[50];
w_AUTOM=a[51];
w_DATARETT=a[52];
w_COLLEG=a[53];
w_FLAGRAP2=a[54];
w_STATOREG=a[55];
w_PROVINCIA=a[56];
w_CODCAB=a[57];
w_PRGIMPOPE=a[58];
op_PRGIMPOPE=a[59];
w_CDATAOPE=a[60];
w_CONNESDOC=a[61];
w_MTCN=a[62];
w_CDATREG=a[63];
w_filtro=a[64];
w_tipope=a[65];
w_appolire=a[66];
w_xTOTLIRE=a[67];
w_xTOTCONT=a[68];
w_gIntemediario=a[69];
w_xdes1=a[70];
w_desccauana=a[71];
w_xdesccausin=a[72];
w_descdiv=a[73];
w_xragsocper=a[74];
w_xdescrap=a[75];
w_xragsocct=a[76];
w_xragsocben=a[77];
w_xdestipleg=a[78];
w_xragint2=a[79];
w_xdescpaese2=a[80];
w_datpaseuro=a[81];
w_xDescDipe=a[82];
w_sEdit=a[83];
w_gChkDate=a[84];
w_errmsg=a[85];
w_test=a[86];
w_valflg2=a[87];
w_gTipInter=a[88];
w_gSblocco=a[89];
w_xdescmodsvo=a[90];
w_xdescareag=a[91];
w_xdescplauso=a[92];
w_xdesctipor=a[93];
w_xdescopeage=a[94];
w_xcodfisc=a[95];
w_dataoggi=a[96];
w_stringaflagrap2=a[97];
w_xdescfreq=a[98];
w_xdescammo=a[99];
w_gDataVaria=a[100];
w_gStatus=a[101];
w_CITINT=a[102];
w_CITDIP=a[103];
w_PROVDIP=a[104];
w_CABDIP=a[105];
w_PROVINT=a[106];
w_CABINT=a[107];
w_gFlgDoc=a[108];
w_xtiporap=a[109];
w_dessta=a[110];
w_xragsocalt=a[111];
w_xdciticon=a[112];
w_gFlgWU=a[113];
w_prova=a[114];
op_codazi=a[115];
o_ZPEPXLSZFA_expand=null;
o_YIVWPEZXIF_expand=null;
m_cWv_ardt_clientisara=a[116];
if (Gt(a.length,117)) {
m_cErrorInChild='';
}
if (Gt(a.length,117)) {
o_filtro=w_filtro;
o_DATAOPE=w_DATAOPE;
o_CDATOPE=w_CDATOPE;
o_FLAGCONT=w_FLAGCONT;
o_CODVOC=w_CODVOC;
o_FLAGLIRE=w_FLAGLIRE;
o_appolire=w_appolire;
o_RAPPORTO=w_RAPPORTO;
o_CONNESCLI=w_CONNESCLI;
o_C_CTA=w_C_CTA;
o_CODINT2=w_CODINT2;
o_CODINTER=w_CODINTER;
o_CODDIPE=w_CODDIPE;
}
m_PrimaryKeys=['IDBASE'];
}
function i_PrimaryKey() {
return 'kperazbo'+'\\'+CPLib.ToCPStr(w_IDBASE);
}
GetLinkPCKeys.set_o('ardt_clientisara',false);
GetLinkPCKeys.o['ardt_clientisara']['IDFILEBO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_IDBASE,'C');
}
}
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('BOAFVDQFRN',function(){return FrameRef('ardt_clientisara')},1,'ardt_clientisara',1,2)
GetSelectedChildPage.child={'ardt_clientisara': function(){return FrameRef('ardt_clientisara')}}
function GetSelectedPage(p_d) {
p_d.setValue('armt_kperazbo',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
if (IsNull(p_id) || Eq(p_id,'AQSAREJVST')) {
if (Ctrl('AQSAREJVST')) {
render_combobox('AQSAREJVST','qbe_tipileg',["?w_CDATOPE","?w_filtro"],[WtA(w_CDATOPE,"C"),WtA(w_filtro,"C")],GetDynComboId('AQSAREJVST'),'TPCODICE','TPDESCRI','',WtA(w_TIPOLEG));
w_TIPOLEG=HtW(getComboValue(Ctrl('AQSAREJVST')),'C');
}
}
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_TIPOOPRAP,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xdes1,'C'); },"field":"DES1","type":"C"}],"keyValues":[{"expression":function() { return WtA(w_tipope,'C'); },"field":"OPERAZIO","type":"C"}],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbtipreg','C'),"uid":"UJRFWINIVQ"});
ExtendedMenu({"configName":WtA('cauinter','C'),"fldValues":[{"expression":function() { return WtA(w_CODANA,'C'); },"field":"CODCAU","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcauana','C'),"uid":"SQVJLYRFKQ"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODVOC,'C'); },"field":"CAUSINT","type":"C"},{"expression":function() { return WtA(w_SEGNO,'C'); },"field":"SEGNO","type":"C"},{"expression":function() { return WtA(w_desccauana,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[{"expression":function() { return WtA(w_CODANA,'C'); },"field":"CODCAU","type":"C"}],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcauana','C'),"uid":"SRWWPHPCUB"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_VALUTA,'C'); },"field":"CODVAL","type":"C"},{"expression":function() { return WtA(w_descdiv,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbvalute','C'),"uid":"MKCXJZEKIG"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_RAPPORTO,'C'); },"field":"RAPPORTO","type":"C"},{"expression":function() { return WtA(w_xdescrap,'C'); },"field":"DESCRAP","type":"C"},{"expression":function() { return WtA(w_FLAGRAP,'C'); },"field":"TIPORAP","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('knarapbo','C'),"uid":"RZIQZFKPUE"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CONNESCLI,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xragsocper,'C'); },"field":"RAGSOC","type":"C"},{"expression":function() { return WtA(w_xcodfisc,'C'); },"field":"CODFISC","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"QBLXDBODXR"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CONNESOPER,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xragsocct,'C'); },"field":"RAGSOC","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"TCOTJNZLGM"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CONNESBEN,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xragsocben,'C'); },"field":"RAGSOC","type":"C"},{"expression":function() { return WtA(w_C_IND,'C'); },"field":"DOMICILIO","type":"C"},{"expression":function() { return WtA(w_C_CTA,'C'); },"field":"DESCCIT","type":"C"},{"expression":function() { return WtA(w_C_PRV,'C'); },"field":"PROVINCIA","type":"C"},{"expression":function() { return WtA(w_C_STA,'C'); },"field":"PAESE","type":"C"},{"expression":function() { return WtA(w_C_CAP,'C'); },"field":"CAP","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"ULVCBLFVEU"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CONNALTRO,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xragsocben,'C'); },"field":"RAGSOC","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"HWFHDWYMIU"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_C_CTA,'C'); },"field":"CITTA","type":"C"},{"expression":function() { return WtA(w_C_CAB,'C'); },"field":"CAB","type":"C"},{"expression":function() { return WtA(w_C_PRV,'C'); },"field":"PROV","type":"C"},{"expression":function() { return WtA(w_C_STA,'C'); },"field":"PKTBSTATI","type":"C"},{"expression":function() { return WtA(w_C_CAP,'C'); },"field":"CAP","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcitta','C'),"uid":"ODAYKSRECA"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_C_STA,'C'); },"field":"CODSTA","type":"C"},{"expression":function() { return WtA(w_dessta,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"YVIKEGPYPM"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODINT2,'C'); },"field":"CODINTER","type":"C"},{"expression":function() { return WtA(w_DESCINTER,'C'); },"field":"RAGSOC","type":"C"},{"expression":function() { return WtA(w_CODCAB2,'C'); },"field":"CODCAB","type":"C"},{"expression":function() { return WtA(w_PROV2,'C'); },"field":"PROVINCIA","type":"C"},{"expression":function() { return WtA(w_PAESE,'C'); },"field":"PAESE","type":"C"},{"expression":function() { return WtA(w_TIPOINT2,'C'); },"field":"TIPINTER","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('inter2bo','C'),"uid":"CDJFSCCGNX"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_PAESE,'C'); },"field":"CODSTA","type":"C"},{"expression":function() { return WtA(w_xdescpaese2,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"NYRJHOZOON"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODCAB2,'C'); },"field":"CAB","type":"C"},{"expression":function() { return WtA(w_xdciticon,'C'); },"field":"CITTA","type":"C"},{"expression":function() { return WtA(w_PROV2,'C'); },"field":"PROV","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcitta','C'),"uid":"YQINIDXZSL"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODDIPE,'C'); },"field":"CODDIP","type":"C"},{"expression":function() { return WtA(w_xDescDipe,'C'); },"field":"DESCRIZ","type":"C"},{"expression":function() { return WtA(w_CITDIP,'C'); },"field":"DESCCIT","type":"C"},{"expression":function() { return WtA(w_PROVDIP,'C'); },"field":"PROVINCIA","type":"C"},{"expression":function() { return WtA(w_CABDIP,'C'); },"field":"CAB","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('anadip','C'),"uid":"AVHTGZTOSZ"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('armt_operazioni','C'),"fldValues":[{"expression":function() { return WtA(w_COLLEG,'C'); },"field":"NUMPROG","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('kperazbo','C'),"uid":"MSGBKOOAOY"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODDIPE,'C'); },"field":"CODDIP","type":"C"},{"expression":function() { return WtA(w_xDescDipe,'C'); },"field":"DESCRIZ","type":"C"},{"expression":function() { return WtA(w_CITDIP,'C'); },"field":"DESCCIT","type":"C"},{"expression":function() { return WtA(w_PROVDIP,'C'); },"field":"PROVINCIA","type":"C"},{"expression":function() { return WtA(w_CABDIP,'C'); },"field":"CAB","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('anadip','C'),"uid":"VFSCXTRPBT"});
}
_Obli('PROV2',0,'ACAPFGYRVI',false,"635233449")
_Obli('DATAOPE',2,'YLIKFVPZJA',true,"829201110")
_Obli('DESC2',0,'FFCAGQAZHK',false,"11823283690")
_Obli('DATAREG',2,'OEIKQOZMYJ',true,"1028598955",null,"12128708791")
_Obli('FLAGCONT',0,'PURPSXEVAI',false,"237632211")
_Obli('ZCPARTE',0,'GXMZZZHVBR',false)
_Obli('TIPOOPRAP',0,'UJRFWINIVQ',false,"11137644647")
_Obli('CODANA',0,'SQVJLYRFKQ',false,"215536597")
_Obli('CODVOC',0,'SRWWPHPCUB',false,"215310487")
_Obli('CODVOC',0,'KHRUYMSPDK',false,"215310487")
_Obli('COLLEG',0,'MSGBKOOAOY',false,"750412439")
_Obli('DATARETT',2,'VYBZEWHKFF',false,"11329559720")
_Obli('appolire',0,'LJBMCCABSS',false)
_Obli('VALUTA',0,'MKCXJZEKIG',false,"109710548")
_Obli('CAMBIO',1,'YTCDGCPEDJ',false,"123704147")
_Obli('xTOTLIRE',1,'EDIXWZNSIC',true)
_Obli('xTOTCONT',1,'CTORYEJVDR',true,null,null,"11525797640")
_Obli('CODCAB2',0,'YQINIDXZSL',false,"11945229207")
_Obli('DESCINTER',0,'VYDRMHACRY',false)
_Obli('DESCINTER',0,'MXCRVGEBAO',false)
_Obli('RAPPORTO',0,'RZIQZFKPUE',false,"10379997930")
_Obli('CONNESCLI',0,'QBLXDBODXR',false,"10219814530")
_Obli('CONNESOPER',0,'TCOTJNZLGM',false,"10219814530")
_Obli('TIPOLEG',0,'AQSAREJVST',false,"14232327")
_Obli('PAGASOGOP',0,'JGKMKQMAHS',false)
_Obli('CONNESBEN',0,'ULVCBLFVEU',false,"10219814530")
_Obli('CONNALTRO',0,'HWFHDWYMIU',false)
_Obli('C_RAG',0,'AWPNTOJIRR',false)
_Obli('C_CTA',0,'ODAYKSRECA',false)
_Obli('C_PRV',0,'NOTZPDMYIA',false)
_Obli('C_CAP',0,'RDAVOEETJG',false)
_Obli('C_CAB',0,'BOTAJBWHHY',false)
_Obli('C_IND',0,'VYLHWTRQNX',false)
_Obli('C_STA',0,'YVIKEGPYPM',false)
_Obli('TIPOINT2',0,'HNMYJPHSQN',false,"11058698874")
_Obli('CODINT2',0,'CDJFSCCGNX',false,"10455298077")
_Obli('CODDIPE',0,'AVHTGZTOSZ',false,"2071283709")
_Obli('CODDIPE',0,'VFSCXTRPBT',false,"2071283709")
_Obli('PAESE',0,'NYRJHOZOON',false,"240702475")
_Obli('C_RAPPORTO',0,'NZZUAIJFDU',false)
_Obli('FLAGFRAZ',0,'OSJVPCICRI',false,"1722199786")
_Obli('FLAGFRAZ',0,'QSRYXQJCBZ',false,"1722199786")
_Obli('MTCN',0,'JDTKGSGMAF',false,"338061")
_Obli('IDBASE',0,'NHERHRZTFP',false,"113866889")
