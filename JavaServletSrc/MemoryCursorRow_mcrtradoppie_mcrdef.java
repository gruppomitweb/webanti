public class MemoryCursorRow_mcrtradoppie_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcrtradoppie_mcrdef() {
  }
  public MemoryCursorRow_mcrtradoppie_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcrtradoppie_mcrdef toBuild = new MemoryCursor_mcrtradoppie_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcrtradoppie_mcrdef toBuild = new MemoryCursor_mcrtradoppie_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String MTCN = "";
  String DATAOPE = "";
  String SEGNO = "";
  String CAUSALE = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(MTCN))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(SEGNO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAUSALE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcrtradoppie_mcrdef p_row) {
    MemoryCursorRow_mcrtradoppie_mcrdef l_row = new MemoryCursorRow_mcrtradoppie_mcrdef();
    CopyOperation<MemoryCursorRow_mcrtradoppie_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcrtradoppie_mcrdef.this.MTCN = l_row.MTCN;
      MemoryCursorRow_mcrtradoppie_mcrdef.this.DATAOPE = l_row.DATAOPE;
      MemoryCursorRow_mcrtradoppie_mcrdef.this.SEGNO = l_row.SEGNO;
      MemoryCursorRow_mcrtradoppie_mcrdef.this.CAUSALE = l_row.CAUSALE;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcrtradoppie_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcrtradoppie_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcrtradoppie_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcrtradoppie_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcrtradoppie_mcrdef p_From,MemoryCursorRow_mcrtradoppie_mcrdef p_To) {
        p_To.MTCN = copyAndCast(p_From.MTCN);
        p_To.DATAOPE = copyAndCast(p_From.DATAOPE);
        p_To.SEGNO = copyAndCast(p_From.SEGNO);
        p_To.CAUSALE = copyAndCast(p_From.CAUSALE);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"MTCN","DATAOPE","SEGNO","CAUSALE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"MTCN","Data Operazione","Segno","Causale"};
    return l_names;
  }
}
