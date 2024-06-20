public class MemoryCursorRow_tbcitta extends CPMemoryCursorRow {
  public MemoryCursorRow_tbcitta() {
  }
  public MemoryCursorRow_tbcitta(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tbcitta toBuild = new MemoryCursor_tbcitta(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tbcitta toBuild = new MemoryCursor_tbcitta();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String IDBASE = "";
  String CITTA = "";
  String CAB = "";
  String PROV = "";
  String CAP = "";
  String PKTBSTATI = "";
  String SIGLA = "";
  String PREF = "";
  String IDTBLS = "";
  String IDCITTA = "";
  String IDISTAT = "";
  String IDREGIO = "";
  java.sql.Date DATAINI = CPLib.NullDate();
  java.sql.Date DATAFIN = CPLib.NullDate();
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CITTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROV))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(PKTBSTATI))) {
      return false;
    }
    if ( ! (CPLib.Empty(SIGLA))) {
      return false;
    }
    if ( ! (CPLib.Empty(PREF))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDTBLS))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDCITTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDISTAT))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDREGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAINI))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAFIN))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tbcitta p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tbcitta.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_tbcitta.this.CITTA = copyAndCast(p_row.CITTA);
      MemoryCursorRow_tbcitta.this.CAB = copyAndCast(p_row.CAB);
      MemoryCursorRow_tbcitta.this.PROV = copyAndCast(p_row.PROV);
      MemoryCursorRow_tbcitta.this.CAP = copyAndCast(p_row.CAP);
      MemoryCursorRow_tbcitta.this.PKTBSTATI = copyAndCast(p_row.PKTBSTATI);
      MemoryCursorRow_tbcitta.this.SIGLA = copyAndCast(p_row.SIGLA);
      MemoryCursorRow_tbcitta.this.PREF = copyAndCast(p_row.PREF);
      MemoryCursorRow_tbcitta.this.IDTBLS = copyAndCast(p_row.IDTBLS);
      MemoryCursorRow_tbcitta.this.IDCITTA = copyAndCast(p_row.IDCITTA);
      MemoryCursorRow_tbcitta.this.IDISTAT = copyAndCast(p_row.IDISTAT);
      MemoryCursorRow_tbcitta.this.IDREGIO = copyAndCast(p_row.IDREGIO);
      MemoryCursorRow_tbcitta.this.DATAINI = copyAndCast(p_row.DATAINI);
      MemoryCursorRow_tbcitta.this.DATAFIN = copyAndCast(p_row.DATAFIN);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"IDBASE","CITTA","CAB","PROV","CAP","PKTBSTATI","SIGLA","PREF","IDTBLS","IDCITTA","IDISTAT","IDREGIO","DATAINI","DATAFIN"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C","C","C","C","D","D"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice","Località","CAB","Provincia","CAP","Stato","Sigla","Prefisso Telefonico","","","","","",""};
    return l_names;
  }
}
