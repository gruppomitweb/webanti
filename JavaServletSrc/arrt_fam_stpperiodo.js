function arrt_fam_stpperiodo() {
var w_DaDatOpe;
var w_ADatOpe;
var w_dainviare;
var w_anno;
var w_mese;
var w_flgdett;
var m_Caller
arrt_fam_stpperiodo._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_DaDatOpe=NullDate();
w_ADatOpe=NullDate();
w_dainviare=0;
w_anno=0;
w_mese='';
w_flgdett='';
}
if(arrt_fam_stpperiodo._p.length>0)_rargs([[['w_DaDatOpe',arrt_fam_stpperiodo._p[0]],['w_ADatOpe',arrt_fam_stpperiodo._p[1]],['w_dainviare',arrt_fam_stpperiodo._p[2]],['w_anno',arrt_fam_stpperiodo._p[3]],['w_mese',arrt_fam_stpperiodo._p[4]],['w_flgdett',arrt_fam_stpperiodo._p[5]]]],{eval:function(e){eval(e)}})
arrt_fam_stpperiodo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_fam_stpperiodo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_fam_stpperiodo._s.SetParameterString('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_fam_stpperiodo._s.SetParameterString('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_fam_stpperiodo._s.SetParameterString('w_dainviare',WtA(w_dainviare,'N'));
arrt_fam_stpperiodo._s.SetParameterString('w_anno',WtA(w_anno,'N'));
arrt_fam_stpperiodo._s.SetParameterString('w_mese',WtA(w_mese,'C'));
arrt_fam_stpperiodo._s.SetParameterString('w_flgdett',WtA(w_flgdett,'C'));
arrt_fam_stpperiodo._s.SetParameterString('m_bApplet','true');
arrt_fam_stpperiodo._s.CallServlet('arrt_fam_stpperiodo');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_fam_stpperiodo._s.errmsg;
}
}
arrt_fam_stpperiodo.CtxLoad_ = function(){return []}
