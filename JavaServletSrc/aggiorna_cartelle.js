function aggiorna_cartelle() {
var m_Caller
aggiorna_cartelle._p=_rargs(arguments,{eval:function(e){eval(e)}})
aggiorna_cartelle._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
aggiorna_cartelle._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
aggiorna_cartelle._s.SetParameterString('m_bApplet','true');
aggiorna_cartelle._s.CallServlet('aggiorna_cartelle');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=aggiorna_cartelle._s.errmsg;
}
}
aggiorna_cartelle.CtxLoad_ = function(){return []}
