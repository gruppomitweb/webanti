function arrt_li_kperazbo() {
var m_Caller
arrt_li_kperazbo._p=_rargs(arguments,{eval:function(e){eval(e)}},null,'arrt_li_kperazbo')
function i_BlankParameters() {
}
if(arrt_li_kperazbo._p.length>0)_rargs([[['pObj',arrt_li_kperazbo._p[0]]]],{eval:function(e){eval(e)}})
arrt_li_kperazbo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_li_kperazbo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_li_kperazbo._s.SetParameterString('pObj',WtA(pObj,'C'));
arrt_li_kperazbo._s.SetParameterString('m_bApplet','true');
arrt_li_kperazbo._s.CallServlet('arrt_li_kperazbo');
if (Gt(arrt_li_kperazbo._p.length,0)) {
arrt_li_kperazbo._p[0].SetFromContext(arrt_li_kperazbo._s.GetCallerStringVar('pObj'));
} else {
arrt_li_kperazbo._search_par=[];
for (var i=0;i<arguments[0].length;i++) arrt_li_kperazbo._search_par[i]=arguments[0][i][0];
arguments[0][LibJavascript.Array.indexOf(arrt_li_kperazbo._search_par,'pObj')][1].SetFromContext(arrt_li_kperazbo._s.GetCallerStringVar('pObj'));
}
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_li_kperazbo._s.errmsg;
}
}
arrt_li_kperazbo.CtxLoad_ = function(){return []}