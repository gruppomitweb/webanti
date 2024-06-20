function arrt_faminvio() {
var w_anno;
var w_mese;
var w_dadata;
var w_a_data;
var w_flgagg;
var w_flgdel;
var w_flgnew;
var w_flgstp;
var w_flgdett;
var w_flagchiu;
var m_Caller
arrt_faminvio._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_anno=0;
w_mese='';
w_dadata=NullDate();
w_a_data=NullDate();
w_flgagg='';
w_flgdel='';
w_flgnew='';
w_flgstp='';
w_flgdett='';
w_flagchiu='';
}
if(arrt_faminvio._p.length>0)_rargs([[['w_anno',arrt_faminvio._p[0]],['w_mese',arrt_faminvio._p[1]],['w_dadata',arrt_faminvio._p[2]],['w_a_data',arrt_faminvio._p[3]],['w_flgagg',arrt_faminvio._p[4]],['w_flgdel',arrt_faminvio._p[5]],['w_flgnew',arrt_faminvio._p[6]],['w_flgstp',arrt_faminvio._p[7]],['w_flgdett',arrt_faminvio._p[8]],['w_flagchiu',arrt_faminvio._p[9]]]],{eval:function(e){eval(e)}})
arrt_faminvio._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_faminvio._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_faminvio._s.SetParameterString('w_anno',WtA(w_anno,'N'));
arrt_faminvio._s.SetParameterString('w_mese',WtA(w_mese,'C'));
arrt_faminvio._s.SetParameterString('w_dadata',WtA(w_dadata,'D'));
arrt_faminvio._s.SetParameterString('w_a_data',WtA(w_a_data,'D'));
arrt_faminvio._s.SetParameterString('w_flgagg',WtA(w_flgagg,'C'));
arrt_faminvio._s.SetParameterString('w_flgdel',WtA(w_flgdel,'C'));
arrt_faminvio._s.SetParameterString('w_flgnew',WtA(w_flgnew,'C'));
arrt_faminvio._s.SetParameterString('w_flgstp',WtA(w_flgstp,'C'));
arrt_faminvio._s.SetParameterString('w_flgdett',WtA(w_flgdett,'C'));
arrt_faminvio._s.SetParameterString('w_flagchiu',WtA(w_flagchiu,'C'));
arrt_faminvio._s.SetParameterString('m_bApplet','true');
arrt_faminvio._s.CallServlet('arrt_faminvio');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_faminvio._s.errmsg;
}
return arrt_faminvio._s.GetString();
}
arrt_faminvio.CtxLoad_ = function(){return []}
