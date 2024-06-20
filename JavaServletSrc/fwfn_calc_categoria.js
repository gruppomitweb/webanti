function fwfn_calc_categoria() {
var pCat1;
var pCat2;
var pCat3;
var pCat4;
var pCat5;
var m_Caller
fwfn_calc_categoria._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCat1='';
pCat2='';
pCat3='';
pCat4='';
pCat5='';
}
if(fwfn_calc_categoria._p.length>0)_rargs([[['pCat1',fwfn_calc_categoria._p[0]],['pCat2',fwfn_calc_categoria._p[1]],['pCat3',fwfn_calc_categoria._p[2]],['pCat4',fwfn_calc_categoria._p[3]],['pCat5',fwfn_calc_categoria._p[4]]]],{eval:function(e){eval(e)}})
fwfn_calc_categoria._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
fwfn_calc_categoria._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
fwfn_calc_categoria._s.SetParameterString('pCat1',WtA(pCat1,'C'));
fwfn_calc_categoria._s.SetParameterString('pCat2',WtA(pCat2,'C'));
fwfn_calc_categoria._s.SetParameterString('pCat3',WtA(pCat3,'C'));
fwfn_calc_categoria._s.SetParameterString('pCat4',WtA(pCat4,'C'));
fwfn_calc_categoria._s.SetParameterString('pCat5',WtA(pCat5,'C'));
fwfn_calc_categoria._s.SetParameterString('m_bApplet','true');
fwfn_calc_categoria._s.CallServlet('fwfn_calc_categoria');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=fwfn_calc_categoria._s.errmsg;
}
return fwfn_calc_categoria._s.GetString();
}
fwfn_calc_categoria.CtxLoad_ = function(){return []}
