function spremovesecurityrow() {
var progname;
var grpcode;
var usrcode;
var m_Caller
spremovesecurityrow._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
progname='';
grpcode=0;
usrcode=0;
}
if(spremovesecurityrow._p.length>0)_rargs([[['progname',spremovesecurityrow._p[0]],['grpcode',spremovesecurityrow._p[1]],['usrcode',spremovesecurityrow._p[2]]]],{eval:function(e){eval(e)}})
spremovesecurityrow._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spremovesecurityrow._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spremovesecurityrow._s.SetParameterString('progname',WtA(progname,'C'));
spremovesecurityrow._s.SetParameterString('grpcode',WtA(grpcode,'N'));
spremovesecurityrow._s.SetParameterString('usrcode',WtA(usrcode,'N'));
spremovesecurityrow._s.SetParameterString('m_bApplet','true');
spremovesecurityrow._s.CallServlet('spremovesecurityrow');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spremovesecurityrow._s.errmsg;
}
return spremovesecurityrow._s.GetString();
}
spremovesecurityrow.CtxLoad_ = function(){return []}
