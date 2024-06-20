function arrt_wu_chkimp() {
var w_WUCODMAGE;
var m_Caller
arrt_wu_chkimp._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_WUCODMAGE='';
}
if(arrt_wu_chkimp._p.length>0)_rargs([[['w_WUCODMAGE',arrt_wu_chkimp._p[0]]]],{eval:function(e){eval(e)}})
arrt_wu_chkimp._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_wu_chkimp._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_wu_chkimp._s.SetParameterString('w_WUCODMAGE',WtA(w_WUCODMAGE,'C'));
arrt_wu_chkimp._s.SetParameterString('m_bApplet','true');
arrt_wu_chkimp._s.CallServlet('arrt_wu_chkimp');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_wu_chkimp._s.errmsg;
}
}
arrt_wu_chkimp.CtxLoad_ = function(){return []}
