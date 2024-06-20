function arfn_mese_inifin() {
var pAnno;
var pMese;
var pTipo;
var m_Caller
arfn_mese_inifin._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pAnno=0;
pMese='';
pTipo='';
}
if(arfn_mese_inifin._p.length>0)_rargs([[['pAnno',arfn_mese_inifin._p[0]],['pMese',arfn_mese_inifin._p[1]],['pTipo',arfn_mese_inifin._p[2]]]],{eval:function(e){eval(e)}})
arfn_mese_inifin._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_mese_inifin._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_mese_inifin._s.SetParameterString('pAnno',WtA(pAnno,'N'));
arfn_mese_inifin._s.SetParameterString('pMese',WtA(pMese,'C'));
arfn_mese_inifin._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_mese_inifin._s.SetParameterString('m_bApplet','true');
arfn_mese_inifin._s.CallServlet('arfn_mese_inifin');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_mese_inifin._s.errmsg;
}
return DateFromApplet(arfn_mese_inifin._s.GetDate());
}
arfn_mese_inifin.CtxLoad_ = function(){return []}
