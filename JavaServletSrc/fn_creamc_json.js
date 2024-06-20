function fn_creamc_json() {
var m_Caller
fn_creamc_json._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
}
if(fn_creamc_json._p.length>0)_rargs([[['pLista',fn_creamc_json._p[0]]]],{eval:function(e){eval(e)}})
fn_creamc_json._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
fn_creamc_json._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
fn_creamc_json._s.SetParameterString('pLista',WtA(pLista,'C'));
fn_creamc_json._s.SetParameterString('m_bApplet','true');
fn_creamc_json._s.CallServlet('fn_creamc_json');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=fn_creamc_json._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=fn_creamc_json._s.errmsg;
fn_creamc_json._res=new CPMemoryCursor();
} else {
fn_creamc_json._res=fn_creamc_json._s.GetMemoryCursor();
}
return fn_creamc_json._res;
}
fn_creamc_json.CtxLoad_ = function(){return []}
