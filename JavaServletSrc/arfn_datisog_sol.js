function arfn_datisog_sol() {
var pCli;
var pDatOpe;
var pRap;
var pTRap;
var pTipoR;
var pRAE;
var pSTATO;
var pDatRet;
var m_Caller
arfn_datisog_sol._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCli='';
pDatOpe=NullDate();
pRap='';
pTRap='';
pTipoR='';
pRAE='';
pSTATO='';
pDatRet=NullDate();
}
if(arfn_datisog_sol._p.length>0)_rargs([[['pCli',arfn_datisog_sol._p[0]],['pDatOpe',arfn_datisog_sol._p[1]],['pRap',arfn_datisog_sol._p[2]],['pTRap',arfn_datisog_sol._p[3]],['pTipoR',arfn_datisog_sol._p[4]],['pRAE',arfn_datisog_sol._p[5]],['pSTATO',arfn_datisog_sol._p[6]],['pDatRet',arfn_datisog_sol._p[7]]]],{eval:function(e){eval(e)}})
arfn_datisog_sol._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_datisog_sol._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_datisog_sol._s.SetParameterString('pCli',WtA(pCli,'C'));
arfn_datisog_sol._s.SetParameterString('pDatOpe',WtA(pDatOpe,'D'));
arfn_datisog_sol._s.SetParameterString('pRap',WtA(pRap,'C'));
arfn_datisog_sol._s.SetParameterString('pTRap',WtA(pTRap,'C'));
arfn_datisog_sol._s.SetParameterString('pTipoR',WtA(pTipoR,'C'));
arfn_datisog_sol._s.SetParameterString('pRAE',WtA(pRAE,'C'));
arfn_datisog_sol._s.SetParameterString('pSTATO',WtA(pSTATO,'C'));
arfn_datisog_sol._s.SetParameterString('pDatRet',WtA(pDatRet,'D'));
arfn_datisog_sol._s.SetParameterString('m_bApplet','true');
arfn_datisog_sol._s.CallServlet('arfn_datisog_sol');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_datisog_sol._s.errmsg;
}
return arfn_datisog_sol._s.GetString();
}
arfn_datisog_sol.CtxLoad_ = function(){return []}
