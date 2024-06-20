function arfn_descrap() {
var pRapporto;
var m_Caller
arfn_descrap._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pRapporto='';
}
if(arfn_descrap._p.length>0)_rargs([[['pRapporto',arfn_descrap._p[0]]]],{eval:function(e){eval(e)}})
arfn_descrap._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_descrap._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_descrap._s.SetParameterString('pRapporto',WtA(pRapporto,'C'));
arfn_descrap._s.SetParameterString('m_bApplet','true');
arfn_descrap._s.CallServlet('arfn_descrap');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_descrap._s.errmsg;
}
return arfn_descrap._s.GetString();
}
arfn_descrap.CtxLoad_ = function(){return []}
