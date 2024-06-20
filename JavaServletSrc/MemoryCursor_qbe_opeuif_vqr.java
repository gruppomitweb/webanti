// Definition generated from query qbe_opeuif_vqr
public class MemoryCursor_qbe_opeuif_vqr extends CPMemoryCursor {
  MemoryCursorRow_qbe_opeuif_vqr row;
  MemoryCursorRow_qbe_opeuif_vqr empty_row;
  public MemoryCursor_qbe_opeuif_vqr() {
    empty_row = new MemoryCursorRow_qbe_opeuif_vqr();
    row = empty_row;
  }
  public MemoryCursor_qbe_opeuif_vqr(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_IDBASE;
    p_IDBASE = new java.util.Properties();
    java.util.Properties p_NUMPROG;
    p_NUMPROG = new java.util.Properties();
    java.util.Properties p_DATAOPE;
    p_DATAOPE = new java.util.Properties();
    java.util.Properties p_TIPOINTER;
    p_TIPOINTER = new java.util.Properties();
    java.util.Properties p_CODINTER;
    p_CODINTER = new java.util.Properties();
    java.util.Properties p_TIPOINF;
    p_TIPOINF = new java.util.Properties();
    java.util.Properties p_IDEREG;
    p_IDEREG = new java.util.Properties();
    java.util.Properties p_DESCCIT;
    p_DESCCIT = new java.util.Properties();
    java.util.Properties p_CODDIPE;
    p_CODDIPE = new java.util.Properties();
    java.util.Properties p_PROVINCIA;
    p_PROVINCIA = new java.util.Properties();
    java.util.Properties p_CODCAB;
    p_CODCAB = new java.util.Properties();
    java.util.Properties p_FLAGFRAZ;
    p_FLAGFRAZ = new java.util.Properties();
    java.util.Properties p_FLAGCONT;
    p_FLAGCONT = new java.util.Properties();
    java.util.Properties p_CODANA;
    p_CODANA = new java.util.Properties();
    java.util.Properties p_CODVOC;
    p_CODVOC = new java.util.Properties();
    java.util.Properties p_TIPOINT2;
    p_TIPOINT2 = new java.util.Properties();
    java.util.Properties p_CODINT2;
    p_CODINT2 = new java.util.Properties();
    java.util.Properties p_PAESE;
    p_PAESE = new java.util.Properties();
    java.util.Properties p_DESC2;
    p_DESC2 = new java.util.Properties();
    java.util.Properties p_PROV2;
    p_PROV2 = new java.util.Properties();
    java.util.Properties p_CODCAB2;
    p_CODCAB2 = new java.util.Properties();
    java.util.Properties p_DESCINTER;
    p_DESCINTER = new java.util.Properties();
    java.util.Properties p_RAPPORTO;
    p_RAPPORTO = new java.util.Properties();
    java.util.Properties p_FLAGRAP;
    p_FLAGRAP = new java.util.Properties();
    java.util.Properties p_TIPOLEG;
    p_TIPOLEG = new java.util.Properties();
    java.util.Properties p_DATAREG;
    p_DATAREG = new java.util.Properties();
    java.util.Properties p_OPRAP;
    p_OPRAP = new java.util.Properties();
    java.util.Properties p_TIPOOPRAP;
    p_TIPOOPRAP = new java.util.Properties();
    java.util.Properties p_FLAGLIRE;
    p_FLAGLIRE = new java.util.Properties();
    java.util.Properties p_VALUTA;
    p_VALUTA = new java.util.Properties();
    java.util.Properties p_SEGNO;
    p_SEGNO = new java.util.Properties();
    java.util.Properties p_TOTLIRE;
    p_TOTLIRE = new java.util.Properties();
    java.util.Properties p_TOTCONT;
    p_TOTCONT = new java.util.Properties();
    java.util.Properties p_STATOREG;
    p_STATOREG = new java.util.Properties();
    java.util.Properties p_OPERAZMOD;
    p_OPERAZMOD = new java.util.Properties();
    java.util.Properties p_DATARETT;
    p_DATARETT = new java.util.Properties();
    java.util.Properties p_CONNESCLI;
    p_CONNESCLI = new java.util.Properties();
    java.util.Properties p_CONNESOPER;
    p_CONNESOPER = new java.util.Properties();
    java.util.Properties p_CONNESBEN;
    p_CONNESBEN = new java.util.Properties();
    java.util.Properties p_COLLEG;
    p_COLLEG = new java.util.Properties();
    java.util.Properties p_CAMBIO;
    p_CAMBIO = new java.util.Properties();
    java.util.Properties p_RAPPORTBEN;
    p_RAPPORTBEN = new java.util.Properties();
    java.util.Properties p_FLAGRAP2;
    p_FLAGRAP2 = new java.util.Properties();
    java.util.Properties p_OPERATORE;
    p_OPERATORE = new java.util.Properties();
    java.util.Properties p_AUTOM;
    p_AUTOM = new java.util.Properties();
    java.util.Properties p_idcauana;
    p_idcauana = new java.util.Properties();
    java.util.Properties p_OPERAG;
    p_OPERAG = new java.util.Properties();
    java.util.Properties p_DOCFILE;
    p_DOCFILE = new java.util.Properties();
    java.util.Properties p_RESPINS;
    p_RESPINS = new java.util.Properties();
    java.util.Properties p_INFORM;
    p_INFORM = new java.util.Properties();
    java.util.Properties p_CDATOPE;
    p_CDATOPE = new java.util.Properties();
    java.util.Properties p_NOPROT;
    p_NOPROT = new java.util.Properties();
    java.util.Properties p_UCODE;
    p_UCODE = new java.util.Properties();
    java.util.Properties p_CDATAOPE;
    p_CDATAOPE = new java.util.Properties();
    java.util.Properties p_ZCPARTE;
    p_ZCPARTE = new java.util.Properties();
    java.util.Properties p_RAGIO;
    p_RAGIO = new java.util.Properties();
    java.util.Properties p_MODSVOL;
    p_MODSVOL = new java.util.Properties();
    java.util.Properties p_AREAGEO;
    p_AREAGEO = new java.util.Properties();
    java.util.Properties p_C_CAB;
    p_C_CAB = new java.util.Properties();
    java.util.Properties p_C_STA;
    p_C_STA = new java.util.Properties();
    java.util.Properties p_RIFIMP;
    p_RIFIMP = new java.util.Properties();
    java.util.Properties p_PROQUOTA;
    p_PROQUOTA = new java.util.Properties();
    java.util.Properties p_IMPSARA;
    p_IMPSARA = new java.util.Properties();
    java.util.Properties p_CONNES;
    p_CONNES = new java.util.Properties();
    java.util.Properties p_RAGSOC;
    p_RAGSOC = new java.util.Properties();
    java.util.Properties p_CODFISC;
    p_CODFISC = new java.util.Properties();
    java.util.Properties p_PAESECLI;
    p_PAESECLI = new java.util.Properties();
    java.util.Properties p_CABCLI;
    p_CABCLI = new java.util.Properties();
    java.util.Properties p_DESCCITCLI;
    p_DESCCITCLI = new java.util.Properties();
    java.util.Properties p_SETTSINT;
    p_SETTSINT = new java.util.Properties();
    java.util.Properties p_SOTGRUP;
    p_SOTGRUP = new java.util.Properties();
    java.util.Properties p_SESSO;
    p_SESSO = new java.util.Properties();
    java.util.Properties p_NOSARA;
    p_NOSARA = new java.util.Properties();
    java.util.Properties p_CABDIP;
    p_CABDIP = new java.util.Properties();
    java.util.Properties p_ABICABSARA;
    p_ABICABSARA = new java.util.Properties();
    java.util.Properties p_CODDIP;
    p_CODDIP = new java.util.Properties();
    java.util.Properties p_DESCRIZ;
    p_DESCRIZ = new java.util.Properties();
    java.util.Properties p_DESCCITD;
    p_DESCCITD = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDBASE".equalsIgnoreCase(key)) {
        p_IDBASE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMPROG".equalsIgnoreCase(key)) {
        p_NUMPROG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAOPE".equalsIgnoreCase(key)) {
        p_DATAOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOINTER".equalsIgnoreCase(key)) {
        p_TIPOINTER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODINTER".equalsIgnoreCase(key)) {
        p_CODINTER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOINF".equalsIgnoreCase(key)) {
        p_TIPOINF = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDEREG".equalsIgnoreCase(key)) {
        p_IDEREG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCCIT".equalsIgnoreCase(key)) {
        p_DESCCIT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODDIPE".equalsIgnoreCase(key)) {
        p_CODDIPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROVINCIA".equalsIgnoreCase(key)) {
        p_PROVINCIA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODCAB".equalsIgnoreCase(key)) {
        p_CODCAB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLAGFRAZ".equalsIgnoreCase(key)) {
        p_FLAGFRAZ = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLAGCONT".equalsIgnoreCase(key)) {
        p_FLAGCONT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODANA".equalsIgnoreCase(key)) {
        p_CODANA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODVOC".equalsIgnoreCase(key)) {
        p_CODVOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOINT2".equalsIgnoreCase(key)) {
        p_TIPOINT2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODINT2".equalsIgnoreCase(key)) {
        p_CODINT2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESE".equalsIgnoreCase(key)) {
        p_PAESE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESC2".equalsIgnoreCase(key)) {
        p_DESC2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROV2".equalsIgnoreCase(key)) {
        p_PROV2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODCAB2".equalsIgnoreCase(key)) {
        p_CODCAB2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCINTER".equalsIgnoreCase(key)) {
        p_DESCINTER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAPPORTO".equalsIgnoreCase(key)) {
        p_RAPPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLAGRAP".equalsIgnoreCase(key)) {
        p_FLAGRAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOLEG".equalsIgnoreCase(key)) {
        p_TIPOLEG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAREG".equalsIgnoreCase(key)) {
        p_DATAREG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("OPRAP".equalsIgnoreCase(key)) {
        p_OPRAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOOPRAP".equalsIgnoreCase(key)) {
        p_TIPOOPRAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLAGLIRE".equalsIgnoreCase(key)) {
        p_FLAGLIRE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VALUTA".equalsIgnoreCase(key)) {
        p_VALUTA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SEGNO".equalsIgnoreCase(key)) {
        p_SEGNO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TOTLIRE".equalsIgnoreCase(key)) {
        p_TOTLIRE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TOTCONT".equalsIgnoreCase(key)) {
        p_TOTCONT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("STATOREG".equalsIgnoreCase(key)) {
        p_STATOREG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("OPERAZMOD".equalsIgnoreCase(key)) {
        p_OPERAZMOD = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATARETT".equalsIgnoreCase(key)) {
        p_DATARETT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNESCLI".equalsIgnoreCase(key)) {
        p_CONNESCLI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNESOPER".equalsIgnoreCase(key)) {
        p_CONNESOPER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNESBEN".equalsIgnoreCase(key)) {
        p_CONNESBEN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COLLEG".equalsIgnoreCase(key)) {
        p_COLLEG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAMBIO".equalsIgnoreCase(key)) {
        p_CAMBIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAPPORTBEN".equalsIgnoreCase(key)) {
        p_RAPPORTBEN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLAGRAP2".equalsIgnoreCase(key)) {
        p_FLAGRAP2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("OPERATORE".equalsIgnoreCase(key)) {
        p_OPERATORE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AUTOM".equalsIgnoreCase(key)) {
        p_AUTOM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("idcauana".equalsIgnoreCase(key)) {
        p_idcauana = CPLib.GetProperties(p.getProperty(key));
      }
      if ("OPERAG".equalsIgnoreCase(key)) {
        p_OPERAG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DOCFILE".equalsIgnoreCase(key)) {
        p_DOCFILE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RESPINS".equalsIgnoreCase(key)) {
        p_RESPINS = CPLib.GetProperties(p.getProperty(key));
      }
      if ("INFORM".equalsIgnoreCase(key)) {
        p_INFORM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CDATOPE".equalsIgnoreCase(key)) {
        p_CDATOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOPROT".equalsIgnoreCase(key)) {
        p_NOPROT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("UCODE".equalsIgnoreCase(key)) {
        p_UCODE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CDATAOPE".equalsIgnoreCase(key)) {
        p_CDATAOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ZCPARTE".equalsIgnoreCase(key)) {
        p_ZCPARTE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAGIO".equalsIgnoreCase(key)) {
        p_RAGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MODSVOL".equalsIgnoreCase(key)) {
        p_MODSVOL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AREAGEO".equalsIgnoreCase(key)) {
        p_AREAGEO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("C_CAB".equalsIgnoreCase(key)) {
        p_C_CAB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("C_STA".equalsIgnoreCase(key)) {
        p_C_STA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RIFIMP".equalsIgnoreCase(key)) {
        p_RIFIMP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROQUOTA".equalsIgnoreCase(key)) {
        p_PROQUOTA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMPSARA".equalsIgnoreCase(key)) {
        p_IMPSARA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNES".equalsIgnoreCase(key)) {
        p_CONNES = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAGSOC".equalsIgnoreCase(key)) {
        p_RAGSOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODFISC".equalsIgnoreCase(key)) {
        p_CODFISC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESECLI".equalsIgnoreCase(key)) {
        p_PAESECLI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CABCLI".equalsIgnoreCase(key)) {
        p_CABCLI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCCITCLI".equalsIgnoreCase(key)) {
        p_DESCCITCLI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SETTSINT".equalsIgnoreCase(key)) {
        p_SETTSINT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SOTGRUP".equalsIgnoreCase(key)) {
        p_SOTGRUP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SESSO".equalsIgnoreCase(key)) {
        p_SESSO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOSARA".equalsIgnoreCase(key)) {
        p_NOSARA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CABDIP".equalsIgnoreCase(key)) {
        p_CABDIP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ABICABSARA".equalsIgnoreCase(key)) {
        p_ABICABSARA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODDIP".equalsIgnoreCase(key)) {
        p_CODDIP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCRIZ".equalsIgnoreCase(key)) {
        p_DESCRIZ = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCCITD".equalsIgnoreCase(key)) {
        p_DESCCITD = CPLib.GetProperties(p.getProperty(key));
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
      row.IDBASE = CPLib.GetProperty(p_IDBASE,"","",i);
      row.NUMPROG = CPLib.GetProperty(p_NUMPROG,"","",i);
      row.DATAOPE = CPLib.GetProperty(p_DATAOPE,"",CPLib.NullDate(),i);
      row.TIPOINTER = CPLib.GetProperty(p_TIPOINTER,"","",i);
      row.CODINTER = CPLib.GetProperty(p_CODINTER,"","",i);
      row.TIPOINF = CPLib.GetProperty(p_TIPOINF,"","",i);
      row.IDEREG = CPLib.GetProperty(p_IDEREG,"","",i);
      row.DESCCIT = CPLib.GetProperty(p_DESCCIT,"","",i);
      row.CODDIPE = CPLib.GetProperty(p_CODDIPE,"","",i);
      row.PROVINCIA = CPLib.GetProperty(p_PROVINCIA,"","",i);
      row.CODCAB = CPLib.GetProperty(p_CODCAB,"","",i);
      row.FLAGFRAZ = CPLib.GetProperty(p_FLAGFRAZ,"","",i);
      row.FLAGCONT = CPLib.GetProperty(p_FLAGCONT,"","",i);
      row.CODANA = CPLib.GetProperty(p_CODANA,"","",i);
      row.CODVOC = CPLib.GetProperty(p_CODVOC,"","",i);
      row.TIPOINT2 = CPLib.GetProperty(p_TIPOINT2,"","",i);
      row.CODINT2 = CPLib.GetProperty(p_CODINT2,"","",i);
      row.PAESE = CPLib.GetProperty(p_PAESE,"","",i);
      row.DESC2 = CPLib.GetProperty(p_DESC2,"","",i);
      row.PROV2 = CPLib.GetProperty(p_PROV2,"","",i);
      row.CODCAB2 = CPLib.GetProperty(p_CODCAB2,"","",i);
      row.DESCINTER = CPLib.GetProperty(p_DESCINTER,"","",i);
      row.RAPPORTO = CPLib.GetProperty(p_RAPPORTO,"","",i);
      row.FLAGRAP = CPLib.GetProperty(p_FLAGRAP,"","",i);
      row.TIPOLEG = CPLib.GetProperty(p_TIPOLEG,"","",i);
      row.DATAREG = CPLib.GetProperty(p_DATAREG,"",CPLib.NullDate(),i);
      row.OPRAP = CPLib.GetProperty(p_OPRAP,"","",i);
      row.TIPOOPRAP = CPLib.GetProperty(p_TIPOOPRAP,"","",i);
      row.FLAGLIRE = CPLib.GetProperty(p_FLAGLIRE,"","",i);
      row.VALUTA = CPLib.GetProperty(p_VALUTA,"","",i);
      row.SEGNO = CPLib.GetProperty(p_SEGNO,"","",i);
      row.TOTLIRE = CPLib.GetProperty(p_TOTLIRE,"",0,i);
      row.TOTCONT = CPLib.GetProperty(p_TOTCONT,"",0,i);
      row.STATOREG = CPLib.GetProperty(p_STATOREG,"","",i);
      row.OPERAZMOD = CPLib.GetProperty(p_OPERAZMOD,"","",i);
      row.DATARETT = CPLib.GetProperty(p_DATARETT,"",CPLib.NullDate(),i);
      row.CONNESCLI = CPLib.GetProperty(p_CONNESCLI,"","",i);
      row.CONNESOPER = CPLib.GetProperty(p_CONNESOPER,"","",i);
      row.CONNESBEN = CPLib.GetProperty(p_CONNESBEN,"","",i);
      row.COLLEG = CPLib.GetProperty(p_COLLEG,"","",i);
      row.CAMBIO = CPLib.GetProperty(p_CAMBIO,"",0,i);
      row.RAPPORTBEN = CPLib.GetProperty(p_RAPPORTBEN,"","",i);
      row.FLAGRAP2 = CPLib.GetProperty(p_FLAGRAP2,"","",i);
      row.OPERATORE = CPLib.GetProperty(p_OPERATORE,"","",i);
      row.AUTOM = CPLib.GetProperty(p_AUTOM,"","",i);
      row.idcauana = CPLib.GetProperty(p_idcauana,"","",i);
      row.OPERAG = CPLib.GetProperty(p_OPERAG,"","",i);
      row.DOCFILE = CPLib.GetProperty(p_DOCFILE,"","",i);
      row.RESPINS = CPLib.GetProperty(p_RESPINS,"","",i);
      row.INFORM = CPLib.GetProperty(p_INFORM,"","",i);
      row.CDATOPE = CPLib.GetProperty(p_CDATOPE,"","",i);
      row.NOPROT = CPLib.GetProperty(p_NOPROT,"",0,i);
      row.UCODE = CPLib.GetProperty(p_UCODE,"","",i);
      row.CDATAOPE = CPLib.GetProperty(p_CDATAOPE,"","",i);
      row.ZCPARTE = CPLib.GetProperty(p_ZCPARTE,"","",i);
      row.RAGIO = CPLib.GetProperty(p_RAGIO,"","",i);
      row.MODSVOL = CPLib.GetProperty(p_MODSVOL,"","",i);
      row.AREAGEO = CPLib.GetProperty(p_AREAGEO,"","",i);
      row.C_CAB = CPLib.GetProperty(p_C_CAB,"","",i);
      row.C_STA = CPLib.GetProperty(p_C_STA,"","",i);
      row.RIFIMP = CPLib.GetProperty(p_RIFIMP,"","",i);
      row.PROQUOTA = CPLib.GetProperty(p_PROQUOTA,"",0,i);
      row.IMPSARA = CPLib.GetProperty(p_IMPSARA,"",0,i);
      row.CONNES = CPLib.GetProperty(p_CONNES,"","",i);
      row.RAGSOC = CPLib.GetProperty(p_RAGSOC,"","",i);
      row.CODFISC = CPLib.GetProperty(p_CODFISC,"","",i);
      row.PAESECLI = CPLib.GetProperty(p_PAESECLI,"","",i);
      row.CABCLI = CPLib.GetProperty(p_CABCLI,"","",i);
      row.DESCCITCLI = CPLib.GetProperty(p_DESCCITCLI,"","",i);
      row.SETTSINT = CPLib.GetProperty(p_SETTSINT,"","",i);
      row.SOTGRUP = CPLib.GetProperty(p_SOTGRUP,"","",i);
      row.SESSO = CPLib.GetProperty(p_SESSO,"","",i);
      row.NOSARA = CPLib.GetProperty(p_NOSARA,"","",i);
      row.CABDIP = CPLib.GetProperty(p_CABDIP,"","",i);
      row.ABICABSARA = CPLib.GetProperty(p_ABICABSARA,"","",i);
      row.CODDIP = CPLib.GetProperty(p_CODDIP,"","",i);
      row.DESCRIZ = CPLib.GetProperty(p_DESCRIZ,"","",i);
      row.DESCCITD = CPLib.GetProperty(p_DESCCITD,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_qbe_opeuif_vqr)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_qbe_opeuif_vqr();
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
  public MemoryCursorRow_qbe_opeuif_vqr _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_qbe_opeuif_vqr _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_qbe_opeuif_vqr> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_qbe_opeuif_vqr p_Row) {
    MemoryCursorRow_qbe_opeuif_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_opeuif_vqr();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_qbe_opeuif_vqr p_Row) {
    MemoryCursorRow_qbe_opeuif_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_opeuif_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_qbe_opeuif_vqr p_Row) {
    MemoryCursorRow_qbe_opeuif_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_opeuif_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_qbe_opeuif_vqr p_Row) {
    MemoryCursorRow_qbe_opeuif_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_opeuif_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_qbe_opeuif_vqr p_Row) {
    MemoryCursorRow_qbe_opeuif_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_opeuif_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_qbe_opeuif_vqr p_Row) {
    MemoryCursorRow_qbe_opeuif_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_opeuif_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_qbe_opeuif_vqr p_Row) {
    MemoryCursorRow_qbe_opeuif_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_opeuif_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_qbe_opeuif_vqr p_Row) {
    MemoryCursorRow_qbe_opeuif_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_opeuif_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_qbe_opeuif_vqr p_Row) {
    MemoryCursorRow_qbe_opeuif_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_opeuif_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_qbe_opeuif_vqr p_Row) {
    MemoryCursorRow_qbe_opeuif_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_opeuif_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_qbe_opeuif_vqr p_Row) {
    MemoryCursorRow_qbe_opeuif_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_opeuif_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_qbe_opeuif_vqr p_Row) {
    MemoryCursorRow_qbe_opeuif_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_opeuif_vqr();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_qbe_opeuif_vqr p_Row) {
    MemoryCursorRow_qbe_opeuif_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_opeuif_vqr();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_qbe_opeuif_vqr p_Row) {
    MemoryCursorRow_qbe_opeuif_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_opeuif_vqr();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_qbe_opeuif_vqr p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_qbe_opeuif_vqr();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
