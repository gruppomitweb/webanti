function arfn_datisog_sol_row() {
var pCli;
var pDatOpe;
var pSTATO;
var pDatRet;
var m_Caller
arfn_datisog_sol_row._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCli='';
pDatOpe=NullDate();
pSTATO='';
pDatRet=NullDate();
}
if(arfn_datisog_sol_row._p.length>0)_rargs([[['pCli',arfn_datisog_sol_row._p[0]],['pDatOpe',arfn_datisog_sol_row._p[1]],['pSTATO',arfn_datisog_sol_row._p[2]],['pDatRet',arfn_datisog_sol_row._p[3]]]],{eval:function(e){eval(e)}})
arfn_datisog_sol_row._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_datisog_sol_row._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_datisog_sol_row._s.SetParameterString('pCli',WtA(pCli,'C'));
arfn_datisog_sol_row._s.SetParameterString('pDatOpe',WtA(pDatOpe,'D'));
arfn_datisog_sol_row._s.SetParameterString('pSTATO',WtA(pSTATO,'C'));
arfn_datisog_sol_row._s.SetParameterString('pDatRet',WtA(pDatRet,'D'));
arfn_datisog_sol_row._s.SetParameterString('m_bApplet','true');
arfn_datisog_sol_row._s.CallServlet('arfn_datisog_sol_row');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_datisog_sol_row._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arfn_datisog_sol_row._s.errmsg;
arfn_datisog_sol_row._res=new CPMemoryCursor();
} else {
arfn_datisog_sol_row._res=arfn_datisog_sol_row._s.GetMemoryCursorRow();
}
return arfn_datisog_sol_row._res;
}
arfn_datisog_sol_row.CtxLoad_ = function(){return []}
