function arfn_chkspers() {
var pCli;
var pOpe;
var m_Caller
arfn_chkspers._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCli='';
pOpe=NullDate();
}
if(arfn_chkspers._p.length>0)_rargs([[['pCli',arfn_chkspers._p[0]],['pOpe',arfn_chkspers._p[1]]]],{eval:function(e){eval(e)}})
arfn_chkspers._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_chkspers._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_chkspers._s.SetParameterString('pCli',WtA(pCli,'C'));
arfn_chkspers._s.SetParameterString('pOpe',WtA(pOpe,'D'));
arfn_chkspers._s.SetParameterString('m_bApplet','true');
arfn_chkspers._s.CallServlet('arfn_chkspers');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_chkspers._s.errmsg;
}
return arfn_chkspers._s.GetString();
}
arfn_chkspers.CtxLoad_ = function(){return []}
