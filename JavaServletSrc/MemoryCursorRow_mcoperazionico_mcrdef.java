public class MemoryCursorRow_mcoperazionico_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcoperazionico_mcrdef() {
  }
  public MemoryCursorRow_mcoperazionico_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcoperazionico_mcrdef toBuild = new MemoryCursor_mcoperazionico_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcoperazionico_mcrdef toBuild = new MemoryCursor_mcoperazionico_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  double CONTAOPE = 0;
  String CODICE_SEGNALANTE = "";
  String DATA_CONTABILE = "";
  double ID_OPERAZIONE = 0;
  String DATA_CONT_OPERAZ = "";
  String TIPO_OPERAZIONE = "";
  String SEGNO_OPERAZ = "";
  String COD_VALUTA = "";
  double IMPORTO_OPERAZ = 0;
  double IMPORTO_CONT = 0;
  String CODICE_FILIALE = "";
  String UL_BANCARIA_CAB = "";
  String COMUNE_ESEC = "";
  String CAT_RAPPORTO = "";
  String NUMERO_RAPPORTO = "";
  String FILIALE = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CONTAOPE))) {
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
    if ( ! (CPLib.Empty(DATA_CONT_OPERAZ))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPO_OPERAZIONE))) {
      return false;
    }
    if ( ! (CPLib.Empty(SEGNO_OPERAZ))) {
      return false;
    }
    if ( ! (CPLib.Empty(COD_VALUTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPORTO_OPERAZ))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPORTO_CONT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODICE_FILIALE))) {
      return false;
    }
    if ( ! (CPLib.Empty(UL_BANCARIA_CAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(COMUNE_ESEC))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAT_RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMERO_RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FILIALE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcoperazionico_mcrdef p_row) {
    MemoryCursorRow_mcoperazionico_mcrdef l_row = new MemoryCursorRow_mcoperazionico_mcrdef();
    CopyOperation<MemoryCursorRow_mcoperazionico_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcoperazionico_mcrdef.this.CONTAOPE = l_row.CONTAOPE;
      MemoryCursorRow_mcoperazionico_mcrdef.this.CODICE_SEGNALANTE = l_row.CODICE_SEGNALANTE;
      MemoryCursorRow_mcoperazionico_mcrdef.this.DATA_CONTABILE = l_row.DATA_CONTABILE;
      MemoryCursorRow_mcoperazionico_mcrdef.this.ID_OPERAZIONE = l_row.ID_OPERAZIONE;
      MemoryCursorRow_mcoperazionico_mcrdef.this.DATA_CONT_OPERAZ = l_row.DATA_CONT_OPERAZ;
      MemoryCursorRow_mcoperazionico_mcrdef.this.TIPO_OPERAZIONE = l_row.TIPO_OPERAZIONE;
      MemoryCursorRow_mcoperazionico_mcrdef.this.SEGNO_OPERAZ = l_row.SEGNO_OPERAZ;
      MemoryCursorRow_mcoperazionico_mcrdef.this.COD_VALUTA = l_row.COD_VALUTA;
      MemoryCursorRow_mcoperazionico_mcrdef.this.IMPORTO_OPERAZ = l_row.IMPORTO_OPERAZ;
      MemoryCursorRow_mcoperazionico_mcrdef.this.IMPORTO_CONT = l_row.IMPORTO_CONT;
      MemoryCursorRow_mcoperazionico_mcrdef.this.CODICE_FILIALE = l_row.CODICE_FILIALE;
      MemoryCursorRow_mcoperazionico_mcrdef.this.UL_BANCARIA_CAB = l_row.UL_BANCARIA_CAB;
      MemoryCursorRow_mcoperazionico_mcrdef.this.COMUNE_ESEC = l_row.COMUNE_ESEC;
      MemoryCursorRow_mcoperazionico_mcrdef.this.CAT_RAPPORTO = l_row.CAT_RAPPORTO;
      MemoryCursorRow_mcoperazionico_mcrdef.this.NUMERO_RAPPORTO = l_row.NUMERO_RAPPORTO;
      MemoryCursorRow_mcoperazionico_mcrdef.this.FILIALE = l_row.FILIALE;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcoperazionico_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcoperazionico_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcoperazionico_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcoperazionico_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcoperazionico_mcrdef p_From,MemoryCursorRow_mcoperazionico_mcrdef p_To) {
        p_To.CONTAOPE = copyAndCast(p_From.CONTAOPE);
        p_To.CODICE_SEGNALANTE = copyAndCast(p_From.CODICE_SEGNALANTE);
        p_To.DATA_CONTABILE = copyAndCast(p_From.DATA_CONTABILE);
        p_To.ID_OPERAZIONE = copyAndCast(p_From.ID_OPERAZIONE);
        p_To.DATA_CONT_OPERAZ = copyAndCast(p_From.DATA_CONT_OPERAZ);
        p_To.TIPO_OPERAZIONE = copyAndCast(p_From.TIPO_OPERAZIONE);
        p_To.SEGNO_OPERAZ = copyAndCast(p_From.SEGNO_OPERAZ);
        p_To.COD_VALUTA = copyAndCast(p_From.COD_VALUTA);
        p_To.IMPORTO_OPERAZ = copyAndCast(p_From.IMPORTO_OPERAZ);
        p_To.IMPORTO_CONT = copyAndCast(p_From.IMPORTO_CONT);
        p_To.CODICE_FILIALE = copyAndCast(p_From.CODICE_FILIALE);
        p_To.UL_BANCARIA_CAB = copyAndCast(p_From.UL_BANCARIA_CAB);
        p_To.COMUNE_ESEC = copyAndCast(p_From.COMUNE_ESEC);
        p_To.CAT_RAPPORTO = copyAndCast(p_From.CAT_RAPPORTO);
        p_To.NUMERO_RAPPORTO = copyAndCast(p_From.NUMERO_RAPPORTO);
        p_To.FILIALE = copyAndCast(p_From.FILIALE);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CONTAOPE","CODICE_SEGNALANTE","DATA_CONTABILE","ID_OPERAZIONE","DATA_CONT_OPERAZ","TIPO_OPERAZIONE","SEGNO_OPERAZ","COD_VALUTA","IMPORTO_OPERAZ","IMPORTO_CONT","CODICE_FILIALE","UL_BANCARIA_CAB","COMUNE_ESEC","CAT_RAPPORTO","NUMERO_RAPPORTO","FILIALE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"N","C","C","N","C","C","C","C","N","N","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"COntatore Operazioni","Codice Segnalatore","Data Fine Periodo","ID Operazione","Data Operazione","Causale Analitica","Segno","Codice Valuta","Importo Totale Operazione","Importo in contanti","Codice Dipendenza","ABI CAB Dipendenza","CAB Dipendendza","Categoria Rapporto","NUmero Rapporto","ABICAB Filiale"};
    return l_names;
  }
}
