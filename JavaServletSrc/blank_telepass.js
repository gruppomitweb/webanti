function blank_telepass() {
var m_Caller
blank_telepass._p=_rargs(arguments,{eval:function(e){eval(e)}})
blank_telepass._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
blank_telepass._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
blank_telepass._s.SetParameterString('m_bApplet','true');
blank_telepass._s.CallServlet('blank_telepass');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=blank_telepass._s.errmsg;
}
}
blank_telepass.CtxLoad_ = function(){return []}
