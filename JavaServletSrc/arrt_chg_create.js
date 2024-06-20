function arrt_chg_create() {
var w_oldcon;
var w_datvar;
var w_flgoper;
var w_flgfraz;
var w_flg3132;
var w_flg5455;
var w_flgleg;
var w_flgrap;
var w_DaData;
var w_A_Data;
var m_Caller
arrt_chg_create._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_oldcon='';
w_datvar=NullDate();
w_flgoper='';
w_flgfraz='';
w_flg3132='';
w_flg5455='';
w_flgleg='';
w_flgrap='';
w_DaData=NullDate();
w_A_Data=NullDate();
}
if(arrt_chg_create._p.length>0)_rargs([[['w_oldcon',arrt_chg_create._p[0]],['w_datvar',arrt_chg_create._p[1]],['w_flgoper',arrt_chg_create._p[2]],['w_flgfraz',arrt_chg_create._p[3]],['w_flg3132',arrt_chg_create._p[4]],['w_flg5455',arrt_chg_create._p[5]],['w_flgleg',arrt_chg_create._p[6]],['w_flgrap',arrt_chg_create._p[7]],['w_DaData',arrt_chg_create._p[8]],['w_A_Data',arrt_chg_create._p[9]]]],{eval:function(e){eval(e)}})
arrt_chg_create._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_chg_create._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_chg_create._s.SetParameterString('w_oldcon',WtA(w_oldcon,'C'));
arrt_chg_create._s.SetParameterString('w_datvar',WtA(w_datvar,'D'));
arrt_chg_create._s.SetParameterString('w_flgoper',WtA(w_flgoper,'C'));
arrt_chg_create._s.SetParameterString('w_flgfraz',WtA(w_flgfraz,'C'));
arrt_chg_create._s.SetParameterString('w_flg3132',WtA(w_flg3132,'C'));
arrt_chg_create._s.SetParameterString('w_flg5455',WtA(w_flg5455,'C'));
arrt_chg_create._s.SetParameterString('w_flgleg',WtA(w_flgleg,'C'));
arrt_chg_create._s.SetParameterString('w_flgrap',WtA(w_flgrap,'C'));
arrt_chg_create._s.SetParameterString('w_DaData',WtA(w_DaData,'D'));
arrt_chg_create._s.SetParameterString('w_A_Data',WtA(w_A_Data,'D'));
arrt_chg_create._s.SetParameterString('m_bApplet','true');
arrt_chg_create._s.CallServlet('arrt_chg_create');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_chg_create._s.errmsg;
}
return arrt_chg_create._s.GetString();
}
arrt_chg_create.CtxLoad_ = function(){return []}
