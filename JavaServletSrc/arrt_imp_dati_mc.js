function arrt_imp_dati_mc() {
var w_tipodest;
var w_impzip;
var w_annorif;
var w_chkaui;
var w_imperr;
var w_creamo;
var w_fscarti;
var w_flgaggfam;
var m_Caller
arrt_imp_dati_mc._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_tipodest=m_Caller.GetString('w_tipodest','C',0,0);
w_impzip=m_Caller.GetNumber('w_impzip','N',0,0);
w_annorif=m_Caller.GetNumber('w_annorif','N',0,0);
w_chkaui=m_Caller.GetString('w_chkaui','C',0,0);
w_imperr=m_Caller.GetString('w_imperr','C',0,0);
w_creamo=m_Caller.GetString('w_creamo','C',0,0);
w_fscarti=m_Caller.GetNumber('w_fscarti','N',0,0);
w_flgaggfam=m_Caller.GetString('w_flgaggfam','C',0,0);
arrt_imp_dati_mc._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_imp_dati_mc._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_imp_dati_mc._s.SetCallerStringVar('w_tipodest',WtA(w_tipodest,'C'));
arrt_imp_dati_mc._s.SetCallerStringVar('w_impzip',WtA(w_impzip,'N'));
arrt_imp_dati_mc._s.SetCallerStringVar('w_annorif',WtA(w_annorif,'N'));
arrt_imp_dati_mc._s.SetCallerStringVar('w_chkaui',WtA(w_chkaui,'C'));
arrt_imp_dati_mc._s.SetCallerStringVar('w_imperr',WtA(w_imperr,'C'));
arrt_imp_dati_mc._s.SetCallerStringVar('w_creamo',WtA(w_creamo,'C'));
arrt_imp_dati_mc._s.SetCallerStringVar('w_fscarti',WtA(w_fscarti,'N'));
arrt_imp_dati_mc._s.SetCallerStringVar('w_flgaggfam',WtA(w_flgaggfam,'C'));
arrt_imp_dati_mc._s.SetParameterString('m_bApplet','true');
arrt_imp_dati_mc._s.CallServlet('arrt_imp_dati_mc');
m_Caller.SetString('w_tipodest','C',0,0,arrt_imp_dati_mc._s.GetCallerStringVar('w_tipodest'));
m_Caller.SetNumber('w_impzip','N',0,0,arrt_imp_dati_mc._s.GetCallerDoubleVar('w_impzip'));
m_Caller.SetNumber('w_annorif','N',0,0,arrt_imp_dati_mc._s.GetCallerDoubleVar('w_annorif'));
m_Caller.SetString('w_chkaui','C',0,0,arrt_imp_dati_mc._s.GetCallerStringVar('w_chkaui'));
m_Caller.SetString('w_imperr','C',0,0,arrt_imp_dati_mc._s.GetCallerStringVar('w_imperr'));
m_Caller.SetString('w_creamo','C',0,0,arrt_imp_dati_mc._s.GetCallerStringVar('w_creamo'));
m_Caller.SetNumber('w_fscarti','N',0,0,arrt_imp_dati_mc._s.GetCallerDoubleVar('w_fscarti'));
m_Caller.SetString('w_flgaggfam','C',0,0,arrt_imp_dati_mc._s.GetCallerStringVar('w_flgaggfam'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_imp_dati_mc._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_imp_dati_mc.CtxLoad_ = function(){return []}
