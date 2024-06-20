function arrt_fam_chksaldi() {
var w_anno;
var w_DaDatOpe;
var w_ADatOpe;
var m_Caller
arrt_fam_chksaldi._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_anno=0;
w_DaDatOpe=NullDate();
w_ADatOpe=NullDate();
}
if(arrt_fam_chksaldi._p.length>0)_rargs([[['w_anno',arrt_fam_chksaldi._p[0]],['w_DaDatOpe',arrt_fam_chksaldi._p[1]],['w_ADatOpe',arrt_fam_chksaldi._p[2]]]],{eval:function(e){eval(e)}})
arrt_fam_chksaldi._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_fam_chksaldi._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_fam_chksaldi._s.SetParameterString('w_anno',WtA(w_anno,'N'));
arrt_fam_chksaldi._s.SetParameterString('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_fam_chksaldi._s.SetParameterString('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_fam_chksaldi._s.SetParameterString('m_bApplet','true');
arrt_fam_chksaldi._s.CallServlet('arrt_fam_chksaldi');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_fam_chksaldi._s.errmsg;
}
}
arrt_fam_chksaldi.CtxLoad_ = function(){return []}
