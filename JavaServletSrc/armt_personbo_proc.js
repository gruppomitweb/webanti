function FillCombosValues() {
FillCombo('IRLEJAUHCB','IRLEJAUHCB');
FillCombo('MBGANUUHRA','MBGANUUHRA');
FillCombo('LLYIGAMXRH','LLYIGAMXRH');
FillCombo('ZGNLLSFQHC','ZGNLLSFQHC');
FillCombo('EMSGWJAYYK','EMSGWJAYYK');
FillCombo('SMVVFHCEHA','SMVVFHCEHA');
}
function SetControlsValue() {
var c;
var tmp_subtitle = ToHTag(AsControlValue('NDG: '+LRTrim(w_CONNES)+' - '+'Nominativo: '+LRTrim(w_RAGSOC)));
if (Ne(e_subtitle,tmp_subtitle)) {
SetSubTitle(tmp_subtitle);
e_subtitle=tmp_subtitle;
}
if(c=Ctrl('UYWIEUHCAL')) selectRadio(c,w_TIPOPERS,'C')
SPBOUILib.SetInputValue('TWTTDWKCRG',function(){return WtH(w_COGNOME,'C',26,0,'@!')},w_COGNOME);
SPBOUILib.SetInputValue('WWGIVGNUDW',function(){return WtH(w_NOME,'C',25,0,'@!')},w_NOME);
if(c=Ctrl('CZTHKEDVCO')) ChkboxCheckUncheck(c,1,w_CFESTERO)
if(c=Ctrl('CZTHKEDVCO')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('AWPNTOJIRR',function(){return WtH(w_RAGSOC,'C',70,0,'@!')},w_RAGSOC);
SPBOUILib.SetInputValue('YVIKEGPYPM',function(){return WtH(w_PAESE,'C',3,0,'')},w_PAESE);
SPBOUILib.SetInputValue('ODAYKSRECA',function(){return WtH(w_DESCCIT,'C',30,0,'@!')},w_DESCCIT);
SPBOUILib.SetInputValue('NOTZPDMYIA',function(){return WtH(w_PROVINCIA,'C',2,0,'')},w_PROVINCIA);
SPBOUILib.SetInputValue('RDAVOEETJG',function(){return WtH(w_CAP,'C',9,0,'')},w_CAP);
SPBOUILib.SetInputValue('BOTAJBWHHY',function(){return WtH(w_CODCAB,'C',6,0,'')},w_CODCAB);
SPBOUILib.SetInputValue('VYLHWTRQNX',function(){return WtH(w_DOMICILIO,'C',35,0,'')},w_DOMICILIO);
if(c=Ctrl('IRLEJAUHCB')) selectCombo(c,w_IDENT,'C')
SPBOUILib.SetInputValue('BYPEBFEOAJ',function(){return WtH(w_IDNASCOMUN,'C',40,0,'')},w_IDNASCOMUN);
SPBOUILib.SetInputValue('NEUBQNUEOJ',function(){return WtH(w_NASCOMUN,'C',30,0,'@!')},w_NASCOMUN);
SPBOUILib.SetInputValue('KPSCOABZLB',function(){return WtH(w_TIPINTER,'C',2,0,'')},w_TIPINTER);
SPBOUILib.SetInputValue('IOAMSFCCVV',function(){return WtH(w_IDNASSTATO,'C',10,0,'')},w_IDNASSTATO);
SPBOUILib.SetInputValue('HODZKKOSYW',function(){return WtH(w_NASSTATO,'C',30,0,'@!')},w_NASSTATO);
if(c=Ctrl('QPALJZMFCL')) selectCombo(c,w_SESSO,'C')
SPBOUILib.SetInputValue('XMGRWGFSFV',function(){return WtH(w_DATANASC,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATANASC);
if(c=Ctrl('MBGANUUHRA')) selectCombo(c,w_TIPODOC,'C')
SPBOUILib.SetInputValue('HVEEMUJUUY',function(){return WtH(w_NUMDOCUM,'C',15,0,'')},w_NUMDOCUM);
SPBOUILib.SetInputValue('XHWYGOPPUN',function(){return WtH(w_DATARILASC,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATARILASC);
SPBOUILib.SetInputValue('BNWXBPSIDG',function(){return WtH(w_DATAVALI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAVALI);
SPBOUILib.SetInputValue('HRNCPADUFU',function(){return WtH(w_AUTRILASC,'C',30,0,'')},w_AUTRILASC);
SPBOUILib.SetInputValue('OJJHIUDPFY',function(){return WtH(w_CODFISC,'C',16,0,'')},w_CODFISC);
SPBOUILib.SetInputValue('FHXWUTBNKI',function(){return WtH(w_PARTIVA,'C',14,0,'')},w_PARTIVA);
SPBOUILib.SetInputValue('JLTVZXPMKM',function(){return WtH(w_CONTO,'C',25,0,'')},w_CONTO);
if(c=Ctrl('LLYIGAMXRH')) selectCombo(c,w_SOTGRUP,'C')
SPBOUILib.SetInputValue('RVNHQCXNEM',function(){return WtH(w_RAMOGRUP,'C',3,0,'')},w_RAMOGRUP);
SPBOUILib.SetInputValue('SAQTIHOALW',function(){return WtH(w_ATTIV,'C',10,0,'')},w_ATTIV);
if(c=Ctrl('ZGNLLSFQHC')) selectCombo(c,w_SETTSINT,'C')
SPBOUILib.SetInputValue('YTPWDRMFUS',function(){return WtH(w_CONNES,'C',16,0,'')},w_CONNES);
if(c=Ctrl('XCYZDRXAMJ')) ChkboxCheckUncheck(c,'S',w_NOSARA)
if(c=Ctrl('XCYZDRXAMJ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('RARXYHBSLM')) ChkboxCheckUncheck(c,1,w_NOTIT)
if(c=Ctrl('RARXYHBSLM')) ChkboxValueAssign(c,1,0,'N',1,0,'')
if(c=Ctrl('DFNZBCOVFH')) ChkboxCheckUncheck(c,'S',w_flgaggfam)
if(c=Ctrl('DFNZBCOVFH')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('FROMUIZATY',function(){return WtH(w_DATARETT,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATARETT);
var tmp_PFEQRACAUA = ToHTag(AsControlValue((Ne(w_TIPOPERS,'G')?'Nominativo:':'Ragione Sociale:')));
if (Ne(e_PFEQRACAUA,tmp_PFEQRACAUA)) {
SPBOUILib.SetLabelValue('PFEQRACAUA','innerHTML',tmp_PFEQRACAUA);
e_PFEQRACAUA=tmp_PFEQRACAUA;
}
var tmp_ESVLUSNYWB = ToHTag(AsControlValue(w_dessta));
if (Ne(e_ESVLUSNYWB,tmp_ESVLUSNYWB)) {
SPBOUILib.SetLabelValue('ESVLUSNYWB','innerHTML',tmp_ESVLUSNYWB);
e_ESVLUSNYWB=tmp_ESVLUSNYWB;
}
var tmp_JCWRPFWYVW = ToHTag(AsControlValue(w_DESCRAMGRU));
if (Ne(e_JCWRPFWYVW,tmp_JCWRPFWYVW)) {
SPBOUILib.SetLabelValue('JCWRPFWYVW','innerHTML',tmp_JCWRPFWYVW);
e_JCWRPFWYVW=tmp_JCWRPFWYVW;
}
var tmp_CPWCFGHBVH = ToHTag(AsControlValue(w_xdesctipatt));
if (Ne(e_CPWCFGHBVH,tmp_CPWCFGHBVH)) {
SPBOUILib.SetLabelValue('CPWCFGHBVH','innerHTML',tmp_CPWCFGHBVH);
e_CPWCFGHBVH=tmp_CPWCFGHBVH;
}
SPBOUILib.SetInputValue('YZOYIYAUUO',function(){return WtH(w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAFINE);
SPBOUILib.SetInputValue('REJDXHTDMV',function(){return WtH(w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAINI);
SPBOUILib.SetInputValue('ODWJZUZDBK',function(){return WtH(w_DISATTIVO,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DISATTIVO);
if(c=Ctrl('JJETXTUKNC')) selectCombo(c,w_TIPOSOGGETTO,'C')
if(c=Ctrl('JFJPGOWVYJ')) selectCombo(c,w_RAPSEGNA,'C')
SPBOUILib.SetInputValue('HKQDVAPIOQ',function(){return WtH(w_SOGAFFIDATARIO,'C',80,0,'@!')},w_SOGAFFIDATARIO);
if(c=Ctrl('EMSGWJAYYK')) selectCombo(c,w_CAUSALE,'N')
SPBOUILib.SetInputValue('XOROAVXTCD',function(){return WtH(w_FATTURATO,'N',12,2,'')},w_FATTURATO);
if(c=Ctrl('XERWNYQDBZ')) ChkboxCheckUncheck(c,'S',w_FLGNOTRIM)
if(c=Ctrl('XERWNYQDBZ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('EVYVDDYVDZ',function(){return WtH(w_DATAIDENT,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAIDENT);
SPBOUILib.SetInputValue('BOHBZOSBVJ',function(){return WtH(w_COMPLETA,'L',1,0,'')},w_COMPLETA);
SPBOUILib.SetInputValue('UMKFMWBVUO',function(){return WtH(w_NOTE,'M',10,0,'')},w_NOTE);
var tmp_LIYWMHOGYX = ToHTag(AsControlValue(w_xRAGLEGRAP));
if (Ne(e_LIYWMHOGYX,tmp_LIYWMHOGYX)) {
SPBOUILib.SetLabelValue('LIYWMHOGYX','innerHTML',tmp_LIYWMHOGYX);
e_LIYWMHOGYX=tmp_LIYWMHOGYX;
}
SPBOUILib.SetInputValue('CKHRNQSKKQ',function(){return WtH(w_CODLEGRAP,'C',16,0,'')},w_CODLEGRAP);
SPBOUILib.SetInputValue('DQZNJUSTLN',function(){return WtH(w_BANCABEN,'C',11,0,'')},w_BANCABEN);
var tmp_XHVCRZXJZF = ToHTag(AsControlValue(w_ragbanben));
if (Ne(e_XHVCRZXJZF,tmp_XHVCRZXJZF)) {
SPBOUILib.SetLabelValue('XHVCRZXJZF','innerHTML',tmp_XHVCRZXJZF);
e_XHVCRZXJZF=tmp_XHVCRZXJZF;
}
SPBOUILib.SetInputValue('ESODTMPIYO',function(){return WtH(w_DATASEGN,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATASEGN);
SPBOUILib.SetInputValue('UNPDFRUOXO',function(){return WtH(w_DATARAUT,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATARAUT);
SPBOUILib.SetInputValue('RKHMYOIJDM',function(){return WtH(w_FATCA,'C',3,0,'')},w_FATCA);
var tmp_YJYXHNVCSS = ToHTag(AsControlValue(w_xdesfatca));
if (Ne(e_YJYXHNVCSS,tmp_YJYXHNVCSS)) {
SPBOUILib.SetLabelValue('YJYXHNVCSS','innerHTML',tmp_YJYXHNVCSS);
e_YJYXHNVCSS=tmp_YJYXHNVCSS;
}
SPBOUILib.SetInputValue('HBSPPQBOJN',function(){return WtH(w_TIN,'C',16,0,'')},w_TIN);
if(c=Ctrl('EOYNWRHHMY')) ChkboxCheckUncheck(c,1,w_ODB)
if(c=Ctrl('EOYNWRHHMY')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('CJBEXKJOQO',function(){return WtH(w_CITTADIN1,'C',3,0,'')},w_CITTADIN1);
SPBOUILib.SetInputValue('UNRQNVVFTK',function(){return WtH(w_CITTADIN2,'C',3,0,'')},w_CITTADIN2);
SPBOUILib.SetInputValue('OSLBLDODHQ',function(){return WtH(w_RESFISC,'C',3,0,'')},w_RESFISC);
var tmp_QNTJNWIUJE = ToHTag(AsControlValue(w_xDesCit1));
if (Ne(e_QNTJNWIUJE,tmp_QNTJNWIUJE)) {
SPBOUILib.SetLabelValue('QNTJNWIUJE','innerHTML',tmp_QNTJNWIUJE);
e_QNTJNWIUJE=tmp_QNTJNWIUJE;
}
var tmp_SBEGVLBNXL = ToHTag(AsControlValue(w_xDesCit2));
if (Ne(e_SBEGVLBNXL,tmp_SBEGVLBNXL)) {
SPBOUILib.SetLabelValue('SBEGVLBNXL','innerHTML',tmp_SBEGVLBNXL);
e_SBEGVLBNXL=tmp_SBEGVLBNXL;
}
var tmp_FLUVMIEXGY = ToHTag(AsControlValue(w_xResFis));
if (Ne(e_FLUVMIEXGY,tmp_FLUVMIEXGY)) {
SPBOUILib.SetLabelValue('FLUVMIEXGY','innerHTML',tmp_FLUVMIEXGY);
e_FLUVMIEXGY=tmp_FLUVMIEXGY;
}
SPBOUILib.SetInputValue('NXVXQSLAGM',function(){return WtH(w_AREAGEO,'C',3,0,'')},w_AREAGEO);
SPBOUILib.SetInputValue('JHEJMIHGSH',function(){return WtH(w_AREAGEO,'C',3,0,'')},w_AREAGEO);
SPBOUILib.SetInputValue('PGYFWWGOTN',function(){return WtH(w_RAREA,'N',3,0,'')},w_RAREA);
SPBOUILib.SetInputValue('VHXDWWHVXF',function(){return WtH(w_PKTBSPECIE,'C',4,0,'')},w_PKTBSPECIE);
SPBOUILib.SetInputValue('DRJTSDRPVN',function(){return WtH(w_PKTBSPECIE,'C',4,0,'')},w_PKTBSPECIE);
SPBOUILib.SetInputValue('AAQYBAEHUR',function(){return WtH(w_RNATGIU,'N',3,0,'')},w_RNATGIU);
SPBOUILib.SetInputValue('UQYOQYIUNM',function(){return WtH(w_ATTIVR,'C',10,0,'')},w_ATTIVR);
SPBOUILib.SetInputValue('QFJRACGINU',function(){return WtH(w_ATTIV,'C',10,0,'')},w_ATTIV);
SPBOUILib.SetInputValue('BOECHNDAXS',function(){return WtH(w_RATTIV,'N',3,0,'')},w_RATTIV);
SPBOUILib.SetInputValue('HLXRSSMBIW',function(){return WtH(w_COMPORT,'C',5,0,'')},w_COMPORT);
SPBOUILib.SetInputValue('KYTSUTYBUR',function(){return WtH(w_COMPORT,'C',5,0,'')},w_COMPORT);
SPBOUILib.SetInputValue('ISJKSRTDAC',function(){return WtH(w_RCOMP,'N',3,0,'')},w_RCOMP);
var tmp_OGZVCUPUAY = ToHTag(AsControlValue(w_xdescareag));
if (Ne(e_OGZVCUPUAY,tmp_OGZVCUPUAY)) {
SPBOUILib.SetLabelValue('OGZVCUPUAY','innerHTML',tmp_OGZVCUPUAY);
e_OGZVCUPUAY=tmp_OGZVCUPUAY;
}
var tmp_VTPWYANRQH = ToHTag(AsControlValue(w_xdescnatgiu));
if (Ne(e_VTPWYANRQH,tmp_VTPWYANRQH)) {
SPBOUILib.SetLabelValue('VTPWYANRQH','innerHTML',tmp_VTPWYANRQH);
e_VTPWYANRQH=tmp_VTPWYANRQH;
}
var tmp_SCYSGLNMDS = ToHTag(AsControlValue(w_xdesctipatt));
if (Ne(e_SCYSGLNMDS,tmp_SCYSGLNMDS)) {
SPBOUILib.SetLabelValue('SCYSGLNMDS','innerHTML',tmp_SCYSGLNMDS);
e_SCYSGLNMDS=tmp_SCYSGLNMDS;
}
var tmp_GVJJFQWUGU = ToHTag(AsControlValue(w_xdesccomp));
if (Ne(e_GVJJFQWUGU,tmp_GVJJFQWUGU)) {
SPBOUILib.SetLabelValue('GVJJFQWUGU','innerHTML',tmp_GVJJFQWUGU);
e_GVJJFQWUGU=tmp_GVJJFQWUGU;
}
SPBOUILib.SetInputValue('CWIQJZFJRS',function(){return WtH(w_DOCFILE,'C',100,0,'')},w_DOCFILE);
if(c=Ctrl('SMVVFHCEHA')) selectCombo(c,w_RISGLOB,'C')
SPBOUILib.SetInputValue('MXITFMGTNB',function(){return WtH(w_DATAPROF,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAPROF);
SPBOUILib.SetInputValue('QLLLNEUVYW',function(){return WtH(w_DATAREVPROF,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAREVPROF);
if(c=Ctrl('XFKXBQYUIU')) ChkboxCheckUncheck(c,'S',w_PEP)
if(c=Ctrl('XFKXBQYUIU')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('RHCYCLTWOT')) ChkboxCheckUncheck(c,'S',w_CRIME)
if(c=Ctrl('RHCYCLTWOT')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('DOXBACRWUU',function(){return WtH(w_MITIG,'N',4,0,'')},w_MITIG);
SPBOUILib.SetInputValue('OXGBDTWKSX',function(){return WtH(w_MITIGDOC,'C',100,0,'')},w_MITIGDOC);
if(c=Ctrl('OXWRJNTXVJ')) selectCombo(c,w_VERIFICA,'C')
SPBOUILib.SetInputValue('FTYWOEFIPD',function(){return WtH(w_NOTERIS,'M',10,0,'')},w_NOTERIS);
SPBOUILib.SetInputValue('YFBFKZZRWO',function(){return WtH(w_status,'C',10,0,'')},w_status);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
h=Ge(w_gTipInter,'30') && Le(w_gTipInter,'41') || IsHiddenByStateDriver(Z.Tabs.Get('tabs').GetTabstripID('page_2'));
SetDisplay(Z.Tabs.Get('tabs').GetTabstripID('page_2'),h);
if (h && (Z.Tabs.Get('tabs').IsExpanded('page_2'))) {
Z.Tabs.Get('tabs').Next() || Z.Tabs.Get('tabs').Prev();
}
h=Ge(w_gTipInter,'30') && Le(w_gTipInter,'41') || IsHiddenByStateDriver(Z.Tabs.Get('tabs').GetTabstripID('page_9'));
SetDisplay(Z.Tabs.Get('tabs').GetTabstripID('page_9'),h);
if (h && (Z.Tabs.Get('tabs').IsExpanded('page_9'))) {
Z.Tabs.Get('tabs').Next() || Z.Tabs.Get('tabs').Prev();
}
SetDisplay('AQSQVBKXAL_DIV',IsHiddenByStateDriver('DatiBase'));
SetDisplay('EWPTTWSBMT_DIV',Eq(w_TIPOPERS,'G') || IsHiddenByStateDriver('PF'));
SetDisplay('OQFTKYDCIW_DIV',IsHiddenByStateDriver('AD'));
SetDisplay(Ctrl('HGVEMKOKYZ'),true);
SetDisplay(Ctrl('BYFMKHYARA'),Ne(w_gSeekAos,'S') || Utilities.Make(window).IsInGroup(9));
SetDisplay(Ctrl('PAHSBQSDGU'),Ne(m_cFunction,'view') || Utilities.Make(window).IsInGroup(9));
SetDisplay(Ctrl('VVZBQJZQFF'),Ne(m_cFunction,'view') || Utilities.Make(window).IsInGroup(9));
SetDisplay(Ctrl('GSYDJTTEZF'),(Ne(w_xFLGVALIDO,'S') && Ne(w_xFLGANAVAL,'S')) || Ne(m_cFunction,'view') || Utilities.Make(window).IsInGroup(9));
SetDisplay(Ctrl('VEHZFMLUPL'),Ne(m_cFunction,'view') || Utilities.Make(window).IsInGroup(9));
SetDisplay(Ctrl('HCIJRBXGCX'),Eq(w_CFESTERO,1) || Eq(w_TIPOPERS,'G') || Eq(w_xFLGVALIDO,'S'));
SetDisplay('XCYZDRXAMJ_DIV',Ge(w_gTipInter,'30') && Le(w_gTipInter,'41'));
SetDisplay('RARXYHBSLM_DIV',Ne(w_TIPOPERS,'G'));
SetDisplay('DFNZBCOVFH_DIV',Ge(w_gTipInter,'30') && Le(w_gTipInter,'41'));
SetDisplay(Ctrl('FROMUIZATY'),true || IsHiddenByStateDriver('DATARETT'));
SetDisplay(Ctrl('YZOYIYAUUO'),Empty(w_DATAINI) || IsHiddenByStateDriver('DATAFINE'));
SetDisplay(Ctrl('YZOYIYAUUO_ZOOM'),Empty(w_DATAINI));
SetDisplay(Ctrl('WWXBPXHXEU'),Empty(w_DATAINI));
SetDisplay(Ctrl('REJDXHTDMV'),Lt(w_gTipInter,'30') || Gt(w_gTipInter,'41') || IsHiddenByStateDriver('DATAINI'));
SetDisplay(Ctrl('REJDXHTDMV_ZOOM'),Lt(w_gTipInter,'30') || Gt(w_gTipInter,'41'));
SetDisplay(Ctrl('LOQXTBECEG'),Lt(w_gTipInter,'30') || Gt(w_gTipInter,'41'));
SetDisplay(Ctrl('ODWJZUZDBK'),Lt(w_gTipInter,'30') || Gt(w_gTipInter,'41') || IsHiddenByStateDriver('DISATTIVO'));
SetDisplay(Ctrl('ODWJZUZDBK_ZOOM'),Lt(w_gTipInter,'30') || Gt(w_gTipInter,'41'));
SetDisplay(Ctrl('PWDSDLHUNX'),Lt(w_gTipInter,'30') || Gt(w_gTipInter,'41'));
SetDisplay('PUKLGLJKBW_DIV',Ne(w_TIPOPERS,'G') || Ne(w_gTipInter,'31') || IsHiddenByStateDriver('GestoriContante'));
SetDisplay(Ctrl('BOHBZOSBVJ'),true || IsHiddenByStateDriver('COMPLETA'));
Z.Tabs.Get("tabs_3_AUI").Hide('VECIWQFMOB',IsHiddenByStateDriver('Operazioni'));
Z.Tabs.Get("tabs_3_AUI").Hide('WXIRJORZUM',IsHiddenByStateDriver('Frazionate'));
Z.Tabs.Get("tabs_3_AUI").Hide('XDVUUVRZLV',IsHiddenByStateDriver('Rapporti'));
Z.Tabs.Get("tabs_5_Provvisorie").Hide('YVPVOYKMZA',IsHiddenByStateDriver('Rapporti'));
Z.Tabs.Get("tabs_5_Provvisorie").Hide('MTHMFUOOBG',IsHiddenByStateDriver('Operazioni'));
Z.Tabs.Get("tabs_5_Provvisorie").Hide('WVUNPTQGCF',IsHiddenByStateDriver('Frazionate'));
SetDisplay('HPGCEWAWGV_DIV',Ne(w_TIPOPERS,'G') || Ne(w_gTipInter,'31') || IsHiddenByStateDriver('LegRap'));
SetDisplay(Ctrl('VXXDGFVFTG'),Ne(w_gFlgWU,'S') || IsHiddenByStateDriver('Storico_Ker'));
Z.Tabs.Get("tabs_8_Altri").Hide('AYKUXGKLPO',IsHiddenByStateDriver('DatiAgg'));
Z.Tabs.Get("tabs_8_Altri").Hide('ZETZWJBOFM',IsHiddenByStateDriver('Dipendenza'));
Z.Tabs.Get("tabs_8_Altri").Hide('XDDGTPJDHN',IsHiddenByStateDriver('SogCollegati'));
SetDisplay('FIXFSIUKKN_DIV',IsHiddenByStateDriver('Fatc'));
SetDisplay('WEJOYIAYYL_DIV',IsHiddenByStateDriver('CittaDiv'));
Z.Tabs.Get("tabs_10_Rischio").Hide('WJVOGIFRCK',IsHiddenByStateDriver('ValRisk'));
Z.Tabs.Get("tabs_10_Rischio").Hide('XTDFJTMZAQ',IsHiddenByStateDriver('MitRisk'));
Z.Tabs.Get("tabs_10_Rischio").Hide('TKKVDEVHBF',IsHiddenByStateDriver('Patrimonio'));
Z.Tabs.Get("tabs_10_Rischio").Hide('STJESIOURE',IsHiddenByStateDriver('Reddito'));
SetDisplay(Ctrl('BCZWUTGYEU'),Ne(w_xITFLGPEP,'S') || IsHiddenByStateDriver('P.E.P.'));
SetDisplay(Ctrl('ESBPIXCOCR'),Ne(w_xITFLGPEP,'S') || IsHiddenByStateDriver('Crime'));
SetDisplay(Ctrl('YFBFKZZRWO'),true || IsHiddenByStateDriver('status'));
Z.Tabs.Get("tabs_11_Rischio").Hide('SSIHDIOVZQ',IsHiddenByStateDriver('RilAnom'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["AREAGEO"]=['YEWQBTSTTE'];
HideUI.lblids["ATTIV"]=['LRKNJREBPN'];
HideUI.lblids["ATTIVR"]=['HQMBYZTNNT'];
HideUI.lblids["AUTRILASC"]=['ZPQIEJPWJC'];
HideUI.lblids["BANCABEN"]=['VRPSNLYZFA'];
HideUI.lblids["CAP"]=['GDOCAGKROT'];
HideUI.lblids["CAUSALE"]=['ULEYNEIGRT'];
HideUI.lblids["CITTADIN1"]=['ZZTJUXJOVM'];
HideUI.lblids["CITTADIN2"]=['PHQZJMYLYP'];
HideUI.lblids["CODCAB"]=['WHMXTGXWGC'];
HideUI.lblids["CODFISC"]=['WZDAFMDKJE'];
HideUI.lblids["CODLEGRAP"]=['ZAFNQMBDHV'];
HideUI.lblids["COGNOME"]=['TVSLWOCERI'];
HideUI.lblids["COMPORT"]=['UEHIJUXEBZ'];
HideUI.lblids["CONNES"]=['EKULYOXTJM'];
HideUI.lblids["CONTO"]=['LHMWHZJZVJ'];
HideUI.lblids["DATAFINE"]=['WWXBPXHXEU'];
HideUI.lblids["DATAIDENT"]=['FPRDXPXSKH'];
HideUI.lblids["DATAINI"]=['LOQXTBECEG'];
HideUI.lblids["DATANASC"]=['HZYTDOZFPI'];
HideUI.lblids["DATAPROF"]=['TTZXYWANKG'];
HideUI.lblids["DATARAUT"]=['WXAVWIXQLR'];
HideUI.lblids["DATAREVPROF"]=['ROVJICRYAM'];
HideUI.lblids["DATARILASC"]=['MLJVDLOITR'];
HideUI.lblids["DATASEGN"]=['KGAUNPQRUF'];
HideUI.lblids["DATAVALI"]=['UYGHJPRVKH'];
HideUI.lblids["DESCCIT"]=['XPSQTBKQQZ'];
HideUI.lblids["DISATTIVO"]=['PWDSDLHUNX'];
HideUI.lblids["DOCFILE"]=['CUGDSJZWEC'];
HideUI.lblids["DOMICILIO"]=['TWTXGZJTAR'];
HideUI.lblids["FATCA"]=['KSZOWVNAMH'];
HideUI.lblids["FATTURATO"]=['ZBWPHEDKDN'];
HideUI.lblids["IDENT"]=['XYHCZSITMJ'];
HideUI.lblids["IDNASCOMUN"]=['WVJSUIKYEY'];
HideUI.lblids["IDNASSTATO"]=['ZBRDCBHLZC'];
HideUI.lblids["MITIG"]=['VCBMHLXJMD'];
HideUI.lblids["MITIGDOC"]=['PKJNNGBWFM'];
HideUI.lblids["NOME"]=['KUPYKSUBXV'];
HideUI.lblids["NOTE"]=['GXTICCPRBI'];
HideUI.lblids["NOTERIS"]=['JVQICCQATG'];
HideUI.lblids["NUMDOCUM"]=['YXFGMWZGNN'];
HideUI.lblids["PAESE"]=['RZBLEGCFJJ'];
HideUI.lblids["PARTIVA"]=['WRVDNZJCDE'];
HideUI.lblids["PKTBSPECIE"]=['JMXSJAUKOO'];
HideUI.lblids["PROVINCIA"]=['SBJQIAQUCN'];
HideUI.lblids["RAGSOC"]=['PFEQRACAUA'];
HideUI.lblids["RAMOGRUP"]=['QOLFDIWXXC'];
HideUI.lblids["RAPSEGNA"]=['MASICCONRV'];
HideUI.lblids["RESFISC"]=['LENIFRRGPH'];
HideUI.lblids["RISGLOB"]=['JKZZQYXAFS'];
HideUI.lblids["SESSO"]=['KRSCDPQZTQ'];
HideUI.lblids["SETTSINT"]=['LHHLIWFNCK'];
HideUI.lblids["SOGAFFIDATARIO"]=['EELMPIGUVH'];
HideUI.lblids["SOTGRUP"]=['ZZDCRCKYFX'];
HideUI.lblids["TIN"]=['FAHIRFAJYI'];
HideUI.lblids["TIPINTER"]=['IVAWYVSUQI'];
HideUI.lblids["TIPODOC"]=['YRARWMJPPV'];
HideUI.lblids["TIPOSOGGETTO"]=['PKXIGUDYJJ'];
HideUI.lblids["VERIFICA"]=['CPCPDBCTVR'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function UYWIEUHCAL_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOPERS','C',w_TIPOPERS,HtW(getRadioValue(Ctrl('UYWIEUHCAL')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOPERS(HtW(getRadioValue(Ctrl('UYWIEUHCAL')),'C'),null,e);
return l_bSetResult;
}
}
function href_HGVEMKOKYZ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('SESSO',AsAppletValue(w_SESSO));
l_oWv.setValue('RAGSOCM',AsAppletValue(w_RAGSOC));
l_oWv.setValue('CONNES',AsAppletValue(w_CONNES));
l_oWv.setValue('CFESTERO',AsAppletValue(w_CFESTERO));
l_oWv.setValue('CODFISC',AsAppletValue(w_CODFISC));
l_oWv.setValue('PARTIVA',AsAppletValue(w_PARTIVA));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('SESSO,RAGSOCM,CONNES,CFESTERO,CODFISC,PARTIVA'));
_modifyandopen('arpg_info_pre_prn_scheda_adeguata_ver_clientela'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=280,width=675',null)
}
function href_BYFMKHYARA() {
_modifyandopen(ToResource('jsp/pg_stampa_ricerca_web_portlet.jsp'+'?nominativo='+URLenc(w_RAGSOC)+'&m_cParameterSequence=nominativo')+'&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=510,width=1024',null)
}
function href_PAHSBQSDGU() {
_modifyandopen(ToResource('jsp/pg_chg_connes_portlet.jsp'+'?DaCodCli='+URLenc(w_CONNES)+'&m_cParameterSequence=DaCodCli')+'&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function href_VVZBQJZQFF() {
_modifyandopen(ToResource('jsp/pg_chg_create_portlet.jsp'+'?DaCodCli='+URLenc(w_CONNES)+'&m_cParameterSequence=DaCodCli')+'&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function href_GSYDJTTEZF() {
if (false || WindowConfirm(Translate('640277248'))) {
arrt_sblocco_modifica([["pConnes",w_CONNES],["w_xFLGANAVAL",w_xFLGANAVAL],["w_xFLGVALIDO",w_xFLGVALIDO]])
}
}
function href_VEHZFMLUPL() {
var l_oWv = InitWvApplet();
l_oWv.setValue('CodCli',AsAppletValue(w_CONNES));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('CodCli'));
_modifyandopen('arpg_stampe_sog'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function TWTTDWKCRG_Valid(e) {
SetActiveField(Ctrl('TWTTDWKCRG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('COGNOME','C',w_COGNOME,HtW(Ctrl('TWTTDWKCRG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_COGNOME(HtW(Ctrl('TWTTDWKCRG').value,'C'),null,e);
return l_bSetResult;
}
}
function TWTTDWKCRG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TWTTDWKCRG'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('TWTTDWKCRG',w_COGNOME,'C',26,0,'@!');
SetActiveField(Ctrl('TWTTDWKCRG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TWTTDWKCRG'),e);
}
function TWTTDWKCRG_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function WWGIVGNUDW_Valid(e) {
SetActiveField(Ctrl('WWGIVGNUDW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NOME','C',w_NOME,HtW(Ctrl('WWGIVGNUDW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOME(HtW(Ctrl('WWGIVGNUDW').value,'C'),null,e);
return l_bSetResult;
}
}
function WWGIVGNUDW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WWGIVGNUDW'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('WWGIVGNUDW',w_NOME,'C',25,0,'@!');
SetActiveField(Ctrl('WWGIVGNUDW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WWGIVGNUDW'),e);
}
function WWGIVGNUDW_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function CZTHKEDVCO_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('CFESTERO','N',w_CFESTERO,ChkboxValueAssign(Ctrl('CZTHKEDVCO'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CFESTERO(ChkboxValueAssign(Ctrl('CZTHKEDVCO'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function CZTHKEDVCO_OnFocus(e) {
SetActiveField(Ctrl('CZTHKEDVCO'),true);
}
function CZTHKEDVCO_OnBlur(e) {
SetActiveField(Ctrl('CZTHKEDVCO'),false);
}
function AWPNTOJIRR_Valid(e) {
SetActiveField(Ctrl('AWPNTOJIRR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RAGSOC','C',w_RAGSOC,HtW(Ctrl('AWPNTOJIRR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAGSOC(HtW(Ctrl('AWPNTOJIRR').value,'C'),null,e);
return l_bSetResult;
}
}
function AWPNTOJIRR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AWPNTOJIRR'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('AWPNTOJIRR',w_RAGSOC,'C',70,0,'@!');
SetActiveField(Ctrl('AWPNTOJIRR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AWPNTOJIRR'),e);
}
function AWPNTOJIRR_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function YVIKEGPYPM_Valid(e) {
SetActiveField(Ctrl('YVIKEGPYPM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PAESE','C',w_PAESE,HtW(Ctrl('YVIKEGPYPM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PAESE(HtW(Ctrl('YVIKEGPYPM').value,'C'),null,e);
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
function ODAYKSRECA_Valid(e) {
SetActiveField(Ctrl('ODAYKSRECA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCCIT','C',w_DESCCIT,HtW(Ctrl('ODAYKSRECA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCCIT(HtW(Ctrl('ODAYKSRECA').value,'C'),null,e);
return l_bSetResult;
}
}
function ODAYKSRECA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ODAYKSRECA'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('ODAYKSRECA',w_DESCCIT,'C',30,0,'@!');
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
DoQuery('PROVINCIA','C',w_PROVINCIA,HtW(Ctrl('NOTZPDMYIA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PROVINCIA(HtW(Ctrl('NOTZPDMYIA').value,'C'),null,e);
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
DoQuery('CAP','C',w_CAP,HtW(Ctrl('RDAVOEETJG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAP(HtW(Ctrl('RDAVOEETJG').value,'C'),null,e);
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
DoQuery('CODCAB','C',w_CODCAB,HtW(Ctrl('BOTAJBWHHY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODCAB(HtW(Ctrl('BOTAJBWHHY').value,'C'),null,e);
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
DoQuery('DOMICILIO','C',w_DOMICILIO,HtW(Ctrl('VYLHWTRQNX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DOMICILIO(HtW(Ctrl('VYLHWTRQNX').value,'C'),null,e);
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
function IRLEJAUHCB_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('IDENT','C',w_IDENT,HtW(getComboValue(Ctrl('IRLEJAUHCB')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDENT(HtW(getComboValue(Ctrl('IRLEJAUHCB')),'C'),null,e);
return l_bSetResult;
}
}
function IRLEJAUHCB_OnFocus(e) {
SetActiveField(Ctrl('IRLEJAUHCB'),true);
}
function IRLEJAUHCB_OnBlur(e) {
SetActiveField(Ctrl('IRLEJAUHCB'),false);
}
function BYPEBFEOAJ_Valid(e) {
SetActiveField(Ctrl('BYPEBFEOAJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDNASCOMUN','C',w_IDNASCOMUN,HtW(Ctrl('BYPEBFEOAJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDNASCOMUN(HtW(Ctrl('BYPEBFEOAJ').value,'C'),null,e);
return l_bSetResult;
}
}
function BYPEBFEOAJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BYPEBFEOAJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BYPEBFEOAJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BYPEBFEOAJ'),e);
}
function BYPEBFEOAJ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('BYPEBFEOAJ')),'linkview_BYPEBFEOAJ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function NEUBQNUEOJ_Valid(e) {
SetActiveField(Ctrl('NEUBQNUEOJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NASCOMUN','C',w_NASCOMUN,HtW(Ctrl('NEUBQNUEOJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NASCOMUN(HtW(Ctrl('NEUBQNUEOJ').value,'C'),null,e);
return l_bSetResult;
}
}
function NEUBQNUEOJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NEUBQNUEOJ'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('NEUBQNUEOJ',w_NASCOMUN,'C',30,0,'@!');
SetActiveField(Ctrl('NEUBQNUEOJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NEUBQNUEOJ'),e);
}
function NEUBQNUEOJ_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function KPSCOABZLB_Valid(e) {
SetActiveField(Ctrl('KPSCOABZLB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TIPINTER','C',w_TIPINTER,HtW(Ctrl('KPSCOABZLB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPINTER(HtW(Ctrl('KPSCOABZLB').value,'C'),null,e);
return l_bSetResult;
}
}
function KPSCOABZLB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KPSCOABZLB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KPSCOABZLB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KPSCOABZLB'),e);
}
function IOAMSFCCVV_Valid(e) {
SetActiveField(Ctrl('IOAMSFCCVV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDNASSTATO','C',w_IDNASSTATO,HtW(Ctrl('IOAMSFCCVV').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDNASSTATO(HtW(Ctrl('IOAMSFCCVV').value,'C'),null,e);
return l_bSetResult;
}
}
function IOAMSFCCVV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IOAMSFCCVV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IOAMSFCCVV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IOAMSFCCVV'),e);
}
function IOAMSFCCVV_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('IOAMSFCCVV')),'linkview_IOAMSFCCVV','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function HODZKKOSYW_Valid(e) {
SetActiveField(Ctrl('HODZKKOSYW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NASSTATO','C',w_NASSTATO,HtW(Ctrl('HODZKKOSYW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NASSTATO(HtW(Ctrl('HODZKKOSYW').value,'C'),null,e);
return l_bSetResult;
}
}
function HODZKKOSYW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HODZKKOSYW'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('HODZKKOSYW',w_NASSTATO,'C',30,0,'@!');
SetActiveField(Ctrl('HODZKKOSYW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HODZKKOSYW'),e);
}
function HODZKKOSYW_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function QPALJZMFCL_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('SESSO','C',w_SESSO,HtW(getComboValue(Ctrl('QPALJZMFCL')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SESSO(HtW(getComboValue(Ctrl('QPALJZMFCL')),'C'),null,e);
return l_bSetResult;
}
}
function QPALJZMFCL_OnFocus(e) {
SetActiveField(Ctrl('QPALJZMFCL'),true);
}
function QPALJZMFCL_OnBlur(e) {
SetActiveField(Ctrl('QPALJZMFCL'),false);
}
function XMGRWGFSFV_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('XMGRWGFSFV'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('XMGRWGFSFV').value=ApplyPictureToDate(Ctrl('XMGRWGFSFV').value,TranslatePicture(datePattern),'XMGRWGFSFV');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('XMGRWGFSFV'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('XMGRWGFSFV');
}
}
}
SetActiveField(Ctrl('XMGRWGFSFV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATANASC','D',w_DATANASC,HtW(Ctrl('XMGRWGFSFV').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATANASC(HtW(Ctrl('XMGRWGFSFV').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function XMGRWGFSFV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XMGRWGFSFV'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('XMGRWGFSFV'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('XMGRWGFSFV',w_DATANASC,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('XMGRWGFSFV');
SetActiveField(Ctrl('XMGRWGFSFV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XMGRWGFSFV'),e);
}
function XMGRWGFSFV_ZOOM_Click() {
LaunchCalendar(Ctrl('XMGRWGFSFV'));
}
function MBGANUUHRA_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPODOC','C',w_TIPODOC,HtW(getComboValue(Ctrl('MBGANUUHRA')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPODOC(HtW(getComboValue(Ctrl('MBGANUUHRA')),'C'),null,e);
return l_bSetResult;
}
}
function MBGANUUHRA_OnFocus(e) {
SetActiveField(Ctrl('MBGANUUHRA'),true);
}
function MBGANUUHRA_OnBlur(e) {
SetActiveField(Ctrl('MBGANUUHRA'),false);
}
function HVEEMUJUUY_Valid(e) {
SetActiveField(Ctrl('HVEEMUJUUY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NUMDOCUM','C',w_NUMDOCUM,HtW(Ctrl('HVEEMUJUUY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NUMDOCUM(HtW(Ctrl('HVEEMUJUUY').value,'C'),null,e);
return l_bSetResult;
}
}
function HVEEMUJUUY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HVEEMUJUUY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HVEEMUJUUY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HVEEMUJUUY'),e);
}
function XHWYGOPPUN_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('XHWYGOPPUN'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('XHWYGOPPUN').value=ApplyPictureToDate(Ctrl('XHWYGOPPUN').value,TranslatePicture(datePattern),'XHWYGOPPUN');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('XHWYGOPPUN'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('XHWYGOPPUN');
}
}
}
SetActiveField(Ctrl('XHWYGOPPUN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATARILASC','D',w_DATARILASC,HtW(Ctrl('XHWYGOPPUN').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATARILASC(HtW(Ctrl('XHWYGOPPUN').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function XHWYGOPPUN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XHWYGOPPUN'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('XHWYGOPPUN'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('XHWYGOPPUN',w_DATARILASC,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('XHWYGOPPUN');
SetActiveField(Ctrl('XHWYGOPPUN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XHWYGOPPUN'),e);
}
function XHWYGOPPUN_ZOOM_Click() {
LaunchCalendar(Ctrl('XHWYGOPPUN'));
}
function BNWXBPSIDG_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('BNWXBPSIDG'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('BNWXBPSIDG').value=ApplyPictureToDate(Ctrl('BNWXBPSIDG').value,TranslatePicture(datePattern),'BNWXBPSIDG');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('BNWXBPSIDG'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('BNWXBPSIDG');
}
}
}
SetActiveField(Ctrl('BNWXBPSIDG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAVALI','D',w_DATAVALI,HtW(Ctrl('BNWXBPSIDG').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAVALI(HtW(Ctrl('BNWXBPSIDG').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function BNWXBPSIDG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BNWXBPSIDG'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('BNWXBPSIDG',w_DATAVALI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('BNWXBPSIDG');
SetActiveField(Ctrl('BNWXBPSIDG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BNWXBPSIDG'),e);
}
function BNWXBPSIDG_ZOOM_Click() {
LaunchCalendar(Ctrl('BNWXBPSIDG'));
}
function HRNCPADUFU_Valid(e) {
SetActiveField(Ctrl('HRNCPADUFU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('AUTRILASC','C',w_AUTRILASC,HtW(Ctrl('HRNCPADUFU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_AUTRILASC(HtW(Ctrl('HRNCPADUFU').value,'C'),null,e);
return l_bSetResult;
}
}
function HRNCPADUFU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HRNCPADUFU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HRNCPADUFU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HRNCPADUFU'),e);
}
function OJJHIUDPFY_Valid(e) {
SetActiveField(Ctrl('OJJHIUDPFY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODFISC','C',w_CODFISC,HtW(Ctrl('OJJHIUDPFY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODFISC(HtW(Ctrl('OJJHIUDPFY').value,'C'),null,e);
return l_bSetResult;
}
}
function OJJHIUDPFY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OJJHIUDPFY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OJJHIUDPFY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OJJHIUDPFY'),e);
}
function href_HCIJRBXGCX() {
arrt_calccodfis_obj([["pObj",this]])
}
function FHXWUTBNKI_Valid(e) {
SetActiveField(Ctrl('FHXWUTBNKI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PARTIVA','C',w_PARTIVA,HtW(Ctrl('FHXWUTBNKI').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PARTIVA(HtW(Ctrl('FHXWUTBNKI').value,'C'),null,e);
return l_bSetResult;
}
}
function FHXWUTBNKI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FHXWUTBNKI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FHXWUTBNKI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FHXWUTBNKI'),e);
}
function JLTVZXPMKM_Valid(e) {
SetActiveField(Ctrl('JLTVZXPMKM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CONTO','C',w_CONTO,HtW(Ctrl('JLTVZXPMKM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONTO(HtW(Ctrl('JLTVZXPMKM').value,'C'),null,e);
return l_bSetResult;
}
}
function JLTVZXPMKM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JLTVZXPMKM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JLTVZXPMKM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JLTVZXPMKM'),e);
}
function LLYIGAMXRH_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('SOTGRUP','C',w_SOTGRUP,HtW(getComboValue(Ctrl('LLYIGAMXRH')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SOTGRUP(HtW(getComboValue(Ctrl('LLYIGAMXRH')),'C'),null,e);
return l_bSetResult;
}
}
function LLYIGAMXRH_OnFocus(e) {
SetActiveField(Ctrl('LLYIGAMXRH'),true);
}
function LLYIGAMXRH_OnBlur(e) {
SetActiveField(Ctrl('LLYIGAMXRH'),false);
}
function SAQTIHOALW_Valid(e) {
SetActiveField(Ctrl('SAQTIHOALW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ATTIV','C',w_ATTIV,HtW(Ctrl('SAQTIHOALW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ATTIV(HtW(Ctrl('SAQTIHOALW').value,'C'),null,e);
return l_bSetResult;
}
}
function SAQTIHOALW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SAQTIHOALW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SAQTIHOALW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SAQTIHOALW'),e);
}
function SAQTIHOALW_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('SAQTIHOALW')),'linkview_SAQTIHOALW','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function ZGNLLSFQHC_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('SETTSINT','C',w_SETTSINT,HtW(getComboValue(Ctrl('ZGNLLSFQHC')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SETTSINT(HtW(getComboValue(Ctrl('ZGNLLSFQHC')),'C'),null,e);
return l_bSetResult;
}
}
function ZGNLLSFQHC_OnFocus(e) {
SetActiveField(Ctrl('ZGNLLSFQHC'),true);
}
function ZGNLLSFQHC_OnBlur(e) {
SetActiveField(Ctrl('ZGNLLSFQHC'),false);
}
function href_UQJBFPCIGV() {
if (false || WindowConfirm(Translate('2021305833'))) {
arrt_calcolasett([])
}
}
function YTPWDRMFUS_Valid(e) {
SetActiveField(Ctrl('YTPWDRMFUS'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('YTPWDRMFUS') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CONNES','C',w_CONNES,HtW(Ctrl('YTPWDRMFUS').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONNES(HtW(Ctrl('YTPWDRMFUS').value,'C'),null,e);
return l_bSetResult;
}
}
function YTPWDRMFUS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YTPWDRMFUS'))) {
DisplayErrorMessage();
}
if ( ! (GetDisabled('YTPWDRMFUS'))) {
if (Eq(w_CONNES,'') && Eq(_tracker.ctrl,null)) {
Ctrl('YTPWDRMFUS').value=WtH(w_CODFISC,'C',16,0,'');
} else {
}
}
SetActiveField(Ctrl('YTPWDRMFUS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YTPWDRMFUS'),e);
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
function RARXYHBSLM_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('NOTIT','N',w_NOTIT,ChkboxValueAssign(Ctrl('RARXYHBSLM'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOTIT(ChkboxValueAssign(Ctrl('RARXYHBSLM'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function RARXYHBSLM_OnFocus(e) {
SetActiveField(Ctrl('RARXYHBSLM'),true);
}
function RARXYHBSLM_OnBlur(e) {
SetActiveField(Ctrl('RARXYHBSLM'),false);
}
function DFNZBCOVFH_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('flgaggfam','C',w_flgaggfam,ChkboxValueAssign(Ctrl('DFNZBCOVFH'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_flgaggfam(ChkboxValueAssign(Ctrl('DFNZBCOVFH'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function DFNZBCOVFH_OnFocus(e) {
SetActiveField(Ctrl('DFNZBCOVFH'),true);
}
function DFNZBCOVFH_OnBlur(e) {
SetActiveField(Ctrl('DFNZBCOVFH'),false);
}
function FROMUIZATY_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('FROMUIZATY'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('FROMUIZATY').value=ApplyPictureToDate(Ctrl('FROMUIZATY').value,TranslatePicture(datePattern),'FROMUIZATY');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('FROMUIZATY'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('FROMUIZATY');
}
}
}
SetActiveField(Ctrl('FROMUIZATY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATARETT','D',w_DATARETT,HtW(Ctrl('FROMUIZATY').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATARETT(HtW(Ctrl('FROMUIZATY').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function FROMUIZATY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FROMUIZATY'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('FROMUIZATY',w_DATARETT,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('FROMUIZATY');
SetActiveField(Ctrl('FROMUIZATY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FROMUIZATY'),e);
}
function YZOYIYAUUO_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('YZOYIYAUUO'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('YZOYIYAUUO').value=ApplyPictureToDate(Ctrl('YZOYIYAUUO').value,TranslatePicture(datePattern),'YZOYIYAUUO');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('YZOYIYAUUO'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('YZOYIYAUUO');
}
}
}
SetActiveField(Ctrl('YZOYIYAUUO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAFINE','D',w_DATAFINE,HtW(Ctrl('YZOYIYAUUO').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAFINE(HtW(Ctrl('YZOYIYAUUO').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function YZOYIYAUUO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YZOYIYAUUO'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('YZOYIYAUUO',w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('YZOYIYAUUO');
SetActiveField(Ctrl('YZOYIYAUUO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YZOYIYAUUO'),e);
}
function YZOYIYAUUO_ZOOM_Click() {
LaunchCalendar(Ctrl('YZOYIYAUUO'));
}
function REJDXHTDMV_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('REJDXHTDMV'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('REJDXHTDMV').value=ApplyPictureToDate(Ctrl('REJDXHTDMV').value,TranslatePicture(datePattern),'REJDXHTDMV');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('REJDXHTDMV'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('REJDXHTDMV');
}
}
}
SetActiveField(Ctrl('REJDXHTDMV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAINI','D',w_DATAINI,HtW(Ctrl('REJDXHTDMV').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAINI(HtW(Ctrl('REJDXHTDMV').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function REJDXHTDMV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('REJDXHTDMV'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('REJDXHTDMV',w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('REJDXHTDMV');
SetActiveField(Ctrl('REJDXHTDMV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('REJDXHTDMV'),e);
}
function REJDXHTDMV_ZOOM_Click() {
LaunchCalendar(Ctrl('REJDXHTDMV'));
}
function ODWJZUZDBK_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('ODWJZUZDBK'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('ODWJZUZDBK').value=ApplyPictureToDate(Ctrl('ODWJZUZDBK').value,TranslatePicture(datePattern),'ODWJZUZDBK');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('ODWJZUZDBK'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('ODWJZUZDBK');
}
}
}
SetActiveField(Ctrl('ODWJZUZDBK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DISATTIVO','D',w_DISATTIVO,HtW(Ctrl('ODWJZUZDBK').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DISATTIVO(HtW(Ctrl('ODWJZUZDBK').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function ODWJZUZDBK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ODWJZUZDBK'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('ODWJZUZDBK',w_DISATTIVO,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('ODWJZUZDBK');
SetActiveField(Ctrl('ODWJZUZDBK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ODWJZUZDBK'),e);
}
function ODWJZUZDBK_ZOOM_Click() {
LaunchCalendar(Ctrl('ODWJZUZDBK'));
}
function JJETXTUKNC_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOSOGGETTO','C',w_TIPOSOGGETTO,HtW(getComboValue(Ctrl('JJETXTUKNC')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOSOGGETTO(HtW(getComboValue(Ctrl('JJETXTUKNC')),'C'),null,e);
return l_bSetResult;
}
}
function JJETXTUKNC_OnFocus(e) {
SetActiveField(Ctrl('JJETXTUKNC'),true);
}
function JJETXTUKNC_OnBlur(e) {
SetActiveField(Ctrl('JJETXTUKNC'),false);
}
function JFJPGOWVYJ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('RAPSEGNA','C',w_RAPSEGNA,HtW(getComboValue(Ctrl('JFJPGOWVYJ')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAPSEGNA(HtW(getComboValue(Ctrl('JFJPGOWVYJ')),'C'),null,e);
return l_bSetResult;
}
}
function JFJPGOWVYJ_OnFocus(e) {
SetActiveField(Ctrl('JFJPGOWVYJ'),true);
}
function JFJPGOWVYJ_OnBlur(e) {
SetActiveField(Ctrl('JFJPGOWVYJ'),false);
}
function HKQDVAPIOQ_Valid(e) {
SetActiveField(Ctrl('HKQDVAPIOQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SOGAFFIDATARIO','C',w_SOGAFFIDATARIO,HtW(Ctrl('HKQDVAPIOQ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SOGAFFIDATARIO(HtW(Ctrl('HKQDVAPIOQ').value,'C'),null,e);
return l_bSetResult;
}
}
function HKQDVAPIOQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HKQDVAPIOQ'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('HKQDVAPIOQ',w_SOGAFFIDATARIO,'C',80,0,'@!');
SetActiveField(Ctrl('HKQDVAPIOQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HKQDVAPIOQ'),e);
}
function HKQDVAPIOQ_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function EMSGWJAYYK_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('CAUSALE','N',w_CAUSALE,HtW(getComboValue(Ctrl('EMSGWJAYYK')),'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAUSALE(HtW(getComboValue(Ctrl('EMSGWJAYYK')),'N'),null,e);
return l_bSetResult;
}
}
function EMSGWJAYYK_OnFocus(e) {
SetActiveField(Ctrl('EMSGWJAYYK'),true);
}
function EMSGWJAYYK_OnBlur(e) {
SetActiveField(Ctrl('EMSGWJAYYK'),false);
}
function XOROAVXTCD_Valid(e) {
SetActiveField(Ctrl('XOROAVXTCD'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('FATTURATO','N',w_FATTURATO,HtW(Ctrl('XOROAVXTCD').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FATTURATO(HtW(Ctrl('XOROAVXTCD').value,'N'),null,e);
return l_bSetResult;
}
}
function XOROAVXTCD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XOROAVXTCD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XOROAVXTCD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XOROAVXTCD'),e);
}
function XERWNYQDBZ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGNOTRIM','C',w_FLGNOTRIM,ChkboxValueAssign(Ctrl('XERWNYQDBZ'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGNOTRIM(ChkboxValueAssign(Ctrl('XERWNYQDBZ'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function XERWNYQDBZ_OnFocus(e) {
SetActiveField(Ctrl('XERWNYQDBZ'),true);
}
function XERWNYQDBZ_OnBlur(e) {
SetActiveField(Ctrl('XERWNYQDBZ'),false);
}
function EVYVDDYVDZ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('EVYVDDYVDZ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('EVYVDDYVDZ').value=ApplyPictureToDate(Ctrl('EVYVDDYVDZ').value,TranslatePicture(datePattern),'EVYVDDYVDZ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('EVYVDDYVDZ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('EVYVDDYVDZ');
}
}
}
SetActiveField(Ctrl('EVYVDDYVDZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAIDENT','D',w_DATAIDENT,HtW(Ctrl('EVYVDDYVDZ').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAIDENT(HtW(Ctrl('EVYVDDYVDZ').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function EVYVDDYVDZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EVYVDDYVDZ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('EVYVDDYVDZ',w_DATAIDENT,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('EVYVDDYVDZ');
SetActiveField(Ctrl('EVYVDDYVDZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EVYVDDYVDZ'),e);
}
function EVYVDDYVDZ_ZOOM_Click() {
LaunchCalendar(Ctrl('EVYVDDYVDZ'));
}
function BOHBZOSBVJ_Valid(e) {
SetActiveField(Ctrl('BOHBZOSBVJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('COMPLETA','L',w_COMPLETA,HtW(Ctrl('BOHBZOSBVJ').value,'L'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_COMPLETA(HtW(Ctrl('BOHBZOSBVJ').value,'L'),null,e);
return l_bSetResult;
}
}
function BOHBZOSBVJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BOHBZOSBVJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BOHBZOSBVJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BOHBZOSBVJ'),e);
}
function UMKFMWBVUO_Valid(e) {
SetActiveField(Ctrl('UMKFMWBVUO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NOTE','M',w_NOTE,HtW(Ctrl('UMKFMWBVUO').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOTE(HtW(Ctrl('UMKFMWBVUO').value,'M'),null,e);
return l_bSetResult;
}
}
function UMKFMWBVUO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UMKFMWBVUO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UMKFMWBVUO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UMKFMWBVUO'),e);
}
function CKHRNQSKKQ_Valid(e) {
SetActiveField(Ctrl('CKHRNQSKKQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODLEGRAP','C',w_CODLEGRAP,HtW(Ctrl('CKHRNQSKKQ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODLEGRAP(HtW(Ctrl('CKHRNQSKKQ').value,'C'),null,e);
return l_bSetResult;
}
}
function CKHRNQSKKQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CKHRNQSKKQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CKHRNQSKKQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CKHRNQSKKQ'),e);
}
function CKHRNQSKKQ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('CKHRNQSKKQ')),'linkview_CKHRNQSKKQ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function DQZNJUSTLN_Valid(e) {
SetActiveField(Ctrl('DQZNJUSTLN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('BANCABEN','C',w_BANCABEN,HtW(Ctrl('DQZNJUSTLN').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_BANCABEN(HtW(Ctrl('DQZNJUSTLN').value,'C'),null,e);
return l_bSetResult;
}
}
function DQZNJUSTLN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DQZNJUSTLN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DQZNJUSTLN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DQZNJUSTLN'),e);
}
function DQZNJUSTLN_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('DQZNJUSTLN')),'linkview_DQZNJUSTLN','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function ESODTMPIYO_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('ESODTMPIYO'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('ESODTMPIYO').value=ApplyPictureToDate(Ctrl('ESODTMPIYO').value,TranslatePicture(datePattern),'ESODTMPIYO');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('ESODTMPIYO'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('ESODTMPIYO');
}
}
}
SetActiveField(Ctrl('ESODTMPIYO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATASEGN','D',w_DATASEGN,HtW(Ctrl('ESODTMPIYO').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATASEGN(HtW(Ctrl('ESODTMPIYO').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function ESODTMPIYO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ESODTMPIYO'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('ESODTMPIYO',w_DATASEGN,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('ESODTMPIYO');
SetActiveField(Ctrl('ESODTMPIYO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ESODTMPIYO'),e);
}
function ESODTMPIYO_ZOOM_Click() {
LaunchCalendar(Ctrl('ESODTMPIYO'));
}
function UNPDFRUOXO_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('UNPDFRUOXO'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('UNPDFRUOXO').value=ApplyPictureToDate(Ctrl('UNPDFRUOXO').value,TranslatePicture(datePattern),'UNPDFRUOXO');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('UNPDFRUOXO'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('UNPDFRUOXO');
}
}
}
SetActiveField(Ctrl('UNPDFRUOXO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATARAUT','D',w_DATARAUT,HtW(Ctrl('UNPDFRUOXO').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATARAUT(HtW(Ctrl('UNPDFRUOXO').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function UNPDFRUOXO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UNPDFRUOXO'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('UNPDFRUOXO',w_DATARAUT,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('UNPDFRUOXO');
SetActiveField(Ctrl('UNPDFRUOXO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UNPDFRUOXO'),e);
}
function UNPDFRUOXO_ZOOM_Click() {
LaunchCalendar(Ctrl('UNPDFRUOXO'));
}
function RKHMYOIJDM_Valid(e) {
SetActiveField(Ctrl('RKHMYOIJDM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('FATCA','C',w_FATCA,HtW(Ctrl('RKHMYOIJDM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FATCA(HtW(Ctrl('RKHMYOIJDM').value,'C'),null,e);
return l_bSetResult;
}
}
function RKHMYOIJDM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RKHMYOIJDM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RKHMYOIJDM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RKHMYOIJDM'),e);
}
function RKHMYOIJDM_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('RKHMYOIJDM')),'linkview_RKHMYOIJDM','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function HBSPPQBOJN_Valid(e) {
SetActiveField(Ctrl('HBSPPQBOJN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TIN','C',w_TIN,HtW(Ctrl('HBSPPQBOJN').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIN(HtW(Ctrl('HBSPPQBOJN').value,'C'),null,e);
return l_bSetResult;
}
}
function HBSPPQBOJN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HBSPPQBOJN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HBSPPQBOJN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HBSPPQBOJN'),e);
}
function EOYNWRHHMY_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('ODB','N',w_ODB,ChkboxValueAssign(Ctrl('EOYNWRHHMY'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ODB(ChkboxValueAssign(Ctrl('EOYNWRHHMY'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function EOYNWRHHMY_OnFocus(e) {
SetActiveField(Ctrl('EOYNWRHHMY'),true);
}
function EOYNWRHHMY_OnBlur(e) {
SetActiveField(Ctrl('EOYNWRHHMY'),false);
}
function CYHJRUWRUL_Click() {
var l_oWv = InitWvApplet();
l_oWv.setValue('cConnes',AsAppletValue(w_CONNES));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('cConnes'));
if (Eq(m_cFunction,'view')) {
if (false || WindowConfirm(Translate('10079390723'))) {
_modifyandopen('arrt_load_fatca'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=330,width=750',null)
}
}
}
function CJBEXKJOQO_Valid(e) {
SetActiveField(Ctrl('CJBEXKJOQO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CITTADIN1','C',w_CITTADIN1,HtW(Ctrl('CJBEXKJOQO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CITTADIN1(HtW(Ctrl('CJBEXKJOQO').value,'C'),null,e);
return l_bSetResult;
}
}
function CJBEXKJOQO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CJBEXKJOQO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CJBEXKJOQO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CJBEXKJOQO'),e);
}
function CJBEXKJOQO_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('CJBEXKJOQO')),'linkview_CJBEXKJOQO','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function UNRQNVVFTK_Valid(e) {
SetActiveField(Ctrl('UNRQNVVFTK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CITTADIN2','C',w_CITTADIN2,HtW(Ctrl('UNRQNVVFTK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CITTADIN2(HtW(Ctrl('UNRQNVVFTK').value,'C'),null,e);
return l_bSetResult;
}
}
function UNRQNVVFTK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UNRQNVVFTK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UNRQNVVFTK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UNRQNVVFTK'),e);
}
function UNRQNVVFTK_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('UNRQNVVFTK')),'linkview_UNRQNVVFTK','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function OSLBLDODHQ_Valid(e) {
SetActiveField(Ctrl('OSLBLDODHQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RESFISC','C',w_RESFISC,HtW(Ctrl('OSLBLDODHQ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RESFISC(HtW(Ctrl('OSLBLDODHQ').value,'C'),null,e);
return l_bSetResult;
}
}
function OSLBLDODHQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OSLBLDODHQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OSLBLDODHQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OSLBLDODHQ'),e);
}
function OSLBLDODHQ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('OSLBLDODHQ')),'linkview_OSLBLDODHQ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function NXVXQSLAGM_Valid(e) {
SetActiveField(Ctrl('NXVXQSLAGM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('AREAGEO','C',w_AREAGEO,HtW(Ctrl('NXVXQSLAGM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_AREAGEO(HtW(Ctrl('NXVXQSLAGM').value,'C'),null,e);
return l_bSetResult;
}
}
function NXVXQSLAGM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NXVXQSLAGM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NXVXQSLAGM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NXVXQSLAGM'),e);
}
function NXVXQSLAGM_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('NXVXQSLAGM')),'linkview_NXVXQSLAGM','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function PGYFWWGOTN_Valid(e) {
SetActiveField(Ctrl('PGYFWWGOTN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RAREA','N',w_RAREA,HtW(Ctrl('PGYFWWGOTN').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAREA(HtW(Ctrl('PGYFWWGOTN').value,'N'),null,e);
return l_bSetResult;
}
}
function PGYFWWGOTN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PGYFWWGOTN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PGYFWWGOTN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PGYFWWGOTN'),e);
}
function VHXDWWHVXF_Valid(e) {
SetActiveField(Ctrl('VHXDWWHVXF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PKTBSPECIE','C',w_PKTBSPECIE,HtW(Ctrl('VHXDWWHVXF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PKTBSPECIE(HtW(Ctrl('VHXDWWHVXF').value,'C'),null,e);
return l_bSetResult;
}
}
function VHXDWWHVXF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VHXDWWHVXF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VHXDWWHVXF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VHXDWWHVXF'),e);
}
function VHXDWWHVXF_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('VHXDWWHVXF')),'linkview_VHXDWWHVXF','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function AAQYBAEHUR_Valid(e) {
SetActiveField(Ctrl('AAQYBAEHUR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RNATGIU','N',w_RNATGIU,HtW(Ctrl('AAQYBAEHUR').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RNATGIU(HtW(Ctrl('AAQYBAEHUR').value,'N'),null,e);
return l_bSetResult;
}
}
function AAQYBAEHUR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AAQYBAEHUR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('AAQYBAEHUR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AAQYBAEHUR'),e);
}
function UQYOQYIUNM_Valid(e) {
SetActiveField(Ctrl('UQYOQYIUNM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ATTIVR','C',w_ATTIVR,HtW(Ctrl('UQYOQYIUNM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ATTIVR(HtW(Ctrl('UQYOQYIUNM').value,'C'),null,e);
return l_bSetResult;
}
}
function UQYOQYIUNM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UQYOQYIUNM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UQYOQYIUNM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UQYOQYIUNM'),e);
}
function UQYOQYIUNM_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('UQYOQYIUNM')),'linkview_UQYOQYIUNM','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function BOECHNDAXS_Valid(e) {
SetActiveField(Ctrl('BOECHNDAXS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RATTIV','N',w_RATTIV,HtW(Ctrl('BOECHNDAXS').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RATTIV(HtW(Ctrl('BOECHNDAXS').value,'N'),null,e);
return l_bSetResult;
}
}
function BOECHNDAXS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BOECHNDAXS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BOECHNDAXS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BOECHNDAXS'),e);
}
function HLXRSSMBIW_Valid(e) {
SetActiveField(Ctrl('HLXRSSMBIW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('COMPORT','C',w_COMPORT,HtW(Ctrl('HLXRSSMBIW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_COMPORT(HtW(Ctrl('HLXRSSMBIW').value,'C'),null,e);
return l_bSetResult;
}
}
function HLXRSSMBIW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HLXRSSMBIW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HLXRSSMBIW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HLXRSSMBIW'),e);
}
function HLXRSSMBIW_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('HLXRSSMBIW')),'linkview_HLXRSSMBIW','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function ISJKSRTDAC_Valid(e) {
SetActiveField(Ctrl('ISJKSRTDAC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RCOMP','N',w_RCOMP,HtW(Ctrl('ISJKSRTDAC').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RCOMP(HtW(Ctrl('ISJKSRTDAC').value,'N'),null,e);
return l_bSetResult;
}
}
function ISJKSRTDAC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ISJKSRTDAC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ISJKSRTDAC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ISJKSRTDAC'),e);
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
function MXITFMGTNB_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('MXITFMGTNB'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('MXITFMGTNB').value=ApplyPictureToDate(Ctrl('MXITFMGTNB').value,TranslatePicture(datePattern),'MXITFMGTNB');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('MXITFMGTNB'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('MXITFMGTNB');
}
}
}
SetActiveField(Ctrl('MXITFMGTNB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAPROF','D',w_DATAPROF,HtW(Ctrl('MXITFMGTNB').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAPROF(HtW(Ctrl('MXITFMGTNB').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function MXITFMGTNB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MXITFMGTNB'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('MXITFMGTNB',w_DATAPROF,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('MXITFMGTNB');
SetActiveField(Ctrl('MXITFMGTNB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MXITFMGTNB'),e);
}
function MXITFMGTNB_ZOOM_Click() {
LaunchCalendar(Ctrl('MXITFMGTNB'));
}
function href_ZFPXBMEPWE() {
arrt_calcola_datarevprof([["pObj",this]])
}
function XFKXBQYUIU_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('PEP','C',w_PEP,ChkboxValueAssign(Ctrl('XFKXBQYUIU'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PEP(ChkboxValueAssign(Ctrl('XFKXBQYUIU'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function XFKXBQYUIU_OnFocus(e) {
SetActiveField(Ctrl('XFKXBQYUIU'),true);
}
function XFKXBQYUIU_OnBlur(e) {
SetActiveField(Ctrl('XFKXBQYUIU'),false);
}
function href_BCZWUTGYEU() {
_modifyandopen(ToResource('jsp/pg_soggettipep_portlet.jsp'+'?w_ragsoc='+URLenc(w_RAGSOC)+'&w_codfisc='+URLenc(w_CODFISC)+'&w_cognome='+URLenc(w_COGNOME)+'&w_nome='+URLenc(w_NOME)+'&w_tipo='+URLenc('F')+'&m_cParameterSequence=w_ragsoc,w_codfisc,w_cognome,w_nome,w_tipo')+'&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function RHCYCLTWOT_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('CRIME','C',w_CRIME,ChkboxValueAssign(Ctrl('RHCYCLTWOT'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CRIME(ChkboxValueAssign(Ctrl('RHCYCLTWOT'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function RHCYCLTWOT_OnFocus(e) {
SetActiveField(Ctrl('RHCYCLTWOT'),true);
}
function RHCYCLTWOT_OnBlur(e) {
SetActiveField(Ctrl('RHCYCLTWOT'),false);
}
function href_ESBPIXCOCR() {
_modifyandopen(ToResource('jsp/pg_soggetticrime_portlet.jsp'+'?w_ragsoc='+URLenc(w_RAGSOC)+'&w_codfisc='+URLenc(w_CODFISC)+'&w_cognome='+URLenc(w_COGNOME)+'&w_nome='+URLenc(w_NOME)+'&w_tipo='+URLenc('F')+'&m_cParameterSequence=w_ragsoc,w_codfisc,w_cognome,w_nome,w_tipo')+'&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
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
function OXWRJNTXVJ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VERIFICA','C',w_VERIFICA,HtW(getComboValue(Ctrl('OXWRJNTXVJ')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VERIFICA(HtW(getComboValue(Ctrl('OXWRJNTXVJ')),'C'),null,e);
return l_bSetResult;
}
}
function OXWRJNTXVJ_OnFocus(e) {
SetActiveField(Ctrl('OXWRJNTXVJ'),true);
}
function OXWRJNTXVJ_OnBlur(e) {
SetActiveField(Ctrl('OXWRJNTXVJ'),false);
}
function FTYWOEFIPD_Valid(e) {
SetActiveField(Ctrl('FTYWOEFIPD'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NOTERIS','M',w_NOTERIS,HtW(Ctrl('FTYWOEFIPD').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOTERIS(HtW(Ctrl('FTYWOEFIPD').value,'M'),null,e);
return l_bSetResult;
}
}
function FTYWOEFIPD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FTYWOEFIPD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FTYWOEFIPD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FTYWOEFIPD'),e);
}
function YFBFKZZRWO_Valid(e) {
SetActiveField(Ctrl('YFBFKZZRWO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('status','C',w_status,HtW(Ctrl('YFBFKZZRWO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_status(HtW(Ctrl('YFBFKZZRWO').value,'C'),null,e);
return l_bSetResult;
}
}
function YFBFKZZRWO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YFBFKZZRWO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YFBFKZZRWO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YFBFKZZRWO'),e);
}
linkpc_url.u('BKKASVQSWO',function(){return 'ardt_personbo_dip?m_bInnerChild=true'+GetLinkPCKeys('ardt_personbo_dip')+'&m_bRowsChild='+EnableChild('ardt_personbo_dip')})
linkpc_url.u('OIREAEXNKZ',function(){return 'armt_personbo_agg?m_bInnerChild=true'+GetLinkPCKeys('armt_personbo_agg')+'&m_bRowsChild='+EnableChild('armt_personbo_agg')})
linkpc_url.u('RYYOFFRITV',function(){return 'ardt_soggope?m_bInnerChild=true'+GetLinkPCKeys('ardt_soggope')+'&m_bRowsChild='+EnableChild('ardt_soggope')})
linkpc_url.u('FBAHOFZNEF',function(){return 'ardt_fatca_ind?m_bInnerChild=true'+GetLinkPCKeys('ardt_fatca_ind')+'&m_bRowsChild='+EnableChild('ardt_fatca_ind')})
linkpc_url.u('FFIYUAKUTX',function(){return 'ardt_patrimonio?m_bInnerChild=true'+GetLinkPCKeys('ardt_patrimonio')+'&m_bRowsChild='+EnableChild('ardt_patrimonio')})
linkpc_url.u('COWMRLCMMU',function(){return 'ardt_reddito?m_bInnerChild=true'+GetLinkPCKeys('ardt_reddito')+'&m_bRowsChild='+EnableChild('ardt_reddito')})
_ResetTracker();
function setEventHandlers() {
var c;
function HGVEMKOKYZ_wrap_OnClick(event) {
return href_HGVEMKOKYZ();
}
SPBOUILib.SetImageClick('HGVEMKOKYZ',HGVEMKOKYZ_wrap_OnClick);
function HGVEMKOKYZ_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('HGVEMKOKYZ',HGVEMKOKYZ_wrap_OnKeyDown);
function BYFMKHYARA_wrap_OnClick(event) {
return href_BYFMKHYARA();
}
SPBOUILib.SetImageClick('BYFMKHYARA',BYFMKHYARA_wrap_OnClick);
function BYFMKHYARA_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('BYFMKHYARA',BYFMKHYARA_wrap_OnKeyDown);
function PAHSBQSDGU_wrap_OnClick(event) {
return href_PAHSBQSDGU();
}
SPBOUILib.SetImageClick('PAHSBQSDGU',PAHSBQSDGU_wrap_OnClick);
function PAHSBQSDGU_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('PAHSBQSDGU',PAHSBQSDGU_wrap_OnKeyDown);
function VVZBQJZQFF_wrap_OnClick(event) {
return href_VVZBQJZQFF();
}
SPBOUILib.SetImageClick('VVZBQJZQFF',VVZBQJZQFF_wrap_OnClick);
function VVZBQJZQFF_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('VVZBQJZQFF',VVZBQJZQFF_wrap_OnKeyDown);
function GSYDJTTEZF_wrap_OnClick(event) {
return href_GSYDJTTEZF();
}
SPBOUILib.SetImageClick('GSYDJTTEZF',GSYDJTTEZF_wrap_OnClick);
function GSYDJTTEZF_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('GSYDJTTEZF',GSYDJTTEZF_wrap_OnKeyDown);
function VEHZFMLUPL_wrap_OnClick(event) {
return href_VEHZFMLUPL();
}
SPBOUILib.SetImageClick('VEHZFMLUPL',VEHZFMLUPL_wrap_OnClick);
function VEHZFMLUPL_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('VEHZFMLUPL',VEHZFMLUPL_wrap_OnKeyDown);
function HCIJRBXGCX_wrap_OnClick(event) {
return href_HCIJRBXGCX();
}
SPBOUILib.SetImageClick('HCIJRBXGCX',HCIJRBXGCX_wrap_OnClick);
function HCIJRBXGCX_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('HCIJRBXGCX',HCIJRBXGCX_wrap_OnKeyDown);
function UQJBFPCIGV_wrap_OnClick(event) {
return href_UQJBFPCIGV();
}
SPBOUILib.SetImageClick('UQJBFPCIGV',UQJBFPCIGV_wrap_OnClick);
function UQJBFPCIGV_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('UQJBFPCIGV',UQJBFPCIGV_wrap_OnKeyDown);
function CYHJRUWRUL_wrap_OnClick(event) {
return CYHJRUWRUL_Click();
}
SPBOUILib.SetButtonClick('CYHJRUWRUL',CYHJRUWRUL_wrap_OnClick);
function ZFPXBMEPWE_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?href_ZFPXBMEPWE():void(0));
}
SPBOUILib.SetImageClick('ZFPXBMEPWE',ZFPXBMEPWE_wrap_OnClick);
function ZFPXBMEPWE_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('ZFPXBMEPWE',ZFPXBMEPWE_wrap_OnKeyDown);
function BCZWUTGYEU_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?href_BCZWUTGYEU():void(0));
}
SPBOUILib.SetImageClick('BCZWUTGYEU',BCZWUTGYEU_wrap_OnClick);
function BCZWUTGYEU_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('BCZWUTGYEU',BCZWUTGYEU_wrap_OnKeyDown);
function ESBPIXCOCR_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?href_ESBPIXCOCR():void(0));
}
SPBOUILib.SetImageClick('ESBPIXCOCR',ESBPIXCOCR_wrap_OnClick);
function ESBPIXCOCR_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('ESBPIXCOCR',ESBPIXCOCR_wrap_OnKeyDown);
if (Ne(m_cFunction,'view')) {
function UYWIEUHCAL_wrap_Valid(event) {
return UYWIEUHCAL_Valid(event);
}
SPBOUILib.SetRadioClick('UYWIEUHCAL',UYWIEUHCAL_wrap_Valid);
function TWTTDWKCRG_wrap_Valid(event) {
return TWTTDWKCRG_Valid(event);
}
SPBOUILib.SetInputExit('TWTTDWKCRG',TWTTDWKCRG_wrap_Valid);
function TWTTDWKCRG_wrap_OnFocus(event) {
return TWTTDWKCRG_OnFocus(event);
}
SPBOUILib.SetInputEnter('TWTTDWKCRG',TWTTDWKCRG_wrap_OnFocus);
function TWTTDWKCRG_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('TWTTDWKCRG',TWTTDWKCRG_wrap_OnKeyPress);
function TWTTDWKCRG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TWTTDWKCRG',TWTTDWKCRG_wrap_OnKeyDown);
function WWGIVGNUDW_wrap_Valid(event) {
return WWGIVGNUDW_Valid(event);
}
SPBOUILib.SetInputExit('WWGIVGNUDW',WWGIVGNUDW_wrap_Valid);
function WWGIVGNUDW_wrap_OnFocus(event) {
return WWGIVGNUDW_OnFocus(event);
}
SPBOUILib.SetInputEnter('WWGIVGNUDW',WWGIVGNUDW_wrap_OnFocus);
function WWGIVGNUDW_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('WWGIVGNUDW',WWGIVGNUDW_wrap_OnKeyPress);
function WWGIVGNUDW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WWGIVGNUDW',WWGIVGNUDW_wrap_OnKeyDown);
function CZTHKEDVCO_wrap_Valid(event) {
return CZTHKEDVCO_Valid(event);
}
SPBOUILib.SetCheckboxClick('CZTHKEDVCO',CZTHKEDVCO_wrap_Valid);
function CZTHKEDVCO_wrap_OnFocus(event) {
return CZTHKEDVCO_OnFocus(event);
}
SPBOUILib.SetInputEnter('CZTHKEDVCO',CZTHKEDVCO_wrap_OnFocus);
function CZTHKEDVCO_wrap_Blur(event) {
return CZTHKEDVCO_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('CZTHKEDVCO',CZTHKEDVCO_wrap_Blur);
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
function IRLEJAUHCB_wrap_Valid(event) {
return IRLEJAUHCB_Valid(event);
}
SPBOUILib.SetComboChange('IRLEJAUHCB',IRLEJAUHCB_wrap_Valid);
function IRLEJAUHCB_wrap_OnFocus(event) {
return IRLEJAUHCB_OnFocus(event);
}
SPBOUILib.SetInputEnter('IRLEJAUHCB',IRLEJAUHCB_wrap_OnFocus);
function IRLEJAUHCB_wrap_Blur(event) {
return IRLEJAUHCB_OnBlur(event);
}
SPBOUILib.SetInputExit('IRLEJAUHCB',IRLEJAUHCB_wrap_Blur);
function BYPEBFEOAJ_wrap_Valid(event) {
return BYPEBFEOAJ_Valid(event);
}
SPBOUILib.SetInputExit('BYPEBFEOAJ',BYPEBFEOAJ_wrap_Valid);
function BYPEBFEOAJ_wrap_OnFocus(event) {
return BYPEBFEOAJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('BYPEBFEOAJ',BYPEBFEOAJ_wrap_OnFocus);
function BYPEBFEOAJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BYPEBFEOAJ',BYPEBFEOAJ_wrap_OnKeyDown);
function BYPEBFEOAJ_ZOOM_setHandlers() {
function BYPEBFEOAJ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?BYPEBFEOAJ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('BYPEBFEOAJ_ZOOM',BYPEBFEOAJ_ZOOM_wrap_OnClick);
function BYPEBFEOAJ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('BYPEBFEOAJ_ZOOM',BYPEBFEOAJ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('BYPEBFEOAJ',BYPEBFEOAJ_ZOOM_setHandlers);
function NEUBQNUEOJ_wrap_Valid(event) {
return NEUBQNUEOJ_Valid(event);
}
SPBOUILib.SetInputExit('NEUBQNUEOJ',NEUBQNUEOJ_wrap_Valid);
function NEUBQNUEOJ_wrap_OnFocus(event) {
return NEUBQNUEOJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('NEUBQNUEOJ',NEUBQNUEOJ_wrap_OnFocus);
function NEUBQNUEOJ_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('NEUBQNUEOJ',NEUBQNUEOJ_wrap_OnKeyPress);
function NEUBQNUEOJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NEUBQNUEOJ',NEUBQNUEOJ_wrap_OnKeyDown);
function KPSCOABZLB_wrap_Valid(event) {
return KPSCOABZLB_Valid(event);
}
SPBOUILib.SetInputExit('KPSCOABZLB',KPSCOABZLB_wrap_Valid);
function KPSCOABZLB_wrap_OnFocus(event) {
return KPSCOABZLB_OnFocus(event);
}
SPBOUILib.SetInputEnter('KPSCOABZLB',KPSCOABZLB_wrap_OnFocus);
function KPSCOABZLB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KPSCOABZLB',KPSCOABZLB_wrap_OnKeyDown);
function IOAMSFCCVV_wrap_Valid(event) {
return IOAMSFCCVV_Valid(event);
}
SPBOUILib.SetInputExit('IOAMSFCCVV',IOAMSFCCVV_wrap_Valid);
function IOAMSFCCVV_wrap_OnFocus(event) {
return IOAMSFCCVV_OnFocus(event);
}
SPBOUILib.SetInputEnter('IOAMSFCCVV',IOAMSFCCVV_wrap_OnFocus);
function IOAMSFCCVV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IOAMSFCCVV',IOAMSFCCVV_wrap_OnKeyDown);
function IOAMSFCCVV_ZOOM_setHandlers() {
function IOAMSFCCVV_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?IOAMSFCCVV_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('IOAMSFCCVV_ZOOM',IOAMSFCCVV_ZOOM_wrap_OnClick);
function IOAMSFCCVV_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('IOAMSFCCVV_ZOOM',IOAMSFCCVV_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('IOAMSFCCVV',IOAMSFCCVV_ZOOM_setHandlers);
function HODZKKOSYW_wrap_Valid(event) {
return HODZKKOSYW_Valid(event);
}
SPBOUILib.SetInputExit('HODZKKOSYW',HODZKKOSYW_wrap_Valid);
function HODZKKOSYW_wrap_OnFocus(event) {
return HODZKKOSYW_OnFocus(event);
}
SPBOUILib.SetInputEnter('HODZKKOSYW',HODZKKOSYW_wrap_OnFocus);
function HODZKKOSYW_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('HODZKKOSYW',HODZKKOSYW_wrap_OnKeyPress);
function HODZKKOSYW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HODZKKOSYW',HODZKKOSYW_wrap_OnKeyDown);
function QPALJZMFCL_wrap_Valid(event) {
return QPALJZMFCL_Valid(event);
}
SPBOUILib.SetComboChange('QPALJZMFCL',QPALJZMFCL_wrap_Valid);
function QPALJZMFCL_wrap_OnFocus(event) {
return QPALJZMFCL_OnFocus(event);
}
SPBOUILib.SetInputEnter('QPALJZMFCL',QPALJZMFCL_wrap_OnFocus);
function QPALJZMFCL_wrap_Blur(event) {
return QPALJZMFCL_OnBlur(event);
}
SPBOUILib.SetInputExit('QPALJZMFCL',QPALJZMFCL_wrap_Blur);
function XMGRWGFSFV_wrap_Valid(event) {
return XMGRWGFSFV_Valid(event);
}
SPBOUILib.SetInputExit('XMGRWGFSFV',XMGRWGFSFV_wrap_Valid);
function XMGRWGFSFV_wrap_OnFocus(event) {
return XMGRWGFSFV_OnFocus(event);
}
SPBOUILib.SetInputEnter('XMGRWGFSFV',XMGRWGFSFV_wrap_OnFocus);
function XMGRWGFSFV_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('XMGRWGFSFV',XMGRWGFSFV_wrap_OnKeyPress);
function XMGRWGFSFV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('XMGRWGFSFV',XMGRWGFSFV_wrap_OnKeyDown);
function XMGRWGFSFV_ZOOM_setHandlers() {
function XMGRWGFSFV_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?XMGRWGFSFV_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('XMGRWGFSFV_ZOOM',XMGRWGFSFV_ZOOM_wrap_OnClick);
function XMGRWGFSFV_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('XMGRWGFSFV_ZOOM',XMGRWGFSFV_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('XMGRWGFSFV',XMGRWGFSFV_ZOOM_setHandlers);
function MBGANUUHRA_wrap_Valid(event) {
return MBGANUUHRA_Valid(event);
}
SPBOUILib.SetComboChange('MBGANUUHRA',MBGANUUHRA_wrap_Valid);
function MBGANUUHRA_wrap_OnFocus(event) {
return MBGANUUHRA_OnFocus(event);
}
SPBOUILib.SetInputEnter('MBGANUUHRA',MBGANUUHRA_wrap_OnFocus);
function MBGANUUHRA_wrap_Blur(event) {
return MBGANUUHRA_OnBlur(event);
}
SPBOUILib.SetInputExit('MBGANUUHRA',MBGANUUHRA_wrap_Blur);
function HVEEMUJUUY_wrap_Valid(event) {
return HVEEMUJUUY_Valid(event);
}
SPBOUILib.SetInputExit('HVEEMUJUUY',HVEEMUJUUY_wrap_Valid);
function HVEEMUJUUY_wrap_OnFocus(event) {
return HVEEMUJUUY_OnFocus(event);
}
SPBOUILib.SetInputEnter('HVEEMUJUUY',HVEEMUJUUY_wrap_OnFocus);
function HVEEMUJUUY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HVEEMUJUUY',HVEEMUJUUY_wrap_OnKeyDown);
function XHWYGOPPUN_wrap_Valid(event) {
return XHWYGOPPUN_Valid(event);
}
SPBOUILib.SetInputExit('XHWYGOPPUN',XHWYGOPPUN_wrap_Valid);
function XHWYGOPPUN_wrap_OnFocus(event) {
return XHWYGOPPUN_OnFocus(event);
}
SPBOUILib.SetInputEnter('XHWYGOPPUN',XHWYGOPPUN_wrap_OnFocus);
function XHWYGOPPUN_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('XHWYGOPPUN',XHWYGOPPUN_wrap_OnKeyPress);
function XHWYGOPPUN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('XHWYGOPPUN',XHWYGOPPUN_wrap_OnKeyDown);
function XHWYGOPPUN_ZOOM_setHandlers() {
function XHWYGOPPUN_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?XHWYGOPPUN_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('XHWYGOPPUN_ZOOM',XHWYGOPPUN_ZOOM_wrap_OnClick);
function XHWYGOPPUN_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('XHWYGOPPUN_ZOOM',XHWYGOPPUN_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('XHWYGOPPUN',XHWYGOPPUN_ZOOM_setHandlers);
function BNWXBPSIDG_wrap_Valid(event) {
return BNWXBPSIDG_Valid(event);
}
SPBOUILib.SetInputExit('BNWXBPSIDG',BNWXBPSIDG_wrap_Valid);
function BNWXBPSIDG_wrap_OnFocus(event) {
return BNWXBPSIDG_OnFocus(event);
}
SPBOUILib.SetInputEnter('BNWXBPSIDG',BNWXBPSIDG_wrap_OnFocus);
function BNWXBPSIDG_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('BNWXBPSIDG',BNWXBPSIDG_wrap_OnKeyPress);
function BNWXBPSIDG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('BNWXBPSIDG',BNWXBPSIDG_wrap_OnKeyDown);
function BNWXBPSIDG_ZOOM_setHandlers() {
function BNWXBPSIDG_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?BNWXBPSIDG_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('BNWXBPSIDG_ZOOM',BNWXBPSIDG_ZOOM_wrap_OnClick);
function BNWXBPSIDG_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('BNWXBPSIDG_ZOOM',BNWXBPSIDG_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('BNWXBPSIDG',BNWXBPSIDG_ZOOM_setHandlers);
function HRNCPADUFU_wrap_Valid(event) {
return HRNCPADUFU_Valid(event);
}
SPBOUILib.SetInputExit('HRNCPADUFU',HRNCPADUFU_wrap_Valid);
function HRNCPADUFU_wrap_OnFocus(event) {
return HRNCPADUFU_OnFocus(event);
}
SPBOUILib.SetInputEnter('HRNCPADUFU',HRNCPADUFU_wrap_OnFocus);
function HRNCPADUFU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HRNCPADUFU',HRNCPADUFU_wrap_OnKeyDown);
function OJJHIUDPFY_wrap_Valid(event) {
return OJJHIUDPFY_Valid(event);
}
SPBOUILib.SetInputExit('OJJHIUDPFY',OJJHIUDPFY_wrap_Valid);
function OJJHIUDPFY_wrap_OnFocus(event) {
return OJJHIUDPFY_OnFocus(event);
}
SPBOUILib.SetInputEnter('OJJHIUDPFY',OJJHIUDPFY_wrap_OnFocus);
function OJJHIUDPFY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OJJHIUDPFY',OJJHIUDPFY_wrap_OnKeyDown);
function FHXWUTBNKI_wrap_Valid(event) {
return FHXWUTBNKI_Valid(event);
}
SPBOUILib.SetInputExit('FHXWUTBNKI',FHXWUTBNKI_wrap_Valid);
function FHXWUTBNKI_wrap_OnFocus(event) {
return FHXWUTBNKI_OnFocus(event);
}
SPBOUILib.SetInputEnter('FHXWUTBNKI',FHXWUTBNKI_wrap_OnFocus);
function FHXWUTBNKI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FHXWUTBNKI',FHXWUTBNKI_wrap_OnKeyDown);
function JLTVZXPMKM_wrap_Valid(event) {
return JLTVZXPMKM_Valid(event);
}
SPBOUILib.SetInputExit('JLTVZXPMKM',JLTVZXPMKM_wrap_Valid);
function JLTVZXPMKM_wrap_OnFocus(event) {
return JLTVZXPMKM_OnFocus(event);
}
SPBOUILib.SetInputEnter('JLTVZXPMKM',JLTVZXPMKM_wrap_OnFocus);
function JLTVZXPMKM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JLTVZXPMKM',JLTVZXPMKM_wrap_OnKeyDown);
function LLYIGAMXRH_wrap_Valid(event) {
return LLYIGAMXRH_Valid(event);
}
SPBOUILib.SetComboChange('LLYIGAMXRH',LLYIGAMXRH_wrap_Valid);
function LLYIGAMXRH_wrap_OnFocus(event) {
return LLYIGAMXRH_OnFocus(event);
}
SPBOUILib.SetInputEnter('LLYIGAMXRH',LLYIGAMXRH_wrap_OnFocus);
function LLYIGAMXRH_wrap_Blur(event) {
return LLYIGAMXRH_OnBlur(event);
}
SPBOUILib.SetInputExit('LLYIGAMXRH',LLYIGAMXRH_wrap_Blur);
function SAQTIHOALW_wrap_Valid(event) {
return SAQTIHOALW_Valid(event);
}
SPBOUILib.SetInputExit('SAQTIHOALW',SAQTIHOALW_wrap_Valid);
function SAQTIHOALW_wrap_OnFocus(event) {
return SAQTIHOALW_OnFocus(event);
}
SPBOUILib.SetInputEnter('SAQTIHOALW',SAQTIHOALW_wrap_OnFocus);
function SAQTIHOALW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SAQTIHOALW',SAQTIHOALW_wrap_OnKeyDown);
function SAQTIHOALW_ZOOM_setHandlers() {
function SAQTIHOALW_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?SAQTIHOALW_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('SAQTIHOALW_ZOOM',SAQTIHOALW_ZOOM_wrap_OnClick);
function SAQTIHOALW_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('SAQTIHOALW_ZOOM',SAQTIHOALW_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('SAQTIHOALW',SAQTIHOALW_ZOOM_setHandlers);
function ZGNLLSFQHC_wrap_Valid(event) {
return ZGNLLSFQHC_Valid(event);
}
SPBOUILib.SetComboChange('ZGNLLSFQHC',ZGNLLSFQHC_wrap_Valid);
function ZGNLLSFQHC_wrap_OnFocus(event) {
return ZGNLLSFQHC_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZGNLLSFQHC',ZGNLLSFQHC_wrap_OnFocus);
function ZGNLLSFQHC_wrap_Blur(event) {
return ZGNLLSFQHC_OnBlur(event);
}
SPBOUILib.SetInputExit('ZGNLLSFQHC',ZGNLLSFQHC_wrap_Blur);
function YTPWDRMFUS_wrap_Valid(event) {
return YTPWDRMFUS_Valid(event);
}
SPBOUILib.SetInputExit('YTPWDRMFUS',YTPWDRMFUS_wrap_Valid);
function YTPWDRMFUS_wrap_OnFocus(event) {
return YTPWDRMFUS_OnFocus(event);
}
SPBOUILib.SetInputEnter('YTPWDRMFUS',YTPWDRMFUS_wrap_OnFocus);
function YTPWDRMFUS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YTPWDRMFUS',YTPWDRMFUS_wrap_OnKeyDown);
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
function RARXYHBSLM_wrap_Valid(event) {
return RARXYHBSLM_Valid(event);
}
SPBOUILib.SetCheckboxClick('RARXYHBSLM',RARXYHBSLM_wrap_Valid);
function RARXYHBSLM_wrap_OnFocus(event) {
return RARXYHBSLM_OnFocus(event);
}
SPBOUILib.SetInputEnter('RARXYHBSLM',RARXYHBSLM_wrap_OnFocus);
function RARXYHBSLM_wrap_Blur(event) {
return RARXYHBSLM_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('RARXYHBSLM',RARXYHBSLM_wrap_Blur);
function DFNZBCOVFH_wrap_Valid(event) {
return DFNZBCOVFH_Valid(event);
}
SPBOUILib.SetCheckboxClick('DFNZBCOVFH',DFNZBCOVFH_wrap_Valid);
function DFNZBCOVFH_wrap_OnFocus(event) {
return DFNZBCOVFH_OnFocus(event);
}
SPBOUILib.SetInputEnter('DFNZBCOVFH',DFNZBCOVFH_wrap_OnFocus);
function DFNZBCOVFH_wrap_Blur(event) {
return DFNZBCOVFH_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('DFNZBCOVFH',DFNZBCOVFH_wrap_Blur);
function FROMUIZATY_wrap_Valid(event) {
return FROMUIZATY_Valid(event);
}
SPBOUILib.SetInputExit('FROMUIZATY',FROMUIZATY_wrap_Valid);
function FROMUIZATY_wrap_OnFocus(event) {
return FROMUIZATY_OnFocus(event);
}
SPBOUILib.SetInputEnter('FROMUIZATY',FROMUIZATY_wrap_OnFocus);
function FROMUIZATY_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('FROMUIZATY',FROMUIZATY_wrap_OnKeyPress);
function FROMUIZATY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('FROMUIZATY',FROMUIZATY_wrap_OnKeyDown);
function YZOYIYAUUO_wrap_Valid(event) {
return YZOYIYAUUO_Valid(event);
}
SPBOUILib.SetInputExit('YZOYIYAUUO',YZOYIYAUUO_wrap_Valid);
function YZOYIYAUUO_wrap_OnFocus(event) {
return YZOYIYAUUO_OnFocus(event);
}
SPBOUILib.SetInputEnter('YZOYIYAUUO',YZOYIYAUUO_wrap_OnFocus);
function YZOYIYAUUO_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('YZOYIYAUUO',YZOYIYAUUO_wrap_OnKeyPress);
function YZOYIYAUUO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('YZOYIYAUUO',YZOYIYAUUO_wrap_OnKeyDown);
function YZOYIYAUUO_ZOOM_setHandlers() {
function YZOYIYAUUO_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?YZOYIYAUUO_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('YZOYIYAUUO_ZOOM',YZOYIYAUUO_ZOOM_wrap_OnClick);
function YZOYIYAUUO_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('YZOYIYAUUO_ZOOM',YZOYIYAUUO_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('YZOYIYAUUO',YZOYIYAUUO_ZOOM_setHandlers);
function REJDXHTDMV_wrap_Valid(event) {
return REJDXHTDMV_Valid(event);
}
SPBOUILib.SetInputExit('REJDXHTDMV',REJDXHTDMV_wrap_Valid);
function REJDXHTDMV_wrap_OnFocus(event) {
return REJDXHTDMV_OnFocus(event);
}
SPBOUILib.SetInputEnter('REJDXHTDMV',REJDXHTDMV_wrap_OnFocus);
function REJDXHTDMV_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('REJDXHTDMV',REJDXHTDMV_wrap_OnKeyPress);
function REJDXHTDMV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('REJDXHTDMV',REJDXHTDMV_wrap_OnKeyDown);
function REJDXHTDMV_ZOOM_setHandlers() {
function REJDXHTDMV_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?REJDXHTDMV_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('REJDXHTDMV_ZOOM',REJDXHTDMV_ZOOM_wrap_OnClick);
function REJDXHTDMV_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('REJDXHTDMV_ZOOM',REJDXHTDMV_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('REJDXHTDMV',REJDXHTDMV_ZOOM_setHandlers);
function ODWJZUZDBK_wrap_Valid(event) {
return ODWJZUZDBK_Valid(event);
}
SPBOUILib.SetInputExit('ODWJZUZDBK',ODWJZUZDBK_wrap_Valid);
function ODWJZUZDBK_wrap_OnFocus(event) {
return ODWJZUZDBK_OnFocus(event);
}
SPBOUILib.SetInputEnter('ODWJZUZDBK',ODWJZUZDBK_wrap_OnFocus);
function ODWJZUZDBK_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('ODWJZUZDBK',ODWJZUZDBK_wrap_OnKeyPress);
function ODWJZUZDBK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('ODWJZUZDBK',ODWJZUZDBK_wrap_OnKeyDown);
function ODWJZUZDBK_ZOOM_setHandlers() {
function ODWJZUZDBK_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ODWJZUZDBK_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('ODWJZUZDBK_ZOOM',ODWJZUZDBK_ZOOM_wrap_OnClick);
function ODWJZUZDBK_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('ODWJZUZDBK_ZOOM',ODWJZUZDBK_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('ODWJZUZDBK',ODWJZUZDBK_ZOOM_setHandlers);
function JJETXTUKNC_wrap_Valid(event) {
return JJETXTUKNC_Valid(event);
}
SPBOUILib.SetComboChange('JJETXTUKNC',JJETXTUKNC_wrap_Valid);
function JJETXTUKNC_wrap_OnFocus(event) {
return JJETXTUKNC_OnFocus(event);
}
SPBOUILib.SetInputEnter('JJETXTUKNC',JJETXTUKNC_wrap_OnFocus);
function JJETXTUKNC_wrap_Blur(event) {
return JJETXTUKNC_OnBlur(event);
}
SPBOUILib.SetInputExit('JJETXTUKNC',JJETXTUKNC_wrap_Blur);
function JFJPGOWVYJ_wrap_Valid(event) {
return JFJPGOWVYJ_Valid(event);
}
SPBOUILib.SetComboChange('JFJPGOWVYJ',JFJPGOWVYJ_wrap_Valid);
function JFJPGOWVYJ_wrap_OnFocus(event) {
return JFJPGOWVYJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('JFJPGOWVYJ',JFJPGOWVYJ_wrap_OnFocus);
function JFJPGOWVYJ_wrap_Blur(event) {
return JFJPGOWVYJ_OnBlur(event);
}
SPBOUILib.SetInputExit('JFJPGOWVYJ',JFJPGOWVYJ_wrap_Blur);
function HKQDVAPIOQ_wrap_Valid(event) {
return HKQDVAPIOQ_Valid(event);
}
SPBOUILib.SetInputExit('HKQDVAPIOQ',HKQDVAPIOQ_wrap_Valid);
function HKQDVAPIOQ_wrap_OnFocus(event) {
return HKQDVAPIOQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('HKQDVAPIOQ',HKQDVAPIOQ_wrap_OnFocus);
function HKQDVAPIOQ_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('HKQDVAPIOQ',HKQDVAPIOQ_wrap_OnKeyPress);
function HKQDVAPIOQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HKQDVAPIOQ',HKQDVAPIOQ_wrap_OnKeyDown);
function EMSGWJAYYK_wrap_Valid(event) {
return EMSGWJAYYK_Valid(event);
}
SPBOUILib.SetComboChange('EMSGWJAYYK',EMSGWJAYYK_wrap_Valid);
function EMSGWJAYYK_wrap_OnFocus(event) {
return EMSGWJAYYK_OnFocus(event);
}
SPBOUILib.SetInputEnter('EMSGWJAYYK',EMSGWJAYYK_wrap_OnFocus);
function EMSGWJAYYK_wrap_Blur(event) {
return EMSGWJAYYK_OnBlur(event);
}
SPBOUILib.SetInputExit('EMSGWJAYYK',EMSGWJAYYK_wrap_Blur);
function XOROAVXTCD_wrap_Valid(event) {
return XOROAVXTCD_Valid(event);
}
SPBOUILib.SetInputExit('XOROAVXTCD',XOROAVXTCD_wrap_Valid);
function XOROAVXTCD_wrap_OnFocus(event) {
return XOROAVXTCD_OnFocus(event);
}
SPBOUILib.SetInputEnter('XOROAVXTCD',XOROAVXTCD_wrap_OnFocus);
function XOROAVXTCD_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('XOROAVXTCD',XOROAVXTCD_wrap_OnKeyPress);
function XOROAVXTCD_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XOROAVXTCD',XOROAVXTCD_wrap_OnKeyDown);
function XERWNYQDBZ_wrap_Valid(event) {
return XERWNYQDBZ_Valid(event);
}
SPBOUILib.SetCheckboxClick('XERWNYQDBZ',XERWNYQDBZ_wrap_Valid);
function XERWNYQDBZ_wrap_OnFocus(event) {
return XERWNYQDBZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('XERWNYQDBZ',XERWNYQDBZ_wrap_OnFocus);
function XERWNYQDBZ_wrap_Blur(event) {
return XERWNYQDBZ_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('XERWNYQDBZ',XERWNYQDBZ_wrap_Blur);
function EVYVDDYVDZ_wrap_Valid(event) {
return EVYVDDYVDZ_Valid(event);
}
SPBOUILib.SetInputExit('EVYVDDYVDZ',EVYVDDYVDZ_wrap_Valid);
function EVYVDDYVDZ_wrap_OnFocus(event) {
return EVYVDDYVDZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('EVYVDDYVDZ',EVYVDDYVDZ_wrap_OnFocus);
function EVYVDDYVDZ_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('EVYVDDYVDZ',EVYVDDYVDZ_wrap_OnKeyPress);
function EVYVDDYVDZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('EVYVDDYVDZ',EVYVDDYVDZ_wrap_OnKeyDown);
function EVYVDDYVDZ_ZOOM_setHandlers() {
function EVYVDDYVDZ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?EVYVDDYVDZ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('EVYVDDYVDZ_ZOOM',EVYVDDYVDZ_ZOOM_wrap_OnClick);
function EVYVDDYVDZ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('EVYVDDYVDZ_ZOOM',EVYVDDYVDZ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('EVYVDDYVDZ',EVYVDDYVDZ_ZOOM_setHandlers);
function BOHBZOSBVJ_wrap_Valid(event) {
return BOHBZOSBVJ_Valid(event);
}
SPBOUILib.SetInputExit('BOHBZOSBVJ',BOHBZOSBVJ_wrap_Valid);
function BOHBZOSBVJ_wrap_OnFocus(event) {
return BOHBZOSBVJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('BOHBZOSBVJ',BOHBZOSBVJ_wrap_OnFocus);
function BOHBZOSBVJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BOHBZOSBVJ',BOHBZOSBVJ_wrap_OnKeyDown);
function UMKFMWBVUO_wrap_Valid(event) {
return UMKFMWBVUO_Valid(event);
}
SPBOUILib.SetInputExit('UMKFMWBVUO',UMKFMWBVUO_wrap_Valid);
function UMKFMWBVUO_wrap_OnFocus(event) {
return UMKFMWBVUO_OnFocus(event);
}
SPBOUILib.SetInputEnter('UMKFMWBVUO',UMKFMWBVUO_wrap_OnFocus);
function CKHRNQSKKQ_wrap_Valid(event) {
return CKHRNQSKKQ_Valid(event);
}
SPBOUILib.SetInputExit('CKHRNQSKKQ',CKHRNQSKKQ_wrap_Valid);
function CKHRNQSKKQ_wrap_OnFocus(event) {
return CKHRNQSKKQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('CKHRNQSKKQ',CKHRNQSKKQ_wrap_OnFocus);
function CKHRNQSKKQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CKHRNQSKKQ',CKHRNQSKKQ_wrap_OnKeyDown);
function CKHRNQSKKQ_ZOOM_setHandlers() {
function CKHRNQSKKQ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?CKHRNQSKKQ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('CKHRNQSKKQ_ZOOM',CKHRNQSKKQ_ZOOM_wrap_OnClick);
function CKHRNQSKKQ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('CKHRNQSKKQ_ZOOM',CKHRNQSKKQ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('CKHRNQSKKQ',CKHRNQSKKQ_ZOOM_setHandlers);
function DQZNJUSTLN_wrap_Valid(event) {
return DQZNJUSTLN_Valid(event);
}
SPBOUILib.SetInputExit('DQZNJUSTLN',DQZNJUSTLN_wrap_Valid);
function DQZNJUSTLN_wrap_OnFocus(event) {
return DQZNJUSTLN_OnFocus(event);
}
SPBOUILib.SetInputEnter('DQZNJUSTLN',DQZNJUSTLN_wrap_OnFocus);
function DQZNJUSTLN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DQZNJUSTLN',DQZNJUSTLN_wrap_OnKeyDown);
function DQZNJUSTLN_ZOOM_setHandlers() {
function DQZNJUSTLN_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?DQZNJUSTLN_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('DQZNJUSTLN_ZOOM',DQZNJUSTLN_ZOOM_wrap_OnClick);
function DQZNJUSTLN_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('DQZNJUSTLN_ZOOM',DQZNJUSTLN_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('DQZNJUSTLN',DQZNJUSTLN_ZOOM_setHandlers);
function ESODTMPIYO_wrap_Valid(event) {
return ESODTMPIYO_Valid(event);
}
SPBOUILib.SetInputExit('ESODTMPIYO',ESODTMPIYO_wrap_Valid);
function ESODTMPIYO_wrap_OnFocus(event) {
return ESODTMPIYO_OnFocus(event);
}
SPBOUILib.SetInputEnter('ESODTMPIYO',ESODTMPIYO_wrap_OnFocus);
function ESODTMPIYO_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('ESODTMPIYO',ESODTMPIYO_wrap_OnKeyPress);
function ESODTMPIYO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('ESODTMPIYO',ESODTMPIYO_wrap_OnKeyDown);
function ESODTMPIYO_ZOOM_setHandlers() {
function ESODTMPIYO_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ESODTMPIYO_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('ESODTMPIYO_ZOOM',ESODTMPIYO_ZOOM_wrap_OnClick);
function ESODTMPIYO_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('ESODTMPIYO_ZOOM',ESODTMPIYO_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('ESODTMPIYO',ESODTMPIYO_ZOOM_setHandlers);
function UNPDFRUOXO_wrap_Valid(event) {
return UNPDFRUOXO_Valid(event);
}
SPBOUILib.SetInputExit('UNPDFRUOXO',UNPDFRUOXO_wrap_Valid);
function UNPDFRUOXO_wrap_OnFocus(event) {
return UNPDFRUOXO_OnFocus(event);
}
SPBOUILib.SetInputEnter('UNPDFRUOXO',UNPDFRUOXO_wrap_OnFocus);
function UNPDFRUOXO_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('UNPDFRUOXO',UNPDFRUOXO_wrap_OnKeyPress);
function UNPDFRUOXO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('UNPDFRUOXO',UNPDFRUOXO_wrap_OnKeyDown);
function UNPDFRUOXO_ZOOM_setHandlers() {
function UNPDFRUOXO_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?UNPDFRUOXO_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('UNPDFRUOXO_ZOOM',UNPDFRUOXO_ZOOM_wrap_OnClick);
function UNPDFRUOXO_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('UNPDFRUOXO_ZOOM',UNPDFRUOXO_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('UNPDFRUOXO',UNPDFRUOXO_ZOOM_setHandlers);
function RKHMYOIJDM_wrap_Valid(event) {
return RKHMYOIJDM_Valid(event);
}
SPBOUILib.SetInputExit('RKHMYOIJDM',RKHMYOIJDM_wrap_Valid);
function RKHMYOIJDM_wrap_OnFocus(event) {
return RKHMYOIJDM_OnFocus(event);
}
SPBOUILib.SetInputEnter('RKHMYOIJDM',RKHMYOIJDM_wrap_OnFocus);
function RKHMYOIJDM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RKHMYOIJDM',RKHMYOIJDM_wrap_OnKeyDown);
function RKHMYOIJDM_ZOOM_setHandlers() {
function RKHMYOIJDM_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?RKHMYOIJDM_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('RKHMYOIJDM_ZOOM',RKHMYOIJDM_ZOOM_wrap_OnClick);
function RKHMYOIJDM_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('RKHMYOIJDM_ZOOM',RKHMYOIJDM_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('RKHMYOIJDM',RKHMYOIJDM_ZOOM_setHandlers);
function HBSPPQBOJN_wrap_Valid(event) {
return HBSPPQBOJN_Valid(event);
}
SPBOUILib.SetInputExit('HBSPPQBOJN',HBSPPQBOJN_wrap_Valid);
function HBSPPQBOJN_wrap_OnFocus(event) {
return HBSPPQBOJN_OnFocus(event);
}
SPBOUILib.SetInputEnter('HBSPPQBOJN',HBSPPQBOJN_wrap_OnFocus);
function HBSPPQBOJN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HBSPPQBOJN',HBSPPQBOJN_wrap_OnKeyDown);
function EOYNWRHHMY_wrap_Valid(event) {
return EOYNWRHHMY_Valid(event);
}
SPBOUILib.SetCheckboxClick('EOYNWRHHMY',EOYNWRHHMY_wrap_Valid);
function EOYNWRHHMY_wrap_OnFocus(event) {
return EOYNWRHHMY_OnFocus(event);
}
SPBOUILib.SetInputEnter('EOYNWRHHMY',EOYNWRHHMY_wrap_OnFocus);
function EOYNWRHHMY_wrap_Blur(event) {
return EOYNWRHHMY_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('EOYNWRHHMY',EOYNWRHHMY_wrap_Blur);
function CYHJRUWRUL_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('CYHJRUWRUL',CYHJRUWRUL_wrap_OnKeyDown);
function CJBEXKJOQO_wrap_Valid(event) {
return CJBEXKJOQO_Valid(event);
}
SPBOUILib.SetInputExit('CJBEXKJOQO',CJBEXKJOQO_wrap_Valid);
function CJBEXKJOQO_wrap_OnFocus(event) {
return CJBEXKJOQO_OnFocus(event);
}
SPBOUILib.SetInputEnter('CJBEXKJOQO',CJBEXKJOQO_wrap_OnFocus);
function CJBEXKJOQO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CJBEXKJOQO',CJBEXKJOQO_wrap_OnKeyDown);
function CJBEXKJOQO_ZOOM_setHandlers() {
function CJBEXKJOQO_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?CJBEXKJOQO_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('CJBEXKJOQO_ZOOM',CJBEXKJOQO_ZOOM_wrap_OnClick);
function CJBEXKJOQO_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('CJBEXKJOQO_ZOOM',CJBEXKJOQO_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('CJBEXKJOQO',CJBEXKJOQO_ZOOM_setHandlers);
function UNRQNVVFTK_wrap_Valid(event) {
return UNRQNVVFTK_Valid(event);
}
SPBOUILib.SetInputExit('UNRQNVVFTK',UNRQNVVFTK_wrap_Valid);
function UNRQNVVFTK_wrap_OnFocus(event) {
return UNRQNVVFTK_OnFocus(event);
}
SPBOUILib.SetInputEnter('UNRQNVVFTK',UNRQNVVFTK_wrap_OnFocus);
function UNRQNVVFTK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UNRQNVVFTK',UNRQNVVFTK_wrap_OnKeyDown);
function UNRQNVVFTK_ZOOM_setHandlers() {
function UNRQNVVFTK_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?UNRQNVVFTK_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('UNRQNVVFTK_ZOOM',UNRQNVVFTK_ZOOM_wrap_OnClick);
function UNRQNVVFTK_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('UNRQNVVFTK_ZOOM',UNRQNVVFTK_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('UNRQNVVFTK',UNRQNVVFTK_ZOOM_setHandlers);
function OSLBLDODHQ_wrap_Valid(event) {
return OSLBLDODHQ_Valid(event);
}
SPBOUILib.SetInputExit('OSLBLDODHQ',OSLBLDODHQ_wrap_Valid);
function OSLBLDODHQ_wrap_OnFocus(event) {
return OSLBLDODHQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('OSLBLDODHQ',OSLBLDODHQ_wrap_OnFocus);
function OSLBLDODHQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OSLBLDODHQ',OSLBLDODHQ_wrap_OnKeyDown);
function OSLBLDODHQ_ZOOM_setHandlers() {
function OSLBLDODHQ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?OSLBLDODHQ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('OSLBLDODHQ_ZOOM',OSLBLDODHQ_ZOOM_wrap_OnClick);
function OSLBLDODHQ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('OSLBLDODHQ_ZOOM',OSLBLDODHQ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('OSLBLDODHQ',OSLBLDODHQ_ZOOM_setHandlers);
function NXVXQSLAGM_wrap_Valid(event) {
return NXVXQSLAGM_Valid(event);
}
SPBOUILib.SetInputExit('NXVXQSLAGM',NXVXQSLAGM_wrap_Valid);
function NXVXQSLAGM_wrap_OnFocus(event) {
return NXVXQSLAGM_OnFocus(event);
}
SPBOUILib.SetInputEnter('NXVXQSLAGM',NXVXQSLAGM_wrap_OnFocus);
function NXVXQSLAGM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NXVXQSLAGM',NXVXQSLAGM_wrap_OnKeyDown);
function NXVXQSLAGM_ZOOM_setHandlers() {
function NXVXQSLAGM_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?NXVXQSLAGM_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('NXVXQSLAGM_ZOOM',NXVXQSLAGM_ZOOM_wrap_OnClick);
function NXVXQSLAGM_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('NXVXQSLAGM_ZOOM',NXVXQSLAGM_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('NXVXQSLAGM',NXVXQSLAGM_ZOOM_setHandlers);
function PGYFWWGOTN_wrap_Valid(event) {
return PGYFWWGOTN_Valid(event);
}
SPBOUILib.SetInputExit('PGYFWWGOTN',PGYFWWGOTN_wrap_Valid);
function PGYFWWGOTN_wrap_OnFocus(event) {
return PGYFWWGOTN_OnFocus(event);
}
SPBOUILib.SetInputEnter('PGYFWWGOTN',PGYFWWGOTN_wrap_OnFocus);
function PGYFWWGOTN_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('PGYFWWGOTN',PGYFWWGOTN_wrap_OnKeyPress);
function PGYFWWGOTN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PGYFWWGOTN',PGYFWWGOTN_wrap_OnKeyDown);
function VHXDWWHVXF_wrap_Valid(event) {
return VHXDWWHVXF_Valid(event);
}
SPBOUILib.SetInputExit('VHXDWWHVXF',VHXDWWHVXF_wrap_Valid);
function VHXDWWHVXF_wrap_OnFocus(event) {
return VHXDWWHVXF_OnFocus(event);
}
SPBOUILib.SetInputEnter('VHXDWWHVXF',VHXDWWHVXF_wrap_OnFocus);
function VHXDWWHVXF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VHXDWWHVXF',VHXDWWHVXF_wrap_OnKeyDown);
function VHXDWWHVXF_ZOOM_setHandlers() {
function VHXDWWHVXF_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?VHXDWWHVXF_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('VHXDWWHVXF_ZOOM',VHXDWWHVXF_ZOOM_wrap_OnClick);
function VHXDWWHVXF_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('VHXDWWHVXF_ZOOM',VHXDWWHVXF_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('VHXDWWHVXF',VHXDWWHVXF_ZOOM_setHandlers);
function AAQYBAEHUR_wrap_Valid(event) {
return AAQYBAEHUR_Valid(event);
}
SPBOUILib.SetInputExit('AAQYBAEHUR',AAQYBAEHUR_wrap_Valid);
function AAQYBAEHUR_wrap_OnFocus(event) {
return AAQYBAEHUR_OnFocus(event);
}
SPBOUILib.SetInputEnter('AAQYBAEHUR',AAQYBAEHUR_wrap_OnFocus);
function AAQYBAEHUR_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('AAQYBAEHUR',AAQYBAEHUR_wrap_OnKeyPress);
function AAQYBAEHUR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AAQYBAEHUR',AAQYBAEHUR_wrap_OnKeyDown);
function UQYOQYIUNM_wrap_Valid(event) {
return UQYOQYIUNM_Valid(event);
}
SPBOUILib.SetInputExit('UQYOQYIUNM',UQYOQYIUNM_wrap_Valid);
function UQYOQYIUNM_wrap_OnFocus(event) {
return UQYOQYIUNM_OnFocus(event);
}
SPBOUILib.SetInputEnter('UQYOQYIUNM',UQYOQYIUNM_wrap_OnFocus);
function UQYOQYIUNM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UQYOQYIUNM',UQYOQYIUNM_wrap_OnKeyDown);
function UQYOQYIUNM_ZOOM_setHandlers() {
function UQYOQYIUNM_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?UQYOQYIUNM_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('UQYOQYIUNM_ZOOM',UQYOQYIUNM_ZOOM_wrap_OnClick);
function UQYOQYIUNM_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('UQYOQYIUNM_ZOOM',UQYOQYIUNM_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('UQYOQYIUNM',UQYOQYIUNM_ZOOM_setHandlers);
function BOECHNDAXS_wrap_Valid(event) {
return BOECHNDAXS_Valid(event);
}
SPBOUILib.SetInputExit('BOECHNDAXS',BOECHNDAXS_wrap_Valid);
function BOECHNDAXS_wrap_OnFocus(event) {
return BOECHNDAXS_OnFocus(event);
}
SPBOUILib.SetInputEnter('BOECHNDAXS',BOECHNDAXS_wrap_OnFocus);
function BOECHNDAXS_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('BOECHNDAXS',BOECHNDAXS_wrap_OnKeyPress);
function BOECHNDAXS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BOECHNDAXS',BOECHNDAXS_wrap_OnKeyDown);
function HLXRSSMBIW_wrap_Valid(event) {
return HLXRSSMBIW_Valid(event);
}
SPBOUILib.SetInputExit('HLXRSSMBIW',HLXRSSMBIW_wrap_Valid);
function HLXRSSMBIW_wrap_OnFocus(event) {
return HLXRSSMBIW_OnFocus(event);
}
SPBOUILib.SetInputEnter('HLXRSSMBIW',HLXRSSMBIW_wrap_OnFocus);
function HLXRSSMBIW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HLXRSSMBIW',HLXRSSMBIW_wrap_OnKeyDown);
function HLXRSSMBIW_ZOOM_setHandlers() {
function HLXRSSMBIW_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?HLXRSSMBIW_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('HLXRSSMBIW_ZOOM',HLXRSSMBIW_ZOOM_wrap_OnClick);
function HLXRSSMBIW_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('HLXRSSMBIW_ZOOM',HLXRSSMBIW_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('HLXRSSMBIW',HLXRSSMBIW_ZOOM_setHandlers);
function ISJKSRTDAC_wrap_Valid(event) {
return ISJKSRTDAC_Valid(event);
}
SPBOUILib.SetInputExit('ISJKSRTDAC',ISJKSRTDAC_wrap_Valid);
function ISJKSRTDAC_wrap_OnFocus(event) {
return ISJKSRTDAC_OnFocus(event);
}
SPBOUILib.SetInputEnter('ISJKSRTDAC',ISJKSRTDAC_wrap_OnFocus);
function ISJKSRTDAC_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('ISJKSRTDAC',ISJKSRTDAC_wrap_OnKeyPress);
function ISJKSRTDAC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ISJKSRTDAC',ISJKSRTDAC_wrap_OnKeyDown);
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
function MXITFMGTNB_wrap_Valid(event) {
return MXITFMGTNB_Valid(event);
}
SPBOUILib.SetInputExit('MXITFMGTNB',MXITFMGTNB_wrap_Valid);
function MXITFMGTNB_wrap_OnFocus(event) {
return MXITFMGTNB_OnFocus(event);
}
SPBOUILib.SetInputEnter('MXITFMGTNB',MXITFMGTNB_wrap_OnFocus);
function MXITFMGTNB_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('MXITFMGTNB',MXITFMGTNB_wrap_OnKeyPress);
function MXITFMGTNB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('MXITFMGTNB',MXITFMGTNB_wrap_OnKeyDown);
function MXITFMGTNB_ZOOM_setHandlers() {
function MXITFMGTNB_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?MXITFMGTNB_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('MXITFMGTNB_ZOOM',MXITFMGTNB_ZOOM_wrap_OnClick);
function MXITFMGTNB_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('MXITFMGTNB_ZOOM',MXITFMGTNB_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('MXITFMGTNB',MXITFMGTNB_ZOOM_setHandlers);
function XFKXBQYUIU_wrap_Valid(event) {
return XFKXBQYUIU_Valid(event);
}
SPBOUILib.SetCheckboxClick('XFKXBQYUIU',XFKXBQYUIU_wrap_Valid);
function XFKXBQYUIU_wrap_OnFocus(event) {
return XFKXBQYUIU_OnFocus(event);
}
SPBOUILib.SetInputEnter('XFKXBQYUIU',XFKXBQYUIU_wrap_OnFocus);
function XFKXBQYUIU_wrap_Blur(event) {
return XFKXBQYUIU_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('XFKXBQYUIU',XFKXBQYUIU_wrap_Blur);
function RHCYCLTWOT_wrap_Valid(event) {
return RHCYCLTWOT_Valid(event);
}
SPBOUILib.SetCheckboxClick('RHCYCLTWOT',RHCYCLTWOT_wrap_Valid);
function RHCYCLTWOT_wrap_OnFocus(event) {
return RHCYCLTWOT_OnFocus(event);
}
SPBOUILib.SetInputEnter('RHCYCLTWOT',RHCYCLTWOT_wrap_OnFocus);
function RHCYCLTWOT_wrap_Blur(event) {
return RHCYCLTWOT_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('RHCYCLTWOT',RHCYCLTWOT_wrap_Blur);
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
function OXWRJNTXVJ_wrap_Valid(event) {
return OXWRJNTXVJ_Valid(event);
}
SPBOUILib.SetComboChange('OXWRJNTXVJ',OXWRJNTXVJ_wrap_Valid);
function OXWRJNTXVJ_wrap_OnFocus(event) {
return OXWRJNTXVJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('OXWRJNTXVJ',OXWRJNTXVJ_wrap_OnFocus);
function OXWRJNTXVJ_wrap_Blur(event) {
return OXWRJNTXVJ_OnBlur(event);
}
SPBOUILib.SetInputExit('OXWRJNTXVJ',OXWRJNTXVJ_wrap_Blur);
function FTYWOEFIPD_wrap_Valid(event) {
return FTYWOEFIPD_Valid(event);
}
SPBOUILib.SetInputExit('FTYWOEFIPD',FTYWOEFIPD_wrap_Valid);
function FTYWOEFIPD_wrap_OnFocus(event) {
return FTYWOEFIPD_OnFocus(event);
}
SPBOUILib.SetInputEnter('FTYWOEFIPD',FTYWOEFIPD_wrap_OnFocus);
function YFBFKZZRWO_wrap_Valid(event) {
return YFBFKZZRWO_Valid(event);
}
SPBOUILib.SetInputExit('YFBFKZZRWO',YFBFKZZRWO_wrap_Valid);
function YFBFKZZRWO_wrap_OnFocus(event) {
return YFBFKZZRWO_OnFocus(event);
}
SPBOUILib.SetInputEnter('YFBFKZZRWO',YFBFKZZRWO_wrap_OnFocus);
function YFBFKZZRWO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YFBFKZZRWO',YFBFKZZRWO_wrap_OnKeyDown);
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
if (Eq(p_cEvent,'Record Loaded')) {
if (Ne(typeof(Calculation_AFKBPWDUSP),'undefined')) {
old_c=m_bCalculating;
m_bCalculating=true;
Calculation_AFKBPWDUSP();
m_bCalculating=old_c;
if ( ! (old_c)) {
DoUpdate(true);
}
}
}
if (Ne(typeof(w_Opextrbo),'undefined')) {
w_Opextrbo.raiseEvent('armt_personbo_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Rapporti_AUI),'undefined')) {
w_Rapporti_AUI.raiseEvent('armt_personbo_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Operazioni_AUI),'undefined')) {
w_Operazioni_AUI.raiseEvent('armt_personbo_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Frazionate_AUI),'undefined')) {
w_Frazionate_AUI.raiseEvent('armt_personbo_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Storico_VAR),'undefined')) {
w_Storico_VAR.raiseEvent('armt_personbo_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Storico_Ker),'undefined')) {
w_Storico_Ker.raiseEvent('armt_personbo_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Titolari_AUI),'undefined')) {
w_Titolari_AUI.raiseEvent('armt_personbo_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Titolari_PRV),'undefined')) {
w_Titolari_PRV.raiseEvent('armt_personbo_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Deleghe_AUI),'undefined')) {
w_Deleghe_AUI.raiseEvent('armt_personbo_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Deleghe_PRV),'undefined')) {
w_Deleghe_PRV.raiseEvent('armt_personbo_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Rilevazioni),'undefined')) {
w_Rilevazioni.raiseEvent('armt_personbo_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Rapporti_Prv),'undefined')) {
w_Rapporti_Prv.raiseEvent('armt_personbo_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Operazioni_Prv),'undefined')) {
w_Operazioni_Prv.raiseEvent('armt_personbo_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Frazionate_Prv),'undefined')) {
w_Frazionate_Prv.raiseEvent('armt_personbo_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.edit={"page_1":["UYWIEUHCAL"],"page_10":["NXVXQSLAGM"],"page_2":["UMKFMWBVUO"],"page_6":["CKHRNQSKKQ"],"page_8":["DQZNJUSTLN"],"page_9":["RKHMYOIJDM"]};
FocusFirstComponent.query={"page_1":["UYWIEUHCAL"],"page_10":["NXVXQSLAGM"],"page_2":["UMKFMWBVUO"],"page_6":["CKHRNQSKKQ"],"page_8":["DQZNJUSTLN"],"page_9":["RKHMYOIJDM"]};
FocusFirstComponent.otherwise={"page_1":["UYWIEUHCAL"],"page_10":["NXVXQSLAGM"],"page_2":["UMKFMWBVUO"],"page_6":["CKHRNQSKKQ"],"page_8":["DQZNJUSTLN"],"page_9":["RKHMYOIJDM"]};
function Help() {
windowOpenForeground('../doc/armt_personbo_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_ardt_personbo_dip() {
SetModified();
}
function SetModified_armt_personbo_agg() {
SetModified();
}
function SetModified_ardt_soggope() {
SetModified();
}
function SetModified_ardt_fatca_ind() {
SetModified();
}
function SetModified_ardt_patrimonio() {
SetModified();
}
function SetModified_ardt_reddito() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_8')) {
if (ChildToLoad('BKKASVQSWO')) {
LoadContext.lc(1,'BKKASVQSWO');
} else {
LibJavascript.RefreshChildGrid('BKKASVQSWO');
}
}
if (Eq(page,'page_8')) {
if (ChildToLoad('OIREAEXNKZ')) {
LoadContext.lc(1,'OIREAEXNKZ');
} else {
LibJavascript.RefreshChildGrid('OIREAEXNKZ');
}
}
if (Eq(page,'page_8')) {
if (ChildToLoad('RYYOFFRITV')) {
if (Eq(lazy,null) || LibJavascript.UserCanSee('RYYOFFRITV')) {
LoadContext.lc(1,'RYYOFFRITV');
}
} else {
LibJavascript.RefreshChildGrid('RYYOFFRITV');
}
}
if (Eq(page,'page_9')) {
if (ChildToLoad('FBAHOFZNEF')) {
LoadContext.lc(1,'FBAHOFZNEF');
} else {
LibJavascript.RefreshChildGrid('FBAHOFZNEF');
}
}
if (Eq(page,'page_10')) {
if (ChildToLoad('FFIYUAKUTX')) {
if (Eq(lazy,null) || LibJavascript.UserCanSee('FFIYUAKUTX')) {
LoadContext.lc(1,'FFIYUAKUTX');
}
} else {
LibJavascript.RefreshChildGrid('FFIYUAKUTX');
}
}
if (Eq(page,'page_10')) {
if (ChildToLoad('COWMRLCMMU')) {
if (Eq(lazy,null) || LibJavascript.UserCanSee('COWMRLCMMU')) {
LoadContext.lc(1,'COWMRLCMMU');
}
} else {
LibJavascript.RefreshChildGrid('COWMRLCMMU');
}
}
}
GetLayerID.Layers.push({"id":"AQSQVBKXAL","name":"DatiBase"});
GetLayerID.Layers.push({"id":"EWPTTWSBMT","name":"PF"});
GetLayerID.Layers.push({"id":"OQFTKYDCIW","name":"AD"});
GetLayerID.Layers.push({"id":"PUKLGLJKBW","name":"GestoriContante"});
GetLayerID.Layers.push({"id":"VECIWQFMOB","name":"Operazioni"});
GetLayerID.Layers.push({"id":"WXIRJORZUM","name":"Frazionate"});
GetLayerID.Layers.push({"id":"XDVUUVRZLV","name":"Rapporti"});
GetLayerID.Layers.push({"id":"YVPVOYKMZA","name":"Rapporti"});
GetLayerID.Layers.push({"id":"MTHMFUOOBG","name":"Operazioni"});
GetLayerID.Layers.push({"id":"WVUNPTQGCF","name":"Frazionate"});
GetLayerID.Layers.push({"id":"HPGCEWAWGV","name":"LegRap"});
GetLayerID.Layers.push({"id":"AYKUXGKLPO","name":"DatiAgg"});
GetLayerID.Layers.push({"id":"ZETZWJBOFM","name":"Dipendenza"});
GetLayerID.Layers.push({"id":"XDDGTPJDHN","name":"SogCollegati"});
GetLayerID.Layers.push({"id":"FIXFSIUKKN","name":"Fatc"});
GetLayerID.Layers.push({"id":"WEJOYIAYYL","name":"CittaDiv"});
GetLayerID.Layers.push({"id":"WJVOGIFRCK","name":"ValRisk"});
GetLayerID.Layers.push({"id":"XTDFJTMZAQ","name":"MitRisk"});
GetLayerID.Layers.push({"id":"TKKVDEVHBF","name":"Patrimonio"});
GetLayerID.Layers.push({"id":"STJESIOURE","name":"Reddito"});
GetLayerID.Layers.push({"id":"SSIHDIOVZQ","name":"RilAnom"});
function DeclareWVs() {
var a = arguments;
w_TIPOPERS=a[0];
w_COGNOME=a[1];
w_NOME=a[2];
w_CFESTERO=a[3];
w_RAGSOC=a[4];
w_PAESE=a[5];
w_DESCCIT=a[6];
w_idcitta=a[7];
w_PROVINCIA=a[8];
w_CAP=a[9];
w_CODCAB=a[10];
w_DOMICILIO=a[11];
w_IDENT=a[12];
w_IDNASCOMUN=a[13];
w_NASCOMUN=a[14];
w_TIPINTER=a[15];
w_IDNASSTATO=a[16];
w_NASSTATO=a[17];
w_SESSO=a[18];
w_DATANASC=a[19];
w_TIPODOC=a[20];
w_NUMDOCUM=a[21];
w_DATARILASC=a[22];
w_DATAVALI=a[23];
w_AUTRILASC=a[24];
w_CODFISC=a[25];
w_PARTIVA=a[26];
w_CONTO=a[27];
w_SOTGRUP=a[28];
w_RAMOGRUP=a[29];
w_ATTIV=a[30];
w_SETTSINT=a[31];
w_CONNES=a[32];
w_NOSARA=a[33];
w_NOTIT=a[34];
w_PROGIMPORT=a[35];
op_PROGIMPORT=a[36];
w_OLDSETSIN=a[37];
w_CRIMEDATE=a[38];
w_PEPDATE=a[39];
w_NOTE=a[40];
w_CODLEGRAP=a[41];
w_FATCA=a[42];
w_TIN=a[43];
w_ODB=a[44];
w_AREAGEO=a[45];
w_RAREA=a[46];
w_PKTBSPECIE=a[47];
w_RNATGIU=a[48];
w_RATTIV=a[49];
w_COMPORT=a[50];
w_RCOMP=a[51];
w_DOCFILE=a[52];
w_RISGLOB=a[53];
w_DATAPROF=a[54];
w_DATAREVPROF=a[55];
w_PEP=a[56];
w_CRIME=a[57];
w_MITIG=a[58];
w_MITIGDOC=a[59];
w_DATAFINE=a[60];
w_DATAINI=a[61];
w_DISATTIVO=a[62];
w_TIPOSOGGETTO=a[63];
w_RAPSEGNA=a[64];
w_SOGAFFIDATARIO=a[65];
w_CAUSALE=a[66];
w_FATTURATO=a[67];
w_FLGNOTRIM=a[68];
w_DATAIDENT=a[69];
w_CITTADIN1=a[70];
w_CITTADIN2=a[71];
w_RESFISC=a[72];
w_BANCABEN=a[73];
w_DATASEGN=a[74];
w_DATARAUT=a[75];
w_VERIFICA=a[76];
w_CODINTER=a[77];
w_NUMIMP=a[78];
w_CODDIPE=a[79];
w_SOSPMAF=a[80];
w_OLDCONNES=a[81];
w_DATEXTRA=a[82];
w_ALLINEATO=a[83];
w_ALLINEATONOMECNOME=a[84];
w_RAGSOCOLD=a[85];
w_PROGIMP_C=a[86];
w_IDFILE=a[87];
w_OLDCODFISC=a[88];
w_MACROAGENTE=a[89];
w_SPOTID=a[90];
w_DATAVARAGE=a[91];
w_SETTSINT2=a[92];
w_TELEF=a[93];
w_TIPOORO=a[94];
w_CODORO=a[95];
w_FLGVALIDO=a[96];
w_DAC6=a[97];
w_ALTRODOM=a[98];
w_ALTROCAP=a[99];
w_IMPORTOMAX=a[100];
w_FREQUENZA=a[101];
w_NUMOPERAZ=a[102];
w_DATASIGN=a[103];
w_IDBASE=a[104];
w_FLAGDAC6=a[105];
w_NOTERIS=a[106];
w_gIntemediario=a[107];
w_gFlgWU=a[108];
w_gSeekAos=a[109];
w_gDataVaria=a[110];
w_gFlgDoc=a[111];
w_gTipInter=a[112];
w_gVerSim=a[113];
w_gCodDip=a[114];
w_dataoggi=a[115];
w_nascomunid=a[116];
w_nasstatoid=a[117];
w_flgaggfam=a[118];
w_DATARETT=a[119];
w_STATOREG=a[120];
w_NUMPROG=a[121];
w_tipsot=a[122];
w_DESCSGRU=a[123];
w_DESCRAMGRU=a[124];
w_DESCUIC=a[125];
w_dessta=a[126];
w_DESCRI=a[127];
w_xstatonas=a[128];
w_finesae=a[129];
w_finesint=a[130];
w_xFLGVALIDO=a[131];
w_xFLGANAVAL=a[132];
w_ragbanben=a[133];
w_xdesfatca=a[134];
w_ATTIVR=a[135];
w_xDESDIPE=a[136];
w_xDSETSIN=a[137];
w_xdesctipatt=a[138];
w_xdescareag=a[139];
w_xdescnatgiu=a[140];
w_xdesccomp=a[141];
w_xITFLGPEP=a[142];
w_xDesCit1=a[143];
w_xDesCit2=a[144];
w_xResFis=a[145];
w_xRAGLEGRAP=a[146];
w_xIDLEGRAP=a[147];
w_FLGALTO=a[148];
w_COMPLETA=a[149];;
w_status=a[150];
op_codazi=a[151];
m_cWv_ardt_personbo_dip=a[152];
m_cWv_armt_personbo_agg=a[153];
m_cWv_ardt_soggope=a[154];
m_cWv_ardt_fatca_ind=a[155];
m_cWv_ardt_patrimonio=a[156];
m_cWv_ardt_reddito=a[157];
if (Gt(a.length,158)) {
m_cErrorInChild='';
}
if (Gt(a.length,158)) {
o_gIntemediario=w_gIntemediario;
o_COGNOME=w_COGNOME;
o_NOME=w_NOME;
o_PAESE=w_PAESE;
o_DESCCIT=w_DESCCIT;
o_idcitta=w_idcitta;
o_IDNASCOMUN=w_IDNASCOMUN;
o_IDNASSTATO=w_IDNASSTATO;
o_NASSTATO=w_NASSTATO;
o_DATANASC=w_DATANASC;
o_TIPODOC=w_TIPODOC;
o_NUMDOCUM=w_NUMDOCUM;
o_DATARILASC=w_DATARILASC;
o_DATAVALI=w_DATAVALI;
o_SOTGRUP=w_SOTGRUP;
o_RAMOGRUP=w_RAMOGRUP;
o_ATTIV=w_ATTIV;
o_CONNES=w_CONNES;
o_tipsot=w_tipsot;
o_AREAGEO=w_AREAGEO;
o_PKTBSPECIE=w_PKTBSPECIE;
o_ATTIVR=w_ATTIVR;
o_COMPORT=w_COMPORT;
}
m_PrimaryKeys=['CONNES'];
}
function i_PrimaryKey() {
return 'personbo'+'\\'+CPLib.ToCPStr(w_CONNES);
}
GetLinkPCKeys.set_o('ardt_personbo_dip',false);
GetLinkPCKeys.set_o('armt_personbo_agg',false);
GetLinkPCKeys.set_o('ardt_soggope',false);
GetLinkPCKeys.set_o('ardt_fatca_ind',false);
GetLinkPCKeys.set_o('ardt_patrimonio',false);
GetLinkPCKeys.set_o('ardt_reddito',false);
GetLinkPCKeys.o['ardt_personbo_dip']['CONNES']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_CONNES,'C');
}
}
GetLinkPCKeys.o['armt_personbo_agg']['CONNES']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_CONNES,'C');
}
}
GetLinkPCKeys.o['ardt_soggope']['COLLEG']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_CONNES,'C');
}
}
GetLinkPCKeys.o['ardt_fatca_ind']['CONNES']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_CONNES,'C');
}
}
GetLinkPCKeys.o['ardt_patrimonio']['CONNES']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_CONNES,'C');
}
}
GetLinkPCKeys.o['ardt_reddito']['CONNES']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_CONNES,'C');
}
}
resizeChildIframe.children['ardt_personbo_dip']=true;
resizeChildIframe.children['armt_personbo_agg']=true;
resizeChildIframe.children['ardt_fatca_ind']=true;
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('BKKASVQSWO',function(){return FrameRef('ardt_personbo_dip')},1,'ardt_personbo_dip',0,8)
LoadContext.f('OIREAEXNKZ',function(){return FrameRef('armt_personbo_agg')},1,'armt_personbo_agg',0,8)
LoadContext.f('RYYOFFRITV',function(){return FrameRef('ardt_soggope')},1,'ardt_soggope',0,8)
LoadContext.f('FBAHOFZNEF',function(){return FrameRef('ardt_fatca_ind')},1,'ardt_fatca_ind',0,9)
LoadContext.f('FFIYUAKUTX',function(){return FrameRef('ardt_patrimonio')},1,'ardt_patrimonio',0,10)
LoadContext.f('COWMRLCMMU',function(){return FrameRef('ardt_reddito')},1,'ardt_reddito',0,10)
GetSelectedChildPage.child={'ardt_personbo_dip': function(){return FrameRef('ardt_personbo_dip')}, 'armt_personbo_agg': function(){return FrameRef('armt_personbo_agg')}, 'ardt_soggope': function(){return FrameRef('ardt_soggope')}, 'ardt_fatca_ind': function(){return FrameRef('ardt_fatca_ind')}, 'ardt_patrimonio': function(){return FrameRef('ardt_patrimonio')}, 'ardt_reddito': function(){return FrameRef('ardt_reddito')}}
function GetSelectedPage(p_d) {
p_d.setValue('armt_personbo',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_PAESE,'C'); },"field":"CODSTA","type":"C"},{"expression":function() { return WtA(w_dessta,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"YVIKEGPYPM"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_DESCCIT,'C'); },"field":"CITTA","type":"C"},{"expression":function() { return WtA(w_idcitta,'C'); },"field":"IDBASE","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcitta','C'),"uid":"ODAYKSRECA"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_IDNASCOMUN,'C'); },"field":"IDBASE","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcittna','C'),"uid":"BYPEBFEOAJ"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_IDNASSTATO,'C'); },"field":"IDBASE","type":"C"},{"expression":function() { return WtA(w_xstatonas,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstatna','C'),"uid":"IOAMSFCCVV"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('armt_tbtipatt','C'),"fldValues":[{"expression":function() { return WtA(w_ATTIV,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xdesctipatt,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbtipatt','C'),"uid":"SAQTIHOALW"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('opemt_personbo','C'),"fldValues":[{"expression":function() { return WtA(w_CODLEGRAP,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xRAGLEGRAP,'C'); },"field":"RAGSOC","type":"C"},{"expression":function() { return WtA(w_xIDLEGRAP,'C'); },"field":"IDBASE","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"CKHRNQSKKQ"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_BANCABEN,'C'); },"field":"CODINTER","type":"C"},{"expression":function() { return WtA(w_ragbanben,'C'); },"field":"RAGSOC","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('inter2bo','C'),"uid":"DQZNJUSTLN"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_FATCA,'C'); },"field":"CODSTA","type":"C"},{"expression":function() { return WtA(w_xdesfatca,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"RKHMYOIJDM"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CITTADIN1,'C'); },"field":"CODSTA","type":"C"},{"expression":function() { return WtA(w_xDesCit1,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"CJBEXKJOQO"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CITTADIN2,'C'); },"field":"CODSTA","type":"C"},{"expression":function() { return WtA(w_xDesCit2,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"UNRQNVVFTK"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_RESFISC,'C'); },"field":"CODSTA","type":"C"},{"expression":function() { return WtA(w_xResFis,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"OSLBLDODHQ"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_AREAGEO,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xdescareag,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbareegeog','C'),"uid":"NXVXQSLAGM"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('armt_tbspecie','C'),"fldValues":[{"expression":function() { return WtA(w_PKTBSPECIE,'C'); },"field":"CODSPE","type":"C"},{"expression":function() { return WtA(w_xdescnatgiu,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbspecie','C'),"uid":"VHXDWWHVXF"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_ATTIVR,'C'); },"field":"CODICE","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbtipatt','C'),"uid":"UQYOQYIUNM"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('armt_tbcondotta','C'),"fldValues":[{"expression":function() { return WtA(w_COMPORT,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xdesccomp,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcondotta','C'),"uid":"HLXRSSMBIW"});
}
_Obli('CAUSALE',1,'EMSGWJAYYK',false,"10412866585")
_Obli('status',0,'YFBFKZZRWO',false)
_Obli('SOGAFFIDATARIO',0,'HKQDVAPIOQ',false,"78498981")
_Obli('NOTERIS',0,'FTYWOEFIPD',false,"11639044319")
_Obli('VERIFICA',0,'OXWRJNTXVJ',false,"1729760413")
_Obli('MITIGDOC',0,'OXGBDTWKSX',false,"210895516")
_Obli('MITIG',1,'DOXBACRWUU',false,"307787605")
_Obli('CRIME',0,'RHCYCLTWOT',false,"10242518395")
_Obli('DATAPROF',2,'MXITFMGTNB',false,"10252637878")
_Obli('TIPOPERS',0,'UYWIEUHCAL',true,"10456253029")
_Obli('COGNOME',0,'TWTTDWKCRG',false,"1816546867")
_Obli('NOME',0,'WWGIVGNUDW',false,"443454")
_Obli('CFESTERO',1,'CZTHKEDVCO',false,"10034405761")
_Obli('RAGSOC',0,'AWPNTOJIRR',false,"10662833243")
_Obli('PAESE',0,'YVIKEGPYPM',true,"7776403",'YVIKEGPYPM')
_Obli('DESCCIT',0,'ODAYKSRECA',true,"15186643",'ODAYKSRECA',null,function() { return (Eq(w_PAESE,'086') || Eq(w_PAESE,'139')) && Eq(w_gVerSim,'N') })
_Obli('DATAIDENT',2,'EVYVDDYVDZ',false,"11067638693")
_Obli('PROVINCIA',0,'NOTZPDMYIA',true,"10095365423",null,null,function() { return (Eq(w_PAESE,'086') || Eq(w_PAESE,'139')) && Eq(w_gVerSim,'N') })
_Obli('CAP',0,'RDAVOEETJG',true,"21587",null,null,function() { return (Eq(w_PAESE,'086') || Eq(w_PAESE,'139')) && Eq(w_gVerSim,'N') })
_Obli('CODCAB',0,'BOTAJBWHHY',true,"18003",null,null,function() { return (w_COMPLETA?(Eq(w_PAESE,'086') || Eq(w_PAESE,'139')):false) })
_Obli('DOMICILIO',0,'VYLHWTRQNX',true,"554236824",null,null,function() { return (Eq(w_PAESE,'086') || Eq(w_PAESE,'139')) && Eq(w_gVerSim,'N') })
_Obli('IDENT',0,'IRLEJAUHCB',false,"1767988220")
_Obli('IDNASCOMUN',0,'BYPEBFEOAJ',false,"200062287")
_Obli('COMPLETA',4,'BOHBZOSBVJ',false)
_Obli('NASCOMUN',0,'NEUBQNUEOJ',false,"12123334500")
_Obli('TIPINTER',0,'KPSCOABZLB',false,"3528304")
_Obli('IDNASSTATO',0,'IOAMSFCCVV',false,"10175904119")
_Obli('RISGLOB',0,'SMVVFHCEHA',false,"10500809751")
_Obli('NASSTATO',0,'HODZKKOSYW',false,"12123284333")
_Obli('SESSO',0,'QPALJZMFCL',false,"7776675")
_Obli('DATANASC',2,'XMGRWGFSFV',false,"11777527481")
_Obli('TIPODOC',0,'MBGANUUHRA',false,"11429032151")
_Obli('NUMDOCUM',0,'HVEEMUJUUY',false,"1734932797")
_Obli('DATARILASC',2,'XHWYGOPPUN',false,"1690077224")
_Obli('DATAVALI',2,'BNWXBPSIDG',false)
_Obli('AUTRILASC',0,'HRNCPADUFU',false,"10032163180")
_Obli('CODFISC',0,'OJJHIUDPFY',false,"11921223220")
_Obli('PARTIVA',0,'FHXWUTBNKI',false,"1756430089")
_Obli('CONTO',0,'JLTVZXPMKM',false,"1715428852")
_Obli('SOTGRUP',0,'LLYIGAMXRH',false,"611154211")
_Obli('ATTIVR',0,'UQYOQYIUNM',false,"2134156131")
_Obli('ATTIV',0,'SAQTIHOALW',true,"2134156131",'SAQTIHOALW',"11909346815",function() { return (w_COMPLETA?Eq(w_tipsot,'1'):false) })
_Obli('ATTIV',0,'QFJRACGINU',false)
_Obli('SETTSINT',0,'ZGNLLSFQHC',false,"2095911698")
_Obli('CONNES',0,'YTPWDRMFUS',true,"439891216")
_Obli('CONNES',0,'MQYKJYJENJ',false)
_Obli('NOSARA',0,'XCYZDRXAMJ',false,"10450770185")
_Obli('NOTIT',1,'RARXYHBSLM',false,"327723579")
_Obli('flgaggfam',0,'DFNZBCOVFH',false)
_Obli('DATARETT',2,'FROMUIZATY',false)
_Obli('COMPORT',0,'HLXRSSMBIW',false)
_Obli('COMPORT',0,'KYTSUTYBUR',false)
_Obli('PKTBSPECIE',0,'VHXDWWHVXF',false)
_Obli('PKTBSPECIE',0,'DRJTSDRPVN',false)
_Obli('RESFISC',0,'OSLBLDODHQ',false)
_Obli('CITTADIN2',0,'UNRQNVVFTK',false)
_Obli('CITTADIN1',0,'CJBEXKJOQO',false,"1390365716")
_Obli('ODB',1,'EOYNWRHHMY',false,"10390001687")
_Obli('FATCA',0,'RKHMYOIJDM',false,"299426891")
_Obli('DATARAUT',2,'UNPDFRUOXO',false,"11132282623")
_Obli('DATASEGN',2,'ESODTMPIYO',false,"1893635209")
_Obli('TIPOSOGGETTO',0,'JJETXTUKNC',false,"10456253029")
_Obli('RAPSEGNA',0,'JFJPGOWVYJ',true,"1723736132",null,"10358848056",function() { return  ! (Empty(w_TIPOSOGGETTO)) })
_Obli('RNATGIU',1,'AAQYBAEHUR',false)
_Obli('RAREA',1,'PGYFWWGOTN',false)
_Obli('AREAGEO',0,'NXVXQSLAGM',false)
_Obli('AREAGEO',0,'JHEJMIHGSH',false)
_Obli('RATTIV',1,'BOECHNDAXS',false)
_Obli('TIN',0,'HBSPPQBOJN',false,"12034347084")
_Obli('CODLEGRAP',0,'CKHRNQSKKQ',false,"11815361151")
_Obli('DISATTIVO',2,'ODWJZUZDBK',false,"1735362560")
_Obli('NOTE',0,'UMKFMWBVUO',false,"445246")
_Obli('DATAINI',2,'REJDXHTDMV',false,"1823814263")
_Obli('FLGNOTRIM',0,'XERWNYQDBZ',false)
_Obli('FATTURATO',1,'XOROAVXTCD',false,"11466123579")
_Obli('BANCABEN',0,'DQZNJUSTLN',false,"11391158649")
_Obli('DATAFINE',2,'YZOYIYAUUO',false,"1823975349")
_Obli('PEP',0,'XFKXBQYUIU',false,"1513560829")
_Obli('RCOMP',1,'ISJKSRTDAC',false)
