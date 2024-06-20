function arrt_intestit_iud() {
var pTipo;
var w_CONNESCLI;
var w_CONNESOPER;
var w_DATAOPE;
var w_TIPOLEG;
var w_TIPOOPRAP;
var w_NUMPROG;
var m_Caller
arrt_intestit_iud._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
}
if(arrt_intestit_iud._p.length>0)_rargs([[['pTipo',arrt_intestit_iud._p[0]]]],{eval:function(e){eval(e)}})
w_CONNESCLI=m_Caller.GetString('w_CONNESCLI','C',0,0);
w_CONNESOPER=m_Caller.GetString('w_CONNESOPER','C',0,0);
w_DATAOPE=m_Caller.GetDate('w_DATAOPE','D',0,0);
w_TIPOLEG=m_Caller.GetString('w_TIPOLEG','C',0,0);
w_TIPOOPRAP=m_Caller.GetString('w_TIPOOPRAP','C',0,0);
w_NUMPROG=m_Caller.GetString('w_NUMPROG','C',0,0);
arrt_intestit_iud._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_intestit_iud._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_intestit_iud._s.SetCallerStringVar('w_CONNESCLI',WtA(w_CONNESCLI,'C'));
arrt_intestit_iud._s.SetCallerStringVar('w_CONNESOPER',WtA(w_CONNESOPER,'C'));
arrt_intestit_iud._s.SetCallerStringVar('w_DATAOPE',WtA(w_DATAOPE,'D'));
arrt_intestit_iud._s.SetCallerStringVar('w_TIPOLEG',WtA(w_TIPOLEG,'C'));
arrt_intestit_iud._s.SetCallerStringVar('w_TIPOOPRAP',WtA(w_TIPOOPRAP,'C'));
arrt_intestit_iud._s.SetCallerStringVar('w_NUMPROG',WtA(w_NUMPROG,'C'));
arrt_intestit_iud._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_intestit_iud._s.SetParameterString('m_bApplet','true');
arrt_intestit_iud._s.CallServlet('arrt_intestit_iud');
m_Caller.SetString('w_CONNESCLI','C',0,0,arrt_intestit_iud._s.GetCallerStringVar('w_CONNESCLI'));
m_Caller.SetString('w_CONNESOPER','C',0,0,arrt_intestit_iud._s.GetCallerStringVar('w_CONNESOPER'));
m_Caller.SetDate('w_DATAOPE','D',0,0,DateFromApplet(arrt_intestit_iud._s.GetCallerDateVar('w_DATAOPE')));
m_Caller.SetString('w_TIPOLEG','C',0,0,arrt_intestit_iud._s.GetCallerStringVar('w_TIPOLEG'));
m_Caller.SetString('w_TIPOOPRAP','C',0,0,arrt_intestit_iud._s.GetCallerStringVar('w_TIPOOPRAP'));
m_Caller.SetString('w_NUMPROG','C',0,0,arrt_intestit_iud._s.GetCallerStringVar('w_NUMPROG'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_intestit_iud._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_intestit_iud.CtxLoad_ = function(){return []}
