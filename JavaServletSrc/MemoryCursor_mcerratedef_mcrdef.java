// Definition generated from record definition mcerratedef_mcrdef
public class MemoryCursor_mcerratedef_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcerratedef_mcrdef row;
  MemoryCursorRow_mcerratedef_mcrdef empty_row;
  public MemoryCursor_mcerratedef_mcrdef() {
    empty_row = new MemoryCursorRow_mcerratedef_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcerratedef_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_colonna01;
    p_colonna01 = new java.util.Properties();
    java.util.Properties p_colonna02;
    p_colonna02 = new java.util.Properties();
    java.util.Properties p_colonna03;
    p_colonna03 = new java.util.Properties();
    java.util.Properties p_colonna04;
    p_colonna04 = new java.util.Properties();
    java.util.Properties p_colonna05;
    p_colonna05 = new java.util.Properties();
    java.util.Properties p_colonna06;
    p_colonna06 = new java.util.Properties();
    java.util.Properties p_colonna07;
    p_colonna07 = new java.util.Properties();
    java.util.Properties p_colonna08;
    p_colonna08 = new java.util.Properties();
    java.util.Properties p_colonna09;
    p_colonna09 = new java.util.Properties();
    java.util.Properties p_colonna10;
    p_colonna10 = new java.util.Properties();
    java.util.Properties p_colonna11;
    p_colonna11 = new java.util.Properties();
    java.util.Properties p_colonna12;
    p_colonna12 = new java.util.Properties();
    java.util.Properties p_colonna13;
    p_colonna13 = new java.util.Properties();
    java.util.Properties p_colonna14;
    p_colonna14 = new java.util.Properties();
    java.util.Properties p_colonna15;
    p_colonna15 = new java.util.Properties();
    java.util.Properties p_colonna16;
    p_colonna16 = new java.util.Properties();
    java.util.Properties p_colonna17;
    p_colonna17 = new java.util.Properties();
    java.util.Properties p_colonna18;
    p_colonna18 = new java.util.Properties();
    java.util.Properties p_colonna19;
    p_colonna19 = new java.util.Properties();
    java.util.Properties p_colonna20;
    p_colonna20 = new java.util.Properties();
    java.util.Properties p_colonna21;
    p_colonna21 = new java.util.Properties();
    java.util.Properties p_colonna22;
    p_colonna22 = new java.util.Properties();
    java.util.Properties p_colonna23;
    p_colonna23 = new java.util.Properties();
    java.util.Properties p_colonna24;
    p_colonna24 = new java.util.Properties();
    java.util.Properties p_colonna25;
    p_colonna25 = new java.util.Properties();
    java.util.Properties p_colonna26;
    p_colonna26 = new java.util.Properties();
    java.util.Properties p_colonna27;
    p_colonna27 = new java.util.Properties();
    java.util.Properties p_colonna28;
    p_colonna28 = new java.util.Properties();
    java.util.Properties p_colonna29;
    p_colonna29 = new java.util.Properties();
    java.util.Properties p_colonna30;
    p_colonna30 = new java.util.Properties();
    java.util.Properties p_colonna31;
    p_colonna31 = new java.util.Properties();
    java.util.Properties p_colonna32;
    p_colonna32 = new java.util.Properties();
    java.util.Properties p_colonna33;
    p_colonna33 = new java.util.Properties();
    java.util.Properties p_colonna34;
    p_colonna34 = new java.util.Properties();
    java.util.Properties p_colonna35;
    p_colonna35 = new java.util.Properties();
    java.util.Properties p_colonna36;
    p_colonna36 = new java.util.Properties();
    java.util.Properties p_colonna37;
    p_colonna37 = new java.util.Properties();
    java.util.Properties p_colonna38;
    p_colonna38 = new java.util.Properties();
    java.util.Properties p_colonna39;
    p_colonna39 = new java.util.Properties();
    java.util.Properties p_colonna40;
    p_colonna40 = new java.util.Properties();
    java.util.Properties p_colonna41;
    p_colonna41 = new java.util.Properties();
    java.util.Properties p_colonna42;
    p_colonna42 = new java.util.Properties();
    java.util.Properties p_colonna43;
    p_colonna43 = new java.util.Properties();
    java.util.Properties p_colonna44;
    p_colonna44 = new java.util.Properties();
    java.util.Properties p_colonna45;
    p_colonna45 = new java.util.Properties();
    java.util.Properties p_colonna46;
    p_colonna46 = new java.util.Properties();
    java.util.Properties p_colonna47;
    p_colonna47 = new java.util.Properties();
    java.util.Properties p_colonna48;
    p_colonna48 = new java.util.Properties();
    java.util.Properties p_colonna49;
    p_colonna49 = new java.util.Properties();
    java.util.Properties p_colonna50;
    p_colonna50 = new java.util.Properties();
    java.util.Properties p_colonna51;
    p_colonna51 = new java.util.Properties();
    java.util.Properties p_colonna52;
    p_colonna52 = new java.util.Properties();
    java.util.Properties p_colonna53;
    p_colonna53 = new java.util.Properties();
    java.util.Properties p_colonna54;
    p_colonna54 = new java.util.Properties();
    java.util.Properties p_colonna55;
    p_colonna55 = new java.util.Properties();
    java.util.Properties p_colonna56;
    p_colonna56 = new java.util.Properties();
    java.util.Properties p_colonna57;
    p_colonna57 = new java.util.Properties();
    java.util.Properties p_colonna58;
    p_colonna58 = new java.util.Properties();
    java.util.Properties p_colonna59;
    p_colonna59 = new java.util.Properties();
    java.util.Properties p_colonna60;
    p_colonna60 = new java.util.Properties();
    java.util.Properties p_colonna61;
    p_colonna61 = new java.util.Properties();
    java.util.Properties p_colonna62;
    p_colonna62 = new java.util.Properties();
    java.util.Properties p_colonna63;
    p_colonna63 = new java.util.Properties();
    java.util.Properties p_colonna64;
    p_colonna64 = new java.util.Properties();
    java.util.Properties p_colonna65;
    p_colonna65 = new java.util.Properties();
    java.util.Properties p_colonna66;
    p_colonna66 = new java.util.Properties();
    java.util.Properties p_colonna67;
    p_colonna67 = new java.util.Properties();
    java.util.Properties p_colonna68;
    p_colonna68 = new java.util.Properties();
    java.util.Properties p_colonna69;
    p_colonna69 = new java.util.Properties();
    java.util.Properties p_colonna70;
    p_colonna70 = new java.util.Properties();
    java.util.Properties p_colonna71;
    p_colonna71 = new java.util.Properties();
    java.util.Properties p_colonna72;
    p_colonna72 = new java.util.Properties();
    java.util.Properties p_colonna73;
    p_colonna73 = new java.util.Properties();
    java.util.Properties p_colonna74;
    p_colonna74 = new java.util.Properties();
    java.util.Properties p_colonna75;
    p_colonna75 = new java.util.Properties();
    java.util.Properties p_colonna76;
    p_colonna76 = new java.util.Properties();
    java.util.Properties p_colonna77;
    p_colonna77 = new java.util.Properties();
    java.util.Properties p_colonna78;
    p_colonna78 = new java.util.Properties();
    java.util.Properties p_colonna79;
    p_colonna79 = new java.util.Properties();
    java.util.Properties p_colonna80;
    p_colonna80 = new java.util.Properties();
    java.util.Properties p_colonna81;
    p_colonna81 = new java.util.Properties();
    java.util.Properties p_colonna82;
    p_colonna82 = new java.util.Properties();
    java.util.Properties p_colonna83;
    p_colonna83 = new java.util.Properties();
    java.util.Properties p_colonna84;
    p_colonna84 = new java.util.Properties();
    java.util.Properties p_colonna85;
    p_colonna85 = new java.util.Properties();
    java.util.Properties p_colonna86;
    p_colonna86 = new java.util.Properties();
    java.util.Properties p_colonna87;
    p_colonna87 = new java.util.Properties();
    java.util.Properties p_colonna88;
    p_colonna88 = new java.util.Properties();
    java.util.Properties p_colonna89;
    p_colonna89 = new java.util.Properties();
    java.util.Properties p_colonna90;
    p_colonna90 = new java.util.Properties();
    java.util.Properties p_colonna91;
    p_colonna91 = new java.util.Properties();
    java.util.Properties p_colonna92;
    p_colonna92 = new java.util.Properties();
    java.util.Properties p_colonna93;
    p_colonna93 = new java.util.Properties();
    java.util.Properties p_colonna94;
    p_colonna94 = new java.util.Properties();
    java.util.Properties p_colonna95;
    p_colonna95 = new java.util.Properties();
    java.util.Properties p_colonna96;
    p_colonna96 = new java.util.Properties();
    java.util.Properties p_colonna97;
    p_colonna97 = new java.util.Properties();
    java.util.Properties p_colonna98;
    p_colonna98 = new java.util.Properties();
    java.util.Properties p_colonna99;
    p_colonna99 = new java.util.Properties();
    java.util.Properties p_colonna100;
    p_colonna100 = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna01".equalsIgnoreCase(key)) {
        p_colonna01 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna02".equalsIgnoreCase(key)) {
        p_colonna02 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna03".equalsIgnoreCase(key)) {
        p_colonna03 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna04".equalsIgnoreCase(key)) {
        p_colonna04 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna05".equalsIgnoreCase(key)) {
        p_colonna05 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna06".equalsIgnoreCase(key)) {
        p_colonna06 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna07".equalsIgnoreCase(key)) {
        p_colonna07 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna08".equalsIgnoreCase(key)) {
        p_colonna08 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna09".equalsIgnoreCase(key)) {
        p_colonna09 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna10".equalsIgnoreCase(key)) {
        p_colonna10 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna11".equalsIgnoreCase(key)) {
        p_colonna11 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna12".equalsIgnoreCase(key)) {
        p_colonna12 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna13".equalsIgnoreCase(key)) {
        p_colonna13 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna14".equalsIgnoreCase(key)) {
        p_colonna14 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna15".equalsIgnoreCase(key)) {
        p_colonna15 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna16".equalsIgnoreCase(key)) {
        p_colonna16 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna17".equalsIgnoreCase(key)) {
        p_colonna17 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna18".equalsIgnoreCase(key)) {
        p_colonna18 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna19".equalsIgnoreCase(key)) {
        p_colonna19 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna20".equalsIgnoreCase(key)) {
        p_colonna20 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna21".equalsIgnoreCase(key)) {
        p_colonna21 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna22".equalsIgnoreCase(key)) {
        p_colonna22 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna23".equalsIgnoreCase(key)) {
        p_colonna23 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna24".equalsIgnoreCase(key)) {
        p_colonna24 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna25".equalsIgnoreCase(key)) {
        p_colonna25 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna26".equalsIgnoreCase(key)) {
        p_colonna26 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna27".equalsIgnoreCase(key)) {
        p_colonna27 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna28".equalsIgnoreCase(key)) {
        p_colonna28 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna29".equalsIgnoreCase(key)) {
        p_colonna29 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna30".equalsIgnoreCase(key)) {
        p_colonna30 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna31".equalsIgnoreCase(key)) {
        p_colonna31 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna32".equalsIgnoreCase(key)) {
        p_colonna32 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna33".equalsIgnoreCase(key)) {
        p_colonna33 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna34".equalsIgnoreCase(key)) {
        p_colonna34 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna35".equalsIgnoreCase(key)) {
        p_colonna35 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna36".equalsIgnoreCase(key)) {
        p_colonna36 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna37".equalsIgnoreCase(key)) {
        p_colonna37 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna38".equalsIgnoreCase(key)) {
        p_colonna38 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna39".equalsIgnoreCase(key)) {
        p_colonna39 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna40".equalsIgnoreCase(key)) {
        p_colonna40 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna41".equalsIgnoreCase(key)) {
        p_colonna41 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna42".equalsIgnoreCase(key)) {
        p_colonna42 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna43".equalsIgnoreCase(key)) {
        p_colonna43 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna44".equalsIgnoreCase(key)) {
        p_colonna44 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna45".equalsIgnoreCase(key)) {
        p_colonna45 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna46".equalsIgnoreCase(key)) {
        p_colonna46 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna47".equalsIgnoreCase(key)) {
        p_colonna47 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna48".equalsIgnoreCase(key)) {
        p_colonna48 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna49".equalsIgnoreCase(key)) {
        p_colonna49 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna50".equalsIgnoreCase(key)) {
        p_colonna50 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna51".equalsIgnoreCase(key)) {
        p_colonna51 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna52".equalsIgnoreCase(key)) {
        p_colonna52 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna53".equalsIgnoreCase(key)) {
        p_colonna53 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna54".equalsIgnoreCase(key)) {
        p_colonna54 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna55".equalsIgnoreCase(key)) {
        p_colonna55 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna56".equalsIgnoreCase(key)) {
        p_colonna56 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna57".equalsIgnoreCase(key)) {
        p_colonna57 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna58".equalsIgnoreCase(key)) {
        p_colonna58 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna59".equalsIgnoreCase(key)) {
        p_colonna59 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna60".equalsIgnoreCase(key)) {
        p_colonna60 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna61".equalsIgnoreCase(key)) {
        p_colonna61 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna62".equalsIgnoreCase(key)) {
        p_colonna62 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna63".equalsIgnoreCase(key)) {
        p_colonna63 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna64".equalsIgnoreCase(key)) {
        p_colonna64 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna65".equalsIgnoreCase(key)) {
        p_colonna65 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna66".equalsIgnoreCase(key)) {
        p_colonna66 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna67".equalsIgnoreCase(key)) {
        p_colonna67 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna68".equalsIgnoreCase(key)) {
        p_colonna68 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna69".equalsIgnoreCase(key)) {
        p_colonna69 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna70".equalsIgnoreCase(key)) {
        p_colonna70 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna71".equalsIgnoreCase(key)) {
        p_colonna71 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna72".equalsIgnoreCase(key)) {
        p_colonna72 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna73".equalsIgnoreCase(key)) {
        p_colonna73 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna74".equalsIgnoreCase(key)) {
        p_colonna74 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna75".equalsIgnoreCase(key)) {
        p_colonna75 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna76".equalsIgnoreCase(key)) {
        p_colonna76 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna77".equalsIgnoreCase(key)) {
        p_colonna77 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna78".equalsIgnoreCase(key)) {
        p_colonna78 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna79".equalsIgnoreCase(key)) {
        p_colonna79 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna80".equalsIgnoreCase(key)) {
        p_colonna80 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna81".equalsIgnoreCase(key)) {
        p_colonna81 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna82".equalsIgnoreCase(key)) {
        p_colonna82 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna83".equalsIgnoreCase(key)) {
        p_colonna83 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna84".equalsIgnoreCase(key)) {
        p_colonna84 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna85".equalsIgnoreCase(key)) {
        p_colonna85 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna86".equalsIgnoreCase(key)) {
        p_colonna86 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna87".equalsIgnoreCase(key)) {
        p_colonna87 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna88".equalsIgnoreCase(key)) {
        p_colonna88 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna89".equalsIgnoreCase(key)) {
        p_colonna89 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna90".equalsIgnoreCase(key)) {
        p_colonna90 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna91".equalsIgnoreCase(key)) {
        p_colonna91 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna92".equalsIgnoreCase(key)) {
        p_colonna92 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna93".equalsIgnoreCase(key)) {
        p_colonna93 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna94".equalsIgnoreCase(key)) {
        p_colonna94 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna95".equalsIgnoreCase(key)) {
        p_colonna95 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna96".equalsIgnoreCase(key)) {
        p_colonna96 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna97".equalsIgnoreCase(key)) {
        p_colonna97 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna98".equalsIgnoreCase(key)) {
        p_colonna98 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna99".equalsIgnoreCase(key)) {
        p_colonna99 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna100".equalsIgnoreCase(key)) {
        p_colonna100 = CPLib.GetProperties(p.getProperty(key));
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
      row.colonna01 = CPLib.GetProperty(p_colonna01,"","",i);
      row.colonna02 = CPLib.GetProperty(p_colonna02,"","",i);
      row.colonna03 = CPLib.GetProperty(p_colonna03,"","",i);
      row.colonna04 = CPLib.GetProperty(p_colonna04,"","",i);
      row.colonna05 = CPLib.GetProperty(p_colonna05,"","",i);
      row.colonna06 = CPLib.GetProperty(p_colonna06,"","",i);
      row.colonna07 = CPLib.GetProperty(p_colonna07,"","",i);
      row.colonna08 = CPLib.GetProperty(p_colonna08,"","",i);
      row.colonna09 = CPLib.GetProperty(p_colonna09,"","",i);
      row.colonna10 = CPLib.GetProperty(p_colonna10,"","",i);
      row.colonna11 = CPLib.GetProperty(p_colonna11,"","",i);
      row.colonna12 = CPLib.GetProperty(p_colonna12,"","",i);
      row.colonna13 = CPLib.GetProperty(p_colonna13,"","",i);
      row.colonna14 = CPLib.GetProperty(p_colonna14,"","",i);
      row.colonna15 = CPLib.GetProperty(p_colonna15,"","",i);
      row.colonna16 = CPLib.GetProperty(p_colonna16,"","",i);
      row.colonna17 = CPLib.GetProperty(p_colonna17,"","",i);
      row.colonna18 = CPLib.GetProperty(p_colonna18,"","",i);
      row.colonna19 = CPLib.GetProperty(p_colonna19,"","",i);
      row.colonna20 = CPLib.GetProperty(p_colonna20,"","",i);
      row.colonna21 = CPLib.GetProperty(p_colonna21,"","",i);
      row.colonna22 = CPLib.GetProperty(p_colonna22,"","",i);
      row.colonna23 = CPLib.GetProperty(p_colonna23,"","",i);
      row.colonna24 = CPLib.GetProperty(p_colonna24,"","",i);
      row.colonna25 = CPLib.GetProperty(p_colonna25,"","",i);
      row.colonna26 = CPLib.GetProperty(p_colonna26,"","",i);
      row.colonna27 = CPLib.GetProperty(p_colonna27,"","",i);
      row.colonna28 = CPLib.GetProperty(p_colonna28,"","",i);
      row.colonna29 = CPLib.GetProperty(p_colonna29,"","",i);
      row.colonna30 = CPLib.GetProperty(p_colonna30,"","",i);
      row.colonna31 = CPLib.GetProperty(p_colonna31,"","",i);
      row.colonna32 = CPLib.GetProperty(p_colonna32,"","",i);
      row.colonna33 = CPLib.GetProperty(p_colonna33,"","",i);
      row.colonna34 = CPLib.GetProperty(p_colonna34,"","",i);
      row.colonna35 = CPLib.GetProperty(p_colonna35,"","",i);
      row.colonna36 = CPLib.GetProperty(p_colonna36,"","",i);
      row.colonna37 = CPLib.GetProperty(p_colonna37,"","",i);
      row.colonna38 = CPLib.GetProperty(p_colonna38,"","",i);
      row.colonna39 = CPLib.GetProperty(p_colonna39,"","",i);
      row.colonna40 = CPLib.GetProperty(p_colonna40,"","",i);
      row.colonna41 = CPLib.GetProperty(p_colonna41,"","",i);
      row.colonna42 = CPLib.GetProperty(p_colonna42,"","",i);
      row.colonna43 = CPLib.GetProperty(p_colonna43,"","",i);
      row.colonna44 = CPLib.GetProperty(p_colonna44,"","",i);
      row.colonna45 = CPLib.GetProperty(p_colonna45,"","",i);
      row.colonna46 = CPLib.GetProperty(p_colonna46,"","",i);
      row.colonna47 = CPLib.GetProperty(p_colonna47,"","",i);
      row.colonna48 = CPLib.GetProperty(p_colonna48,"","",i);
      row.colonna49 = CPLib.GetProperty(p_colonna49,"","",i);
      row.colonna50 = CPLib.GetProperty(p_colonna50,"","",i);
      row.colonna51 = CPLib.GetProperty(p_colonna51,"","",i);
      row.colonna52 = CPLib.GetProperty(p_colonna52,"","",i);
      row.colonna53 = CPLib.GetProperty(p_colonna53,"","",i);
      row.colonna54 = CPLib.GetProperty(p_colonna54,"","",i);
      row.colonna55 = CPLib.GetProperty(p_colonna55,"","",i);
      row.colonna56 = CPLib.GetProperty(p_colonna56,"","",i);
      row.colonna57 = CPLib.GetProperty(p_colonna57,"","",i);
      row.colonna58 = CPLib.GetProperty(p_colonna58,"","",i);
      row.colonna59 = CPLib.GetProperty(p_colonna59,"","",i);
      row.colonna60 = CPLib.GetProperty(p_colonna60,"","",i);
      row.colonna61 = CPLib.GetProperty(p_colonna61,"","",i);
      row.colonna62 = CPLib.GetProperty(p_colonna62,"","",i);
      row.colonna63 = CPLib.GetProperty(p_colonna63,"","",i);
      row.colonna64 = CPLib.GetProperty(p_colonna64,"","",i);
      row.colonna65 = CPLib.GetProperty(p_colonna65,"","",i);
      row.colonna66 = CPLib.GetProperty(p_colonna66,"","",i);
      row.colonna67 = CPLib.GetProperty(p_colonna67,"","",i);
      row.colonna68 = CPLib.GetProperty(p_colonna68,"","",i);
      row.colonna69 = CPLib.GetProperty(p_colonna69,"","",i);
      row.colonna70 = CPLib.GetProperty(p_colonna70,"","",i);
      row.colonna71 = CPLib.GetProperty(p_colonna71,"","",i);
      row.colonna72 = CPLib.GetProperty(p_colonna72,"","",i);
      row.colonna73 = CPLib.GetProperty(p_colonna73,"","",i);
      row.colonna74 = CPLib.GetProperty(p_colonna74,"","",i);
      row.colonna75 = CPLib.GetProperty(p_colonna75,"","",i);
      row.colonna76 = CPLib.GetProperty(p_colonna76,"","",i);
      row.colonna77 = CPLib.GetProperty(p_colonna77,"","",i);
      row.colonna78 = CPLib.GetProperty(p_colonna78,"","",i);
      row.colonna79 = CPLib.GetProperty(p_colonna79,"","",i);
      row.colonna80 = CPLib.GetProperty(p_colonna80,"","",i);
      row.colonna81 = CPLib.GetProperty(p_colonna81,"","",i);
      row.colonna82 = CPLib.GetProperty(p_colonna82,"","",i);
      row.colonna83 = CPLib.GetProperty(p_colonna83,"","",i);
      row.colonna84 = CPLib.GetProperty(p_colonna84,"","",i);
      row.colonna85 = CPLib.GetProperty(p_colonna85,"","",i);
      row.colonna86 = CPLib.GetProperty(p_colonna86,"","",i);
      row.colonna87 = CPLib.GetProperty(p_colonna87,"","",i);
      row.colonna88 = CPLib.GetProperty(p_colonna88,"","",i);
      row.colonna89 = CPLib.GetProperty(p_colonna89,"","",i);
      row.colonna90 = CPLib.GetProperty(p_colonna90,"","",i);
      row.colonna91 = CPLib.GetProperty(p_colonna91,"","",i);
      row.colonna92 = CPLib.GetProperty(p_colonna92,"","",i);
      row.colonna93 = CPLib.GetProperty(p_colonna93,"","",i);
      row.colonna94 = CPLib.GetProperty(p_colonna94,"","",i);
      row.colonna95 = CPLib.GetProperty(p_colonna95,"","",i);
      row.colonna96 = CPLib.GetProperty(p_colonna96,"","",i);
      row.colonna97 = CPLib.GetProperty(p_colonna97,"","",i);
      row.colonna98 = CPLib.GetProperty(p_colonna98,"","",i);
      row.colonna99 = CPLib.GetProperty(p_colonna99,"","",i);
      row.colonna100 = CPLib.GetProperty(p_colonna100,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcerratedef_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcerratedef_mcrdef();
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
  public MemoryCursorRow_mcerratedef_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcerratedef_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcerratedef_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcerratedef_mcrdef p_Row) {
    MemoryCursorRow_mcerratedef_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerratedef_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcerratedef_mcrdef p_Row) {
    MemoryCursorRow_mcerratedef_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerratedef_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcerratedef_mcrdef p_Row) {
    MemoryCursorRow_mcerratedef_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerratedef_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcerratedef_mcrdef p_Row) {
    MemoryCursorRow_mcerratedef_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerratedef_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcerratedef_mcrdef p_Row) {
    MemoryCursorRow_mcerratedef_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerratedef_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcerratedef_mcrdef p_Row) {
    MemoryCursorRow_mcerratedef_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerratedef_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcerratedef_mcrdef p_Row) {
    MemoryCursorRow_mcerratedef_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerratedef_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcerratedef_mcrdef p_Row) {
    MemoryCursorRow_mcerratedef_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerratedef_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcerratedef_mcrdef p_Row) {
    MemoryCursorRow_mcerratedef_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerratedef_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcerratedef_mcrdef p_Row) {
    MemoryCursorRow_mcerratedef_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerratedef_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcerratedef_mcrdef p_Row) {
    MemoryCursorRow_mcerratedef_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerratedef_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcerratedef_mcrdef p_Row) {
    MemoryCursorRow_mcerratedef_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerratedef_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcerratedef_mcrdef p_Row) {
    MemoryCursorRow_mcerratedef_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerratedef_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcerratedef_mcrdef p_Row) {
    MemoryCursorRow_mcerratedef_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerratedef_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcerratedef_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcerratedef_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
