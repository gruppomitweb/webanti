function arfn_loadtransprv() {
var pRapporto;
var m_Caller
arfn_loadtransprv._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pRapporto='';
}
if(arfn_loadtransprv._p.length>0)_rargs([[['pRapporto',arfn_loadtransprv._p[0]]]],{eval:function(e){eval(e)}})
arfn_loadtransprv._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_loadtransprv._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_loadtransprv._s.SetParameterString('pRapporto',WtA(pRapporto,'C'));
arfn_loadtransprv._s.SetParameterString('m_bApplet','true');
arfn_loadtransprv._s.CallServlet('arfn_loadtransprv');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_loadtransprv._s.errmsg;
}
return arfn_loadtransprv._s.GetString();
}
arfn_loadtransprv.CtxLoad_ = function(){return []}
