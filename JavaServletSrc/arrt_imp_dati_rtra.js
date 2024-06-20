function arrt_imp_dati_rtra() {
var w_tipodest;
var w_delprec;
var pAUA;
var pModo;
var pTipo;
var pErrAUI;
var pImpAna;
var pNoDG;
var m_Caller
arrt_imp_dati_rtra._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_tipodest='';
w_delprec='';
pAUA='';
pModo='';
pTipo='';
pErrAUI='';
pImpAna='';
pNoDG='';
}
if(arrt_imp_dati_rtra._p.length>0)_rargs([[['w_tipodest',arrt_imp_dati_rtra._p[0]],['w_delprec',arrt_imp_dati_rtra._p[1]],['pAUA',arrt_imp_dati_rtra._p[2]],['pModo',arrt_imp_dati_rtra._p[3]],['pTipo',arrt_imp_dati_rtra._p[4]],['pErrAUI',arrt_imp_dati_rtra._p[5]],['pImpAna',arrt_imp_dati_rtra._p[6]],['pNoDG',arrt_imp_dati_rtra._p[7]]]],{eval:function(e){eval(e)}})
arrt_imp_dati_rtra._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_imp_dati_rtra._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_imp_dati_rtra._s.SetParameterString('w_tipodest',WtA(w_tipodest,'C'));
arrt_imp_dati_rtra._s.SetParameterString('w_delprec',WtA(w_delprec,'C'));
arrt_imp_dati_rtra._s.SetParameterString('pAUA',WtA(pAUA,'C'));
arrt_imp_dati_rtra._s.SetParameterString('pModo',WtA(pModo,'C'));
arrt_imp_dati_rtra._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_imp_dati_rtra._s.SetParameterString('pErrAUI',WtA(pErrAUI,'C'));
arrt_imp_dati_rtra._s.SetParameterString('pImpAna',WtA(pImpAna,'C'));
arrt_imp_dati_rtra._s.SetParameterString('pNoDG',WtA(pNoDG,'C'));
arrt_imp_dati_rtra._s.SetParameterString('m_bApplet','true');
arrt_imp_dati_rtra._s.CallServlet('arrt_imp_dati_rtra');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_imp_dati_rtra._s.errmsg;
}
return arrt_imp_dati_rtra._s.GetString();
}
arrt_imp_dati_rtra.CtxLoad_ = function(){return []}
