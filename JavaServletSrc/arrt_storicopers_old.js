function arrt_storicopers_old() {
var w_CONNES;
var w_DATARETT;
var m_Caller
arrt_storicopers_old._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_CONNES='';
w_DATARETT=NullDate();
}
if(arrt_storicopers_old._p.length>0)_rargs([[['w_CONNES',arrt_storicopers_old._p[0]],['w_DATARETT',arrt_storicopers_old._p[1]]]],{eval:function(e){eval(e)}})
arrt_storicopers_old._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_storicopers_old._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_storicopers_old._s.SetParameterString('w_CONNES',WtA(w_CONNES,'C'));
arrt_storicopers_old._s.SetParameterString('w_DATARETT',WtA(w_DATARETT,'D'));
arrt_storicopers_old._s.SetParameterString('m_bApplet','true');
arrt_storicopers_old._s.CallServlet('arrt_storicopers_old');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_storicopers_old._s.errmsg;
}
}
arrt_storicopers_old.CtxLoad_ = function(){return []}
