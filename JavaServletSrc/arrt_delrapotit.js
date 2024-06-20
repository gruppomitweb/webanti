function arrt_delrapotit() {
var w_IDBASE;
var w_CONNESCLI;
var w_DATARETT;
var w_NUMPROG;
var m_Caller
arrt_delrapotit._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_IDBASE=m_Caller.GetString('w_IDBASE','C',0,0);
w_CONNESCLI=m_Caller.GetString('w_CONNESCLI','C',0,0);
w_DATARETT=m_Caller.GetDate('w_DATARETT','D',0,0);
w_NUMPROG=m_Caller.GetString('w_NUMPROG','C',0,0);
arrt_delrapotit._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_delrapotit._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_delrapotit._s.SetCallerStringVar('w_IDBASE',WtA(w_IDBASE,'C'));
arrt_delrapotit._s.SetCallerStringVar('w_CONNESCLI',WtA(w_CONNESCLI,'C'));
arrt_delrapotit._s.SetCallerStringVar('w_DATARETT',WtA(w_DATARETT,'D'));
arrt_delrapotit._s.SetCallerStringVar('w_NUMPROG',WtA(w_NUMPROG,'C'));
arrt_delrapotit._s.SetParameterString('m_bApplet','true');
arrt_delrapotit._s.CallServlet('arrt_delrapotit');
m_Caller.SetString('w_IDBASE','C',0,0,arrt_delrapotit._s.GetCallerStringVar('w_IDBASE'));
m_Caller.SetString('w_CONNESCLI','C',0,0,arrt_delrapotit._s.GetCallerStringVar('w_CONNESCLI'));
m_Caller.SetDate('w_DATARETT','D',0,0,DateFromApplet(arrt_delrapotit._s.GetCallerDateVar('w_DATARETT')));
m_Caller.SetString('w_NUMPROG','C',0,0,arrt_delrapotit._s.GetCallerStringVar('w_NUMPROG'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_delrapotit._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_delrapotit.CtxLoad_ = function(){return []}
