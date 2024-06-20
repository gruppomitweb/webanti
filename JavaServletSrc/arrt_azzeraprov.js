function arrt_azzeraprov() {
var m_Caller
arrt_azzeraprov._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_azzeraprov._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_azzeraprov._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_azzeraprov._s.SetParameterString('m_bApplet','true');
arrt_azzeraprov._s.CallServlet('arrt_azzeraprov');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_azzeraprov._s.errmsg;
}
return arrt_azzeraprov._s.GetString();
}
arrt_azzeraprov.CtxLoad_ = function(){return []}
