function arrt_save_newdecoden() {
var pNome;
var pCodice;
var m_Caller
arrt_save_newdecoden._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pNome='';
pCodice='';
}
if(arrt_save_newdecoden._p.length>0)_rargs([[['pNome',arrt_save_newdecoden._p[0]],['pCodice',arrt_save_newdecoden._p[1]]]],{eval:function(e){eval(e)}})
arrt_save_newdecoden._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_save_newdecoden._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_save_newdecoden._s.SetParameterString('pNome',WtA(pNome,'C'));
arrt_save_newdecoden._s.SetParameterString('pCodice',WtA(pCodice,'C'));
arrt_save_newdecoden._s.SetParameterString('m_bApplet','true');
arrt_save_newdecoden._s.CallServlet('arrt_save_newdecoden');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_save_newdecoden._s.errmsg;
}
}
arrt_save_newdecoden.CtxLoad_ = function(){return []}
