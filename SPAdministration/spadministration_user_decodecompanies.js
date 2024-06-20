function spadministration_user_decodecompanies() {
var pCompanies;
var m_Caller
spadministration_user_decodecompanies._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCompanies='';
}
if(spadministration_user_decodecompanies._p.length>0)_rargs([[['pCompanies',spadministration_user_decodecompanies._p[0]]]],{eval:function(e){eval(e)}})
spadministration_user_decodecompanies._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spadministration_user_decodecompanies._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spadministration_user_decodecompanies._s.SetParameterString('pCompanies',WtA(pCompanies,'C'));
spadministration_user_decodecompanies._s.SetParameterString('m_bApplet','true');
spadministration_user_decodecompanies._s.CallServlet('spadministration_user_decodecompanies');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spadministration_user_decodecompanies._s.errmsg;
}
return spadministration_user_decodecompanies._s.GetString();
}
spadministration_user_decodecompanies.CtxLoad_ = function(){return []}
