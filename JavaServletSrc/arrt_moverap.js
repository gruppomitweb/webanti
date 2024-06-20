function arrt_moverap() {
var w_datchi;
var w_datreg;
var w_msgproc;
var m_Caller
arrt_moverap._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_datchi=m_Caller.GetDate('w_datchi','D',0,0);
w_datreg=m_Caller.GetDate('w_datreg','D',0,0);
w_msgproc=m_Caller.GetString('w_msgproc','M',0,0);
arrt_moverap._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_moverap._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_moverap._s.SetCallerStringVar('w_datchi',WtA(w_datchi,'D'));
arrt_moverap._s.SetCallerStringVar('w_datreg',WtA(w_datreg,'D'));
arrt_moverap._s.SetCallerStringVar('w_msgproc',WtA(w_msgproc,'M'));
arrt_moverap._s.SetParameterString('m_bApplet','true');
arrt_moverap._s.CallServlet('arrt_moverap');
m_Caller.SetDate('w_datchi','D',0,0,DateFromApplet(arrt_moverap._s.GetCallerDateVar('w_datchi')));
m_Caller.SetDate('w_datreg','D',0,0,DateFromApplet(arrt_moverap._s.GetCallerDateVar('w_datreg')));
m_Caller.SetString('w_msgproc','M',0,0,arrt_moverap._s.GetCallerStringVar('w_msgproc'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_moverap._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_moverap.CtxLoad_ = function(){return []}
