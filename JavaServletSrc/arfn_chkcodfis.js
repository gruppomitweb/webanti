function arfn_chkcodfis() {
var pCODFIS;
var pSTATO;
var pCFE;
var m_Caller
arfn_chkcodfis._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCODFIS='';
pSTATO='';
pCFE=0;
}
if(arfn_chkcodfis._p.length>0)_rargs([[['pCODFIS',arfn_chkcodfis._p[0]],['pSTATO',arfn_chkcodfis._p[1]],['pCFE',arfn_chkcodfis._p[2]]]],{eval:function(e){eval(e)}})
arfn_chkcodfis._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_chkcodfis._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_chkcodfis._s.SetParameterString('pCODFIS',WtA(pCODFIS,'C'));
arfn_chkcodfis._s.SetParameterString('pSTATO',WtA(pSTATO,'C'));
arfn_chkcodfis._s.SetParameterString('pCFE',WtA(pCFE,'N'));
arfn_chkcodfis._s.SetParameterString('m_bApplet','true');
arfn_chkcodfis._s.CallServlet('arfn_chkcodfis');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_chkcodfis._s.errmsg;
}
return arfn_chkcodfis._s.GetBoolean();
}
arfn_chkcodfis.CtxLoad_ = function(){return []}
