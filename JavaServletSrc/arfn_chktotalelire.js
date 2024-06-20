function arfn_chktotalelire() {
var pDatOpe;
var pDatEuro;
var pImporto;
var cMultipla;
var m_Caller
arfn_chktotalelire._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDatOpe=NullDate();
pDatEuro=NullDate();
pImporto=0;
cMultipla='';
}
if(arfn_chktotalelire._p.length>0)_rargs([[['pDatOpe',arfn_chktotalelire._p[0]],['pDatEuro',arfn_chktotalelire._p[1]],['pImporto',arfn_chktotalelire._p[2]],['cMultipla',arfn_chktotalelire._p[3]]]],{eval:function(e){eval(e)}})
arfn_chktotalelire._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_chktotalelire._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_chktotalelire._s.SetParameterString('pDatOpe',WtA(pDatOpe,'D'));
arfn_chktotalelire._s.SetParameterString('pDatEuro',WtA(pDatEuro,'D'));
arfn_chktotalelire._s.SetParameterString('pImporto',WtA(pImporto,'N'));
arfn_chktotalelire._s.SetParameterString('cMultipla',WtA(cMultipla,'C'));
arfn_chktotalelire._s.SetParameterString('m_bApplet','true');
arfn_chktotalelire._s.CallServlet('arfn_chktotalelire');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_chktotalelire._s.errmsg;
}
return arfn_chktotalelire._s.GetBoolean();
}
arfn_chktotalelire.CtxLoad_ = function(){return []}
