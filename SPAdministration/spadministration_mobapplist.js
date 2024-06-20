function spadministration_mobapplist() {
var m_Caller
spadministration_mobapplist._p=_rargs(arguments,{eval:function(e){eval(e)}})
spadministration_mobapplist._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spadministration_mobapplist._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spadministration_mobapplist._s.SetParameterString('m_bApplet','true');
spadministration_mobapplist._s.CallServlet('spadministration_mobapplist');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spadministration_mobapplist._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=spadministration_mobapplist._s.errmsg;
spadministration_mobapplist._res=new CPMemoryCursor();
} else {
spadministration_mobapplist._res=spadministration_mobapplist._s.GetMemoryCursor();
}
return spadministration_mobapplist._res;
}
spadministration_mobapplist.CtxLoad_ = function(){return []}
