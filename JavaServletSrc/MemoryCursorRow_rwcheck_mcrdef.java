public class MemoryCursorRow_rwcheck_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_rwcheck_mcrdef() {
  }
  public MemoryCursorRow_rwcheck_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_rwcheck_mcrdef toBuild = new MemoryCursor_rwcheck_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_rwcheck_mcrdef toBuild = new MemoryCursor_rwcheck_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String NOMEFILE1 = "";
  String NOMEFILE2 = "";
  String NOMEFILE3 = "";
  String NOMEDIR = "";
  String CRYPPTOKEY = "";
  String DIRBASE = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(NOMEFILE1))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOMEFILE2))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOMEFILE3))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOMEDIR))) {
      return false;
    }
    if ( ! (CPLib.Empty(CRYPPTOKEY))) {
      return false;
    }
    if ( ! (CPLib.Empty(DIRBASE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_rwcheck_mcrdef p_row) {
    MemoryCursorRow_rwcheck_mcrdef l_row = new MemoryCursorRow_rwcheck_mcrdef();
    CopyOperation<MemoryCursorRow_rwcheck_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_rwcheck_mcrdef.this.NOMEFILE1 = l_row.NOMEFILE1;
      MemoryCursorRow_rwcheck_mcrdef.this.NOMEFILE2 = l_row.NOMEFILE2;
      MemoryCursorRow_rwcheck_mcrdef.this.NOMEFILE3 = l_row.NOMEFILE3;
      MemoryCursorRow_rwcheck_mcrdef.this.NOMEDIR = l_row.NOMEDIR;
      MemoryCursorRow_rwcheck_mcrdef.this.CRYPPTOKEY = l_row.CRYPPTOKEY;
      MemoryCursorRow_rwcheck_mcrdef.this.DIRBASE = l_row.DIRBASE;
    }
  }
  protected CopyOperation<MemoryCursorRow_rwcheck_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_rwcheck_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_rwcheck_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_rwcheck_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_rwcheck_mcrdef p_From,MemoryCursorRow_rwcheck_mcrdef p_To) {
        p_To.NOMEFILE1 = copyAndCast(p_From.NOMEFILE1);
        p_To.NOMEFILE2 = copyAndCast(p_From.NOMEFILE2);
        p_To.NOMEFILE3 = copyAndCast(p_From.NOMEFILE3);
        p_To.NOMEDIR = copyAndCast(p_From.NOMEDIR);
        p_To.CRYPPTOKEY = copyAndCast(p_From.CRYPPTOKEY);
        p_To.DIRBASE = copyAndCast(p_From.DIRBASE);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"NOMEFILE1","NOMEFILE2","NOMEFILE3","NOMEDIR","CRYPPTOKEY","DIRBASE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","M","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Nome Primo FIle","Nome Secondo File","Nome Terzo File","Nome Cartella dei file","Chiave Crittografazione","Directory di base"};
    return l_names;
  }
}
