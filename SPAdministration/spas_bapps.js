function spas_bapps() {
var m_Caller
spas_bapps._p=_rargs(arguments,{eval:function(e){eval(e)}})
spas_bapps._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spas_bapps._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spas_bapps._s.SetParameterString('m_bApplet','true');
spas_bapps._s.CallServlet('spas_bapps');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spas_bapps._s.errmsg;
}
}
spas_bapps.CtxLoad_ = function(){return []}
