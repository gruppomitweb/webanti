function spauthid_bcheck_identity_provider() {
var idpCode;
var m_Caller
spauthid_bcheck_identity_provider._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
idpCode='';
}
if(spauthid_bcheck_identity_provider._p.length>0)_rargs([[['idpCode',spauthid_bcheck_identity_provider._p[0]]]],{eval:function(e){eval(e)}})
spauthid_bcheck_identity_provider._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spauthid_bcheck_identity_provider._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spauthid_bcheck_identity_provider._s.SetParameterString('idpCode',WtA(idpCode,'C'));
spauthid_bcheck_identity_provider._s.SetParameterString('m_bApplet','true');
spauthid_bcheck_identity_provider._s.CallServlet('spauthid_bcheck_identity_provider');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spauthid_bcheck_identity_provider._s.errmsg;
}
}
spauthid_bcheck_identity_provider.CtxLoad_ = function(){return []}
