public class MemoryCursorRow_qbe_rtra_aua_2_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_rtra_aua_2_vqr() {
  }
  public MemoryCursorRow_qbe_rtra_aua_2_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_rtra_aua_2_vqr toBuild = new MemoryCursor_qbe_rtra_aua_2_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_rtra_aua_2_vqr toBuild = new MemoryCursor_qbe_rtra_aua_2_vqr();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String TIPODOC = "";
  String NUMDOCUM = "";
  java.sql.Date DATARILASC = CPLib.NullDate();
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(TIPODOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMDOCUM))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATARILASC))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_qbe_rtra_aua_2_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_rtra_aua_2_vqr.this.TIPODOC = copyAndCast(p_row.TIPODOC);
      MemoryCursorRow_qbe_rtra_aua_2_vqr.this.NUMDOCUM = copyAndCast(p_row.NUMDOCUM);
      MemoryCursorRow_qbe_rtra_aua_2_vqr.this.DATARILASC = copyAndCast(p_row.DATARILASC);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"TIPODOC","NUMDOCUM","DATARILASC"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","D"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Tipo Documento","Numero Doc.","Data Rilascio Doc."};
    return l_names;
  }
}
