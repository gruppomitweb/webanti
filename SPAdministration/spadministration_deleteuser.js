function spadministration_deleteuser() {
var usercode;
var m_Caller
spadministration_deleteuser._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
usercode=0;
}
if(spadministration_deleteuser._p.length>0)_rargs([[['usercode',spadministration_deleteuser._p[0]]]],{eval:function(e){eval(e)}})
spadministration_deleteuser._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spadministration_deleteuser._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spadministration_deleteuser._s.SetParameterString('usercode',WtA(usercode,'N'));
spadministration_deleteuser._s.SetParameterString('m_bApplet','true');
spadministration_deleteuser._s.CallServlet('spadministration_deleteuser');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spadministration_deleteuser._s.errmsg;
}
}
spadministration_deleteuser.CtxLoad_ = function(){return []}
