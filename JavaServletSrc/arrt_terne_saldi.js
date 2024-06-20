function arrt_terne_saldi() {
var w_anno;
var w_a_data;
var w_stpoff;
var m_Caller
arrt_terne_saldi._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_anno=m_Caller.GetNumber('w_anno','N',0,0);
w_a_data=m_Caller.GetDate('w_a_data','D',0,0);
w_stpoff=m_Caller.GetString('w_stpoff','C',0,0);
arrt_terne_saldi._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_terne_saldi._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_terne_saldi._s.SetCallerStringVar('w_anno',WtA(w_anno,'N'));
arrt_terne_saldi._s.SetCallerStringVar('w_a_data',WtA(w_a_data,'D'));
arrt_terne_saldi._s.SetCallerStringVar('w_stpoff',WtA(w_stpoff,'C'));
arrt_terne_saldi._s.SetParameterString('m_bApplet','true');
arrt_terne_saldi._s.CallServlet('arrt_terne_saldi');
m_Caller.SetNumber('w_anno','N',0,0,arrt_terne_saldi._s.GetCallerDoubleVar('w_anno'));
m_Caller.SetDate('w_a_data','D',0,0,DateFromApplet(arrt_terne_saldi._s.GetCallerDateVar('w_a_data')));
m_Caller.SetString('w_stpoff','C',0,0,arrt_terne_saldi._s.GetCallerStringVar('w_stpoff'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_terne_saldi._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_terne_saldi.CtxLoad_ = function(){return []}
