function arrt_lancia_import_rtra_errori() {
var m_Caller
arrt_lancia_import_rtra_errori._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_lancia_import_rtra_errori._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_lancia_import_rtra_errori._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_lancia_import_rtra_errori._s.SetParameterString('m_bApplet','true');
arrt_lancia_import_rtra_errori._s.CallServlet('arrt_lancia_import_rtra_errori');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_lancia_import_rtra_errori._s.errmsg;
}
}
arrt_lancia_import_rtra_errori.CtxLoad_ = function(){return []}
