function arrt_chk_opex() {
var w_canno;
var m_Caller
arrt_chk_opex._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_canno=m_Caller.GetString('w_canno','C',0,0);
arrt_chk_opex._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_chk_opex._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_chk_opex._s.SetCallerStringVar('w_canno',WtA(w_canno,'C'));
arrt_chk_opex._s.SetParameterString('m_bApplet','true');
arrt_chk_opex._s.CallServlet('arrt_chk_opex');
m_Caller.SetString('w_canno','C',0,0,arrt_chk_opex._s.GetCallerStringVar('w_canno'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_chk_opex._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_chk_opex.CtxLoad_ = function(){return []}
