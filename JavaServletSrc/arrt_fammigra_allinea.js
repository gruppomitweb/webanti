function arrt_fammigra_allinea() {
var w_dadata;
var w_a_data;
var m_Caller
arrt_fammigra_allinea._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_dadata=NullDate();
w_a_data=NullDate();
}
if(arrt_fammigra_allinea._p.length>0)_rargs([[['w_dadata',arrt_fammigra_allinea._p[0]],['w_a_data',arrt_fammigra_allinea._p[1]]]],{eval:function(e){eval(e)}})
arrt_fammigra_allinea._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_fammigra_allinea._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_fammigra_allinea._s.SetParameterString('w_dadata',WtA(w_dadata,'D'));
arrt_fammigra_allinea._s.SetParameterString('w_a_data',WtA(w_a_data,'D'));
arrt_fammigra_allinea._s.SetParameterString('m_bApplet','true');
arrt_fammigra_allinea._s.CallServlet('arrt_fammigra_allinea');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_fammigra_allinea._s.errmsg;
}
return arrt_fammigra_allinea._s.GetString();
}
arrt_fammigra_allinea.CtxLoad_ = function(){return []}
