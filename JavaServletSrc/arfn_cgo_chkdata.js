function arfn_cgo_chkdata() {
var pData;
var pDoc;
var pTipo;
var pDatOpe;
var m_Caller
arfn_cgo_chkdata._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pData=NullDate();
pDoc='';
pTipo='';
pDatOpe=NullDate();
}
if(arfn_cgo_chkdata._p.length>0)_rargs([[['pData',arfn_cgo_chkdata._p[0]],['pDoc',arfn_cgo_chkdata._p[1]],['pTipo',arfn_cgo_chkdata._p[2]],['pDatOpe',arfn_cgo_chkdata._p[3]]]],{eval:function(e){eval(e)}})
arfn_cgo_chkdata._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_cgo_chkdata._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_cgo_chkdata._s.SetParameterString('pData',WtA(pData,'D'));
arfn_cgo_chkdata._s.SetParameterString('pDoc',WtA(pDoc,'C'));
arfn_cgo_chkdata._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_cgo_chkdata._s.SetParameterString('pDatOpe',WtA(pDatOpe,'D'));
arfn_cgo_chkdata._s.SetParameterString('m_bApplet','true');
arfn_cgo_chkdata._s.CallServlet('arfn_cgo_chkdata');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_cgo_chkdata._s.errmsg;
}
return arfn_cgo_chkdata._s.GetBoolean();
}
arfn_cgo_chkdata.CtxLoad_ = function(){return []}
