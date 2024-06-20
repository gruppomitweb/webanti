function spadministration_insertgrpgrp() {
var code;
var father;
var m_Caller
spadministration_insertgrpgrp._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
code=0;
father=0;
}
if(spadministration_insertgrpgrp._p.length>0)_rargs([[['code',spadministration_insertgrpgrp._p[0]],['father',spadministration_insertgrpgrp._p[1]]]],{eval:function(e){eval(e)}})
spadministration_insertgrpgrp._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spadministration_insertgrpgrp._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spadministration_insertgrpgrp._s.SetParameterString('code',WtA(code,'N'));
spadministration_insertgrpgrp._s.SetParameterString('father',WtA(father,'N'));
spadministration_insertgrpgrp._s.SetParameterString('m_bApplet','true');
spadministration_insertgrpgrp._s.CallServlet('spadministration_insertgrpgrp');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spadministration_insertgrpgrp._s.errmsg;
}
}
spadministration_insertgrpgrp.CtxLoad_ = function(){return []}
