public class MemoryCursorRow_sid_invio extends CPMemoryCursorRow {
  public MemoryCursorRow_sid_invio() {
  }
  public MemoryCursorRow_sid_invio(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_sid_invio toBuild = new MemoryCursor_sid_invio(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_sid_invio toBuild = new MemoryCursor_sid_invio();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODINVIO = "";
  String TIPINVIO = "";
  String TPCINVIO = "";
  java.sql.Date DATINVIO = CPLib.NullDate();
  String ANNINVIO = "";
  String MESINVIO = "";
  String PRTINVIO = "";
  String FLEINVIO = "";
  String FL1INVIO = "";
  String FL2INVIO = "";
  String FLGINVIO = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODINVIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPINVIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TPCINVIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATINVIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(ANNINVIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(MESINVIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(PRTINVIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLEINVIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FL1INVIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FL2INVIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGINVIO))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_sid_invio p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_sid_invio.this.CODINVIO = copyAndCast(p_row.CODINVIO);
      MemoryCursorRow_sid_invio.this.TIPINVIO = copyAndCast(p_row.TIPINVIO);
      MemoryCursorRow_sid_invio.this.TPCINVIO = copyAndCast(p_row.TPCINVIO);
      MemoryCursorRow_sid_invio.this.DATINVIO = copyAndCast(p_row.DATINVIO);
      MemoryCursorRow_sid_invio.this.ANNINVIO = copyAndCast(p_row.ANNINVIO);
      MemoryCursorRow_sid_invio.this.MESINVIO = copyAndCast(p_row.MESINVIO);
      MemoryCursorRow_sid_invio.this.PRTINVIO = copyAndCast(p_row.PRTINVIO);
      MemoryCursorRow_sid_invio.this.FLEINVIO = copyAndCast(p_row.FLEINVIO);
      MemoryCursorRow_sid_invio.this.FL1INVIO = copyAndCast(p_row.FL1INVIO);
      MemoryCursorRow_sid_invio.this.FL2INVIO = copyAndCast(p_row.FL2INVIO);
      MemoryCursorRow_sid_invio.this.FLGINVIO = copyAndCast(p_row.FLGINVIO);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODINVIO","TIPINVIO","TPCINVIO","DATINVIO","ANNINVIO","MESINVIO","PRTINVIO","FLEINVIO","FL1INVIO","FL2INVIO","FLGINVIO"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","D","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice INVIO","Tipo Invio","Tipo Comunicazione","Data Creazione","Anno di Riferimento","Mese di Riferimento","Protocollo Comunicazione","Nome File Creato","Nome File 1 SID","Nome File 2 SID","Creati File"};
    return l_names;
  }
}
