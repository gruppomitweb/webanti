function arfn_chk_onerow() {
var m_Caller
arfn_chk_onerow._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
}
if(arfn_chk_onerow._p.length>0)_rargs([[['pObj',arfn_chk_onerow._p[0]]]],{eval:function(e){eval(e)}})
arfn_chk_onerow._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_chk_onerow._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_chk_onerow._s.SetParameterString('pObj',WtA(pObj,'C'));
arfn_chk_onerow._s.SetParameterString('m_bApplet','true');
arfn_chk_onerow._s.CallServlet('arfn_chk_onerow');
if (Gt(arfn_chk_onerow._p.length,0)) {
arfn_chk_onerow._p[0].SetFromContext(arfn_chk_onerow._s.GetCallerStringVar('pObj'));
} else {
arfn_chk_onerow._search_par=[];
for (var i=0;i<arguments[0].length;i++) arfn_chk_onerow._search_par[i]=arguments[0][i][0];
arguments[0][LibJavascript.Array.indexOf(arfn_chk_onerow._search_par,'pObj')][1].SetFromContext(arfn_chk_onerow._s.GetCallerStringVar('pObj'));
}
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_chk_onerow._s.errmsg;
}
return arfn_chk_onerow._s.GetBoolean();
}
arfn_chk_onerow.CtxLoad_ = function(){return []}
