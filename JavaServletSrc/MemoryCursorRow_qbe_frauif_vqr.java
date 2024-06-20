public class MemoryCursorRow_qbe_frauif_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_frauif_vqr() {
  }
  public MemoryCursorRow_qbe_frauif_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_frauif_vqr toBuild = new MemoryCursor_qbe_frauif_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_frauif_vqr toBuild = new MemoryCursor_qbe_frauif_vqr();
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
  String DESCCIT = "";
  String CODDIPE = "";
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
  String C_CAB = "";
  String C_STA = "";
  String RIFIMP = "";
  double PROQUOTA = 0;
  double IMPSARA = 0;
  String CONNES = "";
  String RAGSOC = "";
  String CODFISC = "";
  String PAESECLI = "";
  String CABCLI = "";
  String DESCCITCLI = "";
  String SETTSINT = "";
  String SOTGRUP = "";
  String SESSO = "";
  String NOSARA = "";
  String CABDIP = "";
  String ABICABSARA = "";
  String CODDIP = "";
  String DESCRIZ = "";
  String DESCCITD = "";
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
    if ( ! (CPLib.Empty(DESCCIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODDIPE))) {
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
    if ( ! (CPLib.Empty(C_CAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(C_STA))) {
      return false;
    }
    if ( ! (CPLib.Empty(RIFIMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROQUOTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPSARA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNES))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGSOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODFISC))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESECLI))) {
      return false;
    }
    if ( ! (CPLib.Empty(CABCLI))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCCITCLI))) {
      return false;
    }
    if ( ! (CPLib.Empty(SETTSINT))) {
      return false;
    }
    if ( ! (CPLib.Empty(SOTGRUP))) {
      return false;
    }
    if ( ! (CPLib.Empty(SESSO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOSARA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CABDIP))) {
      return false;
    }
    if ( ! (CPLib.Empty(ABICABSARA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODDIP))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRIZ))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCCITD))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_qbe_frauif_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_frauif_vqr.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_qbe_frauif_vqr.this.NUMPROG = copyAndCast(p_row.NUMPROG);
      MemoryCursorRow_qbe_frauif_vqr.this.DATAOPE = copyAndCast(p_row.DATAOPE);
      MemoryCursorRow_qbe_frauif_vqr.this.TIPOINTER = copyAndCast(p_row.TIPOINTER);
      MemoryCursorRow_qbe_frauif_vqr.this.CODINTER = copyAndCast(p_row.CODINTER);
      MemoryCursorRow_qbe_frauif_vqr.this.TIPOINF = copyAndCast(p_row.TIPOINF);
      MemoryCursorRow_qbe_frauif_vqr.this.IDEREG = copyAndCast(p_row.IDEREG);
      MemoryCursorRow_qbe_frauif_vqr.this.DESCCIT = copyAndCast(p_row.DESCCIT);
      MemoryCursorRow_qbe_frauif_vqr.this.CODDIPE = copyAndCast(p_row.CODDIPE);
      MemoryCursorRow_qbe_frauif_vqr.this.PROVINCIA = copyAndCast(p_row.PROVINCIA);
      MemoryCursorRow_qbe_frauif_vqr.this.CODCAB = copyAndCast(p_row.CODCAB);
      MemoryCursorRow_qbe_frauif_vqr.this.FLAGFRAZ = copyAndCast(p_row.FLAGFRAZ);
      MemoryCursorRow_qbe_frauif_vqr.this.FLAGCONT = copyAndCast(p_row.FLAGCONT);
      MemoryCursorRow_qbe_frauif_vqr.this.CODANA = copyAndCast(p_row.CODANA);
      MemoryCursorRow_qbe_frauif_vqr.this.CODVOC = copyAndCast(p_row.CODVOC);
      MemoryCursorRow_qbe_frauif_vqr.this.TIPOINT2 = copyAndCast(p_row.TIPOINT2);
      MemoryCursorRow_qbe_frauif_vqr.this.CODINT2 = copyAndCast(p_row.CODINT2);
      MemoryCursorRow_qbe_frauif_vqr.this.PAESE = copyAndCast(p_row.PAESE);
      MemoryCursorRow_qbe_frauif_vqr.this.DESC2 = copyAndCast(p_row.DESC2);
      MemoryCursorRow_qbe_frauif_vqr.this.PROV2 = copyAndCast(p_row.PROV2);
      MemoryCursorRow_qbe_frauif_vqr.this.CODCAB2 = copyAndCast(p_row.CODCAB2);
      MemoryCursorRow_qbe_frauif_vqr.this.DESCINTER = copyAndCast(p_row.DESCINTER);
      MemoryCursorRow_qbe_frauif_vqr.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_qbe_frauif_vqr.this.FLAGRAP = copyAndCast(p_row.FLAGRAP);
      MemoryCursorRow_qbe_frauif_vqr.this.TIPOLEG = copyAndCast(p_row.TIPOLEG);
      MemoryCursorRow_qbe_frauif_vqr.this.DATAREG = copyAndCast(p_row.DATAREG);
      MemoryCursorRow_qbe_frauif_vqr.this.OPRAP = copyAndCast(p_row.OPRAP);
      MemoryCursorRow_qbe_frauif_vqr.this.TIPOOPRAP = copyAndCast(p_row.TIPOOPRAP);
      MemoryCursorRow_qbe_frauif_vqr.this.FLAGLIRE = copyAndCast(p_row.FLAGLIRE);
      MemoryCursorRow_qbe_frauif_vqr.this.VALUTA = copyAndCast(p_row.VALUTA);
      MemoryCursorRow_qbe_frauif_vqr.this.SEGNO = copyAndCast(p_row.SEGNO);
      MemoryCursorRow_qbe_frauif_vqr.this.TOTLIRE = copyAndCast(p_row.TOTLIRE);
      MemoryCursorRow_qbe_frauif_vqr.this.TOTCONT = copyAndCast(p_row.TOTCONT);
      MemoryCursorRow_qbe_frauif_vqr.this.STATOREG = copyAndCast(p_row.STATOREG);
      MemoryCursorRow_qbe_frauif_vqr.this.OPERAZMOD = copyAndCast(p_row.OPERAZMOD);
      MemoryCursorRow_qbe_frauif_vqr.this.DATARETT = copyAndCast(p_row.DATARETT);
      MemoryCursorRow_qbe_frauif_vqr.this.CONNESCLI = copyAndCast(p_row.CONNESCLI);
      MemoryCursorRow_qbe_frauif_vqr.this.CONNESOPER = copyAndCast(p_row.CONNESOPER);
      MemoryCursorRow_qbe_frauif_vqr.this.CONNESBEN = copyAndCast(p_row.CONNESBEN);
      MemoryCursorRow_qbe_frauif_vqr.this.COLLEG = copyAndCast(p_row.COLLEG);
      MemoryCursorRow_qbe_frauif_vqr.this.CAMBIO = copyAndCast(p_row.CAMBIO);
      MemoryCursorRow_qbe_frauif_vqr.this.RAPPORTBEN = copyAndCast(p_row.RAPPORTBEN);
      MemoryCursorRow_qbe_frauif_vqr.this.FLAGRAP2 = copyAndCast(p_row.FLAGRAP2);
      MemoryCursorRow_qbe_frauif_vqr.this.OPERATORE = copyAndCast(p_row.OPERATORE);
      MemoryCursorRow_qbe_frauif_vqr.this.AUTOM = copyAndCast(p_row.AUTOM);
      MemoryCursorRow_qbe_frauif_vqr.this.idcauana = copyAndCast(p_row.idcauana);
      MemoryCursorRow_qbe_frauif_vqr.this.OPERAG = copyAndCast(p_row.OPERAG);
      MemoryCursorRow_qbe_frauif_vqr.this.DOCFILE = copyAndCast(p_row.DOCFILE);
      MemoryCursorRow_qbe_frauif_vqr.this.RESPINS = copyAndCast(p_row.RESPINS);
      MemoryCursorRow_qbe_frauif_vqr.this.INFORM = copyAndCast(p_row.INFORM);
      MemoryCursorRow_qbe_frauif_vqr.this.CDATOPE = copyAndCast(p_row.CDATOPE);
      MemoryCursorRow_qbe_frauif_vqr.this.NOPROT = copyAndCast(p_row.NOPROT);
      MemoryCursorRow_qbe_frauif_vqr.this.UCODE = copyAndCast(p_row.UCODE);
      MemoryCursorRow_qbe_frauif_vqr.this.CDATAOPE = copyAndCast(p_row.CDATAOPE);
      MemoryCursorRow_qbe_frauif_vqr.this.ZCPARTE = copyAndCast(p_row.ZCPARTE);
      MemoryCursorRow_qbe_frauif_vqr.this.RAGIO = copyAndCast(p_row.RAGIO);
      MemoryCursorRow_qbe_frauif_vqr.this.MODSVOL = copyAndCast(p_row.MODSVOL);
      MemoryCursorRow_qbe_frauif_vqr.this.AREAGEO = copyAndCast(p_row.AREAGEO);
      MemoryCursorRow_qbe_frauif_vqr.this.C_CAB = copyAndCast(p_row.C_CAB);
      MemoryCursorRow_qbe_frauif_vqr.this.C_STA = copyAndCast(p_row.C_STA);
      MemoryCursorRow_qbe_frauif_vqr.this.RIFIMP = copyAndCast(p_row.RIFIMP);
      MemoryCursorRow_qbe_frauif_vqr.this.PROQUOTA = copyAndCast(p_row.PROQUOTA);
      MemoryCursorRow_qbe_frauif_vqr.this.IMPSARA = copyAndCast(p_row.IMPSARA);
      MemoryCursorRow_qbe_frauif_vqr.this.CONNES = copyAndCast(p_row.CONNES);
      MemoryCursorRow_qbe_frauif_vqr.this.RAGSOC = copyAndCast(p_row.RAGSOC);
      MemoryCursorRow_qbe_frauif_vqr.this.CODFISC = copyAndCast(p_row.CODFISC);
      MemoryCursorRow_qbe_frauif_vqr.this.PAESECLI = copyAndCast(p_row.PAESECLI);
      MemoryCursorRow_qbe_frauif_vqr.this.CABCLI = copyAndCast(p_row.CABCLI);
      MemoryCursorRow_qbe_frauif_vqr.this.DESCCITCLI = copyAndCast(p_row.DESCCITCLI);
      MemoryCursorRow_qbe_frauif_vqr.this.SETTSINT = copyAndCast(p_row.SETTSINT);
      MemoryCursorRow_qbe_frauif_vqr.this.SOTGRUP = copyAndCast(p_row.SOTGRUP);
      MemoryCursorRow_qbe_frauif_vqr.this.SESSO = copyAndCast(p_row.SESSO);
      MemoryCursorRow_qbe_frauif_vqr.this.NOSARA = copyAndCast(p_row.NOSARA);
      MemoryCursorRow_qbe_frauif_vqr.this.CABDIP = copyAndCast(p_row.CABDIP);
      MemoryCursorRow_qbe_frauif_vqr.this.ABICABSARA = copyAndCast(p_row.ABICABSARA);
      MemoryCursorRow_qbe_frauif_vqr.this.CODDIP = copyAndCast(p_row.CODDIP);
      MemoryCursorRow_qbe_frauif_vqr.this.DESCRIZ = copyAndCast(p_row.DESCRIZ);
      MemoryCursorRow_qbe_frauif_vqr.this.DESCCITD = copyAndCast(p_row.DESCCITD);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"IDBASE","NUMPROG","DATAOPE","TIPOINTER","CODINTER","TIPOINF","IDEREG","DESCCIT","CODDIPE","PROVINCIA","CODCAB","FLAGFRAZ","FLAGCONT","CODANA","CODVOC","TIPOINT2","CODINT2","PAESE","DESC2","PROV2","CODCAB2","DESCINTER","RAPPORTO","FLAGRAP","TIPOLEG","DATAREG","OPRAP","TIPOOPRAP","FLAGLIRE","VALUTA","SEGNO","TOTLIRE","TOTCONT","STATOREG","OPERAZMOD","DATARETT","CONNESCLI","CONNESOPER","CONNESBEN","COLLEG","CAMBIO","RAPPORTBEN","FLAGRAP2","OPERATORE","AUTOM","idcauana","OPERAG","DOCFILE","RESPINS","INFORM","CDATOPE","NOPROT","UCODE","CDATAOPE","ZCPARTE","RAGIO","MODSVOL","AREAGEO","C_CAB","C_STA","RIFIMP","PROQUOTA","IMPSARA","CONNES","RAGSOC","CODFISC","PAESECLI","CABCLI","DESCCITCLI","SETTSINT","SOTGRUP","SESSO","NOSARA","CABDIP","ABICABSARA","CODDIP","DESCRIZ","DESCCITD"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","D","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","D","C","C","C","C","C","N","N","C","C","D","C","C","C","C","N","C","C","C","C","C","C","C","C","C","C","N","C","C","C","C","C","C","C","C","C","N","N","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Idbase","Numero Progressivo","Data Operazione","Tipo Intermediaro","Codice Intermediario","Tipo Informazione","ID Registrazione","Città Dipendenza","Codice Dipendenza","Provincia Dipendenza","CAB Dipendenza","Frazionata (S/N)","Contanti (S/N)","Causale Analitica","Causale Sintetica","Tipo Intermediario C/Parte","Codice Intermediario C/Parte","Stato Intermediario C/Parte","Denominazione Intermediario C/Parte","Provincia Intermediario C/Parte","CAB Intermediario C/Parte","","Rapporto Collegato","Tipo Rapporto Collegato","Tipo Legame sogg. Operante","Data registrazione","Tipo operazione","Tipo Operazione Completa","Lire Euro Valuta","Divisa","Segno","Totale Operazione","di cui contanti","Stato registrazione","Operazione Modificata","Data Rettifica","Codice Cliente Occasionale","Soggetto Operante Conto Terzi","Beneficiario","Collegamento Operazione Multiple","Cambio","Rapporto Beneficiario","Tipo Rapporto Beneficiario","Operatore","Importazione da file esterno","ID BASE Causale Analitica","","","","","Data Operazione in Carattere","","","","","Ragionevolezza","Modalità Svolgimento","Area Geografica","CAB Comune ControParte","Stato Controparte","Riferimento Import","Pro Quota","Importo Sara","Codice Collegamento","Ragione Sociale","Codice Fiscale","Stato","CAB","Città","Settorizzazione UIC","Sottogruppo Att. Ec.","Sesso","Escludi operazioni soggetto da SARA","CAB Dipendenza","ABI CAB Dipendenza per SARA","Codice Dipendenza","Descrizione Dipendenza","Città Dipendenza"};
    return l_names;
  }
}
