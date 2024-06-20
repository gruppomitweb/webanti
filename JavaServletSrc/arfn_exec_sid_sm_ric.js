function arfn_exec_sid_sm_ric() {
var pFile;
var m_Caller
arfn_exec_sid_sm_ric._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pFile='';
}
if(arfn_exec_sid_sm_ric._p.length>0)_rargs([[['pFile',arfn_exec_sid_sm_ric._p[0]]]],{eval:function(e){eval(e)}})
arfn_exec_sid_sm_ric._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_exec_sid_sm_ric._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_exec_sid_sm_ric._s.SetParameterString('pFile',WtA(pFile,'C'));
arfn_exec_sid_sm_ric._s.SetParameterString('m_bApplet','true');
arfn_exec_sid_sm_ric._s.CallServlet('arfn_exec_sid_sm_ric');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_exec_sid_sm_ric._s.errmsg;
}
return arfn_exec_sid_sm_ric._s.GetString();
}
arfn_exec_sid_sm_ric.CtxLoad_ = function(){return []}
