function arfn_cgo_punteggio_adv() {
var pDomanda;
var pValore;
var m_Caller
arfn_cgo_punteggio_adv._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDomanda=0;
pValore=0;
}
if(arfn_cgo_punteggio_adv._p.length>0)_rargs([[['pDomanda',arfn_cgo_punteggio_adv._p[0]],['pValore',arfn_cgo_punteggio_adv._p[1]]]],{eval:function(e){eval(e)}})
arfn_cgo_punteggio_adv._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_cgo_punteggio_adv._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_cgo_punteggio_adv._s.SetParameterString('pDomanda',WtA(pDomanda,'N'));
arfn_cgo_punteggio_adv._s.SetParameterString('pValore',WtA(pValore,'N'));
arfn_cgo_punteggio_adv._s.SetParameterString('m_bApplet','true');
arfn_cgo_punteggio_adv._s.CallServlet('arfn_cgo_punteggio_adv');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_cgo_punteggio_adv._s.errmsg;
}
return arfn_cgo_punteggio_adv._s.GetDouble();
}
arfn_cgo_punteggio_adv.CtxLoad_ = function(){return []}
