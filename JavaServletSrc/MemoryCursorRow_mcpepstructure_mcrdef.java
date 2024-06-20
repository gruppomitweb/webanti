public class MemoryCursorRow_mcpepstructure_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcpepstructure_mcrdef() {
  }
  public MemoryCursorRow_mcpepstructure_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcpepstructure_mcrdef toBuild = new MemoryCursor_mcpepstructure_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcpepstructure_mcrdef toBuild = new MemoryCursor_mcpepstructure_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String PEPCOG = "";
  String PEPNOM = "";
  java.sql.Date PEPNAS = CPLib.NullDate();
  java.sql.Date PEPMOR = CPLib.NullDate();
  String PEPCAT = "";
  String PEPLNAS = "";
  String PEPPNAS = "";
  double PEPPER = 0;
  String PEPINC = "";
  String PEPTICKET = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(PEPCOG))) {
      return false;
    }
    if ( ! (CPLib.Empty(PEPNOM))) {
      return false;
    }
    if ( ! (CPLib.Empty(PEPNAS))) {
      return false;
    }
    if ( ! (CPLib.Empty(PEPMOR))) {
      return false;
    }
    if ( ! (CPLib.Empty(PEPCAT))) {
      return false;
    }
    if ( ! (CPLib.Empty(PEPLNAS))) {
      return false;
    }
    if ( ! (CPLib.Empty(PEPPNAS))) {
      return false;
    }
    if ( ! (CPLib.Empty(PEPPER))) {
      return false;
    }
    if ( ! (CPLib.Empty(PEPINC))) {
      return false;
    }
    if ( ! (CPLib.Empty(PEPTICKET))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcpepstructure_mcrdef p_row) {
    MemoryCursorRow_mcpepstructure_mcrdef l_row = new MemoryCursorRow_mcpepstructure_mcrdef();
    CopyOperation<MemoryCursorRow_mcpepstructure_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcpepstructure_mcrdef.this.PEPCOG = l_row.PEPCOG;
      MemoryCursorRow_mcpepstructure_mcrdef.this.PEPNOM = l_row.PEPNOM;
      MemoryCursorRow_mcpepstructure_mcrdef.this.PEPNAS = l_row.PEPNAS;
      MemoryCursorRow_mcpepstructure_mcrdef.this.PEPMOR = l_row.PEPMOR;
      MemoryCursorRow_mcpepstructure_mcrdef.this.PEPCAT = l_row.PEPCAT;
      MemoryCursorRow_mcpepstructure_mcrdef.this.PEPLNAS = l_row.PEPLNAS;
      MemoryCursorRow_mcpepstructure_mcrdef.this.PEPPNAS = l_row.PEPPNAS;
      MemoryCursorRow_mcpepstructure_mcrdef.this.PEPPER = l_row.PEPPER;
      MemoryCursorRow_mcpepstructure_mcrdef.this.PEPINC = l_row.PEPINC;
      MemoryCursorRow_mcpepstructure_mcrdef.this.PEPTICKET = l_row.PEPTICKET;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcpepstructure_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcpepstructure_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcpepstructure_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcpepstructure_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcpepstructure_mcrdef p_From,MemoryCursorRow_mcpepstructure_mcrdef p_To) {
        p_To.PEPCOG = copyAndCast(p_From.PEPCOG);
        p_To.PEPNOM = copyAndCast(p_From.PEPNOM);
        p_To.PEPNAS = copyAndCast(p_From.PEPNAS);
        p_To.PEPMOR = copyAndCast(p_From.PEPMOR);
        p_To.PEPCAT = copyAndCast(p_From.PEPCAT);
        p_To.PEPLNAS = copyAndCast(p_From.PEPLNAS);
        p_To.PEPPNAS = copyAndCast(p_From.PEPPNAS);
        p_To.PEPPER = copyAndCast(p_From.PEPPER);
        p_To.PEPINC = copyAndCast(p_From.PEPINC);
        p_To.PEPTICKET = copyAndCast(p_From.PEPTICKET);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"PEPCOG","PEPNOM","PEPNAS","PEPMOR","PEPCAT","PEPLNAS","PEPPNAS","PEPPER","PEPINC","PEPTICKET"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","D","D","C","C","C","N","M","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Cognome","Nome","Data di Nascita","Data di Morte","Categoria PEP","Luogo Nascita","Prov. Nascita","Percentuale","Motivo Inclusione","Ticket da salvare"};
    return l_names;
  }
}
