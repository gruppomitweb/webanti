function arrt_creadir_inter() {
var m_Caller
arrt_creadir_inter._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_creadir_inter._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_creadir_inter._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_creadir_inter._s.SetParameterString('m_bApplet','true');
arrt_creadir_inter._s.CallServlet('arrt_creadir_inter');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_creadir_inter._s.errmsg;
}
}
arrt_creadir_inter.CtxLoad_ = function(){return []}
