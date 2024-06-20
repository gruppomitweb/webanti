function arrt_crecopia3() {
var pFile;
var w_IDBASE;
var w_NUMPROG;
var w_DATAOPE;
var w_valflg2;
var w_FLAGRAP2;
var m_Caller
arrt_crecopia3._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pFile='';
}
if(arrt_crecopia3._p.length>0)_rargs([[['pFile',arrt_crecopia3._p[0]]]],{eval:function(e){eval(e)}})
w_IDBASE=m_Caller.GetString('w_IDBASE','C',0,0);
w_NUMPROG=m_Caller.GetString('w_NUMPROG','C',0,0);
w_DATAOPE=m_Caller.GetDate('w_DATAOPE','D',0,0);
w_valflg2=m_Caller.GetString('w_valflg2','C',0,0);
w_FLAGRAP2=m_Caller.GetString('w_FLAGRAP2','C',0,0);
arrt_crecopia3._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_crecopia3._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_crecopia3._s.SetCallerStringVar('w_IDBASE',WtA(w_IDBASE,'C'));
arrt_crecopia3._s.SetCallerStringVar('w_NUMPROG',WtA(w_NUMPROG,'C'));
arrt_crecopia3._s.SetCallerStringVar('w_DATAOPE',WtA(w_DATAOPE,'D'));
arrt_crecopia3._s.SetCallerStringVar('w_valflg2',WtA(w_valflg2,'C'));
arrt_crecopia3._s.SetCallerStringVar('w_FLAGRAP2',WtA(w_FLAGRAP2,'C'));
arrt_crecopia3._s.SetParameterString('pFile',WtA(pFile,'C'));
arrt_crecopia3._s.SetParameterString('m_bApplet','true');
arrt_crecopia3._s.CallServlet('arrt_crecopia3');
m_Caller.SetString('w_IDBASE','C',0,0,arrt_crecopia3._s.GetCallerStringVar('w_IDBASE'));
m_Caller.SetString('w_NUMPROG','C',0,0,arrt_crecopia3._s.GetCallerStringVar('w_NUMPROG'));
m_Caller.SetDate('w_DATAOPE','D',0,0,DateFromApplet(arrt_crecopia3._s.GetCallerDateVar('w_DATAOPE')));
m_Caller.SetString('w_valflg2','C',0,0,arrt_crecopia3._s.GetCallerStringVar('w_valflg2'));
m_Caller.SetString('w_FLAGRAP2','C',0,0,arrt_crecopia3._s.GetCallerStringVar('w_FLAGRAP2'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_crecopia3._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_crecopia3.CtxLoad_ = function(){return []}
