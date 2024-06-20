function arrt_downloadxlsx() {
var pFile;
var pCartella;
var m_Caller
arrt_downloadxlsx._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pFile='';
pCartella='';
}
if(arrt_downloadxlsx._p.length>0)_rargs([[['pFile',arrt_downloadxlsx._p[0]],['pCartella',arrt_downloadxlsx._p[1]]]],{eval:function(e){eval(e)}})
arrt_downloadxlsx._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_downloadxlsx._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_downloadxlsx._s.SetParameterString('pFile',WtA(pFile,'C'));
arrt_downloadxlsx._s.SetParameterString('pCartella',WtA(pCartella,'C'));
arrt_downloadxlsx._s.SetParameterString('m_bApplet','true');
arrt_downloadxlsx._s.CallServlet('arrt_downloadxlsx');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_downloadxlsx._s.errmsg;
}
}
arrt_downloadxlsx.CtxLoad_ = function(){return []}
