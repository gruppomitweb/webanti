function spauthid_bstart_authentication() {
var idpCode;
var company;
var m_Caller
spauthid_bstart_authentication._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
idpCode='';
company='';
}
if(spauthid_bstart_authentication._p.length>0)_rargs([[['idpCode',spauthid_bstart_authentication._p[0]],['company',spauthid_bstart_authentication._p[1]]]],{eval:function(e){eval(e)}})
spauthid_bstart_authentication._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spauthid_bstart_authentication._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spauthid_bstart_authentication._s.SetParameterString('idpCode',WtA(idpCode,'C'));
spauthid_bstart_authentication._s.SetParameterString('company',WtA(company,'C'));
spauthid_bstart_authentication._s.SetParameterString('m_bApplet','true');
spauthid_bstart_authentication._s.CallServlet('spauthid_bstart_authentication');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spauthid_bstart_authentication._s.errmsg;
}
}
spauthid_bstart_authentication.CtxLoad_ = function(){return []}
