function arrt_cgo_qadv_mail() {
var pSNAINUMOPE;
var pTIPOGIOCO;
var pORIGINE;
var m_Caller
arrt_cgo_qadv_mail._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pSNAINUMOPE='';
pTIPOGIOCO='';
pORIGINE='';
}
if(arrt_cgo_qadv_mail._p.length>0)_rargs([[['pSNAINUMOPE',arrt_cgo_qadv_mail._p[0]],['pTIPOGIOCO',arrt_cgo_qadv_mail._p[1]],['pORIGINE',arrt_cgo_qadv_mail._p[2]]]],{eval:function(e){eval(e)}})
arrt_cgo_qadv_mail._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_qadv_mail._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_qadv_mail._s.SetParameterString('pSNAINUMOPE',WtA(pSNAINUMOPE,'C'));
arrt_cgo_qadv_mail._s.SetParameterString('pTIPOGIOCO',WtA(pTIPOGIOCO,'C'));
arrt_cgo_qadv_mail._s.SetParameterString('pORIGINE',WtA(pORIGINE,'C'));
arrt_cgo_qadv_mail._s.SetParameterString('m_bApplet','true');
arrt_cgo_qadv_mail._s.CallServlet('arrt_cgo_qadv_mail');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_qadv_mail._s.errmsg;
}
}
arrt_cgo_qadv_mail.CtxLoad_ = function(){return []}
