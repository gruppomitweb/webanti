function arrt_aggiornamento_multiple_dc() {
var azione;
var CAIDBIGLIETTO;
var m_Caller
arrt_aggiornamento_multiple_dc._p=_rargs(arguments,{eval:function(e){eval(e)}},null,'arrt_aggiornamento_multiple_dc')
function i_BlankParameters() {
azione='';
CAIDBIGLIETTO='';
}
if(arrt_aggiornamento_multiple_dc._p.length>0)_rargs([[['pObj',arrt_aggiornamento_multiple_dc._p[0]],['azione',arrt_aggiornamento_multiple_dc._p[1]],['CAIDBIGLIETTO',arrt_aggiornamento_multiple_dc._p[2]]]],{eval:function(e){eval(e)}})
arrt_aggiornamento_multiple_dc._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_aggiornamento_multiple_dc._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_aggiornamento_multiple_dc._s.SetParameterString('pObj',WtA(pObj,'C'));
arrt_aggiornamento_multiple_dc._s.SetParameterString('azione',WtA(azione,'C'));
arrt_aggiornamento_multiple_dc._s.SetParameterString('CAIDBIGLIETTO',WtA(CAIDBIGLIETTO,'C'));
arrt_aggiornamento_multiple_dc._s.SetParameterString('m_bApplet','true');
arrt_aggiornamento_multiple_dc._s.CallServlet('arrt_aggiornamento_multiple_dc');
if (Gt(arrt_aggiornamento_multiple_dc._p.length,0)) {
arrt_aggiornamento_multiple_dc._p[0].SetFromContext(arrt_aggiornamento_multiple_dc._s.GetCallerStringVar('pObj'));
} else {
arrt_aggiornamento_multiple_dc._search_par=[];
for (var i=0;i<arguments[0].length;i++) arrt_aggiornamento_multiple_dc._search_par[i]=arguments[0][i][0];
arguments[0][LibJavascript.Array.indexOf(arrt_aggiornamento_multiple_dc._search_par,'pObj')][1].SetFromContext(arrt_aggiornamento_multiple_dc._s.GetCallerStringVar('pObj'));
}
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_aggiornamento_multiple_dc._s.errmsg;
}
}
arrt_aggiornamento_multiple_dc.CtxLoad_ = function(){return []}
