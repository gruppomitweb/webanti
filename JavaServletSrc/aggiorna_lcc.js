function aggiorna_lcc() {
var m_Caller
aggiorna_lcc._p=_rargs(arguments,{eval:function(e){eval(e)}})
aggiorna_lcc._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
aggiorna_lcc._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
aggiorna_lcc._s.SetParameterString('m_bApplet','true');
aggiorna_lcc._s.CallServlet('aggiorna_lcc');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=aggiorna_lcc._s.errmsg;
}
}
aggiorna_lcc.CtxLoad_ = function(){return []}
