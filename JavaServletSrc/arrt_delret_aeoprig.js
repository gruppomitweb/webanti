function arrt_delret_aeoprig() {
var pTipo;
var w_IDBASE;
var w_CONNESINT;
var w_ADATARET;
var m_Caller
arrt_delret_aeoprig._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
}
if(arrt_delret_aeoprig._p.length>0)_rargs([[['pTipo',arrt_delret_aeoprig._p[0]]]],{eval:function(e){eval(e)}})
w_IDBASE=m_Caller.GetString('w_IDBASE','C',0,0);
w_CONNESINT=m_Caller.GetString('w_CONNESINT','C',0,0);
w_ADATARET=m_Caller.GetDate('w_ADATARET','D',0,0);
arrt_delret_aeoprig._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_delret_aeoprig._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_delret_aeoprig._s.SetCallerStringVar('w_IDBASE',WtA(w_IDBASE,'C'));
arrt_delret_aeoprig._s.SetCallerStringVar('w_CONNESINT',WtA(w_CONNESINT,'C'));
arrt_delret_aeoprig._s.SetCallerStringVar('w_ADATARET',WtA(w_ADATARET,'D'));
arrt_delret_aeoprig._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_delret_aeoprig._s.SetParameterString('m_bApplet','true');
arrt_delret_aeoprig._s.CallServlet('arrt_delret_aeoprig');
m_Caller.SetString('w_IDBASE','C',0,0,arrt_delret_aeoprig._s.GetCallerStringVar('w_IDBASE'));
m_Caller.SetString('w_CONNESINT','C',0,0,arrt_delret_aeoprig._s.GetCallerStringVar('w_CONNESINT'));
m_Caller.SetDate('w_ADATARET','D',0,0,DateFromApplet(arrt_delret_aeoprig._s.GetCallerDateVar('w_ADATARET')));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_delret_aeoprig._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_delret_aeoprig.CtxLoad_ = function(){return []}
