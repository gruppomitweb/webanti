function arrt_opex_massa() {
var w_flgoef;
var w_flgoag;
var w_flgdel;
var m_Caller
arrt_opex_massa._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_flgoef=m_Caller.GetString('w_flgoef','C',0,0);
w_flgoag=m_Caller.GetString('w_flgoag','C',0,0);
w_flgdel=m_Caller.GetString('w_flgdel','C',0,0);
arrt_opex_massa._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_opex_massa._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_opex_massa._s.SetCallerStringVar('w_flgoef',WtA(w_flgoef,'C'));
arrt_opex_massa._s.SetCallerStringVar('w_flgoag',WtA(w_flgoag,'C'));
arrt_opex_massa._s.SetCallerStringVar('w_flgdel',WtA(w_flgdel,'C'));
arrt_opex_massa._s.SetParameterString('m_bApplet','true');
arrt_opex_massa._s.CallServlet('arrt_opex_massa');
m_Caller.SetString('w_flgoef','C',0,0,arrt_opex_massa._s.GetCallerStringVar('w_flgoef'));
m_Caller.SetString('w_flgoag','C',0,0,arrt_opex_massa._s.GetCallerStringVar('w_flgoag'));
m_Caller.SetString('w_flgdel','C',0,0,arrt_opex_massa._s.GetCallerStringVar('w_flgdel'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_opex_massa._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_opex_massa.CtxLoad_ = function(){return []}
