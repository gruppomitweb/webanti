function arfn_cgo_chkcc() {
var pULT4;
var pDatOpe;
var pMese;
var pAnno;
var pTIPO;
var pMezzo;
var m_Caller
arfn_cgo_chkcc._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pULT4='';
pDatOpe=NullDate();
pMese=0;
pAnno=0;
pTIPO=0;
pMezzo='';
}
if(arfn_cgo_chkcc._p.length>0)_rargs([[['pULT4',arfn_cgo_chkcc._p[0]],['pDatOpe',arfn_cgo_chkcc._p[1]],['pMese',arfn_cgo_chkcc._p[2]],['pAnno',arfn_cgo_chkcc._p[3]],['pTIPO',arfn_cgo_chkcc._p[4]],['pMezzo',arfn_cgo_chkcc._p[5]]]],{eval:function(e){eval(e)}})
arfn_cgo_chkcc._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_cgo_chkcc._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_cgo_chkcc._s.SetParameterString('pULT4',WtA(pULT4,'C'));
arfn_cgo_chkcc._s.SetParameterString('pDatOpe',WtA(pDatOpe,'D'));
arfn_cgo_chkcc._s.SetParameterString('pMese',WtA(pMese,'N'));
arfn_cgo_chkcc._s.SetParameterString('pAnno',WtA(pAnno,'N'));
arfn_cgo_chkcc._s.SetParameterString('pTIPO',WtA(pTIPO,'N'));
arfn_cgo_chkcc._s.SetParameterString('pMezzo',WtA(pMezzo,'C'));
arfn_cgo_chkcc._s.SetParameterString('m_bApplet','true');
arfn_cgo_chkcc._s.CallServlet('arfn_cgo_chkcc');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_cgo_chkcc._s.errmsg;
}
return arfn_cgo_chkcc._s.GetBoolean();
}
arfn_cgo_chkcc.CtxLoad_ = function(){return []}
