public class MemoryCursorRow_anadip extends CPMemoryCursorRow {
  public MemoryCursorRow_anadip() {
  }
  public MemoryCursorRow_anadip(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_anadip toBuild = new MemoryCursor_anadip(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_anadip toBuild = new MemoryCursor_anadip();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODDIP = "";
  String DESCRIZ = "";
  String IDCITTA = "";
  String DESCCIT = "";
  String PROVINCIA = "";
  String CAB = "";
  String IDBASE = "";
  String AGENTE = "";
  String MACROAGENTE = "";
  String TERMINALID = "";
  String DOMICILIO = "";
  String TELEFONO = "";
  String CODLOC = "";
  String ABICABSARA = "";
  String NUOVO = "";
  String CAP = "";
  String AGACCODE = "";
  String NAZAGENTE = "";
  double OPXSOSCLI = 0;
  double OPXSOSAGE = 0;
  String VALCOMPL = "";
  String ANOMOPER = "";
  String AGEREGIO = "";
  String FLGATT = "";
  String CODAGE = "";
  String TIPOSV = "";
  String FLGNOAUA = "";
  String FLGWUPOS = "";
  String CATEG01 = "";
  String CATEG02 = "";
  String CATEG03 = "";
  String CATEG04 = "";
  String CATEG05 = "";
  String CATEGORIA = "";
  String CAB2 = "";
  String RISGLOB = "";
  java.sql.Date DATAPROF = CPLib.NullDate();
  String CODICEAAMS = "";
  String CONCESSIONE = "";
  String CODFISC = "";
  String PARTIVA = "";
  String TIPOAGENTE = "";
  String NUMCIVICO = "";
  java.sql.Date DATAINI = CPLib.NullDate();
  java.sql.Date DATAFINE = CPLib.NullDate();
  String SERRIMDEN = "";
  double FLGCOMPL = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODDIP))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRIZ))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDCITTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCCIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVINCIA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(AGENTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(MACROAGENTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TERMINALID))) {
      return false;
    }
    if ( ! (CPLib.Empty(DOMICILIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TELEFONO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODLOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(ABICABSARA))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUOVO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(AGACCODE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NAZAGENTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(OPXSOSCLI))) {
      return false;
    }
    if ( ! (CPLib.Empty(OPXSOSAGE))) {
      return false;
    }
    if ( ! (CPLib.Empty(VALCOMPL))) {
      return false;
    }
    if ( ! (CPLib.Empty(ANOMOPER))) {
      return false;
    }
    if ( ! (CPLib.Empty(AGEREGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGATT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODAGE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOSV))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGNOAUA))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGWUPOS))) {
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
    if ( ! (CPLib.Empty(CAB2))) {
      return false;
    }
    if ( ! (CPLib.Empty(RISGLOB))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAPROF))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODICEAAMS))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONCESSIONE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODFISC))) {
      return false;
    }
    if ( ! (CPLib.Empty(PARTIVA))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOAGENTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMCIVICO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAINI))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAFINE))) {
      return false;
    }
    if ( ! (CPLib.Empty(SERRIMDEN))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGCOMPL))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_anadip p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_anadip.this.CODDIP = copyAndCast(p_row.CODDIP);
      MemoryCursorRow_anadip.this.DESCRIZ = copyAndCast(p_row.DESCRIZ);
      MemoryCursorRow_anadip.this.IDCITTA = copyAndCast(p_row.IDCITTA);
      MemoryCursorRow_anadip.this.DESCCIT = copyAndCast(p_row.DESCCIT);
      MemoryCursorRow_anadip.this.PROVINCIA = copyAndCast(p_row.PROVINCIA);
      MemoryCursorRow_anadip.this.CAB = copyAndCast(p_row.CAB);
      MemoryCursorRow_anadip.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_anadip.this.AGENTE = copyAndCast(p_row.AGENTE);
      MemoryCursorRow_anadip.this.MACROAGENTE = copyAndCast(p_row.MACROAGENTE);
      MemoryCursorRow_anadip.this.TERMINALID = copyAndCast(p_row.TERMINALID);
      MemoryCursorRow_anadip.this.DOMICILIO = copyAndCast(p_row.DOMICILIO);
      MemoryCursorRow_anadip.this.TELEFONO = copyAndCast(p_row.TELEFONO);
      MemoryCursorRow_anadip.this.CODLOC = copyAndCast(p_row.CODLOC);
      MemoryCursorRow_anadip.this.ABICABSARA = copyAndCast(p_row.ABICABSARA);
      MemoryCursorRow_anadip.this.NUOVO = copyAndCast(p_row.NUOVO);
      MemoryCursorRow_anadip.this.CAP = copyAndCast(p_row.CAP);
      MemoryCursorRow_anadip.this.AGACCODE = copyAndCast(p_row.AGACCODE);
      MemoryCursorRow_anadip.this.NAZAGENTE = copyAndCast(p_row.NAZAGENTE);
      MemoryCursorRow_anadip.this.OPXSOSCLI = copyAndCast(p_row.OPXSOSCLI);
      MemoryCursorRow_anadip.this.OPXSOSAGE = copyAndCast(p_row.OPXSOSAGE);
      MemoryCursorRow_anadip.this.VALCOMPL = copyAndCast(p_row.VALCOMPL);
      MemoryCursorRow_anadip.this.ANOMOPER = copyAndCast(p_row.ANOMOPER);
      MemoryCursorRow_anadip.this.AGEREGIO = copyAndCast(p_row.AGEREGIO);
      MemoryCursorRow_anadip.this.FLGATT = copyAndCast(p_row.FLGATT);
      MemoryCursorRow_anadip.this.CODAGE = copyAndCast(p_row.CODAGE);
      MemoryCursorRow_anadip.this.TIPOSV = copyAndCast(p_row.TIPOSV);
      MemoryCursorRow_anadip.this.FLGNOAUA = copyAndCast(p_row.FLGNOAUA);
      MemoryCursorRow_anadip.this.FLGWUPOS = copyAndCast(p_row.FLGWUPOS);
      MemoryCursorRow_anadip.this.CATEG01 = copyAndCast(p_row.CATEG01);
      MemoryCursorRow_anadip.this.CATEG02 = copyAndCast(p_row.CATEG02);
      MemoryCursorRow_anadip.this.CATEG03 = copyAndCast(p_row.CATEG03);
      MemoryCursorRow_anadip.this.CATEG04 = copyAndCast(p_row.CATEG04);
      MemoryCursorRow_anadip.this.CATEG05 = copyAndCast(p_row.CATEG05);
      MemoryCursorRow_anadip.this.CATEGORIA = copyAndCast(p_row.CATEGORIA);
      MemoryCursorRow_anadip.this.CAB2 = copyAndCast(p_row.CAB2);
      MemoryCursorRow_anadip.this.RISGLOB = copyAndCast(p_row.RISGLOB);
      MemoryCursorRow_anadip.this.DATAPROF = copyAndCast(p_row.DATAPROF);
      MemoryCursorRow_anadip.this.CODICEAAMS = copyAndCast(p_row.CODICEAAMS);
      MemoryCursorRow_anadip.this.CONCESSIONE = copyAndCast(p_row.CONCESSIONE);
      MemoryCursorRow_anadip.this.CODFISC = copyAndCast(p_row.CODFISC);
      MemoryCursorRow_anadip.this.PARTIVA = copyAndCast(p_row.PARTIVA);
      MemoryCursorRow_anadip.this.TIPOAGENTE = copyAndCast(p_row.TIPOAGENTE);
      MemoryCursorRow_anadip.this.NUMCIVICO = copyAndCast(p_row.NUMCIVICO);
      MemoryCursorRow_anadip.this.DATAINI = copyAndCast(p_row.DATAINI);
      MemoryCursorRow_anadip.this.DATAFINE = copyAndCast(p_row.DATAFINE);
      MemoryCursorRow_anadip.this.SERRIMDEN = copyAndCast(p_row.SERRIMDEN);
      MemoryCursorRow_anadip.this.FLGCOMPL = copyAndCast(p_row.FLGCOMPL);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODDIP","DESCRIZ","IDCITTA","DESCCIT","PROVINCIA","CAB","IDBASE","AGENTE","MACROAGENTE","TERMINALID","DOMICILIO","TELEFONO","CODLOC","ABICABSARA","NUOVO","CAP","AGACCODE","NAZAGENTE","OPXSOSCLI","OPXSOSAGE","VALCOMPL","ANOMOPER","AGEREGIO","FLGATT","CODAGE","TIPOSV","FLGNOAUA","FLGWUPOS","CATEG01","CATEG02","CATEG03","CATEG04","CATEG05","CATEGORIA","CAB2","RISGLOB","DATAPROF","CODICEAAMS","CONCESSIONE","CODFISC","PARTIVA","TIPOAGENTE","NUMCIVICO","DATAINI","DATAFINE","SERRIMDEN","FLGCOMPL"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","N","N","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","D","C","C","C","C","C","C","D","D","C","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Dipendenza","Descrizione","Codice Città","Città","Provincia","CAB","","Agente","Denominazione MacroAgente","ID Terrminale","Indirizzo","Telefono","Codice Locale (CGO)","ABI CAB Dipendenza per SARA","Nuovo","CAP","Codice Dipendenza","Nazionalità Agente","Operazioni Sospette Cliente","Operazioni Sospette Agente","Valutazione Visita Compliance","Anomalie Operative Riscontrate","Regione Agente","Agenzia Attiva (S/N)","Codice AGENTE","Canale Distributivo (SV)","Escludi Controlli AUA","Flag WUPOS Attivo","Categoria 1","Categoria 2","Categoria 3","Categoria 4","Categoria 5","Categoria","CAB","Rischio globale","Data Profilatura","Codice AAMS Sala","Concessione","Codice Fiscale","Partita IVA","Tipo Agente (PF/PG)","Numero Civico","Data Inizio","Data Fine","Servizi Rimessa Denaro (S/N)","Chiusura per compliance"};
    return l_names;
  }
}
