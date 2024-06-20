function arrt_start_process() {
var pComando;
var m_Caller
arrt_start_process._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pComando='';
}
if(arrt_start_process._p.length>0)_rargs([[['pComando',arrt_start_process._p[0]]]],{eval:function(e){eval(e)}})
arrt_start_process._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_start_process._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_start_process._s.SetParameterString('pComando',WtA(pComando,'C'));
arrt_start_process._s.SetParameterString('m_bApplet','true');
arrt_start_process._s.CallServlet('arrt_start_process');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_start_process._s.errmsg;
}
}
arrt_start_process.CtxLoad_ = function(){return []}
