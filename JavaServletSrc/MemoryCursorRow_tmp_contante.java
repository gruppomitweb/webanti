public class MemoryCursorRow_tmp_contante extends CPMemoryCursorRow {
  public MemoryCursorRow_tmp_contante() {
  }
  public MemoryCursorRow_tmp_contante(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tmp_contante toBuild = new MemoryCursor_tmp_contante(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tmp_contante toBuild = new MemoryCursor_tmp_contante();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String NUMPROG = "";
  String TIPATT = "";
  String TIPOATTIV = "";
  String CODICEGLN = "";
  double TOTBANKNOTE = 0;
  double TAGLIO = 0;
  double NBANCONOTE = 0;
  String ABIINTER = "";
  String ABIPROPR = "";
  String GLNALTROSOG = "";
  String GLNALTRASC = "";
  String CODCLICON = "";
  String CODCOMCON = "";
  String ATECO_CON = "";
  String CODDIPE = "";
  String IMPPROG = "";
  double TOTRIGA = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(NUMPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPATT))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOATTIV))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODICEGLN))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTBANKNOTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TAGLIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NBANCONOTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(ABIINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(ABIPROPR))) {
      return false;
    }
    if ( ! (CPLib.Empty(GLNALTROSOG))) {
      return false;
    }
    if ( ! (CPLib.Empty(GLNALTRASC))) {
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
    if ( ! (CPLib.Empty(CODDIPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTRIGA))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tmp_contante p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tmp_contante.this.NUMPROG = copyAndCast(p_row.NUMPROG);
      MemoryCursorRow_tmp_contante.this.TIPATT = copyAndCast(p_row.TIPATT);
      MemoryCursorRow_tmp_contante.this.TIPOATTIV = copyAndCast(p_row.TIPOATTIV);
      MemoryCursorRow_tmp_contante.this.CODICEGLN = copyAndCast(p_row.CODICEGLN);
      MemoryCursorRow_tmp_contante.this.TOTBANKNOTE = copyAndCast(p_row.TOTBANKNOTE);
      MemoryCursorRow_tmp_contante.this.TAGLIO = copyAndCast(p_row.TAGLIO);
      MemoryCursorRow_tmp_contante.this.NBANCONOTE = copyAndCast(p_row.NBANCONOTE);
      MemoryCursorRow_tmp_contante.this.ABIINTER = copyAndCast(p_row.ABIINTER);
      MemoryCursorRow_tmp_contante.this.ABIPROPR = copyAndCast(p_row.ABIPROPR);
      MemoryCursorRow_tmp_contante.this.GLNALTROSOG = copyAndCast(p_row.GLNALTROSOG);
      MemoryCursorRow_tmp_contante.this.GLNALTRASC = copyAndCast(p_row.GLNALTRASC);
      MemoryCursorRow_tmp_contante.this.CODCLICON = copyAndCast(p_row.CODCLICON);
      MemoryCursorRow_tmp_contante.this.CODCOMCON = copyAndCast(p_row.CODCOMCON);
      MemoryCursorRow_tmp_contante.this.ATECO_CON = copyAndCast(p_row.ATECO_CON);
      MemoryCursorRow_tmp_contante.this.CODDIPE = copyAndCast(p_row.CODDIPE);
      MemoryCursorRow_tmp_contante.this.IMPPROG = copyAndCast(p_row.IMPPROG);
      MemoryCursorRow_tmp_contante.this.TOTRIGA = copyAndCast(p_row.TOTRIGA);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"NUMPROG","TIPATT","TIPOATTIV","CODICEGLN","TOTBANKNOTE","TAGLIO","NBANCONOTE","ABIINTER","ABIPROPR","GLNALTROSOG","GLNALTRASC","CODCLICON","CODCOMCON","ATECO_CON","CODDIPE","IMPPROG","TOTRIGA"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","N","N","N","C","C","C","C","C","C","C","C","C","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Collegamento Operazioni","Tipo attività","SPortello/CashDispenser","GLN Sala Conta","Banconote Ritirate","Taglio Banconota","N. Banconote","ABI Intermediario","ABI Proprietario","GLN Altro Soggetto","GLN Sala Conta Altro Soggetto","Codice Cliente Contante","Codice ISTAT Comune Cliente Contante","Codice Ateco Cliente Contante","Codice Dipendenza","Progressivo Import","Totale Riga"};
    return l_names;
  }
}
