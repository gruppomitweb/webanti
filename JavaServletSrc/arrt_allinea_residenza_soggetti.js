function arrt_allinea_residenza_soggetti() {
var m_Caller
arrt_allinea_residenza_soggetti._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_allinea_residenza_soggetti._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_allinea_residenza_soggetti._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_allinea_residenza_soggetti._s.SetParameterString('m_bApplet','true');
arrt_allinea_residenza_soggetti._s.CallServlet('arrt_allinea_residenza_soggetti');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_allinea_residenza_soggetti._s.errmsg;
}
return arrt_allinea_residenza_soggetti._s.GetString();
}
arrt_allinea_residenza_soggetti.CtxLoad_ = function(){return []}
