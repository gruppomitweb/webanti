function arrt_fam_rstp_invio() {
var w_stpinvio;
var w_xdatinvio;
var w_xtipinvio;
var w_xtpcinvio;
var w_flgdett;
var m_Caller
arrt_fam_rstp_invio._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_stpinvio=m_Caller.GetString('w_stpinvio','C',0,0);
w_xdatinvio=m_Caller.GetDate('w_xdatinvio','D',0,0);
w_xtipinvio=m_Caller.GetString('w_xtipinvio','C',0,0);
w_xtpcinvio=m_Caller.GetString('w_xtpcinvio','C',0,0);
w_flgdett=m_Caller.GetString('w_flgdett','C',0,0);
arrt_fam_rstp_invio._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_fam_rstp_invio._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_fam_rstp_invio._s.SetCallerStringVar('w_stpinvio',WtA(w_stpinvio,'C'));
arrt_fam_rstp_invio._s.SetCallerStringVar('w_xdatinvio',WtA(w_xdatinvio,'D'));
arrt_fam_rstp_invio._s.SetCallerStringVar('w_xtipinvio',WtA(w_xtipinvio,'C'));
arrt_fam_rstp_invio._s.SetCallerStringVar('w_xtpcinvio',WtA(w_xtpcinvio,'C'));
arrt_fam_rstp_invio._s.SetCallerStringVar('w_flgdett',WtA(w_flgdett,'C'));
arrt_fam_rstp_invio._s.SetParameterString('m_bApplet','true');
arrt_fam_rstp_invio._s.CallServlet('arrt_fam_rstp_invio');
m_Caller.SetString('w_stpinvio','C',0,0,arrt_fam_rstp_invio._s.GetCallerStringVar('w_stpinvio'));
m_Caller.SetDate('w_xdatinvio','D',0,0,DateFromApplet(arrt_fam_rstp_invio._s.GetCallerDateVar('w_xdatinvio')));
m_Caller.SetString('w_xtipinvio','C',0,0,arrt_fam_rstp_invio._s.GetCallerStringVar('w_xtipinvio'));
m_Caller.SetString('w_xtpcinvio','C',0,0,arrt_fam_rstp_invio._s.GetCallerStringVar('w_xtpcinvio'));
m_Caller.SetString('w_flgdett','C',0,0,arrt_fam_rstp_invio._s.GetCallerStringVar('w_flgdett'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_fam_rstp_invio._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_fam_rstp_invio.CtxLoad_ = function(){return []}
