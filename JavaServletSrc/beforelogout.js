function beforelogout() {
var nEvent;
var m_Caller
beforelogout._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
nEvent=0;
}
if(beforelogout._p.length>0)_rargs([[['nEvent',beforelogout._p[0]]]],{eval:function(e){eval(e)}})
beforelogout._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
beforelogout._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
beforelogout._s.SetParameterString('nEvent',WtA(nEvent,'N'));
beforelogout._s.SetParameterString('m_bApplet','true');
beforelogout._s.CallServlet('beforelogout');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=beforelogout._s.errmsg;
}
}
beforelogout.CtxLoad_ = function(){return []}
