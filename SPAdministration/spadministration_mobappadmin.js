function spadministration_mobappadmin() {
var appNames;
var forceCreateFile;
var ignoreFile;
var m_Caller
spadministration_mobappadmin._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
appNames='';
forceCreateFile=false;
ignoreFile=false;
}
if(spadministration_mobappadmin._p.length>0)_rargs([[['appNames',spadministration_mobappadmin._p[0]],['forceCreateFile',spadministration_mobappadmin._p[1]],['ignoreFile',spadministration_mobappadmin._p[2]]]],{eval:function(e){eval(e)}})
spadministration_mobappadmin._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spadministration_mobappadmin._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spadministration_mobappadmin._s.SetParameterString('appNames',WtA(appNames,'M'));
spadministration_mobappadmin._s.SetParameterString('forceCreateFile',WtA(forceCreateFile,'L'));
spadministration_mobappadmin._s.SetParameterString('ignoreFile',WtA(ignoreFile,'L'));
spadministration_mobappadmin._s.SetParameterString('m_bApplet','true');
spadministration_mobappadmin._s.CallServlet('spadministration_mobappadmin');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spadministration_mobappadmin._s.errmsg;
}
return spadministration_mobappadmin._s.GetBoolean();
}
spadministration_mobappadmin.CtxLoad_ = function(){return []}
