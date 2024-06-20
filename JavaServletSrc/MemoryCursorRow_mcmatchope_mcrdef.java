public class MemoryCursorRow_mcmatchope_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcmatchope_mcrdef() {
  }
  public MemoryCursorRow_mcmatchope_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcmatchope_mcrdef toBuild = new MemoryCursor_mcmatchope_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcmatchope_mcrdef toBuild = new MemoryCursor_mcmatchope_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String SNAINUMOPE = "";
  double NUMMATCH = 0;
  double NUMRIGHE = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(SNAINUMOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMMATCH))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMRIGHE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcmatchope_mcrdef p_row) {
    MemoryCursorRow_mcmatchope_mcrdef l_row = new MemoryCursorRow_mcmatchope_mcrdef();
    CopyOperation<MemoryCursorRow_mcmatchope_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcmatchope_mcrdef.this.SNAINUMOPE = l_row.SNAINUMOPE;
      MemoryCursorRow_mcmatchope_mcrdef.this.NUMMATCH = l_row.NUMMATCH;
      MemoryCursorRow_mcmatchope_mcrdef.this.NUMRIGHE = l_row.NUMRIGHE;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcmatchope_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcmatchope_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcmatchope_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcmatchope_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcmatchope_mcrdef p_From,MemoryCursorRow_mcmatchope_mcrdef p_To) {
        p_To.SNAINUMOPE = copyAndCast(p_From.SNAINUMOPE);
        p_To.NUMMATCH = copyAndCast(p_From.NUMMATCH);
        p_To.NUMRIGHE = copyAndCast(p_From.NUMRIGHE);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"SNAINUMOPE","NUMMATCH","NUMRIGHE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","N","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"","",""};
    return l_names;
  }
}
