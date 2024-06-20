public class MemoryCursorRow_tmp_import_rtra extends CPMemoryCursorRow {
  public MemoryCursorRow_tmp_import_rtra() {
  }
  public MemoryCursorRow_tmp_import_rtra(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tmp_import_rtra toBuild = new MemoryCursor_tmp_import_rtra(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tmp_import_rtra toBuild = new MemoryCursor_tmp_import_rtra();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String IDBASE = "";
  String NUMPROG = "";
  java.sql.Date DATAOPE = CPLib.NullDate();
  String TIPOINTER = "";
  String CODINTER = "";
  String TIPOINF = "";
  String IDEREG = "";
  String CODDIPE = "";
  String DESCCIT = "";
  String PROVINCIA = "";
  String CODCAB = "";
  String FLAGFRAZ = "";
  String FLAGCONT = "";
  String CODANA = "";
  String CODVOC = "";
  String TIPOINT2 = "";
  String CODINT2 = "";
  String PAESE = "";
  String DESC2 = "";
  String PROV2 = "";
  String CODCAB2 = "";
  String DESCINTER = "";
  String RAPPORTO = "";
  String FLAGRAP = "";
  String TIPOLEG = "";
  java.sql.Date DATAREG = CPLib.NullDate();
  String OPRAP = "";
  String TIPOOPRAP = "";
  String FLAGLIRE = "";
  String VALUTA = "";
  String SEGNO = "";
  double TOTLIRE = 0;
  double TOTCONT = 0;
  String STATOREG = "";
  String OPERAZMOD = "";
  java.sql.Date DATARETT = CPLib.NullDate();
  String CONNESCLI = "";
  String CONNESOPER = "";
  String CONNESBEN = "";
  String COLLEG = "";
  double CAMBIO = 0;
  String RAPPORTBEN = "";
  String FLAGRAP2 = "";
  String OPERATORE = "";
  String AUTOM = "";
  String idcauana = "";
  String OPERAG = "";
  String DOCFILE = "";
  String RESPINS = "";
  String INFORM = "";
  String CDATOPE = "";
  double NOPROT = 0;
  String UCODE = "";
  String CDATAOPE = "";
  String ZCPARTE = "";
  String RAGIO = "";
  String MODSVOL = "";
  String AREAGEO = "";
  String RIFIMP = "";
  String SCOPO = "";
  String NATURA = "";
  double RTIPO = 0;
  double RCOMP = 0;
  double RIMP = 0;
  double RFREQ = 0;
  double RRAGIO = 0;
  double RAREA = 0;
  String TIPO = "";
  double PRGIMPOPE = 0;
  String UNIQUECODE = "";
  String AMMONT = "";
  String DURAT = "";
  String CONNALTRO = "";
  String CONNESDOC = "";
  String C_RAG = "";
  String C_STA = "";
  String C_CTA = "";
  String C_CAB = "";
  String C_PRV = "";
  String C_IND = "";
  String C_CAP = "";
  java.sql.Date DATAIMP = CPLib.NullDate();
  String C_RAPPORTO = "";
  String PAGASOGOP = "";
  String MTCN = "";
  String IDFILE = "";
  String CDATREG = "";
  double ANNOOPE = 0;
  double IMPIN = 0;
  double IMPOUT = 0;
  String RAGSOC = "";
  String DOMICILIO = "";
  String TIPODOC = "";
  String NUMDOCUM = "";
  java.sql.Date DATARILASC = CPLib.NullDate();
  String AUTRILASC = "";
  String CLIDESCCIT = "";
  String CLIPROVINCIA = "";
  String CLIPAESE = "";
  String CLICAP = "";
  java.sql.Date DATAVALI = CPLib.NullDate();
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOINF))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDEREG))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODDIPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCCIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVINCIA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGFRAZ))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGCONT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODANA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODVOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOINT2))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODINT2))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESC2))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROV2))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCAB2))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGRAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOLEG))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAREG))) {
      return false;
    }
    if ( ! (CPLib.Empty(OPRAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOOPRAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGLIRE))) {
      return false;
    }
    if ( ! (CPLib.Empty(VALUTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(SEGNO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTLIRE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTCONT))) {
      return false;
    }
    if ( ! (CPLib.Empty(STATOREG))) {
      return false;
    }
    if ( ! (CPLib.Empty(OPERAZMOD))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATARETT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESCLI))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESOPER))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESBEN))) {
      return false;
    }
    if ( ! (CPLib.Empty(COLLEG))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAMBIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPPORTBEN))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGRAP2))) {
      return false;
    }
    if ( ! (CPLib.Empty(OPERATORE))) {
      return false;
    }
    if ( ! (CPLib.Empty(AUTOM))) {
      return false;
    }
    if ( ! (CPLib.Empty(idcauana))) {
      return false;
    }
    if ( ! (CPLib.Empty(OPERAG))) {
      return false;
    }
    if ( ! (CPLib.Empty(DOCFILE))) {
      return false;
    }
    if ( ! (CPLib.Empty(RESPINS))) {
      return false;
    }
    if ( ! (CPLib.Empty(INFORM))) {
      return false;
    }
    if ( ! (CPLib.Empty(CDATOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOPROT))) {
      return false;
    }
    if ( ! (CPLib.Empty(UCODE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CDATAOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(ZCPARTE))) {
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
    if ( ! (CPLib.Empty(RIFIMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(SCOPO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NATURA))) {
      return false;
    }
    if ( ! (CPLib.Empty(RTIPO))) {
      return false;
    }
    if ( ! (CPLib.Empty(RCOMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(RIMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(RFREQ))) {
      return false;
    }
    if ( ! (CPLib.Empty(RRAGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAREA))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPO))) {
      return false;
    }
    if ( ! (CPLib.Empty(PRGIMPOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(UNIQUECODE))) {
      return false;
    }
    if ( ! (CPLib.Empty(AMMONT))) {
      return false;
    }
    if ( ! (CPLib.Empty(DURAT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNALTRO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESDOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(C_RAG))) {
      return false;
    }
    if ( ! (CPLib.Empty(C_STA))) {
      return false;
    }
    if ( ! (CPLib.Empty(C_CTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(C_CAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(C_PRV))) {
      return false;
    }
    if ( ! (CPLib.Empty(C_IND))) {
      return false;
    }
    if ( ! (CPLib.Empty(C_CAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAIMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(C_RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAGASOGOP))) {
      return false;
    }
    if ( ! (CPLib.Empty(MTCN))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDFILE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CDATREG))) {
      return false;
    }
    if ( ! (CPLib.Empty(ANNOOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPIN))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPOUT))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGSOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(DOMICILIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPODOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMDOCUM))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATARILASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(AUTRILASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(CLIDESCCIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CLIPROVINCIA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CLIPAESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CLICAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAVALI))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tmp_import_rtra p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tmp_import_rtra.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_tmp_import_rtra.this.NUMPROG = copyAndCast(p_row.NUMPROG);
      MemoryCursorRow_tmp_import_rtra.this.DATAOPE = copyAndCast(p_row.DATAOPE);
      MemoryCursorRow_tmp_import_rtra.this.TIPOINTER = copyAndCast(p_row.TIPOINTER);
      MemoryCursorRow_tmp_import_rtra.this.CODINTER = copyAndCast(p_row.CODINTER);
      MemoryCursorRow_tmp_import_rtra.this.TIPOINF = copyAndCast(p_row.TIPOINF);
      MemoryCursorRow_tmp_import_rtra.this.IDEREG = copyAndCast(p_row.IDEREG);
      MemoryCursorRow_tmp_import_rtra.this.CODDIPE = copyAndCast(p_row.CODDIPE);
      MemoryCursorRow_tmp_import_rtra.this.DESCCIT = copyAndCast(p_row.DESCCIT);
      MemoryCursorRow_tmp_import_rtra.this.PROVINCIA = copyAndCast(p_row.PROVINCIA);
      MemoryCursorRow_tmp_import_rtra.this.CODCAB = copyAndCast(p_row.CODCAB);
      MemoryCursorRow_tmp_import_rtra.this.FLAGFRAZ = copyAndCast(p_row.FLAGFRAZ);
      MemoryCursorRow_tmp_import_rtra.this.FLAGCONT = copyAndCast(p_row.FLAGCONT);
      MemoryCursorRow_tmp_import_rtra.this.CODANA = copyAndCast(p_row.CODANA);
      MemoryCursorRow_tmp_import_rtra.this.CODVOC = copyAndCast(p_row.CODVOC);
      MemoryCursorRow_tmp_import_rtra.this.TIPOINT2 = copyAndCast(p_row.TIPOINT2);
      MemoryCursorRow_tmp_import_rtra.this.CODINT2 = copyAndCast(p_row.CODINT2);
      MemoryCursorRow_tmp_import_rtra.this.PAESE = copyAndCast(p_row.PAESE);
      MemoryCursorRow_tmp_import_rtra.this.DESC2 = copyAndCast(p_row.DESC2);
      MemoryCursorRow_tmp_import_rtra.this.PROV2 = copyAndCast(p_row.PROV2);
      MemoryCursorRow_tmp_import_rtra.this.CODCAB2 = copyAndCast(p_row.CODCAB2);
      MemoryCursorRow_tmp_import_rtra.this.DESCINTER = copyAndCast(p_row.DESCINTER);
      MemoryCursorRow_tmp_import_rtra.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_tmp_import_rtra.this.FLAGRAP = copyAndCast(p_row.FLAGRAP);
      MemoryCursorRow_tmp_import_rtra.this.TIPOLEG = copyAndCast(p_row.TIPOLEG);
      MemoryCursorRow_tmp_import_rtra.this.DATAREG = copyAndCast(p_row.DATAREG);
      MemoryCursorRow_tmp_import_rtra.this.OPRAP = copyAndCast(p_row.OPRAP);
      MemoryCursorRow_tmp_import_rtra.this.TIPOOPRAP = copyAndCast(p_row.TIPOOPRAP);
      MemoryCursorRow_tmp_import_rtra.this.FLAGLIRE = copyAndCast(p_row.FLAGLIRE);
      MemoryCursorRow_tmp_import_rtra.this.VALUTA = copyAndCast(p_row.VALUTA);
      MemoryCursorRow_tmp_import_rtra.this.SEGNO = copyAndCast(p_row.SEGNO);
      MemoryCursorRow_tmp_import_rtra.this.TOTLIRE = copyAndCast(p_row.TOTLIRE);
      MemoryCursorRow_tmp_import_rtra.this.TOTCONT = copyAndCast(p_row.TOTCONT);
      MemoryCursorRow_tmp_import_rtra.this.STATOREG = copyAndCast(p_row.STATOREG);
      MemoryCursorRow_tmp_import_rtra.this.OPERAZMOD = copyAndCast(p_row.OPERAZMOD);
      MemoryCursorRow_tmp_import_rtra.this.DATARETT = copyAndCast(p_row.DATARETT);
      MemoryCursorRow_tmp_import_rtra.this.CONNESCLI = copyAndCast(p_row.CONNESCLI);
      MemoryCursorRow_tmp_import_rtra.this.CONNESOPER = copyAndCast(p_row.CONNESOPER);
      MemoryCursorRow_tmp_import_rtra.this.CONNESBEN = copyAndCast(p_row.CONNESBEN);
      MemoryCursorRow_tmp_import_rtra.this.COLLEG = copyAndCast(p_row.COLLEG);
      MemoryCursorRow_tmp_import_rtra.this.CAMBIO = copyAndCast(p_row.CAMBIO);
      MemoryCursorRow_tmp_import_rtra.this.RAPPORTBEN = copyAndCast(p_row.RAPPORTBEN);
      MemoryCursorRow_tmp_import_rtra.this.FLAGRAP2 = copyAndCast(p_row.FLAGRAP2);
      MemoryCursorRow_tmp_import_rtra.this.OPERATORE = copyAndCast(p_row.OPERATORE);
      MemoryCursorRow_tmp_import_rtra.this.AUTOM = copyAndCast(p_row.AUTOM);
      MemoryCursorRow_tmp_import_rtra.this.idcauana = copyAndCast(p_row.idcauana);
      MemoryCursorRow_tmp_import_rtra.this.OPERAG = copyAndCast(p_row.OPERAG);
      MemoryCursorRow_tmp_import_rtra.this.DOCFILE = copyAndCast(p_row.DOCFILE);
      MemoryCursorRow_tmp_import_rtra.this.RESPINS = copyAndCast(p_row.RESPINS);
      MemoryCursorRow_tmp_import_rtra.this.INFORM = copyAndCast(p_row.INFORM);
      MemoryCursorRow_tmp_import_rtra.this.CDATOPE = copyAndCast(p_row.CDATOPE);
      MemoryCursorRow_tmp_import_rtra.this.NOPROT = copyAndCast(p_row.NOPROT);
      MemoryCursorRow_tmp_import_rtra.this.UCODE = copyAndCast(p_row.UCODE);
      MemoryCursorRow_tmp_import_rtra.this.CDATAOPE = copyAndCast(p_row.CDATAOPE);
      MemoryCursorRow_tmp_import_rtra.this.ZCPARTE = copyAndCast(p_row.ZCPARTE);
      MemoryCursorRow_tmp_import_rtra.this.RAGIO = copyAndCast(p_row.RAGIO);
      MemoryCursorRow_tmp_import_rtra.this.MODSVOL = copyAndCast(p_row.MODSVOL);
      MemoryCursorRow_tmp_import_rtra.this.AREAGEO = copyAndCast(p_row.AREAGEO);
      MemoryCursorRow_tmp_import_rtra.this.RIFIMP = copyAndCast(p_row.RIFIMP);
      MemoryCursorRow_tmp_import_rtra.this.SCOPO = copyAndCast(p_row.SCOPO);
      MemoryCursorRow_tmp_import_rtra.this.NATURA = copyAndCast(p_row.NATURA);
      MemoryCursorRow_tmp_import_rtra.this.RTIPO = copyAndCast(p_row.RTIPO);
      MemoryCursorRow_tmp_import_rtra.this.RCOMP = copyAndCast(p_row.RCOMP);
      MemoryCursorRow_tmp_import_rtra.this.RIMP = copyAndCast(p_row.RIMP);
      MemoryCursorRow_tmp_import_rtra.this.RFREQ = copyAndCast(p_row.RFREQ);
      MemoryCursorRow_tmp_import_rtra.this.RRAGIO = copyAndCast(p_row.RRAGIO);
      MemoryCursorRow_tmp_import_rtra.this.RAREA = copyAndCast(p_row.RAREA);
      MemoryCursorRow_tmp_import_rtra.this.TIPO = copyAndCast(p_row.TIPO);
      MemoryCursorRow_tmp_import_rtra.this.PRGIMPOPE = copyAndCast(p_row.PRGIMPOPE);
      MemoryCursorRow_tmp_import_rtra.this.UNIQUECODE = copyAndCast(p_row.UNIQUECODE);
      MemoryCursorRow_tmp_import_rtra.this.AMMONT = copyAndCast(p_row.AMMONT);
      MemoryCursorRow_tmp_import_rtra.this.DURAT = copyAndCast(p_row.DURAT);
      MemoryCursorRow_tmp_import_rtra.this.CONNALTRO = copyAndCast(p_row.CONNALTRO);
      MemoryCursorRow_tmp_import_rtra.this.CONNESDOC = copyAndCast(p_row.CONNESDOC);
      MemoryCursorRow_tmp_import_rtra.this.C_RAG = copyAndCast(p_row.C_RAG);
      MemoryCursorRow_tmp_import_rtra.this.C_STA = copyAndCast(p_row.C_STA);
      MemoryCursorRow_tmp_import_rtra.this.C_CTA = copyAndCast(p_row.C_CTA);
      MemoryCursorRow_tmp_import_rtra.this.C_CAB = copyAndCast(p_row.C_CAB);
      MemoryCursorRow_tmp_import_rtra.this.C_PRV = copyAndCast(p_row.C_PRV);
      MemoryCursorRow_tmp_import_rtra.this.C_IND = copyAndCast(p_row.C_IND);
      MemoryCursorRow_tmp_import_rtra.this.C_CAP = copyAndCast(p_row.C_CAP);
      MemoryCursorRow_tmp_import_rtra.this.DATAIMP = copyAndCast(p_row.DATAIMP);
      MemoryCursorRow_tmp_import_rtra.this.C_RAPPORTO = copyAndCast(p_row.C_RAPPORTO);
      MemoryCursorRow_tmp_import_rtra.this.PAGASOGOP = copyAndCast(p_row.PAGASOGOP);
      MemoryCursorRow_tmp_import_rtra.this.MTCN = copyAndCast(p_row.MTCN);
      MemoryCursorRow_tmp_import_rtra.this.IDFILE = copyAndCast(p_row.IDFILE);
      MemoryCursorRow_tmp_import_rtra.this.CDATREG = copyAndCast(p_row.CDATREG);
      MemoryCursorRow_tmp_import_rtra.this.ANNOOPE = copyAndCast(p_row.ANNOOPE);
      MemoryCursorRow_tmp_import_rtra.this.IMPIN = copyAndCast(p_row.IMPIN);
      MemoryCursorRow_tmp_import_rtra.this.IMPOUT = copyAndCast(p_row.IMPOUT);
      MemoryCursorRow_tmp_import_rtra.this.RAGSOC = copyAndCast(p_row.RAGSOC);
      MemoryCursorRow_tmp_import_rtra.this.DOMICILIO = copyAndCast(p_row.DOMICILIO);
      MemoryCursorRow_tmp_import_rtra.this.TIPODOC = copyAndCast(p_row.TIPODOC);
      MemoryCursorRow_tmp_import_rtra.this.NUMDOCUM = copyAndCast(p_row.NUMDOCUM);
      MemoryCursorRow_tmp_import_rtra.this.DATARILASC = copyAndCast(p_row.DATARILASC);
      MemoryCursorRow_tmp_import_rtra.this.AUTRILASC = copyAndCast(p_row.AUTRILASC);
      MemoryCursorRow_tmp_import_rtra.this.CLIDESCCIT = copyAndCast(p_row.CLIDESCCIT);
      MemoryCursorRow_tmp_import_rtra.this.CLIPROVINCIA = copyAndCast(p_row.CLIPROVINCIA);
      MemoryCursorRow_tmp_import_rtra.this.CLIPAESE = copyAndCast(p_row.CLIPAESE);
      MemoryCursorRow_tmp_import_rtra.this.CLICAP = copyAndCast(p_row.CLICAP);
      MemoryCursorRow_tmp_import_rtra.this.DATAVALI = copyAndCast(p_row.DATAVALI);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"IDBASE","NUMPROG","DATAOPE","TIPOINTER","CODINTER","TIPOINF","IDEREG","CODDIPE","DESCCIT","PROVINCIA","CODCAB","FLAGFRAZ","FLAGCONT","CODANA","CODVOC","TIPOINT2","CODINT2","PAESE","DESC2","PROV2","CODCAB2","DESCINTER","RAPPORTO","FLAGRAP","TIPOLEG","DATAREG","OPRAP","TIPOOPRAP","FLAGLIRE","VALUTA","SEGNO","TOTLIRE","TOTCONT","STATOREG","OPERAZMOD","DATARETT","CONNESCLI","CONNESOPER","CONNESBEN","COLLEG","CAMBIO","RAPPORTBEN","FLAGRAP2","OPERATORE","AUTOM","idcauana","OPERAG","DOCFILE","RESPINS","INFORM","CDATOPE","NOPROT","UCODE","CDATAOPE","ZCPARTE","RAGIO","MODSVOL","AREAGEO","RIFIMP","SCOPO","NATURA","RTIPO","RCOMP","RIMP","RFREQ","RRAGIO","RAREA","TIPO","PRGIMPOPE","UNIQUECODE","AMMONT","DURAT","CONNALTRO","CONNESDOC","C_RAG","C_STA","C_CTA","C_CAB","C_PRV","C_IND","C_CAP","DATAIMP","C_RAPPORTO","PAGASOGOP","MTCN","IDFILE","CDATREG","ANNOOPE","IMPIN","IMPOUT","RAGSOC","DOMICILIO","TIPODOC","NUMDOCUM","DATARILASC","AUTRILASC","CLIDESCCIT","CLIPROVINCIA","CLIPAESE","CLICAP","DATAVALI"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","D","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","D","C","C","C","C","C","N","N","C","C","D","C","C","C","C","N","C","C","C","C","C","C","C","C","C","C","N","C","C","C","C","C","C","C","C","C","N","N","N","N","N","N","C","N","C","C","C","C","C","C","C","C","C","C","C","C","D","C","C","C","C","C","N","N","N","C","C","C","C","D","C","C","C","C","C","D"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Idbase","Numero Progressivo","Data Operazione","Tipo Intermediaro","Codice Intermediario","Tipo Informazione","ID Registrazione","Codice Dipendenza","Città Dipendenza","Provincia Dipendenza","CAB Dipendenza","Frazionata (S/N)","Contanti (S/N)","Causale Analitica","Causale Sintetica","Tipo Intermediario C/Parte","Codice Intermediario C/Parte","Stato Intermediario C/Parte","Denominazione Intermediario C/Parte","Provincia Intermediario C/Parte","CAB Intermediario C/Parte","","Rapporto Collegato","Tipo Rapporto Collegato","Tipo Legame sogg. Operante","Data registrazione","Tipo operazione","Tipo Operazione Completa","Lire Euro Valuta","Divisa","Segno","Totale Operazione","di cui contanti","Stato registrazione","Operazione Modificata","Data Rettifica","Codice Cliente Occasionale","Soggetto Operante Conto Terzi","Beneficiario","Collegamento Operazione Multiple","Cambio","Rapporto Beneficiario","Tipo Rapporto Beneficiario","Operatore","Importazione da file esterno","ID BASE Causale Analitica","","","","","Data Operazione in Carattere","","","","","Ragionevolezza","Modalità Svolgimento","Area Geografica","","","","","","","","","","","Progressivo Import","Codice univoco per importazioni di n sogetti operanti","","","","Connessione Tabella Storico Documenti","","","","","","","","","","","Riferimento operazione WU","Identificativo File","Data Registrazione in carattere","Anno Operazione (MT/IDP)","Importo IN","Importo OUT","Ragione Sociale","Indirizzo","Tipo Documento","Numero Doc.","Data Rilascio Doc.","Autorità di rilascio","Città","Provincia","Stato","CAP",""};
    return l_names;
  }
}
