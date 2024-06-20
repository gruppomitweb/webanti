function arrt_agg_setsint() {
var w_nTOT;
var w_nTOTm;
var w_nTOTe;
var m_Caller
arrt_agg_setsint._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_nTOT=m_Caller.GetNumber('w_nTOT','N',0,0);
w_nTOTm=m_Caller.GetNumber('w_nTOTm','N',0,0);
w_nTOTe=m_Caller.GetNumber('w_nTOTe','N',0,0);
arrt_agg_setsint._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_agg_setsint._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_agg_setsint._s.SetCallerStringVar('w_nTOT',WtA(w_nTOT,'N'));
arrt_agg_setsint._s.SetCallerStringVar('w_nTOTm',WtA(w_nTOTm,'N'));
arrt_agg_setsint._s.SetCallerStringVar('w_nTOTe',WtA(w_nTOTe,'N'));
arrt_agg_setsint._s.SetParameterString('m_bApplet','true');
arrt_agg_setsint._s.CallServlet('arrt_agg_setsint');
m_Caller.SetNumber('w_nTOT','N',0,0,arrt_agg_setsint._s.GetCallerDoubleVar('w_nTOT'));
m_Caller.SetNumber('w_nTOTm','N',0,0,arrt_agg_setsint._s.GetCallerDoubleVar('w_nTOTm'));
m_Caller.SetNumber('w_nTOTe','N',0,0,arrt_agg_setsint._s.GetCallerDoubleVar('w_nTOTe'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_agg_setsint._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_agg_setsint.CtxLoad_ = function(){return []}
