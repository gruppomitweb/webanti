function arfn_mesecf() {
var pMese;
var m_Caller
arfn_mesecf._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pMese='';
}
if(arfn_mesecf._p.length>0)_rargs([[['pMese',arfn_mesecf._p[0]]]],{eval:function(e){eval(e)}})
arfn_mesecf._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_mesecf._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_mesecf._s.SetParameterString('pMese',WtA(pMese,'C'));
arfn_mesecf._s.SetParameterString('m_bApplet','true');
arfn_mesecf._s.CallServlet('arfn_mesecf');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_mesecf._s.errmsg;
}
return arfn_mesecf._s.GetString();
}
arfn_mesecf.CtxLoad_ = function(){return []}
