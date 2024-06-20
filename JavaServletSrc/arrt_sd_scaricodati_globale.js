function arrt_sd_scaricodati_globale() {
var w_a_data;
var w_dadata;
var w_datpri;
var w_datsecf;
var w_datseci;
var w_iniz;
var w_seco;
var w_files;
var w_anno;
var w_mese;
var w_FILEINVIO;
var w_DATAINVIO;
var w_CFINVIO;
var w_CAFINVIO;
var m_Caller
arrt_sd_scaricodati_globale._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_a_data=m_Caller.GetDate('w_a_data','D',0,0);
w_dadata=m_Caller.GetDate('w_dadata','D',0,0);
w_datpri=m_Caller.GetDate('w_datpri','D',0,0);
w_datsecf=m_Caller.GetDate('w_datsecf','D',0,0);
w_datseci=m_Caller.GetDate('w_datseci','D',0,0);
w_iniz=m_Caller.GetString('w_iniz','C',0,0);
w_seco=m_Caller.GetString('w_seco','C',0,0);
w_files=m_Caller.GetNumber('w_files','N',0,0);
w_anno=m_Caller.GetNumber('w_anno','N',0,0);
w_mese=m_Caller.GetString('w_mese','C',0,0);
w_FILEINVIO=m_Caller.GetString('w_FILEINVIO','C',0,0);
w_DATAINVIO=m_Caller.GetDate('w_DATAINVIO','D',0,0);
w_CFINVIO=m_Caller.GetString('w_CFINVIO','C',0,0);
w_CAFINVIO=m_Caller.GetString('w_CAFINVIO','C',0,0);
arrt_sd_scaricodati_globale._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_sd_scaricodati_globale._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_sd_scaricodati_globale._s.SetCallerStringVar('w_a_data',WtA(w_a_data,'D'));
arrt_sd_scaricodati_globale._s.SetCallerStringVar('w_dadata',WtA(w_dadata,'D'));
arrt_sd_scaricodati_globale._s.SetCallerStringVar('w_datpri',WtA(w_datpri,'D'));
arrt_sd_scaricodati_globale._s.SetCallerStringVar('w_datsecf',WtA(w_datsecf,'D'));
arrt_sd_scaricodati_globale._s.SetCallerStringVar('w_datseci',WtA(w_datseci,'D'));
arrt_sd_scaricodati_globale._s.SetCallerStringVar('w_iniz',WtA(w_iniz,'C'));
arrt_sd_scaricodati_globale._s.SetCallerStringVar('w_seco',WtA(w_seco,'C'));
arrt_sd_scaricodati_globale._s.SetCallerStringVar('w_files',WtA(w_files,'N'));
arrt_sd_scaricodati_globale._s.SetCallerStringVar('w_anno',WtA(w_anno,'N'));
arrt_sd_scaricodati_globale._s.SetCallerStringVar('w_mese',WtA(w_mese,'C'));
arrt_sd_scaricodati_globale._s.SetCallerStringVar('w_FILEINVIO',WtA(w_FILEINVIO,'C'));
arrt_sd_scaricodati_globale._s.SetCallerStringVar('w_DATAINVIO',WtA(w_DATAINVIO,'D'));
arrt_sd_scaricodati_globale._s.SetCallerStringVar('w_CFINVIO',WtA(w_CFINVIO,'C'));
arrt_sd_scaricodati_globale._s.SetCallerStringVar('w_CAFINVIO',WtA(w_CAFINVIO,'C'));
arrt_sd_scaricodati_globale._s.SetParameterString('m_bApplet','true');
arrt_sd_scaricodati_globale._s.CallServlet('arrt_sd_scaricodati_globale');
m_Caller.SetDate('w_a_data','D',0,0,DateFromApplet(arrt_sd_scaricodati_globale._s.GetCallerDateVar('w_a_data')));
m_Caller.SetDate('w_dadata','D',0,0,DateFromApplet(arrt_sd_scaricodati_globale._s.GetCallerDateVar('w_dadata')));
m_Caller.SetDate('w_datpri','D',0,0,DateFromApplet(arrt_sd_scaricodati_globale._s.GetCallerDateVar('w_datpri')));
m_Caller.SetDate('w_datsecf','D',0,0,DateFromApplet(arrt_sd_scaricodati_globale._s.GetCallerDateVar('w_datsecf')));
m_Caller.SetDate('w_datseci','D',0,0,DateFromApplet(arrt_sd_scaricodati_globale._s.GetCallerDateVar('w_datseci')));
m_Caller.SetString('w_iniz','C',0,0,arrt_sd_scaricodati_globale._s.GetCallerStringVar('w_iniz'));
m_Caller.SetString('w_seco','C',0,0,arrt_sd_scaricodati_globale._s.GetCallerStringVar('w_seco'));
m_Caller.SetNumber('w_files','N',0,0,arrt_sd_scaricodati_globale._s.GetCallerDoubleVar('w_files'));
m_Caller.SetNumber('w_anno','N',0,0,arrt_sd_scaricodati_globale._s.GetCallerDoubleVar('w_anno'));
m_Caller.SetString('w_mese','C',0,0,arrt_sd_scaricodati_globale._s.GetCallerStringVar('w_mese'));
m_Caller.SetString('w_FILEINVIO','C',0,0,arrt_sd_scaricodati_globale._s.GetCallerStringVar('w_FILEINVIO'));
m_Caller.SetDate('w_DATAINVIO','D',0,0,DateFromApplet(arrt_sd_scaricodati_globale._s.GetCallerDateVar('w_DATAINVIO')));
m_Caller.SetString('w_CFINVIO','C',0,0,arrt_sd_scaricodati_globale._s.GetCallerStringVar('w_CFINVIO'));
m_Caller.SetString('w_CAFINVIO','C',0,0,arrt_sd_scaricodati_globale._s.GetCallerStringVar('w_CAFINVIO'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_sd_scaricodati_globale._s.errmsg;
}
CalledBatchEnd();
}
arrt_sd_scaricodati_globale.CtxLoad_ = function(){return []}
