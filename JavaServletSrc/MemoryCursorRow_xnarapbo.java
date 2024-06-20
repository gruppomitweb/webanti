public class MemoryCursorRow_xnarapbo extends CPMemoryCursorRow {
  public MemoryCursorRow_xnarapbo() {
  }
  public MemoryCursorRow_xnarapbo(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_xnarapbo toBuild = new MemoryCursor_xnarapbo(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_xnarapbo toBuild = new MemoryCursor_xnarapbo();
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
  String DAC6 = "";
  double FLAGDAC6 = 0;
  String IBAN = "";
  String CODOGG = "";
  String RISGLOB = "";
  java.sql.Date DATAPROF = CPLib.NullDate();
  java.sql.Date DATAREVPROF = CPLib.NullDate();
  java.sql.Timestamp NUMIMP = CPLib.NullDateTime();
  String ISOAGE = "";
  double NOCANC = 0;
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
    if ( ! (CPLib.Empty(NUMIMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(ISOAGE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOCANC))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_xnarapbo p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_xnarapbo.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_xnarapbo.this.DESCRAP = copyAndCast(p_row.DESCRAP);
      MemoryCursorRow_xnarapbo.this.TIPORAP = copyAndCast(p_row.TIPORAP);
      MemoryCursorRow_xnarapbo.this.FLAGLIRE = copyAndCast(p_row.FLAGLIRE);
      MemoryCursorRow_xnarapbo.this.VALUTA = copyAndCast(p_row.VALUTA);
      MemoryCursorRow_xnarapbo.this.CONTINUA = copyAndCast(p_row.CONTINUA);
      MemoryCursorRow_xnarapbo.this.TIPOAG = copyAndCast(p_row.TIPOAG);
      MemoryCursorRow_xnarapbo.this.DOCFILE = copyAndCast(p_row.DOCFILE);
      MemoryCursorRow_xnarapbo.this.NOPROT = copyAndCast(p_row.NOPROT);
      MemoryCursorRow_xnarapbo.this.TIPMOD = copyAndCast(p_row.TIPMOD);
      MemoryCursorRow_xnarapbo.this.DATAMOD = copyAndCast(p_row.DATAMOD);
      MemoryCursorRow_xnarapbo.this.IDRAPPORTO = copyAndCast(p_row.IDRAPPORTO);
      MemoryCursorRow_xnarapbo.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_xnarapbo.this.RAGIO = copyAndCast(p_row.RAGIO);
      MemoryCursorRow_xnarapbo.this.MODSVOL = copyAndCast(p_row.MODSVOL);
      MemoryCursorRow_xnarapbo.this.AREAGEO = copyAndCast(p_row.AREAGEO);
      MemoryCursorRow_xnarapbo.this.SCOPO = copyAndCast(p_row.SCOPO);
      MemoryCursorRow_xnarapbo.this.NATURA = copyAndCast(p_row.NATURA);
      MemoryCursorRow_xnarapbo.this.RTIPO = copyAndCast(p_row.RTIPO);
      MemoryCursorRow_xnarapbo.this.RCOMP = copyAndCast(p_row.RCOMP);
      MemoryCursorRow_xnarapbo.this.RIMP = copyAndCast(p_row.RIMP);
      MemoryCursorRow_xnarapbo.this.RFREQ = copyAndCast(p_row.RFREQ);
      MemoryCursorRow_xnarapbo.this.RRAGIO = copyAndCast(p_row.RRAGIO);
      MemoryCursorRow_xnarapbo.this.RAREA = copyAndCast(p_row.RAREA);
      MemoryCursorRow_xnarapbo.this.TIPO = copyAndCast(p_row.TIPO);
      MemoryCursorRow_xnarapbo.this.PRGIMPRAP = copyAndCast(p_row.PRGIMPRAP);
      MemoryCursorRow_xnarapbo.this.AMMONT = copyAndCast(p_row.AMMONT);
      MemoryCursorRow_xnarapbo.this.DURAT = copyAndCast(p_row.DURAT);
      MemoryCursorRow_xnarapbo.this.IMPAPE = copyAndCast(p_row.IMPAPE);
      MemoryCursorRow_xnarapbo.this.IMPCHIU = copyAndCast(p_row.IMPCHIU);
      MemoryCursorRow_xnarapbo.this.SPLITCODE = copyAndCast(p_row.SPLITCODE);
      MemoryCursorRow_xnarapbo.this.MACODICE = copyAndCast(p_row.MACODICE);
      MemoryCursorRow_xnarapbo.this.CODDIP = copyAndCast(p_row.CODDIP);
      MemoryCursorRow_xnarapbo.this.STATORAP = copyAndCast(p_row.STATORAP);
      MemoryCursorRow_xnarapbo.this.CASTATOC = copyAndCast(p_row.CASTATOC);
      MemoryCursorRow_xnarapbo.this.CASTATOM = copyAndCast(p_row.CASTATOM);
      MemoryCursorRow_xnarapbo.this.CODICELR = copyAndCast(p_row.CODICELR);
      MemoryCursorRow_xnarapbo.this.CADSTATO = copyAndCast(p_row.CADSTATO);
      MemoryCursorRow_xnarapbo.this.MITIG = copyAndCast(p_row.MITIG);
      MemoryCursorRow_xnarapbo.this.MITGDOC = copyAndCast(p_row.MITGDOC);
      MemoryCursorRow_xnarapbo.this.CATEG01 = copyAndCast(p_row.CATEG01);
      MemoryCursorRow_xnarapbo.this.CATEG02 = copyAndCast(p_row.CATEG02);
      MemoryCursorRow_xnarapbo.this.CATEG03 = copyAndCast(p_row.CATEG03);
      MemoryCursorRow_xnarapbo.this.CATEG04 = copyAndCast(p_row.CATEG04);
      MemoryCursorRow_xnarapbo.this.CATEG05 = copyAndCast(p_row.CATEG05);
      MemoryCursorRow_xnarapbo.this.CATEGORIA = copyAndCast(p_row.CATEGORIA);
      MemoryCursorRow_xnarapbo.this.CODDIPE = copyAndCast(p_row.CODDIPE);
      MemoryCursorRow_xnarapbo.this.DAC6 = copyAndCast(p_row.DAC6);
      MemoryCursorRow_xnarapbo.this.FLAGDAC6 = copyAndCast(p_row.FLAGDAC6);
      MemoryCursorRow_xnarapbo.this.IBAN = copyAndCast(p_row.IBAN);
      MemoryCursorRow_xnarapbo.this.CODOGG = copyAndCast(p_row.CODOGG);
      MemoryCursorRow_xnarapbo.this.RISGLOB = copyAndCast(p_row.RISGLOB);
      MemoryCursorRow_xnarapbo.this.DATAPROF = copyAndCast(p_row.DATAPROF);
      MemoryCursorRow_xnarapbo.this.DATAREVPROF = copyAndCast(p_row.DATAREVPROF);
      MemoryCursorRow_xnarapbo.this.NUMIMP = copyAndCast(p_row.NUMIMP);
      MemoryCursorRow_xnarapbo.this.ISOAGE = copyAndCast(p_row.ISOAGE);
      MemoryCursorRow_xnarapbo.this.NOCANC = copyAndCast(p_row.NOCANC);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"RAPPORTO","DESCRAP","TIPORAP","FLAGLIRE","VALUTA","CONTINUA","TIPOAG","DOCFILE","NOPROT","TIPMOD","DATAMOD","IDRAPPORTO","IDBASE","RAGIO","MODSVOL","AREAGEO","SCOPO","NATURA","RTIPO","RCOMP","RIMP","RFREQ","RRAGIO","RAREA","TIPO","PRGIMPRAP","AMMONT","DURAT","IMPAPE","IMPCHIU","SPLITCODE","MACODICE","CODDIP","STATORAP","CASTATOC","CASTATOM","CODICELR","CADSTATO","MITIG","MITGDOC","CATEG01","CATEG02","CATEG03","CATEG04","CATEG05","CATEGORIA","CODDIPE","DAC6","FLAGDAC6","IBAN","CODOGG","RISGLOB","DATAPROF","DATAREVPROF","NUMIMP","ISOAGE","NOCANC"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","N","C","D","C","C","C","C","C","C","C","N","N","N","N","N","N","C","N","C","C","N","N","C","C","C","C","N","N","C","D","N","C","C","C","C","C","C","C","C","C","N","C","C","C","D","D","T","C","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Rapporto","Descrizione","Tipo Rapporto","Divisa","Codice Divisa","","","","Non inviare agenzia entrate","tipo Modifica","Data Modifica","ID Rapporto","ID Base","","","","","","","","","","","","","Progressivo Import","","","Import Apertura Agenzia Entrate","Import Chiusura Agenzia Entrate","Customer ID (WUBS)","Codice Macro Agente","Dipendenza / Agenzia che crea il rapporto","Stato Rapporto (CGO)","Stato SnaiCARD","Motivo Stato","Legale Rappresentante","Data Cambio Stato","Mitigazione","Path Documentazione Mitigazione","Categoria 1","Categoria 2","Categoria 3","Categoria 4","Categoria 5","Categoria","Codice Dipendenza","","","","","Rischio Globale","Data Profilatura","Data Revisione Profilatura","Mark Importazione","Per tipo rapporto age 96/97","Non considerare per passaggio storico/cancellazione"};
    return l_names;
  }
}
