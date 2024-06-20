public class MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr() {
  }
  public MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_estrai_sv_all_ip_1_vqr toBuild = new MemoryCursor_qbe_estrai_sv_all_ip_1_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_estrai_sv_all_ip_1_vqr toBuild = new MemoryCursor_qbe_estrai_sv_all_ip_1_vqr();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String RAPPORTO = "";
  String DESCRAP = "";
  String ANNO = "";
  String TRIMESTRE = "";
  double IMPORTO = 0;
  String CODINTER = "";
  java.sql.Date DATA_INI = CPLib.NullDate();
  java.sql.Date DATA_FIN = CPLib.NullDate();
  String TIPORAP = "";
  java.sql.Date DATARETT = CPLib.NullDate();
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(ANNO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRIMESTRE))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATA_INI))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATA_FIN))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPORAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATARETT))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr.this.DESCRAP = copyAndCast(p_row.DESCRAP);
      MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr.this.ANNO = copyAndCast(p_row.ANNO);
      MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr.this.TRIMESTRE = copyAndCast(p_row.TRIMESTRE);
      MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr.this.IMPORTO = copyAndCast(p_row.IMPORTO);
      MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr.this.CODINTER = copyAndCast(p_row.CODINTER);
      MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr.this.DATA_INI = copyAndCast(p_row.DATA_INI);
      MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr.this.DATA_FIN = copyAndCast(p_row.DATA_FIN);
      MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr.this.TIPORAP = copyAndCast(p_row.TIPORAP);
      MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr.this.DATARETT = copyAndCast(p_row.DATARETT);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"RAPPORTO","DESCRAP","ANNO","TRIMESTRE","IMPORTO","CODINTER","DATA_INI","DATA_FIN","TIPORAP","DATARETT"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","N","C","D","D","C","D"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Rapporto","Descrizione","Anno","Trimestre","Importo","Intestatario (Non Intermediario)","Data Inizio Rapporto","Data Fine Rapporto","Tipo Rapporto","Data rettifica informazione"};
    return l_names;
  }
}
