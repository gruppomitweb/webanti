public class MemoryCursorRow_mcchkperiodo_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcchkperiodo_mcrdef() {
  }
  public MemoryCursorRow_mcchkperiodo_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcchkperiodo_mcrdef toBuild = new MemoryCursor_mcchkperiodo_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcchkperiodo_mcrdef toBuild = new MemoryCursor_mcchkperiodo_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String IDBASE = "";
  String RAPPORTO = "";
  String CODINTER = "";
  java.sql.Date DATAINI = CPLib.NullDate();
  java.sql.Date DATAFINE = CPLib.NullDate();
  String CODFISC = "";
  String TIPO = "";
  String RIFIMP = "";
  String INFORM = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAINI))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAFINE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODFISC))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPO))) {
      return false;
    }
    if ( ! (CPLib.Empty(RIFIMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(INFORM))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcchkperiodo_mcrdef p_row) {
    MemoryCursorRow_mcchkperiodo_mcrdef l_row = new MemoryCursorRow_mcchkperiodo_mcrdef();
    CopyOperation<MemoryCursorRow_mcchkperiodo_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcchkperiodo_mcrdef.this.IDBASE = l_row.IDBASE;
      MemoryCursorRow_mcchkperiodo_mcrdef.this.RAPPORTO = l_row.RAPPORTO;
      MemoryCursorRow_mcchkperiodo_mcrdef.this.CODINTER = l_row.CODINTER;
      MemoryCursorRow_mcchkperiodo_mcrdef.this.DATAINI = l_row.DATAINI;
      MemoryCursorRow_mcchkperiodo_mcrdef.this.DATAFINE = l_row.DATAFINE;
      MemoryCursorRow_mcchkperiodo_mcrdef.this.CODFISC = l_row.CODFISC;
      MemoryCursorRow_mcchkperiodo_mcrdef.this.TIPO = l_row.TIPO;
      MemoryCursorRow_mcchkperiodo_mcrdef.this.RIFIMP = l_row.RIFIMP;
      MemoryCursorRow_mcchkperiodo_mcrdef.this.INFORM = l_row.INFORM;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcchkperiodo_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcchkperiodo_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcchkperiodo_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcchkperiodo_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcchkperiodo_mcrdef p_From,MemoryCursorRow_mcchkperiodo_mcrdef p_To) {
        p_To.IDBASE = copyAndCast(p_From.IDBASE);
        p_To.RAPPORTO = copyAndCast(p_From.RAPPORTO);
        p_To.CODINTER = copyAndCast(p_From.CODINTER);
        p_To.DATAINI = copyAndCast(p_From.DATAINI);
        p_To.DATAFINE = copyAndCast(p_From.DATAFINE);
        p_To.CODFISC = copyAndCast(p_From.CODFISC);
        p_To.TIPO = copyAndCast(p_From.TIPO);
        p_To.RIFIMP = copyAndCast(p_From.RIFIMP);
        p_To.INFORM = copyAndCast(p_From.INFORM);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"IDBASE","RAPPORTO","CODINTER","DATAINI","DATAFINE","CODFISC","TIPO","RIFIMP","INFORM"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","D","D","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"ID Base","Codice Rapporto/Opex","NDG","Data Inizio","Data Fine","Codice Fiscale","Tipo","Rif. Import 1","Rif. Import 2"};
    return l_names;
  }
}
