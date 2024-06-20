function allinea_iremit() {
var m_Caller
allinea_iremit._p=_rargs(arguments,{eval:function(e){eval(e)}})
allinea_iremit._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
allinea_iremit._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
allinea_iremit._s.SetParameterString('m_bApplet','true');
allinea_iremit._s.CallServlet('allinea_iremit');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=allinea_iremit._s.errmsg;
}
}
allinea_iremit.CtxLoad_ = function(){return []}
