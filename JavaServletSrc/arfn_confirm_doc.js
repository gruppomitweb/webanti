function arfn_confirm_doc() {
var pID;
var pTipo;
var pDocUnico;
var pDoc1;
var pDoc2;
var pDoc3;
var pDoc4;
var pDoc5;
var pDoc6;
var pOld0;
var pOld1;
var pOld2;
var pOld3;
var pOld4;
var pOld5;
var pOld6;
var pAttivi;
var pTicket;
var pCodDip;
var m_Caller
arfn_confirm_doc._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pID='';
pTipo='';
pDocUnico='';
pDoc1='';
pDoc2='';
pDoc3='';
pDoc4='';
pDoc5='';
pDoc6='';
pOld0='';
pOld1='';
pOld2='';
pOld3='';
pOld4='';
pOld5='';
pOld6='';
pAttivi='';
pTicket='';
pCodDip='';
}
if(arfn_confirm_doc._p.length>0)_rargs([[['pID',arfn_confirm_doc._p[0]],['pTipo',arfn_confirm_doc._p[1]],['pDocUnico',arfn_confirm_doc._p[2]],['pDoc1',arfn_confirm_doc._p[3]],['pDoc2',arfn_confirm_doc._p[4]],['pDoc3',arfn_confirm_doc._p[5]],['pDoc4',arfn_confirm_doc._p[6]],['pDoc5',arfn_confirm_doc._p[7]],['pDoc6',arfn_confirm_doc._p[8]],['pOld0',arfn_confirm_doc._p[9]],['pOld1',arfn_confirm_doc._p[10]],['pOld2',arfn_confirm_doc._p[11]],['pOld3',arfn_confirm_doc._p[12]],['pOld4',arfn_confirm_doc._p[13]],['pOld5',arfn_confirm_doc._p[14]],['pOld6',arfn_confirm_doc._p[15]],['pAttivi',arfn_confirm_doc._p[16]],['pTicket',arfn_confirm_doc._p[17]],['pCodDip',arfn_confirm_doc._p[18]]]],{eval:function(e){eval(e)}})
arfn_confirm_doc._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_confirm_doc._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_confirm_doc._s.SetParameterString('pID',WtA(pID,'C'));
arfn_confirm_doc._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_confirm_doc._s.SetParameterString('pDocUnico',WtA(pDocUnico,'C'));
arfn_confirm_doc._s.SetParameterString('pDoc1',WtA(pDoc1,'C'));
arfn_confirm_doc._s.SetParameterString('pDoc2',WtA(pDoc2,'C'));
arfn_confirm_doc._s.SetParameterString('pDoc3',WtA(pDoc3,'C'));
arfn_confirm_doc._s.SetParameterString('pDoc4',WtA(pDoc4,'C'));
arfn_confirm_doc._s.SetParameterString('pDoc5',WtA(pDoc5,'C'));
arfn_confirm_doc._s.SetParameterString('pDoc6',WtA(pDoc6,'C'));
arfn_confirm_doc._s.SetParameterString('pOld0',WtA(pOld0,'C'));
arfn_confirm_doc._s.SetParameterString('pOld1',WtA(pOld1,'C'));
arfn_confirm_doc._s.SetParameterString('pOld2',WtA(pOld2,'C'));
arfn_confirm_doc._s.SetParameterString('pOld3',WtA(pOld3,'C'));
arfn_confirm_doc._s.SetParameterString('pOld4',WtA(pOld4,'C'));
arfn_confirm_doc._s.SetParameterString('pOld5',WtA(pOld5,'C'));
arfn_confirm_doc._s.SetParameterString('pOld6',WtA(pOld6,'C'));
arfn_confirm_doc._s.SetParameterString('pAttivi',WtA(pAttivi,'C'));
arfn_confirm_doc._s.SetParameterString('pTicket',WtA(pTicket,'C'));
arfn_confirm_doc._s.SetParameterString('pCodDip',WtA(pCodDip,'C'));
arfn_confirm_doc._s.SetParameterString('m_bApplet','true');
arfn_confirm_doc._s.CallServlet('arfn_confirm_doc');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_confirm_doc._s.errmsg;
}
return arfn_confirm_doc._s.GetString();
}
arfn_confirm_doc.CtxLoad_ = function(){return []}
