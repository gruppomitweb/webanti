public class MemoryCursorRow_qbe_estr_trim_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_estr_trim_vqr() {
  }
  public MemoryCursorRow_qbe_estr_trim_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_estr_trim_vqr toBuild = new MemoryCursor_qbe_estr_trim_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_estr_trim_vqr toBuild = new MemoryCursor_qbe_estr_trim_vqr();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String IDBASE = "";
  String TIPOSOGGETTO = "";
  String RAPSEGNA = "";
  String CODICEGLN = "";
  String ABIINTER = "";
  String ABIPROPR = "";
  String TIPOATTIV = "";
  double NBANCONOTE = 0;
  double TAGLIO = 0;
  String GLNALTRASC = "";
  String GLNALTROSOG = "";
  String CODCLICON = "";
  String CODCOMCON = "";
  String ATECO_CON = "";
  String CONNES = "";
  String ATTIV = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOSOGGETTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPSEGNA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODICEGLN))) {
      return false;
    }
    if ( ! (CPLib.Empty(ABIINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(ABIPROPR))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOATTIV))) {
      return false;
    }
    if ( ! (CPLib.Empty(NBANCONOTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TAGLIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(GLNALTRASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(GLNALTROSOG))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCLICON))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCOMCON))) {
      return false;
    }
    if ( ! (CPLib.Empty(ATECO_CON))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNES))) {
      return false;
    }
    if ( ! (CPLib.Empty(ATTIV))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_qbe_estr_trim_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_estr_trim_vqr.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_qbe_estr_trim_vqr.this.TIPOSOGGETTO = copyAndCast(p_row.TIPOSOGGETTO);
      MemoryCursorRow_qbe_estr_trim_vqr.this.RAPSEGNA = copyAndCast(p_row.RAPSEGNA);
      MemoryCursorRow_qbe_estr_trim_vqr.this.CODICEGLN = copyAndCast(p_row.CODICEGLN);
      MemoryCursorRow_qbe_estr_trim_vqr.this.ABIINTER = copyAndCast(p_row.ABIINTER);
      MemoryCursorRow_qbe_estr_trim_vqr.this.ABIPROPR = copyAndCast(p_row.ABIPROPR);
      MemoryCursorRow_qbe_estr_trim_vqr.this.TIPOATTIV = copyAndCast(p_row.TIPOATTIV);
      MemoryCursorRow_qbe_estr_trim_vqr.this.NBANCONOTE = copyAndCast(p_row.NBANCONOTE);
      MemoryCursorRow_qbe_estr_trim_vqr.this.TAGLIO = copyAndCast(p_row.TAGLIO);
      MemoryCursorRow_qbe_estr_trim_vqr.this.GLNALTRASC = copyAndCast(p_row.GLNALTRASC);
      MemoryCursorRow_qbe_estr_trim_vqr.this.GLNALTROSOG = copyAndCast(p_row.GLNALTROSOG);
      MemoryCursorRow_qbe_estr_trim_vqr.this.CODCLICON = copyAndCast(p_row.CODCLICON);
      MemoryCursorRow_qbe_estr_trim_vqr.this.CODCOMCON = copyAndCast(p_row.CODCOMCON);
      MemoryCursorRow_qbe_estr_trim_vqr.this.ATECO_CON = copyAndCast(p_row.ATECO_CON);
      MemoryCursorRow_qbe_estr_trim_vqr.this.CONNES = copyAndCast(p_row.CONNES);
      MemoryCursorRow_qbe_estr_trim_vqr.this.ATTIV = copyAndCast(p_row.ATTIV);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"IDBASE","TIPOSOGGETTO","RAPSEGNA","CODICEGLN","ABIINTER","ABIPROPR","TIPOATTIV","NBANCONOTE","TAGLIO","GLNALTRASC","GLNALTROSOG","CODCLICON","CODCOMCON","ATECO_CON","CONNES","ATTIV"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","N","N","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"IDBASE","Tipo Soggetto","Rapporto con il segnalante","GLN Sala Conta","ABI Intermediario","ABI Proprietario","SPortello/CashDispenser","N. Banconote","Taglio Banconota","GLN Sala Conta Altro Soggetto","GLN Altro Soggetto","Codice Cliente Contante","Codice ISTAT Comune Cliente Contante","Codice Ateco Cliente Contante","Codice Cliente","ATECO SOGGETTO"};
    return l_names;
  }
}
