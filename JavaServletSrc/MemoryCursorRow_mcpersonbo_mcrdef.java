public class MemoryCursorRow_mcpersonbo_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcpersonbo_mcrdef() {
  }
  public MemoryCursorRow_mcpersonbo_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcpersonbo_mcrdef toBuild = new MemoryCursor_mcpersonbo_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcpersonbo_mcrdef toBuild = new MemoryCursor_mcpersonbo_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODCAB = "";
  String RAGSOC = "";
  String DOMICILIO = "";
  String CODFISC = "";
  java.sql.Date DATANASC = CPLib.NullDate();
  String NASCOMUN = "";
  String SOTGRUP = "";
  String RAMGRUP = "";
  String SETTSINT = "";
  String TIPODOC = "";
  String NUMDOCUM = "";
  java.sql.Date DATARILASC = CPLib.NullDate();
  String AUTRILASC = "";
  String DESCCIT = "";
  String PROVINCIA = "";
  String PAESE = "";
  String CAP = "";
  String PARTIVA = "";
  String SESSO = "";
  java.sql.Date DATAVALI = CPLib.NullDate();
  java.sql.Date DATAVAR = CPLib.NullDate();
  String COGNOME = "";
  String NOME = "";
  String DOCFILE = "";
  String PROVNAS = "";
  double CFESTERO = 0;
  String SPECIE = "";
  String COMPORT = "";
  String ATTIV = "";
  String AREAGEO = "";
  double RNATGIU = 0;
  double RCOMP = 0;
  double RATTIV = 0;
  double RAREA = 0;
  String PEP = "";
  String CONNES = "";
  java.sql.Date DATAVARAGE = CPLib.NullDate();
  String FATCA = "";
  String TIN = "";
  String ODB = "";
  String TELEF = "";
  String TIPOORO = "";
  String CODORO = "";
  String NOTIT = "";
  public boolean IsEmpty() {
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
    if ( ! (CPLib.Empty(RAMGRUP))) {
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
    if ( ! (CPLib.Empty(PARTIVA))) {
      return false;
    }
    if ( ! (CPLib.Empty(SESSO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAVALI))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAVAR))) {
      return false;
    }
    if ( ! (CPLib.Empty(COGNOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(DOCFILE))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVNAS))) {
      return false;
    }
    if ( ! (CPLib.Empty(CFESTERO))) {
      return false;
    }
    if ( ! (CPLib.Empty(SPECIE))) {
      return false;
    }
    if ( ! (CPLib.Empty(COMPORT))) {
      return false;
    }
    if ( ! (CPLib.Empty(ATTIV))) {
      return false;
    }
    if ( ! (CPLib.Empty(AREAGEO))) {
      return false;
    }
    if ( ! (CPLib.Empty(RNATGIU))) {
      return false;
    }
    if ( ! (CPLib.Empty(RCOMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(RATTIV))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAREA))) {
      return false;
    }
    if ( ! (CPLib.Empty(PEP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNES))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAVARAGE))) {
      return false;
    }
    if ( ! (CPLib.Empty(FATCA))) {
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
    if ( ! (CPLib.Empty(NOTIT))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcpersonbo_mcrdef p_row) {
    MemoryCursorRow_mcpersonbo_mcrdef l_row = new MemoryCursorRow_mcpersonbo_mcrdef();
    CopyOperation<MemoryCursorRow_mcpersonbo_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcpersonbo_mcrdef.this.CODCAB = l_row.CODCAB;
      MemoryCursorRow_mcpersonbo_mcrdef.this.RAGSOC = l_row.RAGSOC;
      MemoryCursorRow_mcpersonbo_mcrdef.this.DOMICILIO = l_row.DOMICILIO;
      MemoryCursorRow_mcpersonbo_mcrdef.this.CODFISC = l_row.CODFISC;
      MemoryCursorRow_mcpersonbo_mcrdef.this.DATANASC = l_row.DATANASC;
      MemoryCursorRow_mcpersonbo_mcrdef.this.NASCOMUN = l_row.NASCOMUN;
      MemoryCursorRow_mcpersonbo_mcrdef.this.SOTGRUP = l_row.SOTGRUP;
      MemoryCursorRow_mcpersonbo_mcrdef.this.RAMGRUP = l_row.RAMGRUP;
      MemoryCursorRow_mcpersonbo_mcrdef.this.SETTSINT = l_row.SETTSINT;
      MemoryCursorRow_mcpersonbo_mcrdef.this.TIPODOC = l_row.TIPODOC;
      MemoryCursorRow_mcpersonbo_mcrdef.this.NUMDOCUM = l_row.NUMDOCUM;
      MemoryCursorRow_mcpersonbo_mcrdef.this.DATARILASC = l_row.DATARILASC;
      MemoryCursorRow_mcpersonbo_mcrdef.this.AUTRILASC = l_row.AUTRILASC;
      MemoryCursorRow_mcpersonbo_mcrdef.this.DESCCIT = l_row.DESCCIT;
      MemoryCursorRow_mcpersonbo_mcrdef.this.PROVINCIA = l_row.PROVINCIA;
      MemoryCursorRow_mcpersonbo_mcrdef.this.PAESE = l_row.PAESE;
      MemoryCursorRow_mcpersonbo_mcrdef.this.CAP = l_row.CAP;
      MemoryCursorRow_mcpersonbo_mcrdef.this.PARTIVA = l_row.PARTIVA;
      MemoryCursorRow_mcpersonbo_mcrdef.this.SESSO = l_row.SESSO;
      MemoryCursorRow_mcpersonbo_mcrdef.this.DATAVALI = l_row.DATAVALI;
      MemoryCursorRow_mcpersonbo_mcrdef.this.DATAVAR = l_row.DATAVAR;
      MemoryCursorRow_mcpersonbo_mcrdef.this.COGNOME = l_row.COGNOME;
      MemoryCursorRow_mcpersonbo_mcrdef.this.NOME = l_row.NOME;
      MemoryCursorRow_mcpersonbo_mcrdef.this.DOCFILE = l_row.DOCFILE;
      MemoryCursorRow_mcpersonbo_mcrdef.this.PROVNAS = l_row.PROVNAS;
      MemoryCursorRow_mcpersonbo_mcrdef.this.CFESTERO = l_row.CFESTERO;
      MemoryCursorRow_mcpersonbo_mcrdef.this.SPECIE = l_row.SPECIE;
      MemoryCursorRow_mcpersonbo_mcrdef.this.COMPORT = l_row.COMPORT;
      MemoryCursorRow_mcpersonbo_mcrdef.this.ATTIV = l_row.ATTIV;
      MemoryCursorRow_mcpersonbo_mcrdef.this.AREAGEO = l_row.AREAGEO;
      MemoryCursorRow_mcpersonbo_mcrdef.this.RNATGIU = l_row.RNATGIU;
      MemoryCursorRow_mcpersonbo_mcrdef.this.RCOMP = l_row.RCOMP;
      MemoryCursorRow_mcpersonbo_mcrdef.this.RATTIV = l_row.RATTIV;
      MemoryCursorRow_mcpersonbo_mcrdef.this.RAREA = l_row.RAREA;
      MemoryCursorRow_mcpersonbo_mcrdef.this.PEP = l_row.PEP;
      MemoryCursorRow_mcpersonbo_mcrdef.this.CONNES = l_row.CONNES;
      MemoryCursorRow_mcpersonbo_mcrdef.this.DATAVARAGE = l_row.DATAVARAGE;
      MemoryCursorRow_mcpersonbo_mcrdef.this.FATCA = l_row.FATCA;
      MemoryCursorRow_mcpersonbo_mcrdef.this.TIN = l_row.TIN;
      MemoryCursorRow_mcpersonbo_mcrdef.this.ODB = l_row.ODB;
      MemoryCursorRow_mcpersonbo_mcrdef.this.TELEF = l_row.TELEF;
      MemoryCursorRow_mcpersonbo_mcrdef.this.TIPOORO = l_row.TIPOORO;
      MemoryCursorRow_mcpersonbo_mcrdef.this.CODORO = l_row.CODORO;
      MemoryCursorRow_mcpersonbo_mcrdef.this.NOTIT = l_row.NOTIT;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcpersonbo_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcpersonbo_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcpersonbo_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcpersonbo_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcpersonbo_mcrdef p_From,MemoryCursorRow_mcpersonbo_mcrdef p_To) {
        p_To.CODCAB = copyAndCast(p_From.CODCAB);
        p_To.RAGSOC = copyAndCast(p_From.RAGSOC);
        p_To.DOMICILIO = copyAndCast(p_From.DOMICILIO);
        p_To.CODFISC = copyAndCast(p_From.CODFISC);
        p_To.DATANASC = copyAndCast(p_From.DATANASC);
        p_To.NASCOMUN = copyAndCast(p_From.NASCOMUN);
        p_To.SOTGRUP = copyAndCast(p_From.SOTGRUP);
        p_To.RAMGRUP = copyAndCast(p_From.RAMGRUP);
        p_To.SETTSINT = copyAndCast(p_From.SETTSINT);
        p_To.TIPODOC = copyAndCast(p_From.TIPODOC);
        p_To.NUMDOCUM = copyAndCast(p_From.NUMDOCUM);
        p_To.DATARILASC = copyAndCast(p_From.DATARILASC);
        p_To.AUTRILASC = copyAndCast(p_From.AUTRILASC);
        p_To.DESCCIT = copyAndCast(p_From.DESCCIT);
        p_To.PROVINCIA = copyAndCast(p_From.PROVINCIA);
        p_To.PAESE = copyAndCast(p_From.PAESE);
        p_To.CAP = copyAndCast(p_From.CAP);
        p_To.PARTIVA = copyAndCast(p_From.PARTIVA);
        p_To.SESSO = copyAndCast(p_From.SESSO);
        p_To.DATAVALI = copyAndCast(p_From.DATAVALI);
        p_To.DATAVAR = copyAndCast(p_From.DATAVAR);
        p_To.COGNOME = copyAndCast(p_From.COGNOME);
        p_To.NOME = copyAndCast(p_From.NOME);
        p_To.DOCFILE = copyAndCast(p_From.DOCFILE);
        p_To.PROVNAS = copyAndCast(p_From.PROVNAS);
        p_To.CFESTERO = copyAndCast(p_From.CFESTERO);
        p_To.SPECIE = copyAndCast(p_From.SPECIE);
        p_To.COMPORT = copyAndCast(p_From.COMPORT);
        p_To.ATTIV = copyAndCast(p_From.ATTIV);
        p_To.AREAGEO = copyAndCast(p_From.AREAGEO);
        p_To.RNATGIU = copyAndCast(p_From.RNATGIU);
        p_To.RCOMP = copyAndCast(p_From.RCOMP);
        p_To.RATTIV = copyAndCast(p_From.RATTIV);
        p_To.RAREA = copyAndCast(p_From.RAREA);
        p_To.PEP = copyAndCast(p_From.PEP);
        p_To.CONNES = copyAndCast(p_From.CONNES);
        p_To.DATAVARAGE = copyAndCast(p_From.DATAVARAGE);
        p_To.FATCA = copyAndCast(p_From.FATCA);
        p_To.TIN = copyAndCast(p_From.TIN);
        p_To.ODB = copyAndCast(p_From.ODB);
        p_To.TELEF = copyAndCast(p_From.TELEF);
        p_To.TIPOORO = copyAndCast(p_From.TIPOORO);
        p_To.CODORO = copyAndCast(p_From.CODORO);
        p_To.NOTIT = copyAndCast(p_From.NOTIT);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODCAB","RAGSOC","DOMICILIO","CODFISC","DATANASC","NASCOMUN","SOTGRUP","RAMGRUP","SETTSINT","TIPODOC","NUMDOCUM","DATARILASC","AUTRILASC","DESCCIT","PROVINCIA","PAESE","CAP","PARTIVA","SESSO","DATAVALI","DATAVAR","COGNOME","NOME","DOCFILE","PROVNAS","CFESTERO","SPECIE","COMPORT","ATTIV","AREAGEO","RNATGIU","RCOMP","RATTIV","RAREA","PEP","CONNES","DATAVARAGE","FATCA","TIN","ODB","TELEF","TIPOORO","CODORO","NOTIT"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","D","C","C","C","C","C","C","D","C","C","C","C","C","C","C","D","D","C","C","C","C","N","C","C","C","C","N","N","N","N","C","C","D","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice CAB Residenza","Ragione Sociale","Indirizzo Residenza","Codice Fiscale","Data Nascita","Comune Di Nascita","SAE","RAE","Settorizzazione Sintetica","Tipo Documento","Numero Documento","Data Rilascio","Autorità Rilascio","Città Residenza","Provincia Residenza","Paese Residenza","CAP Residenza","Partita IVA","Sesso","Data Fine Validità Documento","Data Variazione Anagrafica","Cognome ","Nome","Patrh Documenti","Provincia di nascita","CF non generato da AGE","Specie giuridica","Rischio Comportamento","Codifice ATECO","Area Geografica Appartenenza","Rischio Natura Giuridica","Rischio Comportamento","Rischio Attività","Rischio Area Geografica","Persona Esposta Politicamente","NDG","Data Per Variazione Agenzia Entrate","Paese Residenza Fiscale","","","Telefono","Tipologia Operatore in Oro","Codice Operatore Oro","Esenzione Titolare Effettivo"};
    return l_names;
  }
}
