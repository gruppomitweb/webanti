function SetControlsValue() {
var c;
var c;
if(c=Ctrl('WSFEHJKMXC')) ChkboxCheckUncheck(c,'S',w_flgglob)
if(c=Ctrl('WSFEHJKMXC')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('MRVXCEHVUD')) c.value = WtH(w_coddip,'C',6,0,'')
if(c=Ctrl('DPKVLWHCIG')) c.value = WtH(w_DaDatOpe,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('MTJDZQTEIR')) c.value = WtH(w_ADatOpe,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
var tmp_JWQCROYWHX = ToHTag(AsControlValue(w_xdesdip));
if (Ne(e_JWQCROYWHX,tmp_JWQCROYWHX)) {
if(c=Ctrl('JWQCROYWHX')) c.innerHTML=tmp_JWQCROYWHX;
e_JWQCROYWHX=tmp_JWQCROYWHX;
}
if (Gt(m_nRows,0) && Lt(m_nCurrentRow,m_oTrsFW.length)) {
if (Ne(Ctrl('BBVZXDYMJX_'+m_nCurrentRow),null)) {
if(c=Ctrl('BBVZXDYMJX_'+m_nCurrentRow)) ChkboxCheckUncheck(c,'S',w_FLGSEL)
if(c=Ctrl('BBVZXDYMJX_'+m_nCurrentRow)) ChkboxValueAssign(c,'S','N','C',1,0,'')
}
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
if (Gt(m_nRows,0)) {
SetDisplay(Ctrl('ACJEOURJYI'),true);
}
HideUI();
}
HideUI.lblids["ADatOpe"]=['BGHAITOPMU'];
HideUI.lblids["DaDatOpe"]=['HPGJXQIVYG'];
HideUI.lblids["coddip"]=['ASEPFXTVJK'];
function WSFEHJKMXC_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgglob(ChkboxValueAssign(Ctrl('WSFEHJKMXC'),'S','N','C',1,0,''),null,e);
}
function WSFEHJKMXC_OnFocus(e) {
SetActiveField(Ctrl('WSFEHJKMXC'),true);
}
function WSFEHJKMXC_OnBlur(e) {
SetActiveField(Ctrl('WSFEHJKMXC'),false);
}
function MRVXCEHVUD_Valid(e) {
SetActiveField(Ctrl('MRVXCEHVUD'),false);
e=(Ne(e,null)?e:window.event);
return Set_coddip(HtW(Ctrl('MRVXCEHVUD').value,'C'),null,e);
}
function MRVXCEHVUD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MRVXCEHVUD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MRVXCEHVUD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MRVXCEHVUD'),e);
}
function MRVXCEHVUD_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('MRVXCEHVUD')),'linkview_MRVXCEHVUD','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
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
return Set_DaDatOpe(HtW(Ctrl('DPKVLWHCIG').value,'D'),null,e) && dateisok;
}
function DPKVLWHCIG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DPKVLWHCIG'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('DPKVLWHCIG').value=WtH(w_DaDatOpe,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('DPKVLWHCIG');
SetActiveField(Ctrl('DPKVLWHCIG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DPKVLWHCIG'),e);
}
function MTJDZQTEIR_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('MTJDZQTEIR'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('MTJDZQTEIR').value=ApplyPictureToDate(Ctrl('MTJDZQTEIR').value,TranslatePicture(datePattern),'MTJDZQTEIR');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('MTJDZQTEIR'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('MTJDZQTEIR');
}
}
}
SetActiveField(Ctrl('MTJDZQTEIR'),false);
e=(Ne(e,null)?e:window.event);
return Set_ADatOpe(HtW(Ctrl('MTJDZQTEIR').value,'D'),null,e) && dateisok;
}
function MTJDZQTEIR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MTJDZQTEIR'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('MTJDZQTEIR'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('MTJDZQTEIR').value=WtH(w_ADatOpe,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('MTJDZQTEIR');
SetActiveField(Ctrl('MTJDZQTEIR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MTJDZQTEIR'),e);
}
function href_FLFHSXPWZI() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_trasffra_age']));
SendData('start','arrt_trasffra_age'+'',HParApplet().asString());
}
function href_VRHQBWKFPP() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_trasffra_age_sel']));
SendData('start','arrt_trasffra_age_sel'+'',HParApplet().asString());
}
function href_HDSXZTLKVK() {
Update()
}
function href_ZWTNEMXOFQ() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('pTipo',AsAppletValue('D'));
SetHypPar('m_cParameterSequence',AsAppletValue('pTipo'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_seldes_trasfope']));
SendData('start','arrt_seldes_trasfope'+'',HParApplet().asString());
}
function href_FCATLNLMSB() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('pTipo',AsAppletValue('S'));
SetHypPar('m_cParameterSequence',AsAppletValue('pTipo'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_seldes_trasfope']));
SendData('start','arrt_seldes_trasfope'+'',HParApplet().asString());
}
function BBVZXDYMJX_Valid(e) {
var org = GetEventSrcElement(e);
if ( ! (org.focused)) {
var c = org.checked;
org.focus();
org.checked=c;
}
e=(Ne(e,null)?e:window.event);
return Set_FLGSEL(ChkboxValueAssign(Ctrl('BBVZXDYMJX_'+m_nCurrentRow),'S','N','C',1,0,''),null,e);
}
function BBVZXDYMJX_OnFocus(e) {
var org;
org=GetEventSrcElement(e);
org.focused=true;
ChangeRow(Val(Right(org.name,Len(org.name)-RAt('_',org.name))));
}
function BBVZXDYMJX_OnBlur(e) {
SetActiveField(Ctrl('BBVZXDYMJX_'+m_nCurrentRow),false);
}
function BBVZXDYMJX_OnBlur(e) {
var org = GetEventSrcElement(e);
org.focused=false;
}
function BBVZXDYMJX_OnFocus(e) {
var org;
org=GetEventSrcElement(e);
org.focused=true;
ChangeRow(Val(Right(org.name,Len(org.name)-RAt('_',org.name))));
}
function href_PTXYMSWBZO() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('WSFEHJKMXC')) c.onclick=WSFEHJKMXC_Valid;
if(c=Ctrl('WSFEHJKMXC')) c.onfocus=WSFEHJKMXC_OnFocus;
if(c=Ctrl('WSFEHJKMXC')) c.onblur=WSFEHJKMXC_OnBlur;
if(c=Ctrl('MRVXCEHVUD')) c.onblur=MRVXCEHVUD_Valid;
if(c=Ctrl('MRVXCEHVUD')) c.onfocus=MRVXCEHVUD_OnFocus;
if(c=Ctrl('DPKVLWHCIG')) c.onblur=DPKVLWHCIG_Valid;
if(c=Ctrl('DPKVLWHCIG')) c.onfocus=DPKVLWHCIG_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('DPKVLWHCIG')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('MTJDZQTEIR')) c.onblur=MTJDZQTEIR_Valid;
if(c=Ctrl('MTJDZQTEIR')) c.onfocus=MTJDZQTEIR_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('MTJDZQTEIR')) c.onkeypress=CheckDateChar;
}
}
var l_nOldRow = m_nCurrentRow;
m_nCurrentRow=0;
while (Lt(m_nCurrentRow,m_nRows)) {
if(c=Ctrl('BBVZXDYMJX_'+m_nCurrentRow)) c.onclick=BBVZXDYMJX_Valid;
if(c=Ctrl('BBVZXDYMJX_'+m_nCurrentRow)) c.onfocus=BBVZXDYMJX_OnFocus;
if(c=Ctrl('BBVZXDYMJX_'+m_nCurrentRow)) c.onblur=BBVZXDYMJX_OnBlur;
if(c=Ctrl('BBVZXDYMJX_'+m_nCurrentRow)) c.onfocus=BBVZXDYMJX_OnFocus;
if(c=Ctrl('BBVZXDYMJX_'+m_nCurrentRow)) c.onblur=BBVZXDYMJX_OnBlur;
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
FocusFirstComponent.otherwise={"page_1":["WSFEHJKMXC"]};
function Help() {
windowOpenForeground('../doc/arpg_trasffra_age_old_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_flgage=a[1];
w_flgglob=a[2];
w_coddip=a[3];
w_DaDatOpe=a[4];
w_ADatOpe=a[5];
w_cdadata=a[6];
w_c_adata=a[7];
w_xdesdip=a[8];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_trasffra_age_old',m_cSelectedPage);
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
l_bEnabled= ! (Eq(w_flgglob,'N')) || IsDisabledByStateDriver('coddip');
SetDisabled(Ctrl('MRVXCEHVUD'),l_bEnabled);
SetDisabled(Ctrl('MRVXCEHVUD_ZOOM'),l_bEnabled);
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
function Set_ADatOpe(ctrlValue,kmode,e) {
if (Ne(w_ADatOpe,ctrlValue)) {
var ctl = _GetCtl(e,'MTJDZQTEIR');
if (_tracker.goon(ctl,ctrlValue)) {
w_ADatOpe=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MTJDZQTEIR',0);
if (l_bResult) {
l_bResult=Ge(w_ADatOpe,w_DaDatOpe);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='ADatOpe';
m_cLastMsgError=AlertErrorMessage('10357201410');
}
if ( ! (l_bResult)) {
w_ADatOpe=HtW('','D');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D')));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgglob(ctrlValue,kmode,e) {
if (Ne(w_flgglob,ctrlValue)) {
var ctl = _GetCtl(e,'WSFEHJKMXC');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgglob=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WSFEHJKMXC',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_coddip(ctrlValue,kmode,e) {
if (Ne(w_coddip,ctrlValue)) {
var ctl = _GetCtl(e,'MRVXCEHVUD');
if (_tracker.goon(ctl,ctrlValue)) {
w_coddip=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MRVXCEHVUD',0);
if (l_bResult) {
l_bResult=Link_MRVXCEHVUD(kmode);
if ( ! (l_bResult)) {
w_coddip=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',6,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',6,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DaDatOpe(ctrlValue,kmode,e) {
if (Ne(w_DaDatOpe,ctrlValue)) {
var ctl = _GetCtl(e,'DPKVLWHCIG');
if (_tracker.goon(ctl,ctrlValue)) {
w_DaDatOpe=ctrlValue;
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
function Set_FLGSEL(ctrlValue,kmode,e) {
if (Ne(w_FLGSEL,ctrlValue)) {
var ctl = _GetCtl(e,'BBVZXDYMJX_'+m_nCurrentRow+'');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGSEL=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BBVZXDYMJX',0);
DoFieldsUpdate(l_bResult);
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
w_flgage='S';
w_cdadata=DateToChar(w_DaDatOpe);
w_c_adata=DateToChar(w_ADatOpe);
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function Link_MRVXCEHVUD(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_coddip);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('AGENTE',w_flgage,1,0);
l_Appl.SetStringKey('CODDIP',w_coddip,6,0);
l_Appl.SetFields('CODDIP,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetID('MRVXCEHVUD');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_coddip=l_Appl.GetStringValue('CODDIP',6,0);
w_xdesdip=l_Appl.GetStringValue('DESCRIZ',30,0);
} else {
Link_MRVXCEHVUD_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_MRVXCEHVUD';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_MRVXCEHVUD();
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
function Link_MRVXCEHVUD_Blank() {
w_coddip='';
w_xdesdip='';
}
function LOpt_MRVXCEHVUD() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('AGENTE,CODDIP','C'));
l_oWv.setValue('LinkedField',WtA('CODDIP','C'));
l_oWv.setValue('UID',WtA('MRVXCEHVUD','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['MRVXCEHVUD'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1813072817'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'MRVXCEHVUD')) {
last_focused_comp=GetLastFocusedElementOfLink('MRVXCEHVUD');
function SetMethod_MRVXCEHVUD() {
Set_coddip(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_MRVXCEHVUD();
} else {
setTimeout(SetMethod_MRVXCEHVUD,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'MRVXCEHVUD')) {
return [Ctrl('MRVXCEHVUD')];
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
if ( ! (_ChkObl('WSFEHJKMXC',1))) {
_SignErr('WSFEHJKMXC');
m_cLastWorkVarErrorMsg='flgglob';
l_bResult=false;
w_flgglob='N';
} else if ((Eq(w_flgglob,'N')) && ( ! (_ChkObl('MRVXCEHVUD',1)))) {
_SignErr('MRVXCEHVUD');
m_cLastWorkVarErrorMsg='coddip';
l_bResult=false;
w_coddip=HtW('','C');
} else if ( ! (_ChkObl('DPKVLWHCIG',1))) {
_SignErr('DPKVLWHCIG');
m_cLastWorkVarErrorMsg='DaDatOpe';
l_bResult=false;
w_DaDatOpe=HtW('','D');
} else if (( ! (_ChkObl('MTJDZQTEIR',1))) || ( ! (Ge(w_ADatOpe,w_DaDatOpe)))) {
_SignErr('MTJDZQTEIR','10357201410');
l_bResult=false;
w_ADatOpe=HtW('','D');
} else if ( ! (_ChkObl('BBVZXDYMJX',1))) {
_SignErr('BBVZXDYMJX_'+m_nCurrentRow+'');
m_cLastWorkVarErrorMsg='10709584481';
l_bResult=false;
w_FLGSEL='N';
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('MRVXCEHVUD_ZOOM',lc)) {
return 0;
}
if (Eq('MRVXCEHVUD',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_MRVXCEHVUD();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFixedFilter=l_cFixedFilter+l_cAndOp+_flt_('AGENTE',w_flgage,'C',true);
if ( ! (Empty(l_cFixedFilter))) {
l_cAndOp=' and ';
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('FLGSEL',WtA(w_FLGSEL,'C'));
l_oWv.setValue('flgage',WtA(w_flgage,'C'));
l_oWv.setValue('flgglob',WtA(w_flgglob,'C'));
l_oWv.setValue('coddip',WtA(w_coddip,'C'));
l_oWv.setValue('DaDatOpe',WtA(w_DaDatOpe,'D'));
l_oWv.setValue('ADatOpe',WtA(w_ADatOpe,'D'));
l_oWv.setValue('cdadata',WtA(w_cdadata,'C'));
l_oWv.setValue('c_adata',WtA(w_c_adata,'C'));
l_oWv.setValue('xdesdip',WtA(w_xdesdip,'C'));
_FillChildren(l_oWv);
l_oWv.setValue('m_oTrs',TrsApplet().asString());
}
_FillChildren.n=[];
FillWv.n=["FLGSEL","flgage","flgglob","coddip","DaDatOpe","ADatOpe","cdadata","c_adata","xdesdip"];
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
if (Empty(w_coddip) && Ne(opener.w_coddip,null)) {
TransferBetweenWindows(opener,'w_coddip',null,'Set_coddip');
}
if (Empty(w_DaDatOpe) && Ne(opener.w_DaDatOpe,null)) {
TransferBetweenWindows(opener,'w_DaDatOpe',null,'Set_DaDatOpe');
}
if (Empty(w_ADatOpe) && Ne(opener.w_ADatOpe,null)) {
TransferBetweenWindows(opener,'w_ADatOpe',null,'Set_ADatOpe');
}
if (Empty(w_cdadata) && Ne(opener.w_cdadata,null)) {
TransferBetweenWindows(opener,'w_cdadata','w_cdadata');
}
if (Empty(w_c_adata) && Ne(opener.w_c_adata,null)) {
TransferBetweenWindows(opener,'w_c_adata','w_c_adata');
}
}
}
m_bCalculating=true;
w_flgage='S';
if (start && Eq(At(',flgglob,',pseq),0)) {
w_flgglob='N';
}
Link_MRVXCEHVUD(null);
w_cdadata=DateToChar(w_DaDatOpe);
w_c_adata=DateToChar(w_ADatOpe);
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
  this.k_FLGSEL_NUMPROG = arguments[2]
  this.m_nRowStatus = arguments[3]
}
function TrsQueryRow() {
  this.c_NUMPROG = arguments[0]
  this.c_DATAOPE = arguments[1]
  this.c_RAPPORTO = arguments[2]
  this.c_CONNESCLI = arguments[3]
  this.c_TOTLIRE = arguments[4]
  this.c_TOTCONT = arguments[5]
  this.c_VALUTA = arguments[6]
  this.c_IDBASE = arguments[7]
  this.c_CODDIP = arguments[8]
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
c_NUMPROG=row.c_NUMPROG;
c_DATAOPE=row.c_DATAOPE;
c_RAPPORTO=row.c_RAPPORTO;
c_CONNESCLI=row.c_CONNESCLI;
c_TOTLIRE=row.c_TOTLIRE;
c_TOTCONT=row.c_TOTCONT;
c_VALUTA=row.c_VALUTA;
c_IDBASE=row.c_IDBASE;
c_CODDIP=row.c_CODDIP;
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
row.c_NUMPROG=c_NUMPROG;
row.c_DATAOPE=c_DATAOPE;
row.c_RAPPORTO=c_RAPPORTO;
row.c_CONNESCLI=c_CONNESCLI;
row.c_TOTLIRE=c_TOTLIRE;
row.c_TOTCONT=c_TOTCONT;
row.c_VALUTA=c_VALUTA;
row.c_IDBASE=c_IDBASE;
row.c_CODDIP=c_CODDIP;
}
}
function BlankQueryFields() {
c_NUMPROG='';
c_DATAOPE=NullDate();
c_RAPPORTO='';
c_CONNESCLI='';
c_TOTLIRE=0;
c_TOTCONT=0;
c_VALUTA='';
c_IDBASE='';
c_CODDIP='';
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
var l_DBMPSAJNIE = false;
var l_old_DBMPSAJNIE = l_DBMPSAJNIE;
Body_BeginHtml(81,'',0,'A','');
BlankQueryFields();
while ( ! (l_bEof)) {
l_oQuery=m_oTrsQuery[l_nIdx];
l_oFields=m_oTrsFW[l_nIdx];
l_nDeep=0;
if (Lt(l_nIdx,m_nRows)) {
m_nCurrentRow=l_nIdx;
TrsToWork();
l_DBMPSAJNIE=true;
if (Eq(l_nIdx,0)) {
l_nDeep=1;
} else {
if (Ne(l_old_DBMPSAJNIE,l_DBMPSAJNIE)) {
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
GroupFooter_BeginHtml(document,1,'11655068198'+l_nIdx+'','A',true,false)
GroupFooter_EndHtml(document,1,'11655068198'+l_nIdx+'','A')
} else {
}
l_nIdx=l_nIdx+1;
m_nCurrentRow=l_nIdx;
TrsToWork();
l_old_DBMPSAJNIE = l_DBMPSAJNIE;
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
Update_Button("ACJEOURJYI",Translate("113933141"),"","","","CLASS=FormDefault STYLE='display:"+(true?'none':'inline')+"'","")
}
Body_EndHtml('A');
}
function DrawLine(document) {
l_nIdx=Parms.Idx;
l_nDeep=Parms.Deep;
l_nEvenOdd=Parms.EvenOdd;
if (Ge(2,l_nDeep)) {
GroupHeader_BeginHtml(document,1,'11621513766'+l_nIdx+'','A',true,false)
document.writeln(
 "<div id='DIV_0BB6D958"+l_nIdx+"' style='position:relative;height:16px'>" +
"")
document.writeln(
 "<span class=' SPLabel DIWJSXFYLW_DIV'>" +
 "<label class='DIWJSXFYLW'>" +
 ""+ToHTag(Translate("829201110"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel WEUNTCEZTI_DIV'>" +
 "<label class='WEUNTCEZTI'>" +
 ""+ToHTag(Translate("11446421191"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel JUIALTQGYN_DIV'>" +
 "<label class='JUIALTQGYN'>" +
 ""+ToHTag(Translate("1805022818"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel BWDHQRZLTC_DIV'>" +
 "<label class='BWDHQRZLTC'>" +
 ""+ToHTag(Translate("1824000386"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel KKONMMBUPW_DIV'>" +
 "<label class='KKONMMBUPW'>" +
 ""+ToHTag(Translate("1825772649"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel NFMIERMJRB_DIV'>" +
 "<label class='NFMIERMJRB'>" +
 ""+ToHTag(Translate("10948496749"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
GroupHeader_EndHtml(document,1,'11621513766'+l_nIdx+'','A')
} else {
}
Row_BeginHtml(document,l_nEvenOdd,'11453741655'+l_nIdx+'','A',true,-1)
document.writeln(
 "<div id='DIV_0A148BA0"+l_nIdx+"' style='position:relative;height:22px'>" +
"")
document.writeln(
 "<span class='BBVZXDYMJX_DIV' id='BBVZXDYMJX_"+l_nIdx+"_DIV'>" +
 "<input name='FLGSEL_"+l_nIdx+"' id='BBVZXDYMJX_"+l_nIdx+"' type='checkbox' value="+ToHTMLValue(WtH(w_FLGSEL,"C",1,0,''))+" "+(Eq('S',w_FLGSEL)?'CHECKED':'')+">" +
 "<label id='BBVZXDYMJX_"+l_nIdx+"_LBL' for='BBVZXDYMJX_"+l_nIdx+"' class='SPLabel'>"+ToHTag(Translate("10638322983"))+"</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel INHUFYJSGO_DIV'>" +
 "<label class='INHUFYJSGO'>" +
 ""+ToHTag(WtH(c_DATAOPE,'D',8,0,'DD-MM-YYYY'))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel VCVHCSGAYA_DIV'>" +
 "<label class='VCVHCSGAYA'>" +
 ""+ToHTag(WtH(c_NUMPROG,'C',11,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel RNOKLAJWBF_DIV'>" +
 "<label class='RNOKLAJWBF'>" +
 ""+ToHTag(WtH(c_RAPPORTO,'C',25,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel FWVRGICMKB_DIV'>" +
 "<label class='FWVRGICMKB'>" +
 ""+ToHTag(WtH(c_CONNESCLI,'C',16,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel BCCPSVUVJE_DIV'>" +
 "<label class='BCCPSVUVJE'>" +
 ""+ToHTag(WtH(c_TOTLIRE,'N',15,2,'999,999,999.99'))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel KEFLALYAMR_DIV'>" +
 "<label class='KEFLALYAMR'>" +
 ""+ToHTag(WtH(c_TOTCONT,'N',15,2,'999,999,999.99'))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
Row_EndHtml(document,l_nEvenOdd,'11453741655'+l_nIdx+'','A')
Parms.Idx=l_nIdx;
Parms.Deep=l_nDeep;
Parms.EvenOdd=l_nEvenOdd;
}
Parms=new Object();
_Obli('ADatOpe',2,'MTJDZQTEIR',false)
_Obli('flgglob',0,'WSFEHJKMXC',false)
_Obli('coddip',0,'MRVXCEHVUD',false)
_Obli('DaDatOpe',2,'DPKVLWHCIG',false)
_Obli('FLGSEL',0,'BBVZXDYMJX',false,"10709584481")
