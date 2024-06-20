function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('KYSFYTLMNO',function(){return WtH(w_TIPLEG,'C',1,0,'')},w_TIPLEG);
SPBOUILib.SetInputValue('JHHFBCVDFM',function(){return WtH(w_DESCRIZ,'C',95,0,'')},w_DESCRIZ);
SPBOUILib.SetInputValue('UGMIJICNYC',function(){return WtH(w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAINI);
SPBOUILib.SetInputValue('RFAYNTMUSW',function(){return WtH(w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAFINE);
if(c=Ctrl('AGUMDTGLPU')) selectCombo(c,w_FILTRO,'C')
SPBOUILib.SetInputValue('QQTLOBKJYW',function(){return WtH(w_DESCRIZ2,'C',95,0,'')},w_DESCRIZ2);
SPBOUILib.SetInputValue('UAGKCIWRAE',function(){return WtH(w_DATAINID2,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAINID2);
SPBOUILib.SetInputValue('RLLSZMIXEQ',function(){return WtH(w_DATAFIND2,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAFIND2);
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
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["DATAFIND2"]=['BAQYAPSEEN'];
HideUI.lblids["DATAFINE"]=['WTFOCEYBNU'];
HideUI.lblids["DATAINI"]=['TISXMDCETY'];
HideUI.lblids["DATAINID2"]=['TLBUKTGWHE'];
HideUI.lblids["DESCRIZ"]=['BNVGNLZGGB'];
HideUI.lblids["DESCRIZ2"]=['GUOCXDTENN'];
HideUI.lblids["FILTRO"]=['XUPDJQAVWA'];
HideUI.lblids["TIPLEG"]=['BXVCJMERRG'];
function KYSFYTLMNO_Valid(e) {
SetActiveField(Ctrl('KYSFYTLMNO'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('KYSFYTLMNO') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('TIPLEG','C',w_TIPLEG,HtW(Ctrl('KYSFYTLMNO').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPLEG(HtW(Ctrl('KYSFYTLMNO').value,'C'),null,e);
return l_bSetResult;
}
}
function KYSFYTLMNO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KYSFYTLMNO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KYSFYTLMNO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KYSFYTLMNO'),e);
}
function JHHFBCVDFM_Valid(e) {
SetActiveField(Ctrl('JHHFBCVDFM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRIZ','C',w_DESCRIZ,HtW(Ctrl('JHHFBCVDFM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRIZ(HtW(Ctrl('JHHFBCVDFM').value,'C'),null,e);
return l_bSetResult;
}
}
function JHHFBCVDFM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JHHFBCVDFM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JHHFBCVDFM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JHHFBCVDFM'),e);
}
function UGMIJICNYC_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('UGMIJICNYC'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('UGMIJICNYC').value=ApplyPictureToDate(Ctrl('UGMIJICNYC').value,TranslatePicture(datePattern),'UGMIJICNYC');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('UGMIJICNYC'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('UGMIJICNYC');
}
}
}
SetActiveField(Ctrl('UGMIJICNYC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAINI','D',w_DATAINI,HtW(Ctrl('UGMIJICNYC').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAINI(HtW(Ctrl('UGMIJICNYC').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function UGMIJICNYC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UGMIJICNYC'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('UGMIJICNYC',w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('UGMIJICNYC');
SetActiveField(Ctrl('UGMIJICNYC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UGMIJICNYC'),e);
}
function RFAYNTMUSW_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('RFAYNTMUSW'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('RFAYNTMUSW').value=ApplyPictureToDate(Ctrl('RFAYNTMUSW').value,TranslatePicture(datePattern),'RFAYNTMUSW');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('RFAYNTMUSW'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('RFAYNTMUSW');
}
}
}
SetActiveField(Ctrl('RFAYNTMUSW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAFINE','D',w_DATAFINE,HtW(Ctrl('RFAYNTMUSW').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAFINE(HtW(Ctrl('RFAYNTMUSW').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function RFAYNTMUSW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RFAYNTMUSW'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('RFAYNTMUSW',w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('RFAYNTMUSW');
SetActiveField(Ctrl('RFAYNTMUSW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RFAYNTMUSW'),e);
}
function AGUMDTGLPU_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FILTRO','C',w_FILTRO,HtW(getComboValue(Ctrl('AGUMDTGLPU')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FILTRO(HtW(getComboValue(Ctrl('AGUMDTGLPU')),'C'),null,e);
return l_bSetResult;
}
}
function AGUMDTGLPU_OnFocus(e) {
SetActiveField(Ctrl('AGUMDTGLPU'),true);
}
function AGUMDTGLPU_OnBlur(e) {
SetActiveField(Ctrl('AGUMDTGLPU'),false);
}
function QQTLOBKJYW_Valid(e) {
SetActiveField(Ctrl('QQTLOBKJYW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRIZ2','C',w_DESCRIZ2,HtW(Ctrl('QQTLOBKJYW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRIZ2(HtW(Ctrl('QQTLOBKJYW').value,'C'),null,e);
return l_bSetResult;
}
}
function QQTLOBKJYW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QQTLOBKJYW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QQTLOBKJYW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QQTLOBKJYW'),e);
}
function UAGKCIWRAE_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('UAGKCIWRAE'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('UAGKCIWRAE').value=ApplyPictureToDate(Ctrl('UAGKCIWRAE').value,TranslatePicture(datePattern),'UAGKCIWRAE');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('UAGKCIWRAE'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('UAGKCIWRAE');
}
}
}
SetActiveField(Ctrl('UAGKCIWRAE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAINID2','D',w_DATAINID2,HtW(Ctrl('UAGKCIWRAE').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAINID2(HtW(Ctrl('UAGKCIWRAE').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function UAGKCIWRAE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UAGKCIWRAE'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('UAGKCIWRAE',w_DATAINID2,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('UAGKCIWRAE');
SetActiveField(Ctrl('UAGKCIWRAE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UAGKCIWRAE'),e);
}
function RLLSZMIXEQ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('RLLSZMIXEQ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('RLLSZMIXEQ').value=ApplyPictureToDate(Ctrl('RLLSZMIXEQ').value,TranslatePicture(datePattern),'RLLSZMIXEQ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('RLLSZMIXEQ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('RLLSZMIXEQ');
}
}
}
SetActiveField(Ctrl('RLLSZMIXEQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAFIND2','D',w_DATAFIND2,HtW(Ctrl('RLLSZMIXEQ').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAFIND2(HtW(Ctrl('RLLSZMIXEQ').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function RLLSZMIXEQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RLLSZMIXEQ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('RLLSZMIXEQ',w_DATAFIND2,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('RLLSZMIXEQ');
SetActiveField(Ctrl('RLLSZMIXEQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RLLSZMIXEQ'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function KYSFYTLMNO_wrap_Valid(event) {
return KYSFYTLMNO_Valid(event);
}
SPBOUILib.SetInputExit('KYSFYTLMNO',KYSFYTLMNO_wrap_Valid);
function KYSFYTLMNO_wrap_OnFocus(event) {
return KYSFYTLMNO_OnFocus(event);
}
SPBOUILib.SetInputEnter('KYSFYTLMNO',KYSFYTLMNO_wrap_OnFocus);
function KYSFYTLMNO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KYSFYTLMNO',KYSFYTLMNO_wrap_OnKeyDown);
function JHHFBCVDFM_wrap_Valid(event) {
return JHHFBCVDFM_Valid(event);
}
SPBOUILib.SetInputExit('JHHFBCVDFM',JHHFBCVDFM_wrap_Valid);
function JHHFBCVDFM_wrap_OnFocus(event) {
return JHHFBCVDFM_OnFocus(event);
}
SPBOUILib.SetInputEnter('JHHFBCVDFM',JHHFBCVDFM_wrap_OnFocus);
function JHHFBCVDFM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JHHFBCVDFM',JHHFBCVDFM_wrap_OnKeyDown);
function UGMIJICNYC_wrap_Valid(event) {
return UGMIJICNYC_Valid(event);
}
SPBOUILib.SetInputExit('UGMIJICNYC',UGMIJICNYC_wrap_Valid);
function UGMIJICNYC_wrap_OnFocus(event) {
return UGMIJICNYC_OnFocus(event);
}
SPBOUILib.SetInputEnter('UGMIJICNYC',UGMIJICNYC_wrap_OnFocus);
function UGMIJICNYC_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('UGMIJICNYC',UGMIJICNYC_wrap_OnKeyPress);
function UGMIJICNYC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('UGMIJICNYC',UGMIJICNYC_wrap_OnKeyDown);
function RFAYNTMUSW_wrap_Valid(event) {
return RFAYNTMUSW_Valid(event);
}
SPBOUILib.SetInputExit('RFAYNTMUSW',RFAYNTMUSW_wrap_Valid);
function RFAYNTMUSW_wrap_OnFocus(event) {
return RFAYNTMUSW_OnFocus(event);
}
SPBOUILib.SetInputEnter('RFAYNTMUSW',RFAYNTMUSW_wrap_OnFocus);
function RFAYNTMUSW_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('RFAYNTMUSW',RFAYNTMUSW_wrap_OnKeyPress);
function RFAYNTMUSW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('RFAYNTMUSW',RFAYNTMUSW_wrap_OnKeyDown);
function AGUMDTGLPU_wrap_Valid(event) {
return AGUMDTGLPU_Valid(event);
}
SPBOUILib.SetComboChange('AGUMDTGLPU',AGUMDTGLPU_wrap_Valid);
function AGUMDTGLPU_wrap_OnFocus(event) {
return AGUMDTGLPU_OnFocus(event);
}
SPBOUILib.SetInputEnter('AGUMDTGLPU',AGUMDTGLPU_wrap_OnFocus);
function AGUMDTGLPU_wrap_Blur(event) {
return AGUMDTGLPU_OnBlur(event);
}
SPBOUILib.SetInputExit('AGUMDTGLPU',AGUMDTGLPU_wrap_Blur);
function QQTLOBKJYW_wrap_Valid(event) {
return QQTLOBKJYW_Valid(event);
}
SPBOUILib.SetInputExit('QQTLOBKJYW',QQTLOBKJYW_wrap_Valid);
function QQTLOBKJYW_wrap_OnFocus(event) {
return QQTLOBKJYW_OnFocus(event);
}
SPBOUILib.SetInputEnter('QQTLOBKJYW',QQTLOBKJYW_wrap_OnFocus);
function QQTLOBKJYW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QQTLOBKJYW',QQTLOBKJYW_wrap_OnKeyDown);
function UAGKCIWRAE_wrap_Valid(event) {
return UAGKCIWRAE_Valid(event);
}
SPBOUILib.SetInputExit('UAGKCIWRAE',UAGKCIWRAE_wrap_Valid);
function UAGKCIWRAE_wrap_OnFocus(event) {
return UAGKCIWRAE_OnFocus(event);
}
SPBOUILib.SetInputEnter('UAGKCIWRAE',UAGKCIWRAE_wrap_OnFocus);
function UAGKCIWRAE_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('UAGKCIWRAE',UAGKCIWRAE_wrap_OnKeyPress);
function UAGKCIWRAE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('UAGKCIWRAE',UAGKCIWRAE_wrap_OnKeyDown);
function RLLSZMIXEQ_wrap_Valid(event) {
return RLLSZMIXEQ_Valid(event);
}
SPBOUILib.SetInputExit('RLLSZMIXEQ',RLLSZMIXEQ_wrap_Valid);
function RLLSZMIXEQ_wrap_OnFocus(event) {
return RLLSZMIXEQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('RLLSZMIXEQ',RLLSZMIXEQ_wrap_OnFocus);
function RLLSZMIXEQ_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('RLLSZMIXEQ',RLLSZMIXEQ_wrap_OnKeyPress);
function RLLSZMIXEQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('RLLSZMIXEQ',RLLSZMIXEQ_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["JHHFBCVDFM"]};
FocusFirstComponent.query={"page_1":["KYSFYTLMNO"]};
FocusFirstComponent.otherwise={"page_1":["KYSFYTLMNO"]};
function Help() {
windowOpenForeground('../doc/armt_tipileg_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_TIPLEG=a[0];
w_DESCRIZ=a[1];
w_DATAINI=a[2];
w_DATAFINE=a[3];
w_FILTRO=a[4];
w_DESCRIZ2=a[5];
w_DATAINID2=a[6];
w_DATAFIND2=a[7];
m_PrimaryKeys=['TIPLEG'];
}
function i_PrimaryKey() {
return 'tbtipleg'+'\\'+CPLib.ToCPStr(w_TIPLEG);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_tipileg',m_cSelectedPage);
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
_Obli('TIPLEG',0,'KYSFYTLMNO',false,"112851763")
_Obli('DESCRIZ',0,'JHHFBCVDFM',false,"285808099")
_Obli('DATAINI',2,'UGMIJICNYC',false,"86866770")
_Obli('DATAFINE',2,'RFAYNTMUSW',false,"1216938285")
_Obli('FILTRO',0,'AGUMDTGLPU',false,"124367574")
_Obli('DESCRIZ2',0,'QQTLOBKJYW',false,"1443945977")
_Obli('DATAINID2',2,'UAGKCIWRAE',false,"86866770")
_Obli('DATAFIND2',2,'RLLSZMIXEQ',false,"1216938285")
