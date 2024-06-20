function arrt_creadir_start() {
var m_Caller
arrt_creadir_start._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_creadir_start._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_creadir_start._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_creadir_start._s.SetParameterString('m_bApplet','true');
arrt_creadir_start._s.CallServlet('arrt_creadir_start');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_creadir_start._s.errmsg;
}
}
arrt_creadir_start.CtxLoad_ = function(){return []}
