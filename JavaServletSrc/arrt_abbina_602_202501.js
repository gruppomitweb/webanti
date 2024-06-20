function arrt_abbina_602_202501() {
var pOper;
var m_Caller
arrt_abbina_602_202501._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pOper='';
}
if(arrt_abbina_602_202501._p.length>0)_rargs([[['pOper',arrt_abbina_602_202501._p[0]]]],{eval:function(e){eval(e)}})
arrt_abbina_602_202501._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_abbina_602_202501._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_abbina_602_202501._s.SetParameterString('pOper',WtA(pOper,'C'));
arrt_abbina_602_202501._s.SetParameterString('m_bApplet','true');
arrt_abbina_602_202501._s.CallServlet('arrt_abbina_602_202501');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_abbina_602_202501._s.errmsg;
}
return arrt_abbina_602_202501._s.GetBoolean();
}
arrt_abbina_602_202501.CtxLoad_ = function(){return []}
