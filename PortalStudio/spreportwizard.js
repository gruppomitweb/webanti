function spreportwizard() {
var reportName;
var JsonWizardReport;
var m_Caller
spreportwizard._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
reportName='';
JsonWizardReport='';
}
if(spreportwizard._p.length>0)_rargs([[['reportName',spreportwizard._p[0]],['JsonWizardReport',spreportwizard._p[1]]]],{eval:function(e){eval(e)}})
spreportwizard._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spreportwizard._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spreportwizard._s.SetParameterString('reportName',WtA(reportName,'C'));
spreportwizard._s.SetParameterString('JsonWizardReport',WtA(JsonWizardReport,'M'));
spreportwizard._s.SetParameterString('m_bApplet','true');
spreportwizard._s.CallServlet('spreportwizard');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spreportwizard._s.errmsg;
}
return spreportwizard._s.GetString();
}
spreportwizard.CtxLoad_ = function(){return []}
