function spremovesecurity() {
var progname;
var m_Caller
spremovesecurity._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
progname='';
}
if(spremovesecurity._p.length>0)_rargs([[['progname',spremovesecurity._p[0]]]],{eval:function(e){eval(e)}})
spremovesecurity._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spremovesecurity._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spremovesecurity._s.SetParameterString('progname',WtA(progname,'C'));
spremovesecurity._s.SetParameterString('m_bApplet','true');
spremovesecurity._s.CallServlet('spremovesecurity');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spremovesecurity._s.errmsg;
}
return spremovesecurity._s.GetString();
}
spremovesecurity.CtxLoad_ = function(){return []}
