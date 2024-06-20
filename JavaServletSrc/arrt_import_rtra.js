function arrt_import_rtra() {
var pTipo;
var m_Caller
arrt_import_rtra._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
}
if(arrt_import_rtra._p.length>0)_rargs([[['pTipo',arrt_import_rtra._p[0]]]],{eval:function(e){eval(e)}})
arrt_import_rtra._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_import_rtra._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_import_rtra._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_import_rtra._s.SetParameterString('m_bApplet','true');
arrt_import_rtra._s.CallServlet('arrt_import_rtra');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_import_rtra._s.errmsg;
}
}
arrt_import_rtra.CtxLoad_ = function(){return []}
