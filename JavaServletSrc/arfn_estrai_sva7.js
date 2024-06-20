function arfn_estrai_sva7() {
var pAnno;
var pSem;
var m_Caller
arfn_estrai_sva7._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pAnno='';
pSem='';
}
if(arfn_estrai_sva7._p.length>0)_rargs([[['pAnno',arfn_estrai_sva7._p[0]],['pSem',arfn_estrai_sva7._p[1]]]],{eval:function(e){eval(e)}})
arfn_estrai_sva7._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_estrai_sva7._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_estrai_sva7._s.SetParameterString('pAnno',WtA(pAnno,'C'));
arfn_estrai_sva7._s.SetParameterString('pSem',WtA(pSem,'C'));
arfn_estrai_sva7._s.SetParameterString('m_bApplet','true');
arfn_estrai_sva7._s.CallServlet('arfn_estrai_sva7');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_estrai_sva7._s.errmsg;
}
return arfn_estrai_sva7._s.GetString();
}
arfn_estrai_sva7.CtxLoad_ = function(){return []}
