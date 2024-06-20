function arrt_readerr_sid() {
var w_nomefile;
var w_anno;
var m_Caller
arrt_readerr_sid._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_nomefile=m_Caller.GetString('w_nomefile','C',0,0);
w_anno=m_Caller.GetNumber('w_anno','N',0,0);
arrt_readerr_sid._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_readerr_sid._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_readerr_sid._s.SetCallerStringVar('w_nomefile',WtA(w_nomefile,'C'));
arrt_readerr_sid._s.SetCallerStringVar('w_anno',WtA(w_anno,'N'));
arrt_readerr_sid._s.SetParameterString('m_bApplet','true');
arrt_readerr_sid._s.CallServlet('arrt_readerr_sid');
m_Caller.SetString('w_nomefile','C',0,0,arrt_readerr_sid._s.GetCallerStringVar('w_nomefile'));
m_Caller.SetNumber('w_anno','N',0,0,arrt_readerr_sid._s.GetCallerDoubleVar('w_anno'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_readerr_sid._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_readerr_sid.CtxLoad_ = function(){return []}
