function arrt_abbina_702_202501() {
var m_Caller
arrt_abbina_702_202501._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_abbina_702_202501._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_abbina_702_202501._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_abbina_702_202501._s.SetParameterString('m_bApplet','true');
arrt_abbina_702_202501._s.CallServlet('arrt_abbina_702_202501');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_abbina_702_202501._s.errmsg;
}
return arrt_abbina_702_202501._s.GetBoolean();
}
arrt_abbina_702_202501.CtxLoad_ = function(){return []}
