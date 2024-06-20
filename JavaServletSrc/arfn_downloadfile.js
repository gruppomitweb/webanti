function arfn_downloadfile() {
var pFile;
var pCartella;
var pTipo;
var m_Caller
arfn_downloadfile._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pFile='';
pCartella='';
pTipo='';
}
if(arfn_downloadfile._p.length>0)_rargs([[['pFile',arfn_downloadfile._p[0]],['pCartella',arfn_downloadfile._p[1]],['pTipo',arfn_downloadfile._p[2]]]],{eval:function(e){eval(e)}})
arfn_downloadfile._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_downloadfile._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_downloadfile._s.SetParameterString('pFile',WtA(pFile,'C'));
arfn_downloadfile._s.SetParameterString('pCartella',WtA(pCartella,'C'));
arfn_downloadfile._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_downloadfile._s.SetParameterString('m_bApplet','true');
arfn_downloadfile._s.CallServlet('arfn_downloadfile');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_downloadfile._s.errmsg;
}
return arfn_downloadfile._s.GetString();
}
arfn_downloadfile.CtxLoad_ = function(){return []}
