function FillCombosValues() {
FillCombo('QZTTRBWAQL','QZTTRBWAQL');
FillCombo('LVYFMQXNZH','LVYFMQXNZH');
FillCombo('YJDISDDJUY','YJDISDDJUY');
FillCombo('EOSKLIUGBC','EOSKLIUGBC');
FillCombo('SAQTIHOALW','SAQTIHOALW');
FillCombo('MBGANUUHRA','MBGANUUHRA');
FillCombo('YDUQCBNYFV','YDUQCBNYFV');
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('GXLWKNXGMM',function(){return WtH(w_gIntemediario,'C',11,0,'')},w_gIntemediario);
if(c=Ctrl('QZTTRBWAQL')) selectCombo(c,w_TIPOGIOCO,'C')
if(c=Ctrl('LVYFMQXNZH')) selectCombo(c,w_VLTPLAT,'C')
SPBOUILib.SetInputValue('BMTLGIUQTH',function(){return WtH(w_CAIDBIGLIETTO,'C',30,0,'!')},w_CAIDBIGLIETTO);
SPBOUILib.SetInputValue('YLIKFVPZJA',function(){return WtH(w_DATAOPE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAOPE);
if(c=Ctrl('PURPSXEVAI')) selectCombo(c,w_FLAGCONT,'C')
if(c=Ctrl('DWJVPXTRND')) selectCombo(c,w_FLAGWALLET,'C')
if(c=Ctrl('YJDISDDJUY')) selectCombo(c,w_CAFLGOPE,'C')
SPBOUILib.SetInputValue('HUAGBHPUNH',function(){return WtH(w_TOTLIRE,'N',15,2,'999,999,999,999.99')},w_TOTLIRE);
SPBOUILib.SetInputValue('HUDOCMLKKT',function(){return WtH(w_TOTCONT,'N',15,2,'999,999,999,999.99')},w_TOTCONT);
SPBOUILib.SetInputValue('BELMGUMGMW',function(){return WtH(w_IMPWALLET,'N',12,2,'999,999,999,999.99')},w_IMPWALLET);
SPBOUILib.SetInputValue('TRGEEVWGRS',function(){return WtH(w_CODWALLET,'C',20,0,'')},w_CODWALLET);
SPBOUILib.SetInputValue('YYELCZIDWS',function(){return WtH(w_CODTRANSZ,'C',50,0,'')},w_CODTRANSZ);
SPBOUILib.SetInputValue('EKBMRGBOJG',function(){return WtH(w_FILTROMP,'C',50,0,'')},w_FILTROMP);
if(c=Ctrl('SFKJNKYLJO')) selectRadio(c,w_CGOFLGVLT,'C')
SPBOUILib.SetInputValue('GRJCRZXDIK',function(){return WtH(w_FLGPAGAM,'C',1,0,'')},w_FLGPAGAM);
if(c=Ctrl('EOSKLIUGBC')) selectCombo(c,w_MEZPAGAM,'C')
SPBOUILib.SetInputValue('FKEAKFSYVU',function(){return WtH(w_CC4CIFRE,'C',4,0,'')},w_CC4CIFRE);
if(c=Ctrl('MFCMVHMGSB')) selectCombo(c,w_CCMESSCA,'N')
SPBOUILib.SetInputValue('YZHCHEDWZM',function(){return WtH(w_CCANNSCA,'N',4,0,'')},w_CCANNSCA);
SPBOUILib.SetInputValue('KZWBLPQNHU',function(){return WtH(w_ASSEGNO,'C',25,0,'')},w_ASSEGNO);
SPBOUILib.SetInputValue('UTUCDPQJKK',function(){return WtH(w_IBAN,'C',40,0,'!')},w_IBAN);
if(c=Ctrl('CZTHKEDVCO')) ChkboxCheckUncheck(c,1,w_CFESTERO)
if(c=Ctrl('CZTHKEDVCO')) ChkboxValueAssign(c,1,0,'N',1,0,'')
if(c=Ctrl('XFKXBQYUIU')) ChkboxCheckUncheck(c,'S',w_PEP)
if(c=Ctrl('XFKXBQYUIU')) ChkboxValueAssign(c,'S','N','C',1,0,'')
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
SPBOUILib.SetInputValue('GRTAUFQUJZ',function(){return WtH(w_NUMTEL,'C',20,0,'')},w_NUMTEL);
SPBOUILib.SetInputValue('XFUOZLSACP',function(){return WtH(w_SNAINUMOPE,'C',15,0,'')},w_SNAINUMOPE);
SPBOUILib.SetInputValue('OEIKQOZMYJ',function(){return WtH(w_DATAREG,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAREG);
SPBOUILib.SetInputValue('UJRFWINIVQ',function(){return WtH(w_TIPOOPRAP,'C',2,0,'')},w_TIPOOPRAP);
SPBOUILib.SetInputValue('QBLXDBODXR',function(){return WtH(w_CONNESCLI,'C',16,0,'')},w_CONNESCLI);
if(c=Ctrl('QNNLSEAZHF')) selectCombo(c,w_SEGNO,'C')
var tmp_THOGQCLBJA = ToHTag(AsControlValue(w_xdes1));
if (Ne(e_THOGQCLBJA,tmp_THOGQCLBJA)) {
SPBOUILib.SetLabelValue('THOGQCLBJA','innerHTML',tmp_THOGQCLBJA);
e_THOGQCLBJA=tmp_THOGQCLBJA;
}
var tmp_ESVLUSNYWB = ToHTag(AsControlValue(w_dessta));
if (Ne(e_ESVLUSNYWB,tmp_ESVLUSNYWB)) {
SPBOUILib.SetLabelValue('ESVLUSNYWB','innerHTML',tmp_ESVLUSNYWB);
e_ESVLUSNYWB=tmp_ESVLUSNYWB;
}
SPBOUILib.SetInputValue('ZUVVNOUSIQ',function(){return WtH(w_FLGDOCALL,'C',1,0,'')},w_FLGDOCALL);
SPBOUILib.SetInputValue('PAADFVDPUD',function(){return WtH(w_DOC03,'C',80,0,'')},w_DOC03);
SPBOUILib.SetInputValue('SIRTAMVPQN',function(){return WtH(w_DOC04,'C',80,0,'')},w_DOC04);
SPBOUILib.SetInputValue('NVJDAQQRWF',function(){return WtH(w_saveddoc,'C',1,0,'')},w_saveddoc);
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
if(c=Ctrl('XMHFFKJFDF')) ChkboxCheckUncheck(c,'S',w_FLGQADVFULL)
if(c=Ctrl('XMHFFKJFDF')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('PAQVIKBAGR',function(){return WtH(w_PROFESSIONE,'C',40,0,'')},w_PROFESSIONE);
SPBOUILib.SetInputValue('AVHTGZTOSZ',function(){return WtH(w_CODDIPE,'C',6,0,'')},w_CODDIPE);
SPBOUILib.SetInputValue('RLUMBFHPUD',function(){return WtH(w_DESCCITDIP,'C',30,0,'')},w_DESCCITDIP);
var tmp_BLXOBUQVYE = ToHTag(AsControlValue(w_xDescDipe));
if (Ne(e_BLXOBUQVYE,tmp_BLXOBUQVYE)) {
SPBOUILib.SetLabelValue('BLXOBUQVYE','innerHTML',tmp_BLXOBUQVYE);
e_BLXOBUQVYE=tmp_BLXOBUQVYE;
}
SPBOUILib.SetInputValue('OJGQABFSYN',function(){return WtH(w_PROVINCIADIP,'C',2,0,'')},w_PROVINCIADIP);
SPBOUILib.SetInputValue('OZEOCQRSEQ',function(){return WtH(w_CODCABDIP,'C',6,0,'')},w_CODCABDIP);
SPBOUILib.SetInputValue('NWDPKKZGVO',function(){return WtH(w_ANA_FOUND,'C',1,0,'')},w_ANA_FOUND);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
h=Eq(w_FLGDOCALL,'X') || (Eq(w_gGesDoc,'S') && w_edtdoc) || Empty(w_IDDOCALL) || IsHiddenByStateDriver(Z.Tabs.Get('tabs').GetTabstripID('page_2'));
SetDisplay(Z.Tabs.Get('tabs').GetTabstripID('page_2'),h);
if (h && (Z.Tabs.Get('tabs').IsExpanded('page_2'))) {
Z.Tabs.Get('tabs').Next() || Z.Tabs.Get('tabs').Prev();
}
h=Ne(w_TIPOGIOCO,'V') || Eq(w_gQADV,'N') || IsHiddenByStateDriver(Z.Tabs.Get('tabs').GetTabstripID('page_3'));
SetDisplay(Z.Tabs.Get('tabs').GetTabstripID('page_3'),h);
if (h && (Z.Tabs.Get('tabs').IsExpanded('page_3'))) {
Z.Tabs.Get('tabs').Next() || Z.Tabs.Get('tabs').Prev();
}
SetDisplay('CCUOYXMBZC_DIV',IsHiddenByStateDriver('Base'));
SetDisplay('YORQOIOBQN_DIV',IsHiddenByStateDriver('Operazione'));
SetDisplay('AQSQVBKXAL_DIV',IsHiddenByStateDriver('Soggetto'));
SetDisplay(Ctrl('EKBMRGBOJG'),true || IsHiddenByStateDriver('FILTROMP'));
SetDisplay(Ctrl('GRJCRZXDIK'),true || IsHiddenByStateDriver('FLGPAGAM'));
SetDisplay(Ctrl('EOSKLIUGBC'),Eq(w_TOTLIRE-(w_TOTCONT+w_IMPWALLET),0) || IsHiddenByStateDriver('MEZPAGAM'));
SetDisplay(Ctrl('FKEAKFSYVU'),Ne(w_MEZPAGAM,'V') || IsHiddenByStateDriver('CC4CIFRE'));
SetDisplay(Ctrl('MFCMVHMGSB'),Ne(w_MEZPAGAM,'V') || IsHiddenByStateDriver('CCMESSCA'));
SetDisplay(Ctrl('YZHCHEDWZM'),Ne(w_MEZPAGAM,'V') || IsHiddenByStateDriver('CCANNSCA'));
SetDisplay(Ctrl('KZWBLPQNHU'),(Ne(w_MEZPAGAM,'C') && Ne(w_MEZPAGAM,'B')) || (Eq(w_CGOFLGVLT,'S')) || IsHiddenByStateDriver('ASSEGNO'));
SetDisplay(Ctrl('UTUCDPQJKK'),Ne(w_MEZPAGAM,'I') && Ne(w_MEZPAGAM,'E') && Ne(w_MEZPAGAM,'P') || IsHiddenByStateDriver('IBAN'));
SetDisplay(Ctrl('QBLXDBODXR'),true || IsHiddenByStateDriver('CONNESCLI'));
SetDisplay(Ctrl('KDUGHGZUUG'),true);
SetDisplay(Ctrl('VQCVMXHDPB'),Eq(w_TOTLIRE-(w_TOTCONT+w_IMPWALLET),0));
SetDisplay(Ctrl('DERAHXASAL'),Eq(w_CFESTERO,1));
SetDisplay(Ctrl('RQVPEKINIU'),Eq(w_CFESTERO,0));
SetDisplay(Ctrl('PBHNLOUBML'),Ne(w_MEZPAGAM,'I') && Ne(w_MEZPAGAM,'E') && Ne(w_MEZPAGAM,'P'));
SetDisplay(Ctrl('BTZLLSBMCC'),(Ne(w_MEZPAGAM,'C') && Ne(w_MEZPAGAM,'B')) || (Eq(w_CGOFLGVLT,'S')));
SetDisplay(Ctrl('CQTMIXIELC'),Ne(w_MEZPAGAM,'V'));
SetDisplay(Ctrl('HKREYYVVOP'),Ne(w_MEZPAGAM,'V'));
SetDisplay(Ctrl('ZUVVNOUSIQ'),true || IsHiddenByStateDriver('FLGDOCALL'));
SetDisplay(Ctrl('PAADFVDPUD'),true || IsHiddenByStateDriver('DOC03'));
SetDisplay(Ctrl('SIRTAMVPQN'),true || IsHiddenByStateDriver('DOC04'));
SetDisplay(Ctrl('NVJDAQQRWF'),true || IsHiddenByStateDriver('saveddoc'));
SetDisplay('XMHFFKJFDF_DIV',true);
SetDisplay(Ctrl('BYFMKHYARA'),Ne(w_gSeekAos,'S') || Utilities.Make(window).IsInGroup(9) || Empty(w_RAGSOC));
SetDisplay(Ctrl('PAQVIKBAGR'),Eq(w_xCGOFLGPROF,'N') || IsHiddenByStateDriver('PROFESSIONE'));
SetDisplay(Ctrl('VBCBZEOPVC'),Eq(w_xCGOFLGPROF,'N'));
SetDisplay(Ctrl('NWDPKKZGVO'),true || IsHiddenByStateDriver('ANA_FOUND'));
SetDisplay('XWJLXLYKJC_DIV',IsHiddenByStateDriver('Documenti'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["ASSEGNO"]=['BTZLLSBMCC'];
HideUI.lblids["AUTRILASC"]=['ZPQIEJPWJC'];
HideUI.lblids["CAIDBIGLIETTO"]=['EZWFUWOKXC'];
HideUI.lblids["CAP"]=['GDOCAGKROT'];
HideUI.lblids["CAP2"]=['PXQUPKOPNQ'];
HideUI.lblids["CC4CIFRE"]=['CQTMIXIELC'];
HideUI.lblids["CCDATSCA"]=['HKREYYVVOP'];
HideUI.lblids["CGOFLGVLT"]=['LKYFODKVBU'];
HideUI.lblids["CGOTIPOPE"]=['JNQVUOSVPV','DJRHGZHJSR'];
HideUI.lblids["CODCABDIP"]=['ENBRMMDVUP'];
HideUI.lblids["CODDIPE"]=['XVRJYSKGWZ'];
HideUI.lblids["CODFISC"]=['WZDAFMDKJE'];
HideUI.lblids["CODTRANSZ"]=['FYLQGYMZSV'];
HideUI.lblids["CODWALLET"]=['VIFLDDUUWV'];
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
HideUI.lblids["FLAGWALLET"]=['AYZLWZINKY'];
HideUI.lblids["IBAN"]=['PBHNLOUBML'];
HideUI.lblids["IMPWALLET"]=['DWKJKOCJCQ'];
HideUI.lblids["MEZPAGAM"]=['VQCVMXHDPB'];
HideUI.lblids["NASCOMUN"]=['WVJSUIKYEY'];
HideUI.lblids["NASSTATO"]=['ZBRDCBHLZC'];
HideUI.lblids["NOME"]=['KUPYKSUBXV'];
HideUI.lblids["NUMDOCUM"]=['YXFGMWZGNN'];
HideUI.lblids["NUMPROG"]=['KDUGHGZUUG'];
HideUI.lblids["NUMTEL"]=['WKTPZFFUJF'];
HideUI.lblids["PAESE"]=['RZBLEGCFJJ'];
HideUI.lblids["PAESE2"]=['MCODDONEHP'];
HideUI.lblids["PEPDESCRI"]=['ELBFOCJOYH'];
HideUI.lblids["PROFESSIONE"]=['VBCBZEOPVC'];
HideUI.lblids["PROVINCIA"]=['SBJQIAQUCN'];
HideUI.lblids["PROVINCIA2"]=['INUGZKMMHN'];
HideUI.lblids["PROVINCIADIP"]=['JWSDOSRGAG'];
HideUI.lblids["RDCODAUT"]=['RAVMCVENOT'];
HideUI.lblids["RDLOCAUT"]=['LSLCBQSYUK'];
HideUI.lblids["SEGNO"]=['MXHBIVIBOZ'];
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
function QZTTRBWAQL_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOGIOCO','C',w_TIPOGIOCO,HtW(getComboValue(Ctrl('QZTTRBWAQL')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOGIOCO(HtW(getComboValue(Ctrl('QZTTRBWAQL')),'C'),null,e);
return l_bSetResult;
}
}
function QZTTRBWAQL_OnFocus(e) {
SetActiveField(Ctrl('QZTTRBWAQL'),true);
}
function QZTTRBWAQL_OnBlur(e) {
SetActiveField(Ctrl('QZTTRBWAQL'),false);
}
function LVYFMQXNZH_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VLTPLAT','C',w_VLTPLAT,HtW(getComboValue(Ctrl('LVYFMQXNZH')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VLTPLAT(HtW(getComboValue(Ctrl('LVYFMQXNZH')),'C'),null,e);
return l_bSetResult;
}
}
function LVYFMQXNZH_OnFocus(e) {
SetActiveField(Ctrl('LVYFMQXNZH'),true);
}
function LVYFMQXNZH_OnBlur(e) {
SetActiveField(Ctrl('LVYFMQXNZH'),false);
}
function BMTLGIUQTH_Valid(e) {
SetActiveField(Ctrl('BMTLGIUQTH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CAIDBIGLIETTO','C',w_CAIDBIGLIETTO,HtW(Ctrl('BMTLGIUQTH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAIDBIGLIETTO(HtW(Ctrl('BMTLGIUQTH').value,'C'),null,e);
return l_bSetResult;
}
}
function BMTLGIUQTH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BMTLGIUQTH'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('BMTLGIUQTH'))) {
SPBOUILib.WtH('BMTLGIUQTH',w_CAIDBIGLIETTO,'C',30,0,'!');
}
SetActiveField(Ctrl('BMTLGIUQTH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BMTLGIUQTH'),e);
}
function BMTLGIUQTH_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("!"));
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
if (Ne(_tracker.ctrl,Ctrl('YLIKFVPZJA'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('YLIKFVPZJA',w_DATAOPE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
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
function DWJVPXTRND_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLAGWALLET','C',w_FLAGWALLET,HtW(getComboValue(Ctrl('DWJVPXTRND')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLAGWALLET(HtW(getComboValue(Ctrl('DWJVPXTRND')),'C'),null,e);
return l_bSetResult;
}
}
function DWJVPXTRND_OnFocus(e) {
SetActiveField(Ctrl('DWJVPXTRND'),true);
}
function DWJVPXTRND_OnBlur(e) {
SetActiveField(Ctrl('DWJVPXTRND'),false);
}
function YJDISDDJUY_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('CAFLGOPE','C',w_CAFLGOPE,HtW(getComboValue(Ctrl('YJDISDDJUY')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAFLGOPE(HtW(getComboValue(Ctrl('YJDISDDJUY')),'C'),null,e);
return l_bSetResult;
}
}
function YJDISDDJUY_OnFocus(e) {
SetActiveField(Ctrl('YJDISDDJUY'),true);
}
function YJDISDDJUY_OnBlur(e) {
SetActiveField(Ctrl('YJDISDDJUY'),false);
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
if (Ne(_tracker.ctrl,Ctrl('HUDOCMLKKT'))) {
SPBOUILib.WtH('HUDOCMLKKT',w_TOTCONT,'N',15,2,'999999999999.99');
}
SetActiveField(Ctrl('HUDOCMLKKT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HUDOCMLKKT'),e);
}
function HUDOCMLKKT_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999.99"));
}
function BELMGUMGMW_Valid(e) {
SetActiveField(Ctrl('BELMGUMGMW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMPWALLET','N',w_IMPWALLET,HtW(Ctrl('BELMGUMGMW').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMPWALLET(HtW(Ctrl('BELMGUMGMW').value,'N'),null,e);
return l_bSetResult;
}
}
function BELMGUMGMW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BELMGUMGMW'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('BELMGUMGMW'))) {
SPBOUILib.WtH('BELMGUMGMW',w_IMPWALLET,'N',12,2,'999999999999.99');
}
SetActiveField(Ctrl('BELMGUMGMW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BELMGUMGMW'),e);
}
function BELMGUMGMW_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999.99"));
}
function TRGEEVWGRS_Valid(e) {
SetActiveField(Ctrl('TRGEEVWGRS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODWALLET','C',w_CODWALLET,HtW(Ctrl('TRGEEVWGRS').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODWALLET(HtW(Ctrl('TRGEEVWGRS').value,'C'),null,e);
return l_bSetResult;
}
}
function TRGEEVWGRS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TRGEEVWGRS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TRGEEVWGRS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TRGEEVWGRS'),e);
}
function YYELCZIDWS_Valid(e) {
SetActiveField(Ctrl('YYELCZIDWS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODTRANSZ','C',w_CODTRANSZ,HtW(Ctrl('YYELCZIDWS').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODTRANSZ(HtW(Ctrl('YYELCZIDWS').value,'C'),null,e);
return l_bSetResult;
}
}
function YYELCZIDWS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YYELCZIDWS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YYELCZIDWS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YYELCZIDWS'),e);
}
function EKBMRGBOJG_Valid(e) {
SetActiveField(Ctrl('EKBMRGBOJG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('FILTROMP','C',w_FILTROMP,HtW(Ctrl('EKBMRGBOJG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FILTROMP(HtW(Ctrl('EKBMRGBOJG').value,'C'),null,e);
return l_bSetResult;
}
}
function EKBMRGBOJG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EKBMRGBOJG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('EKBMRGBOJG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EKBMRGBOJG'),e);
}
function GRJCRZXDIK_Valid(e) {
SetActiveField(Ctrl('GRJCRZXDIK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('FLGPAGAM','C',w_FLGPAGAM,HtW(Ctrl('GRJCRZXDIK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGPAGAM(HtW(Ctrl('GRJCRZXDIK').value,'C'),null,e);
return l_bSetResult;
}
}
function GRJCRZXDIK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GRJCRZXDIK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GRJCRZXDIK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GRJCRZXDIK'),e);
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
function MFCMVHMGSB_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('CCMESSCA','N',w_CCMESSCA,HtW(getComboValue(Ctrl('MFCMVHMGSB')),'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CCMESSCA(HtW(getComboValue(Ctrl('MFCMVHMGSB')),'N'),null,e);
return l_bSetResult;
}
}
function MFCMVHMGSB_OnFocus(e) {
SetActiveField(Ctrl('MFCMVHMGSB'),true);
}
function MFCMVHMGSB_OnBlur(e) {
SetActiveField(Ctrl('MFCMVHMGSB'),false);
}
function YZHCHEDWZM_Valid(e) {
SetActiveField(Ctrl('YZHCHEDWZM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CCANNSCA','N',w_CCANNSCA,HtW(Ctrl('YZHCHEDWZM').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CCANNSCA(HtW(Ctrl('YZHCHEDWZM').value,'N'),null,e);
return l_bSetResult;
}
}
function YZHCHEDWZM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YZHCHEDWZM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YZHCHEDWZM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YZHCHEDWZM'),e);
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
SPBOUILib.WtH('UTUCDPQJKK',w_IBAN,'C',40,0,'!');
}
SetActiveField(Ctrl('UTUCDPQJKK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UTUCDPQJKK'),e);
}
function UTUCDPQJKK_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("!"));
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
if (Ne(_tracker.ctrl,Ctrl('XMGRWGFSFV'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('XMGRWGFSFV',w_DATANASC,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
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
function GRTAUFQUJZ_Valid(e) {
SetActiveField(Ctrl('GRTAUFQUJZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NUMTEL','C',w_NUMTEL,HtW(Ctrl('GRTAUFQUJZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NUMTEL(HtW(Ctrl('GRTAUFQUJZ').value,'C'),null,e);
return l_bSetResult;
}
}
function GRTAUFQUJZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GRTAUFQUJZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GRTAUFQUJZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GRTAUFQUJZ'),e);
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
function href_DERAHXASAL() {
if ( ! (Empty(w_CODFISC))) {
DatiCF()
}
}
function href_RQVPEKINIU() {
if ( ! (Empty(w_COGNOME)) &&  ! (Empty(w_NOME)) &&  ! (Empty(LRTrim(w_NASCOMUN)+LRTrim(w_NASSTATO))) &&  ! (Empty(w_SESSO)) &&  ! (Empty(w_DATANASC))) {
DatiCN()
}
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
function NVJDAQQRWF_Valid(e) {
SetActiveField(Ctrl('NVJDAQQRWF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('saveddoc','C',w_saveddoc,HtW(Ctrl('NVJDAQQRWF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_saveddoc(HtW(Ctrl('NVJDAQQRWF').value,'C'),null,e);
return l_bSetResult;
}
}
function NVJDAQQRWF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NVJDAQQRWF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NVJDAQQRWF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NVJDAQQRWF'),e);
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
if (Ne(_tracker.ctrl,Ctrl('XHWYGOPPUN'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('XHWYGOPPUN',w_DATARILASC,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
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
if (Ne(_tracker.ctrl,Ctrl('BNWXBPSIDG'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('BNWXBPSIDG',w_DATAVALI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('BNWXBPSIDG');
SetActiveField(Ctrl('BNWXBPSIDG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BNWXBPSIDG'),e);
}
function BNWXBPSIDG_ZOOM_Click() {
LaunchCalendar(Ctrl('BNWXBPSIDG'));
}
function YDUQCBNYFV_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('RDCODAUT','C',w_RDCODAUT,HtW(getComboValue(Ctrl('YDUQCBNYFV')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RDCODAUT(HtW(getComboValue(Ctrl('YDUQCBNYFV')),'C'),null,e);
return l_bSetResult;
}
}
function YDUQCBNYFV_OnFocus(e) {
SetActiveField(Ctrl('YDUQCBNYFV'),true);
}
function YDUQCBNYFV_OnBlur(e) {
SetActiveField(Ctrl('YDUQCBNYFV'),false);
}
function MPRHMTBSXX_Valid(e) {
SetActiveField(Ctrl('MPRHMTBSXX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RDLOCAUT','C',w_RDLOCAUT,HtW(Ctrl('MPRHMTBSXX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RDLOCAUT(HtW(Ctrl('MPRHMTBSXX').value,'C'),null,e);
return l_bSetResult;
}
}
function MPRHMTBSXX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MPRHMTBSXX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MPRHMTBSXX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MPRHMTBSXX'),e);
}
function DAEHHCRYAM_Valid(e) {
SetActiveField(Ctrl('DAEHHCRYAM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PEPDESCRI','C',w_PEPDESCRI,HtW(Ctrl('DAEHHCRYAM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PEPDESCRI(HtW(Ctrl('DAEHHCRYAM').value,'C'),null,e);
return l_bSetResult;
}
}
function DAEHHCRYAM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DAEHHCRYAM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DAEHHCRYAM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DAEHHCRYAM'),e);
}
function UOOQYQWWNG_Valid(e) {
SuggesterLib.resetSuggest('UOOQYQWWNG','UOOQYQWWNG');
SetActiveField(Ctrl('UOOQYQWWNG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PAESE2','C',w_PAESE2,HtW(Ctrl('UOOQYQWWNG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PAESE2(HtW(Ctrl('UOOQYQWWNG').value,'C'),null,e);
return l_bSetResult;
}
}
function UOOQYQWWNG_OnFocus(e) {
UOOQYQWWNG_OnKeyUp.oldValue=HtW(Ctrl('UOOQYQWWNG').value,'C');
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UOOQYQWWNG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UOOQYQWWNG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UOOQYQWWNG'),e);
}
function UOOQYQWWNG_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('UOOQYQWWNG')),'linkview_UOOQYQWWNG','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
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
function BVEIQEJCLQ_Valid(e) {
SuggesterLib.resetSuggest('BVEIQEJCLQ','BVEIQEJCLQ');
SetActiveField(Ctrl('BVEIQEJCLQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCCIT2','C',w_DESCCIT2,HtW(Ctrl('BVEIQEJCLQ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCCIT2(HtW(Ctrl('BVEIQEJCLQ').value,'C'),null,e);
return l_bSetResult;
}
}
function BVEIQEJCLQ_OnFocus(e) {
BVEIQEJCLQ_OnKeyUp.oldValue=HtW(Ctrl('BVEIQEJCLQ').value,'C');
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BVEIQEJCLQ'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('BVEIQEJCLQ',w_DESCCIT2,'C',40,0,'!');
SetActiveField(Ctrl('BVEIQEJCLQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BVEIQEJCLQ'),e);
}
function BVEIQEJCLQ_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("!"));
}
function BVEIQEJCLQ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('BVEIQEJCLQ')),'linkview_BVEIQEJCLQ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
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
function NKJDWBKDWM_Valid(e) {
SetActiveField(Ctrl('NKJDWBKDWM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PROVINCIA2','C',w_PROVINCIA2,HtW(Ctrl('NKJDWBKDWM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PROVINCIA2(HtW(Ctrl('NKJDWBKDWM').value,'C'),null,e);
return l_bSetResult;
}
}
function NKJDWBKDWM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NKJDWBKDWM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NKJDWBKDWM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NKJDWBKDWM'),e);
}
function MDTHUZMSSI_Valid(e) {
SetActiveField(Ctrl('MDTHUZMSSI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CAP2','C',w_CAP2,HtW(Ctrl('MDTHUZMSSI').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAP2(HtW(Ctrl('MDTHUZMSSI').value,'C'),null,e);
return l_bSetResult;
}
}
function MDTHUZMSSI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MDTHUZMSSI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MDTHUZMSSI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MDTHUZMSSI'),e);
}
function CWOLOHZAQW_Valid(e) {
SetActiveField(Ctrl('CWOLOHZAQW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DOMICILIO2','C',w_DOMICILIO2,HtW(Ctrl('CWOLOHZAQW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DOMICILIO2(HtW(Ctrl('CWOLOHZAQW').value,'C'),null,e);
return l_bSetResult;
}
}
function CWOLOHZAQW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CWOLOHZAQW'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('CWOLOHZAQW',w_DOMICILIO2,'C',35,0,'!');
SetActiveField(Ctrl('CWOLOHZAQW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CWOLOHZAQW'),e);
}
function CWOLOHZAQW_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("!"));
}
function ZJPDUNZSZL_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGDOM','C',w_FLGDOM,ChkboxValueAssign(Ctrl('ZJPDUNZSZL'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGDOM(ChkboxValueAssign(Ctrl('ZJPDUNZSZL'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function ZJPDUNZSZL_OnFocus(e) {
SetActiveField(Ctrl('ZJPDUNZSZL'),true);
}
function ZJPDUNZSZL_OnBlur(e) {
SetActiveField(Ctrl('ZJPDUNZSZL'),false);
}
function XMHFFKJFDF_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGQADVFULL','C',w_FLGQADVFULL,ChkboxValueAssign(Ctrl('XMHFFKJFDF'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGQADVFULL(ChkboxValueAssign(Ctrl('XMHFFKJFDF'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function XMHFFKJFDF_OnFocus(e) {
SetActiveField(Ctrl('XMHFFKJFDF'),true);
}
function XMHFFKJFDF_OnBlur(e) {
SetActiveField(Ctrl('XMHFFKJFDF'),false);
}
function href_BYFMKHYARA() {
_modifyandopen(ToResource('jsp/pg_stampa_ricerca_blacklist_portlet.jsp'+'?nominativo='+URLenc(w_RAGSOC)+'&m_cParameterSequence=nominativo')+'&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=550,width=1024',null)
}
function PAQVIKBAGR_Valid(e) {
SetActiveField(Ctrl('PAQVIKBAGR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PROFESSIONE','C',w_PROFESSIONE,HtW(Ctrl('PAQVIKBAGR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PROFESSIONE(HtW(Ctrl('PAQVIKBAGR').value,'C'),null,e);
return l_bSetResult;
}
}
function PAQVIKBAGR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PAQVIKBAGR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PAQVIKBAGR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PAQVIKBAGR'),e);
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
function NWDPKKZGVO_Valid(e) {
SetActiveField(Ctrl('NWDPKKZGVO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ANA_FOUND','C',w_ANA_FOUND,HtW(Ctrl('NWDPKKZGVO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ANA_FOUND(HtW(Ctrl('NWDPKKZGVO').value,'C'),null,e);
return l_bSetResult;
}
}
function NWDPKKZGVO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NWDPKKZGVO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NWDPKKZGVO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NWDPKKZGVO'),e);
}
linkpc_url.u('BZRUFRMVDO',function(){return 'armt_cgo_qadv_operazioni_dl?m_bInnerChild=true'+GetLinkPCKeys('armt_cgo_qadv_operazioni_dl')+'&m_bRowsChild='+EnableChild('armt_cgo_qadv_operazioni_dl')})
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
function BYFMKHYARA_wrap_OnClick(event) {
return href_BYFMKHYARA();
}
SPBOUILib.SetImageClick('BYFMKHYARA',BYFMKHYARA_wrap_OnClick);
function BYFMKHYARA_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('BYFMKHYARA',BYFMKHYARA_wrap_OnKeyDown);
if (Ne(m_cFunction,'view')) {
function QZTTRBWAQL_wrap_Valid(event) {
return QZTTRBWAQL_Valid(event);
}
SPBOUILib.SetComboChange('QZTTRBWAQL',QZTTRBWAQL_wrap_Valid);
function QZTTRBWAQL_wrap_OnFocus(event) {
return QZTTRBWAQL_OnFocus(event);
}
SPBOUILib.SetInputEnter('QZTTRBWAQL',QZTTRBWAQL_wrap_OnFocus);
function QZTTRBWAQL_wrap_Blur(event) {
return QZTTRBWAQL_OnBlur(event);
}
SPBOUILib.SetInputExit('QZTTRBWAQL',QZTTRBWAQL_wrap_Blur);
function LVYFMQXNZH_wrap_Valid(event) {
return LVYFMQXNZH_Valid(event);
}
SPBOUILib.SetComboChange('LVYFMQXNZH',LVYFMQXNZH_wrap_Valid);
function LVYFMQXNZH_wrap_OnFocus(event) {
return LVYFMQXNZH_OnFocus(event);
}
SPBOUILib.SetInputEnter('LVYFMQXNZH',LVYFMQXNZH_wrap_OnFocus);
function LVYFMQXNZH_wrap_Blur(event) {
return LVYFMQXNZH_OnBlur(event);
}
SPBOUILib.SetInputExit('LVYFMQXNZH',LVYFMQXNZH_wrap_Blur);
function BMTLGIUQTH_wrap_Valid(event) {
return BMTLGIUQTH_Valid(event);
}
SPBOUILib.SetInputExit('BMTLGIUQTH',BMTLGIUQTH_wrap_Valid);
function BMTLGIUQTH_wrap_OnFocus(event) {
return BMTLGIUQTH_OnFocus(event);
}
SPBOUILib.SetInputEnter('BMTLGIUQTH',BMTLGIUQTH_wrap_OnFocus);
function BMTLGIUQTH_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('BMTLGIUQTH',BMTLGIUQTH_wrap_OnKeyPress);
function BMTLGIUQTH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BMTLGIUQTH',BMTLGIUQTH_wrap_OnKeyDown);
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
function DWJVPXTRND_wrap_Valid(event) {
return DWJVPXTRND_Valid(event);
}
SPBOUILib.SetComboChange('DWJVPXTRND',DWJVPXTRND_wrap_Valid);
function DWJVPXTRND_wrap_OnFocus(event) {
return DWJVPXTRND_OnFocus(event);
}
SPBOUILib.SetInputEnter('DWJVPXTRND',DWJVPXTRND_wrap_OnFocus);
function DWJVPXTRND_wrap_Blur(event) {
return DWJVPXTRND_OnBlur(event);
}
SPBOUILib.SetInputExit('DWJVPXTRND',DWJVPXTRND_wrap_Blur);
function YJDISDDJUY_wrap_Valid(event) {
return YJDISDDJUY_Valid(event);
}
SPBOUILib.SetComboChange('YJDISDDJUY',YJDISDDJUY_wrap_Valid);
function YJDISDDJUY_wrap_OnFocus(event) {
return YJDISDDJUY_OnFocus(event);
}
SPBOUILib.SetInputEnter('YJDISDDJUY',YJDISDDJUY_wrap_OnFocus);
function YJDISDDJUY_wrap_Blur(event) {
return YJDISDDJUY_OnBlur(event);
}
SPBOUILib.SetInputExit('YJDISDDJUY',YJDISDDJUY_wrap_Blur);
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
function BELMGUMGMW_wrap_Valid(event) {
return BELMGUMGMW_Valid(event);
}
SPBOUILib.SetInputExit('BELMGUMGMW',BELMGUMGMW_wrap_Valid);
function BELMGUMGMW_wrap_OnFocus(event) {
return BELMGUMGMW_OnFocus(event);
}
SPBOUILib.SetInputEnter('BELMGUMGMW',BELMGUMGMW_wrap_OnFocus);
function BELMGUMGMW_wrap_OnKeyPress(event) {
return BELMGUMGMW_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('BELMGUMGMW',BELMGUMGMW_wrap_OnKeyPress);
function BELMGUMGMW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BELMGUMGMW',BELMGUMGMW_wrap_OnKeyDown);
function TRGEEVWGRS_wrap_Valid(event) {
return TRGEEVWGRS_Valid(event);
}
SPBOUILib.SetInputExit('TRGEEVWGRS',TRGEEVWGRS_wrap_Valid);
function TRGEEVWGRS_wrap_OnFocus(event) {
return TRGEEVWGRS_OnFocus(event);
}
SPBOUILib.SetInputEnter('TRGEEVWGRS',TRGEEVWGRS_wrap_OnFocus);
function TRGEEVWGRS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TRGEEVWGRS',TRGEEVWGRS_wrap_OnKeyDown);
function YYELCZIDWS_wrap_Valid(event) {
return YYELCZIDWS_Valid(event);
}
SPBOUILib.SetInputExit('YYELCZIDWS',YYELCZIDWS_wrap_Valid);
function YYELCZIDWS_wrap_OnFocus(event) {
return YYELCZIDWS_OnFocus(event);
}
SPBOUILib.SetInputEnter('YYELCZIDWS',YYELCZIDWS_wrap_OnFocus);
function YYELCZIDWS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YYELCZIDWS',YYELCZIDWS_wrap_OnKeyDown);
function EKBMRGBOJG_wrap_Valid(event) {
return EKBMRGBOJG_Valid(event);
}
SPBOUILib.SetInputExit('EKBMRGBOJG',EKBMRGBOJG_wrap_Valid);
function EKBMRGBOJG_wrap_OnFocus(event) {
return EKBMRGBOJG_OnFocus(event);
}
SPBOUILib.SetInputEnter('EKBMRGBOJG',EKBMRGBOJG_wrap_OnFocus);
function EKBMRGBOJG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('EKBMRGBOJG',EKBMRGBOJG_wrap_OnKeyDown);
function GRJCRZXDIK_wrap_Valid(event) {
return GRJCRZXDIK_Valid(event);
}
SPBOUILib.SetInputExit('GRJCRZXDIK',GRJCRZXDIK_wrap_Valid);
function GRJCRZXDIK_wrap_OnFocus(event) {
return GRJCRZXDIK_OnFocus(event);
}
SPBOUILib.SetInputEnter('GRJCRZXDIK',GRJCRZXDIK_wrap_OnFocus);
function GRJCRZXDIK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('GRJCRZXDIK',GRJCRZXDIK_wrap_OnKeyDown);
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
function MFCMVHMGSB_wrap_Valid(event) {
return MFCMVHMGSB_Valid(event);
}
SPBOUILib.SetComboChange('MFCMVHMGSB',MFCMVHMGSB_wrap_Valid);
function MFCMVHMGSB_wrap_OnFocus(event) {
return MFCMVHMGSB_OnFocus(event);
}
SPBOUILib.SetInputEnter('MFCMVHMGSB',MFCMVHMGSB_wrap_OnFocus);
function MFCMVHMGSB_wrap_Blur(event) {
return MFCMVHMGSB_OnBlur(event);
}
SPBOUILib.SetInputExit('MFCMVHMGSB',MFCMVHMGSB_wrap_Blur);
function YZHCHEDWZM_wrap_Valid(event) {
return YZHCHEDWZM_Valid(event);
}
SPBOUILib.SetInputExit('YZHCHEDWZM',YZHCHEDWZM_wrap_Valid);
function YZHCHEDWZM_wrap_OnFocus(event) {
return YZHCHEDWZM_OnFocus(event);
}
SPBOUILib.SetInputEnter('YZHCHEDWZM',YZHCHEDWZM_wrap_OnFocus);
function YZHCHEDWZM_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('YZHCHEDWZM',YZHCHEDWZM_wrap_OnKeyPress);
function YZHCHEDWZM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YZHCHEDWZM',YZHCHEDWZM_wrap_OnKeyDown);
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
function GRTAUFQUJZ_wrap_Valid(event) {
return GRTAUFQUJZ_Valid(event);
}
SPBOUILib.SetInputExit('GRTAUFQUJZ',GRTAUFQUJZ_wrap_Valid);
function GRTAUFQUJZ_wrap_OnFocus(event) {
return GRTAUFQUJZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('GRTAUFQUJZ',GRTAUFQUJZ_wrap_OnFocus);
function GRTAUFQUJZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('GRTAUFQUJZ',GRTAUFQUJZ_wrap_OnKeyDown);
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
function NVJDAQQRWF_wrap_Valid(event) {
return NVJDAQQRWF_Valid(event);
}
SPBOUILib.SetInputExit('NVJDAQQRWF',NVJDAQQRWF_wrap_Valid);
function NVJDAQQRWF_wrap_OnFocus(event) {
return NVJDAQQRWF_OnFocus(event);
}
SPBOUILib.SetInputEnter('NVJDAQQRWF',NVJDAQQRWF_wrap_OnFocus);
function NVJDAQQRWF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NVJDAQQRWF',NVJDAQQRWF_wrap_OnKeyDown);
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
function YDUQCBNYFV_wrap_Valid(event) {
return YDUQCBNYFV_Valid(event);
}
SPBOUILib.SetComboChange('YDUQCBNYFV',YDUQCBNYFV_wrap_Valid);
function YDUQCBNYFV_wrap_OnFocus(event) {
return YDUQCBNYFV_OnFocus(event);
}
SPBOUILib.SetInputEnter('YDUQCBNYFV',YDUQCBNYFV_wrap_OnFocus);
function YDUQCBNYFV_wrap_Blur(event) {
return YDUQCBNYFV_OnBlur(event);
}
SPBOUILib.SetInputExit('YDUQCBNYFV',YDUQCBNYFV_wrap_Blur);
function MPRHMTBSXX_wrap_Valid(event) {
return MPRHMTBSXX_Valid(event);
}
SPBOUILib.SetInputExit('MPRHMTBSXX',MPRHMTBSXX_wrap_Valid);
function MPRHMTBSXX_wrap_OnFocus(event) {
return MPRHMTBSXX_OnFocus(event);
}
SPBOUILib.SetInputEnter('MPRHMTBSXX',MPRHMTBSXX_wrap_OnFocus);
function MPRHMTBSXX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MPRHMTBSXX',MPRHMTBSXX_wrap_OnKeyDown);
function DAEHHCRYAM_wrap_Valid(event) {
return DAEHHCRYAM_Valid(event);
}
SPBOUILib.SetInputExit('DAEHHCRYAM',DAEHHCRYAM_wrap_Valid);
function DAEHHCRYAM_wrap_OnFocus(event) {
return DAEHHCRYAM_OnFocus(event);
}
SPBOUILib.SetInputEnter('DAEHHCRYAM',DAEHHCRYAM_wrap_OnFocus);
function DAEHHCRYAM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DAEHHCRYAM',DAEHHCRYAM_wrap_OnKeyDown);
function UOOQYQWWNG_wrap_Valid(event) {
return UOOQYQWWNG_Valid(event);
}
SPBOUILib.SetInputExit('UOOQYQWWNG',UOOQYQWWNG_wrap_Valid);
function UOOQYQWWNG_wrap_OnFocus(event) {
return UOOQYQWWNG_OnFocus(event);
}
SPBOUILib.SetInputEnter('UOOQYQWWNG',UOOQYQWWNG_wrap_OnFocus);
function UOOQYQWWNG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UOOQYQWWNG',UOOQYQWWNG_wrap_OnKeyDown);
function UOOQYQWWNG_ZOOM_setHandlers() {
function UOOQYQWWNG_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?UOOQYQWWNG_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('UOOQYQWWNG_ZOOM',UOOQYQWWNG_ZOOM_wrap_OnClick);
function UOOQYQWWNG_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('UOOQYQWWNG_ZOOM',UOOQYQWWNG_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('UOOQYQWWNG',UOOQYQWWNG_ZOOM_setHandlers);
SPBOUILib.SetInputKeyUp('UOOQYQWWNG',function(event) {
  return (Eq(m_cFunction,'edit') || Eq(m_cFunction,'new')?UOOQYQWWNG_OnKeyUp(event):void(0));
});
function BVEIQEJCLQ_wrap_Valid(event) {
return BVEIQEJCLQ_Valid(event);
}
SPBOUILib.SetInputExit('BVEIQEJCLQ',BVEIQEJCLQ_wrap_Valid);
function BVEIQEJCLQ_wrap_OnFocus(event) {
return BVEIQEJCLQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('BVEIQEJCLQ',BVEIQEJCLQ_wrap_OnFocus);
function BVEIQEJCLQ_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('BVEIQEJCLQ',BVEIQEJCLQ_wrap_OnKeyPress);
function BVEIQEJCLQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BVEIQEJCLQ',BVEIQEJCLQ_wrap_OnKeyDown);
function BVEIQEJCLQ_ZOOM_setHandlers() {
function BVEIQEJCLQ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?BVEIQEJCLQ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('BVEIQEJCLQ_ZOOM',BVEIQEJCLQ_ZOOM_wrap_OnClick);
function BVEIQEJCLQ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('BVEIQEJCLQ_ZOOM',BVEIQEJCLQ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('BVEIQEJCLQ',BVEIQEJCLQ_ZOOM_setHandlers);
SPBOUILib.SetInputKeyUp('BVEIQEJCLQ',function(event) {
  return (Eq(m_cFunction,'edit') || Eq(m_cFunction,'new')?BVEIQEJCLQ_OnKeyUp(event):void(0));
});
function NKJDWBKDWM_wrap_Valid(event) {
return NKJDWBKDWM_Valid(event);
}
SPBOUILib.SetInputExit('NKJDWBKDWM',NKJDWBKDWM_wrap_Valid);
function NKJDWBKDWM_wrap_OnFocus(event) {
return NKJDWBKDWM_OnFocus(event);
}
SPBOUILib.SetInputEnter('NKJDWBKDWM',NKJDWBKDWM_wrap_OnFocus);
function NKJDWBKDWM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NKJDWBKDWM',NKJDWBKDWM_wrap_OnKeyDown);
function MDTHUZMSSI_wrap_Valid(event) {
return MDTHUZMSSI_Valid(event);
}
SPBOUILib.SetInputExit('MDTHUZMSSI',MDTHUZMSSI_wrap_Valid);
function MDTHUZMSSI_wrap_OnFocus(event) {
return MDTHUZMSSI_OnFocus(event);
}
SPBOUILib.SetInputEnter('MDTHUZMSSI',MDTHUZMSSI_wrap_OnFocus);
function MDTHUZMSSI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MDTHUZMSSI',MDTHUZMSSI_wrap_OnKeyDown);
function CWOLOHZAQW_wrap_Valid(event) {
return CWOLOHZAQW_Valid(event);
}
SPBOUILib.SetInputExit('CWOLOHZAQW',CWOLOHZAQW_wrap_Valid);
function CWOLOHZAQW_wrap_OnFocus(event) {
return CWOLOHZAQW_OnFocus(event);
}
SPBOUILib.SetInputEnter('CWOLOHZAQW',CWOLOHZAQW_wrap_OnFocus);
function CWOLOHZAQW_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('CWOLOHZAQW',CWOLOHZAQW_wrap_OnKeyPress);
function CWOLOHZAQW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CWOLOHZAQW',CWOLOHZAQW_wrap_OnKeyDown);
function ZJPDUNZSZL_wrap_Valid(event) {
return ZJPDUNZSZL_Valid(event);
}
SPBOUILib.SetCheckboxClick('ZJPDUNZSZL',ZJPDUNZSZL_wrap_Valid);
function ZJPDUNZSZL_wrap_OnFocus(event) {
return ZJPDUNZSZL_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZJPDUNZSZL',ZJPDUNZSZL_wrap_OnFocus);
function ZJPDUNZSZL_wrap_Blur(event) {
return ZJPDUNZSZL_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('ZJPDUNZSZL',ZJPDUNZSZL_wrap_Blur);
function XMHFFKJFDF_wrap_Valid(event) {
return XMHFFKJFDF_Valid(event);
}
SPBOUILib.SetCheckboxClick('XMHFFKJFDF',XMHFFKJFDF_wrap_Valid);
function XMHFFKJFDF_wrap_OnFocus(event) {
return XMHFFKJFDF_OnFocus(event);
}
SPBOUILib.SetInputEnter('XMHFFKJFDF',XMHFFKJFDF_wrap_OnFocus);
function XMHFFKJFDF_wrap_Blur(event) {
return XMHFFKJFDF_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('XMHFFKJFDF',XMHFFKJFDF_wrap_Blur);
function PAQVIKBAGR_wrap_Valid(event) {
return PAQVIKBAGR_Valid(event);
}
SPBOUILib.SetInputExit('PAQVIKBAGR',PAQVIKBAGR_wrap_Valid);
function PAQVIKBAGR_wrap_OnFocus(event) {
return PAQVIKBAGR_OnFocus(event);
}
SPBOUILib.SetInputEnter('PAQVIKBAGR',PAQVIKBAGR_wrap_OnFocus);
function PAQVIKBAGR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PAQVIKBAGR',PAQVIKBAGR_wrap_OnKeyDown);
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
function NWDPKKZGVO_wrap_Valid(event) {
return NWDPKKZGVO_Valid(event);
}
SPBOUILib.SetInputExit('NWDPKKZGVO',NWDPKKZGVO_wrap_Valid);
function NWDPKKZGVO_wrap_OnFocus(event) {
return NWDPKKZGVO_OnFocus(event);
}
SPBOUILib.SetInputEnter('NWDPKKZGVO',NWDPKKZGVO_wrap_OnFocus);
function NWDPKKZGVO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NWDPKKZGVO',NWDPKKZGVO_wrap_OnKeyDown);
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
w_PrtDocAll.raiseEvent('armt_cgo_oper_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.edit={"page_1":["QZTTRBWAQL"]};
FocusFirstComponent.query={"page_1":["QZTTRBWAQL"]};
FocusFirstComponent.otherwise={"page_1":["QZTTRBWAQL"]};
function Help() {
windowOpenForeground('../doc/armt_cgo_oper_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_armt_cgo_qadv_operazioni_dl() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_3')) {
if (ChildToLoad('BZRUFRMVDO')) {
LoadContext.lc(1,'BZRUFRMVDO');
} else {
LibJavascript.RefreshChildGrid('BZRUFRMVDO');
}
}
}
GetLayerID.Layers.push({"id":"CCUOYXMBZC","name":"Base"});
GetLayerID.Layers.push({"id":"YORQOIOBQN","name":"Operazione"});
GetLayerID.Layers.push({"id":"AQSQVBKXAL","name":"Soggetto"});
GetLayerID.Layers.push({"id":"XWJLXLYKJC","name":"Documenti"});
function DeclareWVs() {
var a = arguments;
w_TIPOGIOCO=a[0];
w_CGOTIPOPE=a[1];
w_VLTPLAT=a[2];
w_CAIDBIGLIETTO=a[3];
w_DATAOPE=a[4];
w_FLAGCONT=a[5];
w_FLAGWALLET=a[6];
w_CAFLGOPE=a[7];
w_TOTLIRE=a[8];
w_TOTCONT=a[9];
w_IMPWALLET=a[10];
w_CODWALLET=a[11];
w_CODTRANSZ=a[12];
w_CGOFLGVLT=a[13];
w_CGOFLGVNP=a[14];
w_MEZPAGAM=a[15];
w_CC4CIFRE=a[16];
w_CCMESSCA=a[17];
w_CCANNSCA=a[18];
w_ASSEGNO=a[19];
w_IBAN=a[20];
w_CCDATSCA=a[21];
w_CFESTERO=a[22];
w_PEP=a[23];
w_CODFISC=a[24];
w_COGNOME=a[25];
w_NOME=a[26];
w_NASCOMUN=a[27];
w_TIPINTER=a[28];
w_SESSO=a[29];
w_NASSTATO=a[30];
w_DATANASC=a[31];
w_PAESE=a[32];
w_DESCCIT=a[33];
w_PROVINCIA=a[34];
w_CAP=a[35];
w_DOMICILIO=a[36];
w_NUMTEL=a[37];
w_ATTIV=a[38];
w_TIPOPERS=a[39];
w_RAGSOC=a[40];
w_SOTGRUP=a[41];
w_RAMOGRUP=a[42];
w_SETTSINT=a[43];
w_SNAINUMOPE=a[44];
op_SNAINUMOPE=a[45];
w_DATAREG=a[46];
w_TIPOOPRAP=a[47];
w_CODANA=a[48];
w_CODVOC=a[49];
w_VALUTA=a[50];
w_CAMBIO=a[51];
w_CONNESCLI=a[52];
w_CONNESBEN=a[53];
w_C_RAG=a[54];
w_C_CTA=a[55];
w_C_PRV=a[56];
w_C_CAP=a[57];
w_C_CAB=a[58];
w_C_IND=a[59];
w_C_STA=a[60];
w_CODINTER=a[61];
w_SEGNO=a[62];
w_FLAGFRAZ=a[63];
w_COLLEG=a[64];
w_CACODICE=a[65];
w_CODCAB=a[66];
w_IDDOCALL=a[67];
w_FLGDOCALL=a[68];
w_TIPODOC=a[69];
w_NUMDOCUM=a[70];
w_DATARILASC=a[71];
w_DATAVALI=a[72];
w_RDCODAUT=a[73];
w_RDLOCAUT=a[74];
w_AUTRILASC=a[75];
w_PEPDESCRI=a[76];
w_PAESE2=a[77];
w_DESCCIT2=a[78];
w_PROVINCIA2=a[79];
w_CAP2=a[80];
w_DOMICILIO2=a[81];
w_FLGDOM=a[82];
w_PROFESSIONE=a[83];
w_CODDIPE=a[84];
w_DESCCITDIP=a[85];
w_PROVINCIADIP=a[86];
w_CODCABDIP=a[87];
w_gIntemediario=a[88];
w_xSOGTPGIO=a[89];
w_xDEFTPGIO=a[90];
w_xEDTTPGIO=a[91];
w_xEDTSPGIO=a[92];
w_xDEFSPGIO=a[93];
w_xFLGPLGIO=a[94];
w_FILTROMP=a[95];
w_FLGPAGAM=a[96];
w_idcitta=a[97];
w_xARDESCRI=a[98];
w_dessta=a[99];
w_tipsot=a[100];
w_STATOREG=a[101];
w_IDBASE=a[102];
w_NUMPROG=a[103];
w_DESCRI=a[104];
w_gSeekAos=a[105];
w_gDataVaria=a[106];
w_gFlgDoc=a[107];
w_gCodDip=a[108];
w_xDescDipe=a[109];
w_datpaseuro=a[110];
w_xdes1=a[111];
w_desccauana=a[112];
w_CITINT=a[113];
w_CITDIP=a[114];
w_PROVDIP=a[115];
w_CABDIP=a[116];
w_PROVINT=a[117];
w_CABINT=a[118];
w_xdesccausin=a[119];
w_gChkDate=a[120];
w_xdesctipatt=a[121];
w_gVLT=a[122];
w_gVNP=a[123];
w_gStpDwn=a[124];
w_MIDBIGLIETTO=a[125];
w_MIDBIGLIETTO1=a[126];
w_MIDBIGLIETTO4=a[127];
w_MIDBIGLIETTO2=a[128];
w_MIDBIGLIETTO3=a[129];
w_gPathApp=a[130];
w_xVPFLGATT=a[131];
w_DOC03=a[132];
w_DOC04=a[133];
w_gGesDoc=a[134];
w_edtdoc=a[135];
w_saveddoc=a[136];
w_xIMPMINGIO=a[137];
w_idcitta2=a[138];
w_dessta2=a[139];
w_gTipMul=a[140];
w_FLGQADVFULL=a[141];
w_gQADV=a[142];
w_xCGOFLGPROF=a[143];
w_TELDIP=a[144];
w_CODLOC=a[145];
w_dirupl=a[146];
w_ANA_FOUND=a[147];
op_codazi=a[148];
m_cWv_armt_cgo_qadv_operazioni_dl=a[149];;
if (Gt(a.length,150)) {
m_cErrorInChild='';
}
if (Gt(a.length,150)) {
o_TIPOGIOCO=w_TIPOGIOCO;
o_CAIDBIGLIETTO=w_CAIDBIGLIETTO;
o_DATAOPE=w_DATAOPE;
o_FLAGCONT=w_FLAGCONT;
o_FLAGWALLET=w_FLAGWALLET;
o_CAFLGOPE=w_CAFLGOPE;
o_TOTLIRE=w_TOTLIRE;
o_TOTCONT=w_TOTCONT;
o_IMPWALLET=w_IMPWALLET;
o_FILTROMP=w_FILTROMP;
o_CGOFLGVLT=w_CGOFLGVLT;
o_FLGPAGAM=w_FLGPAGAM;
o_MEZPAGAM=w_MEZPAGAM;
o_COGNOME=w_COGNOME;
o_NOME=w_NOME;
o_NASCOMUN=w_NASCOMUN;
o_TIPINTER=w_TIPINTER;
o_NASSTATO=w_NASSTATO;
o_PAESE=w_PAESE;
o_idcitta=w_idcitta;
o_ATTIV=w_ATTIV;
o_SOTGRUP=w_SOTGRUP;
o_TIPOOPRAP=w_TIPOOPRAP;
o_CONNESBEN=w_CONNESBEN;
o_C_CTA=w_C_CTA;
o_CODINTER=w_CODINTER;
o_COLLEG=w_COLLEG;
o_DATARILASC=w_DATARILASC;
o_DATAVALI=w_DATAVALI;
o_RDCODAUT=w_RDCODAUT;
o_RDLOCAUT=w_RDLOCAUT;
o_PAESE2=w_PAESE2;
o_idcitta2=w_idcitta2;
o_CODDIPE=w_CODDIPE;
}
m_PrimaryKeys=['SNAINUMOPE'];
}
function i_PrimaryKey() {
return 'cgo_operazioni_dl'+'\\'+CPLib.ToCPStr(w_SNAINUMOPE);
}
GetLinkPCKeys.set_o('armt_cgo_qadv_operazioni_dl',false);
GetLinkPCKeys.o['armt_cgo_qadv_operazioni_dl']['SNAINUMOPE']=function(t){
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
LoadContext.f('BZRUFRMVDO',function(){return FrameRef('armt_cgo_qadv_operazioni_dl')},1,'armt_cgo_qadv_operazioni_dl',1,3)
GetSelectedChildPage.child={'armt_cgo_qadv_operazioni_dl': function(){return FrameRef('armt_cgo_qadv_operazioni_dl')}}
function GetSelectedPage(p_d) {
p_d.setValue('armt_cgo_oper',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
if (IsNull(p_id) || Eq(p_id,'YJDISDDJUY')) {
if (Ctrl('YJDISDDJUY')) {
render_combobox('YJDISDDJUY','qbe_cgo_tgtiporeg',["?w_TIPOGIOCO"],[WtA(w_TIPOGIOCO,"C")],GetDynComboId('YJDISDDJUY'),'TRTIPREG','TRDESREG','',WtA(w_CAFLGOPE));
w_CAFLGOPE=HtW(getComboValue(Ctrl('YJDISDDJUY')),'C');
}
}
if (IsNull(p_id) || Eq(p_id,'EOSKLIUGBC')) {
if (Ctrl('EOSKLIUGBC')) {
render_combobox('EOSKLIUGBC','qbe_cgo_mezzipag',["?w_FILTROMP","?w_FLGPAGAM"],[WtA(w_FILTROMP,"C"),WtA(w_FLGPAGAM,"C")],GetDynComboId('EOSKLIUGBC'),'MPCODICE','MPDESCRI','',WtA(w_MEZPAGAM));
w_MEZPAGAM=HtW(getComboValue(Ctrl('EOSKLIUGBC')),'C');
}
}
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_NASCOMUN,'C'); },"field":"CITTA","type":"C"},{"expression":function() { return WtA(w_TIPINTER,'C'); },"field":"PROV","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcitta','C'),"uid":"NEUBQNUEOJ"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_NASSTATO,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"HODZKKOSYW"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_PAESE,'C'); },"field":"CODSTA","type":"C"},{"expression":function() { return WtA(w_dessta,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"YVIKEGPYPM"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_DESCCIT,'C'); },"field":"CITTA","type":"C"},{"expression":function() { return WtA(w_idcitta,'C'); },"field":"IDBASE","type":"C"}],"keyValues":[{"expression":function() { return WtA(w_PAESE,'C'); },"field":"PKTBSTATI","type":"C"}],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcitta','C'),"uid":"ODAYKSRECA"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_PAESE2,'C'); },"field":"CODSTA","type":"C"},{"expression":function() { return WtA(w_dessta2,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"UOOQYQWWNG"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_DESCCIT2,'C'); },"field":"CITTA","type":"C"},{"expression":function() { return WtA(w_idcitta2,'C'); },"field":"IDBASE","type":"C"}],"keyValues":[{"expression":function() { return WtA(w_PAESE,'C'); },"field":"PKTBSTATI","type":"C"}],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcitta','C'),"uid":"BVEIQEJCLQ"});
}
_Obli('FLGDOM',0,'ZJPDUNZSZL',false,"1319025851")
_Obli('TIPOGIOCO',0,'QZTTRBWAQL',true,"1603759671",'QZTTRBWAQL',"1686225832")
_Obli('CAP2',0,'MDTHUZMSSI',true,"21587",null,null,function() { return Eq(w_PAESE2,'086') && Eq(w_FLGDOM,'S') })
_Obli('DESCCIT2',0,'BVEIQEJCLQ',true,"11393904432",'BVEIQEJCLQ',null,function() { return Eq(w_PAESE2,'086') && Eq(w_FLGDOM,'S') })
_Obli('PAESE2',0,'UOOQYQWWNG',true,"11401314672",'UOOQYQWWNG',null,function() { return Eq(w_FLGDOM,'S') })
_Obli('SNAINUMOPE',0,'XFUOZLSACP',false,"11993248424")
_Obli('PEPDESCRI',0,'DAEHHCRYAM',true,"1705711075",null,null,function() { return Eq(w_PEP,'S') })
_Obli('RDLOCAUT',0,'MPRHMTBSXX',true,"1475053609")
_Obli('RDCODAUT',0,'YDUQCBNYFV',true,"1973525056",'YDUQCBNYFV',"1489090677")
_Obli('VLTPLAT',0,'LVYFMQXNZH',true,"11247539166",'LVYFMQXNZH',"441053783",function() { return Eq(w_xFLGPLGIO,'S') })
_Obli('CAIDBIGLIETTO',0,'BMTLGIUQTH',true,"10524120562",null,"11525797640")
_Obli('DATAOPE',2,'YLIKFVPZJA',true,"829201110",null,"10845724022")
_Obli('FLAGCONT',0,'PURPSXEVAI',true,"237632211")
_Obli('FLAGWALLET',0,'DWJVPXTRND',true,"647451330")
_Obli('CAFLGOPE',0,'YJDISDDJUY',true,"995100987")
_Obli('TOTLIRE',1,'HUAGBHPUNH',true,"1825772649",null,"11419822357")
_Obli('TOTCONT',1,'HUDOCMLKKT',true,"10943726013",null,"11525797640",function() { return Eq(w_FLAGCONT,'1') })
_Obli('IMPWALLET',1,'BELMGUMGMW',true,"1991861529",null,"1314928579",function() { return Eq(w_FLAGWALLET,'1') })
_Obli('CODWALLET',0,'TRGEEVWGRS',true,"92934247",null,null,function() { return Eq(w_FLAGWALLET,'1') })
_Obli('CODTRANSZ',0,'YYELCZIDWS',true,"11517258780",null,null,function() { return Eq(w_FLAGWALLET,'1') })
_Obli('FILTROMP',0,'EKBMRGBOJG',false)
_Obli('CONNESCLI',0,'QBLXDBODXR',false,"10219814530")
_Obli('FLGPAGAM',0,'GRJCRZXDIK',false)
_Obli('DATAVALI',2,'BNWXBPSIDG',true,"1216938285",null,"11525797640")
_Obli('MEZPAGAM',0,'EOSKLIUGBC',true,"10651434988",null,null,function() { return Gt(w_TOTLIRE-(w_TOTCONT+w_IMPWALLET),0) })
_Obli('CC4CIFRE',0,'FKEAKFSYVU',true,"11642408298",null,"11525797640",function() { return Eq(w_MEZPAGAM,'V') })
_Obli('CCMESSCA',1,'MFCMVHMGSB',true,"2025840209",null,null,function() { return Eq(w_MEZPAGAM,'V') })
_Obli('CCANNSCA',1,'YZHCHEDWZM',true,"1444804436",null,"11525797640",function() { return Eq(w_MEZPAGAM,'V') })
_Obli('ASSEGNO',0,'KZWBLPQNHU',true,"1984809585",null,null,function() { return (Eq(w_MEZPAGAM,'C') || Eq(w_MEZPAGAM,'B')) && (Ne(w_CGOFLGVLT,'S')) })
_Obli('IBAN',0,'UTUCDPQJKK',true,"737507602",null,"11525797640",function() { return Eq(w_MEZPAGAM,'I') || Eq(w_MEZPAGAM,'E') || Eq(w_MEZPAGAM,'P') })
_Obli('DATARILASC',2,'XHWYGOPPUN',true,"1608394306",null,"11525797640")
_Obli('CFESTERO',1,'CZTHKEDVCO',false,"10034405761")
_Obli('PEP',0,'XFKXBQYUIU',true,"1513560829")
_Obli('CODFISC',0,'OJJHIUDPFY',true,"11921223220",null,"1715238713",function() { return Eq(w_CFESTERO,0) })
_Obli('COGNOME',0,'TWTTDWKCRG',true,"1816546867")
_Obli('NOME',0,'WWGIVGNUDW',true,"443454")
_Obli('NASCOMUN',0,'NEUBQNUEOJ',true,"12123334500",'NEUBQNUEOJ',null,function() { return Empty(w_NASSTATO) })
_Obli('TIPINTER',0,'KPSCOABZLB',true,"3528304")
_Obli('SESSO',0,'QPALJZMFCL',true,"7776675")
_Obli('NASSTATO',0,'HODZKKOSYW',true,"12123284333",'HODZKKOSYW',null,function() { return Empty(w_NASCOMUN) })
_Obli('DATANASC',2,'XMGRWGFSFV',true,"11777527481",null,"11525797640")
_Obli('PAESE',0,'YVIKEGPYPM',true,"227238806",'YVIKEGPYPM')
_Obli('DESCCIT',0,'ODAYKSRECA',true,"15186643",'ODAYKSRECA',null,function() { return Eq(w_PAESE,'086') })
_Obli('NUMDOCUM',0,'HVEEMUJUUY',true,"1734932797")
_Obli('PROVINCIA',0,'NOTZPDMYIA',true,"10095365423",null,null,function() { return Eq(w_PAESE,'086') })
_Obli('CAP',0,'RDAVOEETJG',true,"21587",null,null,function() { return Eq(w_PAESE,'086') })
_Obli('DOMICILIO',0,'VYLHWTRQNX',true,"554236824",null,null,function() { return Eq(w_PAESE,'086') })
_Obli('NUMTEL',0,'GRTAUFQUJZ',false,"10574713661")
_Obli('TIPODOC',0,'MBGANUUHRA',true,"11429032151",'MBGANUUHRA')
_Obli('saveddoc',0,'NVJDAQQRWF',false)
_Obli('DOC04',0,'SIRTAMVPQN',false)
_Obli('DOC03',0,'PAADFVDPUD',false)
_Obli('PROFESSIONE',0,'PAQVIKBAGR',true,"178012863",null,null,function() { return Eq(w_xCGOFLGPROF,'S') })
_Obli('FLGQADVFULL',0,'XMHFFKJFDF',false)
_Obli('DOMICILIO2',0,'CWOLOHZAQW',true,"453879700",null,null,function() { return Eq(w_PAESE2,'086') && Eq(w_FLGDOM,'S') })
_Obli('PROVINCIA2',0,'NKJDWBKDWM',true,"10095365423",null,null,function() { return Eq(w_FLGDOM,'S') })
_Obli('CODDIPE',0,'AVHTGZTOSZ',false,"2071283709")
_Obli('FLGDOCALL',0,'ZUVVNOUSIQ',false,"674110294")
_Obli('ANA_FOUND',0,'NWDPKKZGVO',false)
