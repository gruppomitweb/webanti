public class MemoryCursorRow_mcdiana_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcdiana_mcrdef() {
  }
  public MemoryCursorRow_mcdiana_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcdiana_mcrdef toBuild = new MemoryCursor_mcdiana_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcdiana_mcrdef toBuild = new MemoryCursor_mcdiana_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String TIPO = "";
  String RIGA = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(TIPO))) {
      return false;
    }
    if ( ! (CPLib.Empty(RIGA))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcdiana_mcrdef p_row) {
    MemoryCursorRow_mcdiana_mcrdef l_row = new MemoryCursorRow_mcdiana_mcrdef();
    CopyOperation<MemoryCursorRow_mcdiana_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcdiana_mcrdef.this.TIPO = l_row.TIPO;
      MemoryCursorRow_mcdiana_mcrdef.this.RIGA = l_row.RIGA;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcdiana_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcdiana_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcdiana_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcdiana_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcdiana_mcrdef p_From,MemoryCursorRow_mcdiana_mcrdef p_To) {
        p_To.TIPO = copyAndCast(p_From.TIPO);
        p_To.RIGA = copyAndCast(p_From.RIGA);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"TIPO","RIGA"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","M"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Tipo RIga","Contenuto Tipo Record"};
    return l_names;
  }
}
