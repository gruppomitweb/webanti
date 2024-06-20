function arfn_cgo_nomefile_report() {
var pID;
var pCODDIP;
var m_Caller
arfn_cgo_nomefile_report._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pID='';
pCODDIP='';
}
if(arfn_cgo_nomefile_report._p.length>0)_rargs([[['pID',arfn_cgo_nomefile_report._p[0]],['pCODDIP',arfn_cgo_nomefile_report._p[1]]]],{eval:function(e){eval(e)}})
arfn_cgo_nomefile_report._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_cgo_nomefile_report._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_cgo_nomefile_report._s.SetParameterString('pID',WtA(pID,'C'));
arfn_cgo_nomefile_report._s.SetParameterString('pCODDIP',WtA(pCODDIP,'C'));
arfn_cgo_nomefile_report._s.SetParameterString('m_bApplet','true');
arfn_cgo_nomefile_report._s.CallServlet('arfn_cgo_nomefile_report');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_cgo_nomefile_report._s.errmsg;
}
return arfn_cgo_nomefile_report._s.GetString();
}
arfn_cgo_nomefile_report.CtxLoad_ = function(){return []}
