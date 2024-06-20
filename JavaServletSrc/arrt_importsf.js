function arrt_importsf() {
var w_rfile;
var w_nomefile;
var m_Caller
arrt_importsf._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_rfile='';
}
if(arrt_importsf._p.length>0)_rargs([[['w_rfile',arrt_importsf._p[0]]]],{eval:function(e){eval(e)}})
w_nomefile=m_Caller.GetString('w_nomefile','C',0,0);
arrt_importsf._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_importsf._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_importsf._s.SetCallerStringVar('w_nomefile',WtA(w_nomefile,'C'));
arrt_importsf._s.SetParameterString('w_rfile',WtA(w_rfile,'C'));
arrt_importsf._s.SetParameterString('m_bApplet','true');
arrt_importsf._s.CallServlet('arrt_importsf');
m_Caller.SetString('w_nomefile','C',0,0,arrt_importsf._s.GetCallerStringVar('w_nomefile'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_importsf._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_importsf.CtxLoad_ = function(){return []}
