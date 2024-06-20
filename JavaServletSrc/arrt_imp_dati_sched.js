function arrt_imp_dati_sched() {
var w_tipodest;
var w_gMsgProc;
var w_impzip;
var w_errchk;
var m_Caller
arrt_imp_dati_sched._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_tipodest=m_Caller.GetString('w_tipodest','C',0,0);
w_gMsgProc=m_Caller.GetString('gMsgProc','M',0,0);
w_impzip=m_Caller.GetNumber('w_impzip','N',0,0);
w_errchk=m_Caller.GetNumber('w_errchk','N',0,0);
arrt_imp_dati_sched._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_imp_dati_sched._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_imp_dati_sched._s.SetCallerStringVar('w_tipodest',WtA(w_tipodest,'C'));
arrt_imp_dati_sched._s.SetCallerStringVar('gMsgProc',WtA(w_gMsgProc,'M'));
arrt_imp_dati_sched._s.SetCallerStringVar('w_impzip',WtA(w_impzip,'N'));
arrt_imp_dati_sched._s.SetCallerStringVar('w_errchk',WtA(w_errchk,'N'));
arrt_imp_dati_sched._s.SetParameterString('m_bApplet','true');
arrt_imp_dati_sched._s.CallServlet('arrt_imp_dati_sched');
m_Caller.SetString('w_tipodest','C',0,0,arrt_imp_dati_sched._s.GetCallerStringVar('w_tipodest'));
m_Caller.SetString('w_gMsgProc','M',0,0,arrt_imp_dati_sched._s.GetCallerStringVar('gMsgProc'));
m_Caller.SetNumber('w_impzip','N',0,0,arrt_imp_dati_sched._s.GetCallerDoubleVar('w_impzip'));
m_Caller.SetNumber('w_errchk','N',0,0,arrt_imp_dati_sched._s.GetCallerDoubleVar('w_errchk'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_imp_dati_sched._s.errmsg;
}
CalledBatchEnd();
}
arrt_imp_dati_sched.CtxLoad_ = function(){return []}
