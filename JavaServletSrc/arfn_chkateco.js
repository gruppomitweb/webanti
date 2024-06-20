function arfn_chkateco() {
var pSOTGRU;
var pATECO;
var m_Caller
arfn_chkateco._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pSOTGRU='';
pATECO='';
}
if(arfn_chkateco._p.length>0)_rargs([[['pSOTGRU',arfn_chkateco._p[0]],['pATECO',arfn_chkateco._p[1]]]],{eval:function(e){eval(e)}})
arfn_chkateco._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_chkateco._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_chkateco._s.SetParameterString('pSOTGRU',WtA(pSOTGRU,'C'));
arfn_chkateco._s.SetParameterString('pATECO',WtA(pATECO,'C'));
arfn_chkateco._s.SetParameterString('m_bApplet','true');
arfn_chkateco._s.CallServlet('arfn_chkateco');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_chkateco._s.errmsg;
}
return arfn_chkateco._s.GetBoolean();
}
arfn_chkateco.CtxLoad_ = function(){return []}
