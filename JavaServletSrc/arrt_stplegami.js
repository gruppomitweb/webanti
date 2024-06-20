function arrt_stplegami() {
var w_daSocieta;
var w_aSocieta;
var w_DaData;
var w_AData;
var w_attiva;
var w_cancellata;
var w_detana;
var w_mod_attiva;
var w_mod_copia;
var w_tipo;
var m_Caller
arrt_stplegami._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_daSocieta='';
w_aSocieta='';
w_DaData=NullDate();
w_AData=NullDate();
w_attiva='';
w_cancellata='';
w_detana='';
w_mod_attiva='';
w_mod_copia='';
w_tipo='';
}
if(arrt_stplegami._p.length>0)_rargs([[['w_daSocieta',arrt_stplegami._p[0]],['w_aSocieta',arrt_stplegami._p[1]],['w_DaData',arrt_stplegami._p[2]],['w_AData',arrt_stplegami._p[3]],['w_attiva',arrt_stplegami._p[4]],['w_cancellata',arrt_stplegami._p[5]],['w_detana',arrt_stplegami._p[6]],['w_mod_attiva',arrt_stplegami._p[7]],['w_mod_copia',arrt_stplegami._p[8]],['w_tipo',arrt_stplegami._p[9]]]],{eval:function(e){eval(e)}})
arrt_stplegami._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_stplegami._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_stplegami._s.SetParameterString('w_daSocieta',WtA(w_daSocieta,'C'));
arrt_stplegami._s.SetParameterString('w_aSocieta',WtA(w_aSocieta,'C'));
arrt_stplegami._s.SetParameterString('w_DaData',WtA(w_DaData,'D'));
arrt_stplegami._s.SetParameterString('w_AData',WtA(w_AData,'D'));
arrt_stplegami._s.SetParameterString('w_attiva',WtA(w_attiva,'C'));
arrt_stplegami._s.SetParameterString('w_cancellata',WtA(w_cancellata,'C'));
arrt_stplegami._s.SetParameterString('w_detana',WtA(w_detana,'C'));
arrt_stplegami._s.SetParameterString('w_mod_attiva',WtA(w_mod_attiva,'C'));
arrt_stplegami._s.SetParameterString('w_mod_copia',WtA(w_mod_copia,'C'));
arrt_stplegami._s.SetParameterString('w_tipo',WtA(w_tipo,'C'));
arrt_stplegami._s.SetParameterString('m_bApplet','true');
arrt_stplegami._s.CallServlet('arrt_stplegami');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_stplegami._s.errmsg;
}
}
arrt_stplegami.CtxLoad_ = function(){return []}
