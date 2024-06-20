function arrt_imp_offline() {
var w_nomefile;
var w_tipodest;
var w_azzera;
var w_tipoimp;
var w_flgrae;
var w_soloanag;
var m_Caller
arrt_imp_offline._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_nomefile='';
w_tipodest='';
w_azzera='';
w_tipoimp='';
w_flgrae='';
w_soloanag='';
}
if(arrt_imp_offline._p.length>0)_rargs([[['w_nomefile',arrt_imp_offline._p[0]],['w_tipodest',arrt_imp_offline._p[1]],['w_azzera',arrt_imp_offline._p[2]],['w_tipoimp',arrt_imp_offline._p[3]],['w_flgrae',arrt_imp_offline._p[4]],['w_soloanag',arrt_imp_offline._p[5]]]],{eval:function(e){eval(e)}})
arrt_imp_offline._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_imp_offline._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_imp_offline._s.SetParameterString('w_nomefile',WtA(w_nomefile,'C'));
arrt_imp_offline._s.SetParameterString('w_tipodest',WtA(w_tipodest,'C'));
arrt_imp_offline._s.SetParameterString('w_azzera',WtA(w_azzera,'C'));
arrt_imp_offline._s.SetParameterString('w_tipoimp',WtA(w_tipoimp,'C'));
arrt_imp_offline._s.SetParameterString('w_flgrae',WtA(w_flgrae,'C'));
arrt_imp_offline._s.SetParameterString('w_soloanag',WtA(w_soloanag,'C'));
arrt_imp_offline._s.SetParameterString('m_bApplet','true');
arrt_imp_offline._s.CallServlet('arrt_imp_offline');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_imp_offline._s.errmsg;
}
}
arrt_imp_offline.CtxLoad_ = function(){return []}
