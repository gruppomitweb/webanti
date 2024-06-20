function arfn_storicoxbrl() {
var pAnno;
var pMese;
var pTipo;
var m_Caller
arfn_storicoxbrl._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pAnno='';
pMese='';
pTipo='';
}
if(arfn_storicoxbrl._p.length>0)_rargs([[['pAnno',arfn_storicoxbrl._p[0]],['pMese',arfn_storicoxbrl._p[1]],['pTipo',arfn_storicoxbrl._p[2]]]],{eval:function(e){eval(e)}})
arfn_storicoxbrl._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_storicoxbrl._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_storicoxbrl._s.SetParameterString('pAnno',WtA(pAnno,'C'));
arfn_storicoxbrl._s.SetParameterString('pMese',WtA(pMese,'C'));
arfn_storicoxbrl._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_storicoxbrl._s.SetParameterString('m_bApplet','true');
arfn_storicoxbrl._s.CallServlet('arfn_storicoxbrl');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_storicoxbrl._s.errmsg;
}
return arfn_storicoxbrl._s.GetString();
}
arfn_storicoxbrl.CtxLoad_ = function(){return []}
