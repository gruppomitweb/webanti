function arfn_tipoerrore() {
var pTipo;
var pErr;
var m_Caller
arfn_tipoerrore._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
pErr='';
}
if(arfn_tipoerrore._p.length>0)_rargs([[['pTipo',arfn_tipoerrore._p[0]],['pErr',arfn_tipoerrore._p[1]]]],{eval:function(e){eval(e)}})
arfn_tipoerrore._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_tipoerrore._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_tipoerrore._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_tipoerrore._s.SetParameterString('pErr',WtA(pErr,'C'));
arfn_tipoerrore._s.SetParameterString('m_bApplet','true');
arfn_tipoerrore._s.CallServlet('arfn_tipoerrore');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_tipoerrore._s.errmsg;
}
return arfn_tipoerrore._s.GetString();
}
arfn_tipoerrore.CtxLoad_ = function(){return []}
