function arfn_allinea_datareg_dataope() {
var DA_DATAOPE;
var A_DATAOPE;
var TBL;
var m_Caller
arfn_allinea_datareg_dataope._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
DA_DATAOPE=NullDate();
A_DATAOPE=NullDate();
TBL='';
}
if(arfn_allinea_datareg_dataope._p.length>0)_rargs([[['DA_DATAOPE',arfn_allinea_datareg_dataope._p[0]],['A_DATAOPE',arfn_allinea_datareg_dataope._p[1]],['TBL',arfn_allinea_datareg_dataope._p[2]]]],{eval:function(e){eval(e)}})
arfn_allinea_datareg_dataope._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_allinea_datareg_dataope._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_allinea_datareg_dataope._s.SetParameterString('DA_DATAOPE',WtA(DA_DATAOPE,'D'));
arfn_allinea_datareg_dataope._s.SetParameterString('A_DATAOPE',WtA(A_DATAOPE,'D'));
arfn_allinea_datareg_dataope._s.SetParameterString('TBL',WtA(TBL,'C'));
arfn_allinea_datareg_dataope._s.SetParameterString('m_bApplet','true');
arfn_allinea_datareg_dataope._s.CallServlet('arfn_allinea_datareg_dataope');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_allinea_datareg_dataope._s.errmsg;
}
return arfn_allinea_datareg_dataope._s.GetBoolean();
}
arfn_allinea_datareg_dataope.CtxLoad_ = function(){return []}
