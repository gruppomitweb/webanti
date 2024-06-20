function arrt_ricercamassa() {
var m_Caller
arrt_ricercamassa._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_ricercamassa._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_ricercamassa._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_ricercamassa._s.SetParameterString('m_bApplet','true');
arrt_ricercamassa._s.CallServlet('arrt_ricercamassa');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_ricercamassa._s.errmsg;
}
}
arrt_ricercamassa.CtxLoad_ = function(){return []}
