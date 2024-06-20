function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('SUTANCBZLS',function(){return WtH(w_CODCAU,'C',4,0,'')},w_CODCAU);
SPBOUILib.SetInputValue('AXRQOHDDBP',function(){return WtH(w_DESCRI,'C',165,0,'')},w_DESCRI);
SPBOUILib.SetInputValue('WGIESSCOWN',function(){return WtH(w_SEGNO,'C',1,0,'')},w_SEGNO);
SPBOUILib.SetInputValue('NONDJYDRPI',function(){return WtH(w_CAUSINT,'C',2,0,'')},w_CAUSINT);
var tmp_RILKASVSVV = ToHTag(AsControlValue(w_descau));
if (Ne(e_RILKASVSVV,tmp_RILKASVSVV)) {
SPBOUILib.SetLabelValue('RILKASVSVV','innerHTML',tmp_RILKASVSVV);
e_RILKASVSVV=tmp_RILKASVSVV;
}
SPBOUILib.SetInputValue('LSVJKMLQUN',function(){return WtH(w_idbase,'C',4,0,'')},w_idbase);
SPBOUILib.SetInputValue('CDBUTKZYKR',function(){return WtH(w_VALPERINT,'C',50,0,'')},w_VALPERINT);
SPBOUILib.SetInputValue('ZTKHOWJTQW',function(){return WtH(w_DATINI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATINI);
SPBOUILib.SetInputValue('JEGTRWGMTW',function(){return WtH(w_DATAVALI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAVALI);
if(c=Ctrl('QYLDDSFFZI')) selectCombo(c,w_FLGINTER,'C')
if(c=Ctrl('HVCDFAMPAB')) ChkboxCheckUncheck(c,'S',w_NOSARA)
if(c=Ctrl('HVCDFAMPAB')) ChkboxValueAssign(c,'S','N','C',1,0,'')
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
HideUI.lblids["CAUSINT"]=['DBGZQUERYR'];
HideUI.lblids["CODCAU"]=['BRGUIDMMEU'];
HideUI.lblids["DATAVALI"]=['IWGSKFPGWI'];
HideUI.lblids["DATINI"]=['MMMMANLPCV'];
HideUI.lblids["DESCRI"]=['AEWFAMIETG'];
HideUI.lblids["FLGINTER"]=['JDVWTOPYCW'];
HideUI.lblids["SEGNO"]=['AXFUTWKLFZ'];
HideUI.lblids["VALPERINT"]=['PCDSSXYKYN'];
HideUI.lblids["idbase"]=['WWQWIDQTRZ'];
function SUTANCBZLS_Valid(e) {
SetActiveField(Ctrl('SUTANCBZLS'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('SUTANCBZLS') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODCAU','C',w_CODCAU,HtW(Ctrl('SUTANCBZLS').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODCAU(HtW(Ctrl('SUTANCBZLS').value,'C'),null,e);
return l_bSetResult;
}
}
function SUTANCBZLS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SUTANCBZLS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SUTANCBZLS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SUTANCBZLS'),e);
}
function AXRQOHDDBP_Valid(e) {
SetActiveField(Ctrl('AXRQOHDDBP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('AXRQOHDDBP').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('AXRQOHDDBP').value,'C'),null,e);
return l_bSetResult;
}
}
function AXRQOHDDBP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AXRQOHDDBP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('AXRQOHDDBP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AXRQOHDDBP'),e);
}
function WGIESSCOWN_Valid(e) {
SetActiveField(Ctrl('WGIESSCOWN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SEGNO','C',w_SEGNO,HtW(Ctrl('WGIESSCOWN').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SEGNO(HtW(Ctrl('WGIESSCOWN').value,'C'),null,e);
return l_bSetResult;
}
}
function WGIESSCOWN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WGIESSCOWN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('WGIESSCOWN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WGIESSCOWN'),e);
}
function NONDJYDRPI_Valid(e) {
SetActiveField(Ctrl('NONDJYDRPI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CAUSINT','C',w_CAUSINT,HtW(Ctrl('NONDJYDRPI').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAUSINT(HtW(Ctrl('NONDJYDRPI').value,'C'),null,e);
return l_bSetResult;
}
}
function NONDJYDRPI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NONDJYDRPI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NONDJYDRPI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NONDJYDRPI'),e);
}
function NONDJYDRPI_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('NONDJYDRPI')),'linkview_NONDJYDRPI','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function LSVJKMLQUN_Valid(e) {
SetActiveField(Ctrl('LSVJKMLQUN'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('LSVJKMLQUN') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('idbase','C',w_idbase,HtW(Ctrl('LSVJKMLQUN').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_idbase(HtW(Ctrl('LSVJKMLQUN').value,'C'),null,e);
return l_bSetResult;
}
}
function LSVJKMLQUN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LSVJKMLQUN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LSVJKMLQUN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LSVJKMLQUN'),e);
}
function CDBUTKZYKR_Valid(e) {
SetActiveField(Ctrl('CDBUTKZYKR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('VALPERINT','C',w_VALPERINT,HtW(Ctrl('CDBUTKZYKR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VALPERINT(HtW(Ctrl('CDBUTKZYKR').value,'C'),null,e);
return l_bSetResult;
}
}
function CDBUTKZYKR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CDBUTKZYKR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CDBUTKZYKR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CDBUTKZYKR'),e);
}
function ZTKHOWJTQW_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('ZTKHOWJTQW'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('ZTKHOWJTQW').value=ApplyPictureToDate(Ctrl('ZTKHOWJTQW').value,TranslatePicture(datePattern),'ZTKHOWJTQW');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('ZTKHOWJTQW'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('ZTKHOWJTQW');
}
}
}
SetActiveField(Ctrl('ZTKHOWJTQW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATINI','D',w_DATINI,HtW(Ctrl('ZTKHOWJTQW').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATINI(HtW(Ctrl('ZTKHOWJTQW').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function ZTKHOWJTQW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZTKHOWJTQW'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('ZTKHOWJTQW',w_DATINI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('ZTKHOWJTQW');
SetActiveField(Ctrl('ZTKHOWJTQW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZTKHOWJTQW'),e);
}
function JEGTRWGMTW_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('JEGTRWGMTW'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('JEGTRWGMTW').value=ApplyPictureToDate(Ctrl('JEGTRWGMTW').value,TranslatePicture(datePattern),'JEGTRWGMTW');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('JEGTRWGMTW'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('JEGTRWGMTW');
}
}
}
SetActiveField(Ctrl('JEGTRWGMTW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAVALI','D',w_DATAVALI,HtW(Ctrl('JEGTRWGMTW').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAVALI(HtW(Ctrl('JEGTRWGMTW').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function JEGTRWGMTW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JEGTRWGMTW'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('JEGTRWGMTW',w_DATAVALI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('JEGTRWGMTW');
SetActiveField(Ctrl('JEGTRWGMTW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JEGTRWGMTW'),e);
}
function QYLDDSFFZI_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGINTER','C',w_FLGINTER,HtW(getComboValue(Ctrl('QYLDDSFFZI')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGINTER(HtW(getComboValue(Ctrl('QYLDDSFFZI')),'C'),null,e);
return l_bSetResult;
}
}
function QYLDDSFFZI_OnFocus(e) {
SetActiveField(Ctrl('QYLDDSFFZI'),true);
}
function QYLDDSFFZI_OnBlur(e) {
SetActiveField(Ctrl('QYLDDSFFZI'),false);
}
function HVCDFAMPAB_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('NOSARA','C',w_NOSARA,ChkboxValueAssign(Ctrl('HVCDFAMPAB'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOSARA(ChkboxValueAssign(Ctrl('HVCDFAMPAB'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function HVCDFAMPAB_OnFocus(e) {
SetActiveField(Ctrl('HVCDFAMPAB'),true);
}
function HVCDFAMPAB_OnBlur(e) {
SetActiveField(Ctrl('HVCDFAMPAB'),false);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function SUTANCBZLS_wrap_Valid(event) {
return SUTANCBZLS_Valid(event);
}
SPBOUILib.SetInputExit('SUTANCBZLS',SUTANCBZLS_wrap_Valid);
function SUTANCBZLS_wrap_OnFocus(event) {
return SUTANCBZLS_OnFocus(event);
}
SPBOUILib.SetInputEnter('SUTANCBZLS',SUTANCBZLS_wrap_OnFocus);
function SUTANCBZLS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SUTANCBZLS',SUTANCBZLS_wrap_OnKeyDown);
function AXRQOHDDBP_wrap_Valid(event) {
return AXRQOHDDBP_Valid(event);
}
SPBOUILib.SetInputExit('AXRQOHDDBP',AXRQOHDDBP_wrap_Valid);
function AXRQOHDDBP_wrap_OnFocus(event) {
return AXRQOHDDBP_OnFocus(event);
}
SPBOUILib.SetInputEnter('AXRQOHDDBP',AXRQOHDDBP_wrap_OnFocus);
function AXRQOHDDBP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AXRQOHDDBP',AXRQOHDDBP_wrap_OnKeyDown);
function WGIESSCOWN_wrap_Valid(event) {
return WGIESSCOWN_Valid(event);
}
SPBOUILib.SetInputExit('WGIESSCOWN',WGIESSCOWN_wrap_Valid);
function WGIESSCOWN_wrap_OnFocus(event) {
return WGIESSCOWN_OnFocus(event);
}
SPBOUILib.SetInputEnter('WGIESSCOWN',WGIESSCOWN_wrap_OnFocus);
function WGIESSCOWN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WGIESSCOWN',WGIESSCOWN_wrap_OnKeyDown);
function NONDJYDRPI_wrap_Valid(event) {
return NONDJYDRPI_Valid(event);
}
SPBOUILib.SetInputExit('NONDJYDRPI',NONDJYDRPI_wrap_Valid);
function NONDJYDRPI_wrap_OnFocus(event) {
return NONDJYDRPI_OnFocus(event);
}
SPBOUILib.SetInputEnter('NONDJYDRPI',NONDJYDRPI_wrap_OnFocus);
function NONDJYDRPI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NONDJYDRPI',NONDJYDRPI_wrap_OnKeyDown);
function NONDJYDRPI_ZOOM_setHandlers() {
function NONDJYDRPI_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?NONDJYDRPI_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('NONDJYDRPI_ZOOM',NONDJYDRPI_ZOOM_wrap_OnClick);
function NONDJYDRPI_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('NONDJYDRPI_ZOOM',NONDJYDRPI_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('NONDJYDRPI',NONDJYDRPI_ZOOM_setHandlers);
function LSVJKMLQUN_wrap_Valid(event) {
return LSVJKMLQUN_Valid(event);
}
SPBOUILib.SetInputExit('LSVJKMLQUN',LSVJKMLQUN_wrap_Valid);
function LSVJKMLQUN_wrap_OnFocus(event) {
return LSVJKMLQUN_OnFocus(event);
}
SPBOUILib.SetInputEnter('LSVJKMLQUN',LSVJKMLQUN_wrap_OnFocus);
function LSVJKMLQUN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LSVJKMLQUN',LSVJKMLQUN_wrap_OnKeyDown);
function CDBUTKZYKR_wrap_Valid(event) {
return CDBUTKZYKR_Valid(event);
}
SPBOUILib.SetInputExit('CDBUTKZYKR',CDBUTKZYKR_wrap_Valid);
function CDBUTKZYKR_wrap_OnFocus(event) {
return CDBUTKZYKR_OnFocus(event);
}
SPBOUILib.SetInputEnter('CDBUTKZYKR',CDBUTKZYKR_wrap_OnFocus);
function CDBUTKZYKR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CDBUTKZYKR',CDBUTKZYKR_wrap_OnKeyDown);
function ZTKHOWJTQW_wrap_Valid(event) {
return ZTKHOWJTQW_Valid(event);
}
SPBOUILib.SetInputExit('ZTKHOWJTQW',ZTKHOWJTQW_wrap_Valid);
function ZTKHOWJTQW_wrap_OnFocus(event) {
return ZTKHOWJTQW_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZTKHOWJTQW',ZTKHOWJTQW_wrap_OnFocus);
function ZTKHOWJTQW_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('ZTKHOWJTQW',ZTKHOWJTQW_wrap_OnKeyPress);
function ZTKHOWJTQW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('ZTKHOWJTQW',ZTKHOWJTQW_wrap_OnKeyDown);
function JEGTRWGMTW_wrap_Valid(event) {
return JEGTRWGMTW_Valid(event);
}
SPBOUILib.SetInputExit('JEGTRWGMTW',JEGTRWGMTW_wrap_Valid);
function JEGTRWGMTW_wrap_OnFocus(event) {
return JEGTRWGMTW_OnFocus(event);
}
SPBOUILib.SetInputEnter('JEGTRWGMTW',JEGTRWGMTW_wrap_OnFocus);
function JEGTRWGMTW_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('JEGTRWGMTW',JEGTRWGMTW_wrap_OnKeyPress);
function JEGTRWGMTW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('JEGTRWGMTW',JEGTRWGMTW_wrap_OnKeyDown);
function QYLDDSFFZI_wrap_Valid(event) {
return QYLDDSFFZI_Valid(event);
}
SPBOUILib.SetComboChange('QYLDDSFFZI',QYLDDSFFZI_wrap_Valid);
function QYLDDSFFZI_wrap_OnFocus(event) {
return QYLDDSFFZI_OnFocus(event);
}
SPBOUILib.SetInputEnter('QYLDDSFFZI',QYLDDSFFZI_wrap_OnFocus);
function QYLDDSFFZI_wrap_Blur(event) {
return QYLDDSFFZI_OnBlur(event);
}
SPBOUILib.SetInputExit('QYLDDSFFZI',QYLDDSFFZI_wrap_Blur);
function HVCDFAMPAB_wrap_Valid(event) {
return HVCDFAMPAB_Valid(event);
}
SPBOUILib.SetCheckboxClick('HVCDFAMPAB',HVCDFAMPAB_wrap_Valid);
function HVCDFAMPAB_wrap_OnFocus(event) {
return HVCDFAMPAB_OnFocus(event);
}
SPBOUILib.SetInputEnter('HVCDFAMPAB',HVCDFAMPAB_wrap_OnFocus);
function HVCDFAMPAB_wrap_Blur(event) {
return HVCDFAMPAB_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('HVCDFAMPAB',HVCDFAMPAB_wrap_Blur);
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
FocusFirstComponent.edit={"page_1":["AXRQOHDDBP"]};
FocusFirstComponent.query={"page_1":["SUTANCBZLS"]};
FocusFirstComponent.otherwise={"page_1":["SUTANCBZLS"]};
function Help() {
windowOpenForeground('../doc/armt_causalia_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CODCAU=a[0];
w_DESCRI=a[1];
w_SEGNO=a[2];
w_CAUSINT=a[3];
w_idbase=a[4];
w_VALPERINT=a[5];
w_DATINI=a[6];
w_DATAVALI=a[7];
w_FLGINTER=a[8];
w_NOSARA=a[9];
w_descau=a[10];
m_PrimaryKeys=['idbase','CODCAU'];
}
function i_PrimaryKey() {
return 'tbcauana'+'\\'+CPLib.ToCPStr(w_CODCAU)+'\\'+CPLib.ToCPStr(w_idbase);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_causalia',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('armt_causalis','C'),"fldValues":[{"expression":function() { return WtA(w_CAUSINT,'C'); },"field":"CODVOC","type":"C"},{"expression":function() { return WtA(w_descau,'C'); },"field":"DESCRIZ","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcausin','C'),"uid":"NONDJYDRPI"});
}
_Obli('CODCAU',0,'SUTANCBZLS',false,"112851763")
_Obli('DESCRI',0,'AXRQOHDDBP',false,"285808099")
_Obli('SEGNO',0,'WGIESSCOWN',false,"7753123")
_Obli('CAUSINT',0,'NONDJYDRPI',false,"215310487")
_Obli('idbase',0,'LSVJKMLQUN',false,"1249199241")
_Obli('DATINI',2,'ZTKHOWJTQW',false,"86866770")
_Obli('VALPERINT',0,'CDBUTKZYKR',false,"345486504")
_Obli('DATAVALI',2,'JEGTRWGMTW',false,"1216938285")
_Obli('FLGINTER',0,'QYLDDSFFZI',false,"1404896941")
_Obli('NOSARA',0,'HVCDFAMPAB',false,"1866071435")
