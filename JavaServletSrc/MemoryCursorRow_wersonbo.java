public class MemoryCursorRow_wersonbo extends CPMemoryCursorRow {
  public MemoryCursorRow_wersonbo() {
  }
  public MemoryCursorRow_wersonbo(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_wersonbo toBuild = new MemoryCursor_wersonbo(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_wersonbo toBuild = new MemoryCursor_wersonbo();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String sanumpro = "";
  String CONNES = "";
  String CODCAB = "";
  String RAGSOC = "";
  String DOMICILIO = "";
  String CODFISC = "";
  java.sql.Date DATANASC = CPLib.NullDate();
  String NASCOMUN = "";
  String SOTGRUP = "";
  String RAMOGRUP = "";
  String SETTSINT = "";
  String TIPODOC = "";
  String NUMDOCUM = "";
  java.sql.Date DATARILASC = CPLib.NullDate();
  String AUTRILASC = "";
  String DESCCIT = "";
  String PROVINCIA = "";
  String PAESE = "";
  String CAP = "";
  String CODINTER = "";
  String TIPINTER = "";
  String TIPOPERS = "";
  String CODDIPE = "";
  String PARTIVA = "";
  String NOTE = "";
  String SESSO = "";
  String SOSPMAF = "";
  String idcitta = "";
  java.sql.Date DATAVALI = CPLib.NullDate();
  String NASSTATO = "";
  String DOCFILE = "";
  String NOME = "";
  String COGNOME = "";
  double CFESTERO = 0;
  String OLDCONNES = "";
  java.sql.Date DATEXTRA = CPLib.NullDate();
  String PKTBSPECIE = "";
  String COMPORT = "";
  String ATTIV = "";
  double RNATGIU = 0;
  double RATTIV = 0;
  double RCOMP = 0;
  double RAREA = 0;
  double ALLINEATO = 0;
  double ALLINEATONOMECNOME = 0;
  String RAGSOCOLD = "";
  double PROGIMPORT = 0;
  String PROGIMP_C = "";
  String AREAGEO = "";
  java.sql.Date datamodi = CPLib.NullDate();
  String PEP = "";
  String IDFILE = "";
  String OLDCODFISC = "";
  String MACROAGENTE = "";
  String SPOTID = "";
  java.sql.Date DATASEGN = CPLib.NullDate();
  String OLDSETSIN = "";
  java.sql.Date DATAVARAGE = CPLib.NullDate();
  String SETTSINT2 = "";
  String FATCA = "";
  String BANCABEN = "";
  String TIN = "";
  double ODB = 0;
  String TELEF = "";
  String TIPOORO = "";
  String CODORO = "";
  String IDNASCOMUN = "";
  String IDNASSTATO = "";
  double NOTIT = 0;
  String IDBASE = "";
  String FLGVALIDO = "";
  String CITTADIN1 = "";
  String CITTADIN2 = "";
  String RESFISC = "";
  double MITIG = 0;
  String MITGDOC = "";
  String NOSARA = "";
  String RISGLOB = "";
  java.sql.Date DATAPROF = CPLib.NullDate();
  java.sql.Date DATAREVPROF = CPLib.NullDate();
  String IDENT = "";
  java.sql.Date PEPDATE = CPLib.NullDate();
  String DAC6 = "";
  double FLAGDAC6 = 0;
  String CRIME = "";
  java.sql.Date CRIMEDATE = CPLib.NullDate();
  String ALTRODOM = "";
  String ALTROCAP = "";
  String CONTO = "";
  java.sql.Timestamp NUMIMP = CPLib.NullDateTime();
  String RAPSEGNA = "";
  String CODLEGRAP = "";
  String TIPOSOGGETTO = "";
  double CAUSALE = 0;
  double IMPORTOMAX = 0;
  double FATTURATO = 0;
  String FREQUENZA = "";
  double NUMOPERAZ = 0;
  String SOGAFFIDATARIO = "";
  String FLGNOTRIM = "";
  java.sql.Date DISATTIVO = CPLib.NullDate();
  java.sql.Date DATAFINE = CPLib.NullDate();
  java.sql.Date DATAINI = CPLib.NullDate();
  java.sql.Date DATAIDENT = CPLib.NullDate();
  java.sql.Date DATASIGN = CPLib.NullDate();
  java.sql.Date DATARAUT = CPLib.NullDate();
  String VERIFICA = "";
  String NOTERIS = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(sanumpro))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNES))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGSOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(DOMICILIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODFISC))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATANASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(NASCOMUN))) {
      return false;
    }
    if ( ! (CPLib.Empty(SOTGRUP))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAMOGRUP))) {
      return false;
    }
    if ( ! (CPLib.Empty(SETTSINT))) {
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
    if ( ! (CPLib.Empty(DESCCIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVINCIA))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOPERS))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODDIPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(PARTIVA))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(SESSO))) {
      return false;
    }
    if ( ! (CPLib.Empty(SOSPMAF))) {
      return false;
    }
    if ( ! (CPLib.Empty(idcitta))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAVALI))) {
      return false;
    }
    if ( ! (CPLib.Empty(NASSTATO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DOCFILE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(COGNOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(CFESTERO))) {
      return false;
    }
    if ( ! (CPLib.Empty(OLDCONNES))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATEXTRA))) {
      return false;
    }
    if ( ! (CPLib.Empty(PKTBSPECIE))) {
      return false;
    }
    if ( ! (CPLib.Empty(COMPORT))) {
      return false;
    }
    if ( ! (CPLib.Empty(ATTIV))) {
      return false;
    }
    if ( ! (CPLib.Empty(RNATGIU))) {
      return false;
    }
    if ( ! (CPLib.Empty(RATTIV))) {
      return false;
    }
    if ( ! (CPLib.Empty(RCOMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAREA))) {
      return false;
    }
    if ( ! (CPLib.Empty(ALLINEATO))) {
      return false;
    }
    if ( ! (CPLib.Empty(ALLINEATONOMECNOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGSOCOLD))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROGIMPORT))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROGIMP_C))) {
      return false;
    }
    if ( ! (CPLib.Empty(AREAGEO))) {
      return false;
    }
    if ( ! (CPLib.Empty(datamodi))) {
      return false;
    }
    if ( ! (CPLib.Empty(PEP))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDFILE))) {
      return false;
    }
    if ( ! (CPLib.Empty(OLDCODFISC))) {
      return false;
    }
    if ( ! (CPLib.Empty(MACROAGENTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(SPOTID))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATASEGN))) {
      return false;
    }
    if ( ! (CPLib.Empty(OLDSETSIN))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAVARAGE))) {
      return false;
    }
    if ( ! (CPLib.Empty(SETTSINT2))) {
      return false;
    }
    if ( ! (CPLib.Empty(FATCA))) {
      return false;
    }
    if ( ! (CPLib.Empty(BANCABEN))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIN))) {
      return false;
    }
    if ( ! (CPLib.Empty(ODB))) {
      return false;
    }
    if ( ! (CPLib.Empty(TELEF))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOORO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODORO))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDNASCOMUN))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDNASSTATO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOTIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGVALIDO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CITTADIN1))) {
      return false;
    }
    if ( ! (CPLib.Empty(CITTADIN2))) {
      return false;
    }
    if ( ! (CPLib.Empty(RESFISC))) {
      return false;
    }
    if ( ! (CPLib.Empty(MITIG))) {
      return false;
    }
    if ( ! (CPLib.Empty(MITGDOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOSARA))) {
      return false;
    }
    if ( ! (CPLib.Empty(RISGLOB))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAPROF))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAREVPROF))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDENT))) {
      return false;
    }
    if ( ! (CPLib.Empty(PEPDATE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DAC6))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGDAC6))) {
      return false;
    }
    if ( ! (CPLib.Empty(CRIME))) {
      return false;
    }
    if ( ! (CPLib.Empty(CRIMEDATE))) {
      return false;
    }
    if ( ! (CPLib.Empty(ALTRODOM))) {
      return false;
    }
    if ( ! (CPLib.Empty(ALTROCAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMIMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPSEGNA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODLEGRAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOSOGGETTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAUSALE))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPORTOMAX))) {
      return false;
    }
    if ( ! (CPLib.Empty(FATTURATO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FREQUENZA))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMOPERAZ))) {
      return false;
    }
    if ( ! (CPLib.Empty(SOGAFFIDATARIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGNOTRIM))) {
      return false;
    }
    if ( ! (CPLib.Empty(DISATTIVO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAFINE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAINI))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAIDENT))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATASIGN))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATARAUT))) {
      return false;
    }
    if ( ! (CPLib.Empty(VERIFICA))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOTERIS))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_wersonbo p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_wersonbo.this.sanumpro = copyAndCast(p_row.sanumpro);
      MemoryCursorRow_wersonbo.this.CONNES = copyAndCast(p_row.CONNES);
      MemoryCursorRow_wersonbo.this.CODCAB = copyAndCast(p_row.CODCAB);
      MemoryCursorRow_wersonbo.this.RAGSOC = copyAndCast(p_row.RAGSOC);
      MemoryCursorRow_wersonbo.this.DOMICILIO = copyAndCast(p_row.DOMICILIO);
      MemoryCursorRow_wersonbo.this.CODFISC = copyAndCast(p_row.CODFISC);
      MemoryCursorRow_wersonbo.this.DATANASC = copyAndCast(p_row.DATANASC);
      MemoryCursorRow_wersonbo.this.NASCOMUN = copyAndCast(p_row.NASCOMUN);
      MemoryCursorRow_wersonbo.this.SOTGRUP = copyAndCast(p_row.SOTGRUP);
      MemoryCursorRow_wersonbo.this.RAMOGRUP = copyAndCast(p_row.RAMOGRUP);
      MemoryCursorRow_wersonbo.this.SETTSINT = copyAndCast(p_row.SETTSINT);
      MemoryCursorRow_wersonbo.this.TIPODOC = copyAndCast(p_row.TIPODOC);
      MemoryCursorRow_wersonbo.this.NUMDOCUM = copyAndCast(p_row.NUMDOCUM);
      MemoryCursorRow_wersonbo.this.DATARILASC = copyAndCast(p_row.DATARILASC);
      MemoryCursorRow_wersonbo.this.AUTRILASC = copyAndCast(p_row.AUTRILASC);
      MemoryCursorRow_wersonbo.this.DESCCIT = copyAndCast(p_row.DESCCIT);
      MemoryCursorRow_wersonbo.this.PROVINCIA = copyAndCast(p_row.PROVINCIA);
      MemoryCursorRow_wersonbo.this.PAESE = copyAndCast(p_row.PAESE);
      MemoryCursorRow_wersonbo.this.CAP = copyAndCast(p_row.CAP);
      MemoryCursorRow_wersonbo.this.CODINTER = copyAndCast(p_row.CODINTER);
      MemoryCursorRow_wersonbo.this.TIPINTER = copyAndCast(p_row.TIPINTER);
      MemoryCursorRow_wersonbo.this.TIPOPERS = copyAndCast(p_row.TIPOPERS);
      MemoryCursorRow_wersonbo.this.CODDIPE = copyAndCast(p_row.CODDIPE);
      MemoryCursorRow_wersonbo.this.PARTIVA = copyAndCast(p_row.PARTIVA);
      MemoryCursorRow_wersonbo.this.NOTE = copyAndCast(p_row.NOTE);
      MemoryCursorRow_wersonbo.this.SESSO = copyAndCast(p_row.SESSO);
      MemoryCursorRow_wersonbo.this.SOSPMAF = copyAndCast(p_row.SOSPMAF);
      MemoryCursorRow_wersonbo.this.idcitta = copyAndCast(p_row.idcitta);
      MemoryCursorRow_wersonbo.this.DATAVALI = copyAndCast(p_row.DATAVALI);
      MemoryCursorRow_wersonbo.this.NASSTATO = copyAndCast(p_row.NASSTATO);
      MemoryCursorRow_wersonbo.this.DOCFILE = copyAndCast(p_row.DOCFILE);
      MemoryCursorRow_wersonbo.this.NOME = copyAndCast(p_row.NOME);
      MemoryCursorRow_wersonbo.this.COGNOME = copyAndCast(p_row.COGNOME);
      MemoryCursorRow_wersonbo.this.CFESTERO = copyAndCast(p_row.CFESTERO);
      MemoryCursorRow_wersonbo.this.OLDCONNES = copyAndCast(p_row.OLDCONNES);
      MemoryCursorRow_wersonbo.this.DATEXTRA = copyAndCast(p_row.DATEXTRA);
      MemoryCursorRow_wersonbo.this.PKTBSPECIE = copyAndCast(p_row.PKTBSPECIE);
      MemoryCursorRow_wersonbo.this.COMPORT = copyAndCast(p_row.COMPORT);
      MemoryCursorRow_wersonbo.this.ATTIV = copyAndCast(p_row.ATTIV);
      MemoryCursorRow_wersonbo.this.RNATGIU = copyAndCast(p_row.RNATGIU);
      MemoryCursorRow_wersonbo.this.RATTIV = copyAndCast(p_row.RATTIV);
      MemoryCursorRow_wersonbo.this.RCOMP = copyAndCast(p_row.RCOMP);
      MemoryCursorRow_wersonbo.this.RAREA = copyAndCast(p_row.RAREA);
      MemoryCursorRow_wersonbo.this.ALLINEATO = copyAndCast(p_row.ALLINEATO);
      MemoryCursorRow_wersonbo.this.ALLINEATONOMECNOME = copyAndCast(p_row.ALLINEATONOMECNOME);
      MemoryCursorRow_wersonbo.this.RAGSOCOLD = copyAndCast(p_row.RAGSOCOLD);
      MemoryCursorRow_wersonbo.this.PROGIMPORT = copyAndCast(p_row.PROGIMPORT);
      MemoryCursorRow_wersonbo.this.PROGIMP_C = copyAndCast(p_row.PROGIMP_C);
      MemoryCursorRow_wersonbo.this.AREAGEO = copyAndCast(p_row.AREAGEO);
      MemoryCursorRow_wersonbo.this.datamodi = copyAndCast(p_row.datamodi);
      MemoryCursorRow_wersonbo.this.PEP = copyAndCast(p_row.PEP);
      MemoryCursorRow_wersonbo.this.IDFILE = copyAndCast(p_row.IDFILE);
      MemoryCursorRow_wersonbo.this.OLDCODFISC = copyAndCast(p_row.OLDCODFISC);
      MemoryCursorRow_wersonbo.this.MACROAGENTE = copyAndCast(p_row.MACROAGENTE);
      MemoryCursorRow_wersonbo.this.SPOTID = copyAndCast(p_row.SPOTID);
      MemoryCursorRow_wersonbo.this.DATASEGN = copyAndCast(p_row.DATASEGN);
      MemoryCursorRow_wersonbo.this.OLDSETSIN = copyAndCast(p_row.OLDSETSIN);
      MemoryCursorRow_wersonbo.this.DATAVARAGE = copyAndCast(p_row.DATAVARAGE);
      MemoryCursorRow_wersonbo.this.SETTSINT2 = copyAndCast(p_row.SETTSINT2);
      MemoryCursorRow_wersonbo.this.FATCA = copyAndCast(p_row.FATCA);
      MemoryCursorRow_wersonbo.this.BANCABEN = copyAndCast(p_row.BANCABEN);
      MemoryCursorRow_wersonbo.this.TIN = copyAndCast(p_row.TIN);
      MemoryCursorRow_wersonbo.this.ODB = copyAndCast(p_row.ODB);
      MemoryCursorRow_wersonbo.this.TELEF = copyAndCast(p_row.TELEF);
      MemoryCursorRow_wersonbo.this.TIPOORO = copyAndCast(p_row.TIPOORO);
      MemoryCursorRow_wersonbo.this.CODORO = copyAndCast(p_row.CODORO);
      MemoryCursorRow_wersonbo.this.IDNASCOMUN = copyAndCast(p_row.IDNASCOMUN);
      MemoryCursorRow_wersonbo.this.IDNASSTATO = copyAndCast(p_row.IDNASSTATO);
      MemoryCursorRow_wersonbo.this.NOTIT = copyAndCast(p_row.NOTIT);
      MemoryCursorRow_wersonbo.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_wersonbo.this.FLGVALIDO = copyAndCast(p_row.FLGVALIDO);
      MemoryCursorRow_wersonbo.this.CITTADIN1 = copyAndCast(p_row.CITTADIN1);
      MemoryCursorRow_wersonbo.this.CITTADIN2 = copyAndCast(p_row.CITTADIN2);
      MemoryCursorRow_wersonbo.this.RESFISC = copyAndCast(p_row.RESFISC);
      MemoryCursorRow_wersonbo.this.MITIG = copyAndCast(p_row.MITIG);
      MemoryCursorRow_wersonbo.this.MITGDOC = copyAndCast(p_row.MITGDOC);
      MemoryCursorRow_wersonbo.this.NOSARA = copyAndCast(p_row.NOSARA);
      MemoryCursorRow_wersonbo.this.RISGLOB = copyAndCast(p_row.RISGLOB);
      MemoryCursorRow_wersonbo.this.DATAPROF = copyAndCast(p_row.DATAPROF);
      MemoryCursorRow_wersonbo.this.DATAREVPROF = copyAndCast(p_row.DATAREVPROF);
      MemoryCursorRow_wersonbo.this.IDENT = copyAndCast(p_row.IDENT);
      MemoryCursorRow_wersonbo.this.PEPDATE = copyAndCast(p_row.PEPDATE);
      MemoryCursorRow_wersonbo.this.DAC6 = copyAndCast(p_row.DAC6);
      MemoryCursorRow_wersonbo.this.FLAGDAC6 = copyAndCast(p_row.FLAGDAC6);
      MemoryCursorRow_wersonbo.this.CRIME = copyAndCast(p_row.CRIME);
      MemoryCursorRow_wersonbo.this.CRIMEDATE = copyAndCast(p_row.CRIMEDATE);
      MemoryCursorRow_wersonbo.this.ALTRODOM = copyAndCast(p_row.ALTRODOM);
      MemoryCursorRow_wersonbo.this.ALTROCAP = copyAndCast(p_row.ALTROCAP);
      MemoryCursorRow_wersonbo.this.CONTO = copyAndCast(p_row.CONTO);
      MemoryCursorRow_wersonbo.this.NUMIMP = copyAndCast(p_row.NUMIMP);
      MemoryCursorRow_wersonbo.this.RAPSEGNA = copyAndCast(p_row.RAPSEGNA);
      MemoryCursorRow_wersonbo.this.CODLEGRAP = copyAndCast(p_row.CODLEGRAP);
      MemoryCursorRow_wersonbo.this.TIPOSOGGETTO = copyAndCast(p_row.TIPOSOGGETTO);
      MemoryCursorRow_wersonbo.this.CAUSALE = copyAndCast(p_row.CAUSALE);
      MemoryCursorRow_wersonbo.this.IMPORTOMAX = copyAndCast(p_row.IMPORTOMAX);
      MemoryCursorRow_wersonbo.this.FATTURATO = copyAndCast(p_row.FATTURATO);
      MemoryCursorRow_wersonbo.this.FREQUENZA = copyAndCast(p_row.FREQUENZA);
      MemoryCursorRow_wersonbo.this.NUMOPERAZ = copyAndCast(p_row.NUMOPERAZ);
      MemoryCursorRow_wersonbo.this.SOGAFFIDATARIO = copyAndCast(p_row.SOGAFFIDATARIO);
      MemoryCursorRow_wersonbo.this.FLGNOTRIM = copyAndCast(p_row.FLGNOTRIM);
      MemoryCursorRow_wersonbo.this.DISATTIVO = copyAndCast(p_row.DISATTIVO);
      MemoryCursorRow_wersonbo.this.DATAFINE = copyAndCast(p_row.DATAFINE);
      MemoryCursorRow_wersonbo.this.DATAINI = copyAndCast(p_row.DATAINI);
      MemoryCursorRow_wersonbo.this.DATAIDENT = copyAndCast(p_row.DATAIDENT);
      MemoryCursorRow_wersonbo.this.DATASIGN = copyAndCast(p_row.DATASIGN);
      MemoryCursorRow_wersonbo.this.DATARAUT = copyAndCast(p_row.DATARAUT);
      MemoryCursorRow_wersonbo.this.VERIFICA = copyAndCast(p_row.VERIFICA);
      MemoryCursorRow_wersonbo.this.NOTERIS = copyAndCast(p_row.NOTERIS);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"sanumpro","CONNES","CODCAB","RAGSOC","DOMICILIO","CODFISC","DATANASC","NASCOMUN","SOTGRUP","RAMOGRUP","SETTSINT","TIPODOC","NUMDOCUM","DATARILASC","AUTRILASC","DESCCIT","PROVINCIA","PAESE","CAP","CODINTER","TIPINTER","TIPOPERS","CODDIPE","PARTIVA","NOTE","SESSO","SOSPMAF","idcitta","DATAVALI","NASSTATO","DOCFILE","NOME","COGNOME","CFESTERO","OLDCONNES","DATEXTRA","PKTBSPECIE","COMPORT","ATTIV","RNATGIU","RATTIV","RCOMP","RAREA","ALLINEATO","ALLINEATONOMECNOME","RAGSOCOLD","PROGIMPORT","PROGIMP_C","AREAGEO","datamodi","PEP","IDFILE","OLDCODFISC","MACROAGENTE","SPOTID","DATASEGN","OLDSETSIN","DATAVARAGE","SETTSINT2","FATCA","BANCABEN","TIN","ODB","TELEF","TIPOORO","CODORO","IDNASCOMUN","IDNASSTATO","NOTIT","IDBASE","FLGVALIDO","CITTADIN1","CITTADIN2","RESFISC","MITIG","MITGDOC","NOSARA","RISGLOB","DATAPROF","DATAREVPROF","IDENT","PEPDATE","DAC6","FLAGDAC6","CRIME","CRIMEDATE","ALTRODOM","ALTROCAP","CONTO","NUMIMP","RAPSEGNA","CODLEGRAP","TIPOSOGGETTO","CAUSALE","IMPORTOMAX","FATTURATO","FREQUENZA","NUMOPERAZ","SOGAFFIDATARIO","FLGNOTRIM","DISATTIVO","DATAFINE","DATAINI","DATAIDENT","DATASIGN","DATARAUT","VERIFICA","NOTERIS"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","D","C","C","C","C","C","C","D","C","C","C","C","C","C","C","C","C","C","M","C","C","C","D","C","C","C","C","N","C","D","C","C","C","N","N","N","N","N","N","C","N","C","C","D","C","C","C","C","C","D","C","D","C","C","C","C","N","C","C","C","C","C","N","C","C","C","C","C","N","C","C","C","D","D","C","D","C","N","C","D","C","C","C","T","C","C","C","N","N","N","C","N","C","C","D","D","D","D","D","D","C","M"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"N° Progressivo","Codice Collegamento","CAB","Ragione Sociale","Indirizzo","Codice Fiscale","Data Nascita","Luogo di Nascita","Sottogruppo Att. Ec.","Ramo Gruppo Att. Ec.","Settorizzazione UIC","Tipo Documento","Numero Doc.","Data Rilascio Doc.","Autorità di rilascio","Città","Provincia","Stato","CAP","","","","","Partita IVA","Note","Sesso","","Codice Città","","Stato di nascita","","Nome","Cognome","Codice Fiscale Estero","","","","","","","","","","anagrafica allineata completa","Nome e cognome divisi correttamente","Vecchia Ragione Sociale","Progressivo d'importazione","Progressivo Import (Stringa)","Area Geografica","Data Modifica","Persona Politicamente Esposta","Identificativo File","Codice Fiscale Presente nel file","Codice MacroAgente","SPOT ID (WUB)","Data Segnalazione","Settore Sintetico su RAE","Data Variazione per Agenzia Entrate","Vecchio Settore Sintetico","Stato sede Legale FATCA","Codice Banca se Beneficiario","Codice FATCA","Ordine di Bonifico Permanente","Soggetto è dichiarante di un'operazione canalizzata","Tipo Intermediario","Solo operatori in oro","ID Comune Nascita","ID Stato Nascita","Non inviare titolare AGE","","","","","","Mitigazione","Path Documentazione Mitigazione","","Rischio Globale","Data Profilatura","Data Revisione Profilatura","Tipo Identificazione","Ultime Ricerca PEP","","","Presente in liste Crime","Data Ultima Ricerca","Altro Domicilio","Altro CAP","Conto Corrente","Mark Importazione","Rapporto con il segnalante","Legale Rappresentante","Tipo Soggetto","Causale Default per prestazioni","Importo Massimale","Fatturato","Frequenza / Calendarizzazione","Numero Operazioni Attese","Soggetto Affidatario Incarico","Escludi da estrazioni trimestrali","Non più attivo dal","Non più cliente Dal","Cliente dal","Data Identificazione","Data Segnalazione a UIF","Data Richiesta Autorità","Adeguata Verifica","Note Rischio"};
    return l_names;
  }
}
