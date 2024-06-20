function arrt_crea_mc_unifactor() {
var m_Caller
arrt_crea_mc_unifactor._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_crea_mc_unifactor._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_crea_mc_unifactor._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_crea_mc_unifactor._s.SetParameterString('m_bApplet','true');
arrt_crea_mc_unifactor._s.CallServlet('arrt_crea_mc_unifactor');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_crea_mc_unifactor._s.errmsg;
}
return arrt_crea_mc_unifactor._s.GetString();
}
arrt_crea_mc_unifactor.CtxLoad_ = function(){return []}
