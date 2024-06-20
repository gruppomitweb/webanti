function arfn_chktotalelire_cont() {
var pDatOpe;
var pDatEuro;
var pImporto;
var pTotale;
var m_Caller
arfn_chktotalelire_cont._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDatOpe=NullDate();
pDatEuro=NullDate();
pImporto=0;
pTotale=0;
}
if(arfn_chktotalelire_cont._p.length>0)_rargs([[['pDatOpe',arfn_chktotalelire_cont._p[0]],['pDatEuro',arfn_chktotalelire_cont._p[1]],['pImporto',arfn_chktotalelire_cont._p[2]],['pTotale',arfn_chktotalelire_cont._p[3]]]],{eval:function(e){eval(e)}})
arfn_chktotalelire_cont._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_chktotalelire_cont._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_chktotalelire_cont._s.SetParameterString('pDatOpe',WtA(pDatOpe,'D'));
arfn_chktotalelire_cont._s.SetParameterString('pDatEuro',WtA(pDatEuro,'D'));
arfn_chktotalelire_cont._s.SetParameterString('pImporto',WtA(pImporto,'N'));
arfn_chktotalelire_cont._s.SetParameterString('pTotale',WtA(pTotale,'N'));
arfn_chktotalelire_cont._s.SetParameterString('m_bApplet','true');
arfn_chktotalelire_cont._s.CallServlet('arfn_chktotalelire_cont');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_chktotalelire_cont._s.errmsg;
}
return arfn_chktotalelire_cont._s.GetBoolean();
}
arfn_chktotalelire_cont.CtxLoad_ = function(){return []}
