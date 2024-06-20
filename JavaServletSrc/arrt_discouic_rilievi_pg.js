function arrt_discouic_rilievi_pg() {
var w_DaDatOpe;
var w_ADatOpe;
var w_rcoddip;
var w_rabicab;
var w_rcabdip;
var w_rpaecli;
var w_rcabcli;
var w_rcodvoc;
var w_rflglire;
var w_rsegno;
var w_rsetsin;
var w_rpaecon;
var w_rcabcon;
var w_rpaeint;
var w_rcabint;
var w_TipoOper;
var m_Caller
arrt_discouic_rilievi_pg._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_DaDatOpe=NullDate();
w_ADatOpe=NullDate();
w_rcoddip='';
w_rabicab='';
w_rcabdip='';
w_rpaecli='';
w_rcabcli='';
w_rcodvoc='';
w_rflglire='';
w_rsegno='';
w_rsetsin='';
w_rpaecon='';
w_rcabcon='';
w_rpaeint='';
w_rcabint='';
w_TipoOper='';
}
if(arrt_discouic_rilievi_pg._p.length>0)_rargs([[['w_DaDatOpe',arrt_discouic_rilievi_pg._p[0]],['w_ADatOpe',arrt_discouic_rilievi_pg._p[1]],['w_rcoddip',arrt_discouic_rilievi_pg._p[2]],['w_rabicab',arrt_discouic_rilievi_pg._p[3]],['w_rcabdip',arrt_discouic_rilievi_pg._p[4]],['w_rpaecli',arrt_discouic_rilievi_pg._p[5]],['w_rcabcli',arrt_discouic_rilievi_pg._p[6]],['w_rcodvoc',arrt_discouic_rilievi_pg._p[7]],['w_rflglire',arrt_discouic_rilievi_pg._p[8]],['w_rsegno',arrt_discouic_rilievi_pg._p[9]],['w_rsetsin',arrt_discouic_rilievi_pg._p[10]],['w_rpaecon',arrt_discouic_rilievi_pg._p[11]],['w_rcabcon',arrt_discouic_rilievi_pg._p[12]],['w_rpaeint',arrt_discouic_rilievi_pg._p[13]],['w_rcabint',arrt_discouic_rilievi_pg._p[14]],['w_TipoOper',arrt_discouic_rilievi_pg._p[15]]]],{eval:function(e){eval(e)}})
arrt_discouic_rilievi_pg._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_discouic_rilievi_pg._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_discouic_rilievi_pg._s.SetParameterString('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_discouic_rilievi_pg._s.SetParameterString('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_discouic_rilievi_pg._s.SetParameterString('w_rcoddip',WtA(w_rcoddip,'C'));
arrt_discouic_rilievi_pg._s.SetParameterString('w_rabicab',WtA(w_rabicab,'C'));
arrt_discouic_rilievi_pg._s.SetParameterString('w_rcabdip',WtA(w_rcabdip,'C'));
arrt_discouic_rilievi_pg._s.SetParameterString('w_rpaecli',WtA(w_rpaecli,'C'));
arrt_discouic_rilievi_pg._s.SetParameterString('w_rcabcli',WtA(w_rcabcli,'C'));
arrt_discouic_rilievi_pg._s.SetParameterString('w_rcodvoc',WtA(w_rcodvoc,'C'));
arrt_discouic_rilievi_pg._s.SetParameterString('w_rflglire',WtA(w_rflglire,'C'));
arrt_discouic_rilievi_pg._s.SetParameterString('w_rsegno',WtA(w_rsegno,'C'));
arrt_discouic_rilievi_pg._s.SetParameterString('w_rsetsin',WtA(w_rsetsin,'C'));
arrt_discouic_rilievi_pg._s.SetParameterString('w_rpaecon',WtA(w_rpaecon,'C'));
arrt_discouic_rilievi_pg._s.SetParameterString('w_rcabcon',WtA(w_rcabcon,'C'));
arrt_discouic_rilievi_pg._s.SetParameterString('w_rpaeint',WtA(w_rpaeint,'C'));
arrt_discouic_rilievi_pg._s.SetParameterString('w_rcabint',WtA(w_rcabint,'C'));
arrt_discouic_rilievi_pg._s.SetParameterString('w_TipoOper',WtA(w_TipoOper,'C'));
arrt_discouic_rilievi_pg._s.SetParameterString('m_bApplet','true');
arrt_discouic_rilievi_pg._s.CallServlet('arrt_discouic_rilievi_pg');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_discouic_rilievi_pg._s.errmsg;
}
}
arrt_discouic_rilievi_pg.CtxLoad_ = function(){return []}
