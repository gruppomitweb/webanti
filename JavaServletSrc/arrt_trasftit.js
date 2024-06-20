function arrt_trasftit() {
var m_Caller
arrt_trasftit._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_trasftit._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_trasftit._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_trasftit._s.SetParameterString('m_bApplet','true');
arrt_trasftit._s.CallServlet('arrt_trasftit');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_trasftit._s.errmsg;
}
return arrt_trasftit._s.GetString();
}
arrt_trasftit.CtxLoad_ = function(){return []}
