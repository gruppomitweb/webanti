function spadministration_createmobappdir() {
var dontCheckExists;
var w_oaappmenu;
var m_Caller
spadministration_createmobappdir._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
dontCheckExists=false;
}
if(spadministration_createmobappdir._p.length>0)_rargs([[['dontCheckExists',spadministration_createmobappdir._p[0]]]],{eval:function(e){eval(e)}})
w_oaappmenu=m_Caller.GetString('w_oaappmenu','C',0,0);
spadministration_createmobappdir._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spadministration_createmobappdir._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spadministration_createmobappdir._s.SetCallerStringVar('w_oaappmenu',WtA(w_oaappmenu,'C'));
spadministration_createmobappdir._s.SetParameterString('dontCheckExists',WtA(dontCheckExists,'L'));
spadministration_createmobappdir._s.SetParameterString('m_bApplet','true');
spadministration_createmobappdir._s.CallServlet('spadministration_createmobappdir');
m_Caller.SetString('w_oaappmenu','C',0,0,spadministration_createmobappdir._s.GetCallerStringVar('w_oaappmenu'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spadministration_createmobappdir._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
spadministration_createmobappdir.CtxLoad_ = function(){return []}
