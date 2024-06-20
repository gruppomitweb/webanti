function SetControlsValue() {
var c;
var c;
if(c=Ctrl('INCSNNUWOV')) c.value = WtH(w_anno,'N',4,0,'')
if(c=Ctrl('TCZMCNHUFI')) selectCombo(c,w_mese,'C')
if(c=Ctrl('PRCVTCPVCB')) selectCombo(c,w_TipoOper,'C')
if(c=Ctrl('DPKVLWHCIG')) c.value = WtH(w_DaDatOpe,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('MTJDZQTEIR')) c.value = WtH(w_ADatOpe,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'750\' height=\'350\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('OLAQSOZFCY')) c.value = WtH(w_rcoddip,'C',6,0,'')
var tmp_JSTXFKSRUI = ToHTag(AsControlValue(w_xdesdip));
if (Ne(e_JSTXFKSRUI,tmp_JSTXFKSRUI)) {
if(c=Ctrl('JSTXFKSRUI')) c.innerHTML=tmp_JSTXFKSRUI;
e_JSTXFKSRUI=tmp_JSTXFKSRUI;
}
if(c=Ctrl('JGTODNXAVD')) c.value = WtH(w_rabicab,'C',12,0,'')
if(c=Ctrl('FMRCIWUEYR')) c.value = WtH(w_rcabdip,'C',6,0,'')
if(c=Ctrl('UGMSDYOXMM')) c.value = WtH(w_rpaecli,'C',3,0,'')
var tmp_XEUVCTYSYZ = ToHTag(AsControlValue(w_xpaesecli));
if (Ne(e_XEUVCTYSYZ,tmp_XEUVCTYSYZ)) {
if(c=Ctrl('XEUVCTYSYZ')) c.innerHTML=tmp_XEUVCTYSYZ;
e_XEUVCTYSYZ=tmp_XEUVCTYSYZ;
}
if(c=Ctrl('GUVXBUJIEG')) c.value = WtH(w_rcabcli,'C',6,0,'')
if(c=Ctrl('OZZYALMUYP')) c.value = WtH(w_rcodvoc,'C',2,0,'')
var tmp_KFXGDEJPQJ = ToHTag(AsControlValue(w_xdescau));
if (Ne(e_KFXGDEJPQJ,tmp_KFXGDEJPQJ)) {
if(c=Ctrl('KFXGDEJPQJ')) c.innerHTML=tmp_KFXGDEJPQJ;
e_KFXGDEJPQJ=tmp_KFXGDEJPQJ;
}
if(c=Ctrl('EVPCVZMBLL')) selectCombo(c,w_rflglire,'C')
if(c=Ctrl('KUXBYNJIYY')) selectCombo(c,w_rsegno,'C')
if(c=Ctrl('BOULPRIMLA')) c.value = WtH(w_rsetsin,'C',3,0,'')
if(c=Ctrl('NJAIUIFRCH')) c.value = WtH(w_rpaecon,'C',3,0,'')
var tmp_QIAJXTAKFW = ToHTag(AsControlValue(w_xpaesecon));
if (Ne(e_QIAJXTAKFW,tmp_QIAJXTAKFW)) {
if(c=Ctrl('QIAJXTAKFW')) c.innerHTML=tmp_QIAJXTAKFW;
e_QIAJXTAKFW=tmp_QIAJXTAKFW;
}
if(c=Ctrl('RFAXHNVDNI')) c.value = WtH(w_rcabcon,'C',6,0,'')
if(c=Ctrl('QWUXFRTCAK')) c.value = WtH(w_rpaeint,'C',3,0,'')
var tmp_BACOVSPFFU = ToHTag(AsControlValue(w_xpaeseint));
if (Ne(e_BACOVSPFFU,tmp_BACOVSPFFU)) {
if(c=Ctrl('BACOVSPFFU')) c.innerHTML=tmp_BACOVSPFFU;
e_BACOVSPFFU=tmp_BACOVSPFFU;
}
if(c=Ctrl('IYVNYANIYW')) c.value = WtH(w_rcabint,'C',6,0,'')
var tmp_TTTIJIGSTS = ToHTag(AsControlValue(w_xdesset));
if (Ne(e_TTTIJIGSTS,tmp_TTTIJIGSTS)) {
if(c=Ctrl('TTTIJIGSTS')) c.innerHTML=tmp_TTTIJIGSTS;
e_TTTIJIGSTS=tmp_TTTIJIGSTS;
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('URPSVVEIFI'),true);
HideUI();
}
HideUI.lblids["TipoOper"]=['HLPEMESXOO'];
HideUI.lblids["anno"]=['HPGJXQIVYG'];
HideUI.lblids["mese"]=['JCKMEQWFOM'];
HideUI.lblids["rabicab"]=['RLTRRXKDVL'];
HideUI.lblids["rcabcli"]=['MALQXATPGL'];
HideUI.lblids["rcabcon"]=['IAOBJXLZTI'];
HideUI.lblids["rcabdip"]=['IAWXCLXXBQ'];
HideUI.lblids["rcabint"]=['EBMFNEDGHG'];
HideUI.lblids["rcoddip"]=['GWMNZLYKOI'];
HideUI.lblids["rcodvoc"]=['AAENYRICVA'];
HideUI.lblids["rflglire"]=['OOGZQWLABP'];
HideUI.lblids["rpaecli"]=['MCSVMXGCHX'];
HideUI.lblids["rpaecon"]=['HWSYIMZFAL'];
HideUI.lblids["rpaeint"]=['SVHHVTOUWB'];
HideUI.lblids["rsegno"]=['WFRNOUHQRD'];
HideUI.lblids["rsetsin"]=['HNXOTOMWCA'];
function INCSNNUWOV_Valid(e) {
SetActiveField(Ctrl('INCSNNUWOV'),false);
e=(Ne(e,null)?e:window.event);
return Set_anno(HtW(Ctrl('INCSNNUWOV').value,'N'),null,e);
}
function INCSNNUWOV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('INCSNNUWOV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('INCSNNUWOV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('INCSNNUWOV'),e);
}
function TCZMCNHUFI_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_mese(HtW(getComboValue(Ctrl('TCZMCNHUFI')),'C'),null,e);
}
function TCZMCNHUFI_OnFocus(e) {
SetActiveField(Ctrl('TCZMCNHUFI'),true);
}
function TCZMCNHUFI_OnBlur(e) {
SetActiveField(Ctrl('TCZMCNHUFI'),false);
}
function PRCVTCPVCB_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_TipoOper(HtW(getComboValue(Ctrl('PRCVTCPVCB')),'C'),null,e);
}
function PRCVTCPVCB_OnFocus(e) {
SetActiveField(Ctrl('PRCVTCPVCB'),true);
}
function PRCVTCPVCB_OnBlur(e) {
SetActiveField(Ctrl('PRCVTCPVCB'),false);
}
function href_ZQEKBHAOQV() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function href_SNWBSRFWZT() {
Lancio()
}
function OLAQSOZFCY_Valid(e) {
SetActiveField(Ctrl('OLAQSOZFCY'),false);
e=(Ne(e,null)?e:window.event);
return Set_rcoddip(HtW(Ctrl('OLAQSOZFCY').value,'C'),null,e);
}
function OLAQSOZFCY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OLAQSOZFCY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OLAQSOZFCY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OLAQSOZFCY'),e);
}
function OLAQSOZFCY_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('OLAQSOZFCY')),'linkview_OLAQSOZFCY','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function JGTODNXAVD_Valid(e) {
SetActiveField(Ctrl('JGTODNXAVD'),false);
e=(Ne(e,null)?e:window.event);
return Set_rabicab(HtW(Ctrl('JGTODNXAVD').value,'C'),null,e);
}
function JGTODNXAVD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JGTODNXAVD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JGTODNXAVD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JGTODNXAVD'),e);
}
function FMRCIWUEYR_Valid(e) {
SetActiveField(Ctrl('FMRCIWUEYR'),false);
e=(Ne(e,null)?e:window.event);
return Set_rcabdip(HtW(Ctrl('FMRCIWUEYR').value,'C'),null,e);
}
function FMRCIWUEYR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FMRCIWUEYR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FMRCIWUEYR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FMRCIWUEYR'),e);
}
function UGMSDYOXMM_Valid(e) {
SetActiveField(Ctrl('UGMSDYOXMM'),false);
e=(Ne(e,null)?e:window.event);
return Set_rpaecli(HtW(Ctrl('UGMSDYOXMM').value,'C'),null,e);
}
function UGMSDYOXMM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UGMSDYOXMM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UGMSDYOXMM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UGMSDYOXMM'),e);
}
function UGMSDYOXMM_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('UGMSDYOXMM')),'linkview_UGMSDYOXMM','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function GUVXBUJIEG_Valid(e) {
SetActiveField(Ctrl('GUVXBUJIEG'),false);
e=(Ne(e,null)?e:window.event);
return Set_rcabcli(HtW(Ctrl('GUVXBUJIEG').value,'C'),null,e);
}
function GUVXBUJIEG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GUVXBUJIEG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GUVXBUJIEG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GUVXBUJIEG'),e);
}
function OZZYALMUYP_Valid(e) {
SetActiveField(Ctrl('OZZYALMUYP'),false);
e=(Ne(e,null)?e:window.event);
return Set_rcodvoc(HtW(Ctrl('OZZYALMUYP').value,'C'),null,e);
}
function OZZYALMUYP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OZZYALMUYP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OZZYALMUYP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OZZYALMUYP'),e);
}
function OZZYALMUYP_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('OZZYALMUYP')),'linkview_OZZYALMUYP','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function EVPCVZMBLL_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_rflglire(HtW(getComboValue(Ctrl('EVPCVZMBLL')),'C'),null,e);
}
function EVPCVZMBLL_OnFocus(e) {
SetActiveField(Ctrl('EVPCVZMBLL'),true);
}
function EVPCVZMBLL_OnBlur(e) {
SetActiveField(Ctrl('EVPCVZMBLL'),false);
}
function KUXBYNJIYY_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_rsegno(HtW(getComboValue(Ctrl('KUXBYNJIYY')),'C'),null,e);
}
function KUXBYNJIYY_OnFocus(e) {
SetActiveField(Ctrl('KUXBYNJIYY'),true);
}
function KUXBYNJIYY_OnBlur(e) {
SetActiveField(Ctrl('KUXBYNJIYY'),false);
}
function BOULPRIMLA_Valid(e) {
SetActiveField(Ctrl('BOULPRIMLA'),false);
e=(Ne(e,null)?e:window.event);
return Set_rsetsin(HtW(Ctrl('BOULPRIMLA').value,'C'),null,e);
}
function BOULPRIMLA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BOULPRIMLA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BOULPRIMLA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BOULPRIMLA'),e);
}
function BOULPRIMLA_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('BOULPRIMLA')),'linkview_BOULPRIMLA','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function NJAIUIFRCH_Valid(e) {
SetActiveField(Ctrl('NJAIUIFRCH'),false);
e=(Ne(e,null)?e:window.event);
return Set_rpaecon(HtW(Ctrl('NJAIUIFRCH').value,'C'),null,e);
}
function NJAIUIFRCH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NJAIUIFRCH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NJAIUIFRCH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NJAIUIFRCH'),e);
}
function NJAIUIFRCH_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('NJAIUIFRCH')),'linkview_NJAIUIFRCH','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function RFAXHNVDNI_Valid(e) {
SetActiveField(Ctrl('RFAXHNVDNI'),false);
e=(Ne(e,null)?e:window.event);
return Set_rcabcon(HtW(Ctrl('RFAXHNVDNI').value,'C'),null,e);
}
function RFAXHNVDNI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RFAXHNVDNI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RFAXHNVDNI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RFAXHNVDNI'),e);
}
function QWUXFRTCAK_Valid(e) {
SetActiveField(Ctrl('QWUXFRTCAK'),false);
e=(Ne(e,null)?e:window.event);
return Set_rpaeint(HtW(Ctrl('QWUXFRTCAK').value,'C'),null,e);
}
function QWUXFRTCAK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QWUXFRTCAK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QWUXFRTCAK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QWUXFRTCAK'),e);
}
function QWUXFRTCAK_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('QWUXFRTCAK')),'linkview_QWUXFRTCAK','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function IYVNYANIYW_Valid(e) {
SetActiveField(Ctrl('IYVNYANIYW'),false);
e=(Ne(e,null)?e:window.event);
return Set_rcabint(HtW(Ctrl('IYVNYANIYW').value,'C'),null,e);
}
function IYVNYANIYW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IYVNYANIYW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IYVNYANIYW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IYVNYANIYW'),e);
}
function href_URPSVVEIFI() {
SetLocationHref(null,'arrt_discouic_rilievi'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('INCSNNUWOV')) c.onblur=INCSNNUWOV_Valid;
if(c=Ctrl('INCSNNUWOV')) c.onfocus=INCSNNUWOV_OnFocus;
if(c=Ctrl('INCSNNUWOV')) c.onkeypress=CheckNum;
if(c=Ctrl('TCZMCNHUFI')) c.onchange=TCZMCNHUFI_Valid;
if(c=Ctrl('TCZMCNHUFI')) c.onfocus=TCZMCNHUFI_OnFocus;
if(c=Ctrl('TCZMCNHUFI')) c.onblur=TCZMCNHUFI_OnBlur;
if(c=Ctrl('PRCVTCPVCB')) c.onchange=PRCVTCPVCB_Valid;
if(c=Ctrl('PRCVTCPVCB')) c.onfocus=PRCVTCPVCB_OnFocus;
if(c=Ctrl('PRCVTCPVCB')) c.onblur=PRCVTCPVCB_OnBlur;
if(c=Ctrl('OLAQSOZFCY')) c.onblur=OLAQSOZFCY_Valid;
if(c=Ctrl('OLAQSOZFCY')) c.onfocus=OLAQSOZFCY_OnFocus;
if(c=Ctrl('JGTODNXAVD')) c.onblur=JGTODNXAVD_Valid;
if(c=Ctrl('JGTODNXAVD')) c.onfocus=JGTODNXAVD_OnFocus;
if(c=Ctrl('FMRCIWUEYR')) c.onblur=FMRCIWUEYR_Valid;
if(c=Ctrl('FMRCIWUEYR')) c.onfocus=FMRCIWUEYR_OnFocus;
if(c=Ctrl('UGMSDYOXMM')) c.onblur=UGMSDYOXMM_Valid;
if(c=Ctrl('UGMSDYOXMM')) c.onfocus=UGMSDYOXMM_OnFocus;
if(c=Ctrl('GUVXBUJIEG')) c.onblur=GUVXBUJIEG_Valid;
if(c=Ctrl('GUVXBUJIEG')) c.onfocus=GUVXBUJIEG_OnFocus;
if(c=Ctrl('OZZYALMUYP')) c.onblur=OZZYALMUYP_Valid;
if(c=Ctrl('OZZYALMUYP')) c.onfocus=OZZYALMUYP_OnFocus;
if(c=Ctrl('EVPCVZMBLL')) c.onchange=EVPCVZMBLL_Valid;
if(c=Ctrl('EVPCVZMBLL')) c.onfocus=EVPCVZMBLL_OnFocus;
if(c=Ctrl('EVPCVZMBLL')) c.onblur=EVPCVZMBLL_OnBlur;
if(c=Ctrl('KUXBYNJIYY')) c.onchange=KUXBYNJIYY_Valid;
if(c=Ctrl('KUXBYNJIYY')) c.onfocus=KUXBYNJIYY_OnFocus;
if(c=Ctrl('KUXBYNJIYY')) c.onblur=KUXBYNJIYY_OnBlur;
if(c=Ctrl('BOULPRIMLA')) c.onblur=BOULPRIMLA_Valid;
if(c=Ctrl('BOULPRIMLA')) c.onfocus=BOULPRIMLA_OnFocus;
if(c=Ctrl('NJAIUIFRCH')) c.onblur=NJAIUIFRCH_Valid;
if(c=Ctrl('NJAIUIFRCH')) c.onfocus=NJAIUIFRCH_OnFocus;
if(c=Ctrl('RFAXHNVDNI')) c.onblur=RFAXHNVDNI_Valid;
if(c=Ctrl('RFAXHNVDNI')) c.onfocus=RFAXHNVDNI_OnFocus;
if(c=Ctrl('QWUXFRTCAK')) c.onblur=QWUXFRTCAK_Valid;
if(c=Ctrl('QWUXFRTCAK')) c.onfocus=QWUXFRTCAK_OnFocus;
if(c=Ctrl('IYVNYANIYW')) c.onblur=IYVNYANIYW_Valid;
if(c=Ctrl('IYVNYANIYW')) c.onfocus=IYVNYANIYW_OnFocus;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_discouic_rilievi_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_discouic_rilievi_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["INCSNNUWOV"]};
function Help() {
windowOpenForeground('../doc/arpg_discouic_rilievi_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_mese=a[1];
w_TipoOper=a[2];
w_gIntemediario=a[3];
w_gTipInter=a[4];
w_DaDatOpe=a[5];
w_ADatOpe=a[6];
w_rcoddip=a[7];
w_xdesdip=a[8];
w_rabicab=a[9];
w_rcabdip=a[10];
w_rpaecli=a[11];
w_xpaesecli=a[12];
w_rcabcli=a[13];
w_rcodvoc=a[14];
w_xdescau=a[15];
w_rflglire=a[16];
w_rsegno=a[17];
w_rsetsin=a[18];
w_rpaecon=a[19];
w_rcabcon=a[20];
w_rpaeint=a[21];
w_rcabint=a[22];
w_xpaeseint=a[23];
w_xpaesecon=a[24];
w_xdesset=a[25];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_discouic_rilievi',m_cSelectedPage);
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
SetObligatory(Ctrl('GUVXBUJIEG'),Eq(w_rpaecli,'086') || IsObligatoryByStateDriver('rcabcli'));
SetObligatory(Ctrl('RFAXHNVDNI'),Eq(w_rpaecli,'086') || IsObligatoryByStateDriver('rcabcon'));
SetObligatory(Ctrl('IYVNYANIYW'),Eq(w_rpaeint,'086') || IsObligatoryByStateDriver('rcabint'));
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
var ctl = _GetCtl(e,'INCSNNUWOV');
if (_tracker.goon(ctl,ctrlValue)) {
w_anno=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('INCSNNUWOV',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_mese(ctrlValue,kmode,e) {
if (Ne(w_mese,ctrlValue)) {
var ctl = _GetCtl(e,'TCZMCNHUFI');
if (_tracker.goon(ctl,ctrlValue)) {
w_mese=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TCZMCNHUFI',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TipoOper(ctrlValue,kmode,e) {
if (Ne(w_TipoOper,ctrlValue)) {
var ctl = _GetCtl(e,'PRCVTCPVCB');
if (_tracker.goon(ctl,ctrlValue)) {
w_TipoOper=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PRCVTCPVCB',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_rcabdip(ctrlValue,kmode,e) {
if (Ne(w_rcabdip,ctrlValue)) {
var ctl = _GetCtl(e,'FMRCIWUEYR');
if (_tracker.goon(ctl,ctrlValue)) {
w_rcabdip=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FMRCIWUEYR',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',6,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_rcabint(ctrlValue,kmode,e) {
if (Ne(w_rcabint,ctrlValue)) {
var ctl = _GetCtl(e,'IYVNYANIYW');
if (_tracker.goon(ctl,ctrlValue)) {
w_rcabint=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IYVNYANIYW',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',6,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_rcabcli(ctrlValue,kmode,e) {
if (Ne(w_rcabcli,ctrlValue)) {
var ctl = _GetCtl(e,'GUVXBUJIEG');
if (_tracker.goon(ctl,ctrlValue)) {
w_rcabcli=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GUVXBUJIEG',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',6,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_rpaeint(ctrlValue,kmode,e) {
if (Ne(w_rpaeint,ctrlValue)) {
var ctl = _GetCtl(e,'QWUXFRTCAK');
if (_tracker.goon(ctl,ctrlValue)) {
w_rpaeint=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QWUXFRTCAK',0);
if (l_bResult) {
l_bResult=Link_QWUXFRTCAK(kmode);
if ( ! (l_bResult)) {
w_rpaeint=HtW('','C');
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
function Set_rcoddip(ctrlValue,kmode,e) {
if (Ne(w_rcoddip,ctrlValue)) {
var ctl = _GetCtl(e,'OLAQSOZFCY');
if (_tracker.goon(ctl,ctrlValue)) {
w_rcoddip=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OLAQSOZFCY',0);
if (l_bResult) {
l_bResult=Link_OLAQSOZFCY(kmode);
if ( ! (l_bResult)) {
w_rcoddip=HtW('','C');
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
function Set_rcodvoc(ctrlValue,kmode,e) {
if (Ne(w_rcodvoc,ctrlValue)) {
var ctl = _GetCtl(e,'OZZYALMUYP');
if (_tracker.goon(ctl,ctrlValue)) {
w_rcodvoc=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OZZYALMUYP',0);
if (l_bResult) {
l_bResult=Link_OZZYALMUYP(kmode);
if ( ! (l_bResult)) {
w_rcodvoc=HtW('','C');
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
function Set_rabicab(ctrlValue,kmode,e) {
if (Ne(w_rabicab,ctrlValue)) {
var ctl = _GetCtl(e,'JGTODNXAVD');
if (_tracker.goon(ctl,ctrlValue)) {
w_rabicab=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JGTODNXAVD',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',12,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_rpaecon(ctrlValue,kmode,e) {
if (Ne(w_rpaecon,ctrlValue)) {
var ctl = _GetCtl(e,'NJAIUIFRCH');
if (_tracker.goon(ctl,ctrlValue)) {
w_rpaecon=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NJAIUIFRCH',0);
if (l_bResult) {
l_bResult=Link_NJAIUIFRCH(kmode);
if ( ! (l_bResult)) {
w_rpaecon=HtW('','C');
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
function Set_rpaecli(ctrlValue,kmode,e) {
if (Ne(w_rpaecli,ctrlValue)) {
var ctl = _GetCtl(e,'UGMSDYOXMM');
if (_tracker.goon(ctl,ctrlValue)) {
w_rpaecli=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UGMSDYOXMM',0);
if (l_bResult) {
l_bResult=Link_UGMSDYOXMM(kmode);
if ( ! (l_bResult)) {
w_rpaecli=HtW('','C');
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
function Set_rcabcon(ctrlValue,kmode,e) {
if (Ne(w_rcabcon,ctrlValue)) {
var ctl = _GetCtl(e,'RFAXHNVDNI');
if (_tracker.goon(ctl,ctrlValue)) {
w_rcabcon=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RFAXHNVDNI',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',6,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_rsetsin(ctrlValue,kmode,e) {
if (Ne(w_rsetsin,ctrlValue)) {
var ctl = _GetCtl(e,'BOULPRIMLA');
if (_tracker.goon(ctl,ctrlValue)) {
w_rsetsin=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BOULPRIMLA',0);
if (l_bResult) {
l_bResult=Link_BOULPRIMLA(kmode);
if ( ! (l_bResult)) {
w_rsetsin=HtW('','C');
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
function Set_rsegno(ctrlValue,kmode,e) {
if (Ne(w_rsegno,ctrlValue)) {
var ctl = _GetCtl(e,'KUXBYNJIYY');
if (_tracker.goon(ctl,ctrlValue)) {
w_rsegno=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KUXBYNJIYY',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_rflglire(ctrlValue,kmode,e) {
if (Ne(w_rflglire,ctrlValue)) {
var ctl = _GetCtl(e,'EVPCVZMBLL');
if (_tracker.goon(ctl,ctrlValue)) {
w_rflglire=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EVPCVZMBLL',0);
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
w_DaDatOpe=( ! (Empty(w_anno)) &&  ! (Empty(w_mese))?CharToDate(Str(w_anno,4,0)+w_mese+'01'):NullDate());
w_ADatOpe=arfn_finemese(w_DaDatOpe);
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function Link_OLAQSOZFCY(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_rcoddip);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODDIP',w_rcoddip,6,0);
l_Appl.SetFields('CODDIP,DESCRIZ,CAB,ABICABSARA');
l_Appl.SetTypes('C,C,C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetID('OLAQSOZFCY');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_rcoddip=l_Appl.GetStringValue('CODDIP',6,0);
w_xdesdip=l_Appl.GetStringValue('DESCRIZ',30,0);
w_rcabdip=l_Appl.GetStringValue('CAB',6,0);
w_rabicab=l_Appl.GetStringValue('ABICABSARA',12,0);
} else {
Link_OLAQSOZFCY_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_OLAQSOZFCY';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_OLAQSOZFCY();
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
function Link_OLAQSOZFCY_Blank() {
w_xdesdip='';
w_rcabdip='';
w_rabicab='';
}
function LOpt_OLAQSOZFCY() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODDIP','C'));
l_oWv.setValue('LinkedField',WtA('CODDIP','C'));
l_oWv.setValue('UID',WtA('OLAQSOZFCY','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['OLAQSOZFCY'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('551482149'),'C'));
return l_oWv;
}
function Link_UGMSDYOXMM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_rpaecli);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_rpaecli,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('UGMSDYOXMM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_rpaecli=l_Appl.GetStringValue('CODSTA',3,0);
w_xpaesecli=l_Appl.GetStringValue('DESCRI',40,0);
} else {
Link_UGMSDYOXMM_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_UGMSDYOXMM';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_UGMSDYOXMM();
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
function Link_UGMSDYOXMM_Blank() {
w_xpaesecli='';
}
function LOpt_UGMSDYOXMM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('UGMSDYOXMM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UGMSDYOXMM'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Link_OZZYALMUYP(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_rcodvoc);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODVOC',w_rcodvoc,2,0);
l_Appl.SetFields('CODVOC,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcausin');
l_Appl.SetID('OZZYALMUYP');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_rcodvoc=l_Appl.GetStringValue('CODVOC',2,0);
w_xdescau=l_Appl.GetStringValue('DESCRIZ',165,0);
} else {
Link_OZZYALMUYP_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_OZZYALMUYP';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_OZZYALMUYP();
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
function Link_OZZYALMUYP_Blank() {
w_xdescau='';
}
function LOpt_OZZYALMUYP() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcausin','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODVOC','C'));
l_oWv.setValue('LinkedField',WtA('CODVOC','C'));
l_oWv.setValue('UID',WtA('OZZYALMUYP','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['OZZYALMUYP'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('282420974'),'C'));
return l_oWv;
}
function Link_BOULPRIMLA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_rsetsin);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SETSINT',w_rsetsin,3,0);
l_Appl.SetFields('SETSINT,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbsetsin');
l_Appl.SetID('BOULPRIMLA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_rsetsin=l_Appl.GetStringValue('SETSINT',3,0);
w_xdesset=l_Appl.GetStringValue('DESCRI',200,0);
} else {
Link_BOULPRIMLA_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_BOULPRIMLA';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_BOULPRIMLA();
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
function Link_BOULPRIMLA_Blank() {
w_xdesset='';
}
function LOpt_BOULPRIMLA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbsetsin','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SETSINT','C'));
l_oWv.setValue('LinkedField',WtA('SETSINT','C'));
l_oWv.setValue('UID',WtA('BOULPRIMLA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['BOULPRIMLA'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10513349907'),'C'));
return l_oWv;
}
function Link_NJAIUIFRCH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_rpaecon);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_rpaecon,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('NJAIUIFRCH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_rpaecon=l_Appl.GetStringValue('CODSTA',3,0);
w_xpaesecon=l_Appl.GetStringValue('DESCRI',40,0);
} else {
Link_NJAIUIFRCH_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_NJAIUIFRCH';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_NJAIUIFRCH();
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
function Link_NJAIUIFRCH_Blank() {
w_xpaesecon='';
}
function LOpt_NJAIUIFRCH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('NJAIUIFRCH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NJAIUIFRCH'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Link_QWUXFRTCAK(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_rpaeint);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_rpaeint,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('QWUXFRTCAK');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_rpaeint=l_Appl.GetStringValue('CODSTA',3,0);
w_xpaeseint=l_Appl.GetStringValue('DESCRI',40,0);
} else {
Link_QWUXFRTCAK_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_QWUXFRTCAK';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_QWUXFRTCAK();
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
function Link_QWUXFRTCAK_Blank() {
w_xpaeseint='';
}
function LOpt_QWUXFRTCAK() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('QWUXFRTCAK','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QWUXFRTCAK'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'OLAQSOZFCY')) {
last_focused_comp=GetLastFocusedElementOfLink('OLAQSOZFCY');
function SetMethod_OLAQSOZFCY() {
Set_rcoddip(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_OLAQSOZFCY();
} else {
setTimeout(SetMethod_OLAQSOZFCY,1);
}
bResult=true;
}
if (Eq(varName,'UGMSDYOXMM')) {
last_focused_comp=GetLastFocusedElementOfLink('UGMSDYOXMM');
function SetMethod_UGMSDYOXMM() {
Set_rpaecli(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_UGMSDYOXMM();
} else {
setTimeout(SetMethod_UGMSDYOXMM,1);
}
bResult=true;
}
if (Eq(varName,'OZZYALMUYP')) {
last_focused_comp=GetLastFocusedElementOfLink('OZZYALMUYP');
function SetMethod_OZZYALMUYP() {
Set_rcodvoc(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_OZZYALMUYP();
} else {
setTimeout(SetMethod_OZZYALMUYP,1);
}
bResult=true;
}
if (Eq(varName,'BOULPRIMLA')) {
last_focused_comp=GetLastFocusedElementOfLink('BOULPRIMLA');
function SetMethod_BOULPRIMLA() {
Set_rsetsin(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_BOULPRIMLA();
} else {
setTimeout(SetMethod_BOULPRIMLA,1);
}
bResult=true;
}
if (Eq(varName,'NJAIUIFRCH')) {
last_focused_comp=GetLastFocusedElementOfLink('NJAIUIFRCH');
function SetMethod_NJAIUIFRCH() {
Set_rpaecon(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_NJAIUIFRCH();
} else {
setTimeout(SetMethod_NJAIUIFRCH,1);
}
bResult=true;
}
if (Eq(varName,'QWUXFRTCAK')) {
last_focused_comp=GetLastFocusedElementOfLink('QWUXFRTCAK');
function SetMethod_QWUXFRTCAK() {
Set_rpaeint(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_QWUXFRTCAK();
} else {
setTimeout(SetMethod_QWUXFRTCAK,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'OLAQSOZFCY')) {
return [Ctrl('OLAQSOZFCY')];
}
if (Eq(varName,'UGMSDYOXMM')) {
return [Ctrl('UGMSDYOXMM')];
}
if (Eq(varName,'OZZYALMUYP')) {
return [Ctrl('OZZYALMUYP')];
}
if (Eq(varName,'BOULPRIMLA')) {
return [Ctrl('BOULPRIMLA')];
}
if (Eq(varName,'NJAIUIFRCH')) {
return [Ctrl('NJAIUIFRCH')];
}
if (Eq(varName,'QWUXFRTCAK')) {
return [Ctrl('QWUXFRTCAK')];
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
if ( ! (_ChkObl('INCSNNUWOV',1))) {
_SignErr('INCSNNUWOV');
m_cLastWorkVarErrorMsg='484641';
l_bResult=false;
w_anno=HtW('','N');
} else if ( ! (_ChkObl('TCZMCNHUFI',1))) {
_SignErr('TCZMCNHUFI');
m_cLastWorkVarErrorMsg='444829';
l_bResult=false;
w_mese=HtW('','C');
} else if ( ! (_ChkObl('PRCVTCPVCB',1))) {
_SignErr('PRCVTCPVCB');
m_cLastWorkVarErrorMsg='829257574';
l_bResult=false;
w_TipoOper=HtW('','C');
} else if ( ! (_ChkObl('OLAQSOZFCY',1))) {
_SignErr('OLAQSOZFCY');
m_cLastWorkVarErrorMsg='11933509554';
l_bResult=false;
w_rcoddip=HtW('','C');
} else if ( ! (_ChkObl('JGTODNXAVD',1))) {
_SignErr('JGTODNXAVD');
m_cLastWorkVarErrorMsg='167425256';
l_bResult=false;
w_rabicab=HtW('','C');
} else if ( ! (_ChkObl('FMRCIWUEYR',1))) {
_SignErr('FMRCIWUEYR');
m_cLastWorkVarErrorMsg='10848850431';
l_bResult=false;
w_rcabdip=HtW('','C');
} else if ( ! (_ChkObl('UGMSDYOXMM',1))) {
_SignErr('UGMSDYOXMM');
m_cLastWorkVarErrorMsg='98127897';
l_bResult=false;
w_rpaecli=HtW('','C');
} else if ( ! (_ChkObl('GUVXBUJIEG',1))) {
_SignErr('GUVXBUJIEG');
m_cLastWorkVarErrorMsg='11073368319';
l_bResult=false;
w_rcabcli=HtW('','C');
} else if ( ! (_ChkObl('OZZYALMUYP',1))) {
_SignErr('OZZYALMUYP');
m_cLastWorkVarErrorMsg='335886693';
l_bResult=false;
w_rcodvoc=HtW('','C');
} else if ( ! (_ChkObl('EVPCVZMBLL',1))) {
_SignErr('EVPCVZMBLL');
m_cLastWorkVarErrorMsg='109822566';
l_bResult=false;
w_rflglire=HtW('','C');
} else if ( ! (_ChkObl('KUXBYNJIYY',1))) {
_SignErr('KUXBYNJIYY');
m_cLastWorkVarErrorMsg='7753123';
l_bResult=false;
w_rsegno=HtW('','C');
} else if ( ! (_ChkObl('BOULPRIMLA',1))) {
_SignErr('BOULPRIMLA');
m_cLastWorkVarErrorMsg='496599153';
l_bResult=false;
w_rsetsin=HtW('','C');
} else if ( ! (_ChkObl('NJAIUIFRCH',1))) {
_SignErr('NJAIUIFRCH');
m_cLastWorkVarErrorMsg='10302774925';
l_bResult=false;
w_rpaecon=HtW('','C');
} else if ( ! (_ChkObl('RFAXHNVDNI',1))) {
_SignErr('RFAXHNVDNI');
m_cLastWorkVarErrorMsg='569232821';
l_bResult=false;
w_rcabcon=HtW('','C');
} else if ( ! (_ChkObl('QWUXFRTCAK',1))) {
_SignErr('QWUXFRTCAK');
m_cLastWorkVarErrorMsg='10846498013';
l_bResult=false;
w_rpaeint=HtW('','C');
} else if ( ! (_ChkObl('IYVNYANIYW',1))) {
_SignErr('IYVNYANIYW');
m_cLastWorkVarErrorMsg='10775068380';
l_bResult=false;
w_rcabint=HtW('','C');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('OLAQSOZFCY_ZOOM',lc)) {
return 0;
}
if (Eq('OLAQSOZFCY',lc)) {
return 0;
}
if (Eq('UGMSDYOXMM_ZOOM',lc)) {
return 1;
}
if (Eq('UGMSDYOXMM',lc)) {
return 1;
}
if (Eq('OZZYALMUYP_ZOOM',lc)) {
return 2;
}
if (Eq('OZZYALMUYP',lc)) {
return 2;
}
if (Eq('BOULPRIMLA_ZOOM',lc)) {
return 3;
}
if (Eq('BOULPRIMLA',lc)) {
return 3;
}
if (Eq('NJAIUIFRCH_ZOOM',lc)) {
return 4;
}
if (Eq('NJAIUIFRCH',lc)) {
return 4;
}
if (Eq('QWUXFRTCAK_ZOOM',lc)) {
return 5;
}
if (Eq('QWUXFRTCAK',lc)) {
return 5;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_OLAQSOZFCY();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_UGMSDYOXMM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_OZZYALMUYP();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,3)) {
l_oWv=LOpt_BOULPRIMLA();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,4)) {
l_oWv=LOpt_NJAIUIFRCH();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,5)) {
l_oWv=LOpt_QWUXFRTCAK();
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
l_oWv.setValue('mese',WtA(w_mese,'C'));
l_oWv.setValue('TipoOper',WtA(w_TipoOper,'C'));
l_oWv.setValue('gIntemediario',WtA(w_gIntemediario,'C'));
l_oWv.setValue('gTipInter',WtA(w_gTipInter,'C'));
l_oWv.setValue('DaDatOpe',WtA(w_DaDatOpe,'D'));
l_oWv.setValue('ADatOpe',WtA(w_ADatOpe,'D'));
l_oWv.setValue('rcoddip',WtA(w_rcoddip,'C'));
l_oWv.setValue('xdesdip',WtA(w_xdesdip,'C'));
l_oWv.setValue('rabicab',WtA(w_rabicab,'C'));
l_oWv.setValue('rcabdip',WtA(w_rcabdip,'C'));
l_oWv.setValue('rpaecli',WtA(w_rpaecli,'C'));
l_oWv.setValue('xpaesecli',WtA(w_xpaesecli,'C'));
l_oWv.setValue('rcabcli',WtA(w_rcabcli,'C'));
l_oWv.setValue('rcodvoc',WtA(w_rcodvoc,'C'));
l_oWv.setValue('xdescau',WtA(w_xdescau,'C'));
l_oWv.setValue('rflglire',WtA(w_rflglire,'C'));
l_oWv.setValue('rsegno',WtA(w_rsegno,'C'));
l_oWv.setValue('rsetsin',WtA(w_rsetsin,'C'));
l_oWv.setValue('rpaecon',WtA(w_rpaecon,'C'));
l_oWv.setValue('rcabcon',WtA(w_rcabcon,'C'));
l_oWv.setValue('rpaeint',WtA(w_rpaeint,'C'));
l_oWv.setValue('rcabint',WtA(w_rcabint,'C'));
l_oWv.setValue('xpaeseint',WtA(w_xpaeseint,'C'));
l_oWv.setValue('xpaesecon',WtA(w_xpaesecon,'C'));
l_oWv.setValue('xdesset',WtA(w_xdesset,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["anno","mese","TipoOper","gIntemediario","gTipInter","DaDatOpe","ADatOpe","rcoddip","xdesdip","rabicab","rcabdip","rpaecli","xpaesecli","rcabcli","rcodvoc","xdescau","rflglire","rsegno","rsetsin","rpaecon","rcabcon","rpaeint","rcabint","xpaeseint","xpaesecon","xdesset"];
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
if (Empty(w_DaDatOpe) && Ne(opener.w_DaDatOpe,null)) {
TransferBetweenWindows(opener,'w_DaDatOpe','w_DaDatOpe');
}
if (Empty(w_ADatOpe) && Ne(opener.w_ADatOpe,null)) {
TransferBetweenWindows(opener,'w_ADatOpe','w_ADatOpe');
}
}
}
m_bCalculating=true;
if (start && Eq(At(',anno,',pseq),0)) {
w_anno=Year(SystemDate());
}
w_DaDatOpe=( ! (Empty(w_anno)) &&  ! (Empty(w_mese))?CharToDate(Str(w_anno,4,0)+w_mese+'01'):NullDate());
w_ADatOpe=arfn_finemese(w_DaDatOpe);
Link_OLAQSOZFCY(null);
Link_UGMSDYOXMM(null);
Link_OZZYALMUYP(null);
Link_BOULPRIMLA(null);
Link_NJAIUIFRCH(null);
Link_QWUXFRTCAK(null);
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
_Obli('anno',1,'INCSNNUWOV',true,"484641")
_Obli('mese',0,'TCZMCNHUFI',true,"444829")
_Obli('TipoOper',0,'PRCVTCPVCB',true,"829257574")
_Obli('rcabdip',0,'FMRCIWUEYR',true,"10848850431")
_Obli('rcabint',0,'IYVNYANIYW',true,"10775068380",null,null,"Eq(w_rpaeint,'086')")
_Obli('rcabcli',0,'GUVXBUJIEG',true,"11073368319",null,null,"Eq(w_rpaecli,'086')")
_Obli('rpaeint',0,'QWUXFRTCAK',true,"10846498013",'QWUXFRTCAK')
_Obli('rcoddip',0,'OLAQSOZFCY',true,"11933509554",'OLAQSOZFCY')
_Obli('rcodvoc',0,'OZZYALMUYP',true,"335886693",'OZZYALMUYP')
_Obli('rabicab',0,'JGTODNXAVD',false,"167425256")
_Obli('rpaecon',0,'NJAIUIFRCH',true,"10302774925",'NJAIUIFRCH')
_Obli('rpaecli',0,'UGMSDYOXMM',true,"98127897",'UGMSDYOXMM')
_Obli('rcabcon',0,'RFAXHNVDNI',true,"569232821",null,null,"Eq(w_rpaecli,'086')")
_Obli('rsetsin',0,'BOULPRIMLA',true,"496599153",'BOULPRIMLA')
_Obli('rsegno',0,'KUXBYNJIYY',true,"7753123")
_Obli('rflglire',0,'EVPCVZMBLL',true,"109822566")
