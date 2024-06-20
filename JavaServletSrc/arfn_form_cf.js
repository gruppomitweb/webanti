function arfn_form_cf() {
var pCF;
var pCognome;
var pNome;
var pDatNas;
var pCitta;
var pStato;
var pSesso;
var pCFE;
var pPNas;
var m_Caller
arfn_form_cf._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCF='';
pCognome='';
pNome='';
pDatNas=NullDate();
pCitta='';
pStato='';
pSesso='';
pCFE=0;
pPNas='';
}
if(arfn_form_cf._p.length>0)_rargs([[['pCF',arfn_form_cf._p[0]],['pCognome',arfn_form_cf._p[1]],['pNome',arfn_form_cf._p[2]],['pDatNas',arfn_form_cf._p[3]],['pCitta',arfn_form_cf._p[4]],['pStato',arfn_form_cf._p[5]],['pSesso',arfn_form_cf._p[6]],['pCFE',arfn_form_cf._p[7]],['pPNas',arfn_form_cf._p[8]]]],{eval:function(e){eval(e)}})
arfn_form_cf._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_form_cf._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_form_cf._s.SetParameterString('pCF',WtA(pCF,'C'));
arfn_form_cf._s.SetParameterString('pCognome',WtA(pCognome,'C'));
arfn_form_cf._s.SetParameterString('pNome',WtA(pNome,'C'));
arfn_form_cf._s.SetParameterString('pDatNas',WtA(pDatNas,'D'));
arfn_form_cf._s.SetParameterString('pCitta',WtA(pCitta,'C'));
arfn_form_cf._s.SetParameterString('pStato',WtA(pStato,'C'));
arfn_form_cf._s.SetParameterString('pSesso',WtA(pSesso,'C'));
arfn_form_cf._s.SetParameterString('pCFE',WtA(pCFE,'N'));
arfn_form_cf._s.SetParameterString('pPNas',WtA(pPNas,'C'));
arfn_form_cf._s.SetParameterString('m_bApplet','true');
arfn_form_cf._s.CallServlet('arfn_form_cf');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_form_cf._s.errmsg;
}
return arfn_form_cf._s.GetBoolean();
}
arfn_form_cf.CtxLoad_ = function(){return []}
