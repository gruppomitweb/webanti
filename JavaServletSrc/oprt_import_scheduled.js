function oprt_import_scheduled() {
var m_Caller
oprt_import_scheduled._p=_rargs(arguments,{eval:function(e){eval(e)}})
oprt_import_scheduled._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
oprt_import_scheduled._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
oprt_import_scheduled._s.SetParameterString('m_bApplet','true');
oprt_import_scheduled._s.CallServlet('oprt_import_scheduled');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=oprt_import_scheduled._s.errmsg;
}
}
oprt_import_scheduled.CtxLoad_ = function(){return []}
