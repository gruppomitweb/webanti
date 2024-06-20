function SetControlsValue() {
var c;
var c;
if(c=Ctrl('FFEEVEUPBF')) selectCombo(c,w_ragione,'C')
if(c=Ctrl('JIYGZCDTPQ')) c.value = WtH(w_datarett,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('QLKRKJTVJT')) c.value = WtH(w_olddata,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('NEAUUYCSRF')) c.value = WtH(w_oldintest,'C',16,0,'')
if(c=Ctrl('WVHOQYPKFE')) ChkboxCheckUncheck(c,1,w_xcfestero)
if(c=Ctrl('WVHOQYPKFE')) ChkboxValueAssign(c,1,0,'N',1,0,'')
if(c=Ctrl('KXGHBTYQDK')) c.value = WtH(w_xcodfisc,'C',16,0,'')
if(c=Ctrl('ZLEFBXLUTT')) c.value = WtH(w_xcognome,'C',26,0,'')
if(c=Ctrl('TRZRNHUQSZ')) c.value = WtH(w_xnome,'C',25,0,'')
if(c=Ctrl('VHDBEIXHTA')) selectCombo(c,w_xsesso,'C')
if(c=Ctrl('NOGBUOIVWB')) c.value = WtH(w_newintest,'C',16,0,'')
var tmp_EHGZXQREHH = ToHTag(AsControlValue(w_xragnew));
if (Ne(e_EHGZXQREHH,tmp_EHGZXQREHH)) {
if(c=Ctrl('EHGZXQREHH')) c.innerHTML=tmp_EHGZXQREHH;
e_EHGZXQREHH=tmp_EHGZXQREHH;
}
var tmp_PUHCDZJWVF = ToHTag(AsControlValue(w_xragold));
if (Ne(e_PUHCDZJWVF,tmp_PUHCDZJWVF)) {
if(c=Ctrl('PUHCDZJWVF')) c.innerHTML=tmp_PUHCDZJWVF;
e_PUHCDZJWVF=tmp_PUHCDZJWVF;
}
if(c=Ctrl('ZSRVHHSRRD')) selectRadio(c,w_tipochg,'C')
if(c=Ctrl('HBSWFKBFZJ')) c.value = WtH(w_xnascomun,'C',40,0,'')
if(c=Ctrl('MPXBUDNRPY')) c.value = WtH(w_xtipinter,'C',2,0,'')
if(c=Ctrl('YDHXQFESNA')) c.value = WtH(w_xnasstato,'C',40,0,'')
if(c=Ctrl('SBDBIBIUBZ')) c.value = WtH(w_xdatnasc,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('NCHAEUMUPJ')) c.value = WtH(w_olddatac,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('RROSTBCQKE')) c.value = WtH(w_idesito,'C',8,0,'')
if(c=Ctrl('NICAEATMFV')) c.value = WtH(w_newdatec,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('WYJHXYCTSP')) c.value = WtH(w_newdate,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('MDWFLPZWFN'),Ne(w_ragione,'S') && Ne(w_ragione,'N'));
HideUI();
}
HideUI.lblids["datarett"]=['XQSJGZVMDV'];
HideUI.lblids["idesito"]=['EFJEEIKTHM'];
HideUI.lblids["newdate"]=['OLVLBDQTYW'];
HideUI.lblids["newdatec"]=['VYPUVNDTCE'];
HideUI.lblids["newintest"]=['ISRGWEYPBE'];
HideUI.lblids["olddata"]=['NRLLUEOMLT'];
HideUI.lblids["olddatac"]=['EVXMXJTANP'];
HideUI.lblids["oldintest"]=['YMQGLGBXMV'];
HideUI.lblids["xcodfisc"]=['AJUVDYOZZL'];
HideUI.lblids["xcognome"]=['SSUWRDQRDI'];
HideUI.lblids["xdatnasc"]=['OSVHVNFSTF'];
HideUI.lblids["xnascomun"]=['DFMOVYUECJ'];
HideUI.lblids["xnasstato"]=['RNCFPZEWNP'];
HideUI.lblids["xnome"]=['HHYAFDYFPB'];
HideUI.lblids["xsesso"]=['HAZSNHXYTH'];
function FFEEVEUPBF_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_ragione(HtW(getComboValue(Ctrl('FFEEVEUPBF')),'C'),null,e);
}
function FFEEVEUPBF_OnFocus(e) {
SetActiveField(Ctrl('FFEEVEUPBF'),true);
}
function FFEEVEUPBF_OnBlur(e) {
SetActiveField(Ctrl('FFEEVEUPBF'),false);
}
function JIYGZCDTPQ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('JIYGZCDTPQ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('JIYGZCDTPQ').value=ApplyPictureToDate(Ctrl('JIYGZCDTPQ').value,TranslatePicture(datePattern),'JIYGZCDTPQ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('JIYGZCDTPQ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('JIYGZCDTPQ');
}
}
}
SetActiveField(Ctrl('JIYGZCDTPQ'),false);
e=(Ne(e,null)?e:window.event);
return Set_datarett(HtW(Ctrl('JIYGZCDTPQ').value,'D'),null,e) && dateisok;
}
function JIYGZCDTPQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JIYGZCDTPQ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('JIYGZCDTPQ').value=WtH(w_datarett,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('JIYGZCDTPQ');
SetActiveField(Ctrl('JIYGZCDTPQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JIYGZCDTPQ'),e);
}
function JIYGZCDTPQ_ZOOM_Click() {
LaunchCalendar(Ctrl('JIYGZCDTPQ'));
}
function QLKRKJTVJT_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('QLKRKJTVJT'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('QLKRKJTVJT').value=ApplyPictureToDate(Ctrl('QLKRKJTVJT').value,TranslatePicture(datePattern),'QLKRKJTVJT');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('QLKRKJTVJT'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('QLKRKJTVJT');
}
}
}
SetActiveField(Ctrl('QLKRKJTVJT'),false);
e=(Ne(e,null)?e:window.event);
return Set_olddata(HtW(Ctrl('QLKRKJTVJT').value,'D'),null,e) && dateisok;
}
function QLKRKJTVJT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QLKRKJTVJT'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('QLKRKJTVJT').value=WtH(w_olddata,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('QLKRKJTVJT');
SetActiveField(Ctrl('QLKRKJTVJT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QLKRKJTVJT'),e);
}
function NEAUUYCSRF_Valid(e) {
SetActiveField(Ctrl('NEAUUYCSRF'),false);
e=(Ne(e,null)?e:window.event);
return Set_oldintest(HtW(Ctrl('NEAUUYCSRF').value,'C'),null,e);
}
function NEAUUYCSRF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NEAUUYCSRF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NEAUUYCSRF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NEAUUYCSRF'),e);
}
function NEAUUYCSRF_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('NEAUUYCSRF')),'linkview_NEAUUYCSRF','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function WVHOQYPKFE_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_xcfestero(ChkboxValueAssign(Ctrl('WVHOQYPKFE'),1,0,'N',1,0,''),null,e);
}
function WVHOQYPKFE_OnFocus(e) {
SetActiveField(Ctrl('WVHOQYPKFE'),true);
}
function WVHOQYPKFE_OnBlur(e) {
SetActiveField(Ctrl('WVHOQYPKFE'),false);
}
function KXGHBTYQDK_Valid(e) {
SetActiveField(Ctrl('KXGHBTYQDK'),false);
e=(Ne(e,null)?e:window.event);
return Set_xcodfisc(HtW(Ctrl('KXGHBTYQDK').value,'C'),null,e);
}
function KXGHBTYQDK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KXGHBTYQDK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KXGHBTYQDK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KXGHBTYQDK'),e);
}
function ZLEFBXLUTT_Valid(e) {
SetActiveField(Ctrl('ZLEFBXLUTT'),false);
e=(Ne(e,null)?e:window.event);
return Set_xcognome(HtW(Ctrl('ZLEFBXLUTT').value,'C'),null,e);
}
function ZLEFBXLUTT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZLEFBXLUTT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZLEFBXLUTT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZLEFBXLUTT'),e);
}
function TRZRNHUQSZ_Valid(e) {
SetActiveField(Ctrl('TRZRNHUQSZ'),false);
e=(Ne(e,null)?e:window.event);
return Set_xnome(HtW(Ctrl('TRZRNHUQSZ').value,'C'),null,e);
}
function TRZRNHUQSZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TRZRNHUQSZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TRZRNHUQSZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TRZRNHUQSZ'),e);
}
function VHDBEIXHTA_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_xsesso(HtW(getComboValue(Ctrl('VHDBEIXHTA')),'C'),null,e);
}
function VHDBEIXHTA_OnFocus(e) {
SetActiveField(Ctrl('VHDBEIXHTA'),true);
}
function VHDBEIXHTA_OnBlur(e) {
SetActiveField(Ctrl('VHDBEIXHTA'),false);
}
function NOGBUOIVWB_Valid(e) {
SetActiveField(Ctrl('NOGBUOIVWB'),false);
e=(Ne(e,null)?e:window.event);
return Set_newintest(HtW(Ctrl('NOGBUOIVWB').value,'C'),null,e);
}
function NOGBUOIVWB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NOGBUOIVWB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NOGBUOIVWB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NOGBUOIVWB'),e);
}
function NOGBUOIVWB_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('NOGBUOIVWB')),'linkview_NOGBUOIVWB','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function href_YBBLCLWLHJ() {
window.close()
}
function href_MDWFLPZWFN() {
LanciaSalva()
}
function ZSRVHHSRRD_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipochg(HtW(getRadioValue(Ctrl('ZSRVHHSRRD')),'C'),null,e);
}
function HBSWFKBFZJ_Valid(e) {
SetActiveField(Ctrl('HBSWFKBFZJ'),false);
e=(Ne(e,null)?e:window.event);
return Set_xnascomun(HtW(Ctrl('HBSWFKBFZJ').value,'C'),null,e);
}
function HBSWFKBFZJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HBSWFKBFZJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HBSWFKBFZJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HBSWFKBFZJ'),e);
}
function HBSWFKBFZJ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('HBSWFKBFZJ')),'linkview_HBSWFKBFZJ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function MPXBUDNRPY_Valid(e) {
SetActiveField(Ctrl('MPXBUDNRPY'),false);
e=(Ne(e,null)?e:window.event);
return Set_xtipinter(HtW(Ctrl('MPXBUDNRPY').value,'C'),null,e);
}
function MPXBUDNRPY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MPXBUDNRPY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MPXBUDNRPY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MPXBUDNRPY'),e);
}
function YDHXQFESNA_Valid(e) {
SetActiveField(Ctrl('YDHXQFESNA'),false);
e=(Ne(e,null)?e:window.event);
return Set_xnasstato(HtW(Ctrl('YDHXQFESNA').value,'C'),null,e);
}
function YDHXQFESNA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YDHXQFESNA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YDHXQFESNA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YDHXQFESNA'),e);
}
function YDHXQFESNA_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('YDHXQFESNA')),'linkview_YDHXQFESNA','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function SBDBIBIUBZ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('SBDBIBIUBZ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('SBDBIBIUBZ').value=ApplyPictureToDate(Ctrl('SBDBIBIUBZ').value,TranslatePicture(datePattern),'SBDBIBIUBZ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('SBDBIBIUBZ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('SBDBIBIUBZ');
}
}
}
SetActiveField(Ctrl('SBDBIBIUBZ'),false);
e=(Ne(e,null)?e:window.event);
return Set_xdatnasc(HtW(Ctrl('SBDBIBIUBZ').value,'D'),null,e) && dateisok;
}
function SBDBIBIUBZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SBDBIBIUBZ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('SBDBIBIUBZ').value=WtH(w_xdatnasc,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('SBDBIBIUBZ');
SetActiveField(Ctrl('SBDBIBIUBZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SBDBIBIUBZ'),e);
}
function NCHAEUMUPJ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('NCHAEUMUPJ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('NCHAEUMUPJ').value=ApplyPictureToDate(Ctrl('NCHAEUMUPJ').value,TranslatePicture(datePattern),'NCHAEUMUPJ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('NCHAEUMUPJ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('NCHAEUMUPJ');
}
}
}
SetActiveField(Ctrl('NCHAEUMUPJ'),false);
e=(Ne(e,null)?e:window.event);
return Set_olddatac(HtW(Ctrl('NCHAEUMUPJ').value,'D'),null,e) && dateisok;
}
function NCHAEUMUPJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NCHAEUMUPJ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('NCHAEUMUPJ').value=WtH(w_olddatac,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('NCHAEUMUPJ');
SetActiveField(Ctrl('NCHAEUMUPJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NCHAEUMUPJ'),e);
}
function NICAEATMFV_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('NICAEATMFV'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('NICAEATMFV').value=ApplyPictureToDate(Ctrl('NICAEATMFV').value,TranslatePicture(datePattern),'NICAEATMFV');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('NICAEATMFV'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('NICAEATMFV');
}
}
}
SetActiveField(Ctrl('NICAEATMFV'),false);
e=(Ne(e,null)?e:window.event);
return Set_newdatec(HtW(Ctrl('NICAEATMFV').value,'D'),null,e) && dateisok;
}
function NICAEATMFV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NICAEATMFV'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('NICAEATMFV').value=WtH(w_newdatec,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('NICAEATMFV');
SetActiveField(Ctrl('NICAEATMFV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NICAEATMFV'),e);
}
function NICAEATMFV_ZOOM_Click() {
LaunchCalendar(Ctrl('NICAEATMFV'));
}
function WYJHXYCTSP_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('WYJHXYCTSP'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('WYJHXYCTSP').value=ApplyPictureToDate(Ctrl('WYJHXYCTSP').value,TranslatePicture(datePattern),'WYJHXYCTSP');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('WYJHXYCTSP'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('WYJHXYCTSP');
}
}
}
SetActiveField(Ctrl('WYJHXYCTSP'),false);
e=(Ne(e,null)?e:window.event);
return Set_newdate(HtW(Ctrl('WYJHXYCTSP').value,'D'),null,e) && dateisok;
}
function WYJHXYCTSP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WYJHXYCTSP'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('WYJHXYCTSP').value=WtH(w_newdate,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('WYJHXYCTSP');
SetActiveField(Ctrl('WYJHXYCTSP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WYJHXYCTSP'),e);
}
function WYJHXYCTSP_ZOOM_Click() {
LaunchCalendar(Ctrl('WYJHXYCTSP'));
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('FFEEVEUPBF')) c.onchange=FFEEVEUPBF_Valid;
if(c=Ctrl('FFEEVEUPBF')) c.onfocus=FFEEVEUPBF_OnFocus;
if(c=Ctrl('FFEEVEUPBF')) c.onblur=FFEEVEUPBF_OnBlur;
if(c=Ctrl('JIYGZCDTPQ')) c.onblur=JIYGZCDTPQ_Valid;
if(c=Ctrl('JIYGZCDTPQ')) c.onfocus=JIYGZCDTPQ_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('JIYGZCDTPQ')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('QLKRKJTVJT')) c.onblur=QLKRKJTVJT_Valid;
if(c=Ctrl('QLKRKJTVJT')) c.onfocus=QLKRKJTVJT_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('QLKRKJTVJT')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('NEAUUYCSRF')) c.onblur=NEAUUYCSRF_Valid;
if(c=Ctrl('NEAUUYCSRF')) c.onfocus=NEAUUYCSRF_OnFocus;
if(c=Ctrl('WVHOQYPKFE')) c.onclick=WVHOQYPKFE_Valid;
if(c=Ctrl('WVHOQYPKFE')) c.onfocus=WVHOQYPKFE_OnFocus;
if(c=Ctrl('WVHOQYPKFE')) c.onblur=WVHOQYPKFE_OnBlur;
if(c=Ctrl('KXGHBTYQDK')) c.onblur=KXGHBTYQDK_Valid;
if(c=Ctrl('KXGHBTYQDK')) c.onfocus=KXGHBTYQDK_OnFocus;
if(c=Ctrl('ZLEFBXLUTT')) c.onblur=ZLEFBXLUTT_Valid;
if(c=Ctrl('ZLEFBXLUTT')) c.onfocus=ZLEFBXLUTT_OnFocus;
if(c=Ctrl('TRZRNHUQSZ')) c.onblur=TRZRNHUQSZ_Valid;
if(c=Ctrl('TRZRNHUQSZ')) c.onfocus=TRZRNHUQSZ_OnFocus;
if(c=Ctrl('VHDBEIXHTA')) c.onchange=VHDBEIXHTA_Valid;
if(c=Ctrl('VHDBEIXHTA')) c.onfocus=VHDBEIXHTA_OnFocus;
if(c=Ctrl('VHDBEIXHTA')) c.onblur=VHDBEIXHTA_OnBlur;
if(c=Ctrl('NOGBUOIVWB')) c.onblur=NOGBUOIVWB_Valid;
if(c=Ctrl('NOGBUOIVWB')) c.onfocus=NOGBUOIVWB_OnFocus;
c=Ctrl('ZSRVHHSRRD');
if ( ! (Empty(c))) {
c[0].onclick=ZSRVHHSRRD_Valid;
c[1].onclick=ZSRVHHSRRD_Valid;
}
if(c=Ctrl('HBSWFKBFZJ')) c.onblur=HBSWFKBFZJ_Valid;
if(c=Ctrl('HBSWFKBFZJ')) c.onfocus=HBSWFKBFZJ_OnFocus;
if(c=Ctrl('MPXBUDNRPY')) c.onblur=MPXBUDNRPY_Valid;
if(c=Ctrl('MPXBUDNRPY')) c.onfocus=MPXBUDNRPY_OnFocus;
if(c=Ctrl('YDHXQFESNA')) c.onblur=YDHXQFESNA_Valid;
if(c=Ctrl('YDHXQFESNA')) c.onfocus=YDHXQFESNA_OnFocus;
if(c=Ctrl('SBDBIBIUBZ')) c.onblur=SBDBIBIUBZ_Valid;
if(c=Ctrl('SBDBIBIUBZ')) c.onfocus=SBDBIBIUBZ_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('SBDBIBIUBZ')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('NCHAEUMUPJ')) c.onblur=NCHAEUMUPJ_Valid;
if(c=Ctrl('NCHAEUMUPJ')) c.onfocus=NCHAEUMUPJ_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('NCHAEUMUPJ')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('NICAEATMFV')) c.onblur=NICAEATMFV_Valid;
if(c=Ctrl('NICAEATMFV')) c.onfocus=NICAEATMFV_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('NICAEATMFV')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('WYJHXYCTSP')) c.onblur=WYJHXYCTSP_Valid;
if(c=Ctrl('WYJHXYCTSP')) c.onfocus=WYJHXYCTSP_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('WYJHXYCTSP')) c.onkeypress=CheckDateChar;
}
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
FocusFirstComponent.otherwise={"page_1":["FFEEVEUPBF"]};
function Help() {
windowOpenForeground('../doc/arpg_moddeleghe_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_ragione=a[0];
w_datarett=a[1];
w_olddata=a[2];
w_oldintest=a[3];
w_xcfestero=a[4];
w_xcodfisc=a[5];
w_xcognome=a[6];
w_xnome=a[7];
w_xsesso=a[8];
w_newintest=a[9];
w_xragnew=a[10];
w_xtipopers=a[11];
w_oldprog=a[12];
w_oldidbase=a[13];
w_oldrappo=a[14];
w_oldnumrig=a[15];
w_oldfile=a[16];
w_tipochg=a[17];
w_xnascomun=a[18];
w_xtipinter=a[19];
w_xnasstato=a[20];
w_xdatnasc=a[21];
w_xdessta=a[22];
w_olddatac=a[23];
w_idesito=a[24];
w_newdatec=a[25];
w_newdate=a[26];
w_xdesccit=a[27];
w_xpaese=a[28];
w_xprovincia=a[29];
w_xcap=a[30];
w_xragold=a[31];
w_oldappo=a[32];
o_oldintest=w_oldintest[1];
w_oldintest=w_oldintest[0];
o_xnasstato=w_xnasstato[1];
w_xnasstato=w_xnasstato[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_moddeleghe',m_cSelectedPage);
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
l_bEnabled= ! (Ne(1,1)) || IsDisabledByStateDriver('olddata');
SetDisabled(Ctrl('QLKRKJTVJT'),l_bEnabled);
l_bEnabled= ! (Ne(1,1)) || IsDisabledByStateDriver('oldintest');
SetDisabled(Ctrl('NEAUUYCSRF'),l_bEnabled);
SetDisabled(Ctrl('NEAUUYCSRF_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(w_tipochg,'M')) || IsDisabledByStateDriver('xcodfisc');
SetDisabled(Ctrl('KXGHBTYQDK'),l_bEnabled);
l_bEnabled= ! (Eq(w_xtipopers,'P') && Eq(w_tipochg,'M')) || IsDisabledByStateDriver('xcognome');
SetDisabled(Ctrl('ZLEFBXLUTT'),l_bEnabled);
l_bEnabled= ! (Eq(w_xtipopers,'P') && Eq(w_tipochg,'M')) || IsDisabledByStateDriver('xnome');
SetDisabled(Ctrl('TRZRNHUQSZ'),l_bEnabled);
l_bEnabled= ! (Eq(w_xtipopers,'P') && Eq(w_tipochg,'M')) || IsDisabledByStateDriver('xsesso');
SetDisabled(Ctrl('VHDBEIXHTA'),l_bEnabled);
l_bEnabled= ! (Eq(w_tipochg,'C')) || IsDisabledByStateDriver('newintest');
SetDisabled(Ctrl('NOGBUOIVWB'),l_bEnabled);
SetDisabled(Ctrl('NOGBUOIVWB_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(w_xtipopers,'P') && Eq(w_tipochg,'M')) || IsDisabledByStateDriver('xnascomun');
SetDisabled(Ctrl('HBSWFKBFZJ'),l_bEnabled);
SetDisabled(Ctrl('HBSWFKBFZJ_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(w_xtipopers,'P') && Eq(w_tipochg,'M')) || IsDisabledByStateDriver('xtipinter');
SetDisabled(Ctrl('MPXBUDNRPY'),l_bEnabled);
l_bEnabled= ! (Eq(w_xtipopers,'P') && Eq(w_tipochg,'M')) || IsDisabledByStateDriver('xnasstato');
SetDisabled(Ctrl('YDHXQFESNA'),l_bEnabled);
SetDisabled(Ctrl('YDHXQFESNA_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(w_xtipopers,'P') && Eq(w_tipochg,'M')) || IsDisabledByStateDriver('xdatnasc');
SetDisabled(Ctrl('SBDBIBIUBZ'),l_bEnabled);
l_bEnabled= ! (Ne(1,1)) || IsDisabledByStateDriver('olddatac');
SetDisabled(Ctrl('NCHAEUMUPJ'),l_bEnabled);
DisableUI();
HideControlsUnderCondition();
ObligatoryControlsUnderCondition();
// * --- Area Manuale = UI - Enable Controls End
// * --- arpg_moddeleghe
Link_NEAUUYCSRF()
o_oldintest=''
Calculate()
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
function Set_ragione(ctrlValue,kmode,e) {
if (Ne(w_ragione,ctrlValue)) {
var ctl = _GetCtl(e,'FFEEVEUPBF');
if (_tracker.goon(ctl,ctrlValue)) {
w_ragione=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FFEEVEUPBF',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_datarett(ctrlValue,kmode,e) {
if (Ne(w_datarett,ctrlValue)) {
var ctl = _GetCtl(e,'JIYGZCDTPQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_datarett=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JIYGZCDTPQ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_olddata(ctrlValue,kmode,e) {
if (Ne(w_olddata,ctrlValue)) {
var ctl = _GetCtl(e,'QLKRKJTVJT');
if (_tracker.goon(ctl,ctrlValue)) {
w_olddata=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QLKRKJTVJT',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_oldintest(ctrlValue,kmode,e) {
if (Ne(w_oldintest,ctrlValue)) {
var ctl = _GetCtl(e,'NEAUUYCSRF');
if (_tracker.goon(ctl,ctrlValue)) {
w_oldintest=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NEAUUYCSRF',0);
if (l_bResult) {
l_bResult=Link_NEAUUYCSRF(kmode);
if ( ! (l_bResult)) {
w_oldintest=HtW('','C');
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
function Set_xcfestero(ctrlValue,kmode,e) {
if (Ne(w_xcfestero,ctrlValue)) {
var ctl = _GetCtl(e,'WVHOQYPKFE');
if (_tracker.goon(ctl,ctrlValue)) {
w_xcfestero=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WVHOQYPKFE',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_xcodfisc(ctrlValue,kmode,e) {
if (Ne(w_xcodfisc,ctrlValue)) {
var ctl = _GetCtl(e,'KXGHBTYQDK');
if (_tracker.goon(ctl,ctrlValue)) {
w_xcodfisc=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KXGHBTYQDK',0);
if (l_bResult) {
l_bResult=arfn_chkcodfis(w_xcodfisc,w_xpaese,w_xcfestero);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='11921223220';
m_cLastMsgError='';
}
if ( ! (l_bResult)) {
w_xcodfisc=HtW('','C');
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
function Set_xcognome(ctrlValue,kmode,e) {
if (Ne(w_xcognome,ctrlValue)) {
var ctl = _GetCtl(e,'ZLEFBXLUTT');
if (_tracker.goon(ctl,ctrlValue)) {
w_xcognome=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZLEFBXLUTT',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',26,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_xnome(ctrlValue,kmode,e) {
if (Ne(w_xnome,ctrlValue)) {
var ctl = _GetCtl(e,'TRZRNHUQSZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_xnome=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TRZRNHUQSZ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',25,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_xsesso(ctrlValue,kmode,e) {
if (Ne(w_xsesso,ctrlValue)) {
var ctl = _GetCtl(e,'VHDBEIXHTA');
if (_tracker.goon(ctl,ctrlValue)) {
w_xsesso=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VHDBEIXHTA',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_newintest(ctrlValue,kmode,e) {
if (Ne(w_newintest,ctrlValue)) {
var ctl = _GetCtl(e,'NOGBUOIVWB');
if (_tracker.goon(ctl,ctrlValue)) {
w_newintest=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NOGBUOIVWB',0);
if (l_bResult) {
l_bResult=Link_NOGBUOIVWB(kmode);
if ( ! (l_bResult)) {
w_newintest=HtW('','C');
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
function Set_xdatnasc(ctrlValue,kmode,e) {
if (Ne(w_xdatnasc,ctrlValue)) {
var ctl = _GetCtl(e,'SBDBIBIUBZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_xdatnasc=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SBDBIBIUBZ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_olddatac(ctrlValue,kmode,e) {
if (Ne(w_olddatac,ctrlValue)) {
var ctl = _GetCtl(e,'NCHAEUMUPJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_olddatac=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NCHAEUMUPJ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_newdatec(ctrlValue,kmode,e) {
if (Ne(w_newdatec,ctrlValue)) {
var ctl = _GetCtl(e,'NICAEATMFV');
if (_tracker.goon(ctl,ctrlValue)) {
w_newdatec=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NICAEATMFV',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_xnasstato(ctrlValue,kmode,e) {
if (Ne(w_xnasstato,ctrlValue)) {
var ctl = _GetCtl(e,'YDHXQFESNA');
if (_tracker.goon(ctl,ctrlValue)) {
w_xnasstato=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YDHXQFESNA',0);
if (l_bResult) {
l_bResult=Link_YDHXQFESNA(kmode);
if ( ! (l_bResult)) {
w_xnasstato=HtW('','C');
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
function Set_newdate(ctrlValue,kmode,e) {
if (Ne(w_newdate,ctrlValue)) {
var ctl = _GetCtl(e,'WYJHXYCTSP');
if (_tracker.goon(ctl,ctrlValue)) {
w_newdate=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WYJHXYCTSP',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_tipochg(ctrlValue,kmode,e) {
if (Ne(w_tipochg,ctrlValue)) {
var ctl = _GetCtl(e,'ZSRVHHSRRD');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipochg=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZSRVHHSRRD',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_xtipinter(ctrlValue,kmode,e) {
if (Ne(w_xtipinter,ctrlValue)) {
var ctl = _GetCtl(e,'MPXBUDNRPY');
if (_tracker.goon(ctl,ctrlValue)) {
w_xtipinter=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MPXBUDNRPY',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_xnascomun(ctrlValue,kmode,e) {
if (Ne(w_xnascomun,ctrlValue)) {
var ctl = _GetCtl(e,'HBSWFKBFZJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_xnascomun=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HBSWFKBFZJ',0);
if (l_bResult) {
l_bResult=Link_HBSWFKBFZJ(kmode);
if ( ! (l_bResult)) {
w_xnascomun=HtW('','C');
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
if ((Ne(o_oldintest,w_oldintest))) {
w_xtipopers='P';
}
if ((Ne(o_oldintest,w_oldintest))) {
l_bTmpRes=Link_HBSWFKBFZJ(null);
}
if ((Ne(o_oldintest,w_oldintest))) {
l_bTmpRes=Link_YDHXQFESNA(null);
}
if ((Ne(o_xnasstato,w_xnasstato))) {
Calculation_ZUWRKVWAHP();
}
w_oldappo=w_oldintest;
l_bTmpRes=Link_EEESEXUZFK(null);
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function Calculation_ZUWRKVWAHP() {
w_xtipinter=(Empty(w_xnasstato)?w_xtipinter:'EE');
}
function SaveDependsOn() {
o_oldintest=w_oldintest;
o_xnasstato=w_xnasstato;
}
function SaveLabelDependsOn() {
}
function Link_NEAUUYCSRF(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_oldintest);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_oldintest,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('NEAUUYCSRF');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_oldintest=l_Appl.GetStringValue('CONNES',16,0);
w_xragold=l_Appl.GetStringValue('RAGSOC',70,0);
} else {
Link_NEAUUYCSRF_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_NEAUUYCSRF';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_NEAUUYCSRF();
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
function Link_NEAUUYCSRF_Blank() {
w_oldintest='';
w_xragold='';
}
function LOpt_NEAUUYCSRF() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('NEAUUYCSRF','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NEAUUYCSRF'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('195812931'),'C'));
return l_oWv;
}
function Link_NOGBUOIVWB(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_newintest);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_newintest,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('NOGBUOIVWB');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_newintest=l_Appl.GetStringValue('CONNES',16,0);
w_xragnew=l_Appl.GetStringValue('RAGSOC',70,0);
} else {
Link_NOGBUOIVWB_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_NOGBUOIVWB';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_NOGBUOIVWB();
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
function Link_NOGBUOIVWB_Blank() {
w_newintest='';
w_xragnew='';
}
function LOpt_NOGBUOIVWB() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('NOGBUOIVWB','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NOGBUOIVWB'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('195812931'),'C'));
return l_oWv;
}
function Link_HBSWFKBFZJ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_xnascomun);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_xnascomun,40,0);
l_Appl.SetFields('CITTA,PROV');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('HBSWFKBFZJ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_xnascomun=l_Appl.GetStringValue('CITTA',40,0);
w_xtipinter=l_Appl.GetStringValue('PROV',2,0);
} else {
Link_HBSWFKBFZJ_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_HBSWFKBFZJ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_HBSWFKBFZJ();
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
function Link_HBSWFKBFZJ_Blank() {
w_xtipinter='';
}
function LOpt_HBSWFKBFZJ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('HBSWFKBFZJ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['HBSWFKBFZJ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('117818419'),'C'));
return l_oWv;
}
function Link_YDHXQFESNA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_xnasstato);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('DESCRI',w_xnasstato,40,0);
l_Appl.SetFields('DESCRI');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('YDHXQFESNA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_xnasstato=l_Appl.GetStringValue('DESCRI',40,0);
} else {
Link_YDHXQFESNA_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_YDHXQFESNA';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_YDHXQFESNA();
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
function Link_YDHXQFESNA_Blank() {
w_xnasstato='';
}
function LOpt_YDHXQFESNA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('DESCRI','C'));
l_oWv.setValue('LinkedField',WtA('DESCRI','C'));
l_oWv.setValue('UID',WtA('YDHXQFESNA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['YDHXQFESNA'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Link_EEESEXUZFK(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_oldappo);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_oldappo,16,0);
l_Appl.SetFields('CONNES,RAGSOC,CODFISC,NASCOMUN,DATANASC,SESSO,NASSTATO,COGNOME,NOME,CFESTERO,DESCCIT,PAESE,PROVINCIA,CAP,TIPINTER');
l_Appl.SetTypes('C,C,C,C,D,C,C,C,C,N,C,C,C,C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('EEESEXUZFK');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_oldappo=l_Appl.GetStringValue('CONNES',16,0);
w_xragold=l_Appl.GetStringValue('RAGSOC',70,0);
w_xcodfisc=l_Appl.GetStringValue('CODFISC',16,0);
w_xnascomun=l_Appl.GetStringValue('NASCOMUN',40,0);
w_xdatnasc=l_Appl.GetDateValue('DATANASC',8,0);
w_xdatnasc=DateFromApplet(w_xdatnasc);
w_xsesso=l_Appl.GetStringValue('SESSO',1,0);
w_xnasstato=l_Appl.GetStringValue('NASSTATO',40,0);
w_xcognome=l_Appl.GetStringValue('COGNOME',26,0);
w_xnome=l_Appl.GetStringValue('NOME',25,0);
w_xcfestero=l_Appl.GetDoubleValue('CFESTERO',1,0);
w_xdesccit=l_Appl.GetStringValue('DESCCIT',30,0);
w_xpaese=l_Appl.GetStringValue('PAESE',3,0);
w_xprovincia=l_Appl.GetStringValue('PROVINCIA',2,0);
w_xcap=l_Appl.GetStringValue('CAP',9,0);
w_xtipinter=l_Appl.GetStringValue('TIPINTER',2,0);
} else {
Link_EEESEXUZFK_Blank();
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
function Link_EEESEXUZFK_Blank() {
w_oldappo='';
w_xragold='';
w_xcodfisc='';
w_xnascomun='';
w_xdatnasc=NullDate();
w_xsesso='';
w_xnasstato='';
w_xcognome='';
w_xnome='';
w_xcfestero=0;
w_xdesccit='';
w_xpaese='';
w_xprovincia='';
w_xcap='';
w_xtipinter='';
}
function LOpt_EEESEXUZFK() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('EEESEXUZFK','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['EEESEXUZFK'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('195812931'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'NEAUUYCSRF')) {
last_focused_comp=GetLastFocusedElementOfLink('NEAUUYCSRF');
function SetMethod_NEAUUYCSRF() {
Set_oldintest(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_NEAUUYCSRF();
} else {
setTimeout(SetMethod_NEAUUYCSRF,1);
}
bResult=true;
}
if (Eq(varName,'NOGBUOIVWB')) {
last_focused_comp=GetLastFocusedElementOfLink('NOGBUOIVWB');
function SetMethod_NOGBUOIVWB() {
Set_newintest(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_NOGBUOIVWB();
} else {
setTimeout(SetMethod_NOGBUOIVWB,1);
}
bResult=true;
}
if (Eq(varName,'HBSWFKBFZJ')) {
last_focused_comp=GetLastFocusedElementOfLink('HBSWFKBFZJ');
function SetMethod_HBSWFKBFZJ() {
Set_xnascomun(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_HBSWFKBFZJ();
} else {
setTimeout(SetMethod_HBSWFKBFZJ,1);
}
bResult=true;
}
if (Eq(varName,'YDHXQFESNA')) {
last_focused_comp=GetLastFocusedElementOfLink('YDHXQFESNA');
function SetMethod_YDHXQFESNA() {
Set_xnasstato(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_YDHXQFESNA();
} else {
setTimeout(SetMethod_YDHXQFESNA,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'NEAUUYCSRF')) {
return [Ctrl('NEAUUYCSRF')];
}
if (Eq(varName,'NOGBUOIVWB')) {
return [Ctrl('NOGBUOIVWB')];
}
if (Eq(varName,'HBSWFKBFZJ')) {
return [Ctrl('HBSWFKBFZJ')];
}
if (Eq(varName,'YDHXQFESNA')) {
return [Ctrl('YDHXQFESNA')];
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
if ( ! (_ChkObl('FFEEVEUPBF',1))) {
_SignErr('FFEEVEUPBF');
m_cLastWorkVarErrorMsg='ragione';
l_bResult=false;
w_ragione=HtW('','C');
} else if ( ! (_ChkObl('JIYGZCDTPQ',1))) {
_SignErr('JIYGZCDTPQ');
m_cLastWorkVarErrorMsg='datarett';
l_bResult=false;
w_datarett=HtW('','D');
} else if ((Ne(1,1)) && ( ! (_ChkObl('QLKRKJTVJT',1)))) {
_SignErr('QLKRKJTVJT');
m_cLastWorkVarErrorMsg='olddata';
l_bResult=false;
w_olddata=HtW('','D');
} else if ((Ne(1,1)) && ( ! (_ChkObl('NEAUUYCSRF',1)))) {
_SignErr('NEAUUYCSRF');
m_cLastWorkVarErrorMsg='oldintest';
l_bResult=false;
w_oldintest=HtW('','C');
} else if ( ! (_ChkObl('WVHOQYPKFE',1))) {
_SignErr('WVHOQYPKFE');
m_cLastWorkVarErrorMsg='10034405761';
l_bResult=false;
w_xcfestero=0;
} else if ((Eq(w_tipochg,'M')) && (( ! (_ChkObl('KXGHBTYQDK',1))) || ( ! (arfn_chkcodfis(w_xcodfisc,w_xpaese,w_xcfestero))))) {
_SignErr('KXGHBTYQDK');
m_cLastWorkVarErrorMsg='11921223220';
l_bResult=false;
w_xcodfisc=HtW('','C');
} else if ((Eq(w_xtipopers,'P') && Eq(w_tipochg,'M')) && ( ! (_ChkObl('ZLEFBXLUTT',1)))) {
_SignErr('ZLEFBXLUTT');
m_cLastWorkVarErrorMsg='1816546867';
l_bResult=false;
w_xcognome=HtW('','C');
} else if ((Eq(w_xtipopers,'P') && Eq(w_tipochg,'M')) && ( ! (_ChkObl('TRZRNHUQSZ',1)))) {
_SignErr('TRZRNHUQSZ');
m_cLastWorkVarErrorMsg='443454';
l_bResult=false;
w_xnome=HtW('','C');
} else if ((Eq(w_xtipopers,'P') && Eq(w_tipochg,'M')) && ( ! (_ChkObl('VHDBEIXHTA',1)))) {
_SignErr('VHDBEIXHTA');
m_cLastWorkVarErrorMsg='7776675';
l_bResult=false;
w_xsesso=HtW('','C');
} else if ((Eq(w_tipochg,'C')) && ( ! (_ChkObl('NOGBUOIVWB',1)))) {
_SignErr('NOGBUOIVWB');
m_cLastWorkVarErrorMsg='newintest';
l_bResult=false;
w_newintest=HtW('','C');
} else if ( ! (_ChkObl('ZSRVHHSRRD',1))) {
_SignErr('ZSRVHHSRRD');
m_cLastWorkVarErrorMsg='tipochg';
l_bResult=false;
w_tipochg=HtW('','C');
} else if ((Eq(w_xtipopers,'P') && Eq(w_tipochg,'M')) && ( ! (_ChkObl('HBSWFKBFZJ',1)))) {
_SignErr('HBSWFKBFZJ');
m_cLastWorkVarErrorMsg='12123334500';
l_bResult=false;
w_xnascomun=HtW('','C');
} else if ((Eq(w_xtipopers,'P') && Eq(w_tipochg,'M')) && ( ! (_ChkObl('MPXBUDNRPY',1)))) {
_SignErr('MPXBUDNRPY');
m_cLastWorkVarErrorMsg='10095365423';
l_bResult=false;
w_xtipinter=HtW('','C');
} else if ((Eq(w_xtipopers,'P') && Eq(w_tipochg,'M')) && ( ! (_ChkObl('YDHXQFESNA',1)))) {
_SignErr('YDHXQFESNA');
m_cLastWorkVarErrorMsg='12123284333';
l_bResult=false;
w_xnasstato=HtW('','C');
} else if ((Eq(w_xtipopers,'P') && Eq(w_tipochg,'M')) && ( ! (_ChkObl('SBDBIBIUBZ',1)))) {
_SignErr('SBDBIBIUBZ');
m_cLastWorkVarErrorMsg='11777527481';
l_bResult=false;
w_xdatnasc=HtW('','D');
} else if ((Ne(1,1)) && ( ! (_ChkObl('NCHAEUMUPJ',1)))) {
_SignErr('NCHAEUMUPJ');
m_cLastWorkVarErrorMsg='olddatac';
l_bResult=false;
w_olddatac=HtW('','D');
} else if ( ! (_ChkObl('NICAEATMFV',1))) {
_SignErr('NICAEATMFV');
m_cLastWorkVarErrorMsg='newdatec';
l_bResult=false;
w_newdatec=HtW('','D');
} else if ( ! (_ChkObl('WYJHXYCTSP',1))) {
_SignErr('WYJHXYCTSP');
m_cLastWorkVarErrorMsg='newdate';
l_bResult=false;
w_newdate=HtW('','D');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('JIYGZCDTPQ_ZOOM',lc)) {
return 0;
}
if (Eq('NEAUUYCSRF_ZOOM',lc)) {
return 0;
}
if (Eq('NEAUUYCSRF',lc)) {
return 0;
}
if (Eq('NOGBUOIVWB_ZOOM',lc)) {
return 1;
}
if (Eq('NOGBUOIVWB',lc)) {
return 1;
}
if (Eq('HBSWFKBFZJ_ZOOM',lc)) {
return 2;
}
if (Eq('HBSWFKBFZJ',lc)) {
return 2;
}
if (Eq('YDHXQFESNA_ZOOM',lc)) {
return 3;
}
if (Eq('YDHXQFESNA',lc)) {
return 3;
}
if (Eq('NICAEATMFV_ZOOM',lc)) {
return 4;
}
if (Eq('WYJHXYCTSP_ZOOM',lc)) {
return 4;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_NEAUUYCSRF();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_NOGBUOIVWB();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_HBSWFKBFZJ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,3)) {
l_oWv=LOpt_YDHXQFESNA();
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
l_oWv.setValue('ragione',WtA(w_ragione,'C'));
l_oWv.setValue('datarett',WtA(w_datarett,'D'));
l_oWv.setValue('olddata',WtA(w_olddata,'D'));
l_oWv.setValue('oldintest',WtA(w_oldintest,'C'));
l_oWv.setValue('xcfestero',WtA(w_xcfestero,'N'));
l_oWv.setValue('xcodfisc',WtA(w_xcodfisc,'C'));
l_oWv.setValue('xcognome',WtA(w_xcognome,'C'));
l_oWv.setValue('xnome',WtA(w_xnome,'C'));
l_oWv.setValue('xsesso',WtA(w_xsesso,'C'));
l_oWv.setValue('newintest',WtA(w_newintest,'C'));
l_oWv.setValue('xragnew',WtA(w_xragnew,'C'));
l_oWv.setValue('xtipopers',WtA(w_xtipopers,'C'));
l_oWv.setValue('oldprog',WtA(w_oldprog,'C'));
l_oWv.setValue('oldidbase',WtA(w_oldidbase,'C'));
l_oWv.setValue('oldrappo',WtA(w_oldrappo,'C'));
l_oWv.setValue('oldnumrig',WtA(w_oldnumrig,'N'));
l_oWv.setValue('oldfile',WtA(w_oldfile,'C'));
l_oWv.setValue('tipochg',WtA(w_tipochg,'C'));
l_oWv.setValue('xnascomun',WtA(w_xnascomun,'C'));
l_oWv.setValue('xtipinter',WtA(w_xtipinter,'C'));
l_oWv.setValue('xnasstato',WtA(w_xnasstato,'C'));
l_oWv.setValue('xdatnasc',WtA(w_xdatnasc,'D'));
l_oWv.setValue('xdessta',WtA(w_xdessta,'C'));
l_oWv.setValue('olddatac',WtA(w_olddatac,'D'));
l_oWv.setValue('idesito',WtA(w_idesito,'C'));
l_oWv.setValue('newdatec',WtA(w_newdatec,'D'));
l_oWv.setValue('newdate',WtA(w_newdate,'D'));
l_oWv.setValue('xdesccit',WtA(w_xdesccit,'C'));
l_oWv.setValue('xpaese',WtA(w_xpaese,'C'));
l_oWv.setValue('xprovincia',WtA(w_xprovincia,'C'));
l_oWv.setValue('xcap',WtA(w_xcap,'C'));
l_oWv.setValue('xragold',WtA(w_xragold,'C'));
l_oWv.setValue('oldappo',WtA(w_oldappo,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["ragione","datarett","olddata","oldintest","xcfestero","xcodfisc","xcognome","xnome","xsesso","newintest","xragnew","xtipopers","oldprog","oldidbase","oldrappo","oldnumrig","oldfile","tipochg","xnascomun","xtipinter","xnasstato","xdatnasc","xdessta","olddatac","idesito","newdatec","newdate","xdesccit","xpaese","xprovincia","xcap","xragold","oldappo"];
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
if (Eq(w_datarett,SystemDate()) && Ne(opener.w_datarett,null)) {
TransferBetweenWindows(opener,'w_datarett',null,'Set_datarett');
}
if (Empty(w_olddata) && Ne(opener.w_olddata,null)) {
TransferBetweenWindows(opener,'w_olddata',null,'Set_olddata');
}
if (Empty(w_oldintest) && Ne(opener.w_oldintest,null)) {
TransferBetweenWindows(opener,'w_oldintest',null,'Set_oldintest');
}
if (Empty(w_newintest) && Ne(opener.w_newintest,null)) {
TransferBetweenWindows(opener,'w_newintest',null,'Set_newintest');
}
if (Empty(w_xragnew) && Ne(opener.w_xragnew,null)) {
TransferBetweenWindows(opener,'w_xragnew','w_xragnew');
}
if (Empty(w_oldprog) && Ne(opener.w_oldprog,null)) {
TransferBetweenWindows(opener,'w_oldprog','w_oldprog');
}
if (Empty(w_oldidbase) && Ne(opener.w_oldidbase,null)) {
TransferBetweenWindows(opener,'w_oldidbase','w_oldidbase');
}
if (Empty(w_oldrappo) && Ne(opener.w_oldrappo,null)) {
TransferBetweenWindows(opener,'w_oldrappo','w_oldrappo');
}
if (Empty(w_oldnumrig) && Ne(opener.w_oldnumrig,null)) {
TransferBetweenWindows(opener,'w_oldnumrig','w_oldnumrig');
}
if (Empty(w_oldfile) && Ne(opener.w_oldfile,null)) {
TransferBetweenWindows(opener,'w_oldfile','w_oldfile');
}
if (Empty(w_olddatac) && Ne(opener.w_olddatac,null)) {
TransferBetweenWindows(opener,'w_olddatac',null,'Set_olddatac');
}
if (Empty(w_newdatec) && Ne(opener.w_newdatec,null)) {
TransferBetweenWindows(opener,'w_newdatec',null,'Set_newdatec');
}
if (Empty(w_newdate) && Ne(opener.w_newdate,null)) {
TransferBetweenWindows(opener,'w_newdate',null,'Set_newdate');
}
if (Empty(w_oldappo) && Ne(opener.w_oldappo,null)) {
TransferBetweenWindows(opener,'w_oldappo','w_oldappo');
}
}
}
m_bCalculating=true;
if (start && Eq(At(',datarett,',pseq),0)) {
w_datarett=SystemDate();
}
Link_NEAUUYCSRF(null);
if (start && Eq(At(',xcfestero,',pseq),0)) {
w_xcfestero=0;
}
Link_NOGBUOIVWB(null);
w_xtipopers='P';
if (start && Eq(At(',tipochg,',pseq),0)) {
w_tipochg='M';
}
Link_HBSWFKBFZJ(null);
Link_YDHXQFESNA(null);
w_oldappo=w_oldintest;
Link_EEESEXUZFK(null);
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
_Obli('ragione',0,'FFEEVEUPBF',false)
_Obli('datarett',2,'JIYGZCDTPQ',false)
_Obli('olddata',2,'QLKRKJTVJT',false)
_Obli('oldintest',0,'NEAUUYCSRF',false)
_Obli('xcfestero',1,'WVHOQYPKFE',false,"10034405761")
_Obli('xcodfisc',0,'KXGHBTYQDK',false,"11921223220")
_Obli('xcognome',0,'ZLEFBXLUTT',false,"1816546867")
_Obli('xnome',0,'TRZRNHUQSZ',false,"443454")
_Obli('xsesso',0,'VHDBEIXHTA',false,"7776675")
_Obli('newintest',0,'NOGBUOIVWB',false)
_Obli('xdatnasc',2,'SBDBIBIUBZ',false,"11777527481")
_Obli('olddatac',2,'NCHAEUMUPJ',false)
_Obli('newdatec',2,'NICAEATMFV',false)
_Obli('xnasstato',0,'YDHXQFESNA',false,"12123284333")
_Obli('newdate',2,'WYJHXYCTSP',false)
_Obli('tipochg',0,'ZSRVHHSRRD',false)
_Obli('xtipinter',0,'MPXBUDNRPY',false,"10095365423")
_Obli('xnascomun',0,'HBSWFKBFZJ',false,"12123334500")
