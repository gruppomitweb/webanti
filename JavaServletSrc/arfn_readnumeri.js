function arfn_readnumeri() {
var pNum;
var m_Caller
arfn_readnumeri._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pNum=0;
}
if(arfn_readnumeri._p.length>0)_rargs([[['pNum',arfn_readnumeri._p[0]]]],{eval:function(e){eval(e)}})
arfn_readnumeri._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_readnumeri._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_readnumeri._s.SetParameterString('pNum',WtA(pNum,'N'));
arfn_readnumeri._s.SetParameterString('m_bApplet','true');
arfn_readnumeri._s.CallServlet('arfn_readnumeri');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_readnumeri._s.errmsg;
}
return arfn_readnumeri._s.GetDouble();
}
arfn_readnumeri.CtxLoad_ = function(){return []}
