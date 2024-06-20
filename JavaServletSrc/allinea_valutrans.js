function allinea_valutrans() {
var m_Caller
allinea_valutrans._p=_rargs(arguments,{eval:function(e){eval(e)}})
allinea_valutrans._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
allinea_valutrans._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
allinea_valutrans._s.SetParameterString('m_bApplet','true');
allinea_valutrans._s.CallServlet('allinea_valutrans');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=allinea_valutrans._s.errmsg;
}
}
allinea_valutrans.CtxLoad_ = function(){return []}
