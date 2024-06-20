function spadministration_ispasswordexpired() {
var usercode;
var password;
var m_Caller
spadministration_ispasswordexpired._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
usercode=0;
password='';
}
if(spadministration_ispasswordexpired._p.length>0)_rargs([[['usercode',spadministration_ispasswordexpired._p[0]],['password',spadministration_ispasswordexpired._p[1]]]],{eval:function(e){eval(e)}})
spadministration_ispasswordexpired._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spadministration_ispasswordexpired._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spadministration_ispasswordexpired._s.SetParameterString('usercode',WtA(usercode,'N'));
spadministration_ispasswordexpired._s.SetParameterString('password',WtA(password,'C'));
spadministration_ispasswordexpired._s.SetParameterString('m_bApplet','true');
spadministration_ispasswordexpired._s.CallServlet('spadministration_ispasswordexpired');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spadministration_ispasswordexpired._s.errmsg;
}
return spadministration_ispasswordexpired._s.GetString();
}
spadministration_ispasswordexpired.CtxLoad_ = function(){return []}
