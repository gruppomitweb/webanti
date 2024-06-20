function arrt_seekpep_rs_mc() {
var pTicket;
var pCodFisc;
var m_Caller
arrt_seekpep_rs_mc._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTicket='';
pCodFisc='';
}
if(arrt_seekpep_rs_mc._p.length>0)_rargs([[['pTicket',arrt_seekpep_rs_mc._p[0]],['pCodFisc',arrt_seekpep_rs_mc._p[1]]]],{eval:function(e){eval(e)}})
arrt_seekpep_rs_mc._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_seekpep_rs_mc._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_seekpep_rs_mc._s.SetParameterString('pTicket',WtA(pTicket,'C'));
arrt_seekpep_rs_mc._s.SetParameterString('pCodFisc',WtA(pCodFisc,'C'));
arrt_seekpep_rs_mc._s.SetParameterString('m_bApplet','true');
arrt_seekpep_rs_mc._s.CallServlet('arrt_seekpep_rs_mc');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_seekpep_rs_mc._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arrt_seekpep_rs_mc._s.errmsg;
arrt_seekpep_rs_mc._res=new CPMemoryCursor();
} else {
arrt_seekpep_rs_mc._res=arrt_seekpep_rs_mc._s.GetMemoryCursor();
}
return arrt_seekpep_rs_mc._res;
}
arrt_seekpep_rs_mc.CtxLoad_ = function(){return []}
