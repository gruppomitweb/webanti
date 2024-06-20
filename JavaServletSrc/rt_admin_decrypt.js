function rt_admin_decrypt() {
var w_filename;
var m_Caller
rt_admin_decrypt._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_filename=m_Caller.GetString('w_filename','C',0,0);
rt_admin_decrypt._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
rt_admin_decrypt._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
rt_admin_decrypt._s.SetCallerStringVar('w_filename',WtA(w_filename,'C'));
rt_admin_decrypt._s.SetParameterString('m_bApplet','true');
rt_admin_decrypt._s.CallServlet('rt_admin_decrypt');
m_Caller.SetString('w_filename','C',0,0,rt_admin_decrypt._s.GetCallerStringVar('w_filename'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=rt_admin_decrypt._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
rt_admin_decrypt.CtxLoad_ = function(){return []}
