public class MemoryCursorRow_tipo8 extends CPMemoryCursorRow {
  public MemoryCursorRow_tipo8() {
  }
  public MemoryCursorRow_tipo8(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tipo8 toBuild = new MemoryCursor_tipo8(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tipo8 toBuild = new MemoryCursor_tipo8();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String A01A = "";
  String A01B = "";
  String A02 = "";
  String A03 = "";
  String C21 = "";
  String E11 = "";
  String E13 = "";
  String E14A = "";
  String E14B = "";
  String E14C = "";
  String E15 = "";
  String E16 = "";
  String E17 = "";
  java.sql.Date E18 = CPLib.NullDate();
  String E19 = "";
  String E41 = "";
  String E42 = "";
  java.sql.Date E43 = CPLib.NullDate();
  String E44 = "";
  String E45 = "";
  double PROG = 0;
  double CFESTERO = 0;
  java.sql.Date DATAVALI = CPLib.NullDate();
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(A01A))) {
      return false;
    }
    if ( ! (CPLib.Empty(A01B))) {
      return false;
    }
    if ( ! (CPLib.Empty(A02))) {
      return false;
    }
    if ( ! (CPLib.Empty(A03))) {
      return false;
    }
    if ( ! (CPLib.Empty(C21))) {
      return false;
    }
    if ( ! (CPLib.Empty(E11))) {
      return false;
    }
    if ( ! (CPLib.Empty(E13))) {
      return false;
    }
    if ( ! (CPLib.Empty(E14A))) {
      return false;
    }
    if ( ! (CPLib.Empty(E14B))) {
      return false;
    }
    if ( ! (CPLib.Empty(E14C))) {
      return false;
    }
    if ( ! (CPLib.Empty(E15))) {
      return false;
    }
    if ( ! (CPLib.Empty(E16))) {
      return false;
    }
    if ( ! (CPLib.Empty(E17))) {
      return false;
    }
    if ( ! (CPLib.Empty(E18))) {
      return false;
    }
    if ( ! (CPLib.Empty(E19))) {
      return false;
    }
    if ( ! (CPLib.Empty(E41))) {
      return false;
    }
    if ( ! (CPLib.Empty(E42))) {
      return false;
    }
    if ( ! (CPLib.Empty(E43))) {
      return false;
    }
    if ( ! (CPLib.Empty(E44))) {
      return false;
    }
    if ( ! (CPLib.Empty(E45))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(CFESTERO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAVALI))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tipo8 p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tipo8.this.A01A = copyAndCast(p_row.A01A);
      MemoryCursorRow_tipo8.this.A01B = copyAndCast(p_row.A01B);
      MemoryCursorRow_tipo8.this.A02 = copyAndCast(p_row.A02);
      MemoryCursorRow_tipo8.this.A03 = copyAndCast(p_row.A03);
      MemoryCursorRow_tipo8.this.C21 = copyAndCast(p_row.C21);
      MemoryCursorRow_tipo8.this.E11 = copyAndCast(p_row.E11);
      MemoryCursorRow_tipo8.this.E13 = copyAndCast(p_row.E13);
      MemoryCursorRow_tipo8.this.E14A = copyAndCast(p_row.E14A);
      MemoryCursorRow_tipo8.this.E14B = copyAndCast(p_row.E14B);
      MemoryCursorRow_tipo8.this.E14C = copyAndCast(p_row.E14C);
      MemoryCursorRow_tipo8.this.E15 = copyAndCast(p_row.E15);
      MemoryCursorRow_tipo8.this.E16 = copyAndCast(p_row.E16);
      MemoryCursorRow_tipo8.this.E17 = copyAndCast(p_row.E17);
      MemoryCursorRow_tipo8.this.E18 = copyAndCast(p_row.E18);
      MemoryCursorRow_tipo8.this.E19 = copyAndCast(p_row.E19);
      MemoryCursorRow_tipo8.this.E41 = copyAndCast(p_row.E41);
      MemoryCursorRow_tipo8.this.E42 = copyAndCast(p_row.E42);
      MemoryCursorRow_tipo8.this.E43 = copyAndCast(p_row.E43);
      MemoryCursorRow_tipo8.this.E44 = copyAndCast(p_row.E44);
      MemoryCursorRow_tipo8.this.E45 = copyAndCast(p_row.E45);
      MemoryCursorRow_tipo8.this.PROG = copyAndCast(p_row.PROG);
      MemoryCursorRow_tipo8.this.CFESTERO = copyAndCast(p_row.CFESTERO);
      MemoryCursorRow_tipo8.this.DATAVALI = copyAndCast(p_row.DATAVALI);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"A01A","A01B","A02","A03","C21","E11","E13","E14A","E14B","E14C","E15","E16","E17","E18","E19","E41","E42","E43","E44","E45","PROG","CFESTERO","DATAVALI"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C","C","C","C","C","D","C","C","C","D","C","C","N","N","D"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Tipo intermediario","Codice intermediario","Tipo informazione","Identificativo registrazione","NDG/Connessione anagrafe","Ragione sociale","Paese di residenza","CAB Comune (Residenza)","Descrizione in chiaro (Residenza)","Sigla provincia (Residenza)","Domicilio/Sede: Indirizzo","Domicilio/Sede: CAP","Codice Fiscale","Data di nascita","Comune/Paese di nascita","Tipo documento","Numero documento","Data rilascio","Autorità e località rilascio","Sesso","Contatore","Codice Fiscale Fittizio","Data Scadenza Documento"};
    return l_names;
  }
}
