public class MemoryCursorRow_anarapbo extends CPMemoryCursorRow {
  public MemoryCursorRow_anarapbo() {
  }
  public MemoryCursorRow_anarapbo(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_anarapbo toBuild = new MemoryCursor_anarapbo(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_anarapbo toBuild = new MemoryCursor_anarapbo();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String RAPPORTO = "";
  String DESCRAP = "";
  String TIPORAP = "";
  String FLAGLIRE = "";
  String VALUTA = "";
  String CONTINUA = "";
  String TIPOAG = "";
  String DOCFILE = "";
  double NOPROT = 0;
  String TIPMOD = "";
  java.sql.Date DATAMOD = CPLib.NullDate();
  String IDRAPPORTO = "";
  String IDBASE = "";
  String RAGIO = "";
  String MODSVOL = "";
  String AREAGEO = "";
  String SCOPO = "";
  String NATURA = "";
  double RTIPO = 0;
  double RCOMP = 0;
  double RIMP = 0;
  double RFREQ = 0;
  double RRAGIO = 0;
  double RAREA = 0;
  String TIPO = "";
  double PRGIMPRAP = 0;
  String AMMONT = "";
  String DURAT = "";
  double IMPAPE = 0;
  double IMPCHIU = 0;
  String SPLITCODE = "";
  String MACODICE = "";
  String CODDIP = "";
  String STATORAP = "";
  double CASTATOC = 0;
  double CASTATOM = 0;
  String CODICELR = "";
  java.sql.Date CADSTATO = CPLib.NullDate();
  double MITIG = 0;
  String MITGDOC = "";
  String CATEG01 = "";
  String CATEG02 = "";
  String CATEG03 = "";
  String CATEG04 = "";
  String CATEG05 = "";
  String CATEGORIA = "";
  String CODDIPE = "";
  String MITIGDOC = "";
  String DAC6 = "";
  double FLAGDAC6 = 0;
  String IBAN = "";
  String CODOGG = "";
  String RISGLOB = "";
  java.sql.Date DATAPROF = CPLib.NullDate();
  java.sql.Date DATAREVPROF = CPLib.NullDate();
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPORAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGLIRE))) {
      return false;
    }
    if ( ! (CPLib.Empty(VALUTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONTINUA))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOAG))) {
      return false;
    }
    if ( ! (CPLib.Empty(DOCFILE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOPROT))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPMOD))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAMOD))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDRAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDBASE))) {
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
    if ( ! (CPLib.Empty(PRGIMPRAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(AMMONT))) {
      return false;
    }
    if ( ! (CPLib.Empty(DURAT))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPAPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPCHIU))) {
      return false;
    }
    if ( ! (CPLib.Empty(SPLITCODE))) {
      return false;
    }
    if ( ! (CPLib.Empty(MACODICE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODDIP))) {
      return false;
    }
    if ( ! (CPLib.Empty(STATORAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CASTATOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(CASTATOM))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODICELR))) {
      return false;
    }
    if ( ! (CPLib.Empty(CADSTATO))) {
      return false;
    }
    if ( ! (CPLib.Empty(MITIG))) {
      return false;
    }
    if ( ! (CPLib.Empty(MITGDOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(CATEG01))) {
      return false;
    }
    if ( ! (CPLib.Empty(CATEG02))) {
      return false;
    }
    if ( ! (CPLib.Empty(CATEG03))) {
      return false;
    }
    if ( ! (CPLib.Empty(CATEG04))) {
      return false;
    }
    if ( ! (CPLib.Empty(CATEG05))) {
      return false;
    }
    if ( ! (CPLib.Empty(CATEGORIA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODDIPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(MITIGDOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(DAC6))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGDAC6))) {
      return false;
    }
    if ( ! (CPLib.Empty(IBAN))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODOGG))) {
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
    return true;
  }
  void Copy(MemoryCursorRow_anarapbo p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_anarapbo.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_anarapbo.this.DESCRAP = copyAndCast(p_row.DESCRAP);
      MemoryCursorRow_anarapbo.this.TIPORAP = copyAndCast(p_row.TIPORAP);
      MemoryCursorRow_anarapbo.this.FLAGLIRE = copyAndCast(p_row.FLAGLIRE);
      MemoryCursorRow_anarapbo.this.VALUTA = copyAndCast(p_row.VALUTA);
      MemoryCursorRow_anarapbo.this.CONTINUA = copyAndCast(p_row.CONTINUA);
      MemoryCursorRow_anarapbo.this.TIPOAG = copyAndCast(p_row.TIPOAG);
      MemoryCursorRow_anarapbo.this.DOCFILE = copyAndCast(p_row.DOCFILE);
      MemoryCursorRow_anarapbo.this.NOPROT = copyAndCast(p_row.NOPROT);
      MemoryCursorRow_anarapbo.this.TIPMOD = copyAndCast(p_row.TIPMOD);
      MemoryCursorRow_anarapbo.this.DATAMOD = copyAndCast(p_row.DATAMOD);
      MemoryCursorRow_anarapbo.this.IDRAPPORTO = copyAndCast(p_row.IDRAPPORTO);
      MemoryCursorRow_anarapbo.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_anarapbo.this.RAGIO = copyAndCast(p_row.RAGIO);
      MemoryCursorRow_anarapbo.this.MODSVOL = copyAndCast(p_row.MODSVOL);
      MemoryCursorRow_anarapbo.this.AREAGEO = copyAndCast(p_row.AREAGEO);
      MemoryCursorRow_anarapbo.this.SCOPO = copyAndCast(p_row.SCOPO);
      MemoryCursorRow_anarapbo.this.NATURA = copyAndCast(p_row.NATURA);
      MemoryCursorRow_anarapbo.this.RTIPO = copyAndCast(p_row.RTIPO);
      MemoryCursorRow_anarapbo.this.RCOMP = copyAndCast(p_row.RCOMP);
      MemoryCursorRow_anarapbo.this.RIMP = copyAndCast(p_row.RIMP);
      MemoryCursorRow_anarapbo.this.RFREQ = copyAndCast(p_row.RFREQ);
      MemoryCursorRow_anarapbo.this.RRAGIO = copyAndCast(p_row.RRAGIO);
      MemoryCursorRow_anarapbo.this.RAREA = copyAndCast(p_row.RAREA);
      MemoryCursorRow_anarapbo.this.TIPO = copyAndCast(p_row.TIPO);
      MemoryCursorRow_anarapbo.this.PRGIMPRAP = copyAndCast(p_row.PRGIMPRAP);
      MemoryCursorRow_anarapbo.this.AMMONT = copyAndCast(p_row.AMMONT);
      MemoryCursorRow_anarapbo.this.DURAT = copyAndCast(p_row.DURAT);
      MemoryCursorRow_anarapbo.this.IMPAPE = copyAndCast(p_row.IMPAPE);
      MemoryCursorRow_anarapbo.this.IMPCHIU = copyAndCast(p_row.IMPCHIU);
      MemoryCursorRow_anarapbo.this.SPLITCODE = copyAndCast(p_row.SPLITCODE);
      MemoryCursorRow_anarapbo.this.MACODICE = copyAndCast(p_row.MACODICE);
      MemoryCursorRow_anarapbo.this.CODDIP = copyAndCast(p_row.CODDIP);
      MemoryCursorRow_anarapbo.this.STATORAP = copyAndCast(p_row.STATORAP);
      MemoryCursorRow_anarapbo.this.CASTATOC = copyAndCast(p_row.CASTATOC);
      MemoryCursorRow_anarapbo.this.CASTATOM = copyAndCast(p_row.CASTATOM);
      MemoryCursorRow_anarapbo.this.CODICELR = copyAndCast(p_row.CODICELR);
      MemoryCursorRow_anarapbo.this.CADSTATO = copyAndCast(p_row.CADSTATO);
      MemoryCursorRow_anarapbo.this.MITIG = copyAndCast(p_row.MITIG);
      MemoryCursorRow_anarapbo.this.MITGDOC = copyAndCast(p_row.MITGDOC);
      MemoryCursorRow_anarapbo.this.CATEG01 = copyAndCast(p_row.CATEG01);
      MemoryCursorRow_anarapbo.this.CATEG02 = copyAndCast(p_row.CATEG02);
      MemoryCursorRow_anarapbo.this.CATEG03 = copyAndCast(p_row.CATEG03);
      MemoryCursorRow_anarapbo.this.CATEG04 = copyAndCast(p_row.CATEG04);
      MemoryCursorRow_anarapbo.this.CATEG05 = copyAndCast(p_row.CATEG05);
      MemoryCursorRow_anarapbo.this.CATEGORIA = copyAndCast(p_row.CATEGORIA);
      MemoryCursorRow_anarapbo.this.CODDIPE = copyAndCast(p_row.CODDIPE);
      MemoryCursorRow_anarapbo.this.MITIGDOC = copyAndCast(p_row.MITIGDOC);
      MemoryCursorRow_anarapbo.this.DAC6 = copyAndCast(p_row.DAC6);
      MemoryCursorRow_anarapbo.this.FLAGDAC6 = copyAndCast(p_row.FLAGDAC6);
      MemoryCursorRow_anarapbo.this.IBAN = copyAndCast(p_row.IBAN);
      MemoryCursorRow_anarapbo.this.CODOGG = copyAndCast(p_row.CODOGG);
      MemoryCursorRow_anarapbo.this.RISGLOB = copyAndCast(p_row.RISGLOB);
      MemoryCursorRow_anarapbo.this.DATAPROF = copyAndCast(p_row.DATAPROF);
      MemoryCursorRow_anarapbo.this.DATAREVPROF = copyAndCast(p_row.DATAREVPROF);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"RAPPORTO","DESCRAP","TIPORAP","FLAGLIRE","VALUTA","CONTINUA","TIPOAG","DOCFILE","NOPROT","TIPMOD","DATAMOD","IDRAPPORTO","IDBASE","RAGIO","MODSVOL","AREAGEO","SCOPO","NATURA","RTIPO","RCOMP","RIMP","RFREQ","RRAGIO","RAREA","TIPO","PRGIMPRAP","AMMONT","DURAT","IMPAPE","IMPCHIU","SPLITCODE","MACODICE","CODDIP","STATORAP","CASTATOC","CASTATOM","CODICELR","CADSTATO","MITIG","MITGDOC","CATEG01","CATEG02","CATEG03","CATEG04","CATEG05","CATEGORIA","CODDIPE","MITIGDOC","DAC6","FLAGDAC6","IBAN","CODOGG","RISGLOB","DATAPROF","DATAREVPROF"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","N","C","D","C","C","C","C","C","C","C","N","N","N","N","N","N","C","N","C","C","N","N","C","C","C","C","N","N","C","D","N","C","C","C","C","C","C","C","C","C","C","N","C","C","C","D","D"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Rapporto","Descrizione","Tipo Rapporto","Divisa","Codice Divisa","","","","Non inviare agenzia entrate","tipo Modifica","Data Modifica","ID Rapporto","ID Base","","","","","","","","","","","","","Progressivo Import","","","Import Apertura Agenzia Entrate","Import Chiusura Agenzia Entrate","Customer ID (WUBS)","Codice Macro Agente","Dipendenza / Agenzia che crea il rapporto","Stato Rapporto (CGO)","Stato SnaiCARD","Motivo Stato","Legale Rappresentante","Data Cambio Stato","Mitigazione","Path Documentazione Mitigazione","Categoria 1","Categoria 2","Categoria 3","Categoria 4","Categoria 5","Categoria","Codice Dipendenza","","","","","","Rischio Globale","Data Profilatura","Data Revisione Profilatura"};
    return l_names;
  }
}
