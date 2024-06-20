function arfn_view_soct() {
var pDatOpe;
var pTipOpe;
var pField;
var m_Caller
arfn_view_soct._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDatOpe=NullDate();
pTipOpe='';
pField='';
}
if(arfn_view_soct._p.length>0)_rargs([[['pDatOpe',arfn_view_soct._p[0]],['pTipOpe',arfn_view_soct._p[1]],['pField',arfn_view_soct._p[2]]]],{eval:function(e){eval(e)}})
arfn_view_soct._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_view_soct._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_view_soct._s.SetParameterString('pDatOpe',WtA(pDatOpe,'D'));
arfn_view_soct._s.SetParameterString('pTipOpe',WtA(pTipOpe,'C'));
arfn_view_soct._s.SetParameterString('pField',WtA(pField,'C'));
arfn_view_soct._s.SetParameterString('m_bApplet','true');
arfn_view_soct._s.CallServlet('arfn_view_soct');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_view_soct._s.errmsg;
}
return arfn_view_soct._s.GetBoolean();
}
arfn_view_soct.CtxLoad_ = function(){return []}
