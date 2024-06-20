function arrt_imp_dati_multipli_old() {
var w_tipodest;
var w_msgproc;
var w_impzip;
var m_Caller
arrt_imp_dati_multipli_old._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_tipodest=m_Caller.GetString('w_tipodest','C',0,0);
w_msgproc=m_Caller.GetString('w_msgproc','M',0,0);
w_impzip=m_Caller.GetNumber('w_impzip','N',0,0);
arrt_imp_dati_multipli_old._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_imp_dati_multipli_old._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_imp_dati_multipli_old._s.SetCallerStringVar('w_tipodest',WtA(w_tipodest,'C'));
arrt_imp_dati_multipli_old._s.SetCallerStringVar('w_msgproc',WtA(w_msgproc,'M'));
arrt_imp_dati_multipli_old._s.SetCallerStringVar('w_impzip',WtA(w_impzip,'N'));
arrt_imp_dati_multipli_old._s.SetParameterString('m_bApplet','true');
arrt_imp_dati_multipli_old._s.CallServlet('arrt_imp_dati_multipli_old');
m_Caller.SetString('w_tipodest','C',0,0,arrt_imp_dati_multipli_old._s.GetCallerStringVar('w_tipodest'));
m_Caller.SetString('w_msgproc','M',0,0,arrt_imp_dati_multipli_old._s.GetCallerStringVar('w_msgproc'));
m_Caller.SetNumber('w_impzip','N',0,0,arrt_imp_dati_multipli_old._s.GetCallerDoubleVar('w_impzip'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_imp_dati_multipli_old._s.errmsg;
}
CalledBatchEnd();
}
arrt_imp_dati_multipli_old.CtxLoad_ = function(){return []}
