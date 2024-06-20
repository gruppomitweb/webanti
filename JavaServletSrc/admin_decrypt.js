function admin_decrypt() {
var m_Caller
admin_decrypt._p=_rargs(arguments,{eval:function(e){eval(e)}})
admin_decrypt._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
admin_decrypt._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
admin_decrypt._s.SetParameterString('m_bApplet','true');
admin_decrypt._s.CallServlet('admin_decrypt');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=admin_decrypt._s.errmsg;
}
}
admin_decrypt.CtxLoad_ = function(){return []}
