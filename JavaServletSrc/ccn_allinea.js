function ccn_allinea() {
var m_Caller
ccn_allinea._p=_rargs(arguments,{eval:function(e){eval(e)}})
ccn_allinea._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
ccn_allinea._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
ccn_allinea._s.SetParameterString('m_bApplet','true');
ccn_allinea._s.CallServlet('ccn_allinea');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=ccn_allinea._s.errmsg;
}
}
ccn_allinea.CtxLoad_ = function(){return []}
