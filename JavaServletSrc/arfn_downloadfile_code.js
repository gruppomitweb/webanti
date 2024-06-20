function arfn_downloadfile_code() {
var pCodice;
var pTipo;
var m_Caller
arfn_downloadfile_code._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCodice='';
pTipo='';
}
if(arfn_downloadfile_code._p.length>0)_rargs([[['pCodice',arfn_downloadfile_code._p[0]],['pTipo',arfn_downloadfile_code._p[1]]]],{eval:function(e){eval(e)}})
arfn_downloadfile_code._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_downloadfile_code._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_downloadfile_code._s.SetParameterString('pCodice',WtA(pCodice,'C'));
arfn_downloadfile_code._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_downloadfile_code._s.SetParameterString('m_bApplet','true');
arfn_downloadfile_code._s.CallServlet('arfn_downloadfile_code');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_downloadfile_code._s.errmsg;
}
return arfn_downloadfile_code._s.GetString();
}
arfn_downloadfile_code.CtxLoad_ = function(){return []}
