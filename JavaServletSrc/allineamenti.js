function allineamenti() {
var m_Caller
allineamenti._p=_rargs(arguments,{eval:function(e){eval(e)}})
allineamenti._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
allineamenti._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
allineamenti._s.SetParameterString('m_bApplet','true');
allineamenti._s.CallServlet('allineamenti');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=allineamenti._s.errmsg;
}
}
allineamenti.CtxLoad_ = function(){return []}
