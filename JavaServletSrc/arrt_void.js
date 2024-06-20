function arrt_void() {
var m_Caller
arrt_void._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_void._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_void._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_void._s.SetParameterString('m_bApplet','true');
arrt_void._s.CallServlet('arrt_void');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_void._s.errmsg;
}
}
arrt_void.CtxLoad_ = function(){return []}
