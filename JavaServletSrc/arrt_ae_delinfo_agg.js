function arrt_ae_delinfo_agg() {
var w_NUMPROG;
var w_TIPOOPRAP;
var w_RAPPORTO;
var m_Caller
arrt_ae_delinfo_agg._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_NUMPROG=m_Caller.GetString('w_NUMPROG','C',0,0);
w_TIPOOPRAP=m_Caller.GetString('w_TIPOOPRAP','C',0,0);
w_RAPPORTO=m_Caller.GetString('w_RAPPORTO','C',0,0);
arrt_ae_delinfo_agg._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_ae_delinfo_agg._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_ae_delinfo_agg._s.SetCallerStringVar('w_NUMPROG',WtA(w_NUMPROG,'C'));
arrt_ae_delinfo_agg._s.SetCallerStringVar('w_TIPOOPRAP',WtA(w_TIPOOPRAP,'C'));
arrt_ae_delinfo_agg._s.SetCallerStringVar('w_RAPPORTO',WtA(w_RAPPORTO,'C'));
arrt_ae_delinfo_agg._s.SetParameterString('m_bApplet','true');
arrt_ae_delinfo_agg._s.CallServlet('arrt_ae_delinfo_agg');
m_Caller.SetString('w_NUMPROG','C',0,0,arrt_ae_delinfo_agg._s.GetCallerStringVar('w_NUMPROG'));
m_Caller.SetString('w_TIPOOPRAP','C',0,0,arrt_ae_delinfo_agg._s.GetCallerStringVar('w_TIPOOPRAP'));
m_Caller.SetString('w_RAPPORTO','C',0,0,arrt_ae_delinfo_agg._s.GetCallerStringVar('w_RAPPORTO'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_ae_delinfo_agg._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_ae_delinfo_agg.CtxLoad_ = function(){return []}
