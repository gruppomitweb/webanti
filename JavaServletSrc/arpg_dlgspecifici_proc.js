function SetControlsValue() {
var c;
var c;
if(c=Ctrl('FCREPJBLHG')) c.value = WtH(w_codinter,'C',11,0,'')
if(c=Ctrl('RCFVSQQCNU')) selectCombo(c,w_tipinter,'C')
if(c=Ctrl('QNPCFVUZVQ')) c.value = WtH(w_passwd,'C',10,0,'')
var tmp_UWBJTJCNUU = ToHTag(AsControlValue(w_xragsoc));
if (Ne(e_UWBJTJCNUU,tmp_UWBJTJCNUU)) {
if(c=Ctrl('UWBJTJCNUU')) c.innerHTML=tmp_UWBJTJCNUU;
e_UWBJTJCNUU=tmp_UWBJTJCNUU;
}
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\' name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('DLRFQQQDLC')) c.value = WtH(w_numreg,'N',10,0,'9,999,999,999')
if(c=Ctrl('OCYGBFBZCL')) c.value = WtH(w_numrec,'N',10,0,'9,999,999,999')
if(c=Ctrl('TYQOYPNNDW')) selectCombo(c,w_tipofile,'C')
if(c=Ctrl('BHRJFGYNWO')) ChkboxCheckUncheck(c,'S',w_flgint)
if(c=Ctrl('BHRJFGYNWO')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('QNMKJLGOKW')) selectCombo(c,w_flgrae,'C')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('NLESICXZOP'),Empty(w_codinter) || Empty(w_tipinter));
SetDisplay(Ctrl('FGMOCXNBFY'),true);
HideUI();
}
HideUI.lblids["codinter"]=['PMDUYENKWL'];
HideUI.lblids["numrec"]=['RZXIQFFVYD'];
HideUI.lblids["numreg"]=['GHIYIETBUO'];
HideUI.lblids["passwd"]=['DKFQPXXFTU'];
HideUI.lblids["tipinter"]=['CCVJTGYXIP'];
HideUI.lblids["tipofile"]=['KZSIFKEGCK'];
function FCREPJBLHG_Valid(e) {
SetActiveField(Ctrl('FCREPJBLHG'),false);
e=(Ne(e,null)?e:window.event);
return Set_codinter(HtW(Ctrl('FCREPJBLHG').value,'C'),null,e);
}
function FCREPJBLHG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FCREPJBLHG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FCREPJBLHG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FCREPJBLHG'),e);
}
function FCREPJBLHG_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('FCREPJBLHG')),'linkview_FCREPJBLHG','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function RCFVSQQCNU_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipinter(HtW(getComboValue(Ctrl('RCFVSQQCNU')),'C'),null,e);
}
function RCFVSQQCNU_OnFocus(e) {
SetActiveField(Ctrl('RCFVSQQCNU'),true);
}
function RCFVSQQCNU_OnBlur(e) {
SetActiveField(Ctrl('RCFVSQQCNU'),false);
}
function QNPCFVUZVQ_Valid(e) {
SetActiveField(Ctrl('QNPCFVUZVQ'),false);
e=(Ne(e,null)?e:window.event);
return Set_passwd(HtW(Ctrl('QNPCFVUZVQ').value,'C'),null,e);
}
function QNPCFVUZVQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QNPCFVUZVQ'))) {
DisplayErrorMessage();
}
Ctrl('QNPCFVUZVQ').value=WtH(w_passwd,'C',10,0,'');
SetActiveField(Ctrl('QNPCFVUZVQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QNPCFVUZVQ'),e);
}
function QNPCFVUZVQ_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("*"));
}
function QFCHQSUGEZ_Click() {
window.close()
}
function NLESICXZOP_Click() {
SetLocationHref(null,'arrt_dlgspecifici'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function TYQOYPNNDW_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipofile(HtW(getComboValue(Ctrl('TYQOYPNNDW')),'C'),null,e);
}
function TYQOYPNNDW_OnFocus(e) {
SetActiveField(Ctrl('TYQOYPNNDW'),true);
}
function TYQOYPNNDW_OnBlur(e) {
SetActiveField(Ctrl('TYQOYPNNDW'),false);
}
function BHRJFGYNWO_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgint(ChkboxValueAssign(Ctrl('BHRJFGYNWO'),'S','N','C',1,0,''),null,e);
}
function BHRJFGYNWO_OnFocus(e) {
SetActiveField(Ctrl('BHRJFGYNWO'),true);
}
function BHRJFGYNWO_OnBlur(e) {
SetActiveField(Ctrl('BHRJFGYNWO'),false);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('FCREPJBLHG')) c.onblur=FCREPJBLHG_Valid;
if(c=Ctrl('FCREPJBLHG')) c.onfocus=FCREPJBLHG_OnFocus;
if(c=Ctrl('RCFVSQQCNU')) c.onchange=RCFVSQQCNU_Valid;
if(c=Ctrl('RCFVSQQCNU')) c.onfocus=RCFVSQQCNU_OnFocus;
if(c=Ctrl('RCFVSQQCNU')) c.onblur=RCFVSQQCNU_OnBlur;
if(c=Ctrl('QNPCFVUZVQ')) c.onblur=QNPCFVUZVQ_Valid;
if(c=Ctrl('QNPCFVUZVQ')) c.onfocus=QNPCFVUZVQ_OnFocus;
if(c=Ctrl('TYQOYPNNDW')) c.onchange=TYQOYPNNDW_Valid;
if(c=Ctrl('TYQOYPNNDW')) c.onfocus=TYQOYPNNDW_OnFocus;
if(c=Ctrl('TYQOYPNNDW')) c.onblur=TYQOYPNNDW_OnBlur;
if(c=Ctrl('BHRJFGYNWO')) c.onclick=BHRJFGYNWO_Valid;
if(c=Ctrl('BHRJFGYNWO')) c.onfocus=BHRJFGYNWO_OnFocus;
if(c=Ctrl('BHRJFGYNWO')) c.onblur=BHRJFGYNWO_OnBlur;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_dlgspecifici_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_dlgspecifici_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["FCREPJBLHG"]};
function Help() {
windowOpenForeground('../doc/arpg_dlgspecifici_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_codinter=a[0];
w_tipinter=a[1];
w_passwd=a[2];
w_gIntemediario=a[3];
w_gTipInter=a[4];
w_xragsoc=a[5];
w_numreg=a[6];
w_numrec=a[7];
w_tipofile=a[8];
w_flgint=a[9];
w_flgrae=a[10];
w_flgdel=a[11];
w_flgsto=a[12];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_dlgspecifici',m_cSelectedPage);
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
function Set_codinter(ctrlValue,kmode,e) {
if (Ne(w_codinter,ctrlValue)) {
var ctl = _GetCtl(e,'FCREPJBLHG');
if (_tracker.goon(ctl,ctrlValue)) {
w_codinter=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FCREPJBLHG',0);
if (l_bResult) {
l_bResult=Link_FCREPJBLHG(kmode);
if ( ! (l_bResult)) {
w_codinter=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',11,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',11,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_tipinter(ctrlValue,kmode,e) {
if (Ne(w_tipinter,ctrlValue)) {
var ctl = _GetCtl(e,'RCFVSQQCNU');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipinter=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RCFVSQQCNU',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_passwd(ctrlValue,kmode,e) {
if (Ne(w_passwd,ctrlValue)) {
var ctl = _GetCtl(e,'QNPCFVUZVQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_passwd=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QNPCFVUZVQ',0);
DoUpdate(l_bResult);
if(c=Ctrl('QNPCFVUZVQ')) c.value = WtH(w_passwd,'C',10,0,'')
} else {
ctl.value=WtH('','C',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgint(ctrlValue,kmode,e) {
if (Ne(w_flgint,ctrlValue)) {
var ctl = _GetCtl(e,'BHRJFGYNWO');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgint=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BHRJFGYNWO',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_tipofile(ctrlValue,kmode,e) {
if (Ne(w_tipofile,ctrlValue)) {
var ctl = _GetCtl(e,'TYQOYPNNDW');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipofile=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TYQOYPNNDW',0);
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
w_numreg=arfn_readnumeri(1);
w_numrec=arfn_readnumeri(2);
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function Link_FCREPJBLHG(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_codinter);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODINTER',w_codinter,11,0);
l_Appl.SetFields('CODINTER,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('intermbo');
l_Appl.SetID('FCREPJBLHG');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_codinter=l_Appl.GetStringValue('CODINTER',11,0);
w_xragsoc=l_Appl.GetStringValue('RAGSOC',70,0);
} else {
Link_FCREPJBLHG_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_FCREPJBLHG';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_FCREPJBLHG();
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
function Link_FCREPJBLHG_Blank() {
w_codinter='';
w_xragsoc='';
}
function LOpt_FCREPJBLHG() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('intermbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODINTER','C'));
l_oWv.setValue('LinkedField',WtA('CODINTER','C'));
l_oWv.setValue('UID',WtA('FCREPJBLHG','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['FCREPJBLHG'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11404054622'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'FCREPJBLHG')) {
last_focused_comp=GetLastFocusedElementOfLink('FCREPJBLHG');
function SetMethod_FCREPJBLHG() {
Set_codinter(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_FCREPJBLHG();
} else {
setTimeout(SetMethod_FCREPJBLHG,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'FCREPJBLHG')) {
return [Ctrl('FCREPJBLHG')];
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
if ( ! (_ChkObl('FCREPJBLHG',1))) {
_SignErr('FCREPJBLHG');
m_cLastWorkVarErrorMsg='codinter';
l_bResult=false;
w_codinter=HtW('','C');
} else if ( ! (_ChkObl('RCFVSQQCNU',1))) {
_SignErr('RCFVSQQCNU');
m_cLastWorkVarErrorMsg='tipinter';
l_bResult=false;
w_tipinter=HtW('','C');
} else if ( ! (_ChkObl('QNPCFVUZVQ',1))) {
_SignErr('QNPCFVUZVQ');
m_cLastWorkVarErrorMsg='passwd';
l_bResult=false;
w_passwd=HtW('','C');
} else if ( ! (_ChkObl('TYQOYPNNDW',1))) {
_SignErr('TYQOYPNNDW');
m_cLastWorkVarErrorMsg='tipofile';
l_bResult=false;
w_tipofile=HtW('','C');
} else if ( ! (_ChkObl('BHRJFGYNWO',1))) {
_SignErr('BHRJFGYNWO');
m_cLastWorkVarErrorMsg='flgint';
l_bResult=false;
w_flgint='N';
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('FCREPJBLHG_ZOOM',lc)) {
return 0;
}
if (Eq('FCREPJBLHG',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_FCREPJBLHG();
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
l_oWv.setValue('codinter',WtA(w_codinter,'C'));
l_oWv.setValue('tipinter',WtA(w_tipinter,'C'));
l_oWv.setValue('passwd',WtA(w_passwd,'C'));
l_oWv.setValue('gIntemediario',WtA(w_gIntemediario,'C'));
l_oWv.setValue('gTipInter',WtA(w_gTipInter,'C'));
l_oWv.setValue('xragsoc',WtA(w_xragsoc,'C'));
l_oWv.setValue('numreg',WtA(w_numreg,'N'));
l_oWv.setValue('numrec',WtA(w_numrec,'N'));
l_oWv.setValue('tipofile',WtA(w_tipofile,'C'));
l_oWv.setValue('flgint',WtA(w_flgint,'C'));
l_oWv.setValue('flgrae',WtA(w_flgrae,'C'));
l_oWv.setValue('flgdel',WtA(w_flgdel,'C'));
l_oWv.setValue('flgsto',WtA(w_flgsto,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["codinter","tipinter","passwd","gIntemediario","gTipInter","xragsoc","numreg","numrec","tipofile","flgint","flgrae","flgdel","flgsto"];
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
if (Eq(w_codinter,w_gIntemediario) && Ne(opener.w_codinter,null)) {
TransferBetweenWindows(opener,'w_codinter',null,'Set_codinter');
}
if (Eq(w_tipinter,w_gTipInter) && Ne(opener.w_tipinter,null)) {
TransferBetweenWindows(opener,'w_tipinter',null,'Set_tipinter');
}
if (Empty(w_xragsoc) && Ne(opener.w_xragsoc,null)) {
TransferBetweenWindows(opener,'w_xragsoc','w_xragsoc');
}
if (Empty(w_numreg) && Ne(opener.w_numreg,null)) {
TransferBetweenWindows(opener,'w_numreg','w_numreg');
}
if (Empty(w_numrec) && Ne(opener.w_numrec,null)) {
TransferBetweenWindows(opener,'w_numrec','w_numrec');
}
}
}
m_bCalculating=true;
if (start && Eq(At(',codinter,',pseq),0)) {
w_codinter=w_gIntemediario;
}
Link_FCREPJBLHG(null);
if (start && Eq(At(',tipinter,',pseq),0)) {
w_tipinter=w_gTipInter;
}
w_numreg=arfn_readnumeri(1);
w_numrec=arfn_readnumeri(2);
if (start && Eq(At(',tipofile,',pseq),0)) {
w_tipofile='U';
}
if (start && Eq(At(',flgint,',pseq),0)) {
w_flgint='S';
}
if (start && Eq(At(',flgrae,',pseq),0)) {
w_flgrae='A';
}
if (start && Eq(At(',flgdel,',pseq),0)) {
w_flgdel='S';
}
if (start && Eq(At(',flgsto,',pseq),0)) {
w_flgsto='S';
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
_Obli('codinter',0,'FCREPJBLHG',false)
_Obli('tipinter',0,'RCFVSQQCNU',false)
_Obli('passwd',0,'QNPCFVUZVQ',false)
_Obli('flgint',0,'BHRJFGYNWO',false)
_Obli('tipofile',0,'TYQOYPNNDW',false)
