function arrt_recupera_tbrisglob() {
var m_Caller
arrt_recupera_tbrisglob._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
}
if(arrt_recupera_tbrisglob._p.length>0)_rargs([[['pObj',arrt_recupera_tbrisglob._p[0]]]],{eval:function(e){eval(e)}})
arrt_recupera_tbrisglob._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_recupera_tbrisglob._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_recupera_tbrisglob._s.SetParameterString('pObj',WtA(pObj,'C'));
arrt_recupera_tbrisglob._s.SetParameterString('m_bApplet','true');
arrt_recupera_tbrisglob._s.CallServlet('arrt_recupera_tbrisglob');
if (Gt(arrt_recupera_tbrisglob._p.length,0)) {
arrt_recupera_tbrisglob._p[0].SetFromContext(arrt_recupera_tbrisglob._s.GetCallerStringVar('pObj'));
} else {
arrt_recupera_tbrisglob._search_par=[];
for (var i=0;i<arguments[0].length;i++) arrt_recupera_tbrisglob._search_par[i]=arguments[0][i][0];
arguments[0][LibJavascript.Array.indexOf(arrt_recupera_tbrisglob._search_par,'pObj')][1].SetFromContext(arrt_recupera_tbrisglob._s.GetCallerStringVar('pObj'));
}
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_recupera_tbrisglob._s.errmsg;
}
}
arrt_recupera_tbrisglob.CtxLoad_ = function(){return []}
