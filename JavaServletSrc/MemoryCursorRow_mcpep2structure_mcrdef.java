public class MemoryCursorRow_mcpep2structure_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcpep2structure_mcrdef() {
  }
  public MemoryCursorRow_mcpep2structure_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcpep2structure_mcrdef toBuild = new MemoryCursor_mcpep2structure_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcpep2structure_mcrdef toBuild = new MemoryCursor_mcpep2structure_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String TIPOLOGIA = "";
  String STATUS = "";
  String WARNING = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(TIPOLOGIA))) {
      return false;
    }
    if ( ! (CPLib.Empty(STATUS))) {
      return false;
    }
    if ( ! (CPLib.Empty(WARNING))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcpep2structure_mcrdef p_row) {
    MemoryCursorRow_mcpep2structure_mcrdef l_row = new MemoryCursorRow_mcpep2structure_mcrdef();
    CopyOperation<MemoryCursorRow_mcpep2structure_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcpep2structure_mcrdef.this.TIPOLOGIA = l_row.TIPOLOGIA;
      MemoryCursorRow_mcpep2structure_mcrdef.this.STATUS = l_row.STATUS;
      MemoryCursorRow_mcpep2structure_mcrdef.this.WARNING = l_row.WARNING;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcpep2structure_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcpep2structure_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcpep2structure_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcpep2structure_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcpep2structure_mcrdef p_From,MemoryCursorRow_mcpep2structure_mcrdef p_To) {
        p_To.TIPOLOGIA = copyAndCast(p_From.TIPOLOGIA);
        p_To.STATUS = copyAndCast(p_From.STATUS);
        p_To.WARNING = copyAndCast(p_From.WARNING);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"TIPOLOGIA","STATUS","WARNING"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Tipo Ricerca","(Negativa o positiva)","Messaggi"};
    return l_names;
  }
}
