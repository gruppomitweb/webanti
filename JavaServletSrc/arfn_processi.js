function arfn_processi() {
var m_Caller
arfn_processi._p=_rargs(arguments,{eval:function(e){eval(e)}})
arfn_processi._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_processi._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_processi._s.SetParameterString('m_bApplet','true');
arfn_processi._s.CallServlet('arfn_processi');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_processi._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arfn_processi._s.errmsg;
arfn_processi._res=new CPMemoryCursor();
} else {
arfn_processi._res=arfn_processi._s.GetMemoryCursor();
}
return arfn_processi._res;
}
arfn_processi.CtxLoad_ = function(){return []}
