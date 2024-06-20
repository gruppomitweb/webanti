function arrt_import_3dce() {
var w_msgproc;
var w_tbareegeog;
var w_tbspecie;
var w_tbtiporisc;
var w_tbsvolgim;
var w_tbcondotta;
var w_tbimporto;
var w_tbdurata;
var w_tbplauso;
var w_tbtipatt;
var m_Caller
arrt_import_3dce._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_msgproc=m_Caller.GetString('w_msgproc','M',0,0);
w_tbareegeog=m_Caller.GetString('w_tbareegeog','C',0,0);
w_tbspecie=m_Caller.GetString('w_tbspecie','C',0,0);
w_tbtiporisc=m_Caller.GetString('w_tbtiporisc','C',0,0);
w_tbsvolgim=m_Caller.GetString('w_tbsvolgim','C',0,0);
w_tbcondotta=m_Caller.GetString('w_tbcondotta','C',0,0);
w_tbimporto=m_Caller.GetString('w_tbimporto','C',0,0);
w_tbdurata=m_Caller.GetString('w_tbdurata','C',0,0);
w_tbplauso=m_Caller.GetString('w_tbplauso','C',0,0);
w_tbtipatt=m_Caller.GetString('w_tbtipatt','C',0,0);
arrt_import_3dce._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_import_3dce._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_import_3dce._s.SetCallerStringVar('w_msgproc',WtA(w_msgproc,'M'));
arrt_import_3dce._s.SetCallerStringVar('w_tbareegeog',WtA(w_tbareegeog,'C'));
arrt_import_3dce._s.SetCallerStringVar('w_tbspecie',WtA(w_tbspecie,'C'));
arrt_import_3dce._s.SetCallerStringVar('w_tbtiporisc',WtA(w_tbtiporisc,'C'));
arrt_import_3dce._s.SetCallerStringVar('w_tbsvolgim',WtA(w_tbsvolgim,'C'));
arrt_import_3dce._s.SetCallerStringVar('w_tbcondotta',WtA(w_tbcondotta,'C'));
arrt_import_3dce._s.SetCallerStringVar('w_tbimporto',WtA(w_tbimporto,'C'));
arrt_import_3dce._s.SetCallerStringVar('w_tbdurata',WtA(w_tbdurata,'C'));
arrt_import_3dce._s.SetCallerStringVar('w_tbplauso',WtA(w_tbplauso,'C'));
arrt_import_3dce._s.SetCallerStringVar('w_tbtipatt',WtA(w_tbtipatt,'C'));
arrt_import_3dce._s.SetParameterString('m_bApplet','true');
arrt_import_3dce._s.CallServlet('arrt_import_3dce');
m_Caller.SetString('w_msgproc','M',0,0,arrt_import_3dce._s.GetCallerStringVar('w_msgproc'));
m_Caller.SetString('w_tbareegeog','C',0,0,arrt_import_3dce._s.GetCallerStringVar('w_tbareegeog'));
m_Caller.SetString('w_tbspecie','C',0,0,arrt_import_3dce._s.GetCallerStringVar('w_tbspecie'));
m_Caller.SetString('w_tbtiporisc','C',0,0,arrt_import_3dce._s.GetCallerStringVar('w_tbtiporisc'));
m_Caller.SetString('w_tbsvolgim','C',0,0,arrt_import_3dce._s.GetCallerStringVar('w_tbsvolgim'));
m_Caller.SetString('w_tbcondotta','C',0,0,arrt_import_3dce._s.GetCallerStringVar('w_tbcondotta'));
m_Caller.SetString('w_tbimporto','C',0,0,arrt_import_3dce._s.GetCallerStringVar('w_tbimporto'));
m_Caller.SetString('w_tbdurata','C',0,0,arrt_import_3dce._s.GetCallerStringVar('w_tbdurata'));
m_Caller.SetString('w_tbplauso','C',0,0,arrt_import_3dce._s.GetCallerStringVar('w_tbplauso'));
m_Caller.SetString('w_tbtipatt','C',0,0,arrt_import_3dce._s.GetCallerStringVar('w_tbtipatt'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_import_3dce._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_import_3dce.CtxLoad_ = function(){return []}
