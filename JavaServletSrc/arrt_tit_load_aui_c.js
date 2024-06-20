function arrt_tit_load_aui_c() {
var m_Caller
arrt_tit_load_aui_c._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_tit_load_aui_c._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_tit_load_aui_c._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_tit_load_aui_c._s.SetParameterString('m_bApplet','true');
arrt_tit_load_aui_c._s.CallServlet('arrt_tit_load_aui_c');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_tit_load_aui_c._s.errmsg;
}
}
arrt_tit_load_aui_c.CtxLoad_ = function(){return []}
