function arrt_agg_decstati() {
var m_Caller
arrt_agg_decstati._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_agg_decstati._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_agg_decstati._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_agg_decstati._s.SetParameterString('m_bApplet','true');
arrt_agg_decstati._s.CallServlet('arrt_agg_decstati');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_agg_decstati._s.errmsg;
}
}
arrt_agg_decstati.CtxLoad_ = function(){return []}
