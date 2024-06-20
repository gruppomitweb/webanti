function arfn_list_sid_logs() {
var m_Caller
arfn_list_sid_logs._p=_rargs(arguments,{eval:function(e){eval(e)}})
arfn_list_sid_logs._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_list_sid_logs._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_list_sid_logs._s.SetParameterString('m_bApplet','true');
arfn_list_sid_logs._s.CallServlet('arfn_list_sid_logs');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_list_sid_logs._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arfn_list_sid_logs._s.errmsg;
arfn_list_sid_logs._res=new CPMemoryCursor();
} else {
arfn_list_sid_logs._res=arfn_list_sid_logs._s.GetMemoryCursor();
}
return arfn_list_sid_logs._res;
}
arfn_list_sid_logs.CtxLoad_ = function(){return []}
