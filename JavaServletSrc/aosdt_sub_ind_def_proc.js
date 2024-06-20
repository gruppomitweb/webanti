function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
SPBOUILib.SetInputValue('ZZCYHWIBYI',function(){return WtH(w_IDMOD,'C',10,0,'')},w_IDMOD);
SPBOUILib.SetInputValue('VCVGRLKIYI',function(){return WtH(w_IDIND,'C',10,0,'')},w_IDIND);
if(c=Ctrl('KSVRAIFHEU')) ChkboxCheckUncheck(c,true,w_show_noapplic)
if(c=Ctrl('KSVRAIFHEU')) ChkboxValueAssign(c,true,false,'L',1,0,'')
SPBOUILib.SetInputValue('KQDZVNZECK',function(){return WtH(w_IDSUBIND,'C',10,0,'')},w_IDSUBIND);
SPBOUILib.SetInputValue('ATCXZHNKXY',function(){return WtH(w_DESCRI_layer,'M',10,0,'')},w_DESCRI_layer);
} else {
SPBOUILib.SetInputValue('ZZCYHWIBYI',function(){return WtH(w_IDMOD,'C',10,0,'')},w_IDMOD);
SPBOUILib.SetInputValue('VCVGRLKIYI',function(){return WtH(w_IDIND,'C',10,0,'')},w_IDIND);
if(c=Ctrl('KSVRAIFHEU')) ChkboxCheckUncheck(c,true,w_show_noapplic)
if(c=Ctrl('KSVRAIFHEU')) ChkboxValueAssign(c,true,false,'L',1,0,'')
SPBOUILib.SetInputValue('KQDZVNZECK',function(){return WtH(w_IDSUBIND,'C',10,0,'')},w_IDSUBIND);
SPBOUILib.SetInputValue('MXXMCLALYG',function(){return WtH(w_PROGSUBIND,'C',10,0,'')},w_PROGSUBIND);
SPBOUILib.SetInputValue('NGUCJOKSKM',function(){return WtH(w_DESCRI,'M',10,0,'')},w_DESCRI);
SPBOUILib.SetInputValue('YPEGROOCHF',function(){return WtH(w_PESO,'N',15,2,'999,999,999,999.99')},w_PESO);
SPBOUILib.SetInputValue('VDSUAVUBNI',function(){return WtH(w_INDRISCH,'N',6,2,'999.99')},w_INDRISCH);
if(c=Ctrl('OIJUVIXRQN')) ChkboxCheckUncheck(c,true,w_LOCKMIT)
if(c=Ctrl('OIJUVIXRQN')) ChkboxValueAssign(c,true,false,'L',1,0,'')
if(c=Ctrl('ACJAWRNAVO')) ChkboxCheckUncheck(c,true,w_NOAPPLIC)
if(c=Ctrl('ACJAWRNAVO')) ChkboxValueAssign(c,true,false,'L',1,0,'')
SPBOUILib.SetInputValue('ATCXZHNKXY',function(){return WtH(w_DESCRI_layer,'M',10,0,'')},w_DESCRI_layer);
}
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('ZZCYHWIBYI'),true || IsHiddenByStateDriver('IDMOD'));
SetDisplay(Ctrl('VCVGRLKIYI'),true || IsHiddenByStateDriver('IDIND'));
SetDisplay('KSVRAIFHEU_DIV',true);
SetDisplay(Ctrl('KQDZVNZECK'),true || IsHiddenByStateDriver('IDSUBIND'));
SetDisplay(Ctrl('TVQHCLXOGQ'),w_LOCKMIT &&  ! (Eq(EntityStatus(),'E') || Eq(EntityStatus(),'N')) || IsHiddenByStateDriver('Riporta Descrizione'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["DESCRI"]=['QETIXKMQMF'];
HideUI.lblids["INDRISCH"]=['ALDLRRKGHX'];
HideUI.lblids["LOCKMIT"]=['OLTCDBKKZK'];
HideUI.lblids["NOAPPLIC"]=['NCBLOOVGYK'];
HideUI.lblids["PESO"]=['AATZTVXUOM'];
HideUI.lblids["PROGSUBIND"]=['LZTSHRFCON'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function ZZCYHWIBYI_Valid(e) {
SetActiveField(Ctrl('ZZCYHWIBYI'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('ZZCYHWIBYI') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('IDMOD','C',w_IDMOD,HtW(Ctrl('ZZCYHWIBYI').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDMOD(HtW(Ctrl('ZZCYHWIBYI').value,'C'),null,e);
return l_bSetResult;
}
}
function ZZCYHWIBYI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZZCYHWIBYI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZZCYHWIBYI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZZCYHWIBYI'),e);
}
function VCVGRLKIYI_Valid(e) {
SetActiveField(Ctrl('VCVGRLKIYI'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('VCVGRLKIYI') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('IDIND','C',w_IDIND,HtW(Ctrl('VCVGRLKIYI').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDIND(HtW(Ctrl('VCVGRLKIYI').value,'C'),null,e);
return l_bSetResult;
}
}
function VCVGRLKIYI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VCVGRLKIYI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VCVGRLKIYI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VCVGRLKIYI'),e);
}
function KSVRAIFHEU_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('show_noapplic','L',w_show_noapplic,ChkboxValueAssign(Ctrl('KSVRAIFHEU'),true,false,'L',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_show_noapplic(ChkboxValueAssign(Ctrl('KSVRAIFHEU'),true,false,'L',1,0,''),null,e);
return l_bSetResult;
}
}
function KSVRAIFHEU_OnFocus(e) {
SetActiveField(Ctrl('KSVRAIFHEU'),true);
}
function KSVRAIFHEU_OnBlur(e) {
SetActiveField(Ctrl('KSVRAIFHEU'),false);
}
function KQDZVNZECK_Valid(e) {
SetActiveField(Ctrl('KQDZVNZECK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDSUBIND','C',w_IDSUBIND,HtW(Ctrl('KQDZVNZECK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDSUBIND(HtW(Ctrl('KQDZVNZECK').value,'C'),null,e);
return l_bSetResult;
}
}
function KQDZVNZECK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KQDZVNZECK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KQDZVNZECK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KQDZVNZECK'),e);
}
function MXXMCLALYG_Valid(e) {
SetActiveField(Ctrl('MXXMCLALYG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PROGSUBIND','C',w_PROGSUBIND,HtW(Ctrl('MXXMCLALYG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PROGSUBIND(HtW(Ctrl('MXXMCLALYG').value,'C'),null,e);
return l_bSetResult;
}
}
function MXXMCLALYG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MXXMCLALYG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MXXMCLALYG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MXXMCLALYG'),e);
}
function href_KWRCVYJSPV(el) {
ToggleLayerBox(arguments.length>0 && arguments[0].isConnected?arguments[0]:'KWRCVYJSPV',GetLayerID("Descrizione"),'20',true,'GridTable_Band_DIV','GridTable_Band_HEADER',false)
}
function NGUCJOKSKM_Valid(e) {
SetActiveField(Ctrl('NGUCJOKSKM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','M',w_DESCRI,HtW(Ctrl('NGUCJOKSKM').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('NGUCJOKSKM').value,'M'),null,e);
return l_bSetResult;
}
}
function NGUCJOKSKM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NGUCJOKSKM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NGUCJOKSKM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NGUCJOKSKM'),e);
}
function YPEGROOCHF_Valid(e) {
SetActiveField(Ctrl('YPEGROOCHF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PESO','N',w_PESO,HtW(Ctrl('YPEGROOCHF').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PESO(HtW(Ctrl('YPEGROOCHF').value,'N'),null,e);
return l_bSetResult;
}
}
function YPEGROOCHF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YPEGROOCHF'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('YPEGROOCHF',w_PESO,'N',15,2,'999,999,999,999.99');
SetActiveField(Ctrl('YPEGROOCHF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YPEGROOCHF'),e);
}
function YPEGROOCHF_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999,999,999,999.99"));
}
function VDSUAVUBNI_Valid(e) {
SetActiveField(Ctrl('VDSUAVUBNI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('INDRISCH','N',w_INDRISCH,HtW(Ctrl('VDSUAVUBNI').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_INDRISCH(HtW(Ctrl('VDSUAVUBNI').value,'N'),null,e);
return l_bSetResult;
}
}
function VDSUAVUBNI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VDSUAVUBNI'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('VDSUAVUBNI',w_INDRISCH,'N',6,2,'999.99');
SetActiveField(Ctrl('VDSUAVUBNI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VDSUAVUBNI'),e);
}
function VDSUAVUBNI_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999.99"));
}
function OIJUVIXRQN_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('LOCKMIT','L',w_LOCKMIT,ChkboxValueAssign(Ctrl('OIJUVIXRQN'),true,false,'L',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_LOCKMIT(ChkboxValueAssign(Ctrl('OIJUVIXRQN'),true,false,'L',1,0,''),null,e);
return l_bSetResult;
}
}
function OIJUVIXRQN_OnFocus(e) {
SetActiveField(Ctrl('OIJUVIXRQN'),true);
}
function OIJUVIXRQN_OnBlur(e) {
SetActiveField(Ctrl('OIJUVIXRQN'),false);
}
function ACJAWRNAVO_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('NOAPPLIC','L',w_NOAPPLIC,ChkboxValueAssign(Ctrl('ACJAWRNAVO'),true,false,'L',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOAPPLIC(ChkboxValueAssign(Ctrl('ACJAWRNAVO'),true,false,'L',1,0,''),null,e);
return l_bSetResult;
}
}
function ACJAWRNAVO_OnFocus(e) {
SetActiveField(Ctrl('ACJAWRNAVO'),true);
}
function ACJAWRNAVO_OnBlur(e) {
SetActiveField(Ctrl('ACJAWRNAVO'),false);
}
function ATCXZHNKXY_Valid(e) {
SetActiveField(Ctrl('ATCXZHNKXY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI_layer','M',w_DESCRI_layer,HtW(Ctrl('ATCXZHNKXY').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI_layer(HtW(Ctrl('ATCXZHNKXY').value,'M'),null,e);
return l_bSetResult;
}
}
function ATCXZHNKXY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ATCXZHNKXY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ATCXZHNKXY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ATCXZHNKXY'),e);
}
function href_TVQHCLXOGQ(el) {
ToggleLayerBox(arguments.length>0 && arguments[0].isConnected?arguments[0]:'TVQHCLXOGQ',GetLayerID("Descrizione"),'00',false,'VGASZRXNOJ_DIV','',true)
}
_ResetTracker();
function setEventHandlers() {
var c;
function KWRCVYJSPV_wrap_OnClick(event) {
return href_KWRCVYJSPV(event.srcElement);
}
SPBOUILib.SetImageClick('KWRCVYJSPV',KWRCVYJSPV_wrap_OnClick,SPBOUILib.Row.ALWAYS_ENABLED);
function KWRCVYJSPV_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('KWRCVYJSPV',KWRCVYJSPV_wrap_OnKeyDown,SPBOUILib.Row.ALWAYS_ENABLED);
function TVQHCLXOGQ_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?href_TVQHCLXOGQ(event.srcElement):void(0));
}
SPBOUILib.SetImageClick('TVQHCLXOGQ',TVQHCLXOGQ_wrap_OnClick);
function TVQHCLXOGQ_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('TVQHCLXOGQ',TVQHCLXOGQ_wrap_OnKeyDown);
if (Ne(m_cFunction,'view')) {
function ZZCYHWIBYI_wrap_Valid(event) {
return ZZCYHWIBYI_Valid(event);
}
SPBOUILib.SetInputExit('ZZCYHWIBYI',ZZCYHWIBYI_wrap_Valid);
function ZZCYHWIBYI_wrap_OnFocus(event) {
return ZZCYHWIBYI_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZZCYHWIBYI',ZZCYHWIBYI_wrap_OnFocus);
function ZZCYHWIBYI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZZCYHWIBYI',ZZCYHWIBYI_wrap_OnKeyDown);
function VCVGRLKIYI_wrap_Valid(event) {
return VCVGRLKIYI_Valid(event);
}
SPBOUILib.SetInputExit('VCVGRLKIYI',VCVGRLKIYI_wrap_Valid);
function VCVGRLKIYI_wrap_OnFocus(event) {
return VCVGRLKIYI_OnFocus(event);
}
SPBOUILib.SetInputEnter('VCVGRLKIYI',VCVGRLKIYI_wrap_OnFocus);
function VCVGRLKIYI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VCVGRLKIYI',VCVGRLKIYI_wrap_OnKeyDown);
function KSVRAIFHEU_wrap_Valid(event) {
return KSVRAIFHEU_Valid(event);
}
SPBOUILib.SetCheckboxClick('KSVRAIFHEU',KSVRAIFHEU_wrap_Valid);
function KSVRAIFHEU_wrap_OnFocus(event) {
return KSVRAIFHEU_OnFocus(event);
}
SPBOUILib.SetInputEnter('KSVRAIFHEU',KSVRAIFHEU_wrap_OnFocus);
function KSVRAIFHEU_wrap_Blur(event) {
return KSVRAIFHEU_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('KSVRAIFHEU',KSVRAIFHEU_wrap_Blur);
function KQDZVNZECK_wrap_Valid(event) {
return KQDZVNZECK_Valid(event);
}
SPBOUILib.SetInputExit('KQDZVNZECK',KQDZVNZECK_wrap_Valid);
function KQDZVNZECK_wrap_OnFocus(event) {
return KQDZVNZECK_OnFocus(event);
}
SPBOUILib.SetInputEnter('KQDZVNZECK',KQDZVNZECK_wrap_OnFocus);
function KQDZVNZECK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KQDZVNZECK',KQDZVNZECK_wrap_OnKeyDown);
function MXXMCLALYG_wrap_Valid(event) {
return MXXMCLALYG_Valid(event);
}
SPBOUILib.SetInputExit('MXXMCLALYG',MXXMCLALYG_wrap_Valid,SPBOUILib.Row.IN_GRID);
function MXXMCLALYG_wrap_OnFocus(event) {
return MXXMCLALYG_OnFocus(event);
}
SPBOUILib.SetInputEnter('MXXMCLALYG',MXXMCLALYG_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function MXXMCLALYG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MXXMCLALYG',MXXMCLALYG_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function NGUCJOKSKM_wrap_Valid(event) {
return NGUCJOKSKM_Valid(event);
}
SPBOUILib.SetInputExit('NGUCJOKSKM',NGUCJOKSKM_wrap_Valid,SPBOUILib.Row.IN_GRID);
function NGUCJOKSKM_wrap_OnFocus(event) {
return NGUCJOKSKM_OnFocus(event);
}
SPBOUILib.SetInputEnter('NGUCJOKSKM',NGUCJOKSKM_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function YPEGROOCHF_wrap_Valid(event) {
return YPEGROOCHF_Valid(event);
}
SPBOUILib.SetInputExit('YPEGROOCHF',YPEGROOCHF_wrap_Valid,SPBOUILib.Row.IN_GRID);
function YPEGROOCHF_wrap_OnFocus(event) {
return YPEGROOCHF_OnFocus(event);
}
SPBOUILib.SetInputEnter('YPEGROOCHF',YPEGROOCHF_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function YPEGROOCHF_wrap_OnKeyPress(event) {
return YPEGROOCHF_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('YPEGROOCHF',YPEGROOCHF_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function YPEGROOCHF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YPEGROOCHF',YPEGROOCHF_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function VDSUAVUBNI_wrap_Valid(event) {
return VDSUAVUBNI_Valid(event);
}
SPBOUILib.SetInputExit('VDSUAVUBNI',VDSUAVUBNI_wrap_Valid,SPBOUILib.Row.IN_GRID);
function VDSUAVUBNI_wrap_OnFocus(event) {
return VDSUAVUBNI_OnFocus(event);
}
SPBOUILib.SetInputEnter('VDSUAVUBNI',VDSUAVUBNI_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function VDSUAVUBNI_wrap_OnKeyPress(event) {
return VDSUAVUBNI_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('VDSUAVUBNI',VDSUAVUBNI_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function VDSUAVUBNI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VDSUAVUBNI',VDSUAVUBNI_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function OIJUVIXRQN_wrap_Valid(event) {
return OIJUVIXRQN_Valid(event);
}
SPBOUILib.SetCheckboxClick('OIJUVIXRQN',OIJUVIXRQN_wrap_Valid,SPBOUILib.Row.IN_GRID);
function OIJUVIXRQN_wrap_OnFocus(event) {
return OIJUVIXRQN_OnFocus(event);
}
SPBOUILib.SetInputEnter('OIJUVIXRQN',OIJUVIXRQN_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function OIJUVIXRQN_wrap_Blur(event) {
return OIJUVIXRQN_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('OIJUVIXRQN',OIJUVIXRQN_wrap_Blur,SPBOUILib.Row.IN_GRID);
function ACJAWRNAVO_wrap_Valid(event) {
return ACJAWRNAVO_Valid(event);
}
SPBOUILib.SetCheckboxClick('ACJAWRNAVO',ACJAWRNAVO_wrap_Valid,SPBOUILib.Row.IN_GRID);
function ACJAWRNAVO_wrap_OnFocus(event) {
return ACJAWRNAVO_OnFocus(event);
}
SPBOUILib.SetInputEnter('ACJAWRNAVO',ACJAWRNAVO_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function ACJAWRNAVO_wrap_Blur(event) {
return ACJAWRNAVO_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('ACJAWRNAVO',ACJAWRNAVO_wrap_Blur,SPBOUILib.Row.IN_GRID);
function ATCXZHNKXY_wrap_Valid(event) {
return ATCXZHNKXY_Valid(event);
}
SPBOUILib.SetInputExit('ATCXZHNKXY',ATCXZHNKXY_wrap_Valid);
function ATCXZHNKXY_wrap_OnFocus(event) {
return ATCXZHNKXY_OnFocus(event);
}
SPBOUILib.SetInputEnter('ATCXZHNKXY',ATCXZHNKXY_wrap_OnFocus);
if (m_bExtended) {
SetEventsAndStylesToExtendedFields();
}
}
if (Eq(m_nChildStatus,0)) {
if (Eq(m_cFunction,'query') && Ne(document.FrmToolbar,null)) {
document.FrmToolbar.pos.onkeypress=RecPositionInput;
document.FrmToolbar.pos.onblur=SelectRecord;
}
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Eq(p_cEvent,'After Row Selected')) {
if (Ne(typeof(Calculation_TQCPNMUFSK),'undefined')) {
old_c=m_bCalculating;
m_bCalculating=true;
Calculation_TQCPNMUFSK();
m_bCalculating=old_c;
if ( ! (old_c)) {
DoUpdate(true);
}
}
} else if (Eq(p_cEvent,'Descrizione enter')) {
if (Ne(typeof(Calculation_TQCPNMUFSK),'undefined')) {
old_c=m_bCalculating;
m_bCalculating=true;
Calculation_TQCPNMUFSK();
m_bCalculating=old_c;
if ( ! (old_c)) {
DoUpdate(true);
}
}
} else if (Eq(p_cEvent,'Descrizione exit')) {
if (Ne(typeof(Calculation_LCRFZTFQSM),'undefined')) {
old_c=m_bCalculating;
m_bCalculating=true;
Calculation_LCRFZTFQSM();
m_bCalculating=old_c;
if ( ! (old_c)) {
DoUpdate(true);
}
}
}
}
function SetLastFocusedOnParent() {
if (IsWndAccessible(window['m_oFather'])) {
m_oFather.i_last_focused_item='child_aosdt_sub_ind_def';
m_oFather.last_focused_comp=null;
m_oFather.SetLastFocusedOnParent();
}
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
m_bStopChangeRow=true;
} else if (Ne('undefined',typeof(m_nLastError))) {
m_bStopChangeRow=Eq(m_nLastError,-2);
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.edit={};
FocusFirstComponent.query={};
FocusFirstComponent.otherwise={};
FocusLayerFirstComponent.Layers['VGASZRXNOJ_DIV']='ATCXZHNKXY';
function closeContextMenu_VGASZRXNOJ() {
}
function Help() {
windowOpenForeground('../doc/aosdt_sub_ind_def_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
GetLayerID.Layers.push({"id":"VGASZRXNOJ_DIV","name":"Descrizione"});
GetLayerID.CheckEditRow=true;
function DeclareWVs() {
var a = arguments;
w_IDMOD=a[0];
w_IDIND=a[1];
w_IDSUBIND=a[2];
w_PROGSUBIND=a[3];
w_DESCRI=a[4];
w_PESO=a[5];
w_INDRISCH=a[6];
w_LOCKMIT=a[7];
w_NOAPPLIC=a[8];
w_show_noapplic=a[9];
w_DESCRI_layer=a[10];
w_open_layer=a[11];
w_write_layer=a[12];
m_PrimaryKeys=['IDSUBIND','IDIND','IDMOD'];
}
function i_PrimaryKey() {
return 'sub_ind_def'+'\\'+CPLib.ToCPStr(w_IDMOD)+'\\'+CPLib.ToCPStr(w_IDIND);
}
function CheckZone(me) {
var totals = {"ATCXZHNKXY":["VGASZRXNOJ"]};
var oldZones = totals[i_last_focused_item];
var differences = GetZoneArrayDifference(totals[me]||[],oldZones||[]);
try {
if (Ne(LibJavascript.Array.indexOf(differences,'VGASZRXNOJ'),-1) &&  ! (Check_VGASZRXNOJ(true,true))) {
return false;
}
} finally {
var newZones = totals[me]||[];
if (Ne(LibJavascript.Array.indexOf(newZones,'VGASZRXNOJ'),-1)) {
NotifyEvent('Descrizione enter');
}
}
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('aosdt_sub_ind_def',m_cSelectedPage);
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
function FocusFirstDetailComponent() {
var candidatesToFocus = ["MXXMCLALYG","KWRCVYJSPV"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function IsRowHidden(rowObj) {
var w_IDSUBIND = GetRepeatedValue(rowObj,'IDSUBIND');
var w_PROGSUBIND = GetRepeatedValue(rowObj,'PROGSUBIND');
var w_DESCRI = GetRepeatedValue(rowObj,'DESCRI');
var w_PESO = GetRepeatedValue(rowObj,'PESO');
var w_INDRISCH = GetRepeatedValue(rowObj,'INDRISCH');
var w_LOCKMIT = GetRepeatedValue(rowObj,'LOCKMIT');
var w_NOAPPLIC = GetRepeatedValue(rowObj,'NOAPPLIC');
var w_DESCRI_layer = GetRepeatedValue(rowObj,'DESCRI_layer');
var w_open_layer = GetRepeatedValue(rowObj,'open_layer');
var w_write_layer = GetRepeatedValue(rowObj,'write_layer');
return  ! (w_show_noapplic) && w_NOAPPLIC;
}
function GetFullRowMsgError() {
return '75659037';
}
_Obli('IDMOD',0,'ZZCYHWIBYI',false,"10024211400")
_Obli('IDIND',0,'VCVGRLKIYI',false,"1305674908")
_Obli('show_noapplic',4,'KSVRAIFHEU',false,"10273053127")
_Obli('IDSUBIND',0,'KQDZVNZECK',false,"10785547902")
_Obli('PROGSUBIND',0,'MXXMCLALYG',false,"976616780")
_Obli('DESCRI',0,'NGUCJOKSKM',false,"601925191")
_Obli('PESO',1,'YPEGROOCHF',false,"485792")
_Obli('INDRISCH',1,'VDSUAVUBNI',false,"1701052417")
_Obli('LOCKMIT',4,'OIJUVIXRQN',false,"11407848125")
_Obli('NOAPPLIC',4,'ACJAWRNAVO',false,"11597693133")
_Obli('DESCRI_layer',0,'ATCXZHNKXY',false,"285808099")
