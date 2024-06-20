public class MemoryCursorRow_sid_invio3 extends CPMemoryCursorRow {
  public MemoryCursorRow_sid_invio3() {
  }
  public MemoryCursorRow_sid_invio3(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_sid_invio3 toBuild = new MemoryCursor_sid_invio3(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_sid_invio3 toBuild = new MemoryCursor_sid_invio3();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODINVIO3 = "";
  String RAPINVIO3 = "";
  String TPRINVIO3 = "";
  double ANNINVIO3 = 0;
  String VALINVIO3 = "";
  String NATINVIO3 = "";
  double IM1INVIO3 = 0;
  double FI1INVIO3 = 0;
  double IM2INVIO3 = 0;
  double FI2INVIO3 = 0;
  double IM3INVIO3 = 0;
  double FI3INVIO3 = 0;
  double IM4INVIO3 = 0;
  double FI4INVIO3 = 0;
  double IM5INVIO3 = 0;
  double FI5INVIO3 = 0;
  double IM6INVIO3 = 0;
  double FI6INVIO3 = 0;
  String UNIQUE3 = "";
  String FLGUNQ3 = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODINVIO3))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPINVIO3))) {
      return false;
    }
    if ( ! (CPLib.Empty(TPRINVIO3))) {
      return false;
    }
    if ( ! (CPLib.Empty(ANNINVIO3))) {
      return false;
    }
    if ( ! (CPLib.Empty(VALINVIO3))) {
      return false;
    }
    if ( ! (CPLib.Empty(NATINVIO3))) {
      return false;
    }
    if ( ! (CPLib.Empty(IM1INVIO3))) {
      return false;
    }
    if ( ! (CPLib.Empty(FI1INVIO3))) {
      return false;
    }
    if ( ! (CPLib.Empty(IM2INVIO3))) {
      return false;
    }
    if ( ! (CPLib.Empty(FI2INVIO3))) {
      return false;
    }
    if ( ! (CPLib.Empty(IM3INVIO3))) {
      return false;
    }
    if ( ! (CPLib.Empty(FI3INVIO3))) {
      return false;
    }
    if ( ! (CPLib.Empty(IM4INVIO3))) {
      return false;
    }
    if ( ! (CPLib.Empty(FI4INVIO3))) {
      return false;
    }
    if ( ! (CPLib.Empty(IM5INVIO3))) {
      return false;
    }
    if ( ! (CPLib.Empty(FI5INVIO3))) {
      return false;
    }
    if ( ! (CPLib.Empty(IM6INVIO3))) {
      return false;
    }
    if ( ! (CPLib.Empty(FI6INVIO3))) {
      return false;
    }
    if ( ! (CPLib.Empty(UNIQUE3))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGUNQ3))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_sid_invio3 p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_sid_invio3.this.CODINVIO3 = copyAndCast(p_row.CODINVIO3);
      MemoryCursorRow_sid_invio3.this.RAPINVIO3 = copyAndCast(p_row.RAPINVIO3);
      MemoryCursorRow_sid_invio3.this.TPRINVIO3 = copyAndCast(p_row.TPRINVIO3);
      MemoryCursorRow_sid_invio3.this.ANNINVIO3 = copyAndCast(p_row.ANNINVIO3);
      MemoryCursorRow_sid_invio3.this.VALINVIO3 = copyAndCast(p_row.VALINVIO3);
      MemoryCursorRow_sid_invio3.this.NATINVIO3 = copyAndCast(p_row.NATINVIO3);
      MemoryCursorRow_sid_invio3.this.IM1INVIO3 = copyAndCast(p_row.IM1INVIO3);
      MemoryCursorRow_sid_invio3.this.FI1INVIO3 = copyAndCast(p_row.FI1INVIO3);
      MemoryCursorRow_sid_invio3.this.IM2INVIO3 = copyAndCast(p_row.IM2INVIO3);
      MemoryCursorRow_sid_invio3.this.FI2INVIO3 = copyAndCast(p_row.FI2INVIO3);
      MemoryCursorRow_sid_invio3.this.IM3INVIO3 = copyAndCast(p_row.IM3INVIO3);
      MemoryCursorRow_sid_invio3.this.FI3INVIO3 = copyAndCast(p_row.FI3INVIO3);
      MemoryCursorRow_sid_invio3.this.IM4INVIO3 = copyAndCast(p_row.IM4INVIO3);
      MemoryCursorRow_sid_invio3.this.FI4INVIO3 = copyAndCast(p_row.FI4INVIO3);
      MemoryCursorRow_sid_invio3.this.IM5INVIO3 = copyAndCast(p_row.IM5INVIO3);
      MemoryCursorRow_sid_invio3.this.FI5INVIO3 = copyAndCast(p_row.FI5INVIO3);
      MemoryCursorRow_sid_invio3.this.IM6INVIO3 = copyAndCast(p_row.IM6INVIO3);
      MemoryCursorRow_sid_invio3.this.FI6INVIO3 = copyAndCast(p_row.FI6INVIO3);
      MemoryCursorRow_sid_invio3.this.UNIQUE3 = copyAndCast(p_row.UNIQUE3);
      MemoryCursorRow_sid_invio3.this.FLGUNQ3 = copyAndCast(p_row.FLGUNQ3);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODINVIO3","RAPINVIO3","TPRINVIO3","ANNINVIO3","VALINVIO3","NATINVIO3","IM1INVIO3","FI1INVIO3","IM2INVIO3","FI2INVIO3","IM3INVIO3","FI3INVIO3","IM4INVIO3","FI4INVIO3","IM5INVIO3","FI5INVIO3","IM6INVIO3","FI6INVIO3","UNIQUE3","FLGUNQ3"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","N","C","C","N","N","N","N","N","N","N","N","N","N","N","N","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Invio","Codice Univio Rapporto","Tipo Rapporto","Anno Riferimento Saldi","Valuta","Natura","Importo 1","Importo Superiore o Inferiore a un milione","Importo 2","Importo Superiore o Inferiore a un milione","Importo 3","Importo Superiore o Inferiore a un milione","Importo 4","Importo Superiore o Inferiore a un milione","Importo 5","Importo Superiore o Inferiore a un milione","Giacenza Media","Importo Superiore o Inferiore a un milione","Codice Univoco","Nuovo COdice Univoco"};
    return l_names;
  }
}
