function arrt_lancia_import_rtra() {
var m_Caller
arrt_lancia_import_rtra._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_lancia_import_rtra._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_lancia_import_rtra._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_lancia_import_rtra._s.SetParameterString('m_bApplet','true');
arrt_lancia_import_rtra._s.CallServlet('arrt_lancia_import_rtra');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_lancia_import_rtra._s.errmsg;
}
}
arrt_lancia_import_rtra.CtxLoad_ = function(){return []}
