function arrt_seekpep_rs_ver() {
var pTicket;
var pDataTic;
var m_Caller
arrt_seekpep_rs_ver._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTicket='';
pDataTic='';
}
if(arrt_seekpep_rs_ver._p.length>0)_rargs([[['pTicket',arrt_seekpep_rs_ver._p[0]],['pDataTic',arrt_seekpep_rs_ver._p[1]]]],{eval:function(e){eval(e)}})
arrt_seekpep_rs_ver._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_seekpep_rs_ver._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_seekpep_rs_ver._s.SetParameterString('pTicket',WtA(pTicket,'C'));
arrt_seekpep_rs_ver._s.SetParameterString('pDataTic',WtA(pDataTic,'C'));
arrt_seekpep_rs_ver._s.SetParameterString('m_bApplet','true');
arrt_seekpep_rs_ver._s.CallServlet('arrt_seekpep_rs_ver');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_seekpep_rs_ver._s.errmsg;
}
return arrt_seekpep_rs_ver._s.GetDouble();
}
arrt_seekpep_rs_ver.CtxLoad_ = function(){return []}
