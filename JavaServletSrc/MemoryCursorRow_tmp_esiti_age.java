public class MemoryCursorRow_tmp_esiti_age extends CPMemoryCursorRow {
  public MemoryCursorRow_tmp_esiti_age() {
  }
  public MemoryCursorRow_tmp_esiti_age(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tmp_esiti_age toBuild = new MemoryCursor_tmp_esiti_age(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tmp_esiti_age toBuild = new MemoryCursor_tmp_esiti_age();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String RAGSOC = "";
  String CODFISC = "";
  String PROT = "";
  String INFO = "";
  String NFILE = "";
  String IDFILE = "";
  String PROGREC = "";
  double NUMPROG = 0;
  String COD = "";
  String SOTTCOD = "";
  String IDESITO = "";
  String DESCRICOD = "";
  String DESCRISCOD = "";
  String TIPOESITO = "";
  String CODDIP = "";
  String CONNES = "";
  java.sql.Date DATAOPE = CPLib.NullDate();
  double IMPOPE = 0;
  String NUMOPE = "";
  String IDB = "";
  double CRIGA = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(RAGSOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODFISC))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROT))) {
      return false;
    }
    if ( ! (CPLib.Empty(INFO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NFILE))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDFILE))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROGREC))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(COD))) {
      return false;
    }
    if ( ! (CPLib.Empty(SOTTCOD))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDESITO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRICOD))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRISCOD))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOESITO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODDIP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNES))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDB))) {
      return false;
    }
    if ( ! (CPLib.Empty(CRIGA))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tmp_esiti_age p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tmp_esiti_age.this.RAGSOC = copyAndCast(p_row.RAGSOC);
      MemoryCursorRow_tmp_esiti_age.this.CODFISC = copyAndCast(p_row.CODFISC);
      MemoryCursorRow_tmp_esiti_age.this.PROT = copyAndCast(p_row.PROT);
      MemoryCursorRow_tmp_esiti_age.this.INFO = copyAndCast(p_row.INFO);
      MemoryCursorRow_tmp_esiti_age.this.NFILE = copyAndCast(p_row.NFILE);
      MemoryCursorRow_tmp_esiti_age.this.IDFILE = copyAndCast(p_row.IDFILE);
      MemoryCursorRow_tmp_esiti_age.this.PROGREC = copyAndCast(p_row.PROGREC);
      MemoryCursorRow_tmp_esiti_age.this.NUMPROG = copyAndCast(p_row.NUMPROG);
      MemoryCursorRow_tmp_esiti_age.this.COD = copyAndCast(p_row.COD);
      MemoryCursorRow_tmp_esiti_age.this.SOTTCOD = copyAndCast(p_row.SOTTCOD);
      MemoryCursorRow_tmp_esiti_age.this.IDESITO = copyAndCast(p_row.IDESITO);
      MemoryCursorRow_tmp_esiti_age.this.DESCRICOD = copyAndCast(p_row.DESCRICOD);
      MemoryCursorRow_tmp_esiti_age.this.DESCRISCOD = copyAndCast(p_row.DESCRISCOD);
      MemoryCursorRow_tmp_esiti_age.this.TIPOESITO = copyAndCast(p_row.TIPOESITO);
      MemoryCursorRow_tmp_esiti_age.this.CODDIP = copyAndCast(p_row.CODDIP);
      MemoryCursorRow_tmp_esiti_age.this.CONNES = copyAndCast(p_row.CONNES);
      MemoryCursorRow_tmp_esiti_age.this.DATAOPE = copyAndCast(p_row.DATAOPE);
      MemoryCursorRow_tmp_esiti_age.this.IMPOPE = copyAndCast(p_row.IMPOPE);
      MemoryCursorRow_tmp_esiti_age.this.NUMOPE = copyAndCast(p_row.NUMOPE);
      MemoryCursorRow_tmp_esiti_age.this.IDB = copyAndCast(p_row.IDB);
      MemoryCursorRow_tmp_esiti_age.this.CRIGA = copyAndCast(p_row.CRIGA);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"RAGSOC","CODFISC","PROT","INFO","NFILE","IDFILE","PROGREC","NUMPROG","COD","SOTTCOD","IDESITO","DESCRICOD","DESCRISCOD","TIPOESITO","CODDIP","CONNES","DATAOPE","IMPOPE","NUMOPE","IDB","CRIGA"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","N","C","C","C","M","M","C","C","C","D","N","C","C","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Ragione Sociale","Codice Fiscale","Protocollo","Informazione","File","ID File","Progressivo Record","N° Progressivo","Codice Errore","Sottocodice Errore","IDESITO","Descrizione Codice","Descrizione Sottocodice","Rapporti - Opex - Deleghe","Codice Agenzia","Codice Cliente","Data Operazione","Importo Operazione","N° Operazione","IDBASE da aggiornare","N° Riga"};
    return l_names;
  }
}
