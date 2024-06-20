function arrt_riordina_info() {
var w_frzuif;
var w_opeage;
var w_opeuif;
var w_rapage;
var w_rapuif;
var m_Caller
arrt_riordina_info._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_frzuif=m_Caller.GetString('w_frzuif','C',0,0);
w_opeage=m_Caller.GetString('w_opeage','C',0,0);
w_opeuif=m_Caller.GetString('w_opeuif','C',0,0);
w_rapage=m_Caller.GetString('w_rapage','C',0,0);
w_rapuif=m_Caller.GetString('w_rapuif','C',0,0);
arrt_riordina_info._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_riordina_info._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_riordina_info._s.SetCallerStringVar('w_frzuif',WtA(w_frzuif,'C'));
arrt_riordina_info._s.SetCallerStringVar('w_opeage',WtA(w_opeage,'C'));
arrt_riordina_info._s.SetCallerStringVar('w_opeuif',WtA(w_opeuif,'C'));
arrt_riordina_info._s.SetCallerStringVar('w_rapage',WtA(w_rapage,'C'));
arrt_riordina_info._s.SetCallerStringVar('w_rapuif',WtA(w_rapuif,'C'));
arrt_riordina_info._s.SetParameterString('m_bApplet','true');
arrt_riordina_info._s.CallServlet('arrt_riordina_info');
m_Caller.SetString('w_frzuif','C',0,0,arrt_riordina_info._s.GetCallerStringVar('w_frzuif'));
m_Caller.SetString('w_opeage','C',0,0,arrt_riordina_info._s.GetCallerStringVar('w_opeage'));
m_Caller.SetString('w_opeuif','C',0,0,arrt_riordina_info._s.GetCallerStringVar('w_opeuif'));
m_Caller.SetString('w_rapage','C',0,0,arrt_riordina_info._s.GetCallerStringVar('w_rapage'));
m_Caller.SetString('w_rapuif','C',0,0,arrt_riordina_info._s.GetCallerStringVar('w_rapuif'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_riordina_info._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_riordina_info.CtxLoad_ = function(){return []}
