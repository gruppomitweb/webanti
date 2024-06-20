function FillCombosValues() {
FillCombo('SNYJQPAYYR','SNYJQPAYYR');
FillCombo('MDEBFTECJW','MDEBFTECJW');
FillCombo('NHFRSWSJPA','NHFRSWSJPA');
FillCombo('KYDBUIQLMM','KYDBUIQLMM');
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
FillCombo('GVMMKABWWU','GVMMKABWWU'+postfix,( ! (Empty(postfix))?WtA(w_VOCE):null));
render_combobox('NNRZYWQBXJ'+postfix,'qbe_sottovocea7',["?w_VOCE"],[WtA(w_VOCE,"C")],GetDynComboId('NNRZYWQBXJ'),'SOTTOVOCE','DESCRI','',w_SOTTOVOCE);
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
if(c=Ctrl('MVCFXMIIPY')) selectCombo(c,w_RESID,'C')
if(c=Ctrl('SNYJQPAYYR')) selectCombo(c,w_PROVINCIA,'C')
if(c=Ctrl('MDEBFTECJW')) selectCombo(c,w_STATO,'C')
if(c=Ctrl('NHFRSWSJPA')) selectCombo(c,w_VAL01217,'C')
if(c=Ctrl('KYDBUIQLMM')) selectCombo(c,w_VAL02147,'C')
SPBOUILib.SetInputValue('CNCQNTLDXJ',function(){return WtH(w_VAL02148,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_VAL02148);
SPBOUILib.SetInputValue('PDCPOALMKJ',function(){return WtH(w_VAL02149,'C',6,0,'')},w_VAL02149);
SPBOUILib.SetInputValue('OWRKSPYBFW',function(){return WtH(w_IMPORTO,'N',15,2,'999,999,999,999.99')},w_IMPORTO);
} else {
if(c=Ctrl('GVMMKABWWU')) selectCombo(c,w_VOCE,'C')
if(c=Ctrl('NNRZYWQBXJ')) selectCombo(c,w_SOTTOVOCE,'C')
if(c=Ctrl('MVCFXMIIPY')) selectCombo(c,w_RESID,'C')
if(c=Ctrl('SNYJQPAYYR')) selectCombo(c,w_PROVINCIA,'C')
if(c=Ctrl('MDEBFTECJW')) selectCombo(c,w_STATO,'C')
if(c=Ctrl('NHFRSWSJPA')) selectCombo(c,w_VAL01217,'C')
if(c=Ctrl('KYDBUIQLMM')) selectCombo(c,w_VAL02147,'C')
SPBOUILib.SetInputValue('CNCQNTLDXJ',function(){return WtH(w_VAL02148,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_VAL02148);
SPBOUILib.SetInputValue('PDCPOALMKJ',function(){return WtH(w_VAL02149,'C',6,0,'')},w_VAL02149);
SPBOUILib.SetInputValue('OWRKSPYBFW',function(){return WtH(w_IMPORTO,'N',15,2,'999,999,999,999.99')},w_IMPORTO);
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
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["IMPORTO"]=['VSGBYENSVC'];
HideUI.lblids["PROVINCIA"]=['BKLPQLOWPY'];
HideUI.lblids["RESID"]=['QYXREWCOCK'];
HideUI.lblids["SOTTOVOCE"]=['NPOUDYSLPC'];
HideUI.lblids["STATO"]=['CKEDGOYWAR'];
HideUI.lblids["VAL01217"]=['DHTENWMMKQ'];
HideUI.lblids["VAL02147"]=['NOMPGQKWQY'];
HideUI.lblids["VAL02148"]=['YZSDTWZADK'];
HideUI.lblids["VAL02149"]=['UJZUUASOGW'];
HideUI.lblids["VOCE"]=['EYBPXHGUZY'];
function GVMMKABWWU_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VOCE','C',w_VOCE,HtW(getComboValue(Ctrl('GVMMKABWWU')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VOCE(HtW(getComboValue(Ctrl('GVMMKABWWU')),'C'),null,e);
return l_bSetResult;
}
}
function GVMMKABWWU_OnFocus(e) {
SetActiveField(Ctrl('GVMMKABWWU'),true);
}
function GVMMKABWWU_OnBlur(e) {
SetActiveField(Ctrl('GVMMKABWWU'),false);
}
function NNRZYWQBXJ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('SOTTOVOCE','C',w_SOTTOVOCE,HtW(getComboValue(Ctrl('NNRZYWQBXJ')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SOTTOVOCE(HtW(getComboValue(Ctrl('NNRZYWQBXJ')),'C'),null,e);
return l_bSetResult;
}
}
function NNRZYWQBXJ_OnFocus(e) {
SetActiveField(Ctrl('NNRZYWQBXJ'),true);
}
function NNRZYWQBXJ_OnBlur(e) {
SetActiveField(Ctrl('NNRZYWQBXJ'),false);
}
function MVCFXMIIPY_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('RESID','C',w_RESID,HtW(getComboValue(Ctrl('MVCFXMIIPY')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RESID(HtW(getComboValue(Ctrl('MVCFXMIIPY')),'C'),null,e);
return l_bSetResult;
}
}
function MVCFXMIIPY_OnFocus(e) {
SetActiveField(Ctrl('MVCFXMIIPY'),true);
}
function MVCFXMIIPY_OnBlur(e) {
SetActiveField(Ctrl('MVCFXMIIPY'),false);
}
function SNYJQPAYYR_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('PROVINCIA','C',w_PROVINCIA,HtW(getComboValue(Ctrl('SNYJQPAYYR')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PROVINCIA(HtW(getComboValue(Ctrl('SNYJQPAYYR')),'C'),null,e);
return l_bSetResult;
}
}
function SNYJQPAYYR_OnFocus(e) {
SetActiveField(Ctrl('SNYJQPAYYR'),true);
}
function SNYJQPAYYR_OnBlur(e) {
SetActiveField(Ctrl('SNYJQPAYYR'),false);
}
function MDEBFTECJW_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('STATO','C',w_STATO,HtW(getComboValue(Ctrl('MDEBFTECJW')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_STATO(HtW(getComboValue(Ctrl('MDEBFTECJW')),'C'),null,e);
return l_bSetResult;
}
}
function MDEBFTECJW_OnFocus(e) {
SetActiveField(Ctrl('MDEBFTECJW'),true);
}
function MDEBFTECJW_OnBlur(e) {
SetActiveField(Ctrl('MDEBFTECJW'),false);
}
function NHFRSWSJPA_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VAL01217','C',w_VAL01217,HtW(getComboValue(Ctrl('NHFRSWSJPA')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VAL01217(HtW(getComboValue(Ctrl('NHFRSWSJPA')),'C'),null,e);
return l_bSetResult;
}
}
function NHFRSWSJPA_OnFocus(e) {
SetActiveField(Ctrl('NHFRSWSJPA'),true);
}
function NHFRSWSJPA_OnBlur(e) {
SetActiveField(Ctrl('NHFRSWSJPA'),false);
}
function KYDBUIQLMM_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VAL02147','C',w_VAL02147,HtW(getComboValue(Ctrl('KYDBUIQLMM')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VAL02147(HtW(getComboValue(Ctrl('KYDBUIQLMM')),'C'),null,e);
return l_bSetResult;
}
}
function KYDBUIQLMM_OnFocus(e) {
SetActiveField(Ctrl('KYDBUIQLMM'),true);
}
function KYDBUIQLMM_OnBlur(e) {
SetActiveField(Ctrl('KYDBUIQLMM'),false);
}
function CNCQNTLDXJ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('CNCQNTLDXJ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('CNCQNTLDXJ').value=ApplyPictureToDate(Ctrl('CNCQNTLDXJ').value,TranslatePicture(datePattern),'CNCQNTLDXJ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('CNCQNTLDXJ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('CNCQNTLDXJ');
}
}
}
SetActiveField(Ctrl('CNCQNTLDXJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('VAL02148','D',w_VAL02148,HtW(Ctrl('CNCQNTLDXJ').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VAL02148(HtW(Ctrl('CNCQNTLDXJ').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function CNCQNTLDXJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CNCQNTLDXJ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('CNCQNTLDXJ',w_VAL02148,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('CNCQNTLDXJ');
SetActiveField(Ctrl('CNCQNTLDXJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CNCQNTLDXJ'),e);
}
function CNCQNTLDXJ_ZOOM_Click() {
LaunchCalendar(Ctrl('CNCQNTLDXJ'));
}
function PDCPOALMKJ_Valid(e) {
SetActiveField(Ctrl('PDCPOALMKJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('VAL02149','C',w_VAL02149,HtW(Ctrl('PDCPOALMKJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VAL02149(HtW(Ctrl('PDCPOALMKJ').value,'C'),null,e);
return l_bSetResult;
}
}
function PDCPOALMKJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PDCPOALMKJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PDCPOALMKJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PDCPOALMKJ'),e);
}
function OWRKSPYBFW_Valid(e) {
SetActiveField(Ctrl('OWRKSPYBFW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMPORTO','N',w_IMPORTO,HtW(Ctrl('OWRKSPYBFW').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMPORTO(HtW(Ctrl('OWRKSPYBFW').value,'N'),null,e);
return l_bSetResult;
}
}
function OWRKSPYBFW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OWRKSPYBFW'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('OWRKSPYBFW',w_IMPORTO,'N',15,2,'999999999999.99');
SetActiveField(Ctrl('OWRKSPYBFW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OWRKSPYBFW'),e);
}
function OWRKSPYBFW_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999.99"));
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function GVMMKABWWU_wrap_Valid(event) {
return GVMMKABWWU_Valid(event);
}
SPBOUILib.SetComboChange('GVMMKABWWU',GVMMKABWWU_wrap_Valid,SPBOUILib.Row.IN_GRID);
function GVMMKABWWU_wrap_OnFocus(event) {
return GVMMKABWWU_OnFocus(event);
}
SPBOUILib.SetInputEnter('GVMMKABWWU',GVMMKABWWU_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function GVMMKABWWU_wrap_Blur(event) {
return GVMMKABWWU_OnBlur(event);
}
SPBOUILib.SetInputExit('GVMMKABWWU',GVMMKABWWU_wrap_Blur,SPBOUILib.Row.IN_GRID);
function NNRZYWQBXJ_wrap_Valid(event) {
return NNRZYWQBXJ_Valid(event);
}
SPBOUILib.SetComboChange('NNRZYWQBXJ',NNRZYWQBXJ_wrap_Valid,SPBOUILib.Row.IN_GRID);
function NNRZYWQBXJ_wrap_OnFocus(event) {
return NNRZYWQBXJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('NNRZYWQBXJ',NNRZYWQBXJ_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function NNRZYWQBXJ_wrap_Blur(event) {
return NNRZYWQBXJ_OnBlur(event);
}
SPBOUILib.SetInputExit('NNRZYWQBXJ',NNRZYWQBXJ_wrap_Blur,SPBOUILib.Row.IN_GRID);
function MVCFXMIIPY_wrap_Valid(event) {
return MVCFXMIIPY_Valid(event);
}
SPBOUILib.SetComboChange('MVCFXMIIPY',MVCFXMIIPY_wrap_Valid);
function MVCFXMIIPY_wrap_OnFocus(event) {
return MVCFXMIIPY_OnFocus(event);
}
SPBOUILib.SetInputEnter('MVCFXMIIPY',MVCFXMIIPY_wrap_OnFocus);
function MVCFXMIIPY_wrap_Blur(event) {
return MVCFXMIIPY_OnBlur(event);
}
SPBOUILib.SetInputExit('MVCFXMIIPY',MVCFXMIIPY_wrap_Blur);
function SNYJQPAYYR_wrap_Valid(event) {
return SNYJQPAYYR_Valid(event);
}
SPBOUILib.SetComboChange('SNYJQPAYYR',SNYJQPAYYR_wrap_Valid);
function SNYJQPAYYR_wrap_OnFocus(event) {
return SNYJQPAYYR_OnFocus(event);
}
SPBOUILib.SetInputEnter('SNYJQPAYYR',SNYJQPAYYR_wrap_OnFocus);
function SNYJQPAYYR_wrap_Blur(event) {
return SNYJQPAYYR_OnBlur(event);
}
SPBOUILib.SetInputExit('SNYJQPAYYR',SNYJQPAYYR_wrap_Blur);
function MDEBFTECJW_wrap_Valid(event) {
return MDEBFTECJW_Valid(event);
}
SPBOUILib.SetComboChange('MDEBFTECJW',MDEBFTECJW_wrap_Valid);
function MDEBFTECJW_wrap_OnFocus(event) {
return MDEBFTECJW_OnFocus(event);
}
SPBOUILib.SetInputEnter('MDEBFTECJW',MDEBFTECJW_wrap_OnFocus);
function MDEBFTECJW_wrap_Blur(event) {
return MDEBFTECJW_OnBlur(event);
}
SPBOUILib.SetInputExit('MDEBFTECJW',MDEBFTECJW_wrap_Blur);
function NHFRSWSJPA_wrap_Valid(event) {
return NHFRSWSJPA_Valid(event);
}
SPBOUILib.SetComboChange('NHFRSWSJPA',NHFRSWSJPA_wrap_Valid);
function NHFRSWSJPA_wrap_OnFocus(event) {
return NHFRSWSJPA_OnFocus(event);
}
SPBOUILib.SetInputEnter('NHFRSWSJPA',NHFRSWSJPA_wrap_OnFocus);
function NHFRSWSJPA_wrap_Blur(event) {
return NHFRSWSJPA_OnBlur(event);
}
SPBOUILib.SetInputExit('NHFRSWSJPA',NHFRSWSJPA_wrap_Blur);
function KYDBUIQLMM_wrap_Valid(event) {
return KYDBUIQLMM_Valid(event);
}
SPBOUILib.SetComboChange('KYDBUIQLMM',KYDBUIQLMM_wrap_Valid);
function KYDBUIQLMM_wrap_OnFocus(event) {
return KYDBUIQLMM_OnFocus(event);
}
SPBOUILib.SetInputEnter('KYDBUIQLMM',KYDBUIQLMM_wrap_OnFocus);
function KYDBUIQLMM_wrap_Blur(event) {
return KYDBUIQLMM_OnBlur(event);
}
SPBOUILib.SetInputExit('KYDBUIQLMM',KYDBUIQLMM_wrap_Blur);
function CNCQNTLDXJ_wrap_Valid(event) {
return CNCQNTLDXJ_Valid(event);
}
SPBOUILib.SetInputExit('CNCQNTLDXJ',CNCQNTLDXJ_wrap_Valid);
function CNCQNTLDXJ_wrap_OnFocus(event) {
return CNCQNTLDXJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('CNCQNTLDXJ',CNCQNTLDXJ_wrap_OnFocus);
function CNCQNTLDXJ_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('CNCQNTLDXJ',CNCQNTLDXJ_wrap_OnKeyPress);
function CNCQNTLDXJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('CNCQNTLDXJ',CNCQNTLDXJ_wrap_OnKeyDown);
function CNCQNTLDXJ_ZOOM_setHandlers() {
function CNCQNTLDXJ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?CNCQNTLDXJ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('CNCQNTLDXJ_ZOOM',CNCQNTLDXJ_ZOOM_wrap_OnClick);
}
SPBOUILib.SetPicker('CNCQNTLDXJ',CNCQNTLDXJ_ZOOM_setHandlers);
function PDCPOALMKJ_wrap_Valid(event) {
return PDCPOALMKJ_Valid(event);
}
SPBOUILib.SetInputExit('PDCPOALMKJ',PDCPOALMKJ_wrap_Valid);
function PDCPOALMKJ_wrap_OnFocus(event) {
return PDCPOALMKJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('PDCPOALMKJ',PDCPOALMKJ_wrap_OnFocus);
function PDCPOALMKJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PDCPOALMKJ',PDCPOALMKJ_wrap_OnKeyDown);
function OWRKSPYBFW_wrap_Valid(event) {
return OWRKSPYBFW_Valid(event);
}
SPBOUILib.SetInputExit('OWRKSPYBFW',OWRKSPYBFW_wrap_Valid);
function OWRKSPYBFW_wrap_OnFocus(event) {
return OWRKSPYBFW_OnFocus(event);
}
SPBOUILib.SetInputEnter('OWRKSPYBFW',OWRKSPYBFW_wrap_OnFocus);
function OWRKSPYBFW_wrap_OnKeyPress(event) {
return OWRKSPYBFW_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('OWRKSPYBFW',OWRKSPYBFW_wrap_OnKeyPress);
function OWRKSPYBFW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OWRKSPYBFW',OWRKSPYBFW_wrap_OnKeyDown);
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
}
function SetLastFocusedOnParent() {
if (IsWndAccessible(window['m_oFather'])) {
m_oFather.i_last_focused_item='child_ardt_dettaglioa7';
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
function Help() {
windowOpenForeground('../doc/ardt_dettaglioa7_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_ANNO=a[0];
w_SEMESTRE=a[1];
w_VOCE=a[2];
w_SOTTOVOCE=a[3];
w_RESID=a[4];
w_PROVINCIA=a[5];
w_STATO=a[6];
w_VAL01217=a[7];
w_VAL02147=a[8];
w_VAL02148=a[9];
w_VAL02149=a[10];
w_DATAEFF=a[11];
w_IMPORTO=a[12];
w_IDBASEA7=a[13];
w_CPROWNUM=a[14];
w_FLGRESID=a[15];
w_FLG00015=a[16];
w_FLG00016=a[17];
w_FLG01217=a[18];
w_FLG02147=a[19];
w_FLG02148=a[20];
w_FLG02149=a[21];
w_xDESCRI=a[22];
w_xDESVOCE=a[23];
if (Gt(a.length,24)) {
o_VOCE=w_VOCE;
}
m_PrimaryKeys=['CPROWNUM','SEMESTRE','ANNO'];
}
function i_PrimaryKey() {
return 'detta7'+'\\'+CPLib.ToCPStr(w_ANNO)+'\\'+CPLib.ToCPStr(w_SEMESTRE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_dettaglioa7',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
if (IsNull(p_id) || Eq(p_id,'NNRZYWQBXJ')) {
if (Ctrl('NNRZYWQBXJ')) {
render_combobox('NNRZYWQBXJ','qbe_sottovocea7',["?w_VOCE"],[WtA(w_VOCE,"C")],GetDynComboId('NNRZYWQBXJ'),'SOTTOVOCE','DESCRI','',WtA(w_SOTTOVOCE));
w_SOTTOVOCE=HtW(getComboValue(Ctrl('NNRZYWQBXJ')),'C');
}
}
if (IsNull(p_id) || Eq(p_id,'NHFRSWSJPA')) {
if (Ctrl('NHFRSWSJPA')) {
render_combobox('NHFRSWSJPA','qbe_tb01217',["?w_VOCE"],[WtA(w_VOCE,"C")],GetDynComboId('NHFRSWSJPA'),'COD','DESCRI','',WtA(w_VAL01217));
w_VAL01217=HtW(getComboValue(Ctrl('NHFRSWSJPA')),'C');
}
}
}
function LinkZoomExtendedMenu() {
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["GVMMKABWWU"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function RefreshDynamicContents() {
if (Ctrl('NHFRSWSJPA')) {
render_combobox('NHFRSWSJPA','qbe_tb01217',["?w_VOCE"],[WtA(w_VOCE,"C")],GetDynComboId('NHFRSWSJPA'),'COD','DESCRI','',WtA(w_VAL01217));
}
}
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('PROVINCIA',0,'SNYJQPAYYR',true,"10095365423",null,null,function() { return Eq(w_FLG00015,'S') })
_Obli('STATO',0,'MDEBFTECJW',true,"7776403",'MDEBFTECJW',null,function() { return Eq(w_FLG00016,'S') })
_Obli('VOCE',0,'GVMMKABWWU',false,"440902")
_Obli('SOTTOVOCE',0,'NNRZYWQBXJ',false,"11495876696")
_Obli('RESID',0,'MVCFXMIIPY',true,"347802115",null,null,function() { return Eq(w_FLGRESID,'S') })
_Obli('VAL02147',0,'KYDBUIQLMM',true,"10262589875",'KYDBUIQLMM',null,function() { return Eq(w_FLG02147,'S') })
_Obli('IMPORTO',1,'OWRKSPYBFW',true,"1847733175")
_Obli('VAL01217',0,'NHFRSWSJPA',true,"11602249308",'NHFRSWSJPA',null,function() { return Eq(w_FLG01217,'S') })
_Obli('VAL02148',2,'CNCQNTLDXJ',true,"10789175827",null,null,function() { return Eq(w_FLG02148,'S') })
_Obli('VAL02149',0,'PDCPOALMKJ',true,"237553103",null,null,function() { return Eq(w_FLG02149,'S') })
