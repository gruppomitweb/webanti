function arfn_cgo_criticita() {
var pTipo;
var m_Caller
arfn_cgo_criticita._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
}
if(arfn_cgo_criticita._p.length>0)_rargs([[['pTipo',arfn_cgo_criticita._p[0]]]],{eval:function(e){eval(e)}})
arfn_cgo_criticita._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_cgo_criticita._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_cgo_criticita._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_cgo_criticita._s.SetParameterString('m_bApplet','true');
arfn_cgo_criticita._s.CallServlet('arfn_cgo_criticita');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_cgo_criticita._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arfn_cgo_criticita._s.errmsg;
arfn_cgo_criticita._res=new CPMemoryCursor();
} else {
arfn_cgo_criticita._res=arfn_cgo_criticita._s.GetMemoryCursor();
}
return arfn_cgo_criticita._res;
}
arfn_cgo_criticita.CtxLoad_ = function(){return []}
