function arrt_calcsaldi_opex() {
var w_annorif;
var w_valuta;
var w_flgazz;
var w_ndgcli;
var w_flgmopx;
var m_Caller
arrt_calcsaldi_opex._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_annorif=0;
w_valuta='';
w_flgazz='';
w_ndgcli='';
w_flgmopx='';
}
if(arrt_calcsaldi_opex._p.length>0)_rargs([[['w_annorif',arrt_calcsaldi_opex._p[0]],['w_valuta',arrt_calcsaldi_opex._p[1]],['w_flgazz',arrt_calcsaldi_opex._p[2]],['w_ndgcli',arrt_calcsaldi_opex._p[3]],['w_flgmopx',arrt_calcsaldi_opex._p[4]]]],{eval:function(e){eval(e)}})
arrt_calcsaldi_opex._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_calcsaldi_opex._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_calcsaldi_opex._s.SetParameterString('w_annorif',WtA(w_annorif,'N'));
arrt_calcsaldi_opex._s.SetParameterString('w_valuta',WtA(w_valuta,'C'));
arrt_calcsaldi_opex._s.SetParameterString('w_flgazz',WtA(w_flgazz,'C'));
arrt_calcsaldi_opex._s.SetParameterString('w_ndgcli',WtA(w_ndgcli,'C'));
arrt_calcsaldi_opex._s.SetParameterString('w_flgmopx',WtA(w_flgmopx,'C'));
arrt_calcsaldi_opex._s.SetParameterString('m_bApplet','true');
arrt_calcsaldi_opex._s.CallServlet('arrt_calcsaldi_opex');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_calcsaldi_opex._s.errmsg;
}
return arrt_calcsaldi_opex._s.GetString();
}
arrt_calcsaldi_opex.CtxLoad_ = function(){return []}
