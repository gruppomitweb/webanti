public class MemoryCursorRow_qbe_setsin_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_setsin_vqr() {
  }
  public MemoryCursorRow_qbe_setsin_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_setsin_vqr toBuild = new MemoryCursor_qbe_setsin_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_setsin_vqr toBuild = new MemoryCursor_qbe_setsin_vqr();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String SETSINT = "";
  String DESCRI = "";
  java.sql.Date DATAINI = CPLib.NullDate();
  java.sql.Date DATAFINE = CPLib.NullDate();
  String DAGRU1 = "";
  String AGRU1 = "";
  String DAGRU2 = "";
  String AGRU2 = "";
  String DAGRU3 = "";
  String AGRU3 = "";
  String DAGRU4 = "";
  String AGRU4 = "";
  String DAGRU5 = "";
  String AGRU5 = "";
  String DAGRU6 = "";
  String AGRU6 = "";
  String DASOT1 = "";
  String ASOT1 = "";
  String DASOT2 = "";
  String ASOT2 = "";
  String DASOT3 = "";
  String ASOT3 = "";
  String DASOT4 = "";
  String ASOT4 = "";
  String DASOT5 = "";
  String ASOT5 = "";
  String DASOT6 = "";
  String ASOT6 = "";
  String DASOT7 = "";
  String ASOT7 = "";
  String DASOT8 = "";
  String ASOT8 = "";
  String DASOT9 = "";
  String ASOT9 = "";
  String DASOT10 = "";
  String ASOT10 = "";
  String DASOT11 = "";
  String ASOT11 = "";
  String DASOT12 = "";
  String ASOT12 = "";
  String DAATE1 = "";
  String AATE1 = "";
  String DAATE2 = "";
  String AATE2 = "";
  String DAATE3 = "";
  String AATE3 = "";
  String DAATE4 = "";
  String AATE4 = "";
  String DAATE5 = "";
  String AATE5 = "";
  String DAATE6 = "";
  String AATE6 = "";
  double IDSETSIN = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(SETSINT))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRI))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAINI))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAFINE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DAGRU1))) {
      return false;
    }
    if ( ! (CPLib.Empty(AGRU1))) {
      return false;
    }
    if ( ! (CPLib.Empty(DAGRU2))) {
      return false;
    }
    if ( ! (CPLib.Empty(AGRU2))) {
      return false;
    }
    if ( ! (CPLib.Empty(DAGRU3))) {
      return false;
    }
    if ( ! (CPLib.Empty(AGRU3))) {
      return false;
    }
    if ( ! (CPLib.Empty(DAGRU4))) {
      return false;
    }
    if ( ! (CPLib.Empty(AGRU4))) {
      return false;
    }
    if ( ! (CPLib.Empty(DAGRU5))) {
      return false;
    }
    if ( ! (CPLib.Empty(AGRU5))) {
      return false;
    }
    if ( ! (CPLib.Empty(DAGRU6))) {
      return false;
    }
    if ( ! (CPLib.Empty(AGRU6))) {
      return false;
    }
    if ( ! (CPLib.Empty(DASOT1))) {
      return false;
    }
    if ( ! (CPLib.Empty(ASOT1))) {
      return false;
    }
    if ( ! (CPLib.Empty(DASOT2))) {
      return false;
    }
    if ( ! (CPLib.Empty(ASOT2))) {
      return false;
    }
    if ( ! (CPLib.Empty(DASOT3))) {
      return false;
    }
    if ( ! (CPLib.Empty(ASOT3))) {
      return false;
    }
    if ( ! (CPLib.Empty(DASOT4))) {
      return false;
    }
    if ( ! (CPLib.Empty(ASOT4))) {
      return false;
    }
    if ( ! (CPLib.Empty(DASOT5))) {
      return false;
    }
    if ( ! (CPLib.Empty(ASOT5))) {
      return false;
    }
    if ( ! (CPLib.Empty(DASOT6))) {
      return false;
    }
    if ( ! (CPLib.Empty(ASOT6))) {
      return false;
    }
    if ( ! (CPLib.Empty(DASOT7))) {
      return false;
    }
    if ( ! (CPLib.Empty(ASOT7))) {
      return false;
    }
    if ( ! (CPLib.Empty(DASOT8))) {
      return false;
    }
    if ( ! (CPLib.Empty(ASOT8))) {
      return false;
    }
    if ( ! (CPLib.Empty(DASOT9))) {
      return false;
    }
    if ( ! (CPLib.Empty(ASOT9))) {
      return false;
    }
    if ( ! (CPLib.Empty(DASOT10))) {
      return false;
    }
    if ( ! (CPLib.Empty(ASOT10))) {
      return false;
    }
    if ( ! (CPLib.Empty(DASOT11))) {
      return false;
    }
    if ( ! (CPLib.Empty(ASOT11))) {
      return false;
    }
    if ( ! (CPLib.Empty(DASOT12))) {
      return false;
    }
    if ( ! (CPLib.Empty(ASOT12))) {
      return false;
    }
    if ( ! (CPLib.Empty(DAATE1))) {
      return false;
    }
    if ( ! (CPLib.Empty(AATE1))) {
      return false;
    }
    if ( ! (CPLib.Empty(DAATE2))) {
      return false;
    }
    if ( ! (CPLib.Empty(AATE2))) {
      return false;
    }
    if ( ! (CPLib.Empty(DAATE3))) {
      return false;
    }
    if ( ! (CPLib.Empty(AATE3))) {
      return false;
    }
    if ( ! (CPLib.Empty(DAATE4))) {
      return false;
    }
    if ( ! (CPLib.Empty(AATE4))) {
      return false;
    }
    if ( ! (CPLib.Empty(DAATE5))) {
      return false;
    }
    if ( ! (CPLib.Empty(AATE5))) {
      return false;
    }
    if ( ! (CPLib.Empty(DAATE6))) {
      return false;
    }
    if ( ! (CPLib.Empty(AATE6))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDSETSIN))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_qbe_setsin_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_setsin_vqr.this.SETSINT = copyAndCast(p_row.SETSINT);
      MemoryCursorRow_qbe_setsin_vqr.this.DESCRI = copyAndCast(p_row.DESCRI);
      MemoryCursorRow_qbe_setsin_vqr.this.DATAINI = copyAndCast(p_row.DATAINI);
      MemoryCursorRow_qbe_setsin_vqr.this.DATAFINE = copyAndCast(p_row.DATAFINE);
      MemoryCursorRow_qbe_setsin_vqr.this.DAGRU1 = copyAndCast(p_row.DAGRU1);
      MemoryCursorRow_qbe_setsin_vqr.this.AGRU1 = copyAndCast(p_row.AGRU1);
      MemoryCursorRow_qbe_setsin_vqr.this.DAGRU2 = copyAndCast(p_row.DAGRU2);
      MemoryCursorRow_qbe_setsin_vqr.this.AGRU2 = copyAndCast(p_row.AGRU2);
      MemoryCursorRow_qbe_setsin_vqr.this.DAGRU3 = copyAndCast(p_row.DAGRU3);
      MemoryCursorRow_qbe_setsin_vqr.this.AGRU3 = copyAndCast(p_row.AGRU3);
      MemoryCursorRow_qbe_setsin_vqr.this.DAGRU4 = copyAndCast(p_row.DAGRU4);
      MemoryCursorRow_qbe_setsin_vqr.this.AGRU4 = copyAndCast(p_row.AGRU4);
      MemoryCursorRow_qbe_setsin_vqr.this.DAGRU5 = copyAndCast(p_row.DAGRU5);
      MemoryCursorRow_qbe_setsin_vqr.this.AGRU5 = copyAndCast(p_row.AGRU5);
      MemoryCursorRow_qbe_setsin_vqr.this.DAGRU6 = copyAndCast(p_row.DAGRU6);
      MemoryCursorRow_qbe_setsin_vqr.this.AGRU6 = copyAndCast(p_row.AGRU6);
      MemoryCursorRow_qbe_setsin_vqr.this.DASOT1 = copyAndCast(p_row.DASOT1);
      MemoryCursorRow_qbe_setsin_vqr.this.ASOT1 = copyAndCast(p_row.ASOT1);
      MemoryCursorRow_qbe_setsin_vqr.this.DASOT2 = copyAndCast(p_row.DASOT2);
      MemoryCursorRow_qbe_setsin_vqr.this.ASOT2 = copyAndCast(p_row.ASOT2);
      MemoryCursorRow_qbe_setsin_vqr.this.DASOT3 = copyAndCast(p_row.DASOT3);
      MemoryCursorRow_qbe_setsin_vqr.this.ASOT3 = copyAndCast(p_row.ASOT3);
      MemoryCursorRow_qbe_setsin_vqr.this.DASOT4 = copyAndCast(p_row.DASOT4);
      MemoryCursorRow_qbe_setsin_vqr.this.ASOT4 = copyAndCast(p_row.ASOT4);
      MemoryCursorRow_qbe_setsin_vqr.this.DASOT5 = copyAndCast(p_row.DASOT5);
      MemoryCursorRow_qbe_setsin_vqr.this.ASOT5 = copyAndCast(p_row.ASOT5);
      MemoryCursorRow_qbe_setsin_vqr.this.DASOT6 = copyAndCast(p_row.DASOT6);
      MemoryCursorRow_qbe_setsin_vqr.this.ASOT6 = copyAndCast(p_row.ASOT6);
      MemoryCursorRow_qbe_setsin_vqr.this.DASOT7 = copyAndCast(p_row.DASOT7);
      MemoryCursorRow_qbe_setsin_vqr.this.ASOT7 = copyAndCast(p_row.ASOT7);
      MemoryCursorRow_qbe_setsin_vqr.this.DASOT8 = copyAndCast(p_row.DASOT8);
      MemoryCursorRow_qbe_setsin_vqr.this.ASOT8 = copyAndCast(p_row.ASOT8);
      MemoryCursorRow_qbe_setsin_vqr.this.DASOT9 = copyAndCast(p_row.DASOT9);
      MemoryCursorRow_qbe_setsin_vqr.this.ASOT9 = copyAndCast(p_row.ASOT9);
      MemoryCursorRow_qbe_setsin_vqr.this.DASOT10 = copyAndCast(p_row.DASOT10);
      MemoryCursorRow_qbe_setsin_vqr.this.ASOT10 = copyAndCast(p_row.ASOT10);
      MemoryCursorRow_qbe_setsin_vqr.this.DASOT11 = copyAndCast(p_row.DASOT11);
      MemoryCursorRow_qbe_setsin_vqr.this.ASOT11 = copyAndCast(p_row.ASOT11);
      MemoryCursorRow_qbe_setsin_vqr.this.DASOT12 = copyAndCast(p_row.DASOT12);
      MemoryCursorRow_qbe_setsin_vqr.this.ASOT12 = copyAndCast(p_row.ASOT12);
      MemoryCursorRow_qbe_setsin_vqr.this.DAATE1 = copyAndCast(p_row.DAATE1);
      MemoryCursorRow_qbe_setsin_vqr.this.AATE1 = copyAndCast(p_row.AATE1);
      MemoryCursorRow_qbe_setsin_vqr.this.DAATE2 = copyAndCast(p_row.DAATE2);
      MemoryCursorRow_qbe_setsin_vqr.this.AATE2 = copyAndCast(p_row.AATE2);
      MemoryCursorRow_qbe_setsin_vqr.this.DAATE3 = copyAndCast(p_row.DAATE3);
      MemoryCursorRow_qbe_setsin_vqr.this.AATE3 = copyAndCast(p_row.AATE3);
      MemoryCursorRow_qbe_setsin_vqr.this.DAATE4 = copyAndCast(p_row.DAATE4);
      MemoryCursorRow_qbe_setsin_vqr.this.AATE4 = copyAndCast(p_row.AATE4);
      MemoryCursorRow_qbe_setsin_vqr.this.DAATE5 = copyAndCast(p_row.DAATE5);
      MemoryCursorRow_qbe_setsin_vqr.this.AATE5 = copyAndCast(p_row.AATE5);
      MemoryCursorRow_qbe_setsin_vqr.this.DAATE6 = copyAndCast(p_row.DAATE6);
      MemoryCursorRow_qbe_setsin_vqr.this.AATE6 = copyAndCast(p_row.AATE6);
      MemoryCursorRow_qbe_setsin_vqr.this.IDSETSIN = copyAndCast(p_row.IDSETSIN);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"SETSINT","DESCRI","DATAINI","DATAFINE","DAGRU1","AGRU1","DAGRU2","AGRU2","DAGRU3","AGRU3","DAGRU4","AGRU4","DAGRU5","AGRU5","DAGRU6","AGRU6","DASOT1","ASOT1","DASOT2","ASOT2","DASOT3","ASOT3","DASOT4","ASOT4","DASOT5","ASOT5","DASOT6","ASOT6","DASOT7","ASOT7","DASOT8","ASOT8","DASOT9","ASOT9","DASOT10","ASOT10","DASOT11","ASOT11","DASOT12","ASOT12","DAATE1","AATE1","DAATE2","AATE2","DAATE3","AATE3","DAATE4","AATE4","DAATE5","AATE5","DAATE6","AATE6","IDSETSIN"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","D","D","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice","Descrizione","Data Inizio Validità","Data Fine Validità","Da Gruppo","A Gruppo","","","","","","","","","","","Da Sottogruppo","A Sottogruppo","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","Identificativo"};
    return l_names;
  }
}
