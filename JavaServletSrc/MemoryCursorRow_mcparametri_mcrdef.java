public class MemoryCursorRow_mcparametri_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcparametri_mcrdef() {
  }
  public MemoryCursorRow_mcparametri_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcparametri_mcrdef toBuild = new MemoryCursor_mcparametri_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcparametri_mcrdef toBuild = new MemoryCursor_mcparametri_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String pTipo = "";
  java.sql.Date w_dadata = CPLib.NullDate();
  java.sql.Date w_adata = CPLib.NullDate();
  String w_cdadata = "";
  String w_c_adata = "";
  String w_cDIP = "";
  String w_xdesdip = "";
  String w_ragosc = "";
  String w_citnas = "";
  String w_stanas = "";
  java.sql.Date w_datnas = CPLib.NullDate();
  String w_cMTCN = "";
  String w_cCODFISC = "";
  String w_ragben = "";
  String w_staben = "";
  String w_codmag = "";
  String w_connes = "";
  String w_nomefile = "";
  String w_tipofile = "";
  String w_flgsto = "";
  String w_tipoout = "";
  String w_opesel = "";
  String w_frzsel = "";
  String w_attive = "";
  String w_destfold = "";
  String w_flgmese = "";
  String w_flgncf = "";
  String w_flgsegno = "";
  String w_lststa = "";
  String w_lstprv = "";
  double w_importo = 0;
  String w_storico = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(pTipo))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_dadata))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_adata))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_cdadata))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_c_adata))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_cDIP))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_xdesdip))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_ragosc))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_citnas))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_stanas))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_datnas))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_cMTCN))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_cCODFISC))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_ragben))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_staben))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_codmag))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_connes))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_nomefile))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_tipofile))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_flgsto))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_tipoout))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_opesel))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_frzsel))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_attive))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_destfold))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_flgmese))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_flgncf))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_flgsegno))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_lststa))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_lstprv))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_importo))) {
      return false;
    }
    if ( ! (CPLib.Empty(w_storico))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcparametri_mcrdef p_row) {
    MemoryCursorRow_mcparametri_mcrdef l_row = new MemoryCursorRow_mcparametri_mcrdef();
    CopyOperation<MemoryCursorRow_mcparametri_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcparametri_mcrdef.this.pTipo = l_row.pTipo;
      MemoryCursorRow_mcparametri_mcrdef.this.w_dadata = l_row.w_dadata;
      MemoryCursorRow_mcparametri_mcrdef.this.w_adata = l_row.w_adata;
      MemoryCursorRow_mcparametri_mcrdef.this.w_cdadata = l_row.w_cdadata;
      MemoryCursorRow_mcparametri_mcrdef.this.w_c_adata = l_row.w_c_adata;
      MemoryCursorRow_mcparametri_mcrdef.this.w_cDIP = l_row.w_cDIP;
      MemoryCursorRow_mcparametri_mcrdef.this.w_xdesdip = l_row.w_xdesdip;
      MemoryCursorRow_mcparametri_mcrdef.this.w_ragosc = l_row.w_ragosc;
      MemoryCursorRow_mcparametri_mcrdef.this.w_citnas = l_row.w_citnas;
      MemoryCursorRow_mcparametri_mcrdef.this.w_stanas = l_row.w_stanas;
      MemoryCursorRow_mcparametri_mcrdef.this.w_datnas = l_row.w_datnas;
      MemoryCursorRow_mcparametri_mcrdef.this.w_cMTCN = l_row.w_cMTCN;
      MemoryCursorRow_mcparametri_mcrdef.this.w_cCODFISC = l_row.w_cCODFISC;
      MemoryCursorRow_mcparametri_mcrdef.this.w_ragben = l_row.w_ragben;
      MemoryCursorRow_mcparametri_mcrdef.this.w_staben = l_row.w_staben;
      MemoryCursorRow_mcparametri_mcrdef.this.w_codmag = l_row.w_codmag;
      MemoryCursorRow_mcparametri_mcrdef.this.w_connes = l_row.w_connes;
      MemoryCursorRow_mcparametri_mcrdef.this.w_nomefile = l_row.w_nomefile;
      MemoryCursorRow_mcparametri_mcrdef.this.w_tipofile = l_row.w_tipofile;
      MemoryCursorRow_mcparametri_mcrdef.this.w_flgsto = l_row.w_flgsto;
      MemoryCursorRow_mcparametri_mcrdef.this.w_tipoout = l_row.w_tipoout;
      MemoryCursorRow_mcparametri_mcrdef.this.w_opesel = l_row.w_opesel;
      MemoryCursorRow_mcparametri_mcrdef.this.w_frzsel = l_row.w_frzsel;
      MemoryCursorRow_mcparametri_mcrdef.this.w_attive = l_row.w_attive;
      MemoryCursorRow_mcparametri_mcrdef.this.w_destfold = l_row.w_destfold;
      MemoryCursorRow_mcparametri_mcrdef.this.w_flgmese = l_row.w_flgmese;
      MemoryCursorRow_mcparametri_mcrdef.this.w_flgncf = l_row.w_flgncf;
      MemoryCursorRow_mcparametri_mcrdef.this.w_flgsegno = l_row.w_flgsegno;
      MemoryCursorRow_mcparametri_mcrdef.this.w_lststa = l_row.w_lststa;
      MemoryCursorRow_mcparametri_mcrdef.this.w_lstprv = l_row.w_lstprv;
      MemoryCursorRow_mcparametri_mcrdef.this.w_importo = l_row.w_importo;
      MemoryCursorRow_mcparametri_mcrdef.this.w_storico = l_row.w_storico;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcparametri_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcparametri_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcparametri_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcparametri_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcparametri_mcrdef p_From,MemoryCursorRow_mcparametri_mcrdef p_To) {
        p_To.pTipo = copyAndCast(p_From.pTipo);
        p_To.w_dadata = copyAndCast(p_From.w_dadata);
        p_To.w_adata = copyAndCast(p_From.w_adata);
        p_To.w_cdadata = copyAndCast(p_From.w_cdadata);
        p_To.w_c_adata = copyAndCast(p_From.w_c_adata);
        p_To.w_cDIP = copyAndCast(p_From.w_cDIP);
        p_To.w_xdesdip = copyAndCast(p_From.w_xdesdip);
        p_To.w_ragosc = copyAndCast(p_From.w_ragosc);
        p_To.w_citnas = copyAndCast(p_From.w_citnas);
        p_To.w_stanas = copyAndCast(p_From.w_stanas);
        p_To.w_datnas = copyAndCast(p_From.w_datnas);
        p_To.w_cMTCN = copyAndCast(p_From.w_cMTCN);
        p_To.w_cCODFISC = copyAndCast(p_From.w_cCODFISC);
        p_To.w_ragben = copyAndCast(p_From.w_ragben);
        p_To.w_staben = copyAndCast(p_From.w_staben);
        p_To.w_codmag = copyAndCast(p_From.w_codmag);
        p_To.w_connes = copyAndCast(p_From.w_connes);
        p_To.w_nomefile = copyAndCast(p_From.w_nomefile);
        p_To.w_tipofile = copyAndCast(p_From.w_tipofile);
        p_To.w_flgsto = copyAndCast(p_From.w_flgsto);
        p_To.w_tipoout = copyAndCast(p_From.w_tipoout);
        p_To.w_opesel = copyAndCast(p_From.w_opesel);
        p_To.w_frzsel = copyAndCast(p_From.w_frzsel);
        p_To.w_attive = copyAndCast(p_From.w_attive);
        p_To.w_destfold = copyAndCast(p_From.w_destfold);
        p_To.w_flgmese = copyAndCast(p_From.w_flgmese);
        p_To.w_flgncf = copyAndCast(p_From.w_flgncf);
        p_To.w_flgsegno = copyAndCast(p_From.w_flgsegno);
        p_To.w_lststa = copyAndCast(p_From.w_lststa);
        p_To.w_lstprv = copyAndCast(p_From.w_lstprv);
        p_To.w_importo = copyAndCast(p_From.w_importo);
        p_To.w_storico = copyAndCast(p_From.w_storico);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"pTipo","w_dadata","w_adata","w_cdadata","w_c_adata","w_cDIP","w_xdesdip","w_ragosc","w_citnas","w_stanas","w_datnas","w_cMTCN","w_cCODFISC","w_ragben","w_staben","w_codmag","w_connes","w_nomefile","w_tipofile","w_flgsto","w_tipoout","w_opesel","w_frzsel","w_attive","w_destfold","w_flgmese","w_flgncf","w_flgsegno","w_lststa","w_lstprv","w_importo","w_storico"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","D","D","C","C","C","C","C","C","C","D","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","N","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Tipo Elaborazione","Data Inizio Periodo","Data Fine Periodo","Data Inizio Periodo Char","Data Fine Periodo Char","Agenzia","Descrizione Agenzia","Ragione Sociale","Città di nascita","Stato di Nascita","Data di nascita","MTCN","Codice Fiscale","Ragione Sociale Controparte","Stato Beneficiario","MacroAgente","NDG Cliente","Nome File Origine","Tipo Contenuto File","Dati storici soggetto","Tipo Output","Operazioni","Frazionate","Solo operazioni attive","Cartella Destinazione","Suddivisione in un mese","No c.f. fittizi","Segno operazione","Stati Selezionati","Lista provincie","Importo >=","Storico per data registrazione/data operazione"};
    return l_names;
  }
}
