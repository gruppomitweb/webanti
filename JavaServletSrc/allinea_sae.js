function allinea_sae() {
var pDatIni;
var pDatFin;
var m_Caller
allinea_sae._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDatIni=NullDate();
pDatFin=NullDate();
}
if(allinea_sae._p.length>0)_rargs([[['pDatIni',allinea_sae._p[0]],['pDatFin',allinea_sae._p[1]]]],{eval:function(e){eval(e)}})
allinea_sae._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
allinea_sae._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
allinea_sae._s.SetParameterString('pDatIni',WtA(pDatIni,'D'));
allinea_sae._s.SetParameterString('pDatFin',WtA(pDatFin,'D'));
allinea_sae._s.SetParameterString('m_bApplet','true');
allinea_sae._s.CallServlet('allinea_sae');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=allinea_sae._s.errmsg;
}
return allinea_sae._s.GetString();
}
allinea_sae.CtxLoad_ = function(){return []}
