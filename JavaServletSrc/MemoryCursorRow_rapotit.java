public class MemoryCursorRow_rapotit extends CPMemoryCursorRow {
  public MemoryCursorRow_rapotit() {
  }
  public MemoryCursorRow_rapotit(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_rapotit toBuild = new MemoryCursor_rapotit(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_rapotit toBuild = new MemoryCursor_rapotit();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String IDBASE = "";
  java.sql.Date DATAOPE = CPLib.NullDate();
  String NUMPROG = "";
  String TIPOINTER = "";
  String CODINTER = "";
  String TIPOINF = "";
  String IDEREG = "";
  String CODDIPE = "";
  String DESCCIT = "";
  String PROVINCIA = "";
  String CODCAB = "";
  String FLAGFRAZ = "";
  String FLAGCONT = "";
  String CODANA = "";
  String CODVOC = "";
  String TIPOINT2 = "";
  String CODINT2 = "";
  String PAESE = "";
  String DESC2 = "";
  String PROV2 = "";
  String CODCAB2 = "";
  String DESCINTER = "";
  String RAPPORTO = "";
  String FLAGRAP = "";
  String TIPOLEG = "";
  java.sql.Date DATAREG = CPLib.NullDate();
  String OPRAP = "";
  String TIPOOPRAP = "";
  String FLAGLIRE = "";
  String VALUTA = "";
  String SEGNO = "";
  double TOTLIRE = 0;
  double TOTCONT = 0;
  String STATOREG = "";
  String OPERAZMOD = "";
  java.sql.Date DATARETT = CPLib.NullDate();
  String CONNESCLI = "";
  String CONNESOPER = "";
  String CONNESBEN = "";
  String COLLEG = "";
  double CAMBIO = 0;
  String RAPPORTBEN = "";
  String FLAGRAP2 = "";
  String OPERATORE = "";
  String AUTOM = "";
  String RESPINS = "";
  String INFORM = "";
  java.sql.Date DATAAGE = CPLib.NullDate();
  String UCODE = "";
  double PRGIMPTIT = 0;
  String CDATOPE = "";
  String UNIQUECODE = "";
  String CDATREG = "";
  String IDBASE2 = "";
  java.sql.Timestamp NUMIMP = CPLib.NullDateTime();
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOINF))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDEREG))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODDIPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCCIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVINCIA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGFRAZ))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGCONT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODANA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODVOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOINT2))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODINT2))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESC2))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROV2))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCAB2))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGRAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOLEG))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAREG))) {
      return false;
    }
    if ( ! (CPLib.Empty(OPRAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOOPRAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGLIRE))) {
      return false;
    }
    if ( ! (CPLib.Empty(VALUTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(SEGNO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTLIRE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTCONT))) {
      return false;
    }
    if ( ! (CPLib.Empty(STATOREG))) {
      return false;
    }
    if ( ! (CPLib.Empty(OPERAZMOD))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATARETT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESCLI))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESOPER))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESBEN))) {
      return false;
    }
    if ( ! (CPLib.Empty(COLLEG))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAMBIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPPORTBEN))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGRAP2))) {
      return false;
    }
    if ( ! (CPLib.Empty(OPERATORE))) {
      return false;
    }
    if ( ! (CPLib.Empty(AUTOM))) {
      return false;
    }
    if ( ! (CPLib.Empty(RESPINS))) {
      return false;
    }
    if ( ! (CPLib.Empty(INFORM))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAAGE))) {
      return false;
    }
    if ( ! (CPLib.Empty(UCODE))) {
      return false;
    }
    if ( ! (CPLib.Empty(PRGIMPTIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CDATOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(UNIQUECODE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CDATREG))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDBASE2))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMIMP))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_rapotit p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_rapotit.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_rapotit.this.DATAOPE = copyAndCast(p_row.DATAOPE);
      MemoryCursorRow_rapotit.this.NUMPROG = copyAndCast(p_row.NUMPROG);
      MemoryCursorRow_rapotit.this.TIPOINTER = copyAndCast(p_row.TIPOINTER);
      MemoryCursorRow_rapotit.this.CODINTER = copyAndCast(p_row.CODINTER);
      MemoryCursorRow_rapotit.this.TIPOINF = copyAndCast(p_row.TIPOINF);
      MemoryCursorRow_rapotit.this.IDEREG = copyAndCast(p_row.IDEREG);
      MemoryCursorRow_rapotit.this.CODDIPE = copyAndCast(p_row.CODDIPE);
      MemoryCursorRow_rapotit.this.DESCCIT = copyAndCast(p_row.DESCCIT);
      MemoryCursorRow_rapotit.this.PROVINCIA = copyAndCast(p_row.PROVINCIA);
      MemoryCursorRow_rapotit.this.CODCAB = copyAndCast(p_row.CODCAB);
      MemoryCursorRow_rapotit.this.FLAGFRAZ = copyAndCast(p_row.FLAGFRAZ);
      MemoryCursorRow_rapotit.this.FLAGCONT = copyAndCast(p_row.FLAGCONT);
      MemoryCursorRow_rapotit.this.CODANA = copyAndCast(p_row.CODANA);
      MemoryCursorRow_rapotit.this.CODVOC = copyAndCast(p_row.CODVOC);
      MemoryCursorRow_rapotit.this.TIPOINT2 = copyAndCast(p_row.TIPOINT2);
      MemoryCursorRow_rapotit.this.CODINT2 = copyAndCast(p_row.CODINT2);
      MemoryCursorRow_rapotit.this.PAESE = copyAndCast(p_row.PAESE);
      MemoryCursorRow_rapotit.this.DESC2 = copyAndCast(p_row.DESC2);
      MemoryCursorRow_rapotit.this.PROV2 = copyAndCast(p_row.PROV2);
      MemoryCursorRow_rapotit.this.CODCAB2 = copyAndCast(p_row.CODCAB2);
      MemoryCursorRow_rapotit.this.DESCINTER = copyAndCast(p_row.DESCINTER);
      MemoryCursorRow_rapotit.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_rapotit.this.FLAGRAP = copyAndCast(p_row.FLAGRAP);
      MemoryCursorRow_rapotit.this.TIPOLEG = copyAndCast(p_row.TIPOLEG);
      MemoryCursorRow_rapotit.this.DATAREG = copyAndCast(p_row.DATAREG);
      MemoryCursorRow_rapotit.this.OPRAP = copyAndCast(p_row.OPRAP);
      MemoryCursorRow_rapotit.this.TIPOOPRAP = copyAndCast(p_row.TIPOOPRAP);
      MemoryCursorRow_rapotit.this.FLAGLIRE = copyAndCast(p_row.FLAGLIRE);
      MemoryCursorRow_rapotit.this.VALUTA = copyAndCast(p_row.VALUTA);
      MemoryCursorRow_rapotit.this.SEGNO = copyAndCast(p_row.SEGNO);
      MemoryCursorRow_rapotit.this.TOTLIRE = copyAndCast(p_row.TOTLIRE);
      MemoryCursorRow_rapotit.this.TOTCONT = copyAndCast(p_row.TOTCONT);
      MemoryCursorRow_rapotit.this.STATOREG = copyAndCast(p_row.STATOREG);
      MemoryCursorRow_rapotit.this.OPERAZMOD = copyAndCast(p_row.OPERAZMOD);
      MemoryCursorRow_rapotit.this.DATARETT = copyAndCast(p_row.DATARETT);
      MemoryCursorRow_rapotit.this.CONNESCLI = copyAndCast(p_row.CONNESCLI);
      MemoryCursorRow_rapotit.this.CONNESOPER = copyAndCast(p_row.CONNESOPER);
      MemoryCursorRow_rapotit.this.CONNESBEN = copyAndCast(p_row.CONNESBEN);
      MemoryCursorRow_rapotit.this.COLLEG = copyAndCast(p_row.COLLEG);
      MemoryCursorRow_rapotit.this.CAMBIO = copyAndCast(p_row.CAMBIO);
      MemoryCursorRow_rapotit.this.RAPPORTBEN = copyAndCast(p_row.RAPPORTBEN);
      MemoryCursorRow_rapotit.this.FLAGRAP2 = copyAndCast(p_row.FLAGRAP2);
      MemoryCursorRow_rapotit.this.OPERATORE = copyAndCast(p_row.OPERATORE);
      MemoryCursorRow_rapotit.this.AUTOM = copyAndCast(p_row.AUTOM);
      MemoryCursorRow_rapotit.this.RESPINS = copyAndCast(p_row.RESPINS);
      MemoryCursorRow_rapotit.this.INFORM = copyAndCast(p_row.INFORM);
      MemoryCursorRow_rapotit.this.DATAAGE = copyAndCast(p_row.DATAAGE);
      MemoryCursorRow_rapotit.this.UCODE = copyAndCast(p_row.UCODE);
      MemoryCursorRow_rapotit.this.PRGIMPTIT = copyAndCast(p_row.PRGIMPTIT);
      MemoryCursorRow_rapotit.this.CDATOPE = copyAndCast(p_row.CDATOPE);
      MemoryCursorRow_rapotit.this.UNIQUECODE = copyAndCast(p_row.UNIQUECODE);
      MemoryCursorRow_rapotit.this.CDATREG = copyAndCast(p_row.CDATREG);
      MemoryCursorRow_rapotit.this.IDBASE2 = copyAndCast(p_row.IDBASE2);
      MemoryCursorRow_rapotit.this.NUMIMP = copyAndCast(p_row.NUMIMP);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"IDBASE","DATAOPE","NUMPROG","TIPOINTER","CODINTER","TIPOINF","IDEREG","CODDIPE","DESCCIT","PROVINCIA","CODCAB","FLAGFRAZ","FLAGCONT","CODANA","CODVOC","TIPOINT2","CODINT2","PAESE","DESC2","PROV2","CODCAB2","DESCINTER","RAPPORTO","FLAGRAP","TIPOLEG","DATAREG","OPRAP","TIPOOPRAP","FLAGLIRE","VALUTA","SEGNO","TOTLIRE","TOTCONT","STATOREG","OPERAZMOD","DATARETT","CONNESCLI","CONNESOPER","CONNESBEN","COLLEG","CAMBIO","RAPPORTBEN","FLAGRAP2","OPERATORE","AUTOM","RESPINS","INFORM","DATAAGE","UCODE","PRGIMPTIT","CDATOPE","UNIQUECODE","CDATREG","IDBASE2","NUMIMP"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","D","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","D","C","C","C","C","C","N","N","C","C","D","C","C","C","C","N","C","C","C","C","C","C","D","C","N","C","C","C","C","T"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","Progressivo Import","Data Operazione (Letterale)","Codice Univoco","Data Registrazione (Letterale)","Gestione IDEREG","Mark Importazione"};
    return l_names;
  }
}
