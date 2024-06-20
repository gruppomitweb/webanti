function arrt_import_correzioni_sv() {
var nomefile;
var m_Caller
arrt_import_correzioni_sv._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
nomefile='';
}
if(arrt_import_correzioni_sv._p.length>0)_rargs([[['nomefile',arrt_import_correzioni_sv._p[0]]]],{eval:function(e){eval(e)}})
arrt_import_correzioni_sv._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_import_correzioni_sv._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_import_correzioni_sv._s.SetParameterString('nomefile',WtA(nomefile,'C'));
arrt_import_correzioni_sv._s.SetParameterString('m_bApplet','true');
arrt_import_correzioni_sv._s.CallServlet('arrt_import_correzioni_sv');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_import_correzioni_sv._s.errmsg;
}
}
arrt_import_correzioni_sv.CtxLoad_ = function(){return []}
