public class MemoryCursorRow_mca7_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mca7_mcrdef() {
  }
  public MemoryCursorRow_mca7_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mca7_mcrdef toBuild = new MemoryCursor_mca7_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mca7_mcrdef toBuild = new MemoryCursor_mca7_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String IDFENOMENO = "";
  double IMPORTO = 0;
  String DURATA = "";
  String DIVISA = "";
  String RESIDENZA = "";
  String ATTR0 = "";
  String DATO0 = "";
  String ATTR1 = "";
  String DATO1 = "";
  String ATTR2 = "";
  String DATO2 = "";
  String ATTR3 = "";
  String DATO3 = "";
  String ATTR4 = "";
  String DATO4 = "";
  String ATTR5 = "";
  String DATO5 = "";
  String ATTR6 = "";
  String DATO6 = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(IDFENOMENO))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DURATA))) {
      return false;
    }
    if ( ! (CPLib.Empty(DIVISA))) {
      return false;
    }
    if ( ! (CPLib.Empty(RESIDENZA))) {
      return false;
    }
    if ( ! (CPLib.Empty(ATTR0))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATO0))) {
      return false;
    }
    if ( ! (CPLib.Empty(ATTR1))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATO1))) {
      return false;
    }
    if ( ! (CPLib.Empty(ATTR2))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATO2))) {
      return false;
    }
    if ( ! (CPLib.Empty(ATTR3))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATO3))) {
      return false;
    }
    if ( ! (CPLib.Empty(ATTR4))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATO4))) {
      return false;
    }
    if ( ! (CPLib.Empty(ATTR5))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATO5))) {
      return false;
    }
    if ( ! (CPLib.Empty(ATTR6))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATO6))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mca7_mcrdef p_row) {
    MemoryCursorRow_mca7_mcrdef l_row = new MemoryCursorRow_mca7_mcrdef();
    CopyOperation<MemoryCursorRow_mca7_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mca7_mcrdef.this.IDFENOMENO = l_row.IDFENOMENO;
      MemoryCursorRow_mca7_mcrdef.this.IMPORTO = l_row.IMPORTO;
      MemoryCursorRow_mca7_mcrdef.this.DURATA = l_row.DURATA;
      MemoryCursorRow_mca7_mcrdef.this.DIVISA = l_row.DIVISA;
      MemoryCursorRow_mca7_mcrdef.this.RESIDENZA = l_row.RESIDENZA;
      MemoryCursorRow_mca7_mcrdef.this.ATTR0 = l_row.ATTR0;
      MemoryCursorRow_mca7_mcrdef.this.DATO0 = l_row.DATO0;
      MemoryCursorRow_mca7_mcrdef.this.ATTR1 = l_row.ATTR1;
      MemoryCursorRow_mca7_mcrdef.this.DATO1 = l_row.DATO1;
      MemoryCursorRow_mca7_mcrdef.this.ATTR2 = l_row.ATTR2;
      MemoryCursorRow_mca7_mcrdef.this.DATO2 = l_row.DATO2;
      MemoryCursorRow_mca7_mcrdef.this.ATTR3 = l_row.ATTR3;
      MemoryCursorRow_mca7_mcrdef.this.DATO3 = l_row.DATO3;
      MemoryCursorRow_mca7_mcrdef.this.ATTR4 = l_row.ATTR4;
      MemoryCursorRow_mca7_mcrdef.this.DATO4 = l_row.DATO4;
      MemoryCursorRow_mca7_mcrdef.this.ATTR5 = l_row.ATTR5;
      MemoryCursorRow_mca7_mcrdef.this.DATO5 = l_row.DATO5;
      MemoryCursorRow_mca7_mcrdef.this.ATTR6 = l_row.ATTR6;
      MemoryCursorRow_mca7_mcrdef.this.DATO6 = l_row.DATO6;
    }
  }
  protected CopyOperation<MemoryCursorRow_mca7_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mca7_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mca7_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mca7_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mca7_mcrdef p_From,MemoryCursorRow_mca7_mcrdef p_To) {
        p_To.IDFENOMENO = copyAndCast(p_From.IDFENOMENO);
        p_To.IMPORTO = copyAndCast(p_From.IMPORTO);
        p_To.DURATA = copyAndCast(p_From.DURATA);
        p_To.DIVISA = copyAndCast(p_From.DIVISA);
        p_To.RESIDENZA = copyAndCast(p_From.RESIDENZA);
        p_To.ATTR0 = copyAndCast(p_From.ATTR0);
        p_To.DATO0 = copyAndCast(p_From.DATO0);
        p_To.ATTR1 = copyAndCast(p_From.ATTR1);
        p_To.DATO1 = copyAndCast(p_From.DATO1);
        p_To.ATTR2 = copyAndCast(p_From.ATTR2);
        p_To.DATO2 = copyAndCast(p_From.DATO2);
        p_To.ATTR3 = copyAndCast(p_From.ATTR3);
        p_To.DATO3 = copyAndCast(p_From.DATO3);
        p_To.ATTR4 = copyAndCast(p_From.ATTR4);
        p_To.DATO4 = copyAndCast(p_From.DATO4);
        p_To.ATTR5 = copyAndCast(p_From.ATTR5);
        p_To.DATO5 = copyAndCast(p_From.DATO5);
        p_To.ATTR6 = copyAndCast(p_From.ATTR6);
        p_To.DATO6 = copyAndCast(p_From.DATO6);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"IDFENOMENO","IMPORTO","DURATA","DIVISA","RESIDENZA","ATTR0","DATO0","ATTR1","DATO1","ATTR2","DATO2","ATTR3","DATO3","ATTR4","DATO4","ATTR5","DATO5","ATTR6","DATO6"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","N","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Voce+Sottovoce","Import/Quantità","Durata","Divisa/Valuta","Residenza","Attributo 0","Dato 0","Attributo 1","Dato 1","Attributo 2","Dato 2","Attributo 3","Dato 3","Attributo 4","Dato 4","Attributo 5","Dato 5","Attributo 6","Dato 6"};
    return l_names;
  }
}
