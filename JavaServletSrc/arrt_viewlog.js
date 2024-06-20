function arrt_viewlog() {
var pDoc;
var m_Caller
arrt_viewlog._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDoc='';
}
if(arrt_viewlog._p.length>0)_rargs([[['pDoc',arrt_viewlog._p[0]]]],{eval:function(e){eval(e)}})
arrt_viewlog._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_viewlog._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_viewlog._s.SetParameterString('pDoc',WtA(pDoc,'C'));
arrt_viewlog._s.SetParameterString('m_bApplet','true');
arrt_viewlog._s.CallServlet('arrt_viewlog');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_viewlog._s.errmsg;
}
}
arrt_viewlog.CtxLoad_ = function(){return []}
