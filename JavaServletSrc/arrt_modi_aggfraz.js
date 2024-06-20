function arrt_modi_aggfraz() {
var w_IDBASE;
var w_DURAT;
var w_RFREQ;
var w_AMMONT;
var w_RIMP;
var w_AREAGEO;
var w_RAREA;
var w_MODSVOL;
var w_RCOMP;
var w_RAGIO;
var w_RRAGIO;
var w_TIPO;
var w_RTIPO;
var w_NOPROT;
var w_OPERAG;
var w_RESPINS;
var w_SCOPO;
var w_NATURA;
var w_INFORM;
var m_Caller
arrt_modi_aggfraz._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_IDBASE=m_Caller.GetString('w_IDBASE','C',0,0);
w_DURAT=m_Caller.GetString('w_DURAT','C',0,0);
w_RFREQ=m_Caller.GetNumber('w_RFREQ','N',0,0);
w_AMMONT=m_Caller.GetString('w_AMMONT','C',0,0);
w_RIMP=m_Caller.GetNumber('w_RIMP','N',0,0);
w_AREAGEO=m_Caller.GetString('w_AREAGEO','C',0,0);
w_RAREA=m_Caller.GetNumber('w_RAREA','N',0,0);
w_MODSVOL=m_Caller.GetString('w_MODSVOL','C',0,0);
w_RCOMP=m_Caller.GetNumber('w_RCOMP','N',0,0);
w_RAGIO=m_Caller.GetString('w_RAGIO','C',0,0);
w_RRAGIO=m_Caller.GetNumber('w_RRAGIO','N',0,0);
w_TIPO=m_Caller.GetString('w_TIPO','C',0,0);
w_RTIPO=m_Caller.GetNumber('w_RTIPO','N',0,0);
w_NOPROT=m_Caller.GetNumber('w_NOPROT','N',0,0);
w_OPERAG=m_Caller.GetString('w_OPERAG','C',0,0);
w_RESPINS=m_Caller.GetString('w_RESPINS','C',0,0);
w_SCOPO=m_Caller.GetString('w_SCOPO','C',0,0);
w_NATURA=m_Caller.GetString('w_NATURA','C',0,0);
w_INFORM=m_Caller.GetString('w_INFORM','C',0,0);
arrt_modi_aggfraz._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_modi_aggfraz._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_modi_aggfraz._s.SetCallerStringVar('w_IDBASE',WtA(w_IDBASE,'C'));
arrt_modi_aggfraz._s.SetCallerStringVar('w_DURAT',WtA(w_DURAT,'C'));
arrt_modi_aggfraz._s.SetCallerStringVar('w_RFREQ',WtA(w_RFREQ,'N'));
arrt_modi_aggfraz._s.SetCallerStringVar('w_AMMONT',WtA(w_AMMONT,'C'));
arrt_modi_aggfraz._s.SetCallerStringVar('w_RIMP',WtA(w_RIMP,'N'));
arrt_modi_aggfraz._s.SetCallerStringVar('w_AREAGEO',WtA(w_AREAGEO,'C'));
arrt_modi_aggfraz._s.SetCallerStringVar('w_RAREA',WtA(w_RAREA,'N'));
arrt_modi_aggfraz._s.SetCallerStringVar('w_MODSVOL',WtA(w_MODSVOL,'C'));
arrt_modi_aggfraz._s.SetCallerStringVar('w_RCOMP',WtA(w_RCOMP,'N'));
arrt_modi_aggfraz._s.SetCallerStringVar('w_RAGIO',WtA(w_RAGIO,'C'));
arrt_modi_aggfraz._s.SetCallerStringVar('w_RRAGIO',WtA(w_RRAGIO,'N'));
arrt_modi_aggfraz._s.SetCallerStringVar('w_TIPO',WtA(w_TIPO,'C'));
arrt_modi_aggfraz._s.SetCallerStringVar('w_RTIPO',WtA(w_RTIPO,'N'));
arrt_modi_aggfraz._s.SetCallerStringVar('w_NOPROT',WtA(w_NOPROT,'N'));
arrt_modi_aggfraz._s.SetCallerStringVar('w_OPERAG',WtA(w_OPERAG,'C'));
arrt_modi_aggfraz._s.SetCallerStringVar('w_RESPINS',WtA(w_RESPINS,'C'));
arrt_modi_aggfraz._s.SetCallerStringVar('w_SCOPO',WtA(w_SCOPO,'C'));
arrt_modi_aggfraz._s.SetCallerStringVar('w_NATURA',WtA(w_NATURA,'C'));
arrt_modi_aggfraz._s.SetCallerStringVar('w_INFORM',WtA(w_INFORM,'C'));
arrt_modi_aggfraz._s.SetParameterString('m_bApplet','true');
arrt_modi_aggfraz._s.CallServlet('arrt_modi_aggfraz');
m_Caller.SetString('w_IDBASE','C',0,0,arrt_modi_aggfraz._s.GetCallerStringVar('w_IDBASE'));
m_Caller.SetString('w_DURAT','C',0,0,arrt_modi_aggfraz._s.GetCallerStringVar('w_DURAT'));
m_Caller.SetNumber('w_RFREQ','N',0,0,arrt_modi_aggfraz._s.GetCallerDoubleVar('w_RFREQ'));
m_Caller.SetString('w_AMMONT','C',0,0,arrt_modi_aggfraz._s.GetCallerStringVar('w_AMMONT'));
m_Caller.SetNumber('w_RIMP','N',0,0,arrt_modi_aggfraz._s.GetCallerDoubleVar('w_RIMP'));
m_Caller.SetString('w_AREAGEO','C',0,0,arrt_modi_aggfraz._s.GetCallerStringVar('w_AREAGEO'));
m_Caller.SetNumber('w_RAREA','N',0,0,arrt_modi_aggfraz._s.GetCallerDoubleVar('w_RAREA'));
m_Caller.SetString('w_MODSVOL','C',0,0,arrt_modi_aggfraz._s.GetCallerStringVar('w_MODSVOL'));
m_Caller.SetNumber('w_RCOMP','N',0,0,arrt_modi_aggfraz._s.GetCallerDoubleVar('w_RCOMP'));
m_Caller.SetString('w_RAGIO','C',0,0,arrt_modi_aggfraz._s.GetCallerStringVar('w_RAGIO'));
m_Caller.SetNumber('w_RRAGIO','N',0,0,arrt_modi_aggfraz._s.GetCallerDoubleVar('w_RRAGIO'));
m_Caller.SetString('w_TIPO','C',0,0,arrt_modi_aggfraz._s.GetCallerStringVar('w_TIPO'));
m_Caller.SetNumber('w_RTIPO','N',0,0,arrt_modi_aggfraz._s.GetCallerDoubleVar('w_RTIPO'));
m_Caller.SetNumber('w_NOPROT','N',0,0,arrt_modi_aggfraz._s.GetCallerDoubleVar('w_NOPROT'));
m_Caller.SetString('w_OPERAG','C',0,0,arrt_modi_aggfraz._s.GetCallerStringVar('w_OPERAG'));
m_Caller.SetString('w_RESPINS','C',0,0,arrt_modi_aggfraz._s.GetCallerStringVar('w_RESPINS'));
m_Caller.SetString('w_SCOPO','C',0,0,arrt_modi_aggfraz._s.GetCallerStringVar('w_SCOPO'));
m_Caller.SetString('w_NATURA','C',0,0,arrt_modi_aggfraz._s.GetCallerStringVar('w_NATURA'));
m_Caller.SetString('w_INFORM','C',0,0,arrt_modi_aggfraz._s.GetCallerStringVar('w_INFORM'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_modi_aggfraz._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_modi_aggfraz.CtxLoad_ = function(){return []}
