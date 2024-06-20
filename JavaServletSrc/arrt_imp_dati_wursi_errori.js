function arrt_imp_dati_wursi_errori() {
var w_tipodest;
var w_impzip;
var w_destfin;
var m_Caller
arrt_imp_dati_wursi_errori._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_tipodest=m_Caller.GetString('w_tipodest','C',0,0);
w_impzip=m_Caller.GetNumber('w_impzip','N',0,0);
w_destfin=m_Caller.GetString('w_destfin','C',0,0);
arrt_imp_dati_wursi_errori._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_imp_dati_wursi_errori._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_imp_dati_wursi_errori._s.SetCallerStringVar('w_tipodest',WtA(w_tipodest,'C'));
arrt_imp_dati_wursi_errori._s.SetCallerStringVar('w_impzip',WtA(w_impzip,'N'));
arrt_imp_dati_wursi_errori._s.SetCallerStringVar('w_destfin',WtA(w_destfin,'C'));
arrt_imp_dati_wursi_errori._s.SetParameterString('m_bApplet','true');
arrt_imp_dati_wursi_errori._s.CallServlet('arrt_imp_dati_wursi_errori');
m_Caller.SetString('w_tipodest','C',0,0,arrt_imp_dati_wursi_errori._s.GetCallerStringVar('w_tipodest'));
m_Caller.SetNumber('w_impzip','N',0,0,arrt_imp_dati_wursi_errori._s.GetCallerDoubleVar('w_impzip'));
m_Caller.SetString('w_destfin','C',0,0,arrt_imp_dati_wursi_errori._s.GetCallerStringVar('w_destfin'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_imp_dati_wursi_errori._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_imp_dati_wursi_errori.CtxLoad_ = function(){return []}
