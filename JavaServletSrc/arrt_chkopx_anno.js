function arrt_chkopx_anno() {
var w_anno;
var w_a_data;
var w_dadata;
var m_Caller
arrt_chkopx_anno._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_anno=m_Caller.GetNumber('w_anno','N',0,0);
w_a_data=m_Caller.GetDate('w_a_data','D',0,0);
w_dadata=m_Caller.GetDate('w_dadata','D',0,0);
arrt_chkopx_anno._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_chkopx_anno._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_chkopx_anno._s.SetCallerStringVar('w_anno',WtA(w_anno,'N'));
arrt_chkopx_anno._s.SetCallerStringVar('w_a_data',WtA(w_a_data,'D'));
arrt_chkopx_anno._s.SetCallerStringVar('w_dadata',WtA(w_dadata,'D'));
arrt_chkopx_anno._s.SetParameterString('m_bApplet','true');
arrt_chkopx_anno._s.CallServlet('arrt_chkopx_anno');
m_Caller.SetNumber('w_anno','N',0,0,arrt_chkopx_anno._s.GetCallerDoubleVar('w_anno'));
m_Caller.SetDate('w_a_data','D',0,0,DateFromApplet(arrt_chkopx_anno._s.GetCallerDateVar('w_a_data')));
m_Caller.SetDate('w_dadata','D',0,0,DateFromApplet(arrt_chkopx_anno._s.GetCallerDateVar('w_dadata')));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_chkopx_anno._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_chkopx_anno.CtxLoad_ = function(){return []}