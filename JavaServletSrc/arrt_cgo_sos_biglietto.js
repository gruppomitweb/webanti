function arrt_cgo_sos_biglietto() {
var m_Caller
arrt_cgo_sos_biglietto._p=_rargs(arguments,{eval:function(e){eval(e)}},null,'arrt_cgo_sos_biglietto')
function i_BlankParameters() {
}
if(arrt_cgo_sos_biglietto._p.length>0)_rargs([[['pObj',arrt_cgo_sos_biglietto._p[0]]]],{eval:function(e){eval(e)}})
arrt_cgo_sos_biglietto._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_sos_biglietto._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_sos_biglietto._s.SetParameterString('pObj',WtA(pObj,'C'));
arrt_cgo_sos_biglietto._s.SetParameterString('m_bApplet','true');
arrt_cgo_sos_biglietto._s.CallServlet('arrt_cgo_sos_biglietto');
if (Gt(arrt_cgo_sos_biglietto._p.length,0)) {
arrt_cgo_sos_biglietto._p[0].SetFromContext(arrt_cgo_sos_biglietto._s.GetCallerStringVar('pObj'));
} else {
arrt_cgo_sos_biglietto._search_par=[];
for (var i=0;i<arguments[0].length;i++) arrt_cgo_sos_biglietto._search_par[i]=arguments[0][i][0];
arguments[0][LibJavascript.Array.indexOf(arrt_cgo_sos_biglietto._search_par,'pObj')][1].SetFromContext(arrt_cgo_sos_biglietto._s.GetCallerStringVar('pObj'));
}
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_sos_biglietto._s.errmsg;
}
}
arrt_cgo_sos_biglietto.CtxLoad_ = function(){return []}
