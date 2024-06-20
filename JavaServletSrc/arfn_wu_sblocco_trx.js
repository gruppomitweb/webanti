function arfn_wu_sblocco_trx() {
var pTRX;
var m_Caller
arfn_wu_sblocco_trx._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTRX=0;
}
if(arfn_wu_sblocco_trx._p.length>0)_rargs([[['pTRX',arfn_wu_sblocco_trx._p[0]]]],{eval:function(e){eval(e)}})
arfn_wu_sblocco_trx._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_wu_sblocco_trx._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_wu_sblocco_trx._s.SetParameterString('pTRX',WtA(pTRX,'N'));
arfn_wu_sblocco_trx._s.SetParameterString('m_bApplet','true');
arfn_wu_sblocco_trx._s.CallServlet('arfn_wu_sblocco_trx');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_wu_sblocco_trx._s.errmsg;
}
return arfn_wu_sblocco_trx._s.GetString();
}
arfn_wu_sblocco_trx.CtxLoad_ = function(){return []}
