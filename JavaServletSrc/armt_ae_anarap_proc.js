function FillCombosValues() {
FillCombo('ZFOHYLVPYN','ZFOHYLVPYN');
FillCombo('BHAVHLFPAC','BHAVHLFPAC');
FillCombo('QBUCLWUNFT','QBUCLWUNFT');
}
function SetControlsValue() {
var c;
var tmp_subtitle = ToHTag(AsControlValue(w_titolo));
if (Ne(e_subtitle,tmp_subtitle)) {
SetSubTitle(tmp_subtitle);
e_subtitle=tmp_subtitle;
}
SPBOUILib.SetInputValue('LXORWVRYJJ',function(){return WtH(w_RAPPORTO,'C',25,0,'')},w_RAPPORTO);
SPBOUILib.SetInputValue('AQAARAIPOR',function(){return WtH(w_DESCRAP,'C',50,0,'')},w_DESCRAP);
if(c=Ctrl('ZFOHYLVPYN')) selectCombo(c,w_TIPORAP,'C')
if(c=Ctrl('BHAVHLFPAC')) selectCombo(c,w_TIPOAG,'C')
if(c=Ctrl('QBUCLWUNFT')) selectCombo(c,w_ISOAGE,'C')
if(c=Ctrl('BCLYMGMBLK')) selectCombo(c,w_FLAGLIRE,'C')
SPBOUILib.SetInputValue('RUMXLFCOKA',function(){return WtH(w_VALUTA,'C',3,0,'')},w_VALUTA);
var tmp_XQILBJQNNS = ToHTag(AsControlValue(w_descval));
if (Ne(e_XQILBJQNNS,tmp_XQILBJQNNS)) {
SPBOUILib.SetLabelValue('XQILBJQNNS','innerHTML',tmp_XQILBJQNNS);
e_XQILBJQNNS=tmp_XQILBJQNNS;
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
SetDisplay('YORQOIOBQN_DIV',IsHiddenByStateDriver('DatiBase'));
SetDisplay('GJZISGEBVV_DIV',IsHiddenByStateDriver('DatiBase'));
SetDisplay(Ctrl('QBUCLWUNFT'),Ne(w_TIPOAG,'96') && Ne(w_TIPOAG,'97') || IsHiddenByStateDriver('ISOAGE'));
SetDisplay(Ctrl('TQNAPDCWFY'),Ne(w_TIPOAG,'96') && Ne(w_TIPOAG,'97'));
SetDisplay('LZCEHELAXJ_DIV',IsHiddenByStateDriver('Rapporto'));
SetDisplay('EHSQLOIDHO_DIV',IsHiddenByStateDriver('Deleghe'));
SetDisplay('KAVLKRYWMM_DIV',IsHiddenByStateDriver('SaldiOro'));
SetDisplay('LWDMGLAEON_DIV',IsHiddenByStateDriver('Garantiti'));
SetDisplay('MUCCIMEJEB_DIV',IsHiddenByStateDriver('Saldi'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["DESCRAP"]=['VEBJKDHMDC'];
HideUI.lblids["FLAGLIRE"]=['OUQKLNQVMP'];
HideUI.lblids["ISOAGE"]=['TQNAPDCWFY'];
HideUI.lblids["RAPPORTO"]=['OICGZUOZYP'];
HideUI.lblids["TIPOAG"]=['CTCKWHZVTZ'];
HideUI.lblids["TIPORAP"]=['GDCHKTFQUK'];
HideUI.lblids["VALUTA"]=['MILRATMPIJ'];
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
function AQAARAIPOR_Valid(e) {
SetActiveField(Ctrl('AQAARAIPOR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRAP','C',w_DESCRAP,HtW(Ctrl('AQAARAIPOR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRAP(HtW(Ctrl('AQAARAIPOR').value,'C'),null,e);
return l_bSetResult;
}
}
function AQAARAIPOR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AQAARAIPOR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('AQAARAIPOR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AQAARAIPOR'),e);
}
function ZFOHYLVPYN_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPORAP','C',w_TIPORAP,HtW(getComboValue(Ctrl('ZFOHYLVPYN')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPORAP(HtW(getComboValue(Ctrl('ZFOHYLVPYN')),'C'),null,e);
return l_bSetResult;
}
}
function ZFOHYLVPYN_OnFocus(e) {
SetActiveField(Ctrl('ZFOHYLVPYN'),true);
}
function ZFOHYLVPYN_OnBlur(e) {
SetActiveField(Ctrl('ZFOHYLVPYN'),false);
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
function QBUCLWUNFT_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('ISOAGE','C',w_ISOAGE,HtW(getComboValue(Ctrl('QBUCLWUNFT')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ISOAGE(HtW(getComboValue(Ctrl('QBUCLWUNFT')),'C'),null,e);
return l_bSetResult;
}
}
function QBUCLWUNFT_OnFocus(e) {
SetActiveField(Ctrl('QBUCLWUNFT'),true);
}
function QBUCLWUNFT_OnBlur(e) {
SetActiveField(Ctrl('QBUCLWUNFT'),false);
}
function BCLYMGMBLK_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLAGLIRE','C',w_FLAGLIRE,HtW(getComboValue(Ctrl('BCLYMGMBLK')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLAGLIRE(HtW(getComboValue(Ctrl('BCLYMGMBLK')),'C'),null,e);
return l_bSetResult;
}
}
function BCLYMGMBLK_OnFocus(e) {
SetActiveField(Ctrl('BCLYMGMBLK'),true);
}
function BCLYMGMBLK_OnBlur(e) {
SetActiveField(Ctrl('BCLYMGMBLK'),false);
}
function RUMXLFCOKA_Valid(e) {
SetActiveField(Ctrl('RUMXLFCOKA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('VALUTA','C',w_VALUTA,HtW(Ctrl('RUMXLFCOKA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VALUTA(HtW(Ctrl('RUMXLFCOKA').value,'C'),null,e);
return l_bSetResult;
}
}
function RUMXLFCOKA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RUMXLFCOKA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RUMXLFCOKA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RUMXLFCOKA'),e);
}
function RUMXLFCOKA_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('RUMXLFCOKA')),'linkview_RUMXLFCOKA','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
linkpc_url.u('OYYXUVDIWN',function(){return 'ardt_ae_delegabo?m_bInnerChild=true'+GetLinkPCKeys('ardt_ae_delegabo')+'&m_bRowsChild='+EnableChild('ardt_ae_delegabo')})
linkpc_url.u('XRVFDCHTKZ',function(){return 'ardt_saldioro?m_bInnerChild=true'+GetLinkPCKeys('ardt_saldioro')+'&m_bRowsChild='+EnableChild('ardt_saldioro')})
linkpc_url.u('ZSYGOPYXSA',function(){return 'ardt_jarantbo?m_bInnerChild=true'+GetLinkPCKeys('ardt_jarantbo')+'&m_bRowsChild='+EnableChild('ardt_jarantbo')})
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
function AQAARAIPOR_wrap_Valid(event) {
return AQAARAIPOR_Valid(event);
}
SPBOUILib.SetInputExit('AQAARAIPOR',AQAARAIPOR_wrap_Valid);
function AQAARAIPOR_wrap_OnFocus(event) {
return AQAARAIPOR_OnFocus(event);
}
SPBOUILib.SetInputEnter('AQAARAIPOR',AQAARAIPOR_wrap_OnFocus);
function AQAARAIPOR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AQAARAIPOR',AQAARAIPOR_wrap_OnKeyDown);
function ZFOHYLVPYN_wrap_Valid(event) {
return ZFOHYLVPYN_Valid(event);
}
SPBOUILib.SetComboChange('ZFOHYLVPYN',ZFOHYLVPYN_wrap_Valid);
function ZFOHYLVPYN_wrap_OnFocus(event) {
return ZFOHYLVPYN_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZFOHYLVPYN',ZFOHYLVPYN_wrap_OnFocus);
function ZFOHYLVPYN_wrap_Blur(event) {
return ZFOHYLVPYN_OnBlur(event);
}
SPBOUILib.SetInputExit('ZFOHYLVPYN',ZFOHYLVPYN_wrap_Blur);
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
function QBUCLWUNFT_wrap_Valid(event) {
return QBUCLWUNFT_Valid(event);
}
SPBOUILib.SetComboChange('QBUCLWUNFT',QBUCLWUNFT_wrap_Valid);
function QBUCLWUNFT_wrap_OnFocus(event) {
return QBUCLWUNFT_OnFocus(event);
}
SPBOUILib.SetInputEnter('QBUCLWUNFT',QBUCLWUNFT_wrap_OnFocus);
function QBUCLWUNFT_wrap_Blur(event) {
return QBUCLWUNFT_OnBlur(event);
}
SPBOUILib.SetInputExit('QBUCLWUNFT',QBUCLWUNFT_wrap_Blur);
function BCLYMGMBLK_wrap_Valid(event) {
return BCLYMGMBLK_Valid(event);
}
SPBOUILib.SetComboChange('BCLYMGMBLK',BCLYMGMBLK_wrap_Valid);
function BCLYMGMBLK_wrap_OnFocus(event) {
return BCLYMGMBLK_OnFocus(event);
}
SPBOUILib.SetInputEnter('BCLYMGMBLK',BCLYMGMBLK_wrap_OnFocus);
function BCLYMGMBLK_wrap_Blur(event) {
return BCLYMGMBLK_OnBlur(event);
}
SPBOUILib.SetInputExit('BCLYMGMBLK',BCLYMGMBLK_wrap_Blur);
function RUMXLFCOKA_wrap_Valid(event) {
return RUMXLFCOKA_Valid(event);
}
SPBOUILib.SetInputExit('RUMXLFCOKA',RUMXLFCOKA_wrap_Valid);
function RUMXLFCOKA_wrap_OnFocus(event) {
return RUMXLFCOKA_OnFocus(event);
}
SPBOUILib.SetInputEnter('RUMXLFCOKA',RUMXLFCOKA_wrap_OnFocus);
function RUMXLFCOKA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RUMXLFCOKA',RUMXLFCOKA_wrap_OnKeyDown);
function RUMXLFCOKA_ZOOM_setHandlers() {
function RUMXLFCOKA_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?RUMXLFCOKA_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('RUMXLFCOKA_ZOOM',RUMXLFCOKA_ZOOM_wrap_OnClick);
function RUMXLFCOKA_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('RUMXLFCOKA_ZOOM',RUMXLFCOKA_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('RUMXLFCOKA',RUMXLFCOKA_ZOOM_setHandlers);
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
if (Ne(typeof(w_Intestatari),'undefined')) {
w_Intestatari.raiseEvent('armt_ae_anarap_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Informazioni),'undefined')) {
w_Informazioni.raiseEvent('armt_ae_anarap_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Operazioni),'undefined')) {
w_Operazioni.raiseEvent('armt_ae_anarap_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.edit={"page_1":["AQAARAIPOR"]};
FocusFirstComponent.query={"page_1":["LXORWVRYJJ"]};
FocusFirstComponent.otherwise={"page_1":["LXORWVRYJJ"]};
function Help() {
windowOpenForeground('../doc/armt_ae_anarap_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_ardt_ae_delegabo() {
SetModified();
}
function SetModified_ardt_saldioro() {
SetModified();
}
function SetModified_ardt_jarantbo() {
SetModified();
}
function SetModified_ardt_ae_saldianno_rap() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_3')) {
if (ChildToLoad('OYYXUVDIWN')) {
LoadContext.lc(1,'OYYXUVDIWN');
} else {
LibJavascript.RefreshChildGrid('OYYXUVDIWN');
}
}
if (Eq(page,'page_3')) {
if (ChildToLoad('XRVFDCHTKZ')) {
LoadContext.lc(1,'XRVFDCHTKZ');
} else {
LibJavascript.RefreshChildGrid('XRVFDCHTKZ');
}
}
if (Eq(page,'page_4')) {
if (ChildToLoad('ZSYGOPYXSA')) {
LoadContext.lc(1,'ZSYGOPYXSA');
} else {
LibJavascript.RefreshChildGrid('ZSYGOPYXSA');
}
}
if (Eq(page,'page_5')) {
if (ChildToLoad('XUXHMWVHFR')) {
if (Eq(lazy,null) || LibJavascript.UserCanSee('XUXHMWVHFR')) {
LoadContext.lc(1,'XUXHMWVHFR');
}
} else {
LibJavascript.RefreshChildGrid('XUXHMWVHFR');
}
}
}
GetLayerID.Layers.push({"id":"YORQOIOBQN","name":"DatiBase"});
GetLayerID.Layers.push({"id":"GJZISGEBVV","name":"DatiBase"});
GetLayerID.Layers.push({"id":"LZCEHELAXJ","name":"Rapporto"});
GetLayerID.Layers.push({"id":"EHSQLOIDHO","name":"Deleghe"});
GetLayerID.Layers.push({"id":"KAVLKRYWMM","name":"SaldiOro"});
GetLayerID.Layers.push({"id":"LWDMGLAEON","name":"Garantiti"});
GetLayerID.Layers.push({"id":"MUCCIMEJEB","name":"Saldi"});
function DeclareWVs() {
var a = arguments;
w_RAPPORTO=a[0];
w_DESCRAP=a[1];
w_TIPORAP=a[2];
w_TIPOAG=a[3];
w_ISOAGE=a[4];
w_FLAGLIRE=a[5];
w_VALUTA=a[6];
w_PRGIMPRAP=a[7];
op_PRGIMPRAP=a[8];
w_CODDIP=a[9];
w_NOPROT=a[10];
w_gTelepass=a[11];
w_gCodDip=a[12];
w_gBrowser=a[13];
w_gTipInter=a[14];
w_descval=a[15];
w_daticoll=a[16];
w_titolo=a[17];
w_mess=a[18];
op_codazi=a[19];
m_cWv_ardt_ae_delegabo=a[20];
m_cWv_ardt_saldioro=a[21];
m_cWv_ardt_jarantbo=a[22];
m_cWv_ardt_ae_saldianno_rap=a[23];
if (Gt(a.length,24)) {
m_cErrorInChild='';
}
if (Gt(a.length,24)) {
o_TIPOAG=w_TIPOAG;
o_FLAGLIRE=w_FLAGLIRE;
o_VALUTA=w_VALUTA;
}
m_PrimaryKeys=['RAPPORTO'];
}
function i_PrimaryKey() {
return 'jnarapbo'+'\\'+CPLib.ToCPStr(w_RAPPORTO);
}
GetLinkPCKeys.set_o('ardt_ae_delegabo',false);
GetLinkPCKeys.set_o('ardt_saldioro',false);
GetLinkPCKeys.set_o('ardt_jarantbo',false);
GetLinkPCKeys.set_o('ardt_ae_saldianno_rap',false);
GetLinkPCKeys.o['ardt_ae_delegabo']['RAPPORTO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_RAPPORTO,'C');
}
}
GetLinkPCKeys.o['ardt_saldioro']['RAPPORTO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_RAPPORTO,'C');
}
}
GetLinkPCKeys.o['ardt_jarantbo']['RAPPORTO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_RAPPORTO,'C');
}
}
GetLinkPCKeys.o['ardt_ae_saldianno_rap']['RAPPORTO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_RAPPORTO,'C');
}
}
resizeChildIframe.children['ardt_ae_delegabo']=true;
resizeChildIframe.children['ardt_saldioro']=true;
resizeChildIframe.children['ardt_jarantbo']=true;
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('OYYXUVDIWN',function(){return FrameRef('ardt_ae_delegabo')},1,'ardt_ae_delegabo',0,3)
LoadContext.f('XRVFDCHTKZ',function(){return FrameRef('ardt_saldioro')},1,'ardt_saldioro',0,3)
LoadContext.f('ZSYGOPYXSA',function(){return FrameRef('ardt_jarantbo')},1,'ardt_jarantbo',0,4)
LoadContext.f('XUXHMWVHFR',function(){return FrameRef('ardt_ae_saldianno_rap')},1,'ardt_ae_saldianno_rap',0,5)
GetSelectedChildPage.child={'ardt_ae_delegabo': function(){return FrameRef('ardt_ae_delegabo')}, 'ardt_saldioro': function(){return FrameRef('ardt_saldioro')}, 'ardt_jarantbo': function(){return FrameRef('ardt_jarantbo')}, 'ardt_ae_saldianno_rap': function(){return FrameRef('ardt_ae_saldianno_rap')}}
function GetSelectedPage(p_d) {
p_d.setValue('armt_ae_anarap',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('armt_divise','C'),"fldValues":[{"expression":function() { return WtA(w_VALUTA,'C'); },"field":"CODVAL","type":"C"},{"expression":function() { return WtA(w_descval,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbvalute','C'),"uid":"RUMXLFCOKA"});
}
_Obli('ISOAGE',0,'QBUCLWUNFT',true,"1529904207",null,null,function() { return Eq(w_TIPOAG,'96') || Eq(w_TIPOAG,'97') })
_Obli('FLAGLIRE',0,'BCLYMGMBLK',true,"109710548")
_Obli('DESCRAP',0,'AQAARAIPOR',false,"285808099")
_Obli('TIPORAP',0,'ZFOHYLVPYN',true,"1723736132")
_Obli('RAPPORTO',0,'LXORWVRYJJ',false,"11116511596")
_Obli('TIPOAG',0,'BHAVHLFPAC',false)
_Obli('VALUTA',0,'RUMXLFCOKA',true,"1730321404",'RUMXLFCOKA')
