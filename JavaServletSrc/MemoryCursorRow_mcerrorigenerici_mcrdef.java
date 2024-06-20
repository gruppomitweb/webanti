public class MemoryCursorRow_mcerrorigenerici_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcerrorigenerici_mcrdef() {
  }
  public MemoryCursorRow_mcerrorigenerici_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcerrorigenerici_mcrdef toBuild = new MemoryCursor_mcerrorigenerici_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcerrorigenerici_mcrdef toBuild = new MemoryCursor_mcerrorigenerici_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String field1 = "";
  String field2 = "";
  String field3 = "";
  String field4 = "";
  String field5 = "";
  String field6 = "";
  String field7 = "";
  String field8 = "";
  String field9 = "";
  String field10 = "";
  String field11 = "";
  String field12 = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(field1))) {
      return false;
    }
    if ( ! (CPLib.Empty(field2))) {
      return false;
    }
    if ( ! (CPLib.Empty(field3))) {
      return false;
    }
    if ( ! (CPLib.Empty(field4))) {
      return false;
    }
    if ( ! (CPLib.Empty(field5))) {
      return false;
    }
    if ( ! (CPLib.Empty(field6))) {
      return false;
    }
    if ( ! (CPLib.Empty(field7))) {
      return false;
    }
    if ( ! (CPLib.Empty(field8))) {
      return false;
    }
    if ( ! (CPLib.Empty(field9))) {
      return false;
    }
    if ( ! (CPLib.Empty(field10))) {
      return false;
    }
    if ( ! (CPLib.Empty(field11))) {
      return false;
    }
    if ( ! (CPLib.Empty(field12))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcerrorigenerici_mcrdef p_row) {
    MemoryCursorRow_mcerrorigenerici_mcrdef l_row = new MemoryCursorRow_mcerrorigenerici_mcrdef();
    CopyOperation<MemoryCursorRow_mcerrorigenerici_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcerrorigenerici_mcrdef.this.field1 = l_row.field1;
      MemoryCursorRow_mcerrorigenerici_mcrdef.this.field2 = l_row.field2;
      MemoryCursorRow_mcerrorigenerici_mcrdef.this.field3 = l_row.field3;
      MemoryCursorRow_mcerrorigenerici_mcrdef.this.field4 = l_row.field4;
      MemoryCursorRow_mcerrorigenerici_mcrdef.this.field5 = l_row.field5;
      MemoryCursorRow_mcerrorigenerici_mcrdef.this.field6 = l_row.field6;
      MemoryCursorRow_mcerrorigenerici_mcrdef.this.field7 = l_row.field7;
      MemoryCursorRow_mcerrorigenerici_mcrdef.this.field8 = l_row.field8;
      MemoryCursorRow_mcerrorigenerici_mcrdef.this.field9 = l_row.field9;
      MemoryCursorRow_mcerrorigenerici_mcrdef.this.field10 = l_row.field10;
      MemoryCursorRow_mcerrorigenerici_mcrdef.this.field11 = l_row.field11;
      MemoryCursorRow_mcerrorigenerici_mcrdef.this.field12 = l_row.field12;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcerrorigenerici_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcerrorigenerici_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcerrorigenerici_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcerrorigenerici_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcerrorigenerici_mcrdef p_From,MemoryCursorRow_mcerrorigenerici_mcrdef p_To) {
        p_To.field1 = copyAndCast(p_From.field1);
        p_To.field2 = copyAndCast(p_From.field2);
        p_To.field3 = copyAndCast(p_From.field3);
        p_To.field4 = copyAndCast(p_From.field4);
        p_To.field5 = copyAndCast(p_From.field5);
        p_To.field6 = copyAndCast(p_From.field6);
        p_To.field7 = copyAndCast(p_From.field7);
        p_To.field8 = copyAndCast(p_From.field8);
        p_To.field9 = copyAndCast(p_From.field9);
        p_To.field10 = copyAndCast(p_From.field10);
        p_To.field11 = copyAndCast(p_From.field11);
        p_To.field12 = copyAndCast(p_From.field12);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"field1","field2","field3","field4","field5","field6","field7","field8","field9","field10","field11","field12"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"","","","","","","","","","","",""};
    return l_names;
  }
}
