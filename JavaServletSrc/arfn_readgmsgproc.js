function arfn_readgmsgproc() {
var m_Caller
arfn_readgmsgproc._p=_rargs(arguments,{eval:function(e){eval(e)}})
arfn_readgmsgproc._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_readgmsgproc._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_readgmsgproc._s.SetParameterString('m_bApplet','true');
arfn_readgmsgproc._s.CallServlet('arfn_readgmsgproc');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_readgmsgproc._s.errmsg;
}
return arfn_readgmsgproc._s.GetString();
}
arfn_readgmsgproc.CtxLoad_ = function(){return []}
