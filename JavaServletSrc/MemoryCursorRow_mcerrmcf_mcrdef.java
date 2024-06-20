public class MemoryCursorRow_mcerrmcf_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcerrmcf_mcrdef() {
  }
  public MemoryCursorRow_mcerrmcf_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcerrmcf_mcrdef toBuild = new MemoryCursor_mcerrmcf_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcerrmcf_mcrdef toBuild = new MemoryCursor_mcerrmcf_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String ERCODICE = "";
  String ERDESCRI = "";
  String ERTESTO = "";
  String ERAZIONE = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(ERCODICE))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERDESCRI))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERTESTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERAZIONE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcerrmcf_mcrdef p_row) {
    MemoryCursorRow_mcerrmcf_mcrdef l_row = new MemoryCursorRow_mcerrmcf_mcrdef();
    CopyOperation<MemoryCursorRow_mcerrmcf_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcerrmcf_mcrdef.this.ERCODICE = l_row.ERCODICE;
      MemoryCursorRow_mcerrmcf_mcrdef.this.ERDESCRI = l_row.ERDESCRI;
      MemoryCursorRow_mcerrmcf_mcrdef.this.ERTESTO = l_row.ERTESTO;
      MemoryCursorRow_mcerrmcf_mcrdef.this.ERAZIONE = l_row.ERAZIONE;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcerrmcf_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcerrmcf_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcerrmcf_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcerrmcf_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcerrmcf_mcrdef p_From,MemoryCursorRow_mcerrmcf_mcrdef p_To) {
        p_To.ERCODICE = copyAndCast(p_From.ERCODICE);
        p_To.ERDESCRI = copyAndCast(p_From.ERDESCRI);
        p_To.ERTESTO = copyAndCast(p_From.ERTESTO);
        p_To.ERAZIONE = copyAndCast(p_From.ERAZIONE);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"ERCODICE","ERDESCRI","ERTESTO","ERAZIONE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice","Descrizione","Note","Azione / Esito"};
    return l_names;
  }
}
