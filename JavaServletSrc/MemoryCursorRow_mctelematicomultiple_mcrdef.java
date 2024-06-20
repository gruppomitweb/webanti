public class MemoryCursorRow_mctelematicomultiple_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mctelematicomultiple_mcrdef() {
  }
  public MemoryCursorRow_mctelematicomultiple_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mctelematicomultiple_mcrdef toBuild = new MemoryCursor_mctelematicomultiple_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mctelematicomultiple_mcrdef toBuild = new MemoryCursor_mctelematicomultiple_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String SNAINUMOPE = "";
  String ENV = "";
  String IDMULTIPLA = "";
  double TOTLIRE = 0;
  double CACODICE = 0;
  java.sql.Timestamp CADATAORA = CPLib.NullDateTime();
  String CAIDBIGLIETTO = "";
  String CODLOB = "";
  String TIPOGIOCO = "";
  double CATIPGIO = 0;
  double CATIPCON = 0;
  String TROVATO = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(SNAINUMOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(ENV))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDMULTIPLA))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTLIRE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CACODICE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CADATAORA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAIDBIGLIETTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODLOB))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOGIOCO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CATIPGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CATIPCON))) {
      return false;
    }
    if ( ! (CPLib.Empty(TROVATO))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mctelematicomultiple_mcrdef p_row) {
    MemoryCursorRow_mctelematicomultiple_mcrdef l_row = new MemoryCursorRow_mctelematicomultiple_mcrdef();
    CopyOperation<MemoryCursorRow_mctelematicomultiple_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mctelematicomultiple_mcrdef.this.SNAINUMOPE = l_row.SNAINUMOPE;
      MemoryCursorRow_mctelematicomultiple_mcrdef.this.ENV = l_row.ENV;
      MemoryCursorRow_mctelematicomultiple_mcrdef.this.IDMULTIPLA = l_row.IDMULTIPLA;
      MemoryCursorRow_mctelematicomultiple_mcrdef.this.TOTLIRE = l_row.TOTLIRE;
      MemoryCursorRow_mctelematicomultiple_mcrdef.this.CACODICE = l_row.CACODICE;
      MemoryCursorRow_mctelematicomultiple_mcrdef.this.CADATAORA = l_row.CADATAORA;
      MemoryCursorRow_mctelematicomultiple_mcrdef.this.CAIDBIGLIETTO = l_row.CAIDBIGLIETTO;
      MemoryCursorRow_mctelematicomultiple_mcrdef.this.CODLOB = l_row.CODLOB;
      MemoryCursorRow_mctelematicomultiple_mcrdef.this.TIPOGIOCO = l_row.TIPOGIOCO;
      MemoryCursorRow_mctelematicomultiple_mcrdef.this.CATIPGIO = l_row.CATIPGIO;
      MemoryCursorRow_mctelematicomultiple_mcrdef.this.CATIPCON = l_row.CATIPCON;
      MemoryCursorRow_mctelematicomultiple_mcrdef.this.TROVATO = l_row.TROVATO;
    }
  }
  protected CopyOperation<MemoryCursorRow_mctelematicomultiple_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mctelematicomultiple_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mctelematicomultiple_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mctelematicomultiple_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mctelematicomultiple_mcrdef p_From,MemoryCursorRow_mctelematicomultiple_mcrdef p_To) {
        p_To.SNAINUMOPE = copyAndCast(p_From.SNAINUMOPE);
        p_To.ENV = copyAndCast(p_From.ENV);
        p_To.IDMULTIPLA = copyAndCast(p_From.IDMULTIPLA);
        p_To.TOTLIRE = copyAndCast(p_From.TOTLIRE);
        p_To.CACODICE = copyAndCast(p_From.CACODICE);
        p_To.CADATAORA = copyAndCast(p_From.CADATAORA);
        p_To.CAIDBIGLIETTO = copyAndCast(p_From.CAIDBIGLIETTO);
        p_To.CODLOB = copyAndCast(p_From.CODLOB);
        p_To.TIPOGIOCO = copyAndCast(p_From.TIPOGIOCO);
        p_To.CATIPGIO = copyAndCast(p_From.CATIPGIO);
        p_To.CATIPCON = copyAndCast(p_From.CATIPCON);
        p_To.TROVATO = copyAndCast(p_From.TROVATO);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"SNAINUMOPE","ENV","IDMULTIPLA","TOTLIRE","CACODICE","CADATAORA","CAIDBIGLIETTO","CODLOB","TIPOGIOCO","CATIPGIO","CATIPCON","TROVATO"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","N","N","T","C","C","C","N","N","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"","","","","","","","","","","",""};
    return l_names;
  }
}
