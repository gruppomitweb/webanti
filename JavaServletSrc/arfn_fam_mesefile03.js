function arfn_fam_mesefile03() {
var pRow;
var pAnno;
var pTipo;
var pValuta;
var m_Caller
arfn_fam_mesefile03._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pAnno=0;
pTipo='';
pValuta='';
}
if(arfn_fam_mesefile03._p.length>0)_rargs([[['pRow',arfn_fam_mesefile03._p[0]],['pAnno',arfn_fam_mesefile03._p[1]],['pTipo',arfn_fam_mesefile03._p[2]],['pValuta',arfn_fam_mesefile03._p[3]]]],{eval:function(e){eval(e)}})
arfn_fam_mesefile03._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_fam_mesefile03._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_fam_mesefile03._s.SetParameterString('pRow',WtA(pRow,'R'),pRow);
arfn_fam_mesefile03._s.SetParameterString('pAnno',WtA(pAnno,'N'));
arfn_fam_mesefile03._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_fam_mesefile03._s.SetParameterString('pValuta',WtA(pValuta,'C'));
arfn_fam_mesefile03._s.SetParameterString('m_bApplet','true');
arfn_fam_mesefile03._s.CallServlet('arfn_fam_mesefile03');
pRow.Copy(arfn_fam_mesefile03._s.GetCallerMemoryCursorRowVar('pRow'))
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_fam_mesefile03._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arfn_fam_mesefile03._s.errmsg;
arfn_fam_mesefile03._res=new CPMemoryCursor();
} else {
arfn_fam_mesefile03._res=arfn_fam_mesefile03._s.GetMemoryCursor();
if (Eq(arfn_fam_mesefile03._res,arfn_fam_mesefile03._s.GetCallerMemoryCursorRowVar('pRow'))) {
arfn_fam_mesefile03._res=pRow;
}
}
return arfn_fam_mesefile03._res;
}
arfn_fam_mesefile03.CtxLoad_ = function(){return []}
