function SetControlsValue() {
var c;
var c;
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\' name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('GTMJENMCMN')) c.value = WtH(w_anno,'N',4,0,'')
if(c=Ctrl('FSXHJAAZGG')) c.value = WtH(w_dadata,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('CLVVMIYSQG')) c.value = WtH(w_a_data,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('LNLUBIIALG')) c.value = WtH(w_fileprodotto,'C',128,0,'')
if(c=Ctrl('HNAQCEUJMB')) ChkboxCheckUncheck(c,'S',w_flgann)
if(c=Ctrl('HNAQCEUJMB')) ChkboxValueAssign(c,'S','N','C',2,0,'')
if(c=Ctrl('UCCWMDWDFX')) c.value = WtH(w_nomefile,'C',20,0,'')
var tmp_SOEEFGGSXW = ToHTag(AsControlValue('Anno Saldi: '+w_annoc));
if (Ne(e_SOEEFGGSXW,tmp_SOEEFGGSXW)) {
if(c=Ctrl('SOEEFGGSXW')) c.innerHTML=tmp_SOEEFGGSXW;
e_SOEEFGGSXW=tmp_SOEEFGGSXW;
}
if(c=Ctrl('XQBOPDZHKF')) ChkboxCheckUncheck(c,'S',w_flgsos)
if(c=Ctrl('XQBOPDZHKF')) ChkboxValueAssign(c,'S','N','C',2,0,'')
if(c=Ctrl('ORRGPKNHYL')) ChkboxCheckUncheck(c,'S',w_flg555)
if(c=Ctrl('ORRGPKNHYL')) ChkboxValueAssign(c,'S','N','C',2,0,'')
if(c=Ctrl('MQNXNCXTLE')) c.value = WtH(w_numcicli,'N',2,0,'')
if(c=Ctrl('UKCGJKFOCN')) ChkboxCheckUncheck(c,'S',w_flgope)
if(c=Ctrl('UKCGJKFOCN')) ChkboxValueAssign(c,'S','N','C',2,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
SetDisplay(Ctrl('LNLUBIIALG'),Ne(w_gFlgWU,'S') || IsHiddenByStateDriver('fileprodotto'));
SetDisplay(Ctrl('UCCWMDWDFX'),Eq(w_flgann,'N') || IsHiddenByStateDriver('nomefile'));
SetDisplay(Ctrl('UCCWMDWDFX_ZOOM'),Eq(w_flgann,'N'));
SetDisplay(Ctrl('NUXUIBOQWB'),Eq(w_flgann,'N'));
SetDisplay(Ctrl('SOEEFGGSXW'),Eq(w_flgann,'N'));
HideUI();
}
HideUI.lblids["a_data"]=['LFJQIXRRKM'];
HideUI.lblids["anno"]=['YIXZTOKOBR'];
HideUI.lblids["dadata"]=['NOYEUIKFXN'];
HideUI.lblids["nomefile"]=['NUXUIBOQWB'];
HideUI.lblids["numcicli"]=['FZUQJEOESI'];
function GTMJENMCMN_Valid(e) {
SetActiveField(Ctrl('GTMJENMCMN'),false);
e=(Ne(e,null)?e:window.event);
return Set_anno(HtW(Ctrl('GTMJENMCMN').value,'N'),null,e);
}
function GTMJENMCMN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GTMJENMCMN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GTMJENMCMN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GTMJENMCMN'),e);
}
function NMNMXABGKO_Click() {
if ( ! (Empty(w_dadata)) &&  ! (Empty(w_a_data)) && Eq(w_flg555,'N')) {
SetLocationHref(null,'arrt_cf_inviosaldi'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
}
function href_AJXISNWTIP() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function href_JBNBDKBIAJ() {
_modifyandopen(ToResource('jsp/list_filesid_portlet.jsp'+'')+'?m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=600,width=800',null)
}
function href_MPCMAMHQST() {
var l_oWv = InitWvApplet();
l_oWv.setValue('ReportName',AsAppletValue('arrp_invio_saldi'));
l_oWv.setValue('outputFormat',AsAppletValue('PDF'));
l_oWv.setValue('rotation',AsAppletValue('LANDSCAPE'));
l_oWv.setValue('DescAzi',AsAppletValue(w_gDescAzi));
l_oWv.setValue('anno',AsAppletValue(w_anno));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('ReportName,outputFormat,rotation,DescAzi,anno'));
_modifyandopen('Report'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=600,width=800',null)
}
function href_RLHBNGNSUG() {
SetLocationHref(null,'arrt_exec_sid'+'?m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','elaborazione')
}
function LNLUBIIALG_Valid(e) {
SetActiveField(Ctrl('LNLUBIIALG'),false);
e=(Ne(e,null)?e:window.event);
return Set_fileprodotto(HtW(Ctrl('LNLUBIIALG').value,'C'),null,e);
}
function LNLUBIIALG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LNLUBIIALG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LNLUBIIALG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LNLUBIIALG'),e);
}
function HNAQCEUJMB_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgann(ChkboxValueAssign(Ctrl('HNAQCEUJMB'),'S','N','C',2,0,''),null,e);
}
function HNAQCEUJMB_OnFocus(e) {
SetActiveField(Ctrl('HNAQCEUJMB'),true);
}
function HNAQCEUJMB_OnBlur(e) {
SetActiveField(Ctrl('HNAQCEUJMB'),false);
}
function UCCWMDWDFX_Valid(e) {
SetActiveField(Ctrl('UCCWMDWDFX'),false);
e=(Ne(e,null)?e:window.event);
return Set_nomefile(HtW(Ctrl('UCCWMDWDFX').value,'C'),null,e);
}
function UCCWMDWDFX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UCCWMDWDFX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UCCWMDWDFX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UCCWMDWDFX'),e);
}
function UCCWMDWDFX_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('UCCWMDWDFX')),'linkview_UCCWMDWDFX','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function XQBOPDZHKF_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgsos(ChkboxValueAssign(Ctrl('XQBOPDZHKF'),'S','N','C',2,0,''),null,e);
}
function XQBOPDZHKF_OnFocus(e) {
SetActiveField(Ctrl('XQBOPDZHKF'),true);
}
function XQBOPDZHKF_OnBlur(e) {
SetActiveField(Ctrl('XQBOPDZHKF'),false);
}
function MVMFEJNTIZ_Click() {
if (Eq(w_flg555,'S') &&  ! (Empty(w_dadata)) &&  ! (Empty(w_a_data))) {
SetLocationHref(null,'arrt_cf_saldi555'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
}
function ORRGPKNHYL_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flg555(ChkboxValueAssign(Ctrl('ORRGPKNHYL'),'S','N','C',2,0,''),null,e);
}
function ORRGPKNHYL_OnFocus(e) {
SetActiveField(Ctrl('ORRGPKNHYL'),true);
}
function ORRGPKNHYL_OnBlur(e) {
SetActiveField(Ctrl('ORRGPKNHYL'),false);
}
function UKCGJKFOCN_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgope(ChkboxValueAssign(Ctrl('UKCGJKFOCN'),'S','N','C',2,0,''),null,e);
}
function UKCGJKFOCN_OnFocus(e) {
SetActiveField(Ctrl('UKCGJKFOCN'),true);
}
function UKCGJKFOCN_OnBlur(e) {
SetActiveField(Ctrl('UKCGJKFOCN'),false);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('GTMJENMCMN')) c.onblur=GTMJENMCMN_Valid;
if(c=Ctrl('GTMJENMCMN')) c.onfocus=GTMJENMCMN_OnFocus;
if(c=Ctrl('GTMJENMCMN')) c.onkeypress=CheckNum;
if(c=Ctrl('LNLUBIIALG')) c.onblur=LNLUBIIALG_Valid;
if(c=Ctrl('LNLUBIIALG')) c.onfocus=LNLUBIIALG_OnFocus;
if(c=Ctrl('HNAQCEUJMB')) c.onclick=HNAQCEUJMB_Valid;
if(c=Ctrl('HNAQCEUJMB')) c.onfocus=HNAQCEUJMB_OnFocus;
if(c=Ctrl('HNAQCEUJMB')) c.onblur=HNAQCEUJMB_OnBlur;
if(c=Ctrl('UCCWMDWDFX')) c.onblur=UCCWMDWDFX_Valid;
if(c=Ctrl('UCCWMDWDFX')) c.onfocus=UCCWMDWDFX_OnFocus;
if(c=Ctrl('XQBOPDZHKF')) c.onclick=XQBOPDZHKF_Valid;
if(c=Ctrl('XQBOPDZHKF')) c.onfocus=XQBOPDZHKF_OnFocus;
if(c=Ctrl('XQBOPDZHKF')) c.onblur=XQBOPDZHKF_OnBlur;
if(c=Ctrl('ORRGPKNHYL')) c.onclick=ORRGPKNHYL_Valid;
if(c=Ctrl('ORRGPKNHYL')) c.onfocus=ORRGPKNHYL_OnFocus;
if(c=Ctrl('ORRGPKNHYL')) c.onblur=ORRGPKNHYL_OnBlur;
if(c=Ctrl('UKCGJKFOCN')) c.onclick=UKCGJKFOCN_Valid;
if(c=Ctrl('UKCGJKFOCN')) c.onfocus=UKCGJKFOCN_OnFocus;
if(c=Ctrl('UKCGJKFOCN')) c.onblur=UKCGJKFOCN_OnBlur;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_cf_inviosaldi_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_cf_inviosaldi_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["GTMJENMCMN"]};
function Help() {
windowOpenForeground('../doc/arpg_cf_inviosaldi_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_anno=a[0];
w_dadata=a[1];
w_a_data=a[2];
w_fileprodotto=a[3];
w_gDescAzi=a[4];
w_flgann=a[5];
w_nomefile=a[6];
w_annoc=a[7];
w_idbase=a[8];
w_flgsos=a[9];
w_flg555=a[10];
w_numcicli=a[11];
w_gFlgWU=a[12];
w_flgope=a[13];
o_nomefile=w_nomefile[1];
w_nomefile=w_nomefile[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_cf_inviosaldi',m_cSelectedPage);
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
l_bEnabled= ! ( ! (Empty(w_dadata)) &&  ! (Empty(w_a_data)) && Eq(w_flg555,'N'));
SetDisabled(Ctrl('NMNMXABGKO'),l_bEnabled);
l_bEnabled= ! (Eq(w_flgann,'S')) || IsDisabledByStateDriver('nomefile');
SetDisabled(Ctrl('UCCWMDWDFX'),l_bEnabled);
SetDisabled(Ctrl('UCCWMDWDFX_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(w_flg555,'S') &&  ! (Empty(w_dadata)) &&  ! (Empty(w_a_data)));
SetDisabled(Ctrl('MVMFEJNTIZ'),l_bEnabled);
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
function Set_anno(ctrlValue,kmode,e) {
if (Ne(w_anno,ctrlValue)) {
var ctl = _GetCtl(e,'GTMJENMCMN');
if (_tracker.goon(ctl,ctrlValue)) {
w_anno=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GTMJENMCMN',0);
if (l_bResult) {
l_bResult=Ge(w_anno,2011);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='anno';
m_cLastMsgError=AlertErrorMessage('369065168');
}
if ( ! (l_bResult)) {
w_anno=HtW('','N');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'N',4,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','N',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_nomefile(ctrlValue,kmode,e) {
if (Ne(w_nomefile,ctrlValue)) {
var ctl = _GetCtl(e,'UCCWMDWDFX');
if (_tracker.goon(ctl,ctrlValue)) {
w_nomefile=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UCCWMDWDFX',0);
if (l_bResult) {
l_bResult=Link_UCCWMDWDFX(kmode);
if ( ! (l_bResult)) {
w_nomefile=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',20,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',20,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgann(ctrlValue,kmode,e) {
if (Ne(w_flgann,ctrlValue)) {
var ctl = _GetCtl(e,'HNAQCEUJMB');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgann=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HNAQCEUJMB',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_fileprodotto(ctrlValue,kmode,e) {
if (Ne(w_fileprodotto,ctrlValue)) {
var ctl = _GetCtl(e,'LNLUBIIALG');
if (_tracker.goon(ctl,ctrlValue)) {
w_fileprodotto=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LNLUBIIALG',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',128,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flg555(ctrlValue,kmode,e) {
if (Ne(w_flg555,ctrlValue)) {
var ctl = _GetCtl(e,'ORRGPKNHYL');
if (_tracker.goon(ctl,ctrlValue)) {
w_flg555=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ORRGPKNHYL',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgope(ctrlValue,kmode,e) {
if (Ne(w_flgope,ctrlValue)) {
var ctl = _GetCtl(e,'UKCGJKFOCN');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgope=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UKCGJKFOCN',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgsos(ctrlValue,kmode,e) {
if (Ne(w_flgsos,ctrlValue)) {
var ctl = _GetCtl(e,'XQBOPDZHKF');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgsos=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XQBOPDZHKF',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',2,0,'');
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
w_dadata=CharToDate(Str(w_anno,4,0)+'0101');
w_a_data=CharToDate(Str(w_anno,4,0)+'1231');
if ((Ne(o_nomefile,w_nomefile))) {
Calculation_ZXDLHDGJXB();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function Calculation_ZXDLHDGJXB() {
w_anno=Val(w_annoc);
}
function SaveDependsOn() {
o_nomefile=w_nomefile;
}
function SaveLabelDependsOn() {
}
function Link_UCCWMDWDFX(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_nomefile);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('NOMEFILE',w_nomefile,20,0);
l_Appl.SetFields('NOMEFILE,ANNO,IDBASE');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('aesaldi');
l_Appl.SetID('UCCWMDWDFX');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_nomefile=l_Appl.GetStringValue('NOMEFILE',20,0);
w_annoc=l_Appl.GetStringValue('ANNO',4,0);
w_idbase=l_Appl.GetStringValue('IDBASE',10,0);
} else {
Link_UCCWMDWDFX_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_UCCWMDWDFX';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_UCCWMDWDFX();
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
function Link_UCCWMDWDFX_Blank() {
w_annoc='';
w_idbase='';
}
function LOpt_UCCWMDWDFX() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('aesaldi','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('NOMEFILE','C'));
l_oWv.setValue('LinkedField',WtA('NOMEFILE','C'));
l_oWv.setValue('UID',WtA('UCCWMDWDFX','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UCCWMDWDFX'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1242000219'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'UCCWMDWDFX')) {
last_focused_comp=GetLastFocusedElementOfLink('UCCWMDWDFX');
function SetMethod_UCCWMDWDFX() {
Set_nomefile(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_UCCWMDWDFX();
} else {
setTimeout(SetMethod_UCCWMDWDFX,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'UCCWMDWDFX')) {
return [Ctrl('UCCWMDWDFX')];
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
if (( ! (_ChkObl('GTMJENMCMN',1))) || ( ! (Ge(w_anno,2011)))) {
_SignErr('GTMJENMCMN','369065168');
l_bResult=false;
w_anno=HtW('','N');
} else if ( ! (_ChkObl('LNLUBIIALG',1))) {
_SignErr('LNLUBIIALG');
m_cLastWorkVarErrorMsg='fileprodotto';
l_bResult=false;
w_fileprodotto=HtW('','C');
} else if ( ! (_ChkObl('HNAQCEUJMB',1))) {
_SignErr('HNAQCEUJMB');
m_cLastWorkVarErrorMsg='flgann';
l_bResult=false;
w_flgann='N';
} else if ((Eq(w_flgann,'S')) && ( ! (_ChkObl('UCCWMDWDFX',1)))) {
_SignErr('UCCWMDWDFX');
m_cLastWorkVarErrorMsg='nomefile';
l_bResult=false;
w_nomefile=HtW('','C');
} else if ( ! (_ChkObl('XQBOPDZHKF',1))) {
_SignErr('XQBOPDZHKF');
m_cLastWorkVarErrorMsg='flgsos';
l_bResult=false;
w_flgsos='N';
} else if ( ! (_ChkObl('ORRGPKNHYL',1))) {
_SignErr('ORRGPKNHYL');
m_cLastWorkVarErrorMsg='flg555';
l_bResult=false;
w_flg555='N';
} else if ( ! (_ChkObl('UKCGJKFOCN',1))) {
_SignErr('UKCGJKFOCN');
m_cLastWorkVarErrorMsg='flgope';
l_bResult=false;
w_flgope='N';
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('UCCWMDWDFX_ZOOM',lc)) {
return 0;
}
if (Eq('UCCWMDWDFX',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_UCCWMDWDFX();
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
l_oWv.setValue('anno',WtA(w_anno,'N'));
l_oWv.setValue('dadata',WtA(w_dadata,'D'));
l_oWv.setValue('a_data',WtA(w_a_data,'D'));
l_oWv.setValue('fileprodotto',WtA(w_fileprodotto,'C'));
l_oWv.setValue('gDescAzi',WtA(w_gDescAzi,'C'));
l_oWv.setValue('flgann',WtA(w_flgann,'C'));
l_oWv.setValue('nomefile',WtA(w_nomefile,'C'));
l_oWv.setValue('annoc',WtA(w_annoc,'C'));
l_oWv.setValue('idbase',WtA(w_idbase,'C'));
l_oWv.setValue('flgsos',WtA(w_flgsos,'C'));
l_oWv.setValue('flg555',WtA(w_flg555,'C'));
l_oWv.setValue('numcicli',WtA(w_numcicli,'N'));
l_oWv.setValue('gFlgWU',WtA(w_gFlgWU,'C'));
l_oWv.setValue('flgope',WtA(w_flgope,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["anno","dadata","a_data","fileprodotto","gDescAzi","flgann","nomefile","annoc","idbase","flgsos","flg555","numcicli","gFlgWU","flgope"];
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
if (Empty(w_fileprodotto) && Ne(opener.w_fileprodotto,null)) {
TransferBetweenWindows(opener,'w_fileprodotto',null,'Set_fileprodotto');
}
if (Empty(w_nomefile) && Ne(opener.w_nomefile,null)) {
TransferBetweenWindows(opener,'w_nomefile',null,'Set_nomefile');
}
if (Empty(w_numcicli) && Ne(opener.w_numcicli,null)) {
TransferBetweenWindows(opener,'w_numcicli','w_numcicli');
}
}
}
m_bCalculating=true;
if (start && Eq(At(',anno,',pseq),0)) {
w_anno=Year(SystemDate())-1;
}
w_dadata=CharToDate(Str(w_anno,4,0)+'0101');
w_a_data=CharToDate(Str(w_anno,4,0)+'1231');
if (start && Eq(At(',flgann,',pseq),0)) {
w_flgann='N';
}
Link_UCCWMDWDFX(null);
if (start && Eq(At(',flgsos,',pseq),0)) {
w_flgsos='N';
}
if (start && Eq(At(',flg555,',pseq),0)) {
w_flg555='N';
}
if (start && Eq(At(',flgope,',pseq),0)) {
w_flgope='N';
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
_Obli('anno',1,'GTMJENMCMN',false)
_Obli('nomefile',0,'UCCWMDWDFX',false)
_Obli('flgann',0,'HNAQCEUJMB',false)
_Obli('fileprodotto',0,'LNLUBIIALG',false)
_Obli('flg555',0,'ORRGPKNHYL',false)
_Obli('flgope',0,'UKCGJKFOCN',false)
_Obli('flgsos',0,'XQBOPDZHKF',false)
