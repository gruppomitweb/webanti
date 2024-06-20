public class MemoryCursorRow_mcrtranaid_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcrtranaid_mcrdef() {
  }
  public MemoryCursorRow_mcrtranaid_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcrtranaid_mcrdef toBuild = new MemoryCursor_mcrtranaid_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcrtranaid_mcrdef toBuild = new MemoryCursor_mcrtranaid_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String NAID = "";
  double TOTALE = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(NAID))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTALE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcrtranaid_mcrdef p_row) {
    MemoryCursorRow_mcrtranaid_mcrdef l_row = new MemoryCursorRow_mcrtranaid_mcrdef();
    CopyOperation<MemoryCursorRow_mcrtranaid_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcrtranaid_mcrdef.this.NAID = l_row.NAID;
      MemoryCursorRow_mcrtranaid_mcrdef.this.TOTALE = l_row.TOTALE;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcrtranaid_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcrtranaid_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcrtranaid_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcrtranaid_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcrtranaid_mcrdef p_From,MemoryCursorRow_mcrtranaid_mcrdef p_To) {
        p_To.NAID = copyAndCast(p_From.NAID);
        p_To.TOTALE = copyAndCast(p_From.TOTALE);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"NAID","TOTALE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice NAID","Numero Transazioni"};
    return l_names;
  }
}
