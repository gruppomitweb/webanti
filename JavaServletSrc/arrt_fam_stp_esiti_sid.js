function arrt_fam_stp_esiti_sid() {
var FileName;
var m_Caller
arrt_fam_stp_esiti_sid._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
FileName='';
}
if(arrt_fam_stp_esiti_sid._p.length>0)_rargs([[['FileName',arrt_fam_stp_esiti_sid._p[0]]]],{eval:function(e){eval(e)}})
arrt_fam_stp_esiti_sid._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_fam_stp_esiti_sid._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_fam_stp_esiti_sid._s.SetParameterString('FileName',WtA(FileName,'C'));
arrt_fam_stp_esiti_sid._s.SetParameterString('m_bApplet','true');
arrt_fam_stp_esiti_sid._s.CallServlet('arrt_fam_stp_esiti_sid');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_fam_stp_esiti_sid._s.errmsg;
}
}
arrt_fam_stp_esiti_sid.CtxLoad_ = function(){return []}
