public class MemoryCursorRow_tipo1 extends CPMemoryCursorRow {
  public MemoryCursorRow_tipo1() {
  }
  public MemoryCursorRow_tipo1(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tipo1 toBuild = new MemoryCursor_tipo1(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tipo1 toBuild = new MemoryCursor_tipo1();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String A01A = "";
  String A01B = "";
  String A02 = "";
  String A03 = "";
  String A11 = "";
  String A12A = "";
  String A12B = "";
  String A12C = "";
  java.sql.Date A21 = CPLib.NullDate();
  String A22 = "";
  String A23 = "";
  String A24 = "";
  String A25 = "";
  String A31A = "";
  String A31B = "";
  String A32 = "";
  String A33A = "";
  String A33B = "";
  String A33C = "";
  String A34 = "";
  String A41 = "";
  String A42 = "";
  String A43 = "";
  java.sql.Date A51 = CPLib.NullDate();
  String A52 = "";
  String A53 = "";
  String A54A = "";
  java.sql.Date A54B = CPLib.NullDate();
  String A54C = "";
  String B11 = "";
  String B12 = "";
  String B13 = "";
  double B14 = 0;
  double B15 = 0;
  double PROG = 0;
  String TMOV = "";
  String PRGANTI = "";
  String FONTE = "";
  String A52L = "";
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
    if ( ! (CPLib.Empty(A11))) {
      return false;
    }
    if ( ! (CPLib.Empty(A12A))) {
      return false;
    }
    if ( ! (CPLib.Empty(A12B))) {
      return false;
    }
    if ( ! (CPLib.Empty(A12C))) {
      return false;
    }
    if ( ! (CPLib.Empty(A21))) {
      return false;
    }
    if ( ! (CPLib.Empty(A22))) {
      return false;
    }
    if ( ! (CPLib.Empty(A23))) {
      return false;
    }
    if ( ! (CPLib.Empty(A24))) {
      return false;
    }
    if ( ! (CPLib.Empty(A25))) {
      return false;
    }
    if ( ! (CPLib.Empty(A31A))) {
      return false;
    }
    if ( ! (CPLib.Empty(A31B))) {
      return false;
    }
    if ( ! (CPLib.Empty(A32))) {
      return false;
    }
    if ( ! (CPLib.Empty(A33A))) {
      return false;
    }
    if ( ! (CPLib.Empty(A33B))) {
      return false;
    }
    if ( ! (CPLib.Empty(A33C))) {
      return false;
    }
    if ( ! (CPLib.Empty(A34))) {
      return false;
    }
    if ( ! (CPLib.Empty(A41))) {
      return false;
    }
    if ( ! (CPLib.Empty(A42))) {
      return false;
    }
    if ( ! (CPLib.Empty(A43))) {
      return false;
    }
    if ( ! (CPLib.Empty(A51))) {
      return false;
    }
    if ( ! (CPLib.Empty(A52))) {
      return false;
    }
    if ( ! (CPLib.Empty(A53))) {
      return false;
    }
    if ( ! (CPLib.Empty(A54A))) {
      return false;
    }
    if ( ! (CPLib.Empty(A54B))) {
      return false;
    }
    if ( ! (CPLib.Empty(A54C))) {
      return false;
    }
    if ( ! (CPLib.Empty(B11))) {
      return false;
    }
    if ( ! (CPLib.Empty(B12))) {
      return false;
    }
    if ( ! (CPLib.Empty(B13))) {
      return false;
    }
    if ( ! (CPLib.Empty(B14))) {
      return false;
    }
    if ( ! (CPLib.Empty(B15))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(TMOV))) {
      return false;
    }
    if ( ! (CPLib.Empty(PRGANTI))) {
      return false;
    }
    if ( ! (CPLib.Empty(FONTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(A52L))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tipo1 p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tipo1.this.A01A = copyAndCast(p_row.A01A);
      MemoryCursorRow_tipo1.this.A01B = copyAndCast(p_row.A01B);
      MemoryCursorRow_tipo1.this.A02 = copyAndCast(p_row.A02);
      MemoryCursorRow_tipo1.this.A03 = copyAndCast(p_row.A03);
      MemoryCursorRow_tipo1.this.A11 = copyAndCast(p_row.A11);
      MemoryCursorRow_tipo1.this.A12A = copyAndCast(p_row.A12A);
      MemoryCursorRow_tipo1.this.A12B = copyAndCast(p_row.A12B);
      MemoryCursorRow_tipo1.this.A12C = copyAndCast(p_row.A12C);
      MemoryCursorRow_tipo1.this.A21 = copyAndCast(p_row.A21);
      MemoryCursorRow_tipo1.this.A22 = copyAndCast(p_row.A22);
      MemoryCursorRow_tipo1.this.A23 = copyAndCast(p_row.A23);
      MemoryCursorRow_tipo1.this.A24 = copyAndCast(p_row.A24);
      MemoryCursorRow_tipo1.this.A25 = copyAndCast(p_row.A25);
      MemoryCursorRow_tipo1.this.A31A = copyAndCast(p_row.A31A);
      MemoryCursorRow_tipo1.this.A31B = copyAndCast(p_row.A31B);
      MemoryCursorRow_tipo1.this.A32 = copyAndCast(p_row.A32);
      MemoryCursorRow_tipo1.this.A33A = copyAndCast(p_row.A33A);
      MemoryCursorRow_tipo1.this.A33B = copyAndCast(p_row.A33B);
      MemoryCursorRow_tipo1.this.A33C = copyAndCast(p_row.A33C);
      MemoryCursorRow_tipo1.this.A34 = copyAndCast(p_row.A34);
      MemoryCursorRow_tipo1.this.A41 = copyAndCast(p_row.A41);
      MemoryCursorRow_tipo1.this.A42 = copyAndCast(p_row.A42);
      MemoryCursorRow_tipo1.this.A43 = copyAndCast(p_row.A43);
      MemoryCursorRow_tipo1.this.A51 = copyAndCast(p_row.A51);
      MemoryCursorRow_tipo1.this.A52 = copyAndCast(p_row.A52);
      MemoryCursorRow_tipo1.this.A53 = copyAndCast(p_row.A53);
      MemoryCursorRow_tipo1.this.A54A = copyAndCast(p_row.A54A);
      MemoryCursorRow_tipo1.this.A54B = copyAndCast(p_row.A54B);
      MemoryCursorRow_tipo1.this.A54C = copyAndCast(p_row.A54C);
      MemoryCursorRow_tipo1.this.B11 = copyAndCast(p_row.B11);
      MemoryCursorRow_tipo1.this.B12 = copyAndCast(p_row.B12);
      MemoryCursorRow_tipo1.this.B13 = copyAndCast(p_row.B13);
      MemoryCursorRow_tipo1.this.B14 = copyAndCast(p_row.B14);
      MemoryCursorRow_tipo1.this.B15 = copyAndCast(p_row.B15);
      MemoryCursorRow_tipo1.this.PROG = copyAndCast(p_row.PROG);
      MemoryCursorRow_tipo1.this.TMOV = copyAndCast(p_row.TMOV);
      MemoryCursorRow_tipo1.this.PRGANTI = copyAndCast(p_row.PRGANTI);
      MemoryCursorRow_tipo1.this.FONTE = copyAndCast(p_row.FONTE);
      MemoryCursorRow_tipo1.this.A52L = copyAndCast(p_row.A52L);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"A01A","A01B","A02","A03","A11","A12A","A12B","A12C","A21","A22","A23","A24","A25","A31A","A31B","A32","A33A","A33B","A33C","A34","A41","A42","A43","A51","A52","A53","A54A","A54B","A54C","B11","B12","B13","B14","B15","PROG","TMOV","PRGANTI","FONTE","A52L"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","D","C","C","C","C","C","C","C","C","C","C","C","C","C","C","D","C","C","C","D","C","C","C","C","N","N","N","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Tipo Intermediario","Codice Intermediario","Tipo Informazione","Identificativo registrazione","Codice interno della dipendenza","Codice CAB Comune","Descrizione in chiaro","Sigla Provincia","Data dell'operazione","Flal Frazionata/Multipla","Flag Contanti","Codice Causale Analitica","Codice Voce","Tipo Intermediario","Codice (Secondo il tipo)","Paese estero dell'intermediario","Codice CAB (Intermediario Controparte)","Descrizione in chiaro (Intermediario Controparte)","Sigla Provincia (Intermediario Controparte)","Descrizione intermediario della controparte","Rapporto","Tipo Rapporto","Tipo Legame","Data di Registrazione","Tipo di registrazione","Connessione tra registrazioni","Codice Stato ","Data della rettifica ","Identificativo registarzione modificata","Euro o divise non UEM","Codice Divisa","Segno Monetario","Importo Totale","Importo \"Di cui contante\"","Contatore","Tipo Movimento","Progressivo effettivo antiriciclaggio","tabella di provenienza del dato",""};
    return l_names;
  }
}
