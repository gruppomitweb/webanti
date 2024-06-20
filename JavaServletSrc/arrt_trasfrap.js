function arrt_trasfrap() {
var m_Caller
arrt_trasfrap._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_trasfrap._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_trasfrap._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_trasfrap._s.SetParameterString('m_bApplet','true');
arrt_trasfrap._s.CallServlet('arrt_trasfrap');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_trasfrap._s.errmsg;
}
return arrt_trasfrap._s.GetString();
}
arrt_trasfrap.CtxLoad_ = function(){return []}
