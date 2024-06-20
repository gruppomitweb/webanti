public class MemoryCursorRow_tipo9 extends CPMemoryCursorRow {
  public MemoryCursorRow_tipo9() {
  }
  public MemoryCursorRow_tipo9(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tipo9 toBuild = new MemoryCursor_tipo9(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tipo9 toBuild = new MemoryCursor_tipo9();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String A01A = "";
  String A01B = "";
  String A02 = "";
  String A03 = "";
  String C51 = "";
  String H11 = "";
  String H13 = "";
  String H14A = "";
  String H14B = "";
  String H14C = "";
  String H15 = "";
  String H16 = "";
  String H17 = "";
  java.sql.Date H18 = CPLib.NullDate();
  String H19 = "";
  String H41 = "";
  String H42 = "";
  java.sql.Date H43 = CPLib.NullDate();
  String H44 = "";
  String H45 = "";
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
    if ( ! (CPLib.Empty(C51))) {
      return false;
    }
    if ( ! (CPLib.Empty(H11))) {
      return false;
    }
    if ( ! (CPLib.Empty(H13))) {
      return false;
    }
    if ( ! (CPLib.Empty(H14A))) {
      return false;
    }
    if ( ! (CPLib.Empty(H14B))) {
      return false;
    }
    if ( ! (CPLib.Empty(H14C))) {
      return false;
    }
    if ( ! (CPLib.Empty(H15))) {
      return false;
    }
    if ( ! (CPLib.Empty(H16))) {
      return false;
    }
    if ( ! (CPLib.Empty(H17))) {
      return false;
    }
    if ( ! (CPLib.Empty(H18))) {
      return false;
    }
    if ( ! (CPLib.Empty(H19))) {
      return false;
    }
    if ( ! (CPLib.Empty(H41))) {
      return false;
    }
    if ( ! (CPLib.Empty(H42))) {
      return false;
    }
    if ( ! (CPLib.Empty(H43))) {
      return false;
    }
    if ( ! (CPLib.Empty(H44))) {
      return false;
    }
    if ( ! (CPLib.Empty(H45))) {
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
  void Copy(MemoryCursorRow_tipo9 p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tipo9.this.A01A = copyAndCast(p_row.A01A);
      MemoryCursorRow_tipo9.this.A01B = copyAndCast(p_row.A01B);
      MemoryCursorRow_tipo9.this.A02 = copyAndCast(p_row.A02);
      MemoryCursorRow_tipo9.this.A03 = copyAndCast(p_row.A03);
      MemoryCursorRow_tipo9.this.C51 = copyAndCast(p_row.C51);
      MemoryCursorRow_tipo9.this.H11 = copyAndCast(p_row.H11);
      MemoryCursorRow_tipo9.this.H13 = copyAndCast(p_row.H13);
      MemoryCursorRow_tipo9.this.H14A = copyAndCast(p_row.H14A);
      MemoryCursorRow_tipo9.this.H14B = copyAndCast(p_row.H14B);
      MemoryCursorRow_tipo9.this.H14C = copyAndCast(p_row.H14C);
      MemoryCursorRow_tipo9.this.H15 = copyAndCast(p_row.H15);
      MemoryCursorRow_tipo9.this.H16 = copyAndCast(p_row.H16);
      MemoryCursorRow_tipo9.this.H17 = copyAndCast(p_row.H17);
      MemoryCursorRow_tipo9.this.H18 = copyAndCast(p_row.H18);
      MemoryCursorRow_tipo9.this.H19 = copyAndCast(p_row.H19);
      MemoryCursorRow_tipo9.this.H41 = copyAndCast(p_row.H41);
      MemoryCursorRow_tipo9.this.H42 = copyAndCast(p_row.H42);
      MemoryCursorRow_tipo9.this.H43 = copyAndCast(p_row.H43);
      MemoryCursorRow_tipo9.this.H44 = copyAndCast(p_row.H44);
      MemoryCursorRow_tipo9.this.H45 = copyAndCast(p_row.H45);
      MemoryCursorRow_tipo9.this.PROG = copyAndCast(p_row.PROG);
      MemoryCursorRow_tipo9.this.CFESTERO = copyAndCast(p_row.CFESTERO);
      MemoryCursorRow_tipo9.this.DATAVALI = copyAndCast(p_row.DATAVALI);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"A01A","A01B","A02","A03","C51","H11","H13","H14A","H14B","H14C","H15","H16","H17","H18","H19","H41","H42","H43","H44","H45","PROG","CFESTERO","DATAVALI"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C","C","C","C","C","D","C","C","C","D","C","C","N","N","D"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Tipo intermediario","Codice intermediario","Tipo informazione","Identificativo registrazione","NDG/Connessione anagrafe","Ragione sociale","Paese di residenza","CAB Comune (Residenza)","Descrizione in chiaro (Residenza)","Sigla provincia (Residenza)","Domicilio/Sede: Indirizzo","Domicilio/Sede: CAP","Codice fiscale","Data di nascita","Comune/Paese di nascita","Tipo Documento","Numero documento","Data rilascio","Autorità e località rilascio","Sesso","Contatore","Codice Fiscale Fittizio","Data Scadenza Documento"};
    return l_names;
  }
}
