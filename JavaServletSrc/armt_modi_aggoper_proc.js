function SetControlsValue() {
var c;
var c;
if(c=Ctrl('QGVSOMWQKO')) c.value = WtH(w_OPERAG,'C',3,0,'')
if(c=Ctrl('VXNCZZQUTU')) c.value = WtH(w_RESPINS,'C',30,0,'')
if(c=Ctrl('UHKTWUYPMH')) c.value = WtH(w_INFORM,'C',30,0,'')
if(c=Ctrl('XQEWDORSRU')) ChkboxCheckUncheck(c,1,w_NOPROT)
if(c=Ctrl('XQEWDORSRU')) ChkboxValueAssign(c,1,0,'N',1,0,'')
var tmp_IFYTOFMTWY = ToHTag(AsControlValue(w_xdescopeage));
if (Ne(e_IFYTOFMTWY,tmp_IFYTOFMTWY)) {
if(c=Ctrl('IFYTOFMTWY')) c.innerHTML=tmp_IFYTOFMTWY;
e_IFYTOFMTWY=tmp_IFYTOFMTWY;
}
if(c=Ctrl('MUJANTNTBM')) c.value = WtH(w_RAGIO,'C',5,0,'')
if(c=Ctrl('HEAYXIPDHR')) c.value = WtH(w_MODSVOL,'C',5,0,'')
if(c=Ctrl('BCFQRQNZJM')) c.value = WtH(w_AREAGEO,'C',5,0,'')
var tmp_MKGCFMDIFR = ToHTag(AsControlValue(w_xdescrag));
if (Ne(e_MKGCFMDIFR,tmp_MKGCFMDIFR)) {
if(c=Ctrl('MKGCFMDIFR')) c.innerHTML=tmp_MKGCFMDIFR;
e_MKGCFMDIFR=tmp_MKGCFMDIFR;
}
var tmp_WINLROSAWR = ToHTag(AsControlValue(w_xmodsvol));
if (Ne(e_WINLROSAWR,tmp_WINLROSAWR)) {
if(c=Ctrl('WINLROSAWR')) c.innerHTML=tmp_WINLROSAWR;
e_WINLROSAWR=tmp_WINLROSAWR;
}
var tmp_OVBLOKMXTL = ToHTag(AsControlValue(w_xareegeog));
if (Ne(e_OVBLOKMXTL,tmp_OVBLOKMXTL)) {
if(c=Ctrl('OVBLOKMXTL')) c.innerHTML=tmp_OVBLOKMXTL;
e_OVBLOKMXTL=tmp_OVBLOKMXTL;
}
if(c=Ctrl('TMQBHKYHRS')) c.value = WtH(w_NATURA,'C',50,0,'')
if(c=Ctrl('MJXJDMQQRI')) c.value = WtH(w_SCOPO,'C',50,0,'')
if(c=Ctrl('FKIUXYFTAY')) c.value = WtH(w_TIPO,'C',3,0,'')
var tmp_VCGKYDPCZH = ToHTag(AsControlValue(w_xdesctipor));
if (Ne(e_VCGKYDPCZH,tmp_VCGKYDPCZH)) {
if(c=Ctrl('VCGKYDPCZH')) c.innerHTML=tmp_VCGKYDPCZH;
e_VCGKYDPCZH=tmp_VCGKYDPCZH;
}
if(c=Ctrl('CXKIEWTPXM')) c.value = WtH(w_RFREQ,'N',3,0,'')
if(c=Ctrl('AKGZOBFEHJ')) c.value = WtH(w_RAREA,'N',3,0,'')
if(c=Ctrl('PMYHCHZIWV')) c.value = WtH(w_RCOMP,'N',3,0,'')
if(c=Ctrl('UFRMQEXWER')) c.value = WtH(w_RRAGIO,'N',3,0,'')
if(c=Ctrl('HJNXGLDJPH')) c.value = WtH(w_RTIPO,'N',3,0,'')
if(c=Ctrl('EZKIGVHOME')) c.value = WtH(w_RIMP,'N',3,0,'')
if(c=Ctrl('HMBPBMNNSQ')) c.value = WtH(w_AMMONT,'C',5,0,'')
if(c=Ctrl('XJFWPDTBUT')) c.value = WtH(w_DURAT,'C',5,0,'')
var tmp_YGMVSHOXQQ = ToHTag(AsControlValue(w_xammont));
if (Ne(e_YGMVSHOXQQ,tmp_YGMVSHOXQQ)) {
if(c=Ctrl('YGMVSHOXQQ')) c.innerHTML=tmp_YGMVSHOXQQ;
e_YGMVSHOXQQ=tmp_YGMVSHOXQQ;
}
var tmp_JQLJCTWIDF = ToHTag(AsControlValue(w_xdurat));
if (Ne(e_JQLJCTWIDF,tmp_JQLJCTWIDF)) {
if(c=Ctrl('JQLJCTWIDF')) c.innerHTML=tmp_JQLJCTWIDF;
e_JQLJCTWIDF=tmp_JQLJCTWIDF;
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
HideUI();
}
HideUI.lblids["AMMONT"]=['KRTOISVCUF'];
HideUI.lblids["AREAGEO"]=['QMLRYBDBVX'];
HideUI.lblids["DURAT"]=['HMWWZRPUTP'];
HideUI.lblids["INFORM"]=['UEOPGTWLUL'];
HideUI.lblids["MODSVOL"]=['EAQLLTYHOL'];
HideUI.lblids["NATURA"]=['KFTGHDJCYW'];
HideUI.lblids["OPERAG"]=['PIAIOUTMLP'];
HideUI.lblids["RAGIO"]=['OMJUPGXWIC'];
HideUI.lblids["RESPINS"]=['WNUAUHZXGB'];
HideUI.lblids["SCOPO"]=['YXRVJJQAOH'];
HideUI.lblids["TIPO"]=['IMIRLRSKNU'];
function QGVSOMWQKO_Valid(e) {
SetActiveField(Ctrl('QGVSOMWQKO'),false);
e=(Ne(e,null)?e:window.event);
return Set_OPERAG(HtW(Ctrl('QGVSOMWQKO').value,'C'),null,e);
}
function QGVSOMWQKO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QGVSOMWQKO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QGVSOMWQKO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QGVSOMWQKO'),e);
}
function QGVSOMWQKO_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('QGVSOMWQKO')),'linkview_QGVSOMWQKO','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function VXNCZZQUTU_Valid(e) {
SetActiveField(Ctrl('VXNCZZQUTU'),false);
e=(Ne(e,null)?e:window.event);
return Set_RESPINS(HtW(Ctrl('VXNCZZQUTU').value,'C'),null,e);
}
function VXNCZZQUTU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VXNCZZQUTU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VXNCZZQUTU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VXNCZZQUTU'),e);
}
function UHKTWUYPMH_Valid(e) {
SetActiveField(Ctrl('UHKTWUYPMH'),false);
e=(Ne(e,null)?e:window.event);
return Set_INFORM(HtW(Ctrl('UHKTWUYPMH').value,'C'),null,e);
}
function UHKTWUYPMH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UHKTWUYPMH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UHKTWUYPMH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UHKTWUYPMH'),e);
}
function XQEWDORSRU_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_NOPROT(ChkboxValueAssign(Ctrl('XQEWDORSRU'),1,0,'N',1,0,''),null,e);
}
function XQEWDORSRU_OnFocus(e) {
SetActiveField(Ctrl('XQEWDORSRU'),true);
}
function XQEWDORSRU_OnBlur(e) {
SetActiveField(Ctrl('XQEWDORSRU'),false);
}
function href_RROILCAWGO() {
SalvaDati()
}
function href_ZQEKBHAOQV() {
window.close()
}
function MUJANTNTBM_Valid(e) {
SetActiveField(Ctrl('MUJANTNTBM'),false);
e=(Ne(e,null)?e:window.event);
return Set_RAGIO(HtW(Ctrl('MUJANTNTBM').value,'C'),null,e);
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
function HEAYXIPDHR_Valid(e) {
SetActiveField(Ctrl('HEAYXIPDHR'),false);
e=(Ne(e,null)?e:window.event);
return Set_MODSVOL(HtW(Ctrl('HEAYXIPDHR').value,'C'),null,e);
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
function TMQBHKYHRS_Valid(e) {
SetActiveField(Ctrl('TMQBHKYHRS'),false);
e=(Ne(e,null)?e:window.event);
return Set_NATURA(HtW(Ctrl('TMQBHKYHRS').value,'C'),null,e);
}
function TMQBHKYHRS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TMQBHKYHRS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TMQBHKYHRS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TMQBHKYHRS'),e);
}
function MJXJDMQQRI_Valid(e) {
SetActiveField(Ctrl('MJXJDMQQRI'),false);
e=(Ne(e,null)?e:window.event);
return Set_SCOPO(HtW(Ctrl('MJXJDMQQRI').value,'C'),null,e);
}
function MJXJDMQQRI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MJXJDMQQRI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MJXJDMQQRI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MJXJDMQQRI'),e);
}
function FKIUXYFTAY_Valid(e) {
SetActiveField(Ctrl('FKIUXYFTAY'),false);
e=(Ne(e,null)?e:window.event);
return Set_TIPO(HtW(Ctrl('FKIUXYFTAY').value,'C'),null,e);
}
function FKIUXYFTAY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FKIUXYFTAY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FKIUXYFTAY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FKIUXYFTAY'),e);
}
function FKIUXYFTAY_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('FKIUXYFTAY')),'linkview_FKIUXYFTAY','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function CXKIEWTPXM_Valid(e) {
SetActiveField(Ctrl('CXKIEWTPXM'),false);
e=(Ne(e,null)?e:window.event);
return Set_RFREQ(HtW(Ctrl('CXKIEWTPXM').value,'N'),null,e);
}
function CXKIEWTPXM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CXKIEWTPXM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CXKIEWTPXM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CXKIEWTPXM'),e);
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
function PMYHCHZIWV_Valid(e) {
SetActiveField(Ctrl('PMYHCHZIWV'),false);
e=(Ne(e,null)?e:window.event);
return Set_RCOMP(HtW(Ctrl('PMYHCHZIWV').value,'N'),null,e);
}
function PMYHCHZIWV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PMYHCHZIWV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PMYHCHZIWV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PMYHCHZIWV'),e);
}
function UFRMQEXWER_Valid(e) {
SetActiveField(Ctrl('UFRMQEXWER'),false);
e=(Ne(e,null)?e:window.event);
return Set_RRAGIO(HtW(Ctrl('UFRMQEXWER').value,'N'),null,e);
}
function UFRMQEXWER_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UFRMQEXWER'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UFRMQEXWER'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UFRMQEXWER'),e);
}
function HJNXGLDJPH_Valid(e) {
SetActiveField(Ctrl('HJNXGLDJPH'),false);
e=(Ne(e,null)?e:window.event);
return Set_RTIPO(HtW(Ctrl('HJNXGLDJPH').value,'N'),null,e);
}
function HJNXGLDJPH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HJNXGLDJPH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HJNXGLDJPH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HJNXGLDJPH'),e);
}
function EZKIGVHOME_Valid(e) {
SetActiveField(Ctrl('EZKIGVHOME'),false);
e=(Ne(e,null)?e:window.event);
return Set_RIMP(HtW(Ctrl('EZKIGVHOME').value,'N'),null,e);
}
function EZKIGVHOME_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EZKIGVHOME'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('EZKIGVHOME'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EZKIGVHOME'),e);
}
function HMBPBMNNSQ_Valid(e) {
SetActiveField(Ctrl('HMBPBMNNSQ'),false);
e=(Ne(e,null)?e:window.event);
return Set_AMMONT(HtW(Ctrl('HMBPBMNNSQ').value,'C'),null,e);
}
function HMBPBMNNSQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HMBPBMNNSQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HMBPBMNNSQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HMBPBMNNSQ'),e);
}
function HMBPBMNNSQ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('HMBPBMNNSQ')),'linkview_HMBPBMNNSQ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function XJFWPDTBUT_Valid(e) {
SetActiveField(Ctrl('XJFWPDTBUT'),false);
e=(Ne(e,null)?e:window.event);
return Set_DURAT(HtW(Ctrl('XJFWPDTBUT').value,'C'),null,e);
}
function XJFWPDTBUT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XJFWPDTBUT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XJFWPDTBUT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XJFWPDTBUT'),e);
}
function XJFWPDTBUT_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('XJFWPDTBUT')),'linkview_XJFWPDTBUT','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('QGVSOMWQKO')) c.onblur=QGVSOMWQKO_Valid;
if(c=Ctrl('QGVSOMWQKO')) c.onfocus=QGVSOMWQKO_OnFocus;
if(c=Ctrl('VXNCZZQUTU')) c.onblur=VXNCZZQUTU_Valid;
if(c=Ctrl('VXNCZZQUTU')) c.onfocus=VXNCZZQUTU_OnFocus;
if(c=Ctrl('UHKTWUYPMH')) c.onblur=UHKTWUYPMH_Valid;
if(c=Ctrl('UHKTWUYPMH')) c.onfocus=UHKTWUYPMH_OnFocus;
if(c=Ctrl('XQEWDORSRU')) c.onclick=XQEWDORSRU_Valid;
if(c=Ctrl('XQEWDORSRU')) c.onfocus=XQEWDORSRU_OnFocus;
if(c=Ctrl('XQEWDORSRU')) c.onblur=XQEWDORSRU_OnBlur;
if(c=Ctrl('MUJANTNTBM')) c.onblur=MUJANTNTBM_Valid;
if(c=Ctrl('MUJANTNTBM')) c.onfocus=MUJANTNTBM_OnFocus;
if(c=Ctrl('HEAYXIPDHR')) c.onblur=HEAYXIPDHR_Valid;
if(c=Ctrl('HEAYXIPDHR')) c.onfocus=HEAYXIPDHR_OnFocus;
if(c=Ctrl('BCFQRQNZJM')) c.onblur=BCFQRQNZJM_Valid;
if(c=Ctrl('BCFQRQNZJM')) c.onfocus=BCFQRQNZJM_OnFocus;
if(c=Ctrl('TMQBHKYHRS')) c.onblur=TMQBHKYHRS_Valid;
if(c=Ctrl('TMQBHKYHRS')) c.onfocus=TMQBHKYHRS_OnFocus;
if(c=Ctrl('MJXJDMQQRI')) c.onblur=MJXJDMQQRI_Valid;
if(c=Ctrl('MJXJDMQQRI')) c.onfocus=MJXJDMQQRI_OnFocus;
if(c=Ctrl('FKIUXYFTAY')) c.onblur=FKIUXYFTAY_Valid;
if(c=Ctrl('FKIUXYFTAY')) c.onfocus=FKIUXYFTAY_OnFocus;
if(c=Ctrl('CXKIEWTPXM')) c.onblur=CXKIEWTPXM_Valid;
if(c=Ctrl('CXKIEWTPXM')) c.onfocus=CXKIEWTPXM_OnFocus;
if(c=Ctrl('CXKIEWTPXM')) c.onkeypress=CheckNum;
if(c=Ctrl('AKGZOBFEHJ')) c.onblur=AKGZOBFEHJ_Valid;
if(c=Ctrl('AKGZOBFEHJ')) c.onfocus=AKGZOBFEHJ_OnFocus;
if(c=Ctrl('AKGZOBFEHJ')) c.onkeypress=CheckNum;
if(c=Ctrl('PMYHCHZIWV')) c.onblur=PMYHCHZIWV_Valid;
if(c=Ctrl('PMYHCHZIWV')) c.onfocus=PMYHCHZIWV_OnFocus;
if(c=Ctrl('PMYHCHZIWV')) c.onkeypress=CheckNum;
if(c=Ctrl('UFRMQEXWER')) c.onblur=UFRMQEXWER_Valid;
if(c=Ctrl('UFRMQEXWER')) c.onfocus=UFRMQEXWER_OnFocus;
if(c=Ctrl('UFRMQEXWER')) c.onkeypress=CheckNum;
if(c=Ctrl('HJNXGLDJPH')) c.onblur=HJNXGLDJPH_Valid;
if(c=Ctrl('HJNXGLDJPH')) c.onfocus=HJNXGLDJPH_OnFocus;
if(c=Ctrl('HJNXGLDJPH')) c.onkeypress=CheckNum;
if(c=Ctrl('EZKIGVHOME')) c.onblur=EZKIGVHOME_Valid;
if(c=Ctrl('EZKIGVHOME')) c.onfocus=EZKIGVHOME_OnFocus;
if(c=Ctrl('EZKIGVHOME')) c.onkeypress=CheckNum;
if(c=Ctrl('HMBPBMNNSQ')) c.onblur=HMBPBMNNSQ_Valid;
if(c=Ctrl('HMBPBMNNSQ')) c.onfocus=HMBPBMNNSQ_OnFocus;
if(c=Ctrl('XJFWPDTBUT')) c.onblur=XJFWPDTBUT_Valid;
if(c=Ctrl('XJFWPDTBUT')) c.onfocus=XJFWPDTBUT_OnFocus;
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
FocusFirstComponent.otherwise={"page_1":["QGVSOMWQKO"]};
function Help() {
windowOpenForeground('../doc/armt_modi_aggoper_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_OPERAG=a[0];
w_RESPINS=a[1];
w_INFORM=a[2];
w_xdescrag=a[3];
w_xmodsvol=a[4];
w_xareegeog=a[5];
w_xdescopeage=a[6];
w_NOPROT=a[7];
w_IDBASE=a[8];
w_RAGIO=a[9];
w_MODSVOL=a[10];
w_AREAGEO=a[11];
w_NATURA=a[12];
w_SCOPO=a[13];
w_TIPO=a[14];
w_xdesctipor=a[15];
w_RFREQ=a[16];
w_RAREA=a[17];
w_RCOMP=a[18];
w_RRAGIO=a[19];
w_RTIPO=a[20];
w_RIMP=a[21];
w_AMMONT=a[22];
w_DURAT=a[23];
w_xdurat=a[24];
w_xammont=a[25];
o_RAGIO=w_RAGIO[1];
w_RAGIO=w_RAGIO[0];
o_MODSVOL=w_MODSVOL[1];
w_MODSVOL=w_MODSVOL[0];
o_AREAGEO=w_AREAGEO[1];
w_AREAGEO=w_AREAGEO[0];
o_TIPO=w_TIPO[1];
w_TIPO=w_TIPO[0];
o_AMMONT=w_AMMONT[1];
w_AMMONT=w_AMMONT[0];
o_DURAT=w_DURAT[1];
w_DURAT=w_DURAT[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_modi_aggoper',m_cSelectedPage);
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
function Set_OPERAG(ctrlValue,kmode,e) {
if (Ne(w_OPERAG,ctrlValue)) {
var ctl = _GetCtl(e,'QGVSOMWQKO');
if (_tracker.goon(ctl,ctrlValue)) {
w_OPERAG=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QGVSOMWQKO',0);
if (l_bResult) {
l_bResult=Link_QGVSOMWQKO(kmode);
if ( ! (l_bResult)) {
w_OPERAG=HtW('','C');
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
function Set_RESPINS(ctrlValue,kmode,e) {
if (Ne(w_RESPINS,ctrlValue)) {
var ctl = _GetCtl(e,'VXNCZZQUTU');
if (_tracker.goon(ctl,ctrlValue)) {
w_RESPINS=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VXNCZZQUTU',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',30,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_INFORM(ctrlValue,kmode,e) {
if (Ne(w_INFORM,ctrlValue)) {
var ctl = _GetCtl(e,'UHKTWUYPMH');
if (_tracker.goon(ctl,ctrlValue)) {
w_INFORM=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UHKTWUYPMH',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',30,0,'');
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
l_bResult=l_bResult && _ChkObl('JSRWGYXWUP',0);
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
function Set_SCOPO(ctrlValue,kmode,e) {
if (Ne(w_SCOPO,ctrlValue)) {
var ctl = _GetCtl(e,'MJXJDMQQRI');
if (_tracker.goon(ctl,ctrlValue)) {
w_SCOPO=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MJXJDMQQRI',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',50,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_AMMONT(ctrlValue,kmode,e) {
if (Ne(w_AMMONT,ctrlValue)) {
var ctl = _GetCtl(e,'HMBPBMNNSQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_AMMONT=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HMBPBMNNSQ',0);
if (l_bResult) {
l_bResult=Link_HMBPBMNNSQ(kmode);
if ( ! (l_bResult)) {
w_AMMONT=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('OXGJIOYQVA',0);
if (l_bResult) {
if ( ! (l_bResult)) {
w_AMMONT=HtW('','C');
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
function Set_RIMP(ctrlValue,kmode,e) {
if (Ne(w_RIMP,ctrlValue)) {
var ctl = _GetCtl(e,'EZKIGVHOME');
if (_tracker.goon(ctl,ctrlValue)) {
w_RIMP=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EZKIGVHOME',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',3,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_NOPROT(ctrlValue,kmode,e) {
if (Ne(w_NOPROT,ctrlValue)) {
var ctl = _GetCtl(e,'XQEWDORSRU');
if (_tracker.goon(ctl,ctrlValue)) {
w_NOPROT=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XQEWDORSRU',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TIPO(ctrlValue,kmode,e) {
if (Ne(w_TIPO,ctrlValue)) {
var ctl = _GetCtl(e,'FKIUXYFTAY');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPO=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FKIUXYFTAY',0);
if (l_bResult) {
l_bResult=Link_FKIUXYFTAY(kmode);
if ( ! (l_bResult)) {
w_TIPO=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('ZXAGFQXBRH',0);
if (l_bResult) {
if ( ! (l_bResult)) {
w_TIPO=HtW('','C');
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
function Set_RAGIO(ctrlValue,kmode,e) {
if (Ne(w_RAGIO,ctrlValue)) {
var ctl = _GetCtl(e,'MUJANTNTBM');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAGIO=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MUJANTNTBM',0);
if (l_bResult) {
l_bResult=Link_MUJANTNTBM(kmode);
if ( ! (l_bResult)) {
w_RAGIO=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('UVOSMLOZGD',0);
if (l_bResult) {
if ( ! (l_bResult)) {
w_RAGIO=HtW('','C');
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
function Set_MODSVOL(ctrlValue,kmode,e) {
if (Ne(w_MODSVOL,ctrlValue)) {
var ctl = _GetCtl(e,'HEAYXIPDHR');
if (_tracker.goon(ctl,ctrlValue)) {
w_MODSVOL=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HEAYXIPDHR',0);
if (l_bResult) {
l_bResult=Link_HEAYXIPDHR(kmode);
if ( ! (l_bResult)) {
w_MODSVOL=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('UUIMACOHVM',0);
if (l_bResult) {
if ( ! (l_bResult)) {
w_MODSVOL=HtW('','C');
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
function Set_DURAT(ctrlValue,kmode,e) {
if (Ne(w_DURAT,ctrlValue)) {
var ctl = _GetCtl(e,'XJFWPDTBUT');
if (_tracker.goon(ctl,ctrlValue)) {
w_DURAT=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XJFWPDTBUT',0);
if (l_bResult) {
l_bResult=Link_XJFWPDTBUT(kmode);
if ( ! (l_bResult)) {
w_DURAT=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('ZBLNCBPFUK',0);
if (l_bResult) {
if ( ! (l_bResult)) {
w_DURAT=HtW('','C');
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
function Set_NATURA(ctrlValue,kmode,e) {
if (Ne(w_NATURA,ctrlValue)) {
var ctl = _GetCtl(e,'TMQBHKYHRS');
if (_tracker.goon(ctl,ctrlValue)) {
w_NATURA=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TMQBHKYHRS',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',50,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_RFREQ(ctrlValue,kmode,e) {
if (Ne(w_RFREQ,ctrlValue)) {
var ctl = _GetCtl(e,'CXKIEWTPXM');
if (_tracker.goon(ctl,ctrlValue)) {
w_RFREQ=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CXKIEWTPXM',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',3,0,'');
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
function Set_RTIPO(ctrlValue,kmode,e) {
if (Ne(w_RTIPO,ctrlValue)) {
var ctl = _GetCtl(e,'HJNXGLDJPH');
if (_tracker.goon(ctl,ctrlValue)) {
w_RTIPO=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HJNXGLDJPH',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',3,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_RRAGIO(ctrlValue,kmode,e) {
if (Ne(w_RRAGIO,ctrlValue)) {
var ctl = _GetCtl(e,'UFRMQEXWER');
if (_tracker.goon(ctl,ctrlValue)) {
w_RRAGIO=ctrlValue;
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
function Set_RCOMP(ctrlValue,kmode,e) {
if (Ne(w_RCOMP,ctrlValue)) {
var ctl = _GetCtl(e,'PMYHCHZIWV');
if (_tracker.goon(ctl,ctrlValue)) {
w_RCOMP=ctrlValue;
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
if ((Ne(o_TIPO,w_TIPO))) {
l_bTmpRes=Link_ZXAGFQXBRH(null);
}
if ((Ne(o_RAGIO,w_RAGIO))) {
l_bTmpRes=Link_UVOSMLOZGD(null);
}
if ((Ne(o_MODSVOL,w_MODSVOL))) {
l_bTmpRes=Link_UUIMACOHVM(null);
}
if ((Ne(o_AREAGEO,w_AREAGEO))) {
l_bTmpRes=Link_JSRWGYXWUP(null);
}
if ((Ne(o_AMMONT,w_AMMONT))) {
l_bTmpRes=Link_OXGJIOYQVA(null);
}
if ((Ne(o_DURAT,w_DURAT))) {
l_bTmpRes=Link_ZBLNCBPFUK(null);
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
o_RAGIO=w_RAGIO;
o_MODSVOL=w_MODSVOL;
o_AREAGEO=w_AREAGEO;
o_TIPO=w_TIPO;
o_AMMONT=w_AMMONT;
o_DURAT=w_DURAT;
}
function SaveLabelDependsOn() {
}
function Link_QGVSOMWQKO(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_OPERAG);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_OPERAG,3,0);
l_Appl.SetFields('CODICE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbtipope');
l_Appl.SetID('QGVSOMWQKO');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_OPERAG=l_Appl.GetStringValue('CODICE',3,0);
w_xdescopeage=l_Appl.GetStringValue('DESCRI',254,0);
} else {
Link_QGVSOMWQKO_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_QGVSOMWQKO';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_QGVSOMWQKO();
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
function Link_QGVSOMWQKO_Blank() {
w_OPERAG='';
w_xdescopeage='';
}
function LOpt_QGVSOMWQKO() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipope','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('QGVSOMWQKO','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QGVSOMWQKO'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('103243324'),'C'));
return l_oWv;
}
function Link_MUJANTNTBM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_RAGIO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_RAGIO,5,0);
l_Appl.SetFields('CODICE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbplauso');
l_Appl.SetID('MUJANTNTBM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_RAGIO=l_Appl.GetStringValue('CODICE',5,0);
w_xdescrag=l_Appl.GetStringValue('DESCRI',50,0);
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
w_RAGIO='';
w_xdescrag='';
}
function LOpt_MUJANTNTBM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbplauso','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('MUJANTNTBM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['MUJANTNTBM'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('955814582'),'C'));
return l_oWv;
}
function Link_HEAYXIPDHR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_MODSVOL);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_MODSVOL,5,0);
l_Appl.SetFields('CODICE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbsvolgim');
l_Appl.SetID('HEAYXIPDHR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_MODSVOL=l_Appl.GetStringValue('CODICE',5,0);
w_xmodsvol=l_Appl.GetStringValue('DESCRI',50,0);
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
w_MODSVOL='';
w_xmodsvol='';
}
function LOpt_HEAYXIPDHR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbsvolgim','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('HEAYXIPDHR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['HEAYXIPDHR'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11158852142'),'C'));
return l_oWv;
}
function Link_BCFQRQNZJM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_AREAGEO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_AREAGEO,5,0);
l_Appl.SetFields('CODICE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbareegeog');
l_Appl.SetID('BCFQRQNZJM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AREAGEO=l_Appl.GetStringValue('CODICE',5,0);
w_xareegeog=l_Appl.GetStringValue('DESCRI',50,0);
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
function Link_FKIUXYFTAY(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TIPO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_TIPO,3,0);
l_Appl.SetFields('CODICE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbtiporisc');
l_Appl.SetID('FKIUXYFTAY');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TIPO=l_Appl.GetStringValue('CODICE',3,0);
w_xdesctipor=l_Appl.GetStringValue('DESCRI',100,0);
} else {
Link_FKIUXYFTAY_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_FKIUXYFTAY';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_FKIUXYFTAY();
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
function Link_FKIUXYFTAY_Blank() {
w_TIPO='';
w_xdesctipor='';
}
function LOpt_FKIUXYFTAY() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtiporisc','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('FKIUXYFTAY','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['FKIUXYFTAY'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10049460300'),'C'));
return l_oWv;
}
function Link_HMBPBMNNSQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_AMMONT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_AMMONT,5,0);
l_Appl.SetFields('CODICE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbimporto');
l_Appl.SetID('HMBPBMNNSQ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AMMONT=l_Appl.GetStringValue('CODICE',5,0);
w_xammont=l_Appl.GetStringValue('DESCRI',200,0);
} else {
Link_HMBPBMNNSQ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_HMBPBMNNSQ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_HMBPBMNNSQ();
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
function Link_HMBPBMNNSQ_Blank() {
w_AMMONT='';
w_xammont='';
}
function LOpt_HMBPBMNNSQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbimporto','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('HMBPBMNNSQ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['HMBPBMNNSQ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11857520945'),'C'));
return l_oWv;
}
function Link_XJFWPDTBUT(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DURAT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_DURAT,5,0);
l_Appl.SetFields('CODICE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbdurata');
l_Appl.SetID('XJFWPDTBUT');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DURAT=l_Appl.GetStringValue('CODICE',5,0);
w_xdurat=l_Appl.GetStringValue('DESCRI',200,0);
} else {
Link_XJFWPDTBUT_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_XJFWPDTBUT';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_XJFWPDTBUT();
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
function Link_XJFWPDTBUT_Blank() {
w_DURAT='';
w_xdurat='';
}
function LOpt_XJFWPDTBUT() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbdurata','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('XJFWPDTBUT','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['XJFWPDTBUT'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('492819232'),'C'));
return l_oWv;
}
function Link_ZXAGFQXBRH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TIPO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_TIPO,3,0);
l_Appl.SetFields('CODICE,RISCHIO');
l_Appl.SetTypes('C,N');
l_Appl.LinkTable('tbtiporisc_p');
l_Appl.SetID('ZXAGFQXBRH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TIPO=l_Appl.GetStringValue('CODICE',3,0);
w_RTIPO=l_Appl.GetDoubleValue('RISCHIO',3,0);
} else {
Link_ZXAGFQXBRH_Blank();
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
function Link_ZXAGFQXBRH_Blank() {
w_TIPO='';
w_RTIPO=0;
}
function LOpt_ZXAGFQXBRH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtiporisc_p','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('ZXAGFQXBRH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ZXAGFQXBRH'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10049460300'),'C'));
return l_oWv;
}
function Link_UVOSMLOZGD(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_RAGIO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_RAGIO,5,0);
l_Appl.SetFields('CODICE,RISCHIO');
l_Appl.SetTypes('C,N');
l_Appl.LinkTable('tbplauso_p');
l_Appl.SetID('UVOSMLOZGD');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_RAGIO=l_Appl.GetStringValue('CODICE',5,0);
w_RRAGIO=l_Appl.GetDoubleValue('RISCHIO',3,0);
} else {
Link_UVOSMLOZGD_Blank();
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
function Link_UVOSMLOZGD_Blank() {
w_RAGIO='';
w_RRAGIO=0;
}
function LOpt_UVOSMLOZGD() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbplauso_p','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('UVOSMLOZGD','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UVOSMLOZGD'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('955814582'),'C'));
return l_oWv;
}
function Link_UUIMACOHVM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_MODSVOL);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_MODSVOL,5,0);
l_Appl.SetFields('CODICE,RISCHIO');
l_Appl.SetTypes('C,N');
l_Appl.LinkTable('tbsvolgim_p');
l_Appl.SetID('UUIMACOHVM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_MODSVOL=l_Appl.GetStringValue('CODICE',5,0);
w_RCOMP=l_Appl.GetDoubleValue('RISCHIO',3,0);
} else {
Link_UUIMACOHVM_Blank();
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
function Link_UUIMACOHVM_Blank() {
w_MODSVOL='';
w_RCOMP=0;
}
function LOpt_UUIMACOHVM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbsvolgim_p','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('UUIMACOHVM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UUIMACOHVM'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11158852142'),'C'));
return l_oWv;
}
function Link_JSRWGYXWUP(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_AREAGEO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_AREAGEO,5,0);
l_Appl.SetFields('CODICE,RISCHIO');
l_Appl.SetTypes('C,N');
l_Appl.LinkTable('tbareegeog_p');
l_Appl.SetID('JSRWGYXWUP');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AREAGEO=l_Appl.GetStringValue('CODICE',5,0);
w_RAREA=l_Appl.GetDoubleValue('RISCHIO',3,0);
} else {
Link_JSRWGYXWUP_Blank();
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
function Link_JSRWGYXWUP_Blank() {
w_AREAGEO='';
w_RAREA=0;
}
function LOpt_JSRWGYXWUP() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbareegeog_p','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('JSRWGYXWUP','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['JSRWGYXWUP'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('406226152'),'C'));
return l_oWv;
}
function Link_OXGJIOYQVA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_AMMONT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_AMMONT,5,0);
l_Appl.SetFields('CODICE,RISCHIO');
l_Appl.SetTypes('C,N');
l_Appl.LinkTable('tbimporto_p');
l_Appl.SetID('OXGJIOYQVA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AMMONT=l_Appl.GetStringValue('CODICE',5,0);
w_RIMP=l_Appl.GetDoubleValue('RISCHIO',3,0);
} else {
Link_OXGJIOYQVA_Blank();
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
function Link_OXGJIOYQVA_Blank() {
w_AMMONT='';
w_RIMP=0;
}
function LOpt_OXGJIOYQVA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbimporto_p','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('OXGJIOYQVA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['OXGJIOYQVA'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11857520945'),'C'));
return l_oWv;
}
function Link_ZBLNCBPFUK(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DURAT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_DURAT,5,0);
l_Appl.SetFields('CODICE,RISCHIO');
l_Appl.SetTypes('C,N');
l_Appl.LinkTable('tbdurata_p');
l_Appl.SetID('ZBLNCBPFUK');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DURAT=l_Appl.GetStringValue('CODICE',5,0);
w_RFREQ=l_Appl.GetDoubleValue('RISCHIO',3,0);
} else {
Link_ZBLNCBPFUK_Blank();
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
function Link_ZBLNCBPFUK_Blank() {
w_DURAT='';
w_RFREQ=0;
}
function LOpt_ZBLNCBPFUK() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbdurata_p','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('ZBLNCBPFUK','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ZBLNCBPFUK'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('492819232'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'QGVSOMWQKO')) {
last_focused_comp=GetLastFocusedElementOfLink('QGVSOMWQKO');
function SetMethod_QGVSOMWQKO() {
Set_OPERAG(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_QGVSOMWQKO();
} else {
setTimeout(SetMethod_QGVSOMWQKO,1);
}
bResult=true;
}
if (Eq(varName,'MUJANTNTBM')) {
last_focused_comp=GetLastFocusedElementOfLink('MUJANTNTBM');
function SetMethod_MUJANTNTBM() {
Set_RAGIO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_MUJANTNTBM();
} else {
setTimeout(SetMethod_MUJANTNTBM,1);
}
bResult=true;
}
if (Eq(varName,'HEAYXIPDHR')) {
last_focused_comp=GetLastFocusedElementOfLink('HEAYXIPDHR');
function SetMethod_HEAYXIPDHR() {
Set_MODSVOL(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_HEAYXIPDHR();
} else {
setTimeout(SetMethod_HEAYXIPDHR,1);
}
bResult=true;
}
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
if (Eq(varName,'FKIUXYFTAY')) {
last_focused_comp=GetLastFocusedElementOfLink('FKIUXYFTAY');
function SetMethod_FKIUXYFTAY() {
Set_TIPO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_FKIUXYFTAY();
} else {
setTimeout(SetMethod_FKIUXYFTAY,1);
}
bResult=true;
}
if (Eq(varName,'HMBPBMNNSQ')) {
last_focused_comp=GetLastFocusedElementOfLink('HMBPBMNNSQ');
function SetMethod_HMBPBMNNSQ() {
Set_AMMONT(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_HMBPBMNNSQ();
} else {
setTimeout(SetMethod_HMBPBMNNSQ,1);
}
bResult=true;
}
if (Eq(varName,'XJFWPDTBUT')) {
last_focused_comp=GetLastFocusedElementOfLink('XJFWPDTBUT');
function SetMethod_XJFWPDTBUT() {
Set_DURAT(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_XJFWPDTBUT();
} else {
setTimeout(SetMethod_XJFWPDTBUT,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'QGVSOMWQKO')) {
return [Ctrl('QGVSOMWQKO')];
}
if (Eq(varName,'MUJANTNTBM')) {
return [Ctrl('MUJANTNTBM')];
}
if (Eq(varName,'HEAYXIPDHR')) {
return [Ctrl('HEAYXIPDHR')];
}
if (Eq(varName,'BCFQRQNZJM')) {
return [Ctrl('BCFQRQNZJM')];
}
if (Eq(varName,'FKIUXYFTAY')) {
return [Ctrl('FKIUXYFTAY')];
}
if (Eq(varName,'HMBPBMNNSQ')) {
return [Ctrl('HMBPBMNNSQ')];
}
if (Eq(varName,'XJFWPDTBUT')) {
return [Ctrl('XJFWPDTBUT')];
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
if ( ! (_ChkObl('QGVSOMWQKO',1))) {
_SignErr('QGVSOMWQKO');
m_cLastWorkVarErrorMsg='OPERAG';
l_bResult=false;
w_OPERAG=HtW('','C');
} else if ( ! (_ChkObl('VXNCZZQUTU',1))) {
_SignErr('VXNCZZQUTU');
m_cLastWorkVarErrorMsg='RESPINS';
l_bResult=false;
w_RESPINS=HtW('','C');
} else if ( ! (_ChkObl('UHKTWUYPMH',1))) {
_SignErr('UHKTWUYPMH');
m_cLastWorkVarErrorMsg='INFORM';
l_bResult=false;
w_INFORM=HtW('','C');
} else if ( ! (_ChkObl('XQEWDORSRU',1))) {
_SignErr('XQEWDORSRU');
m_cLastWorkVarErrorMsg='NOPROT';
l_bResult=false;
w_NOPROT=0;
} else if ( ! (_ChkObl('MUJANTNTBM',1))) {
_SignErr('MUJANTNTBM');
m_cLastWorkVarErrorMsg='RAGIO';
l_bResult=false;
w_RAGIO=HtW('','C');
} else if ( ! (_ChkObl('HEAYXIPDHR',1))) {
_SignErr('HEAYXIPDHR');
m_cLastWorkVarErrorMsg='11158852142';
l_bResult=false;
w_MODSVOL=HtW('','C');
} else if ( ! (_ChkObl('BCFQRQNZJM',1))) {
_SignErr('BCFQRQNZJM');
m_cLastWorkVarErrorMsg='AREAGEO';
l_bResult=false;
w_AREAGEO=HtW('','C');
} else if ( ! (_ChkObl('TMQBHKYHRS',1))) {
_SignErr('TMQBHKYHRS');
m_cLastWorkVarErrorMsg='NATURA';
l_bResult=false;
w_NATURA=HtW('','C');
} else if ( ! (_ChkObl('MJXJDMQQRI',1))) {
_SignErr('MJXJDMQQRI');
m_cLastWorkVarErrorMsg='SCOPO';
l_bResult=false;
w_SCOPO=HtW('','C');
} else if ( ! (_ChkObl('FKIUXYFTAY',1))) {
_SignErr('FKIUXYFTAY');
m_cLastWorkVarErrorMsg='TIPO';
l_bResult=false;
w_TIPO=HtW('','C');
} else if ( ! (_ChkObl('CXKIEWTPXM',1))) {
_SignErr('CXKIEWTPXM');
m_cLastWorkVarErrorMsg='RFREQ';
l_bResult=false;
w_RFREQ=HtW('','N');
} else if ( ! (_ChkObl('AKGZOBFEHJ',1))) {
_SignErr('AKGZOBFEHJ');
m_cLastWorkVarErrorMsg='1310320066';
l_bResult=false;
w_RAREA=HtW('','N');
} else if ( ! (_ChkObl('PMYHCHZIWV',1))) {
_SignErr('PMYHCHZIWV');
m_cLastWorkVarErrorMsg='1701052417';
l_bResult=false;
w_RCOMP=HtW('','N');
} else if ( ! (_ChkObl('UFRMQEXWER',1))) {
_SignErr('UFRMQEXWER');
m_cLastWorkVarErrorMsg='1701052417';
l_bResult=false;
w_RRAGIO=HtW('','N');
} else if ( ! (_ChkObl('HJNXGLDJPH',1))) {
_SignErr('HJNXGLDJPH');
m_cLastWorkVarErrorMsg='1701044225';
l_bResult=false;
w_RTIPO=HtW('','N');
} else if ( ! (_ChkObl('EZKIGVHOME',1))) {
_SignErr('EZKIGVHOME');
m_cLastWorkVarErrorMsg='RIMP';
l_bResult=false;
w_RIMP=HtW('','N');
} else if ( ! (_ChkObl('HMBPBMNNSQ',1))) {
_SignErr('HMBPBMNNSQ');
m_cLastWorkVarErrorMsg='1991862041';
l_bResult=false;
w_AMMONT=HtW('','C');
} else if ( ! (_ChkObl('XJFWPDTBUT',1))) {
_SignErr('XJFWPDTBUT');
m_cLastWorkVarErrorMsg='DURAT';
l_bResult=false;
w_DURAT=HtW('','C');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('QGVSOMWQKO_ZOOM',lc)) {
return 0;
}
if (Eq('QGVSOMWQKO',lc)) {
return 0;
}
if (Eq('MUJANTNTBM_ZOOM',lc)) {
return 1;
}
if (Eq('MUJANTNTBM',lc)) {
return 1;
}
if (Eq('HEAYXIPDHR_ZOOM',lc)) {
return 2;
}
if (Eq('HEAYXIPDHR',lc)) {
return 2;
}
if (Eq('BCFQRQNZJM_ZOOM',lc)) {
return 3;
}
if (Eq('BCFQRQNZJM',lc)) {
return 3;
}
if (Eq('FKIUXYFTAY_ZOOM',lc)) {
return 4;
}
if (Eq('FKIUXYFTAY',lc)) {
return 4;
}
if (Eq('HMBPBMNNSQ_ZOOM',lc)) {
return 5;
}
if (Eq('HMBPBMNNSQ',lc)) {
return 5;
}
if (Eq('XJFWPDTBUT_ZOOM',lc)) {
return 6;
}
if (Eq('XJFWPDTBUT',lc)) {
return 6;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_QGVSOMWQKO();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_MUJANTNTBM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_HEAYXIPDHR();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,3)) {
l_oWv=LOpt_BCFQRQNZJM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,4)) {
l_oWv=LOpt_FKIUXYFTAY();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,5)) {
l_oWv=LOpt_HMBPBMNNSQ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,6)) {
l_oWv=LOpt_XJFWPDTBUT();
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
l_oWv.setValue('OPERAG',WtA(w_OPERAG,'C'));
l_oWv.setValue('RESPINS',WtA(w_RESPINS,'C'));
l_oWv.setValue('INFORM',WtA(w_INFORM,'C'));
l_oWv.setValue('xdescrag',WtA(w_xdescrag,'C'));
l_oWv.setValue('xmodsvol',WtA(w_xmodsvol,'C'));
l_oWv.setValue('xareegeog',WtA(w_xareegeog,'C'));
l_oWv.setValue('xdescopeage',WtA(w_xdescopeage,'C'));
l_oWv.setValue('NOPROT',WtA(w_NOPROT,'N'));
l_oWv.setValue('IDBASE',WtA(w_IDBASE,'C'));
l_oWv.setValue('RAGIO',WtA(w_RAGIO,'C'));
l_oWv.setValue('MODSVOL',WtA(w_MODSVOL,'C'));
l_oWv.setValue('AREAGEO',WtA(w_AREAGEO,'C'));
l_oWv.setValue('NATURA',WtA(w_NATURA,'C'));
l_oWv.setValue('SCOPO',WtA(w_SCOPO,'C'));
l_oWv.setValue('TIPO',WtA(w_TIPO,'C'));
l_oWv.setValue('xdesctipor',WtA(w_xdesctipor,'C'));
l_oWv.setValue('RFREQ',WtA(w_RFREQ,'N'));
l_oWv.setValue('RAREA',WtA(w_RAREA,'N'));
l_oWv.setValue('RCOMP',WtA(w_RCOMP,'N'));
l_oWv.setValue('RRAGIO',WtA(w_RRAGIO,'N'));
l_oWv.setValue('RTIPO',WtA(w_RTIPO,'N'));
l_oWv.setValue('RIMP',WtA(w_RIMP,'N'));
l_oWv.setValue('AMMONT',WtA(w_AMMONT,'C'));
l_oWv.setValue('DURAT',WtA(w_DURAT,'C'));
l_oWv.setValue('xdurat',WtA(w_xdurat,'C'));
l_oWv.setValue('xammont',WtA(w_xammont,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["OPERAG","RESPINS","INFORM","xdescrag","xmodsvol","xareegeog","xdescopeage","NOPROT","IDBASE","RAGIO","MODSVOL","AREAGEO","NATURA","SCOPO","TIPO","xdesctipor","RFREQ","RAREA","RCOMP","RRAGIO","RTIPO","RIMP","AMMONT","DURAT","xdurat","xammont"];
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
if (Empty(w_OPERAG) && Ne(opener.w_OPERAG,null)) {
TransferBetweenWindows(opener,'w_OPERAG',null,'Set_OPERAG');
}
if (Empty(w_RESPINS) && Ne(opener.w_RESPINS,null)) {
TransferBetweenWindows(opener,'w_RESPINS',null,'Set_RESPINS');
}
if (Empty(w_INFORM) && Ne(opener.w_INFORM,null)) {
TransferBetweenWindows(opener,'w_INFORM',null,'Set_INFORM');
}
if (Eq(w_NOPROT,0) && Ne(opener.w_NOPROT,null)) {
TransferBetweenWindows(opener,'w_NOPROT',null,'Set_NOPROT');
}
if (Empty(w_IDBASE) && Ne(opener.w_IDBASE,null)) {
TransferBetweenWindows(opener,'w_IDBASE','w_IDBASE');
}
if (Empty(w_RAGIO) && Ne(opener.w_RAGIO,null)) {
TransferBetweenWindows(opener,'w_RAGIO',null,'Set_RAGIO');
}
if (Empty(w_MODSVOL) && Ne(opener.w_MODSVOL,null)) {
TransferBetweenWindows(opener,'w_MODSVOL',null,'Set_MODSVOL');
}
if (Empty(w_AREAGEO) && Ne(opener.w_AREAGEO,null)) {
TransferBetweenWindows(opener,'w_AREAGEO',null,'Set_AREAGEO');
}
if (Empty(w_NATURA) && Ne(opener.w_NATURA,null)) {
TransferBetweenWindows(opener,'w_NATURA',null,'Set_NATURA');
}
if (Empty(w_SCOPO) && Ne(opener.w_SCOPO,null)) {
TransferBetweenWindows(opener,'w_SCOPO',null,'Set_SCOPO');
}
if (Empty(w_TIPO) && Ne(opener.w_TIPO,null)) {
TransferBetweenWindows(opener,'w_TIPO',null,'Set_TIPO');
}
if (Empty(w_RFREQ) && Ne(opener.w_RFREQ,null)) {
TransferBetweenWindows(opener,'w_RFREQ',null,'Set_RFREQ');
}
if (Empty(w_RAREA) && Ne(opener.w_RAREA,null)) {
TransferBetweenWindows(opener,'w_RAREA',null,'Set_RAREA');
}
if (Empty(w_RCOMP) && Ne(opener.w_RCOMP,null)) {
TransferBetweenWindows(opener,'w_RCOMP',null,'Set_RCOMP');
}
if (Empty(w_RRAGIO) && Ne(opener.w_RRAGIO,null)) {
TransferBetweenWindows(opener,'w_RRAGIO',null,'Set_RRAGIO');
}
if (Empty(w_RTIPO) && Ne(opener.w_RTIPO,null)) {
TransferBetweenWindows(opener,'w_RTIPO',null,'Set_RTIPO');
}
if (Empty(w_RIMP) && Ne(opener.w_RIMP,null)) {
TransferBetweenWindows(opener,'w_RIMP',null,'Set_RIMP');
}
if (Empty(w_AMMONT) && Ne(opener.w_AMMONT,null)) {
TransferBetweenWindows(opener,'w_AMMONT',null,'Set_AMMONT');
}
if (Empty(w_DURAT) && Ne(opener.w_DURAT,null)) {
TransferBetweenWindows(opener,'w_DURAT',null,'Set_DURAT');
}
}
}
m_bCalculating=true;
Link_QGVSOMWQKO(null);
if (start && Eq(At(',NOPROT,',pseq),0)) {
w_NOPROT=0;
}
Link_MUJANTNTBM(null);
Link_HEAYXIPDHR(null);
Link_BCFQRQNZJM(null);
Link_FKIUXYFTAY(null);
Link_HMBPBMNNSQ(null);
Link_XJFWPDTBUT(null);
Link_ZXAGFQXBRH(null);
Link_UVOSMLOZGD(null);
Link_UUIMACOHVM(null);
Link_JSRWGYXWUP(null);
Link_OXGJIOYQVA(null);
Link_ZBLNCBPFUK(null);
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
_Obli('OPERAG',0,'QGVSOMWQKO',false)
_Obli('RESPINS',0,'VXNCZZQUTU',false)
_Obli('INFORM',0,'UHKTWUYPMH',false)
_Obli('AREAGEO',0,'BCFQRQNZJM',false)
_Obli('AREAGEO',0,'JSRWGYXWUP',false)
_Obli('SCOPO',0,'MJXJDMQQRI',false)
_Obli('AMMONT',0,'HMBPBMNNSQ',false,"1991862041")
_Obli('AMMONT',0,'OXGJIOYQVA',false,"1991862041")
_Obli('RIMP',1,'EZKIGVHOME',false)
_Obli('NOPROT',1,'XQEWDORSRU',false)
_Obli('TIPO',0,'FKIUXYFTAY',false)
_Obli('TIPO',0,'ZXAGFQXBRH',false)
_Obli('RAGIO',0,'MUJANTNTBM',false)
_Obli('RAGIO',0,'UVOSMLOZGD',false)
_Obli('MODSVOL',0,'HEAYXIPDHR',false,"11158852142")
_Obli('MODSVOL',0,'UUIMACOHVM',false,"11158852142")
_Obli('DURAT',0,'XJFWPDTBUT',false)
_Obli('DURAT',0,'ZBLNCBPFUK',false)
_Obli('NATURA',0,'TMQBHKYHRS',false)
_Obli('RFREQ',1,'CXKIEWTPXM',false)
_Obli('RAREA',1,'AKGZOBFEHJ',false,"1310320066")
_Obli('RTIPO',1,'HJNXGLDJPH',false,"1701044225")
_Obli('RRAGIO',1,'UFRMQEXWER',false,"1701052417")
_Obli('RCOMP',1,'PMYHCHZIWV',false,"1701052417")
