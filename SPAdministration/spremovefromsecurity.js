function spremovefromsecurity() {
var grpcode;
var usrcode;
var w_progname;
var m_Caller
spremovefromsecurity._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
grpcode=0;
usrcode=0;
}
if(spremovefromsecurity._p.length>0)_rargs([[['grpcode',spremovefromsecurity._p[0]],['usrcode',spremovefromsecurity._p[1]]]],{eval:function(e){eval(e)}})
w_progname=m_Caller.GetString('progname','C',0,0);
spremovefromsecurity._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spremovefromsecurity._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spremovefromsecurity._s.SetCallerStringVar('progname',WtA(w_progname,'C'));
spremovefromsecurity._s.SetParameterString('grpcode',WtA(grpcode,'N'));
spremovefromsecurity._s.SetParameterString('usrcode',WtA(usrcode,'N'));
spremovefromsecurity._s.SetParameterString('m_bApplet','true');
spremovefromsecurity._s.CallServlet('spremovefromsecurity');
m_Caller.SetString('w_progname','C',0,0,spremovefromsecurity._s.GetCallerStringVar('progname'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spremovefromsecurity._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
spremovefromsecurity.CtxLoad_ = function(){return []}
