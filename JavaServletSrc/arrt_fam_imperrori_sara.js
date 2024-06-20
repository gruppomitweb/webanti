function arrt_fam_imperrori_sara() {
var w_nomefile;
var m_Caller
arrt_fam_imperrori_sara._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_nomefile='';
}
if(arrt_fam_imperrori_sara._p.length>0)_rargs([[['w_nomefile',arrt_fam_imperrori_sara._p[0]]]],{eval:function(e){eval(e)}})
arrt_fam_imperrori_sara._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_fam_imperrori_sara._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_fam_imperrori_sara._s.SetParameterString('w_nomefile',WtA(w_nomefile,'C'));
arrt_fam_imperrori_sara._s.SetParameterString('m_bApplet','true');
arrt_fam_imperrori_sara._s.CallServlet('arrt_fam_imperrori_sara');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_fam_imperrori_sara._s.errmsg;
}
return arrt_fam_imperrori_sara._s.GetString();
}
arrt_fam_imperrori_sara.CtxLoad_ = function(){return []}
