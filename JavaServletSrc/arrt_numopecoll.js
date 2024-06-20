function arrt_numopecoll() {
var pTipo;
var w_RAPPORTO;
var m_Caller
arrt_numopecoll._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
}
if(arrt_numopecoll._p.length>0)_rargs([[['pTipo',arrt_numopecoll._p[0]]]],{eval:function(e){eval(e)}})
w_RAPPORTO=m_Caller.GetString('w_RAPPORTO','C',0,0);
arrt_numopecoll._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_numopecoll._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_numopecoll._s.SetCallerStringVar('w_RAPPORTO',WtA(w_RAPPORTO,'C'));
arrt_numopecoll._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_numopecoll._s.SetParameterString('m_bApplet','true');
arrt_numopecoll._s.CallServlet('arrt_numopecoll');
m_Caller.SetString('w_RAPPORTO','C',0,0,arrt_numopecoll._s.GetCallerStringVar('w_RAPPORTO'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_numopecoll._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_numopecoll.CtxLoad_ = function(){return []}
