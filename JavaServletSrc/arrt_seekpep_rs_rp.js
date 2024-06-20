function arrt_seekpep_rs_rp() {
var pTicket;
var pCodFis;
var m_Caller
arrt_seekpep_rs_rp._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTicket='';
pCodFis='';
}
if(arrt_seekpep_rs_rp._p.length>0)_rargs([[['pTicket',arrt_seekpep_rs_rp._p[0]],['pCodFis',arrt_seekpep_rs_rp._p[1]]]],{eval:function(e){eval(e)}})
arrt_seekpep_rs_rp._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_seekpep_rs_rp._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_seekpep_rs_rp._s.SetParameterString('pTicket',WtA(pTicket,'C'));
arrt_seekpep_rs_rp._s.SetParameterString('pCodFis',WtA(pCodFis,'C'));
arrt_seekpep_rs_rp._s.SetParameterString('m_bApplet','true');
arrt_seekpep_rs_rp._s.CallServlet('arrt_seekpep_rs_rp');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_seekpep_rs_rp._s.errmsg;
}
return arrt_seekpep_rs_rp._s.GetString();
}
arrt_seekpep_rs_rp.CtxLoad_ = function(){return []}
