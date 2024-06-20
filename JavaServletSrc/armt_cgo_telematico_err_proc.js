function FillCombosValues() {
FillCombo('WJQFIEBCQV','WJQFIEBCQV');
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('GSWVKRDVIZ',function(){return WtH(w_SNAINUMOPE,'C',15,0,'')},w_SNAINUMOPE);
if(c=Ctrl('XUFFKSTRWQ')) selectCombo(c,w_ENV,'C')
SPBOUILib.SetInputValue('YMJRPKIKSX',function(){return WtH(w_CODDIPE,'C',6,0,'')},w_CODDIPE);
SPBOUILib.SetInputValue('DSKEQYLWDR',function(){return WtH(w_RAPPORTO,'C',25,0,'')},w_RAPPORTO);
SPBOUILib.SetInputValue('UQYWDDPGQG',function(){return WtH(w_TOTLIRE,'N',15,2,'999999999999.99')},w_TOTLIRE);
SPBOUILib.SetInputValue('NSVLOKQVAT',function(){return WtH(w_CADATAORA,'T',14,0,TranslatePicture(GetDatePicture(true,'T'),'T'))},w_CADATAORA);
SPBOUILib.SetInputValue('YMUBWPUUZX',function(){return WtH(w_CAIDBIGLIETTO,'C',28,0,'')},w_CAIDBIGLIETTO);
SPBOUILib.SetInputValue('MMAJBBOTBM',function(){return WtH(w_IPCOLLEG,'C',20,0,'')},w_IPCOLLEG);
SPBOUILib.SetInputValue('FLDKXDUZMH',function(){return WtH(w_ORACOLLEG,'T',14,0,TranslatePicture(GetDatePicture(true,'T'),'T'))},w_ORACOLLEG);
SPBOUILib.SetInputValue('RUIEOGJHQL',function(){return WtH(w_DUCOLLEG,'N',10,0,'9999999999')},w_DUCOLLEG);
SPBOUILib.SetInputValue('TVQKRQXOUS',function(){return WtH(w_TXTERR,'M',10,0,'')},w_TXTERR);
var tmp_DEIMFQSLOV = ToHTag(AsControlValue(w_xdesdip));
if (Ne(e_DEIMFQSLOV,tmp_DEIMFQSLOV)) {
SPBOUILib.SetLabelValue('DEIMFQSLOV','innerHTML',tmp_DEIMFQSLOV);
e_DEIMFQSLOV=tmp_DEIMFQSLOV;
}
if(c=Ctrl('EOSKLIUGBC')) selectCombo(c,w_MEZPAGAM,'C')
SPBOUILib.SetInputValue('UTUCDPQJKK',function(){return WtH(w_IBAN,'C',27,0,'@!')},w_IBAN);
var tmp_NDJOCZNQIT = ToHTag(AsControlValue(w_xdesrap));
if (Ne(e_NDJOCZNQIT,tmp_NDJOCZNQIT)) {
SPBOUILib.SetLabelValue('NDJOCZNQIT','innerHTML',tmp_NDJOCZNQIT);
e_NDJOCZNQIT=tmp_NDJOCZNQIT;
}
if(c=Ctrl('WJQFIEBCQV')) selectCombo(c,w_CACODICE,'N')
if(c=Ctrl('AYCRVWSEMG')) ChkboxCheckUncheck(c,'S',w_FLGFULL)
if(c=Ctrl('AYCRVWSEMG')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('XQXYVWITMV',function(){return WtH(w_CATIPGIO,'N',5,0,'')},w_CATIPGIO);
SPBOUILib.SetInputValue('BRJUUNWDMJ',function(){return WtH(w_CATIPCON,'N',5,0,'')},w_CATIPCON);
SPBOUILib.SetInputValue('CTQAPOFAUI',function(){return WtH(w_CAPV_COD,'N',10,0,'')},w_CAPV_COD);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay('PIMVZFFAWF_DIV',IsHiddenByStateDriver('Dati'));
SetDisplay('MKZZTQTPHW_DIV',IsHiddenByStateDriver('Errori'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["CACODICE"]=['YFGRJCQGZV'];
HideUI.lblids["CADATAORA"]=['PNRWGGQEBO'];
HideUI.lblids["CAIDBIGLIETTO"]=['NCFFVJFTNT'];
HideUI.lblids["CAPV_COD"]=['HCCCMVVWJX'];
HideUI.lblids["CATIPCON"]=['VUQKRXMESB'];
HideUI.lblids["CATIPGIO"]=['HKGTRSYYFU'];
HideUI.lblids["CODDIPE"]=['EAZRWDNQMQ'];
HideUI.lblids["DUCOLLEG"]=['RBBHENRBWM'];
HideUI.lblids["ENV"]=['HOGUHQBZIF'];
HideUI.lblids["IBAN"]=['PBHNLOUBML'];
HideUI.lblids["IPCOLLEG"]=['LSAYIFWCRN'];
HideUI.lblids["MEZPAGAM"]=['VQCVMXHDPB'];
HideUI.lblids["ORACOLLEG"]=['PEYKVSMVYE'];
HideUI.lblids["RAPPORTO"]=['NANPPGWHGJ'];
HideUI.lblids["SNAINUMOPE"]=['RUJPODETQU'];
HideUI.lblids["TOTLIRE"]=['YJAJNAZWNB'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function GSWVKRDVIZ_Valid(e) {
SetActiveField(Ctrl('GSWVKRDVIZ'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('GSWVKRDVIZ') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('SNAINUMOPE','C',w_SNAINUMOPE,HtW(Ctrl('GSWVKRDVIZ').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SNAINUMOPE(HtW(Ctrl('GSWVKRDVIZ').value,'C'),null,e);
return l_bSetResult;
}
}
function GSWVKRDVIZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GSWVKRDVIZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GSWVKRDVIZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GSWVKRDVIZ'),e);
}
function GSWVKRDVIZ_ZOOM_Click() {
}
function XUFFKSTRWQ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('ENV','C',w_ENV,HtW(getComboValue(Ctrl('XUFFKSTRWQ')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ENV(HtW(getComboValue(Ctrl('XUFFKSTRWQ')),'C'),null,e);
return l_bSetResult;
}
}
function XUFFKSTRWQ_OnFocus(e) {
SetActiveField(Ctrl('XUFFKSTRWQ'),true);
}
function XUFFKSTRWQ_OnBlur(e) {
SetActiveField(Ctrl('XUFFKSTRWQ'),false);
}
function YMJRPKIKSX_Valid(e) {
SetActiveField(Ctrl('YMJRPKIKSX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODDIPE','C',w_CODDIPE,HtW(Ctrl('YMJRPKIKSX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODDIPE(HtW(Ctrl('YMJRPKIKSX').value,'C'),null,e);
return l_bSetResult;
}
}
function YMJRPKIKSX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YMJRPKIKSX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YMJRPKIKSX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YMJRPKIKSX'),e);
}
function YMJRPKIKSX_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('YMJRPKIKSX')),'linkview_YMJRPKIKSX','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function DSKEQYLWDR_Valid(e) {
SetActiveField(Ctrl('DSKEQYLWDR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RAPPORTO','C',w_RAPPORTO,HtW(Ctrl('DSKEQYLWDR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAPPORTO(HtW(Ctrl('DSKEQYLWDR').value,'C'),null,e);
return l_bSetResult;
}
}
function DSKEQYLWDR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DSKEQYLWDR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DSKEQYLWDR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DSKEQYLWDR'),e);
}
function DSKEQYLWDR_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('DSKEQYLWDR')),'linkview_DSKEQYLWDR','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function UQYWDDPGQG_Valid(e) {
SetActiveField(Ctrl('UQYWDDPGQG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TOTLIRE','N',w_TOTLIRE,HtW(Ctrl('UQYWDDPGQG').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TOTLIRE(HtW(Ctrl('UQYWDDPGQG').value,'N'),null,e);
return l_bSetResult;
}
}
function UQYWDDPGQG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UQYWDDPGQG'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('UQYWDDPGQG',w_TOTLIRE,'N',15,2,'999999999999.99');
SetActiveField(Ctrl('UQYWDDPGQG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UQYWDDPGQG'),e);
}
function UQYWDDPGQG_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999.99"));
}
function UQYWDDPGQG_ZOOM_Click() {
}
function NSVLOKQVAT_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('NSVLOKQVAT'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.datetimeLocal)) {
Ctrl('NSVLOKQVAT').value=ApplyPictureToDateTime(Ctrl('NSVLOKQVAT').value,TranslatePicture(dateTimePattern),'NSVLOKQVAT');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.datetimeLocal) {
CheckDateValidity(Ctrl('NSVLOKQVAT'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('NSVLOKQVAT');
}
}
}
SetActiveField(Ctrl('NSVLOKQVAT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CADATAORA','T',w_CADATAORA,HtW(Ctrl('NSVLOKQVAT').value,'T'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CADATAORA(HtW(Ctrl('NSVLOKQVAT').value,'T'),null,e) && dateisok;
return l_bSetResult;
}
}
function NSVLOKQVAT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NSVLOKQVAT'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.datetimeLocal)) {
SPBOUILib.WtH('NSVLOKQVAT',w_CADATAORA,'T',14,0,TranslatePicture(GetDatePicture(false,'T'),'T'));
}
m_oEnteredInDate=Ctrl('NSVLOKQVAT');
SetActiveField(Ctrl('NSVLOKQVAT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NSVLOKQVAT'),e);
}
function NSVLOKQVAT_ZOOM_Click() {
}
function YMUBWPUUZX_Valid(e) {
SetActiveField(Ctrl('YMUBWPUUZX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CAIDBIGLIETTO','C',w_CAIDBIGLIETTO,HtW(Ctrl('YMUBWPUUZX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAIDBIGLIETTO(HtW(Ctrl('YMUBWPUUZX').value,'C'),null,e);
return l_bSetResult;
}
}
function YMUBWPUUZX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YMUBWPUUZX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YMUBWPUUZX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YMUBWPUUZX'),e);
}
function YMUBWPUUZX_ZOOM_Click() {
}
function TVQKRQXOUS_Valid(e) {
SetActiveField(Ctrl('TVQKRQXOUS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TXTERR','M',w_TXTERR,HtW(Ctrl('TVQKRQXOUS').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TXTERR(HtW(Ctrl('TVQKRQXOUS').value,'M'),null,e);
return l_bSetResult;
}
}
function TVQKRQXOUS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TVQKRQXOUS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TVQKRQXOUS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TVQKRQXOUS'),e);
}
function EOSKLIUGBC_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('MEZPAGAM','C',w_MEZPAGAM,HtW(getComboValue(Ctrl('EOSKLIUGBC')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_MEZPAGAM(HtW(getComboValue(Ctrl('EOSKLIUGBC')),'C'),null,e);
return l_bSetResult;
}
}
function EOSKLIUGBC_OnFocus(e) {
SetActiveField(Ctrl('EOSKLIUGBC'),true);
}
function EOSKLIUGBC_OnBlur(e) {
SetActiveField(Ctrl('EOSKLIUGBC'),false);
}
function UTUCDPQJKK_Valid(e) {
SetActiveField(Ctrl('UTUCDPQJKK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IBAN','C',w_IBAN,HtW(Ctrl('UTUCDPQJKK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IBAN(HtW(Ctrl('UTUCDPQJKK').value,'C'),null,e);
return l_bSetResult;
}
}
function UTUCDPQJKK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UTUCDPQJKK'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('UTUCDPQJKK'))) {
SPBOUILib.WtH('UTUCDPQJKK',w_IBAN,'C',27,0,'@!');
}
SetActiveField(Ctrl('UTUCDPQJKK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UTUCDPQJKK'),e);
}
function UTUCDPQJKK_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function WJQFIEBCQV_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('CACODICE','N',w_CACODICE,HtW(getComboValue(Ctrl('WJQFIEBCQV')),'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CACODICE(HtW(getComboValue(Ctrl('WJQFIEBCQV')),'N'),null,e);
return l_bSetResult;
}
}
function WJQFIEBCQV_OnFocus(e) {
SetActiveField(Ctrl('WJQFIEBCQV'),true);
}
function WJQFIEBCQV_OnBlur(e) {
SetActiveField(Ctrl('WJQFIEBCQV'),false);
}
function AYCRVWSEMG_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGFULL','C',w_FLGFULL,ChkboxValueAssign(Ctrl('AYCRVWSEMG'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGFULL(ChkboxValueAssign(Ctrl('AYCRVWSEMG'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function AYCRVWSEMG_OnFocus(e) {
SetActiveField(Ctrl('AYCRVWSEMG'),true);
}
function AYCRVWSEMG_OnBlur(e) {
SetActiveField(Ctrl('AYCRVWSEMG'),false);
}
function XQXYVWITMV_Valid(e) {
SetActiveField(Ctrl('XQXYVWITMV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CATIPGIO','N',w_CATIPGIO,HtW(Ctrl('XQXYVWITMV').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CATIPGIO(HtW(Ctrl('XQXYVWITMV').value,'N'),null,e);
return l_bSetResult;
}
}
function XQXYVWITMV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XQXYVWITMV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XQXYVWITMV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XQXYVWITMV'),e);
}
function BRJUUNWDMJ_Valid(e) {
SetActiveField(Ctrl('BRJUUNWDMJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CATIPCON','N',w_CATIPCON,HtW(Ctrl('BRJUUNWDMJ').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CATIPCON(HtW(Ctrl('BRJUUNWDMJ').value,'N'),null,e);
return l_bSetResult;
}
}
function BRJUUNWDMJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BRJUUNWDMJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BRJUUNWDMJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BRJUUNWDMJ'),e);
}
function CTQAPOFAUI_Valid(e) {
SetActiveField(Ctrl('CTQAPOFAUI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CAPV_COD','N',w_CAPV_COD,HtW(Ctrl('CTQAPOFAUI').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAPV_COD(HtW(Ctrl('CTQAPOFAUI').value,'N'),null,e);
return l_bSetResult;
}
}
function CTQAPOFAUI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CTQAPOFAUI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CTQAPOFAUI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CTQAPOFAUI'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function GSWVKRDVIZ_wrap_Valid(event) {
return GSWVKRDVIZ_Valid(event);
}
SPBOUILib.SetInputExit('GSWVKRDVIZ',GSWVKRDVIZ_wrap_Valid);
function GSWVKRDVIZ_wrap_OnFocus(event) {
return GSWVKRDVIZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('GSWVKRDVIZ',GSWVKRDVIZ_wrap_OnFocus);
function GSWVKRDVIZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('GSWVKRDVIZ',GSWVKRDVIZ_wrap_OnKeyDown);
function GSWVKRDVIZ_ZOOM_setHandlers() {
function GSWVKRDVIZ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?GSWVKRDVIZ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('GSWVKRDVIZ_ZOOM',GSWVKRDVIZ_ZOOM_wrap_OnClick);
function GSWVKRDVIZ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('GSWVKRDVIZ_ZOOM',GSWVKRDVIZ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('GSWVKRDVIZ',GSWVKRDVIZ_ZOOM_setHandlers);
function XUFFKSTRWQ_wrap_Valid(event) {
return XUFFKSTRWQ_Valid(event);
}
SPBOUILib.SetComboChange('XUFFKSTRWQ',XUFFKSTRWQ_wrap_Valid);
function XUFFKSTRWQ_wrap_OnFocus(event) {
return XUFFKSTRWQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('XUFFKSTRWQ',XUFFKSTRWQ_wrap_OnFocus);
function XUFFKSTRWQ_wrap_Blur(event) {
return XUFFKSTRWQ_OnBlur(event);
}
SPBOUILib.SetInputExit('XUFFKSTRWQ',XUFFKSTRWQ_wrap_Blur);
function YMJRPKIKSX_wrap_Valid(event) {
return YMJRPKIKSX_Valid(event);
}
SPBOUILib.SetInputExit('YMJRPKIKSX',YMJRPKIKSX_wrap_Valid);
function YMJRPKIKSX_wrap_OnFocus(event) {
return YMJRPKIKSX_OnFocus(event);
}
SPBOUILib.SetInputEnter('YMJRPKIKSX',YMJRPKIKSX_wrap_OnFocus);
function YMJRPKIKSX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YMJRPKIKSX',YMJRPKIKSX_wrap_OnKeyDown);
function YMJRPKIKSX_ZOOM_setHandlers() {
function YMJRPKIKSX_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?YMJRPKIKSX_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('YMJRPKIKSX_ZOOM',YMJRPKIKSX_ZOOM_wrap_OnClick);
function YMJRPKIKSX_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('YMJRPKIKSX_ZOOM',YMJRPKIKSX_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('YMJRPKIKSX',YMJRPKIKSX_ZOOM_setHandlers);
function DSKEQYLWDR_wrap_Valid(event) {
return DSKEQYLWDR_Valid(event);
}
SPBOUILib.SetInputExit('DSKEQYLWDR',DSKEQYLWDR_wrap_Valid);
function DSKEQYLWDR_wrap_OnFocus(event) {
return DSKEQYLWDR_OnFocus(event);
}
SPBOUILib.SetInputEnter('DSKEQYLWDR',DSKEQYLWDR_wrap_OnFocus);
function DSKEQYLWDR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DSKEQYLWDR',DSKEQYLWDR_wrap_OnKeyDown);
function DSKEQYLWDR_ZOOM_setHandlers() {
function DSKEQYLWDR_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?DSKEQYLWDR_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('DSKEQYLWDR_ZOOM',DSKEQYLWDR_ZOOM_wrap_OnClick);
function DSKEQYLWDR_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('DSKEQYLWDR_ZOOM',DSKEQYLWDR_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('DSKEQYLWDR',DSKEQYLWDR_ZOOM_setHandlers);
function UQYWDDPGQG_wrap_Valid(event) {
return UQYWDDPGQG_Valid(event);
}
SPBOUILib.SetInputExit('UQYWDDPGQG',UQYWDDPGQG_wrap_Valid);
function UQYWDDPGQG_wrap_OnFocus(event) {
return UQYWDDPGQG_OnFocus(event);
}
SPBOUILib.SetInputEnter('UQYWDDPGQG',UQYWDDPGQG_wrap_OnFocus);
function UQYWDDPGQG_wrap_OnKeyPress(event) {
return UQYWDDPGQG_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('UQYWDDPGQG',UQYWDDPGQG_wrap_OnKeyPress);
function UQYWDDPGQG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UQYWDDPGQG',UQYWDDPGQG_wrap_OnKeyDown);
function UQYWDDPGQG_ZOOM_setHandlers() {
function UQYWDDPGQG_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?UQYWDDPGQG_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('UQYWDDPGQG_ZOOM',UQYWDDPGQG_ZOOM_wrap_OnClick);
function UQYWDDPGQG_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('UQYWDDPGQG_ZOOM',UQYWDDPGQG_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('UQYWDDPGQG',UQYWDDPGQG_ZOOM_setHandlers);
function NSVLOKQVAT_wrap_Valid(event) {
return NSVLOKQVAT_Valid(event);
}
SPBOUILib.SetInputExit('NSVLOKQVAT',NSVLOKQVAT_wrap_Valid);
function NSVLOKQVAT_wrap_OnFocus(event) {
return NSVLOKQVAT_OnFocus(event);
}
SPBOUILib.SetInputEnter('NSVLOKQVAT',NSVLOKQVAT_wrap_OnFocus);
function NSVLOKQVAT_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('NSVLOKQVAT',NSVLOKQVAT_wrap_OnKeyPress);
function NSVLOKQVAT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('NSVLOKQVAT',NSVLOKQVAT_wrap_OnKeyDown);
function NSVLOKQVAT_ZOOM_setHandlers() {
function NSVLOKQVAT_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?NSVLOKQVAT_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('NSVLOKQVAT_ZOOM',NSVLOKQVAT_ZOOM_wrap_OnClick);
function NSVLOKQVAT_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('NSVLOKQVAT_ZOOM',NSVLOKQVAT_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('NSVLOKQVAT',NSVLOKQVAT_ZOOM_setHandlers);
function YMUBWPUUZX_wrap_Valid(event) {
return YMUBWPUUZX_Valid(event);
}
SPBOUILib.SetInputExit('YMUBWPUUZX',YMUBWPUUZX_wrap_Valid);
function YMUBWPUUZX_wrap_OnFocus(event) {
return YMUBWPUUZX_OnFocus(event);
}
SPBOUILib.SetInputEnter('YMUBWPUUZX',YMUBWPUUZX_wrap_OnFocus);
function YMUBWPUUZX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YMUBWPUUZX',YMUBWPUUZX_wrap_OnKeyDown);
function YMUBWPUUZX_ZOOM_setHandlers() {
function YMUBWPUUZX_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?YMUBWPUUZX_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('YMUBWPUUZX_ZOOM',YMUBWPUUZX_ZOOM_wrap_OnClick);
function YMUBWPUUZX_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('YMUBWPUUZX_ZOOM',YMUBWPUUZX_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('YMUBWPUUZX',YMUBWPUUZX_ZOOM_setHandlers);
function TVQKRQXOUS_wrap_Valid(event) {
return TVQKRQXOUS_Valid(event);
}
SPBOUILib.SetInputExit('TVQKRQXOUS',TVQKRQXOUS_wrap_Valid);
function TVQKRQXOUS_wrap_OnFocus(event) {
return TVQKRQXOUS_OnFocus(event);
}
SPBOUILib.SetInputEnter('TVQKRQXOUS',TVQKRQXOUS_wrap_OnFocus);
function EOSKLIUGBC_wrap_Valid(event) {
return EOSKLIUGBC_Valid(event);
}
SPBOUILib.SetComboChange('EOSKLIUGBC',EOSKLIUGBC_wrap_Valid);
function EOSKLIUGBC_wrap_OnFocus(event) {
return EOSKLIUGBC_OnFocus(event);
}
SPBOUILib.SetInputEnter('EOSKLIUGBC',EOSKLIUGBC_wrap_OnFocus);
function EOSKLIUGBC_wrap_Blur(event) {
return EOSKLIUGBC_OnBlur(event);
}
SPBOUILib.SetInputExit('EOSKLIUGBC',EOSKLIUGBC_wrap_Blur);
function UTUCDPQJKK_wrap_Valid(event) {
return UTUCDPQJKK_Valid(event);
}
SPBOUILib.SetInputExit('UTUCDPQJKK',UTUCDPQJKK_wrap_Valid);
function UTUCDPQJKK_wrap_OnFocus(event) {
return UTUCDPQJKK_OnFocus(event);
}
SPBOUILib.SetInputEnter('UTUCDPQJKK',UTUCDPQJKK_wrap_OnFocus);
function UTUCDPQJKK_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('UTUCDPQJKK',UTUCDPQJKK_wrap_OnKeyPress);
function UTUCDPQJKK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UTUCDPQJKK',UTUCDPQJKK_wrap_OnKeyDown);
function WJQFIEBCQV_wrap_Valid(event) {
return WJQFIEBCQV_Valid(event);
}
SPBOUILib.SetComboChange('WJQFIEBCQV',WJQFIEBCQV_wrap_Valid);
function WJQFIEBCQV_wrap_OnFocus(event) {
return WJQFIEBCQV_OnFocus(event);
}
SPBOUILib.SetInputEnter('WJQFIEBCQV',WJQFIEBCQV_wrap_OnFocus);
function WJQFIEBCQV_wrap_Blur(event) {
return WJQFIEBCQV_OnBlur(event);
}
SPBOUILib.SetInputExit('WJQFIEBCQV',WJQFIEBCQV_wrap_Blur);
function AYCRVWSEMG_wrap_Valid(event) {
return AYCRVWSEMG_Valid(event);
}
SPBOUILib.SetCheckboxClick('AYCRVWSEMG',AYCRVWSEMG_wrap_Valid);
function AYCRVWSEMG_wrap_OnFocus(event) {
return AYCRVWSEMG_OnFocus(event);
}
SPBOUILib.SetInputEnter('AYCRVWSEMG',AYCRVWSEMG_wrap_OnFocus);
function AYCRVWSEMG_wrap_Blur(event) {
return AYCRVWSEMG_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('AYCRVWSEMG',AYCRVWSEMG_wrap_Blur);
function XQXYVWITMV_wrap_Valid(event) {
return XQXYVWITMV_Valid(event);
}
SPBOUILib.SetInputExit('XQXYVWITMV',XQXYVWITMV_wrap_Valid);
function XQXYVWITMV_wrap_OnFocus(event) {
return XQXYVWITMV_OnFocus(event);
}
SPBOUILib.SetInputEnter('XQXYVWITMV',XQXYVWITMV_wrap_OnFocus);
function XQXYVWITMV_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('XQXYVWITMV',XQXYVWITMV_wrap_OnKeyPress);
function XQXYVWITMV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XQXYVWITMV',XQXYVWITMV_wrap_OnKeyDown);
function BRJUUNWDMJ_wrap_Valid(event) {
return BRJUUNWDMJ_Valid(event);
}
SPBOUILib.SetInputExit('BRJUUNWDMJ',BRJUUNWDMJ_wrap_Valid);
function BRJUUNWDMJ_wrap_OnFocus(event) {
return BRJUUNWDMJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('BRJUUNWDMJ',BRJUUNWDMJ_wrap_OnFocus);
function BRJUUNWDMJ_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('BRJUUNWDMJ',BRJUUNWDMJ_wrap_OnKeyPress);
function BRJUUNWDMJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BRJUUNWDMJ',BRJUUNWDMJ_wrap_OnKeyDown);
function CTQAPOFAUI_wrap_Valid(event) {
return CTQAPOFAUI_Valid(event);
}
SPBOUILib.SetInputExit('CTQAPOFAUI',CTQAPOFAUI_wrap_Valid);
function CTQAPOFAUI_wrap_OnFocus(event) {
return CTQAPOFAUI_OnFocus(event);
}
SPBOUILib.SetInputEnter('CTQAPOFAUI',CTQAPOFAUI_wrap_OnFocus);
function CTQAPOFAUI_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('CTQAPOFAUI',CTQAPOFAUI_wrap_OnKeyPress);
function CTQAPOFAUI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CTQAPOFAUI',CTQAPOFAUI_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["XUFFKSTRWQ"]};
FocusFirstComponent.query={"page_1":["GSWVKRDVIZ"]};
FocusFirstComponent.otherwise={"page_1":["GSWVKRDVIZ"]};
function Help() {
windowOpenForeground('../doc/armt_cgo_telematico_err_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
GetLayerID.Layers.push({"id":"PIMVZFFAWF","name":"Dati"});
GetLayerID.Layers.push({"id":"MKZZTQTPHW","name":"Errori"});
function DeclareWVs() {
var a = arguments;
w_SNAINUMOPE=a[0];
w_ENV=a[1];
w_CODDIPE=a[2];
w_RAPPORTO=a[3];
w_TOTLIRE=a[4];
w_CADATAORA=a[5];
w_CAIDBIGLIETTO=a[6];
w_CSMF_COD=a[7];
w_NUM_CONC=a[8];
w_P_VEND=a[9];
w_IPCOLLEG=a[10];
w_ORACOLLEG=a[11];
w_DUCOLLEG=a[12];
w_TXTERR=a[13];
w_MEZPAGAM=a[14];
w_IBAN=a[15];
w_CACODICE=a[16];
w_FLGFULL=a[17];
w_CATIPGIO=a[18];
w_CATIPCON=a[19];
w_CAPV_COD=a[20];
w_xdesdip=a[21];
w_xdesrap=a[22];
m_PrimaryKeys=['SNAINUMOPE'];
}
function i_PrimaryKey() {
return 'cgo_telematico_err'+'\\'+CPLib.ToCPStr(w_SNAINUMOPE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_cgo_telematico_err',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODDIPE,'C'); },"field":"CODDIP","type":"C"},{"expression":function() { return WtA(w_xdesdip,'C'); },"field":"DESCRIZ","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('anadip','C'),"uid":"YMJRPKIKSX"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_RAPPORTO,'C'); },"field":"RAPPORTO","type":"C"},{"expression":function() { return WtA(w_xdesrap,'C'); },"field":"DESCRAP","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('knarapbo','C'),"uid":"DSKEQYLWDR"});
}
_Obli('SNAINUMOPE',0,'GSWVKRDVIZ',false,"11993248424")
_Obli('ENV',0,'XUFFKSTRWQ',false,"11281918484")
_Obli('CODDIPE',0,'YMJRPKIKSX',false,"2071283709")
_Obli('RAPPORTO',0,'DSKEQYLWDR',false,"10379997930")
_Obli('TOTLIRE',1,'UQYWDDPGQG',false,"1825772649")
_Obli('CADATAORA',3,'NSVLOKQVAT',false,"1464986651")
_Obli('CAIDBIGLIETTO',0,'YMUBWPUUZX',false,"10524120562")
_Obli('CATIPCON',1,'BRJUUNWDMJ',false,"414716055")
_Obli('TXTERR',0,'TVQKRQXOUS',false,"118057317")
_Obli('CATIPGIO',1,'XQXYVWITMV',false,"1570205239")
_Obli('FLGFULL',0,'AYCRVWSEMG',false,"1791194163")
_Obli('CAPV_COD',1,'CTQAPOFAUI',false,"76780720")
_Obli('MEZPAGAM',0,'EOSKLIUGBC',false,"10651434988")
_Obli('IBAN',0,'UTUCDPQJKK',true,"737507602",null,"11525797640",function() { return Eq(w_MEZPAGAM,'B') })
_Obli('CACODICE',1,'WJQFIEBCQV',false,"1814604627")
