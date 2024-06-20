function arfn_filesage() {
var m_Caller
arfn_filesage._p=_rargs(arguments,{eval:function(e){eval(e)}})
arfn_filesage._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_filesage._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_filesage._s.SetParameterString('m_bApplet','true');
arfn_filesage._s.CallServlet('arfn_filesage');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_filesage._s.errmsg;
}
return arfn_filesage._s.GetDouble();
}
arfn_filesage.CtxLoad_ = function(){return []}
