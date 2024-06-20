function opert_del_scarti_contante() {
var pProg;
var m_Caller
opert_del_scarti_contante._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pProg='';
}
if(opert_del_scarti_contante._p.length>0)_rargs([[['pProg',opert_del_scarti_contante._p[0]]]],{eval:function(e){eval(e)}})
opert_del_scarti_contante._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
opert_del_scarti_contante._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
opert_del_scarti_contante._s.SetParameterString('pProg',WtA(pProg,'C'));
opert_del_scarti_contante._s.SetParameterString('m_bApplet','true');
opert_del_scarti_contante._s.CallServlet('opert_del_scarti_contante');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=opert_del_scarti_contante._s.errmsg;
}
}
opert_del_scarti_contante.CtxLoad_ = function(){return []}
