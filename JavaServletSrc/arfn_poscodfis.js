function arfn_poscodfis() {
var pCODFIS;
var m_Caller
arfn_poscodfis._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCODFIS='';
}
if(arfn_poscodfis._p.length>0)_rargs([[['pCODFIS',arfn_poscodfis._p[0]]]],{eval:function(e){eval(e)}})
arfn_poscodfis._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_poscodfis._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_poscodfis._s.SetParameterString('pCODFIS',WtA(pCODFIS,'C'));
arfn_poscodfis._s.SetParameterString('m_bApplet','true');
arfn_poscodfis._s.CallServlet('arfn_poscodfis');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_poscodfis._s.errmsg;
}
return arfn_poscodfis._s.GetBoolean();
}
arfn_poscodfis.CtxLoad_ = function(){return []}
