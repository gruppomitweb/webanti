public class MemoryCursorRow_processi extends CPMemoryCursorRow {
  public MemoryCursorRow_processi() {
  }
  public MemoryCursorRow_processi(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_processi toBuild = new MemoryCursor_processi(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_processi toBuild = new MemoryCursor_processi();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String PR_TIPO = "";
  String PRCODICE = "";
  String PRDESCRI = "";
  java.sql.Timestamp PRDOSTART = CPLib.NullDateTime();
  java.sql.Timestamp PRDOSTOP = CPLib.NullDateTime();
  String PRESITO = "";
  String PRFILEOUT = "";
  String PTRIPOOUT = "";
  String PRGMSGSTA = "";
  String PRNOMEFILE = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(PR_TIPO))) {
      return false;
    }
    if ( ! (CPLib.Empty(PRCODICE))) {
      return false;
    }
    if ( ! (CPLib.Empty(PRDESCRI))) {
      return false;
    }
    if ( ! (CPLib.Empty(PRDOSTART))) {
      return false;
    }
    if ( ! (CPLib.Empty(PRDOSTOP))) {
      return false;
    }
    if ( ! (CPLib.Empty(PRESITO))) {
      return false;
    }
    if ( ! (CPLib.Empty(PRFILEOUT))) {
      return false;
    }
    if ( ! (CPLib.Empty(PTRIPOOUT))) {
      return false;
    }
    if ( ! (CPLib.Empty(PRGMSGSTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(PRNOMEFILE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_processi p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_processi.this.PR_TIPO = copyAndCast(p_row.PR_TIPO);
      MemoryCursorRow_processi.this.PRCODICE = copyAndCast(p_row.PRCODICE);
      MemoryCursorRow_processi.this.PRDESCRI = copyAndCast(p_row.PRDESCRI);
      MemoryCursorRow_processi.this.PRDOSTART = copyAndCast(p_row.PRDOSTART);
      MemoryCursorRow_processi.this.PRDOSTOP = copyAndCast(p_row.PRDOSTOP);
      MemoryCursorRow_processi.this.PRESITO = copyAndCast(p_row.PRESITO);
      MemoryCursorRow_processi.this.PRFILEOUT = copyAndCast(p_row.PRFILEOUT);
      MemoryCursorRow_processi.this.PTRIPOOUT = copyAndCast(p_row.PTRIPOOUT);
      MemoryCursorRow_processi.this.PRGMSGSTA = copyAndCast(p_row.PRGMSGSTA);
      MemoryCursorRow_processi.this.PRNOMEFILE = copyAndCast(p_row.PRNOMEFILE);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"PR_TIPO","PRCODICE","PRDESCRI","PRDOSTART","PRDOSTOP","PRESITO","PRFILEOUT","PTRIPOOUT","PRGMSGSTA","PRNOMEFILE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","T","T","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Tipo Processo","Codice Processo","Descrizione","Data E Ora Inizio","Data e Ora Fine","Esito","Nome File Output","Tipo File Output","Messaggio di stato","Nome File senza Path"};
    return l_names;
  }
}
