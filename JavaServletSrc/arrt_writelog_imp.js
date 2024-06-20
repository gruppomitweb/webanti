function arrt_writelog_imp() {
var pOperazione;
var pTabella;
var pChiave;
var pTesto;
var m_Caller
arrt_writelog_imp._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pOperazione='';
pTabella='';
pChiave='';
pTesto='';
}
if(arrt_writelog_imp._p.length>0)_rargs([[['pOperazione',arrt_writelog_imp._p[0]],['pTabella',arrt_writelog_imp._p[1]],['pChiave',arrt_writelog_imp._p[2]],['pTesto',arrt_writelog_imp._p[3]]]],{eval:function(e){eval(e)}})
arrt_writelog_imp._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_writelog_imp._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_writelog_imp._s.SetParameterString('pOperazione',WtA(pOperazione,'C'));
arrt_writelog_imp._s.SetParameterString('pTabella',WtA(pTabella,'C'));
arrt_writelog_imp._s.SetParameterString('pChiave',WtA(pChiave,'C'));
arrt_writelog_imp._s.SetParameterString('pTesto',WtA(pTesto,'M'));
arrt_writelog_imp._s.SetParameterString('m_bApplet','true');
arrt_writelog_imp._s.CallServlet('arrt_writelog_imp');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_writelog_imp._s.errmsg;
}
}
arrt_writelog_imp.CtxLoad_ = function(){return []}
