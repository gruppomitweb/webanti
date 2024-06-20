function arrt_modi_aggpers() {
var w_CONNES;
var w_AREAGEO;
var w_BANCABEN;
var w_COMPORT;
var w_PKTBSPECIE;
var w_RAREA;
var w_RCOMP;
var w_RNATGIU;
var w_CITTADIN1;
var w_CITTADIN2;
var w_RESFISC;
var w_MITIG;
var w_MITGDOC;
var m_Caller
arrt_modi_aggpers._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_CONNES=m_Caller.GetString('w_CONNES','C',0,0);
w_AREAGEO=m_Caller.GetString('w_AREAGEO','C',0,0);
w_BANCABEN=m_Caller.GetString('w_BANCABEN','C',0,0);
w_COMPORT=m_Caller.GetString('w_COMPORT','C',0,0);
w_PKTBSPECIE=m_Caller.GetString('w_PKTBSPECIE','C',0,0);
w_RAREA=m_Caller.GetNumber('w_RAREA','N',0,0);
w_RCOMP=m_Caller.GetNumber('w_RCOMP','N',0,0);
w_RNATGIU=m_Caller.GetNumber('w_RNATGIU','N',0,0);
w_CITTADIN1=m_Caller.GetString('w_CITTADIN1','C',0,0);
w_CITTADIN2=m_Caller.GetString('w_CITTADIN2','C',0,0);
w_RESFISC=m_Caller.GetString('w_RESFISC','C',0,0);
w_MITIG=m_Caller.GetNumber('w_MITIG','N',0,0);
w_MITGDOC=m_Caller.GetString('w_MITGDOC','C',0,0);
arrt_modi_aggpers._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_modi_aggpers._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_modi_aggpers._s.SetCallerStringVar('w_CONNES',WtA(w_CONNES,'C'));
arrt_modi_aggpers._s.SetCallerStringVar('w_AREAGEO',WtA(w_AREAGEO,'C'));
arrt_modi_aggpers._s.SetCallerStringVar('w_BANCABEN',WtA(w_BANCABEN,'C'));
arrt_modi_aggpers._s.SetCallerStringVar('w_COMPORT',WtA(w_COMPORT,'C'));
arrt_modi_aggpers._s.SetCallerStringVar('w_PKTBSPECIE',WtA(w_PKTBSPECIE,'C'));
arrt_modi_aggpers._s.SetCallerStringVar('w_RAREA',WtA(w_RAREA,'N'));
arrt_modi_aggpers._s.SetCallerStringVar('w_RCOMP',WtA(w_RCOMP,'N'));
arrt_modi_aggpers._s.SetCallerStringVar('w_RNATGIU',WtA(w_RNATGIU,'N'));
arrt_modi_aggpers._s.SetCallerStringVar('w_CITTADIN1',WtA(w_CITTADIN1,'C'));
arrt_modi_aggpers._s.SetCallerStringVar('w_CITTADIN2',WtA(w_CITTADIN2,'C'));
arrt_modi_aggpers._s.SetCallerStringVar('w_RESFISC',WtA(w_RESFISC,'C'));
arrt_modi_aggpers._s.SetCallerStringVar('w_MITIG',WtA(w_MITIG,'N'));
arrt_modi_aggpers._s.SetCallerStringVar('w_MITGDOC',WtA(w_MITGDOC,'C'));
arrt_modi_aggpers._s.SetParameterString('m_bApplet','true');
arrt_modi_aggpers._s.CallServlet('arrt_modi_aggpers');
m_Caller.SetString('w_CONNES','C',0,0,arrt_modi_aggpers._s.GetCallerStringVar('w_CONNES'));
m_Caller.SetString('w_AREAGEO','C',0,0,arrt_modi_aggpers._s.GetCallerStringVar('w_AREAGEO'));
m_Caller.SetString('w_BANCABEN','C',0,0,arrt_modi_aggpers._s.GetCallerStringVar('w_BANCABEN'));
m_Caller.SetString('w_COMPORT','C',0,0,arrt_modi_aggpers._s.GetCallerStringVar('w_COMPORT'));
m_Caller.SetString('w_PKTBSPECIE','C',0,0,arrt_modi_aggpers._s.GetCallerStringVar('w_PKTBSPECIE'));
m_Caller.SetNumber('w_RAREA','N',0,0,arrt_modi_aggpers._s.GetCallerDoubleVar('w_RAREA'));
m_Caller.SetNumber('w_RCOMP','N',0,0,arrt_modi_aggpers._s.GetCallerDoubleVar('w_RCOMP'));
m_Caller.SetNumber('w_RNATGIU','N',0,0,arrt_modi_aggpers._s.GetCallerDoubleVar('w_RNATGIU'));
m_Caller.SetString('w_CITTADIN1','C',0,0,arrt_modi_aggpers._s.GetCallerStringVar('w_CITTADIN1'));
m_Caller.SetString('w_CITTADIN2','C',0,0,arrt_modi_aggpers._s.GetCallerStringVar('w_CITTADIN2'));
m_Caller.SetString('w_RESFISC','C',0,0,arrt_modi_aggpers._s.GetCallerStringVar('w_RESFISC'));
m_Caller.SetNumber('w_MITIG','N',0,0,arrt_modi_aggpers._s.GetCallerDoubleVar('w_MITIG'));
m_Caller.SetString('w_MITGDOC','C',0,0,arrt_modi_aggpers._s.GetCallerStringVar('w_MITGDOC'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_modi_aggpers._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_modi_aggpers.CtxLoad_ = function(){return []}
