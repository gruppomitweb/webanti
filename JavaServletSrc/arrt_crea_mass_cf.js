function arrt_crea_mass_cf() {
var w_tiposog;
var w_tipoinv;
var w_maxinvii;
var w_a2013;
var w_a2014;
var w_a2015;
var w_a2016;
var w_a2017;
var w_a2018;
var w_a2019;
var w_a2020;
var w_a2021;
var w_a2022;
var m_Caller
arrt_crea_mass_cf._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_tiposog='';
w_tipoinv='';
w_maxinvii=0;
w_a2013='';
w_a2014='';
w_a2015='';
w_a2016='';
w_a2017='';
w_a2018='';
w_a2019='';
w_a2020='';
w_a2021='';
w_a2022='';
}
if(arrt_crea_mass_cf._p.length>0)_rargs([[['w_tiposog',arrt_crea_mass_cf._p[0]],['w_tipoinv',arrt_crea_mass_cf._p[1]],['w_maxinvii',arrt_crea_mass_cf._p[2]],['w_a2013',arrt_crea_mass_cf._p[3]],['w_a2014',arrt_crea_mass_cf._p[4]],['w_a2015',arrt_crea_mass_cf._p[5]],['w_a2016',arrt_crea_mass_cf._p[6]],['w_a2017',arrt_crea_mass_cf._p[7]],['w_a2018',arrt_crea_mass_cf._p[8]],['w_a2019',arrt_crea_mass_cf._p[9]],['w_a2020',arrt_crea_mass_cf._p[10]],['w_a2021',arrt_crea_mass_cf._p[11]],['w_a2022',arrt_crea_mass_cf._p[12]]]],{eval:function(e){eval(e)}})
arrt_crea_mass_cf._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_crea_mass_cf._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_crea_mass_cf._s.SetParameterString('w_tiposog',WtA(w_tiposog,'C'));
arrt_crea_mass_cf._s.SetParameterString('w_tipoinv',WtA(w_tipoinv,'C'));
arrt_crea_mass_cf._s.SetParameterString('w_maxinvii',WtA(w_maxinvii,'N'));
arrt_crea_mass_cf._s.SetParameterString('w_a2013',WtA(w_a2013,'C'));
arrt_crea_mass_cf._s.SetParameterString('w_a2014',WtA(w_a2014,'C'));
arrt_crea_mass_cf._s.SetParameterString('w_a2015',WtA(w_a2015,'C'));
arrt_crea_mass_cf._s.SetParameterString('w_a2016',WtA(w_a2016,'C'));
arrt_crea_mass_cf._s.SetParameterString('w_a2017',WtA(w_a2017,'C'));
arrt_crea_mass_cf._s.SetParameterString('w_a2018',WtA(w_a2018,'C'));
arrt_crea_mass_cf._s.SetParameterString('w_a2019',WtA(w_a2019,'C'));
arrt_crea_mass_cf._s.SetParameterString('w_a2020',WtA(w_a2020,'C'));
arrt_crea_mass_cf._s.SetParameterString('w_a2021',WtA(w_a2021,'C'));
arrt_crea_mass_cf._s.SetParameterString('w_a2022',WtA(w_a2022,'C'));
arrt_crea_mass_cf._s.SetParameterString('m_bApplet','true');
arrt_crea_mass_cf._s.CallServlet('arrt_crea_mass_cf');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_crea_mass_cf._s.errmsg;
}
return arrt_crea_mass_cf._s.GetString();
}
arrt_crea_mass_cf.CtxLoad_ = function(){return []}
