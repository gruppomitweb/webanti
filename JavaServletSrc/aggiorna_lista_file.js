function aggiorna_lista_file() {
var m_Caller
aggiorna_lista_file._p=_rargs(arguments,{eval:function(e){eval(e)}})
aggiorna_lista_file._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
aggiorna_lista_file._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
aggiorna_lista_file._s.SetParameterString('m_bApplet','true');
aggiorna_lista_file._s.CallServlet('aggiorna_lista_file');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=aggiorna_lista_file._s.errmsg;
}
}
aggiorna_lista_file.CtxLoad_ = function(){return []}
