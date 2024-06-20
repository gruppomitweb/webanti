function arrt_refresh_opextrbo() {
var m_Caller
arrt_refresh_opextrbo._p=_rargs(arguments,{eval:function(e){eval(e)}},null,'arrt_refresh_opextrbo')
function i_BlankParameters() {
}
if(arrt_refresh_opextrbo._p.length>0)_rargs([[['pObj',arrt_refresh_opextrbo._p[0]]]],{eval:function(e){eval(e)}})
arrt_refresh_opextrbo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_refresh_opextrbo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_refresh_opextrbo._s.SetParameterString('pObj',WtA(pObj,'C'));
arrt_refresh_opextrbo._s.SetParameterString('m_bApplet','true');
arrt_refresh_opextrbo._s.CallServlet('arrt_refresh_opextrbo');
if (Gt(arrt_refresh_opextrbo._p.length,0)) {
arrt_refresh_opextrbo._p[0].SetFromContext(arrt_refresh_opextrbo._s.GetCallerStringVar('pObj'));
} else {
arrt_refresh_opextrbo._search_par=[];
for (var i=0;i<arguments[0].length;i++) arrt_refresh_opextrbo._search_par[i]=arguments[0][i][0];
arguments[0][LibJavascript.Array.indexOf(arrt_refresh_opextrbo._search_par,'pObj')][1].SetFromContext(arrt_refresh_opextrbo._s.GetCallerStringVar('pObj'));
}
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_refresh_opextrbo._s.errmsg;
}
}
arrt_refresh_opextrbo.CtxLoad_ = function(){return []}
