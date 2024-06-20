function FillCombosValues() {
FillCombo('UJRFWINIVQ','UJRFWINIVQ');
FillCombo('MKCXJZEKIG','MKCXJZEKIG');
FillCombo('AQSAREJVST','AQSAREJVST');
FillCombo('HNMYJPHSQN','HNMYJPHSQN');
FillCombo('YMKLIGEOKH','YMKLIGEOKH');
FillCombo('SMVVFHCEHA','SMVVFHCEHA');
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('NHERHRZTFP',function(){return WtH(w_IDBASE,'C',10,0,'')},w_IDBASE);
SPBOUILib.SetInputValue('WJSVGWKSFC',function(){return WtH(w_CODINTER,'C',11,0,'')},w_CODINTER);
SPBOUILib.SetInputValue('AVHTGZTOSZ',function(){return WtH(w_CODDIPE,'C',6,0,'')},w_CODDIPE);
SPBOUILib.SetInputValue('RLUMBFHPUD',function(){return WtH(w_DESCCIT,'C',30,0,'')},w_DESCCIT);
SPBOUILib.SetInputValue('OJGQABFSYN',function(){return WtH(w_PROVINCIA,'C',2,0,'')},w_PROVINCIA);
SPBOUILib.SetInputValue('OZEOCQRSEQ',function(){return WtH(w_CODCAB,'C',6,0,'')},w_CODCAB);
SPBOUILib.SetInputValue('YLIKFVPZJA',function(){return WtH(w_DATAOPE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAOPE);
SPBOUILib.SetInputValue('XYMCLUECBD',function(){return WtH(w_NUMPROG,'C',11,0,'')},w_NUMPROG);
SPBOUILib.SetInputValue('KHYCSRMDGJ',function(){return WtH(w_IDEREG,'C',20,0,'')},w_IDEREG);
if(c=Ctrl('QSRYXQJCBZ')) selectCombo(c,w_FLAGFRAZ,'C')
SPBOUILib.SetInputValue('MSGBKOOAOY',function(){return WtH(w_COLLEG,'C',12,0,'')},w_COLLEG);
if(c=Ctrl('UJRFWINIVQ')) selectCombo(c,w_TIPOOPRAP,'C')
SPBOUILib.SetInputValue('XDPPAEWQFR',function(){return WtH(w_idcauana,'C',4,0,'')},w_idcauana);
SPBOUILib.SetInputValue('SQVJLYRFKQ',function(){return WtH(w_CODANA,'C',4,0,'')},w_CODANA);
SPBOUILib.SetInputValue('SRWWPHPCUB',function(){return WtH(w_CODVOC,'C',2,0,'')},w_CODVOC);
if(c=Ctrl('LJBMCCABSS')) selectCombo(c,w_appolire,'C')
if(c=Ctrl('MKCXJZEKIG')) selectCombo(c,w_VALUTA,'C')
SPBOUILib.SetInputValue('EDIXWZNSIC',function(){return WtH(w_xTOTLIRE,'N',15,2,'999,999,999,999.99')},w_xTOTLIRE);
if(c=Ctrl('PURPSXEVAI')) selectCombo(c,w_FLAGCONT,'C')
SPBOUILib.SetInputValue('CTORYEJVDR',function(){return WtH(w_xTOTCONT,'N',15,2,'999,999,999,999.99')},w_xTOTCONT);
SPBOUILib.SetInputValue('YTCDGCPEDJ',function(){return WtH(w_CAMBIO,'N',9,4,'9999.9999')},w_CAMBIO);
SPBOUILib.SetInputValue('YXAKYHSWPW',function(){return WtH(w_IMPIN,'N',15,2,'')},w_IMPIN);
SPBOUILib.SetInputValue('DPCGXWDECV',function(){return WtH(w_IMPOUT,'N',15,2,'')},w_IMPOUT);
var tmp_ZLLARVPZIO = ToHTag(AsControlValue((Ne(At(w_CODANA,'|DB|DC'),0)?'Importo in Uscita:':'Importo Operazione al netto delle commissioni:')));
if (Ne(e_ZLLARVPZIO,tmp_ZLLARVPZIO)) {
SPBOUILib.SetLabelValue('ZLLARVPZIO','innerHTML',tmp_ZLLARVPZIO);
e_ZLLARVPZIO=tmp_ZLLARVPZIO;
}
SPBOUILib.SetInputValue('RZIQZFKPUE',function(){return WtH(w_RAPPORTO,'C',25,0,'@!')},w_RAPPORTO);
SPBOUILib.SetInputValue('QBLXDBODXR',function(){return WtH(w_CONNESCLI,'C',16,0,'')},w_CONNESCLI);
SPBOUILib.SetInputValue('ADUIDSWRJW',function(){return WtH(w_PROQUOTA,'N',3,0,'')},w_PROQUOTA);
SPBOUILib.SetInputValue('LLXFEZDLPK',function(){return WtH(w_IMPSARA,'N',19,2,'99,999,999,999,999.99')},w_IMPSARA);
SPBOUILib.SetInputValue('TCOTJNZLGM',function(){return WtH(w_CONNESOPER,'C',16,0,'')},w_CONNESOPER);
if(c=Ctrl('AQSAREJVST')) selectCombo(c,w_TIPOLEG,'C')
if(c=Ctrl('JGKMKQMAHS')) ChkboxCheckUncheck(c,'S',w_PAGASOGOP)
if(c=Ctrl('JGKMKQMAHS')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('ULVCBLFVEU',function(){return WtH(w_CONNESBEN,'C',16,0,'')},w_CONNESBEN);
SPBOUILib.SetInputValue('HWFHDWYMIU',function(){return WtH(w_CONNALTRO,'C',16,0,'')},w_CONNALTRO);
SPBOUILib.SetInputValue('AWPNTOJIRR',function(){return WtH(w_C_RAG,'C',70,0,'@!')},w_C_RAG);
SPBOUILib.SetInputValue('ODAYKSRECA',function(){return WtH(w_C_CTA,'C',30,0,'@!')},w_C_CTA);
SPBOUILib.SetInputValue('NOTZPDMYIA',function(){return WtH(w_C_PRV,'C',2,0,'')},w_C_PRV);
SPBOUILib.SetInputValue('RDAVOEETJG',function(){return WtH(w_C_CAP,'C',5,0,'')},w_C_CAP);
SPBOUILib.SetInputValue('BOTAJBWHHY',function(){return WtH(w_C_CAB,'C',6,0,'')},w_C_CAB);
SPBOUILib.SetInputValue('VYLHWTRQNX',function(){return WtH(w_C_IND,'C',35,0,'')},w_C_IND);
SPBOUILib.SetInputValue('YVIKEGPYPM',function(){return WtH(w_C_STA,'C',3,0,'')},w_C_STA);
if(c=Ctrl('HNMYJPHSQN')) selectCombo(c,w_TIPOINT2,'C')
SPBOUILib.SetInputValue('CDJFSCCGNX',function(){return WtH(w_CODINT2,'C',11,0,'')},w_CODINT2);
SPBOUILib.SetInputValue('VYDRMHACRY',function(){return WtH(w_DESCINTER,'C',50,0,'')},w_DESCINTER);
SPBOUILib.SetInputValue('NYRJHOZOON',function(){return WtH(w_PAESE,'C',3,0,'')},w_PAESE);
SPBOUILib.SetInputValue('YBNJCVPDUM',function(){return WtH(w_C_RAPPORTO,'C',25,0,'')},w_C_RAPPORTO);
SPBOUILib.SetInputValue('YQINIDXZSL',function(){return WtH(w_CODCAB2,'C',6,0,'')},w_CODCAB2);
SPBOUILib.SetInputValue('FFCAGQAZHK',function(){return WtH(w_DESC2,'C',30,0,'')},w_DESC2);
SPBOUILib.SetInputValue('ACAPFGYRVI',function(){return WtH(w_PROV2,'C',2,0,'')},w_PROV2);
SPBOUILib.SetInputValue('GXMZZZHVBR',function(){return WtH(w_ZCPARTE,'C',69,0,'')},w_ZCPARTE);
SPBOUILib.SetInputValue('QNNLSEAZHF',function(){return WtH(w_SEGNO,'C',1,0,'')},w_SEGNO);
var tmp_XLNVLBYVQX = ToHTag(AsControlValue((Ge(w_DATAOPE,CharToDate('20020101')) || Le(w_datpaseuro,w_DATAOPE)?'B14. Totale Euro:':'B14. Totale Lire:')));
if (Ne(e_XLNVLBYVQX,tmp_XLNVLBYVQX)) {
SPBOUILib.SetLabelValue('XLNVLBYVQX','innerHTML',tmp_XLNVLBYVQX);
e_XLNVLBYVQX=tmp_XLNVLBYVQX;
}
var tmp_IINONMZPLB = ToHTag(AsControlValue((Lt(w_DATAOPE,CharToDate('20140101'))?'C21. Sogg. Op. Conto Terzi:':'C21. Esecutore: ')));
if (Ne(e_IINONMZPLB,tmp_IINONMZPLB)) {
SPBOUILib.SetLabelValue('IINONMZPLB','innerHTML',tmp_IINONMZPLB);
e_IINONMZPLB=tmp_IINONMZPLB;
}
var tmp_PXKFPRTVXX = ToHTag(AsControlValue(w_xragsocper));
if (Ne(e_PXKFPRTVXX,tmp_PXKFPRTVXX)) {
SPBOUILib.SetLabelValue('PXKFPRTVXX','innerHTML',tmp_PXKFPRTVXX);
e_PXKFPRTVXX=tmp_PXKFPRTVXX;
}
var tmp_UWUWSYENHG = ToHTag(AsControlValue(w_xdescrap));
if (Ne(e_UWUWSYENHG,tmp_UWUWSYENHG)) {
SPBOUILib.SetLabelValue('UWUWSYENHG','innerHTML',tmp_UWUWSYENHG);
e_UWUWSYENHG=tmp_UWUWSYENHG;
}
var tmp_QGPWBVUZYW = ToHTag(AsControlValue(w_xragsocct));
if (Ne(e_QGPWBVUZYW,tmp_QGPWBVUZYW)) {
SPBOUILib.SetLabelValue('QGPWBVUZYW','innerHTML',tmp_QGPWBVUZYW);
e_QGPWBVUZYW=tmp_QGPWBVUZYW;
}
var tmp_USZXRLYSFT = ToHTag(AsControlValue(w_xragsocben));
if (Ne(e_USZXRLYSFT,tmp_USZXRLYSFT)) {
SPBOUILib.SetLabelValue('USZXRLYSFT','innerHTML',tmp_USZXRLYSFT);
e_USZXRLYSFT=tmp_USZXRLYSFT;
}
var tmp_MYPLEXWRTO = ToHTag(AsControlValue(w_xdescpaese2));
if (Ne(e_MYPLEXWRTO,tmp_MYPLEXWRTO)) {
SPBOUILib.SetLabelValue('MYPLEXWRTO','innerHTML',tmp_MYPLEXWRTO);
e_MYPLEXWRTO=tmp_MYPLEXWRTO;
}
var tmp_OQXSPVCWCC = ToHTag(AsControlValue((Lt(w_DATAOPE,CharToDate('20140101'))?'C41. Titolare Effettivo:':'C51. Soggetto per conto del quale: ')));
if (Ne(e_OQXSPVCWCC,tmp_OQXSPVCWCC)) {
SPBOUILib.SetLabelValue('OQXSPVCWCC','innerHTML',tmp_OQXSPVCWCC);
e_OQXSPVCWCC=tmp_OQXSPVCWCC;
}
var tmp_PDLOBCDELX = ToHTag(AsControlValue(w_xragsocalt));
if (Ne(e_PDLOBCDELX,tmp_PDLOBCDELX)) {
SPBOUILib.SetLabelValue('PDLOBCDELX','innerHTML',tmp_PDLOBCDELX);
e_PDLOBCDELX=tmp_PDLOBCDELX;
}
var tmp_ESVLUSNYWB = ToHTag(AsControlValue(w_dessta));
if (Ne(e_ESVLUSNYWB,tmp_ESVLUSNYWB)) {
SPBOUILib.SetLabelValue('ESVLUSNYWB','innerHTML',tmp_ESVLUSNYWB);
e_ESVLUSNYWB=tmp_ESVLUSNYWB;
}
var tmp_WDLBZTAAWH = ToHTag(AsControlValue(w_desccauana));
if (Ne(e_WDLBZTAAWH,tmp_WDLBZTAAWH)) {
SPBOUILib.SetLabelValue('WDLBZTAAWH','innerHTML',tmp_WDLBZTAAWH);
e_WDLBZTAAWH=tmp_WDLBZTAAWH;
}
var tmp_BPBCTQXMMG = ToHTag(AsControlValue(w_xdesccausin));
if (Ne(e_BPBCTQXMMG,tmp_BPBCTQXMMG)) {
SPBOUILib.SetLabelValue('BPBCTQXMMG','innerHTML',tmp_BPBCTQXMMG);
e_BPBCTQXMMG=tmp_BPBCTQXMMG;
}
var tmp_POOUDEGCOH = ToHTag(AsControlValue(w_xdciticon));
if (Ne(e_POOUDEGCOH,tmp_POOUDEGCOH)) {
SPBOUILib.SetLabelValue('POOUDEGCOH','innerHTML',tmp_POOUDEGCOH);
e_POOUDEGCOH=tmp_POOUDEGCOH;
}
if(c=Ctrl('XCYZDRXAMJ')) ChkboxCheckUncheck(c,'S',w_NOSARA)
if(c=Ctrl('XCYZDRXAMJ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
var tmp_EJWGZOJWBP = ToHTag(AsControlValue('A12A. CAB: '+w_CODCAB));
if (Ne(e_EJWGZOJWBP,tmp_EJWGZOJWBP)) {
SPBOUILib.SetLabelValue('EJWGZOJWBP','innerHTML',tmp_EJWGZOJWBP);
e_EJWGZOJWBP=tmp_EJWGZOJWBP;
}
var tmp_EYNHAYOCCR = ToHTag(AsControlValue(' A12C. Prov.: '+w_PROVINCIA));
if (Ne(e_EYNHAYOCCR,tmp_EYNHAYOCCR)) {
SPBOUILib.SetLabelValue('EYNHAYOCCR','innerHTML',tmp_EYNHAYOCCR);
e_EYNHAYOCCR=tmp_EYNHAYOCCR;
}
var tmp_NVHVXNIQIJ = ToHTag(AsControlValue('A12B. Citt\xe0: '+w_DESCCIT));
if (Ne(e_NVHVXNIQIJ,tmp_NVHVXNIQIJ)) {
SPBOUILib.SetLabelValue('NVHVXNIQIJ','innerHTML',tmp_NVHVXNIQIJ);
e_NVHVXNIQIJ=tmp_NVHVXNIQIJ;
}
var tmp_SLFPRXDNJY = ToHTag(AsControlValue('A11. Dipendenza:'+w_CODDIPE));
if (Ne(e_SLFPRXDNJY,tmp_SLFPRXDNJY)) {
SPBOUILib.SetLabelValue('SLFPRXDNJY','innerHTML',tmp_SLFPRXDNJY);
e_SLFPRXDNJY=tmp_SLFPRXDNJY;
}
var tmp_ZPWWHEDZIY = ToHTag(AsControlValue('A01B. Intermediario: '+w_CODINTER));
if (Ne(e_ZPWWHEDZIY,tmp_ZPWWHEDZIY)) {
SPBOUILib.SetLabelValue('ZPWWHEDZIY','innerHTML',tmp_ZPWWHEDZIY);
e_ZPWWHEDZIY=tmp_ZPWWHEDZIY;
}
var tmp_HBMZVUXNWN = ToHTag(AsControlValue('A12A. CAB: '+w_CODCAB));
if (Ne(e_HBMZVUXNWN,tmp_HBMZVUXNWN)) {
SPBOUILib.SetLabelValue('HBMZVUXNWN','innerHTML',tmp_HBMZVUXNWN);
e_HBMZVUXNWN=tmp_HBMZVUXNWN;
}
var tmp_AXLJYHIMAU = ToHTag(AsControlValue(' A12C. Prov.: '+w_PROVINCIA));
if (Ne(e_AXLJYHIMAU,tmp_AXLJYHIMAU)) {
SPBOUILib.SetLabelValue('AXLJYHIMAU','innerHTML',tmp_AXLJYHIMAU);
e_AXLJYHIMAU=tmp_AXLJYHIMAU;
}
var tmp_ZOZWHJGKZC = ToHTag(AsControlValue('A12B. Citt\xe0: '+w_DESCCIT));
if (Ne(e_ZOZWHJGKZC,tmp_ZOZWHJGKZC)) {
SPBOUILib.SetLabelValue('ZOZWHJGKZC','innerHTML',tmp_ZOZWHJGKZC);
e_ZOZWHJGKZC=tmp_ZOZWHJGKZC;
}
var tmp_DOGJJSYMJD = ToHTag(AsControlValue('A11. Dipendenza:'+w_CODDIPE));
if (Ne(e_DOGJJSYMJD,tmp_DOGJJSYMJD)) {
SPBOUILib.SetLabelValue('DOGJJSYMJD','innerHTML',tmp_DOGJJSYMJD);
e_DOGJJSYMJD=tmp_DOGJJSYMJD;
}
var tmp_UMQVZLKAFI = ToHTag(AsControlValue('A01B. Intermediario: '+w_CODINTER));
if (Ne(e_UMQVZLKAFI,tmp_UMQVZLKAFI)) {
SPBOUILib.SetLabelValue('UMQVZLKAFI','innerHTML',tmp_UMQVZLKAFI);
e_UMQVZLKAFI=tmp_UMQVZLKAFI;
}
var tmp_CPZZPGLPTT = ToHTag(AsControlValue('A01B. Intermediario: '+w_CODINTER));
if (Ne(e_CPZZPGLPTT,tmp_CPZZPGLPTT)) {
SPBOUILib.SetLabelValue('CPZZPGLPTT','innerHTML',tmp_CPZZPGLPTT);
e_CPZZPGLPTT=tmp_CPZZPGLPTT;
}
var tmp_GIZJGVDRHP = ToHTag(AsControlValue('A11. Dipendenza:'+w_CODDIPE));
if (Ne(e_GIZJGVDRHP,tmp_GIZJGVDRHP)) {
SPBOUILib.SetLabelValue('GIZJGVDRHP','innerHTML',tmp_GIZJGVDRHP);
e_GIZJGVDRHP=tmp_GIZJGVDRHP;
}
var tmp_XTJJGCAFPQ = ToHTag(AsControlValue('A12B. Citt\xe0: '+w_DESCCIT));
if (Ne(e_XTJJGCAFPQ,tmp_XTJJGCAFPQ)) {
SPBOUILib.SetLabelValue('XTJJGCAFPQ','innerHTML',tmp_XTJJGCAFPQ);
e_XTJJGCAFPQ=tmp_XTJJGCAFPQ;
}
var tmp_NYDZFOZDZT = ToHTag(AsControlValue(' A12C. Prov.: '+w_PROVINCIA));
if (Ne(e_NYDZFOZDZT,tmp_NYDZFOZDZT)) {
SPBOUILib.SetLabelValue('NYDZFOZDZT','innerHTML',tmp_NYDZFOZDZT);
e_NYDZFOZDZT=tmp_NYDZFOZDZT;
}
var tmp_LRAIPTRCTP = ToHTag(AsControlValue('A12A. CAB: '+w_CODCAB));
if (Ne(e_LRAIPTRCTP,tmp_LRAIPTRCTP)) {
SPBOUILib.SetLabelValue('LRAIPTRCTP','innerHTML',tmp_LRAIPTRCTP);
e_LRAIPTRCTP=tmp_LRAIPTRCTP;
}
SPBOUILib.SetInputValue('GOVICFJKZC',function(){return WtH(w_IPCOLLEG,'C',15,0,'')},w_IPCOLLEG);
SPBOUILib.SetInputValue('USFWBVEHFH',function(){return WtH(w_ORACOLLEG,'T',8,0,TranslatePicture(GetDatePicture(true,'T'),'T'))},w_ORACOLLEG);
SPBOUILib.SetInputValue('IKKFZQQTRR',function(){return WtH(w_DUCOLLEG,'N',10,0,'')},w_DUCOLLEG);
if(c=Ctrl('LEHLEQRJPH')) ChkboxCheckUncheck(c,1,w_NOPROT)
if(c=Ctrl('LEHLEQRJPH')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('QEFXECTWSF',function(){return WtH(w_OPERAG,'C',3,0,'')},w_OPERAG);
var tmp_ILIJSVUNTQ = ToHTag(AsControlValue(w_xdescopeage));
if (Ne(e_ILIJSVUNTQ,tmp_ILIJSVUNTQ)) {
SPBOUILib.SetLabelValue('ILIJSVUNTQ','innerHTML',tmp_ILIJSVUNTQ);
e_ILIJSVUNTQ=tmp_ILIJSVUNTQ;
}
SPBOUILib.SetInputValue('VMRTFBBQHL',function(){return WtH(w_RESPINS,'C',30,0,'')},w_RESPINS);
SPBOUILib.SetInputValue('KDWBJNGUTK',function(){return WtH(w_INFORM,'C',30,0,'')},w_INFORM);
SPBOUILib.SetInputValue('VSHUPFYWOC',function(){return WtH(w_NATURA,'C',50,0,'')},w_NATURA);
SPBOUILib.SetInputValue('VASVGQZJGP',function(){return WtH(w_SCOPO,'C',50,0,'')},w_SCOPO);
if(c=Ctrl('SMZCOQAIDC')) selectCombo(c,w_SV58550,'C')
if(c=Ctrl('MDVEMSKFNR')) selectCombo(c,w_SV58550MA,'C')
SPBOUILib.SetInputValue('JEKLOGLRAN',function(){return WtH(w_MEZPAG,'C',30,0,'')},w_MEZPAG);
SPBOUILib.SetInputValue('RQKHNRJEDR',function(){return WtH(w_PRESTAZ,'C',30,0,'')},w_PRESTAZ);
SPBOUILib.SetInputValue('DVZEGUGHBR',function(){return WtH(w_DESPUNTO,'C',80,0,'')},w_DESPUNTO);
SPBOUILib.SetInputValue('IDIFNZYSLH',function(){return WtH(w_CODCLICON,'C',20,0,'')},w_CODCLICON);
if(c=Ctrl('SOMEUVNZHG')) selectCombo(c,w_TIPATT,'C')
if(c=Ctrl('YMKLIGEOKH')) selectCombo(c,w_VASP,'C')
SPBOUILib.SetInputValue('WNMMMNSARU',function(){return WtH(w_CONNESDOC,'C',50,0,'')},w_CONNESDOC);
SPBOUILib.SetInputValue('PLFKNICHPU',function(){return WtH(w_IDFILE,'C',60,0,'')},w_IDFILE);
var tmp_DRRKLKJROO = ToHTag(AsControlValue(w_xRAGSOCDOC));
if (Ne(e_DRRKLKJROO,tmp_DRRKLKJROO)) {
SPBOUILib.SetLabelValue('DRRKLKJROO','innerHTML',tmp_DRRKLKJROO);
e_DRRKLKJROO=tmp_DRRKLKJROO;
}
SPBOUILib.SetInputValue('JDTKGSGMAF',function(){return WtH(w_MTCN,'C',10,0,'')},w_MTCN);
var tmp_EEITQZTRRW = ToHTag(AsControlValue('A12A. CAB: '+w_CODCAB));
if (Ne(e_EEITQZTRRW,tmp_EEITQZTRRW)) {
SPBOUILib.SetLabelValue('EEITQZTRRW','innerHTML',tmp_EEITQZTRRW);
e_EEITQZTRRW=tmp_EEITQZTRRW;
}
var tmp_OCZGVOLDFD = ToHTag(AsControlValue(' A12C. Prov.: '+w_PROVINCIA));
if (Ne(e_OCZGVOLDFD,tmp_OCZGVOLDFD)) {
SPBOUILib.SetLabelValue('OCZGVOLDFD','innerHTML',tmp_OCZGVOLDFD);
e_OCZGVOLDFD=tmp_OCZGVOLDFD;
}
var tmp_JYWFCOSVCX = ToHTag(AsControlValue('A12B. Citt\xe0: '+w_DESCCIT));
if (Ne(e_JYWFCOSVCX,tmp_JYWFCOSVCX)) {
SPBOUILib.SetLabelValue('JYWFCOSVCX','innerHTML',tmp_JYWFCOSVCX);
e_JYWFCOSVCX=tmp_JYWFCOSVCX;
}
var tmp_XGDHKAIOHL = ToHTag(AsControlValue('A11. Dipendenza:'+w_CODDIPE));
if (Ne(e_XGDHKAIOHL,tmp_XGDHKAIOHL)) {
SPBOUILib.SetLabelValue('XGDHKAIOHL','innerHTML',tmp_XGDHKAIOHL);
e_XGDHKAIOHL=tmp_XGDHKAIOHL;
}
var tmp_JXHUHLCFZT = ToHTag(AsControlValue('A01B. Intermediario: '+w_CODINTER));
if (Ne(e_JXHUHLCFZT,tmp_JXHUHLCFZT)) {
SPBOUILib.SetLabelValue('JXHUHLCFZT','innerHTML',tmp_JXHUHLCFZT);
e_JXHUHLCFZT=tmp_JXHUHLCFZT;
}
SPBOUILib.SetInputValue('CKJQULDXKW',function(){return WtH(w_DURAT,'C',5,0,'')},w_DURAT);
SPBOUILib.SetInputValue('MXYTQLATHC',function(){return WtH(w_RFREQ,'N',3,0,'')},w_RFREQ);
SPBOUILib.SetInputValue('SXTYCPHBIM',function(){return WtH(w_AMMONT,'C',5,0,'')},w_AMMONT);
SPBOUILib.SetInputValue('KBIUAXUDXA',function(){return WtH(w_RIMP,'N',3,0,'')},w_RIMP);
SPBOUILib.SetInputValue('QJSTZIPOQB',function(){return WtH(w_AREAGEO,'C',5,0,'')},w_AREAGEO);
SPBOUILib.SetInputValue('UDAYHICPVB',function(){return WtH(w_RAREA,'N',3,0,'')},w_RAREA);
SPBOUILib.SetInputValue('SFFFOYOWNH',function(){return WtH(w_MODSVOL,'C',5,0,'')},w_MODSVOL);
SPBOUILib.SetInputValue('ETALZDRBSO',function(){return WtH(w_RCOMP,'N',3,0,'')},w_RCOMP);
SPBOUILib.SetInputValue('NOBMPHKVTX',function(){return WtH(w_RAGIO,'C',5,0,'')},w_RAGIO);
SPBOUILib.SetInputValue('QBTVZDKLCO',function(){return WtH(w_RRAGIO,'N',3,0,'')},w_RRAGIO);
SPBOUILib.SetInputValue('DJOWYRMDDC',function(){return WtH(w_TIPO,'C',3,0,'')},w_TIPO);
SPBOUILib.SetInputValue('RUWEXWJASG',function(){return WtH(w_RTIPO,'N',3,0,'')},w_RTIPO);
if(c=Ctrl('SMVVFHCEHA')) selectCombo(c,w_RISGLOB,'C')
SPBOUILib.SetInputValue('DOXBACRWUU',function(){return WtH(w_MITIG,'N',4,0,'')},w_MITIG);
SPBOUILib.SetInputValue('OXGBDTWKSX',function(){return WtH(w_MITIGDOC,'C',100,0,'')},w_MITIGDOC);
var tmp_CMKJDFEFFI = ToHTag(AsControlValue(w_xdescareag));
if (Ne(e_CMKJDFEFFI,tmp_CMKJDFEFFI)) {
SPBOUILib.SetLabelValue('CMKJDFEFFI','innerHTML',tmp_CMKJDFEFFI);
e_CMKJDFEFFI=tmp_CMKJDFEFFI;
}
var tmp_DXOTWSGBKN = ToHTag(AsControlValue(w_xdescmodsvo));
if (Ne(e_DXOTWSGBKN,tmp_DXOTWSGBKN)) {
SPBOUILib.SetLabelValue('DXOTWSGBKN','innerHTML',tmp_DXOTWSGBKN);
e_DXOTWSGBKN=tmp_DXOTWSGBKN;
}
var tmp_FXHEISJAJE = ToHTag(AsControlValue(w_xdescplauso));
if (Ne(e_FXHEISJAJE,tmp_FXHEISJAJE)) {
SPBOUILib.SetLabelValue('FXHEISJAJE','innerHTML',tmp_FXHEISJAJE);
e_FXHEISJAJE=tmp_FXHEISJAJE;
}
var tmp_GHHOMNKDDQ = ToHTag(AsControlValue(w_xdesctipor));
if (Ne(e_GHHOMNKDDQ,tmp_GHHOMNKDDQ)) {
SPBOUILib.SetLabelValue('GHHOMNKDDQ','innerHTML',tmp_GHHOMNKDDQ);
e_GHHOMNKDDQ=tmp_GHHOMNKDDQ;
}
var tmp_BCFLBBQSRN = ToHTag(AsControlValue(w_xdescammo));
if (Ne(e_BCFLBBQSRN,tmp_BCFLBBQSRN)) {
SPBOUILib.SetLabelValue('BCFLBBQSRN','innerHTML',tmp_BCFLBBQSRN);
e_BCFLBBQSRN=tmp_BCFLBBQSRN;
}
var tmp_QEXJCFPJBM = ToHTag(AsControlValue(w_xdescfreq));
if (Ne(e_QEXJCFPJBM,tmp_QEXJCFPJBM)) {
SPBOUILib.SetLabelValue('QEXJCFPJBM','innerHTML',tmp_QEXJCFPJBM);
e_QEXJCFPJBM=tmp_QEXJCFPJBM;
}
var tmp_UNSHTJMGHI = ToHTag(AsControlValue('A12A. CAB: '+w_CODCAB));
if (Ne(e_UNSHTJMGHI,tmp_UNSHTJMGHI)) {
SPBOUILib.SetLabelValue('UNSHTJMGHI','innerHTML',tmp_UNSHTJMGHI);
e_UNSHTJMGHI=tmp_UNSHTJMGHI;
}
var tmp_OJRHNXOUWC = ToHTag(AsControlValue(' A12C. Prov.: '+w_PROVINCIA));
if (Ne(e_OJRHNXOUWC,tmp_OJRHNXOUWC)) {
SPBOUILib.SetLabelValue('OJRHNXOUWC','innerHTML',tmp_OJRHNXOUWC);
e_OJRHNXOUWC=tmp_OJRHNXOUWC;
}
var tmp_KLUNHTCEQC = ToHTag(AsControlValue('A12B. Citt\xe0: '+w_DESCCIT));
if (Ne(e_KLUNHTCEQC,tmp_KLUNHTCEQC)) {
SPBOUILib.SetLabelValue('KLUNHTCEQC','innerHTML',tmp_KLUNHTCEQC);
e_KLUNHTCEQC=tmp_KLUNHTCEQC;
}
var tmp_ZTVMDQIMQO = ToHTag(AsControlValue('A11. Dipendenza:'+w_CODDIPE));
if (Ne(e_ZTVMDQIMQO,tmp_ZTVMDQIMQO)) {
SPBOUILib.SetLabelValue('ZTVMDQIMQO','innerHTML',tmp_ZTVMDQIMQO);
e_ZTVMDQIMQO=tmp_ZTVMDQIMQO;
}
var tmp_UPCAOESJXK = ToHTag(AsControlValue('A01B. Intermediario: '+w_CODINTER));
if (Ne(e_UPCAOESJXK,tmp_UPCAOESJXK)) {
SPBOUILib.SetLabelValue('UPCAOESJXK','innerHTML',tmp_UPCAOESJXK);
e_UPCAOESJXK=tmp_UPCAOESJXK;
}
var tmp_YGLPQVFGKD = ToHTag(AsControlValue('A12A. CAB: '+w_CODCAB));
if (Ne(e_YGLPQVFGKD,tmp_YGLPQVFGKD)) {
SPBOUILib.SetLabelValue('YGLPQVFGKD','innerHTML',tmp_YGLPQVFGKD);
e_YGLPQVFGKD=tmp_YGLPQVFGKD;
}
var tmp_SZTEZKCQXE = ToHTag(AsControlValue(' A12C. Prov.: '+w_PROVINCIA));
if (Ne(e_SZTEZKCQXE,tmp_SZTEZKCQXE)) {
SPBOUILib.SetLabelValue('SZTEZKCQXE','innerHTML',tmp_SZTEZKCQXE);
e_SZTEZKCQXE=tmp_SZTEZKCQXE;
}
var tmp_SLEKQHWKOI = ToHTag(AsControlValue('A12B. Citt\xe0: '+w_DESCCIT));
if (Ne(e_SLEKQHWKOI,tmp_SLEKQHWKOI)) {
SPBOUILib.SetLabelValue('SLEKQHWKOI','innerHTML',tmp_SLEKQHWKOI);
e_SLEKQHWKOI=tmp_SLEKQHWKOI;
}
var tmp_MHLKBIRWTL = ToHTag(AsControlValue('A11. Dipendenza:'+w_CODDIPE));
if (Ne(e_MHLKBIRWTL,tmp_MHLKBIRWTL)) {
SPBOUILib.SetLabelValue('MHLKBIRWTL','innerHTML',tmp_MHLKBIRWTL);
e_MHLKBIRWTL=tmp_MHLKBIRWTL;
}
var tmp_DJRZLXTYSY = ToHTag(AsControlValue('A01B. Intermediario: '+w_CODINTER));
if (Ne(e_DJRZLXTYSY,tmp_DJRZLXTYSY)) {
SPBOUILib.SetLabelValue('DJRZLXTYSY','innerHTML',tmp_DJRZLXTYSY);
e_DJRZLXTYSY=tmp_DJRZLXTYSY;
}
SetCollapsibleCaptions();
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function SetCollapsibleCaptions() {
var c;
var l_cComment;
l_cComment=(Lt(w_DATAOPE,CharToDate('20140101'))?'Altri Soggetti Operanti Conto Terzi':'Altri Esecutori');
if (Ne(e_ZYUUSRMPQG,l_cComment)) {
SetBoxCaption('ZYUUSRMPQG',l_cComment);
e_ZYUUSRMPQG=l_cComment;
}
l_cComment=(Ge(w_DATAOPE,CharToDate('20140101'))?'Altri Soggetti Terzi':'Titolari Effettivi');
if (Ne(e_BHLGNNSXQY,l_cComment)) {
SetBoxCaption('BHLGNNSXQY',l_cComment);
e_BHLGNNSXQY=l_cComment;
}
}
function HideControlsUnderCondition() {
var h;
h=Ne(w_gFlgWU,'S') || IsHiddenByStateDriver(Z.Tabs.Get('tabs').GetTabstripID('page_5'));
SetDisplay(Z.Tabs.Get('tabs').GetTabstripID('page_5'),h);
if (h && (Z.Tabs.Get('tabs').IsExpanded('page_5'))) {
Z.Tabs.Get('tabs').Next() || Z.Tabs.Get('tabs').Prev();
}
h=Ne(w_gTipInter,'31') || IsHiddenByStateDriver(Z.Tabs.Get('tabs').GetTabstripID('page_7'));
SetDisplay(Z.Tabs.Get('tabs').GetTabstripID('page_7'),h);
if (h && (Z.Tabs.Get('tabs').IsExpanded('page_7'))) {
Z.Tabs.Get('tabs').Next() || Z.Tabs.Get('tabs').Prev();
}
SetDisplay(Ctrl('NHERHRZTFP'),Eq(1,1) || IsHiddenByStateDriver('IDBASE'));
SetDisplay('YORQOIOBQN_DIV',IsHiddenByStateDriver('DatiOperazione'));
SetDisplay('ANGGVVFTIZ_DIV',Ge(w_gTipInter,'30') && Le(w_gTipInter,'41') || IsHiddenByStateDriver('DatiCambiaSV'));
SetDisplay('XLSSDAVPDH_DIV',IsHiddenByStateDriver('DatiSoggetti'));
SetDisplay('ZPEPXLSZFA_DIV',Ge(w_gTipInter,'30') && Le(w_gTipInter,'41') || IsHiddenByStateDriver('DatiControparte'));
SetDisplay('YIVWPEZXIF_DIV',Ge(w_gTipInter,'30') && Le(w_gTipInter,'41') || IsHiddenByStateDriver('DatiIntermediarioControparte'));
SetDisplay('BOYWPGJEEZ_DIV',IsHiddenByStateDriver('Intermediario'));
SetDisplay(Ctrl('MSGBKOOAOY'),Empty(w_COLLEG) || IsHiddenByStateDriver('COLLEG'));
SetDisplay(Ctrl('SIPPFUEECW'),Eq(At(w_CODANA,'|DB|DC'),0));
SetDisplay(Ctrl('YXAKYHSWPW'),Eq(At(w_CODANA,'|DB|DC'),0) || IsHiddenByStateDriver('IMPIN'));
SetDisplay(Ctrl('XPWBHUQUGP'),Ne(m_cFunction,'view'));
SetDisplay(Ctrl('FRGXYSRNBR'),(Ne(w_gSeekAos,'S') || Utilities.Make(window).IsInGroup(9)) && Empty(w_CONNESBEN) &&  ! (Empty(w_C_RAG)));
SetDisplay(Ctrl('WTYYEQYAIU'),Empty(w_COLLEG));
SetDisplay('XCYZDRXAMJ_DIV',Ge(w_gTipInter,'30') && Le(w_gTipInter,'41'));
SetDisplay('BDZUATYPMW_DIV',IsHiddenByStateDriver('AltriIntestatari'));
SetDisplay('ZYUUSRMPQG_DIV',IsHiddenByStateDriver('AltriEsecutori'));
SetDisplay('NIKDKIOYYF_DIV',IsHiddenByStateDriver('Intermediario2'));
SetDisplay('GTSBULOFTD_DIV',IsHiddenByStateDriver('AltriControparti'));
SetDisplay('BHLGNNSXQY_DIV',IsHiddenByStateDriver('AltriSogTerzi'));
SetDisplay('CNRNAIMNZQ_DIV',IsHiddenByStateDriver('Rapporto'));
SetDisplay('JWDKPZAEZU_DIV',IsHiddenByStateDriver('Intermediario3'));
SetDisplay('QVDUCHDNOK_DIV',IsHiddenByStateDriver('Intermediario4'));
SetDisplay('JTWNGHDSFX_DIV',Ge(w_gTipInter,'30') && Le(w_gTipInter,'41') || IsHiddenByStateDriver('Internet'));
SetDisplay('EOKCAXCLZO_DIV',Ge(w_gTipInter,'30') && Le(w_gTipInter,'41') || IsHiddenByStateDriver('AGE'));
SetDisplay(Ctrl('SMZCOQAIDC'),Ne(w_TIPOOPRAP,'11') || IsHiddenByStateDriver('SV58550'));
SetDisplay(Ctrl('BQDHWAMSZF'),Ne(w_TIPOOPRAP,'11'));
SetDisplay('VVOVGLWTVP_DIV',Ge(w_gTipInter,'30') && Le(w_gTipInter,'41') || IsHiddenByStateDriver('SV'));
SetDisplay(Ctrl('JEKLOGLRAN'),Lt(w_gTipInter,'30') || Gt(w_gTipInter,'41') || IsHiddenByStateDriver('MEZPAG'));
SetDisplay(Ctrl('RVWYGBVTDV'),Lt(w_gTipInter,'30') || Gt(w_gTipInter,'41'));
SetDisplay(Ctrl('RQKHNRJEDR'),Lt(w_gTipInter,'30') || Gt(w_gTipInter,'41') || IsHiddenByStateDriver('PRESTAZ'));
SetDisplay(Ctrl('ZFGJEWNDTX'),Lt(w_gTipInter,'30') || Gt(w_gTipInter,'41'));
SetDisplay('SNFGHIZMTZ_DIV',IsHiddenByStateDriver('AltriDati'));
SetDisplay('LLZCQSNQZL_DIV',Ne(w_gTipInter,'31') || IsHiddenByStateDriver('Contante_Gen'));
SetDisplay('OXFXXISYUL_DIV',IsHiddenByStateDriver('OAM'));
SetDisplay('JELGAQOYWT_DIV',IsHiddenByStateDriver('Documenti'));
SetDisplay(Ctrl('JDTKGSGMAF'),Ne(w_gFlgWU,'S') || IsHiddenByStateDriver('MTCN'));
SetDisplay(Ctrl('EOJCZFADSY'),Ne(w_gFlgWU,'S'));
SetDisplay('CEBGUGLSVM_DIV',IsHiddenByStateDriver('Intermediario5'));
SetDisplay('GMMLWYVNPO_DIV',IsHiddenByStateDriver('IIIDirettiva'));
SetDisplay('UFFFOVKFCE_DIV',IsHiddenByStateDriver('Mitigazione'));
SetDisplay('YUNLBUHYXD_DIV',IsHiddenByStateDriver('Categorie'));
SetDisplay('HHLUYHQCAT_DIV',IsHiddenByStateDriver('Intermediario6'));
SetDisplay('QKOTBMZCDT_DIV',IsHiddenByStateDriver('Intermediario7'));
SetDisplay('VTXXRGJSRI_DIV',IsHiddenByStateDriver('Contante'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["AMMONT"]=['LXNMWSOUMF'];
HideUI.lblids["AREAGEO"]=['NAVNOGNZNE'];
HideUI.lblids["CAMBIO"]=['HTLKHJWKEZ'];
HideUI.lblids["CODANA"]=['RPGHLQLUDI'];
HideUI.lblids["CODCAB"]=['ENBRMMDVUP'];
HideUI.lblids["CODCAB2"]=['GXGGXKSESA'];
HideUI.lblids["CODCLICON"]=['GWFAZWBZWG'];
HideUI.lblids["CODDIPE"]=['XVRJYSKGWZ'];
HideUI.lblids["CODINT2"]=['LNONRUGLMW'];
HideUI.lblids["CODINTER"]=['LOEAMXUYLA'];
HideUI.lblids["CODVOC"]=['GVUCGWQOGG'];
HideUI.lblids["COLLEG"]=['WTYYEQYAIU'];
HideUI.lblids["CONNALTRO"]=['OQXSPVCWCC'];
HideUI.lblids["CONNESBEN"]=['LZDWHHTSGR'];
HideUI.lblids["CONNESCLI"]=['NUEFWOMRRX'];
HideUI.lblids["CONNESDOC"]=['MHQXMCGOMG'];
HideUI.lblids["CONNESOPER"]=['IINONMZPLB'];
HideUI.lblids["C_CAB"]=['WHMXTGXWGC'];
HideUI.lblids["C_CAP"]=['GDOCAGKROT'];
HideUI.lblids["C_CTA"]=['XPSQTBKQQZ'];
HideUI.lblids["C_IND"]=['TWTXGZJTAR'];
HideUI.lblids["C_PRV"]=['SBJQIAQUCN'];
HideUI.lblids["C_RAG"]=['PFEQRACAUA'];
HideUI.lblids["C_RAPPORTO"]=['RUIGDGZVBM'];
HideUI.lblids["C_STA"]=['RZBLEGCFJJ'];
HideUI.lblids["DATAOPE"]=['HVHVAYPDJE'];
HideUI.lblids["DESC2"]=['ZTIARSVAXX'];
HideUI.lblids["DESCCIT"]=['CTLYJMTHDV'];
HideUI.lblids["DESCINTER"]=['MZACLGVARN'];
HideUI.lblids["DESPUNTO"]=['IXLIPJPKPM'];
HideUI.lblids["DUCOLLEG"]=['WAAEZAHSYA'];
HideUI.lblids["DURAT"]=['ZUVXJIZOSF'];
HideUI.lblids["FLAGCONT"]=['GVTXMEILAZ'];
HideUI.lblids["FLAGFRAZ"]=['JHWWHHXDJI'];
HideUI.lblids["IDEREG"]=['NOCRBBFOUY'];
HideUI.lblids["IDFILE"]=['BNZLNGZOEF'];
HideUI.lblids["IMPIN"]=['SIPPFUEECW'];
HideUI.lblids["IMPOUT"]=['ZLLARVPZIO'];
HideUI.lblids["IMPSARA"]=['XGCFFEVNTQ'];
HideUI.lblids["INFORM"]=['PZUBJPCOXA'];
HideUI.lblids["IPCOLLEG"]=['KMKAXHABAG'];
HideUI.lblids["MEZPAG"]=['RVWYGBVTDV'];
HideUI.lblids["MITIG"]=['VCBMHLXJMD'];
HideUI.lblids["MITIGDOC"]=['PKJNNGBWFM'];
HideUI.lblids["MODSVOL"]=['LHTXLTQYIK'];
HideUI.lblids["MTCN"]=['EOJCZFADSY'];
HideUI.lblids["NATURA"]=['BVGYBYGMJB'];
HideUI.lblids["NUMPROG"]=['KDUGHGZUUG'];
HideUI.lblids["OPERAG"]=['ZEYLNLLVTD'];
HideUI.lblids["ORACOLLEG"]=['GETFWUXANX'];
HideUI.lblids["PAESE"]=['JJLAKRDJXU'];
HideUI.lblids["PRESTAZ"]=['ZFGJEWNDTX'];
HideUI.lblids["PROQUOTA"]=['CMPDPVIXKY'];
HideUI.lblids["PROV2"]=['IDAYTSKPPF'];
HideUI.lblids["PROVINCIA"]=['JWSDOSRGAG'];
HideUI.lblids["RAGIO"]=['HGXSBHTFKF'];
HideUI.lblids["RAPPORTO"]=['EXIXNLTCBE'];
HideUI.lblids["RESPINS"]=['AMHSICIBVW'];
HideUI.lblids["RISGLOB"]=['JKZZQYXAFS'];
HideUI.lblids["SCOPO"]=['EWATRAIADP'];
HideUI.lblids["SEGNO"]=['PQFNSCNIRZ'];
HideUI.lblids["SV58550"]=['BQDHWAMSZF'];
HideUI.lblids["SV58550MA"]=['BRIRCGYFEZ'];
HideUI.lblids["TIPATT"]=['TZYCGKLUVR'];
HideUI.lblids["TIPO"]=['OKFGBGYVWD'];
HideUI.lblids["TIPOINT2"]=['CFRJFQBTVV'];
HideUI.lblids["TIPOLEG"]=['VECGHPFLII'];
HideUI.lblids["TIPOOPRAP"]=['KMCNAWQHKV'];
HideUI.lblids["VALUTA"]=['UIZWPHSLNT'];
HideUI.lblids["VASP"]=['THAPDQIYBH'];
HideUI.lblids["ZCPARTE"]=['IMHKHLSVQZ'];
HideUI.lblids["appolire"]=['EQARGRKLGY'];
HideUI.lblids["idcauana"]=['DFNYQWVWJD'];
HideUI.lblids["xTOTCONT"]=['IDTBMNCIOX'];
HideUI.lblids["xTOTLIRE"]=['XLNVLBYVQX'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
cond= ! (Empty(w_C_RAG));
if (Ne(o_ZPEPXLSZFA_expand,cond)) {
ExpandCollapsibleBox('ZPEPXLSZFA',cond);
o_ZPEPXLSZFA_expand=cond;
}
cond= ! (Empty(w_C_RAG));
if (Ne(o_YIVWPEZXIF_expand,cond)) {
ExpandCollapsibleBox('YIVWPEZXIF',cond);
o_YIVWPEZXIF_expand=cond;
}
}
function NHERHRZTFP_Valid(e) {
SetActiveField(Ctrl('NHERHRZTFP'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('NHERHRZTFP') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('IDBASE','C',w_IDBASE,HtW(Ctrl('NHERHRZTFP').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDBASE(HtW(Ctrl('NHERHRZTFP').value,'C'),null,e);
return l_bSetResult;
}
}
function NHERHRZTFP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NHERHRZTFP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NHERHRZTFP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NHERHRZTFP'),e);
}
function AVHTGZTOSZ_Valid(e) {
SetActiveField(Ctrl('AVHTGZTOSZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODDIPE','C',w_CODDIPE,HtW(Ctrl('AVHTGZTOSZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODDIPE(HtW(Ctrl('AVHTGZTOSZ').value,'C'),null,e);
return l_bSetResult;
}
}
function AVHTGZTOSZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AVHTGZTOSZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('AVHTGZTOSZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AVHTGZTOSZ'),e);
}
function AVHTGZTOSZ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('AVHTGZTOSZ')),'linkview_AVHTGZTOSZ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function YLIKFVPZJA_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('YLIKFVPZJA'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('YLIKFVPZJA').value=ApplyPictureToDate(Ctrl('YLIKFVPZJA').value,TranslatePicture(datePattern),'YLIKFVPZJA');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('YLIKFVPZJA'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('YLIKFVPZJA');
}
}
}
SetActiveField(Ctrl('YLIKFVPZJA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAOPE','D',w_DATAOPE,HtW(Ctrl('YLIKFVPZJA').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAOPE(HtW(Ctrl('YLIKFVPZJA').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function YLIKFVPZJA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YLIKFVPZJA'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('YLIKFVPZJA',w_DATAOPE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('YLIKFVPZJA');
SetActiveField(Ctrl('YLIKFVPZJA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YLIKFVPZJA'),e);
}
function YLIKFVPZJA_ZOOM_Click() {
LaunchCalendar(Ctrl('YLIKFVPZJA'));
}
function QSRYXQJCBZ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLAGFRAZ','C',w_FLAGFRAZ,HtW(getComboValue(Ctrl('QSRYXQJCBZ')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLAGFRAZ(HtW(getComboValue(Ctrl('QSRYXQJCBZ')),'C'),null,e);
return l_bSetResult;
}
}
function QSRYXQJCBZ_OnFocus(e) {
SetActiveField(Ctrl('QSRYXQJCBZ'),true);
}
function QSRYXQJCBZ_OnBlur(e) {
SetActiveField(Ctrl('QSRYXQJCBZ'),false);
}
function UJRFWINIVQ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOOPRAP','C',w_TIPOOPRAP,HtW(getComboValue(Ctrl('UJRFWINIVQ')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOOPRAP(HtW(getComboValue(Ctrl('UJRFWINIVQ')),'C'),null,e);
return l_bSetResult;
}
}
function UJRFWINIVQ_OnFocus(e) {
SetActiveField(Ctrl('UJRFWINIVQ'),true);
}
function UJRFWINIVQ_OnBlur(e) {
SetActiveField(Ctrl('UJRFWINIVQ'),false);
}
function XDPPAEWQFR_Valid(e) {
SetActiveField(Ctrl('XDPPAEWQFR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('idcauana','C',w_idcauana,HtW(Ctrl('XDPPAEWQFR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_idcauana(HtW(Ctrl('XDPPAEWQFR').value,'C'),null,e);
return l_bSetResult;
}
}
function XDPPAEWQFR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XDPPAEWQFR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XDPPAEWQFR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XDPPAEWQFR'),e);
}
function XDPPAEWQFR_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('XDPPAEWQFR')),'linkview_XDPPAEWQFR','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function LJBMCCABSS_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('appolire','C',w_appolire,HtW(getComboValue(Ctrl('LJBMCCABSS')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_appolire(HtW(getComboValue(Ctrl('LJBMCCABSS')),'C'),null,e);
return l_bSetResult;
}
}
function LJBMCCABSS_OnFocus(e) {
SetActiveField(Ctrl('LJBMCCABSS'),true);
}
function LJBMCCABSS_OnBlur(e) {
SetActiveField(Ctrl('LJBMCCABSS'),false);
}
function MKCXJZEKIG_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VALUTA','C',w_VALUTA,HtW(getComboValue(Ctrl('MKCXJZEKIG')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VALUTA(HtW(getComboValue(Ctrl('MKCXJZEKIG')),'C'),null,e);
return l_bSetResult;
}
}
function MKCXJZEKIG_OnFocus(e) {
SetActiveField(Ctrl('MKCXJZEKIG'),true);
}
function MKCXJZEKIG_OnBlur(e) {
SetActiveField(Ctrl('MKCXJZEKIG'),false);
}
function EDIXWZNSIC_Valid(e) {
SetActiveField(Ctrl('EDIXWZNSIC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('xTOTLIRE','N',w_xTOTLIRE,HtW(Ctrl('EDIXWZNSIC').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_xTOTLIRE(HtW(Ctrl('EDIXWZNSIC').value,'N'),null,e);
return l_bSetResult;
}
}
function EDIXWZNSIC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EDIXWZNSIC'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('EDIXWZNSIC'))) {
SPBOUILib.WtH('EDIXWZNSIC',w_xTOTLIRE,'N',15,2,'999999999999.99');
}
SetActiveField(Ctrl('EDIXWZNSIC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EDIXWZNSIC'),e);
}
function EDIXWZNSIC_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999.99"));
}
function PURPSXEVAI_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLAGCONT','C',w_FLAGCONT,HtW(getComboValue(Ctrl('PURPSXEVAI')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLAGCONT(HtW(getComboValue(Ctrl('PURPSXEVAI')),'C'),null,e);
return l_bSetResult;
}
}
function PURPSXEVAI_OnFocus(e) {
SetActiveField(Ctrl('PURPSXEVAI'),true);
}
function PURPSXEVAI_OnBlur(e) {
SetActiveField(Ctrl('PURPSXEVAI'),false);
}
function CTORYEJVDR_Valid(e) {
SetActiveField(Ctrl('CTORYEJVDR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('xTOTCONT','N',w_xTOTCONT,HtW(Ctrl('CTORYEJVDR').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_xTOTCONT(HtW(Ctrl('CTORYEJVDR').value,'N'),null,e);
return l_bSetResult;
}
}
function CTORYEJVDR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CTORYEJVDR'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('CTORYEJVDR'))) {
SPBOUILib.WtH('CTORYEJVDR',w_xTOTCONT,'N',15,2,'999999999999.99');
}
SetActiveField(Ctrl('CTORYEJVDR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CTORYEJVDR'),e);
}
function CTORYEJVDR_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999.99"));
}
function YTCDGCPEDJ_Valid(e) {
SetActiveField(Ctrl('YTCDGCPEDJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CAMBIO','N',w_CAMBIO,HtW(Ctrl('YTCDGCPEDJ').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAMBIO(HtW(Ctrl('YTCDGCPEDJ').value,'N'),null,e);
return l_bSetResult;
}
}
function YTCDGCPEDJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YTCDGCPEDJ'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('YTCDGCPEDJ',w_CAMBIO,'N',9,4,'9999.9999');
SetActiveField(Ctrl('YTCDGCPEDJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YTCDGCPEDJ'),e);
}
function YTCDGCPEDJ_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("9999.9999"));
}
function YXAKYHSWPW_Valid(e) {
SetActiveField(Ctrl('YXAKYHSWPW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMPIN','N',w_IMPIN,HtW(Ctrl('YXAKYHSWPW').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMPIN(HtW(Ctrl('YXAKYHSWPW').value,'N'),null,e);
return l_bSetResult;
}
}
function YXAKYHSWPW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YXAKYHSWPW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YXAKYHSWPW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YXAKYHSWPW'),e);
}
function DPCGXWDECV_Valid(e) {
SetActiveField(Ctrl('DPCGXWDECV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMPOUT','N',w_IMPOUT,HtW(Ctrl('DPCGXWDECV').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMPOUT(HtW(Ctrl('DPCGXWDECV').value,'N'),null,e);
return l_bSetResult;
}
}
function DPCGXWDECV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DPCGXWDECV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DPCGXWDECV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DPCGXWDECV'),e);
}
function RZIQZFKPUE_Valid(e) {
SetActiveField(Ctrl('RZIQZFKPUE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RAPPORTO','C',w_RAPPORTO,HtW(Ctrl('RZIQZFKPUE').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAPPORTO(HtW(Ctrl('RZIQZFKPUE').value,'C'),null,e);
return l_bSetResult;
}
}
function RZIQZFKPUE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RZIQZFKPUE'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('RZIQZFKPUE',w_RAPPORTO,'C',25,0,'@!');
SetActiveField(Ctrl('RZIQZFKPUE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RZIQZFKPUE'),e);
}
function RZIQZFKPUE_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function RZIQZFKPUE_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('RZIQZFKPUE')),'linkview_RZIQZFKPUE','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function QBLXDBODXR_Valid(e) {
SetActiveField(Ctrl('QBLXDBODXR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CONNESCLI','C',w_CONNESCLI,HtW(Ctrl('QBLXDBODXR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONNESCLI(HtW(Ctrl('QBLXDBODXR').value,'C'),null,e);
return l_bSetResult;
}
}
function QBLXDBODXR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QBLXDBODXR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QBLXDBODXR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QBLXDBODXR'),e);
}
function QBLXDBODXR_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('QBLXDBODXR')),'linkview_QBLXDBODXR','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function ADUIDSWRJW_Valid(e) {
SetActiveField(Ctrl('ADUIDSWRJW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PROQUOTA','N',w_PROQUOTA,HtW(Ctrl('ADUIDSWRJW').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PROQUOTA(HtW(Ctrl('ADUIDSWRJW').value,'N'),null,e);
return l_bSetResult;
}
}
function ADUIDSWRJW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ADUIDSWRJW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ADUIDSWRJW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ADUIDSWRJW'),e);
}
function LLXFEZDLPK_Valid(e) {
SetActiveField(Ctrl('LLXFEZDLPK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMPSARA','N',w_IMPSARA,HtW(Ctrl('LLXFEZDLPK').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMPSARA(HtW(Ctrl('LLXFEZDLPK').value,'N'),null,e);
return l_bSetResult;
}
}
function LLXFEZDLPK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LLXFEZDLPK'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('LLXFEZDLPK',w_IMPSARA,'N',19,2,'9999999999999999.99');
SetActiveField(Ctrl('LLXFEZDLPK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LLXFEZDLPK'),e);
}
function LLXFEZDLPK_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("9999999999999999.99"));
}
function TCOTJNZLGM_Valid(e) {
SetActiveField(Ctrl('TCOTJNZLGM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CONNESOPER','C',w_CONNESOPER,HtW(Ctrl('TCOTJNZLGM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONNESOPER(HtW(Ctrl('TCOTJNZLGM').value,'C'),null,e);
return l_bSetResult;
}
}
function TCOTJNZLGM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TCOTJNZLGM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TCOTJNZLGM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TCOTJNZLGM'),e);
}
function TCOTJNZLGM_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('TCOTJNZLGM')),'linkview_TCOTJNZLGM','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function AQSAREJVST_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOLEG','C',w_TIPOLEG,HtW(getComboValue(Ctrl('AQSAREJVST')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOLEG(HtW(getComboValue(Ctrl('AQSAREJVST')),'C'),null,e);
return l_bSetResult;
}
}
function AQSAREJVST_OnFocus(e) {
SetActiveField(Ctrl('AQSAREJVST'),true);
}
function AQSAREJVST_OnBlur(e) {
SetActiveField(Ctrl('AQSAREJVST'),false);
}
function JGKMKQMAHS_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('PAGASOGOP','C',w_PAGASOGOP,ChkboxValueAssign(Ctrl('JGKMKQMAHS'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PAGASOGOP(ChkboxValueAssign(Ctrl('JGKMKQMAHS'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function JGKMKQMAHS_OnFocus(e) {
SetActiveField(Ctrl('JGKMKQMAHS'),true);
}
function JGKMKQMAHS_OnBlur(e) {
SetActiveField(Ctrl('JGKMKQMAHS'),false);
}
function ULVCBLFVEU_Valid(e) {
SetActiveField(Ctrl('ULVCBLFVEU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CONNESBEN','C',w_CONNESBEN,HtW(Ctrl('ULVCBLFVEU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONNESBEN(HtW(Ctrl('ULVCBLFVEU').value,'C'),null,e);
return l_bSetResult;
}
}
function ULVCBLFVEU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ULVCBLFVEU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ULVCBLFVEU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ULVCBLFVEU'),e);
}
function ULVCBLFVEU_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('ULVCBLFVEU')),'linkview_ULVCBLFVEU','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function HWFHDWYMIU_Valid(e) {
SetActiveField(Ctrl('HWFHDWYMIU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CONNALTRO','C',w_CONNALTRO,HtW(Ctrl('HWFHDWYMIU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONNALTRO(HtW(Ctrl('HWFHDWYMIU').value,'C'),null,e);
return l_bSetResult;
}
}
function HWFHDWYMIU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HWFHDWYMIU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HWFHDWYMIU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HWFHDWYMIU'),e);
}
function HWFHDWYMIU_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('HWFHDWYMIU')),'linkview_HWFHDWYMIU','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function XPWBHUQUGP_Click() {
_modifyandopen(ToResource('jsp/pg_collegamenti_portlet.jsp'+'?w_CONNES='+URLenc(w_CONNALTRO)+'&ragsoc='+URLenc(w_xragsocalt)+'&m_cParameterSequence=w_CONNES,ragsoc')+'&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function AWPNTOJIRR_Valid(e) {
SetActiveField(Ctrl('AWPNTOJIRR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_RAG','C',w_C_RAG,HtW(Ctrl('AWPNTOJIRR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_RAG(HtW(Ctrl('AWPNTOJIRR').value,'C'),null,e);
return l_bSetResult;
}
}
function AWPNTOJIRR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AWPNTOJIRR'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('AWPNTOJIRR',w_C_RAG,'C',70,0,'@!');
SetActiveField(Ctrl('AWPNTOJIRR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AWPNTOJIRR'),e);
}
function AWPNTOJIRR_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function href_FRGXYSRNBR() {
_modifyandopen(ToResource('jsp/pg_stampa_ricerca_web_portlet.jsp'+'?nominativo='+URLenc(w_C_RAG)+'&m_cParameterSequence=nominativo')+'&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=510,width=1024',null)
}
function ODAYKSRECA_Valid(e) {
SetActiveField(Ctrl('ODAYKSRECA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_CTA','C',w_C_CTA,HtW(Ctrl('ODAYKSRECA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_CTA(HtW(Ctrl('ODAYKSRECA').value,'C'),null,e);
return l_bSetResult;
}
}
function ODAYKSRECA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ODAYKSRECA'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('ODAYKSRECA',w_C_CTA,'C',30,0,'@!');
SetActiveField(Ctrl('ODAYKSRECA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ODAYKSRECA'),e);
}
function ODAYKSRECA_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function ODAYKSRECA_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('ODAYKSRECA')),'linkview_ODAYKSRECA','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function NOTZPDMYIA_Valid(e) {
SetActiveField(Ctrl('NOTZPDMYIA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_PRV','C',w_C_PRV,HtW(Ctrl('NOTZPDMYIA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_PRV(HtW(Ctrl('NOTZPDMYIA').value,'C'),null,e);
return l_bSetResult;
}
}
function NOTZPDMYIA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NOTZPDMYIA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NOTZPDMYIA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NOTZPDMYIA'),e);
}
function RDAVOEETJG_Valid(e) {
SetActiveField(Ctrl('RDAVOEETJG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_CAP','C',w_C_CAP,HtW(Ctrl('RDAVOEETJG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_CAP(HtW(Ctrl('RDAVOEETJG').value,'C'),null,e);
return l_bSetResult;
}
}
function RDAVOEETJG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RDAVOEETJG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RDAVOEETJG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RDAVOEETJG'),e);
}
function BOTAJBWHHY_Valid(e) {
SetActiveField(Ctrl('BOTAJBWHHY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_CAB','C',w_C_CAB,HtW(Ctrl('BOTAJBWHHY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_CAB(HtW(Ctrl('BOTAJBWHHY').value,'C'),null,e);
return l_bSetResult;
}
}
function BOTAJBWHHY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BOTAJBWHHY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BOTAJBWHHY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BOTAJBWHHY'),e);
}
function VYLHWTRQNX_Valid(e) {
SetActiveField(Ctrl('VYLHWTRQNX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_IND','C',w_C_IND,HtW(Ctrl('VYLHWTRQNX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_IND(HtW(Ctrl('VYLHWTRQNX').value,'C'),null,e);
return l_bSetResult;
}
}
function VYLHWTRQNX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VYLHWTRQNX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VYLHWTRQNX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VYLHWTRQNX'),e);
}
function YVIKEGPYPM_Valid(e) {
SetActiveField(Ctrl('YVIKEGPYPM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_STA','C',w_C_STA,HtW(Ctrl('YVIKEGPYPM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_STA(HtW(Ctrl('YVIKEGPYPM').value,'C'),null,e);
return l_bSetResult;
}
}
function YVIKEGPYPM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YVIKEGPYPM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YVIKEGPYPM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YVIKEGPYPM'),e);
}
function YVIKEGPYPM_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('YVIKEGPYPM')),'linkview_YVIKEGPYPM','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function HNMYJPHSQN_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOINT2','C',w_TIPOINT2,HtW(getComboValue(Ctrl('HNMYJPHSQN')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOINT2(HtW(getComboValue(Ctrl('HNMYJPHSQN')),'C'),null,e);
return l_bSetResult;
}
}
function HNMYJPHSQN_OnFocus(e) {
SetActiveField(Ctrl('HNMYJPHSQN'),true);
}
function HNMYJPHSQN_OnBlur(e) {
SetActiveField(Ctrl('HNMYJPHSQN'),false);
}
function CDJFSCCGNX_Valid(e) {
SetActiveField(Ctrl('CDJFSCCGNX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODINT2','C',w_CODINT2,HtW(Ctrl('CDJFSCCGNX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODINT2(HtW(Ctrl('CDJFSCCGNX').value,'C'),null,e);
return l_bSetResult;
}
}
function CDJFSCCGNX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CDJFSCCGNX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CDJFSCCGNX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CDJFSCCGNX'),e);
}
function CDJFSCCGNX_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('CDJFSCCGNX')),'linkview_CDJFSCCGNX','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function VYDRMHACRY_Valid(e) {
SetActiveField(Ctrl('VYDRMHACRY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCINTER','C',w_DESCINTER,HtW(Ctrl('VYDRMHACRY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCINTER(HtW(Ctrl('VYDRMHACRY').value,'C'),null,e);
return l_bSetResult;
}
}
function VYDRMHACRY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VYDRMHACRY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VYDRMHACRY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VYDRMHACRY'),e);
}
function NYRJHOZOON_Valid(e) {
SetActiveField(Ctrl('NYRJHOZOON'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PAESE','C',w_PAESE,HtW(Ctrl('NYRJHOZOON').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PAESE(HtW(Ctrl('NYRJHOZOON').value,'C'),null,e);
return l_bSetResult;
}
}
function NYRJHOZOON_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NYRJHOZOON'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NYRJHOZOON'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NYRJHOZOON'),e);
}
function NYRJHOZOON_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('NYRJHOZOON')),'linkview_NYRJHOZOON','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function YBNJCVPDUM_Valid(e) {
SetActiveField(Ctrl('YBNJCVPDUM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_RAPPORTO','C',w_C_RAPPORTO,HtW(Ctrl('YBNJCVPDUM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_RAPPORTO(HtW(Ctrl('YBNJCVPDUM').value,'C'),null,e);
return l_bSetResult;
}
}
function YBNJCVPDUM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YBNJCVPDUM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YBNJCVPDUM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YBNJCVPDUM'),e);
}
function YQINIDXZSL_Valid(e) {
SetActiveField(Ctrl('YQINIDXZSL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODCAB2','C',w_CODCAB2,HtW(Ctrl('YQINIDXZSL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODCAB2(HtW(Ctrl('YQINIDXZSL').value,'C'),null,e);
return l_bSetResult;
}
}
function YQINIDXZSL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YQINIDXZSL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YQINIDXZSL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YQINIDXZSL'),e);
}
function YQINIDXZSL_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('YQINIDXZSL')),'linkview_YQINIDXZSL','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function FFCAGQAZHK_Valid(e) {
SetActiveField(Ctrl('FFCAGQAZHK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESC2','C',w_DESC2,HtW(Ctrl('FFCAGQAZHK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESC2(HtW(Ctrl('FFCAGQAZHK').value,'C'),null,e);
return l_bSetResult;
}
}
function FFCAGQAZHK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FFCAGQAZHK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FFCAGQAZHK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FFCAGQAZHK'),e);
}
function ACAPFGYRVI_Valid(e) {
SetActiveField(Ctrl('ACAPFGYRVI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PROV2','C',w_PROV2,HtW(Ctrl('ACAPFGYRVI').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PROV2(HtW(Ctrl('ACAPFGYRVI').value,'C'),null,e);
return l_bSetResult;
}
}
function ACAPFGYRVI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ACAPFGYRVI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ACAPFGYRVI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ACAPFGYRVI'),e);
}
function GXMZZZHVBR_Valid(e) {
SetActiveField(Ctrl('GXMZZZHVBR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ZCPARTE','C',w_ZCPARTE,HtW(Ctrl('GXMZZZHVBR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ZCPARTE(HtW(Ctrl('GXMZZZHVBR').value,'C'),null,e);
return l_bSetResult;
}
}
function GXMZZZHVBR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GXMZZZHVBR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GXMZZZHVBR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GXMZZZHVBR'),e);
}
function XCYZDRXAMJ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('NOSARA','C',w_NOSARA,ChkboxValueAssign(Ctrl('XCYZDRXAMJ'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOSARA(ChkboxValueAssign(Ctrl('XCYZDRXAMJ'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function XCYZDRXAMJ_OnFocus(e) {
SetActiveField(Ctrl('XCYZDRXAMJ'),true);
}
function XCYZDRXAMJ_OnBlur(e) {
SetActiveField(Ctrl('XCYZDRXAMJ'),false);
}
function href_RHYSMJSILT() {
_modifyandopen(ToResource('jsp/pg_linkxper_portlet.jsp'+'?w_CONNES='+URLenc(w_CONNESCLI)+'&ragsoc='+URLenc(w_xragsocper)+'&w_RAPPORTO='+URLenc(w_RAPPORTO)+'&descrap='+URLenc(w_xdescrap)+'&w_IDOPER='+URLenc(w_IDBASE)+'&tipope='+URLenc('2')+'&w_CONNESOPER='+URLenc(w_CONNESOPER)+'&w_CONNESBEN='+URLenc(w_CONNESBEN)+'&ragsocope='+URLenc(w_xragsocct)+'&ragsocben='+URLenc(w_xragsocben)+'&m_cParameterSequence=w_CONNES,ragsoc,w_RAPPORTO,descrap,w_IDOPER,tipope,w_CONNESOPER,w_CONNESBEN,ragsocope,ragsocben')+'&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=480,width=750',null)
}
function LEHLEQRJPH_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('NOPROT','N',w_NOPROT,ChkboxValueAssign(Ctrl('LEHLEQRJPH'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOPROT(ChkboxValueAssign(Ctrl('LEHLEQRJPH'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function LEHLEQRJPH_OnFocus(e) {
SetActiveField(Ctrl('LEHLEQRJPH'),true);
}
function LEHLEQRJPH_OnBlur(e) {
SetActiveField(Ctrl('LEHLEQRJPH'),false);
}
function QEFXECTWSF_Valid(e) {
SetActiveField(Ctrl('QEFXECTWSF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('OPERAG','C',w_OPERAG,HtW(Ctrl('QEFXECTWSF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_OPERAG(HtW(Ctrl('QEFXECTWSF').value,'C'),null,e);
return l_bSetResult;
}
}
function QEFXECTWSF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QEFXECTWSF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QEFXECTWSF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QEFXECTWSF'),e);
}
function QEFXECTWSF_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('QEFXECTWSF')),'linkview_QEFXECTWSF','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function VMRTFBBQHL_Valid(e) {
SetActiveField(Ctrl('VMRTFBBQHL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RESPINS','C',w_RESPINS,HtW(Ctrl('VMRTFBBQHL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RESPINS(HtW(Ctrl('VMRTFBBQHL').value,'C'),null,e);
return l_bSetResult;
}
}
function VMRTFBBQHL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VMRTFBBQHL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VMRTFBBQHL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VMRTFBBQHL'),e);
}
function KDWBJNGUTK_Valid(e) {
SetActiveField(Ctrl('KDWBJNGUTK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('INFORM','C',w_INFORM,HtW(Ctrl('KDWBJNGUTK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_INFORM(HtW(Ctrl('KDWBJNGUTK').value,'C'),null,e);
return l_bSetResult;
}
}
function KDWBJNGUTK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KDWBJNGUTK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KDWBJNGUTK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KDWBJNGUTK'),e);
}
function VSHUPFYWOC_Valid(e) {
SetActiveField(Ctrl('VSHUPFYWOC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NATURA','C',w_NATURA,HtW(Ctrl('VSHUPFYWOC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NATURA(HtW(Ctrl('VSHUPFYWOC').value,'C'),null,e);
return l_bSetResult;
}
}
function VSHUPFYWOC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VSHUPFYWOC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VSHUPFYWOC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VSHUPFYWOC'),e);
}
function VASVGQZJGP_Valid(e) {
SetActiveField(Ctrl('VASVGQZJGP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SCOPO','C',w_SCOPO,HtW(Ctrl('VASVGQZJGP').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SCOPO(HtW(Ctrl('VASVGQZJGP').value,'C'),null,e);
return l_bSetResult;
}
}
function VASVGQZJGP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VASVGQZJGP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VASVGQZJGP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VASVGQZJGP'),e);
}
function SMZCOQAIDC_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('SV58550','C',w_SV58550,HtW(getComboValue(Ctrl('SMZCOQAIDC')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SV58550(HtW(getComboValue(Ctrl('SMZCOQAIDC')),'C'),null,e);
return l_bSetResult;
}
}
function SMZCOQAIDC_OnFocus(e) {
SetActiveField(Ctrl('SMZCOQAIDC'),true);
}
function SMZCOQAIDC_OnBlur(e) {
SetActiveField(Ctrl('SMZCOQAIDC'),false);
}
function MDVEMSKFNR_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('SV58550MA','C',w_SV58550MA,HtW(getComboValue(Ctrl('MDVEMSKFNR')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SV58550MA(HtW(getComboValue(Ctrl('MDVEMSKFNR')),'C'),null,e);
return l_bSetResult;
}
}
function MDVEMSKFNR_OnFocus(e) {
SetActiveField(Ctrl('MDVEMSKFNR'),true);
}
function MDVEMSKFNR_OnBlur(e) {
SetActiveField(Ctrl('MDVEMSKFNR'),false);
}
function JEKLOGLRAN_Valid(e) {
SetActiveField(Ctrl('JEKLOGLRAN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('MEZPAG','C',w_MEZPAG,HtW(Ctrl('JEKLOGLRAN').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_MEZPAG(HtW(Ctrl('JEKLOGLRAN').value,'C'),null,e);
return l_bSetResult;
}
}
function JEKLOGLRAN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JEKLOGLRAN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JEKLOGLRAN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JEKLOGLRAN'),e);
}
function RQKHNRJEDR_Valid(e) {
SetActiveField(Ctrl('RQKHNRJEDR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PRESTAZ','C',w_PRESTAZ,HtW(Ctrl('RQKHNRJEDR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PRESTAZ(HtW(Ctrl('RQKHNRJEDR').value,'C'),null,e);
return l_bSetResult;
}
}
function RQKHNRJEDR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RQKHNRJEDR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RQKHNRJEDR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RQKHNRJEDR'),e);
}
function YMKLIGEOKH_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VASP','C',w_VASP,HtW(getComboValue(Ctrl('YMKLIGEOKH')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VASP(HtW(getComboValue(Ctrl('YMKLIGEOKH')),'C'),null,e);
return l_bSetResult;
}
}
function YMKLIGEOKH_OnFocus(e) {
SetActiveField(Ctrl('YMKLIGEOKH'),true);
}
function YMKLIGEOKH_OnBlur(e) {
SetActiveField(Ctrl('YMKLIGEOKH'),false);
}
function WNMMMNSARU_Valid(e) {
SetActiveField(Ctrl('WNMMMNSARU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CONNESDOC','C',w_CONNESDOC,HtW(Ctrl('WNMMMNSARU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONNESDOC(HtW(Ctrl('WNMMMNSARU').value,'C'),null,e);
return l_bSetResult;
}
}
function WNMMMNSARU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WNMMMNSARU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('WNMMMNSARU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WNMMMNSARU'),e);
}
function WNMMMNSARU_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('WNMMMNSARU')),'linkview_WNMMMNSARU','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function JDTKGSGMAF_Valid(e) {
SetActiveField(Ctrl('JDTKGSGMAF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('MTCN','C',w_MTCN,HtW(Ctrl('JDTKGSGMAF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_MTCN(HtW(Ctrl('JDTKGSGMAF').value,'C'),null,e);
return l_bSetResult;
}
}
function JDTKGSGMAF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JDTKGSGMAF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JDTKGSGMAF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JDTKGSGMAF'),e);
}
function CKJQULDXKW_Valid(e) {
SetActiveField(Ctrl('CKJQULDXKW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DURAT','C',w_DURAT,HtW(Ctrl('CKJQULDXKW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DURAT(HtW(Ctrl('CKJQULDXKW').value,'C'),null,e);
return l_bSetResult;
}
}
function CKJQULDXKW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CKJQULDXKW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CKJQULDXKW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CKJQULDXKW'),e);
}
function CKJQULDXKW_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('CKJQULDXKW')),'linkview_CKJQULDXKW','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function MXYTQLATHC_Valid(e) {
SetActiveField(Ctrl('MXYTQLATHC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RFREQ','N',w_RFREQ,HtW(Ctrl('MXYTQLATHC').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RFREQ(HtW(Ctrl('MXYTQLATHC').value,'N'),null,e);
return l_bSetResult;
}
}
function MXYTQLATHC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MXYTQLATHC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MXYTQLATHC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MXYTQLATHC'),e);
}
function SXTYCPHBIM_Valid(e) {
SetActiveField(Ctrl('SXTYCPHBIM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('AMMONT','C',w_AMMONT,HtW(Ctrl('SXTYCPHBIM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_AMMONT(HtW(Ctrl('SXTYCPHBIM').value,'C'),null,e);
return l_bSetResult;
}
}
function SXTYCPHBIM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SXTYCPHBIM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SXTYCPHBIM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SXTYCPHBIM'),e);
}
function SXTYCPHBIM_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('SXTYCPHBIM')),'linkview_SXTYCPHBIM','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function KBIUAXUDXA_Valid(e) {
SetActiveField(Ctrl('KBIUAXUDXA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RIMP','N',w_RIMP,HtW(Ctrl('KBIUAXUDXA').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RIMP(HtW(Ctrl('KBIUAXUDXA').value,'N'),null,e);
return l_bSetResult;
}
}
function KBIUAXUDXA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KBIUAXUDXA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KBIUAXUDXA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KBIUAXUDXA'),e);
}
function QJSTZIPOQB_Valid(e) {
SetActiveField(Ctrl('QJSTZIPOQB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('AREAGEO','C',w_AREAGEO,HtW(Ctrl('QJSTZIPOQB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_AREAGEO(HtW(Ctrl('QJSTZIPOQB').value,'C'),null,e);
return l_bSetResult;
}
}
function QJSTZIPOQB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QJSTZIPOQB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QJSTZIPOQB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QJSTZIPOQB'),e);
}
function QJSTZIPOQB_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('QJSTZIPOQB')),'linkview_QJSTZIPOQB','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function UDAYHICPVB_Valid(e) {
SetActiveField(Ctrl('UDAYHICPVB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RAREA','N',w_RAREA,HtW(Ctrl('UDAYHICPVB').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAREA(HtW(Ctrl('UDAYHICPVB').value,'N'),null,e);
return l_bSetResult;
}
}
function UDAYHICPVB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UDAYHICPVB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UDAYHICPVB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UDAYHICPVB'),e);
}
function SFFFOYOWNH_Valid(e) {
SetActiveField(Ctrl('SFFFOYOWNH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('MODSVOL','C',w_MODSVOL,HtW(Ctrl('SFFFOYOWNH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_MODSVOL(HtW(Ctrl('SFFFOYOWNH').value,'C'),null,e);
return l_bSetResult;
}
}
function SFFFOYOWNH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SFFFOYOWNH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SFFFOYOWNH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SFFFOYOWNH'),e);
}
function SFFFOYOWNH_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('SFFFOYOWNH')),'linkview_SFFFOYOWNH','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function ETALZDRBSO_Valid(e) {
SetActiveField(Ctrl('ETALZDRBSO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RCOMP','N',w_RCOMP,HtW(Ctrl('ETALZDRBSO').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RCOMP(HtW(Ctrl('ETALZDRBSO').value,'N'),null,e);
return l_bSetResult;
}
}
function ETALZDRBSO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ETALZDRBSO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ETALZDRBSO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ETALZDRBSO'),e);
}
function NOBMPHKVTX_Valid(e) {
SetActiveField(Ctrl('NOBMPHKVTX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RAGIO','C',w_RAGIO,HtW(Ctrl('NOBMPHKVTX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAGIO(HtW(Ctrl('NOBMPHKVTX').value,'C'),null,e);
return l_bSetResult;
}
}
function NOBMPHKVTX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NOBMPHKVTX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NOBMPHKVTX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NOBMPHKVTX'),e);
}
function NOBMPHKVTX_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('NOBMPHKVTX')),'linkview_NOBMPHKVTX','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function QBTVZDKLCO_Valid(e) {
SetActiveField(Ctrl('QBTVZDKLCO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RRAGIO','N',w_RRAGIO,HtW(Ctrl('QBTVZDKLCO').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RRAGIO(HtW(Ctrl('QBTVZDKLCO').value,'N'),null,e);
return l_bSetResult;
}
}
function QBTVZDKLCO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QBTVZDKLCO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QBTVZDKLCO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QBTVZDKLCO'),e);
}
function DJOWYRMDDC_Valid(e) {
SetActiveField(Ctrl('DJOWYRMDDC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TIPO','C',w_TIPO,HtW(Ctrl('DJOWYRMDDC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPO(HtW(Ctrl('DJOWYRMDDC').value,'C'),null,e);
return l_bSetResult;
}
}
function DJOWYRMDDC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DJOWYRMDDC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DJOWYRMDDC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DJOWYRMDDC'),e);
}
function DJOWYRMDDC_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('DJOWYRMDDC')),'linkview_DJOWYRMDDC','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function RUWEXWJASG_Valid(e) {
SetActiveField(Ctrl('RUWEXWJASG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RTIPO','N',w_RTIPO,HtW(Ctrl('RUWEXWJASG').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RTIPO(HtW(Ctrl('RUWEXWJASG').value,'N'),null,e);
return l_bSetResult;
}
}
function RUWEXWJASG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RUWEXWJASG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RUWEXWJASG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RUWEXWJASG'),e);
}
function SMVVFHCEHA_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('RISGLOB','C',w_RISGLOB,HtW(getComboValue(Ctrl('SMVVFHCEHA')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RISGLOB(HtW(getComboValue(Ctrl('SMVVFHCEHA')),'C'),null,e);
return l_bSetResult;
}
}
function SMVVFHCEHA_OnFocus(e) {
SetActiveField(Ctrl('SMVVFHCEHA'),true);
}
function SMVVFHCEHA_OnBlur(e) {
SetActiveField(Ctrl('SMVVFHCEHA'),false);
}
function DOXBACRWUU_Valid(e) {
SetActiveField(Ctrl('DOXBACRWUU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('MITIG','N',w_MITIG,HtW(Ctrl('DOXBACRWUU').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_MITIG(HtW(Ctrl('DOXBACRWUU').value,'N'),null,e);
return l_bSetResult;
}
}
function DOXBACRWUU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DOXBACRWUU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DOXBACRWUU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DOXBACRWUU'),e);
}
function OXGBDTWKSX_Valid(e) {
SetActiveField(Ctrl('OXGBDTWKSX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('MITIGDOC','C',w_MITIGDOC,HtW(Ctrl('OXGBDTWKSX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_MITIGDOC(HtW(Ctrl('OXGBDTWKSX').value,'C'),null,e);
return l_bSetResult;
}
}
function OXGBDTWKSX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OXGBDTWKSX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OXGBDTWKSX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OXGBDTWKSX'),e);
}
linkpc_url.u('TQDGESLQVD',function(){return 'ardt_sogopeprov?m_bInnerChild=true'+GetLinkPCKeys('ardt_sogopeprov')+'&m_bRowsChild='+EnableChild('ardt_sogopeprov')})
linkpc_url.u('BOAFVDQFRN',function(){return 'ardt_xlientiope?m_bInnerChild=true'+GetLinkPCKeys('ardt_xlientiope')+'&m_bRowsChild='+EnableChild('ardt_xlientiope')})
linkpc_url.u('OCTDIOXFMI',function(){return 'ardt_xeneficope?m_bInnerChild=true'+GetLinkPCKeys('ardt_xeneficope')+'&m_bRowsChild='+EnableChild('ardt_xeneficope')})
linkpc_url.u('NOKYMTFBFL',function(){return 'ardt_xerzistiope?m_bInnerChild=true'+GetLinkPCKeys('ardt_xerzistiope')+'&m_bRowsChild='+EnableChild('ardt_xerzistiope')})
linkpc_url.u('QLURQBXKEV',function(){return 'ardt_xapcoll?m_bInnerChild=true'+GetLinkPCKeys('ardt_xapcoll')+'&m_bRowsChild='+EnableChild('ardt_xapcoll')})
linkpc_url.u('OZMPVCAYQN',function(){return 'ardt_docopebo?m_bInnerChild=true'+GetLinkPCKeys('ardt_docopebo')+'&m_bRowsChild='+EnableChild('ardt_docopebo')})
linkpc_url.u('RZOXJTRIYP',function(){return 'armt_xperazbo_agg?m_bInnerChild=true'+GetLinkPCKeys('armt_xperazbo_agg')+'&m_bRowsChild='+EnableChild('armt_xperazbo_agg')})
linkpc_url.u('HPXRKUBEED',function(){return 'ardt_xpe_contante?m_bInnerChild=true'+GetLinkPCKeys('ardt_xpe_contante')+'&m_bRowsChild='+EnableChild('ardt_xpe_contante')})
_ResetTracker();
function setEventHandlers() {
var c;
function XPWBHUQUGP_wrap_OnClick(event) {
return XPWBHUQUGP_Click();
}
SPBOUILib.SetButtonClick('XPWBHUQUGP',XPWBHUQUGP_wrap_OnClick);
function FRGXYSRNBR_wrap_OnClick(event) {
return href_FRGXYSRNBR();
}
SPBOUILib.SetImageClick('FRGXYSRNBR',FRGXYSRNBR_wrap_OnClick);
function FRGXYSRNBR_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('FRGXYSRNBR',FRGXYSRNBR_wrap_OnKeyDown);
function RHYSMJSILT_wrap_OnClick(event) {
return href_RHYSMJSILT();
}
SPBOUILib.SetImageClick('RHYSMJSILT',RHYSMJSILT_wrap_OnClick);
function RHYSMJSILT_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('RHYSMJSILT',RHYSMJSILT_wrap_OnKeyDown);
if (Ne(m_cFunction,'view')) {
function NHERHRZTFP_wrap_Valid(event) {
return NHERHRZTFP_Valid(event);
}
SPBOUILib.SetInputExit('NHERHRZTFP',NHERHRZTFP_wrap_Valid);
function NHERHRZTFP_wrap_OnFocus(event) {
return NHERHRZTFP_OnFocus(event);
}
SPBOUILib.SetInputEnter('NHERHRZTFP',NHERHRZTFP_wrap_OnFocus);
function NHERHRZTFP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NHERHRZTFP',NHERHRZTFP_wrap_OnKeyDown);
function AVHTGZTOSZ_wrap_Valid(event) {
return AVHTGZTOSZ_Valid(event);
}
SPBOUILib.SetInputExit('AVHTGZTOSZ',AVHTGZTOSZ_wrap_Valid);
function AVHTGZTOSZ_wrap_OnFocus(event) {
return AVHTGZTOSZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('AVHTGZTOSZ',AVHTGZTOSZ_wrap_OnFocus);
function AVHTGZTOSZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AVHTGZTOSZ',AVHTGZTOSZ_wrap_OnKeyDown);
function AVHTGZTOSZ_ZOOM_setHandlers() {
function AVHTGZTOSZ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?AVHTGZTOSZ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('AVHTGZTOSZ_ZOOM',AVHTGZTOSZ_ZOOM_wrap_OnClick);
function AVHTGZTOSZ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('AVHTGZTOSZ_ZOOM',AVHTGZTOSZ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('AVHTGZTOSZ',AVHTGZTOSZ_ZOOM_setHandlers);
function YLIKFVPZJA_wrap_Valid(event) {
return YLIKFVPZJA_Valid(event);
}
SPBOUILib.SetInputExit('YLIKFVPZJA',YLIKFVPZJA_wrap_Valid);
function YLIKFVPZJA_wrap_OnFocus(event) {
return YLIKFVPZJA_OnFocus(event);
}
SPBOUILib.SetInputEnter('YLIKFVPZJA',YLIKFVPZJA_wrap_OnFocus);
function YLIKFVPZJA_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('YLIKFVPZJA',YLIKFVPZJA_wrap_OnKeyPress);
function YLIKFVPZJA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('YLIKFVPZJA',YLIKFVPZJA_wrap_OnKeyDown);
function YLIKFVPZJA_ZOOM_setHandlers() {
function YLIKFVPZJA_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?YLIKFVPZJA_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('YLIKFVPZJA_ZOOM',YLIKFVPZJA_ZOOM_wrap_OnClick);
function YLIKFVPZJA_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('YLIKFVPZJA_ZOOM',YLIKFVPZJA_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('YLIKFVPZJA',YLIKFVPZJA_ZOOM_setHandlers);
function QSRYXQJCBZ_wrap_Valid(event) {
return QSRYXQJCBZ_Valid(event);
}
SPBOUILib.SetComboChange('QSRYXQJCBZ',QSRYXQJCBZ_wrap_Valid);
function QSRYXQJCBZ_wrap_OnFocus(event) {
return QSRYXQJCBZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('QSRYXQJCBZ',QSRYXQJCBZ_wrap_OnFocus);
function QSRYXQJCBZ_wrap_Blur(event) {
return QSRYXQJCBZ_OnBlur(event);
}
SPBOUILib.SetInputExit('QSRYXQJCBZ',QSRYXQJCBZ_wrap_Blur);
function UJRFWINIVQ_wrap_Valid(event) {
return UJRFWINIVQ_Valid(event);
}
SPBOUILib.SetComboChange('UJRFWINIVQ',UJRFWINIVQ_wrap_Valid);
function UJRFWINIVQ_wrap_OnFocus(event) {
return UJRFWINIVQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('UJRFWINIVQ',UJRFWINIVQ_wrap_OnFocus);
function UJRFWINIVQ_wrap_Blur(event) {
return UJRFWINIVQ_OnBlur(event);
}
SPBOUILib.SetInputExit('UJRFWINIVQ',UJRFWINIVQ_wrap_Blur);
function XDPPAEWQFR_wrap_Valid(event) {
return XDPPAEWQFR_Valid(event);
}
SPBOUILib.SetInputExit('XDPPAEWQFR',XDPPAEWQFR_wrap_Valid);
function XDPPAEWQFR_wrap_OnFocus(event) {
return XDPPAEWQFR_OnFocus(event);
}
SPBOUILib.SetInputEnter('XDPPAEWQFR',XDPPAEWQFR_wrap_OnFocus);
function XDPPAEWQFR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XDPPAEWQFR',XDPPAEWQFR_wrap_OnKeyDown);
function XDPPAEWQFR_ZOOM_setHandlers() {
function XDPPAEWQFR_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?XDPPAEWQFR_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('XDPPAEWQFR_ZOOM',XDPPAEWQFR_ZOOM_wrap_OnClick);
function XDPPAEWQFR_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('XDPPAEWQFR_ZOOM',XDPPAEWQFR_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('XDPPAEWQFR',XDPPAEWQFR_ZOOM_setHandlers);
function LJBMCCABSS_wrap_Valid(event) {
return LJBMCCABSS_Valid(event);
}
SPBOUILib.SetComboChange('LJBMCCABSS',LJBMCCABSS_wrap_Valid);
function LJBMCCABSS_wrap_OnFocus(event) {
return LJBMCCABSS_OnFocus(event);
}
SPBOUILib.SetInputEnter('LJBMCCABSS',LJBMCCABSS_wrap_OnFocus);
function LJBMCCABSS_wrap_Blur(event) {
return LJBMCCABSS_OnBlur(event);
}
SPBOUILib.SetInputExit('LJBMCCABSS',LJBMCCABSS_wrap_Blur);
function MKCXJZEKIG_wrap_Valid(event) {
return MKCXJZEKIG_Valid(event);
}
SPBOUILib.SetComboChange('MKCXJZEKIG',MKCXJZEKIG_wrap_Valid);
function MKCXJZEKIG_wrap_OnFocus(event) {
return MKCXJZEKIG_OnFocus(event);
}
SPBOUILib.SetInputEnter('MKCXJZEKIG',MKCXJZEKIG_wrap_OnFocus);
function MKCXJZEKIG_wrap_Blur(event) {
return MKCXJZEKIG_OnBlur(event);
}
SPBOUILib.SetInputExit('MKCXJZEKIG',MKCXJZEKIG_wrap_Blur);
function EDIXWZNSIC_wrap_Valid(event) {
return EDIXWZNSIC_Valid(event);
}
SPBOUILib.SetInputExit('EDIXWZNSIC',EDIXWZNSIC_wrap_Valid);
function EDIXWZNSIC_wrap_OnFocus(event) {
return EDIXWZNSIC_OnFocus(event);
}
SPBOUILib.SetInputEnter('EDIXWZNSIC',EDIXWZNSIC_wrap_OnFocus);
function EDIXWZNSIC_wrap_OnKeyPress(event) {
return EDIXWZNSIC_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('EDIXWZNSIC',EDIXWZNSIC_wrap_OnKeyPress);
function EDIXWZNSIC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('EDIXWZNSIC',EDIXWZNSIC_wrap_OnKeyDown);
function PURPSXEVAI_wrap_Valid(event) {
return PURPSXEVAI_Valid(event);
}
SPBOUILib.SetComboChange('PURPSXEVAI',PURPSXEVAI_wrap_Valid);
function PURPSXEVAI_wrap_OnFocus(event) {
return PURPSXEVAI_OnFocus(event);
}
SPBOUILib.SetInputEnter('PURPSXEVAI',PURPSXEVAI_wrap_OnFocus);
function PURPSXEVAI_wrap_Blur(event) {
return PURPSXEVAI_OnBlur(event);
}
SPBOUILib.SetInputExit('PURPSXEVAI',PURPSXEVAI_wrap_Blur);
function CTORYEJVDR_wrap_Valid(event) {
return CTORYEJVDR_Valid(event);
}
SPBOUILib.SetInputExit('CTORYEJVDR',CTORYEJVDR_wrap_Valid);
function CTORYEJVDR_wrap_OnFocus(event) {
return CTORYEJVDR_OnFocus(event);
}
SPBOUILib.SetInputEnter('CTORYEJVDR',CTORYEJVDR_wrap_OnFocus);
function CTORYEJVDR_wrap_OnKeyPress(event) {
return CTORYEJVDR_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('CTORYEJVDR',CTORYEJVDR_wrap_OnKeyPress);
function CTORYEJVDR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CTORYEJVDR',CTORYEJVDR_wrap_OnKeyDown);
function YTCDGCPEDJ_wrap_Valid(event) {
return YTCDGCPEDJ_Valid(event);
}
SPBOUILib.SetInputExit('YTCDGCPEDJ',YTCDGCPEDJ_wrap_Valid);
function YTCDGCPEDJ_wrap_OnFocus(event) {
return YTCDGCPEDJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('YTCDGCPEDJ',YTCDGCPEDJ_wrap_OnFocus);
function YTCDGCPEDJ_wrap_OnKeyPress(event) {
return YTCDGCPEDJ_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('YTCDGCPEDJ',YTCDGCPEDJ_wrap_OnKeyPress);
function YTCDGCPEDJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YTCDGCPEDJ',YTCDGCPEDJ_wrap_OnKeyDown);
function YXAKYHSWPW_wrap_Valid(event) {
return YXAKYHSWPW_Valid(event);
}
SPBOUILib.SetInputExit('YXAKYHSWPW',YXAKYHSWPW_wrap_Valid);
function YXAKYHSWPW_wrap_OnFocus(event) {
return YXAKYHSWPW_OnFocus(event);
}
SPBOUILib.SetInputEnter('YXAKYHSWPW',YXAKYHSWPW_wrap_OnFocus);
function YXAKYHSWPW_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('YXAKYHSWPW',YXAKYHSWPW_wrap_OnKeyPress);
function YXAKYHSWPW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YXAKYHSWPW',YXAKYHSWPW_wrap_OnKeyDown);
function DPCGXWDECV_wrap_Valid(event) {
return DPCGXWDECV_Valid(event);
}
SPBOUILib.SetInputExit('DPCGXWDECV',DPCGXWDECV_wrap_Valid);
function DPCGXWDECV_wrap_OnFocus(event) {
return DPCGXWDECV_OnFocus(event);
}
SPBOUILib.SetInputEnter('DPCGXWDECV',DPCGXWDECV_wrap_OnFocus);
function DPCGXWDECV_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('DPCGXWDECV',DPCGXWDECV_wrap_OnKeyPress);
function DPCGXWDECV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DPCGXWDECV',DPCGXWDECV_wrap_OnKeyDown);
function RZIQZFKPUE_wrap_Valid(event) {
return RZIQZFKPUE_Valid(event);
}
SPBOUILib.SetInputExit('RZIQZFKPUE',RZIQZFKPUE_wrap_Valid);
function RZIQZFKPUE_wrap_OnFocus(event) {
return RZIQZFKPUE_OnFocus(event);
}
SPBOUILib.SetInputEnter('RZIQZFKPUE',RZIQZFKPUE_wrap_OnFocus);
function RZIQZFKPUE_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('RZIQZFKPUE',RZIQZFKPUE_wrap_OnKeyPress);
function RZIQZFKPUE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RZIQZFKPUE',RZIQZFKPUE_wrap_OnKeyDown);
function RZIQZFKPUE_ZOOM_setHandlers() {
function RZIQZFKPUE_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?RZIQZFKPUE_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('RZIQZFKPUE_ZOOM',RZIQZFKPUE_ZOOM_wrap_OnClick);
function RZIQZFKPUE_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('RZIQZFKPUE_ZOOM',RZIQZFKPUE_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('RZIQZFKPUE',RZIQZFKPUE_ZOOM_setHandlers);
function QBLXDBODXR_wrap_Valid(event) {
return QBLXDBODXR_Valid(event);
}
SPBOUILib.SetInputExit('QBLXDBODXR',QBLXDBODXR_wrap_Valid);
function QBLXDBODXR_wrap_OnFocus(event) {
return QBLXDBODXR_OnFocus(event);
}
SPBOUILib.SetInputEnter('QBLXDBODXR',QBLXDBODXR_wrap_OnFocus);
function QBLXDBODXR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QBLXDBODXR',QBLXDBODXR_wrap_OnKeyDown);
function QBLXDBODXR_ZOOM_setHandlers() {
function QBLXDBODXR_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?QBLXDBODXR_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('QBLXDBODXR_ZOOM',QBLXDBODXR_ZOOM_wrap_OnClick);
function QBLXDBODXR_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('QBLXDBODXR_ZOOM',QBLXDBODXR_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('QBLXDBODXR',QBLXDBODXR_ZOOM_setHandlers);
function ADUIDSWRJW_wrap_Valid(event) {
return ADUIDSWRJW_Valid(event);
}
SPBOUILib.SetInputExit('ADUIDSWRJW',ADUIDSWRJW_wrap_Valid);
function ADUIDSWRJW_wrap_OnFocus(event) {
return ADUIDSWRJW_OnFocus(event);
}
SPBOUILib.SetInputEnter('ADUIDSWRJW',ADUIDSWRJW_wrap_OnFocus);
function ADUIDSWRJW_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('ADUIDSWRJW',ADUIDSWRJW_wrap_OnKeyPress);
function ADUIDSWRJW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ADUIDSWRJW',ADUIDSWRJW_wrap_OnKeyDown);
function LLXFEZDLPK_wrap_Valid(event) {
return LLXFEZDLPK_Valid(event);
}
SPBOUILib.SetInputExit('LLXFEZDLPK',LLXFEZDLPK_wrap_Valid);
function LLXFEZDLPK_wrap_OnFocus(event) {
return LLXFEZDLPK_OnFocus(event);
}
SPBOUILib.SetInputEnter('LLXFEZDLPK',LLXFEZDLPK_wrap_OnFocus);
function LLXFEZDLPK_wrap_OnKeyPress(event) {
return LLXFEZDLPK_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('LLXFEZDLPK',LLXFEZDLPK_wrap_OnKeyPress);
function LLXFEZDLPK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LLXFEZDLPK',LLXFEZDLPK_wrap_OnKeyDown);
function TCOTJNZLGM_wrap_Valid(event) {
return TCOTJNZLGM_Valid(event);
}
SPBOUILib.SetInputExit('TCOTJNZLGM',TCOTJNZLGM_wrap_Valid);
function TCOTJNZLGM_wrap_OnFocus(event) {
return TCOTJNZLGM_OnFocus(event);
}
SPBOUILib.SetInputEnter('TCOTJNZLGM',TCOTJNZLGM_wrap_OnFocus);
function TCOTJNZLGM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TCOTJNZLGM',TCOTJNZLGM_wrap_OnKeyDown);
function TCOTJNZLGM_ZOOM_setHandlers() {
function TCOTJNZLGM_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?TCOTJNZLGM_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('TCOTJNZLGM_ZOOM',TCOTJNZLGM_ZOOM_wrap_OnClick);
function TCOTJNZLGM_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('TCOTJNZLGM_ZOOM',TCOTJNZLGM_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('TCOTJNZLGM',TCOTJNZLGM_ZOOM_setHandlers);
function AQSAREJVST_wrap_Valid(event) {
return AQSAREJVST_Valid(event);
}
SPBOUILib.SetComboChange('AQSAREJVST',AQSAREJVST_wrap_Valid);
function AQSAREJVST_wrap_OnFocus(event) {
return AQSAREJVST_OnFocus(event);
}
SPBOUILib.SetInputEnter('AQSAREJVST',AQSAREJVST_wrap_OnFocus);
function AQSAREJVST_wrap_Blur(event) {
return AQSAREJVST_OnBlur(event);
}
SPBOUILib.SetInputExit('AQSAREJVST',AQSAREJVST_wrap_Blur);
function JGKMKQMAHS_wrap_Valid(event) {
return JGKMKQMAHS_Valid(event);
}
SPBOUILib.SetCheckboxClick('JGKMKQMAHS',JGKMKQMAHS_wrap_Valid);
function JGKMKQMAHS_wrap_OnFocus(event) {
return JGKMKQMAHS_OnFocus(event);
}
SPBOUILib.SetInputEnter('JGKMKQMAHS',JGKMKQMAHS_wrap_OnFocus);
function JGKMKQMAHS_wrap_Blur(event) {
return JGKMKQMAHS_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('JGKMKQMAHS',JGKMKQMAHS_wrap_Blur);
function ULVCBLFVEU_wrap_Valid(event) {
return ULVCBLFVEU_Valid(event);
}
SPBOUILib.SetInputExit('ULVCBLFVEU',ULVCBLFVEU_wrap_Valid);
function ULVCBLFVEU_wrap_OnFocus(event) {
return ULVCBLFVEU_OnFocus(event);
}
SPBOUILib.SetInputEnter('ULVCBLFVEU',ULVCBLFVEU_wrap_OnFocus);
function ULVCBLFVEU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ULVCBLFVEU',ULVCBLFVEU_wrap_OnKeyDown);
function ULVCBLFVEU_ZOOM_setHandlers() {
function ULVCBLFVEU_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ULVCBLFVEU_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('ULVCBLFVEU_ZOOM',ULVCBLFVEU_ZOOM_wrap_OnClick);
function ULVCBLFVEU_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('ULVCBLFVEU_ZOOM',ULVCBLFVEU_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('ULVCBLFVEU',ULVCBLFVEU_ZOOM_setHandlers);
function HWFHDWYMIU_wrap_Valid(event) {
return HWFHDWYMIU_Valid(event);
}
SPBOUILib.SetInputExit('HWFHDWYMIU',HWFHDWYMIU_wrap_Valid);
function HWFHDWYMIU_wrap_OnFocus(event) {
return HWFHDWYMIU_OnFocus(event);
}
SPBOUILib.SetInputEnter('HWFHDWYMIU',HWFHDWYMIU_wrap_OnFocus);
function HWFHDWYMIU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HWFHDWYMIU',HWFHDWYMIU_wrap_OnKeyDown);
function HWFHDWYMIU_ZOOM_setHandlers() {
function HWFHDWYMIU_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?HWFHDWYMIU_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('HWFHDWYMIU_ZOOM',HWFHDWYMIU_ZOOM_wrap_OnClick);
function HWFHDWYMIU_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('HWFHDWYMIU_ZOOM',HWFHDWYMIU_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('HWFHDWYMIU',HWFHDWYMIU_ZOOM_setHandlers);
function XPWBHUQUGP_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('XPWBHUQUGP',XPWBHUQUGP_wrap_OnKeyDown);
function AWPNTOJIRR_wrap_Valid(event) {
return AWPNTOJIRR_Valid(event);
}
SPBOUILib.SetInputExit('AWPNTOJIRR',AWPNTOJIRR_wrap_Valid);
function AWPNTOJIRR_wrap_OnFocus(event) {
return AWPNTOJIRR_OnFocus(event);
}
SPBOUILib.SetInputEnter('AWPNTOJIRR',AWPNTOJIRR_wrap_OnFocus);
function AWPNTOJIRR_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('AWPNTOJIRR',AWPNTOJIRR_wrap_OnKeyPress);
function AWPNTOJIRR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AWPNTOJIRR',AWPNTOJIRR_wrap_OnKeyDown);
function ODAYKSRECA_wrap_Valid(event) {
return ODAYKSRECA_Valid(event);
}
SPBOUILib.SetInputExit('ODAYKSRECA',ODAYKSRECA_wrap_Valid);
function ODAYKSRECA_wrap_OnFocus(event) {
return ODAYKSRECA_OnFocus(event);
}
SPBOUILib.SetInputEnter('ODAYKSRECA',ODAYKSRECA_wrap_OnFocus);
function ODAYKSRECA_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('ODAYKSRECA',ODAYKSRECA_wrap_OnKeyPress);
function ODAYKSRECA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ODAYKSRECA',ODAYKSRECA_wrap_OnKeyDown);
function ODAYKSRECA_ZOOM_setHandlers() {
function ODAYKSRECA_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ODAYKSRECA_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('ODAYKSRECA_ZOOM',ODAYKSRECA_ZOOM_wrap_OnClick);
function ODAYKSRECA_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('ODAYKSRECA_ZOOM',ODAYKSRECA_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('ODAYKSRECA',ODAYKSRECA_ZOOM_setHandlers);
function NOTZPDMYIA_wrap_Valid(event) {
return NOTZPDMYIA_Valid(event);
}
SPBOUILib.SetInputExit('NOTZPDMYIA',NOTZPDMYIA_wrap_Valid);
function NOTZPDMYIA_wrap_OnFocus(event) {
return NOTZPDMYIA_OnFocus(event);
}
SPBOUILib.SetInputEnter('NOTZPDMYIA',NOTZPDMYIA_wrap_OnFocus);
function NOTZPDMYIA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NOTZPDMYIA',NOTZPDMYIA_wrap_OnKeyDown);
function RDAVOEETJG_wrap_Valid(event) {
return RDAVOEETJG_Valid(event);
}
SPBOUILib.SetInputExit('RDAVOEETJG',RDAVOEETJG_wrap_Valid);
function RDAVOEETJG_wrap_OnFocus(event) {
return RDAVOEETJG_OnFocus(event);
}
SPBOUILib.SetInputEnter('RDAVOEETJG',RDAVOEETJG_wrap_OnFocus);
function RDAVOEETJG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RDAVOEETJG',RDAVOEETJG_wrap_OnKeyDown);
function BOTAJBWHHY_wrap_Valid(event) {
return BOTAJBWHHY_Valid(event);
}
SPBOUILib.SetInputExit('BOTAJBWHHY',BOTAJBWHHY_wrap_Valid);
function BOTAJBWHHY_wrap_OnFocus(event) {
return BOTAJBWHHY_OnFocus(event);
}
SPBOUILib.SetInputEnter('BOTAJBWHHY',BOTAJBWHHY_wrap_OnFocus);
function BOTAJBWHHY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BOTAJBWHHY',BOTAJBWHHY_wrap_OnKeyDown);
function VYLHWTRQNX_wrap_Valid(event) {
return VYLHWTRQNX_Valid(event);
}
SPBOUILib.SetInputExit('VYLHWTRQNX',VYLHWTRQNX_wrap_Valid);
function VYLHWTRQNX_wrap_OnFocus(event) {
return VYLHWTRQNX_OnFocus(event);
}
SPBOUILib.SetInputEnter('VYLHWTRQNX',VYLHWTRQNX_wrap_OnFocus);
function VYLHWTRQNX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VYLHWTRQNX',VYLHWTRQNX_wrap_OnKeyDown);
function YVIKEGPYPM_wrap_Valid(event) {
return YVIKEGPYPM_Valid(event);
}
SPBOUILib.SetInputExit('YVIKEGPYPM',YVIKEGPYPM_wrap_Valid);
function YVIKEGPYPM_wrap_OnFocus(event) {
return YVIKEGPYPM_OnFocus(event);
}
SPBOUILib.SetInputEnter('YVIKEGPYPM',YVIKEGPYPM_wrap_OnFocus);
function YVIKEGPYPM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YVIKEGPYPM',YVIKEGPYPM_wrap_OnKeyDown);
function YVIKEGPYPM_ZOOM_setHandlers() {
function YVIKEGPYPM_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?YVIKEGPYPM_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('YVIKEGPYPM_ZOOM',YVIKEGPYPM_ZOOM_wrap_OnClick);
function YVIKEGPYPM_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('YVIKEGPYPM_ZOOM',YVIKEGPYPM_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('YVIKEGPYPM',YVIKEGPYPM_ZOOM_setHandlers);
function HNMYJPHSQN_wrap_Valid(event) {
return HNMYJPHSQN_Valid(event);
}
SPBOUILib.SetComboChange('HNMYJPHSQN',HNMYJPHSQN_wrap_Valid);
function HNMYJPHSQN_wrap_OnFocus(event) {
return HNMYJPHSQN_OnFocus(event);
}
SPBOUILib.SetInputEnter('HNMYJPHSQN',HNMYJPHSQN_wrap_OnFocus);
function HNMYJPHSQN_wrap_Blur(event) {
return HNMYJPHSQN_OnBlur(event);
}
SPBOUILib.SetInputExit('HNMYJPHSQN',HNMYJPHSQN_wrap_Blur);
function CDJFSCCGNX_wrap_Valid(event) {
return CDJFSCCGNX_Valid(event);
}
SPBOUILib.SetInputExit('CDJFSCCGNX',CDJFSCCGNX_wrap_Valid);
function CDJFSCCGNX_wrap_OnFocus(event) {
return CDJFSCCGNX_OnFocus(event);
}
SPBOUILib.SetInputEnter('CDJFSCCGNX',CDJFSCCGNX_wrap_OnFocus);
function CDJFSCCGNX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CDJFSCCGNX',CDJFSCCGNX_wrap_OnKeyDown);
function CDJFSCCGNX_ZOOM_setHandlers() {
function CDJFSCCGNX_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?CDJFSCCGNX_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('CDJFSCCGNX_ZOOM',CDJFSCCGNX_ZOOM_wrap_OnClick);
function CDJFSCCGNX_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('CDJFSCCGNX_ZOOM',CDJFSCCGNX_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('CDJFSCCGNX',CDJFSCCGNX_ZOOM_setHandlers);
function VYDRMHACRY_wrap_Valid(event) {
return VYDRMHACRY_Valid(event);
}
SPBOUILib.SetInputExit('VYDRMHACRY',VYDRMHACRY_wrap_Valid);
function VYDRMHACRY_wrap_OnFocus(event) {
return VYDRMHACRY_OnFocus(event);
}
SPBOUILib.SetInputEnter('VYDRMHACRY',VYDRMHACRY_wrap_OnFocus);
function VYDRMHACRY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VYDRMHACRY',VYDRMHACRY_wrap_OnKeyDown);
function NYRJHOZOON_wrap_Valid(event) {
return NYRJHOZOON_Valid(event);
}
SPBOUILib.SetInputExit('NYRJHOZOON',NYRJHOZOON_wrap_Valid);
function NYRJHOZOON_wrap_OnFocus(event) {
return NYRJHOZOON_OnFocus(event);
}
SPBOUILib.SetInputEnter('NYRJHOZOON',NYRJHOZOON_wrap_OnFocus);
function NYRJHOZOON_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NYRJHOZOON',NYRJHOZOON_wrap_OnKeyDown);
function NYRJHOZOON_ZOOM_setHandlers() {
function NYRJHOZOON_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?NYRJHOZOON_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('NYRJHOZOON_ZOOM',NYRJHOZOON_ZOOM_wrap_OnClick);
function NYRJHOZOON_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('NYRJHOZOON_ZOOM',NYRJHOZOON_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('NYRJHOZOON',NYRJHOZOON_ZOOM_setHandlers);
function YBNJCVPDUM_wrap_Valid(event) {
return YBNJCVPDUM_Valid(event);
}
SPBOUILib.SetInputExit('YBNJCVPDUM',YBNJCVPDUM_wrap_Valid);
function YBNJCVPDUM_wrap_OnFocus(event) {
return YBNJCVPDUM_OnFocus(event);
}
SPBOUILib.SetInputEnter('YBNJCVPDUM',YBNJCVPDUM_wrap_OnFocus);
function YBNJCVPDUM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YBNJCVPDUM',YBNJCVPDUM_wrap_OnKeyDown);
function YQINIDXZSL_wrap_Valid(event) {
return YQINIDXZSL_Valid(event);
}
SPBOUILib.SetInputExit('YQINIDXZSL',YQINIDXZSL_wrap_Valid);
function YQINIDXZSL_wrap_OnFocus(event) {
return YQINIDXZSL_OnFocus(event);
}
SPBOUILib.SetInputEnter('YQINIDXZSL',YQINIDXZSL_wrap_OnFocus);
function YQINIDXZSL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YQINIDXZSL',YQINIDXZSL_wrap_OnKeyDown);
function YQINIDXZSL_ZOOM_setHandlers() {
function YQINIDXZSL_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?YQINIDXZSL_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('YQINIDXZSL_ZOOM',YQINIDXZSL_ZOOM_wrap_OnClick);
function YQINIDXZSL_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('YQINIDXZSL_ZOOM',YQINIDXZSL_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('YQINIDXZSL',YQINIDXZSL_ZOOM_setHandlers);
function FFCAGQAZHK_wrap_Valid(event) {
return FFCAGQAZHK_Valid(event);
}
SPBOUILib.SetInputExit('FFCAGQAZHK',FFCAGQAZHK_wrap_Valid);
function FFCAGQAZHK_wrap_OnFocus(event) {
return FFCAGQAZHK_OnFocus(event);
}
SPBOUILib.SetInputEnter('FFCAGQAZHK',FFCAGQAZHK_wrap_OnFocus);
function FFCAGQAZHK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FFCAGQAZHK',FFCAGQAZHK_wrap_OnKeyDown);
function ACAPFGYRVI_wrap_Valid(event) {
return ACAPFGYRVI_Valid(event);
}
SPBOUILib.SetInputExit('ACAPFGYRVI',ACAPFGYRVI_wrap_Valid);
function ACAPFGYRVI_wrap_OnFocus(event) {
return ACAPFGYRVI_OnFocus(event);
}
SPBOUILib.SetInputEnter('ACAPFGYRVI',ACAPFGYRVI_wrap_OnFocus);
function ACAPFGYRVI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ACAPFGYRVI',ACAPFGYRVI_wrap_OnKeyDown);
function GXMZZZHVBR_wrap_Valid(event) {
return GXMZZZHVBR_Valid(event);
}
SPBOUILib.SetInputExit('GXMZZZHVBR',GXMZZZHVBR_wrap_Valid);
function GXMZZZHVBR_wrap_OnFocus(event) {
return GXMZZZHVBR_OnFocus(event);
}
SPBOUILib.SetInputEnter('GXMZZZHVBR',GXMZZZHVBR_wrap_OnFocus);
function GXMZZZHVBR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('GXMZZZHVBR',GXMZZZHVBR_wrap_OnKeyDown);
function XCYZDRXAMJ_wrap_Valid(event) {
return XCYZDRXAMJ_Valid(event);
}
SPBOUILib.SetCheckboxClick('XCYZDRXAMJ',XCYZDRXAMJ_wrap_Valid);
function XCYZDRXAMJ_wrap_OnFocus(event) {
return XCYZDRXAMJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('XCYZDRXAMJ',XCYZDRXAMJ_wrap_OnFocus);
function XCYZDRXAMJ_wrap_Blur(event) {
return XCYZDRXAMJ_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('XCYZDRXAMJ',XCYZDRXAMJ_wrap_Blur);
function LEHLEQRJPH_wrap_Valid(event) {
return LEHLEQRJPH_Valid(event);
}
SPBOUILib.SetCheckboxClick('LEHLEQRJPH',LEHLEQRJPH_wrap_Valid);
function LEHLEQRJPH_wrap_OnFocus(event) {
return LEHLEQRJPH_OnFocus(event);
}
SPBOUILib.SetInputEnter('LEHLEQRJPH',LEHLEQRJPH_wrap_OnFocus);
function LEHLEQRJPH_wrap_Blur(event) {
return LEHLEQRJPH_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('LEHLEQRJPH',LEHLEQRJPH_wrap_Blur);
function QEFXECTWSF_wrap_Valid(event) {
return QEFXECTWSF_Valid(event);
}
SPBOUILib.SetInputExit('QEFXECTWSF',QEFXECTWSF_wrap_Valid);
function QEFXECTWSF_wrap_OnFocus(event) {
return QEFXECTWSF_OnFocus(event);
}
SPBOUILib.SetInputEnter('QEFXECTWSF',QEFXECTWSF_wrap_OnFocus);
function QEFXECTWSF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QEFXECTWSF',QEFXECTWSF_wrap_OnKeyDown);
function QEFXECTWSF_ZOOM_setHandlers() {
function QEFXECTWSF_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?QEFXECTWSF_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('QEFXECTWSF_ZOOM',QEFXECTWSF_ZOOM_wrap_OnClick);
function QEFXECTWSF_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('QEFXECTWSF_ZOOM',QEFXECTWSF_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('QEFXECTWSF',QEFXECTWSF_ZOOM_setHandlers);
function VMRTFBBQHL_wrap_Valid(event) {
return VMRTFBBQHL_Valid(event);
}
SPBOUILib.SetInputExit('VMRTFBBQHL',VMRTFBBQHL_wrap_Valid);
function VMRTFBBQHL_wrap_OnFocus(event) {
return VMRTFBBQHL_OnFocus(event);
}
SPBOUILib.SetInputEnter('VMRTFBBQHL',VMRTFBBQHL_wrap_OnFocus);
function VMRTFBBQHL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VMRTFBBQHL',VMRTFBBQHL_wrap_OnKeyDown);
function KDWBJNGUTK_wrap_Valid(event) {
return KDWBJNGUTK_Valid(event);
}
SPBOUILib.SetInputExit('KDWBJNGUTK',KDWBJNGUTK_wrap_Valid);
function KDWBJNGUTK_wrap_OnFocus(event) {
return KDWBJNGUTK_OnFocus(event);
}
SPBOUILib.SetInputEnter('KDWBJNGUTK',KDWBJNGUTK_wrap_OnFocus);
function KDWBJNGUTK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KDWBJNGUTK',KDWBJNGUTK_wrap_OnKeyDown);
function VSHUPFYWOC_wrap_Valid(event) {
return VSHUPFYWOC_Valid(event);
}
SPBOUILib.SetInputExit('VSHUPFYWOC',VSHUPFYWOC_wrap_Valid);
function VSHUPFYWOC_wrap_OnFocus(event) {
return VSHUPFYWOC_OnFocus(event);
}
SPBOUILib.SetInputEnter('VSHUPFYWOC',VSHUPFYWOC_wrap_OnFocus);
function VSHUPFYWOC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VSHUPFYWOC',VSHUPFYWOC_wrap_OnKeyDown);
function VASVGQZJGP_wrap_Valid(event) {
return VASVGQZJGP_Valid(event);
}
SPBOUILib.SetInputExit('VASVGQZJGP',VASVGQZJGP_wrap_Valid);
function VASVGQZJGP_wrap_OnFocus(event) {
return VASVGQZJGP_OnFocus(event);
}
SPBOUILib.SetInputEnter('VASVGQZJGP',VASVGQZJGP_wrap_OnFocus);
function VASVGQZJGP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VASVGQZJGP',VASVGQZJGP_wrap_OnKeyDown);
function SMZCOQAIDC_wrap_Valid(event) {
return SMZCOQAIDC_Valid(event);
}
SPBOUILib.SetComboChange('SMZCOQAIDC',SMZCOQAIDC_wrap_Valid);
function SMZCOQAIDC_wrap_OnFocus(event) {
return SMZCOQAIDC_OnFocus(event);
}
SPBOUILib.SetInputEnter('SMZCOQAIDC',SMZCOQAIDC_wrap_OnFocus);
function SMZCOQAIDC_wrap_Blur(event) {
return SMZCOQAIDC_OnBlur(event);
}
SPBOUILib.SetInputExit('SMZCOQAIDC',SMZCOQAIDC_wrap_Blur);
function MDVEMSKFNR_wrap_Valid(event) {
return MDVEMSKFNR_Valid(event);
}
SPBOUILib.SetComboChange('MDVEMSKFNR',MDVEMSKFNR_wrap_Valid);
function MDVEMSKFNR_wrap_OnFocus(event) {
return MDVEMSKFNR_OnFocus(event);
}
SPBOUILib.SetInputEnter('MDVEMSKFNR',MDVEMSKFNR_wrap_OnFocus);
function MDVEMSKFNR_wrap_Blur(event) {
return MDVEMSKFNR_OnBlur(event);
}
SPBOUILib.SetInputExit('MDVEMSKFNR',MDVEMSKFNR_wrap_Blur);
function JEKLOGLRAN_wrap_Valid(event) {
return JEKLOGLRAN_Valid(event);
}
SPBOUILib.SetInputExit('JEKLOGLRAN',JEKLOGLRAN_wrap_Valid);
function JEKLOGLRAN_wrap_OnFocus(event) {
return JEKLOGLRAN_OnFocus(event);
}
SPBOUILib.SetInputEnter('JEKLOGLRAN',JEKLOGLRAN_wrap_OnFocus);
function JEKLOGLRAN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JEKLOGLRAN',JEKLOGLRAN_wrap_OnKeyDown);
function RQKHNRJEDR_wrap_Valid(event) {
return RQKHNRJEDR_Valid(event);
}
SPBOUILib.SetInputExit('RQKHNRJEDR',RQKHNRJEDR_wrap_Valid);
function RQKHNRJEDR_wrap_OnFocus(event) {
return RQKHNRJEDR_OnFocus(event);
}
SPBOUILib.SetInputEnter('RQKHNRJEDR',RQKHNRJEDR_wrap_OnFocus);
function RQKHNRJEDR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RQKHNRJEDR',RQKHNRJEDR_wrap_OnKeyDown);
function YMKLIGEOKH_wrap_Valid(event) {
return YMKLIGEOKH_Valid(event);
}
SPBOUILib.SetComboChange('YMKLIGEOKH',YMKLIGEOKH_wrap_Valid);
function YMKLIGEOKH_wrap_OnFocus(event) {
return YMKLIGEOKH_OnFocus(event);
}
SPBOUILib.SetInputEnter('YMKLIGEOKH',YMKLIGEOKH_wrap_OnFocus);
function YMKLIGEOKH_wrap_Blur(event) {
return YMKLIGEOKH_OnBlur(event);
}
SPBOUILib.SetInputExit('YMKLIGEOKH',YMKLIGEOKH_wrap_Blur);
function WNMMMNSARU_wrap_Valid(event) {
return WNMMMNSARU_Valid(event);
}
SPBOUILib.SetInputExit('WNMMMNSARU',WNMMMNSARU_wrap_Valid);
function WNMMMNSARU_wrap_OnFocus(event) {
return WNMMMNSARU_OnFocus(event);
}
SPBOUILib.SetInputEnter('WNMMMNSARU',WNMMMNSARU_wrap_OnFocus);
function WNMMMNSARU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WNMMMNSARU',WNMMMNSARU_wrap_OnKeyDown);
function WNMMMNSARU_ZOOM_setHandlers() {
function WNMMMNSARU_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?WNMMMNSARU_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('WNMMMNSARU_ZOOM',WNMMMNSARU_ZOOM_wrap_OnClick);
function WNMMMNSARU_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('WNMMMNSARU_ZOOM',WNMMMNSARU_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('WNMMMNSARU',WNMMMNSARU_ZOOM_setHandlers);
function JDTKGSGMAF_wrap_Valid(event) {
return JDTKGSGMAF_Valid(event);
}
SPBOUILib.SetInputExit('JDTKGSGMAF',JDTKGSGMAF_wrap_Valid);
function JDTKGSGMAF_wrap_OnFocus(event) {
return JDTKGSGMAF_OnFocus(event);
}
SPBOUILib.SetInputEnter('JDTKGSGMAF',JDTKGSGMAF_wrap_OnFocus);
function JDTKGSGMAF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JDTKGSGMAF',JDTKGSGMAF_wrap_OnKeyDown);
function CKJQULDXKW_wrap_Valid(event) {
return CKJQULDXKW_Valid(event);
}
SPBOUILib.SetInputExit('CKJQULDXKW',CKJQULDXKW_wrap_Valid);
function CKJQULDXKW_wrap_OnFocus(event) {
return CKJQULDXKW_OnFocus(event);
}
SPBOUILib.SetInputEnter('CKJQULDXKW',CKJQULDXKW_wrap_OnFocus);
function CKJQULDXKW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CKJQULDXKW',CKJQULDXKW_wrap_OnKeyDown);
function CKJQULDXKW_ZOOM_setHandlers() {
function CKJQULDXKW_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?CKJQULDXKW_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('CKJQULDXKW_ZOOM',CKJQULDXKW_ZOOM_wrap_OnClick);
function CKJQULDXKW_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('CKJQULDXKW_ZOOM',CKJQULDXKW_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('CKJQULDXKW',CKJQULDXKW_ZOOM_setHandlers);
function MXYTQLATHC_wrap_Valid(event) {
return MXYTQLATHC_Valid(event);
}
SPBOUILib.SetInputExit('MXYTQLATHC',MXYTQLATHC_wrap_Valid);
function MXYTQLATHC_wrap_OnFocus(event) {
return MXYTQLATHC_OnFocus(event);
}
SPBOUILib.SetInputEnter('MXYTQLATHC',MXYTQLATHC_wrap_OnFocus);
function MXYTQLATHC_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('MXYTQLATHC',MXYTQLATHC_wrap_OnKeyPress);
function MXYTQLATHC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MXYTQLATHC',MXYTQLATHC_wrap_OnKeyDown);
function SXTYCPHBIM_wrap_Valid(event) {
return SXTYCPHBIM_Valid(event);
}
SPBOUILib.SetInputExit('SXTYCPHBIM',SXTYCPHBIM_wrap_Valid);
function SXTYCPHBIM_wrap_OnFocus(event) {
return SXTYCPHBIM_OnFocus(event);
}
SPBOUILib.SetInputEnter('SXTYCPHBIM',SXTYCPHBIM_wrap_OnFocus);
function SXTYCPHBIM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SXTYCPHBIM',SXTYCPHBIM_wrap_OnKeyDown);
function SXTYCPHBIM_ZOOM_setHandlers() {
function SXTYCPHBIM_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?SXTYCPHBIM_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('SXTYCPHBIM_ZOOM',SXTYCPHBIM_ZOOM_wrap_OnClick);
function SXTYCPHBIM_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('SXTYCPHBIM_ZOOM',SXTYCPHBIM_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('SXTYCPHBIM',SXTYCPHBIM_ZOOM_setHandlers);
function KBIUAXUDXA_wrap_Valid(event) {
return KBIUAXUDXA_Valid(event);
}
SPBOUILib.SetInputExit('KBIUAXUDXA',KBIUAXUDXA_wrap_Valid);
function KBIUAXUDXA_wrap_OnFocus(event) {
return KBIUAXUDXA_OnFocus(event);
}
SPBOUILib.SetInputEnter('KBIUAXUDXA',KBIUAXUDXA_wrap_OnFocus);
function KBIUAXUDXA_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('KBIUAXUDXA',KBIUAXUDXA_wrap_OnKeyPress);
function KBIUAXUDXA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KBIUAXUDXA',KBIUAXUDXA_wrap_OnKeyDown);
function QJSTZIPOQB_wrap_Valid(event) {
return QJSTZIPOQB_Valid(event);
}
SPBOUILib.SetInputExit('QJSTZIPOQB',QJSTZIPOQB_wrap_Valid);
function QJSTZIPOQB_wrap_OnFocus(event) {
return QJSTZIPOQB_OnFocus(event);
}
SPBOUILib.SetInputEnter('QJSTZIPOQB',QJSTZIPOQB_wrap_OnFocus);
function QJSTZIPOQB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QJSTZIPOQB',QJSTZIPOQB_wrap_OnKeyDown);
function QJSTZIPOQB_ZOOM_setHandlers() {
function QJSTZIPOQB_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?QJSTZIPOQB_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('QJSTZIPOQB_ZOOM',QJSTZIPOQB_ZOOM_wrap_OnClick);
function QJSTZIPOQB_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('QJSTZIPOQB_ZOOM',QJSTZIPOQB_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('QJSTZIPOQB',QJSTZIPOQB_ZOOM_setHandlers);
function UDAYHICPVB_wrap_Valid(event) {
return UDAYHICPVB_Valid(event);
}
SPBOUILib.SetInputExit('UDAYHICPVB',UDAYHICPVB_wrap_Valid);
function UDAYHICPVB_wrap_OnFocus(event) {
return UDAYHICPVB_OnFocus(event);
}
SPBOUILib.SetInputEnter('UDAYHICPVB',UDAYHICPVB_wrap_OnFocus);
function UDAYHICPVB_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('UDAYHICPVB',UDAYHICPVB_wrap_OnKeyPress);
function UDAYHICPVB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UDAYHICPVB',UDAYHICPVB_wrap_OnKeyDown);
function SFFFOYOWNH_wrap_Valid(event) {
return SFFFOYOWNH_Valid(event);
}
SPBOUILib.SetInputExit('SFFFOYOWNH',SFFFOYOWNH_wrap_Valid);
function SFFFOYOWNH_wrap_OnFocus(event) {
return SFFFOYOWNH_OnFocus(event);
}
SPBOUILib.SetInputEnter('SFFFOYOWNH',SFFFOYOWNH_wrap_OnFocus);
function SFFFOYOWNH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SFFFOYOWNH',SFFFOYOWNH_wrap_OnKeyDown);
function SFFFOYOWNH_ZOOM_setHandlers() {
function SFFFOYOWNH_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?SFFFOYOWNH_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('SFFFOYOWNH_ZOOM',SFFFOYOWNH_ZOOM_wrap_OnClick);
function SFFFOYOWNH_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('SFFFOYOWNH_ZOOM',SFFFOYOWNH_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('SFFFOYOWNH',SFFFOYOWNH_ZOOM_setHandlers);
function ETALZDRBSO_wrap_Valid(event) {
return ETALZDRBSO_Valid(event);
}
SPBOUILib.SetInputExit('ETALZDRBSO',ETALZDRBSO_wrap_Valid);
function ETALZDRBSO_wrap_OnFocus(event) {
return ETALZDRBSO_OnFocus(event);
}
SPBOUILib.SetInputEnter('ETALZDRBSO',ETALZDRBSO_wrap_OnFocus);
function ETALZDRBSO_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('ETALZDRBSO',ETALZDRBSO_wrap_OnKeyPress);
function ETALZDRBSO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ETALZDRBSO',ETALZDRBSO_wrap_OnKeyDown);
function NOBMPHKVTX_wrap_Valid(event) {
return NOBMPHKVTX_Valid(event);
}
SPBOUILib.SetInputExit('NOBMPHKVTX',NOBMPHKVTX_wrap_Valid);
function NOBMPHKVTX_wrap_OnFocus(event) {
return NOBMPHKVTX_OnFocus(event);
}
SPBOUILib.SetInputEnter('NOBMPHKVTX',NOBMPHKVTX_wrap_OnFocus);
function NOBMPHKVTX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NOBMPHKVTX',NOBMPHKVTX_wrap_OnKeyDown);
function NOBMPHKVTX_ZOOM_setHandlers() {
function NOBMPHKVTX_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?NOBMPHKVTX_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('NOBMPHKVTX_ZOOM',NOBMPHKVTX_ZOOM_wrap_OnClick);
function NOBMPHKVTX_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('NOBMPHKVTX_ZOOM',NOBMPHKVTX_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('NOBMPHKVTX',NOBMPHKVTX_ZOOM_setHandlers);
function QBTVZDKLCO_wrap_Valid(event) {
return QBTVZDKLCO_Valid(event);
}
SPBOUILib.SetInputExit('QBTVZDKLCO',QBTVZDKLCO_wrap_Valid);
function QBTVZDKLCO_wrap_OnFocus(event) {
return QBTVZDKLCO_OnFocus(event);
}
SPBOUILib.SetInputEnter('QBTVZDKLCO',QBTVZDKLCO_wrap_OnFocus);
function QBTVZDKLCO_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('QBTVZDKLCO',QBTVZDKLCO_wrap_OnKeyPress);
function QBTVZDKLCO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QBTVZDKLCO',QBTVZDKLCO_wrap_OnKeyDown);
function DJOWYRMDDC_wrap_Valid(event) {
return DJOWYRMDDC_Valid(event);
}
SPBOUILib.SetInputExit('DJOWYRMDDC',DJOWYRMDDC_wrap_Valid);
function DJOWYRMDDC_wrap_OnFocus(event) {
return DJOWYRMDDC_OnFocus(event);
}
SPBOUILib.SetInputEnter('DJOWYRMDDC',DJOWYRMDDC_wrap_OnFocus);
function DJOWYRMDDC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DJOWYRMDDC',DJOWYRMDDC_wrap_OnKeyDown);
function DJOWYRMDDC_ZOOM_setHandlers() {
function DJOWYRMDDC_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?DJOWYRMDDC_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('DJOWYRMDDC_ZOOM',DJOWYRMDDC_ZOOM_wrap_OnClick);
function DJOWYRMDDC_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('DJOWYRMDDC_ZOOM',DJOWYRMDDC_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('DJOWYRMDDC',DJOWYRMDDC_ZOOM_setHandlers);
function RUWEXWJASG_wrap_Valid(event) {
return RUWEXWJASG_Valid(event);
}
SPBOUILib.SetInputExit('RUWEXWJASG',RUWEXWJASG_wrap_Valid);
function RUWEXWJASG_wrap_OnFocus(event) {
return RUWEXWJASG_OnFocus(event);
}
SPBOUILib.SetInputEnter('RUWEXWJASG',RUWEXWJASG_wrap_OnFocus);
function RUWEXWJASG_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('RUWEXWJASG',RUWEXWJASG_wrap_OnKeyPress);
function RUWEXWJASG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RUWEXWJASG',RUWEXWJASG_wrap_OnKeyDown);
function SMVVFHCEHA_wrap_Valid(event) {
return SMVVFHCEHA_Valid(event);
}
SPBOUILib.SetComboChange('SMVVFHCEHA',SMVVFHCEHA_wrap_Valid);
function SMVVFHCEHA_wrap_OnFocus(event) {
return SMVVFHCEHA_OnFocus(event);
}
SPBOUILib.SetInputEnter('SMVVFHCEHA',SMVVFHCEHA_wrap_OnFocus);
function SMVVFHCEHA_wrap_Blur(event) {
return SMVVFHCEHA_OnBlur(event);
}
SPBOUILib.SetInputExit('SMVVFHCEHA',SMVVFHCEHA_wrap_Blur);
function DOXBACRWUU_wrap_Valid(event) {
return DOXBACRWUU_Valid(event);
}
SPBOUILib.SetInputExit('DOXBACRWUU',DOXBACRWUU_wrap_Valid);
function DOXBACRWUU_wrap_OnFocus(event) {
return DOXBACRWUU_OnFocus(event);
}
SPBOUILib.SetInputEnter('DOXBACRWUU',DOXBACRWUU_wrap_OnFocus);
function DOXBACRWUU_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('DOXBACRWUU',DOXBACRWUU_wrap_OnKeyPress);
function DOXBACRWUU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DOXBACRWUU',DOXBACRWUU_wrap_OnKeyDown);
function OXGBDTWKSX_wrap_Valid(event) {
return OXGBDTWKSX_Valid(event);
}
SPBOUILib.SetInputExit('OXGBDTWKSX',OXGBDTWKSX_wrap_Valid);
function OXGBDTWKSX_wrap_OnFocus(event) {
return OXGBDTWKSX_OnFocus(event);
}
SPBOUILib.SetInputEnter('OXGBDTWKSX',OXGBDTWKSX_wrap_OnFocus);
function OXGBDTWKSX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OXGBDTWKSX',OXGBDTWKSX_wrap_OnKeyDown);
if (m_bExtended) {
SetEventsAndStylesToExtendedFields();
}
}
if (Eq(m_cFunction,'query') && Ne(document.FrmToolbar,null)) {
document.FrmToolbar.pos.onkeypress=RecPositionInput;
document.FrmToolbar.pos.onblur=SelectRecord;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
}
function SetLastFocusedOnParent() {
// used only in child entities
}
function DoUpdate(p_bResult) {
if (Ne(m_cFunction,'query') && Ne(m_cFunction,'view')) {
Calculate();
SaveDependsOn();
SetControlsValue();
SetDynamicClasses();
SetDynamicTooltip();
EnableControlsUnderCondition();
SaveLabelDependsOn();
}
if ( ! (p_bResult)) {
DisplayErrorMessage();
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.edit={"page_1":["AVHTGZTOSZ"],"page_4":["LEHLEQRJPH"],"page_5":["WNMMMNSARU"],"page_6":["CKJQULDXKW"]};
FocusFirstComponent.query={"page_1":["AVHTGZTOSZ"],"page_4":["LEHLEQRJPH"],"page_5":["WNMMMNSARU"],"page_6":["CKJQULDXKW"]};
FocusFirstComponent.otherwise={"page_1":["AVHTGZTOSZ"],"page_4":["LEHLEQRJPH"],"page_5":["WNMMMNSARU"],"page_6":["CKJQULDXKW"]};
function Help() {
windowOpenForeground('../doc/armt_oprovvisorie_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_ardt_sogopeprov() {
SetModified();
}
function SetModified_ardt_xlientiope() {
SetModified();
}
function SetModified_ardt_xeneficope() {
SetModified();
}
function SetModified_ardt_xerzistiope() {
SetModified();
}
function SetModified_ardt_xapcoll() {
SetModified();
}
function SetModified_ardt_docopebo() {
SetModified();
}
function SetModified_armt_xperazbo_agg() {
SetModified();
}
function SetModified_ardt_xpe_contante() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_2')) {
if (ChildToLoad('TQDGESLQVD')) {
LoadContext.lc(1,'TQDGESLQVD');
} else {
LibJavascript.RefreshChildGrid('TQDGESLQVD');
}
}
if (Eq(page,'page_2')) {
if (ChildToLoad('BOAFVDQFRN')) {
LoadContext.lc(1,'BOAFVDQFRN');
} else {
LibJavascript.RefreshChildGrid('BOAFVDQFRN');
}
}
if (Eq(page,'page_3')) {
if (ChildToLoad('OCTDIOXFMI')) {
LoadContext.lc(1,'OCTDIOXFMI');
} else {
LibJavascript.RefreshChildGrid('OCTDIOXFMI');
}
}
if (Eq(page,'page_3')) {
if (ChildToLoad('NOKYMTFBFL')) {
LoadContext.lc(1,'NOKYMTFBFL');
} else {
LibJavascript.RefreshChildGrid('NOKYMTFBFL');
}
}
if (Eq(page,'page_3')) {
if (ChildToLoad('QLURQBXKEV')) {
LoadContext.lc(1,'QLURQBXKEV');
} else {
LibJavascript.RefreshChildGrid('QLURQBXKEV');
}
}
if (Eq(page,'page_5')) {
if (ChildToLoad('OZMPVCAYQN')) {
LoadContext.lc(1,'OZMPVCAYQN');
} else {
LibJavascript.RefreshChildGrid('OZMPVCAYQN');
}
}
if (Eq(page,'page_6')) {
if (ChildToLoad('RZOXJTRIYP')) {
LoadContext.lc(1,'RZOXJTRIYP');
} else {
LibJavascript.RefreshChildGrid('RZOXJTRIYP');
}
}
if (Eq(page,'page_7')) {
if (ChildToLoad('HPXRKUBEED')) {
if (Eq(lazy,null) || LibJavascript.UserCanSee('HPXRKUBEED')) {
LoadContext.lc(1,'HPXRKUBEED');
}
} else {
LibJavascript.RefreshChildGrid('HPXRKUBEED');
}
}
}
GetLayerID.Layers.push({"id":"YORQOIOBQN","name":"DatiOperazione"});
GetLayerID.Layers.push({"id":"ANGGVVFTIZ","name":"DatiCambiaSV"});
GetLayerID.Layers.push({"id":"XLSSDAVPDH","name":"DatiSoggetti"});
GetLayerID.Layers.push({"id":"ZPEPXLSZFA","name":"DatiControparte"});
GetLayerID.Layers.push({"id":"YIVWPEZXIF","name":"DatiIntermediarioControparte"});
GetLayerID.Layers.push({"id":"BOYWPGJEEZ","name":"Intermediario"});
GetLayerID.Layers.push({"id":"BDZUATYPMW","name":"AltriIntestatari"});
GetLayerID.Layers.push({"id":"ZYUUSRMPQG","name":"AltriEsecutori"});
GetLayerID.Layers.push({"id":"NIKDKIOYYF","name":"Intermediario2"});
GetLayerID.Layers.push({"id":"GTSBULOFTD","name":"AltriControparti"});
GetLayerID.Layers.push({"id":"BHLGNNSXQY","name":"AltriSogTerzi"});
GetLayerID.Layers.push({"id":"CNRNAIMNZQ","name":"Rapporto"});
GetLayerID.Layers.push({"id":"JWDKPZAEZU","name":"Intermediario3"});
GetLayerID.Layers.push({"id":"QVDUCHDNOK","name":"Intermediario4"});
GetLayerID.Layers.push({"id":"JTWNGHDSFX","name":"Internet"});
GetLayerID.Layers.push({"id":"EOKCAXCLZO","name":"AGE"});
GetLayerID.Layers.push({"id":"VVOVGLWTVP","name":"SV"});
GetLayerID.Layers.push({"id":"SNFGHIZMTZ","name":"AltriDati"});
GetLayerID.Layers.push({"id":"LLZCQSNQZL","name":"Contante_Gen"});
GetLayerID.Layers.push({"id":"OXFXXISYUL","name":"OAM"});
GetLayerID.Layers.push({"id":"JELGAQOYWT","name":"Documenti"});
GetLayerID.Layers.push({"id":"CEBGUGLSVM","name":"Intermediario5"});
GetLayerID.Layers.push({"id":"GMMLWYVNPO","name":"IIIDirettiva"});
GetLayerID.Layers.push({"id":"UFFFOVKFCE","name":"Mitigazione"});
GetLayerID.Layers.push({"id":"YUNLBUHYXD","name":"Categorie"});
GetLayerID.Layers.push({"id":"HHLUYHQCAT","name":"Intermediario6"});
GetLayerID.Layers.push({"id":"QKOTBMZCDT","name":"Intermediario7"});
GetLayerID.Layers.push({"id":"VTXXRGJSRI","name":"Contante"});
function DeclareWVs() {
var a = arguments;
w_IDBASE=a[0];
op_IDBASE=a[1];
w_CODINTER=a[2];
w_CODDIPE=a[3];
w_DESCCIT=a[4];
w_PROVINCIA=a[5];
w_CODCAB=a[6];
w_DATAOPE=a[7];
w_NUMPROG=a[8];
op_NUMPROG=a[9];
w_CDATOPE=a[10];
w_CDATAOPE=a[11];
w_ANNOOPE=a[12];
w_IDEREG=a[13];
w_DATAREG=a[14];
w_CDATREG=a[15];
w_FLAGFRAZ=a[16];
w_COLLEG=a[17];
w_TIPOOPRAP=a[18];
w_idcauana=a[19];
w_CODANA=a[20];
w_CODVOC=a[21];
w_FLAGLIRE=a[22];
w_VALUTA=a[23];
w_FLAGCONT=a[24];
w_CAMBIO=a[25];
w_IMPIN=a[26];
w_IMPOUT=a[27];
w_RAPPORTO=a[28];
w_CONNESCLI=a[29];
w_PROQUOTA=a[30];
w_IMPSARA=a[31];
w_CONNESOPER=a[32];
w_TIPOLEG=a[33];
w_PAGASOGOP=a[34];
w_CONNESBEN=a[35];
w_CONNALTRO=a[36];
w_C_RAG=a[37];
w_C_CTA=a[38];
w_C_PRV=a[39];
w_C_CAP=a[40];
w_C_CAB=a[41];
w_C_IND=a[42];
w_C_STA=a[43];
w_TIPOINT2=a[44];
w_CODINT2=a[45];
w_DESCINTER=a[46];
w_PAESE=a[47];
w_C_RAPPORTO=a[48];
w_CODCAB2=a[49];
w_DESC2=a[50];
w_PROV2=a[51];
w_ZCPARTE=a[52];
w_TIPOINF=a[53];
w_SEGNO=a[54];
w_IPCOLLEG=a[55];
w_ORACOLLEG=a[56];
w_DUCOLLEG=a[57];
w_NOPROT=a[58];
w_OPERAG=a[59];
w_RESPINS=a[60];
w_INFORM=a[61];
w_NATURA=a[62];
w_SCOPO=a[63];
w_SV58550=a[64];
w_SV58550MA=a[65];
w_DURAT=a[66];
w_AMMONT=a[67];
w_AREAGEO=a[68];
w_MODSVOL=a[69];
w_RAGIO=a[70];
w_TIPO=a[71];
w_CONNESDOC=a[72];
w_IDFILE=a[73];
w_MTCN=a[74];
w_TOTLIRE=a[75];
w_TOTCONT=a[76];
w_FLAGRAP=a[77];
w_OPRAP=a[78];
w_RAPPORTBEN=a[79];
w_OPERATORE=a[80];
w_AUTOM=a[81];
w_FLAGRAP2=a[82];
w_PRGIMPOPE=a[83];
op_PRGIMPOPE=a[84];
w_IDBASE2=a[85];
w_RFREQ=a[86];
w_RIMP=a[87];
w_RAREA=a[88];
w_RCOMP=a[89];
w_RRAGIO=a[90];
w_RTIPO=a[91];
w_RISGLOB=a[92];
w_MITIG=a[93];
w_MITIGDOC=a[94];
w_MEZPAG=a[95];
w_PRESTAZ=a[96];
w_NOSARA=a[97];
w_DESPUNTO=a[98];
w_CODCLICON=a[99];
w_TIPATT=a[100];
w_VASP=a[101];
w_RIFIMP=a[102];
w_gIntemediario=a[103];
w_gChkDate=a[104];
w_gTipInter=a[105];
w_gSblocco=a[106];
w_gDataVaria=a[107];
w_gStatus=a[108];
w_gFlgDoc=a[109];
w_gFlgWU=a[110];
w_gFlgDTP=a[111];
w_gSeekAos=a[112];
w_gVerSim=a[113];
w_dataoggi=a[114];
w_filtro=a[115];
w_sEdit=a[116];
w_test=a[117];
w_datpaseuro=a[118];
w_tipope=a[119];
w_stringaflagrap2=a[120];
w_appolire=a[121];
w_xTOTLIRE=a[122];
w_xTOTCONT=a[123];
w_apporeg=a[124];
w_xdestipleg=a[125];
w_xragsocct=a[126];
w_xDescDipe=a[127];
w_descdiv=a[128];
w_valflg2=a[129];
w_xragint2=a[130];
w_errmsg=a[131];
w_xragsocper=a[132];
w_desccauana=a[133];
w_xragsocben=a[134];
w_xdesccausin=a[135];
w_xdescpaese2=a[136];
w_xdescrap=a[137];
w_xdes1=a[138];
w_xcodfisc=a[139];
w_xdciticon=a[140];
w_dessta=a[141];
w_xragsocalt=a[142];
w_xFLGITAEST=a[143];
w_xdescopeage=a[144];
w_xdescfreq=a[145];
w_xdescammo=a[146];
w_xdescareag=a[147];
w_xdescmodsvo=a[148];
w_xdescplauso=a[149];;
w_xdesctipor=a[150];
w_xRAGSOCDOC=a[151];
w_CITINT=a[152];
w_CITDIP=a[153];
w_PROVDIP=a[154];
w_CABDIP=a[155];
w_PROVINT=a[156];
w_CABINT=a[157];
w_DATAVALI=a[158];
w_DATARILASC=a[159];
op_codazi=a[160];
o_ZPEPXLSZFA_expand=null;
o_YIVWPEZXIF_expand=null;
m_cWv_ardt_sogopeprov=a[161];
m_cWv_ardt_xlientiope=a[162];
m_cWv_ardt_xeneficope=a[163];
m_cWv_ardt_xerzistiope=a[164];
m_cWv_ardt_xapcoll=a[165];
m_cWv_ardt_docopebo=a[166];
m_cWv_armt_xperazbo_agg=a[167];
m_cWv_ardt_xpe_contante=a[168];
if (Gt(a.length,169)) {
m_cErrorInChild='';
}
if (Gt(a.length,169)) {
o_filtro=w_filtro;
o_CODINTER=w_CODINTER;
o_CODDIPE=w_CODDIPE;
o_DATAOPE=w_DATAOPE;
o_CDATOPE=w_CDATOPE;
o_DATAREG=w_DATAREG;
o_FLAGFRAZ=w_FLAGFRAZ;
o_TIPOOPRAP=w_TIPOOPRAP;
o_CODANA=w_CODANA;
o_CODVOC=w_CODVOC;
o_FLAGLIRE=w_FLAGLIRE;
o_appolire=w_appolire;
o_VALUTA=w_VALUTA;
o_FLAGCONT=w_FLAGCONT;
o_RAPPORTO=w_RAPPORTO;
o_CONNESCLI=w_CONNESCLI;
o_CONNESOPER=w_CONNESOPER;
o_CONNESBEN=w_CONNESBEN;
o_CONNALTRO=w_CONNALTRO;
o_C_CTA=w_C_CTA;
o_CODINT2=w_CODINT2;
o_SEGNO=w_SEGNO;
o_DURAT=w_DURAT;
o_AMMONT=w_AMMONT;
o_AREAGEO=w_AREAGEO;
o_MODSVOL=w_MODSVOL;
o_RAGIO=w_RAGIO;
o_TIPO=w_TIPO;
}
m_PrimaryKeys=['IDBASE'];
}
function i_PrimaryKey() {
return 'xperazbo'+'\\'+CPLib.ToCPStr(w_IDBASE);
}
GetLinkPCKeys.set_o('ardt_sogopeprov',false);
GetLinkPCKeys.set_o('ardt_xlientiope',false);
GetLinkPCKeys.set_o('ardt_xeneficope',false);
GetLinkPCKeys.set_o('ardt_xerzistiope',false);
GetLinkPCKeys.set_o('ardt_xapcoll',false);
GetLinkPCKeys.set_o('ardt_docopebo',false);
GetLinkPCKeys.set_o('armt_xperazbo_agg',false);
GetLinkPCKeys.set_o('ardt_xpe_contante',false);
GetLinkPCKeys.o['ardt_sogopeprov']['IDFILEBO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_IDBASE,'C');
}
}
GetLinkPCKeys.o['ardt_xlientiope']['IDFILEBO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_IDBASE,'C');
}
}
GetLinkPCKeys.o['ardt_xeneficope']['IDFILEBO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_IDBASE,'C');
}
}
GetLinkPCKeys.o['ardt_xerzistiope']['IDFILEBO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_IDBASE,'C');
}
}
GetLinkPCKeys.o['ardt_xapcoll']['IDFILEBO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_IDBASE,'C');
}
}
GetLinkPCKeys.o['ardt_docopebo']['NUMPROG']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_NUMPROG,'C');
}
}
GetLinkPCKeys.o['armt_xperazbo_agg']['IDBASE']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_IDBASE,'C');
}
}
GetLinkPCKeys.o['ardt_xpe_contante']['IDOPE']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_IDBASE,'C');
}
}
resizeChildIframe.children['ardt_sogopeprov']=true;
resizeChildIframe.children['ardt_xlientiope']=true;
resizeChildIframe.children['ardt_xeneficope']=true;
resizeChildIframe.children['ardt_xerzistiope']=true;
resizeChildIframe.children['ardt_xapcoll']=true;
resizeChildIframe.children['ardt_docopebo']=true;
resizeChildIframe.children['armt_xperazbo_agg']=true;
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('TQDGESLQVD',function(){return FrameRef('ardt_sogopeprov')},1,'ardt_sogopeprov',0,2)
LoadContext.f('BOAFVDQFRN',function(){return FrameRef('ardt_xlientiope')},1,'ardt_xlientiope',0,2)
LoadContext.f('OCTDIOXFMI',function(){return FrameRef('ardt_xeneficope')},1,'ardt_xeneficope',0,3)
LoadContext.f('NOKYMTFBFL',function(){return FrameRef('ardt_xerzistiope')},1,'ardt_xerzistiope',0,3)
LoadContext.f('QLURQBXKEV',function(){return FrameRef('ardt_xapcoll')},1,'ardt_xapcoll',0,3)
LoadContext.f('OZMPVCAYQN',function(){return FrameRef('ardt_docopebo')},1,'ardt_docopebo',0,5)
LoadContext.f('RZOXJTRIYP',function(){return FrameRef('armt_xperazbo_agg')},1,'armt_xperazbo_agg',0,6)
LoadContext.f('HPXRKUBEED',function(){return FrameRef('ardt_xpe_contante')},1,'ardt_xpe_contante',0,7)
GetSelectedChildPage.child={'ardt_sogopeprov': function(){return FrameRef('ardt_sogopeprov')}, 'ardt_xlientiope': function(){return FrameRef('ardt_xlientiope')}, 'ardt_xeneficope': function(){return FrameRef('ardt_xeneficope')}, 'ardt_xerzistiope': function(){return FrameRef('ardt_xerzistiope')}, 'ardt_xapcoll': function(){return FrameRef('ardt_xapcoll')}, 'ardt_docopebo': function(){return FrameRef('ardt_docopebo')}, 'armt_xperazbo_agg': function(){return FrameRef('armt_xperazbo_agg')}, 'ardt_xpe_contante': function(){return FrameRef('ardt_xpe_contante')}}
function GetSelectedPage(p_d) {
p_d.setValue('armt_oprovvisorie',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
if (IsNull(p_id) || Eq(p_id,'AQSAREJVST')) {
if (Ctrl('AQSAREJVST')) {
render_combobox('AQSAREJVST','qbe_tipileg',["?w_CDATOPE","?w_filtro"],[WtA(w_CDATOPE,"C"),WtA(w_filtro,"C")],GetDynComboId('AQSAREJVST'),'TPCODICE','TPDESCRI','',WtA(w_TIPOLEG));
w_TIPOLEG=HtW(getComboValue(Ctrl('AQSAREJVST')),'C');
}
}
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODDIPE,'C'); },"field":"CODDIP","type":"C"},{"expression":function() { return WtA(w_xDescDipe,'C'); },"field":"DESCRIZ","type":"C"},{"expression":function() { return WtA(w_CITDIP,'C'); },"field":"DESCCIT","type":"C"},{"expression":function() { return WtA(w_PROVDIP,'C'); },"field":"PROVINCIA","type":"C"},{"expression":function() { return WtA(w_CABDIP,'C'); },"field":"CAB","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('anadip','C'),"uid":"AVHTGZTOSZ"});
ExtendedMenu({"configName":WtA('cauinter','C'),"fldValues":[{"expression":function() { return WtA(w_idcauana,'C'); },"field":"idbase","type":"C"},{"expression":function() { return WtA(w_CODANA,'C'); },"field":"CODCAU","type":"C"},{"expression":function() { return WtA(w_CODVOC,'C'); },"field":"CAUSINT","type":"C"},{"expression":function() { return WtA(w_SEGNO,'C'); },"field":"SEGNO","type":"C"},{"expression":function() { return WtA(w_NOSARA,'C'); },"field":"NOSARA","type":"C"},{"expression":function() { return WtA(w_xFLGITAEST,'C'); },"field":"FLGINTER","type":"C"},{"expression":function() { return WtA(w_desccauana,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcauana','C'),"uid":"XDPPAEWQFR"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_RAPPORTO,'C'); },"field":"RAPPORTO","type":"C"},{"expression":function() { return WtA(w_xdescrap,'C'); },"field":"DESCRAP","type":"C"},{"expression":function() { return WtA(w_FLAGRAP,'C'); },"field":"TIPORAP","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('anarapbo','C'),"uid":"RZIQZFKPUE"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CONNESCLI,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xragsocper,'C'); },"field":"RAGSOC","type":"C"},{"expression":function() { return WtA(w_xcodfisc,'C'); },"field":"CODFISC","type":"C"},{"expression":function() { return WtA(w_DATAVALI,'D'); },"field":"DATAVALI","type":"D"},{"expression":function() { return WtA(w_DATARILASC,'D'); },"field":"DATARILASC","type":"D"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"QBLXDBODXR"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CONNESOPER,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xragsocct,'C'); },"field":"RAGSOC","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"TCOTJNZLGM"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CONNESBEN,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xragsocben,'C'); },"field":"RAGSOC","type":"C"},{"expression":function() { return WtA(w_C_RAPPORTO,'C'); },"field":"CONTO","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"ULVCBLFVEU"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CONNALTRO,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xragsocalt,'C'); },"field":"RAGSOC","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"HWFHDWYMIU"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_C_CTA,'C'); },"field":"CITTA","type":"C"},{"expression":function() { return WtA(w_C_CAB,'C'); },"field":"CAB","type":"C"},{"expression":function() { return WtA(w_C_PRV,'C'); },"field":"PROV","type":"C"},{"expression":function() { return WtA(w_C_STA,'C'); },"field":"PKTBSTATI","type":"C"},{"expression":function() { return WtA(w_C_CAP,'C'); },"field":"CAP","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcitta','C'),"uid":"ODAYKSRECA"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_C_STA,'C'); },"field":"CODSTA","type":"C"},{"expression":function() { return WtA(w_dessta,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"YVIKEGPYPM"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODINT2,'C'); },"field":"CODINTER","type":"C"},{"expression":function() { return WtA(w_DESCINTER,'C'); },"field":"RAGSOC","type":"C"},{"expression":function() { return WtA(w_CODCAB2,'C'); },"field":"CODCAB","type":"C"},{"expression":function() { return WtA(w_PROV2,'C'); },"field":"PROVINCIA","type":"C"},{"expression":function() { return WtA(w_PAESE,'C'); },"field":"PAESE","type":"C"},{"expression":function() { return WtA(w_TIPOINT2,'C'); },"field":"TIPINTER","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('inter2bo','C'),"uid":"CDJFSCCGNX"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_PAESE,'C'); },"field":"CODSTA","type":"C"},{"expression":function() { return WtA(w_xdescpaese2,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"NYRJHOZOON"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODCAB2,'C'); },"field":"CAB","type":"C"},{"expression":function() { return WtA(w_DESC2,'C'); },"field":"CITTA","type":"C"},{"expression":function() { return WtA(w_PROV2,'C'); },"field":"PROV","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcitta','C'),"uid":"YQINIDXZSL"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_OPERAG,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xdescopeage,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbtipope','C'),"uid":"QEFXECTWSF"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CONNESDOC,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xRAGSOCDOC,'C'); },"field":"RAGSOC","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('kersonbo','C'),"uid":"WNMMMNSARU"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_DURAT,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xdescfreq,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbdurata','C'),"uid":"CKJQULDXKW"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_AMMONT,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xdescammo,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbimporto','C'),"uid":"SXTYCPHBIM"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_AREAGEO,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xdescareag,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbareegeog','C'),"uid":"QJSTZIPOQB"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_MODSVOL,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xdescmodsvo,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbsvolgim','C'),"uid":"SFFFOYOWNH"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_RAGIO,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xdescplauso,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbplauso','C'),"uid":"NOBMPHKVTX"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_TIPO,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xdesctipor,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbtiporisc','C'),"uid":"DJOWYRMDDC"});
}
_Obli('MITIG',1,'DOXBACRWUU',false,"307787605")
_Obli('RISGLOB',0,'SMVVFHCEHA',false,"10500809751")
_Obli('RTIPO',1,'RUWEXWJASG',false)
_Obli('TIPO',0,'XSVOIKCEKR',false)
_Obli('TIPO',0,'DJOWYRMDDC',false)
_Obli('RRAGIO',1,'QBTVZDKLCO',false)
_Obli('RAGIO',0,'NVHOMNEASH',false)
_Obli('RAGIO',0,'NOBMPHKVTX',false)
_Obli('RCOMP',1,'ETALZDRBSO',false)
_Obli('MODSVOL',0,'VZKBEOYRRK',false)
_Obli('MODSVOL',0,'SFFFOYOWNH',false)
_Obli('RAREA',1,'UDAYHICPVB',false)
_Obli('AREAGEO',0,'UXDPSYOTRU',false)
_Obli('AREAGEO',0,'QJSTZIPOQB',false)
_Obli('RIMP',1,'KBIUAXUDXA',false)
_Obli('AMMONT',0,'ASETEUZIOS',false)
_Obli('AMMONT',0,'SXTYCPHBIM',false)
_Obli('RFREQ',1,'MXYTQLATHC',false)
_Obli('DURAT',0,'VMVNJQLPEN',false)
_Obli('DURAT',0,'CKJQULDXKW',false)
_Obli('PROV2',0,'ACAPFGYRVI',true,"635233449",null,null,function() { return Ne(At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R'),0) && Eq(w_xFLGITAEST,'I') })
_Obli('SV58550MA',0,'MDVEMSKFNR',false,"12000295156")
_Obli('SV58550',0,'SMZCOQAIDC',false,"10984972139")
_Obli('SCOPO',0,'VASVGQZJGP',false)
_Obli('IDBASE',0,'NHERHRZTFP',false,"113866889")
_Obli('ZCPARTE',0,'GXMZZZHVBR',false)
_Obli('CODDIPE',0,'AVHTGZTOSZ',false,"2071283709")
_Obli('INFORM',0,'KDWBJNGUTK',false)
_Obli('OPERAG',0,'QEFXECTWSF',false)
_Obli('CODCAB2',0,'YQINIDXZSL',true,"12135010165",'YQINIDXZSL',null,function() { return Ne(At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R'),0) && Eq(w_xFLGITAEST,'I') })
_Obli('DATAOPE',2,'YLIKFVPZJA',true,"829201110")
_Obli('DESC2',0,'FFCAGQAZHK',true,"10166248752",null,null,function() { return Ne(At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R'),0) && Eq(w_xFLGITAEST,'I') })
_Obli('NOPROT',1,'LEHLEQRJPH',false)
_Obli('CONNESBEN',0,'ULVCBLFVEU',false,"10219814530")
_Obli('CONNALTRO',0,'HWFHDWYMIU',false)
_Obli('MITIGDOC',0,'OXGBDTWKSX',false,"724026219")
_Obli('MTCN',0,'JDTKGSGMAF',false,"338061")
_Obli('CONNESDOC',0,'WNMMMNSARU',false,"711282992")
_Obli('CONNESDOC',0,'NWEMAAVMTA',false,"339694596")
_Obli('FLAGFRAZ',0,'QSRYXQJCBZ',false,"1722199786")
_Obli('C_RAG',0,'AWPNTOJIRR',true,"1284129730",null,null,function() { return Ne(At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R'),0) })
_Obli('TIPOOPRAP',0,'UJRFWINIVQ',false,"11137644647")
_Obli('idcauana',0,'XDPPAEWQFR',true,"1814604627",'XDPPAEWQFR')
_Obli('C_CTA',0,'ODAYKSRECA',false,"1410438055")
_Obli('C_PRV',0,'NOTZPDMYIA',false,"1637276170")
_Obli('PRESTAZ',0,'RQKHNRJEDR',false,"2135167160")
_Obli('appolire',0,'LJBMCCABSS',true,"10126883135")
_Obli('VALUTA',0,'MKCXJZEKIG',true,"10849117717",'MKCXJZEKIG')
_Obli('xTOTLIRE',1,'EDIXWZNSIC',true,"11144213888")
_Obli('FLAGCONT',0,'PURPSXEVAI',false,"237632211")
_Obli('xTOTCONT',1,'CTORYEJVDR',true,"616535110",null,null,function() { return Eq(w_FLAGCONT,'1') })
_Obli('CAMBIO',1,'YTCDGCPEDJ',false,"123704147")
_Obli('IMPIN',1,'YXAKYHSWPW',false,"7070950")
_Obli('IMPOUT',1,'DPCGXWDECV',false,"643948227")
_Obli('RAPPORTO',0,'RZIQZFKPUE',false,"10379997930")
_Obli('CONNESCLI',0,'QBLXDBODXR',false,"10219814530")
_Obli('PROQUOTA',1,'ADUIDSWRJW',false,"11552491820")
_Obli('IMPSARA',1,'LLXFEZDLPK',false,"1992150396")
_Obli('CONNESOPER',0,'TCOTJNZLGM',false,"10219814530")
_Obli('TIPOLEG',0,'AQSAREJVST',true,"10639118571",null,null,function() { return  ! (Empty(w_CONNESOPER)) })
_Obli('PAGASOGOP',0,'JGKMKQMAHS',false)
_Obli('DESCINTER',0,'VYDRMHACRY',true,"1663847547",null,null,function() { return Ne(At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R'),0) && Empty(w_CODINT2) && Eq(w_gVerSim,'N') })
_Obli('DESCINTER',0,'MXCRVGEBAO',false)
_Obli('TIPOINT2',0,'HNMYJPHSQN',true,"11628231202",null,null,function() { return Ne(At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R'),0) })
_Obli('CODINT2',0,'CDJFSCCGNX',false,"10166252281")
_Obli('NATURA',0,'VSHUPFYWOC',false)
_Obli('VASP',0,'YMKLIGEOKH',false,"1988585268")
_Obli('C_CAP',0,'RDAVOEETJG',false,"11141557209")
_Obli('C_CAB',0,'BOTAJBWHHY',false,"11085000424")
_Obli('C_IND',0,'VYLHWTRQNX',false,"11835283726")
_Obli('C_STA',0,'YVIKEGPYPM',true,"728888873",'YVIKEGPYPM',null,function() { return Ne(At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R'),0) })
_Obli('C_RAPPORTO',0,'YBNJCVPDUM',false)
_Obli('RESPINS',0,'VMRTFBBQHL',false)
_Obli('MEZPAG',0,'JEKLOGLRAN',false,"10114564076")
_Obli('PAESE',0,'NYRJHOZOON',true,"1108605666",'NYRJHOZOON',null,function() { return Ne(At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R'),0) })
_Obli('NOSARA',0,'XCYZDRXAMJ',false,"10450770185")
