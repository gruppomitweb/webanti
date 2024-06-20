function arfn_agg_fraudolente() {
var pAnno;
var pTri;
var m_Caller
arfn_agg_fraudolente._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pAnno=0;
pTri=0;
}
if(arfn_agg_fraudolente._p.length>0)_rargs([[['pAnno',arfn_agg_fraudolente._p[0]],['pTri',arfn_agg_fraudolente._p[1]]]],{eval:function(e){eval(e)}})
arfn_agg_fraudolente._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_agg_fraudolente._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_agg_fraudolente._s.SetParameterString('pAnno',WtA(pAnno,'N'));
arfn_agg_fraudolente._s.SetParameterString('pTri',WtA(pTri,'N'));
arfn_agg_fraudolente._s.SetParameterString('m_bApplet','true');
arfn_agg_fraudolente._s.CallServlet('arfn_agg_fraudolente');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_agg_fraudolente._s.errmsg;
}
return arfn_agg_fraudolente._s.GetString();
}
arfn_agg_fraudolente.CtxLoad_ = function(){return []}
