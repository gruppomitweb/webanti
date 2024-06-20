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
var tmp_QSDCLKKQSB = ToHTag(AsControlValue((Lt(w_DATAOPE,CharToDate('20100601'))?'Pers. Fisica Agente x conto:':(Gt(w_DATAOPE,CharToDate('20131231'))?'Esecutore:':''))));
if (Ne(e_QSDCLKKQSB,tmp_QSDCLKKQSB)) {
SPBOUILib.SetLabelValue('QSDCLKKQSB','innerHTML',tmp_QSDCLKKQSB);
e_QSDCLKKQSB=tmp_QSDCLKKQSB;
}
var tmp_YJYVIBZLQH = ToHTag(AsControlValue(w_xRagSoc));
if (Ne(e_YJYVIBZLQH,tmp_YJYVIBZLQH)) {
SPBOUILib.SetLabelValue('YJYVIBZLQH','innerHTML',tmp_YJYVIBZLQH);
e_YJYVIBZLQH=tmp_YJYVIBZLQH;
}
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay('YORQOIOBQN_DIV',IsHiddenByStateDriver('DATIBASE'));
Z.Tabs.Get("tabs_1_DETTAGLIO").Hide('HOHRVXKGPC',IsHiddenByStateDriver('INTESTATARI'));
Z.Tabs.Get("tabs_1_DETTAGLIO").Hide('PUODKNEFWX',IsHiddenByStateDriver('DELEGATI'));
SetDisplay(Ctrl('SLTZSUMACW'),arfn_view_soct(w_DATAOPE,w_TIPOOPRAP,'V') || IsHiddenByStateDriver('CONNESOPER'));
SetDisplay(Ctrl('SLTZSUMACW_ZOOM'),arfn_view_soct(w_DATAOPE,w_TIPOOPRAP,'V'));
SetDisplay(Ctrl('MLPGOPNAKN'),arfn_view_soct(w_DATAOPE,w_TIPOOPRAP,'T') || IsHiddenByStateDriver('TIPOLEG'));
SetDisplay(Ctrl('XAWQKRVCSF'),arfn_view_soct(w_DATAOPE,w_TIPOOPRAP,'T'));
SetDisplay(Ctrl('QSDCLKKQSB'),arfn_view_soct(w_DATAOPE,w_TIPOOPRAP,'V'));
SetDisplay(Ctrl('YJYVIBZLQH'),arfn_view_soct(w_DATAOPE,w_TIPOOPRAP,'V'));
SetDisplay(Ctrl('EFRNVTREYB'), ! (Empty(LRTrim(w_xRagSoc))) || Empty(w_CONNESOPER));
Z.Tabs.Get("tabs_1_DETTAGLIO").Hide('HDCVKCQUDV',IsHiddenByStateDriver('ALTRISOGG'));
SetDisplay('BFAOFWJWLC_DIV',IsHiddenByStateDriver('Intermediario'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["CODCAB"]=['ENBRMMDVUP'];
HideUI.lblids["CODDIPE"]=['XVRJYSKGWZ'];
HideUI.lblids["CODINTER"]=['LOEAMXUYLA'];
HideUI.lblids["CONNESOPER"]=['QSDCLKKQSB'];
HideUI.lblids["DATAOPE"]=['HVHVAYPDJE'];
HideUI.lblids["DATAREG"]=['IKBMEWKQJW'];
HideUI.lblids["DESCCIT"]=['CTLYJMTHDV'];
HideUI.lblids["NUMPROG"]=['KDUGHGZUUG'];
HideUI.lblids["PROVINCIA"]=['JWSDOSRGAG'];
HideUI.lblids["RAPPORTO"]=['WDSMYOZLJE'];
HideUI.lblids["TIPOLEG"]=['XAWQKRVCSF'];
HideUI.lblids["TIPOOPRAP"]=['BYKQMDEEAQ'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
cond=Eq(At(w_TIPOOPRAP,'|25|28|39|40|41|47'),0) &&  ! (Empty(w_TIPOOPRAP));
if (Ne(o_HOHRVXKGPC_expand,cond)) {
if (cond) {
Z.Tabs.Get("tabs_1_DETTAGLIO").Expand('HOHRVXKGPC');
}
o_HOHRVXKGPC_expand=cond;
}
cond=Gt(At(w_TIPOOPRAP,'|25|28|39|40|41|47'),0) || Empty(w_TIPOOPRAP);
if (Ne(o_HOHRVXKGPC_collapse,cond)) {
if (cond) {
Z.Tabs.Get("tabs_1_DETTAGLIO").Collapse('HOHRVXKGPC');
}
o_HOHRVXKGPC_collapse=cond;
}
cond=Gt(At(w_TIPOOPRAP,'|25|28|39|40|41|47'),0) &&  ! (Empty(w_TIPOOPRAP));
if (Ne(o_PUODKNEFWX_expand,cond)) {
if (cond) {
Z.Tabs.Get("tabs_1_DETTAGLIO").Expand('PUODKNEFWX');
}
o_PUODKNEFWX_expand=cond;
}
cond=Eq(At(w_TIPOOPRAP,'|25|28|39|40|41|47'),0) || Empty(w_TIPOOPRAP);
if (Ne(o_PUODKNEFWX_collapse,cond)) {
if (cond) {
Z.Tabs.Get("tabs_1_DETTAGLIO").Collapse('PUODKNEFWX');
}
o_PUODKNEFWX_collapse=cond;
}
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
linkpc_url.u('ZFLICMSKTV',function(){return 'ardt_ae_intestbo?m_bInnerChild=true'+GetLinkPCKeys('ardt_ae_intestbo')+'&m_bRowsChild='+EnableChild('ardt_ae_intestbo')})
linkpc_url.u('RSWMQMMVEI',function(){return 'ardt_ae_delegabo?m_bInnerChild=true'+GetLinkPCKeys('ardt_ae_delegabo')+'&m_bRowsChild='+EnableChild('ardt_ae_delegabo')})
linkpc_url.u('IXHEMDOSUG',function(){return 'ardt_ae_soginfo?m_bInnerChild=true'+GetLinkPCKeys('ardt_ae_soginfo')+'&m_bRowsChild='+EnableChild('ardt_ae_soginfo')})
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
FocusFirstComponent.edit={"page_1":["AVHTGZTOSZ","UMFEJVRUFZ"]};
FocusFirstComponent.query={"page_1":["AVHTGZTOSZ","UMFEJVRUFZ"]};
FocusFirstComponent.otherwise={"page_1":["AVHTGZTOSZ","UMFEJVRUFZ"]};
function Help() {
windowOpenForeground('../doc/armt_ae_rapopebo_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_ardt_ae_intestbo() {
SetModified();
}
function SetModified_ardt_ae_delegabo() {
SetModified();
}
function SetModified_ardt_ae_soginfo() {
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
if (Eq(page,'page_1')) {
if (ChildToLoad('RSWMQMMVEI')) {
LoadContext.lc(1,'RSWMQMMVEI');
} else {
LibJavascript.RefreshChildGrid('RSWMQMMVEI');
}
}
if (Eq(page,'page_1')) {
if (ChildToLoad('IXHEMDOSUG')) {
LoadContext.lc(1,'IXHEMDOSUG');
} else {
LibJavascript.RefreshChildGrid('IXHEMDOSUG');
}
}
}
GetLayerID.Layers.push({"id":"YORQOIOBQN","name":"DATIBASE"});
GetLayerID.Layers.push({"id":"HOHRVXKGPC","name":"INTESTATARI"});
GetLayerID.Layers.push({"id":"PUODKNEFWX","name":"DELEGATI"});
GetLayerID.Layers.push({"id":"HDCVKCQUDV","name":"ALTRISOGG"});
GetLayerID.Layers.push({"id":"BFAOFWJWLC","name":"Intermediario"});
function DeclareWVs() {
var a = arguments;
w_CDATOPE=a[0];
w_CODINTER=a[1];
w_CODDIPE=a[2];
w_RAPPORTO=a[3];
w_DATAOPE=a[4];
w_DATAREG=a[5];
w_TIPOOPRAP=a[6];
w_CONNESOPER=a[7];
w_TIPOLEG=a[8];
w_IDBASE=a[9];
op_IDBASE=a[10];
w_TIPOINTER=a[11];
w_TIPOINF=a[12];
w_IDEREG=a[13];
w_FLAGRAP=a[14];
w_OPRAP=a[15];
w_OPERATORE=a[16];
w_AUTOM=a[17];
w_DESCCIT=a[18];
w_PROVINCIA=a[19];
w_CODCAB=a[20];
w_NUMPROG=a[21];
op_NUMPROG=a[22];
w_FLAGRAP2=a[23];
w_FLAGLIRE=a[24];
w_PRGIMPINF=a[25];
op_PRGIMPINF=a[26];
w_OPERAZMOD=a[27];
w_gIntemediario=a[28];
w_gSblocco=a[29];
w_gFlgDTP=a[30];
w_gChkDate=a[31];
w_gStatus=a[32];
w_gDataVaria=a[33];
w_gCodDip=a[34];
w_filtro=a[35];
w_dataoggi=a[36];
w_tipreg=a[37];
w_tipregn=a[38];
w_sEdit=a[39];
w_xdescrap=a[40];
w_xDescDipe=a[41];
w_datpaseuro=a[42];
w_xDesReg=a[43];
w_xRagSoc=a[44];
w_errmsg=a[45];
w_Aggiorna=a[46];
w_lancio=a[47];
w_VALUTA=a[48];
w_CITINT=a[49];
w_CITDIP=a[50];
w_PROVDIP=a[51];
w_CABDIP=a[52];
w_PROVINT=a[53];
w_CABINT=a[54];
w_inutile=a[55];
w_prova=a[56];
op_codazi=a[57];
o_HOHRVXKGPC_expand=null;
o_HOHRVXKGPC_collapse=null;
o_PUODKNEFWX_expand=null;
o_PUODKNEFWX_collapse=null;
m_cWv_ardt_ae_intestbo=a[58];
m_cWv_ardt_ae_delegabo=a[59];
m_cWv_ardt_ae_soginfo=a[60];
if (Gt(a.length,61)) {
m_cErrorInChild='';
}
if (Gt(a.length,61)) {
o_filtro=w_filtro;
o_CDATOPE=w_CDATOPE;
o_CODINTER=w_CODINTER;
o_CODDIPE=w_CODDIPE;
o_RAPPORTO=w_RAPPORTO;
o_DATAOPE=w_DATAOPE;
o_TIPOOPRAP=w_TIPOOPRAP;
o_FLAGRAP=w_FLAGRAP;
}
m_PrimaryKeys=['IDBASE'];
}
function i_PrimaryKey() {
return 'japopebo'+'\\'+CPLib.ToCPStr(w_IDBASE);
}
GetLinkPCKeys.set_o('ardt_ae_intestbo',false);
GetLinkPCKeys.set_o('ardt_ae_delegabo',false);
GetLinkPCKeys.set_o('ardt_ae_soginfo',false);
GetLinkPCKeys.o['ardt_ae_intestbo']['RAPPORTO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_RAPPORTO,'C');
}
}
GetLinkPCKeys.o['ardt_ae_delegabo']['RAPPORTO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_RAPPORTO,'C');
}
}
GetLinkPCKeys.o['ardt_ae_soginfo']['RAPCOL']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_RAPPORTO,'C');
}
}
resizeChildIframe.children['ardt_ae_intestbo']=true;
resizeChildIframe.children['ardt_ae_delegabo']=true;
resizeChildIframe.children['ardt_ae_soginfo']=true;
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('ZFLICMSKTV',function(){return FrameRef('ardt_ae_intestbo')},1,'ardt_ae_intestbo',1,1)
LoadContext.f('RSWMQMMVEI',function(){return FrameRef('ardt_ae_delegabo')},1,'ardt_ae_delegabo',1,1)
LoadContext.f('IXHEMDOSUG',function(){return FrameRef('ardt_ae_soginfo')},1,'ardt_ae_soginfo',1,1)
GetSelectedChildPage.child={'ardt_ae_intestbo': function(){return FrameRef('ardt_ae_intestbo')}, 'ardt_ae_delegabo': function(){return FrameRef('ardt_ae_delegabo')}, 'ardt_ae_soginfo': function(){return FrameRef('ardt_ae_soginfo')}}
function GetSelectedPage(p_d) {
p_d.setValue('armt_ae_rapopebo',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
if (IsNull(p_id) || Eq(p_id,'MLPGOPNAKN')) {
if (Ctrl('MLPGOPNAKN')) {
render_combobox('MLPGOPNAKN','qbe_tipileg',["?w_CDATOPE","?w_filtro"],[WtA(w_CDATOPE,"C"),WtA(w_filtro,"C")],GetDynComboId('MLPGOPNAKN'),'TPCODICE','TPDESCRI','',WtA(w_TIPOLEG));
w_TIPOLEG=HtW(getComboValue(Ctrl('MLPGOPNAKN')),'C');
}
}
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODDIPE,'C'); },"field":"CODDIP","type":"C"},{"expression":function() { return WtA(w_xDescDipe,'C'); },"field":"DESCRIZ","type":"C"},{"expression":function() { return WtA(w_CITDIP,'C'); },"field":"DESCCIT","type":"C"},{"expression":function() { return WtA(w_PROVDIP,'C'); },"field":"PROVINCIA","type":"C"},{"expression":function() { return WtA(w_CABDIP,'C'); },"field":"CAB","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('anadip','C'),"uid":"AVHTGZTOSZ"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_RAPPORTO,'C'); },"field":"RAPPORTO","type":"C"},{"expression":function() { return WtA(w_xdescrap,'C'); },"field":"DESCRAP","type":"C"},{"expression":function() { return WtA(w_FLAGLIRE,'C'); },"field":"FLAGLIRE","type":"C"},{"expression":function() { return WtA(w_VALUTA,'C'); },"field":"VALUTA","type":"C"},{"expression":function() { return WtA(w_FLAGRAP,'C'); },"field":"TIPORAP","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('jnarapbo','C'),"uid":"UMFEJVRUFZ"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CONNESOPER,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xRagSoc,'C'); },"field":"RAGSOC","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"SLTZSUMACW"});
}
_Obli('TIPOOPRAP',0,'SWRTSKXMDH',true,"684190680",'SWRTSKXMDH')
_Obli('DATAREG',2,'OEIKQOZMYJ',true,"1028598955",null,"2021191611")
_Obli('DATAOPE',2,'YLIKFVPZJA',true,"829201110",null,"2021191611")
_Obli('RAPPORTO',0,'UMFEJVRUFZ',false)
_Obli('CODDIPE',0,'AVHTGZTOSZ',false,"2071283709")
_Obli('TIPOLEG',0,'MLPGOPNAKN',false,"11205021885")
_Obli('CONNESOPER',0,'SLTZSUMACW',false,"11755647652")
