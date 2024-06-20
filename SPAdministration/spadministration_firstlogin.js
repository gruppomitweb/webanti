function spadministration_firstlogin() {
var usercode;
var m_Caller
spadministration_firstlogin._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
usercode=0;
}
if(spadministration_firstlogin._p.length>0)_rargs([[['usercode',spadministration_firstlogin._p[0]]]],{eval:function(e){eval(e)}})
spadministration_firstlogin._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spadministration_firstlogin._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spadministration_firstlogin._s.SetParameterString('usercode',WtA(usercode,'N'));
spadministration_firstlogin._s.SetParameterString('m_bApplet','true');
spadministration_firstlogin._s.CallServlet('spadministration_firstlogin');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spadministration_firstlogin._s.errmsg;
}
}
spadministration_firstlogin.CtxLoad_ = function(){return []}
