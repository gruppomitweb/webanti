function SetControlsValue() {
var c;
var c;
if(c=Ctrl('EDVZEHEPWR')) c.value = WtH(w_dataope,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('MZRZWUCOCZ')) c.value = WtH(w_datareg,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('OWENYZRHAH')) c.value = WtH(w_tipope,'C',2,0,'')
var tmp_PODSUGNDQG = ToHTag(AsControlValue(w_xdes1));
if (Ne(e_PODSUGNDQG,tmp_PODSUGNDQG)) {
if(c=Ctrl('PODSUGNDQG')) c.innerHTML=tmp_PODSUGNDQG;
e_PODSUGNDQG=tmp_PODSUGNDQG;
}
if (Gt(m_nRows,0) && Lt(m_nCurrentRow,m_oTrsFW.length)) {
if (Ne(Ctrl('BHCCADUOZN_'+m_nCurrentRow),null)) {
if(c=Ctrl('BHCCADUOZN_'+m_nCurrentRow)) ChkboxCheckUncheck(c,'S',w_FLGSEL)
if(c=Ctrl('BHCCADUOZN_'+m_nCurrentRow)) ChkboxValueAssign(c,'S','N','C',1,0,'')
}
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
if (Gt(m_nRows,0)) {
SetDisplay(Ctrl('NFDUNWOAZE'),true);
}
HideUI();
}
HideUI.lblids["dataope"]=['BRAPIEKOMS'];
HideUI.lblids["datareg"]=['VRUVGWMMYE'];
HideUI.lblids["tipope"]=['SCFTKMRNAF'];
function href_RROILCAWGO() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_closerap']));
SendData('start','arrt_closerap'+'',HParApplet().asString());
}
function href_HDSXZTLKVK() {
Update()
}
function href_ZWTNEMXOFQ() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('pTipo',AsAppletValue('D'));
SetHypPar('m_cParameterSequence',AsAppletValue('pTipo'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_seldes_closerap']));
SendData('start','arrt_seldes_closerap'+'',HParApplet().asString());
}
function href_FCATLNLMSB() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('pTipo',AsAppletValue('S'));
SetHypPar('m_cParameterSequence',AsAppletValue('pTipo'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_seldes_closerap']));
SendData('start','arrt_seldes_closerap'+'',HParApplet().asString());
}
function BHCCADUOZN_Valid(e) {
var org = GetEventSrcElement(e);
if ( ! (org.focused)) {
var c = org.checked;
org.focus();
org.checked=c;
}
e=(Ne(e,null)?e:window.event);
return Set_FLGSEL(ChkboxValueAssign(Ctrl('BHCCADUOZN_'+m_nCurrentRow),'S','N','C',1,0,''),null,e);
}
function BHCCADUOZN_OnFocus(e) {
var org;
org=GetEventSrcElement(e);
org.focused=true;
ChangeRow(Val(Right(org.name,Len(org.name)-RAt('_',org.name))));
}
function BHCCADUOZN_OnBlur(e) {
SetActiveField(Ctrl('BHCCADUOZN_'+m_nCurrentRow),false);
}
function BHCCADUOZN_OnBlur(e) {
var org = GetEventSrcElement(e);
org.focused=false;
}
function BHCCADUOZN_OnFocus(e) {
var org;
org=GetEventSrcElement(e);
org.focused=true;
ChangeRow(Val(Right(org.name,Len(org.name)-RAt('_',org.name))));
}
function href_IIJDTQKPBX() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function EDVZEHEPWR_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('EDVZEHEPWR'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('EDVZEHEPWR').value=ApplyPictureToDate(Ctrl('EDVZEHEPWR').value,TranslatePicture(datePattern),'EDVZEHEPWR');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('EDVZEHEPWR'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('EDVZEHEPWR');
}
}
}
SetActiveField(Ctrl('EDVZEHEPWR'),false);
e=(Ne(e,null)?e:window.event);
return Set_dataope(HtW(Ctrl('EDVZEHEPWR').value,'D'),null,e) && dateisok;
}
function EDVZEHEPWR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EDVZEHEPWR'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('EDVZEHEPWR').value=WtH(w_dataope,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('EDVZEHEPWR');
SetActiveField(Ctrl('EDVZEHEPWR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EDVZEHEPWR'),e);
}
function EDVZEHEPWR_ZOOM_Click() {
LaunchCalendar(Ctrl('EDVZEHEPWR'));
}
function MZRZWUCOCZ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('MZRZWUCOCZ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('MZRZWUCOCZ').value=ApplyPictureToDate(Ctrl('MZRZWUCOCZ').value,TranslatePicture(datePattern),'MZRZWUCOCZ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('MZRZWUCOCZ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('MZRZWUCOCZ');
}
}
}
SetActiveField(Ctrl('MZRZWUCOCZ'),false);
e=(Ne(e,null)?e:window.event);
return Set_datareg(HtW(Ctrl('MZRZWUCOCZ').value,'D'),null,e) && dateisok;
}
function MZRZWUCOCZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MZRZWUCOCZ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('MZRZWUCOCZ').value=WtH(w_datareg,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('MZRZWUCOCZ');
SetActiveField(Ctrl('MZRZWUCOCZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MZRZWUCOCZ'),e);
}
function MZRZWUCOCZ_ZOOM_Click() {
LaunchCalendar(Ctrl('MZRZWUCOCZ'));
}
function OWENYZRHAH_Valid(e) {
SetActiveField(Ctrl('OWENYZRHAH'),false);
e=(Ne(e,null)?e:window.event);
return Set_tipope(HtW(Ctrl('OWENYZRHAH').value,'C'),null,e);
}
function OWENYZRHAH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OWENYZRHAH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OWENYZRHAH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OWENYZRHAH'),e);
}
function OWENYZRHAH_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('OWENYZRHAH')),'linkview_OWENYZRHAH','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('EDVZEHEPWR')) c.onblur=EDVZEHEPWR_Valid;
if(c=Ctrl('EDVZEHEPWR')) c.onfocus=EDVZEHEPWR_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('EDVZEHEPWR')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('MZRZWUCOCZ')) c.onblur=MZRZWUCOCZ_Valid;
if(c=Ctrl('MZRZWUCOCZ')) c.onfocus=MZRZWUCOCZ_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('MZRZWUCOCZ')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('OWENYZRHAH')) c.onblur=OWENYZRHAH_Valid;
if(c=Ctrl('OWENYZRHAH')) c.onfocus=OWENYZRHAH_OnFocus;
}
var l_nOldRow = m_nCurrentRow;
m_nCurrentRow=0;
while (Lt(m_nCurrentRow,m_nRows)) {
if(c=Ctrl('BHCCADUOZN_'+m_nCurrentRow)) c.onclick=BHCCADUOZN_Valid;
if(c=Ctrl('BHCCADUOZN_'+m_nCurrentRow)) c.onfocus=BHCCADUOZN_OnFocus;
if(c=Ctrl('BHCCADUOZN_'+m_nCurrentRow)) c.onblur=BHCCADUOZN_OnBlur;
if(c=Ctrl('BHCCADUOZN_'+m_nCurrentRow)) c.onfocus=BHCCADUOZN_OnFocus;
if(c=Ctrl('BHCCADUOZN_'+m_nCurrentRow)) c.onblur=BHCCADUOZN_OnBlur;
m_nCurrentRow=m_nCurrentRow+1;
}
m_nCurrentRow=l_nOldRow;
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
function DoFieldsUpdate(p_bResult) {
m_bFieldsUpdated=true;
DoUpdate(p_bResult);
}
FocusFirstComponent.otherwise={"page_1":["BHCCADUOZN_'+m_nCurrentRow+'"]};
function Help() {
windowOpenForeground('../doc/arpg_closerap_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_FLGSEL=a[0];
w_dataope=a[1];
w_datareg=a[2];
w_tipope=a[3];
w_xdes1=a[4];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_closerap',m_cSelectedPage);
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
if (Gt(m_nRows,0)) {
}
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
function Update() {
var l_bUpdate;
var l_nRow;
l_nRow=0;
l_bUpdate=true;
if (m_bFieldsUpdated) {
while (l_bUpdate && Lt(m_nCurrentRow,m_nRows)) {
ChangeRow(l_nRow);
l_bUpdate=l_bUpdate && Eq(m_nCurrentRow,l_nRow);
l_nRow=l_nRow+1;
}
}
if (l_bUpdate) {
FillFrmTrs('FLGSEL');
SubmitForm('save');
}
}
function Set_FLGSEL(ctrlValue,kmode,e) {
if (Ne(w_FLGSEL,ctrlValue)) {
var ctl = _GetCtl(e,'BHCCADUOZN_'+m_nCurrentRow+'');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGSEL=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BHCCADUOZN',0);
DoFieldsUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_dataope(ctrlValue,kmode,e) {
if (Ne(w_dataope,ctrlValue)) {
var ctl = _GetCtl(e,'EDVZEHEPWR');
if (_tracker.goon(ctl,ctrlValue)) {
w_dataope=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EDVZEHEPWR',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_datareg(ctrlValue,kmode,e) {
if (Ne(w_datareg,ctrlValue)) {
var ctl = _GetCtl(e,'MZRZWUCOCZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_datareg=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MZRZWUCOCZ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_tipope(ctrlValue,kmode,e) {
if (Ne(w_tipope,ctrlValue)) {
var ctl = _GetCtl(e,'OWENYZRHAH');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipope=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OWENYZRHAH',0);
if (l_bResult) {
l_bResult=Link_OWENYZRHAH(kmode);
if ( ! (l_bResult)) {
w_tipope=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',2,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',2,0,'');
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
function Link_OWENYZRHAH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_tipope);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_tipope,2,0);
l_Appl.SetFields('CODICE,DES1');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbtipreg');
l_Appl.SetID('OWENYZRHAH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_tipope=l_Appl.GetStringValue('CODICE',2,0);
w_xdes1=l_Appl.GetStringValue('DES1',90,0);
} else {
Link_OWENYZRHAH_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_OWENYZRHAH';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_OWENYZRHAH();
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
function Link_OWENYZRHAH_Blank() {
w_tipope='';
w_xdes1='';
}
function LOpt_OWENYZRHAH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipreg','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('OWENYZRHAH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['OWENYZRHAH'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('829257574'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'OWENYZRHAH')) {
last_focused_comp=GetLastFocusedElementOfLink('OWENYZRHAH');
function SetMethod_OWENYZRHAH() {
Set_tipope(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_OWENYZRHAH();
} else {
setTimeout(SetMethod_OWENYZRHAH,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'OWENYZRHAH')) {
return [Ctrl('OWENYZRHAH')];
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
if ( ! (_ChkObl('BHCCADUOZN',1))) {
_SignErr('BHCCADUOZN_'+m_nCurrentRow+'');
m_cLastWorkVarErrorMsg='10861150445';
l_bResult=false;
w_FLGSEL='N';
} else if ( ! (_ChkObl('EDVZEHEPWR',1))) {
_SignErr('EDVZEHEPWR');
m_cLastWorkVarErrorMsg='829201110';
l_bResult=false;
w_dataope=HtW('','D');
} else if ( ! (_ChkObl('MZRZWUCOCZ',1))) {
_SignErr('MZRZWUCOCZ');
m_cLastWorkVarErrorMsg='829201110';
l_bResult=false;
w_datareg=HtW('','D');
} else if ( ! (_ChkObl('OWENYZRHAH',1))) {
_SignErr('OWENYZRHAH');
m_cLastWorkVarErrorMsg='829257574';
l_bResult=false;
w_tipope=HtW('','C');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('EDVZEHEPWR_ZOOM',lc)) {
return 0;
}
if (Eq('MZRZWUCOCZ_ZOOM',lc)) {
return 0;
}
if (Eq('OWENYZRHAH_ZOOM',lc)) {
return 0;
}
if (Eq('OWENYZRHAH',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_OWENYZRHAH();
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
l_oWv.setValue('FLGSEL',WtA(w_FLGSEL,'C'));
l_oWv.setValue('dataope',WtA(w_dataope,'D'));
l_oWv.setValue('datareg',WtA(w_datareg,'D'));
l_oWv.setValue('tipope',WtA(w_tipope,'C'));
l_oWv.setValue('xdes1',WtA(w_xdes1,'C'));
_FillChildren(l_oWv);
l_oWv.setValue('m_oTrs',TrsApplet().asString());
}
_FillChildren.n=[];
FillWv.n=["FLGSEL","dataope","datareg","tipope","xdes1"];
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
if (Empty(w_dataope) && Ne(opener.w_dataope,null)) {
TransferBetweenWindows(opener,'w_dataope',null,'Set_dataope');
}
if (Empty(w_datareg) && Ne(opener.w_datareg,null)) {
TransferBetweenWindows(opener,'w_datareg',null,'Set_datareg');
}
if (Empty(w_tipope) && Ne(opener.w_tipope,null)) {
TransferBetweenWindows(opener,'w_tipope',null,'Set_tipope');
}
if (Empty(w_xdes1) && Ne(opener.w_xdes1,null)) {
TransferBetweenWindows(opener,'w_xdes1','w_xdes1');
}
}
}
m_bCalculating=true;
Link_OWENYZRHAH(null);
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
function TrsFWRow() {
  this.w_FLGSEL = arguments[0]
  this.t_FLGSEL = arguments[1]
  this.k_FLGSEL_RAPPORTO = arguments[2]
  this.m_nRowStatus = arguments[3]
}
function TrsQueryRow() {
  this.c_RAPPORTO = arguments[0]
  this.c_DESCRAP = arguments[1]
  this.c_FLGSEL = arguments[2]
}
function TrsToWork() {
var row;
if (Lt(m_nCurrentRow,m_oTrsFW.length)) {
row=m_oTrsFW[m_nCurrentRow];
w_FLGSEL=row.w_FLGSEL;
m_nRowStatus=row.m_nRowStatus;
}
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
c_RAPPORTO=row.c_RAPPORTO;
c_DESCRAP=row.c_DESCRAP;
c_FLGSEL=row.c_FLGSEL;
}
}
function WorkToTrs() {
var row;
if (Lt(m_nCurrentRow,m_oTrsFW.length)) {
row=m_oTrsFW[m_nCurrentRow];
row.w_FLGSEL=w_FLGSEL;
row.m_nRowStatus=m_nRowStatus;
}
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
row.c_RAPPORTO=c_RAPPORTO;
row.c_DESCRAP=c_DESCRAP;
row.c_FLGSEL=c_FLGSEL;
}
}
function BlankQueryFields() {
c_RAPPORTO='';
c_DESCRAP='';
c_FLGSEL='';
}
function FillHTMLRow() {
var l_nIdx = 0;
var l_oQuery;
var l_oFields;
var l_nEvenOdd = 0;
var l_nPrev = 0;
var l_nNext = 0;
var l_bEof;
l_bEof=Eq(m_nRows,0);
var l_nDeep;
l_nDeep=-1;
var l_nStartRow = Val(document.FSender.StartRow.value);
var l_nPos = 0;
var l_XHOLECKSMB = false;
var l_old_XHOLECKSMB = l_XHOLECKSMB;
Body_BeginHtml(63,'',0,'A','');
BlankQueryFields();
while ( ! (l_bEof)) {
l_oQuery=m_oTrsQuery[l_nIdx];
l_oFields=m_oTrsFW[l_nIdx];
l_nDeep=0;
if (Lt(l_nIdx,m_nRows)) {
m_nCurrentRow=l_nIdx;
TrsToWork();
l_XHOLECKSMB=true;
if (Eq(l_nIdx,0)) {
l_nDeep=1;
} else {
if (Ne(l_old_XHOLECKSMB,l_XHOLECKSMB)) {
l_nDeep=2;
} else {
l_nDeep=3;
}
}
} else {
l_bEof=true;
l_nDeep=1;
}
l_nIdx=l_nIdx-1;
if (Ge(l_nIdx,0)) {
m_nCurrentRow=l_nIdx;
TrsToWork();
}
if (Ge(2,l_nDeep) && Ge(l_nIdx,0)) {
GroupFooter_BeginHtml(document,1,'11627623307'+l_nIdx+'','A',true,false)
GroupFooter_EndHtml(document,1,'11627623307'+l_nIdx+'','A')
} else {
}
l_nIdx=l_nIdx+1;
m_nCurrentRow=l_nIdx;
TrsToWork();
l_old_XHOLECKSMB = l_XHOLECKSMB;
if ( ! (l_bEof)) {
Parms.Idx=l_nIdx;
Parms.Deep=l_nDeep;
Parms.EvenOdd=l_nEvenOdd;
DrawLine(document);
l_nEvenOdd = l_nEvenOdd+1;
}
if ( ! (l_bEof)) {
l_nIdx=l_nIdx+1;
}
}
Body_Buttons(Gt(l_nStartRow,1),m_bOtherRow,'A');
if (Gt(m_nRows,0) || Lt(l_nIdx,m_nRows)) {
Update_Button("NFDUNWOAZE",Translate("113933141"),"","","","CLASS=FormDefault STYLE='display:"+(true?'none':'inline')+"'","")
}
Body_EndHtml('A');
}
function DrawLine(document) {
l_nIdx=Parms.Idx;
l_nDeep=Parms.Deep;
l_nEvenOdd=Parms.EvenOdd;
if (Ge(2,l_nDeep)) {
GroupHeader_BeginHtml(document,1,'11594068875'+l_nIdx+'','A',true,false)
document.writeln(
 "<div id='DIV_0B92D3C0"+l_nIdx+"' style='position:relative;height:23px'>" +
"")
document.writeln(
 "<span class=' SPLabel LGHPFZJHVC_DIV'>" +
 "<label class='LGHPFZJHVC'>" +
 ""+ToHTag(Translate("1232360546"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel YEWLTYBCCV_DIV'>" +
 "<label class='YEWLTYBCCV'>" +
 ""+ToHTag(Translate("10286862909"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
GroupHeader_EndHtml(document,1,'11594068875'+l_nIdx+'','A')
} else {
}
Row_BeginHtml(document,l_nEvenOdd,'11426296764'+l_nIdx+'','A',true,-1)
document.writeln(
 "<div id='DIV_09E78F20"+l_nIdx+"' style='position:relative;height:22px'>" +
"")
document.writeln(
 "<span class='BHCCADUOZN_DIV' id='BHCCADUOZN_"+l_nIdx+"_DIV'>" +
 "<input name='FLGSEL_"+l_nIdx+"' id='BHCCADUOZN_"+l_nIdx+"' type='checkbox' value="+ToHTMLValue(WtH(w_FLGSEL,"C",1,0,''))+" "+(Eq('S',w_FLGSEL)?'CHECKED':'')+">" +
 "<label id='BHCCADUOZN_"+l_nIdx+"_LBL' for='BHCCADUOZN_"+l_nIdx+"' class='SPLabel'>"+ToHTag(Translate("11141062951"))+"</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel WEZTJDRFCK_DIV'>" +
 "<label class='WEZTJDRFCK'>" +
 ""+ToHTag(WtH(c_RAPPORTO,'C',25,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel SAWHPQDSMR_DIV'>" +
 "<label class='SAWHPQDSMR'>" +
 ""+ToHTag(WtH(c_DESCRAP,'C',50,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
Row_EndHtml(document,l_nEvenOdd,'11426296764'+l_nIdx+'','A')
Parms.Idx=l_nIdx;
Parms.Deep=l_nDeep;
Parms.EvenOdd=l_nEvenOdd;
}
Parms=new Object();
_Obli('FLGSEL',0,'BHCCADUOZN',false,"10861150445")
_Obli('dataope',2,'EDVZEHEPWR',false,"829201110")
_Obli('datareg',2,'MZRZWUCOCZ',false,"829201110")
_Obli('tipope',0,'OWENYZRHAH',false,"829257574")
