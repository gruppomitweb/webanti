function arrt_trasftit_sel() {
var w_DaConnes;
var w_AConnes;
var w_xragsoc1;
var w_xragsoc2;
var m_Caller
arrt_trasftit_sel._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_DaConnes=m_Caller.GetString('w_DaConnes','C',0,0);
w_AConnes=m_Caller.GetString('w_AConnes','C',0,0);
w_xragsoc1=m_Caller.GetString('w_xragsoc1','C',0,0);
w_xragsoc2=m_Caller.GetString('w_xragsoc2','C',0,0);
arrt_trasftit_sel._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_trasftit_sel._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_trasftit_sel._s.SetCallerStringVar('w_DaConnes',WtA(w_DaConnes,'C'));
arrt_trasftit_sel._s.SetCallerStringVar('w_AConnes',WtA(w_AConnes,'C'));
arrt_trasftit_sel._s.SetCallerStringVar('w_xragsoc1',WtA(w_xragsoc1,'C'));
arrt_trasftit_sel._s.SetCallerStringVar('w_xragsoc2',WtA(w_xragsoc2,'C'));
arrt_trasftit_sel._s.SetParameterString('m_bApplet','true');
arrt_trasftit_sel._s.CallServlet('arrt_trasftit_sel');
m_Caller.SetString('w_DaConnes','C',0,0,arrt_trasftit_sel._s.GetCallerStringVar('w_DaConnes'));
m_Caller.SetString('w_AConnes','C',0,0,arrt_trasftit_sel._s.GetCallerStringVar('w_AConnes'));
m_Caller.SetString('w_xragsoc1','C',0,0,arrt_trasftit_sel._s.GetCallerStringVar('w_xragsoc1'));
m_Caller.SetString('w_xragsoc2','C',0,0,arrt_trasftit_sel._s.GetCallerStringVar('w_xragsoc2'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_trasftit_sel._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_trasftit_sel.CtxLoad_ = function(){return []}
