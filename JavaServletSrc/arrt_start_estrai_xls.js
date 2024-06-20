function arrt_start_estrai_xls() {
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
var w_flgmese;
var w_flgncf;
var w_flgsegno;
var m_Caller
arrt_start_estrai_xls._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
}
if(arrt_start_estrai_xls._p.length>0)_rargs([[['pTipo',arrt_start_estrai_xls._p[0]]]],{eval:function(e){eval(e)}})
w_dadata=m_Caller.GetDate('w_dadata','D',0,0);
w_adata=m_Caller.GetDate('w_adata','D',0,0);
w_cdadata=m_Caller.GetString('w_cdadata','C',0,0);
w_c_adata=m_Caller.GetString('w_c_adata','C',0,0);
w_cDIP=m_Caller.GetString('w_cDIP','C',0,0);
w_xdesdip=m_Caller.GetString('w_xdesdip','C',0,0);
w_ragosc=m_Caller.GetString('w_ragosc','C',0,0);
w_citnas=m_Caller.GetString('w_citnas','C',0,0);
w_stanas=m_Caller.GetString('w_stanas','C',0,0);
w_datnas=m_Caller.GetDate('w_datnas','D',0,0);
w_cMTCN=m_Caller.GetString('w_cMTCN','C',0,0);
w_cCODFISC=m_Caller.GetString('w_cCODFISC','C',0,0);
w_ragben=m_Caller.GetString('w_ragben','C',0,0);
w_staben=m_Caller.GetString('w_staben','C',0,0);
w_codmag=m_Caller.GetString('w_codmag','C',0,0);
w_connes=m_Caller.GetString('w_connes','C',0,0);
w_nomefile=m_Caller.GetString('w_nomefile','C',0,0);
w_tipofile=m_Caller.GetString('w_tipofile','C',0,0);
w_flgsto=m_Caller.GetString('w_flgsto','C',0,0);
w_tipoout=m_Caller.GetString('w_tipoout','C',0,0);
w_opesel=m_Caller.GetString('w_opesel','C',0,0);
w_frzsel=m_Caller.GetString('w_frzsel','C',0,0);
w_attive=m_Caller.GetString('w_attive','C',0,0);
w_destfold=m_Caller.GetString('w_destfold','C',0,0);
w_flgmese=m_Caller.GetString('w_flgmese','C',0,0);
w_flgncf=m_Caller.GetString('w_flgncf','C',0,0);
w_flgsegno=m_Caller.GetString('w_flgsegno','C',0,0);
arrt_start_estrai_xls._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_start_estrai_xls._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_start_estrai_xls._s.SetCallerStringVar('w_dadata',WtA(w_dadata,'D'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_adata',WtA(w_adata,'D'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_cdadata',WtA(w_cdadata,'C'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_c_adata',WtA(w_c_adata,'C'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_cDIP',WtA(w_cDIP,'C'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_xdesdip',WtA(w_xdesdip,'C'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_ragosc',WtA(w_ragosc,'C'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_citnas',WtA(w_citnas,'C'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_stanas',WtA(w_stanas,'C'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_datnas',WtA(w_datnas,'D'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_cMTCN',WtA(w_cMTCN,'C'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_cCODFISC',WtA(w_cCODFISC,'C'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_ragben',WtA(w_ragben,'C'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_staben',WtA(w_staben,'C'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_codmag',WtA(w_codmag,'C'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_connes',WtA(w_connes,'C'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_nomefile',WtA(w_nomefile,'C'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_tipofile',WtA(w_tipofile,'C'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_flgsto',WtA(w_flgsto,'C'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_tipoout',WtA(w_tipoout,'C'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_opesel',WtA(w_opesel,'C'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_frzsel',WtA(w_frzsel,'C'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_attive',WtA(w_attive,'C'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_destfold',WtA(w_destfold,'C'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_flgmese',WtA(w_flgmese,'C'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_flgncf',WtA(w_flgncf,'C'));
arrt_start_estrai_xls._s.SetCallerStringVar('w_flgsegno',WtA(w_flgsegno,'C'));
arrt_start_estrai_xls._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_start_estrai_xls._s.SetParameterString('m_bApplet','true');
arrt_start_estrai_xls._s.CallServlet('arrt_start_estrai_xls');
m_Caller.SetDate('w_dadata','D',0,0,DateFromApplet(arrt_start_estrai_xls._s.GetCallerDateVar('w_dadata')));
m_Caller.SetDate('w_adata','D',0,0,DateFromApplet(arrt_start_estrai_xls._s.GetCallerDateVar('w_adata')));
m_Caller.SetString('w_cdadata','C',0,0,arrt_start_estrai_xls._s.GetCallerStringVar('w_cdadata'));
m_Caller.SetString('w_c_adata','C',0,0,arrt_start_estrai_xls._s.GetCallerStringVar('w_c_adata'));
m_Caller.SetString('w_cDIP','C',0,0,arrt_start_estrai_xls._s.GetCallerStringVar('w_cDIP'));
m_Caller.SetString('w_xdesdip','C',0,0,arrt_start_estrai_xls._s.GetCallerStringVar('w_xdesdip'));
m_Caller.SetString('w_ragosc','C',0,0,arrt_start_estrai_xls._s.GetCallerStringVar('w_ragosc'));
m_Caller.SetString('w_citnas','C',0,0,arrt_start_estrai_xls._s.GetCallerStringVar('w_citnas'));
m_Caller.SetString('w_stanas','C',0,0,arrt_start_estrai_xls._s.GetCallerStringVar('w_stanas'));
m_Caller.SetDate('w_datnas','D',0,0,DateFromApplet(arrt_start_estrai_xls._s.GetCallerDateVar('w_datnas')));
m_Caller.SetString('w_cMTCN','C',0,0,arrt_start_estrai_xls._s.GetCallerStringVar('w_cMTCN'));
m_Caller.SetString('w_cCODFISC','C',0,0,arrt_start_estrai_xls._s.GetCallerStringVar('w_cCODFISC'));
m_Caller.SetString('w_ragben','C',0,0,arrt_start_estrai_xls._s.GetCallerStringVar('w_ragben'));
m_Caller.SetString('w_staben','C',0,0,arrt_start_estrai_xls._s.GetCallerStringVar('w_staben'));
m_Caller.SetString('w_codmag','C',0,0,arrt_start_estrai_xls._s.GetCallerStringVar('w_codmag'));
m_Caller.SetString('w_connes','C',0,0,arrt_start_estrai_xls._s.GetCallerStringVar('w_connes'));
m_Caller.SetString('w_nomefile','C',0,0,arrt_start_estrai_xls._s.GetCallerStringVar('w_nomefile'));
m_Caller.SetString('w_tipofile','C',0,0,arrt_start_estrai_xls._s.GetCallerStringVar('w_tipofile'));
m_Caller.SetString('w_flgsto','C',0,0,arrt_start_estrai_xls._s.GetCallerStringVar('w_flgsto'));
m_Caller.SetString('w_tipoout','C',0,0,arrt_start_estrai_xls._s.GetCallerStringVar('w_tipoout'));
m_Caller.SetString('w_opesel','C',0,0,arrt_start_estrai_xls._s.GetCallerStringVar('w_opesel'));
m_Caller.SetString('w_frzsel','C',0,0,arrt_start_estrai_xls._s.GetCallerStringVar('w_frzsel'));
m_Caller.SetString('w_attive','C',0,0,arrt_start_estrai_xls._s.GetCallerStringVar('w_attive'));
m_Caller.SetString('w_destfold','C',0,0,arrt_start_estrai_xls._s.GetCallerStringVar('w_destfold'));
m_Caller.SetString('w_flgmese','C',0,0,arrt_start_estrai_xls._s.GetCallerStringVar('w_flgmese'));
m_Caller.SetString('w_flgncf','C',0,0,arrt_start_estrai_xls._s.GetCallerStringVar('w_flgncf'));
m_Caller.SetString('w_flgsegno','C',0,0,arrt_start_estrai_xls._s.GetCallerStringVar('w_flgsegno'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_start_estrai_xls._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_start_estrai_xls.CtxLoad_ = function(){return []}
