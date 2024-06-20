function aggiorna_titolari() {
var m_Caller
aggiorna_titolari._p=_rargs(arguments,{eval:function(e){eval(e)}})
aggiorna_titolari._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
aggiorna_titolari._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
aggiorna_titolari._s.SetParameterString('m_bApplet','true');
aggiorna_titolari._s.CallServlet('aggiorna_titolari');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=aggiorna_titolari._s.errmsg;
}
}
aggiorna_titolari.CtxLoad_ = function(){return []}
