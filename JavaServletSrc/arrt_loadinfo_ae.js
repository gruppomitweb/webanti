function arrt_loadinfo_ae() {
var m_Caller
arrt_loadinfo_ae._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
}
if(arrt_loadinfo_ae._p.length>0)_rargs([[['pObj',arrt_loadinfo_ae._p[0]]]],{eval:function(e){eval(e)}})
arrt_loadinfo_ae._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_loadinfo_ae._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_loadinfo_ae._s.SetParameterString('pObj',WtA(pObj,'C'));
arrt_loadinfo_ae._s.SetParameterString('m_bApplet','true');
arrt_loadinfo_ae._s.CallServlet('arrt_loadinfo_ae');
if (Gt(arrt_loadinfo_ae._p.length,0)) {
arrt_loadinfo_ae._p[0].SetFromContext(arrt_loadinfo_ae._s.GetCallerStringVar('pObj'));
} else {
arrt_loadinfo_ae._search_par=[];
for (var i=0;i<arguments[0].length;i++) arrt_loadinfo_ae._search_par[i]=arguments[0][i][0];
arguments[0][LibJavascript.Array.indexOf(arrt_loadinfo_ae._search_par,'pObj')][1].SetFromContext(arrt_loadinfo_ae._s.GetCallerStringVar('pObj'));
}
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_loadinfo_ae._s.errmsg;
}
}
arrt_loadinfo_ae.CtxLoad_ = function(){return []}
