function allinea_arighe() {
var m_Caller
allinea_arighe._p=_rargs(arguments,{eval:function(e){eval(e)}})
allinea_arighe._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
allinea_arighe._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
allinea_arighe._s.SetParameterString('m_bApplet','true');
allinea_arighe._s.CallServlet('allinea_arighe');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=allinea_arighe._s.errmsg;
}
}
allinea_arighe.CtxLoad_ = function(){return []}
