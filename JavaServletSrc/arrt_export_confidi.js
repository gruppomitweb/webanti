function arrt_export_confidi() {
var m_Caller
arrt_export_confidi._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_export_confidi._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_export_confidi._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_export_confidi._s.SetParameterString('m_bApplet','true');
arrt_export_confidi._s.CallServlet('arrt_export_confidi');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_export_confidi._s.errmsg;
}
}
arrt_export_confidi.CtxLoad_ = function(){return []}
