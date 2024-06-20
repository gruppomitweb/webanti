function allinea_monty() {
var m_Caller
allinea_monty._p=_rargs(arguments,{eval:function(e){eval(e)}})
allinea_monty._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
allinea_monty._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
allinea_monty._s.SetParameterString('m_bApplet','true');
allinea_monty._s.CallServlet('allinea_monty');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=allinea_monty._s.errmsg;
}
}
allinea_monty.CtxLoad_ = function(){return []}
