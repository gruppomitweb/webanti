function spadministration_maxazi() {
var pCodice;
var m_Caller
spadministration_maxazi._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCodice='';
}
if(spadministration_maxazi._p.length>0)_rargs([[['pCodice',spadministration_maxazi._p[0]]]],{eval:function(e){eval(e)}})
spadministration_maxazi._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spadministration_maxazi._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spadministration_maxazi._s.SetParameterString('pCodice',WtA(pCodice,'C'));
spadministration_maxazi._s.SetParameterString('m_bApplet','true');
spadministration_maxazi._s.CallServlet('spadministration_maxazi');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spadministration_maxazi._s.errmsg;
}
}
spadministration_maxazi.CtxLoad_ = function(){return []}
