function spadministration_checkmobappdir() {
var menuname;
var m_Caller
spadministration_checkmobappdir._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
menuname='';
}
if(spadministration_checkmobappdir._p.length>0)_rargs([[['menuname',spadministration_checkmobappdir._p[0]]]],{eval:function(e){eval(e)}})
spadministration_checkmobappdir._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spadministration_checkmobappdir._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spadministration_checkmobappdir._s.SetParameterString('menuname',WtA(menuname,'C'));
spadministration_checkmobappdir._s.SetParameterString('m_bApplet','true');
spadministration_checkmobappdir._s.CallServlet('spadministration_checkmobappdir');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spadministration_checkmobappdir._s.errmsg;
}
return spadministration_checkmobappdir._s.GetBoolean();
}
spadministration_checkmobappdir.CtxLoad_ = function(){return []}
