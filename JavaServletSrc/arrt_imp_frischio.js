function arrt_imp_frischio() {
var pTipo;
var w_CONNESCLI;
var w_RAPPORTO;
var w_DURAT;
var w_AMMONT;
var w_AREAGEO;
var w_MODSVOL;
var w_RAGIO;
var w_TIPO;
var w_RAREA;
var w_RCOMP;
var w_RRAGIO;
var w_RTIPO;
var w_RFREQ;
var w_RIMP;
var m_Caller
arrt_imp_frischio._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
}
if(arrt_imp_frischio._p.length>0)_rargs([[['pTipo',arrt_imp_frischio._p[0]]]],{eval:function(e){eval(e)}})
w_CONNESCLI=m_Caller.GetString('w_CONNESCLI','C',0,0);
w_RAPPORTO=m_Caller.GetString('w_RAPPORTO','C',0,0);
w_DURAT=m_Caller.GetString('w_DURAT','C',0,0);
w_AMMONT=m_Caller.GetString('w_AMMONT','C',0,0);
w_AREAGEO=m_Caller.GetString('w_AREAGEO','C',0,0);
w_MODSVOL=m_Caller.GetString('w_MODSVOL','C',0,0);
w_RAGIO=m_Caller.GetString('w_RAGIO','C',0,0);
w_TIPO=m_Caller.GetString('w_TIPO','C',0,0);
w_RAREA=m_Caller.GetNumber('w_RAREA','N',0,0);
w_RCOMP=m_Caller.GetNumber('w_RCOMP','N',0,0);
w_RRAGIO=m_Caller.GetNumber('w_RRAGIO','N',0,0);
w_RTIPO=m_Caller.GetNumber('w_RTIPO','N',0,0);
w_RFREQ=m_Caller.GetNumber('w_RFREQ','N',0,0);
w_RIMP=m_Caller.GetNumber('w_RIMP','N',0,0);
arrt_imp_frischio._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_imp_frischio._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_imp_frischio._s.SetCallerStringVar('w_CONNESCLI',WtA(w_CONNESCLI,'C'));
arrt_imp_frischio._s.SetCallerStringVar('w_RAPPORTO',WtA(w_RAPPORTO,'C'));
arrt_imp_frischio._s.SetCallerStringVar('w_DURAT',WtA(w_DURAT,'C'));
arrt_imp_frischio._s.SetCallerStringVar('w_AMMONT',WtA(w_AMMONT,'C'));
arrt_imp_frischio._s.SetCallerStringVar('w_AREAGEO',WtA(w_AREAGEO,'C'));
arrt_imp_frischio._s.SetCallerStringVar('w_MODSVOL',WtA(w_MODSVOL,'C'));
arrt_imp_frischio._s.SetCallerStringVar('w_RAGIO',WtA(w_RAGIO,'C'));
arrt_imp_frischio._s.SetCallerStringVar('w_TIPO',WtA(w_TIPO,'C'));
arrt_imp_frischio._s.SetCallerStringVar('w_RAREA',WtA(w_RAREA,'N'));
arrt_imp_frischio._s.SetCallerStringVar('w_RCOMP',WtA(w_RCOMP,'N'));
arrt_imp_frischio._s.SetCallerStringVar('w_RRAGIO',WtA(w_RRAGIO,'N'));
arrt_imp_frischio._s.SetCallerStringVar('w_RTIPO',WtA(w_RTIPO,'N'));
arrt_imp_frischio._s.SetCallerStringVar('w_RFREQ',WtA(w_RFREQ,'N'));
arrt_imp_frischio._s.SetCallerStringVar('w_RIMP',WtA(w_RIMP,'N'));
arrt_imp_frischio._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_imp_frischio._s.SetParameterString('m_bApplet','true');
arrt_imp_frischio._s.CallServlet('arrt_imp_frischio');
m_Caller.SetString('w_CONNESCLI','C',0,0,arrt_imp_frischio._s.GetCallerStringVar('w_CONNESCLI'));
m_Caller.SetString('w_RAPPORTO','C',0,0,arrt_imp_frischio._s.GetCallerStringVar('w_RAPPORTO'));
m_Caller.SetString('w_DURAT','C',0,0,arrt_imp_frischio._s.GetCallerStringVar('w_DURAT'));
m_Caller.SetString('w_AMMONT','C',0,0,arrt_imp_frischio._s.GetCallerStringVar('w_AMMONT'));
m_Caller.SetString('w_AREAGEO','C',0,0,arrt_imp_frischio._s.GetCallerStringVar('w_AREAGEO'));
m_Caller.SetString('w_MODSVOL','C',0,0,arrt_imp_frischio._s.GetCallerStringVar('w_MODSVOL'));
m_Caller.SetString('w_RAGIO','C',0,0,arrt_imp_frischio._s.GetCallerStringVar('w_RAGIO'));
m_Caller.SetString('w_TIPO','C',0,0,arrt_imp_frischio._s.GetCallerStringVar('w_TIPO'));
m_Caller.SetNumber('w_RAREA','N',0,0,arrt_imp_frischio._s.GetCallerDoubleVar('w_RAREA'));
m_Caller.SetNumber('w_RCOMP','N',0,0,arrt_imp_frischio._s.GetCallerDoubleVar('w_RCOMP'));
m_Caller.SetNumber('w_RRAGIO','N',0,0,arrt_imp_frischio._s.GetCallerDoubleVar('w_RRAGIO'));
m_Caller.SetNumber('w_RTIPO','N',0,0,arrt_imp_frischio._s.GetCallerDoubleVar('w_RTIPO'));
m_Caller.SetNumber('w_RFREQ','N',0,0,arrt_imp_frischio._s.GetCallerDoubleVar('w_RFREQ'));
m_Caller.SetNumber('w_RIMP','N',0,0,arrt_imp_frischio._s.GetCallerDoubleVar('w_RIMP'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_imp_frischio._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_imp_frischio.CtxLoad_ = function(){return []}
