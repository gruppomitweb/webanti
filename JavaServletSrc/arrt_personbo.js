function arrt_personbo() {
var w_IDBASE;
var w_NEWID;
var w_CONNES;
var w_DATARETT;
var w_tipooper;
var w_datavaria;
var m_Caller
arrt_personbo._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_IDBASE=m_Caller.GetString('w_IDBASE','C',0,0);
w_NEWID=m_Caller.GetString('w_NEWID','C',0,0);
w_CONNES=m_Caller.GetString('w_CONNES','C',0,0);
w_DATARETT=m_Caller.GetDate('w_DATARETT','D',0,0);
w_tipooper=m_Caller.GetString('w_tipooper','C',0,0);
w_datavaria=m_Caller.GetDate('w_datavaria','D',0,0);
arrt_personbo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_personbo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_personbo._s.SetCallerStringVar('w_IDBASE',WtA(w_IDBASE,'C'));
arrt_personbo._s.SetCallerStringVar('w_NEWID',WtA(w_NEWID,'C'));
arrt_personbo._s.SetCallerStringVar('w_CONNES',WtA(w_CONNES,'C'));
arrt_personbo._s.SetCallerStringVar('w_DATARETT',WtA(w_DATARETT,'D'));
arrt_personbo._s.SetCallerStringVar('w_tipooper',WtA(w_tipooper,'C'));
arrt_personbo._s.SetCallerStringVar('w_datavaria',WtA(w_datavaria,'D'));
arrt_personbo._s.SetParameterString('m_bApplet','true');
arrt_personbo._s.CallServlet('arrt_personbo');
m_Caller.SetString('w_IDBASE','C',0,0,arrt_personbo._s.GetCallerStringVar('w_IDBASE'));
m_Caller.SetString('w_NEWID','C',0,0,arrt_personbo._s.GetCallerStringVar('w_NEWID'));
m_Caller.SetString('w_CONNES','C',0,0,arrt_personbo._s.GetCallerStringVar('w_CONNES'));
m_Caller.SetDate('w_DATARETT','D',0,0,DateFromApplet(arrt_personbo._s.GetCallerDateVar('w_DATARETT')));
m_Caller.SetString('w_tipooper','C',0,0,arrt_personbo._s.GetCallerStringVar('w_tipooper'));
m_Caller.SetDate('w_datavaria','D',0,0,DateFromApplet(arrt_personbo._s.GetCallerDateVar('w_datavaria')));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_personbo._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_personbo.CtxLoad_ = function(){return []}
