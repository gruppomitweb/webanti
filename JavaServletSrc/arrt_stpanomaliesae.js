function arrt_stpanomaliesae() {
var w_daData;
var m_Caller
arrt_stpanomaliesae._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_daData=NullDate();
}
if(arrt_stpanomaliesae._p.length>0)_rargs([[['w_daData',arrt_stpanomaliesae._p[0]]]],{eval:function(e){eval(e)}})
arrt_stpanomaliesae._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_stpanomaliesae._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_stpanomaliesae._s.SetParameterString('w_daData',WtA(w_daData,'D'));
arrt_stpanomaliesae._s.SetParameterString('m_bApplet','true');
arrt_stpanomaliesae._s.CallServlet('arrt_stpanomaliesae');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_stpanomaliesae._s.errmsg;
}
}
arrt_stpanomaliesae.CtxLoad_ = function(){return []}
