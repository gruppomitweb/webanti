function spadministration_check_server_usage() {
var server;
var m_Caller
spadministration_check_server_usage._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
server='';
}
if(spadministration_check_server_usage._p.length>0)_rargs([[['server',spadministration_check_server_usage._p[0]]]],{eval:function(e){eval(e)}})
spadministration_check_server_usage._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spadministration_check_server_usage._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spadministration_check_server_usage._s.SetParameterString('server',WtA(server,'C'));
spadministration_check_server_usage._s.SetParameterString('m_bApplet','true');
spadministration_check_server_usage._s.CallServlet('spadministration_check_server_usage');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spadministration_check_server_usage._s.errmsg;
}
return spadministration_check_server_usage._s.GetBoolean();
}
spadministration_check_server_usage.CtxLoad_ = function(){return []}
