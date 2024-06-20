public class MemoryCursorRow_mccategorizzazione_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mccategorizzazione_mcrdef() {
  }
  public MemoryCursorRow_mccategorizzazione_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mccategorizzazione_mcrdef toBuild = new MemoryCursor_mccategorizzazione_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mccategorizzazione_mcrdef toBuild = new MemoryCursor_mccategorizzazione_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODIST = "";
  String TIPOINT = "";
  String CODINT = "";
  String IDSOGG = "";
  String COD_TIPO_SOGG = "";
  String COD_STATO = "";
  String COD_SPEC_GIUR = "";
  String COD_SETT = "";
  String COD_RAMO = "";
  String COD_NDG_GRUP_ECON = "";
  String COD_ATECO = "";
  String SEG_CAN_TERZI = "";
  String COD_TIT_EFFETTIVO = "";
  String COD_COMP_RILE = "";
  String COD_SCOPO_RAPP = "";
  String NDG_SOGG_PRIMARIO = "";
  String TIPO_RELAZIONE = "";
  String NAT_GIURIDICA = "";
  String CATENA_CTRL = "";
  String AMMONTARE = "";
  String COD_FILIALE = "";
  String DESC_FILIALE = "";
  String OPERATIVITA = "";
  String COMPORTAMENTO = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODIST))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOINT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODINT))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDSOGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(COD_TIPO_SOGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(COD_STATO))) {
      return false;
    }
    if ( ! (CPLib.Empty(COD_SPEC_GIUR))) {
      return false;
    }
    if ( ! (CPLib.Empty(COD_SETT))) {
      return false;
    }
    if ( ! (CPLib.Empty(COD_RAMO))) {
      return false;
    }
    if ( ! (CPLib.Empty(COD_NDG_GRUP_ECON))) {
      return false;
    }
    if ( ! (CPLib.Empty(COD_ATECO))) {
      return false;
    }
    if ( ! (CPLib.Empty(SEG_CAN_TERZI))) {
      return false;
    }
    if ( ! (CPLib.Empty(COD_TIT_EFFETTIVO))) {
      return false;
    }
    if ( ! (CPLib.Empty(COD_COMP_RILE))) {
      return false;
    }
    if ( ! (CPLib.Empty(COD_SCOPO_RAPP))) {
      return false;
    }
    if ( ! (CPLib.Empty(NDG_SOGG_PRIMARIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPO_RELAZIONE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NAT_GIURIDICA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CATENA_CTRL))) {
      return false;
    }
    if ( ! (CPLib.Empty(AMMONTARE))) {
      return false;
    }
    if ( ! (CPLib.Empty(COD_FILIALE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESC_FILIALE))) {
      return false;
    }
    if ( ! (CPLib.Empty(OPERATIVITA))) {
      return false;
    }
    if ( ! (CPLib.Empty(COMPORTAMENTO))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mccategorizzazione_mcrdef p_row) {
    MemoryCursorRow_mccategorizzazione_mcrdef l_row = new MemoryCursorRow_mccategorizzazione_mcrdef();
    CopyOperation<MemoryCursorRow_mccategorizzazione_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mccategorizzazione_mcrdef.this.CODIST = l_row.CODIST;
      MemoryCursorRow_mccategorizzazione_mcrdef.this.TIPOINT = l_row.TIPOINT;
      MemoryCursorRow_mccategorizzazione_mcrdef.this.CODINT = l_row.CODINT;
      MemoryCursorRow_mccategorizzazione_mcrdef.this.IDSOGG = l_row.IDSOGG;
      MemoryCursorRow_mccategorizzazione_mcrdef.this.COD_TIPO_SOGG = l_row.COD_TIPO_SOGG;
      MemoryCursorRow_mccategorizzazione_mcrdef.this.COD_STATO = l_row.COD_STATO;
      MemoryCursorRow_mccategorizzazione_mcrdef.this.COD_SPEC_GIUR = l_row.COD_SPEC_GIUR;
      MemoryCursorRow_mccategorizzazione_mcrdef.this.COD_SETT = l_row.COD_SETT;
      MemoryCursorRow_mccategorizzazione_mcrdef.this.COD_RAMO = l_row.COD_RAMO;
      MemoryCursorRow_mccategorizzazione_mcrdef.this.COD_NDG_GRUP_ECON = l_row.COD_NDG_GRUP_ECON;
      MemoryCursorRow_mccategorizzazione_mcrdef.this.COD_ATECO = l_row.COD_ATECO;
      MemoryCursorRow_mccategorizzazione_mcrdef.this.SEG_CAN_TERZI = l_row.SEG_CAN_TERZI;
      MemoryCursorRow_mccategorizzazione_mcrdef.this.COD_TIT_EFFETTIVO = l_row.COD_TIT_EFFETTIVO;
      MemoryCursorRow_mccategorizzazione_mcrdef.this.COD_COMP_RILE = l_row.COD_COMP_RILE;
      MemoryCursorRow_mccategorizzazione_mcrdef.this.COD_SCOPO_RAPP = l_row.COD_SCOPO_RAPP;
      MemoryCursorRow_mccategorizzazione_mcrdef.this.NDG_SOGG_PRIMARIO = l_row.NDG_SOGG_PRIMARIO;
      MemoryCursorRow_mccategorizzazione_mcrdef.this.TIPO_RELAZIONE = l_row.TIPO_RELAZIONE;
      MemoryCursorRow_mccategorizzazione_mcrdef.this.NAT_GIURIDICA = l_row.NAT_GIURIDICA;
      MemoryCursorRow_mccategorizzazione_mcrdef.this.CATENA_CTRL = l_row.CATENA_CTRL;
      MemoryCursorRow_mccategorizzazione_mcrdef.this.AMMONTARE = l_row.AMMONTARE;
      MemoryCursorRow_mccategorizzazione_mcrdef.this.COD_FILIALE = l_row.COD_FILIALE;
      MemoryCursorRow_mccategorizzazione_mcrdef.this.DESC_FILIALE = l_row.DESC_FILIALE;
      MemoryCursorRow_mccategorizzazione_mcrdef.this.OPERATIVITA = l_row.OPERATIVITA;
      MemoryCursorRow_mccategorizzazione_mcrdef.this.COMPORTAMENTO = l_row.COMPORTAMENTO;
    }
  }
  protected CopyOperation<MemoryCursorRow_mccategorizzazione_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mccategorizzazione_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mccategorizzazione_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mccategorizzazione_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mccategorizzazione_mcrdef p_From,MemoryCursorRow_mccategorizzazione_mcrdef p_To) {
        p_To.CODIST = copyAndCast(p_From.CODIST);
        p_To.TIPOINT = copyAndCast(p_From.TIPOINT);
        p_To.CODINT = copyAndCast(p_From.CODINT);
        p_To.IDSOGG = copyAndCast(p_From.IDSOGG);
        p_To.COD_TIPO_SOGG = copyAndCast(p_From.COD_TIPO_SOGG);
        p_To.COD_STATO = copyAndCast(p_From.COD_STATO);
        p_To.COD_SPEC_GIUR = copyAndCast(p_From.COD_SPEC_GIUR);
        p_To.COD_SETT = copyAndCast(p_From.COD_SETT);
        p_To.COD_RAMO = copyAndCast(p_From.COD_RAMO);
        p_To.COD_NDG_GRUP_ECON = copyAndCast(p_From.COD_NDG_GRUP_ECON);
        p_To.COD_ATECO = copyAndCast(p_From.COD_ATECO);
        p_To.SEG_CAN_TERZI = copyAndCast(p_From.SEG_CAN_TERZI);
        p_To.COD_TIT_EFFETTIVO = copyAndCast(p_From.COD_TIT_EFFETTIVO);
        p_To.COD_COMP_RILE = copyAndCast(p_From.COD_COMP_RILE);
        p_To.COD_SCOPO_RAPP = copyAndCast(p_From.COD_SCOPO_RAPP);
        p_To.NDG_SOGG_PRIMARIO = copyAndCast(p_From.NDG_SOGG_PRIMARIO);
        p_To.TIPO_RELAZIONE = copyAndCast(p_From.TIPO_RELAZIONE);
        p_To.NAT_GIURIDICA = copyAndCast(p_From.NAT_GIURIDICA);
        p_To.CATENA_CTRL = copyAndCast(p_From.CATENA_CTRL);
        p_To.AMMONTARE = copyAndCast(p_From.AMMONTARE);
        p_To.COD_FILIALE = copyAndCast(p_From.COD_FILIALE);
        p_To.DESC_FILIALE = copyAndCast(p_From.DESC_FILIALE);
        p_To.OPERATIVITA = copyAndCast(p_From.OPERATIVITA);
        p_To.COMPORTAMENTO = copyAndCast(p_From.COMPORTAMENTO);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODIST","TIPOINT","CODINT","IDSOGG","COD_TIPO_SOGG","COD_STATO","COD_SPEC_GIUR","COD_SETT","COD_RAMO","COD_NDG_GRUP_ECON","COD_ATECO","SEG_CAN_TERZI","COD_TIT_EFFETTIVO","COD_COMP_RILE","COD_SCOPO_RAPP","NDG_SOGG_PRIMARIO","TIPO_RELAZIONE","NAT_GIURIDICA","CATENA_CTRL","AMMONTARE","COD_FILIALE","DESC_FILIALE","OPERATIVITA","COMPORTAMENTO"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Istituto","Tipo Intermediario","Codice Intermediario","NDG Soggetto","Tipo Soggetto","Stato anagrafico","Specie giuridica","Codice Settore BI","Codice Ramo","NDG del Gruppo di appartenenza","Codice Ateco","","","","","","","","","","Codice Filiale","Descrizione Filiale","",""};
    return l_names;
  }
}
