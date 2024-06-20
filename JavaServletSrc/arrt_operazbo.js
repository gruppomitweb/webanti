function arrt_operazbo() {
var w_IDBASE;
var w_CONNES;
var w_DATARETT;
var w_NUMPROG;
var w_FLAGFRAZ;
var w_tipooper;
var w_datavaria;
var m_Caller
arrt_operazbo._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_IDBASE=m_Caller.GetString('w_IDBASE','C',0,0);
w_CONNES=m_Caller.GetString('w_CONNES','C',0,0);
w_DATARETT=m_Caller.GetDate('w_DATARETT','D',0,0);
w_NUMPROG=m_Caller.GetString('w_NUMPROG','C',0,0);
w_FLAGFRAZ=m_Caller.GetString('w_FLAGFRAZ','C',0,0);
w_tipooper=m_Caller.GetString('w_tipooper','C',0,0);
w_datavaria=m_Caller.GetDate('w_datavaria','D',0,0);
arrt_operazbo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_operazbo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_operazbo._s.SetCallerStringVar('w_IDBASE',WtA(w_IDBASE,'C'));
arrt_operazbo._s.SetCallerStringVar('w_CONNES',WtA(w_CONNES,'C'));
arrt_operazbo._s.SetCallerStringVar('w_DATARETT',WtA(w_DATARETT,'D'));
arrt_operazbo._s.SetCallerStringVar('w_NUMPROG',WtA(w_NUMPROG,'C'));
arrt_operazbo._s.SetCallerStringVar('w_FLAGFRAZ',WtA(w_FLAGFRAZ,'C'));
arrt_operazbo._s.SetCallerStringVar('w_tipooper',WtA(w_tipooper,'C'));
arrt_operazbo._s.SetCallerStringVar('w_datavaria',WtA(w_datavaria,'D'));
arrt_operazbo._s.SetParameterString('m_bApplet','true');
arrt_operazbo._s.CallServlet('arrt_operazbo');
m_Caller.SetString('w_IDBASE','C',0,0,arrt_operazbo._s.GetCallerStringVar('w_IDBASE'));
m_Caller.SetString('w_CONNES','C',0,0,arrt_operazbo._s.GetCallerStringVar('w_CONNES'));
m_Caller.SetDate('w_DATARETT','D',0,0,DateFromApplet(arrt_operazbo._s.GetCallerDateVar('w_DATARETT')));
m_Caller.SetString('w_NUMPROG','C',0,0,arrt_operazbo._s.GetCallerStringVar('w_NUMPROG'));
m_Caller.SetString('w_FLAGFRAZ','C',0,0,arrt_operazbo._s.GetCallerStringVar('w_FLAGFRAZ'));
m_Caller.SetString('w_tipooper','C',0,0,arrt_operazbo._s.GetCallerStringVar('w_tipooper'));
m_Caller.SetDate('w_datavaria','D',0,0,DateFromApplet(arrt_operazbo._s.GetCallerDateVar('w_datavaria')));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_operazbo._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_operazbo.CtxLoad_ = function(){return []}
