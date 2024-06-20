function arfn_cgo_tbtipgio() {
var pGioco;
var pPlat;
var m_Caller
arfn_cgo_tbtipgio._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pGioco='';
pPlat='';
}
if(arfn_cgo_tbtipgio._p.length>0)_rargs([[['pGioco',arfn_cgo_tbtipgio._p[0]],['pPlat',arfn_cgo_tbtipgio._p[1]]]],{eval:function(e){eval(e)}})
arfn_cgo_tbtipgio._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_cgo_tbtipgio._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_cgo_tbtipgio._s.SetParameterString('pGioco',WtA(pGioco,'C'));
arfn_cgo_tbtipgio._s.SetParameterString('pPlat',WtA(pPlat,'C'));
arfn_cgo_tbtipgio._s.SetParameterString('m_bApplet','true');
arfn_cgo_tbtipgio._s.CallServlet('arfn_cgo_tbtipgio');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_cgo_tbtipgio._s.errmsg;
}
return arfn_cgo_tbtipgio._s.GetString();
}
arfn_cgo_tbtipgio.CtxLoad_ = function(){return []}
