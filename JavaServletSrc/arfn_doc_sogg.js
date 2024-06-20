function arfn_doc_sogg() {
var connes;
var dataope;
var idbase;
var cursore;
var m_Caller
arfn_doc_sogg._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
connes='';
dataope=NullDate();
idbase='';
cursore='';
}
if(arfn_doc_sogg._p.length>0)_rargs([[['connes',arfn_doc_sogg._p[0]],['dataope',arfn_doc_sogg._p[1]],['idbase',arfn_doc_sogg._p[2]],['cursore',arfn_doc_sogg._p[3]]]],{eval:function(e){eval(e)}})
arfn_doc_sogg._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_doc_sogg._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_doc_sogg._s.SetParameterString('connes',WtA(connes,'C'));
arfn_doc_sogg._s.SetParameterString('dataope',WtA(dataope,'D'));
arfn_doc_sogg._s.SetParameterString('idbase',WtA(idbase,'C'));
arfn_doc_sogg._s.SetParameterString('cursore',WtA(cursore,'C'));
arfn_doc_sogg._s.SetParameterString('m_bApplet','true');
arfn_doc_sogg._s.CallServlet('arfn_doc_sogg');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_doc_sogg._s.errmsg;
}
return arfn_doc_sogg._s.GetBoolean();
}
arfn_doc_sogg.CtxLoad_ = function(){return []}
