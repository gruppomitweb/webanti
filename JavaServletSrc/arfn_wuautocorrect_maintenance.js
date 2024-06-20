function arfn_wuautocorrect_maintenance() {
var mcRecord;
var m_Caller
arfn_wuautocorrect_maintenance._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
}
if(arfn_wuautocorrect_maintenance._p.length>0)_rargs([[['mcRecord',arfn_wuautocorrect_maintenance._p[0]]]],{eval:function(e){eval(e)}})
arfn_wuautocorrect_maintenance._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_wuautocorrect_maintenance._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_wuautocorrect_maintenance._s.SetParameterString('mcRecord',WtA(mcRecord,'MC'),mcRecord);
arfn_wuautocorrect_maintenance._s.SetParameterString('m_bApplet','true');
arfn_wuautocorrect_maintenance._s.CallServlet('arfn_wuautocorrect_maintenance');
mcRecord._Copy(arfn_wuautocorrect_maintenance._s.GetCallerMemoryCursorVar('mcRecord'))
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_wuautocorrect_maintenance._s.errmsg;
}
return arfn_wuautocorrect_maintenance._s.GetString();
}
arfn_wuautocorrect_maintenance.CtxLoad_ = function(){return []}
