function arrt_import_file_xlsx_esterni() {
var datamod;
var aggfam;
var pnomefile;
var pannorif;
var pselezione;
var m_Caller
arrt_import_file_xlsx_esterni._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
datamod=NullDate();
aggfam=false;
pnomefile='';
pannorif=0;
pselezione='';
}
if(arrt_import_file_xlsx_esterni._p.length>0)_rargs([[['datamod',arrt_import_file_xlsx_esterni._p[0]],['aggfam',arrt_import_file_xlsx_esterni._p[1]],['pnomefile',arrt_import_file_xlsx_esterni._p[2]],['pannorif',arrt_import_file_xlsx_esterni._p[3]],['pselezione',arrt_import_file_xlsx_esterni._p[4]]]],{eval:function(e){eval(e)}})
arrt_import_file_xlsx_esterni._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_import_file_xlsx_esterni._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_import_file_xlsx_esterni._s.SetParameterString('datamod',WtA(datamod,'D'));
arrt_import_file_xlsx_esterni._s.SetParameterString('aggfam',WtA(aggfam,'L'));
arrt_import_file_xlsx_esterni._s.SetParameterString('pnomefile',WtA(pnomefile,'C'));
arrt_import_file_xlsx_esterni._s.SetParameterString('pannorif',WtA(pannorif,'N'));
arrt_import_file_xlsx_esterni._s.SetParameterString('pselezione',WtA(pselezione,'C'));
arrt_import_file_xlsx_esterni._s.SetParameterString('m_bApplet','true');
arrt_import_file_xlsx_esterni._s.CallServlet('arrt_import_file_xlsx_esterni');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_import_file_xlsx_esterni._s.errmsg;
}
return arrt_import_file_xlsx_esterni._s.GetString();
}
arrt_import_file_xlsx_esterni.CtxLoad_ = function(){return []}
