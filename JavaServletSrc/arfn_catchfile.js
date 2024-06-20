function arfn_catchfile() {
var pID;
var pFile;
var pTipo;
var pCodDip;
var m_Caller
arfn_catchfile._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pID='';
pFile='';
pTipo='';
pCodDip='';
}
if(arfn_catchfile._p.length>0)_rargs([[['pID',arfn_catchfile._p[0]],['pFile',arfn_catchfile._p[1]],['pTipo',arfn_catchfile._p[2]],['pCodDip',arfn_catchfile._p[3]]]],{eval:function(e){eval(e)}})
arfn_catchfile._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_catchfile._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_catchfile._s.SetParameterString('pID',WtA(pID,'C'));
arfn_catchfile._s.SetParameterString('pFile',WtA(pFile,'C'));
arfn_catchfile._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_catchfile._s.SetParameterString('pCodDip',WtA(pCodDip,'C'));
arfn_catchfile._s.SetParameterString('m_bApplet','true');
arfn_catchfile._s.CallServlet('arfn_catchfile');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_catchfile._s.errmsg;
}
return arfn_catchfile._s.GetString();
}
arfn_catchfile.CtxLoad_ = function(){return []}
