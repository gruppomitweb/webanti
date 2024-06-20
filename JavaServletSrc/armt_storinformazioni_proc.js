function FillCombosValues() {
FillCombo('SWRTSKXMDH','SWRTSKXMDH');
FillCombo('MLPGOPNAKN','MLPGOPNAKN');
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('WJSVGWKSFC',function(){return WtH(w_CODINTER,'C',11,0,'')},w_CODINTER);
SPBOUILib.SetInputValue('AVHTGZTOSZ',function(){return WtH(w_CODDIPE,'C',6,0,'')},w_CODDIPE);
SPBOUILib.SetInputValue('UMFEJVRUFZ',function(){return WtH(w_RAPPORTO,'C',25,0,'')},w_RAPPORTO);
SPBOUILib.SetInputValue('YLIKFVPZJA',function(){return WtH(w_DATAOPE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAOPE);
SPBOUILib.SetInputValue('OEIKQOZMYJ',function(){return WtH(w_DATAREG,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAREG);
if(c=Ctrl('SWRTSKXMDH')) selectCombo(c,w_TIPOOPRAP,'C')
SPBOUILib.SetInputValue('SLTZSUMACW',function(){return WtH(w_CONNESOPER,'C',16,0,'')},w_CONNESOPER);
if(c=Ctrl('MLPGOPNAKN')) selectCombo(c,w_TIPOLEG,'C')
SPBOUILib.SetInputValue('VYBZEWHKFF',function(){return WtH(w_DATARETT,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATARETT);
SPBOUILib.SetInputValue('FTYILIQWQK',function(){return WtH(w_STATOREG,'C',1,0,'')},w_STATOREG);
SPBOUILib.SetInputValue('RLUMBFHPUD',function(){return WtH(w_DESCCIT,'C',30,0,'')},w_DESCCIT);
SPBOUILib.SetInputValue('OJGQABFSYN',function(){return WtH(w_PROVINCIA,'C',2,0,'')},w_PROVINCIA);
SPBOUILib.SetInputValue('OZEOCQRSEQ',function(){return WtH(w_CODCAB,'C',6,0,'')},w_CODCAB);
var tmp_BLXOBUQVYE = ToHTag(AsControlValue(w_xDescDipe));
if (Ne(e_BLXOBUQVYE,tmp_BLXOBUQVYE)) {
SPBOUILib.SetLabelValue('BLXOBUQVYE','innerHTML',tmp_BLXOBUQVYE);
e_BLXOBUQVYE=tmp_BLXOBUQVYE;
}
SPBOUILib.SetInputValue('XYMCLUECBD',function(){return WtH(w_NUMPROG,'C',11,0,'')},w_NUMPROG);
var tmp_XXRYVYIIGY = ToHTag(AsControlValue(w_xdescrap));
if (Ne(e_XXRYVYIIGY,tmp_XXRYVYIIGY)) {
SPBOUILib.SetLabelValue('XXRYVYIIGY','innerHTML',tmp_XXRYVYIIGY);
e_XXRYVYIIGY=tmp_XXRYVYIIGY;
}
var tmp_YJYVIBZLQH = ToHTag(AsControlValue(w_xRagSoc));
if (Ne(e_YJYVIBZLQH,tmp_YJYVIBZLQH)) {
SPBOUILib.SetLabelValue('YJYVIBZLQH','innerHTML',tmp_YJYVIBZLQH);
e_YJYVIBZLQH=tmp_YJYVIBZLQH;
}
SPBOUILib.SetInputValue('TQTBMAXOZP',function(){return WtH(w_CODINTER,'C',11,0,'')},w_CODINTER);
SPBOUILib.SetInputValue('MMJUUBVOXU',function(){return WtH(w_DESCCIT,'C',30,0,'')},w_DESCCIT);
SPBOUILib.SetInputValue('RPVZSKBMLW',function(){return WtH(w_PROVINCIA,'C',2,0,'')},w_PROVINCIA);
SPBOUILib.SetInputValue('WDTMWXLMPB',function(){return WtH(w_CODCAB,'C',6,0,'')},w_CODCAB);
var tmp_OHBJKANXZH = ToHTag(AsControlValue(w_xDescDipe));
if (Ne(e_OHBJKANXZH,tmp_OHBJKANXZH)) {
SPBOUILib.SetLabelValue('OHBJKANXZH','innerHTML',tmp_OHBJKANXZH);
e_OHBJKANXZH=tmp_OHBJKANXZH;
}
var tmp_ABCLQJCBCR = ToHTag(AsControlValue(w_RAPPORTO+'- '+w_xdescrap));
if (Ne(e_ABCLQJCBCR,tmp_ABCLQJCBCR)) {
SPBOUILib.SetLabelValue('ABCLQJCBCR','innerHTML',tmp_ABCLQJCBCR);
e_ABCLQJCBCR=tmp_ABCLQJCBCR;
}
SPBOUILib.SetInputValue('BILHYLSMRS',function(){return WtH(w_CODDIPE,'C',6,0,'')},w_CODDIPE);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
h=Gt(w_DATAOPE,CharToDate('20100531')) || IsHiddenByStateDriver(Z.Tabs.Get('tabs').GetTabstripID('page_2'));
SetDisplay(Z.Tabs.Get('tabs').GetTabstripID('page_2'),h);
if (h && (Z.Tabs.Get('tabs').IsExpanded('page_2'))) {
Z.Tabs.Get('tabs').Next() || Z.Tabs.Get('tabs').Prev();
}
SetDisplay('YORQOIOBQN_DIV',IsHiddenByStateDriver('box_YORQOIOBQN'));
SetDisplay('BOYWPGJEEZ_DIV',IsHiddenByStateDriver('box_BOYWPGJEEZ'));
SetDisplay(Ctrl('SLTZSUMACW'),Ge(w_DATAOPE,CharToDate('01/06/2010')) && Empty(w_CONNESOPER) || IsHiddenByStateDriver('CONNESOPER'));
SetDisplay(Ctrl('SLTZSUMACW_ZOOM'),Ge(w_DATAOPE,CharToDate('01/06/2010')) && Empty(w_CONNESOPER));
SetDisplay(Ctrl('MLPGOPNAKN'),Ge(w_DATAOPE,CharToDate('01/06/2010')) && Empty(w_CONNESOPER) || IsHiddenByStateDriver('TIPOLEG'));
SetDisplay(Ctrl('VYBZEWHKFF'),true || IsHiddenByStateDriver('DATARETT'));
SetDisplay(Ctrl('XAWQKRVCSF'),Ge(w_DATAOPE,CharToDate('01/06/2010')) && Empty(w_CONNESOPER));
SetDisplay(Ctrl('FTYILIQWQK'),true || IsHiddenByStateDriver('STATOREG'));
SetDisplay(Ctrl('QSDCLKKQSB'),Ge(w_DATAOPE,CharToDate('01/06/2010')) && Empty(w_CONNESOPER));
SetDisplay(Ctrl('JTSYWOZZQD'),Ne(w_STATOREG,'3'));
SetDisplay(Ctrl('LPKMZXAILT'),Ne(w_STATOREG,'2'));
SetDisplay('HDCVKCQUDV_DIV',IsHiddenByStateDriver('box_HDCVKCQUDV'));
SetDisplay('TALHUUYCXX_DIV',IsHiddenByStateDriver('box_TALHUUYCXX'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["CODCAB"]=['ENBRMMDVUP','IWNONYEAAB'];
HideUI.lblids["CODDIPE"]=['XVRJYSKGWZ','NXNHXKZHDU'];
HideUI.lblids["CODINTER"]=['ASXPAXYMTW','LOEAMXUYLA'];
HideUI.lblids["CONNESOPER"]=['XAWQKRVCSF','QSDCLKKQSB'];
HideUI.lblids["DATAOPE"]=['HVHVAYPDJE'];
HideUI.lblids["DATAREG"]=['IKBMEWKQJW'];
HideUI.lblids["DESCCIT"]=['JOVDRMQUVQ','CTLYJMTHDV'];
HideUI.lblids["NUMPROG"]=['KDUGHGZUUG'];
HideUI.lblids["PROVINCIA"]=['JWSDOSRGAG','TLOTQEDJQB'];
HideUI.lblids["RAPPORTO"]=['WDSMYOZLJE'];
HideUI.lblids["TIPOLEG"]=['XAWQKRVCSF','QSDCLKKQSB'];
HideUI.lblids["TIPOOPRAP"]=['BYKQMDEEAQ'];
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
function UMFEJVRUFZ_Valid(e) {
SetActiveField(Ctrl('UMFEJVRUFZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RAPPORTO','C',w_RAPPORTO,HtW(Ctrl('UMFEJVRUFZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAPPORTO(HtW(Ctrl('UMFEJVRUFZ').value,'C'),null,e);
return l_bSetResult;
}
}
function UMFEJVRUFZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UMFEJVRUFZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UMFEJVRUFZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UMFEJVRUFZ'),e);
}
function UMFEJVRUFZ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('UMFEJVRUFZ')),'linkview_UMFEJVRUFZ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
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
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('OEIKQOZMYJ',w_DATAREG,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('OEIKQOZMYJ');
SetActiveField(Ctrl('OEIKQOZMYJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OEIKQOZMYJ'),e);
}
function SWRTSKXMDH_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOOPRAP','C',w_TIPOOPRAP,HtW(getComboValue(Ctrl('SWRTSKXMDH')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOOPRAP(HtW(getComboValue(Ctrl('SWRTSKXMDH')),'C'),null,e);
return l_bSetResult;
}
}
function SWRTSKXMDH_OnFocus(e) {
SetActiveField(Ctrl('SWRTSKXMDH'),true);
}
function SWRTSKXMDH_OnBlur(e) {
SetActiveField(Ctrl('SWRTSKXMDH'),false);
}
function SLTZSUMACW_Valid(e) {
SetActiveField(Ctrl('SLTZSUMACW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CONNESOPER','C',w_CONNESOPER,HtW(Ctrl('SLTZSUMACW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONNESOPER(HtW(Ctrl('SLTZSUMACW').value,'C'),null,e);
return l_bSetResult;
}
}
function SLTZSUMACW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SLTZSUMACW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SLTZSUMACW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SLTZSUMACW'),e);
}
function SLTZSUMACW_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('SLTZSUMACW')),'linkview_SLTZSUMACW','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function MLPGOPNAKN_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOLEG','C',w_TIPOLEG,HtW(getComboValue(Ctrl('MLPGOPNAKN')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOLEG(HtW(getComboValue(Ctrl('MLPGOPNAKN')),'C'),null,e);
return l_bSetResult;
}
}
function MLPGOPNAKN_OnFocus(e) {
SetActiveField(Ctrl('MLPGOPNAKN'),true);
}
function MLPGOPNAKN_OnBlur(e) {
SetActiveField(Ctrl('MLPGOPNAKN'),false);
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
function FTYILIQWQK_Valid(e) {
SetActiveField(Ctrl('FTYILIQWQK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('STATOREG','C',w_STATOREG,HtW(Ctrl('FTYILIQWQK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_STATOREG(HtW(Ctrl('FTYILIQWQK').value,'C'),null,e);
return l_bSetResult;
}
}
function FTYILIQWQK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FTYILIQWQK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FTYILIQWQK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FTYILIQWQK'),e);
}
linkpc_url.u('ZFLICMSKTV',function(){return 'ardt_storinformazioni?m_bInnerChild=true'+GetLinkPCKeys('ardt_storinformazioni')+'&m_bRowsChild='+EnableChild('ardt_storinformazioni')})
linkpc_url.u('IXHEMDOSUG',function(){return 'ardt_storsoginfo?m_bInnerChild=true'+GetLinkPCKeys('ardt_storsoginfo')+'&m_bRowsChild='+EnableChild('ardt_storsoginfo')})
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
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
function UMFEJVRUFZ_wrap_Valid(event) {
return UMFEJVRUFZ_Valid(event);
}
SPBOUILib.SetInputExit('UMFEJVRUFZ',UMFEJVRUFZ_wrap_Valid);
function UMFEJVRUFZ_wrap_OnFocus(event) {
return UMFEJVRUFZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('UMFEJVRUFZ',UMFEJVRUFZ_wrap_OnFocus);
function UMFEJVRUFZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UMFEJVRUFZ',UMFEJVRUFZ_wrap_OnKeyDown);
function UMFEJVRUFZ_ZOOM_setHandlers() {
function UMFEJVRUFZ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?UMFEJVRUFZ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('UMFEJVRUFZ_ZOOM',UMFEJVRUFZ_ZOOM_wrap_OnClick);
function UMFEJVRUFZ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('UMFEJVRUFZ_ZOOM',UMFEJVRUFZ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('UMFEJVRUFZ',UMFEJVRUFZ_ZOOM_setHandlers);
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
function SWRTSKXMDH_wrap_Valid(event) {
return SWRTSKXMDH_Valid(event);
}
SPBOUILib.SetComboChange('SWRTSKXMDH',SWRTSKXMDH_wrap_Valid);
function SWRTSKXMDH_wrap_OnFocus(event) {
return SWRTSKXMDH_OnFocus(event);
}
SPBOUILib.SetInputEnter('SWRTSKXMDH',SWRTSKXMDH_wrap_OnFocus);
function SWRTSKXMDH_wrap_Blur(event) {
return SWRTSKXMDH_OnBlur(event);
}
SPBOUILib.SetInputExit('SWRTSKXMDH',SWRTSKXMDH_wrap_Blur);
function SLTZSUMACW_wrap_Valid(event) {
return SLTZSUMACW_Valid(event);
}
SPBOUILib.SetInputExit('SLTZSUMACW',SLTZSUMACW_wrap_Valid);
function SLTZSUMACW_wrap_OnFocus(event) {
return SLTZSUMACW_OnFocus(event);
}
SPBOUILib.SetInputEnter('SLTZSUMACW',SLTZSUMACW_wrap_OnFocus);
function SLTZSUMACW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SLTZSUMACW',SLTZSUMACW_wrap_OnKeyDown);
function SLTZSUMACW_ZOOM_setHandlers() {
function SLTZSUMACW_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?SLTZSUMACW_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('SLTZSUMACW_ZOOM',SLTZSUMACW_ZOOM_wrap_OnClick);
function SLTZSUMACW_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('SLTZSUMACW_ZOOM',SLTZSUMACW_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('SLTZSUMACW',SLTZSUMACW_ZOOM_setHandlers);
function MLPGOPNAKN_wrap_Valid(event) {
return MLPGOPNAKN_Valid(event);
}
SPBOUILib.SetComboChange('MLPGOPNAKN',MLPGOPNAKN_wrap_Valid);
function MLPGOPNAKN_wrap_OnFocus(event) {
return MLPGOPNAKN_OnFocus(event);
}
SPBOUILib.SetInputEnter('MLPGOPNAKN',MLPGOPNAKN_wrap_OnFocus);
function MLPGOPNAKN_wrap_Blur(event) {
return MLPGOPNAKN_OnBlur(event);
}
SPBOUILib.SetInputExit('MLPGOPNAKN',MLPGOPNAKN_wrap_Blur);
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
function FTYILIQWQK_wrap_Valid(event) {
return FTYILIQWQK_Valid(event);
}
SPBOUILib.SetInputExit('FTYILIQWQK',FTYILIQWQK_wrap_Valid);
function FTYILIQWQK_wrap_OnFocus(event) {
return FTYILIQWQK_OnFocus(event);
}
SPBOUILib.SetInputEnter('FTYILIQWQK',FTYILIQWQK_wrap_OnFocus);
function FTYILIQWQK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FTYILIQWQK',FTYILIQWQK_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["AVHTGZTOSZ"]};
FocusFirstComponent.query={"page_1":["AVHTGZTOSZ"]};
FocusFirstComponent.otherwise={"page_1":["AVHTGZTOSZ"]};
function Help() {
windowOpenForeground('../doc/armt_storinformazioni_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_ardt_storinformazioni() {
SetModified();
}
function SetModified_ardt_storsoginfo() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_1')) {
if (ChildToLoad('ZFLICMSKTV')) {
LoadContext.lc(1,'ZFLICMSKTV');
} else {
LibJavascript.RefreshChildGrid('ZFLICMSKTV');
}
}
if (Eq(page,'page_2')) {
if (ChildToLoad('IXHEMDOSUG')) {
LoadContext.lc(1,'IXHEMDOSUG');
} else {
LibJavascript.RefreshChildGrid('IXHEMDOSUG');
}
}
}
function DeclareWVs() {
var a = arguments;
w_CODINTER=a[0];
w_CODDIPE=a[1];
w_RAPPORTO=a[2];
w_DATAOPE=a[3];
w_DATAREG=a[4];
w_TIPOOPRAP=a[5];
w_CONNESOPER=a[6];
w_TIPOLEG=a[7];
w_DATARETT=a[8];
w_IDBASE=a[9];
op_IDBASE=a[10];
w_TIPOINTER=a[11];
w_TIPOINF=a[12];
w_IDEREG=a[13];
w_FLAGRAP=a[14];
w_OPRAP=a[15];
w_STATOREG=a[16];
w_OPERAZMOD=a[17];
w_OPERATORE=a[18];
w_AUTOM=a[19];
w_DESCCIT=a[20];
w_PROVINCIA=a[21];
w_CODCAB=a[22];
w_NUMPROG=a[23];
op_NUMPROG=a[24];
w_FLAGRAP2=a[25];
w_FLAGLIRE=a[26];
w_PRGIMPINF=a[27];
op_PRGIMPINF=a[28];
w_CDATOPE=a[29];
w_gIntemediario=a[30];
w_xdescrap=a[31];
w_xDescDipe=a[32];
w_datpaseuro=a[33];
w_gChkDate=a[34];
w_xDesReg=a[35];
w_xRagSoc=a[36];
w_sEdit=a[37];
w_errmsg=a[38];
w_Aggiorna=a[39];
w_lancio=a[40];
w_VALUTA=a[41];
w_gSblocco=a[42];
w_tipreg=a[43];
w_tipregn=a[44];
w_dataoggi=a[45];
w_gStatus=a[46];
w_gDataVaria=a[47];
w_CITINT=a[48];
w_CITDIP=a[49];
w_PROVDIP=a[50];
w_CABDIP=a[51];
w_PROVINT=a[52];
w_CABINT=a[53];
op_codazi=a[54];
m_cWv_ardt_storinformazioni=a[55];
m_cWv_ardt_storsoginfo=a[56];
if (Gt(a.length,57)) {
m_cErrorInChild='';
}
if (Gt(a.length,57)) {
o_CODINTER=w_CODINTER;
o_CODDIPE=w_CODDIPE;
o_DATAOPE=w_DATAOPE;
o_TIPOOPRAP=w_TIPOOPRAP;
o_FLAGRAP=w_FLAGRAP;
}
m_PrimaryKeys=['IDBASE'];
}
function i_PrimaryKey() {
return 'wapopebo'+'\\'+CPLib.ToCPStr(w_IDBASE);
}
GetLinkPCKeys.set_o('ardt_storinformazioni',false);
GetLinkPCKeys.set_o('ardt_storsoginfo',false);
GetLinkPCKeys.o['ardt_storinformazioni']['RAPPORTO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_RAPPORTO,'C');
}
}
GetLinkPCKeys.o['ardt_storsoginfo']['RAPCOL']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_RAPPORTO,'C');
}
}
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('ZFLICMSKTV',function(){return FrameRef('ardt_storinformazioni')},1,'ardt_storinformazioni',1,1)
LoadContext.f('IXHEMDOSUG',function(){return FrameRef('ardt_storsoginfo')},1,'ardt_storsoginfo',1,2)
GetSelectedChildPage.child={'ardt_storinformazioni': function(){return FrameRef('ardt_storinformazioni')}, 'ardt_storsoginfo': function(){return FrameRef('ardt_storsoginfo')}}
function GetSelectedPage(p_d) {
p_d.setValue('armt_storinformazioni',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODDIPE,'C'); },"field":"CODDIP","type":"C"},{"expression":function() { return WtA(w_xDescDipe,'C'); },"field":"DESCRIZ","type":"C"},{"expression":function() { return WtA(w_CITDIP,'C'); },"field":"DESCCIT","type":"C"},{"expression":function() { return WtA(w_PROVDIP,'C'); },"field":"PROVINCIA","type":"C"},{"expression":function() { return WtA(w_CABDIP,'C'); },"field":"CAB","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('anadip','C'),"uid":"AVHTGZTOSZ"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_RAPPORTO,'C'); },"field":"RAPPORTO","type":"C"},{"expression":function() { return WtA(w_xdescrap,'C'); },"field":"DESCRAP","type":"C"},{"expression":function() { return WtA(w_FLAGLIRE,'C'); },"field":"FLAGLIRE","type":"C"},{"expression":function() { return WtA(w_VALUTA,'C'); },"field":"VALUTA","type":"C"},{"expression":function() { return WtA(w_FLAGRAP,'C'); },"field":"TIPORAP","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('wnarapbo','C'),"uid":"UMFEJVRUFZ"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CONNESOPER,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xRagSoc,'C'); },"field":"RAGSOC","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"SLTZSUMACW"});
}
_Obli('TIPOOPRAP',0,'SWRTSKXMDH',true,"684190680",'SWRTSKXMDH')
_Obli('CONNESOPER',0,'SLTZSUMACW',false,"11755647652")
_Obli('CODDIPE',0,'AVHTGZTOSZ',false,"2071283709")
_Obli('CODDIPE',0,'BILHYLSMRS',false,"2071283709")
_Obli('RAPPORTO',0,'UMFEJVRUFZ',false)
_Obli('DATAOPE',2,'YLIKFVPZJA',true,"829201110")
_Obli('DATAREG',2,'OEIKQOZMYJ',true,"1028598955")
_Obli('DATARETT',2,'VYBZEWHKFF',false,"11329559720")
_Obli('TIPOLEG',0,'MLPGOPNAKN',false,"11205021885")
_Obli('STATOREG',0,'FTYILIQWQK',false,"11258238247")
