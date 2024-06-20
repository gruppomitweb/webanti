public class MemoryCursorRow_qbe_oam_operazbo_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_oam_operazbo_vqr() {
  }
  public MemoryCursorRow_qbe_oam_operazbo_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_oam_operazbo_vqr toBuild = new MemoryCursor_qbe_oam_operazbo_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_oam_operazbo_vqr toBuild = new MemoryCursor_qbe_oam_operazbo_vqr();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String TIPO = "";
  String NUMPROG = "";
  String IDBASE2 = "";
  java.sql.Date DATAOPE = CPLib.NullDate();
  String VALUTA = "";
  String SEGNO = "";
  double IMPIN = 0;
  double IMPOUT = 0;
  String CODDIPE = "";
  String CONNESCLI = "";
  java.sql.Date DATAREG = CPLib.NullDate();
  String STATOREG = "";
  java.sql.Date DATARETT = CPLib.NullDate();
  String CODANA = "";
  String DESCCIT = "";
  String CAP = "";
  double CAMBIO = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(TIPO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDBASE2))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(VALUTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(SEGNO))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPIN))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPOUT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODDIPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESCLI))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAREG))) {
      return false;
    }
    if ( ! (CPLib.Empty(STATOREG))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATARETT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODANA))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCCIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAMBIO))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_qbe_oam_operazbo_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_oam_operazbo_vqr.this.TIPO = copyAndCast(p_row.TIPO);
      MemoryCursorRow_qbe_oam_operazbo_vqr.this.NUMPROG = copyAndCast(p_row.NUMPROG);
      MemoryCursorRow_qbe_oam_operazbo_vqr.this.IDBASE2 = copyAndCast(p_row.IDBASE2);
      MemoryCursorRow_qbe_oam_operazbo_vqr.this.DATAOPE = copyAndCast(p_row.DATAOPE);
      MemoryCursorRow_qbe_oam_operazbo_vqr.this.VALUTA = copyAndCast(p_row.VALUTA);
      MemoryCursorRow_qbe_oam_operazbo_vqr.this.SEGNO = copyAndCast(p_row.SEGNO);
      MemoryCursorRow_qbe_oam_operazbo_vqr.this.IMPIN = copyAndCast(p_row.IMPIN);
      MemoryCursorRow_qbe_oam_operazbo_vqr.this.IMPOUT = copyAndCast(p_row.IMPOUT);
      MemoryCursorRow_qbe_oam_operazbo_vqr.this.CODDIPE = copyAndCast(p_row.CODDIPE);
      MemoryCursorRow_qbe_oam_operazbo_vqr.this.CONNESCLI = copyAndCast(p_row.CONNESCLI);
      MemoryCursorRow_qbe_oam_operazbo_vqr.this.DATAREG = copyAndCast(p_row.DATAREG);
      MemoryCursorRow_qbe_oam_operazbo_vqr.this.STATOREG = copyAndCast(p_row.STATOREG);
      MemoryCursorRow_qbe_oam_operazbo_vqr.this.DATARETT = copyAndCast(p_row.DATARETT);
      MemoryCursorRow_qbe_oam_operazbo_vqr.this.CODANA = copyAndCast(p_row.CODANA);
      MemoryCursorRow_qbe_oam_operazbo_vqr.this.DESCCIT = copyAndCast(p_row.DESCCIT);
      MemoryCursorRow_qbe_oam_operazbo_vqr.this.CAP = copyAndCast(p_row.CAP);
      MemoryCursorRow_qbe_oam_operazbo_vqr.this.CAMBIO = copyAndCast(p_row.CAMBIO);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"TIPO","NUMPROG","IDBASE2","DATAOPE","VALUTA","SEGNO","IMPIN","IMPOUT","CODDIPE","CONNESCLI","DATAREG","STATOREG","DATARETT","CODANA","DESCCIT","CAP","CAMBIO"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","D","C","C","N","N","C","C","D","C","D","C","C","C","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"TIPO","Numero Progressivo","Gestione IDEREG","Data Operazione","Divisa","Segno","Importo IN","Importo OUT","Codice Dipendenza","Codice Cliente Occasionale","Data registrazione","Stato registrazione","Data Rettifica","Causale Analitica","Città","CAP","Cambio"};
    return l_names;
  }
}
