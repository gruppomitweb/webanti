function spadministration_writepwd() {
var password;
var usercode;
var m_Caller
spadministration_writepwd._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
password='';
usercode=0;
}
if(spadministration_writepwd._p.length>0)_rargs([[['password',spadministration_writepwd._p[0]],['usercode',spadministration_writepwd._p[1]]]],{eval:function(e){eval(e)}})
spadministration_writepwd._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spadministration_writepwd._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spadministration_writepwd._s.SetParameterString('password',WtA(password,'C'));
spadministration_writepwd._s.SetParameterString('usercode',WtA(usercode,'N'));
spadministration_writepwd._s.SetParameterString('m_bApplet','true');
spadministration_writepwd._s.CallServlet('spadministration_writepwd');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spadministration_writepwd._s.errmsg;
}
}
spadministration_writepwd.CtxLoad_ = function(){return []}
