function arfn_ae_chkdel() {
var pIDB;
var pTipo;
var m_Caller
arfn_ae_chkdel._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pIDB='';
pTipo='';
}
if(arfn_ae_chkdel._p.length>0)_rargs([[['pIDB',arfn_ae_chkdel._p[0]],['pTipo',arfn_ae_chkdel._p[1]]]],{eval:function(e){eval(e)}})
arfn_ae_chkdel._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_ae_chkdel._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_ae_chkdel._s.SetParameterString('pIDB',WtA(pIDB,'C'));
arfn_ae_chkdel._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_ae_chkdel._s.SetParameterString('m_bApplet','true');
arfn_ae_chkdel._s.CallServlet('arfn_ae_chkdel');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_ae_chkdel._s.errmsg;
}
return arfn_ae_chkdel._s.GetBoolean();
}
arfn_ae_chkdel.CtxLoad_ = function(){return []}
