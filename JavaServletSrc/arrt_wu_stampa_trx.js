function arrt_wu_stampa_trx() {
var pDatIni;
var pDatFin;
var m_Caller
arrt_wu_stampa_trx._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDatIni=NullDate();
pDatFin=NullDate();
}
if(arrt_wu_stampa_trx._p.length>0)_rargs([[['pDatIni',arrt_wu_stampa_trx._p[0]],['pDatFin',arrt_wu_stampa_trx._p[1]]]],{eval:function(e){eval(e)}})
arrt_wu_stampa_trx._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_wu_stampa_trx._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_wu_stampa_trx._s.SetParameterString('pDatIni',WtA(pDatIni,'D'));
arrt_wu_stampa_trx._s.SetParameterString('pDatFin',WtA(pDatFin,'D'));
arrt_wu_stampa_trx._s.SetParameterString('m_bApplet','true');
arrt_wu_stampa_trx._s.CallServlet('arrt_wu_stampa_trx');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_wu_stampa_trx._s.errmsg;
}
return arrt_wu_stampa_trx._s.GetString();
}
arrt_wu_stampa_trx.CtxLoad_ = function(){return []}
