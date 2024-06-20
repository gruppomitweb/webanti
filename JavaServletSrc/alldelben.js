function alldelben() {
var m_Caller
alldelben._p=_rargs(arguments,{eval:function(e){eval(e)}})
alldelben._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
alldelben._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
alldelben._s.SetParameterString('m_bApplet','true');
alldelben._s.CallServlet('alldelben');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=alldelben._s.errmsg;
}
}
alldelben.CtxLoad_ = function(){return []}
