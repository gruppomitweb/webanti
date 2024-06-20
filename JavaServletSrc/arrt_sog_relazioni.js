function arrt_sog_relazioni() {
var w_CodCli;
var w_RAGSOC1;
var m_Caller
arrt_sog_relazioni._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_CodCli=m_Caller.GetString('w_CodCli','C',0,0);
w_RAGSOC1=m_Caller.GetString('w_RAGSOC1','C',0,0);
arrt_sog_relazioni._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_sog_relazioni._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_sog_relazioni._s.SetCallerStringVar('w_CodCli',WtA(w_CodCli,'C'));
arrt_sog_relazioni._s.SetCallerStringVar('w_RAGSOC1',WtA(w_RAGSOC1,'C'));
arrt_sog_relazioni._s.SetParameterString('m_bApplet','true');
arrt_sog_relazioni._s.CallServlet('arrt_sog_relazioni');
m_Caller.SetString('w_CodCli','C',0,0,arrt_sog_relazioni._s.GetCallerStringVar('w_CodCli'));
m_Caller.SetString('w_RAGSOC1','C',0,0,arrt_sog_relazioni._s.GetCallerStringVar('w_RAGSOC1'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_sog_relazioni._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_sog_relazioni.CtxLoad_ = function(){return []}
