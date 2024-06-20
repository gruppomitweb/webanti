public class MemoryCursorRow_mcwersonbokey_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcwersonbokey_mcrdef() {
  }
  public MemoryCursorRow_mcwersonbokey_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcwersonbokey_mcrdef toBuild = new MemoryCursor_mcwersonbokey_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcwersonbokey_mcrdef toBuild = new MemoryCursor_mcwersonbokey_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CONNES = "";
  java.sql.Date DATAMODI = CPLib.NullDate();
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CONNES))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAMODI))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcwersonbokey_mcrdef p_row) {
    MemoryCursorRow_mcwersonbokey_mcrdef l_row = new MemoryCursorRow_mcwersonbokey_mcrdef();
    CopyOperation<MemoryCursorRow_mcwersonbokey_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcwersonbokey_mcrdef.this.CONNES = l_row.CONNES;
      MemoryCursorRow_mcwersonbokey_mcrdef.this.DATAMODI = l_row.DATAMODI;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcwersonbokey_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcwersonbokey_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcwersonbokey_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcwersonbokey_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcwersonbokey_mcrdef p_From,MemoryCursorRow_mcwersonbokey_mcrdef p_To) {
        p_To.CONNES = copyAndCast(p_From.CONNES);
        p_To.DATAMODI = copyAndCast(p_From.DATAMODI);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CONNES","DATAMODI"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","D"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"",""};
    return l_names;
  }
}
