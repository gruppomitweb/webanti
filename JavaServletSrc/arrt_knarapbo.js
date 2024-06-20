function arrt_knarapbo() {
var pTipo;
var pOper;
var w_RAPPORTO;
var w_DESCRAP;
var w_TIPORAP;
var w_CODDIPE;
var m_Caller
arrt_knarapbo._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
pOper='';
}
if(arrt_knarapbo._p.length>0)_rargs([[['pTipo',arrt_knarapbo._p[0]],['pOper',arrt_knarapbo._p[1]]]],{eval:function(e){eval(e)}})
w_RAPPORTO=m_Caller.GetString('w_RAPPORTO','C',0,0);
w_DESCRAP=m_Caller.GetString('w_DESCRAP','C',0,0);
w_TIPORAP=m_Caller.GetString('w_TIPORAP','C',0,0);
w_CODDIPE=m_Caller.GetString('w_CODDIPE','C',0,0);
arrt_knarapbo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_knarapbo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_knarapbo._s.SetCallerStringVar('w_RAPPORTO',WtA(w_RAPPORTO,'C'));
arrt_knarapbo._s.SetCallerStringVar('w_DESCRAP',WtA(w_DESCRAP,'C'));
arrt_knarapbo._s.SetCallerStringVar('w_TIPORAP',WtA(w_TIPORAP,'C'));
arrt_knarapbo._s.SetCallerStringVar('w_CODDIPE',WtA(w_CODDIPE,'C'));
arrt_knarapbo._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_knarapbo._s.SetParameterString('pOper',WtA(pOper,'C'));
arrt_knarapbo._s.SetParameterString('m_bApplet','true');
arrt_knarapbo._s.CallServlet('arrt_knarapbo');
m_Caller.SetString('w_RAPPORTO','C',0,0,arrt_knarapbo._s.GetCallerStringVar('w_RAPPORTO'));
m_Caller.SetString('w_DESCRAP','C',0,0,arrt_knarapbo._s.GetCallerStringVar('w_DESCRAP'));
m_Caller.SetString('w_TIPORAP','C',0,0,arrt_knarapbo._s.GetCallerStringVar('w_TIPORAP'));
m_Caller.SetString('w_CODDIPE','C',0,0,arrt_knarapbo._s.GetCallerStringVar('w_CODDIPE'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_knarapbo._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_knarapbo.CtxLoad_ = function(){return []}
