function arrt_estrai_xls() {
var pTipo;
var w_dadata;
var w_adata;
var w_cdadata;
var w_c_adata;
var w_cDIP;
var w_xdesdip;
var w_ragosc;
var w_citnas;
var w_stanas;
var w_datnas;
var w_cMTCN;
var w_cCODFISC;
var w_ragben;
var w_staben;
var w_codmag;
var w_connes;
var w_nomefile;
var w_tipofile;
var w_flgsto;
var w_tipoout;
var w_opesel;
var w_frzsel;
var w_attive;
var w_destfold;
var pAzienda;
var pPath;
var pMese;
var pNCF;
var pSegno;
var pLstSta;
var pLstPrv;
var pImporto;
var m_Caller
arrt_estrai_xls._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
w_dadata=NullDate();
w_adata=NullDate();
w_cdadata='';
w_c_adata='';
w_cDIP='';
w_xdesdip='';
w_ragosc='';
w_citnas='';
w_stanas='';
w_datnas=NullDate();
w_cMTCN='';
w_cCODFISC='';
w_ragben='';
w_staben='';
w_codmag='';
w_connes='';
w_nomefile='';
w_tipofile='';
w_flgsto='';
w_tipoout='';
w_opesel='';
w_frzsel='';
w_attive='';
w_destfold='';
pAzienda='';
pPath='';
pMese='';
pNCF='';
pSegno='';
pLstSta='';
pLstPrv='';
pImporto=0;
}
if(arrt_estrai_xls._p.length>0)_rargs([[['pTipo',arrt_estrai_xls._p[0]],['w_dadata',arrt_estrai_xls._p[1]],['w_adata',arrt_estrai_xls._p[2]],['w_cdadata',arrt_estrai_xls._p[3]],['w_c_adata',arrt_estrai_xls._p[4]],['w_cDIP',arrt_estrai_xls._p[5]],['w_xdesdip',arrt_estrai_xls._p[6]],['w_ragosc',arrt_estrai_xls._p[7]],['w_citnas',arrt_estrai_xls._p[8]],['w_stanas',arrt_estrai_xls._p[9]],['w_datnas',arrt_estrai_xls._p[10]],['w_cMTCN',arrt_estrai_xls._p[11]],['w_cCODFISC',arrt_estrai_xls._p[12]],['w_ragben',arrt_estrai_xls._p[13]],['w_staben',arrt_estrai_xls._p[14]],['w_codmag',arrt_estrai_xls._p[15]],['w_connes',arrt_estrai_xls._p[16]],['w_nomefile',arrt_estrai_xls._p[17]],['w_tipofile',arrt_estrai_xls._p[18]],['w_flgsto',arrt_estrai_xls._p[19]],['w_tipoout',arrt_estrai_xls._p[20]],['w_opesel',arrt_estrai_xls._p[21]],['w_frzsel',arrt_estrai_xls._p[22]],['w_attive',arrt_estrai_xls._p[23]],['w_destfold',arrt_estrai_xls._p[24]],['pAzienda',arrt_estrai_xls._p[25]],['pPath',arrt_estrai_xls._p[26]],['pMese',arrt_estrai_xls._p[27]],['pNCF',arrt_estrai_xls._p[28]],['pSegno',arrt_estrai_xls._p[29]],['pLstSta',arrt_estrai_xls._p[30]],['pLstPrv',arrt_estrai_xls._p[31]],['pImporto',arrt_estrai_xls._p[32]]]],{eval:function(e){eval(e)}})
arrt_estrai_xls._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_estrai_xls._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_estrai_xls._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_estrai_xls._s.SetParameterString('w_dadata',WtA(w_dadata,'D'));
arrt_estrai_xls._s.SetParameterString('w_adata',WtA(w_adata,'D'));
arrt_estrai_xls._s.SetParameterString('w_cdadata',WtA(w_cdadata,'C'));
arrt_estrai_xls._s.SetParameterString('w_c_adata',WtA(w_c_adata,'C'));
arrt_estrai_xls._s.SetParameterString('w_cDIP',WtA(w_cDIP,'C'));
arrt_estrai_xls._s.SetParameterString('w_xdesdip',WtA(w_xdesdip,'C'));
arrt_estrai_xls._s.SetParameterString('w_ragosc',WtA(w_ragosc,'C'));
arrt_estrai_xls._s.SetParameterString('w_citnas',WtA(w_citnas,'C'));
arrt_estrai_xls._s.SetParameterString('w_stanas',WtA(w_stanas,'C'));
arrt_estrai_xls._s.SetParameterString('w_datnas',WtA(w_datnas,'D'));
arrt_estrai_xls._s.SetParameterString('w_cMTCN',WtA(w_cMTCN,'C'));
arrt_estrai_xls._s.SetParameterString('w_cCODFISC',WtA(w_cCODFISC,'C'));
arrt_estrai_xls._s.SetParameterString('w_ragben',WtA(w_ragben,'C'));
arrt_estrai_xls._s.SetParameterString('w_staben',WtA(w_staben,'C'));
arrt_estrai_xls._s.SetParameterString('w_codmag',WtA(w_codmag,'C'));
arrt_estrai_xls._s.SetParameterString('w_connes',WtA(w_connes,'C'));
arrt_estrai_xls._s.SetParameterString('w_nomefile',WtA(w_nomefile,'C'));
arrt_estrai_xls._s.SetParameterString('w_tipofile',WtA(w_tipofile,'C'));
arrt_estrai_xls._s.SetParameterString('w_flgsto',WtA(w_flgsto,'C'));
arrt_estrai_xls._s.SetParameterString('w_tipoout',WtA(w_tipoout,'C'));
arrt_estrai_xls._s.SetParameterString('w_opesel',WtA(w_opesel,'C'));
arrt_estrai_xls._s.SetParameterString('w_frzsel',WtA(w_frzsel,'C'));
arrt_estrai_xls._s.SetParameterString('w_attive',WtA(w_attive,'C'));
arrt_estrai_xls._s.SetParameterString('w_destfold',WtA(w_destfold,'C'));
arrt_estrai_xls._s.SetParameterString('pAzienda',WtA(pAzienda,'C'));
arrt_estrai_xls._s.SetParameterString('pPath',WtA(pPath,'C'));
arrt_estrai_xls._s.SetParameterString('pMese',WtA(pMese,'C'));
arrt_estrai_xls._s.SetParameterString('pNCF',WtA(pNCF,'C'));
arrt_estrai_xls._s.SetParameterString('pSegno',WtA(pSegno,'C'));
arrt_estrai_xls._s.SetParameterString('pLstSta',WtA(pLstSta,'C'));
arrt_estrai_xls._s.SetParameterString('pLstPrv',WtA(pLstPrv,'C'));
arrt_estrai_xls._s.SetParameterString('pImporto',WtA(pImporto,'N'));
arrt_estrai_xls._s.SetParameterString('m_bApplet','true');
arrt_estrai_xls._s.CallServlet('arrt_estrai_xls');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_estrai_xls._s.errmsg;
}
}
arrt_estrai_xls.CtxLoad_ = function(){return []}
