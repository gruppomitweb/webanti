public class MemoryCursorRow_mcpersonstorico_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcpersonstorico_mcrdef() {
  }
  public MemoryCursorRow_mcpersonstorico_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcpersonstorico_mcrdef toBuild = new MemoryCursor_mcpersonstorico_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcpersonstorico_mcrdef toBuild = new MemoryCursor_mcpersonstorico_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CONNES = "";
  String CODFISC = "";
  String RAGSOC = "";
  String CAP = "";
  String CAB = "";
  String PAESE = "";
  String DESCCIT = "";
  String PROVINCIA = "";
  java.sql.Date DATANASC = CPLib.NullDate();
  String IDNASSTATO = "";
  String PIVA = "";
  String NOSARA = "";
  String TIPOPERS = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CONNES))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODFISC))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGSOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCCIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVINCIA))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATANASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDNASSTATO))) {
      return false;
    }
    if ( ! (CPLib.Empty(PIVA))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOSARA))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOPERS))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcpersonstorico_mcrdef p_row) {
    MemoryCursorRow_mcpersonstorico_mcrdef l_row = new MemoryCursorRow_mcpersonstorico_mcrdef();
    CopyOperation<MemoryCursorRow_mcpersonstorico_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcpersonstorico_mcrdef.this.CONNES = l_row.CONNES;
      MemoryCursorRow_mcpersonstorico_mcrdef.this.CODFISC = l_row.CODFISC;
      MemoryCursorRow_mcpersonstorico_mcrdef.this.RAGSOC = l_row.RAGSOC;
      MemoryCursorRow_mcpersonstorico_mcrdef.this.CAP = l_row.CAP;
      MemoryCursorRow_mcpersonstorico_mcrdef.this.CAB = l_row.CAB;
      MemoryCursorRow_mcpersonstorico_mcrdef.this.PAESE = l_row.PAESE;
      MemoryCursorRow_mcpersonstorico_mcrdef.this.DESCCIT = l_row.DESCCIT;
      MemoryCursorRow_mcpersonstorico_mcrdef.this.PROVINCIA = l_row.PROVINCIA;
      MemoryCursorRow_mcpersonstorico_mcrdef.this.DATANASC = l_row.DATANASC;
      MemoryCursorRow_mcpersonstorico_mcrdef.this.IDNASSTATO = l_row.IDNASSTATO;
      MemoryCursorRow_mcpersonstorico_mcrdef.this.PIVA = l_row.PIVA;
      MemoryCursorRow_mcpersonstorico_mcrdef.this.NOSARA = l_row.NOSARA;
      MemoryCursorRow_mcpersonstorico_mcrdef.this.TIPOPERS = l_row.TIPOPERS;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcpersonstorico_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcpersonstorico_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcpersonstorico_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcpersonstorico_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcpersonstorico_mcrdef p_From,MemoryCursorRow_mcpersonstorico_mcrdef p_To) {
        p_To.CONNES = copyAndCast(p_From.CONNES);
        p_To.CODFISC = copyAndCast(p_From.CODFISC);
        p_To.RAGSOC = copyAndCast(p_From.RAGSOC);
        p_To.CAP = copyAndCast(p_From.CAP);
        p_To.CAB = copyAndCast(p_From.CAB);
        p_To.PAESE = copyAndCast(p_From.PAESE);
        p_To.DESCCIT = copyAndCast(p_From.DESCCIT);
        p_To.PROVINCIA = copyAndCast(p_From.PROVINCIA);
        p_To.DATANASC = copyAndCast(p_From.DATANASC);
        p_To.IDNASSTATO = copyAndCast(p_From.IDNASSTATO);
        p_To.PIVA = copyAndCast(p_From.PIVA);
        p_To.NOSARA = copyAndCast(p_From.NOSARA);
        p_To.TIPOPERS = copyAndCast(p_From.TIPOPERS);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CONNES","CODFISC","RAGSOC","CAP","CAB","PAESE","DESCCIT","PROVINCIA","DATANASC","IDNASSTATO","PIVA","NOSARA","TIPOPERS"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","D","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"","","","","","","","","","","","",""};
    return l_names;
  }
}
