function arfn_chksogg() {
var pNDG;
var pTipo;
var m_Caller
arfn_chksogg._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pNDG='';
pTipo='';
}
if(arfn_chksogg._p.length>0)_rargs([[['pNDG',arfn_chksogg._p[0]],['pTipo',arfn_chksogg._p[1]]]],{eval:function(e){eval(e)}})
arfn_chksogg._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_chksogg._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_chksogg._s.SetParameterString('pNDG',WtA(pNDG,'C'));
arfn_chksogg._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_chksogg._s.SetParameterString('m_bApplet','true');
arfn_chksogg._s.CallServlet('arfn_chksogg');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_chksogg._s.errmsg;
}
return arfn_chksogg._s.GetBoolean();
}
arfn_chksogg.CtxLoad_ = function(){return []}
