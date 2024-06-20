function FillCombosValues() {
FillCombo('JXOBOAXKRQ','JXOBOAXKRQ');
FillCombo('AYYXYNLAUC','AYYXYNLAUC');
FillCombo('LYZAJWZGAM','LYZAJWZGAM');
FillCombo('GORKFABVFF','GORKFABVFF');
}
function SetControlsValue() {
var c;
if(c=Ctrl('JXOBOAXKRQ')) selectCombo(c,w_TIPINTER,'C')
SPBOUILib.SetInputValue('HVIUTGJWGE',function(){return WtH(w_RAGSOC,'C',70,0,'@!')},w_RAGSOC);
SPBOUILib.SetInputValue('JCGROGAZTR',function(){return WtH(w_DESCCIT,'C',30,0,'')},w_DESCCIT);
SPBOUILib.SetInputValue('UQKLCBCTLH',function(){return WtH(w_PROVINCIA,'C',2,0,'')},w_PROVINCIA);
SPBOUILib.SetInputValue('BQSGHFQUHM',function(){return WtH(w_CAP,'C',9,0,'')},w_CAP);
SPBOUILib.SetInputValue('IXWLDAOCFD',function(){return WtH(w_CODCAB,'C',6,0,'')},w_CODCAB);
SPBOUILib.SetInputValue('SJHNBZJAKA',function(){return WtH(w_DOMICILIO,'C',35,0,'')},w_DOMICILIO);
SPBOUILib.SetInputValue('IIXRREUEAM',function(){return WtH(w_PAESE,'C',3,0,'')},w_PAESE);
SPBOUILib.SetInputValue('SZWCLLEIQY',function(){return WtH(w_CODFISC,'C',16,0,'')},w_CODFISC);
SPBOUILib.SetInputValue('OIWIANSIOG',function(){return WtH(w_PARTIVA,'C',14,0,'')},w_PARTIVA);
SPBOUILib.SetInputValue('TNUQTSSGFZ',function(){return WtH(w_DATANASC,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATANASC);
SPBOUILib.SetInputValue('LLYIGAMXRH',function(){return WtH(w_SOTGRUP,'C',3,0,'')},w_SOTGRUP);
SPBOUILib.SetInputValue('RVNHQCXNEM',function(){return WtH(w_RAMOGRUP,'C',3,0,'')},w_RAMOGRUP);
SPBOUILib.SetInputValue('ZGNLLSFQHC',function(){return WtH(w_SETTSINT,'C',3,0,'')},w_SETTSINT);
if(c=Ctrl('AYYXYNLAUC')) selectCombo(c,w_TIPODOC,'C')
if(c=Ctrl('OREVCZVNVS')) selectCombo(c,w_SESSO,'C')
SPBOUILib.SetInputValue('XCNHFVDZMT',function(){return WtH(w_NUMDOCUM,'C',15,0,'')},w_NUMDOCUM);
SPBOUILib.SetInputValue('ZYURNYDRPU',function(){return WtH(w_DATARILASC,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATARILASC);
SPBOUILib.SetInputValue('YYONLOLCBB',function(){return WtH(w_AUTRILASC,'C',30,0,'')},w_AUTRILASC);
SPBOUILib.SetInputValue('PSZTLCSMPB',function(){return WtH(w_CODDIPE,'C',6,0,'')},w_CODDIPE);
SPBOUILib.SetInputValue('COVTIKSDDS',function(){return WtH(w_NOTE,'M',10,0,'')},w_NOTE);
SPBOUILib.SetInputValue('WSAOVXNTFO',function(){return WtH(w_CODORO,'C',20,0,'')},w_CODORO);
SPBOUILib.SetInputValue('YPYQJILEQY',function(){return WtH(w_CODINTER,'C',11,0,'')},w_CODINTER);
var tmp_MXPRRGVTSK = ToHTag(AsControlValue(w_DESCRIsta));
if (Ne(e_MXPRRGVTSK,tmp_MXPRRGVTSK)) {
SPBOUILib.SetLabelValue('MXPRRGVTSK','innerHTML',tmp_MXPRRGVTSK);
e_MXPRRGVTSK=tmp_MXPRRGVTSK;
}
var tmp_OCYWPELSQS = ToHTag(AsControlValue(w_descdip));
if (Ne(e_OCYWPELSQS,tmp_OCYWPELSQS)) {
SPBOUILib.SetLabelValue('OCYWPELSQS','innerHTML',tmp_OCYWPELSQS);
e_OCYWPELSQS=tmp_OCYWPELSQS;
}
var tmp_HCAZKBKJGO = ToHTag(AsControlValue(w_DESCSGRU));
if (Ne(e_HCAZKBKJGO,tmp_HCAZKBKJGO)) {
SPBOUILib.SetLabelValue('HCAZKBKJGO','innerHTML',tmp_HCAZKBKJGO);
e_HCAZKBKJGO=tmp_HCAZKBKJGO;
}
var tmp_FXLAZWVNMJ = ToHTag(AsControlValue(w_DESCRAMGRU));
if (Ne(e_FXLAZWVNMJ,tmp_FXLAZWVNMJ)) {
SPBOUILib.SetLabelValue('FXLAZWVNMJ','innerHTML',tmp_FXLAZWVNMJ);
e_FXLAZWVNMJ=tmp_FXLAZWVNMJ;
}
var tmp_DOCORIFJEH = ToHTag(AsControlValue(w_DESCUIC));
if (Ne(e_DOCORIFJEH,tmp_DOCORIFJEH)) {
SPBOUILib.SetLabelValue('DOCORIFJEH','innerHTML',tmp_DOCORIFJEH);
e_DOCORIFJEH=tmp_DOCORIFJEH;
}
var tmp_ORWPADTZZT = ToHTag(AsControlValue(w_xdescitdip));
if (Ne(e_ORWPADTZZT,tmp_ORWPADTZZT)) {
SPBOUILib.SetLabelValue('ORWPADTZZT','innerHTML',tmp_ORWPADTZZT);
e_ORWPADTZZT=tmp_ORWPADTZZT;
}
var tmp_PPBRHNBLNO = ToHTag(AsControlValue(w_xcabdip));
if (Ne(e_PPBRHNBLNO,tmp_PPBRHNBLNO)) {
SPBOUILib.SetLabelValue('PPBRHNBLNO','innerHTML',tmp_PPBRHNBLNO);
e_PPBRHNBLNO=tmp_PPBRHNBLNO;
}
SPBOUILib.SetInputValue('MXHAWWCAZX',function(){return WtH(w_DATAVALI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAVALI);
SPBOUILib.SetInputValue('TFMCRMSOGY',function(){return WtH(w_CFINVIO,'C',16,0,'')},w_CFINVIO);
SPBOUILib.SetInputValue('YUCSUDKWNH',function(){return WtH(w_CAFINVIO,'C',5,0,'')},w_CAFINVIO);
if(c=Ctrl('JSTXCUBOUH')) selectCombo(c,w_FILEINVIO,'C')
SPBOUILib.SetInputValue('YOVFWZCOBN',function(){return WtH(w_DATAINVIO,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAINVIO);
SPBOUILib.SetInputValue('QPIRUTKOVH',function(){return WtH(w_IDSID,'C',8,0,'')},w_IDSID);
SPBOUILib.SetInputValue('ULCBOSJURF',function(){return WtH(w_SIDPASS,'C',30,0,'')},w_SIDPASS);
SPBOUILib.SetInputValue('KHHILRUMHZ',function(){return WtH(w_PATHJAVA,'C',250,0,'')},w_PATHJAVA);
if(c=Ctrl('ELBURHNYTV')) selectCombo(c,w_TIPOINST,'C')
if(c=Ctrl('JYYHNLJDWT')) ChkboxCheckUncheck(c,1,w_FLGSIDAUTO)
if(c=Ctrl('JYYHNLJDWT')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('FLPFDBFHXV',function(){return WtH(w_appocert,'C',10,0,'')},w_appocert);
var tmp_NRBJJRHEYL = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_NRBJJRHEYL,tmp_NRBJJRHEYL)) {
SPBOUILib.SetLabelValue('NRBJJRHEYL','innerHTML',tmp_NRBJJRHEYL);
e_NRBJJRHEYL=tmp_NRBJJRHEYL;
}
if(c=Ctrl('LYZAJWZGAM')) selectCombo(c,w_TIPOSV,'C')
SPBOUILib.SetInputValue('LAQADJFMRL',function(){return WtH(w_LIMITE20,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_LIMITE20);
SPBOUILib.SetInputValue('FTETLDBHIY',function(){return WtH(w_CODVASP,'C',10,0,'')},w_CODVASP);
if(c=Ctrl('CWVJUDEVCT')) ChkboxCheckUncheck(c,1,w_ART1)
if(c=Ctrl('CWVJUDEVCT')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('FPFLFCPHAL',function(){return WtH(w_URLAPPL,'C',80,0,'')},w_URLAPPL);
if(c=Ctrl('EOQVPQLKOP')) ChkboxCheckUncheck(c,'S',w_FLGLOG)
if(c=Ctrl('EOQVPQLKOP')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('BLWLPTWCFV')) ChkboxCheckUncheck(c,'S',w_FLGAOS)
if(c=Ctrl('BLWLPTWCFV')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('REBGPUSIPL')) ChkboxCheckUncheck(c,'S',w_FLGEAOS)
if(c=Ctrl('REBGPUSIPL')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('HKDCUQQHSU')) ChkboxCheckUncheck(c,'S',w_FLGCDOC)
if(c=Ctrl('HKDCUQQHSU')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('CCBVEBVMNW')) ChkboxCheckUncheck(c,'S',w_FLGFRAZ)
if(c=Ctrl('CCBVEBVMNW')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('IDROHZZWYH')) selectCombo(c,w_FLGAPERS,'C')
SPBOUILib.SetInputValue('IQOQQQRZAK',function(){return WtH(w_DTINIATT,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DTINIATT);
if(c=Ctrl('ZPSOMDIBXB')) selectRadio(c,w_FLGTIPIMP,'C')
if(c=Ctrl('PIGFPYZMIR')) ChkboxCheckUncheck(c,'S',w_FLGSTPCON)
if(c=Ctrl('PIGFPYZMIR')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('DUFIQNBDKW')) selectCombo(c,w_FLGIMPAGE,'C')
if(c=Ctrl('LOYILZBSVI')) ChkboxCheckUncheck(c,'S',w_FLGWU)
if(c=Ctrl('LOYILZBSVI')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('YJCSSLPJKG',function(){return WtH(w_IMPINTOPE,'N',12,2,'')},w_IMPINTOPE);
if(c=Ctrl('PXNLADGGBR')) ChkboxCheckUncheck(c,'S',w_FLGOPEXTR)
if(c=Ctrl('PXNLADGGBR')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('OSHAMNPXFT')) ChkboxCheckUncheck(c,'S',w_FLGRAPCLI)
if(c=Ctrl('OSHAMNPXFT')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('UETNARUDOE')) ChkboxCheckUncheck(c,1,w_NOCODFISC)
if(c=Ctrl('UETNARUDOE')) ChkboxValueAssign(c,1,0,'N',1,0,'')
if(c=Ctrl('UHGVOKNSVL')) ChkboxCheckUncheck(c,'S',w_FLGCHK)
if(c=Ctrl('UHGVOKNSVL')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('NLUIAOSQKM',function(){return WtH(w_PWDSER,'C',10,0,'')},w_PWDSER);
if(c=Ctrl('XDDITMPJIZ')) selectCombo(c,w_SOSPMAF,'C')
if(c=Ctrl('LUPNVRRLHF')) ChkboxCheckUncheck(c,'S',w_FLGRITORNO)
if(c=Ctrl('LUPNVRRLHF')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('HFADCPKPNB')) ChkboxCheckUncheck(c,'S',w_FLGCREAAGE)
if(c=Ctrl('HFADCPKPNB')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('ASIWFAENLM',function(){return WtH(w_DTTITAGE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DTTITAGE);
SPBOUILib.SetInputValue('IOYUNQJDKZ',function(){return WtH(w_SCADSALDI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_SCADSALDI);
if(c=Ctrl('LSBZHECNKO')) ChkboxCheckUncheck(c,'S',w_FLGIPMT)
if(c=Ctrl('LSBZHECNKO')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('FKIIMPSJSB',function(){return WtH(w_LIMITEFRZ,'N',10,2,'')},w_LIMITEFRZ);
SPBOUILib.SetInputValue('EQCSRKQZVC',function(){return WtH(w_DBPROT,'C',100,0,'')},w_DBPROT);
if(c=Ctrl('KFQWZVCJIW')) ChkboxCheckUncheck(c,1,w_OAMTPDOC)
if(c=Ctrl('KFQWZVCJIW')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('LGZDRUUSXZ',function(){return WtH(w_DAYSIMPORT,'N',2,0,'')},w_DAYSIMPORT);
SPBOUILib.SetInputValue('FQKHRITNGP',function(){return WtH(w_DAYSIMPCMB,'N',2,0,'')},w_DAYSIMPCMB);
if(c=Ctrl('SIZHWNZUOT')) ChkboxCheckUncheck(c,'S',w_FLGAWUPOS)
if(c=Ctrl('SIZHWNZUOT')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('QBHBPWJMOW',function(){return WtH(w_WUGIOSCA,'N',3,0,'')},w_WUGIOSCA);
SPBOUILib.SetInputValue('HXPRRNXNJO',function(){return WtH(w_WUGGALERT,'N',3,0,'')},w_WUGGALERT);
SPBOUILib.SetInputValue('AAIARGXIIW',function(){return WtH(w_RICEVUTE,'C',250,0,'')},w_RICEVUTE);
if(c=Ctrl('PLWDFUBDIP')) ChkboxCheckUncheck(c,'S',w_OGGI3I4)
if(c=Ctrl('PLWDFUBDIP')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('PDLIXDKBWK')) ChkboxCheckUncheck(c,'S',w_CGOTGDEFMUL)
if(c=Ctrl('PDLIXDKBWK')) ChkboxValueAssign(c,'S','N','C',3,0,'')
if(c=Ctrl('PVOEPQLJPS')) ChkboxCheckUncheck(c,'S',w_AUTOSARA)
if(c=Ctrl('PVOEPQLJPS')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('FCXDRDCINI')) ChkboxCheckUncheck(c,'S',w_FLGCGOOTP)
if(c=Ctrl('FCXDRDCINI')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('RBAZEQPPJI')) ChkboxCheckUncheck(c,'S',w_ITFLGPEP)
if(c=Ctrl('RBAZEQPPJI')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('VDJMSNZEEV',function(){return WtH(w_ITPWDPEP,'C',50,0,'')},w_ITPWDPEP);
SPBOUILib.SetInputValue('LNADTKDHIZ',function(){return WtH(w_ITUSRPEP,'C',50,0,'')},w_ITUSRPEP);
if(c=Ctrl('XMAVZMPWRZ')) ChkboxCheckUncheck(c,'S',w_FLGAGGFAM)
if(c=Ctrl('XMAVZMPWRZ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('BZARULYZUH',function(){return WtH(w_ALTSRVMAIL,'C',50,0,'')},w_ALTSRVMAIL);
SPBOUILib.SetInputValue('CWFIJJMSTR',function(){return WtH(w_ALTPRTMAIL,'C',5,0,'')},w_ALTPRTMAIL);
SPBOUILib.SetInputValue('YPHGLIUDNW',function(){return WtH(w_ALTEMLMAIL,'C',50,0,'')},w_ALTEMLMAIL);
SPBOUILib.SetInputValue('HSAOKMBAUY',function(){return WtH(w_ALTUSRMAIL,'C',50,0,'')},w_ALTUSRMAIL);
SPBOUILib.SetInputValue('LGVTLPSUGS',function(){return WtH(w_ALTPWDMAIL,'C',80,0,'')},w_ALTPWDMAIL);
if(c=Ctrl('KPSLGRAIIO')) ChkboxCheckUncheck(c,'S',w_ALTSSLEMAIL)
if(c=Ctrl('KPSLGRAIIO')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('YRAEGOUXRJ',function(){return WtH(w_PATHIMPORT,'C',128,0,'')},w_PATHIMPORT);
SPBOUILib.SetInputValue('OHRBGBCDVG',function(){return WtH(w_DESTEMAIL,'C',80,0,'')},w_DESTEMAIL);
SPBOUILib.SetInputValue('KDJLQEMEDV',function(){return WtH(w_COGNOME,'C',30,0,'')},w_COGNOME);
SPBOUILib.SetInputValue('VTFLIHXHLG',function(){return WtH(w_NOME,'C',30,0,'')},w_NOME);
if(c=Ctrl('SIJUUSKFLV')) selectCombo(c,w_SESSO,'C')
SPBOUILib.SetInputValue('XCZARGUGTG',function(){return WtH(w_DNASC,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DNASC);
SPBOUILib.SetInputValue('PZGXGIZQWY',function(){return WtH(w_DESCCIT,'C',30,0,'')},w_DESCCIT);
SPBOUILib.SetInputValue('MUWSLBTIOI',function(){return WtH(w_PROVINCIA,'C',2,0,'')},w_PROVINCIA);
if(c=Ctrl('WQWXGOLVXC')) selectCombo(c,w_CITTADINA,'C')
SPBOUILib.SetInputValue('DUROREWBNG',function(){return WtH(w_NASCOMUN,'C',30,0,'')},w_NASCOMUN);
SPBOUILib.SetInputValue('ZTUIXEONYI',function(){return WtH(w_NASSTATO,'C',30,0,'')},w_NASSTATO);
SPBOUILib.SetInputValue('KSRCRPEMFT',function(){return WtH(w_PRNASC,'C',2,0,'')},w_PRNASC);
if(c=Ctrl('IYKMLTUWXM')) selectCombo(c,w_SOGCOM,'C')
if(c=Ctrl('KYNLIGXUVC')) selectCombo(c,w_TIPODOC,'C')
SPBOUILib.SetInputValue('IAXBQWHGLM',function(){return WtH(w_BPCODPAT,'C',12,0,'')},w_BPCODPAT);
SPBOUILib.SetInputValue('PBQXUDZUOZ',function(){return WtH(w_BPENTSEG,'C',12,0,'')},w_BPENTSEG);
SPBOUILib.SetInputValue('UBNVJIYFWU',function(){return WtH(w_BPCOGSEG,'C',30,0,'')},w_BPCOGSEG);
SPBOUILib.SetInputValue('PELELICXZD',function(){return WtH(w_BPNOMSEG,'C',30,0,'')},w_BPNOMSEG);
SPBOUILib.SetInputValue('DZVDAZOPWP',function(){return WtH(w_BPTELSEG,'C',15,0,'')},w_BPTELSEG);
SPBOUILib.SetInputValue('HRZVDXDSOJ',function(){return WtH(w_BPEMLSEG,'C',50,0,'')},w_BPEMLSEG);
SPBOUILib.SetInputValue('TFDNMJLIWF',function(){return WtH(w_ABI,'C',6,0,'')},w_ABI);
SPBOUILib.SetInputValue('WRRSZRBPCI',function(){return WtH(w_CAB,'C',6,0,'')},w_CAB);
SPBOUILib.SetInputValue('PUFIBBLEMQ',function(){return WtH(w_GGWARNPRV,'N',3,0,'')},w_GGWARNPRV);
SPBOUILib.SetInputValue('MBMIGFSBXO',function(){return WtH(w_GGWARNAUI,'N',3,0,'')},w_GGWARNAUI);
SPBOUILib.SetInputValue('XUNVKFSSZL',function(){return WtH(w_SOGLIAMAX,'N',12,2,'999,999,999.99')},w_SOGLIAMAX);
SPBOUILib.SetInputValue('CMBYXKAJCS',function(){return WtH(w_CODVASP,'C',10,0,'')},w_CODVASP);
SPBOUILib.SetInputValue('CNQFAHXNUY',function(){return WtH(w_IDOAM,'C',8,0,'')},w_IDOAM);
SPBOUILib.SetInputValue('PUYJXGBDJI',function(){return WtH(w_IDOAMR,'C',8,0,'')},w_IDOAMR);
SPBOUILib.SetInputValue('DNCMAAILTV',function(){return WtH(w_SKT_SERVER,'C',30,0,'')},w_SKT_SERVER);
SPBOUILib.SetInputValue('UMEMYFCVBI',function(){return WtH(w_SKT_PORT,'N',5,0,'')},w_SKT_PORT);
SPBOUILib.SetInputValue('ZFUOSYKTGZ',function(){return WtH(w_SKT_PATHS,'C',60,0,'')},w_SKT_PATHS);
if(c=Ctrl('ECARBEFMBC')) selectCombo(c,w_SKT_MODET,'C')
SPBOUILib.SetInputValue('DNNGPDMXQI',function(){return WtH(w_RASPAUI,'C',50,0,'')},w_RASPAUI);
SPBOUILib.SetInputValue('WHJVJHBKYI',function(){return WtH(w_RESPAUI,'C',50,0,'')},w_RESPAUI);
SPBOUILib.SetInputValue('ZZSBUTEXWS',function(){return WtH(w_TESTIP,'C',11,0,'')},w_TESTIP);
SPBOUILib.SetInputValue('XRGIDJXVCB',function(){return WtH(w_MINFRZSNAI,'N',12,2,'')},w_MINFRZSNAI);
if(c=Ctrl('CZINOLQOUB')) ChkboxCheckUncheck(c,'S',w_FLGSCDFRZ)
if(c=Ctrl('CZINOLQOUB')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('BMMUPRLVUU',function(){return WtH(w_GIORNIFRZ,'N',3,0,'')},w_GIORNIFRZ);
SPBOUILib.SetInputValue('JFMMDZQFJC',function(){return WtH(w_LIMITVLT,'N',10,2,'9,999,999.99')},w_LIMITVLT);
SPBOUILib.SetInputValue('OHKFECVWFV',function(){return WtH(w_LIMITVNP,'N',10,2,'9,999,999.99')},w_LIMITVNP);
if(c=Ctrl('OOAVIAADZS')) ChkboxCheckUncheck(c,'S',w_FLGSTPDIR)
if(c=Ctrl('OOAVIAADZS')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('MRWHAAPELH')) ChkboxCheckUncheck(c,'S',w_FLGNODOC)
if(c=Ctrl('MRWHAAPELH')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('HBTCFEMATT')) ChkboxCheckUncheck(c,'S',w_FRAZDEL)
if(c=Ctrl('HBTCFEMATT')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('FOTKWJQFAL',function(){return WtH(w_PATHAPP,'C',80,0,'')},w_PATHAPP);
if(c=Ctrl('QMOTVZANBJ')) ChkboxCheckUncheck(c,'S',w_FLGLIGHT)
if(c=Ctrl('QMOTVZANBJ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('JPABVPZDBZ',function(){return WtH(w_pathmanuale,'C',80,0,'')},w_pathmanuale);
if(c=Ctrl('VJPULIZVKG')) ChkboxCheckUncheck(c,'S',w_FLGCGOPWD)
if(c=Ctrl('VJPULIZVKG')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('EMDHDDRUPP',function(){return WtH(w_PATHSID,'C',250,0,'')},w_PATHSID);
SPBOUILib.SetInputValue('WXRSSFBXYH',function(){return WtH(w_PATHCERT,'C',250,0,'')},w_PATHCERT);
SPBOUILib.SetInputValue('WPPFTLWEWX',function(){return WtH(w_PATHFTP,'C',128,0,'')},w_PATHFTP);
if(c=Ctrl('KZJBLRRDWP')) ChkboxCheckUncheck(c,'S',w_FLGUTEAGE)
if(c=Ctrl('KZJBLRRDWP')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('PUWCGJFLDF',function(){return WtH(w_PRGAEPATH,'C',250,0,'')},w_PRGAEPATH);
SPBOUILib.SetInputValue('NVZYOQAKDU',function(){return WtH(w_NUMGIORN,'N',3,0,'')},w_NUMGIORN);
if(c=Ctrl('MHHQTFPDEN')) ChkboxCheckUncheck(c,'S',w_FLGCGOOTP)
if(c=Ctrl('MHHQTFPDEN')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('SSXDYZLCUX')) ChkboxCheckUncheck(c,'S',w_FLGCGOQADV)
if(c=Ctrl('SSXDYZLCUX')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('XVGAGFPMXP',function(){return WtH(w_BLOCCOUSER,'N',3,0,'')},w_BLOCCOUSER);
if(c=Ctrl('ABGLJLFEYQ')) ChkboxCheckUncheck(c,'S',w_CGOFLGPROF)
if(c=Ctrl('ABGLJLFEYQ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('MLYQUOWFHN',function(){return WtH(w_ALTSRVMAIL,'C',50,0,'')},w_ALTSRVMAIL);
SPBOUILib.SetInputValue('VRYHAZPGSR',function(){return WtH(w_ALTPRTMAIL,'C',5,0,'')},w_ALTPRTMAIL);
SPBOUILib.SetInputValue('TYOXRXGXKJ',function(){return WtH(w_ALTEMLMAIL,'C',50,0,'')},w_ALTEMLMAIL);
SPBOUILib.SetInputValue('OKEJPCYNVH',function(){return WtH(w_ALTUSRMAIL,'C',50,0,'')},w_ALTUSRMAIL);
SPBOUILib.SetInputValue('IIVBDSFKCC',function(){return WtH(w_ALTPWDMAIL,'C',30,0,'')},w_ALTPWDMAIL);
if(c=Ctrl('FYAHSLEGLP')) ChkboxCheckUncheck(c,'S',w_FLGGESDOC)
if(c=Ctrl('FYAHSLEGLP')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('MUANKUGIIK',function(){return WtH(w_USRGESDOC,'C',30,0,'')},w_USRGESDOC);
SPBOUILib.SetInputValue('HFVZAFILCA',function(){return WtH(w_PWDGESDOC,'C',30,0,'')},w_PWDGESDOC);
SPBOUILib.SetInputValue('RNIWEERJDP',function(){return WtH(w_URLDESDOC,'C',80,0,'')},w_URLDESDOC);
SPBOUILib.SetInputValue('LZEBZLGWCH',function(){return WtH(w_EMAILDOC,'C',80,0,'')},w_EMAILDOC);
SPBOUILib.SetInputValue('VOONRSAKSU',function(){return WtH(w_DATADOC,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATADOC);
SPBOUILib.SetInputValue('MRRDOEHYLX',function(){return WtH(w_PATHDOCBAC,'C',128,0,'')},w_PATHDOCBAC);
SPBOUILib.SetInputValue('ABFCWFBDMW',function(){return WtH(w_IMPPATH,'C',240,0,'')},w_IMPPATH);
if(c=Ctrl('GORKFABVFF')) selectCombo(c,w_CGOTGDEFMUL,'C')
SPBOUILib.SetInputValue('HAPCMCIYJW',function(){return WtH(w_SONUMMESI,'N',2,0,'')},w_SONUMMESI);
SPBOUILib.SetInputValue('OAAOYRQPRR',function(){return WtH(w_SOMESIBACK,'N',2,0,'')},w_SOMESIBACK);
SPBOUILib.SetInputValue('IDOPVICMXL',function(){return WtH(w_SOSHELLCMD,'M',10,0,'')},w_SOSHELLCMD);
if(c=Ctrl('ATYYTAXDZW')) selectCombo(c,w_SOAMBIENTE,'C')
SPBOUILib.SetInputValue('GHUASLAKBC',function(){return WtH(w_SOPATHIMPORT,'M',10,0,'')},w_SOPATHIMPORT);
SPBOUILib.SetInputValue('APTIWOKBUI',function(){return WtH(w_SOORAIMPORT,'N',2,0,'')},w_SOORAIMPORT);
SPBOUILib.SetInputValue('HRSWOWLUUE',function(){return WtH(w_QADV_SOGLIA,'N',4,0,'')},w_QADV_SOGLIA);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
h=Eq(w_TIPINTER,'15') || IsHiddenByStateDriver(Z.Tabs.Get('tabs').GetTabstripID('page_3'));
SetDisplay(Z.Tabs.Get('tabs').GetTabstripID('page_3'),h);
if (h && (Z.Tabs.Get('tabs').IsExpanded('page_3'))) {
Z.Tabs.Get('tabs').Next() || Z.Tabs.Get('tabs').Prev();
}
h=Ne(w_TIPINTER,'15') || IsHiddenByStateDriver(Z.Tabs.Get('tabs').GetTabstripID('page_4'));
SetDisplay(Z.Tabs.Get('tabs').GetTabstripID('page_4'),h);
if (h && (Z.Tabs.Get('tabs').IsExpanded('page_4'))) {
Z.Tabs.Get('tabs').Next() || Z.Tabs.Get('tabs').Prev();
}
h=Ne(w_TIPINTER,'15') || IsHiddenByStateDriver(Z.Tabs.Get('tabs').GetTabstripID('page_5'));
SetDisplay(Z.Tabs.Get('tabs').GetTabstripID('page_5'),h);
if (h && (Z.Tabs.Get('tabs').IsExpanded('page_5'))) {
Z.Tabs.Get('tabs').Next() || Z.Tabs.Get('tabs').Prev();
}
h=Ne(w_TIPINTER,'15') || IsHiddenByStateDriver(Z.Tabs.Get('tabs').GetTabstripID('page_6'));
SetDisplay(Z.Tabs.Get('tabs').GetTabstripID('page_6'),h);
if (h && (Z.Tabs.Get('tabs').IsExpanded('page_6'))) {
Z.Tabs.Get('tabs').Next() || Z.Tabs.Get('tabs').Prev();
}
SetDisplay('YORQOIOBQN_DIV',IsHiddenByStateDriver('DatiBase'));
SetDisplay('BWMEEFCWMJ_DIV',IsHiddenByStateDriver('box_BWMEEFCWMJ'));
SetDisplay('FJJCZFOQTA_DIV',IsHiddenByStateDriver('box_FJJCZFOQTA'));
SetDisplay('PRFPRMFSTZ_DIV',IsHiddenByStateDriver('box_PRFPRMFSTZ'));
SetDisplay(Ctrl('FLPFDBFHXV'),true || IsHiddenByStateDriver('appocert'));
SetDisplay(Ctrl('NRBJJRHEYL'),true);
SetDisplay(Ctrl('LAQADJFMRL'), ! (LibreriaMit.inter_art1(w_TIPINTER)) || IsHiddenByStateDriver('LIMITE20'));
SetDisplay(Ctrl('LAQADJFMRL_ZOOM'), ! (LibreriaMit.inter_art1(w_TIPINTER)));
SetDisplay(Ctrl('ZTVBLCEEKH'), ! (LibreriaMit.inter_art1(w_TIPINTER)));
SetDisplay(Ctrl('TXEDKCGZGL'), ! (LibreriaMit.inter_art1(w_TIPINTER)));
SetDisplay('POUNPHSDYV_DIV',IsHiddenByStateDriver('ParamBase'));
SetDisplay('EOQVPQLKOP_DIV', ! (Utilities.Make(window).IsAdministrator()));
SetDisplay('BLWLPTWCFV_DIV', ! (Utilities.Make(window).IsAdministrator()));
SetDisplay('PIGFPYZMIR_DIV',Ne(w_FLGAPERS,'4'));
SetDisplay('UHGVOKNSVL_DIV', ! (Utilities.Make(window).IsAdministrator()));
SetDisplay(Ctrl('NLUIAOSQKM'), ! (Utilities.Make(window).IsAdministrator()) || IsHiddenByStateDriver('PWDSER'));
SetDisplay(Ctrl('XDDITMPJIZ'),Ne(w_PWDSER,'MIT'+Substr(DateToChar(SystemDate()),3,6)) || IsHiddenByStateDriver('SOSPMAF'));
SetDisplay(Ctrl('USUAFIVIAY'),Ne(w_PWDSER,'MIT'+Substr(DateToChar(SystemDate()),3,6)));
SetDisplay(Ctrl('REOBNBRGTT'), ! (Utilities.Make(window).IsAdministrator()));
SetDisplay(Ctrl('IOYUNQJDKZ'),true || IsHiddenByStateDriver('SCADSALDI'));
SetDisplay(Ctrl('IOYUNQJDKZ_ZOOM'),true);
SetDisplay(Ctrl('KVNARHOHUS'),true);
SetDisplay('LSBZHECNKO_DIV',Eq(At(w_TIPINTER,'|46|17|81'),0));
SetDisplay('CCPBATRTRJ_DIV',IsHiddenByStateDriver('PEP'));
SetDisplay('DQBIMZLTTE_DIV',IsHiddenByStateDriver('CGOEmail'));
SetDisplay('XFBWYNZQZN_DIV',IsHiddenByStateDriver('Import'));
SetDisplay('CESCBNVXDE_DIV',IsHiddenByStateDriver('Cambiavalute'));
SetDisplay('XEDASKHZOQ_DIV',IsHiddenByStateDriver('Base9Cambia'));
SetDisplay('HDNWLIPNPD_DIV',IsHiddenByStateDriver('DestWarn'));
SetDisplay('TQULLVKAWF_DIV',IsHiddenByStateDriver('OAM'));
SetDisplay('VSXUXPIOIH_DIV',IsHiddenByStateDriver('CGO'));
SetDisplay('NGHUXVAVYG_DIV',IsHiddenByStateDriver('Socket'));
SetDisplay('ENNTXFKBDB_DIV',IsHiddenByStateDriver('RespAnti'));
SetDisplay(Ctrl('JPABVPZDBZ'),true || IsHiddenByStateDriver('pathmanuale'));
SetDisplay('AMSHYBLKWR_DIV',IsHiddenByStateDriver('CGOEmail'));
SetDisplay('KNXWNOJPJB_DIV',IsHiddenByStateDriver('GesDOC'));
SetDisplay(Ctrl('VOONRSAKSU'),Eq(w_FLGDDOC,'S') || IsHiddenByStateDriver('DATADOC'));
SetDisplay(Ctrl('VOONRSAKSU_ZOOM'),Eq(w_FLGDDOC,'S'));
SetDisplay(Ctrl('MKAXCAIGIN'),Eq(w_FLGDDOC,'S'));
SetDisplay(Ctrl('DJJPJVNREQ'),Eq(w_FLGDDOC,'S'));
SetDisplay('EOMKPJOLGE_DIV',IsHiddenByStateDriver('box_EOMKPJOLGE'));
SetDisplay('MFFCPIVYZD_DIV',IsHiddenByStateDriver('E-Learning'));
SetDisplay('UYDQCWOOEO_DIV',IsHiddenByStateDriver('Multiple'));
SetDisplay('QSIBTTRMLJ_DIV',IsHiddenByStateDriver('ExtSO'));
SetDisplay('YAITYOPUEH_DIV',IsHiddenByStateDriver('DestEmail'));
SetDisplay('MKILJOCTZW_DIV',IsHiddenByStateDriver('ImportVLT'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["ABI"]=['QCYZGHORPG'];
HideUI.lblids["ALTEMLMAIL"]=['NFXFLOJWRM','UPYNWKDWTI'];
HideUI.lblids["ALTPRTMAIL"]=['ATTOCVUWED','KRWHWQWWJO'];
HideUI.lblids["ALTPWDMAIL"]=['XWBWYCDSUH','CAZHGSIXHK'];
HideUI.lblids["ALTSRVMAIL"]=['ICYIBIEJPT','EWRSHYJVWC'];
HideUI.lblids["ALTUSRMAIL"]=['RHFVPZJHSD','ROHUJGYBZU'];
HideUI.lblids["AUTRILASC"]=['NSALRHXEBM'];
HideUI.lblids["BLOCCOUSER"]=['NVZVLIUMGN'];
HideUI.lblids["BPCODPAT"]=['HABRXIELKU'];
HideUI.lblids["BPCOGSEG"]=['AZWMLMXFTT'];
HideUI.lblids["BPEMLSEG"]=['LQQXWNYQRB'];
HideUI.lblids["BPENTSEG"]=['IYWXEOHSIG'];
HideUI.lblids["BPNOMSEG"]=['QSZTRDTOHH'];
HideUI.lblids["BPTELSEG"]=['GALIAYORFO'];
HideUI.lblids["CAB"]=['APGZAARWJB'];
HideUI.lblids["CAP"]=['NMZHNTXQTF'];
HideUI.lblids["CFINVIO"]=['WFJIAHYNWC'];
HideUI.lblids["CGOTGDEFMUL"]=['JXWDSHKCJJ'];
HideUI.lblids["CITTADINA"]=['QEDFADZTLI'];
HideUI.lblids["CODCAB"]=['JONRSBZIHE'];
HideUI.lblids["CODDIPE"]=['SJBGPBDZHD'];
HideUI.lblids["CODFISC"]=['XWWYBJUIHH'];
HideUI.lblids["CODINTER"]=['PGYTWCFSTL'];
HideUI.lblids["CODORO"]=['BGMFJTDOCE'];
HideUI.lblids["CODVASP"]=['SCMDDRTKOA','HUPLKWHBHY'];
HideUI.lblids["COGNOME"]=['ROSZPLTXFI'];
HideUI.lblids["DATADOC"]=['MKAXCAIGIN'];
HideUI.lblids["DATAINVIO"]=['NEDHUIILCP'];
HideUI.lblids["DATANASC"]=['OYUTQSFYLN'];
HideUI.lblids["DATARILASC"]=['IVKVLQFAAC'];
HideUI.lblids["DATAVALI"]=['OPNSNKCGEE'];
HideUI.lblids["DAYSIMPCMB"]=['FNFPYHHCTJ'];
HideUI.lblids["DAYSIMPORT"]=['FLAGKQKWLF'];
HideUI.lblids["DBPROT"]=['OWCRFMADTX'];
HideUI.lblids["DESCCIT"]=['UZZIVDGXTK','UPFDNQAQQN'];
HideUI.lblids["DESTEMAIL"]=['ISGMMWGAEC'];
HideUI.lblids["DNASC"]=['LHZGAVQLHJ'];
HideUI.lblids["DOMICILIO"]=['RXTBTLMSHX'];
HideUI.lblids["DTINIATT"]=['AWSAENIKPZ'];
HideUI.lblids["DTTITAGE"]=['LUCDNUTLOB'];
HideUI.lblids["EMAILDOC"]=['YXBFOUJXZL'];
HideUI.lblids["FILEINVIO"]=['VBUGEDJFHA'];
HideUI.lblids["FLGAPERS"]=['OEFBKJVZGI'];
HideUI.lblids["FLGIMPAGE"]=['FRGSTKSWWS'];
HideUI.lblids["FLGTIPIMP"]=['MNXQLPZJTD'];
HideUI.lblids["GGWARNAUI"]=['HPOFGKJCFG'];
HideUI.lblids["GGWARNPRV"]=['FBHJBOUZMO'];
HideUI.lblids["GIORNIFRZ"]=['VXHBHRROHO'];
HideUI.lblids["IDOAM"]=['IMVVZYFAKP'];
HideUI.lblids["IDOAMR"]=['HQOSRSTJSV'];
HideUI.lblids["IDSID"]=['OLANUOOFSZ'];
HideUI.lblids["IMPINTOPE"]=['HGDWNYPDSM'];
HideUI.lblids["IMPPATH"]=['SNAQIGBZKF'];
HideUI.lblids["ITPWDPEP"]=['ZYNRGRHMEV'];
HideUI.lblids["ITUSRPEP"]=['TROEZOSPBE'];
HideUI.lblids["LIMITE20"]=['ZTVBLCEEKH'];
HideUI.lblids["LIMITEFRZ"]=['OUASZKTMZL'];
HideUI.lblids["LIMITVLT"]=['RJCVXDREIV'];
HideUI.lblids["LIMITVNP"]=['RDFGAOKNTD'];
HideUI.lblids["MINFRZSNAI"]=['ZNVCMRAKQV'];
HideUI.lblids["NASCOMUN"]=['RDSGVORAHH'];
HideUI.lblids["NASSTATO"]=['FEFHMTGUWV'];
HideUI.lblids["NOME"]=['KHSXGUNTRM'];
HideUI.lblids["NOTE"]=['SXFVWFHYFF'];
HideUI.lblids["NUMDOCUM"]=['CPZJUXWKDU'];
HideUI.lblids["NUMGIORN"]=['RBGWMMIZHB'];
HideUI.lblids["PAESE"]=['OPSDKLYWTJ'];
HideUI.lblids["PARTIVA"]=['YQOAAOOFNL'];
HideUI.lblids["PATHAPP"]=['JVKSSLUPHM'];
HideUI.lblids["PATHCERT"]=['QUNKJMETVO'];
HideUI.lblids["PATHDOCBAC"]=['SPTLVDHKHB'];
HideUI.lblids["PATHFTP"]=['WNJNVATEHJ'];
HideUI.lblids["PATHIMPORT"]=['AUPNFEOYCV'];
HideUI.lblids["PATHJAVA"]=['RZHRRJTCMJ'];
HideUI.lblids["PATHSID"]=['PZUDQEMFCW'];
HideUI.lblids["PRGAEPATH"]=['YGXQBBEZFG'];
HideUI.lblids["PRNASC"]=['MMUGKFYZMW'];
HideUI.lblids["PROVINCIA"]=['JKODERXVSD','EOCHTUTBUF'];
HideUI.lblids["PWDGESDOC"]=['GGIEQBUUGN'];
HideUI.lblids["PWDSER"]=['REOBNBRGTT'];
HideUI.lblids["QADV_SOGLIA"]=['AUWHLLTNOH'];
HideUI.lblids["RAGSOC"]=['OINFLDOGXT'];
HideUI.lblids["RAMOGRUP"]=['QOLFDIWXXC'];
HideUI.lblids["RASPAUI"]=['BCBTSVHELC'];
HideUI.lblids["RESPAUI"]=['NMLJUJKRDZ'];
HideUI.lblids["RICEVUTE"]=['EKCSWYBUKQ'];
HideUI.lblids["SCADSALDI"]=['KVNARHOHUS'];
HideUI.lblids["SESSO"]=['RFSBVMUUQX','NPSJWIVGOM'];
HideUI.lblids["SETTSINT"]=['LHHLIWFNCK'];
HideUI.lblids["SIDPASS"]=['QJJQEBOELV'];
HideUI.lblids["SKT_MODET"]=['JVXHUCMVZF'];
HideUI.lblids["SKT_PATHS"]=['DVCWNGURJN'];
HideUI.lblids["SKT_PORT"]=['ALYRIEUNZA'];
HideUI.lblids["SKT_SERVER"]=['LBQAGEZTOQ'];
HideUI.lblids["SOAMBIENTE"]=['RQTPKYOXZT'];
HideUI.lblids["SOGCOM"]=['FTRVPLIAQI'];
HideUI.lblids["SOGLIAMAX"]=['MLGAKKSLBW'];
HideUI.lblids["SOMESIBACK"]=['IQSWXNMJHD'];
HideUI.lblids["SONUMMESI"]=['OTANLZAUMP'];
HideUI.lblids["SOORAIMPORT"]=['ZWDTCOUNPV'];
HideUI.lblids["SOPATHIMPORT"]=['MDAFYIMKHP'];
HideUI.lblids["SOSHELLCMD"]=['JUWTXZPQPP'];
HideUI.lblids["SOSPMAF"]=['USUAFIVIAY'];
HideUI.lblids["SOTGRUP"]=['ZZDCRCKYFX'];
HideUI.lblids["TESTIP"]=['RXEIJMGEQM'];
HideUI.lblids["TIPINTER"]=['CVRIOCDDYU'];
HideUI.lblids["TIPODOC"]=['HJLXKBUTGL','UFURNZFHIZ'];
HideUI.lblids["TIPOINST"]=['UOUQMGWZYN'];
HideUI.lblids["TIPOSV"]=['EXFKQPWTSQ'];
HideUI.lblids["URLAPPL"]=['PXCKUPWOFP'];
HideUI.lblids["URLDESDOC"]=['ARQZPHKUOK'];
HideUI.lblids["USRGESDOC"]=['QPIEEELYAP'];
HideUI.lblids["WUGGALERT"]=['OIGTNGXRRH'];
HideUI.lblids["WUGIOSCA"]=['JIDHZWEVMP'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
cond=Eq(w_ITFLGPEP,'S');
if (Ne(o_CCPBATRTRJ_expand,cond)) {
ExpandCollapsibleBox('CCPBATRTRJ',cond);
o_CCPBATRTRJ_expand=cond;
}
cond=Ne(w_ITFLGPEP,'S');
if (Ne(o_CCPBATRTRJ_collapse,cond)) {
CollapseCollapsibleBox('CCPBATRTRJ',cond);
o_CCPBATRTRJ_collapse=cond;
}
}
function JXOBOAXKRQ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPINTER','C',w_TIPINTER,HtW(getComboValue(Ctrl('JXOBOAXKRQ')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPINTER(HtW(getComboValue(Ctrl('JXOBOAXKRQ')),'C'),null,e);
return l_bSetResult;
}
}
function JXOBOAXKRQ_OnFocus(e) {
SetActiveField(Ctrl('JXOBOAXKRQ'),true);
}
function JXOBOAXKRQ_OnBlur(e) {
SetActiveField(Ctrl('JXOBOAXKRQ'),false);
}
function HVIUTGJWGE_Valid(e) {
SetActiveField(Ctrl('HVIUTGJWGE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RAGSOC','C',w_RAGSOC,HtW(Ctrl('HVIUTGJWGE').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAGSOC(HtW(Ctrl('HVIUTGJWGE').value,'C'),null,e);
return l_bSetResult;
}
}
function HVIUTGJWGE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HVIUTGJWGE'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('HVIUTGJWGE',w_RAGSOC,'C',70,0,'@!');
SetActiveField(Ctrl('HVIUTGJWGE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HVIUTGJWGE'),e);
}
function HVIUTGJWGE_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function JCGROGAZTR_Valid(e) {
SetActiveField(Ctrl('JCGROGAZTR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCCIT','C',w_DESCCIT,HtW(Ctrl('JCGROGAZTR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCCIT(HtW(Ctrl('JCGROGAZTR').value,'C'),null,e);
return l_bSetResult;
}
}
function JCGROGAZTR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JCGROGAZTR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JCGROGAZTR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JCGROGAZTR'),e);
}
function JCGROGAZTR_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('JCGROGAZTR')),'linkview_JCGROGAZTR','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function UQKLCBCTLH_Valid(e) {
SetActiveField(Ctrl('UQKLCBCTLH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PROVINCIA','C',w_PROVINCIA,HtW(Ctrl('UQKLCBCTLH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PROVINCIA(HtW(Ctrl('UQKLCBCTLH').value,'C'),null,e);
return l_bSetResult;
}
}
function UQKLCBCTLH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UQKLCBCTLH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UQKLCBCTLH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UQKLCBCTLH'),e);
}
function BQSGHFQUHM_Valid(e) {
SetActiveField(Ctrl('BQSGHFQUHM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CAP','C',w_CAP,HtW(Ctrl('BQSGHFQUHM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAP(HtW(Ctrl('BQSGHFQUHM').value,'C'),null,e);
return l_bSetResult;
}
}
function BQSGHFQUHM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BQSGHFQUHM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BQSGHFQUHM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BQSGHFQUHM'),e);
}
function IXWLDAOCFD_Valid(e) {
SetActiveField(Ctrl('IXWLDAOCFD'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODCAB','C',w_CODCAB,HtW(Ctrl('IXWLDAOCFD').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODCAB(HtW(Ctrl('IXWLDAOCFD').value,'C'),null,e);
return l_bSetResult;
}
}
function IXWLDAOCFD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IXWLDAOCFD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IXWLDAOCFD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IXWLDAOCFD'),e);
}
function SJHNBZJAKA_Valid(e) {
SetActiveField(Ctrl('SJHNBZJAKA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DOMICILIO','C',w_DOMICILIO,HtW(Ctrl('SJHNBZJAKA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DOMICILIO(HtW(Ctrl('SJHNBZJAKA').value,'C'),null,e);
return l_bSetResult;
}
}
function SJHNBZJAKA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SJHNBZJAKA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SJHNBZJAKA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SJHNBZJAKA'),e);
}
function IIXRREUEAM_Valid(e) {
SetActiveField(Ctrl('IIXRREUEAM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PAESE','C',w_PAESE,HtW(Ctrl('IIXRREUEAM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PAESE(HtW(Ctrl('IIXRREUEAM').value,'C'),null,e);
return l_bSetResult;
}
}
function IIXRREUEAM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IIXRREUEAM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IIXRREUEAM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IIXRREUEAM'),e);
}
function IIXRREUEAM_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('IIXRREUEAM')),'linkview_IIXRREUEAM','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function SZWCLLEIQY_Valid(e) {
SetActiveField(Ctrl('SZWCLLEIQY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODFISC','C',w_CODFISC,HtW(Ctrl('SZWCLLEIQY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODFISC(HtW(Ctrl('SZWCLLEIQY').value,'C'),null,e);
return l_bSetResult;
}
}
function SZWCLLEIQY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SZWCLLEIQY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SZWCLLEIQY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SZWCLLEIQY'),e);
}
function OIWIANSIOG_Valid(e) {
SetActiveField(Ctrl('OIWIANSIOG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PARTIVA','C',w_PARTIVA,HtW(Ctrl('OIWIANSIOG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PARTIVA(HtW(Ctrl('OIWIANSIOG').value,'C'),null,e);
return l_bSetResult;
}
}
function OIWIANSIOG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OIWIANSIOG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OIWIANSIOG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OIWIANSIOG'),e);
}
function TNUQTSSGFZ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('TNUQTSSGFZ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('TNUQTSSGFZ').value=ApplyPictureToDate(Ctrl('TNUQTSSGFZ').value,TranslatePicture(datePattern),'TNUQTSSGFZ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('TNUQTSSGFZ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('TNUQTSSGFZ');
}
}
}
SetActiveField(Ctrl('TNUQTSSGFZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATANASC','D',w_DATANASC,HtW(Ctrl('TNUQTSSGFZ').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATANASC(HtW(Ctrl('TNUQTSSGFZ').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function TNUQTSSGFZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TNUQTSSGFZ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('TNUQTSSGFZ',w_DATANASC,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('TNUQTSSGFZ');
SetActiveField(Ctrl('TNUQTSSGFZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TNUQTSSGFZ'),e);
}
function LLYIGAMXRH_Valid(e) {
SetActiveField(Ctrl('LLYIGAMXRH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SOTGRUP','C',w_SOTGRUP,HtW(Ctrl('LLYIGAMXRH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SOTGRUP(HtW(Ctrl('LLYIGAMXRH').value,'C'),null,e);
return l_bSetResult;
}
}
function LLYIGAMXRH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LLYIGAMXRH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LLYIGAMXRH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LLYIGAMXRH'),e);
}
function LLYIGAMXRH_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('LLYIGAMXRH')),'linkview_LLYIGAMXRH','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function RVNHQCXNEM_Valid(e) {
SetActiveField(Ctrl('RVNHQCXNEM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RAMOGRUP','C',w_RAMOGRUP,HtW(Ctrl('RVNHQCXNEM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAMOGRUP(HtW(Ctrl('RVNHQCXNEM').value,'C'),null,e);
return l_bSetResult;
}
}
function RVNHQCXNEM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RVNHQCXNEM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RVNHQCXNEM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RVNHQCXNEM'),e);
}
function RVNHQCXNEM_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('RVNHQCXNEM')),'linkview_RVNHQCXNEM','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function ZGNLLSFQHC_Valid(e) {
SetActiveField(Ctrl('ZGNLLSFQHC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SETTSINT','C',w_SETTSINT,HtW(Ctrl('ZGNLLSFQHC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SETTSINT(HtW(Ctrl('ZGNLLSFQHC').value,'C'),null,e);
return l_bSetResult;
}
}
function ZGNLLSFQHC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZGNLLSFQHC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZGNLLSFQHC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZGNLLSFQHC'),e);
}
function ZGNLLSFQHC_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('ZGNLLSFQHC')),'linkview_ZGNLLSFQHC','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function AYYXYNLAUC_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPODOC','C',w_TIPODOC,HtW(getComboValue(Ctrl('AYYXYNLAUC')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPODOC(HtW(getComboValue(Ctrl('AYYXYNLAUC')),'C'),null,e);
return l_bSetResult;
}
}
function AYYXYNLAUC_OnFocus(e) {
SetActiveField(Ctrl('AYYXYNLAUC'),true);
}
function AYYXYNLAUC_OnBlur(e) {
SetActiveField(Ctrl('AYYXYNLAUC'),false);
}
function OREVCZVNVS_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('SESSO','C',w_SESSO,HtW(getComboValue(Ctrl('OREVCZVNVS')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SESSO(HtW(getComboValue(Ctrl('OREVCZVNVS')),'C'),null,e);
return l_bSetResult;
}
}
function OREVCZVNVS_OnFocus(e) {
SetActiveField(Ctrl('OREVCZVNVS'),true);
}
function OREVCZVNVS_OnBlur(e) {
SetActiveField(Ctrl('OREVCZVNVS'),false);
}
function XCNHFVDZMT_Valid(e) {
SetActiveField(Ctrl('XCNHFVDZMT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NUMDOCUM','C',w_NUMDOCUM,HtW(Ctrl('XCNHFVDZMT').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NUMDOCUM(HtW(Ctrl('XCNHFVDZMT').value,'C'),null,e);
return l_bSetResult;
}
}
function XCNHFVDZMT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XCNHFVDZMT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XCNHFVDZMT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XCNHFVDZMT'),e);
}
function ZYURNYDRPU_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('ZYURNYDRPU'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('ZYURNYDRPU').value=ApplyPictureToDate(Ctrl('ZYURNYDRPU').value,TranslatePicture(datePattern),'ZYURNYDRPU');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('ZYURNYDRPU'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('ZYURNYDRPU');
}
}
}
SetActiveField(Ctrl('ZYURNYDRPU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATARILASC','D',w_DATARILASC,HtW(Ctrl('ZYURNYDRPU').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATARILASC(HtW(Ctrl('ZYURNYDRPU').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function ZYURNYDRPU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZYURNYDRPU'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('ZYURNYDRPU',w_DATARILASC,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('ZYURNYDRPU');
SetActiveField(Ctrl('ZYURNYDRPU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZYURNYDRPU'),e);
}
function YYONLOLCBB_Valid(e) {
SetActiveField(Ctrl('YYONLOLCBB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('AUTRILASC','C',w_AUTRILASC,HtW(Ctrl('YYONLOLCBB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_AUTRILASC(HtW(Ctrl('YYONLOLCBB').value,'C'),null,e);
return l_bSetResult;
}
}
function YYONLOLCBB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YYONLOLCBB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YYONLOLCBB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YYONLOLCBB'),e);
}
function PSZTLCSMPB_Valid(e) {
SetActiveField(Ctrl('PSZTLCSMPB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODDIPE','C',w_CODDIPE,HtW(Ctrl('PSZTLCSMPB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODDIPE(HtW(Ctrl('PSZTLCSMPB').value,'C'),null,e);
return l_bSetResult;
}
}
function PSZTLCSMPB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PSZTLCSMPB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PSZTLCSMPB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PSZTLCSMPB'),e);
}
function PSZTLCSMPB_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('PSZTLCSMPB')),'linkview_PSZTLCSMPB','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function COVTIKSDDS_Valid(e) {
SetActiveField(Ctrl('COVTIKSDDS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NOTE','M',w_NOTE,HtW(Ctrl('COVTIKSDDS').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOTE(HtW(Ctrl('COVTIKSDDS').value,'M'),null,e);
return l_bSetResult;
}
}
function COVTIKSDDS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('COVTIKSDDS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('COVTIKSDDS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('COVTIKSDDS'),e);
}
function COVTIKSDDS_MENU_Click() {
toggleContextMenu('COVTIKSDDS_MENU',null,null);
}
function WSAOVXNTFO_Valid(e) {
SetActiveField(Ctrl('WSAOVXNTFO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODORO','C',w_CODORO,HtW(Ctrl('WSAOVXNTFO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODORO(HtW(Ctrl('WSAOVXNTFO').value,'C'),null,e);
return l_bSetResult;
}
}
function WSAOVXNTFO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WSAOVXNTFO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('WSAOVXNTFO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WSAOVXNTFO'),e);
}
function YPYQJILEQY_Valid(e) {
SetActiveField(Ctrl('YPYQJILEQY'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('YPYQJILEQY') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODINTER','C',w_CODINTER,HtW(Ctrl('YPYQJILEQY').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODINTER(HtW(Ctrl('YPYQJILEQY').value,'C'),null,e);
return l_bSetResult;
}
}
function YPYQJILEQY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YPYQJILEQY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YPYQJILEQY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YPYQJILEQY'),e);
}
function MXHAWWCAZX_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('MXHAWWCAZX'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('MXHAWWCAZX').value=ApplyPictureToDate(Ctrl('MXHAWWCAZX').value,TranslatePicture(datePattern),'MXHAWWCAZX');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('MXHAWWCAZX'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('MXHAWWCAZX');
}
}
}
SetActiveField(Ctrl('MXHAWWCAZX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAVALI','D',w_DATAVALI,HtW(Ctrl('MXHAWWCAZX').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAVALI(HtW(Ctrl('MXHAWWCAZX').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function MXHAWWCAZX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MXHAWWCAZX'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('MXHAWWCAZX',w_DATAVALI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('MXHAWWCAZX');
SetActiveField(Ctrl('MXHAWWCAZX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MXHAWWCAZX'),e);
}
function TFMCRMSOGY_Valid(e) {
SetActiveField(Ctrl('TFMCRMSOGY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CFINVIO','C',w_CFINVIO,HtW(Ctrl('TFMCRMSOGY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CFINVIO(HtW(Ctrl('TFMCRMSOGY').value,'C'),null,e);
return l_bSetResult;
}
}
function TFMCRMSOGY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TFMCRMSOGY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TFMCRMSOGY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TFMCRMSOGY'),e);
}
function YUCSUDKWNH_Valid(e) {
SetActiveField(Ctrl('YUCSUDKWNH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CAFINVIO','C',w_CAFINVIO,HtW(Ctrl('YUCSUDKWNH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAFINVIO(HtW(Ctrl('YUCSUDKWNH').value,'C'),null,e);
return l_bSetResult;
}
}
function YUCSUDKWNH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YUCSUDKWNH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YUCSUDKWNH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YUCSUDKWNH'),e);
}
function JSTXCUBOUH_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FILEINVIO','C',w_FILEINVIO,HtW(getComboValue(Ctrl('JSTXCUBOUH')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FILEINVIO(HtW(getComboValue(Ctrl('JSTXCUBOUH')),'C'),null,e);
return l_bSetResult;
}
}
function JSTXCUBOUH_OnFocus(e) {
SetActiveField(Ctrl('JSTXCUBOUH'),true);
}
function JSTXCUBOUH_OnBlur(e) {
SetActiveField(Ctrl('JSTXCUBOUH'),false);
}
function YOVFWZCOBN_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('YOVFWZCOBN'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('YOVFWZCOBN').value=ApplyPictureToDate(Ctrl('YOVFWZCOBN').value,TranslatePicture(datePattern),'YOVFWZCOBN');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('YOVFWZCOBN'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('YOVFWZCOBN');
}
}
}
SetActiveField(Ctrl('YOVFWZCOBN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAINVIO','D',w_DATAINVIO,HtW(Ctrl('YOVFWZCOBN').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAINVIO(HtW(Ctrl('YOVFWZCOBN').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function YOVFWZCOBN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YOVFWZCOBN'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('YOVFWZCOBN',w_DATAINVIO,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('YOVFWZCOBN');
SetActiveField(Ctrl('YOVFWZCOBN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YOVFWZCOBN'),e);
}
function QPIRUTKOVH_Valid(e) {
SetActiveField(Ctrl('QPIRUTKOVH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDSID','C',w_IDSID,HtW(Ctrl('QPIRUTKOVH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDSID(HtW(Ctrl('QPIRUTKOVH').value,'C'),null,e);
return l_bSetResult;
}
}
function QPIRUTKOVH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QPIRUTKOVH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QPIRUTKOVH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QPIRUTKOVH'),e);
}
function ULCBOSJURF_Valid(e) {
SetActiveField(Ctrl('ULCBOSJURF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SIDPASS','C',w_SIDPASS,HtW(Ctrl('ULCBOSJURF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SIDPASS(HtW(Ctrl('ULCBOSJURF').value,'C'),null,e);
return l_bSetResult;
}
}
function ULCBOSJURF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ULCBOSJURF'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('ULCBOSJURF',w_SIDPASS,'C',30,0,'');
SetActiveField(Ctrl('ULCBOSJURF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ULCBOSJURF'),e);
}
function ULCBOSJURF_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("*"));
}
function KHHILRUMHZ_Valid(e) {
SetActiveField(Ctrl('KHHILRUMHZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PATHJAVA','C',w_PATHJAVA,HtW(Ctrl('KHHILRUMHZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PATHJAVA(HtW(Ctrl('KHHILRUMHZ').value,'C'),null,e);
return l_bSetResult;
}
}
function KHHILRUMHZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KHHILRUMHZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KHHILRUMHZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KHHILRUMHZ'),e);
}
function ELBURHNYTV_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOINST','C',w_TIPOINST,HtW(getComboValue(Ctrl('ELBURHNYTV')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOINST(HtW(getComboValue(Ctrl('ELBURHNYTV')),'C'),null,e);
return l_bSetResult;
}
}
function ELBURHNYTV_OnFocus(e) {
SetActiveField(Ctrl('ELBURHNYTV'),true);
}
function ELBURHNYTV_OnBlur(e) {
SetActiveField(Ctrl('ELBURHNYTV'),false);
}
function JYYHNLJDWT_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGSIDAUTO','N',w_FLGSIDAUTO,ChkboxValueAssign(Ctrl('JYYHNLJDWT'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGSIDAUTO(ChkboxValueAssign(Ctrl('JYYHNLJDWT'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function JYYHNLJDWT_OnFocus(e) {
SetActiveField(Ctrl('JYYHNLJDWT'),true);
}
function JYYHNLJDWT_OnBlur(e) {
SetActiveField(Ctrl('JYYHNLJDWT'),false);
}
function LMKKKUVBBI_Click(el) {
ToggleLayerBox(arguments.length>0 && arguments[0].isConnected?arguments[0]:'LMKKKUVBBI',GetLayerID("upload"),'11',false,'YORQOIOBQN_DIV','YORQOIOBQN_HEADER',false)
}
function DFVZKIFMYL_Click(el) {
ToggleLayerBox(arguments.length>0 && arguments[0].isConnected?arguments[0]:'DFVZKIFMYL',GetLayerID("scadenze"),'11',false,'YORQOIOBQN_DIV','YORQOIOBQN_HEADER',false)
}
function FLPFDBFHXV_Valid(e) {
SetActiveField(Ctrl('FLPFDBFHXV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('appocert','C',w_appocert,HtW(Ctrl('FLPFDBFHXV').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_appocert(HtW(Ctrl('FLPFDBFHXV').value,'C'),null,e);
return l_bSetResult;
}
}
function FLPFDBFHXV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FLPFDBFHXV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FLPFDBFHXV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FLPFDBFHXV'),e);
}
function LBMKPTTAXP_Click() {
if (false || WindowConfirm(Translate('11749906472'))) {
AzzSemaforo()
}
}
function LYZAJWZGAM_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOSV','C',w_TIPOSV,HtW(getComboValue(Ctrl('LYZAJWZGAM')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOSV(HtW(getComboValue(Ctrl('LYZAJWZGAM')),'C'),null,e);
return l_bSetResult;
}
}
function LYZAJWZGAM_OnFocus(e) {
SetActiveField(Ctrl('LYZAJWZGAM'),true);
}
function LYZAJWZGAM_OnBlur(e) {
SetActiveField(Ctrl('LYZAJWZGAM'),false);
}
function LAQADJFMRL_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('LAQADJFMRL'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('LAQADJFMRL').value=ApplyPictureToDate(Ctrl('LAQADJFMRL').value,TranslatePicture(datePattern),'LAQADJFMRL');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('LAQADJFMRL'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('LAQADJFMRL');
}
}
}
SetActiveField(Ctrl('LAQADJFMRL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('LIMITE20','D',w_LIMITE20,HtW(Ctrl('LAQADJFMRL').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_LIMITE20(HtW(Ctrl('LAQADJFMRL').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function LAQADJFMRL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LAQADJFMRL'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('LAQADJFMRL',w_LIMITE20,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('LAQADJFMRL');
SetActiveField(Ctrl('LAQADJFMRL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LAQADJFMRL'),e);
}
function LAQADJFMRL_ZOOM_Click() {
LaunchCalendar(Ctrl('LAQADJFMRL'));
}
function ZYHCFDSBFP_Click() {
var l_oWv = InitWvApplet();
l_oWv.setValue('codinter',AsAppletValue(w_CODINTER));
l_oWv.setValue('tipinter',AsAppletValue(w_TIPINTER));
l_oWv.setValue('xragsoc',AsAppletValue(w_RAGSOC));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('codinter,tipinter,xragsoc'));
_modifyandopen('arpg_dlgspecifici'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=600,width=800',false)
}
function FTETLDBHIY_Valid(e) {
SetActiveField(Ctrl('FTETLDBHIY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODVASP','C',w_CODVASP,HtW(Ctrl('FTETLDBHIY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODVASP(HtW(Ctrl('FTETLDBHIY').value,'C'),null,e);
return l_bSetResult;
}
}
function FTETLDBHIY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FTETLDBHIY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FTETLDBHIY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FTETLDBHIY'),e);
}
function CWVJUDEVCT_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('ART1','N',w_ART1,ChkboxValueAssign(Ctrl('CWVJUDEVCT'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ART1(ChkboxValueAssign(Ctrl('CWVJUDEVCT'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function CWVJUDEVCT_OnFocus(e) {
SetActiveField(Ctrl('CWVJUDEVCT'),true);
}
function CWVJUDEVCT_OnBlur(e) {
SetActiveField(Ctrl('CWVJUDEVCT'),false);
}
function FPFLFCPHAL_Valid(e) {
SetActiveField(Ctrl('FPFLFCPHAL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('URLAPPL','C',w_URLAPPL,HtW(Ctrl('FPFLFCPHAL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_URLAPPL(HtW(Ctrl('FPFLFCPHAL').value,'C'),null,e);
return l_bSetResult;
}
}
function FPFLFCPHAL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FPFLFCPHAL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FPFLFCPHAL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FPFLFCPHAL'),e);
}
function EOQVPQLKOP_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGLOG','C',w_FLGLOG,ChkboxValueAssign(Ctrl('EOQVPQLKOP'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGLOG(ChkboxValueAssign(Ctrl('EOQVPQLKOP'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function EOQVPQLKOP_OnFocus(e) {
SetActiveField(Ctrl('EOQVPQLKOP'),true);
}
function EOQVPQLKOP_OnBlur(e) {
SetActiveField(Ctrl('EOQVPQLKOP'),false);
}
function BLWLPTWCFV_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGAOS','C',w_FLGAOS,ChkboxValueAssign(Ctrl('BLWLPTWCFV'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGAOS(ChkboxValueAssign(Ctrl('BLWLPTWCFV'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function BLWLPTWCFV_OnFocus(e) {
SetActiveField(Ctrl('BLWLPTWCFV'),true);
}
function BLWLPTWCFV_OnBlur(e) {
SetActiveField(Ctrl('BLWLPTWCFV'),false);
}
function REBGPUSIPL_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGEAOS','C',w_FLGEAOS,ChkboxValueAssign(Ctrl('REBGPUSIPL'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGEAOS(ChkboxValueAssign(Ctrl('REBGPUSIPL'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function REBGPUSIPL_OnFocus(e) {
SetActiveField(Ctrl('REBGPUSIPL'),true);
}
function REBGPUSIPL_OnBlur(e) {
SetActiveField(Ctrl('REBGPUSIPL'),false);
}
function HKDCUQQHSU_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGCDOC','C',w_FLGCDOC,ChkboxValueAssign(Ctrl('HKDCUQQHSU'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGCDOC(ChkboxValueAssign(Ctrl('HKDCUQQHSU'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function HKDCUQQHSU_OnFocus(e) {
SetActiveField(Ctrl('HKDCUQQHSU'),true);
}
function HKDCUQQHSU_OnBlur(e) {
SetActiveField(Ctrl('HKDCUQQHSU'),false);
}
function CCBVEBVMNW_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGFRAZ','C',w_FLGFRAZ,ChkboxValueAssign(Ctrl('CCBVEBVMNW'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGFRAZ(ChkboxValueAssign(Ctrl('CCBVEBVMNW'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function CCBVEBVMNW_OnFocus(e) {
SetActiveField(Ctrl('CCBVEBVMNW'),true);
}
function CCBVEBVMNW_OnBlur(e) {
SetActiveField(Ctrl('CCBVEBVMNW'),false);
}
function IDROHZZWYH_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGAPERS','C',w_FLGAPERS,HtW(getComboValue(Ctrl('IDROHZZWYH')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGAPERS(HtW(getComboValue(Ctrl('IDROHZZWYH')),'C'),null,e);
return l_bSetResult;
}
}
function IDROHZZWYH_OnFocus(e) {
SetActiveField(Ctrl('IDROHZZWYH'),true);
}
function IDROHZZWYH_OnBlur(e) {
SetActiveField(Ctrl('IDROHZZWYH'),false);
}
function IQOQQQRZAK_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('IQOQQQRZAK'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('IQOQQQRZAK').value=ApplyPictureToDate(Ctrl('IQOQQQRZAK').value,TranslatePicture(datePattern),'IQOQQQRZAK');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('IQOQQQRZAK'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('IQOQQQRZAK');
}
}
}
SetActiveField(Ctrl('IQOQQQRZAK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DTINIATT','D',w_DTINIATT,HtW(Ctrl('IQOQQQRZAK').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DTINIATT(HtW(Ctrl('IQOQQQRZAK').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function IQOQQQRZAK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IQOQQQRZAK'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('IQOQQQRZAK',w_DTINIATT,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('IQOQQQRZAK');
SetActiveField(Ctrl('IQOQQQRZAK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IQOQQQRZAK'),e);
}
function IQOQQQRZAK_ZOOM_Click() {
LaunchCalendar(Ctrl('IQOQQQRZAK'));
}
function ZPSOMDIBXB_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGTIPIMP','C',w_FLGTIPIMP,HtW(getRadioValue(Ctrl('ZPSOMDIBXB')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGTIPIMP(HtW(getRadioValue(Ctrl('ZPSOMDIBXB')),'C'),null,e);
return l_bSetResult;
}
}
function PIGFPYZMIR_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGSTPCON','C',w_FLGSTPCON,ChkboxValueAssign(Ctrl('PIGFPYZMIR'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGSTPCON(ChkboxValueAssign(Ctrl('PIGFPYZMIR'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function PIGFPYZMIR_OnFocus(e) {
SetActiveField(Ctrl('PIGFPYZMIR'),true);
}
function PIGFPYZMIR_OnBlur(e) {
SetActiveField(Ctrl('PIGFPYZMIR'),false);
}
function DUFIQNBDKW_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGIMPAGE','C',w_FLGIMPAGE,HtW(getComboValue(Ctrl('DUFIQNBDKW')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGIMPAGE(HtW(getComboValue(Ctrl('DUFIQNBDKW')),'C'),null,e);
return l_bSetResult;
}
}
function DUFIQNBDKW_OnFocus(e) {
SetActiveField(Ctrl('DUFIQNBDKW'),true);
}
function DUFIQNBDKW_OnBlur(e) {
SetActiveField(Ctrl('DUFIQNBDKW'),false);
}
function LOYILZBSVI_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGWU','C',w_FLGWU,ChkboxValueAssign(Ctrl('LOYILZBSVI'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGWU(ChkboxValueAssign(Ctrl('LOYILZBSVI'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function LOYILZBSVI_OnFocus(e) {
SetActiveField(Ctrl('LOYILZBSVI'),true);
}
function LOYILZBSVI_OnBlur(e) {
SetActiveField(Ctrl('LOYILZBSVI'),false);
}
function YJCSSLPJKG_Valid(e) {
SetActiveField(Ctrl('YJCSSLPJKG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMPINTOPE','N',w_IMPINTOPE,HtW(Ctrl('YJCSSLPJKG').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMPINTOPE(HtW(Ctrl('YJCSSLPJKG').value,'N'),null,e);
return l_bSetResult;
}
}
function YJCSSLPJKG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YJCSSLPJKG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YJCSSLPJKG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YJCSSLPJKG'),e);
}
function PXNLADGGBR_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGOPEXTR','C',w_FLGOPEXTR,ChkboxValueAssign(Ctrl('PXNLADGGBR'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGOPEXTR(ChkboxValueAssign(Ctrl('PXNLADGGBR'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function PXNLADGGBR_OnFocus(e) {
SetActiveField(Ctrl('PXNLADGGBR'),true);
}
function PXNLADGGBR_OnBlur(e) {
SetActiveField(Ctrl('PXNLADGGBR'),false);
}
function OSHAMNPXFT_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGRAPCLI','C',w_FLGRAPCLI,ChkboxValueAssign(Ctrl('OSHAMNPXFT'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGRAPCLI(ChkboxValueAssign(Ctrl('OSHAMNPXFT'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function OSHAMNPXFT_OnFocus(e) {
SetActiveField(Ctrl('OSHAMNPXFT'),true);
}
function OSHAMNPXFT_OnBlur(e) {
SetActiveField(Ctrl('OSHAMNPXFT'),false);
}
function ZHYZMPHABC_Click() {
if (false || WindowConfirm(Translate('859061417'))) {
CreaDIR()
}
}
function UETNARUDOE_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('NOCODFISC','N',w_NOCODFISC,ChkboxValueAssign(Ctrl('UETNARUDOE'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOCODFISC(ChkboxValueAssign(Ctrl('UETNARUDOE'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function UETNARUDOE_OnFocus(e) {
SetActiveField(Ctrl('UETNARUDOE'),true);
}
function UETNARUDOE_OnBlur(e) {
SetActiveField(Ctrl('UETNARUDOE'),false);
}
function UHGVOKNSVL_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGCHK','C',w_FLGCHK,ChkboxValueAssign(Ctrl('UHGVOKNSVL'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGCHK(ChkboxValueAssign(Ctrl('UHGVOKNSVL'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function UHGVOKNSVL_OnFocus(e) {
SetActiveField(Ctrl('UHGVOKNSVL'),true);
}
function UHGVOKNSVL_OnBlur(e) {
SetActiveField(Ctrl('UHGVOKNSVL'),false);
}
function NLUIAOSQKM_Valid(e) {
SetActiveField(Ctrl('NLUIAOSQKM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PWDSER','C',w_PWDSER,HtW(Ctrl('NLUIAOSQKM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PWDSER(HtW(Ctrl('NLUIAOSQKM').value,'C'),null,e);
return l_bSetResult;
}
}
function NLUIAOSQKM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NLUIAOSQKM'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('NLUIAOSQKM'))) {
SPBOUILib.WtH('NLUIAOSQKM',w_PWDSER,'C',10,0,'');
}
SetActiveField(Ctrl('NLUIAOSQKM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NLUIAOSQKM'),e);
}
function NLUIAOSQKM_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("*"));
}
function XDDITMPJIZ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('SOSPMAF','C',w_SOSPMAF,HtW(getComboValue(Ctrl('XDDITMPJIZ')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SOSPMAF(HtW(getComboValue(Ctrl('XDDITMPJIZ')),'C'),null,e);
return l_bSetResult;
}
}
function XDDITMPJIZ_OnFocus(e) {
SetActiveField(Ctrl('XDDITMPJIZ'),true);
}
function XDDITMPJIZ_OnBlur(e) {
SetActiveField(Ctrl('XDDITMPJIZ'),false);
}
function LUPNVRRLHF_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGRITORNO','C',w_FLGRITORNO,ChkboxValueAssign(Ctrl('LUPNVRRLHF'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGRITORNO(ChkboxValueAssign(Ctrl('LUPNVRRLHF'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function LUPNVRRLHF_OnFocus(e) {
SetActiveField(Ctrl('LUPNVRRLHF'),true);
}
function LUPNVRRLHF_OnBlur(e) {
SetActiveField(Ctrl('LUPNVRRLHF'),false);
}
function HFADCPKPNB_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGCREAAGE','C',w_FLGCREAAGE,ChkboxValueAssign(Ctrl('HFADCPKPNB'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGCREAAGE(ChkboxValueAssign(Ctrl('HFADCPKPNB'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function HFADCPKPNB_OnFocus(e) {
SetActiveField(Ctrl('HFADCPKPNB'),true);
}
function HFADCPKPNB_OnBlur(e) {
SetActiveField(Ctrl('HFADCPKPNB'),false);
}
function ASIWFAENLM_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('ASIWFAENLM'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('ASIWFAENLM').value=ApplyPictureToDate(Ctrl('ASIWFAENLM').value,TranslatePicture(datePattern),'ASIWFAENLM');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('ASIWFAENLM'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('ASIWFAENLM');
}
}
}
SetActiveField(Ctrl('ASIWFAENLM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DTTITAGE','D',w_DTTITAGE,HtW(Ctrl('ASIWFAENLM').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DTTITAGE(HtW(Ctrl('ASIWFAENLM').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function ASIWFAENLM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ASIWFAENLM'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('ASIWFAENLM',w_DTTITAGE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('ASIWFAENLM');
SetActiveField(Ctrl('ASIWFAENLM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ASIWFAENLM'),e);
}
function ASIWFAENLM_ZOOM_Click() {
LaunchCalendar(Ctrl('ASIWFAENLM'));
}
function IOYUNQJDKZ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('IOYUNQJDKZ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('IOYUNQJDKZ').value=ApplyPictureToDate(Ctrl('IOYUNQJDKZ').value,TranslatePicture(datePattern),'IOYUNQJDKZ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('IOYUNQJDKZ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('IOYUNQJDKZ');
}
}
}
SetActiveField(Ctrl('IOYUNQJDKZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SCADSALDI','D',w_SCADSALDI,HtW(Ctrl('IOYUNQJDKZ').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SCADSALDI(HtW(Ctrl('IOYUNQJDKZ').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function IOYUNQJDKZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IOYUNQJDKZ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('IOYUNQJDKZ',w_SCADSALDI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('IOYUNQJDKZ');
SetActiveField(Ctrl('IOYUNQJDKZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IOYUNQJDKZ'),e);
}
function IOYUNQJDKZ_ZOOM_Click() {
LaunchCalendar(Ctrl('IOYUNQJDKZ'));
}
function LSBZHECNKO_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGIPMT','C',w_FLGIPMT,ChkboxValueAssign(Ctrl('LSBZHECNKO'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGIPMT(ChkboxValueAssign(Ctrl('LSBZHECNKO'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function LSBZHECNKO_OnFocus(e) {
SetActiveField(Ctrl('LSBZHECNKO'),true);
}
function LSBZHECNKO_OnBlur(e) {
SetActiveField(Ctrl('LSBZHECNKO'),false);
}
function FKIIMPSJSB_Valid(e) {
SetActiveField(Ctrl('FKIIMPSJSB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('LIMITEFRZ','N',w_LIMITEFRZ,HtW(Ctrl('FKIIMPSJSB').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_LIMITEFRZ(HtW(Ctrl('FKIIMPSJSB').value,'N'),null,e);
return l_bSetResult;
}
}
function FKIIMPSJSB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FKIIMPSJSB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FKIIMPSJSB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FKIIMPSJSB'),e);
}
function EQCSRKQZVC_Valid(e) {
SetActiveField(Ctrl('EQCSRKQZVC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DBPROT','C',w_DBPROT,HtW(Ctrl('EQCSRKQZVC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DBPROT(HtW(Ctrl('EQCSRKQZVC').value,'C'),null,e);
return l_bSetResult;
}
}
function EQCSRKQZVC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EQCSRKQZVC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('EQCSRKQZVC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EQCSRKQZVC'),e);
}
function KFQWZVCJIW_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('OAMTPDOC','N',w_OAMTPDOC,ChkboxValueAssign(Ctrl('KFQWZVCJIW'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_OAMTPDOC(ChkboxValueAssign(Ctrl('KFQWZVCJIW'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function KFQWZVCJIW_OnFocus(e) {
SetActiveField(Ctrl('KFQWZVCJIW'),true);
}
function KFQWZVCJIW_OnBlur(e) {
SetActiveField(Ctrl('KFQWZVCJIW'),false);
}
function LGZDRUUSXZ_Valid(e) {
SetActiveField(Ctrl('LGZDRUUSXZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DAYSIMPORT','N',w_DAYSIMPORT,HtW(Ctrl('LGZDRUUSXZ').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DAYSIMPORT(HtW(Ctrl('LGZDRUUSXZ').value,'N'),null,e);
return l_bSetResult;
}
}
function LGZDRUUSXZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LGZDRUUSXZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LGZDRUUSXZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LGZDRUUSXZ'),e);
}
function FQKHRITNGP_Valid(e) {
SetActiveField(Ctrl('FQKHRITNGP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DAYSIMPCMB','N',w_DAYSIMPCMB,HtW(Ctrl('FQKHRITNGP').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DAYSIMPCMB(HtW(Ctrl('FQKHRITNGP').value,'N'),null,e);
return l_bSetResult;
}
}
function FQKHRITNGP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FQKHRITNGP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FQKHRITNGP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FQKHRITNGP'),e);
}
function SIZHWNZUOT_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGAWUPOS','C',w_FLGAWUPOS,ChkboxValueAssign(Ctrl('SIZHWNZUOT'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGAWUPOS(ChkboxValueAssign(Ctrl('SIZHWNZUOT'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function SIZHWNZUOT_OnFocus(e) {
SetActiveField(Ctrl('SIZHWNZUOT'),true);
}
function SIZHWNZUOT_OnBlur(e) {
SetActiveField(Ctrl('SIZHWNZUOT'),false);
}
function QBHBPWJMOW_Valid(e) {
SetActiveField(Ctrl('QBHBPWJMOW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('WUGIOSCA','N',w_WUGIOSCA,HtW(Ctrl('QBHBPWJMOW').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_WUGIOSCA(HtW(Ctrl('QBHBPWJMOW').value,'N'),null,e);
return l_bSetResult;
}
}
function QBHBPWJMOW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QBHBPWJMOW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QBHBPWJMOW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QBHBPWJMOW'),e);
}
function HXPRRNXNJO_Valid(e) {
SetActiveField(Ctrl('HXPRRNXNJO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('WUGGALERT','N',w_WUGGALERT,HtW(Ctrl('HXPRRNXNJO').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_WUGGALERT(HtW(Ctrl('HXPRRNXNJO').value,'N'),null,e);
return l_bSetResult;
}
}
function HXPRRNXNJO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HXPRRNXNJO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HXPRRNXNJO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HXPRRNXNJO'),e);
}
function AAIARGXIIW_Valid(e) {
SetActiveField(Ctrl('AAIARGXIIW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RICEVUTE','C',w_RICEVUTE,HtW(Ctrl('AAIARGXIIW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RICEVUTE(HtW(Ctrl('AAIARGXIIW').value,'C'),null,e);
return l_bSetResult;
}
}
function AAIARGXIIW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AAIARGXIIW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('AAIARGXIIW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AAIARGXIIW'),e);
}
function PLWDFUBDIP_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('OGGI3I4','C',w_OGGI3I4,ChkboxValueAssign(Ctrl('PLWDFUBDIP'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_OGGI3I4(ChkboxValueAssign(Ctrl('PLWDFUBDIP'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function PLWDFUBDIP_OnFocus(e) {
SetActiveField(Ctrl('PLWDFUBDIP'),true);
}
function PLWDFUBDIP_OnBlur(e) {
SetActiveField(Ctrl('PLWDFUBDIP'),false);
}
function PDLIXDKBWK_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('CGOTGDEFMUL','C',w_CGOTGDEFMUL,ChkboxValueAssign(Ctrl('PDLIXDKBWK'),'S','N','C',3,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CGOTGDEFMUL(ChkboxValueAssign(Ctrl('PDLIXDKBWK'),'S','N','C',3,0,''),null,e);
return l_bSetResult;
}
}
function PDLIXDKBWK_OnFocus(e) {
SetActiveField(Ctrl('PDLIXDKBWK'),true);
}
function PDLIXDKBWK_OnBlur(e) {
SetActiveField(Ctrl('PDLIXDKBWK'),false);
}
function PVOEPQLJPS_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('AUTOSARA','C',w_AUTOSARA,ChkboxValueAssign(Ctrl('PVOEPQLJPS'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_AUTOSARA(ChkboxValueAssign(Ctrl('PVOEPQLJPS'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function PVOEPQLJPS_OnFocus(e) {
SetActiveField(Ctrl('PVOEPQLJPS'),true);
}
function PVOEPQLJPS_OnBlur(e) {
SetActiveField(Ctrl('PVOEPQLJPS'),false);
}
function FCXDRDCINI_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGCGOOTP','C',w_FLGCGOOTP,ChkboxValueAssign(Ctrl('FCXDRDCINI'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGCGOOTP(ChkboxValueAssign(Ctrl('FCXDRDCINI'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function FCXDRDCINI_OnFocus(e) {
SetActiveField(Ctrl('FCXDRDCINI'),true);
}
function FCXDRDCINI_OnBlur(e) {
SetActiveField(Ctrl('FCXDRDCINI'),false);
}
function RBAZEQPPJI_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('ITFLGPEP','C',w_ITFLGPEP,ChkboxValueAssign(Ctrl('RBAZEQPPJI'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ITFLGPEP(ChkboxValueAssign(Ctrl('RBAZEQPPJI'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function RBAZEQPPJI_OnFocus(e) {
SetActiveField(Ctrl('RBAZEQPPJI'),true);
}
function RBAZEQPPJI_OnBlur(e) {
SetActiveField(Ctrl('RBAZEQPPJI'),false);
}
function VDJMSNZEEV_Valid(e) {
SetActiveField(Ctrl('VDJMSNZEEV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ITPWDPEP','C',w_ITPWDPEP,HtW(Ctrl('VDJMSNZEEV').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ITPWDPEP(HtW(Ctrl('VDJMSNZEEV').value,'C'),null,e);
return l_bSetResult;
}
}
function VDJMSNZEEV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VDJMSNZEEV'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('VDJMSNZEEV',w_ITPWDPEP,'C',50,0,'');
SetActiveField(Ctrl('VDJMSNZEEV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VDJMSNZEEV'),e);
}
function VDJMSNZEEV_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("*"));
}
function LNADTKDHIZ_Valid(e) {
SetActiveField(Ctrl('LNADTKDHIZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ITUSRPEP','C',w_ITUSRPEP,HtW(Ctrl('LNADTKDHIZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ITUSRPEP(HtW(Ctrl('LNADTKDHIZ').value,'C'),null,e);
return l_bSetResult;
}
}
function LNADTKDHIZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LNADTKDHIZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LNADTKDHIZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LNADTKDHIZ'),e);
}
function XMAVZMPWRZ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGAGGFAM','C',w_FLGAGGFAM,ChkboxValueAssign(Ctrl('XMAVZMPWRZ'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGAGGFAM(ChkboxValueAssign(Ctrl('XMAVZMPWRZ'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function XMAVZMPWRZ_OnFocus(e) {
SetActiveField(Ctrl('XMAVZMPWRZ'),true);
}
function XMAVZMPWRZ_OnBlur(e) {
SetActiveField(Ctrl('XMAVZMPWRZ'),false);
}
function BZARULYZUH_Valid(e) {
SetActiveField(Ctrl('BZARULYZUH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ALTSRVMAIL','C',w_ALTSRVMAIL,HtW(Ctrl('BZARULYZUH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ALTSRVMAIL(HtW(Ctrl('BZARULYZUH').value,'C'),null,e);
return l_bSetResult;
}
}
function BZARULYZUH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BZARULYZUH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BZARULYZUH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BZARULYZUH'),e);
}
function CWFIJJMSTR_Valid(e) {
SetActiveField(Ctrl('CWFIJJMSTR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ALTPRTMAIL','C',w_ALTPRTMAIL,HtW(Ctrl('CWFIJJMSTR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ALTPRTMAIL(HtW(Ctrl('CWFIJJMSTR').value,'C'),null,e);
return l_bSetResult;
}
}
function CWFIJJMSTR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CWFIJJMSTR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CWFIJJMSTR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CWFIJJMSTR'),e);
}
function YPHGLIUDNW_Valid(e) {
SetActiveField(Ctrl('YPHGLIUDNW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ALTEMLMAIL','C',w_ALTEMLMAIL,HtW(Ctrl('YPHGLIUDNW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ALTEMLMAIL(HtW(Ctrl('YPHGLIUDNW').value,'C'),null,e);
return l_bSetResult;
}
}
function YPHGLIUDNW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YPHGLIUDNW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YPHGLIUDNW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YPHGLIUDNW'),e);
}
function HSAOKMBAUY_Valid(e) {
SetActiveField(Ctrl('HSAOKMBAUY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ALTUSRMAIL','C',w_ALTUSRMAIL,HtW(Ctrl('HSAOKMBAUY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ALTUSRMAIL(HtW(Ctrl('HSAOKMBAUY').value,'C'),null,e);
return l_bSetResult;
}
}
function HSAOKMBAUY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HSAOKMBAUY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HSAOKMBAUY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HSAOKMBAUY'),e);
}
function LGVTLPSUGS_Valid(e) {
SetActiveField(Ctrl('LGVTLPSUGS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ALTPWDMAIL','C',w_ALTPWDMAIL,HtW(Ctrl('LGVTLPSUGS').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ALTPWDMAIL(HtW(Ctrl('LGVTLPSUGS').value,'C'),null,e);
return l_bSetResult;
}
}
function LGVTLPSUGS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LGVTLPSUGS'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('LGVTLPSUGS',w_ALTPWDMAIL,'C',80,0,'');
SetActiveField(Ctrl('LGVTLPSUGS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LGVTLPSUGS'),e);
}
function LGVTLPSUGS_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict('*'));
}
function KPSLGRAIIO_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('ALTSSLEMAIL','C',w_ALTSSLEMAIL,ChkboxValueAssign(Ctrl('KPSLGRAIIO'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ALTSSLEMAIL(ChkboxValueAssign(Ctrl('KPSLGRAIIO'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function KPSLGRAIIO_OnFocus(e) {
SetActiveField(Ctrl('KPSLGRAIIO'),true);
}
function KPSLGRAIIO_OnBlur(e) {
SetActiveField(Ctrl('KPSLGRAIIO'),false);
}
function YRAEGOUXRJ_Valid(e) {
SetActiveField(Ctrl('YRAEGOUXRJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PATHIMPORT','C',w_PATHIMPORT,HtW(Ctrl('YRAEGOUXRJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PATHIMPORT(HtW(Ctrl('YRAEGOUXRJ').value,'C'),null,e);
return l_bSetResult;
}
}
function YRAEGOUXRJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YRAEGOUXRJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YRAEGOUXRJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YRAEGOUXRJ'),e);
}
function OHRBGBCDVG_Valid(e) {
SetActiveField(Ctrl('OHRBGBCDVG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESTEMAIL','C',w_DESTEMAIL,HtW(Ctrl('OHRBGBCDVG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESTEMAIL(HtW(Ctrl('OHRBGBCDVG').value,'C'),null,e);
return l_bSetResult;
}
}
function OHRBGBCDVG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OHRBGBCDVG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OHRBGBCDVG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OHRBGBCDVG'),e);
}
function KDJLQEMEDV_Valid(e) {
SetActiveField(Ctrl('KDJLQEMEDV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('COGNOME','C',w_COGNOME,HtW(Ctrl('KDJLQEMEDV').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_COGNOME(HtW(Ctrl('KDJLQEMEDV').value,'C'),null,e);
return l_bSetResult;
}
}
function KDJLQEMEDV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KDJLQEMEDV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KDJLQEMEDV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KDJLQEMEDV'),e);
}
function VTFLIHXHLG_Valid(e) {
SetActiveField(Ctrl('VTFLIHXHLG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NOME','C',w_NOME,HtW(Ctrl('VTFLIHXHLG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOME(HtW(Ctrl('VTFLIHXHLG').value,'C'),null,e);
return l_bSetResult;
}
}
function VTFLIHXHLG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VTFLIHXHLG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VTFLIHXHLG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VTFLIHXHLG'),e);
}
function SIJUUSKFLV_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('SESSO','C',w_SESSO,HtW(getComboValue(Ctrl('SIJUUSKFLV')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SESSO(HtW(getComboValue(Ctrl('SIJUUSKFLV')),'C'),null,e);
return l_bSetResult;
}
}
function SIJUUSKFLV_OnFocus(e) {
SetActiveField(Ctrl('SIJUUSKFLV'),true);
}
function SIJUUSKFLV_OnBlur(e) {
SetActiveField(Ctrl('SIJUUSKFLV'),false);
}
function XCZARGUGTG_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('XCZARGUGTG'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('XCZARGUGTG').value=ApplyPictureToDate(Ctrl('XCZARGUGTG').value,TranslatePicture(datePattern),'XCZARGUGTG');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('XCZARGUGTG'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('XCZARGUGTG');
}
}
}
SetActiveField(Ctrl('XCZARGUGTG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DNASC','D',w_DNASC,HtW(Ctrl('XCZARGUGTG').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DNASC(HtW(Ctrl('XCZARGUGTG').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function XCZARGUGTG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XCZARGUGTG'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('XCZARGUGTG',w_DNASC,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('XCZARGUGTG');
SetActiveField(Ctrl('XCZARGUGTG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XCZARGUGTG'),e);
}
function XCZARGUGTG_ZOOM_Click() {
LaunchCalendar(Ctrl('XCZARGUGTG'));
}
function PZGXGIZQWY_Valid(e) {
SetActiveField(Ctrl('PZGXGIZQWY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCCIT','C',w_DESCCIT,HtW(Ctrl('PZGXGIZQWY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCCIT(HtW(Ctrl('PZGXGIZQWY').value,'C'),null,e);
return l_bSetResult;
}
}
function PZGXGIZQWY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PZGXGIZQWY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PZGXGIZQWY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PZGXGIZQWY'),e);
}
function PZGXGIZQWY_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('PZGXGIZQWY')),'linkview_PZGXGIZQWY','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function WQWXGOLVXC_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('CITTADINA','C',w_CITTADINA,HtW(getComboValue(Ctrl('WQWXGOLVXC')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CITTADINA(HtW(getComboValue(Ctrl('WQWXGOLVXC')),'C'),null,e);
return l_bSetResult;
}
}
function WQWXGOLVXC_OnFocus(e) {
SetActiveField(Ctrl('WQWXGOLVXC'),true);
}
function WQWXGOLVXC_OnBlur(e) {
SetActiveField(Ctrl('WQWXGOLVXC'),false);
}
function DUROREWBNG_Valid(e) {
SetActiveField(Ctrl('DUROREWBNG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NASCOMUN','C',w_NASCOMUN,HtW(Ctrl('DUROREWBNG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NASCOMUN(HtW(Ctrl('DUROREWBNG').value,'C'),null,e);
return l_bSetResult;
}
}
function DUROREWBNG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DUROREWBNG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DUROREWBNG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DUROREWBNG'),e);
}
function DUROREWBNG_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('DUROREWBNG')),'linkview_DUROREWBNG','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function ZTUIXEONYI_Valid(e) {
SetActiveField(Ctrl('ZTUIXEONYI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NASSTATO','C',w_NASSTATO,HtW(Ctrl('ZTUIXEONYI').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NASSTATO(HtW(Ctrl('ZTUIXEONYI').value,'C'),null,e);
return l_bSetResult;
}
}
function ZTUIXEONYI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZTUIXEONYI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZTUIXEONYI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZTUIXEONYI'),e);
}
function ZTUIXEONYI_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('ZTUIXEONYI')),'linkview_ZTUIXEONYI','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function KSRCRPEMFT_Valid(e) {
SetActiveField(Ctrl('KSRCRPEMFT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PRNASC','C',w_PRNASC,HtW(Ctrl('KSRCRPEMFT').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PRNASC(HtW(Ctrl('KSRCRPEMFT').value,'C'),null,e);
return l_bSetResult;
}
}
function KSRCRPEMFT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KSRCRPEMFT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KSRCRPEMFT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KSRCRPEMFT'),e);
}
function IYKMLTUWXM_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('SOGCOM','C',w_SOGCOM,HtW(getComboValue(Ctrl('IYKMLTUWXM')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SOGCOM(HtW(getComboValue(Ctrl('IYKMLTUWXM')),'C'),null,e);
return l_bSetResult;
}
}
function IYKMLTUWXM_OnFocus(e) {
SetActiveField(Ctrl('IYKMLTUWXM'),true);
}
function IYKMLTUWXM_OnBlur(e) {
SetActiveField(Ctrl('IYKMLTUWXM'),false);
}
function KYNLIGXUVC_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPODOC','C',w_TIPODOC,HtW(getComboValue(Ctrl('KYNLIGXUVC')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPODOC(HtW(getComboValue(Ctrl('KYNLIGXUVC')),'C'),null,e);
return l_bSetResult;
}
}
function KYNLIGXUVC_OnFocus(e) {
SetActiveField(Ctrl('KYNLIGXUVC'),true);
}
function KYNLIGXUVC_OnBlur(e) {
SetActiveField(Ctrl('KYNLIGXUVC'),false);
}
function IAXBQWHGLM_Valid(e) {
SetActiveField(Ctrl('IAXBQWHGLM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('BPCODPAT','C',w_BPCODPAT,HtW(Ctrl('IAXBQWHGLM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_BPCODPAT(HtW(Ctrl('IAXBQWHGLM').value,'C'),null,e);
return l_bSetResult;
}
}
function IAXBQWHGLM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IAXBQWHGLM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IAXBQWHGLM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IAXBQWHGLM'),e);
}
function PBQXUDZUOZ_Valid(e) {
SetActiveField(Ctrl('PBQXUDZUOZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('BPENTSEG','C',w_BPENTSEG,HtW(Ctrl('PBQXUDZUOZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_BPENTSEG(HtW(Ctrl('PBQXUDZUOZ').value,'C'),null,e);
return l_bSetResult;
}
}
function PBQXUDZUOZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PBQXUDZUOZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PBQXUDZUOZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PBQXUDZUOZ'),e);
}
function UBNVJIYFWU_Valid(e) {
SetActiveField(Ctrl('UBNVJIYFWU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('BPCOGSEG','C',w_BPCOGSEG,HtW(Ctrl('UBNVJIYFWU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_BPCOGSEG(HtW(Ctrl('UBNVJIYFWU').value,'C'),null,e);
return l_bSetResult;
}
}
function UBNVJIYFWU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UBNVJIYFWU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UBNVJIYFWU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UBNVJIYFWU'),e);
}
function PELELICXZD_Valid(e) {
SetActiveField(Ctrl('PELELICXZD'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('BPNOMSEG','C',w_BPNOMSEG,HtW(Ctrl('PELELICXZD').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_BPNOMSEG(HtW(Ctrl('PELELICXZD').value,'C'),null,e);
return l_bSetResult;
}
}
function PELELICXZD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PELELICXZD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PELELICXZD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PELELICXZD'),e);
}
function DZVDAZOPWP_Valid(e) {
SetActiveField(Ctrl('DZVDAZOPWP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('BPTELSEG','C',w_BPTELSEG,HtW(Ctrl('DZVDAZOPWP').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_BPTELSEG(HtW(Ctrl('DZVDAZOPWP').value,'C'),null,e);
return l_bSetResult;
}
}
function DZVDAZOPWP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DZVDAZOPWP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DZVDAZOPWP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DZVDAZOPWP'),e);
}
function HRZVDXDSOJ_Valid(e) {
SetActiveField(Ctrl('HRZVDXDSOJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('BPEMLSEG','C',w_BPEMLSEG,HtW(Ctrl('HRZVDXDSOJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_BPEMLSEG(HtW(Ctrl('HRZVDXDSOJ').value,'C'),null,e);
return l_bSetResult;
}
}
function HRZVDXDSOJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HRZVDXDSOJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HRZVDXDSOJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HRZVDXDSOJ'),e);
}
function TFDNMJLIWF_Valid(e) {
SetActiveField(Ctrl('TFDNMJLIWF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ABI','C',w_ABI,HtW(Ctrl('TFDNMJLIWF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ABI(HtW(Ctrl('TFDNMJLIWF').value,'C'),null,e);
return l_bSetResult;
}
}
function TFDNMJLIWF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TFDNMJLIWF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TFDNMJLIWF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TFDNMJLIWF'),e);
}
function WRRSZRBPCI_Valid(e) {
SetActiveField(Ctrl('WRRSZRBPCI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CAB','C',w_CAB,HtW(Ctrl('WRRSZRBPCI').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAB(HtW(Ctrl('WRRSZRBPCI').value,'C'),null,e);
return l_bSetResult;
}
}
function WRRSZRBPCI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WRRSZRBPCI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('WRRSZRBPCI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WRRSZRBPCI'),e);
}
function PUFIBBLEMQ_Valid(e) {
SetActiveField(Ctrl('PUFIBBLEMQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('GGWARNPRV','N',w_GGWARNPRV,HtW(Ctrl('PUFIBBLEMQ').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_GGWARNPRV(HtW(Ctrl('PUFIBBLEMQ').value,'N'),null,e);
return l_bSetResult;
}
}
function PUFIBBLEMQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PUFIBBLEMQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PUFIBBLEMQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PUFIBBLEMQ'),e);
}
function MBMIGFSBXO_Valid(e) {
SetActiveField(Ctrl('MBMIGFSBXO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('GGWARNAUI','N',w_GGWARNAUI,HtW(Ctrl('MBMIGFSBXO').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_GGWARNAUI(HtW(Ctrl('MBMIGFSBXO').value,'N'),null,e);
return l_bSetResult;
}
}
function MBMIGFSBXO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MBMIGFSBXO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MBMIGFSBXO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MBMIGFSBXO'),e);
}
function XUNVKFSSZL_Valid(e) {
SetActiveField(Ctrl('XUNVKFSSZL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SOGLIAMAX','N',w_SOGLIAMAX,HtW(Ctrl('XUNVKFSSZL').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SOGLIAMAX(HtW(Ctrl('XUNVKFSSZL').value,'N'),null,e);
return l_bSetResult;
}
}
function XUNVKFSSZL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XUNVKFSSZL'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('XUNVKFSSZL',w_SOGLIAMAX,'N',12,2,'999999999.99');
SetActiveField(Ctrl('XUNVKFSSZL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XUNVKFSSZL'),e);
}
function XUNVKFSSZL_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999.99"));
}
function CMBYXKAJCS_Valid(e) {
SetActiveField(Ctrl('CMBYXKAJCS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODVASP','C',w_CODVASP,HtW(Ctrl('CMBYXKAJCS').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODVASP(HtW(Ctrl('CMBYXKAJCS').value,'C'),null,e);
return l_bSetResult;
}
}
function CMBYXKAJCS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CMBYXKAJCS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CMBYXKAJCS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CMBYXKAJCS'),e);
}
function CNQFAHXNUY_Valid(e) {
SetActiveField(Ctrl('CNQFAHXNUY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDOAM','C',w_IDOAM,HtW(Ctrl('CNQFAHXNUY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDOAM(HtW(Ctrl('CNQFAHXNUY').value,'C'),null,e);
return l_bSetResult;
}
}
function CNQFAHXNUY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CNQFAHXNUY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CNQFAHXNUY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CNQFAHXNUY'),e);
}
function PUYJXGBDJI_Valid(e) {
SetActiveField(Ctrl('PUYJXGBDJI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDOAMR','C',w_IDOAMR,HtW(Ctrl('PUYJXGBDJI').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDOAMR(HtW(Ctrl('PUYJXGBDJI').value,'C'),null,e);
return l_bSetResult;
}
}
function PUYJXGBDJI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PUYJXGBDJI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PUYJXGBDJI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PUYJXGBDJI'),e);
}
function DNCMAAILTV_Valid(e) {
SetActiveField(Ctrl('DNCMAAILTV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SKT_SERVER','C',w_SKT_SERVER,HtW(Ctrl('DNCMAAILTV').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SKT_SERVER(HtW(Ctrl('DNCMAAILTV').value,'C'),null,e);
return l_bSetResult;
}
}
function DNCMAAILTV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DNCMAAILTV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DNCMAAILTV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DNCMAAILTV'),e);
}
function UMEMYFCVBI_Valid(e) {
SetActiveField(Ctrl('UMEMYFCVBI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SKT_PORT','N',w_SKT_PORT,HtW(Ctrl('UMEMYFCVBI').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SKT_PORT(HtW(Ctrl('UMEMYFCVBI').value,'N'),null,e);
return l_bSetResult;
}
}
function UMEMYFCVBI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UMEMYFCVBI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UMEMYFCVBI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UMEMYFCVBI'),e);
}
function ZFUOSYKTGZ_Valid(e) {
SetActiveField(Ctrl('ZFUOSYKTGZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SKT_PATHS','C',w_SKT_PATHS,HtW(Ctrl('ZFUOSYKTGZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SKT_PATHS(HtW(Ctrl('ZFUOSYKTGZ').value,'C'),null,e);
return l_bSetResult;
}
}
function ZFUOSYKTGZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZFUOSYKTGZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZFUOSYKTGZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZFUOSYKTGZ'),e);
}
function ECARBEFMBC_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('SKT_MODET','C',w_SKT_MODET,HtW(getComboValue(Ctrl('ECARBEFMBC')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SKT_MODET(HtW(getComboValue(Ctrl('ECARBEFMBC')),'C'),null,e);
return l_bSetResult;
}
}
function ECARBEFMBC_OnFocus(e) {
SetActiveField(Ctrl('ECARBEFMBC'),true);
}
function ECARBEFMBC_OnBlur(e) {
SetActiveField(Ctrl('ECARBEFMBC'),false);
}
function DNNGPDMXQI_Valid(e) {
SetActiveField(Ctrl('DNNGPDMXQI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RASPAUI','C',w_RASPAUI,HtW(Ctrl('DNNGPDMXQI').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RASPAUI(HtW(Ctrl('DNNGPDMXQI').value,'C'),null,e);
return l_bSetResult;
}
}
function DNNGPDMXQI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DNNGPDMXQI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DNNGPDMXQI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DNNGPDMXQI'),e);
}
function WHJVJHBKYI_Valid(e) {
SetActiveField(Ctrl('WHJVJHBKYI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RESPAUI','C',w_RESPAUI,HtW(Ctrl('WHJVJHBKYI').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RESPAUI(HtW(Ctrl('WHJVJHBKYI').value,'C'),null,e);
return l_bSetResult;
}
}
function WHJVJHBKYI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WHJVJHBKYI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('WHJVJHBKYI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WHJVJHBKYI'),e);
}
function ZZSBUTEXWS_Valid(e) {
SetActiveField(Ctrl('ZZSBUTEXWS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TESTIP','C',w_TESTIP,HtW(Ctrl('ZZSBUTEXWS').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TESTIP(HtW(Ctrl('ZZSBUTEXWS').value,'C'),null,e);
return l_bSetResult;
}
}
function ZZSBUTEXWS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZZSBUTEXWS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZZSBUTEXWS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZZSBUTEXWS'),e);
}
function XRGIDJXVCB_Valid(e) {
SetActiveField(Ctrl('XRGIDJXVCB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('MINFRZSNAI','N',w_MINFRZSNAI,HtW(Ctrl('XRGIDJXVCB').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_MINFRZSNAI(HtW(Ctrl('XRGIDJXVCB').value,'N'),null,e);
return l_bSetResult;
}
}
function XRGIDJXVCB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XRGIDJXVCB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XRGIDJXVCB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XRGIDJXVCB'),e);
}
function CZINOLQOUB_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGSCDFRZ','C',w_FLGSCDFRZ,ChkboxValueAssign(Ctrl('CZINOLQOUB'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGSCDFRZ(ChkboxValueAssign(Ctrl('CZINOLQOUB'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function CZINOLQOUB_OnFocus(e) {
SetActiveField(Ctrl('CZINOLQOUB'),true);
}
function CZINOLQOUB_OnBlur(e) {
SetActiveField(Ctrl('CZINOLQOUB'),false);
}
function BMMUPRLVUU_Valid(e) {
SetActiveField(Ctrl('BMMUPRLVUU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('GIORNIFRZ','N',w_GIORNIFRZ,HtW(Ctrl('BMMUPRLVUU').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_GIORNIFRZ(HtW(Ctrl('BMMUPRLVUU').value,'N'),null,e);
return l_bSetResult;
}
}
function BMMUPRLVUU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BMMUPRLVUU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BMMUPRLVUU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BMMUPRLVUU'),e);
}
function JFMMDZQFJC_Valid(e) {
SetActiveField(Ctrl('JFMMDZQFJC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('LIMITVLT','N',w_LIMITVLT,HtW(Ctrl('JFMMDZQFJC').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_LIMITVLT(HtW(Ctrl('JFMMDZQFJC').value,'N'),null,e);
return l_bSetResult;
}
}
function JFMMDZQFJC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JFMMDZQFJC'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('JFMMDZQFJC',w_LIMITVLT,'N',10,2,'9999999.99');
SetActiveField(Ctrl('JFMMDZQFJC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JFMMDZQFJC'),e);
}
function JFMMDZQFJC_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("9999999.99"));
}
function OHKFECVWFV_Valid(e) {
SetActiveField(Ctrl('OHKFECVWFV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('LIMITVNP','N',w_LIMITVNP,HtW(Ctrl('OHKFECVWFV').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_LIMITVNP(HtW(Ctrl('OHKFECVWFV').value,'N'),null,e);
return l_bSetResult;
}
}
function OHKFECVWFV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OHKFECVWFV'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('OHKFECVWFV',w_LIMITVNP,'N',10,2,'9999999.99');
SetActiveField(Ctrl('OHKFECVWFV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OHKFECVWFV'),e);
}
function OHKFECVWFV_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("9999999.99"));
}
function OOAVIAADZS_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGSTPDIR','C',w_FLGSTPDIR,ChkboxValueAssign(Ctrl('OOAVIAADZS'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGSTPDIR(ChkboxValueAssign(Ctrl('OOAVIAADZS'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function OOAVIAADZS_OnFocus(e) {
SetActiveField(Ctrl('OOAVIAADZS'),true);
}
function OOAVIAADZS_OnBlur(e) {
SetActiveField(Ctrl('OOAVIAADZS'),false);
}
function MRWHAAPELH_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGNODOC','C',w_FLGNODOC,ChkboxValueAssign(Ctrl('MRWHAAPELH'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGNODOC(ChkboxValueAssign(Ctrl('MRWHAAPELH'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function MRWHAAPELH_OnFocus(e) {
SetActiveField(Ctrl('MRWHAAPELH'),true);
}
function MRWHAAPELH_OnBlur(e) {
SetActiveField(Ctrl('MRWHAAPELH'),false);
}
function HBTCFEMATT_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FRAZDEL','C',w_FRAZDEL,ChkboxValueAssign(Ctrl('HBTCFEMATT'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FRAZDEL(ChkboxValueAssign(Ctrl('HBTCFEMATT'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function HBTCFEMATT_OnFocus(e) {
SetActiveField(Ctrl('HBTCFEMATT'),true);
}
function HBTCFEMATT_OnBlur(e) {
SetActiveField(Ctrl('HBTCFEMATT'),false);
}
function FOTKWJQFAL_Valid(e) {
SetActiveField(Ctrl('FOTKWJQFAL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PATHAPP','C',w_PATHAPP,HtW(Ctrl('FOTKWJQFAL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PATHAPP(HtW(Ctrl('FOTKWJQFAL').value,'C'),null,e);
return l_bSetResult;
}
}
function FOTKWJQFAL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FOTKWJQFAL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FOTKWJQFAL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FOTKWJQFAL'),e);
}
function QMOTVZANBJ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGLIGHT','C',w_FLGLIGHT,ChkboxValueAssign(Ctrl('QMOTVZANBJ'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGLIGHT(ChkboxValueAssign(Ctrl('QMOTVZANBJ'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function QMOTVZANBJ_OnFocus(e) {
SetActiveField(Ctrl('QMOTVZANBJ'),true);
}
function QMOTVZANBJ_OnBlur(e) {
SetActiveField(Ctrl('QMOTVZANBJ'),false);
}
function ROVOSMARIB_Click() {
_modifyandopen(ToResource('servlet/sp_huploadfile'+'?pDirectory='+URLenc('manuale')+'&pAtExit='+URLenc('Return')+'&pVarReturn='+URLenc('PATHSID')+'&m_cParameterSequence=pDirectory,pAtExit,pVarReturn')+'&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function JPABVPZDBZ_Valid(e) {
SetActiveField(Ctrl('JPABVPZDBZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('pathmanuale','C',w_pathmanuale,HtW(Ctrl('JPABVPZDBZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_pathmanuale(HtW(Ctrl('JPABVPZDBZ').value,'C'),null,e);
return l_bSetResult;
}
}
function JPABVPZDBZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JPABVPZDBZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JPABVPZDBZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JPABVPZDBZ'),e);
}
function VJPULIZVKG_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGCGOPWD','C',w_FLGCGOPWD,ChkboxValueAssign(Ctrl('VJPULIZVKG'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGCGOPWD(ChkboxValueAssign(Ctrl('VJPULIZVKG'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function VJPULIZVKG_OnFocus(e) {
SetActiveField(Ctrl('VJPULIZVKG'),true);
}
function VJPULIZVKG_OnBlur(e) {
SetActiveField(Ctrl('VJPULIZVKG'),false);
}
function EMDHDDRUPP_Valid(e) {
SetActiveField(Ctrl('EMDHDDRUPP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PATHSID','C',w_PATHSID,HtW(Ctrl('EMDHDDRUPP').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PATHSID(HtW(Ctrl('EMDHDDRUPP').value,'C'),null,e);
return l_bSetResult;
}
}
function EMDHDDRUPP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EMDHDDRUPP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('EMDHDDRUPP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EMDHDDRUPP'),e);
}
function WXRSSFBXYH_Valid(e) {
SetActiveField(Ctrl('WXRSSFBXYH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PATHCERT','C',w_PATHCERT,HtW(Ctrl('WXRSSFBXYH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PATHCERT(HtW(Ctrl('WXRSSFBXYH').value,'C'),null,e);
return l_bSetResult;
}
}
function WXRSSFBXYH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WXRSSFBXYH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('WXRSSFBXYH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WXRSSFBXYH'),e);
}
function WPPFTLWEWX_Valid(e) {
SetActiveField(Ctrl('WPPFTLWEWX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PATHFTP','C',w_PATHFTP,HtW(Ctrl('WPPFTLWEWX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PATHFTP(HtW(Ctrl('WPPFTLWEWX').value,'C'),null,e);
return l_bSetResult;
}
}
function WPPFTLWEWX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WPPFTLWEWX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('WPPFTLWEWX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WPPFTLWEWX'),e);
}
function KZJBLRRDWP_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGUTEAGE','C',w_FLGUTEAGE,ChkboxValueAssign(Ctrl('KZJBLRRDWP'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGUTEAGE(ChkboxValueAssign(Ctrl('KZJBLRRDWP'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function KZJBLRRDWP_OnFocus(e) {
SetActiveField(Ctrl('KZJBLRRDWP'),true);
}
function KZJBLRRDWP_OnBlur(e) {
SetActiveField(Ctrl('KZJBLRRDWP'),false);
}
function PUWCGJFLDF_Valid(e) {
SetActiveField(Ctrl('PUWCGJFLDF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PRGAEPATH','C',w_PRGAEPATH,HtW(Ctrl('PUWCGJFLDF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PRGAEPATH(HtW(Ctrl('PUWCGJFLDF').value,'C'),null,e);
return l_bSetResult;
}
}
function PUWCGJFLDF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PUWCGJFLDF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PUWCGJFLDF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PUWCGJFLDF'),e);
}
function NVZYOQAKDU_Valid(e) {
SetActiveField(Ctrl('NVZYOQAKDU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NUMGIORN','N',w_NUMGIORN,HtW(Ctrl('NVZYOQAKDU').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NUMGIORN(HtW(Ctrl('NVZYOQAKDU').value,'N'),null,e);
return l_bSetResult;
}
}
function NVZYOQAKDU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NVZYOQAKDU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NVZYOQAKDU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NVZYOQAKDU'),e);
}
function MHHQTFPDEN_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGCGOOTP','C',w_FLGCGOOTP,ChkboxValueAssign(Ctrl('MHHQTFPDEN'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGCGOOTP(ChkboxValueAssign(Ctrl('MHHQTFPDEN'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function MHHQTFPDEN_OnFocus(e) {
SetActiveField(Ctrl('MHHQTFPDEN'),true);
}
function MHHQTFPDEN_OnBlur(e) {
SetActiveField(Ctrl('MHHQTFPDEN'),false);
}
function SSXDYZLCUX_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGCGOQADV','C',w_FLGCGOQADV,ChkboxValueAssign(Ctrl('SSXDYZLCUX'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGCGOQADV(ChkboxValueAssign(Ctrl('SSXDYZLCUX'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function SSXDYZLCUX_OnFocus(e) {
SetActiveField(Ctrl('SSXDYZLCUX'),true);
}
function SSXDYZLCUX_OnBlur(e) {
SetActiveField(Ctrl('SSXDYZLCUX'),false);
}
function XVGAGFPMXP_Valid(e) {
SetActiveField(Ctrl('XVGAGFPMXP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('BLOCCOUSER','N',w_BLOCCOUSER,HtW(Ctrl('XVGAGFPMXP').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_BLOCCOUSER(HtW(Ctrl('XVGAGFPMXP').value,'N'),null,e);
return l_bSetResult;
}
}
function XVGAGFPMXP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XVGAGFPMXP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XVGAGFPMXP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XVGAGFPMXP'),e);
}
function ABGLJLFEYQ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('CGOFLGPROF','C',w_CGOFLGPROF,ChkboxValueAssign(Ctrl('ABGLJLFEYQ'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CGOFLGPROF(ChkboxValueAssign(Ctrl('ABGLJLFEYQ'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function ABGLJLFEYQ_OnFocus(e) {
SetActiveField(Ctrl('ABGLJLFEYQ'),true);
}
function ABGLJLFEYQ_OnBlur(e) {
SetActiveField(Ctrl('ABGLJLFEYQ'),false);
}
function MLYQUOWFHN_Valid(e) {
SetActiveField(Ctrl('MLYQUOWFHN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ALTSRVMAIL','C',w_ALTSRVMAIL,HtW(Ctrl('MLYQUOWFHN').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ALTSRVMAIL(HtW(Ctrl('MLYQUOWFHN').value,'C'),null,e);
return l_bSetResult;
}
}
function MLYQUOWFHN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MLYQUOWFHN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MLYQUOWFHN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MLYQUOWFHN'),e);
}
function VRYHAZPGSR_Valid(e) {
SetActiveField(Ctrl('VRYHAZPGSR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ALTPRTMAIL','C',w_ALTPRTMAIL,HtW(Ctrl('VRYHAZPGSR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ALTPRTMAIL(HtW(Ctrl('VRYHAZPGSR').value,'C'),null,e);
return l_bSetResult;
}
}
function VRYHAZPGSR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VRYHAZPGSR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VRYHAZPGSR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VRYHAZPGSR'),e);
}
function TYOXRXGXKJ_Valid(e) {
SetActiveField(Ctrl('TYOXRXGXKJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ALTEMLMAIL','C',w_ALTEMLMAIL,HtW(Ctrl('TYOXRXGXKJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ALTEMLMAIL(HtW(Ctrl('TYOXRXGXKJ').value,'C'),null,e);
return l_bSetResult;
}
}
function TYOXRXGXKJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TYOXRXGXKJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TYOXRXGXKJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TYOXRXGXKJ'),e);
}
function OKEJPCYNVH_Valid(e) {
SetActiveField(Ctrl('OKEJPCYNVH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ALTUSRMAIL','C',w_ALTUSRMAIL,HtW(Ctrl('OKEJPCYNVH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ALTUSRMAIL(HtW(Ctrl('OKEJPCYNVH').value,'C'),null,e);
return l_bSetResult;
}
}
function OKEJPCYNVH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OKEJPCYNVH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OKEJPCYNVH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OKEJPCYNVH'),e);
}
function IIVBDSFKCC_Valid(e) {
SetActiveField(Ctrl('IIVBDSFKCC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ALTPWDMAIL','C',w_ALTPWDMAIL,HtW(Ctrl('IIVBDSFKCC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ALTPWDMAIL(HtW(Ctrl('IIVBDSFKCC').value,'C'),null,e);
return l_bSetResult;
}
}
function IIVBDSFKCC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IIVBDSFKCC'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('IIVBDSFKCC',w_ALTPWDMAIL,'C',30,0,'');
SetActiveField(Ctrl('IIVBDSFKCC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IIVBDSFKCC'),e);
}
function IIVBDSFKCC_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict('*'));
}
function FYAHSLEGLP_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGGESDOC','C',w_FLGGESDOC,ChkboxValueAssign(Ctrl('FYAHSLEGLP'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGGESDOC(ChkboxValueAssign(Ctrl('FYAHSLEGLP'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function FYAHSLEGLP_OnFocus(e) {
SetActiveField(Ctrl('FYAHSLEGLP'),true);
}
function FYAHSLEGLP_OnBlur(e) {
SetActiveField(Ctrl('FYAHSLEGLP'),false);
}
function MUANKUGIIK_Valid(e) {
SetActiveField(Ctrl('MUANKUGIIK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('USRGESDOC','C',w_USRGESDOC,HtW(Ctrl('MUANKUGIIK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_USRGESDOC(HtW(Ctrl('MUANKUGIIK').value,'C'),null,e);
return l_bSetResult;
}
}
function MUANKUGIIK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MUANKUGIIK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MUANKUGIIK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MUANKUGIIK'),e);
}
function HFVZAFILCA_Valid(e) {
SetActiveField(Ctrl('HFVZAFILCA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PWDGESDOC','C',w_PWDGESDOC,HtW(Ctrl('HFVZAFILCA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PWDGESDOC(HtW(Ctrl('HFVZAFILCA').value,'C'),null,e);
return l_bSetResult;
}
}
function HFVZAFILCA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HFVZAFILCA'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('HFVZAFILCA',w_PWDGESDOC,'C',30,0,'');
SetActiveField(Ctrl('HFVZAFILCA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HFVZAFILCA'),e);
}
function HFVZAFILCA_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("*"));
}
function RNIWEERJDP_Valid(e) {
SetActiveField(Ctrl('RNIWEERJDP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('URLDESDOC','C',w_URLDESDOC,HtW(Ctrl('RNIWEERJDP').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_URLDESDOC(HtW(Ctrl('RNIWEERJDP').value,'C'),null,e);
return l_bSetResult;
}
}
function RNIWEERJDP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RNIWEERJDP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RNIWEERJDP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RNIWEERJDP'),e);
}
function LZEBZLGWCH_Valid(e) {
SetActiveField(Ctrl('LZEBZLGWCH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('EMAILDOC','C',w_EMAILDOC,HtW(Ctrl('LZEBZLGWCH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_EMAILDOC(HtW(Ctrl('LZEBZLGWCH').value,'C'),null,e);
return l_bSetResult;
}
}
function LZEBZLGWCH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LZEBZLGWCH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LZEBZLGWCH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LZEBZLGWCH'),e);
}
function VOONRSAKSU_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('VOONRSAKSU'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('VOONRSAKSU').value=ApplyPictureToDate(Ctrl('VOONRSAKSU').value,TranslatePicture(datePattern),'VOONRSAKSU');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('VOONRSAKSU'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('VOONRSAKSU');
}
}
}
SetActiveField(Ctrl('VOONRSAKSU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATADOC','D',w_DATADOC,HtW(Ctrl('VOONRSAKSU').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATADOC(HtW(Ctrl('VOONRSAKSU').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function VOONRSAKSU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VOONRSAKSU'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('VOONRSAKSU',w_DATADOC,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('VOONRSAKSU');
SetActiveField(Ctrl('VOONRSAKSU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VOONRSAKSU'),e);
}
function VOONRSAKSU_ZOOM_Click() {
LaunchCalendar(Ctrl('VOONRSAKSU'));
}
function DJJPJVNREQ_Click() {
if (false || WindowConfirm(Translate('857291818'))) {
_modifyandopen('arrt_cgo_blockope'+'?m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
}
function MRRDOEHYLX_Valid(e) {
SetActiveField(Ctrl('MRRDOEHYLX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PATHDOCBAC','C',w_PATHDOCBAC,HtW(Ctrl('MRRDOEHYLX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PATHDOCBAC(HtW(Ctrl('MRRDOEHYLX').value,'C'),null,e);
return l_bSetResult;
}
}
function MRRDOEHYLX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MRRDOEHYLX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MRRDOEHYLX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MRRDOEHYLX'),e);
}
function ABFCWFBDMW_Valid(e) {
SetActiveField(Ctrl('ABFCWFBDMW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMPPATH','C',w_IMPPATH,HtW(Ctrl('ABFCWFBDMW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMPPATH(HtW(Ctrl('ABFCWFBDMW').value,'C'),null,e);
return l_bSetResult;
}
}
function ABFCWFBDMW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ABFCWFBDMW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ABFCWFBDMW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ABFCWFBDMW'),e);
}
function GORKFABVFF_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('CGOTGDEFMUL','C',w_CGOTGDEFMUL,HtW(getComboValue(Ctrl('GORKFABVFF')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CGOTGDEFMUL(HtW(getComboValue(Ctrl('GORKFABVFF')),'C'),null,e);
return l_bSetResult;
}
}
function GORKFABVFF_OnFocus(e) {
SetActiveField(Ctrl('GORKFABVFF'),true);
}
function GORKFABVFF_OnBlur(e) {
SetActiveField(Ctrl('GORKFABVFF'),false);
}
function HAPCMCIYJW_Valid(e) {
SetActiveField(Ctrl('HAPCMCIYJW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SONUMMESI','N',w_SONUMMESI,HtW(Ctrl('HAPCMCIYJW').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SONUMMESI(HtW(Ctrl('HAPCMCIYJW').value,'N'),null,e);
return l_bSetResult;
}
}
function HAPCMCIYJW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HAPCMCIYJW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HAPCMCIYJW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HAPCMCIYJW'),e);
}
function OAAOYRQPRR_Valid(e) {
SetActiveField(Ctrl('OAAOYRQPRR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SOMESIBACK','N',w_SOMESIBACK,HtW(Ctrl('OAAOYRQPRR').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SOMESIBACK(HtW(Ctrl('OAAOYRQPRR').value,'N'),null,e);
return l_bSetResult;
}
}
function OAAOYRQPRR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OAAOYRQPRR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OAAOYRQPRR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OAAOYRQPRR'),e);
}
function IDOPVICMXL_Valid(e) {
SetActiveField(Ctrl('IDOPVICMXL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SOSHELLCMD','M',w_SOSHELLCMD,HtW(Ctrl('IDOPVICMXL').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SOSHELLCMD(HtW(Ctrl('IDOPVICMXL').value,'M'),null,e);
return l_bSetResult;
}
}
function IDOPVICMXL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IDOPVICMXL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IDOPVICMXL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IDOPVICMXL'),e);
}
function ATYYTAXDZW_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('SOAMBIENTE','C',w_SOAMBIENTE,HtW(getComboValue(Ctrl('ATYYTAXDZW')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SOAMBIENTE(HtW(getComboValue(Ctrl('ATYYTAXDZW')),'C'),null,e);
return l_bSetResult;
}
}
function ATYYTAXDZW_OnFocus(e) {
SetActiveField(Ctrl('ATYYTAXDZW'),true);
}
function ATYYTAXDZW_OnBlur(e) {
SetActiveField(Ctrl('ATYYTAXDZW'),false);
}
function GHUASLAKBC_Valid(e) {
SetActiveField(Ctrl('GHUASLAKBC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SOPATHIMPORT','M',w_SOPATHIMPORT,HtW(Ctrl('GHUASLAKBC').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SOPATHIMPORT(HtW(Ctrl('GHUASLAKBC').value,'M'),null,e);
return l_bSetResult;
}
}
function GHUASLAKBC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GHUASLAKBC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GHUASLAKBC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GHUASLAKBC'),e);
}
function APTIWOKBUI_Valid(e) {
SetActiveField(Ctrl('APTIWOKBUI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SOORAIMPORT','N',w_SOORAIMPORT,HtW(Ctrl('APTIWOKBUI').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SOORAIMPORT(HtW(Ctrl('APTIWOKBUI').value,'N'),null,e);
return l_bSetResult;
}
}
function APTIWOKBUI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('APTIWOKBUI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('APTIWOKBUI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('APTIWOKBUI'),e);
}
function HRSWOWLUUE_Valid(e) {
SetActiveField(Ctrl('HRSWOWLUUE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('QADV_SOGLIA','N',w_QADV_SOGLIA,HtW(Ctrl('HRSWOWLUUE').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_QADV_SOGLIA(HtW(Ctrl('HRSWOWLUUE').value,'N'),null,e);
return l_bSetResult;
}
}
function HRSWOWLUUE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HRSWOWLUUE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HRSWOWLUUE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HRSWOWLUUE'),e);
}
linkpc_url.u('JBFAVRHYDR',function(){return 'ardt_destwarn?m_bInnerChild=true'+GetLinkPCKeys('ardt_destwarn')+'&m_bRowsChild='+EnableChild('ardt_destwarn')})
linkpc_url.u('TOSEVHXRVF',function(){return 'ardt_cgo_tipall?m_bInnerChild=true'+GetLinkPCKeys('ardt_cgo_tipall')+'&m_bRowsChild='+EnableChild('ardt_cgo_tipall')})
linkpc_url.u('KDWFCOUSQZ',function(){return 'ardt_cgo_subnets?m_bInnerChild=true'+GetLinkPCKeys('ardt_cgo_subnets')+'&m_bRowsChild='+EnableChild('ardt_cgo_subnets')})
linkpc_url.u('JWJORCKLGL',function(){return 'ardt_destemail?m_bInnerChild=true'+GetLinkPCKeys('ardt_destemail')+'&m_bRowsChild='+EnableChild('ardt_destemail')})
_ResetTracker();
function setEventHandlers() {
var c;
function DFVZKIFMYL_wrap_OnClick(event) {
return DFVZKIFMYL_Click(event.srcElement);
}
SPBOUILib.SetButtonClick('DFVZKIFMYL',DFVZKIFMYL_wrap_OnClick);
if (Ne(m_cFunction,'view')) {
function JXOBOAXKRQ_wrap_Valid(event) {
return JXOBOAXKRQ_Valid(event);
}
SPBOUILib.SetComboChange('JXOBOAXKRQ',JXOBOAXKRQ_wrap_Valid);
function JXOBOAXKRQ_wrap_OnFocus(event) {
return JXOBOAXKRQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('JXOBOAXKRQ',JXOBOAXKRQ_wrap_OnFocus);
function JXOBOAXKRQ_wrap_Blur(event) {
return JXOBOAXKRQ_OnBlur(event);
}
SPBOUILib.SetInputExit('JXOBOAXKRQ',JXOBOAXKRQ_wrap_Blur);
function HVIUTGJWGE_wrap_Valid(event) {
return HVIUTGJWGE_Valid(event);
}
SPBOUILib.SetInputExit('HVIUTGJWGE',HVIUTGJWGE_wrap_Valid);
function HVIUTGJWGE_wrap_OnFocus(event) {
return HVIUTGJWGE_OnFocus(event);
}
SPBOUILib.SetInputEnter('HVIUTGJWGE',HVIUTGJWGE_wrap_OnFocus);
function HVIUTGJWGE_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('HVIUTGJWGE',HVIUTGJWGE_wrap_OnKeyPress);
function HVIUTGJWGE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HVIUTGJWGE',HVIUTGJWGE_wrap_OnKeyDown);
function JCGROGAZTR_wrap_Valid(event) {
return JCGROGAZTR_Valid(event);
}
SPBOUILib.SetInputExit('JCGROGAZTR',JCGROGAZTR_wrap_Valid);
function JCGROGAZTR_wrap_OnFocus(event) {
return JCGROGAZTR_OnFocus(event);
}
SPBOUILib.SetInputEnter('JCGROGAZTR',JCGROGAZTR_wrap_OnFocus);
function JCGROGAZTR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JCGROGAZTR',JCGROGAZTR_wrap_OnKeyDown);
function JCGROGAZTR_ZOOM_setHandlers() {
function JCGROGAZTR_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?JCGROGAZTR_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('JCGROGAZTR_ZOOM',JCGROGAZTR_ZOOM_wrap_OnClick);
function JCGROGAZTR_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('JCGROGAZTR_ZOOM',JCGROGAZTR_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('JCGROGAZTR',JCGROGAZTR_ZOOM_setHandlers);
function UQKLCBCTLH_wrap_Valid(event) {
return UQKLCBCTLH_Valid(event);
}
SPBOUILib.SetInputExit('UQKLCBCTLH',UQKLCBCTLH_wrap_Valid);
function UQKLCBCTLH_wrap_OnFocus(event) {
return UQKLCBCTLH_OnFocus(event);
}
SPBOUILib.SetInputEnter('UQKLCBCTLH',UQKLCBCTLH_wrap_OnFocus);
function UQKLCBCTLH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UQKLCBCTLH',UQKLCBCTLH_wrap_OnKeyDown);
function BQSGHFQUHM_wrap_Valid(event) {
return BQSGHFQUHM_Valid(event);
}
SPBOUILib.SetInputExit('BQSGHFQUHM',BQSGHFQUHM_wrap_Valid);
function BQSGHFQUHM_wrap_OnFocus(event) {
return BQSGHFQUHM_OnFocus(event);
}
SPBOUILib.SetInputEnter('BQSGHFQUHM',BQSGHFQUHM_wrap_OnFocus);
function BQSGHFQUHM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BQSGHFQUHM',BQSGHFQUHM_wrap_OnKeyDown);
function IXWLDAOCFD_wrap_Valid(event) {
return IXWLDAOCFD_Valid(event);
}
SPBOUILib.SetInputExit('IXWLDAOCFD',IXWLDAOCFD_wrap_Valid);
function IXWLDAOCFD_wrap_OnFocus(event) {
return IXWLDAOCFD_OnFocus(event);
}
SPBOUILib.SetInputEnter('IXWLDAOCFD',IXWLDAOCFD_wrap_OnFocus);
function IXWLDAOCFD_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IXWLDAOCFD',IXWLDAOCFD_wrap_OnKeyDown);
function SJHNBZJAKA_wrap_Valid(event) {
return SJHNBZJAKA_Valid(event);
}
SPBOUILib.SetInputExit('SJHNBZJAKA',SJHNBZJAKA_wrap_Valid);
function SJHNBZJAKA_wrap_OnFocus(event) {
return SJHNBZJAKA_OnFocus(event);
}
SPBOUILib.SetInputEnter('SJHNBZJAKA',SJHNBZJAKA_wrap_OnFocus);
function SJHNBZJAKA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SJHNBZJAKA',SJHNBZJAKA_wrap_OnKeyDown);
function IIXRREUEAM_wrap_Valid(event) {
return IIXRREUEAM_Valid(event);
}
SPBOUILib.SetInputExit('IIXRREUEAM',IIXRREUEAM_wrap_Valid);
function IIXRREUEAM_wrap_OnFocus(event) {
return IIXRREUEAM_OnFocus(event);
}
SPBOUILib.SetInputEnter('IIXRREUEAM',IIXRREUEAM_wrap_OnFocus);
function IIXRREUEAM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IIXRREUEAM',IIXRREUEAM_wrap_OnKeyDown);
function IIXRREUEAM_ZOOM_setHandlers() {
function IIXRREUEAM_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?IIXRREUEAM_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('IIXRREUEAM_ZOOM',IIXRREUEAM_ZOOM_wrap_OnClick);
function IIXRREUEAM_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('IIXRREUEAM_ZOOM',IIXRREUEAM_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('IIXRREUEAM',IIXRREUEAM_ZOOM_setHandlers);
function SZWCLLEIQY_wrap_Valid(event) {
return SZWCLLEIQY_Valid(event);
}
SPBOUILib.SetInputExit('SZWCLLEIQY',SZWCLLEIQY_wrap_Valid);
function SZWCLLEIQY_wrap_OnFocus(event) {
return SZWCLLEIQY_OnFocus(event);
}
SPBOUILib.SetInputEnter('SZWCLLEIQY',SZWCLLEIQY_wrap_OnFocus);
function SZWCLLEIQY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SZWCLLEIQY',SZWCLLEIQY_wrap_OnKeyDown);
function OIWIANSIOG_wrap_Valid(event) {
return OIWIANSIOG_Valid(event);
}
SPBOUILib.SetInputExit('OIWIANSIOG',OIWIANSIOG_wrap_Valid);
function OIWIANSIOG_wrap_OnFocus(event) {
return OIWIANSIOG_OnFocus(event);
}
SPBOUILib.SetInputEnter('OIWIANSIOG',OIWIANSIOG_wrap_OnFocus);
function OIWIANSIOG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OIWIANSIOG',OIWIANSIOG_wrap_OnKeyDown);
function TNUQTSSGFZ_wrap_Valid(event) {
return TNUQTSSGFZ_Valid(event);
}
SPBOUILib.SetInputExit('TNUQTSSGFZ',TNUQTSSGFZ_wrap_Valid);
function TNUQTSSGFZ_wrap_OnFocus(event) {
return TNUQTSSGFZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('TNUQTSSGFZ',TNUQTSSGFZ_wrap_OnFocus);
function TNUQTSSGFZ_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('TNUQTSSGFZ',TNUQTSSGFZ_wrap_OnKeyPress);
function TNUQTSSGFZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('TNUQTSSGFZ',TNUQTSSGFZ_wrap_OnKeyDown);
function LLYIGAMXRH_wrap_Valid(event) {
return LLYIGAMXRH_Valid(event);
}
SPBOUILib.SetInputExit('LLYIGAMXRH',LLYIGAMXRH_wrap_Valid);
function LLYIGAMXRH_wrap_OnFocus(event) {
return LLYIGAMXRH_OnFocus(event);
}
SPBOUILib.SetInputEnter('LLYIGAMXRH',LLYIGAMXRH_wrap_OnFocus);
function LLYIGAMXRH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LLYIGAMXRH',LLYIGAMXRH_wrap_OnKeyDown);
function LLYIGAMXRH_ZOOM_setHandlers() {
function LLYIGAMXRH_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?LLYIGAMXRH_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('LLYIGAMXRH_ZOOM',LLYIGAMXRH_ZOOM_wrap_OnClick);
function LLYIGAMXRH_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('LLYIGAMXRH_ZOOM',LLYIGAMXRH_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('LLYIGAMXRH',LLYIGAMXRH_ZOOM_setHandlers);
function RVNHQCXNEM_wrap_Valid(event) {
return RVNHQCXNEM_Valid(event);
}
SPBOUILib.SetInputExit('RVNHQCXNEM',RVNHQCXNEM_wrap_Valid);
function RVNHQCXNEM_wrap_OnFocus(event) {
return RVNHQCXNEM_OnFocus(event);
}
SPBOUILib.SetInputEnter('RVNHQCXNEM',RVNHQCXNEM_wrap_OnFocus);
function RVNHQCXNEM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RVNHQCXNEM',RVNHQCXNEM_wrap_OnKeyDown);
function RVNHQCXNEM_ZOOM_setHandlers() {
function RVNHQCXNEM_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?RVNHQCXNEM_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('RVNHQCXNEM_ZOOM',RVNHQCXNEM_ZOOM_wrap_OnClick);
function RVNHQCXNEM_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('RVNHQCXNEM_ZOOM',RVNHQCXNEM_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('RVNHQCXNEM',RVNHQCXNEM_ZOOM_setHandlers);
function ZGNLLSFQHC_wrap_Valid(event) {
return ZGNLLSFQHC_Valid(event);
}
SPBOUILib.SetInputExit('ZGNLLSFQHC',ZGNLLSFQHC_wrap_Valid);
function ZGNLLSFQHC_wrap_OnFocus(event) {
return ZGNLLSFQHC_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZGNLLSFQHC',ZGNLLSFQHC_wrap_OnFocus);
function ZGNLLSFQHC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZGNLLSFQHC',ZGNLLSFQHC_wrap_OnKeyDown);
function ZGNLLSFQHC_ZOOM_setHandlers() {
function ZGNLLSFQHC_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ZGNLLSFQHC_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('ZGNLLSFQHC_ZOOM',ZGNLLSFQHC_ZOOM_wrap_OnClick);
function ZGNLLSFQHC_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('ZGNLLSFQHC_ZOOM',ZGNLLSFQHC_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('ZGNLLSFQHC',ZGNLLSFQHC_ZOOM_setHandlers);
function AYYXYNLAUC_wrap_Valid(event) {
return AYYXYNLAUC_Valid(event);
}
SPBOUILib.SetComboChange('AYYXYNLAUC',AYYXYNLAUC_wrap_Valid);
function AYYXYNLAUC_wrap_OnFocus(event) {
return AYYXYNLAUC_OnFocus(event);
}
SPBOUILib.SetInputEnter('AYYXYNLAUC',AYYXYNLAUC_wrap_OnFocus);
function AYYXYNLAUC_wrap_Blur(event) {
return AYYXYNLAUC_OnBlur(event);
}
SPBOUILib.SetInputExit('AYYXYNLAUC',AYYXYNLAUC_wrap_Blur);
function OREVCZVNVS_wrap_Valid(event) {
return OREVCZVNVS_Valid(event);
}
SPBOUILib.SetComboChange('OREVCZVNVS',OREVCZVNVS_wrap_Valid);
function OREVCZVNVS_wrap_OnFocus(event) {
return OREVCZVNVS_OnFocus(event);
}
SPBOUILib.SetInputEnter('OREVCZVNVS',OREVCZVNVS_wrap_OnFocus);
function OREVCZVNVS_wrap_Blur(event) {
return OREVCZVNVS_OnBlur(event);
}
SPBOUILib.SetInputExit('OREVCZVNVS',OREVCZVNVS_wrap_Blur);
function XCNHFVDZMT_wrap_Valid(event) {
return XCNHFVDZMT_Valid(event);
}
SPBOUILib.SetInputExit('XCNHFVDZMT',XCNHFVDZMT_wrap_Valid);
function XCNHFVDZMT_wrap_OnFocus(event) {
return XCNHFVDZMT_OnFocus(event);
}
SPBOUILib.SetInputEnter('XCNHFVDZMT',XCNHFVDZMT_wrap_OnFocus);
function XCNHFVDZMT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XCNHFVDZMT',XCNHFVDZMT_wrap_OnKeyDown);
function ZYURNYDRPU_wrap_Valid(event) {
return ZYURNYDRPU_Valid(event);
}
SPBOUILib.SetInputExit('ZYURNYDRPU',ZYURNYDRPU_wrap_Valid);
function ZYURNYDRPU_wrap_OnFocus(event) {
return ZYURNYDRPU_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZYURNYDRPU',ZYURNYDRPU_wrap_OnFocus);
function ZYURNYDRPU_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('ZYURNYDRPU',ZYURNYDRPU_wrap_OnKeyPress);
function ZYURNYDRPU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('ZYURNYDRPU',ZYURNYDRPU_wrap_OnKeyDown);
function YYONLOLCBB_wrap_Valid(event) {
return YYONLOLCBB_Valid(event);
}
SPBOUILib.SetInputExit('YYONLOLCBB',YYONLOLCBB_wrap_Valid);
function YYONLOLCBB_wrap_OnFocus(event) {
return YYONLOLCBB_OnFocus(event);
}
SPBOUILib.SetInputEnter('YYONLOLCBB',YYONLOLCBB_wrap_OnFocus);
function YYONLOLCBB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YYONLOLCBB',YYONLOLCBB_wrap_OnKeyDown);
function PSZTLCSMPB_wrap_Valid(event) {
return PSZTLCSMPB_Valid(event);
}
SPBOUILib.SetInputExit('PSZTLCSMPB',PSZTLCSMPB_wrap_Valid);
function PSZTLCSMPB_wrap_OnFocus(event) {
return PSZTLCSMPB_OnFocus(event);
}
SPBOUILib.SetInputEnter('PSZTLCSMPB',PSZTLCSMPB_wrap_OnFocus);
function PSZTLCSMPB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PSZTLCSMPB',PSZTLCSMPB_wrap_OnKeyDown);
function PSZTLCSMPB_ZOOM_setHandlers() {
function PSZTLCSMPB_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?PSZTLCSMPB_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('PSZTLCSMPB_ZOOM',PSZTLCSMPB_ZOOM_wrap_OnClick);
function PSZTLCSMPB_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('PSZTLCSMPB_ZOOM',PSZTLCSMPB_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('PSZTLCSMPB',PSZTLCSMPB_ZOOM_setHandlers);
function COVTIKSDDS_wrap_Valid(event) {
return COVTIKSDDS_Valid(event);
}
SPBOUILib.SetInputExit('COVTIKSDDS',COVTIKSDDS_wrap_Valid);
function COVTIKSDDS_wrap_OnFocus(event) {
return COVTIKSDDS_OnFocus(event);
}
SPBOUILib.SetInputEnter('COVTIKSDDS',COVTIKSDDS_wrap_OnFocus);
function COVTIKSDDS_MENU_setHandlers() {
function COVTIKSDDS_MENU_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?COVTIKSDDS_MENU_Click():void(0));
}
SPBOUILib.SetButtonClick('COVTIKSDDS_MENU',COVTIKSDDS_MENU_wrap_OnClick);
function COVTIKSDDS_MENU_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('COVTIKSDDS_MENU',COVTIKSDDS_MENU_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('COVTIKSDDS',COVTIKSDDS_MENU_setHandlers);
function WSAOVXNTFO_wrap_Valid(event) {
return WSAOVXNTFO_Valid(event);
}
SPBOUILib.SetInputExit('WSAOVXNTFO',WSAOVXNTFO_wrap_Valid);
function WSAOVXNTFO_wrap_OnFocus(event) {
return WSAOVXNTFO_OnFocus(event);
}
SPBOUILib.SetInputEnter('WSAOVXNTFO',WSAOVXNTFO_wrap_OnFocus);
function WSAOVXNTFO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WSAOVXNTFO',WSAOVXNTFO_wrap_OnKeyDown);
function YPYQJILEQY_wrap_Valid(event) {
return YPYQJILEQY_Valid(event);
}
SPBOUILib.SetInputExit('YPYQJILEQY',YPYQJILEQY_wrap_Valid);
function YPYQJILEQY_wrap_OnFocus(event) {
return YPYQJILEQY_OnFocus(event);
}
SPBOUILib.SetInputEnter('YPYQJILEQY',YPYQJILEQY_wrap_OnFocus);
function YPYQJILEQY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YPYQJILEQY',YPYQJILEQY_wrap_OnKeyDown);
function MXHAWWCAZX_wrap_Valid(event) {
return MXHAWWCAZX_Valid(event);
}
SPBOUILib.SetInputExit('MXHAWWCAZX',MXHAWWCAZX_wrap_Valid);
function MXHAWWCAZX_wrap_OnFocus(event) {
return MXHAWWCAZX_OnFocus(event);
}
SPBOUILib.SetInputEnter('MXHAWWCAZX',MXHAWWCAZX_wrap_OnFocus);
function MXHAWWCAZX_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('MXHAWWCAZX',MXHAWWCAZX_wrap_OnKeyPress);
function MXHAWWCAZX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('MXHAWWCAZX',MXHAWWCAZX_wrap_OnKeyDown);
function TFMCRMSOGY_wrap_Valid(event) {
return TFMCRMSOGY_Valid(event);
}
SPBOUILib.SetInputExit('TFMCRMSOGY',TFMCRMSOGY_wrap_Valid);
function TFMCRMSOGY_wrap_OnFocus(event) {
return TFMCRMSOGY_OnFocus(event);
}
SPBOUILib.SetInputEnter('TFMCRMSOGY',TFMCRMSOGY_wrap_OnFocus);
function TFMCRMSOGY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TFMCRMSOGY',TFMCRMSOGY_wrap_OnKeyDown);
function YUCSUDKWNH_wrap_Valid(event) {
return YUCSUDKWNH_Valid(event);
}
SPBOUILib.SetInputExit('YUCSUDKWNH',YUCSUDKWNH_wrap_Valid);
function YUCSUDKWNH_wrap_OnFocus(event) {
return YUCSUDKWNH_OnFocus(event);
}
SPBOUILib.SetInputEnter('YUCSUDKWNH',YUCSUDKWNH_wrap_OnFocus);
function YUCSUDKWNH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YUCSUDKWNH',YUCSUDKWNH_wrap_OnKeyDown);
function JSTXCUBOUH_wrap_Valid(event) {
return JSTXCUBOUH_Valid(event);
}
SPBOUILib.SetComboChange('JSTXCUBOUH',JSTXCUBOUH_wrap_Valid);
function JSTXCUBOUH_wrap_OnFocus(event) {
return JSTXCUBOUH_OnFocus(event);
}
SPBOUILib.SetInputEnter('JSTXCUBOUH',JSTXCUBOUH_wrap_OnFocus);
function JSTXCUBOUH_wrap_Blur(event) {
return JSTXCUBOUH_OnBlur(event);
}
SPBOUILib.SetInputExit('JSTXCUBOUH',JSTXCUBOUH_wrap_Blur);
function YOVFWZCOBN_wrap_Valid(event) {
return YOVFWZCOBN_Valid(event);
}
SPBOUILib.SetInputExit('YOVFWZCOBN',YOVFWZCOBN_wrap_Valid);
function YOVFWZCOBN_wrap_OnFocus(event) {
return YOVFWZCOBN_OnFocus(event);
}
SPBOUILib.SetInputEnter('YOVFWZCOBN',YOVFWZCOBN_wrap_OnFocus);
function YOVFWZCOBN_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('YOVFWZCOBN',YOVFWZCOBN_wrap_OnKeyPress);
function YOVFWZCOBN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('YOVFWZCOBN',YOVFWZCOBN_wrap_OnKeyDown);
function QPIRUTKOVH_wrap_Valid(event) {
return QPIRUTKOVH_Valid(event);
}
SPBOUILib.SetInputExit('QPIRUTKOVH',QPIRUTKOVH_wrap_Valid);
function QPIRUTKOVH_wrap_OnFocus(event) {
return QPIRUTKOVH_OnFocus(event);
}
SPBOUILib.SetInputEnter('QPIRUTKOVH',QPIRUTKOVH_wrap_OnFocus);
function QPIRUTKOVH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QPIRUTKOVH',QPIRUTKOVH_wrap_OnKeyDown);
function ULCBOSJURF_wrap_Valid(event) {
return ULCBOSJURF_Valid(event);
}
SPBOUILib.SetInputExit('ULCBOSJURF',ULCBOSJURF_wrap_Valid);
function ULCBOSJURF_wrap_OnFocus(event) {
return ULCBOSJURF_OnFocus(event);
}
SPBOUILib.SetInputEnter('ULCBOSJURF',ULCBOSJURF_wrap_OnFocus);
function ULCBOSJURF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ULCBOSJURF',ULCBOSJURF_wrap_OnKeyDown);
function KHHILRUMHZ_wrap_Valid(event) {
return KHHILRUMHZ_Valid(event);
}
SPBOUILib.SetInputExit('KHHILRUMHZ',KHHILRUMHZ_wrap_Valid);
function KHHILRUMHZ_wrap_OnFocus(event) {
return KHHILRUMHZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('KHHILRUMHZ',KHHILRUMHZ_wrap_OnFocus);
function KHHILRUMHZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KHHILRUMHZ',KHHILRUMHZ_wrap_OnKeyDown);
function ELBURHNYTV_wrap_Valid(event) {
return ELBURHNYTV_Valid(event);
}
SPBOUILib.SetComboChange('ELBURHNYTV',ELBURHNYTV_wrap_Valid);
function ELBURHNYTV_wrap_OnFocus(event) {
return ELBURHNYTV_OnFocus(event);
}
SPBOUILib.SetInputEnter('ELBURHNYTV',ELBURHNYTV_wrap_OnFocus);
function ELBURHNYTV_wrap_Blur(event) {
return ELBURHNYTV_OnBlur(event);
}
SPBOUILib.SetInputExit('ELBURHNYTV',ELBURHNYTV_wrap_Blur);
function JYYHNLJDWT_wrap_Valid(event) {
return JYYHNLJDWT_Valid(event);
}
SPBOUILib.SetCheckboxClick('JYYHNLJDWT',JYYHNLJDWT_wrap_Valid);
function JYYHNLJDWT_wrap_OnFocus(event) {
return JYYHNLJDWT_OnFocus(event);
}
SPBOUILib.SetInputEnter('JYYHNLJDWT',JYYHNLJDWT_wrap_OnFocus);
function JYYHNLJDWT_wrap_Blur(event) {
return JYYHNLJDWT_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('JYYHNLJDWT',JYYHNLJDWT_wrap_Blur);
function LMKKKUVBBI_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?LMKKKUVBBI_Click(event.srcElement):void(0));
}
SPBOUILib.SetButtonClick('LMKKKUVBBI',LMKKKUVBBI_wrap_OnClick);
function LMKKKUVBBI_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('LMKKKUVBBI',LMKKKUVBBI_wrap_OnKeyDown);
function DFVZKIFMYL_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('DFVZKIFMYL',DFVZKIFMYL_wrap_OnKeyDown);
function FLPFDBFHXV_wrap_Valid(event) {
return FLPFDBFHXV_Valid(event);
}
SPBOUILib.SetInputExit('FLPFDBFHXV',FLPFDBFHXV_wrap_Valid);
function FLPFDBFHXV_wrap_OnFocus(event) {
return FLPFDBFHXV_OnFocus(event);
}
SPBOUILib.SetInputEnter('FLPFDBFHXV',FLPFDBFHXV_wrap_OnFocus);
function FLPFDBFHXV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FLPFDBFHXV',FLPFDBFHXV_wrap_OnKeyDown);
function LBMKPTTAXP_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?LBMKPTTAXP_Click():void(0));
}
SPBOUILib.SetButtonClick('LBMKPTTAXP',LBMKPTTAXP_wrap_OnClick);
function LBMKPTTAXP_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('LBMKPTTAXP',LBMKPTTAXP_wrap_OnKeyDown);
function LYZAJWZGAM_wrap_Valid(event) {
return LYZAJWZGAM_Valid(event);
}
SPBOUILib.SetComboChange('LYZAJWZGAM',LYZAJWZGAM_wrap_Valid);
function LYZAJWZGAM_wrap_OnFocus(event) {
return LYZAJWZGAM_OnFocus(event);
}
SPBOUILib.SetInputEnter('LYZAJWZGAM',LYZAJWZGAM_wrap_OnFocus);
function LYZAJWZGAM_wrap_Blur(event) {
return LYZAJWZGAM_OnBlur(event);
}
SPBOUILib.SetInputExit('LYZAJWZGAM',LYZAJWZGAM_wrap_Blur);
function LAQADJFMRL_wrap_Valid(event) {
return LAQADJFMRL_Valid(event);
}
SPBOUILib.SetInputExit('LAQADJFMRL',LAQADJFMRL_wrap_Valid);
function LAQADJFMRL_wrap_OnFocus(event) {
return LAQADJFMRL_OnFocus(event);
}
SPBOUILib.SetInputEnter('LAQADJFMRL',LAQADJFMRL_wrap_OnFocus);
function LAQADJFMRL_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('LAQADJFMRL',LAQADJFMRL_wrap_OnKeyPress);
function LAQADJFMRL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('LAQADJFMRL',LAQADJFMRL_wrap_OnKeyDown);
function LAQADJFMRL_ZOOM_setHandlers() {
function LAQADJFMRL_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?LAQADJFMRL_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('LAQADJFMRL_ZOOM',LAQADJFMRL_ZOOM_wrap_OnClick);
function LAQADJFMRL_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('LAQADJFMRL_ZOOM',LAQADJFMRL_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('LAQADJFMRL',LAQADJFMRL_ZOOM_setHandlers);
function ZYHCFDSBFP_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ZYHCFDSBFP_Click():void(0));
}
SPBOUILib.SetButtonClick('ZYHCFDSBFP',ZYHCFDSBFP_wrap_OnClick);
function ZYHCFDSBFP_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('ZYHCFDSBFP',ZYHCFDSBFP_wrap_OnKeyDown);
function FTETLDBHIY_wrap_Valid(event) {
return FTETLDBHIY_Valid(event);
}
SPBOUILib.SetInputExit('FTETLDBHIY',FTETLDBHIY_wrap_Valid);
function FTETLDBHIY_wrap_OnFocus(event) {
return FTETLDBHIY_OnFocus(event);
}
SPBOUILib.SetInputEnter('FTETLDBHIY',FTETLDBHIY_wrap_OnFocus);
function FTETLDBHIY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FTETLDBHIY',FTETLDBHIY_wrap_OnKeyDown);
function HNIRGTQRAE_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?HNIRGTQRAE_Click():void(0));
}
SPBOUILib.SetButtonClick('HNIRGTQRAE',HNIRGTQRAE_wrap_OnClick);
function HNIRGTQRAE_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('HNIRGTQRAE',HNIRGTQRAE_wrap_OnKeyDown);
function CWVJUDEVCT_wrap_Valid(event) {
return CWVJUDEVCT_Valid(event);
}
SPBOUILib.SetCheckboxClick('CWVJUDEVCT',CWVJUDEVCT_wrap_Valid);
function CWVJUDEVCT_wrap_OnFocus(event) {
return CWVJUDEVCT_OnFocus(event);
}
SPBOUILib.SetInputEnter('CWVJUDEVCT',CWVJUDEVCT_wrap_OnFocus);
function CWVJUDEVCT_wrap_Blur(event) {
return CWVJUDEVCT_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('CWVJUDEVCT',CWVJUDEVCT_wrap_Blur);
function FPFLFCPHAL_wrap_Valid(event) {
return FPFLFCPHAL_Valid(event);
}
SPBOUILib.SetInputExit('FPFLFCPHAL',FPFLFCPHAL_wrap_Valid);
function FPFLFCPHAL_wrap_OnFocus(event) {
return FPFLFCPHAL_OnFocus(event);
}
SPBOUILib.SetInputEnter('FPFLFCPHAL',FPFLFCPHAL_wrap_OnFocus);
function FPFLFCPHAL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FPFLFCPHAL',FPFLFCPHAL_wrap_OnKeyDown);
function EOQVPQLKOP_wrap_Valid(event) {
return EOQVPQLKOP_Valid(event);
}
SPBOUILib.SetCheckboxClick('EOQVPQLKOP',EOQVPQLKOP_wrap_Valid);
function EOQVPQLKOP_wrap_OnFocus(event) {
return EOQVPQLKOP_OnFocus(event);
}
SPBOUILib.SetInputEnter('EOQVPQLKOP',EOQVPQLKOP_wrap_OnFocus);
function EOQVPQLKOP_wrap_Blur(event) {
return EOQVPQLKOP_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('EOQVPQLKOP',EOQVPQLKOP_wrap_Blur);
function BLWLPTWCFV_wrap_Valid(event) {
return BLWLPTWCFV_Valid(event);
}
SPBOUILib.SetCheckboxClick('BLWLPTWCFV',BLWLPTWCFV_wrap_Valid);
function BLWLPTWCFV_wrap_OnFocus(event) {
return BLWLPTWCFV_OnFocus(event);
}
SPBOUILib.SetInputEnter('BLWLPTWCFV',BLWLPTWCFV_wrap_OnFocus);
function BLWLPTWCFV_wrap_Blur(event) {
return BLWLPTWCFV_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('BLWLPTWCFV',BLWLPTWCFV_wrap_Blur);
function REBGPUSIPL_wrap_Valid(event) {
return REBGPUSIPL_Valid(event);
}
SPBOUILib.SetCheckboxClick('REBGPUSIPL',REBGPUSIPL_wrap_Valid);
function REBGPUSIPL_wrap_OnFocus(event) {
return REBGPUSIPL_OnFocus(event);
}
SPBOUILib.SetInputEnter('REBGPUSIPL',REBGPUSIPL_wrap_OnFocus);
function REBGPUSIPL_wrap_Blur(event) {
return REBGPUSIPL_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('REBGPUSIPL',REBGPUSIPL_wrap_Blur);
function HKDCUQQHSU_wrap_Valid(event) {
return HKDCUQQHSU_Valid(event);
}
SPBOUILib.SetCheckboxClick('HKDCUQQHSU',HKDCUQQHSU_wrap_Valid);
function HKDCUQQHSU_wrap_OnFocus(event) {
return HKDCUQQHSU_OnFocus(event);
}
SPBOUILib.SetInputEnter('HKDCUQQHSU',HKDCUQQHSU_wrap_OnFocus);
function HKDCUQQHSU_wrap_Blur(event) {
return HKDCUQQHSU_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('HKDCUQQHSU',HKDCUQQHSU_wrap_Blur);
function CCBVEBVMNW_wrap_Valid(event) {
return CCBVEBVMNW_Valid(event);
}
SPBOUILib.SetCheckboxClick('CCBVEBVMNW',CCBVEBVMNW_wrap_Valid);
function CCBVEBVMNW_wrap_OnFocus(event) {
return CCBVEBVMNW_OnFocus(event);
}
SPBOUILib.SetInputEnter('CCBVEBVMNW',CCBVEBVMNW_wrap_OnFocus);
function CCBVEBVMNW_wrap_Blur(event) {
return CCBVEBVMNW_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('CCBVEBVMNW',CCBVEBVMNW_wrap_Blur);
function IDROHZZWYH_wrap_Valid(event) {
return IDROHZZWYH_Valid(event);
}
SPBOUILib.SetComboChange('IDROHZZWYH',IDROHZZWYH_wrap_Valid);
function IDROHZZWYH_wrap_OnFocus(event) {
return IDROHZZWYH_OnFocus(event);
}
SPBOUILib.SetInputEnter('IDROHZZWYH',IDROHZZWYH_wrap_OnFocus);
function IDROHZZWYH_wrap_Blur(event) {
return IDROHZZWYH_OnBlur(event);
}
SPBOUILib.SetInputExit('IDROHZZWYH',IDROHZZWYH_wrap_Blur);
function IQOQQQRZAK_wrap_Valid(event) {
return IQOQQQRZAK_Valid(event);
}
SPBOUILib.SetInputExit('IQOQQQRZAK',IQOQQQRZAK_wrap_Valid);
function IQOQQQRZAK_wrap_OnFocus(event) {
return IQOQQQRZAK_OnFocus(event);
}
SPBOUILib.SetInputEnter('IQOQQQRZAK',IQOQQQRZAK_wrap_OnFocus);
function IQOQQQRZAK_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('IQOQQQRZAK',IQOQQQRZAK_wrap_OnKeyPress);
function IQOQQQRZAK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('IQOQQQRZAK',IQOQQQRZAK_wrap_OnKeyDown);
function IQOQQQRZAK_ZOOM_setHandlers() {
function IQOQQQRZAK_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?IQOQQQRZAK_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('IQOQQQRZAK_ZOOM',IQOQQQRZAK_ZOOM_wrap_OnClick);
function IQOQQQRZAK_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('IQOQQQRZAK_ZOOM',IQOQQQRZAK_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('IQOQQQRZAK',IQOQQQRZAK_ZOOM_setHandlers);
function ZPSOMDIBXB_wrap_Valid(event) {
return ZPSOMDIBXB_Valid(event);
}
SPBOUILib.SetRadioClick('ZPSOMDIBXB',ZPSOMDIBXB_wrap_Valid);
function PIGFPYZMIR_wrap_Valid(event) {
return PIGFPYZMIR_Valid(event);
}
SPBOUILib.SetCheckboxClick('PIGFPYZMIR',PIGFPYZMIR_wrap_Valid);
function PIGFPYZMIR_wrap_OnFocus(event) {
return PIGFPYZMIR_OnFocus(event);
}
SPBOUILib.SetInputEnter('PIGFPYZMIR',PIGFPYZMIR_wrap_OnFocus);
function PIGFPYZMIR_wrap_Blur(event) {
return PIGFPYZMIR_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('PIGFPYZMIR',PIGFPYZMIR_wrap_Blur);
function DUFIQNBDKW_wrap_Valid(event) {
return DUFIQNBDKW_Valid(event);
}
SPBOUILib.SetComboChange('DUFIQNBDKW',DUFIQNBDKW_wrap_Valid);
function DUFIQNBDKW_wrap_OnFocus(event) {
return DUFIQNBDKW_OnFocus(event);
}
SPBOUILib.SetInputEnter('DUFIQNBDKW',DUFIQNBDKW_wrap_OnFocus);
function DUFIQNBDKW_wrap_Blur(event) {
return DUFIQNBDKW_OnBlur(event);
}
SPBOUILib.SetInputExit('DUFIQNBDKW',DUFIQNBDKW_wrap_Blur);
function LOYILZBSVI_wrap_Valid(event) {
return LOYILZBSVI_Valid(event);
}
SPBOUILib.SetCheckboxClick('LOYILZBSVI',LOYILZBSVI_wrap_Valid);
function LOYILZBSVI_wrap_OnFocus(event) {
return LOYILZBSVI_OnFocus(event);
}
SPBOUILib.SetInputEnter('LOYILZBSVI',LOYILZBSVI_wrap_OnFocus);
function LOYILZBSVI_wrap_Blur(event) {
return LOYILZBSVI_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('LOYILZBSVI',LOYILZBSVI_wrap_Blur);
function YJCSSLPJKG_wrap_Valid(event) {
return YJCSSLPJKG_Valid(event);
}
SPBOUILib.SetInputExit('YJCSSLPJKG',YJCSSLPJKG_wrap_Valid);
function YJCSSLPJKG_wrap_OnFocus(event) {
return YJCSSLPJKG_OnFocus(event);
}
SPBOUILib.SetInputEnter('YJCSSLPJKG',YJCSSLPJKG_wrap_OnFocus);
function YJCSSLPJKG_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('YJCSSLPJKG',YJCSSLPJKG_wrap_OnKeyPress);
function YJCSSLPJKG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YJCSSLPJKG',YJCSSLPJKG_wrap_OnKeyDown);
function PXNLADGGBR_wrap_Valid(event) {
return PXNLADGGBR_Valid(event);
}
SPBOUILib.SetCheckboxClick('PXNLADGGBR',PXNLADGGBR_wrap_Valid);
function PXNLADGGBR_wrap_OnFocus(event) {
return PXNLADGGBR_OnFocus(event);
}
SPBOUILib.SetInputEnter('PXNLADGGBR',PXNLADGGBR_wrap_OnFocus);
function PXNLADGGBR_wrap_Blur(event) {
return PXNLADGGBR_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('PXNLADGGBR',PXNLADGGBR_wrap_Blur);
function OSHAMNPXFT_wrap_Valid(event) {
return OSHAMNPXFT_Valid(event);
}
SPBOUILib.SetCheckboxClick('OSHAMNPXFT',OSHAMNPXFT_wrap_Valid);
function OSHAMNPXFT_wrap_OnFocus(event) {
return OSHAMNPXFT_OnFocus(event);
}
SPBOUILib.SetInputEnter('OSHAMNPXFT',OSHAMNPXFT_wrap_OnFocus);
function OSHAMNPXFT_wrap_Blur(event) {
return OSHAMNPXFT_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('OSHAMNPXFT',OSHAMNPXFT_wrap_Blur);
function ZHYZMPHABC_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ZHYZMPHABC_Click():void(0));
}
SPBOUILib.SetButtonClick('ZHYZMPHABC',ZHYZMPHABC_wrap_OnClick);
function ZHYZMPHABC_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('ZHYZMPHABC',ZHYZMPHABC_wrap_OnKeyDown);
function UETNARUDOE_wrap_Valid(event) {
return UETNARUDOE_Valid(event);
}
SPBOUILib.SetCheckboxClick('UETNARUDOE',UETNARUDOE_wrap_Valid);
function UETNARUDOE_wrap_OnFocus(event) {
return UETNARUDOE_OnFocus(event);
}
SPBOUILib.SetInputEnter('UETNARUDOE',UETNARUDOE_wrap_OnFocus);
function UETNARUDOE_wrap_Blur(event) {
return UETNARUDOE_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('UETNARUDOE',UETNARUDOE_wrap_Blur);
function UHGVOKNSVL_wrap_Valid(event) {
return UHGVOKNSVL_Valid(event);
}
SPBOUILib.SetCheckboxClick('UHGVOKNSVL',UHGVOKNSVL_wrap_Valid);
function UHGVOKNSVL_wrap_OnFocus(event) {
return UHGVOKNSVL_OnFocus(event);
}
SPBOUILib.SetInputEnter('UHGVOKNSVL',UHGVOKNSVL_wrap_OnFocus);
function UHGVOKNSVL_wrap_Blur(event) {
return UHGVOKNSVL_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('UHGVOKNSVL',UHGVOKNSVL_wrap_Blur);
function NLUIAOSQKM_wrap_Valid(event) {
return NLUIAOSQKM_Valid(event);
}
SPBOUILib.SetInputExit('NLUIAOSQKM',NLUIAOSQKM_wrap_Valid);
function NLUIAOSQKM_wrap_OnFocus(event) {
return NLUIAOSQKM_OnFocus(event);
}
SPBOUILib.SetInputEnter('NLUIAOSQKM',NLUIAOSQKM_wrap_OnFocus);
function NLUIAOSQKM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NLUIAOSQKM',NLUIAOSQKM_wrap_OnKeyDown);
function XDDITMPJIZ_wrap_Valid(event) {
return XDDITMPJIZ_Valid(event);
}
SPBOUILib.SetComboChange('XDDITMPJIZ',XDDITMPJIZ_wrap_Valid);
function XDDITMPJIZ_wrap_OnFocus(event) {
return XDDITMPJIZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('XDDITMPJIZ',XDDITMPJIZ_wrap_OnFocus);
function XDDITMPJIZ_wrap_Blur(event) {
return XDDITMPJIZ_OnBlur(event);
}
SPBOUILib.SetInputExit('XDDITMPJIZ',XDDITMPJIZ_wrap_Blur);
function LUPNVRRLHF_wrap_Valid(event) {
return LUPNVRRLHF_Valid(event);
}
SPBOUILib.SetCheckboxClick('LUPNVRRLHF',LUPNVRRLHF_wrap_Valid);
function LUPNVRRLHF_wrap_OnFocus(event) {
return LUPNVRRLHF_OnFocus(event);
}
SPBOUILib.SetInputEnter('LUPNVRRLHF',LUPNVRRLHF_wrap_OnFocus);
function LUPNVRRLHF_wrap_Blur(event) {
return LUPNVRRLHF_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('LUPNVRRLHF',LUPNVRRLHF_wrap_Blur);
function HFADCPKPNB_wrap_Valid(event) {
return HFADCPKPNB_Valid(event);
}
SPBOUILib.SetCheckboxClick('HFADCPKPNB',HFADCPKPNB_wrap_Valid);
function HFADCPKPNB_wrap_OnFocus(event) {
return HFADCPKPNB_OnFocus(event);
}
SPBOUILib.SetInputEnter('HFADCPKPNB',HFADCPKPNB_wrap_OnFocus);
function HFADCPKPNB_wrap_Blur(event) {
return HFADCPKPNB_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('HFADCPKPNB',HFADCPKPNB_wrap_Blur);
function ASIWFAENLM_wrap_Valid(event) {
return ASIWFAENLM_Valid(event);
}
SPBOUILib.SetInputExit('ASIWFAENLM',ASIWFAENLM_wrap_Valid);
function ASIWFAENLM_wrap_OnFocus(event) {
return ASIWFAENLM_OnFocus(event);
}
SPBOUILib.SetInputEnter('ASIWFAENLM',ASIWFAENLM_wrap_OnFocus);
function ASIWFAENLM_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('ASIWFAENLM',ASIWFAENLM_wrap_OnKeyPress);
function ASIWFAENLM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('ASIWFAENLM',ASIWFAENLM_wrap_OnKeyDown);
function ASIWFAENLM_ZOOM_setHandlers() {
function ASIWFAENLM_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ASIWFAENLM_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('ASIWFAENLM_ZOOM',ASIWFAENLM_ZOOM_wrap_OnClick);
function ASIWFAENLM_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('ASIWFAENLM_ZOOM',ASIWFAENLM_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('ASIWFAENLM',ASIWFAENLM_ZOOM_setHandlers);
function IOYUNQJDKZ_wrap_Valid(event) {
return IOYUNQJDKZ_Valid(event);
}
SPBOUILib.SetInputExit('IOYUNQJDKZ',IOYUNQJDKZ_wrap_Valid);
function IOYUNQJDKZ_wrap_OnFocus(event) {
return IOYUNQJDKZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('IOYUNQJDKZ',IOYUNQJDKZ_wrap_OnFocus);
function IOYUNQJDKZ_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('IOYUNQJDKZ',IOYUNQJDKZ_wrap_OnKeyPress);
function IOYUNQJDKZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('IOYUNQJDKZ',IOYUNQJDKZ_wrap_OnKeyDown);
function IOYUNQJDKZ_ZOOM_setHandlers() {
function IOYUNQJDKZ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?IOYUNQJDKZ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('IOYUNQJDKZ_ZOOM',IOYUNQJDKZ_ZOOM_wrap_OnClick);
function IOYUNQJDKZ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('IOYUNQJDKZ_ZOOM',IOYUNQJDKZ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('IOYUNQJDKZ',IOYUNQJDKZ_ZOOM_setHandlers);
function LSBZHECNKO_wrap_Valid(event) {
return LSBZHECNKO_Valid(event);
}
SPBOUILib.SetCheckboxClick('LSBZHECNKO',LSBZHECNKO_wrap_Valid);
function LSBZHECNKO_wrap_OnFocus(event) {
return LSBZHECNKO_OnFocus(event);
}
SPBOUILib.SetInputEnter('LSBZHECNKO',LSBZHECNKO_wrap_OnFocus);
function LSBZHECNKO_wrap_Blur(event) {
return LSBZHECNKO_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('LSBZHECNKO',LSBZHECNKO_wrap_Blur);
function FKIIMPSJSB_wrap_Valid(event) {
return FKIIMPSJSB_Valid(event);
}
SPBOUILib.SetInputExit('FKIIMPSJSB',FKIIMPSJSB_wrap_Valid);
function FKIIMPSJSB_wrap_OnFocus(event) {
return FKIIMPSJSB_OnFocus(event);
}
SPBOUILib.SetInputEnter('FKIIMPSJSB',FKIIMPSJSB_wrap_OnFocus);
function FKIIMPSJSB_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('FKIIMPSJSB',FKIIMPSJSB_wrap_OnKeyPress);
function FKIIMPSJSB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FKIIMPSJSB',FKIIMPSJSB_wrap_OnKeyDown);
function EQCSRKQZVC_wrap_Valid(event) {
return EQCSRKQZVC_Valid(event);
}
SPBOUILib.SetInputExit('EQCSRKQZVC',EQCSRKQZVC_wrap_Valid);
function EQCSRKQZVC_wrap_OnFocus(event) {
return EQCSRKQZVC_OnFocus(event);
}
SPBOUILib.SetInputEnter('EQCSRKQZVC',EQCSRKQZVC_wrap_OnFocus);
function EQCSRKQZVC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('EQCSRKQZVC',EQCSRKQZVC_wrap_OnKeyDown);
function KFQWZVCJIW_wrap_Valid(event) {
return KFQWZVCJIW_Valid(event);
}
SPBOUILib.SetCheckboxClick('KFQWZVCJIW',KFQWZVCJIW_wrap_Valid);
function KFQWZVCJIW_wrap_OnFocus(event) {
return KFQWZVCJIW_OnFocus(event);
}
SPBOUILib.SetInputEnter('KFQWZVCJIW',KFQWZVCJIW_wrap_OnFocus);
function KFQWZVCJIW_wrap_Blur(event) {
return KFQWZVCJIW_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('KFQWZVCJIW',KFQWZVCJIW_wrap_Blur);
function LGZDRUUSXZ_wrap_Valid(event) {
return LGZDRUUSXZ_Valid(event);
}
SPBOUILib.SetInputExit('LGZDRUUSXZ',LGZDRUUSXZ_wrap_Valid);
function LGZDRUUSXZ_wrap_OnFocus(event) {
return LGZDRUUSXZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('LGZDRUUSXZ',LGZDRUUSXZ_wrap_OnFocus);
function LGZDRUUSXZ_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('LGZDRUUSXZ',LGZDRUUSXZ_wrap_OnKeyPress);
function LGZDRUUSXZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LGZDRUUSXZ',LGZDRUUSXZ_wrap_OnKeyDown);
function FQKHRITNGP_wrap_Valid(event) {
return FQKHRITNGP_Valid(event);
}
SPBOUILib.SetInputExit('FQKHRITNGP',FQKHRITNGP_wrap_Valid);
function FQKHRITNGP_wrap_OnFocus(event) {
return FQKHRITNGP_OnFocus(event);
}
SPBOUILib.SetInputEnter('FQKHRITNGP',FQKHRITNGP_wrap_OnFocus);
function FQKHRITNGP_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('FQKHRITNGP',FQKHRITNGP_wrap_OnKeyPress);
function FQKHRITNGP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FQKHRITNGP',FQKHRITNGP_wrap_OnKeyDown);
function SIZHWNZUOT_wrap_Valid(event) {
return SIZHWNZUOT_Valid(event);
}
SPBOUILib.SetCheckboxClick('SIZHWNZUOT',SIZHWNZUOT_wrap_Valid);
function SIZHWNZUOT_wrap_OnFocus(event) {
return SIZHWNZUOT_OnFocus(event);
}
SPBOUILib.SetInputEnter('SIZHWNZUOT',SIZHWNZUOT_wrap_OnFocus);
function SIZHWNZUOT_wrap_Blur(event) {
return SIZHWNZUOT_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('SIZHWNZUOT',SIZHWNZUOT_wrap_Blur);
function QBHBPWJMOW_wrap_Valid(event) {
return QBHBPWJMOW_Valid(event);
}
SPBOUILib.SetInputExit('QBHBPWJMOW',QBHBPWJMOW_wrap_Valid);
function QBHBPWJMOW_wrap_OnFocus(event) {
return QBHBPWJMOW_OnFocus(event);
}
SPBOUILib.SetInputEnter('QBHBPWJMOW',QBHBPWJMOW_wrap_OnFocus);
function QBHBPWJMOW_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('QBHBPWJMOW',QBHBPWJMOW_wrap_OnKeyPress);
function QBHBPWJMOW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QBHBPWJMOW',QBHBPWJMOW_wrap_OnKeyDown);
function HXPRRNXNJO_wrap_Valid(event) {
return HXPRRNXNJO_Valid(event);
}
SPBOUILib.SetInputExit('HXPRRNXNJO',HXPRRNXNJO_wrap_Valid);
function HXPRRNXNJO_wrap_OnFocus(event) {
return HXPRRNXNJO_OnFocus(event);
}
SPBOUILib.SetInputEnter('HXPRRNXNJO',HXPRRNXNJO_wrap_OnFocus);
function HXPRRNXNJO_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('HXPRRNXNJO',HXPRRNXNJO_wrap_OnKeyPress);
function HXPRRNXNJO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HXPRRNXNJO',HXPRRNXNJO_wrap_OnKeyDown);
function AAIARGXIIW_wrap_Valid(event) {
return AAIARGXIIW_Valid(event);
}
SPBOUILib.SetInputExit('AAIARGXIIW',AAIARGXIIW_wrap_Valid);
function AAIARGXIIW_wrap_OnFocus(event) {
return AAIARGXIIW_OnFocus(event);
}
SPBOUILib.SetInputEnter('AAIARGXIIW',AAIARGXIIW_wrap_OnFocus);
function AAIARGXIIW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AAIARGXIIW',AAIARGXIIW_wrap_OnKeyDown);
function PLWDFUBDIP_wrap_Valid(event) {
return PLWDFUBDIP_Valid(event);
}
SPBOUILib.SetCheckboxClick('PLWDFUBDIP',PLWDFUBDIP_wrap_Valid);
function PLWDFUBDIP_wrap_OnFocus(event) {
return PLWDFUBDIP_OnFocus(event);
}
SPBOUILib.SetInputEnter('PLWDFUBDIP',PLWDFUBDIP_wrap_OnFocus);
function PLWDFUBDIP_wrap_Blur(event) {
return PLWDFUBDIP_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('PLWDFUBDIP',PLWDFUBDIP_wrap_Blur);
function PDLIXDKBWK_wrap_Valid(event) {
return PDLIXDKBWK_Valid(event);
}
SPBOUILib.SetCheckboxClick('PDLIXDKBWK',PDLIXDKBWK_wrap_Valid);
function PDLIXDKBWK_wrap_OnFocus(event) {
return PDLIXDKBWK_OnFocus(event);
}
SPBOUILib.SetInputEnter('PDLIXDKBWK',PDLIXDKBWK_wrap_OnFocus);
function PDLIXDKBWK_wrap_Blur(event) {
return PDLIXDKBWK_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('PDLIXDKBWK',PDLIXDKBWK_wrap_Blur);
function PVOEPQLJPS_wrap_Valid(event) {
return PVOEPQLJPS_Valid(event);
}
SPBOUILib.SetCheckboxClick('PVOEPQLJPS',PVOEPQLJPS_wrap_Valid);
function PVOEPQLJPS_wrap_OnFocus(event) {
return PVOEPQLJPS_OnFocus(event);
}
SPBOUILib.SetInputEnter('PVOEPQLJPS',PVOEPQLJPS_wrap_OnFocus);
function PVOEPQLJPS_wrap_Blur(event) {
return PVOEPQLJPS_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('PVOEPQLJPS',PVOEPQLJPS_wrap_Blur);
function FCXDRDCINI_wrap_Valid(event) {
return FCXDRDCINI_Valid(event);
}
SPBOUILib.SetCheckboxClick('FCXDRDCINI',FCXDRDCINI_wrap_Valid);
function FCXDRDCINI_wrap_OnFocus(event) {
return FCXDRDCINI_OnFocus(event);
}
SPBOUILib.SetInputEnter('FCXDRDCINI',FCXDRDCINI_wrap_OnFocus);
function FCXDRDCINI_wrap_Blur(event) {
return FCXDRDCINI_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('FCXDRDCINI',FCXDRDCINI_wrap_Blur);
function RBAZEQPPJI_wrap_Valid(event) {
return RBAZEQPPJI_Valid(event);
}
SPBOUILib.SetCheckboxClick('RBAZEQPPJI',RBAZEQPPJI_wrap_Valid);
function RBAZEQPPJI_wrap_OnFocus(event) {
return RBAZEQPPJI_OnFocus(event);
}
SPBOUILib.SetInputEnter('RBAZEQPPJI',RBAZEQPPJI_wrap_OnFocus);
function RBAZEQPPJI_wrap_Blur(event) {
return RBAZEQPPJI_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('RBAZEQPPJI',RBAZEQPPJI_wrap_Blur);
function VDJMSNZEEV_wrap_Valid(event) {
return VDJMSNZEEV_Valid(event);
}
SPBOUILib.SetInputExit('VDJMSNZEEV',VDJMSNZEEV_wrap_Valid);
function VDJMSNZEEV_wrap_OnFocus(event) {
return VDJMSNZEEV_OnFocus(event);
}
SPBOUILib.SetInputEnter('VDJMSNZEEV',VDJMSNZEEV_wrap_OnFocus);
function VDJMSNZEEV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VDJMSNZEEV',VDJMSNZEEV_wrap_OnKeyDown);
function LNADTKDHIZ_wrap_Valid(event) {
return LNADTKDHIZ_Valid(event);
}
SPBOUILib.SetInputExit('LNADTKDHIZ',LNADTKDHIZ_wrap_Valid);
function LNADTKDHIZ_wrap_OnFocus(event) {
return LNADTKDHIZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('LNADTKDHIZ',LNADTKDHIZ_wrap_OnFocus);
function LNADTKDHIZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LNADTKDHIZ',LNADTKDHIZ_wrap_OnKeyDown);
function XMAVZMPWRZ_wrap_Valid(event) {
return XMAVZMPWRZ_Valid(event);
}
SPBOUILib.SetCheckboxClick('XMAVZMPWRZ',XMAVZMPWRZ_wrap_Valid);
function XMAVZMPWRZ_wrap_OnFocus(event) {
return XMAVZMPWRZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('XMAVZMPWRZ',XMAVZMPWRZ_wrap_OnFocus);
function XMAVZMPWRZ_wrap_Blur(event) {
return XMAVZMPWRZ_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('XMAVZMPWRZ',XMAVZMPWRZ_wrap_Blur);
function BZARULYZUH_wrap_Valid(event) {
return BZARULYZUH_Valid(event);
}
SPBOUILib.SetInputExit('BZARULYZUH',BZARULYZUH_wrap_Valid);
function BZARULYZUH_wrap_OnFocus(event) {
return BZARULYZUH_OnFocus(event);
}
SPBOUILib.SetInputEnter('BZARULYZUH',BZARULYZUH_wrap_OnFocus);
function BZARULYZUH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BZARULYZUH',BZARULYZUH_wrap_OnKeyDown);
function CWFIJJMSTR_wrap_Valid(event) {
return CWFIJJMSTR_Valid(event);
}
SPBOUILib.SetInputExit('CWFIJJMSTR',CWFIJJMSTR_wrap_Valid);
function CWFIJJMSTR_wrap_OnFocus(event) {
return CWFIJJMSTR_OnFocus(event);
}
SPBOUILib.SetInputEnter('CWFIJJMSTR',CWFIJJMSTR_wrap_OnFocus);
function CWFIJJMSTR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CWFIJJMSTR',CWFIJJMSTR_wrap_OnKeyDown);
function YPHGLIUDNW_wrap_Valid(event) {
return YPHGLIUDNW_Valid(event);
}
SPBOUILib.SetInputExit('YPHGLIUDNW',YPHGLIUDNW_wrap_Valid);
function YPHGLIUDNW_wrap_OnFocus(event) {
return YPHGLIUDNW_OnFocus(event);
}
SPBOUILib.SetInputEnter('YPHGLIUDNW',YPHGLIUDNW_wrap_OnFocus);
function YPHGLIUDNW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YPHGLIUDNW',YPHGLIUDNW_wrap_OnKeyDown);
function HSAOKMBAUY_wrap_Valid(event) {
return HSAOKMBAUY_Valid(event);
}
SPBOUILib.SetInputExit('HSAOKMBAUY',HSAOKMBAUY_wrap_Valid);
function HSAOKMBAUY_wrap_OnFocus(event) {
return HSAOKMBAUY_OnFocus(event);
}
SPBOUILib.SetInputEnter('HSAOKMBAUY',HSAOKMBAUY_wrap_OnFocus);
function HSAOKMBAUY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HSAOKMBAUY',HSAOKMBAUY_wrap_OnKeyDown);
function LGVTLPSUGS_wrap_Valid(event) {
return LGVTLPSUGS_Valid(event);
}
SPBOUILib.SetInputExit('LGVTLPSUGS',LGVTLPSUGS_wrap_Valid);
function LGVTLPSUGS_wrap_OnFocus(event) {
return LGVTLPSUGS_OnFocus(event);
}
SPBOUILib.SetInputEnter('LGVTLPSUGS',LGVTLPSUGS_wrap_OnFocus);
function LGVTLPSUGS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LGVTLPSUGS',LGVTLPSUGS_wrap_OnKeyDown);
function KPSLGRAIIO_wrap_Valid(event) {
return KPSLGRAIIO_Valid(event);
}
SPBOUILib.SetCheckboxClick('KPSLGRAIIO',KPSLGRAIIO_wrap_Valid);
function KPSLGRAIIO_wrap_OnFocus(event) {
return KPSLGRAIIO_OnFocus(event);
}
SPBOUILib.SetInputEnter('KPSLGRAIIO',KPSLGRAIIO_wrap_OnFocus);
function KPSLGRAIIO_wrap_Blur(event) {
return KPSLGRAIIO_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('KPSLGRAIIO',KPSLGRAIIO_wrap_Blur);
function YRAEGOUXRJ_wrap_Valid(event) {
return YRAEGOUXRJ_Valid(event);
}
SPBOUILib.SetInputExit('YRAEGOUXRJ',YRAEGOUXRJ_wrap_Valid);
function YRAEGOUXRJ_wrap_OnFocus(event) {
return YRAEGOUXRJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('YRAEGOUXRJ',YRAEGOUXRJ_wrap_OnFocus);
function YRAEGOUXRJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YRAEGOUXRJ',YRAEGOUXRJ_wrap_OnKeyDown);
function OHRBGBCDVG_wrap_Valid(event) {
return OHRBGBCDVG_Valid(event);
}
SPBOUILib.SetInputExit('OHRBGBCDVG',OHRBGBCDVG_wrap_Valid);
function OHRBGBCDVG_wrap_OnFocus(event) {
return OHRBGBCDVG_OnFocus(event);
}
SPBOUILib.SetInputEnter('OHRBGBCDVG',OHRBGBCDVG_wrap_OnFocus);
function OHRBGBCDVG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OHRBGBCDVG',OHRBGBCDVG_wrap_OnKeyDown);
function KDJLQEMEDV_wrap_Valid(event) {
return KDJLQEMEDV_Valid(event);
}
SPBOUILib.SetInputExit('KDJLQEMEDV',KDJLQEMEDV_wrap_Valid);
function KDJLQEMEDV_wrap_OnFocus(event) {
return KDJLQEMEDV_OnFocus(event);
}
SPBOUILib.SetInputEnter('KDJLQEMEDV',KDJLQEMEDV_wrap_OnFocus);
function KDJLQEMEDV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KDJLQEMEDV',KDJLQEMEDV_wrap_OnKeyDown);
function VTFLIHXHLG_wrap_Valid(event) {
return VTFLIHXHLG_Valid(event);
}
SPBOUILib.SetInputExit('VTFLIHXHLG',VTFLIHXHLG_wrap_Valid);
function VTFLIHXHLG_wrap_OnFocus(event) {
return VTFLIHXHLG_OnFocus(event);
}
SPBOUILib.SetInputEnter('VTFLIHXHLG',VTFLIHXHLG_wrap_OnFocus);
function VTFLIHXHLG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VTFLIHXHLG',VTFLIHXHLG_wrap_OnKeyDown);
function SIJUUSKFLV_wrap_Valid(event) {
return SIJUUSKFLV_Valid(event);
}
SPBOUILib.SetComboChange('SIJUUSKFLV',SIJUUSKFLV_wrap_Valid);
function SIJUUSKFLV_wrap_OnFocus(event) {
return SIJUUSKFLV_OnFocus(event);
}
SPBOUILib.SetInputEnter('SIJUUSKFLV',SIJUUSKFLV_wrap_OnFocus);
function SIJUUSKFLV_wrap_Blur(event) {
return SIJUUSKFLV_OnBlur(event);
}
SPBOUILib.SetInputExit('SIJUUSKFLV',SIJUUSKFLV_wrap_Blur);
function XCZARGUGTG_wrap_Valid(event) {
return XCZARGUGTG_Valid(event);
}
SPBOUILib.SetInputExit('XCZARGUGTG',XCZARGUGTG_wrap_Valid);
function XCZARGUGTG_wrap_OnFocus(event) {
return XCZARGUGTG_OnFocus(event);
}
SPBOUILib.SetInputEnter('XCZARGUGTG',XCZARGUGTG_wrap_OnFocus);
function XCZARGUGTG_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('XCZARGUGTG',XCZARGUGTG_wrap_OnKeyPress);
function XCZARGUGTG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('XCZARGUGTG',XCZARGUGTG_wrap_OnKeyDown);
function XCZARGUGTG_ZOOM_setHandlers() {
function XCZARGUGTG_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?XCZARGUGTG_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('XCZARGUGTG_ZOOM',XCZARGUGTG_ZOOM_wrap_OnClick);
function XCZARGUGTG_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('XCZARGUGTG_ZOOM',XCZARGUGTG_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('XCZARGUGTG',XCZARGUGTG_ZOOM_setHandlers);
function PZGXGIZQWY_wrap_Valid(event) {
return PZGXGIZQWY_Valid(event);
}
SPBOUILib.SetInputExit('PZGXGIZQWY',PZGXGIZQWY_wrap_Valid);
function PZGXGIZQWY_wrap_OnFocus(event) {
return PZGXGIZQWY_OnFocus(event);
}
SPBOUILib.SetInputEnter('PZGXGIZQWY',PZGXGIZQWY_wrap_OnFocus);
function PZGXGIZQWY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PZGXGIZQWY',PZGXGIZQWY_wrap_OnKeyDown);
function PZGXGIZQWY_ZOOM_setHandlers() {
function PZGXGIZQWY_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?PZGXGIZQWY_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('PZGXGIZQWY_ZOOM',PZGXGIZQWY_ZOOM_wrap_OnClick);
function PZGXGIZQWY_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('PZGXGIZQWY_ZOOM',PZGXGIZQWY_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('PZGXGIZQWY',PZGXGIZQWY_ZOOM_setHandlers);
function WQWXGOLVXC_wrap_Valid(event) {
return WQWXGOLVXC_Valid(event);
}
SPBOUILib.SetComboChange('WQWXGOLVXC',WQWXGOLVXC_wrap_Valid);
function WQWXGOLVXC_wrap_OnFocus(event) {
return WQWXGOLVXC_OnFocus(event);
}
SPBOUILib.SetInputEnter('WQWXGOLVXC',WQWXGOLVXC_wrap_OnFocus);
function WQWXGOLVXC_wrap_Blur(event) {
return WQWXGOLVXC_OnBlur(event);
}
SPBOUILib.SetInputExit('WQWXGOLVXC',WQWXGOLVXC_wrap_Blur);
function DUROREWBNG_wrap_Valid(event) {
return DUROREWBNG_Valid(event);
}
SPBOUILib.SetInputExit('DUROREWBNG',DUROREWBNG_wrap_Valid);
function DUROREWBNG_wrap_OnFocus(event) {
return DUROREWBNG_OnFocus(event);
}
SPBOUILib.SetInputEnter('DUROREWBNG',DUROREWBNG_wrap_OnFocus);
function DUROREWBNG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DUROREWBNG',DUROREWBNG_wrap_OnKeyDown);
function DUROREWBNG_ZOOM_setHandlers() {
function DUROREWBNG_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?DUROREWBNG_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('DUROREWBNG_ZOOM',DUROREWBNG_ZOOM_wrap_OnClick);
function DUROREWBNG_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('DUROREWBNG_ZOOM',DUROREWBNG_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('DUROREWBNG',DUROREWBNG_ZOOM_setHandlers);
function ZTUIXEONYI_wrap_Valid(event) {
return ZTUIXEONYI_Valid(event);
}
SPBOUILib.SetInputExit('ZTUIXEONYI',ZTUIXEONYI_wrap_Valid);
function ZTUIXEONYI_wrap_OnFocus(event) {
return ZTUIXEONYI_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZTUIXEONYI',ZTUIXEONYI_wrap_OnFocus);
function ZTUIXEONYI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZTUIXEONYI',ZTUIXEONYI_wrap_OnKeyDown);
function ZTUIXEONYI_ZOOM_setHandlers() {
function ZTUIXEONYI_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ZTUIXEONYI_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('ZTUIXEONYI_ZOOM',ZTUIXEONYI_ZOOM_wrap_OnClick);
function ZTUIXEONYI_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('ZTUIXEONYI_ZOOM',ZTUIXEONYI_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('ZTUIXEONYI',ZTUIXEONYI_ZOOM_setHandlers);
function KSRCRPEMFT_wrap_Valid(event) {
return KSRCRPEMFT_Valid(event);
}
SPBOUILib.SetInputExit('KSRCRPEMFT',KSRCRPEMFT_wrap_Valid);
function KSRCRPEMFT_wrap_OnFocus(event) {
return KSRCRPEMFT_OnFocus(event);
}
SPBOUILib.SetInputEnter('KSRCRPEMFT',KSRCRPEMFT_wrap_OnFocus);
function KSRCRPEMFT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KSRCRPEMFT',KSRCRPEMFT_wrap_OnKeyDown);
function IYKMLTUWXM_wrap_Valid(event) {
return IYKMLTUWXM_Valid(event);
}
SPBOUILib.SetComboChange('IYKMLTUWXM',IYKMLTUWXM_wrap_Valid);
function IYKMLTUWXM_wrap_OnFocus(event) {
return IYKMLTUWXM_OnFocus(event);
}
SPBOUILib.SetInputEnter('IYKMLTUWXM',IYKMLTUWXM_wrap_OnFocus);
function IYKMLTUWXM_wrap_Blur(event) {
return IYKMLTUWXM_OnBlur(event);
}
SPBOUILib.SetInputExit('IYKMLTUWXM',IYKMLTUWXM_wrap_Blur);
function KYNLIGXUVC_wrap_Valid(event) {
return KYNLIGXUVC_Valid(event);
}
SPBOUILib.SetComboChange('KYNLIGXUVC',KYNLIGXUVC_wrap_Valid);
function KYNLIGXUVC_wrap_OnFocus(event) {
return KYNLIGXUVC_OnFocus(event);
}
SPBOUILib.SetInputEnter('KYNLIGXUVC',KYNLIGXUVC_wrap_OnFocus);
function KYNLIGXUVC_wrap_Blur(event) {
return KYNLIGXUVC_OnBlur(event);
}
SPBOUILib.SetInputExit('KYNLIGXUVC',KYNLIGXUVC_wrap_Blur);
function IAXBQWHGLM_wrap_Valid(event) {
return IAXBQWHGLM_Valid(event);
}
SPBOUILib.SetInputExit('IAXBQWHGLM',IAXBQWHGLM_wrap_Valid);
function IAXBQWHGLM_wrap_OnFocus(event) {
return IAXBQWHGLM_OnFocus(event);
}
SPBOUILib.SetInputEnter('IAXBQWHGLM',IAXBQWHGLM_wrap_OnFocus);
function IAXBQWHGLM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IAXBQWHGLM',IAXBQWHGLM_wrap_OnKeyDown);
function PBQXUDZUOZ_wrap_Valid(event) {
return PBQXUDZUOZ_Valid(event);
}
SPBOUILib.SetInputExit('PBQXUDZUOZ',PBQXUDZUOZ_wrap_Valid);
function PBQXUDZUOZ_wrap_OnFocus(event) {
return PBQXUDZUOZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('PBQXUDZUOZ',PBQXUDZUOZ_wrap_OnFocus);
function PBQXUDZUOZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PBQXUDZUOZ',PBQXUDZUOZ_wrap_OnKeyDown);
function UBNVJIYFWU_wrap_Valid(event) {
return UBNVJIYFWU_Valid(event);
}
SPBOUILib.SetInputExit('UBNVJIYFWU',UBNVJIYFWU_wrap_Valid);
function UBNVJIYFWU_wrap_OnFocus(event) {
return UBNVJIYFWU_OnFocus(event);
}
SPBOUILib.SetInputEnter('UBNVJIYFWU',UBNVJIYFWU_wrap_OnFocus);
function UBNVJIYFWU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UBNVJIYFWU',UBNVJIYFWU_wrap_OnKeyDown);
function PELELICXZD_wrap_Valid(event) {
return PELELICXZD_Valid(event);
}
SPBOUILib.SetInputExit('PELELICXZD',PELELICXZD_wrap_Valid);
function PELELICXZD_wrap_OnFocus(event) {
return PELELICXZD_OnFocus(event);
}
SPBOUILib.SetInputEnter('PELELICXZD',PELELICXZD_wrap_OnFocus);
function PELELICXZD_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PELELICXZD',PELELICXZD_wrap_OnKeyDown);
function DZVDAZOPWP_wrap_Valid(event) {
return DZVDAZOPWP_Valid(event);
}
SPBOUILib.SetInputExit('DZVDAZOPWP',DZVDAZOPWP_wrap_Valid);
function DZVDAZOPWP_wrap_OnFocus(event) {
return DZVDAZOPWP_OnFocus(event);
}
SPBOUILib.SetInputEnter('DZVDAZOPWP',DZVDAZOPWP_wrap_OnFocus);
function DZVDAZOPWP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DZVDAZOPWP',DZVDAZOPWP_wrap_OnKeyDown);
function HRZVDXDSOJ_wrap_Valid(event) {
return HRZVDXDSOJ_Valid(event);
}
SPBOUILib.SetInputExit('HRZVDXDSOJ',HRZVDXDSOJ_wrap_Valid);
function HRZVDXDSOJ_wrap_OnFocus(event) {
return HRZVDXDSOJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('HRZVDXDSOJ',HRZVDXDSOJ_wrap_OnFocus);
function HRZVDXDSOJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HRZVDXDSOJ',HRZVDXDSOJ_wrap_OnKeyDown);
function TFDNMJLIWF_wrap_Valid(event) {
return TFDNMJLIWF_Valid(event);
}
SPBOUILib.SetInputExit('TFDNMJLIWF',TFDNMJLIWF_wrap_Valid);
function TFDNMJLIWF_wrap_OnFocus(event) {
return TFDNMJLIWF_OnFocus(event);
}
SPBOUILib.SetInputEnter('TFDNMJLIWF',TFDNMJLIWF_wrap_OnFocus);
function TFDNMJLIWF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TFDNMJLIWF',TFDNMJLIWF_wrap_OnKeyDown);
function WRRSZRBPCI_wrap_Valid(event) {
return WRRSZRBPCI_Valid(event);
}
SPBOUILib.SetInputExit('WRRSZRBPCI',WRRSZRBPCI_wrap_Valid);
function WRRSZRBPCI_wrap_OnFocus(event) {
return WRRSZRBPCI_OnFocus(event);
}
SPBOUILib.SetInputEnter('WRRSZRBPCI',WRRSZRBPCI_wrap_OnFocus);
function WRRSZRBPCI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WRRSZRBPCI',WRRSZRBPCI_wrap_OnKeyDown);
function PUFIBBLEMQ_wrap_Valid(event) {
return PUFIBBLEMQ_Valid(event);
}
SPBOUILib.SetInputExit('PUFIBBLEMQ',PUFIBBLEMQ_wrap_Valid);
function PUFIBBLEMQ_wrap_OnFocus(event) {
return PUFIBBLEMQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('PUFIBBLEMQ',PUFIBBLEMQ_wrap_OnFocus);
function PUFIBBLEMQ_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('PUFIBBLEMQ',PUFIBBLEMQ_wrap_OnKeyPress);
function PUFIBBLEMQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PUFIBBLEMQ',PUFIBBLEMQ_wrap_OnKeyDown);
function MBMIGFSBXO_wrap_Valid(event) {
return MBMIGFSBXO_Valid(event);
}
SPBOUILib.SetInputExit('MBMIGFSBXO',MBMIGFSBXO_wrap_Valid);
function MBMIGFSBXO_wrap_OnFocus(event) {
return MBMIGFSBXO_OnFocus(event);
}
SPBOUILib.SetInputEnter('MBMIGFSBXO',MBMIGFSBXO_wrap_OnFocus);
function MBMIGFSBXO_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('MBMIGFSBXO',MBMIGFSBXO_wrap_OnKeyPress);
function MBMIGFSBXO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MBMIGFSBXO',MBMIGFSBXO_wrap_OnKeyDown);
function XUNVKFSSZL_wrap_Valid(event) {
return XUNVKFSSZL_Valid(event);
}
SPBOUILib.SetInputExit('XUNVKFSSZL',XUNVKFSSZL_wrap_Valid);
function XUNVKFSSZL_wrap_OnFocus(event) {
return XUNVKFSSZL_OnFocus(event);
}
SPBOUILib.SetInputEnter('XUNVKFSSZL',XUNVKFSSZL_wrap_OnFocus);
function XUNVKFSSZL_wrap_OnKeyPress(event) {
return XUNVKFSSZL_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('XUNVKFSSZL',XUNVKFSSZL_wrap_OnKeyPress);
function XUNVKFSSZL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XUNVKFSSZL',XUNVKFSSZL_wrap_OnKeyDown);
function CMBYXKAJCS_wrap_Valid(event) {
return CMBYXKAJCS_Valid(event);
}
SPBOUILib.SetInputExit('CMBYXKAJCS',CMBYXKAJCS_wrap_Valid);
function CMBYXKAJCS_wrap_OnFocus(event) {
return CMBYXKAJCS_OnFocus(event);
}
SPBOUILib.SetInputEnter('CMBYXKAJCS',CMBYXKAJCS_wrap_OnFocus);
function CMBYXKAJCS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CMBYXKAJCS',CMBYXKAJCS_wrap_OnKeyDown);
function CNQFAHXNUY_wrap_Valid(event) {
return CNQFAHXNUY_Valid(event);
}
SPBOUILib.SetInputExit('CNQFAHXNUY',CNQFAHXNUY_wrap_Valid);
function CNQFAHXNUY_wrap_OnFocus(event) {
return CNQFAHXNUY_OnFocus(event);
}
SPBOUILib.SetInputEnter('CNQFAHXNUY',CNQFAHXNUY_wrap_OnFocus);
function CNQFAHXNUY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CNQFAHXNUY',CNQFAHXNUY_wrap_OnKeyDown);
function PUYJXGBDJI_wrap_Valid(event) {
return PUYJXGBDJI_Valid(event);
}
SPBOUILib.SetInputExit('PUYJXGBDJI',PUYJXGBDJI_wrap_Valid);
function PUYJXGBDJI_wrap_OnFocus(event) {
return PUYJXGBDJI_OnFocus(event);
}
SPBOUILib.SetInputEnter('PUYJXGBDJI',PUYJXGBDJI_wrap_OnFocus);
function PUYJXGBDJI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PUYJXGBDJI',PUYJXGBDJI_wrap_OnKeyDown);
function DNCMAAILTV_wrap_Valid(event) {
return DNCMAAILTV_Valid(event);
}
SPBOUILib.SetInputExit('DNCMAAILTV',DNCMAAILTV_wrap_Valid);
function DNCMAAILTV_wrap_OnFocus(event) {
return DNCMAAILTV_OnFocus(event);
}
SPBOUILib.SetInputEnter('DNCMAAILTV',DNCMAAILTV_wrap_OnFocus);
function DNCMAAILTV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DNCMAAILTV',DNCMAAILTV_wrap_OnKeyDown);
function UMEMYFCVBI_wrap_Valid(event) {
return UMEMYFCVBI_Valid(event);
}
SPBOUILib.SetInputExit('UMEMYFCVBI',UMEMYFCVBI_wrap_Valid);
function UMEMYFCVBI_wrap_OnFocus(event) {
return UMEMYFCVBI_OnFocus(event);
}
SPBOUILib.SetInputEnter('UMEMYFCVBI',UMEMYFCVBI_wrap_OnFocus);
function UMEMYFCVBI_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('UMEMYFCVBI',UMEMYFCVBI_wrap_OnKeyPress);
function UMEMYFCVBI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UMEMYFCVBI',UMEMYFCVBI_wrap_OnKeyDown);
function ZFUOSYKTGZ_wrap_Valid(event) {
return ZFUOSYKTGZ_Valid(event);
}
SPBOUILib.SetInputExit('ZFUOSYKTGZ',ZFUOSYKTGZ_wrap_Valid);
function ZFUOSYKTGZ_wrap_OnFocus(event) {
return ZFUOSYKTGZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZFUOSYKTGZ',ZFUOSYKTGZ_wrap_OnFocus);
function ZFUOSYKTGZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZFUOSYKTGZ',ZFUOSYKTGZ_wrap_OnKeyDown);
function ECARBEFMBC_wrap_Valid(event) {
return ECARBEFMBC_Valid(event);
}
SPBOUILib.SetComboChange('ECARBEFMBC',ECARBEFMBC_wrap_Valid);
function ECARBEFMBC_wrap_OnFocus(event) {
return ECARBEFMBC_OnFocus(event);
}
SPBOUILib.SetInputEnter('ECARBEFMBC',ECARBEFMBC_wrap_OnFocus);
function ECARBEFMBC_wrap_Blur(event) {
return ECARBEFMBC_OnBlur(event);
}
SPBOUILib.SetInputExit('ECARBEFMBC',ECARBEFMBC_wrap_Blur);
function DNNGPDMXQI_wrap_Valid(event) {
return DNNGPDMXQI_Valid(event);
}
SPBOUILib.SetInputExit('DNNGPDMXQI',DNNGPDMXQI_wrap_Valid);
function DNNGPDMXQI_wrap_OnFocus(event) {
return DNNGPDMXQI_OnFocus(event);
}
SPBOUILib.SetInputEnter('DNNGPDMXQI',DNNGPDMXQI_wrap_OnFocus);
function DNNGPDMXQI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DNNGPDMXQI',DNNGPDMXQI_wrap_OnKeyDown);
function WHJVJHBKYI_wrap_Valid(event) {
return WHJVJHBKYI_Valid(event);
}
SPBOUILib.SetInputExit('WHJVJHBKYI',WHJVJHBKYI_wrap_Valid);
function WHJVJHBKYI_wrap_OnFocus(event) {
return WHJVJHBKYI_OnFocus(event);
}
SPBOUILib.SetInputEnter('WHJVJHBKYI',WHJVJHBKYI_wrap_OnFocus);
function WHJVJHBKYI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WHJVJHBKYI',WHJVJHBKYI_wrap_OnKeyDown);
function ZZSBUTEXWS_wrap_Valid(event) {
return ZZSBUTEXWS_Valid(event);
}
SPBOUILib.SetInputExit('ZZSBUTEXWS',ZZSBUTEXWS_wrap_Valid);
function ZZSBUTEXWS_wrap_OnFocus(event) {
return ZZSBUTEXWS_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZZSBUTEXWS',ZZSBUTEXWS_wrap_OnFocus);
function ZZSBUTEXWS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZZSBUTEXWS',ZZSBUTEXWS_wrap_OnKeyDown);
function XRGIDJXVCB_wrap_Valid(event) {
return XRGIDJXVCB_Valid(event);
}
SPBOUILib.SetInputExit('XRGIDJXVCB',XRGIDJXVCB_wrap_Valid);
function XRGIDJXVCB_wrap_OnFocus(event) {
return XRGIDJXVCB_OnFocus(event);
}
SPBOUILib.SetInputEnter('XRGIDJXVCB',XRGIDJXVCB_wrap_OnFocus);
function XRGIDJXVCB_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('XRGIDJXVCB',XRGIDJXVCB_wrap_OnKeyPress);
function XRGIDJXVCB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XRGIDJXVCB',XRGIDJXVCB_wrap_OnKeyDown);
function CZINOLQOUB_wrap_Valid(event) {
return CZINOLQOUB_Valid(event);
}
SPBOUILib.SetCheckboxClick('CZINOLQOUB',CZINOLQOUB_wrap_Valid);
function CZINOLQOUB_wrap_OnFocus(event) {
return CZINOLQOUB_OnFocus(event);
}
SPBOUILib.SetInputEnter('CZINOLQOUB',CZINOLQOUB_wrap_OnFocus);
function CZINOLQOUB_wrap_Blur(event) {
return CZINOLQOUB_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('CZINOLQOUB',CZINOLQOUB_wrap_Blur);
function BMMUPRLVUU_wrap_Valid(event) {
return BMMUPRLVUU_Valid(event);
}
SPBOUILib.SetInputExit('BMMUPRLVUU',BMMUPRLVUU_wrap_Valid);
function BMMUPRLVUU_wrap_OnFocus(event) {
return BMMUPRLVUU_OnFocus(event);
}
SPBOUILib.SetInputEnter('BMMUPRLVUU',BMMUPRLVUU_wrap_OnFocus);
function BMMUPRLVUU_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('BMMUPRLVUU',BMMUPRLVUU_wrap_OnKeyPress);
function BMMUPRLVUU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BMMUPRLVUU',BMMUPRLVUU_wrap_OnKeyDown);
function JFMMDZQFJC_wrap_Valid(event) {
return JFMMDZQFJC_Valid(event);
}
SPBOUILib.SetInputExit('JFMMDZQFJC',JFMMDZQFJC_wrap_Valid);
function JFMMDZQFJC_wrap_OnFocus(event) {
return JFMMDZQFJC_OnFocus(event);
}
SPBOUILib.SetInputEnter('JFMMDZQFJC',JFMMDZQFJC_wrap_OnFocus);
function JFMMDZQFJC_wrap_OnKeyPress(event) {
return JFMMDZQFJC_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('JFMMDZQFJC',JFMMDZQFJC_wrap_OnKeyPress);
function JFMMDZQFJC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JFMMDZQFJC',JFMMDZQFJC_wrap_OnKeyDown);
function OHKFECVWFV_wrap_Valid(event) {
return OHKFECVWFV_Valid(event);
}
SPBOUILib.SetInputExit('OHKFECVWFV',OHKFECVWFV_wrap_Valid);
function OHKFECVWFV_wrap_OnFocus(event) {
return OHKFECVWFV_OnFocus(event);
}
SPBOUILib.SetInputEnter('OHKFECVWFV',OHKFECVWFV_wrap_OnFocus);
function OHKFECVWFV_wrap_OnKeyPress(event) {
return OHKFECVWFV_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('OHKFECVWFV',OHKFECVWFV_wrap_OnKeyPress);
function OHKFECVWFV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OHKFECVWFV',OHKFECVWFV_wrap_OnKeyDown);
function OOAVIAADZS_wrap_Valid(event) {
return OOAVIAADZS_Valid(event);
}
SPBOUILib.SetCheckboxClick('OOAVIAADZS',OOAVIAADZS_wrap_Valid);
function OOAVIAADZS_wrap_OnFocus(event) {
return OOAVIAADZS_OnFocus(event);
}
SPBOUILib.SetInputEnter('OOAVIAADZS',OOAVIAADZS_wrap_OnFocus);
function OOAVIAADZS_wrap_Blur(event) {
return OOAVIAADZS_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('OOAVIAADZS',OOAVIAADZS_wrap_Blur);
function MRWHAAPELH_wrap_Valid(event) {
return MRWHAAPELH_Valid(event);
}
SPBOUILib.SetCheckboxClick('MRWHAAPELH',MRWHAAPELH_wrap_Valid);
function MRWHAAPELH_wrap_OnFocus(event) {
return MRWHAAPELH_OnFocus(event);
}
SPBOUILib.SetInputEnter('MRWHAAPELH',MRWHAAPELH_wrap_OnFocus);
function MRWHAAPELH_wrap_Blur(event) {
return MRWHAAPELH_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('MRWHAAPELH',MRWHAAPELH_wrap_Blur);
function HBTCFEMATT_wrap_Valid(event) {
return HBTCFEMATT_Valid(event);
}
SPBOUILib.SetCheckboxClick('HBTCFEMATT',HBTCFEMATT_wrap_Valid);
function HBTCFEMATT_wrap_OnFocus(event) {
return HBTCFEMATT_OnFocus(event);
}
SPBOUILib.SetInputEnter('HBTCFEMATT',HBTCFEMATT_wrap_OnFocus);
function HBTCFEMATT_wrap_Blur(event) {
return HBTCFEMATT_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('HBTCFEMATT',HBTCFEMATT_wrap_Blur);
function FOTKWJQFAL_wrap_Valid(event) {
return FOTKWJQFAL_Valid(event);
}
SPBOUILib.SetInputExit('FOTKWJQFAL',FOTKWJQFAL_wrap_Valid);
function FOTKWJQFAL_wrap_OnFocus(event) {
return FOTKWJQFAL_OnFocus(event);
}
SPBOUILib.SetInputEnter('FOTKWJQFAL',FOTKWJQFAL_wrap_OnFocus);
function FOTKWJQFAL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FOTKWJQFAL',FOTKWJQFAL_wrap_OnKeyDown);
function QMOTVZANBJ_wrap_Valid(event) {
return QMOTVZANBJ_Valid(event);
}
SPBOUILib.SetCheckboxClick('QMOTVZANBJ',QMOTVZANBJ_wrap_Valid);
function QMOTVZANBJ_wrap_OnFocus(event) {
return QMOTVZANBJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('QMOTVZANBJ',QMOTVZANBJ_wrap_OnFocus);
function QMOTVZANBJ_wrap_Blur(event) {
return QMOTVZANBJ_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('QMOTVZANBJ',QMOTVZANBJ_wrap_Blur);
function ROVOSMARIB_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ROVOSMARIB_Click():void(0));
}
SPBOUILib.SetButtonClick('ROVOSMARIB',ROVOSMARIB_wrap_OnClick);
function ROVOSMARIB_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('ROVOSMARIB',ROVOSMARIB_wrap_OnKeyDown);
function JPABVPZDBZ_wrap_Valid(event) {
return JPABVPZDBZ_Valid(event);
}
SPBOUILib.SetInputExit('JPABVPZDBZ',JPABVPZDBZ_wrap_Valid);
function JPABVPZDBZ_wrap_OnFocus(event) {
return JPABVPZDBZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('JPABVPZDBZ',JPABVPZDBZ_wrap_OnFocus);
function JPABVPZDBZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JPABVPZDBZ',JPABVPZDBZ_wrap_OnKeyDown);
function VJPULIZVKG_wrap_Valid(event) {
return VJPULIZVKG_Valid(event);
}
SPBOUILib.SetCheckboxClick('VJPULIZVKG',VJPULIZVKG_wrap_Valid);
function VJPULIZVKG_wrap_OnFocus(event) {
return VJPULIZVKG_OnFocus(event);
}
SPBOUILib.SetInputEnter('VJPULIZVKG',VJPULIZVKG_wrap_OnFocus);
function VJPULIZVKG_wrap_Blur(event) {
return VJPULIZVKG_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('VJPULIZVKG',VJPULIZVKG_wrap_Blur);
function EMDHDDRUPP_wrap_Valid(event) {
return EMDHDDRUPP_Valid(event);
}
SPBOUILib.SetInputExit('EMDHDDRUPP',EMDHDDRUPP_wrap_Valid);
function EMDHDDRUPP_wrap_OnFocus(event) {
return EMDHDDRUPP_OnFocus(event);
}
SPBOUILib.SetInputEnter('EMDHDDRUPP',EMDHDDRUPP_wrap_OnFocus);
function EMDHDDRUPP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('EMDHDDRUPP',EMDHDDRUPP_wrap_OnKeyDown);
function WXRSSFBXYH_wrap_Valid(event) {
return WXRSSFBXYH_Valid(event);
}
SPBOUILib.SetInputExit('WXRSSFBXYH',WXRSSFBXYH_wrap_Valid);
function WXRSSFBXYH_wrap_OnFocus(event) {
return WXRSSFBXYH_OnFocus(event);
}
SPBOUILib.SetInputEnter('WXRSSFBXYH',WXRSSFBXYH_wrap_OnFocus);
function WXRSSFBXYH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WXRSSFBXYH',WXRSSFBXYH_wrap_OnKeyDown);
function WPPFTLWEWX_wrap_Valid(event) {
return WPPFTLWEWX_Valid(event);
}
SPBOUILib.SetInputExit('WPPFTLWEWX',WPPFTLWEWX_wrap_Valid);
function WPPFTLWEWX_wrap_OnFocus(event) {
return WPPFTLWEWX_OnFocus(event);
}
SPBOUILib.SetInputEnter('WPPFTLWEWX',WPPFTLWEWX_wrap_OnFocus);
function WPPFTLWEWX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WPPFTLWEWX',WPPFTLWEWX_wrap_OnKeyDown);
function KZJBLRRDWP_wrap_Valid(event) {
return KZJBLRRDWP_Valid(event);
}
SPBOUILib.SetCheckboxClick('KZJBLRRDWP',KZJBLRRDWP_wrap_Valid);
function KZJBLRRDWP_wrap_OnFocus(event) {
return KZJBLRRDWP_OnFocus(event);
}
SPBOUILib.SetInputEnter('KZJBLRRDWP',KZJBLRRDWP_wrap_OnFocus);
function KZJBLRRDWP_wrap_Blur(event) {
return KZJBLRRDWP_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('KZJBLRRDWP',KZJBLRRDWP_wrap_Blur);
function PUWCGJFLDF_wrap_Valid(event) {
return PUWCGJFLDF_Valid(event);
}
SPBOUILib.SetInputExit('PUWCGJFLDF',PUWCGJFLDF_wrap_Valid);
function PUWCGJFLDF_wrap_OnFocus(event) {
return PUWCGJFLDF_OnFocus(event);
}
SPBOUILib.SetInputEnter('PUWCGJFLDF',PUWCGJFLDF_wrap_OnFocus);
function PUWCGJFLDF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PUWCGJFLDF',PUWCGJFLDF_wrap_OnKeyDown);
function NVZYOQAKDU_wrap_Valid(event) {
return NVZYOQAKDU_Valid(event);
}
SPBOUILib.SetInputExit('NVZYOQAKDU',NVZYOQAKDU_wrap_Valid);
function NVZYOQAKDU_wrap_OnFocus(event) {
return NVZYOQAKDU_OnFocus(event);
}
SPBOUILib.SetInputEnter('NVZYOQAKDU',NVZYOQAKDU_wrap_OnFocus);
function NVZYOQAKDU_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('NVZYOQAKDU',NVZYOQAKDU_wrap_OnKeyPress);
function NVZYOQAKDU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NVZYOQAKDU',NVZYOQAKDU_wrap_OnKeyDown);
function MHHQTFPDEN_wrap_Valid(event) {
return MHHQTFPDEN_Valid(event);
}
SPBOUILib.SetCheckboxClick('MHHQTFPDEN',MHHQTFPDEN_wrap_Valid);
function MHHQTFPDEN_wrap_OnFocus(event) {
return MHHQTFPDEN_OnFocus(event);
}
SPBOUILib.SetInputEnter('MHHQTFPDEN',MHHQTFPDEN_wrap_OnFocus);
function MHHQTFPDEN_wrap_Blur(event) {
return MHHQTFPDEN_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('MHHQTFPDEN',MHHQTFPDEN_wrap_Blur);
function SSXDYZLCUX_wrap_Valid(event) {
return SSXDYZLCUX_Valid(event);
}
SPBOUILib.SetCheckboxClick('SSXDYZLCUX',SSXDYZLCUX_wrap_Valid);
function SSXDYZLCUX_wrap_OnFocus(event) {
return SSXDYZLCUX_OnFocus(event);
}
SPBOUILib.SetInputEnter('SSXDYZLCUX',SSXDYZLCUX_wrap_OnFocus);
function SSXDYZLCUX_wrap_Blur(event) {
return SSXDYZLCUX_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('SSXDYZLCUX',SSXDYZLCUX_wrap_Blur);
function XVGAGFPMXP_wrap_Valid(event) {
return XVGAGFPMXP_Valid(event);
}
SPBOUILib.SetInputExit('XVGAGFPMXP',XVGAGFPMXP_wrap_Valid);
function XVGAGFPMXP_wrap_OnFocus(event) {
return XVGAGFPMXP_OnFocus(event);
}
SPBOUILib.SetInputEnter('XVGAGFPMXP',XVGAGFPMXP_wrap_OnFocus);
function XVGAGFPMXP_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('XVGAGFPMXP',XVGAGFPMXP_wrap_OnKeyPress);
function XVGAGFPMXP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XVGAGFPMXP',XVGAGFPMXP_wrap_OnKeyDown);
function ABGLJLFEYQ_wrap_Valid(event) {
return ABGLJLFEYQ_Valid(event);
}
SPBOUILib.SetCheckboxClick('ABGLJLFEYQ',ABGLJLFEYQ_wrap_Valid);
function ABGLJLFEYQ_wrap_OnFocus(event) {
return ABGLJLFEYQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('ABGLJLFEYQ',ABGLJLFEYQ_wrap_OnFocus);
function ABGLJLFEYQ_wrap_Blur(event) {
return ABGLJLFEYQ_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('ABGLJLFEYQ',ABGLJLFEYQ_wrap_Blur);
function MLYQUOWFHN_wrap_Valid(event) {
return MLYQUOWFHN_Valid(event);
}
SPBOUILib.SetInputExit('MLYQUOWFHN',MLYQUOWFHN_wrap_Valid);
function MLYQUOWFHN_wrap_OnFocus(event) {
return MLYQUOWFHN_OnFocus(event);
}
SPBOUILib.SetInputEnter('MLYQUOWFHN',MLYQUOWFHN_wrap_OnFocus);
function MLYQUOWFHN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MLYQUOWFHN',MLYQUOWFHN_wrap_OnKeyDown);
function VRYHAZPGSR_wrap_Valid(event) {
return VRYHAZPGSR_Valid(event);
}
SPBOUILib.SetInputExit('VRYHAZPGSR',VRYHAZPGSR_wrap_Valid);
function VRYHAZPGSR_wrap_OnFocus(event) {
return VRYHAZPGSR_OnFocus(event);
}
SPBOUILib.SetInputEnter('VRYHAZPGSR',VRYHAZPGSR_wrap_OnFocus);
function VRYHAZPGSR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VRYHAZPGSR',VRYHAZPGSR_wrap_OnKeyDown);
function TYOXRXGXKJ_wrap_Valid(event) {
return TYOXRXGXKJ_Valid(event);
}
SPBOUILib.SetInputExit('TYOXRXGXKJ',TYOXRXGXKJ_wrap_Valid);
function TYOXRXGXKJ_wrap_OnFocus(event) {
return TYOXRXGXKJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('TYOXRXGXKJ',TYOXRXGXKJ_wrap_OnFocus);
function TYOXRXGXKJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TYOXRXGXKJ',TYOXRXGXKJ_wrap_OnKeyDown);
function OKEJPCYNVH_wrap_Valid(event) {
return OKEJPCYNVH_Valid(event);
}
SPBOUILib.SetInputExit('OKEJPCYNVH',OKEJPCYNVH_wrap_Valid);
function OKEJPCYNVH_wrap_OnFocus(event) {
return OKEJPCYNVH_OnFocus(event);
}
SPBOUILib.SetInputEnter('OKEJPCYNVH',OKEJPCYNVH_wrap_OnFocus);
function OKEJPCYNVH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OKEJPCYNVH',OKEJPCYNVH_wrap_OnKeyDown);
function IIVBDSFKCC_wrap_Valid(event) {
return IIVBDSFKCC_Valid(event);
}
SPBOUILib.SetInputExit('IIVBDSFKCC',IIVBDSFKCC_wrap_Valid);
function IIVBDSFKCC_wrap_OnFocus(event) {
return IIVBDSFKCC_OnFocus(event);
}
SPBOUILib.SetInputEnter('IIVBDSFKCC',IIVBDSFKCC_wrap_OnFocus);
function IIVBDSFKCC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IIVBDSFKCC',IIVBDSFKCC_wrap_OnKeyDown);
function FYAHSLEGLP_wrap_Valid(event) {
return FYAHSLEGLP_Valid(event);
}
SPBOUILib.SetCheckboxClick('FYAHSLEGLP',FYAHSLEGLP_wrap_Valid);
function FYAHSLEGLP_wrap_OnFocus(event) {
return FYAHSLEGLP_OnFocus(event);
}
SPBOUILib.SetInputEnter('FYAHSLEGLP',FYAHSLEGLP_wrap_OnFocus);
function FYAHSLEGLP_wrap_Blur(event) {
return FYAHSLEGLP_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('FYAHSLEGLP',FYAHSLEGLP_wrap_Blur);
function MUANKUGIIK_wrap_Valid(event) {
return MUANKUGIIK_Valid(event);
}
SPBOUILib.SetInputExit('MUANKUGIIK',MUANKUGIIK_wrap_Valid);
function MUANKUGIIK_wrap_OnFocus(event) {
return MUANKUGIIK_OnFocus(event);
}
SPBOUILib.SetInputEnter('MUANKUGIIK',MUANKUGIIK_wrap_OnFocus);
function MUANKUGIIK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MUANKUGIIK',MUANKUGIIK_wrap_OnKeyDown);
function HFVZAFILCA_wrap_Valid(event) {
return HFVZAFILCA_Valid(event);
}
SPBOUILib.SetInputExit('HFVZAFILCA',HFVZAFILCA_wrap_Valid);
function HFVZAFILCA_wrap_OnFocus(event) {
return HFVZAFILCA_OnFocus(event);
}
SPBOUILib.SetInputEnter('HFVZAFILCA',HFVZAFILCA_wrap_OnFocus);
function HFVZAFILCA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HFVZAFILCA',HFVZAFILCA_wrap_OnKeyDown);
function RNIWEERJDP_wrap_Valid(event) {
return RNIWEERJDP_Valid(event);
}
SPBOUILib.SetInputExit('RNIWEERJDP',RNIWEERJDP_wrap_Valid);
function RNIWEERJDP_wrap_OnFocus(event) {
return RNIWEERJDP_OnFocus(event);
}
SPBOUILib.SetInputEnter('RNIWEERJDP',RNIWEERJDP_wrap_OnFocus);
function RNIWEERJDP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RNIWEERJDP',RNIWEERJDP_wrap_OnKeyDown);
function LZEBZLGWCH_wrap_Valid(event) {
return LZEBZLGWCH_Valid(event);
}
SPBOUILib.SetInputExit('LZEBZLGWCH',LZEBZLGWCH_wrap_Valid);
function LZEBZLGWCH_wrap_OnFocus(event) {
return LZEBZLGWCH_OnFocus(event);
}
SPBOUILib.SetInputEnter('LZEBZLGWCH',LZEBZLGWCH_wrap_OnFocus);
function LZEBZLGWCH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LZEBZLGWCH',LZEBZLGWCH_wrap_OnKeyDown);
function VOONRSAKSU_wrap_Valid(event) {
return VOONRSAKSU_Valid(event);
}
SPBOUILib.SetInputExit('VOONRSAKSU',VOONRSAKSU_wrap_Valid);
function VOONRSAKSU_wrap_OnFocus(event) {
return VOONRSAKSU_OnFocus(event);
}
SPBOUILib.SetInputEnter('VOONRSAKSU',VOONRSAKSU_wrap_OnFocus);
function VOONRSAKSU_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('VOONRSAKSU',VOONRSAKSU_wrap_OnKeyPress);
function VOONRSAKSU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('VOONRSAKSU',VOONRSAKSU_wrap_OnKeyDown);
function VOONRSAKSU_ZOOM_setHandlers() {
function VOONRSAKSU_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?VOONRSAKSU_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('VOONRSAKSU_ZOOM',VOONRSAKSU_ZOOM_wrap_OnClick);
function VOONRSAKSU_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('VOONRSAKSU_ZOOM',VOONRSAKSU_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('VOONRSAKSU',VOONRSAKSU_ZOOM_setHandlers);
function DJJPJVNREQ_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?DJJPJVNREQ_Click():void(0));
}
SPBOUILib.SetButtonClick('DJJPJVNREQ',DJJPJVNREQ_wrap_OnClick);
function DJJPJVNREQ_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('DJJPJVNREQ',DJJPJVNREQ_wrap_OnKeyDown);
function MRRDOEHYLX_wrap_Valid(event) {
return MRRDOEHYLX_Valid(event);
}
SPBOUILib.SetInputExit('MRRDOEHYLX',MRRDOEHYLX_wrap_Valid);
function MRRDOEHYLX_wrap_OnFocus(event) {
return MRRDOEHYLX_OnFocus(event);
}
SPBOUILib.SetInputEnter('MRRDOEHYLX',MRRDOEHYLX_wrap_OnFocus);
function MRRDOEHYLX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MRRDOEHYLX',MRRDOEHYLX_wrap_OnKeyDown);
function ABFCWFBDMW_wrap_Valid(event) {
return ABFCWFBDMW_Valid(event);
}
SPBOUILib.SetInputExit('ABFCWFBDMW',ABFCWFBDMW_wrap_Valid);
function ABFCWFBDMW_wrap_OnFocus(event) {
return ABFCWFBDMW_OnFocus(event);
}
SPBOUILib.SetInputEnter('ABFCWFBDMW',ABFCWFBDMW_wrap_OnFocus);
function ABFCWFBDMW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ABFCWFBDMW',ABFCWFBDMW_wrap_OnKeyDown);
function GORKFABVFF_wrap_Valid(event) {
return GORKFABVFF_Valid(event);
}
SPBOUILib.SetComboChange('GORKFABVFF',GORKFABVFF_wrap_Valid);
function GORKFABVFF_wrap_OnFocus(event) {
return GORKFABVFF_OnFocus(event);
}
SPBOUILib.SetInputEnter('GORKFABVFF',GORKFABVFF_wrap_OnFocus);
function GORKFABVFF_wrap_Blur(event) {
return GORKFABVFF_OnBlur(event);
}
SPBOUILib.SetInputExit('GORKFABVFF',GORKFABVFF_wrap_Blur);
function HAPCMCIYJW_wrap_Valid(event) {
return HAPCMCIYJW_Valid(event);
}
SPBOUILib.SetInputExit('HAPCMCIYJW',HAPCMCIYJW_wrap_Valid);
function HAPCMCIYJW_wrap_OnFocus(event) {
return HAPCMCIYJW_OnFocus(event);
}
SPBOUILib.SetInputEnter('HAPCMCIYJW',HAPCMCIYJW_wrap_OnFocus);
function HAPCMCIYJW_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('HAPCMCIYJW',HAPCMCIYJW_wrap_OnKeyPress);
function HAPCMCIYJW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HAPCMCIYJW',HAPCMCIYJW_wrap_OnKeyDown);
function OAAOYRQPRR_wrap_Valid(event) {
return OAAOYRQPRR_Valid(event);
}
SPBOUILib.SetInputExit('OAAOYRQPRR',OAAOYRQPRR_wrap_Valid);
function OAAOYRQPRR_wrap_OnFocus(event) {
return OAAOYRQPRR_OnFocus(event);
}
SPBOUILib.SetInputEnter('OAAOYRQPRR',OAAOYRQPRR_wrap_OnFocus);
function OAAOYRQPRR_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('OAAOYRQPRR',OAAOYRQPRR_wrap_OnKeyPress);
function OAAOYRQPRR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OAAOYRQPRR',OAAOYRQPRR_wrap_OnKeyDown);
function IDOPVICMXL_wrap_Valid(event) {
return IDOPVICMXL_Valid(event);
}
SPBOUILib.SetInputExit('IDOPVICMXL',IDOPVICMXL_wrap_Valid);
function IDOPVICMXL_wrap_OnFocus(event) {
return IDOPVICMXL_OnFocus(event);
}
SPBOUILib.SetInputEnter('IDOPVICMXL',IDOPVICMXL_wrap_OnFocus);
function ATYYTAXDZW_wrap_Valid(event) {
return ATYYTAXDZW_Valid(event);
}
SPBOUILib.SetComboChange('ATYYTAXDZW',ATYYTAXDZW_wrap_Valid);
function ATYYTAXDZW_wrap_OnFocus(event) {
return ATYYTAXDZW_OnFocus(event);
}
SPBOUILib.SetInputEnter('ATYYTAXDZW',ATYYTAXDZW_wrap_OnFocus);
function ATYYTAXDZW_wrap_Blur(event) {
return ATYYTAXDZW_OnBlur(event);
}
SPBOUILib.SetInputExit('ATYYTAXDZW',ATYYTAXDZW_wrap_Blur);
function GHUASLAKBC_wrap_Valid(event) {
return GHUASLAKBC_Valid(event);
}
SPBOUILib.SetInputExit('GHUASLAKBC',GHUASLAKBC_wrap_Valid);
function GHUASLAKBC_wrap_OnFocus(event) {
return GHUASLAKBC_OnFocus(event);
}
SPBOUILib.SetInputEnter('GHUASLAKBC',GHUASLAKBC_wrap_OnFocus);
function APTIWOKBUI_wrap_Valid(event) {
return APTIWOKBUI_Valid(event);
}
SPBOUILib.SetInputExit('APTIWOKBUI',APTIWOKBUI_wrap_Valid);
function APTIWOKBUI_wrap_OnFocus(event) {
return APTIWOKBUI_OnFocus(event);
}
SPBOUILib.SetInputEnter('APTIWOKBUI',APTIWOKBUI_wrap_OnFocus);
function APTIWOKBUI_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('APTIWOKBUI',APTIWOKBUI_wrap_OnKeyPress);
function APTIWOKBUI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('APTIWOKBUI',APTIWOKBUI_wrap_OnKeyDown);
function HRSWOWLUUE_wrap_Valid(event) {
return HRSWOWLUUE_Valid(event);
}
SPBOUILib.SetInputExit('HRSWOWLUUE',HRSWOWLUUE_wrap_Valid);
function HRSWOWLUUE_wrap_OnFocus(event) {
return HRSWOWLUUE_OnFocus(event);
}
SPBOUILib.SetInputEnter('HRSWOWLUUE',HRSWOWLUUE_wrap_OnFocus);
function HRSWOWLUUE_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('HRSWOWLUUE',HRSWOWLUUE_wrap_OnKeyPress);
function HRSWOWLUUE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HRSWOWLUUE',HRSWOWLUUE_wrap_OnKeyDown);
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
if (Ne(typeof(w_upload),'undefined')) {
w_upload.raiseEvent('armt_intermbo_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_scadenze),'undefined')) {
w_scadenze.raiseEvent('armt_intermbo_'+Strtran(p_cEvent,' ','_'));
}
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
FocusFirstComponent.edit={"page_1":["JXOBOAXKRQ"],"page_2":["FPFLFCPHAL"],"page_3":["KDJLQEMEDV"],"page_4":["DNCMAAILTV"],"page_5":["MLYQUOWFHN"],"page_6":["HAPCMCIYJW"]};
FocusFirstComponent.query={"page_1":["JXOBOAXKRQ"],"page_2":["FPFLFCPHAL"],"page_3":["KDJLQEMEDV"],"page_4":["DNCMAAILTV"],"page_5":["MLYQUOWFHN"],"page_6":["HAPCMCIYJW"]};
FocusFirstComponent.otherwise={"page_1":["JXOBOAXKRQ"],"page_2":["FPFLFCPHAL"],"page_3":["KDJLQEMEDV"],"page_4":["DNCMAAILTV"],"page_5":["MLYQUOWFHN"],"page_6":["HAPCMCIYJW"]};
function closeContextMenu_KAJTGMRBSU() {
}
function closeContextMenu_IXYGPGIHLH() {
}
function Help() {
windowOpenForeground('../doc/armt_intermbo_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_ardt_destwarn() {
SetModified();
}
function SetModified_ardt_cgo_tipall() {
SetModified();
}
function SetModified_ardt_cgo_subnets() {
SetModified();
}
function SetModified_ardt_destemail() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_3')) {
if (ChildToLoad('JBFAVRHYDR')) {
if (Eq(lazy,null) || LibJavascript.UserCanSee('JBFAVRHYDR')) {
LoadContext.lc(1,'JBFAVRHYDR');
}
} else {
LibJavascript.RefreshChildGrid('JBFAVRHYDR');
}
}
if (Eq(page,'page_5')) {
if (ChildToLoad('TOSEVHXRVF')) {
if (Eq(lazy,null) || LibJavascript.UserCanSee('TOSEVHXRVF')) {
LoadContext.lc(1,'TOSEVHXRVF');
}
} else {
LibJavascript.RefreshChildGrid('TOSEVHXRVF');
}
}
if (Eq(page,'page_5')) {
if (ChildToLoad('KDWFCOUSQZ')) {
if (Eq(lazy,null) || LibJavascript.UserCanSee('KDWFCOUSQZ')) {
LoadContext.lc(1,'KDWFCOUSQZ');
}
} else {
LibJavascript.RefreshChildGrid('KDWFCOUSQZ');
}
}
if (Eq(page,'page_6')) {
if (ChildToLoad('JWJORCKLGL')) {
if (Eq(lazy,null) || LibJavascript.UserCanSee('JWJORCKLGL')) {
LoadContext.lc(1,'JWJORCKLGL');
}
} else {
LibJavascript.RefreshChildGrid('JWJORCKLGL');
}
}
}
GetLayerID.Layers.push({"id":"YORQOIOBQN","name":"DatiBase"});
GetLayerID.Layers.push({"id":"KAJTGMRBSU_DIV","name":"upload"});
GetLayerID.Layers.push({"id":"IXYGPGIHLH_DIV","name":"scadenze"});
GetLayerID.Layers.push({"id":"POUNPHSDYV","name":"ParamBase"});
GetLayerID.Layers.push({"id":"CCPBATRTRJ","name":"PEP"});
GetLayerID.Layers.push({"id":"DQBIMZLTTE","name":"CGOEmail"});
GetLayerID.Layers.push({"id":"XFBWYNZQZN","name":"Import"});
GetLayerID.Layers.push({"id":"CESCBNVXDE","name":"Cambiavalute"});
GetLayerID.Layers.push({"id":"XEDASKHZOQ","name":"Base9Cambia"});
GetLayerID.Layers.push({"id":"HDNWLIPNPD","name":"DestWarn"});
GetLayerID.Layers.push({"id":"TQULLVKAWF","name":"OAM"});
GetLayerID.Layers.push({"id":"VSXUXPIOIH","name":"CGO"});
GetLayerID.Layers.push({"id":"NGHUXVAVYG","name":"Socket"});
GetLayerID.Layers.push({"id":"ENNTXFKBDB","name":"RespAnti"});
GetLayerID.Layers.push({"id":"AMSHYBLKWR","name":"CGOEmail"});
GetLayerID.Layers.push({"id":"KNXWNOJPJB","name":"GesDOC"});
GetLayerID.Layers.push({"id":"EOMKPJOLGE","name":"box_EOMKPJOLGE"});
GetLayerID.Layers.push({"id":"MFFCPIVYZD","name":"E-Learning"});
GetLayerID.Layers.push({"id":"UYDQCWOOEO","name":"Multiple"});
GetLayerID.Layers.push({"id":"QSIBTTRMLJ","name":"ExtSO"});
GetLayerID.Layers.push({"id":"YAITYOPUEH","name":"DestEmail"});
GetLayerID.Layers.push({"id":"MKILJOCTZW","name":"ImportVLT"});
function DeclareWVs() {
var a = arguments;
w_TIPINTER=a[0];
w_RAGSOC=a[1];
w_DESCCIT=a[2];
w_PROVINCIA=a[3];
w_CAP=a[4];
w_CODCAB=a[5];
w_DOMICILIO=a[6];
w_PAESE=a[7];
w_CODFISC=a[8];
w_PARTIVA=a[9];
w_DATANASC=a[10];
w_SOTGRUP=a[11];
w_RAMOGRUP=a[12];
w_SETTSINT=a[13];
w_TIPODOC=a[14];
w_SESSO=a[15];
w_NUMDOCUM=a[16];
w_DATARILASC=a[17];
w_AUTRILASC=a[18];
w_CODDIPE=a[19];
w_CONNES=a[20];
w_NOTE=a[21];
w_CODORO=a[22];
w_CODINTER=a[23];
w_TIPOPERS=a[24];
w_IDCITTA=a[25];
w_DATAVALI=a[26];
w_CONTATORE=a[27];
w_CFINVIO=a[28];
w_CAFINVIO=a[29];
w_FILEINVIO=a[30];
w_URLAPPL=a[31];
w_FLGLOG=a[32];
w_FLGAOS=a[33];
w_FLGEAOS=a[34];
w_FLGCDOC=a[35];
w_FLGFRAZ=a[36];
w_FLGAPERS=a[37];
w_DTINIATT=a[38];
w_FLGTIPIMP=a[39];
w_FLGSTPCON=a[40];
w_FLGIMPAGE=a[41];
w_FLGWU=a[42];
w_DATAINVIO=a[43];
w_IMPINTOPE=a[44];
w_FLGOPEXTR=a[45];
w_FLGRAPCLI=a[46];
w_FLGDATAIM=a[47];
w_FLGDATATP=a[48];
w_NOCODFISC=a[49];
w_FLGCHK=a[50];
w_CODAGE=a[51];
w_IDSID=a[52];
w_SIDPASS=a[53];
w_PATHJAVA=a[54];
w_TIPOINST=a[55];
w_FLGSIDAUTO=a[56];
w_SOSPMAF=a[57];
w_FLGRITORNO=a[58];
w_FLGCREAAGE=a[59];
w_DTTITAGE=a[60];
w_SCADSALDI=a[61];
w_FLGIPMT=a[62];
w_LIMITEFRZ=a[63];
w_DBPROT=a[64];
w_OAMTPDOC=a[65];
w_DAYSIMPORT=a[66];
w_DAYSIMPCMB=a[67];
w_TIPOSV=a[68];
w_FLGAWUPOS=a[69];
w_WUGIOSCA=a[70];
w_WUGGALERT=a[71];
w_SKT_SERVER=a[72];
w_SKT_PORT=a[73];
w_SKT_PATHS=a[74];
w_SKT_MODET=a[75];
w_RASPAUI=a[76];
w_RESPAUI=a[77];
w_TESTIP=a[78];
w_MINFRZSNAI=a[79];
w_FLGSCDFRZ=a[80];
w_GIORNIFRZ=a[81];
w_LIMITVLT=a[82];
w_LIMITVNP=a[83];
w_FLGSTPDIR=a[84];
w_FLGNODOC=a[85];
w_SNAISTOR=a[86];
w_FRAZDEL=a[87];
w_PATHAPP=a[88];
w_FLGDDOC=a[89];
w_FLGLIGHT=a[90];
w_FLGCGOPWD=a[91];
w_PATHSID=a[92];
w_PATHCERT=a[93];
w_PATHFTP=a[94];
w_FLGUTEAGE=a[95];
w_PRGAEPATH=a[96];
w_NUMGIORN=a[97];
w_COGNOME=a[98];
w_NOME=a[99];
w_DNASC=a[100];
w_CITTADINA=a[101];
w_NASCOMUN=a[102];
w_NASSTATO=a[103];
w_PRNASC=a[104];
w_SOGCOM=a[105];
w_ALTSRVMAIL=a[106];
w_ALTPRTMAIL=a[107];
w_ALTEMLMAIL=a[108];
w_ALTUSRMAIL=a[109];
w_ALTPWDMAIL=a[110];
w_FLGGESDOC=a[111];
w_USRGESDOC=a[112];
w_PWDGESDOC=a[113];
w_URLDESDOC=a[114];
w_EMAILDOC=a[115];
w_DATADOC=a[116];
w_PATHDOCBAC=a[117];
w_IMPPATH=a[118];
w_BPCODPAT=a[119];
w_BPENTSEG=a[120];
w_BPCOGSEG=a[121];
w_BPNOMSEG=a[122];
w_BPTELSEG=a[123];
w_BPEMLSEG=a[124];
w_RICEVUTE=a[125];
w_ABI=a[126];
w_CAB=a[127];
w_OGGI3I4=a[128];
w_CGOTGDEFMUL=a[129];
w_AUTOSARA=a[130];
w_GGWARNPRV=a[131];
w_GGWARNAUI=a[132];
w_SOGLIAMAX=a[133];
w_LIMITE20=a[134];
w_SONUMMESI=a[135];
w_SOMESIBACK=a[136];
w_SOSHELLCMD=a[137];
w_SOAMBIENTE=a[138];
w_SOPATHIMPORT=a[139];
w_SOORAIMPORT=a[140];
w_QADV_SOGLIA=a[141];
w_FLGCGOOTP=a[142];
w_FLGCGOQADV=a[143];
w_ITFLGPEP=a[144];
w_ITPWDPEP=a[145];
w_ITUSRPEP=a[146];
w_BLOCCOUSER=a[147];
w_CGOFLGPROF=a[148];
w_FLGAGGFAM=a[149];;
w_ALTSSLEMAIL=a[150];
w_PATHIMPORT=a[151];
w_DESTEMAIL=a[152];
w_CODVASP=a[153];
w_IDOAM=a[154];
w_IDOAMR=a[155];
w_ART1=a[156];
w_DESCRIsta=a[157];
w_DESCSGRU=a[158];
w_DESCRAMGRU=a[159];
w_DESCUIC=a[160];
w_descdip=a[161];
w_tipsot=a[162];
w_xdescitdip=a[163];
w_xcabdip=a[164];
w_gUserCode=a[165];
w_ATTIV=a[166];
w_gUrlApp=a[167];
w_gAzienda=a[168];
w_PWDSER=a[169];
w_appocert=a[170];
w_pathmanuale=a[171];
w_xDESCAN=a[172];
o_CCPBATRTRJ_expand=null;
o_CCPBATRTRJ_collapse=null;
m_cWv_ardt_destwarn=a[173];
m_cWv_ardt_cgo_tipall=a[174];
m_cWv_ardt_cgo_subnets=a[175];
m_cWv_ardt_destemail=a[176];
if (Gt(a.length,177)) {
m_cErrorInChild='';
}
if (Gt(a.length,177)) {
o_DESCCIT=w_DESCCIT;
o_SOTGRUP=w_SOTGRUP;
o_RAMOGRUP=w_RAMOGRUP;
}
m_PrimaryKeys=['CODINTER'];
}
function i_PrimaryKey() {
return 'intermbo'+'\\'+CPLib.ToCPStr(w_CODINTER);
}
GetLinkPCKeys.set_o('ardt_destwarn',false);
GetLinkPCKeys.set_o('ardt_cgo_tipall',false);
GetLinkPCKeys.set_o('ardt_cgo_subnets',false);
GetLinkPCKeys.set_o('ardt_destemail',false);
GetLinkPCKeys.o['ardt_destwarn']['DWCODINT']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_CODINTER,'C');
}
}
GetLinkPCKeys.o['ardt_cgo_tipall']['TACODINT']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_CODINTER,'C');
}
}
GetLinkPCKeys.o['ardt_cgo_subnets']['SNCODINT']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_CODINTER,'C');
}
}
GetLinkPCKeys.o['ardt_destemail']['DWCODINT']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_CODINTER,'C');
}
}
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('JBFAVRHYDR',function(){return FrameRef('ardt_destwarn')},1,'ardt_destwarn',0,3)
LoadContext.f('TOSEVHXRVF',function(){return FrameRef('ardt_cgo_tipall')},1,'ardt_cgo_tipall',0,5)
LoadContext.f('KDWFCOUSQZ',function(){return FrameRef('ardt_cgo_subnets')},1,'ardt_cgo_subnets',0,5)
LoadContext.f('JWJORCKLGL',function(){return FrameRef('ardt_destemail')},1,'ardt_destemail',0,6)
GetSelectedChildPage.child={'ardt_destwarn': function(){return FrameRef('ardt_destwarn')}, 'ardt_cgo_tipall': function(){return FrameRef('ardt_cgo_tipall')}, 'ardt_cgo_subnets': function(){return FrameRef('ardt_cgo_subnets')}, 'ardt_destemail': function(){return FrameRef('ardt_destemail')}}
function GetSelectedPage(p_d) {
p_d.setValue('armt_intermbo',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_DESCCIT,'C'); },"field":"CITTA","type":"C"},{"expression":function() { return WtA(w_CODCAB,'C'); },"field":"CAB","type":"C"},{"expression":function() { return WtA(w_PROVINCIA,'C'); },"field":"PROV","type":"C"},{"expression":function() { return WtA(w_CAP,'C'); },"field":"CAP","type":"C"},{"expression":function() { return WtA(w_PAESE,'C'); },"field":"PKTBSTATI","type":"C"},{"expression":function() { return WtA(w_IDCITTA,'C'); },"field":"IDBASE","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcitta','C'),"uid":"JCGROGAZTR"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_PAESE,'C'); },"field":"CODSTA","type":"C"},{"expression":function() { return WtA(w_DESCRIsta,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"IIXRREUEAM"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_SOTGRUP,'C'); },"field":"SOTGRU","type":"C"},{"expression":function() { return WtA(w_DESCSGRU,'C'); },"field":"DESCRI","type":"C"},{"expression":function() { return WtA(w_tipsot,'C'); },"field":"TIPOSOT","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstgru','C'),"uid":"LLYIGAMXRH"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_RAMOGRUP,'C'); },"field":"RAMGRU","type":"C"},{"expression":function() { return WtA(w_DESCRAMGRU,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbramgru','C'),"uid":"RVNHQCXNEM"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_SETTSINT,'C'); },"field":"SETSINT","type":"C"},{"expression":function() { return WtA(w_DESCUIC,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbsetsin','C'),"uid":"ZGNLLSFQHC"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODDIPE,'C'); },"field":"CODDIP","type":"C"},{"expression":function() { return WtA(w_descdip,'C'); },"field":"DESCRIZ","type":"C"},{"expression":function() { return WtA(w_xdescitdip,'C'); },"field":"DESCCIT","type":"C"},{"expression":function() { return WtA(w_xcabdip,'C'); },"field":"CAB","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('anadip','C'),"uid":"PSZTLCSMPB"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('armt_citta','C'),"fldValues":[{"expression":function() { return WtA(w_DESCCIT,'C'); },"field":"CITTA","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcitta','C'),"uid":"PZGXGIZQWY"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('armt_citta','C'),"fldValues":[{"expression":function() { return WtA(w_NASCOMUN,'C'); },"field":"CITTA","type":"C"},{"expression":function() { return WtA(w_PRNASC,'C'); },"field":"PROV","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcitta','C'),"uid":"DUROREWBNG"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_NASSTATO,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"ZTUIXEONYI"});
}
_Obli('TIPINTER',0,'JXOBOAXKRQ',false,"984756930")
_Obli('RAGSOC',0,'HVIUTGJWGE',false,"10662833243")
_Obli('DESCCIT',0,'JCGROGAZTR',false,"15186643")
_Obli('DESCCIT',0,'PZGXGIZQWY',false,"49939619")
_Obli('PROVINCIA',0,'UQKLCBCTLH',false,"10095365423")
_Obli('PROVINCIA',0,'MUWSLBTIOI',false,"10095365423")
_Obli('CAP',0,'BQSGHFQUHM',false,"21587")
_Obli('CODCAB',0,'IXWLDAOCFD',false,"18003")
_Obli('DOMICILIO',0,'SJHNBZJAKA',false,"554236824")
_Obli('PAESE',0,'IIXRREUEAM',false,"7776403")
_Obli('CODFISC',0,'SZWCLLEIQY',false,"11921223220")
_Obli('PARTIVA',0,'OIWIANSIOG',false,"1756430089")
_Obli('DATANASC',2,'TNUQTSSGFZ',false,"226933836")
_Obli('SOTGRUP',0,'LLYIGAMXRH',false,"611154211")
_Obli('RAMOGRUP',0,'RVNHQCXNEM',false,"572399938")
_Obli('SETTSINT',0,'ZGNLLSFQHC',false,"2095911698")
_Obli('TIPODOC',0,'AYYXYNLAUC',false,"11429032151")
_Obli('TIPODOC',0,'KYNLIGXUVC',false,"61024920")
_Obli('SESSO',0,'OREVCZVNVS',false,"7776675")
_Obli('SESSO',0,'SIJUUSKFLV',false,"7776675")
_Obli('NUMDOCUM',0,'XCNHFVDZMT',false,"10759885763")
_Obli('DATARILASC',2,'ZYURNYDRPU',false,"784106725")
_Obli('AUTRILASC',0,'YYONLOLCBB',false,"1171331983")
_Obli('CODDIPE',0,'PSZTLCSMPB',false,"2071283709")
_Obli('CGOTGDEFMUL',0,'GORKFABVFF',false,"547041811")
_Obli('CGOTGDEFMUL',0,'PDLIXDKBWK',false,"547041811")
_Obli('NOTE',0,'COVTIKSDDS',false,"277599600")
_Obli('CODORO',0,'WSAOVXNTFO',false,"1191715360")
_Obli('CODINTER',0,'YPYQJILEQY',true,"112851763")
_Obli('ALTPWDMAIL',0,'IIVBDSFKCC',false,"11183930016")
_Obli('ALTPWDMAIL',0,'LGVTLPSUGS',false,"11183930016")
_Obli('ALTSSLEMAIL',0,'KPSLGRAIIO',false,"1367697541")
_Obli('SOORAIMPORT',1,'APTIWOKBUI',false,"102290740")
_Obli('SOPATHIMPORT',0,'GHUASLAKBC',false,"11556190124")
_Obli('SOAMBIENTE',0,'ATYYTAXDZW',true,"11928289558",null,null,function() { return  ! (Empty(LRTrim(w_SOSHELLCMD))) })
_Obli('SOSHELLCMD',0,'IDOPVICMXL',false,"156458968")
_Obli('SOMESIBACK',1,'OAAOYRQPRR',false,"10222585128")
_Obli('SONUMMESI',1,'HAPCMCIYJW',false,"10629686554")
_Obli('IMPPATH',0,'ABFCWFBDMW',false,"11017138898")
_Obli('DATAVALI',2,'MXHAWWCAZX',false,"784106725")
_Obli('PATHIMPORT',0,'YRAEGOUXRJ',false,"10420604475")
_Obli('PATHDOCBAC',0,'MRRDOEHYLX',false,"10252967626")
_Obli('DATADOC',2,'VOONRSAKSU',false,"10300990862")
_Obli('CFINVIO',0,'TFMCRMSOGY',false,"11949617228")
_Obli('CAFINVIO',0,'YUCSUDKWNH',false,"346962755")
_Obli('FILEINVIO',0,'JSTXCUBOUH',false,"603506633")
_Obli('DATAINVIO',2,'YOVFWZCOBN',false,"1908272937")
_Obli('IDSID',0,'QPIRUTKOVH',false,"1417173637")
_Obli('SIDPASS',0,'ULCBOSJURF',false,"11183930016")
_Obli('PATHJAVA',0,'KHHILRUMHZ',false,"11780950272")
_Obli('TIPOINST',0,'ELBURHNYTV',false,"62890022")
_Obli('FLGSIDAUTO',1,'JYYHNLJDWT',false)
_Obli('DNASC',2,'XCZARGUGTG',false,"1924622942")
_Obli('EMAILDOC',0,'LZEBZLGWCH',false,"1173187617")
_Obli('appocert',0,'FLPFDBFHXV',false)
_Obli('TIPOSV',0,'LYZAJWZGAM',false,"229480117")
_Obli('LIMITE20',2,'LAQADJFMRL',false,"898056191")
_Obli('CODVASP',0,'FTETLDBHIY',false,"10964521107")
_Obli('CODVASP',0,'CMBYXKAJCS',false,"10964521107")
_Obli('ART1',1,'CWVJUDEVCT',false,"11386753202")
_Obli('URLAPPL',0,'FPFLFCPHAL',false,"10056338162")
_Obli('FLGLOG',0,'EOQVPQLKOP',false,"444014241")
_Obli('FLGAOS',0,'BLWLPTWCFV',false,"11925635672")
_Obli('FLGEAOS',0,'REBGPUSIPL',false,"10863203227")
_Obli('FLGCDOC',0,'HKDCUQQHSU',false,"10663215684")
_Obli('FLGFRAZ',0,'CCBVEBVMNW',false,"10792439550")
_Obli('FLGAPERS',0,'IDROHZZWYH',false,"10387266406")
_Obli('DTINIATT',2,'IQOQQQRZAK',false,"239631204")
_Obli('FLGTIPIMP',0,'ZPSOMDIBXB',false,"11372282520")
_Obli('FLGSTPCON',0,'PIGFPYZMIR',false,"1057101874")
_Obli('FLGIMPAGE',0,'DUFIQNBDKW',false,"10580197773")
_Obli('FLGWU',0,'LOYILZBSVI',false,"629299095")
_Obli('IMPINTOPE',1,'YJCSSLPJKG',false,"11318353074")
_Obli('FLGOPEXTR',0,'PXNLADGGBR',false,"2069243517")
_Obli('FLGRAPCLI',0,'OSHAMNPXFT',false,"11899629160")
_Obli('BPENTSEG',0,'PBQXUDZUOZ',false,"821432322")
_Obli('BPCOGSEG',0,'UBNVJIYFWU',false,"342820965")
_Obli('NOCODFISC',1,'UETNARUDOE',false,"1838445422")
_Obli('FLGCHK',0,'UHGVOKNSVL',false,"10832346659")
_Obli('BPNOMSEG',0,'PELELICXZD',false,"443454")
_Obli('PWDSER',0,'NLUIAOSQKM',false)
_Obli('SOSPMAF',0,'XDDITMPJIZ',false,"1991110901")
_Obli('FLGRITORNO',0,'LUPNVRRLHF',false,"12119982584")
_Obli('FLGCREAAGE',0,'HFADCPKPNB',false,"129191708")
_Obli('DTTITAGE',2,'ASIWFAENLM',false,"10013527374")
_Obli('SCADSALDI',2,'IOYUNQJDKZ',false,"1445270903")
_Obli('FLGIPMT',0,'LSBZHECNKO',false,"12098996044")
_Obli('LIMITEFRZ',1,'FKIIMPSJSB',false,"11107614036")
_Obli('LIMITEFRZ',1,'QNBTKVPOCY',false,"11107614036")
_Obli('LIMITEFRZ',1,'UCTCKTKEZC',false,"11107614036")
_Obli('GGWARNPRV',1,'PUFIBBLEMQ',false,"1418436627")
_Obli('DBPROT',0,'EQCSRKQZVC',false,"2128701876")
_Obli('OAMTPDOC',1,'KFQWZVCJIW',false,"691571468")
_Obli('DAYSIMPORT',1,'LGZDRUUSXZ',false,"892694017")
_Obli('DAYSIMPCMB',1,'FQKHRITNGP',false,"10821185899")
_Obli('FLGAWUPOS',0,'SIZHWNZUOT',false,"54222013")
_Obli('WUGIOSCA',1,'QBHBPWJMOW',false,"11212325724")
_Obli('WUGGALERT',1,'HXPRRNXNJO',false,"11345952953")
_Obli('RICEVUTE',0,'AAIARGXIIW',false,"11435351387")
_Obli('OGGI3I4',0,'PLWDFUBDIP',false,"11215522148")
_Obli('IDOAMR',0,'PUYJXGBDJI',false,"10585263250")
_Obli('QADV_SOGLIA',1,'HRSWOWLUUE',false,"11128798379")
_Obli('AUTOSARA',0,'PVOEPQLJPS',false,"10708787386")
_Obli('FLGCGOOTP',0,'MHHQTFPDEN',false,"48458917")
_Obli('FLGCGOOTP',0,'FCXDRDCINI',false,"48458917")
_Obli('ITFLGPEP',0,'RBAZEQPPJI',false,"10619854532")
_Obli('ITPWDPEP',0,'VDJMSNZEEV',false,"298733899")
_Obli('ITUSRPEP',0,'LNADTKDHIZ',false,"791817119")
_Obli('FLGAGGFAM',0,'XMAVZMPWRZ',false,"10539278829")
_Obli('ALTSRVMAIL',0,'MLYQUOWFHN',false,"1538539509")
_Obli('ALTSRVMAIL',0,'BZARULYZUH',false,"1538539509")
_Obli('ALTPRTMAIL',0,'VRYHAZPGSR',false,"6863168")
_Obli('ALTPRTMAIL',0,'CWFIJJMSTR',false,"6863168")
_Obli('ALTEMLMAIL',0,'TYOXRXGXKJ',false,"10759744842")
_Obli('ALTEMLMAIL',0,'YPHGLIUDNW',false,"10759744842")
_Obli('ALTUSRMAIL',0,'OKEJPCYNVH',false,"11227707037")
_Obli('ALTUSRMAIL',0,'HSAOKMBAUY',false,"11227707037")
_Obli('RESPAUI',0,'WHJVJHBKYI',false,"11973601132")
_Obli('URLDESDOC',0,'RNIWEERJDP',false,"1506669781")
_Obli('PWDGESDOC',0,'HFVZAFILCA',false,"10274446797")
_Obli('DESTEMAIL',0,'OHRBGBCDVG',false,"11069952590")
_Obli('COGNOME',0,'KDJLQEMEDV',false,"1816546867")
_Obli('NOME',0,'VTFLIHXHLG',false,"443454")
_Obli('MINFRZSNAI',1,'XRGIDJXVCB',false,"11688003470")
_Obli('FLGSCDFRZ',0,'CZINOLQOUB',false,"2088685076")
_Obli('CITTADINA',0,'WQWXGOLVXC',false,"1336888340")
_Obli('NASCOMUN',0,'DUROREWBNG',false,"376382717")
_Obli('NASSTATO',0,'ZTUIXEONYI',false)
_Obli('PRNASC',0,'KSRCRPEMFT',false,"1614154515")
_Obli('SOGCOM',0,'IYKMLTUWXM',false,"11536826979")
_Obli('BPCODPAT',0,'IAXBQWHGLM',false,"776361652")
_Obli('FLGSTPDIR',0,'OOAVIAADZS',false,"282519940")
_Obli('FLGNODOC',0,'MRWHAAPELH',false,"1193776028")
_Obli('USRGESDOC',0,'MUANKUGIIK',false,"10519994838")
_Obli('BPTELSEG',0,'DZVDAZOPWP',false,"10404199848")
_Obli('BPEMLSEG',0,'HRZVDXDSOJ',false,"7534101")
_Obli('ABI',0,'TFDNMJLIWF',false,"19809")
_Obli('CAB',0,'WRRSZRBPCI',false,"18003")
_Obli('FLGGESDOC',0,'FYAHSLEGLP',false,"296951675")
_Obli('GGWARNAUI',1,'MBMIGFSBXO',false,"10840261571")
_Obli('SOGLIAMAX',1,'XUNVKFSSZL',false,"513536497")
_Obli('IDOAM',0,'CNQFAHXNUY',false,"343431949")
_Obli('PATHAPP',0,'FOTKWJQFAL',false,"10862260321")
_Obli('SKT_SERVER',0,'DNCMAAILTV',false,"1478813640")
_Obli('SKT_PORT',1,'UMEMYFCVBI',false,"1164993875")
_Obli('SKT_PATHS',0,'ZFUOSYKTGZ',false,"11171811910")
_Obli('SKT_MODET',0,'ECARBEFMBC',false,"2063760189")
_Obli('RASPAUI',0,'DNNGPDMXQI',false,"11087095564")
_Obli('pathmanuale',0,'JPABVPZDBZ',false)
_Obli('TESTIP',0,'ZZSBUTEXWS',false,"321149674")
_Obli('FLGCGOPWD',0,'VJPULIZVKG',false,"11829318249")
_Obli('PATHSID',0,'EMDHDDRUPP',false,"1594022391")
_Obli('GIORNIFRZ',1,'BMMUPRLVUU',false,"11490314427")
_Obli('LIMITVLT',1,'JFMMDZQFJC',false,"11843606227")
_Obli('LIMITVNP',1,'OHKFECVWFV',false,"2015453927")
_Obli('PATHFTP',0,'WPPFTLWEWX',false,"10901840369")
_Obli('FRAZDEL',0,'HBTCFEMATT',false,"10969052023")
_Obli('FLGUTEAGE',0,'KZJBLRRDWP',false,"10119643152")
_Obli('FLGLIGHT',0,'QMOTVZANBJ',false,"10471602801")
_Obli('PRGAEPATH',0,'PUWCGJFLDF',false,"614440993")
_Obli('CGOFLGPROF',0,'ABGLJLFEYQ',false,"628897822")
_Obli('PATHCERT',0,'WXRSSFBXYH',false,"10895800895")
_Obli('NUMGIORN',1,'NVZYOQAKDU',false,"1199608503")
_Obli('BLOCCOUSER',1,'XVGAGFPMXP',false,"535087343")
_Obli('FLGCGOQADV',0,'SSXDYZLCUX',false,"915236354")
