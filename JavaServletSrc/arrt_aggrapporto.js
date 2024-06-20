function arrt_aggrapporto() {
var w_IDBASE;
var m_Caller
arrt_aggrapporto._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_IDBASE=m_Caller.GetString('w_IDBASE','C',0,0);
arrt_aggrapporto._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_aggrapporto._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_aggrapporto._s.SetCallerStringVar('w_IDBASE',WtA(w_IDBASE,'C'));
arrt_aggrapporto._s.SetParameterString('m_bApplet','true');
arrt_aggrapporto._s.CallServlet('arrt_aggrapporto');
m_Caller.SetString('w_IDBASE','C',0,0,arrt_aggrapporto._s.GetCallerStringVar('w_IDBASE'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_aggrapporto._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_aggrapporto.CtxLoad_ = function(){return []}
