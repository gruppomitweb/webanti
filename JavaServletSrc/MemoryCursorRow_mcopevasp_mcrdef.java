public class MemoryCursorRow_mcopevasp_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcopevasp_mcrdef() {
  }
  public MemoryCursorRow_mcopevasp_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcopevasp_mcrdef toBuild = new MemoryCursor_mcopevasp_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcopevasp_mcrdef toBuild = new MemoryCursor_mcopevasp_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODICE = "";
  double OPERAZIONI = 0;
  double IMPORTO = 0;
  double TOTIMPIN = 0;
  double TOTIMPOUT = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODICE))) {
      return false;
    }
    if ( ! (CPLib.Empty(OPERAZIONI))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTIMPIN))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTIMPOUT))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcopevasp_mcrdef p_row) {
    MemoryCursorRow_mcopevasp_mcrdef l_row = new MemoryCursorRow_mcopevasp_mcrdef();
    CopyOperation<MemoryCursorRow_mcopevasp_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcopevasp_mcrdef.this.CODICE = l_row.CODICE;
      MemoryCursorRow_mcopevasp_mcrdef.this.OPERAZIONI = l_row.OPERAZIONI;
      MemoryCursorRow_mcopevasp_mcrdef.this.IMPORTO = l_row.IMPORTO;
      MemoryCursorRow_mcopevasp_mcrdef.this.TOTIMPIN = l_row.TOTIMPIN;
      MemoryCursorRow_mcopevasp_mcrdef.this.TOTIMPOUT = l_row.TOTIMPOUT;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcopevasp_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcopevasp_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcopevasp_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcopevasp_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcopevasp_mcrdef p_From,MemoryCursorRow_mcopevasp_mcrdef p_To) {
        p_To.CODICE = copyAndCast(p_From.CODICE);
        p_To.OPERAZIONI = copyAndCast(p_From.OPERAZIONI);
        p_To.IMPORTO = copyAndCast(p_From.IMPORTO);
        p_To.TOTIMPIN = copyAndCast(p_From.TOTIMPIN);
        p_To.TOTIMPOUT = copyAndCast(p_From.TOTIMPOUT);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODICE","OPERAZIONI","IMPORTO","TOTIMPIN","TOTIMPOUT"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","N","N","N","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice VASP","Operazioni","Importo","Totale IMPIN","Totale IMPOUT"};
    return l_names;
  }
}
