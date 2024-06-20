function arfn_forza_aua() {
var pDatIni;
var pDatFin;
var pMotivo;
var m_Caller
arfn_forza_aua._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDatIni=NullDate();
pDatFin=NullDate();
pMotivo='';
}
if(arfn_forza_aua._p.length>0)_rargs([[['pDatIni',arfn_forza_aua._p[0]],['pDatFin',arfn_forza_aua._p[1]],['pMotivo',arfn_forza_aua._p[2]]]],{eval:function(e){eval(e)}})
arfn_forza_aua._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_forza_aua._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_forza_aua._s.SetParameterString('pDatIni',WtA(pDatIni,'D'));
arfn_forza_aua._s.SetParameterString('pDatFin',WtA(pDatFin,'D'));
arfn_forza_aua._s.SetParameterString('pMotivo',WtA(pMotivo,'C'));
arfn_forza_aua._s.SetParameterString('m_bApplet','true');
arfn_forza_aua._s.CallServlet('arfn_forza_aua');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_forza_aua._s.errmsg;
}
return arfn_forza_aua._s.GetString();
}
arfn_forza_aua.CtxLoad_ = function(){return []}
