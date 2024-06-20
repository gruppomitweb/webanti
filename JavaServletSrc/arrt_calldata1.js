function arrt_calldata1() {
var pTipoOpe;
var pNomePrg;
var w_IDBASE;
var w_CONNES;
var w_NUMPROG;
var m_Caller
arrt_calldata1._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipoOpe='';
pNomePrg='';
}
if(arrt_calldata1._p.length>0)_rargs([[['pTipoOpe',arrt_calldata1._p[0]],['pNomePrg',arrt_calldata1._p[1]]]],{eval:function(e){eval(e)}})
w_IDBASE=m_Caller.GetString('w_IDBASE','C',0,0);
w_CONNES=m_Caller.GetString('w_CONNES','C',0,0);
w_NUMPROG=m_Caller.GetString('w_NUMPROG','C',0,0);
arrt_calldata1._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_calldata1._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_calldata1._s.SetCallerStringVar('w_IDBASE',WtA(w_IDBASE,'C'));
arrt_calldata1._s.SetCallerStringVar('w_CONNES',WtA(w_CONNES,'C'));
arrt_calldata1._s.SetCallerStringVar('w_NUMPROG',WtA(w_NUMPROG,'C'));
arrt_calldata1._s.SetParameterString('pTipoOpe',WtA(pTipoOpe,'C'));
arrt_calldata1._s.SetParameterString('pNomePrg',WtA(pNomePrg,'C'));
arrt_calldata1._s.SetParameterString('m_bApplet','true');
arrt_calldata1._s.CallServlet('arrt_calldata1');
m_Caller.SetString('w_IDBASE','C',0,0,arrt_calldata1._s.GetCallerStringVar('w_IDBASE'));
m_Caller.SetString('w_CONNES','C',0,0,arrt_calldata1._s.GetCallerStringVar('w_CONNES'));
m_Caller.SetString('w_NUMPROG','C',0,0,arrt_calldata1._s.GetCallerStringVar('w_NUMPROG'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_calldata1._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_calldata1.CtxLoad_ = function(){return []}
