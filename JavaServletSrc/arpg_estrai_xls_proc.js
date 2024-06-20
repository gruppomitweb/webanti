function SetControlsValue() {
var c;
var c;
if(c=Ctrl('QEIVEBXKFW')) c.value = WtH(w_connes,'C',16,0,'')
if(c=Ctrl('IUARTFLDNM')) c.value = WtH(w_ragosc,'C',60,0,'@!')
if(c=Ctrl('OUWMDLXPIS')) c.value = WtH(w_cCODFISC,'C',16,0,'')
if(c=Ctrl('FKOHLGHPDQ')) c.value = WtH(w_citnas,'C',40,0,'')
if(c=Ctrl('CYKHQWZLSC')) c.value = WtH(w_stanas,'C',40,0,'')
if(c=Ctrl('WWVZLGRRCI')) c.value = WtH(w_datnas,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('OXKAWWOUJN')) c.value = WtH(w_ragben,'C',60,0,'@!')
if(c=Ctrl('FWTFXGQZAI')) c.value = WtH(w_staben,'C',40,0,'')
if(c=Ctrl('DPKVLWHCIG')) c.value = WtH(w_dadata,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('MTJDZQTEIR')) c.value = WtH(w_adata,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('RWVYYKSQTM')) ChkboxCheckUncheck(c,'S',w_flgmese)
if(c=Ctrl('RWVYYKSQTM')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('DZAJHOZNZJ')) c.value = WtH(w_codmag,'C',5,0,'')
if(c=Ctrl('FBVBGICYQT')) c.value = WtH(w_cDIP,'C',6,0,'')
if(c=Ctrl('XECGCUVQNW')) c.value = WtH(w_cMTCN,'C',10,0,'')
if(c=Ctrl('FLYXRDHNYB')) selectCombo(c,w_tipofile,'C')
if(c=Ctrl('BAPCIYCOIX')) c.value = WtH(w_destfold,'C',80,0,'')
if(c=Ctrl('XPVFYUOOMG')) ChkboxCheckUncheck(c,'S',w_opesel)
if(c=Ctrl('XPVFYUOOMG')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('DVVVZVWYQU')) ChkboxCheckUncheck(c,'S',w_frzsel)
if(c=Ctrl('DVVVZVWYQU')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('KVMSNZSHYQ')) ChkboxCheckUncheck(c,'S',w_attive)
if(c=Ctrl('KVMSNZSHYQ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('CNLUJUMTRH')) selectRadio(c,w_tipoout,'C')
var tmp_TQJNOWMVHW = ToHTag(AsControlValue(w_xdesdip));
if (Ne(e_TQJNOWMVHW,tmp_TQJNOWMVHW)) {
if(c=Ctrl('TQJNOWMVHW')) c.innerHTML=tmp_TQJNOWMVHW;
e_TQJNOWMVHW=tmp_TQJNOWMVHW;
}
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
var tmp_BUHXXVSCZH = ToHTag(AsControlValue(w_xmadescri));
if (Ne(e_BUHXXVSCZH,tmp_BUHXXVSCZH)) {
if(c=Ctrl('BUHXXVSCZH')) c.innerHTML=tmp_BUHXXVSCZH;
e_BUHXXVSCZH=tmp_BUHXXVSCZH;
}
if(c=Ctrl('FPLBMQHLCU')) c.value = WtH(w_nomefile,'C',60,0,'')
if(c=Ctrl('LDWRKOVJHN')) ChkboxCheckUncheck(c,'S',w_flgsto)
if(c=Ctrl('LDWRKOVJHN')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('VFBJBVZFDJ')) ChkboxCheckUncheck(c,'S',w_flgncf)
if(c=Ctrl('VFBJBVZFDJ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('PBRMCZVHNN')) selectRadio(c,w_flgsegno,'C')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('OUWMDLXPIS'),Ne(w_gFlgWU,'S') || IsHiddenByStateDriver('cCODFISC'));
SetDisplay(Ctrl('XECGCUVQNW'),Ne(w_gFlgWU,'S') || IsHiddenByStateDriver('cMTCN'));
SetDisplay(Ctrl('FGMOCXNBFY'),true);
SetDisplay(Ctrl('CXSMATIXZS'),Ne(w_gFlgWU,'S'));
SetDisplay(Ctrl('MAKXXLLXNA'),Ne(w_gFlgWU,'S'));
HideUI();
}
HideUI.lblids["adata"]=['BGHAITOPMU'];
HideUI.lblids["cCODFISC"]=['CXSMATIXZS','MAKXXLLXNA'];
HideUI.lblids["cDIP"]=['HLQSHVFXVS'];
HideUI.lblids["cMTCN"]=['CXSMATIXZS','MAKXXLLXNA'];
HideUI.lblids["citnas"]=['PUJCUNGGCR'];
HideUI.lblids["codmag"]=['JLHFWAWERN'];
HideUI.lblids["connes"]=['SKZNSKGZRP'];
HideUI.lblids["dadata"]=['HPGJXQIVYG'];
HideUI.lblids["datnas"]=['IPCBNWYJLL'];
HideUI.lblids["destfold"]=['OBJZKBQZTK'];
HideUI.lblids["nomefile"]=['QRXJMBXMQM'];
HideUI.lblids["opesel"]=['QJBLEONCDX'];
HideUI.lblids["ragben"]=['BRFEXEKXWS'];
HideUI.lblids["ragosc"]=['MILQDXSPXU'];
HideUI.lblids["staben"]=['WGMJUTZBBY'];
HideUI.lblids["stanas"]=['ZAMUVZUHHN'];
HideUI.lblids["tipofile"]=['PIFFTCKSCU'];
HideUI.lblids["tipoout"]=['OJOGFQEVQE','ZWFWRKARRA'];
function QEIVEBXKFW_Valid(e) {
SetActiveField(Ctrl('QEIVEBXKFW'),false);
e=(Ne(e,null)?e:window.event);
return Set_connes(HtW(Ctrl('QEIVEBXKFW').value,'C'),null,e);
}
function QEIVEBXKFW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QEIVEBXKFW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QEIVEBXKFW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QEIVEBXKFW'),e);
}
function QEIVEBXKFW_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('QEIVEBXKFW')),'linkview_QEIVEBXKFW','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function IUARTFLDNM_Valid(e) {
SetActiveField(Ctrl('IUARTFLDNM'),false);
e=(Ne(e,null)?e:window.event);
return Set_ragosc(HtW(Ctrl('IUARTFLDNM').value,'C'),null,e);
}
function IUARTFLDNM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IUARTFLDNM'))) {
DisplayErrorMessage();
}
Ctrl('IUARTFLDNM').value=WtH(w_ragosc,'C',60,0,'@!');
SetActiveField(Ctrl('IUARTFLDNM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IUARTFLDNM'),e);
}
function IUARTFLDNM_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function OUWMDLXPIS_Valid(e) {
SetActiveField(Ctrl('OUWMDLXPIS'),false);
e=(Ne(e,null)?e:window.event);
return Set_cCODFISC(HtW(Ctrl('OUWMDLXPIS').value,'C'),null,e);
}
function OUWMDLXPIS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OUWMDLXPIS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OUWMDLXPIS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OUWMDLXPIS'),e);
}
function FKOHLGHPDQ_Valid(e) {
SetActiveField(Ctrl('FKOHLGHPDQ'),false);
e=(Ne(e,null)?e:window.event);
return Set_citnas(HtW(Ctrl('FKOHLGHPDQ').value,'C'),null,e);
}
function FKOHLGHPDQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FKOHLGHPDQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FKOHLGHPDQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FKOHLGHPDQ'),e);
}
function FKOHLGHPDQ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('FKOHLGHPDQ')),'linkview_FKOHLGHPDQ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function CYKHQWZLSC_Valid(e) {
SetActiveField(Ctrl('CYKHQWZLSC'),false);
e=(Ne(e,null)?e:window.event);
return Set_stanas(HtW(Ctrl('CYKHQWZLSC').value,'C'),null,e);
}
function CYKHQWZLSC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CYKHQWZLSC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CYKHQWZLSC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CYKHQWZLSC'),e);
}
function CYKHQWZLSC_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('CYKHQWZLSC')),'linkview_CYKHQWZLSC','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function WWVZLGRRCI_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('WWVZLGRRCI'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('WWVZLGRRCI').value=ApplyPictureToDate(Ctrl('WWVZLGRRCI').value,TranslatePicture(datePattern),'WWVZLGRRCI');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('WWVZLGRRCI'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('WWVZLGRRCI');
}
}
}
SetActiveField(Ctrl('WWVZLGRRCI'),false);
e=(Ne(e,null)?e:window.event);
return Set_datnas(HtW(Ctrl('WWVZLGRRCI').value,'D'),null,e) && dateisok;
}
function WWVZLGRRCI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WWVZLGRRCI'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('WWVZLGRRCI').value=WtH(w_datnas,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('WWVZLGRRCI');
SetActiveField(Ctrl('WWVZLGRRCI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WWVZLGRRCI'),e);
}
function WWVZLGRRCI_ZOOM_Click() {
LaunchCalendar(Ctrl('WWVZLGRRCI'));
}
function OXKAWWOUJN_Valid(e) {
SetActiveField(Ctrl('OXKAWWOUJN'),false);
e=(Ne(e,null)?e:window.event);
return Set_ragben(HtW(Ctrl('OXKAWWOUJN').value,'C'),null,e);
}
function OXKAWWOUJN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OXKAWWOUJN'))) {
DisplayErrorMessage();
}
Ctrl('OXKAWWOUJN').value=WtH(w_ragben,'C',60,0,'@!');
SetActiveField(Ctrl('OXKAWWOUJN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OXKAWWOUJN'),e);
}
function OXKAWWOUJN_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function FWTFXGQZAI_Valid(e) {
SetActiveField(Ctrl('FWTFXGQZAI'),false);
e=(Ne(e,null)?e:window.event);
return Set_staben(HtW(Ctrl('FWTFXGQZAI').value,'C'),null,e);
}
function FWTFXGQZAI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FWTFXGQZAI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FWTFXGQZAI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FWTFXGQZAI'),e);
}
function FWTFXGQZAI_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('FWTFXGQZAI')),'linkview_FWTFXGQZAI','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
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
return Set_dadata(HtW(Ctrl('DPKVLWHCIG').value,'D'),null,e) && dateisok;
}
function DPKVLWHCIG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DPKVLWHCIG'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('DPKVLWHCIG').value=WtH(w_dadata,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('DPKVLWHCIG');
SetActiveField(Ctrl('DPKVLWHCIG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DPKVLWHCIG'),e);
}
function DPKVLWHCIG_ZOOM_Click() {
LaunchCalendar(Ctrl('DPKVLWHCIG'));
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
return Set_adata(HtW(Ctrl('MTJDZQTEIR').value,'D'),null,e) && dateisok;
}
function MTJDZQTEIR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MTJDZQTEIR'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('MTJDZQTEIR'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('MTJDZQTEIR').value=WtH(w_adata,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('MTJDZQTEIR');
SetActiveField(Ctrl('MTJDZQTEIR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MTJDZQTEIR'),e);
}
function MTJDZQTEIR_ZOOM_Click() {
LaunchCalendar(Ctrl('MTJDZQTEIR'));
}
function RWVYYKSQTM_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgmese(ChkboxValueAssign(Ctrl('RWVYYKSQTM'),'S','N','C',1,0,''),null,e);
}
function RWVYYKSQTM_OnFocus(e) {
SetActiveField(Ctrl('RWVYYKSQTM'),true);
}
function RWVYYKSQTM_OnBlur(e) {
SetActiveField(Ctrl('RWVYYKSQTM'),false);
}
function DZAJHOZNZJ_Valid(e) {
SetActiveField(Ctrl('DZAJHOZNZJ'),false);
e=(Ne(e,null)?e:window.event);
return Set_codmag(HtW(Ctrl('DZAJHOZNZJ').value,'C'),null,e);
}
function DZAJHOZNZJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DZAJHOZNZJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DZAJHOZNZJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DZAJHOZNZJ'),e);
}
function DZAJHOZNZJ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('DZAJHOZNZJ')),'linkview_DZAJHOZNZJ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function FBVBGICYQT_Valid(e) {
SetActiveField(Ctrl('FBVBGICYQT'),false);
e=(Ne(e,null)?e:window.event);
return Set_cDIP(HtW(Ctrl('FBVBGICYQT').value,'C'),null,e);
}
function FBVBGICYQT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FBVBGICYQT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FBVBGICYQT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FBVBGICYQT'),e);
}
function FBVBGICYQT_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('FBVBGICYQT')),'linkview_FBVBGICYQT','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function XECGCUVQNW_Valid(e) {
SetActiveField(Ctrl('XECGCUVQNW'),false);
e=(Ne(e,null)?e:window.event);
return Set_cMTCN(HtW(Ctrl('XECGCUVQNW').value,'C'),null,e);
}
function XECGCUVQNW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XECGCUVQNW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XECGCUVQNW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XECGCUVQNW'),e);
}
function DZUBEERBGN_Click() {
_modifyandopen(ToResource('servlet/sp_huploadfile'+'?pAtExit='+URLenc('Return')+'&pDirectory='+URLenc('appo/'+LRTrim(w_gAzienda))+'&pVarReturn='+URLenc('nomefile')+'&m_cParameterSequence=pAtExit,pDirectory,pVarReturn')+'&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function FLYXRDHNYB_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipofile(HtW(getComboValue(Ctrl('FLYXRDHNYB')),'C'),null,e);
}
function FLYXRDHNYB_OnFocus(e) {
SetActiveField(Ctrl('FLYXRDHNYB'),true);
}
function FLYXRDHNYB_OnBlur(e) {
SetActiveField(Ctrl('FLYXRDHNYB'),false);
}
function BAPCIYCOIX_Valid(e) {
SetActiveField(Ctrl('BAPCIYCOIX'),false);
e=(Ne(e,null)?e:window.event);
return Set_destfold(HtW(Ctrl('BAPCIYCOIX').value,'C'),null,e);
}
function BAPCIYCOIX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BAPCIYCOIX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BAPCIYCOIX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BAPCIYCOIX'),e);
}
function XPVFYUOOMG_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_opesel(ChkboxValueAssign(Ctrl('XPVFYUOOMG'),'S','N','C',1,0,''),null,e);
}
function XPVFYUOOMG_OnFocus(e) {
SetActiveField(Ctrl('XPVFYUOOMG'),true);
}
function XPVFYUOOMG_OnBlur(e) {
SetActiveField(Ctrl('XPVFYUOOMG'),false);
}
function DVVVZVWYQU_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_frzsel(ChkboxValueAssign(Ctrl('DVVVZVWYQU'),'S','N','C',1,0,''),null,e);
}
function DVVVZVWYQU_OnFocus(e) {
SetActiveField(Ctrl('DVVVZVWYQU'),true);
}
function DVVVZVWYQU_OnBlur(e) {
SetActiveField(Ctrl('DVVVZVWYQU'),false);
}
function KVMSNZSHYQ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_attive(ChkboxValueAssign(Ctrl('KVMSNZSHYQ'),'S','N','C',1,0,''),null,e);
}
function KVMSNZSHYQ_OnFocus(e) {
SetActiveField(Ctrl('KVMSNZSHYQ'),true);
}
function KVMSNZSHYQ_OnBlur(e) {
SetActiveField(Ctrl('KVMSNZSHYQ'),false);
}
function CNLUJUMTRH_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipoout(HtW(getRadioValue(Ctrl('CNLUJUMTRH')),'C'),null,e);
}
function href_FXCLBAZMUC() {
var l_oWv = InitWvApplet();
l_oWv.setValue('pTipo',AsAppletValue('B'));
l_oWv.setValue('w_adata',AsAppletValue(w_adata));
l_oWv.setValue('w_c_adata',AsAppletValue(w_c_adata));
l_oWv.setValue('w_cCODFISC',AsAppletValue(w_cCODFISC));
l_oWv.setValue('w_cdadata',AsAppletValue(w_cdadata));
l_oWv.setValue('w_cDIP',AsAppletValue(w_cDIP));
l_oWv.setValue('w_citnas',AsAppletValue(w_citnas));
l_oWv.setValue('w_cMTCN',AsAppletValue(w_cMTCN));
l_oWv.setValue('w_dadata',AsAppletValue(w_dadata));
l_oWv.setValue('w_datnas',AsAppletValue(w_datnas));
l_oWv.setValue('w_ragosc',AsAppletValue(w_ragosc));
l_oWv.setValue('w_stanas',AsAppletValue(w_stanas));
l_oWv.setValue('w_xdesdip',AsAppletValue(w_xdesdip));
l_oWv.setValue('w_ragben',AsAppletValue(w_ragben));
l_oWv.setValue('w_staben',AsAppletValue(w_staben));
l_oWv.setValue('w_codmag',AsAppletValue(w_codmag));
l_oWv.setValue('w_connes',AsAppletValue(w_connes));
l_oWv.setValue('w_nomefile',AsAppletValue(w_nomefile));
l_oWv.setValue('w_tipofile',AsAppletValue(w_tipofile));
l_oWv.setValue('w_tipoout',AsAppletValue(w_tipoout));
l_oWv.setValue('w_opesel',AsAppletValue(w_opesel));
l_oWv.setValue('w_frzsel',AsAppletValue(w_frzsel));
l_oWv.setValue('w_attive',AsAppletValue(w_attive));
l_oWv.setValue('w_destfold',AsAppletValue(w_destfold));
l_oWv.setValue('w_flgmese',AsAppletValue(w_flgmese));
l_oWv.setValue('w_flgncf',AsAppletValue(w_flgncf));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('pTipo,w_adata,w_c_adata,w_cCODFISC,w_cdadata,w_cDIP,w_citnas,w_cMTCN,w_dadata,w_datnas,w_ragosc,w_stanas,w_xdesdip,w_ragben,w_staben,w_codmag,w_connes,w_nomefile,w_tipofile,w_tipoout,w_opesel,w_frzsel,w_attive,w_destfold,w_flgmese,w_flgncf'));
SetLocationHref(null,'arrt_start_estrai_xls'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function href_XURLGQZZMU() {
var l_oWv = InitWvApplet();
l_oWv.setValue('pTipo',AsAppletValue('S'));
l_oWv.setValue('w_adata',AsAppletValue(w_adata));
l_oWv.setValue('w_c_adata',AsAppletValue(w_c_adata));
l_oWv.setValue('w_cCODFISC',AsAppletValue(w_cCODFISC));
l_oWv.setValue('w_cdadata',AsAppletValue(w_cdadata));
l_oWv.setValue('w_cDIP',AsAppletValue(w_cDIP));
l_oWv.setValue('w_citnas',AsAppletValue(w_citnas));
l_oWv.setValue('w_cMTCN',AsAppletValue(w_cMTCN));
l_oWv.setValue('w_dadata',AsAppletValue(w_dadata));
l_oWv.setValue('w_datnas',AsAppletValue(w_datnas));
l_oWv.setValue('w_ragosc',AsAppletValue(w_ragosc));
l_oWv.setValue('w_stanas',AsAppletValue(w_stanas));
l_oWv.setValue('w_xdesdip',AsAppletValue(w_xdesdip));
l_oWv.setValue('w_ragben',AsAppletValue(w_ragben));
l_oWv.setValue('w_staben',AsAppletValue(w_staben));
l_oWv.setValue('w_codmag',AsAppletValue(w_codmag));
l_oWv.setValue('w_connes',AsAppletValue(w_connes));
l_oWv.setValue('w_nomefile',AsAppletValue(w_nomefile));
l_oWv.setValue('w_tipofile',AsAppletValue(w_tipofile));
l_oWv.setValue('w_tipoout',AsAppletValue(w_tipoout));
l_oWv.setValue('w_opesel',AsAppletValue(w_opesel));
l_oWv.setValue('w_frzsel',AsAppletValue(w_frzsel));
l_oWv.setValue('w_attive',AsAppletValue(w_attive));
l_oWv.setValue('w_destfold',AsAppletValue(w_destfold));
l_oWv.setValue('w_flgmese',AsAppletValue(w_flgmese));
l_oWv.setValue('w_flgncf',AsAppletValue(w_flgncf));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('pTipo,w_adata,w_c_adata,w_cCODFISC,w_cdadata,w_cDIP,w_citnas,w_cMTCN,w_dadata,w_datnas,w_ragosc,w_stanas,w_xdesdip,w_ragben,w_staben,w_codmag,w_connes,w_nomefile,w_tipofile,w_tipoout,w_opesel,w_frzsel,w_attive,w_destfold,w_flgmese,w_flgncf'));
SetLocationHref(null,'arrt_start_estrai_xls'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function href_PTXYMSWBZO() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function FPLBMQHLCU_Valid(e) {
SetActiveField(Ctrl('FPLBMQHLCU'),false);
e=(Ne(e,null)?e:window.event);
return Set_nomefile(HtW(Ctrl('FPLBMQHLCU').value,'C'),null,e);
}
function FPLBMQHLCU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FPLBMQHLCU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FPLBMQHLCU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FPLBMQHLCU'),e);
}
function LDWRKOVJHN_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgsto(ChkboxValueAssign(Ctrl('LDWRKOVJHN'),'S','N','C',1,0,''),null,e);
}
function LDWRKOVJHN_OnFocus(e) {
SetActiveField(Ctrl('LDWRKOVJHN'),true);
}
function LDWRKOVJHN_OnBlur(e) {
SetActiveField(Ctrl('LDWRKOVJHN'),false);
}
function VFBJBVZFDJ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgncf(ChkboxValueAssign(Ctrl('VFBJBVZFDJ'),'S','N','C',1,0,''),null,e);
}
function VFBJBVZFDJ_OnFocus(e) {
SetActiveField(Ctrl('VFBJBVZFDJ'),true);
}
function VFBJBVZFDJ_OnBlur(e) {
SetActiveField(Ctrl('VFBJBVZFDJ'),false);
}
function PBRMCZVHNN_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgsegno(HtW(getRadioValue(Ctrl('PBRMCZVHNN')),'C'),null,e);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('QEIVEBXKFW')) c.onblur=QEIVEBXKFW_Valid;
if(c=Ctrl('QEIVEBXKFW')) c.onfocus=QEIVEBXKFW_OnFocus;
if(c=Ctrl('IUARTFLDNM')) c.onblur=IUARTFLDNM_Valid;
if(c=Ctrl('IUARTFLDNM')) c.onfocus=IUARTFLDNM_OnFocus;
if(c=Ctrl('IUARTFLDNM')) c.onkeypress=CheckUpper;
if(c=Ctrl('OUWMDLXPIS')) c.onblur=OUWMDLXPIS_Valid;
if(c=Ctrl('OUWMDLXPIS')) c.onfocus=OUWMDLXPIS_OnFocus;
if(c=Ctrl('FKOHLGHPDQ')) c.onblur=FKOHLGHPDQ_Valid;
if(c=Ctrl('FKOHLGHPDQ')) c.onfocus=FKOHLGHPDQ_OnFocus;
if(c=Ctrl('CYKHQWZLSC')) c.onblur=CYKHQWZLSC_Valid;
if(c=Ctrl('CYKHQWZLSC')) c.onfocus=CYKHQWZLSC_OnFocus;
if(c=Ctrl('WWVZLGRRCI')) c.onblur=WWVZLGRRCI_Valid;
if(c=Ctrl('WWVZLGRRCI')) c.onfocus=WWVZLGRRCI_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('WWVZLGRRCI')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('OXKAWWOUJN')) c.onblur=OXKAWWOUJN_Valid;
if(c=Ctrl('OXKAWWOUJN')) c.onfocus=OXKAWWOUJN_OnFocus;
if(c=Ctrl('OXKAWWOUJN')) c.onkeypress=CheckUpper;
if(c=Ctrl('FWTFXGQZAI')) c.onblur=FWTFXGQZAI_Valid;
if(c=Ctrl('FWTFXGQZAI')) c.onfocus=FWTFXGQZAI_OnFocus;
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
if(c=Ctrl('RWVYYKSQTM')) c.onclick=RWVYYKSQTM_Valid;
if(c=Ctrl('RWVYYKSQTM')) c.onfocus=RWVYYKSQTM_OnFocus;
if(c=Ctrl('RWVYYKSQTM')) c.onblur=RWVYYKSQTM_OnBlur;
if(c=Ctrl('DZAJHOZNZJ')) c.onblur=DZAJHOZNZJ_Valid;
if(c=Ctrl('DZAJHOZNZJ')) c.onfocus=DZAJHOZNZJ_OnFocus;
if(c=Ctrl('FBVBGICYQT')) c.onblur=FBVBGICYQT_Valid;
if(c=Ctrl('FBVBGICYQT')) c.onfocus=FBVBGICYQT_OnFocus;
if(c=Ctrl('XECGCUVQNW')) c.onblur=XECGCUVQNW_Valid;
if(c=Ctrl('XECGCUVQNW')) c.onfocus=XECGCUVQNW_OnFocus;
if(c=Ctrl('FLYXRDHNYB')) c.onchange=FLYXRDHNYB_Valid;
if(c=Ctrl('FLYXRDHNYB')) c.onfocus=FLYXRDHNYB_OnFocus;
if(c=Ctrl('FLYXRDHNYB')) c.onblur=FLYXRDHNYB_OnBlur;
if(c=Ctrl('BAPCIYCOIX')) c.onblur=BAPCIYCOIX_Valid;
if(c=Ctrl('BAPCIYCOIX')) c.onfocus=BAPCIYCOIX_OnFocus;
if(c=Ctrl('XPVFYUOOMG')) c.onclick=XPVFYUOOMG_Valid;
if(c=Ctrl('XPVFYUOOMG')) c.onfocus=XPVFYUOOMG_OnFocus;
if(c=Ctrl('XPVFYUOOMG')) c.onblur=XPVFYUOOMG_OnBlur;
if(c=Ctrl('DVVVZVWYQU')) c.onclick=DVVVZVWYQU_Valid;
if(c=Ctrl('DVVVZVWYQU')) c.onfocus=DVVVZVWYQU_OnFocus;
if(c=Ctrl('DVVVZVWYQU')) c.onblur=DVVVZVWYQU_OnBlur;
if(c=Ctrl('KVMSNZSHYQ')) c.onclick=KVMSNZSHYQ_Valid;
if(c=Ctrl('KVMSNZSHYQ')) c.onfocus=KVMSNZSHYQ_OnFocus;
if(c=Ctrl('KVMSNZSHYQ')) c.onblur=KVMSNZSHYQ_OnBlur;
c=Ctrl('CNLUJUMTRH');
if ( ! (Empty(c))) {
c[0].onclick=CNLUJUMTRH_Valid;
c[1].onclick=CNLUJUMTRH_Valid;
c[2].onclick=CNLUJUMTRH_Valid;
c[3].onclick=CNLUJUMTRH_Valid;
c[4].onclick=CNLUJUMTRH_Valid;
}
if(c=Ctrl('FPLBMQHLCU')) c.onblur=FPLBMQHLCU_Valid;
if(c=Ctrl('FPLBMQHLCU')) c.onfocus=FPLBMQHLCU_OnFocus;
if(c=Ctrl('LDWRKOVJHN')) c.onclick=LDWRKOVJHN_Valid;
if(c=Ctrl('LDWRKOVJHN')) c.onfocus=LDWRKOVJHN_OnFocus;
if(c=Ctrl('LDWRKOVJHN')) c.onblur=LDWRKOVJHN_OnBlur;
if(c=Ctrl('VFBJBVZFDJ')) c.onclick=VFBJBVZFDJ_Valid;
if(c=Ctrl('VFBJBVZFDJ')) c.onfocus=VFBJBVZFDJ_OnFocus;
if(c=Ctrl('VFBJBVZFDJ')) c.onblur=VFBJBVZFDJ_OnBlur;
c=Ctrl('PBRMCZVHNN');
if ( ! (Empty(c))) {
c[0].onclick=PBRMCZVHNN_Valid;
c[1].onclick=PBRMCZVHNN_Valid;
}
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_estrai_xls_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["QEIVEBXKFW"]};
function Help() {
windowOpenForeground('../doc/arpg_estrai_xls_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_connes=a[0];
w_ragosc=a[1];
w_cCODFISC=a[2];
w_citnas=a[3];
w_stanas=a[4];
w_datnas=a[5];
w_ragben=a[6];
w_staben=a[7];
w_dadata=a[8];
w_adata=a[9];
w_flgmese=a[10];
w_codmag=a[11];
w_cDIP=a[12];
w_cMTCN=a[13];
w_tipofile=a[14];
w_destfold=a[15];
w_opesel=a[16];
w_frzsel=a[17];
w_attive=a[18];
w_tipoout=a[19];
w_cdadata=a[20];
w_c_adata=a[21];
w_xdesdip=a[22];
w_nomefile=a[23];
w_gUrlApp=a[24];
w_gFileName=a[25];
w_gFlgWU=a[26];
w_xmadescri=a[27];
w_gAzienda=a[28];
w_flgsto=a[29];
w_flgncf=a[30];
w_flgsegno=a[31];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_estrai_xls',m_cSelectedPage);
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
l_bEnabled= ! (false) || IsDisabledByStateDriver('nomefile');
SetDisabled(Ctrl('FPLBMQHLCU'),l_bEnabled);
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
function Set_connes(ctrlValue,kmode,e) {
if (Ne(w_connes,ctrlValue)) {
var ctl = _GetCtl(e,'QEIVEBXKFW');
if (_tracker.goon(ctl,ctrlValue)) {
w_connes=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QEIVEBXKFW',0);
if (l_bResult) {
l_bResult=Link_QEIVEBXKFW(kmode);
if ( ! (l_bResult)) {
w_connes=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',16,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',16,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ragosc(ctrlValue,kmode,e) {
if (Ne(w_ragosc,ctrlValue)) {
var ctl = _GetCtl(e,'IUARTFLDNM');
if (_tracker.goon(ctl,ctrlValue)) {
w_ragosc=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IUARTFLDNM',0);
DoUpdate(l_bResult);
if(c=Ctrl('IUARTFLDNM')) c.value = WtH(w_ragosc,'C',60,0,'@!')
} else {
ctl.value=WtH('','C',60,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_cCODFISC(ctrlValue,kmode,e) {
if (Ne(w_cCODFISC,ctrlValue)) {
var ctl = _GetCtl(e,'OUWMDLXPIS');
if (_tracker.goon(ctl,ctrlValue)) {
w_cCODFISC=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OUWMDLXPIS',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',16,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_citnas(ctrlValue,kmode,e) {
if (Ne(w_citnas,ctrlValue)) {
var ctl = _GetCtl(e,'FKOHLGHPDQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_citnas=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FKOHLGHPDQ',0);
if (l_bResult) {
l_bResult=Link_FKOHLGHPDQ(kmode);
if ( ! (l_bResult)) {
w_citnas=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',40,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',40,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_stanas(ctrlValue,kmode,e) {
if (Ne(w_stanas,ctrlValue)) {
var ctl = _GetCtl(e,'CYKHQWZLSC');
if (_tracker.goon(ctl,ctrlValue)) {
w_stanas=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CYKHQWZLSC',0);
if (l_bResult) {
l_bResult=Link_CYKHQWZLSC(kmode);
if ( ! (l_bResult)) {
w_stanas=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',40,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',40,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_datnas(ctrlValue,kmode,e) {
if (Ne(w_datnas,ctrlValue)) {
var ctl = _GetCtl(e,'WWVZLGRRCI');
if (_tracker.goon(ctl,ctrlValue)) {
w_datnas=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WWVZLGRRCI',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_ragben(ctrlValue,kmode,e) {
if (Ne(w_ragben,ctrlValue)) {
var ctl = _GetCtl(e,'OXKAWWOUJN');
if (_tracker.goon(ctl,ctrlValue)) {
w_ragben=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OXKAWWOUJN',0);
DoUpdate(l_bResult);
if(c=Ctrl('OXKAWWOUJN')) c.value = WtH(w_ragben,'C',60,0,'@!')
} else {
ctl.value=WtH('','C',60,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_staben(ctrlValue,kmode,e) {
if (Ne(w_staben,ctrlValue)) {
var ctl = _GetCtl(e,'FWTFXGQZAI');
if (_tracker.goon(ctl,ctrlValue)) {
w_staben=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FWTFXGQZAI',0);
if (l_bResult) {
l_bResult=Link_FWTFXGQZAI(kmode);
if ( ! (l_bResult)) {
w_staben=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',40,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',40,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_dadata(ctrlValue,kmode,e) {
if (Ne(w_dadata,ctrlValue)) {
var ctl = _GetCtl(e,'DPKVLWHCIG');
if (_tracker.goon(ctl,ctrlValue)) {
w_dadata=ctrlValue;
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
function Set_adata(ctrlValue,kmode,e) {
if (Ne(w_adata,ctrlValue)) {
var ctl = _GetCtl(e,'MTJDZQTEIR');
if (_tracker.goon(ctl,ctrlValue)) {
w_adata=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MTJDZQTEIR',0);
if (l_bResult) {
l_bResult=Ge(w_adata,w_dadata);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='adata';
m_cLastMsgError=AlertErrorMessage('10557974447');
}
if ( ! (l_bResult)) {
w_adata=HtW('','D');
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
function Set_flgmese(ctrlValue,kmode,e) {
if (Ne(w_flgmese,ctrlValue)) {
var ctl = _GetCtl(e,'RWVYYKSQTM');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgmese=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RWVYYKSQTM',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_codmag(ctrlValue,kmode,e) {
if (Ne(w_codmag,ctrlValue)) {
var ctl = _GetCtl(e,'DZAJHOZNZJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_codmag=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DZAJHOZNZJ',0);
if (l_bResult) {
l_bResult=Link_DZAJHOZNZJ(kmode);
if ( ! (l_bResult)) {
w_codmag=HtW('','C');
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
function Set_cDIP(ctrlValue,kmode,e) {
if (Ne(w_cDIP,ctrlValue)) {
var ctl = _GetCtl(e,'FBVBGICYQT');
if (_tracker.goon(ctl,ctrlValue)) {
w_cDIP=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FBVBGICYQT',0);
if (l_bResult) {
l_bResult=Link_FBVBGICYQT(kmode);
if ( ! (l_bResult)) {
w_cDIP=HtW('','C');
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
function Set_cMTCN(ctrlValue,kmode,e) {
if (Ne(w_cMTCN,ctrlValue)) {
var ctl = _GetCtl(e,'XECGCUVQNW');
if (_tracker.goon(ctl,ctrlValue)) {
w_cMTCN=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XECGCUVQNW',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_tipofile(ctrlValue,kmode,e) {
if (Ne(w_tipofile,ctrlValue)) {
var ctl = _GetCtl(e,'FLYXRDHNYB');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipofile=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FLYXRDHNYB',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_destfold(ctrlValue,kmode,e) {
if (Ne(w_destfold,ctrlValue)) {
var ctl = _GetCtl(e,'BAPCIYCOIX');
if (_tracker.goon(ctl,ctrlValue)) {
w_destfold=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BAPCIYCOIX',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',80,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_opesel(ctrlValue,kmode,e) {
if (Ne(w_opesel,ctrlValue)) {
var ctl = _GetCtl(e,'XPVFYUOOMG');
if (_tracker.goon(ctl,ctrlValue)) {
w_opesel=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XPVFYUOOMG',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_frzsel(ctrlValue,kmode,e) {
if (Ne(w_frzsel,ctrlValue)) {
var ctl = _GetCtl(e,'DVVVZVWYQU');
if (_tracker.goon(ctl,ctrlValue)) {
w_frzsel=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DVVVZVWYQU',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_attive(ctrlValue,kmode,e) {
if (Ne(w_attive,ctrlValue)) {
var ctl = _GetCtl(e,'KVMSNZSHYQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_attive=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KVMSNZSHYQ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_tipoout(ctrlValue,kmode,e) {
if (Ne(w_tipoout,ctrlValue)) {
var ctl = _GetCtl(e,'CNLUJUMTRH');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipoout=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CNLUJUMTRH',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgsegno(ctrlValue,kmode,e) {
if (Ne(w_flgsegno,ctrlValue)) {
var ctl = _GetCtl(e,'PBRMCZVHNN');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgsegno=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PBRMCZVHNN',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgncf(ctrlValue,kmode,e) {
if (Ne(w_flgncf,ctrlValue)) {
var ctl = _GetCtl(e,'VFBJBVZFDJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgncf=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VFBJBVZFDJ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgsto(ctrlValue,kmode,e) {
if (Ne(w_flgsto,ctrlValue)) {
var ctl = _GetCtl(e,'LDWRKOVJHN');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgsto=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LDWRKOVJHN',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_nomefile(ctrlValue,kmode,e) {
if (Ne(w_nomefile,ctrlValue)) {
var ctl = _GetCtl(e,'FPLBMQHLCU');
if (_tracker.goon(ctl,ctrlValue)) {
w_nomefile=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UVZFDRNXWE',0);
l_bResult=l_bResult && _ChkObl('FPLBMQHLCU',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',60,0,'');
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
w_cdadata=(Empty(w_dadata)?'':DateToChar(w_dadata));
w_c_adata=(Empty(w_adata)?'':DateToChar(w_adata));
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function Link_QEIVEBXKFW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_connes);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_connes,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('QEIVEBXKFW');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_connes=l_Appl.GetStringValue('CONNES',16,0);
w_ragosc=l_Appl.GetStringValue('RAGSOC',60,0);
} else {
Link_QEIVEBXKFW_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_QEIVEBXKFW';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_QEIVEBXKFW();
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
function Link_QEIVEBXKFW_Blank() {
w_connes='';
w_ragosc='';
}
function LOpt_QEIVEBXKFW() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('QEIVEBXKFW','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QEIVEBXKFW'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('195812931'),'C'));
return l_oWv;
}
function Link_FKOHLGHPDQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_citnas);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_citnas,40,0);
l_Appl.SetFields('CITTA');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('FKOHLGHPDQ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_citnas=l_Appl.GetStringValue('CITTA',40,0);
} else {
Link_FKOHLGHPDQ_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_FKOHLGHPDQ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_FKOHLGHPDQ();
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
function Link_FKOHLGHPDQ_Blank() {
}
function LOpt_FKOHLGHPDQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('FKOHLGHPDQ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['FKOHLGHPDQ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_CYKHQWZLSC(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_stanas);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('DESCRI',w_stanas,40,0);
l_Appl.SetFields('DESCRI');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('CYKHQWZLSC');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_stanas=l_Appl.GetStringValue('DESCRI',40,0);
} else {
Link_CYKHQWZLSC_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_CYKHQWZLSC';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_CYKHQWZLSC();
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
function Link_CYKHQWZLSC_Blank() {
}
function LOpt_CYKHQWZLSC() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('DESCRI','C'));
l_oWv.setValue('LinkedField',WtA('DESCRI','C'));
l_oWv.setValue('UID',WtA('CYKHQWZLSC','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['CYKHQWZLSC'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Link_FWTFXGQZAI(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_staben);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('DESCRI',w_staben,40,0);
l_Appl.SetFields('DESCRI');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('FWTFXGQZAI');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_staben=l_Appl.GetStringValue('DESCRI',40,0);
} else {
Link_FWTFXGQZAI_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_FWTFXGQZAI';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_FWTFXGQZAI();
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
function Link_FWTFXGQZAI_Blank() {
}
function LOpt_FWTFXGQZAI() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('DESCRI','C'));
l_oWv.setValue('LinkedField',WtA('DESCRI','C'));
l_oWv.setValue('UID',WtA('FWTFXGQZAI','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['FWTFXGQZAI'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Link_DZAJHOZNZJ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_codmag);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('MACODICE',w_codmag,5,0);
l_Appl.SetFields('MACODICE,MADESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbmacage');
l_Appl.SetID('DZAJHOZNZJ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_codmag=l_Appl.GetStringValue('MACODICE',5,0);
w_xmadescri=l_Appl.GetStringValue('MADESCRI',60,0);
} else {
Link_DZAJHOZNZJ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_DZAJHOZNZJ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_DZAJHOZNZJ();
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
function Link_DZAJHOZNZJ_Blank() {
w_codmag='';
w_xmadescri='';
}
function LOpt_DZAJHOZNZJ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbmacage','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('MACODICE','C'));
l_oWv.setValue('LinkedField',WtA('MACODICE','C'));
l_oWv.setValue('UID',WtA('DZAJHOZNZJ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['DZAJHOZNZJ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11148782069'),'C'));
return l_oWv;
}
function Link_FBVBGICYQT(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_cDIP);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODDIP',w_cDIP,6,0);
l_Appl.SetFields('CODDIP,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetID('FBVBGICYQT');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_cDIP=l_Appl.GetStringValue('CODDIP',6,0);
w_xdesdip=l_Appl.GetStringValue('DESCRIZ',30,0);
} else {
Link_FBVBGICYQT_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_FBVBGICYQT';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_FBVBGICYQT();
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
function Link_FBVBGICYQT_Blank() {
w_cDIP='';
w_xdesdip='';
}
function LOpt_FBVBGICYQT() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODDIP','C'));
l_oWv.setValue('LinkedField',WtA('CODDIP','C'));
l_oWv.setValue('UID',WtA('FBVBGICYQT','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['FBVBGICYQT'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1270140318'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'QEIVEBXKFW')) {
last_focused_comp=GetLastFocusedElementOfLink('QEIVEBXKFW');
function SetMethod_QEIVEBXKFW() {
Set_connes(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_QEIVEBXKFW();
} else {
setTimeout(SetMethod_QEIVEBXKFW,1);
}
bResult=true;
}
if (Eq(varName,'FKOHLGHPDQ')) {
last_focused_comp=GetLastFocusedElementOfLink('FKOHLGHPDQ');
function SetMethod_FKOHLGHPDQ() {
Set_citnas(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_FKOHLGHPDQ();
} else {
setTimeout(SetMethod_FKOHLGHPDQ,1);
}
bResult=true;
}
if (Eq(varName,'CYKHQWZLSC')) {
last_focused_comp=GetLastFocusedElementOfLink('CYKHQWZLSC');
function SetMethod_CYKHQWZLSC() {
Set_stanas(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_CYKHQWZLSC();
} else {
setTimeout(SetMethod_CYKHQWZLSC,1);
}
bResult=true;
}
if (Eq(varName,'FWTFXGQZAI')) {
last_focused_comp=GetLastFocusedElementOfLink('FWTFXGQZAI');
function SetMethod_FWTFXGQZAI() {
Set_staben(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_FWTFXGQZAI();
} else {
setTimeout(SetMethod_FWTFXGQZAI,1);
}
bResult=true;
}
if (Eq(varName,'DZAJHOZNZJ')) {
last_focused_comp=GetLastFocusedElementOfLink('DZAJHOZNZJ');
function SetMethod_DZAJHOZNZJ() {
Set_codmag(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_DZAJHOZNZJ();
} else {
setTimeout(SetMethod_DZAJHOZNZJ,1);
}
bResult=true;
}
if (Eq(varName,'FBVBGICYQT')) {
last_focused_comp=GetLastFocusedElementOfLink('FBVBGICYQT');
function SetMethod_FBVBGICYQT() {
Set_cDIP(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_FBVBGICYQT();
} else {
setTimeout(SetMethod_FBVBGICYQT,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'QEIVEBXKFW')) {
return [Ctrl('QEIVEBXKFW')];
}
if (Eq(varName,'FKOHLGHPDQ')) {
return [Ctrl('FKOHLGHPDQ')];
}
if (Eq(varName,'CYKHQWZLSC')) {
return [Ctrl('CYKHQWZLSC')];
}
if (Eq(varName,'FWTFXGQZAI')) {
return [Ctrl('FWTFXGQZAI')];
}
if (Eq(varName,'DZAJHOZNZJ')) {
return [Ctrl('DZAJHOZNZJ')];
}
if (Eq(varName,'FBVBGICYQT')) {
return [Ctrl('FBVBGICYQT')];
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
if ( ! (_ChkObl('QEIVEBXKFW',1))) {
_SignErr('QEIVEBXKFW');
m_cLastWorkVarErrorMsg='733213761';
l_bResult=false;
w_connes=HtW('','C');
} else if ( ! (_ChkObl('IUARTFLDNM',1))) {
_SignErr('IUARTFLDNM');
m_cLastWorkVarErrorMsg='176491428';
l_bResult=false;
w_ragosc=HtW('','C');
} else if ( ! (_ChkObl('OUWMDLXPIS',1))) {
_SignErr('OUWMDLXPIS');
m_cLastWorkVarErrorMsg='cCODFISC';
l_bResult=false;
w_cCODFISC=HtW('','C');
} else if ( ! (_ChkObl('FKOHLGHPDQ',1))) {
_SignErr('FKOHLGHPDQ');
m_cLastWorkVarErrorMsg='12124197165';
l_bResult=false;
w_citnas=HtW('','C');
} else if ( ! (_ChkObl('CYKHQWZLSC',1))) {
_SignErr('CYKHQWZLSC');
m_cLastWorkVarErrorMsg='12123284333';
l_bResult=false;
w_stanas=HtW('','C');
} else if ( ! (_ChkObl('WWVZLGRRCI',1))) {
_SignErr('WWVZLGRRCI');
m_cLastWorkVarErrorMsg='10669633582';
l_bResult=false;
w_datnas=HtW('','D');
} else if ( ! (_ChkObl('OXKAWWOUJN',1))) {
_SignErr('OXKAWWOUJN');
m_cLastWorkVarErrorMsg='176491428';
l_bResult=false;
w_ragben=HtW('','C');
} else if ( ! (_ChkObl('FWTFXGQZAI',1))) {
_SignErr('FWTFXGQZAI');
m_cLastWorkVarErrorMsg='12123284333';
l_bResult=false;
w_staben=HtW('','C');
} else if ( ! (_ChkObl('DPKVLWHCIG',1))) {
_SignErr('DPKVLWHCIG');
m_cLastWorkVarErrorMsg='dadata';
l_bResult=false;
w_dadata=HtW('','D');
} else if (( ! (_ChkObl('MTJDZQTEIR',1))) || ( ! (Ge(w_adata,w_dadata)))) {
_SignErr('MTJDZQTEIR','10557974447');
l_bResult=false;
w_adata=HtW('','D');
} else if ( ! (_ChkObl('RWVYYKSQTM',1))) {
_SignErr('RWVYYKSQTM');
m_cLastWorkVarErrorMsg='flgmese';
l_bResult=false;
w_flgmese='N';
} else if ( ! (_ChkObl('DZAJHOZNZJ',1))) {
_SignErr('DZAJHOZNZJ');
m_cLastWorkVarErrorMsg='11148783093';
l_bResult=false;
w_codmag=HtW('','C');
} else if ( ! (_ChkObl('FBVBGICYQT',1))) {
_SignErr('FBVBGICYQT');
m_cLastWorkVarErrorMsg='cDIP';
l_bResult=false;
w_cDIP=HtW('','C');
} else if ( ! (_ChkObl('XECGCUVQNW',1))) {
_SignErr('XECGCUVQNW');
m_cLastWorkVarErrorMsg='cMTCN';
l_bResult=false;
w_cMTCN=HtW('','C');
} else if ( ! (_ChkObl('FLYXRDHNYB',1))) {
_SignErr('FLYXRDHNYB');
m_cLastWorkVarErrorMsg='763848521';
l_bResult=false;
w_tipofile=HtW('','C');
} else if ( ! (_ChkObl('BAPCIYCOIX',1))) {
_SignErr('BAPCIYCOIX');
m_cLastWorkVarErrorMsg='145008573';
l_bResult=false;
w_destfold=HtW('','C');
} else if ( ! (_ChkObl('XPVFYUOOMG',1))) {
_SignErr('XPVFYUOOMG');
m_cLastWorkVarErrorMsg='opesel';
l_bResult=false;
w_opesel='N';
} else if ( ! (_ChkObl('DVVVZVWYQU',1))) {
_SignErr('DVVVZVWYQU');
m_cLastWorkVarErrorMsg='frzsel';
l_bResult=false;
w_frzsel='N';
} else if ( ! (_ChkObl('KVMSNZSHYQ',1))) {
_SignErr('KVMSNZSHYQ');
m_cLastWorkVarErrorMsg='attive';
l_bResult=false;
w_attive='N';
} else if ( ! (_ChkObl('CNLUJUMTRH',1))) {
_SignErr('CNLUJUMTRH');
m_cLastWorkVarErrorMsg='11172839772';
l_bResult=false;
w_tipoout=HtW('','C');
} else if ((false) && ( ! (_ChkObl('FPLBMQHLCU',1)))) {
_SignErr('FPLBMQHLCU');
m_cLastWorkVarErrorMsg='10982022690';
l_bResult=false;
w_nomefile=HtW('','C');
} else if ( ! (_ChkObl('LDWRKOVJHN',1))) {
_SignErr('LDWRKOVJHN');
m_cLastWorkVarErrorMsg='1311031053';
l_bResult=false;
w_flgsto='N';
} else if ( ! (_ChkObl('VFBJBVZFDJ',1))) {
_SignErr('VFBJBVZFDJ');
m_cLastWorkVarErrorMsg='flgncf';
l_bResult=false;
w_flgncf='N';
} else if ( ! (_ChkObl('PBRMCZVHNN',1))) {
_SignErr('PBRMCZVHNN');
m_cLastWorkVarErrorMsg='flgsegno';
l_bResult=false;
w_flgsegno=HtW('','C');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('QEIVEBXKFW_ZOOM',lc)) {
return 0;
}
if (Eq('QEIVEBXKFW',lc)) {
return 0;
}
if (Eq('FKOHLGHPDQ_ZOOM',lc)) {
return 1;
}
if (Eq('FKOHLGHPDQ',lc)) {
return 1;
}
if (Eq('CYKHQWZLSC_ZOOM',lc)) {
return 2;
}
if (Eq('CYKHQWZLSC',lc)) {
return 2;
}
if (Eq('WWVZLGRRCI_ZOOM',lc)) {
return 3;
}
if (Eq('FWTFXGQZAI_ZOOM',lc)) {
return 3;
}
if (Eq('FWTFXGQZAI',lc)) {
return 3;
}
if (Eq('DPKVLWHCIG_ZOOM',lc)) {
return 4;
}
if (Eq('MTJDZQTEIR_ZOOM',lc)) {
return 4;
}
if (Eq('DZAJHOZNZJ_ZOOM',lc)) {
return 4;
}
if (Eq('DZAJHOZNZJ',lc)) {
return 4;
}
if (Eq('FBVBGICYQT_ZOOM',lc)) {
return 5;
}
if (Eq('FBVBGICYQT',lc)) {
return 5;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_QEIVEBXKFW();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_FKOHLGHPDQ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_CYKHQWZLSC();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,3)) {
l_oWv=LOpt_FWTFXGQZAI();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,4)) {
l_oWv=LOpt_DZAJHOZNZJ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,5)) {
l_oWv=LOpt_FBVBGICYQT();
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
l_oWv.setValue('connes',WtA(w_connes,'C'));
l_oWv.setValue('ragosc',WtA(w_ragosc,'C'));
l_oWv.setValue('cCODFISC',WtA(w_cCODFISC,'C'));
l_oWv.setValue('citnas',WtA(w_citnas,'C'));
l_oWv.setValue('stanas',WtA(w_stanas,'C'));
l_oWv.setValue('datnas',WtA(w_datnas,'D'));
l_oWv.setValue('ragben',WtA(w_ragben,'C'));
l_oWv.setValue('staben',WtA(w_staben,'C'));
l_oWv.setValue('dadata',WtA(w_dadata,'D'));
l_oWv.setValue('adata',WtA(w_adata,'D'));
l_oWv.setValue('flgmese',WtA(w_flgmese,'C'));
l_oWv.setValue('codmag',WtA(w_codmag,'C'));
l_oWv.setValue('cDIP',WtA(w_cDIP,'C'));
l_oWv.setValue('cMTCN',WtA(w_cMTCN,'C'));
l_oWv.setValue('tipofile',WtA(w_tipofile,'C'));
l_oWv.setValue('destfold',WtA(w_destfold,'C'));
l_oWv.setValue('opesel',WtA(w_opesel,'C'));
l_oWv.setValue('frzsel',WtA(w_frzsel,'C'));
l_oWv.setValue('attive',WtA(w_attive,'C'));
l_oWv.setValue('tipoout',WtA(w_tipoout,'C'));
l_oWv.setValue('cdadata',WtA(w_cdadata,'C'));
l_oWv.setValue('c_adata',WtA(w_c_adata,'C'));
l_oWv.setValue('xdesdip',WtA(w_xdesdip,'C'));
l_oWv.setValue('nomefile',WtA(w_nomefile,'C'));
l_oWv.setValue('gUrlApp',WtA(w_gUrlApp,'C'));
l_oWv.setValue('gFileName',WtA(w_gFileName,'C'));
l_oWv.setValue('gFlgWU',WtA(w_gFlgWU,'C'));
l_oWv.setValue('xmadescri',WtA(w_xmadescri,'C'));
l_oWv.setValue('gAzienda',WtA(w_gAzienda,'C'));
l_oWv.setValue('flgsto',WtA(w_flgsto,'C'));
l_oWv.setValue('flgncf',WtA(w_flgncf,'C'));
l_oWv.setValue('flgsegno',WtA(w_flgsegno,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["connes","ragosc","cCODFISC","citnas","stanas","datnas","ragben","staben","dadata","adata","flgmese","codmag","cDIP","cMTCN","tipofile","destfold","opesel","frzsel","attive","tipoout","cdadata","c_adata","xdesdip","nomefile","gUrlApp","gFileName","gFlgWU","xmadescri","gAzienda","flgsto","flgncf","flgsegno"];
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
if (Empty(w_dadata) && Ne(opener.w_dadata,null)) {
TransferBetweenWindows(opener,'w_dadata',null,'Set_dadata');
}
if (Empty(w_adata) && Ne(opener.w_adata,null)) {
TransferBetweenWindows(opener,'w_adata',null,'Set_adata');
}
if (Empty(w_cdadata) && Ne(opener.w_cdadata,null)) {
TransferBetweenWindows(opener,'w_cdadata','w_cdadata');
}
if (Empty(w_c_adata) && Ne(opener.w_c_adata,null)) {
TransferBetweenWindows(opener,'w_c_adata','w_c_adata');
}
if (Empty(w_nomefile) && Ne(opener.w_nomefile,null)) {
TransferBetweenWindows(opener,'w_nomefile','w_nomefile');
}
}
}
m_bCalculating=true;
Link_QEIVEBXKFW(null);
Link_FKOHLGHPDQ(null);
Link_CYKHQWZLSC(null);
Link_FWTFXGQZAI(null);
if (start && Eq(At(',flgmese,',pseq),0)) {
w_flgmese='N';
}
Link_DZAJHOZNZJ(null);
Link_FBVBGICYQT(null);
if (start && Eq(At(',opesel,',pseq),0)) {
w_opesel='S';
}
if (start && Eq(At(',frzsel,',pseq),0)) {
w_frzsel='S';
}
if (start && Eq(At(',attive,',pseq),0)) {
w_attive='N';
}
if (start && Eq(At(',tipoout,',pseq),0)) {
w_tipoout='E';
}
w_cdadata=(Empty(w_dadata)?'':DateToChar(w_dadata));
w_c_adata=(Empty(w_adata)?'':DateToChar(w_adata));
if (start && Eq(At(',flgncf,',pseq),0)) {
w_flgncf='N';
}
if (start && Eq(At(',flgsegno,',pseq),0)) {
w_flgsegno='1';
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
_Obli('connes',0,'QEIVEBXKFW',false,"733213761")
_Obli('ragosc',0,'IUARTFLDNM',false,"176491428")
_Obli('cCODFISC',0,'OUWMDLXPIS',false)
_Obli('citnas',0,'FKOHLGHPDQ',false,"12124197165")
_Obli('stanas',0,'CYKHQWZLSC',false,"12123284333")
_Obli('datnas',2,'WWVZLGRRCI',false,"10669633582")
_Obli('ragben',0,'OXKAWWOUJN',false,"176491428")
_Obli('staben',0,'FWTFXGQZAI',false,"12123284333")
_Obli('dadata',2,'DPKVLWHCIG',false)
_Obli('adata',2,'MTJDZQTEIR',false)
_Obli('flgmese',0,'RWVYYKSQTM',false)
_Obli('codmag',0,'DZAJHOZNZJ',false,"11148783093")
_Obli('cDIP',0,'FBVBGICYQT',false)
_Obli('cMTCN',0,'XECGCUVQNW',false)
_Obli('tipofile',0,'FLYXRDHNYB',false,"763848521")
_Obli('destfold',0,'BAPCIYCOIX',false,"145008573")
_Obli('opesel',0,'XPVFYUOOMG',false)
_Obli('frzsel',0,'DVVVZVWYQU',false)
_Obli('attive',0,'KVMSNZSHYQ',false)
_Obli('tipoout',0,'CNLUJUMTRH',false,"11172839772")
_Obli('flgsegno',0,'PBRMCZVHNN',false)
_Obli('flgncf',0,'VFBJBVZFDJ',false)
_Obli('flgsto',0,'LDWRKOVJHN',false,"1311031053")
_Obli('nomefile',0,'UVZFDRNXWE',false)
_Obli('nomefile',0,'FPLBMQHLCU',false,"10982022690")
