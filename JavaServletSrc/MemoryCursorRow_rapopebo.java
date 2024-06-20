public class MemoryCursorRow_rapopebo extends CPMemoryCursorRow {
  public MemoryCursorRow_rapopebo() {
  }
  public MemoryCursorRow_rapopebo(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_rapopebo toBuild = new MemoryCursor_rapopebo(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_rapopebo toBuild = new MemoryCursor_rapopebo();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String IDBASE = "";
  String NUMPROG = "";
  java.sql.Date DATAOPE = CPLib.NullDate();
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
  double PRGIMPINF = 0;
  String UNIQUECODE = "";
  String CDATOPE = "";
  String CDATREG = "";
  String IDBASE2 = "";
  String CONNALTRO = "";
  java.sql.Timestamp NUMIMP = CPLib.NullDateTime();
  double FLAGTIT = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAOPE))) {
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
    if ( ! (CPLib.Empty(PRGIMPINF))) {
      return false;
    }
    if ( ! (CPLib.Empty(UNIQUECODE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CDATOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CDATREG))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDBASE2))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNALTRO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMIMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGTIT))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_rapopebo p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_rapopebo.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_rapopebo.this.NUMPROG = copyAndCast(p_row.NUMPROG);
      MemoryCursorRow_rapopebo.this.DATAOPE = copyAndCast(p_row.DATAOPE);
      MemoryCursorRow_rapopebo.this.TIPOINTER = copyAndCast(p_row.TIPOINTER);
      MemoryCursorRow_rapopebo.this.CODINTER = copyAndCast(p_row.CODINTER);
      MemoryCursorRow_rapopebo.this.TIPOINF = copyAndCast(p_row.TIPOINF);
      MemoryCursorRow_rapopebo.this.IDEREG = copyAndCast(p_row.IDEREG);
      MemoryCursorRow_rapopebo.this.CODDIPE = copyAndCast(p_row.CODDIPE);
      MemoryCursorRow_rapopebo.this.DESCCIT = copyAndCast(p_row.DESCCIT);
      MemoryCursorRow_rapopebo.this.PROVINCIA = copyAndCast(p_row.PROVINCIA);
      MemoryCursorRow_rapopebo.this.CODCAB = copyAndCast(p_row.CODCAB);
      MemoryCursorRow_rapopebo.this.FLAGFRAZ = copyAndCast(p_row.FLAGFRAZ);
      MemoryCursorRow_rapopebo.this.FLAGCONT = copyAndCast(p_row.FLAGCONT);
      MemoryCursorRow_rapopebo.this.CODANA = copyAndCast(p_row.CODANA);
      MemoryCursorRow_rapopebo.this.CODVOC = copyAndCast(p_row.CODVOC);
      MemoryCursorRow_rapopebo.this.TIPOINT2 = copyAndCast(p_row.TIPOINT2);
      MemoryCursorRow_rapopebo.this.CODINT2 = copyAndCast(p_row.CODINT2);
      MemoryCursorRow_rapopebo.this.PAESE = copyAndCast(p_row.PAESE);
      MemoryCursorRow_rapopebo.this.DESC2 = copyAndCast(p_row.DESC2);
      MemoryCursorRow_rapopebo.this.PROV2 = copyAndCast(p_row.PROV2);
      MemoryCursorRow_rapopebo.this.CODCAB2 = copyAndCast(p_row.CODCAB2);
      MemoryCursorRow_rapopebo.this.DESCINTER = copyAndCast(p_row.DESCINTER);
      MemoryCursorRow_rapopebo.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_rapopebo.this.FLAGRAP = copyAndCast(p_row.FLAGRAP);
      MemoryCursorRow_rapopebo.this.TIPOLEG = copyAndCast(p_row.TIPOLEG);
      MemoryCursorRow_rapopebo.this.DATAREG = copyAndCast(p_row.DATAREG);
      MemoryCursorRow_rapopebo.this.OPRAP = copyAndCast(p_row.OPRAP);
      MemoryCursorRow_rapopebo.this.TIPOOPRAP = copyAndCast(p_row.TIPOOPRAP);
      MemoryCursorRow_rapopebo.this.FLAGLIRE = copyAndCast(p_row.FLAGLIRE);
      MemoryCursorRow_rapopebo.this.VALUTA = copyAndCast(p_row.VALUTA);
      MemoryCursorRow_rapopebo.this.SEGNO = copyAndCast(p_row.SEGNO);
      MemoryCursorRow_rapopebo.this.TOTLIRE = copyAndCast(p_row.TOTLIRE);
      MemoryCursorRow_rapopebo.this.TOTCONT = copyAndCast(p_row.TOTCONT);
      MemoryCursorRow_rapopebo.this.STATOREG = copyAndCast(p_row.STATOREG);
      MemoryCursorRow_rapopebo.this.OPERAZMOD = copyAndCast(p_row.OPERAZMOD);
      MemoryCursorRow_rapopebo.this.DATARETT = copyAndCast(p_row.DATARETT);
      MemoryCursorRow_rapopebo.this.CONNESCLI = copyAndCast(p_row.CONNESCLI);
      MemoryCursorRow_rapopebo.this.CONNESOPER = copyAndCast(p_row.CONNESOPER);
      MemoryCursorRow_rapopebo.this.CONNESBEN = copyAndCast(p_row.CONNESBEN);
      MemoryCursorRow_rapopebo.this.COLLEG = copyAndCast(p_row.COLLEG);
      MemoryCursorRow_rapopebo.this.CAMBIO = copyAndCast(p_row.CAMBIO);
      MemoryCursorRow_rapopebo.this.RAPPORTBEN = copyAndCast(p_row.RAPPORTBEN);
      MemoryCursorRow_rapopebo.this.FLAGRAP2 = copyAndCast(p_row.FLAGRAP2);
      MemoryCursorRow_rapopebo.this.OPERATORE = copyAndCast(p_row.OPERATORE);
      MemoryCursorRow_rapopebo.this.AUTOM = copyAndCast(p_row.AUTOM);
      MemoryCursorRow_rapopebo.this.RESPINS = copyAndCast(p_row.RESPINS);
      MemoryCursorRow_rapopebo.this.INFORM = copyAndCast(p_row.INFORM);
      MemoryCursorRow_rapopebo.this.DATAAGE = copyAndCast(p_row.DATAAGE);
      MemoryCursorRow_rapopebo.this.UCODE = copyAndCast(p_row.UCODE);
      MemoryCursorRow_rapopebo.this.PRGIMPINF = copyAndCast(p_row.PRGIMPINF);
      MemoryCursorRow_rapopebo.this.UNIQUECODE = copyAndCast(p_row.UNIQUECODE);
      MemoryCursorRow_rapopebo.this.CDATOPE = copyAndCast(p_row.CDATOPE);
      MemoryCursorRow_rapopebo.this.CDATREG = copyAndCast(p_row.CDATREG);
      MemoryCursorRow_rapopebo.this.IDBASE2 = copyAndCast(p_row.IDBASE2);
      MemoryCursorRow_rapopebo.this.CONNALTRO = copyAndCast(p_row.CONNALTRO);
      MemoryCursorRow_rapopebo.this.NUMIMP = copyAndCast(p_row.NUMIMP);
      MemoryCursorRow_rapopebo.this.FLAGTIT = copyAndCast(p_row.FLAGTIT);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"IDBASE","NUMPROG","DATAOPE","TIPOINTER","CODINTER","TIPOINF","IDEREG","CODDIPE","DESCCIT","PROVINCIA","CODCAB","FLAGFRAZ","FLAGCONT","CODANA","CODVOC","TIPOINT2","CODINT2","PAESE","DESC2","PROV2","CODCAB2","DESCINTER","RAPPORTO","FLAGRAP","TIPOLEG","DATAREG","OPRAP","TIPOOPRAP","FLAGLIRE","VALUTA","SEGNO","TOTLIRE","TOTCONT","STATOREG","OPERAZMOD","DATARETT","CONNESCLI","CONNESOPER","CONNESBEN","COLLEG","CAMBIO","RAPPORTBEN","FLAGRAP2","OPERATORE","AUTOM","RESPINS","INFORM","DATAAGE","UCODE","PRGIMPINF","UNIQUECODE","CDATOPE","CDATREG","IDBASE2","CONNALTRO","NUMIMP","FLAGTIT"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","D","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","D","C","C","C","C","C","N","N","C","C","D","C","C","C","C","N","C","C","C","C","C","C","D","C","N","C","C","C","C","C","T","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"idbase","Numero Progressivo","Data Inizio / Fine Rapporto","","Codice Interm.","","","Codice Dipendenza","Citta Int.","Provincia","CAB","","","","","","","","","","","Note Brevi","","","Tipo Legame Sogg.","Data Registrazione","","Tipo Informazione","","","","","","Stato Registrazione","","","","Soggetto Operante Conto Terzi","","","","","","","","","","","","Progressivo Importo","Codice univoco per importazioni di n sogetti operanti","Data Operazione (Letterale)","Data Registrazione","Gestione IDEREG","Codice Legame tipo 58","Mark Importazione","Flag Somma Titolari"};
    return l_names;
  }
}
