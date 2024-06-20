public class MemoryCursorRow_mcmessaggi_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcmessaggi_mcrdef() {
  }
  public MemoryCursorRow_mcmessaggi_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcmessaggi_mcrdef toBuild = new MemoryCursor_mcmessaggi_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcmessaggi_mcrdef toBuild = new MemoryCursor_mcmessaggi_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String testata = "";
  String messaggio = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(testata))) {
      return false;
    }
    if ( ! (CPLib.Empty(messaggio))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcmessaggi_mcrdef p_row) {
    MemoryCursorRow_mcmessaggi_mcrdef l_row = new MemoryCursorRow_mcmessaggi_mcrdef();
    CopyOperation<MemoryCursorRow_mcmessaggi_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcmessaggi_mcrdef.this.testata = l_row.testata;
      MemoryCursorRow_mcmessaggi_mcrdef.this.messaggio = l_row.messaggio;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcmessaggi_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcmessaggi_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcmessaggi_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcmessaggi_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcmessaggi_mcrdef p_From,MemoryCursorRow_mcmessaggi_mcrdef p_To) {
        p_To.testata = copyAndCast(p_From.testata);
        p_To.messaggio = copyAndCast(p_From.messaggio);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"testata","messaggio"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Testa del messaggio","Messaggio da visualizzare"};
    return l_names;
  }
}
