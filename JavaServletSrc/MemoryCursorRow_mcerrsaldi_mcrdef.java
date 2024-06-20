public class MemoryCursorRow_mcerrsaldi_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcerrsaldi_mcrdef() {
  }
  public MemoryCursorRow_mcerrsaldi_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcerrsaldi_mcrdef toBuild = new MemoryCursor_mcerrsaldi_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcerrsaldi_mcrdef toBuild = new MemoryCursor_mcerrsaldi_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String TIPO = "";
  String RAPPORTO = "";
  String CONNESINT = "";
  String TXTERR = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(TIPO))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESINT))) {
      return false;
    }
    if ( ! (CPLib.Empty(TXTERR))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcerrsaldi_mcrdef p_row) {
    MemoryCursorRow_mcerrsaldi_mcrdef l_row = new MemoryCursorRow_mcerrsaldi_mcrdef();
    CopyOperation<MemoryCursorRow_mcerrsaldi_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcerrsaldi_mcrdef.this.TIPO = l_row.TIPO;
      MemoryCursorRow_mcerrsaldi_mcrdef.this.RAPPORTO = l_row.RAPPORTO;
      MemoryCursorRow_mcerrsaldi_mcrdef.this.CONNESINT = l_row.CONNESINT;
      MemoryCursorRow_mcerrsaldi_mcrdef.this.TXTERR = l_row.TXTERR;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcerrsaldi_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcerrsaldi_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcerrsaldi_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcerrsaldi_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcerrsaldi_mcrdef p_From,MemoryCursorRow_mcerrsaldi_mcrdef p_To) {
        p_To.TIPO = copyAndCast(p_From.TIPO);
        p_To.RAPPORTO = copyAndCast(p_From.RAPPORTO);
        p_To.CONNESINT = copyAndCast(p_From.CONNESINT);
        p_To.TXTERR = copyAndCast(p_From.TXTERR);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"TIPO","RAPPORTO","CONNESINT","TXTERR"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Tipo Errore","Rapporto","Soggetto OPEX","Errore"};
    return l_names;
  }
}
