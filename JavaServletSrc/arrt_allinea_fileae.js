function arrt_allinea_fileae() {
var w_impzip;
var w_dadata;
var w_a_data;
var m_Caller
arrt_allinea_fileae._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_impzip=m_Caller.GetNumber('w_impzip','N',0,0);
w_dadata=m_Caller.GetDate('w_dadata','D',0,0);
w_a_data=m_Caller.GetDate('w_a_data','D',0,0);
arrt_allinea_fileae._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_allinea_fileae._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_allinea_fileae._s.SetCallerStringVar('w_impzip',WtA(w_impzip,'N'));
arrt_allinea_fileae._s.SetCallerStringVar('w_dadata',WtA(w_dadata,'D'));
arrt_allinea_fileae._s.SetCallerStringVar('w_a_data',WtA(w_a_data,'D'));
arrt_allinea_fileae._s.SetParameterString('m_bApplet','true');
arrt_allinea_fileae._s.CallServlet('arrt_allinea_fileae');
m_Caller.SetNumber('w_impzip','N',0,0,arrt_allinea_fileae._s.GetCallerDoubleVar('w_impzip'));
m_Caller.SetDate('w_dadata','D',0,0,DateFromApplet(arrt_allinea_fileae._s.GetCallerDateVar('w_dadata')));
m_Caller.SetDate('w_a_data','D',0,0,DateFromApplet(arrt_allinea_fileae._s.GetCallerDateVar('w_a_data')));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_allinea_fileae._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_allinea_fileae.CtxLoad_ = function(){return []}
