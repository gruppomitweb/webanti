function arfn_calcflaglire() {
var pDatOpe;
var pTipDiv;
var pDatEuro;
var m_Caller
arfn_calcflaglire._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDatOpe=NullDate();
pTipDiv='';
pDatEuro=NullDate();
}
if(arfn_calcflaglire._p.length>0)_rargs([[['pDatOpe',arfn_calcflaglire._p[0]],['pTipDiv',arfn_calcflaglire._p[1]],['pDatEuro',arfn_calcflaglire._p[2]]]],{eval:function(e){eval(e)}})
arfn_calcflaglire._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_calcflaglire._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_calcflaglire._s.SetParameterString('pDatOpe',WtA(pDatOpe,'D'));
arfn_calcflaglire._s.SetParameterString('pTipDiv',WtA(pTipDiv,'C'));
arfn_calcflaglire._s.SetParameterString('pDatEuro',WtA(pDatEuro,'D'));
arfn_calcflaglire._s.SetParameterString('m_bApplet','true');
arfn_calcflaglire._s.CallServlet('arfn_calcflaglire');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_calcflaglire._s.errmsg;
}
return arfn_calcflaglire._s.GetString();
}
arfn_calcflaglire.CtxLoad_ = function(){return []}
