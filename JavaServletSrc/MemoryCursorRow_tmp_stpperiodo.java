public class MemoryCursorRow_tmp_stpperiodo extends CPMemoryCursorRow {
  public MemoryCursorRow_tmp_stpperiodo() {
  }
  public MemoryCursorRow_tmp_stpperiodo(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tmp_stpperiodo toBuild = new MemoryCursor_tmp_stpperiodo(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tmp_stpperiodo toBuild = new MemoryCursor_tmp_stpperiodo();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String RAPPORTO = "";
  java.sql.Date DATAINI = CPLib.NullDate();
  java.sql.Date DATAFINE = CPLib.NullDate();
  String TIPOAG = "";
  String TIPORAP = "";
  String DESCRAP = "";
  String VALUTA = "";
  double INVIATO = 0;
  String TIPO = "";
  String CAB = "";
  String UNIQUECODE = "";
  String OLDINTER = "";
  String IDBASE = "";
  java.sql.Date DATAMODI = CPLib.NullDate();
  String IDESITO = "";
  String ISOAGE = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAINI))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAFINE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOAG))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPORAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(VALUTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(INVIATO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(UNIQUECODE))) {
      return false;
    }
    if ( ! (CPLib.Empty(OLDINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAMODI))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDESITO))) {
      return false;
    }
    if ( ! (CPLib.Empty(ISOAGE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tmp_stpperiodo p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tmp_stpperiodo.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_tmp_stpperiodo.this.DATAINI = copyAndCast(p_row.DATAINI);
      MemoryCursorRow_tmp_stpperiodo.this.DATAFINE = copyAndCast(p_row.DATAFINE);
      MemoryCursorRow_tmp_stpperiodo.this.TIPOAG = copyAndCast(p_row.TIPOAG);
      MemoryCursorRow_tmp_stpperiodo.this.TIPORAP = copyAndCast(p_row.TIPORAP);
      MemoryCursorRow_tmp_stpperiodo.this.DESCRAP = copyAndCast(p_row.DESCRAP);
      MemoryCursorRow_tmp_stpperiodo.this.VALUTA = copyAndCast(p_row.VALUTA);
      MemoryCursorRow_tmp_stpperiodo.this.INVIATO = copyAndCast(p_row.INVIATO);
      MemoryCursorRow_tmp_stpperiodo.this.TIPO = copyAndCast(p_row.TIPO);
      MemoryCursorRow_tmp_stpperiodo.this.CAB = copyAndCast(p_row.CAB);
      MemoryCursorRow_tmp_stpperiodo.this.UNIQUECODE = copyAndCast(p_row.UNIQUECODE);
      MemoryCursorRow_tmp_stpperiodo.this.OLDINTER = copyAndCast(p_row.OLDINTER);
      MemoryCursorRow_tmp_stpperiodo.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_tmp_stpperiodo.this.DATAMODI = copyAndCast(p_row.DATAMODI);
      MemoryCursorRow_tmp_stpperiodo.this.IDESITO = copyAndCast(p_row.IDESITO);
      MemoryCursorRow_tmp_stpperiodo.this.ISOAGE = copyAndCast(p_row.ISOAGE);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"RAPPORTO","DATAINI","DATAFINE","TIPOAG","TIPORAP","DESCRAP","VALUTA","INVIATO","TIPO","CAB","UNIQUECODE","OLDINTER","IDBASE","DATAMODI","IDESITO","ISOAGE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","D","D","C","C","C","C","N","C","C","C","C","C","D","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Rapporto","Data Inizio","Data Fine","Tipo AGE","Tipo AUI","Descrizione","Valuta","Inviato","Tipo","CAB","Codice Univoco","Codice Vecchio Intermediario","ID RIGA","Data Modifica","","ISO per 96/97"};
    return l_names;
  }
}
