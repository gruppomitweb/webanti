function arrt_check_opex() {
var w_DaDatOpe;
var w_ADatOpe;
var w_anno;
var m_Caller
arrt_check_opex._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_DaDatOpe=m_Caller.GetDate('w_DaDatOpe','D',0,0);
w_ADatOpe=m_Caller.GetDate('w_ADatOpe','D',0,0);
w_anno=m_Caller.GetNumber('w_anno','N',0,0);
arrt_check_opex._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_check_opex._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_check_opex._s.SetCallerStringVar('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_check_opex._s.SetCallerStringVar('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_check_opex._s.SetCallerStringVar('w_anno',WtA(w_anno,'N'));
arrt_check_opex._s.SetParameterString('m_bApplet','true');
arrt_check_opex._s.CallServlet('arrt_check_opex');
m_Caller.SetDate('w_DaDatOpe','D',0,0,DateFromApplet(arrt_check_opex._s.GetCallerDateVar('w_DaDatOpe')));
m_Caller.SetDate('w_ADatOpe','D',0,0,DateFromApplet(arrt_check_opex._s.GetCallerDateVar('w_ADatOpe')));
m_Caller.SetNumber('w_anno','N',0,0,arrt_check_opex._s.GetCallerDoubleVar('w_anno'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_check_opex._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_check_opex.CtxLoad_ = function(){return []}
