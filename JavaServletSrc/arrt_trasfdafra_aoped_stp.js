function arrt_trasfdafra_aoped_stp() {
var w_ADatOpe;
var w_DaDatOpe;
var m_Caller
arrt_trasfdafra_aoped_stp._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_ADatOpe=m_Caller.GetDate('w_ADatOpe','D',0,0);
w_DaDatOpe=m_Caller.GetDate('w_DaDatOpe','D',0,0);
arrt_trasfdafra_aoped_stp._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_trasfdafra_aoped_stp._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_trasfdafra_aoped_stp._s.SetCallerStringVar('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_trasfdafra_aoped_stp._s.SetCallerStringVar('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_trasfdafra_aoped_stp._s.SetParameterString('m_bApplet','true');
arrt_trasfdafra_aoped_stp._s.CallServlet('arrt_trasfdafra_aoped_stp');
m_Caller.SetDate('w_ADatOpe','D',0,0,DateFromApplet(arrt_trasfdafra_aoped_stp._s.GetCallerDateVar('w_ADatOpe')));
m_Caller.SetDate('w_DaDatOpe','D',0,0,DateFromApplet(arrt_trasfdafra_aoped_stp._s.GetCallerDateVar('w_DaDatOpe')));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_trasfdafra_aoped_stp._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_trasfdafra_aoped_stp.CtxLoad_ = function(){return []}
