function FillCombosValues() {
FillCombo('SWRTSKXMDH','SWRTSKXMDH');
FillCombo('MLPGOPNAKN','MLPGOPNAKN');
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('WJSVGWKSFC',function(){return WtH(w_CODINTER,'C',11,0,'')},w_CODINTER);
SPBOUILib.SetInputValue('AVHTGZTOSZ',function(){return WtH(w_CODDIPE,'C',6,0,'')},w_CODDIPE);
SPBOUILib.SetInputValue('UMFEJVRUFZ',function(){return WtH(w_CONNESCLI,'C',16,0,'')},w_CONNESCLI);
SPBOUILib.SetInputValue('YLIKFVPZJA',function(){return WtH(w_DATAOPE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAOPE);
if(c=Ctrl('SWRTSKXMDH')) selectCombo(c,w_TIPOOPRAP,'C')
if(c=Ctrl('MLPGOPNAKN')) selectCombo(c,w_TIPOLEG,'C')
SPBOUILib.SetInputValue('FMTBXELZFV',function(){return WtH(w_RAPPORTO,'C',25,0,'')},w_RAPPORTO);
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
var tmp_XXRYVYIIGY = ToHTag(AsControlValue(w_xRagSocCli));
if (Ne(e_XXRYVYIIGY,tmp_XXRYVYIIGY)) {
SPBOUILib.SetLabelValue('XXRYVYIIGY','innerHTML',tmp_XXRYVYIIGY);
e_XXRYVYIIGY=tmp_XXRYVYIIGY;
}
SPBOUILib.SetInputValue('OMOIESFAVO',function(){return WtH(w_DESCINTER,'C',50,0,'')},w_DESCINTER);
var tmp_KDPAOAJNFQ = ToHTag(AsControlValue(w_xdescrap));
if (Ne(e_KDPAOAJNFQ,tmp_KDPAOAJNFQ)) {
SPBOUILib.SetLabelValue('KDPAOAJNFQ','innerHTML',tmp_KDPAOAJNFQ);
e_KDPAOAJNFQ=tmp_KDPAOAJNFQ;
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
SetDisplay('BOYWPGJEEZ_DIV',IsHiddenByStateDriver('box_BOYWPGJEEZ'));
SetDisplay(Ctrl('FTYILIQWQK'),true || IsHiddenByStateDriver('STATOREG'));
SetDisplay(Ctrl('IKBMEWKQJW'),true);
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["CODCAB"]=['ENBRMMDVUP'];
HideUI.lblids["CODDIPE"]=['XVRJYSKGWZ'];
HideUI.lblids["CODINTER"]=['LOEAMXUYLA'];
HideUI.lblids["CONNESCLI"]=['WDSMYOZLJE'];
HideUI.lblids["DATAOPE"]=['HVHVAYPDJE'];
HideUI.lblids["DATAREG"]=['IKBMEWKQJW'];
HideUI.lblids["DESCCIT"]=['CTLYJMTHDV'];
HideUI.lblids["DESCINTER"]=['AGQEPDVFBG'];
HideUI.lblids["NUMPROG"]=['KDUGHGZUUG'];
HideUI.lblids["PROVINCIA"]=['JWSDOSRGAG'];
HideUI.lblids["RAPPORTO"]=['JIPVCDYRBV'];
HideUI.lblids["STATOREG"]=['IKBMEWKQJW'];
HideUI.lblids["TIPOLEG"]=['XAWQKRVCSF'];
HideUI.lblids["TIPOOPRAP"]=['BYKQMDEEAQ'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
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
DoQuery('CONNESCLI','C',w_CONNESCLI,HtW(Ctrl('UMFEJVRUFZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONNESCLI(HtW(Ctrl('UMFEJVRUFZ').value,'C'),null,e);
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
function FMTBXELZFV_Valid(e) {
SetActiveField(Ctrl('FMTBXELZFV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RAPPORTO','C',w_RAPPORTO,HtW(Ctrl('FMTBXELZFV').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAPPORTO(HtW(Ctrl('FMTBXELZFV').value,'C'),null,e);
return l_bSetResult;
}
}
function FMTBXELZFV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FMTBXELZFV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FMTBXELZFV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FMTBXELZFV'),e);
}
function FMTBXELZFV_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('FMTBXELZFV')),'linkview_FMTBXELZFV','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
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
function OMOIESFAVO_Valid(e) {
SetActiveField(Ctrl('OMOIESFAVO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCINTER','C',w_DESCINTER,HtW(Ctrl('OMOIESFAVO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCINTER(HtW(Ctrl('OMOIESFAVO').value,'C'),null,e);
return l_bSetResult;
}
}
function OMOIESFAVO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OMOIESFAVO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OMOIESFAVO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OMOIESFAVO'),e);
}
linkpc_url.u('XSGICXLWWX',function(){return 'ardt_xntestit?m_bInnerChild=true'+GetLinkPCKeys('ardt_xntestit')+'&m_bRowsChild='+EnableChild('ardt_xntestit')})
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
function FMTBXELZFV_wrap_Valid(event) {
return FMTBXELZFV_Valid(event);
}
SPBOUILib.SetInputExit('FMTBXELZFV',FMTBXELZFV_wrap_Valid);
function FMTBXELZFV_wrap_OnFocus(event) {
return FMTBXELZFV_OnFocus(event);
}
SPBOUILib.SetInputEnter('FMTBXELZFV',FMTBXELZFV_wrap_OnFocus);
function FMTBXELZFV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FMTBXELZFV',FMTBXELZFV_wrap_OnKeyDown);
function FMTBXELZFV_ZOOM_setHandlers() {
function FMTBXELZFV_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?FMTBXELZFV_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('FMTBXELZFV_ZOOM',FMTBXELZFV_ZOOM_wrap_OnClick);
function FMTBXELZFV_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('FMTBXELZFV_ZOOM',FMTBXELZFV_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('FMTBXELZFV',FMTBXELZFV_ZOOM_setHandlers);
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
function OMOIESFAVO_wrap_Valid(event) {
return OMOIESFAVO_Valid(event);
}
SPBOUILib.SetInputExit('OMOIESFAVO',OMOIESFAVO_wrap_Valid);
function OMOIESFAVO_wrap_OnFocus(event) {
return OMOIESFAVO_OnFocus(event);
}
SPBOUILib.SetInputEnter('OMOIESFAVO',OMOIESFAVO_wrap_OnFocus);
function OMOIESFAVO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OMOIESFAVO',OMOIESFAVO_wrap_OnKeyDown);
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
windowOpenForeground('../doc/armt_xapotit_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_ardt_xntestit() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_1')) {
if (ChildToLoad('XSGICXLWWX')) {
LoadContext.lc(1,'XSGICXLWWX');
} else {
LibJavascript.RefreshChildGrid('XSGICXLWWX');
}
}
}
GetLayerID.Layers.push({"id":"BOYWPGJEEZ","name":"box_BOYWPGJEEZ"});
function DeclareWVs() {
var a = arguments;
w_CODINTER=a[0];
w_CODDIPE=a[1];
w_CONNESCLI=a[2];
w_DATAOPE=a[3];
w_CDATOPE=a[4];
w_DATAREG=a[5];
w_TIPOOPRAP=a[6];
w_CONNESOPER=a[7];
w_TIPOLEG=a[8];
w_RAPPORTO=a[9];
w_DATARETT=a[10];
w_IDBASE=a[11];
op_IDBASE=a[12];
w_TIPOINTER=a[13];
w_TIPOINF=a[14];
w_IDEREG=a[15];
w_FLAGRAP=a[16];
w_OPRAP=a[17];
w_STATOREG=a[18];
w_OPERAZMOD=a[19];
w_OPERATORE=a[20];
w_AUTOM=a[21];
w_DESCCIT=a[22];
w_PROVINCIA=a[23];
w_CODCAB=a[24];
w_NUMPROG=a[25];
op_NUMPROG=a[26];
w_FLAGRAP2=a[27];
w_FLAGLIRE=a[28];
w_PRGIMPTIT=a[29];
op_PRGIMPTIT=a[30];
w_DESCINTER=a[31];
w_CDATREG=a[32];
w_flgpg=a[33];
w_flgpf=a[34];
w_gCodDip=a[35];
w_gIntemediario=a[36];
w_xdescrap=a[37];
w_xDescDipe=a[38];
w_datpaseuro=a[39];
w_gChkDate=a[40];
w_xDesReg=a[41];
w_xRagSoc=a[42];
w_sEdit=a[43];
w_errmsg=a[44];
w_Aggiorna=a[45];
w_lancio=a[46];
w_VALUTA=a[47];
w_gSblocco=a[48];
w_tipreg=a[49];
w_tipregn=a[50];
w_dataoggi=a[51];
w_gStatus=a[52];
w_gDataVaria=a[53];
w_CITINT=a[54];
w_CITDIP=a[55];
w_PROVDIP=a[56];
w_CABDIP=a[57];
w_PROVINT=a[58];
w_CABINT=a[59];
w_xRagSocCli=a[60];
w_filtro=a[61];
w_SESSO=a[62];
op_codazi=a[63];
m_cWv_ardt_xntestit=a[64];
if (Gt(a.length,65)) {
m_cErrorInChild='';
}
if (Gt(a.length,65)) {
o_CODINTER=w_CODINTER;
o_flgpf=w_flgpf;
o_CODDIPE=w_CODDIPE;
o_CONNESCLI=w_CONNESCLI;
o_DATAOPE=w_DATAOPE;
o_CDATOPE=w_CDATOPE;
o_DATAREG=w_DATAREG;
o_TIPOOPRAP=w_TIPOOPRAP;
o_CONNESOPER=w_CONNESOPER;
o_filtro=w_filtro;
}
m_PrimaryKeys=['IDBASE'];
}
function i_PrimaryKey() {
return 'xapotit'+'\\'+CPLib.ToCPStr(w_IDBASE);
}
GetLinkPCKeys.set_o('ardt_xntestit',false);
GetLinkPCKeys.o['ardt_xntestit']['CODCLI']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_CONNESCLI,'C');
}
}
resizeChildIframe.children['ardt_xntestit']=true;
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('XSGICXLWWX',function(){return FrameRef('ardt_xntestit')},1,'ardt_xntestit',1,1)
GetSelectedChildPage.child={'ardt_xntestit': function(){return FrameRef('ardt_xntestit')}}
function GetSelectedPage(p_d) {
p_d.setValue('armt_xapotit',m_cSelectedPage);
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
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CONNESCLI,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xRagSocCli,'C'); },"field":"RAGSOC","type":"C"},{"expression":function() { return WtA(w_SESSO,'C'); },"field":"SESSO","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"UMFEJVRUFZ"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_RAPPORTO,'C'); },"field":"RAPPORTO","type":"C"},{"expression":function() { return WtA(w_xdescrap,'C'); },"field":"DESCRAP","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('knarapbo','C'),"uid":"FMTBXELZFV"});
}
_Obli('TIPOOPRAP',0,'SWRTSKXMDH',true,"684190680",'SWRTSKXMDH')
_Obli('DATAOPE',2,'YLIKFVPZJA',true,"829201110")
_Obli('RAPPORTO',0,'FMTBXELZFV',true,null,'FMTBXELZFV',null,function() { return Eq(w_TIPOOPRAP,'52') || Eq(w_TIPOOPRAP,'53') })
_Obli('TIPOLEG',0,'MLPGOPNAKN',false,"11205021885")
_Obli('CONNESCLI',0,'UMFEJVRUFZ',false)
_Obli('CODDIPE',0,'AVHTGZTOSZ',false,"2071283709")
_Obli('STATOREG',0,'FTYILIQWQK',false,"11258238247")
_Obli('DESCINTER',0,'OMOIESFAVO',false)
