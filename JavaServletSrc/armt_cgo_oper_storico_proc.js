function FillCombosValues() {
FillCombo('MBGANUUHRA','MBGANUUHRA');
FillCombo('SAQTIHOALW','SAQTIHOALW');
FillCombo('LVYFMQXNZH','LVYFMQXNZH');
FillCombo('DKNVEJCFAA','DKNVEJCFAA');
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('BMTLGIUQTH',function(){return WtH(w_CAIDBIGLIETTO,'C',30,0,'!')},w_CAIDBIGLIETTO);
SPBOUILib.SetInputValue('YLIKFVPZJA',function(){return WtH(w_DATAOPE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAOPE);
if(c=Ctrl('PURPSXEVAI')) selectCombo(c,w_FLAGCONT,'C')
if(c=Ctrl('WJQFIEBCQV')) selectCombo(c,w_CACODICE,'N')
if(c=Ctrl('YJDISDDJUY')) selectCombo(c,w_CAFLGOPE,'C')
SPBOUILib.SetInputValue('HUAGBHPUNH',function(){return WtH(w_TOTLIRE,'N',15,2,'999,999,999,999.99')},w_TOTLIRE);
SPBOUILib.SetInputValue('HUDOCMLKKT',function(){return WtH(w_TOTCONT,'N',15,2,'999,999,999,999.99')},w_TOTCONT);
if(c=Ctrl('SFKJNKYLJO')) selectRadio(c,w_CGOFLGVLT,'C')
if(c=Ctrl('EOSKLIUGBC')) selectCombo(c,w_MEZPAGAM,'C')
if(c=Ctrl('CZTHKEDVCO')) ChkboxCheckUncheck(c,1,w_CFESTERO)
if(c=Ctrl('CZTHKEDVCO')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('OJJHIUDPFY',function(){return WtH(w_CODFISC,'C',16,0,'!')},w_CODFISC);
SPBOUILib.SetInputValue('TWTTDWKCRG',function(){return WtH(w_COGNOME,'C',26,0,'!')},w_COGNOME);
SPBOUILib.SetInputValue('WWGIVGNUDW',function(){return WtH(w_NOME,'C',25,0,'!')},w_NOME);
SPBOUILib.SetInputValue('NEUBQNUEOJ',function(){return WtH(w_NASCOMUN,'C',30,0,'!')},w_NASCOMUN);
SPBOUILib.SetInputValue('KPSCOABZLB',function(){return WtH(w_TIPINTER,'C',2,0,'!')},w_TIPINTER);
if(c=Ctrl('QPALJZMFCL')) selectCombo(c,w_SESSO,'C')
SPBOUILib.SetInputValue('HODZKKOSYW',function(){return WtH(w_NASSTATO,'C',30,0,'!')},w_NASSTATO);
SPBOUILib.SetInputValue('XMGRWGFSFV',function(){return WtH(w_DATANASC,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATANASC);
SPBOUILib.SetInputValue('YVIKEGPYPM',function(){return WtH(w_PAESE,'C',3,0,'')},w_PAESE);
SPBOUILib.SetInputValue('ODAYKSRECA',function(){return WtH(w_DESCCIT,'C',40,0,'!')},w_DESCCIT);
SPBOUILib.SetInputValue('NOTZPDMYIA',function(){return WtH(w_PROVINCIA,'C',2,0,'')},w_PROVINCIA);
SPBOUILib.SetInputValue('RDAVOEETJG',function(){return WtH(w_CAP,'C',9,0,'')},w_CAP);
SPBOUILib.SetInputValue('VYLHWTRQNX',function(){return WtH(w_DOMICILIO,'C',35,0,'!')},w_DOMICILIO);
if(c=Ctrl('MBGANUUHRA')) selectCombo(c,w_TIPODOC,'C')
SPBOUILib.SetInputValue('HVEEMUJUUY',function(){return WtH(w_NUMDOCUM,'C',15,0,'!')},w_NUMDOCUM);
SPBOUILib.SetInputValue('XHWYGOPPUN',function(){return WtH(w_DATARILASC,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATARILASC);
SPBOUILib.SetInputValue('BNWXBPSIDG',function(){return WtH(w_DATAVALI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAVALI);
SPBOUILib.SetInputValue('HRNCPADUFU',function(){return WtH(w_AUTRILASC,'C',30,0,'!')},w_AUTRILASC);
SPBOUILib.SetInputValue('XFUOZLSACP',function(){return WtH(w_SNAINUMOPE,'C',15,0,'')},w_SNAINUMOPE);
SPBOUILib.SetInputValue('OEIKQOZMYJ',function(){return WtH(w_DATAREG,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAREG);
SPBOUILib.SetInputValue('UJRFWINIVQ',function(){return WtH(w_TIPOOPRAP,'C',2,0,'')},w_TIPOOPRAP);
SPBOUILib.SetInputValue('XYMCLUECBD',function(){return WtH(w_NUMPROG,'C',11,0,'')},w_NUMPROG);
SPBOUILib.SetInputValue('GXLWKNXGMM',function(){return WtH(w_gIntemediario,'C',11,0,'')},w_gIntemediario);
SPBOUILib.SetInputValue('AVHTGZTOSZ',function(){return WtH(w_CODDIPE,'C',6,0,'')},w_CODDIPE);
SPBOUILib.SetInputValue('RLUMBFHPUD',function(){return WtH(w_DESCCITDIP,'C',30,0,'')},w_DESCCITDIP);
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
SPBOUILib.SetInputValue('OJGQABFSYN',function(){return WtH(w_PROVINCIADIP,'C',2,0,'')},w_PROVINCIADIP);
SPBOUILib.SetInputValue('OZEOCQRSEQ',function(){return WtH(w_CODCABDIP,'C',6,0,'')},w_CODCABDIP);
var tmp_ESVLUSNYWB = ToHTag(AsControlValue(w_dessta));
if (Ne(e_ESVLUSNYWB,tmp_ESVLUSNYWB)) {
SPBOUILib.SetLabelValue('ESVLUSNYWB','innerHTML',tmp_ESVLUSNYWB);
e_ESVLUSNYWB=tmp_ESVLUSNYWB;
}
SPBOUILib.SetInputValue('BSSRUASCBR',function(){return WtH(w_MIDBIGLIETTO,'M',10,0,'')},w_MIDBIGLIETTO);
if(c=Ctrl('LVYFMQXNZH')) selectCombo(c,w_VLTPLAT,'C')
if(c=Ctrl('DKNVEJCFAA')) selectCombo(c,w_TIPOGIOCO,'C')
SPBOUILib.SetInputValue('KZWBLPQNHU',function(){return WtH(w_ASSEGNO,'C',25,0,'')},w_ASSEGNO);
SPBOUILib.SetInputValue('UTUCDPQJKK',function(){return WtH(w_IBAN,'C',27,0,'!')},w_IBAN);
SPBOUILib.SetInputValue('FKEAKFSYVU',function(){return WtH(w_CC4CIFRE,'C',4,0,'')},w_CC4CIFRE);
SPBOUILib.SetInputValue('OXFYJQLTDL',function(){return WtH(w_CCDATSCA,'C',7,0,'')},w_CCDATSCA);
SPBOUILib.SetInputValue('KSZEHVQAGY',function(){return WtH(w_NUMTEL,'C',20,0,'')},w_NUMTEL);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
h=Eq(w_gGesDoc,'N') || (Eq(w_gGesDoc,'S') && Empty(w_IDDOCALL)) || IsHiddenByStateDriver(Z.Tabs.Get('tabs').GetTabstripID('page_2'));
SetDisplay(Z.Tabs.Get('tabs').GetTabstripID('page_2'),h);
if (h && (Z.Tabs.Get('tabs').IsExpanded('page_2'))) {
Z.Tabs.Get('tabs').Next() || Z.Tabs.Get('tabs').Prev();
}
SetDisplay('CCUOYXMBZC_DIV',IsHiddenByStateDriver('box_CCUOYXMBZC'));
SetDisplay('YORQOIOBQN_DIV',IsHiddenByStateDriver('Operazione'));
SetDisplay('AQSQVBKXAL_DIV',IsHiddenByStateDriver('Soggetto'));
SetDisplay(Ctrl('DERAHXASAL'),Eq(w_CFESTERO,1));
SetDisplay(Ctrl('RQVPEKINIU'),Eq(w_CFESTERO,0));
SetDisplay(Ctrl('BSSRUASCBR'),true || IsHiddenByStateDriver('MIDBIGLIETTO'));
SetDisplay(Ctrl('KZWBLPQNHU'),Ne(w_MEZPAGAM,'C') && Ne(w_MEZPAGAM,'B') || IsHiddenByStateDriver('ASSEGNO'));
SetDisplay(Ctrl('UTUCDPQJKK'),Ne(w_MEZPAGAM,'I') && Ne(w_MEZPAGAM,'E') && Ne(w_MEZPAGAM,'P') || IsHiddenByStateDriver('IBAN'));
SetDisplay(Ctrl('FKEAKFSYVU'),Ne(w_MEZPAGAM,'V') || IsHiddenByStateDriver('CC4CIFRE'));
SetDisplay(Ctrl('OXFYJQLTDL'),Ne(w_MEZPAGAM,'V') || IsHiddenByStateDriver('CCDATSCA'));
SetDisplay(Ctrl('PBHNLOUBML'),Ne(w_MEZPAGAM,'I') && Ne(w_MEZPAGAM,'E') && Ne(w_MEZPAGAM,'P'));
SetDisplay(Ctrl('BTZLLSBMCC'),Ne(w_MEZPAGAM,'C') && Ne(w_MEZPAGAM,'B'));
SetDisplay(Ctrl('CQTMIXIELC'),Ne(w_MEZPAGAM,'V'));
SetDisplay(Ctrl('HKREYYVVOP'),Ne(w_MEZPAGAM,'V'));
SetDisplay('XWJLXLYKJC_DIV',IsHiddenByStateDriver('box_XWJLXLYKJC'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["ASSEGNO"]=['BTZLLSBMCC'];
HideUI.lblids["AUTRILASC"]=['ZPQIEJPWJC'];
HideUI.lblids["CACODICE"]=['YFGRJCQGZV'];
HideUI.lblids["CAIDBIGLIETTO"]=['ZQBDEYWWMG'];
HideUI.lblids["CAP"]=['GDOCAGKROT'];
HideUI.lblids["CC4CIFRE"]=['CQTMIXIELC'];
HideUI.lblids["CCDATSCA"]=['HKREYYVVOP'];
HideUI.lblids["CGOFLGVLT"]=['LKYFODKVBU'];
HideUI.lblids["CGOTIPOPE"]=['NRIPVBSJUQ','DJRHGZHJSR'];
HideUI.lblids["CODCABDIP"]=['ENBRMMDVUP'];
HideUI.lblids["CODDIPE"]=['XVRJYSKGWZ'];
HideUI.lblids["CODFISC"]=['WZDAFMDKJE'];
HideUI.lblids["COGNOME"]=['TVSLWOCERI'];
HideUI.lblids["DATANASC"]=['HZYTDOZFPI'];
HideUI.lblids["DATAOPE"]=['HVHVAYPDJE'];
HideUI.lblids["DATAREG"]=['IKBMEWKQJW'];
HideUI.lblids["DATARILASC"]=['MLJVDLOITR'];
HideUI.lblids["DATAVALI"]=['UYGHJPRVKH'];
HideUI.lblids["DESCCIT"]=['XPSQTBKQQZ'];
HideUI.lblids["DESCCITDIP"]=['CTLYJMTHDV'];
HideUI.lblids["DOMICILIO"]=['TWTXGZJTAR'];
HideUI.lblids["FLAGCONT"]=['GVTXMEILAZ'];
HideUI.lblids["IBAN"]=['PBHNLOUBML'];
HideUI.lblids["MEZPAGAM"]=['VQCVMXHDPB'];
HideUI.lblids["NASCOMUN"]=['WVJSUIKYEY'];
HideUI.lblids["NASSTATO"]=['ZBRDCBHLZC'];
HideUI.lblids["NOME"]=['KUPYKSUBXV'];
HideUI.lblids["NUMDOCUM"]=['YXFGMWZGNN'];
HideUI.lblids["NUMPROG"]=['KDUGHGZUUG'];
HideUI.lblids["NUMTEL"]=['FTGPYDFDAY'];
HideUI.lblids["PAESE"]=['RZBLEGCFJJ'];
HideUI.lblids["PROVINCIA"]=['SBJQIAQUCN'];
HideUI.lblids["PROVINCIADIP"]=['JWSDOSRGAG'];
HideUI.lblids["SESSO"]=['KRSCDPQZTQ'];
HideUI.lblids["SNAINUMOPE"]=['GZVEXPFQCZ'];
HideUI.lblids["TIPINTER"]=['IVAWYVSUQI'];
HideUI.lblids["TIPODOC"]=['YRARWMJPPV'];
HideUI.lblids["TIPOOPRAP"]=['KMCNAWQHKV'];
HideUI.lblids["TOTCONT"]=['IDTBMNCIOX'];
HideUI.lblids["TOTLIRE"]=['XLNVLBYVQX'];
HideUI.lblids["gIntemediario"]=['LOEAMXUYLA'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
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
function YLIKFVPZJA_ZOOM_Click() {
LaunchCalendar(Ctrl('YLIKFVPZJA'));
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
function WJQFIEBCQV_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('CACODICE','N',w_CACODICE,HtW(getComboValue(Ctrl('WJQFIEBCQV')),'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CACODICE(HtW(getComboValue(Ctrl('WJQFIEBCQV')),'N'),null,e);
return l_bSetResult;
}
}
function WJQFIEBCQV_OnFocus(e) {
SetActiveField(Ctrl('WJQFIEBCQV'),true);
}
function WJQFIEBCQV_OnBlur(e) {
SetActiveField(Ctrl('WJQFIEBCQV'),false);
}
function HUAGBHPUNH_Valid(e) {
SetActiveField(Ctrl('HUAGBHPUNH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TOTLIRE','N',w_TOTLIRE,HtW(Ctrl('HUAGBHPUNH').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TOTLIRE(HtW(Ctrl('HUAGBHPUNH').value,'N'),null,e);
return l_bSetResult;
}
}
function HUAGBHPUNH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HUAGBHPUNH'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('HUAGBHPUNH'))) {
SPBOUILib.WtH('HUAGBHPUNH',w_TOTLIRE,'N',15,2,'999999999999.99');
}
SetActiveField(Ctrl('HUAGBHPUNH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HUAGBHPUNH'),e);
}
function HUAGBHPUNH_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999.99"));
}
function HUDOCMLKKT_Valid(e) {
SetActiveField(Ctrl('HUDOCMLKKT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TOTCONT','N',w_TOTCONT,HtW(Ctrl('HUDOCMLKKT').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TOTCONT(HtW(Ctrl('HUDOCMLKKT').value,'N'),null,e);
return l_bSetResult;
}
}
function HUDOCMLKKT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HUDOCMLKKT'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('HUDOCMLKKT',w_TOTCONT,'N',15,2,'999999999999.99');
SetActiveField(Ctrl('HUDOCMLKKT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HUDOCMLKKT'),e);
}
function HUDOCMLKKT_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999.99"));
}
function SFKJNKYLJO_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('CGOFLGVLT','C',w_CGOFLGVLT,HtW(getRadioValue(Ctrl('SFKJNKYLJO')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CGOFLGVLT(HtW(getRadioValue(Ctrl('SFKJNKYLJO')),'C'),null,e);
return l_bSetResult;
}
}
function EOSKLIUGBC_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('MEZPAGAM','C',w_MEZPAGAM,HtW(getComboValue(Ctrl('EOSKLIUGBC')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_MEZPAGAM(HtW(getComboValue(Ctrl('EOSKLIUGBC')),'C'),null,e);
return l_bSetResult;
}
}
function EOSKLIUGBC_OnFocus(e) {
SetActiveField(Ctrl('EOSKLIUGBC'),true);
}
function EOSKLIUGBC_OnBlur(e) {
SetActiveField(Ctrl('EOSKLIUGBC'),false);
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
function OJJHIUDPFY_Valid(e) {
SetActiveField(Ctrl('OJJHIUDPFY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODFISC','C',w_CODFISC,HtW(Ctrl('OJJHIUDPFY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODFISC(HtW(Ctrl('OJJHIUDPFY').value,'C'),null,e);
return l_bSetResult;
}
}
function OJJHIUDPFY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OJJHIUDPFY'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('OJJHIUDPFY'))) {
SPBOUILib.WtH('OJJHIUDPFY',w_CODFISC,'C',16,0,'!');
}
SetActiveField(Ctrl('OJJHIUDPFY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OJJHIUDPFY'),e);
}
function OJJHIUDPFY_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("!"));
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
SPBOUILib.WtH('TWTTDWKCRG',w_COGNOME,'C',26,0,'!');
SetActiveField(Ctrl('TWTTDWKCRG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TWTTDWKCRG'),e);
}
function TWTTDWKCRG_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("!"));
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
SPBOUILib.WtH('WWGIVGNUDW',w_NOME,'C',25,0,'!');
SetActiveField(Ctrl('WWGIVGNUDW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WWGIVGNUDW'),e);
}
function WWGIVGNUDW_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("!"));
}
function NEUBQNUEOJ_Valid(e) {
SuggesterLib.resetSuggest('NEUBQNUEOJ','NEUBQNUEOJ');
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
NEUBQNUEOJ_OnKeyUp.oldValue=HtW(Ctrl('NEUBQNUEOJ').value,'C');
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NEUBQNUEOJ'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('NEUBQNUEOJ',w_NASCOMUN,'C',30,0,'!');
SetActiveField(Ctrl('NEUBQNUEOJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NEUBQNUEOJ'),e);
}
function NEUBQNUEOJ_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("!"));
}
function NEUBQNUEOJ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('NEUBQNUEOJ')),'linkview_NEUBQNUEOJ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function NEUBQNUEOJ_OnKeyUp(e) {
var evt = (window.event?window.event:e);
var newValue = HtW(Ctrl('NEUBQNUEOJ').value,'C');
if (Eq(newValue,NEUBQNUEOJ_OnKeyUp.oldValue)) {
return;
}
NEUBQNUEOJ_OnKeyUp.oldValue=newValue;
if ( ! (GetDisabled(Ctrl('NEUBQNUEOJ')) || IsMobile())) {
if (Gt(newValue.length,2)) {
SuggesterLib.callSuggest(Sugg_NEUBQNUEOJ,1);
} else {
SuggesterLib.resetSuggest('NEUBQNUEOJ','NEUBQNUEOJ');
}
}
}
function NEUBQNUEOJ_ValidSuggest(e) {
e=(window.event?window.event:e);
if (e) {
return SuggesterLib.select_suggest('NEUBQNUEOJ','NEUBQNUEOJ',-1,e);
}
}
function KPSCOABZLB_Valid(e) {
SetActiveField(Ctrl('KPSCOABZLB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TIPINTER','C',w_TIPINTER,HtW(Ctrl('KPSCOABZLB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPINTER(HtW(Ctrl('KPSCOABZLB').value,'C'),null,e);
return l_bSetResult;
}
}
function KPSCOABZLB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KPSCOABZLB'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('KPSCOABZLB',w_TIPINTER,'C',2,0,'!');
SetActiveField(Ctrl('KPSCOABZLB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KPSCOABZLB'),e);
}
function KPSCOABZLB_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("!"));
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
SPBOUILib.WtH('HODZKKOSYW',w_NASSTATO,'C',30,0,'!');
SetActiveField(Ctrl('HODZKKOSYW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HODZKKOSYW'),e);
}
function HODZKKOSYW_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("!"));
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
function YVIKEGPYPM_Valid(e) {
SuggesterLib.resetSuggest('YVIKEGPYPM','YVIKEGPYPM');
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
YVIKEGPYPM_OnKeyUp.oldValue=HtW(Ctrl('YVIKEGPYPM').value,'C');
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
function YVIKEGPYPM_OnKeyUp(e) {
var evt = (window.event?window.event:e);
var newValue = HtW(Ctrl('YVIKEGPYPM').value,'C');
if (Eq(newValue,YVIKEGPYPM_OnKeyUp.oldValue)) {
return;
}
YVIKEGPYPM_OnKeyUp.oldValue=newValue;
if ( ! (GetDisabled(Ctrl('YVIKEGPYPM')) || IsMobile())) {
if (Gt(newValue.length,0)) {
SuggesterLib.callSuggest(Sugg_YVIKEGPYPM,2);
} else {
SuggesterLib.resetSuggest('YVIKEGPYPM','YVIKEGPYPM');
}
}
}
function YVIKEGPYPM_ValidSuggest(e) {
e=(window.event?window.event:e);
if (e) {
return SuggesterLib.select_suggest('YVIKEGPYPM','YVIKEGPYPM',-1,e);
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
SPBOUILib.WtH('ODAYKSRECA',w_DESCCIT,'C',40,0,'!');
SetActiveField(Ctrl('ODAYKSRECA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ODAYKSRECA'),e);
}
function ODAYKSRECA_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("!"));
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
SPBOUILib.WtH('VYLHWTRQNX',w_DOMICILIO,'C',35,0,'!');
SetActiveField(Ctrl('VYLHWTRQNX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VYLHWTRQNX'),e);
}
function VYLHWTRQNX_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("!"));
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
SPBOUILib.WtH('HVEEMUJUUY',w_NUMDOCUM,'C',15,0,'!');
SetActiveField(Ctrl('HVEEMUJUUY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HVEEMUJUUY'),e);
}
function HVEEMUJUUY_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("!"));
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
SPBOUILib.WtH('HRNCPADUFU',w_AUTRILASC,'C',30,0,'!');
SetActiveField(Ctrl('HRNCPADUFU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HRNCPADUFU'),e);
}
function HRNCPADUFU_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("!"));
}
function XFUOZLSACP_Valid(e) {
SetActiveField(Ctrl('XFUOZLSACP'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('XFUOZLSACP') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('SNAINUMOPE','C',w_SNAINUMOPE,HtW(Ctrl('XFUOZLSACP').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SNAINUMOPE(HtW(Ctrl('XFUOZLSACP').value,'C'),null,e);
return l_bSetResult;
}
}
function XFUOZLSACP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XFUOZLSACP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XFUOZLSACP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XFUOZLSACP'),e);
}
function href_DERAHXASAL() {
if ( ! (Empty(w_CODFISC))) {
arrt_cgo_read_codfisc_multi([["pObj",this],["pTipo",'I']])
}
}
function href_RQVPEKINIU() {
if ( ! (Empty(w_COGNOME)) &&  ! (Empty(w_NOME)) &&  ! (Empty(LRTrim(w_NASCOMUN)+LRTrim(w_NASSTATO))) &&  ! (Empty(w_SESSO)) &&  ! (Empty(w_DATANASC))) {
arrt_cgo_read_codfisc_multi([["pObj",this],["pTipo",'E']])
}
}
function BSSRUASCBR_Valid(e) {
SetActiveField(Ctrl('BSSRUASCBR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('MIDBIGLIETTO','M',w_MIDBIGLIETTO,HtW(Ctrl('BSSRUASCBR').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_MIDBIGLIETTO(HtW(Ctrl('BSSRUASCBR').value,'M'),null,e);
return l_bSetResult;
}
}
function BSSRUASCBR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BSSRUASCBR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BSSRUASCBR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BSSRUASCBR'),e);
}
function KZWBLPQNHU_Valid(e) {
SetActiveField(Ctrl('KZWBLPQNHU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ASSEGNO','C',w_ASSEGNO,HtW(Ctrl('KZWBLPQNHU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ASSEGNO(HtW(Ctrl('KZWBLPQNHU').value,'C'),null,e);
return l_bSetResult;
}
}
function KZWBLPQNHU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KZWBLPQNHU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KZWBLPQNHU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KZWBLPQNHU'),e);
}
function UTUCDPQJKK_Valid(e) {
SetActiveField(Ctrl('UTUCDPQJKK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IBAN','C',w_IBAN,HtW(Ctrl('UTUCDPQJKK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IBAN(HtW(Ctrl('UTUCDPQJKK').value,'C'),null,e);
return l_bSetResult;
}
}
function UTUCDPQJKK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UTUCDPQJKK'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('UTUCDPQJKK'))) {
SPBOUILib.WtH('UTUCDPQJKK',w_IBAN,'C',27,0,'!');
}
SetActiveField(Ctrl('UTUCDPQJKK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UTUCDPQJKK'),e);
}
function UTUCDPQJKK_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("!"));
}
function FKEAKFSYVU_Valid(e) {
SetActiveField(Ctrl('FKEAKFSYVU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CC4CIFRE','C',w_CC4CIFRE,HtW(Ctrl('FKEAKFSYVU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CC4CIFRE(HtW(Ctrl('FKEAKFSYVU').value,'C'),null,e);
return l_bSetResult;
}
}
function FKEAKFSYVU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FKEAKFSYVU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FKEAKFSYVU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FKEAKFSYVU'),e);
}
function OXFYJQLTDL_Valid(e) {
SetActiveField(Ctrl('OXFYJQLTDL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CCDATSCA','C',w_CCDATSCA,HtW(Ctrl('OXFYJQLTDL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CCDATSCA(HtW(Ctrl('OXFYJQLTDL').value,'C'),null,e);
return l_bSetResult;
}
}
function OXFYJQLTDL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OXFYJQLTDL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OXFYJQLTDL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OXFYJQLTDL'),e);
}
function KSZEHVQAGY_Valid(e) {
SetActiveField(Ctrl('KSZEHVQAGY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NUMTEL','C',w_NUMTEL,HtW(Ctrl('KSZEHVQAGY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NUMTEL(HtW(Ctrl('KSZEHVQAGY').value,'C'),null,e);
return l_bSetResult;
}
}
function KSZEHVQAGY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KSZEHVQAGY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KSZEHVQAGY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KSZEHVQAGY'),e);
}
linkpc_url.u('AAHJPBZVGL',function(){return 'ardt_cgo_oper_storico_multi?m_bInnerChild=true'+GetLinkPCKeys('ardt_cgo_oper_storico_multi')+'&m_bRowsChild='+EnableChild('ardt_cgo_oper_storico_multi')})
_ResetTracker();
function setEventHandlers() {
var c;
function DERAHXASAL_wrap_OnClick(event) {
return href_DERAHXASAL();
}
SPBOUILib.SetImageClick('DERAHXASAL',DERAHXASAL_wrap_OnClick);
function DERAHXASAL_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('DERAHXASAL',DERAHXASAL_wrap_OnKeyDown);
function RQVPEKINIU_wrap_OnClick(event) {
return href_RQVPEKINIU();
}
SPBOUILib.SetImageClick('RQVPEKINIU',RQVPEKINIU_wrap_OnClick);
function RQVPEKINIU_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('RQVPEKINIU',RQVPEKINIU_wrap_OnKeyDown);
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
function YLIKFVPZJA_ZOOM_setHandlers() {
function YLIKFVPZJA_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?YLIKFVPZJA_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('YLIKFVPZJA_ZOOM',YLIKFVPZJA_ZOOM_wrap_OnClick);
function YLIKFVPZJA_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('YLIKFVPZJA_ZOOM',YLIKFVPZJA_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('YLIKFVPZJA',YLIKFVPZJA_ZOOM_setHandlers);
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
function WJQFIEBCQV_wrap_Valid(event) {
return WJQFIEBCQV_Valid(event);
}
SPBOUILib.SetComboChange('WJQFIEBCQV',WJQFIEBCQV_wrap_Valid);
function WJQFIEBCQV_wrap_OnFocus(event) {
return WJQFIEBCQV_OnFocus(event);
}
SPBOUILib.SetInputEnter('WJQFIEBCQV',WJQFIEBCQV_wrap_OnFocus);
function WJQFIEBCQV_wrap_Blur(event) {
return WJQFIEBCQV_OnBlur(event);
}
SPBOUILib.SetInputExit('WJQFIEBCQV',WJQFIEBCQV_wrap_Blur);
function HUAGBHPUNH_wrap_Valid(event) {
return HUAGBHPUNH_Valid(event);
}
SPBOUILib.SetInputExit('HUAGBHPUNH',HUAGBHPUNH_wrap_Valid);
function HUAGBHPUNH_wrap_OnFocus(event) {
return HUAGBHPUNH_OnFocus(event);
}
SPBOUILib.SetInputEnter('HUAGBHPUNH',HUAGBHPUNH_wrap_OnFocus);
function HUAGBHPUNH_wrap_OnKeyPress(event) {
return HUAGBHPUNH_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('HUAGBHPUNH',HUAGBHPUNH_wrap_OnKeyPress);
function HUAGBHPUNH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HUAGBHPUNH',HUAGBHPUNH_wrap_OnKeyDown);
function HUDOCMLKKT_wrap_Valid(event) {
return HUDOCMLKKT_Valid(event);
}
SPBOUILib.SetInputExit('HUDOCMLKKT',HUDOCMLKKT_wrap_Valid);
function HUDOCMLKKT_wrap_OnFocus(event) {
return HUDOCMLKKT_OnFocus(event);
}
SPBOUILib.SetInputEnter('HUDOCMLKKT',HUDOCMLKKT_wrap_OnFocus);
function HUDOCMLKKT_wrap_OnKeyPress(event) {
return HUDOCMLKKT_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('HUDOCMLKKT',HUDOCMLKKT_wrap_OnKeyPress);
function HUDOCMLKKT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HUDOCMLKKT',HUDOCMLKKT_wrap_OnKeyDown);
function SFKJNKYLJO_wrap_Valid(event) {
return SFKJNKYLJO_Valid(event);
}
SPBOUILib.SetRadioClick('SFKJNKYLJO',SFKJNKYLJO_wrap_Valid);
function EOSKLIUGBC_wrap_Valid(event) {
return EOSKLIUGBC_Valid(event);
}
SPBOUILib.SetComboChange('EOSKLIUGBC',EOSKLIUGBC_wrap_Valid);
function EOSKLIUGBC_wrap_OnFocus(event) {
return EOSKLIUGBC_OnFocus(event);
}
SPBOUILib.SetInputEnter('EOSKLIUGBC',EOSKLIUGBC_wrap_OnFocus);
function EOSKLIUGBC_wrap_Blur(event) {
return EOSKLIUGBC_OnBlur(event);
}
SPBOUILib.SetInputExit('EOSKLIUGBC',EOSKLIUGBC_wrap_Blur);
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
function OJJHIUDPFY_wrap_Valid(event) {
return OJJHIUDPFY_Valid(event);
}
SPBOUILib.SetInputExit('OJJHIUDPFY',OJJHIUDPFY_wrap_Valid);
function OJJHIUDPFY_wrap_OnFocus(event) {
return OJJHIUDPFY_OnFocus(event);
}
SPBOUILib.SetInputEnter('OJJHIUDPFY',OJJHIUDPFY_wrap_OnFocus);
function OJJHIUDPFY_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('OJJHIUDPFY',OJJHIUDPFY_wrap_OnKeyPress);
function OJJHIUDPFY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OJJHIUDPFY',OJJHIUDPFY_wrap_OnKeyDown);
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
function NEUBQNUEOJ_ZOOM_setHandlers() {
function NEUBQNUEOJ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?NEUBQNUEOJ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('NEUBQNUEOJ_ZOOM',NEUBQNUEOJ_ZOOM_wrap_OnClick);
function NEUBQNUEOJ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('NEUBQNUEOJ_ZOOM',NEUBQNUEOJ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('NEUBQNUEOJ',NEUBQNUEOJ_ZOOM_setHandlers);
SPBOUILib.SetInputKeyUp('NEUBQNUEOJ',function(event) {
  return (Eq(m_cFunction,'edit') || Eq(m_cFunction,'new')?NEUBQNUEOJ_OnKeyUp(event):void(0));
});
function KPSCOABZLB_wrap_Valid(event) {
return KPSCOABZLB_Valid(event);
}
SPBOUILib.SetInputExit('KPSCOABZLB',KPSCOABZLB_wrap_Valid);
function KPSCOABZLB_wrap_OnFocus(event) {
return KPSCOABZLB_OnFocus(event);
}
SPBOUILib.SetInputEnter('KPSCOABZLB',KPSCOABZLB_wrap_OnFocus);
function KPSCOABZLB_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('KPSCOABZLB',KPSCOABZLB_wrap_OnKeyPress);
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
SPBOUILib.SetInputKeyUp('YVIKEGPYPM',function(event) {
  return (Eq(m_cFunction,'edit') || Eq(m_cFunction,'new')?YVIKEGPYPM_OnKeyUp(event):void(0));
});
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
function VYLHWTRQNX_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('VYLHWTRQNX',VYLHWTRQNX_wrap_OnKeyPress);
function VYLHWTRQNX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VYLHWTRQNX',VYLHWTRQNX_wrap_OnKeyDown);
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
function HVEEMUJUUY_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('HVEEMUJUUY',HVEEMUJUUY_wrap_OnKeyPress);
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
function HRNCPADUFU_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('HRNCPADUFU',HRNCPADUFU_wrap_OnKeyPress);
function HRNCPADUFU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HRNCPADUFU',HRNCPADUFU_wrap_OnKeyDown);
function XFUOZLSACP_wrap_Valid(event) {
return XFUOZLSACP_Valid(event);
}
SPBOUILib.SetInputExit('XFUOZLSACP',XFUOZLSACP_wrap_Valid);
function XFUOZLSACP_wrap_OnFocus(event) {
return XFUOZLSACP_OnFocus(event);
}
SPBOUILib.SetInputEnter('XFUOZLSACP',XFUOZLSACP_wrap_OnFocus);
function XFUOZLSACP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XFUOZLSACP',XFUOZLSACP_wrap_OnKeyDown);
function BSSRUASCBR_wrap_Valid(event) {
return BSSRUASCBR_Valid(event);
}
SPBOUILib.SetInputExit('BSSRUASCBR',BSSRUASCBR_wrap_Valid);
function BSSRUASCBR_wrap_OnFocus(event) {
return BSSRUASCBR_OnFocus(event);
}
SPBOUILib.SetInputEnter('BSSRUASCBR',BSSRUASCBR_wrap_OnFocus);
function KZWBLPQNHU_wrap_Valid(event) {
return KZWBLPQNHU_Valid(event);
}
SPBOUILib.SetInputExit('KZWBLPQNHU',KZWBLPQNHU_wrap_Valid);
function KZWBLPQNHU_wrap_OnFocus(event) {
return KZWBLPQNHU_OnFocus(event);
}
SPBOUILib.SetInputEnter('KZWBLPQNHU',KZWBLPQNHU_wrap_OnFocus);
function KZWBLPQNHU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KZWBLPQNHU',KZWBLPQNHU_wrap_OnKeyDown);
function UTUCDPQJKK_wrap_Valid(event) {
return UTUCDPQJKK_Valid(event);
}
SPBOUILib.SetInputExit('UTUCDPQJKK',UTUCDPQJKK_wrap_Valid);
function UTUCDPQJKK_wrap_OnFocus(event) {
return UTUCDPQJKK_OnFocus(event);
}
SPBOUILib.SetInputEnter('UTUCDPQJKK',UTUCDPQJKK_wrap_OnFocus);
function UTUCDPQJKK_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('UTUCDPQJKK',UTUCDPQJKK_wrap_OnKeyPress);
function UTUCDPQJKK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UTUCDPQJKK',UTUCDPQJKK_wrap_OnKeyDown);
function FKEAKFSYVU_wrap_Valid(event) {
return FKEAKFSYVU_Valid(event);
}
SPBOUILib.SetInputExit('FKEAKFSYVU',FKEAKFSYVU_wrap_Valid);
function FKEAKFSYVU_wrap_OnFocus(event) {
return FKEAKFSYVU_OnFocus(event);
}
SPBOUILib.SetInputEnter('FKEAKFSYVU',FKEAKFSYVU_wrap_OnFocus);
function FKEAKFSYVU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FKEAKFSYVU',FKEAKFSYVU_wrap_OnKeyDown);
function OXFYJQLTDL_wrap_Valid(event) {
return OXFYJQLTDL_Valid(event);
}
SPBOUILib.SetInputExit('OXFYJQLTDL',OXFYJQLTDL_wrap_Valid);
function OXFYJQLTDL_wrap_OnFocus(event) {
return OXFYJQLTDL_OnFocus(event);
}
SPBOUILib.SetInputEnter('OXFYJQLTDL',OXFYJQLTDL_wrap_OnFocus);
function OXFYJQLTDL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OXFYJQLTDL',OXFYJQLTDL_wrap_OnKeyDown);
function KSZEHVQAGY_wrap_Valid(event) {
return KSZEHVQAGY_Valid(event);
}
SPBOUILib.SetInputExit('KSZEHVQAGY',KSZEHVQAGY_wrap_Valid);
function KSZEHVQAGY_wrap_OnFocus(event) {
return KSZEHVQAGY_OnFocus(event);
}
SPBOUILib.SetInputEnter('KSZEHVQAGY',KSZEHVQAGY_wrap_OnFocus);
function KSZEHVQAGY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KSZEHVQAGY',KSZEHVQAGY_wrap_OnKeyDown);
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
if (Ne(typeof(w_PrtDocAll),'undefined')) {
w_PrtDocAll.raiseEvent('armt_cgo_oper_storico_'+Strtran(p_cEvent,' ','_'));
}
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
FocusFirstComponent.edit={"page_1":["YLIKFVPZJA"]};
FocusFirstComponent.query={"page_1":["YLIKFVPZJA"]};
FocusFirstComponent.otherwise={"page_1":["YLIKFVPZJA"]};
function Help() {
windowOpenForeground('../doc/armt_cgo_oper_storico_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_ardt_cgo_oper_storico_multi() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_1')) {
if (ChildToLoad('AAHJPBZVGL')) {
if (Eq(lazy,null) || LibJavascript.UserCanSee('AAHJPBZVGL')) {
LoadContext.lc(1,'AAHJPBZVGL');
}
} else {
LibJavascript.RefreshChildGrid('AAHJPBZVGL');
}
}
}
GetLayerID.Layers.push({"id":"YORQOIOBQN","name":"Operazione"});
GetLayerID.Layers.push({"id":"AQSQVBKXAL","name":"Soggetto"});
function DeclareWVs() {
var a = arguments;
w_CGOTIPOPE=a[0];
w_CAIDBIGLIETTO=a[1];
w_DATAOPE=a[2];
w_FLAGCONT=a[3];
w_CACODICE=a[4];
w_CAFLGOPE=a[5];
w_TOTLIRE=a[6];
w_TOTCONT=a[7];
w_CGOFLGVLT=a[8];
w_CGOFLGVNP=a[9];
w_MEZPAGAM=a[10];
w_CFESTERO=a[11];
w_CODFISC=a[12];
w_COGNOME=a[13];
w_NOME=a[14];
w_NASCOMUN=a[15];
w_TIPINTER=a[16];
w_SESSO=a[17];
w_NASSTATO=a[18];
w_DATANASC=a[19];
w_PAESE=a[20];
w_DESCCIT=a[21];
w_PROVINCIA=a[22];
w_CAP=a[23];
w_DOMICILIO=a[24];
w_TIPODOC=a[25];
w_NUMDOCUM=a[26];
w_DATARILASC=a[27];
w_DATAVALI=a[28];
w_AUTRILASC=a[29];
w_ATTIV=a[30];
w_TIPOPERS=a[31];
w_RAGSOC=a[32];
w_SOTGRUP=a[33];
w_RAMOGRUP=a[34];
w_SETTSINT=a[35];
w_SNAINUMOPE=a[36];
op_SNAINUMOPE=a[37];
w_DATAREG=a[38];
w_TIPOOPRAP=a[39];
w_CODANA=a[40];
w_CODVOC=a[41];
w_VALUTA=a[42];
w_CAMBIO=a[43];
w_CONNESCLI=a[44];
w_CONNESBEN=a[45];
w_C_RAG=a[46];
w_C_CTA=a[47];
w_C_PRV=a[48];
w_C_CAP=a[49];
w_C_CAB=a[50];
w_C_IND=a[51];
w_C_STA=a[52];
w_CODINTER=a[53];
w_CODDIPE=a[54];
w_DESCCITDIP=a[55];
w_SEGNO=a[56];
w_FLAGFRAZ=a[57];
w_COLLEG=a[58];
w_PROVINCIADIP=a[59];
w_CODCABDIP=a[60];
w_CODCAB=a[61];
w_PEP=a[62];
w_VLTPLAT=a[63];
w_TIPOGIOCO=a[64];
w_ASSEGNO=a[65];
w_IBAN=a[66];
w_CC4CIFRE=a[67];
w_CCDATSCA=a[68];
w_NUMTEL=a[69];
w_IDDOCALL=a[70];
w_FLGDOCALL=a[71];
w_xSOGTPGIO=a[72];
w_xDEFTPGIO=a[73];
w_xEDTTPGIO=a[74];
w_dessta=a[75];
w_tipsot=a[76];
w_STATOREG=a[77];
w_IDBASE=a[78];
w_NUMPROG=a[79];
w_DESCRI=a[80];
w_gSeekAos=a[81];
w_gDataVaria=a[82];
w_gFlgDoc=a[83];
w_gIntemediario=a[84];
w_xDescDipe=a[85];
w_datpaseuro=a[86];
w_xdes1=a[87];
w_desccauana=a[88];
w_CITINT=a[89];
w_CITDIP=a[90];
w_PROVDIP=a[91];
w_CABDIP=a[92];
w_PROVINT=a[93];
w_CABINT=a[94];
w_xdesccausin=a[95];
w_gChkDate=a[96];
w_idcitta=a[97];
w_xdesctipatt=a[98];
w_gVLT=a[99];
w_gVNP=a[100];
w_gCodDip=a[101];
w_gStpDwn=a[102];
w_MIDBIGLIETTO=a[103];
w_xFLGPLGIO=a[104];
w_xDEFSPGIO=a[105];
w_xEDTSPGIO=a[106];
w_gGesDoc=a[107];
op_codazi=a[108];
m_cWv_ardt_cgo_oper_storico_multi=a[109];
if (Gt(a.length,110)) {
m_cErrorInChild='';
}
if (Gt(a.length,110)) {
o_CGOTIPOPE=w_CGOTIPOPE;
o_DATAOPE=w_DATAOPE;
o_CACODICE=w_CACODICE;
o_COGNOME=w_COGNOME;
o_NOME=w_NOME;
o_NASCOMUN=w_NASCOMUN;
o_TIPINTER=w_TIPINTER;
o_NASSTATO=w_NASSTATO;
o_PAESE=w_PAESE;
o_DATARILASC=w_DATARILASC;
o_DATAVALI=w_DATAVALI;
o_ATTIV=w_ATTIV;
o_SOTGRUP=w_SOTGRUP;
o_TIPOOPRAP=w_TIPOOPRAP;
o_CODANA=w_CODANA;
o_CODVOC=w_CODVOC;
o_CONNESBEN=w_CONNESBEN;
o_C_CTA=w_C_CTA;
o_CODINTER=w_CODINTER;
o_CODDIPE=w_CODDIPE;
o_COLLEG=w_COLLEG;
o_idcitta=w_idcitta;
o_VLTPLAT=w_VLTPLAT;
o_TIPOGIOCO=w_TIPOGIOCO;
}
m_PrimaryKeys=['SNAINUMOPE'];
}
function i_PrimaryKey() {
return 'cgo_operazioni_dl_multi'+'\\'+CPLib.ToCPStr(w_SNAINUMOPE);
}
GetLinkPCKeys.set_o('ardt_cgo_oper_storico_multi',false);
GetLinkPCKeys.o['ardt_cgo_oper_storico_multi']['SNAINUMOPE']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_SNAINUMOPE,'C');
}
}
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('AAHJPBZVGL',function(){return FrameRef('ardt_cgo_oper_storico_multi')},1,'ardt_cgo_oper_storico_multi',1,1)
GetSelectedChildPage.child={'ardt_cgo_oper_storico_multi': function(){return FrameRef('ardt_cgo_oper_storico_multi')}}
function GetSelectedPage(p_d) {
p_d.setValue('armt_cgo_oper_storico',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_NASCOMUN,'C'); },"field":"CITTA","type":"C"},{"expression":function() { return WtA(w_TIPINTER,'C'); },"field":"PROV","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcitta','C'),"uid":"NEUBQNUEOJ"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_NASSTATO,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"HODZKKOSYW"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_PAESE,'C'); },"field":"CODSTA","type":"C"},{"expression":function() { return WtA(w_dessta,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"YVIKEGPYPM"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_DESCCIT,'C'); },"field":"CITTA","type":"C"},{"expression":function() { return WtA(w_idcitta,'C'); },"field":"IDBASE","type":"C"}],"keyValues":[{"expression":function() { return WtA(w_PAESE,'C'); },"field":"PKTBSTATI","type":"C"}],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcitta','C'),"uid":"ODAYKSRECA"});
}
_Obli('CC4CIFRE',0,'FKEAKFSYVU',true,"11642408994",null,null,function() { return Eq(w_MEZPAGAM,'V') })
_Obli('IBAN',0,'UTUCDPQJKK',true,"737507602",null,"11525797640",function() { return Eq(w_MEZPAGAM,'I') || Eq(w_MEZPAGAM,'E') || Eq(w_MEZPAGAM,'P') })
_Obli('SNAINUMOPE',0,'XFUOZLSACP',false,"11993248424")
_Obli('TIPODOC',0,'MBGANUUHRA',true,"11429032151",'MBGANUUHRA')
_Obli('NUMDOCUM',0,'HVEEMUJUUY',true,"1734932797")
_Obli('DATAOPE',2,'YLIKFVPZJA',false,"829201110")
_Obli('FLAGCONT',0,'PURPSXEVAI',true,"237632211")
_Obli('CACODICE',1,'WJQFIEBCQV',false,"1814604627")
_Obli('DATAVALI',2,'BNWXBPSIDG',true,"1216938285")
_Obli('TOTLIRE',1,'HUAGBHPUNH',true,"1825772649",null,"11419822357")
_Obli('TOTCONT',1,'HUDOCMLKKT',true,"10943726013",null,null,function() { return Eq(w_FLAGCONT,'1') })
_Obli('CGOFLGVLT',0,'SFKJNKYLJO',true,"11256417841")
_Obli('AUTRILASC',0,'HRNCPADUFU',true,"10032163180")
_Obli('MEZPAGAM',0,'EOSKLIUGBC',true,"10651434988")
_Obli('CFESTERO',1,'CZTHKEDVCO',false,"10034405761")
_Obli('CODFISC',0,'OJJHIUDPFY',true,"11921223220",null,"1715238713",function() { return Eq(w_CFESTERO,0) })
_Obli('COGNOME',0,'TWTTDWKCRG',true,"1816546867")
_Obli('NOME',0,'WWGIVGNUDW',true,"443454")
_Obli('NASCOMUN',0,'NEUBQNUEOJ',true,"12123334500",'NEUBQNUEOJ',null,function() { return Empty(w_NASSTATO) })
_Obli('TIPINTER',0,'KPSCOABZLB',true,"3528304")
_Obli('SESSO',0,'QPALJZMFCL',true,"7776675")
_Obli('NASSTATO',0,'HODZKKOSYW',true,"12123284333",'HODZKKOSYW',null,function() { return Empty(w_NASCOMUN) })
_Obli('DATANASC',2,'XMGRWGFSFV',true,"11777527481")
_Obli('PAESE',0,'YVIKEGPYPM',true,"7776403",'YVIKEGPYPM')
_Obli('DESCCIT',0,'ODAYKSRECA',true,"15186643",'ODAYKSRECA',null,function() { return Eq(w_PAESE,'086') })
_Obli('PROVINCIA',0,'NOTZPDMYIA',true,"10095365423",null,null,function() { return Eq(w_PAESE,'086') })
_Obli('CAP',0,'RDAVOEETJG',true,"21587",null,null,function() { return Eq(w_PAESE,'086') })
_Obli('DOMICILIO',0,'VYLHWTRQNX',true,"554236824",null,null,function() { return Eq(w_PAESE,'086') })
_Obli('NUMTEL',0,'KSZEHVQAGY',false,"10574713661")
_Obli('CCDATSCA',0,'OXFYJQLTDL',true,"11857312893",null,null,function() { return Eq(w_MEZPAGAM,'V') })
_Obli('DATARILASC',2,'XHWYGOPPUN',true,"1608394306")
_Obli('MIDBIGLIETTO',0,'BSSRUASCBR',false)
_Obli('ASSEGNO',0,'KZWBLPQNHU',true,"1984809585",null,null,function() { return Eq(w_MEZPAGAM,'C') || Eq(w_MEZPAGAM,'B') })
