function arrt_crea_tmp_list_imprich() {
var m_Caller
arrt_crea_tmp_list_imprich._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_crea_tmp_list_imprich._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_crea_tmp_list_imprich._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_crea_tmp_list_imprich._s.SetParameterString('m_bApplet','true');
arrt_crea_tmp_list_imprich._s.CallServlet('arrt_crea_tmp_list_imprich');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_crea_tmp_list_imprich._s.errmsg;
}
return arrt_crea_tmp_list_imprich._s.GetString();
}
arrt_crea_tmp_list_imprich.CtxLoad_ = function(){return []}
