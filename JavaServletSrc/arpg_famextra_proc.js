function SetControlsValue() {
var c;
var c;
var tmp_TYIWXFLLFY = ToHTag(AsControlValue('<iframe width=\'750\' height=\'400\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_TYIWXFLLFY,tmp_TYIWXFLLFY)) {
if(c=Ctrl('TYIWXFLLFY')) c.innerHTML=tmp_TYIWXFLLFY;
e_TYIWXFLLFY=tmp_TYIWXFLLFY;
}
if(c=Ctrl('TFMYEDBUXJ')) selectRadio(c,w_tipo,'C')
if(c=Ctrl('NQCHGQZSVT')) c.value = WtH(w_daData,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('PZFGEEQVPK')) c.value = WtH(w_a_Data,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('LYJDXZJFGW')) c.value = WtH(w_protfile,'C',24,0,'')
if(c=Ctrl('AOHGKXZIJG')) ChkboxCheckUncheck(c,'S',w_flgstp)
if(c=Ctrl('AOHGKXZIJG')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('ILJJUNMQGU')) ChkboxCheckUncheck(c,'S',w_flganni)
if(c=Ctrl('ILJJUNMQGU')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('MHITXDESMW')) c.value = WtH(w_oldinter,'C',16,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('NQCHGQZSVT'),Ne(w_tipo,'R') || IsHiddenByStateDriver('daData'));
SetDisplay(Ctrl('GQEBBQASYL'),Ne(w_tipo,'R'));
SetDisplay(Ctrl('PZFGEEQVPK'),Ne(w_tipo,'R') || IsHiddenByStateDriver('a_Data'));
SetDisplay(Ctrl('PZFGEEQVPK_ZOOM'),Ne(w_tipo,'R'));
SetDisplay(Ctrl('AHDJAVIZRK'),Ne(w_tipo,'R'));
SetDisplay(Ctrl('LYJDXZJFGW'),Ne(w_tipo,'A') || IsHiddenByStateDriver('protfile'));
SetDisplay(Ctrl('LYJDXZJFGW_ZOOM'),Ne(w_tipo,'A'));
SetDisplay(Ctrl('CYUWCGZNEA'),Ne(w_tipo,'A'));
SetDisplay('ILJJUNMQGU_DIV',Ne(w_tipo,'R'));
SetDisplay(Ctrl('MHITXDESMW'),Ne(w_tipo,'P') || IsHiddenByStateDriver('oldinter'));
SetDisplay(Ctrl('JQZIUZNQCK'),Ne(w_tipo,'P'));
HideUI();
}
HideUI.lblids["a_Data"]=['AHDJAVIZRK'];
HideUI.lblids["daData"]=['GQEBBQASYL'];
HideUI.lblids["oldinter"]=['JQZIUZNQCK'];
HideUI.lblids["protfile"]=['CYUWCGZNEA'];
function ALQVOOWZEV_Click() {
var l_oWv = InitWvApplet();
l_oWv.setValue('w_a_Data',AsAppletValue(w_a_Data));
l_oWv.setValue('w_daData',AsAppletValue(w_daData));
l_oWv.setValue('w_flganni',AsAppletValue(w_flganni));
l_oWv.setValue('w_flgstp',AsAppletValue(w_flgstp));
l_oWv.setValue('w_gDescAzi',AsAppletValue(w_gDescAzi));
l_oWv.setValue('w_gIntemediario',AsAppletValue(w_gIntemediario));
l_oWv.setValue('w_oldinter',AsAppletValue(w_oldinter));
l_oWv.setValue('w_protfile',AsAppletValue(w_protfile));
l_oWv.setValue('w_tipo',AsAppletValue(w_tipo));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('w_a_Data,w_daData,w_flganni,w_flgstp,w_gDescAzi,w_gIntemediario,w_oldinter,w_protfile,w_tipo'));
if ( ! (Empty(w_tipo))) {
if (false || WindowConfirm(Translate('1312852873'))) {
SetLocationHref(null,'arrt_famextra'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cMode=hyperlink','elaborazione')
}
}
}
function href_AJXISNWTIP() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function href_MPCMAMHQST() {
SetLocationHref(null,'arrt_famextra_stp'+'?m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','elaborazione')
}
function href_JBNBDKBIAJ() {
_modifyandopen(ToResource('jsp/list_filesid_portlet.jsp'+'')+'?m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=600,width=800',null)
}
function TFMYEDBUXJ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipo(HtW(getRadioValue(Ctrl('TFMYEDBUXJ')),'C'),null,e);
}
function PZFGEEQVPK_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('PZFGEEQVPK'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('PZFGEEQVPK').value=ApplyPictureToDate(Ctrl('PZFGEEQVPK').value,TranslatePicture(datePattern),'PZFGEEQVPK');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('PZFGEEQVPK'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('PZFGEEQVPK');
}
}
}
SetActiveField(Ctrl('PZFGEEQVPK'),false);
e=(Ne(e,null)?e:window.event);
return Set_a_Data(HtW(Ctrl('PZFGEEQVPK').value,'D'),null,e) && dateisok;
}
function PZFGEEQVPK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PZFGEEQVPK'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('PZFGEEQVPK').value=WtH(w_a_Data,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('PZFGEEQVPK');
SetActiveField(Ctrl('PZFGEEQVPK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PZFGEEQVPK'),e);
}
function PZFGEEQVPK_ZOOM_Click() {
LaunchCalendar(Ctrl('PZFGEEQVPK'));
}
function LYJDXZJFGW_Valid(e) {
SetActiveField(Ctrl('LYJDXZJFGW'),false);
e=(Ne(e,null)?e:window.event);
return Set_protfile(HtW(Ctrl('LYJDXZJFGW').value,'C'),null,e);
}
function LYJDXZJFGW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LYJDXZJFGW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LYJDXZJFGW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LYJDXZJFGW'),e);
}
function LYJDXZJFGW_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('LYJDXZJFGW')),'linkview_LYJDXZJFGW','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function AOHGKXZIJG_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgstp(ChkboxValueAssign(Ctrl('AOHGKXZIJG'),'S','N','C',1,0,''),null,e);
}
function AOHGKXZIJG_OnFocus(e) {
SetActiveField(Ctrl('AOHGKXZIJG'),true);
}
function AOHGKXZIJG_OnBlur(e) {
SetActiveField(Ctrl('AOHGKXZIJG'),false);
}
function ILJJUNMQGU_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flganni(ChkboxValueAssign(Ctrl('ILJJUNMQGU'),'S','N','C',1,0,''),null,e);
}
function ILJJUNMQGU_OnFocus(e) {
SetActiveField(Ctrl('ILJJUNMQGU'),true);
}
function ILJJUNMQGU_OnBlur(e) {
SetActiveField(Ctrl('ILJJUNMQGU'),false);
}
function MHITXDESMW_Valid(e) {
SetActiveField(Ctrl('MHITXDESMW'),false);
e=(Ne(e,null)?e:window.event);
return Set_oldinter(HtW(Ctrl('MHITXDESMW').value,'C'),null,e);
}
function MHITXDESMW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MHITXDESMW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MHITXDESMW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MHITXDESMW'),e);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
c=Ctrl('TFMYEDBUXJ');
if ( ! (Empty(c))) {
c[0].onclick=TFMYEDBUXJ_Valid;
c[1].onclick=TFMYEDBUXJ_Valid;
c[2].onclick=TFMYEDBUXJ_Valid;
c[3].onclick=TFMYEDBUXJ_Valid;
}
if(c=Ctrl('PZFGEEQVPK')) c.onblur=PZFGEEQVPK_Valid;
if(c=Ctrl('PZFGEEQVPK')) c.onfocus=PZFGEEQVPK_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('PZFGEEQVPK')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('LYJDXZJFGW')) c.onblur=LYJDXZJFGW_Valid;
if(c=Ctrl('LYJDXZJFGW')) c.onfocus=LYJDXZJFGW_OnFocus;
if(c=Ctrl('AOHGKXZIJG')) c.onclick=AOHGKXZIJG_Valid;
if(c=Ctrl('AOHGKXZIJG')) c.onfocus=AOHGKXZIJG_OnFocus;
if(c=Ctrl('AOHGKXZIJG')) c.onblur=AOHGKXZIJG_OnBlur;
if(c=Ctrl('ILJJUNMQGU')) c.onclick=ILJJUNMQGU_Valid;
if(c=Ctrl('ILJJUNMQGU')) c.onfocus=ILJJUNMQGU_OnFocus;
if(c=Ctrl('ILJJUNMQGU')) c.onblur=ILJJUNMQGU_OnBlur;
if(c=Ctrl('MHITXDESMW')) c.onblur=MHITXDESMW_Valid;
if(c=Ctrl('MHITXDESMW')) c.onfocus=MHITXDESMW_OnFocus;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_famextra_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_famextra_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["ALQVOOWZEV","TFMYEDBUXJ"]};
function Help() {
windowOpenForeground('../doc/arpg_famextra_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_gDescAzi=a[1];
w_tipo=a[2];
w_daData=a[3];
w_a_Data=a[4];
w_protfile=a[5];
w_flgstp=a[6];
w_flganni=a[7];
w_oldinter=a[8];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_famextra',m_cSelectedPage);
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
l_bEnabled= ! ( ! (Empty(w_tipo)));
SetDisabled(Ctrl('ALQVOOWZEV'),l_bEnabled);
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
function Set_a_Data(ctrlValue,kmode,e) {
if (Ne(w_a_Data,ctrlValue)) {
var ctl = _GetCtl(e,'PZFGEEQVPK');
if (_tracker.goon(ctl,ctrlValue)) {
w_a_Data=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PZFGEEQVPK',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_oldinter(ctrlValue,kmode,e) {
if (Ne(w_oldinter,ctrlValue)) {
var ctl = _GetCtl(e,'MHITXDESMW');
if (_tracker.goon(ctl,ctrlValue)) {
w_oldinter=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MHITXDESMW',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',16,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_tipo(ctrlValue,kmode,e) {
if (Ne(w_tipo,ctrlValue)) {
var ctl = _GetCtl(e,'TFMYEDBUXJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipo=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TFMYEDBUXJ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_protfile(ctrlValue,kmode,e) {
if (Ne(w_protfile,ctrlValue)) {
var ctl = _GetCtl(e,'LYJDXZJFGW');
if (_tracker.goon(ctl,ctrlValue)) {
w_protfile=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LYJDXZJFGW',0);
if (l_bResult) {
l_bResult=Link_LYJDXZJFGW(kmode);
if ( ! (l_bResult)) {
w_protfile=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',24,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',24,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flganni(ctrlValue,kmode,e) {
if (Ne(w_flganni,ctrlValue)) {
var ctl = _GetCtl(e,'ILJJUNMQGU');
if (_tracker.goon(ctl,ctrlValue)) {
w_flganni=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ILJJUNMQGU',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgstp(ctrlValue,kmode,e) {
if (Ne(w_flgstp,ctrlValue)) {
var ctl = _GetCtl(e,'AOHGKXZIJG');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgstp=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AOHGKXZIJG',0);
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
w_daData=CharToDate('20110101');
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function Link_LYJDXZJFGW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_protfile);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('PROTOCOLLO',w_protfile,24,0);
l_Appl.SetFields('PROTOCOLLO');
l_Appl.SetTypes('C');
l_Appl.LinkTable('aesaldi');
l_Appl.SetID('LYJDXZJFGW');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_protfile=l_Appl.GetStringValue('PROTOCOLLO',24,0);
} else {
Link_LYJDXZJFGW_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_LYJDXZJFGW';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('ANNULLATO',1,null,true,'<>');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_LYJDXZJFGW();
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
function Link_LYJDXZJFGW_Blank() {
w_protfile='';
}
function LOpt_LYJDXZJFGW() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('aesaldi','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('PROTOCOLLO','C'));
l_oWv.setValue('LinkedField',WtA('PROTOCOLLO','C'));
l_oWv.setValue('UID',WtA('LYJDXZJFGW','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['LYJDXZJFGW'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10759313073'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'LYJDXZJFGW')) {
last_focused_comp=GetLastFocusedElementOfLink('LYJDXZJFGW');
function SetMethod_LYJDXZJFGW() {
Set_protfile(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_LYJDXZJFGW();
} else {
setTimeout(SetMethod_LYJDXZJFGW,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'LYJDXZJFGW')) {
return [Ctrl('LYJDXZJFGW')];
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
if ( ! (_ChkObl('TFMYEDBUXJ',1))) {
_SignErr('TFMYEDBUXJ');
m_cLastWorkVarErrorMsg='tipo';
l_bResult=false;
w_tipo=HtW('','C');
} else if ( ! (_ChkObl('PZFGEEQVPK',1))) {
_SignErr('PZFGEEQVPK');
m_cLastWorkVarErrorMsg='a_Data';
l_bResult=false;
w_a_Data=HtW('','D');
} else if ( ! (_ChkObl('LYJDXZJFGW',1))) {
_SignErr('LYJDXZJFGW');
m_cLastWorkVarErrorMsg='900120012';
l_bResult=false;
w_protfile=HtW('','C');
} else if ( ! (_ChkObl('AOHGKXZIJG',1))) {
_SignErr('AOHGKXZIJG');
m_cLastWorkVarErrorMsg='flgstp';
l_bResult=false;
w_flgstp='N';
} else if ( ! (_ChkObl('ILJJUNMQGU',1))) {
_SignErr('ILJJUNMQGU');
m_cLastWorkVarErrorMsg='flganni';
l_bResult=false;
w_flganni='N';
} else if ( ! (_ChkObl('MHITXDESMW',1))) {
_SignErr('MHITXDESMW');
m_cLastWorkVarErrorMsg='582839624';
l_bResult=false;
w_oldinter=HtW('','C');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('PZFGEEQVPK_ZOOM',lc)) {
return 0;
}
if (Eq('LYJDXZJFGW_ZOOM',lc)) {
return 0;
}
if (Eq('LYJDXZJFGW',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_LYJDXZJFGW();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('ANNULLATO',1,null,true,'<>');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_oWv.setValue('FieldFilter',l_cFieldFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('gIntemediario',WtA(w_gIntemediario,'C'));
l_oWv.setValue('gDescAzi',WtA(w_gDescAzi,'C'));
l_oWv.setValue('tipo',WtA(w_tipo,'C'));
l_oWv.setValue('daData',WtA(w_daData,'D'));
l_oWv.setValue('a_Data',WtA(w_a_Data,'D'));
l_oWv.setValue('protfile',WtA(w_protfile,'C'));
l_oWv.setValue('flgstp',WtA(w_flgstp,'C'));
l_oWv.setValue('flganni',WtA(w_flganni,'C'));
l_oWv.setValue('oldinter',WtA(w_oldinter,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["gIntemediario","gDescAzi","tipo","daData","a_Data","protfile","flgstp","flganni","oldinter"];
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
w_daData=CharToDate('20110101');
Link_LYJDXZJFGW(null);
if (start && Eq(At(',flgstp,',pseq),0)) {
w_flgstp='N';
}
if (start && Eq(At(',flganni,',pseq),0)) {
w_flganni='N';
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
_Obli('a_Data',2,'PZFGEEQVPK',false)
_Obli('oldinter',0,'MHITXDESMW',false,"582839624")
_Obli('tipo',0,'TFMYEDBUXJ',false)
_Obli('protfile',0,'LYJDXZJFGW',false,"900120012")
_Obli('flganni',0,'ILJJUNMQGU',false)
_Obli('flgstp',0,'AOHGKXZIJG',false)
