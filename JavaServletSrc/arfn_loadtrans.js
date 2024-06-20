function arfn_loadtrans() {
var pRapporto;
var m_Caller
arfn_loadtrans._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pRapporto='';
}
if(arfn_loadtrans._p.length>0)_rargs([[['pRapporto',arfn_loadtrans._p[0]]]],{eval:function(e){eval(e)}})
arfn_loadtrans._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_loadtrans._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_loadtrans._s.SetParameterString('pRapporto',WtA(pRapporto,'C'));
arfn_loadtrans._s.SetParameterString('m_bApplet','true');
arfn_loadtrans._s.CallServlet('arfn_loadtrans');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_loadtrans._s.errmsg;
}
return arfn_loadtrans._s.GetString();
}
arfn_loadtrans.CtxLoad_ = function(){return []}
