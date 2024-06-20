function arrt_famnoinvio() {
var w_flgexist;
var m_Caller
arrt_famnoinvio._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_flgexist=m_Caller.GetString('w_flgexist','C',0,0);
arrt_famnoinvio._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_famnoinvio._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_famnoinvio._s.SetCallerStringVar('w_flgexist',WtA(w_flgexist,'C'));
arrt_famnoinvio._s.SetParameterString('m_bApplet','true');
arrt_famnoinvio._s.CallServlet('arrt_famnoinvio');
m_Caller.SetString('w_flgexist','C',0,0,arrt_famnoinvio._s.GetCallerStringVar('w_flgexist'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_famnoinvio._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_famnoinvio.CtxLoad_ = function(){return []}
