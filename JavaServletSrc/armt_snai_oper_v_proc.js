function FillCombosValues() {
FillCombo('QZTTRBWAQL','QZTTRBWAQL');
FillCombo('SAQTIHOALW','SAQTIHOALW');
FillCombo('WJQFIEBCQV','WJQFIEBCQV');
FillCombo('LVYFMQXNZH','LVYFMQXNZH');
FillCombo('MBGANUUHRA','MBGANUUHRA');
FillCombo('YDUQCBNYFV','YDUQCBNYFV');
FillCombo('UHSDZYTDDZ','UHSDZYTDDZ');
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('GXLWKNXGMM',function(){return WtH(w_gIntemediario,'C',11,0,'')},w_gIntemediario);
if(c=Ctrl('QZTTRBWAQL')) selectCombo(c,w_TIPOGIOCO,'C')
SPBOUILib.SetInputValue('HUAGBHPUNH',function(){return WtH(w_TOTLIRE,'N',15,2,'999,999,999,999.99')},w_TOTLIRE);
if(c=Ctrl('SFKJNKYLJO')) selectRadio(c,w_CGOFLGVLT,'C')
if(c=Ctrl('EOSKLIUGBC')) selectCombo(c,w_MEZPAGAM,'C')
SPBOUILib.SetInputValue('KZWBLPQNHU',function(){return WtH(w_ASSEGNO,'C',25,0,'')},w_ASSEGNO);
SPBOUILib.SetInputValue('UTUCDPQJKK',function(){return WtH(w_IBAN,'C',27,0,'!')},w_IBAN);
SPBOUILib.SetInputValue('FKEAKFSYVU',function(){return WtH(w_CC4CIFRE,'C',4,0,'')},w_CC4CIFRE);
SPBOUILib.SetInputValue('OXFYJQLTDL',function(){return WtH(w_CCDATSCA,'C',7,0,'')},w_CCDATSCA);
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
SPBOUILib.SetInputValue('VFKGHJLVGB',function(){return WtH(w_NUMTEL,'C',20,0,'')},w_NUMTEL);
var tmp_ESVLUSNYWB = ToHTag(AsControlValue(w_dessta));
if (Ne(e_ESVLUSNYWB,tmp_ESVLUSNYWB)) {
SPBOUILib.SetLabelValue('ESVLUSNYWB','innerHTML',tmp_ESVLUSNYWB);
e_ESVLUSNYWB=tmp_ESVLUSNYWB;
}
SPBOUILib.SetInputValue('XFUOZLSACP',function(){return WtH(w_SNAINUMOPE,'C',15,0,'')},w_SNAINUMOPE);
SPBOUILib.SetInputValue('YLIKFVPZJA',function(){return WtH(w_DATAOPE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAOPE);
SPBOUILib.SetInputValue('OEIKQOZMYJ',function(){return WtH(w_DATAREG,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAREG);
if(c=Ctrl('PURPSXEVAI')) selectCombo(c,w_FLAGCONT,'C')
SPBOUILib.SetInputValue('UJRFWINIVQ',function(){return WtH(w_TIPOOPRAP,'C',2,0,'')},w_TIPOOPRAP);
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
SPBOUILib.SetInputValue('HUDOCMLKKT',function(){return WtH(w_TOTCONT,'N',15,2,'999,999,999,999.99')},w_TOTCONT);
if(c=Ctrl('WJQFIEBCQV')) selectCombo(c,w_CACODICE,'N')
SPBOUILib.SetInputValue('BMTLGIUQTH',function(){return WtH(w_CAIDBIGLIETTO,'C',30,0,'')},w_CAIDBIGLIETTO);
SPBOUILib.SetInputValue('PUBAAWPVMH',function(){return WtH(w_verifica,'C',1,0,'')},w_verifica);
SPBOUILib.SetInputValue('HILLZZMRNQ',function(){return WtH(w_NUMOPEDL,'C',15,0,'')},w_NUMOPEDL);
if(c=Ctrl('YJDISDDJUY')) selectCombo(c,w_CAFLGOPE,'C')
SPBOUILib.SetInputValue('ZUVVNOUSIQ',function(){return WtH(w_FLGDOCALL,'C',1,0,'')},w_FLGDOCALL);
if(c=Ctrl('LVYFMQXNZH')) selectCombo(c,w_VLTPLAT,'C')
SPBOUILib.SetInputValue('PAADFVDPUD',function(){return WtH(w_DOC03,'C',80,0,'')},w_DOC03);
SPBOUILib.SetInputValue('SIRTAMVPQN',function(){return WtH(w_DOC04,'C',80,0,'')},w_DOC04);
SPBOUILib.SetInputValue('OZGWRQKOZF',function(){return WtH(w_tipop,'C',1,0,'')},w_tipop);
if(c=Ctrl('VXAWEXADJV')) ChkboxCheckUncheck(c,'S',w_PEP)
if(c=Ctrl('VXAWEXADJV')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('MBGANUUHRA')) selectCombo(c,w_TIPODOC,'C')
SPBOUILib.SetInputValue('HVEEMUJUUY',function(){return WtH(w_NUMDOCUM,'C',15,0,'!')},w_NUMDOCUM);
SPBOUILib.SetInputValue('XHWYGOPPUN',function(){return WtH(w_DATARILASC,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATARILASC);
SPBOUILib.SetInputValue('BNWXBPSIDG',function(){return WtH(w_DATAVALI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAVALI);
if(c=Ctrl('YDUQCBNYFV')) selectCombo(c,w_RDCODAUT,'C')
SPBOUILib.SetInputValue('MPRHMTBSXX',function(){return WtH(w_RDLOCAUT,'C',20,0,'')},w_RDLOCAUT);
SPBOUILib.SetInputValue('TXKHUBKEOP',function(){return WtH(w_AUTRILASC,'C',30,0,'!')},w_AUTRILASC);
SPBOUILib.SetInputValue('DAEHHCRYAM',function(){return WtH(w_PEPDESCRI,'C',80,0,'')},w_PEPDESCRI);
SPBOUILib.SetInputValue('UOOQYQWWNG',function(){return WtH(w_PAESE2,'C',3,0,'')},w_PAESE2);
SPBOUILib.SetInputValue('BVEIQEJCLQ',function(){return WtH(w_DESCCIT2,'C',40,0,'!')},w_DESCCIT2);
SPBOUILib.SetInputValue('NKJDWBKDWM',function(){return WtH(w_PROVINCIA2,'C',2,0,'')},w_PROVINCIA2);
SPBOUILib.SetInputValue('MDTHUZMSSI',function(){return WtH(w_CAP2,'C',9,0,'')},w_CAP2);
SPBOUILib.SetInputValue('CWOLOHZAQW',function(){return WtH(w_DOMICILIO2,'C',35,0,'!')},w_DOMICILIO2);
var tmp_XAZPZOWUXV = ToHTag(AsControlValue(w_dessta2));
if (Ne(e_XAZPZOWUXV,tmp_XAZPZOWUXV)) {
SPBOUILib.SetLabelValue('XAZPZOWUXV','innerHTML',tmp_XAZPZOWUXV);
e_XAZPZOWUXV=tmp_XAZPZOWUXV;
}
if(c=Ctrl('ZJPDUNZSZL')) ChkboxCheckUncheck(c,'S',w_FLGDOM)
if(c=Ctrl('ZJPDUNZSZL')) ChkboxValueAssign(c,'S','N','C',1,0,'')
var tmp_WSBYTYXZUJ = ToHTag(AsControlValue('Intermediario: '+w_gIntemediario));
if (Ne(e_WSBYTYXZUJ,tmp_WSBYTYXZUJ)) {
SPBOUILib.SetLabelValue('WSBYTYXZUJ','innerHTML',tmp_WSBYTYXZUJ);
e_WSBYTYXZUJ=tmp_WSBYTYXZUJ;
}
var tmp_RYPMYFNJCH = ToHTag(AsControlValue('Telefono: '+w_TELDIP));
if (Ne(e_RYPMYFNJCH,tmp_RYPMYFNJCH)) {
SPBOUILib.SetLabelValue('RYPMYFNJCH','innerHTML',tmp_RYPMYFNJCH);
e_RYPMYFNJCH=tmp_RYPMYFNJCH;
}
var tmp_SYSCVQLGYQ = ToHTag(AsControlValue('Pr.: '+w_PROVDIP));
if (Ne(e_SYSCVQLGYQ,tmp_SYSCVQLGYQ)) {
SPBOUILib.SetLabelValue('SYSCVQLGYQ','innerHTML',tmp_SYSCVQLGYQ);
e_SYSCVQLGYQ=tmp_SYSCVQLGYQ;
}
var tmp_NDRSVVFNFN = ToHTag(AsControlValue('CAB: '+w_CABDIP));
if (Ne(e_NDRSVVFNFN,tmp_NDRSVVFNFN)) {
SPBOUILib.SetLabelValue('NDRSVVFNFN','innerHTML',tmp_NDRSVVFNFN);
e_NDRSVVFNFN=tmp_NDRSVVFNFN;
}
var tmp_PTPHBBPAMU = ToHTag(AsControlValue(LRTrim(w_CODDIPE)+' - '+w_xDescDipe));
if (Ne(e_PTPHBBPAMU,tmp_PTPHBBPAMU)) {
SPBOUILib.SetLabelValue('PTPHBBPAMU','innerHTML',tmp_PTPHBBPAMU);
e_PTPHBBPAMU=tmp_PTPHBBPAMU;
}
var tmp_FXXYGMCKWS = ToHTag(AsControlValue('Citt\xe0: '+w_DESCCITDIP));
if (Ne(e_FXXYGMCKWS,tmp_FXXYGMCKWS)) {
SPBOUILib.SetLabelValue('FXXYGMCKWS','innerHTML',tmp_FXXYGMCKWS);
e_FXXYGMCKWS=tmp_FXXYGMCKWS;
}
SPBOUILib.SetInputValue('QGTPFXSEXX',function(){return WtH(w_CGODATCON,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_CGODATCON);
if(c=Ctrl('UHSDZYTDDZ')) selectCombo(c,w_CGOESICON,'C')
SPBOUILib.SetInputValue('MVSSLZXHUW',function(){return WtH(w_CGONOTCON,'M',10,0,'')},w_CGONOTCON);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
h=Eq(w_FLGDOCALL,'X') || (Empty(w_IDDOCALL) || Empty(w_TIPOGIOCO) || Le(w_TOTLIRE,0) || (Eq(w_FLAGCONT,'1') && Le(w_TOTCONT,0))) || IsHiddenByStateDriver(Z.Tabs.Get('tabs').GetTabstripID('page_2'));
SetDisplay(Z.Tabs.Get('tabs').GetTabstripID('page_2'),h);
if (h && (Z.Tabs.Get('tabs').IsExpanded('page_2'))) {
Z.Tabs.Get('tabs').Next() || Z.Tabs.Get('tabs').Prev();
}
h=Utilities.Make(window).IsInGroup(6) || IsHiddenByStateDriver(Z.Tabs.Get('tabs').GetTabstripID('page_3'));
SetDisplay(Z.Tabs.Get('tabs').GetTabstripID('page_3'),h);
if (h && (Z.Tabs.Get('tabs').IsExpanded('page_3'))) {
Z.Tabs.Get('tabs').Next() || Z.Tabs.Get('tabs').Prev();
}
SetDisplay('CCUOYXMBZC_DIV',IsHiddenByStateDriver('Base'));
SetDisplay('YORQOIOBQN_DIV',IsHiddenByStateDriver('Operazione'));
SetDisplay('AQSQVBKXAL_DIV',IsHiddenByStateDriver('Soggetto'));
SetDisplay(Ctrl('KZWBLPQNHU'),Ne(w_MEZPAGAM,'C') && Ne(w_MEZPAGAM,'B') || IsHiddenByStateDriver('ASSEGNO'));
SetDisplay(Ctrl('UTUCDPQJKK'),Ne(w_MEZPAGAM,'I') && Ne(w_MEZPAGAM,'E') && Ne(w_MEZPAGAM,'P') || IsHiddenByStateDriver('IBAN'));
SetDisplay(Ctrl('FKEAKFSYVU'),Ne(w_MEZPAGAM,'V') || IsHiddenByStateDriver('CC4CIFRE'));
SetDisplay(Ctrl('OXFYJQLTDL'),Ne(w_MEZPAGAM,'V') || IsHiddenByStateDriver('CCDATSCA'));
SetDisplay(Ctrl('KDUGHGZUUG'),true);
SetDisplay(Ctrl('PUBAAWPVMH'),true || IsHiddenByStateDriver('verifica'));
SetDisplay(Ctrl('HILLZZMRNQ'),true || IsHiddenByStateDriver('NUMOPEDL'));
SetDisplay(Ctrl('PBHNLOUBML'),Ne(w_MEZPAGAM,'I') && Ne(w_MEZPAGAM,'E') && Ne(w_MEZPAGAM,'P'));
SetDisplay(Ctrl('BTZLLSBMCC'),Ne(w_MEZPAGAM,'C') && Ne(w_MEZPAGAM,'B'));
SetDisplay(Ctrl('CQTMIXIELC'),Ne(w_MEZPAGAM,'V'));
SetDisplay(Ctrl('HKREYYVVOP'),Ne(w_MEZPAGAM,'V'));
SetDisplay(Ctrl('ZUVVNOUSIQ'),true || IsHiddenByStateDriver('FLGDOCALL'));
SetDisplay(Ctrl('PAADFVDPUD'),true || IsHiddenByStateDriver('DOC03'));
SetDisplay(Ctrl('SIRTAMVPQN'),true || IsHiddenByStateDriver('DOC04'));
SetDisplay(Ctrl('OZGWRQKOZF'),true || IsHiddenByStateDriver('tipop'));
SetDisplay('XWJLXLYKJC_DIV',IsHiddenByStateDriver('box_XWJLXLYKJC'));
SetDisplay('NYSCBMMEEX_DIV',IsHiddenByStateDriver('box_NYSCBMMEEX'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["ASSEGNO"]=['BTZLLSBMCC'];
HideUI.lblids["AUTRILASC"]=['ZPQIEJPWJC'];
HideUI.lblids["CACODICE"]=['YFGRJCQGZV'];
HideUI.lblids["CAIDBIGLIETTO"]=['EZWFUWOKXC'];
HideUI.lblids["CAP"]=['GDOCAGKROT'];
HideUI.lblids["CAP2"]=['PXQUPKOPNQ'];
HideUI.lblids["CC4CIFRE"]=['CQTMIXIELC'];
HideUI.lblids["CCDATSCA"]=['HKREYYVVOP'];
HideUI.lblids["CGODATCON"]=['FQOWHKPMKJ'];
HideUI.lblids["CGOESICON"]=['QEBYVTHZSE'];
HideUI.lblids["CGOFLGVLT"]=['LKYFODKVBU'];
HideUI.lblids["CGONOTCON"]=['WNQEZXSVGA'];
HideUI.lblids["CGOTIPOPE"]=['JNQVUOSVPV','DJRHGZHJSR'];
HideUI.lblids["CODCABDIP"]=['ENBRMMDVUP'];
HideUI.lblids["CODDIPE"]=['XVRJYSKGWZ'];
HideUI.lblids["CODFISC"]=['WZDAFMDKJE'];
HideUI.lblids["COGNOME"]=['TVSLWOCERI'];
HideUI.lblids["DATANASC"]=['HZYTDOZFPI'];
HideUI.lblids["DATAOPE"]=['HVHVAYPDJE'];
HideUI.lblids["DATAREG"]=['IKBMEWKQJW'];
HideUI.lblids["DATARILASC"]=['QUXAELRWLA'];
HideUI.lblids["DATAVALI"]=['UYGHJPRVKH'];
HideUI.lblids["DESCCIT"]=['XPSQTBKQQZ'];
HideUI.lblids["DESCCIT2"]=['BRPGRCAORR'];
HideUI.lblids["DESCCITDIP"]=['CTLYJMTHDV'];
HideUI.lblids["DOMICILIO"]=['TWTXGZJTAR'];
HideUI.lblids["DOMICILIO2"]=['KBBIQTXMOO'];
HideUI.lblids["FLAGCONT"]=['GVTXMEILAZ'];
HideUI.lblids["IBAN"]=['PBHNLOUBML'];
HideUI.lblids["MEZPAGAM"]=['VQCVMXHDPB'];
HideUI.lblids["NASCOMUN"]=['WVJSUIKYEY'];
HideUI.lblids["NASSTATO"]=['ZBRDCBHLZC'];
HideUI.lblids["NOME"]=['KUPYKSUBXV'];
HideUI.lblids["NUMDOCUM"]=['YXFGMWZGNN'];
HideUI.lblids["NUMPROG"]=['KDUGHGZUUG'];
HideUI.lblids["NUMTEL"]=['ZZVYXPTPXC'];
HideUI.lblids["PAESE"]=['RZBLEGCFJJ'];
HideUI.lblids["PAESE2"]=['MCODDONEHP'];
HideUI.lblids["PEPDESCRI"]=['ELBFOCJOYH'];
HideUI.lblids["PROVINCIA"]=['SBJQIAQUCN'];
HideUI.lblids["PROVINCIA2"]=['INUGZKMMHN'];
HideUI.lblids["PROVINCIADIP"]=['JWSDOSRGAG'];
HideUI.lblids["RDCODAUT"]=['RAVMCVENOT'];
HideUI.lblids["RDLOCAUT"]=['LSLCBQSYUK'];
HideUI.lblids["SESSO"]=['KRSCDPQZTQ'];
HideUI.lblids["SNAINUMOPE"]=['GZVEXPFQCZ'];
HideUI.lblids["TIPINTER"]=['IVAWYVSUQI'];
HideUI.lblids["TIPODOC"]=['KCXIMANXKF'];
HideUI.lblids["TIPOOPRAP"]=['KMCNAWQHKV'];
HideUI.lblids["TOTCONT"]=['IDTBMNCIOX'];
HideUI.lblids["TOTLIRE"]=['XLNVLBYVQX'];
HideUI.lblids["gIntemediario"]=['LOEAMXUYLA'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
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
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('YLIKFVPZJA',w_DATAOPE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('YLIKFVPZJA');
SetActiveField(Ctrl('YLIKFVPZJA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YLIKFVPZJA'),e);
}
function PUBAAWPVMH_Valid(e) {
SetActiveField(Ctrl('PUBAAWPVMH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('verifica','C',w_verifica,HtW(Ctrl('PUBAAWPVMH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_verifica(HtW(Ctrl('PUBAAWPVMH').value,'C'),null,e);
return l_bSetResult;
}
}
function PUBAAWPVMH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PUBAAWPVMH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PUBAAWPVMH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PUBAAWPVMH'),e);
}
function HILLZZMRNQ_Valid(e) {
SetActiveField(Ctrl('HILLZZMRNQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NUMOPEDL','C',w_NUMOPEDL,HtW(Ctrl('HILLZZMRNQ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NUMOPEDL(HtW(Ctrl('HILLZZMRNQ').value,'C'),null,e);
return l_bSetResult;
}
}
function HILLZZMRNQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HILLZZMRNQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HILLZZMRNQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HILLZZMRNQ'),e);
}
function ZUVVNOUSIQ_Valid(e) {
SetActiveField(Ctrl('ZUVVNOUSIQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('FLGDOCALL','C',w_FLGDOCALL,HtW(Ctrl('ZUVVNOUSIQ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGDOCALL(HtW(Ctrl('ZUVVNOUSIQ').value,'C'),null,e);
return l_bSetResult;
}
}
function ZUVVNOUSIQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZUVVNOUSIQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZUVVNOUSIQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZUVVNOUSIQ'),e);
}
function PAADFVDPUD_Valid(e) {
SetActiveField(Ctrl('PAADFVDPUD'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DOC03','C',w_DOC03,HtW(Ctrl('PAADFVDPUD').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DOC03(HtW(Ctrl('PAADFVDPUD').value,'C'),null,e);
return l_bSetResult;
}
}
function PAADFVDPUD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PAADFVDPUD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PAADFVDPUD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PAADFVDPUD'),e);
}
function SIRTAMVPQN_Valid(e) {
SetActiveField(Ctrl('SIRTAMVPQN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DOC04','C',w_DOC04,HtW(Ctrl('SIRTAMVPQN').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DOC04(HtW(Ctrl('SIRTAMVPQN').value,'C'),null,e);
return l_bSetResult;
}
}
function SIRTAMVPQN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SIRTAMVPQN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SIRTAMVPQN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SIRTAMVPQN'),e);
}
function OZGWRQKOZF_Valid(e) {
SetActiveField(Ctrl('OZGWRQKOZF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('tipop','C',w_tipop,HtW(Ctrl('OZGWRQKOZF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_tipop(HtW(Ctrl('OZGWRQKOZF').value,'C'),null,e);
return l_bSetResult;
}
}
function OZGWRQKOZF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OZGWRQKOZF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OZGWRQKOZF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OZGWRQKOZF'),e);
}
function UOOQYQWWNG_OnKeyUp(e) {
var evt = (window.event?window.event:e);
var newValue = HtW(Ctrl('UOOQYQWWNG').value,'C');
if (Eq(newValue,UOOQYQWWNG_OnKeyUp.oldValue)) {
return;
}
UOOQYQWWNG_OnKeyUp.oldValue=newValue;
if ( ! (GetDisabled(Ctrl('UOOQYQWWNG')) || IsMobile())) {
if (Gt(newValue.length,0)) {
SuggesterLib.callSuggest(Sugg_UOOQYQWWNG,2);
} else {
SuggesterLib.resetSuggest('UOOQYQWWNG','UOOQYQWWNG');
}
}
}
function UOOQYQWWNG_ValidSuggest(e) {
e=(window.event?window.event:e);
if (e) {
return SuggesterLib.select_suggest('UOOQYQWWNG','UOOQYQWWNG',-1,e);
}
}
function BVEIQEJCLQ_OnKeyUp(e) {
var evt = (window.event?window.event:e);
var newValue = HtW(Ctrl('BVEIQEJCLQ').value,'C');
if (Eq(newValue,BVEIQEJCLQ_OnKeyUp.oldValue)) {
return;
}
BVEIQEJCLQ_OnKeyUp.oldValue=newValue;
if ( ! (GetDisabled(Ctrl('BVEIQEJCLQ')) || IsMobile())) {
if (Gt(newValue.length,2)) {
SuggesterLib.callSuggest(Sugg_BVEIQEJCLQ,2);
} else {
SuggesterLib.resetSuggest('BVEIQEJCLQ','BVEIQEJCLQ');
}
}
}
function BVEIQEJCLQ_ValidSuggest(e) {
e=(window.event?window.event:e);
if (e) {
return SuggesterLib.select_suggest('BVEIQEJCLQ','BVEIQEJCLQ',-1,e);
}
}
function MVSSLZXHUW_Valid(e) {
SetActiveField(Ctrl('MVSSLZXHUW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CGONOTCON','M',w_CGONOTCON,HtW(Ctrl('MVSSLZXHUW').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CGONOTCON(HtW(Ctrl('MVSSLZXHUW').value,'M'),null,e);
return l_bSetResult;
}
}
function MVSSLZXHUW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MVSSLZXHUW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MVSSLZXHUW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MVSSLZXHUW'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
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
function PUBAAWPVMH_wrap_Valid(event) {
return PUBAAWPVMH_Valid(event);
}
SPBOUILib.SetInputExit('PUBAAWPVMH',PUBAAWPVMH_wrap_Valid);
function PUBAAWPVMH_wrap_OnFocus(event) {
return PUBAAWPVMH_OnFocus(event);
}
SPBOUILib.SetInputEnter('PUBAAWPVMH',PUBAAWPVMH_wrap_OnFocus);
function PUBAAWPVMH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PUBAAWPVMH',PUBAAWPVMH_wrap_OnKeyDown);
function HILLZZMRNQ_wrap_Valid(event) {
return HILLZZMRNQ_Valid(event);
}
SPBOUILib.SetInputExit('HILLZZMRNQ',HILLZZMRNQ_wrap_Valid);
function HILLZZMRNQ_wrap_OnFocus(event) {
return HILLZZMRNQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('HILLZZMRNQ',HILLZZMRNQ_wrap_OnFocus);
function HILLZZMRNQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HILLZZMRNQ',HILLZZMRNQ_wrap_OnKeyDown);
function ZUVVNOUSIQ_wrap_Valid(event) {
return ZUVVNOUSIQ_Valid(event);
}
SPBOUILib.SetInputExit('ZUVVNOUSIQ',ZUVVNOUSIQ_wrap_Valid);
function ZUVVNOUSIQ_wrap_OnFocus(event) {
return ZUVVNOUSIQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZUVVNOUSIQ',ZUVVNOUSIQ_wrap_OnFocus);
function ZUVVNOUSIQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZUVVNOUSIQ',ZUVVNOUSIQ_wrap_OnKeyDown);
function PAADFVDPUD_wrap_Valid(event) {
return PAADFVDPUD_Valid(event);
}
SPBOUILib.SetInputExit('PAADFVDPUD',PAADFVDPUD_wrap_Valid);
function PAADFVDPUD_wrap_OnFocus(event) {
return PAADFVDPUD_OnFocus(event);
}
SPBOUILib.SetInputEnter('PAADFVDPUD',PAADFVDPUD_wrap_OnFocus);
function PAADFVDPUD_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PAADFVDPUD',PAADFVDPUD_wrap_OnKeyDown);
function SIRTAMVPQN_wrap_Valid(event) {
return SIRTAMVPQN_Valid(event);
}
SPBOUILib.SetInputExit('SIRTAMVPQN',SIRTAMVPQN_wrap_Valid);
function SIRTAMVPQN_wrap_OnFocus(event) {
return SIRTAMVPQN_OnFocus(event);
}
SPBOUILib.SetInputEnter('SIRTAMVPQN',SIRTAMVPQN_wrap_OnFocus);
function SIRTAMVPQN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SIRTAMVPQN',SIRTAMVPQN_wrap_OnKeyDown);
function OZGWRQKOZF_wrap_Valid(event) {
return OZGWRQKOZF_Valid(event);
}
SPBOUILib.SetInputExit('OZGWRQKOZF',OZGWRQKOZF_wrap_Valid);
function OZGWRQKOZF_wrap_OnFocus(event) {
return OZGWRQKOZF_OnFocus(event);
}
SPBOUILib.SetInputEnter('OZGWRQKOZF',OZGWRQKOZF_wrap_OnFocus);
function OZGWRQKOZF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OZGWRQKOZF',OZGWRQKOZF_wrap_OnKeyDown);
function MVSSLZXHUW_wrap_Valid(event) {
return MVSSLZXHUW_Valid(event);
}
SPBOUILib.SetInputExit('MVSSLZXHUW',MVSSLZXHUW_wrap_Valid);
function MVSSLZXHUW_wrap_OnFocus(event) {
return MVSSLZXHUW_OnFocus(event);
}
SPBOUILib.SetInputEnter('MVSSLZXHUW',MVSSLZXHUW_wrap_OnFocus);
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
w_PrtDocAll.raiseEvent('armt_snai_oper_v_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.query={"page_1":["XFUOZLSACP","YLIKFVPZJA"],"page_3":["MVSSLZXHUW"]};
FocusFirstComponent.otherwise={"page_1":["YLIKFVPZJA"]};
function Help() {
windowOpenForeground('../doc/armt_snai_oper_v_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
GetLayerID.Layers.push({"id":"CCUOYXMBZC","name":"Base"});
GetLayerID.Layers.push({"id":"YORQOIOBQN","name":"Operazione"});
GetLayerID.Layers.push({"id":"AQSQVBKXAL","name":"Soggetto"});
function DeclareWVs() {
var a = arguments;
w_TIPOGIOCO=a[0];
w_TIPOPERS=a[1];
w_CGOFLGVNP=a[2];
w_TOTLIRE=a[3];
w_CGOFLGVLT=a[4];
w_MEZPAGAM=a[5];
w_ASSEGNO=a[6];
w_IBAN=a[7];
w_CC4CIFRE=a[8];
w_CCDATSCA=a[9];
w_CFESTERO=a[10];
w_CODFISC=a[11];
w_COGNOME=a[12];
w_NOME=a[13];
w_NASCOMUN=a[14];
w_TIPINTER=a[15];
w_SESSO=a[16];
w_NASSTATO=a[17];
w_DATANASC=a[18];
w_PAESE=a[19];
w_RAGSOC=a[20];
w_DESCCIT=a[21];
w_PROVINCIA=a[22];
w_CAP=a[23];
w_CODCAB=a[24];
w_DOMICILIO=a[25];
w_NUMTEL=a[26];
w_ATTIV=a[27];
w_SOTGRUP=a[28];
w_RAMOGRUP=a[29];
w_SETTSINT=a[30];
w_PEP=a[31];
w_SNAINUMOPE=a[32];
w_DATAOPE=a[33];
w_DATAREG=a[34];
w_FLAGCONT=a[35];
w_TIPOOPRAP=a[36];
w_CODANA=a[37];
w_CODVOC=a[38];
w_VALUTA=a[39];
w_CAMBIO=a[40];
w_CONNESCLI=a[41];
w_CONNESBEN=a[42];
w_C_RAG=a[43];
w_C_CTA=a[44];
w_C_PRV=a[45];
w_C_CAP=a[46];
w_C_CAB=a[47];
w_C_IND=a[48];
w_C_STA=a[49];
w_CODINTER=a[50];
w_CODDIPE=a[51];
w_DESCCITDIP=a[52];
w_SEGNO=a[53];
w_FLAGFRAZ=a[54];
w_COLLEG=a[55];
w_PROVINCIADIP=a[56];
w_CODCABDIP=a[57];
w_TOTCONT=a[58];
w_CACODICE=a[59];
w_CAIDBIGLIETTO=a[60];
w_CGOTIPOPE=a[61];
w_NUMOPEDL=a[62];
w_CAFLGOPE=a[63];
w_CGODATCON=a[64];
w_CGOESICON=a[65];
w_CGONOTCON=a[66];
w_IDDOCALL=a[67];
w_FLGDOCALL=a[68];
w_VLTPLAT=a[69];
w_TIPODOC=a[70];
w_NUMDOCUM=a[71];
w_DATARILASC=a[72];
w_DATAVALI=a[73];
w_RDCODAUT=a[74];
w_RDLOCAUT=a[75];
w_AUTRILASC=a[76];
w_PEPDESCRI=a[77];
w_PAESE2=a[78];
w_DESCCIT2=a[79];
w_PROVINCIA2=a[80];
w_CAP2=a[81];
w_DOMICILIO2=a[82];
w_FLGDOM=a[83];
w_gIntemediario=a[84];
w_xSOGTPGIO=a[85];
w_xDEFTPGIO=a[86];
w_xEDTTPGIO=a[87];
w_xEDTSPGIO=a[88];
w_xDEFSPGIO=a[89];
w_xARDESCRI=a[90];
w_dessta=a[91];
w_tipsot=a[92];
w_STATOREG=a[93];
w_IDBASE=a[94];
w_NUMPROG=a[95];
w_DESCRI=a[96];
w_gSeekAos=a[97];
w_gDataVaria=a[98];
w_gFlgDoc=a[99];
w_xDescDipe=a[100];
w_datpaseuro=a[101];
w_xdes1=a[102];
w_desccauana=a[103];
w_CITINT=a[104];
w_CITDIP=a[105];
w_PROVDIP=a[106];
w_CABDIP=a[107];
w_PROVINT=a[108];
w_CABINT=a[109];
w_xdesccausin=a[110];
w_gChkDate=a[111];
w_idcitta=a[112];
w_xdesctipatt=a[113];
w_gVLT=a[114];
w_gVNP=a[115];
w_gCodDip=a[116];
w_verifica=a[117];
w_gStpDwn=a[118];
w_MIDBIGLIETTO=a[119];
w_MIDBIGLIETTO1=a[120];
w_MIDBIGLIETTO2=a[121];
w_MIDBIGLIETTO3=a[122];
w_MIDBIGLIETTO4=a[123];
w_TELDIP=a[124];
w_CODLOC=a[125];
w_xFLGPLGIO=a[126];
w_xVPFLGATT=a[127];
w_DOC03=a[128];
w_DOC04=a[129];
w_tipop=a[130];
w_FLGSAVE=a[131];
w_dessta2=a[132];
if (Gt(a.length,133)) {
o_TIPOGIOCO=w_TIPOGIOCO;
o_NASCOMUN=w_NASCOMUN;
o_NASSTATO=w_NASSTATO;
o_PAESE=w_PAESE;
o_DESCCIT=w_DESCCIT;
o_ATTIV=w_ATTIV;
o_SOTGRUP=w_SOTGRUP;
o_DATAOPE=w_DATAOPE;
o_TIPOOPRAP=w_TIPOOPRAP;
o_CODANA=w_CODANA;
o_CODVOC=w_CODVOC;
o_CONNESBEN=w_CONNESBEN;
o_C_CTA=w_C_CTA;
o_CODDIPE=w_CODDIPE;
o_COLLEG=w_COLLEG;
o_idcitta=w_idcitta;;
o_CACODICE=w_CACODICE;
o_TIPODOC=w_TIPODOC;
o_RDCODAUT=w_RDCODAUT;
o_RDLOCAUT=w_RDLOCAUT;
o_PAESE2=w_PAESE2;
o_DESCCIT2=w_DESCCIT2;
}
m_PrimaryKeys=['SNAINUMOPE'];
}
function i_PrimaryKey() {
return 'cgo_operazioni'+'\\'+CPLib.ToCPStr(w_SNAINUMOPE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_snai_oper_v',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
}
_Obli('tipop',0,'OZGWRQKOZF',false)
_Obli('DOC04',0,'SIRTAMVPQN',false)
_Obli('DATAOPE',2,'YLIKFVPZJA',false,"829201110")
_Obli('NUMOPEDL',0,'HILLZZMRNQ',false,"11628234069")
_Obli('DOC03',0,'PAADFVDPUD',false)
_Obli('verifica',0,'PUBAAWPVMH',false)
_Obli('FLGDOCALL',0,'ZUVVNOUSIQ',false,"674110294")
_Obli('SNAINUMOPE',0,'XFUOZLSACP',false,"11993248424")
_Obli('CGONOTCON',0,'MVSSLZXHUW',false,"1405978050")
