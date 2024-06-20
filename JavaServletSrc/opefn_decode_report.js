function opefn_decode_report() {
var pTipo;
var pValore;
var m_Caller
opefn_decode_report._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
pValore='';
}
if(opefn_decode_report._p.length>0)_rargs([[['pTipo',opefn_decode_report._p[0]],['pValore',opefn_decode_report._p[1]]]],{eval:function(e){eval(e)}})
opefn_decode_report._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
opefn_decode_report._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
opefn_decode_report._s.SetParameterString('pTipo',WtA(pTipo,'C'));
opefn_decode_report._s.SetParameterString('pValore',WtA(pValore,'C'));
opefn_decode_report._s.SetParameterString('m_bApplet','true');
opefn_decode_report._s.CallServlet('opefn_decode_report');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=opefn_decode_report._s.errmsg;
}
return opefn_decode_report._s.GetString();
}
opefn_decode_report.CtxLoad_ = function(){return []}
