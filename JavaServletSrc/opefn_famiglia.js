function opefn_famiglia() {
var pStringa;
var m_Caller
opefn_famiglia._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pStringa='';
}
if(opefn_famiglia._p.length>0)_rargs([[['pStringa',opefn_famiglia._p[0]]]],{eval:function(e){eval(e)}})
opefn_famiglia._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
opefn_famiglia._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
opefn_famiglia._s.SetParameterString('pStringa',WtA(pStringa,'C'));
opefn_famiglia._s.SetParameterString('m_bApplet','true');
opefn_famiglia._s.CallServlet('opefn_famiglia');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=opefn_famiglia._s.errmsg;
}
return opefn_famiglia._s.GetString();
}
opefn_famiglia.CtxLoad_ = function(){return []}
