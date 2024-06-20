function arfn_chk_sl_fatca() {
var pRiga;
var pTipo;
var pLista;
var m_Caller
arfn_chk_sl_fatca._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pRiga=0;
pTipo='';
pLista='';
}
if(arfn_chk_sl_fatca._p.length>0)_rargs([[['pRiga',arfn_chk_sl_fatca._p[0]],['pTipo',arfn_chk_sl_fatca._p[1]],['pLista',arfn_chk_sl_fatca._p[2]]]],{eval:function(e){eval(e)}})
arfn_chk_sl_fatca._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_chk_sl_fatca._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_chk_sl_fatca._s.SetParameterString('pRiga',WtA(pRiga,'N'));
arfn_chk_sl_fatca._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_chk_sl_fatca._s.SetParameterString('pLista',WtA(pLista,'M'));
arfn_chk_sl_fatca._s.SetParameterString('m_bApplet','true');
arfn_chk_sl_fatca._s.CallServlet('arfn_chk_sl_fatca');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_chk_sl_fatca._s.errmsg;
}
return arfn_chk_sl_fatca._s.GetBoolean();
}
arfn_chk_sl_fatca.CtxLoad_ = function(){return []}
