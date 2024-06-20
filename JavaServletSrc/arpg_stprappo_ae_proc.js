function SetControlsValue() {
var c;
var c;
if(c=Ctrl('UYVYTEMEXX')) c.value = WtH(w_daRappo,'C',25,0,'')
if(c=Ctrl('CJWUHWULAR')) c.value = WtH(w_aRappo,'C',25,0,'')
if(c=Ctrl('AITVTFTATA')) c.value = WtH(w_DaData,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('KGOPKMFAZV')) c.value = WtH(w_AData,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('ZNXWTQHRAY')) c.value = WtH(w_coddip,'C',6,0,'')
var tmp_VXJAZUGUIO = ToHTag(AsControlValue(w_desrap1));
if (Ne(e_VXJAZUGUIO,tmp_VXJAZUGUIO)) {
if(c=Ctrl('VXJAZUGUIO')) c.innerHTML=tmp_VXJAZUGUIO;
e_VXJAZUGUIO=tmp_VXJAZUGUIO;
}
var tmp_XCBBNKIAUV = ToHTag(AsControlValue(w_desrap2));
if (Ne(e_XCBBNKIAUV,tmp_XCBBNKIAUV)) {
if(c=Ctrl('XCBBNKIAUV')) c.innerHTML=tmp_XCBBNKIAUV;
e_XCBBNKIAUV=tmp_XCBBNKIAUV;
}
if(c=Ctrl('KRWIPWBLIZ')) ChkboxCheckUncheck(c,'S',w_detope)
if(c=Ctrl('KRWIPWBLIZ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('HOUDAUAIJN')) selectRadio(c,w_tipo,'C')
if(c=Ctrl('BGSKTJIZGQ')) ChkboxCheckUncheck(c,'S',w_detana)
if(c=Ctrl('BGSKTJIZGQ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('ULDTTBEWIQ')) ChkboxCheckUncheck(c,'S',w_flgtit)
if(c=Ctrl('ULDTTBEWIQ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('JVAYGFIMTX')) ChkboxCheckUncheck(c,'S',w_flgdel)
if(c=Ctrl('JVAYGFIMTX')) ChkboxValueAssign(c,'S','N','C',1,0,'')
var tmp_UKVSKINWXW = ToHTag(AsControlValue(w_desdip));
if (Ne(e_UKVSKINWXW,tmp_UKVSKINWXW)) {
if(c=Ctrl('UKVSKINWXW')) c.innerHTML=tmp_UKVSKINWXW;
e_UKVSKINWXW=tmp_UKVSKINWXW;
}
var tmp_TYIWXFLLFY = ToHTag(AsControlValue('<iframe width=\'750\' height=\'400\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_TYIWXFLLFY,tmp_TYIWXFLLFY)) {
if(c=Ctrl('TYIWXFLLFY')) c.innerHTML=tmp_TYIWXFLLFY;
e_TYIWXFLLFY=tmp_TYIWXFLLFY;
}
if(c=Ctrl('POCUAPXGMF')) ChkboxCheckUncheck(c,'S',w_noaui)
if(c=Ctrl('POCUAPXGMF')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
HideUI();
}
HideUI.lblids["AData"]=['WICQRPVOOM'];
HideUI.lblids["DaData"]=['NGVOZRVMWR'];
HideUI.lblids["aRappo"]=['JGQCNSZOCQ'];
HideUI.lblids["coddip"]=['YCCWJHXBSK'];
HideUI.lblids["daRappo"]=['PCILMATBXL'];
HideUI.lblids["flgtit"]=['LMSVTJSWTT'];
function UYVYTEMEXX_Valid(e) {
SetActiveField(Ctrl('UYVYTEMEXX'),false);
e=(Ne(e,null)?e:window.event);
return Set_daRappo(HtW(Ctrl('UYVYTEMEXX').value,'C'),null,e);
}
function UYVYTEMEXX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UYVYTEMEXX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UYVYTEMEXX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UYVYTEMEXX'),e);
}
function UYVYTEMEXX_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('UYVYTEMEXX')),'linkview_UYVYTEMEXX','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function CJWUHWULAR_Valid(e) {
SetActiveField(Ctrl('CJWUHWULAR'),false);
e=(Ne(e,null)?e:window.event);
return Set_aRappo(HtW(Ctrl('CJWUHWULAR').value,'C'),null,e);
}
function CJWUHWULAR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CJWUHWULAR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CJWUHWULAR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CJWUHWULAR'),e);
}
function CJWUHWULAR_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('CJWUHWULAR')),'linkview_CJWUHWULAR','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function AITVTFTATA_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('AITVTFTATA'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('AITVTFTATA').value=ApplyPictureToDate(Ctrl('AITVTFTATA').value,TranslatePicture(datePattern),'AITVTFTATA');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('AITVTFTATA'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('AITVTFTATA');
}
}
}
SetActiveField(Ctrl('AITVTFTATA'),false);
e=(Ne(e,null)?e:window.event);
return Set_DaData(HtW(Ctrl('AITVTFTATA').value,'D'),null,e) && dateisok;
}
function AITVTFTATA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AITVTFTATA'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('AITVTFTATA').value=WtH(w_DaData,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('AITVTFTATA');
SetActiveField(Ctrl('AITVTFTATA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AITVTFTATA'),e);
}
function AITVTFTATA_ZOOM_Click() {
LaunchCalendar(Ctrl('AITVTFTATA'));
}
function KGOPKMFAZV_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('KGOPKMFAZV'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('KGOPKMFAZV').value=ApplyPictureToDate(Ctrl('KGOPKMFAZV').value,TranslatePicture(datePattern),'KGOPKMFAZV');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('KGOPKMFAZV'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('KGOPKMFAZV');
}
}
}
SetActiveField(Ctrl('KGOPKMFAZV'),false);
e=(Ne(e,null)?e:window.event);
return Set_AData(HtW(Ctrl('KGOPKMFAZV').value,'D'),null,e) && dateisok;
}
function KGOPKMFAZV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KGOPKMFAZV'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('KGOPKMFAZV').value=WtH(w_AData,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('KGOPKMFAZV');
SetActiveField(Ctrl('KGOPKMFAZV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KGOPKMFAZV'),e);
}
function KGOPKMFAZV_ZOOM_Click() {
LaunchCalendar(Ctrl('KGOPKMFAZV'));
}
function ZNXWTQHRAY_Valid(e) {
SetActiveField(Ctrl('ZNXWTQHRAY'),false);
e=(Ne(e,null)?e:window.event);
return Set_coddip(HtW(Ctrl('ZNXWTQHRAY').value,'C'),null,e);
}
function ZNXWTQHRAY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZNXWTQHRAY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZNXWTQHRAY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZNXWTQHRAY'),e);
}
function ZNXWTQHRAY_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('ZNXWTQHRAY')),'linkview_ZNXWTQHRAY','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function href_XURLGQZZMU() {
var l_oWv = InitWvApplet();
l_oWv.setValue('pTipo',AsAppletValue('R'));
l_oWv.setValue('w_AData',AsAppletValue(w_AData));
l_oWv.setValue('w_aRappo',AsAppletValue(w_aRappo));
l_oWv.setValue('w_c_adata',AsAppletValue(w_c_adata));
l_oWv.setValue('w_c_dadata',AsAppletValue(w_c_dadata));
l_oWv.setValue('w_DaData',AsAppletValue(w_DaData));
l_oWv.setValue('w_daRappo',AsAppletValue(w_daRappo));
l_oWv.setValue('w_detana',AsAppletValue(w_detana));
l_oWv.setValue('w_detope',AsAppletValue(w_detope));
l_oWv.setValue('w_flgdel',AsAppletValue(w_flgdel));
l_oWv.setValue('w_flgtit',AsAppletValue(w_flgtit));
l_oWv.setValue('w_tipo',AsAppletValue(w_tipo));
l_oWv.setValue('w_noaui',AsAppletValue(w_noaui));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('pTipo,w_AData,w_aRappo,w_c_adata,w_c_dadata,w_DaData,w_daRappo,w_detana,w_detope,w_flgdel,w_flgtit,w_tipo,w_noaui'));
SetLocationHref(null,'arrt_stprappo_ae'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function KRWIPWBLIZ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_detope(ChkboxValueAssign(Ctrl('KRWIPWBLIZ'),'S','N','C',1,0,''),null,e);
}
function KRWIPWBLIZ_OnFocus(e) {
SetActiveField(Ctrl('KRWIPWBLIZ'),true);
}
function KRWIPWBLIZ_OnBlur(e) {
SetActiveField(Ctrl('KRWIPWBLIZ'),false);
}
function href_RPFMUWVENA() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function href_RUYTQICXFP() {
var l_oWv = InitWvApplet();
l_oWv.setValue('pTipo',AsAppletValue('X'));
l_oWv.setValue('w_AData',AsAppletValue(w_AData));
l_oWv.setValue('w_aRappo',AsAppletValue(w_aRappo));
l_oWv.setValue('w_c_adata',AsAppletValue(w_c_adata));
l_oWv.setValue('w_c_dadata',AsAppletValue(w_c_dadata));
l_oWv.setValue('w_DaData',AsAppletValue(w_DaData));
l_oWv.setValue('w_daRappo',AsAppletValue(w_daRappo));
l_oWv.setValue('w_detana',AsAppletValue(w_detana));
l_oWv.setValue('w_detope',AsAppletValue(w_detope));
l_oWv.setValue('w_flgdel',AsAppletValue(w_flgdel));
l_oWv.setValue('w_flgtit',AsAppletValue(w_flgtit));
l_oWv.setValue('w_tipo',AsAppletValue(w_tipo));
l_oWv.setValue('w_noaui',AsAppletValue(w_noaui));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('pTipo,w_AData,w_aRappo,w_c_adata,w_c_dadata,w_DaData,w_daRappo,w_detana,w_detope,w_flgdel,w_flgtit,w_tipo,w_noaui'));
SetLocationHref(null,'arrt_stprappo_ae'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function HOUDAUAIJN_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipo(HtW(getRadioValue(Ctrl('HOUDAUAIJN')),'C'),null,e);
}
function BGSKTJIZGQ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_detana(ChkboxValueAssign(Ctrl('BGSKTJIZGQ'),'S','N','C',1,0,''),null,e);
}
function BGSKTJIZGQ_OnFocus(e) {
SetActiveField(Ctrl('BGSKTJIZGQ'),true);
}
function BGSKTJIZGQ_OnBlur(e) {
SetActiveField(Ctrl('BGSKTJIZGQ'),false);
}
function ULDTTBEWIQ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgtit(ChkboxValueAssign(Ctrl('ULDTTBEWIQ'),'S','N','C',1,0,''),null,e);
}
function ULDTTBEWIQ_OnFocus(e) {
SetActiveField(Ctrl('ULDTTBEWIQ'),true);
}
function ULDTTBEWIQ_OnBlur(e) {
SetActiveField(Ctrl('ULDTTBEWIQ'),false);
}
function JVAYGFIMTX_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgdel(ChkboxValueAssign(Ctrl('JVAYGFIMTX'),'S','N','C',1,0,''),null,e);
}
function JVAYGFIMTX_OnFocus(e) {
SetActiveField(Ctrl('JVAYGFIMTX'),true);
}
function JVAYGFIMTX_OnBlur(e) {
SetActiveField(Ctrl('JVAYGFIMTX'),false);
}
function POCUAPXGMF_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_noaui(ChkboxValueAssign(Ctrl('POCUAPXGMF'),'S','N','C',1,0,''),null,e);
}
function POCUAPXGMF_OnFocus(e) {
SetActiveField(Ctrl('POCUAPXGMF'),true);
}
function POCUAPXGMF_OnBlur(e) {
SetActiveField(Ctrl('POCUAPXGMF'),false);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('UYVYTEMEXX')) c.onblur=UYVYTEMEXX_Valid;
if(c=Ctrl('UYVYTEMEXX')) c.onfocus=UYVYTEMEXX_OnFocus;
if(c=Ctrl('CJWUHWULAR')) c.onblur=CJWUHWULAR_Valid;
if(c=Ctrl('CJWUHWULAR')) c.onfocus=CJWUHWULAR_OnFocus;
if(c=Ctrl('AITVTFTATA')) c.onblur=AITVTFTATA_Valid;
if(c=Ctrl('AITVTFTATA')) c.onfocus=AITVTFTATA_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('AITVTFTATA')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('KGOPKMFAZV')) c.onblur=KGOPKMFAZV_Valid;
if(c=Ctrl('KGOPKMFAZV')) c.onfocus=KGOPKMFAZV_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('KGOPKMFAZV')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('ZNXWTQHRAY')) c.onblur=ZNXWTQHRAY_Valid;
if(c=Ctrl('ZNXWTQHRAY')) c.onfocus=ZNXWTQHRAY_OnFocus;
if(c=Ctrl('KRWIPWBLIZ')) c.onclick=KRWIPWBLIZ_Valid;
if(c=Ctrl('KRWIPWBLIZ')) c.onfocus=KRWIPWBLIZ_OnFocus;
if(c=Ctrl('KRWIPWBLIZ')) c.onblur=KRWIPWBLIZ_OnBlur;
c=Ctrl('HOUDAUAIJN');
if ( ! (Empty(c))) {
c[0].onclick=HOUDAUAIJN_Valid;
c[1].onclick=HOUDAUAIJN_Valid;
c[2].onclick=HOUDAUAIJN_Valid;
}
if(c=Ctrl('BGSKTJIZGQ')) c.onclick=BGSKTJIZGQ_Valid;
if(c=Ctrl('BGSKTJIZGQ')) c.onfocus=BGSKTJIZGQ_OnFocus;
if(c=Ctrl('BGSKTJIZGQ')) c.onblur=BGSKTJIZGQ_OnBlur;
if(c=Ctrl('ULDTTBEWIQ')) c.onclick=ULDTTBEWIQ_Valid;
if(c=Ctrl('ULDTTBEWIQ')) c.onfocus=ULDTTBEWIQ_OnFocus;
if(c=Ctrl('ULDTTBEWIQ')) c.onblur=ULDTTBEWIQ_OnBlur;
if(c=Ctrl('JVAYGFIMTX')) c.onclick=JVAYGFIMTX_Valid;
if(c=Ctrl('JVAYGFIMTX')) c.onfocus=JVAYGFIMTX_OnFocus;
if(c=Ctrl('JVAYGFIMTX')) c.onblur=JVAYGFIMTX_OnBlur;
if(c=Ctrl('POCUAPXGMF')) c.onclick=POCUAPXGMF_Valid;
if(c=Ctrl('POCUAPXGMF')) c.onfocus=POCUAPXGMF_OnFocus;
if(c=Ctrl('POCUAPXGMF')) c.onblur=POCUAPXGMF_OnBlur;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_stprappo_ae_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["UYVYTEMEXX"]};
function Help() {
windowOpenForeground('../doc/arpg_stprappo_ae_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_daRappo=a[0];
w_aRappo=a[1];
w_DaData=a[2];
w_AData=a[3];
w_coddip=a[4];
w_desrap1=a[5];
w_desrap2=a[6];
w_detope=a[7];
w_c_dadata=a[8];
w_c_adata=a[9];
w_tipo=a[10];
w_detana=a[11];
w_flgtit=a[12];
w_flgdel=a[13];
w_desdip=a[14];
w_noaui=a[15];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_stprappo_ae',m_cSelectedPage);
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
function Set_daRappo(ctrlValue,kmode,e) {
if (Ne(w_daRappo,ctrlValue)) {
var ctl = _GetCtl(e,'UYVYTEMEXX');
if (_tracker.goon(ctl,ctrlValue)) {
w_daRappo=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UYVYTEMEXX',0);
if (l_bResult) {
l_bResult=Link_UYVYTEMEXX(kmode);
if ( ! (l_bResult)) {
w_daRappo=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',25,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',25,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_aRappo(ctrlValue,kmode,e) {
if (Ne(w_aRappo,ctrlValue)) {
var ctl = _GetCtl(e,'CJWUHWULAR');
if (_tracker.goon(ctl,ctrlValue)) {
w_aRappo=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CJWUHWULAR',0);
if (l_bResult) {
l_bResult=Link_CJWUHWULAR(kmode);
if ( ! (l_bResult)) {
w_aRappo=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',25,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',25,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DaData(ctrlValue,kmode,e) {
if (Ne(w_DaData,ctrlValue)) {
var ctl = _GetCtl(e,'AITVTFTATA');
if (_tracker.goon(ctl,ctrlValue)) {
w_DaData=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AITVTFTATA',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_AData(ctrlValue,kmode,e) {
if (Ne(w_AData,ctrlValue)) {
var ctl = _GetCtl(e,'KGOPKMFAZV');
if (_tracker.goon(ctl,ctrlValue)) {
w_AData=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KGOPKMFAZV',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_coddip(ctrlValue,kmode,e) {
if (Ne(w_coddip,ctrlValue)) {
var ctl = _GetCtl(e,'ZNXWTQHRAY');
if (_tracker.goon(ctl,ctrlValue)) {
w_coddip=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZNXWTQHRAY',0);
if (l_bResult) {
l_bResult=Link_ZNXWTQHRAY(kmode);
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
function Set_detope(ctrlValue,kmode,e) {
if (Ne(w_detope,ctrlValue)) {
var ctl = _GetCtl(e,'KRWIPWBLIZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_detope=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KRWIPWBLIZ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_tipo(ctrlValue,kmode,e) {
if (Ne(w_tipo,ctrlValue)) {
var ctl = _GetCtl(e,'HOUDAUAIJN');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipo=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HOUDAUAIJN',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_detana(ctrlValue,kmode,e) {
if (Ne(w_detana,ctrlValue)) {
var ctl = _GetCtl(e,'BGSKTJIZGQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_detana=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BGSKTJIZGQ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgdel(ctrlValue,kmode,e) {
if (Ne(w_flgdel,ctrlValue)) {
var ctl = _GetCtl(e,'JVAYGFIMTX');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgdel=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JVAYGFIMTX',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgtit(ctrlValue,kmode,e) {
if (Ne(w_flgtit,ctrlValue)) {
var ctl = _GetCtl(e,'ULDTTBEWIQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgtit=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ULDTTBEWIQ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_noaui(ctrlValue,kmode,e) {
if (Ne(w_noaui,ctrlValue)) {
var ctl = _GetCtl(e,'POCUAPXGMF');
if (_tracker.goon(ctl,ctrlValue)) {
w_noaui=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('POCUAPXGMF',0);
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
w_c_dadata=(Empty(w_DaData)?'':DateToChar(w_DaData));
w_c_adata=(Empty(w_AData)?'':DateToChar(w_AData));
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function Link_UYVYTEMEXX(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_daRappo);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAPPORTO',w_daRappo,25,0);
l_Appl.SetFields('RAPPORTO,DESCRAP');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('anarapbo');
l_Appl.SetID('UYVYTEMEXX');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_daRappo=l_Appl.GetStringValue('RAPPORTO',25,0);
w_desrap1=l_Appl.GetStringValue('DESCRAP',50,0);
} else {
Link_UYVYTEMEXX_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_UYVYTEMEXX';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_UYVYTEMEXX();
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
function Link_UYVYTEMEXX_Blank() {
w_daRappo='';
w_desrap1='';
}
function LOpt_UYVYTEMEXX() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anarapbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAPPORTO','C'));
l_oWv.setValue('LinkedField',WtA('RAPPORTO','C'));
l_oWv.setValue('UID',WtA('UYVYTEMEXX','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UYVYTEMEXX'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('12002828349'),'C'));
return l_oWv;
}
function Link_CJWUHWULAR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_aRappo);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAPPORTO',w_aRappo,25,0);
l_Appl.SetFields('RAPPORTO,DESCRAP');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('anarapbo');
l_Appl.SetID('CJWUHWULAR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_aRappo=l_Appl.GetStringValue('RAPPORTO',25,0);
w_desrap2=l_Appl.GetStringValue('DESCRAP',50,0);
} else {
Link_CJWUHWULAR_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_CJWUHWULAR';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_CJWUHWULAR();
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
if (l_bResult &&  ! (Empty(w_aRappo) && l_bEmp)) {
l_bResult=Ge(w_aRappo,w_daRappo);
if ( ! (l_bResult)) {
Link_CJWUHWULAR_Blank();
}
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
} else {
m_cLastMsgError=AlertErrorMessage('10387154264');
}
}
}
return l_bResult;
}
function Link_CJWUHWULAR_Blank() {
w_aRappo='';
w_desrap2='';
}
function LOpt_CJWUHWULAR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anarapbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAPPORTO','C'));
l_oWv.setValue('LinkedField',WtA('RAPPORTO','C'));
l_oWv.setValue('UID',WtA('CJWUHWULAR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['CJWUHWULAR'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('12002828349'),'C'));
return l_oWv;
}
function Link_ZNXWTQHRAY(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_coddip);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODDIP',w_coddip,6,0);
l_Appl.SetFields('CODDIP,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetID('ZNXWTQHRAY');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_coddip=l_Appl.GetStringValue('CODDIP',6,0);
w_desdip=l_Appl.GetStringValue('DESCRIZ',30,0);
} else {
Link_ZNXWTQHRAY_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_ZNXWTQHRAY';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_ZNXWTQHRAY();
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
function Link_ZNXWTQHRAY_Blank() {
w_coddip='';
w_desdip='';
}
function LOpt_ZNXWTQHRAY() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODDIP','C'));
l_oWv.setValue('LinkedField',WtA('CODDIP','C'));
l_oWv.setValue('UID',WtA('ZNXWTQHRAY','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ZNXWTQHRAY'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1270140318'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'UYVYTEMEXX')) {
last_focused_comp=GetLastFocusedElementOfLink('UYVYTEMEXX');
function SetMethod_UYVYTEMEXX() {
Set_daRappo(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_UYVYTEMEXX();
} else {
setTimeout(SetMethod_UYVYTEMEXX,1);
}
bResult=true;
}
if (Eq(varName,'CJWUHWULAR')) {
last_focused_comp=GetLastFocusedElementOfLink('CJWUHWULAR');
function SetMethod_CJWUHWULAR() {
Set_aRappo(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_CJWUHWULAR();
} else {
setTimeout(SetMethod_CJWUHWULAR,1);
}
bResult=true;
}
if (Eq(varName,'ZNXWTQHRAY')) {
last_focused_comp=GetLastFocusedElementOfLink('ZNXWTQHRAY');
function SetMethod_ZNXWTQHRAY() {
Set_coddip(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_ZNXWTQHRAY();
} else {
setTimeout(SetMethod_ZNXWTQHRAY,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'UYVYTEMEXX')) {
return [Ctrl('UYVYTEMEXX')];
}
if (Eq(varName,'CJWUHWULAR')) {
return [Ctrl('CJWUHWULAR')];
}
if (Eq(varName,'ZNXWTQHRAY')) {
return [Ctrl('ZNXWTQHRAY')];
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
if ( ! (_ChkObl('UYVYTEMEXX',1))) {
_SignErr('UYVYTEMEXX');
m_cLastWorkVarErrorMsg='daRappo';
l_bResult=false;
w_daRappo=HtW('','C');
} else if (( ! (_ChkObl('CJWUHWULAR',1))) || ( ! (Empty(w_aRappo)) &&  ! (Ge(w_aRappo,w_daRappo)))) {
_SignErr('CJWUHWULAR','10387154264');
l_bResult=false;
w_aRappo=HtW('','C');
} else if ( ! (_ChkObl('AITVTFTATA',1))) {
_SignErr('AITVTFTATA');
m_cLastWorkVarErrorMsg='DaData';
l_bResult=false;
w_DaData=HtW('','D');
} else if ( ! (_ChkObl('KGOPKMFAZV',1))) {
_SignErr('KGOPKMFAZV');
m_cLastWorkVarErrorMsg='AData';
l_bResult=false;
w_AData=HtW('','D');
} else if ( ! (_ChkObl('ZNXWTQHRAY',1))) {
_SignErr('ZNXWTQHRAY');
m_cLastWorkVarErrorMsg='116285036';
l_bResult=false;
w_coddip=HtW('','C');
} else if ( ! (_ChkObl('KRWIPWBLIZ',1))) {
_SignErr('KRWIPWBLIZ');
m_cLastWorkVarErrorMsg='detope';
l_bResult=false;
w_detope='N';
} else if ( ! (_ChkObl('HOUDAUAIJN',1))) {
_SignErr('HOUDAUAIJN');
m_cLastWorkVarErrorMsg='tipo';
l_bResult=false;
w_tipo=HtW('','C');
} else if ( ! (_ChkObl('BGSKTJIZGQ',1))) {
_SignErr('BGSKTJIZGQ');
m_cLastWorkVarErrorMsg='detana';
l_bResult=false;
w_detana='N';
} else if ( ! (_ChkObl('ULDTTBEWIQ',1))) {
_SignErr('ULDTTBEWIQ');
m_cLastWorkVarErrorMsg='flgtit';
l_bResult=false;
w_flgtit='N';
} else if ( ! (_ChkObl('JVAYGFIMTX',1))) {
_SignErr('JVAYGFIMTX');
m_cLastWorkVarErrorMsg='flgdel';
l_bResult=false;
w_flgdel='N';
} else if ( ! (_ChkObl('POCUAPXGMF',1))) {
_SignErr('POCUAPXGMF');
m_cLastWorkVarErrorMsg='noaui';
l_bResult=false;
w_noaui='N';
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('UYVYTEMEXX_ZOOM',lc)) {
return 0;
}
if (Eq('UYVYTEMEXX',lc)) {
return 0;
}
if (Eq('CJWUHWULAR_ZOOM',lc)) {
return 1;
}
if (Eq('CJWUHWULAR',lc)) {
return 1;
}
if (Eq('AITVTFTATA_ZOOM',lc)) {
return 2;
}
if (Eq('KGOPKMFAZV_ZOOM',lc)) {
return 2;
}
if (Eq('ZNXWTQHRAY_ZOOM',lc)) {
return 2;
}
if (Eq('ZNXWTQHRAY',lc)) {
return 2;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_UYVYTEMEXX();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_CJWUHWULAR();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_ZNXWTQHRAY();
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
l_oWv.setValue('daRappo',WtA(w_daRappo,'C'));
l_oWv.setValue('aRappo',WtA(w_aRappo,'C'));
l_oWv.setValue('DaData',WtA(w_DaData,'D'));
l_oWv.setValue('AData',WtA(w_AData,'D'));
l_oWv.setValue('coddip',WtA(w_coddip,'C'));
l_oWv.setValue('desrap1',WtA(w_desrap1,'C'));
l_oWv.setValue('desrap2',WtA(w_desrap2,'C'));
l_oWv.setValue('detope',WtA(w_detope,'C'));
l_oWv.setValue('c_dadata',WtA(w_c_dadata,'C'));
l_oWv.setValue('c_adata',WtA(w_c_adata,'C'));
l_oWv.setValue('tipo',WtA(w_tipo,'C'));
l_oWv.setValue('detana',WtA(w_detana,'C'));
l_oWv.setValue('flgtit',WtA(w_flgtit,'C'));
l_oWv.setValue('flgdel',WtA(w_flgdel,'C'));
l_oWv.setValue('desdip',WtA(w_desdip,'C'));
l_oWv.setValue('noaui',WtA(w_noaui,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["daRappo","aRappo","DaData","AData","coddip","desrap1","desrap2","detope","c_dadata","c_adata","tipo","detana","flgtit","flgdel","desdip","noaui"];
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
if (Eq(w_detope,'N') && Ne(opener.w_detope,null)) {
TransferBetweenWindows(opener,'w_detope',null,'Set_detope');
}
if (Empty(w_c_dadata) && Ne(opener.w_c_dadata,null)) {
TransferBetweenWindows(opener,'w_c_dadata','w_c_dadata');
}
if (Empty(w_c_adata) && Ne(opener.w_c_adata,null)) {
TransferBetweenWindows(opener,'w_c_adata','w_c_adata');
}
if (Eq(w_tipo,'T') && Ne(opener.w_tipo,null)) {
TransferBetweenWindows(opener,'w_tipo',null,'Set_tipo');
}
if (Eq(w_detana,'N') && Ne(opener.w_detana,null)) {
TransferBetweenWindows(opener,'w_detana',null,'Set_detana');
}
}
}
m_bCalculating=true;
Link_UYVYTEMEXX(null);
Link_CJWUHWULAR(null);
Link_ZNXWTQHRAY(null);
if (start && Eq(At(',detope,',pseq),0)) {
w_detope='N';
}
w_c_dadata=(Empty(w_DaData)?'':DateToChar(w_DaData));
w_c_adata=(Empty(w_AData)?'':DateToChar(w_AData));
if (start && Eq(At(',tipo,',pseq),0)) {
w_tipo='T';
}
if (start && Eq(At(',detana,',pseq),0)) {
w_detana='N';
}
if (start && Eq(At(',flgtit,',pseq),0)) {
w_flgtit='N';
}
if (start && Eq(At(',flgdel,',pseq),0)) {
w_flgdel='N';
}
if (start && Eq(At(',noaui,',pseq),0)) {
w_noaui='N';
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
_Obli('daRappo',0,'UYVYTEMEXX',false)
_Obli('aRappo',0,'CJWUHWULAR',false)
_Obli('DaData',2,'AITVTFTATA',false)
_Obli('AData',2,'KGOPKMFAZV',false)
_Obli('coddip',0,'ZNXWTQHRAY',false,"116285036")
_Obli('detope',0,'KRWIPWBLIZ',false)
_Obli('tipo',0,'HOUDAUAIJN',false)
_Obli('detana',0,'BGSKTJIZGQ',false)
_Obli('flgdel',0,'JVAYGFIMTX',false)
_Obli('flgtit',0,'ULDTTBEWIQ',false)
_Obli('noaui',0,'POCUAPXGMF',false)
