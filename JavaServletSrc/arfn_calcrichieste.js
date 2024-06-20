function arfn_calcrichieste() {
var m_Caller
arfn_calcrichieste._p=_rargs(arguments,{eval:function(e){eval(e)}})
arfn_calcrichieste._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_calcrichieste._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_calcrichieste._s.SetParameterString('m_bApplet','true');
arfn_calcrichieste._s.CallServlet('arfn_calcrichieste');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_calcrichieste._s.errmsg;
}
return arfn_calcrichieste._s.GetDouble();
}
arfn_calcrichieste.CtxLoad_ = function(){return []}
