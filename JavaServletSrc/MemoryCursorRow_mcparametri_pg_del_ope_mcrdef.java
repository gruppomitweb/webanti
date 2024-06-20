public class MemoryCursorRow_mcparametri_pg_del_ope_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcparametri_pg_del_ope_mcrdef() {
  }
  public MemoryCursorRow_mcparametri_pg_del_ope_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcparametri_pg_del_ope_mcrdef toBuild = new MemoryCursor_mcparametri_pg_del_ope_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcparametri_pg_del_ope_mcrdef toBuild = new MemoryCursor_mcparametri_pg_del_ope_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  java.sql.Date da_data = CPLib.NullDate();
  java.sql.Date a_data = CPLib.NullDate();
  String fonte = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(da_data))) {
      return false;
    }
    if ( ! (CPLib.Empty(a_data))) {
      return false;
    }
    if ( ! (CPLib.Empty(fonte))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcparametri_pg_del_ope_mcrdef p_row) {
    MemoryCursorRow_mcparametri_pg_del_ope_mcrdef l_row = new MemoryCursorRow_mcparametri_pg_del_ope_mcrdef();
    CopyOperation<MemoryCursorRow_mcparametri_pg_del_ope_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcparametri_pg_del_ope_mcrdef.this.da_data = l_row.da_data;
      MemoryCursorRow_mcparametri_pg_del_ope_mcrdef.this.a_data = l_row.a_data;
      MemoryCursorRow_mcparametri_pg_del_ope_mcrdef.this.fonte = l_row.fonte;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcparametri_pg_del_ope_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcparametri_pg_del_ope_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcparametri_pg_del_ope_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcparametri_pg_del_ope_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcparametri_pg_del_ope_mcrdef p_From,MemoryCursorRow_mcparametri_pg_del_ope_mcrdef p_To) {
        p_To.da_data = copyAndCast(p_From.da_data);
        p_To.a_data = copyAndCast(p_From.a_data);
        p_To.fonte = copyAndCast(p_From.fonte);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"da_data","a_data","fonte"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"D","D","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"filtro da data operazione","filtro a data operazione","su quale tabella fare la cancellazione\nOperazioni intere (O)\nFrazionate (F)\nTutte (T)"};
    return l_names;
  }
}
