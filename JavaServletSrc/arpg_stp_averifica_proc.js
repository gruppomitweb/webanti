function SetControlsValue() {
var c;
var c;
if(c=Ctrl('GZUTYTXNWO')) ChkboxCheckUncheck(c,'S',w_flgdati)
if(c=Ctrl('GZUTYTXNWO')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('WHZBZEFJJM')) ChkboxCheckUncheck(c,'S',w_flgschema)
if(c=Ctrl('WHZBZEFJJM')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('RKDVPIADNI')) selectRadio(c,w_flgtipcli,'C')
if(c=Ctrl('XBCVOUVWLB')) c.value = WtH(w_legale,'C',16,0,'')
var tmp_SAOLAFGSNJ = ToHTag(AsControlValue(w_xRAGSOC));
if (Ne(e_SAOLAFGSNJ,tmp_SAOLAFGSNJ)) {
if(c=Ctrl('SAOLAFGSNJ')) c.innerHTML=tmp_SAOLAFGSNJ;
e_SAOLAFGSNJ=tmp_SAOLAFGSNJ;
}
if(c=Ctrl('NIKKLBPCLR')) ChkboxCheckUncheck(c,'S',w_flgvisc)
if(c=Ctrl('NIKKLBPCLR')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('XBCVOUVWLB'), ! (Empty(w_SESSO)) || IsHiddenByStateDriver('legale'));
SetDisplay(Ctrl('XBCVOUVWLB_ZOOM'), ! (Empty(w_SESSO)));
SetDisplay(Ctrl('EXOUNTZJEC'), ! (Empty(w_SESSO)));
SetDisplay(Ctrl('SAOLAFGSNJ'), ! (Empty(w_SESSO)));
SetDisplay('NIKKLBPCLR_DIV',Eq(w_CFESTERO,1) || (Eq(w_CFESTERO,0) && Eq(Len(LRTrim(w_CODFISC)),16) && Empty(LRTrim(w_PIVA))) || (Eq(w_CFESTERO,0) && Ne(Len(LRTrim(w_CODFISC)),16)));
HideUI();
}
HideUI.lblids["legale"]=['EXOUNTZJEC'];
function href_GEDJGVMCKZ() {
DeleteFile()
}
function href_AJXISNWTIP() {
window.close()
}
function GZUTYTXNWO_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgdati(ChkboxValueAssign(Ctrl('GZUTYTXNWO'),'S','N','C',1,0,''),null,e);
}
function GZUTYTXNWO_OnFocus(e) {
SetActiveField(Ctrl('GZUTYTXNWO'),true);
}
function GZUTYTXNWO_OnBlur(e) {
SetActiveField(Ctrl('GZUTYTXNWO'),false);
}
function WHZBZEFJJM_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgschema(ChkboxValueAssign(Ctrl('WHZBZEFJJM'),'S','N','C',1,0,''),null,e);
}
function WHZBZEFJJM_OnFocus(e) {
SetActiveField(Ctrl('WHZBZEFJJM'),true);
}
function WHZBZEFJJM_OnBlur(e) {
SetActiveField(Ctrl('WHZBZEFJJM'),false);
}
function RKDVPIADNI_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgtipcli(HtW(getRadioValue(Ctrl('RKDVPIADNI')),'C'),null,e);
}
function XBCVOUVWLB_Valid(e) {
SetActiveField(Ctrl('XBCVOUVWLB'),false);
e=(Ne(e,null)?e:window.event);
return Set_legale(HtW(Ctrl('XBCVOUVWLB').value,'C'),null,e);
}
function XBCVOUVWLB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XBCVOUVWLB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XBCVOUVWLB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XBCVOUVWLB'),e);
}
function XBCVOUVWLB_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('XBCVOUVWLB')),'linkview_XBCVOUVWLB','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function NIKKLBPCLR_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgvisc(ChkboxValueAssign(Ctrl('NIKKLBPCLR'),'S','N','C',1,0,''),null,e);
}
function NIKKLBPCLR_OnFocus(e) {
SetActiveField(Ctrl('NIKKLBPCLR'),true);
}
function NIKKLBPCLR_OnBlur(e) {
SetActiveField(Ctrl('NIKKLBPCLR'),false);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('GZUTYTXNWO')) c.onclick=GZUTYTXNWO_Valid;
if(c=Ctrl('GZUTYTXNWO')) c.onfocus=GZUTYTXNWO_OnFocus;
if(c=Ctrl('GZUTYTXNWO')) c.onblur=GZUTYTXNWO_OnBlur;
if(c=Ctrl('WHZBZEFJJM')) c.onclick=WHZBZEFJJM_Valid;
if(c=Ctrl('WHZBZEFJJM')) c.onfocus=WHZBZEFJJM_OnFocus;
if(c=Ctrl('WHZBZEFJJM')) c.onblur=WHZBZEFJJM_OnBlur;
c=Ctrl('RKDVPIADNI');
if ( ! (Empty(c))) {
c[0].onclick=RKDVPIADNI_Valid;
c[1].onclick=RKDVPIADNI_Valid;
}
if(c=Ctrl('XBCVOUVWLB')) c.onblur=XBCVOUVWLB_Valid;
if(c=Ctrl('XBCVOUVWLB')) c.onfocus=XBCVOUVWLB_OnFocus;
if(c=Ctrl('NIKKLBPCLR')) c.onclick=NIKKLBPCLR_Valid;
if(c=Ctrl('NIKKLBPCLR')) c.onfocus=NIKKLBPCLR_OnFocus;
if(c=Ctrl('NIKKLBPCLR')) c.onblur=NIKKLBPCLR_OnBlur;
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
FocusFirstComponent.otherwise={"page_1":["GZUTYTXNWO"]};
function Help() {
windowOpenForeground('../doc/arpg_stp_averifica_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CONNES=a[0];
w_SESSO=a[1];
w_CFESTERO=a[2];
w_flgdati=a[3];
w_flgschema=a[4];
w_flgtipcli=a[5];
w_legale=a[6];
w_xRAGSOC=a[7];
w_flgvisc=a[8];
w_CODFISC=a[9];
w_PIVA=a[10];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_stp_averifica',m_cSelectedPage);
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
function Set_flgtipcli(ctrlValue,kmode,e) {
if (Ne(w_flgtipcli,ctrlValue)) {
var ctl = _GetCtl(e,'RKDVPIADNI');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgtipcli=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RKDVPIADNI',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgdati(ctrlValue,kmode,e) {
if (Ne(w_flgdati,ctrlValue)) {
var ctl = _GetCtl(e,'GZUTYTXNWO');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgdati=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GZUTYTXNWO',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgschema(ctrlValue,kmode,e) {
if (Ne(w_flgschema,ctrlValue)) {
var ctl = _GetCtl(e,'WHZBZEFJJM');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgschema=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WHZBZEFJJM',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_legale(ctrlValue,kmode,e) {
if (Ne(w_legale,ctrlValue)) {
var ctl = _GetCtl(e,'XBCVOUVWLB');
if (_tracker.goon(ctl,ctrlValue)) {
w_legale=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XBCVOUVWLB',0);
if (l_bResult) {
l_bResult=Link_XBCVOUVWLB(kmode);
if ( ! (l_bResult)) {
w_legale=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',16,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',16,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgvisc(ctrlValue,kmode,e) {
if (Ne(w_flgvisc,ctrlValue)) {
var ctl = _GetCtl(e,'NIKKLBPCLR');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgvisc=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NIKKLBPCLR',0);
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
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function Link_XBCVOUVWLB(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_legale);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_legale,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('XBCVOUVWLB');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_legale=l_Appl.GetStringValue('CONNES',16,0);
w_xRAGSOC=l_Appl.GetStringValue('RAGSOC',70,0);
} else {
Link_XBCVOUVWLB_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_XBCVOUVWLB';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_XBCVOUVWLB();
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
function Link_XBCVOUVWLB_Blank() {
w_legale='';
w_xRAGSOC='';
}
function LOpt_XBCVOUVWLB() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('XBCVOUVWLB','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['XBCVOUVWLB'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10505367639'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'XBCVOUVWLB')) {
last_focused_comp=GetLastFocusedElementOfLink('XBCVOUVWLB');
function SetMethod_XBCVOUVWLB() {
Set_legale(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_XBCVOUVWLB();
} else {
setTimeout(SetMethod_XBCVOUVWLB,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'XBCVOUVWLB')) {
return [Ctrl('XBCVOUVWLB')];
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
if ( ! (_ChkObl('GZUTYTXNWO',1))) {
_SignErr('GZUTYTXNWO');
m_cLastWorkVarErrorMsg='flgdati';
l_bResult=false;
w_flgdati='N';
} else if ( ! (_ChkObl('WHZBZEFJJM',1))) {
_SignErr('WHZBZEFJJM');
m_cLastWorkVarErrorMsg='flgschema';
l_bResult=false;
w_flgschema='N';
} else if ( ! (_ChkObl('RKDVPIADNI',1))) {
_SignErr('RKDVPIADNI');
m_cLastWorkVarErrorMsg='flgtipcli';
l_bResult=false;
w_flgtipcli=HtW('','C');
} else if ( ! (_ChkObl('XBCVOUVWLB',1))) {
_SignErr('XBCVOUVWLB');
m_cLastWorkVarErrorMsg='legale';
l_bResult=false;
w_legale=HtW('','C');
} else if ( ! (_ChkObl('NIKKLBPCLR',1))) {
_SignErr('NIKKLBPCLR');
m_cLastWorkVarErrorMsg='flgvisc';
l_bResult=false;
w_flgvisc='N';
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('XBCVOUVWLB_ZOOM',lc)) {
return 0;
}
if (Eq('XBCVOUVWLB',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_XBCVOUVWLB();
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
l_oWv.setValue('CONNES',WtA(w_CONNES,'C'));
l_oWv.setValue('SESSO',WtA(w_SESSO,'C'));
l_oWv.setValue('CFESTERO',WtA(w_CFESTERO,'N'));
l_oWv.setValue('flgdati',WtA(w_flgdati,'C'));
l_oWv.setValue('flgschema',WtA(w_flgschema,'C'));
l_oWv.setValue('flgtipcli',WtA(w_flgtipcli,'C'));
l_oWv.setValue('legale',WtA(w_legale,'C'));
l_oWv.setValue('xRAGSOC',WtA(w_xRAGSOC,'C'));
l_oWv.setValue('flgvisc',WtA(w_flgvisc,'C'));
l_oWv.setValue('CODFISC',WtA(w_CODFISC,'C'));
l_oWv.setValue('PIVA',WtA(w_PIVA,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["CONNES","SESSO","CFESTERO","flgdati","flgschema","flgtipcli","legale","xRAGSOC","flgvisc","CODFISC","PIVA"];
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
if (Empty(w_CONNES) && Ne(opener.w_CONNES,null)) {
TransferBetweenWindows(opener,'w_CONNES','w_CONNES');
}
if (Empty(w_SESSO) && Ne(opener.w_SESSO,null)) {
TransferBetweenWindows(opener,'w_SESSO','w_SESSO');
}
if (Empty(w_CFESTERO) && Ne(opener.w_CFESTERO,null)) {
TransferBetweenWindows(opener,'w_CFESTERO','w_CFESTERO');
}
if (Empty(w_CODFISC) && Ne(opener.w_CODFISC,null)) {
TransferBetweenWindows(opener,'w_CODFISC','w_CODFISC');
}
if (Empty(w_PIVA) && Ne(opener.w_PIVA,null)) {
TransferBetweenWindows(opener,'w_PIVA','w_PIVA');
}
}
}
m_bCalculating=true;
if (start && Eq(At(',flgdati,',pseq),0)) {
w_flgdati='N';
}
if (start && Eq(At(',flgschema,',pseq),0)) {
w_flgschema='N';
}
if (start && Eq(At(',flgtipcli,',pseq),0)) {
w_flgtipcli='N';
}
Link_XBCVOUVWLB(null);
if (start && Eq(At(',flgvisc,',pseq),0)) {
w_flgvisc='N';
}
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
_Obli('flgtipcli',0,'RKDVPIADNI',false)
_Obli('flgdati',0,'GZUTYTXNWO',false)
_Obli('flgschema',0,'WHZBZEFJJM',false)
_Obli('legale',0,'XBCVOUVWLB',false)
_Obli('flgvisc',0,'NIKKLBPCLR',false)
