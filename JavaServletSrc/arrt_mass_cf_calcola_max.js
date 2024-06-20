function arrt_mass_cf_calcola_max() {
var w_tipoinv;
var m_Caller
arrt_mass_cf_calcola_max._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_tipoinv='';
}
if(arrt_mass_cf_calcola_max._p.length>0)_rargs([[['w_tipoinv',arrt_mass_cf_calcola_max._p[0]]]],{eval:function(e){eval(e)}})
arrt_mass_cf_calcola_max._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_mass_cf_calcola_max._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_mass_cf_calcola_max._s.SetParameterString('w_tipoinv',WtA(w_tipoinv,'C'));
arrt_mass_cf_calcola_max._s.SetParameterString('m_bApplet','true');
arrt_mass_cf_calcola_max._s.CallServlet('arrt_mass_cf_calcola_max');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_mass_cf_calcola_max._s.errmsg;
}
return arrt_mass_cf_calcola_max._s.GetDouble();
}
arrt_mass_cf_calcola_max.CtxLoad_ = function(){return []}
