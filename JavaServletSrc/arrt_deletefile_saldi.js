function arrt_deletefile_saldi() {
var w_nomefile;
var w_anno;
var w_idbase;
var m_Caller
arrt_deletefile_saldi._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_nomefile=m_Caller.GetString('w_nomefile','C',0,0);
w_anno=m_Caller.GetString('w_anno','C',0,0);
w_idbase=m_Caller.GetString('w_idbase','C',0,0);
arrt_deletefile_saldi._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_deletefile_saldi._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_deletefile_saldi._s.SetCallerStringVar('w_nomefile',WtA(w_nomefile,'C'));
arrt_deletefile_saldi._s.SetCallerStringVar('w_anno',WtA(w_anno,'C'));
arrt_deletefile_saldi._s.SetCallerStringVar('w_idbase',WtA(w_idbase,'C'));
arrt_deletefile_saldi._s.SetParameterString('m_bApplet','true');
arrt_deletefile_saldi._s.CallServlet('arrt_deletefile_saldi');
m_Caller.SetString('w_nomefile','C',0,0,arrt_deletefile_saldi._s.GetCallerStringVar('w_nomefile'));
m_Caller.SetString('w_anno','C',0,0,arrt_deletefile_saldi._s.GetCallerStringVar('w_anno'));
m_Caller.SetString('w_idbase','C',0,0,arrt_deletefile_saldi._s.GetCallerStringVar('w_idbase'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_deletefile_saldi._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_deletefile_saldi.CtxLoad_ = function(){return []}
