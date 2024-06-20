function spadministration_check_username() {
var usercode;
var username;
var m_Caller
spadministration_check_username._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
usercode=0;
username='';
}
if(spadministration_check_username._p.length>0)_rargs([[['usercode',spadministration_check_username._p[0]],['username',spadministration_check_username._p[1]]]],{eval:function(e){eval(e)}})
spadministration_check_username._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spadministration_check_username._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spadministration_check_username._s.SetParameterString('usercode',WtA(usercode,'N'));
spadministration_check_username._s.SetParameterString('username',WtA(username,'C'));
spadministration_check_username._s.SetParameterString('m_bApplet','true');
spadministration_check_username._s.CallServlet('spadministration_check_username');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spadministration_check_username._s.errmsg;
}
return spadministration_check_username._s.GetBoolean();
}
spadministration_check_username.CtxLoad_ = function(){return []}
