function SetControlsValue() {
var c;
var c;
if(c=Ctrl('TJVNAGXDHC')) c.value = WtH(w_CONNES,'C',16,0,'')
if(c=Ctrl('BCFQRQNZJM')) c.value = WtH(w_AREAGEO,'C',5,0,'')
if(c=Ctrl('AKGZOBFEHJ')) c.value = WtH(w_RAREA,'N',3,0,'')
var tmp_MKGCFMDIFR = ToHTag(AsControlValue(w_xdesccomp));
if (Ne(e_MKGCFMDIFR,tmp_MKGCFMDIFR)) {
if(c=Ctrl('MKGCFMDIFR')) c.innerHTML=tmp_MKGCFMDIFR;
e_MKGCFMDIFR=tmp_MKGCFMDIFR;
}
if(c=Ctrl('HEAYXIPDHR')) c.value = WtH(w_PKTBSPECIE,'C',4,0,'')
if(c=Ctrl('PMYHCHZIWV')) c.value = WtH(w_RNATGIU,'N',3,0,'')
var tmp_WINLROSAWR = ToHTag(AsControlValue(w_xdescnatgiu));
if (Ne(e_WINLROSAWR,tmp_WINLROSAWR)) {
if(c=Ctrl('WINLROSAWR')) c.innerHTML=tmp_WINLROSAWR;
e_WINLROSAWR=tmp_WINLROSAWR;
}
if(c=Ctrl('MUJANTNTBM')) c.value = WtH(w_COMPORT,'C',5,0,'')
if(c=Ctrl('UFRMQEXWER')) c.value = WtH(w_RCOMP,'N',3,0,'')
var tmp_OVBLOKMXTL = ToHTag(AsControlValue(w_xareegeog));
if (Ne(e_OVBLOKMXTL,tmp_OVBLOKMXTL)) {
if(c=Ctrl('OVBLOKMXTL')) c.innerHTML=tmp_OVBLOKMXTL;
e_OVBLOKMXTL=tmp_OVBLOKMXTL;
}
if(c=Ctrl('KGWDOFUOWE')) c.value = WtH(w_BANCABEN,'C',11,0,'')
var tmp_JOCPJKPIZR = ToHTag(AsControlValue(w_ragbanben));
if (Ne(e_JOCPJKPIZR,tmp_JOCPJKPIZR)) {
if(c=Ctrl('JOCPJKPIZR')) c.innerHTML=tmp_JOCPJKPIZR;
e_JOCPJKPIZR=tmp_JOCPJKPIZR;
}
if(c=Ctrl('UIYRMZBTXN')) c.value = WtH(w_CITTADIN1,'C',3,0,'')
var tmp_UHICKFPGEL = ToHTag(AsControlValue(w_xDesCit1));
if (Ne(e_UHICKFPGEL,tmp_UHICKFPGEL)) {
if(c=Ctrl('UHICKFPGEL')) c.innerHTML=tmp_UHICKFPGEL;
e_UHICKFPGEL=tmp_UHICKFPGEL;
}
if(c=Ctrl('WTTMHORXIC')) c.value = WtH(w_CITTADIN2,'C',3,0,'')
var tmp_JPSRYRGJWE = ToHTag(AsControlValue(w_xDesCit2));
if (Ne(e_JPSRYRGJWE,tmp_JPSRYRGJWE)) {
if(c=Ctrl('JPSRYRGJWE')) c.innerHTML=tmp_JPSRYRGJWE;
e_JPSRYRGJWE=tmp_JPSRYRGJWE;
}
if(c=Ctrl('IEFIVEJHWI')) c.value = WtH(w_RESFISC,'C',3,0,'')
var tmp_MHAGFLZFVW = ToHTag(AsControlValue(w_xResFis));
if (Ne(e_MHAGFLZFVW,tmp_MHAGFLZFVW)) {
if(c=Ctrl('MHAGFLZFVW')) c.innerHTML=tmp_MHAGFLZFVW;
e_MHAGFLZFVW=tmp_MHAGFLZFVW;
}
if(c=Ctrl('BYFWYCWDSS')) c.value = WtH(w_MITIG,'N',4,0,'')
if(c=Ctrl('JMJDZQCPOM')) c.value = WtH(w_MITGDOC,'C',100,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('TJVNAGXDHC'),true || IsHiddenByStateDriver('CONNES'));
HideUI();
}
HideUI.lblids["AREAGEO"]=['QMLRYBDBVX'];
HideUI.lblids["BANCABEN"]=['LYSAOMHYTT'];
HideUI.lblids["CITTADIN1"]=['HSXHLMNVRG'];
HideUI.lblids["CITTADIN2"]=['ZXJRLOBYSB'];
HideUI.lblids["COMPORT"]=['OMJUPGXWIC'];
HideUI.lblids["MITGDOC"]=['YQUXOOFUTK'];
HideUI.lblids["MITIG"]=['XEOWJEFHMR','TDMTQHVPZW'];
HideUI.lblids["PKTBSPECIE"]=['EAQLLTYHOL'];
HideUI.lblids["RESFISC"]=['IHHARYGXBL'];
function href_RROILCAWGO() {
if (false || WindowConfirm(Translate('10108547188'))) {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('w_AREAGEO',AsAppletValue(w_AREAGEO));
SetHypPar('w_BANCABEN',AsAppletValue(w_BANCABEN));
SetHypPar('w_COMPORT',AsAppletValue(w_COMPORT));
SetHypPar('w_CONNES',AsAppletValue(w_CONNES));
SetHypPar('w_PKTBSPECIE',AsAppletValue(w_PKTBSPECIE));
SetHypPar('w_RAREA',AsAppletValue(w_RAREA));
SetHypPar('w_RCOMP',AsAppletValue(w_RCOMP));
SetHypPar('w_RNATGIU',AsAppletValue(w_RNATGIU));
SetHypPar('w_CITTADIN1',AsAppletValue(w_CITTADIN1));
SetHypPar('w_CITTADIN2',AsAppletValue(w_CITTADIN2));
SetHypPar('w_RESFISC',AsAppletValue(w_RESFISC));
SetHypPar('w_MITIG',AsAppletValue(w_MITIG));
SetHypPar('w_MITGDOC',AsAppletValue(w_MITGDOC));
SetHypPar('m_cParameterSequence',AsAppletValue('w_AREAGEO,w_BANCABEN,w_COMPORT,w_CONNES,w_PKTBSPECIE,w_RAREA,w_RCOMP,w_RNATGIU,w_CITTADIN1,w_CITTADIN2,w_RESFISC,w_MITIG,w_MITGDOC'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_modi_aggpers']));
SendData('start','arrt_modi_aggpers'+'',HParApplet().asString());
}
}
function href_ZQEKBHAOQV() {
if (false || WindowConfirm(Translate('11596038816'))) {
window.close()
}
}
function TJVNAGXDHC_Valid(e) {
SetActiveField(Ctrl('TJVNAGXDHC'),false);
e=(Ne(e,null)?e:window.event);
return Set_CONNES(HtW(Ctrl('TJVNAGXDHC').value,'C'),null,e);
}
function TJVNAGXDHC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TJVNAGXDHC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TJVNAGXDHC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TJVNAGXDHC'),e);
}
function BCFQRQNZJM_Valid(e) {
SetActiveField(Ctrl('BCFQRQNZJM'),false);
e=(Ne(e,null)?e:window.event);
return Set_AREAGEO(HtW(Ctrl('BCFQRQNZJM').value,'C'),null,e);
}
function BCFQRQNZJM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BCFQRQNZJM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BCFQRQNZJM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BCFQRQNZJM'),e);
}
function BCFQRQNZJM_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('BCFQRQNZJM')),'linkview_BCFQRQNZJM','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function AKGZOBFEHJ_Valid(e) {
SetActiveField(Ctrl('AKGZOBFEHJ'),false);
e=(Ne(e,null)?e:window.event);
return Set_RAREA(HtW(Ctrl('AKGZOBFEHJ').value,'N'),null,e);
}
function AKGZOBFEHJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AKGZOBFEHJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('AKGZOBFEHJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AKGZOBFEHJ'),e);
}
function HEAYXIPDHR_Valid(e) {
SetActiveField(Ctrl('HEAYXIPDHR'),false);
e=(Ne(e,null)?e:window.event);
return Set_PKTBSPECIE(HtW(Ctrl('HEAYXIPDHR').value,'C'),null,e);
}
function HEAYXIPDHR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HEAYXIPDHR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HEAYXIPDHR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HEAYXIPDHR'),e);
}
function HEAYXIPDHR_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('HEAYXIPDHR')),'linkview_HEAYXIPDHR','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function PMYHCHZIWV_Valid(e) {
SetActiveField(Ctrl('PMYHCHZIWV'),false);
e=(Ne(e,null)?e:window.event);
return Set_RNATGIU(HtW(Ctrl('PMYHCHZIWV').value,'N'),null,e);
}
function PMYHCHZIWV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PMYHCHZIWV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PMYHCHZIWV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PMYHCHZIWV'),e);
}
function MUJANTNTBM_Valid(e) {
SetActiveField(Ctrl('MUJANTNTBM'),false);
e=(Ne(e,null)?e:window.event);
return Set_COMPORT(HtW(Ctrl('MUJANTNTBM').value,'C'),null,e);
}
function MUJANTNTBM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MUJANTNTBM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MUJANTNTBM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MUJANTNTBM'),e);
}
function MUJANTNTBM_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('MUJANTNTBM')),'linkview_MUJANTNTBM','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function UFRMQEXWER_Valid(e) {
SetActiveField(Ctrl('UFRMQEXWER'),false);
e=(Ne(e,null)?e:window.event);
return Set_RCOMP(HtW(Ctrl('UFRMQEXWER').value,'N'),null,e);
}
function UFRMQEXWER_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UFRMQEXWER'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UFRMQEXWER'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UFRMQEXWER'),e);
}
function KGWDOFUOWE_Valid(e) {
SetActiveField(Ctrl('KGWDOFUOWE'),false);
e=(Ne(e,null)?e:window.event);
return Set_BANCABEN(HtW(Ctrl('KGWDOFUOWE').value,'C'),null,e);
}
function KGWDOFUOWE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KGWDOFUOWE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KGWDOFUOWE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KGWDOFUOWE'),e);
}
function KGWDOFUOWE_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('KGWDOFUOWE')),'linkview_KGWDOFUOWE','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function UIYRMZBTXN_Valid(e) {
SetActiveField(Ctrl('UIYRMZBTXN'),false);
e=(Ne(e,null)?e:window.event);
return Set_CITTADIN1(HtW(Ctrl('UIYRMZBTXN').value,'C'),null,e);
}
function UIYRMZBTXN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UIYRMZBTXN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UIYRMZBTXN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UIYRMZBTXN'),e);
}
function UIYRMZBTXN_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('UIYRMZBTXN')),'linkview_UIYRMZBTXN','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function WTTMHORXIC_Valid(e) {
SetActiveField(Ctrl('WTTMHORXIC'),false);
e=(Ne(e,null)?e:window.event);
return Set_CITTADIN2(HtW(Ctrl('WTTMHORXIC').value,'C'),null,e);
}
function WTTMHORXIC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WTTMHORXIC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('WTTMHORXIC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WTTMHORXIC'),e);
}
function WTTMHORXIC_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('WTTMHORXIC')),'linkview_WTTMHORXIC','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function IEFIVEJHWI_Valid(e) {
SetActiveField(Ctrl('IEFIVEJHWI'),false);
e=(Ne(e,null)?e:window.event);
return Set_RESFISC(HtW(Ctrl('IEFIVEJHWI').value,'C'),null,e);
}
function IEFIVEJHWI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IEFIVEJHWI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IEFIVEJHWI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IEFIVEJHWI'),e);
}
function IEFIVEJHWI_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('IEFIVEJHWI')),'linkview_IEFIVEJHWI','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function BYFWYCWDSS_Valid(e) {
SetActiveField(Ctrl('BYFWYCWDSS'),false);
e=(Ne(e,null)?e:window.event);
return Set_MITIG(HtW(Ctrl('BYFWYCWDSS').value,'N'),null,e);
}
function BYFWYCWDSS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BYFWYCWDSS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BYFWYCWDSS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BYFWYCWDSS'),e);
}
function JMJDZQCPOM_Valid(e) {
SetActiveField(Ctrl('JMJDZQCPOM'),false);
e=(Ne(e,null)?e:window.event);
return Set_MITGDOC(HtW(Ctrl('JMJDZQCPOM').value,'C'),null,e);
}
function JMJDZQCPOM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JMJDZQCPOM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JMJDZQCPOM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JMJDZQCPOM'),e);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('TJVNAGXDHC')) c.onblur=TJVNAGXDHC_Valid;
if(c=Ctrl('TJVNAGXDHC')) c.onfocus=TJVNAGXDHC_OnFocus;
if(c=Ctrl('BCFQRQNZJM')) c.onblur=BCFQRQNZJM_Valid;
if(c=Ctrl('BCFQRQNZJM')) c.onfocus=BCFQRQNZJM_OnFocus;
if(c=Ctrl('AKGZOBFEHJ')) c.onblur=AKGZOBFEHJ_Valid;
if(c=Ctrl('AKGZOBFEHJ')) c.onfocus=AKGZOBFEHJ_OnFocus;
if(c=Ctrl('AKGZOBFEHJ')) c.onkeypress=CheckNum;
if(c=Ctrl('HEAYXIPDHR')) c.onblur=HEAYXIPDHR_Valid;
if(c=Ctrl('HEAYXIPDHR')) c.onfocus=HEAYXIPDHR_OnFocus;
if(c=Ctrl('PMYHCHZIWV')) c.onblur=PMYHCHZIWV_Valid;
if(c=Ctrl('PMYHCHZIWV')) c.onfocus=PMYHCHZIWV_OnFocus;
if(c=Ctrl('PMYHCHZIWV')) c.onkeypress=CheckNum;
if(c=Ctrl('MUJANTNTBM')) c.onblur=MUJANTNTBM_Valid;
if(c=Ctrl('MUJANTNTBM')) c.onfocus=MUJANTNTBM_OnFocus;
if(c=Ctrl('UFRMQEXWER')) c.onblur=UFRMQEXWER_Valid;
if(c=Ctrl('UFRMQEXWER')) c.onfocus=UFRMQEXWER_OnFocus;
if(c=Ctrl('UFRMQEXWER')) c.onkeypress=CheckNum;
if(c=Ctrl('KGWDOFUOWE')) c.onblur=KGWDOFUOWE_Valid;
if(c=Ctrl('KGWDOFUOWE')) c.onfocus=KGWDOFUOWE_OnFocus;
if(c=Ctrl('UIYRMZBTXN')) c.onblur=UIYRMZBTXN_Valid;
if(c=Ctrl('UIYRMZBTXN')) c.onfocus=UIYRMZBTXN_OnFocus;
if(c=Ctrl('WTTMHORXIC')) c.onblur=WTTMHORXIC_Valid;
if(c=Ctrl('WTTMHORXIC')) c.onfocus=WTTMHORXIC_OnFocus;
if(c=Ctrl('IEFIVEJHWI')) c.onblur=IEFIVEJHWI_Valid;
if(c=Ctrl('IEFIVEJHWI')) c.onfocus=IEFIVEJHWI_OnFocus;
if(c=Ctrl('BYFWYCWDSS')) c.onblur=BYFWYCWDSS_Valid;
if(c=Ctrl('BYFWYCWDSS')) c.onfocus=BYFWYCWDSS_OnFocus;
if(c=Ctrl('BYFWYCWDSS')) c.onkeypress=CheckNum;
if(c=Ctrl('JMJDZQCPOM')) c.onblur=JMJDZQCPOM_Valid;
if(c=Ctrl('JMJDZQCPOM')) c.onfocus=JMJDZQCPOM_OnFocus;
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
FocusFirstComponent.otherwise={"page_1":["BCFQRQNZJM"]};
function Help() {
windowOpenForeground('../doc/arpg_modi_aggpers_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_xdesccomp=a[0];
w_xdescnatgiu=a[1];
w_xareegeog=a[2];
w_CONNES=a[3];
w_AREAGEO=a[4];
w_RAREA=a[5];
w_PKTBSPECIE=a[6];
w_RNATGIU=a[7];
w_COMPORT=a[8];
w_RCOMP=a[9];
w_BANCABEN=a[10];
w_ragbanben=a[11];
w_CITTADIN1=a[12];
w_xDesCit1=a[13];
w_CITTADIN2=a[14];
w_RESFISC=a[15];
w_xDesCit2=a[16];
w_xResFis=a[17];
w_MITIG=a[18];
w_MITGDOC=a[19];
o_AREAGEO=w_AREAGEO[1];
w_AREAGEO=w_AREAGEO[0];
o_PKTBSPECIE=w_PKTBSPECIE[1];
w_PKTBSPECIE=w_PKTBSPECIE[0];
o_COMPORT=w_COMPORT[1];
w_COMPORT=w_COMPORT[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_modi_aggpers',m_cSelectedPage);
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
function Set_COMPORT(ctrlValue,kmode,e) {
if (Ne(w_COMPORT,ctrlValue)) {
var ctl = _GetCtl(e,'MUJANTNTBM');
if (_tracker.goon(ctl,ctrlValue)) {
w_COMPORT=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MUJANTNTBM',0);
if (l_bResult) {
l_bResult=Link_MUJANTNTBM(kmode);
if ( ! (l_bResult)) {
w_COMPORT=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('BSNTWULPEA',0);
if (l_bResult) {
if ( ! (l_bResult)) {
w_COMPORT=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',5,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',5,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_MITGDOC(ctrlValue,kmode,e) {
if (Ne(w_MITGDOC,ctrlValue)) {
var ctl = _GetCtl(e,'JMJDZQCPOM');
if (_tracker.goon(ctl,ctrlValue)) {
w_MITGDOC=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JMJDZQCPOM',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',100,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_RNATGIU(ctrlValue,kmode,e) {
if (Ne(w_RNATGIU,ctrlValue)) {
var ctl = _GetCtl(e,'PMYHCHZIWV');
if (_tracker.goon(ctl,ctrlValue)) {
w_RNATGIU=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PMYHCHZIWV',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',3,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CONNES(ctrlValue,kmode,e) {
if (Ne(w_CONNES,ctrlValue)) {
var ctl = _GetCtl(e,'TJVNAGXDHC');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNES=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TJVNAGXDHC',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',16,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_AREAGEO(ctrlValue,kmode,e) {
if (Ne(w_AREAGEO,ctrlValue)) {
var ctl = _GetCtl(e,'BCFQRQNZJM');
if (_tracker.goon(ctl,ctrlValue)) {
w_AREAGEO=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BCFQRQNZJM',0);
if (l_bResult) {
l_bResult=Link_BCFQRQNZJM(kmode);
if ( ! (l_bResult)) {
w_AREAGEO=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('ITDOCXMPBH',0);
if (l_bResult) {
if ( ! (l_bResult)) {
w_AREAGEO=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',5,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',5,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_MITIG(ctrlValue,kmode,e) {
if (Ne(w_MITIG,ctrlValue)) {
var ctl = _GetCtl(e,'BYFWYCWDSS');
if (_tracker.goon(ctl,ctrlValue)) {
w_MITIG=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BYFWYCWDSS',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_RAREA(ctrlValue,kmode,e) {
if (Ne(w_RAREA,ctrlValue)) {
var ctl = _GetCtl(e,'AKGZOBFEHJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAREA=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AKGZOBFEHJ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',3,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_PKTBSPECIE(ctrlValue,kmode,e) {
if (Ne(w_PKTBSPECIE,ctrlValue)) {
var ctl = _GetCtl(e,'HEAYXIPDHR');
if (_tracker.goon(ctl,ctrlValue)) {
w_PKTBSPECIE=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HEAYXIPDHR',0);
if (l_bResult) {
l_bResult=Link_HEAYXIPDHR(kmode);
if ( ! (l_bResult)) {
w_PKTBSPECIE=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('DWJFSNZMHW',0);
if (l_bResult) {
if ( ! (l_bResult)) {
w_PKTBSPECIE=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',4,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_RCOMP(ctrlValue,kmode,e) {
if (Ne(w_RCOMP,ctrlValue)) {
var ctl = _GetCtl(e,'UFRMQEXWER');
if (_tracker.goon(ctl,ctrlValue)) {
w_RCOMP=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UFRMQEXWER',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',3,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_BANCABEN(ctrlValue,kmode,e) {
if (Ne(w_BANCABEN,ctrlValue)) {
var ctl = _GetCtl(e,'KGWDOFUOWE');
if (_tracker.goon(ctl,ctrlValue)) {
w_BANCABEN=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KGWDOFUOWE',0);
if (l_bResult) {
l_bResult=Link_KGWDOFUOWE(kmode);
if ( ! (l_bResult)) {
w_BANCABEN=HtW('','C');
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
function Set_RESFISC(ctrlValue,kmode,e) {
if (Ne(w_RESFISC,ctrlValue)) {
var ctl = _GetCtl(e,'IEFIVEJHWI');
if (_tracker.goon(ctl,ctrlValue)) {
w_RESFISC=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IEFIVEJHWI',0);
if (l_bResult) {
l_bResult=Link_IEFIVEJHWI(kmode);
if ( ! (l_bResult)) {
w_RESFISC=HtW('','C');
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
function Set_CITTADIN2(ctrlValue,kmode,e) {
if (Ne(w_CITTADIN2,ctrlValue)) {
var ctl = _GetCtl(e,'WTTMHORXIC');
if (_tracker.goon(ctl,ctrlValue)) {
w_CITTADIN2=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WTTMHORXIC',0);
if (l_bResult) {
l_bResult=Link_WTTMHORXIC(kmode);
if ( ! (l_bResult)) {
w_CITTADIN2=HtW('','C');
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
function Set_CITTADIN1(ctrlValue,kmode,e) {
if (Ne(w_CITTADIN1,ctrlValue)) {
var ctl = _GetCtl(e,'UIYRMZBTXN');
if (_tracker.goon(ctl,ctrlValue)) {
w_CITTADIN1=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UIYRMZBTXN',0);
if (l_bResult) {
l_bResult=Link_UIYRMZBTXN(kmode);
if ( ! (l_bResult)) {
w_CITTADIN1=HtW('','C');
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
if ((Ne(o_AREAGEO,w_AREAGEO))) {
l_bTmpRes=Link_ITDOCXMPBH(null);
}
if ((Ne(o_PKTBSPECIE,w_PKTBSPECIE))) {
l_bTmpRes=Link_DWJFSNZMHW(null);
}
if ((Ne(o_COMPORT,w_COMPORT))) {
l_bTmpRes=Link_BSNTWULPEA(null);
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
o_AREAGEO=w_AREAGEO;
o_PKTBSPECIE=w_PKTBSPECIE;
o_COMPORT=w_COMPORT;
}
function SaveLabelDependsOn() {
}
function Link_BCFQRQNZJM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_AREAGEO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_AREAGEO,5,0);
l_Appl.SetFields('CODICE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbareegeog');
l_Appl.SetID('BCFQRQNZJM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AREAGEO=l_Appl.GetStringValue('CODICE',5,0);
w_xareegeog=l_Appl.GetStringValue('DESCRI',50,0);
w_RAREA=l_Appl.GetDoubleValue('RISCHIO',3,0);
} else {
Link_BCFQRQNZJM_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_BCFQRQNZJM';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_BCFQRQNZJM();
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
function Link_BCFQRQNZJM_Blank() {
w_AREAGEO='';
w_xareegeog='';
w_RAREA=0;
}
function LOpt_BCFQRQNZJM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbareegeog','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('BCFQRQNZJM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['BCFQRQNZJM'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('406226152'),'C'));
return l_oWv;
}
function Link_ITDOCXMPBH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_AREAGEO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_AREAGEO,5,0);
l_Appl.SetFields('CODICE,RISCHIO');
l_Appl.SetTypes('C,N');
l_Appl.LinkTable('tbareegeog_p');
l_Appl.SetID('ITDOCXMPBH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AREAGEO=l_Appl.GetStringValue('CODICE',5,0);
w_RAREA=l_Appl.GetDoubleValue('RISCHIO',3,0);
} else {
Link_ITDOCXMPBH_Blank();
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
return l_bResult;
}
function Link_ITDOCXMPBH_Blank() {
w_AREAGEO='';
w_RAREA=0;
}
function LOpt_ITDOCXMPBH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbareegeog_p','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('ITDOCXMPBH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ITDOCXMPBH'][1],'C'));
return l_oWv;
}
function Link_HEAYXIPDHR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_PKTBSPECIE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSPE',w_PKTBSPECIE,4,0);
l_Appl.SetFields('CODSPE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbspecie');
l_Appl.SetID('HEAYXIPDHR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_PKTBSPECIE=l_Appl.GetStringValue('CODSPE',4,0);
w_xdescnatgiu=l_Appl.GetStringValue('DESCRI',60,0);
} else {
Link_HEAYXIPDHR_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_HEAYXIPDHR';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_HEAYXIPDHR();
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
function Link_HEAYXIPDHR_Blank() {
w_PKTBSPECIE='';
w_xdescnatgiu='';
}
function LOpt_HEAYXIPDHR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbspecie','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSPE','C'));
l_oWv.setValue('LinkedField',WtA('CODSPE','C'));
l_oWv.setValue('UID',WtA('HEAYXIPDHR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['HEAYXIPDHR'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11158852142'),'C'));
return l_oWv;
}
function Link_DWJFSNZMHW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_PKTBSPECIE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSPE',w_PKTBSPECIE,4,0);
l_Appl.SetFields('CODSPE,RISCHIO');
l_Appl.SetTypes('C,N');
l_Appl.LinkTable('tbspecie_p');
l_Appl.SetID('DWJFSNZMHW');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_PKTBSPECIE=l_Appl.GetStringValue('CODSPE',4,0);
w_RNATGIU=l_Appl.GetDoubleValue('RISCHIO',3,0);
} else {
Link_DWJFSNZMHW_Blank();
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
return l_bResult;
}
function Link_DWJFSNZMHW_Blank() {
w_PKTBSPECIE='';
w_RNATGIU=0;
}
function LOpt_DWJFSNZMHW() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbspecie_p','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSPE','C'));
l_oWv.setValue('LinkedField',WtA('CODSPE','C'));
l_oWv.setValue('UID',WtA('DWJFSNZMHW','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['DWJFSNZMHW'][1],'C'));
return l_oWv;
}
function Link_MUJANTNTBM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_COMPORT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_COMPORT,5,0);
l_Appl.SetFields('CODICE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcondotta');
l_Appl.SetID('MUJANTNTBM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_COMPORT=l_Appl.GetStringValue('CODICE',5,0);
w_xdesccomp=l_Appl.GetStringValue('DESCRI',200,0);
} else {
Link_MUJANTNTBM_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_MUJANTNTBM';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_MUJANTNTBM();
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
function Link_MUJANTNTBM_Blank() {
w_COMPORT='';
w_xdesccomp='';
}
function LOpt_MUJANTNTBM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcondotta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('MUJANTNTBM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['MUJANTNTBM'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('955814582'),'C'));
return l_oWv;
}
function Link_BSNTWULPEA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_COMPORT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_COMPORT,5,0);
l_Appl.SetFields('CODICE,RISCHIO');
l_Appl.SetTypes('C,N');
l_Appl.LinkTable('tbcondotta_p');
l_Appl.SetID('BSNTWULPEA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_COMPORT=l_Appl.GetStringValue('CODICE',5,0);
w_RCOMP=l_Appl.GetDoubleValue('RISCHIO',3,0);
} else {
Link_BSNTWULPEA_Blank();
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
return l_bResult;
}
function Link_BSNTWULPEA_Blank() {
w_COMPORT='';
w_RCOMP=0;
}
function LOpt_BSNTWULPEA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcondotta_p','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('BSNTWULPEA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['BSNTWULPEA'][1],'C'));
return l_oWv;
}
function Link_KGWDOFUOWE(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_BANCABEN);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODINTER',w_BANCABEN,11,0);
l_Appl.SetFields('CODINTER,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('inter2bo');
l_Appl.SetID('KGWDOFUOWE');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_BANCABEN=l_Appl.GetStringValue('CODINTER',11,0);
w_ragbanben=l_Appl.GetStringValue('RAGSOC',70,0);
} else {
Link_KGWDOFUOWE_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_KGWDOFUOWE';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_KGWDOFUOWE();
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
function Link_KGWDOFUOWE_Blank() {
w_BANCABEN='';
w_ragbanben='';
}
function LOpt_KGWDOFUOWE() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('inter2bo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODINTER','C'));
l_oWv.setValue('LinkedField',WtA('CODINTER','C'));
l_oWv.setValue('UID',WtA('KGWDOFUOWE','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['KGWDOFUOWE'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10608444682'),'C'));
return l_oWv;
}
function Link_UIYRMZBTXN(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CITTADIN1);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_CITTADIN1,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('UIYRMZBTXN');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CITTADIN1=l_Appl.GetStringValue('CODSTA',3,0);
w_xDesCit1=l_Appl.GetStringValue('DESCRI',40,0);
} else {
Link_UIYRMZBTXN_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_UIYRMZBTXN';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_UIYRMZBTXN();
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
function Link_UIYRMZBTXN_Blank() {
w_CITTADIN1='';
w_xDesCit1='';
}
function LOpt_UIYRMZBTXN() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('UIYRMZBTXN','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UIYRMZBTXN'][1],'C'));
return l_oWv;
}
function Link_WTTMHORXIC(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CITTADIN2);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_CITTADIN2,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('WTTMHORXIC');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CITTADIN2=l_Appl.GetStringValue('CODSTA',3,0);
w_xDesCit2=l_Appl.GetStringValue('DESCRI',40,0);
} else {
Link_WTTMHORXIC_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_WTTMHORXIC';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_WTTMHORXIC();
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
function Link_WTTMHORXIC_Blank() {
w_CITTADIN2='';
w_xDesCit2='';
}
function LOpt_WTTMHORXIC() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('WTTMHORXIC','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['WTTMHORXIC'][1],'C'));
return l_oWv;
}
function Link_IEFIVEJHWI(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_RESFISC);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_RESFISC,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('IEFIVEJHWI');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_RESFISC=l_Appl.GetStringValue('CODSTA',3,0);
w_xResFis=l_Appl.GetStringValue('DESCRI',40,0);
} else {
Link_IEFIVEJHWI_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_IEFIVEJHWI';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_IEFIVEJHWI();
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
function Link_IEFIVEJHWI_Blank() {
w_RESFISC='';
w_xResFis='';
}
function LOpt_IEFIVEJHWI() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('IEFIVEJHWI','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['IEFIVEJHWI'][1],'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'BCFQRQNZJM')) {
last_focused_comp=GetLastFocusedElementOfLink('BCFQRQNZJM');
function SetMethod_BCFQRQNZJM() {
Set_AREAGEO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_BCFQRQNZJM();
} else {
setTimeout(SetMethod_BCFQRQNZJM,1);
}
bResult=true;
}
if (Eq(varName,'HEAYXIPDHR')) {
last_focused_comp=GetLastFocusedElementOfLink('HEAYXIPDHR');
function SetMethod_HEAYXIPDHR() {
Set_PKTBSPECIE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_HEAYXIPDHR();
} else {
setTimeout(SetMethod_HEAYXIPDHR,1);
}
bResult=true;
}
if (Eq(varName,'MUJANTNTBM')) {
last_focused_comp=GetLastFocusedElementOfLink('MUJANTNTBM');
function SetMethod_MUJANTNTBM() {
Set_COMPORT(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_MUJANTNTBM();
} else {
setTimeout(SetMethod_MUJANTNTBM,1);
}
bResult=true;
}
if (Eq(varName,'KGWDOFUOWE')) {
last_focused_comp=GetLastFocusedElementOfLink('KGWDOFUOWE');
function SetMethod_KGWDOFUOWE() {
Set_BANCABEN(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_KGWDOFUOWE();
} else {
setTimeout(SetMethod_KGWDOFUOWE,1);
}
bResult=true;
}
if (Eq(varName,'UIYRMZBTXN')) {
last_focused_comp=GetLastFocusedElementOfLink('UIYRMZBTXN');
function SetMethod_UIYRMZBTXN() {
Set_CITTADIN1(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_UIYRMZBTXN();
} else {
setTimeout(SetMethod_UIYRMZBTXN,1);
}
bResult=true;
}
if (Eq(varName,'WTTMHORXIC')) {
last_focused_comp=GetLastFocusedElementOfLink('WTTMHORXIC');
function SetMethod_WTTMHORXIC() {
Set_CITTADIN2(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_WTTMHORXIC();
} else {
setTimeout(SetMethod_WTTMHORXIC,1);
}
bResult=true;
}
if (Eq(varName,'IEFIVEJHWI')) {
last_focused_comp=GetLastFocusedElementOfLink('IEFIVEJHWI');
function SetMethod_IEFIVEJHWI() {
Set_RESFISC(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_IEFIVEJHWI();
} else {
setTimeout(SetMethod_IEFIVEJHWI,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'BCFQRQNZJM')) {
return [Ctrl('BCFQRQNZJM')];
}
if (Eq(varName,'HEAYXIPDHR')) {
return [Ctrl('HEAYXIPDHR')];
}
if (Eq(varName,'MUJANTNTBM')) {
return [Ctrl('MUJANTNTBM')];
}
if (Eq(varName,'KGWDOFUOWE')) {
return [Ctrl('KGWDOFUOWE')];
}
if (Eq(varName,'UIYRMZBTXN')) {
return [Ctrl('UIYRMZBTXN')];
}
if (Eq(varName,'WTTMHORXIC')) {
return [Ctrl('WTTMHORXIC')];
}
if (Eq(varName,'IEFIVEJHWI')) {
return [Ctrl('IEFIVEJHWI')];
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
if ( ! (_ChkObl('TJVNAGXDHC',1))) {
_SignErr('TJVNAGXDHC');
m_cLastWorkVarErrorMsg='CONNES';
l_bResult=false;
w_CONNES=HtW('','C');
} else if ( ! (_ChkObl('BCFQRQNZJM',1))) {
_SignErr('BCFQRQNZJM');
m_cLastWorkVarErrorMsg='AREAGEO';
l_bResult=false;
w_AREAGEO=HtW('','C');
} else if ( ! (_ChkObl('AKGZOBFEHJ',1))) {
_SignErr('AKGZOBFEHJ');
m_cLastWorkVarErrorMsg='1310320066';
l_bResult=false;
w_RAREA=HtW('','N');
} else if ( ! (_ChkObl('HEAYXIPDHR',1))) {
_SignErr('HEAYXIPDHR');
m_cLastWorkVarErrorMsg='11158852142';
l_bResult=false;
w_PKTBSPECIE=HtW('','C');
} else if ( ! (_ChkObl('PMYHCHZIWV',1))) {
_SignErr('PMYHCHZIWV');
m_cLastWorkVarErrorMsg='1701052417';
l_bResult=false;
w_RNATGIU=HtW('','N');
} else if ( ! (_ChkObl('MUJANTNTBM',1))) {
_SignErr('MUJANTNTBM');
m_cLastWorkVarErrorMsg='COMPORT';
l_bResult=false;
w_COMPORT=HtW('','C');
} else if ( ! (_ChkObl('UFRMQEXWER',1))) {
_SignErr('UFRMQEXWER');
m_cLastWorkVarErrorMsg='1310320066';
l_bResult=false;
w_RCOMP=HtW('','N');
} else if ( ! (_ChkObl('KGWDOFUOWE',1))) {
_SignErr('KGWDOFUOWE');
m_cLastWorkVarErrorMsg='11391158649';
l_bResult=false;
w_BANCABEN=HtW('','C');
} else if ( ! (_ChkObl('UIYRMZBTXN',1))) {
_SignErr('UIYRMZBTXN');
m_cLastWorkVarErrorMsg='1390365716';
l_bResult=false;
w_CITTADIN1=HtW('','C');
} else if ( ! (_ChkObl('WTTMHORXIC',1))) {
_SignErr('WTTMHORXIC');
m_cLastWorkVarErrorMsg='1392462868';
l_bResult=false;
w_CITTADIN2=HtW('','C');
} else if ( ! (_ChkObl('IEFIVEJHWI',1))) {
_SignErr('IEFIVEJHWI');
m_cLastWorkVarErrorMsg='1013244520';
l_bResult=false;
w_RESFISC=HtW('','C');
} else if ( ! (_ChkObl('BYFWYCWDSS',1))) {
_SignErr('BYFWYCWDSS');
m_cLastWorkVarErrorMsg='307787605';
l_bResult=false;
w_MITIG=HtW('','N');
} else if ( ! (_ChkObl('JMJDZQCPOM',1))) {
_SignErr('JMJDZQCPOM');
m_cLastWorkVarErrorMsg='210895516';
l_bResult=false;
w_MITGDOC=HtW('','C');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('BCFQRQNZJM_ZOOM',lc)) {
return 0;
}
if (Eq('BCFQRQNZJM',lc)) {
return 0;
}
if (Eq('HEAYXIPDHR_ZOOM',lc)) {
return 1;
}
if (Eq('HEAYXIPDHR',lc)) {
return 1;
}
if (Eq('MUJANTNTBM_ZOOM',lc)) {
return 2;
}
if (Eq('MUJANTNTBM',lc)) {
return 2;
}
if (Eq('KGWDOFUOWE_ZOOM',lc)) {
return 3;
}
if (Eq('KGWDOFUOWE',lc)) {
return 3;
}
if (Eq('UIYRMZBTXN_ZOOM',lc)) {
return 4;
}
if (Eq('UIYRMZBTXN',lc)) {
return 4;
}
if (Eq('WTTMHORXIC_ZOOM',lc)) {
return 5;
}
if (Eq('WTTMHORXIC',lc)) {
return 5;
}
if (Eq('IEFIVEJHWI_ZOOM',lc)) {
return 6;
}
if (Eq('IEFIVEJHWI',lc)) {
return 6;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_BCFQRQNZJM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_HEAYXIPDHR();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_MUJANTNTBM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,3)) {
l_oWv=LOpt_KGWDOFUOWE();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,4)) {
l_oWv=LOpt_UIYRMZBTXN();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,5)) {
l_oWv=LOpt_WTTMHORXIC();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,6)) {
l_oWv=LOpt_IEFIVEJHWI();
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
l_oWv.setValue('xdesccomp',WtA(w_xdesccomp,'C'));
l_oWv.setValue('xdescnatgiu',WtA(w_xdescnatgiu,'C'));
l_oWv.setValue('xareegeog',WtA(w_xareegeog,'C'));
l_oWv.setValue('CONNES',WtA(w_CONNES,'C'));
l_oWv.setValue('AREAGEO',WtA(w_AREAGEO,'C'));
l_oWv.setValue('RAREA',WtA(w_RAREA,'N'));
l_oWv.setValue('PKTBSPECIE',WtA(w_PKTBSPECIE,'C'));
l_oWv.setValue('RNATGIU',WtA(w_RNATGIU,'N'));
l_oWv.setValue('COMPORT',WtA(w_COMPORT,'C'));
l_oWv.setValue('RCOMP',WtA(w_RCOMP,'N'));
l_oWv.setValue('BANCABEN',WtA(w_BANCABEN,'C'));
l_oWv.setValue('ragbanben',WtA(w_ragbanben,'C'));
l_oWv.setValue('CITTADIN1',WtA(w_CITTADIN1,'C'));
l_oWv.setValue('xDesCit1',WtA(w_xDesCit1,'C'));
l_oWv.setValue('CITTADIN2',WtA(w_CITTADIN2,'C'));
l_oWv.setValue('RESFISC',WtA(w_RESFISC,'C'));
l_oWv.setValue('xDesCit2',WtA(w_xDesCit2,'C'));
l_oWv.setValue('xResFis',WtA(w_xResFis,'C'));
l_oWv.setValue('MITIG',WtA(w_MITIG,'N'));
l_oWv.setValue('MITGDOC',WtA(w_MITGDOC,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["xdesccomp","xdescnatgiu","xareegeog","CONNES","AREAGEO","RAREA","PKTBSPECIE","RNATGIU","COMPORT","RCOMP","BANCABEN","ragbanben","CITTADIN1","xDesCit1","CITTADIN2","RESFISC","xDesCit2","xResFis","MITIG","MITGDOC"];
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
if (Empty(w_CONNES) && Ne(opener.w_CONNES,null)) {
TransferBetweenWindows(opener,'w_CONNES',null,'Set_CONNES');
}
if (Empty(w_AREAGEO) && Ne(opener.w_AREAGEO,null)) {
TransferBetweenWindows(opener,'w_AREAGEO',null,'Set_AREAGEO');
}
if (Empty(w_RAREA) && Ne(opener.w_RAREA,null)) {
TransferBetweenWindows(opener,'w_RAREA',null,'Set_RAREA');
}
if (Empty(w_PKTBSPECIE) && Ne(opener.w_PKTBSPECIE,null)) {
TransferBetweenWindows(opener,'w_PKTBSPECIE',null,'Set_PKTBSPECIE');
}
if (Empty(w_RNATGIU) && Ne(opener.w_RNATGIU,null)) {
TransferBetweenWindows(opener,'w_RNATGIU',null,'Set_RNATGIU');
}
if (Empty(w_COMPORT) && Ne(opener.w_COMPORT,null)) {
TransferBetweenWindows(opener,'w_COMPORT',null,'Set_COMPORT');
}
if (Empty(w_RCOMP) && Ne(opener.w_RCOMP,null)) {
TransferBetweenWindows(opener,'w_RCOMP',null,'Set_RCOMP');
}
if (Empty(w_BANCABEN) && Ne(opener.w_BANCABEN,null)) {
TransferBetweenWindows(opener,'w_BANCABEN',null,'Set_BANCABEN');
}
if (Empty(w_CITTADIN1) && Ne(opener.w_CITTADIN1,null)) {
TransferBetweenWindows(opener,'w_CITTADIN1',null,'Set_CITTADIN1');
}
if (Empty(w_CITTADIN2) && Ne(opener.w_CITTADIN2,null)) {
TransferBetweenWindows(opener,'w_CITTADIN2',null,'Set_CITTADIN2');
}
if (Empty(w_RESFISC) && Ne(opener.w_RESFISC,null)) {
TransferBetweenWindows(opener,'w_RESFISC',null,'Set_RESFISC');
}
if (Empty(w_MITIG) && Ne(opener.w_MITIG,null)) {
TransferBetweenWindows(opener,'w_MITIG',null,'Set_MITIG');
}
if (Empty(w_MITGDOC) && Ne(opener.w_MITGDOC,null)) {
TransferBetweenWindows(opener,'w_MITGDOC',null,'Set_MITGDOC');
}
}
}
m_bCalculating=true;
Link_BCFQRQNZJM(null);
Link_ITDOCXMPBH(null);
Link_HEAYXIPDHR(null);
Link_DWJFSNZMHW(null);
Link_MUJANTNTBM(null);
Link_BSNTWULPEA(null);
Link_KGWDOFUOWE(null);
Link_UIYRMZBTXN(null);
Link_WTTMHORXIC(null);
Link_IEFIVEJHWI(null);
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
_Obli('COMPORT',0,'MUJANTNTBM',false)
_Obli('COMPORT',0,'BSNTWULPEA',false)
_Obli('MITGDOC',0,'JMJDZQCPOM',false,"210895516")
_Obli('RNATGIU',1,'PMYHCHZIWV',false,"1701052417")
_Obli('CONNES',0,'TJVNAGXDHC',false)
_Obli('AREAGEO',0,'BCFQRQNZJM',false)
_Obli('AREAGEO',0,'ITDOCXMPBH',false)
_Obli('MITIG',1,'BYFWYCWDSS',false,"307787605")
_Obli('RAREA',1,'AKGZOBFEHJ',false,"1310320066")
_Obli('PKTBSPECIE',0,'HEAYXIPDHR',false,"11158852142")
_Obli('PKTBSPECIE',0,'DWJFSNZMHW',false,"11158852142")
_Obli('RCOMP',1,'UFRMQEXWER',false,"1310320066")
_Obli('BANCABEN',0,'KGWDOFUOWE',false,"11391158649")
_Obli('RESFISC',0,'IEFIVEJHWI',false,"1013244520")
_Obli('CITTADIN2',0,'WTTMHORXIC',false,"1392462868")
_Obli('CITTADIN1',0,'UIYRMZBTXN',false,"1390365716")
