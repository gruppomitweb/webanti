function arrt_imp_dati_storico_exam() {
var w_tipodest;
var w_impzip;
var w_errchk;
var m_Caller
arrt_imp_dati_storico_exam._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_tipodest='';
w_impzip=0;
w_errchk=0;
}
if(arrt_imp_dati_storico_exam._p.length>0)_rargs([[['w_tipodest',arrt_imp_dati_storico_exam._p[0]],['w_impzip',arrt_imp_dati_storico_exam._p[1]],['w_errchk',arrt_imp_dati_storico_exam._p[2]]]],{eval:function(e){eval(e)}})
arrt_imp_dati_storico_exam._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_imp_dati_storico_exam._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_imp_dati_storico_exam._s.SetParameterString('w_tipodest',WtA(w_tipodest,'C'));
arrt_imp_dati_storico_exam._s.SetParameterString('w_impzip',WtA(w_impzip,'N'));
arrt_imp_dati_storico_exam._s.SetParameterString('w_errchk',WtA(w_errchk,'N'));
arrt_imp_dati_storico_exam._s.SetParameterString('m_bApplet','true');
arrt_imp_dati_storico_exam._s.CallServlet('arrt_imp_dati_storico_exam');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_imp_dati_storico_exam._s.errmsg;
}
return arrt_imp_dati_storico_exam._s.GetDouble();
}
arrt_imp_dati_storico_exam.CtxLoad_ = function(){return []}
