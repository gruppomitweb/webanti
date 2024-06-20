function arrt_imp_dati_sv() {
var w_tipodest;
var w_chkaui;
var w_imperr;
var w_flgaggfam;
var w_flgimposv;
var w_creamo;
var w_norifimp;
var w_flgforzaagg;
var m_Caller
arrt_imp_dati_sv._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_tipodest='';
w_chkaui='';
w_imperr='';
w_flgaggfam='';
w_flgimposv='';
w_creamo='';
w_norifimp='';
w_flgforzaagg='';
}
if(arrt_imp_dati_sv._p.length>0)_rargs([[['w_tipodest',arrt_imp_dati_sv._p[0]],['w_chkaui',arrt_imp_dati_sv._p[1]],['w_imperr',arrt_imp_dati_sv._p[2]],['w_flgaggfam',arrt_imp_dati_sv._p[3]],['w_flgimposv',arrt_imp_dati_sv._p[4]],['w_creamo',arrt_imp_dati_sv._p[5]],['w_norifimp',arrt_imp_dati_sv._p[6]],['w_flgforzaagg',arrt_imp_dati_sv._p[7]]]],{eval:function(e){eval(e)}})
arrt_imp_dati_sv._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_imp_dati_sv._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_imp_dati_sv._s.SetParameterString('w_tipodest',WtA(w_tipodest,'C'));
arrt_imp_dati_sv._s.SetParameterString('w_chkaui',WtA(w_chkaui,'C'));
arrt_imp_dati_sv._s.SetParameterString('w_imperr',WtA(w_imperr,'C'));
arrt_imp_dati_sv._s.SetParameterString('w_flgaggfam',WtA(w_flgaggfam,'C'));
arrt_imp_dati_sv._s.SetParameterString('w_flgimposv',WtA(w_flgimposv,'C'));
arrt_imp_dati_sv._s.SetParameterString('w_creamo',WtA(w_creamo,'C'));
arrt_imp_dati_sv._s.SetParameterString('w_norifimp',WtA(w_norifimp,'C'));
arrt_imp_dati_sv._s.SetParameterString('w_flgforzaagg',WtA(w_flgforzaagg,'C'));
arrt_imp_dati_sv._s.SetParameterString('m_bApplet','true');
arrt_imp_dati_sv._s.CallServlet('arrt_imp_dati_sv');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_imp_dati_sv._s.errmsg;
}
return arrt_imp_dati_sv._s.GetDouble();
}
arrt_imp_dati_sv.CtxLoad_ = function(){return []}
