function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('XIEVRJLRDP',function(){return WtH(w_CODICE,'C',2,0,'')},w_CODICE);
SPBOUILib.SetInputValue('BRISTCOXVE',function(){return WtH(w_DES1,'C',90,0,'')},w_DES1);
SPBOUILib.SetInputValue('PFCAAXIJSU',function(){return WtH(w_DES2,'C',60,0,'')},w_DES2);
SPBOUILib.SetInputValue('TAZCXRSOBO',function(){return WtH(w_TIPREG,'C',1,0,'')},w_TIPREG);
SPBOUILib.SetInputValue('HHIHNZHIBP',function(){return WtH(w_OPERAZIO,'C',1,0,'')},w_OPERAZIO);
SPBOUILib.SetInputValue('CFISKJBJKS',function(){return WtH(w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAINI);
SPBOUILib.SetInputValue('FLWSSMJEER',function(){return WtH(w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAFINE);
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
HideUI.lblids["CODICE"]=['KRFRYGOSLS'];
HideUI.lblids["DATAFINE"]=['VOYHHNAYNL'];
HideUI.lblids["DATAINI"]=['YFZCHPMRFS'];
HideUI.lblids["DES1"]=['KHBUWPWCWH'];
HideUI.lblids["DES2"]=['KTBTLLLBYZ'];
HideUI.lblids["OPERAZIO"]=['MDDHSSDZXD'];
HideUI.lblids["TIPREG"]=['FGEMKCSZFO'];
function XIEVRJLRDP_Valid(e) {
SetActiveField(Ctrl('XIEVRJLRDP'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('XIEVRJLRDP') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODICE','C',w_CODICE,HtW(Ctrl('XIEVRJLRDP').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODICE(HtW(Ctrl('XIEVRJLRDP').value,'C'),null,e);
return l_bSetResult;
}
}
function XIEVRJLRDP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XIEVRJLRDP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XIEVRJLRDP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XIEVRJLRDP'),e);
}
function BRISTCOXVE_Valid(e) {
SetActiveField(Ctrl('BRISTCOXVE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DES1','C',w_DES1,HtW(Ctrl('BRISTCOXVE').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DES1(HtW(Ctrl('BRISTCOXVE').value,'C'),null,e);
return l_bSetResult;
}
}
function BRISTCOXVE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BRISTCOXVE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BRISTCOXVE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BRISTCOXVE'),e);
}
function PFCAAXIJSU_Valid(e) {
SetActiveField(Ctrl('PFCAAXIJSU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DES2','C',w_DES2,HtW(Ctrl('PFCAAXIJSU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DES2(HtW(Ctrl('PFCAAXIJSU').value,'C'),null,e);
return l_bSetResult;
}
}
function PFCAAXIJSU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PFCAAXIJSU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PFCAAXIJSU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PFCAAXIJSU'),e);
}
function TAZCXRSOBO_Valid(e) {
SetActiveField(Ctrl('TAZCXRSOBO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TIPREG','C',w_TIPREG,HtW(Ctrl('TAZCXRSOBO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPREG(HtW(Ctrl('TAZCXRSOBO').value,'C'),null,e);
return l_bSetResult;
}
}
function TAZCXRSOBO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TAZCXRSOBO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TAZCXRSOBO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TAZCXRSOBO'),e);
}
function HHIHNZHIBP_Valid(e) {
SetActiveField(Ctrl('HHIHNZHIBP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('OPERAZIO','C',w_OPERAZIO,HtW(Ctrl('HHIHNZHIBP').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_OPERAZIO(HtW(Ctrl('HHIHNZHIBP').value,'C'),null,e);
return l_bSetResult;
}
}
function HHIHNZHIBP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HHIHNZHIBP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HHIHNZHIBP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HHIHNZHIBP'),e);
}
function CFISKJBJKS_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('CFISKJBJKS'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('CFISKJBJKS').value=ApplyPictureToDate(Ctrl('CFISKJBJKS').value,TranslatePicture(datePattern),'CFISKJBJKS');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('CFISKJBJKS'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('CFISKJBJKS');
}
}
}
SetActiveField(Ctrl('CFISKJBJKS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAINI','D',w_DATAINI,HtW(Ctrl('CFISKJBJKS').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAINI(HtW(Ctrl('CFISKJBJKS').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function CFISKJBJKS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CFISKJBJKS'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('CFISKJBJKS',w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('CFISKJBJKS');
SetActiveField(Ctrl('CFISKJBJKS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CFISKJBJKS'),e);
}
function FLWSSMJEER_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('FLWSSMJEER'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('FLWSSMJEER').value=ApplyPictureToDate(Ctrl('FLWSSMJEER').value,TranslatePicture(datePattern),'FLWSSMJEER');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('FLWSSMJEER'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('FLWSSMJEER');
}
}
}
SetActiveField(Ctrl('FLWSSMJEER'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAFINE','D',w_DATAFINE,HtW(Ctrl('FLWSSMJEER').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAFINE(HtW(Ctrl('FLWSSMJEER').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function FLWSSMJEER_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FLWSSMJEER'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('FLWSSMJEER',w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('FLWSSMJEER');
SetActiveField(Ctrl('FLWSSMJEER'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FLWSSMJEER'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function XIEVRJLRDP_wrap_Valid(event) {
return XIEVRJLRDP_Valid(event);
}
SPBOUILib.SetInputExit('XIEVRJLRDP',XIEVRJLRDP_wrap_Valid);
function XIEVRJLRDP_wrap_OnFocus(event) {
return XIEVRJLRDP_OnFocus(event);
}
SPBOUILib.SetInputEnter('XIEVRJLRDP',XIEVRJLRDP_wrap_OnFocus);
function XIEVRJLRDP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XIEVRJLRDP',XIEVRJLRDP_wrap_OnKeyDown);
function BRISTCOXVE_wrap_Valid(event) {
return BRISTCOXVE_Valid(event);
}
SPBOUILib.SetInputExit('BRISTCOXVE',BRISTCOXVE_wrap_Valid);
function BRISTCOXVE_wrap_OnFocus(event) {
return BRISTCOXVE_OnFocus(event);
}
SPBOUILib.SetInputEnter('BRISTCOXVE',BRISTCOXVE_wrap_OnFocus);
function BRISTCOXVE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BRISTCOXVE',BRISTCOXVE_wrap_OnKeyDown);
function PFCAAXIJSU_wrap_Valid(event) {
return PFCAAXIJSU_Valid(event);
}
SPBOUILib.SetInputExit('PFCAAXIJSU',PFCAAXIJSU_wrap_Valid);
function PFCAAXIJSU_wrap_OnFocus(event) {
return PFCAAXIJSU_OnFocus(event);
}
SPBOUILib.SetInputEnter('PFCAAXIJSU',PFCAAXIJSU_wrap_OnFocus);
function PFCAAXIJSU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PFCAAXIJSU',PFCAAXIJSU_wrap_OnKeyDown);
function TAZCXRSOBO_wrap_Valid(event) {
return TAZCXRSOBO_Valid(event);
}
SPBOUILib.SetInputExit('TAZCXRSOBO',TAZCXRSOBO_wrap_Valid);
function TAZCXRSOBO_wrap_OnFocus(event) {
return TAZCXRSOBO_OnFocus(event);
}
SPBOUILib.SetInputEnter('TAZCXRSOBO',TAZCXRSOBO_wrap_OnFocus);
function TAZCXRSOBO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TAZCXRSOBO',TAZCXRSOBO_wrap_OnKeyDown);
function HHIHNZHIBP_wrap_Valid(event) {
return HHIHNZHIBP_Valid(event);
}
SPBOUILib.SetInputExit('HHIHNZHIBP',HHIHNZHIBP_wrap_Valid);
function HHIHNZHIBP_wrap_OnFocus(event) {
return HHIHNZHIBP_OnFocus(event);
}
SPBOUILib.SetInputEnter('HHIHNZHIBP',HHIHNZHIBP_wrap_OnFocus);
function HHIHNZHIBP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HHIHNZHIBP',HHIHNZHIBP_wrap_OnKeyDown);
function CFISKJBJKS_wrap_Valid(event) {
return CFISKJBJKS_Valid(event);
}
SPBOUILib.SetInputExit('CFISKJBJKS',CFISKJBJKS_wrap_Valid);
function CFISKJBJKS_wrap_OnFocus(event) {
return CFISKJBJKS_OnFocus(event);
}
SPBOUILib.SetInputEnter('CFISKJBJKS',CFISKJBJKS_wrap_OnFocus);
function CFISKJBJKS_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('CFISKJBJKS',CFISKJBJKS_wrap_OnKeyPress);
function CFISKJBJKS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('CFISKJBJKS',CFISKJBJKS_wrap_OnKeyDown);
function FLWSSMJEER_wrap_Valid(event) {
return FLWSSMJEER_Valid(event);
}
SPBOUILib.SetInputExit('FLWSSMJEER',FLWSSMJEER_wrap_Valid);
function FLWSSMJEER_wrap_OnFocus(event) {
return FLWSSMJEER_OnFocus(event);
}
SPBOUILib.SetInputEnter('FLWSSMJEER',FLWSSMJEER_wrap_OnFocus);
function FLWSSMJEER_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('FLWSSMJEER',FLWSSMJEER_wrap_OnKeyPress);
function FLWSSMJEER_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('FLWSSMJEER',FLWSSMJEER_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["BRISTCOXVE"]};
FocusFirstComponent.query={"page_1":["XIEVRJLRDP"]};
FocusFirstComponent.otherwise={"page_1":["XIEVRJLRDP"]};
function Help() {
windowOpenForeground('../doc/armt_tipreg_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CODICE=a[0];
w_DES1=a[1];
w_DES2=a[2];
w_TIPREG=a[3];
w_OPERAZIO=a[4];
w_DATAINI=a[5];
w_DATAFINE=a[6];
m_PrimaryKeys=['CODICE'];
}
function i_PrimaryKey() {
return 'tbtipreg'+'\\'+CPLib.ToCPStr(w_CODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_tipreg',m_cSelectedPage);
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
_Obli('CODICE',0,'XIEVRJLRDP',false,"112851763")
_Obli('DES1',0,'BRISTCOXVE',false,"285808099")
_Obli('DES2',0,'PFCAAXIJSU',false,"289215971")
_Obli('TIPREG',0,'TAZCXRSOBO',false,"995100987")
_Obli('OPERAZIO',0,'HHIHNZHIBP',false,"10932226881")
_Obli('DATAINI',2,'CFISKJBJKS',false,"86866770")
_Obli('DATAFINE',2,'FLWSSMJEER',false,"1216938285")
