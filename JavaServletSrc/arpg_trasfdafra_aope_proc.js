function SetControlsValue() {
var c;
var c;
if(c=Ctrl('ZKFMYNWIHS')) c.value = WtH(w_numgio,'N',2,0,'99')
if(c=Ctrl('DPKVLWHCIG')) c.value = WtH(w_ADatOpe,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('FIAJYROYOB')) ChkboxCheckUncheck(c,'S',w_flgdel)
if(c=Ctrl('FIAJYROYOB')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('DDNRZXUWRD')) c.value = WtH(w_DaDatOpe,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
var tmp_TYIWXFLLFY = ToHTag(AsControlValue('<iframe width=\'750\' height=\'400\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_TYIWXFLLFY,tmp_TYIWXFLLFY)) {
if(c=Ctrl('TYIWXFLLFY')) c.innerHTML=tmp_TYIWXFLLFY;
e_TYIWXFLLFY=tmp_TYIWXFLLFY;
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
HideUI();
}
HideUI.lblids["ADatOpe"]=['LEOXCMDAMB'];
HideUI.lblids["DaDatOpe"]=['FAFOJNJJXI'];
HideUI.lblids["numgio"]=['SEBDBFIOVZ'];
function DPKVLWHCIG_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('DPKVLWHCIG'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('DPKVLWHCIG').value=ApplyPictureToDate(Ctrl('DPKVLWHCIG').value,TranslatePicture(datePattern),'DPKVLWHCIG');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('DPKVLWHCIG'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('DPKVLWHCIG');
}
}
}
SetActiveField(Ctrl('DPKVLWHCIG'),false);
e=(Ne(e,null)?e:window.event);
return Set_ADatOpe(HtW(Ctrl('DPKVLWHCIG').value,'D'),null,e) && dateisok;
}
function DPKVLWHCIG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DPKVLWHCIG'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('DPKVLWHCIG').value=WtH(w_ADatOpe,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('DPKVLWHCIG');
SetActiveField(Ctrl('DPKVLWHCIG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DPKVLWHCIG'),e);
}
function DPKVLWHCIG_ZOOM_Click() {
LaunchCalendar(Ctrl('DPKVLWHCIG'));
}
function href_TLMOPHOHJY() {
SetLocationHref(null,'arrt_trasfdafra_aoped_stp'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function FIAJYROYOB_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgdel(ChkboxValueAssign(Ctrl('FIAJYROYOB'),'S','N','C',1,0,''),null,e);
}
function FIAJYROYOB_OnFocus(e) {
SetActiveField(Ctrl('FIAJYROYOB'),true);
}
function FIAJYROYOB_OnBlur(e) {
SetActiveField(Ctrl('FIAJYROYOB'),false);
}
function href_BRZJBIMUYF() {
SetLocationHref(null,'arrt_trasfdafra_aoped'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('DPKVLWHCIG')) c.onblur=DPKVLWHCIG_Valid;
if(c=Ctrl('DPKVLWHCIG')) c.onfocus=DPKVLWHCIG_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('DPKVLWHCIG')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('FIAJYROYOB')) c.onclick=FIAJYROYOB_Valid;
if(c=Ctrl('FIAJYROYOB')) c.onfocus=FIAJYROYOB_OnFocus;
if(c=Ctrl('FIAJYROYOB')) c.onblur=FIAJYROYOB_OnBlur;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_trasfdafra_aope_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_trasfdafra_aope_'+Strtran(p_cEvent,' ','_'));
}
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
FocusFirstComponent.otherwise={"page_1":["DPKVLWHCIG"]};
function Help() {
windowOpenForeground('../doc/arpg_trasfdafra_aope_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_numgio=a[0];
w_ADatOpe=a[1];
w_msgtxt=a[2];
w_valelab=a[3];
w_flgdel=a[4];
w_DaDatOpe=a[5];
w_gIntemediario=a[6];
w_xLIMITE20=a[7];
o_gIntemediario=w_gIntemediario[1];
w_gIntemediario=w_gIntemediario[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_trasfdafra_aope',m_cSelectedPage);
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
function Set_ADatOpe(ctrlValue,kmode,e) {
if (Ne(w_ADatOpe,ctrlValue)) {
var ctl = _GetCtl(e,'DPKVLWHCIG');
if (_tracker.goon(ctl,ctrlValue)) {
w_ADatOpe=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DPKVLWHCIG',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgdel(ctrlValue,kmode,e) {
if (Ne(w_flgdel,ctrlValue)) {
var ctl = _GetCtl(e,'FIAJYROYOB');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgdel=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FIAJYROYOB',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
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
w_numgio=7;
w_DaDatOpe=( ! (Empty(w_ADatOpe))?arfn_dateminus(w_ADatOpe,w_numgio-1):NullDate());
if ((Ne(o_gIntemediario,w_gIntemediario))) {
l_bTmpRes=Link_BAUGPXCQMW(null);
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
o_gIntemediario=w_gIntemediario;
}
function SaveLabelDependsOn() {
}
function Link_BAUGPXCQMW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_gIntemediario);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODINTER',w_gIntemediario,11,0);
l_Appl.SetFields('CODINTER,FRAZDEL,LIMITE20');
l_Appl.SetTypes('C,C,D');
l_Appl.LinkTable('intermbo');
l_Appl.SetLinkzoom('armt_intermbo');
l_Appl.SetID('BAUGPXCQMW');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_gIntemediario=l_Appl.GetStringValue('CODINTER',11,0);
w_flgdel=l_Appl.GetStringValue('FRAZDEL',1,0);
w_xLIMITE20=l_Appl.GetDateValue('LIMITE20',8,0);
w_xLIMITE20=DateFromApplet(w_xLIMITE20);
} else {
Link_BAUGPXCQMW_Blank();
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
return l_bResult;
}
function Link_BAUGPXCQMW_Blank() {
w_gIntemediario='';
w_flgdel='';
w_xLIMITE20=NullDate();
}
function LOpt_BAUGPXCQMW() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('intermbo','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_intermbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODINTER','C'));
l_oWv.setValue('LinkedField',WtA('CODINTER','C'));
l_oWv.setValue('UID',WtA('BAUGPXCQMW','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['BAUGPXCQMW'][1],'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
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
if ( ! (_ChkObl('DPKVLWHCIG',1))) {
_SignErr('DPKVLWHCIG','1899181237');
l_bResult=false;
w_ADatOpe=HtW('','D');
} else if ( ! (_ChkObl('FIAJYROYOB',1))) {
_SignErr('FIAJYROYOB');
m_cLastWorkVarErrorMsg='flgdel';
l_bResult=false;
w_flgdel='N';
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('DPKVLWHCIG_ZOOM',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('numgio',WtA(w_numgio,'N'));
l_oWv.setValue('ADatOpe',WtA(w_ADatOpe,'D'));
l_oWv.setValue('msgtxt',WtA(w_msgtxt,'C'));
l_oWv.setValue('valelab',WtA(w_valelab,'N'));
l_oWv.setValue('flgdel',WtA(w_flgdel,'C'));
l_oWv.setValue('DaDatOpe',WtA(w_DaDatOpe,'D'));
l_oWv.setValue('gIntemediario',WtA(w_gIntemediario,'C'));
l_oWv.setValue('xLIMITE20',WtA(w_xLIMITE20,'D'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["numgio","ADatOpe","msgtxt","valelab","flgdel","DaDatOpe","gIntemediario","xLIMITE20"];
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
if (Empty(w_ADatOpe) && Ne(opener.w_ADatOpe,null)) {
TransferBetweenWindows(opener,'w_ADatOpe',null,'Set_ADatOpe');
}
if (Empty(w_msgtxt) && Ne(opener.w_msgtxt,null)) {
TransferBetweenWindows(opener,'w_msgtxt','w_msgtxt');
}
if (Eq(w_valelab,0) && Ne(opener.w_valelab,null)) {
TransferBetweenWindows(opener,'w_valelab','w_valelab');
}
if (Empty(w_DaDatOpe) && Ne(opener.w_DaDatOpe,null)) {
TransferBetweenWindows(opener,'w_DaDatOpe','w_DaDatOpe');
}
}
}
m_bCalculating=true;
w_numgio=7;
if (start && Eq(At(',valelab,',pseq),0)) {
w_valelab=0;
}
if (start && Eq(At(',flgdel,',pseq),0)) {
w_flgdel='N';
}
w_DaDatOpe=( ! (Empty(w_ADatOpe))?arfn_dateminus(w_ADatOpe,w_numgio-1):NullDate());
Link_BAUGPXCQMW(null);
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
_Obli('ADatOpe',2,'DPKVLWHCIG',false)
_Obli('flgdel',0,'FIAJYROYOB',false)
