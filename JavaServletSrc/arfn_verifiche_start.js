function arfn_verifiche_start() {
var m_Caller
arfn_verifiche_start._p=_rargs(arguments,{eval:function(e){eval(e)}})
arfn_verifiche_start._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_verifiche_start._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_verifiche_start._s.SetParameterString('m_bApplet','true');
arfn_verifiche_start._s.CallServlet('arfn_verifiche_start');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_verifiche_start._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arfn_verifiche_start._s.errmsg;
arfn_verifiche_start._res=new CPMemoryCursor();
} else {
arfn_verifiche_start._res=arfn_verifiche_start._s.GetMemoryCursor();
}
return arfn_verifiche_start._res;
}
arfn_verifiche_start.CtxLoad_ = function(){return []}
