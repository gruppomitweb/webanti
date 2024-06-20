function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('CANUTVNGFD',function(){return WtH(w_CATEG01,'C',2,0,'')},w_CATEG01);
SPBOUILib.SetInputValue('IXGRJLAKIQ',function(){return WtH(w_CATEG02,'C',2,0,'')},w_CATEG02);
SPBOUILib.SetInputValue('NKIXCWZJHO',function(){return WtH(w_CATEG03,'C',2,0,'')},w_CATEG03);
SPBOUILib.SetInputValue('JQLGHMLOKO',function(){return WtH(w_CATEG04,'C',2,0,'')},w_CATEG04);
SPBOUILib.SetInputValue('QVBZSFMTVP',function(){return WtH(w_CATEG05,'C',2,0,'')},w_CATEG05);
if(c=Ctrl('QKZHBGTGRL')) ChkboxCheckUncheck(c,1,w_FLAGFRAUD)
if(c=Ctrl('QKZHBGTGRL')) ChkboxValueAssign(c,1,0,'N',1,0,'')
if(c=Ctrl('BJYOWOAAQH')) selectCombo(c,w_SV58724,'C')
if(c=Ctrl('AKMFIOWCBF')) ChkboxCheckUncheck(c,'S',w_SV58726SCA)
if(c=Ctrl('AKMFIOWCBF')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('WUEMBLXMFM')) selectCombo(c,w_SV58726SA,'C')
if(c=Ctrl('NODGYYBWWX')) selectCombo(c,w_SV58726PISP,'C')
var tmp_NRWNAJJVRA = ToHTag(AsControlValue(w_xC1DESCRI));
if (Ne(e_NRWNAJJVRA,tmp_NRWNAJJVRA)) {
SPBOUILib.SetLabelValue('NRWNAJJVRA','innerHTML',tmp_NRWNAJJVRA);
e_NRWNAJJVRA=tmp_NRWNAJJVRA;
}
var tmp_LNOFOPAOYD = ToHTag(AsControlValue(w_xC2DESCRI));
if (Ne(e_LNOFOPAOYD,tmp_LNOFOPAOYD)) {
SPBOUILib.SetLabelValue('LNOFOPAOYD','innerHTML',tmp_LNOFOPAOYD);
e_LNOFOPAOYD=tmp_LNOFOPAOYD;
}
var tmp_WBTKNDJDFF = ToHTag(AsControlValue(w_xC3DESCRI));
if (Ne(e_WBTKNDJDFF,tmp_WBTKNDJDFF)) {
SPBOUILib.SetLabelValue('WBTKNDJDFF','innerHTML',tmp_WBTKNDJDFF);
e_WBTKNDJDFF=tmp_WBTKNDJDFF;
}
var tmp_MWCFKQVNHF = ToHTag(AsControlValue(w_xC4DESCRI));
if (Ne(e_MWCFKQVNHF,tmp_MWCFKQVNHF)) {
SPBOUILib.SetLabelValue('MWCFKQVNHF','innerHTML',tmp_MWCFKQVNHF);
e_MWCFKQVNHF=tmp_MWCFKQVNHF;
}
var tmp_HADVHTQAPE = ToHTag(AsControlValue(w_xC5DESCRI));
if (Ne(e_HADVHTQAPE,tmp_HADVHTQAPE)) {
SPBOUILib.SetLabelValue('HADVHTQAPE','innerHTML',tmp_HADVHTQAPE);
e_HADVHTQAPE=tmp_HADVHTQAPE;
}
SPBOUILib.SetInputValue('LUQZFCFSYI',function(){return WtH(w_C_COGNOME,'C',50,0,'')},w_C_COGNOME);
SPBOUILib.SetInputValue('DXUKTRNNCS',function(){return WtH(w_C_NOME,'C',30,0,'')},w_C_NOME);
if(c=Ctrl('CIGEGYZWMZ')) selectCombo(c,w_SOSPAGAM,'C')
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay('RFAIYHSGII_DIV',IsHiddenByStateDriver('Categorie'));
SetDisplay('JANROHXZBL_DIV',Eq(w_SEGNO,'A') || IsHiddenByStateDriver('sv'));
SetDisplay('QKZHBGTGRL_DIV',Ne(w_SEGNO,'D'));
SetDisplay(Ctrl('BJYOWOAAQH'),Ne(w_SEGNO,'D') || IsHiddenByStateDriver('SV58724'));
SetDisplay('AKMFIOWCBF_DIV',Ne(w_SEGNO,'D'));
SetDisplay(Ctrl('WUEMBLXMFM'),Ne(w_SEGNO,'D') || IsHiddenByStateDriver('SV58726SA'));
SetDisplay(Ctrl('NODGYYBWWX'),Ne(w_SEGNO,'D') || IsHiddenByStateDriver('SV58726PISP'));
SetDisplay(Ctrl('XVUIFQMEIG'),Ne(w_SEGNO,'D'));
SetDisplay(Ctrl('WFICGFEUAH'),Ne(w_SEGNO,'D'));
SetDisplay(Ctrl('VIBYCNNDWC'),Ne(w_SEGNO,'D'));
SetDisplay('STHOKLKHLK_DIV',IsHiddenByStateDriver('SOS'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["CATEG01"]=['WWRYOVTMFY'];
HideUI.lblids["CATEG02"]=['HNQZARYXGS'];
HideUI.lblids["CATEG03"]=['BGEVFUGGOS'];
HideUI.lblids["CATEG04"]=['RHXCIUHRTU'];
HideUI.lblids["CATEG05"]=['GRCYFEKJWU'];
HideUI.lblids["C_COGNOME"]=['FVAZAUXFYY'];
HideUI.lblids["C_NOME"]=['EYRDOOPCVW'];
HideUI.lblids["SOSPAGAM"]=['VAWAJFPLKZ'];
HideUI.lblids["SV58724"]=['XVUIFQMEIG'];
HideUI.lblids["SV58726PISP"]=['VIBYCNNDWC'];
HideUI.lblids["SV58726SA"]=['WFICGFEUAH'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function CANUTVNGFD_Valid(e) {
SetActiveField(Ctrl('CANUTVNGFD'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CATEG01','C',w_CATEG01,HtW(Ctrl('CANUTVNGFD').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CATEG01(HtW(Ctrl('CANUTVNGFD').value,'C'),null,e);
return l_bSetResult;
}
}
function CANUTVNGFD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CANUTVNGFD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CANUTVNGFD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CANUTVNGFD'),e);
}
function CANUTVNGFD_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('CANUTVNGFD')),'linkview_CANUTVNGFD','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function IXGRJLAKIQ_Valid(e) {
SetActiveField(Ctrl('IXGRJLAKIQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CATEG02','C',w_CATEG02,HtW(Ctrl('IXGRJLAKIQ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CATEG02(HtW(Ctrl('IXGRJLAKIQ').value,'C'),null,e);
return l_bSetResult;
}
}
function IXGRJLAKIQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IXGRJLAKIQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IXGRJLAKIQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IXGRJLAKIQ'),e);
}
function IXGRJLAKIQ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('IXGRJLAKIQ')),'linkview_IXGRJLAKIQ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function NKIXCWZJHO_Valid(e) {
SetActiveField(Ctrl('NKIXCWZJHO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CATEG03','C',w_CATEG03,HtW(Ctrl('NKIXCWZJHO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CATEG03(HtW(Ctrl('NKIXCWZJHO').value,'C'),null,e);
return l_bSetResult;
}
}
function NKIXCWZJHO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NKIXCWZJHO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NKIXCWZJHO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NKIXCWZJHO'),e);
}
function NKIXCWZJHO_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('NKIXCWZJHO')),'linkview_NKIXCWZJHO','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function JQLGHMLOKO_Valid(e) {
SetActiveField(Ctrl('JQLGHMLOKO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CATEG04','C',w_CATEG04,HtW(Ctrl('JQLGHMLOKO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CATEG04(HtW(Ctrl('JQLGHMLOKO').value,'C'),null,e);
return l_bSetResult;
}
}
function JQLGHMLOKO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JQLGHMLOKO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JQLGHMLOKO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JQLGHMLOKO'),e);
}
function JQLGHMLOKO_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('JQLGHMLOKO')),'linkview_JQLGHMLOKO','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function QVBZSFMTVP_Valid(e) {
SetActiveField(Ctrl('QVBZSFMTVP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CATEG05','C',w_CATEG05,HtW(Ctrl('QVBZSFMTVP').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CATEG05(HtW(Ctrl('QVBZSFMTVP').value,'C'),null,e);
return l_bSetResult;
}
}
function QVBZSFMTVP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QVBZSFMTVP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QVBZSFMTVP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QVBZSFMTVP'),e);
}
function QVBZSFMTVP_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('QVBZSFMTVP')),'linkview_QVBZSFMTVP','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function QKZHBGTGRL_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLAGFRAUD','N',w_FLAGFRAUD,ChkboxValueAssign(Ctrl('QKZHBGTGRL'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLAGFRAUD(ChkboxValueAssign(Ctrl('QKZHBGTGRL'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function QKZHBGTGRL_OnFocus(e) {
SetActiveField(Ctrl('QKZHBGTGRL'),true);
}
function QKZHBGTGRL_OnBlur(e) {
SetActiveField(Ctrl('QKZHBGTGRL'),false);
}
function BJYOWOAAQH_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('SV58724','C',w_SV58724,HtW(getComboValue(Ctrl('BJYOWOAAQH')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SV58724(HtW(getComboValue(Ctrl('BJYOWOAAQH')),'C'),null,e);
return l_bSetResult;
}
}
function BJYOWOAAQH_OnFocus(e) {
SetActiveField(Ctrl('BJYOWOAAQH'),true);
}
function BJYOWOAAQH_OnBlur(e) {
SetActiveField(Ctrl('BJYOWOAAQH'),false);
}
function AKMFIOWCBF_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('SV58726SCA','C',w_SV58726SCA,ChkboxValueAssign(Ctrl('AKMFIOWCBF'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SV58726SCA(ChkboxValueAssign(Ctrl('AKMFIOWCBF'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function AKMFIOWCBF_OnFocus(e) {
SetActiveField(Ctrl('AKMFIOWCBF'),true);
}
function AKMFIOWCBF_OnBlur(e) {
SetActiveField(Ctrl('AKMFIOWCBF'),false);
}
function WUEMBLXMFM_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('SV58726SA','C',w_SV58726SA,HtW(getComboValue(Ctrl('WUEMBLXMFM')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SV58726SA(HtW(getComboValue(Ctrl('WUEMBLXMFM')),'C'),null,e);
return l_bSetResult;
}
}
function WUEMBLXMFM_OnFocus(e) {
SetActiveField(Ctrl('WUEMBLXMFM'),true);
}
function WUEMBLXMFM_OnBlur(e) {
SetActiveField(Ctrl('WUEMBLXMFM'),false);
}
function NODGYYBWWX_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('SV58726PISP','C',w_SV58726PISP,HtW(getComboValue(Ctrl('NODGYYBWWX')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SV58726PISP(HtW(getComboValue(Ctrl('NODGYYBWWX')),'C'),null,e);
return l_bSetResult;
}
}
function NODGYYBWWX_OnFocus(e) {
SetActiveField(Ctrl('NODGYYBWWX'),true);
}
function NODGYYBWWX_OnBlur(e) {
SetActiveField(Ctrl('NODGYYBWWX'),false);
}
function LUQZFCFSYI_Valid(e) {
SetActiveField(Ctrl('LUQZFCFSYI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_COGNOME','C',w_C_COGNOME,HtW(Ctrl('LUQZFCFSYI').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_COGNOME(HtW(Ctrl('LUQZFCFSYI').value,'C'),null,e);
return l_bSetResult;
}
}
function LUQZFCFSYI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LUQZFCFSYI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LUQZFCFSYI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LUQZFCFSYI'),e);
}
function DXUKTRNNCS_Valid(e) {
SetActiveField(Ctrl('DXUKTRNNCS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_NOME','C',w_C_NOME,HtW(Ctrl('DXUKTRNNCS').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_NOME(HtW(Ctrl('DXUKTRNNCS').value,'C'),null,e);
return l_bSetResult;
}
}
function DXUKTRNNCS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DXUKTRNNCS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DXUKTRNNCS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DXUKTRNNCS'),e);
}
function CIGEGYZWMZ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('SOSPAGAM','C',w_SOSPAGAM,HtW(getComboValue(Ctrl('CIGEGYZWMZ')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SOSPAGAM(HtW(getComboValue(Ctrl('CIGEGYZWMZ')),'C'),null,e);
return l_bSetResult;
}
}
function CIGEGYZWMZ_OnFocus(e) {
SetActiveField(Ctrl('CIGEGYZWMZ'),true);
}
function CIGEGYZWMZ_OnBlur(e) {
SetActiveField(Ctrl('CIGEGYZWMZ'),false);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function CANUTVNGFD_wrap_Valid(event) {
return CANUTVNGFD_Valid(event);
}
SPBOUILib.SetInputExit('CANUTVNGFD',CANUTVNGFD_wrap_Valid);
function CANUTVNGFD_wrap_OnFocus(event) {
return CANUTVNGFD_OnFocus(event);
}
SPBOUILib.SetInputEnter('CANUTVNGFD',CANUTVNGFD_wrap_OnFocus);
function CANUTVNGFD_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CANUTVNGFD',CANUTVNGFD_wrap_OnKeyDown);
function CANUTVNGFD_ZOOM_setHandlers() {
function CANUTVNGFD_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?CANUTVNGFD_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('CANUTVNGFD_ZOOM',CANUTVNGFD_ZOOM_wrap_OnClick);
function CANUTVNGFD_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('CANUTVNGFD_ZOOM',CANUTVNGFD_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('CANUTVNGFD',CANUTVNGFD_ZOOM_setHandlers);
function IXGRJLAKIQ_wrap_Valid(event) {
return IXGRJLAKIQ_Valid(event);
}
SPBOUILib.SetInputExit('IXGRJLAKIQ',IXGRJLAKIQ_wrap_Valid);
function IXGRJLAKIQ_wrap_OnFocus(event) {
return IXGRJLAKIQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('IXGRJLAKIQ',IXGRJLAKIQ_wrap_OnFocus);
function IXGRJLAKIQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IXGRJLAKIQ',IXGRJLAKIQ_wrap_OnKeyDown);
function IXGRJLAKIQ_ZOOM_setHandlers() {
function IXGRJLAKIQ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?IXGRJLAKIQ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('IXGRJLAKIQ_ZOOM',IXGRJLAKIQ_ZOOM_wrap_OnClick);
function IXGRJLAKIQ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('IXGRJLAKIQ_ZOOM',IXGRJLAKIQ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('IXGRJLAKIQ',IXGRJLAKIQ_ZOOM_setHandlers);
function NKIXCWZJHO_wrap_Valid(event) {
return NKIXCWZJHO_Valid(event);
}
SPBOUILib.SetInputExit('NKIXCWZJHO',NKIXCWZJHO_wrap_Valid);
function NKIXCWZJHO_wrap_OnFocus(event) {
return NKIXCWZJHO_OnFocus(event);
}
SPBOUILib.SetInputEnter('NKIXCWZJHO',NKIXCWZJHO_wrap_OnFocus);
function NKIXCWZJHO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NKIXCWZJHO',NKIXCWZJHO_wrap_OnKeyDown);
function NKIXCWZJHO_ZOOM_setHandlers() {
function NKIXCWZJHO_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?NKIXCWZJHO_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('NKIXCWZJHO_ZOOM',NKIXCWZJHO_ZOOM_wrap_OnClick);
function NKIXCWZJHO_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('NKIXCWZJHO_ZOOM',NKIXCWZJHO_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('NKIXCWZJHO',NKIXCWZJHO_ZOOM_setHandlers);
function JQLGHMLOKO_wrap_Valid(event) {
return JQLGHMLOKO_Valid(event);
}
SPBOUILib.SetInputExit('JQLGHMLOKO',JQLGHMLOKO_wrap_Valid);
function JQLGHMLOKO_wrap_OnFocus(event) {
return JQLGHMLOKO_OnFocus(event);
}
SPBOUILib.SetInputEnter('JQLGHMLOKO',JQLGHMLOKO_wrap_OnFocus);
function JQLGHMLOKO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JQLGHMLOKO',JQLGHMLOKO_wrap_OnKeyDown);
function JQLGHMLOKO_ZOOM_setHandlers() {
function JQLGHMLOKO_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?JQLGHMLOKO_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('JQLGHMLOKO_ZOOM',JQLGHMLOKO_ZOOM_wrap_OnClick);
function JQLGHMLOKO_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('JQLGHMLOKO_ZOOM',JQLGHMLOKO_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('JQLGHMLOKO',JQLGHMLOKO_ZOOM_setHandlers);
function QVBZSFMTVP_wrap_Valid(event) {
return QVBZSFMTVP_Valid(event);
}
SPBOUILib.SetInputExit('QVBZSFMTVP',QVBZSFMTVP_wrap_Valid);
function QVBZSFMTVP_wrap_OnFocus(event) {
return QVBZSFMTVP_OnFocus(event);
}
SPBOUILib.SetInputEnter('QVBZSFMTVP',QVBZSFMTVP_wrap_OnFocus);
function QVBZSFMTVP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QVBZSFMTVP',QVBZSFMTVP_wrap_OnKeyDown);
function QVBZSFMTVP_ZOOM_setHandlers() {
function QVBZSFMTVP_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?QVBZSFMTVP_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('QVBZSFMTVP_ZOOM',QVBZSFMTVP_ZOOM_wrap_OnClick);
function QVBZSFMTVP_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('QVBZSFMTVP_ZOOM',QVBZSFMTVP_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('QVBZSFMTVP',QVBZSFMTVP_ZOOM_setHandlers);
function QKZHBGTGRL_wrap_Valid(event) {
return QKZHBGTGRL_Valid(event);
}
SPBOUILib.SetCheckboxClick('QKZHBGTGRL',QKZHBGTGRL_wrap_Valid);
function QKZHBGTGRL_wrap_OnFocus(event) {
return QKZHBGTGRL_OnFocus(event);
}
SPBOUILib.SetInputEnter('QKZHBGTGRL',QKZHBGTGRL_wrap_OnFocus);
function QKZHBGTGRL_wrap_Blur(event) {
return QKZHBGTGRL_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('QKZHBGTGRL',QKZHBGTGRL_wrap_Blur);
function BJYOWOAAQH_wrap_Valid(event) {
return BJYOWOAAQH_Valid(event);
}
SPBOUILib.SetComboChange('BJYOWOAAQH',BJYOWOAAQH_wrap_Valid);
function BJYOWOAAQH_wrap_OnFocus(event) {
return BJYOWOAAQH_OnFocus(event);
}
SPBOUILib.SetInputEnter('BJYOWOAAQH',BJYOWOAAQH_wrap_OnFocus);
function BJYOWOAAQH_wrap_Blur(event) {
return BJYOWOAAQH_OnBlur(event);
}
SPBOUILib.SetInputExit('BJYOWOAAQH',BJYOWOAAQH_wrap_Blur);
function AKMFIOWCBF_wrap_Valid(event) {
return AKMFIOWCBF_Valid(event);
}
SPBOUILib.SetCheckboxClick('AKMFIOWCBF',AKMFIOWCBF_wrap_Valid);
function AKMFIOWCBF_wrap_OnFocus(event) {
return AKMFIOWCBF_OnFocus(event);
}
SPBOUILib.SetInputEnter('AKMFIOWCBF',AKMFIOWCBF_wrap_OnFocus);
function AKMFIOWCBF_wrap_Blur(event) {
return AKMFIOWCBF_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('AKMFIOWCBF',AKMFIOWCBF_wrap_Blur);
function WUEMBLXMFM_wrap_Valid(event) {
return WUEMBLXMFM_Valid(event);
}
SPBOUILib.SetComboChange('WUEMBLXMFM',WUEMBLXMFM_wrap_Valid);
function WUEMBLXMFM_wrap_OnFocus(event) {
return WUEMBLXMFM_OnFocus(event);
}
SPBOUILib.SetInputEnter('WUEMBLXMFM',WUEMBLXMFM_wrap_OnFocus);
function WUEMBLXMFM_wrap_Blur(event) {
return WUEMBLXMFM_OnBlur(event);
}
SPBOUILib.SetInputExit('WUEMBLXMFM',WUEMBLXMFM_wrap_Blur);
function NODGYYBWWX_wrap_Valid(event) {
return NODGYYBWWX_Valid(event);
}
SPBOUILib.SetComboChange('NODGYYBWWX',NODGYYBWWX_wrap_Valid);
function NODGYYBWWX_wrap_OnFocus(event) {
return NODGYYBWWX_OnFocus(event);
}
SPBOUILib.SetInputEnter('NODGYYBWWX',NODGYYBWWX_wrap_OnFocus);
function NODGYYBWWX_wrap_Blur(event) {
return NODGYYBWWX_OnBlur(event);
}
SPBOUILib.SetInputExit('NODGYYBWWX',NODGYYBWWX_wrap_Blur);
function LUQZFCFSYI_wrap_Valid(event) {
return LUQZFCFSYI_Valid(event);
}
SPBOUILib.SetInputExit('LUQZFCFSYI',LUQZFCFSYI_wrap_Valid);
function LUQZFCFSYI_wrap_OnFocus(event) {
return LUQZFCFSYI_OnFocus(event);
}
SPBOUILib.SetInputEnter('LUQZFCFSYI',LUQZFCFSYI_wrap_OnFocus);
function LUQZFCFSYI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LUQZFCFSYI',LUQZFCFSYI_wrap_OnKeyDown);
function DXUKTRNNCS_wrap_Valid(event) {
return DXUKTRNNCS_Valid(event);
}
SPBOUILib.SetInputExit('DXUKTRNNCS',DXUKTRNNCS_wrap_Valid);
function DXUKTRNNCS_wrap_OnFocus(event) {
return DXUKTRNNCS_OnFocus(event);
}
SPBOUILib.SetInputEnter('DXUKTRNNCS',DXUKTRNNCS_wrap_OnFocus);
function DXUKTRNNCS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DXUKTRNNCS',DXUKTRNNCS_wrap_OnKeyDown);
function CIGEGYZWMZ_wrap_Valid(event) {
return CIGEGYZWMZ_Valid(event);
}
SPBOUILib.SetComboChange('CIGEGYZWMZ',CIGEGYZWMZ_wrap_Valid);
function CIGEGYZWMZ_wrap_OnFocus(event) {
return CIGEGYZWMZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('CIGEGYZWMZ',CIGEGYZWMZ_wrap_OnFocus);
function CIGEGYZWMZ_wrap_Blur(event) {
return CIGEGYZWMZ_OnBlur(event);
}
SPBOUILib.SetInputExit('CIGEGYZWMZ',CIGEGYZWMZ_wrap_Blur);
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
m_oFather.i_last_focused_item='child_armt_xperazbo_agg';
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
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.edit={"page_1":["CANUTVNGFD"]};
FocusFirstComponent.query={"page_1":["CANUTVNGFD"]};
FocusFirstComponent.otherwise={"page_1":["CANUTVNGFD"]};
function Help() {
windowOpenForeground('../doc/armt_xperazbo_agg_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
GetLayerID.Layers.push({"id":"RFAIYHSGII","name":"Categorie"});
GetLayerID.Layers.push({"id":"JANROHXZBL","name":"sv"});
GetLayerID.Layers.push({"id":"STHOKLKHLK","name":"SOS"});
function DeclareWVs() {
var a = arguments;
w_IDBASE=a[0];
w_CATEG01=a[1];
w_CATEG02=a[2];
w_CATEG03=a[3];
w_CATEG04=a[4];
w_CATEG05=a[5];
w_FLAGFRAUD=a[6];
w_SV58724=a[7];
w_SV58726SCA=a[8];
w_SV58726SA=a[9];
w_SV58726PISP=a[10];
w_CATEGORIA=a[11];
w_C_COGNOME=a[12];
w_C_NOME=a[13];
w_SOSPAGAM=a[14];
w_SEGNO=a[15];
w_xC1DESCRI=a[16];
w_xC2DESCRI=a[17];
w_xC3DESCRI=a[18];
w_xC4DESCRI=a[19];
w_xC5DESCRI=a[20];
if (Gt(a.length,21)) {
o_CATEG01=w_CATEG01;
o_CATEG02=w_CATEG02;
o_CATEG03=w_CATEG03;
o_CATEG04=w_CATEG04;
o_CATEG05=w_CATEG05;
}
m_PrimaryKeys=['IDBASE'];
}
function i_PrimaryKey() {
return 'xperazbo_agg'+'\\'+CPLib.ToCPStr(w_IDBASE);
}
function CheckZone(me) {
if (IsWndAccessible(window['m_oFather'])) {
return m_oFather.CheckZone('child_armt_xperazbo_agg');
}
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_xperazbo_agg',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('opemt_tbcateg01','C'),"fldValues":[{"expression":function() { return WtA(w_CATEG01,'C'); },"field":"C1CODICE","type":"C"},{"expression":function() { return WtA(w_xC1DESCRI,'C'); },"field":"C1DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcateg01','C'),"uid":"CANUTVNGFD"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('opemt_tbcateg02','C'),"fldValues":[{"expression":function() { return WtA(w_CATEG02,'C'); },"field":"C2CODICE","type":"C"},{"expression":function() { return WtA(w_xC2DESCRI,'C'); },"field":"C2DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcateg02','C'),"uid":"IXGRJLAKIQ"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('opemt_tbcateg03','C'),"fldValues":[{"expression":function() { return WtA(w_CATEG03,'C'); },"field":"C3CODICE","type":"C"},{"expression":function() { return WtA(w_xC3DESCRI,'C'); },"field":"C3DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcateg03','C'),"uid":"NKIXCWZJHO"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('opemt_tbcateg04','C'),"fldValues":[{"expression":function() { return WtA(w_CATEG04,'C'); },"field":"C4CODICE","type":"C"},{"expression":function() { return WtA(w_xC4DESCRI,'C'); },"field":"C4DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcateg04','C'),"uid":"JQLGHMLOKO"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('opemt_tbcateg05','C'),"fldValues":[{"expression":function() { return WtA(w_CATEG05,'C'); },"field":"C5CODICE","type":"C"},{"expression":function() { return WtA(w_xC5DESCRI,'C'); },"field":"C5DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcateg05','C'),"uid":"QVBZSFMTVP"});
}
_Obli('SV58726SA',0,'WUEMBLXMFM',false,"759255200")
_Obli('SOSPAGAM',0,'CIGEGYZWMZ',false,"1118764577")
_Obli('CATEG01',0,'CANUTVNGFD',false,"157154740")
_Obli('CATEG02',0,'IXGRJLAKIQ',false,"157154996")
_Obli('CATEG03',0,'NKIXCWZJHO',false,"157155252")
_Obli('CATEG04',0,'JQLGHMLOKO',false,"157154740")
_Obli('CATEG05',0,'QVBZSFMTVP',false,"157154740")
_Obli('FLAGFRAUD',1,'QKZHBGTGRL',false,"588930876")
_Obli('SV58724',0,'BJYOWOAAQH',false,"584607094")
_Obli('SV58726SCA',0,'AKMFIOWCBF',false,"10311059713")
_Obli('C_NOME',0,'DXUKTRNNCS',false,"11757468987")
_Obli('SV58726PISP',0,'NODGYYBWWX',false,"11263356912")
_Obli('C_COGNOME',0,'LUQZFCFSYI',false,"10227543146")
