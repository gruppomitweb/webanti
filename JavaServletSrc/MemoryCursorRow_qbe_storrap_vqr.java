public class MemoryCursorRow_qbe_storrap_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_storrap_vqr() {
  }
  public MemoryCursorRow_qbe_storrap_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_storrap_vqr toBuild = new MemoryCursor_qbe_storrap_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_storrap_vqr toBuild = new MemoryCursor_qbe_storrap_vqr();
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
  String DAC6 = "";
  double FLAGDAC6 = 0;
  String IBAN = "";
  String CODOGG = "";
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
    return true;
  }
  void Copy(MemoryCursorRow_qbe_storrap_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_storrap_vqr.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_qbe_storrap_vqr.this.DESCRAP = copyAndCast(p_row.DESCRAP);
      MemoryCursorRow_qbe_storrap_vqr.this.TIPORAP = copyAndCast(p_row.TIPORAP);
      MemoryCursorRow_qbe_storrap_vqr.this.FLAGLIRE = copyAndCast(p_row.FLAGLIRE);
      MemoryCursorRow_qbe_storrap_vqr.this.VALUTA = copyAndCast(p_row.VALUTA);
      MemoryCursorRow_qbe_storrap_vqr.this.CONTINUA = copyAndCast(p_row.CONTINUA);
      MemoryCursorRow_qbe_storrap_vqr.this.TIPOAG = copyAndCast(p_row.TIPOAG);
      MemoryCursorRow_qbe_storrap_vqr.this.DOCFILE = copyAndCast(p_row.DOCFILE);
      MemoryCursorRow_qbe_storrap_vqr.this.NOPROT = copyAndCast(p_row.NOPROT);
      MemoryCursorRow_qbe_storrap_vqr.this.TIPMOD = copyAndCast(p_row.TIPMOD);
      MemoryCursorRow_qbe_storrap_vqr.this.DATAMOD = copyAndCast(p_row.DATAMOD);
      MemoryCursorRow_qbe_storrap_vqr.this.IDRAPPORTO = copyAndCast(p_row.IDRAPPORTO);
      MemoryCursorRow_qbe_storrap_vqr.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_qbe_storrap_vqr.this.RAGIO = copyAndCast(p_row.RAGIO);
      MemoryCursorRow_qbe_storrap_vqr.this.MODSVOL = copyAndCast(p_row.MODSVOL);
      MemoryCursorRow_qbe_storrap_vqr.this.AREAGEO = copyAndCast(p_row.AREAGEO);
      MemoryCursorRow_qbe_storrap_vqr.this.SCOPO = copyAndCast(p_row.SCOPO);
      MemoryCursorRow_qbe_storrap_vqr.this.NATURA = copyAndCast(p_row.NATURA);
      MemoryCursorRow_qbe_storrap_vqr.this.RTIPO = copyAndCast(p_row.RTIPO);
      MemoryCursorRow_qbe_storrap_vqr.this.RCOMP = copyAndCast(p_row.RCOMP);
      MemoryCursorRow_qbe_storrap_vqr.this.RIMP = copyAndCast(p_row.RIMP);
      MemoryCursorRow_qbe_storrap_vqr.this.RFREQ = copyAndCast(p_row.RFREQ);
      MemoryCursorRow_qbe_storrap_vqr.this.RRAGIO = copyAndCast(p_row.RRAGIO);
      MemoryCursorRow_qbe_storrap_vqr.this.RAREA = copyAndCast(p_row.RAREA);
      MemoryCursorRow_qbe_storrap_vqr.this.TIPO = copyAndCast(p_row.TIPO);
      MemoryCursorRow_qbe_storrap_vqr.this.PRGIMPRAP = copyAndCast(p_row.PRGIMPRAP);
      MemoryCursorRow_qbe_storrap_vqr.this.AMMONT = copyAndCast(p_row.AMMONT);
      MemoryCursorRow_qbe_storrap_vqr.this.DURAT = copyAndCast(p_row.DURAT);
      MemoryCursorRow_qbe_storrap_vqr.this.IMPAPE = copyAndCast(p_row.IMPAPE);
      MemoryCursorRow_qbe_storrap_vqr.this.IMPCHIU = copyAndCast(p_row.IMPCHIU);
      MemoryCursorRow_qbe_storrap_vqr.this.SPLITCODE = copyAndCast(p_row.SPLITCODE);
      MemoryCursorRow_qbe_storrap_vqr.this.MACODICE = copyAndCast(p_row.MACODICE);
      MemoryCursorRow_qbe_storrap_vqr.this.CODDIP = copyAndCast(p_row.CODDIP);
      MemoryCursorRow_qbe_storrap_vqr.this.STATORAP = copyAndCast(p_row.STATORAP);
      MemoryCursorRow_qbe_storrap_vqr.this.CASTATOC = copyAndCast(p_row.CASTATOC);
      MemoryCursorRow_qbe_storrap_vqr.this.CASTATOM = copyAndCast(p_row.CASTATOM);
      MemoryCursorRow_qbe_storrap_vqr.this.CODICELR = copyAndCast(p_row.CODICELR);
      MemoryCursorRow_qbe_storrap_vqr.this.CADSTATO = copyAndCast(p_row.CADSTATO);
      MemoryCursorRow_qbe_storrap_vqr.this.MITIG = copyAndCast(p_row.MITIG);
      MemoryCursorRow_qbe_storrap_vqr.this.MITGDOC = copyAndCast(p_row.MITGDOC);
      MemoryCursorRow_qbe_storrap_vqr.this.DAC6 = copyAndCast(p_row.DAC6);
      MemoryCursorRow_qbe_storrap_vqr.this.FLAGDAC6 = copyAndCast(p_row.FLAGDAC6);
      MemoryCursorRow_qbe_storrap_vqr.this.IBAN = copyAndCast(p_row.IBAN);
      MemoryCursorRow_qbe_storrap_vqr.this.CODOGG = copyAndCast(p_row.CODOGG);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"RAPPORTO","DESCRAP","TIPORAP","FLAGLIRE","VALUTA","CONTINUA","TIPOAG","DOCFILE","NOPROT","TIPMOD","DATAMOD","IDRAPPORTO","IDBASE","RAGIO","MODSVOL","AREAGEO","SCOPO","NATURA","RTIPO","RCOMP","RIMP","RFREQ","RRAGIO","RAREA","TIPO","PRGIMPRAP","AMMONT","DURAT","IMPAPE","IMPCHIU","SPLITCODE","MACODICE","CODDIP","STATORAP","CASTATOC","CASTATOM","CODICELR","CADSTATO","MITIG","MITGDOC","DAC6","FLAGDAC6","IBAN","CODOGG"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","N","C","D","C","C","C","C","C","C","C","N","N","N","N","N","N","C","N","C","C","N","N","C","C","C","C","N","N","C","D","N","C","C","N","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Rapporto","Descrizione","Tipo Rapporto","Divisa","Codice Divisa","","","","Non inviare agenzia entrate","tipo Modifica","Data Modifica","ID Rapporto","ID Base","","","","","","","","","","","","","Progressivo Import","","","Import Apertura Agenzia Entrate","Import Chiusura Agenzia Entrate","Customer ID (WUBS)","Codice Macro Agente","Dipendenza / Agenzia che crea il rapporto","Stato Rapporto (CGO)","Stato SnaiCARD","Motivo Stato","Legale Rappresentante","Data Cambio Stato","Mitigazione","Path Documentazione Mitigazione","","","",""};
    return l_names;
  }
}
