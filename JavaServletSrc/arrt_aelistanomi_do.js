function arrt_aelistanomi_do() {
var w_iniz;
var w_dadata;
var w_a_data;
var w_datpris;
var w_datprif;
var w_datseci;
var w_datsecf;
var w_tipostp;
var m_Caller
arrt_aelistanomi_do._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_iniz=m_Caller.GetString('w_iniz','C',0,0);
w_dadata=m_Caller.GetDate('w_dadata','D',0,0);
w_a_data=m_Caller.GetDate('w_a_data','D',0,0);
w_datpris=m_Caller.GetDate('w_datpris','D',0,0);
w_datprif=m_Caller.GetDate('w_datprif','D',0,0);
w_datseci=m_Caller.GetDate('w_datseci','D',0,0);
w_datsecf=m_Caller.GetDate('w_datsecf','D',0,0);
w_tipostp=m_Caller.GetString('w_tipostp','C',0,0);
arrt_aelistanomi_do._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_aelistanomi_do._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_aelistanomi_do._s.SetCallerStringVar('w_iniz',WtA(w_iniz,'C'));
arrt_aelistanomi_do._s.SetCallerStringVar('w_dadata',WtA(w_dadata,'D'));
arrt_aelistanomi_do._s.SetCallerStringVar('w_a_data',WtA(w_a_data,'D'));
arrt_aelistanomi_do._s.SetCallerStringVar('w_datpris',WtA(w_datpris,'D'));
arrt_aelistanomi_do._s.SetCallerStringVar('w_datprif',WtA(w_datprif,'D'));
arrt_aelistanomi_do._s.SetCallerStringVar('w_datseci',WtA(w_datseci,'D'));
arrt_aelistanomi_do._s.SetCallerStringVar('w_datsecf',WtA(w_datsecf,'D'));
arrt_aelistanomi_do._s.SetCallerStringVar('w_tipostp',WtA(w_tipostp,'C'));
arrt_aelistanomi_do._s.SetParameterString('m_bApplet','true');
arrt_aelistanomi_do._s.CallServlet('arrt_aelistanomi_do');
m_Caller.SetString('w_iniz','C',0,0,arrt_aelistanomi_do._s.GetCallerStringVar('w_iniz'));
m_Caller.SetDate('w_dadata','D',0,0,DateFromApplet(arrt_aelistanomi_do._s.GetCallerDateVar('w_dadata')));
m_Caller.SetDate('w_a_data','D',0,0,DateFromApplet(arrt_aelistanomi_do._s.GetCallerDateVar('w_a_data')));
m_Caller.SetDate('w_datpris','D',0,0,DateFromApplet(arrt_aelistanomi_do._s.GetCallerDateVar('w_datpris')));
m_Caller.SetDate('w_datprif','D',0,0,DateFromApplet(arrt_aelistanomi_do._s.GetCallerDateVar('w_datprif')));
m_Caller.SetDate('w_datseci','D',0,0,DateFromApplet(arrt_aelistanomi_do._s.GetCallerDateVar('w_datseci')));
m_Caller.SetDate('w_datsecf','D',0,0,DateFromApplet(arrt_aelistanomi_do._s.GetCallerDateVar('w_datsecf')));
m_Caller.SetString('w_tipostp','C',0,0,arrt_aelistanomi_do._s.GetCallerStringVar('w_tipostp'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_aelistanomi_do._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_aelistanomi_do.CtxLoad_ = function(){return []}
