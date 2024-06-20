function arfn_chkrapporto() {
var pRapporto;
var m_Caller
arfn_chkrapporto._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pRapporto='';
}
if(arfn_chkrapporto._p.length>0)_rargs([[['pRapporto',arfn_chkrapporto._p[0]]]],{eval:function(e){eval(e)}})
arfn_chkrapporto._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_chkrapporto._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_chkrapporto._s.SetParameterString('pRapporto',WtA(pRapporto,'C'));
arfn_chkrapporto._s.SetParameterString('m_bApplet','true');
arfn_chkrapporto._s.CallServlet('arfn_chkrapporto');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_chkrapporto._s.errmsg;
}
}
arfn_chkrapporto.CtxLoad_ = function(){return []}
