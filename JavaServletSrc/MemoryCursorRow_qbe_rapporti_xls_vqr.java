public class MemoryCursorRow_qbe_rapporti_xls_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_rapporti_xls_vqr() {
  }
  public MemoryCursorRow_qbe_rapporti_xls_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_rapporti_xls_vqr toBuild = new MemoryCursor_qbe_rapporti_xls_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_rapporti_xls_vqr toBuild = new MemoryCursor_qbe_rapporti_xls_vqr();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String RAPPORTO = "";
  String DESCRAP = "";
  String TIPORAP = "";
  String FLAGLIRE = "";
  String VALUTA = "";
  String SCOPO = "";
  String NATURA = "";
  String RISGLOB = "";
  java.sql.Date DATAPROF = CPLib.NullDate();
  java.sql.Date DATAREVPROF = CPLib.NullDate();
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPORAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGLIRE))) {
      return false;
    }
    if ( ! (CPLib.Empty(VALUTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(SCOPO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NATURA))) {
      return false;
    }
    if ( ! (CPLib.Empty(RISGLOB))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAPROF))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAREVPROF))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_qbe_rapporti_xls_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_rapporti_xls_vqr.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_qbe_rapporti_xls_vqr.this.DESCRAP = copyAndCast(p_row.DESCRAP);
      MemoryCursorRow_qbe_rapporti_xls_vqr.this.TIPORAP = copyAndCast(p_row.TIPORAP);
      MemoryCursorRow_qbe_rapporti_xls_vqr.this.FLAGLIRE = copyAndCast(p_row.FLAGLIRE);
      MemoryCursorRow_qbe_rapporti_xls_vqr.this.VALUTA = copyAndCast(p_row.VALUTA);
      MemoryCursorRow_qbe_rapporti_xls_vqr.this.SCOPO = copyAndCast(p_row.SCOPO);
      MemoryCursorRow_qbe_rapporti_xls_vqr.this.NATURA = copyAndCast(p_row.NATURA);
      MemoryCursorRow_qbe_rapporti_xls_vqr.this.RISGLOB = copyAndCast(p_row.RISGLOB);
      MemoryCursorRow_qbe_rapporti_xls_vqr.this.DATAPROF = copyAndCast(p_row.DATAPROF);
      MemoryCursorRow_qbe_rapporti_xls_vqr.this.DATAREVPROF = copyAndCast(p_row.DATAREVPROF);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"RAPPORTO","DESCRAP","TIPORAP","FLAGLIRE","VALUTA","SCOPO","NATURA","RISGLOB","DATAPROF","DATAREVPROF"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","D","D"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Rapporto","Descrizione","Tipo Rapporto","Divisa","Codice Divisa","Scopo","Natura","Rischio Globale","Data Profilatura","Data Revisione Profilatura"};
    return l_names;
  }
}
