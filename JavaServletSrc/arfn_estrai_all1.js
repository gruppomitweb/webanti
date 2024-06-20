function arfn_estrai_all1() {
var w_DaData;
var w_AData;
var w_codage;
var w_codcli;
var w_rapporto;
var w_flgope;
var w_flgrap;
var w_flgfrz;
var w_flgordine;
var w_stoper;
var w_tipout;
var w_rappAttivSel;
var m_Caller
arfn_estrai_all1._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_DaData=NullDate();
w_AData=NullDate();
w_codage='';
w_codcli='';
w_rapporto='';
w_flgope='';
w_flgrap='';
w_flgfrz='';
w_flgordine='';
w_stoper='';
w_tipout='';
w_rappAttivSel='';
}
if(arfn_estrai_all1._p.length>0)_rargs([[['w_DaData',arfn_estrai_all1._p[0]],['w_AData',arfn_estrai_all1._p[1]],['w_codage',arfn_estrai_all1._p[2]],['w_codcli',arfn_estrai_all1._p[3]],['w_rapporto',arfn_estrai_all1._p[4]],['w_flgope',arfn_estrai_all1._p[5]],['w_flgrap',arfn_estrai_all1._p[6]],['w_flgfrz',arfn_estrai_all1._p[7]],['w_flgordine',arfn_estrai_all1._p[8]],['w_stoper',arfn_estrai_all1._p[9]],['w_tipout',arfn_estrai_all1._p[10]],['w_rappAttivSel',arfn_estrai_all1._p[11]]]],{eval:function(e){eval(e)}})
arfn_estrai_all1._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_estrai_all1._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_estrai_all1._s.SetParameterString('w_DaData',WtA(w_DaData,'D'));
arfn_estrai_all1._s.SetParameterString('w_AData',WtA(w_AData,'D'));
arfn_estrai_all1._s.SetParameterString('w_codage',WtA(w_codage,'C'));
arfn_estrai_all1._s.SetParameterString('w_codcli',WtA(w_codcli,'C'));
arfn_estrai_all1._s.SetParameterString('w_rapporto',WtA(w_rapporto,'C'));
arfn_estrai_all1._s.SetParameterString('w_flgope',WtA(w_flgope,'C'));
arfn_estrai_all1._s.SetParameterString('w_flgrap',WtA(w_flgrap,'C'));
arfn_estrai_all1._s.SetParameterString('w_flgfrz',WtA(w_flgfrz,'C'));
arfn_estrai_all1._s.SetParameterString('w_flgordine',WtA(w_flgordine,'C'));
arfn_estrai_all1._s.SetParameterString('w_stoper',WtA(w_stoper,'C'));
arfn_estrai_all1._s.SetParameterString('w_tipout',WtA(w_tipout,'C'));
arfn_estrai_all1._s.SetParameterString('w_rappAttivSel',WtA(w_rappAttivSel,'C'));
arfn_estrai_all1._s.SetParameterString('m_bApplet','true');
arfn_estrai_all1._s.CallServlet('arfn_estrai_all1');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_estrai_all1._s.errmsg;
}
return arfn_estrai_all1._s.GetString();
}
arfn_estrai_all1.CtxLoad_ = function(){return []}
