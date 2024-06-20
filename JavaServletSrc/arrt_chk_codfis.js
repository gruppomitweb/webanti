function arrt_chk_codfis() {
var m_Caller
arrt_chk_codfis._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_chk_codfis._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_chk_codfis._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_chk_codfis._s.SetParameterString('m_bApplet','true');
arrt_chk_codfis._s.CallServlet('arrt_chk_codfis');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_chk_codfis._s.errmsg;
}
return arrt_chk_codfis._s.GetString();
}
arrt_chk_codfis.CtxLoad_ = function(){return []}
