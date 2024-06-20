function arrt_creadir() {
var m_Caller
arrt_creadir._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_creadir._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_creadir._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_creadir._s.SetParameterString('m_bApplet','true');
arrt_creadir._s.CallServlet('arrt_creadir');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_creadir._s.errmsg;
}
}
arrt_creadir.CtxLoad_ = function(){return []}
