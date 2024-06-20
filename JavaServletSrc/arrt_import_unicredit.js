function arrt_import_unicredit() {
var w_tipodest;
var w_nomefile;
var w_codmage;
var m_Caller
arrt_import_unicredit._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_tipodest='';
w_nomefile='';
w_codmage='';
}
if(arrt_import_unicredit._p.length>0)_rargs([[['w_tipodest',arrt_import_unicredit._p[0]],['w_nomefile',arrt_import_unicredit._p[1]],['w_codmage',arrt_import_unicredit._p[2]]]],{eval:function(e){eval(e)}})
arrt_import_unicredit._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_import_unicredit._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_import_unicredit._s.SetParameterString('w_tipodest',WtA(w_tipodest,'C'));
arrt_import_unicredit._s.SetParameterString('w_nomefile',WtA(w_nomefile,'C'));
arrt_import_unicredit._s.SetParameterString('w_codmage',WtA(w_codmage,'C'));
arrt_import_unicredit._s.SetParameterString('m_bApplet','true');
arrt_import_unicredit._s.CallServlet('arrt_import_unicredit');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_import_unicredit._s.errmsg;
}
return arrt_import_unicredit._s.GetString();
}
arrt_import_unicredit.CtxLoad_ = function(){return []}
