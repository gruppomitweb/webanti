function arrt_famgetdgn() {
var m_Caller
arrt_famgetdgn._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_famgetdgn._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_famgetdgn._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_famgetdgn._s.SetParameterString('m_bApplet','true');
arrt_famgetdgn._s.CallServlet('arrt_famgetdgn');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_famgetdgn._s.errmsg;
}
}
arrt_famgetdgn.CtxLoad_ = function(){return []}
