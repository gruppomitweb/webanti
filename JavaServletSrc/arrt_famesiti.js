function arrt_famesiti() {
var w_nomefile;
var w_anno;
var m_Caller
arrt_famesiti._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_nomefile='';
w_anno=0;
}
if(arrt_famesiti._p.length>0)_rargs([[['w_nomefile',arrt_famesiti._p[0]],['w_anno',arrt_famesiti._p[1]]]],{eval:function(e){eval(e)}})
arrt_famesiti._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_famesiti._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_famesiti._s.SetParameterString('w_nomefile',WtA(w_nomefile,'C'));
arrt_famesiti._s.SetParameterString('w_anno',WtA(w_anno,'N'));
arrt_famesiti._s.SetParameterString('m_bApplet','true');
arrt_famesiti._s.CallServlet('arrt_famesiti');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_famesiti._s.errmsg;
}
return arrt_famesiti._s.GetString();
}
arrt_famesiti.CtxLoad_ = function(){return []}
