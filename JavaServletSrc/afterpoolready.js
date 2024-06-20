function afterpoolready() {
var m_Caller
afterpoolready._p=_rargs(arguments,{eval:function(e){eval(e)}})
afterpoolready._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
afterpoolready._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
afterpoolready._s.SetParameterString('m_bApplet','true');
afterpoolready._s.CallServlet('afterpoolready');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=afterpoolready._s.errmsg;
}
}
afterpoolready.CtxLoad_ = function(){return []}
