function FillCombosValues() {
FillCombo('BHAVHLFPAC','BHAVHLFPAC');
}
function SetControlsValue() {
var c;
if(c=Ctrl('JHOQNVHZXH')) selectCombo(c,w_COINT,'C')
if(c=Ctrl('BHAVHLFPAC')) selectCombo(c,w_TIPOAG,'C')
SPBOUILib.SetInputValue('DZWSXMBIHR',function(){return WtH(w_CONNESINT,'C',16,0,'')},w_CONNESINT);
SPBOUILib.SetInputValue('HUMSCLHVTQ',function(){return WtH(w_ADATA,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_ADATA);
SPBOUILib.SetInputValue('VXGCUGFCOM',function(){return WtH(w_ADATARET,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_ADATARET);
if(c=Ctrl('OYBCLSBWWU')) ChkboxCheckUncheck(c,1,w_ASPEDITO)
if(c=Ctrl('OYBCLSBWWU')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('EDCVGCRZZZ',function(){return WtH(w_AFILE,'C',15,0,'')},w_AFILE);
SPBOUILib.SetInputValue('JINDLZUJGB',function(){return WtH(w_APROG,'C',25,0,'')},w_APROG);
var tmp_SVRLUYRVRK = ToHTag(AsControlValue(w_xragsoc));
if (Ne(e_SVRLUYRVRK,tmp_SVRLUYRVRK)) {
SPBOUILib.SetLabelValue('SVRLUYRVRK','innerHTML',tmp_SVRLUYRVRK);
e_SVRLUYRVRK=tmp_SVRLUYRVRK;
}
if(c=Ctrl('AEKMRLIFOL')) ChkboxCheckUncheck(c,'S',w_NOCODFISC)
if(c=Ctrl('AEKMRLIFOL')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('ZDQIQPDLMA',function(){return WtH(w_IDESITO,'C',8,0,'')},w_IDESITO);
SPBOUILib.SetInputValue('AOOZEQQJTQ',function(){return WtH(w_DATESITO,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATESITO);
if(c=Ctrl('WSCNNXSPZE')) ChkboxCheckUncheck(c,1,w_RSPEDITO)
if(c=Ctrl('WSCNNXSPZE')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('IYTHKZIUFV',function(){return WtH(w_COLDFILE,'C',15,0,'')},w_COLDFILE);
SPBOUILib.SetInputValue('URGNQSTVHB',function(){return WtH(w_COLDPROG,'C',25,0,'')},w_COLDPROG);
SPBOUILib.SetInputValue('FMXMNQMEMH',function(){return WtH(w_dtcanc,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_dtcanc);
if(c=Ctrl('GRVAHWHFJH')) ChkboxCheckUncheck(c,1,w_spcanc)
if(c=Ctrl('GRVAHWHFJH')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('TZPQRTXHYT',function(){return WtH(w_filecanc,'C',15,0,'')},w_filecanc);
SPBOUILib.SetInputValue('GWASKALOUK',function(){return WtH(w_idcanc,'C',25,0,'')},w_idcanc);
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
SetDisplay('RGYIJRGRVR_DIV',IsHiddenByStateDriver('box_RGYIJRGRVR'));
SetDisplay(Ctrl('RZXJJIHWRO'),Empty(w_CONNESINT) || Eq(w_ASPEDITO,0) ||  ! (arfn_ae_chkdel(w_IDBASE,'O')));
SetDisplay(Ctrl('LBDAXRYAIV'),Empty(w_CONNESINT) || Eq(w_ASPEDITO,0) ||  ! (arfn_ae_chkdel(w_IDBASE,'O')));
SetDisplay('HDQLRPYTAN_DIV',IsHiddenByStateDriver('box_HDQLRPYTAN'));
SetDisplay('KPRGKTCWLJ_DIV',IsHiddenByStateDriver('box_KPRGKTCWLJ'));
SetDisplay('FXPPJOXLEV_DIV',IsHiddenByStateDriver('box_FXPPJOXLEV'));
SetDisplay(Ctrl('VQNRBICOXA'),Empty(w_dtcanc));
SetDisplay(Ctrl('URZTYMSMYS'),Empty(w_ADATARET) || ( ! (Empty(w_ADATARET)) && Eq(w_RSPEDITO,1)));
SetDisplay(Ctrl('WEIKCFSMRK'),Empty(w_dtcanc));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["ADATA"]=['EEPWGWPHCL'];
HideUI.lblids["ADATARET"]=['BLWCMFJCPC'];
HideUI.lblids["COINT"]=['GDTYXHVEHO'];
HideUI.lblids["CONNESINT"]=['TOFVCFNDFU'];
HideUI.lblids["DATESITO"]=['IINLMHPBWG'];
HideUI.lblids["IDESITO"]=['YBLTSMLFUZ'];
HideUI.lblids["TIPOAG"]=['CTCKWHZVTZ'];
HideUI.lblids["dtcanc"]=['WJDBESRNAN'];
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
function DZWSXMBIHR_Valid(e) {
SetActiveField(Ctrl('DZWSXMBIHR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CONNESINT','C',w_CONNESINT,HtW(Ctrl('DZWSXMBIHR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONNESINT(HtW(Ctrl('DZWSXMBIHR').value,'C'),null,e);
return l_bSetResult;
}
}
function DZWSXMBIHR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DZWSXMBIHR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DZWSXMBIHR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DZWSXMBIHR'),e);
}
function DZWSXMBIHR_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('DZWSXMBIHR')),'linkview_DZWSXMBIHR','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function HUMSCLHVTQ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('HUMSCLHVTQ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('HUMSCLHVTQ').value=ApplyPictureToDate(Ctrl('HUMSCLHVTQ').value,TranslatePicture(datePattern),'HUMSCLHVTQ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('HUMSCLHVTQ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('HUMSCLHVTQ');
}
}
}
SetActiveField(Ctrl('HUMSCLHVTQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ADATA','D',w_ADATA,HtW(Ctrl('HUMSCLHVTQ').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ADATA(HtW(Ctrl('HUMSCLHVTQ').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function HUMSCLHVTQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HUMSCLHVTQ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('HUMSCLHVTQ',w_ADATA,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('HUMSCLHVTQ');
SetActiveField(Ctrl('HUMSCLHVTQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HUMSCLHVTQ'),e);
}
function VXGCUGFCOM_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('VXGCUGFCOM'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('VXGCUGFCOM').value=ApplyPictureToDate(Ctrl('VXGCUGFCOM').value,TranslatePicture(datePattern),'VXGCUGFCOM');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('VXGCUGFCOM'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('VXGCUGFCOM');
}
}
}
SetActiveField(Ctrl('VXGCUGFCOM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ADATARET','D',w_ADATARET,HtW(Ctrl('VXGCUGFCOM').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ADATARET(HtW(Ctrl('VXGCUGFCOM').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function VXGCUGFCOM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VXGCUGFCOM'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('VXGCUGFCOM',w_ADATARET,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('VXGCUGFCOM');
SetActiveField(Ctrl('VXGCUGFCOM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VXGCUGFCOM'),e);
}
function OYBCLSBWWU_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('ASPEDITO','N',w_ASPEDITO,ChkboxValueAssign(Ctrl('OYBCLSBWWU'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ASPEDITO(ChkboxValueAssign(Ctrl('OYBCLSBWWU'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function OYBCLSBWWU_OnFocus(e) {
SetActiveField(Ctrl('OYBCLSBWWU'),true);
}
function OYBCLSBWWU_OnBlur(e) {
SetActiveField(Ctrl('OYBCLSBWWU'),false);
}
function EDCVGCRZZZ_Valid(e) {
SetActiveField(Ctrl('EDCVGCRZZZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('AFILE','C',w_AFILE,HtW(Ctrl('EDCVGCRZZZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_AFILE(HtW(Ctrl('EDCVGCRZZZ').value,'C'),null,e);
return l_bSetResult;
}
}
function EDCVGCRZZZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EDCVGCRZZZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('EDCVGCRZZZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EDCVGCRZZZ'),e);
}
function JINDLZUJGB_Valid(e) {
SetActiveField(Ctrl('JINDLZUJGB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('APROG','C',w_APROG,HtW(Ctrl('JINDLZUJGB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_APROG(HtW(Ctrl('JINDLZUJGB').value,'C'),null,e);
return l_bSetResult;
}
}
function JINDLZUJGB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JINDLZUJGB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JINDLZUJGB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JINDLZUJGB'),e);
}
function RZXJJIHWRO_Click() {
if ( ! (Empty(w_CONNESINT)) && Eq(w_ASPEDITO,1) && Eq(m_cFunction,'view')) {
ModOpen(1)
}
}
function LBDAXRYAIV_Click() {
if ( ! (Empty(w_CONNESINT)) && Eq(w_ASPEDITO,1) && Eq(m_cFunction,'view')) {
ModOpen(2)
}
}
function href_AFSFEDCXQH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('CONNES',AsAppletValue(w_CONNESINT));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('CONNES'));
_modifyandopen('arpg_edt_personbo'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',false)
}
function ZDQIQPDLMA_Valid(e) {
SetActiveField(Ctrl('ZDQIQPDLMA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDESITO','C',w_IDESITO,HtW(Ctrl('ZDQIQPDLMA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDESITO(HtW(Ctrl('ZDQIQPDLMA').value,'C'),null,e);
return l_bSetResult;
}
}
function ZDQIQPDLMA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZDQIQPDLMA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZDQIQPDLMA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZDQIQPDLMA'),e);
}
function AOOZEQQJTQ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('AOOZEQQJTQ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('AOOZEQQJTQ').value=ApplyPictureToDate(Ctrl('AOOZEQQJTQ').value,TranslatePicture(datePattern),'AOOZEQQJTQ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('AOOZEQQJTQ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('AOOZEQQJTQ');
}
}
}
SetActiveField(Ctrl('AOOZEQQJTQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATESITO','D',w_DATESITO,HtW(Ctrl('AOOZEQQJTQ').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATESITO(HtW(Ctrl('AOOZEQQJTQ').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function AOOZEQQJTQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AOOZEQQJTQ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('AOOZEQQJTQ',w_DATESITO,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('AOOZEQQJTQ');
SetActiveField(Ctrl('AOOZEQQJTQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AOOZEQQJTQ'),e);
}
function WSCNNXSPZE_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('RSPEDITO','N',w_RSPEDITO,ChkboxValueAssign(Ctrl('WSCNNXSPZE'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RSPEDITO(ChkboxValueAssign(Ctrl('WSCNNXSPZE'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function WSCNNXSPZE_OnFocus(e) {
SetActiveField(Ctrl('WSCNNXSPZE'),true);
}
function WSCNNXSPZE_OnBlur(e) {
SetActiveField(Ctrl('WSCNNXSPZE'),false);
}
function IYTHKZIUFV_Valid(e) {
SetActiveField(Ctrl('IYTHKZIUFV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('COLDFILE','C',w_COLDFILE,HtW(Ctrl('IYTHKZIUFV').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_COLDFILE(HtW(Ctrl('IYTHKZIUFV').value,'C'),null,e);
return l_bSetResult;
}
}
function IYTHKZIUFV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IYTHKZIUFV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IYTHKZIUFV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IYTHKZIUFV'),e);
}
function URGNQSTVHB_Valid(e) {
SetActiveField(Ctrl('URGNQSTVHB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('COLDPROG','C',w_COLDPROG,HtW(Ctrl('URGNQSTVHB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_COLDPROG(HtW(Ctrl('URGNQSTVHB').value,'C'),null,e);
return l_bSetResult;
}
}
function URGNQSTVHB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('URGNQSTVHB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('URGNQSTVHB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('URGNQSTVHB'),e);
}
function URZTYMSMYS_Click() {
if (Eq(m_cFunction,'view')) {
if (false || WindowConfirm(Translate('11741368204'))) {
arrt_delret_aeoprig([["pTipo",'R'],["w_IDBASE",w_IDBASE],["w_ADATARET",w_ADATARET],["w_CONNESINT",w_CONNESINT]])
}
}
}
function WEIKCFSMRK_Click() {
if (Eq(m_cFunction,'view')) {
if (false || WindowConfirm(Translate('11741368204'))) {
arrt_delret_aeoprig([["pTipo",'D'],["w_IDBASE",w_IDBASE],["w_ADATARET",w_ADATARET],["w_CONNESINT",w_CONNESINT]])
}
}
}
_ResetTracker();
function setEventHandlers() {
var c;
function RZXJJIHWRO_wrap_OnClick(event) {
return RZXJJIHWRO_Click();
}
SPBOUILib.SetButtonClick('RZXJJIHWRO',RZXJJIHWRO_wrap_OnClick);
function LBDAXRYAIV_wrap_OnClick(event) {
return LBDAXRYAIV_Click();
}
SPBOUILib.SetButtonClick('LBDAXRYAIV',LBDAXRYAIV_wrap_OnClick);
function AFSFEDCXQH_wrap_OnClick(event) {
return href_AFSFEDCXQH();
}
SPBOUILib.SetImageClick('AFSFEDCXQH',AFSFEDCXQH_wrap_OnClick);
function AFSFEDCXQH_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('AFSFEDCXQH',AFSFEDCXQH_wrap_OnKeyDown);
function URZTYMSMYS_wrap_OnClick(event) {
return URZTYMSMYS_Click();
}
SPBOUILib.SetButtonClick('URZTYMSMYS',URZTYMSMYS_wrap_OnClick);
function WEIKCFSMRK_wrap_OnClick(event) {
return WEIKCFSMRK_Click();
}
SPBOUILib.SetButtonClick('WEIKCFSMRK',WEIKCFSMRK_wrap_OnClick);
if (Ne(m_cFunction,'view')) {
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
function DZWSXMBIHR_wrap_Valid(event) {
return DZWSXMBIHR_Valid(event);
}
SPBOUILib.SetInputExit('DZWSXMBIHR',DZWSXMBIHR_wrap_Valid);
function DZWSXMBIHR_wrap_OnFocus(event) {
return DZWSXMBIHR_OnFocus(event);
}
SPBOUILib.SetInputEnter('DZWSXMBIHR',DZWSXMBIHR_wrap_OnFocus);
function DZWSXMBIHR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DZWSXMBIHR',DZWSXMBIHR_wrap_OnKeyDown);
function DZWSXMBIHR_ZOOM_setHandlers() {
function DZWSXMBIHR_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?DZWSXMBIHR_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('DZWSXMBIHR_ZOOM',DZWSXMBIHR_ZOOM_wrap_OnClick);
function DZWSXMBIHR_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('DZWSXMBIHR_ZOOM',DZWSXMBIHR_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('DZWSXMBIHR',DZWSXMBIHR_ZOOM_setHandlers);
function HUMSCLHVTQ_wrap_Valid(event) {
return HUMSCLHVTQ_Valid(event);
}
SPBOUILib.SetInputExit('HUMSCLHVTQ',HUMSCLHVTQ_wrap_Valid);
function HUMSCLHVTQ_wrap_OnFocus(event) {
return HUMSCLHVTQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('HUMSCLHVTQ',HUMSCLHVTQ_wrap_OnFocus);
function HUMSCLHVTQ_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('HUMSCLHVTQ',HUMSCLHVTQ_wrap_OnKeyPress);
function HUMSCLHVTQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('HUMSCLHVTQ',HUMSCLHVTQ_wrap_OnKeyDown);
function VXGCUGFCOM_wrap_Valid(event) {
return VXGCUGFCOM_Valid(event);
}
SPBOUILib.SetInputExit('VXGCUGFCOM',VXGCUGFCOM_wrap_Valid);
function VXGCUGFCOM_wrap_OnFocus(event) {
return VXGCUGFCOM_OnFocus(event);
}
SPBOUILib.SetInputEnter('VXGCUGFCOM',VXGCUGFCOM_wrap_OnFocus);
function VXGCUGFCOM_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('VXGCUGFCOM',VXGCUGFCOM_wrap_OnKeyPress);
function VXGCUGFCOM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('VXGCUGFCOM',VXGCUGFCOM_wrap_OnKeyDown);
function OYBCLSBWWU_wrap_Valid(event) {
return OYBCLSBWWU_Valid(event);
}
SPBOUILib.SetCheckboxClick('OYBCLSBWWU',OYBCLSBWWU_wrap_Valid);
function OYBCLSBWWU_wrap_OnFocus(event) {
return OYBCLSBWWU_OnFocus(event);
}
SPBOUILib.SetInputEnter('OYBCLSBWWU',OYBCLSBWWU_wrap_OnFocus);
function OYBCLSBWWU_wrap_Blur(event) {
return OYBCLSBWWU_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('OYBCLSBWWU',OYBCLSBWWU_wrap_Blur);
function EDCVGCRZZZ_wrap_Valid(event) {
return EDCVGCRZZZ_Valid(event);
}
SPBOUILib.SetInputExit('EDCVGCRZZZ',EDCVGCRZZZ_wrap_Valid);
function EDCVGCRZZZ_wrap_OnFocus(event) {
return EDCVGCRZZZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('EDCVGCRZZZ',EDCVGCRZZZ_wrap_OnFocus);
function EDCVGCRZZZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('EDCVGCRZZZ',EDCVGCRZZZ_wrap_OnKeyDown);
function JINDLZUJGB_wrap_Valid(event) {
return JINDLZUJGB_Valid(event);
}
SPBOUILib.SetInputExit('JINDLZUJGB',JINDLZUJGB_wrap_Valid);
function JINDLZUJGB_wrap_OnFocus(event) {
return JINDLZUJGB_OnFocus(event);
}
SPBOUILib.SetInputEnter('JINDLZUJGB',JINDLZUJGB_wrap_OnFocus);
function JINDLZUJGB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JINDLZUJGB',JINDLZUJGB_wrap_OnKeyDown);
function RZXJJIHWRO_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('RZXJJIHWRO',RZXJJIHWRO_wrap_OnKeyDown);
function LBDAXRYAIV_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('LBDAXRYAIV',LBDAXRYAIV_wrap_OnKeyDown);
function ZDQIQPDLMA_wrap_Valid(event) {
return ZDQIQPDLMA_Valid(event);
}
SPBOUILib.SetInputExit('ZDQIQPDLMA',ZDQIQPDLMA_wrap_Valid);
function ZDQIQPDLMA_wrap_OnFocus(event) {
return ZDQIQPDLMA_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZDQIQPDLMA',ZDQIQPDLMA_wrap_OnFocus);
function ZDQIQPDLMA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZDQIQPDLMA',ZDQIQPDLMA_wrap_OnKeyDown);
function AOOZEQQJTQ_wrap_Valid(event) {
return AOOZEQQJTQ_Valid(event);
}
SPBOUILib.SetInputExit('AOOZEQQJTQ',AOOZEQQJTQ_wrap_Valid);
function AOOZEQQJTQ_wrap_OnFocus(event) {
return AOOZEQQJTQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('AOOZEQQJTQ',AOOZEQQJTQ_wrap_OnFocus);
function AOOZEQQJTQ_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('AOOZEQQJTQ',AOOZEQQJTQ_wrap_OnKeyPress);
function AOOZEQQJTQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('AOOZEQQJTQ',AOOZEQQJTQ_wrap_OnKeyDown);
function WSCNNXSPZE_wrap_Valid(event) {
return WSCNNXSPZE_Valid(event);
}
SPBOUILib.SetCheckboxClick('WSCNNXSPZE',WSCNNXSPZE_wrap_Valid);
function WSCNNXSPZE_wrap_OnFocus(event) {
return WSCNNXSPZE_OnFocus(event);
}
SPBOUILib.SetInputEnter('WSCNNXSPZE',WSCNNXSPZE_wrap_OnFocus);
function WSCNNXSPZE_wrap_Blur(event) {
return WSCNNXSPZE_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('WSCNNXSPZE',WSCNNXSPZE_wrap_Blur);
function IYTHKZIUFV_wrap_Valid(event) {
return IYTHKZIUFV_Valid(event);
}
SPBOUILib.SetInputExit('IYTHKZIUFV',IYTHKZIUFV_wrap_Valid);
function IYTHKZIUFV_wrap_OnFocus(event) {
return IYTHKZIUFV_OnFocus(event);
}
SPBOUILib.SetInputEnter('IYTHKZIUFV',IYTHKZIUFV_wrap_OnFocus);
function IYTHKZIUFV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IYTHKZIUFV',IYTHKZIUFV_wrap_OnKeyDown);
function URGNQSTVHB_wrap_Valid(event) {
return URGNQSTVHB_Valid(event);
}
SPBOUILib.SetInputExit('URGNQSTVHB',URGNQSTVHB_wrap_Valid);
function URGNQSTVHB_wrap_OnFocus(event) {
return URGNQSTVHB_OnFocus(event);
}
SPBOUILib.SetInputEnter('URGNQSTVHB',URGNQSTVHB_wrap_OnFocus);
function URGNQSTVHB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('URGNQSTVHB',URGNQSTVHB_wrap_OnKeyDown);
function URZTYMSMYS_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('URZTYMSMYS',URZTYMSMYS_wrap_OnKeyDown);
function WEIKCFSMRK_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('WEIKCFSMRK',WEIKCFSMRK_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["JHOQNVHZXH"]};
FocusFirstComponent.query={"page_1":["JHOQNVHZXH"]};
FocusFirstComponent.otherwise={"page_1":["JHOQNVHZXH"]};
function Help() {
windowOpenForeground('../doc/armt_ae_aeoprig_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
GetLayerID.Layers.push({"id":"HDQLRPYTAN","name":"box_HDQLRPYTAN"});
GetLayerID.Layers.push({"id":"KPRGKTCWLJ","name":"box_KPRGKTCWLJ"});
GetLayerID.Layers.push({"id":"FXPPJOXLEV","name":"box_FXPPJOXLEV"});
function DeclareWVs() {
var a = arguments;
w_RAPPORTO=a[0];
w_COINT=a[1];
w_TIPOAG=a[2];
w_IDBASE=a[3];
op_IDBASE=a[4];
w_CONNESINT=a[5];
w_ADATA=a[6];
w_ADATARET=a[7];
w_ASPEDITO=a[8];
w_AFILE=a[9];
w_APROG=a[10];
w_AOLDPROG=a[11];
w_AOLDFILE=a[12];
w_CSPEDITO=a[13];
w_CPROG=a[14];
w_COLDPROG=a[15];
w_CFILE=a[16];
w_COLDFILE=a[17];
w_IDRIF=a[18];
w_ADTPRE=a[19];
w_CDTPRE=a[20];
w_CDATA=a[21];
w_CDATARET=a[22];
w_NOCODFISC=a[23];
w_IDESITO=a[24];
w_DATESITO=a[25];
w_PROGOPX=a[26];
op_PROGOPX=a[27];
w_RSPEDITO=a[28];
w_xragsoc=a[29];
w_dtcanc=a[30];
w_spcanc=a[31];
w_filecanc=a[32];
w_idcanc=a[33];
w_xcfestero=a[34];
w_desctrap=a[35];
op_codazi=a[36];
if (Gt(a.length,37)) {
o_IDBASE=w_IDBASE;
}
m_PrimaryKeys=['IDBASE'];
}
function i_PrimaryKey() {
return 'aeoprig'+'\\'+CPLib.ToCPStr(w_IDBASE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_ae_aeoprig',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CONNESINT,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xragsoc,'C'); },"field":"RAGSOC","type":"C"},{"expression":function() { return WtA(w_xcfestero,'N'); },"field":"CFESTERO","type":"N"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"DZWSXMBIHR"});
}
_Obli('DATESITO',2,'AOOZEQQJTQ',false,"10859751047")
_Obli('COINT',0,'JHOQNVHZXH',false,"1723736132")
_Obli('TIPOAG',0,'BHAVHLFPAC',false)
_Obli('RSPEDITO',1,'WSCNNXSPZE',false)
_Obli('CONNESINT',0,'DZWSXMBIHR',false,"10580790440")
_Obli('ADATA',2,'HUMSCLHVTQ',false,"45547646")
_Obli('ADATARET',2,'VXGCUGFCOM',false,"11329559720")
_Obli('ASPEDITO',1,'OYBCLSBWWU',false,"1265210153")
_Obli('AFILE',0,'EDCVGCRZZZ',false,"1027202812")
_Obli('APROG',0,'JINDLZUJGB',false,"11446421191")
_Obli('COLDFILE',0,'AGVEMIAUQV',false,"863382899")
_Obli('COLDFILE',0,'IYTHKZIUFV',false)
_Obli('COLDPROG',0,'NAJNVPLZYU',false,"533198559")
_Obli('COLDPROG',0,'URGNQSTVHB',false)
_Obli('IDESITO',0,'ZDQIQPDLMA',false,"11284067142")
