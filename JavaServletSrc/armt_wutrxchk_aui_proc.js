function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('LPQRPTUZNB',function(){return WtH(w_TRXCODPRG,'N',15,0,'999999999999999')},w_TRXCODPRG);
if(c=Ctrl('EPEPXVTDDF')) selectCombo(c,w_TRSSEGNO,'C')
SPBOUILib.SetInputValue('FNVGSTOZTQ',function(){return WtH(w_TRXIMPORTO,'N',15,2,'999999999999.99')},w_TRXIMPORTO);
SPBOUILib.SetInputValue('EVKHOJDUVF',function(){return WtH(w_TRXCONTAN,'N',15,2,'999999999999.99')},w_TRXCONTAN);
SPBOUILib.SetInputValue('FCRFUHHVHU',function(){return WtH(w_TRXUNIQUE,'C',10,0,'')},w_TRXUNIQUE);
SPBOUILib.SetInputValue('HZPBCLSNRS',function(){return WtH(w_TRXCODDIP,'C',10,0,'')},w_TRXCODDIP);
SPBOUILib.SetInputValue('LGVQVJPZZP',function(){return WtH(w_TRXCOGCON,'C',100,0,'')},w_TRXCOGCON);
SPBOUILib.SetInputValue('OKKVRBSRDN',function(){return WtH(w_TRXNOMCON,'C',100,0,'')},w_TRXNOMCON);
SPBOUILib.SetInputValue('FDXEUOOSVN',function(){return WtH(w_TRXDESTIN,'C',100,0,'')},w_TRXDESTIN);
SPBOUILib.SetInputValue('YZULLMXBBH',function(){return WtH(w_TRXMTCN,'C',10,0,'')},w_TRXMTCN);
SPBOUILib.SetInputValue('UTGSXNXPVT',function(){return WtH(w_TRXCODCAS,'C',4,0,'')},w_TRXCODCAS);
if(c=Ctrl('FMRUIANURB')) selectCombo(c,w_TRXRECTYPE,'C')
SPBOUILib.SetInputValue('UTFQIBBLAF',function(){return WtH(w_TRXCODMAG,'C',5,0,'')},w_TRXCODMAG);
SPBOUILib.SetInputValue('NSNBJQWLKR',function(){return WtH(w_TRXCODUNI,'C',18,0,'')},w_TRXCODUNI);
if(c=Ctrl('TZHYQAUMDE')) ChkboxCheckUncheck(c,'S',w_TRXFLGAUI)
if(c=Ctrl('TZHYQAUMDE')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('CMGWBYDKHQ')) ChkboxCheckUncheck(c,'S',w_TRXFLGFOR)
if(c=Ctrl('CMGWBYDKHQ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('YUKRVYFISB',function(){return WtH(w_xMADESCRI,'C',60,0,'')},w_xMADESCRI);
SPBOUILib.SetInputValue('PXDVUJVPPR',function(){return WtH(w_xDESCRIZ,'C',30,0,'')},w_xDESCRIZ);
SPBOUILib.SetInputValue('QKFJKVYCVD',function(){return WtH(w_TRXCOGNOM,'C',50,0,'')},w_TRXCOGNOM);
SPBOUILib.SetInputValue('OUUNVPTKEC',function(){return WtH(w_TRXNOME,'C',50,0,'')},w_TRXNOME);
SPBOUILib.SetInputValue('APRONFZYCV',function(){return WtH(w_TRXDOMICI,'C',100,0,'')},w_TRXDOMICI);
if(c=Ctrl('ASIYKLXBCD')) ChkboxCheckUncheck(c,'S',w_TRXFLGCF)
if(c=Ctrl('ASIYKLXBCD')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('FVJVEJQIYB',function(){return WtH(w_TRXCODFIS,'C',16,0,'')},w_TRXCODFIS);
SPBOUILib.SetInputValue('OTJSTXXVID',function(){return WtH(w_TRXLUONAS,'C',50,0,'')},w_TRXLUONAS);
SPBOUILib.SetInputValue('MMSPBVULRO',function(){return WtH(w_TRXNUMDOC,'C',30,0,'')},w_TRXNUMDOC);
SPBOUILib.SetInputValue('IFKUOAHUHG',function(){return WtH(w_TRXDATSCA,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_TRXDATSCA);
SPBOUILib.SetInputValue('DRQDHBWECQ',function(){return WtH(w_TRXDATRIL,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_TRXDATRIL);
SPBOUILib.SetInputValue('KUJLLGUFUU',function(){return WtH(w_TRXAUTRIL,'C',50,0,'')},w_TRXAUTRIL);
SPBOUILib.SetInputValue('SOTHCYQHKP',function(){return WtH(w_TRXNAZRES,'C',50,0,'')},w_TRXNAZRES);
SPBOUILib.SetInputValue('ZDOEFBYPYC',function(){return WtH(w_TRXCITRES,'C',50,0,'')},w_TRXCITRES);
if(c=Ctrl('ZCRTCXLUUY')) selectCombo(c,w_TRXTIPDOC,'C')
SPBOUILib.SetInputValue('BYTTMKVPJF',function(){return WtH(w_TRXDATNAS,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_TRXDATNAS);
SPBOUILib.SetInputValue('VUPAGTECJJ',function(){return WtH(w_TRXDATOPE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_TRXDATOPE);
if(c=Ctrl('ATGEKSLXET')) selectCombo(c,w_TRXSESSO,'C')
if(c=Ctrl('TQMBDRYXLU')) ChkboxCheckUncheck(c,'S',w_TRXFLGCON)
if(c=Ctrl('TQMBDRYXLU')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('UCHSJHQNIV',function(){return WtH(w_TRXERROR01,'C',80,0,'')},w_TRXERROR01);
SPBOUILib.SetInputValue('GKZAXYVJEW',function(){return WtH(w_TRXERROR02,'C',80,0,'')},w_TRXERROR02);
SPBOUILib.SetInputValue('SYKQVOROAS',function(){return WtH(w_TRXERROR03,'C',80,0,'')},w_TRXERROR03);
SPBOUILib.SetInputValue('WXHVIATWKM',function(){return WtH(w_TRXERROR04,'C',80,0,'')},w_TRXERROR04);
SPBOUILib.SetInputValue('YCDTVJJIMR',function(){return WtH(w_TRXERROR05,'C',80,0,'')},w_TRXERROR05);
SPBOUILib.SetInputValue('BACNEOKNNG',function(){return WtH(w_TRXERROR06,'C',80,0,'')},w_TRXERROR06);
SPBOUILib.SetInputValue('RVIBIVADUM',function(){return WtH(w_TRXERROR07,'C',80,0,'')},w_TRXERROR07);
SPBOUILib.SetInputValue('XOBPJRQPBZ',function(){return WtH(w_TRXERROR08,'C',80,0,'')},w_TRXERROR08);
SPBOUILib.SetInputValue('RFAJDLABHK',function(){return WtH(w_TRXERROR09,'C',80,0,'')},w_TRXERROR09);
SPBOUILib.SetInputValue('LNJHQTAPKH',function(){return WtH(w_TRXERROR10,'C',80,0,'')},w_TRXERROR10);
SPBOUILib.SetInputValue('BXBAWWFZDV',function(){return WtH(w_TRXERROR11,'C',80,0,'')},w_TRXERROR11);
SPBOUILib.SetInputValue('GLAQECICHA',function(){return WtH(w_TRXERROR12,'C',80,0,'')},w_TRXERROR12);
SPBOUILib.SetInputValue('KLEBFCDCIF',function(){return WtH(w_TRXERROR13,'C',80,0,'')},w_TRXERROR13);
SPBOUILib.SetInputValue('WXIZZGFGYV',function(){return WtH(w_TRXERROR14,'C',80,0,'')},w_TRXERROR14);
SPBOUILib.SetInputValue('VDAZXJXDXY',function(){return WtH(w_TRXERROR15,'C',80,0,'')},w_TRXERROR15);
SPBOUILib.SetInputValue('JANNSGSWGM',function(){return WtH(w_TRXERROR16,'C',80,0,'')},w_TRXERROR16);
SPBOUILib.SetInputValue('HUIFQLIZHZ',function(){return WtH(w_TRXERROR17,'C',80,0,'')},w_TRXERROR17);
SPBOUILib.SetInputValue('YPMKIOATIZ',function(){return WtH(w_TRXERROR18,'C',80,0,'')},w_TRXERROR18);
SPBOUILib.SetInputValue('KGAEUMDODK',function(){return WtH(w_TRXERROR19,'C',80,0,'')},w_TRXERROR19);
SPBOUILib.SetInputValue('VGBNUNWCXY',function(){return WtH(w_TRXERROR20,'C',80,0,'')},w_TRXERROR20);
SPBOUILib.SetInputValue('DLAKPEHAYJ',function(){return WtH(w_TRXERROR21,'C',80,0,'')},w_TRXERROR21);
SPBOUILib.SetInputValue('JEDPFHJRZS',function(){return WtH(w_TRXERROR22,'C',80,0,'')},w_TRXERROR22);
SPBOUILib.SetInputValue('BMIRKKOHKR',function(){return WtH(w_TRXERROR23,'C',80,0,'')},w_TRXERROR23);
SPBOUILib.SetInputValue('OHTYWCOOIK',function(){return WtH(w_TRXERROR24,'C',80,0,'')},w_TRXERROR24);
SPBOUILib.SetInputValue('LAAPMSXDPL',function(){return WtH(w_TRXERROR25,'C',80,0,'')},w_TRXERROR25);
SPBOUILib.SetInputValue('ASSPEANDMC',function(){return WtH(w_TRXERROR26,'C',80,0,'')},w_TRXERROR26);
SPBOUILib.SetInputValue('FMOIMQZAPG',function(){return WtH(w_TRXERROR27,'C',80,0,'')},w_TRXERROR27);
SPBOUILib.SetInputValue('RKGHXZFQZL',function(){return WtH(w_TRXERROR28,'C',80,0,'')},w_TRXERROR28);
SPBOUILib.SetInputValue('HEPMULJALS',function(){return WtH(w_TRXERROR29,'C',80,0,'')},w_TRXERROR29);
SPBOUILib.SetInputValue('DYBWDBXZIJ',function(){return WtH(w_TRXERROR30,'C',80,0,'')},w_TRXERROR30);
SPBOUILib.SetInputValue('LISOLVFJNF',function(){return WtH(w_TRXERROR31,'C',80,0,'')},w_TRXERROR31);
SPBOUILib.SetInputValue('BHISKUARAJ',function(){return WtH(w_TRXERROR32,'C',80,0,'')},w_TRXERROR32);
SPBOUILib.SetInputValue('MSSBSWBLKI',function(){return WtH(w_TRXERROR33,'C',80,0,'')},w_TRXERROR33);
SPBOUILib.SetInputValue('ATBSEHTJHH',function(){return WtH(w_TRXERROR34,'C',80,0,'')},w_TRXERROR34);
SPBOUILib.SetInputValue('CIFSRVZLSK',function(){return WtH(w_TRXERROR35,'C',80,0,'')},w_TRXERROR35);
SPBOUILib.SetInputValue('FCOYAJZYOF',function(){return WtH(w_TRXERROR36,'C',80,0,'')},w_TRXERROR36);
SPBOUILib.SetInputValue('ZNHTQWPUYJ',function(){return WtH(w_TRXERROR37,'C',80,0,'')},w_TRXERROR37);
SPBOUILib.SetInputValue('ULYZEYIIYY',function(){return WtH(w_TRXERROR38,'C',80,0,'')},w_TRXERROR38);
SPBOUILib.SetInputValue('ZRCBZVUWZE',function(){return WtH(w_TRXERROR39,'C',80,0,'')},w_TRXERROR39);
SPBOUILib.SetInputValue('TCMPTOYHZU',function(){return WtH(w_TRXERROR40,'C',80,0,'')},w_TRXERROR40);
SPBOUILib.SetInputValue('DYIXHFFDPL',function(){return WtH(w_TRXERROR41,'C',80,0,'')},w_TRXERROR41);
SPBOUILib.SetInputValue('OZIAVQGVQX',function(){return WtH(w_TRXERROR42,'C',80,0,'')},w_TRXERROR42);
SPBOUILib.SetInputValue('QURNMKDXBF',function(){return WtH(w_TRXERROR43,'C',80,0,'')},w_TRXERROR43);
SPBOUILib.SetInputValue('MNXGCWMDZI',function(){return WtH(w_TRXERROR44,'C',80,0,'')},w_TRXERROR44);
SPBOUILib.SetInputValue('YJUYZEFYVU',function(){return WtH(w_TRXERROR45,'C',80,0,'')},w_TRXERROR45);
SPBOUILib.SetInputValue('ASNHGNRDBH',function(){return WtH(w_TRXERROR46,'C',80,0,'')},w_TRXERROR46);
SPBOUILib.SetInputValue('CZSDXMRIYM',function(){return WtH(w_TRXERROR47,'C',80,0,'')},w_TRXERROR47);
SPBOUILib.SetInputValue('XVGSKNYKNU',function(){return WtH(w_TRXERROR48,'C',80,0,'')},w_TRXERROR48);
SPBOUILib.SetInputValue('BBGXFOFUHV',function(){return WtH(w_TRXERROR49,'C',80,0,'')},w_TRXERROR49);
SPBOUILib.SetInputValue('VKWSDIQTXK',function(){return WtH(w_TRXERROR50,'C',80,0,'')},w_TRXERROR50);
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
HideUI.lblids["TRSSEGNO"]=['HAJXBCFZUB'];
HideUI.lblids["TRXAUTRIL"]=['UDUZNUWZVD'];
HideUI.lblids["TRXCITRES"]=['KSYOWUXVPF'];
HideUI.lblids["TRXCODCAS"]=['MEUEEEUOXT'];
HideUI.lblids["TRXCODDIP"]=['CKTPLYQSNF'];
HideUI.lblids["TRXCODFIS"]=['RPYTXEJOAU'];
HideUI.lblids["TRXCODMAG"]=['VIWNSSMTML'];
HideUI.lblids["TRXCODPRG"]=['NESFDLHKJF'];
HideUI.lblids["TRXCODUNI"]=['XIUAHOQEHG'];
HideUI.lblids["TRXCOGCON"]=['ZUININVXNT'];
HideUI.lblids["TRXCOGNOM"]=['XUZGKKXQHI'];
HideUI.lblids["TRXCONTAN"]=['AIMDTEHGSW'];
HideUI.lblids["TRXDATNAS"]=['RWVGLFMUMW'];
HideUI.lblids["TRXDATOPE"]=['NRJSRMLPEW'];
HideUI.lblids["TRXDATRIL"]=['GFCZJPFQSD'];
HideUI.lblids["TRXDATSCA"]=['UUAVAMYOIT'];
HideUI.lblids["TRXDESTIN"]=['ZVELAFATZL'];
HideUI.lblids["TRXDOMICI"]=['IULBWAOCZM'];
HideUI.lblids["TRXERROR01"]=['YJDTDBJKTF'];
HideUI.lblids["TRXERROR02"]=['AVIHMGJWGN'];
HideUI.lblids["TRXERROR03"]=['LQOWVNXSZZ'];
HideUI.lblids["TRXERROR04"]=['ZEQMJDTKJK'];
HideUI.lblids["TRXERROR05"]=['QOKDINZBUM'];
HideUI.lblids["TRXERROR06"]=['MSZJRHNIOJ'];
HideUI.lblids["TRXERROR07"]=['YCUADRGOUT'];
HideUI.lblids["TRXERROR08"]=['SHKIUHYTBK'];
HideUI.lblids["TRXERROR09"]=['ODLCWVHXIM'];
HideUI.lblids["TRXERROR10"]=['IXLENOMJOT'];
HideUI.lblids["TRXERROR11"]=['MGTUFSHMTT'];
HideUI.lblids["TRXERROR12"]=['JGYZCBGDLT'];
HideUI.lblids["TRXERROR13"]=['MDPKUXQMTX'];
HideUI.lblids["TRXERROR14"]=['IMVSNIGMHD'];
HideUI.lblids["TRXERROR15"]=['TJJMOKWTNI'];
HideUI.lblids["TRXERROR16"]=['CVAGINOCMP'];
HideUI.lblids["TRXERROR17"]=['JPTDZENLJK'];
HideUI.lblids["TRXERROR18"]=['OKMDAUUJFH'];
HideUI.lblids["TRXERROR19"]=['QCKHWGMETR'];
HideUI.lblids["TRXERROR20"]=['PLWWFSRYAI'];
HideUI.lblids["TRXERROR21"]=['GVUUSALGNA'];
HideUI.lblids["TRXERROR22"]=['NOXWNOVPAD'];
HideUI.lblids["TRXERROR23"]=['CDOOHIIAPB'];
HideUI.lblids["TRXERROR24"]=['MWDMUSJEML'];
HideUI.lblids["TRXERROR25"]=['VBPHKZYIIK'];
HideUI.lblids["TRXERROR26"]=['HNLLPVTPEP'];
HideUI.lblids["TRXERROR27"]=['AWLZZLJZMV'];
HideUI.lblids["TRXERROR28"]=['REHSVTTQZW'];
HideUI.lblids["TRXERROR29"]=['QWSQQWGKJA'];
HideUI.lblids["TRXERROR30"]=['RYCQAUVBFN'];
HideUI.lblids["TRXERROR31"]=['XYZFJXNCXY'];
HideUI.lblids["TRXERROR32"]=['KPITEKYSGW'];
HideUI.lblids["TRXERROR33"]=['YQMAZGPJAS'];
HideUI.lblids["TRXERROR34"]=['AGCPTXWUDW'];
HideUI.lblids["TRXERROR35"]=['EUBHVZLAKQ'];
HideUI.lblids["TRXERROR36"]=['YBMQFVMVNK'];
HideUI.lblids["TRXERROR37"]=['YUAOFCOOFT'];
HideUI.lblids["TRXERROR38"]=['APRWZHGLUI'];
HideUI.lblids["TRXERROR39"]=['VTTPEXBMTN'];
HideUI.lblids["TRXERROR40"]=['CAQYVLVNUV'];
HideUI.lblids["TRXERROR41"]=['YCPYSNRJCS'];
HideUI.lblids["TRXERROR42"]=['KCOBOXNFOZ'];
HideUI.lblids["TRXERROR43"]=['XVDSGNYPCO'];
HideUI.lblids["TRXERROR44"]=['GEHQBAIYSA'];
HideUI.lblids["TRXERROR45"]=['RWRUJLOGUJ'];
HideUI.lblids["TRXERROR46"]=['QZDQYZMYBD'];
HideUI.lblids["TRXERROR47"]=['LXCXEBOILM'];
HideUI.lblids["TRXERROR48"]=['WJGQPYDDSI'];
HideUI.lblids["TRXERROR49"]=['YNBUPEMGKR'];
HideUI.lblids["TRXERROR50"]=['NDQGRTJVYG'];
HideUI.lblids["TRXFLGCF"]=['TQNQMPMBTY'];
HideUI.lblids["TRXFLGCON"]=['HWRRLNPDOJ'];
HideUI.lblids["TRXIMPORTO"]=['TYFYRRXXWC'];
HideUI.lblids["TRXLUONAS"]=['YWGMEJQDVN'];
HideUI.lblids["TRXMTCN"]=['DYDCEKIOPZ'];
HideUI.lblids["TRXNAZRES"]=['ISWVVEAGKR'];
HideUI.lblids["TRXNOMCON"]=['DSHVDLPTCM'];
HideUI.lblids["TRXNOME"]=['PDDGGZFWWD'];
HideUI.lblids["TRXNUMDOC"]=['XSWCEEGDZN'];
HideUI.lblids["TRXRECTYPE"]=['XXKUBGHLZL'];
HideUI.lblids["TRXSESSO"]=['UWFFZZSTIY'];
HideUI.lblids["TRXTIPDOC"]=['KUKWNMYGCS'];
HideUI.lblids["TRXUNIQUE"]=['ULSRWVYTMU'];
function LPQRPTUZNB_Valid(e) {
SetActiveField(Ctrl('LPQRPTUZNB'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('LPQRPTUZNB') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('TRXCODPRG','N',w_TRXCODPRG,HtW(Ctrl('LPQRPTUZNB').value,'N'),m_bQueryOnLatestKeyOnly);
}
}
}
function LPQRPTUZNB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LPQRPTUZNB'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('LPQRPTUZNB',w_TRXCODPRG,'N',15,0,'999999999999999');
SetActiveField(Ctrl('LPQRPTUZNB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LPQRPTUZNB'),e);
}
function LPQRPTUZNB_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999999"));
}
function EPEPXVTDDF_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TRSSEGNO','C',w_TRSSEGNO,HtW(getComboValue(Ctrl('EPEPXVTDDF')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRSSEGNO(HtW(getComboValue(Ctrl('EPEPXVTDDF')),'C'),null,e);
return l_bSetResult;
}
}
function EPEPXVTDDF_OnFocus(e) {
SetActiveField(Ctrl('EPEPXVTDDF'),true);
}
function EPEPXVTDDF_OnBlur(e) {
SetActiveField(Ctrl('EPEPXVTDDF'),false);
}
function FNVGSTOZTQ_Valid(e) {
SetActiveField(Ctrl('FNVGSTOZTQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXIMPORTO','N',w_TRXIMPORTO,HtW(Ctrl('FNVGSTOZTQ').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXIMPORTO(HtW(Ctrl('FNVGSTOZTQ').value,'N'),null,e);
return l_bSetResult;
}
}
function FNVGSTOZTQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FNVGSTOZTQ'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('FNVGSTOZTQ',w_TRXIMPORTO,'N',15,2,'999999999999.99');
SetActiveField(Ctrl('FNVGSTOZTQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FNVGSTOZTQ'),e);
}
function FNVGSTOZTQ_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999.99"));
}
function EVKHOJDUVF_Valid(e) {
SetActiveField(Ctrl('EVKHOJDUVF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXCONTAN','N',w_TRXCONTAN,HtW(Ctrl('EVKHOJDUVF').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXCONTAN(HtW(Ctrl('EVKHOJDUVF').value,'N'),null,e);
return l_bSetResult;
}
}
function EVKHOJDUVF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EVKHOJDUVF'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('EVKHOJDUVF',w_TRXCONTAN,'N',15,2,'999999999999.99');
SetActiveField(Ctrl('EVKHOJDUVF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EVKHOJDUVF'),e);
}
function EVKHOJDUVF_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999.99"));
}
function FCRFUHHVHU_Valid(e) {
SetActiveField(Ctrl('FCRFUHHVHU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXUNIQUE','C',w_TRXUNIQUE,HtW(Ctrl('FCRFUHHVHU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXUNIQUE(HtW(Ctrl('FCRFUHHVHU').value,'C'),null,e);
return l_bSetResult;
}
}
function FCRFUHHVHU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FCRFUHHVHU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FCRFUHHVHU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FCRFUHHVHU'),e);
}
function HZPBCLSNRS_Valid(e) {
SetActiveField(Ctrl('HZPBCLSNRS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXCODDIP','C',w_TRXCODDIP,HtW(Ctrl('HZPBCLSNRS').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXCODDIP(HtW(Ctrl('HZPBCLSNRS').value,'C'),null,e);
return l_bSetResult;
}
}
function HZPBCLSNRS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HZPBCLSNRS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HZPBCLSNRS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HZPBCLSNRS'),e);
}
function HZPBCLSNRS_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('HZPBCLSNRS')),'linkview_HZPBCLSNRS','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function LGVQVJPZZP_Valid(e) {
SetActiveField(Ctrl('LGVQVJPZZP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXCOGCON','C',w_TRXCOGCON,HtW(Ctrl('LGVQVJPZZP').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXCOGCON(HtW(Ctrl('LGVQVJPZZP').value,'C'),null,e);
return l_bSetResult;
}
}
function LGVQVJPZZP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LGVQVJPZZP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LGVQVJPZZP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LGVQVJPZZP'),e);
}
function OKKVRBSRDN_Valid(e) {
SetActiveField(Ctrl('OKKVRBSRDN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXNOMCON','C',w_TRXNOMCON,HtW(Ctrl('OKKVRBSRDN').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXNOMCON(HtW(Ctrl('OKKVRBSRDN').value,'C'),null,e);
return l_bSetResult;
}
}
function OKKVRBSRDN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OKKVRBSRDN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OKKVRBSRDN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OKKVRBSRDN'),e);
}
function FDXEUOOSVN_Valid(e) {
SetActiveField(Ctrl('FDXEUOOSVN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXDESTIN','C',w_TRXDESTIN,HtW(Ctrl('FDXEUOOSVN').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXDESTIN(HtW(Ctrl('FDXEUOOSVN').value,'C'),null,e);
return l_bSetResult;
}
}
function FDXEUOOSVN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FDXEUOOSVN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FDXEUOOSVN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FDXEUOOSVN'),e);
}
function YZULLMXBBH_Valid(e) {
SetActiveField(Ctrl('YZULLMXBBH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXMTCN','C',w_TRXMTCN,HtW(Ctrl('YZULLMXBBH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXMTCN(HtW(Ctrl('YZULLMXBBH').value,'C'),null,e);
return l_bSetResult;
}
}
function YZULLMXBBH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YZULLMXBBH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YZULLMXBBH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YZULLMXBBH'),e);
}
function UTGSXNXPVT_Valid(e) {
SetActiveField(Ctrl('UTGSXNXPVT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXCODCAS','C',w_TRXCODCAS,HtW(Ctrl('UTGSXNXPVT').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXCODCAS(HtW(Ctrl('UTGSXNXPVT').value,'C'),null,e);
return l_bSetResult;
}
}
function UTGSXNXPVT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UTGSXNXPVT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UTGSXNXPVT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UTGSXNXPVT'),e);
}
function FMRUIANURB_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TRXRECTYPE','C',w_TRXRECTYPE,HtW(getComboValue(Ctrl('FMRUIANURB')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXRECTYPE(HtW(getComboValue(Ctrl('FMRUIANURB')),'C'),null,e);
return l_bSetResult;
}
}
function FMRUIANURB_OnFocus(e) {
SetActiveField(Ctrl('FMRUIANURB'),true);
}
function FMRUIANURB_OnBlur(e) {
SetActiveField(Ctrl('FMRUIANURB'),false);
}
function UTFQIBBLAF_Valid(e) {
SetActiveField(Ctrl('UTFQIBBLAF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXCODMAG','C',w_TRXCODMAG,HtW(Ctrl('UTFQIBBLAF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXCODMAG(HtW(Ctrl('UTFQIBBLAF').value,'C'),null,e);
return l_bSetResult;
}
}
function UTFQIBBLAF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UTFQIBBLAF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UTFQIBBLAF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UTFQIBBLAF'),e);
}
function UTFQIBBLAF_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('UTFQIBBLAF')),'linkview_UTFQIBBLAF','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function NSNBJQWLKR_Valid(e) {
SetActiveField(Ctrl('NSNBJQWLKR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXCODUNI','C',w_TRXCODUNI,HtW(Ctrl('NSNBJQWLKR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXCODUNI(HtW(Ctrl('NSNBJQWLKR').value,'C'),null,e);
return l_bSetResult;
}
}
function NSNBJQWLKR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NSNBJQWLKR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NSNBJQWLKR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NSNBJQWLKR'),e);
}
function TZHYQAUMDE_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TRXFLGAUI','C',w_TRXFLGAUI,ChkboxValueAssign(Ctrl('TZHYQAUMDE'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXFLGAUI(ChkboxValueAssign(Ctrl('TZHYQAUMDE'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function TZHYQAUMDE_OnFocus(e) {
SetActiveField(Ctrl('TZHYQAUMDE'),true);
}
function TZHYQAUMDE_OnBlur(e) {
SetActiveField(Ctrl('TZHYQAUMDE'),false);
}
function CMGWBYDKHQ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TRXFLGFOR','C',w_TRXFLGFOR,ChkboxValueAssign(Ctrl('CMGWBYDKHQ'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXFLGFOR(ChkboxValueAssign(Ctrl('CMGWBYDKHQ'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function CMGWBYDKHQ_OnFocus(e) {
SetActiveField(Ctrl('CMGWBYDKHQ'),true);
}
function CMGWBYDKHQ_OnBlur(e) {
SetActiveField(Ctrl('CMGWBYDKHQ'),false);
}
function QKFJKVYCVD_Valid(e) {
SetActiveField(Ctrl('QKFJKVYCVD'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXCOGNOM','C',w_TRXCOGNOM,HtW(Ctrl('QKFJKVYCVD').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXCOGNOM(HtW(Ctrl('QKFJKVYCVD').value,'C'),null,e);
return l_bSetResult;
}
}
function QKFJKVYCVD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QKFJKVYCVD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QKFJKVYCVD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QKFJKVYCVD'),e);
}
function OUUNVPTKEC_Valid(e) {
SetActiveField(Ctrl('OUUNVPTKEC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXNOME','C',w_TRXNOME,HtW(Ctrl('OUUNVPTKEC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXNOME(HtW(Ctrl('OUUNVPTKEC').value,'C'),null,e);
return l_bSetResult;
}
}
function OUUNVPTKEC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OUUNVPTKEC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OUUNVPTKEC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OUUNVPTKEC'),e);
}
function APRONFZYCV_Valid(e) {
SetActiveField(Ctrl('APRONFZYCV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXDOMICI','C',w_TRXDOMICI,HtW(Ctrl('APRONFZYCV').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXDOMICI(HtW(Ctrl('APRONFZYCV').value,'C'),null,e);
return l_bSetResult;
}
}
function APRONFZYCV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('APRONFZYCV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('APRONFZYCV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('APRONFZYCV'),e);
}
function ASIYKLXBCD_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TRXFLGCF','C',w_TRXFLGCF,ChkboxValueAssign(Ctrl('ASIYKLXBCD'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXFLGCF(ChkboxValueAssign(Ctrl('ASIYKLXBCD'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function ASIYKLXBCD_OnFocus(e) {
SetActiveField(Ctrl('ASIYKLXBCD'),true);
}
function ASIYKLXBCD_OnBlur(e) {
SetActiveField(Ctrl('ASIYKLXBCD'),false);
}
function FVJVEJQIYB_Valid(e) {
SetActiveField(Ctrl('FVJVEJQIYB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXCODFIS','C',w_TRXCODFIS,HtW(Ctrl('FVJVEJQIYB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXCODFIS(HtW(Ctrl('FVJVEJQIYB').value,'C'),null,e);
return l_bSetResult;
}
}
function FVJVEJQIYB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FVJVEJQIYB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FVJVEJQIYB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FVJVEJQIYB'),e);
}
function OTJSTXXVID_Valid(e) {
SetActiveField(Ctrl('OTJSTXXVID'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXLUONAS','C',w_TRXLUONAS,HtW(Ctrl('OTJSTXXVID').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXLUONAS(HtW(Ctrl('OTJSTXXVID').value,'C'),null,e);
return l_bSetResult;
}
}
function OTJSTXXVID_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OTJSTXXVID'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OTJSTXXVID'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OTJSTXXVID'),e);
}
function MMSPBVULRO_Valid(e) {
SetActiveField(Ctrl('MMSPBVULRO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXNUMDOC','C',w_TRXNUMDOC,HtW(Ctrl('MMSPBVULRO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXNUMDOC(HtW(Ctrl('MMSPBVULRO').value,'C'),null,e);
return l_bSetResult;
}
}
function MMSPBVULRO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MMSPBVULRO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MMSPBVULRO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MMSPBVULRO'),e);
}
function IFKUOAHUHG_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('IFKUOAHUHG'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('IFKUOAHUHG').value=ApplyPictureToDate(Ctrl('IFKUOAHUHG').value,TranslatePicture(datePattern),'IFKUOAHUHG');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('IFKUOAHUHG'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('IFKUOAHUHG');
}
}
}
SetActiveField(Ctrl('IFKUOAHUHG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXDATSCA','D',w_TRXDATSCA,HtW(Ctrl('IFKUOAHUHG').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXDATSCA(HtW(Ctrl('IFKUOAHUHG').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function IFKUOAHUHG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IFKUOAHUHG'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('IFKUOAHUHG',w_TRXDATSCA,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('IFKUOAHUHG');
SetActiveField(Ctrl('IFKUOAHUHG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IFKUOAHUHG'),e);
}
function IFKUOAHUHG_ZOOM_Click() {
LaunchCalendar(Ctrl('IFKUOAHUHG'));
}
function DRQDHBWECQ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('DRQDHBWECQ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('DRQDHBWECQ').value=ApplyPictureToDate(Ctrl('DRQDHBWECQ').value,TranslatePicture(datePattern),'DRQDHBWECQ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('DRQDHBWECQ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('DRQDHBWECQ');
}
}
}
SetActiveField(Ctrl('DRQDHBWECQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXDATRIL','D',w_TRXDATRIL,HtW(Ctrl('DRQDHBWECQ').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXDATRIL(HtW(Ctrl('DRQDHBWECQ').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function DRQDHBWECQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DRQDHBWECQ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('DRQDHBWECQ',w_TRXDATRIL,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('DRQDHBWECQ');
SetActiveField(Ctrl('DRQDHBWECQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DRQDHBWECQ'),e);
}
function DRQDHBWECQ_ZOOM_Click() {
LaunchCalendar(Ctrl('DRQDHBWECQ'));
}
function KUJLLGUFUU_Valid(e) {
SetActiveField(Ctrl('KUJLLGUFUU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXAUTRIL','C',w_TRXAUTRIL,HtW(Ctrl('KUJLLGUFUU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXAUTRIL(HtW(Ctrl('KUJLLGUFUU').value,'C'),null,e);
return l_bSetResult;
}
}
function KUJLLGUFUU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KUJLLGUFUU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KUJLLGUFUU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KUJLLGUFUU'),e);
}
function SOTHCYQHKP_Valid(e) {
SetActiveField(Ctrl('SOTHCYQHKP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXNAZRES','C',w_TRXNAZRES,HtW(Ctrl('SOTHCYQHKP').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXNAZRES(HtW(Ctrl('SOTHCYQHKP').value,'C'),null,e);
return l_bSetResult;
}
}
function SOTHCYQHKP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SOTHCYQHKP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SOTHCYQHKP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SOTHCYQHKP'),e);
}
function ZDOEFBYPYC_Valid(e) {
SetActiveField(Ctrl('ZDOEFBYPYC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXCITRES','C',w_TRXCITRES,HtW(Ctrl('ZDOEFBYPYC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXCITRES(HtW(Ctrl('ZDOEFBYPYC').value,'C'),null,e);
return l_bSetResult;
}
}
function ZDOEFBYPYC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZDOEFBYPYC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZDOEFBYPYC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZDOEFBYPYC'),e);
}
function ZCRTCXLUUY_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TRXTIPDOC','C',w_TRXTIPDOC,HtW(getComboValue(Ctrl('ZCRTCXLUUY')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXTIPDOC(HtW(getComboValue(Ctrl('ZCRTCXLUUY')),'C'),null,e);
return l_bSetResult;
}
}
function ZCRTCXLUUY_OnFocus(e) {
SetActiveField(Ctrl('ZCRTCXLUUY'),true);
}
function ZCRTCXLUUY_OnBlur(e) {
SetActiveField(Ctrl('ZCRTCXLUUY'),false);
}
function BYTTMKVPJF_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('BYTTMKVPJF'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('BYTTMKVPJF').value=ApplyPictureToDate(Ctrl('BYTTMKVPJF').value,TranslatePicture(datePattern),'BYTTMKVPJF');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('BYTTMKVPJF'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('BYTTMKVPJF');
}
}
}
SetActiveField(Ctrl('BYTTMKVPJF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXDATNAS','D',w_TRXDATNAS,HtW(Ctrl('BYTTMKVPJF').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXDATNAS(HtW(Ctrl('BYTTMKVPJF').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function BYTTMKVPJF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BYTTMKVPJF'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('BYTTMKVPJF',w_TRXDATNAS,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('BYTTMKVPJF');
SetActiveField(Ctrl('BYTTMKVPJF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BYTTMKVPJF'),e);
}
function VUPAGTECJJ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('VUPAGTECJJ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('VUPAGTECJJ').value=ApplyPictureToDate(Ctrl('VUPAGTECJJ').value,TranslatePicture(datePattern),'VUPAGTECJJ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('VUPAGTECJJ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('VUPAGTECJJ');
}
}
}
SetActiveField(Ctrl('VUPAGTECJJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXDATOPE','D',w_TRXDATOPE,HtW(Ctrl('VUPAGTECJJ').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXDATOPE(HtW(Ctrl('VUPAGTECJJ').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function VUPAGTECJJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VUPAGTECJJ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('VUPAGTECJJ',w_TRXDATOPE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('VUPAGTECJJ');
SetActiveField(Ctrl('VUPAGTECJJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VUPAGTECJJ'),e);
}
function VUPAGTECJJ_ZOOM_Click() {
LaunchCalendar(Ctrl('VUPAGTECJJ'));
}
function ATGEKSLXET_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TRXSESSO','C',w_TRXSESSO,HtW(getComboValue(Ctrl('ATGEKSLXET')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXSESSO(HtW(getComboValue(Ctrl('ATGEKSLXET')),'C'),null,e);
return l_bSetResult;
}
}
function ATGEKSLXET_OnFocus(e) {
SetActiveField(Ctrl('ATGEKSLXET'),true);
}
function ATGEKSLXET_OnBlur(e) {
SetActiveField(Ctrl('ATGEKSLXET'),false);
}
function ASSPEANDMC_Valid(e) {
SetActiveField(Ctrl('ASSPEANDMC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR26','C',w_TRXERROR26,HtW(Ctrl('ASSPEANDMC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR26(HtW(Ctrl('ASSPEANDMC').value,'C'),null,e);
return l_bSetResult;
}
}
function ASSPEANDMC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ASSPEANDMC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ASSPEANDMC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ASSPEANDMC'),e);
}
function FMOIMQZAPG_Valid(e) {
SetActiveField(Ctrl('FMOIMQZAPG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR27','C',w_TRXERROR27,HtW(Ctrl('FMOIMQZAPG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR27(HtW(Ctrl('FMOIMQZAPG').value,'C'),null,e);
return l_bSetResult;
}
}
function FMOIMQZAPG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FMOIMQZAPG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FMOIMQZAPG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FMOIMQZAPG'),e);
}
function RKGHXZFQZL_Valid(e) {
SetActiveField(Ctrl('RKGHXZFQZL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR28','C',w_TRXERROR28,HtW(Ctrl('RKGHXZFQZL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR28(HtW(Ctrl('RKGHXZFQZL').value,'C'),null,e);
return l_bSetResult;
}
}
function RKGHXZFQZL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RKGHXZFQZL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RKGHXZFQZL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RKGHXZFQZL'),e);
}
function HEPMULJALS_Valid(e) {
SetActiveField(Ctrl('HEPMULJALS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR29','C',w_TRXERROR29,HtW(Ctrl('HEPMULJALS').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR29(HtW(Ctrl('HEPMULJALS').value,'C'),null,e);
return l_bSetResult;
}
}
function HEPMULJALS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HEPMULJALS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HEPMULJALS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HEPMULJALS'),e);
}
function DYBWDBXZIJ_Valid(e) {
SetActiveField(Ctrl('DYBWDBXZIJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR30','C',w_TRXERROR30,HtW(Ctrl('DYBWDBXZIJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR30(HtW(Ctrl('DYBWDBXZIJ').value,'C'),null,e);
return l_bSetResult;
}
}
function DYBWDBXZIJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DYBWDBXZIJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DYBWDBXZIJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DYBWDBXZIJ'),e);
}
function LISOLVFJNF_Valid(e) {
SetActiveField(Ctrl('LISOLVFJNF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR31','C',w_TRXERROR31,HtW(Ctrl('LISOLVFJNF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR31(HtW(Ctrl('LISOLVFJNF').value,'C'),null,e);
return l_bSetResult;
}
}
function LISOLVFJNF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LISOLVFJNF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LISOLVFJNF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LISOLVFJNF'),e);
}
function BHISKUARAJ_Valid(e) {
SetActiveField(Ctrl('BHISKUARAJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR32','C',w_TRXERROR32,HtW(Ctrl('BHISKUARAJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR32(HtW(Ctrl('BHISKUARAJ').value,'C'),null,e);
return l_bSetResult;
}
}
function BHISKUARAJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BHISKUARAJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BHISKUARAJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BHISKUARAJ'),e);
}
function MSSBSWBLKI_Valid(e) {
SetActiveField(Ctrl('MSSBSWBLKI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR33','C',w_TRXERROR33,HtW(Ctrl('MSSBSWBLKI').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR33(HtW(Ctrl('MSSBSWBLKI').value,'C'),null,e);
return l_bSetResult;
}
}
function MSSBSWBLKI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MSSBSWBLKI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MSSBSWBLKI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MSSBSWBLKI'),e);
}
function ATBSEHTJHH_Valid(e) {
SetActiveField(Ctrl('ATBSEHTJHH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR34','C',w_TRXERROR34,HtW(Ctrl('ATBSEHTJHH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR34(HtW(Ctrl('ATBSEHTJHH').value,'C'),null,e);
return l_bSetResult;
}
}
function ATBSEHTJHH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ATBSEHTJHH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ATBSEHTJHH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ATBSEHTJHH'),e);
}
function CIFSRVZLSK_Valid(e) {
SetActiveField(Ctrl('CIFSRVZLSK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR35','C',w_TRXERROR35,HtW(Ctrl('CIFSRVZLSK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR35(HtW(Ctrl('CIFSRVZLSK').value,'C'),null,e);
return l_bSetResult;
}
}
function CIFSRVZLSK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CIFSRVZLSK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CIFSRVZLSK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CIFSRVZLSK'),e);
}
function FCOYAJZYOF_Valid(e) {
SetActiveField(Ctrl('FCOYAJZYOF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR36','C',w_TRXERROR36,HtW(Ctrl('FCOYAJZYOF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR36(HtW(Ctrl('FCOYAJZYOF').value,'C'),null,e);
return l_bSetResult;
}
}
function FCOYAJZYOF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FCOYAJZYOF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FCOYAJZYOF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FCOYAJZYOF'),e);
}
function ZNHTQWPUYJ_Valid(e) {
SetActiveField(Ctrl('ZNHTQWPUYJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR37','C',w_TRXERROR37,HtW(Ctrl('ZNHTQWPUYJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR37(HtW(Ctrl('ZNHTQWPUYJ').value,'C'),null,e);
return l_bSetResult;
}
}
function ZNHTQWPUYJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZNHTQWPUYJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZNHTQWPUYJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZNHTQWPUYJ'),e);
}
function ULYZEYIIYY_Valid(e) {
SetActiveField(Ctrl('ULYZEYIIYY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR38','C',w_TRXERROR38,HtW(Ctrl('ULYZEYIIYY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR38(HtW(Ctrl('ULYZEYIIYY').value,'C'),null,e);
return l_bSetResult;
}
}
function ULYZEYIIYY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ULYZEYIIYY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ULYZEYIIYY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ULYZEYIIYY'),e);
}
function ZRCBZVUWZE_Valid(e) {
SetActiveField(Ctrl('ZRCBZVUWZE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR39','C',w_TRXERROR39,HtW(Ctrl('ZRCBZVUWZE').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR39(HtW(Ctrl('ZRCBZVUWZE').value,'C'),null,e);
return l_bSetResult;
}
}
function ZRCBZVUWZE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZRCBZVUWZE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZRCBZVUWZE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZRCBZVUWZE'),e);
}
function TCMPTOYHZU_Valid(e) {
SetActiveField(Ctrl('TCMPTOYHZU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR40','C',w_TRXERROR40,HtW(Ctrl('TCMPTOYHZU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR40(HtW(Ctrl('TCMPTOYHZU').value,'C'),null,e);
return l_bSetResult;
}
}
function TCMPTOYHZU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TCMPTOYHZU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TCMPTOYHZU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TCMPTOYHZU'),e);
}
function DYIXHFFDPL_Valid(e) {
SetActiveField(Ctrl('DYIXHFFDPL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR41','C',w_TRXERROR41,HtW(Ctrl('DYIXHFFDPL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR41(HtW(Ctrl('DYIXHFFDPL').value,'C'),null,e);
return l_bSetResult;
}
}
function DYIXHFFDPL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DYIXHFFDPL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DYIXHFFDPL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DYIXHFFDPL'),e);
}
function OZIAVQGVQX_Valid(e) {
SetActiveField(Ctrl('OZIAVQGVQX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR42','C',w_TRXERROR42,HtW(Ctrl('OZIAVQGVQX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR42(HtW(Ctrl('OZIAVQGVQX').value,'C'),null,e);
return l_bSetResult;
}
}
function OZIAVQGVQX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OZIAVQGVQX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OZIAVQGVQX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OZIAVQGVQX'),e);
}
function QURNMKDXBF_Valid(e) {
SetActiveField(Ctrl('QURNMKDXBF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR43','C',w_TRXERROR43,HtW(Ctrl('QURNMKDXBF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR43(HtW(Ctrl('QURNMKDXBF').value,'C'),null,e);
return l_bSetResult;
}
}
function QURNMKDXBF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QURNMKDXBF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QURNMKDXBF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QURNMKDXBF'),e);
}
function MNXGCWMDZI_Valid(e) {
SetActiveField(Ctrl('MNXGCWMDZI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR44','C',w_TRXERROR44,HtW(Ctrl('MNXGCWMDZI').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR44(HtW(Ctrl('MNXGCWMDZI').value,'C'),null,e);
return l_bSetResult;
}
}
function MNXGCWMDZI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MNXGCWMDZI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MNXGCWMDZI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MNXGCWMDZI'),e);
}
function YJUYZEFYVU_Valid(e) {
SetActiveField(Ctrl('YJUYZEFYVU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR45','C',w_TRXERROR45,HtW(Ctrl('YJUYZEFYVU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR45(HtW(Ctrl('YJUYZEFYVU').value,'C'),null,e);
return l_bSetResult;
}
}
function YJUYZEFYVU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YJUYZEFYVU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YJUYZEFYVU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YJUYZEFYVU'),e);
}
function ASNHGNRDBH_Valid(e) {
SetActiveField(Ctrl('ASNHGNRDBH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR46','C',w_TRXERROR46,HtW(Ctrl('ASNHGNRDBH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR46(HtW(Ctrl('ASNHGNRDBH').value,'C'),null,e);
return l_bSetResult;
}
}
function ASNHGNRDBH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ASNHGNRDBH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ASNHGNRDBH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ASNHGNRDBH'),e);
}
function CZSDXMRIYM_Valid(e) {
SetActiveField(Ctrl('CZSDXMRIYM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR47','C',w_TRXERROR47,HtW(Ctrl('CZSDXMRIYM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR47(HtW(Ctrl('CZSDXMRIYM').value,'C'),null,e);
return l_bSetResult;
}
}
function CZSDXMRIYM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CZSDXMRIYM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CZSDXMRIYM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CZSDXMRIYM'),e);
}
function XVGSKNYKNU_Valid(e) {
SetActiveField(Ctrl('XVGSKNYKNU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR48','C',w_TRXERROR48,HtW(Ctrl('XVGSKNYKNU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR48(HtW(Ctrl('XVGSKNYKNU').value,'C'),null,e);
return l_bSetResult;
}
}
function XVGSKNYKNU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XVGSKNYKNU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XVGSKNYKNU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XVGSKNYKNU'),e);
}
function BBGXFOFUHV_Valid(e) {
SetActiveField(Ctrl('BBGXFOFUHV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR49','C',w_TRXERROR49,HtW(Ctrl('BBGXFOFUHV').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR49(HtW(Ctrl('BBGXFOFUHV').value,'C'),null,e);
return l_bSetResult;
}
}
function BBGXFOFUHV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BBGXFOFUHV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BBGXFOFUHV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BBGXFOFUHV'),e);
}
function VKWSDIQTXK_Valid(e) {
SetActiveField(Ctrl('VKWSDIQTXK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXERROR50','C',w_TRXERROR50,HtW(Ctrl('VKWSDIQTXK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXERROR50(HtW(Ctrl('VKWSDIQTXK').value,'C'),null,e);
return l_bSetResult;
}
}
function VKWSDIQTXK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VKWSDIQTXK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VKWSDIQTXK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VKWSDIQTXK'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function LPQRPTUZNB_wrap_Valid(event) {
return LPQRPTUZNB_Valid(event);
}
SPBOUILib.SetInputExit('LPQRPTUZNB',LPQRPTUZNB_wrap_Valid);
function LPQRPTUZNB_wrap_OnFocus(event) {
return LPQRPTUZNB_OnFocus(event);
}
SPBOUILib.SetInputEnter('LPQRPTUZNB',LPQRPTUZNB_wrap_OnFocus);
function LPQRPTUZNB_wrap_OnKeyPress(event) {
return LPQRPTUZNB_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('LPQRPTUZNB',LPQRPTUZNB_wrap_OnKeyPress);
function LPQRPTUZNB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LPQRPTUZNB',LPQRPTUZNB_wrap_OnKeyDown);
function EPEPXVTDDF_wrap_Valid(event) {
return EPEPXVTDDF_Valid(event);
}
SPBOUILib.SetComboChange('EPEPXVTDDF',EPEPXVTDDF_wrap_Valid);
function EPEPXVTDDF_wrap_OnFocus(event) {
return EPEPXVTDDF_OnFocus(event);
}
SPBOUILib.SetInputEnter('EPEPXVTDDF',EPEPXVTDDF_wrap_OnFocus);
function EPEPXVTDDF_wrap_Blur(event) {
return EPEPXVTDDF_OnBlur(event);
}
SPBOUILib.SetInputExit('EPEPXVTDDF',EPEPXVTDDF_wrap_Blur);
function FNVGSTOZTQ_wrap_Valid(event) {
return FNVGSTOZTQ_Valid(event);
}
SPBOUILib.SetInputExit('FNVGSTOZTQ',FNVGSTOZTQ_wrap_Valid);
function FNVGSTOZTQ_wrap_OnFocus(event) {
return FNVGSTOZTQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('FNVGSTOZTQ',FNVGSTOZTQ_wrap_OnFocus);
function FNVGSTOZTQ_wrap_OnKeyPress(event) {
return FNVGSTOZTQ_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('FNVGSTOZTQ',FNVGSTOZTQ_wrap_OnKeyPress);
function FNVGSTOZTQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FNVGSTOZTQ',FNVGSTOZTQ_wrap_OnKeyDown);
function EVKHOJDUVF_wrap_Valid(event) {
return EVKHOJDUVF_Valid(event);
}
SPBOUILib.SetInputExit('EVKHOJDUVF',EVKHOJDUVF_wrap_Valid);
function EVKHOJDUVF_wrap_OnFocus(event) {
return EVKHOJDUVF_OnFocus(event);
}
SPBOUILib.SetInputEnter('EVKHOJDUVF',EVKHOJDUVF_wrap_OnFocus);
function EVKHOJDUVF_wrap_OnKeyPress(event) {
return EVKHOJDUVF_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('EVKHOJDUVF',EVKHOJDUVF_wrap_OnKeyPress);
function EVKHOJDUVF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('EVKHOJDUVF',EVKHOJDUVF_wrap_OnKeyDown);
function FCRFUHHVHU_wrap_Valid(event) {
return FCRFUHHVHU_Valid(event);
}
SPBOUILib.SetInputExit('FCRFUHHVHU',FCRFUHHVHU_wrap_Valid);
function FCRFUHHVHU_wrap_OnFocus(event) {
return FCRFUHHVHU_OnFocus(event);
}
SPBOUILib.SetInputEnter('FCRFUHHVHU',FCRFUHHVHU_wrap_OnFocus);
function FCRFUHHVHU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FCRFUHHVHU',FCRFUHHVHU_wrap_OnKeyDown);
function HZPBCLSNRS_wrap_Valid(event) {
return HZPBCLSNRS_Valid(event);
}
SPBOUILib.SetInputExit('HZPBCLSNRS',HZPBCLSNRS_wrap_Valid);
function HZPBCLSNRS_wrap_OnFocus(event) {
return HZPBCLSNRS_OnFocus(event);
}
SPBOUILib.SetInputEnter('HZPBCLSNRS',HZPBCLSNRS_wrap_OnFocus);
function HZPBCLSNRS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HZPBCLSNRS',HZPBCLSNRS_wrap_OnKeyDown);
function HZPBCLSNRS_ZOOM_setHandlers() {
function HZPBCLSNRS_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?HZPBCLSNRS_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('HZPBCLSNRS_ZOOM',HZPBCLSNRS_ZOOM_wrap_OnClick);
function HZPBCLSNRS_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('HZPBCLSNRS_ZOOM',HZPBCLSNRS_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('HZPBCLSNRS',HZPBCLSNRS_ZOOM_setHandlers);
function LGVQVJPZZP_wrap_Valid(event) {
return LGVQVJPZZP_Valid(event);
}
SPBOUILib.SetInputExit('LGVQVJPZZP',LGVQVJPZZP_wrap_Valid);
function LGVQVJPZZP_wrap_OnFocus(event) {
return LGVQVJPZZP_OnFocus(event);
}
SPBOUILib.SetInputEnter('LGVQVJPZZP',LGVQVJPZZP_wrap_OnFocus);
function LGVQVJPZZP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LGVQVJPZZP',LGVQVJPZZP_wrap_OnKeyDown);
function OKKVRBSRDN_wrap_Valid(event) {
return OKKVRBSRDN_Valid(event);
}
SPBOUILib.SetInputExit('OKKVRBSRDN',OKKVRBSRDN_wrap_Valid);
function OKKVRBSRDN_wrap_OnFocus(event) {
return OKKVRBSRDN_OnFocus(event);
}
SPBOUILib.SetInputEnter('OKKVRBSRDN',OKKVRBSRDN_wrap_OnFocus);
function OKKVRBSRDN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OKKVRBSRDN',OKKVRBSRDN_wrap_OnKeyDown);
function FDXEUOOSVN_wrap_Valid(event) {
return FDXEUOOSVN_Valid(event);
}
SPBOUILib.SetInputExit('FDXEUOOSVN',FDXEUOOSVN_wrap_Valid);
function FDXEUOOSVN_wrap_OnFocus(event) {
return FDXEUOOSVN_OnFocus(event);
}
SPBOUILib.SetInputEnter('FDXEUOOSVN',FDXEUOOSVN_wrap_OnFocus);
function FDXEUOOSVN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FDXEUOOSVN',FDXEUOOSVN_wrap_OnKeyDown);
function YZULLMXBBH_wrap_Valid(event) {
return YZULLMXBBH_Valid(event);
}
SPBOUILib.SetInputExit('YZULLMXBBH',YZULLMXBBH_wrap_Valid);
function YZULLMXBBH_wrap_OnFocus(event) {
return YZULLMXBBH_OnFocus(event);
}
SPBOUILib.SetInputEnter('YZULLMXBBH',YZULLMXBBH_wrap_OnFocus);
function YZULLMXBBH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YZULLMXBBH',YZULLMXBBH_wrap_OnKeyDown);
function UTGSXNXPVT_wrap_Valid(event) {
return UTGSXNXPVT_Valid(event);
}
SPBOUILib.SetInputExit('UTGSXNXPVT',UTGSXNXPVT_wrap_Valid);
function UTGSXNXPVT_wrap_OnFocus(event) {
return UTGSXNXPVT_OnFocus(event);
}
SPBOUILib.SetInputEnter('UTGSXNXPVT',UTGSXNXPVT_wrap_OnFocus);
function UTGSXNXPVT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UTGSXNXPVT',UTGSXNXPVT_wrap_OnKeyDown);
function FMRUIANURB_wrap_Valid(event) {
return FMRUIANURB_Valid(event);
}
SPBOUILib.SetComboChange('FMRUIANURB',FMRUIANURB_wrap_Valid);
function FMRUIANURB_wrap_OnFocus(event) {
return FMRUIANURB_OnFocus(event);
}
SPBOUILib.SetInputEnter('FMRUIANURB',FMRUIANURB_wrap_OnFocus);
function FMRUIANURB_wrap_Blur(event) {
return FMRUIANURB_OnBlur(event);
}
SPBOUILib.SetInputExit('FMRUIANURB',FMRUIANURB_wrap_Blur);
function UTFQIBBLAF_wrap_Valid(event) {
return UTFQIBBLAF_Valid(event);
}
SPBOUILib.SetInputExit('UTFQIBBLAF',UTFQIBBLAF_wrap_Valid);
function UTFQIBBLAF_wrap_OnFocus(event) {
return UTFQIBBLAF_OnFocus(event);
}
SPBOUILib.SetInputEnter('UTFQIBBLAF',UTFQIBBLAF_wrap_OnFocus);
function UTFQIBBLAF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UTFQIBBLAF',UTFQIBBLAF_wrap_OnKeyDown);
function UTFQIBBLAF_ZOOM_setHandlers() {
function UTFQIBBLAF_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?UTFQIBBLAF_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('UTFQIBBLAF_ZOOM',UTFQIBBLAF_ZOOM_wrap_OnClick);
function UTFQIBBLAF_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('UTFQIBBLAF_ZOOM',UTFQIBBLAF_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('UTFQIBBLAF',UTFQIBBLAF_ZOOM_setHandlers);
function NSNBJQWLKR_wrap_Valid(event) {
return NSNBJQWLKR_Valid(event);
}
SPBOUILib.SetInputExit('NSNBJQWLKR',NSNBJQWLKR_wrap_Valid);
function NSNBJQWLKR_wrap_OnFocus(event) {
return NSNBJQWLKR_OnFocus(event);
}
SPBOUILib.SetInputEnter('NSNBJQWLKR',NSNBJQWLKR_wrap_OnFocus);
function NSNBJQWLKR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NSNBJQWLKR',NSNBJQWLKR_wrap_OnKeyDown);
function TZHYQAUMDE_wrap_Valid(event) {
return TZHYQAUMDE_Valid(event);
}
SPBOUILib.SetCheckboxClick('TZHYQAUMDE',TZHYQAUMDE_wrap_Valid);
function TZHYQAUMDE_wrap_OnFocus(event) {
return TZHYQAUMDE_OnFocus(event);
}
SPBOUILib.SetInputEnter('TZHYQAUMDE',TZHYQAUMDE_wrap_OnFocus);
function TZHYQAUMDE_wrap_Blur(event) {
return TZHYQAUMDE_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('TZHYQAUMDE',TZHYQAUMDE_wrap_Blur);
function CMGWBYDKHQ_wrap_Valid(event) {
return CMGWBYDKHQ_Valid(event);
}
SPBOUILib.SetCheckboxClick('CMGWBYDKHQ',CMGWBYDKHQ_wrap_Valid);
function CMGWBYDKHQ_wrap_OnFocus(event) {
return CMGWBYDKHQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('CMGWBYDKHQ',CMGWBYDKHQ_wrap_OnFocus);
function CMGWBYDKHQ_wrap_Blur(event) {
return CMGWBYDKHQ_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('CMGWBYDKHQ',CMGWBYDKHQ_wrap_Blur);
function QKFJKVYCVD_wrap_Valid(event) {
return QKFJKVYCVD_Valid(event);
}
SPBOUILib.SetInputExit('QKFJKVYCVD',QKFJKVYCVD_wrap_Valid);
function QKFJKVYCVD_wrap_OnFocus(event) {
return QKFJKVYCVD_OnFocus(event);
}
SPBOUILib.SetInputEnter('QKFJKVYCVD',QKFJKVYCVD_wrap_OnFocus);
function QKFJKVYCVD_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QKFJKVYCVD',QKFJKVYCVD_wrap_OnKeyDown);
function OUUNVPTKEC_wrap_Valid(event) {
return OUUNVPTKEC_Valid(event);
}
SPBOUILib.SetInputExit('OUUNVPTKEC',OUUNVPTKEC_wrap_Valid);
function OUUNVPTKEC_wrap_OnFocus(event) {
return OUUNVPTKEC_OnFocus(event);
}
SPBOUILib.SetInputEnter('OUUNVPTKEC',OUUNVPTKEC_wrap_OnFocus);
function OUUNVPTKEC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OUUNVPTKEC',OUUNVPTKEC_wrap_OnKeyDown);
function APRONFZYCV_wrap_Valid(event) {
return APRONFZYCV_Valid(event);
}
SPBOUILib.SetInputExit('APRONFZYCV',APRONFZYCV_wrap_Valid);
function APRONFZYCV_wrap_OnFocus(event) {
return APRONFZYCV_OnFocus(event);
}
SPBOUILib.SetInputEnter('APRONFZYCV',APRONFZYCV_wrap_OnFocus);
function APRONFZYCV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('APRONFZYCV',APRONFZYCV_wrap_OnKeyDown);
function ASIYKLXBCD_wrap_Valid(event) {
return ASIYKLXBCD_Valid(event);
}
SPBOUILib.SetCheckboxClick('ASIYKLXBCD',ASIYKLXBCD_wrap_Valid);
function ASIYKLXBCD_wrap_OnFocus(event) {
return ASIYKLXBCD_OnFocus(event);
}
SPBOUILib.SetInputEnter('ASIYKLXBCD',ASIYKLXBCD_wrap_OnFocus);
function ASIYKLXBCD_wrap_Blur(event) {
return ASIYKLXBCD_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('ASIYKLXBCD',ASIYKLXBCD_wrap_Blur);
function FVJVEJQIYB_wrap_Valid(event) {
return FVJVEJQIYB_Valid(event);
}
SPBOUILib.SetInputExit('FVJVEJQIYB',FVJVEJQIYB_wrap_Valid);
function FVJVEJQIYB_wrap_OnFocus(event) {
return FVJVEJQIYB_OnFocus(event);
}
SPBOUILib.SetInputEnter('FVJVEJQIYB',FVJVEJQIYB_wrap_OnFocus);
function FVJVEJQIYB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FVJVEJQIYB',FVJVEJQIYB_wrap_OnKeyDown);
function OTJSTXXVID_wrap_Valid(event) {
return OTJSTXXVID_Valid(event);
}
SPBOUILib.SetInputExit('OTJSTXXVID',OTJSTXXVID_wrap_Valid);
function OTJSTXXVID_wrap_OnFocus(event) {
return OTJSTXXVID_OnFocus(event);
}
SPBOUILib.SetInputEnter('OTJSTXXVID',OTJSTXXVID_wrap_OnFocus);
function OTJSTXXVID_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OTJSTXXVID',OTJSTXXVID_wrap_OnKeyDown);
function MMSPBVULRO_wrap_Valid(event) {
return MMSPBVULRO_Valid(event);
}
SPBOUILib.SetInputExit('MMSPBVULRO',MMSPBVULRO_wrap_Valid);
function MMSPBVULRO_wrap_OnFocus(event) {
return MMSPBVULRO_OnFocus(event);
}
SPBOUILib.SetInputEnter('MMSPBVULRO',MMSPBVULRO_wrap_OnFocus);
function MMSPBVULRO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MMSPBVULRO',MMSPBVULRO_wrap_OnKeyDown);
function IFKUOAHUHG_wrap_Valid(event) {
return IFKUOAHUHG_Valid(event);
}
SPBOUILib.SetInputExit('IFKUOAHUHG',IFKUOAHUHG_wrap_Valid);
function IFKUOAHUHG_wrap_OnFocus(event) {
return IFKUOAHUHG_OnFocus(event);
}
SPBOUILib.SetInputEnter('IFKUOAHUHG',IFKUOAHUHG_wrap_OnFocus);
function IFKUOAHUHG_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('IFKUOAHUHG',IFKUOAHUHG_wrap_OnKeyPress);
function IFKUOAHUHG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('IFKUOAHUHG',IFKUOAHUHG_wrap_OnKeyDown);
function IFKUOAHUHG_ZOOM_setHandlers() {
function IFKUOAHUHG_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?IFKUOAHUHG_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('IFKUOAHUHG_ZOOM',IFKUOAHUHG_ZOOM_wrap_OnClick);
function IFKUOAHUHG_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('IFKUOAHUHG_ZOOM',IFKUOAHUHG_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('IFKUOAHUHG',IFKUOAHUHG_ZOOM_setHandlers);
function DRQDHBWECQ_wrap_Valid(event) {
return DRQDHBWECQ_Valid(event);
}
SPBOUILib.SetInputExit('DRQDHBWECQ',DRQDHBWECQ_wrap_Valid);
function DRQDHBWECQ_wrap_OnFocus(event) {
return DRQDHBWECQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('DRQDHBWECQ',DRQDHBWECQ_wrap_OnFocus);
function DRQDHBWECQ_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('DRQDHBWECQ',DRQDHBWECQ_wrap_OnKeyPress);
function DRQDHBWECQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('DRQDHBWECQ',DRQDHBWECQ_wrap_OnKeyDown);
function DRQDHBWECQ_ZOOM_setHandlers() {
function DRQDHBWECQ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?DRQDHBWECQ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('DRQDHBWECQ_ZOOM',DRQDHBWECQ_ZOOM_wrap_OnClick);
function DRQDHBWECQ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('DRQDHBWECQ_ZOOM',DRQDHBWECQ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('DRQDHBWECQ',DRQDHBWECQ_ZOOM_setHandlers);
function KUJLLGUFUU_wrap_Valid(event) {
return KUJLLGUFUU_Valid(event);
}
SPBOUILib.SetInputExit('KUJLLGUFUU',KUJLLGUFUU_wrap_Valid);
function KUJLLGUFUU_wrap_OnFocus(event) {
return KUJLLGUFUU_OnFocus(event);
}
SPBOUILib.SetInputEnter('KUJLLGUFUU',KUJLLGUFUU_wrap_OnFocus);
function KUJLLGUFUU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KUJLLGUFUU',KUJLLGUFUU_wrap_OnKeyDown);
function SOTHCYQHKP_wrap_Valid(event) {
return SOTHCYQHKP_Valid(event);
}
SPBOUILib.SetInputExit('SOTHCYQHKP',SOTHCYQHKP_wrap_Valid);
function SOTHCYQHKP_wrap_OnFocus(event) {
return SOTHCYQHKP_OnFocus(event);
}
SPBOUILib.SetInputEnter('SOTHCYQHKP',SOTHCYQHKP_wrap_OnFocus);
function SOTHCYQHKP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SOTHCYQHKP',SOTHCYQHKP_wrap_OnKeyDown);
function ZDOEFBYPYC_wrap_Valid(event) {
return ZDOEFBYPYC_Valid(event);
}
SPBOUILib.SetInputExit('ZDOEFBYPYC',ZDOEFBYPYC_wrap_Valid);
function ZDOEFBYPYC_wrap_OnFocus(event) {
return ZDOEFBYPYC_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZDOEFBYPYC',ZDOEFBYPYC_wrap_OnFocus);
function ZDOEFBYPYC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZDOEFBYPYC',ZDOEFBYPYC_wrap_OnKeyDown);
function ZCRTCXLUUY_wrap_Valid(event) {
return ZCRTCXLUUY_Valid(event);
}
SPBOUILib.SetComboChange('ZCRTCXLUUY',ZCRTCXLUUY_wrap_Valid);
function ZCRTCXLUUY_wrap_OnFocus(event) {
return ZCRTCXLUUY_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZCRTCXLUUY',ZCRTCXLUUY_wrap_OnFocus);
function ZCRTCXLUUY_wrap_Blur(event) {
return ZCRTCXLUUY_OnBlur(event);
}
SPBOUILib.SetInputExit('ZCRTCXLUUY',ZCRTCXLUUY_wrap_Blur);
function BYTTMKVPJF_wrap_Valid(event) {
return BYTTMKVPJF_Valid(event);
}
SPBOUILib.SetInputExit('BYTTMKVPJF',BYTTMKVPJF_wrap_Valid);
function BYTTMKVPJF_wrap_OnFocus(event) {
return BYTTMKVPJF_OnFocus(event);
}
SPBOUILib.SetInputEnter('BYTTMKVPJF',BYTTMKVPJF_wrap_OnFocus);
function BYTTMKVPJF_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('BYTTMKVPJF',BYTTMKVPJF_wrap_OnKeyPress);
function BYTTMKVPJF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('BYTTMKVPJF',BYTTMKVPJF_wrap_OnKeyDown);
function VUPAGTECJJ_wrap_Valid(event) {
return VUPAGTECJJ_Valid(event);
}
SPBOUILib.SetInputExit('VUPAGTECJJ',VUPAGTECJJ_wrap_Valid);
function VUPAGTECJJ_wrap_OnFocus(event) {
return VUPAGTECJJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('VUPAGTECJJ',VUPAGTECJJ_wrap_OnFocus);
function VUPAGTECJJ_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('VUPAGTECJJ',VUPAGTECJJ_wrap_OnKeyPress);
function VUPAGTECJJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('VUPAGTECJJ',VUPAGTECJJ_wrap_OnKeyDown);
function VUPAGTECJJ_ZOOM_setHandlers() {
function VUPAGTECJJ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?VUPAGTECJJ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('VUPAGTECJJ_ZOOM',VUPAGTECJJ_ZOOM_wrap_OnClick);
function VUPAGTECJJ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('VUPAGTECJJ_ZOOM',VUPAGTECJJ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('VUPAGTECJJ',VUPAGTECJJ_ZOOM_setHandlers);
function ATGEKSLXET_wrap_Valid(event) {
return ATGEKSLXET_Valid(event);
}
SPBOUILib.SetComboChange('ATGEKSLXET',ATGEKSLXET_wrap_Valid);
function ATGEKSLXET_wrap_OnFocus(event) {
return ATGEKSLXET_OnFocus(event);
}
SPBOUILib.SetInputEnter('ATGEKSLXET',ATGEKSLXET_wrap_OnFocus);
function ATGEKSLXET_wrap_Blur(event) {
return ATGEKSLXET_OnBlur(event);
}
SPBOUILib.SetInputExit('ATGEKSLXET',ATGEKSLXET_wrap_Blur);
function ASSPEANDMC_wrap_Valid(event) {
return ASSPEANDMC_Valid(event);
}
SPBOUILib.SetInputExit('ASSPEANDMC',ASSPEANDMC_wrap_Valid);
function ASSPEANDMC_wrap_OnFocus(event) {
return ASSPEANDMC_OnFocus(event);
}
SPBOUILib.SetInputEnter('ASSPEANDMC',ASSPEANDMC_wrap_OnFocus);
function ASSPEANDMC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ASSPEANDMC',ASSPEANDMC_wrap_OnKeyDown);
function FMOIMQZAPG_wrap_Valid(event) {
return FMOIMQZAPG_Valid(event);
}
SPBOUILib.SetInputExit('FMOIMQZAPG',FMOIMQZAPG_wrap_Valid);
function FMOIMQZAPG_wrap_OnFocus(event) {
return FMOIMQZAPG_OnFocus(event);
}
SPBOUILib.SetInputEnter('FMOIMQZAPG',FMOIMQZAPG_wrap_OnFocus);
function FMOIMQZAPG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FMOIMQZAPG',FMOIMQZAPG_wrap_OnKeyDown);
function RKGHXZFQZL_wrap_Valid(event) {
return RKGHXZFQZL_Valid(event);
}
SPBOUILib.SetInputExit('RKGHXZFQZL',RKGHXZFQZL_wrap_Valid);
function RKGHXZFQZL_wrap_OnFocus(event) {
return RKGHXZFQZL_OnFocus(event);
}
SPBOUILib.SetInputEnter('RKGHXZFQZL',RKGHXZFQZL_wrap_OnFocus);
function RKGHXZFQZL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RKGHXZFQZL',RKGHXZFQZL_wrap_OnKeyDown);
function HEPMULJALS_wrap_Valid(event) {
return HEPMULJALS_Valid(event);
}
SPBOUILib.SetInputExit('HEPMULJALS',HEPMULJALS_wrap_Valid);
function HEPMULJALS_wrap_OnFocus(event) {
return HEPMULJALS_OnFocus(event);
}
SPBOUILib.SetInputEnter('HEPMULJALS',HEPMULJALS_wrap_OnFocus);
function HEPMULJALS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HEPMULJALS',HEPMULJALS_wrap_OnKeyDown);
function DYBWDBXZIJ_wrap_Valid(event) {
return DYBWDBXZIJ_Valid(event);
}
SPBOUILib.SetInputExit('DYBWDBXZIJ',DYBWDBXZIJ_wrap_Valid);
function DYBWDBXZIJ_wrap_OnFocus(event) {
return DYBWDBXZIJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('DYBWDBXZIJ',DYBWDBXZIJ_wrap_OnFocus);
function DYBWDBXZIJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DYBWDBXZIJ',DYBWDBXZIJ_wrap_OnKeyDown);
function LISOLVFJNF_wrap_Valid(event) {
return LISOLVFJNF_Valid(event);
}
SPBOUILib.SetInputExit('LISOLVFJNF',LISOLVFJNF_wrap_Valid);
function LISOLVFJNF_wrap_OnFocus(event) {
return LISOLVFJNF_OnFocus(event);
}
SPBOUILib.SetInputEnter('LISOLVFJNF',LISOLVFJNF_wrap_OnFocus);
function LISOLVFJNF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LISOLVFJNF',LISOLVFJNF_wrap_OnKeyDown);
function BHISKUARAJ_wrap_Valid(event) {
return BHISKUARAJ_Valid(event);
}
SPBOUILib.SetInputExit('BHISKUARAJ',BHISKUARAJ_wrap_Valid);
function BHISKUARAJ_wrap_OnFocus(event) {
return BHISKUARAJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('BHISKUARAJ',BHISKUARAJ_wrap_OnFocus);
function BHISKUARAJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BHISKUARAJ',BHISKUARAJ_wrap_OnKeyDown);
function MSSBSWBLKI_wrap_Valid(event) {
return MSSBSWBLKI_Valid(event);
}
SPBOUILib.SetInputExit('MSSBSWBLKI',MSSBSWBLKI_wrap_Valid);
function MSSBSWBLKI_wrap_OnFocus(event) {
return MSSBSWBLKI_OnFocus(event);
}
SPBOUILib.SetInputEnter('MSSBSWBLKI',MSSBSWBLKI_wrap_OnFocus);
function MSSBSWBLKI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MSSBSWBLKI',MSSBSWBLKI_wrap_OnKeyDown);
function ATBSEHTJHH_wrap_Valid(event) {
return ATBSEHTJHH_Valid(event);
}
SPBOUILib.SetInputExit('ATBSEHTJHH',ATBSEHTJHH_wrap_Valid);
function ATBSEHTJHH_wrap_OnFocus(event) {
return ATBSEHTJHH_OnFocus(event);
}
SPBOUILib.SetInputEnter('ATBSEHTJHH',ATBSEHTJHH_wrap_OnFocus);
function ATBSEHTJHH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ATBSEHTJHH',ATBSEHTJHH_wrap_OnKeyDown);
function CIFSRVZLSK_wrap_Valid(event) {
return CIFSRVZLSK_Valid(event);
}
SPBOUILib.SetInputExit('CIFSRVZLSK',CIFSRVZLSK_wrap_Valid);
function CIFSRVZLSK_wrap_OnFocus(event) {
return CIFSRVZLSK_OnFocus(event);
}
SPBOUILib.SetInputEnter('CIFSRVZLSK',CIFSRVZLSK_wrap_OnFocus);
function CIFSRVZLSK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CIFSRVZLSK',CIFSRVZLSK_wrap_OnKeyDown);
function FCOYAJZYOF_wrap_Valid(event) {
return FCOYAJZYOF_Valid(event);
}
SPBOUILib.SetInputExit('FCOYAJZYOF',FCOYAJZYOF_wrap_Valid);
function FCOYAJZYOF_wrap_OnFocus(event) {
return FCOYAJZYOF_OnFocus(event);
}
SPBOUILib.SetInputEnter('FCOYAJZYOF',FCOYAJZYOF_wrap_OnFocus);
function FCOYAJZYOF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FCOYAJZYOF',FCOYAJZYOF_wrap_OnKeyDown);
function ZNHTQWPUYJ_wrap_Valid(event) {
return ZNHTQWPUYJ_Valid(event);
}
SPBOUILib.SetInputExit('ZNHTQWPUYJ',ZNHTQWPUYJ_wrap_Valid);
function ZNHTQWPUYJ_wrap_OnFocus(event) {
return ZNHTQWPUYJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZNHTQWPUYJ',ZNHTQWPUYJ_wrap_OnFocus);
function ZNHTQWPUYJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZNHTQWPUYJ',ZNHTQWPUYJ_wrap_OnKeyDown);
function ULYZEYIIYY_wrap_Valid(event) {
return ULYZEYIIYY_Valid(event);
}
SPBOUILib.SetInputExit('ULYZEYIIYY',ULYZEYIIYY_wrap_Valid);
function ULYZEYIIYY_wrap_OnFocus(event) {
return ULYZEYIIYY_OnFocus(event);
}
SPBOUILib.SetInputEnter('ULYZEYIIYY',ULYZEYIIYY_wrap_OnFocus);
function ULYZEYIIYY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ULYZEYIIYY',ULYZEYIIYY_wrap_OnKeyDown);
function ZRCBZVUWZE_wrap_Valid(event) {
return ZRCBZVUWZE_Valid(event);
}
SPBOUILib.SetInputExit('ZRCBZVUWZE',ZRCBZVUWZE_wrap_Valid);
function ZRCBZVUWZE_wrap_OnFocus(event) {
return ZRCBZVUWZE_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZRCBZVUWZE',ZRCBZVUWZE_wrap_OnFocus);
function ZRCBZVUWZE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZRCBZVUWZE',ZRCBZVUWZE_wrap_OnKeyDown);
function TCMPTOYHZU_wrap_Valid(event) {
return TCMPTOYHZU_Valid(event);
}
SPBOUILib.SetInputExit('TCMPTOYHZU',TCMPTOYHZU_wrap_Valid);
function TCMPTOYHZU_wrap_OnFocus(event) {
return TCMPTOYHZU_OnFocus(event);
}
SPBOUILib.SetInputEnter('TCMPTOYHZU',TCMPTOYHZU_wrap_OnFocus);
function TCMPTOYHZU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TCMPTOYHZU',TCMPTOYHZU_wrap_OnKeyDown);
function DYIXHFFDPL_wrap_Valid(event) {
return DYIXHFFDPL_Valid(event);
}
SPBOUILib.SetInputExit('DYIXHFFDPL',DYIXHFFDPL_wrap_Valid);
function DYIXHFFDPL_wrap_OnFocus(event) {
return DYIXHFFDPL_OnFocus(event);
}
SPBOUILib.SetInputEnter('DYIXHFFDPL',DYIXHFFDPL_wrap_OnFocus);
function DYIXHFFDPL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DYIXHFFDPL',DYIXHFFDPL_wrap_OnKeyDown);
function OZIAVQGVQX_wrap_Valid(event) {
return OZIAVQGVQX_Valid(event);
}
SPBOUILib.SetInputExit('OZIAVQGVQX',OZIAVQGVQX_wrap_Valid);
function OZIAVQGVQX_wrap_OnFocus(event) {
return OZIAVQGVQX_OnFocus(event);
}
SPBOUILib.SetInputEnter('OZIAVQGVQX',OZIAVQGVQX_wrap_OnFocus);
function OZIAVQGVQX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OZIAVQGVQX',OZIAVQGVQX_wrap_OnKeyDown);
function QURNMKDXBF_wrap_Valid(event) {
return QURNMKDXBF_Valid(event);
}
SPBOUILib.SetInputExit('QURNMKDXBF',QURNMKDXBF_wrap_Valid);
function QURNMKDXBF_wrap_OnFocus(event) {
return QURNMKDXBF_OnFocus(event);
}
SPBOUILib.SetInputEnter('QURNMKDXBF',QURNMKDXBF_wrap_OnFocus);
function QURNMKDXBF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QURNMKDXBF',QURNMKDXBF_wrap_OnKeyDown);
function MNXGCWMDZI_wrap_Valid(event) {
return MNXGCWMDZI_Valid(event);
}
SPBOUILib.SetInputExit('MNXGCWMDZI',MNXGCWMDZI_wrap_Valid);
function MNXGCWMDZI_wrap_OnFocus(event) {
return MNXGCWMDZI_OnFocus(event);
}
SPBOUILib.SetInputEnter('MNXGCWMDZI',MNXGCWMDZI_wrap_OnFocus);
function MNXGCWMDZI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MNXGCWMDZI',MNXGCWMDZI_wrap_OnKeyDown);
function YJUYZEFYVU_wrap_Valid(event) {
return YJUYZEFYVU_Valid(event);
}
SPBOUILib.SetInputExit('YJUYZEFYVU',YJUYZEFYVU_wrap_Valid);
function YJUYZEFYVU_wrap_OnFocus(event) {
return YJUYZEFYVU_OnFocus(event);
}
SPBOUILib.SetInputEnter('YJUYZEFYVU',YJUYZEFYVU_wrap_OnFocus);
function YJUYZEFYVU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YJUYZEFYVU',YJUYZEFYVU_wrap_OnKeyDown);
function ASNHGNRDBH_wrap_Valid(event) {
return ASNHGNRDBH_Valid(event);
}
SPBOUILib.SetInputExit('ASNHGNRDBH',ASNHGNRDBH_wrap_Valid);
function ASNHGNRDBH_wrap_OnFocus(event) {
return ASNHGNRDBH_OnFocus(event);
}
SPBOUILib.SetInputEnter('ASNHGNRDBH',ASNHGNRDBH_wrap_OnFocus);
function ASNHGNRDBH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ASNHGNRDBH',ASNHGNRDBH_wrap_OnKeyDown);
function CZSDXMRIYM_wrap_Valid(event) {
return CZSDXMRIYM_Valid(event);
}
SPBOUILib.SetInputExit('CZSDXMRIYM',CZSDXMRIYM_wrap_Valid);
function CZSDXMRIYM_wrap_OnFocus(event) {
return CZSDXMRIYM_OnFocus(event);
}
SPBOUILib.SetInputEnter('CZSDXMRIYM',CZSDXMRIYM_wrap_OnFocus);
function CZSDXMRIYM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CZSDXMRIYM',CZSDXMRIYM_wrap_OnKeyDown);
function XVGSKNYKNU_wrap_Valid(event) {
return XVGSKNYKNU_Valid(event);
}
SPBOUILib.SetInputExit('XVGSKNYKNU',XVGSKNYKNU_wrap_Valid);
function XVGSKNYKNU_wrap_OnFocus(event) {
return XVGSKNYKNU_OnFocus(event);
}
SPBOUILib.SetInputEnter('XVGSKNYKNU',XVGSKNYKNU_wrap_OnFocus);
function XVGSKNYKNU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XVGSKNYKNU',XVGSKNYKNU_wrap_OnKeyDown);
function BBGXFOFUHV_wrap_Valid(event) {
return BBGXFOFUHV_Valid(event);
}
SPBOUILib.SetInputExit('BBGXFOFUHV',BBGXFOFUHV_wrap_Valid);
function BBGXFOFUHV_wrap_OnFocus(event) {
return BBGXFOFUHV_OnFocus(event);
}
SPBOUILib.SetInputEnter('BBGXFOFUHV',BBGXFOFUHV_wrap_OnFocus);
function BBGXFOFUHV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BBGXFOFUHV',BBGXFOFUHV_wrap_OnKeyDown);
function VKWSDIQTXK_wrap_Valid(event) {
return VKWSDIQTXK_Valid(event);
}
SPBOUILib.SetInputExit('VKWSDIQTXK',VKWSDIQTXK_wrap_Valid);
function VKWSDIQTXK_wrap_OnFocus(event) {
return VKWSDIQTXK_OnFocus(event);
}
SPBOUILib.SetInputEnter('VKWSDIQTXK',VKWSDIQTXK_wrap_OnFocus);
function VKWSDIQTXK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VKWSDIQTXK',VKWSDIQTXK_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["EPEPXVTDDF"],"page_3":["ASSPEANDMC"]};
FocusFirstComponent.query={"page_1":["LPQRPTUZNB","EPEPXVTDDF"],"page_3":["ASSPEANDMC"]};
FocusFirstComponent.otherwise={"page_1":["EPEPXVTDDF"],"page_3":["ASSPEANDMC"]};
function Help() {
windowOpenForeground('../doc/armt_wutrxchk_aui_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_TRXCODPRG=a[0];
op_TRXCODPRG=a[1];
w_TRSSEGNO=a[2];
w_TRXIMPORTO=a[3];
w_TRXCONTAN=a[4];
w_TRXUNIQUE=a[5];
w_TRXCODDIP=a[6];
w_TRXCOGCON=a[7];
w_TRXNOMCON=a[8];
w_TRXDESTIN=a[9];
w_TRXMTCN=a[10];
w_TRXCODCAS=a[11];
w_TRXRECTYPE=a[12];
w_TRXCODMAG=a[13];
w_TRXCODUNI=a[14];
w_TRXFLGAUI=a[15];
w_TRXFLGFOR=a[16];
w_TRXERROR01=a[17];
w_TRXERROR02=a[18];
w_TRXERROR03=a[19];
w_TRXERROR04=a[20];
w_TRXERROR05=a[21];
w_TRXERROR06=a[22];
w_TRXERROR07=a[23];
w_TRXERROR08=a[24];
w_TRXERROR09=a[25];
w_TRXERROR10=a[26];
w_TRXERROR11=a[27];
w_TRXERROR12=a[28];
w_TRXERROR13=a[29];
w_TRXERROR14=a[30];
w_TRXERROR15=a[31];
w_TRXERROR16=a[32];
w_TRXERROR17=a[33];
w_TRXERROR18=a[34];
w_TRXERROR19=a[35];
w_TRXERROR20=a[36];
w_TRXERROR21=a[37];
w_TRXERROR22=a[38];
w_TRXERROR23=a[39];
w_TRXERROR24=a[40];
w_TRXERROR25=a[41];
w_TRXERROR26=a[42];
w_TRXERROR27=a[43];
w_TRXERROR28=a[44];
w_TRXERROR29=a[45];
w_TRXERROR30=a[46];
w_TRXERROR31=a[47];
w_TRXERROR32=a[48];
w_TRXERROR33=a[49];
w_TRXERROR34=a[50];
w_TRXERROR35=a[51];
w_TRXERROR36=a[52];
w_TRXERROR37=a[53];
w_TRXERROR38=a[54];
w_TRXERROR39=a[55];
w_TRXERROR40=a[56];
w_TRXERROR41=a[57];
w_TRXERROR42=a[58];
w_TRXERROR43=a[59];
w_TRXERROR44=a[60];
w_TRXERROR45=a[61];
w_TRXERROR46=a[62];
w_TRXERROR47=a[63];
w_TRXERROR48=a[64];
w_TRXERROR49=a[65];
w_TRXERROR50=a[66];
w_TRXCOGNOM=a[67];
w_TRXNOME=a[68];
w_TRXDOMICI=a[69];
w_TRXFLGCF=a[70];
w_TRXCODFIS=a[71];
w_TRXLUONAS=a[72];
w_TRXNUMDOC=a[73];
w_TRXDATSCA=a[74];
w_TRXDATRIL=a[75];
w_TRXAUTRIL=a[76];
w_TRXNAZRES=a[77];
w_TRXCITRES=a[78];
w_TRXTIPDOC=a[79];
w_TRXDATNAS=a[80];
w_TRXDATOPE=a[81];
w_TRXSESSO=a[82];
w_TRXNASSTATO=a[83];
w_TRXNASCOMUN=a[84];
w_TRXFLGCON=a[85];
w_xMADESCRI=a[86];
w_xDESCRIZ=a[87];
w_doctype=a[88];
w_sesso=a[89];
m_PrimaryKeys=['TRXCODPRG'];
}
function i_PrimaryKey() {
return 'wutrxchk'+'\\'+CPLib.ToCPStr(w_TRXCODPRG);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_wutrxchk_aui',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_TRXCODDIP,'C'); },"field":"AGACCODE","type":"C"},{"expression":function() { return WtA(w_xDESCRIZ,'C'); },"field":"DESCRIZ","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('anadip','C'),"uid":"HZPBCLSNRS"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_TRXCODMAG,'C'); },"field":"MANAIDWU","type":"C"},{"expression":function() { return WtA(w_xMADESCRI,'C'); },"field":"MADESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbmacage','C'),"uid":"UTFQIBBLAF"});
}
_Obli('TRXERROR49',0,'BBGXFOFUHV',false,"1724475806")
_Obli('TRSSEGNO',0,'EPEPXVTDDF',false,"1316049330")
_Obli('TRXIMPORTO',1,'FNVGSTOZTQ',false,"1991862041")
_Obli('TRXCONTAN',1,'EVKHOJDUVF',false,"10884427469")
_Obli('TRXUNIQUE',0,'FCRFUHHVHU',false,"11228111751")
_Obli('TRXCODDIP',0,'HZPBCLSNRS',false,"1027280874")
_Obli('TRXCOGCON',0,'LGVQVJPZZP',false,"10206540776")
_Obli('TRXNOMCON',0,'OKKVRBSRDN',false,"517946066")
_Obli('TRXDESTIN',0,'FDXEUOOSVN',false,"10302116186")
_Obli('TRXMTCN',0,'YZULLMXBBH',false,"829110543")
_Obli('TRXCODCAS',0,'UTGSXNXPVT',false,"423990228")
_Obli('TRXRECTYPE',0,'FMRUIANURB',false,"11706569101")
_Obli('TRXCODMAG',0,'UTFQIBBLAF',false,"1114794632")
_Obli('TRXCODUNI',0,'NSNBJQWLKR',false,"2115266609")
_Obli('TRXFLGAUI',0,'TZHYQAUMDE',false,"887948673")
_Obli('TRXFLGFOR',0,'CMGWBYDKHQ',false,"1636021524")
_Obli('TRXERROR47',0,'CZSDXMRIYM',false,"1724475804")
_Obli('TRXERROR46',0,'ASNHGNRDBH',false,"1724475803")
_Obli('TRXCOGNOM',0,'QKFJKVYCVD',false,"1816546867")
_Obli('TRXNOME',0,'OUUNVPTKEC',false,"443454")
_Obli('TRXDOMICI',0,'APRONFZYCV',false,"49939619")
_Obli('TRXFLGCF',0,'ASIYKLXBCD',false,"1563406272")
_Obli('TRXCODFIS',0,'FVJVEJQIYB',false,"10782899903")
_Obli('TRXLUONAS',0,'OTJSTXXVID',false,"12123333988")
_Obli('TRXNUMDOC',0,'MMSPBVULRO',false,"10759885763")
_Obli('TRXDATSCA',2,'IFKUOAHUHG',false,"628384699")
_Obli('TRXDATRIL',2,'DRQDHBWECQ',false,"10613332584")
_Obli('TRXAUTRIL',0,'KUJLLGUFUU',false,"979125998")
_Obli('TRXNAZRES',0,'SOTHCYQHKP',false,"485943447")
_Obli('TRXCITRES',0,'ZDOEFBYPYC',false,"580410781")
_Obli('TRXTIPDOC',0,'ZCRTCXLUUY',false,"11429032151")
_Obli('TRXDATNAS',2,'BYTTMKVPJF',false,"10703188046")
_Obli('TRXDATOPE',2,'VUPAGTECJJ',false,"829201110")
_Obli('TRXSESSO',0,'ATGEKSLXET',false,"7776675")
_Obli('TRXERROR45',0,'YJUYZEFYVU',false,"1724475802")
_Obli('TRXERROR44',0,'MNXGCWMDZI',false,"1724475801")
_Obli('TRXERROR43',0,'QURNMKDXBF',false,"1724475800")
_Obli('TRXERROR42',0,'OZIAVQGVQX',false,"1724475799")
_Obli('TRXERROR41',0,'DYIXHFFDPL',false,"1724475798")
_Obli('TRXERROR40',0,'TCMPTOYHZU',false,"1724475797")
_Obli('TRXERROR39',0,'ZRCBZVUWZE',false,"1456040350")
_Obli('TRXERROR38',0,'ULYZEYIIYY',false,"1456040349")
_Obli('TRXERROR37',0,'ZNHTQWPUYJ',false,"1456040348")
_Obli('TRXERROR36',0,'FCOYAJZYOF',false,"1456040347")
_Obli('TRXERROR50',0,'VKWSDIQTXK',false,"1992911253")
_Obli('TRXERROR34',0,'ATBSEHTJHH',false,"1456040345")
_Obli('TRXERROR33',0,'MSSBSWBLKI',false,"1456040344")
_Obli('TRXERROR32',0,'BHISKUARAJ',false,"1456040343")
_Obli('TRXERROR31',0,'LISOLVFJNF',false,"1456040342")
_Obli('TRXERROR30',0,'DYBWDBXZIJ',false,"1456040341")
_Obli('TRXERROR29',0,'HEPMULJALS',false,"1187604894")
_Obli('TRXERROR48',0,'XVGSKNYKNU',false,"1724475805")
_Obli('TRXERROR35',0,'CIFSRVZLSK',false,"1456040346")
_Obli('TRXERROR28',0,'RKGHXZFQZL',false,"1187604893")
_Obli('TRXERROR27',0,'FMOIMQZAPG',false,"11463195291")
_Obli('TRXERROR26',0,'ASSPEANDMC',false,"1187604891")
