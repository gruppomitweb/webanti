public class MemoryCursorRow_tipo2_3 extends CPMemoryCursorRow {
  public MemoryCursorRow_tipo2_3() {
  }
  public MemoryCursorRow_tipo2_3(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tipo2_3 toBuild = new MemoryCursor_tipo2_3(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tipo2_3 toBuild = new MemoryCursor_tipo2_3();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String A01A = "";
  String A01B = "";
  String A02 = "";
  String A03 = "";
  String C11 = "";
  String D11 = "";
  String D13 = "";
  String D14A = "";
  String D14B = "";
  String D14C = "";
  String D15 = "";
  String D16 = "";
  String D17 = "";
  java.sql.Date D18 = CPLib.NullDate();
  String D19 = "";
  String D21 = "";
  String D22 = "";
  String D23 = "";
  String D31 = "";
  String D32 = "";
  String D41 = "";
  String D42 = "";
  java.sql.Date D43 = CPLib.NullDate();
  String D44 = "";
  String D45 = "";
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
    if ( ! (CPLib.Empty(C11))) {
      return false;
    }
    if ( ! (CPLib.Empty(D11))) {
      return false;
    }
    if ( ! (CPLib.Empty(D13))) {
      return false;
    }
    if ( ! (CPLib.Empty(D14A))) {
      return false;
    }
    if ( ! (CPLib.Empty(D14B))) {
      return false;
    }
    if ( ! (CPLib.Empty(D14C))) {
      return false;
    }
    if ( ! (CPLib.Empty(D15))) {
      return false;
    }
    if ( ! (CPLib.Empty(D16))) {
      return false;
    }
    if ( ! (CPLib.Empty(D17))) {
      return false;
    }
    if ( ! (CPLib.Empty(D18))) {
      return false;
    }
    if ( ! (CPLib.Empty(D19))) {
      return false;
    }
    if ( ! (CPLib.Empty(D21))) {
      return false;
    }
    if ( ! (CPLib.Empty(D22))) {
      return false;
    }
    if ( ! (CPLib.Empty(D23))) {
      return false;
    }
    if ( ! (CPLib.Empty(D31))) {
      return false;
    }
    if ( ! (CPLib.Empty(D32))) {
      return false;
    }
    if ( ! (CPLib.Empty(D41))) {
      return false;
    }
    if ( ! (CPLib.Empty(D42))) {
      return false;
    }
    if ( ! (CPLib.Empty(D43))) {
      return false;
    }
    if ( ! (CPLib.Empty(D44))) {
      return false;
    }
    if ( ! (CPLib.Empty(D45))) {
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
  void Copy(MemoryCursorRow_tipo2_3 p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tipo2_3.this.A01A = copyAndCast(p_row.A01A);
      MemoryCursorRow_tipo2_3.this.A01B = copyAndCast(p_row.A01B);
      MemoryCursorRow_tipo2_3.this.A02 = copyAndCast(p_row.A02);
      MemoryCursorRow_tipo2_3.this.A03 = copyAndCast(p_row.A03);
      MemoryCursorRow_tipo2_3.this.C11 = copyAndCast(p_row.C11);
      MemoryCursorRow_tipo2_3.this.D11 = copyAndCast(p_row.D11);
      MemoryCursorRow_tipo2_3.this.D13 = copyAndCast(p_row.D13);
      MemoryCursorRow_tipo2_3.this.D14A = copyAndCast(p_row.D14A);
      MemoryCursorRow_tipo2_3.this.D14B = copyAndCast(p_row.D14B);
      MemoryCursorRow_tipo2_3.this.D14C = copyAndCast(p_row.D14C);
      MemoryCursorRow_tipo2_3.this.D15 = copyAndCast(p_row.D15);
      MemoryCursorRow_tipo2_3.this.D16 = copyAndCast(p_row.D16);
      MemoryCursorRow_tipo2_3.this.D17 = copyAndCast(p_row.D17);
      MemoryCursorRow_tipo2_3.this.D18 = copyAndCast(p_row.D18);
      MemoryCursorRow_tipo2_3.this.D19 = copyAndCast(p_row.D19);
      MemoryCursorRow_tipo2_3.this.D21 = copyAndCast(p_row.D21);
      MemoryCursorRow_tipo2_3.this.D22 = copyAndCast(p_row.D22);
      MemoryCursorRow_tipo2_3.this.D23 = copyAndCast(p_row.D23);
      MemoryCursorRow_tipo2_3.this.D31 = copyAndCast(p_row.D31);
      MemoryCursorRow_tipo2_3.this.D32 = copyAndCast(p_row.D32);
      MemoryCursorRow_tipo2_3.this.D41 = copyAndCast(p_row.D41);
      MemoryCursorRow_tipo2_3.this.D42 = copyAndCast(p_row.D42);
      MemoryCursorRow_tipo2_3.this.D43 = copyAndCast(p_row.D43);
      MemoryCursorRow_tipo2_3.this.D44 = copyAndCast(p_row.D44);
      MemoryCursorRow_tipo2_3.this.D45 = copyAndCast(p_row.D45);
      MemoryCursorRow_tipo2_3.this.PROG = copyAndCast(p_row.PROG);
      MemoryCursorRow_tipo2_3.this.CFESTERO = copyAndCast(p_row.CFESTERO);
      MemoryCursorRow_tipo2_3.this.DATAVALI = copyAndCast(p_row.DATAVALI);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"A01A","A01B","A02","A03","C11","D11","D13","D14A","D14B","D14C","D15","D16","D17","D18","D19","D21","D22","D23","D31","D32","D41","D42","D43","D44","D45","PROG","CFESTERO","DATAVALI"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C","C","C","C","C","D","C","C","C","C","C","C","C","C","D","C","C","N","N","D"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Tipo Intermediario","Codice Intermediario","Tipo informazione","Identificativo registrazione","NDG/Connessione con Anagrafe","Ragione sociale","Paese di residenza","CAB Comune (Residenza)","Descrizione in chiaro (Residenza)","Sigla provincia (Residenza)","Domicilio/Sede: Indirizzo","Domicili/Sede: CAP","Codice Fiscale","Data di nascita ","Comune/Paese di nascita","Sottogruppo attività economica","Ramo/Gruppo attività econmica","Settorizzazione sintetica economica","Rapporto (Su rapporto movimentato)","Tipo Rapporto (Su rapporto movimentato)","Tipo documento","Numero documento","Data di rilascio","Autorità e località di rilascio","Sesso","Contatore","Codice Fiscale Fittizio","Data Scadenza Documento"};
    return l_names;
  }
}
