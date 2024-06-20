function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('HAMGFXNOBZ',function(){return WtH(w_CODDIP,'C',6,0,'')},w_CODDIP);
SPBOUILib.SetInputValue('FBTVENHVSF',function(){return WtH(w_DESCRIZ,'C',30,0,'')},w_DESCRIZ);
SPBOUILib.SetInputValue('QGLRMYVVYR',function(){return WtH(w_DESCCIT,'C',30,0,'')},w_DESCCIT);
SPBOUILib.SetInputValue('HEWLMIJUMK',function(){return WtH(w_PROVINCIA,'C',2,0,'')},w_PROVINCIA);
SPBOUILib.SetInputValue('THQKFWRDKA',function(){return WtH(w_CAB,'C',6,0,'')},w_CAB);
SPBOUILib.SetInputValue('JVFMFSMZFE',function(){return WtH(w_IDBASE,'C',10,0,'')},w_IDBASE);
SPBOUILib.SetInputValue('OJVLLPYCBU',function(){return WtH(w_DOMICILIO,'C',40,0,'')},w_DOMICILIO);
SPBOUILib.SetInputValue('TGHRJMBUBA',function(){return WtH(w_TELEFONO,'C',15,0,'')},w_TELEFONO);
SPBOUILib.SetInputValue('TVQKRQXOUS',function(){return WtH(w_TXTERR,'M',10,0,'')},w_TXTERR);
if(c=Ctrl('AYCRVWSEMG')) ChkboxCheckUncheck(c,'S',w_FLGFULL)
if(c=Ctrl('AYCRVWSEMG')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('QAIJWTCCHF',function(){return WtH(w_PRGDIP,'C',15,0,'')},w_PRGDIP);
SPBOUILib.SetInputValue('CKIITMJYDK',function(){return WtH(w_CODICEAAMS,'C',12,0,'')},w_CODICEAAMS);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["CAB"]=['LXOQHEQPUU'];
HideUI.lblids["CODDIP"]=['VQTSKPEBNM'];
HideUI.lblids["CODICEAAMS"]=['FFIYNLYIZI'];
HideUI.lblids["DESCCIT"]=['ELQXKWCBIV'];
HideUI.lblids["DESCRIZ"]=['MYKSKVFXFD'];
HideUI.lblids["DOMICILIO"]=['ODMNMHPECS'];
HideUI.lblids["IDBASE"]=['MKFSFNYCTH'];
HideUI.lblids["PRGDIP"]=['MHTMUMDSLD'];
HideUI.lblids["PROVINCIA"]=['NLAOEAEHXY'];
HideUI.lblids["TELEFONO"]=['SQGTPRBIDT'];
function HAMGFXNOBZ_Valid(e) {
SetActiveField(Ctrl('HAMGFXNOBZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODDIP','C',w_CODDIP,HtW(Ctrl('HAMGFXNOBZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODDIP(HtW(Ctrl('HAMGFXNOBZ').value,'C'),null,e);
return l_bSetResult;
}
}
function HAMGFXNOBZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HAMGFXNOBZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HAMGFXNOBZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HAMGFXNOBZ'),e);
}
function HAMGFXNOBZ_ZOOM_Click() {
}
function FBTVENHVSF_Valid(e) {
SetActiveField(Ctrl('FBTVENHVSF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRIZ','C',w_DESCRIZ,HtW(Ctrl('FBTVENHVSF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRIZ(HtW(Ctrl('FBTVENHVSF').value,'C'),null,e);
return l_bSetResult;
}
}
function FBTVENHVSF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FBTVENHVSF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FBTVENHVSF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FBTVENHVSF'),e);
}
function FBTVENHVSF_ZOOM_Click() {
}
function QGLRMYVVYR_Valid(e) {
SetActiveField(Ctrl('QGLRMYVVYR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCCIT','C',w_DESCCIT,HtW(Ctrl('QGLRMYVVYR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCCIT(HtW(Ctrl('QGLRMYVVYR').value,'C'),null,e);
return l_bSetResult;
}
}
function QGLRMYVVYR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QGLRMYVVYR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QGLRMYVVYR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QGLRMYVVYR'),e);
}
function QGLRMYVVYR_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('QGLRMYVVYR')),'linkview_QGLRMYVVYR','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function HEWLMIJUMK_Valid(e) {
SetActiveField(Ctrl('HEWLMIJUMK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PROVINCIA','C',w_PROVINCIA,HtW(Ctrl('HEWLMIJUMK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PROVINCIA(HtW(Ctrl('HEWLMIJUMK').value,'C'),null,e);
return l_bSetResult;
}
}
function HEWLMIJUMK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HEWLMIJUMK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HEWLMIJUMK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HEWLMIJUMK'),e);
}
function HEWLMIJUMK_ZOOM_Click() {
}
function THQKFWRDKA_Valid(e) {
SetActiveField(Ctrl('THQKFWRDKA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CAB','C',w_CAB,HtW(Ctrl('THQKFWRDKA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAB(HtW(Ctrl('THQKFWRDKA').value,'C'),null,e);
return l_bSetResult;
}
}
function THQKFWRDKA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('THQKFWRDKA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('THQKFWRDKA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('THQKFWRDKA'),e);
}
function THQKFWRDKA_ZOOM_Click() {
}
function JVFMFSMZFE_Valid(e) {
SetActiveField(Ctrl('JVFMFSMZFE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDBASE','C',w_IDBASE,HtW(Ctrl('JVFMFSMZFE').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDBASE(HtW(Ctrl('JVFMFSMZFE').value,'C'),null,e);
return l_bSetResult;
}
}
function JVFMFSMZFE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JVFMFSMZFE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JVFMFSMZFE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JVFMFSMZFE'),e);
}
function JVFMFSMZFE_ZOOM_Click() {
}
function OJVLLPYCBU_Valid(e) {
SetActiveField(Ctrl('OJVLLPYCBU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DOMICILIO','C',w_DOMICILIO,HtW(Ctrl('OJVLLPYCBU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DOMICILIO(HtW(Ctrl('OJVLLPYCBU').value,'C'),null,e);
return l_bSetResult;
}
}
function OJVLLPYCBU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OJVLLPYCBU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OJVLLPYCBU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OJVLLPYCBU'),e);
}
function OJVLLPYCBU_ZOOM_Click() {
}
function TGHRJMBUBA_Valid(e) {
SetActiveField(Ctrl('TGHRJMBUBA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TELEFONO','C',w_TELEFONO,HtW(Ctrl('TGHRJMBUBA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TELEFONO(HtW(Ctrl('TGHRJMBUBA').value,'C'),null,e);
return l_bSetResult;
}
}
function TGHRJMBUBA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TGHRJMBUBA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TGHRJMBUBA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TGHRJMBUBA'),e);
}
function TGHRJMBUBA_ZOOM_Click() {
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
function QAIJWTCCHF_Valid(e) {
SetActiveField(Ctrl('QAIJWTCCHF'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('QAIJWTCCHF') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('PRGDIP','C',w_PRGDIP,HtW(Ctrl('QAIJWTCCHF').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PRGDIP(HtW(Ctrl('QAIJWTCCHF').value,'C'),null,e);
return l_bSetResult;
}
}
function QAIJWTCCHF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QAIJWTCCHF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QAIJWTCCHF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QAIJWTCCHF'),e);
}
function CKIITMJYDK_Valid(e) {
SetActiveField(Ctrl('CKIITMJYDK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODICEAAMS','C',w_CODICEAAMS,HtW(Ctrl('CKIITMJYDK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODICEAAMS(HtW(Ctrl('CKIITMJYDK').value,'C'),null,e);
return l_bSetResult;
}
}
function CKIITMJYDK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CKIITMJYDK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CKIITMJYDK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CKIITMJYDK'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function HAMGFXNOBZ_wrap_Valid(event) {
return HAMGFXNOBZ_Valid(event);
}
SPBOUILib.SetInputExit('HAMGFXNOBZ',HAMGFXNOBZ_wrap_Valid);
function HAMGFXNOBZ_wrap_OnFocus(event) {
return HAMGFXNOBZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('HAMGFXNOBZ',HAMGFXNOBZ_wrap_OnFocus);
function HAMGFXNOBZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HAMGFXNOBZ',HAMGFXNOBZ_wrap_OnKeyDown);
function HAMGFXNOBZ_ZOOM_setHandlers() {
function HAMGFXNOBZ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?HAMGFXNOBZ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('HAMGFXNOBZ_ZOOM',HAMGFXNOBZ_ZOOM_wrap_OnClick);
function HAMGFXNOBZ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('HAMGFXNOBZ_ZOOM',HAMGFXNOBZ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('HAMGFXNOBZ',HAMGFXNOBZ_ZOOM_setHandlers);
function FBTVENHVSF_wrap_Valid(event) {
return FBTVENHVSF_Valid(event);
}
SPBOUILib.SetInputExit('FBTVENHVSF',FBTVENHVSF_wrap_Valid);
function FBTVENHVSF_wrap_OnFocus(event) {
return FBTVENHVSF_OnFocus(event);
}
SPBOUILib.SetInputEnter('FBTVENHVSF',FBTVENHVSF_wrap_OnFocus);
function FBTVENHVSF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FBTVENHVSF',FBTVENHVSF_wrap_OnKeyDown);
function FBTVENHVSF_ZOOM_setHandlers() {
function FBTVENHVSF_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?FBTVENHVSF_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('FBTVENHVSF_ZOOM',FBTVENHVSF_ZOOM_wrap_OnClick);
function FBTVENHVSF_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('FBTVENHVSF_ZOOM',FBTVENHVSF_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('FBTVENHVSF',FBTVENHVSF_ZOOM_setHandlers);
function QGLRMYVVYR_wrap_Valid(event) {
return QGLRMYVVYR_Valid(event);
}
SPBOUILib.SetInputExit('QGLRMYVVYR',QGLRMYVVYR_wrap_Valid);
function QGLRMYVVYR_wrap_OnFocus(event) {
return QGLRMYVVYR_OnFocus(event);
}
SPBOUILib.SetInputEnter('QGLRMYVVYR',QGLRMYVVYR_wrap_OnFocus);
function QGLRMYVVYR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QGLRMYVVYR',QGLRMYVVYR_wrap_OnKeyDown);
function QGLRMYVVYR_ZOOM_setHandlers() {
function QGLRMYVVYR_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?QGLRMYVVYR_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('QGLRMYVVYR_ZOOM',QGLRMYVVYR_ZOOM_wrap_OnClick);
function QGLRMYVVYR_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('QGLRMYVVYR_ZOOM',QGLRMYVVYR_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('QGLRMYVVYR',QGLRMYVVYR_ZOOM_setHandlers);
function HEWLMIJUMK_wrap_Valid(event) {
return HEWLMIJUMK_Valid(event);
}
SPBOUILib.SetInputExit('HEWLMIJUMK',HEWLMIJUMK_wrap_Valid);
function HEWLMIJUMK_wrap_OnFocus(event) {
return HEWLMIJUMK_OnFocus(event);
}
SPBOUILib.SetInputEnter('HEWLMIJUMK',HEWLMIJUMK_wrap_OnFocus);
function HEWLMIJUMK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HEWLMIJUMK',HEWLMIJUMK_wrap_OnKeyDown);
function HEWLMIJUMK_ZOOM_setHandlers() {
function HEWLMIJUMK_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?HEWLMIJUMK_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('HEWLMIJUMK_ZOOM',HEWLMIJUMK_ZOOM_wrap_OnClick);
function HEWLMIJUMK_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('HEWLMIJUMK_ZOOM',HEWLMIJUMK_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('HEWLMIJUMK',HEWLMIJUMK_ZOOM_setHandlers);
function THQKFWRDKA_wrap_Valid(event) {
return THQKFWRDKA_Valid(event);
}
SPBOUILib.SetInputExit('THQKFWRDKA',THQKFWRDKA_wrap_Valid);
function THQKFWRDKA_wrap_OnFocus(event) {
return THQKFWRDKA_OnFocus(event);
}
SPBOUILib.SetInputEnter('THQKFWRDKA',THQKFWRDKA_wrap_OnFocus);
function THQKFWRDKA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('THQKFWRDKA',THQKFWRDKA_wrap_OnKeyDown);
function THQKFWRDKA_ZOOM_setHandlers() {
function THQKFWRDKA_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?THQKFWRDKA_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('THQKFWRDKA_ZOOM',THQKFWRDKA_ZOOM_wrap_OnClick);
function THQKFWRDKA_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('THQKFWRDKA_ZOOM',THQKFWRDKA_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('THQKFWRDKA',THQKFWRDKA_ZOOM_setHandlers);
function JVFMFSMZFE_wrap_Valid(event) {
return JVFMFSMZFE_Valid(event);
}
SPBOUILib.SetInputExit('JVFMFSMZFE',JVFMFSMZFE_wrap_Valid);
function JVFMFSMZFE_wrap_OnFocus(event) {
return JVFMFSMZFE_OnFocus(event);
}
SPBOUILib.SetInputEnter('JVFMFSMZFE',JVFMFSMZFE_wrap_OnFocus);
function JVFMFSMZFE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JVFMFSMZFE',JVFMFSMZFE_wrap_OnKeyDown);
function JVFMFSMZFE_ZOOM_setHandlers() {
function JVFMFSMZFE_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?JVFMFSMZFE_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('JVFMFSMZFE_ZOOM',JVFMFSMZFE_ZOOM_wrap_OnClick);
function JVFMFSMZFE_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('JVFMFSMZFE_ZOOM',JVFMFSMZFE_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('JVFMFSMZFE',JVFMFSMZFE_ZOOM_setHandlers);
function OJVLLPYCBU_wrap_Valid(event) {
return OJVLLPYCBU_Valid(event);
}
SPBOUILib.SetInputExit('OJVLLPYCBU',OJVLLPYCBU_wrap_Valid);
function OJVLLPYCBU_wrap_OnFocus(event) {
return OJVLLPYCBU_OnFocus(event);
}
SPBOUILib.SetInputEnter('OJVLLPYCBU',OJVLLPYCBU_wrap_OnFocus);
function OJVLLPYCBU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OJVLLPYCBU',OJVLLPYCBU_wrap_OnKeyDown);
function OJVLLPYCBU_ZOOM_setHandlers() {
function OJVLLPYCBU_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?OJVLLPYCBU_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('OJVLLPYCBU_ZOOM',OJVLLPYCBU_ZOOM_wrap_OnClick);
function OJVLLPYCBU_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('OJVLLPYCBU_ZOOM',OJVLLPYCBU_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('OJVLLPYCBU',OJVLLPYCBU_ZOOM_setHandlers);
function TGHRJMBUBA_wrap_Valid(event) {
return TGHRJMBUBA_Valid(event);
}
SPBOUILib.SetInputExit('TGHRJMBUBA',TGHRJMBUBA_wrap_Valid);
function TGHRJMBUBA_wrap_OnFocus(event) {
return TGHRJMBUBA_OnFocus(event);
}
SPBOUILib.SetInputEnter('TGHRJMBUBA',TGHRJMBUBA_wrap_OnFocus);
function TGHRJMBUBA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TGHRJMBUBA',TGHRJMBUBA_wrap_OnKeyDown);
function TGHRJMBUBA_ZOOM_setHandlers() {
function TGHRJMBUBA_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?TGHRJMBUBA_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('TGHRJMBUBA_ZOOM',TGHRJMBUBA_ZOOM_wrap_OnClick);
function TGHRJMBUBA_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('TGHRJMBUBA_ZOOM',TGHRJMBUBA_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('TGHRJMBUBA',TGHRJMBUBA_ZOOM_setHandlers);
function TVQKRQXOUS_wrap_Valid(event) {
return TVQKRQXOUS_Valid(event);
}
SPBOUILib.SetInputExit('TVQKRQXOUS',TVQKRQXOUS_wrap_Valid);
function TVQKRQXOUS_wrap_OnFocus(event) {
return TVQKRQXOUS_OnFocus(event);
}
SPBOUILib.SetInputEnter('TVQKRQXOUS',TVQKRQXOUS_wrap_OnFocus);
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
function QAIJWTCCHF_wrap_Valid(event) {
return QAIJWTCCHF_Valid(event);
}
SPBOUILib.SetInputExit('QAIJWTCCHF',QAIJWTCCHF_wrap_Valid);
function QAIJWTCCHF_wrap_OnFocus(event) {
return QAIJWTCCHF_OnFocus(event);
}
SPBOUILib.SetInputEnter('QAIJWTCCHF',QAIJWTCCHF_wrap_OnFocus);
function QAIJWTCCHF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QAIJWTCCHF',QAIJWTCCHF_wrap_OnKeyDown);
function CKIITMJYDK_wrap_Valid(event) {
return CKIITMJYDK_Valid(event);
}
SPBOUILib.SetInputExit('CKIITMJYDK',CKIITMJYDK_wrap_Valid);
function CKIITMJYDK_wrap_OnFocus(event) {
return CKIITMJYDK_OnFocus(event);
}
SPBOUILib.SetInputEnter('CKIITMJYDK',CKIITMJYDK_wrap_OnFocus);
function CKIITMJYDK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CKIITMJYDK',CKIITMJYDK_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["HAMGFXNOBZ"]};
FocusFirstComponent.query={"page_1":["HAMGFXNOBZ"]};
FocusFirstComponent.otherwise={"page_1":["HAMGFXNOBZ"]};
function Help() {
windowOpenForeground('../doc/armt_cgo_anadip_err_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CODDIP=a[0];
w_DESCRIZ=a[1];
w_DESCCIT=a[2];
w_PROVINCIA=a[3];
w_CAB=a[4];
w_IDBASE=a[5];
w_DOMICILIO=a[6];
w_TELEFONO=a[7];
w_TXTERR=a[8];
w_FLGFULL=a[9];
w_PRGDIP=a[10];
w_CODICEAAMS=a[11];
m_PrimaryKeys=['PRGDIP'];
}
function i_PrimaryKey() {
return 'cgo_anadip_err'+'\\'+CPLib.ToCPStr(w_PRGDIP);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_cgo_anadip_err',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_DESCCIT,'C'); },"field":"CITTA","type":"C"},{"expression":function() { return WtA(w_CAB,'C'); },"field":"CAB","type":"C"},{"expression":function() { return WtA(w_PROVINCIA,'C'); },"field":"PROV","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcitta','C'),"uid":"QGLRMYVVYR"});
}
_Obli('CODDIP',0,'HAMGFXNOBZ',false,"2071283709")
_Obli('DESCRIZ',0,'FBTVENHVSF',false,"285808099")
_Obli('DESCCIT',0,'QGLRMYVVYR',false,"15186643")
_Obli('PROVINCIA',0,'HEWLMIJUMK',false,"10095365423")
_Obli('CAB',0,'THQKFWRDKA',false,"18003")
_Obli('IDBASE',0,'JVFMFSMZFE',false,"11105229855")
_Obli('DOMICILIO',0,'OJVLLPYCBU',false,"554236824")
_Obli('TELEFONO',0,'TGHRJMBUBA',false,"1700577956")
_Obli('TXTERR',0,'TVQKRQXOUS',false,"118057317")
_Obli('FLGFULL',0,'AYCRVWSEMG',false,"1791194163")
_Obli('PRGDIP',0,'QAIJWTCCHF',false,"321938427")
_Obli('CODICEAAMS',0,'CKIITMJYDK',false,"918180676")
