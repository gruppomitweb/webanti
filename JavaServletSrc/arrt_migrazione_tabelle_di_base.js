function arrt_migrazione_tabelle_di_base() {
var pNomeDataBaseSorgente;
var pNomeAziendaSogernteDati;
var m_Caller
arrt_migrazione_tabelle_di_base._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pNomeDataBaseSorgente='';
pNomeAziendaSogernteDati='';
}
if(arrt_migrazione_tabelle_di_base._p.length>0)_rargs([[['pNomeDataBaseSorgente',arrt_migrazione_tabelle_di_base._p[0]],['pNomeAziendaSogernteDati',arrt_migrazione_tabelle_di_base._p[1]]]],{eval:function(e){eval(e)}})
arrt_migrazione_tabelle_di_base._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_migrazione_tabelle_di_base._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_migrazione_tabelle_di_base._s.SetParameterString('pNomeDataBaseSorgente',WtA(pNomeDataBaseSorgente,'C'));
arrt_migrazione_tabelle_di_base._s.SetParameterString('pNomeAziendaSogernteDati',WtA(pNomeAziendaSogernteDati,'C'));
arrt_migrazione_tabelle_di_base._s.SetParameterString('m_bApplet','true');
arrt_migrazione_tabelle_di_base._s.CallServlet('arrt_migrazione_tabelle_di_base');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_migrazione_tabelle_di_base._s.errmsg;
}
}
arrt_migrazione_tabelle_di_base.CtxLoad_ = function(){return []}
