function arfn_cgo_confread_infbacheca() {
var pInfo;
var m_Caller
arfn_cgo_confread_infbacheca._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pInfo=0;
}
if(arfn_cgo_confread_infbacheca._p.length>0)_rargs([[['pInfo',arfn_cgo_confread_infbacheca._p[0]]]],{eval:function(e){eval(e)}})
arfn_cgo_confread_infbacheca._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_cgo_confread_infbacheca._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_cgo_confread_infbacheca._s.SetParameterString('pInfo',WtA(pInfo,'N'));
arfn_cgo_confread_infbacheca._s.SetParameterString('m_bApplet','true');
arfn_cgo_confread_infbacheca._s.CallServlet('arfn_cgo_confread_infbacheca');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_cgo_confread_infbacheca._s.errmsg;
}
return arfn_cgo_confread_infbacheca._s.GetString();
}
arfn_cgo_confread_infbacheca.CtxLoad_ = function(){return []}
