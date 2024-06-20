function imp_newtabs_mt() {
var m_Caller
imp_newtabs_mt._p=_rargs(arguments,{eval:function(e){eval(e)}})
imp_newtabs_mt._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
imp_newtabs_mt._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
imp_newtabs_mt._s.SetParameterString('m_bApplet','true');
imp_newtabs_mt._s.CallServlet('imp_newtabs_mt');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=imp_newtabs_mt._s.errmsg;
}
}
imp_newtabs_mt.CtxLoad_ = function(){return []}
