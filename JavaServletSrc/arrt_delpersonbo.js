function arrt_delpersonbo() {
var w_CONNES;
var m_Caller
arrt_delpersonbo._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_CONNES='';
}
if(arrt_delpersonbo._p.length>0)_rargs([[['w_CONNES',arrt_delpersonbo._p[0]]]],{eval:function(e){eval(e)}})
arrt_delpersonbo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_delpersonbo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_delpersonbo._s.SetParameterString('w_CONNES',WtA(w_CONNES,'C'));
arrt_delpersonbo._s.SetParameterString('m_bApplet','true');
arrt_delpersonbo._s.CallServlet('arrt_delpersonbo');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_delpersonbo._s.errmsg;
}
}
arrt_delpersonbo.CtxLoad_ = function(){return []}
