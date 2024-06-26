public class MemoryCursorRow_mc_tipob_altra_cit_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mc_tipob_altra_cit_mcrdef() {
  }
  public MemoryCursorRow_mc_tipob_altra_cit_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mc_tipob_altra_cit_mcrdef toBuild = new MemoryCursor_mc_tipob_altra_cit_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mc_tipob_altra_cit_mcrdef toBuild = new MemoryCursor_mc_tipob_altra_cit_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String KEY = "";
  String GNL = "";
  String ISTAT = "";
  String GNLCIT = "";
  String GNLCITSALA = "";
  String ABI_P = "";
  double BM5 = 0;
  double BM10 = 0;
  double BM20 = 0;
  double BM50 = 0;
  double BM100 = 0;
  double BM200 = 0;
  double BM500 = 0;
  double NUM_OPE = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(KEY))) {
      return false;
    }
    if ( ! (CPLib.Empty(GNL))) {
      return false;
    }
    if ( ! (CPLib.Empty(ISTAT))) {
      return false;
    }
    if ( ! (CPLib.Empty(GNLCIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(GNLCITSALA))) {
      return false;
    }
    if ( ! (CPLib.Empty(ABI_P))) {
      return false;
    }
    if ( ! (CPLib.Empty(BM5))) {
      return false;
    }
    if ( ! (CPLib.Empty(BM10))) {
      return false;
    }
    if ( ! (CPLib.Empty(BM20))) {
      return false;
    }
    if ( ! (CPLib.Empty(BM50))) {
      return false;
    }
    if ( ! (CPLib.Empty(BM100))) {
      return false;
    }
    if ( ! (CPLib.Empty(BM200))) {
      return false;
    }
    if ( ! (CPLib.Empty(BM500))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUM_OPE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mc_tipob_altra_cit_mcrdef p_row) {
    MemoryCursorRow_mc_tipob_altra_cit_mcrdef l_row = new MemoryCursorRow_mc_tipob_altra_cit_mcrdef();
    CopyOperation<MemoryCursorRow_mc_tipob_altra_cit_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mc_tipob_altra_cit_mcrdef.this.KEY = l_row.KEY;
      MemoryCursorRow_mc_tipob_altra_cit_mcrdef.this.GNL = l_row.GNL;
      MemoryCursorRow_mc_tipob_altra_cit_mcrdef.this.ISTAT = l_row.ISTAT;
      MemoryCursorRow_mc_tipob_altra_cit_mcrdef.this.GNLCIT = l_row.GNLCIT;
      MemoryCursorRow_mc_tipob_altra_cit_mcrdef.this.GNLCITSALA = l_row.GNLCITSALA;
      MemoryCursorRow_mc_tipob_altra_cit_mcrdef.this.ABI_P = l_row.ABI_P;
      MemoryCursorRow_mc_tipob_altra_cit_mcrdef.this.BM5 = l_row.BM5;
      MemoryCursorRow_mc_tipob_altra_cit_mcrdef.this.BM10 = l_row.BM10;
      MemoryCursorRow_mc_tipob_altra_cit_mcrdef.this.BM20 = l_row.BM20;
      MemoryCursorRow_mc_tipob_altra_cit_mcrdef.this.BM50 = l_row.BM50;
      MemoryCursorRow_mc_tipob_altra_cit_mcrdef.this.BM100 = l_row.BM100;
      MemoryCursorRow_mc_tipob_altra_cit_mcrdef.this.BM200 = l_row.BM200;
      MemoryCursorRow_mc_tipob_altra_cit_mcrdef.this.BM500 = l_row.BM500;
      MemoryCursorRow_mc_tipob_altra_cit_mcrdef.this.NUM_OPE = l_row.NUM_OPE;
    }
  }
  protected CopyOperation<MemoryCursorRow_mc_tipob_altra_cit_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mc_tipob_altra_cit_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mc_tipob_altra_cit_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mc_tipob_altra_cit_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mc_tipob_altra_cit_mcrdef p_From,MemoryCursorRow_mc_tipob_altra_cit_mcrdef p_To) {
        p_To.KEY = copyAndCast(p_From.KEY);
        p_To.GNL = copyAndCast(p_From.GNL);
        p_To.ISTAT = copyAndCast(p_From.ISTAT);
        p_To.GNLCIT = copyAndCast(p_From.GNLCIT);
        p_To.GNLCITSALA = copyAndCast(p_From.GNLCITSALA);
        p_To.ABI_P = copyAndCast(p_From.ABI_P);
        p_To.BM5 = copyAndCast(p_From.BM5);
        p_To.BM10 = copyAndCast(p_From.BM10);
        p_To.BM20 = copyAndCast(p_From.BM20);
        p_To.BM50 = copyAndCast(p_From.BM50);
        p_To.BM100 = copyAndCast(p_From.BM100);
        p_To.BM200 = copyAndCast(p_From.BM200);
        p_To.BM500 = copyAndCast(p_From.BM500);
        p_To.NUM_OPE = copyAndCast(p_From.NUM_OPE);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"KEY","GNL","ISTAT","GNLCIT","GNLCITSALA","ABI_P","BM5","BM10","BM20","BM50","BM100","BM200","BM500","NUM_OPE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","N","N","N","N","N","N","N","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Chiave Primaria","GNL Sala Conta","Codice ISTAT","GNLCIT","Sala Conta del GNLCIT","ABI Proprietario","Banconote Movimentate da 5\u20ac","","","","","","",""};
    return l_names;
  }
}
