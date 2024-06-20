function arrt_importwu() {
var w_rfile;
var w_nomefile;
var w_impzip;
var m_Caller
arrt_importwu._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_rfile='';
}
if(arrt_importwu._p.length>0)_rargs([[['w_rfile',arrt_importwu._p[0]]]],{eval:function(e){eval(e)}})
w_nomefile=m_Caller.GetString('w_nomefile','C',0,0);
w_impzip=m_Caller.GetNumber('w_impzip','N',0,0);
arrt_importwu._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_importwu._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_importwu._s.SetCallerStringVar('w_nomefile',WtA(w_nomefile,'C'));
arrt_importwu._s.SetCallerStringVar('w_impzip',WtA(w_impzip,'N'));
arrt_importwu._s.SetParameterString('w_rfile',WtA(w_rfile,'C'));
arrt_importwu._s.SetParameterString('m_bApplet','true');
arrt_importwu._s.CallServlet('arrt_importwu');
m_Caller.SetString('w_nomefile','C',0,0,arrt_importwu._s.GetCallerStringVar('w_nomefile'));
m_Caller.SetNumber('w_impzip','N',0,0,arrt_importwu._s.GetCallerDoubleVar('w_impzip'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_importwu._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_importwu.CtxLoad_ = function(){return []}
