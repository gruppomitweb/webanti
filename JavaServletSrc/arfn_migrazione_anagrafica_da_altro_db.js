function arfn_migrazione_anagrafica_da_altro_db() {
var pconnes;
var m_Caller
arfn_migrazione_anagrafica_da_altro_db._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pconnes='';
}
if(arfn_migrazione_anagrafica_da_altro_db._p.length>0)_rargs([[['pconnes',arfn_migrazione_anagrafica_da_altro_db._p[0]]]],{eval:function(e){eval(e)}})
arfn_migrazione_anagrafica_da_altro_db._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_migrazione_anagrafica_da_altro_db._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_migrazione_anagrafica_da_altro_db._s.SetParameterString('pconnes',WtA(pconnes,'C'));
arfn_migrazione_anagrafica_da_altro_db._s.SetParameterString('m_bApplet','true');
arfn_migrazione_anagrafica_da_altro_db._s.CallServlet('arfn_migrazione_anagrafica_da_altro_db');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_migrazione_anagrafica_da_altro_db._s.errmsg;
}
return arfn_migrazione_anagrafica_da_altro_db._s.GetString();
}
arfn_migrazione_anagrafica_da_altro_db.CtxLoad_ = function(){return []}
