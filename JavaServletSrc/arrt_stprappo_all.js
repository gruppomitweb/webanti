function arrt_stprappo_all() {
var fonte;
var tipostp;
var daRappo;
var aRappo;
var DaSogg;
var ASogg;
var coddip;
var DaData;
var AData;
var detope;
var detana;
var flgtit;
var flgdel;
var tipo;
var attiva;
var mod_attiva;
var cancellata;
var mod_copia;
var aui;
var pTIPOAG;
var pRISGLOB;
var m_Caller
arrt_stprappo_all._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
fonte='';
tipostp='';
daRappo='';
aRappo='';
DaSogg='';
ASogg='';
coddip='';
DaData=NullDate();
AData=NullDate();
detope=false;
detana=false;
flgtit=false;
flgdel=false;
tipo='';
attiva=false;
mod_attiva=false;
cancellata=false;
mod_copia=false;
aui=false;
pTIPOAG='';
pRISGLOB='';
}
if(arrt_stprappo_all._p.length>0)_rargs([[['fonte',arrt_stprappo_all._p[0]],['tipostp',arrt_stprappo_all._p[1]],['daRappo',arrt_stprappo_all._p[2]],['aRappo',arrt_stprappo_all._p[3]],['DaSogg',arrt_stprappo_all._p[4]],['ASogg',arrt_stprappo_all._p[5]],['coddip',arrt_stprappo_all._p[6]],['DaData',arrt_stprappo_all._p[7]],['AData',arrt_stprappo_all._p[8]],['detope',arrt_stprappo_all._p[9]],['detana',arrt_stprappo_all._p[10]],['flgtit',arrt_stprappo_all._p[11]],['flgdel',arrt_stprappo_all._p[12]],['tipo',arrt_stprappo_all._p[13]],['attiva',arrt_stprappo_all._p[14]],['mod_attiva',arrt_stprappo_all._p[15]],['cancellata',arrt_stprappo_all._p[16]],['mod_copia',arrt_stprappo_all._p[17]],['aui',arrt_stprappo_all._p[18]],['pTIPOAG',arrt_stprappo_all._p[19]],['pRISGLOB',arrt_stprappo_all._p[20]]]],{eval:function(e){eval(e)}})
arrt_stprappo_all._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_stprappo_all._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_stprappo_all._s.SetParameterString('fonte',WtA(fonte,'C'));
arrt_stprappo_all._s.SetParameterString('tipostp',WtA(tipostp,'C'));
arrt_stprappo_all._s.SetParameterString('daRappo',WtA(daRappo,'C'));
arrt_stprappo_all._s.SetParameterString('aRappo',WtA(aRappo,'C'));
arrt_stprappo_all._s.SetParameterString('DaSogg',WtA(DaSogg,'C'));
arrt_stprappo_all._s.SetParameterString('ASogg',WtA(ASogg,'C'));
arrt_stprappo_all._s.SetParameterString('coddip',WtA(coddip,'C'));
arrt_stprappo_all._s.SetParameterString('DaData',WtA(DaData,'D'));
arrt_stprappo_all._s.SetParameterString('AData',WtA(AData,'D'));
arrt_stprappo_all._s.SetParameterString('detope',WtA(detope,'L'));
arrt_stprappo_all._s.SetParameterString('detana',WtA(detana,'L'));
arrt_stprappo_all._s.SetParameterString('flgtit',WtA(flgtit,'L'));
arrt_stprappo_all._s.SetParameterString('flgdel',WtA(flgdel,'L'));
arrt_stprappo_all._s.SetParameterString('tipo',WtA(tipo,'C'));
arrt_stprappo_all._s.SetParameterString('attiva',WtA(attiva,'L'));
arrt_stprappo_all._s.SetParameterString('mod_attiva',WtA(mod_attiva,'L'));
arrt_stprappo_all._s.SetParameterString('cancellata',WtA(cancellata,'L'));
arrt_stprappo_all._s.SetParameterString('mod_copia',WtA(mod_copia,'L'));
arrt_stprappo_all._s.SetParameterString('aui',WtA(aui,'L'));
arrt_stprappo_all._s.SetParameterString('pTIPOAG',WtA(pTIPOAG,'C'));
arrt_stprappo_all._s.SetParameterString('pRISGLOB',WtA(pRISGLOB,'C'));
arrt_stprappo_all._s.SetParameterString('m_bApplet','true');
arrt_stprappo_all._s.CallServlet('arrt_stprappo_all');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_stprappo_all._s.errmsg;
}
}
arrt_stprappo_all.CtxLoad_ = function(){return []}
