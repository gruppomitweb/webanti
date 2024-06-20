public class MemoryCursorRow_mcdatistru_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcdatistru_mcrdef() {
  }
  public MemoryCursorRow_mcdatistru_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcdatistru_mcrdef toBuild = new MemoryCursor_mcdatistru_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcdatistru_mcrdef toBuild = new MemoryCursor_mcdatistru_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String colonna1 = "";
  String colonna2 = "";
  String colonna3 = "";
  String colonna4 = "";
  String colonna5 = "";
  String colonna6 = "";
  String colonna7 = "";
  String colonna8 = "";
  String colonna9 = "";
  String colonna10 = "";
  String colonna11 = "";
  String colonna12 = "";
  String colonna13 = "";
  String colonna14 = "";
  String colonna15 = "";
  String colonna16 = "";
  String colonna17 = "";
  String colonna18 = "";
  String colonna19 = "";
  String colonna20 = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(colonna1))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna2))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna3))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna4))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna5))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna6))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna7))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna8))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna9))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna10))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna11))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna12))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna13))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna14))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna15))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna16))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna17))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna18))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna19))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna20))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcdatistru_mcrdef p_row) {
    MemoryCursorRow_mcdatistru_mcrdef l_row = new MemoryCursorRow_mcdatistru_mcrdef();
    CopyOperation<MemoryCursorRow_mcdatistru_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcdatistru_mcrdef.this.colonna1 = l_row.colonna1;
      MemoryCursorRow_mcdatistru_mcrdef.this.colonna2 = l_row.colonna2;
      MemoryCursorRow_mcdatistru_mcrdef.this.colonna3 = l_row.colonna3;
      MemoryCursorRow_mcdatistru_mcrdef.this.colonna4 = l_row.colonna4;
      MemoryCursorRow_mcdatistru_mcrdef.this.colonna5 = l_row.colonna5;
      MemoryCursorRow_mcdatistru_mcrdef.this.colonna6 = l_row.colonna6;
      MemoryCursorRow_mcdatistru_mcrdef.this.colonna7 = l_row.colonna7;
      MemoryCursorRow_mcdatistru_mcrdef.this.colonna8 = l_row.colonna8;
      MemoryCursorRow_mcdatistru_mcrdef.this.colonna9 = l_row.colonna9;
      MemoryCursorRow_mcdatistru_mcrdef.this.colonna10 = l_row.colonna10;
      MemoryCursorRow_mcdatistru_mcrdef.this.colonna11 = l_row.colonna11;
      MemoryCursorRow_mcdatistru_mcrdef.this.colonna12 = l_row.colonna12;
      MemoryCursorRow_mcdatistru_mcrdef.this.colonna13 = l_row.colonna13;
      MemoryCursorRow_mcdatistru_mcrdef.this.colonna14 = l_row.colonna14;
      MemoryCursorRow_mcdatistru_mcrdef.this.colonna15 = l_row.colonna15;
      MemoryCursorRow_mcdatistru_mcrdef.this.colonna16 = l_row.colonna16;
      MemoryCursorRow_mcdatistru_mcrdef.this.colonna17 = l_row.colonna17;
      MemoryCursorRow_mcdatistru_mcrdef.this.colonna18 = l_row.colonna18;
      MemoryCursorRow_mcdatistru_mcrdef.this.colonna19 = l_row.colonna19;
      MemoryCursorRow_mcdatistru_mcrdef.this.colonna20 = l_row.colonna20;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcdatistru_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcdatistru_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcdatistru_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcdatistru_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcdatistru_mcrdef p_From,MemoryCursorRow_mcdatistru_mcrdef p_To) {
        p_To.colonna1 = copyAndCast(p_From.colonna1);
        p_To.colonna2 = copyAndCast(p_From.colonna2);
        p_To.colonna3 = copyAndCast(p_From.colonna3);
        p_To.colonna4 = copyAndCast(p_From.colonna4);
        p_To.colonna5 = copyAndCast(p_From.colonna5);
        p_To.colonna6 = copyAndCast(p_From.colonna6);
        p_To.colonna7 = copyAndCast(p_From.colonna7);
        p_To.colonna8 = copyAndCast(p_From.colonna8);
        p_To.colonna9 = copyAndCast(p_From.colonna9);
        p_To.colonna10 = copyAndCast(p_From.colonna10);
        p_To.colonna11 = copyAndCast(p_From.colonna11);
        p_To.colonna12 = copyAndCast(p_From.colonna12);
        p_To.colonna13 = copyAndCast(p_From.colonna13);
        p_To.colonna14 = copyAndCast(p_From.colonna14);
        p_To.colonna15 = copyAndCast(p_From.colonna15);
        p_To.colonna16 = copyAndCast(p_From.colonna16);
        p_To.colonna17 = copyAndCast(p_From.colonna17);
        p_To.colonna18 = copyAndCast(p_From.colonna18);
        p_To.colonna19 = copyAndCast(p_From.colonna19);
        p_To.colonna20 = copyAndCast(p_From.colonna20);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"colonna1","colonna2","colonna3","colonna4","colonna5","colonna6","colonna7","colonna8","colonna9","colonna10","colonna11","colonna12","colonna13","colonna14","colonna15","colonna16","colonna17","colonna18","colonna19","colonna20"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"","","","","","","","","","","","","","","","","","","",""};
    return l_names;
  }
}
