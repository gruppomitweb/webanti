function arfn_nuovi_alert() {
var m_Caller
arfn_nuovi_alert._p=_rargs(arguments,{eval:function(e){eval(e)}})
arfn_nuovi_alert._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_nuovi_alert._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_nuovi_alert._s.SetParameterString('m_bApplet','true');
arfn_nuovi_alert._s.CallServlet('arfn_nuovi_alert');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_nuovi_alert._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arfn_nuovi_alert._s.errmsg;
arfn_nuovi_alert._res=new CPMemoryCursor();
} else {
arfn_nuovi_alert._res=arfn_nuovi_alert._s.GetMemoryCursor();
}
return arfn_nuovi_alert._res;
}
arfn_nuovi_alert.CtxLoad_ = function(){return []}
