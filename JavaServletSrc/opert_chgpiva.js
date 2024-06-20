function opert_chgpiva() {
var pIVA1;
var pIVA2;
var m_Caller
opert_chgpiva._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pIVA1='';
pIVA2='';
}
if(opert_chgpiva._p.length>0)_rargs([[['pIVA1',opert_chgpiva._p[0]],['pIVA2',opert_chgpiva._p[1]]]],{eval:function(e){eval(e)}})
opert_chgpiva._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
opert_chgpiva._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
opert_chgpiva._s.SetParameterString('pIVA1',WtA(pIVA1,'C'));
opert_chgpiva._s.SetParameterString('pIVA2',WtA(pIVA2,'C'));
opert_chgpiva._s.SetParameterString('m_bApplet','true');
opert_chgpiva._s.CallServlet('opert_chgpiva');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=opert_chgpiva._s.errmsg;
}
return opert_chgpiva._s.GetString();
}
opert_chgpiva.CtxLoad_ = function(){return []}
