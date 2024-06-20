function arrt_famsaldi() {
var w_anno;
var w_flginvio;
var w_flgstp;
var w_anticipo;
var m_Caller
arrt_famsaldi._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_anno='';
w_flginvio='';
w_flgstp='';
w_anticipo='';
}
if(arrt_famsaldi._p.length>0)_rargs([[['w_anno',arrt_famsaldi._p[0]],['w_flginvio',arrt_famsaldi._p[1]],['w_flgstp',arrt_famsaldi._p[2]],['w_anticipo',arrt_famsaldi._p[3]]]],{eval:function(e){eval(e)}})
arrt_famsaldi._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_famsaldi._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_famsaldi._s.SetParameterString('w_anno',WtA(w_anno,'C'));
arrt_famsaldi._s.SetParameterString('w_flginvio',WtA(w_flginvio,'C'));
arrt_famsaldi._s.SetParameterString('w_flgstp',WtA(w_flgstp,'C'));
arrt_famsaldi._s.SetParameterString('w_anticipo',WtA(w_anticipo,'C'));
arrt_famsaldi._s.SetParameterString('m_bApplet','true');
arrt_famsaldi._s.CallServlet('arrt_famsaldi');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_famsaldi._s.errmsg;
}
return arrt_famsaldi._s.GetString();
}
arrt_famsaldi.CtxLoad_ = function(){return []}
