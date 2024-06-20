function allinea_telepass() {
var m_Caller
allinea_telepass._p=_rargs(arguments,{eval:function(e){eval(e)}})
allinea_telepass._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
allinea_telepass._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
allinea_telepass._s.SetParameterString('m_bApplet','true');
allinea_telepass._s.CallServlet('allinea_telepass');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=allinea_telepass._s.errmsg;
}
}
allinea_telepass.CtxLoad_ = function(){return []}
