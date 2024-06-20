function spadministration_getpwdciclicity_group() {
var usercode;
var m_Caller
spadministration_getpwdciclicity_group._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
usercode=0;
}
if(spadministration_getpwdciclicity_group._p.length>0)_rargs([[['usercode',spadministration_getpwdciclicity_group._p[0]]]],{eval:function(e){eval(e)}})
spadministration_getpwdciclicity_group._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spadministration_getpwdciclicity_group._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spadministration_getpwdciclicity_group._s.SetParameterString('usercode',WtA(usercode,'N'));
spadministration_getpwdciclicity_group._s.SetParameterString('m_bApplet','true');
spadministration_getpwdciclicity_group._s.CallServlet('spadministration_getpwdciclicity_group');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spadministration_getpwdciclicity_group._s.errmsg;
}
return spadministration_getpwdciclicity_group._s.GetDouble();
}
spadministration_getpwdciclicity_group.CtxLoad_ = function(){return []}
