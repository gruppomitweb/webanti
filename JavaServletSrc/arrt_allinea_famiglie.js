function arrt_allinea_famiglie() {
var w_nomefile;
var m_Caller
arrt_allinea_famiglie._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_nomefile=m_Caller.GetString('w_nomefile','C',0,0);
arrt_allinea_famiglie._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_allinea_famiglie._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_allinea_famiglie._s.SetCallerStringVar('w_nomefile',WtA(w_nomefile,'C'));
arrt_allinea_famiglie._s.SetParameterString('m_bApplet','true');
arrt_allinea_famiglie._s.CallServlet('arrt_allinea_famiglie');
m_Caller.SetString('w_nomefile','C',0,0,arrt_allinea_famiglie._s.GetCallerStringVar('w_nomefile'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_allinea_famiglie._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_allinea_famiglie.CtxLoad_ = function(){return []}
