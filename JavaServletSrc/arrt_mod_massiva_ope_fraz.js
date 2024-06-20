function arrt_mod_massiva_ope_fraz() {
var m_Caller
arrt_mod_massiva_ope_fraz._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_mod_massiva_ope_fraz._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_mod_massiva_ope_fraz._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_mod_massiva_ope_fraz._s.SetParameterString('m_bApplet','true');
arrt_mod_massiva_ope_fraz._s.CallServlet('arrt_mod_massiva_ope_fraz');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_mod_massiva_ope_fraz._s.errmsg;
}
}
arrt_mod_massiva_ope_fraz.CtxLoad_ = function(){return []}
