public class MemoryCursorRow_mcanarap_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcanarap_mcrdef() {
  }
  public MemoryCursorRow_mcanarap_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcanarap_mcrdef toBuild = new MemoryCursor_mcanarap_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcanarap_mcrdef toBuild = new MemoryCursor_mcanarap_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String RAPPORTO = "";
  String TIPOAG = "";
  String VALUTA = "";
  java.sql.Date DATAINI = CPLib.NullDate();
  java.sql.Date DATAFINE = CPLib.NullDate();
  String CODDIPE = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOAG))) {
      return false;
    }
    if ( ! (CPLib.Empty(VALUTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAINI))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAFINE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODDIPE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcanarap_mcrdef p_row) {
    MemoryCursorRow_mcanarap_mcrdef l_row = new MemoryCursorRow_mcanarap_mcrdef();
    CopyOperation<MemoryCursorRow_mcanarap_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcanarap_mcrdef.this.RAPPORTO = l_row.RAPPORTO;
      MemoryCursorRow_mcanarap_mcrdef.this.TIPOAG = l_row.TIPOAG;
      MemoryCursorRow_mcanarap_mcrdef.this.VALUTA = l_row.VALUTA;
      MemoryCursorRow_mcanarap_mcrdef.this.DATAINI = l_row.DATAINI;
      MemoryCursorRow_mcanarap_mcrdef.this.DATAFINE = l_row.DATAFINE;
      MemoryCursorRow_mcanarap_mcrdef.this.CODDIPE = l_row.CODDIPE;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcanarap_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcanarap_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcanarap_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcanarap_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcanarap_mcrdef p_From,MemoryCursorRow_mcanarap_mcrdef p_To) {
        p_To.RAPPORTO = copyAndCast(p_From.RAPPORTO);
        p_To.TIPOAG = copyAndCast(p_From.TIPOAG);
        p_To.VALUTA = copyAndCast(p_From.VALUTA);
        p_To.DATAINI = copyAndCast(p_From.DATAINI);
        p_To.DATAFINE = copyAndCast(p_From.DATAFINE);
        p_To.CODDIPE = copyAndCast(p_From.CODDIPE);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"RAPPORTO","TIPOAG","VALUTA","DATAINI","DATAFINE","CODDIPE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","D","D","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Rapporto","Tipo Rapporto","Codice Valuta","Data Inizio Rapporto","Data Fine Rapporto","Codice Dimpendenza"};
    return l_names;
  }
}
