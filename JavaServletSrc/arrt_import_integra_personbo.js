function arrt_import_integra_personbo() {
var w_impzip;
var m_Caller
arrt_import_integra_personbo._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_impzip=m_Caller.GetNumber('w_impzip','N',0,0);
arrt_import_integra_personbo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_import_integra_personbo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_import_integra_personbo._s.SetCallerStringVar('w_impzip',WtA(w_impzip,'N'));
arrt_import_integra_personbo._s.SetParameterString('m_bApplet','true');
arrt_import_integra_personbo._s.CallServlet('arrt_import_integra_personbo');
m_Caller.SetNumber('w_impzip','N',0,0,arrt_import_integra_personbo._s.GetCallerDoubleVar('w_impzip'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_import_integra_personbo._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_import_integra_personbo.CtxLoad_ = function(){return []}
