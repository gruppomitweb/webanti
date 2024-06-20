function arfn_read_tipoleg() {
var pID;
var pOper;
var m_Caller
arfn_read_tipoleg._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pID='';
pOper='';
}
if(arfn_read_tipoleg._p.length>0)_rargs([[['pID',arfn_read_tipoleg._p[0]],['pOper',arfn_read_tipoleg._p[1]]]],{eval:function(e){eval(e)}})
arfn_read_tipoleg._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_read_tipoleg._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_read_tipoleg._s.SetParameterString('pID',WtA(pID,'C'));
arfn_read_tipoleg._s.SetParameterString('pOper',WtA(pOper,'C'));
arfn_read_tipoleg._s.SetParameterString('m_bApplet','true');
arfn_read_tipoleg._s.CallServlet('arfn_read_tipoleg');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_read_tipoleg._s.errmsg;
}
return arfn_read_tipoleg._s.GetString();
}
arfn_read_tipoleg.CtxLoad_ = function(){return []}
