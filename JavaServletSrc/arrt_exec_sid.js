function arrt_exec_sid() {
var w_fileprodotto;
var w_anno;
var w_flg555;
var w_numcicli;
var m_Caller
arrt_exec_sid._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_fileprodotto=m_Caller.GetString('w_fileprodotto','C',0,0);
w_anno=m_Caller.GetNumber('w_anno','N',0,0);
w_flg555=m_Caller.GetString('w_flg555','C',0,0);
w_numcicli=m_Caller.GetNumber('w_numcicli','N',0,0);
arrt_exec_sid._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_exec_sid._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_exec_sid._s.SetCallerStringVar('w_fileprodotto',WtA(w_fileprodotto,'C'));
arrt_exec_sid._s.SetCallerStringVar('w_anno',WtA(w_anno,'N'));
arrt_exec_sid._s.SetCallerStringVar('w_flg555',WtA(w_flg555,'C'));
arrt_exec_sid._s.SetCallerStringVar('w_numcicli',WtA(w_numcicli,'N'));
arrt_exec_sid._s.SetParameterString('m_bApplet','true');
arrt_exec_sid._s.CallServlet('arrt_exec_sid');
m_Caller.SetString('w_fileprodotto','C',0,0,arrt_exec_sid._s.GetCallerStringVar('w_fileprodotto'));
m_Caller.SetNumber('w_anno','N',0,0,arrt_exec_sid._s.GetCallerDoubleVar('w_anno'));
m_Caller.SetString('w_flg555','C',0,0,arrt_exec_sid._s.GetCallerStringVar('w_flg555'));
m_Caller.SetNumber('w_numcicli','N',0,0,arrt_exec_sid._s.GetCallerDoubleVar('w_numcicli'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_exec_sid._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_exec_sid.CtxLoad_ = function(){return []}
