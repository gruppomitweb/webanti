function arrt_save_nome_cognome_alliniati() {
var m_Caller
arrt_save_nome_cognome_alliniati._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_save_nome_cognome_alliniati._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_save_nome_cognome_alliniati._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_save_nome_cognome_alliniati._s.SetParameterString('m_bApplet','true');
arrt_save_nome_cognome_alliniati._s.CallServlet('arrt_save_nome_cognome_alliniati');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_save_nome_cognome_alliniati._s.errmsg;
}
}
arrt_save_nome_cognome_alliniati.CtxLoad_ = function(){return []}
