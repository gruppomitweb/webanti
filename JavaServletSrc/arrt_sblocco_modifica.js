function arrt_sblocco_modifica() {
var pConnes;
var w_xFLGVALIDO;
var w_xFLGANAVAL;
var m_Caller
arrt_sblocco_modifica._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pConnes='';
}
if(arrt_sblocco_modifica._p.length>0)_rargs([[['pConnes',arrt_sblocco_modifica._p[0]]]],{eval:function(e){eval(e)}})
w_xFLGVALIDO=m_Caller.GetString('w_xFLGVALIDO','C',0,0);
w_xFLGANAVAL=m_Caller.GetString('w_xFLGANAVAL','C',0,0);
arrt_sblocco_modifica._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_sblocco_modifica._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_sblocco_modifica._s.SetCallerStringVar('w_xFLGVALIDO',WtA(w_xFLGVALIDO,'C'));
arrt_sblocco_modifica._s.SetCallerStringVar('w_xFLGANAVAL',WtA(w_xFLGANAVAL,'C'));
arrt_sblocco_modifica._s.SetParameterString('pConnes',WtA(pConnes,'C'));
arrt_sblocco_modifica._s.SetParameterString('m_bApplet','true');
arrt_sblocco_modifica._s.CallServlet('arrt_sblocco_modifica');
m_Caller.SetString('w_xFLGVALIDO','C',0,0,arrt_sblocco_modifica._s.GetCallerStringVar('w_xFLGVALIDO'));
m_Caller.SetString('w_xFLGANAVAL','C',0,0,arrt_sblocco_modifica._s.GetCallerStringVar('w_xFLGANAVAL'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_sblocco_modifica._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_sblocco_modifica.CtxLoad_ = function(){return []}
