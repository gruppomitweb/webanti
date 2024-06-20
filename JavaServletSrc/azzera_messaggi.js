function azzera_messaggi() {
var m_Caller
azzera_messaggi._p=_rargs(arguments,{eval:function(e){eval(e)}})
azzera_messaggi._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
azzera_messaggi._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
azzera_messaggi._s.SetParameterString('m_bApplet','true');
azzera_messaggi._s.CallServlet('azzera_messaggi');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=azzera_messaggi._s.errmsg;
}
}
azzera_messaggi.CtxLoad_ = function(){return []}
