function arrt_cgo_read_codfisc() {
var pTipo;
var m_Caller
arrt_cgo_read_codfisc._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
}
if(arrt_cgo_read_codfisc._p.length>0)_rargs([[['pObj',arrt_cgo_read_codfisc._p[0]],['pTipo',arrt_cgo_read_codfisc._p[1]]]],{eval:function(e){eval(e)}})
arrt_cgo_read_codfisc._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_read_codfisc._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_read_codfisc._s.SetParameterString('pObj',WtA(pObj,'C'));
arrt_cgo_read_codfisc._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_cgo_read_codfisc._s.SetParameterString('m_bApplet','true');
arrt_cgo_read_codfisc._s.CallServlet('arrt_cgo_read_codfisc');
if (Gt(arrt_cgo_read_codfisc._p.length,0)) {
arrt_cgo_read_codfisc._p[0].SetFromContext(arrt_cgo_read_codfisc._s.GetCallerStringVar('pObj'));
} else {
arrt_cgo_read_codfisc._search_par=[];
for (var i=0;i<arguments[0].length;i++) arrt_cgo_read_codfisc._search_par[i]=arguments[0][i][0];
arguments[0][LibJavascript.Array.indexOf(arrt_cgo_read_codfisc._search_par,'pObj')][1].SetFromContext(arrt_cgo_read_codfisc._s.GetCallerStringVar('pObj'));
}
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_read_codfisc._s.errmsg;
}
}
arrt_cgo_read_codfisc.CtxLoad_ = function(){return []}
