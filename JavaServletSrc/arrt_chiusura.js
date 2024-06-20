function arrt_chiusura() {
var pTipo;
var w_datchi;
var w_datreg;
var w_tipoarch;
var w_causale;
var w_macage;
var m_Caller
arrt_chiusura._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
}
if(arrt_chiusura._p.length>0)_rargs([[['pTipo',arrt_chiusura._p[0]]]],{eval:function(e){eval(e)}})
w_datchi=m_Caller.GetDate('w_datchi','D',0,0);
w_datreg=m_Caller.GetDate('w_datreg','D',0,0);
w_tipoarch=m_Caller.GetString('w_tipoarch','C',0,0);
w_causale=m_Caller.GetString('w_causale','C',0,0);
w_macage=m_Caller.GetString('w_macage','C',0,0);
arrt_chiusura._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_chiusura._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_chiusura._s.SetCallerStringVar('w_datchi',WtA(w_datchi,'D'));
arrt_chiusura._s.SetCallerStringVar('w_datreg',WtA(w_datreg,'D'));
arrt_chiusura._s.SetCallerStringVar('w_tipoarch',WtA(w_tipoarch,'C'));
arrt_chiusura._s.SetCallerStringVar('w_causale',WtA(w_causale,'C'));
arrt_chiusura._s.SetCallerStringVar('w_macage',WtA(w_macage,'C'));
arrt_chiusura._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_chiusura._s.SetParameterString('m_bApplet','true');
arrt_chiusura._s.CallServlet('arrt_chiusura');
m_Caller.SetDate('w_datchi','D',0,0,DateFromApplet(arrt_chiusura._s.GetCallerDateVar('w_datchi')));
m_Caller.SetDate('w_datreg','D',0,0,DateFromApplet(arrt_chiusura._s.GetCallerDateVar('w_datreg')));
m_Caller.SetString('w_tipoarch','C',0,0,arrt_chiusura._s.GetCallerStringVar('w_tipoarch'));
m_Caller.SetString('w_causale','C',0,0,arrt_chiusura._s.GetCallerStringVar('w_causale'));
m_Caller.SetString('w_macage','C',0,0,arrt_chiusura._s.GetCallerStringVar('w_macage'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_chiusura._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_chiusura.CtxLoad_ = function(){return []}
