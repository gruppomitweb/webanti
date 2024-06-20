public class MemoryCursorRow_tmp_imp_oper extends CPMemoryCursorRow {
  public MemoryCursorRow_tmp_imp_oper() {
  }
  public MemoryCursorRow_tmp_imp_oper(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tmp_imp_oper toBuild = new MemoryCursor_tmp_imp_oper(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tmp_imp_oper toBuild = new MemoryCursor_tmp_imp_oper();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String TIPOOPER = "";
  String CODSTUDIO = "";
  String CODDIPE = "";
  String NUMPROG = "";
  String DATAOPE = "";
  String FLAGFRAZ = "";
  String CAUOPER = "";
  String CONNESCLI = "";
  String CONNESREAL = "";
  String CONNESBEN = "";
  String DATAREG = "";
  String STATOREG = "";
  String DATARETT = "";
  String VALUTA = "";
  double IMPORTO = 0;
  double CONTANTI = 0;
  String MEZPAG = "";
  String PRESTAZ = "";
  String POSIZ = "";
  String RAGIO = "";
  String MODSVOL = "";
  String AREAGEO = "";
  String TIPO = "";
  String AMMONT = "";
  String DURAT = "";
  double RAREA = 0;
  double RRAGIO = 0;
  double RCOMP = 0;
  double RTIPO = 0;
  double RFREQ = 0;
  double RIMP = 0;
  String CODABI = "";
  String CODCAB = "";
  String CONNALTRO = "";
  String IMPPROG = "";
  String DESPUNTO = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(TIPOOPER))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODSTUDIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODDIPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGFRAZ))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAUOPER))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESCLI))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESREAL))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESBEN))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAREG))) {
      return false;
    }
    if ( ! (CPLib.Empty(STATOREG))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATARETT))) {
      return false;
    }
    if ( ! (CPLib.Empty(VALUTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONTANTI))) {
      return false;
    }
    if ( ! (CPLib.Empty(MEZPAG))) {
      return false;
    }
    if ( ! (CPLib.Empty(PRESTAZ))) {
      return false;
    }
    if ( ! (CPLib.Empty(POSIZ))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(MODSVOL))) {
      return false;
    }
    if ( ! (CPLib.Empty(AREAGEO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPO))) {
      return false;
    }
    if ( ! (CPLib.Empty(AMMONT))) {
      return false;
    }
    if ( ! (CPLib.Empty(DURAT))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAREA))) {
      return false;
    }
    if ( ! (CPLib.Empty(RRAGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(RCOMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(RTIPO))) {
      return false;
    }
    if ( ! (CPLib.Empty(RFREQ))) {
      return false;
    }
    if ( ! (CPLib.Empty(RIMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODABI))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNALTRO))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESPUNTO))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tmp_imp_oper p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tmp_imp_oper.this.TIPOOPER = copyAndCast(p_row.TIPOOPER);
      MemoryCursorRow_tmp_imp_oper.this.CODSTUDIO = copyAndCast(p_row.CODSTUDIO);
      MemoryCursorRow_tmp_imp_oper.this.CODDIPE = copyAndCast(p_row.CODDIPE);
      MemoryCursorRow_tmp_imp_oper.this.NUMPROG = copyAndCast(p_row.NUMPROG);
      MemoryCursorRow_tmp_imp_oper.this.DATAOPE = copyAndCast(p_row.DATAOPE);
      MemoryCursorRow_tmp_imp_oper.this.FLAGFRAZ = copyAndCast(p_row.FLAGFRAZ);
      MemoryCursorRow_tmp_imp_oper.this.CAUOPER = copyAndCast(p_row.CAUOPER);
      MemoryCursorRow_tmp_imp_oper.this.CONNESCLI = copyAndCast(p_row.CONNESCLI);
      MemoryCursorRow_tmp_imp_oper.this.CONNESREAL = copyAndCast(p_row.CONNESREAL);
      MemoryCursorRow_tmp_imp_oper.this.CONNESBEN = copyAndCast(p_row.CONNESBEN);
      MemoryCursorRow_tmp_imp_oper.this.DATAREG = copyAndCast(p_row.DATAREG);
      MemoryCursorRow_tmp_imp_oper.this.STATOREG = copyAndCast(p_row.STATOREG);
      MemoryCursorRow_tmp_imp_oper.this.DATARETT = copyAndCast(p_row.DATARETT);
      MemoryCursorRow_tmp_imp_oper.this.VALUTA = copyAndCast(p_row.VALUTA);
      MemoryCursorRow_tmp_imp_oper.this.IMPORTO = copyAndCast(p_row.IMPORTO);
      MemoryCursorRow_tmp_imp_oper.this.CONTANTI = copyAndCast(p_row.CONTANTI);
      MemoryCursorRow_tmp_imp_oper.this.MEZPAG = copyAndCast(p_row.MEZPAG);
      MemoryCursorRow_tmp_imp_oper.this.PRESTAZ = copyAndCast(p_row.PRESTAZ);
      MemoryCursorRow_tmp_imp_oper.this.POSIZ = copyAndCast(p_row.POSIZ);
      MemoryCursorRow_tmp_imp_oper.this.RAGIO = copyAndCast(p_row.RAGIO);
      MemoryCursorRow_tmp_imp_oper.this.MODSVOL = copyAndCast(p_row.MODSVOL);
      MemoryCursorRow_tmp_imp_oper.this.AREAGEO = copyAndCast(p_row.AREAGEO);
      MemoryCursorRow_tmp_imp_oper.this.TIPO = copyAndCast(p_row.TIPO);
      MemoryCursorRow_tmp_imp_oper.this.AMMONT = copyAndCast(p_row.AMMONT);
      MemoryCursorRow_tmp_imp_oper.this.DURAT = copyAndCast(p_row.DURAT);
      MemoryCursorRow_tmp_imp_oper.this.RAREA = copyAndCast(p_row.RAREA);
      MemoryCursorRow_tmp_imp_oper.this.RRAGIO = copyAndCast(p_row.RRAGIO);
      MemoryCursorRow_tmp_imp_oper.this.RCOMP = copyAndCast(p_row.RCOMP);
      MemoryCursorRow_tmp_imp_oper.this.RTIPO = copyAndCast(p_row.RTIPO);
      MemoryCursorRow_tmp_imp_oper.this.RFREQ = copyAndCast(p_row.RFREQ);
      MemoryCursorRow_tmp_imp_oper.this.RIMP = copyAndCast(p_row.RIMP);
      MemoryCursorRow_tmp_imp_oper.this.CODABI = copyAndCast(p_row.CODABI);
      MemoryCursorRow_tmp_imp_oper.this.CODCAB = copyAndCast(p_row.CODCAB);
      MemoryCursorRow_tmp_imp_oper.this.CONNALTRO = copyAndCast(p_row.CONNALTRO);
      MemoryCursorRow_tmp_imp_oper.this.IMPPROG = copyAndCast(p_row.IMPPROG);
      MemoryCursorRow_tmp_imp_oper.this.DESPUNTO = copyAndCast(p_row.DESPUNTO);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"TIPOOPER","CODSTUDIO","CODDIPE","NUMPROG","DATAOPE","FLAGFRAZ","CAUOPER","CONNESCLI","CONNESREAL","CONNESBEN","DATAREG","STATOREG","DATARETT","VALUTA","IMPORTO","CONTANTI","MEZPAG","PRESTAZ","POSIZ","RAGIO","MODSVOL","AREAGEO","TIPO","AMMONT","DURAT","RAREA","RRAGIO","RCOMP","RTIPO","RFREQ","RIMP","CODABI","CODCAB","CONNALTRO","IMPPROG","DESPUNTO"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C","C","C","C","C","C","N","N","C","C","C","C","C","C","C","C","C","N","N","N","N","N","N","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"","","","","","","","","","","","","","","","","","","","Ragionevolezza","Modalità Svolgimento","Area Geografica","","","","","","","","","","Codice ABI","Codice CAB","Titolare operazione","Progressivo Import","Descrizione Punto"};
    return l_names;
  }
}
