function arrt_stp_contfile_do() {
var w_nomefile;
var w_idfile;
var m_Caller
arrt_stp_contfile_do._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_nomefile=m_Caller.GetString('w_nomefile','C',0,0);
w_idfile=m_Caller.GetString('w_idfile','C',0,0);
arrt_stp_contfile_do._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_stp_contfile_do._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_stp_contfile_do._s.SetCallerStringVar('w_nomefile',WtA(w_nomefile,'C'));
arrt_stp_contfile_do._s.SetCallerStringVar('w_idfile',WtA(w_idfile,'C'));
arrt_stp_contfile_do._s.SetParameterString('m_bApplet','true');
arrt_stp_contfile_do._s.CallServlet('arrt_stp_contfile_do');
m_Caller.SetString('w_nomefile','C',0,0,arrt_stp_contfile_do._s.GetCallerStringVar('w_nomefile'));
m_Caller.SetString('w_idfile','C',0,0,arrt_stp_contfile_do._s.GetCallerStringVar('w_idfile'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_stp_contfile_do._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_stp_contfile_do.CtxLoad_ = function(){return []}
