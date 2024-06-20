function arrt_pbprocessi() {
var m_Caller
arrt_pbprocessi._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_pbprocessi._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_pbprocessi._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_pbprocessi._s.SetParameterString('m_bApplet','true');
arrt_pbprocessi._s.CallServlet('arrt_pbprocessi');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_pbprocessi._s.errmsg;
}
}
arrt_pbprocessi.CtxLoad_ = function(){return []}
