function arrt_fammigra_stp() {
var w_dadata;
var w_a_data;
var w_flgwrt;
var w_flgnoe;
var m_Caller
arrt_fammigra_stp._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_dadata=NullDate();
w_a_data=NullDate();
w_flgwrt='';
w_flgnoe='';
}
if(arrt_fammigra_stp._p.length>0)_rargs([[['w_dadata',arrt_fammigra_stp._p[0]],['w_a_data',arrt_fammigra_stp._p[1]],['w_flgwrt',arrt_fammigra_stp._p[2]],['w_flgnoe',arrt_fammigra_stp._p[3]]]],{eval:function(e){eval(e)}})
arrt_fammigra_stp._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_fammigra_stp._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_fammigra_stp._s.SetParameterString('w_dadata',WtA(w_dadata,'D'));
arrt_fammigra_stp._s.SetParameterString('w_a_data',WtA(w_a_data,'D'));
arrt_fammigra_stp._s.SetParameterString('w_flgwrt',WtA(w_flgwrt,'C'));
arrt_fammigra_stp._s.SetParameterString('w_flgnoe',WtA(w_flgnoe,'C'));
arrt_fammigra_stp._s.SetParameterString('m_bApplet','true');
arrt_fammigra_stp._s.CallServlet('arrt_fammigra_stp');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_fammigra_stp._s.errmsg;
}
return arrt_fammigra_stp._s.GetString();
}
arrt_fammigra_stp.CtxLoad_ = function(){return []}
