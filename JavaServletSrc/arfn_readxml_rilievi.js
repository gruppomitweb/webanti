function arfn_readxml_rilievi() {
var pFile;
var m_Caller
arfn_readxml_rilievi._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pFile='';
}
if(arfn_readxml_rilievi._p.length>0)_rargs([[['pFile',arfn_readxml_rilievi._p[0]]]],{eval:function(e){eval(e)}})
arfn_readxml_rilievi._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_readxml_rilievi._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_readxml_rilievi._s.SetParameterString('pFile',WtA(pFile,'C'));
arfn_readxml_rilievi._s.SetParameterString('m_bApplet','true');
arfn_readxml_rilievi._s.CallServlet('arfn_readxml_rilievi');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_readxml_rilievi._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arfn_readxml_rilievi._s.errmsg;
arfn_readxml_rilievi._res=new CPMemoryCursor();
} else {
arfn_readxml_rilievi._res=arfn_readxml_rilievi._s.GetMemoryCursor();
}
return arfn_readxml_rilievi._res;
}
arfn_readxml_rilievi.CtxLoad_ = function(){return []}
