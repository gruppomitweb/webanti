function arrt_crea_5455() {
var w_NUMPROG;
var w_CONNESCLI;
var w_CONNESOPER;
var m_Caller
arrt_crea_5455._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_NUMPROG=m_Caller.GetString('w_NUMPROG','C',0,0);
w_CONNESCLI=m_Caller.GetString('w_CONNESCLI','C',0,0);
w_CONNESOPER=m_Caller.GetString('w_CONNESOPER','C',0,0);
arrt_crea_5455._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_crea_5455._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_crea_5455._s.SetCallerStringVar('w_NUMPROG',WtA(w_NUMPROG,'C'));
arrt_crea_5455._s.SetCallerStringVar('w_CONNESCLI',WtA(w_CONNESCLI,'C'));
arrt_crea_5455._s.SetCallerStringVar('w_CONNESOPER',WtA(w_CONNESOPER,'C'));
arrt_crea_5455._s.SetParameterString('m_bApplet','true');
arrt_crea_5455._s.CallServlet('arrt_crea_5455');
m_Caller.SetString('w_NUMPROG','C',0,0,arrt_crea_5455._s.GetCallerStringVar('w_NUMPROG'));
m_Caller.SetString('w_CONNESCLI','C',0,0,arrt_crea_5455._s.GetCallerStringVar('w_CONNESCLI'));
m_Caller.SetString('w_CONNESOPER','C',0,0,arrt_crea_5455._s.GetCallerStringVar('w_CONNESOPER'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_crea_5455._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_crea_5455.CtxLoad_ = function(){return []}
