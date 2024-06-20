function arrt_azzera_invii_opex() {
var w_a_data;
var w_dadata;
var w_anno;
var w_mese;
var m_Caller
arrt_azzera_invii_opex._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_a_data=m_Caller.GetDate('w_a_data','D',0,0);
w_dadata=m_Caller.GetDate('w_dadata','D',0,0);
w_anno=m_Caller.GetNumber('w_anno','N',0,0);
w_mese=m_Caller.GetString('w_mese','C',0,0);
arrt_azzera_invii_opex._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_azzera_invii_opex._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_azzera_invii_opex._s.SetCallerStringVar('w_a_data',WtA(w_a_data,'D'));
arrt_azzera_invii_opex._s.SetCallerStringVar('w_dadata',WtA(w_dadata,'D'));
arrt_azzera_invii_opex._s.SetCallerStringVar('w_anno',WtA(w_anno,'N'));
arrt_azzera_invii_opex._s.SetCallerStringVar('w_mese',WtA(w_mese,'C'));
arrt_azzera_invii_opex._s.SetParameterString('m_bApplet','true');
arrt_azzera_invii_opex._s.CallServlet('arrt_azzera_invii_opex');
m_Caller.SetDate('w_a_data','D',0,0,DateFromApplet(arrt_azzera_invii_opex._s.GetCallerDateVar('w_a_data')));
m_Caller.SetDate('w_dadata','D',0,0,DateFromApplet(arrt_azzera_invii_opex._s.GetCallerDateVar('w_dadata')));
m_Caller.SetNumber('w_anno','N',0,0,arrt_azzera_invii_opex._s.GetCallerDoubleVar('w_anno'));
m_Caller.SetString('w_mese','C',0,0,arrt_azzera_invii_opex._s.GetCallerStringVar('w_mese'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_azzera_invii_opex._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_azzera_invii_opex.CtxLoad_ = function(){return []}
