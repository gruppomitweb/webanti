public class MemoryCursorRow_qbe_rapporti_xls_dett_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_rapporti_xls_dett_vqr() {
  }
  public MemoryCursorRow_qbe_rapporti_xls_dett_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_rapporti_xls_dett_vqr toBuild = new MemoryCursor_qbe_rapporti_xls_dett_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_rapporti_xls_dett_vqr toBuild = new MemoryCursor_qbe_rapporti_xls_dett_vqr();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String RAPPORTO = "";
  String DESCRAP = "";
  String TIPORAP = "";
  String FLAGLIRE = "";
  String VALUTA = "";
  String SPLITCODE = "";
  String SCOPO = "";
  String NATURA = "";
  java.sql.Date DATAPROF = CPLib.NullDate();
  String RISGLOB = "";
  java.sql.Date DATAREVPROF = CPLib.NullDate();
  String CODICELR = "";
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
    if ( ! (CPLib.Empty(SPLITCODE))) {
      return false;
    }
    if ( ! (CPLib.Empty(SCOPO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NATURA))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAPROF))) {
      return false;
    }
    if ( ! (CPLib.Empty(RISGLOB))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAREVPROF))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODICELR))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_qbe_rapporti_xls_dett_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_rapporti_xls_dett_vqr.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_qbe_rapporti_xls_dett_vqr.this.DESCRAP = copyAndCast(p_row.DESCRAP);
      MemoryCursorRow_qbe_rapporti_xls_dett_vqr.this.TIPORAP = copyAndCast(p_row.TIPORAP);
      MemoryCursorRow_qbe_rapporti_xls_dett_vqr.this.FLAGLIRE = copyAndCast(p_row.FLAGLIRE);
      MemoryCursorRow_qbe_rapporti_xls_dett_vqr.this.VALUTA = copyAndCast(p_row.VALUTA);
      MemoryCursorRow_qbe_rapporti_xls_dett_vqr.this.SPLITCODE = copyAndCast(p_row.SPLITCODE);
      MemoryCursorRow_qbe_rapporti_xls_dett_vqr.this.SCOPO = copyAndCast(p_row.SCOPO);
      MemoryCursorRow_qbe_rapporti_xls_dett_vqr.this.NATURA = copyAndCast(p_row.NATURA);
      MemoryCursorRow_qbe_rapporti_xls_dett_vqr.this.DATAPROF = copyAndCast(p_row.DATAPROF);
      MemoryCursorRow_qbe_rapporti_xls_dett_vqr.this.RISGLOB = copyAndCast(p_row.RISGLOB);
      MemoryCursorRow_qbe_rapporti_xls_dett_vqr.this.DATAREVPROF = copyAndCast(p_row.DATAREVPROF);
      MemoryCursorRow_qbe_rapporti_xls_dett_vqr.this.CODICELR = copyAndCast(p_row.CODICELR);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"RAPPORTO","DESCRAP","TIPORAP","FLAGLIRE","VALUTA","SPLITCODE","SCOPO","NATURA","DATAPROF","RISGLOB","DATAREVPROF","CODICELR"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","D","C","D","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Rapporto","Descrizione","Tipo Rapporto","Divisa","Codice Divisa","Customer ID (WUBS)","Scopo","Natura","Data Profilatura","Rischio Globale","Data Revisione Profilatura","Legale Rappresentante"};
    return l_names;
  }
}
