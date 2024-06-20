function arrt_cancella_ae() {
var w_datchi;
var m_Caller
arrt_cancella_ae._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_datchi=m_Caller.GetDate('w_datchi','D',0,0);
arrt_cancella_ae._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cancella_ae._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cancella_ae._s.SetCallerStringVar('w_datchi',WtA(w_datchi,'D'));
arrt_cancella_ae._s.SetParameterString('m_bApplet','true');
arrt_cancella_ae._s.CallServlet('arrt_cancella_ae');
m_Caller.SetDate('w_datchi','D',0,0,DateFromApplet(arrt_cancella_ae._s.GetCallerDateVar('w_datchi')));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cancella_ae._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_cancella_ae.CtxLoad_ = function(){return []}
