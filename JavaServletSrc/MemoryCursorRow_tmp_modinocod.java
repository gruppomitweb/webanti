public class MemoryCursorRow_tmp_modinocod extends CPMemoryCursorRow {
  public MemoryCursorRow_tmp_modinocod() {
  }
  public MemoryCursorRow_tmp_modinocod(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tmp_modinocod toBuild = new MemoryCursor_tmp_modinocod(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tmp_modinocod toBuild = new MemoryCursor_tmp_modinocod();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String TIPOREC = "";
  String PROGREC = "";
  String CODINTER = "";
  String IDFILE = "";
  String PROGRIF = "";
  String TIPOOPE = "";
  String COGNOME = "";
  String NOME = "";
  String SESSO = "";
  String DATANASC = "";
  String COMSTA = "";
  String PROVNA = "";
  String DENOM = "";
  String COMSEDE = "";
  String PROVSED = "";
  String TIPORAP = "";
  String COINT = "";
  String DATAINI = "";
  String DATACHIU = "";
  String IDBASE = "";
  String RAPPORTO = "";
  String CODFISC = "";
  String OPERAZIO = "";
  String RIFINVIO = "";
  String IDRETT = "";
  java.sql.Date DTRETT = CPLib.NullDate();
  String AFILE = "";
  String APROG = "";
  String CFILE = "";
  String CPROG = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(TIPOREC))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROGREC))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDFILE))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROGRIF))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(COGNOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(SESSO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATANASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(COMSTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVNA))) {
      return false;
    }
    if ( ! (CPLib.Empty(DENOM))) {
      return false;
    }
    if ( ! (CPLib.Empty(COMSEDE))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVSED))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPORAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(COINT))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAINI))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATACHIU))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODFISC))) {
      return false;
    }
    if ( ! (CPLib.Empty(OPERAZIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(RIFINVIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDRETT))) {
      return false;
    }
    if ( ! (CPLib.Empty(DTRETT))) {
      return false;
    }
    if ( ! (CPLib.Empty(AFILE))) {
      return false;
    }
    if ( ! (CPLib.Empty(APROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(CFILE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CPROG))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tmp_modinocod p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tmp_modinocod.this.TIPOREC = copyAndCast(p_row.TIPOREC);
      MemoryCursorRow_tmp_modinocod.this.PROGREC = copyAndCast(p_row.PROGREC);
      MemoryCursorRow_tmp_modinocod.this.CODINTER = copyAndCast(p_row.CODINTER);
      MemoryCursorRow_tmp_modinocod.this.IDFILE = copyAndCast(p_row.IDFILE);
      MemoryCursorRow_tmp_modinocod.this.PROGRIF = copyAndCast(p_row.PROGRIF);
      MemoryCursorRow_tmp_modinocod.this.TIPOOPE = copyAndCast(p_row.TIPOOPE);
      MemoryCursorRow_tmp_modinocod.this.COGNOME = copyAndCast(p_row.COGNOME);
      MemoryCursorRow_tmp_modinocod.this.NOME = copyAndCast(p_row.NOME);
      MemoryCursorRow_tmp_modinocod.this.SESSO = copyAndCast(p_row.SESSO);
      MemoryCursorRow_tmp_modinocod.this.DATANASC = copyAndCast(p_row.DATANASC);
      MemoryCursorRow_tmp_modinocod.this.COMSTA = copyAndCast(p_row.COMSTA);
      MemoryCursorRow_tmp_modinocod.this.PROVNA = copyAndCast(p_row.PROVNA);
      MemoryCursorRow_tmp_modinocod.this.DENOM = copyAndCast(p_row.DENOM);
      MemoryCursorRow_tmp_modinocod.this.COMSEDE = copyAndCast(p_row.COMSEDE);
      MemoryCursorRow_tmp_modinocod.this.PROVSED = copyAndCast(p_row.PROVSED);
      MemoryCursorRow_tmp_modinocod.this.TIPORAP = copyAndCast(p_row.TIPORAP);
      MemoryCursorRow_tmp_modinocod.this.COINT = copyAndCast(p_row.COINT);
      MemoryCursorRow_tmp_modinocod.this.DATAINI = copyAndCast(p_row.DATAINI);
      MemoryCursorRow_tmp_modinocod.this.DATACHIU = copyAndCast(p_row.DATACHIU);
      MemoryCursorRow_tmp_modinocod.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_tmp_modinocod.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_tmp_modinocod.this.CODFISC = copyAndCast(p_row.CODFISC);
      MemoryCursorRow_tmp_modinocod.this.OPERAZIO = copyAndCast(p_row.OPERAZIO);
      MemoryCursorRow_tmp_modinocod.this.RIFINVIO = copyAndCast(p_row.RIFINVIO);
      MemoryCursorRow_tmp_modinocod.this.IDRETT = copyAndCast(p_row.IDRETT);
      MemoryCursorRow_tmp_modinocod.this.DTRETT = copyAndCast(p_row.DTRETT);
      MemoryCursorRow_tmp_modinocod.this.AFILE = copyAndCast(p_row.AFILE);
      MemoryCursorRow_tmp_modinocod.this.APROG = copyAndCast(p_row.APROG);
      MemoryCursorRow_tmp_modinocod.this.CFILE = copyAndCast(p_row.CFILE);
      MemoryCursorRow_tmp_modinocod.this.CPROG = copyAndCast(p_row.CPROG);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"TIPOREC","PROGREC","CODINTER","IDFILE","PROGRIF","TIPOOPE","COGNOME","NOME","SESSO","DATANASC","COMSTA","PROVNA","DENOM","COMSEDE","PROVSED","TIPORAP","COINT","DATAINI","DATACHIU","IDBASE","RAPPORTO","CODFISC","OPERAZIO","RIFINVIO","IDRETT","DTRETT","AFILE","APROG","CFILE","CPROG"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","D","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"","","","","","","","","","","","","","","","","","","","","","Codice Fiscale","A=Aperture,C=Chiusure,D=Cancellazioni","Riferimento Invio","ID Rettifica","Data Richiesta Rettifica","","","",""};
    return l_names;
  }
}
