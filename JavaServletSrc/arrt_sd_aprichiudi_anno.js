function arrt_sd_aprichiudi_anno() {
var m_Caller
arrt_sd_aprichiudi_anno._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_sd_aprichiudi_anno._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_sd_aprichiudi_anno._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_sd_aprichiudi_anno._s.SetParameterString('m_bApplet','true');
arrt_sd_aprichiudi_anno._s.CallServlet('arrt_sd_aprichiudi_anno');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_sd_aprichiudi_anno._s.errmsg;
}
}
arrt_sd_aprichiudi_anno.CtxLoad_ = function(){return []}
