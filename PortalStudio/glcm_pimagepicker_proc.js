function SetControlsValue() {
var c;
var c;
if(c=Ctrl('XUKRDCQOWH')) c.value = WtH(w_imageFilter,'C',100,0,'')
if (Gt(m_nRows,0) && Lt(m_nCurrentRow,m_oTrsFW.length)) {
if (Ne(Ctrl('KPWHGLIYFW_'+m_nCurrentRow),null)) {
}
if (Ne(Ctrl('DAXQIGIZPL_'+m_nCurrentRow),null)) {
var tmp_DAXQIGIZPL = ToResource('images/portalstudio_ord_'+w_Orderdirection+'.gif');
if (Ne(e_DAXQIGIZPL,tmp_DAXQIGIZPL)) {
if(c=Ctrl('DAXQIGIZPL_'+m_nCurrentRow)) c.src=tmp_DAXQIGIZPL;
setTimeout('scaleImage(\'DAXQIGIZPL_'+l_nIdx+'\',15,15)',0);
e_DAXQIGIZPL=tmp_DAXQIGIZPL;
}
}
if (Ne(Ctrl('UWYFWAPCIQ_'+m_nCurrentRow),null)) {
var tmp_UWYFWAPCIQ = ToResource('images/portalstudio_ord_'+w_Orderdirection+'.gif');
if (Ne(e_UWYFWAPCIQ,tmp_UWYFWAPCIQ)) {
if(c=Ctrl('UWYFWAPCIQ_'+m_nCurrentRow)) c.src=tmp_UWYFWAPCIQ;
setTimeout('scaleImage(\'UWYFWAPCIQ_'+l_nIdx+'\',15,15)',0);
e_UWYFWAPCIQ=tmp_UWYFWAPCIQ;
}
}
if (Ne(Ctrl('GNGKNICNUH_'+m_nCurrentRow),null)) {
var tmp_GNGKNICNUH = ToResource('images/portalstudio_ord_'+w_Orderdirection+'.gif');
if (Ne(e_GNGKNICNUH,tmp_GNGKNICNUH)) {
if(c=Ctrl('GNGKNICNUH_'+m_nCurrentRow)) c.src=tmp_GNGKNICNUH;
setTimeout('scaleImage(\'GNGKNICNUH_'+l_nIdx+'\',15,15)',0);
e_GNGKNICNUH=tmp_GNGKNICNUH;
}
}
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
HideUI();
}
HideUI.lblids["imageFilter"]=['ZNKSDPDSTT'];
function href_TIXKETQEMA(p_nRow) {
ChangeRow(p_nRow);
ViewImage(c_url)
}
function href_OSFPDXIQEM(p_nRow) {
ChangeRow(p_nRow);
ViewImage(c_url)
}
function href_FGQCMAKHVP(p_nRow) {
ChangeRow(p_nRow);
(c_isdir?drillto(c_name):ViewImage(c_url))
}
function href_NVGGLTXCDQ(p_nRow) {
ChangeRow(p_nRow);
DeleteImage(c_name)
}
function href_DAXQIGIZPL(p_nRow) {
ChangeRow(p_nRow);
order('name',(Eq(w_Orderdirection,'az')?'za':'az'))
}
function href_UWYFWAPCIQ(p_nRow) {
ChangeRow(p_nRow);
order('size',(Eq(w_Orderdirection,'az')?'za':'az'))
}
function href_GNGKNICNUH(p_nRow) {
ChangeRow(p_nRow);
order('date',(Eq(w_Orderdirection,'az')?'za':'az'))
}
function href_HWSPROBKQP(p_nRow) {
ChangeRow(p_nRow);
order('name','az')
}
function href_YFCGSXQUNZ(p_nRow) {
ChangeRow(p_nRow);
order('size','az')
}
function href_KMNBGIYIEW(p_nRow) {
ChangeRow(p_nRow);
order('date','az')
}
function href_JTUXWIBDYN(p_nRow) {
ChangeRow(p_nRow);
drillto(c_name)
}
function href_WSOEIFQECB(p_nRow) {
ChangeRow(p_nRow);
drillto('..')
}
function href_XNMUUXRPID() {
AddImage()
}
function href_TZLXKZTOZN() {
AddImage()
}
function href_SLGVVHMSGD(p_nRow) {
ChangeRow(p_nRow);
SelectImage(c_url,w_imgnew,w_retTo)
}
function XUKRDCQOWH_Valid(e) {
SetActiveField(Ctrl('XUKRDCQOWH'),false);
e=(Ne(e,null)?e:window.event);
return Set_imageFilter(HtW(Ctrl('XUKRDCQOWH').value,'C'),null,e);
}
function XUKRDCQOWH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XUKRDCQOWH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XUKRDCQOWH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XUKRDCQOWH'),e);
}
function MDQXRYIUFH_Click() {
Aggiorna()
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('XUKRDCQOWH')) c.onblur=XUKRDCQOWH_Valid;
if(c=Ctrl('XUKRDCQOWH')) c.onfocus=XUKRDCQOWH_OnFocus;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
}
function SetLastFocusedOnParent() {
// used only in child entities
}
function DoUpdate(p_bResult) {
Calculate();
SaveDependsOn();
SetControlsValue();
SetDynamicClasses();
SetDynamicTooltip();
EnableControlsUnderCondition();
SaveLabelDependsOn();
if ( ! (p_bResult)) {
DisplayErrorMessage();
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.otherwise={"page_1":["XUKRDCQOWH"]};
function Help() {
windowOpenForeground('../doc/glcm_pimagepicker_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_Givevalueto=a[0];
w_Dirtoopen=a[1];
w_Orderwhat=a[2];
w_Orderdirection=a[3];
w_gPersonaID=a[4];
w_RootDir=a[5];
w_CanInsert=a[6];
w_imgnew=a[7];
w_imageFilter=a[8];
w_retTo=a[9];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('glcm_pimagepicker',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
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
alert(Translate(m_cObblFieldName)+' : '+Translate(l_cErrorMsg));
} else {
if (Eq(l_cErrorMsg,'MSG_VALUE_NOT_ALLOWED') && Ne(m_cLastWorkVarErrorMsg,'')) {
alert(Translate(m_cLastWorkVarErrorMsg)+': '+Translate(l_cErrorMsg));
} else {
alert(Translate(l_cErrorMsg));
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
var l_bEnabled = true;
// * --- Area Manuale = UI - Enable Controls Init
// * --- Fine Area Manuale
if (Ne(typeof(tabs),'undefined')) {
tabs.CheckTabStrip();
}
DisableUI();
HideControlsUnderCondition();
ObligatoryControlsUnderCondition();
// * --- Area Manuale = UI - Enable Controls End
// * --- Fine Area Manuale
}
function ObligatoryControlsUnderCondition() {
var l_bObligatory = true;
}
function SetDynamicClasses() {
var c;
}
function SetDynamicTooltip() {
var c;
}
function SetSectionsHeight(id,m_nCurrentRow) {
if (Eq(id,'DIV_03E147C8')) {
var delta0 = 0;
delta0=Max(GetStretchedHeight('NVGGLTXCDQ_'+m_nCurrentRow)-14,delta0);
if (Ne(delta0,0)) {
SetStretchedHeight('DIV_03E147C8'+m_nCurrentRow,31+delta0);
SetStretchedHeight('DIV_03E147C8_0_'+m_nCurrentRow,delta0+22);
}
var delta1 = 0;
delta1=Max(GetStretchedHeight('FGQCMAKHVP_'+m_nCurrentRow)-17-delta0,delta1);
if (Ne(delta1,0)) {
SetStretchedHeight('DIV_03E147C8'+m_nCurrentRow,31+delta0+delta1);
SetStretchedHeight('DIV_03E147C8_1_'+m_nCurrentRow,delta1+2);
}
SetStretchedHeight('OYFKYJABXC_'+m_nCurrentRow,30+delta0+delta1);
}
}
function AdjustOnResize() {
var i = 0;
while (Lt(i,m_nRows)) {
if (Ne(Ctrl('DIV_03E147C8'+i),null)) {
SetSectionsHeight('DIV_03E147C8',i);
}
i=i+1;
}
}
function InitVariables() {
}
function Set_imageFilter(ctrlValue,kmode,e) {
if (Ne(w_imageFilter,ctrlValue)) {
var ctl = _GetCtl(e,'XUKRDCQOWH');
if (_tracker.goon(ctl,ctrlValue)) {
w_imageFilter=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XUKRDCQOWH',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',100,0,'');
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
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function SendData(formaction,url,data) {
if (Eq(m_bAlreadySubmitted,true)) {
alert(Translate('MSG_SERVER_DATA'));
return;
}
var Frm = document.FSender;
var bResult = true;
if (Eq(formaction,'discard')) {
return;
}
if ((Ne(formaction,'next') && Ne(formaction,'previous') && Ne(formaction,'save')) || CheckRow()) {
SubmitForm(formaction,url,data);
} else {
DoUpdate(false);
}
}
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('XUKRDCQOWH',1))) {
_SignErr('XUKRDCQOWH');
m_cLastWorkVarErrorMsg='imageFilter';
l_bResult=false;
w_imageFilter=HtW('','C');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Givevalueto',WtA(w_Givevalueto,'C'));
l_oWv.setValue('Dirtoopen',WtA(w_Dirtoopen,'C'));
l_oWv.setValue('Orderwhat',WtA(w_Orderwhat,'C'));
l_oWv.setValue('Orderdirection',WtA(w_Orderdirection,'C'));
l_oWv.setValue('gPersonaID',WtA(w_gPersonaID,'C'));
l_oWv.setValue('RootDir',WtA(w_RootDir,'C'));
l_oWv.setValue('CanInsert',WtA(w_CanInsert,'C'));
l_oWv.setValue('imgnew',WtA(w_imgnew,'C'));
l_oWv.setValue('imageFilter',WtA(w_imageFilter,'C'));
l_oWv.setValue('retTo',WtA(w_retTo,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["Givevalueto","Dirtoopen","Orderwhat","Orderdirection","gPersonaID","RootDir","CanInsert","imgnew","imageFilter","retTo"];
function SetModified(bRepeated) {
m_bUpdated=true;
if (bRepeated) {
if (Le(m_nCurrentRow,m_oTrsFW.length)) {
m_nRowStatus=1;
}
}
}
function initNoLocalVars(start,pseq) {
if (IsWndAccessible(opener)) {
if (start) {
if (Empty(w_Givevalueto) && Ne(opener.w_Givevalueto,null)) {
TransferBetweenWindows(opener,'w_Givevalueto','w_Givevalueto');
}
if (Empty(w_Dirtoopen) && Ne(opener.w_Dirtoopen,null)) {
TransferBetweenWindows(opener,'w_Dirtoopen','w_Dirtoopen');
}
if (Empty(w_Orderwhat) && Ne(opener.w_Orderwhat,null)) {
TransferBetweenWindows(opener,'w_Orderwhat','w_Orderwhat');
}
if (Empty(w_Orderdirection) && Ne(opener.w_Orderdirection,null)) {
TransferBetweenWindows(opener,'w_Orderdirection','w_Orderdirection');
}
if (Empty(w_RootDir) && Ne(opener.w_RootDir,null)) {
TransferBetweenWindows(opener,'w_RootDir','w_RootDir');
}
if (Empty(w_CanInsert) && Ne(opener.w_CanInsert,null)) {
TransferBetweenWindows(opener,'w_CanInsert','w_CanInsert');
}
if (Empty(w_imgnew) && Ne(opener.w_imgnew,null)) {
TransferBetweenWindows(opener,'w_imgnew','w_imgnew');
}
if (Empty(w_imageFilter) && Ne(opener.w_imageFilter,null)) {
TransferBetweenWindows(opener,'w_imageFilter',null,'Set_imageFilter');
}
if (Empty(w_retTo) && Ne(opener.w_retTo,null)) {
TransferBetweenWindows(opener,'w_retTo','w_retTo');
}
}
}
m_bCalculating=true;
m_bCalculating=false;
SaveDependsOn();
SetControlsValue();
EnableControlsUnderCondition();
SaveLabelDependsOn();
DoUpdate(true);
var l_oCaller;
if (IsWndAccessible(l_oCaller)) {
var xAccessErr; try{l_oCaller.Ctrl;}catch(e){xAccessErr=1;} //IE security access error
if ( ! (xAccessErr) && Ne(typeof(l_oCaller.Ctrl),'undefined') && Ne(l_oCaller.Ctrl('FSender'),null) && Ne(typeof(l_oCaller.Ctrl('FSender').m_cOldCPCCCHK),'undefined')) {
m_cCPCCCHK=l_oCaller.Ctrl('FSender').m_cOldCPCCCHK.value;
}
}
}
function CheckRow() {
var l_bResult = true;
ResetErrorVars();
if (Lt(m_nCurrentRow,m_nRows)) {
}
return l_bResult;
}
function TrsFWRow() {
  this.m_nRowStatus = arguments[0]
}
function TrsQueryRow() {
  this.c_url = arguments[0]
  this.c_date = arguments[1]
  this.c_isdir = arguments[2]
  this.c_size = arguments[3]
  this.c_name = arguments[4]
}
function TrsToWork() {
var row;
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
c_url=row.c_url;
c_date=row.c_date;
c_isdir=row.c_isdir;
c_size=row.c_size;
c_name=row.c_name;
}
}
function WorkToTrs() {
var row;
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
row.c_url=c_url;
row.c_date=c_date;
row.c_isdir=c_isdir;
row.c_size=c_size;
row.c_name=c_name;
}
}
function BlankQueryFields() {
c_url='';
c_date=NullDateTime();
c_isdir=false;
c_size=0;
c_name='';
}
function FillHTMLRow() {
var l_nIdx = 0;
var l_oQuery;
var l_nEvenOdd = 0;
var l_nPrev = 0;
var l_nNext = 0;
var l_bEof;
l_bEof=Eq(m_nRows,0);
var l_nDeep;
l_nDeep=-1;
var l_nStartRow = Val(document.FSender.StartRow.value);
var l_nPos = 0;
var l_LGAZTHBNEY = '';
var l_old_LGAZTHBNEY = l_LGAZTHBNEY;
Body_BeginHtml(4,'#E8E8E8',0,'A','');
BlankQueryFields();
while ( ! (l_bEof)) {
l_oQuery=m_oTrsQuery[l_nIdx];
l_nDeep=0;
if (Lt(l_nIdx,m_nRows)) {
m_nCurrentRow=l_nIdx;
TrsToWork();
l_LGAZTHBNEY='';
if (Eq(l_nIdx,0)) {
l_nDeep=1;
} else {
if (Ne(l_old_LGAZTHBNEY,l_LGAZTHBNEY)) {
l_nDeep=2;
} else {
l_nDeep=3;
}
}
} else {
l_bEof=true;
l_nDeep=1;
}
l_nIdx=l_nIdx-1;
if (Ge(l_nIdx,0)) {
m_nCurrentRow=l_nIdx;
TrsToWork();
}
if (Ge(2,l_nDeep) && Ge(l_nIdx,0)) {
GroupFooter_BeginHtml(document,1,'37610074'+l_nIdx+'','A',false,false)
document.writeln(
 "<div id='DIV_03766528"+l_nIdx+"' style='position:relative;height:1px'>" +
"")
document.writeln(
 "<div style='overflow:hidden'>" +
 "</div>" +
"")
document.writeln(
 "</div>" +
"")
GroupFooter_EndHtml(document,1,'37610074'+l_nIdx+'','A')
} else {
}
l_nIdx=l_nIdx+1;
m_nCurrentRow=l_nIdx;
TrsToWork();
l_old_LGAZTHBNEY = l_LGAZTHBNEY;
if ( ! (l_bEof)) {
Parms.Idx=l_nIdx;
Parms.Deep=l_nDeep;
Parms.EvenOdd=l_nEvenOdd;
DrawLine(document);
l_nEvenOdd = l_nEvenOdd+1;
}
if ( ! (l_bEof)) {
l_nIdx=l_nIdx+1;
}
}
Body_Buttons(Gt(l_nStartRow,1),m_bOtherRow,'A');
Body_EndHtml('A');
}
function DrawLine(document) {
l_nIdx=Parms.Idx;
l_nDeep=Parms.Deep;
l_nEvenOdd=Parms.EvenOdd;
if (Ge(2,l_nDeep)) {
GroupHeader_BeginHtml(document,1,'37610586'+l_nIdx+'','A',false,false)
document.writeln(
 "<div id='DIV_03E0BBB8"+l_nIdx+"' style='position:relative;height:47px'>" +
"")
document.writeln(
 "<a href='javascript:href_WSOEIFQECB("+l_nIdx+")' id='WSOEIFQECB_"+l_nIdx+"_HREF'>" +
 "<img id='WSOEIFQECB_"+l_nIdx+"' class='WSOEIFQECB' style='"+( ! (Eq(w_Dirtoopen,''))?'':'display:none;visibility:hidden;')+"' src="+"'"+ToResource('images/portalstudio_up_dir.gif')+"'"+" title="+ToHTMLValue(Translate("11619920164"))+" alt="+ToHTMLValue(Translate("11619920164"),"C",0,0)+" onload=SetSectionsHeight('DIV_03E0BBB8',"+l_nIdx+")>" +
 "</a>" +
"")
document.writeln(
 "<img id='NWIOILYLVU_"+l_nIdx+"' class='NWIOILYLVU' style='"+( ! (Ne(w_Dirtoopen,''))?'':'display:none;visibility:hidden;')+"' src="+"'"+ToResource('images/portalstudio_dir.gif')+"'"+" alt='' onload=SetSectionsHeight('DIV_03E0BBB8',"+l_nIdx+")>" +
"")
document.writeln(
 "<span class=' SPLabel KPWHGLIYFW_DIV'>" +
 "<label class='KPWHGLIYFW' title="+ToHTMLValue(Translate("938888712"))+">" +
 ""+ToHTag(WtH(LRTrim('Directory: '+w_Dirtoopen+'/'),'C',70,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<div id='EAPMXMQFRH_"+l_nIdx+"_DIV' class=EAPMXMQFRH_DIV class='UntitledBox'>" +
 "<div id='EAPMXMQFRH_"+l_nIdx+"' class='EAPMXMQFRH BoxBody'>" +
 "</div>" +
 "</div>" +
"")
document.writeln(
 "<a href='javascript:href_HWSPROBKQP("+l_nIdx+")' id='HWSPROBKQP_"+l_nIdx+"_HREF'>" +
 "<img id='HWSPROBKQP_"+l_nIdx+"' class='HWSPROBKQP' style='"+( ! (Eq(w_Orderwhat,'name'))?'':'display:none;visibility:hidden;')+"' src="+"'"+ToResource('images/portalstudio_ord_no.gif')+"'"+" title="+ToHTMLValue(Translate("11832189196"))+" alt="+ToHTMLValue(Translate("11832189196"),"C",0,0)+" onload=SetSectionsHeight('DIV_03E0BBB8',"+l_nIdx+")>" +
 "</a>" +
"")
document.writeln(
 "<a href='javascript:href_DAXQIGIZPL("+l_nIdx+")' id='DAXQIGIZPL_"+l_nIdx+"_HREF'>" +
 "<img id='DAXQIGIZPL_"+l_nIdx+"' class='DAXQIGIZPL' style='"+( ! (Ne(w_Orderwhat,'name'))?'':'display:none;visibility:hidden;')+"' src="+"'"+ToResource('images/portalstudio_ord_'+w_Orderdirection+'.gif')+"'"+" title="+ToHTMLValue(Translate("876494694"))+" alt="+ToHTMLValue(Translate("876494694"),"C",0,0)+" onload=SetSectionsHeight('DIV_03E0BBB8',"+l_nIdx+")>" +
 "</a>" +
"")
document.writeln(
 "<a href='javascript:href_YFCGSXQUNZ("+l_nIdx+")' id='YFCGSXQUNZ_"+l_nIdx+"_HREF'>" +
 "<img id='YFCGSXQUNZ_"+l_nIdx+"' class='YFCGSXQUNZ' style='"+( ! (Eq(w_Orderwhat,'size'))?'':'display:none;visibility:hidden;')+"' src="+"'"+ToResource('images/portalstudio_ord_no.gif')+"'"+" title="+ToHTMLValue(Translate("1932572919"))+" alt="+ToHTMLValue(Translate("1932572919"),"C",0,0)+" onload=SetSectionsHeight('DIV_03E0BBB8',"+l_nIdx+")>" +
 "</a>" +
"")
document.writeln(
 "<a href='javascript:href_UWYFWAPCIQ("+l_nIdx+")' id='UWYFWAPCIQ_"+l_nIdx+"_HREF'>" +
 "<img id='UWYFWAPCIQ_"+l_nIdx+"' class='UWYFWAPCIQ' style='"+( ! (Ne(w_Orderwhat,'size'))?'':'display:none;visibility:hidden;')+"' src="+"'"+ToResource('images/portalstudio_ord_'+w_Orderdirection+'.gif')+"'"+" title="+ToHTMLValue(Translate("876494694"))+" alt="+ToHTMLValue(Translate("876494694"),"C",0,0)+" onload=SetSectionsHeight('DIV_03E0BBB8',"+l_nIdx+")>" +
 "</a>" +
"")
document.writeln(
 "<a href='javascript:href_GNGKNICNUH("+l_nIdx+")' id='GNGKNICNUH_"+l_nIdx+"_HREF'>" +
 "<img id='GNGKNICNUH_"+l_nIdx+"' class='GNGKNICNUH' style='"+( ! (Ne(w_Orderwhat,'date'))?'':'display:none;visibility:hidden;')+"' src="+"'"+ToResource('images/portalstudio_ord_'+w_Orderdirection+'.gif')+"'"+" title="+ToHTMLValue(Translate("876494694"))+" alt="+ToHTMLValue(Translate("876494694"),"C",0,0)+" onload=SetSectionsHeight('DIV_03E0BBB8',"+l_nIdx+")>" +
 "</a>" +
"")
document.writeln(
 "<a href='javascript:href_KMNBGIYIEW("+l_nIdx+")' id='KMNBGIYIEW_"+l_nIdx+"_HREF'>" +
 "<img id='KMNBGIYIEW_"+l_nIdx+"' class='KMNBGIYIEW' style='"+( ! (Eq(w_Orderwhat,'date'))?'':'display:none;visibility:hidden;')+"' src="+"'"+ToResource('images/portalstudio_ord_no.gif')+"'"+" title="+ToHTMLValue(Translate("11892916492"))+" alt="+ToHTMLValue(Translate("11892916492"),"C",0,0)+" onload=SetSectionsHeight('DIV_03E0BBB8',"+l_nIdx+")>" +
 "</a>" +
"")
document.writeln(
 "<span class=' SPLabel IIEFMVMMLY_DIV'>" +
 "<label class='IIEFMVMMLY'>" +
 ""+ToHTag(Translate("10990018535"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel YLMOWMIRPV_DIV'>" +
 "<label class='YLMOWMIRPV'>" +
 ""+ToHTag(Translate("1621412498"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel GLNUZFPQNI_DIV'>" +
 "<label class='GLNUZFPQNI'>" +
 ""+ToHTag(Translate("428628"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
GroupHeader_EndHtml(document,1,'37610586'+l_nIdx+'','A')
} else {
}
Row_BeginHtml(document,l_nEvenOdd,'34008666'+l_nIdx+'','A',false,-1)
document.writeln(
 "<div id='DIV_03E147C8"+l_nIdx+"' style='position:relative;height:31px'>" +
"")
document.writeln(
 "<div id='DIV_03E147C8_0_"+l_nIdx+"' style='position:relative;height:22px'>" +
"")
document.writeln(
 "<table>" +
"")
document.writeln(
 "</table>" +
"")
document.writeln(
 "<div id='OYFKYJABXC_"+l_nIdx+"_DIV' class=OYFKYJABXC_DIV style='"+( ! (c_isdir || Lt(c_size,0))?'':'display:none;visibility:hidden;')+"' class='UntitledBox'>" +
 "<div id='OYFKYJABXC_"+l_nIdx+"' class='OYFKYJABXC BoxBody'>" +
 "</div>" +
 "</div>" +
"")
document.writeln(
 "<a href='javascript:href_TIXKETQEMA("+l_nIdx+")' id='TIXKETQEMA_"+l_nIdx+"_HREF'>" +
 "<img id='TIXKETQEMA_"+l_nIdx+"' class='TIXKETQEMA' style='"+( ! (c_isdir || Lt(c_size,0))?'':'display:none;visibility:hidden;')+"' src="+"'"+ToResource(c_url)+"'"+" title="+ToHTMLValue(Translate("10547893613"))+" alt="+ToHTMLValue(Translate("10547893613"),"C",0,0)+" onload=SetSectionsHeight('DIV_03E147C8',"+l_nIdx+")>" +
 "</a>" +
"")
document.writeln(
 "<span class=' SPLabel GOGFBNOQMB_DIV' style='"+( ! (Ge(c_size,0))?'':'display:none;visibility:hidden;')+"'>" +
 "<label id='GOGFBNOQMB_"+l_nIdx+"' class='GOGFBNOQMB'>" +
 ""+ToHTag(Translate("603418349"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<a href='javascript:href_FGQCMAKHVP("+l_nIdx+")' id='FGQCMAKHVP_"+l_nIdx+"_HREF'>" +
 "<img id='FGQCMAKHVP_"+l_nIdx+"' class='FGQCMAKHVP' style='"+( ! ( ! (c_isdir) || Lt(c_size,0))?'':'display:none;visibility:hidden;')+"' src="+"'"+ToResource('images/portalstudio_dir.gif')+"'"+" title="+ToHTMLValue(Translate("11767257779"))+" alt="+ToHTMLValue(Translate("11767257779"),"C",0,0)+" onload=SetSectionsHeight('DIV_03E147C8',"+l_nIdx+")>" +
 "</a>" +
"")
document.writeln(
 "<span class=' SPLabel JTUXWIBDYN_DIV' style='"+( ! ( ! (c_isdir) || Lt(c_size,0))?'':'display:none;visibility:hidden;')+"'>" +
 "<label id='JTUXWIBDYN_"+l_nIdx+"' class='JTUXWIBDYN' title="+ToHTMLValue(Translate("11396688428"))+">" +
 "<a href='javascript:href_JTUXWIBDYN("+l_nIdx+")'>" +
 ""+ToHTag(WtH(c_name,'C',240,0,''))+"" +
 "</a>" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel SLGVVHMSGD_DIV' style='"+( ! (c_isdir || Ne(w_CanInsert,'S'))?'':'display:none;visibility:hidden;')+"'>" +
 "<label id='SLGVVHMSGD_"+l_nIdx+"' class='SLGVVHMSGD' title="+ToHTMLValue(Translate("11483928496"))+">" +
 "<a href='javascript:href_SLGVVHMSGD("+l_nIdx+")'>" +
 ""+ToHTag(WtH(c_name,'C',240,0,''))+"" +
 "</a>" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel OSFPDXIQEM_DIV' style='"+( ! (c_isdir || Eq(w_CanInsert,'S'))?'':'display:none;visibility:hidden;')+"'>" +
 "<label id='OSFPDXIQEM_"+l_nIdx+"' class='OSFPDXIQEM' title="+ToHTMLValue(Translate("1041960256"))+">" +
 "<a href='javascript:href_OSFPDXIQEM("+l_nIdx+")'>" +
 ""+ToHTag(WtH(c_name,'C',240,0,''))+"" +
 "</a>" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel LBEZQJWIFK_DIV' style='"+( ! (c_isdir || Lt(c_size,0))?'':'display:none;visibility:hidden;')+"'>" +
 "<label id='LBEZQJWIFK_"+l_nIdx+"' class='LBEZQJWIFK' title="+ToHTMLValue(Translate("10808384038"))+">" +
 ""+ToHTag(WtH(c_size,'N',10,0,'9,999,999,999'))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel NDGWFZHHLS_DIV' style='"+( ! (Lt(c_size,0))?'':'display:none;visibility:hidden;')+"'>" +
 "<label id='NDGWFZHHLS_"+l_nIdx+"' class='NDGWFZHHLS' title="+ToHTMLValue(Translate("11361286013"))+">" +
 ""+ToHTag(WtH(c_date,'T',14,0,'DD-MM-YYYY hh:mm:ss'))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<a href='javascript:href_NVGGLTXCDQ("+l_nIdx+")' id='NVGGLTXCDQ_"+l_nIdx+"_HREF'>" +
 "<img id='NVGGLTXCDQ_"+l_nIdx+"' class='NVGGLTXCDQ' style='"+( ! (c_isdir || Lt(c_size,0))?'':'display:none;visibility:hidden;')+"' src="+"'"+ToResource('portalstudio/images/icon/deleteicon.png')+"'"+" title="+ToHTMLValue(Translate("2077864999"))+" alt="+ToHTMLValue(Translate("2077864999"),"C",0,0)+" onload=SetSectionsHeight('DIV_03E147C8',"+l_nIdx+")>" +
 "</a>" +
"")
document.writeln(
 "</div>" +
"")
document.writeln(
 "<div id='DIV_03E147C8_1_"+l_nIdx+"' style='position:relative;height:2px'>" +
"")
document.writeln(
 "<table>" +
"")
document.writeln(
 "</table>" +
"")
document.writeln(
 "</div>" +
"")
document.writeln(
 "<div id='DIV_03E147C8_2_"+l_nIdx+"' style='position:relative;height:7px'>" +
"")
document.writeln(
 "<table>" +
"")
document.writeln(
 "</table>" +
"")
document.writeln(
 "</div>" +
"")
SetSectionsHeight('DIV_03E147C8',l_nIdx);
document.writeln(
 "</div>" +
"")
Row_EndHtml(document,l_nEvenOdd,'34008666'+l_nIdx+'','A')
Parms.Idx=l_nIdx;
Parms.Deep=l_nDeep;
Parms.EvenOdd=l_nEvenOdd;
}
Parms=new Object();
_Obli('imageFilter',0,'XUKRDCQOWH',false)
