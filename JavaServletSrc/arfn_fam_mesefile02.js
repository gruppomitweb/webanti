function arfn_fam_mesefile02() {
var pRow;
var pDaData;
var pAData;
var pTipo;
var m_Caller
arfn_fam_mesefile02._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDaData=NullDate();
pAData=NullDate();
pTipo='';
}
if(arfn_fam_mesefile02._p.length>0)_rargs([[['pRow',arfn_fam_mesefile02._p[0]],['pDaData',arfn_fam_mesefile02._p[1]],['pAData',arfn_fam_mesefile02._p[2]],['pTipo',arfn_fam_mesefile02._p[3]]]],{eval:function(e){eval(e)}})
arfn_fam_mesefile02._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_fam_mesefile02._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_fam_mesefile02._s.SetParameterString('pRow',WtA(pRow,'R'),pRow);
arfn_fam_mesefile02._s.SetParameterString('pDaData',WtA(pDaData,'D'));
arfn_fam_mesefile02._s.SetParameterString('pAData',WtA(pAData,'D'));
arfn_fam_mesefile02._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_fam_mesefile02._s.SetParameterString('m_bApplet','true');
arfn_fam_mesefile02._s.CallServlet('arfn_fam_mesefile02');
pRow.Copy(arfn_fam_mesefile02._s.GetCallerMemoryCursorRowVar('pRow'))
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_fam_mesefile02._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arfn_fam_mesefile02._s.errmsg;
arfn_fam_mesefile02._res=new CPMemoryCursor();
} else {
arfn_fam_mesefile02._res=arfn_fam_mesefile02._s.GetMemoryCursor();
if (Eq(arfn_fam_mesefile02._res,arfn_fam_mesefile02._s.GetCallerMemoryCursorRowVar('pRow'))) {
arfn_fam_mesefile02._res=pRow;
}
}
return arfn_fam_mesefile02._res;
}
arfn_fam_mesefile02.CtxLoad_ = function(){return []}
