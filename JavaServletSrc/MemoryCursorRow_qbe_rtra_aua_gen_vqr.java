public class MemoryCursorRow_qbe_rtra_aua_gen_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_rtra_aua_gen_vqr() {
  }
  public MemoryCursorRow_qbe_rtra_aua_gen_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_rtra_aua_gen_vqr toBuild = new MemoryCursor_qbe_rtra_aua_gen_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_rtra_aua_gen_vqr toBuild = new MemoryCursor_qbe_rtra_aua_gen_vqr();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CONNES = "";
  String COGNOME = "";
  String NOME = "";
  String NASSTATO = "";
  String NASCOMUN = "";
  java.sql.Date DATANASC = CPLib.NullDate();
  String SESSO = "";
  String TIPODOC = "";
  String NUMDOCUM = "";
  java.sql.Date DATARILASC = CPLib.NullDate();
  String CODFISC = "";
  String RAGSOC = "";
  String FLGCFVALIDO = "";
  String FLGCGFORMAT = "";
  String LUOGONAS = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CONNES))) {
      return false;
    }
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
    if ( ! (CPLib.Empty(TIPODOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMDOCUM))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATARILASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODFISC))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGSOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGCFVALIDO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGCGFORMAT))) {
      return false;
    }
    if ( ! (CPLib.Empty(LUOGONAS))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_qbe_rtra_aua_gen_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_rtra_aua_gen_vqr.this.CONNES = copyAndCast(p_row.CONNES);
      MemoryCursorRow_qbe_rtra_aua_gen_vqr.this.COGNOME = copyAndCast(p_row.COGNOME);
      MemoryCursorRow_qbe_rtra_aua_gen_vqr.this.NOME = copyAndCast(p_row.NOME);
      MemoryCursorRow_qbe_rtra_aua_gen_vqr.this.NASSTATO = copyAndCast(p_row.NASSTATO);
      MemoryCursorRow_qbe_rtra_aua_gen_vqr.this.NASCOMUN = copyAndCast(p_row.NASCOMUN);
      MemoryCursorRow_qbe_rtra_aua_gen_vqr.this.DATANASC = copyAndCast(p_row.DATANASC);
      MemoryCursorRow_qbe_rtra_aua_gen_vqr.this.SESSO = copyAndCast(p_row.SESSO);
      MemoryCursorRow_qbe_rtra_aua_gen_vqr.this.TIPODOC = copyAndCast(p_row.TIPODOC);
      MemoryCursorRow_qbe_rtra_aua_gen_vqr.this.NUMDOCUM = copyAndCast(p_row.NUMDOCUM);
      MemoryCursorRow_qbe_rtra_aua_gen_vqr.this.DATARILASC = copyAndCast(p_row.DATARILASC);
      MemoryCursorRow_qbe_rtra_aua_gen_vqr.this.CODFISC = copyAndCast(p_row.CODFISC);
      MemoryCursorRow_qbe_rtra_aua_gen_vqr.this.RAGSOC = copyAndCast(p_row.RAGSOC);
      MemoryCursorRow_qbe_rtra_aua_gen_vqr.this.FLGCFVALIDO = copyAndCast(p_row.FLGCFVALIDO);
      MemoryCursorRow_qbe_rtra_aua_gen_vqr.this.FLGCGFORMAT = copyAndCast(p_row.FLGCGFORMAT);
      MemoryCursorRow_qbe_rtra_aua_gen_vqr.this.LUOGONAS = copyAndCast(p_row.LUOGONAS);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CONNES","COGNOME","NOME","NASSTATO","NASCOMUN","DATANASC","SESSO","TIPODOC","NUMDOCUM","DATARILASC","CODFISC","RAGSOC","FLGCFVALIDO","FLGCGFORMAT","LUOGONAS"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","D","C","C","C","D","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Collegamento","Cognome","Nome","Stato di nascita","Luogo di Nascita","Data Nascita","Sesso","Tipo Documento","Numero Doc.","Data Rilascio Doc.","Codice Fiscale","Ragione Sociale","Codice Fiscale Validato","Codice Fiscale Formalmente Valido","Luogo Nascita"};
    return l_names;
  }
}
