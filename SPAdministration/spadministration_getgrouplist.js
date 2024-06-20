function spadministration_getgrouplist() {
var userCode;
var m_Caller
spadministration_getgrouplist._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
userCode=0;
}
if(spadministration_getgrouplist._p.length>0)_rargs([[['userCode',spadministration_getgrouplist._p[0]]]],{eval:function(e){eval(e)}})
spadministration_getgrouplist._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spadministration_getgrouplist._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spadministration_getgrouplist._s.SetParameterString('userCode',WtA(userCode,'N'));
spadministration_getgrouplist._s.SetParameterString('m_bApplet','true');
spadministration_getgrouplist._s.CallServlet('spadministration_getgrouplist');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spadministration_getgrouplist._s.errmsg;
}
return spadministration_getgrouplist._s.GetString();
}
spadministration_getgrouplist.CtxLoad_ = function(){return []}
