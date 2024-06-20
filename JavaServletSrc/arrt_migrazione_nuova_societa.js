function arrt_migrazione_nuova_societa() {
var pDataOpe;
var pDataReg;
var pNomeDataBaseSorgente;
var pNomeAziendaSogernteDati;
var m_Caller
arrt_migrazione_nuova_societa._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDataOpe=NullDate();
pDataReg=NullDate();
pNomeDataBaseSorgente='';
pNomeAziendaSogernteDati='';
}
if(arrt_migrazione_nuova_societa._p.length>0)_rargs([[['pDataOpe',arrt_migrazione_nuova_societa._p[0]],['pDataReg',arrt_migrazione_nuova_societa._p[1]],['pNomeDataBaseSorgente',arrt_migrazione_nuova_societa._p[2]],['pNomeAziendaSogernteDati',arrt_migrazione_nuova_societa._p[3]]]],{eval:function(e){eval(e)}})
arrt_migrazione_nuova_societa._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_migrazione_nuova_societa._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_migrazione_nuova_societa._s.SetParameterString('pDataOpe',WtA(pDataOpe,'D'));
arrt_migrazione_nuova_societa._s.SetParameterString('pDataReg',WtA(pDataReg,'D'));
arrt_migrazione_nuova_societa._s.SetParameterString('pNomeDataBaseSorgente',WtA(pNomeDataBaseSorgente,'C'));
arrt_migrazione_nuova_societa._s.SetParameterString('pNomeAziendaSogernteDati',WtA(pNomeAziendaSogernteDati,'C'));
arrt_migrazione_nuova_societa._s.SetParameterString('m_bApplet','true');
arrt_migrazione_nuova_societa._s.CallServlet('arrt_migrazione_nuova_societa');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_migrazione_nuova_societa._s.errmsg;
}
}
arrt_migrazione_nuova_societa.CtxLoad_ = function(){return []}
