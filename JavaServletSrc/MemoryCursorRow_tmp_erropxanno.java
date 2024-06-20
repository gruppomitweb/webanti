public class MemoryCursorRow_tmp_erropxanno extends CPMemoryCursorRow {
  public MemoryCursorRow_tmp_erropxanno() {
  }
  public MemoryCursorRow_tmp_erropxanno(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tmp_erropxanno toBuild = new MemoryCursor_tmp_erropxanno(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tmp_erropxanno toBuild = new MemoryCursor_tmp_erropxanno();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String TIPERR = "";
  double ANNO = 0;
  String CONNES = "";
  String CODFISC = "";
  String RAGSOC = "";
  String DESCRAP = "";
  String VALUTA = "";
  double SALDO = 0;
  double QTA = 0;
  java.sql.Date DATAOPE = CPLib.NullDate();
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(TIPERR))) {
      return false;
    }
    if ( ! (CPLib.Empty(ANNO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNES))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODFISC))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGSOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(VALUTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(SALDO))) {
      return false;
    }
    if ( ! (CPLib.Empty(QTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAOPE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tmp_erropxanno p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tmp_erropxanno.this.TIPERR = copyAndCast(p_row.TIPERR);
      MemoryCursorRow_tmp_erropxanno.this.ANNO = copyAndCast(p_row.ANNO);
      MemoryCursorRow_tmp_erropxanno.this.CONNES = copyAndCast(p_row.CONNES);
      MemoryCursorRow_tmp_erropxanno.this.CODFISC = copyAndCast(p_row.CODFISC);
      MemoryCursorRow_tmp_erropxanno.this.RAGSOC = copyAndCast(p_row.RAGSOC);
      MemoryCursorRow_tmp_erropxanno.this.DESCRAP = copyAndCast(p_row.DESCRAP);
      MemoryCursorRow_tmp_erropxanno.this.VALUTA = copyAndCast(p_row.VALUTA);
      MemoryCursorRow_tmp_erropxanno.this.SALDO = copyAndCast(p_row.SALDO);
      MemoryCursorRow_tmp_erropxanno.this.QTA = copyAndCast(p_row.QTA);
      MemoryCursorRow_tmp_erropxanno.this.DATAOPE = copyAndCast(p_row.DATAOPE);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"TIPERR","ANNO","CONNES","CODFISC","RAGSOC","DESCRAP","VALUTA","SALDO","QTA","DATAOPE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","N","C","C","C","C","C","N","N","D"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Tipo Errore","Anno Riferimento","NDG","Codice Fiscale Intestatario","Ragione Sociale","Descrizione","Valuta","Saldo","N° Operazioni","Data Operazione"};
    return l_names;
  }
}
