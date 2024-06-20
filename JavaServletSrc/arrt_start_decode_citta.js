function arrt_start_decode_citta() {
var m_Caller
arrt_start_decode_citta._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_start_decode_citta._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_start_decode_citta._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_start_decode_citta._s.SetParameterString('m_bApplet','true');
arrt_start_decode_citta._s.CallServlet('arrt_start_decode_citta');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_start_decode_citta._s.errmsg;
}
}
arrt_start_decode_citta.CtxLoad_ = function(){return []}
