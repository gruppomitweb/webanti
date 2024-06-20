function maremmazucchina() {
var m_Caller
maremmazucchina._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
}
if(maremmazucchina._p.length>0)_rargs([[['pObj',maremmazucchina._p[0]]]],{eval:function(e){eval(e)}})
maremmazucchina._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
maremmazucchina._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
maremmazucchina._s.SetParameterString('pObj',WtA(pObj,'C'));
maremmazucchina._s.SetParameterString('m_bApplet','true');
maremmazucchina._s.CallServlet('maremmazucchina');
if (Gt(maremmazucchina._p.length,0)) {
maremmazucchina._p[0].SetFromContext(maremmazucchina._s.GetCallerStringVar('pObj'));
} else {
maremmazucchina._search_par=[];
for (var i=0;i<arguments[0].length;i++) maremmazucchina._search_par[i]=arguments[0][i][0];
arguments[0][LibJavascript.Array.indexOf(maremmazucchina._search_par,'pObj')][1].SetFromContext(maremmazucchina._s.GetCallerStringVar('pObj'));
}
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=maremmazucchina._s.errmsg;
}
}
maremmazucchina.CtxLoad_ = function(){return []}
