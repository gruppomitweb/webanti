function arrt_import_sva7() {
var pFile;
var pTipo;
var m_Caller
arrt_import_sva7._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pFile='';
pTipo='';
}
if(arrt_import_sva7._p.length>0)_rargs([[['pFile',arrt_import_sva7._p[0]],['pTipo',arrt_import_sva7._p[1]]]],{eval:function(e){eval(e)}})
arrt_import_sva7._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_import_sva7._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_import_sva7._s.SetParameterString('pFile',WtA(pFile,'C'));
arrt_import_sva7._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_import_sva7._s.SetParameterString('m_bApplet','true');
arrt_import_sva7._s.CallServlet('arrt_import_sva7');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_import_sva7._s.errmsg;
}
}
arrt_import_sva7.CtxLoad_ = function(){return []}
