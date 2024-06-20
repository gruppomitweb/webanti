public class MemoryCursorRow_personbo_agg extends CPMemoryCursorRow {
  public MemoryCursorRow_personbo_agg() {
  }
  public MemoryCursorRow_personbo_agg(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_personbo_agg toBuild = new MemoryCursor_personbo_agg(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_personbo_agg toBuild = new MemoryCursor_personbo_agg();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CONNES = "";
  String EMAIL = "";
  String FLGEMAIL = "";
  String TELEFONO = "";
  String RDCODAUT = "";
  String RDLOCAUT = "";
  String FLGBANCA = "";
  String FLGVALIDO = "";
  String REGRES = "";
  String FLGBL = "";
  double CLOCCUPA = 0;
  String NUMTEL = "";
  String NAZIONE = "";
  String LASTOPER = "";
  String CODCLIEST = "";
  String FLGANAVAL = "";
  String CLPRVDOM = "";
  double MITIG = 0;
  String MITGDOC = "";
  String CATEG01 = "";
  String CATEG02 = "";
  String CATEG03 = "";
  String CATEG04 = "";
  String CATEG05 = "";
  String CATEGORIA = "";
  String FLGPREGIUD = "";
  String FLGTRUST = "";
  String FLGRISCHIO = "";
  String FLGEQUIFIN = "";
  String FLGFALSADIC = "";
  String FLGRICINF = "";
  String WUGID = "";
  String WUNAZRILDOC = "";
  String WUCOGNOME = "";
  String WUNOME = "";
  String WULUONAS = "";
  String NUMCEL = "";
  String PEC = "";
  String REFERENTE = "";
  double CFOK = 0;
  double CONALTO = 0;
  double APPALTO = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CONNES))) {
      return false;
    }
    if ( ! (CPLib.Empty(EMAIL))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGEMAIL))) {
      return false;
    }
    if ( ! (CPLib.Empty(TELEFONO))) {
      return false;
    }
    if ( ! (CPLib.Empty(RDCODAUT))) {
      return false;
    }
    if ( ! (CPLib.Empty(RDLOCAUT))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGBANCA))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGVALIDO))) {
      return false;
    }
    if ( ! (CPLib.Empty(REGRES))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGBL))) {
      return false;
    }
    if ( ! (CPLib.Empty(CLOCCUPA))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMTEL))) {
      return false;
    }
    if ( ! (CPLib.Empty(NAZIONE))) {
      return false;
    }
    if ( ! (CPLib.Empty(LASTOPER))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCLIEST))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGANAVAL))) {
      return false;
    }
    if ( ! (CPLib.Empty(CLPRVDOM))) {
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
    if ( ! (CPLib.Empty(FLGPREGIUD))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGTRUST))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGRISCHIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGEQUIFIN))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGFALSADIC))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGRICINF))) {
      return false;
    }
    if ( ! (CPLib.Empty(WUGID))) {
      return false;
    }
    if ( ! (CPLib.Empty(WUNAZRILDOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(WUCOGNOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(WUNOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(WULUONAS))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMCEL))) {
      return false;
    }
    if ( ! (CPLib.Empty(PEC))) {
      return false;
    }
    if ( ! (CPLib.Empty(REFERENTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CFOK))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONALTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(APPALTO))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_personbo_agg p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_personbo_agg.this.CONNES = copyAndCast(p_row.CONNES);
      MemoryCursorRow_personbo_agg.this.EMAIL = copyAndCast(p_row.EMAIL);
      MemoryCursorRow_personbo_agg.this.FLGEMAIL = copyAndCast(p_row.FLGEMAIL);
      MemoryCursorRow_personbo_agg.this.TELEFONO = copyAndCast(p_row.TELEFONO);
      MemoryCursorRow_personbo_agg.this.RDCODAUT = copyAndCast(p_row.RDCODAUT);
      MemoryCursorRow_personbo_agg.this.RDLOCAUT = copyAndCast(p_row.RDLOCAUT);
      MemoryCursorRow_personbo_agg.this.FLGBANCA = copyAndCast(p_row.FLGBANCA);
      MemoryCursorRow_personbo_agg.this.FLGVALIDO = copyAndCast(p_row.FLGVALIDO);
      MemoryCursorRow_personbo_agg.this.REGRES = copyAndCast(p_row.REGRES);
      MemoryCursorRow_personbo_agg.this.FLGBL = copyAndCast(p_row.FLGBL);
      MemoryCursorRow_personbo_agg.this.CLOCCUPA = copyAndCast(p_row.CLOCCUPA);
      MemoryCursorRow_personbo_agg.this.NUMTEL = copyAndCast(p_row.NUMTEL);
      MemoryCursorRow_personbo_agg.this.NAZIONE = copyAndCast(p_row.NAZIONE);
      MemoryCursorRow_personbo_agg.this.LASTOPER = copyAndCast(p_row.LASTOPER);
      MemoryCursorRow_personbo_agg.this.CODCLIEST = copyAndCast(p_row.CODCLIEST);
      MemoryCursorRow_personbo_agg.this.FLGANAVAL = copyAndCast(p_row.FLGANAVAL);
      MemoryCursorRow_personbo_agg.this.CLPRVDOM = copyAndCast(p_row.CLPRVDOM);
      MemoryCursorRow_personbo_agg.this.MITIG = copyAndCast(p_row.MITIG);
      MemoryCursorRow_personbo_agg.this.MITGDOC = copyAndCast(p_row.MITGDOC);
      MemoryCursorRow_personbo_agg.this.CATEG01 = copyAndCast(p_row.CATEG01);
      MemoryCursorRow_personbo_agg.this.CATEG02 = copyAndCast(p_row.CATEG02);
      MemoryCursorRow_personbo_agg.this.CATEG03 = copyAndCast(p_row.CATEG03);
      MemoryCursorRow_personbo_agg.this.CATEG04 = copyAndCast(p_row.CATEG04);
      MemoryCursorRow_personbo_agg.this.CATEG05 = copyAndCast(p_row.CATEG05);
      MemoryCursorRow_personbo_agg.this.CATEGORIA = copyAndCast(p_row.CATEGORIA);
      MemoryCursorRow_personbo_agg.this.FLGPREGIUD = copyAndCast(p_row.FLGPREGIUD);
      MemoryCursorRow_personbo_agg.this.FLGTRUST = copyAndCast(p_row.FLGTRUST);
      MemoryCursorRow_personbo_agg.this.FLGRISCHIO = copyAndCast(p_row.FLGRISCHIO);
      MemoryCursorRow_personbo_agg.this.FLGEQUIFIN = copyAndCast(p_row.FLGEQUIFIN);
      MemoryCursorRow_personbo_agg.this.FLGFALSADIC = copyAndCast(p_row.FLGFALSADIC);
      MemoryCursorRow_personbo_agg.this.FLGRICINF = copyAndCast(p_row.FLGRICINF);
      MemoryCursorRow_personbo_agg.this.WUGID = copyAndCast(p_row.WUGID);
      MemoryCursorRow_personbo_agg.this.WUNAZRILDOC = copyAndCast(p_row.WUNAZRILDOC);
      MemoryCursorRow_personbo_agg.this.WUCOGNOME = copyAndCast(p_row.WUCOGNOME);
      MemoryCursorRow_personbo_agg.this.WUNOME = copyAndCast(p_row.WUNOME);
      MemoryCursorRow_personbo_agg.this.WULUONAS = copyAndCast(p_row.WULUONAS);
      MemoryCursorRow_personbo_agg.this.NUMCEL = copyAndCast(p_row.NUMCEL);
      MemoryCursorRow_personbo_agg.this.PEC = copyAndCast(p_row.PEC);
      MemoryCursorRow_personbo_agg.this.REFERENTE = copyAndCast(p_row.REFERENTE);
      MemoryCursorRow_personbo_agg.this.CFOK = copyAndCast(p_row.CFOK);
      MemoryCursorRow_personbo_agg.this.CONALTO = copyAndCast(p_row.CONALTO);
      MemoryCursorRow_personbo_agg.this.APPALTO = copyAndCast(p_row.APPALTO);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CONNES","EMAIL","FLGEMAIL","TELEFONO","RDCODAUT","RDLOCAUT","FLGBANCA","FLGVALIDO","REGRES","FLGBL","CLOCCUPA","NUMTEL","NAZIONE","LASTOPER","CODCLIEST","FLGANAVAL","CLPRVDOM","MITIG","MITGDOC","CATEG01","CATEG02","CATEG03","CATEG04","CATEG05","CATEGORIA","FLGPREGIUD","FLGTRUST","FLGRISCHIO","FLGEQUIFIN","FLGFALSADIC","FLGRICINF","WUGID","WUNAZRILDOC","WUCOGNOME","WUNOME","WULUONAS","NUMCEL","PEC","REFERENTE","CFOK","CONALTO","APPALTO"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","M","C","C","C","C","C","C","C","C","N","C","C","C","C","C","C","N","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","N","N","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Cliente","EMAIL","Flag EMAIL","Telefono","Codice Autorità Rilascio","Località Autorità Rilascio","Dati Aggiornati da Banca (WU)","Codice Fiscale Validato","Regione Residenza","BlackList","Codice Occupazione","Numero Telefono","Nazionalità","Ultima Operazione Insertita","Codice Cliente Originale","Dati Anagrafici Validati","Provincia Domicilio","Mitigazione","Path Documentazione Mitigazione","Categoria 1","Categoria 2","Categoria 3","Categoria 4","Categoria 5","Categoria","Pregiudizievole","Trust","Cliente con attività in paesi a rischio","Equilibrio Finanziario","Falsa dichiarazione","Richiamo di Informativa","GID Soggetto","Nazione Rilascio Documento","Cognome RTRA","Nome RTRA","Luogo Nascita WU","Numero Cellulare","PEC","Referente","No messaggi su codice fiscale","Connesso con attività a rischio","Prevalente attività in appalti pubblici"};
    return l_names;
  }
}
