function SetControlsValue() {
var c;
var c;
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'460\' height=\'80\' id =\'elaborazione\' name =\'elaborazione\' frameborder=\'0\'  border=\'0\' align=\'TOP\' marginwidth=\'0\' marginheight=\'0\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('RWYSXVADUD')) ChkboxCheckUncheck(c,'S',w_rapuif)
if(c=Ctrl('RWYSXVADUD')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('CENYIVTJCD')) ChkboxCheckUncheck(c,'S',w_opeuif)
if(c=Ctrl('CENYIVTJCD')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('CPLLFIWSVW')) ChkboxCheckUncheck(c,'S',w_frzuif)
if(c=Ctrl('CPLLFIWSVW')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('JALETSSOWI')) ChkboxCheckUncheck(c,'S',w_rapage)
if(c=Ctrl('JALETSSOWI')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('YSMCMCPCUY')) ChkboxCheckUncheck(c,'S',w_opeage)
if(c=Ctrl('YSMCMCPCUY')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('IEUGAKXYTZ')) ChkboxCheckUncheck(c,'S',w_titaui)
if(c=Ctrl('IEUGAKXYTZ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('FMRRWRYWEQ')) ChkboxCheckUncheck(c,'S',w_flgpart)
if(c=Ctrl('FMRRWRYWEQ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('IRVRFIWCHD')) c.value = WtH(w_prgidb,'N',10,0,'')
if(c=Ctrl('SHFWFZUZAU')) c.value = WtH(w_prgnprg,'N',10,0,'')
if(c=Ctrl('BBWGQILZDE')) c.value = WtH(w_prgiope,'N',10,0,'')
if(c=Ctrl('DGCPENGASO')) c.value = WtH(w_daData,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('YSDLBTYKKH')) ChkboxCheckUncheck(c,'S',w_dataover)
if(c=Ctrl('YSDLBTYKKH')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('BXVKMROMSG')) c.value = WtH(w_ngiorni,'N',2,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
SetDisplay('FMRRWRYWEQ_DIV',Eq(w_gFlgWU,'N'));
SetDisplay(Ctrl('IRVRFIWCHD'),Eq(w_gFlgWU,'N') || IsHiddenByStateDriver('prgidb'));
SetDisplay(Ctrl('BQBTJCITDO'),Eq(w_gFlgWU,'N'));
SetDisplay(Ctrl('SHFWFZUZAU'),Eq(w_gFlgWU,'N') || IsHiddenByStateDriver('prgnprg'));
SetDisplay(Ctrl('ZUPQPKRXOU'),Eq(w_gFlgWU,'N'));
SetDisplay(Ctrl('BBWGQILZDE'),Eq(w_gFlgWU,'N') || IsHiddenByStateDriver('prgiope'));
SetDisplay(Ctrl('HEDBPKUMXR'),Eq(w_gFlgWU,'N'));
SetDisplay(Ctrl('BXVKMROMSG'),Eq(w_dataover,'N') || IsHiddenByStateDriver('ngiorni'));
HideUI();
}
HideUI.lblids["daData"]=['JJDJMFKGFW'];
HideUI.lblids["prgidb"]=['BQBTJCITDO'];
HideUI.lblids["prgiope"]=['HEDBPKUMXR'];
HideUI.lblids["prgnprg"]=['ZUPQPKRXOU'];
function href_ROZQLWLMOH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('w_frzuif',AsAppletValue(w_frzuif));
l_oWv.setValue('w_opeage',AsAppletValue(w_opeage));
l_oWv.setValue('w_opeuif',AsAppletValue(w_opeuif));
l_oWv.setValue('w_rapage',AsAppletValue(w_rapage));
l_oWv.setValue('w_rapuif',AsAppletValue(w_rapuif));
l_oWv.setValue('w_titaui',AsAppletValue(w_titaui));
l_oWv.setValue('w_flgpart',AsAppletValue(w_flgpart));
l_oWv.setValue('w_prgidb',AsAppletValue(w_prgidb));
l_oWv.setValue('w_prgiope',AsAppletValue(w_prgiope));
l_oWv.setValue('w_prgnprg',AsAppletValue(w_prgnprg));
l_oWv.setValue('w_daData',AsAppletValue(w_daData));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('w_frzuif,w_opeage,w_opeuif,w_rapage,w_rapuif,w_titaui,w_flgpart,w_prgidb,w_prgiope,w_prgnprg,w_daData'));
SetLocationHref(null,'arrt_riordina'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function RWYSXVADUD_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_rapuif(ChkboxValueAssign(Ctrl('RWYSXVADUD'),'S','N','C',1,0,''),null,e);
}
function RWYSXVADUD_OnFocus(e) {
SetActiveField(Ctrl('RWYSXVADUD'),true);
}
function RWYSXVADUD_OnBlur(e) {
SetActiveField(Ctrl('RWYSXVADUD'),false);
}
function CENYIVTJCD_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_opeuif(ChkboxValueAssign(Ctrl('CENYIVTJCD'),'S','N','C',1,0,''),null,e);
}
function CENYIVTJCD_OnFocus(e) {
SetActiveField(Ctrl('CENYIVTJCD'),true);
}
function CENYIVTJCD_OnBlur(e) {
SetActiveField(Ctrl('CENYIVTJCD'),false);
}
function CPLLFIWSVW_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_frzuif(ChkboxValueAssign(Ctrl('CPLLFIWSVW'),'S','N','C',1,0,''),null,e);
}
function CPLLFIWSVW_OnFocus(e) {
SetActiveField(Ctrl('CPLLFIWSVW'),true);
}
function CPLLFIWSVW_OnBlur(e) {
SetActiveField(Ctrl('CPLLFIWSVW'),false);
}
function JALETSSOWI_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_rapage(ChkboxValueAssign(Ctrl('JALETSSOWI'),'S','N','C',1,0,''),null,e);
}
function JALETSSOWI_OnFocus(e) {
SetActiveField(Ctrl('JALETSSOWI'),true);
}
function JALETSSOWI_OnBlur(e) {
SetActiveField(Ctrl('JALETSSOWI'),false);
}
function YSMCMCPCUY_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_opeage(ChkboxValueAssign(Ctrl('YSMCMCPCUY'),'S','N','C',1,0,''),null,e);
}
function YSMCMCPCUY_OnFocus(e) {
SetActiveField(Ctrl('YSMCMCPCUY'),true);
}
function YSMCMCPCUY_OnBlur(e) {
SetActiveField(Ctrl('YSMCMCPCUY'),false);
}
function IEUGAKXYTZ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_titaui(ChkboxValueAssign(Ctrl('IEUGAKXYTZ'),'S','N','C',1,0,''),null,e);
}
function IEUGAKXYTZ_OnFocus(e) {
SetActiveField(Ctrl('IEUGAKXYTZ'),true);
}
function IEUGAKXYTZ_OnBlur(e) {
SetActiveField(Ctrl('IEUGAKXYTZ'),false);
}
function FMRRWRYWEQ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgpart(ChkboxValueAssign(Ctrl('FMRRWRYWEQ'),'S','N','C',1,0,''),null,e);
}
function FMRRWRYWEQ_OnFocus(e) {
SetActiveField(Ctrl('FMRRWRYWEQ'),true);
}
function FMRRWRYWEQ_OnBlur(e) {
SetActiveField(Ctrl('FMRRWRYWEQ'),false);
}
function IRVRFIWCHD_Valid(e) {
SetActiveField(Ctrl('IRVRFIWCHD'),false);
e=(Ne(e,null)?e:window.event);
return Set_prgidb(HtW(Ctrl('IRVRFIWCHD').value,'N'),null,e);
}
function IRVRFIWCHD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IRVRFIWCHD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IRVRFIWCHD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IRVRFIWCHD'),e);
}
function SHFWFZUZAU_Valid(e) {
SetActiveField(Ctrl('SHFWFZUZAU'),false);
e=(Ne(e,null)?e:window.event);
return Set_prgnprg(HtW(Ctrl('SHFWFZUZAU').value,'N'),null,e);
}
function SHFWFZUZAU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SHFWFZUZAU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SHFWFZUZAU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SHFWFZUZAU'),e);
}
function BBWGQILZDE_Valid(e) {
SetActiveField(Ctrl('BBWGQILZDE'),false);
e=(Ne(e,null)?e:window.event);
return Set_prgiope(HtW(Ctrl('BBWGQILZDE').value,'N'),null,e);
}
function BBWGQILZDE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BBWGQILZDE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BBWGQILZDE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BBWGQILZDE'),e);
}
function DGCPENGASO_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('DGCPENGASO'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('DGCPENGASO').value=ApplyPictureToDate(Ctrl('DGCPENGASO').value,TranslatePicture(datePattern),'DGCPENGASO');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('DGCPENGASO'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('DGCPENGASO');
}
}
}
SetActiveField(Ctrl('DGCPENGASO'),false);
e=(Ne(e,null)?e:window.event);
return Set_daData(HtW(Ctrl('DGCPENGASO').value,'D'),null,e) && dateisok;
}
function DGCPENGASO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DGCPENGASO'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('DGCPENGASO').value=WtH(w_daData,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('DGCPENGASO');
SetActiveField(Ctrl('DGCPENGASO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DGCPENGASO'),e);
}
function DGCPENGASO_ZOOM_Click() {
LaunchCalendar(Ctrl('DGCPENGASO'));
}
function YSDLBTYKKH_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_dataover(ChkboxValueAssign(Ctrl('YSDLBTYKKH'),'S','N','C',1,0,''),null,e);
}
function YSDLBTYKKH_OnFocus(e) {
SetActiveField(Ctrl('YSDLBTYKKH'),true);
}
function YSDLBTYKKH_OnBlur(e) {
SetActiveField(Ctrl('YSDLBTYKKH'),false);
}
function BXVKMROMSG_Valid(e) {
SetActiveField(Ctrl('BXVKMROMSG'),false);
e=(Ne(e,null)?e:window.event);
return Set_ngiorni(HtW(Ctrl('BXVKMROMSG').value,'N'),null,e);
}
function BXVKMROMSG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BXVKMROMSG'))) {
DisplayErrorMessage();
}
if ( ! (GetDisabled('BXVKMROMSG'))) {
if (Eq(w_ngiorni,0) && Eq(_tracker.ctrl,null)) {
Ctrl('BXVKMROMSG').value=WtH(30,'N',2,0,'');
} else {
}
}
SetActiveField(Ctrl('BXVKMROMSG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BXVKMROMSG'),e);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('RWYSXVADUD')) c.onclick=RWYSXVADUD_Valid;
if(c=Ctrl('RWYSXVADUD')) c.onfocus=RWYSXVADUD_OnFocus;
if(c=Ctrl('RWYSXVADUD')) c.onblur=RWYSXVADUD_OnBlur;
if(c=Ctrl('CENYIVTJCD')) c.onclick=CENYIVTJCD_Valid;
if(c=Ctrl('CENYIVTJCD')) c.onfocus=CENYIVTJCD_OnFocus;
if(c=Ctrl('CENYIVTJCD')) c.onblur=CENYIVTJCD_OnBlur;
if(c=Ctrl('CPLLFIWSVW')) c.onclick=CPLLFIWSVW_Valid;
if(c=Ctrl('CPLLFIWSVW')) c.onfocus=CPLLFIWSVW_OnFocus;
if(c=Ctrl('CPLLFIWSVW')) c.onblur=CPLLFIWSVW_OnBlur;
if(c=Ctrl('JALETSSOWI')) c.onclick=JALETSSOWI_Valid;
if(c=Ctrl('JALETSSOWI')) c.onfocus=JALETSSOWI_OnFocus;
if(c=Ctrl('JALETSSOWI')) c.onblur=JALETSSOWI_OnBlur;
if(c=Ctrl('YSMCMCPCUY')) c.onclick=YSMCMCPCUY_Valid;
if(c=Ctrl('YSMCMCPCUY')) c.onfocus=YSMCMCPCUY_OnFocus;
if(c=Ctrl('YSMCMCPCUY')) c.onblur=YSMCMCPCUY_OnBlur;
if(c=Ctrl('IEUGAKXYTZ')) c.onclick=IEUGAKXYTZ_Valid;
if(c=Ctrl('IEUGAKXYTZ')) c.onfocus=IEUGAKXYTZ_OnFocus;
if(c=Ctrl('IEUGAKXYTZ')) c.onblur=IEUGAKXYTZ_OnBlur;
if(c=Ctrl('FMRRWRYWEQ')) c.onclick=FMRRWRYWEQ_Valid;
if(c=Ctrl('FMRRWRYWEQ')) c.onfocus=FMRRWRYWEQ_OnFocus;
if(c=Ctrl('FMRRWRYWEQ')) c.onblur=FMRRWRYWEQ_OnBlur;
if(c=Ctrl('IRVRFIWCHD')) c.onblur=IRVRFIWCHD_Valid;
if(c=Ctrl('IRVRFIWCHD')) c.onfocus=IRVRFIWCHD_OnFocus;
if(c=Ctrl('IRVRFIWCHD')) c.onkeypress=CheckNum;
if(c=Ctrl('SHFWFZUZAU')) c.onblur=SHFWFZUZAU_Valid;
if(c=Ctrl('SHFWFZUZAU')) c.onfocus=SHFWFZUZAU_OnFocus;
if(c=Ctrl('SHFWFZUZAU')) c.onkeypress=CheckNum;
if(c=Ctrl('BBWGQILZDE')) c.onblur=BBWGQILZDE_Valid;
if(c=Ctrl('BBWGQILZDE')) c.onfocus=BBWGQILZDE_OnFocus;
if(c=Ctrl('BBWGQILZDE')) c.onkeypress=CheckNum;
if(c=Ctrl('DGCPENGASO')) c.onblur=DGCPENGASO_Valid;
if(c=Ctrl('DGCPENGASO')) c.onfocus=DGCPENGASO_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('DGCPENGASO')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('YSDLBTYKKH')) c.onclick=YSDLBTYKKH_Valid;
if(c=Ctrl('YSDLBTYKKH')) c.onfocus=YSDLBTYKKH_OnFocus;
if(c=Ctrl('YSDLBTYKKH')) c.onblur=YSDLBTYKKH_OnBlur;
if(c=Ctrl('BXVKMROMSG')) c.onblur=BXVKMROMSG_Valid;
if(c=Ctrl('BXVKMROMSG')) c.onfocus=BXVKMROMSG_OnFocus;
if(c=Ctrl('BXVKMROMSG')) c.onkeypress=CheckNum;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_riordina_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["RWYSXVADUD"]};
function Help() {
windowOpenForeground('../doc/arpg_riordina_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_rapuif=a[0];
w_opeuif=a[1];
w_frzuif=a[2];
w_rapage=a[3];
w_opeage=a[4];
w_gTelepass=a[5];
w_titaui=a[6];
w_gFlgWU=a[7];
w_flgpart=a[8];
w_prgidb=a[9];
w_prgnprg=a[10];
w_prgiope=a[11];
w_daData=a[12];
w_dataover=a[13];
w_ngiorni=a[14];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_riordina',m_cSelectedPage);
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
l_bEnabled= ! (Eq(w_flgpart,'S')) || IsDisabledByStateDriver('prgidb');
SetDisabled(Ctrl('IRVRFIWCHD'),l_bEnabled);
l_bEnabled= ! (Eq(w_flgpart,'S')) || IsDisabledByStateDriver('prgnprg');
SetDisabled(Ctrl('SHFWFZUZAU'),l_bEnabled);
l_bEnabled= ! (Eq(w_flgpart,'S')) || IsDisabledByStateDriver('prgiope');
SetDisabled(Ctrl('BBWGQILZDE'),l_bEnabled);
l_bEnabled= ! (Eq(w_dataover,'S')) || IsDisabledByStateDriver('ngiorni');
SetDisabled(Ctrl('BXVKMROMSG'),l_bEnabled);
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
function Set_rapuif(ctrlValue,kmode,e) {
if (Ne(w_rapuif,ctrlValue)) {
var ctl = _GetCtl(e,'RWYSXVADUD');
if (_tracker.goon(ctl,ctrlValue)) {
w_rapuif=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RWYSXVADUD',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_opeuif(ctrlValue,kmode,e) {
if (Ne(w_opeuif,ctrlValue)) {
var ctl = _GetCtl(e,'CENYIVTJCD');
if (_tracker.goon(ctl,ctrlValue)) {
w_opeuif=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CENYIVTJCD',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_frzuif(ctrlValue,kmode,e) {
if (Ne(w_frzuif,ctrlValue)) {
var ctl = _GetCtl(e,'CPLLFIWSVW');
if (_tracker.goon(ctl,ctrlValue)) {
w_frzuif=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CPLLFIWSVW',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_rapage(ctrlValue,kmode,e) {
if (Ne(w_rapage,ctrlValue)) {
var ctl = _GetCtl(e,'JALETSSOWI');
if (_tracker.goon(ctl,ctrlValue)) {
w_rapage=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JALETSSOWI',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_opeage(ctrlValue,kmode,e) {
if (Ne(w_opeage,ctrlValue)) {
var ctl = _GetCtl(e,'YSMCMCPCUY');
if (_tracker.goon(ctl,ctrlValue)) {
w_opeage=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YSMCMCPCUY',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_titaui(ctrlValue,kmode,e) {
if (Ne(w_titaui,ctrlValue)) {
var ctl = _GetCtl(e,'IEUGAKXYTZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_titaui=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IEUGAKXYTZ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_prgidb(ctrlValue,kmode,e) {
if (Ne(w_prgidb,ctrlValue)) {
var ctl = _GetCtl(e,'IRVRFIWCHD');
if (_tracker.goon(ctl,ctrlValue)) {
w_prgidb=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IRVRFIWCHD',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ngiorni(ctrlValue,kmode,e) {
if (Ne(w_ngiorni,ctrlValue)) {
var ctl = _GetCtl(e,'BXVKMROMSG');
if (_tracker.goon(ctl,ctrlValue)) {
w_ngiorni=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('BXVKMROMSG',0);
if (l_bResult) {
if (l_bResult && ( ! (Gt(w_ngiorni,30) || Lt(w_ngiorni,0)) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('919240835'));
} finally {
_tracker.askwrn=false;
}
}
if ( ! (l_bResult) ||  ! (l_bWarn)) {
w_ngiorni=HtW('','N');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult) ||  ! (l_bWarn)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'N',2,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','N',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgpart(ctrlValue,kmode,e) {
if (Ne(w_flgpart,ctrlValue)) {
var ctl = _GetCtl(e,'FMRRWRYWEQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgpart=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FMRRWRYWEQ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_prgiope(ctrlValue,kmode,e) {
if (Ne(w_prgiope,ctrlValue)) {
var ctl = _GetCtl(e,'BBWGQILZDE');
if (_tracker.goon(ctl,ctrlValue)) {
w_prgiope=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BBWGQILZDE',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_prgnprg(ctrlValue,kmode,e) {
if (Ne(w_prgnprg,ctrlValue)) {
var ctl = _GetCtl(e,'SHFWFZUZAU');
if (_tracker.goon(ctl,ctrlValue)) {
w_prgnprg=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SHFWFZUZAU',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_daData(ctrlValue,kmode,e) {
if (Ne(w_daData,ctrlValue)) {
var ctl = _GetCtl(e,'DGCPENGASO');
if (_tracker.goon(ctl,ctrlValue)) {
w_daData=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DGCPENGASO',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_dataover(ctrlValue,kmode,e) {
if (Ne(w_dataover,ctrlValue)) {
var ctl = _GetCtl(e,'YSDLBTYKKH');
if (_tracker.goon(ctl,ctrlValue)) {
w_dataover=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YSDLBTYKKH',0);
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
if ( ! (_ChkObl('RWYSXVADUD',1))) {
_SignErr('RWYSXVADUD');
m_cLastWorkVarErrorMsg='rapuif';
l_bResult=false;
w_rapuif='N';
} else if ( ! (_ChkObl('CENYIVTJCD',1))) {
_SignErr('CENYIVTJCD');
m_cLastWorkVarErrorMsg='opeuif';
l_bResult=false;
w_opeuif='N';
} else if ( ! (_ChkObl('CPLLFIWSVW',1))) {
_SignErr('CPLLFIWSVW');
m_cLastWorkVarErrorMsg='frzuif';
l_bResult=false;
w_frzuif='N';
} else if ( ! (_ChkObl('JALETSSOWI',1))) {
_SignErr('JALETSSOWI');
m_cLastWorkVarErrorMsg='rapage';
l_bResult=false;
w_rapage='N';
} else if ( ! (_ChkObl('YSMCMCPCUY',1))) {
_SignErr('YSMCMCPCUY');
m_cLastWorkVarErrorMsg='opeage';
l_bResult=false;
w_opeage='N';
} else if ( ! (_ChkObl('IEUGAKXYTZ',1))) {
_SignErr('IEUGAKXYTZ');
m_cLastWorkVarErrorMsg='titaui';
l_bResult=false;
w_titaui='N';
} else if ( ! (_ChkObl('FMRRWRYWEQ',1))) {
_SignErr('FMRRWRYWEQ');
m_cLastWorkVarErrorMsg='flgpart';
l_bResult=false;
w_flgpart='N';
} else if ((Eq(w_flgpart,'S')) && ( ! (_ChkObl('IRVRFIWCHD',1)))) {
_SignErr('IRVRFIWCHD');
m_cLastWorkVarErrorMsg='11959162430';
l_bResult=false;
w_prgidb=HtW('','N');
} else if ((Eq(w_flgpart,'S')) && ( ! (_ChkObl('SHFWFZUZAU',1)))) {
_SignErr('SHFWFZUZAU');
m_cLastWorkVarErrorMsg='11959162430';
l_bResult=false;
w_prgnprg=HtW('','N');
} else if ((Eq(w_flgpart,'S')) && ( ! (_ChkObl('BBWGQILZDE',1)))) {
_SignErr('BBWGQILZDE');
m_cLastWorkVarErrorMsg='11959162430';
l_bResult=false;
w_prgiope=HtW('','N');
} else if ( ! (_ChkObl('DGCPENGASO',1))) {
_SignErr('DGCPENGASO');
m_cLastWorkVarErrorMsg='10221529600';
l_bResult=false;
w_daData=HtW('','D');
} else if ( ! (_ChkObl('YSDLBTYKKH',1))) {
_SignErr('YSDLBTYKKH');
m_cLastWorkVarErrorMsg='11315943373';
l_bResult=false;
w_dataover='N';
} else if ((Eq(w_dataover,'S')) && ( ! (_ChkObl('BXVKMROMSG',1)))) {
_SignErr('BXVKMROMSG');
m_cLastWorkVarErrorMsg='1828634119';
l_bResult=false;
w_ngiorni=HtW('','N');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('DGCPENGASO_ZOOM',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('rapuif',WtA(w_rapuif,'C'));
l_oWv.setValue('opeuif',WtA(w_opeuif,'C'));
l_oWv.setValue('frzuif',WtA(w_frzuif,'C'));
l_oWv.setValue('rapage',WtA(w_rapage,'C'));
l_oWv.setValue('opeage',WtA(w_opeage,'C'));
l_oWv.setValue('gTelepass',WtA(w_gTelepass,'C'));
l_oWv.setValue('titaui',WtA(w_titaui,'C'));
l_oWv.setValue('gFlgWU',WtA(w_gFlgWU,'C'));
l_oWv.setValue('flgpart',WtA(w_flgpart,'C'));
l_oWv.setValue('prgidb',WtA(w_prgidb,'N'));
l_oWv.setValue('prgnprg',WtA(w_prgnprg,'N'));
l_oWv.setValue('prgiope',WtA(w_prgiope,'N'));
l_oWv.setValue('daData',WtA(w_daData,'D'));
l_oWv.setValue('dataover',WtA(w_dataover,'C'));
l_oWv.setValue('ngiorni',WtA(w_ngiorni,'N'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["rapuif","opeuif","frzuif","rapage","opeage","gTelepass","titaui","gFlgWU","flgpart","prgidb","prgnprg","prgiope","daData","dataover","ngiorni"];
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
if (start && Eq(At(',rapuif,',pseq),0)) {
w_rapuif='N';
}
if (start && Eq(At(',opeuif,',pseq),0)) {
w_opeuif='N';
}
if (start && Eq(At(',frzuif,',pseq),0)) {
w_frzuif='N';
}
if (start && Eq(At(',rapage,',pseq),0)) {
w_rapage='N';
}
if (start && Eq(At(',opeage,',pseq),0)) {
w_opeage='N';
}
if (start && Eq(At(',titaui,',pseq),0)) {
w_titaui='N';
}
if (start && Eq(At(',flgpart,',pseq),0)) {
w_flgpart='N';
}
if (start && Eq(At(',dataover,',pseq),0)) {
w_dataover='N';
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
_Obli('rapuif',0,'RWYSXVADUD',false)
_Obli('opeuif',0,'CENYIVTJCD',false)
_Obli('frzuif',0,'CPLLFIWSVW',false)
_Obli('rapage',0,'JALETSSOWI',false)
_Obli('opeage',0,'YSMCMCPCUY',false)
_Obli('titaui',0,'IEUGAKXYTZ',false)
_Obli('prgidb',1,'IRVRFIWCHD',false,"11959162430")
_Obli('ngiorni',1,'BXVKMROMSG',false,"1828634119")
_Obli('flgpart',0,'FMRRWRYWEQ',false)
_Obli('prgiope',1,'BBWGQILZDE',false,"11959162430")
_Obli('prgnprg',1,'SHFWFZUZAU',false,"11959162430")
_Obli('daData',2,'DGCPENGASO',false,"10221529600")
_Obli('dataover',0,'YSDLBTYKKH',false,"11315943373")
