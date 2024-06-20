function opert_contante_distinct_merge() {
var m_Caller
opert_contante_distinct_merge._p=_rargs(arguments,{eval:function(e){eval(e)}})
opert_contante_distinct_merge._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
opert_contante_distinct_merge._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
opert_contante_distinct_merge._s.SetParameterString('m_bApplet','true');
opert_contante_distinct_merge._s.CallServlet('opert_contante_distinct_merge');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=opert_contante_distinct_merge._s.errmsg;
}
}
opert_contante_distinct_merge.CtxLoad_ = function(){return []}
