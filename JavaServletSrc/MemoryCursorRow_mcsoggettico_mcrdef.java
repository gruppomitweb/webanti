public class MemoryCursorRow_mcsoggettico_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcsoggettico_mcrdef() {
  }
  public MemoryCursorRow_mcsoggettico_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcsoggettico_mcrdef toBuild = new MemoryCursor_mcsoggettico_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcsoggettico_mcrdef toBuild = new MemoryCursor_mcsoggettico_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  double CONTASOGG = 0;
  String CODICE_SEGNALANTE = "";
  String DATA_CONTABILE = "";
  double ID_OPERAZIONE = 0;
  double PROG_SOGGETTO = 0;
  String CODICE_TIPO_SOGGETTO = "";
  String NATURA_GIURIDICA = "";
  String CODICE_FISCALE = "";
  String SGRP_ATTIVITA_EC = "";
  String CODICE_ATECO = "";
  String NPF_DENOMINAZIONE = "";
  String NPF_SEDELEG_IND_COMUNE = "";
  String NPF_SEDELEG_IND_STATO = "";
  String PF_NOME = "";
  String PF_COGNOME = "";
  String PF_SESSO = "";
  String PF_DATANASCITA = "";
  String PF_STATONASCITA = "";
  String PF_COMUNENASCITA = "";
  String PF_IND_COMUNE = "";
  String PF_IND_STATO = "";
  String PF_POLITIC_ESPOSTA = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CONTASOGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODICE_SEGNALANTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATA_CONTABILE))) {
      return false;
    }
    if ( ! (CPLib.Empty(ID_OPERAZIONE))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROG_SOGGETTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODICE_TIPO_SOGGETTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NATURA_GIURIDICA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODICE_FISCALE))) {
      return false;
    }
    if ( ! (CPLib.Empty(SGRP_ATTIVITA_EC))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODICE_ATECO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NPF_DENOMINAZIONE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NPF_SEDELEG_IND_COMUNE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NPF_SEDELEG_IND_STATO))) {
      return false;
    }
    if ( ! (CPLib.Empty(PF_NOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(PF_COGNOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(PF_SESSO))) {
      return false;
    }
    if ( ! (CPLib.Empty(PF_DATANASCITA))) {
      return false;
    }
    if ( ! (CPLib.Empty(PF_STATONASCITA))) {
      return false;
    }
    if ( ! (CPLib.Empty(PF_COMUNENASCITA))) {
      return false;
    }
    if ( ! (CPLib.Empty(PF_IND_COMUNE))) {
      return false;
    }
    if ( ! (CPLib.Empty(PF_IND_STATO))) {
      return false;
    }
    if ( ! (CPLib.Empty(PF_POLITIC_ESPOSTA))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcsoggettico_mcrdef p_row) {
    MemoryCursorRow_mcsoggettico_mcrdef l_row = new MemoryCursorRow_mcsoggettico_mcrdef();
    CopyOperation<MemoryCursorRow_mcsoggettico_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcsoggettico_mcrdef.this.CONTASOGG = l_row.CONTASOGG;
      MemoryCursorRow_mcsoggettico_mcrdef.this.CODICE_SEGNALANTE = l_row.CODICE_SEGNALANTE;
      MemoryCursorRow_mcsoggettico_mcrdef.this.DATA_CONTABILE = l_row.DATA_CONTABILE;
      MemoryCursorRow_mcsoggettico_mcrdef.this.ID_OPERAZIONE = l_row.ID_OPERAZIONE;
      MemoryCursorRow_mcsoggettico_mcrdef.this.PROG_SOGGETTO = l_row.PROG_SOGGETTO;
      MemoryCursorRow_mcsoggettico_mcrdef.this.CODICE_TIPO_SOGGETTO = l_row.CODICE_TIPO_SOGGETTO;
      MemoryCursorRow_mcsoggettico_mcrdef.this.NATURA_GIURIDICA = l_row.NATURA_GIURIDICA;
      MemoryCursorRow_mcsoggettico_mcrdef.this.CODICE_FISCALE = l_row.CODICE_FISCALE;
      MemoryCursorRow_mcsoggettico_mcrdef.this.SGRP_ATTIVITA_EC = l_row.SGRP_ATTIVITA_EC;
      MemoryCursorRow_mcsoggettico_mcrdef.this.CODICE_ATECO = l_row.CODICE_ATECO;
      MemoryCursorRow_mcsoggettico_mcrdef.this.NPF_DENOMINAZIONE = l_row.NPF_DENOMINAZIONE;
      MemoryCursorRow_mcsoggettico_mcrdef.this.NPF_SEDELEG_IND_COMUNE = l_row.NPF_SEDELEG_IND_COMUNE;
      MemoryCursorRow_mcsoggettico_mcrdef.this.NPF_SEDELEG_IND_STATO = l_row.NPF_SEDELEG_IND_STATO;
      MemoryCursorRow_mcsoggettico_mcrdef.this.PF_NOME = l_row.PF_NOME;
      MemoryCursorRow_mcsoggettico_mcrdef.this.PF_COGNOME = l_row.PF_COGNOME;
      MemoryCursorRow_mcsoggettico_mcrdef.this.PF_SESSO = l_row.PF_SESSO;
      MemoryCursorRow_mcsoggettico_mcrdef.this.PF_DATANASCITA = l_row.PF_DATANASCITA;
      MemoryCursorRow_mcsoggettico_mcrdef.this.PF_STATONASCITA = l_row.PF_STATONASCITA;
      MemoryCursorRow_mcsoggettico_mcrdef.this.PF_COMUNENASCITA = l_row.PF_COMUNENASCITA;
      MemoryCursorRow_mcsoggettico_mcrdef.this.PF_IND_COMUNE = l_row.PF_IND_COMUNE;
      MemoryCursorRow_mcsoggettico_mcrdef.this.PF_IND_STATO = l_row.PF_IND_STATO;
      MemoryCursorRow_mcsoggettico_mcrdef.this.PF_POLITIC_ESPOSTA = l_row.PF_POLITIC_ESPOSTA;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcsoggettico_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcsoggettico_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcsoggettico_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcsoggettico_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcsoggettico_mcrdef p_From,MemoryCursorRow_mcsoggettico_mcrdef p_To) {
        p_To.CONTASOGG = copyAndCast(p_From.CONTASOGG);
        p_To.CODICE_SEGNALANTE = copyAndCast(p_From.CODICE_SEGNALANTE);
        p_To.DATA_CONTABILE = copyAndCast(p_From.DATA_CONTABILE);
        p_To.ID_OPERAZIONE = copyAndCast(p_From.ID_OPERAZIONE);
        p_To.PROG_SOGGETTO = copyAndCast(p_From.PROG_SOGGETTO);
        p_To.CODICE_TIPO_SOGGETTO = copyAndCast(p_From.CODICE_TIPO_SOGGETTO);
        p_To.NATURA_GIURIDICA = copyAndCast(p_From.NATURA_GIURIDICA);
        p_To.CODICE_FISCALE = copyAndCast(p_From.CODICE_FISCALE);
        p_To.SGRP_ATTIVITA_EC = copyAndCast(p_From.SGRP_ATTIVITA_EC);
        p_To.CODICE_ATECO = copyAndCast(p_From.CODICE_ATECO);
        p_To.NPF_DENOMINAZIONE = copyAndCast(p_From.NPF_DENOMINAZIONE);
        p_To.NPF_SEDELEG_IND_COMUNE = copyAndCast(p_From.NPF_SEDELEG_IND_COMUNE);
        p_To.NPF_SEDELEG_IND_STATO = copyAndCast(p_From.NPF_SEDELEG_IND_STATO);
        p_To.PF_NOME = copyAndCast(p_From.PF_NOME);
        p_To.PF_COGNOME = copyAndCast(p_From.PF_COGNOME);
        p_To.PF_SESSO = copyAndCast(p_From.PF_SESSO);
        p_To.PF_DATANASCITA = copyAndCast(p_From.PF_DATANASCITA);
        p_To.PF_STATONASCITA = copyAndCast(p_From.PF_STATONASCITA);
        p_To.PF_COMUNENASCITA = copyAndCast(p_From.PF_COMUNENASCITA);
        p_To.PF_IND_COMUNE = copyAndCast(p_From.PF_IND_COMUNE);
        p_To.PF_IND_STATO = copyAndCast(p_From.PF_IND_STATO);
        p_To.PF_POLITIC_ESPOSTA = copyAndCast(p_From.PF_POLITIC_ESPOSTA);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CONTASOGG","CODICE_SEGNALANTE","DATA_CONTABILE","ID_OPERAZIONE","PROG_SOGGETTO","CODICE_TIPO_SOGGETTO","NATURA_GIURIDICA","CODICE_FISCALE","SGRP_ATTIVITA_EC","CODICE_ATECO","NPF_DENOMINAZIONE","NPF_SEDELEG_IND_COMUNE","NPF_SEDELEG_IND_STATO","PF_NOME","PF_COGNOME","PF_SESSO","PF_DATANASCITA","PF_STATONASCITA","PF_COMUNENASCITA","PF_IND_COMUNE","PF_IND_STATO","PF_POLITIC_ESPOSTA"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"N","C","C","N","N","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Contatore Soggetti","Codice Segnalante","Data Fine Periodo","ID Operazione\n","Progressivo Soggetto","Codice Tipo Soggetto","Persona fisica o giuridica","Codice FISCALE","SAE","ATECO","Ragione Sociale\n","CAB Sede Legale","Stato Sede Legale","Nome","Cognome","Sesso","Data di Nascita","Stato di Nascita","Comune di Nascita","CAB Comune Residenza","Stato Residenza","PEP"};
    return l_names;
  }
}
