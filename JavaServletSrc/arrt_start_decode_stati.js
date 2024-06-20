function arrt_start_decode_stati() {
var m_Caller
arrt_start_decode_stati._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_start_decode_stati._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_start_decode_stati._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_start_decode_stati._s.SetParameterString('m_bApplet','true');
arrt_start_decode_stati._s.CallServlet('arrt_start_decode_stati');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_start_decode_stati._s.errmsg;
}
}
arrt_start_decode_stati.CtxLoad_ = function(){return []}
