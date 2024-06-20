public class MemoryCursorRow_tmp_cgo_crtc extends CPMemoryCursorRow {
  public MemoryCursorRow_tmp_cgo_crtc() {
  }
  public MemoryCursorRow_tmp_cgo_crtc(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tmp_cgo_crtc toBuild = new MemoryCursor_tmp_cgo_crtc(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tmp_cgo_crtc toBuild = new MemoryCursor_tmp_cgo_crtc();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODDIP = "";
  java.sql.Date DATAOPE = CPLib.NullDate();
  String FLGCRTC = "";
  double NUMDAYS = 0;
  String TIPCRTC = "";
  String DESCDIP = "";
  String CITDIP = "";
  String IDBASE = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODDIP))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGCRTC))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMDAYS))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPCRTC))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCDIP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CITDIP))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tmp_cgo_crtc p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tmp_cgo_crtc.this.CODDIP = copyAndCast(p_row.CODDIP);
      MemoryCursorRow_tmp_cgo_crtc.this.DATAOPE = copyAndCast(p_row.DATAOPE);
      MemoryCursorRow_tmp_cgo_crtc.this.FLGCRTC = copyAndCast(p_row.FLGCRTC);
      MemoryCursorRow_tmp_cgo_crtc.this.NUMDAYS = copyAndCast(p_row.NUMDAYS);
      MemoryCursorRow_tmp_cgo_crtc.this.TIPCRTC = copyAndCast(p_row.TIPCRTC);
      MemoryCursorRow_tmp_cgo_crtc.this.DESCDIP = copyAndCast(p_row.DESCDIP);
      MemoryCursorRow_tmp_cgo_crtc.this.CITDIP = copyAndCast(p_row.CITDIP);
      MemoryCursorRow_tmp_cgo_crtc.this.IDBASE = copyAndCast(p_row.IDBASE);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODDIP","DATAOPE","FLGCRTC","NUMDAYS","TIPCRTC","DESCDIP","CITDIP","IDBASE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","D","C","N","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Agenzia","Data Operazione Più Vecchia","","N° Giorni","Tipo Operazione","Descrizione Dipendenza","Cità Dipendenza","ID Agenzia"};
    return l_names;
  }
}
