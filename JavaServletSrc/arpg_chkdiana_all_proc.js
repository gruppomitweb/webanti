function SetControlsValue() {
var c;
var c;
if(c=Ctrl('FCREPJBLHG')) c.value = WtH(w_codinter,'C',11,0,'')
var tmp_UWBJTJCNUU = ToHTag(AsControlValue(w_xragsoc));
if (Ne(e_UWBJTJCNUU,tmp_UWBJTJCNUU)) {
if(c=Ctrl('UWBJTJCNUU')) c.innerHTML=tmp_UWBJTJCNUU;
e_UWBJTJCNUU=tmp_UWBJTJCNUU;
}
if(c=Ctrl('RCFVSQQCNU')) selectCombo(c,w_tipinter,'C')
if(c=Ctrl('LMCBBKUTJY')) c.value = WtH(w_codage,'C',6,0,'')
if(c=Ctrl('VEYKPVUMPQ')) c.value = WtH(w_codcli,'C',16,0,'')
if(c=Ctrl('CNQRKVJUGN')) c.value = WtH(w_ragben,'C',70,0,'!')
if(c=Ctrl('HJLJFAMGNR')) c.value = WtH(w_DaData,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('XWZHWTENET')) c.value = WtH(w_AData,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('HBWDBPTGKK')) c.value = WtH(w_DaDataReg,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('WTEIEHYBUM')) c.value = WtH(w_ADataReg,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('YJWPZAWNZJ')) selectRadio(c,w_tipoarch,'C')
if(c=Ctrl('QNMKJLGOKW')) selectCombo(c,w_flgrae,'C')
if(c=Ctrl('ACJYNBGGGK')) ChkboxCheckUncheck(c,'S',w_flgope)
if(c=Ctrl('ACJYNBGGGK')) ChkboxValueAssign(c,'S','N','C',10,0,'')
if(c=Ctrl('UGLRKSBAIN')) ChkboxCheckUncheck(c,'S',w_flgfrz)
if(c=Ctrl('UGLRKSBAIN')) ChkboxValueAssign(c,'S','N','C',10,0,'')
if(c=Ctrl('QXOCQTKHHM')) ChkboxCheckUncheck(c,'S',w_flgrap)
if(c=Ctrl('QXOCQTKHHM')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('YKZIVVFLHM')) selectCombo(c,w_tiprap,'C')
if(c=Ctrl('MPZNTAOLOD')) ChkboxCheckUncheck(c,'S',w_flgtit)
if(c=Ctrl('MPZNTAOLOD')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('BGNWNQZSMR')) selectCombo(c,w_tiptip,'C')
if(c=Ctrl('BHRJFGYNWO')) ChkboxCheckUncheck(c,'S',w_flgint)
if(c=Ctrl('BHRJFGYNWO')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('VIRLZRRHIQ')) ChkboxCheckUncheck(c,'S',w_flgdel)
if(c=Ctrl('VIRLZRRHIQ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('LJVZZPXJUZ')) ChkboxCheckUncheck(c,'S',w_flgchk)
if(c=Ctrl('LJVZZPXJUZ')) ChkboxValueAssign(c,'S','N','C',10,0,'')
if(c=Ctrl('DRCOVPYYCV')) ChkboxCheckUncheck(c,'S',w_flgsto)
if(c=Ctrl('DRCOVPYYCV')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('BAPCIYCOIX')) c.value = WtH(w_destfold,'C',80,0,'')
var tmp_UAIBAUYUDZ = ToHTag(AsControlValue(w_xdesage));
if (Ne(e_UAIBAUYUDZ,tmp_UAIBAUYUDZ)) {
if(c=Ctrl('UAIBAUYUDZ')) c.innerHTML=tmp_UAIBAUYUDZ;
e_UAIBAUYUDZ=tmp_UAIBAUYUDZ;
}
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\' name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
var tmp_GOVQOOBBUD = ToHTag(AsControlValue(w_xragcli));
if (Ne(e_GOVQOOBBUD,tmp_GOVQOOBBUD)) {
if(c=Ctrl('GOVQOOBBUD')) c.innerHTML=tmp_GOVQOOBBUD;
e_GOVQOOBBUD=tmp_GOVQOOBBUD;
}
if(c=Ctrl('XPNJJLILLB')) selectCombo(c,w_stoper,'C')
if(c=Ctrl('OKPHQCXKRD')) ChkboxCheckUncheck(c,'S',w_flgxls)
if(c=Ctrl('OKPHQCXKRD')) ChkboxValueAssign(c,'S','N','C',10,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay('LJVZZPXJUZ_DIV',Ne(w_gWebCHK,'S'));
SetDisplay('DRCOVPYYCV_DIV',Eq(w_flgchk,'N'));
SetDisplay(Ctrl('MAYNQUHJSS'),Empty(w_codinter) || Empty(w_tipinter));
SetDisplay(Ctrl('LCFKHGNSPV'),Empty(w_codinter) || Empty(w_tipinter) || (Eq(w_flgchk,'S')));
SetDisplay(Ctrl('FGMOCXNBFY'),true);
SetDisplay(Ctrl('WTUOJUZNCL'),true);
SetDisplay('OKPHQCXKRD_DIV',Ne(w_gWebCHK,'S'));
HideUI();
}
HideUI.lblids["AData"]=['VGTGDVWOBC'];
HideUI.lblids["ADataReg"]=['MXGGWPSZXH'];
HideUI.lblids["DaData"]=['LQTOQIQYKP'];
HideUI.lblids["DaDataReg"]=['ASMHCXBGTS'];
HideUI.lblids["codage"]=['ENFIBHJIYH'];
HideUI.lblids["codcli"]=['LMKGHMEMXE'];
HideUI.lblids["codinter"]=['PMDUYENKWL'];
HideUI.lblids["destfold"]=['OBJZKBQZTK'];
HideUI.lblids["flgope"]=['MBIRXQHNIJ'];
HideUI.lblids["ragben"]=['PNUSYHLNFS'];
HideUI.lblids["tipinter"]=['CCVJTGYXIP'];
HideUI.lblids["tipoarch"]=['USJHXUDNOM'];
function FCREPJBLHG_Valid(e) {
SetActiveField(Ctrl('FCREPJBLHG'),false);
e=(Ne(e,null)?e:window.event);
return Set_codinter(HtW(Ctrl('FCREPJBLHG').value,'C'),null,e);
}
function FCREPJBLHG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FCREPJBLHG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FCREPJBLHG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FCREPJBLHG'),e);
}
function FCREPJBLHG_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('FCREPJBLHG')),'linkview_FCREPJBLHG','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function RCFVSQQCNU_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipinter(HtW(getComboValue(Ctrl('RCFVSQQCNU')),'C'),null,e);
}
function RCFVSQQCNU_OnFocus(e) {
SetActiveField(Ctrl('RCFVSQQCNU'),true);
}
function RCFVSQQCNU_OnBlur(e) {
SetActiveField(Ctrl('RCFVSQQCNU'),false);
}
function LMCBBKUTJY_Valid(e) {
SetActiveField(Ctrl('LMCBBKUTJY'),false);
e=(Ne(e,null)?e:window.event);
return Set_codage(HtW(Ctrl('LMCBBKUTJY').value,'C'),null,e);
}
function LMCBBKUTJY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LMCBBKUTJY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LMCBBKUTJY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LMCBBKUTJY'),e);
}
function LMCBBKUTJY_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('LMCBBKUTJY')),'linkview_LMCBBKUTJY','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function VEYKPVUMPQ_Valid(e) {
SetActiveField(Ctrl('VEYKPVUMPQ'),false);
e=(Ne(e,null)?e:window.event);
return Set_codcli(HtW(Ctrl('VEYKPVUMPQ').value,'C'),null,e);
}
function VEYKPVUMPQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VEYKPVUMPQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VEYKPVUMPQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VEYKPVUMPQ'),e);
}
function VEYKPVUMPQ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('VEYKPVUMPQ')),'linkview_VEYKPVUMPQ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function CNQRKVJUGN_Valid(e) {
SetActiveField(Ctrl('CNQRKVJUGN'),false);
e=(Ne(e,null)?e:window.event);
return Set_ragben(HtW(Ctrl('CNQRKVJUGN').value,'C'),null,e);
}
function CNQRKVJUGN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CNQRKVJUGN'))) {
DisplayErrorMessage();
}
Ctrl('CNQRKVJUGN').value=WtH(w_ragben,'C',70,0,'!');
SetActiveField(Ctrl('CNQRKVJUGN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CNQRKVJUGN'),e);
}
function CNQRKVJUGN_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("!"));
}
function HJLJFAMGNR_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('HJLJFAMGNR'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('HJLJFAMGNR').value=ApplyPictureToDate(Ctrl('HJLJFAMGNR').value,TranslatePicture(datePattern),'HJLJFAMGNR');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('HJLJFAMGNR'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('HJLJFAMGNR');
}
}
}
SetActiveField(Ctrl('HJLJFAMGNR'),false);
e=(Ne(e,null)?e:window.event);
return Set_DaData(HtW(Ctrl('HJLJFAMGNR').value,'D'),null,e) && dateisok;
}
function HJLJFAMGNR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HJLJFAMGNR'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('HJLJFAMGNR'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('HJLJFAMGNR').value=WtH(w_DaData,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('HJLJFAMGNR');
SetActiveField(Ctrl('HJLJFAMGNR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HJLJFAMGNR'),e);
}
function HJLJFAMGNR_ZOOM_Click() {
LaunchCalendar(Ctrl('HJLJFAMGNR'));
}
function XWZHWTENET_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('XWZHWTENET'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('XWZHWTENET').value=ApplyPictureToDate(Ctrl('XWZHWTENET').value,TranslatePicture(datePattern),'XWZHWTENET');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('XWZHWTENET'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('XWZHWTENET');
}
}
}
SetActiveField(Ctrl('XWZHWTENET'),false);
e=(Ne(e,null)?e:window.event);
return Set_AData(HtW(Ctrl('XWZHWTENET').value,'D'),null,e) && dateisok;
}
function XWZHWTENET_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XWZHWTENET'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('XWZHWTENET'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('XWZHWTENET').value=WtH(w_AData,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('XWZHWTENET');
SetActiveField(Ctrl('XWZHWTENET'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XWZHWTENET'),e);
}
function XWZHWTENET_ZOOM_Click() {
LaunchCalendar(Ctrl('XWZHWTENET'));
}
function HBWDBPTGKK_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('HBWDBPTGKK'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('HBWDBPTGKK').value=ApplyPictureToDate(Ctrl('HBWDBPTGKK').value,TranslatePicture(datePattern),'HBWDBPTGKK');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('HBWDBPTGKK'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('HBWDBPTGKK');
}
}
}
SetActiveField(Ctrl('HBWDBPTGKK'),false);
e=(Ne(e,null)?e:window.event);
return Set_DaDataReg(HtW(Ctrl('HBWDBPTGKK').value,'D'),null,e) && dateisok;
}
function HBWDBPTGKK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HBWDBPTGKK'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('HBWDBPTGKK'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('HBWDBPTGKK').value=WtH(w_DaDataReg,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('HBWDBPTGKK');
SetActiveField(Ctrl('HBWDBPTGKK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HBWDBPTGKK'),e);
}
function HBWDBPTGKK_ZOOM_Click() {
LaunchCalendar(Ctrl('HBWDBPTGKK'));
}
function WTEIEHYBUM_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('WTEIEHYBUM'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('WTEIEHYBUM').value=ApplyPictureToDate(Ctrl('WTEIEHYBUM').value,TranslatePicture(datePattern),'WTEIEHYBUM');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('WTEIEHYBUM'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('WTEIEHYBUM');
}
}
}
SetActiveField(Ctrl('WTEIEHYBUM'),false);
e=(Ne(e,null)?e:window.event);
return Set_ADataReg(HtW(Ctrl('WTEIEHYBUM').value,'D'),null,e) && dateisok;
}
function WTEIEHYBUM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WTEIEHYBUM'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('WTEIEHYBUM'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('WTEIEHYBUM').value=WtH(w_ADataReg,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('WTEIEHYBUM');
SetActiveField(Ctrl('WTEIEHYBUM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WTEIEHYBUM'),e);
}
function WTEIEHYBUM_ZOOM_Click() {
LaunchCalendar(Ctrl('WTEIEHYBUM'));
}
function YJWPZAWNZJ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipoarch(HtW(getRadioValue(Ctrl('YJWPZAWNZJ')),'C'),null,e);
}
function QNMKJLGOKW_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgrae(HtW(getComboValue(Ctrl('QNMKJLGOKW')),'C'),null,e);
}
function QNMKJLGOKW_OnFocus(e) {
SetActiveField(Ctrl('QNMKJLGOKW'),true);
}
function QNMKJLGOKW_OnBlur(e) {
SetActiveField(Ctrl('QNMKJLGOKW'),false);
}
function ACJYNBGGGK_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgope(ChkboxValueAssign(Ctrl('ACJYNBGGGK'),'S','N','C',10,0,''),null,e);
}
function ACJYNBGGGK_OnFocus(e) {
SetActiveField(Ctrl('ACJYNBGGGK'),true);
}
function ACJYNBGGGK_OnBlur(e) {
SetActiveField(Ctrl('ACJYNBGGGK'),false);
}
function UGLRKSBAIN_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgfrz(ChkboxValueAssign(Ctrl('UGLRKSBAIN'),'S','N','C',10,0,''),null,e);
}
function UGLRKSBAIN_OnFocus(e) {
SetActiveField(Ctrl('UGLRKSBAIN'),true);
}
function UGLRKSBAIN_OnBlur(e) {
SetActiveField(Ctrl('UGLRKSBAIN'),false);
}
function QXOCQTKHHM_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgrap(ChkboxValueAssign(Ctrl('QXOCQTKHHM'),'S','N','C',1,0,''),null,e);
}
function QXOCQTKHHM_OnFocus(e) {
SetActiveField(Ctrl('QXOCQTKHHM'),true);
}
function QXOCQTKHHM_OnBlur(e) {
SetActiveField(Ctrl('QXOCQTKHHM'),false);
}
function YKZIVVFLHM_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tiprap(HtW(getComboValue(Ctrl('YKZIVVFLHM')),'C'),null,e);
}
function YKZIVVFLHM_OnFocus(e) {
SetActiveField(Ctrl('YKZIVVFLHM'),true);
}
function YKZIVVFLHM_OnBlur(e) {
SetActiveField(Ctrl('YKZIVVFLHM'),false);
}
function MPZNTAOLOD_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgtit(ChkboxValueAssign(Ctrl('MPZNTAOLOD'),'S','N','C',1,0,''),null,e);
}
function MPZNTAOLOD_OnFocus(e) {
SetActiveField(Ctrl('MPZNTAOLOD'),true);
}
function MPZNTAOLOD_OnBlur(e) {
SetActiveField(Ctrl('MPZNTAOLOD'),false);
}
function BGNWNQZSMR_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tiptip(HtW(getComboValue(Ctrl('BGNWNQZSMR')),'C'),null,e);
}
function BGNWNQZSMR_OnFocus(e) {
SetActiveField(Ctrl('BGNWNQZSMR'),true);
}
function BGNWNQZSMR_OnBlur(e) {
SetActiveField(Ctrl('BGNWNQZSMR'),false);
}
function BHRJFGYNWO_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgint(ChkboxValueAssign(Ctrl('BHRJFGYNWO'),'S','N','C',1,0,''),null,e);
}
function BHRJFGYNWO_OnFocus(e) {
SetActiveField(Ctrl('BHRJFGYNWO'),true);
}
function BHRJFGYNWO_OnBlur(e) {
SetActiveField(Ctrl('BHRJFGYNWO'),false);
}
function VIRLZRRHIQ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgdel(ChkboxValueAssign(Ctrl('VIRLZRRHIQ'),'S','N','C',1,0,''),null,e);
}
function VIRLZRRHIQ_OnFocus(e) {
SetActiveField(Ctrl('VIRLZRRHIQ'),true);
}
function VIRLZRRHIQ_OnBlur(e) {
SetActiveField(Ctrl('VIRLZRRHIQ'),false);
}
function LJVZZPXJUZ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgchk(ChkboxValueAssign(Ctrl('LJVZZPXJUZ'),'S','N','C',10,0,''),null,e);
}
function LJVZZPXJUZ_OnFocus(e) {
SetActiveField(Ctrl('LJVZZPXJUZ'),true);
}
function LJVZZPXJUZ_OnBlur(e) {
SetActiveField(Ctrl('LJVZZPXJUZ'),false);
}
function DRCOVPYYCV_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgsto(ChkboxValueAssign(Ctrl('DRCOVPYYCV'),'S','N','C',1,0,''),null,e);
}
function DRCOVPYYCV_OnFocus(e) {
SetActiveField(Ctrl('DRCOVPYYCV'),true);
}
function DRCOVPYYCV_OnBlur(e) {
SetActiveField(Ctrl('DRCOVPYYCV'),false);
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
function href_MAYNQUHJSS() {
if (false || WindowConfirm(Translate('11376555280'))) {
Lancio()
}
}
function href_LCFKHGNSPV() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('m_cAtExit',AsAppletValue(close));
SetHypPar('pFile',AsAppletValue('campione.zip'));
SetHypPar('pCartella',AsAppletValue('flussi'));
SetHypPar('pTipo',AsAppletValue('ZIP'));
SetHypPar('m_cParameterSequence',AsAppletValue('pFile,pCartella,pTipo'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_downloadfile_doc']));
SendData('start','arrt_downloadfile_doc'+'',HParApplet().asString());
}
function href_NACPPABTRW() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function XPNJJLILLB_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_stoper(HtW(getComboValue(Ctrl('XPNJJLILLB')),'C'),null,e);
}
function XPNJJLILLB_OnFocus(e) {
SetActiveField(Ctrl('XPNJJLILLB'),true);
}
function XPNJJLILLB_OnBlur(e) {
SetActiveField(Ctrl('XPNJJLILLB'),false);
}
function href_WTUOJUZNCL() {
var l_oWv = InitWvApplet();
l_oWv.setValue('w_AData',AsAppletValue(w_AData));
l_oWv.setValue('w_codage',AsAppletValue(w_codage));
l_oWv.setValue('w_codcli',AsAppletValue(w_codcli));
l_oWv.setValue('w_codinter',AsAppletValue(w_codinter));
l_oWv.setValue('w_DaData',AsAppletValue(w_DaData));
l_oWv.setValue('w_flgchk',AsAppletValue(w_flgchk));
l_oWv.setValue('w_flgdel',AsAppletValue(w_flgdel));
l_oWv.setValue('w_flgfrz',AsAppletValue(w_flgfrz));
l_oWv.setValue('w_flgint',AsAppletValue(w_flgint));
l_oWv.setValue('w_flgope',AsAppletValue(w_flgope));
l_oWv.setValue('w_flgrae',AsAppletValue(w_flgrae));
l_oWv.setValue('w_flgrap',AsAppletValue(w_flgrap));
l_oWv.setValue('w_flgsto',AsAppletValue(w_flgsto));
l_oWv.setValue('w_flgtit',AsAppletValue(w_flgtit));
l_oWv.setValue('w_ragben',AsAppletValue(w_ragben));
l_oWv.setValue('w_tipinter',AsAppletValue(w_tipinter));
l_oWv.setValue('w_tipoarch',AsAppletValue(w_tipoarch));
l_oWv.setValue('w_tiprap',AsAppletValue(w_tiprap));
l_oWv.setValue('w_tiptit',AsAppletValue(w_tiptip));
l_oWv.setValue('w_destfold',AsAppletValue(w_destfold));
l_oWv.setValue('w_stoper',AsAppletValue(w_stoper));
l_oWv.setValue('w_ADataReg',AsAppletValue(w_ADataReg));
l_oWv.setValue('w_DaDataReg',AsAppletValue(w_DaDataReg));
l_oWv.setValue('w_flgxls',AsAppletValue(w_flgxls));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('w_AData,w_codage,w_codcli,w_codinter,w_DaData,w_flgchk,w_flgdel,w_flgfrz,w_flgint,w_flgope,w_flgrae,w_flgrap,w_flgsto,w_flgtit,w_ragben,w_tipinter,w_tipoarch,w_tiprap,w_tiptit,w_destfold,w_stoper,w_ADataReg,w_DaDataReg,w_flgxls'));
SetLocationHref(null,'arrt_chkdiana_all'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','elaborazione')
}
function OKPHQCXKRD_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgxls(ChkboxValueAssign(Ctrl('OKPHQCXKRD'),'S','N','C',10,0,''),null,e);
}
function OKPHQCXKRD_OnFocus(e) {
SetActiveField(Ctrl('OKPHQCXKRD'),true);
}
function OKPHQCXKRD_OnBlur(e) {
SetActiveField(Ctrl('OKPHQCXKRD'),false);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('FCREPJBLHG')) c.onblur=FCREPJBLHG_Valid;
if(c=Ctrl('FCREPJBLHG')) c.onfocus=FCREPJBLHG_OnFocus;
if(c=Ctrl('RCFVSQQCNU')) c.onchange=RCFVSQQCNU_Valid;
if(c=Ctrl('RCFVSQQCNU')) c.onfocus=RCFVSQQCNU_OnFocus;
if(c=Ctrl('RCFVSQQCNU')) c.onblur=RCFVSQQCNU_OnBlur;
if(c=Ctrl('LMCBBKUTJY')) c.onblur=LMCBBKUTJY_Valid;
if(c=Ctrl('LMCBBKUTJY')) c.onfocus=LMCBBKUTJY_OnFocus;
if(c=Ctrl('VEYKPVUMPQ')) c.onblur=VEYKPVUMPQ_Valid;
if(c=Ctrl('VEYKPVUMPQ')) c.onfocus=VEYKPVUMPQ_OnFocus;
if(c=Ctrl('CNQRKVJUGN')) c.onblur=CNQRKVJUGN_Valid;
if(c=Ctrl('CNQRKVJUGN')) c.onfocus=CNQRKVJUGN_OnFocus;
if(c=Ctrl('CNQRKVJUGN')) c.onkeypress=CheckUpper;
if(c=Ctrl('HJLJFAMGNR')) c.onblur=HJLJFAMGNR_Valid;
if(c=Ctrl('HJLJFAMGNR')) c.onfocus=HJLJFAMGNR_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('HJLJFAMGNR')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('XWZHWTENET')) c.onblur=XWZHWTENET_Valid;
if(c=Ctrl('XWZHWTENET')) c.onfocus=XWZHWTENET_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('XWZHWTENET')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('HBWDBPTGKK')) c.onblur=HBWDBPTGKK_Valid;
if(c=Ctrl('HBWDBPTGKK')) c.onfocus=HBWDBPTGKK_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('HBWDBPTGKK')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('WTEIEHYBUM')) c.onblur=WTEIEHYBUM_Valid;
if(c=Ctrl('WTEIEHYBUM')) c.onfocus=WTEIEHYBUM_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('WTEIEHYBUM')) c.onkeypress=CheckDateChar;
}
c=Ctrl('YJWPZAWNZJ');
if ( ! (Empty(c))) {
c[0].onclick=YJWPZAWNZJ_Valid;
c[1].onclick=YJWPZAWNZJ_Valid;
}
if(c=Ctrl('QNMKJLGOKW')) c.onchange=QNMKJLGOKW_Valid;
if(c=Ctrl('QNMKJLGOKW')) c.onfocus=QNMKJLGOKW_OnFocus;
if(c=Ctrl('QNMKJLGOKW')) c.onblur=QNMKJLGOKW_OnBlur;
if(c=Ctrl('ACJYNBGGGK')) c.onclick=ACJYNBGGGK_Valid;
if(c=Ctrl('ACJYNBGGGK')) c.onfocus=ACJYNBGGGK_OnFocus;
if(c=Ctrl('ACJYNBGGGK')) c.onblur=ACJYNBGGGK_OnBlur;
if(c=Ctrl('UGLRKSBAIN')) c.onclick=UGLRKSBAIN_Valid;
if(c=Ctrl('UGLRKSBAIN')) c.onfocus=UGLRKSBAIN_OnFocus;
if(c=Ctrl('UGLRKSBAIN')) c.onblur=UGLRKSBAIN_OnBlur;
if(c=Ctrl('QXOCQTKHHM')) c.onclick=QXOCQTKHHM_Valid;
if(c=Ctrl('QXOCQTKHHM')) c.onfocus=QXOCQTKHHM_OnFocus;
if(c=Ctrl('QXOCQTKHHM')) c.onblur=QXOCQTKHHM_OnBlur;
if(c=Ctrl('YKZIVVFLHM')) c.onchange=YKZIVVFLHM_Valid;
if(c=Ctrl('YKZIVVFLHM')) c.onfocus=YKZIVVFLHM_OnFocus;
if(c=Ctrl('YKZIVVFLHM')) c.onblur=YKZIVVFLHM_OnBlur;
if(c=Ctrl('MPZNTAOLOD')) c.onclick=MPZNTAOLOD_Valid;
if(c=Ctrl('MPZNTAOLOD')) c.onfocus=MPZNTAOLOD_OnFocus;
if(c=Ctrl('MPZNTAOLOD')) c.onblur=MPZNTAOLOD_OnBlur;
if(c=Ctrl('BGNWNQZSMR')) c.onchange=BGNWNQZSMR_Valid;
if(c=Ctrl('BGNWNQZSMR')) c.onfocus=BGNWNQZSMR_OnFocus;
if(c=Ctrl('BGNWNQZSMR')) c.onblur=BGNWNQZSMR_OnBlur;
if(c=Ctrl('BHRJFGYNWO')) c.onclick=BHRJFGYNWO_Valid;
if(c=Ctrl('BHRJFGYNWO')) c.onfocus=BHRJFGYNWO_OnFocus;
if(c=Ctrl('BHRJFGYNWO')) c.onblur=BHRJFGYNWO_OnBlur;
if(c=Ctrl('VIRLZRRHIQ')) c.onclick=VIRLZRRHIQ_Valid;
if(c=Ctrl('VIRLZRRHIQ')) c.onfocus=VIRLZRRHIQ_OnFocus;
if(c=Ctrl('VIRLZRRHIQ')) c.onblur=VIRLZRRHIQ_OnBlur;
if(c=Ctrl('LJVZZPXJUZ')) c.onclick=LJVZZPXJUZ_Valid;
if(c=Ctrl('LJVZZPXJUZ')) c.onfocus=LJVZZPXJUZ_OnFocus;
if(c=Ctrl('LJVZZPXJUZ')) c.onblur=LJVZZPXJUZ_OnBlur;
if(c=Ctrl('DRCOVPYYCV')) c.onclick=DRCOVPYYCV_Valid;
if(c=Ctrl('DRCOVPYYCV')) c.onfocus=DRCOVPYYCV_OnFocus;
if(c=Ctrl('DRCOVPYYCV')) c.onblur=DRCOVPYYCV_OnBlur;
if(c=Ctrl('BAPCIYCOIX')) c.onblur=BAPCIYCOIX_Valid;
if(c=Ctrl('BAPCIYCOIX')) c.onfocus=BAPCIYCOIX_OnFocus;
if(c=Ctrl('XPNJJLILLB')) c.onchange=XPNJJLILLB_Valid;
if(c=Ctrl('XPNJJLILLB')) c.onfocus=XPNJJLILLB_OnFocus;
if(c=Ctrl('XPNJJLILLB')) c.onblur=XPNJJLILLB_OnBlur;
if(c=Ctrl('OKPHQCXKRD')) c.onclick=OKPHQCXKRD_Valid;
if(c=Ctrl('OKPHQCXKRD')) c.onfocus=OKPHQCXKRD_OnFocus;
if(c=Ctrl('OKPHQCXKRD')) c.onblur=OKPHQCXKRD_OnBlur;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_pMsg),'undefined')) {
w_pMsg.raiseEvent('arpg_chkdiana_all_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_pLog),'undefined')) {
w_pLog.raiseEvent('arpg_chkdiana_all_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["FCREPJBLHG"]};
function Help() {
windowOpenForeground('../doc/arpg_chkdiana_all_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_gIntemediario=a[0];
w_gTipInter=a[1];
w_codinter=a[2];
w_xragsoc=a[3];
w_tipinter=a[4];
w_codage=a[5];
w_codcli=a[6];
w_ragben=a[7];
w_DaData=a[8];
w_AData=a[9];
w_DaDataReg=a[10];
w_ADataReg=a[11];
w_tipoarch=a[12];
w_flgrae=a[13];
w_flgope=a[14];
w_flgfrz=a[15];
w_flgrap=a[16];
w_tiprap=a[17];
w_flgtit=a[18];
w_tiptip=a[19];
w_flgint=a[20];
w_flgdel=a[21];
w_flgchk=a[22];
w_flgsto=a[23];
w_destfold=a[24];
w_xdesage=a[25];
w_gUrlApp=a[26];
w_gAzienda=a[27];
w_gFlgWU=a[28];
w_xragcli=a[29];
w_gWebCHK=a[30];
w_stoper=a[31];
w_flgxls=a[32];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_chkdiana_all',m_cSelectedPage);
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
l_bEnabled= ! (Eq(w_flgrap,'S')) || IsDisabledByStateDriver('tiprap');
SetDisabled(Ctrl('YKZIVVFLHM'),l_bEnabled);
l_bEnabled= ! (Eq(w_flgtit,'S')) || IsDisabledByStateDriver('tiptip');
SetDisabled(Ctrl('BGNWNQZSMR'),l_bEnabled);
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
function Set_flgrap(ctrlValue,kmode,e) {
if (Ne(w_flgrap,ctrlValue)) {
var ctl = _GetCtl(e,'QXOCQTKHHM');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgrap=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QXOCQTKHHM',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgxls(ctrlValue,kmode,e) {
if (Ne(w_flgxls,ctrlValue)) {
var ctl = _GetCtl(e,'OKPHQCXKRD');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgxls=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OKPHQCXKRD',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_codinter(ctrlValue,kmode,e) {
if (Ne(w_codinter,ctrlValue)) {
var ctl = _GetCtl(e,'FCREPJBLHG');
if (_tracker.goon(ctl,ctrlValue)) {
w_codinter=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FCREPJBLHG',0);
if (l_bResult) {
l_bResult=Link_FCREPJBLHG(kmode);
if ( ! (l_bResult)) {
w_codinter=HtW('','C');
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
function Set_tiprap(ctrlValue,kmode,e) {
if (Ne(w_tiprap,ctrlValue)) {
var ctl = _GetCtl(e,'YKZIVVFLHM');
if (_tracker.goon(ctl,ctrlValue)) {
w_tiprap=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YKZIVVFLHM',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_tipinter(ctrlValue,kmode,e) {
if (Ne(w_tipinter,ctrlValue)) {
var ctl = _GetCtl(e,'RCFVSQQCNU');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipinter=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RCFVSQQCNU',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_codage(ctrlValue,kmode,e) {
if (Ne(w_codage,ctrlValue)) {
var ctl = _GetCtl(e,'LMCBBKUTJY');
if (_tracker.goon(ctl,ctrlValue)) {
w_codage=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LMCBBKUTJY',0);
if (l_bResult) {
l_bResult=Link_LMCBBKUTJY(kmode);
if ( ! (l_bResult)) {
w_codage=HtW('','C');
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
function Set_codcli(ctrlValue,kmode,e) {
if (Ne(w_codcli,ctrlValue)) {
var ctl = _GetCtl(e,'VEYKPVUMPQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_codcli=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VEYKPVUMPQ',0);
if (l_bResult) {
l_bResult=Link_VEYKPVUMPQ(kmode);
if ( ! (l_bResult)) {
w_codcli=HtW('','C');
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
function Set_ragben(ctrlValue,kmode,e) {
if (Ne(w_ragben,ctrlValue)) {
var ctl = _GetCtl(e,'CNQRKVJUGN');
if (_tracker.goon(ctl,ctrlValue)) {
w_ragben=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CNQRKVJUGN',0);
DoUpdate(l_bResult);
if(c=Ctrl('CNQRKVJUGN')) c.value = WtH(w_ragben,'C',70,0,'!')
} else {
ctl.value=WtH('','C',70,0,'!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DaData(ctrlValue,kmode,e) {
if (Ne(w_DaData,ctrlValue)) {
var ctl = _GetCtl(e,'HJLJFAMGNR');
if (_tracker.goon(ctl,ctrlValue)) {
w_DaData=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HJLJFAMGNR',0);
if (l_bResult) {
l_bResult=( ! (Empty(w_AData))?Le(w_DaData,w_AData):true);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='DaData';
m_cLastMsgError=AlertErrorMessage('1187078281');
}
if ( ! (l_bResult)) {
w_DaData=HtW('','D');
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
function Set_AData(ctrlValue,kmode,e) {
if (Ne(w_AData,ctrlValue)) {
var ctl = _GetCtl(e,'XWZHWTENET');
if (_tracker.goon(ctl,ctrlValue)) {
w_AData=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XWZHWTENET',0);
if (l_bResult) {
l_bResult=Ge(w_AData,w_DaData);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='AData';
m_cLastMsgError=AlertErrorMessage('1677589740');
}
if ( ! (l_bResult)) {
w_AData=HtW('','D');
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
function Set_DaDataReg(ctrlValue,kmode,e) {
if (Ne(w_DaDataReg,ctrlValue)) {
var ctl = _GetCtl(e,'HBWDBPTGKK');
if (_tracker.goon(ctl,ctrlValue)) {
w_DaDataReg=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HBWDBPTGKK',0);
if (l_bResult) {
l_bResult=( ! (Empty(w_ADataReg))?Le(w_DaDataReg,w_ADataReg):true);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='DaDataReg';
m_cLastMsgError=AlertErrorMessage('1065830827');
}
if ( ! (l_bResult)) {
w_DaDataReg=HtW('','D');
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
function Set_ADataReg(ctrlValue,kmode,e) {
if (Ne(w_ADataReg,ctrlValue)) {
var ctl = _GetCtl(e,'WTEIEHYBUM');
if (_tracker.goon(ctl,ctrlValue)) {
w_ADataReg=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WTEIEHYBUM',0);
if (l_bResult) {
l_bResult=Ge(w_ADataReg,w_DaDataReg);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='ADataReg';
m_cLastMsgError=AlertErrorMessage('12072144219');
}
if ( ! (l_bResult)) {
w_ADataReg=HtW('','D');
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
function Set_tipoarch(ctrlValue,kmode,e) {
if (Ne(w_tipoarch,ctrlValue)) {
var ctl = _GetCtl(e,'YJWPZAWNZJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipoarch=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YJWPZAWNZJ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgrae(ctrlValue,kmode,e) {
if (Ne(w_flgrae,ctrlValue)) {
var ctl = _GetCtl(e,'QNMKJLGOKW');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgrae=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QNMKJLGOKW',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgope(ctrlValue,kmode,e) {
if (Ne(w_flgope,ctrlValue)) {
var ctl = _GetCtl(e,'ACJYNBGGGK');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgope=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ACJYNBGGGK',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgfrz(ctrlValue,kmode,e) {
if (Ne(w_flgfrz,ctrlValue)) {
var ctl = _GetCtl(e,'UGLRKSBAIN');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgfrz=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UGLRKSBAIN',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgsto(ctrlValue,kmode,e) {
if (Ne(w_flgsto,ctrlValue)) {
var ctl = _GetCtl(e,'DRCOVPYYCV');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgsto=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DRCOVPYYCV',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
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
function Set_flgtit(ctrlValue,kmode,e) {
if (Ne(w_flgtit,ctrlValue)) {
var ctl = _GetCtl(e,'MPZNTAOLOD');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgtit=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MPZNTAOLOD',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_tiptip(ctrlValue,kmode,e) {
if (Ne(w_tiptip,ctrlValue)) {
var ctl = _GetCtl(e,'BGNWNQZSMR');
if (_tracker.goon(ctl,ctrlValue)) {
w_tiptip=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BGNWNQZSMR',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgint(ctrlValue,kmode,e) {
if (Ne(w_flgint,ctrlValue)) {
var ctl = _GetCtl(e,'BHRJFGYNWO');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgint=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BHRJFGYNWO',0);
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
var ctl = _GetCtl(e,'VIRLZRRHIQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgdel=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VIRLZRRHIQ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgchk(ctrlValue,kmode,e) {
if (Ne(w_flgchk,ctrlValue)) {
var ctl = _GetCtl(e,'LJVZZPXJUZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgchk=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LJVZZPXJUZ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_stoper(ctrlValue,kmode,e) {
if (Ne(w_stoper,ctrlValue)) {
var ctl = _GetCtl(e,'XPNJJLILLB');
if (_tracker.goon(ctl,ctrlValue)) {
w_stoper=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XPNJJLILLB',0);
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
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function Link_FCREPJBLHG(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_codinter);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODINTER',w_codinter,11,0);
l_Appl.SetFields('CODINTER,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('intermbo');
l_Appl.SetID('FCREPJBLHG');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_codinter=l_Appl.GetStringValue('CODINTER',11,0);
w_xragsoc=l_Appl.GetStringValue('RAGSOC',70,0);
} else {
Link_FCREPJBLHG_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_FCREPJBLHG';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_FCREPJBLHG();
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
function Link_FCREPJBLHG_Blank() {
w_codinter='';
w_xragsoc='';
}
function LOpt_FCREPJBLHG() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('intermbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODINTER','C'));
l_oWv.setValue('LinkedField',WtA('CODINTER','C'));
l_oWv.setValue('UID',WtA('FCREPJBLHG','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['FCREPJBLHG'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11404054622'),'C'));
return l_oWv;
}
function Link_LMCBBKUTJY(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_codage);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODDIP',w_codage,6,0);
l_Appl.SetFields('CODDIP,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetID('LMCBBKUTJY');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_codage=l_Appl.GetStringValue('CODDIP',6,0);
w_xdesage=l_Appl.GetStringValue('DESCRIZ',30,0);
} else {
Link_LMCBBKUTJY_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_LMCBBKUTJY';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_LMCBBKUTJY();
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
function Link_LMCBBKUTJY_Blank() {
w_codage='';
w_xdesage='';
}
function LOpt_LMCBBKUTJY() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODDIP','C'));
l_oWv.setValue('LinkedField',WtA('CODDIP','C'));
l_oWv.setValue('UID',WtA('LMCBBKUTJY','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['LMCBBKUTJY'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11480189617'),'C'));
return l_oWv;
}
function Link_VEYKPVUMPQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_codcli);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_codcli,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('VEYKPVUMPQ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_codcli=l_Appl.GetStringValue('CONNES',16,0);
w_xragcli=l_Appl.GetStringValue('RAGSOC',70,0);
} else {
Link_VEYKPVUMPQ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_VEYKPVUMPQ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_VEYKPVUMPQ();
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
function Link_VEYKPVUMPQ_Blank() {
w_codcli='';
w_xragcli='';
}
function LOpt_VEYKPVUMPQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('VEYKPVUMPQ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['VEYKPVUMPQ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10634962900'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'FCREPJBLHG')) {
last_focused_comp=GetLastFocusedElementOfLink('FCREPJBLHG');
function SetMethod_FCREPJBLHG() {
Set_codinter(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_FCREPJBLHG();
} else {
setTimeout(SetMethod_FCREPJBLHG,1);
}
bResult=true;
}
if (Eq(varName,'LMCBBKUTJY')) {
last_focused_comp=GetLastFocusedElementOfLink('LMCBBKUTJY');
function SetMethod_LMCBBKUTJY() {
Set_codage(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_LMCBBKUTJY();
} else {
setTimeout(SetMethod_LMCBBKUTJY,1);
}
bResult=true;
}
if (Eq(varName,'VEYKPVUMPQ')) {
last_focused_comp=GetLastFocusedElementOfLink('VEYKPVUMPQ');
function SetMethod_VEYKPVUMPQ() {
Set_codcli(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_VEYKPVUMPQ();
} else {
setTimeout(SetMethod_VEYKPVUMPQ,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'FCREPJBLHG')) {
return [Ctrl('FCREPJBLHG')];
}
if (Eq(varName,'LMCBBKUTJY')) {
return [Ctrl('LMCBBKUTJY')];
}
if (Eq(varName,'VEYKPVUMPQ')) {
return [Ctrl('VEYKPVUMPQ')];
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
if ( ! (_ChkObl('FCREPJBLHG',1))) {
_SignErr('FCREPJBLHG');
m_cLastWorkVarErrorMsg='codinter';
l_bResult=false;
w_codinter=HtW('','C');
} else if ( ! (_ChkObl('RCFVSQQCNU',1))) {
_SignErr('RCFVSQQCNU');
m_cLastWorkVarErrorMsg='tipinter';
l_bResult=false;
w_tipinter=HtW('','C');
} else if ( ! (_ChkObl('LMCBBKUTJY',1))) {
_SignErr('LMCBBKUTJY');
m_cLastWorkVarErrorMsg='11547283697';
l_bResult=false;
w_codage=HtW('','C');
} else if ( ! (_ChkObl('VEYKPVUMPQ',1))) {
_SignErr('VEYKPVUMPQ');
m_cLastWorkVarErrorMsg='1823784963';
l_bResult=false;
w_codcli=HtW('','C');
} else if ( ! (_ChkObl('CNQRKVJUGN',1))) {
_SignErr('CNQRKVJUGN');
m_cLastWorkVarErrorMsg='10100391661';
l_bResult=false;
w_ragben=HtW('','C');
} else if (( ! (_ChkObl('HJLJFAMGNR',1))) || ( ! (( ! (Empty(w_AData))?Le(w_DaData,w_AData):true)))) {
_SignErr('HJLJFAMGNR','1187078281');
l_bResult=false;
w_DaData=HtW('','D');
} else if (( ! (_ChkObl('XWZHWTENET',1))) || ( ! (Ge(w_AData,w_DaData)))) {
_SignErr('XWZHWTENET','1677589740');
l_bResult=false;
w_AData=HtW('','D');
} else if (( ! (_ChkObl('HBWDBPTGKK',1))) || ( ! (( ! (Empty(w_ADataReg))?Le(w_DaDataReg,w_ADataReg):true)))) {
_SignErr('HBWDBPTGKK','1065830827');
l_bResult=false;
w_DaDataReg=HtW('','D');
} else if (( ! (_ChkObl('WTEIEHYBUM',1))) || ( ! (Ge(w_ADataReg,w_DaDataReg)))) {
_SignErr('WTEIEHYBUM','12072144219');
l_bResult=false;
w_ADataReg=HtW('','D');
} else if ( ! (_ChkObl('YJWPZAWNZJ',1))) {
_SignErr('YJWPZAWNZJ');
m_cLastWorkVarErrorMsg='tipoarch';
l_bResult=false;
w_tipoarch=HtW('','C');
} else if ( ! (_ChkObl('QNMKJLGOKW',1))) {
_SignErr('QNMKJLGOKW');
m_cLastWorkVarErrorMsg='flgrae';
l_bResult=false;
w_flgrae=HtW('','C');
} else if ( ! (_ChkObl('ACJYNBGGGK',1))) {
_SignErr('ACJYNBGGGK');
m_cLastWorkVarErrorMsg='flgope';
l_bResult=false;
w_flgope='N';
} else if ( ! (_ChkObl('UGLRKSBAIN',1))) {
_SignErr('UGLRKSBAIN');
m_cLastWorkVarErrorMsg='flgfrz';
l_bResult=false;
w_flgfrz='N';
} else if ( ! (_ChkObl('QXOCQTKHHM',1))) {
_SignErr('QXOCQTKHHM');
m_cLastWorkVarErrorMsg='flgrap';
l_bResult=false;
w_flgrap='N';
} else if ((Eq(w_flgrap,'S')) && ( ! (_ChkObl('YKZIVVFLHM',1)))) {
_SignErr('YKZIVVFLHM');
m_cLastWorkVarErrorMsg='tiprap';
l_bResult=false;
w_tiprap=HtW('','C');
} else if ( ! (_ChkObl('MPZNTAOLOD',1))) {
_SignErr('MPZNTAOLOD');
m_cLastWorkVarErrorMsg='flgtit';
l_bResult=false;
w_flgtit='N';
} else if ((Eq(w_flgtit,'S')) && ( ! (_ChkObl('BGNWNQZSMR',1)))) {
_SignErr('BGNWNQZSMR');
m_cLastWorkVarErrorMsg='tiptip';
l_bResult=false;
w_tiptip=HtW('','C');
} else if ( ! (_ChkObl('BHRJFGYNWO',1))) {
_SignErr('BHRJFGYNWO');
m_cLastWorkVarErrorMsg='flgint';
l_bResult=false;
w_flgint='N';
} else if ( ! (_ChkObl('VIRLZRRHIQ',1))) {
_SignErr('VIRLZRRHIQ');
m_cLastWorkVarErrorMsg='flgdel';
l_bResult=false;
w_flgdel='N';
} else if ( ! (_ChkObl('LJVZZPXJUZ',1))) {
_SignErr('LJVZZPXJUZ');
m_cLastWorkVarErrorMsg='flgchk';
l_bResult=false;
w_flgchk='N';
} else if ( ! (_ChkObl('DRCOVPYYCV',1))) {
_SignErr('DRCOVPYYCV');
m_cLastWorkVarErrorMsg='flgsto';
l_bResult=false;
w_flgsto='N';
} else if ( ! (_ChkObl('BAPCIYCOIX',1))) {
_SignErr('BAPCIYCOIX');
m_cLastWorkVarErrorMsg='145008573';
l_bResult=false;
w_destfold=HtW('','C');
} else if ( ! (_ChkObl('XPNJJLILLB',1))) {
_SignErr('XPNJJLILLB');
m_cLastWorkVarErrorMsg='stoper';
l_bResult=false;
w_stoper=HtW('','C');
} else if ( ! (_ChkObl('OKPHQCXKRD',1))) {
_SignErr('OKPHQCXKRD');
m_cLastWorkVarErrorMsg='flgxls';
l_bResult=false;
w_flgxls='N';
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('FCREPJBLHG_ZOOM',lc)) {
return 0;
}
if (Eq('FCREPJBLHG',lc)) {
return 0;
}
if (Eq('LMCBBKUTJY_ZOOM',lc)) {
return 1;
}
if (Eq('LMCBBKUTJY',lc)) {
return 1;
}
if (Eq('VEYKPVUMPQ_ZOOM',lc)) {
return 2;
}
if (Eq('VEYKPVUMPQ',lc)) {
return 2;
}
if (Eq('HJLJFAMGNR_ZOOM',lc)) {
return 3;
}
if (Eq('XWZHWTENET_ZOOM',lc)) {
return 3;
}
if (Eq('HBWDBPTGKK_ZOOM',lc)) {
return 3;
}
if (Eq('WTEIEHYBUM_ZOOM',lc)) {
return 3;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_FCREPJBLHG();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_LMCBBKUTJY();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_VEYKPVUMPQ();
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
l_oWv.setValue('gIntemediario',WtA(w_gIntemediario,'C'));
l_oWv.setValue('gTipInter',WtA(w_gTipInter,'C'));
l_oWv.setValue('codinter',WtA(w_codinter,'C'));
l_oWv.setValue('xragsoc',WtA(w_xragsoc,'C'));
l_oWv.setValue('tipinter',WtA(w_tipinter,'C'));
l_oWv.setValue('codage',WtA(w_codage,'C'));
l_oWv.setValue('codcli',WtA(w_codcli,'C'));
l_oWv.setValue('ragben',WtA(w_ragben,'C'));
l_oWv.setValue('DaData',WtA(w_DaData,'D'));
l_oWv.setValue('AData',WtA(w_AData,'D'));
l_oWv.setValue('DaDataReg',WtA(w_DaDataReg,'D'));
l_oWv.setValue('ADataReg',WtA(w_ADataReg,'D'));
l_oWv.setValue('tipoarch',WtA(w_tipoarch,'C'));
l_oWv.setValue('flgrae',WtA(w_flgrae,'C'));
l_oWv.setValue('flgope',WtA(w_flgope,'C'));
l_oWv.setValue('flgfrz',WtA(w_flgfrz,'C'));
l_oWv.setValue('flgrap',WtA(w_flgrap,'C'));
l_oWv.setValue('tiprap',WtA(w_tiprap,'C'));
l_oWv.setValue('flgtit',WtA(w_flgtit,'C'));
l_oWv.setValue('tiptip',WtA(w_tiptip,'C'));
l_oWv.setValue('flgint',WtA(w_flgint,'C'));
l_oWv.setValue('flgdel',WtA(w_flgdel,'C'));
l_oWv.setValue('flgchk',WtA(w_flgchk,'C'));
l_oWv.setValue('flgsto',WtA(w_flgsto,'C'));
l_oWv.setValue('destfold',WtA(w_destfold,'C'));
l_oWv.setValue('xdesage',WtA(w_xdesage,'C'));
l_oWv.setValue('gUrlApp',WtA(w_gUrlApp,'C'));
l_oWv.setValue('gAzienda',WtA(w_gAzienda,'C'));
l_oWv.setValue('gFlgWU',WtA(w_gFlgWU,'C'));
l_oWv.setValue('xragcli',WtA(w_xragcli,'C'));
l_oWv.setValue('gWebCHK',WtA(w_gWebCHK,'C'));
l_oWv.setValue('stoper',WtA(w_stoper,'C'));
l_oWv.setValue('flgxls',WtA(w_flgxls,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["gIntemediario","gTipInter","codinter","xragsoc","tipinter","codage","codcli","ragben","DaData","AData","DaDataReg","ADataReg","tipoarch","flgrae","flgope","flgfrz","flgrap","tiprap","flgtit","tiptip","flgint","flgdel","flgchk","flgsto","destfold","xdesage","gUrlApp","gAzienda","gFlgWU","xragcli","gWebCHK","stoper","flgxls"];
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
if (Eq(w_codinter,w_gIntemediario) && Ne(opener.w_codinter,null)) {
TransferBetweenWindows(opener,'w_codinter',null,'Set_codinter');
}
if (Empty(w_xragsoc) && Ne(opener.w_xragsoc,null)) {
TransferBetweenWindows(opener,'w_xragsoc','w_xragsoc');
}
if (Eq(w_tipinter,w_gTipInter) && Ne(opener.w_tipinter,null)) {
TransferBetweenWindows(opener,'w_tipinter',null,'Set_tipinter');
}
}
}
m_bCalculating=true;
if (start && Eq(At(',codinter,',pseq),0)) {
w_codinter=w_gIntemediario;
}
Link_FCREPJBLHG(null);
if (start && Eq(At(',tipinter,',pseq),0)) {
w_tipinter=w_gTipInter;
}
Link_LMCBBKUTJY(null);
Link_VEYKPVUMPQ(null);
if (start && Eq(At(',tipoarch,',pseq),0)) {
w_tipoarch='D';
}
if (start && Eq(At(',flgrae,',pseq),0)) {
w_flgrae='A';
}
if (start && Eq(At(',flgope,',pseq),0)) {
w_flgope='S';
}
if (start && Eq(At(',flgfrz,',pseq),0)) {
w_flgfrz='N';
}
if (start && Eq(At(',flgrap,',pseq),0)) {
w_flgrap='N';
}
if (start && Eq(At(',tiprap,',pseq),0)) {
w_tiprap='1';
}
if (start && Eq(At(',flgtit,',pseq),0)) {
w_flgtit='N';
}
if (start && Eq(At(',tiptip,',pseq),0)) {
w_tiptip='1';
}
if (start && Eq(At(',flgint,',pseq),0)) {
w_flgint='S';
}
if (start && Eq(At(',flgdel,',pseq),0)) {
w_flgdel='S';
}
if (start && Eq(At(',flgchk,',pseq),0)) {
w_flgchk='N';
}
if (start && Eq(At(',flgsto,',pseq),0)) {
w_flgsto='N';
}
if (start && Eq(At(',stoper,',pseq),0)) {
w_stoper='R';
}
if (start && Eq(At(',flgxls,',pseq),0)) {
w_flgxls='N';
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
_Obli('flgrap',0,'QXOCQTKHHM',false)
_Obli('flgxls',0,'OKPHQCXKRD',false)
_Obli('codinter',0,'FCREPJBLHG',false)
_Obli('tiprap',0,'YKZIVVFLHM',false)
_Obli('tipinter',0,'RCFVSQQCNU',false)
_Obli('codage',0,'LMCBBKUTJY',false,"11547283697")
_Obli('codcli',0,'VEYKPVUMPQ',false,"1823784963")
_Obli('ragben',0,'CNQRKVJUGN',false,"10100391661")
_Obli('DaData',2,'HJLJFAMGNR',false)
_Obli('AData',2,'XWZHWTENET',false)
_Obli('DaDataReg',2,'HBWDBPTGKK',false)
_Obli('ADataReg',2,'WTEIEHYBUM',false)
_Obli('tipoarch',0,'YJWPZAWNZJ',false)
_Obli('flgrae',0,'QNMKJLGOKW',false)
_Obli('flgope',0,'ACJYNBGGGK',false)
_Obli('flgfrz',0,'UGLRKSBAIN',false)
_Obli('flgsto',0,'DRCOVPYYCV',false)
_Obli('destfold',0,'BAPCIYCOIX',false,"145008573")
_Obli('flgtit',0,'MPZNTAOLOD',false)
_Obli('tiptip',0,'BGNWNQZSMR',false)
_Obli('flgint',0,'BHRJFGYNWO',false)
_Obli('flgdel',0,'VIRLZRRHIQ',false)
_Obli('flgchk',0,'LJVZZPXJUZ',false)
_Obli('stoper',0,'XPNJJLILLB',false)
