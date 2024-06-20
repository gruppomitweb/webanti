// Definition generated from table wutrxchk
public class MemoryCursor_wutrxchk extends CPMemoryCursor {
  MemoryCursorRow_wutrxchk row;
  MemoryCursorRow_wutrxchk empty_row;
  public MemoryCursor_wutrxchk() {
    empty_row = new MemoryCursorRow_wutrxchk();
    row = empty_row;
  }
  public MemoryCursor_wutrxchk(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_TRXCODPRG;
    p_TRXCODPRG = new java.util.Properties();
    java.util.Properties p_TRXCOGNOM;
    p_TRXCOGNOM = new java.util.Properties();
    java.util.Properties p_TRXNOME;
    p_TRXNOME = new java.util.Properties();
    java.util.Properties p_TRXDOMICI;
    p_TRXDOMICI = new java.util.Properties();
    java.util.Properties p_TRXFLGCF;
    p_TRXFLGCF = new java.util.Properties();
    java.util.Properties p_TRXCODFIS;
    p_TRXCODFIS = new java.util.Properties();
    java.util.Properties p_TRXLUONAS;
    p_TRXLUONAS = new java.util.Properties();
    java.util.Properties p_TRXNUMDOC;
    p_TRXNUMDOC = new java.util.Properties();
    java.util.Properties p_TRXDATSCA;
    p_TRXDATSCA = new java.util.Properties();
    java.util.Properties p_TRXDATRIL;
    p_TRXDATRIL = new java.util.Properties();
    java.util.Properties p_TRXAUTRIL;
    p_TRXAUTRIL = new java.util.Properties();
    java.util.Properties p_TRXNAZRES;
    p_TRXNAZRES = new java.util.Properties();
    java.util.Properties p_TRXCITRES;
    p_TRXCITRES = new java.util.Properties();
    java.util.Properties p_TRXTIPDOC;
    p_TRXTIPDOC = new java.util.Properties();
    java.util.Properties p_TRXDATOPE;
    p_TRXDATOPE = new java.util.Properties();
    java.util.Properties p_TRXFLGCON;
    p_TRXFLGCON = new java.util.Properties();
    java.util.Properties p_TRSSEGNO;
    p_TRSSEGNO = new java.util.Properties();
    java.util.Properties p_TRXIMPORTO;
    p_TRXIMPORTO = new java.util.Properties();
    java.util.Properties p_TRXCONTAN;
    p_TRXCONTAN = new java.util.Properties();
    java.util.Properties p_TRXUNIQUE;
    p_TRXUNIQUE = new java.util.Properties();
    java.util.Properties p_TRXCODDIP;
    p_TRXCODDIP = new java.util.Properties();
    java.util.Properties p_TRXCOGCON;
    p_TRXCOGCON = new java.util.Properties();
    java.util.Properties p_TRXNOMCON;
    p_TRXNOMCON = new java.util.Properties();
    java.util.Properties p_TRXDESTIN;
    p_TRXDESTIN = new java.util.Properties();
    java.util.Properties p_TRXMTCN;
    p_TRXMTCN = new java.util.Properties();
    java.util.Properties p_TRXDATNAS;
    p_TRXDATNAS = new java.util.Properties();
    java.util.Properties p_TRXSESSO;
    p_TRXSESSO = new java.util.Properties();
    java.util.Properties p_TRXCODCAS;
    p_TRXCODCAS = new java.util.Properties();
    java.util.Properties p_TRXRECTYPE;
    p_TRXRECTYPE = new java.util.Properties();
    java.util.Properties p_TRXCODMAG;
    p_TRXCODMAG = new java.util.Properties();
    java.util.Properties p_TRXCODUNI;
    p_TRXCODUNI = new java.util.Properties();
    java.util.Properties p_TRXERROR01;
    p_TRXERROR01 = new java.util.Properties();
    java.util.Properties p_TRXERROR02;
    p_TRXERROR02 = new java.util.Properties();
    java.util.Properties p_TRXERROR03;
    p_TRXERROR03 = new java.util.Properties();
    java.util.Properties p_TRXERROR04;
    p_TRXERROR04 = new java.util.Properties();
    java.util.Properties p_TRXERROR05;
    p_TRXERROR05 = new java.util.Properties();
    java.util.Properties p_TRXERROR06;
    p_TRXERROR06 = new java.util.Properties();
    java.util.Properties p_TRXERROR07;
    p_TRXERROR07 = new java.util.Properties();
    java.util.Properties p_TRXERROR08;
    p_TRXERROR08 = new java.util.Properties();
    java.util.Properties p_TRXERROR09;
    p_TRXERROR09 = new java.util.Properties();
    java.util.Properties p_TRXERROR10;
    p_TRXERROR10 = new java.util.Properties();
    java.util.Properties p_TRXERROR11;
    p_TRXERROR11 = new java.util.Properties();
    java.util.Properties p_TRXERROR12;
    p_TRXERROR12 = new java.util.Properties();
    java.util.Properties p_TRXERROR13;
    p_TRXERROR13 = new java.util.Properties();
    java.util.Properties p_TRXERROR14;
    p_TRXERROR14 = new java.util.Properties();
    java.util.Properties p_TRXERROR15;
    p_TRXERROR15 = new java.util.Properties();
    java.util.Properties p_TRXERROR16;
    p_TRXERROR16 = new java.util.Properties();
    java.util.Properties p_TRXERROR17;
    p_TRXERROR17 = new java.util.Properties();
    java.util.Properties p_TRXERROR18;
    p_TRXERROR18 = new java.util.Properties();
    java.util.Properties p_TRXERROR19;
    p_TRXERROR19 = new java.util.Properties();
    java.util.Properties p_TRXERROR20;
    p_TRXERROR20 = new java.util.Properties();
    java.util.Properties p_TRXERROR21;
    p_TRXERROR21 = new java.util.Properties();
    java.util.Properties p_TRXERROR22;
    p_TRXERROR22 = new java.util.Properties();
    java.util.Properties p_TRXERROR23;
    p_TRXERROR23 = new java.util.Properties();
    java.util.Properties p_TRXERROR24;
    p_TRXERROR24 = new java.util.Properties();
    java.util.Properties p_TRXERROR25;
    p_TRXERROR25 = new java.util.Properties();
    java.util.Properties p_TRXERROR26;
    p_TRXERROR26 = new java.util.Properties();
    java.util.Properties p_TRXERROR27;
    p_TRXERROR27 = new java.util.Properties();
    java.util.Properties p_TRXERROR28;
    p_TRXERROR28 = new java.util.Properties();
    java.util.Properties p_TRXERROR29;
    p_TRXERROR29 = new java.util.Properties();
    java.util.Properties p_TRXERROR30;
    p_TRXERROR30 = new java.util.Properties();
    java.util.Properties p_TRXERROR31;
    p_TRXERROR31 = new java.util.Properties();
    java.util.Properties p_TRXERROR32;
    p_TRXERROR32 = new java.util.Properties();
    java.util.Properties p_TRXERROR33;
    p_TRXERROR33 = new java.util.Properties();
    java.util.Properties p_TRXERROR34;
    p_TRXERROR34 = new java.util.Properties();
    java.util.Properties p_TRXERROR35;
    p_TRXERROR35 = new java.util.Properties();
    java.util.Properties p_TRXERROR36;
    p_TRXERROR36 = new java.util.Properties();
    java.util.Properties p_TRXERROR37;
    p_TRXERROR37 = new java.util.Properties();
    java.util.Properties p_TRXERROR38;
    p_TRXERROR38 = new java.util.Properties();
    java.util.Properties p_TRXERROR39;
    p_TRXERROR39 = new java.util.Properties();
    java.util.Properties p_TRXERROR40;
    p_TRXERROR40 = new java.util.Properties();
    java.util.Properties p_TRXERROR41;
    p_TRXERROR41 = new java.util.Properties();
    java.util.Properties p_TRXERROR42;
    p_TRXERROR42 = new java.util.Properties();
    java.util.Properties p_TRXERROR43;
    p_TRXERROR43 = new java.util.Properties();
    java.util.Properties p_TRXERROR44;
    p_TRXERROR44 = new java.util.Properties();
    java.util.Properties p_TRXERROR45;
    p_TRXERROR45 = new java.util.Properties();
    java.util.Properties p_TRXERROR46;
    p_TRXERROR46 = new java.util.Properties();
    java.util.Properties p_TRXERROR47;
    p_TRXERROR47 = new java.util.Properties();
    java.util.Properties p_TRXERROR48;
    p_TRXERROR48 = new java.util.Properties();
    java.util.Properties p_TRXERROR49;
    p_TRXERROR49 = new java.util.Properties();
    java.util.Properties p_TRXERROR50;
    p_TRXERROR50 = new java.util.Properties();
    java.util.Properties p_TRXERRAUA01;
    p_TRXERRAUA01 = new java.util.Properties();
    java.util.Properties p_TRXERRAUA02;
    p_TRXERRAUA02 = new java.util.Properties();
    java.util.Properties p_TRXERRAUA03;
    p_TRXERRAUA03 = new java.util.Properties();
    java.util.Properties p_TRXERRAUA04;
    p_TRXERRAUA04 = new java.util.Properties();
    java.util.Properties p_TRXERRAUA05;
    p_TRXERRAUA05 = new java.util.Properties();
    java.util.Properties p_TRXERRAUA06;
    p_TRXERRAUA06 = new java.util.Properties();
    java.util.Properties p_TRXERRAUA07;
    p_TRXERRAUA07 = new java.util.Properties();
    java.util.Properties p_TRXERRAUA08;
    p_TRXERRAUA08 = new java.util.Properties();
    java.util.Properties p_TRXERRAUA09;
    p_TRXERRAUA09 = new java.util.Properties();
    java.util.Properties p_TRXERRAUA10;
    p_TRXERRAUA10 = new java.util.Properties();
    java.util.Properties p_TRXFLGAUI;
    p_TRXFLGAUI = new java.util.Properties();
    java.util.Properties p_TRXFLGAUA;
    p_TRXFLGAUA = new java.util.Properties();
    java.util.Properties p_TRXFLGFOR;
    p_TRXFLGFOR = new java.util.Properties();
    java.util.Properties p_TRXAUICHK;
    p_TRXAUICHK = new java.util.Properties();
    java.util.Properties p_TRXAUACHK;
    p_TRXAUACHK = new java.util.Properties();
    java.util.Properties p_TRXNOTEOPER;
    p_TRXNOTEOPER = new java.util.Properties();
    java.util.Properties p_TRXFORCE;
    p_TRXFORCE = new java.util.Properties();
    java.util.Properties p_TRXNASSTATO;
    p_TRXNASSTATO = new java.util.Properties();
    java.util.Properties p_TRXNASCOMUN;
    p_TRXNASCOMUN = new java.util.Properties();
    java.util.Properties p_TRXFLGAUAQ1;
    p_TRXFLGAUAQ1 = new java.util.Properties();
    java.util.Properties p_TRXFLGAUAQ2;
    p_TRXFLGAUAQ2 = new java.util.Properties();
    java.util.Properties p_TRXFLGAUAQ3;
    p_TRXFLGAUAQ3 = new java.util.Properties();
    java.util.Properties p_TRXFLGAUAQ4;
    p_TRXFLGAUAQ4 = new java.util.Properties();
    java.util.Properties p_TRXFLGAUAQ5;
    p_TRXFLGAUAQ5 = new java.util.Properties();
    java.util.Properties p_TRXDATRICERCA;
    p_TRXDATRICERCA = new java.util.Properties();
    java.util.Properties p_TRXUTENTE;
    p_TRXUTENTE = new java.util.Properties();
    java.util.Properties p_TRXTINILAV;
    p_TRXTINILAV = new java.util.Properties();
    java.util.Properties p_TRXTFINLAV;
    p_TRXTFINLAV = new java.util.Properties();
    java.util.Properties p_TRXDINILAV;
    p_TRXDINILAV = new java.util.Properties();
    java.util.Properties p_TRDFINLAV;
    p_TRDFINLAV = new java.util.Properties();
    java.util.Properties p_TRFLGINLAV;
    p_TRFLGINLAV = new java.util.Properties();
    java.util.Properties p_TRXNUMRIL;
    p_TRXNUMRIL = new java.util.Properties();
    java.util.Properties p_TRXSCAEDT;
    p_TRXSCAEDT = new java.util.Properties();
    java.util.Properties p_TRXESITO;
    p_TRXESITO = new java.util.Properties();
    java.util.Properties p_TRXDERIVATA;
    p_TRXDERIVATA = new java.util.Properties();
    java.util.Properties p_TRXGALACTIC;
    p_TRXGALACTIC = new java.util.Properties();
    java.util.Properties p_TRXNAZRIL;
    p_TRXNAZRIL = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXCODPRG".equalsIgnoreCase(key)) {
        p_TRXCODPRG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXCOGNOM".equalsIgnoreCase(key)) {
        p_TRXCOGNOM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXNOME".equalsIgnoreCase(key)) {
        p_TRXNOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXDOMICI".equalsIgnoreCase(key)) {
        p_TRXDOMICI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXFLGCF".equalsIgnoreCase(key)) {
        p_TRXFLGCF = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXCODFIS".equalsIgnoreCase(key)) {
        p_TRXCODFIS = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXLUONAS".equalsIgnoreCase(key)) {
        p_TRXLUONAS = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXNUMDOC".equalsIgnoreCase(key)) {
        p_TRXNUMDOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXDATSCA".equalsIgnoreCase(key)) {
        p_TRXDATSCA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXDATRIL".equalsIgnoreCase(key)) {
        p_TRXDATRIL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXAUTRIL".equalsIgnoreCase(key)) {
        p_TRXAUTRIL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXNAZRES".equalsIgnoreCase(key)) {
        p_TRXNAZRES = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXCITRES".equalsIgnoreCase(key)) {
        p_TRXCITRES = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXTIPDOC".equalsIgnoreCase(key)) {
        p_TRXTIPDOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXDATOPE".equalsIgnoreCase(key)) {
        p_TRXDATOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXFLGCON".equalsIgnoreCase(key)) {
        p_TRXFLGCON = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRSSEGNO".equalsIgnoreCase(key)) {
        p_TRSSEGNO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXIMPORTO".equalsIgnoreCase(key)) {
        p_TRXIMPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXCONTAN".equalsIgnoreCase(key)) {
        p_TRXCONTAN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXUNIQUE".equalsIgnoreCase(key)) {
        p_TRXUNIQUE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXCODDIP".equalsIgnoreCase(key)) {
        p_TRXCODDIP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXCOGCON".equalsIgnoreCase(key)) {
        p_TRXCOGCON = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXNOMCON".equalsIgnoreCase(key)) {
        p_TRXNOMCON = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXDESTIN".equalsIgnoreCase(key)) {
        p_TRXDESTIN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXMTCN".equalsIgnoreCase(key)) {
        p_TRXMTCN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXDATNAS".equalsIgnoreCase(key)) {
        p_TRXDATNAS = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXSESSO".equalsIgnoreCase(key)) {
        p_TRXSESSO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXCODCAS".equalsIgnoreCase(key)) {
        p_TRXCODCAS = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXRECTYPE".equalsIgnoreCase(key)) {
        p_TRXRECTYPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXCODMAG".equalsIgnoreCase(key)) {
        p_TRXCODMAG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXCODUNI".equalsIgnoreCase(key)) {
        p_TRXCODUNI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR01".equalsIgnoreCase(key)) {
        p_TRXERROR01 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR02".equalsIgnoreCase(key)) {
        p_TRXERROR02 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR03".equalsIgnoreCase(key)) {
        p_TRXERROR03 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR04".equalsIgnoreCase(key)) {
        p_TRXERROR04 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR05".equalsIgnoreCase(key)) {
        p_TRXERROR05 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR06".equalsIgnoreCase(key)) {
        p_TRXERROR06 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR07".equalsIgnoreCase(key)) {
        p_TRXERROR07 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR08".equalsIgnoreCase(key)) {
        p_TRXERROR08 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR09".equalsIgnoreCase(key)) {
        p_TRXERROR09 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR10".equalsIgnoreCase(key)) {
        p_TRXERROR10 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR11".equalsIgnoreCase(key)) {
        p_TRXERROR11 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR12".equalsIgnoreCase(key)) {
        p_TRXERROR12 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR13".equalsIgnoreCase(key)) {
        p_TRXERROR13 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR14".equalsIgnoreCase(key)) {
        p_TRXERROR14 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR15".equalsIgnoreCase(key)) {
        p_TRXERROR15 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR16".equalsIgnoreCase(key)) {
        p_TRXERROR16 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR17".equalsIgnoreCase(key)) {
        p_TRXERROR17 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR18".equalsIgnoreCase(key)) {
        p_TRXERROR18 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR19".equalsIgnoreCase(key)) {
        p_TRXERROR19 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR20".equalsIgnoreCase(key)) {
        p_TRXERROR20 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR21".equalsIgnoreCase(key)) {
        p_TRXERROR21 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR22".equalsIgnoreCase(key)) {
        p_TRXERROR22 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR23".equalsIgnoreCase(key)) {
        p_TRXERROR23 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR24".equalsIgnoreCase(key)) {
        p_TRXERROR24 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR25".equalsIgnoreCase(key)) {
        p_TRXERROR25 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR26".equalsIgnoreCase(key)) {
        p_TRXERROR26 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR27".equalsIgnoreCase(key)) {
        p_TRXERROR27 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR28".equalsIgnoreCase(key)) {
        p_TRXERROR28 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR29".equalsIgnoreCase(key)) {
        p_TRXERROR29 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR30".equalsIgnoreCase(key)) {
        p_TRXERROR30 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR31".equalsIgnoreCase(key)) {
        p_TRXERROR31 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR32".equalsIgnoreCase(key)) {
        p_TRXERROR32 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR33".equalsIgnoreCase(key)) {
        p_TRXERROR33 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR34".equalsIgnoreCase(key)) {
        p_TRXERROR34 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR35".equalsIgnoreCase(key)) {
        p_TRXERROR35 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR36".equalsIgnoreCase(key)) {
        p_TRXERROR36 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR37".equalsIgnoreCase(key)) {
        p_TRXERROR37 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR38".equalsIgnoreCase(key)) {
        p_TRXERROR38 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR39".equalsIgnoreCase(key)) {
        p_TRXERROR39 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR40".equalsIgnoreCase(key)) {
        p_TRXERROR40 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR41".equalsIgnoreCase(key)) {
        p_TRXERROR41 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR42".equalsIgnoreCase(key)) {
        p_TRXERROR42 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR43".equalsIgnoreCase(key)) {
        p_TRXERROR43 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR44".equalsIgnoreCase(key)) {
        p_TRXERROR44 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR45".equalsIgnoreCase(key)) {
        p_TRXERROR45 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR46".equalsIgnoreCase(key)) {
        p_TRXERROR46 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR47".equalsIgnoreCase(key)) {
        p_TRXERROR47 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR48".equalsIgnoreCase(key)) {
        p_TRXERROR48 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR49".equalsIgnoreCase(key)) {
        p_TRXERROR49 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERROR50".equalsIgnoreCase(key)) {
        p_TRXERROR50 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERRAUA01".equalsIgnoreCase(key)) {
        p_TRXERRAUA01 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERRAUA02".equalsIgnoreCase(key)) {
        p_TRXERRAUA02 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERRAUA03".equalsIgnoreCase(key)) {
        p_TRXERRAUA03 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERRAUA04".equalsIgnoreCase(key)) {
        p_TRXERRAUA04 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERRAUA05".equalsIgnoreCase(key)) {
        p_TRXERRAUA05 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERRAUA06".equalsIgnoreCase(key)) {
        p_TRXERRAUA06 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERRAUA07".equalsIgnoreCase(key)) {
        p_TRXERRAUA07 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERRAUA08".equalsIgnoreCase(key)) {
        p_TRXERRAUA08 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERRAUA09".equalsIgnoreCase(key)) {
        p_TRXERRAUA09 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXERRAUA10".equalsIgnoreCase(key)) {
        p_TRXERRAUA10 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXFLGAUI".equalsIgnoreCase(key)) {
        p_TRXFLGAUI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXFLGAUA".equalsIgnoreCase(key)) {
        p_TRXFLGAUA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXFLGFOR".equalsIgnoreCase(key)) {
        p_TRXFLGFOR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXAUICHK".equalsIgnoreCase(key)) {
        p_TRXAUICHK = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXAUACHK".equalsIgnoreCase(key)) {
        p_TRXAUACHK = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXNOTEOPER".equalsIgnoreCase(key)) {
        p_TRXNOTEOPER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXFORCE".equalsIgnoreCase(key)) {
        p_TRXFORCE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXNASSTATO".equalsIgnoreCase(key)) {
        p_TRXNASSTATO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXNASCOMUN".equalsIgnoreCase(key)) {
        p_TRXNASCOMUN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXFLGAUAQ1".equalsIgnoreCase(key)) {
        p_TRXFLGAUAQ1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXFLGAUAQ2".equalsIgnoreCase(key)) {
        p_TRXFLGAUAQ2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXFLGAUAQ3".equalsIgnoreCase(key)) {
        p_TRXFLGAUAQ3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXFLGAUAQ4".equalsIgnoreCase(key)) {
        p_TRXFLGAUAQ4 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXFLGAUAQ5".equalsIgnoreCase(key)) {
        p_TRXFLGAUAQ5 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXDATRICERCA".equalsIgnoreCase(key)) {
        p_TRXDATRICERCA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXUTENTE".equalsIgnoreCase(key)) {
        p_TRXUTENTE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXTINILAV".equalsIgnoreCase(key)) {
        p_TRXTINILAV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXTFINLAV".equalsIgnoreCase(key)) {
        p_TRXTFINLAV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXDINILAV".equalsIgnoreCase(key)) {
        p_TRXDINILAV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRDFINLAV".equalsIgnoreCase(key)) {
        p_TRDFINLAV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRFLGINLAV".equalsIgnoreCase(key)) {
        p_TRFLGINLAV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXNUMRIL".equalsIgnoreCase(key)) {
        p_TRXNUMRIL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXSCAEDT".equalsIgnoreCase(key)) {
        p_TRXSCAEDT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXESITO".equalsIgnoreCase(key)) {
        p_TRXESITO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXDERIVATA".equalsIgnoreCase(key)) {
        p_TRXDERIVATA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXGALACTIC".equalsIgnoreCase(key)) {
        p_TRXGALACTIC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXNAZRIL".equalsIgnoreCase(key)) {
        p_TRXNAZRIL = CPLib.GetProperties(p.getProperty(key));
      }
    }
    for ( i = 1; CPLib.le(i,Rows); i = i + (1)) {
      AppendBlank();
      String l_cKeyValue = null;
      l_cKeyValue = CPLib.GetProperty(l_Key,"",l_cKeyValue,i);
      Object l_KeyValue = l_cKeyValue;
      if ( ! (CPLib.IsNull(l_KeyValue))) {
        SetKey(l_KeyValue);
      }
      row.TRXCODPRG = CPLib.GetProperty(p_TRXCODPRG,"",0,i);
      row.TRXCOGNOM = CPLib.GetProperty(p_TRXCOGNOM,"","",i);
      row.TRXNOME = CPLib.GetProperty(p_TRXNOME,"","",i);
      row.TRXDOMICI = CPLib.GetProperty(p_TRXDOMICI,"","",i);
      row.TRXFLGCF = CPLib.GetProperty(p_TRXFLGCF,"","",i);
      row.TRXCODFIS = CPLib.GetProperty(p_TRXCODFIS,"","",i);
      row.TRXLUONAS = CPLib.GetProperty(p_TRXLUONAS,"","",i);
      row.TRXNUMDOC = CPLib.GetProperty(p_TRXNUMDOC,"","",i);
      row.TRXDATSCA = CPLib.GetProperty(p_TRXDATSCA,"",CPLib.NullDate(),i);
      row.TRXDATRIL = CPLib.GetProperty(p_TRXDATRIL,"",CPLib.NullDate(),i);
      row.TRXAUTRIL = CPLib.GetProperty(p_TRXAUTRIL,"","",i);
      row.TRXNAZRES = CPLib.GetProperty(p_TRXNAZRES,"","",i);
      row.TRXCITRES = CPLib.GetProperty(p_TRXCITRES,"","",i);
      row.TRXTIPDOC = CPLib.GetProperty(p_TRXTIPDOC,"","",i);
      row.TRXDATOPE = CPLib.GetProperty(p_TRXDATOPE,"",CPLib.NullDate(),i);
      row.TRXFLGCON = CPLib.GetProperty(p_TRXFLGCON,"","",i);
      row.TRSSEGNO = CPLib.GetProperty(p_TRSSEGNO,"","",i);
      row.TRXIMPORTO = CPLib.GetProperty(p_TRXIMPORTO,"",0,i);
      row.TRXCONTAN = CPLib.GetProperty(p_TRXCONTAN,"",0,i);
      row.TRXUNIQUE = CPLib.GetProperty(p_TRXUNIQUE,"","",i);
      row.TRXCODDIP = CPLib.GetProperty(p_TRXCODDIP,"","",i);
      row.TRXCOGCON = CPLib.GetProperty(p_TRXCOGCON,"","",i);
      row.TRXNOMCON = CPLib.GetProperty(p_TRXNOMCON,"","",i);
      row.TRXDESTIN = CPLib.GetProperty(p_TRXDESTIN,"","",i);
      row.TRXMTCN = CPLib.GetProperty(p_TRXMTCN,"","",i);
      row.TRXDATNAS = CPLib.GetProperty(p_TRXDATNAS,"",CPLib.NullDate(),i);
      row.TRXSESSO = CPLib.GetProperty(p_TRXSESSO,"","",i);
      row.TRXCODCAS = CPLib.GetProperty(p_TRXCODCAS,"","",i);
      row.TRXRECTYPE = CPLib.GetProperty(p_TRXRECTYPE,"","",i);
      row.TRXCODMAG = CPLib.GetProperty(p_TRXCODMAG,"","",i);
      row.TRXCODUNI = CPLib.GetProperty(p_TRXCODUNI,"","",i);
      row.TRXERROR01 = CPLib.GetProperty(p_TRXERROR01,"","",i);
      row.TRXERROR02 = CPLib.GetProperty(p_TRXERROR02,"","",i);
      row.TRXERROR03 = CPLib.GetProperty(p_TRXERROR03,"","",i);
      row.TRXERROR04 = CPLib.GetProperty(p_TRXERROR04,"","",i);
      row.TRXERROR05 = CPLib.GetProperty(p_TRXERROR05,"","",i);
      row.TRXERROR06 = CPLib.GetProperty(p_TRXERROR06,"","",i);
      row.TRXERROR07 = CPLib.GetProperty(p_TRXERROR07,"","",i);
      row.TRXERROR08 = CPLib.GetProperty(p_TRXERROR08,"","",i);
      row.TRXERROR09 = CPLib.GetProperty(p_TRXERROR09,"","",i);
      row.TRXERROR10 = CPLib.GetProperty(p_TRXERROR10,"","",i);
      row.TRXERROR11 = CPLib.GetProperty(p_TRXERROR11,"","",i);
      row.TRXERROR12 = CPLib.GetProperty(p_TRXERROR12,"","",i);
      row.TRXERROR13 = CPLib.GetProperty(p_TRXERROR13,"","",i);
      row.TRXERROR14 = CPLib.GetProperty(p_TRXERROR14,"","",i);
      row.TRXERROR15 = CPLib.GetProperty(p_TRXERROR15,"","",i);
      row.TRXERROR16 = CPLib.GetProperty(p_TRXERROR16,"","",i);
      row.TRXERROR17 = CPLib.GetProperty(p_TRXERROR17,"","",i);
      row.TRXERROR18 = CPLib.GetProperty(p_TRXERROR18,"","",i);
      row.TRXERROR19 = CPLib.GetProperty(p_TRXERROR19,"","",i);
      row.TRXERROR20 = CPLib.GetProperty(p_TRXERROR20,"","",i);
      row.TRXERROR21 = CPLib.GetProperty(p_TRXERROR21,"","",i);
      row.TRXERROR22 = CPLib.GetProperty(p_TRXERROR22,"","",i);
      row.TRXERROR23 = CPLib.GetProperty(p_TRXERROR23,"","",i);
      row.TRXERROR24 = CPLib.GetProperty(p_TRXERROR24,"","",i);
      row.TRXERROR25 = CPLib.GetProperty(p_TRXERROR25,"","",i);
      row.TRXERROR26 = CPLib.GetProperty(p_TRXERROR26,"","",i);
      row.TRXERROR27 = CPLib.GetProperty(p_TRXERROR27,"","",i);
      row.TRXERROR28 = CPLib.GetProperty(p_TRXERROR28,"","",i);
      row.TRXERROR29 = CPLib.GetProperty(p_TRXERROR29,"","",i);
      row.TRXERROR30 = CPLib.GetProperty(p_TRXERROR30,"","",i);
      row.TRXERROR31 = CPLib.GetProperty(p_TRXERROR31,"","",i);
      row.TRXERROR32 = CPLib.GetProperty(p_TRXERROR32,"","",i);
      row.TRXERROR33 = CPLib.GetProperty(p_TRXERROR33,"","",i);
      row.TRXERROR34 = CPLib.GetProperty(p_TRXERROR34,"","",i);
      row.TRXERROR35 = CPLib.GetProperty(p_TRXERROR35,"","",i);
      row.TRXERROR36 = CPLib.GetProperty(p_TRXERROR36,"","",i);
      row.TRXERROR37 = CPLib.GetProperty(p_TRXERROR37,"","",i);
      row.TRXERROR38 = CPLib.GetProperty(p_TRXERROR38,"","",i);
      row.TRXERROR39 = CPLib.GetProperty(p_TRXERROR39,"","",i);
      row.TRXERROR40 = CPLib.GetProperty(p_TRXERROR40,"","",i);
      row.TRXERROR41 = CPLib.GetProperty(p_TRXERROR41,"","",i);
      row.TRXERROR42 = CPLib.GetProperty(p_TRXERROR42,"","",i);
      row.TRXERROR43 = CPLib.GetProperty(p_TRXERROR43,"","",i);
      row.TRXERROR44 = CPLib.GetProperty(p_TRXERROR44,"","",i);
      row.TRXERROR45 = CPLib.GetProperty(p_TRXERROR45,"","",i);
      row.TRXERROR46 = CPLib.GetProperty(p_TRXERROR46,"","",i);
      row.TRXERROR47 = CPLib.GetProperty(p_TRXERROR47,"","",i);
      row.TRXERROR48 = CPLib.GetProperty(p_TRXERROR48,"","",i);
      row.TRXERROR49 = CPLib.GetProperty(p_TRXERROR49,"","",i);
      row.TRXERROR50 = CPLib.GetProperty(p_TRXERROR50,"","",i);
      row.TRXERRAUA01 = CPLib.GetProperty(p_TRXERRAUA01,"","",i);
      row.TRXERRAUA02 = CPLib.GetProperty(p_TRXERRAUA02,"","",i);
      row.TRXERRAUA03 = CPLib.GetProperty(p_TRXERRAUA03,"","",i);
      row.TRXERRAUA04 = CPLib.GetProperty(p_TRXERRAUA04,"","",i);
      row.TRXERRAUA05 = CPLib.GetProperty(p_TRXERRAUA05,"","",i);
      row.TRXERRAUA06 = CPLib.GetProperty(p_TRXERRAUA06,"","",i);
      row.TRXERRAUA07 = CPLib.GetProperty(p_TRXERRAUA07,"","",i);
      row.TRXERRAUA08 = CPLib.GetProperty(p_TRXERRAUA08,"","",i);
      row.TRXERRAUA09 = CPLib.GetProperty(p_TRXERRAUA09,"","",i);
      row.TRXERRAUA10 = CPLib.GetProperty(p_TRXERRAUA10,"","",i);
      row.TRXFLGAUI = CPLib.GetProperty(p_TRXFLGAUI,"","",i);
      row.TRXFLGAUA = CPLib.GetProperty(p_TRXFLGAUA,"","",i);
      row.TRXFLGFOR = CPLib.GetProperty(p_TRXFLGFOR,"","",i);
      row.TRXAUICHK = CPLib.GetProperty(p_TRXAUICHK,"","",i);
      row.TRXAUACHK = CPLib.GetProperty(p_TRXAUACHK,"","",i);
      row.TRXNOTEOPER = CPLib.GetProperty(p_TRXNOTEOPER,"","",i);
      row.TRXFORCE = CPLib.GetProperty(p_TRXFORCE,"","",i);
      row.TRXNASSTATO = CPLib.GetProperty(p_TRXNASSTATO,"","",i);
      row.TRXNASCOMUN = CPLib.GetProperty(p_TRXNASCOMUN,"","",i);
      row.TRXFLGAUAQ1 = CPLib.GetProperty(p_TRXFLGAUAQ1,"","",i);
      row.TRXFLGAUAQ2 = CPLib.GetProperty(p_TRXFLGAUAQ2,"","",i);
      row.TRXFLGAUAQ3 = CPLib.GetProperty(p_TRXFLGAUAQ3,"","",i);
      row.TRXFLGAUAQ4 = CPLib.GetProperty(p_TRXFLGAUAQ4,"","",i);
      row.TRXFLGAUAQ5 = CPLib.GetProperty(p_TRXFLGAUAQ5,"","",i);
      row.TRXDATRICERCA = CPLib.GetProperty(p_TRXDATRICERCA,"",CPLib.NullDate(),i);
      row.TRXUTENTE = CPLib.GetProperty(p_TRXUTENTE,"",0,i);
      row.TRXTINILAV = CPLib.GetProperty(p_TRXTINILAV,"",CPLib.NullDateTime(),i);
      row.TRXTFINLAV = CPLib.GetProperty(p_TRXTFINLAV,"",CPLib.NullDateTime(),i);
      row.TRXDINILAV = CPLib.GetProperty(p_TRXDINILAV,"",CPLib.NullDate(),i);
      row.TRDFINLAV = CPLib.GetProperty(p_TRDFINLAV,"",CPLib.NullDate(),i);
      row.TRFLGINLAV = CPLib.GetProperty(p_TRFLGINLAV,"","",i);
      row.TRXNUMRIL = CPLib.GetProperty(p_TRXNUMRIL,"",0,i);
      row.TRXSCAEDT = CPLib.GetProperty(p_TRXSCAEDT,"",CPLib.NullDate(),i);
      row.TRXESITO = CPLib.GetProperty(p_TRXESITO,"","",i);
      row.TRXDERIVATA = CPLib.GetProperty(p_TRXDERIVATA,"","",i);
      row.TRXGALACTIC = CPLib.GetProperty(p_TRXGALACTIC,"","",i);
      row.TRXNAZRIL = CPLib.GetProperty(p_TRXNAZRIL,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_wutrxchk)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_wutrxchk();
  }
  protected String[] GetColumnNames() {
    return row.GetColumnNames();
  }
  protected String[] GetColumnTypes() {
    return row.GetColumnTypes();
  }
  public CPMemoryCursorRow CurrentRow() {
    return row;
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_wutrxchk _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_wutrxchk _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_wutrxchk> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_wutrxchk p_Row) {
    MemoryCursorRow_wutrxchk l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_wutrxchk();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_wutrxchk p_Row) {
    MemoryCursorRow_wutrxchk l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_wutrxchk();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_wutrxchk p_Row) {
    MemoryCursorRow_wutrxchk l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_wutrxchk();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_wutrxchk p_Row) {
    MemoryCursorRow_wutrxchk l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_wutrxchk();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_wutrxchk p_Row) {
    MemoryCursorRow_wutrxchk l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_wutrxchk();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_wutrxchk p_Row) {
    MemoryCursorRow_wutrxchk l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_wutrxchk();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_wutrxchk p_Row) {
    MemoryCursorRow_wutrxchk l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_wutrxchk();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_wutrxchk p_Row) {
    MemoryCursorRow_wutrxchk l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_wutrxchk();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_wutrxchk p_Row) {
    MemoryCursorRow_wutrxchk l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_wutrxchk();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_wutrxchk p_Row) {
    MemoryCursorRow_wutrxchk l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_wutrxchk();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_wutrxchk p_Row) {
    MemoryCursorRow_wutrxchk l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_wutrxchk();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_wutrxchk p_Row) {
    MemoryCursorRow_wutrxchk l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_wutrxchk();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_wutrxchk p_Row) {
    MemoryCursorRow_wutrxchk l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_wutrxchk();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_wutrxchk p_Row) {
    MemoryCursorRow_wutrxchk l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_wutrxchk();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_wutrxchk p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_wutrxchk();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
