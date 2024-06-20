function arfn_unlock_doc() {
var pID;
var pTipo;
var m_Caller
arfn_unlock_doc._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pID='';
pTipo='';
}
if(arfn_unlock_doc._p.length>0)_rargs([[['pID',arfn_unlock_doc._p[0]],['pTipo',arfn_unlock_doc._p[1]]]],{eval:function(e){eval(e)}})
arfn_unlock_doc._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_unlock_doc._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_unlock_doc._s.SetParameterString('pID',WtA(pID,'C'));
arfn_unlock_doc._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_unlock_doc._s.SetParameterString('m_bApplet','true');
arfn_unlock_doc._s.CallServlet('arfn_unlock_doc');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_unlock_doc._s.errmsg;
}
return arfn_unlock_doc._s.GetString();
}
arfn_unlock_doc.CtxLoad_ = function(){return []}
