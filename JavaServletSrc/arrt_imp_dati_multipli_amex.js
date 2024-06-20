function arrt_imp_dati_multipli_amex() {
var w_tipodest;
var w_gMsgProc;
var w_impzip;
var m_Caller
arrt_imp_dati_multipli_amex._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_tipodest=m_Caller.GetString('w_tipodest','C',0,0);
w_gMsgProc=m_Caller.GetString('gMsgProc','M',0,0);
w_impzip=m_Caller.GetNumber('w_impzip','N',0,0);
arrt_imp_dati_multipli_amex._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_imp_dati_multipli_amex._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_imp_dati_multipli_amex._s.SetCallerStringVar('w_tipodest',WtA(w_tipodest,'C'));
arrt_imp_dati_multipli_amex._s.SetCallerStringVar('gMsgProc',WtA(w_gMsgProc,'M'));
arrt_imp_dati_multipli_amex._s.SetCallerStringVar('w_impzip',WtA(w_impzip,'N'));
arrt_imp_dati_multipli_amex._s.SetParameterString('m_bApplet','true');
arrt_imp_dati_multipli_amex._s.CallServlet('arrt_imp_dati_multipli_amex');
m_Caller.SetString('w_tipodest','C',0,0,arrt_imp_dati_multipli_amex._s.GetCallerStringVar('w_tipodest'));
m_Caller.SetString('w_gMsgProc','M',0,0,arrt_imp_dati_multipli_amex._s.GetCallerStringVar('gMsgProc'));
m_Caller.SetNumber('w_impzip','N',0,0,arrt_imp_dati_multipli_amex._s.GetCallerDoubleVar('w_impzip'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_imp_dati_multipli_amex._s.errmsg;
}
CalledBatchEnd();
}
arrt_imp_dati_multipli_amex.CtxLoad_ = function(){return []}
