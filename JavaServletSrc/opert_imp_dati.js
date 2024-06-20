function opert_imp_dati() {
var w_nomefile;
var w_tipodest;
var w_tipofile;
var w_tipoform;
var w_PAGMEZ;
var pScheduler;
var m_Caller
opert_imp_dati._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_nomefile='';
w_tipodest='';
w_tipofile='';
w_tipoform='';
w_PAGMEZ='';
pScheduler='';
}
if(opert_imp_dati._p.length>0)_rargs([[['w_nomefile',opert_imp_dati._p[0]],['w_tipodest',opert_imp_dati._p[1]],['w_tipofile',opert_imp_dati._p[2]],['w_tipoform',opert_imp_dati._p[3]],['w_PAGMEZ',opert_imp_dati._p[4]],['pScheduler',opert_imp_dati._p[5]]]],{eval:function(e){eval(e)}})
opert_imp_dati._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
opert_imp_dati._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
opert_imp_dati._s.SetParameterString('w_nomefile',WtA(w_nomefile,'C'));
opert_imp_dati._s.SetParameterString('w_tipodest',WtA(w_tipodest,'C'));
opert_imp_dati._s.SetParameterString('w_tipofile',WtA(w_tipofile,'C'));
opert_imp_dati._s.SetParameterString('w_tipoform',WtA(w_tipoform,'C'));
opert_imp_dati._s.SetParameterString('w_PAGMEZ',WtA(w_PAGMEZ,'C'));
opert_imp_dati._s.SetParameterString('pScheduler',WtA(pScheduler,'C'));
opert_imp_dati._s.SetParameterString('m_bApplet','true');
opert_imp_dati._s.CallServlet('opert_imp_dati');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=opert_imp_dati._s.errmsg;
}
return opert_imp_dati._s.GetString();
}
opert_imp_dati.CtxLoad_ = function(){return []}
