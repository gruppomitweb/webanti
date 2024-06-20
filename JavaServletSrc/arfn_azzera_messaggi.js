function arfn_azzera_messaggi() {
var m_Caller
arfn_azzera_messaggi._p=_rargs(arguments,{eval:function(e){eval(e)}})
arfn_azzera_messaggi._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_azzera_messaggi._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_azzera_messaggi._s.SetParameterString('m_bApplet','true');
arfn_azzera_messaggi._s.CallServlet('arfn_azzera_messaggi');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_azzera_messaggi._s.errmsg;
}
return arfn_azzera_messaggi._s.GetString();
}
arfn_azzera_messaggi.CtxLoad_ = function(){return []}
