function arrt_stpperson() {
var w_daData;
var w_aData;
var w_daCodCli;
var w_aCodCli;
var w_tipstp;
var w_ChkSoloVar;
var w_elenco;
var w_stpatt;
var w_chktit;
var w_chknotit;
var m_Caller
arrt_stpperson._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_daData=NullDate();
w_aData=NullDate();
w_daCodCli='';
w_aCodCli='';
w_tipstp='';
w_ChkSoloVar='';
w_elenco='';
w_stpatt='';
w_chktit='';
w_chknotit='';
}
if(arrt_stpperson._p.length>0)_rargs([[['w_daData',arrt_stpperson._p[0]],['w_aData',arrt_stpperson._p[1]],['w_daCodCli',arrt_stpperson._p[2]],['w_aCodCli',arrt_stpperson._p[3]],['w_tipstp',arrt_stpperson._p[4]],['w_ChkSoloVar',arrt_stpperson._p[5]],['w_elenco',arrt_stpperson._p[6]],['w_stpatt',arrt_stpperson._p[7]],['w_chktit',arrt_stpperson._p[8]],['w_chknotit',arrt_stpperson._p[9]]]],{eval:function(e){eval(e)}})
arrt_stpperson._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_stpperson._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_stpperson._s.SetParameterString('w_daData',WtA(w_daData,'D'));
arrt_stpperson._s.SetParameterString('w_aData',WtA(w_aData,'D'));
arrt_stpperson._s.SetParameterString('w_daCodCli',WtA(w_daCodCli,'C'));
arrt_stpperson._s.SetParameterString('w_aCodCli',WtA(w_aCodCli,'C'));
arrt_stpperson._s.SetParameterString('w_tipstp',WtA(w_tipstp,'C'));
arrt_stpperson._s.SetParameterString('w_ChkSoloVar',WtA(w_ChkSoloVar,'C'));
arrt_stpperson._s.SetParameterString('w_elenco',WtA(w_elenco,'C'));
arrt_stpperson._s.SetParameterString('w_stpatt',WtA(w_stpatt,'C'));
arrt_stpperson._s.SetParameterString('w_chktit',WtA(w_chktit,'C'));
arrt_stpperson._s.SetParameterString('w_chknotit',WtA(w_chknotit,'C'));
arrt_stpperson._s.SetParameterString('m_bApplet','true');
arrt_stpperson._s.CallServlet('arrt_stpperson');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_stpperson._s.errmsg;
}
}
arrt_stpperson.CtxLoad_ = function(){return []}
