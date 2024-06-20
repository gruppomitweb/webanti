function SetControlsValue() {
var c;
if(c=Ctrl('WJSVGWKSFC')) c.value = WtH(w_CODINTER,'C',11,0,'')
if(c=Ctrl('AVHTGZTOSZ')) c.value = WtH(w_CODDIPE,'C',6,0,'')
if(c=Ctrl('UMFEJVRUFZ')) c.value = WtH(w_RAPPORTO,'C',25,0,'')
if(c=Ctrl('YLIKFVPZJA')) c.value = WtH(w_DATAOPE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('SWRTSKXMDH')) selectCombo(c,w_TIPOOPRAP,'C')
if(c=Ctrl('FTYILIQWQK')) c.value = WtH(w_STATOREG,'C',1,0,'')
if(c=Ctrl('RLUMBFHPUD')) c.value = WtH(w_DESCCIT,'C',30,0,'')
if(c=Ctrl('OJGQABFSYN')) c.value = WtH(w_PROVINCIA,'C',2,0,'')
if(c=Ctrl('OZEOCQRSEQ')) c.value = WtH(w_CODCAB,'C',6,0,'')
var tmp_BLXOBUQVYE = ToHTag(AsControlValue(w_xDescDipe));
if (Ne(e_BLXOBUQVYE,tmp_BLXOBUQVYE)) {
if(c=Ctrl('BLXOBUQVYE')) c.innerHTML=tmp_BLXOBUQVYE;
e_BLXOBUQVYE=tmp_BLXOBUQVYE;
}
if(c=Ctrl('XYMCLUECBD')) c.value = WtH(w_NUMPROG,'C',11,0,'')
var tmp_XXRYVYIIGY = ToHTag(AsControlValue(w_xdescrap));
if (Ne(e_XXRYVYIIGY,tmp_XXRYVYIIGY)) {
if(c=Ctrl('XXRYVYIIGY')) c.innerHTML=tmp_XXRYVYIIGY;
e_XXRYVYIIGY=tmp_XXRYVYIIGY;
}
if(c=Ctrl('TQTBMAXOZP')) c.value = WtH(w_CODINTER,'C',11,0,'')
if(c=Ctrl('MMJUUBVOXU')) c.value = WtH(w_DESCCIT,'C',30,0,'')
if(c=Ctrl('RPVZSKBMLW')) c.value = WtH(w_PROVINCIA,'C',2,0,'')
if(c=Ctrl('WDTMWXLMPB')) c.value = WtH(w_CODCAB,'C',6,0,'')
var tmp_OHBJKANXZH = ToHTag(AsControlValue(w_xDescDipe));
if (Ne(e_OHBJKANXZH,tmp_OHBJKANXZH)) {
if(c=Ctrl('OHBJKANXZH')) c.innerHTML=tmp_OHBJKANXZH;
e_OHBJKANXZH=tmp_OHBJKANXZH;
}
var tmp_ABCLQJCBCR = ToHTag(AsControlValue(w_RAPPORTO+'- '+w_xdescrap));
if (Ne(e_ABCLQJCBCR,tmp_ABCLQJCBCR)) {
if(c=Ctrl('ABCLQJCBCR')) c.innerHTML=tmp_ABCLQJCBCR;
e_ABCLQJCBCR=tmp_ABCLQJCBCR;
}
if(c=Ctrl('BILHYLSMRS')) c.value = WtH(w_CODDIPE,'C',6,0,'')
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
h=Gt(w_DATAOPE,CharToDate('20100531')) || IsHiddenByStateDriver(tabs.GetTabstripID('page_2'));
SetDisplay(tabs.GetTabstripID('page_2'),h);
if (h && (tabs.IsExpanded('page_2'))) {
tabs.Next() || tabs.Prev();
}
SetDisplay(Ctrl('FTYILIQWQK'),Eq(1,1) || IsHiddenByStateDriver('STATOREG'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["CODCAB"]=['ENBRMMDVUP','IWNONYEAAB'];
HideUI.lblids["CODDIPE"]=['XVRJYSKGWZ','NXNHXKZHDU'];
HideUI.lblids["CODINTER"]=['ASXPAXYMTW','LOEAMXUYLA'];
HideUI.lblids["DATAOPE"]=['HVHVAYPDJE'];
HideUI.lblids["DESCCIT"]=['JOVDRMQUVQ','CTLYJMTHDV'];
HideUI.lblids["NUMPROG"]=['KDUGHGZUUG'];
HideUI.lblids["PROVINCIA"]=['JWSDOSRGAG','TLOTQEDJQB'];
HideUI.lblids["RAPPORTO"]=['WDSMYOZLJE'];
HideUI.lblids["TIPOOPRAP"]=['BYKQMDEEAQ'];
function AVHTGZTOSZ_Valid(e) {
SetActiveField(Ctrl('AVHTGZTOSZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODDIPE','C',w_CODDIPE,HtW(Ctrl('AVHTGZTOSZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODDIPE(HtW(Ctrl('AVHTGZTOSZ').value,'C'),null,e);
return l_bSetResult;
}
}
function AVHTGZTOSZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AVHTGZTOSZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('AVHTGZTOSZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AVHTGZTOSZ'),e);
}
function AVHTGZTOSZ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index(Ctrl('AVHTGZTOSZ'))),'linkview_AVHTGZTOSZ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function UMFEJVRUFZ_Valid(e) {
SetActiveField(Ctrl('UMFEJVRUFZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RAPPORTO','C',w_RAPPORTO,HtW(Ctrl('UMFEJVRUFZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAPPORTO(HtW(Ctrl('UMFEJVRUFZ').value,'C'),null,e);
return l_bSetResult;
}
}
function UMFEJVRUFZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UMFEJVRUFZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UMFEJVRUFZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UMFEJVRUFZ'),e);
}
function UMFEJVRUFZ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index(Ctrl('UMFEJVRUFZ'))),'linkview_UMFEJVRUFZ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function YLIKFVPZJA_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('YLIKFVPZJA'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('YLIKFVPZJA').value=ApplyPictureToDate(Ctrl('YLIKFVPZJA').value,TranslatePicture(datePattern),'YLIKFVPZJA');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('YLIKFVPZJA'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('YLIKFVPZJA');
}
}
}
SetActiveField(Ctrl('YLIKFVPZJA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAOPE','D',w_DATAOPE,HtW(Ctrl('YLIKFVPZJA').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAOPE(HtW(Ctrl('YLIKFVPZJA').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function YLIKFVPZJA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YLIKFVPZJA'))) {
DisplayErrorMessage();
}
if ( ! (GetDisabled('YLIKFVPZJA'))) {
if (Eq(w_DATAOPE,NullDate()) && Eq(_tracker.ctrl,null)) {
Ctrl('YLIKFVPZJA').value=WtH(SystemDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
} else {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('YLIKFVPZJA').value=WtH(w_DATAOPE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
}
m_oEnteredInDate=Ctrl('YLIKFVPZJA');
SetActiveField(Ctrl('YLIKFVPZJA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YLIKFVPZJA'),e);
}
function SWRTSKXMDH_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOOPRAP','C',w_TIPOOPRAP,HtW(getComboValue(Ctrl('SWRTSKXMDH')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOOPRAP(HtW(getComboValue(Ctrl('SWRTSKXMDH')),'C'),null,e);
return l_bSetResult;
}
}
function SWRTSKXMDH_OnFocus(e) {
SetActiveField(Ctrl('SWRTSKXMDH'),true);
}
function SWRTSKXMDH_OnBlur(e) {
SetActiveField(Ctrl('SWRTSKXMDH'),false);
}
function FTYILIQWQK_Valid(e) {
SetActiveField(Ctrl('FTYILIQWQK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('STATOREG','C',w_STATOREG,HtW(Ctrl('FTYILIQWQK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_STATOREG(HtW(Ctrl('FTYILIQWQK').value,'C'),null,e);
return l_bSetResult;
}
}
function FTYILIQWQK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FTYILIQWQK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FTYILIQWQK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FTYILIQWQK'),e);
}
linkpc_url.u('TXFLNDGZME',function(){return 'ardt_ae_intestbo?m_bInnerChild=true'+GetLinkPCKeys('ardt_ae_intestbo')+'&m_bRowsChild='+EnableChild('ardt_ae_intestbo')})
linkpc_url.u('SYICQKNLUB',function(){return 'ardt_ae_delegabo?m_bInnerChild=true'+GetLinkPCKeys('ardt_ae_delegabo')+'&m_bRowsChild='+EnableChild('ardt_ae_delegabo')})
linkpc_url.u('IXHEMDOSUG',function(){return 'ardt_ae_soginfo?m_bInnerChild=true'+GetLinkPCKeys('ardt_ae_soginfo')+'&m_bRowsChild='+EnableChild('ardt_ae_soginfo')})
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('AVHTGZTOSZ')) c.onblur=AVHTGZTOSZ_Valid;
if(c=Ctrl('AVHTGZTOSZ')) c.onfocus=AVHTGZTOSZ_OnFocus;
if(c=Ctrl('UMFEJVRUFZ')) c.onblur=UMFEJVRUFZ_Valid;
if(c=Ctrl('UMFEJVRUFZ')) c.onfocus=UMFEJVRUFZ_OnFocus;
if(c=Ctrl('YLIKFVPZJA')) c.onblur=YLIKFVPZJA_Valid;
if(c=Ctrl('YLIKFVPZJA')) c.onfocus=YLIKFVPZJA_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('YLIKFVPZJA')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('SWRTSKXMDH')) c.onchange=SWRTSKXMDH_Valid;
if(c=Ctrl('SWRTSKXMDH')) c.onfocus=SWRTSKXMDH_OnFocus;
if(c=Ctrl('SWRTSKXMDH')) c.onblur=SWRTSKXMDH_OnBlur;
if(c=Ctrl('FTYILIQWQK')) c.onblur=FTYILIQWQK_Valid;
if(c=Ctrl('FTYILIQWQK')) c.onfocus=FTYILIQWQK_OnFocus;
if (m_bExtended) {
SetEventsAndStylesToExtendedFields();
}
}
if (Eq(m_cFunction,'query') && Ne(document.FrmToolbar,null)) {
document.FrmToolbar.pos.onkeypress=RecPositionInput;
document.FrmToolbar.pos.onblur=SelectRecord;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
}
function SetLastFocusedOnParent() {
// used only in child entities
}
function DoUpdate(p_bResult) {
if (Ne(m_cFunction,'query') && Ne(m_cFunction,'view')) {
Calculate();
SaveDependsOn();
SetControlsValue();
SetDynamicClasses();
SetDynamicTooltip();
EnableControlsUnderCondition();
SaveLabelDependsOn();
}
if ( ! (p_bResult)) {
DisplayErrorMessage();
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.edit={"page_1":["AVHTGZTOSZ"]};
FocusFirstComponent.query={"page_1":["AVHTGZTOSZ"]};
FocusFirstComponent.otherwise={"page_1":["AVHTGZTOSZ"]};
function Help() {
windowOpenForeground('../doc/armt_ae_rapopebo_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_ardt_ae_intestbo() {
SetModified();
}
function SetModified_ardt_ae_delegabo() {
SetModified();
}
function SetModified_ardt_ae_soginfo() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_1')) {
if (ChildToLoad('TXFLNDGZME')) {
LoadContext.lc(1,'TXFLNDGZME');
} else {
LibJavascript.RefreshChildGrid('TXFLNDGZME');
}
}
if (Eq(page,'page_1')) {
if (ChildToLoad('SYICQKNLUB')) {
LoadContext.lc(1,'SYICQKNLUB');
} else {
LibJavascript.RefreshChildGrid('SYICQKNLUB');
}
}
if (Eq(page,'page_2')) {
if (ChildToLoad('IXHEMDOSUG')) {
LoadContext.lc(1,'IXHEMDOSUG');
} else {
LibJavascript.RefreshChildGrid('IXHEMDOSUG');
}
}
}
function DeclareWVs() {
var a = arguments;
w_CODINTER=a[0];
w_CODDIPE=a[1];
w_RAPPORTO=a[2];
w_DATAOPE=a[3];
w_DATAREG=a[4];
w_TIPOOPRAP=a[5];
w_CONNESOPER=a[6];
w_TIPOLEG=a[7];
w_DATARETT=a[8];
w_IDBASE=a[9];
op_IDBASE=a[10];
w_TIPOINTER=a[11];
w_TIPOINF=a[12];
w_IDEREG=a[13];
w_FLAGRAP=a[14];
w_OPRAP=a[15];
w_STATOREG=a[16];
w_OPERAZMOD=a[17];
w_OPERATORE=a[18];
w_AUTOM=a[19];
w_DESCCIT=a[20];
w_PROVINCIA=a[21];
w_CODCAB=a[22];
w_NUMPROG=a[23];
op_NUMPROG=a[24];
w_FLAGRAP2=a[25];
w_FLAGLIRE=a[26];
w_PRGIMPINF=a[27];
op_PRGIMPINF=a[28];
w_CDATOPE=a[29];
w_gIntemediario=a[30];
w_xdescrap=a[31];
w_xDescDipe=a[32];
w_datpaseuro=a[33];
w_contdate=a[34];
w_xDesReg=a[35];
w_tipreg=a[36];
w_xRagSoc=a[37];
w_sEdit=a[38];
w_errmsg=a[39];
w_Aggiorna=a[40];
w_lancio=a[41];
w_VALUTA=a[42];
w_tipregn=a[43];
w_dataoggi=a[44];
w_CITINT=a[45];
w_CITDIP=a[46];
w_PROVDIP=a[47];
w_CABDIP=a[48];
w_PROVINT=a[49];
w_CABINT=a[50];
op_codazi=a[51];
m_cWv_ardt_ae_intestbo=a[52];
m_cWv_ardt_ae_delegabo=a[53];
m_cWv_ardt_ae_soginfo=a[54];
if (Gt(a.length,55)) {
m_cErrorInChild='';
}
if (Gt(a.length,55)) {
o_CODINTER=w_CODINTER;
o_CODDIPE=w_CODDIPE;
o_DATAOPE=w_DATAOPE;
o_CONNESOPER=w_CONNESOPER;
o_TIPOLEG=w_TIPOLEG;
}
m_PrimaryKeys=['IDBASE'];
}
function i_PrimaryKey() {
return 'japopebo'+'\\'+CPLib.ToCPStr(w_IDBASE);
}
GetLinkPCKeys.set_o('ardt_ae_intestbo',false);
GetLinkPCKeys.set_o('ardt_ae_delegabo',false);
GetLinkPCKeys.set_o('ardt_ae_soginfo',false);
GetLinkPCKeys.o['ardt_ae_intestbo']['RAPPORTO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_RAPPORTO,'C');
}
}
GetLinkPCKeys.o['ardt_ae_delegabo']['RAPPORTO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_RAPPORTO,'C');
}
}
GetLinkPCKeys.o['ardt_ae_soginfo']['RAPCOL']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_RAPPORTO,'C');
}
}
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('TXFLNDGZME',function(){return FrameRef('ardt_ae_intestbo')},1,'ardt_ae_intestbo',1,1)
LoadContext.f('SYICQKNLUB',function(){return FrameRef('ardt_ae_delegabo')},1,'ardt_ae_delegabo',1,1)
LoadContext.f('IXHEMDOSUG',function(){return FrameRef('ardt_ae_soginfo')},1,'ardt_ae_soginfo',1,2)
GetSelectedChildPage.child={'ardt_ae_intestbo': function(){return FrameRef('ardt_ae_intestbo')}, 'ardt_ae_delegabo': function(){return FrameRef('ardt_ae_delegabo')}, 'ardt_ae_soginfo': function(){return FrameRef('ardt_ae_soginfo')}}
function GetSelectedPage(p_d) {
p_d.setValue('armt_ae_rapopebo',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
_Obli('TIPOOPRAP',0,'SWRTSKXMDH',true,"684190680",'SWRTSKXMDH')
_Obli('RAPPORTO',0,'UMFEJVRUFZ',false)
_Obli('CODDIPE',0,'AVHTGZTOSZ',false,"2071283709")
_Obli('CODDIPE',0,'BILHYLSMRS',false,"2071283709")
_Obli('DATAOPE',2,'YLIKFVPZJA',true,"829201110")
_Obli('STATOREG',0,'FTYILIQWQK',false,"11258238247")
