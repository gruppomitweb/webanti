function allinea_moneytrans() {
var m_Caller
allinea_moneytrans._p=_rargs(arguments,{eval:function(e){eval(e)}})
allinea_moneytrans._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
allinea_moneytrans._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
allinea_moneytrans._s.SetParameterString('m_bApplet','true');
allinea_moneytrans._s.CallServlet('allinea_moneytrans');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=allinea_moneytrans._s.errmsg;
}
}
allinea_moneytrans.CtxLoad_ = function(){return []}
