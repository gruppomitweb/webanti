function arrt_imp_dati2() {
var w_tipodest;
var w_impzip;
var w_annorif;
var w_chkaui;
var w_imperr;
var w_creamo;
var w_fscarti;
var w_flgaggfam;
var w_flgimposv;
var m_Caller
arrt_imp_dati2._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_tipodest='';
w_impzip=0;
w_annorif=0;
w_chkaui='';
w_imperr='';
w_creamo='';
w_fscarti=0;
w_flgaggfam='';
w_flgimposv='';
}
if(arrt_imp_dati2._p.length>0)_rargs([[['w_tipodest',arrt_imp_dati2._p[0]],['w_impzip',arrt_imp_dati2._p[1]],['w_annorif',arrt_imp_dati2._p[2]],['w_chkaui',arrt_imp_dati2._p[3]],['w_imperr',arrt_imp_dati2._p[4]],['w_creamo',arrt_imp_dati2._p[5]],['w_fscarti',arrt_imp_dati2._p[6]],['w_flgaggfam',arrt_imp_dati2._p[7]],['w_flgimposv',arrt_imp_dati2._p[8]]]],{eval:function(e){eval(e)}})
arrt_imp_dati2._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_imp_dati2._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_imp_dati2._s.SetParameterString('w_tipodest',WtA(w_tipodest,'C'));
arrt_imp_dati2._s.SetParameterString('w_impzip',WtA(w_impzip,'N'));
arrt_imp_dati2._s.SetParameterString('w_annorif',WtA(w_annorif,'N'));
arrt_imp_dati2._s.SetParameterString('w_chkaui',WtA(w_chkaui,'C'));
arrt_imp_dati2._s.SetParameterString('w_imperr',WtA(w_imperr,'C'));
arrt_imp_dati2._s.SetParameterString('w_creamo',WtA(w_creamo,'C'));
arrt_imp_dati2._s.SetParameterString('w_fscarti',WtA(w_fscarti,'N'));
arrt_imp_dati2._s.SetParameterString('w_flgaggfam',WtA(w_flgaggfam,'C'));
arrt_imp_dati2._s.SetParameterString('w_flgimposv',WtA(w_flgimposv,'C'));
arrt_imp_dati2._s.SetParameterString('m_bApplet','true');
arrt_imp_dati2._s.CallServlet('arrt_imp_dati2');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_imp_dati2._s.errmsg;
}
return arrt_imp_dati2._s.GetString();
}
arrt_imp_dati2.CtxLoad_ = function(){return []}
