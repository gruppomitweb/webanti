function arrt_ricrea51() {
var w_DataReg;
var m_Caller
arrt_ricrea51._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_DataReg=m_Caller.GetDate('w_DataReg','D',0,0);
arrt_ricrea51._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_ricrea51._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_ricrea51._s.SetCallerStringVar('w_DataReg',WtA(w_DataReg,'D'));
arrt_ricrea51._s.SetParameterString('m_bApplet','true');
arrt_ricrea51._s.CallServlet('arrt_ricrea51');
m_Caller.SetDate('w_DataReg','D',0,0,DateFromApplet(arrt_ricrea51._s.GetCallerDateVar('w_DataReg')));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_ricrea51._s.errmsg;
}
CalledBatchEnd();
}
arrt_ricrea51.CtxLoad_ = function(){return []}
