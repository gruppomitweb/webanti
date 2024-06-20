function arrt_wu_stp_rapporti() {
var w_codrap;
var w_WUCODMAGE;
var w_xDESCRAP;
var w_xMADESCRI;
var m_Caller
arrt_wu_stp_rapporti._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_codrap='';
w_WUCODMAGE='';
w_xDESCRAP='';
w_xMADESCRI='';
}
if(arrt_wu_stp_rapporti._p.length>0)_rargs([[['w_codrap',arrt_wu_stp_rapporti._p[0]],['w_WUCODMAGE',arrt_wu_stp_rapporti._p[1]],['w_xDESCRAP',arrt_wu_stp_rapporti._p[2]],['w_xMADESCRI',arrt_wu_stp_rapporti._p[3]]]],{eval:function(e){eval(e)}})
arrt_wu_stp_rapporti._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_wu_stp_rapporti._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_wu_stp_rapporti._s.SetParameterString('w_codrap',WtA(w_codrap,'C'));
arrt_wu_stp_rapporti._s.SetParameterString('w_WUCODMAGE',WtA(w_WUCODMAGE,'C'));
arrt_wu_stp_rapporti._s.SetParameterString('w_xDESCRAP',WtA(w_xDESCRAP,'C'));
arrt_wu_stp_rapporti._s.SetParameterString('w_xMADESCRI',WtA(w_xMADESCRI,'C'));
arrt_wu_stp_rapporti._s.SetParameterString('m_bApplet','true');
arrt_wu_stp_rapporti._s.CallServlet('arrt_wu_stp_rapporti');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_wu_stp_rapporti._s.errmsg;
}
return arrt_wu_stp_rapporti._s.GetString();
}
arrt_wu_stp_rapporti.CtxLoad_ = function(){return []}
