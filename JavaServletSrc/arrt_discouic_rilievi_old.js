function arrt_discouic_rilievi_old() {
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
arrt_discouic_rilievi_old._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_DaDatOpe=m_Caller.GetDate('w_DaDatOpe','D',0,0);
w_ADatOpe=m_Caller.GetDate('w_ADatOpe','D',0,0);
w_rcoddip=m_Caller.GetString('w_rcoddip','C',0,0);
w_rabicab=m_Caller.GetString('w_rabicab','C',0,0);
w_rcabdip=m_Caller.GetString('w_rcabdip','C',0,0);
w_rpaecli=m_Caller.GetString('w_rpaecli','C',0,0);
w_rcabcli=m_Caller.GetString('w_rcabcli','C',0,0);
w_rcodvoc=m_Caller.GetString('w_rcodvoc','C',0,0);
w_rflglire=m_Caller.GetString('w_rflglire','C',0,0);
w_rsegno=m_Caller.GetString('w_rsegno','C',0,0);
w_rsetsin=m_Caller.GetString('w_rsetsin','C',0,0);
w_rpaecon=m_Caller.GetString('w_rpaecon','C',0,0);
w_rcabcon=m_Caller.GetString('w_rcabcon','C',0,0);
w_rpaeint=m_Caller.GetString('w_rpaeint','C',0,0);
w_rcabint=m_Caller.GetString('w_rcabint','C',0,0);
w_TipoOper=m_Caller.GetString('w_TipoOper','C',0,0);
arrt_discouic_rilievi_old._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_discouic_rilievi_old._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_discouic_rilievi_old._s.SetCallerStringVar('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_discouic_rilievi_old._s.SetCallerStringVar('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_discouic_rilievi_old._s.SetCallerStringVar('w_rcoddip',WtA(w_rcoddip,'C'));
arrt_discouic_rilievi_old._s.SetCallerStringVar('w_rabicab',WtA(w_rabicab,'C'));
arrt_discouic_rilievi_old._s.SetCallerStringVar('w_rcabdip',WtA(w_rcabdip,'C'));
arrt_discouic_rilievi_old._s.SetCallerStringVar('w_rpaecli',WtA(w_rpaecli,'C'));
arrt_discouic_rilievi_old._s.SetCallerStringVar('w_rcabcli',WtA(w_rcabcli,'C'));
arrt_discouic_rilievi_old._s.SetCallerStringVar('w_rcodvoc',WtA(w_rcodvoc,'C'));
arrt_discouic_rilievi_old._s.SetCallerStringVar('w_rflglire',WtA(w_rflglire,'C'));
arrt_discouic_rilievi_old._s.SetCallerStringVar('w_rsegno',WtA(w_rsegno,'C'));
arrt_discouic_rilievi_old._s.SetCallerStringVar('w_rsetsin',WtA(w_rsetsin,'C'));
arrt_discouic_rilievi_old._s.SetCallerStringVar('w_rpaecon',WtA(w_rpaecon,'C'));
arrt_discouic_rilievi_old._s.SetCallerStringVar('w_rcabcon',WtA(w_rcabcon,'C'));
arrt_discouic_rilievi_old._s.SetCallerStringVar('w_rpaeint',WtA(w_rpaeint,'C'));
arrt_discouic_rilievi_old._s.SetCallerStringVar('w_rcabint',WtA(w_rcabint,'C'));
arrt_discouic_rilievi_old._s.SetCallerStringVar('w_TipoOper',WtA(w_TipoOper,'C'));
arrt_discouic_rilievi_old._s.SetParameterString('m_bApplet','true');
arrt_discouic_rilievi_old._s.CallServlet('arrt_discouic_rilievi_old');
m_Caller.SetDate('w_DaDatOpe','D',0,0,DateFromApplet(arrt_discouic_rilievi_old._s.GetCallerDateVar('w_DaDatOpe')));
m_Caller.SetDate('w_ADatOpe','D',0,0,DateFromApplet(arrt_discouic_rilievi_old._s.GetCallerDateVar('w_ADatOpe')));
m_Caller.SetString('w_rcoddip','C',0,0,arrt_discouic_rilievi_old._s.GetCallerStringVar('w_rcoddip'));
m_Caller.SetString('w_rabicab','C',0,0,arrt_discouic_rilievi_old._s.GetCallerStringVar('w_rabicab'));
m_Caller.SetString('w_rcabdip','C',0,0,arrt_discouic_rilievi_old._s.GetCallerStringVar('w_rcabdip'));
m_Caller.SetString('w_rpaecli','C',0,0,arrt_discouic_rilievi_old._s.GetCallerStringVar('w_rpaecli'));
m_Caller.SetString('w_rcabcli','C',0,0,arrt_discouic_rilievi_old._s.GetCallerStringVar('w_rcabcli'));
m_Caller.SetString('w_rcodvoc','C',0,0,arrt_discouic_rilievi_old._s.GetCallerStringVar('w_rcodvoc'));
m_Caller.SetString('w_rflglire','C',0,0,arrt_discouic_rilievi_old._s.GetCallerStringVar('w_rflglire'));
m_Caller.SetString('w_rsegno','C',0,0,arrt_discouic_rilievi_old._s.GetCallerStringVar('w_rsegno'));
m_Caller.SetString('w_rsetsin','C',0,0,arrt_discouic_rilievi_old._s.GetCallerStringVar('w_rsetsin'));
m_Caller.SetString('w_rpaecon','C',0,0,arrt_discouic_rilievi_old._s.GetCallerStringVar('w_rpaecon'));
m_Caller.SetString('w_rcabcon','C',0,0,arrt_discouic_rilievi_old._s.GetCallerStringVar('w_rcabcon'));
m_Caller.SetString('w_rpaeint','C',0,0,arrt_discouic_rilievi_old._s.GetCallerStringVar('w_rpaeint'));
m_Caller.SetString('w_rcabint','C',0,0,arrt_discouic_rilievi_old._s.GetCallerStringVar('w_rcabint'));
m_Caller.SetString('w_TipoOper','C',0,0,arrt_discouic_rilievi_old._s.GetCallerStringVar('w_TipoOper'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_discouic_rilievi_old._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_discouic_rilievi_old.CtxLoad_ = function(){return []}
