public class MemoryCursorRow_tmp_newpers extends CPMemoryCursorRow {
  public MemoryCursorRow_tmp_newpers() {
  }
  public MemoryCursorRow_tmp_newpers(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tmp_newpers toBuild = new MemoryCursor_tmp_newpers(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tmp_newpers toBuild = new MemoryCursor_tmp_newpers();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CONNES = "";
  String RAGSOC = "";
  String SOTGRUP = "";
  String RAMOGRUP = "";
  String SETTSINT = "";
  String ATTIV = "";
  String MSGELAB = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CONNES))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGSOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(SOTGRUP))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAMOGRUP))) {
      return false;
    }
    if ( ! (CPLib.Empty(SETTSINT))) {
      return false;
    }
    if ( ! (CPLib.Empty(ATTIV))) {
      return false;
    }
    if ( ! (CPLib.Empty(MSGELAB))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tmp_newpers p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tmp_newpers.this.CONNES = copyAndCast(p_row.CONNES);
      MemoryCursorRow_tmp_newpers.this.RAGSOC = copyAndCast(p_row.RAGSOC);
      MemoryCursorRow_tmp_newpers.this.SOTGRUP = copyAndCast(p_row.SOTGRUP);
      MemoryCursorRow_tmp_newpers.this.RAMOGRUP = copyAndCast(p_row.RAMOGRUP);
      MemoryCursorRow_tmp_newpers.this.SETTSINT = copyAndCast(p_row.SETTSINT);
      MemoryCursorRow_tmp_newpers.this.ATTIV = copyAndCast(p_row.ATTIV);
      MemoryCursorRow_tmp_newpers.this.MSGELAB = copyAndCast(p_row.MSGELAB);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CONNES","RAGSOC","SOTGRUP","RAMOGRUP","SETTSINT","ATTIV","MSGELAB"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Cliente","Ragione Sociale","Sottogruppo Att. Ec.","Ramo Gruppo Att. Ec.","Settorizzazione UIC","ATECO 2007","Messaggio"};
    return l_names;
  }
}
