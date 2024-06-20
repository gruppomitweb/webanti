public class MemoryCursorRow_mcesitierr_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcesitierr_mcrdef() {
  }
  public MemoryCursorRow_mcesitierr_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcesitierr_mcrdef toBuild = new MemoryCursor_mcesitierr_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcesitierr_mcrdef toBuild = new MemoryCursor_mcesitierr_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String UNIQUECODE = "";
  String RAPPORTO = "";
  String TIPORAP = "";
  String NDGSOG = "";
  String ERRMSG = "";
  String DATOMIT = "";
  String DATOAGE = "";
  String COGNOME = "";
  String NOME = "";
  String CODFISC = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(UNIQUECODE))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPORAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(NDGSOG))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERRMSG))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATOMIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATOAGE))) {
      return false;
    }
    if ( ! (CPLib.Empty(COGNOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODFISC))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcesitierr_mcrdef p_row) {
    MemoryCursorRow_mcesitierr_mcrdef l_row = new MemoryCursorRow_mcesitierr_mcrdef();
    CopyOperation<MemoryCursorRow_mcesitierr_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcesitierr_mcrdef.this.UNIQUECODE = l_row.UNIQUECODE;
      MemoryCursorRow_mcesitierr_mcrdef.this.RAPPORTO = l_row.RAPPORTO;
      MemoryCursorRow_mcesitierr_mcrdef.this.TIPORAP = l_row.TIPORAP;
      MemoryCursorRow_mcesitierr_mcrdef.this.NDGSOG = l_row.NDGSOG;
      MemoryCursorRow_mcesitierr_mcrdef.this.ERRMSG = l_row.ERRMSG;
      MemoryCursorRow_mcesitierr_mcrdef.this.DATOMIT = l_row.DATOMIT;
      MemoryCursorRow_mcesitierr_mcrdef.this.DATOAGE = l_row.DATOAGE;
      MemoryCursorRow_mcesitierr_mcrdef.this.COGNOME = l_row.COGNOME;
      MemoryCursorRow_mcesitierr_mcrdef.this.NOME = l_row.NOME;
      MemoryCursorRow_mcesitierr_mcrdef.this.CODFISC = l_row.CODFISC;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcesitierr_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcesitierr_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcesitierr_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcesitierr_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcesitierr_mcrdef p_From,MemoryCursorRow_mcesitierr_mcrdef p_To) {
        p_To.UNIQUECODE = copyAndCast(p_From.UNIQUECODE);
        p_To.RAPPORTO = copyAndCast(p_From.RAPPORTO);
        p_To.TIPORAP = copyAndCast(p_From.TIPORAP);
        p_To.NDGSOG = copyAndCast(p_From.NDGSOG);
        p_To.ERRMSG = copyAndCast(p_From.ERRMSG);
        p_To.DATOMIT = copyAndCast(p_From.DATOMIT);
        p_To.DATOAGE = copyAndCast(p_From.DATOAGE);
        p_To.COGNOME = copyAndCast(p_From.COGNOME);
        p_To.NOME = copyAndCast(p_From.NOME);
        p_To.CODFISC = copyAndCast(p_From.CODFISC);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"UNIQUECODE","RAPPORTO","TIPORAP","NDGSOG","ERRMSG","DATOMIT","DATOAGE","COGNOME","NOME","CODFISC"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","M","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Univoco","Rapporto","O-Opex - R-Rapporto","NDG Soggetto","Errori","Dato MIT","Dato AGE","Cognome","Nome","Codice Fiscale"};
    return l_names;
  }
}
