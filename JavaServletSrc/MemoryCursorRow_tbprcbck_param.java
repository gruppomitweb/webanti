public class MemoryCursorRow_tbprcbck_param extends CPMemoryCursorRow {
  public MemoryCursorRow_tbprcbck_param() {
  }
  public MemoryCursorRow_tbprcbck_param(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tbprcbck_param toBuild = new MemoryCursor_tbprcbck_param(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tbprcbck_param toBuild = new MemoryCursor_tbprcbck_param();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  double PPCODICE = 0;
  double CPROWNUM = 0;
  String PPDESCRI = "";
  String PPTIPPAR = "";
  String PPVALPAR = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(PPCODICE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CPROWNUM))) {
      return false;
    }
    if ( ! (CPLib.Empty(PPDESCRI))) {
      return false;
    }
    if ( ! (CPLib.Empty(PPTIPPAR))) {
      return false;
    }
    if ( ! (CPLib.Empty(PPVALPAR))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tbprcbck_param p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tbprcbck_param.this.PPCODICE = copyAndCast(p_row.PPCODICE);
      MemoryCursorRow_tbprcbck_param.this.CPROWNUM = copyAndCast(p_row.CPROWNUM);
      MemoryCursorRow_tbprcbck_param.this.PPDESCRI = copyAndCast(p_row.PPDESCRI);
      MemoryCursorRow_tbprcbck_param.this.PPTIPPAR = copyAndCast(p_row.PPTIPPAR);
      MemoryCursorRow_tbprcbck_param.this.PPVALPAR = copyAndCast(p_row.PPVALPAR);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"PPCODICE","CPROWNUM","PPDESCRI","PPTIPPAR","PPVALPAR"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"N","N","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"","N. Riga","Descrizione","Tipo (Stringa,Double,Int)","Valore"};
    return l_names;
  }
}
