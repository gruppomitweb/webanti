function arrt_closerap_start() {
var m_Caller
arrt_closerap_start._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_closerap_start._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_closerap_start._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_closerap_start._s.SetParameterString('m_bApplet','true');
arrt_closerap_start._s.CallServlet('arrt_closerap_start');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_closerap_start._s.errmsg;
}
}
arrt_closerap_start.CtxLoad_ = function(){return []}
