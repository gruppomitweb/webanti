public class MemoryCursorRow_mcopefrazstorico_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcopefrazstorico_mcrdef() {
  }
  public MemoryCursorRow_mcopefrazstorico_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcopefrazstorico_mcrdef toBuild = new MemoryCursor_mcopefrazstorico_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcopefrazstorico_mcrdef toBuild = new MemoryCursor_mcopefrazstorico_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String NUMPROG = "";
  java.sql.Date DATAOPE = CPLib.NullDate();
  java.sql.Date DATAREG = CPLib.NullDate();
  String CAUSALE = "";
  double IMPORTO = 0;
  String VALUTA = "";
  String CONNESCLI = "";
  String DESCRI = "";
  String STATOREG = "";
  String TIPOARCH = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(NUMPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAREG))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAUSALE))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(VALUTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESCLI))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRI))) {
      return false;
    }
    if ( ! (CPLib.Empty(STATOREG))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOARCH))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcopefrazstorico_mcrdef p_row) {
    MemoryCursorRow_mcopefrazstorico_mcrdef l_row = new MemoryCursorRow_mcopefrazstorico_mcrdef();
    CopyOperation<MemoryCursorRow_mcopefrazstorico_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcopefrazstorico_mcrdef.this.NUMPROG = l_row.NUMPROG;
      MemoryCursorRow_mcopefrazstorico_mcrdef.this.DATAOPE = l_row.DATAOPE;
      MemoryCursorRow_mcopefrazstorico_mcrdef.this.DATAREG = l_row.DATAREG;
      MemoryCursorRow_mcopefrazstorico_mcrdef.this.CAUSALE = l_row.CAUSALE;
      MemoryCursorRow_mcopefrazstorico_mcrdef.this.IMPORTO = l_row.IMPORTO;
      MemoryCursorRow_mcopefrazstorico_mcrdef.this.VALUTA = l_row.VALUTA;
      MemoryCursorRow_mcopefrazstorico_mcrdef.this.CONNESCLI = l_row.CONNESCLI;
      MemoryCursorRow_mcopefrazstorico_mcrdef.this.DESCRI = l_row.DESCRI;
      MemoryCursorRow_mcopefrazstorico_mcrdef.this.STATOREG = l_row.STATOREG;
      MemoryCursorRow_mcopefrazstorico_mcrdef.this.TIPOARCH = l_row.TIPOARCH;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcopefrazstorico_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcopefrazstorico_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcopefrazstorico_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcopefrazstorico_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcopefrazstorico_mcrdef p_From,MemoryCursorRow_mcopefrazstorico_mcrdef p_To) {
        p_To.NUMPROG = copyAndCast(p_From.NUMPROG);
        p_To.DATAOPE = copyAndCast(p_From.DATAOPE);
        p_To.DATAREG = copyAndCast(p_From.DATAREG);
        p_To.CAUSALE = copyAndCast(p_From.CAUSALE);
        p_To.IMPORTO = copyAndCast(p_From.IMPORTO);
        p_To.VALUTA = copyAndCast(p_From.VALUTA);
        p_To.CONNESCLI = copyAndCast(p_From.CONNESCLI);
        p_To.DESCRI = copyAndCast(p_From.DESCRI);
        p_To.STATOREG = copyAndCast(p_From.STATOREG);
        p_To.TIPOARCH = copyAndCast(p_From.TIPOARCH);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"NUMPROG","DATAOPE","DATAREG","CAUSALE","IMPORTO","VALUTA","CONNESCLI","DESCRI","STATOREG","TIPOARCH"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","D","D","C","N","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"","","","","","","","","","Aui/Entrate"};
    return l_names;
  }
}
