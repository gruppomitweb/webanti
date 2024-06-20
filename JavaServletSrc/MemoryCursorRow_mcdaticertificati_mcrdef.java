public class MemoryCursorRow_mcdaticertificati_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcdaticertificati_mcrdef() {
  }
  public MemoryCursorRow_mcdaticertificati_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcdaticertificati_mcrdef toBuild = new MemoryCursor_mcdaticertificati_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcdaticertificati_mcrdef toBuild = new MemoryCursor_mcdaticertificati_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String startDate = "";
  String endDate = "";
  String codifica = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(startDate))) {
      return false;
    }
    if ( ! (CPLib.Empty(endDate))) {
      return false;
    }
    if ( ! (CPLib.Empty(codifica))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcdaticertificati_mcrdef p_row) {
    MemoryCursorRow_mcdaticertificati_mcrdef l_row = new MemoryCursorRow_mcdaticertificati_mcrdef();
    CopyOperation<MemoryCursorRow_mcdaticertificati_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcdaticertificati_mcrdef.this.startDate = l_row.startDate;
      MemoryCursorRow_mcdaticertificati_mcrdef.this.endDate = l_row.endDate;
      MemoryCursorRow_mcdaticertificati_mcrdef.this.codifica = l_row.codifica;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcdaticertificati_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcdaticertificati_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcdaticertificati_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcdaticertificati_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcdaticertificati_mcrdef p_From,MemoryCursorRow_mcdaticertificati_mcrdef p_To) {
        p_To.startDate = copyAndCast(p_From.startDate);
        p_To.endDate = copyAndCast(p_From.endDate);
        p_To.codifica = copyAndCast(p_From.codifica);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"startDate","endDate","codifica"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Data Inizio","Data Fine","Codifica"};
    return l_names;
  }
}
