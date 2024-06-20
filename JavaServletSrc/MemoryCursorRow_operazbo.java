public class MemoryCursorRow_operazbo extends CPMemoryCursorRow {
  public MemoryCursorRow_operazbo() {
  }
  public MemoryCursorRow_operazbo(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_operazbo toBuild = new MemoryCursor_operazbo(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_operazbo toBuild = new MemoryCursor_operazbo();
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
  String IPCOLLEG = "";
  java.sql.Timestamp ORACOLLEG = CPLib.NullDateTime();
  double DUCOLLEG = 0;
  double ANNOOPE = 0;
  String IDBASE2 = "";
  double IMPIN = 0;
  double IMPOUT = 0;
  double MITIG = 0;
  String MITIGDOC = "";
  String RISGLOB = "";
  String SV58550 = "";
  double PROQUOTA = 0;
  String TIPOORO = "";
  String DAC6 = "";
  double FLAGDAC6 = 0;
  double IMPSARA = 0;
  String SV58550MA = "";
  String NOSARA = "";
  String MEZPAG = "";
  String PRESTAZ = "";
  double CAUSALE = 0;
  java.sql.Timestamp NUMIMP = CPLib.NullDateTime();
  String DESPUNTO = "";
  String CODCLICON = "";
  String TIPATT = "";
  String IMPPROG = "";
  String NOTE = "";
  String VASP = "";
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
    if ( ! (CPLib.Empty(IPCOLLEG))) {
      return false;
    }
    if ( ! (CPLib.Empty(ORACOLLEG))) {
      return false;
    }
    if ( ! (CPLib.Empty(DUCOLLEG))) {
      return false;
    }
    if ( ! (CPLib.Empty(ANNOOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDBASE2))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPIN))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPOUT))) {
      return false;
    }
    if ( ! (CPLib.Empty(MITIG))) {
      return false;
    }
    if ( ! (CPLib.Empty(MITIGDOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(RISGLOB))) {
      return false;
    }
    if ( ! (CPLib.Empty(SV58550))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROQUOTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOORO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DAC6))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGDAC6))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPSARA))) {
      return false;
    }
    if ( ! (CPLib.Empty(SV58550MA))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOSARA))) {
      return false;
    }
    if ( ! (CPLib.Empty(MEZPAG))) {
      return false;
    }
    if ( ! (CPLib.Empty(PRESTAZ))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAUSALE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMIMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESPUNTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCLICON))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPATT))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(VASP))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_operazbo p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_operazbo.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_operazbo.this.NUMPROG = copyAndCast(p_row.NUMPROG);
      MemoryCursorRow_operazbo.this.DATAOPE = copyAndCast(p_row.DATAOPE);
      MemoryCursorRow_operazbo.this.TIPOINTER = copyAndCast(p_row.TIPOINTER);
      MemoryCursorRow_operazbo.this.CODINTER = copyAndCast(p_row.CODINTER);
      MemoryCursorRow_operazbo.this.TIPOINF = copyAndCast(p_row.TIPOINF);
      MemoryCursorRow_operazbo.this.IDEREG = copyAndCast(p_row.IDEREG);
      MemoryCursorRow_operazbo.this.CODDIPE = copyAndCast(p_row.CODDIPE);
      MemoryCursorRow_operazbo.this.DESCCIT = copyAndCast(p_row.DESCCIT);
      MemoryCursorRow_operazbo.this.PROVINCIA = copyAndCast(p_row.PROVINCIA);
      MemoryCursorRow_operazbo.this.CODCAB = copyAndCast(p_row.CODCAB);
      MemoryCursorRow_operazbo.this.FLAGFRAZ = copyAndCast(p_row.FLAGFRAZ);
      MemoryCursorRow_operazbo.this.FLAGCONT = copyAndCast(p_row.FLAGCONT);
      MemoryCursorRow_operazbo.this.CODANA = copyAndCast(p_row.CODANA);
      MemoryCursorRow_operazbo.this.CODVOC = copyAndCast(p_row.CODVOC);
      MemoryCursorRow_operazbo.this.TIPOINT2 = copyAndCast(p_row.TIPOINT2);
      MemoryCursorRow_operazbo.this.CODINT2 = copyAndCast(p_row.CODINT2);
      MemoryCursorRow_operazbo.this.PAESE = copyAndCast(p_row.PAESE);
      MemoryCursorRow_operazbo.this.DESC2 = copyAndCast(p_row.DESC2);
      MemoryCursorRow_operazbo.this.PROV2 = copyAndCast(p_row.PROV2);
      MemoryCursorRow_operazbo.this.CODCAB2 = copyAndCast(p_row.CODCAB2);
      MemoryCursorRow_operazbo.this.DESCINTER = copyAndCast(p_row.DESCINTER);
      MemoryCursorRow_operazbo.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_operazbo.this.FLAGRAP = copyAndCast(p_row.FLAGRAP);
      MemoryCursorRow_operazbo.this.TIPOLEG = copyAndCast(p_row.TIPOLEG);
      MemoryCursorRow_operazbo.this.DATAREG = copyAndCast(p_row.DATAREG);
      MemoryCursorRow_operazbo.this.OPRAP = copyAndCast(p_row.OPRAP);
      MemoryCursorRow_operazbo.this.TIPOOPRAP = copyAndCast(p_row.TIPOOPRAP);
      MemoryCursorRow_operazbo.this.FLAGLIRE = copyAndCast(p_row.FLAGLIRE);
      MemoryCursorRow_operazbo.this.VALUTA = copyAndCast(p_row.VALUTA);
      MemoryCursorRow_operazbo.this.SEGNO = copyAndCast(p_row.SEGNO);
      MemoryCursorRow_operazbo.this.TOTLIRE = copyAndCast(p_row.TOTLIRE);
      MemoryCursorRow_operazbo.this.TOTCONT = copyAndCast(p_row.TOTCONT);
      MemoryCursorRow_operazbo.this.STATOREG = copyAndCast(p_row.STATOREG);
      MemoryCursorRow_operazbo.this.OPERAZMOD = copyAndCast(p_row.OPERAZMOD);
      MemoryCursorRow_operazbo.this.DATARETT = copyAndCast(p_row.DATARETT);
      MemoryCursorRow_operazbo.this.CONNESCLI = copyAndCast(p_row.CONNESCLI);
      MemoryCursorRow_operazbo.this.CONNESOPER = copyAndCast(p_row.CONNESOPER);
      MemoryCursorRow_operazbo.this.CONNESBEN = copyAndCast(p_row.CONNESBEN);
      MemoryCursorRow_operazbo.this.COLLEG = copyAndCast(p_row.COLLEG);
      MemoryCursorRow_operazbo.this.CAMBIO = copyAndCast(p_row.CAMBIO);
      MemoryCursorRow_operazbo.this.RAPPORTBEN = copyAndCast(p_row.RAPPORTBEN);
      MemoryCursorRow_operazbo.this.FLAGRAP2 = copyAndCast(p_row.FLAGRAP2);
      MemoryCursorRow_operazbo.this.OPERATORE = copyAndCast(p_row.OPERATORE);
      MemoryCursorRow_operazbo.this.AUTOM = copyAndCast(p_row.AUTOM);
      MemoryCursorRow_operazbo.this.idcauana = copyAndCast(p_row.idcauana);
      MemoryCursorRow_operazbo.this.OPERAG = copyAndCast(p_row.OPERAG);
      MemoryCursorRow_operazbo.this.DOCFILE = copyAndCast(p_row.DOCFILE);
      MemoryCursorRow_operazbo.this.RESPINS = copyAndCast(p_row.RESPINS);
      MemoryCursorRow_operazbo.this.INFORM = copyAndCast(p_row.INFORM);
      MemoryCursorRow_operazbo.this.CDATOPE = copyAndCast(p_row.CDATOPE);
      MemoryCursorRow_operazbo.this.NOPROT = copyAndCast(p_row.NOPROT);
      MemoryCursorRow_operazbo.this.UCODE = copyAndCast(p_row.UCODE);
      MemoryCursorRow_operazbo.this.CDATAOPE = copyAndCast(p_row.CDATAOPE);
      MemoryCursorRow_operazbo.this.ZCPARTE = copyAndCast(p_row.ZCPARTE);
      MemoryCursorRow_operazbo.this.RAGIO = copyAndCast(p_row.RAGIO);
      MemoryCursorRow_operazbo.this.MODSVOL = copyAndCast(p_row.MODSVOL);
      MemoryCursorRow_operazbo.this.AREAGEO = copyAndCast(p_row.AREAGEO);
      MemoryCursorRow_operazbo.this.RIFIMP = copyAndCast(p_row.RIFIMP);
      MemoryCursorRow_operazbo.this.SCOPO = copyAndCast(p_row.SCOPO);
      MemoryCursorRow_operazbo.this.NATURA = copyAndCast(p_row.NATURA);
      MemoryCursorRow_operazbo.this.RTIPO = copyAndCast(p_row.RTIPO);
      MemoryCursorRow_operazbo.this.RCOMP = copyAndCast(p_row.RCOMP);
      MemoryCursorRow_operazbo.this.RIMP = copyAndCast(p_row.RIMP);
      MemoryCursorRow_operazbo.this.RFREQ = copyAndCast(p_row.RFREQ);
      MemoryCursorRow_operazbo.this.RRAGIO = copyAndCast(p_row.RRAGIO);
      MemoryCursorRow_operazbo.this.RAREA = copyAndCast(p_row.RAREA);
      MemoryCursorRow_operazbo.this.TIPO = copyAndCast(p_row.TIPO);
      MemoryCursorRow_operazbo.this.PRGIMPOPE = copyAndCast(p_row.PRGIMPOPE);
      MemoryCursorRow_operazbo.this.UNIQUECODE = copyAndCast(p_row.UNIQUECODE);
      MemoryCursorRow_operazbo.this.AMMONT = copyAndCast(p_row.AMMONT);
      MemoryCursorRow_operazbo.this.DURAT = copyAndCast(p_row.DURAT);
      MemoryCursorRow_operazbo.this.CONNALTRO = copyAndCast(p_row.CONNALTRO);
      MemoryCursorRow_operazbo.this.CONNESDOC = copyAndCast(p_row.CONNESDOC);
      MemoryCursorRow_operazbo.this.C_RAG = copyAndCast(p_row.C_RAG);
      MemoryCursorRow_operazbo.this.C_STA = copyAndCast(p_row.C_STA);
      MemoryCursorRow_operazbo.this.C_CTA = copyAndCast(p_row.C_CTA);
      MemoryCursorRow_operazbo.this.C_CAB = copyAndCast(p_row.C_CAB);
      MemoryCursorRow_operazbo.this.C_PRV = copyAndCast(p_row.C_PRV);
      MemoryCursorRow_operazbo.this.C_IND = copyAndCast(p_row.C_IND);
      MemoryCursorRow_operazbo.this.C_CAP = copyAndCast(p_row.C_CAP);
      MemoryCursorRow_operazbo.this.DATAIMP = copyAndCast(p_row.DATAIMP);
      MemoryCursorRow_operazbo.this.C_RAPPORTO = copyAndCast(p_row.C_RAPPORTO);
      MemoryCursorRow_operazbo.this.PAGASOGOP = copyAndCast(p_row.PAGASOGOP);
      MemoryCursorRow_operazbo.this.MTCN = copyAndCast(p_row.MTCN);
      MemoryCursorRow_operazbo.this.IDFILE = copyAndCast(p_row.IDFILE);
      MemoryCursorRow_operazbo.this.CDATREG = copyAndCast(p_row.CDATREG);
      MemoryCursorRow_operazbo.this.IPCOLLEG = copyAndCast(p_row.IPCOLLEG);
      MemoryCursorRow_operazbo.this.ORACOLLEG = copyAndCast(p_row.ORACOLLEG);
      MemoryCursorRow_operazbo.this.DUCOLLEG = copyAndCast(p_row.DUCOLLEG);
      MemoryCursorRow_operazbo.this.ANNOOPE = copyAndCast(p_row.ANNOOPE);
      MemoryCursorRow_operazbo.this.IDBASE2 = copyAndCast(p_row.IDBASE2);
      MemoryCursorRow_operazbo.this.IMPIN = copyAndCast(p_row.IMPIN);
      MemoryCursorRow_operazbo.this.IMPOUT = copyAndCast(p_row.IMPOUT);
      MemoryCursorRow_operazbo.this.MITIG = copyAndCast(p_row.MITIG);
      MemoryCursorRow_operazbo.this.MITIGDOC = copyAndCast(p_row.MITIGDOC);
      MemoryCursorRow_operazbo.this.RISGLOB = copyAndCast(p_row.RISGLOB);
      MemoryCursorRow_operazbo.this.SV58550 = copyAndCast(p_row.SV58550);
      MemoryCursorRow_operazbo.this.PROQUOTA = copyAndCast(p_row.PROQUOTA);
      MemoryCursorRow_operazbo.this.TIPOORO = copyAndCast(p_row.TIPOORO);
      MemoryCursorRow_operazbo.this.DAC6 = copyAndCast(p_row.DAC6);
      MemoryCursorRow_operazbo.this.FLAGDAC6 = copyAndCast(p_row.FLAGDAC6);
      MemoryCursorRow_operazbo.this.IMPSARA = copyAndCast(p_row.IMPSARA);
      MemoryCursorRow_operazbo.this.SV58550MA = copyAndCast(p_row.SV58550MA);
      MemoryCursorRow_operazbo.this.NOSARA = copyAndCast(p_row.NOSARA);
      MemoryCursorRow_operazbo.this.MEZPAG = copyAndCast(p_row.MEZPAG);
      MemoryCursorRow_operazbo.this.PRESTAZ = copyAndCast(p_row.PRESTAZ);
      MemoryCursorRow_operazbo.this.CAUSALE = copyAndCast(p_row.CAUSALE);
      MemoryCursorRow_operazbo.this.NUMIMP = copyAndCast(p_row.NUMIMP);
      MemoryCursorRow_operazbo.this.DESPUNTO = copyAndCast(p_row.DESPUNTO);
      MemoryCursorRow_operazbo.this.CODCLICON = copyAndCast(p_row.CODCLICON);
      MemoryCursorRow_operazbo.this.TIPATT = copyAndCast(p_row.TIPATT);
      MemoryCursorRow_operazbo.this.IMPPROG = copyAndCast(p_row.IMPPROG);
      MemoryCursorRow_operazbo.this.NOTE = copyAndCast(p_row.NOTE);
      MemoryCursorRow_operazbo.this.VASP = copyAndCast(p_row.VASP);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"IDBASE","NUMPROG","DATAOPE","TIPOINTER","CODINTER","TIPOINF","IDEREG","CODDIPE","DESCCIT","PROVINCIA","CODCAB","FLAGFRAZ","FLAGCONT","CODANA","CODVOC","TIPOINT2","CODINT2","PAESE","DESC2","PROV2","CODCAB2","DESCINTER","RAPPORTO","FLAGRAP","TIPOLEG","DATAREG","OPRAP","TIPOOPRAP","FLAGLIRE","VALUTA","SEGNO","TOTLIRE","TOTCONT","STATOREG","OPERAZMOD","DATARETT","CONNESCLI","CONNESOPER","CONNESBEN","COLLEG","CAMBIO","RAPPORTBEN","FLAGRAP2","OPERATORE","AUTOM","idcauana","OPERAG","DOCFILE","RESPINS","INFORM","CDATOPE","NOPROT","UCODE","CDATAOPE","ZCPARTE","RAGIO","MODSVOL","AREAGEO","RIFIMP","SCOPO","NATURA","RTIPO","RCOMP","RIMP","RFREQ","RRAGIO","RAREA","TIPO","PRGIMPOPE","UNIQUECODE","AMMONT","DURAT","CONNALTRO","CONNESDOC","C_RAG","C_STA","C_CTA","C_CAB","C_PRV","C_IND","C_CAP","DATAIMP","C_RAPPORTO","PAGASOGOP","MTCN","IDFILE","CDATREG","IPCOLLEG","ORACOLLEG","DUCOLLEG","ANNOOPE","IDBASE2","IMPIN","IMPOUT","MITIG","MITIGDOC","RISGLOB","SV58550","PROQUOTA","TIPOORO","DAC6","FLAGDAC6","IMPSARA","SV58550MA","NOSARA","MEZPAG","PRESTAZ","CAUSALE","NUMIMP","DESPUNTO","CODCLICON","TIPATT","IMPPROG","NOTE","VASP"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","D","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","D","C","C","C","C","C","N","N","C","C","D","C","C","C","C","N","C","C","C","C","C","C","C","C","C","C","N","C","C","C","C","C","C","C","C","C","N","N","N","N","N","N","C","N","C","C","C","C","C","C","C","C","C","C","C","C","D","C","C","C","C","C","C","T","N","N","C","N","N","N","C","C","C","N","C","C","N","N","C","C","C","C","N","T","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Idbase","Numero Progressivo","Data Operazione","Tipo Intermediaro","Codice Intermediario","Tipo Informazione","ID Registrazione","Codice Dipendenza","Città Dipendenza","Provincia Dipendenza","CAB Dipendenza","Frazionata (S/N)","Contanti (S/N)","Causale Analitica","Causale Sintetica","Tipo Intermediario C/Parte","Codice Intermediario C/Parte","Stato Intermediario C/Parte","Denominazione Intermediario C/Parte","Provincia Intermediario C/Parte","CAB Intermediario C/Parte","","Rapporto Collegato","Tipo Rapporto Collegato","Tipo Legame sogg. Operante","Data registrazione","Tipo operazione","Tipo Operazione Completa","Lire Euro Valuta","Divisa","Segno","Totale Operazione","di cui contanti","Stato registrazione","Operazione Modificata","Data Rettifica","Codice Cliente Occasionale","Soggetto Operante Conto Terzi","Beneficiario","Collegamento Operazione Multiple","Cambio","Rapporto Beneficiario","Tipo Rapporto Beneficiario","Operatore","Importazione da file esterno","ID BASE Causale Analitica","","","","","Data Operazione in Carattere","","","","","Ragionevolezza","Modalità Svolgimento","Area Geografica","","","","","","","","","","","Progressivo Import","Codice univoco per importazioni di n sogetti operanti","","","","Connessione Tabella Storico Documenti","","","","","","","","","","","Riferimento operazione WU","Identificativo File","Data Registrazione in carattere","IP Collegamento","Inizio Collegamento","Durata Collegamento","Anno Operazione (MT/IDP)","Gestione IDEREG","Importo IN","Importo OUT","Mitigazione","Path Documentazione Mitigazione","Rischio Globale","Modalità bonifico in uscita","Pro Quota","","","","","Modalità di avvio bonifico (SV)","Escludi operazione da SARA","Mezzo pagamento","Prestazione","Causale","Mark Importazione","Descrizione Punto Contante","Codice Cliente Contante","Tipo attività","Progressivo da Import","Note","Codice VASP"};
    return l_names;
  }
}
