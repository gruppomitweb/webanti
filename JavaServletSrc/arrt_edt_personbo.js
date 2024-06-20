function arrt_edt_personbo() {
var w_CONNES;
var w_datavaria;
var w_TIPO;
var m_Caller
arrt_edt_personbo._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_CONNES=m_Caller.GetString('w_CONNES','C',0,0);
w_datavaria=m_Caller.GetDate('w_datavaria','D',0,0);
w_TIPO=m_Caller.GetString('w_TIPO','C',0,0);
arrt_edt_personbo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_edt_personbo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_edt_personbo._s.SetCallerStringVar('w_CONNES',WtA(w_CONNES,'C'));
arrt_edt_personbo._s.SetCallerStringVar('w_datavaria',WtA(w_datavaria,'D'));
arrt_edt_personbo._s.SetCallerStringVar('w_TIPO',WtA(w_TIPO,'C'));
arrt_edt_personbo._s.SetParameterString('m_bApplet','true');
arrt_edt_personbo._s.CallServlet('arrt_edt_personbo');
m_Caller.SetString('w_CONNES','C',0,0,arrt_edt_personbo._s.GetCallerStringVar('w_CONNES'));
m_Caller.SetDate('w_datavaria','D',0,0,DateFromApplet(arrt_edt_personbo._s.GetCallerDateVar('w_datavaria')));
m_Caller.SetString('w_TIPO','C',0,0,arrt_edt_personbo._s.GetCallerStringVar('w_TIPO'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_edt_personbo._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_edt_personbo.CtxLoad_ = function(){return []}
