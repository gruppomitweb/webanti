public class MemoryCursorRow_mcdaycases_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcdaycases_mcrdef() {
  }
  public MemoryCursorRow_mcdaycases_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcdaycases_mcrdef toBuild = new MemoryCursor_mcdaycases_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcdaycases_mcrdef toBuild = new MemoryCursor_mcdaycases_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  java.sql.Date DATAOPE = CPLib.NullDate();
  double TOTTRX = 0;
  double CASO_1 = 0;
  double CASO_2 = 0;
  double CASO_3 = 0;
  double CASO_4 = 0;
  double CASO_5 = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(DATAOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTTRX))) {
      return false;
    }
    if ( ! (CPLib.Empty(CASO_1))) {
      return false;
    }
    if ( ! (CPLib.Empty(CASO_2))) {
      return false;
    }
    if ( ! (CPLib.Empty(CASO_3))) {
      return false;
    }
    if ( ! (CPLib.Empty(CASO_4))) {
      return false;
    }
    if ( ! (CPLib.Empty(CASO_5))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcdaycases_mcrdef p_row) {
    MemoryCursorRow_mcdaycases_mcrdef l_row = new MemoryCursorRow_mcdaycases_mcrdef();
    CopyOperation<MemoryCursorRow_mcdaycases_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcdaycases_mcrdef.this.DATAOPE = l_row.DATAOPE;
      MemoryCursorRow_mcdaycases_mcrdef.this.TOTTRX = l_row.TOTTRX;
      MemoryCursorRow_mcdaycases_mcrdef.this.CASO_1 = l_row.CASO_1;
      MemoryCursorRow_mcdaycases_mcrdef.this.CASO_2 = l_row.CASO_2;
      MemoryCursorRow_mcdaycases_mcrdef.this.CASO_3 = l_row.CASO_3;
      MemoryCursorRow_mcdaycases_mcrdef.this.CASO_4 = l_row.CASO_4;
      MemoryCursorRow_mcdaycases_mcrdef.this.CASO_5 = l_row.CASO_5;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcdaycases_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcdaycases_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcdaycases_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcdaycases_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcdaycases_mcrdef p_From,MemoryCursorRow_mcdaycases_mcrdef p_To) {
        p_To.DATAOPE = copyAndCast(p_From.DATAOPE);
        p_To.TOTTRX = copyAndCast(p_From.TOTTRX);
        p_To.CASO_1 = copyAndCast(p_From.CASO_1);
        p_To.CASO_2 = copyAndCast(p_From.CASO_2);
        p_To.CASO_3 = copyAndCast(p_From.CASO_3);
        p_To.CASO_4 = copyAndCast(p_From.CASO_4);
        p_To.CASO_5 = copyAndCast(p_From.CASO_5);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"DATAOPE","TOTTRX","CASO_1","CASO_2","CASO_3","CASO_4","CASO_5"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"D","N","N","N","N","N","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Data Operazioni","N. Transazioni","Caso 1 Rilievi","Caso 2 Rilievi","Caso 3 Rilievi","Caso 4 Rilievi","Caso 5 Rilievi"};
    return l_names;
  }
}
