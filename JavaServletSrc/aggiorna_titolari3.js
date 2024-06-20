function aggiorna_titolari3() {
var m_Caller
aggiorna_titolari3._p=_rargs(arguments,{eval:function(e){eval(e)}})
aggiorna_titolari3._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
aggiorna_titolari3._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
aggiorna_titolari3._s.SetParameterString('m_bApplet','true');
aggiorna_titolari3._s.CallServlet('aggiorna_titolari3');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=aggiorna_titolari3._s.errmsg;
}
}
aggiorna_titolari3.CtxLoad_ = function(){return []}
