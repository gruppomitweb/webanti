function arrt_warining_import() {
var m_Caller
arrt_warining_import._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_warining_import._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_warining_import._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_warining_import._s.SetParameterString('m_bApplet','true');
arrt_warining_import._s.CallServlet('arrt_warining_import');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_warining_import._s.errmsg;
}
}
arrt_warining_import.CtxLoad_ = function(){return []}
