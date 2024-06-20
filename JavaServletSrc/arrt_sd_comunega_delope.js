function arrt_sd_comunega_delope() {
var w_a_data;
var w_dadata;
var w_datpri;
var w_datprf;
var w_datsecf;
var w_datseci;
var w_iniz;
var w_seco;
var m_Caller
arrt_sd_comunega_delope._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_a_data=m_Caller.GetDate('w_a_data','D',0,0);
w_dadata=m_Caller.GetDate('w_dadata','D',0,0);
w_datpri=m_Caller.GetDate('w_datpri','D',0,0);
w_datprf=m_Caller.GetDate('w_datprf','D',0,0);
w_datsecf=m_Caller.GetDate('w_datsecf','D',0,0);
w_datseci=m_Caller.GetDate('w_datseci','D',0,0);
w_iniz=m_Caller.GetString('w_iniz','C',0,0);
w_seco=m_Caller.GetString('w_seco','C',0,0);
arrt_sd_comunega_delope._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_sd_comunega_delope._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_sd_comunega_delope._s.SetCallerStringVar('w_a_data',WtA(w_a_data,'D'));
arrt_sd_comunega_delope._s.SetCallerStringVar('w_dadata',WtA(w_dadata,'D'));
arrt_sd_comunega_delope._s.SetCallerStringVar('w_datpri',WtA(w_datpri,'D'));
arrt_sd_comunega_delope._s.SetCallerStringVar('w_datprf',WtA(w_datprf,'D'));
arrt_sd_comunega_delope._s.SetCallerStringVar('w_datsecf',WtA(w_datsecf,'D'));
arrt_sd_comunega_delope._s.SetCallerStringVar('w_datseci',WtA(w_datseci,'D'));
arrt_sd_comunega_delope._s.SetCallerStringVar('w_iniz',WtA(w_iniz,'C'));
arrt_sd_comunega_delope._s.SetCallerStringVar('w_seco',WtA(w_seco,'C'));
arrt_sd_comunega_delope._s.SetParameterString('m_bApplet','true');
arrt_sd_comunega_delope._s.CallServlet('arrt_sd_comunega_delope');
m_Caller.SetDate('w_a_data','D',0,0,DateFromApplet(arrt_sd_comunega_delope._s.GetCallerDateVar('w_a_data')));
m_Caller.SetDate('w_dadata','D',0,0,DateFromApplet(arrt_sd_comunega_delope._s.GetCallerDateVar('w_dadata')));
m_Caller.SetDate('w_datpri','D',0,0,DateFromApplet(arrt_sd_comunega_delope._s.GetCallerDateVar('w_datpri')));
m_Caller.SetDate('w_datprf','D',0,0,DateFromApplet(arrt_sd_comunega_delope._s.GetCallerDateVar('w_datprf')));
m_Caller.SetDate('w_datsecf','D',0,0,DateFromApplet(arrt_sd_comunega_delope._s.GetCallerDateVar('w_datsecf')));
m_Caller.SetDate('w_datseci','D',0,0,DateFromApplet(arrt_sd_comunega_delope._s.GetCallerDateVar('w_datseci')));
m_Caller.SetString('w_iniz','C',0,0,arrt_sd_comunega_delope._s.GetCallerStringVar('w_iniz'));
m_Caller.SetString('w_seco','C',0,0,arrt_sd_comunega_delope._s.GetCallerStringVar('w_seco'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_sd_comunega_delope._s.errmsg;
}
CalledBatchEnd();
}
arrt_sd_comunega_delope.CtxLoad_ = function(){return []}
