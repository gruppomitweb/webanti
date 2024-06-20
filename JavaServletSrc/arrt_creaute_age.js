function arrt_creaute_age() {
var w_CODDIP;
var w_DESCRIZ;
var w_CODAGE;
var m_Caller
arrt_creaute_age._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_CODDIP=m_Caller.GetString('w_CODDIP','C',0,0);
w_DESCRIZ=m_Caller.GetString('w_DESCRIZ','C',0,0);
w_CODAGE=m_Caller.GetString('w_CODAGE','C',0,0);
arrt_creaute_age._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_creaute_age._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_creaute_age._s.SetCallerStringVar('w_CODDIP',WtA(w_CODDIP,'C'));
arrt_creaute_age._s.SetCallerStringVar('w_DESCRIZ',WtA(w_DESCRIZ,'C'));
arrt_creaute_age._s.SetCallerStringVar('w_CODAGE',WtA(w_CODAGE,'C'));
arrt_creaute_age._s.SetParameterString('m_bApplet','true');
arrt_creaute_age._s.CallServlet('arrt_creaute_age');
m_Caller.SetString('w_CODDIP','C',0,0,arrt_creaute_age._s.GetCallerStringVar('w_CODDIP'));
m_Caller.SetString('w_DESCRIZ','C',0,0,arrt_creaute_age._s.GetCallerStringVar('w_DESCRIZ'));
m_Caller.SetString('w_CODAGE','C',0,0,arrt_creaute_age._s.GetCallerStringVar('w_CODAGE'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_creaute_age._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_creaute_age.CtxLoad_ = function(){return []}
