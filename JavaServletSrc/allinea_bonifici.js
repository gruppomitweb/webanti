function allinea_bonifici() {
var m_Caller
allinea_bonifici._p=_rargs(arguments,{eval:function(e){eval(e)}})
allinea_bonifici._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
allinea_bonifici._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
allinea_bonifici._s.SetParameterString('m_bApplet','true');
allinea_bonifici._s.CallServlet('allinea_bonifici');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=allinea_bonifici._s.errmsg;
}
}
allinea_bonifici.CtxLoad_ = function(){return []}
