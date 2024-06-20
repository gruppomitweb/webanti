function arrt_stp_scheda_di_verifica() {
var w_CONNES;
var w_CONNESLEG;
var w_ana;
var w_mpa;
var w_neo;
var w_vcam;
var m_Caller
arrt_stp_scheda_di_verifica._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_CONNES=m_Caller.GetString('w_CONNES','C',0,0);
w_CONNESLEG=m_Caller.GetString('w_CONNESLEG','C',0,0);
w_ana=m_Caller.GetNumber('w_ana','N',0,0);
w_mpa=m_Caller.GetNumber('w_mpa','N',0,0);
w_neo=m_Caller.GetNumber('w_neo','N',0,0);
w_vcam=m_Caller.GetNumber('w_vcam','N',0,0);
arrt_stp_scheda_di_verifica._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_stp_scheda_di_verifica._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_stp_scheda_di_verifica._s.SetCallerStringVar('w_CONNES',WtA(w_CONNES,'C'));
arrt_stp_scheda_di_verifica._s.SetCallerStringVar('w_CONNESLEG',WtA(w_CONNESLEG,'C'));
arrt_stp_scheda_di_verifica._s.SetCallerStringVar('w_ana',WtA(w_ana,'N'));
arrt_stp_scheda_di_verifica._s.SetCallerStringVar('w_mpa',WtA(w_mpa,'N'));
arrt_stp_scheda_di_verifica._s.SetCallerStringVar('w_neo',WtA(w_neo,'N'));
arrt_stp_scheda_di_verifica._s.SetCallerStringVar('w_vcam',WtA(w_vcam,'N'));
arrt_stp_scheda_di_verifica._s.SetParameterString('m_bApplet','true');
arrt_stp_scheda_di_verifica._s.CallServlet('arrt_stp_scheda_di_verifica');
m_Caller.SetString('w_CONNES','C',0,0,arrt_stp_scheda_di_verifica._s.GetCallerStringVar('w_CONNES'));
m_Caller.SetString('w_CONNESLEG','C',0,0,arrt_stp_scheda_di_verifica._s.GetCallerStringVar('w_CONNESLEG'));
m_Caller.SetNumber('w_ana','N',0,0,arrt_stp_scheda_di_verifica._s.GetCallerDoubleVar('w_ana'));
m_Caller.SetNumber('w_mpa','N',0,0,arrt_stp_scheda_di_verifica._s.GetCallerDoubleVar('w_mpa'));
m_Caller.SetNumber('w_neo','N',0,0,arrt_stp_scheda_di_verifica._s.GetCallerDoubleVar('w_neo'));
m_Caller.SetNumber('w_vcam','N',0,0,arrt_stp_scheda_di_verifica._s.GetCallerDoubleVar('w_vcam'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_stp_scheda_di_verifica._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_stp_scheda_di_verifica.CtxLoad_ = function(){return []}
