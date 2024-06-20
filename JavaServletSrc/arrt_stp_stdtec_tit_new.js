function arrt_stp_stdtec_tit_new() {
var pAUI;
var pPDF;
var w_DaDatOpe;
var w_ADatOpe;
var w_DaDatReg;
var w_ADatReg;
var w_daCodCli;
var w_aCodCli;
var w_daCodDip;
var w_aCodDip;
var m_Caller
arrt_stp_stdtec_tit_new._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pAUI='';
pPDF='';
w_DaDatOpe=NullDate();
w_ADatOpe=NullDate();
w_DaDatReg=NullDate();
w_ADatReg=NullDate();
w_daCodCli='';
w_aCodCli='';
w_daCodDip='';
w_aCodDip='';
}
if(arrt_stp_stdtec_tit_new._p.length>0)_rargs([[['pAUI',arrt_stp_stdtec_tit_new._p[0]],['pPDF',arrt_stp_stdtec_tit_new._p[1]],['w_DaDatOpe',arrt_stp_stdtec_tit_new._p[2]],['w_ADatOpe',arrt_stp_stdtec_tit_new._p[3]],['w_DaDatReg',arrt_stp_stdtec_tit_new._p[4]],['w_ADatReg',arrt_stp_stdtec_tit_new._p[5]],['w_daCodCli',arrt_stp_stdtec_tit_new._p[6]],['w_aCodCli',arrt_stp_stdtec_tit_new._p[7]],['w_daCodDip',arrt_stp_stdtec_tit_new._p[8]],['w_aCodDip',arrt_stp_stdtec_tit_new._p[9]]]],{eval:function(e){eval(e)}})
arrt_stp_stdtec_tit_new._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_stp_stdtec_tit_new._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_stp_stdtec_tit_new._s.SetParameterString('pAUI',WtA(pAUI,'C'));
arrt_stp_stdtec_tit_new._s.SetParameterString('pPDF',WtA(pPDF,'C'));
arrt_stp_stdtec_tit_new._s.SetParameterString('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_stp_stdtec_tit_new._s.SetParameterString('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_stp_stdtec_tit_new._s.SetParameterString('w_DaDatReg',WtA(w_DaDatReg,'D'));
arrt_stp_stdtec_tit_new._s.SetParameterString('w_ADatReg',WtA(w_ADatReg,'D'));
arrt_stp_stdtec_tit_new._s.SetParameterString('w_daCodCli',WtA(w_daCodCli,'C'));
arrt_stp_stdtec_tit_new._s.SetParameterString('w_aCodCli',WtA(w_aCodCli,'C'));
arrt_stp_stdtec_tit_new._s.SetParameterString('w_daCodDip',WtA(w_daCodDip,'C'));
arrt_stp_stdtec_tit_new._s.SetParameterString('w_aCodDip',WtA(w_aCodDip,'C'));
arrt_stp_stdtec_tit_new._s.SetParameterString('m_bApplet','true');
arrt_stp_stdtec_tit_new._s.CallServlet('arrt_stp_stdtec_tit_new');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_stp_stdtec_tit_new._s.errmsg;
}
}
arrt_stp_stdtec_tit_new.CtxLoad_ = function(){return []}
