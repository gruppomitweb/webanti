function spadministration_passwordcgo() {
var pEvent;
var w_usercode;
var w_new_password;
var m_Caller
spadministration_passwordcgo._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pEvent='';
}
if(spadministration_passwordcgo._p.length>0)_rargs([[['pEvent',spadministration_passwordcgo._p[0]]]],{eval:function(e){eval(e)}})
w_usercode=m_Caller.GetNumber('usercode','N',0,0);
w_new_password=m_Caller.GetString('w_new_password','C',0,0);
spadministration_passwordcgo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spadministration_passwordcgo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spadministration_passwordcgo._s.SetCallerStringVar('usercode',WtA(w_usercode,'N'));
spadministration_passwordcgo._s.SetCallerStringVar('w_new_password',WtA(w_new_password,'C'));
spadministration_passwordcgo._s.SetParameterString('pEvent',WtA(pEvent,'C'));
spadministration_passwordcgo._s.SetParameterString('m_bApplet','true');
spadministration_passwordcgo._s.CallServlet('spadministration_passwordcgo');
m_Caller.SetNumber('w_usercode','N',0,0,spadministration_passwordcgo._s.GetCallerDoubleVar('usercode'));
m_Caller.SetString('w_new_password','C',0,0,spadministration_passwordcgo._s.GetCallerStringVar('w_new_password'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spadministration_passwordcgo._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
spadministration_passwordcgo.CtxLoad_ = function(){return []}
