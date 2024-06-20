function arrt_writelog() {
var pOperazione;
var pTabella;
var pChiave;
var pTesto;
var pTipo;
var m_Caller
arrt_writelog._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pOperazione='';
pTabella='';
pChiave='';
pTesto='';
pTipo='I';
}
if(arrt_writelog._p.length>0)_rargs([[['pOperazione',arrt_writelog._p[0]],['pTabella',arrt_writelog._p[1]],['pChiave',arrt_writelog._p[2]],['pTesto',arrt_writelog._p[3]],['pTipo',arrt_writelog._p[4]]]],{eval:function(e){eval(e)}})
arrt_writelog._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_writelog._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_writelog._s.SetParameterString('pOperazione',WtA(pOperazione,'C'));
arrt_writelog._s.SetParameterString('pTabella',WtA(pTabella,'C'));
arrt_writelog._s.SetParameterString('pChiave',WtA(pChiave,'C'));
arrt_writelog._s.SetParameterString('pTesto',WtA(pTesto,'M'));
arrt_writelog._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_writelog._s.SetParameterString('m_bApplet','true');
arrt_writelog._s.CallServlet('arrt_writelog');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_writelog._s.errmsg;
}
}
arrt_writelog.CtxLoad_ = function(){return []}
