public class MemoryCursorRow_tmp_saldi extends CPMemoryCursorRow {
  public MemoryCursorRow_tmp_saldi() {
  }
  public MemoryCursorRow_tmp_saldi(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tmp_saldi toBuild = new MemoryCursor_tmp_saldi(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tmp_saldi toBuild = new MemoryCursor_tmp_saldi();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String TIPODAT = "";
  String PROGR = "";
  String TIPORAP = "";
  String DESCRAP = "";
  String CODRAP = "";
  String CAB = "";
  String IMP1 = "";
  String IMP2 = "";
  String IMP3 = "";
  String IMP4 = "";
  String NUM = "";
  String VALUTA = "";
  String IDESITO = "";
  String PROGR2 = "";
  String IDFILE = "";
  String IDPROG = "";
  String IDBASE = "";
  String NUMPROG = "";
  String TIPO = "";
  String OLDINTER = "";
  String RAPPORTO = "";
  String TERNAFILE = "";
  String TERNAPROG = "";
  String CONNESINT = "";
  double PROGGEN = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(TIPODAT))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROGR))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPORAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODRAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMP1))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMP2))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMP3))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMP4))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUM))) {
      return false;
    }
    if ( ! (CPLib.Empty(VALUTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDESITO))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROGR2))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDFILE))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPO))) {
      return false;
    }
    if ( ! (CPLib.Empty(OLDINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TERNAFILE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TERNAPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESINT))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROGGEN))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tmp_saldi p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tmp_saldi.this.TIPODAT = copyAndCast(p_row.TIPODAT);
      MemoryCursorRow_tmp_saldi.this.PROGR = copyAndCast(p_row.PROGR);
      MemoryCursorRow_tmp_saldi.this.TIPORAP = copyAndCast(p_row.TIPORAP);
      MemoryCursorRow_tmp_saldi.this.DESCRAP = copyAndCast(p_row.DESCRAP);
      MemoryCursorRow_tmp_saldi.this.CODRAP = copyAndCast(p_row.CODRAP);
      MemoryCursorRow_tmp_saldi.this.CAB = copyAndCast(p_row.CAB);
      MemoryCursorRow_tmp_saldi.this.IMP1 = copyAndCast(p_row.IMP1);
      MemoryCursorRow_tmp_saldi.this.IMP2 = copyAndCast(p_row.IMP2);
      MemoryCursorRow_tmp_saldi.this.IMP3 = copyAndCast(p_row.IMP3);
      MemoryCursorRow_tmp_saldi.this.IMP4 = copyAndCast(p_row.IMP4);
      MemoryCursorRow_tmp_saldi.this.NUM = copyAndCast(p_row.NUM);
      MemoryCursorRow_tmp_saldi.this.VALUTA = copyAndCast(p_row.VALUTA);
      MemoryCursorRow_tmp_saldi.this.IDESITO = copyAndCast(p_row.IDESITO);
      MemoryCursorRow_tmp_saldi.this.PROGR2 = copyAndCast(p_row.PROGR2);
      MemoryCursorRow_tmp_saldi.this.IDFILE = copyAndCast(p_row.IDFILE);
      MemoryCursorRow_tmp_saldi.this.IDPROG = copyAndCast(p_row.IDPROG);
      MemoryCursorRow_tmp_saldi.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_tmp_saldi.this.NUMPROG = copyAndCast(p_row.NUMPROG);
      MemoryCursorRow_tmp_saldi.this.TIPO = copyAndCast(p_row.TIPO);
      MemoryCursorRow_tmp_saldi.this.OLDINTER = copyAndCast(p_row.OLDINTER);
      MemoryCursorRow_tmp_saldi.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_tmp_saldi.this.TERNAFILE = copyAndCast(p_row.TERNAFILE);
      MemoryCursorRow_tmp_saldi.this.TERNAPROG = copyAndCast(p_row.TERNAPROG);
      MemoryCursorRow_tmp_saldi.this.CONNESINT = copyAndCast(p_row.CONNESINT);
      MemoryCursorRow_tmp_saldi.this.PROGGEN = copyAndCast(p_row.PROGGEN);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"TIPODAT","PROGR","TIPORAP","DESCRAP","CODRAP","CAB","IMP1","IMP2","IMP3","IMP4","NUM","VALUTA","IDESITO","PROGR2","IDFILE","IDPROG","IDBASE","NUMPROG","TIPO","OLDINTER","RAPPORTO","TERNAFILE","TERNAPROG","CONNESINT","PROGGEN"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"","","","","","","","","","","","","","","","","","","","","","","","Codice Soggetto",""};
    return l_names;
  }
}
