function FillCombosValues() {
FillCombo('BHAVHLFPAC','BHAVHLFPAC');
FillCombo('CNUZSPOEIV','CNUZSPOEIV');
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('LXORWVRYJJ',function(){return WtH(w_RAPPORTO,'C',25,0,'')},w_RAPPORTO);
if(c=Ctrl('BHAVHLFPAC')) selectCombo(c,w_TIPOAG,'C')
if(c=Ctrl('JHOQNVHZXH')) selectCombo(c,w_COINT,'C')
SPBOUILib.SetInputValue('OATVYCOEYD',function(){return WtH(w_DESCRI,'C',24,0,'')},w_DESCRI);
SPBOUILib.SetInputValue('RAPQTBTNXT',function(){return WtH(w_OLDINTER,'C',16,0,'')},w_OLDINTER);
if(c=Ctrl('CNUZSPOEIV')) selectCombo(c,w_VALUTA,'C')
SPBOUILib.SetInputValue('GSFLHJGDBR',function(){return WtH(w_CAB,'C',5,0,'')},w_CAB);
if(c=Ctrl('BJQDZXBWJS')) ChkboxCheckUncheck(c,1,w_INVIATO)
if(c=Ctrl('BJQDZXBWJS')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('UOUKXZECJY',function(){return WtH(w_DATAINVIO,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAINVIO);
SPBOUILib.SetInputValue('VCDAQCGFUL',function(){return WtH(w_DATAMODI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAMODI);
if(c=Ctrl('QKEKMYOBIJ')) ChkboxCheckUncheck(c,1,w_ANNULLA)
if(c=Ctrl('QKEKMYOBIJ')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('BYWOFLDARI',function(){return WtH(w_DATAANNU,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAANNU);
SPBOUILib.SetInputValue('JLZSVQCYSK',function(){return WtH(w_IDESITOFAM,'C',24,0,'')},w_IDESITOFAM);
SPBOUILib.SetInputValue('ASHSTCRNBL',function(){return WtH(w_UNIQUECODE,'C',50,0,'')},w_UNIQUECODE);
if(c=Ctrl('QKGGINIHGW')) ChkboxCheckUncheck(c,1,w_INVIATOC)
if(c=Ctrl('QKGGINIHGW')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('RJUFHFUDIX',function(){return WtH(w_DATAINVIOC,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAINVIOC);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay('YORQOIOBQN_DIV',IsHiddenByStateDriver('box_YORQOIOBQN'));
SetDisplay(Ctrl('ERFGDWAQVY'),Ne(w_INVIATO,1));
SetDisplay(Ctrl('KINMWWRRUA'),(Eq(w_INVIATO,1) && Eq(w_ANNULLA,1)) || Eq(w_INVIATO,0));
SetDisplay(Ctrl('LJBUMZNQNX'),Ne(w_INVIATO,1));
SetDisplay('MUCCIMEJEB_DIV',IsHiddenByStateDriver('Saldi'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["CAB"]=['MGDEBLMLWS'];
HideUI.lblids["COINT"]=['GDTYXHVEHO'];
HideUI.lblids["DATAMODI"]=['SOEKBYYSDZ'];
HideUI.lblids["DESCRI"]=['DUYEPEAECV'];
HideUI.lblids["IDESITOFAM"]=['SIHWUIKOST'];
HideUI.lblids["OLDINTER"]=['HYFJJHUTOA'];
HideUI.lblids["RAPPORTO"]=['OICGZUOZYP'];
HideUI.lblids["TIPOAG"]=['CTCKWHZVTZ'];
HideUI.lblids["UNIQUECODE"]=['DYCSKKQYXP'];
HideUI.lblids["VALUTA"]=['WUXCQQIOXL'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function LXORWVRYJJ_Valid(e) {
SetActiveField(Ctrl('LXORWVRYJJ'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('LXORWVRYJJ') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('RAPPORTO','C',w_RAPPORTO,HtW(Ctrl('LXORWVRYJJ').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAPPORTO(HtW(Ctrl('LXORWVRYJJ').value,'C'),null,e);
return l_bSetResult;
}
}
function LXORWVRYJJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LXORWVRYJJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LXORWVRYJJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LXORWVRYJJ'),e);
}
function BHAVHLFPAC_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOAG','C',w_TIPOAG,HtW(getComboValue(Ctrl('BHAVHLFPAC')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOAG(HtW(getComboValue(Ctrl('BHAVHLFPAC')),'C'),null,e);
return l_bSetResult;
}
}
function BHAVHLFPAC_OnFocus(e) {
SetActiveField(Ctrl('BHAVHLFPAC'),true);
}
function BHAVHLFPAC_OnBlur(e) {
SetActiveField(Ctrl('BHAVHLFPAC'),false);
}
function JHOQNVHZXH_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('COINT','C',w_COINT,HtW(getComboValue(Ctrl('JHOQNVHZXH')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_COINT(HtW(getComboValue(Ctrl('JHOQNVHZXH')),'C'),null,e);
return l_bSetResult;
}
}
function JHOQNVHZXH_OnFocus(e) {
SetActiveField(Ctrl('JHOQNVHZXH'),true);
}
function JHOQNVHZXH_OnBlur(e) {
SetActiveField(Ctrl('JHOQNVHZXH'),false);
}
function OATVYCOEYD_Valid(e) {
SetActiveField(Ctrl('OATVYCOEYD'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('OATVYCOEYD').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('OATVYCOEYD').value,'C'),null,e);
return l_bSetResult;
}
}
function OATVYCOEYD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OATVYCOEYD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OATVYCOEYD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OATVYCOEYD'),e);
}
function RAPQTBTNXT_Valid(e) {
SetActiveField(Ctrl('RAPQTBTNXT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('OLDINTER','C',w_OLDINTER,HtW(Ctrl('RAPQTBTNXT').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_OLDINTER(HtW(Ctrl('RAPQTBTNXT').value,'C'),null,e);
return l_bSetResult;
}
}
function RAPQTBTNXT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RAPQTBTNXT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RAPQTBTNXT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RAPQTBTNXT'),e);
}
function CNUZSPOEIV_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VALUTA','C',w_VALUTA,HtW(getComboValue(Ctrl('CNUZSPOEIV')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VALUTA(HtW(getComboValue(Ctrl('CNUZSPOEIV')),'C'),null,e);
return l_bSetResult;
}
}
function CNUZSPOEIV_OnFocus(e) {
SetActiveField(Ctrl('CNUZSPOEIV'),true);
}
function CNUZSPOEIV_OnBlur(e) {
SetActiveField(Ctrl('CNUZSPOEIV'),false);
}
function GSFLHJGDBR_Valid(e) {
SetActiveField(Ctrl('GSFLHJGDBR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CAB','C',w_CAB,HtW(Ctrl('GSFLHJGDBR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAB(HtW(Ctrl('GSFLHJGDBR').value,'C'),null,e);
return l_bSetResult;
}
}
function GSFLHJGDBR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GSFLHJGDBR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GSFLHJGDBR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GSFLHJGDBR'),e);
}
function BJQDZXBWJS_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('INVIATO','N',w_INVIATO,ChkboxValueAssign(Ctrl('BJQDZXBWJS'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_INVIATO(ChkboxValueAssign(Ctrl('BJQDZXBWJS'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function BJQDZXBWJS_OnFocus(e) {
SetActiveField(Ctrl('BJQDZXBWJS'),true);
}
function BJQDZXBWJS_OnBlur(e) {
SetActiveField(Ctrl('BJQDZXBWJS'),false);
}
function UOUKXZECJY_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('UOUKXZECJY'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('UOUKXZECJY').value=ApplyPictureToDate(Ctrl('UOUKXZECJY').value,TranslatePicture(datePattern),'UOUKXZECJY');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('UOUKXZECJY'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('UOUKXZECJY');
}
}
}
SetActiveField(Ctrl('UOUKXZECJY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAINVIO','D',w_DATAINVIO,HtW(Ctrl('UOUKXZECJY').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAINVIO(HtW(Ctrl('UOUKXZECJY').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function UOUKXZECJY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UOUKXZECJY'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('UOUKXZECJY',w_DATAINVIO,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('UOUKXZECJY');
SetActiveField(Ctrl('UOUKXZECJY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UOUKXZECJY'),e);
}
function VCDAQCGFUL_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('VCDAQCGFUL'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('VCDAQCGFUL').value=ApplyPictureToDate(Ctrl('VCDAQCGFUL').value,TranslatePicture(datePattern),'VCDAQCGFUL');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('VCDAQCGFUL'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('VCDAQCGFUL');
}
}
}
SetActiveField(Ctrl('VCDAQCGFUL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAMODI','D',w_DATAMODI,HtW(Ctrl('VCDAQCGFUL').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAMODI(HtW(Ctrl('VCDAQCGFUL').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function VCDAQCGFUL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VCDAQCGFUL'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('VCDAQCGFUL',w_DATAMODI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('VCDAQCGFUL');
SetActiveField(Ctrl('VCDAQCGFUL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VCDAQCGFUL'),e);
}
function QKEKMYOBIJ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('ANNULLA','N',w_ANNULLA,ChkboxValueAssign(Ctrl('QKEKMYOBIJ'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ANNULLA(ChkboxValueAssign(Ctrl('QKEKMYOBIJ'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function QKEKMYOBIJ_OnFocus(e) {
SetActiveField(Ctrl('QKEKMYOBIJ'),true);
}
function QKEKMYOBIJ_OnBlur(e) {
SetActiveField(Ctrl('QKEKMYOBIJ'),false);
}
function BYWOFLDARI_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('BYWOFLDARI'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('BYWOFLDARI').value=ApplyPictureToDate(Ctrl('BYWOFLDARI').value,TranslatePicture(datePattern),'BYWOFLDARI');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('BYWOFLDARI'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('BYWOFLDARI');
}
}
}
SetActiveField(Ctrl('BYWOFLDARI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAANNU','D',w_DATAANNU,HtW(Ctrl('BYWOFLDARI').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAANNU(HtW(Ctrl('BYWOFLDARI').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function BYWOFLDARI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BYWOFLDARI'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('BYWOFLDARI',w_DATAANNU,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('BYWOFLDARI');
SetActiveField(Ctrl('BYWOFLDARI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BYWOFLDARI'),e);
}
function JLZSVQCYSK_Valid(e) {
SetActiveField(Ctrl('JLZSVQCYSK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDESITOFAM','C',w_IDESITOFAM,HtW(Ctrl('JLZSVQCYSK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDESITOFAM(HtW(Ctrl('JLZSVQCYSK').value,'C'),null,e);
return l_bSetResult;
}
}
function JLZSVQCYSK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JLZSVQCYSK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JLZSVQCYSK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JLZSVQCYSK'),e);
}
function ASHSTCRNBL_Valid(e) {
SetActiveField(Ctrl('ASHSTCRNBL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('UNIQUECODE','C',w_UNIQUECODE,HtW(Ctrl('ASHSTCRNBL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_UNIQUECODE(HtW(Ctrl('ASHSTCRNBL').value,'C'),null,e);
return l_bSetResult;
}
}
function ASHSTCRNBL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ASHSTCRNBL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ASHSTCRNBL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ASHSTCRNBL'),e);
}
function ERFGDWAQVY_Click() {
_modifyandopen('arpg_fam_variazione'+'?m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=200,width=300',false)
}
function KINMWWRRUA_Click() {
_modifyandopen('arpg_fam_cancella'+'?m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=200,width=300',false)
}
function QKGGINIHGW_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('INVIATOC','N',w_INVIATOC,ChkboxValueAssign(Ctrl('QKGGINIHGW'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_INVIATOC(ChkboxValueAssign(Ctrl('QKGGINIHGW'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function QKGGINIHGW_OnFocus(e) {
SetActiveField(Ctrl('QKGGINIHGW'),true);
}
function QKGGINIHGW_OnBlur(e) {
SetActiveField(Ctrl('QKGGINIHGW'),false);
}
function RJUFHFUDIX_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('RJUFHFUDIX'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('RJUFHFUDIX').value=ApplyPictureToDate(Ctrl('RJUFHFUDIX').value,TranslatePicture(datePattern),'RJUFHFUDIX');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('RJUFHFUDIX'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('RJUFHFUDIX');
}
}
}
SetActiveField(Ctrl('RJUFHFUDIX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAINVIOC','D',w_DATAINVIOC,HtW(Ctrl('RJUFHFUDIX').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAINVIOC(HtW(Ctrl('RJUFHFUDIX').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function RJUFHFUDIX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RJUFHFUDIX'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('RJUFHFUDIX',w_DATAINVIOC,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('RJUFHFUDIX');
SetActiveField(Ctrl('RJUFHFUDIX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RJUFHFUDIX'),e);
}
function LJBUMZNQNX_Click() {
if (false || WindowConfirm(Translate('11257604157'))) {
Reinvio()
}
}
linkpc_url.u('XUXHMWVHFR',function(){return 'ardt_ae_saldianno_rap?m_bInnerChild=true'+GetLinkPCKeys('ardt_ae_saldianno_rap')+'&m_bRowsChild='+EnableChild('ardt_ae_saldianno_rap')})
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function LXORWVRYJJ_wrap_Valid(event) {
return LXORWVRYJJ_Valid(event);
}
SPBOUILib.SetInputExit('LXORWVRYJJ',LXORWVRYJJ_wrap_Valid);
function LXORWVRYJJ_wrap_OnFocus(event) {
return LXORWVRYJJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('LXORWVRYJJ',LXORWVRYJJ_wrap_OnFocus);
function LXORWVRYJJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LXORWVRYJJ',LXORWVRYJJ_wrap_OnKeyDown);
function BHAVHLFPAC_wrap_Valid(event) {
return BHAVHLFPAC_Valid(event);
}
SPBOUILib.SetComboChange('BHAVHLFPAC',BHAVHLFPAC_wrap_Valid);
function BHAVHLFPAC_wrap_OnFocus(event) {
return BHAVHLFPAC_OnFocus(event);
}
SPBOUILib.SetInputEnter('BHAVHLFPAC',BHAVHLFPAC_wrap_OnFocus);
function BHAVHLFPAC_wrap_Blur(event) {
return BHAVHLFPAC_OnBlur(event);
}
SPBOUILib.SetInputExit('BHAVHLFPAC',BHAVHLFPAC_wrap_Blur);
function JHOQNVHZXH_wrap_Valid(event) {
return JHOQNVHZXH_Valid(event);
}
SPBOUILib.SetComboChange('JHOQNVHZXH',JHOQNVHZXH_wrap_Valid);
function JHOQNVHZXH_wrap_OnFocus(event) {
return JHOQNVHZXH_OnFocus(event);
}
SPBOUILib.SetInputEnter('JHOQNVHZXH',JHOQNVHZXH_wrap_OnFocus);
function JHOQNVHZXH_wrap_Blur(event) {
return JHOQNVHZXH_OnBlur(event);
}
SPBOUILib.SetInputExit('JHOQNVHZXH',JHOQNVHZXH_wrap_Blur);
function OATVYCOEYD_wrap_Valid(event) {
return OATVYCOEYD_Valid(event);
}
SPBOUILib.SetInputExit('OATVYCOEYD',OATVYCOEYD_wrap_Valid);
function OATVYCOEYD_wrap_OnFocus(event) {
return OATVYCOEYD_OnFocus(event);
}
SPBOUILib.SetInputEnter('OATVYCOEYD',OATVYCOEYD_wrap_OnFocus);
function OATVYCOEYD_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OATVYCOEYD',OATVYCOEYD_wrap_OnKeyDown);
function RAPQTBTNXT_wrap_Valid(event) {
return RAPQTBTNXT_Valid(event);
}
SPBOUILib.SetInputExit('RAPQTBTNXT',RAPQTBTNXT_wrap_Valid);
function RAPQTBTNXT_wrap_OnFocus(event) {
return RAPQTBTNXT_OnFocus(event);
}
SPBOUILib.SetInputEnter('RAPQTBTNXT',RAPQTBTNXT_wrap_OnFocus);
function RAPQTBTNXT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RAPQTBTNXT',RAPQTBTNXT_wrap_OnKeyDown);
function CNUZSPOEIV_wrap_Valid(event) {
return CNUZSPOEIV_Valid(event);
}
SPBOUILib.SetComboChange('CNUZSPOEIV',CNUZSPOEIV_wrap_Valid);
function CNUZSPOEIV_wrap_OnFocus(event) {
return CNUZSPOEIV_OnFocus(event);
}
SPBOUILib.SetInputEnter('CNUZSPOEIV',CNUZSPOEIV_wrap_OnFocus);
function CNUZSPOEIV_wrap_Blur(event) {
return CNUZSPOEIV_OnBlur(event);
}
SPBOUILib.SetInputExit('CNUZSPOEIV',CNUZSPOEIV_wrap_Blur);
function GSFLHJGDBR_wrap_Valid(event) {
return GSFLHJGDBR_Valid(event);
}
SPBOUILib.SetInputExit('GSFLHJGDBR',GSFLHJGDBR_wrap_Valid);
function GSFLHJGDBR_wrap_OnFocus(event) {
return GSFLHJGDBR_OnFocus(event);
}
SPBOUILib.SetInputEnter('GSFLHJGDBR',GSFLHJGDBR_wrap_OnFocus);
function GSFLHJGDBR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('GSFLHJGDBR',GSFLHJGDBR_wrap_OnKeyDown);
function BJQDZXBWJS_wrap_Valid(event) {
return BJQDZXBWJS_Valid(event);
}
SPBOUILib.SetCheckboxClick('BJQDZXBWJS',BJQDZXBWJS_wrap_Valid);
function BJQDZXBWJS_wrap_OnFocus(event) {
return BJQDZXBWJS_OnFocus(event);
}
SPBOUILib.SetInputEnter('BJQDZXBWJS',BJQDZXBWJS_wrap_OnFocus);
function BJQDZXBWJS_wrap_Blur(event) {
return BJQDZXBWJS_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('BJQDZXBWJS',BJQDZXBWJS_wrap_Blur);
function UOUKXZECJY_wrap_Valid(event) {
return UOUKXZECJY_Valid(event);
}
SPBOUILib.SetInputExit('UOUKXZECJY',UOUKXZECJY_wrap_Valid);
function UOUKXZECJY_wrap_OnFocus(event) {
return UOUKXZECJY_OnFocus(event);
}
SPBOUILib.SetInputEnter('UOUKXZECJY',UOUKXZECJY_wrap_OnFocus);
function UOUKXZECJY_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('UOUKXZECJY',UOUKXZECJY_wrap_OnKeyPress);
function UOUKXZECJY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('UOUKXZECJY',UOUKXZECJY_wrap_OnKeyDown);
function VCDAQCGFUL_wrap_Valid(event) {
return VCDAQCGFUL_Valid(event);
}
SPBOUILib.SetInputExit('VCDAQCGFUL',VCDAQCGFUL_wrap_Valid);
function VCDAQCGFUL_wrap_OnFocus(event) {
return VCDAQCGFUL_OnFocus(event);
}
SPBOUILib.SetInputEnter('VCDAQCGFUL',VCDAQCGFUL_wrap_OnFocus);
function VCDAQCGFUL_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('VCDAQCGFUL',VCDAQCGFUL_wrap_OnKeyPress);
function VCDAQCGFUL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('VCDAQCGFUL',VCDAQCGFUL_wrap_OnKeyDown);
function QKEKMYOBIJ_wrap_Valid(event) {
return QKEKMYOBIJ_Valid(event);
}
SPBOUILib.SetCheckboxClick('QKEKMYOBIJ',QKEKMYOBIJ_wrap_Valid);
function QKEKMYOBIJ_wrap_OnFocus(event) {
return QKEKMYOBIJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('QKEKMYOBIJ',QKEKMYOBIJ_wrap_OnFocus);
function QKEKMYOBIJ_wrap_Blur(event) {
return QKEKMYOBIJ_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('QKEKMYOBIJ',QKEKMYOBIJ_wrap_Blur);
function BYWOFLDARI_wrap_Valid(event) {
return BYWOFLDARI_Valid(event);
}
SPBOUILib.SetInputExit('BYWOFLDARI',BYWOFLDARI_wrap_Valid);
function BYWOFLDARI_wrap_OnFocus(event) {
return BYWOFLDARI_OnFocus(event);
}
SPBOUILib.SetInputEnter('BYWOFLDARI',BYWOFLDARI_wrap_OnFocus);
function BYWOFLDARI_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('BYWOFLDARI',BYWOFLDARI_wrap_OnKeyPress);
function BYWOFLDARI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('BYWOFLDARI',BYWOFLDARI_wrap_OnKeyDown);
function JLZSVQCYSK_wrap_Valid(event) {
return JLZSVQCYSK_Valid(event);
}
SPBOUILib.SetInputExit('JLZSVQCYSK',JLZSVQCYSK_wrap_Valid);
function JLZSVQCYSK_wrap_OnFocus(event) {
return JLZSVQCYSK_OnFocus(event);
}
SPBOUILib.SetInputEnter('JLZSVQCYSK',JLZSVQCYSK_wrap_OnFocus);
function JLZSVQCYSK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JLZSVQCYSK',JLZSVQCYSK_wrap_OnKeyDown);
function ASHSTCRNBL_wrap_Valid(event) {
return ASHSTCRNBL_Valid(event);
}
SPBOUILib.SetInputExit('ASHSTCRNBL',ASHSTCRNBL_wrap_Valid);
function ASHSTCRNBL_wrap_OnFocus(event) {
return ASHSTCRNBL_OnFocus(event);
}
SPBOUILib.SetInputEnter('ASHSTCRNBL',ASHSTCRNBL_wrap_OnFocus);
function ASHSTCRNBL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ASHSTCRNBL',ASHSTCRNBL_wrap_OnKeyDown);
function ERFGDWAQVY_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ERFGDWAQVY_Click():void(0));
}
SPBOUILib.SetButtonClick('ERFGDWAQVY',ERFGDWAQVY_wrap_OnClick);
function ERFGDWAQVY_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('ERFGDWAQVY',ERFGDWAQVY_wrap_OnKeyDown);
function KINMWWRRUA_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?KINMWWRRUA_Click():void(0));
}
SPBOUILib.SetButtonClick('KINMWWRRUA',KINMWWRRUA_wrap_OnClick);
function KINMWWRRUA_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('KINMWWRRUA',KINMWWRRUA_wrap_OnKeyDown);
function QKGGINIHGW_wrap_Valid(event) {
return QKGGINIHGW_Valid(event);
}
SPBOUILib.SetCheckboxClick('QKGGINIHGW',QKGGINIHGW_wrap_Valid);
function QKGGINIHGW_wrap_OnFocus(event) {
return QKGGINIHGW_OnFocus(event);
}
SPBOUILib.SetInputEnter('QKGGINIHGW',QKGGINIHGW_wrap_OnFocus);
function QKGGINIHGW_wrap_Blur(event) {
return QKGGINIHGW_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('QKGGINIHGW',QKGGINIHGW_wrap_Blur);
function RJUFHFUDIX_wrap_Valid(event) {
return RJUFHFUDIX_Valid(event);
}
SPBOUILib.SetInputExit('RJUFHFUDIX',RJUFHFUDIX_wrap_Valid);
function RJUFHFUDIX_wrap_OnFocus(event) {
return RJUFHFUDIX_OnFocus(event);
}
SPBOUILib.SetInputEnter('RJUFHFUDIX',RJUFHFUDIX_wrap_OnFocus);
function RJUFHFUDIX_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('RJUFHFUDIX',RJUFHFUDIX_wrap_OnKeyPress);
function RJUFHFUDIX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('RJUFHFUDIX',RJUFHFUDIX_wrap_OnKeyDown);
function LJBUMZNQNX_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?LJBUMZNQNX_Click():void(0));
}
SPBOUILib.SetButtonClick('LJBUMZNQNX',LJBUMZNQNX_wrap_OnClick);
function LJBUMZNQNX_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('LJBUMZNQNX',LJBUMZNQNX_wrap_OnKeyDown);
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
if (Ne(typeof(w_Famiglia),'undefined')) {
w_Famiglia.raiseEvent('armt_ae_famiglie_'+Strtran(p_cEvent,' ','_'));
}
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
FocusFirstComponent.edit={"page_1":["BHAVHLFPAC"]};
FocusFirstComponent.query={"page_1":["LXORWVRYJJ"]};
FocusFirstComponent.otherwise={"page_1":["LXORWVRYJJ"]};
function Help() {
windowOpenForeground('../doc/armt_ae_famiglie_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_ardt_ae_saldianno_rap() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_2')) {
if (ChildToLoad('XUXHMWVHFR')) {
if (Eq(lazy,null) || LibJavascript.UserCanSee('XUXHMWVHFR')) {
LoadContext.lc(1,'XUXHMWVHFR');
}
} else {
LibJavascript.RefreshChildGrid('XUXHMWVHFR');
}
}
}
GetLayerID.Layers.push({"id":"YORQOIOBQN","name":"box_YORQOIOBQN"});
GetLayerID.Layers.push({"id":"MUCCIMEJEB","name":"Saldi"});
function DeclareWVs() {
var a = arguments;
w_RAPPORTO=a[0];
w_TIPOAG=a[1];
w_COINT=a[2];
w_DESCRI=a[3];
w_OLDINTER=a[4];
w_VALUTA=a[5];
w_CAB=a[6];
w_INVIATO=a[7];
w_DATAINVIO=a[8];
w_DATAMODI=a[9];
w_ANNULLA=a[10];
w_DATAANNU=a[11];
w_IDESITOFAM=a[12];
w_UNIQUECODE=a[13];
w_INVIATOC=a[14];
w_DATAINVIOC=a[15];
m_cWv_ardt_ae_saldianno_rap=a[16];
if (Gt(a.length,17)) {
m_cErrorInChild='';
}
if (Gt(a.length,17)) {
o_TIPOAG=w_TIPOAG;
}
m_PrimaryKeys=['RAPPORTO'];
}
function i_PrimaryKey() {
return 'aetesta'+'\\'+CPLib.ToCPStr(w_RAPPORTO);
}
GetLinkPCKeys.set_o('ardt_ae_saldianno_rap',false);
GetLinkPCKeys.o['ardt_ae_saldianno_rap']['RAPPORTO']=function(t){
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
LoadContext.f('XUXHMWVHFR',function(){return FrameRef('ardt_ae_saldianno_rap')},1,'ardt_ae_saldianno_rap',0,2)
GetSelectedChildPage.child={'ardt_ae_saldianno_rap': function(){return FrameRef('ardt_ae_saldianno_rap')}}
function GetSelectedPage(p_d) {
p_d.setValue('armt_ae_famiglie',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
}
_Obli('RAPPORTO',0,'LXORWVRYJJ',false,"11116511596")
_Obli('TIPOAG',0,'BHAVHLFPAC',false)
_Obli('COINT',0,'JHOQNVHZXH',false,"1723736132")
_Obli('DESCRI',0,'OATVYCOEYD',false,"285808099")
_Obli('OLDINTER',0,'RAPQTBTNXT',false,"730578090")
_Obli('VALUTA',0,'CNUZSPOEIV',false,"109710548")
_Obli('CAB',0,'GSFLHJGDBR',false,"1455030164")
_Obli('INVIATO',1,'BJQDZXBWJS',false)
_Obli('DATAINVIO',2,'UOUKXZECJY',false)
_Obli('DATAMODI',2,'VCDAQCGFUL',false,"11268897251")
_Obli('ANNULLA',1,'QKEKMYOBIJ',false)
_Obli('DATAANNU',2,'BYWOFLDARI',false)
_Obli('IDESITOFAM',0,'JLZSVQCYSK',false,"10615814578")
_Obli('UNIQUECODE',0,'ASHSTCRNBL',false)
_Obli('INVIATOC',1,'QKGGINIHGW',false)
_Obli('DATAINVIOC',2,'RJUFHFUDIX',false)
