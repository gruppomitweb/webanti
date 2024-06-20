function arrt_agg_famiglie() {
var w_CONNES;
var w_CFESTERO;
var w_flgaggfam;
var m_Caller
arrt_agg_famiglie._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_CONNES=m_Caller.GetString('w_CONNES','C',0,0);
w_CFESTERO=m_Caller.GetNumber('w_CFESTERO','N',0,0);
w_flgaggfam=m_Caller.GetString('w_flgaggfam','C',0,0);
arrt_agg_famiglie._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_agg_famiglie._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_agg_famiglie._s.SetCallerStringVar('w_CONNES',WtA(w_CONNES,'C'));
arrt_agg_famiglie._s.SetCallerStringVar('w_CFESTERO',WtA(w_CFESTERO,'N'));
arrt_agg_famiglie._s.SetCallerStringVar('w_flgaggfam',WtA(w_flgaggfam,'C'));
arrt_agg_famiglie._s.SetParameterString('m_bApplet','true');
arrt_agg_famiglie._s.CallServlet('arrt_agg_famiglie');
m_Caller.SetString('w_CONNES','C',0,0,arrt_agg_famiglie._s.GetCallerStringVar('w_CONNES'));
m_Caller.SetNumber('w_CFESTERO','N',0,0,arrt_agg_famiglie._s.GetCallerDoubleVar('w_CFESTERO'));
m_Caller.SetString('w_flgaggfam','C',0,0,arrt_agg_famiglie._s.GetCallerStringVar('w_flgaggfam'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_agg_famiglie._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_agg_famiglie.CtxLoad_ = function(){return []}
