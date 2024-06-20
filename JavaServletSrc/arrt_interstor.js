function arrt_interstor() {
var m_Caller
arrt_interstor._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_interstor._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_interstor._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_interstor._s.SetParameterString('m_bApplet','true');
arrt_interstor._s.CallServlet('arrt_interstor');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_interstor._s.errmsg;
}
}
arrt_interstor.CtxLoad_ = function(){return []}
