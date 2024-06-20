function arrt_famextra_rstp() {
var w_stpinvio;
var w_xanno;
var w_xmese;
var m_Caller
arrt_famextra_rstp._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_stpinvio=m_Caller.GetString('w_stpinvio','C',0,0);
w_xanno=m_Caller.GetString('w_xanno','C',0,0);
w_xmese=m_Caller.GetString('w_xmese','C',0,0);
arrt_famextra_rstp._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_famextra_rstp._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_famextra_rstp._s.SetCallerStringVar('w_stpinvio',WtA(w_stpinvio,'C'));
arrt_famextra_rstp._s.SetCallerStringVar('w_xanno',WtA(w_xanno,'C'));
arrt_famextra_rstp._s.SetCallerStringVar('w_xmese',WtA(w_xmese,'C'));
arrt_famextra_rstp._s.SetParameterString('m_bApplet','true');
arrt_famextra_rstp._s.CallServlet('arrt_famextra_rstp');
m_Caller.SetString('w_stpinvio','C',0,0,arrt_famextra_rstp._s.GetCallerStringVar('w_stpinvio'));
m_Caller.SetString('w_xanno','C',0,0,arrt_famextra_rstp._s.GetCallerStringVar('w_xanno'));
m_Caller.SetString('w_xmese','C',0,0,arrt_famextra_rstp._s.GetCallerStringVar('w_xmese'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_famextra_rstp._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_famextra_rstp.CtxLoad_ = function(){return []}
