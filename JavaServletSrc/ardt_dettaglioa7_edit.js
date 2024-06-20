function DisplayErrorMessage() {
if (Le(m_nLastError,-1)) {
return;
}
if (Eq(typeof(m_cErrorInChild),'undefined') || Empty(m_cErrorInChild)) {
var l_cErrorMsg = m_cLastMsgError;
if (Eq(l_cErrorMsg,'')) {
if (Eq(m_nLastError,1)) {
l_cErrorMsg='MSG_OBBLI_FIELD';
} else if (Eq(m_nLastError,2)) {
l_cErrorMsg='MSG_VALUE_NOT_ALLOWED';
} else if (Eq(m_nLastError,3)) {
l_cErrorMsg='MSG_VALUE_NOT_ALLOWED';
} else {
l_cErrorMsg='MSG_UNSPEC_ERROR';
}
}
if (Eq(m_nLastError,1)) {
WindowAlert(Translate(m_cObblFieldName)+' : '+Translate(l_cErrorMsg));
} else {
if (Eq(l_cErrorMsg,'MSG_VALUE_NOT_ALLOWED') && Ne(m_cLastWorkVarErrorMsg,'')) {
WindowAlert(Translate(m_cLastWorkVarErrorMsg)+': '+Translate(l_cErrorMsg));
} else {
WindowAlert(Translate(l_cErrorMsg));
}
}
if (Ne(m_cLastWorkVarError,'')) {
SetControlFocus(m_cLastWorkVarError);
SetErrorField(m_cLastWorkVarError,true);
m_cLastWorkVarError='';
}
} else if (Ne(typeof('DisplayErrorMessage_'+m_cErrorInChild),'undefined')) {
DisplayErrorMessageOfChild(m_cErrorInChild);
}
}
function ResetErrorVars() {
m_nLastError=0;
m_cLastMsgError='';
m_cLastWorkVarError='';
m_cLastWorkVarErrorMsg='';
m_cErrorInChild='';
}
function EnableControlsUnderCondition() {
}
function EnableControlsUnderCondition_WhenReady(inherit) {
if (Eq(inherit,null)) {
inherit=true;
}
var l_bEnabled = true;
// * --- Area Manuale = UI - Enable Controls Init
// * --- Fine Area Manuale
if (window.Z && window.Z.Tabs) {
Z.Tabs.Get('tabs').CheckTabStrip();
}
l_bEnabled= ! (Eq(w_FLGRESID,'S')) || IsDisabledByStateDriver('RESID');
SetDisabled('MVCFXMIIPY',l_bEnabled);
l_bEnabled= ! (Eq(w_FLG00015,'S')) || IsDisabledByStateDriver('PROVINCIA');
SetDisabled('SNYJQPAYYR',l_bEnabled);
l_bEnabled= ! (Eq(w_FLG00016,'S')) || IsDisabledByStateDriver('STATO');
SetDisabled('MDEBFTECJW',l_bEnabled);
l_bEnabled= ! (Eq(w_FLG01217,'S')) || IsDisabledByStateDriver('VAL01217');
SetDisabled('NHFRSWSJPA',l_bEnabled);
l_bEnabled= ! (Eq(w_FLG02147,'S')) || IsDisabledByStateDriver('VAL02147');
SetDisabled('KYDBUIQLMM',l_bEnabled);
l_bEnabled= ! (Eq(w_FLG02148,'S')) || IsDisabledByStateDriver('VAL02148');
SetDisabled('CNCQNTLDXJ',l_bEnabled);
SetDisabled(Ctrl('CNCQNTLDXJ_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(w_FLG02149,'S')) || IsDisabledByStateDriver('VAL02149');
SetDisabled('PDCPOALMKJ',l_bEnabled);
LibJavascript.forEachItem(m_FoundlingEditExpression,i_body_0)
function i_body_0(child){
child();
}
DisableUI();
if (Ne('undefined',typeof(DisableChainedLinks))) {
DisableChainedLinks(Ne(0,m_oTrs.length));
}
if (inherit && IsWndAccessible(m_oFather) &&  ! (m_oFather.m_bCalculating)) {
m_oFather.EnableControlsUnderCondition();
}
HideControlsUnderCondition();
ObligatoryControlsUnderCondition();
// * --- Area Manuale = UI - Enable Controls End
// * --- Fine Area Manuale
}
function ObligatoryControlsUnderCondition() {
var l_bObligatory = true;
SetObligatory(Ctrl('MVCFXMIIPY'),Eq(w_FLGRESID,'S') || IsObligatoryByStateDriver('RESID'));
SetObligatory(Ctrl('SNYJQPAYYR'),Eq(w_FLG00015,'S') || IsObligatoryByStateDriver('PROVINCIA'));
SetObligatory(Ctrl('MDEBFTECJW'),Eq(w_FLG00016,'S') || IsObligatoryByStateDriver('STATO'));
SetObligatory(Ctrl('NHFRSWSJPA'),Eq(w_FLG01217,'S') || IsObligatoryByStateDriver('VAL01217'));
SetObligatory(Ctrl('KYDBUIQLMM'),Eq(w_FLG02147,'S') || IsObligatoryByStateDriver('VAL02147'));
SetObligatory(Ctrl('CNCQNTLDXJ'),Eq(w_FLG02148,'S') || IsObligatoryByStateDriver('VAL02148'));
SetObligatory(Ctrl('PDCPOALMKJ'),Eq(w_FLG02149,'S') || IsObligatoryByStateDriver('VAL02149'));
}
function SetDynamicClasses() {
var c;
}
function SetDynamicTooltip() {
var c;
if(c=Ctrl('GVMMKABWWU')) c.title=Strtran(AlertErrorMessage('11214349292',w_xDESVOCE),'\\n',"\n");
if(c=Ctrl('NNRZYWQBXJ')) c.title=Strtran(AlertErrorMessage('12019815305',w_xDESCRI),'\\n',"\n");
}
function SetDefaultFixedStyles() {
SetErrorField('MVCFXMIIPY',false);
SetErrorField('SNYJQPAYYR',false);
SetErrorField('MDEBFTECJW',false);
SetErrorField('NHFRSWSJPA',false);
SetErrorField('KYDBUIQLMM',false);
SetErrorField('CNCQNTLDXJ',false);
SetErrorField('PDCPOALMKJ',false);
SetErrorField('OWRKSPYBFW',false);
}
function Set_PROVINCIA(ctrlValue,kmode,e) {
if (Ne(w_PROVINCIA,ctrlValue)) {
var ctl = _GetCtl(e,'SNYJQPAYYR');
if (_tracker.goon(ctl,ctrlValue)) {
w_PROVINCIA=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SNYJQPAYYR',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',5,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_STATO(ctrlValue,kmode,e) {
if (Ne(w_STATO,ctrlValue)) {
var ctl = _GetCtl(e,'MDEBFTECJW');
if (_tracker.goon(ctl,ctrlValue)) {
w_STATO=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MDEBFTECJW',0);
if (l_bResult) {
l_bResult=Link_MDEBFTECJW(kmode);
if ( ! (l_bResult)) {
w_STATO=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',3,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',3,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_VOCE(ctrlValue,kmode,e) {
if (Ne(w_VOCE,ctrlValue)) {
var ctl = _GetCtl(e,'GVMMKABWWU');
if (_tracker.goon(ctl,ctrlValue)) {
w_VOCE=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GVMMKABWWU',0);
if (l_bResult) {
l_bResult=Link_GVMMKABWWU(kmode);
if ( ! (Empty(w_SOTTOVOCE))) {
Link_NNRZYWQBXJ(kmode);
}
if ( ! (l_bResult)) {
w_VOCE=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',5,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',5,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_SOTTOVOCE(ctrlValue,kmode,e) {
if (Ne(w_SOTTOVOCE,ctrlValue)) {
var ctl = _GetCtl(e,'NNRZYWQBXJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOTTOVOCE=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NNRZYWQBXJ',0);
if (l_bResult) {
l_bResult=Link_NNRZYWQBXJ(kmode);
if ( ! (l_bResult)) {
w_SOTTOVOCE=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',2,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_RESID(ctrlValue,kmode,e) {
if (Ne(w_RESID,ctrlValue)) {
var ctl = _GetCtl(e,'MVCFXMIIPY');
if (_tracker.goon(ctl,ctrlValue)) {
w_RESID=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MVCFXMIIPY',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_VAL02147(ctrlValue,kmode,e) {
if (Ne(w_VAL02147,ctrlValue)) {
var ctl = _GetCtl(e,'KYDBUIQLMM');
if (_tracker.goon(ctl,ctrlValue)) {
w_VAL02147=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KYDBUIQLMM',0);
if (l_bResult) {
l_bResult=Link_KYDBUIQLMM(kmode);
if ( ! (l_bResult)) {
w_VAL02147=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',5,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',5,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_IMPORTO(ctrlValue,kmode,e) {
if (Ne(w_IMPORTO,ctrlValue)) {
var ctl = _GetCtl(e,'OWRKSPYBFW');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMPORTO=ValidNum(ctrlValue,'999999999999.99');
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OWRKSPYBFW',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('OWRKSPYBFW',function(){return WtH(w_IMPORTO,'N',15,2,'999,999,999,999.99')},w_IMPORTO);
return l_bResult;
} else {
ctl.value=WtH('','N',15,2,'999999999999.99');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('OWRKSPYBFW',function(){return WtH(w_IMPORTO,'N',15,2,'999,999,999,999.99')},w_IMPORTO);
}
return true;
}
function Set_VAL01217(ctrlValue,kmode,e) {
if (Ne(w_VAL01217,ctrlValue)) {
var ctl = _GetCtl(e,'NHFRSWSJPA');
if (_tracker.goon(ctl,ctrlValue)) {
w_VAL01217=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NHFRSWSJPA',0);
if (l_bResult) {
l_bResult=Link_NHFRSWSJPA(kmode);
if ( ! (l_bResult)) {
w_VAL01217=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',5,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',5,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_VAL02148(ctrlValue,kmode,e) {
if (Ne(w_VAL02148,ctrlValue)) {
var ctl = _GetCtl(e,'CNCQNTLDXJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_VAL02148=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CNCQNTLDXJ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_VAL02149(ctrlValue,kmode,e) {
if (Ne(w_VAL02149,ctrlValue)) {
var ctl = _GetCtl(e,'PDCPOALMKJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_VAL02149=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PDCPOALMKJ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',6,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
if ((Ne(o_VOCE,w_VOCE))) {
RenderDynamicCombo('NNRZYWQBXJ');
l_bTmpRes=Link_NNRZYWQBXJ(null);
}
if ((Ne(o_VOCE,w_VOCE))) {
RenderDynamicCombo('NHFRSWSJPA');
l_bTmpRes=Link_NHFRSWSJPA(null);
}
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
o_VOCE=w_VOCE;
}
function SaveLabelDependsOn() {
}
function Link_GVMMKABWWU(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_VOCE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('VOCE',w_VOCE,5,0);
l_Appl.SetFields('VOCE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('vocea7');
l_Appl.SetID('GVMMKABWWU');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_VOCE=l_Appl.GetStringValue('VOCE',5,0);
w_xDESVOCE=l_Appl.GetStringValue('DESCRI',160,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_GVMMKABWWU_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_GVMMKABWWU';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_GVMMKABWWU();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
layerOpenForeground(l_cLinkUrl,openername,'toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes');
m_nLastError=-2;
} else {
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
}
return l_bResult;
}
function Link_GVMMKABWWU_Blank() {
w_VOCE='';
w_xDESVOCE='';
}
function LOpt_GVMMKABWWU() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('vocea7','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('VOCE','C'));
l_oWv.setValue('LinkedField',WtA('VOCE','C'));
l_oWv.setValue('UID',WtA('GVMMKABWWU','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['GVMMKABWWU'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('457286'),'C'));
return l_oWv;
}
function Link_NNRZYWQBXJ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_SOTTOVOCE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('VOCE',w_VOCE,5,0);
l_Appl.SetStringKey('SOTTOVOCE',w_SOTTOVOCE,2,0);
l_Appl.SetFields('SOTTOVOCE,FLGRESID,FLG00015,FLG00016,FLG01217,FLG02147,FLG02148,FLG02149,DESCRI');
l_Appl.SetTypes('C,C,C,C,C,C,C,C,C');
l_Appl.LinkTable('sottovocea7');
l_Appl.SetID('NNRZYWQBXJ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_SOTTOVOCE=l_Appl.GetStringValue('SOTTOVOCE',2,0);
w_FLGRESID=l_Appl.GetStringValue('FLGRESID',1,0);
w_FLG00015=l_Appl.GetStringValue('FLG00015',1,0);
w_FLG00016=l_Appl.GetStringValue('FLG00016',1,0);
w_FLG01217=l_Appl.GetStringValue('FLG01217',1,0);
w_FLG02147=l_Appl.GetStringValue('FLG02147',1,0);
w_FLG02148=l_Appl.GetStringValue('FLG02148',1,0);
w_FLG02149=l_Appl.GetStringValue('FLG02149',1,0);
w_xDESCRI=l_Appl.GetStringValue('DESCRI',160,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_NNRZYWQBXJ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_NNRZYWQBXJ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_NNRZYWQBXJ();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
layerOpenForeground(l_cLinkUrl,openername,'toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes');
m_nLastError=-2;
} else {
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
}
return l_bResult;
}
function Link_NNRZYWQBXJ_Blank() {
w_SOTTOVOCE='';
w_FLGRESID='';
w_FLG00015='';
w_FLG00016='';
w_FLG01217='';
w_FLG02147='';
w_FLG02148='';
w_FLG02149='';
w_xDESCRI='';
}
function LOpt_NNRZYWQBXJ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('sottovocea7','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('VOCE,SOTTOVOCE','C'));
l_oWv.setValue('LinkedField',WtA('SOTTOVOCE','C'));
l_oWv.setValue('UID',WtA('NNRZYWQBXJ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NNRZYWQBXJ'][1],'C'));
return l_oWv;
}
function Link_MDEBFTECJW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_STATO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('COD',w_STATO,3,0);
l_Appl.SetFields('COD');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tb00016');
l_Appl.SetID('MDEBFTECJW');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_STATO=l_Appl.GetStringValue('COD',3,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_MDEBFTECJW_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_MDEBFTECJW';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_MDEBFTECJW();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
layerOpenForeground(l_cLinkUrl,openername,'toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes');
m_nLastError=-2;
} else {
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
}
return l_bResult;
}
function Link_MDEBFTECJW_Blank() {
w_STATO='';
}
function LOpt_MDEBFTECJW() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tb00016','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('COD','C'));
l_oWv.setValue('LinkedField',WtA('COD','C'));
l_oWv.setValue('UID',WtA('MDEBFTECJW','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['MDEBFTECJW'][1],'C'));
return l_oWv;
}
function Link_NHFRSWSJPA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_VAL01217);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('COD',w_VAL01217,5,0);
l_Appl.SetFields('COD');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tb01217');
l_Appl.SetID('NHFRSWSJPA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_VAL01217=l_Appl.GetStringValue('COD',5,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_NHFRSWSJPA_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_NHFRSWSJPA';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_NHFRSWSJPA();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
layerOpenForeground(l_cLinkUrl,openername,'toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes');
m_nLastError=-2;
} else {
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
}
return l_bResult;
}
function Link_NHFRSWSJPA_Blank() {
w_VAL01217='';
}
function LOpt_NHFRSWSJPA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tb01217','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('COD','C'));
l_oWv.setValue('LinkedField',WtA('COD','C'));
l_oWv.setValue('UID',WtA('NHFRSWSJPA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NHFRSWSJPA'][1],'C'));
return l_oWv;
}
function Link_KYDBUIQLMM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_VAL02147);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('COD',w_VAL02147,5,0);
l_Appl.SetFields('COD');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tb02147');
l_Appl.SetID('KYDBUIQLMM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_VAL02147=l_Appl.GetStringValue('COD',5,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_KYDBUIQLMM_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_KYDBUIQLMM';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_KYDBUIQLMM();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
layerOpenForeground(l_cLinkUrl,openername,'toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes');
m_nLastError=-2;
} else {
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
}
return l_bResult;
}
function Link_KYDBUIQLMM_Blank() {
w_VAL02147='';
}
function LOpt_KYDBUIQLMM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tb02147','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('COD','C'));
l_oWv.setValue('LinkedField',WtA('COD','C'));
l_oWv.setValue('UID',WtA('KYDBUIQLMM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['KYDBUIQLMM'][1],'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'GVMMKABWWU')) {
last_focused_comp=GetLastFocusedElementOfLink('GVMMKABWWU');
function SetMethod_GVMMKABWWU() {
Set_VOCE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_GVMMKABWWU();
} else {
setTimeout(SetMethod_GVMMKABWWU,1);
}
bResult=true;
}
if (Eq(varName,'NNRZYWQBXJ')) {
last_focused_comp=GetLastFocusedElementOfLink('NNRZYWQBXJ');
function SetMethod_NNRZYWQBXJ() {
Set_SOTTOVOCE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_NNRZYWQBXJ();
} else {
setTimeout(SetMethod_NNRZYWQBXJ,1);
}
bResult=true;
}
if (Eq(varName,'MDEBFTECJW')) {
last_focused_comp=GetLastFocusedElementOfLink('MDEBFTECJW');
function SetMethod_MDEBFTECJW() {
Set_STATO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_MDEBFTECJW();
} else {
setTimeout(SetMethod_MDEBFTECJW,1);
}
bResult=true;
}
if (Eq(varName,'NHFRSWSJPA')) {
last_focused_comp=GetLastFocusedElementOfLink('NHFRSWSJPA');
function SetMethod_NHFRSWSJPA() {
Set_VAL01217(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_NHFRSWSJPA();
} else {
setTimeout(SetMethod_NHFRSWSJPA,1);
}
bResult=true;
}
if (Eq(varName,'KYDBUIQLMM')) {
last_focused_comp=GetLastFocusedElementOfLink('KYDBUIQLMM');
function SetMethod_KYDBUIQLMM() {
Set_VAL02147(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_KYDBUIQLMM();
} else {
setTimeout(SetMethod_KYDBUIQLMM,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'GVMMKABWWU')) {
return [Ctrl('GVMMKABWWU')];
}
if (Eq(varName,'NNRZYWQBXJ')) {
return [Ctrl('NNRZYWQBXJ')];
}
if (Eq(varName,'MDEBFTECJW')) {
return [Ctrl('MDEBFTECJW')];
}
if (Eq(varName,'NHFRSWSJPA')) {
return [Ctrl('NHFRSWSJPA')];
}
if (Eq(varName,'KYDBUIQLMM')) {
return [Ctrl('KYDBUIQLMM')];
}
}
function SendData(formaction,url,data) {
if (Eq(m_bAlreadySubmitted,true)) {
WindowAlert(Translate('MSG_SERVER_DATA'));
return;
}
var Frm = document.FSender;
var bResult = true;
function l_Checks() {
bResult=bResult && Check() && CheckPwdOTP();
}
if (IsWndAccessible(m_oFather)) {
if (Eq(m_nChildStatus,2)) {
m_oFather.SendData(formaction,url,data);
} else if (Eq(m_nChildStatus,1)) {
if (Eq(formaction,'save')) {
if ( ! (SaveRow())) {
return;
}
if ( ! (Check())) {
DisplayErrorMessage();
return;
}
if ( ! (m_oFather.SaveContext_ardt_dettaglioa7())) {
WindowAlert(Translate('MSG_CANNOT_UPDATE_CALLERVAR'));
return;
}
InnerChildSendData(bResult);
} else if (Eq(formaction,'moveto') && m_bUpdated) {
WindowConfirm(Translate('MSG_LEAVE_MOD'),InnerChildSendData);
} else {
InnerChildSendData(bResult);
}
function InnerChildSendData(bResult) {
if (bResult) {
if (Eq(m_cFunction,'view') || Eq(m_cFunction,'query') || Ne(m_nLastError,1)) {
m_oFather.focus();
WindowClose();
}
if (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')) {
ResetErrorVars();
}
}
}
}
} else {
if (Eq(formaction,'moveto') && m_bUpdated) {
bResult=WindowConfirm(Translate('MSG_LEAVE_MOD'));
}
if (bResult) {
if (Eq(formaction,'moveto') || (Eq(m_cFunction,'edit') &&  ! (m_bUpdated))) {
formaction='discard';
}
if (Eq(formaction,'save')) {
NotifyEvent('Before Save Row');
bResult=bResult && SaveRow(true);
if (bResult) {
NotifyEvent('Before Save');
l_Checks();
}
}
if (bResult) {
Frm.m_cSelectedPage.value=GetSelectedPage(InitWvApplet()).asString();
SubmitForm.SetAction(formaction);
SubmitForm.SetPwdAndOTP();
Frm.m_cAltInterface.value=m_cAltInterface;
Frm.m_cLayerInterface.value=m_cLayerInterface;
FillWv();
Frm.m_cWv.value=WvApplet().asString(1);
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('ardt_dettaglioa7_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('ardt_dettaglioa7_dataNotSent',{'action':formaction});
}
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('CNCQNTLDXJ_ZOOM',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('m_CheckVars',JSON.stringify(m_CheckVars));
l_oWv.setValue('ANNO',WtA(w_ANNO,'C'));
l_oWv.setValue('SEMESTRE',WtA(w_SEMESTRE,'C'));
_FillChildren(l_oWv);
if (m_bExtended) {
ExtendWv(l_oWv);
}
if (Ne(m_cFunction,'view')) {
l_oWv.setValue('m_bUpdated',WtA(m_bUpdated,'L'));
l_oWv.setValue('m_cPrvsStt',WtA(m_cPrvsStt,'C'));
}
l_oWv.setValue('m_bLoaded',WtA(m_bLoaded,'L'));
l_oWv.setValue('m_cOldCPCCCHK',WtA(m_cOldCPCCCHK,'C'));
if (Ne(m_cFunction,'view')) {
l_oWv.setValue('m_bHeaderUpdated',WtA(m_bHeaderUpdated,'L'));
l_oWv.setValue('m_oTrs',TrsApplet().asString());
}
}
_FillChildren.n=[];
FillWv.n=["ANNO","SEMESTRE"];
function CheckRow(w) {
var l_bResult = true;
ResetErrorVars();
if (Le(m_nCurrentRow,Rows())) {
if (( ! (_ChkObl('GVMMKABWWU',1))) && FullRow()) {
_SignErr('GVMMKABWWU');
m_cLastWorkVarErrorMsg='440902';
l_bResult=false;
w_VOCE=HtW('','C');
} else if (( ! (_ChkObl('NNRZYWQBXJ',1))) && FullRow()) {
_SignErr('NNRZYWQBXJ');
m_cLastWorkVarErrorMsg='11495876696';
l_bResult=false;
w_SOTTOVOCE=HtW('','C');
} else if (((Eq(w_FLGRESID,'S')) && ( ! (_ChkObl('MVCFXMIIPY',1)))) && FullRow()) {
_SignErr('MVCFXMIIPY');
m_cLastWorkVarErrorMsg='347802115';
l_bResult=false;
w_RESID=HtW('','C');
} else if (((Eq(w_FLG00015,'S')) && ( ! (_ChkObl('SNYJQPAYYR',1)))) && FullRow()) {
_SignErr('SNYJQPAYYR');
m_cLastWorkVarErrorMsg='10095365423';
l_bResult=false;
w_PROVINCIA=HtW('','C');
} else if (((Eq(w_FLG00016,'S')) && ( ! (_ChkObl('MDEBFTECJW',1)))) && FullRow()) {
_SignErr('MDEBFTECJW');
m_cLastWorkVarErrorMsg='7776403';
l_bResult=false;
w_STATO=HtW('','C');
} else if (((Eq(w_FLG01217,'S')) && ( ! (_ChkObl('NHFRSWSJPA',1)))) && FullRow()) {
_SignErr('NHFRSWSJPA');
m_cLastWorkVarErrorMsg='11602249308';
l_bResult=false;
w_VAL01217=HtW('','C');
} else if (((Eq(w_FLG02147,'S')) && ( ! (_ChkObl('KYDBUIQLMM',1)))) && FullRow()) {
_SignErr('KYDBUIQLMM');
m_cLastWorkVarErrorMsg='10262589875';
l_bResult=false;
w_VAL02147=HtW('','C');
} else if (((Eq(w_FLG02148,'S')) && ( ! (_ChkObl('CNCQNTLDXJ',1)))) && FullRow()) {
_SignErr('CNCQNTLDXJ');
m_cLastWorkVarErrorMsg='10789175827';
l_bResult=false;
w_VAL02148=HtW('','D');
} else if (((Eq(w_FLG02149,'S')) && ( ! (_ChkObl('PDCPOALMKJ',1)))) && FullRow()) {
_SignErr('PDCPOALMKJ');
m_cLastWorkVarErrorMsg='237553103';
l_bResult=false;
w_VAL02149=HtW('','C');
} else if (( ! (_ChkObl('OWRKSPYBFW',1))) && FullRow()) {
_SignErr('OWRKSPYBFW');
m_cLastWorkVarErrorMsg='1847733175';
l_bResult=false;
w_IMPORTO=HtW('','N');
}
}
if (FullRow()) {
if (l_bResult) {
l_bResult=CheckChild(1);
}
}
DisableChainedLinks(true);
// * --- Area Manuale = UI - Check Row
// * --- Fine Area Manuale
return l_bResult;
}
function CheckDeleteRow() {
var l_bResult = true;
ResetErrorVars();
return l_bResult;
}
function SetModified(bRepeated) {
m_bUpdated=true;
if (bRepeated) {
if (Le(m_nCurrentRow,m_oTrs.length) && Eq(m_nRowStatus,0)) {
m_nRowStatus=1;
}
} else {
m_bHeaderUpdated=true;
}
if (IsWndAccessible(m_oFather)) {
m_oFather.SetModified_ardt_dettaglioa7();
}
}
SaveContext.child=[];
function BlankRow() {
w_VOCE='';
w_SOTTOVOCE='';
w_RESID='';
w_PROVINCIA='';
w_STATO='';
w_VAL01217='';
w_VAL02147='';
w_VAL02148=NullDate();
w_VAL02149='';
w_DATAEFF=NullDate();
w_IMPORTO=0;
w_IDBASEA7='';
w_FLGRESID='';
w_FLG00015='';
w_FLG00016='';
w_FLG01217='';
w_FLG02147='';
w_FLG02148='';
w_FLG02149='';
w_xDESCRI='';
w_xDESVOCE='';
if ( ! (EmptyString(w_VOCE))) {
Link_GVMMKABWWU(null);
}
if ( ! (EmptyString(w_SOTTOVOCE))) {
Link_NNRZYWQBXJ(null);
}
w_RESID='1';
if ( ! (EmptyString(w_STATO))) {
Link_MDEBFTECJW(null);
}
if ( ! (EmptyString(w_VAL01217))) {
Link_NHFRSWSJPA(null);
}
if ( ! (EmptyString(w_VAL02147))) {
Link_KYDBUIQLMM(null);
}
BlankRowChild();
if (m_bExtended) {
BlankRepeatedExtendedFields();
}
SaveDependsOn();
LoadContext(true);
}
function FullRow() {
return  ! (Empty(w_VOCE));
}
function GetRepeatedFields() {
var l_aRepeatedFields;
l_aRepeatedFields={};
l_aRepeatedFields.VOCE={"dec":0,"fixedpos":false,"id":"GVMMKABWWU","len":5,"name":"VOCE","title":"Voce","type":"C"};
l_aRepeatedFields.SOTTOVOCE={"dec":0,"fixedpos":false,"id":"NNRZYWQBXJ","len":2,"name":"SOTTOVOCE","title":"Sottovoce","type":"C"};
l_aRepeatedFields.RESID={"dec":0,"fixedpos":true,"id":"MVCFXMIIPY","len":1,"name":"RESID","title":"Residenza","type":"C"};
l_aRepeatedFields.PROVINCIA={"dec":0,"fixedpos":true,"id":"SNYJQPAYYR","len":5,"name":"PROVINCIA","title":"Provincia","type":"C"};
l_aRepeatedFields.STATO={"dec":0,"fixedpos":true,"id":"MDEBFTECJW","len":3,"name":"STATO","title":"Stato","type":"C"};
l_aRepeatedFields.VAL01217={"dec":0,"fixedpos":true,"id":"NHFRSWSJPA","len":5,"name":"VAL01217","title":"Oggetto dei reclami","type":"C"};
l_aRepeatedFields.VAL02147={"dec":0,"fixedpos":true,"id":"KYDBUIQLMM","len":5,"name":"VAL02147","title":"Tipo Restituzione","type":"C"};
l_aRepeatedFields.VAL02148={"dec":0,"fixedpos":true,"id":"CNCQNTLDXJ","len":8,"name":"VAL02148","title":"Data Efficacia","type":"D"};
l_aRepeatedFields.VAL02149={"dec":0,"fixedpos":true,"id":"PDCPOALMKJ","len":6,"name":"VAL02149","title":"Progressivo Manovra","type":"C"};
l_aRepeatedFields.DATAEFF={"dec":0,"fixedpos":true,"id":"EBYJTCWSYH","len":8,"name":"DATAEFF","title":"Data Effettuazione","type":"D"};
l_aRepeatedFields.IMPORTO={"dec":2,"fixedpos":true,"id":"OWRKSPYBFW","len":15,"name":"IMPORTO","title":"Importo\/Numero","type":"N"};
l_aRepeatedFields.IDBASEA7={"dec":0,"fixedpos":true,"id":"WYXXYYPRMA","len":10,"name":"IDBASEA7","title":"IDBASE RIga","type":"C"};
l_aRepeatedFields.FLGRESID={"dec":0,"fixedpos":true,"id":"RKVIQJIUUC","len":1,"name":"FLGRESID","title":"Flag Residenza","type":"C"};
l_aRepeatedFields.FLG00015={"dec":0,"fixedpos":true,"id":"KPPNJPEWGY","len":1,"name":"FLG00015","title":"Attiva Provincia","type":"C"};
l_aRepeatedFields.FLG00016={"dec":0,"fixedpos":true,"id":"OLOBKCQZKB","len":1,"name":"FLG00016","title":"Attiva Stato","type":"C"};
l_aRepeatedFields.FLG01217={"dec":0,"fixedpos":true,"id":"WGKFAZLRNL","len":1,"name":"FLG01217","title":"Attiva Tab 1217","type":"C"};
l_aRepeatedFields.FLG02147={"dec":0,"fixedpos":true,"id":"ZNTVDOOVME","len":1,"name":"FLG02147","title":"Attiva Tab 2147","type":"C"};
l_aRepeatedFields.FLG02148={"dec":0,"fixedpos":true,"id":"MBIRPICILO","len":1,"name":"FLG02148","title":"Attiva Tab 2148","type":"C"};
l_aRepeatedFields.FLG02149={"dec":0,"fixedpos":true,"id":"BGBJHESPEE","len":1,"name":"FLG02149","title":"Attiva Tab 2149","type":"C"};
l_aRepeatedFields.xDESCRI={"dec":0,"fixedpos":true,"id":"MCRGXGXEDE","len":160,"name":"xDESCRI","title":"Descrizione","type":"C"};
l_aRepeatedFields.xDESVOCE={"dec":0,"fixedpos":true,"id":"IWKXQEWQOX","len":160,"name":"xDESVOCE","title":"Descrizione","type":"C"};
return l_aRepeatedFields;
}
function SubtractTotals() {
}
function hasDepOnTotals() {
}
function DisableChainedLinks(disable) {
}
function EnableEntityWhenReady(enable) {
if (enable) {
var c;
if(c=Ctrl('MVCFXMIIPY')) SetDisabled(c,true);
if(c=Ctrl('SNYJQPAYYR')) SetDisabled(c,true);
if(c=Ctrl('MDEBFTECJW')) SetDisabled(c,true);
if(c=Ctrl('NHFRSWSJPA')) SetDisabled(c,true);
if(c=Ctrl('KYDBUIQLMM')) SetDisabled(c,true);
if(c=Ctrl('CNCQNTLDXJ')) SetDisabled(c,true);
if(c=Ctrl('CNCQNTLDXJ_ZOOM')) SetDisabled(c,true);
if(c=Ctrl('PDCPOALMKJ')) SetDisabled(c,true);
if(c=Ctrl('OWRKSPYBFW')) SetDisabled(c,true);
SetQueryRow(Ctrl('GridTable'),false);
} else {
SetEditRow(Ctrl('GridTable'),false);
var c;
if(c=Ctrl('MVCFXMIIPY')) SetDisabled(c,false);
if(c=Ctrl('SNYJQPAYYR')) SetDisabled(c,false);
if(c=Ctrl('MDEBFTECJW')) SetDisabled(c,false);
if(c=Ctrl('NHFRSWSJPA')) SetDisabled(c,false);
if(c=Ctrl('KYDBUIQLMM')) SetDisabled(c,false);
if(c=Ctrl('CNCQNTLDXJ')) SetDisabled(c,false);
if(c=Ctrl('CNCQNTLDXJ_ZOOM')) SetDisabled(c,false);
if(c=Ctrl('PDCPOALMKJ')) SetDisabled(c,false);
if(c=Ctrl('OWRKSPYBFW')) SetDisabled(c,false);
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
