function arrt_stp_stdtec_new_mc() {
var pTipo;
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
var w_flgrae;
var m_Caller
arrt_stp_stdtec_new_mc._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
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
w_flgrae='A';
}
if(arrt_stp_stdtec_new_mc._p.length>0)_rargs([[['pTipo',arrt_stp_stdtec_new_mc._p[0]],['pAUI',arrt_stp_stdtec_new_mc._p[1]],['pPDF',arrt_stp_stdtec_new_mc._p[2]],['w_DaDatOpe',arrt_stp_stdtec_new_mc._p[3]],['w_ADatOpe',arrt_stp_stdtec_new_mc._p[4]],['w_DaDatReg',arrt_stp_stdtec_new_mc._p[5]],['w_ADatReg',arrt_stp_stdtec_new_mc._p[6]],['w_daCodCli',arrt_stp_stdtec_new_mc._p[7]],['w_aCodCli',arrt_stp_stdtec_new_mc._p[8]],['w_daCodDip',arrt_stp_stdtec_new_mc._p[9]],['w_aCodDip',arrt_stp_stdtec_new_mc._p[10]],['w_flgrae',arrt_stp_stdtec_new_mc._p[11]]]],{eval:function(e){eval(e)}})
arrt_stp_stdtec_new_mc._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_stp_stdtec_new_mc._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_stp_stdtec_new_mc._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_stp_stdtec_new_mc._s.SetParameterString('pAUI',WtA(pAUI,'C'));
arrt_stp_stdtec_new_mc._s.SetParameterString('pPDF',WtA(pPDF,'C'));
arrt_stp_stdtec_new_mc._s.SetParameterString('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_stp_stdtec_new_mc._s.SetParameterString('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_stp_stdtec_new_mc._s.SetParameterString('w_DaDatReg',WtA(w_DaDatReg,'D'));
arrt_stp_stdtec_new_mc._s.SetParameterString('w_ADatReg',WtA(w_ADatReg,'D'));
arrt_stp_stdtec_new_mc._s.SetParameterString('w_daCodCli',WtA(w_daCodCli,'C'));
arrt_stp_stdtec_new_mc._s.SetParameterString('w_aCodCli',WtA(w_aCodCli,'C'));
arrt_stp_stdtec_new_mc._s.SetParameterString('w_daCodDip',WtA(w_daCodDip,'C'));
arrt_stp_stdtec_new_mc._s.SetParameterString('w_aCodDip',WtA(w_aCodDip,'C'));
arrt_stp_stdtec_new_mc._s.SetParameterString('w_flgrae',WtA(w_flgrae,'C'));
arrt_stp_stdtec_new_mc._s.SetParameterString('m_bApplet','true');
arrt_stp_stdtec_new_mc._s.CallServlet('arrt_stp_stdtec_new_mc');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_stp_stdtec_new_mc._s.errmsg;
}
}
arrt_stp_stdtec_new_mc.CtxLoad_ = function(){return []}
