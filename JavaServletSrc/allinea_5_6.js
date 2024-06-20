function allinea_5_6() {
var m_Caller
allinea_5_6._p=_rargs(arguments,{eval:function(e){eval(e)}})
allinea_5_6._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
allinea_5_6._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
allinea_5_6._s.SetParameterString('m_bApplet','true');
allinea_5_6._s.CallServlet('allinea_5_6');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=allinea_5_6._s.errmsg;
}
}
allinea_5_6.CtxLoad_ = function(){return []}
