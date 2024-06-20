function arrt_tit_load_prv() {
var m_Caller
arrt_tit_load_prv._p=_rargs(arguments,{eval:function(e){eval(e)}},null,'arrt_tit_load_prv')
function i_BlankParameters() {
}
if(arrt_tit_load_prv._p.length>0)_rargs([[['pObj',arrt_tit_load_prv._p[0]]]],{eval:function(e){eval(e)}})
arrt_tit_load_prv._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_tit_load_prv._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_tit_load_prv._s.SetParameterString('pObj',WtA(pObj,'C'));
arrt_tit_load_prv._s.SetParameterString('m_bApplet','true');
arrt_tit_load_prv._s.CallServlet('arrt_tit_load_prv');
if (Gt(arrt_tit_load_prv._p.length,0)) {
arrt_tit_load_prv._p[0].SetFromContext(arrt_tit_load_prv._s.GetCallerStringVar('pObj'));
} else {
arrt_tit_load_prv._search_par=[];
for (var i=0;i<arguments[0].length;i++) arrt_tit_load_prv._search_par[i]=arguments[0][i][0];
arguments[0][LibJavascript.Array.indexOf(arrt_tit_load_prv._search_par,'pObj')][1].SetFromContext(arrt_tit_load_prv._s.GetCallerStringVar('pObj'));
}
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_tit_load_prv._s.errmsg;
}
}
arrt_tit_load_prv.CtxLoad_ = function(){return []}
