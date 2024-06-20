function arrt_importdati() {
var m_Caller
arrt_importdati._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_importdati._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_importdati._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_importdati._s.SetParameterString('m_bApplet','true');
arrt_importdati._s.CallServlet('arrt_importdati');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_importdati._s.errmsg;
}
}
arrt_importdati.CtxLoad_ = function(){return []}
