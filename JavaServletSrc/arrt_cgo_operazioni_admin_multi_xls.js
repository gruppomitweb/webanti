function arrt_cgo_operazioni_admin_multi_xls() {
var pAgenzia;
var pTicket;
var pTipGio;
var m_Caller
arrt_cgo_operazioni_admin_multi_xls._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pAgenzia='';
pTicket='';
pTipGio='';
}
if(arrt_cgo_operazioni_admin_multi_xls._p.length>0)_rargs([[['pAgenzia',arrt_cgo_operazioni_admin_multi_xls._p[0]],['pTicket',arrt_cgo_operazioni_admin_multi_xls._p[1]],['pTipGio',arrt_cgo_operazioni_admin_multi_xls._p[2]]]],{eval:function(e){eval(e)}})
arrt_cgo_operazioni_admin_multi_xls._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_operazioni_admin_multi_xls._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_operazioni_admin_multi_xls._s.SetParameterString('pAgenzia',WtA(pAgenzia,'C'));
arrt_cgo_operazioni_admin_multi_xls._s.SetParameterString('pTicket',WtA(pTicket,'C'));
arrt_cgo_operazioni_admin_multi_xls._s.SetParameterString('pTipGio',WtA(pTipGio,'C'));
arrt_cgo_operazioni_admin_multi_xls._s.SetParameterString('m_bApplet','true');
arrt_cgo_operazioni_admin_multi_xls._s.CallServlet('arrt_cgo_operazioni_admin_multi_xls');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_operazioni_admin_multi_xls._s.errmsg;
}
}
arrt_cgo_operazioni_admin_multi_xls.CtxLoad_ = function(){return []}
