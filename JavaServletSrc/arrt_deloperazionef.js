function arrt_deloperazionef() {
var w_IDBASE;
var w_NUMPROG;
var w_DATAOPE;
var w_DATARETT;
var w_CONNESCLI;
var w_MTCN;
var m_Caller
arrt_deloperazionef._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_IDBASE=m_Caller.GetString('w_IDBASE','C',0,0);
w_NUMPROG=m_Caller.GetString('w_NUMPROG','C',0,0);
w_DATAOPE=m_Caller.GetDate('w_DATAOPE','D',0,0);
w_DATARETT=m_Caller.GetDate('w_DATARETT','D',0,0);
w_CONNESCLI=m_Caller.GetString('w_CONNESCLI','C',0,0);
w_MTCN=m_Caller.GetString('w_MTCN','C',0,0);
arrt_deloperazionef._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_deloperazionef._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_deloperazionef._s.SetCallerStringVar('w_IDBASE',WtA(w_IDBASE,'C'));
arrt_deloperazionef._s.SetCallerStringVar('w_NUMPROG',WtA(w_NUMPROG,'C'));
arrt_deloperazionef._s.SetCallerStringVar('w_DATAOPE',WtA(w_DATAOPE,'D'));
arrt_deloperazionef._s.SetCallerStringVar('w_DATARETT',WtA(w_DATARETT,'D'));
arrt_deloperazionef._s.SetCallerStringVar('w_CONNESCLI',WtA(w_CONNESCLI,'C'));
arrt_deloperazionef._s.SetCallerStringVar('w_MTCN',WtA(w_MTCN,'C'));
arrt_deloperazionef._s.SetParameterString('m_bApplet','true');
arrt_deloperazionef._s.CallServlet('arrt_deloperazionef');
m_Caller.SetString('w_IDBASE','C',0,0,arrt_deloperazionef._s.GetCallerStringVar('w_IDBASE'));
m_Caller.SetString('w_NUMPROG','C',0,0,arrt_deloperazionef._s.GetCallerStringVar('w_NUMPROG'));
m_Caller.SetDate('w_DATAOPE','D',0,0,DateFromApplet(arrt_deloperazionef._s.GetCallerDateVar('w_DATAOPE')));
m_Caller.SetDate('w_DATARETT','D',0,0,DateFromApplet(arrt_deloperazionef._s.GetCallerDateVar('w_DATARETT')));
m_Caller.SetString('w_CONNESCLI','C',0,0,arrt_deloperazionef._s.GetCallerStringVar('w_CONNESCLI'));
m_Caller.SetString('w_MTCN','C',0,0,arrt_deloperazionef._s.GetCallerStringVar('w_MTCN'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_deloperazionef._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_deloperazionef.CtxLoad_ = function(){return []}
