function arrt_aggstatoreg() {
var pFile;
var pOper;
var w_IDBASE;
var w_STATOREG;
var w_NUMPROG;
var w_DATAOPE;
var w_DATAREG;
var w_DATARETT;
var m_Caller
arrt_aggstatoreg._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pFile='';
pOper='';
}
if(arrt_aggstatoreg._p.length>0)_rargs([[['pFile',arrt_aggstatoreg._p[0]],['pOper',arrt_aggstatoreg._p[1]]]],{eval:function(e){eval(e)}})
w_IDBASE=m_Caller.GetString('w_IDBASE','C',0,0);
w_STATOREG=m_Caller.GetString('w_STATOREG','C',0,0);
w_NUMPROG=m_Caller.GetString('w_NUMPROG','C',0,0);
w_DATAOPE=m_Caller.GetDate('w_DATAOPE','D',0,0);
w_DATAREG=m_Caller.GetDate('w_DATAREG','D',0,0);
w_DATARETT=m_Caller.GetDate('w_DATARETT','D',0,0);
arrt_aggstatoreg._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_aggstatoreg._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_aggstatoreg._s.SetCallerStringVar('w_IDBASE',WtA(w_IDBASE,'C'));
arrt_aggstatoreg._s.SetCallerStringVar('w_STATOREG',WtA(w_STATOREG,'C'));
arrt_aggstatoreg._s.SetCallerStringVar('w_NUMPROG',WtA(w_NUMPROG,'C'));
arrt_aggstatoreg._s.SetCallerStringVar('w_DATAOPE',WtA(w_DATAOPE,'D'));
arrt_aggstatoreg._s.SetCallerStringVar('w_DATAREG',WtA(w_DATAREG,'D'));
arrt_aggstatoreg._s.SetCallerStringVar('w_DATARETT',WtA(w_DATARETT,'D'));
arrt_aggstatoreg._s.SetParameterString('pFile',WtA(pFile,'C'));
arrt_aggstatoreg._s.SetParameterString('pOper',WtA(pOper,'C'));
arrt_aggstatoreg._s.SetParameterString('m_bApplet','true');
arrt_aggstatoreg._s.CallServlet('arrt_aggstatoreg');
m_Caller.SetString('w_IDBASE','C',0,0,arrt_aggstatoreg._s.GetCallerStringVar('w_IDBASE'));
m_Caller.SetString('w_STATOREG','C',0,0,arrt_aggstatoreg._s.GetCallerStringVar('w_STATOREG'));
m_Caller.SetString('w_NUMPROG','C',0,0,arrt_aggstatoreg._s.GetCallerStringVar('w_NUMPROG'));
m_Caller.SetDate('w_DATAOPE','D',0,0,DateFromApplet(arrt_aggstatoreg._s.GetCallerDateVar('w_DATAOPE')));
m_Caller.SetDate('w_DATAREG','D',0,0,DateFromApplet(arrt_aggstatoreg._s.GetCallerDateVar('w_DATAREG')));
m_Caller.SetDate('w_DATARETT','D',0,0,DateFromApplet(arrt_aggstatoreg._s.GetCallerDateVar('w_DATARETT')));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_aggstatoreg._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_aggstatoreg.CtxLoad_ = function(){return []}
