function FillCombosValues() {
FillCombo('INPSVTNSOS','INPSVTNSOS');
FillCombo('HSMPABEPMD','HSMPABEPMD');
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('JVZQIVEGBJ',function(){return WtH(w_CODINTER,'C',11,0,'')},w_CODINTER);
SPBOUILib.SetInputValue('XSIPBNXGHK',function(){return WtH(w_CODDIPE,'C',6,0,'')},w_CODDIPE);
SPBOUILib.SetInputValue('GTGZXUQXTV',function(){return WtH(w_DESCCIT,'C',30,0,'')},w_DESCCIT);
SPBOUILib.SetInputValue('YYEANTLIIE',function(){return WtH(w_PROVINCIA,'C',2,0,'')},w_PROVINCIA);
SPBOUILib.SetInputValue('VDKKUGUMEB',function(){return WtH(w_CODCAB,'C',6,0,'')},w_CODCAB);
var tmp_RUHPTHZWPU = ToHTag(AsControlValue(w_xDescDipe));
if (Ne(e_RUHPTHZWPU,tmp_RUHPTHZWPU)) {
SPBOUILib.SetLabelValue('RUHPTHZWPU','innerHTML',tmp_RUHPTHZWPU);
e_RUHPTHZWPU=tmp_RUHPTHZWPU;
}
SPBOUILib.SetInputValue('ROFCOTWPXY',function(){return WtH(w_RAPPORTO,'C',25,0,'@!')},w_RAPPORTO);
SPBOUILib.SetInputValue('OHLAYQXDKA',function(){return WtH(w_DATAOPE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAOPE);
SPBOUILib.SetInputValue('SNCWUQDNDY',function(){return WtH(w_DATAREG,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAREG);
if(c=Ctrl('INPSVTNSOS')) selectCombo(c,w_TIPOOPRAP,'C')
SPBOUILib.SetInputValue('RYTLUFEGUP',function(){return WtH(w_CONNESOPER,'C',16,0,'')},w_CONNESOPER);
if(c=Ctrl('HSMPABEPMD')) selectCombo(c,w_TIPOLEG,'C')
SPBOUILib.SetInputValue('KRPGPQZJIR',function(){return WtH(w_NUMPROG,'C',11,0,'')},w_NUMPROG);
var tmp_ROEEFYEJBO = ToHTag(AsControlValue(w_xdescrap));
if (Ne(e_ROEEFYEJBO,tmp_ROEEFYEJBO)) {
SPBOUILib.SetLabelValue('ROEEFYEJBO','innerHTML',tmp_ROEEFYEJBO);
e_ROEEFYEJBO=tmp_ROEEFYEJBO;
}
var tmp_VKQGQAJPMH = ToHTag(AsControlValue('Tipo Legame Sogg.:'));
if (Ne(e_VKQGQAJPMH,tmp_VKQGQAJPMH)) {
SPBOUILib.SetLabelValue('VKQGQAJPMH','innerHTML',tmp_VKQGQAJPMH);
e_VKQGQAJPMH=tmp_VKQGQAJPMH;
}
var tmp_PLNAAWAXXR = ToHTag(AsControlValue((Lt(w_DATAOPE,CharToDate('20100601'))?'Soggetto Agente x conto:':(Gt(w_DATAOPE,CharToDate('20131231'))?'Esecutore:':''))));
if (Ne(e_PLNAAWAXXR,tmp_PLNAAWAXXR)) {
SPBOUILib.SetLabelValue('PLNAAWAXXR','innerHTML',tmp_PLNAAWAXXR);
e_PLNAAWAXXR=tmp_PLNAAWAXXR;
}
var tmp_ARLCJESUHN = ToHTag(AsControlValue(w_xRagSoc));
if (Ne(e_ARLCJESUHN,tmp_ARLCJESUHN)) {
SPBOUILib.SetLabelValue('ARLCJESUHN','innerHTML',tmp_ARLCJESUHN);
e_ARLCJESUHN=tmp_ARLCJESUHN;
}
SPBOUILib.SetInputValue('KHYCSRMDGJ',function(){return WtH(w_IDEREG,'C',20,0,'')},w_IDEREG);
var tmp_VODVVAXWLX = ToHTag(AsControlValue(w_xDescDipe));
if (Ne(e_VODVVAXWLX,tmp_VODVVAXWLX)) {
SPBOUILib.SetLabelValue('VODVVAXWLX','innerHTML',tmp_VODVVAXWLX);
e_VODVVAXWLX=tmp_VODVVAXWLX;
}
SPBOUILib.SetInputValue('ZTXEUOXXIE',function(){return WtH(w_CODINTER,'C',11,0,'')},w_CODINTER);
SPBOUILib.SetInputValue('BRGHYFSDHY',function(){return WtH(w_CODDIPE,'C',6,0,'')},w_CODDIPE);
SPBOUILib.SetInputValue('PZJOZFRYQW',function(){return WtH(w_DESCCIT,'C',30,0,'')},w_DESCCIT);
SPBOUILib.SetInputValue('WBNNXNUZER',function(){return WtH(w_PROVINCIA,'C',2,0,'')},w_PROVINCIA);
SPBOUILib.SetInputValue('BCBQLPOXMG',function(){return WtH(w_CODCAB,'C',6,0,'')},w_CODCAB);
if(c=Ctrl('WKYJJJVZEF')) ChkboxCheckUncheck(c,1,w_FLAGTIT)
if(c=Ctrl('WKYJJJVZEF')) ChkboxValueAssign(c,1,0,'N',1,0,'')
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
h=Gt(w_DATAOPE,CharToDate('20100531')) && Lt(w_DATAOPE,CharToDate('20140101')) || IsHiddenByStateDriver(Z.Tabs.Get('tabs').GetTabstripID('page_2'));
SetDisplay(Z.Tabs.Get('tabs').GetTabstripID('page_2'),h);
if (h && (Z.Tabs.Get('tabs').IsExpanded('page_2'))) {
Z.Tabs.Get('tabs').Next() || Z.Tabs.Get('tabs').Prev();
}
SetDisplay('KTBKPUIVLZ_DIV',IsHiddenByStateDriver('Intermediario'));
SetDisplay('MMRLCYYISA_DIV',IsHiddenByStateDriver('DATIBASE'));
Z.Tabs.Get("tabs_1_DETTAGLIO").Hide('WMBIUHHCFT',IsHiddenByStateDriver('INTESTATARI'));
Z.Tabs.Get("tabs_1_DETTAGLIO").Hide('BJHZWDCHTX',IsHiddenByStateDriver('DELEGATI'));
SetDisplay(Ctrl('RYTLUFEGUP'),arfn_view_soct(w_DATAOPE,w_TIPOOPRAP,'V') || IsHiddenByStateDriver('CONNESOPER'));
SetDisplay(Ctrl('RYTLUFEGUP_ZOOM'),arfn_view_soct(w_DATAOPE,w_TIPOOPRAP,'V'));
SetDisplay(Ctrl('HSMPABEPMD'),arfn_view_soct(w_DATAOPE,w_TIPOOPRAP,'T') || IsHiddenByStateDriver('TIPOLEG'));
SetDisplay(Ctrl('VKQGQAJPMH'),arfn_view_soct(w_DATAOPE,w_TIPOOPRAP,'T'));
SetDisplay(Ctrl('PLNAAWAXXR'),arfn_view_soct(w_DATAOPE,w_TIPOOPRAP,'V'));
SetDisplay(Ctrl('ARLCJESUHN'),arfn_view_soct(w_DATAOPE,w_TIPOOPRAP,'V'));
SetDisplay(Ctrl('LPCLBCMYBE'), ! (Empty(LRTrim(w_xRagSoc))) || Empty(w_CONNESOPER));
Z.Tabs.Get("tabs_2_Altri").Hide('ZXKFTKZCJE',IsHiddenByStateDriver('ALTRISOGG'));
Z.Tabs.Get("tabs_2_Altri").Hide('EGKLPQESRU',Lt(w_DATAOPE,CharToDate('20230101')) || IsHiddenByStateDriver('TITOLARI'));
Z.Tabs.Get("tabs_2_Altri").Hide('LTJVEGZAIT',Lt(w_DATAOPE,CharToDate('20140101')) || IsHiddenByStateDriver('FIDUCIANTI'));
SetDisplay('YCTBVNLZSK_DIV',IsHiddenByStateDriver('Intermediario'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["CODCAB"]=['ZWATUBQOIB','PMDOWBVORJ'];
HideUI.lblids["CODDIPE"]=['TGFGXLNJGM','XGVTUHQDRX'];
HideUI.lblids["CODINTER"]=['AXLBHWEBRA','VJHGEJLSKM'];
HideUI.lblids["CONNESOPER"]=['PLNAAWAXXR'];
HideUI.lblids["DATAOPE"]=['XVSGAMCJTW'];
HideUI.lblids["DATAREG"]=['ZMONPCZVBO'];
HideUI.lblids["DESCCIT"]=['KKTFFUWQXX','DPYJDBXPUD'];
HideUI.lblids["IDEREG"]=['NOCRBBFOUY'];
HideUI.lblids["NUMPROG"]=['WOEAIUGKOM'];
HideUI.lblids["PROVINCIA"]=['IRVPTXCSTC','ATZABYJTFS'];
HideUI.lblids["RAPPORTO"]=['LVDWSCCIIN'];
HideUI.lblids["TIPOLEG"]=['VKQGQAJPMH'];
HideUI.lblids["TIPOOPRAP"]=['LVOYMIPKXE'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
cond=Eq(At(w_TIPOOPRAP,'|25|28|39|40|41|47'),0) &&  ! (Empty(w_TIPOOPRAP));
if (Ne(o_WMBIUHHCFT_expand,cond)) {
if (cond) {
Z.Tabs.Get("tabs_1_DETTAGLIO").Expand('WMBIUHHCFT');
}
o_WMBIUHHCFT_expand=cond;
}
cond=Gt(At(w_TIPOOPRAP,'|25|28|39|40|41|47'),0) || Empty(w_TIPOOPRAP);
if (Ne(o_WMBIUHHCFT_collapse,cond)) {
if (cond) {
Z.Tabs.Get("tabs_1_DETTAGLIO").Collapse('WMBIUHHCFT');
}
o_WMBIUHHCFT_collapse=cond;
}
cond=Gt(At(w_TIPOOPRAP,'|25|28|39|40|41|47'),0) &&  ! (Empty(w_TIPOOPRAP));
if (Ne(o_BJHZWDCHTX_expand,cond)) {
if (cond) {
Z.Tabs.Get("tabs_1_DETTAGLIO").Expand('BJHZWDCHTX');
}
o_BJHZWDCHTX_expand=cond;
}
cond=Eq(At(w_TIPOOPRAP,'|25|28|39|40|41|47'),0) || Empty(w_TIPOOPRAP);
if (Ne(o_BJHZWDCHTX_collapse,cond)) {
if (cond) {
Z.Tabs.Get("tabs_1_DETTAGLIO").Collapse('BJHZWDCHTX');
}
o_BJHZWDCHTX_collapse=cond;
}
}
function XSIPBNXGHK_Valid(e) {
SetActiveField(Ctrl('XSIPBNXGHK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODDIPE','C',w_CODDIPE,HtW(Ctrl('XSIPBNXGHK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODDIPE(HtW(Ctrl('XSIPBNXGHK').value,'C'),null,e);
return l_bSetResult;
}
}
function XSIPBNXGHK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XSIPBNXGHK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XSIPBNXGHK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XSIPBNXGHK'),e);
}
function XSIPBNXGHK_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('XSIPBNXGHK')),'linkview_XSIPBNXGHK','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function ROFCOTWPXY_Valid(e) {
SetActiveField(Ctrl('ROFCOTWPXY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RAPPORTO','C',w_RAPPORTO,HtW(Ctrl('ROFCOTWPXY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAPPORTO(HtW(Ctrl('ROFCOTWPXY').value,'C'),null,e);
return l_bSetResult;
}
}
function ROFCOTWPXY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ROFCOTWPXY'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('ROFCOTWPXY',w_RAPPORTO,'C',25,0,'@!');
SetActiveField(Ctrl('ROFCOTWPXY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ROFCOTWPXY'),e);
}
function ROFCOTWPXY_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function ROFCOTWPXY_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('ROFCOTWPXY')),'linkview_ROFCOTWPXY','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function OHLAYQXDKA_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('OHLAYQXDKA'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('OHLAYQXDKA').value=ApplyPictureToDate(Ctrl('OHLAYQXDKA').value,TranslatePicture(datePattern),'OHLAYQXDKA');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('OHLAYQXDKA'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('OHLAYQXDKA');
}
}
}
SetActiveField(Ctrl('OHLAYQXDKA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAOPE','D',w_DATAOPE,HtW(Ctrl('OHLAYQXDKA').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAOPE(HtW(Ctrl('OHLAYQXDKA').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function OHLAYQXDKA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OHLAYQXDKA'))) {
DisplayErrorMessage();
}
if ( ! (GetDisabled('OHLAYQXDKA'))) {
if (Eq(w_DATAOPE,NullDate()) && Eq(_tracker.ctrl,null)) {
Ctrl('OHLAYQXDKA').value=WtH(SystemDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
} else {
if (Ne(_tracker.ctrl,Ctrl('OHLAYQXDKA'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('OHLAYQXDKA',w_DATAOPE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
}
}
m_oEnteredInDate=Ctrl('OHLAYQXDKA');
SetActiveField(Ctrl('OHLAYQXDKA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OHLAYQXDKA'),e);
}
function OHLAYQXDKA_ZOOM_Click() {
LaunchCalendar(Ctrl('OHLAYQXDKA'));
}
function SNCWUQDNDY_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('SNCWUQDNDY'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('SNCWUQDNDY').value=ApplyPictureToDate(Ctrl('SNCWUQDNDY').value,TranslatePicture(datePattern),'SNCWUQDNDY');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('SNCWUQDNDY'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('SNCWUQDNDY');
}
}
}
SetActiveField(Ctrl('SNCWUQDNDY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAREG','D',w_DATAREG,HtW(Ctrl('SNCWUQDNDY').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAREG(HtW(Ctrl('SNCWUQDNDY').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function SNCWUQDNDY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SNCWUQDNDY'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('SNCWUQDNDY'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('SNCWUQDNDY',w_DATAREG,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('SNCWUQDNDY');
SetActiveField(Ctrl('SNCWUQDNDY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SNCWUQDNDY'),e);
}
function SNCWUQDNDY_ZOOM_Click() {
LaunchCalendar(Ctrl('SNCWUQDNDY'));
}
function INPSVTNSOS_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOOPRAP','C',w_TIPOOPRAP,HtW(getComboValue(Ctrl('INPSVTNSOS')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOOPRAP(HtW(getComboValue(Ctrl('INPSVTNSOS')),'C'),null,e);
return l_bSetResult;
}
}
function INPSVTNSOS_OnFocus(e) {
SetActiveField(Ctrl('INPSVTNSOS'),true);
}
function INPSVTNSOS_OnBlur(e) {
SetActiveField(Ctrl('INPSVTNSOS'),false);
}
function RYTLUFEGUP_Valid(e) {
SetActiveField(Ctrl('RYTLUFEGUP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CONNESOPER','C',w_CONNESOPER,HtW(Ctrl('RYTLUFEGUP').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONNESOPER(HtW(Ctrl('RYTLUFEGUP').value,'C'),null,e);
return l_bSetResult;
}
}
function RYTLUFEGUP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RYTLUFEGUP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RYTLUFEGUP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RYTLUFEGUP'),e);
}
function RYTLUFEGUP_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('RYTLUFEGUP')),'linkview_RYTLUFEGUP','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function HSMPABEPMD_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOLEG','C',w_TIPOLEG,HtW(getComboValue(Ctrl('HSMPABEPMD')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOLEG(HtW(getComboValue(Ctrl('HSMPABEPMD')),'C'),null,e);
return l_bSetResult;
}
}
function HSMPABEPMD_OnFocus(e) {
SetActiveField(Ctrl('HSMPABEPMD'),true);
}
function HSMPABEPMD_OnBlur(e) {
SetActiveField(Ctrl('HSMPABEPMD'),false);
}
function WKYJJJVZEF_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLAGTIT','N',w_FLAGTIT,ChkboxValueAssign(Ctrl('WKYJJJVZEF'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLAGTIT(ChkboxValueAssign(Ctrl('WKYJJJVZEF'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function WKYJJJVZEF_OnFocus(e) {
SetActiveField(Ctrl('WKYJJJVZEF'),true);
}
function WKYJJJVZEF_OnBlur(e) {
SetActiveField(Ctrl('WKYJJJVZEF'),false);
}
linkpc_url.u('ZFLICMSKTV',function(){return 'ardt_provinformazioni?m_bInnerChild=true'+GetLinkPCKeys('ardt_provinformazioni')+'&m_bRowsChild='+EnableChild('ardt_provinformazioni')})
linkpc_url.u('RSWMQMMVEI',function(){return 'ardt_pdelegabo?m_bInnerChild=true'+GetLinkPCKeys('ardt_pdelegabo')+'&m_bRowsChild='+EnableChild('ardt_pdelegabo')})
linkpc_url.u('DUGPTCZBRI',function(){return 'ardt_provsoginfo?m_bInnerChild=true'+GetLinkPCKeys('ardt_provsoginfo')+'&m_bRowsChild='+EnableChild('ardt_provsoginfo')})
linkpc_url.u('WYSOGTWVYA',function(){return 'ardt_xiduciabo?m_bInnerChild=true'+GetLinkPCKeys('ardt_xiduciabo')+'&m_bRowsChild='+EnableChild('ardt_xiduciabo')})
linkpc_url.u('NOKYMTFBFL',function(){return 'ardt_xerzistirap?m_bInnerChild=true'+GetLinkPCKeys('ardt_xerzistirap')+'&m_bRowsChild='+EnableChild('ardt_xerzistirap')})
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function XSIPBNXGHK_wrap_Valid(event) {
return XSIPBNXGHK_Valid(event);
}
SPBOUILib.SetInputExit('XSIPBNXGHK',XSIPBNXGHK_wrap_Valid);
function XSIPBNXGHK_wrap_OnFocus(event) {
return XSIPBNXGHK_OnFocus(event);
}
SPBOUILib.SetInputEnter('XSIPBNXGHK',XSIPBNXGHK_wrap_OnFocus);
function XSIPBNXGHK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XSIPBNXGHK',XSIPBNXGHK_wrap_OnKeyDown);
function XSIPBNXGHK_ZOOM_setHandlers() {
function XSIPBNXGHK_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?XSIPBNXGHK_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('XSIPBNXGHK_ZOOM',XSIPBNXGHK_ZOOM_wrap_OnClick);
function XSIPBNXGHK_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('XSIPBNXGHK_ZOOM',XSIPBNXGHK_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('XSIPBNXGHK',XSIPBNXGHK_ZOOM_setHandlers);
function ROFCOTWPXY_wrap_Valid(event) {
return ROFCOTWPXY_Valid(event);
}
SPBOUILib.SetInputExit('ROFCOTWPXY',ROFCOTWPXY_wrap_Valid);
function ROFCOTWPXY_wrap_OnFocus(event) {
return ROFCOTWPXY_OnFocus(event);
}
SPBOUILib.SetInputEnter('ROFCOTWPXY',ROFCOTWPXY_wrap_OnFocus);
function ROFCOTWPXY_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('ROFCOTWPXY',ROFCOTWPXY_wrap_OnKeyPress);
function ROFCOTWPXY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ROFCOTWPXY',ROFCOTWPXY_wrap_OnKeyDown);
function ROFCOTWPXY_ZOOM_setHandlers() {
function ROFCOTWPXY_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ROFCOTWPXY_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('ROFCOTWPXY_ZOOM',ROFCOTWPXY_ZOOM_wrap_OnClick);
function ROFCOTWPXY_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('ROFCOTWPXY_ZOOM',ROFCOTWPXY_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('ROFCOTWPXY',ROFCOTWPXY_ZOOM_setHandlers);
function OHLAYQXDKA_wrap_Valid(event) {
return OHLAYQXDKA_Valid(event);
}
SPBOUILib.SetInputExit('OHLAYQXDKA',OHLAYQXDKA_wrap_Valid);
function OHLAYQXDKA_wrap_OnFocus(event) {
return OHLAYQXDKA_OnFocus(event);
}
SPBOUILib.SetInputEnter('OHLAYQXDKA',OHLAYQXDKA_wrap_OnFocus);
function OHLAYQXDKA_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('OHLAYQXDKA',OHLAYQXDKA_wrap_OnKeyPress);
function OHLAYQXDKA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('OHLAYQXDKA',OHLAYQXDKA_wrap_OnKeyDown);
function OHLAYQXDKA_ZOOM_setHandlers() {
function OHLAYQXDKA_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?OHLAYQXDKA_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('OHLAYQXDKA_ZOOM',OHLAYQXDKA_ZOOM_wrap_OnClick);
function OHLAYQXDKA_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('OHLAYQXDKA_ZOOM',OHLAYQXDKA_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('OHLAYQXDKA',OHLAYQXDKA_ZOOM_setHandlers);
function SNCWUQDNDY_wrap_Valid(event) {
return SNCWUQDNDY_Valid(event);
}
SPBOUILib.SetInputExit('SNCWUQDNDY',SNCWUQDNDY_wrap_Valid);
function SNCWUQDNDY_wrap_OnFocus(event) {
return SNCWUQDNDY_OnFocus(event);
}
SPBOUILib.SetInputEnter('SNCWUQDNDY',SNCWUQDNDY_wrap_OnFocus);
function SNCWUQDNDY_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('SNCWUQDNDY',SNCWUQDNDY_wrap_OnKeyPress);
function SNCWUQDNDY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('SNCWUQDNDY',SNCWUQDNDY_wrap_OnKeyDown);
function SNCWUQDNDY_ZOOM_setHandlers() {
function SNCWUQDNDY_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?SNCWUQDNDY_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('SNCWUQDNDY_ZOOM',SNCWUQDNDY_ZOOM_wrap_OnClick);
function SNCWUQDNDY_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('SNCWUQDNDY_ZOOM',SNCWUQDNDY_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('SNCWUQDNDY',SNCWUQDNDY_ZOOM_setHandlers);
function INPSVTNSOS_wrap_Valid(event) {
return INPSVTNSOS_Valid(event);
}
SPBOUILib.SetComboChange('INPSVTNSOS',INPSVTNSOS_wrap_Valid);
function INPSVTNSOS_wrap_OnFocus(event) {
return INPSVTNSOS_OnFocus(event);
}
SPBOUILib.SetInputEnter('INPSVTNSOS',INPSVTNSOS_wrap_OnFocus);
function INPSVTNSOS_wrap_Blur(event) {
return INPSVTNSOS_OnBlur(event);
}
SPBOUILib.SetInputExit('INPSVTNSOS',INPSVTNSOS_wrap_Blur);
function RYTLUFEGUP_wrap_Valid(event) {
return RYTLUFEGUP_Valid(event);
}
SPBOUILib.SetInputExit('RYTLUFEGUP',RYTLUFEGUP_wrap_Valid);
function RYTLUFEGUP_wrap_OnFocus(event) {
return RYTLUFEGUP_OnFocus(event);
}
SPBOUILib.SetInputEnter('RYTLUFEGUP',RYTLUFEGUP_wrap_OnFocus);
function RYTLUFEGUP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RYTLUFEGUP',RYTLUFEGUP_wrap_OnKeyDown);
function RYTLUFEGUP_ZOOM_setHandlers() {
function RYTLUFEGUP_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?RYTLUFEGUP_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('RYTLUFEGUP_ZOOM',RYTLUFEGUP_ZOOM_wrap_OnClick);
function RYTLUFEGUP_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('RYTLUFEGUP_ZOOM',RYTLUFEGUP_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('RYTLUFEGUP',RYTLUFEGUP_ZOOM_setHandlers);
function HSMPABEPMD_wrap_Valid(event) {
return HSMPABEPMD_Valid(event);
}
SPBOUILib.SetComboChange('HSMPABEPMD',HSMPABEPMD_wrap_Valid);
function HSMPABEPMD_wrap_OnFocus(event) {
return HSMPABEPMD_OnFocus(event);
}
SPBOUILib.SetInputEnter('HSMPABEPMD',HSMPABEPMD_wrap_OnFocus);
function HSMPABEPMD_wrap_Blur(event) {
return HSMPABEPMD_OnBlur(event);
}
SPBOUILib.SetInputExit('HSMPABEPMD',HSMPABEPMD_wrap_Blur);
function WKYJJJVZEF_wrap_Valid(event) {
return WKYJJJVZEF_Valid(event);
}
SPBOUILib.SetCheckboxClick('WKYJJJVZEF',WKYJJJVZEF_wrap_Valid);
function WKYJJJVZEF_wrap_OnFocus(event) {
return WKYJJJVZEF_OnFocus(event);
}
SPBOUILib.SetInputEnter('WKYJJJVZEF',WKYJJJVZEF_wrap_OnFocus);
function WKYJJJVZEF_wrap_Blur(event) {
return WKYJJJVZEF_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('WKYJJJVZEF',WKYJJJVZEF_wrap_Blur);
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
FocusFirstComponent.edit={"page_1":["XSIPBNXGHK","ROFCOTWPXY"],"page_2":["WKYJJJVZEF"]};
FocusFirstComponent.query={"page_1":["XSIPBNXGHK","ROFCOTWPXY"],"page_2":["WKYJJJVZEF"]};
FocusFirstComponent.otherwise={"page_1":["XSIPBNXGHK","ROFCOTWPXY"],"page_2":["WKYJJJVZEF"]};
function Help() {
windowOpenForeground('../doc/armt_provinformazioni_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_ardt_provinformazioni() {
SetModified();
}
function SetModified_ardt_pdelegabo() {
SetModified();
}
function SetModified_ardt_provsoginfo() {
SetModified();
}
function SetModified_ardt_xiduciabo() {
SetModified();
}
function SetModified_ardt_xerzistirap() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_1')) {
if (ChildToLoad('ZFLICMSKTV')) {
LoadContext.lc(1,'ZFLICMSKTV');
} else {
LibJavascript.RefreshChildGrid('ZFLICMSKTV');
}
}
if (Eq(page,'page_1')) {
if (ChildToLoad('RSWMQMMVEI')) {
LoadContext.lc(1,'RSWMQMMVEI');
} else {
LibJavascript.RefreshChildGrid('RSWMQMMVEI');
}
}
if (Eq(page,'page_2')) {
if (ChildToLoad('DUGPTCZBRI')) {
LoadContext.lc(1,'DUGPTCZBRI');
} else {
LibJavascript.RefreshChildGrid('DUGPTCZBRI');
}
}
if (Eq(page,'page_2')) {
if (ChildToLoad('WYSOGTWVYA')) {
LoadContext.lc(1,'WYSOGTWVYA');
} else {
LibJavascript.RefreshChildGrid('WYSOGTWVYA');
}
}
if (Eq(page,'page_2')) {
if (ChildToLoad('NOKYMTFBFL')) {
LoadContext.lc(1,'NOKYMTFBFL');
} else {
LibJavascript.RefreshChildGrid('NOKYMTFBFL');
}
}
}
GetLayerID.Layers.push({"id":"KTBKPUIVLZ","name":"Intermediario"});
GetLayerID.Layers.push({"id":"MMRLCYYISA","name":"DATIBASE"});
GetLayerID.Layers.push({"id":"WMBIUHHCFT","name":"INTESTATARI"});
GetLayerID.Layers.push({"id":"BJHZWDCHTX","name":"DELEGATI"});
GetLayerID.Layers.push({"id":"ZXKFTKZCJE","name":"ALTRISOGG"});
GetLayerID.Layers.push({"id":"EGKLPQESRU","name":"TITOLARI"});
GetLayerID.Layers.push({"id":"LTJVEGZAIT","name":"FIDUCIANTI"});
GetLayerID.Layers.push({"id":"YCTBVNLZSK","name":"Intermediario"});
function DeclareWVs() {
var a = arguments;
w_CDATOPE=a[0];
w_DATARETT=a[1];
w_IDBASE=a[2];
op_IDBASE=a[3];
w_TIPOINTER=a[4];
w_TIPOINF=a[5];
w_IDEREG=a[6];
w_FLAGRAP=a[7];
w_OPRAP=a[8];
w_STATOREG=a[9];
w_OPERAZMOD=a[10];
w_OPERATORE=a[11];
w_AUTOM=a[12];
w_FLAGRAP2=a[13];
w_PRGIMPINF=a[14];
op_PRGIMPINF=a[15];
w_CDATREG=a[16];
w_FLAGLIRE=a[17];
w_VALUTA=a[18];
w_CODINTER=a[19];
w_CODDIPE=a[20];
w_DESCCIT=a[21];
w_PROVINCIA=a[22];
w_CODCAB=a[23];
w_RAPPORTO=a[24];
w_DATAOPE=a[25];
w_DATAREG=a[26];
w_TIPOOPRAP=a[27];
w_CONNESOPER=a[28];
w_TIPOLEG=a[29];
w_NUMPROG=a[30];
op_NUMPROG=a[31];
w_FLAGTIT=a[32];
w_gChkDate=a[33];
w_gDataVaria=a[34];
w_gFlgDTP=a[35];
w_gCodDip=a[36];
w_gIntemediario=a[37];
w_gStatus=a[38];
w_tipreg=a[39];
w_tipregn=a[40];
w_xdescrap=a[41];
w_xDescDipe=a[42];
w_datpaseuro=a[43];
w_xDesReg=a[44];
w_xRagSoc=a[45];
w_sEdit=a[46];
w_errmsg=a[47];
w_test=a[48];
w_Aggiorna=a[49];
w_lancio=a[50];
w_dataoggi=a[51];
w_CITINT=a[52];
w_CITDIP=a[53];
w_PROVDIP=a[54];
w_CABDIP=a[55];
w_PROVINT=a[56];
w_CABINT=a[57];
w_filtro=a[58];
op_codazi=a[59];
o_WMBIUHHCFT_expand=null;
o_WMBIUHHCFT_collapse=null;
o_BJHZWDCHTX_expand=null;
o_BJHZWDCHTX_collapse=null;
m_cWv_ardt_provinformazioni=a[60];
m_cWv_ardt_pdelegabo=a[61];
m_cWv_ardt_provsoginfo=a[62];
m_cWv_ardt_xiduciabo=a[63];
m_cWv_ardt_xerzistirap=a[64];
if (Gt(a.length,65)) {
m_cErrorInChild='';
}
if (Gt(a.length,65)) {
o_CDATOPE=w_CDATOPE;
o_FLAGRAP=w_FLAGRAP;
o_filtro=w_filtro;
o_CODINTER=w_CODINTER;
o_CODDIPE=w_CODDIPE;
o_DATAOPE=w_DATAOPE;
o_TIPOOPRAP=w_TIPOOPRAP;
}
m_PrimaryKeys=['IDBASE'];
}
function i_PrimaryKey() {
return 'xapopebo'+'\\'+CPLib.ToCPStr(w_IDBASE);
}
GetLinkPCKeys.set_o('ardt_provinformazioni',false);
GetLinkPCKeys.set_o('ardt_pdelegabo',false);
GetLinkPCKeys.set_o('ardt_provsoginfo',false);
GetLinkPCKeys.set_o('ardt_xiduciabo',false);
GetLinkPCKeys.set_o('ardt_xerzistirap',false);
GetLinkPCKeys.o['ardt_provinformazioni']['RAPPORTO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_RAPPORTO,'C');
}
}
GetLinkPCKeys.o['ardt_pdelegabo']['RAPPORTO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_RAPPORTO,'C');
}
}
GetLinkPCKeys.o['ardt_provsoginfo']['RAPCOL']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_RAPPORTO,'C');
}
}
GetLinkPCKeys.o['ardt_xiduciabo']['RAPCOL']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_RAPPORTO,'C');
}
}
GetLinkPCKeys.o['ardt_xerzistirap']['IDFILEBO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_IDBASE,'C');
}
}
resizeChildIframe.children['ardt_provinformazioni']=true;
resizeChildIframe.children['ardt_pdelegabo']=true;
resizeChildIframe.children['ardt_provsoginfo']=true;
resizeChildIframe.children['ardt_xiduciabo']=true;
resizeChildIframe.children['ardt_xerzistirap']=true;
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('ZFLICMSKTV',function(){return FrameRef('ardt_provinformazioni')},1,'ardt_provinformazioni',1,1)
LoadContext.f('RSWMQMMVEI',function(){return FrameRef('ardt_pdelegabo')},1,'ardt_pdelegabo',1,1)
LoadContext.f('DUGPTCZBRI',function(){return FrameRef('ardt_provsoginfo')},1,'ardt_provsoginfo',1,2)
LoadContext.f('WYSOGTWVYA',function(){return FrameRef('ardt_xiduciabo')},1,'ardt_xiduciabo',1,2)
LoadContext.f('NOKYMTFBFL',function(){return FrameRef('ardt_xerzistirap')},1,'ardt_xerzistirap',1,2)
GetSelectedChildPage.child={'ardt_provinformazioni': function(){return FrameRef('ardt_provinformazioni')}, 'ardt_pdelegabo': function(){return FrameRef('ardt_pdelegabo')}, 'ardt_provsoginfo': function(){return FrameRef('ardt_provsoginfo')}, 'ardt_xiduciabo': function(){return FrameRef('ardt_xiduciabo')}, 'ardt_xerzistirap': function(){return FrameRef('ardt_xerzistirap')}}
function GetSelectedPage(p_d) {
p_d.setValue('armt_provinformazioni',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
if (IsNull(p_id) || Eq(p_id,'HSMPABEPMD')) {
if (Ctrl('HSMPABEPMD')) {
render_combobox('HSMPABEPMD','qbe_tipileg',["?w_CDATOPE","?w_filtro"],[WtA(w_CDATOPE,"C"),WtA(w_filtro,"C")],GetDynComboId('HSMPABEPMD'),'TPCODICE','TPDESCRI','',WtA(w_TIPOLEG));
w_TIPOLEG=HtW(getComboValue(Ctrl('HSMPABEPMD')),'C');
}
}
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODDIPE,'C'); },"field":"CODDIP","type":"C"},{"expression":function() { return WtA(w_xDescDipe,'C'); },"field":"DESCRIZ","type":"C"},{"expression":function() { return WtA(w_CITDIP,'C'); },"field":"DESCCIT","type":"C"},{"expression":function() { return WtA(w_PROVDIP,'C'); },"field":"PROVINCIA","type":"C"},{"expression":function() { return WtA(w_CABDIP,'C'); },"field":"CAB","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('anadip','C'),"uid":"XSIPBNXGHK"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_RAPPORTO,'C'); },"field":"RAPPORTO","type":"C"},{"expression":function() { return WtA(w_xdescrap,'C'); },"field":"DESCRAP","type":"C"},{"expression":function() { return WtA(w_FLAGRAP,'C'); },"field":"TIPORAP","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('knarapbo','C'),"uid":"ROFCOTWPXY"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CONNESOPER,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xRagSoc,'C'); },"field":"RAGSOC","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"RYTLUFEGUP"});
}
_Obli('TIPOLEG',0,'HSMPABEPMD',false,"11205021885")
_Obli('CONNESOPER',0,'RYTLUFEGUP',false,"11755647652")
_Obli('TIPOOPRAP',0,'INPSVTNSOS',true,"684190680",'INPSVTNSOS')
_Obli('DATAREG',2,'SNCWUQDNDY',true,"1028598955",null,"2021191611")
_Obli('DATAOPE',2,'OHLAYQXDKA',true,"829201110",null,"2021191611")
_Obli('RAPPORTO',0,'ROFCOTWPXY',false)
_Obli('CODDIPE',0,'XSIPBNXGHK',false,"2071283709")
_Obli('CODDIPE',0,'BRGHYFSDHY',false)
_Obli('FLAGTIT',1,'WKYJJJVZEF',false,"2063970052")
