public class MemoryCursorRow_tbstatisv extends CPMemoryCursorRow {
  public MemoryCursorRow_tbstatisv() {
  }
  public MemoryCursorRow_tbstatisv(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tbstatisv toBuild = new MemoryCursor_tbstatisv(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tbstatisv toBuild = new MemoryCursor_tbstatisv();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODICENSV = "";
  String DENOMINAZIONE = "";
  String COD_BI = "";
  String SIGLA = "";
  String ISO = "";
  String ISO2 = "";
  java.sql.Date INIZIO = CPLib.NullDate();
  java.sql.Date FINE = CPLib.NullDate();
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODICENSV))) {
      return false;
    }
    if ( ! (CPLib.Empty(DENOMINAZIONE))) {
      return false;
    }
    if ( ! (CPLib.Empty(COD_BI))) {
      return false;
    }
    if ( ! (CPLib.Empty(SIGLA))) {
      return false;
    }
    if ( ! (CPLib.Empty(ISO))) {
      return false;
    }
    if ( ! (CPLib.Empty(ISO2))) {
      return false;
    }
    if ( ! (CPLib.Empty(INIZIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FINE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tbstatisv p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tbstatisv.this.CODICENSV = copyAndCast(p_row.CODICENSV);
      MemoryCursorRow_tbstatisv.this.DENOMINAZIONE = copyAndCast(p_row.DENOMINAZIONE);
      MemoryCursorRow_tbstatisv.this.COD_BI = copyAndCast(p_row.COD_BI);
      MemoryCursorRow_tbstatisv.this.SIGLA = copyAndCast(p_row.SIGLA);
      MemoryCursorRow_tbstatisv.this.ISO = copyAndCast(p_row.ISO);
      MemoryCursorRow_tbstatisv.this.ISO2 = copyAndCast(p_row.ISO2);
      MemoryCursorRow_tbstatisv.this.INIZIO = copyAndCast(p_row.INIZIO);
      MemoryCursorRow_tbstatisv.this.FINE = copyAndCast(p_row.FINE);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODICENSV","DENOMINAZIONE","COD_BI","SIGLA","ISO","ISO2","INIZIO","FINE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","D","D"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Stato N.S.V.","Descrizione","Codifica Banca D'Italia","Codice Catastale","ISO 3 Caratteri","ISO 2 Caratteri","Data Inizio Validità","Data Fine Validità"};
    return l_names;
  }
}
