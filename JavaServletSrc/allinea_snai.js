function allinea_snai() {
var m_Caller
allinea_snai._p=_rargs(arguments,{eval:function(e){eval(e)}})
allinea_snai._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
allinea_snai._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
allinea_snai._s.SetParameterString('m_bApplet','true');
allinea_snai._s.CallServlet('allinea_snai');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=allinea_snai._s.errmsg;
}
}
allinea_snai.CtxLoad_ = function(){return []}
