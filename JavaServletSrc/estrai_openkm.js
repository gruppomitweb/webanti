function estrai_openkm() {
var m_Caller
estrai_openkm._p=_rargs(arguments,{eval:function(e){eval(e)}})
estrai_openkm._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
estrai_openkm._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
estrai_openkm._s.SetParameterString('m_bApplet','true');
estrai_openkm._s.CallServlet('estrai_openkm');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=estrai_openkm._s.errmsg;
}
}
estrai_openkm.CtxLoad_ = function(){return []}
