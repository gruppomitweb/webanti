function arfn_msg_allinea() {
var m_Caller
arfn_msg_allinea._p=_rargs(arguments,{eval:function(e){eval(e)}})
arfn_msg_allinea._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_msg_allinea._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_msg_allinea._s.SetParameterString('m_bApplet','true');
arfn_msg_allinea._s.CallServlet('arfn_msg_allinea');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_msg_allinea._s.errmsg;
}
return arfn_msg_allinea._s.GetString();
}
arfn_msg_allinea.CtxLoad_ = function(){return []}
