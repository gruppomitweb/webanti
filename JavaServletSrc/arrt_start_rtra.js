function arrt_start_rtra() {
var m_Caller
arrt_start_rtra._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_start_rtra._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_start_rtra._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_start_rtra._s.SetParameterString('m_bApplet','true');
arrt_start_rtra._s.CallServlet('arrt_start_rtra');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_start_rtra._s.errmsg;
}
}
arrt_start_rtra.CtxLoad_ = function(){return []}
