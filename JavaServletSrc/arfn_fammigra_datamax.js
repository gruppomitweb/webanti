function arfn_fammigra_datamax() {
var pData;
var m_Caller
arfn_fammigra_datamax._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pData=NullDate();
}
if(arfn_fammigra_datamax._p.length>0)_rargs([[['pData',arfn_fammigra_datamax._p[0]]]],{eval:function(e){eval(e)}})
arfn_fammigra_datamax._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_fammigra_datamax._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_fammigra_datamax._s.SetParameterString('pData',WtA(pData,'D'));
arfn_fammigra_datamax._s.SetParameterString('m_bApplet','true');
arfn_fammigra_datamax._s.CallServlet('arfn_fammigra_datamax');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_fammigra_datamax._s.errmsg;
}
return DateFromApplet(arfn_fammigra_datamax._s.GetDate());
}
arfn_fammigra_datamax.CtxLoad_ = function(){return []}
