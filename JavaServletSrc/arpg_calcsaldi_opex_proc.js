function SetControlsValue() {
var c;
var c;
var tmp_UAIBAUYUDZ = ToHTag(AsControlValue(w_xdesval));
if (Ne(e_UAIBAUYUDZ,tmp_UAIBAUYUDZ)) {
if(c=Ctrl('UAIBAUYUDZ')) c.innerHTML=tmp_UAIBAUYUDZ;
e_UAIBAUYUDZ=tmp_UAIBAUYUDZ;
}
if(c=Ctrl('QJYFRLEIBB')) c.value = WtH(w_annorif,'N',4,0,'')
if(c=Ctrl('SZZYVNKOQS')) c.value = WtH(w_valuta,'C',3,0,'')
if(c=Ctrl('TPIIDTIVPT')) selectCombo(c,w_flgmod,'C')
if(c=Ctrl('NPTKUXAOKM')) ChkboxCheckUncheck(c,'S',w_flgazz)
if(c=Ctrl('NPTKUXAOKM')) ChkboxValueAssign(c,'S','N','C',1,0,'')
var tmp_TYIWXFLLFY = ToHTag(AsControlValue('<iframe width=\'750\' height=\'400\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_TYIWXFLLFY,tmp_TYIWXFLLFY)) {
if(c=Ctrl('TYIWXFLLFY')) c.innerHTML=tmp_TYIWXFLLFY;
e_TYIWXFLLFY=tmp_TYIWXFLLFY;
}
if(c=Ctrl('UNGKYHCDIF')) c.value = WtH(w_ndgcli,'C',16,0,'')
var tmp_RYYAKPKUZO = ToHTag(AsControlValue(w_xragsoc));
if (Ne(e_RYYAKPKUZO,tmp_RYYAKPKUZO)) {
if(c=Ctrl('RYYAKPKUZO')) c.innerHTML=tmp_RYYAKPKUZO;
e_RYYAKPKUZO=tmp_RYYAKPKUZO;
}
if(c=Ctrl('YBEELIFFJV')) ChkboxCheckUncheck(c,'S',w_flgmopx)
if(c=Ctrl('YBEELIFFJV')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('MAYNQUHJSS'),Empty(w_annorif) || Empty(w_valuta));
SetDisplay('YBEELIFFJV_DIV',Empty(w_ndgcli));
SetDisplay(Ctrl('JGBEHEEJHD'),true);
HideUI();
}
HideUI.lblids["annorif"]=['QJBHNDQNQE','TVAOJABIZC'];
HideUI.lblids["ndgcli"]=['OXNGQWATKR'];
HideUI.lblids["valuta"]=['QVLNYNNMIY'];
function href_MAYNQUHJSS() {
Lancio()
}
function href_LCFKHGNSPV() {
var l_oWv = InitWvApplet();
l_oWv.setValue('rotation',AsAppletValue('LANDSCAPE'));
l_oWv.setValue('w_annorif',AsAppletValue(w_annorif));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('rotation,w_annorif'));
SetLocationHref(null,'Report?ReportName='+'arrp_saldi_opex_r'+'&m_cWv='+URLenc(l_oWv.asString())+'&m_cAtExit=close&m_cMode=hyperlink','elaborazione')
}
function href_NACPPABTRW() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function QJYFRLEIBB_Valid(e) {
SetActiveField(Ctrl('QJYFRLEIBB'),false);
e=(Ne(e,null)?e:window.event);
return Set_annorif(HtW(Ctrl('QJYFRLEIBB').value,'N'),null,e);
}
function QJYFRLEIBB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QJYFRLEIBB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QJYFRLEIBB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QJYFRLEIBB'),e);
}
function SZZYVNKOQS_Valid(e) {
SetActiveField(Ctrl('SZZYVNKOQS'),false);
e=(Ne(e,null)?e:window.event);
return Set_valuta(HtW(Ctrl('SZZYVNKOQS').value,'C'),null,e);
}
function SZZYVNKOQS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SZZYVNKOQS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SZZYVNKOQS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SZZYVNKOQS'),e);
}
function SZZYVNKOQS_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('SZZYVNKOQS')),'linkview_SZZYVNKOQS','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function TPIIDTIVPT_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgmod(HtW(getComboValue(Ctrl('TPIIDTIVPT')),'C'),null,e);
}
function TPIIDTIVPT_OnFocus(e) {
SetActiveField(Ctrl('TPIIDTIVPT'),true);
}
function TPIIDTIVPT_OnBlur(e) {
SetActiveField(Ctrl('TPIIDTIVPT'),false);
}
function href_AFQJCONGDS() {
var l_oWv = InitWvApplet();
l_oWv.setValue('w_annopx',AsAppletValue(Str(w_annorif,4,0)));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('w_annopx'));
SetLocationHref(null,'Report?ReportName='+'arrp_saldi_opex_ul'+'&m_cWv='+URLenc(l_oWv.asString())+'&m_cAtExit=close&m_cMode=hyperlink','elaborazione')
}
function NPTKUXAOKM_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgazz(ChkboxValueAssign(Ctrl('NPTKUXAOKM'),'S','N','C',1,0,''),null,e);
}
function NPTKUXAOKM_OnFocus(e) {
SetActiveField(Ctrl('NPTKUXAOKM'),true);
}
function NPTKUXAOKM_OnBlur(e) {
SetActiveField(Ctrl('NPTKUXAOKM'),false);
}
function UNGKYHCDIF_Valid(e) {
SetActiveField(Ctrl('UNGKYHCDIF'),false);
e=(Ne(e,null)?e:window.event);
return Set_ndgcli(HtW(Ctrl('UNGKYHCDIF').value,'C'),null,e);
}
function UNGKYHCDIF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UNGKYHCDIF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UNGKYHCDIF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UNGKYHCDIF'),e);
}
function UNGKYHCDIF_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('UNGKYHCDIF')),'linkview_UNGKYHCDIF','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function YBEELIFFJV_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgmopx(ChkboxValueAssign(Ctrl('YBEELIFFJV'),'S','N','C',1,0,''),null,e);
}
function YBEELIFFJV_OnFocus(e) {
SetActiveField(Ctrl('YBEELIFFJV'),true);
}
function YBEELIFFJV_OnBlur(e) {
SetActiveField(Ctrl('YBEELIFFJV'),false);
}
function href_JGBEHEEJHD() {
SetLocationHref(null,'arrt_calcsaldi_opex'+'?m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','elaborazione')
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('QJYFRLEIBB')) c.onblur=QJYFRLEIBB_Valid;
if(c=Ctrl('QJYFRLEIBB')) c.onfocus=QJYFRLEIBB_OnFocus;
if(c=Ctrl('QJYFRLEIBB')) c.onkeypress=CheckNum;
if(c=Ctrl('SZZYVNKOQS')) c.onblur=SZZYVNKOQS_Valid;
if(c=Ctrl('SZZYVNKOQS')) c.onfocus=SZZYVNKOQS_OnFocus;
if(c=Ctrl('TPIIDTIVPT')) c.onchange=TPIIDTIVPT_Valid;
if(c=Ctrl('TPIIDTIVPT')) c.onfocus=TPIIDTIVPT_OnFocus;
if(c=Ctrl('TPIIDTIVPT')) c.onblur=TPIIDTIVPT_OnBlur;
if(c=Ctrl('NPTKUXAOKM')) c.onclick=NPTKUXAOKM_Valid;
if(c=Ctrl('NPTKUXAOKM')) c.onfocus=NPTKUXAOKM_OnFocus;
if(c=Ctrl('NPTKUXAOKM')) c.onblur=NPTKUXAOKM_OnBlur;
if(c=Ctrl('UNGKYHCDIF')) c.onblur=UNGKYHCDIF_Valid;
if(c=Ctrl('UNGKYHCDIF')) c.onfocus=UNGKYHCDIF_OnFocus;
if(c=Ctrl('YBEELIFFJV')) c.onclick=YBEELIFFJV_Valid;
if(c=Ctrl('YBEELIFFJV')) c.onfocus=YBEELIFFJV_OnFocus;
if(c=Ctrl('YBEELIFFJV')) c.onblur=YBEELIFFJV_OnBlur;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_pMsg),'undefined')) {
w_pMsg.raiseEvent('arpg_calcsaldi_opex_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["QJYFRLEIBB"]};
function Help() {
windowOpenForeground('../doc/arpg_calcsaldi_opex_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_gIntemediario=a[0];
w_gTipInter=a[1];
w_gUrlApp=a[2];
w_gAzienda=a[3];
w_gFlgWU=a[4];
w_annorif=a[5];
w_valuta=a[6];
w_xdesval=a[7];
w_flgmod=a[8];
w_flgazz=a[9];
w_ndgcli=a[10];
w_xragsoc=a[11];
w_flgmopx=a[12];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_calcsaldi_opex',m_cSelectedPage);
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
function Set_valuta(ctrlValue,kmode,e) {
if (Ne(w_valuta,ctrlValue)) {
var ctl = _GetCtl(e,'SZZYVNKOQS');
if (_tracker.goon(ctl,ctrlValue)) {
w_valuta=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SZZYVNKOQS',0);
if (l_bResult) {
l_bResult=Link_SZZYVNKOQS(kmode);
if ( ! (l_bResult)) {
w_valuta=HtW('','C');
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
function Set_annorif(ctrlValue,kmode,e) {
if (Ne(w_annorif,ctrlValue)) {
var ctl = _GetCtl(e,'QJYFRLEIBB');
if (_tracker.goon(ctl,ctrlValue)) {
w_annorif=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QJYFRLEIBB',0);
if (l_bResult) {
l_bResult=Ge(w_annorif,2011) && Le(w_annorif,Year(SystemDate()));
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='863017169';
m_cLastMsgError=AlertErrorMessage('1672601933');
}
if ( ! (l_bResult)) {
w_annorif=HtW('','N');
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
function Set_flgmopx(ctrlValue,kmode,e) {
if (Ne(w_flgmopx,ctrlValue)) {
var ctl = _GetCtl(e,'YBEELIFFJV');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgmopx=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YBEELIFFJV',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ndgcli(ctrlValue,kmode,e) {
if (Ne(w_ndgcli,ctrlValue)) {
var ctl = _GetCtl(e,'UNGKYHCDIF');
if (_tracker.goon(ctl,ctrlValue)) {
w_ndgcli=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UNGKYHCDIF',0);
if (l_bResult) {
l_bResult=Link_UNGKYHCDIF(kmode);
if ( ! (l_bResult)) {
w_ndgcli=HtW('','C');
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
function Set_flgazz(ctrlValue,kmode,e) {
if (Ne(w_flgazz,ctrlValue)) {
var ctl = _GetCtl(e,'NPTKUXAOKM');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgazz=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NPTKUXAOKM',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgmod(ctrlValue,kmode,e) {
if (Ne(w_flgmod,ctrlValue)) {
var ctl = _GetCtl(e,'TPIIDTIVPT');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgmod=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TPIIDTIVPT',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
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
function Link_SZZYVNKOQS(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_valuta);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODVAL',w_valuta,3,0);
l_Appl.SetFields('CODVAL,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbvalute');
l_Appl.SetLinkzoom('armt_divise');
l_Appl.SetID('SZZYVNKOQS');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_valuta=l_Appl.GetStringValue('CODVAL',3,0);
w_xdesval=l_Appl.GetStringValue('DESCRI',45,0);
} else {
Link_SZZYVNKOQS_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_SZZYVNKOQS';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_SZZYVNKOQS();
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
function Link_SZZYVNKOQS_Blank() {
w_valuta='';
w_xdesval='';
}
function LOpt_SZZYVNKOQS() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbvalute','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_divise','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODVAL','C'));
l_oWv.setValue('LinkedField',WtA('CODVAL','C'));
l_oWv.setValue('UID',WtA('SZZYVNKOQS','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SZZYVNKOQS'][1],'C'));
return l_oWv;
}
function Link_UNGKYHCDIF(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_ndgcli);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_ndgcli,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetLinkzoom('armt_personbo');
l_Appl.SetID('UNGKYHCDIF');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_ndgcli=l_Appl.GetStringValue('CONNES',16,0);
w_xragsoc=l_Appl.GetStringValue('RAGSOC',70,0);
} else {
Link_UNGKYHCDIF_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_UNGKYHCDIF';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_UNGKYHCDIF();
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
function Link_UNGKYHCDIF_Blank() {
w_ndgcli='';
w_xragsoc='';
}
function LOpt_UNGKYHCDIF() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('UNGKYHCDIF','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UNGKYHCDIF'][1],'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'SZZYVNKOQS')) {
last_focused_comp=GetLastFocusedElementOfLink('SZZYVNKOQS');
function SetMethod_SZZYVNKOQS() {
Set_valuta(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_SZZYVNKOQS();
} else {
setTimeout(SetMethod_SZZYVNKOQS,1);
}
bResult=true;
}
if (Eq(varName,'UNGKYHCDIF')) {
last_focused_comp=GetLastFocusedElementOfLink('UNGKYHCDIF');
function SetMethod_UNGKYHCDIF() {
Set_ndgcli(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_UNGKYHCDIF();
} else {
setTimeout(SetMethod_UNGKYHCDIF,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'SZZYVNKOQS')) {
return [Ctrl('SZZYVNKOQS')];
}
if (Eq(varName,'UNGKYHCDIF')) {
return [Ctrl('UNGKYHCDIF')];
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
if (( ! (_ChkObl('QJYFRLEIBB',1))) || ( ! (Ge(w_annorif,2011) && Le(w_annorif,Year(SystemDate()))))) {
_SignErr('QJYFRLEIBB','1672601933');
l_bResult=false;
w_annorif=HtW('','N');
} else if ( ! (_ChkObl('SZZYVNKOQS',1))) {
_SignErr('SZZYVNKOQS');
m_cLastWorkVarErrorMsg='10615624819';
l_bResult=false;
w_valuta=HtW('','C');
} else if ( ! (_ChkObl('TPIIDTIVPT',1))) {
_SignErr('TPIIDTIVPT');
m_cLastWorkVarErrorMsg='flgmod';
l_bResult=false;
w_flgmod=HtW('','C');
} else if ( ! (_ChkObl('NPTKUXAOKM',1))) {
_SignErr('NPTKUXAOKM');
m_cLastWorkVarErrorMsg='flgazz';
l_bResult=false;
w_flgazz='N';
} else if ( ! (_ChkObl('UNGKYHCDIF',1))) {
_SignErr('UNGKYHCDIF');
m_cLastWorkVarErrorMsg='10718176058';
l_bResult=false;
w_ndgcli=HtW('','C');
} else if ( ! (_ChkObl('YBEELIFFJV',1))) {
_SignErr('YBEELIFFJV');
m_cLastWorkVarErrorMsg='flgmopx';
l_bResult=false;
w_flgmopx='N';
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('SZZYVNKOQS_ZOOM',lc)) {
return 0;
}
if (Eq('SZZYVNKOQS',lc)) {
return 0;
}
if (Eq('UNGKYHCDIF_ZOOM',lc)) {
return 1;
}
if (Eq('UNGKYHCDIF',lc)) {
return 1;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_SZZYVNKOQS();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_UNGKYHCDIF();
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
l_oWv.setValue('gIntemediario',WtA(w_gIntemediario,'C'));
l_oWv.setValue('gTipInter',WtA(w_gTipInter,'C'));
l_oWv.setValue('gUrlApp',WtA(w_gUrlApp,'C'));
l_oWv.setValue('gAzienda',WtA(w_gAzienda,'C'));
l_oWv.setValue('gFlgWU',WtA(w_gFlgWU,'C'));
l_oWv.setValue('annorif',WtA(w_annorif,'N'));
l_oWv.setValue('valuta',WtA(w_valuta,'C'));
l_oWv.setValue('xdesval',WtA(w_xdesval,'C'));
l_oWv.setValue('flgmod',WtA(w_flgmod,'C'));
l_oWv.setValue('flgazz',WtA(w_flgazz,'C'));
l_oWv.setValue('ndgcli',WtA(w_ndgcli,'C'));
l_oWv.setValue('xragsoc',WtA(w_xragsoc,'C'));
l_oWv.setValue('flgmopx',WtA(w_flgmopx,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["gIntemediario","gTipInter","gUrlApp","gAzienda","gFlgWU","annorif","valuta","xdesval","flgmod","flgazz","ndgcli","xragsoc","flgmopx"];
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
if (start && Eq(At(',valuta,',pseq),0)) {
w_valuta='242';
}
Link_SZZYVNKOQS(null);
if (start && Eq(At(',flgmod,',pseq),0)) {
w_flgmod='O';
}
if (start && Eq(At(',flgazz,',pseq),0)) {
w_flgazz='N';
}
Link_UNGKYHCDIF(null);
if (start && Eq(At(',flgmopx,',pseq),0)) {
w_flgmopx='N';
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
_Obli('valuta',0,'SZZYVNKOQS',false,"10615624819")
_Obli('annorif',1,'QJYFRLEIBB',true,"863017169",null,"1672601933")
_Obli('flgmopx',0,'YBEELIFFJV',false)
_Obli('ndgcli',0,'UNGKYHCDIF',false,"10718176058")
_Obli('flgazz',0,'NPTKUXAOKM',false)
_Obli('flgmod',0,'TPIIDTIVPT',false)
