function arrt_blocca_nopay() {
var m_Caller
arrt_blocca_nopay._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_blocca_nopay._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_blocca_nopay._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_blocca_nopay._s.SetParameterString('m_bApplet','true');
arrt_blocca_nopay._s.CallServlet('arrt_blocca_nopay');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_blocca_nopay._s.errmsg;
}
}
arrt_blocca_nopay.CtxLoad_ = function(){return []}
