function arrt_fam_stpsaldi() {
var w_anno;
var w_dainviare;
var m_Caller
arrt_fam_stpsaldi._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_anno='';
w_dainviare=0;
}
if(arrt_fam_stpsaldi._p.length>0)_rargs([[['w_anno',arrt_fam_stpsaldi._p[0]],['w_dainviare',arrt_fam_stpsaldi._p[1]]]],{eval:function(e){eval(e)}})
arrt_fam_stpsaldi._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_fam_stpsaldi._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_fam_stpsaldi._s.SetParameterString('w_anno',WtA(w_anno,'C'));
arrt_fam_stpsaldi._s.SetParameterString('w_dainviare',WtA(w_dainviare,'N'));
arrt_fam_stpsaldi._s.SetParameterString('m_bApplet','true');
arrt_fam_stpsaldi._s.CallServlet('arrt_fam_stpsaldi');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_fam_stpsaldi._s.errmsg;
}
}
arrt_fam_stpsaldi.CtxLoad_ = function(){return []}
