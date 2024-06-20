function arrt_famprino_stp() {
var w_anno;
var w_mese;
var m_Caller
arrt_famprino_stp._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_anno=0;
w_mese='';
}
if(arrt_famprino_stp._p.length>0)_rargs([[['w_anno',arrt_famprino_stp._p[0]],['w_mese',arrt_famprino_stp._p[1]]]],{eval:function(e){eval(e)}})
arrt_famprino_stp._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_famprino_stp._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_famprino_stp._s.SetParameterString('w_anno',WtA(w_anno,'N'));
arrt_famprino_stp._s.SetParameterString('w_mese',WtA(w_mese,'C'));
arrt_famprino_stp._s.SetParameterString('m_bApplet','true');
arrt_famprino_stp._s.CallServlet('arrt_famprino_stp');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_famprino_stp._s.errmsg;
}
}
arrt_famprino_stp.CtxLoad_ = function(){return []}
