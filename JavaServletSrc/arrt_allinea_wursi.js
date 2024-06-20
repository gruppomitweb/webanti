function arrt_allinea_wursi() {
var m_Caller
arrt_allinea_wursi._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_allinea_wursi._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_allinea_wursi._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_allinea_wursi._s.SetParameterString('m_bApplet','true');
arrt_allinea_wursi._s.CallServlet('arrt_allinea_wursi');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_allinea_wursi._s.errmsg;
}
}
arrt_allinea_wursi.CtxLoad_ = function(){return []}
