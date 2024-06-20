function arrt_copiaoperazione() {
var w_IDBASE;
var w_OPERAZMOD;
var w_DATARETT;
var w_DATAOPE;
var w_NUMPROG;
var w_FLAGRAP2;
var w_IDEREG;
var w_IDBASE2;
var w_STATOREG;
var m_Caller
arrt_copiaoperazione._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_IDBASE=m_Caller.GetString('w_IDBASE','C',0,0);
w_OPERAZMOD=m_Caller.GetString('w_OPERAZMOD','C',0,0);
w_DATARETT=m_Caller.GetDate('w_DATARETT','D',0,0);
w_DATAOPE=m_Caller.GetDate('w_DATAOPE','D',0,0);
w_NUMPROG=m_Caller.GetString('w_NUMPROG','C',0,0);
w_FLAGRAP2=m_Caller.GetString('w_FLAGRAP2','C',0,0);
w_IDEREG=m_Caller.GetString('w_IDEREG','C',0,0);
w_IDBASE2=m_Caller.GetString('w_IDBASE2','C',0,0);
w_STATOREG=m_Caller.GetString('w_STATOREG','C',0,0);
arrt_copiaoperazione._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_copiaoperazione._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_copiaoperazione._s.SetCallerStringVar('w_IDBASE',WtA(w_IDBASE,'C'));
arrt_copiaoperazione._s.SetCallerStringVar('w_OPERAZMOD',WtA(w_OPERAZMOD,'C'));
arrt_copiaoperazione._s.SetCallerStringVar('w_DATARETT',WtA(w_DATARETT,'D'));
arrt_copiaoperazione._s.SetCallerStringVar('w_DATAOPE',WtA(w_DATAOPE,'D'));
arrt_copiaoperazione._s.SetCallerStringVar('w_NUMPROG',WtA(w_NUMPROG,'C'));
arrt_copiaoperazione._s.SetCallerStringVar('w_FLAGRAP2',WtA(w_FLAGRAP2,'C'));
arrt_copiaoperazione._s.SetCallerStringVar('w_IDEREG',WtA(w_IDEREG,'C'));
arrt_copiaoperazione._s.SetCallerStringVar('w_IDBASE2',WtA(w_IDBASE2,'C'));
arrt_copiaoperazione._s.SetCallerStringVar('w_STATOREG',WtA(w_STATOREG,'C'));
arrt_copiaoperazione._s.SetParameterString('m_bApplet','true');
arrt_copiaoperazione._s.CallServlet('arrt_copiaoperazione');
m_Caller.SetString('w_IDBASE','C',0,0,arrt_copiaoperazione._s.GetCallerStringVar('w_IDBASE'));
m_Caller.SetString('w_OPERAZMOD','C',0,0,arrt_copiaoperazione._s.GetCallerStringVar('w_OPERAZMOD'));
m_Caller.SetDate('w_DATARETT','D',0,0,DateFromApplet(arrt_copiaoperazione._s.GetCallerDateVar('w_DATARETT')));
m_Caller.SetDate('w_DATAOPE','D',0,0,DateFromApplet(arrt_copiaoperazione._s.GetCallerDateVar('w_DATAOPE')));
m_Caller.SetString('w_NUMPROG','C',0,0,arrt_copiaoperazione._s.GetCallerStringVar('w_NUMPROG'));
m_Caller.SetString('w_FLAGRAP2','C',0,0,arrt_copiaoperazione._s.GetCallerStringVar('w_FLAGRAP2'));
m_Caller.SetString('w_IDEREG','C',0,0,arrt_copiaoperazione._s.GetCallerStringVar('w_IDEREG'));
m_Caller.SetString('w_IDBASE2','C',0,0,arrt_copiaoperazione._s.GetCallerStringVar('w_IDBASE2'));
m_Caller.SetString('w_STATOREG','C',0,0,arrt_copiaoperazione._s.GetCallerStringVar('w_STATOREG'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_copiaoperazione._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_copiaoperazione.CtxLoad_ = function(){return []}
