function arfn_datidip_sol() {
var pCodDip;
var pCodCab;
var pDesCit;
var pProv;
var m_Caller
arfn_datidip_sol._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCodDip='';
pCodCab='';
pDesCit='';
pProv='';
}
if(arfn_datidip_sol._p.length>0)_rargs([[['pCodDip',arfn_datidip_sol._p[0]],['pCodCab',arfn_datidip_sol._p[1]],['pDesCit',arfn_datidip_sol._p[2]],['pProv',arfn_datidip_sol._p[3]]]],{eval:function(e){eval(e)}})
arfn_datidip_sol._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_datidip_sol._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_datidip_sol._s.SetParameterString('pCodDip',WtA(pCodDip,'C'));
arfn_datidip_sol._s.SetParameterString('pCodCab',WtA(pCodCab,'C'));
arfn_datidip_sol._s.SetParameterString('pDesCit',WtA(pDesCit,'C'));
arfn_datidip_sol._s.SetParameterString('pProv',WtA(pProv,'C'));
arfn_datidip_sol._s.SetParameterString('m_bApplet','true');
arfn_datidip_sol._s.CallServlet('arfn_datidip_sol');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_datidip_sol._s.errmsg;
}
return arfn_datidip_sol._s.GetString();
}
arfn_datidip_sol.CtxLoad_ = function(){return []}
