function arrt_famextra() {
var w_a_Data;
var w_daData;
var w_tipo;
var w_flgstp;
var w_flganni;
var w_protfile;
var w_oldinter;
var w_datachiu;
var m_Caller
arrt_famextra._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_a_Data=NullDate();
w_daData=NullDate();
w_tipo='';
w_flgstp='';
w_flganni='';
w_protfile='';
w_oldinter='';
w_datachiu=NullDate();
}
if(arrt_famextra._p.length>0)_rargs([[['w_a_Data',arrt_famextra._p[0]],['w_daData',arrt_famextra._p[1]],['w_tipo',arrt_famextra._p[2]],['w_flgstp',arrt_famextra._p[3]],['w_flganni',arrt_famextra._p[4]],['w_protfile',arrt_famextra._p[5]],['w_oldinter',arrt_famextra._p[6]],['w_datachiu',arrt_famextra._p[7]]]],{eval:function(e){eval(e)}})
arrt_famextra._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_famextra._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_famextra._s.SetParameterString('w_a_Data',WtA(w_a_Data,'D'));
arrt_famextra._s.SetParameterString('w_daData',WtA(w_daData,'D'));
arrt_famextra._s.SetParameterString('w_tipo',WtA(w_tipo,'C'));
arrt_famextra._s.SetParameterString('w_flgstp',WtA(w_flgstp,'C'));
arrt_famextra._s.SetParameterString('w_flganni',WtA(w_flganni,'C'));
arrt_famextra._s.SetParameterString('w_protfile',WtA(w_protfile,'C'));
arrt_famextra._s.SetParameterString('w_oldinter',WtA(w_oldinter,'C'));
arrt_famextra._s.SetParameterString('w_datachiu',WtA(w_datachiu,'D'));
arrt_famextra._s.SetParameterString('m_bApplet','true');
arrt_famextra._s.CallServlet('arrt_famextra');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_famextra._s.errmsg;
}
}
arrt_famextra.CtxLoad_ = function(){return []}
