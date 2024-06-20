function arfn_chkdatreg() {
var pDatOpe;
var pDatReg;
var pTipCon;
var pStato;
var m_Caller
arfn_chkdatreg._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDatOpe=NullDate();
pDatReg=NullDate();
pTipCon='';
pStato='';
}
if(arfn_chkdatreg._p.length>0)_rargs([[['pDatOpe',arfn_chkdatreg._p[0]],['pDatReg',arfn_chkdatreg._p[1]],['pTipCon',arfn_chkdatreg._p[2]],['pStato',arfn_chkdatreg._p[3]]]],{eval:function(e){eval(e)}})
arfn_chkdatreg._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_chkdatreg._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_chkdatreg._s.SetParameterString('pDatOpe',WtA(pDatOpe,'D'));
arfn_chkdatreg._s.SetParameterString('pDatReg',WtA(pDatReg,'D'));
arfn_chkdatreg._s.SetParameterString('pTipCon',WtA(pTipCon,'C'));
arfn_chkdatreg._s.SetParameterString('pStato',WtA(pStato,'C'));
arfn_chkdatreg._s.SetParameterString('m_bApplet','true');
arfn_chkdatreg._s.CallServlet('arfn_chkdatreg');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_chkdatreg._s.errmsg;
}
return arfn_chkdatreg._s.GetBoolean();
}
arfn_chkdatreg.CtxLoad_ = function(){return []}
