function spcheckandrunsysteminterface() {
var entity;
var m_Caller
spcheckandrunsysteminterface._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
entity='';
}
if(spcheckandrunsysteminterface._p.length>0)_rargs([[['entity',spcheckandrunsysteminterface._p[0]]]],{eval:function(e){eval(e)}})
spcheckandrunsysteminterface._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spcheckandrunsysteminterface._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spcheckandrunsysteminterface._s.SetParameterString('entity',WtA(entity,'C'));
spcheckandrunsysteminterface._s.SetParameterString('m_bApplet','true');
spcheckandrunsysteminterface._s.CallServlet('spcheckandrunsysteminterface');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spcheckandrunsysteminterface._s.errmsg;
}
}
spcheckandrunsysteminterface.CtxLoad_ = function(){return []}
