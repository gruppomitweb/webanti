function arrt_seldes_trasfope() {
var pTipo;
var m_Caller
arrt_seldes_trasfope._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
}
if(arrt_seldes_trasfope._p.length>0)_rargs([[['pTipo',arrt_seldes_trasfope._p[0]]]],{eval:function(e){eval(e)}})
arrt_seldes_trasfope._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_seldes_trasfope._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_seldes_trasfope._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_seldes_trasfope._s.SetParameterString('m_bApplet','true');
arrt_seldes_trasfope._s.CallServlet('arrt_seldes_trasfope');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_seldes_trasfope._s.errmsg;
}
}
arrt_seldes_trasfope.CtxLoad_ = function(){return []}
