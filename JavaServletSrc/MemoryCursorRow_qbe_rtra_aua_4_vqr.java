public class MemoryCursorRow_qbe_rtra_aua_4_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_rtra_aua_4_vqr() {
  }
  public MemoryCursorRow_qbe_rtra_aua_4_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_rtra_aua_4_vqr toBuild = new MemoryCursor_qbe_rtra_aua_4_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_rtra_aua_4_vqr toBuild = new MemoryCursor_qbe_rtra_aua_4_vqr();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String COGNOME = "";
  String NOME = "";
  String NASSTATO = "";
  String NASCOMUN = "";
  java.sql.Date DATANASC = CPLib.NullDate();
  String SESSO = "";
  String RAGSOC = "";
  String LUOGONAS = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(COGNOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(NASSTATO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NASCOMUN))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATANASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(SESSO))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGSOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(LUOGONAS))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_qbe_rtra_aua_4_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_rtra_aua_4_vqr.this.COGNOME = copyAndCast(p_row.COGNOME);
      MemoryCursorRow_qbe_rtra_aua_4_vqr.this.NOME = copyAndCast(p_row.NOME);
      MemoryCursorRow_qbe_rtra_aua_4_vqr.this.NASSTATO = copyAndCast(p_row.NASSTATO);
      MemoryCursorRow_qbe_rtra_aua_4_vqr.this.NASCOMUN = copyAndCast(p_row.NASCOMUN);
      MemoryCursorRow_qbe_rtra_aua_4_vqr.this.DATANASC = copyAndCast(p_row.DATANASC);
      MemoryCursorRow_qbe_rtra_aua_4_vqr.this.SESSO = copyAndCast(p_row.SESSO);
      MemoryCursorRow_qbe_rtra_aua_4_vqr.this.RAGSOC = copyAndCast(p_row.RAGSOC);
      MemoryCursorRow_qbe_rtra_aua_4_vqr.this.LUOGONAS = copyAndCast(p_row.LUOGONAS);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"COGNOME","NOME","NASSTATO","NASCOMUN","DATANASC","SESSO","RAGSOC","LUOGONAS"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","D","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Cognome","Nome","Stato di nascita","Luogo di Nascita","Data Nascita","Sesso","Ragione Sociale","Luogo di Nascita"};
    return l_names;
  }
}
