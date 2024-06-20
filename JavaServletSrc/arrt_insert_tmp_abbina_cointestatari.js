function arrt_insert_tmp_abbina_cointestatari() {
var w_Password;
var w_fonte;
var w_COINT;
var w_OrderBy;
var m_Caller
arrt_insert_tmp_abbina_cointestatari._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_Password=m_Caller.GetString('w_Password','C',0,0);
w_fonte=m_Caller.GetString('w_fonte','C',0,0);
w_COINT=m_Caller.GetString('w_COINT','C',0,0);
w_OrderBy=m_Caller.GetString('w_OrderBy','C',0,0);
arrt_insert_tmp_abbina_cointestatari._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_insert_tmp_abbina_cointestatari._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_insert_tmp_abbina_cointestatari._s.SetCallerStringVar('w_Password',WtA(w_Password,'C'));
arrt_insert_tmp_abbina_cointestatari._s.SetCallerStringVar('w_fonte',WtA(w_fonte,'C'));
arrt_insert_tmp_abbina_cointestatari._s.SetCallerStringVar('w_COINT',WtA(w_COINT,'C'));
arrt_insert_tmp_abbina_cointestatari._s.SetCallerStringVar('w_OrderBy',WtA(w_OrderBy,'C'));
arrt_insert_tmp_abbina_cointestatari._s.SetParameterString('m_bApplet','true');
arrt_insert_tmp_abbina_cointestatari._s.CallServlet('arrt_insert_tmp_abbina_cointestatari');
m_Caller.SetString('w_Password','C',0,0,arrt_insert_tmp_abbina_cointestatari._s.GetCallerStringVar('w_Password'));
m_Caller.SetString('w_fonte','C',0,0,arrt_insert_tmp_abbina_cointestatari._s.GetCallerStringVar('w_fonte'));
m_Caller.SetString('w_COINT','C',0,0,arrt_insert_tmp_abbina_cointestatari._s.GetCallerStringVar('w_COINT'));
m_Caller.SetString('w_OrderBy','C',0,0,arrt_insert_tmp_abbina_cointestatari._s.GetCallerStringVar('w_OrderBy'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_insert_tmp_abbina_cointestatari._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_insert_tmp_abbina_cointestatari.CtxLoad_ = function(){return []}
