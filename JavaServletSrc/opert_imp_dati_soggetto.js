function opert_imp_dati_soggetto() {
var pIVA;
var m_Caller
opert_imp_dati_soggetto._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pIVA='';
}
if(opert_imp_dati_soggetto._p.length>0)_rargs([[['pIVA',opert_imp_dati_soggetto._p[0]]]],{eval:function(e){eval(e)}})
opert_imp_dati_soggetto._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
opert_imp_dati_soggetto._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
opert_imp_dati_soggetto._s.SetParameterString('pIVA',WtA(pIVA,'C'));
opert_imp_dati_soggetto._s.SetParameterString('m_bApplet','true');
opert_imp_dati_soggetto._s.CallServlet('opert_imp_dati_soggetto');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=opert_imp_dati_soggetto._s.errmsg;
}
}
opert_imp_dati_soggetto.CtxLoad_ = function(){return []}
