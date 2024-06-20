function arrt_abbina_602_202501_save() {
var mcValues;
var m_Caller
arrt_abbina_602_202501_save._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
}
if(arrt_abbina_602_202501_save._p.length>0)_rargs([[['mcValues',arrt_abbina_602_202501_save._p[0]]]],{eval:function(e){eval(e)}})
arrt_abbina_602_202501_save._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_abbina_602_202501_save._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_abbina_602_202501_save._s.SetParameterString('mcValues',WtA(mcValues,'MC'),mcValues);
arrt_abbina_602_202501_save._s.SetParameterString('m_bApplet','true');
arrt_abbina_602_202501_save._s.CallServlet('arrt_abbina_602_202501_save');
mcValues._Copy(arrt_abbina_602_202501_save._s.GetCallerMemoryCursorVar('mcValues'))
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_abbina_602_202501_save._s.errmsg;
}
return arrt_abbina_602_202501_save._s.GetBoolean();
}
arrt_abbina_602_202501_save.CtxLoad_ = function(){return []}
