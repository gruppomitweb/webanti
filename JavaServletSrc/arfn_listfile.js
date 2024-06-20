function arfn_listfile() {
var m_Caller
arfn_listfile._p=_rargs(arguments,{eval:function(e){eval(e)}})
arfn_listfile._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_listfile._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_listfile._s.SetParameterString('m_bApplet','true');
arfn_listfile._s.CallServlet('arfn_listfile');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_listfile._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arfn_listfile._s.errmsg;
arfn_listfile._res=new CPMemoryCursor();
} else {
arfn_listfile._res=arfn_listfile._s.GetMemoryCursor();
}
return arfn_listfile._res;
}
arfn_listfile.CtxLoad_ = function(){return []}
