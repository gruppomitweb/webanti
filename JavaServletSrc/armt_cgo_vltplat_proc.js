function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('ZGGIFYYPOE',function(){return WtH(w_VPCODICE,'C',2,0,'')},w_VPCODICE);
SPBOUILib.SetInputValue('OSLIHZCQKI',function(){return WtH(w_VPDESCRI,'C',50,0,'')},w_VPDESCRI);
if(c=Ctrl('CZVGGKXVIZ')) ChkboxCheckUncheck(c,'S',w_VPFLGATT)
if(c=Ctrl('CZVGGKXVIZ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('OFJLXZEHFJ',function(){return WtH(w_VPIDAAMS,'C',16,0,'')},w_VPIDAAMS);
SPBOUILib.SetInputValue('PVLHZPDZCG',function(){return WtH(w_VPCODPIAT,'N',4,0,'')},w_VPCODPIAT);
SPBOUILib.SetInputValue('SBCJPJIQKL',function(){return WtH(w_VPSIGLAPIAT,'C',3,0,'')},w_VPSIGLAPIAT);
SPBOUILib.SetInputValue('MWISDJAVFU',function(){return WtH(w_VPPROVENIENZA,'C',1,0,'')},w_VPPROVENIENZA);
SPBOUILib.SetInputValue('EPIRSSFGUY',function(){return WtH(w_VPVLTCODPLAT,'N',4,0,'')},w_VPVLTCODPLAT);
if(c=Ctrl('IOXCKXSDQO')) ChkboxCheckUncheck(c,'S',w_VPFLGCRYPTO)
if(c=Ctrl('IOXCKXSDQO')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('OWDBUVHDZF',function(){return WtH(w_VFPKAYCRYPTO,'M',10,0,'')},w_VFPKAYCRYPTO);
SPBOUILib.SetInputValue('CRNCQKHAZD',function(){return WtH(w_VPDIRFILE,'C',30,0,'')},w_VPDIRFILE);
if(c=Ctrl('YRIBZBIKSQ')) ChkboxCheckUncheck(c,'S',w_VPFILEINTESTA1)
if(c=Ctrl('YRIBZBIKSQ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('HSUYGDBUTJ')) selectCombo(c,w_VPFFILESPERATOR1,'C')
if(c=Ctrl('WWIDCEPGYS')) selectCombo(c,w_VPFILEFORDATA1,'C')
SPBOUILib.SetInputValue('WIFZHMQFSC',function(){return WtH(w_VPPREFFILE1,'C',30,0,'')},w_VPPREFFILE1);
if(c=Ctrl('JSTNURAHAS')) ChkboxCheckUncheck(c,'S',w_VPFILEINTESTA2)
if(c=Ctrl('JSTNURAHAS')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('RMKWOZTKVK')) selectCombo(c,w_VPFFILESPERATOR2,'C')
if(c=Ctrl('WSOZNFILVU')) selectCombo(c,w_VPFILEFORDATA2,'C')
SPBOUILib.SetInputValue('KMMYWUIZJE',function(){return WtH(w_VPPREFFILE2,'C',30,0,'')},w_VPPREFFILE2);
if(c=Ctrl('LGHPNQFTEZ')) ChkboxCheckUncheck(c,'S',w_VPFILEINTESTA3)
if(c=Ctrl('LGHPNQFTEZ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('DRTQWCMRII')) selectCombo(c,w_VPFFILESPERATOR3,'C')
if(c=Ctrl('WIOMSFLLSU')) selectCombo(c,w_VPFILEFORDATA3,'C')
SPBOUILib.SetInputValue('HYYEMIXZZH',function(){return WtH(w_VPPREFFILE3,'C',30,0,'')},w_VPPREFFILE3);
if(c=Ctrl('IWAAKTWPEO')) selectCombo(c,w_VPFLGPRESUF1,'C')
if(c=Ctrl('JNTTHSGKEW')) selectCombo(c,w_VPFLGPRESUF2,'C')
if(c=Ctrl('TMKKDOYZLM')) selectCombo(c,w_VPFLGPRESUF3,'C')
if(c=Ctrl('TAWZTFESRW')) ChkboxCheckUncheck(c,'S',w_VFPFLAGIMPORT)
if(c=Ctrl('TAWZTFESRW')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('UJQXAYYQOQ')) selectCombo(c,w_VFPTIPOFILE1,'C')
if(c=Ctrl('XKZJHMFBOP')) selectCombo(c,w_VFPTIPOFILE2,'C')
if(c=Ctrl('ADHTWRZDJL')) selectCombo(c,w_VFPTIPOFILE3,'C')
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('OWDBUVHDZF'),Eq(w_VPFLGCRYPTO,'N') || IsHiddenByStateDriver('VFPKAYCRYPTO'));
SetDisplay(Ctrl('SSPIDBFNIE'),Eq(w_VPFLGCRYPTO,'N'));
SetDisplay('UPMDALZWNE_DIV',IsHiddenByStateDriver('File'));
SetDisplay('XWPAALVUKU_DIV',IsHiddenByStateDriver('File1'));
SetDisplay('BVXXKEJNHQ_DIV',IsHiddenByStateDriver('File2'));
SetDisplay('PIFTFGCGKH_DIV',IsHiddenByStateDriver('File3'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["VFPKAYCRYPTO"]=['SSPIDBFNIE'];
HideUI.lblids["VFPTIPOFILE1"]=['OQBNEWXCRA'];
HideUI.lblids["VFPTIPOFILE2"]=['DSURKWDFIJ'];
HideUI.lblids["VFPTIPOFILE3"]=['RTYERWTCGQ'];
HideUI.lblids["VPCODICE"]=['DXUSYAWUSF'];
HideUI.lblids["VPCODPIAT"]=['YPGVNHKNND'];
HideUI.lblids["VPDESCRI"]=['NWLFWHLCTQ'];
HideUI.lblids["VPDIRFILE"]=['TQARYJWENE'];
HideUI.lblids["VPFFILESPERATOR1"]=['DKHGDLJMIA'];
HideUI.lblids["VPFFILESPERATOR2"]=['UIQPFTGBVY'];
HideUI.lblids["VPFFILESPERATOR3"]=['SYZSFZRUBB'];
HideUI.lblids["VPFILEFORDATA1"]=['VTSRTHMMJK'];
HideUI.lblids["VPFILEFORDATA2"]=['ODSVLUCLCI'];
HideUI.lblids["VPFILEFORDATA3"]=['BCOMVSSXIR'];
HideUI.lblids["VPIDAAMS"]=['MPMDRVAJWY'];
HideUI.lblids["VPPROVENIENZA"]=['WNALTAKNFI'];
HideUI.lblids["VPSIGLAPIAT"]=['ZDFKZEFUWP'];
HideUI.lblids["VPVLTCODPLAT"]=['NAOYNVOZFF'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function ZGGIFYYPOE_Valid(e) {
SetActiveField(Ctrl('ZGGIFYYPOE'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('ZGGIFYYPOE') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('VPCODICE','C',w_VPCODICE,HtW(Ctrl('ZGGIFYYPOE').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPCODICE(HtW(Ctrl('ZGGIFYYPOE').value,'C'),null,e);
return l_bSetResult;
}
}
function ZGGIFYYPOE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZGGIFYYPOE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZGGIFYYPOE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZGGIFYYPOE'),e);
}
function OSLIHZCQKI_Valid(e) {
SetActiveField(Ctrl('OSLIHZCQKI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('VPDESCRI','C',w_VPDESCRI,HtW(Ctrl('OSLIHZCQKI').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPDESCRI(HtW(Ctrl('OSLIHZCQKI').value,'C'),null,e);
return l_bSetResult;
}
}
function OSLIHZCQKI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OSLIHZCQKI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OSLIHZCQKI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OSLIHZCQKI'),e);
}
function CZVGGKXVIZ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VPFLGATT','C',w_VPFLGATT,ChkboxValueAssign(Ctrl('CZVGGKXVIZ'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPFLGATT(ChkboxValueAssign(Ctrl('CZVGGKXVIZ'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function CZVGGKXVIZ_OnFocus(e) {
SetActiveField(Ctrl('CZVGGKXVIZ'),true);
}
function CZVGGKXVIZ_OnBlur(e) {
SetActiveField(Ctrl('CZVGGKXVIZ'),false);
}
function OFJLXZEHFJ_Valid(e) {
SetActiveField(Ctrl('OFJLXZEHFJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('VPIDAAMS','C',w_VPIDAAMS,HtW(Ctrl('OFJLXZEHFJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPIDAAMS(HtW(Ctrl('OFJLXZEHFJ').value,'C'),null,e);
return l_bSetResult;
}
}
function OFJLXZEHFJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OFJLXZEHFJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OFJLXZEHFJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OFJLXZEHFJ'),e);
}
function PVLHZPDZCG_Valid(e) {
SetActiveField(Ctrl('PVLHZPDZCG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('VPCODPIAT','N',w_VPCODPIAT,HtW(Ctrl('PVLHZPDZCG').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPCODPIAT(HtW(Ctrl('PVLHZPDZCG').value,'N'),null,e);
return l_bSetResult;
}
}
function PVLHZPDZCG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PVLHZPDZCG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PVLHZPDZCG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PVLHZPDZCG'),e);
}
function SBCJPJIQKL_Valid(e) {
SetActiveField(Ctrl('SBCJPJIQKL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('VPSIGLAPIAT','C',w_VPSIGLAPIAT,HtW(Ctrl('SBCJPJIQKL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPSIGLAPIAT(HtW(Ctrl('SBCJPJIQKL').value,'C'),null,e);
return l_bSetResult;
}
}
function SBCJPJIQKL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SBCJPJIQKL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SBCJPJIQKL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SBCJPJIQKL'),e);
}
function MWISDJAVFU_Valid(e) {
SetActiveField(Ctrl('MWISDJAVFU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('VPPROVENIENZA','C',w_VPPROVENIENZA,HtW(Ctrl('MWISDJAVFU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPPROVENIENZA(HtW(Ctrl('MWISDJAVFU').value,'C'),null,e);
return l_bSetResult;
}
}
function MWISDJAVFU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MWISDJAVFU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MWISDJAVFU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MWISDJAVFU'),e);
}
function EPIRSSFGUY_Valid(e) {
SetActiveField(Ctrl('EPIRSSFGUY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('VPVLTCODPLAT','N',w_VPVLTCODPLAT,HtW(Ctrl('EPIRSSFGUY').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPVLTCODPLAT(HtW(Ctrl('EPIRSSFGUY').value,'N'),null,e);
return l_bSetResult;
}
}
function EPIRSSFGUY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EPIRSSFGUY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('EPIRSSFGUY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EPIRSSFGUY'),e);
}
function IOXCKXSDQO_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VPFLGCRYPTO','C',w_VPFLGCRYPTO,ChkboxValueAssign(Ctrl('IOXCKXSDQO'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPFLGCRYPTO(ChkboxValueAssign(Ctrl('IOXCKXSDQO'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function IOXCKXSDQO_OnFocus(e) {
SetActiveField(Ctrl('IOXCKXSDQO'),true);
}
function IOXCKXSDQO_OnBlur(e) {
SetActiveField(Ctrl('IOXCKXSDQO'),false);
}
function OWDBUVHDZF_Valid(e) {
SetActiveField(Ctrl('OWDBUVHDZF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('VFPKAYCRYPTO','M',w_VFPKAYCRYPTO,HtW(Ctrl('OWDBUVHDZF').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VFPKAYCRYPTO(HtW(Ctrl('OWDBUVHDZF').value,'M'),null,e);
return l_bSetResult;
}
}
function OWDBUVHDZF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OWDBUVHDZF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OWDBUVHDZF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OWDBUVHDZF'),e);
}
function CRNCQKHAZD_Valid(e) {
SetActiveField(Ctrl('CRNCQKHAZD'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('VPDIRFILE','C',w_VPDIRFILE,HtW(Ctrl('CRNCQKHAZD').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPDIRFILE(HtW(Ctrl('CRNCQKHAZD').value,'C'),null,e);
return l_bSetResult;
}
}
function CRNCQKHAZD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CRNCQKHAZD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CRNCQKHAZD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CRNCQKHAZD'),e);
}
function YRIBZBIKSQ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VPFILEINTESTA1','C',w_VPFILEINTESTA1,ChkboxValueAssign(Ctrl('YRIBZBIKSQ'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPFILEINTESTA1(ChkboxValueAssign(Ctrl('YRIBZBIKSQ'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function YRIBZBIKSQ_OnFocus(e) {
SetActiveField(Ctrl('YRIBZBIKSQ'),true);
}
function YRIBZBIKSQ_OnBlur(e) {
SetActiveField(Ctrl('YRIBZBIKSQ'),false);
}
function HSUYGDBUTJ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VPFFILESPERATOR1','C',w_VPFFILESPERATOR1,HtW(getComboValue(Ctrl('HSUYGDBUTJ')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPFFILESPERATOR1(HtW(getComboValue(Ctrl('HSUYGDBUTJ')),'C'),null,e);
return l_bSetResult;
}
}
function HSUYGDBUTJ_OnFocus(e) {
SetActiveField(Ctrl('HSUYGDBUTJ'),true);
}
function HSUYGDBUTJ_OnBlur(e) {
SetActiveField(Ctrl('HSUYGDBUTJ'),false);
}
function WWIDCEPGYS_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VPFILEFORDATA1','C',w_VPFILEFORDATA1,HtW(getComboValue(Ctrl('WWIDCEPGYS')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPFILEFORDATA1(HtW(getComboValue(Ctrl('WWIDCEPGYS')),'C'),null,e);
return l_bSetResult;
}
}
function WWIDCEPGYS_OnFocus(e) {
SetActiveField(Ctrl('WWIDCEPGYS'),true);
}
function WWIDCEPGYS_OnBlur(e) {
SetActiveField(Ctrl('WWIDCEPGYS'),false);
}
function WIFZHMQFSC_Valid(e) {
SetActiveField(Ctrl('WIFZHMQFSC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('VPPREFFILE1','C',w_VPPREFFILE1,HtW(Ctrl('WIFZHMQFSC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPPREFFILE1(HtW(Ctrl('WIFZHMQFSC').value,'C'),null,e);
return l_bSetResult;
}
}
function WIFZHMQFSC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WIFZHMQFSC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('WIFZHMQFSC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WIFZHMQFSC'),e);
}
function JSTNURAHAS_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VPFILEINTESTA2','C',w_VPFILEINTESTA2,ChkboxValueAssign(Ctrl('JSTNURAHAS'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPFILEINTESTA2(ChkboxValueAssign(Ctrl('JSTNURAHAS'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function JSTNURAHAS_OnFocus(e) {
SetActiveField(Ctrl('JSTNURAHAS'),true);
}
function JSTNURAHAS_OnBlur(e) {
SetActiveField(Ctrl('JSTNURAHAS'),false);
}
function RMKWOZTKVK_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VPFFILESPERATOR2','C',w_VPFFILESPERATOR2,HtW(getComboValue(Ctrl('RMKWOZTKVK')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPFFILESPERATOR2(HtW(getComboValue(Ctrl('RMKWOZTKVK')),'C'),null,e);
return l_bSetResult;
}
}
function RMKWOZTKVK_OnFocus(e) {
SetActiveField(Ctrl('RMKWOZTKVK'),true);
}
function RMKWOZTKVK_OnBlur(e) {
SetActiveField(Ctrl('RMKWOZTKVK'),false);
}
function WSOZNFILVU_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VPFILEFORDATA2','C',w_VPFILEFORDATA2,HtW(getComboValue(Ctrl('WSOZNFILVU')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPFILEFORDATA2(HtW(getComboValue(Ctrl('WSOZNFILVU')),'C'),null,e);
return l_bSetResult;
}
}
function WSOZNFILVU_OnFocus(e) {
SetActiveField(Ctrl('WSOZNFILVU'),true);
}
function WSOZNFILVU_OnBlur(e) {
SetActiveField(Ctrl('WSOZNFILVU'),false);
}
function KMMYWUIZJE_Valid(e) {
SetActiveField(Ctrl('KMMYWUIZJE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('VPPREFFILE2','C',w_VPPREFFILE2,HtW(Ctrl('KMMYWUIZJE').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPPREFFILE2(HtW(Ctrl('KMMYWUIZJE').value,'C'),null,e);
return l_bSetResult;
}
}
function KMMYWUIZJE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KMMYWUIZJE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KMMYWUIZJE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KMMYWUIZJE'),e);
}
function LGHPNQFTEZ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VPFILEINTESTA3','C',w_VPFILEINTESTA3,ChkboxValueAssign(Ctrl('LGHPNQFTEZ'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPFILEINTESTA3(ChkboxValueAssign(Ctrl('LGHPNQFTEZ'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function LGHPNQFTEZ_OnFocus(e) {
SetActiveField(Ctrl('LGHPNQFTEZ'),true);
}
function LGHPNQFTEZ_OnBlur(e) {
SetActiveField(Ctrl('LGHPNQFTEZ'),false);
}
function DRTQWCMRII_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VPFFILESPERATOR3','C',w_VPFFILESPERATOR3,HtW(getComboValue(Ctrl('DRTQWCMRII')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPFFILESPERATOR3(HtW(getComboValue(Ctrl('DRTQWCMRII')),'C'),null,e);
return l_bSetResult;
}
}
function DRTQWCMRII_OnFocus(e) {
SetActiveField(Ctrl('DRTQWCMRII'),true);
}
function DRTQWCMRII_OnBlur(e) {
SetActiveField(Ctrl('DRTQWCMRII'),false);
}
function WIOMSFLLSU_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VPFILEFORDATA3','C',w_VPFILEFORDATA3,HtW(getComboValue(Ctrl('WIOMSFLLSU')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPFILEFORDATA3(HtW(getComboValue(Ctrl('WIOMSFLLSU')),'C'),null,e);
return l_bSetResult;
}
}
function WIOMSFLLSU_OnFocus(e) {
SetActiveField(Ctrl('WIOMSFLLSU'),true);
}
function WIOMSFLLSU_OnBlur(e) {
SetActiveField(Ctrl('WIOMSFLLSU'),false);
}
function HYYEMIXZZH_Valid(e) {
SetActiveField(Ctrl('HYYEMIXZZH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('VPPREFFILE3','C',w_VPPREFFILE3,HtW(Ctrl('HYYEMIXZZH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPPREFFILE3(HtW(Ctrl('HYYEMIXZZH').value,'C'),null,e);
return l_bSetResult;
}
}
function HYYEMIXZZH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HYYEMIXZZH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HYYEMIXZZH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HYYEMIXZZH'),e);
}
function IWAAKTWPEO_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VPFLGPRESUF1','C',w_VPFLGPRESUF1,HtW(getComboValue(Ctrl('IWAAKTWPEO')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPFLGPRESUF1(HtW(getComboValue(Ctrl('IWAAKTWPEO')),'C'),null,e);
return l_bSetResult;
}
}
function IWAAKTWPEO_OnFocus(e) {
SetActiveField(Ctrl('IWAAKTWPEO'),true);
}
function IWAAKTWPEO_OnBlur(e) {
SetActiveField(Ctrl('IWAAKTWPEO'),false);
}
function JNTTHSGKEW_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VPFLGPRESUF2','C',w_VPFLGPRESUF2,HtW(getComboValue(Ctrl('JNTTHSGKEW')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPFLGPRESUF2(HtW(getComboValue(Ctrl('JNTTHSGKEW')),'C'),null,e);
return l_bSetResult;
}
}
function JNTTHSGKEW_OnFocus(e) {
SetActiveField(Ctrl('JNTTHSGKEW'),true);
}
function JNTTHSGKEW_OnBlur(e) {
SetActiveField(Ctrl('JNTTHSGKEW'),false);
}
function TMKKDOYZLM_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VPFLGPRESUF3','C',w_VPFLGPRESUF3,HtW(getComboValue(Ctrl('TMKKDOYZLM')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VPFLGPRESUF3(HtW(getComboValue(Ctrl('TMKKDOYZLM')),'C'),null,e);
return l_bSetResult;
}
}
function TMKKDOYZLM_OnFocus(e) {
SetActiveField(Ctrl('TMKKDOYZLM'),true);
}
function TMKKDOYZLM_OnBlur(e) {
SetActiveField(Ctrl('TMKKDOYZLM'),false);
}
function TAWZTFESRW_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VFPFLAGIMPORT','C',w_VFPFLAGIMPORT,ChkboxValueAssign(Ctrl('TAWZTFESRW'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VFPFLAGIMPORT(ChkboxValueAssign(Ctrl('TAWZTFESRW'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function TAWZTFESRW_OnFocus(e) {
SetActiveField(Ctrl('TAWZTFESRW'),true);
}
function TAWZTFESRW_OnBlur(e) {
SetActiveField(Ctrl('TAWZTFESRW'),false);
}
function UJQXAYYQOQ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VFPTIPOFILE1','C',w_VFPTIPOFILE1,HtW(getComboValue(Ctrl('UJQXAYYQOQ')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VFPTIPOFILE1(HtW(getComboValue(Ctrl('UJQXAYYQOQ')),'C'),null,e);
return l_bSetResult;
}
}
function UJQXAYYQOQ_OnFocus(e) {
SetActiveField(Ctrl('UJQXAYYQOQ'),true);
}
function UJQXAYYQOQ_OnBlur(e) {
SetActiveField(Ctrl('UJQXAYYQOQ'),false);
}
function XKZJHMFBOP_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VFPTIPOFILE2','C',w_VFPTIPOFILE2,HtW(getComboValue(Ctrl('XKZJHMFBOP')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VFPTIPOFILE2(HtW(getComboValue(Ctrl('XKZJHMFBOP')),'C'),null,e);
return l_bSetResult;
}
}
function XKZJHMFBOP_OnFocus(e) {
SetActiveField(Ctrl('XKZJHMFBOP'),true);
}
function XKZJHMFBOP_OnBlur(e) {
SetActiveField(Ctrl('XKZJHMFBOP'),false);
}
function ADHTWRZDJL_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VFPTIPOFILE3','C',w_VFPTIPOFILE3,HtW(getComboValue(Ctrl('ADHTWRZDJL')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VFPTIPOFILE3(HtW(getComboValue(Ctrl('ADHTWRZDJL')),'C'),null,e);
return l_bSetResult;
}
}
function ADHTWRZDJL_OnFocus(e) {
SetActiveField(Ctrl('ADHTWRZDJL'),true);
}
function ADHTWRZDJL_OnBlur(e) {
SetActiveField(Ctrl('ADHTWRZDJL'),false);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function ZGGIFYYPOE_wrap_Valid(event) {
return ZGGIFYYPOE_Valid(event);
}
SPBOUILib.SetInputExit('ZGGIFYYPOE',ZGGIFYYPOE_wrap_Valid);
function ZGGIFYYPOE_wrap_OnFocus(event) {
return ZGGIFYYPOE_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZGGIFYYPOE',ZGGIFYYPOE_wrap_OnFocus);
function ZGGIFYYPOE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZGGIFYYPOE',ZGGIFYYPOE_wrap_OnKeyDown);
function OSLIHZCQKI_wrap_Valid(event) {
return OSLIHZCQKI_Valid(event);
}
SPBOUILib.SetInputExit('OSLIHZCQKI',OSLIHZCQKI_wrap_Valid);
function OSLIHZCQKI_wrap_OnFocus(event) {
return OSLIHZCQKI_OnFocus(event);
}
SPBOUILib.SetInputEnter('OSLIHZCQKI',OSLIHZCQKI_wrap_OnFocus);
function OSLIHZCQKI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OSLIHZCQKI',OSLIHZCQKI_wrap_OnKeyDown);
function CZVGGKXVIZ_wrap_Valid(event) {
return CZVGGKXVIZ_Valid(event);
}
SPBOUILib.SetCheckboxClick('CZVGGKXVIZ',CZVGGKXVIZ_wrap_Valid);
function CZVGGKXVIZ_wrap_OnFocus(event) {
return CZVGGKXVIZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('CZVGGKXVIZ',CZVGGKXVIZ_wrap_OnFocus);
function CZVGGKXVIZ_wrap_Blur(event) {
return CZVGGKXVIZ_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('CZVGGKXVIZ',CZVGGKXVIZ_wrap_Blur);
function OFJLXZEHFJ_wrap_Valid(event) {
return OFJLXZEHFJ_Valid(event);
}
SPBOUILib.SetInputExit('OFJLXZEHFJ',OFJLXZEHFJ_wrap_Valid);
function OFJLXZEHFJ_wrap_OnFocus(event) {
return OFJLXZEHFJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('OFJLXZEHFJ',OFJLXZEHFJ_wrap_OnFocus);
function OFJLXZEHFJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OFJLXZEHFJ',OFJLXZEHFJ_wrap_OnKeyDown);
function PVLHZPDZCG_wrap_Valid(event) {
return PVLHZPDZCG_Valid(event);
}
SPBOUILib.SetInputExit('PVLHZPDZCG',PVLHZPDZCG_wrap_Valid);
function PVLHZPDZCG_wrap_OnFocus(event) {
return PVLHZPDZCG_OnFocus(event);
}
SPBOUILib.SetInputEnter('PVLHZPDZCG',PVLHZPDZCG_wrap_OnFocus);
function PVLHZPDZCG_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('PVLHZPDZCG',PVLHZPDZCG_wrap_OnKeyPress);
function PVLHZPDZCG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PVLHZPDZCG',PVLHZPDZCG_wrap_OnKeyDown);
function SBCJPJIQKL_wrap_Valid(event) {
return SBCJPJIQKL_Valid(event);
}
SPBOUILib.SetInputExit('SBCJPJIQKL',SBCJPJIQKL_wrap_Valid);
function SBCJPJIQKL_wrap_OnFocus(event) {
return SBCJPJIQKL_OnFocus(event);
}
SPBOUILib.SetInputEnter('SBCJPJIQKL',SBCJPJIQKL_wrap_OnFocus);
function SBCJPJIQKL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SBCJPJIQKL',SBCJPJIQKL_wrap_OnKeyDown);
function MWISDJAVFU_wrap_Valid(event) {
return MWISDJAVFU_Valid(event);
}
SPBOUILib.SetInputExit('MWISDJAVFU',MWISDJAVFU_wrap_Valid);
function MWISDJAVFU_wrap_OnFocus(event) {
return MWISDJAVFU_OnFocus(event);
}
SPBOUILib.SetInputEnter('MWISDJAVFU',MWISDJAVFU_wrap_OnFocus);
function MWISDJAVFU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MWISDJAVFU',MWISDJAVFU_wrap_OnKeyDown);
function EPIRSSFGUY_wrap_Valid(event) {
return EPIRSSFGUY_Valid(event);
}
SPBOUILib.SetInputExit('EPIRSSFGUY',EPIRSSFGUY_wrap_Valid);
function EPIRSSFGUY_wrap_OnFocus(event) {
return EPIRSSFGUY_OnFocus(event);
}
SPBOUILib.SetInputEnter('EPIRSSFGUY',EPIRSSFGUY_wrap_OnFocus);
function EPIRSSFGUY_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('EPIRSSFGUY',EPIRSSFGUY_wrap_OnKeyPress);
function EPIRSSFGUY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('EPIRSSFGUY',EPIRSSFGUY_wrap_OnKeyDown);
function IOXCKXSDQO_wrap_Valid(event) {
return IOXCKXSDQO_Valid(event);
}
SPBOUILib.SetCheckboxClick('IOXCKXSDQO',IOXCKXSDQO_wrap_Valid);
function IOXCKXSDQO_wrap_OnFocus(event) {
return IOXCKXSDQO_OnFocus(event);
}
SPBOUILib.SetInputEnter('IOXCKXSDQO',IOXCKXSDQO_wrap_OnFocus);
function IOXCKXSDQO_wrap_Blur(event) {
return IOXCKXSDQO_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('IOXCKXSDQO',IOXCKXSDQO_wrap_Blur);
function OWDBUVHDZF_wrap_Valid(event) {
return OWDBUVHDZF_Valid(event);
}
SPBOUILib.SetInputExit('OWDBUVHDZF',OWDBUVHDZF_wrap_Valid);
function OWDBUVHDZF_wrap_OnFocus(event) {
return OWDBUVHDZF_OnFocus(event);
}
SPBOUILib.SetInputEnter('OWDBUVHDZF',OWDBUVHDZF_wrap_OnFocus);
function CRNCQKHAZD_wrap_Valid(event) {
return CRNCQKHAZD_Valid(event);
}
SPBOUILib.SetInputExit('CRNCQKHAZD',CRNCQKHAZD_wrap_Valid);
function CRNCQKHAZD_wrap_OnFocus(event) {
return CRNCQKHAZD_OnFocus(event);
}
SPBOUILib.SetInputEnter('CRNCQKHAZD',CRNCQKHAZD_wrap_OnFocus);
function CRNCQKHAZD_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CRNCQKHAZD',CRNCQKHAZD_wrap_OnKeyDown);
function YRIBZBIKSQ_wrap_Valid(event) {
return YRIBZBIKSQ_Valid(event);
}
SPBOUILib.SetCheckboxClick('YRIBZBIKSQ',YRIBZBIKSQ_wrap_Valid);
function YRIBZBIKSQ_wrap_OnFocus(event) {
return YRIBZBIKSQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('YRIBZBIKSQ',YRIBZBIKSQ_wrap_OnFocus);
function YRIBZBIKSQ_wrap_Blur(event) {
return YRIBZBIKSQ_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('YRIBZBIKSQ',YRIBZBIKSQ_wrap_Blur);
function HSUYGDBUTJ_wrap_Valid(event) {
return HSUYGDBUTJ_Valid(event);
}
SPBOUILib.SetComboChange('HSUYGDBUTJ',HSUYGDBUTJ_wrap_Valid);
function HSUYGDBUTJ_wrap_OnFocus(event) {
return HSUYGDBUTJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('HSUYGDBUTJ',HSUYGDBUTJ_wrap_OnFocus);
function HSUYGDBUTJ_wrap_Blur(event) {
return HSUYGDBUTJ_OnBlur(event);
}
SPBOUILib.SetInputExit('HSUYGDBUTJ',HSUYGDBUTJ_wrap_Blur);
function WWIDCEPGYS_wrap_Valid(event) {
return WWIDCEPGYS_Valid(event);
}
SPBOUILib.SetComboChange('WWIDCEPGYS',WWIDCEPGYS_wrap_Valid);
function WWIDCEPGYS_wrap_OnFocus(event) {
return WWIDCEPGYS_OnFocus(event);
}
SPBOUILib.SetInputEnter('WWIDCEPGYS',WWIDCEPGYS_wrap_OnFocus);
function WWIDCEPGYS_wrap_Blur(event) {
return WWIDCEPGYS_OnBlur(event);
}
SPBOUILib.SetInputExit('WWIDCEPGYS',WWIDCEPGYS_wrap_Blur);
function WIFZHMQFSC_wrap_Valid(event) {
return WIFZHMQFSC_Valid(event);
}
SPBOUILib.SetInputExit('WIFZHMQFSC',WIFZHMQFSC_wrap_Valid);
function WIFZHMQFSC_wrap_OnFocus(event) {
return WIFZHMQFSC_OnFocus(event);
}
SPBOUILib.SetInputEnter('WIFZHMQFSC',WIFZHMQFSC_wrap_OnFocus);
function WIFZHMQFSC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WIFZHMQFSC',WIFZHMQFSC_wrap_OnKeyDown);
function JSTNURAHAS_wrap_Valid(event) {
return JSTNURAHAS_Valid(event);
}
SPBOUILib.SetCheckboxClick('JSTNURAHAS',JSTNURAHAS_wrap_Valid);
function JSTNURAHAS_wrap_OnFocus(event) {
return JSTNURAHAS_OnFocus(event);
}
SPBOUILib.SetInputEnter('JSTNURAHAS',JSTNURAHAS_wrap_OnFocus);
function JSTNURAHAS_wrap_Blur(event) {
return JSTNURAHAS_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('JSTNURAHAS',JSTNURAHAS_wrap_Blur);
function RMKWOZTKVK_wrap_Valid(event) {
return RMKWOZTKVK_Valid(event);
}
SPBOUILib.SetComboChange('RMKWOZTKVK',RMKWOZTKVK_wrap_Valid);
function RMKWOZTKVK_wrap_OnFocus(event) {
return RMKWOZTKVK_OnFocus(event);
}
SPBOUILib.SetInputEnter('RMKWOZTKVK',RMKWOZTKVK_wrap_OnFocus);
function RMKWOZTKVK_wrap_Blur(event) {
return RMKWOZTKVK_OnBlur(event);
}
SPBOUILib.SetInputExit('RMKWOZTKVK',RMKWOZTKVK_wrap_Blur);
function WSOZNFILVU_wrap_Valid(event) {
return WSOZNFILVU_Valid(event);
}
SPBOUILib.SetComboChange('WSOZNFILVU',WSOZNFILVU_wrap_Valid);
function WSOZNFILVU_wrap_OnFocus(event) {
return WSOZNFILVU_OnFocus(event);
}
SPBOUILib.SetInputEnter('WSOZNFILVU',WSOZNFILVU_wrap_OnFocus);
function WSOZNFILVU_wrap_Blur(event) {
return WSOZNFILVU_OnBlur(event);
}
SPBOUILib.SetInputExit('WSOZNFILVU',WSOZNFILVU_wrap_Blur);
function KMMYWUIZJE_wrap_Valid(event) {
return KMMYWUIZJE_Valid(event);
}
SPBOUILib.SetInputExit('KMMYWUIZJE',KMMYWUIZJE_wrap_Valid);
function KMMYWUIZJE_wrap_OnFocus(event) {
return KMMYWUIZJE_OnFocus(event);
}
SPBOUILib.SetInputEnter('KMMYWUIZJE',KMMYWUIZJE_wrap_OnFocus);
function KMMYWUIZJE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KMMYWUIZJE',KMMYWUIZJE_wrap_OnKeyDown);
function LGHPNQFTEZ_wrap_Valid(event) {
return LGHPNQFTEZ_Valid(event);
}
SPBOUILib.SetCheckboxClick('LGHPNQFTEZ',LGHPNQFTEZ_wrap_Valid);
function LGHPNQFTEZ_wrap_OnFocus(event) {
return LGHPNQFTEZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('LGHPNQFTEZ',LGHPNQFTEZ_wrap_OnFocus);
function LGHPNQFTEZ_wrap_Blur(event) {
return LGHPNQFTEZ_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('LGHPNQFTEZ',LGHPNQFTEZ_wrap_Blur);
function DRTQWCMRII_wrap_Valid(event) {
return DRTQWCMRII_Valid(event);
}
SPBOUILib.SetComboChange('DRTQWCMRII',DRTQWCMRII_wrap_Valid);
function DRTQWCMRII_wrap_OnFocus(event) {
return DRTQWCMRII_OnFocus(event);
}
SPBOUILib.SetInputEnter('DRTQWCMRII',DRTQWCMRII_wrap_OnFocus);
function DRTQWCMRII_wrap_Blur(event) {
return DRTQWCMRII_OnBlur(event);
}
SPBOUILib.SetInputExit('DRTQWCMRII',DRTQWCMRII_wrap_Blur);
function WIOMSFLLSU_wrap_Valid(event) {
return WIOMSFLLSU_Valid(event);
}
SPBOUILib.SetComboChange('WIOMSFLLSU',WIOMSFLLSU_wrap_Valid);
function WIOMSFLLSU_wrap_OnFocus(event) {
return WIOMSFLLSU_OnFocus(event);
}
SPBOUILib.SetInputEnter('WIOMSFLLSU',WIOMSFLLSU_wrap_OnFocus);
function WIOMSFLLSU_wrap_Blur(event) {
return WIOMSFLLSU_OnBlur(event);
}
SPBOUILib.SetInputExit('WIOMSFLLSU',WIOMSFLLSU_wrap_Blur);
function HYYEMIXZZH_wrap_Valid(event) {
return HYYEMIXZZH_Valid(event);
}
SPBOUILib.SetInputExit('HYYEMIXZZH',HYYEMIXZZH_wrap_Valid);
function HYYEMIXZZH_wrap_OnFocus(event) {
return HYYEMIXZZH_OnFocus(event);
}
SPBOUILib.SetInputEnter('HYYEMIXZZH',HYYEMIXZZH_wrap_OnFocus);
function HYYEMIXZZH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HYYEMIXZZH',HYYEMIXZZH_wrap_OnKeyDown);
function IWAAKTWPEO_wrap_Valid(event) {
return IWAAKTWPEO_Valid(event);
}
SPBOUILib.SetComboChange('IWAAKTWPEO',IWAAKTWPEO_wrap_Valid);
function IWAAKTWPEO_wrap_OnFocus(event) {
return IWAAKTWPEO_OnFocus(event);
}
SPBOUILib.SetInputEnter('IWAAKTWPEO',IWAAKTWPEO_wrap_OnFocus);
function IWAAKTWPEO_wrap_Blur(event) {
return IWAAKTWPEO_OnBlur(event);
}
SPBOUILib.SetInputExit('IWAAKTWPEO',IWAAKTWPEO_wrap_Blur);
function JNTTHSGKEW_wrap_Valid(event) {
return JNTTHSGKEW_Valid(event);
}
SPBOUILib.SetComboChange('JNTTHSGKEW',JNTTHSGKEW_wrap_Valid);
function JNTTHSGKEW_wrap_OnFocus(event) {
return JNTTHSGKEW_OnFocus(event);
}
SPBOUILib.SetInputEnter('JNTTHSGKEW',JNTTHSGKEW_wrap_OnFocus);
function JNTTHSGKEW_wrap_Blur(event) {
return JNTTHSGKEW_OnBlur(event);
}
SPBOUILib.SetInputExit('JNTTHSGKEW',JNTTHSGKEW_wrap_Blur);
function TMKKDOYZLM_wrap_Valid(event) {
return TMKKDOYZLM_Valid(event);
}
SPBOUILib.SetComboChange('TMKKDOYZLM',TMKKDOYZLM_wrap_Valid);
function TMKKDOYZLM_wrap_OnFocus(event) {
return TMKKDOYZLM_OnFocus(event);
}
SPBOUILib.SetInputEnter('TMKKDOYZLM',TMKKDOYZLM_wrap_OnFocus);
function TMKKDOYZLM_wrap_Blur(event) {
return TMKKDOYZLM_OnBlur(event);
}
SPBOUILib.SetInputExit('TMKKDOYZLM',TMKKDOYZLM_wrap_Blur);
function TAWZTFESRW_wrap_Valid(event) {
return TAWZTFESRW_Valid(event);
}
SPBOUILib.SetCheckboxClick('TAWZTFESRW',TAWZTFESRW_wrap_Valid);
function TAWZTFESRW_wrap_OnFocus(event) {
return TAWZTFESRW_OnFocus(event);
}
SPBOUILib.SetInputEnter('TAWZTFESRW',TAWZTFESRW_wrap_OnFocus);
function TAWZTFESRW_wrap_Blur(event) {
return TAWZTFESRW_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('TAWZTFESRW',TAWZTFESRW_wrap_Blur);
function UJQXAYYQOQ_wrap_Valid(event) {
return UJQXAYYQOQ_Valid(event);
}
SPBOUILib.SetComboChange('UJQXAYYQOQ',UJQXAYYQOQ_wrap_Valid);
function UJQXAYYQOQ_wrap_OnFocus(event) {
return UJQXAYYQOQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('UJQXAYYQOQ',UJQXAYYQOQ_wrap_OnFocus);
function UJQXAYYQOQ_wrap_Blur(event) {
return UJQXAYYQOQ_OnBlur(event);
}
SPBOUILib.SetInputExit('UJQXAYYQOQ',UJQXAYYQOQ_wrap_Blur);
function XKZJHMFBOP_wrap_Valid(event) {
return XKZJHMFBOP_Valid(event);
}
SPBOUILib.SetComboChange('XKZJHMFBOP',XKZJHMFBOP_wrap_Valid);
function XKZJHMFBOP_wrap_OnFocus(event) {
return XKZJHMFBOP_OnFocus(event);
}
SPBOUILib.SetInputEnter('XKZJHMFBOP',XKZJHMFBOP_wrap_OnFocus);
function XKZJHMFBOP_wrap_Blur(event) {
return XKZJHMFBOP_OnBlur(event);
}
SPBOUILib.SetInputExit('XKZJHMFBOP',XKZJHMFBOP_wrap_Blur);
function ADHTWRZDJL_wrap_Valid(event) {
return ADHTWRZDJL_Valid(event);
}
SPBOUILib.SetComboChange('ADHTWRZDJL',ADHTWRZDJL_wrap_Valid);
function ADHTWRZDJL_wrap_OnFocus(event) {
return ADHTWRZDJL_OnFocus(event);
}
SPBOUILib.SetInputEnter('ADHTWRZDJL',ADHTWRZDJL_wrap_OnFocus);
function ADHTWRZDJL_wrap_Blur(event) {
return ADHTWRZDJL_OnBlur(event);
}
SPBOUILib.SetInputExit('ADHTWRZDJL',ADHTWRZDJL_wrap_Blur);
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
FocusFirstComponent.edit={"page_1":["OSLIHZCQKI"]};
FocusFirstComponent.query={"page_1":["ZGGIFYYPOE"]};
FocusFirstComponent.otherwise={"page_1":["ZGGIFYYPOE"]};
function Help() {
windowOpenForeground('../doc/armt_cgo_vltplat_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
GetLayerID.Layers.push({"id":"UPMDALZWNE","name":"File"});
GetLayerID.Layers.push({"id":"XWPAALVUKU","name":"File1"});
GetLayerID.Layers.push({"id":"BVXXKEJNHQ","name":"File2"});
GetLayerID.Layers.push({"id":"PIFTFGCGKH","name":"File3"});
function DeclareWVs() {
var a = arguments;
w_VPCODICE=a[0];
w_VPDESCRI=a[1];
w_VPFLGATT=a[2];
w_VPIDAAMS=a[3];
w_VPCODPIAT=a[4];
w_VPSIGLAPIAT=a[5];
w_VPPROVENIENZA=a[6];
w_VPVLTCODPLAT=a[7];
w_VPFLGCRYPTO=a[8];
w_VFPKAYCRYPTO=a[9];
w_VPDIRFILE=a[10];
w_VPFILEINTESTA1=a[11];
w_VPFFILESPERATOR1=a[12];
w_VPFILEFORDATA1=a[13];
w_VPPREFFILE1=a[14];
w_VPFILEINTESTA2=a[15];
w_VPFFILESPERATOR2=a[16];
w_VPFILEFORDATA2=a[17];
w_VPPREFFILE2=a[18];
w_VPFILEINTESTA3=a[19];
w_VPFFILESPERATOR3=a[20];
w_VPFILEFORDATA3=a[21];
w_VPPREFFILE3=a[22];
w_VPFLGPRESUF1=a[23];
w_VPFLGPRESUF2=a[24];
w_VPFLGPRESUF3=a[25];
w_VFPFLAGIMPORT=a[26];
w_VFPTIPOFILE1=a[27];
w_VFPTIPOFILE2=a[28];
w_VFPTIPOFILE3=a[29];
m_PrimaryKeys=['VPCODICE'];
}
function i_PrimaryKey() {
return 'cgo_vltplat'+'\\'+CPLib.ToCPStr(w_VPCODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_cgo_vltplat',m_cSelectedPage);
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
_Obli('VPCODICE',0,'ZGGIFYYPOE',false,"112851763")
_Obli('VPDESCRI',0,'OSLIHZCQKI',false,"285808099")
_Obli('VPFLGATT',0,'CZVGGKXVIZ',false,"1745819304")
_Obli('VPIDAAMS',0,'OFJLXZEHFJ',false,"1477784713")
_Obli('VPCODPIAT',1,'PVLHZPDZCG',false,"10357365663")
_Obli('VPSIGLAPIAT',0,'SBCJPJIQKL',false,"734312933")
_Obli('VPPROVENIENZA',0,'MWISDJAVFU',false,"11068679298")
_Obli('VPVLTCODPLAT',1,'EPIRSSFGUY',false,"11038861271")
_Obli('VPFLGCRYPTO',0,'IOXCKXSDQO',false,"12056152049")
_Obli('VFPKAYCRYPTO',0,'OWDBUVHDZF',false,"1275677499")
_Obli('VPDIRFILE',0,'CRNCQKHAZD',false,"11633640653")
_Obli('VPFILEINTESTA1',0,'YRIBZBIKSQ',false,"1035812210")
_Obli('VPFFILESPERATOR1',0,'HSUYGDBUTJ',false,"1908399461")
_Obli('VPFILEFORDATA1',0,'WWIDCEPGYS',false,"1991168906")
_Obli('VPPREFFILE1',0,'WIFZHMQFSC',false,"1795947504")
_Obli('VPFILEINTESTA2',0,'JSTNURAHAS',false,"1035812210")
_Obli('VPFFILESPERATOR2',0,'RMKWOZTKVK',false,"1908399461")
_Obli('VPFILEFORDATA2',0,'WSOZNFILVU',false,"1991168906")
_Obli('VPPREFFILE2',0,'KMMYWUIZJE',false,"1795947504")
_Obli('VPFILEINTESTA3',0,'LGHPNQFTEZ',false,"1035812210")
_Obli('VPFFILESPERATOR3',0,'DRTQWCMRII',false,"1908399461")
_Obli('VPFILEFORDATA3',0,'WIOMSFLLSU',false,"1991168906")
_Obli('VPPREFFILE3',0,'HYYEMIXZZH',false,"1795947504")
_Obli('VPFLGPRESUF1',0,'IWAAKTWPEO',false,"1736088099")
_Obli('VPFLGPRESUF2',0,'JNTTHSGKEW',false,"1736088099")
_Obli('VPFLGPRESUF3',0,'TMKKDOYZLM',false,"1736088099")
_Obli('VFPFLAGIMPORT',0,'TAWZTFESRW',false,"10586713253")
_Obli('VFPTIPOFILE1',0,'UJQXAYYQOQ',false,"10160733698")
_Obli('VFPTIPOFILE2',0,'XKZJHMFBOP',false,"10160733442")
_Obli('VFPTIPOFILE3',0,'ADHTWRZDJL',false,"10160733186")
