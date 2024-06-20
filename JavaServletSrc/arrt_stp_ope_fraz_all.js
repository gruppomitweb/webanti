function arrt_stp_ope_fraz_all() {
var w_DaDatOpe;
var w_ADatOpe;
var w_DaDatReg;
var w_ADatReg;
var w_DaDatRet;
var w_ADatRet;
var w_EstrazTitEffNelPeriodo;
var w_CONNES;
var w_TipoOpeStampa;
var w_TipoStampa;
var w_OrderBy;
var w_Stp_dist_lire_euro;
var w_Con_Contanti;
var w_Stato;
var w_Senza_dip;
var w_Dipendenza;
var w_Ambito;
var m_Caller
arrt_stp_ope_fraz_all._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_DaDatOpe=NullDate();
w_ADatOpe=NullDate();
w_DaDatReg=NullDate();
w_ADatReg=NullDate();
w_DaDatRet=NullDate();
w_ADatRet=NullDate();
w_EstrazTitEffNelPeriodo='';
w_CONNES='';
w_TipoOpeStampa='';
w_TipoStampa='';
w_OrderBy='';
w_Stp_dist_lire_euro=false;
w_Con_Contanti=false;
w_Stato='';
w_Senza_dip=false;
w_Dipendenza='';
w_Ambito='';
}
if(arrt_stp_ope_fraz_all._p.length>0)_rargs([[['w_DaDatOpe',arrt_stp_ope_fraz_all._p[0]],['w_ADatOpe',arrt_stp_ope_fraz_all._p[1]],['w_DaDatReg',arrt_stp_ope_fraz_all._p[2]],['w_ADatReg',arrt_stp_ope_fraz_all._p[3]],['w_DaDatRet',arrt_stp_ope_fraz_all._p[4]],['w_ADatRet',arrt_stp_ope_fraz_all._p[5]],['w_EstrazTitEffNelPeriodo',arrt_stp_ope_fraz_all._p[6]],['w_CONNES',arrt_stp_ope_fraz_all._p[7]],['w_TipoOpeStampa',arrt_stp_ope_fraz_all._p[8]],['w_TipoStampa',arrt_stp_ope_fraz_all._p[9]],['w_OrderBy',arrt_stp_ope_fraz_all._p[10]],['w_Stp_dist_lire_euro',arrt_stp_ope_fraz_all._p[11]],['w_Con_Contanti',arrt_stp_ope_fraz_all._p[12]],['w_Stato',arrt_stp_ope_fraz_all._p[13]],['w_Senza_dip',arrt_stp_ope_fraz_all._p[14]],['w_Dipendenza',arrt_stp_ope_fraz_all._p[15]],['w_Ambito',arrt_stp_ope_fraz_all._p[16]]]],{eval:function(e){eval(e)}})
arrt_stp_ope_fraz_all._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_stp_ope_fraz_all._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_stp_ope_fraz_all._s.SetParameterString('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_stp_ope_fraz_all._s.SetParameterString('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_stp_ope_fraz_all._s.SetParameterString('w_DaDatReg',WtA(w_DaDatReg,'D'));
arrt_stp_ope_fraz_all._s.SetParameterString('w_ADatReg',WtA(w_ADatReg,'D'));
arrt_stp_ope_fraz_all._s.SetParameterString('w_DaDatRet',WtA(w_DaDatRet,'D'));
arrt_stp_ope_fraz_all._s.SetParameterString('w_ADatRet',WtA(w_ADatRet,'D'));
arrt_stp_ope_fraz_all._s.SetParameterString('w_EstrazTitEffNelPeriodo',WtA(w_EstrazTitEffNelPeriodo,'C'));
arrt_stp_ope_fraz_all._s.SetParameterString('w_CONNES',WtA(w_CONNES,'C'));
arrt_stp_ope_fraz_all._s.SetParameterString('w_TipoOpeStampa',WtA(w_TipoOpeStampa,'C'));
arrt_stp_ope_fraz_all._s.SetParameterString('w_TipoStampa',WtA(w_TipoStampa,'C'));
arrt_stp_ope_fraz_all._s.SetParameterString('w_OrderBy',WtA(w_OrderBy,'C'));
arrt_stp_ope_fraz_all._s.SetParameterString('w_Stp_dist_lire_euro',WtA(w_Stp_dist_lire_euro,'L'));
arrt_stp_ope_fraz_all._s.SetParameterString('w_Con_Contanti',WtA(w_Con_Contanti,'L'));
arrt_stp_ope_fraz_all._s.SetParameterString('w_Stato',WtA(w_Stato,'C'));
arrt_stp_ope_fraz_all._s.SetParameterString('w_Senza_dip',WtA(w_Senza_dip,'L'));
arrt_stp_ope_fraz_all._s.SetParameterString('w_Dipendenza',WtA(w_Dipendenza,'C'));
arrt_stp_ope_fraz_all._s.SetParameterString('w_Ambito',WtA(w_Ambito,'C'));
arrt_stp_ope_fraz_all._s.SetParameterString('m_bApplet','true');
arrt_stp_ope_fraz_all._s.CallServlet('arrt_stp_ope_fraz_all');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_stp_ope_fraz_all._s.errmsg;
}
}
arrt_stp_ope_fraz_all.CtxLoad_ = function(){return []}
