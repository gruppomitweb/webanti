function arfn_chktotalelire_fraz() {
var pDatOpe;
var pDatEuro;
var pImporto;
var m_Caller
arfn_chktotalelire_fraz._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDatOpe=NullDate();
pDatEuro=NullDate();
pImporto=0;
}
if(arfn_chktotalelire_fraz._p.length>0)_rargs([[['pDatOpe',arfn_chktotalelire_fraz._p[0]],['pDatEuro',arfn_chktotalelire_fraz._p[1]],['pImporto',arfn_chktotalelire_fraz._p[2]]]],{eval:function(e){eval(e)}})
arfn_chktotalelire_fraz._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_chktotalelire_fraz._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_chktotalelire_fraz._s.SetParameterString('pDatOpe',WtA(pDatOpe,'D'));
arfn_chktotalelire_fraz._s.SetParameterString('pDatEuro',WtA(pDatEuro,'D'));
arfn_chktotalelire_fraz._s.SetParameterString('pImporto',WtA(pImporto,'N'));
arfn_chktotalelire_fraz._s.SetParameterString('m_bApplet','true');
arfn_chktotalelire_fraz._s.CallServlet('arfn_chktotalelire_fraz');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_chktotalelire_fraz._s.errmsg;
}
return arfn_chktotalelire_fraz._s.GetBoolean();
}
arfn_chktotalelire_fraz.CtxLoad_ = function(){return []}
