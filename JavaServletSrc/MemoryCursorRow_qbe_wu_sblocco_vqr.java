public class MemoryCursorRow_qbe_wu_sblocco_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_wu_sblocco_vqr() {
  }
  public MemoryCursorRow_qbe_wu_sblocco_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_wu_sblocco_vqr toBuild = new MemoryCursor_qbe_wu_sblocco_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_wu_sblocco_vqr toBuild = new MemoryCursor_qbe_wu_sblocco_vqr();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  double TRXCODPRG = 0;
  String TRXCODDIP = "";
  String TRXMTCN = "";
  java.sql.Date TRXDATOPE = CPLib.NullDate();
  String TRXCOGNOM = "";
  String TRXNOME = "";
  String TRXCODFIS = "";
  double TRXUTENTE = 0;
  String fullname = "";
  java.sql.Timestamp TRXTINILAV = CPLib.NullDateTime();
  java.sql.Date TRXSCAEDT = CPLib.NullDate();
  double SCADENZA = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(TRXCODPRG))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXCODDIP))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXMTCN))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXDATOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXCOGNOM))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXNOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXCODFIS))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXUTENTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(fullname))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXTINILAV))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXSCAEDT))) {
      return false;
    }
    if ( ! (CPLib.Empty(SCADENZA))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_qbe_wu_sblocco_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_wu_sblocco_vqr.this.TRXCODPRG = copyAndCast(p_row.TRXCODPRG);
      MemoryCursorRow_qbe_wu_sblocco_vqr.this.TRXCODDIP = copyAndCast(p_row.TRXCODDIP);
      MemoryCursorRow_qbe_wu_sblocco_vqr.this.TRXMTCN = copyAndCast(p_row.TRXMTCN);
      MemoryCursorRow_qbe_wu_sblocco_vqr.this.TRXDATOPE = copyAndCast(p_row.TRXDATOPE);
      MemoryCursorRow_qbe_wu_sblocco_vqr.this.TRXCOGNOM = copyAndCast(p_row.TRXCOGNOM);
      MemoryCursorRow_qbe_wu_sblocco_vqr.this.TRXNOME = copyAndCast(p_row.TRXNOME);
      MemoryCursorRow_qbe_wu_sblocco_vqr.this.TRXCODFIS = copyAndCast(p_row.TRXCODFIS);
      MemoryCursorRow_qbe_wu_sblocco_vqr.this.TRXUTENTE = copyAndCast(p_row.TRXUTENTE);
      MemoryCursorRow_qbe_wu_sblocco_vqr.this.fullname = copyAndCast(p_row.fullname);
      MemoryCursorRow_qbe_wu_sblocco_vqr.this.TRXTINILAV = copyAndCast(p_row.TRXTINILAV);
      MemoryCursorRow_qbe_wu_sblocco_vqr.this.TRXSCAEDT = copyAndCast(p_row.TRXSCAEDT);
      MemoryCursorRow_qbe_wu_sblocco_vqr.this.SCADENZA = copyAndCast(p_row.SCADENZA);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"TRXCODPRG","TRXCODDIP","TRXMTCN","TRXDATOPE","TRXCOGNOM","TRXNOME","TRXCODFIS","TRXUTENTE","fullname","TRXTINILAV","TRXSCAEDT","SCADENZA"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"N","C","C","D","C","C","C","N","C","T","D","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"ID Transazione","Agenzia","MTCN Operazione","Data Operazione","Cognome","Nome","Codice Fiscale","Codice Utente che lavora la transazione","Nome Utente","Ora Inizio Lavorazione","Scadenza Transazione","Giorni Scadenza"};
    return l_names;
  }
}
