function arrt_creaxls_decodenascita() {
var m_Caller
arrt_creaxls_decodenascita._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_creaxls_decodenascita._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_creaxls_decodenascita._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_creaxls_decodenascita._s.SetParameterString('m_bApplet','true');
arrt_creaxls_decodenascita._s.CallServlet('arrt_creaxls_decodenascita');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_creaxls_decodenascita._s.errmsg;
}
}
arrt_creaxls_decodenascita.CtxLoad_ = function(){return []}
