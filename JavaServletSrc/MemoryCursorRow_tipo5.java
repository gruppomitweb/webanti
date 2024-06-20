public class MemoryCursorRow_tipo5 extends CPMemoryCursorRow {
  public MemoryCursorRow_tipo5() {
  }
  public MemoryCursorRow_tipo5(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tipo5 toBuild = new MemoryCursor_tipo5(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tipo5 toBuild = new MemoryCursor_tipo5();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String A01A = "";
  String A01B = "";
  String A02 = "";
  String A03 = "";
  String C31 = "";
  String F11 = "";
  String F13 = "";
  String F14A = "";
  String F14B = "";
  String F14C = "";
  String F15 = "";
  String F16 = "";
  String F31 = "";
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
    if ( ! (CPLib.Empty(C31))) {
      return false;
    }
    if ( ! (CPLib.Empty(F11))) {
      return false;
    }
    if ( ! (CPLib.Empty(F13))) {
      return false;
    }
    if ( ! (CPLib.Empty(F14A))) {
      return false;
    }
    if ( ! (CPLib.Empty(F14B))) {
      return false;
    }
    if ( ! (CPLib.Empty(F14C))) {
      return false;
    }
    if ( ! (CPLib.Empty(F15))) {
      return false;
    }
    if ( ! (CPLib.Empty(F16))) {
      return false;
    }
    if ( ! (CPLib.Empty(F31))) {
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
  void Copy(MemoryCursorRow_tipo5 p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tipo5.this.A01A = copyAndCast(p_row.A01A);
      MemoryCursorRow_tipo5.this.A01B = copyAndCast(p_row.A01B);
      MemoryCursorRow_tipo5.this.A02 = copyAndCast(p_row.A02);
      MemoryCursorRow_tipo5.this.A03 = copyAndCast(p_row.A03);
      MemoryCursorRow_tipo5.this.C31 = copyAndCast(p_row.C31);
      MemoryCursorRow_tipo5.this.F11 = copyAndCast(p_row.F11);
      MemoryCursorRow_tipo5.this.F13 = copyAndCast(p_row.F13);
      MemoryCursorRow_tipo5.this.F14A = copyAndCast(p_row.F14A);
      MemoryCursorRow_tipo5.this.F14B = copyAndCast(p_row.F14B);
      MemoryCursorRow_tipo5.this.F14C = copyAndCast(p_row.F14C);
      MemoryCursorRow_tipo5.this.F15 = copyAndCast(p_row.F15);
      MemoryCursorRow_tipo5.this.F16 = copyAndCast(p_row.F16);
      MemoryCursorRow_tipo5.this.F31 = copyAndCast(p_row.F31);
      MemoryCursorRow_tipo5.this.PROG = copyAndCast(p_row.PROG);
      MemoryCursorRow_tipo5.this.CFESTERO = copyAndCast(p_row.CFESTERO);
      MemoryCursorRow_tipo5.this.DATAVALI = copyAndCast(p_row.DATAVALI);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"A01A","A01B","A02","A03","C31","F11","F13","F14A","F14B","F14C","F15","F16","F31","PROG","CFESTERO","DATAVALI"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C","C","C","C","C","N","N","D"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Tipo intermediario","Codice intermediario","Tipo informazione","Identificativo registrazione","NDG/Connessione anagrafe","Ragione sociale","Paese di residenza","CAB Comune (Residenza)","Descrizione in chiaro (Residenza)","Sigla provincia (Residenza)","Domicilio/Sede: Indirizzo","Domicilio/Sede: CAP","Rapporto","Contatore","Codice Fiscale Fittizio","Data Scadenza Documento"};
    return l_names;
  }
}
