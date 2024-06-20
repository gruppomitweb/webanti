public class MemoryCursorRow_mcflusso_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcflusso_mcrdef() {
  }
  public MemoryCursorRow_mcflusso_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcflusso_mcrdef toBuild = new MemoryCursor_mcflusso_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcflusso_mcrdef toBuild = new MemoryCursor_mcflusso_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CodiceIstituto = "";
  String DataElaborazione = "";
  String ProceduraOrigine = "";
  String NumeroElettronicoOperante = "";
  String SottoNumeroOperazione = "";
  String TipoRegistrazione = "";
  String DataOperazione = "";
  String FilialeOperante = "";
  String CodiceOperatore = "";
  String TerminaleOperante = "";
  String Transazione = "";
  String OperazioneCassa = "";
  String CausaleInterna = "";
  String CodiceCausale = "";
  String FlagContanti = "";
  double ImportoTotale = 0;
  double ImportoContante = 0;
  String Segno = "";
  String CodiceDivisa = "";
  String NumeroRapporto = "";
  String TipoRapportoAUI = "";
  String FormaTecnica = "";
  String TipoRapportoIntermediario = "";
  String CABSportello = "";
  String Note = "";
  String FlagSaggio = "";
  String FlagPostRep = "";
  String FILLER1 = "";
  String Ragionevolezza = "";
  String Tipologia = "";
  String Motivazione = "";
  String NaturaScopo = "";
  String TipoVerifica = "";
  String ObbTitolareEff = "";
  String SocFiduciaria = "";
  String NumeroOperazione = "";
  double ImportoFineMese = 0;
  String FlagObbFiduciante = "";
  String FlagObbNumOpeLegame = "";
  String NumOpeLegame = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CodiceIstituto))) {
      return false;
    }
    if ( ! (CPLib.Empty(DataElaborazione))) {
      return false;
    }
    if ( ! (CPLib.Empty(ProceduraOrigine))) {
      return false;
    }
    if ( ! (CPLib.Empty(NumeroElettronicoOperante))) {
      return false;
    }
    if ( ! (CPLib.Empty(SottoNumeroOperazione))) {
      return false;
    }
    if ( ! (CPLib.Empty(TipoRegistrazione))) {
      return false;
    }
    if ( ! (CPLib.Empty(DataOperazione))) {
      return false;
    }
    if ( ! (CPLib.Empty(FilialeOperante))) {
      return false;
    }
    if ( ! (CPLib.Empty(CodiceOperatore))) {
      return false;
    }
    if ( ! (CPLib.Empty(TerminaleOperante))) {
      return false;
    }
    if ( ! (CPLib.Empty(Transazione))) {
      return false;
    }
    if ( ! (CPLib.Empty(OperazioneCassa))) {
      return false;
    }
    if ( ! (CPLib.Empty(CausaleInterna))) {
      return false;
    }
    if ( ! (CPLib.Empty(CodiceCausale))) {
      return false;
    }
    if ( ! (CPLib.Empty(FlagContanti))) {
      return false;
    }
    if ( ! (CPLib.Empty(ImportoTotale))) {
      return false;
    }
    if ( ! (CPLib.Empty(ImportoContante))) {
      return false;
    }
    if ( ! (CPLib.Empty(Segno))) {
      return false;
    }
    if ( ! (CPLib.Empty(CodiceDivisa))) {
      return false;
    }
    if ( ! (CPLib.Empty(NumeroRapporto))) {
      return false;
    }
    if ( ! (CPLib.Empty(TipoRapportoAUI))) {
      return false;
    }
    if ( ! (CPLib.Empty(FormaTecnica))) {
      return false;
    }
    if ( ! (CPLib.Empty(TipoRapportoIntermediario))) {
      return false;
    }
    if ( ! (CPLib.Empty(CABSportello))) {
      return false;
    }
    if ( ! (CPLib.Empty(Note))) {
      return false;
    }
    if ( ! (CPLib.Empty(FlagSaggio))) {
      return false;
    }
    if ( ! (CPLib.Empty(FlagPostRep))) {
      return false;
    }
    if ( ! (CPLib.Empty(FILLER1))) {
      return false;
    }
    if ( ! (CPLib.Empty(Ragionevolezza))) {
      return false;
    }
    if ( ! (CPLib.Empty(Tipologia))) {
      return false;
    }
    if ( ! (CPLib.Empty(Motivazione))) {
      return false;
    }
    if ( ! (CPLib.Empty(NaturaScopo))) {
      return false;
    }
    if ( ! (CPLib.Empty(TipoVerifica))) {
      return false;
    }
    if ( ! (CPLib.Empty(ObbTitolareEff))) {
      return false;
    }
    if ( ! (CPLib.Empty(SocFiduciaria))) {
      return false;
    }
    if ( ! (CPLib.Empty(NumeroOperazione))) {
      return false;
    }
    if ( ! (CPLib.Empty(ImportoFineMese))) {
      return false;
    }
    if ( ! (CPLib.Empty(FlagObbFiduciante))) {
      return false;
    }
    if ( ! (CPLib.Empty(FlagObbNumOpeLegame))) {
      return false;
    }
    if ( ! (CPLib.Empty(NumOpeLegame))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcflusso_mcrdef p_row) {
    MemoryCursorRow_mcflusso_mcrdef l_row = new MemoryCursorRow_mcflusso_mcrdef();
    CopyOperation<MemoryCursorRow_mcflusso_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcflusso_mcrdef.this.CodiceIstituto = l_row.CodiceIstituto;
      MemoryCursorRow_mcflusso_mcrdef.this.DataElaborazione = l_row.DataElaborazione;
      MemoryCursorRow_mcflusso_mcrdef.this.ProceduraOrigine = l_row.ProceduraOrigine;
      MemoryCursorRow_mcflusso_mcrdef.this.NumeroElettronicoOperante = l_row.NumeroElettronicoOperante;
      MemoryCursorRow_mcflusso_mcrdef.this.SottoNumeroOperazione = l_row.SottoNumeroOperazione;
      MemoryCursorRow_mcflusso_mcrdef.this.TipoRegistrazione = l_row.TipoRegistrazione;
      MemoryCursorRow_mcflusso_mcrdef.this.DataOperazione = l_row.DataOperazione;
      MemoryCursorRow_mcflusso_mcrdef.this.FilialeOperante = l_row.FilialeOperante;
      MemoryCursorRow_mcflusso_mcrdef.this.CodiceOperatore = l_row.CodiceOperatore;
      MemoryCursorRow_mcflusso_mcrdef.this.TerminaleOperante = l_row.TerminaleOperante;
      MemoryCursorRow_mcflusso_mcrdef.this.Transazione = l_row.Transazione;
      MemoryCursorRow_mcflusso_mcrdef.this.OperazioneCassa = l_row.OperazioneCassa;
      MemoryCursorRow_mcflusso_mcrdef.this.CausaleInterna = l_row.CausaleInterna;
      MemoryCursorRow_mcflusso_mcrdef.this.CodiceCausale = l_row.CodiceCausale;
      MemoryCursorRow_mcflusso_mcrdef.this.FlagContanti = l_row.FlagContanti;
      MemoryCursorRow_mcflusso_mcrdef.this.ImportoTotale = l_row.ImportoTotale;
      MemoryCursorRow_mcflusso_mcrdef.this.ImportoContante = l_row.ImportoContante;
      MemoryCursorRow_mcflusso_mcrdef.this.Segno = l_row.Segno;
      MemoryCursorRow_mcflusso_mcrdef.this.CodiceDivisa = l_row.CodiceDivisa;
      MemoryCursorRow_mcflusso_mcrdef.this.NumeroRapporto = l_row.NumeroRapporto;
      MemoryCursorRow_mcflusso_mcrdef.this.TipoRapportoAUI = l_row.TipoRapportoAUI;
      MemoryCursorRow_mcflusso_mcrdef.this.FormaTecnica = l_row.FormaTecnica;
      MemoryCursorRow_mcflusso_mcrdef.this.TipoRapportoIntermediario = l_row.TipoRapportoIntermediario;
      MemoryCursorRow_mcflusso_mcrdef.this.CABSportello = l_row.CABSportello;
      MemoryCursorRow_mcflusso_mcrdef.this.Note = l_row.Note;
      MemoryCursorRow_mcflusso_mcrdef.this.FlagSaggio = l_row.FlagSaggio;
      MemoryCursorRow_mcflusso_mcrdef.this.FlagPostRep = l_row.FlagPostRep;
      MemoryCursorRow_mcflusso_mcrdef.this.FILLER1 = l_row.FILLER1;
      MemoryCursorRow_mcflusso_mcrdef.this.Ragionevolezza = l_row.Ragionevolezza;
      MemoryCursorRow_mcflusso_mcrdef.this.Tipologia = l_row.Tipologia;
      MemoryCursorRow_mcflusso_mcrdef.this.Motivazione = l_row.Motivazione;
      MemoryCursorRow_mcflusso_mcrdef.this.NaturaScopo = l_row.NaturaScopo;
      MemoryCursorRow_mcflusso_mcrdef.this.TipoVerifica = l_row.TipoVerifica;
      MemoryCursorRow_mcflusso_mcrdef.this.ObbTitolareEff = l_row.ObbTitolareEff;
      MemoryCursorRow_mcflusso_mcrdef.this.SocFiduciaria = l_row.SocFiduciaria;
      MemoryCursorRow_mcflusso_mcrdef.this.NumeroOperazione = l_row.NumeroOperazione;
      MemoryCursorRow_mcflusso_mcrdef.this.ImportoFineMese = l_row.ImportoFineMese;
      MemoryCursorRow_mcflusso_mcrdef.this.FlagObbFiduciante = l_row.FlagObbFiduciante;
      MemoryCursorRow_mcflusso_mcrdef.this.FlagObbNumOpeLegame = l_row.FlagObbNumOpeLegame;
      MemoryCursorRow_mcflusso_mcrdef.this.NumOpeLegame = l_row.NumOpeLegame;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcflusso_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcflusso_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcflusso_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcflusso_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcflusso_mcrdef p_From,MemoryCursorRow_mcflusso_mcrdef p_To) {
        p_To.CodiceIstituto = copyAndCast(p_From.CodiceIstituto);
        p_To.DataElaborazione = copyAndCast(p_From.DataElaborazione);
        p_To.ProceduraOrigine = copyAndCast(p_From.ProceduraOrigine);
        p_To.NumeroElettronicoOperante = copyAndCast(p_From.NumeroElettronicoOperante);
        p_To.SottoNumeroOperazione = copyAndCast(p_From.SottoNumeroOperazione);
        p_To.TipoRegistrazione = copyAndCast(p_From.TipoRegistrazione);
        p_To.DataOperazione = copyAndCast(p_From.DataOperazione);
        p_To.FilialeOperante = copyAndCast(p_From.FilialeOperante);
        p_To.CodiceOperatore = copyAndCast(p_From.CodiceOperatore);
        p_To.TerminaleOperante = copyAndCast(p_From.TerminaleOperante);
        p_To.Transazione = copyAndCast(p_From.Transazione);
        p_To.OperazioneCassa = copyAndCast(p_From.OperazioneCassa);
        p_To.CausaleInterna = copyAndCast(p_From.CausaleInterna);
        p_To.CodiceCausale = copyAndCast(p_From.CodiceCausale);
        p_To.FlagContanti = copyAndCast(p_From.FlagContanti);
        p_To.ImportoTotale = copyAndCast(p_From.ImportoTotale);
        p_To.ImportoContante = copyAndCast(p_From.ImportoContante);
        p_To.Segno = copyAndCast(p_From.Segno);
        p_To.CodiceDivisa = copyAndCast(p_From.CodiceDivisa);
        p_To.NumeroRapporto = copyAndCast(p_From.NumeroRapporto);
        p_To.TipoRapportoAUI = copyAndCast(p_From.TipoRapportoAUI);
        p_To.FormaTecnica = copyAndCast(p_From.FormaTecnica);
        p_To.TipoRapportoIntermediario = copyAndCast(p_From.TipoRapportoIntermediario);
        p_To.CABSportello = copyAndCast(p_From.CABSportello);
        p_To.Note = copyAndCast(p_From.Note);
        p_To.FlagSaggio = copyAndCast(p_From.FlagSaggio);
        p_To.FlagPostRep = copyAndCast(p_From.FlagPostRep);
        p_To.FILLER1 = copyAndCast(p_From.FILLER1);
        p_To.Ragionevolezza = copyAndCast(p_From.Ragionevolezza);
        p_To.Tipologia = copyAndCast(p_From.Tipologia);
        p_To.Motivazione = copyAndCast(p_From.Motivazione);
        p_To.NaturaScopo = copyAndCast(p_From.NaturaScopo);
        p_To.TipoVerifica = copyAndCast(p_From.TipoVerifica);
        p_To.ObbTitolareEff = copyAndCast(p_From.ObbTitolareEff);
        p_To.SocFiduciaria = copyAndCast(p_From.SocFiduciaria);
        p_To.NumeroOperazione = copyAndCast(p_From.NumeroOperazione);
        p_To.ImportoFineMese = copyAndCast(p_From.ImportoFineMese);
        p_To.FlagObbFiduciante = copyAndCast(p_From.FlagObbFiduciante);
        p_To.FlagObbNumOpeLegame = copyAndCast(p_From.FlagObbNumOpeLegame);
        p_To.NumOpeLegame = copyAndCast(p_From.NumOpeLegame);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CodiceIstituto","DataElaborazione","ProceduraOrigine","NumeroElettronicoOperante","SottoNumeroOperazione","TipoRegistrazione","DataOperazione","FilialeOperante","CodiceOperatore","TerminaleOperante","Transazione","OperazioneCassa","CausaleInterna","CodiceCausale","FlagContanti","ImportoTotale","ImportoContante","Segno","CodiceDivisa","NumeroRapporto","TipoRapportoAUI","FormaTecnica","TipoRapportoIntermediario","CABSportello","Note","FlagSaggio","FlagPostRep","FILLER1","Ragionevolezza","Tipologia","Motivazione","NaturaScopo","TipoVerifica","ObbTitolareEff","SocFiduciaria","NumeroOperazione","ImportoFineMese","FlagObbFiduciante","FlagObbNumOpeLegame","NumOpeLegame"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","N","N","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","N","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice istituto","Data Elaborazione (AAAAMMGG)","Procedura Originante","Numero Elettronico Operante","Sotto numero dell'operazione","Tipo Registrazione","Data Operazione","Filiale Operante","Codice Operatore","Terminale Operante","Transazione","Operazione di Cassa","Causale Interna","Codice Causale","Flag Contanti","Importo Totale","Importo Contante","Segno","Codice Divisa","Numero Rapporto","Tipo Rapporto Antiriciclaggio","Forma Tecnica del Rapporto","Tipo Rapporto Intermediario","CAB dello Sportello","Note","Flag Saggio","Flag PostRep","Filler 1","Ragionevolezza operazione in base attività svolta","Tipologia dell'?operazione","Motivazione dell'?operazione","Natura/Scopo del rapporto","Tipo Verifica","Obbligatorietà Titolare Effettivo","Società Fiduciaria","Numero dell?operazione","Importo fine mese precedente","Flag Obbligatorietà Fiduciante","Flag obbligatorietà numero operazione per connessione con legame","Numero operazione per connessione con legame"};
    return l_names;
  }
}
