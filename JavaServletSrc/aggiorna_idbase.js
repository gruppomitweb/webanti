function aggiorna_idbase() {
var m_Caller
aggiorna_idbase._p=_rargs(arguments,{eval:function(e){eval(e)}})
aggiorna_idbase._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
aggiorna_idbase._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
aggiorna_idbase._s.SetParameterString('m_bApplet','true');
aggiorna_idbase._s.CallServlet('aggiorna_idbase');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=aggiorna_idbase._s.errmsg;
}
}
aggiorna_idbase.CtxLoad_ = function(){return []}
