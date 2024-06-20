function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('BXPAETNPNW',function(){return WtH(w_oa__code,'C',10,0,'')},w_oa__code);
if(c=Ctrl('SNIXYTTVQQ')) ChkboxCheckUncheck(c,1,w_oaapppublished)
if(c=Ctrl('SNIXYTTVQQ')) ChkboxValueAssign(c,1,0,'N',1,0,'')
if(c=Ctrl('ZLZSHHUAAO')) ChkboxCheckUncheck(c,'S',w_oareserved)
if(c=Ctrl('ZLZSHHUAAO')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('HGEWTTQPUR',function(){return WtH(w_oaappmenu,'C',100,0,'')},w_oaappmenu);
SPBOUILib.SetInputValue('DIVZDHWPRQ',function(){return WtH(w_oaapptitle,'C',50,0,'')},w_oaapptitle);
SPBOUILib.SetInputValue('XGINRSLGED',function(){return WtH(w_oadescri,'M',10,0,'')},w_oadescri);
SPBOUILib.SetInputValue('THXHMWDAPZ',function(){return WtH(w_oaapplogo,'C',50,0,'')},w_oaapplogo);
SPBOUILib.SetInputValue('QYLTLWYYSH',function(){return WtH(w_oaappfavico,'C',50,0,'')},w_oaappfavico);
SPBOUILib.SetInputValue('LHWJXXROEN',function(){return WtH(w_oaapplanding,'C',255,0,'')},w_oaapplanding);
SPBOUILib.SetInputValue('UZJHJSBNKL',function(){return WtH(w_oaskinname,'C',30,0,'')},w_oaskinname);
if(c=Ctrl('JKORHAZIKU')) ChkboxCheckUncheck(c,true,w_changeSkin)
if(c=Ctrl('JKORHAZIKU')) ChkboxValueAssign(c,true,false,'L',1,0,'')
SPBOUILib.SetInputValue('LRTLIAYQMN',function(){return WtH(w_oaappvariantname,'C',30,0,'')},w_oaappvariantname);
SPBOUILib.SetInputValue('MRNRGZRDQJ',function(){return WtH(w_oaappheader,'C',50,0,'')},w_oaappheader);
SPBOUILib.SetInputValue('CUOPMOHONZ',function(){return WtH(w_oaappdescrheader,'C',50,0,'')},w_oaappdescrheader);
if(c=Ctrl('DAMSKDIPPB')) ChkboxCheckUncheck(c,1,w_oaapphideutilitygroup)
if(c=Ctrl('DAMSKDIPPB')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('EYZZDYMIDO',function(){return WtH(w_oaapphomelink,'C',255,0,'')},w_oaapphomelink);
if(c=Ctrl('LMGRJMFNAF')) selectCombo(c,w_combo_homelink,'N')
SPBOUILib.SetInputValue('ZOTPWYUMVB',function(){return WtH(w_custom_homelink,'C',255,0,'')},w_custom_homelink);
SPBOUILib.SetInputValue('GJRUFNPOQO',function(){return WtH(w_oaappchecksum,'C',20,0,'')},w_oaappchecksum);
if(c=Ctrl('ZMJJCHDRPF')) selectCombo(c,w_OAAPPACCESSMODE,'C')
if(c=Ctrl('FBEIHIJGFG')) selectCombo(c,w_oaappdevtyp,'C')
if(c=Ctrl('HRCRJRTGHT')) ChkboxCheckUncheck(c,1,w_oaappreqreg)
if(c=Ctrl('HRCRJRTGHT')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('LDPQVCCVLI',function(){return WtH(w_oaappurlreg,'C',255,0,'')},w_oaappurlreg);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
h=Eq(w_oareserved,'N') || IsHiddenByStateDriver(Z.Tabs.Get('tabs').GetTabstripID('page_3'));
SetDisplay(Z.Tabs.Get('tabs').GetTabstripID('page_3'),h);
if (h && (Z.Tabs.Get('tabs').IsExpanded('page_3'))) {
Z.Tabs.Get('tabs').Next() || Z.Tabs.Get('tabs').Prev();
}
SetDisplay(Ctrl('EYZZDYMIDO'),true || IsHiddenByStateDriver('oaapphomelink'));
SetDisplay(Ctrl('ZOTPWYUMVB'),Ne(w_combo_homelink,3) || IsHiddenByStateDriver('custom_homelink'));
SetDisplay(Ctrl('LDPQVCCVLI'),Eq(w_oaappreqreg,0) || IsHiddenByStateDriver('oaappurlreg'));
SetDisplay(Ctrl('XRODPYXFDF'),Eq(w_oaappreqreg,0));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["combo_homelink"]=['NCFRRVPJOU'];
HideUI.lblids["oa__code"]=['KVKRLLIGYM'];
HideUI.lblids["oaappchecksum"]=['GFKDYWNVED'];
HideUI.lblids["oaappdescrheader"]=['QHPVOKFJDL'];
HideUI.lblids["oaappdevtyp"]=['TWZFAYGLKC'];
HideUI.lblids["oaappfavico"]=['XEBDOBFQBZ'];
HideUI.lblids["oaappheader"]=['ICRRPRBHAK'];
HideUI.lblids["oaapplanding"]=['DSXRDZXBTT'];
HideUI.lblids["oaapplogo"]=['HMQXIQLADZ'];
HideUI.lblids["oaappmenu"]=['TZKFFVHPXC'];
HideUI.lblids["oaapptitle"]=['FSDGYBMNYQ'];
HideUI.lblids["oaappurlreg"]=['XRODPYXFDF'];
HideUI.lblids["oaappvariantname"]=['MVNSCJDAFX'];
HideUI.lblids["oadescri"]=['CTNJEDTGDD'];
HideUI.lblids["oaskinname"]=['JLTWHMFXTO'];
function BXPAETNPNW_Valid(e) {
if (Ne(Ctrl('BXPAETNPNW').value,'')) {
Ctrl('BXPAETNPNW').value=zeroFill(Ctrl('BXPAETNPNW').value,10);
}
SetActiveField(Ctrl('BXPAETNPNW'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('BXPAETNPNW') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('oa__code','C',w_oa__code,HtW(Ctrl('BXPAETNPNW').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_oa__code(HtW(Ctrl('BXPAETNPNW').value,'C'),null,e);
return l_bSetResult;
}
}
function BXPAETNPNW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BXPAETNPNW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BXPAETNPNW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BXPAETNPNW'),e);
}
function SNIXYTTVQQ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('oaapppublished','N',w_oaapppublished,ChkboxValueAssign(Ctrl('SNIXYTTVQQ'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_oaapppublished(ChkboxValueAssign(Ctrl('SNIXYTTVQQ'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function SNIXYTTVQQ_OnFocus(e) {
SetActiveField(Ctrl('SNIXYTTVQQ'),true);
}
function SNIXYTTVQQ_OnBlur(e) {
SetActiveField(Ctrl('SNIXYTTVQQ'),false);
}
function ZLZSHHUAAO_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('oareserved','C',w_oareserved,ChkboxValueAssign(Ctrl('ZLZSHHUAAO'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_oareserved(ChkboxValueAssign(Ctrl('ZLZSHHUAAO'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function ZLZSHHUAAO_OnFocus(e) {
SetActiveField(Ctrl('ZLZSHHUAAO'),true);
}
function ZLZSHHUAAO_OnBlur(e) {
SetActiveField(Ctrl('ZLZSHHUAAO'),false);
}
function HGEWTTQPUR_Valid(e) {
SetActiveField(Ctrl('HGEWTTQPUR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('oaappmenu','C',w_oaappmenu,HtW(Ctrl('HGEWTTQPUR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_oaappmenu(HtW(Ctrl('HGEWTTQPUR').value,'C'),null,e);
return l_bSetResult;
}
}
function HGEWTTQPUR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HGEWTTQPUR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HGEWTTQPUR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HGEWTTQPUR'),e);
}
function href_TZKFFVHPXC() {
if ( ! (Empty(w_oaappmenu))) {
_modifyandopen(ToResource('../menueditor/menueditor.jsp'+'?action='+URLenc('load')+'&filename='+URLenc(w_oaappmenu)+'&m_cParameterSequence=action,filename')+'&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
}
function DIVZDHWPRQ_Valid(e) {
SetActiveField(Ctrl('DIVZDHWPRQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('oaapptitle','C',w_oaapptitle,HtW(Ctrl('DIVZDHWPRQ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_oaapptitle(HtW(Ctrl('DIVZDHWPRQ').value,'C'),null,e);
return l_bSetResult;
}
}
function DIVZDHWPRQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DIVZDHWPRQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DIVZDHWPRQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DIVZDHWPRQ'),e);
}
function XGINRSLGED_Valid(e) {
SetActiveField(Ctrl('XGINRSLGED'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('oadescri','M',w_oadescri,HtW(Ctrl('XGINRSLGED').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_oadescri(HtW(Ctrl('XGINRSLGED').value,'M'),null,e);
return l_bSetResult;
}
}
function XGINRSLGED_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XGINRSLGED'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XGINRSLGED'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XGINRSLGED'),e);
}
function THXHMWDAPZ_Valid(e) {
SetActiveField(Ctrl('THXHMWDAPZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('oaapplogo','C',w_oaapplogo,HtW(Ctrl('THXHMWDAPZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_oaapplogo(HtW(Ctrl('THXHMWDAPZ').value,'C'),null,e);
return l_bSetResult;
}
}
function THXHMWDAPZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('THXHMWDAPZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('THXHMWDAPZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('THXHMWDAPZ'),e);
}
function QYLTLWYYSH_Valid(e) {
SetActiveField(Ctrl('QYLTLWYYSH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('oaappfavico','C',w_oaappfavico,HtW(Ctrl('QYLTLWYYSH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_oaappfavico(HtW(Ctrl('QYLTLWYYSH').value,'C'),null,e);
return l_bSetResult;
}
}
function QYLTLWYYSH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QYLTLWYYSH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QYLTLWYYSH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QYLTLWYYSH'),e);
}
function LHWJXXROEN_Valid(e) {
SetActiveField(Ctrl('LHWJXXROEN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('oaapplanding','C',w_oaapplanding,HtW(Ctrl('LHWJXXROEN').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_oaapplanding(HtW(Ctrl('LHWJXXROEN').value,'C'),null,e);
return l_bSetResult;
}
}
function LHWJXXROEN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LHWJXXROEN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LHWJXXROEN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LHWJXXROEN'),e);
}
function UZJHJSBNKL_Valid(e) {
SetActiveField(Ctrl('UZJHJSBNKL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('oaskinname','C',w_oaskinname,HtW(Ctrl('UZJHJSBNKL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_oaskinname(HtW(Ctrl('UZJHJSBNKL').value,'C'),null,e);
return l_bSetResult;
}
}
function UZJHJSBNKL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UZJHJSBNKL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UZJHJSBNKL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UZJHJSBNKL'),e);
}
function JKORHAZIKU_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('changeSkin','L',w_changeSkin,ChkboxValueAssign(Ctrl('JKORHAZIKU'),true,false,'L',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_changeSkin(ChkboxValueAssign(Ctrl('JKORHAZIKU'),true,false,'L',1,0,''),null,e);
return l_bSetResult;
}
}
function JKORHAZIKU_OnFocus(e) {
SetActiveField(Ctrl('JKORHAZIKU'),true);
}
function JKORHAZIKU_OnBlur(e) {
SetActiveField(Ctrl('JKORHAZIKU'),false);
}
function LRTLIAYQMN_Valid(e) {
SetActiveField(Ctrl('LRTLIAYQMN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('oaappvariantname','C',w_oaappvariantname,HtW(Ctrl('LRTLIAYQMN').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_oaappvariantname(HtW(Ctrl('LRTLIAYQMN').value,'C'),null,e);
return l_bSetResult;
}
}
function LRTLIAYQMN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LRTLIAYQMN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LRTLIAYQMN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LRTLIAYQMN'),e);
}
function MRNRGZRDQJ_Valid(e) {
SetActiveField(Ctrl('MRNRGZRDQJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('oaappheader','C',w_oaappheader,HtW(Ctrl('MRNRGZRDQJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_oaappheader(HtW(Ctrl('MRNRGZRDQJ').value,'C'),null,e);
return l_bSetResult;
}
}
function MRNRGZRDQJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MRNRGZRDQJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MRNRGZRDQJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MRNRGZRDQJ'),e);
}
function CUOPMOHONZ_Valid(e) {
SetActiveField(Ctrl('CUOPMOHONZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('oaappdescrheader','C',w_oaappdescrheader,HtW(Ctrl('CUOPMOHONZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_oaappdescrheader(HtW(Ctrl('CUOPMOHONZ').value,'C'),null,e);
return l_bSetResult;
}
}
function CUOPMOHONZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CUOPMOHONZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CUOPMOHONZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CUOPMOHONZ'),e);
}
function DAMSKDIPPB_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('oaapphideutilitygroup','N',w_oaapphideutilitygroup,ChkboxValueAssign(Ctrl('DAMSKDIPPB'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_oaapphideutilitygroup(ChkboxValueAssign(Ctrl('DAMSKDIPPB'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function DAMSKDIPPB_OnFocus(e) {
SetActiveField(Ctrl('DAMSKDIPPB'),true);
}
function DAMSKDIPPB_OnBlur(e) {
SetActiveField(Ctrl('DAMSKDIPPB'),false);
}
function EYZZDYMIDO_Valid(e) {
SetActiveField(Ctrl('EYZZDYMIDO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('oaapphomelink','C',w_oaapphomelink,HtW(Ctrl('EYZZDYMIDO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_oaapphomelink(HtW(Ctrl('EYZZDYMIDO').value,'C'),null,e);
return l_bSetResult;
}
}
function EYZZDYMIDO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EYZZDYMIDO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('EYZZDYMIDO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EYZZDYMIDO'),e);
}
function LMGRJMFNAF_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('combo_homelink','N',w_combo_homelink,HtW(getComboValue(Ctrl('LMGRJMFNAF')),'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_combo_homelink(HtW(getComboValue(Ctrl('LMGRJMFNAF')),'N'),null,e);
return l_bSetResult;
}
}
function LMGRJMFNAF_OnFocus(e) {
SetActiveField(Ctrl('LMGRJMFNAF'),true);
}
function LMGRJMFNAF_OnBlur(e) {
SetActiveField(Ctrl('LMGRJMFNAF'),false);
}
function ZOTPWYUMVB_Valid(e) {
SetActiveField(Ctrl('ZOTPWYUMVB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('custom_homelink','C',w_custom_homelink,HtW(Ctrl('ZOTPWYUMVB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_custom_homelink(HtW(Ctrl('ZOTPWYUMVB').value,'C'),null,e);
return l_bSetResult;
}
}
function ZOTPWYUMVB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZOTPWYUMVB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZOTPWYUMVB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZOTPWYUMVB'),e);
}
function GJRUFNPOQO_Valid(e) {
SetActiveField(Ctrl('GJRUFNPOQO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('oaappchecksum','C',w_oaappchecksum,HtW(Ctrl('GJRUFNPOQO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_oaappchecksum(HtW(Ctrl('GJRUFNPOQO').value,'C'),null,e);
return l_bSetResult;
}
}
function GJRUFNPOQO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GJRUFNPOQO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GJRUFNPOQO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GJRUFNPOQO'),e);
}
function ZMJJCHDRPF_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('OAAPPACCESSMODE','C',w_OAAPPACCESSMODE,HtW(getComboValue(Ctrl('ZMJJCHDRPF')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_OAAPPACCESSMODE(HtW(getComboValue(Ctrl('ZMJJCHDRPF')),'C'),null,e);
return l_bSetResult;
}
}
function ZMJJCHDRPF_OnFocus(e) {
SetActiveField(Ctrl('ZMJJCHDRPF'),true);
}
function ZMJJCHDRPF_OnBlur(e) {
SetActiveField(Ctrl('ZMJJCHDRPF'),false);
}
function FBEIHIJGFG_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('oaappdevtyp','C',w_oaappdevtyp,HtW(getComboValue(Ctrl('FBEIHIJGFG')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_oaappdevtyp(HtW(getComboValue(Ctrl('FBEIHIJGFG')),'C'),null,e);
return l_bSetResult;
}
}
function FBEIHIJGFG_OnFocus(e) {
SetActiveField(Ctrl('FBEIHIJGFG'),true);
}
function FBEIHIJGFG_OnBlur(e) {
SetActiveField(Ctrl('FBEIHIJGFG'),false);
}
function HRCRJRTGHT_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('oaappreqreg','N',w_oaappreqreg,ChkboxValueAssign(Ctrl('HRCRJRTGHT'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_oaappreqreg(ChkboxValueAssign(Ctrl('HRCRJRTGHT'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function HRCRJRTGHT_OnFocus(e) {
SetActiveField(Ctrl('HRCRJRTGHT'),true);
}
function HRCRJRTGHT_OnBlur(e) {
SetActiveField(Ctrl('HRCRJRTGHT'),false);
}
function LDPQVCCVLI_Valid(e) {
SetActiveField(Ctrl('LDPQVCCVLI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('oaappurlreg','C',w_oaappurlreg,HtW(Ctrl('LDPQVCCVLI').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_oaappurlreg(HtW(Ctrl('LDPQVCCVLI').value,'C'),null,e);
return l_bSetResult;
}
}
function LDPQVCCVLI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LDPQVCCVLI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LDPQVCCVLI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LDPQVCCVLI'),e);
}
linkpc_url.u('OIOVQVCCYP',function(){return 'spadministration_dmobapp_qkm?m_bInnerChild=true'+GetLinkPCKeys('spadministration_dmobapp_qkm')+'&m_bRowsChild='+EnableChild('spadministration_dmobapp_qkm')})
linkpc_url.u('XNQZSXVGTN',function(){return 'spadministration_mobapppermissions?m_bInnerChild=true'+GetLinkPCKeys('spadministration_mobapppermissions')+'&m_bRowsChild='+EnableChild('spadministration_mobapppermissions')})
_ResetTracker();
function setEventHandlers() {
var c;
function TZKFFVHPXC_wrap_OnClick(event) {
return href_TZKFFVHPXC();
}
SPBOUILib.SetLabelClick('TZKFFVHPXC',TZKFFVHPXC_wrap_OnClick);
function TZKFFVHPXC_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetLabelKeyDown('TZKFFVHPXC',TZKFFVHPXC_wrap_OnKeyDown);
if (Ne(m_cFunction,'view')) {
function BXPAETNPNW_wrap_Valid(event) {
return BXPAETNPNW_Valid(event);
}
SPBOUILib.SetInputExit('BXPAETNPNW',BXPAETNPNW_wrap_Valid);
function BXPAETNPNW_wrap_OnFocus(event) {
return BXPAETNPNW_OnFocus(event);
}
SPBOUILib.SetInputEnter('BXPAETNPNW',BXPAETNPNW_wrap_OnFocus);
function BXPAETNPNW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BXPAETNPNW',BXPAETNPNW_wrap_OnKeyDown);
function SNIXYTTVQQ_wrap_Valid(event) {
return SNIXYTTVQQ_Valid(event);
}
SPBOUILib.SetCheckboxClick('SNIXYTTVQQ',SNIXYTTVQQ_wrap_Valid);
function SNIXYTTVQQ_wrap_OnFocus(event) {
return SNIXYTTVQQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('SNIXYTTVQQ',SNIXYTTVQQ_wrap_OnFocus);
function SNIXYTTVQQ_wrap_Blur(event) {
return SNIXYTTVQQ_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('SNIXYTTVQQ',SNIXYTTVQQ_wrap_Blur);
function ZLZSHHUAAO_wrap_Valid(event) {
return ZLZSHHUAAO_Valid(event);
}
SPBOUILib.SetCheckboxClick('ZLZSHHUAAO',ZLZSHHUAAO_wrap_Valid);
function ZLZSHHUAAO_wrap_OnFocus(event) {
return ZLZSHHUAAO_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZLZSHHUAAO',ZLZSHHUAAO_wrap_OnFocus);
function ZLZSHHUAAO_wrap_Blur(event) {
return ZLZSHHUAAO_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('ZLZSHHUAAO',ZLZSHHUAAO_wrap_Blur);
function HGEWTTQPUR_wrap_Valid(event) {
return HGEWTTQPUR_Valid(event);
}
SPBOUILib.SetInputExit('HGEWTTQPUR',HGEWTTQPUR_wrap_Valid);
function HGEWTTQPUR_wrap_OnFocus(event) {
return HGEWTTQPUR_OnFocus(event);
}
SPBOUILib.SetInputEnter('HGEWTTQPUR',HGEWTTQPUR_wrap_OnFocus);
function HGEWTTQPUR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HGEWTTQPUR',HGEWTTQPUR_wrap_OnKeyDown);
function DIVZDHWPRQ_wrap_Valid(event) {
return DIVZDHWPRQ_Valid(event);
}
SPBOUILib.SetInputExit('DIVZDHWPRQ',DIVZDHWPRQ_wrap_Valid);
function DIVZDHWPRQ_wrap_OnFocus(event) {
return DIVZDHWPRQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('DIVZDHWPRQ',DIVZDHWPRQ_wrap_OnFocus);
function DIVZDHWPRQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DIVZDHWPRQ',DIVZDHWPRQ_wrap_OnKeyDown);
function XGINRSLGED_wrap_Valid(event) {
return XGINRSLGED_Valid(event);
}
SPBOUILib.SetInputExit('XGINRSLGED',XGINRSLGED_wrap_Valid);
function XGINRSLGED_wrap_OnFocus(event) {
return XGINRSLGED_OnFocus(event);
}
SPBOUILib.SetInputEnter('XGINRSLGED',XGINRSLGED_wrap_OnFocus);
function THXHMWDAPZ_wrap_Valid(event) {
return THXHMWDAPZ_Valid(event);
}
SPBOUILib.SetInputExit('THXHMWDAPZ',THXHMWDAPZ_wrap_Valid);
function THXHMWDAPZ_wrap_OnFocus(event) {
return THXHMWDAPZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('THXHMWDAPZ',THXHMWDAPZ_wrap_OnFocus);
function THXHMWDAPZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('THXHMWDAPZ',THXHMWDAPZ_wrap_OnKeyDown);
function QYLTLWYYSH_wrap_Valid(event) {
return QYLTLWYYSH_Valid(event);
}
SPBOUILib.SetInputExit('QYLTLWYYSH',QYLTLWYYSH_wrap_Valid);
function QYLTLWYYSH_wrap_OnFocus(event) {
return QYLTLWYYSH_OnFocus(event);
}
SPBOUILib.SetInputEnter('QYLTLWYYSH',QYLTLWYYSH_wrap_OnFocus);
function QYLTLWYYSH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QYLTLWYYSH',QYLTLWYYSH_wrap_OnKeyDown);
function LHWJXXROEN_wrap_Valid(event) {
return LHWJXXROEN_Valid(event);
}
SPBOUILib.SetInputExit('LHWJXXROEN',LHWJXXROEN_wrap_Valid);
function LHWJXXROEN_wrap_OnFocus(event) {
return LHWJXXROEN_OnFocus(event);
}
SPBOUILib.SetInputEnter('LHWJXXROEN',LHWJXXROEN_wrap_OnFocus);
function LHWJXXROEN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LHWJXXROEN',LHWJXXROEN_wrap_OnKeyDown);
function UZJHJSBNKL_wrap_Valid(event) {
return UZJHJSBNKL_Valid(event);
}
SPBOUILib.SetInputExit('UZJHJSBNKL',UZJHJSBNKL_wrap_Valid);
function UZJHJSBNKL_wrap_OnFocus(event) {
return UZJHJSBNKL_OnFocus(event);
}
SPBOUILib.SetInputEnter('UZJHJSBNKL',UZJHJSBNKL_wrap_OnFocus);
function UZJHJSBNKL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UZJHJSBNKL',UZJHJSBNKL_wrap_OnKeyDown);
function JKORHAZIKU_wrap_Valid(event) {
return JKORHAZIKU_Valid(event);
}
SPBOUILib.SetCheckboxClick('JKORHAZIKU',JKORHAZIKU_wrap_Valid);
function JKORHAZIKU_wrap_OnFocus(event) {
return JKORHAZIKU_OnFocus(event);
}
SPBOUILib.SetInputEnter('JKORHAZIKU',JKORHAZIKU_wrap_OnFocus);
function JKORHAZIKU_wrap_Blur(event) {
return JKORHAZIKU_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('JKORHAZIKU',JKORHAZIKU_wrap_Blur);
function LRTLIAYQMN_wrap_Valid(event) {
return LRTLIAYQMN_Valid(event);
}
SPBOUILib.SetInputExit('LRTLIAYQMN',LRTLIAYQMN_wrap_Valid);
function LRTLIAYQMN_wrap_OnFocus(event) {
return LRTLIAYQMN_OnFocus(event);
}
SPBOUILib.SetInputEnter('LRTLIAYQMN',LRTLIAYQMN_wrap_OnFocus);
function LRTLIAYQMN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LRTLIAYQMN',LRTLIAYQMN_wrap_OnKeyDown);
function MRNRGZRDQJ_wrap_Valid(event) {
return MRNRGZRDQJ_Valid(event);
}
SPBOUILib.SetInputExit('MRNRGZRDQJ',MRNRGZRDQJ_wrap_Valid);
function MRNRGZRDQJ_wrap_OnFocus(event) {
return MRNRGZRDQJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('MRNRGZRDQJ',MRNRGZRDQJ_wrap_OnFocus);
function MRNRGZRDQJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MRNRGZRDQJ',MRNRGZRDQJ_wrap_OnKeyDown);
function CUOPMOHONZ_wrap_Valid(event) {
return CUOPMOHONZ_Valid(event);
}
SPBOUILib.SetInputExit('CUOPMOHONZ',CUOPMOHONZ_wrap_Valid);
function CUOPMOHONZ_wrap_OnFocus(event) {
return CUOPMOHONZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('CUOPMOHONZ',CUOPMOHONZ_wrap_OnFocus);
function CUOPMOHONZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CUOPMOHONZ',CUOPMOHONZ_wrap_OnKeyDown);
function DAMSKDIPPB_wrap_Valid(event) {
return DAMSKDIPPB_Valid(event);
}
SPBOUILib.SetCheckboxClick('DAMSKDIPPB',DAMSKDIPPB_wrap_Valid);
function DAMSKDIPPB_wrap_OnFocus(event) {
return DAMSKDIPPB_OnFocus(event);
}
SPBOUILib.SetInputEnter('DAMSKDIPPB',DAMSKDIPPB_wrap_OnFocus);
function DAMSKDIPPB_wrap_Blur(event) {
return DAMSKDIPPB_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('DAMSKDIPPB',DAMSKDIPPB_wrap_Blur);
function EYZZDYMIDO_wrap_Valid(event) {
return EYZZDYMIDO_Valid(event);
}
SPBOUILib.SetInputExit('EYZZDYMIDO',EYZZDYMIDO_wrap_Valid);
function EYZZDYMIDO_wrap_OnFocus(event) {
return EYZZDYMIDO_OnFocus(event);
}
SPBOUILib.SetInputEnter('EYZZDYMIDO',EYZZDYMIDO_wrap_OnFocus);
function EYZZDYMIDO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('EYZZDYMIDO',EYZZDYMIDO_wrap_OnKeyDown);
function LMGRJMFNAF_wrap_Valid(event) {
return LMGRJMFNAF_Valid(event);
}
SPBOUILib.SetComboChange('LMGRJMFNAF',LMGRJMFNAF_wrap_Valid);
function LMGRJMFNAF_wrap_OnFocus(event) {
return LMGRJMFNAF_OnFocus(event);
}
SPBOUILib.SetInputEnter('LMGRJMFNAF',LMGRJMFNAF_wrap_OnFocus);
function LMGRJMFNAF_wrap_Blur(event) {
return LMGRJMFNAF_OnBlur(event);
}
SPBOUILib.SetInputExit('LMGRJMFNAF',LMGRJMFNAF_wrap_Blur);
function ZOTPWYUMVB_wrap_Valid(event) {
return ZOTPWYUMVB_Valid(event);
}
SPBOUILib.SetInputExit('ZOTPWYUMVB',ZOTPWYUMVB_wrap_Valid);
function ZOTPWYUMVB_wrap_OnFocus(event) {
return ZOTPWYUMVB_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZOTPWYUMVB',ZOTPWYUMVB_wrap_OnFocus);
function ZOTPWYUMVB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZOTPWYUMVB',ZOTPWYUMVB_wrap_OnKeyDown);
function GJRUFNPOQO_wrap_Valid(event) {
return GJRUFNPOQO_Valid(event);
}
SPBOUILib.SetInputExit('GJRUFNPOQO',GJRUFNPOQO_wrap_Valid);
function GJRUFNPOQO_wrap_OnFocus(event) {
return GJRUFNPOQO_OnFocus(event);
}
SPBOUILib.SetInputEnter('GJRUFNPOQO',GJRUFNPOQO_wrap_OnFocus);
function GJRUFNPOQO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('GJRUFNPOQO',GJRUFNPOQO_wrap_OnKeyDown);
function ZMJJCHDRPF_wrap_Valid(event) {
return ZMJJCHDRPF_Valid(event);
}
SPBOUILib.SetComboChange('ZMJJCHDRPF',ZMJJCHDRPF_wrap_Valid);
function ZMJJCHDRPF_wrap_OnFocus(event) {
return ZMJJCHDRPF_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZMJJCHDRPF',ZMJJCHDRPF_wrap_OnFocus);
function ZMJJCHDRPF_wrap_Blur(event) {
return ZMJJCHDRPF_OnBlur(event);
}
SPBOUILib.SetInputExit('ZMJJCHDRPF',ZMJJCHDRPF_wrap_Blur);
function FBEIHIJGFG_wrap_Valid(event) {
return FBEIHIJGFG_Valid(event);
}
SPBOUILib.SetComboChange('FBEIHIJGFG',FBEIHIJGFG_wrap_Valid);
function FBEIHIJGFG_wrap_OnFocus(event) {
return FBEIHIJGFG_OnFocus(event);
}
SPBOUILib.SetInputEnter('FBEIHIJGFG',FBEIHIJGFG_wrap_OnFocus);
function FBEIHIJGFG_wrap_Blur(event) {
return FBEIHIJGFG_OnBlur(event);
}
SPBOUILib.SetInputExit('FBEIHIJGFG',FBEIHIJGFG_wrap_Blur);
function HRCRJRTGHT_wrap_Valid(event) {
return HRCRJRTGHT_Valid(event);
}
SPBOUILib.SetCheckboxClick('HRCRJRTGHT',HRCRJRTGHT_wrap_Valid);
function HRCRJRTGHT_wrap_OnFocus(event) {
return HRCRJRTGHT_OnFocus(event);
}
SPBOUILib.SetInputEnter('HRCRJRTGHT',HRCRJRTGHT_wrap_OnFocus);
function HRCRJRTGHT_wrap_Blur(event) {
return HRCRJRTGHT_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('HRCRJRTGHT',HRCRJRTGHT_wrap_Blur);
function LDPQVCCVLI_wrap_Valid(event) {
return LDPQVCCVLI_Valid(event);
}
SPBOUILib.SetInputExit('LDPQVCCVLI',LDPQVCCVLI_wrap_Valid);
function LDPQVCCVLI_wrap_OnFocus(event) {
return LDPQVCCVLI_OnFocus(event);
}
SPBOUILib.SetInputEnter('LDPQVCCVLI',LDPQVCCVLI_wrap_OnFocus);
function LDPQVCCVLI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LDPQVCCVLI',LDPQVCCVLI_wrap_OnKeyDown);
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
if (Eq(p_cEvent,'Before Save')) {
if (Ne(typeof(Calculation_BDPZYTDKPT),'undefined')) {
old_c=m_bCalculating;
m_bCalculating=true;
Calculation_BDPZYTDKPT();
m_bCalculating=old_c;
if ( ! (old_c)) {
DoUpdate(true);
}
}
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
FocusFirstComponent.edit={"page_1":["SNIXYTTVQQ"]};
FocusFirstComponent.query={"page_1":["BXPAETNPNW"]};
FocusFirstComponent.otherwise={"page_1":["BXPAETNPNW"]};
function Help() {
windowOpenForeground('../doc/spadministration_mobappstore_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_spadministration_dmobapp_qkm() {
SetModified();
}
function SetModified_spadministration_mobapppermissions() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_2')) {
if (ChildToLoad('OIOVQVCCYP')) {
LoadContext.lc(1,'OIOVQVCCYP');
} else {
LibJavascript.RefreshChildGrid('OIOVQVCCYP');
}
}
if (Eq(page,'page_3')) {
if (ChildToLoad('XNQZSXVGTN')) {
LoadContext.lc(1,'XNQZSXVGTN');
} else {
LibJavascript.RefreshChildGrid('XNQZSXVGTN');
}
}
}
function DeclareWVs() {
var a = arguments;
w_oa__code=a[0];
op_oa__code=a[1];
w_oaapppublished=a[2];
w_oareserved=a[3];
w_oaappmenu=a[4];
w_oaapptitle=a[5];
w_oadescri=a[6];
w_oaapplogo=a[7];
w_oaappfavico=a[8];
w_oaapplanding=a[9];
w_oaskinname=a[10];
w_oaappvariantname=a[11];
w_oaappheader=a[12];
w_oaappdescrheader=a[13];
w_oaapphideutilitygroup=a[14];
w_oaapphomelink=a[15];
w_oaappchecksum=a[16];
w_OAAPPACCESSMODE=a[17];
w_oaappdevtyp=a[18];
w_oaappreqreg=a[19];
w_oaappurlreg=a[20];
w_changeSkin=a[21];
w_combo_homelink=a[22];
w_custom_homelink=a[23];
w_forceCreateFile=a[24];
w_ignoreFile=a[25];
m_cWv_spadministration_dmobapp_qkm=a[26];
m_cWv_spadministration_mobapppermissions=a[27];
if (Gt(a.length,28)) {
m_cErrorInChild='';
}
if (Gt(a.length,28)) {
o_oaappreqreg=w_oaappreqreg;
}
m_PrimaryKeys=['oa__code'];
}
function i_PrimaryKey() {
return 'cpappstore'+'\\'+CPLib.ToCPStr(w_oa__code);
}
GetLinkPCKeys.set_o('spadministration_dmobapp_qkm',false);
GetLinkPCKeys.set_o('spadministration_mobapppermissions',false);
GetLinkPCKeys.o['spadministration_dmobapp_qkm']['QA_CODE']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_oa__code,'C');
}
}
GetLinkPCKeys.o['spadministration_mobapppermissions']['pecodice']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_oa__code,'C');
}
}
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('OIOVQVCCYP',function(){return FrameRef('spadministration_dmobapp_qkm')},1,'spadministration_dmobapp_qkm',0,2)
LoadContext.f('XNQZSXVGTN',function(){return FrameRef('spadministration_mobapppermissions')},1,'spadministration_mobapppermissions',0,3)
GetSelectedChildPage.child={'spadministration_dmobapp_qkm': function(){return FrameRef('spadministration_dmobapp_qkm')}, 'spadministration_mobapppermissions': function(){return FrameRef('spadministration_mobapppermissions')}}
function GetSelectedPage(p_d) {
p_d.setValue('spadministration_mobappstore',m_cSelectedPage);
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
_Obli('oa__code',0,'BXPAETNPNW',false,"831361452")
_Obli('oaapppublished',1,'SNIXYTTVQQ',false,"11080022524")
_Obli('oareserved',0,'ZLZSHHUAAO',false,"11473259823")
_Obli('oaappmenu',0,'HGEWTTQPUR',true,"994633243")
_Obli('oaapptitle',0,'DIVZDHWPRQ',false,"11321299471")
_Obli('oadescri',0,'XGINRSLGED',false,"1932338830")
_Obli('oaapplogo',0,'THXHMWDAPZ',false,"10728329812")
_Obli('oaappfavico',0,'QYLTLWYYSH',false,"10875327060")
_Obli('oaapplanding',0,'LHWJXXROEN',false,"1851159004")
_Obli('oaskinname',0,'UZJHJSBNKL',false,"5686444")
_Obli('changeSkin',4,'JKORHAZIKU',false)
_Obli('oaappvariantname',0,'LRTLIAYQMN',false,"2068761572")
_Obli('oaappheader',0,'MRNRGZRDQJ',false,"11215142635")
_Obli('oaappdescrheader',0,'CUOPMOHONZ',false,"1589847666")
_Obli('oaapphideutilitygroup',1,'DAMSKDIPPB',false,"527286826")
_Obli('oaapphomelink',0,'EYZZDYMIDO',false,"10330741240")
_Obli('combo_homelink',1,'LMGRJMFNAF',false,"2111909383")
_Obli('custom_homelink',0,'ZOTPWYUMVB',false)
_Obli('oaappchecksum',0,'GJRUFNPOQO',false,"1959402435")
_Obli('OAAPPACCESSMODE',0,'ZMJJCHDRPF',false,"10139844320")
_Obli('oaappdevtyp',0,'FBEIHIJGFG',false,"11403674860")
_Obli('oaappreqreg',1,'HRCRJRTGHT',false,"1301099432")
_Obli('oaappurlreg',0,'LDPQVCCVLI',false,"1097638194")
