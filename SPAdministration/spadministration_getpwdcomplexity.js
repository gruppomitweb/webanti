function spadministration_getpwdcomplexity() {
var usercode;
var m_Caller
spadministration_getpwdcomplexity._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
usercode=0;
}
if(spadministration_getpwdcomplexity._p.length>0)_rargs([[['usercode',spadministration_getpwdcomplexity._p[0]]]],{eval:function(e){eval(e)}})
spadministration_getpwdcomplexity._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spadministration_getpwdcomplexity._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spadministration_getpwdcomplexity._s.SetParameterString('usercode',WtA(usercode,'N'));
spadministration_getpwdcomplexity._s.SetParameterString('m_bApplet','true');
spadministration_getpwdcomplexity._s.CallServlet('spadministration_getpwdcomplexity');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spadministration_getpwdcomplexity._s.errmsg;
}
return spadministration_getpwdcomplexity._s.GetDouble();
}
spadministration_getpwdcomplexity.CtxLoad_ = function(){return []}
