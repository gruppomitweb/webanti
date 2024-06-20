function arrt_fammigra_imp() {
var m_Caller
arrt_fammigra_imp._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_fammigra_imp._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_fammigra_imp._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_fammigra_imp._s.SetParameterString('m_bApplet','true');
arrt_fammigra_imp._s.CallServlet('arrt_fammigra_imp');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_fammigra_imp._s.errmsg;
}
return arrt_fammigra_imp._s.GetString();
}
arrt_fammigra_imp.CtxLoad_ = function(){return []}
