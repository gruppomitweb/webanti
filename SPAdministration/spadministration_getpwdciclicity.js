function spadministration_getpwdciclicity() {
var usercode;
var m_Caller
spadministration_getpwdciclicity._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
usercode=0;
}
if(spadministration_getpwdciclicity._p.length>0)_rargs([[['usercode',spadministration_getpwdciclicity._p[0]]]],{eval:function(e){eval(e)}})
spadministration_getpwdciclicity._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spadministration_getpwdciclicity._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spadministration_getpwdciclicity._s.SetParameterString('usercode',WtA(usercode,'N'));
spadministration_getpwdciclicity._s.SetParameterString('m_bApplet','true');
spadministration_getpwdciclicity._s.CallServlet('spadministration_getpwdciclicity');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spadministration_getpwdciclicity._s.errmsg;
}
return spadministration_getpwdciclicity._s.GetDouble();
}
spadministration_getpwdciclicity.CtxLoad_ = function(){return []}
