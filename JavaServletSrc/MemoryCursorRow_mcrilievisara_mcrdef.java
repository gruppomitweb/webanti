public class MemoryCursorRow_mcrilievisara_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcrilievisara_mcrdef() {
  }
  public MemoryCursorRow_mcrilievisara_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcrilievisara_mcrdef toBuild = new MemoryCursor_mcrilievisara_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcrilievisara_mcrdef toBuild = new MemoryCursor_mcrilievisara_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String ID = "";
  String MOTIVO = "";
  String TIPOLOGIA = "";
  String CAUSALE_AGGREGATA = "";
  String CAUSALE_AGGREGATA_ERR = "";
  String CODICE_INTERNO_DIP = "";
  String CODICE_INTERNO_DIP_ERR = "";
  String CODICE_SEGNALANTE = "";
  String CODICE_SEGNALANTE_ERR = "";
  String CODICE_VALUTA = "";
  String CODICE_VALUTA_ERR = "";
  String COMUNE_CONTROPARTE = "";
  String COMUNE_CONTROPARTE_ERR = "";
  String COMUNE_INTERM_CTRP = "";
  String COMUNE_INTERM_CTRP_ERR = "";
  String COMUNE_DIP = "";
  String COMUNE_DIP_ERR = "";
  String COMUNE_RES_CLIENTE = "";
  String COMUNE_RES_CLIENTE_ERR = "";
  java.sql.Date DATA_RIFERIMENTO = CPLib.NullDate();
  String DATA_RIFERIMENTO_ERR = "";
  String PAESE_CONTROPARTE = "";
  String PAESE_CONTROPARTE_ERR = "";
  String PAESE_INTERM_CTRP = "";
  String PAESE_INTERM_CTRP_ERR = "";
  String PAESE_RES_CLIENTE = "";
  String PAESE_RES_CLIENTE_ERR = "";
  String SEGNO_MONETARIO = "";
  String SEGNO_MONETARIO_ERR = "";
  String SETTORIZ_SINT_ECON = "";
  String SETTORIZ_SINT_ECON_ERR = "";
  String TIPO_SEGNALANTE = "";
  String TIPO_SEGNALANTE_ERR = "";
  double IMPORTO_TOT = 0;
  String IMPORTO_TOT_ERR = "";
  double IMPORTO_TOT_CONTANTI = 0;
  String IMPORTO_TOT_CONTANTI_ERR = "";
  double NUMERO_OPER_CONT = 0;
  String NUMERO_OPER_CONT_ERR = "";
  double NUMERO_TOT_OPER = 0;
  String NUMERO_TOT_OPER_ERR = "";
  String ABICAB_SPORTELLO = "";
  String ABICAB_SPORTELLO_ERR = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(ID))) {
      return false;
    }
    if ( ! (CPLib.Empty(MOTIVO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOLOGIA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAUSALE_AGGREGATA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAUSALE_AGGREGATA_ERR))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODICE_INTERNO_DIP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODICE_INTERNO_DIP_ERR))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODICE_SEGNALANTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODICE_SEGNALANTE_ERR))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODICE_VALUTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODICE_VALUTA_ERR))) {
      return false;
    }
    if ( ! (CPLib.Empty(COMUNE_CONTROPARTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(COMUNE_CONTROPARTE_ERR))) {
      return false;
    }
    if ( ! (CPLib.Empty(COMUNE_INTERM_CTRP))) {
      return false;
    }
    if ( ! (CPLib.Empty(COMUNE_INTERM_CTRP_ERR))) {
      return false;
    }
    if ( ! (CPLib.Empty(COMUNE_DIP))) {
      return false;
    }
    if ( ! (CPLib.Empty(COMUNE_DIP_ERR))) {
      return false;
    }
    if ( ! (CPLib.Empty(COMUNE_RES_CLIENTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(COMUNE_RES_CLIENTE_ERR))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATA_RIFERIMENTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATA_RIFERIMENTO_ERR))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESE_CONTROPARTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESE_CONTROPARTE_ERR))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESE_INTERM_CTRP))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESE_INTERM_CTRP_ERR))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESE_RES_CLIENTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESE_RES_CLIENTE_ERR))) {
      return false;
    }
    if ( ! (CPLib.Empty(SEGNO_MONETARIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(SEGNO_MONETARIO_ERR))) {
      return false;
    }
    if ( ! (CPLib.Empty(SETTORIZ_SINT_ECON))) {
      return false;
    }
    if ( ! (CPLib.Empty(SETTORIZ_SINT_ECON_ERR))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPO_SEGNALANTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPO_SEGNALANTE_ERR))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPORTO_TOT))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPORTO_TOT_ERR))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPORTO_TOT_CONTANTI))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPORTO_TOT_CONTANTI_ERR))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMERO_OPER_CONT))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMERO_OPER_CONT_ERR))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMERO_TOT_OPER))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMERO_TOT_OPER_ERR))) {
      return false;
    }
    if ( ! (CPLib.Empty(ABICAB_SPORTELLO))) {
      return false;
    }
    if ( ! (CPLib.Empty(ABICAB_SPORTELLO_ERR))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcrilievisara_mcrdef p_row) {
    MemoryCursorRow_mcrilievisara_mcrdef l_row = new MemoryCursorRow_mcrilievisara_mcrdef();
    CopyOperation<MemoryCursorRow_mcrilievisara_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcrilievisara_mcrdef.this.ID = l_row.ID;
      MemoryCursorRow_mcrilievisara_mcrdef.this.MOTIVO = l_row.MOTIVO;
      MemoryCursorRow_mcrilievisara_mcrdef.this.TIPOLOGIA = l_row.TIPOLOGIA;
      MemoryCursorRow_mcrilievisara_mcrdef.this.CAUSALE_AGGREGATA = l_row.CAUSALE_AGGREGATA;
      MemoryCursorRow_mcrilievisara_mcrdef.this.CAUSALE_AGGREGATA_ERR = l_row.CAUSALE_AGGREGATA_ERR;
      MemoryCursorRow_mcrilievisara_mcrdef.this.CODICE_INTERNO_DIP = l_row.CODICE_INTERNO_DIP;
      MemoryCursorRow_mcrilievisara_mcrdef.this.CODICE_INTERNO_DIP_ERR = l_row.CODICE_INTERNO_DIP_ERR;
      MemoryCursorRow_mcrilievisara_mcrdef.this.CODICE_SEGNALANTE = l_row.CODICE_SEGNALANTE;
      MemoryCursorRow_mcrilievisara_mcrdef.this.CODICE_SEGNALANTE_ERR = l_row.CODICE_SEGNALANTE_ERR;
      MemoryCursorRow_mcrilievisara_mcrdef.this.CODICE_VALUTA = l_row.CODICE_VALUTA;
      MemoryCursorRow_mcrilievisara_mcrdef.this.CODICE_VALUTA_ERR = l_row.CODICE_VALUTA_ERR;
      MemoryCursorRow_mcrilievisara_mcrdef.this.COMUNE_CONTROPARTE = l_row.COMUNE_CONTROPARTE;
      MemoryCursorRow_mcrilievisara_mcrdef.this.COMUNE_CONTROPARTE_ERR = l_row.COMUNE_CONTROPARTE_ERR;
      MemoryCursorRow_mcrilievisara_mcrdef.this.COMUNE_INTERM_CTRP = l_row.COMUNE_INTERM_CTRP;
      MemoryCursorRow_mcrilievisara_mcrdef.this.COMUNE_INTERM_CTRP_ERR = l_row.COMUNE_INTERM_CTRP_ERR;
      MemoryCursorRow_mcrilievisara_mcrdef.this.COMUNE_DIP = l_row.COMUNE_DIP;
      MemoryCursorRow_mcrilievisara_mcrdef.this.COMUNE_DIP_ERR = l_row.COMUNE_DIP_ERR;
      MemoryCursorRow_mcrilievisara_mcrdef.this.COMUNE_RES_CLIENTE = l_row.COMUNE_RES_CLIENTE;
      MemoryCursorRow_mcrilievisara_mcrdef.this.COMUNE_RES_CLIENTE_ERR = l_row.COMUNE_RES_CLIENTE_ERR;
      MemoryCursorRow_mcrilievisara_mcrdef.this.DATA_RIFERIMENTO = l_row.DATA_RIFERIMENTO;
      MemoryCursorRow_mcrilievisara_mcrdef.this.DATA_RIFERIMENTO_ERR = l_row.DATA_RIFERIMENTO_ERR;
      MemoryCursorRow_mcrilievisara_mcrdef.this.PAESE_CONTROPARTE = l_row.PAESE_CONTROPARTE;
      MemoryCursorRow_mcrilievisara_mcrdef.this.PAESE_CONTROPARTE_ERR = l_row.PAESE_CONTROPARTE_ERR;
      MemoryCursorRow_mcrilievisara_mcrdef.this.PAESE_INTERM_CTRP = l_row.PAESE_INTERM_CTRP;
      MemoryCursorRow_mcrilievisara_mcrdef.this.PAESE_INTERM_CTRP_ERR = l_row.PAESE_INTERM_CTRP_ERR;
      MemoryCursorRow_mcrilievisara_mcrdef.this.PAESE_RES_CLIENTE = l_row.PAESE_RES_CLIENTE;
      MemoryCursorRow_mcrilievisara_mcrdef.this.PAESE_RES_CLIENTE_ERR = l_row.PAESE_RES_CLIENTE_ERR;
      MemoryCursorRow_mcrilievisara_mcrdef.this.SEGNO_MONETARIO = l_row.SEGNO_MONETARIO;
      MemoryCursorRow_mcrilievisara_mcrdef.this.SEGNO_MONETARIO_ERR = l_row.SEGNO_MONETARIO_ERR;
      MemoryCursorRow_mcrilievisara_mcrdef.this.SETTORIZ_SINT_ECON = l_row.SETTORIZ_SINT_ECON;
      MemoryCursorRow_mcrilievisara_mcrdef.this.SETTORIZ_SINT_ECON_ERR = l_row.SETTORIZ_SINT_ECON_ERR;
      MemoryCursorRow_mcrilievisara_mcrdef.this.TIPO_SEGNALANTE = l_row.TIPO_SEGNALANTE;
      MemoryCursorRow_mcrilievisara_mcrdef.this.TIPO_SEGNALANTE_ERR = l_row.TIPO_SEGNALANTE_ERR;
      MemoryCursorRow_mcrilievisara_mcrdef.this.IMPORTO_TOT = l_row.IMPORTO_TOT;
      MemoryCursorRow_mcrilievisara_mcrdef.this.IMPORTO_TOT_ERR = l_row.IMPORTO_TOT_ERR;
      MemoryCursorRow_mcrilievisara_mcrdef.this.IMPORTO_TOT_CONTANTI = l_row.IMPORTO_TOT_CONTANTI;
      MemoryCursorRow_mcrilievisara_mcrdef.this.IMPORTO_TOT_CONTANTI_ERR = l_row.IMPORTO_TOT_CONTANTI_ERR;
      MemoryCursorRow_mcrilievisara_mcrdef.this.NUMERO_OPER_CONT = l_row.NUMERO_OPER_CONT;
      MemoryCursorRow_mcrilievisara_mcrdef.this.NUMERO_OPER_CONT_ERR = l_row.NUMERO_OPER_CONT_ERR;
      MemoryCursorRow_mcrilievisara_mcrdef.this.NUMERO_TOT_OPER = l_row.NUMERO_TOT_OPER;
      MemoryCursorRow_mcrilievisara_mcrdef.this.NUMERO_TOT_OPER_ERR = l_row.NUMERO_TOT_OPER_ERR;
      MemoryCursorRow_mcrilievisara_mcrdef.this.ABICAB_SPORTELLO = l_row.ABICAB_SPORTELLO;
      MemoryCursorRow_mcrilievisara_mcrdef.this.ABICAB_SPORTELLO_ERR = l_row.ABICAB_SPORTELLO_ERR;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcrilievisara_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcrilievisara_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcrilievisara_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcrilievisara_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcrilievisara_mcrdef p_From,MemoryCursorRow_mcrilievisara_mcrdef p_To) {
        p_To.ID = copyAndCast(p_From.ID);
        p_To.MOTIVO = copyAndCast(p_From.MOTIVO);
        p_To.TIPOLOGIA = copyAndCast(p_From.TIPOLOGIA);
        p_To.CAUSALE_AGGREGATA = copyAndCast(p_From.CAUSALE_AGGREGATA);
        p_To.CAUSALE_AGGREGATA_ERR = copyAndCast(p_From.CAUSALE_AGGREGATA_ERR);
        p_To.CODICE_INTERNO_DIP = copyAndCast(p_From.CODICE_INTERNO_DIP);
        p_To.CODICE_INTERNO_DIP_ERR = copyAndCast(p_From.CODICE_INTERNO_DIP_ERR);
        p_To.CODICE_SEGNALANTE = copyAndCast(p_From.CODICE_SEGNALANTE);
        p_To.CODICE_SEGNALANTE_ERR = copyAndCast(p_From.CODICE_SEGNALANTE_ERR);
        p_To.CODICE_VALUTA = copyAndCast(p_From.CODICE_VALUTA);
        p_To.CODICE_VALUTA_ERR = copyAndCast(p_From.CODICE_VALUTA_ERR);
        p_To.COMUNE_CONTROPARTE = copyAndCast(p_From.COMUNE_CONTROPARTE);
        p_To.COMUNE_CONTROPARTE_ERR = copyAndCast(p_From.COMUNE_CONTROPARTE_ERR);
        p_To.COMUNE_INTERM_CTRP = copyAndCast(p_From.COMUNE_INTERM_CTRP);
        p_To.COMUNE_INTERM_CTRP_ERR = copyAndCast(p_From.COMUNE_INTERM_CTRP_ERR);
        p_To.COMUNE_DIP = copyAndCast(p_From.COMUNE_DIP);
        p_To.COMUNE_DIP_ERR = copyAndCast(p_From.COMUNE_DIP_ERR);
        p_To.COMUNE_RES_CLIENTE = copyAndCast(p_From.COMUNE_RES_CLIENTE);
        p_To.COMUNE_RES_CLIENTE_ERR = copyAndCast(p_From.COMUNE_RES_CLIENTE_ERR);
        p_To.DATA_RIFERIMENTO = copyAndCast(p_From.DATA_RIFERIMENTO);
        p_To.DATA_RIFERIMENTO_ERR = copyAndCast(p_From.DATA_RIFERIMENTO_ERR);
        p_To.PAESE_CONTROPARTE = copyAndCast(p_From.PAESE_CONTROPARTE);
        p_To.PAESE_CONTROPARTE_ERR = copyAndCast(p_From.PAESE_CONTROPARTE_ERR);
        p_To.PAESE_INTERM_CTRP = copyAndCast(p_From.PAESE_INTERM_CTRP);
        p_To.PAESE_INTERM_CTRP_ERR = copyAndCast(p_From.PAESE_INTERM_CTRP_ERR);
        p_To.PAESE_RES_CLIENTE = copyAndCast(p_From.PAESE_RES_CLIENTE);
        p_To.PAESE_RES_CLIENTE_ERR = copyAndCast(p_From.PAESE_RES_CLIENTE_ERR);
        p_To.SEGNO_MONETARIO = copyAndCast(p_From.SEGNO_MONETARIO);
        p_To.SEGNO_MONETARIO_ERR = copyAndCast(p_From.SEGNO_MONETARIO_ERR);
        p_To.SETTORIZ_SINT_ECON = copyAndCast(p_From.SETTORIZ_SINT_ECON);
        p_To.SETTORIZ_SINT_ECON_ERR = copyAndCast(p_From.SETTORIZ_SINT_ECON_ERR);
        p_To.TIPO_SEGNALANTE = copyAndCast(p_From.TIPO_SEGNALANTE);
        p_To.TIPO_SEGNALANTE_ERR = copyAndCast(p_From.TIPO_SEGNALANTE_ERR);
        p_To.IMPORTO_TOT = copyAndCast(p_From.IMPORTO_TOT);
        p_To.IMPORTO_TOT_ERR = copyAndCast(p_From.IMPORTO_TOT_ERR);
        p_To.IMPORTO_TOT_CONTANTI = copyAndCast(p_From.IMPORTO_TOT_CONTANTI);
        p_To.IMPORTO_TOT_CONTANTI_ERR = copyAndCast(p_From.IMPORTO_TOT_CONTANTI_ERR);
        p_To.NUMERO_OPER_CONT = copyAndCast(p_From.NUMERO_OPER_CONT);
        p_To.NUMERO_OPER_CONT_ERR = copyAndCast(p_From.NUMERO_OPER_CONT_ERR);
        p_To.NUMERO_TOT_OPER = copyAndCast(p_From.NUMERO_TOT_OPER);
        p_To.NUMERO_TOT_OPER_ERR = copyAndCast(p_From.NUMERO_TOT_OPER_ERR);
        p_To.ABICAB_SPORTELLO = copyAndCast(p_From.ABICAB_SPORTELLO);
        p_To.ABICAB_SPORTELLO_ERR = copyAndCast(p_From.ABICAB_SPORTELLO_ERR);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"ID","MOTIVO","TIPOLOGIA","CAUSALE_AGGREGATA","CAUSALE_AGGREGATA_ERR","CODICE_INTERNO_DIP","CODICE_INTERNO_DIP_ERR","CODICE_SEGNALANTE","CODICE_SEGNALANTE_ERR","CODICE_VALUTA","CODICE_VALUTA_ERR","COMUNE_CONTROPARTE","COMUNE_CONTROPARTE_ERR","COMUNE_INTERM_CTRP","COMUNE_INTERM_CTRP_ERR","COMUNE_DIP","COMUNE_DIP_ERR","COMUNE_RES_CLIENTE","COMUNE_RES_CLIENTE_ERR","DATA_RIFERIMENTO","DATA_RIFERIMENTO_ERR","PAESE_CONTROPARTE","PAESE_CONTROPARTE_ERR","PAESE_INTERM_CTRP","PAESE_INTERM_CTRP_ERR","PAESE_RES_CLIENTE","PAESE_RES_CLIENTE_ERR","SEGNO_MONETARIO","SEGNO_MONETARIO_ERR","SETTORIZ_SINT_ECON","SETTORIZ_SINT_ECON_ERR","TIPO_SEGNALANTE","TIPO_SEGNALANTE_ERR","IMPORTO_TOT","IMPORTO_TOT_ERR","IMPORTO_TOT_CONTANTI","IMPORTO_TOT_CONTANTI_ERR","NUMERO_OPER_CONT","NUMERO_OPER_CONT_ERR","NUMERO_TOT_OPER","NUMERO_TOT_OPER_ERR","ABICAB_SPORTELLO","ABICAB_SPORTELLO_ERR"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","D","C","C","C","C","C","C","C","C","C","C","C","C","C","N","C","N","C","N","C","N","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"ID Rilievo","Motivazione","Tipologia","Causale Aggregata","Errore Causale Aggregata","Codice Interno Dipendenza","Errore Codice Interno Dipendenza","Codice Segnalante","Errore Codice Segnalate","Codice Valuta","Errore Codice Valuta","Comune Controparte","Errore Comune Controparte","Comune Intermediario Controparte","Errore Comune Intermediario Controparte","Comune Dipendenza","Errore Comune Dipendenza","Comune Residenza Cliente","Errore Comune Residenza Cliente","Data di Riferimento","Errore Data di Riferimento","Paese Controparte","Errore Paese Controparte","Paese Intermediario Controparte ","Errore Paese Intermediario Controparte","Paese Residenza Cliente","Errore Paese Residenza Cliente","Segno Monetario","Errore Segno Monetario","Settorizzazione Sintetica","Errore Settorizzazione Sintetica","Tipo Segnalante","Errore Tipo Segnalante","Importo Totale","Errore Importo Totale","Importo Contanti","Errore Importo Contanti","Numero Operazioni Contanti","Errore Numero Operazioni Contanti","Numero Totale Operazioni","Errore Numero Totale Operazioni","ABI-CAB Dipendenza","Ertrore ABI-CAB Dipendenza"};
    return l_names;
  }
}
