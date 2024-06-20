// Definition generated from table personbo
public class MemoryCursor_personbo extends CPMemoryCursor {
  MemoryCursorRow_personbo row;
  MemoryCursorRow_personbo empty_row;
  public MemoryCursor_personbo() {
    empty_row = new MemoryCursorRow_personbo();
    row = empty_row;
  }
  public MemoryCursor_personbo(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CONNES;
    p_CONNES = new java.util.Properties();
    java.util.Properties p_CODCAB;
    p_CODCAB = new java.util.Properties();
    java.util.Properties p_RAGSOC;
    p_RAGSOC = new java.util.Properties();
    java.util.Properties p_DOMICILIO;
    p_DOMICILIO = new java.util.Properties();
    java.util.Properties p_CODFISC;
    p_CODFISC = new java.util.Properties();
    java.util.Properties p_DATANASC;
    p_DATANASC = new java.util.Properties();
    java.util.Properties p_NASCOMUN;
    p_NASCOMUN = new java.util.Properties();
    java.util.Properties p_SOTGRUP;
    p_SOTGRUP = new java.util.Properties();
    java.util.Properties p_RAMOGRUP;
    p_RAMOGRUP = new java.util.Properties();
    java.util.Properties p_SETTSINT;
    p_SETTSINT = new java.util.Properties();
    java.util.Properties p_TIPODOC;
    p_TIPODOC = new java.util.Properties();
    java.util.Properties p_NUMDOCUM;
    p_NUMDOCUM = new java.util.Properties();
    java.util.Properties p_DATARILASC;
    p_DATARILASC = new java.util.Properties();
    java.util.Properties p_AUTRILASC;
    p_AUTRILASC = new java.util.Properties();
    java.util.Properties p_DESCCIT;
    p_DESCCIT = new java.util.Properties();
    java.util.Properties p_PROVINCIA;
    p_PROVINCIA = new java.util.Properties();
    java.util.Properties p_PAESE;
    p_PAESE = new java.util.Properties();
    java.util.Properties p_CAP;
    p_CAP = new java.util.Properties();
    java.util.Properties p_CODINTER;
    p_CODINTER = new java.util.Properties();
    java.util.Properties p_TIPINTER;
    p_TIPINTER = new java.util.Properties();
    java.util.Properties p_TIPOPERS;
    p_TIPOPERS = new java.util.Properties();
    java.util.Properties p_CODDIPE;
    p_CODDIPE = new java.util.Properties();
    java.util.Properties p_PARTIVA;
    p_PARTIVA = new java.util.Properties();
    java.util.Properties p_NOTE;
    p_NOTE = new java.util.Properties();
    java.util.Properties p_SESSO;
    p_SESSO = new java.util.Properties();
    java.util.Properties p_SOSPMAF;
    p_SOSPMAF = new java.util.Properties();
    java.util.Properties p_idcitta;
    p_idcitta = new java.util.Properties();
    java.util.Properties p_DATAVALI;
    p_DATAVALI = new java.util.Properties();
    java.util.Properties p_NASSTATO;
    p_NASSTATO = new java.util.Properties();
    java.util.Properties p_DOCFILE;
    p_DOCFILE = new java.util.Properties();
    java.util.Properties p_NOME;
    p_NOME = new java.util.Properties();
    java.util.Properties p_COGNOME;
    p_COGNOME = new java.util.Properties();
    java.util.Properties p_CFESTERO;
    p_CFESTERO = new java.util.Properties();
    java.util.Properties p_OLDCONNES;
    p_OLDCONNES = new java.util.Properties();
    java.util.Properties p_DATEXTRA;
    p_DATEXTRA = new java.util.Properties();
    java.util.Properties p_PKTBSPECIE;
    p_PKTBSPECIE = new java.util.Properties();
    java.util.Properties p_COMPORT;
    p_COMPORT = new java.util.Properties();
    java.util.Properties p_ATTIV;
    p_ATTIV = new java.util.Properties();
    java.util.Properties p_RNATGIU;
    p_RNATGIU = new java.util.Properties();
    java.util.Properties p_RATTIV;
    p_RATTIV = new java.util.Properties();
    java.util.Properties p_RCOMP;
    p_RCOMP = new java.util.Properties();
    java.util.Properties p_RAREA;
    p_RAREA = new java.util.Properties();
    java.util.Properties p_ALLINEATO;
    p_ALLINEATO = new java.util.Properties();
    java.util.Properties p_ALLINEATONOMECNOME;
    p_ALLINEATONOMECNOME = new java.util.Properties();
    java.util.Properties p_RAGSOCOLD;
    p_RAGSOCOLD = new java.util.Properties();
    java.util.Properties p_PROGIMPORT;
    p_PROGIMPORT = new java.util.Properties();
    java.util.Properties p_PROGIMP_C;
    p_PROGIMP_C = new java.util.Properties();
    java.util.Properties p_AREAGEO;
    p_AREAGEO = new java.util.Properties();
    java.util.Properties p_PEP;
    p_PEP = new java.util.Properties();
    java.util.Properties p_IDFILE;
    p_IDFILE = new java.util.Properties();
    java.util.Properties p_OLDCODFISC;
    p_OLDCODFISC = new java.util.Properties();
    java.util.Properties p_MACROAGENTE;
    p_MACROAGENTE = new java.util.Properties();
    java.util.Properties p_SPOTID;
    p_SPOTID = new java.util.Properties();
    java.util.Properties p_DATASEGN;
    p_DATASEGN = new java.util.Properties();
    java.util.Properties p_OLDSETSIN;
    p_OLDSETSIN = new java.util.Properties();
    java.util.Properties p_DATAVARAGE;
    p_DATAVARAGE = new java.util.Properties();
    java.util.Properties p_SETTSINT2;
    p_SETTSINT2 = new java.util.Properties();
    java.util.Properties p_FATCA;
    p_FATCA = new java.util.Properties();
    java.util.Properties p_BANCABEN;
    p_BANCABEN = new java.util.Properties();
    java.util.Properties p_TIN;
    p_TIN = new java.util.Properties();
    java.util.Properties p_ODB;
    p_ODB = new java.util.Properties();
    java.util.Properties p_TELEF;
    p_TELEF = new java.util.Properties();
    java.util.Properties p_TIPOORO;
    p_TIPOORO = new java.util.Properties();
    java.util.Properties p_CODORO;
    p_CODORO = new java.util.Properties();
    java.util.Properties p_IDNASCOMUN;
    p_IDNASCOMUN = new java.util.Properties();
    java.util.Properties p_IDNASSTATO;
    p_IDNASSTATO = new java.util.Properties();
    java.util.Properties p_NOTIT;
    p_NOTIT = new java.util.Properties();
    java.util.Properties p_IDBASE;
    p_IDBASE = new java.util.Properties();
    java.util.Properties p_FLGVALIDO;
    p_FLGVALIDO = new java.util.Properties();
    java.util.Properties p_CITTADIN1;
    p_CITTADIN1 = new java.util.Properties();
    java.util.Properties p_CITTADIN2;
    p_CITTADIN2 = new java.util.Properties();
    java.util.Properties p_RESFISC;
    p_RESFISC = new java.util.Properties();
    java.util.Properties p_MITIG;
    p_MITIG = new java.util.Properties();
    java.util.Properties p_MITIGDOC;
    p_MITIGDOC = new java.util.Properties();
    java.util.Properties p_NOSARA;
    p_NOSARA = new java.util.Properties();
    java.util.Properties p_RISGLOB;
    p_RISGLOB = new java.util.Properties();
    java.util.Properties p_DATAPROF;
    p_DATAPROF = new java.util.Properties();
    java.util.Properties p_DATAREVPROF;
    p_DATAREVPROF = new java.util.Properties();
    java.util.Properties p_IDENT;
    p_IDENT = new java.util.Properties();
    java.util.Properties p_PEPDATE;
    p_PEPDATE = new java.util.Properties();
    java.util.Properties p_DAC6;
    p_DAC6 = new java.util.Properties();
    java.util.Properties p_FLAGDAC6;
    p_FLAGDAC6 = new java.util.Properties();
    java.util.Properties p_CRIME;
    p_CRIME = new java.util.Properties();
    java.util.Properties p_CRIMEDATE;
    p_CRIMEDATE = new java.util.Properties();
    java.util.Properties p_ALTRODOM;
    p_ALTRODOM = new java.util.Properties();
    java.util.Properties p_ALTROCAP;
    p_ALTROCAP = new java.util.Properties();
    java.util.Properties p_CONTO;
    p_CONTO = new java.util.Properties();
    java.util.Properties p_NUMIMP;
    p_NUMIMP = new java.util.Properties();
    java.util.Properties p_RAPSEGNA;
    p_RAPSEGNA = new java.util.Properties();
    java.util.Properties p_CODLEGRAP;
    p_CODLEGRAP = new java.util.Properties();
    java.util.Properties p_TIPOSOGGETTO;
    p_TIPOSOGGETTO = new java.util.Properties();
    java.util.Properties p_CAUSALE;
    p_CAUSALE = new java.util.Properties();
    java.util.Properties p_IMPORTOMAX;
    p_IMPORTOMAX = new java.util.Properties();
    java.util.Properties p_FATTURATO;
    p_FATTURATO = new java.util.Properties();
    java.util.Properties p_FREQUENZA;
    p_FREQUENZA = new java.util.Properties();
    java.util.Properties p_NUMOPERAZ;
    p_NUMOPERAZ = new java.util.Properties();
    java.util.Properties p_SOGAFFIDATARIO;
    p_SOGAFFIDATARIO = new java.util.Properties();
    java.util.Properties p_FLGNOTRIM;
    p_FLGNOTRIM = new java.util.Properties();
    java.util.Properties p_DISATTIVO;
    p_DISATTIVO = new java.util.Properties();
    java.util.Properties p_DATAFINE;
    p_DATAFINE = new java.util.Properties();
    java.util.Properties p_DATAINI;
    p_DATAINI = new java.util.Properties();
    java.util.Properties p_DATAIDENT;
    p_DATAIDENT = new java.util.Properties();
    java.util.Properties p_DATASIGN;
    p_DATASIGN = new java.util.Properties();
    java.util.Properties p_DATARAUT;
    p_DATARAUT = new java.util.Properties();
    java.util.Properties p_VERIFICA;
    p_VERIFICA = new java.util.Properties();
    java.util.Properties p_NOTERIS;
    p_NOTERIS = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNES".equalsIgnoreCase(key)) {
        p_CONNES = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODCAB".equalsIgnoreCase(key)) {
        p_CODCAB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAGSOC".equalsIgnoreCase(key)) {
        p_RAGSOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DOMICILIO".equalsIgnoreCase(key)) {
        p_DOMICILIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODFISC".equalsIgnoreCase(key)) {
        p_CODFISC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATANASC".equalsIgnoreCase(key)) {
        p_DATANASC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NASCOMUN".equalsIgnoreCase(key)) {
        p_NASCOMUN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SOTGRUP".equalsIgnoreCase(key)) {
        p_SOTGRUP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAMOGRUP".equalsIgnoreCase(key)) {
        p_RAMOGRUP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SETTSINT".equalsIgnoreCase(key)) {
        p_SETTSINT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPODOC".equalsIgnoreCase(key)) {
        p_TIPODOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMDOCUM".equalsIgnoreCase(key)) {
        p_NUMDOCUM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATARILASC".equalsIgnoreCase(key)) {
        p_DATARILASC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AUTRILASC".equalsIgnoreCase(key)) {
        p_AUTRILASC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCCIT".equalsIgnoreCase(key)) {
        p_DESCCIT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROVINCIA".equalsIgnoreCase(key)) {
        p_PROVINCIA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESE".equalsIgnoreCase(key)) {
        p_PAESE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAP".equalsIgnoreCase(key)) {
        p_CAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODINTER".equalsIgnoreCase(key)) {
        p_CODINTER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPINTER".equalsIgnoreCase(key)) {
        p_TIPINTER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOPERS".equalsIgnoreCase(key)) {
        p_TIPOPERS = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODDIPE".equalsIgnoreCase(key)) {
        p_CODDIPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PARTIVA".equalsIgnoreCase(key)) {
        p_PARTIVA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOTE".equalsIgnoreCase(key)) {
        p_NOTE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SESSO".equalsIgnoreCase(key)) {
        p_SESSO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SOSPMAF".equalsIgnoreCase(key)) {
        p_SOSPMAF = CPLib.GetProperties(p.getProperty(key));
      }
      if ("idcitta".equalsIgnoreCase(key)) {
        p_idcitta = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAVALI".equalsIgnoreCase(key)) {
        p_DATAVALI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NASSTATO".equalsIgnoreCase(key)) {
        p_NASSTATO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DOCFILE".equalsIgnoreCase(key)) {
        p_DOCFILE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOME".equalsIgnoreCase(key)) {
        p_NOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COGNOME".equalsIgnoreCase(key)) {
        p_COGNOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CFESTERO".equalsIgnoreCase(key)) {
        p_CFESTERO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("OLDCONNES".equalsIgnoreCase(key)) {
        p_OLDCONNES = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATEXTRA".equalsIgnoreCase(key)) {
        p_DATEXTRA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PKTBSPECIE".equalsIgnoreCase(key)) {
        p_PKTBSPECIE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COMPORT".equalsIgnoreCase(key)) {
        p_COMPORT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ATTIV".equalsIgnoreCase(key)) {
        p_ATTIV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RNATGIU".equalsIgnoreCase(key)) {
        p_RNATGIU = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RATTIV".equalsIgnoreCase(key)) {
        p_RATTIV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RCOMP".equalsIgnoreCase(key)) {
        p_RCOMP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAREA".equalsIgnoreCase(key)) {
        p_RAREA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ALLINEATO".equalsIgnoreCase(key)) {
        p_ALLINEATO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ALLINEATONOMECNOME".equalsIgnoreCase(key)) {
        p_ALLINEATONOMECNOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAGSOCOLD".equalsIgnoreCase(key)) {
        p_RAGSOCOLD = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROGIMPORT".equalsIgnoreCase(key)) {
        p_PROGIMPORT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROGIMP_C".equalsIgnoreCase(key)) {
        p_PROGIMP_C = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AREAGEO".equalsIgnoreCase(key)) {
        p_AREAGEO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PEP".equalsIgnoreCase(key)) {
        p_PEP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDFILE".equalsIgnoreCase(key)) {
        p_IDFILE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("OLDCODFISC".equalsIgnoreCase(key)) {
        p_OLDCODFISC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MACROAGENTE".equalsIgnoreCase(key)) {
        p_MACROAGENTE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SPOTID".equalsIgnoreCase(key)) {
        p_SPOTID = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATASEGN".equalsIgnoreCase(key)) {
        p_DATASEGN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("OLDSETSIN".equalsIgnoreCase(key)) {
        p_OLDSETSIN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAVARAGE".equalsIgnoreCase(key)) {
        p_DATAVARAGE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SETTSINT2".equalsIgnoreCase(key)) {
        p_SETTSINT2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FATCA".equalsIgnoreCase(key)) {
        p_FATCA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("BANCABEN".equalsIgnoreCase(key)) {
        p_BANCABEN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIN".equalsIgnoreCase(key)) {
        p_TIN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ODB".equalsIgnoreCase(key)) {
        p_ODB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TELEF".equalsIgnoreCase(key)) {
        p_TELEF = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOORO".equalsIgnoreCase(key)) {
        p_TIPOORO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODORO".equalsIgnoreCase(key)) {
        p_CODORO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDNASCOMUN".equalsIgnoreCase(key)) {
        p_IDNASCOMUN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDNASSTATO".equalsIgnoreCase(key)) {
        p_IDNASSTATO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOTIT".equalsIgnoreCase(key)) {
        p_NOTIT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDBASE".equalsIgnoreCase(key)) {
        p_IDBASE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGVALIDO".equalsIgnoreCase(key)) {
        p_FLGVALIDO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CITTADIN1".equalsIgnoreCase(key)) {
        p_CITTADIN1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CITTADIN2".equalsIgnoreCase(key)) {
        p_CITTADIN2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RESFISC".equalsIgnoreCase(key)) {
        p_RESFISC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MITIG".equalsIgnoreCase(key)) {
        p_MITIG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MITIGDOC".equalsIgnoreCase(key)) {
        p_MITIGDOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOSARA".equalsIgnoreCase(key)) {
        p_NOSARA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RISGLOB".equalsIgnoreCase(key)) {
        p_RISGLOB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAPROF".equalsIgnoreCase(key)) {
        p_DATAPROF = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAREVPROF".equalsIgnoreCase(key)) {
        p_DATAREVPROF = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDENT".equalsIgnoreCase(key)) {
        p_IDENT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PEPDATE".equalsIgnoreCase(key)) {
        p_PEPDATE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DAC6".equalsIgnoreCase(key)) {
        p_DAC6 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLAGDAC6".equalsIgnoreCase(key)) {
        p_FLAGDAC6 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CRIME".equalsIgnoreCase(key)) {
        p_CRIME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CRIMEDATE".equalsIgnoreCase(key)) {
        p_CRIMEDATE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ALTRODOM".equalsIgnoreCase(key)) {
        p_ALTRODOM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ALTROCAP".equalsIgnoreCase(key)) {
        p_ALTROCAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONTO".equalsIgnoreCase(key)) {
        p_CONTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMIMP".equalsIgnoreCase(key)) {
        p_NUMIMP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAPSEGNA".equalsIgnoreCase(key)) {
        p_RAPSEGNA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODLEGRAP".equalsIgnoreCase(key)) {
        p_CODLEGRAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOSOGGETTO".equalsIgnoreCase(key)) {
        p_TIPOSOGGETTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAUSALE".equalsIgnoreCase(key)) {
        p_CAUSALE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMPORTOMAX".equalsIgnoreCase(key)) {
        p_IMPORTOMAX = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FATTURATO".equalsIgnoreCase(key)) {
        p_FATTURATO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FREQUENZA".equalsIgnoreCase(key)) {
        p_FREQUENZA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMOPERAZ".equalsIgnoreCase(key)) {
        p_NUMOPERAZ = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SOGAFFIDATARIO".equalsIgnoreCase(key)) {
        p_SOGAFFIDATARIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGNOTRIM".equalsIgnoreCase(key)) {
        p_FLGNOTRIM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DISATTIVO".equalsIgnoreCase(key)) {
        p_DISATTIVO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAFINE".equalsIgnoreCase(key)) {
        p_DATAFINE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAINI".equalsIgnoreCase(key)) {
        p_DATAINI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAIDENT".equalsIgnoreCase(key)) {
        p_DATAIDENT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATASIGN".equalsIgnoreCase(key)) {
        p_DATASIGN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATARAUT".equalsIgnoreCase(key)) {
        p_DATARAUT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VERIFICA".equalsIgnoreCase(key)) {
        p_VERIFICA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOTERIS".equalsIgnoreCase(key)) {
        p_NOTERIS = CPLib.GetProperties(p.getProperty(key));
      }
    }
    for ( i = 1; CPLib.le(i,Rows); i = i + (1)) {
      AppendBlank();
      String l_cKeyValue = null;
      l_cKeyValue = CPLib.GetProperty(l_Key,"",l_cKeyValue,i);
      Object l_KeyValue = l_cKeyValue;
      if ( ! (CPLib.IsNull(l_KeyValue))) {
        SetKey(l_KeyValue);
      }
      row.CONNES = CPLib.GetProperty(p_CONNES,"","",i);
      row.CODCAB = CPLib.GetProperty(p_CODCAB,"","",i);
      row.RAGSOC = CPLib.GetProperty(p_RAGSOC,"","",i);
      row.DOMICILIO = CPLib.GetProperty(p_DOMICILIO,"","",i);
      row.CODFISC = CPLib.GetProperty(p_CODFISC,"","",i);
      row.DATANASC = CPLib.GetProperty(p_DATANASC,"",CPLib.NullDate(),i);
      row.NASCOMUN = CPLib.GetProperty(p_NASCOMUN,"","",i);
      row.SOTGRUP = CPLib.GetProperty(p_SOTGRUP,"","",i);
      row.RAMOGRUP = CPLib.GetProperty(p_RAMOGRUP,"","",i);
      row.SETTSINT = CPLib.GetProperty(p_SETTSINT,"","",i);
      row.TIPODOC = CPLib.GetProperty(p_TIPODOC,"","",i);
      row.NUMDOCUM = CPLib.GetProperty(p_NUMDOCUM,"","",i);
      row.DATARILASC = CPLib.GetProperty(p_DATARILASC,"",CPLib.NullDate(),i);
      row.AUTRILASC = CPLib.GetProperty(p_AUTRILASC,"","",i);
      row.DESCCIT = CPLib.GetProperty(p_DESCCIT,"","",i);
      row.PROVINCIA = CPLib.GetProperty(p_PROVINCIA,"","",i);
      row.PAESE = CPLib.GetProperty(p_PAESE,"","",i);
      row.CAP = CPLib.GetProperty(p_CAP,"","",i);
      row.CODINTER = CPLib.GetProperty(p_CODINTER,"","",i);
      row.TIPINTER = CPLib.GetProperty(p_TIPINTER,"","",i);
      row.TIPOPERS = CPLib.GetProperty(p_TIPOPERS,"","",i);
      row.CODDIPE = CPLib.GetProperty(p_CODDIPE,"","",i);
      row.PARTIVA = CPLib.GetProperty(p_PARTIVA,"","",i);
      row.NOTE = CPLib.GetProperty(p_NOTE,"","",i);
      row.SESSO = CPLib.GetProperty(p_SESSO,"","",i);
      row.SOSPMAF = CPLib.GetProperty(p_SOSPMAF,"","",i);
      row.idcitta = CPLib.GetProperty(p_idcitta,"","",i);
      row.DATAVALI = CPLib.GetProperty(p_DATAVALI,"",CPLib.NullDate(),i);
      row.NASSTATO = CPLib.GetProperty(p_NASSTATO,"","",i);
      row.DOCFILE = CPLib.GetProperty(p_DOCFILE,"","",i);
      row.NOME = CPLib.GetProperty(p_NOME,"","",i);
      row.COGNOME = CPLib.GetProperty(p_COGNOME,"","",i);
      row.CFESTERO = CPLib.GetProperty(p_CFESTERO,"",0,i);
      row.OLDCONNES = CPLib.GetProperty(p_OLDCONNES,"","",i);
      row.DATEXTRA = CPLib.GetProperty(p_DATEXTRA,"",CPLib.NullDate(),i);
      row.PKTBSPECIE = CPLib.GetProperty(p_PKTBSPECIE,"","",i);
      row.COMPORT = CPLib.GetProperty(p_COMPORT,"","",i);
      row.ATTIV = CPLib.GetProperty(p_ATTIV,"","",i);
      row.RNATGIU = CPLib.GetProperty(p_RNATGIU,"",0,i);
      row.RATTIV = CPLib.GetProperty(p_RATTIV,"",0,i);
      row.RCOMP = CPLib.GetProperty(p_RCOMP,"",0,i);
      row.RAREA = CPLib.GetProperty(p_RAREA,"",0,i);
      row.ALLINEATO = CPLib.GetProperty(p_ALLINEATO,"",0,i);
      row.ALLINEATONOMECNOME = CPLib.GetProperty(p_ALLINEATONOMECNOME,"",0,i);
      row.RAGSOCOLD = CPLib.GetProperty(p_RAGSOCOLD,"","",i);
      row.PROGIMPORT = CPLib.GetProperty(p_PROGIMPORT,"",0,i);
      row.PROGIMP_C = CPLib.GetProperty(p_PROGIMP_C,"","",i);
      row.AREAGEO = CPLib.GetProperty(p_AREAGEO,"","",i);
      row.PEP = CPLib.GetProperty(p_PEP,"","",i);
      row.IDFILE = CPLib.GetProperty(p_IDFILE,"","",i);
      row.OLDCODFISC = CPLib.GetProperty(p_OLDCODFISC,"","",i);
      row.MACROAGENTE = CPLib.GetProperty(p_MACROAGENTE,"","",i);
      row.SPOTID = CPLib.GetProperty(p_SPOTID,"","",i);
      row.DATASEGN = CPLib.GetProperty(p_DATASEGN,"",CPLib.NullDate(),i);
      row.OLDSETSIN = CPLib.GetProperty(p_OLDSETSIN,"","",i);
      row.DATAVARAGE = CPLib.GetProperty(p_DATAVARAGE,"",CPLib.NullDate(),i);
      row.SETTSINT2 = CPLib.GetProperty(p_SETTSINT2,"","",i);
      row.FATCA = CPLib.GetProperty(p_FATCA,"","",i);
      row.BANCABEN = CPLib.GetProperty(p_BANCABEN,"","",i);
      row.TIN = CPLib.GetProperty(p_TIN,"","",i);
      row.ODB = CPLib.GetProperty(p_ODB,"",0,i);
      row.TELEF = CPLib.GetProperty(p_TELEF,"","",i);
      row.TIPOORO = CPLib.GetProperty(p_TIPOORO,"","",i);
      row.CODORO = CPLib.GetProperty(p_CODORO,"","",i);
      row.IDNASCOMUN = CPLib.GetProperty(p_IDNASCOMUN,"","",i);
      row.IDNASSTATO = CPLib.GetProperty(p_IDNASSTATO,"","",i);
      row.NOTIT = CPLib.GetProperty(p_NOTIT,"",0,i);
      row.IDBASE = CPLib.GetProperty(p_IDBASE,"","",i);
      row.FLGVALIDO = CPLib.GetProperty(p_FLGVALIDO,"","",i);
      row.CITTADIN1 = CPLib.GetProperty(p_CITTADIN1,"","",i);
      row.CITTADIN2 = CPLib.GetProperty(p_CITTADIN2,"","",i);
      row.RESFISC = CPLib.GetProperty(p_RESFISC,"","",i);
      row.MITIG = CPLib.GetProperty(p_MITIG,"",0,i);
      row.MITIGDOC = CPLib.GetProperty(p_MITIGDOC,"","",i);
      row.NOSARA = CPLib.GetProperty(p_NOSARA,"","",i);
      row.RISGLOB = CPLib.GetProperty(p_RISGLOB,"","",i);
      row.DATAPROF = CPLib.GetProperty(p_DATAPROF,"",CPLib.NullDate(),i);
      row.DATAREVPROF = CPLib.GetProperty(p_DATAREVPROF,"",CPLib.NullDate(),i);
      row.IDENT = CPLib.GetProperty(p_IDENT,"","",i);
      row.PEPDATE = CPLib.GetProperty(p_PEPDATE,"",CPLib.NullDate(),i);
      row.DAC6 = CPLib.GetProperty(p_DAC6,"","",i);
      row.FLAGDAC6 = CPLib.GetProperty(p_FLAGDAC6,"",0,i);
      row.CRIME = CPLib.GetProperty(p_CRIME,"","",i);
      row.CRIMEDATE = CPLib.GetProperty(p_CRIMEDATE,"",CPLib.NullDate(),i);
      row.ALTRODOM = CPLib.GetProperty(p_ALTRODOM,"","",i);
      row.ALTROCAP = CPLib.GetProperty(p_ALTROCAP,"","",i);
      row.CONTO = CPLib.GetProperty(p_CONTO,"","",i);
      row.NUMIMP = CPLib.GetProperty(p_NUMIMP,"",CPLib.NullDateTime(),i);
      row.RAPSEGNA = CPLib.GetProperty(p_RAPSEGNA,"","",i);
      row.CODLEGRAP = CPLib.GetProperty(p_CODLEGRAP,"","",i);
      row.TIPOSOGGETTO = CPLib.GetProperty(p_TIPOSOGGETTO,"","",i);
      row.CAUSALE = CPLib.GetProperty(p_CAUSALE,"",0,i);
      row.IMPORTOMAX = CPLib.GetProperty(p_IMPORTOMAX,"",0,i);
      row.FATTURATO = CPLib.GetProperty(p_FATTURATO,"",0,i);
      row.FREQUENZA = CPLib.GetProperty(p_FREQUENZA,"","",i);
      row.NUMOPERAZ = CPLib.GetProperty(p_NUMOPERAZ,"",0,i);
      row.SOGAFFIDATARIO = CPLib.GetProperty(p_SOGAFFIDATARIO,"","",i);
      row.FLGNOTRIM = CPLib.GetProperty(p_FLGNOTRIM,"","",i);
      row.DISATTIVO = CPLib.GetProperty(p_DISATTIVO,"",CPLib.NullDate(),i);
      row.DATAFINE = CPLib.GetProperty(p_DATAFINE,"",CPLib.NullDate(),i);
      row.DATAINI = CPLib.GetProperty(p_DATAINI,"",CPLib.NullDate(),i);
      row.DATAIDENT = CPLib.GetProperty(p_DATAIDENT,"",CPLib.NullDate(),i);
      row.DATASIGN = CPLib.GetProperty(p_DATASIGN,"",CPLib.NullDate(),i);
      row.DATARAUT = CPLib.GetProperty(p_DATARAUT,"",CPLib.NullDate(),i);
      row.VERIFICA = CPLib.GetProperty(p_VERIFICA,"","",i);
      row.NOTERIS = CPLib.GetProperty(p_NOTERIS,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_personbo)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_personbo();
  }
  protected String[] GetColumnNames() {
    return row.GetColumnNames();
  }
  protected String[] GetColumnTypes() {
    return row.GetColumnTypes();
  }
  public CPMemoryCursorRow CurrentRow() {
    return row;
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_personbo _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_personbo _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_personbo> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_personbo p_Row) {
    MemoryCursorRow_personbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_personbo p_Row) {
    MemoryCursorRow_personbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_personbo p_Row) {
    MemoryCursorRow_personbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_personbo p_Row) {
    MemoryCursorRow_personbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_personbo p_Row) {
    MemoryCursorRow_personbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_personbo p_Row) {
    MemoryCursorRow_personbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_personbo p_Row) {
    MemoryCursorRow_personbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_personbo p_Row) {
    MemoryCursorRow_personbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_personbo p_Row) {
    MemoryCursorRow_personbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_personbo p_Row) {
    MemoryCursorRow_personbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_personbo p_Row) {
    MemoryCursorRow_personbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_personbo p_Row) {
    MemoryCursorRow_personbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_personbo p_Row) {
    MemoryCursorRow_personbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_personbo p_Row) {
    MemoryCursorRow_personbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_personbo p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_personbo();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
