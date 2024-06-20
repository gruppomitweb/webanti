function arrt_sd_ricrea() {
var w_nomefile;
var w_tipofile;
var w_files;
var m_Caller
arrt_sd_ricrea._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_nomefile=m_Caller.GetString('w_nomefile','C',0,0);
w_tipofile=m_Caller.GetString('w_tipofile','C',0,0);
w_files=m_Caller.GetNumber('w_files','N',0,0);
arrt_sd_ricrea._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_sd_ricrea._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_sd_ricrea._s.SetCallerStringVar('w_nomefile',WtA(w_nomefile,'C'));
arrt_sd_ricrea._s.SetCallerStringVar('w_tipofile',WtA(w_tipofile,'C'));
arrt_sd_ricrea._s.SetCallerStringVar('w_files',WtA(w_files,'N'));
arrt_sd_ricrea._s.SetParameterString('m_bApplet','true');
arrt_sd_ricrea._s.CallServlet('arrt_sd_ricrea');
m_Caller.SetString('w_nomefile','C',0,0,arrt_sd_ricrea._s.GetCallerStringVar('w_nomefile'));
m_Caller.SetString('w_tipofile','C',0,0,arrt_sd_ricrea._s.GetCallerStringVar('w_tipofile'));
m_Caller.SetNumber('w_files','N',0,0,arrt_sd_ricrea._s.GetCallerDoubleVar('w_files'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_sd_ricrea._s.errmsg;
}
CalledBatchEnd();
}
arrt_sd_ricrea.CtxLoad_ = function(){return []}
