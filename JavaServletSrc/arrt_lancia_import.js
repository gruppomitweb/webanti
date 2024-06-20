function arrt_lancia_import() {
var m_Caller
arrt_lancia_import._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_lancia_import._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_lancia_import._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_lancia_import._s.SetParameterString('m_bApplet','true');
arrt_lancia_import._s.CallServlet('arrt_lancia_import');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_lancia_import._s.errmsg;
}
}
arrt_lancia_import.CtxLoad_ = function(){return []}
