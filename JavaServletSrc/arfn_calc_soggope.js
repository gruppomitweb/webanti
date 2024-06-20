function arfn_calc_soggope() {
var pConnes;
var pDatOpe;
var pRuolo;
var m_Caller
arfn_calc_soggope._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pConnes='';
pDatOpe='';
pRuolo='';
}
if(arfn_calc_soggope._p.length>0)_rargs([[['pConnes',arfn_calc_soggope._p[0]],['pDatOpe',arfn_calc_soggope._p[1]],['pRuolo',arfn_calc_soggope._p[2]]]],{eval:function(e){eval(e)}})
arfn_calc_soggope._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_calc_soggope._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_calc_soggope._s.SetParameterString('pConnes',WtA(pConnes,'C'));
arfn_calc_soggope._s.SetParameterString('pDatOpe',WtA(pDatOpe,'C'));
arfn_calc_soggope._s.SetParameterString('pRuolo',WtA(pRuolo,'C'));
arfn_calc_soggope._s.SetParameterString('m_bApplet','true');
arfn_calc_soggope._s.CallServlet('arfn_calc_soggope');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_calc_soggope._s.errmsg;
}
return arfn_calc_soggope._s.GetDouble();
}
arfn_calc_soggope.CtxLoad_ = function(){return []}
