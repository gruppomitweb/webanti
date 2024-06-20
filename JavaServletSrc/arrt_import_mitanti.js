function arrt_import_mitanti() {
var pOper;
var pFlg;
var w_msgproc;
var m_Caller
arrt_import_mitanti._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pOper='';
pFlg='';
}
if(arrt_import_mitanti._p.length>0)_rargs([[['pOper',arrt_import_mitanti._p[0]],['pFlg',arrt_import_mitanti._p[1]]]],{eval:function(e){eval(e)}})
w_msgproc=m_Caller.GetString('w_msgproc','M',0,0);
arrt_import_mitanti._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_import_mitanti._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_import_mitanti._s.SetCallerStringVar('w_msgproc',WtA(w_msgproc,'M'));
arrt_import_mitanti._s.SetParameterString('pOper',WtA(pOper,'C'));
arrt_import_mitanti._s.SetParameterString('pFlg',WtA(pFlg,'C'));
arrt_import_mitanti._s.SetParameterString('m_bApplet','true');
arrt_import_mitanti._s.CallServlet('arrt_import_mitanti');
m_Caller.SetString('w_msgproc','M',0,0,arrt_import_mitanti._s.GetCallerStringVar('w_msgproc'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_import_mitanti._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_import_mitanti.CtxLoad_ = function(){return []}
