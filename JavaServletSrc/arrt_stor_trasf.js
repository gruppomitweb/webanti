function arrt_stor_trasf() {
var w_chi_chiama_la_routine;
var w_tipoope;
var w_anag_colleg;
var w_stampa;
var w_DaDatOpe;
var w_ADatOpe;
var w_today_caller;
var w_chkAUI;
var w_chkAGE;
var m_Caller
arrt_stor_trasf._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_chi_chiama_la_routine='';
w_tipoope='';
w_anag_colleg=false;
w_stampa='';
w_DaDatOpe=NullDate();
w_ADatOpe=NullDate();
w_today_caller=NullDate();
w_chkAUI='';
w_chkAGE='';
}
if(arrt_stor_trasf._p.length>0)_rargs([[['w_chi_chiama_la_routine',arrt_stor_trasf._p[0]],['w_tipoope',arrt_stor_trasf._p[1]],['w_anag_colleg',arrt_stor_trasf._p[2]],['w_stampa',arrt_stor_trasf._p[3]],['w_DaDatOpe',arrt_stor_trasf._p[4]],['w_ADatOpe',arrt_stor_trasf._p[5]],['w_today_caller',arrt_stor_trasf._p[6]],['w_chkAUI',arrt_stor_trasf._p[7]],['w_chkAGE',arrt_stor_trasf._p[8]]]],{eval:function(e){eval(e)}})
arrt_stor_trasf._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_stor_trasf._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_stor_trasf._s.SetParameterString('w_chi_chiama_la_routine',WtA(w_chi_chiama_la_routine,'C'));
arrt_stor_trasf._s.SetParameterString('w_tipoope',WtA(w_tipoope,'C'));
arrt_stor_trasf._s.SetParameterString('w_anag_colleg',WtA(w_anag_colleg,'L'));
arrt_stor_trasf._s.SetParameterString('w_stampa',WtA(w_stampa,'C'));
arrt_stor_trasf._s.SetParameterString('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_stor_trasf._s.SetParameterString('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_stor_trasf._s.SetParameterString('w_today_caller',WtA(w_today_caller,'D'));
arrt_stor_trasf._s.SetParameterString('w_chkAUI',WtA(w_chkAUI,'C'));
arrt_stor_trasf._s.SetParameterString('w_chkAGE',WtA(w_chkAGE,'C'));
arrt_stor_trasf._s.SetParameterString('m_bApplet','true');
arrt_stor_trasf._s.CallServlet('arrt_stor_trasf');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_stor_trasf._s.errmsg;
}
return arrt_stor_trasf._s.GetString();
}
arrt_stor_trasf.CtxLoad_ = function(){return []}
