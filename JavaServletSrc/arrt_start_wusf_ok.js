function arrt_start_wusf_ok() {
var w_WUCODICE;
var w_WUFLGALL;
var m_Caller
arrt_start_wusf_ok._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_WUCODICE=m_Caller.GetNumber('w_WUCODICE','N',0,0);
w_WUFLGALL=m_Caller.GetString('w_WUFLGALL','C',0,0);
arrt_start_wusf_ok._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_start_wusf_ok._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_start_wusf_ok._s.SetCallerStringVar('w_WUCODICE',WtA(w_WUCODICE,'N'));
arrt_start_wusf_ok._s.SetCallerStringVar('w_WUFLGALL',WtA(w_WUFLGALL,'C'));
arrt_start_wusf_ok._s.SetParameterString('m_bApplet','true');
arrt_start_wusf_ok._s.CallServlet('arrt_start_wusf_ok');
m_Caller.SetNumber('w_WUCODICE','N',0,0,arrt_start_wusf_ok._s.GetCallerDoubleVar('w_WUCODICE'));
m_Caller.SetString('w_WUFLGALL','C',0,0,arrt_start_wusf_ok._s.GetCallerStringVar('w_WUFLGALL'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_start_wusf_ok._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_start_wusf_ok.CtxLoad_ = function(){return []}
