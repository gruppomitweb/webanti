function arrt_casprimo() {
var w_flgnuovi;
var w_anno;
var w_mese;
var w_flgstp;
var m_Caller
arrt_casprimo._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_flgnuovi=m_Caller.GetString('w_flgnuovi','C',0,0);
w_anno=m_Caller.GetNumber('w_anno','N',0,0);
w_mese=m_Caller.GetString('w_mese','C',0,0);
w_flgstp=m_Caller.GetString('w_flgstp','C',0,0);
arrt_casprimo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_casprimo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_casprimo._s.SetCallerStringVar('w_flgnuovi',WtA(w_flgnuovi,'C'));
arrt_casprimo._s.SetCallerStringVar('w_anno',WtA(w_anno,'N'));
arrt_casprimo._s.SetCallerStringVar('w_mese',WtA(w_mese,'C'));
arrt_casprimo._s.SetCallerStringVar('w_flgstp',WtA(w_flgstp,'C'));
arrt_casprimo._s.SetParameterString('m_bApplet','true');
arrt_casprimo._s.CallServlet('arrt_casprimo');
m_Caller.SetString('w_flgnuovi','C',0,0,arrt_casprimo._s.GetCallerStringVar('w_flgnuovi'));
m_Caller.SetNumber('w_anno','N',0,0,arrt_casprimo._s.GetCallerDoubleVar('w_anno'));
m_Caller.SetString('w_mese','C',0,0,arrt_casprimo._s.GetCallerStringVar('w_mese'));
m_Caller.SetString('w_flgstp','C',0,0,arrt_casprimo._s.GetCallerStringVar('w_flgstp'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_casprimo._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_casprimo.CtxLoad_ = function(){return []}
