function aggiorna_zenith() {
var m_Caller
aggiorna_zenith._p=_rargs(arguments,{eval:function(e){eval(e)}})
aggiorna_zenith._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
aggiorna_zenith._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
aggiorna_zenith._s.SetParameterString('m_bApplet','true');
aggiorna_zenith._s.CallServlet('aggiorna_zenith');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=aggiorna_zenith._s.errmsg;
}
}
aggiorna_zenith.CtxLoad_ = function(){return []}
