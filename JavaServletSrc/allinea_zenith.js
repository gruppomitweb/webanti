function allinea_zenith() {
var m_Caller
allinea_zenith._p=_rargs(arguments,{eval:function(e){eval(e)}})
allinea_zenith._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
allinea_zenith._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
allinea_zenith._s.SetParameterString('m_bApplet','true');
allinea_zenith._s.CallServlet('allinea_zenith');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=allinea_zenith._s.errmsg;
}
}
allinea_zenith.CtxLoad_ = function(){return []}
