function arrt_imp_dati_wubs() {
var w_tipodest;
var m_Caller
arrt_imp_dati_wubs._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_tipodest='';
}
if(arrt_imp_dati_wubs._p.length>0)_rargs([[['w_tipodest',arrt_imp_dati_wubs._p[0]]]],{eval:function(e){eval(e)}})
arrt_imp_dati_wubs._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_imp_dati_wubs._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_imp_dati_wubs._s.SetParameterString('w_tipodest',WtA(w_tipodest,'C'));
arrt_imp_dati_wubs._s.SetParameterString('m_bApplet','true');
arrt_imp_dati_wubs._s.CallServlet('arrt_imp_dati_wubs');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_imp_dati_wubs._s.errmsg;
}
return arrt_imp_dati_wubs._s.GetDouble();
}
arrt_imp_dati_wubs.CtxLoad_ = function(){return []}
