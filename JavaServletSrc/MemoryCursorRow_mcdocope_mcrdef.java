public class MemoryCursorRow_mcdocope_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcdocope_mcrdef() {
  }
  public MemoryCursorRow_mcdocope_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcdocope_mcrdef toBuild = new MemoryCursor_mcdocope_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcdocope_mcrdef toBuild = new MemoryCursor_mcdocope_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  double numdoc = 0;
  String nomdoc = "";
  String olddoc = "";
  String orgdoc = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(numdoc))) {
      return false;
    }
    if ( ! (CPLib.Empty(nomdoc))) {
      return false;
    }
    if ( ! (CPLib.Empty(olddoc))) {
      return false;
    }
    if ( ! (CPLib.Empty(orgdoc))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcdocope_mcrdef p_row) {
    MemoryCursorRow_mcdocope_mcrdef l_row = new MemoryCursorRow_mcdocope_mcrdef();
    CopyOperation<MemoryCursorRow_mcdocope_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcdocope_mcrdef.this.numdoc = l_row.numdoc;
      MemoryCursorRow_mcdocope_mcrdef.this.nomdoc = l_row.nomdoc;
      MemoryCursorRow_mcdocope_mcrdef.this.olddoc = l_row.olddoc;
      MemoryCursorRow_mcdocope_mcrdef.this.orgdoc = l_row.orgdoc;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcdocope_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcdocope_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcdocope_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcdocope_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcdocope_mcrdef p_From,MemoryCursorRow_mcdocope_mcrdef p_To) {
        p_To.numdoc = copyAndCast(p_From.numdoc);
        p_To.nomdoc = copyAndCast(p_From.nomdoc);
        p_To.olddoc = copyAndCast(p_From.olddoc);
        p_To.orgdoc = copyAndCast(p_From.orgdoc);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"numdoc","nomdoc","olddoc","orgdoc"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"N","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Posizione Documento","Nome Nuovo Documento","Documento Precedente","Nuovo Documento nome originale"};
    return l_names;
  }
}
