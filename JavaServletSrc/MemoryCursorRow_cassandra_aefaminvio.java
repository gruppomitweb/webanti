public class MemoryCursorRow_cassandra_aefaminvio extends CPMemoryCursorRow {
  public MemoryCursorRow_cassandra_aefaminvio() {
  }
  public MemoryCursorRow_cassandra_aefaminvio(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_cassandra_aefaminvio toBuild = new MemoryCursor_cassandra_aefaminvio(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_cassandra_aefaminvio toBuild = new MemoryCursor_cassandra_aefaminvio();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String IDBASE = "";
  String IDIDBASE = "";
  String TIPO = "";
  String TIPOINVIO = "";
  String ANNO = "";
  String MESE = "";
  String TIPOCOM = "";
  java.sql.Date OLDDATA = CPLib.NullDate();
  String RAPPORTO = "";
  String NOMEFILE = "";
  String FILEINV1 = "";
  String FILEINV2 = "";
  double PROG = 0;
  String PROTOCOLLO = "";
  String CODERROR = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDIDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOINVIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(ANNO))) {
      return false;
    }
    if ( ! (CPLib.Empty(MESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOCOM))) {
      return false;
    }
    if ( ! (CPLib.Empty(OLDDATA))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOMEFILE))) {
      return false;
    }
    if ( ! (CPLib.Empty(FILEINV1))) {
      return false;
    }
    if ( ! (CPLib.Empty(FILEINV2))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROTOCOLLO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODERROR))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_cassandra_aefaminvio p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_cassandra_aefaminvio.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_cassandra_aefaminvio.this.IDIDBASE = copyAndCast(p_row.IDIDBASE);
      MemoryCursorRow_cassandra_aefaminvio.this.TIPO = copyAndCast(p_row.TIPO);
      MemoryCursorRow_cassandra_aefaminvio.this.TIPOINVIO = copyAndCast(p_row.TIPOINVIO);
      MemoryCursorRow_cassandra_aefaminvio.this.ANNO = copyAndCast(p_row.ANNO);
      MemoryCursorRow_cassandra_aefaminvio.this.MESE = copyAndCast(p_row.MESE);
      MemoryCursorRow_cassandra_aefaminvio.this.TIPOCOM = copyAndCast(p_row.TIPOCOM);
      MemoryCursorRow_cassandra_aefaminvio.this.OLDDATA = copyAndCast(p_row.OLDDATA);
      MemoryCursorRow_cassandra_aefaminvio.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_cassandra_aefaminvio.this.NOMEFILE = copyAndCast(p_row.NOMEFILE);
      MemoryCursorRow_cassandra_aefaminvio.this.FILEINV1 = copyAndCast(p_row.FILEINV1);
      MemoryCursorRow_cassandra_aefaminvio.this.FILEINV2 = copyAndCast(p_row.FILEINV2);
      MemoryCursorRow_cassandra_aefaminvio.this.PROG = copyAndCast(p_row.PROG);
      MemoryCursorRow_cassandra_aefaminvio.this.PROTOCOLLO = copyAndCast(p_row.PROTOCOLLO);
      MemoryCursorRow_cassandra_aefaminvio.this.CODERROR = copyAndCast(p_row.CODERROR);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"IDBASE","IDIDBASE","TIPO","TIPOINVIO","ANNO","MESE","TIPOCOM","OLDDATA","RAPPORTO","NOMEFILE","FILEINV1","FILEINV2","PROG","PROTOCOLLO","CODERROR"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","D","C","C","C","C","N","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"ID Registrazione","ID Base record aetesta/opextrbo","Tipo Registrazione","Tipo Invio","Anno Riferimento","Mese Riferimento","Tipo Comunicazione","Data precedente","Rapporto","Nome File","ID File Invio 1","ID FIle Invio 2","Progressivo","Protocollo","Codice Errore"};
    return l_names;
  }
}
