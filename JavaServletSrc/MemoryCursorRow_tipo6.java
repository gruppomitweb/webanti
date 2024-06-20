public class MemoryCursorRow_tipo6 extends CPMemoryCursorRow {
  public MemoryCursorRow_tipo6() {
  }
  public MemoryCursorRow_tipo6(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tipo6 toBuild = new MemoryCursor_tipo6(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tipo6 toBuild = new MemoryCursor_tipo6();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String A01A = "";
  String A01B = "";
  String A02 = "";
  String A03 = "";
  String C41 = "";
  String G11 = "";
  String G13 = "";
  String G14A = "";
  String G14B = "";
  String G14C = "";
  String G15 = "";
  String G16 = "";
  String G17 = "";
  java.sql.Date G18 = CPLib.NullDate();
  String G19 = "";
  String G41 = "";
  String G42 = "";
  java.sql.Date G43 = CPLib.NullDate();
  String G44 = "";
  String G45 = "";
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
    if ( ! (CPLib.Empty(C41))) {
      return false;
    }
    if ( ! (CPLib.Empty(G11))) {
      return false;
    }
    if ( ! (CPLib.Empty(G13))) {
      return false;
    }
    if ( ! (CPLib.Empty(G14A))) {
      return false;
    }
    if ( ! (CPLib.Empty(G14B))) {
      return false;
    }
    if ( ! (CPLib.Empty(G14C))) {
      return false;
    }
    if ( ! (CPLib.Empty(G15))) {
      return false;
    }
    if ( ! (CPLib.Empty(G16))) {
      return false;
    }
    if ( ! (CPLib.Empty(G17))) {
      return false;
    }
    if ( ! (CPLib.Empty(G18))) {
      return false;
    }
    if ( ! (CPLib.Empty(G19))) {
      return false;
    }
    if ( ! (CPLib.Empty(G41))) {
      return false;
    }
    if ( ! (CPLib.Empty(G42))) {
      return false;
    }
    if ( ! (CPLib.Empty(G43))) {
      return false;
    }
    if ( ! (CPLib.Empty(G44))) {
      return false;
    }
    if ( ! (CPLib.Empty(G45))) {
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
  void Copy(MemoryCursorRow_tipo6 p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tipo6.this.A01A = copyAndCast(p_row.A01A);
      MemoryCursorRow_tipo6.this.A01B = copyAndCast(p_row.A01B);
      MemoryCursorRow_tipo6.this.A02 = copyAndCast(p_row.A02);
      MemoryCursorRow_tipo6.this.A03 = copyAndCast(p_row.A03);
      MemoryCursorRow_tipo6.this.C41 = copyAndCast(p_row.C41);
      MemoryCursorRow_tipo6.this.G11 = copyAndCast(p_row.G11);
      MemoryCursorRow_tipo6.this.G13 = copyAndCast(p_row.G13);
      MemoryCursorRow_tipo6.this.G14A = copyAndCast(p_row.G14A);
      MemoryCursorRow_tipo6.this.G14B = copyAndCast(p_row.G14B);
      MemoryCursorRow_tipo6.this.G14C = copyAndCast(p_row.G14C);
      MemoryCursorRow_tipo6.this.G15 = copyAndCast(p_row.G15);
      MemoryCursorRow_tipo6.this.G16 = copyAndCast(p_row.G16);
      MemoryCursorRow_tipo6.this.G17 = copyAndCast(p_row.G17);
      MemoryCursorRow_tipo6.this.G18 = copyAndCast(p_row.G18);
      MemoryCursorRow_tipo6.this.G19 = copyAndCast(p_row.G19);
      MemoryCursorRow_tipo6.this.G41 = copyAndCast(p_row.G41);
      MemoryCursorRow_tipo6.this.G42 = copyAndCast(p_row.G42);
      MemoryCursorRow_tipo6.this.G43 = copyAndCast(p_row.G43);
      MemoryCursorRow_tipo6.this.G44 = copyAndCast(p_row.G44);
      MemoryCursorRow_tipo6.this.G45 = copyAndCast(p_row.G45);
      MemoryCursorRow_tipo6.this.PROG = copyAndCast(p_row.PROG);
      MemoryCursorRow_tipo6.this.CFESTERO = copyAndCast(p_row.CFESTERO);
      MemoryCursorRow_tipo6.this.DATAVALI = copyAndCast(p_row.DATAVALI);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"A01A","A01B","A02","A03","C41","G11","G13","G14A","G14B","G14C","G15","G16","G17","G18","G19","G41","G42","G43","G44","G45","PROG","CFESTERO","DATAVALI"};
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
