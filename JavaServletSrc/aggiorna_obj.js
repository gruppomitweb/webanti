function aggiorna_obj() {
var m_Caller
aggiorna_obj._p=_rargs(arguments,{eval:function(e){eval(e)}})
aggiorna_obj._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
aggiorna_obj._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
aggiorna_obj._s.SetParameterString('m_bApplet','true');
aggiorna_obj._s.CallServlet('aggiorna_obj');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=aggiorna_obj._s.errmsg;
}
}
aggiorna_obj.CtxLoad_ = function(){return []}
