function arrt_fam_annullafile() {
var w_CODINVIO;
var w_nomefile;
var w_idbase;
var m_Caller
arrt_fam_annullafile._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_CODINVIO='';
w_nomefile='';
w_idbase='';
}
if(arrt_fam_annullafile._p.length>0)_rargs([[['w_CODINVIO',arrt_fam_annullafile._p[0]],['w_nomefile',arrt_fam_annullafile._p[1]],['w_idbase',arrt_fam_annullafile._p[2]]]],{eval:function(e){eval(e)}})
arrt_fam_annullafile._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_fam_annullafile._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_fam_annullafile._s.SetParameterString('w_CODINVIO',WtA(w_CODINVIO,'C'));
arrt_fam_annullafile._s.SetParameterString('w_nomefile',WtA(w_nomefile,'C'));
arrt_fam_annullafile._s.SetParameterString('w_idbase',WtA(w_idbase,'C'));
arrt_fam_annullafile._s.SetParameterString('m_bApplet','true');
arrt_fam_annullafile._s.CallServlet('arrt_fam_annullafile');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_fam_annullafile._s.errmsg;
}
return arrt_fam_annullafile._s.GetString();
}
arrt_fam_annullafile.CtxLoad_ = function(){return []}
