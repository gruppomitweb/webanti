public class MemoryCursorRow_mcestraisv_clienti_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcestraisv_clienti_mcrdef() {
  }
  public MemoryCursorRow_mcestraisv_clienti_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcestraisv_clienti_mcrdef toBuild = new MemoryCursor_mcestraisv_clienti_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcestraisv_clienti_mcrdef toBuild = new MemoryCursor_mcestraisv_clienti_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODCLI = "";
  String RAGSOC = "";
  String COGNOME = "";
  String NOME = "";
  String CODFISC = "";
  String PARTIVA = "";
  java.sql.Date DATANASC = CPLib.NullDate();
  String CAPNASC = "";
  String COMUNASC = "";
  String PROVNASC = "";
  String PAESENASC = "";
  String SESSO = "";
  String INDRESID = "";
  String CAPRESID = "";
  String DESCCIT = "";
  String PROVINCIA = "";
  String PAESE = "";
  String INDDOMIC = "";
  String CAPDOMIC = "";
  String DESCDOM = "";
  String PROVDOM = "";
  String PAESEDOM = "";
  String SPECIE = "";
  String TELEF = "";
  String FAX = "";
  String EMAIL = "";
  String SVGRUPPO = "";
  String SVT01118 = "";
  double SVPMI = 0;
  String NUMCR = "";
  String SVT00353 = "";
  String SVT00011 = "";
  String CLINVREN = "";
  String SVTIPOSCAD = "";
  String SVTIPOINAD = "";
  String SVT00353GA = "";
  String CCIAA = "";
  String LEI = "";
  String NDG = "";
  String PROV = "";
  String SAE = "";
  String ATECO = "";
  String STATO = "";
  double CFESTERO = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODCLI))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGSOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(COGNOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODFISC))) {
      return false;
    }
    if ( ! (CPLib.Empty(PARTIVA))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATANASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAPNASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(COMUNASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVNASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESENASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(SESSO))) {
      return false;
    }
    if ( ! (CPLib.Empty(INDRESID))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAPRESID))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCCIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVINCIA))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(INDDOMIC))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAPDOMIC))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCDOM))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVDOM))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESEDOM))) {
      return false;
    }
    if ( ! (CPLib.Empty(SPECIE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TELEF))) {
      return false;
    }
    if ( ! (CPLib.Empty(FAX))) {
      return false;
    }
    if ( ! (CPLib.Empty(EMAIL))) {
      return false;
    }
    if ( ! (CPLib.Empty(SVGRUPPO))) {
      return false;
    }
    if ( ! (CPLib.Empty(SVT01118))) {
      return false;
    }
    if ( ! (CPLib.Empty(SVPMI))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMCR))) {
      return false;
    }
    if ( ! (CPLib.Empty(SVT00353))) {
      return false;
    }
    if ( ! (CPLib.Empty(SVT00011))) {
      return false;
    }
    if ( ! (CPLib.Empty(CLINVREN))) {
      return false;
    }
    if ( ! (CPLib.Empty(SVTIPOSCAD))) {
      return false;
    }
    if ( ! (CPLib.Empty(SVTIPOINAD))) {
      return false;
    }
    if ( ! (CPLib.Empty(SVT00353GA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CCIAA))) {
      return false;
    }
    if ( ! (CPLib.Empty(LEI))) {
      return false;
    }
    if ( ! (CPLib.Empty(NDG))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROV))) {
      return false;
    }
    if ( ! (CPLib.Empty(SAE))) {
      return false;
    }
    if ( ! (CPLib.Empty(ATECO))) {
      return false;
    }
    if ( ! (CPLib.Empty(STATO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CFESTERO))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcestraisv_clienti_mcrdef p_row) {
    MemoryCursorRow_mcestraisv_clienti_mcrdef l_row = new MemoryCursorRow_mcestraisv_clienti_mcrdef();
    CopyOperation<MemoryCursorRow_mcestraisv_clienti_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.CODCLI = l_row.CODCLI;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.RAGSOC = l_row.RAGSOC;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.COGNOME = l_row.COGNOME;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.NOME = l_row.NOME;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.CODFISC = l_row.CODFISC;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.PARTIVA = l_row.PARTIVA;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.DATANASC = l_row.DATANASC;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.CAPNASC = l_row.CAPNASC;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.COMUNASC = l_row.COMUNASC;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.PROVNASC = l_row.PROVNASC;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.PAESENASC = l_row.PAESENASC;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.SESSO = l_row.SESSO;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.INDRESID = l_row.INDRESID;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.CAPRESID = l_row.CAPRESID;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.DESCCIT = l_row.DESCCIT;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.PROVINCIA = l_row.PROVINCIA;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.PAESE = l_row.PAESE;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.INDDOMIC = l_row.INDDOMIC;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.CAPDOMIC = l_row.CAPDOMIC;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.DESCDOM = l_row.DESCDOM;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.PROVDOM = l_row.PROVDOM;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.PAESEDOM = l_row.PAESEDOM;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.SPECIE = l_row.SPECIE;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.TELEF = l_row.TELEF;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.FAX = l_row.FAX;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.EMAIL = l_row.EMAIL;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.SVGRUPPO = l_row.SVGRUPPO;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.SVT01118 = l_row.SVT01118;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.SVPMI = l_row.SVPMI;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.NUMCR = l_row.NUMCR;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.SVT00353 = l_row.SVT00353;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.SVT00011 = l_row.SVT00011;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.CLINVREN = l_row.CLINVREN;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.SVTIPOSCAD = l_row.SVTIPOSCAD;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.SVTIPOINAD = l_row.SVTIPOINAD;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.SVT00353GA = l_row.SVT00353GA;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.CCIAA = l_row.CCIAA;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.LEI = l_row.LEI;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.NDG = l_row.NDG;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.PROV = l_row.PROV;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.SAE = l_row.SAE;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.ATECO = l_row.ATECO;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.STATO = l_row.STATO;
      MemoryCursorRow_mcestraisv_clienti_mcrdef.this.CFESTERO = l_row.CFESTERO;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcestraisv_clienti_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcestraisv_clienti_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcestraisv_clienti_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcestraisv_clienti_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcestraisv_clienti_mcrdef p_From,MemoryCursorRow_mcestraisv_clienti_mcrdef p_To) {
        p_To.CODCLI = copyAndCast(p_From.CODCLI);
        p_To.RAGSOC = copyAndCast(p_From.RAGSOC);
        p_To.COGNOME = copyAndCast(p_From.COGNOME);
        p_To.NOME = copyAndCast(p_From.NOME);
        p_To.CODFISC = copyAndCast(p_From.CODFISC);
        p_To.PARTIVA = copyAndCast(p_From.PARTIVA);
        p_To.DATANASC = copyAndCast(p_From.DATANASC);
        p_To.CAPNASC = copyAndCast(p_From.CAPNASC);
        p_To.COMUNASC = copyAndCast(p_From.COMUNASC);
        p_To.PROVNASC = copyAndCast(p_From.PROVNASC);
        p_To.PAESENASC = copyAndCast(p_From.PAESENASC);
        p_To.SESSO = copyAndCast(p_From.SESSO);
        p_To.INDRESID = copyAndCast(p_From.INDRESID);
        p_To.CAPRESID = copyAndCast(p_From.CAPRESID);
        p_To.DESCCIT = copyAndCast(p_From.DESCCIT);
        p_To.PROVINCIA = copyAndCast(p_From.PROVINCIA);
        p_To.PAESE = copyAndCast(p_From.PAESE);
        p_To.INDDOMIC = copyAndCast(p_From.INDDOMIC);
        p_To.CAPDOMIC = copyAndCast(p_From.CAPDOMIC);
        p_To.DESCDOM = copyAndCast(p_From.DESCDOM);
        p_To.PROVDOM = copyAndCast(p_From.PROVDOM);
        p_To.PAESEDOM = copyAndCast(p_From.PAESEDOM);
        p_To.SPECIE = copyAndCast(p_From.SPECIE);
        p_To.TELEF = copyAndCast(p_From.TELEF);
        p_To.FAX = copyAndCast(p_From.FAX);
        p_To.EMAIL = copyAndCast(p_From.EMAIL);
        p_To.SVGRUPPO = copyAndCast(p_From.SVGRUPPO);
        p_To.SVT01118 = copyAndCast(p_From.SVT01118);
        p_To.SVPMI = copyAndCast(p_From.SVPMI);
        p_To.NUMCR = copyAndCast(p_From.NUMCR);
        p_To.SVT00353 = copyAndCast(p_From.SVT00353);
        p_To.SVT00011 = copyAndCast(p_From.SVT00011);
        p_To.CLINVREN = copyAndCast(p_From.CLINVREN);
        p_To.SVTIPOSCAD = copyAndCast(p_From.SVTIPOSCAD);
        p_To.SVTIPOINAD = copyAndCast(p_From.SVTIPOINAD);
        p_To.SVT00353GA = copyAndCast(p_From.SVT00353GA);
        p_To.CCIAA = copyAndCast(p_From.CCIAA);
        p_To.LEI = copyAndCast(p_From.LEI);
        p_To.NDG = copyAndCast(p_From.NDG);
        p_To.PROV = copyAndCast(p_From.PROV);
        p_To.SAE = copyAndCast(p_From.SAE);
        p_To.ATECO = copyAndCast(p_From.ATECO);
        p_To.STATO = copyAndCast(p_From.STATO);
        p_To.CFESTERO = copyAndCast(p_From.CFESTERO);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODCLI","RAGSOC","COGNOME","NOME","CODFISC","PARTIVA","DATANASC","CAPNASC","COMUNASC","PROVNASC","PAESENASC","SESSO","INDRESID","CAPRESID","DESCCIT","PROVINCIA","PAESE","INDDOMIC","CAPDOMIC","DESCDOM","PROVDOM","PAESEDOM","SPECIE","TELEF","FAX","EMAIL","SVGRUPPO","SVT01118","SVPMI","NUMCR","SVT00353","SVT00011","CLINVREN","SVTIPOSCAD","SVTIPOINAD","SVT00353GA","CCIAA","LEI","NDG","PROV","SAE","ATECO","STATO","CFESTERO"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","D","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","N","C","C","C","C","C","C","C","C","C","C","C","C","C","C","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
    return l_names;
  }
}
