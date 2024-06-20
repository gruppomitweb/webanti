function opert_stampa_ope() {
var w_dadatreg;
var w_a_datreg;
var w_daSog;
var w_aSog;
var w_flgtit;
var pType;
var w_dadest;
var w_a_dest;
var m_Caller
opert_stampa_ope._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_dadatreg=NullDate();
w_a_datreg=NullDate();
w_daSog='';
w_aSog='';
w_flgtit='';
pType='';
w_dadest='';
w_a_dest='';
}
if(opert_stampa_ope._p.length>0)_rargs([[['w_dadatreg',opert_stampa_ope._p[0]],['w_a_datreg',opert_stampa_ope._p[1]],['w_daSog',opert_stampa_ope._p[2]],['w_aSog',opert_stampa_ope._p[3]],['w_flgtit',opert_stampa_ope._p[4]],['pType',opert_stampa_ope._p[5]],['w_dadest',opert_stampa_ope._p[6]],['w_a_dest',opert_stampa_ope._p[7]]]],{eval:function(e){eval(e)}})
opert_stampa_ope._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
opert_stampa_ope._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
opert_stampa_ope._s.SetParameterString('w_dadatreg',WtA(w_dadatreg,'D'));
opert_stampa_ope._s.SetParameterString('w_a_datreg',WtA(w_a_datreg,'D'));
opert_stampa_ope._s.SetParameterString('w_daSog',WtA(w_daSog,'C'));
opert_stampa_ope._s.SetParameterString('w_aSog',WtA(w_aSog,'C'));
opert_stampa_ope._s.SetParameterString('w_flgtit',WtA(w_flgtit,'C'));
opert_stampa_ope._s.SetParameterString('pType',WtA(pType,'C'));
opert_stampa_ope._s.SetParameterString('w_dadest',WtA(w_dadest,'C'));
opert_stampa_ope._s.SetParameterString('w_a_dest',WtA(w_a_dest,'C'));
opert_stampa_ope._s.SetParameterString('m_bApplet','true');
opert_stampa_ope._s.CallServlet('opert_stampa_ope');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=opert_stampa_ope._s.errmsg;
}
}
opert_stampa_ope.CtxLoad_ = function(){return []}
