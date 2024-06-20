function arfn_chkconnes() {
var pCODICE;
var m_Caller
arfn_chkconnes._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCODICE='';
}
if(arfn_chkconnes._p.length>0)_rargs([[['pCODICE',arfn_chkconnes._p[0]]]],{eval:function(e){eval(e)}})
arfn_chkconnes._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_chkconnes._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_chkconnes._s.SetParameterString('pCODICE',WtA(pCODICE,'C'));
arfn_chkconnes._s.SetParameterString('m_bApplet','true');
arfn_chkconnes._s.CallServlet('arfn_chkconnes');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_chkconnes._s.errmsg;
}
return arfn_chkconnes._s.GetBoolean();
}
arfn_chkconnes.CtxLoad_ = function(){return []}
