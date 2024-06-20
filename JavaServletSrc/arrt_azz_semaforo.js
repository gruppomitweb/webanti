function arrt_azz_semaforo() {
var m_Caller
arrt_azz_semaforo._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_azz_semaforo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_azz_semaforo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_azz_semaforo._s.SetParameterString('m_bApplet','true');
arrt_azz_semaforo._s.CallServlet('arrt_azz_semaforo');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_azz_semaforo._s.errmsg;
}
}
arrt_azz_semaforo.CtxLoad_ = function(){return []}
