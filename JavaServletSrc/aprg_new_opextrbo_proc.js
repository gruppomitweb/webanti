function SetControlsValue() {
var c;
var c;
if(c=Ctrl('MEXFGSWICI')) c.value = WtH(w_annorif,'C',4,0,'')
if(c=Ctrl('PYGHSMNTBK')) c.value = WtH(w_dataope,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('MVMKKHKTPS')) c.value = WtH(w_txtnote,'C',50,0,'')
if(c=Ctrl('SJSORASFDD')) c.value = WtH(w_nummov,'N',10,0,'')
if(c=Ctrl('XVLXTTNQKE')) c.value = WtH(w_impsaldo,'N',17,0,'99,999,999,999,999,999')
if(c=Ctrl('LRGJFQVRXS')) c.value = WtH(w_codval,'C',3,0,'')
if(c=Ctrl('TJVNAGXDHC')) c.value = WtH(w_CONNES,'C',16,0,'')
var tmp_MOKGCFDFSI = ToHTag(AsControlValue(w_xdesval));
if (Ne(e_MOKGCFDFSI,tmp_MOKGCFDFSI)) {
if(c=Ctrl('MOKGCFDFSI')) c.innerHTML=tmp_MOKGCFDFSI;
e_MOKGCFDFSI=tmp_MOKGCFDFSI;
}
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('TJVNAGXDHC'),true || IsHiddenByStateDriver('CONNES'));
SetDisplay(Ctrl('FGMOCXNBFY'),true);
HideUI();
}
HideUI.lblids["annorif"]=['MONQASQGHB'];
HideUI.lblids["codval"]=['LVRTLUHOTJ'];
HideUI.lblids["dataope"]=['BAATYILHGP'];
HideUI.lblids["impsaldo"]=['LVCMUSBIZN'];
HideUI.lblids["nummov"]=['IXDOZMMVRS'];
HideUI.lblids["txtnote"]=['XWYXRGKNEJ'];
function MEXFGSWICI_Valid(e) {
SetActiveField(Ctrl('MEXFGSWICI'),false);
e=(Ne(e,null)?e:window.event);
return Set_annorif(HtW(Ctrl('MEXFGSWICI').value,'C'),null,e);
}
function MEXFGSWICI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MEXFGSWICI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MEXFGSWICI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MEXFGSWICI'),e);
}
function PYGHSMNTBK_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('PYGHSMNTBK'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('PYGHSMNTBK').value=ApplyPictureToDate(Ctrl('PYGHSMNTBK').value,TranslatePicture(datePattern),'PYGHSMNTBK');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('PYGHSMNTBK'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('PYGHSMNTBK');
}
}
}
SetActiveField(Ctrl('PYGHSMNTBK'),false);
e=(Ne(e,null)?e:window.event);
return Set_dataope(HtW(Ctrl('PYGHSMNTBK').value,'D'),null,e) && dateisok;
}
function PYGHSMNTBK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PYGHSMNTBK'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('PYGHSMNTBK').value=WtH(w_dataope,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('PYGHSMNTBK');
SetActiveField(Ctrl('PYGHSMNTBK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PYGHSMNTBK'),e);
}
function MVMKKHKTPS_Valid(e) {
SetActiveField(Ctrl('MVMKKHKTPS'),false);
e=(Ne(e,null)?e:window.event);
return Set_txtnote(HtW(Ctrl('MVMKKHKTPS').value,'C'),null,e);
}
function MVMKKHKTPS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MVMKKHKTPS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MVMKKHKTPS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MVMKKHKTPS'),e);
}
function SJSORASFDD_Valid(e) {
SetActiveField(Ctrl('SJSORASFDD'),false);
e=(Ne(e,null)?e:window.event);
return Set_nummov(HtW(Ctrl('SJSORASFDD').value,'N'),null,e);
}
function SJSORASFDD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SJSORASFDD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SJSORASFDD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SJSORASFDD'),e);
}
function XVLXTTNQKE_Valid(e) {
SetActiveField(Ctrl('XVLXTTNQKE'),false);
e=(Ne(e,null)?e:window.event);
return Set_impsaldo(HtW(Ctrl('XVLXTTNQKE').value,'N'),null,e);
}
function XVLXTTNQKE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XVLXTTNQKE'))) {
DisplayErrorMessage();
}
Ctrl('XVLXTTNQKE').value=WtH(w_impsaldo,'N',17,0,'99999999999999999');
SetActiveField(Ctrl('XVLXTTNQKE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XVLXTTNQKE'),e);
}
function XVLXTTNQKE_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("99999999999999999"));
}
function LRGJFQVRXS_Valid(e) {
SetActiveField(Ctrl('LRGJFQVRXS'),false);
e=(Ne(e,null)?e:window.event);
return Set_codval(HtW(Ctrl('LRGJFQVRXS').value,'C'),null,e);
}
function LRGJFQVRXS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LRGJFQVRXS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LRGJFQVRXS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LRGJFQVRXS'),e);
}
function LRGJFQVRXS_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('LRGJFQVRXS')),'linkview_LRGJFQVRXS','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function href_ZQEKBHAOQV() {
if (false || WindowConfirm(Translate('11271491468'))) {
window.close()
}
}
function TJVNAGXDHC_Valid(e) {
SetActiveField(Ctrl('TJVNAGXDHC'),false);
e=(Ne(e,null)?e:window.event);
return Set_CONNES(HtW(Ctrl('TJVNAGXDHC').value,'C'),null,e);
}
function TJVNAGXDHC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TJVNAGXDHC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TJVNAGXDHC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TJVNAGXDHC'),e);
}
function href_GJGIOZNGOM() {
if (false || WindowConfirm(Translate('10108547188'))) {
SalvaDati()
}
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('MEXFGSWICI')) c.onblur=MEXFGSWICI_Valid;
if(c=Ctrl('MEXFGSWICI')) c.onfocus=MEXFGSWICI_OnFocus;
if(c=Ctrl('PYGHSMNTBK')) c.onblur=PYGHSMNTBK_Valid;
if(c=Ctrl('PYGHSMNTBK')) c.onfocus=PYGHSMNTBK_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('PYGHSMNTBK')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('MVMKKHKTPS')) c.onblur=MVMKKHKTPS_Valid;
if(c=Ctrl('MVMKKHKTPS')) c.onfocus=MVMKKHKTPS_OnFocus;
if(c=Ctrl('SJSORASFDD')) c.onblur=SJSORASFDD_Valid;
if(c=Ctrl('SJSORASFDD')) c.onfocus=SJSORASFDD_OnFocus;
if(c=Ctrl('SJSORASFDD')) c.onkeypress=CheckNum;
if(c=Ctrl('XVLXTTNQKE')) c.onblur=XVLXTTNQKE_Valid;
if(c=Ctrl('XVLXTTNQKE')) c.onfocus=XVLXTTNQKE_OnFocus;
if(c=Ctrl('XVLXTTNQKE')) c.onkeypress=XVLXTTNQKE_CheckNumWithPict;
if(c=Ctrl('LRGJFQVRXS')) c.onblur=LRGJFQVRXS_Valid;
if(c=Ctrl('LRGJFQVRXS')) c.onfocus=LRGJFQVRXS_OnFocus;
if(c=Ctrl('TJVNAGXDHC')) c.onblur=TJVNAGXDHC_Valid;
if(c=Ctrl('TJVNAGXDHC')) c.onfocus=TJVNAGXDHC_OnFocus;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
}
function SetLastFocusedOnParent() {
// used only in child entities
}
function DoUpdate(p_bResult) {
Calculate();
SaveDependsOn();
SetControlsValue();
SetDynamicClasses();
SetDynamicTooltip();
EnableControlsUnderCondition();
SaveLabelDependsOn();
if ( ! (p_bResult)) {
DisplayErrorMessage();
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.otherwise={"page_1":["MEXFGSWICI"]};
function Help() {
windowOpenForeground('../doc/aprg_new_opextrbo_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
function DeclareWVs() {
var a = arguments;
w_annorif=a[0];
w_dataope=a[1];
w_txtnote=a[2];
w_nummov=a[3];
w_impsaldo=a[4];
w_codval=a[5];
w_CONNES=a[6];
w_xdesval=a[7];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('aprg_new_opextrbo',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function DisplayErrorMessage() {
if (Le(m_nLastError,-1)) {
return;
}
if (Eq(typeof(m_cErrorInChild),'undefined') || Empty(m_cErrorInChild)) {
var l_cErrorMsg = m_cLastMsgError;
if (Eq(l_cErrorMsg,'')) {
if (Eq(m_nLastError,1)) {
l_cErrorMsg='MSG_OBBLI_FIELD';
} else if (Eq(m_nLastError,2)) {
l_cErrorMsg='MSG_VALUE_NOT_ALLOWED';
} else if (Eq(m_nLastError,3)) {
l_cErrorMsg='MSG_VALUE_NOT_ALLOWED';
} else {
l_cErrorMsg='MSG_UNSPEC_ERROR';
}
}
if (Eq(m_nLastError,1)) {
WindowAlert(Translate(m_cObblFieldName)+' : '+Translate(l_cErrorMsg));
} else {
if (Eq(l_cErrorMsg,'MSG_VALUE_NOT_ALLOWED') && Ne(m_cLastWorkVarErrorMsg,'')) {
WindowAlert(Translate(m_cLastWorkVarErrorMsg)+': '+Translate(l_cErrorMsg));
} else {
WindowAlert(Translate(l_cErrorMsg));
}
}
if (Ne(m_cLastWorkVarError,'')) {
SetControlFocus(m_cLastWorkVarError);
SetErrorField(m_cLastWorkVarError,true);
m_cLastWorkVarError='';
}
} else if (Ne(typeof('DisplayErrorMessage_'+m_cErrorInChild),'undefined')) {
DisplayErrorMessageOfChild(m_cErrorInChild);
}
}
function ResetErrorVars() {
m_nLastError=0;
m_cLastMsgError='';
m_cLastWorkVarError='';
m_cLastWorkVarErrorMsg='';
m_cErrorInChild='';
}
function EnableControlsUnderCondition() {
var l_bEnabled = true;
// * --- Area Manuale = UI - Enable Controls Init
// * --- Fine Area Manuale
if (Ne(typeof(tabs),'undefined')) {
tabs.CheckTabStrip();
}
DisableUI();
HideControlsUnderCondition();
ObligatoryControlsUnderCondition();
// * --- Area Manuale = UI - Enable Controls End
// * --- Fine Area Manuale
}
function ObligatoryControlsUnderCondition() {
var l_bObligatory = true;
}
function SetDynamicClasses() {
var c;
}
function SetDynamicTooltip() {
var c;
}
function SetSectionsHeight(id,m_nCurrentRow) {
}
function AdjustOnResize() {
var i = 0;
while (Lt(i,m_nRows)) {
i=i+1;
}
}
function InitVariables() {
}
function Set_annorif(ctrlValue,kmode,e) {
if (Ne(w_annorif,ctrlValue)) {
var ctl = _GetCtl(e,'MEXFGSWICI');
if (_tracker.goon(ctl,ctrlValue)) {
w_annorif=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MEXFGSWICI',0);
if (l_bResult) {
l_bResult=arfn_verify_opex(w_CONNES,w_annorif);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='965977510';
m_cLastMsgError=AlertErrorMessage('1164410876');
}
if ( ! (l_bResult)) {
w_annorif=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',4,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_dataope(ctrlValue,kmode,e) {
if (Ne(w_dataope,ctrlValue)) {
var ctl = _GetCtl(e,'PYGHSMNTBK');
if (_tracker.goon(ctl,ctrlValue)) {
w_dataope=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PYGHSMNTBK',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_txtnote(ctrlValue,kmode,e) {
if (Ne(w_txtnote,ctrlValue)) {
var ctl = _GetCtl(e,'MVMKKHKTPS');
if (_tracker.goon(ctl,ctrlValue)) {
w_txtnote=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MVMKKHKTPS',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',50,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_nummov(ctrlValue,kmode,e) {
if (Ne(w_nummov,ctrlValue)) {
var ctl = _GetCtl(e,'SJSORASFDD');
if (_tracker.goon(ctl,ctrlValue)) {
w_nummov=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SJSORASFDD',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_impsaldo(ctrlValue,kmode,e) {
if (Ne(w_impsaldo,ctrlValue)) {
var ctl = _GetCtl(e,'XVLXTTNQKE');
if (_tracker.goon(ctl,ctrlValue)) {
w_impsaldo=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XVLXTTNQKE',0);
DoUpdate(l_bResult);
if(c=Ctrl('XVLXTTNQKE')) c.value = WtH(w_impsaldo,'N',17,0,'99,999,999,999,999,999')
} else {
ctl.value=WtH('','N',17,0,'99999999999999999');
_ResetTracker();
return true;
}
} else {
if(c=Ctrl('XVLXTTNQKE')) c.value = WtH(w_impsaldo,'N',17,0,'99,999,999,999,999,999')
}
return true;
}
function Set_codval(ctrlValue,kmode,e) {
if (Ne(w_codval,ctrlValue)) {
var ctl = _GetCtl(e,'LRGJFQVRXS');
if (_tracker.goon(ctl,ctrlValue)) {
w_codval=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LRGJFQVRXS',0);
if (l_bResult) {
l_bResult=Link_LRGJFQVRXS(kmode);
if ( ! (l_bResult)) {
w_codval=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',3,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',3,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CONNES(ctrlValue,kmode,e) {
if (Ne(w_CONNES,ctrlValue)) {
var ctl = _GetCtl(e,'TJVNAGXDHC');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNES=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TJVNAGXDHC',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',16,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function Link_LRGJFQVRXS(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_codval);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODVAL',w_codval,3,0);
l_Appl.SetFields('CODVAL,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbvalute');
l_Appl.SetID('LRGJFQVRXS');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_codval=l_Appl.GetStringValue('CODVAL',3,0);
w_xdesval=l_Appl.GetStringValue('DESCRI',45,0);
} else {
Link_LRGJFQVRXS_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_LRGJFQVRXS';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_LRGJFQVRXS();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
l_cLinkUrl='../servlet/SPVisualZoom'+'?m_cWv='+URLenc(l_oWv.asString());
layerOpenForeground(l_cLinkUrl,openername,'toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes');
m_nLastError=-2;
} else {
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
}
return l_bResult;
}
function Link_LRGJFQVRXS_Blank() {
w_codval='';
w_xdesval='';
}
function LOpt_LRGJFQVRXS() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbvalute','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODVAL','C'));
l_oWv.setValue('LinkedField',WtA('CODVAL','C'));
l_oWv.setValue('UID',WtA('LRGJFQVRXS','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['LRGJFQVRXS'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('114016870'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'LRGJFQVRXS')) {
last_focused_comp=GetLastFocusedElementOfLink('LRGJFQVRXS');
function SetMethod_LRGJFQVRXS() {
Set_codval(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_LRGJFQVRXS();
} else {
setTimeout(SetMethod_LRGJFQVRXS,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'LRGJFQVRXS')) {
return [Ctrl('LRGJFQVRXS')];
}
}
function SendData(formaction,url,data) {
if (Eq(m_bAlreadySubmitted,true)) {
WindowAlert(Translate('MSG_SERVER_DATA'));
return;
}
var Frm = document.FSender;
var bResult = true;
if (Eq(formaction,'discard')) {
return;
}
if ((Ne(formaction,'next') && Ne(formaction,'previous') && Ne(formaction,'save')) || CheckRow()) {
SubmitForm(formaction,url,data);
} else {
DoUpdate(false);
}
}
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if (( ! (_ChkObl('MEXFGSWICI',1))) || ( ! (arfn_verify_opex(w_CONNES,w_annorif)))) {
_SignErr('MEXFGSWICI','1164410876');
l_bResult=false;
w_annorif=HtW('','C');
} else if ( ! (_ChkObl('PYGHSMNTBK',1))) {
_SignErr('PYGHSMNTBK');
m_cLastWorkVarErrorMsg='829201110';
l_bResult=false;
w_dataope=HtW('','D');
} else if ( ! (_ChkObl('MVMKKHKTPS',1))) {
_SignErr('MVMKKHKTPS');
m_cLastWorkVarErrorMsg='445246';
l_bResult=false;
w_txtnote=HtW('','C');
} else if ( ! (_ChkObl('SJSORASFDD',1))) {
_SignErr('SJSORASFDD');
m_cLastWorkVarErrorMsg='1878793056';
l_bResult=false;
w_nummov=HtW('','N');
} else if ( ! (_ChkObl('XVLXTTNQKE',1))) {
_SignErr('XVLXTTNQKE');
m_cLastWorkVarErrorMsg='1999575420';
l_bResult=false;
w_impsaldo=HtW('','N');
} else if ( ! (_ChkObl('LRGJFQVRXS',1))) {
_SignErr('LRGJFQVRXS');
m_cLastWorkVarErrorMsg='10615624819';
l_bResult=false;
w_codval=HtW('','C');
} else if ( ! (_ChkObl('TJVNAGXDHC',1))) {
_SignErr('TJVNAGXDHC');
m_cLastWorkVarErrorMsg='CONNES';
l_bResult=false;
w_CONNES=HtW('','C');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('LRGJFQVRXS_ZOOM',lc)) {
return 0;
}
if (Eq('LRGJFQVRXS',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_LRGJFQVRXS();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('annorif',WtA(w_annorif,'C'));
l_oWv.setValue('dataope',WtA(w_dataope,'D'));
l_oWv.setValue('txtnote',WtA(w_txtnote,'C'));
l_oWv.setValue('nummov',WtA(w_nummov,'N'));
l_oWv.setValue('impsaldo',WtA(w_impsaldo,'N'));
l_oWv.setValue('codval',WtA(w_codval,'C'));
l_oWv.setValue('CONNES',WtA(w_CONNES,'C'));
l_oWv.setValue('xdesval',WtA(w_xdesval,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["annorif","dataope","txtnote","nummov","impsaldo","codval","CONNES","xdesval"];
function SetModified(bRepeated) {
m_bUpdated=true;
if (bRepeated) {
if (Le(m_nCurrentRow,m_oTrsFW.length)) {
m_nRowStatus=1;
}
}
}
function initNoLocalVars(start,pseq) {
if (IsWndAccessible(opener)) {
if (start) {
if (Empty(w_annorif) && Ne(opener.w_annorif,null)) {
TransferBetweenWindows(opener,'w_annorif',null,'Set_annorif');
}
if (Empty(w_dataope) && Ne(opener.w_dataope,null)) {
TransferBetweenWindows(opener,'w_dataope',null,'Set_dataope');
}
if (Empty(w_txtnote) && Ne(opener.w_txtnote,null)) {
TransferBetweenWindows(opener,'w_txtnote',null,'Set_txtnote');
}
if (Empty(w_nummov) && Ne(opener.w_nummov,null)) {
TransferBetweenWindows(opener,'w_nummov',null,'Set_nummov');
}
if (Empty(w_impsaldo) && Ne(opener.w_impsaldo,null)) {
TransferBetweenWindows(opener,'w_impsaldo',null,'Set_impsaldo');
}
if (Empty(w_codval) && Ne(opener.w_codval,null)) {
TransferBetweenWindows(opener,'w_codval',null,'Set_codval');
}
if (Empty(w_CONNES) && Ne(opener.w_CONNES,null)) {
TransferBetweenWindows(opener,'w_CONNES',null,'Set_CONNES');
}
}
}
m_bCalculating=true;
Link_LRGJFQVRXS(null);
m_bCalculating=false;
SaveDependsOn();
SetControlsValue();
EnableControlsUnderCondition();
SaveLabelDependsOn();
DoUpdate(true);
var l_oCaller;
if (IsWndAccessible(l_oCaller)) {
var xAccessErr; try{l_oCaller.Ctrl;}catch(e){xAccessErr=1;} //IE security access error
if ( ! (xAccessErr) && Ne(typeof(l_oCaller.Ctrl),'undefined') && Ne(l_oCaller.Ctrl('FSender'),null) && Ne(typeof(l_oCaller.Ctrl('FSender').m_cOldCPCCCHK),'undefined')) {
m_cCPCCCHK=l_oCaller.Ctrl('FSender').m_cOldCPCCCHK.value;
}
}
}
function CheckRow() {
var l_bResult = true;
ResetErrorVars();
if (Lt(m_nCurrentRow,m_nRows)) {
}
return l_bResult;
}
_Obli('annorif',0,'MEXFGSWICI',false,"965977510")
_Obli('dataope',2,'PYGHSMNTBK',false,"829201110")
_Obli('txtnote',0,'MVMKKHKTPS',false,"445246")
_Obli('nummov',1,'SJSORASFDD',false,"1878793056")
_Obli('impsaldo',1,'XVLXTTNQKE',false,"1999575420")
_Obli('codval',0,'LRGJFQVRXS',false,"10615624819")
_Obli('CONNES',0,'TJVNAGXDHC',false)
