function arrt_rapmod_at() {
var m_Caller
arrt_rapmod_at._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_rapmod_at._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_rapmod_at._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_rapmod_at._s.SetParameterString('m_bApplet','true');
arrt_rapmod_at._s.CallServlet('arrt_rapmod_at');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_rapmod_at._s.errmsg;
}
}
arrt_rapmod_at.CtxLoad_ = function(){return []}
