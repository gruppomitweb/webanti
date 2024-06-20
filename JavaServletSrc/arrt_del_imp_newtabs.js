function arrt_del_imp_newtabs() {
var m_Caller
arrt_del_imp_newtabs._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_del_imp_newtabs._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_del_imp_newtabs._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_del_imp_newtabs._s.SetParameterString('m_bApplet','true');
arrt_del_imp_newtabs._s.CallServlet('arrt_del_imp_newtabs');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_del_imp_newtabs._s.errmsg;
}
return arrt_del_imp_newtabs._s.GetString();
}
arrt_del_imp_newtabs.CtxLoad_ = function(){return []}
