function arrt_import_masscf() {
var w_nomefile;
var w_flgfam;
var w_flganf;
var w_flgant;
var w_flgxls;
var w_flgexa;
var w_flgcst;
var m_Caller
arrt_import_masscf._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_nomefile='';
w_flgfam='';
w_flganf='';
w_flgant='';
w_flgxls='';
w_flgexa='';
w_flgcst='';
}
if(arrt_import_masscf._p.length>0)_rargs([[['w_nomefile',arrt_import_masscf._p[0]],['w_flgfam',arrt_import_masscf._p[1]],['w_flganf',arrt_import_masscf._p[2]],['w_flgant',arrt_import_masscf._p[3]],['w_flgxls',arrt_import_masscf._p[4]],['w_flgexa',arrt_import_masscf._p[5]],['w_flgcst',arrt_import_masscf._p[6]]]],{eval:function(e){eval(e)}})
arrt_import_masscf._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_import_masscf._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_import_masscf._s.SetParameterString('w_nomefile',WtA(w_nomefile,'C'));
arrt_import_masscf._s.SetParameterString('w_flgfam',WtA(w_flgfam,'C'));
arrt_import_masscf._s.SetParameterString('w_flganf',WtA(w_flganf,'C'));
arrt_import_masscf._s.SetParameterString('w_flgant',WtA(w_flgant,'C'));
arrt_import_masscf._s.SetParameterString('w_flgxls',WtA(w_flgxls,'C'));
arrt_import_masscf._s.SetParameterString('w_flgexa',WtA(w_flgexa,'C'));
arrt_import_masscf._s.SetParameterString('w_flgcst',WtA(w_flgcst,'C'));
arrt_import_masscf._s.SetParameterString('m_bApplet','true');
arrt_import_masscf._s.CallServlet('arrt_import_masscf');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_import_masscf._s.errmsg;
}
return arrt_import_masscf._s.GetString();
}
arrt_import_masscf.CtxLoad_ = function(){return []}
