function arrt_famesiti_elab() {
var w_nomefile;
var w_nomsg;
var m_Caller
arrt_famesiti_elab._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_nomefile='';
w_nomsg='';
}
if(arrt_famesiti_elab._p.length>0)_rargs([[['w_nomefile',arrt_famesiti_elab._p[0]],['w_nomsg',arrt_famesiti_elab._p[1]]]],{eval:function(e){eval(e)}})
arrt_famesiti_elab._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_famesiti_elab._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_famesiti_elab._s.SetParameterString('w_nomefile',WtA(w_nomefile,'C'));
arrt_famesiti_elab._s.SetParameterString('w_nomsg',WtA(w_nomsg,'C'));
arrt_famesiti_elab._s.SetParameterString('m_bApplet','true');
arrt_famesiti_elab._s.CallServlet('arrt_famesiti_elab');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_famesiti_elab._s.errmsg;
}
return arrt_famesiti_elab._s.GetString();
}
arrt_famesiti_elab.CtxLoad_ = function(){return []}
