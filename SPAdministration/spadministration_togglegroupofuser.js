function spadministration_togglegroupofuser() {
var userCode;
var groupCode;
var m_Caller
spadministration_togglegroupofuser._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
userCode=0;
groupCode=0;
}
if(spadministration_togglegroupofuser._p.length>0)_rargs([[['userCode',spadministration_togglegroupofuser._p[0]],['groupCode',spadministration_togglegroupofuser._p[1]]]],{eval:function(e){eval(e)}})
spadministration_togglegroupofuser._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spadministration_togglegroupofuser._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spadministration_togglegroupofuser._s.SetParameterString('userCode',WtA(userCode,'N'));
spadministration_togglegroupofuser._s.SetParameterString('groupCode',WtA(groupCode,'N'));
spadministration_togglegroupofuser._s.SetParameterString('m_bApplet','true');
spadministration_togglegroupofuser._s.CallServlet('spadministration_togglegroupofuser');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spadministration_togglegroupofuser._s.errmsg;
}
return spadministration_togglegroupofuser._s.GetBoolean();
}
spadministration_togglegroupofuser.CtxLoad_ = function(){return []}
