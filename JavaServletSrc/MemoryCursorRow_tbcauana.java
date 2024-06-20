public class MemoryCursorRow_tbcauana extends CPMemoryCursorRow {
  public MemoryCursorRow_tbcauana() {
  }
  public MemoryCursorRow_tbcauana(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tbcauana toBuild = new MemoryCursor_tbcauana(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tbcauana toBuild = new MemoryCursor_tbcauana();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String idbase = "";
  String DESCRI = "";
  String CODCAU = "";
  String SEGNO = "";
  String CAUSINT = "";
  java.sql.Date DATAVALI = CPLib.NullDate();
  String VALPERINT = "";
  java.sql.Date DATINI = CPLib.NullDate();
  String FLGINTER = "";
  String MITBASE = "";
  String USEBASE = "";
  String NOSARA = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(idbase))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRI))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCAU))) {
      return false;
    }
    if ( ! (CPLib.Empty(SEGNO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAUSINT))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAVALI))) {
      return false;
    }
    if ( ! (CPLib.Empty(VALPERINT))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATINI))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(MITBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(USEBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOSARA))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tbcauana p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tbcauana.this.idbase = copyAndCast(p_row.idbase);
      MemoryCursorRow_tbcauana.this.DESCRI = copyAndCast(p_row.DESCRI);
      MemoryCursorRow_tbcauana.this.CODCAU = copyAndCast(p_row.CODCAU);
      MemoryCursorRow_tbcauana.this.SEGNO = copyAndCast(p_row.SEGNO);
      MemoryCursorRow_tbcauana.this.CAUSINT = copyAndCast(p_row.CAUSINT);
      MemoryCursorRow_tbcauana.this.DATAVALI = copyAndCast(p_row.DATAVALI);
      MemoryCursorRow_tbcauana.this.VALPERINT = copyAndCast(p_row.VALPERINT);
      MemoryCursorRow_tbcauana.this.DATINI = copyAndCast(p_row.DATINI);
      MemoryCursorRow_tbcauana.this.FLGINTER = copyAndCast(p_row.FLGINTER);
      MemoryCursorRow_tbcauana.this.MITBASE = copyAndCast(p_row.MITBASE);
      MemoryCursorRow_tbcauana.this.USEBASE = copyAndCast(p_row.USEBASE);
      MemoryCursorRow_tbcauana.this.NOSARA = copyAndCast(p_row.NOSARA);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"idbase","DESCRI","CODCAU","SEGNO","CAUSINT","DATAVALI","VALPERINT","DATINI","FLGINTER","MITBASE","USEBASE","NOSARA"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","D","C","D","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"ID BASE","Descrizione","Codice","Segno","Causale Sintetica","Data Fine Validità","Valido per intermediario","Data Inizio Validità","I=Italia,E=Estero","","","Escludi le operazioni da SARA"};
    return l_names;
  }
}
