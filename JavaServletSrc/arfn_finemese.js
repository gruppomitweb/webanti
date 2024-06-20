function arfn_finemese() {
var pDatIni;
var m_Caller
arfn_finemese._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDatIni=NullDate();
}
if(arfn_finemese._p.length>0)_rargs([[['pDatIni',arfn_finemese._p[0]]]],{eval:function(e){eval(e)}})
arfn_finemese._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_finemese._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_finemese._s.SetParameterString('pDatIni',WtA(pDatIni,'D'));
arfn_finemese._s.SetParameterString('m_bApplet','true');
arfn_finemese._s.CallServlet('arfn_finemese');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_finemese._s.errmsg;
}
return DateFromApplet(arfn_finemese._s.GetDate());
}
arfn_finemese.CtxLoad_ = function(){return []}
