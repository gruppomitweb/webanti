public class MemoryCursorRow_mccontroparte_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mccontroparte_mcrdef() {
  }
  public MemoryCursorRow_mccontroparte_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mccontroparte_mcrdef toBuild = new MemoryCursor_mccontroparte_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mccontroparte_mcrdef toBuild = new MemoryCursor_mccontroparte_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CodiceIstituto = "";
  String DataElaborazione = "";
  String ProceduraOrigine = "";
  String NumeroElettronicoOperante = "";
  String SottoNumeroOperazione = "";
  String TipoRapportoBeneficiario = "";
  String CodiceBeneficiario = "";
  String CodiceRapporto = "";
  String NomeBeneficiario = "";
  String IndirizzoBeneficiario = "";
  String CapBeneficiario = "";
  String CabBeneficiario = "";
  String LocalitaBeneficiario = "";
  String ProvinciaBeneficiario = "";
  String StatoBeneficiario = "";
  String TipoIntermediario = "";
  String CodiceIntermediario = "";
  String CodiceStatoBanca = "";
  String CabBanca = "";
  String ComuneBanca = "";
  String ProvinciaBanca = "";
  String DescrizioneIntermediario = "";
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
    if ( ! (CPLib.Empty(TipoRapportoBeneficiario))) {
      return false;
    }
    if ( ! (CPLib.Empty(CodiceBeneficiario))) {
      return false;
    }
    if ( ! (CPLib.Empty(CodiceRapporto))) {
      return false;
    }
    if ( ! (CPLib.Empty(NomeBeneficiario))) {
      return false;
    }
    if ( ! (CPLib.Empty(IndirizzoBeneficiario))) {
      return false;
    }
    if ( ! (CPLib.Empty(CapBeneficiario))) {
      return false;
    }
    if ( ! (CPLib.Empty(CabBeneficiario))) {
      return false;
    }
    if ( ! (CPLib.Empty(LocalitaBeneficiario))) {
      return false;
    }
    if ( ! (CPLib.Empty(ProvinciaBeneficiario))) {
      return false;
    }
    if ( ! (CPLib.Empty(StatoBeneficiario))) {
      return false;
    }
    if ( ! (CPLib.Empty(TipoIntermediario))) {
      return false;
    }
    if ( ! (CPLib.Empty(CodiceIntermediario))) {
      return false;
    }
    if ( ! (CPLib.Empty(CodiceStatoBanca))) {
      return false;
    }
    if ( ! (CPLib.Empty(CabBanca))) {
      return false;
    }
    if ( ! (CPLib.Empty(ComuneBanca))) {
      return false;
    }
    if ( ! (CPLib.Empty(ProvinciaBanca))) {
      return false;
    }
    if ( ! (CPLib.Empty(DescrizioneIntermediario))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mccontroparte_mcrdef p_row) {
    MemoryCursorRow_mccontroparte_mcrdef l_row = new MemoryCursorRow_mccontroparte_mcrdef();
    CopyOperation<MemoryCursorRow_mccontroparte_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mccontroparte_mcrdef.this.CodiceIstituto = l_row.CodiceIstituto;
      MemoryCursorRow_mccontroparte_mcrdef.this.DataElaborazione = l_row.DataElaborazione;
      MemoryCursorRow_mccontroparte_mcrdef.this.ProceduraOrigine = l_row.ProceduraOrigine;
      MemoryCursorRow_mccontroparte_mcrdef.this.NumeroElettronicoOperante = l_row.NumeroElettronicoOperante;
      MemoryCursorRow_mccontroparte_mcrdef.this.SottoNumeroOperazione = l_row.SottoNumeroOperazione;
      MemoryCursorRow_mccontroparte_mcrdef.this.TipoRapportoBeneficiario = l_row.TipoRapportoBeneficiario;
      MemoryCursorRow_mccontroparte_mcrdef.this.CodiceBeneficiario = l_row.CodiceBeneficiario;
      MemoryCursorRow_mccontroparte_mcrdef.this.CodiceRapporto = l_row.CodiceRapporto;
      MemoryCursorRow_mccontroparte_mcrdef.this.NomeBeneficiario = l_row.NomeBeneficiario;
      MemoryCursorRow_mccontroparte_mcrdef.this.IndirizzoBeneficiario = l_row.IndirizzoBeneficiario;
      MemoryCursorRow_mccontroparte_mcrdef.this.CapBeneficiario = l_row.CapBeneficiario;
      MemoryCursorRow_mccontroparte_mcrdef.this.CabBeneficiario = l_row.CabBeneficiario;
      MemoryCursorRow_mccontroparte_mcrdef.this.LocalitaBeneficiario = l_row.LocalitaBeneficiario;
      MemoryCursorRow_mccontroparte_mcrdef.this.ProvinciaBeneficiario = l_row.ProvinciaBeneficiario;
      MemoryCursorRow_mccontroparte_mcrdef.this.StatoBeneficiario = l_row.StatoBeneficiario;
      MemoryCursorRow_mccontroparte_mcrdef.this.TipoIntermediario = l_row.TipoIntermediario;
      MemoryCursorRow_mccontroparte_mcrdef.this.CodiceIntermediario = l_row.CodiceIntermediario;
      MemoryCursorRow_mccontroparte_mcrdef.this.CodiceStatoBanca = l_row.CodiceStatoBanca;
      MemoryCursorRow_mccontroparte_mcrdef.this.CabBanca = l_row.CabBanca;
      MemoryCursorRow_mccontroparte_mcrdef.this.ComuneBanca = l_row.ComuneBanca;
      MemoryCursorRow_mccontroparte_mcrdef.this.ProvinciaBanca = l_row.ProvinciaBanca;
      MemoryCursorRow_mccontroparte_mcrdef.this.DescrizioneIntermediario = l_row.DescrizioneIntermediario;
    }
  }
  protected CopyOperation<MemoryCursorRow_mccontroparte_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mccontroparte_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mccontroparte_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mccontroparte_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mccontroparte_mcrdef p_From,MemoryCursorRow_mccontroparte_mcrdef p_To) {
        p_To.CodiceIstituto = copyAndCast(p_From.CodiceIstituto);
        p_To.DataElaborazione = copyAndCast(p_From.DataElaborazione);
        p_To.ProceduraOrigine = copyAndCast(p_From.ProceduraOrigine);
        p_To.NumeroElettronicoOperante = copyAndCast(p_From.NumeroElettronicoOperante);
        p_To.SottoNumeroOperazione = copyAndCast(p_From.SottoNumeroOperazione);
        p_To.TipoRapportoBeneficiario = copyAndCast(p_From.TipoRapportoBeneficiario);
        p_To.CodiceBeneficiario = copyAndCast(p_From.CodiceBeneficiario);
        p_To.CodiceRapporto = copyAndCast(p_From.CodiceRapporto);
        p_To.NomeBeneficiario = copyAndCast(p_From.NomeBeneficiario);
        p_To.IndirizzoBeneficiario = copyAndCast(p_From.IndirizzoBeneficiario);
        p_To.CapBeneficiario = copyAndCast(p_From.CapBeneficiario);
        p_To.CabBeneficiario = copyAndCast(p_From.CabBeneficiario);
        p_To.LocalitaBeneficiario = copyAndCast(p_From.LocalitaBeneficiario);
        p_To.ProvinciaBeneficiario = copyAndCast(p_From.ProvinciaBeneficiario);
        p_To.StatoBeneficiario = copyAndCast(p_From.StatoBeneficiario);
        p_To.TipoIntermediario = copyAndCast(p_From.TipoIntermediario);
        p_To.CodiceIntermediario = copyAndCast(p_From.CodiceIntermediario);
        p_To.CodiceStatoBanca = copyAndCast(p_From.CodiceStatoBanca);
        p_To.CabBanca = copyAndCast(p_From.CabBanca);
        p_To.ComuneBanca = copyAndCast(p_From.ComuneBanca);
        p_To.ProvinciaBanca = copyAndCast(p_From.ProvinciaBanca);
        p_To.DescrizioneIntermediario = copyAndCast(p_From.DescrizioneIntermediario);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CodiceIstituto","DataElaborazione","ProceduraOrigine","NumeroElettronicoOperante","SottoNumeroOperazione","TipoRapportoBeneficiario","CodiceBeneficiario","CodiceRapporto","NomeBeneficiario","IndirizzoBeneficiario","CapBeneficiario","CabBeneficiario","LocalitaBeneficiario","ProvinciaBeneficiario","StatoBeneficiario","TipoIntermediario","CodiceIntermediario","CodiceStatoBanca","CabBanca","ComuneBanca","ProvinciaBanca","DescrizioneIntermediario"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice istituto","Data Elaborazione (AAAAMMGG)","Procedura Originante","Numero Elettronico Operante","Sotto numero dell'operazione","Tipo Rapporto Beneficiario","Numero anagrafico del beneficiario","Codice rapporto del beneficiario","Nome del beneficiario","Indirizzo del beneficiario","Cap del beneficiario","Cab del beneficiario","Località di residenza del beneficiario","Provincia di residenza del beneficiario","Stato di residenza del beneficiario","Tipo intermediario Beneficiario","Codice intermediario Beneficiario","Codice stato della banca tramite","Cab della banca tramite","Comune della banca tramite","Provincia della banca tramite","Descrizione dell'intermediario"};
    return l_names;
  }
}
