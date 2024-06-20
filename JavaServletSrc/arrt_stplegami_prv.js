function arrt_stplegami_prv() {
var w_daSocieta;
var w_aSocieta;
var w_DaData;
var w_AData;
var w_detana;
var m_Caller
arrt_stplegami_prv._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_daSocieta='';
w_aSocieta='';
w_DaData=NullDate();
w_AData=NullDate();
w_detana='';
}
if(arrt_stplegami_prv._p.length>0)_rargs([[['w_daSocieta',arrt_stplegami_prv._p[0]],['w_aSocieta',arrt_stplegami_prv._p[1]],['w_DaData',arrt_stplegami_prv._p[2]],['w_AData',arrt_stplegami_prv._p[3]],['w_detana',arrt_stplegami_prv._p[4]]]],{eval:function(e){eval(e)}})
arrt_stplegami_prv._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_stplegami_prv._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_stplegami_prv._s.SetParameterString('w_daSocieta',WtA(w_daSocieta,'C'));
arrt_stplegami_prv._s.SetParameterString('w_aSocieta',WtA(w_aSocieta,'C'));
arrt_stplegami_prv._s.SetParameterString('w_DaData',WtA(w_DaData,'D'));
arrt_stplegami_prv._s.SetParameterString('w_AData',WtA(w_AData,'D'));
arrt_stplegami_prv._s.SetParameterString('w_detana',WtA(w_detana,'C'));
arrt_stplegami_prv._s.SetParameterString('m_bApplet','true');
arrt_stplegami_prv._s.CallServlet('arrt_stplegami_prv');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_stplegami_prv._s.errmsg;
}
}
arrt_stplegami_prv.CtxLoad_ = function(){return []}
