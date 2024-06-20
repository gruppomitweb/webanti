function FillCombosValues() {
FillCombo('BHAVHLFPAC','BHAVHLFPAC');
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('LXORWVRYJJ',function(){return WtH(w_RAPPORTO,'C',25,0,'')},w_RAPPORTO);
if(c=Ctrl('JHOQNVHZXH')) selectCombo(c,w_COINT,'C')
if(c=Ctrl('BHAVHLFPAC')) selectCombo(c,w_TIPOAG,'C')
SPBOUILib.SetInputValue('DZWSXMBIHR',function(){return WtH(w_CONNESINT,'C',16,0,'')},w_CONNESINT);
SPBOUILib.SetInputValue('HUMSCLHVTQ',function(){return WtH(w_ADATA,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_ADATA);
if(c=Ctrl('OYBCLSBWWU')) ChkboxCheckUncheck(c,1,w_ASPEDITO)
if(c=Ctrl('OYBCLSBWWU')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('EDCVGCRZZZ',function(){return WtH(w_AFILE,'C',15,0,'')},w_AFILE);
SPBOUILib.SetInputValue('JINDLZUJGB',function(){return WtH(w_APROG,'C',25,0,'')},w_APROG);
if(c=Ctrl('LLONFBQGWC')) ChkboxCheckUncheck(c,1,w_CSPEDITO)
if(c=Ctrl('LLONFBQGWC')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('YFRSEVUKNF',function(){return WtH(w_CPROG,'C',25,0,'')},w_CPROG);
SPBOUILib.SetInputValue('HBCZFDMLIW',function(){return WtH(w_CFILE,'C',15,0,'')},w_CFILE);
var tmp_SVRLUYRVRK = ToHTag(AsControlValue(w_xragsoc));
if (Ne(e_SVRLUYRVRK,tmp_SVRLUYRVRK)) {
SPBOUILib.SetLabelValue('SVRLUYRVRK','innerHTML',tmp_SVRLUYRVRK);
e_SVRLUYRVRK=tmp_SVRLUYRVRK;
}
SPBOUILib.SetInputValue('EYLNNWDCKZ',function(){return WtH(w_CDATA,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_CDATA);
SPBOUILib.SetInputValue('ZDQIQPDLMA',function(){return WtH(w_IDESITO,'C',8,0,'')},w_IDESITO);
SPBOUILib.SetInputValue('GVMNAQQJWY',function(){return WtH(w_ADATARET,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_ADATARET);
if(c=Ctrl('JDNKWMLZTI')) ChkboxCheckUncheck(c,1,w_RSPEDITO)
if(c=Ctrl('JDNKWMLZTI')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('JWUIHKTDYH',function(){return WtH(w_COLDFILE,'C',15,0,'')},w_COLDFILE);
SPBOUILib.SetInputValue('JCJVALRBTS',function(){return WtH(w_COLDPROG,'C',25,0,'')},w_COLDPROG);
SPBOUILib.SetInputValue('FMXMNQMEMH',function(){return WtH(w_dtcanc,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_dtcanc);
if(c=Ctrl('GRVAHWHFJH')) ChkboxCheckUncheck(c,1,w_spcanc)
if(c=Ctrl('GRVAHWHFJH')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('TZPQRTXHYT',function(){return WtH(w_filecanc,'C',15,0,'')},w_filecanc);
SPBOUILib.SetInputValue('GWASKALOUK',function(){return WtH(w_idcanc,'C',25,0,'')},w_idcanc);
SPBOUILib.SetInputValue('UCLGIPKHHK',function(){return WtH(w_DATESITO,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATESITO);
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
SetDisplay('SWHJSXDMQR_DIV',IsHiddenByStateDriver('box_SWHJSXDMQR'));
SetDisplay(Ctrl('RZXJJIHWRO'),Empty(w_RAPPORTO) || Eq(w_ASPEDITO,0));
SetDisplay(Ctrl('LBDAXRYAIV'),Empty(w_RAPPORTO) || Eq(w_ASPEDITO,0));
SetDisplay('HDQLRPYTAN_DIV',IsHiddenByStateDriver('box_HDQLRPYTAN'));
SetDisplay('ZUHLCKITMM_DIV',IsHiddenByStateDriver('box_ZUHLCKITMM'));
SetDisplay('TNLEGEGWAQ_DIV',IsHiddenByStateDriver('box_TNLEGEGWAQ'));
SetDisplay('NNCELEXRKP_DIV',IsHiddenByStateDriver('box_NNCELEXRKP'));
SetDisplay(Ctrl('VQNRBICOXA'),Empty(w_dtcanc));
SetDisplay(Ctrl('URZTYMSMYS'),Empty(w_ADATARET) || ( ! (Empty(w_ADATARET)) && Eq(w_RSPEDITO,1)));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["ADATA"]=['EEPWGWPHCL'];
HideUI.lblids["ADATARET"]=['ZQIDHWPUXR'];
HideUI.lblids["CDATA"]=['SXESAQVPYH'];
HideUI.lblids["COINT"]=['GDTYXHVEHO'];
HideUI.lblids["CONNESINT"]=['TOFVCFNDFU'];
HideUI.lblids["DATESITO"]=['CYWLVXKPWG'];
HideUI.lblids["IDESITO"]=['YBLTSMLFUZ'];
HideUI.lblids["RAPPORTO"]=['OICGZUOZYP'];
HideUI.lblids["TIPOAG"]=['CTCKWHZVTZ'];
HideUI.lblids["dtcanc"]=['WJDBESRNAN'];
function LXORWVRYJJ_Valid(e) {
SetActiveField(Ctrl('LXORWVRYJJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RAPPORTO','C',w_RAPPORTO,HtW(Ctrl('LXORWVRYJJ').value,'C'));
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
function LLONFBQGWC_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('CSPEDITO','N',w_CSPEDITO,ChkboxValueAssign(Ctrl('LLONFBQGWC'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CSPEDITO(ChkboxValueAssign(Ctrl('LLONFBQGWC'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function LLONFBQGWC_OnFocus(e) {
SetActiveField(Ctrl('LLONFBQGWC'),true);
}
function LLONFBQGWC_OnBlur(e) {
SetActiveField(Ctrl('LLONFBQGWC'),false);
}
function YFRSEVUKNF_Valid(e) {
SetActiveField(Ctrl('YFRSEVUKNF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CPROG','C',w_CPROG,HtW(Ctrl('YFRSEVUKNF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CPROG(HtW(Ctrl('YFRSEVUKNF').value,'C'),null,e);
return l_bSetResult;
}
}
function YFRSEVUKNF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YFRSEVUKNF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YFRSEVUKNF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YFRSEVUKNF'),e);
}
function HBCZFDMLIW_Valid(e) {
SetActiveField(Ctrl('HBCZFDMLIW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CFILE','C',w_CFILE,HtW(Ctrl('HBCZFDMLIW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CFILE(HtW(Ctrl('HBCZFDMLIW').value,'C'),null,e);
return l_bSetResult;
}
}
function HBCZFDMLIW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HBCZFDMLIW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HBCZFDMLIW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HBCZFDMLIW'),e);
}
function EYLNNWDCKZ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('EYLNNWDCKZ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('EYLNNWDCKZ').value=ApplyPictureToDate(Ctrl('EYLNNWDCKZ').value,TranslatePicture(datePattern),'EYLNNWDCKZ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('EYLNNWDCKZ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('EYLNNWDCKZ');
}
}
}
SetActiveField(Ctrl('EYLNNWDCKZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CDATA','D',w_CDATA,HtW(Ctrl('EYLNNWDCKZ').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CDATA(HtW(Ctrl('EYLNNWDCKZ').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function EYLNNWDCKZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EYLNNWDCKZ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('EYLNNWDCKZ',w_CDATA,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('EYLNNWDCKZ');
SetActiveField(Ctrl('EYLNNWDCKZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EYLNNWDCKZ'),e);
}
function RZXJJIHWRO_Click() {
if ( ! (Empty(w_RAPPORTO)) && Eq(w_ASPEDITO,1) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'edit'))) {
ModOpen()
}
}
function LBDAXRYAIV_Click() {
if ( ! (Empty(w_RAPPORTO)) && Eq(w_ASPEDITO,1) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'edit'))) {
ModClose()
}
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
function GVMNAQQJWY_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('GVMNAQQJWY'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('GVMNAQQJWY').value=ApplyPictureToDate(Ctrl('GVMNAQQJWY').value,TranslatePicture(datePattern),'GVMNAQQJWY');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('GVMNAQQJWY'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('GVMNAQQJWY');
}
}
}
SetActiveField(Ctrl('GVMNAQQJWY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ADATARET','D',w_ADATARET,HtW(Ctrl('GVMNAQQJWY').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ADATARET(HtW(Ctrl('GVMNAQQJWY').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function GVMNAQQJWY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GVMNAQQJWY'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('GVMNAQQJWY',w_ADATARET,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('GVMNAQQJWY');
SetActiveField(Ctrl('GVMNAQQJWY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GVMNAQQJWY'),e);
}
function JDNKWMLZTI_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('RSPEDITO','N',w_RSPEDITO,ChkboxValueAssign(Ctrl('JDNKWMLZTI'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RSPEDITO(ChkboxValueAssign(Ctrl('JDNKWMLZTI'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function JDNKWMLZTI_OnFocus(e) {
SetActiveField(Ctrl('JDNKWMLZTI'),true);
}
function JDNKWMLZTI_OnBlur(e) {
SetActiveField(Ctrl('JDNKWMLZTI'),false);
}
function JWUIHKTDYH_Valid(e) {
SetActiveField(Ctrl('JWUIHKTDYH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('COLDFILE','C',w_COLDFILE,HtW(Ctrl('JWUIHKTDYH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_COLDFILE(HtW(Ctrl('JWUIHKTDYH').value,'C'),null,e);
return l_bSetResult;
}
}
function JWUIHKTDYH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JWUIHKTDYH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JWUIHKTDYH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JWUIHKTDYH'),e);
}
function JCJVALRBTS_Valid(e) {
SetActiveField(Ctrl('JCJVALRBTS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('COLDPROG','C',w_COLDPROG,HtW(Ctrl('JCJVALRBTS').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_COLDPROG(HtW(Ctrl('JCJVALRBTS').value,'C'),null,e);
return l_bSetResult;
}
}
function JCJVALRBTS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JCJVALRBTS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JCJVALRBTS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JCJVALRBTS'),e);
}
function URZTYMSMYS_Click() {
if (Eq(m_cFunction,'view')) {
if (false || WindowConfirm(Translate('11741368204'))) {
arrt_delret_aederig([["w_IDBASE",w_IDBASE],["w_RAPPORTO",w_RAPPORTO],["w_ADATARET",w_ADATARET]])
}
}
}
function UCLGIPKHHK_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('UCLGIPKHHK'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('UCLGIPKHHK').value=ApplyPictureToDate(Ctrl('UCLGIPKHHK').value,TranslatePicture(datePattern),'UCLGIPKHHK');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('UCLGIPKHHK'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('UCLGIPKHHK');
}
}
}
SetActiveField(Ctrl('UCLGIPKHHK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATESITO','D',w_DATESITO,HtW(Ctrl('UCLGIPKHHK').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATESITO(HtW(Ctrl('UCLGIPKHHK').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function UCLGIPKHHK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UCLGIPKHHK'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('UCLGIPKHHK',w_DATESITO,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('UCLGIPKHHK');
SetActiveField(Ctrl('UCLGIPKHHK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UCLGIPKHHK'),e);
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
function URZTYMSMYS_wrap_OnClick(event) {
return URZTYMSMYS_Click();
}
SPBOUILib.SetButtonClick('URZTYMSMYS',URZTYMSMYS_wrap_OnClick);
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
function LLONFBQGWC_wrap_Valid(event) {
return LLONFBQGWC_Valid(event);
}
SPBOUILib.SetCheckboxClick('LLONFBQGWC',LLONFBQGWC_wrap_Valid);
function LLONFBQGWC_wrap_OnFocus(event) {
return LLONFBQGWC_OnFocus(event);
}
SPBOUILib.SetInputEnter('LLONFBQGWC',LLONFBQGWC_wrap_OnFocus);
function LLONFBQGWC_wrap_Blur(event) {
return LLONFBQGWC_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('LLONFBQGWC',LLONFBQGWC_wrap_Blur);
function YFRSEVUKNF_wrap_Valid(event) {
return YFRSEVUKNF_Valid(event);
}
SPBOUILib.SetInputExit('YFRSEVUKNF',YFRSEVUKNF_wrap_Valid);
function YFRSEVUKNF_wrap_OnFocus(event) {
return YFRSEVUKNF_OnFocus(event);
}
SPBOUILib.SetInputEnter('YFRSEVUKNF',YFRSEVUKNF_wrap_OnFocus);
function YFRSEVUKNF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YFRSEVUKNF',YFRSEVUKNF_wrap_OnKeyDown);
function HBCZFDMLIW_wrap_Valid(event) {
return HBCZFDMLIW_Valid(event);
}
SPBOUILib.SetInputExit('HBCZFDMLIW',HBCZFDMLIW_wrap_Valid);
function HBCZFDMLIW_wrap_OnFocus(event) {
return HBCZFDMLIW_OnFocus(event);
}
SPBOUILib.SetInputEnter('HBCZFDMLIW',HBCZFDMLIW_wrap_OnFocus);
function HBCZFDMLIW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HBCZFDMLIW',HBCZFDMLIW_wrap_OnKeyDown);
function EYLNNWDCKZ_wrap_Valid(event) {
return EYLNNWDCKZ_Valid(event);
}
SPBOUILib.SetInputExit('EYLNNWDCKZ',EYLNNWDCKZ_wrap_Valid);
function EYLNNWDCKZ_wrap_OnFocus(event) {
return EYLNNWDCKZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('EYLNNWDCKZ',EYLNNWDCKZ_wrap_OnFocus);
function EYLNNWDCKZ_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('EYLNNWDCKZ',EYLNNWDCKZ_wrap_OnKeyPress);
function EYLNNWDCKZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('EYLNNWDCKZ',EYLNNWDCKZ_wrap_OnKeyDown);
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
function GVMNAQQJWY_wrap_Valid(event) {
return GVMNAQQJWY_Valid(event);
}
SPBOUILib.SetInputExit('GVMNAQQJWY',GVMNAQQJWY_wrap_Valid);
function GVMNAQQJWY_wrap_OnFocus(event) {
return GVMNAQQJWY_OnFocus(event);
}
SPBOUILib.SetInputEnter('GVMNAQQJWY',GVMNAQQJWY_wrap_OnFocus);
function GVMNAQQJWY_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('GVMNAQQJWY',GVMNAQQJWY_wrap_OnKeyPress);
function GVMNAQQJWY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('GVMNAQQJWY',GVMNAQQJWY_wrap_OnKeyDown);
function JDNKWMLZTI_wrap_Valid(event) {
return JDNKWMLZTI_Valid(event);
}
SPBOUILib.SetCheckboxClick('JDNKWMLZTI',JDNKWMLZTI_wrap_Valid);
function JDNKWMLZTI_wrap_OnFocus(event) {
return JDNKWMLZTI_OnFocus(event);
}
SPBOUILib.SetInputEnter('JDNKWMLZTI',JDNKWMLZTI_wrap_OnFocus);
function JDNKWMLZTI_wrap_Blur(event) {
return JDNKWMLZTI_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('JDNKWMLZTI',JDNKWMLZTI_wrap_Blur);
function JWUIHKTDYH_wrap_Valid(event) {
return JWUIHKTDYH_Valid(event);
}
SPBOUILib.SetInputExit('JWUIHKTDYH',JWUIHKTDYH_wrap_Valid);
function JWUIHKTDYH_wrap_OnFocus(event) {
return JWUIHKTDYH_OnFocus(event);
}
SPBOUILib.SetInputEnter('JWUIHKTDYH',JWUIHKTDYH_wrap_OnFocus);
function JWUIHKTDYH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JWUIHKTDYH',JWUIHKTDYH_wrap_OnKeyDown);
function JCJVALRBTS_wrap_Valid(event) {
return JCJVALRBTS_Valid(event);
}
SPBOUILib.SetInputExit('JCJVALRBTS',JCJVALRBTS_wrap_Valid);
function JCJVALRBTS_wrap_OnFocus(event) {
return JCJVALRBTS_OnFocus(event);
}
SPBOUILib.SetInputEnter('JCJVALRBTS',JCJVALRBTS_wrap_OnFocus);
function JCJVALRBTS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JCJVALRBTS',JCJVALRBTS_wrap_OnKeyDown);
function URZTYMSMYS_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('URZTYMSMYS',URZTYMSMYS_wrap_OnKeyDown);
function UCLGIPKHHK_wrap_Valid(event) {
return UCLGIPKHHK_Valid(event);
}
SPBOUILib.SetInputExit('UCLGIPKHHK',UCLGIPKHHK_wrap_Valid);
function UCLGIPKHHK_wrap_OnFocus(event) {
return UCLGIPKHHK_OnFocus(event);
}
SPBOUILib.SetInputEnter('UCLGIPKHHK',UCLGIPKHHK_wrap_OnFocus);
function UCLGIPKHHK_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('UCLGIPKHHK',UCLGIPKHHK_wrap_OnKeyPress);
function UCLGIPKHHK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('UCLGIPKHHK',UCLGIPKHHK_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["LXORWVRYJJ"]};
FocusFirstComponent.query={"page_1":["LXORWVRYJJ"]};
FocusFirstComponent.otherwise={"page_1":["LXORWVRYJJ"]};
function Help() {
windowOpenForeground('../doc/armt_ae_aedelrig_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
GetLayerID.Layers.push({"id":"HDQLRPYTAN","name":"box_HDQLRPYTAN"});
GetLayerID.Layers.push({"id":"ZUHLCKITMM","name":"box_ZUHLCKITMM"});
GetLayerID.Layers.push({"id":"TNLEGEGWAQ","name":"box_TNLEGEGWAQ"});
GetLayerID.Layers.push({"id":"NNCELEXRKP","name":"box_NNCELEXRKP"});
function DeclareWVs() {
var a = arguments;
w_RAPPORTO=a[0];
w_COINT=a[1];
w_TIPOAG=a[2];
w_IDBASE=a[3];
op_IDBASE=a[4];
w_CONNESINT=a[5];
w_ADATA=a[6];
w_ASPEDITO=a[7];
w_AFILE=a[8];
w_APROG=a[9];
w_AOLDPROG=a[10];
w_AOLDFILE=a[11];
w_CSPEDITO=a[12];
w_CPROG=a[13];
w_COLDPROG=a[14];
w_CFILE=a[15];
w_COLDFILE=a[16];
w_IDRIF=a[17];
w_NOCODFISC=a[18];
w_ADTPRE=a[19];
w_CDTPRE=a[20];
w_CDATA=a[21];
w_IDESITO=a[22];
w_PROGDLG=a[23];
op_PROGDLG=a[24];
w_ADATARET=a[25];
w_RSPEDITO=a[26];
w_DATESITO=a[27];
w_xcfestero=a[28];
w_xragsoc=a[29];
w_desctrap=a[30];
w_dtcanc=a[31];
w_spcanc=a[32];
w_filecanc=a[33];
w_idcanc=a[34];
op_codazi=a[35];
if (Gt(a.length,36)) {
o_IDBASE=w_IDBASE;
}
m_PrimaryKeys=['IDBASE'];
}
function i_PrimaryKey() {
return 'aederig'+'\\'+CPLib.ToCPStr(w_IDBASE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_ae_aedelrig',m_cSelectedPage);
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
_Obli('RAPPORTO',0,'LXORWVRYJJ',false,"11116511596")
_Obli('COINT',0,'JHOQNVHZXH',false,"1723736132")
_Obli('TIPOAG',0,'BHAVHLFPAC',false)
_Obli('CPROG',0,'YFRSEVUKNF',false,"910975989")
_Obli('CONNESINT',0,'DZWSXMBIHR',false,"10580790440")
_Obli('CFILE',0,'HBCZFDMLIW',false,"1039309729")
_Obli('ADATA',2,'HUMSCLHVTQ',false,"45547646")
_Obli('ASPEDITO',1,'OYBCLSBWWU',false,"1265210153")
_Obli('AFILE',0,'EDCVGCRZZZ',false,"1027202812")
_Obli('APROG',0,'JINDLZUJGB',false,"11446421191")
_Obli('DATESITO',2,'UCLGIPKHHK',false,"1025726040")
_Obli('RSPEDITO',1,'JDNKWMLZTI',false)
_Obli('CSPEDITO',1,'LLONFBQGWC',false,"218917798")
_Obli('COLDFILE',0,'AGVEMIAUQV',false,"863382899")
_Obli('COLDFILE',0,'JWUIHKTDYH',false,"863382899")
_Obli('COLDPROG',0,'NAJNVPLZYU',false,"533198559")
_Obli('COLDPROG',0,'JCJVALRBTS',false,"533198559")
_Obli('CDATA',2,'EYLNNWDCKZ',false,"45547646")
_Obli('ADATARET',2,'GVMNAQQJWY',false,"11329559720")
_Obli('IDESITO',0,'ZDQIQPDLMA',false,"11284067142")
