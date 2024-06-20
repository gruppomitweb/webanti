function FillCombosValues() {
FillCombo('LYZAJWZGAM','LYZAJWZGAM');
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('PBPAZFLKHV',function(){return WtH(w_CODDIP,'C',6,0,'')},w_CODDIP);
SPBOUILib.SetInputValue('XCUHPGQTRL',function(){return WtH(w_DESCRIZ,'C',30,0,'')},w_DESCRIZ);
SPBOUILib.SetInputValue('JRSYWVEHIR',function(){return WtH(w_DOMICILIO,'C',50,0,'')},w_DOMICILIO);
SPBOUILib.SetInputValue('KQSLGVHSRE',function(){return WtH(w_CAP,'C',5,0,'')},w_CAP);
SPBOUILib.SetInputValue('AEZUFOYHTM',function(){return WtH(w_DESCCIT,'C',60,0,'')},w_DESCCIT);
SPBOUILib.SetInputValue('WBQFGTJCPW',function(){return WtH(w_PROVINCIA,'C',2,0,'')},w_PROVINCIA);
SPBOUILib.SetInputValue('FJRMKWPZIG',function(){return WtH(w_CAB,'C',6,0,'')},w_CAB);
if(c=Ctrl('WRIYZYCTBR')) ChkboxCheckUncheck(c,'S',w_AGENTE)
if(c=Ctrl('WRIYZYCTBR')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('BPQQBVFABO',function(){return WtH(w_MACROAGENTE,'C',5,0,'')},w_MACROAGENTE);
SPBOUILib.SetInputValue('RTLSPZPWWO',function(){return WtH(w_TERMINALID,'C',15,0,'')},w_TERMINALID);
var tmp_QJZAQQCYWJ = ToHTag(AsControlValue((Empty(w_xMADESCRI)?LRTrim(w_xMACOGNOME)+' '+LRTrim(w_xMANOME):LRTrim(w_xMADESCRI))));
if (Ne(e_QJZAQQCYWJ,tmp_QJZAQQCYWJ)) {
SPBOUILib.SetLabelValue('QJZAQQCYWJ','innerHTML',tmp_QJZAQQCYWJ);
e_QJZAQQCYWJ=tmp_QJZAQQCYWJ;
}
SPBOUILib.SetInputValue('WTENUNIUCY',function(){return WtH(w_IDBASE,'C',10,0,'')},w_IDBASE);
SPBOUILib.SetInputValue('CDMUQZYEAX',function(){return WtH(w_TELEFONO,'C',15,0,'')},w_TELEFONO);
SPBOUILib.SetInputValue('YTCIMOKXKS',function(){return WtH(w_ABICABSARA,'C',12,0,'')},w_ABICABSARA);
SPBOUILib.SetInputValue('NISBFWYVAN',function(){return WtH(w_AGACCODE,'C',10,0,'')},w_AGACCODE);
SPBOUILib.SetInputValue('SGDAQGMTNU',function(){return WtH(w_NAZAGENTE,'C',3,0,'')},w_NAZAGENTE);
var tmp_VNMKJRVPPS = ToHTag(AsControlValue(w_xDESCNAZ));
if (Ne(e_VNMKJRVPPS,tmp_VNMKJRVPPS)) {
SPBOUILib.SetLabelValue('VNMKJRVPPS','innerHTML',tmp_VNMKJRVPPS);
e_VNMKJRVPPS=tmp_VNMKJRVPPS;
}
if(c=Ctrl('KSBCZELDDB')) selectCombo(c,w_AGEREGIO,'C')
if(c=Ctrl('ECKDLHTTSN')) ChkboxCheckUncheck(c,'S',w_FLGATT)
if(c=Ctrl('ECKDLHTTSN')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('DUZIXALHHS',function(){return WtH(w_CODLOC,'C',25,0,'')},w_CODLOC);
SPBOUILib.SetInputValue('MOQMJLJJNI',function(){return WtH(w_CODAGE,'C',15,0,'')},w_CODAGE);
if(c=Ctrl('LYZAJWZGAM')) selectCombo(c,w_TIPOSV,'C')
if(c=Ctrl('NPJMZHJDRZ')) ChkboxCheckUncheck(c,'S',w_FLGNOAUA)
if(c=Ctrl('NPJMZHJDRZ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('PNZMYOKETI')) ChkboxCheckUncheck(c,'S',w_FLGWUPOS)
if(c=Ctrl('PNZMYOKETI')) ChkboxValueAssign(c,'S','N','C',1,0,'')
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
SPBOUILib.SetInputValue('JQLGHMLOKO',function(){return WtH(w_CATEG04,'C',2,0,'')},w_CATEG04);
var tmp_MWCFKQVNHF = ToHTag(AsControlValue(w_xC4DESCRI));
if (Ne(e_MWCFKQVNHF,tmp_MWCFKQVNHF)) {
SPBOUILib.SetLabelValue('MWCFKQVNHF','innerHTML',tmp_MWCFKQVNHF);
e_MWCFKQVNHF=tmp_MWCFKQVNHF;
}
SPBOUILib.SetInputValue('QVBZSFMTVP',function(){return WtH(w_CATEG05,'C',2,0,'')},w_CATEG05);
var tmp_HADVHTQAPE = ToHTag(AsControlValue(w_xC5DESCRI));
if (Ne(e_HADVHTQAPE,tmp_HADVHTQAPE)) {
SPBOUILib.SetLabelValue('HADVHTQAPE','innerHTML',tmp_HADVHTQAPE);
e_HADVHTQAPE=tmp_HADVHTQAPE;
}
SPBOUILib.SetInputValue('ICGUZGYXTD',function(){return WtH(w_CATEG01,'C',2,0,'')},w_CATEG01);
SPBOUILib.SetInputValue('TGQHYPERED',function(){return WtH(w_CATEG02,'C',2,0,'')},w_CATEG02);
SPBOUILib.SetInputValue('QRJNKZVHDW',function(){return WtH(w_CATEG03,'C',2,0,'')},w_CATEG03);
SPBOUILib.SetInputValue('IOZYXJKYDX',function(){return WtH(w_CAB2,'C',6,0,'')},w_CAB2);
SPBOUILib.SetInputValue('VYZSOTTSWB',function(){return WtH(w_CODICEAAMS,'C',12,0,'')},w_CODICEAAMS);
SPBOUILib.SetInputValue('JJJFDTJFAK',function(){return WtH(w_CONCESSIONE,'C',10,0,'')},w_CONCESSIONE);
SPBOUILib.SetInputValue('ACTQHMCVYK',function(){return WtH(w_CODFISC,'C',16,0,'')},w_CODFISC);
SPBOUILib.SetInputValue('RTWJYVXECF',function(){return WtH(w_PARTIVA,'C',11,0,'')},w_PARTIVA);
if(c=Ctrl('ACDLDQVQXS')) selectCombo(c,w_TIPOAGENTE,'C')
SPBOUILib.SetInputValue('PWMWPIWKXR',function(){return WtH(w_NUMCIVICO,'C',15,0,'')},w_NUMCIVICO);
if(c=Ctrl('VKYZPROJCI')) ChkboxCheckUncheck(c,'S',w_SERRIMDEN)
if(c=Ctrl('VKYZPROJCI')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('OSJJWSZMDE',function(){return WtH(w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAINI);
SPBOUILib.SetInputValue('QDGOPSCQNI',function(){return WtH(w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAFINE);
if(c=Ctrl('DVNRBUBGST')) ChkboxCheckUncheck(c,1,w_FLGCOMPL)
if(c=Ctrl('DVNRBUBGST')) ChkboxValueAssign(c,1,0,'N',1,0,'')
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay('UBUBESGOCL_DIV',IsHiddenByStateDriver('DatiBase'));
Z.Tabs.Get("tabs_1_Dati").Hide('OQJXMMCZQK',Ne(w_gTipInter,'15') && Ne(w_gFlgWU,'S') || IsHiddenByStateDriver('DatiAdd'));
SetDisplay(Ctrl('RTLSPZPWWO'),Ne(w_gFlgWU,'S') || IsHiddenByStateDriver('TERMINALID'));
SetDisplay(Ctrl('WRCFGXMASK'),Ne(w_gFlgWU,'S'));
SetDisplay(Ctrl('MOQMJLJJNI'),Ne(w_gAgeCGO,'S') || IsHiddenByStateDriver('CODAGE'));
SetDisplay(Ctrl('MRGPZXPZJX'),Ne(w_gAgeCGO,'S'));
SetDisplay('NPJMZHJDRZ_DIV',Ne(w_gFlgWU,'S'));
SetDisplay('PNZMYOKETI_DIV',Ne(w_gFlgWU,'S'));
Z.Tabs.Get("tabs_1_Dati").Hide('RFAIYHSGII',IsHiddenByStateDriver('Rischio'));
Z.Tabs.Get("tabs_1_Dati").Hide('SJOTYLCKUC',IsHiddenByStateDriver('Dati SARA/SV'));
Z.Tabs.Get("tabs_1_Dati").Hide('DKPWIMNYIB',IsHiddenByStateDriver('Preposti'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["ABICABSARA"]=['LRAFMUSNIS'];
HideUI.lblids["AGACCODE"]=['ECJVBPLVAM'];
HideUI.lblids["AGEREGIO"]=['SFACPNQMFC'];
HideUI.lblids["CAB"]=['XFSMURLNKN'];
HideUI.lblids["CAB2"]=['LJFDSMRYHQ'];
HideUI.lblids["CAP"]=['TTSBPIZZEM'];
HideUI.lblids["CATEG01"]=['WWRYOVTMFY'];
HideUI.lblids["CATEG02"]=['HNQZARYXGS'];
HideUI.lblids["CATEG03"]=['BGEVFUGGOS'];
HideUI.lblids["CATEG04"]=['RHXCIUHRTU'];
HideUI.lblids["CATEG05"]=['GRCYFEKJWU'];
HideUI.lblids["CODAGE"]=['MRGPZXPZJX'];
HideUI.lblids["CODDIP"]=['RBRNYGGGZL'];
HideUI.lblids["CODFISC"]=['LLXHZULQLI'];
HideUI.lblids["CODICEAAMS"]=['XKQHBHHNKD'];
HideUI.lblids["CODLOC"]=['KPEKMJMQUX'];
HideUI.lblids["CONCESSIONE"]=['BGLJJMTOYA'];
HideUI.lblids["DATAFINE"]=['XHVKTYTVYI'];
HideUI.lblids["DATAINI"]=['MDCCDZNMIV'];
HideUI.lblids["DESCCIT"]=['BMQWNHMESL'];
HideUI.lblids["DESCRIZ"]=['HSCGRBUSWT'];
HideUI.lblids["DOMICILIO"]=['LGDVILSMPZ'];
HideUI.lblids["IDBASE"]=['FOXBQNQVXR'];
HideUI.lblids["MACROAGENTE"]=['BUKDXBSGHV'];
HideUI.lblids["NAZAGENTE"]=['SARKHBDBSW'];
HideUI.lblids["NUMCIVICO"]=['NFTCHEJXHV'];
HideUI.lblids["PARTIVA"]=['FDEKGGVCSR'];
HideUI.lblids["PROVINCIA"]=['GVPDXVYAAR'];
HideUI.lblids["TELEFONO"]=['RASTVMTGDB'];
HideUI.lblids["TERMINALID"]=['WRCFGXMASK'];
HideUI.lblids["TIPOAGENTE"]=['ZMFFOLWFAF'];
HideUI.lblids["TIPOSV"]=['EXFKQPWTSQ'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function PBPAZFLKHV_Valid(e) {
SetActiveField(Ctrl('PBPAZFLKHV'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('PBPAZFLKHV') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODDIP','C',w_CODDIP,HtW(Ctrl('PBPAZFLKHV').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODDIP(HtW(Ctrl('PBPAZFLKHV').value,'C'),null,e);
return l_bSetResult;
}
}
function PBPAZFLKHV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PBPAZFLKHV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PBPAZFLKHV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PBPAZFLKHV'),e);
}
function XCUHPGQTRL_Valid(e) {
SetActiveField(Ctrl('XCUHPGQTRL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRIZ','C',w_DESCRIZ,HtW(Ctrl('XCUHPGQTRL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRIZ(HtW(Ctrl('XCUHPGQTRL').value,'C'),null,e);
return l_bSetResult;
}
}
function XCUHPGQTRL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XCUHPGQTRL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XCUHPGQTRL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XCUHPGQTRL'),e);
}
function JRSYWVEHIR_Valid(e) {
SetActiveField(Ctrl('JRSYWVEHIR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DOMICILIO','C',w_DOMICILIO,HtW(Ctrl('JRSYWVEHIR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DOMICILIO(HtW(Ctrl('JRSYWVEHIR').value,'C'),null,e);
return l_bSetResult;
}
}
function JRSYWVEHIR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JRSYWVEHIR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JRSYWVEHIR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JRSYWVEHIR'),e);
}
function KQSLGVHSRE_Valid(e) {
SetActiveField(Ctrl('KQSLGVHSRE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CAP','C',w_CAP,HtW(Ctrl('KQSLGVHSRE').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAP(HtW(Ctrl('KQSLGVHSRE').value,'C'),null,e);
return l_bSetResult;
}
}
function KQSLGVHSRE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KQSLGVHSRE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KQSLGVHSRE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KQSLGVHSRE'),e);
}
function AEZUFOYHTM_Valid(e) {
SetActiveField(Ctrl('AEZUFOYHTM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCCIT','C',w_DESCCIT,HtW(Ctrl('AEZUFOYHTM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCCIT(HtW(Ctrl('AEZUFOYHTM').value,'C'),null,e);
return l_bSetResult;
}
}
function AEZUFOYHTM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AEZUFOYHTM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('AEZUFOYHTM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AEZUFOYHTM'),e);
}
function AEZUFOYHTM_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('AEZUFOYHTM')),'linkview_AEZUFOYHTM','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function WRIYZYCTBR_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('AGENTE','C',w_AGENTE,ChkboxValueAssign(Ctrl('WRIYZYCTBR'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_AGENTE(ChkboxValueAssign(Ctrl('WRIYZYCTBR'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function WRIYZYCTBR_OnFocus(e) {
SetActiveField(Ctrl('WRIYZYCTBR'),true);
}
function WRIYZYCTBR_OnBlur(e) {
SetActiveField(Ctrl('WRIYZYCTBR'),false);
}
function BPQQBVFABO_Valid(e) {
SetActiveField(Ctrl('BPQQBVFABO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('MACROAGENTE','C',w_MACROAGENTE,HtW(Ctrl('BPQQBVFABO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_MACROAGENTE(HtW(Ctrl('BPQQBVFABO').value,'C'),null,e);
return l_bSetResult;
}
}
function BPQQBVFABO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BPQQBVFABO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BPQQBVFABO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BPQQBVFABO'),e);
}
function BPQQBVFABO_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('BPQQBVFABO')),'linkview_BPQQBVFABO','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function RTLSPZPWWO_Valid(e) {
SetActiveField(Ctrl('RTLSPZPWWO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TERMINALID','C',w_TERMINALID,HtW(Ctrl('RTLSPZPWWO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TERMINALID(HtW(Ctrl('RTLSPZPWWO').value,'C'),null,e);
return l_bSetResult;
}
}
function RTLSPZPWWO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RTLSPZPWWO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RTLSPZPWWO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RTLSPZPWWO'),e);
}
function WTENUNIUCY_Valid(e) {
SetActiveField(Ctrl('WTENUNIUCY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDBASE','C',w_IDBASE,HtW(Ctrl('WTENUNIUCY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDBASE(HtW(Ctrl('WTENUNIUCY').value,'C'),null,e);
return l_bSetResult;
}
}
function WTENUNIUCY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WTENUNIUCY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('WTENUNIUCY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WTENUNIUCY'),e);
}
function CDMUQZYEAX_Valid(e) {
SetActiveField(Ctrl('CDMUQZYEAX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TELEFONO','C',w_TELEFONO,HtW(Ctrl('CDMUQZYEAX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TELEFONO(HtW(Ctrl('CDMUQZYEAX').value,'C'),null,e);
return l_bSetResult;
}
}
function CDMUQZYEAX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CDMUQZYEAX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CDMUQZYEAX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CDMUQZYEAX'),e);
}
function YTCIMOKXKS_Valid(e) {
SetActiveField(Ctrl('YTCIMOKXKS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ABICABSARA','C',w_ABICABSARA,HtW(Ctrl('YTCIMOKXKS').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ABICABSARA(HtW(Ctrl('YTCIMOKXKS').value,'C'),null,e);
return l_bSetResult;
}
}
function YTCIMOKXKS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YTCIMOKXKS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YTCIMOKXKS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YTCIMOKXKS'),e);
}
function NISBFWYVAN_Valid(e) {
SetActiveField(Ctrl('NISBFWYVAN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('AGACCODE','C',w_AGACCODE,HtW(Ctrl('NISBFWYVAN').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_AGACCODE(HtW(Ctrl('NISBFWYVAN').value,'C'),null,e);
return l_bSetResult;
}
}
function NISBFWYVAN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NISBFWYVAN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NISBFWYVAN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NISBFWYVAN'),e);
}
function SGDAQGMTNU_Valid(e) {
SetActiveField(Ctrl('SGDAQGMTNU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NAZAGENTE','C',w_NAZAGENTE,HtW(Ctrl('SGDAQGMTNU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NAZAGENTE(HtW(Ctrl('SGDAQGMTNU').value,'C'),null,e);
return l_bSetResult;
}
}
function SGDAQGMTNU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SGDAQGMTNU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SGDAQGMTNU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SGDAQGMTNU'),e);
}
function SGDAQGMTNU_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('SGDAQGMTNU')),'linkview_SGDAQGMTNU','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function KSBCZELDDB_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('AGEREGIO','C',w_AGEREGIO,HtW(getComboValue(Ctrl('KSBCZELDDB')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_AGEREGIO(HtW(getComboValue(Ctrl('KSBCZELDDB')),'C'),null,e);
return l_bSetResult;
}
}
function KSBCZELDDB_OnFocus(e) {
SetActiveField(Ctrl('KSBCZELDDB'),true);
}
function KSBCZELDDB_OnBlur(e) {
SetActiveField(Ctrl('KSBCZELDDB'),false);
}
function ECKDLHTTSN_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGATT','C',w_FLGATT,ChkboxValueAssign(Ctrl('ECKDLHTTSN'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGATT(ChkboxValueAssign(Ctrl('ECKDLHTTSN'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function ECKDLHTTSN_OnFocus(e) {
SetActiveField(Ctrl('ECKDLHTTSN'),true);
}
function ECKDLHTTSN_OnBlur(e) {
SetActiveField(Ctrl('ECKDLHTTSN'),false);
}
function DUZIXALHHS_Valid(e) {
SetActiveField(Ctrl('DUZIXALHHS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODLOC','C',w_CODLOC,HtW(Ctrl('DUZIXALHHS').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODLOC(HtW(Ctrl('DUZIXALHHS').value,'C'),null,e);
return l_bSetResult;
}
}
function DUZIXALHHS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DUZIXALHHS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DUZIXALHHS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DUZIXALHHS'),e);
}
function MOQMJLJJNI_Valid(e) {
SetActiveField(Ctrl('MOQMJLJJNI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODAGE','C',w_CODAGE,HtW(Ctrl('MOQMJLJJNI').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODAGE(HtW(Ctrl('MOQMJLJJNI').value,'C'),null,e);
return l_bSetResult;
}
}
function MOQMJLJJNI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MOQMJLJJNI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MOQMJLJJNI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MOQMJLJJNI'),e);
}
function LYZAJWZGAM_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOSV','C',w_TIPOSV,HtW(getComboValue(Ctrl('LYZAJWZGAM')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOSV(HtW(getComboValue(Ctrl('LYZAJWZGAM')),'C'),null,e);
return l_bSetResult;
}
}
function LYZAJWZGAM_OnFocus(e) {
SetActiveField(Ctrl('LYZAJWZGAM'),true);
}
function LYZAJWZGAM_OnBlur(e) {
SetActiveField(Ctrl('LYZAJWZGAM'),false);
}
function NPJMZHJDRZ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGNOAUA','C',w_FLGNOAUA,ChkboxValueAssign(Ctrl('NPJMZHJDRZ'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGNOAUA(ChkboxValueAssign(Ctrl('NPJMZHJDRZ'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function NPJMZHJDRZ_OnFocus(e) {
SetActiveField(Ctrl('NPJMZHJDRZ'),true);
}
function NPJMZHJDRZ_OnBlur(e) {
SetActiveField(Ctrl('NPJMZHJDRZ'),false);
}
function PNZMYOKETI_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGWUPOS','C',w_FLGWUPOS,ChkboxValueAssign(Ctrl('PNZMYOKETI'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGWUPOS(ChkboxValueAssign(Ctrl('PNZMYOKETI'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function PNZMYOKETI_OnFocus(e) {
SetActiveField(Ctrl('PNZMYOKETI'),true);
}
function PNZMYOKETI_OnBlur(e) {
SetActiveField(Ctrl('PNZMYOKETI'),false);
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
function ICGUZGYXTD_Valid(e) {
SetActiveField(Ctrl('ICGUZGYXTD'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CATEG01','C',w_CATEG01,HtW(Ctrl('ICGUZGYXTD').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CATEG01(HtW(Ctrl('ICGUZGYXTD').value,'C'),null,e);
return l_bSetResult;
}
}
function ICGUZGYXTD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ICGUZGYXTD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ICGUZGYXTD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ICGUZGYXTD'),e);
}
function ICGUZGYXTD_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('ICGUZGYXTD')),'linkview_ICGUZGYXTD','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function TGQHYPERED_Valid(e) {
SetActiveField(Ctrl('TGQHYPERED'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CATEG02','C',w_CATEG02,HtW(Ctrl('TGQHYPERED').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CATEG02(HtW(Ctrl('TGQHYPERED').value,'C'),null,e);
return l_bSetResult;
}
}
function TGQHYPERED_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TGQHYPERED'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TGQHYPERED'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TGQHYPERED'),e);
}
function TGQHYPERED_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('TGQHYPERED')),'linkview_TGQHYPERED','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function QRJNKZVHDW_Valid(e) {
SetActiveField(Ctrl('QRJNKZVHDW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CATEG03','C',w_CATEG03,HtW(Ctrl('QRJNKZVHDW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CATEG03(HtW(Ctrl('QRJNKZVHDW').value,'C'),null,e);
return l_bSetResult;
}
}
function QRJNKZVHDW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QRJNKZVHDW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QRJNKZVHDW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QRJNKZVHDW'),e);
}
function QRJNKZVHDW_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('QRJNKZVHDW')),'linkview_QRJNKZVHDW','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function IOZYXJKYDX_Valid(e) {
SetActiveField(Ctrl('IOZYXJKYDX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CAB2','C',w_CAB2,HtW(Ctrl('IOZYXJKYDX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAB2(HtW(Ctrl('IOZYXJKYDX').value,'C'),null,e);
return l_bSetResult;
}
}
function IOZYXJKYDX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IOZYXJKYDX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IOZYXJKYDX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IOZYXJKYDX'),e);
}
function VYZSOTTSWB_Valid(e) {
SetActiveField(Ctrl('VYZSOTTSWB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODICEAAMS','C',w_CODICEAAMS,HtW(Ctrl('VYZSOTTSWB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODICEAAMS(HtW(Ctrl('VYZSOTTSWB').value,'C'),null,e);
return l_bSetResult;
}
}
function VYZSOTTSWB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VYZSOTTSWB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VYZSOTTSWB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VYZSOTTSWB'),e);
}
function JJJFDTJFAK_Valid(e) {
SetActiveField(Ctrl('JJJFDTJFAK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CONCESSIONE','C',w_CONCESSIONE,HtW(Ctrl('JJJFDTJFAK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONCESSIONE(HtW(Ctrl('JJJFDTJFAK').value,'C'),null,e);
return l_bSetResult;
}
}
function JJJFDTJFAK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JJJFDTJFAK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JJJFDTJFAK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JJJFDTJFAK'),e);
}
function ACTQHMCVYK_Valid(e) {
SetActiveField(Ctrl('ACTQHMCVYK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODFISC','C',w_CODFISC,HtW(Ctrl('ACTQHMCVYK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODFISC(HtW(Ctrl('ACTQHMCVYK').value,'C'),null,e);
return l_bSetResult;
}
}
function ACTQHMCVYK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ACTQHMCVYK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ACTQHMCVYK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ACTQHMCVYK'),e);
}
function RTWJYVXECF_Valid(e) {
SetActiveField(Ctrl('RTWJYVXECF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PARTIVA','C',w_PARTIVA,HtW(Ctrl('RTWJYVXECF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PARTIVA(HtW(Ctrl('RTWJYVXECF').value,'C'),null,e);
return l_bSetResult;
}
}
function RTWJYVXECF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RTWJYVXECF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RTWJYVXECF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RTWJYVXECF'),e);
}
function ACDLDQVQXS_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOAGENTE','C',w_TIPOAGENTE,HtW(getComboValue(Ctrl('ACDLDQVQXS')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOAGENTE(HtW(getComboValue(Ctrl('ACDLDQVQXS')),'C'),null,e);
return l_bSetResult;
}
}
function ACDLDQVQXS_OnFocus(e) {
SetActiveField(Ctrl('ACDLDQVQXS'),true);
}
function ACDLDQVQXS_OnBlur(e) {
SetActiveField(Ctrl('ACDLDQVQXS'),false);
}
function PWMWPIWKXR_Valid(e) {
SetActiveField(Ctrl('PWMWPIWKXR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NUMCIVICO','C',w_NUMCIVICO,HtW(Ctrl('PWMWPIWKXR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NUMCIVICO(HtW(Ctrl('PWMWPIWKXR').value,'C'),null,e);
return l_bSetResult;
}
}
function PWMWPIWKXR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PWMWPIWKXR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PWMWPIWKXR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PWMWPIWKXR'),e);
}
function VKYZPROJCI_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('SERRIMDEN','C',w_SERRIMDEN,ChkboxValueAssign(Ctrl('VKYZPROJCI'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SERRIMDEN(ChkboxValueAssign(Ctrl('VKYZPROJCI'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function VKYZPROJCI_OnFocus(e) {
SetActiveField(Ctrl('VKYZPROJCI'),true);
}
function VKYZPROJCI_OnBlur(e) {
SetActiveField(Ctrl('VKYZPROJCI'),false);
}
function OSJJWSZMDE_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('OSJJWSZMDE'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('OSJJWSZMDE').value=ApplyPictureToDate(Ctrl('OSJJWSZMDE').value,TranslatePicture(datePattern),'OSJJWSZMDE');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('OSJJWSZMDE'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('OSJJWSZMDE');
}
}
}
SetActiveField(Ctrl('OSJJWSZMDE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAINI','D',w_DATAINI,HtW(Ctrl('OSJJWSZMDE').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAINI(HtW(Ctrl('OSJJWSZMDE').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function OSJJWSZMDE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OSJJWSZMDE'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('OSJJWSZMDE',w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('OSJJWSZMDE');
SetActiveField(Ctrl('OSJJWSZMDE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OSJJWSZMDE'),e);
}
function OSJJWSZMDE_ZOOM_Click() {
LaunchCalendar(Ctrl('OSJJWSZMDE'));
}
function QDGOPSCQNI_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('QDGOPSCQNI'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('QDGOPSCQNI').value=ApplyPictureToDate(Ctrl('QDGOPSCQNI').value,TranslatePicture(datePattern),'QDGOPSCQNI');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('QDGOPSCQNI'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('QDGOPSCQNI');
}
}
}
SetActiveField(Ctrl('QDGOPSCQNI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAFINE','D',w_DATAFINE,HtW(Ctrl('QDGOPSCQNI').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAFINE(HtW(Ctrl('QDGOPSCQNI').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function QDGOPSCQNI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QDGOPSCQNI'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('QDGOPSCQNI',w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('QDGOPSCQNI');
SetActiveField(Ctrl('QDGOPSCQNI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QDGOPSCQNI'),e);
}
function QDGOPSCQNI_ZOOM_Click() {
LaunchCalendar(Ctrl('QDGOPSCQNI'));
}
function DVNRBUBGST_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGCOMPL','N',w_FLGCOMPL,ChkboxValueAssign(Ctrl('DVNRBUBGST'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGCOMPL(ChkboxValueAssign(Ctrl('DVNRBUBGST'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function DVNRBUBGST_OnFocus(e) {
SetActiveField(Ctrl('DVNRBUBGST'),true);
}
function DVNRBUBGST_OnBlur(e) {
SetActiveField(Ctrl('DVNRBUBGST'),false);
}
linkpc_url.u('ZBFNRFHLSE',function(){return 'ardt_dippreposti?m_bInnerChild=true'+GetLinkPCKeys('ardt_dippreposti')+'&m_bRowsChild='+EnableChild('ardt_dippreposti')})
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function PBPAZFLKHV_wrap_Valid(event) {
return PBPAZFLKHV_Valid(event);
}
SPBOUILib.SetInputExit('PBPAZFLKHV',PBPAZFLKHV_wrap_Valid);
function PBPAZFLKHV_wrap_OnFocus(event) {
return PBPAZFLKHV_OnFocus(event);
}
SPBOUILib.SetInputEnter('PBPAZFLKHV',PBPAZFLKHV_wrap_OnFocus);
function PBPAZFLKHV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PBPAZFLKHV',PBPAZFLKHV_wrap_OnKeyDown);
function XCUHPGQTRL_wrap_Valid(event) {
return XCUHPGQTRL_Valid(event);
}
SPBOUILib.SetInputExit('XCUHPGQTRL',XCUHPGQTRL_wrap_Valid);
function XCUHPGQTRL_wrap_OnFocus(event) {
return XCUHPGQTRL_OnFocus(event);
}
SPBOUILib.SetInputEnter('XCUHPGQTRL',XCUHPGQTRL_wrap_OnFocus);
function XCUHPGQTRL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XCUHPGQTRL',XCUHPGQTRL_wrap_OnKeyDown);
function JRSYWVEHIR_wrap_Valid(event) {
return JRSYWVEHIR_Valid(event);
}
SPBOUILib.SetInputExit('JRSYWVEHIR',JRSYWVEHIR_wrap_Valid);
function JRSYWVEHIR_wrap_OnFocus(event) {
return JRSYWVEHIR_OnFocus(event);
}
SPBOUILib.SetInputEnter('JRSYWVEHIR',JRSYWVEHIR_wrap_OnFocus);
function JRSYWVEHIR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JRSYWVEHIR',JRSYWVEHIR_wrap_OnKeyDown);
function KQSLGVHSRE_wrap_Valid(event) {
return KQSLGVHSRE_Valid(event);
}
SPBOUILib.SetInputExit('KQSLGVHSRE',KQSLGVHSRE_wrap_Valid);
function KQSLGVHSRE_wrap_OnFocus(event) {
return KQSLGVHSRE_OnFocus(event);
}
SPBOUILib.SetInputEnter('KQSLGVHSRE',KQSLGVHSRE_wrap_OnFocus);
function KQSLGVHSRE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KQSLGVHSRE',KQSLGVHSRE_wrap_OnKeyDown);
function AEZUFOYHTM_wrap_Valid(event) {
return AEZUFOYHTM_Valid(event);
}
SPBOUILib.SetInputExit('AEZUFOYHTM',AEZUFOYHTM_wrap_Valid);
function AEZUFOYHTM_wrap_OnFocus(event) {
return AEZUFOYHTM_OnFocus(event);
}
SPBOUILib.SetInputEnter('AEZUFOYHTM',AEZUFOYHTM_wrap_OnFocus);
function AEZUFOYHTM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AEZUFOYHTM',AEZUFOYHTM_wrap_OnKeyDown);
function AEZUFOYHTM_ZOOM_setHandlers() {
function AEZUFOYHTM_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?AEZUFOYHTM_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('AEZUFOYHTM_ZOOM',AEZUFOYHTM_ZOOM_wrap_OnClick);
function AEZUFOYHTM_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('AEZUFOYHTM_ZOOM',AEZUFOYHTM_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('AEZUFOYHTM',AEZUFOYHTM_ZOOM_setHandlers);
function WRIYZYCTBR_wrap_Valid(event) {
return WRIYZYCTBR_Valid(event);
}
SPBOUILib.SetCheckboxClick('WRIYZYCTBR',WRIYZYCTBR_wrap_Valid);
function WRIYZYCTBR_wrap_OnFocus(event) {
return WRIYZYCTBR_OnFocus(event);
}
SPBOUILib.SetInputEnter('WRIYZYCTBR',WRIYZYCTBR_wrap_OnFocus);
function WRIYZYCTBR_wrap_Blur(event) {
return WRIYZYCTBR_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('WRIYZYCTBR',WRIYZYCTBR_wrap_Blur);
function BPQQBVFABO_wrap_Valid(event) {
return BPQQBVFABO_Valid(event);
}
SPBOUILib.SetInputExit('BPQQBVFABO',BPQQBVFABO_wrap_Valid);
function BPQQBVFABO_wrap_OnFocus(event) {
return BPQQBVFABO_OnFocus(event);
}
SPBOUILib.SetInputEnter('BPQQBVFABO',BPQQBVFABO_wrap_OnFocus);
function BPQQBVFABO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BPQQBVFABO',BPQQBVFABO_wrap_OnKeyDown);
function BPQQBVFABO_ZOOM_setHandlers() {
function BPQQBVFABO_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?BPQQBVFABO_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('BPQQBVFABO_ZOOM',BPQQBVFABO_ZOOM_wrap_OnClick);
function BPQQBVFABO_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('BPQQBVFABO_ZOOM',BPQQBVFABO_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('BPQQBVFABO',BPQQBVFABO_ZOOM_setHandlers);
function RTLSPZPWWO_wrap_Valid(event) {
return RTLSPZPWWO_Valid(event);
}
SPBOUILib.SetInputExit('RTLSPZPWWO',RTLSPZPWWO_wrap_Valid);
function RTLSPZPWWO_wrap_OnFocus(event) {
return RTLSPZPWWO_OnFocus(event);
}
SPBOUILib.SetInputEnter('RTLSPZPWWO',RTLSPZPWWO_wrap_OnFocus);
function RTLSPZPWWO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RTLSPZPWWO',RTLSPZPWWO_wrap_OnKeyDown);
function WTENUNIUCY_wrap_Valid(event) {
return WTENUNIUCY_Valid(event);
}
SPBOUILib.SetInputExit('WTENUNIUCY',WTENUNIUCY_wrap_Valid);
function WTENUNIUCY_wrap_OnFocus(event) {
return WTENUNIUCY_OnFocus(event);
}
SPBOUILib.SetInputEnter('WTENUNIUCY',WTENUNIUCY_wrap_OnFocus);
function WTENUNIUCY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WTENUNIUCY',WTENUNIUCY_wrap_OnKeyDown);
function CDMUQZYEAX_wrap_Valid(event) {
return CDMUQZYEAX_Valid(event);
}
SPBOUILib.SetInputExit('CDMUQZYEAX',CDMUQZYEAX_wrap_Valid);
function CDMUQZYEAX_wrap_OnFocus(event) {
return CDMUQZYEAX_OnFocus(event);
}
SPBOUILib.SetInputEnter('CDMUQZYEAX',CDMUQZYEAX_wrap_OnFocus);
function CDMUQZYEAX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CDMUQZYEAX',CDMUQZYEAX_wrap_OnKeyDown);
function YTCIMOKXKS_wrap_Valid(event) {
return YTCIMOKXKS_Valid(event);
}
SPBOUILib.SetInputExit('YTCIMOKXKS',YTCIMOKXKS_wrap_Valid);
function YTCIMOKXKS_wrap_OnFocus(event) {
return YTCIMOKXKS_OnFocus(event);
}
SPBOUILib.SetInputEnter('YTCIMOKXKS',YTCIMOKXKS_wrap_OnFocus);
function YTCIMOKXKS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YTCIMOKXKS',YTCIMOKXKS_wrap_OnKeyDown);
function NISBFWYVAN_wrap_Valid(event) {
return NISBFWYVAN_Valid(event);
}
SPBOUILib.SetInputExit('NISBFWYVAN',NISBFWYVAN_wrap_Valid);
function NISBFWYVAN_wrap_OnFocus(event) {
return NISBFWYVAN_OnFocus(event);
}
SPBOUILib.SetInputEnter('NISBFWYVAN',NISBFWYVAN_wrap_OnFocus);
function NISBFWYVAN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NISBFWYVAN',NISBFWYVAN_wrap_OnKeyDown);
function SGDAQGMTNU_wrap_Valid(event) {
return SGDAQGMTNU_Valid(event);
}
SPBOUILib.SetInputExit('SGDAQGMTNU',SGDAQGMTNU_wrap_Valid);
function SGDAQGMTNU_wrap_OnFocus(event) {
return SGDAQGMTNU_OnFocus(event);
}
SPBOUILib.SetInputEnter('SGDAQGMTNU',SGDAQGMTNU_wrap_OnFocus);
function SGDAQGMTNU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SGDAQGMTNU',SGDAQGMTNU_wrap_OnKeyDown);
function SGDAQGMTNU_ZOOM_setHandlers() {
function SGDAQGMTNU_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?SGDAQGMTNU_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('SGDAQGMTNU_ZOOM',SGDAQGMTNU_ZOOM_wrap_OnClick);
function SGDAQGMTNU_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('SGDAQGMTNU_ZOOM',SGDAQGMTNU_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('SGDAQGMTNU',SGDAQGMTNU_ZOOM_setHandlers);
function KSBCZELDDB_wrap_Valid(event) {
return KSBCZELDDB_Valid(event);
}
SPBOUILib.SetComboChange('KSBCZELDDB',KSBCZELDDB_wrap_Valid);
function KSBCZELDDB_wrap_OnFocus(event) {
return KSBCZELDDB_OnFocus(event);
}
SPBOUILib.SetInputEnter('KSBCZELDDB',KSBCZELDDB_wrap_OnFocus);
function KSBCZELDDB_wrap_Blur(event) {
return KSBCZELDDB_OnBlur(event);
}
SPBOUILib.SetInputExit('KSBCZELDDB',KSBCZELDDB_wrap_Blur);
function ECKDLHTTSN_wrap_Valid(event) {
return ECKDLHTTSN_Valid(event);
}
SPBOUILib.SetCheckboxClick('ECKDLHTTSN',ECKDLHTTSN_wrap_Valid);
function ECKDLHTTSN_wrap_OnFocus(event) {
return ECKDLHTTSN_OnFocus(event);
}
SPBOUILib.SetInputEnter('ECKDLHTTSN',ECKDLHTTSN_wrap_OnFocus);
function ECKDLHTTSN_wrap_Blur(event) {
return ECKDLHTTSN_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('ECKDLHTTSN',ECKDLHTTSN_wrap_Blur);
function DUZIXALHHS_wrap_Valid(event) {
return DUZIXALHHS_Valid(event);
}
SPBOUILib.SetInputExit('DUZIXALHHS',DUZIXALHHS_wrap_Valid);
function DUZIXALHHS_wrap_OnFocus(event) {
return DUZIXALHHS_OnFocus(event);
}
SPBOUILib.SetInputEnter('DUZIXALHHS',DUZIXALHHS_wrap_OnFocus);
function DUZIXALHHS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DUZIXALHHS',DUZIXALHHS_wrap_OnKeyDown);
function MOQMJLJJNI_wrap_Valid(event) {
return MOQMJLJJNI_Valid(event);
}
SPBOUILib.SetInputExit('MOQMJLJJNI',MOQMJLJJNI_wrap_Valid);
function MOQMJLJJNI_wrap_OnFocus(event) {
return MOQMJLJJNI_OnFocus(event);
}
SPBOUILib.SetInputEnter('MOQMJLJJNI',MOQMJLJJNI_wrap_OnFocus);
function MOQMJLJJNI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MOQMJLJJNI',MOQMJLJJNI_wrap_OnKeyDown);
function LYZAJWZGAM_wrap_Valid(event) {
return LYZAJWZGAM_Valid(event);
}
SPBOUILib.SetComboChange('LYZAJWZGAM',LYZAJWZGAM_wrap_Valid);
function LYZAJWZGAM_wrap_OnFocus(event) {
return LYZAJWZGAM_OnFocus(event);
}
SPBOUILib.SetInputEnter('LYZAJWZGAM',LYZAJWZGAM_wrap_OnFocus);
function LYZAJWZGAM_wrap_Blur(event) {
return LYZAJWZGAM_OnBlur(event);
}
SPBOUILib.SetInputExit('LYZAJWZGAM',LYZAJWZGAM_wrap_Blur);
function NPJMZHJDRZ_wrap_Valid(event) {
return NPJMZHJDRZ_Valid(event);
}
SPBOUILib.SetCheckboxClick('NPJMZHJDRZ',NPJMZHJDRZ_wrap_Valid);
function NPJMZHJDRZ_wrap_OnFocus(event) {
return NPJMZHJDRZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('NPJMZHJDRZ',NPJMZHJDRZ_wrap_OnFocus);
function NPJMZHJDRZ_wrap_Blur(event) {
return NPJMZHJDRZ_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('NPJMZHJDRZ',NPJMZHJDRZ_wrap_Blur);
function PNZMYOKETI_wrap_Valid(event) {
return PNZMYOKETI_Valid(event);
}
SPBOUILib.SetCheckboxClick('PNZMYOKETI',PNZMYOKETI_wrap_Valid);
function PNZMYOKETI_wrap_OnFocus(event) {
return PNZMYOKETI_OnFocus(event);
}
SPBOUILib.SetInputEnter('PNZMYOKETI',PNZMYOKETI_wrap_OnFocus);
function PNZMYOKETI_wrap_Blur(event) {
return PNZMYOKETI_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('PNZMYOKETI',PNZMYOKETI_wrap_Blur);
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
function ICGUZGYXTD_wrap_Valid(event) {
return ICGUZGYXTD_Valid(event);
}
SPBOUILib.SetInputExit('ICGUZGYXTD',ICGUZGYXTD_wrap_Valid);
function ICGUZGYXTD_wrap_OnFocus(event) {
return ICGUZGYXTD_OnFocus(event);
}
SPBOUILib.SetInputEnter('ICGUZGYXTD',ICGUZGYXTD_wrap_OnFocus);
function ICGUZGYXTD_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ICGUZGYXTD',ICGUZGYXTD_wrap_OnKeyDown);
function ICGUZGYXTD_ZOOM_setHandlers() {
function ICGUZGYXTD_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ICGUZGYXTD_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('ICGUZGYXTD_ZOOM',ICGUZGYXTD_ZOOM_wrap_OnClick);
function ICGUZGYXTD_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('ICGUZGYXTD_ZOOM',ICGUZGYXTD_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('ICGUZGYXTD',ICGUZGYXTD_ZOOM_setHandlers);
function TGQHYPERED_wrap_Valid(event) {
return TGQHYPERED_Valid(event);
}
SPBOUILib.SetInputExit('TGQHYPERED',TGQHYPERED_wrap_Valid);
function TGQHYPERED_wrap_OnFocus(event) {
return TGQHYPERED_OnFocus(event);
}
SPBOUILib.SetInputEnter('TGQHYPERED',TGQHYPERED_wrap_OnFocus);
function TGQHYPERED_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TGQHYPERED',TGQHYPERED_wrap_OnKeyDown);
function TGQHYPERED_ZOOM_setHandlers() {
function TGQHYPERED_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?TGQHYPERED_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('TGQHYPERED_ZOOM',TGQHYPERED_ZOOM_wrap_OnClick);
function TGQHYPERED_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('TGQHYPERED_ZOOM',TGQHYPERED_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('TGQHYPERED',TGQHYPERED_ZOOM_setHandlers);
function QRJNKZVHDW_wrap_Valid(event) {
return QRJNKZVHDW_Valid(event);
}
SPBOUILib.SetInputExit('QRJNKZVHDW',QRJNKZVHDW_wrap_Valid);
function QRJNKZVHDW_wrap_OnFocus(event) {
return QRJNKZVHDW_OnFocus(event);
}
SPBOUILib.SetInputEnter('QRJNKZVHDW',QRJNKZVHDW_wrap_OnFocus);
function QRJNKZVHDW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QRJNKZVHDW',QRJNKZVHDW_wrap_OnKeyDown);
function QRJNKZVHDW_ZOOM_setHandlers() {
function QRJNKZVHDW_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?QRJNKZVHDW_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('QRJNKZVHDW_ZOOM',QRJNKZVHDW_ZOOM_wrap_OnClick);
function QRJNKZVHDW_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('QRJNKZVHDW_ZOOM',QRJNKZVHDW_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('QRJNKZVHDW',QRJNKZVHDW_ZOOM_setHandlers);
function IOZYXJKYDX_wrap_Valid(event) {
return IOZYXJKYDX_Valid(event);
}
SPBOUILib.SetInputExit('IOZYXJKYDX',IOZYXJKYDX_wrap_Valid);
function IOZYXJKYDX_wrap_OnFocus(event) {
return IOZYXJKYDX_OnFocus(event);
}
SPBOUILib.SetInputEnter('IOZYXJKYDX',IOZYXJKYDX_wrap_OnFocus);
function IOZYXJKYDX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IOZYXJKYDX',IOZYXJKYDX_wrap_OnKeyDown);
function VYZSOTTSWB_wrap_Valid(event) {
return VYZSOTTSWB_Valid(event);
}
SPBOUILib.SetInputExit('VYZSOTTSWB',VYZSOTTSWB_wrap_Valid);
function VYZSOTTSWB_wrap_OnFocus(event) {
return VYZSOTTSWB_OnFocus(event);
}
SPBOUILib.SetInputEnter('VYZSOTTSWB',VYZSOTTSWB_wrap_OnFocus);
function VYZSOTTSWB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VYZSOTTSWB',VYZSOTTSWB_wrap_OnKeyDown);
function JJJFDTJFAK_wrap_Valid(event) {
return JJJFDTJFAK_Valid(event);
}
SPBOUILib.SetInputExit('JJJFDTJFAK',JJJFDTJFAK_wrap_Valid);
function JJJFDTJFAK_wrap_OnFocus(event) {
return JJJFDTJFAK_OnFocus(event);
}
SPBOUILib.SetInputEnter('JJJFDTJFAK',JJJFDTJFAK_wrap_OnFocus);
function JJJFDTJFAK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JJJFDTJFAK',JJJFDTJFAK_wrap_OnKeyDown);
function ACTQHMCVYK_wrap_Valid(event) {
return ACTQHMCVYK_Valid(event);
}
SPBOUILib.SetInputExit('ACTQHMCVYK',ACTQHMCVYK_wrap_Valid);
function ACTQHMCVYK_wrap_OnFocus(event) {
return ACTQHMCVYK_OnFocus(event);
}
SPBOUILib.SetInputEnter('ACTQHMCVYK',ACTQHMCVYK_wrap_OnFocus);
function ACTQHMCVYK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ACTQHMCVYK',ACTQHMCVYK_wrap_OnKeyDown);
function RTWJYVXECF_wrap_Valid(event) {
return RTWJYVXECF_Valid(event);
}
SPBOUILib.SetInputExit('RTWJYVXECF',RTWJYVXECF_wrap_Valid);
function RTWJYVXECF_wrap_OnFocus(event) {
return RTWJYVXECF_OnFocus(event);
}
SPBOUILib.SetInputEnter('RTWJYVXECF',RTWJYVXECF_wrap_OnFocus);
function RTWJYVXECF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RTWJYVXECF',RTWJYVXECF_wrap_OnKeyDown);
function ACDLDQVQXS_wrap_Valid(event) {
return ACDLDQVQXS_Valid(event);
}
SPBOUILib.SetComboChange('ACDLDQVQXS',ACDLDQVQXS_wrap_Valid);
function ACDLDQVQXS_wrap_OnFocus(event) {
return ACDLDQVQXS_OnFocus(event);
}
SPBOUILib.SetInputEnter('ACDLDQVQXS',ACDLDQVQXS_wrap_OnFocus);
function ACDLDQVQXS_wrap_Blur(event) {
return ACDLDQVQXS_OnBlur(event);
}
SPBOUILib.SetInputExit('ACDLDQVQXS',ACDLDQVQXS_wrap_Blur);
function PWMWPIWKXR_wrap_Valid(event) {
return PWMWPIWKXR_Valid(event);
}
SPBOUILib.SetInputExit('PWMWPIWKXR',PWMWPIWKXR_wrap_Valid);
function PWMWPIWKXR_wrap_OnFocus(event) {
return PWMWPIWKXR_OnFocus(event);
}
SPBOUILib.SetInputEnter('PWMWPIWKXR',PWMWPIWKXR_wrap_OnFocus);
function PWMWPIWKXR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PWMWPIWKXR',PWMWPIWKXR_wrap_OnKeyDown);
function VKYZPROJCI_wrap_Valid(event) {
return VKYZPROJCI_Valid(event);
}
SPBOUILib.SetCheckboxClick('VKYZPROJCI',VKYZPROJCI_wrap_Valid);
function VKYZPROJCI_wrap_OnFocus(event) {
return VKYZPROJCI_OnFocus(event);
}
SPBOUILib.SetInputEnter('VKYZPROJCI',VKYZPROJCI_wrap_OnFocus);
function VKYZPROJCI_wrap_Blur(event) {
return VKYZPROJCI_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('VKYZPROJCI',VKYZPROJCI_wrap_Blur);
function OSJJWSZMDE_wrap_Valid(event) {
return OSJJWSZMDE_Valid(event);
}
SPBOUILib.SetInputExit('OSJJWSZMDE',OSJJWSZMDE_wrap_Valid);
function OSJJWSZMDE_wrap_OnFocus(event) {
return OSJJWSZMDE_OnFocus(event);
}
SPBOUILib.SetInputEnter('OSJJWSZMDE',OSJJWSZMDE_wrap_OnFocus);
function OSJJWSZMDE_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('OSJJWSZMDE',OSJJWSZMDE_wrap_OnKeyPress);
function OSJJWSZMDE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('OSJJWSZMDE',OSJJWSZMDE_wrap_OnKeyDown);
function OSJJWSZMDE_ZOOM_setHandlers() {
function OSJJWSZMDE_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?OSJJWSZMDE_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('OSJJWSZMDE_ZOOM',OSJJWSZMDE_ZOOM_wrap_OnClick);
function OSJJWSZMDE_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('OSJJWSZMDE_ZOOM',OSJJWSZMDE_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('OSJJWSZMDE',OSJJWSZMDE_ZOOM_setHandlers);
function QDGOPSCQNI_wrap_Valid(event) {
return QDGOPSCQNI_Valid(event);
}
SPBOUILib.SetInputExit('QDGOPSCQNI',QDGOPSCQNI_wrap_Valid);
function QDGOPSCQNI_wrap_OnFocus(event) {
return QDGOPSCQNI_OnFocus(event);
}
SPBOUILib.SetInputEnter('QDGOPSCQNI',QDGOPSCQNI_wrap_OnFocus);
function QDGOPSCQNI_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('QDGOPSCQNI',QDGOPSCQNI_wrap_OnKeyPress);
function QDGOPSCQNI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('QDGOPSCQNI',QDGOPSCQNI_wrap_OnKeyDown);
function QDGOPSCQNI_ZOOM_setHandlers() {
function QDGOPSCQNI_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?QDGOPSCQNI_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('QDGOPSCQNI_ZOOM',QDGOPSCQNI_ZOOM_wrap_OnClick);
function QDGOPSCQNI_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('QDGOPSCQNI_ZOOM',QDGOPSCQNI_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('QDGOPSCQNI',QDGOPSCQNI_ZOOM_setHandlers);
function DVNRBUBGST_wrap_Valid(event) {
return DVNRBUBGST_Valid(event);
}
SPBOUILib.SetCheckboxClick('DVNRBUBGST',DVNRBUBGST_wrap_Valid);
function DVNRBUBGST_wrap_OnFocus(event) {
return DVNRBUBGST_OnFocus(event);
}
SPBOUILib.SetInputEnter('DVNRBUBGST',DVNRBUBGST_wrap_OnFocus);
function DVNRBUBGST_wrap_Blur(event) {
return DVNRBUBGST_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('DVNRBUBGST',DVNRBUBGST_wrap_Blur);
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
FocusFirstComponent.edit={"page_1":["XCUHPGQTRL"]};
FocusFirstComponent.query={"page_1":["PBPAZFLKHV"]};
FocusFirstComponent.otherwise={"page_1":["PBPAZFLKHV"]};
function Help() {
windowOpenForeground('../doc/armt_anadip_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_ardt_dippreposti() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_1')) {
if (ChildToLoad('ZBFNRFHLSE')) {
if (Eq(lazy,null) || LibJavascript.UserCanSee('ZBFNRFHLSE')) {
LoadContext.lc(1,'ZBFNRFHLSE');
}
} else {
LibJavascript.RefreshChildGrid('ZBFNRFHLSE');
}
}
}
GetLayerID.Layers.push({"id":"UBUBESGOCL","name":"DatiBase"});
GetLayerID.Layers.push({"id":"OQJXMMCZQK","name":"DatiAdd"});
GetLayerID.Layers.push({"id":"RFAIYHSGII","name":"Rischio"});
GetLayerID.Layers.push({"id":"SJOTYLCKUC","name":"Dati SARA\/SV"});
GetLayerID.Layers.push({"id":"DKPWIMNYIB","name":"Preposti"});
function DeclareWVs() {
var a = arguments;
w_CODDIP=a[0];
w_DESCRIZ=a[1];
w_DOMICILIO=a[2];
w_CAP=a[3];
w_IDCITTA=a[4];
w_DESCCIT=a[5];
w_PROVINCIA=a[6];
w_CAB=a[7];
w_AGENTE=a[8];
w_MACROAGENTE=a[9];
w_TERMINALID=a[10];
w_IDBASE=a[11];
w_TELEFONO=a[12];
w_ABICABSARA=a[13];
w_AGACCODE=a[14];
w_NAZAGENTE=a[15];
w_VALCOMPL=a[16];
w_ANOMOPER=a[17];
w_OPXSOSCLI=a[18];
w_OPXSOSAGE=a[19];
w_AGEREGIO=a[20];
w_FLGATT=a[21];
w_CODLOC=a[22];
w_CODAGE=a[23];
w_TIPOSV=a[24];
w_FLGNOAUA=a[25];
w_FLGWUPOS=a[26];
w_CATEG04=a[27];
w_CATEG05=a[28];
w_CATEGORIA=a[29];
w_CATEG01=a[30];
w_CATEG02=a[31];
w_CATEG03=a[32];
w_CAB2=a[33];
w_CODICEAAMS=a[34];
w_CONCESSIONE=a[35];
w_CODFISC=a[36];
w_PARTIVA=a[37];
w_TIPOAGENTE=a[38];
w_NUMCIVICO=a[39];
w_SERRIMDEN=a[40];
w_DATAINI=a[41];
w_DATAFINE=a[42];
w_FLGCOMPL=a[43];
w_gFlgWU=a[44];
w_xMADESCRI=a[45];
w_xDESCNAZ=a[46];
w_gAgeCGO=a[47];
w_tipocat=a[48];
w_xC1DESCRI=a[49];
w_xC2DESCRI=a[50];
w_xC3DESCRI=a[51];
w_xC4DESCRI=a[52];
w_xC5DESCRI=a[53];
w_gTipInter=a[54];
w_xDESCAN=a[55];
w_xMACOGNOME=a[56];
w_xMANOME=a[57];
m_cWv_ardt_dippreposti=a[58];
if (Gt(a.length,59)) {
m_cErrorInChild='';
}
if (Gt(a.length,59)) {
o_IDCITTA=w_IDCITTA;
}
m_PrimaryKeys=['CODDIP'];
}
function i_PrimaryKey() {
return 'anadip'+'\\'+CPLib.ToCPStr(w_CODDIP);
}
GetLinkPCKeys.set_o('ardt_dippreposti',false);
GetLinkPCKeys.o['ardt_dippreposti']['CODDIP']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_CODDIP,'C');
}
}
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('ZBFNRFHLSE',function(){return FrameRef('ardt_dippreposti')},1,'ardt_dippreposti',0,1)
GetSelectedChildPage.child={'ardt_dippreposti': function(){return FrameRef('ardt_dippreposti')}}
function GetSelectedPage(p_d) {
p_d.setValue('armt_anadip',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_DESCCIT,'C'); },"field":"CITTA","type":"C"},{"expression":function() { return WtA(w_IDCITTA,'C'); },"field":"IDBASE","type":"C"},{"expression":function() { return WtA(w_PROVINCIA,'C'); },"field":"PROV","type":"C"},{"expression":function() { return WtA(w_CAB,'C'); },"field":"CAB","type":"C"},{"expression":function() { return WtA(w_CAP,'C'); },"field":"CAP","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcitta','C'),"uid":"AEZUFOYHTM"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('armt_tbmacage','C'),"fldValues":[{"expression":function() { return WtA(w_MACROAGENTE,'C'); },"field":"MACODICE","type":"C"},{"expression":function() { return WtA(w_xMADESCRI,'C'); },"field":"MADESCRI","type":"C"},{"expression":function() { return WtA(w_xMACOGNOME,'C'); },"field":"MACOGNOME","type":"C"},{"expression":function() { return WtA(w_xMANOME,'C'); },"field":"MANOME","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbmacage','C'),"uid":"BPQQBVFABO"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_NAZAGENTE,'C'); },"field":"CODSTA","type":"C"},{"expression":function() { return WtA(w_xDESCNAZ,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"SGDAQGMTNU"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('opemt_tbcateg04','C'),"fldValues":[{"expression":function() { return WtA(w_CATEG04,'C'); },"field":"C4CODICE","type":"C"},{"expression":function() { return WtA(w_xC4DESCRI,'C'); },"field":"C4DESCRI","type":"C"}],"keyValues":[{"expression":function() { return WtA(w_tipocat,'C'); },"field":"C4CODTAB","type":"C"}],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcateg04','C'),"uid":"JQLGHMLOKO"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('opemt_tbcateg05','C'),"fldValues":[{"expression":function() { return WtA(w_CATEG05,'C'); },"field":"C5CODICE","type":"C"},{"expression":function() { return WtA(w_xC5DESCRI,'C'); },"field":"C5DESCRI","type":"C"}],"keyValues":[{"expression":function() { return WtA(w_tipocat,'C'); },"field":"C5CODTAB","type":"C"}],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcateg05','C'),"uid":"QVBZSFMTVP"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CATEG01,'C'); },"field":"C1CODICE","type":"C"},{"expression":function() { return WtA(w_xC1DESCRI,'C'); },"field":"C1DESCRI","type":"C"}],"keyValues":[{"expression":function() { return WtA(w_tipocat,'C'); },"field":"C1CODTAB","type":"C"}],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcateg01','C'),"uid":"ICGUZGYXTD"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CATEG02,'C'); },"field":"C2CODICE","type":"C"},{"expression":function() { return WtA(w_xC2DESCRI,'C'); },"field":"C2DESCRI","type":"C"}],"keyValues":[{"expression":function() { return WtA(w_tipocat,'C'); },"field":"C2CODTAB","type":"C"}],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcateg02','C'),"uid":"TGQHYPERED"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CATEG03,'C'); },"field":"C3CODICE","type":"C"},{"expression":function() { return WtA(w_xC3DESCRI,'C'); },"field":"C3DESCRI","type":"C"}],"keyValues":[{"expression":function() { return WtA(w_tipocat,'C'); },"field":"C3CODTAB","type":"C"}],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcateg03','C'),"uid":"QRJNKZVHDW"});
}
_Obli('CODDIP',0,'PBPAZFLKHV',false,"2071283709")
_Obli('DESCRIZ',0,'XCUHPGQTRL',false,"285808099")
_Obli('DOMICILIO',0,'JRSYWVEHIR',false,"554236824")
_Obli('CAP',0,'KQSLGVHSRE',false,"21587")
_Obli('TIPOSV',0,'LYZAJWZGAM',false,"229480117")
_Obli('DESCCIT',0,'AEZUFOYHTM',false,"15186643")
_Obli('FLGNOAUA',0,'NPJMZHJDRZ',false,"11553173743")
_Obli('FLGWUPOS',0,'PNZMYOKETI',false,"1519836549")
_Obli('AGENTE',0,'WRIYZYCTBR',false,"113986481")
_Obli('FLGCOMPL',1,'DVNRBUBGST',false,"986106899")
_Obli('MACROAGENTE',0,'BPQQBVFABO',false,"11725152890")
_Obli('TERMINALID',0,'RTLSPZPWWO',false,"1240894674")
_Obli('CATEG04',0,'JQLGHMLOKO',false,"157154740")
_Obli('IDBASE',0,'WTENUNIUCY',false,"12014834236")
_Obli('TELEFONO',0,'CDMUQZYEAX',false,"1700577956")
_Obli('ABICABSARA',0,'YTCIMOKXKS',false,"10376012512")
_Obli('AGACCODE',0,'NISBFWYVAN',false,"1276075358")
_Obli('NAZAGENTE',0,'SGDAQGMTNU',false,"1946812107")
_Obli('DATAFINE',2,'QDGOPSCQNI',true,"10180688344",null,"1325233457",function() { return Eq(w_FLGCOMPL,1) })
_Obli('SERRIMDEN',0,'VKYZPROJCI',false,"12128215460")
_Obli('NUMCIVICO',0,'PWMWPIWKXR',false,"1474192743")
_Obli('TIPOAGENTE',0,'ACDLDQVQXS',false,"11153969262")
_Obli('PARTIVA',0,'RTWJYVXECF',false,"1756430089")
_Obli('AGEREGIO',0,'KSBCZELDDB',false,"1817574818")
_Obli('FLGATT',0,'ECKDLHTTSN',false,"245446773")
_Obli('CODLOC',0,'DUZIXALHHS',false,"1093030153")
_Obli('CODAGE',0,'MOQMJLJJNI',true,"923045322",null,null,function() { return Eq(w_gAgeCGO,'S') })
_Obli('CODFISC',0,'ACTQHMCVYK',false,"11921223220")
_Obli('CONCESSIONE',0,'JJJFDTJFAK',false,"178000258")
_Obli('CODICEAAMS',0,'VYZSOTTSWB',false,"11189129404")
_Obli('CAB2',0,'IOZYXJKYDX',false,"11537497388")
_Obli('CATEG03',0,'QRJNKZVHDW',false,"157155252")
_Obli('CATEG02',0,'TGQHYPERED',false,"157154996")
_Obli('CATEG05',0,'QVBZSFMTVP',false,"157154740")
_Obli('DATAINI',2,'OSJJWSZMDE',false,"11223264513")
_Obli('CATEG01',0,'ICGUZGYXTD',false,"157154740")
