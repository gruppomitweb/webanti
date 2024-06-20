public class MemoryCursorRow_mccertificati_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mccertificati_mcrdef() {
  }
  public MemoryCursorRow_mccertificati_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mccertificati_mcrdef toBuild = new MemoryCursor_mccertificati_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mccertificati_mcrdef toBuild = new MemoryCursor_mccertificati_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String nome = "";
  boolean presente = false;
  java.sql.Timestamp datamod = CPLib.NullDateTime();
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(nome))) {
      return false;
    }
    if ( ! (CPLib.Empty(presente))) {
      return false;
    }
    if ( ! (CPLib.Empty(datamod))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mccertificati_mcrdef p_row) {
    MemoryCursorRow_mccertificati_mcrdef l_row = new MemoryCursorRow_mccertificati_mcrdef();
    CopyOperation<MemoryCursorRow_mccertificati_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mccertificati_mcrdef.this.nome = l_row.nome;
      MemoryCursorRow_mccertificati_mcrdef.this.presente = l_row.presente;
      MemoryCursorRow_mccertificati_mcrdef.this.datamod = l_row.datamod;
    }
  }
  protected CopyOperation<MemoryCursorRow_mccertificati_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mccertificati_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mccertificati_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mccertificati_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mccertificati_mcrdef p_From,MemoryCursorRow_mccertificati_mcrdef p_To) {
        p_To.nome = copyAndCast(p_From.nome);
        p_To.presente = copyAndCast(p_From.presente);
        p_To.datamod = copyAndCast(p_From.datamod);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"nome","presente","datamod"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","L","T"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"nome del file verificato","presenza o meno del certificato","data di ultima modifica del file"};
    return l_names;
  }
}
