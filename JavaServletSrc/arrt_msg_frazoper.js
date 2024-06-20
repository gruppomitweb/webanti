function arrt_msg_frazoper() {
var w_cMsg;
var m_Caller
arrt_msg_frazoper._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_cMsg=m_Caller.GetString('w_cMsg','C',0,0);
arrt_msg_frazoper._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_msg_frazoper._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_msg_frazoper._s.SetCallerStringVar('w_cMsg',WtA(w_cMsg,'C'));
arrt_msg_frazoper._s.SetParameterString('m_bApplet','true');
arrt_msg_frazoper._s.CallServlet('arrt_msg_frazoper');
m_Caller.SetString('w_cMsg','C',0,0,arrt_msg_frazoper._s.GetCallerStringVar('w_cMsg'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_msg_frazoper._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_msg_frazoper.CtxLoad_ = function(){return []}
