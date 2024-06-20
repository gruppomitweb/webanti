function arrt_load_anarapbo() {
var cRapporto;
var m_Caller
arrt_load_anarapbo._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
cRapporto='';
}
if(arrt_load_anarapbo._p.length>0)_rargs([[['cRapporto',arrt_load_anarapbo._p[0]]]],{eval:function(e){eval(e)}})
arrt_load_anarapbo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_load_anarapbo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_load_anarapbo._s.SetParameterString('cRapporto',WtA(cRapporto,'C'));
arrt_load_anarapbo._s.SetParameterString('m_bApplet','true');
arrt_load_anarapbo._s.CallServlet('arrt_load_anarapbo');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_load_anarapbo._s.errmsg;
}
}
arrt_load_anarapbo.CtxLoad_ = function(){return []}
