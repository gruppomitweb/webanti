public class MemoryCursorRow_mcconnes_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcconnes_mcrdef() {
  }
  public MemoryCursorRow_mcconnes_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcconnes_mcrdef toBuild = new MemoryCursor_mcconnes_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcconnes_mcrdef toBuild = new MemoryCursor_mcconnes_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String connes = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(connes))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcconnes_mcrdef p_row) {
    MemoryCursorRow_mcconnes_mcrdef l_row = new MemoryCursorRow_mcconnes_mcrdef();
    CopyOperation<MemoryCursorRow_mcconnes_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcconnes_mcrdef.this.connes = l_row.connes;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcconnes_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcconnes_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcconnes_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcconnes_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcconnes_mcrdef p_From,MemoryCursorRow_mcconnes_mcrdef p_To) {
        p_To.connes = copyAndCast(p_From.connes);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"connes"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"codice di collegamento anagrafica"};
    return l_names;
  }
}
