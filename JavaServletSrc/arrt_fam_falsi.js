function arrt_fam_falsi() {
var m_Caller
arrt_fam_falsi._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_fam_falsi._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_fam_falsi._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_fam_falsi._s.SetParameterString('m_bApplet','true');
arrt_fam_falsi._s.CallServlet('arrt_fam_falsi');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_fam_falsi._s.errmsg;
}
}
arrt_fam_falsi.CtxLoad_ = function(){return []}
