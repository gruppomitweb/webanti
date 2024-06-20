function arrt_sd_ricrea_ac() {
var w_a_data;
var w_dadata;
var w_files;
var m_Caller
arrt_sd_ricrea_ac._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_a_data=m_Caller.GetDate('w_a_data','D',0,0);
w_dadata=m_Caller.GetDate('w_dadata','D',0,0);
w_files=m_Caller.GetNumber('w_files','N',0,0);
arrt_sd_ricrea_ac._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_sd_ricrea_ac._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_sd_ricrea_ac._s.SetCallerStringVar('w_a_data',WtA(w_a_data,'D'));
arrt_sd_ricrea_ac._s.SetCallerStringVar('w_dadata',WtA(w_dadata,'D'));
arrt_sd_ricrea_ac._s.SetCallerStringVar('w_files',WtA(w_files,'N'));
arrt_sd_ricrea_ac._s.SetParameterString('m_bApplet','true');
arrt_sd_ricrea_ac._s.CallServlet('arrt_sd_ricrea_ac');
m_Caller.SetDate('w_a_data','D',0,0,DateFromApplet(arrt_sd_ricrea_ac._s.GetCallerDateVar('w_a_data')));
m_Caller.SetDate('w_dadata','D',0,0,DateFromApplet(arrt_sd_ricrea_ac._s.GetCallerDateVar('w_dadata')));
m_Caller.SetNumber('w_files','N',0,0,arrt_sd_ricrea_ac._s.GetCallerDoubleVar('w_files'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_sd_ricrea_ac._s.errmsg;
}
CalledBatchEnd();
}
arrt_sd_ricrea_ac.CtxLoad_ = function(){return []}
