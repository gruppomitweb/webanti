function arrt_delega_noage() {
var pRapporto;
var pDelega;
var pAGE;
var m_Caller
arrt_delega_noage._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pRapporto='';
pDelega='';
pAGE='';
}
if(arrt_delega_noage._p.length>0)_rargs([[['pRapporto',arrt_delega_noage._p[0]],['pDelega',arrt_delega_noage._p[1]],['pAGE',arrt_delega_noage._p[2]]]],{eval:function(e){eval(e)}})
arrt_delega_noage._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_delega_noage._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_delega_noage._s.SetParameterString('pRapporto',WtA(pRapporto,'C'));
arrt_delega_noage._s.SetParameterString('pDelega',WtA(pDelega,'C'));
arrt_delega_noage._s.SetParameterString('pAGE',WtA(pAGE,'C'));
arrt_delega_noage._s.SetParameterString('m_bApplet','true');
arrt_delega_noage._s.CallServlet('arrt_delega_noage');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_delega_noage._s.errmsg;
}
}
arrt_delega_noage.CtxLoad_ = function(){return []}
