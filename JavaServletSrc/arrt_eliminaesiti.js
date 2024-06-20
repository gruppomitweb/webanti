function arrt_eliminaesiti() {
var w_scelta;
var w_msgproc;
var w_gMsgProc;
var m_Caller
arrt_eliminaesiti._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_scelta=m_Caller.GetNumber('w_scelta','N',0,0);
w_msgproc=m_Caller.GetString('w_msgproc','M',0,0);
w_gMsgProc=m_Caller.GetString('gMsgProc','M',0,0);
arrt_eliminaesiti._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_eliminaesiti._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_eliminaesiti._s.SetCallerStringVar('w_scelta',WtA(w_scelta,'N'));
arrt_eliminaesiti._s.SetCallerStringVar('w_msgproc',WtA(w_msgproc,'M'));
arrt_eliminaesiti._s.SetCallerStringVar('gMsgProc',WtA(w_gMsgProc,'M'));
arrt_eliminaesiti._s.SetParameterString('m_bApplet','true');
arrt_eliminaesiti._s.CallServlet('arrt_eliminaesiti');
m_Caller.SetNumber('w_scelta','N',0,0,arrt_eliminaesiti._s.GetCallerDoubleVar('w_scelta'));
m_Caller.SetString('w_msgproc','M',0,0,arrt_eliminaesiti._s.GetCallerStringVar('w_msgproc'));
m_Caller.SetString('w_gMsgProc','M',0,0,arrt_eliminaesiti._s.GetCallerStringVar('gMsgProc'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_eliminaesiti._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_eliminaesiti.CtxLoad_ = function(){return []}
