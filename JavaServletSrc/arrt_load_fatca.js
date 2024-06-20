function arrt_load_fatca() {
var cConnes;
var m_Caller
arrt_load_fatca._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
cConnes='';
}
if(arrt_load_fatca._p.length>0)_rargs([[['cConnes',arrt_load_fatca._p[0]]]],{eval:function(e){eval(e)}})
arrt_load_fatca._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_load_fatca._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_load_fatca._s.SetParameterString('cConnes',WtA(cConnes,'C'));
arrt_load_fatca._s.SetParameterString('m_bApplet','true');
arrt_load_fatca._s.CallServlet('arrt_load_fatca');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_load_fatca._s.errmsg;
}
}
arrt_load_fatca.CtxLoad_ = function(){return []}
