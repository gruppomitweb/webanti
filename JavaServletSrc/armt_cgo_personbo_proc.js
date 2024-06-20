function FillCombosValues() {
FillCombo('MBGANUUHRA','MBGANUUHRA');
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('TWTTDWKCRG',function(){return WtH(w_COGNOME,'C',26,0,'@!')},w_COGNOME);
SPBOUILib.SetInputValue('WWGIVGNUDW',function(){return WtH(w_NOME,'C',25,0,'@!')},w_NOME);
if(c=Ctrl('CZTHKEDVCO')) ChkboxCheckUncheck(c,1,w_CFESTERO)
if(c=Ctrl('CZTHKEDVCO')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('YVIKEGPYPM',function(){return WtH(w_PAESE,'C',3,0,'')},w_PAESE);
SPBOUILib.SetInputValue('ODAYKSRECA',function(){return WtH(w_DESCCIT,'C',30,0,'@!')},w_DESCCIT);
SPBOUILib.SetInputValue('NOTZPDMYIA',function(){return WtH(w_PROVINCIA,'C',2,0,'')},w_PROVINCIA);
SPBOUILib.SetInputValue('RDAVOEETJG',function(){return WtH(w_CAP,'C',9,0,'')},w_CAP);
SPBOUILib.SetInputValue('VYLHWTRQNX',function(){return WtH(w_DOMICILIO,'C',35,0,'')},w_DOMICILIO);
SPBOUILib.SetInputValue('BYPEBFEOAJ',function(){return WtH(w_IDCITTANA,'C',40,0,'')},w_IDCITTANA);
SPBOUILib.SetInputValue('NEUBQNUEOJ',function(){return WtH(w_NASCOMUN,'C',30,0,'@!')},w_NASCOMUN);
SPBOUILib.SetInputValue('KPSCOABZLB',function(){return WtH(w_NASPROV,'C',2,0,'')},w_NASPROV);
if(c=Ctrl('QPALJZMFCL')) selectCombo(c,w_SESSO,'C')
SPBOUILib.SetInputValue('HODZKKOSYW',function(){return WtH(w_NASSTATO,'C',30,0,'@!')},w_NASSTATO);
SPBOUILib.SetInputValue('XMGRWGFSFV',function(){return WtH(w_DATANASC,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATANASC);
if(c=Ctrl('MBGANUUHRA')) selectCombo(c,w_TIPODOC,'C')
SPBOUILib.SetInputValue('HVEEMUJUUY',function(){return WtH(w_NUMDOCUM,'C',15,0,'')},w_NUMDOCUM);
SPBOUILib.SetInputValue('XHWYGOPPUN',function(){return WtH(w_DATARILASC,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATARILASC);
SPBOUILib.SetInputValue('BNWXBPSIDG',function(){return WtH(w_DATAVALI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAVALI);
SPBOUILib.SetInputValue('HRNCPADUFU',function(){return WtH(w_AUTRILASC,'C',30,0,'')},w_AUTRILASC);
SPBOUILib.SetInputValue('OJJHIUDPFY',function(){return WtH(w_CONNES,'C',16,0,'')},w_CONNES);
var tmp_ESVLUSNYWB = ToHTag(AsControlValue(w_dessta));
if (Ne(e_ESVLUSNYWB,tmp_ESVLUSNYWB)) {
SPBOUILib.SetLabelValue('ESVLUSNYWB','innerHTML',tmp_ESVLUSNYWB);
e_ESVLUSNYWB=tmp_ESVLUSNYWB;
}
if(c=Ctrl('XFKXBQYUIU')) ChkboxCheckUncheck(c,'S',w_PEP)
if(c=Ctrl('XFKXBQYUIU')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('TVQKRQXOUS',function(){return WtH(w_TXTERR,'M',10,0,'')},w_TXTERR);
SPBOUILib.SetInputValue('GIZUBOQEKL',function(){return WtH(w_PRGSOG,'C',15,0,'')},w_PRGSOG);
if(c=Ctrl('AYCRVWSEMG')) ChkboxCheckUncheck(c,'S',w_FLGFULL)
if(c=Ctrl('AYCRVWSEMG')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('WBGZOIFODE',function(){return WtH(w_CODCAB,'C',6,0,'')},w_CODCAB);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay('AQSQVBKXAL_DIV',IsHiddenByStateDriver('Residenza'));
SetDisplay('EWPTTWSBMT_DIV',IsHiddenByStateDriver('PF'));
SetDisplay('BLAIVNGHMW_DIV',IsHiddenByStateDriver('PFDoc'));
SetDisplay('OQFTKYDCIW_DIV',IsHiddenByStateDriver('Chiave'));
SetDisplay('MKZZTQTPHW_DIV',IsHiddenByStateDriver('Errori'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["AUTRILASC"]=['ZPQIEJPWJC'];
HideUI.lblids["CAP"]=['GDOCAGKROT'];
HideUI.lblids["CODCAB"]=['WHMXTGXWGC'];
HideUI.lblids["COGNOME"]=['TVSLWOCERI'];
HideUI.lblids["CONNES"]=['WZDAFMDKJE'];
HideUI.lblids["DATANASC"]=['HZYTDOZFPI'];
HideUI.lblids["DATARILASC"]=['MLJVDLOITR'];
HideUI.lblids["DATAVALI"]=['UYGHJPRVKH'];
HideUI.lblids["DESCCIT"]=['XPSQTBKQQZ'];
HideUI.lblids["DOMICILIO"]=['TWTXGZJTAR'];
HideUI.lblids["IDCITTANA"]=['WVJSUIKYEY'];
HideUI.lblids["NASPROV"]=['IVAWYVSUQI'];
HideUI.lblids["NASSTATO"]=['ZBRDCBHLZC'];
HideUI.lblids["NOME"]=['KUPYKSUBXV'];
HideUI.lblids["NUMDOCUM"]=['YXFGMWZGNN'];
HideUI.lblids["PAESE"]=['RZBLEGCFJJ'];
HideUI.lblids["PRGSOG"]=['BLRTTDWMJC'];
HideUI.lblids["PROVINCIA"]=['SBJQIAQUCN'];
HideUI.lblids["SESSO"]=['KRSCDPQZTQ'];
HideUI.lblids["TIPODOC"]=['YRARWMJPPV'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function TWTTDWKCRG_Valid(e) {
SetActiveField(Ctrl('TWTTDWKCRG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('COGNOME','C',w_COGNOME,HtW(Ctrl('TWTTDWKCRG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_COGNOME(HtW(Ctrl('TWTTDWKCRG').value,'C'),null,e);
return l_bSetResult;
}
}
function TWTTDWKCRG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TWTTDWKCRG'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('TWTTDWKCRG',w_COGNOME,'C',26,0,'@!');
SetActiveField(Ctrl('TWTTDWKCRG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TWTTDWKCRG'),e);
}
function TWTTDWKCRG_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function WWGIVGNUDW_Valid(e) {
SetActiveField(Ctrl('WWGIVGNUDW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NOME','C',w_NOME,HtW(Ctrl('WWGIVGNUDW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOME(HtW(Ctrl('WWGIVGNUDW').value,'C'),null,e);
return l_bSetResult;
}
}
function WWGIVGNUDW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WWGIVGNUDW'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('WWGIVGNUDW',w_NOME,'C',25,0,'@!');
SetActiveField(Ctrl('WWGIVGNUDW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WWGIVGNUDW'),e);
}
function WWGIVGNUDW_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function CZTHKEDVCO_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('CFESTERO','N',w_CFESTERO,ChkboxValueAssign(Ctrl('CZTHKEDVCO'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CFESTERO(ChkboxValueAssign(Ctrl('CZTHKEDVCO'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function CZTHKEDVCO_OnFocus(e) {
SetActiveField(Ctrl('CZTHKEDVCO'),true);
}
function CZTHKEDVCO_OnBlur(e) {
SetActiveField(Ctrl('CZTHKEDVCO'),false);
}
function YVIKEGPYPM_Valid(e) {
SetActiveField(Ctrl('YVIKEGPYPM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PAESE','C',w_PAESE,HtW(Ctrl('YVIKEGPYPM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PAESE(HtW(Ctrl('YVIKEGPYPM').value,'C'),null,e);
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
function ODAYKSRECA_Valid(e) {
SuggesterLib.resetSuggest('ODAYKSRECA','ODAYKSRECA');
SetActiveField(Ctrl('ODAYKSRECA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCCIT','C',w_DESCCIT,HtW(Ctrl('ODAYKSRECA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCCIT(HtW(Ctrl('ODAYKSRECA').value,'C'),null,e);
return l_bSetResult;
}
}
function ODAYKSRECA_OnFocus(e) {
ODAYKSRECA_OnKeyUp.oldValue=HtW(Ctrl('ODAYKSRECA').value,'C');
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ODAYKSRECA'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('ODAYKSRECA',w_DESCCIT,'C',30,0,'@!');
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
function ODAYKSRECA_OnKeyUp(e) {
var evt = (window.event?window.event:e);
var newValue = HtW(Ctrl('ODAYKSRECA').value,'C');
if (Eq(newValue,ODAYKSRECA_OnKeyUp.oldValue)) {
return;
}
ODAYKSRECA_OnKeyUp.oldValue=newValue;
if ( ! (GetDisabled(Ctrl('ODAYKSRECA')) || IsMobile())) {
if (Gt(newValue.length,2)) {
SuggesterLib.callSuggest(Sugg_ODAYKSRECA,2);
} else {
SuggesterLib.resetSuggest('ODAYKSRECA','ODAYKSRECA');
}
}
}
function ODAYKSRECA_ValidSuggest(e) {
e=(window.event?window.event:e);
if (e) {
return SuggesterLib.select_suggest('ODAYKSRECA','ODAYKSRECA',-1,e);
}
}
function NOTZPDMYIA_Valid(e) {
SetActiveField(Ctrl('NOTZPDMYIA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PROVINCIA','C',w_PROVINCIA,HtW(Ctrl('NOTZPDMYIA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PROVINCIA(HtW(Ctrl('NOTZPDMYIA').value,'C'),null,e);
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
DoQuery('CAP','C',w_CAP,HtW(Ctrl('RDAVOEETJG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAP(HtW(Ctrl('RDAVOEETJG').value,'C'),null,e);
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
function VYLHWTRQNX_Valid(e) {
SetActiveField(Ctrl('VYLHWTRQNX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DOMICILIO','C',w_DOMICILIO,HtW(Ctrl('VYLHWTRQNX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DOMICILIO(HtW(Ctrl('VYLHWTRQNX').value,'C'),null,e);
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
function BYPEBFEOAJ_Valid(e) {
SetActiveField(Ctrl('BYPEBFEOAJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDCITTANA','C',w_IDCITTANA,HtW(Ctrl('BYPEBFEOAJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDCITTANA(HtW(Ctrl('BYPEBFEOAJ').value,'C'),null,e);
return l_bSetResult;
}
}
function BYPEBFEOAJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BYPEBFEOAJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BYPEBFEOAJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BYPEBFEOAJ'),e);
}
function BYPEBFEOAJ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('BYPEBFEOAJ')),'linkview_BYPEBFEOAJ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function NEUBQNUEOJ_Valid(e) {
SetActiveField(Ctrl('NEUBQNUEOJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NASCOMUN','C',w_NASCOMUN,HtW(Ctrl('NEUBQNUEOJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NASCOMUN(HtW(Ctrl('NEUBQNUEOJ').value,'C'),null,e);
return l_bSetResult;
}
}
function NEUBQNUEOJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NEUBQNUEOJ'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('NEUBQNUEOJ',w_NASCOMUN,'C',30,0,'@!');
SetActiveField(Ctrl('NEUBQNUEOJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NEUBQNUEOJ'),e);
}
function NEUBQNUEOJ_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function KPSCOABZLB_Valid(e) {
SetActiveField(Ctrl('KPSCOABZLB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NASPROV','C',w_NASPROV,HtW(Ctrl('KPSCOABZLB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NASPROV(HtW(Ctrl('KPSCOABZLB').value,'C'),null,e);
return l_bSetResult;
}
}
function KPSCOABZLB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KPSCOABZLB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KPSCOABZLB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KPSCOABZLB'),e);
}
function QPALJZMFCL_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('SESSO','C',w_SESSO,HtW(getComboValue(Ctrl('QPALJZMFCL')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SESSO(HtW(getComboValue(Ctrl('QPALJZMFCL')),'C'),null,e);
return l_bSetResult;
}
}
function QPALJZMFCL_OnFocus(e) {
SetActiveField(Ctrl('QPALJZMFCL'),true);
}
function QPALJZMFCL_OnBlur(e) {
SetActiveField(Ctrl('QPALJZMFCL'),false);
}
function HODZKKOSYW_Valid(e) {
SuggesterLib.resetSuggest('HODZKKOSYW','HODZKKOSYW');
SetActiveField(Ctrl('HODZKKOSYW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NASSTATO','C',w_NASSTATO,HtW(Ctrl('HODZKKOSYW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NASSTATO(HtW(Ctrl('HODZKKOSYW').value,'C'),null,e);
return l_bSetResult;
}
}
function HODZKKOSYW_OnFocus(e) {
HODZKKOSYW_OnKeyUp.oldValue=HtW(Ctrl('HODZKKOSYW').value,'C');
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HODZKKOSYW'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('HODZKKOSYW',w_NASSTATO,'C',30,0,'@!');
SetActiveField(Ctrl('HODZKKOSYW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HODZKKOSYW'),e);
}
function HODZKKOSYW_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function HODZKKOSYW_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('HODZKKOSYW')),'linkview_HODZKKOSYW','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function HODZKKOSYW_OnKeyUp(e) {
var evt = (window.event?window.event:e);
var newValue = HtW(Ctrl('HODZKKOSYW').value,'C');
if (Eq(newValue,HODZKKOSYW_OnKeyUp.oldValue)) {
return;
}
HODZKKOSYW_OnKeyUp.oldValue=newValue;
if ( ! (GetDisabled(Ctrl('HODZKKOSYW')) || IsMobile())) {
if (Gt(newValue.length,2)) {
SuggesterLib.callSuggest(Sugg_HODZKKOSYW,1);
} else {
SuggesterLib.resetSuggest('HODZKKOSYW','HODZKKOSYW');
}
}
}
function HODZKKOSYW_ValidSuggest(e) {
e=(window.event?window.event:e);
if (e) {
return SuggesterLib.select_suggest('HODZKKOSYW','HODZKKOSYW',-1,e);
}
}
function XMGRWGFSFV_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('XMGRWGFSFV'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('XMGRWGFSFV').value=ApplyPictureToDate(Ctrl('XMGRWGFSFV').value,TranslatePicture(datePattern),'XMGRWGFSFV');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('XMGRWGFSFV'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('XMGRWGFSFV');
}
}
}
SetActiveField(Ctrl('XMGRWGFSFV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATANASC','D',w_DATANASC,HtW(Ctrl('XMGRWGFSFV').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATANASC(HtW(Ctrl('XMGRWGFSFV').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function XMGRWGFSFV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XMGRWGFSFV'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('XMGRWGFSFV',w_DATANASC,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('XMGRWGFSFV');
SetActiveField(Ctrl('XMGRWGFSFV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XMGRWGFSFV'),e);
}
function XMGRWGFSFV_ZOOM_Click() {
LaunchCalendar(Ctrl('XMGRWGFSFV'));
}
function MBGANUUHRA_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPODOC','C',w_TIPODOC,HtW(getComboValue(Ctrl('MBGANUUHRA')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPODOC(HtW(getComboValue(Ctrl('MBGANUUHRA')),'C'),null,e);
return l_bSetResult;
}
}
function MBGANUUHRA_OnFocus(e) {
SetActiveField(Ctrl('MBGANUUHRA'),true);
}
function MBGANUUHRA_OnBlur(e) {
SetActiveField(Ctrl('MBGANUUHRA'),false);
}
function HVEEMUJUUY_Valid(e) {
SetActiveField(Ctrl('HVEEMUJUUY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NUMDOCUM','C',w_NUMDOCUM,HtW(Ctrl('HVEEMUJUUY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NUMDOCUM(HtW(Ctrl('HVEEMUJUUY').value,'C'),null,e);
return l_bSetResult;
}
}
function HVEEMUJUUY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HVEEMUJUUY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HVEEMUJUUY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HVEEMUJUUY'),e);
}
function XHWYGOPPUN_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('XHWYGOPPUN'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('XHWYGOPPUN').value=ApplyPictureToDate(Ctrl('XHWYGOPPUN').value,TranslatePicture(datePattern),'XHWYGOPPUN');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('XHWYGOPPUN'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('XHWYGOPPUN');
}
}
}
SetActiveField(Ctrl('XHWYGOPPUN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATARILASC','D',w_DATARILASC,HtW(Ctrl('XHWYGOPPUN').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATARILASC(HtW(Ctrl('XHWYGOPPUN').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function XHWYGOPPUN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XHWYGOPPUN'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('XHWYGOPPUN',w_DATARILASC,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('XHWYGOPPUN');
SetActiveField(Ctrl('XHWYGOPPUN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XHWYGOPPUN'),e);
}
function XHWYGOPPUN_ZOOM_Click() {
LaunchCalendar(Ctrl('XHWYGOPPUN'));
}
function BNWXBPSIDG_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('BNWXBPSIDG'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('BNWXBPSIDG').value=ApplyPictureToDate(Ctrl('BNWXBPSIDG').value,TranslatePicture(datePattern),'BNWXBPSIDG');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('BNWXBPSIDG'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('BNWXBPSIDG');
}
}
}
SetActiveField(Ctrl('BNWXBPSIDG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAVALI','D',w_DATAVALI,HtW(Ctrl('BNWXBPSIDG').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAVALI(HtW(Ctrl('BNWXBPSIDG').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function BNWXBPSIDG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BNWXBPSIDG'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('BNWXBPSIDG',w_DATAVALI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('BNWXBPSIDG');
SetActiveField(Ctrl('BNWXBPSIDG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BNWXBPSIDG'),e);
}
function BNWXBPSIDG_ZOOM_Click() {
LaunchCalendar(Ctrl('BNWXBPSIDG'));
}
function HRNCPADUFU_Valid(e) {
SetActiveField(Ctrl('HRNCPADUFU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('AUTRILASC','C',w_AUTRILASC,HtW(Ctrl('HRNCPADUFU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_AUTRILASC(HtW(Ctrl('HRNCPADUFU').value,'C'),null,e);
return l_bSetResult;
}
}
function HRNCPADUFU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HRNCPADUFU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HRNCPADUFU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HRNCPADUFU'),e);
}
function OJJHIUDPFY_Valid(e) {
SetActiveField(Ctrl('OJJHIUDPFY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CONNES','C',w_CONNES,HtW(Ctrl('OJJHIUDPFY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONNES(HtW(Ctrl('OJJHIUDPFY').value,'C'),null,e);
return l_bSetResult;
}
}
function OJJHIUDPFY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OJJHIUDPFY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OJJHIUDPFY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OJJHIUDPFY'),e);
}
function XFKXBQYUIU_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('PEP','C',w_PEP,ChkboxValueAssign(Ctrl('XFKXBQYUIU'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PEP(ChkboxValueAssign(Ctrl('XFKXBQYUIU'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function XFKXBQYUIU_OnFocus(e) {
SetActiveField(Ctrl('XFKXBQYUIU'),true);
}
function XFKXBQYUIU_OnBlur(e) {
SetActiveField(Ctrl('XFKXBQYUIU'),false);
}
function TVQKRQXOUS_Valid(e) {
SetActiveField(Ctrl('TVQKRQXOUS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TXTERR','M',w_TXTERR,HtW(Ctrl('TVQKRQXOUS').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TXTERR(HtW(Ctrl('TVQKRQXOUS').value,'M'),null,e);
return l_bSetResult;
}
}
function TVQKRQXOUS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TVQKRQXOUS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TVQKRQXOUS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TVQKRQXOUS'),e);
}
function GIZUBOQEKL_Valid(e) {
SetActiveField(Ctrl('GIZUBOQEKL'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('GIZUBOQEKL') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('PRGSOG','C',w_PRGSOG,HtW(Ctrl('GIZUBOQEKL').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PRGSOG(HtW(Ctrl('GIZUBOQEKL').value,'C'),null,e);
return l_bSetResult;
}
}
function GIZUBOQEKL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GIZUBOQEKL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GIZUBOQEKL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GIZUBOQEKL'),e);
}
function AYCRVWSEMG_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGFULL','C',w_FLGFULL,ChkboxValueAssign(Ctrl('AYCRVWSEMG'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGFULL(ChkboxValueAssign(Ctrl('AYCRVWSEMG'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function AYCRVWSEMG_OnFocus(e) {
SetActiveField(Ctrl('AYCRVWSEMG'),true);
}
function AYCRVWSEMG_OnBlur(e) {
SetActiveField(Ctrl('AYCRVWSEMG'),false);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function TWTTDWKCRG_wrap_Valid(event) {
return TWTTDWKCRG_Valid(event);
}
SPBOUILib.SetInputExit('TWTTDWKCRG',TWTTDWKCRG_wrap_Valid);
function TWTTDWKCRG_wrap_OnFocus(event) {
return TWTTDWKCRG_OnFocus(event);
}
SPBOUILib.SetInputEnter('TWTTDWKCRG',TWTTDWKCRG_wrap_OnFocus);
function TWTTDWKCRG_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('TWTTDWKCRG',TWTTDWKCRG_wrap_OnKeyPress);
function TWTTDWKCRG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TWTTDWKCRG',TWTTDWKCRG_wrap_OnKeyDown);
function WWGIVGNUDW_wrap_Valid(event) {
return WWGIVGNUDW_Valid(event);
}
SPBOUILib.SetInputExit('WWGIVGNUDW',WWGIVGNUDW_wrap_Valid);
function WWGIVGNUDW_wrap_OnFocus(event) {
return WWGIVGNUDW_OnFocus(event);
}
SPBOUILib.SetInputEnter('WWGIVGNUDW',WWGIVGNUDW_wrap_OnFocus);
function WWGIVGNUDW_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('WWGIVGNUDW',WWGIVGNUDW_wrap_OnKeyPress);
function WWGIVGNUDW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WWGIVGNUDW',WWGIVGNUDW_wrap_OnKeyDown);
function CZTHKEDVCO_wrap_Valid(event) {
return CZTHKEDVCO_Valid(event);
}
SPBOUILib.SetCheckboxClick('CZTHKEDVCO',CZTHKEDVCO_wrap_Valid);
function CZTHKEDVCO_wrap_OnFocus(event) {
return CZTHKEDVCO_OnFocus(event);
}
SPBOUILib.SetInputEnter('CZTHKEDVCO',CZTHKEDVCO_wrap_OnFocus);
function CZTHKEDVCO_wrap_Blur(event) {
return CZTHKEDVCO_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('CZTHKEDVCO',CZTHKEDVCO_wrap_Blur);
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
SPBOUILib.SetInputKeyUp('ODAYKSRECA',function(event) {
  return (Eq(m_cFunction,'edit') || Eq(m_cFunction,'new')?ODAYKSRECA_OnKeyUp(event):void(0));
});
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
function BYPEBFEOAJ_wrap_Valid(event) {
return BYPEBFEOAJ_Valid(event);
}
SPBOUILib.SetInputExit('BYPEBFEOAJ',BYPEBFEOAJ_wrap_Valid);
function BYPEBFEOAJ_wrap_OnFocus(event) {
return BYPEBFEOAJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('BYPEBFEOAJ',BYPEBFEOAJ_wrap_OnFocus);
function BYPEBFEOAJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BYPEBFEOAJ',BYPEBFEOAJ_wrap_OnKeyDown);
function BYPEBFEOAJ_ZOOM_setHandlers() {
function BYPEBFEOAJ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?BYPEBFEOAJ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('BYPEBFEOAJ_ZOOM',BYPEBFEOAJ_ZOOM_wrap_OnClick);
function BYPEBFEOAJ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('BYPEBFEOAJ_ZOOM',BYPEBFEOAJ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('BYPEBFEOAJ',BYPEBFEOAJ_ZOOM_setHandlers);
function NEUBQNUEOJ_wrap_Valid(event) {
return NEUBQNUEOJ_Valid(event);
}
SPBOUILib.SetInputExit('NEUBQNUEOJ',NEUBQNUEOJ_wrap_Valid);
function NEUBQNUEOJ_wrap_OnFocus(event) {
return NEUBQNUEOJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('NEUBQNUEOJ',NEUBQNUEOJ_wrap_OnFocus);
function NEUBQNUEOJ_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('NEUBQNUEOJ',NEUBQNUEOJ_wrap_OnKeyPress);
function NEUBQNUEOJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NEUBQNUEOJ',NEUBQNUEOJ_wrap_OnKeyDown);
function KPSCOABZLB_wrap_Valid(event) {
return KPSCOABZLB_Valid(event);
}
SPBOUILib.SetInputExit('KPSCOABZLB',KPSCOABZLB_wrap_Valid);
function KPSCOABZLB_wrap_OnFocus(event) {
return KPSCOABZLB_OnFocus(event);
}
SPBOUILib.SetInputEnter('KPSCOABZLB',KPSCOABZLB_wrap_OnFocus);
function KPSCOABZLB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KPSCOABZLB',KPSCOABZLB_wrap_OnKeyDown);
function QPALJZMFCL_wrap_Valid(event) {
return QPALJZMFCL_Valid(event);
}
SPBOUILib.SetComboChange('QPALJZMFCL',QPALJZMFCL_wrap_Valid);
function QPALJZMFCL_wrap_OnFocus(event) {
return QPALJZMFCL_OnFocus(event);
}
SPBOUILib.SetInputEnter('QPALJZMFCL',QPALJZMFCL_wrap_OnFocus);
function QPALJZMFCL_wrap_Blur(event) {
return QPALJZMFCL_OnBlur(event);
}
SPBOUILib.SetInputExit('QPALJZMFCL',QPALJZMFCL_wrap_Blur);
function HODZKKOSYW_wrap_Valid(event) {
return HODZKKOSYW_Valid(event);
}
SPBOUILib.SetInputExit('HODZKKOSYW',HODZKKOSYW_wrap_Valid);
function HODZKKOSYW_wrap_OnFocus(event) {
return HODZKKOSYW_OnFocus(event);
}
SPBOUILib.SetInputEnter('HODZKKOSYW',HODZKKOSYW_wrap_OnFocus);
function HODZKKOSYW_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('HODZKKOSYW',HODZKKOSYW_wrap_OnKeyPress);
function HODZKKOSYW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HODZKKOSYW',HODZKKOSYW_wrap_OnKeyDown);
function HODZKKOSYW_ZOOM_setHandlers() {
function HODZKKOSYW_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?HODZKKOSYW_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('HODZKKOSYW_ZOOM',HODZKKOSYW_ZOOM_wrap_OnClick);
function HODZKKOSYW_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('HODZKKOSYW_ZOOM',HODZKKOSYW_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('HODZKKOSYW',HODZKKOSYW_ZOOM_setHandlers);
SPBOUILib.SetInputKeyUp('HODZKKOSYW',function(event) {
  return (Eq(m_cFunction,'edit') || Eq(m_cFunction,'new')?HODZKKOSYW_OnKeyUp(event):void(0));
});
function XMGRWGFSFV_wrap_Valid(event) {
return XMGRWGFSFV_Valid(event);
}
SPBOUILib.SetInputExit('XMGRWGFSFV',XMGRWGFSFV_wrap_Valid);
function XMGRWGFSFV_wrap_OnFocus(event) {
return XMGRWGFSFV_OnFocus(event);
}
SPBOUILib.SetInputEnter('XMGRWGFSFV',XMGRWGFSFV_wrap_OnFocus);
function XMGRWGFSFV_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('XMGRWGFSFV',XMGRWGFSFV_wrap_OnKeyPress);
function XMGRWGFSFV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('XMGRWGFSFV',XMGRWGFSFV_wrap_OnKeyDown);
function XMGRWGFSFV_ZOOM_setHandlers() {
function XMGRWGFSFV_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?XMGRWGFSFV_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('XMGRWGFSFV_ZOOM',XMGRWGFSFV_ZOOM_wrap_OnClick);
function XMGRWGFSFV_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('XMGRWGFSFV_ZOOM',XMGRWGFSFV_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('XMGRWGFSFV',XMGRWGFSFV_ZOOM_setHandlers);
function MBGANUUHRA_wrap_Valid(event) {
return MBGANUUHRA_Valid(event);
}
SPBOUILib.SetComboChange('MBGANUUHRA',MBGANUUHRA_wrap_Valid);
function MBGANUUHRA_wrap_OnFocus(event) {
return MBGANUUHRA_OnFocus(event);
}
SPBOUILib.SetInputEnter('MBGANUUHRA',MBGANUUHRA_wrap_OnFocus);
function MBGANUUHRA_wrap_Blur(event) {
return MBGANUUHRA_OnBlur(event);
}
SPBOUILib.SetInputExit('MBGANUUHRA',MBGANUUHRA_wrap_Blur);
function HVEEMUJUUY_wrap_Valid(event) {
return HVEEMUJUUY_Valid(event);
}
SPBOUILib.SetInputExit('HVEEMUJUUY',HVEEMUJUUY_wrap_Valid);
function HVEEMUJUUY_wrap_OnFocus(event) {
return HVEEMUJUUY_OnFocus(event);
}
SPBOUILib.SetInputEnter('HVEEMUJUUY',HVEEMUJUUY_wrap_OnFocus);
function HVEEMUJUUY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HVEEMUJUUY',HVEEMUJUUY_wrap_OnKeyDown);
function XHWYGOPPUN_wrap_Valid(event) {
return XHWYGOPPUN_Valid(event);
}
SPBOUILib.SetInputExit('XHWYGOPPUN',XHWYGOPPUN_wrap_Valid);
function XHWYGOPPUN_wrap_OnFocus(event) {
return XHWYGOPPUN_OnFocus(event);
}
SPBOUILib.SetInputEnter('XHWYGOPPUN',XHWYGOPPUN_wrap_OnFocus);
function XHWYGOPPUN_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('XHWYGOPPUN',XHWYGOPPUN_wrap_OnKeyPress);
function XHWYGOPPUN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('XHWYGOPPUN',XHWYGOPPUN_wrap_OnKeyDown);
function XHWYGOPPUN_ZOOM_setHandlers() {
function XHWYGOPPUN_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?XHWYGOPPUN_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('XHWYGOPPUN_ZOOM',XHWYGOPPUN_ZOOM_wrap_OnClick);
function XHWYGOPPUN_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('XHWYGOPPUN_ZOOM',XHWYGOPPUN_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('XHWYGOPPUN',XHWYGOPPUN_ZOOM_setHandlers);
function BNWXBPSIDG_wrap_Valid(event) {
return BNWXBPSIDG_Valid(event);
}
SPBOUILib.SetInputExit('BNWXBPSIDG',BNWXBPSIDG_wrap_Valid);
function BNWXBPSIDG_wrap_OnFocus(event) {
return BNWXBPSIDG_OnFocus(event);
}
SPBOUILib.SetInputEnter('BNWXBPSIDG',BNWXBPSIDG_wrap_OnFocus);
function BNWXBPSIDG_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('BNWXBPSIDG',BNWXBPSIDG_wrap_OnKeyPress);
function BNWXBPSIDG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('BNWXBPSIDG',BNWXBPSIDG_wrap_OnKeyDown);
function BNWXBPSIDG_ZOOM_setHandlers() {
function BNWXBPSIDG_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?BNWXBPSIDG_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('BNWXBPSIDG_ZOOM',BNWXBPSIDG_ZOOM_wrap_OnClick);
function BNWXBPSIDG_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('BNWXBPSIDG_ZOOM',BNWXBPSIDG_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('BNWXBPSIDG',BNWXBPSIDG_ZOOM_setHandlers);
function HRNCPADUFU_wrap_Valid(event) {
return HRNCPADUFU_Valid(event);
}
SPBOUILib.SetInputExit('HRNCPADUFU',HRNCPADUFU_wrap_Valid);
function HRNCPADUFU_wrap_OnFocus(event) {
return HRNCPADUFU_OnFocus(event);
}
SPBOUILib.SetInputEnter('HRNCPADUFU',HRNCPADUFU_wrap_OnFocus);
function HRNCPADUFU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HRNCPADUFU',HRNCPADUFU_wrap_OnKeyDown);
function OJJHIUDPFY_wrap_Valid(event) {
return OJJHIUDPFY_Valid(event);
}
SPBOUILib.SetInputExit('OJJHIUDPFY',OJJHIUDPFY_wrap_Valid);
function OJJHIUDPFY_wrap_OnFocus(event) {
return OJJHIUDPFY_OnFocus(event);
}
SPBOUILib.SetInputEnter('OJJHIUDPFY',OJJHIUDPFY_wrap_OnFocus);
function OJJHIUDPFY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OJJHIUDPFY',OJJHIUDPFY_wrap_OnKeyDown);
function XFKXBQYUIU_wrap_Valid(event) {
return XFKXBQYUIU_Valid(event);
}
SPBOUILib.SetCheckboxClick('XFKXBQYUIU',XFKXBQYUIU_wrap_Valid);
function XFKXBQYUIU_wrap_OnFocus(event) {
return XFKXBQYUIU_OnFocus(event);
}
SPBOUILib.SetInputEnter('XFKXBQYUIU',XFKXBQYUIU_wrap_OnFocus);
function XFKXBQYUIU_wrap_Blur(event) {
return XFKXBQYUIU_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('XFKXBQYUIU',XFKXBQYUIU_wrap_Blur);
function TVQKRQXOUS_wrap_Valid(event) {
return TVQKRQXOUS_Valid(event);
}
SPBOUILib.SetInputExit('TVQKRQXOUS',TVQKRQXOUS_wrap_Valid);
function TVQKRQXOUS_wrap_OnFocus(event) {
return TVQKRQXOUS_OnFocus(event);
}
SPBOUILib.SetInputEnter('TVQKRQXOUS',TVQKRQXOUS_wrap_OnFocus);
function GIZUBOQEKL_wrap_Valid(event) {
return GIZUBOQEKL_Valid(event);
}
SPBOUILib.SetInputExit('GIZUBOQEKL',GIZUBOQEKL_wrap_Valid);
function GIZUBOQEKL_wrap_OnFocus(event) {
return GIZUBOQEKL_OnFocus(event);
}
SPBOUILib.SetInputEnter('GIZUBOQEKL',GIZUBOQEKL_wrap_OnFocus);
function GIZUBOQEKL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('GIZUBOQEKL',GIZUBOQEKL_wrap_OnKeyDown);
function AYCRVWSEMG_wrap_Valid(event) {
return AYCRVWSEMG_Valid(event);
}
SPBOUILib.SetCheckboxClick('AYCRVWSEMG',AYCRVWSEMG_wrap_Valid);
function AYCRVWSEMG_wrap_OnFocus(event) {
return AYCRVWSEMG_OnFocus(event);
}
SPBOUILib.SetInputEnter('AYCRVWSEMG',AYCRVWSEMG_wrap_OnFocus);
function AYCRVWSEMG_wrap_Blur(event) {
return AYCRVWSEMG_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('AYCRVWSEMG',AYCRVWSEMG_wrap_Blur);
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
FocusFirstComponent.edit={"page_1":["TWTTDWKCRG"]};
FocusFirstComponent.query={"page_1":["TWTTDWKCRG"]};
FocusFirstComponent.otherwise={"page_1":["TWTTDWKCRG"]};
function Help() {
windowOpenForeground('../doc/armt_cgo_personbo_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
GetLayerID.Layers.push({"id":"AQSQVBKXAL","name":"Residenza"});
GetLayerID.Layers.push({"id":"EWPTTWSBMT","name":"PF"});
GetLayerID.Layers.push({"id":"BLAIVNGHMW","name":"PFDoc"});
GetLayerID.Layers.push({"id":"OQFTKYDCIW","name":"Chiave"});
GetLayerID.Layers.push({"id":"MKZZTQTPHW","name":"Errori"});
function DeclareWVs() {
var a = arguments;
w_COGNOME=a[0];
w_NOME=a[1];
w_CFESTERO=a[2];
w_PAESE=a[3];
w_DESCCIT=a[4];
w_PROVINCIA=a[5];
w_CAP=a[6];
w_DOMICILIO=a[7];
w_IDCITTANA=a[8];
w_NASCOMUN=a[9];
w_NASPROV=a[10];
w_SESSO=a[11];
w_NASSTATO=a[12];
w_DATANASC=a[13];
w_TIPODOC=a[14];
w_NUMDOCUM=a[15];
w_DATARILASC=a[16];
w_DATAVALI=a[17];
w_AUTRILASC=a[18];
w_CONNES=a[19];
w_PEP=a[20];
w_TXTERR=a[21];
w_PRGSOG=a[22];
w_FLGFULL=a[23];
w_nascomunid=a[24];
w_dessta=a[25];
w_DESCRI=a[26];
w_CODCAB=a[27];
if (Gt(a.length,28)) {
o_COGNOME=w_COGNOME;
o_NOME=w_NOME;
o_PAESE=w_PAESE;
o_DESCCIT=w_DESCCIT;
o_IDCITTANA=w_IDCITTANA;
o_NASSTATO=w_NASSTATO;
o_DATANASC=w_DATANASC;
}
m_PrimaryKeys=['PRGSOG'];
}
function i_PrimaryKey() {
return 'cgo_soggetti_err'+'\\'+CPLib.ToCPStr(w_PRGSOG);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_cgo_personbo',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_PAESE,'C'); },"field":"CODSTA","type":"C"},{"expression":function() { return WtA(w_dessta,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"YVIKEGPYPM"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_DESCCIT,'C'); },"field":"CITTA","type":"C"},{"expression":function() { return WtA(w_PROVINCIA,'C'); },"field":"PROV","type":"C"},{"expression":function() { return WtA(w_CAP,'C'); },"field":"CAP","type":"C"},{"expression":function() { return WtA(w_CODCAB,'C'); },"field":"CAB","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcitta','C'),"uid":"ODAYKSRECA"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_IDCITTANA,'C'); },"field":"IDBASE","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcittna','C'),"uid":"BYPEBFEOAJ"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_NASSTATO,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstatna','C'),"uid":"HODZKKOSYW"});
}
_Obli('COGNOME',0,'TWTTDWKCRG',false,"1816546867")
_Obli('NOME',0,'WWGIVGNUDW',false,"443454")
_Obli('CFESTERO',1,'CZTHKEDVCO',false,"10034405761")
_Obli('PAESE',0,'YVIKEGPYPM',false,"7776403")
_Obli('DESCCIT',0,'ODAYKSRECA',false,"15186643")
_Obli('PROVINCIA',0,'NOTZPDMYIA',false,"10095365423")
_Obli('CAP',0,'RDAVOEETJG',false,"21587")
_Obli('DOMICILIO',0,'VYLHWTRQNX',false,"554236824")
_Obli('IDCITTANA',0,'BYPEBFEOAJ',false,"378006153")
_Obli('NASSTATO',0,'HODZKKOSYW',false,"12123284333")
_Obli('NASCOMUN',0,'NEUBQNUEOJ',true,"12123334500")
_Obli('NASPROV',0,'KPSCOABZLB',true,"11693745788")
_Obli('SESSO',0,'QPALJZMFCL',true,"7776675")
_Obli('CONNES',0,'OJJHIUDPFY',true,"11921223220",null,"10034398626")
_Obli('DATANASC',2,'XMGRWGFSFV',true,"11777527481")
_Obli('TIPODOC',0,'MBGANUUHRA',true,"11429032151",'MBGANUUHRA')
_Obli('NUMDOCUM',0,'HVEEMUJUUY',true,"1734932797")
_Obli('DATARILASC',2,'XHWYGOPPUN',true,"1690077224")
_Obli('DATAVALI',2,'BNWXBPSIDG',false)
_Obli('AUTRILASC',0,'HRNCPADUFU',true,"10032163180")
_Obli('TXTERR',0,'TVQKRQXOUS',false,"118057317")
_Obli('PRGSOG',0,'GIZUBOQEKL',false,"321938427")
_Obli('PEP',0,'XFKXBQYUIU',false,"1513560829")
_Obli('FLGFULL',0,'AYCRVWSEMG',false,"1791194163")
