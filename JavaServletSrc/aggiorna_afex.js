function aggiorna_afex() {
var m_Caller
aggiorna_afex._p=_rargs(arguments,{eval:function(e){eval(e)}})
aggiorna_afex._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
aggiorna_afex._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
aggiorna_afex._s.SetParameterString('m_bApplet','true');
aggiorna_afex._s.CallServlet('aggiorna_afex');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=aggiorna_afex._s.errmsg;
}
}
aggiorna_afex.CtxLoad_ = function(){return []}
