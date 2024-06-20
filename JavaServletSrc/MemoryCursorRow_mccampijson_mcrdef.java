public class MemoryCursorRow_mccampijson_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mccampijson_mcrdef() {
  }
  public MemoryCursorRow_mccampijson_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mccampijson_mcrdef toBuild = new MemoryCursor_mccampijson_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mccampijson_mcrdef toBuild = new MemoryCursor_mccampijson_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String nomecampo = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(nomecampo))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mccampijson_mcrdef p_row) {
    MemoryCursorRow_mccampijson_mcrdef l_row = new MemoryCursorRow_mccampijson_mcrdef();
    CopyOperation<MemoryCursorRow_mccampijson_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mccampijson_mcrdef.this.nomecampo = l_row.nomecampo;
    }
  }
  protected CopyOperation<MemoryCursorRow_mccampijson_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mccampijson_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mccampijson_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mccampijson_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mccampijson_mcrdef p_From,MemoryCursorRow_mccampijson_mcrdef p_To) {
        p_To.nomecampo = copyAndCast(p_From.nomecampo);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"nomecampo"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Nome campo JSON"};
    return l_names;
  }
}
