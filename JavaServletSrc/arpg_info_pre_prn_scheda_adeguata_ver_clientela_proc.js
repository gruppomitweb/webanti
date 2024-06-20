function SetControlsValue() {
var c;
var c;
if(c=Ctrl('HNOHSVFLOQ')) ChkboxCheckUncheck(c,1,w_mpa)
if(c=Ctrl('HNOHSVFLOQ')) ChkboxValueAssign(c,1,0,'N',1,0,'')
if(c=Ctrl('GMCWGKWJAP')) selectRadio(c,w_neo,'N')
if(c=Ctrl('DWLJVFRPWC')) ChkboxCheckUncheck(c,1,w_ana)
if(c=Ctrl('DWLJVFRPWC')) ChkboxValueAssign(c,1,0,'N',1,0,'')
if(c=Ctrl('QCPAGAIRIU')) c.value = WtH(w_cod,'C',16,0,'')
var tmp_YRBRMQSERG = ToHTag(AsControlValue('Indicare il legale Rappresentante della societ\xe0 '+w_RAGSOCM+':'));
if (Ne(e_YRBRMQSERG,tmp_YRBRMQSERG)) {
if(c=Ctrl('YRBRMQSERG')) c.innerHTML=tmp_YRBRMQSERG;
e_YRBRMQSERG=tmp_YRBRMQSERG;
}
var tmp_TXJKEDTKOL = ToHTag(AsControlValue(w_xragisoc));
if (Ne(e_TXJKEDTKOL,tmp_TXJKEDTKOL)) {
if(c=Ctrl('TXJKEDTKOL')) c.innerHTML=tmp_TXJKEDTKOL;
e_TXJKEDTKOL=tmp_TXJKEDTKOL;
}
if(c=Ctrl('DWNCHDOZIE')) ChkboxCheckUncheck(c,1,w_vcam)
if(c=Ctrl('DWNCHDOZIE')) ChkboxValueAssign(c,1,0,'N',1,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay('MTKUDOZPWO_DIV',Eq(w_mpa,1));
SetDisplay('GMCWGKWJAP_DIV',Eq(w_mpa,1));
SetDisplay('DWLJVFRPWC_DIV',Eq(w_mpa,1));
SetDisplay(Ctrl('QCPAGAIRIU'), ! (Empty(w_SESSO)) || Eq(w_mpa,1) || IsHiddenByStateDriver('cod'));
SetDisplay(Ctrl('QCPAGAIRIU_ZOOM'), ! (Empty(w_SESSO)) || Eq(w_mpa,1));
SetDisplay(Ctrl('YRBRMQSERG'), ! (Empty(w_SESSO)) || Eq(w_mpa,1));
SetDisplay(Ctrl('TXJKEDTKOL'), ! (Empty(w_SESSO)) || Eq(w_mpa,1));
SetDisplay('DWNCHDOZIE_DIV', ! (Eq(w_CFESTERO,0) && Eq(Len(LRTrim(w_CODFISC)),16) &&  ! (Empty(w_PARTIVA))) &&  ! (Empty(w_SESSO)));
HideUI();
}
function HNOHSVFLOQ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_mpa(ChkboxValueAssign(Ctrl('HNOHSVFLOQ'),1,0,'N',1,0,''),null,e);
}
function HNOHSVFLOQ_OnFocus(e) {
SetActiveField(Ctrl('HNOHSVFLOQ'),true);
}
function HNOHSVFLOQ_OnBlur(e) {
SetActiveField(Ctrl('HNOHSVFLOQ'),false);
}
function GMCWGKWJAP_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_neo(HtW(getRadioValue(Ctrl('GMCWGKWJAP')),'N'),null,e);
}
function DWLJVFRPWC_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_ana(ChkboxValueAssign(Ctrl('DWLJVFRPWC'),1,0,'N',1,0,''),null,e);
}
function DWLJVFRPWC_OnFocus(e) {
SetActiveField(Ctrl('DWLJVFRPWC'),true);
}
function DWLJVFRPWC_OnBlur(e) {
SetActiveField(Ctrl('DWLJVFRPWC'),false);
}
function QCPAGAIRIU_Valid(e) {
SetActiveField(Ctrl('QCPAGAIRIU'),false);
e=(Ne(e,null)?e:window.event);
return Set_cod(HtW(Ctrl('QCPAGAIRIU').value,'C'),null,e);
}
function QCPAGAIRIU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QCPAGAIRIU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QCPAGAIRIU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QCPAGAIRIU'),e);
}
function QCPAGAIRIU_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('QCPAGAIRIU')),'linkview_QCPAGAIRIU','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function href_AAQUHMAIVT() {
if ( ! (Empty(w_cod))) {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('CONNES',AsAppletValue(w_CONNES));
SetHypPar('CONNESLEG',AsAppletValue(w_cod));
SetHypPar('m_cParameterSequence',AsAppletValue('CONNES,CONNESLEG'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_stp_scheda_di_verifica']));
SendData('start','arrt_stp_scheda_di_verifica'+'',HParApplet().asString());
}
}
function DWNCHDOZIE_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_vcam(ChkboxValueAssign(Ctrl('DWNCHDOZIE'),1,0,'N',1,0,''),null,e);
}
function DWNCHDOZIE_OnFocus(e) {
SetActiveField(Ctrl('DWNCHDOZIE'),true);
}
function DWNCHDOZIE_OnBlur(e) {
SetActiveField(Ctrl('DWNCHDOZIE'),false);
}
function href_SEPYAQKCQK() {
window.close()
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('HNOHSVFLOQ')) c.onclick=HNOHSVFLOQ_Valid;
if(c=Ctrl('HNOHSVFLOQ')) c.onfocus=HNOHSVFLOQ_OnFocus;
if(c=Ctrl('HNOHSVFLOQ')) c.onblur=HNOHSVFLOQ_OnBlur;
c=Ctrl('GMCWGKWJAP');
if ( ! (Empty(c))) {
c[0].onclick=GMCWGKWJAP_Valid;
c[1].onclick=GMCWGKWJAP_Valid;
}
if(c=Ctrl('DWLJVFRPWC')) c.onclick=DWLJVFRPWC_Valid;
if(c=Ctrl('DWLJVFRPWC')) c.onfocus=DWLJVFRPWC_OnFocus;
if(c=Ctrl('DWLJVFRPWC')) c.onblur=DWLJVFRPWC_OnBlur;
if(c=Ctrl('QCPAGAIRIU')) c.onblur=QCPAGAIRIU_Valid;
if(c=Ctrl('QCPAGAIRIU')) c.onfocus=QCPAGAIRIU_OnFocus;
if(c=Ctrl('DWNCHDOZIE')) c.onclick=DWNCHDOZIE_Valid;
if(c=Ctrl('DWNCHDOZIE')) c.onfocus=DWNCHDOZIE_OnFocus;
if(c=Ctrl('DWNCHDOZIE')) c.onblur=DWNCHDOZIE_OnBlur;
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
FocusFirstComponent.otherwise={"page_1":["HNOHSVFLOQ"]};
function Help() {
windowOpenForeground('../doc/arpg_info_pre_prn_scheda_adeguata_ver_clientela_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_mpa=a[0];
w_neo=a[1];
w_ana=a[2];
w_cod=a[3];
w_SESSO=a[4];
w_xragisoc=a[5];
w_RAGSOCM=a[6];
w_CONNES=a[7];
w_CFESTERO=a[8];
w_CODFISC=a[9];
w_PARTIVA=a[10];
w_vcam=a[11];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_info_pre_prn_scheda_adeguata_ver_clientela',m_cSelectedPage);
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
l_bEnabled= ! ( ! (Empty(w_cod)));
SetDisabled(Ctrl('AAQUHMAIVT'),l_bEnabled);
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
function Set_mpa(ctrlValue,kmode,e) {
if (Ne(w_mpa,ctrlValue)) {
var ctl = _GetCtl(e,'HNOHSVFLOQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_mpa=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HNOHSVFLOQ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_neo(ctrlValue,kmode,e) {
if (Ne(w_neo,ctrlValue)) {
var ctl = _GetCtl(e,'GMCWGKWJAP');
if (_tracker.goon(ctl,ctrlValue)) {
w_neo=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GMCWGKWJAP',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ana(ctrlValue,kmode,e) {
if (Ne(w_ana,ctrlValue)) {
var ctl = _GetCtl(e,'DWLJVFRPWC');
if (_tracker.goon(ctl,ctrlValue)) {
w_ana=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DWLJVFRPWC',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_cod(ctrlValue,kmode,e) {
if (Ne(w_cod,ctrlValue)) {
var ctl = _GetCtl(e,'QCPAGAIRIU');
if (_tracker.goon(ctl,ctrlValue)) {
w_cod=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QCPAGAIRIU',0);
if (l_bResult) {
l_bResult=Link_QCPAGAIRIU(kmode);
if ( ! (l_bResult)) {
w_cod=HtW('','C');
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
function Set_vcam(ctrlValue,kmode,e) {
if (Ne(w_vcam,ctrlValue)) {
var ctl = _GetCtl(e,'DWNCHDOZIE');
if (_tracker.goon(ctl,ctrlValue)) {
w_vcam=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DWNCHDOZIE',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(0,'N',1,0,'');
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
function Link_QCPAGAIRIU(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_cod);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_cod,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetLinkzoom('armt_personbo');
l_Appl.SetID('QCPAGAIRIU');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_cod=l_Appl.GetStringValue('CONNES',16,0);
w_xragisoc=l_Appl.GetStringValue('RAGSOC',70,0);
} else {
Link_QCPAGAIRIU_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_QCPAGAIRIU';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_QCPAGAIRIU();
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
function Link_QCPAGAIRIU_Blank() {
w_cod='';
w_xragisoc='';
}
function LOpt_QCPAGAIRIU() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('QCPAGAIRIU','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QCPAGAIRIU'][1],'C'));
l_oWv.setValue('Caption','Selezione legale rappresentante della socit\xe0 '+w_RAGSOCM);
l_oWv.setValue('ConfigName',WtA('pers_fisiche','C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'QCPAGAIRIU')) {
last_focused_comp=GetLastFocusedElementOfLink('QCPAGAIRIU');
function SetMethod_QCPAGAIRIU() {
Set_cod(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_QCPAGAIRIU();
} else {
setTimeout(SetMethod_QCPAGAIRIU,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'QCPAGAIRIU')) {
return [Ctrl('QCPAGAIRIU')];
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
if ( ! (_ChkObl('HNOHSVFLOQ',1))) {
_SignErr('HNOHSVFLOQ');
m_cLastWorkVarErrorMsg='12038347288';
l_bResult=false;
w_mpa=0;
} else if ( ! (_ChkObl('GMCWGKWJAP',1))) {
_SignErr('GMCWGKWJAP');
m_cLastWorkVarErrorMsg='neo';
l_bResult=false;
w_neo=HtW('','N');
} else if ( ! (_ChkObl('DWLJVFRPWC',1))) {
_SignErr('DWLJVFRPWC');
m_cLastWorkVarErrorMsg='809926818';
l_bResult=false;
w_ana=0;
} else if ( ! (_ChkObl('QCPAGAIRIU',1))) {
_SignErr('QCPAGAIRIU');
m_cLastWorkVarErrorMsg='cod';
l_bResult=false;
w_cod=HtW('','C');
} else if ( ! (_ChkObl('DWNCHDOZIE',1))) {
_SignErr('DWNCHDOZIE');
m_cLastWorkVarErrorMsg='vcam';
l_bResult=false;
w_vcam=0;
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('QCPAGAIRIU_ZOOM',lc)) {
return 0;
}
if (Eq('QCPAGAIRIU',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_QCPAGAIRIU();
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
l_oWv.setValue('mpa',WtA(w_mpa,'N'));
l_oWv.setValue('neo',WtA(w_neo,'N'));
l_oWv.setValue('ana',WtA(w_ana,'N'));
l_oWv.setValue('cod',WtA(w_cod,'C'));
l_oWv.setValue('SESSO',WtA(w_SESSO,'C'));
l_oWv.setValue('xragisoc',WtA(w_xragisoc,'C'));
l_oWv.setValue('RAGSOCM',WtA(w_RAGSOCM,'C'));
l_oWv.setValue('CONNES',WtA(w_CONNES,'C'));
l_oWv.setValue('CFESTERO',WtA(w_CFESTERO,'N'));
l_oWv.setValue('CODFISC',WtA(w_CODFISC,'C'));
l_oWv.setValue('PARTIVA',WtA(w_PARTIVA,'C'));
l_oWv.setValue('vcam',WtA(w_vcam,'N'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["mpa","neo","ana","cod","SESSO","xragisoc","RAGSOCM","CONNES","CFESTERO","CODFISC","PARTIVA","vcam"];
function SetModified(bRepeated) {
m_bUpdated=true;
if (bRepeated) {
if (Le(m_nCurrentRow,m_oTrsFW.length)) {
m_nRowStatus=1;
}
}
}
function initNoLocalVars(start,pseq) {
m_bCalculating=true;
if (start && Eq(At(',mpa,',pseq),0)) {
w_mpa=0;
}
if (start && Eq(At(',neo,',pseq),0)) {
w_neo=0;
}
if (start && Eq(At(',ana,',pseq),0)) {
w_ana=0;
}
Link_QCPAGAIRIU(null);
if (start && Eq(At(',vcam,',pseq),0)) {
w_vcam=0;
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
_Obli('mpa',1,'HNOHSVFLOQ',false,"12038347288")
_Obli('neo',1,'GMCWGKWJAP',false)
_Obli('ana',1,'DWLJVFRPWC',false,"809926818")
_Obli('cod',0,'QCPAGAIRIU',false)
_Obli('vcam',1,'DWNCHDOZIE',false)
