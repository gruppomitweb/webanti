function arrt_lanciarap() {
var pRapporto;
var m_Caller
arrt_lanciarap._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pRapporto='';
}
if(arrt_lanciarap._p.length>0)_rargs([[['pRapporto',arrt_lanciarap._p[0]]]],{eval:function(e){eval(e)}})
arrt_lanciarap._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_lanciarap._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_lanciarap._s.SetParameterString('pRapporto',WtA(pRapporto,'C'));
arrt_lanciarap._s.SetParameterString('m_bApplet','true');
arrt_lanciarap._s.CallServlet('arrt_lanciarap');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_lanciarap._s.errmsg;
}
}
arrt_lanciarap.CtxLoad_ = function(){return []}
