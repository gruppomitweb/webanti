function arfn_wu_sblocco_usr() {
var pUser;
var m_Caller
arfn_wu_sblocco_usr._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pUser=0;
}
if(arfn_wu_sblocco_usr._p.length>0)_rargs([[['pUser',arfn_wu_sblocco_usr._p[0]]]],{eval:function(e){eval(e)}})
arfn_wu_sblocco_usr._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_wu_sblocco_usr._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_wu_sblocco_usr._s.SetParameterString('pUser',WtA(pUser,'N'));
arfn_wu_sblocco_usr._s.SetParameterString('m_bApplet','true');
arfn_wu_sblocco_usr._s.CallServlet('arfn_wu_sblocco_usr');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_wu_sblocco_usr._s.errmsg;
}
return arfn_wu_sblocco_usr._s.GetString();
}
arfn_wu_sblocco_usr.CtxLoad_ = function(){return []}
