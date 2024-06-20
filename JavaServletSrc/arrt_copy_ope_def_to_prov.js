function arrt_copy_ope_def_to_prov() {
var pIDBASE;
var pFONTE;
var m_Caller
arrt_copy_ope_def_to_prov._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pIDBASE='';
pFONTE='';
}
if(arrt_copy_ope_def_to_prov._p.length>0)_rargs([[['pIDBASE',arrt_copy_ope_def_to_prov._p[0]],['pFONTE',arrt_copy_ope_def_to_prov._p[1]]]],{eval:function(e){eval(e)}})
arrt_copy_ope_def_to_prov._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_copy_ope_def_to_prov._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_copy_ope_def_to_prov._s.SetParameterString('pIDBASE',WtA(pIDBASE,'C'));
arrt_copy_ope_def_to_prov._s.SetParameterString('pFONTE',WtA(pFONTE,'C'));
arrt_copy_ope_def_to_prov._s.SetParameterString('m_bApplet','true');
arrt_copy_ope_def_to_prov._s.CallServlet('arrt_copy_ope_def_to_prov');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_copy_ope_def_to_prov._s.errmsg;
}
}
arrt_copy_ope_def_to_prov.CtxLoad_ = function(){return []}
