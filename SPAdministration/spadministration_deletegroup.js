function spadministration_deletegroup() {
var idfolder;
var m_Caller
spadministration_deletegroup._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
idfolder=0;
}
if(spadministration_deletegroup._p.length>0)_rargs([[['idfolder',spadministration_deletegroup._p[0]]]],{eval:function(e){eval(e)}})
spadministration_deletegroup._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spadministration_deletegroup._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spadministration_deletegroup._s.SetParameterString('idfolder',WtA(idfolder,'N'));
spadministration_deletegroup._s.SetParameterString('m_bApplet','true');
spadministration_deletegroup._s.CallServlet('spadministration_deletegroup');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spadministration_deletegroup._s.errmsg;
}
return spadministration_deletegroup._s.GetBoolean();
}
spadministration_deletegroup.CtxLoad_ = function(){return []}
