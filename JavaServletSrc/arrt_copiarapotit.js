function arrt_copiarapotit() {
var a;
var m_Caller
arguments.callee._p=_rargs(arguments,{eval:function(e){eval(e)}})
a=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
a.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
a.SetCallerStringVar('w_IDBASE',WtA(w_IDBASE,'C'));
a.SetCallerStringVar('w_OPERAZMOD',WtA(w_OPERAZMOD,'C'));
a.SetCallerStringVar('w_DATARETT',WtA(w_DATARETT,'D'));
a.SetCallerStringVar('w_DATAOPE',WtA(w_DATAOPE,'D'));
a.SetCallerStringVar('w_NUMPROG',WtA(w_NUMPROG,'C'));
a.SetParameterString('m_bApplet','true');
a.CallServlet('arrt_copiarapotit');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=a.errmsg;
}
m_Caller.SetString('w_IDBASE','C',0,0,a.GetCallerStringVar('w_IDBASE'));
m_Caller.SetString('w_OPERAZMOD','C',0,0,a.GetCallerStringVar('w_OPERAZMOD'));
m_Caller.SetDate('w_DATARETT','D',0,0,DateFromApplet(a.GetCallerDateVar('w_DATARETT')));
m_Caller.SetDate('w_DATAOPE','D',0,0,DateFromApplet(a.GetCallerDateVar('w_DATAOPE')));
m_Caller.SetString('w_NUMPROG','C',0,0,a.GetCallerStringVar('w_NUMPROG'));
CalledBatchEnd();
}
