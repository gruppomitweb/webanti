function arfn_cgo_nomefile_vlt() {
var pPrefSuf;
var pNomefile;
var pDataFor;
var pDataRif;
var m_Caller
arfn_cgo_nomefile_vlt._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pPrefSuf='';
pNomefile='';
pDataFor='';
pDataRif=NullDate();
}
if(arfn_cgo_nomefile_vlt._p.length>0)_rargs([[['pPrefSuf',arfn_cgo_nomefile_vlt._p[0]],['pNomefile',arfn_cgo_nomefile_vlt._p[1]],['pDataFor',arfn_cgo_nomefile_vlt._p[2]],['pDataRif',arfn_cgo_nomefile_vlt._p[3]]]],{eval:function(e){eval(e)}})
arfn_cgo_nomefile_vlt._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_cgo_nomefile_vlt._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_cgo_nomefile_vlt._s.SetParameterString('pPrefSuf',WtA(pPrefSuf,'C'));
arfn_cgo_nomefile_vlt._s.SetParameterString('pNomefile',WtA(pNomefile,'C'));
arfn_cgo_nomefile_vlt._s.SetParameterString('pDataFor',WtA(pDataFor,'C'));
arfn_cgo_nomefile_vlt._s.SetParameterString('pDataRif',WtA(pDataRif,'D'));
arfn_cgo_nomefile_vlt._s.SetParameterString('m_bApplet','true');
arfn_cgo_nomefile_vlt._s.CallServlet('arfn_cgo_nomefile_vlt');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_cgo_nomefile_vlt._s.errmsg;
}
return arfn_cgo_nomefile_vlt._s.GetString();
}
arfn_cgo_nomefile_vlt.CtxLoad_ = function(){return []}
