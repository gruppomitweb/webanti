function arrt_edt_rapotit() {
var w_IDBASE;
var w_datavaria;
var m_Caller
arrt_edt_rapotit._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_IDBASE=m_Caller.GetString('w_IDBASE','C',0,0);
w_datavaria=m_Caller.GetDate('w_datavaria','D',0,0);
arrt_edt_rapotit._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_edt_rapotit._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_edt_rapotit._s.SetCallerStringVar('w_IDBASE',WtA(w_IDBASE,'C'));
arrt_edt_rapotit._s.SetCallerStringVar('w_datavaria',WtA(w_datavaria,'D'));
arrt_edt_rapotit._s.SetParameterString('m_bApplet','true');
arrt_edt_rapotit._s.CallServlet('arrt_edt_rapotit');
m_Caller.SetString('w_IDBASE','C',0,0,arrt_edt_rapotit._s.GetCallerStringVar('w_IDBASE'));
m_Caller.SetDate('w_datavaria','D',0,0,DateFromApplet(arrt_edt_rapotit._s.GetCallerDateVar('w_datavaria')));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_edt_rapotit._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_edt_rapotit.CtxLoad_ = function(){return []}
