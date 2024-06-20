function arfn_imp_offline() {
var w_nomefile;
var w_tipodest;
var w_azzera;
var w_soloanag;
var m_Caller
arfn_imp_offline._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_nomefile='';
w_tipodest='';
w_azzera='';
w_soloanag='';
}
if(arfn_imp_offline._p.length>0)_rargs([[['w_nomefile',arfn_imp_offline._p[0]],['w_tipodest',arfn_imp_offline._p[1]],['w_azzera',arfn_imp_offline._p[2]],['w_soloanag',arfn_imp_offline._p[3]]]],{eval:function(e){eval(e)}})
arfn_imp_offline._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_imp_offline._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_imp_offline._s.SetParameterString('w_nomefile',WtA(w_nomefile,'C'));
arfn_imp_offline._s.SetParameterString('w_tipodest',WtA(w_tipodest,'C'));
arfn_imp_offline._s.SetParameterString('w_azzera',WtA(w_azzera,'C'));
arfn_imp_offline._s.SetParameterString('w_soloanag',WtA(w_soloanag,'C'));
arfn_imp_offline._s.SetParameterString('m_bApplet','true');
arfn_imp_offline._s.CallServlet('arfn_imp_offline');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_imp_offline._s.errmsg;
}
return arfn_imp_offline._s.GetString();
}
arfn_imp_offline.CtxLoad_ = function(){return []}
