function arrt_ripintestbo() {
var m_Caller
arrt_ripintestbo._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_ripintestbo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_ripintestbo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_ripintestbo._s.SetParameterString('m_bApplet','true');
arrt_ripintestbo._s.CallServlet('arrt_ripintestbo');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_ripintestbo._s.errmsg;
}
}
arrt_ripintestbo.CtxLoad_ = function(){return []}
