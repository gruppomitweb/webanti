function spaddsecurityrecord() {
var m_Caller
spaddsecurityrecord._p=_rargs(arguments,{eval:function(e){eval(e)}})
spaddsecurityrecord._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spaddsecurityrecord._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spaddsecurityrecord._s.SetParameterString('m_bApplet','true');
spaddsecurityrecord._s.CallServlet('spaddsecurityrecord');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spaddsecurityrecord._s.errmsg;
}
}
spaddsecurityrecord.CtxLoad_ = function(){return []}
