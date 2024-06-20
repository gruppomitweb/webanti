public class MemoryCursorRow_tmp_stpoperazioni extends CPMemoryCursorRow {
  public MemoryCursorRow_tmp_stpoperazioni() {
  }
  public MemoryCursorRow_tmp_stpoperazioni(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tmp_stpoperazioni toBuild = new MemoryCursor_tmp_stpoperazioni(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tmp_stpoperazioni toBuild = new MemoryCursor_tmp_stpoperazioni();
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
  String CONNESDOC = "";
  String CONNESCOL = "";
  String RAGCLI = "";
  String RAGOPE = "";
  String RAGBEN = "";
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
  String DIPCAB = "";
  String DIPCIT = "";
  String DIPPRV = "";
  String TXTNOTE = "";
  String ERR01 = "";
  String ERR02 = "";
  String ERR03 = "";
  String ERR04 = "";
  String ERR05 = "";
  String ERR06 = "";
  String ERR07 = "";
  String ERR08 = "";
  String ERR09 = "";
  String ERR10 = "";
  String ERR11 = "";
  String CODINTDIP = "";
  String ABICABDIP = "";
  String CODCABDIP = "";
  String PERPAESE = "";
  String PERCAB = "";
  String CODVOCAGG = "";
  String FLAGLIREAGG = "";
  String SEGNOAGG = "";
  String SETTSINTAGG = "";
  String PAESECP = "";
  String CODCABCP = "";
  String PAESEICP = "";
  String CABICP = "";
  String SUBTYP = "";
  double TOPE = 0;
  double TCON = 0;
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
    if ( ! (CPLib.Empty(CONNESDOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESCOL))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGCLI))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGBEN))) {
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
    if ( ! (CPLib.Empty(DIPCAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(DIPCIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(DIPPRV))) {
      return false;
    }
    if ( ! (CPLib.Empty(TXTNOTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERR01))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERR02))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERR03))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERR04))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERR05))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERR06))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERR07))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERR08))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERR09))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERR10))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERR11))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODINTDIP))) {
      return false;
    }
    if ( ! (CPLib.Empty(ABICABDIP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCABDIP))) {
      return false;
    }
    if ( ! (CPLib.Empty(PERPAESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(PERCAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODVOCAGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGLIREAGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(SEGNOAGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(SETTSINTAGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESECP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCABCP))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESEICP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CABICP))) {
      return false;
    }
    if ( ! (CPLib.Empty(SUBTYP))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TCON))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tmp_stpoperazioni p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tmp_stpoperazioni.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_tmp_stpoperazioni.this.NUMPROG = copyAndCast(p_row.NUMPROG);
      MemoryCursorRow_tmp_stpoperazioni.this.DATAOPE = copyAndCast(p_row.DATAOPE);
      MemoryCursorRow_tmp_stpoperazioni.this.TIPOINTER = copyAndCast(p_row.TIPOINTER);
      MemoryCursorRow_tmp_stpoperazioni.this.CODINTER = copyAndCast(p_row.CODINTER);
      MemoryCursorRow_tmp_stpoperazioni.this.TIPOINF = copyAndCast(p_row.TIPOINF);
      MemoryCursorRow_tmp_stpoperazioni.this.IDEREG = copyAndCast(p_row.IDEREG);
      MemoryCursorRow_tmp_stpoperazioni.this.CODDIPE = copyAndCast(p_row.CODDIPE);
      MemoryCursorRow_tmp_stpoperazioni.this.DESCCIT = copyAndCast(p_row.DESCCIT);
      MemoryCursorRow_tmp_stpoperazioni.this.PROVINCIA = copyAndCast(p_row.PROVINCIA);
      MemoryCursorRow_tmp_stpoperazioni.this.CODCAB = copyAndCast(p_row.CODCAB);
      MemoryCursorRow_tmp_stpoperazioni.this.FLAGFRAZ = copyAndCast(p_row.FLAGFRAZ);
      MemoryCursorRow_tmp_stpoperazioni.this.FLAGCONT = copyAndCast(p_row.FLAGCONT);
      MemoryCursorRow_tmp_stpoperazioni.this.CODANA = copyAndCast(p_row.CODANA);
      MemoryCursorRow_tmp_stpoperazioni.this.CODVOC = copyAndCast(p_row.CODVOC);
      MemoryCursorRow_tmp_stpoperazioni.this.TIPOINT2 = copyAndCast(p_row.TIPOINT2);
      MemoryCursorRow_tmp_stpoperazioni.this.CODINT2 = copyAndCast(p_row.CODINT2);
      MemoryCursorRow_tmp_stpoperazioni.this.PAESE = copyAndCast(p_row.PAESE);
      MemoryCursorRow_tmp_stpoperazioni.this.DESC2 = copyAndCast(p_row.DESC2);
      MemoryCursorRow_tmp_stpoperazioni.this.PROV2 = copyAndCast(p_row.PROV2);
      MemoryCursorRow_tmp_stpoperazioni.this.CODCAB2 = copyAndCast(p_row.CODCAB2);
      MemoryCursorRow_tmp_stpoperazioni.this.DESCINTER = copyAndCast(p_row.DESCINTER);
      MemoryCursorRow_tmp_stpoperazioni.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_tmp_stpoperazioni.this.FLAGRAP = copyAndCast(p_row.FLAGRAP);
      MemoryCursorRow_tmp_stpoperazioni.this.TIPOLEG = copyAndCast(p_row.TIPOLEG);
      MemoryCursorRow_tmp_stpoperazioni.this.DATAREG = copyAndCast(p_row.DATAREG);
      MemoryCursorRow_tmp_stpoperazioni.this.OPRAP = copyAndCast(p_row.OPRAP);
      MemoryCursorRow_tmp_stpoperazioni.this.TIPOOPRAP = copyAndCast(p_row.TIPOOPRAP);
      MemoryCursorRow_tmp_stpoperazioni.this.FLAGLIRE = copyAndCast(p_row.FLAGLIRE);
      MemoryCursorRow_tmp_stpoperazioni.this.VALUTA = copyAndCast(p_row.VALUTA);
      MemoryCursorRow_tmp_stpoperazioni.this.SEGNO = copyAndCast(p_row.SEGNO);
      MemoryCursorRow_tmp_stpoperazioni.this.TOTLIRE = copyAndCast(p_row.TOTLIRE);
      MemoryCursorRow_tmp_stpoperazioni.this.TOTCONT = copyAndCast(p_row.TOTCONT);
      MemoryCursorRow_tmp_stpoperazioni.this.STATOREG = copyAndCast(p_row.STATOREG);
      MemoryCursorRow_tmp_stpoperazioni.this.OPERAZMOD = copyAndCast(p_row.OPERAZMOD);
      MemoryCursorRow_tmp_stpoperazioni.this.DATARETT = copyAndCast(p_row.DATARETT);
      MemoryCursorRow_tmp_stpoperazioni.this.CONNESCLI = copyAndCast(p_row.CONNESCLI);
      MemoryCursorRow_tmp_stpoperazioni.this.CONNESOPER = copyAndCast(p_row.CONNESOPER);
      MemoryCursorRow_tmp_stpoperazioni.this.CONNESBEN = copyAndCast(p_row.CONNESBEN);
      MemoryCursorRow_tmp_stpoperazioni.this.COLLEG = copyAndCast(p_row.COLLEG);
      MemoryCursorRow_tmp_stpoperazioni.this.CAMBIO = copyAndCast(p_row.CAMBIO);
      MemoryCursorRow_tmp_stpoperazioni.this.RAPPORTBEN = copyAndCast(p_row.RAPPORTBEN);
      MemoryCursorRow_tmp_stpoperazioni.this.FLAGRAP2 = copyAndCast(p_row.FLAGRAP2);
      MemoryCursorRow_tmp_stpoperazioni.this.OPERATORE = copyAndCast(p_row.OPERATORE);
      MemoryCursorRow_tmp_stpoperazioni.this.AUTOM = copyAndCast(p_row.AUTOM);
      MemoryCursorRow_tmp_stpoperazioni.this.idcauana = copyAndCast(p_row.idcauana);
      MemoryCursorRow_tmp_stpoperazioni.this.OPERAG = copyAndCast(p_row.OPERAG);
      MemoryCursorRow_tmp_stpoperazioni.this.DOCFILE = copyAndCast(p_row.DOCFILE);
      MemoryCursorRow_tmp_stpoperazioni.this.RESPINS = copyAndCast(p_row.RESPINS);
      MemoryCursorRow_tmp_stpoperazioni.this.INFORM = copyAndCast(p_row.INFORM);
      MemoryCursorRow_tmp_stpoperazioni.this.CDATOPE = copyAndCast(p_row.CDATOPE);
      MemoryCursorRow_tmp_stpoperazioni.this.NOPROT = copyAndCast(p_row.NOPROT);
      MemoryCursorRow_tmp_stpoperazioni.this.UCODE = copyAndCast(p_row.UCODE);
      MemoryCursorRow_tmp_stpoperazioni.this.CDATAOPE = copyAndCast(p_row.CDATAOPE);
      MemoryCursorRow_tmp_stpoperazioni.this.ZCPARTE = copyAndCast(p_row.ZCPARTE);
      MemoryCursorRow_tmp_stpoperazioni.this.RAGIO = copyAndCast(p_row.RAGIO);
      MemoryCursorRow_tmp_stpoperazioni.this.MODSVOL = copyAndCast(p_row.MODSVOL);
      MemoryCursorRow_tmp_stpoperazioni.this.AREAGEO = copyAndCast(p_row.AREAGEO);
      MemoryCursorRow_tmp_stpoperazioni.this.RIFIMP = copyAndCast(p_row.RIFIMP);
      MemoryCursorRow_tmp_stpoperazioni.this.SCOPO = copyAndCast(p_row.SCOPO);
      MemoryCursorRow_tmp_stpoperazioni.this.NATURA = copyAndCast(p_row.NATURA);
      MemoryCursorRow_tmp_stpoperazioni.this.RTIPO = copyAndCast(p_row.RTIPO);
      MemoryCursorRow_tmp_stpoperazioni.this.RCOMP = copyAndCast(p_row.RCOMP);
      MemoryCursorRow_tmp_stpoperazioni.this.RIMP = copyAndCast(p_row.RIMP);
      MemoryCursorRow_tmp_stpoperazioni.this.RFREQ = copyAndCast(p_row.RFREQ);
      MemoryCursorRow_tmp_stpoperazioni.this.RRAGIO = copyAndCast(p_row.RRAGIO);
      MemoryCursorRow_tmp_stpoperazioni.this.RAREA = copyAndCast(p_row.RAREA);
      MemoryCursorRow_tmp_stpoperazioni.this.TIPO = copyAndCast(p_row.TIPO);
      MemoryCursorRow_tmp_stpoperazioni.this.PRGIMPOPE = copyAndCast(p_row.PRGIMPOPE);
      MemoryCursorRow_tmp_stpoperazioni.this.UNIQUECODE = copyAndCast(p_row.UNIQUECODE);
      MemoryCursorRow_tmp_stpoperazioni.this.CONNESDOC = copyAndCast(p_row.CONNESDOC);
      MemoryCursorRow_tmp_stpoperazioni.this.CONNESCOL = copyAndCast(p_row.CONNESCOL);
      MemoryCursorRow_tmp_stpoperazioni.this.RAGCLI = copyAndCast(p_row.RAGCLI);
      MemoryCursorRow_tmp_stpoperazioni.this.RAGOPE = copyAndCast(p_row.RAGOPE);
      MemoryCursorRow_tmp_stpoperazioni.this.RAGBEN = copyAndCast(p_row.RAGBEN);
      MemoryCursorRow_tmp_stpoperazioni.this.C_RAG = copyAndCast(p_row.C_RAG);
      MemoryCursorRow_tmp_stpoperazioni.this.C_STA = copyAndCast(p_row.C_STA);
      MemoryCursorRow_tmp_stpoperazioni.this.C_CTA = copyAndCast(p_row.C_CTA);
      MemoryCursorRow_tmp_stpoperazioni.this.C_CAB = copyAndCast(p_row.C_CAB);
      MemoryCursorRow_tmp_stpoperazioni.this.C_PRV = copyAndCast(p_row.C_PRV);
      MemoryCursorRow_tmp_stpoperazioni.this.C_IND = copyAndCast(p_row.C_IND);
      MemoryCursorRow_tmp_stpoperazioni.this.C_CAP = copyAndCast(p_row.C_CAP);
      MemoryCursorRow_tmp_stpoperazioni.this.DATAIMP = copyAndCast(p_row.DATAIMP);
      MemoryCursorRow_tmp_stpoperazioni.this.C_RAPPORTO = copyAndCast(p_row.C_RAPPORTO);
      MemoryCursorRow_tmp_stpoperazioni.this.PAGASOGOP = copyAndCast(p_row.PAGASOGOP);
      MemoryCursorRow_tmp_stpoperazioni.this.MTCN = copyAndCast(p_row.MTCN);
      MemoryCursorRow_tmp_stpoperazioni.this.IDFILE = copyAndCast(p_row.IDFILE);
      MemoryCursorRow_tmp_stpoperazioni.this.CDATREG = copyAndCast(p_row.CDATREG);
      MemoryCursorRow_tmp_stpoperazioni.this.IPCOLLEG = copyAndCast(p_row.IPCOLLEG);
      MemoryCursorRow_tmp_stpoperazioni.this.ORACOLLEG = copyAndCast(p_row.ORACOLLEG);
      MemoryCursorRow_tmp_stpoperazioni.this.DUCOLLEG = copyAndCast(p_row.DUCOLLEG);
      MemoryCursorRow_tmp_stpoperazioni.this.DIPCAB = copyAndCast(p_row.DIPCAB);
      MemoryCursorRow_tmp_stpoperazioni.this.DIPCIT = copyAndCast(p_row.DIPCIT);
      MemoryCursorRow_tmp_stpoperazioni.this.DIPPRV = copyAndCast(p_row.DIPPRV);
      MemoryCursorRow_tmp_stpoperazioni.this.TXTNOTE = copyAndCast(p_row.TXTNOTE);
      MemoryCursorRow_tmp_stpoperazioni.this.ERR01 = copyAndCast(p_row.ERR01);
      MemoryCursorRow_tmp_stpoperazioni.this.ERR02 = copyAndCast(p_row.ERR02);
      MemoryCursorRow_tmp_stpoperazioni.this.ERR03 = copyAndCast(p_row.ERR03);
      MemoryCursorRow_tmp_stpoperazioni.this.ERR04 = copyAndCast(p_row.ERR04);
      MemoryCursorRow_tmp_stpoperazioni.this.ERR05 = copyAndCast(p_row.ERR05);
      MemoryCursorRow_tmp_stpoperazioni.this.ERR06 = copyAndCast(p_row.ERR06);
      MemoryCursorRow_tmp_stpoperazioni.this.ERR07 = copyAndCast(p_row.ERR07);
      MemoryCursorRow_tmp_stpoperazioni.this.ERR08 = copyAndCast(p_row.ERR08);
      MemoryCursorRow_tmp_stpoperazioni.this.ERR09 = copyAndCast(p_row.ERR09);
      MemoryCursorRow_tmp_stpoperazioni.this.ERR10 = copyAndCast(p_row.ERR10);
      MemoryCursorRow_tmp_stpoperazioni.this.ERR11 = copyAndCast(p_row.ERR11);
      MemoryCursorRow_tmp_stpoperazioni.this.CODINTDIP = copyAndCast(p_row.CODINTDIP);
      MemoryCursorRow_tmp_stpoperazioni.this.ABICABDIP = copyAndCast(p_row.ABICABDIP);
      MemoryCursorRow_tmp_stpoperazioni.this.CODCABDIP = copyAndCast(p_row.CODCABDIP);
      MemoryCursorRow_tmp_stpoperazioni.this.PERPAESE = copyAndCast(p_row.PERPAESE);
      MemoryCursorRow_tmp_stpoperazioni.this.PERCAB = copyAndCast(p_row.PERCAB);
      MemoryCursorRow_tmp_stpoperazioni.this.CODVOCAGG = copyAndCast(p_row.CODVOCAGG);
      MemoryCursorRow_tmp_stpoperazioni.this.FLAGLIREAGG = copyAndCast(p_row.FLAGLIREAGG);
      MemoryCursorRow_tmp_stpoperazioni.this.SEGNOAGG = copyAndCast(p_row.SEGNOAGG);
      MemoryCursorRow_tmp_stpoperazioni.this.SETTSINTAGG = copyAndCast(p_row.SETTSINTAGG);
      MemoryCursorRow_tmp_stpoperazioni.this.PAESECP = copyAndCast(p_row.PAESECP);
      MemoryCursorRow_tmp_stpoperazioni.this.CODCABCP = copyAndCast(p_row.CODCABCP);
      MemoryCursorRow_tmp_stpoperazioni.this.PAESEICP = copyAndCast(p_row.PAESEICP);
      MemoryCursorRow_tmp_stpoperazioni.this.CABICP = copyAndCast(p_row.CABICP);
      MemoryCursorRow_tmp_stpoperazioni.this.SUBTYP = copyAndCast(p_row.SUBTYP);
      MemoryCursorRow_tmp_stpoperazioni.this.TOPE = copyAndCast(p_row.TOPE);
      MemoryCursorRow_tmp_stpoperazioni.this.TCON = copyAndCast(p_row.TCON);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"IDBASE","NUMPROG","DATAOPE","TIPOINTER","CODINTER","TIPOINF","IDEREG","CODDIPE","DESCCIT","PROVINCIA","CODCAB","FLAGFRAZ","FLAGCONT","CODANA","CODVOC","TIPOINT2","CODINT2","PAESE","DESC2","PROV2","CODCAB2","DESCINTER","RAPPORTO","FLAGRAP","TIPOLEG","DATAREG","OPRAP","TIPOOPRAP","FLAGLIRE","VALUTA","SEGNO","TOTLIRE","TOTCONT","STATOREG","OPERAZMOD","DATARETT","CONNESCLI","CONNESOPER","CONNESBEN","COLLEG","CAMBIO","RAPPORTBEN","FLAGRAP2","OPERATORE","AUTOM","idcauana","OPERAG","DOCFILE","RESPINS","INFORM","CDATOPE","NOPROT","UCODE","CDATAOPE","ZCPARTE","RAGIO","MODSVOL","AREAGEO","RIFIMP","SCOPO","NATURA","RTIPO","RCOMP","RIMP","RFREQ","RRAGIO","RAREA","TIPO","PRGIMPOPE","UNIQUECODE","CONNESDOC","CONNESCOL","RAGCLI","RAGOPE","RAGBEN","C_RAG","C_STA","C_CTA","C_CAB","C_PRV","C_IND","C_CAP","DATAIMP","C_RAPPORTO","PAGASOGOP","MTCN","IDFILE","CDATREG","IPCOLLEG","ORACOLLEG","DUCOLLEG","DIPCAB","DIPCIT","DIPPRV","TXTNOTE","ERR01","ERR02","ERR03","ERR04","ERR05","ERR06","ERR07","ERR08","ERR09","ERR10","ERR11","CODINTDIP","ABICABDIP","CODCABDIP","PERPAESE","PERCAB","CODVOCAGG","FLAGLIREAGG","SEGNOAGG","SETTSINTAGG","PAESECP","CODCABCP","PAESEICP","CABICP","SUBTYP","TOPE","TCON"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","D","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","D","C","C","C","C","C","N","N","C","C","D","C","C","C","C","N","C","C","C","C","C","C","C","C","C","C","N","C","C","C","C","C","C","C","C","C","N","N","N","N","N","N","C","N","C","C","C","C","C","C","C","C","C","C","C","C","C","D","C","C","C","C","C","C","T","N","C","C","C","M","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","N","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Idbase","Numero Progressivo","Data Operazione","Tipo Intermediaro","Codice Intermediario","Tipo Informazione","ID Registrazione","Codice Dipendenza","Città Dipendenza","Provincia Dipendenza","CAB Dipendenza","Frazionata (S/N)","Contanti (S/N)","Causale Analitica","Causale Sintetica","Tipo Intermediario C/Parte","Codice Intermediario C/Parte","Stato Intermediario C/Parte","Denominazione Intermediario C/Parte","Provincia Intermediario C/Parte","CAB Intermediario C/Parte","","Rapporto Collegato","Tipo Rapporto Collegato","Tipo Legame sogg. Operante","Data registrazione","Tipo operazione","Tipo Operazione Completa","Lire Euro Valuta","Divisa","Segno","Totale Operazione","di cui contanti","Stato registrazione","Operazione Modificata","Data Rettifica","Codice Cliente Occasionale","Soggetto Operante Conto Terzi","Beneficiario","Collegamento Operazione Multiple","Cambio","Rapporto Beneficiario","Tipo Rapporto Beneficiario","Operatore","Importazione da file esterno","ID BASE Causale Analitica","","","","","Data Operazione in Carattere","","","","","Ragionevolezza","Modalità Svolgimento","Area Geografica","","","","","","","","","","","Progressivo Import","Codice univoco per importazioni di n sogetti operanti","Connessione Tabella Documenti","Intestatari","Ragione Sociale Cliente Occasionale","Ragiore Sociale Operatore Conto Terzi","Ragioen Sociale Controparte","","","","","","","","","","","Riferimento operazione WU","Identificativo File","Data Registrazione in carattere","IP Collegamento","Inizio Collegamento","Durata Collegamento","CAB dipendenza","Città dipendenza","provincia dipendenza","Note Varie","","","","","","","","","","","","Codice Dipendenza","ABI CAB della DIPENDENZA","CAB DIPENDENZA","Paese Residenza Cliente","CAB Comune Residenza Cliente","Causale Aggregata","Valuta","Segno (Dare - Avere)","Settorizzazione Sintetica","PAESE Controparte","CAB Comune Controparte","Paese Intermediario Controparte","CAB Comune Intermediario Controparte","","Numero Operazioni","Operazioni in contanti"};
    return l_names;
  }
}
