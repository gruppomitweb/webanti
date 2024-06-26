public class MemoryCursorRow_tmp_invio_xbrl extends CPMemoryCursorRow {
  public MemoryCursorRow_tmp_invio_xbrl() {
  }
  public MemoryCursorRow_tmp_invio_xbrl(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tmp_invio_xbrl toBuild = new MemoryCursor_tmp_invio_xbrl(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tmp_invio_xbrl toBuild = new MemoryCursor_tmp_invio_xbrl();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODINTDIP = "";
  String ABICABDIP = "";
  String CODCABDIP = "";
  String PERPAESE = "";
  String PERCAB = "";
  String CODVOC = "";
  String FLAGLIRE = "";
  String SEGNO = "";
  String SETTSINT = "";
  String PAESECP = "";
  String CODCABCP = "";
  String PAESEICP = "";
  String CABICP = "";
  double TOTLIRE = 0;
  double TOTCONT = 0;
  double OPERAZIONI = 0;
  double CONTANTI = 0;
  double N_ITA = 0;
  double N_EXT = 0;
  double N_ALT = 0;
  String IDBASE = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODINTDIP))) {
      return false;
    }
    if ( ! (CPLib.Empty(ABICABDIP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCABDIP))) {
      return false;
    }
    if ( ! (CPLib.Empty(PERPAESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(PERCAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODVOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGLIRE))) {
      return false;
    }
    if ( ! (CPLib.Empty(SEGNO))) {
      return false;
    }
    if ( ! (CPLib.Empty(SETTSINT))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESECP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCABCP))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESEICP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CABICP))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTLIRE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTCONT))) {
      return false;
    }
    if ( ! (CPLib.Empty(OPERAZIONI))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONTANTI))) {
      return false;
    }
    if ( ! (CPLib.Empty(N_ITA))) {
      return false;
    }
    if ( ! (CPLib.Empty(N_EXT))) {
      return false;
    }
    if ( ! (CPLib.Empty(N_ALT))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tmp_invio_xbrl p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tmp_invio_xbrl.this.CODINTDIP = copyAndCast(p_row.CODINTDIP);
      MemoryCursorRow_tmp_invio_xbrl.this.ABICABDIP = copyAndCast(p_row.ABICABDIP);
      MemoryCursorRow_tmp_invio_xbrl.this.CODCABDIP = copyAndCast(p_row.CODCABDIP);
      MemoryCursorRow_tmp_invio_xbrl.this.PERPAESE = copyAndCast(p_row.PERPAESE);
      MemoryCursorRow_tmp_invio_xbrl.this.PERCAB = copyAndCast(p_row.PERCAB);
      MemoryCursorRow_tmp_invio_xbrl.this.CODVOC = copyAndCast(p_row.CODVOC);
      MemoryCursorRow_tmp_invio_xbrl.this.FLAGLIRE = copyAndCast(p_row.FLAGLIRE);
      MemoryCursorRow_tmp_invio_xbrl.this.SEGNO = copyAndCast(p_row.SEGNO);
      MemoryCursorRow_tmp_invio_xbrl.this.SETTSINT = copyAndCast(p_row.SETTSINT);
      MemoryCursorRow_tmp_invio_xbrl.this.PAESECP = copyAndCast(p_row.PAESECP);
      MemoryCursorRow_tmp_invio_xbrl.this.CODCABCP = copyAndCast(p_row.CODCABCP);
      MemoryCursorRow_tmp_invio_xbrl.this.PAESEICP = copyAndCast(p_row.PAESEICP);
      MemoryCursorRow_tmp_invio_xbrl.this.CABICP = copyAndCast(p_row.CABICP);
      MemoryCursorRow_tmp_invio_xbrl.this.TOTLIRE = copyAndCast(p_row.TOTLIRE);
      MemoryCursorRow_tmp_invio_xbrl.this.TOTCONT = copyAndCast(p_row.TOTCONT);
      MemoryCursorRow_tmp_invio_xbrl.this.OPERAZIONI = copyAndCast(p_row.OPERAZIONI);
      MemoryCursorRow_tmp_invio_xbrl.this.CONTANTI = copyAndCast(p_row.CONTANTI);
      MemoryCursorRow_tmp_invio_xbrl.this.N_ITA = copyAndCast(p_row.N_ITA);
      MemoryCursorRow_tmp_invio_xbrl.this.N_EXT = copyAndCast(p_row.N_EXT);
      MemoryCursorRow_tmp_invio_xbrl.this.N_ALT = copyAndCast(p_row.N_ALT);
      MemoryCursorRow_tmp_invio_xbrl.this.IDBASE = copyAndCast(p_row.IDBASE);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODINTDIP","ABICABDIP","CODCABDIP","PERPAESE","PERCAB","CODVOC","FLAGLIRE","SEGNO","SETTSINT","PAESECP","CODCABCP","PAESEICP","CABICP","TOTLIRE","TOTCONT","OPERAZIONI","CONTANTI","N_ITA","N_EXT","N_ALT","IDBASE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C","C","C","C","C","N","N","N","N","N","N","N","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Dipendenza","ABI CAB della DIPENDENZA","CAB DIPENDENZA","Paese Residenza Cliente","CAB Comune Residenza Cliente","Causale Aggregata","Valuta","Segno (Dare - Avere)","Settorizzazione Sintetica","PAESE Controparte","CAB Comune Controparte","Paese Intermediario Controparte","CAB Comune Intermediario Controparte","Totale Generale","Totale Contanti","Operazioni Totali","Operazioni in contanti","Contatore ITALIA","Contatore Estero","Altre Operazioni","IDBASE OPERAZIONE"};
    return l_names;
  }
}
