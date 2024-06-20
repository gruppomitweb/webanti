function arrt_import_rtra_errori() {
var w_tipodest;
var m_Caller
arrt_import_rtra_errori._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_tipodest='';
}
if(arrt_import_rtra_errori._p.length>0)_rargs([[['w_tipodest',arrt_import_rtra_errori._p[0]]]],{eval:function(e){eval(e)}})
arrt_import_rtra_errori._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_import_rtra_errori._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_import_rtra_errori._s.SetParameterString('w_tipodest',WtA(w_tipodest,'C'));
arrt_import_rtra_errori._s.SetParameterString('m_bApplet','true');
arrt_import_rtra_errori._s.CallServlet('arrt_import_rtra_errori');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_import_rtra_errori._s.errmsg;
}
return arrt_import_rtra_errori._s.GetString();
}
arrt_import_rtra_errori.CtxLoad_ = function(){return []}
