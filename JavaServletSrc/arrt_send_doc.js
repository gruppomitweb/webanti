function arrt_send_doc() {
var m_Caller
arrt_send_doc._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_send_doc._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_send_doc._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_send_doc._s.SetParameterString('m_bApplet','true');
arrt_send_doc._s.CallServlet('arrt_send_doc');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_send_doc._s.errmsg;
}
}
arrt_send_doc.CtxLoad_ = function(){return []}
