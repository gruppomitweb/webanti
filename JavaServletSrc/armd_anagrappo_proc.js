function FillCombosValues() {
FillCombo('GGLQTNYWZF','GGLQTNYWZF');
FillCombo('AKLWIUMNVR','AKLWIUMNVR');
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
SPBOUILib.SetInputValue('UOVJKJLZBV',function(){return WtH(w_RAPPORTO,'C',25,0,'')},w_RAPPORTO);
if(c=Ctrl('GGLQTNYWZF')) selectCombo(c,w_TIPOAG,'C')
if(c=Ctrl('BLOIDAPXRQ')) selectCombo(c,w_COINT,'C')
SPBOUILib.SetInputValue('LTLFYOYQAO',function(){return WtH(w_UNIQUECODE,'C',50,0,'')},w_UNIQUECODE);
SPBOUILib.SetInputValue('CODMGYDXYT',function(){return WtH(w_CAB,'C',5,0,'')},w_CAB);
if(c=Ctrl('AKLWIUMNVR')) selectCombo(c,w_VALUTA,'C')
if(c=Ctrl('VKTPGVCBJR')) ChkboxCheckUncheck(c,1,w_ASPEDITO)
if(c=Ctrl('VKTPGVCBJR')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('SQFHVLZLRL',function(){return WtH(w_APROG,'C',25,0,'')},w_APROG);
SPBOUILib.SetInputValue('CCYVNDNRFK',function(){return WtH(w_AFILE,'C',15,0,'')},w_AFILE);
if(c=Ctrl('GZYOVGKBQU')) ChkboxCheckUncheck(c,1,w_CSPEDITO)
if(c=Ctrl('GZYOVGKBQU')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('RPTFBMPRFK',function(){return WtH(w_CPROG,'C',25,0,'')},w_CPROG);
SPBOUILib.SetInputValue('GEAGHOYNJV',function(){return WtH(w_CFILE,'C',15,0,'')},w_CFILE);
SPBOUILib.SetInputValue('KGVKWENSDZ',function(){return WtH(w_ADATA,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_ADATA);
SPBOUILib.SetInputValue('UJYQWLUHMX',function(){return WtH(w_CDATA,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_CDATA);
SPBOUILib.SetInputValue('IANSHYURPV',function(){return WtH(w_IDESITO,'C',8,0,'')},w_IDESITO);
SPBOUILib.SetInputValue('LJUMSXSYFZ',function(){return WtH(w_ADATARET,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_ADATARET);
if(c=Ctrl('ZEWCJCWNSV')) ChkboxCheckUncheck(c,1,w_RSPEDITO)
if(c=Ctrl('ZEWCJCWNSV')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('YYRSSVEWOX',function(){return WtH(w_COLDFILE,'C',15,0,'')},w_COLDFILE);
SPBOUILib.SetInputValue('FDSYVBCPAC',function(){return WtH(w_COLDPROG,'C',25,0,'')},w_COLDPROG);
SPBOUILib.SetInputValue('CGGFGFHNLQ',function(){return WtH(w_dtcanc,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_dtcanc);
if(c=Ctrl('PULJPVPYAY')) ChkboxCheckUncheck(c,1,w_spcanc)
if(c=Ctrl('PULJPVPYAY')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('CPXILLMFYQ',function(){return WtH(w_filecanc,'C',15,0,'')},w_filecanc);
SPBOUILib.SetInputValue('MQSDKNMJUI',function(){return WtH(w_idcanc,'C',25,0,'')},w_idcanc);
SPBOUILib.SetInputValue('YJETHTLSAS',function(){return WtH(w_DATESITO,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATESITO);
} else {
SPBOUILib.SetInputValue('UOVJKJLZBV',function(){return WtH(w_RAPPORTO,'C',25,0,'')},w_RAPPORTO);
if(c=Ctrl('GGLQTNYWZF')) selectCombo(c,w_TIPOAG,'C')
if(c=Ctrl('BLOIDAPXRQ')) selectCombo(c,w_COINT,'C')
SPBOUILib.SetInputValue('ZWBKZJLHCV',function(){return WtH(w_CONNESINT,'C',16,0,'')},w_CONNESINT);
if(c=Ctrl('VKTPGVCBJR')) ChkboxCheckUncheck(c,1,w_ASPEDITO)
if(c=Ctrl('VKTPGVCBJR')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('ZYSXZRLIHG',function(){return WtH(w_ADATA,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_ADATA);
SPBOUILib.SetInputValue('SQFHVLZLRL',function(){return WtH(w_APROG,'C',25,0,'')},w_APROG);
SPBOUILib.SetInputValue('CCYVNDNRFK',function(){return WtH(w_AFILE,'C',15,0,'')},w_AFILE);
if(c=Ctrl('GZYOVGKBQU')) ChkboxCheckUncheck(c,1,w_CSPEDITO)
if(c=Ctrl('GZYOVGKBQU')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('YQJXLYYDEK',function(){return WtH(w_CDATA,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_CDATA);
SPBOUILib.SetInputValue('RPTFBMPRFK',function(){return WtH(w_CPROG,'C',25,0,'')},w_CPROG);
SPBOUILib.SetInputValue('GEAGHOYNJV',function(){return WtH(w_CFILE,'C',15,0,'')},w_CFILE);
SPBOUILib.SetInputValue('VCSXGLJKMU',function(){return WtH(w_xragsoc,'C',70,0,'')},w_xragsoc);
SPBOUILib.SetInputValue('KGVKWENSDZ',function(){return WtH(w_ADATA,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_ADATA);
SPBOUILib.SetInputValue('UJYQWLUHMX',function(){return WtH(w_CDATA,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_CDATA);
SPBOUILib.SetInputValue('IANSHYURPV',function(){return WtH(w_IDESITO,'C',8,0,'')},w_IDESITO);
SPBOUILib.SetInputValue('LJUMSXSYFZ',function(){return WtH(w_ADATARET,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_ADATARET);
if(c=Ctrl('ZEWCJCWNSV')) ChkboxCheckUncheck(c,1,w_RSPEDITO)
if(c=Ctrl('ZEWCJCWNSV')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('YYRSSVEWOX',function(){return WtH(w_COLDFILE,'C',15,0,'')},w_COLDFILE);
SPBOUILib.SetInputValue('FDSYVBCPAC',function(){return WtH(w_COLDPROG,'C',25,0,'')},w_COLDPROG);
SPBOUILib.SetInputValue('CGGFGFHNLQ',function(){return WtH(w_dtcanc,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_dtcanc);
if(c=Ctrl('PULJPVPYAY')) ChkboxCheckUncheck(c,1,w_spcanc)
if(c=Ctrl('PULJPVPYAY')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('CPXILLMFYQ',function(){return WtH(w_filecanc,'C',15,0,'')},w_filecanc);
SPBOUILib.SetInputValue('MQSDKNMJUI',function(){return WtH(w_idcanc,'C',25,0,'')},w_idcanc);
SPBOUILib.SetInputValue('YJETHTLSAS',function(){return WtH(w_DATESITO,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATESITO);
SPBOUILib.SetInputValue('LTLFYOYQAO',function(){return WtH(w_UNIQUECODE,'C',50,0,'')},w_UNIQUECODE);
SPBOUILib.SetInputValue('CODMGYDXYT',function(){return WtH(w_CAB,'C',5,0,'')},w_CAB);
if(c=Ctrl('AKLWIUMNVR')) selectCombo(c,w_VALUTA,'C')
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
SetDisplay('XDYFKZMJHC_DIV',IsHiddenByStateDriver('box_XDYFKZMJHC'));
SetDisplay('KLSWWEOHOR_DIV',IsHiddenByStateDriver('box_KLSWWEOHOR'));
SetDisplay('BJDGPHQYFI_DIV',IsHiddenByStateDriver('box_BJDGPHQYFI'));
SetDisplay(Ctrl('GCHWZOBGPB'),Empty(w_RAPPORTO) || Eq(w_ASPEDITO,0) ||  ! (arfn_ae_chkdel(w_IDBASE,'R')));
SetDisplay(Ctrl('NALNSNTYAI'),Empty(w_RAPPORTO) || Eq(w_ASPEDITO,0) ||  ! (arfn_ae_chkdel(w_IDBASE,'R')));
SetDisplay('WNPHGDFVJX_DIV',IsHiddenByStateDriver('box_WNPHGDFVJX'));
SetDisplay('RANZSHNOJF_DIV',IsHiddenByStateDriver('box_RANZSHNOJF'));
SetDisplay(Ctrl('UDPOLEMYNZ'),Empty(w_dtcanc));
SetDisplay(Ctrl('RHOMZTFXOQ'),Empty(w_ADATARET) || ( ! (Empty(w_ADATARET)) && Eq(w_RSPEDITO,1)));
SetDisplay('UBHZWYZYEF_DIV',IsHiddenByStateDriver('box_UBHZWYZYEF'));
SetDisplay('TGJYPNQVEJ_DIV',IsHiddenByStateDriver('box_TGJYPNQVEJ'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["CAB"]=['FRUUOBVPDA'];
HideUI.lblids["COINT"]=['UGCBYIEUDJ'];
HideUI.lblids["DATESITO"]=['JUCNEACWKX'];
HideUI.lblids["IDESITO"]=['MMLVTODRRS'];
HideUI.lblids["RAPPORTO"]=['UBDRZPYJRT'];
HideUI.lblids["TIPOAG"]=['VVKODWZEWZ'];
HideUI.lblids["UNIQUECODE"]=['JXLGEAUZTQ'];
HideUI.lblids["VALUTA"]=['KSMLUMFLML'];
function UOVJKJLZBV_Valid(e) {
SetActiveField(Ctrl('UOVJKJLZBV'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('UOVJKJLZBV') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('RAPPORTO','C',w_RAPPORTO,HtW(Ctrl('UOVJKJLZBV').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAPPORTO(HtW(Ctrl('UOVJKJLZBV').value,'C'),null,e);
return l_bSetResult;
}
}
function UOVJKJLZBV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UOVJKJLZBV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UOVJKJLZBV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UOVJKJLZBV'),e);
}
function GGLQTNYWZF_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOAG','C',w_TIPOAG,HtW(getComboValue(Ctrl('GGLQTNYWZF')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOAG(HtW(getComboValue(Ctrl('GGLQTNYWZF')),'C'),null,e);
return l_bSetResult;
}
}
function GGLQTNYWZF_OnFocus(e) {
SetActiveField(Ctrl('GGLQTNYWZF'),true);
}
function GGLQTNYWZF_OnBlur(e) {
SetActiveField(Ctrl('GGLQTNYWZF'),false);
}
function BLOIDAPXRQ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('COINT','C',w_COINT,HtW(getComboValue(Ctrl('BLOIDAPXRQ')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_COINT(HtW(getComboValue(Ctrl('BLOIDAPXRQ')),'C'),null,e);
return l_bSetResult;
}
}
function BLOIDAPXRQ_OnFocus(e) {
SetActiveField(Ctrl('BLOIDAPXRQ'),true);
}
function BLOIDAPXRQ_OnBlur(e) {
SetActiveField(Ctrl('BLOIDAPXRQ'),false);
}
function GCHWZOBGPB_Click() {
var l_oWv = InitWvApplet();
l_oWv.setValue('olddata',AsAppletValue(w_ADATA));
l_oWv.setValue('olddatac',AsAppletValue(w_CDATA));
l_oWv.setValue('oldfile',AsAppletValue(w_AFILE));
l_oWv.setValue('oldidbase',AsAppletValue(w_IDBASE));
l_oWv.setValue('oldintest',AsAppletValue(w_CONNESINT));
l_oWv.setValue('oldnumrig',AsAppletValue(w_CPROWNUM));
l_oWv.setValue('oldprog',AsAppletValue(w_APROG));
l_oWv.setValue('oldrappo',AsAppletValue(w_RAPPORTO));
l_oWv.setValue('newdate',AsAppletValue(w_ADATA));
l_oWv.setValue('newintest',AsAppletValue(w_CONNESINT));
l_oWv.setValue('newdatec',AsAppletValue(w_CDATA));
l_oWv.setValue('xragnew',AsAppletValue(w_xragsoc));
l_oWv.setValue('xragold',AsAppletValue(w_xragsoc));
l_oWv.setValue('idesito',AsAppletValue(w_IDESITO));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('olddata,olddatac,oldfile,oldidbase,oldintest,oldnumrig,oldprog,oldrappo,newdate,newintest,newdatec,xragnew,xragold,idesito'));
if ( ! (Empty(w_RAPPORTO)) && Eq(w_ASPEDITO,1) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'edit'))) {
if (false || WindowConfirm(Translate('1560126028'))) {
_modifyandopen('arpg_modopen1'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=550,width=675',false)
}
}
}
function NALNSNTYAI_Click() {
var l_oWv = InitWvApplet();
l_oWv.setValue('oldfile',AsAppletValue(w_CFILE));
l_oWv.setValue('oldidbase',AsAppletValue(w_IDBASE));
l_oWv.setValue('oldprog',AsAppletValue(w_CPROG));
l_oWv.setValue('oldrappo',AsAppletValue(w_RAPPORTO));
l_oWv.setValue('oldrnumrig',AsAppletValue(w_CPROWNUM));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('oldfile,oldidbase,oldprog,oldrappo,oldrnumrig'));
if ( ! (Empty(w_RAPPORTO)) && Eq(w_ASPEDITO,1) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'edit'))) {
if (false || WindowConfirm(Translate('1560126028'))) {
_modifyandopen('arpg_modclose2'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=550,width=675',false)
}
}
}
function HWWOJAYWAI_Click() {
var l_oWv = InitWvApplet();
l_oWv.setValue('CONNES',AsAppletValue(w_CONNESINT));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('CONNES'));
_modifyandopen('arpg_edt_personbo'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',false)
}
function RHOMZTFXOQ_Click() {
if (Eq(m_cFunction,'view')) {
if (false || WindowConfirm(Translate('11741368204'))) {
arrt_delret_aerighe([["w_ADATARET",w_ADATARET],["w_IDBASE",w_IDBASE],["w_RAPPORTO",w_RAPPORTO]])
}
}
}
function ZWBKZJLHCV_Valid(e) {
SetActiveField(Ctrl('ZWBKZJLHCV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CONNESINT','C',w_CONNESINT,HtW(Ctrl('ZWBKZJLHCV').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONNESINT(HtW(Ctrl('ZWBKZJLHCV').value,'C'),null,e);
return l_bSetResult;
}
}
function ZWBKZJLHCV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZWBKZJLHCV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZWBKZJLHCV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZWBKZJLHCV'),e);
}
function ZWBKZJLHCV_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('ZWBKZJLHCV')),'linkview_ZWBKZJLHCV','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function VKTPGVCBJR_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('ASPEDITO','N',w_ASPEDITO,ChkboxValueAssign(Ctrl('VKTPGVCBJR'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ASPEDITO(ChkboxValueAssign(Ctrl('VKTPGVCBJR'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function VKTPGVCBJR_OnFocus(e) {
SetActiveField(Ctrl('VKTPGVCBJR'),true);
}
function VKTPGVCBJR_OnBlur(e) {
SetActiveField(Ctrl('VKTPGVCBJR'),false);
}
function ZYSXZRLIHG_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('ZYSXZRLIHG'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('ZYSXZRLIHG').value=ApplyPictureToDate(Ctrl('ZYSXZRLIHG').value,TranslatePicture(datePattern),'ZYSXZRLIHG');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('ZYSXZRLIHG'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('ZYSXZRLIHG');
}
}
}
SetActiveField(Ctrl('ZYSXZRLIHG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ADATA','D',w_ADATA,HtW(Ctrl('ZYSXZRLIHG').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ADATA(HtW(Ctrl('ZYSXZRLIHG').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function ZYSXZRLIHG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZYSXZRLIHG'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('ZYSXZRLIHG',w_ADATA,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('ZYSXZRLIHG');
SetActiveField(Ctrl('ZYSXZRLIHG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZYSXZRLIHG'),e);
}
function SQFHVLZLRL_Valid(e) {
SetActiveField(Ctrl('SQFHVLZLRL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('APROG','C',w_APROG,HtW(Ctrl('SQFHVLZLRL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_APROG(HtW(Ctrl('SQFHVLZLRL').value,'C'),null,e);
return l_bSetResult;
}
}
function SQFHVLZLRL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SQFHVLZLRL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SQFHVLZLRL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SQFHVLZLRL'),e);
}
function CCYVNDNRFK_Valid(e) {
SetActiveField(Ctrl('CCYVNDNRFK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('AFILE','C',w_AFILE,HtW(Ctrl('CCYVNDNRFK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_AFILE(HtW(Ctrl('CCYVNDNRFK').value,'C'),null,e);
return l_bSetResult;
}
}
function CCYVNDNRFK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CCYVNDNRFK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CCYVNDNRFK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CCYVNDNRFK'),e);
}
function GZYOVGKBQU_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('CSPEDITO','N',w_CSPEDITO,ChkboxValueAssign(Ctrl('GZYOVGKBQU'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CSPEDITO(ChkboxValueAssign(Ctrl('GZYOVGKBQU'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function GZYOVGKBQU_OnFocus(e) {
SetActiveField(Ctrl('GZYOVGKBQU'),true);
}
function GZYOVGKBQU_OnBlur(e) {
SetActiveField(Ctrl('GZYOVGKBQU'),false);
}
function YQJXLYYDEK_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('YQJXLYYDEK'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('YQJXLYYDEK').value=ApplyPictureToDate(Ctrl('YQJXLYYDEK').value,TranslatePicture(datePattern),'YQJXLYYDEK');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('YQJXLYYDEK'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('YQJXLYYDEK');
}
}
}
SetActiveField(Ctrl('YQJXLYYDEK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CDATA','D',w_CDATA,HtW(Ctrl('YQJXLYYDEK').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CDATA(HtW(Ctrl('YQJXLYYDEK').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function YQJXLYYDEK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YQJXLYYDEK'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('YQJXLYYDEK',w_CDATA,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('YQJXLYYDEK');
SetActiveField(Ctrl('YQJXLYYDEK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YQJXLYYDEK'),e);
}
function RPTFBMPRFK_Valid(e) {
SetActiveField(Ctrl('RPTFBMPRFK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CPROG','C',w_CPROG,HtW(Ctrl('RPTFBMPRFK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CPROG(HtW(Ctrl('RPTFBMPRFK').value,'C'),null,e);
return l_bSetResult;
}
}
function RPTFBMPRFK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RPTFBMPRFK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RPTFBMPRFK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RPTFBMPRFK'),e);
}
function GEAGHOYNJV_Valid(e) {
SetActiveField(Ctrl('GEAGHOYNJV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CFILE','C',w_CFILE,HtW(Ctrl('GEAGHOYNJV').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CFILE(HtW(Ctrl('GEAGHOYNJV').value,'C'),null,e);
return l_bSetResult;
}
}
function GEAGHOYNJV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GEAGHOYNJV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GEAGHOYNJV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GEAGHOYNJV'),e);
}
function KGVKWENSDZ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('KGVKWENSDZ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('KGVKWENSDZ').value=ApplyPictureToDate(Ctrl('KGVKWENSDZ').value,TranslatePicture(datePattern),'KGVKWENSDZ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('KGVKWENSDZ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('KGVKWENSDZ');
}
}
}
SetActiveField(Ctrl('KGVKWENSDZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ADATA','D',w_ADATA,HtW(Ctrl('KGVKWENSDZ').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ADATA(HtW(Ctrl('KGVKWENSDZ').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function KGVKWENSDZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KGVKWENSDZ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('KGVKWENSDZ',w_ADATA,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('KGVKWENSDZ');
SetActiveField(Ctrl('KGVKWENSDZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KGVKWENSDZ'),e);
}
function UJYQWLUHMX_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('UJYQWLUHMX'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('UJYQWLUHMX').value=ApplyPictureToDate(Ctrl('UJYQWLUHMX').value,TranslatePicture(datePattern),'UJYQWLUHMX');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('UJYQWLUHMX'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('UJYQWLUHMX');
}
}
}
SetActiveField(Ctrl('UJYQWLUHMX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CDATA','D',w_CDATA,HtW(Ctrl('UJYQWLUHMX').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CDATA(HtW(Ctrl('UJYQWLUHMX').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function UJYQWLUHMX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UJYQWLUHMX'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('UJYQWLUHMX',w_CDATA,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('UJYQWLUHMX');
SetActiveField(Ctrl('UJYQWLUHMX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UJYQWLUHMX'),e);
}
function LJUMSXSYFZ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('LJUMSXSYFZ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('LJUMSXSYFZ').value=ApplyPictureToDate(Ctrl('LJUMSXSYFZ').value,TranslatePicture(datePattern),'LJUMSXSYFZ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('LJUMSXSYFZ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('LJUMSXSYFZ');
}
}
}
SetActiveField(Ctrl('LJUMSXSYFZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ADATARET','D',w_ADATARET,HtW(Ctrl('LJUMSXSYFZ').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ADATARET(HtW(Ctrl('LJUMSXSYFZ').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function LJUMSXSYFZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LJUMSXSYFZ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('LJUMSXSYFZ',w_ADATARET,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('LJUMSXSYFZ');
SetActiveField(Ctrl('LJUMSXSYFZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LJUMSXSYFZ'),e);
}
function ZEWCJCWNSV_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('RSPEDITO','N',w_RSPEDITO,ChkboxValueAssign(Ctrl('ZEWCJCWNSV'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RSPEDITO(ChkboxValueAssign(Ctrl('ZEWCJCWNSV'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function ZEWCJCWNSV_OnFocus(e) {
SetActiveField(Ctrl('ZEWCJCWNSV'),true);
}
function ZEWCJCWNSV_OnBlur(e) {
SetActiveField(Ctrl('ZEWCJCWNSV'),false);
}
function YYRSSVEWOX_Valid(e) {
SetActiveField(Ctrl('YYRSSVEWOX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('COLDFILE','C',w_COLDFILE,HtW(Ctrl('YYRSSVEWOX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_COLDFILE(HtW(Ctrl('YYRSSVEWOX').value,'C'),null,e);
return l_bSetResult;
}
}
function YYRSSVEWOX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YYRSSVEWOX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YYRSSVEWOX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YYRSSVEWOX'),e);
}
function FDSYVBCPAC_Valid(e) {
SetActiveField(Ctrl('FDSYVBCPAC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('COLDPROG','C',w_COLDPROG,HtW(Ctrl('FDSYVBCPAC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_COLDPROG(HtW(Ctrl('FDSYVBCPAC').value,'C'),null,e);
return l_bSetResult;
}
}
function FDSYVBCPAC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FDSYVBCPAC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FDSYVBCPAC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FDSYVBCPAC'),e);
}
function CODMGYDXYT_Valid(e) {
SetActiveField(Ctrl('CODMGYDXYT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CAB','C',w_CAB,HtW(Ctrl('CODMGYDXYT').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAB(HtW(Ctrl('CODMGYDXYT').value,'C'),null,e);
return l_bSetResult;
}
}
function CODMGYDXYT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CODMGYDXYT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CODMGYDXYT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CODMGYDXYT'),e);
}
function AKLWIUMNVR_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VALUTA','C',w_VALUTA,HtW(getComboValue(Ctrl('AKLWIUMNVR')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VALUTA(HtW(getComboValue(Ctrl('AKLWIUMNVR')),'C'),null,e);
return l_bSetResult;
}
}
function AKLWIUMNVR_OnFocus(e) {
SetActiveField(Ctrl('AKLWIUMNVR'),true);
}
function AKLWIUMNVR_OnBlur(e) {
SetActiveField(Ctrl('AKLWIUMNVR'),false);
}
linkpc_url.u('KGHSUPPYWT',function(){return 'ardt_ae_saldianno_rap?m_bInnerChild=true'+GetLinkPCKeys('ardt_ae_saldianno_rap')+'&m_bRowsChild='+EnableChild('ardt_ae_saldianno_rap')})
_ResetTracker();
function setEventHandlers() {
var c;
function GCHWZOBGPB_wrap_OnClick(event) {
return GCHWZOBGPB_Click();
}
SPBOUILib.SetButtonClick('GCHWZOBGPB',GCHWZOBGPB_wrap_OnClick);
function NALNSNTYAI_wrap_OnClick(event) {
return NALNSNTYAI_Click();
}
SPBOUILib.SetButtonClick('NALNSNTYAI',NALNSNTYAI_wrap_OnClick);
function HWWOJAYWAI_wrap_OnClick(event) {
return HWWOJAYWAI_Click();
}
SPBOUILib.SetButtonClick('HWWOJAYWAI',HWWOJAYWAI_wrap_OnClick);
function RHOMZTFXOQ_wrap_OnClick(event) {
return RHOMZTFXOQ_Click();
}
SPBOUILib.SetButtonClick('RHOMZTFXOQ',RHOMZTFXOQ_wrap_OnClick);
if (Ne(m_cFunction,'view')) {
function UOVJKJLZBV_wrap_Valid(event) {
return UOVJKJLZBV_Valid(event);
}
SPBOUILib.SetInputExit('UOVJKJLZBV',UOVJKJLZBV_wrap_Valid);
function UOVJKJLZBV_wrap_OnFocus(event) {
return UOVJKJLZBV_OnFocus(event);
}
SPBOUILib.SetInputEnter('UOVJKJLZBV',UOVJKJLZBV_wrap_OnFocus);
function UOVJKJLZBV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UOVJKJLZBV',UOVJKJLZBV_wrap_OnKeyDown);
function GGLQTNYWZF_wrap_Valid(event) {
return GGLQTNYWZF_Valid(event);
}
SPBOUILib.SetComboChange('GGLQTNYWZF',GGLQTNYWZF_wrap_Valid);
function GGLQTNYWZF_wrap_OnFocus(event) {
return GGLQTNYWZF_OnFocus(event);
}
SPBOUILib.SetInputEnter('GGLQTNYWZF',GGLQTNYWZF_wrap_OnFocus);
function GGLQTNYWZF_wrap_Blur(event) {
return GGLQTNYWZF_OnBlur(event);
}
SPBOUILib.SetInputExit('GGLQTNYWZF',GGLQTNYWZF_wrap_Blur);
function BLOIDAPXRQ_wrap_Valid(event) {
return BLOIDAPXRQ_Valid(event);
}
SPBOUILib.SetComboChange('BLOIDAPXRQ',BLOIDAPXRQ_wrap_Valid);
function BLOIDAPXRQ_wrap_OnFocus(event) {
return BLOIDAPXRQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('BLOIDAPXRQ',BLOIDAPXRQ_wrap_OnFocus);
function BLOIDAPXRQ_wrap_Blur(event) {
return BLOIDAPXRQ_OnBlur(event);
}
SPBOUILib.SetInputExit('BLOIDAPXRQ',BLOIDAPXRQ_wrap_Blur);
function ZWBKZJLHCV_wrap_Valid(event) {
return ZWBKZJLHCV_Valid(event);
}
SPBOUILib.SetInputExit('ZWBKZJLHCV',ZWBKZJLHCV_wrap_Valid,SPBOUILib.Row.IN_GRID);
function ZWBKZJLHCV_wrap_OnFocus(event) {
return ZWBKZJLHCV_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZWBKZJLHCV',ZWBKZJLHCV_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function ZWBKZJLHCV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZWBKZJLHCV',ZWBKZJLHCV_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function ZWBKZJLHCV_ZOOM_setHandlers() {
function ZWBKZJLHCV_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ZWBKZJLHCV_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('ZWBKZJLHCV_ZOOM',ZWBKZJLHCV_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('ZWBKZJLHCV',ZWBKZJLHCV_ZOOM_setHandlers);
function VKTPGVCBJR_wrap_Valid(event) {
return VKTPGVCBJR_Valid(event);
}
SPBOUILib.SetCheckboxClick('VKTPGVCBJR',VKTPGVCBJR_wrap_Valid);
function VKTPGVCBJR_wrap_OnFocus(event) {
return VKTPGVCBJR_OnFocus(event);
}
SPBOUILib.SetInputEnter('VKTPGVCBJR',VKTPGVCBJR_wrap_OnFocus);
function VKTPGVCBJR_wrap_Blur(event) {
return VKTPGVCBJR_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('VKTPGVCBJR',VKTPGVCBJR_wrap_Blur);
function ZYSXZRLIHG_wrap_Valid(event) {
return ZYSXZRLIHG_Valid(event);
}
SPBOUILib.SetInputExit('ZYSXZRLIHG',ZYSXZRLIHG_wrap_Valid,SPBOUILib.Row.IN_GRID);
function ZYSXZRLIHG_wrap_OnFocus(event) {
return ZYSXZRLIHG_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZYSXZRLIHG',ZYSXZRLIHG_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function ZYSXZRLIHG_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('ZYSXZRLIHG',ZYSXZRLIHG_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function ZYSXZRLIHG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('ZYSXZRLIHG',ZYSXZRLIHG_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function SQFHVLZLRL_wrap_Valid(event) {
return SQFHVLZLRL_Valid(event);
}
SPBOUILib.SetInputExit('SQFHVLZLRL',SQFHVLZLRL_wrap_Valid);
function SQFHVLZLRL_wrap_OnFocus(event) {
return SQFHVLZLRL_OnFocus(event);
}
SPBOUILib.SetInputEnter('SQFHVLZLRL',SQFHVLZLRL_wrap_OnFocus);
function SQFHVLZLRL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SQFHVLZLRL',SQFHVLZLRL_wrap_OnKeyDown);
function CCYVNDNRFK_wrap_Valid(event) {
return CCYVNDNRFK_Valid(event);
}
SPBOUILib.SetInputExit('CCYVNDNRFK',CCYVNDNRFK_wrap_Valid);
function CCYVNDNRFK_wrap_OnFocus(event) {
return CCYVNDNRFK_OnFocus(event);
}
SPBOUILib.SetInputEnter('CCYVNDNRFK',CCYVNDNRFK_wrap_OnFocus);
function CCYVNDNRFK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CCYVNDNRFK',CCYVNDNRFK_wrap_OnKeyDown);
function GZYOVGKBQU_wrap_Valid(event) {
return GZYOVGKBQU_Valid(event);
}
SPBOUILib.SetCheckboxClick('GZYOVGKBQU',GZYOVGKBQU_wrap_Valid);
function GZYOVGKBQU_wrap_OnFocus(event) {
return GZYOVGKBQU_OnFocus(event);
}
SPBOUILib.SetInputEnter('GZYOVGKBQU',GZYOVGKBQU_wrap_OnFocus);
function GZYOVGKBQU_wrap_Blur(event) {
return GZYOVGKBQU_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('GZYOVGKBQU',GZYOVGKBQU_wrap_Blur);
function YQJXLYYDEK_wrap_Valid(event) {
return YQJXLYYDEK_Valid(event);
}
SPBOUILib.SetInputExit('YQJXLYYDEK',YQJXLYYDEK_wrap_Valid,SPBOUILib.Row.IN_GRID);
function YQJXLYYDEK_wrap_OnFocus(event) {
return YQJXLYYDEK_OnFocus(event);
}
SPBOUILib.SetInputEnter('YQJXLYYDEK',YQJXLYYDEK_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function YQJXLYYDEK_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('YQJXLYYDEK',YQJXLYYDEK_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function YQJXLYYDEK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('YQJXLYYDEK',YQJXLYYDEK_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function RPTFBMPRFK_wrap_Valid(event) {
return RPTFBMPRFK_Valid(event);
}
SPBOUILib.SetInputExit('RPTFBMPRFK',RPTFBMPRFK_wrap_Valid);
function RPTFBMPRFK_wrap_OnFocus(event) {
return RPTFBMPRFK_OnFocus(event);
}
SPBOUILib.SetInputEnter('RPTFBMPRFK',RPTFBMPRFK_wrap_OnFocus);
function RPTFBMPRFK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RPTFBMPRFK',RPTFBMPRFK_wrap_OnKeyDown);
function GEAGHOYNJV_wrap_Valid(event) {
return GEAGHOYNJV_Valid(event);
}
SPBOUILib.SetInputExit('GEAGHOYNJV',GEAGHOYNJV_wrap_Valid);
function GEAGHOYNJV_wrap_OnFocus(event) {
return GEAGHOYNJV_OnFocus(event);
}
SPBOUILib.SetInputEnter('GEAGHOYNJV',GEAGHOYNJV_wrap_OnFocus);
function GEAGHOYNJV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('GEAGHOYNJV',GEAGHOYNJV_wrap_OnKeyDown);
function KGVKWENSDZ_wrap_Valid(event) {
return KGVKWENSDZ_Valid(event);
}
SPBOUILib.SetInputExit('KGVKWENSDZ',KGVKWENSDZ_wrap_Valid);
function KGVKWENSDZ_wrap_OnFocus(event) {
return KGVKWENSDZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('KGVKWENSDZ',KGVKWENSDZ_wrap_OnFocus);
function KGVKWENSDZ_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('KGVKWENSDZ',KGVKWENSDZ_wrap_OnKeyPress);
function KGVKWENSDZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('KGVKWENSDZ',KGVKWENSDZ_wrap_OnKeyDown);
function UJYQWLUHMX_wrap_Valid(event) {
return UJYQWLUHMX_Valid(event);
}
SPBOUILib.SetInputExit('UJYQWLUHMX',UJYQWLUHMX_wrap_Valid);
function UJYQWLUHMX_wrap_OnFocus(event) {
return UJYQWLUHMX_OnFocus(event);
}
SPBOUILib.SetInputEnter('UJYQWLUHMX',UJYQWLUHMX_wrap_OnFocus);
function UJYQWLUHMX_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('UJYQWLUHMX',UJYQWLUHMX_wrap_OnKeyPress);
function UJYQWLUHMX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('UJYQWLUHMX',UJYQWLUHMX_wrap_OnKeyDown);
function LJUMSXSYFZ_wrap_Valid(event) {
return LJUMSXSYFZ_Valid(event);
}
SPBOUILib.SetInputExit('LJUMSXSYFZ',LJUMSXSYFZ_wrap_Valid);
function LJUMSXSYFZ_wrap_OnFocus(event) {
return LJUMSXSYFZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('LJUMSXSYFZ',LJUMSXSYFZ_wrap_OnFocus);
function LJUMSXSYFZ_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('LJUMSXSYFZ',LJUMSXSYFZ_wrap_OnKeyPress);
function LJUMSXSYFZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('LJUMSXSYFZ',LJUMSXSYFZ_wrap_OnKeyDown);
function ZEWCJCWNSV_wrap_Valid(event) {
return ZEWCJCWNSV_Valid(event);
}
SPBOUILib.SetCheckboxClick('ZEWCJCWNSV',ZEWCJCWNSV_wrap_Valid);
function ZEWCJCWNSV_wrap_OnFocus(event) {
return ZEWCJCWNSV_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZEWCJCWNSV',ZEWCJCWNSV_wrap_OnFocus);
function ZEWCJCWNSV_wrap_Blur(event) {
return ZEWCJCWNSV_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('ZEWCJCWNSV',ZEWCJCWNSV_wrap_Blur);
function YYRSSVEWOX_wrap_Valid(event) {
return YYRSSVEWOX_Valid(event);
}
SPBOUILib.SetInputExit('YYRSSVEWOX',YYRSSVEWOX_wrap_Valid);
function YYRSSVEWOX_wrap_OnFocus(event) {
return YYRSSVEWOX_OnFocus(event);
}
SPBOUILib.SetInputEnter('YYRSSVEWOX',YYRSSVEWOX_wrap_OnFocus);
function YYRSSVEWOX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YYRSSVEWOX',YYRSSVEWOX_wrap_OnKeyDown);
function FDSYVBCPAC_wrap_Valid(event) {
return FDSYVBCPAC_Valid(event);
}
SPBOUILib.SetInputExit('FDSYVBCPAC',FDSYVBCPAC_wrap_Valid);
function FDSYVBCPAC_wrap_OnFocus(event) {
return FDSYVBCPAC_OnFocus(event);
}
SPBOUILib.SetInputEnter('FDSYVBCPAC',FDSYVBCPAC_wrap_OnFocus);
function FDSYVBCPAC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FDSYVBCPAC',FDSYVBCPAC_wrap_OnKeyDown);
function CODMGYDXYT_wrap_Valid(event) {
return CODMGYDXYT_Valid(event);
}
SPBOUILib.SetInputExit('CODMGYDXYT',CODMGYDXYT_wrap_Valid);
function CODMGYDXYT_wrap_OnFocus(event) {
return CODMGYDXYT_OnFocus(event);
}
SPBOUILib.SetInputEnter('CODMGYDXYT',CODMGYDXYT_wrap_OnFocus);
function CODMGYDXYT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CODMGYDXYT',CODMGYDXYT_wrap_OnKeyDown);
function AKLWIUMNVR_wrap_Valid(event) {
return AKLWIUMNVR_Valid(event);
}
SPBOUILib.SetComboChange('AKLWIUMNVR',AKLWIUMNVR_wrap_Valid);
function AKLWIUMNVR_wrap_OnFocus(event) {
return AKLWIUMNVR_OnFocus(event);
}
SPBOUILib.SetInputEnter('AKLWIUMNVR',AKLWIUMNVR_wrap_OnFocus);
function AKLWIUMNVR_wrap_Blur(event) {
return AKLWIUMNVR_OnBlur(event);
}
SPBOUILib.SetInputExit('AKLWIUMNVR',AKLWIUMNVR_wrap_Blur);
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
m_bStopChangeRow=true;
} else if (Ne('undefined',typeof(m_nLastError))) {
m_bStopChangeRow=Eq(m_nLastError,-2);
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.edit={"page_1":["GGLQTNYWZF"],"page_4":["CODMGYDXYT"]};
FocusFirstComponent.query={"page_1":["UOVJKJLZBV"],"page_4":["CODMGYDXYT"]};
FocusFirstComponent.otherwise={"page_1":["UOVJKJLZBV"],"page_4":["CODMGYDXYT"]};
function Help() {
windowOpenForeground('../doc/armd_anagrappo_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_ardt_ae_saldianno_rap() {
SetModified(false);
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_2')) {
if (ChildToLoad('KGHSUPPYWT')) {
LoadContext.lc(1,'KGHSUPPYWT');
} else {
LibJavascript.RefreshChildGrid('KGHSUPPYWT');
}
}
}
GetLayerID.Layers.push({"id":"UBHZWYZYEF","name":"box_UBHZWYZYEF"});
GetLayerID.CheckEditRow=true;
function DeclareWVs() {
var a = arguments;
w_RAPPORTO=a[0];
w_TIPOAG=a[1];
w_COINT=a[2];
w_RIFANA=a[3];
w_CONNESINT=a[4];
w_ASPEDITO=a[5];
w_ADATA=a[6];
w_APROG=a[7];
w_AOLDPROG=a[8];
w_AFILE=a[9];
w_AOLDFILE=a[10];
w_ADATARET=a[11];
w_CSPEDITO=a[12];
w_CDATA=a[13];
w_CPROG=a[14];
w_COLDPROG=a[15];
w_CFILE=a[16];
w_COLDFILE=a[17];
w_CDATARET=a[18];
w_IDRIF=a[19];
w_NOCODFISC=a[20];
w_IDBASE=a[21];
w_CPROWNUM=a[22];
w_IDESITO=a[23];
w_RSPEDITO=a[24];
w_UNIQUECODE=a[25];
w_CAB=a[26];
w_VALUTA=a[27];
w_PROGAER=a[28];
op_PROGAER=a[29];
w_PROGAET=a[30];
op_PROGAET=a[31];
w_DATESITO=a[32];
w_CFESTERO=a[33];
w_xragsoc=a[34];
w_dtcanc=a[35];
w_spcanc=a[36];
w_filecanc=a[37];
w_idcanc=a[38];
op_codazi=a[39];
m_cWv_ardt_ae_saldianno_rap=a[40];
if (Gt(a.length,41)) {
m_cErrorInChild='';
}
if (Gt(a.length,41)) {
o_TIPOAG=w_TIPOAG;
o_IDBASE=w_IDBASE;
}
m_PrimaryKeys=['CPROWNUM','RAPPORTO'];
}
function i_PrimaryKey() {
return 'aetesta'+'\\'+CPLib.ToCPStr(w_RAPPORTO);
}
GetLinkPCKeys.set_o('ardt_ae_saldianno_rap',false);
GetLinkPCKeys.o['ardt_ae_saldianno_rap']['RAPPORTO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_RAPPORTO,'C');
}
}
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('KGHSUPPYWT',function(){return FrameRef('ardt_ae_saldianno_rap')},1,'ardt_ae_saldianno_rap',1,4)
GetSelectedChildPage.child={'ardt_ae_saldianno_rap': function(){return FrameRef('ardt_ae_saldianno_rap')}}
function GetSelectedPage(p_d) {
p_d.setValue('armd_anagrappo',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CONNESINT,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xragsoc,'C'); },"field":"RAGSOC","type":"C"},{"expression":function() { return WtA(w_CFESTERO,'N'); },"field":"CFESTERO","type":"N"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"ZWBKZJLHCV"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["ZWBKZJLHCV"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('RAPPORTO',0,'UOVJKJLZBV',false,"11116511596")
_Obli('TIPOAG',0,'GGLQTNYWZF',false,"1723736132")
_Obli('COINT',0,'BLOIDAPXRQ',false,"1723736132")
_Obli('CPROG',0,'RPTFBMPRFK',false,"803225745")
_Obli('CFILE',0,'GEAGHOYNJV',false,"11116236915")
_Obli('CONNESINT',0,'ZWBKZJLHCV',false,"1095110115")
_Obli('ASPEDITO',1,'VKTPGVCBJR',false,"348541329")
_Obli('ADATA',2,'ZYSXZRLIHG',false,"10996202746")
_Obli('ADATA',2,'KGVKWENSDZ',false,"10996202746")
_Obli('APROG',0,'SQFHVLZLRL',false,"264260953")
_Obli('CAB',0,'CODMGYDXYT',false,"18003")
_Obli('AFILE',0,'CCYVNDNRFK',false,"11745066193")
_Obli('VALUTA',0,'AKLWIUMNVR',false,"109822566")
_Obli('COLDFILE',0,'NVIYVKNNOM',false,"10991326470")
_Obli('COLDFILE',0,'YYRSSVEWOX',false,"10991326470")
_Obli('CSPEDITO',1,'GZYOVGKBQU',false,"11149805813")
_Obli('CDATA',2,'YQJXLYYDEK',false,"1747631465")
_Obli('CDATA',2,'UJYQWLUHMX',false,"1747631465")
_Obli('RSPEDITO',1,'ZEWCJCWNSV',false,"1205724772")
_Obli('COLDPROG',0,'RNQDSBHRRV',false,"11752966299")
_Obli('COLDPROG',0,'FDSYVBCPAC',false,"11752966299")
_Obli('ADATARET',2,'CZKERSYIAL',false,"1264402456")
_Obli('ADATARET',2,'LJUMSXSYFZ',false,"1264402456")
