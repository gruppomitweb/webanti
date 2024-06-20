function arrt_cgo_apitalk() {
var CODICE;
var operazione;
var anagrafica;
var tipogestione;
var sp_company;
var m_Caller
arrt_cgo_apitalk._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
CODICE='';
operazione='';
anagrafica='';
tipogestione='';
sp_company='';
}
if(arrt_cgo_apitalk._p.length>0)_rargs([[['CODICE',arrt_cgo_apitalk._p[0]],['operazione',arrt_cgo_apitalk._p[1]],['anagrafica',arrt_cgo_apitalk._p[2]],['tipogestione',arrt_cgo_apitalk._p[3]],['sp_company',arrt_cgo_apitalk._p[4]]]],{eval:function(e){eval(e)}})
arrt_cgo_apitalk._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_apitalk._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_apitalk._s.SetParameterString('CODICE',WtA(CODICE,'C'));
arrt_cgo_apitalk._s.SetParameterString('operazione',WtA(operazione,'M'));
arrt_cgo_apitalk._s.SetParameterString('anagrafica',WtA(anagrafica,'M'));
arrt_cgo_apitalk._s.SetParameterString('tipogestione',WtA(tipogestione,'C'));
arrt_cgo_apitalk._s.SetParameterString('sp_company',WtA(sp_company,'C'));
arrt_cgo_apitalk._s.SetParameterString('m_bApplet','true');
arrt_cgo_apitalk._s.CallServlet('arrt_cgo_apitalk');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_apitalk._s.errmsg;
}
return arrt_cgo_apitalk._s.GetJSON();
}
arrt_cgo_apitalk.CtxLoad_ = function(){return []}
