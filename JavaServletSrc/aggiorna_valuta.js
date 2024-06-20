function aggiorna_valuta() {
var m_Caller
aggiorna_valuta._p=_rargs(arguments,{eval:function(e){eval(e)}})
aggiorna_valuta._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
aggiorna_valuta._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
aggiorna_valuta._s.SetParameterString('m_bApplet','true');
aggiorna_valuta._s.CallServlet('aggiorna_valuta');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=aggiorna_valuta._s.errmsg;
}
}
aggiorna_valuta.CtxLoad_ = function(){return []}
