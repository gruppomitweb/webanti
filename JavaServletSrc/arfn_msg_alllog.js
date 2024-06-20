function arfn_msg_alllog() {
var m_Caller
arfn_msg_alllog._p=_rargs(arguments,{eval:function(e){eval(e)}})
arfn_msg_alllog._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_msg_alllog._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_msg_alllog._s.SetParameterString('m_bApplet','true');
arfn_msg_alllog._s.CallServlet('arfn_msg_alllog');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_msg_alllog._s.errmsg;
}
return arfn_msg_alllog._s.GetString();
}
arfn_msg_alllog.CtxLoad_ = function(){return []}
