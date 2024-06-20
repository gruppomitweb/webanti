public class MemoryCursorRow_mcrowserrori_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcrowserrori_mcrdef() {
  }
  public MemoryCursorRow_mcrowserrori_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcrowserrori_mcrdef toBuild = new MemoryCursor_mcrowserrori_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcrowserrori_mcrdef toBuild = new MemoryCursor_mcrowserrori_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String colonna01 = "";
  String colonna02 = "";
  String colonna03 = "";
  String colonna04 = "";
  String colonna05 = "";
  String colonna06 = "";
  String colonna07 = "";
  String colonna08 = "";
  double colonna09 = 0;
  String colonna10 = "";
  double colonna11 = 0;
  String colonna12 = "";
  String colonna13 = "";
  String colonna14 = "";
  String colonna15 = "";
  String colonna16 = "";
  String colonna17 = "";
  String colonna18 = "";
  String colonna19 = "";
  String colonna20 = "";
  String colonna21 = "";
  String colonna22 = "";
  String colonna23 = "";
  String colonna24 = "";
  String colonna25 = "";
  String colonna26 = "";
  String colonna27 = "";
  String colonna28 = "";
  String colonna29 = "";
  String colonna30 = "";
  String colonna31 = "";
  String colonna32 = "";
  String colonna33 = "";
  String colonna34 = "";
  String flgforza = "";
  String Errore = "";
  String colonna35 = "";
  String colonna36 = "";
  String colonna37 = "";
  String colonna38 = "";
  String colonna39 = "";
  String colonna40 = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(colonna01))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna02))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna03))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna04))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna05))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna06))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna07))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna08))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna09))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna10))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna11))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna12))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna13))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna14))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna15))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna16))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna17))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna18))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna19))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna20))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna21))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna22))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna23))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna24))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna25))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna26))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna27))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna28))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna29))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna30))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna31))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna32))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna33))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna34))) {
      return false;
    }
    if ( ! (CPLib.Empty(flgforza))) {
      return false;
    }
    if ( ! (CPLib.Empty(Errore))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna35))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna36))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna37))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna38))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna39))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna40))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcrowserrori_mcrdef p_row) {
    MemoryCursorRow_mcrowserrori_mcrdef l_row = new MemoryCursorRow_mcrowserrori_mcrdef();
    CopyOperation<MemoryCursorRow_mcrowserrori_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna01 = l_row.colonna01;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna02 = l_row.colonna02;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna03 = l_row.colonna03;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna04 = l_row.colonna04;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna05 = l_row.colonna05;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna06 = l_row.colonna06;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna07 = l_row.colonna07;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna08 = l_row.colonna08;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna09 = l_row.colonna09;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna10 = l_row.colonna10;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna11 = l_row.colonna11;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna12 = l_row.colonna12;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna13 = l_row.colonna13;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna14 = l_row.colonna14;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna15 = l_row.colonna15;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna16 = l_row.colonna16;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna17 = l_row.colonna17;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna18 = l_row.colonna18;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna19 = l_row.colonna19;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna20 = l_row.colonna20;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna21 = l_row.colonna21;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna22 = l_row.colonna22;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna23 = l_row.colonna23;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna24 = l_row.colonna24;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna25 = l_row.colonna25;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna26 = l_row.colonna26;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna27 = l_row.colonna27;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna28 = l_row.colonna28;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna29 = l_row.colonna29;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna30 = l_row.colonna30;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna31 = l_row.colonna31;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna32 = l_row.colonna32;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna33 = l_row.colonna33;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna34 = l_row.colonna34;
      MemoryCursorRow_mcrowserrori_mcrdef.this.flgforza = l_row.flgforza;
      MemoryCursorRow_mcrowserrori_mcrdef.this.Errore = l_row.Errore;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna35 = l_row.colonna35;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna36 = l_row.colonna36;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna37 = l_row.colonna37;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna38 = l_row.colonna38;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna39 = l_row.colonna39;
      MemoryCursorRow_mcrowserrori_mcrdef.this.colonna40 = l_row.colonna40;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcrowserrori_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcrowserrori_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcrowserrori_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcrowserrori_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcrowserrori_mcrdef p_From,MemoryCursorRow_mcrowserrori_mcrdef p_To) {
        p_To.colonna01 = copyAndCast(p_From.colonna01);
        p_To.colonna02 = copyAndCast(p_From.colonna02);
        p_To.colonna03 = copyAndCast(p_From.colonna03);
        p_To.colonna04 = copyAndCast(p_From.colonna04);
        p_To.colonna05 = copyAndCast(p_From.colonna05);
        p_To.colonna06 = copyAndCast(p_From.colonna06);
        p_To.colonna07 = copyAndCast(p_From.colonna07);
        p_To.colonna08 = copyAndCast(p_From.colonna08);
        p_To.colonna09 = copyAndCast(p_From.colonna09);
        p_To.colonna10 = copyAndCast(p_From.colonna10);
        p_To.colonna11 = copyAndCast(p_From.colonna11);
        p_To.colonna12 = copyAndCast(p_From.colonna12);
        p_To.colonna13 = copyAndCast(p_From.colonna13);
        p_To.colonna14 = copyAndCast(p_From.colonna14);
        p_To.colonna15 = copyAndCast(p_From.colonna15);
        p_To.colonna16 = copyAndCast(p_From.colonna16);
        p_To.colonna17 = copyAndCast(p_From.colonna17);
        p_To.colonna18 = copyAndCast(p_From.colonna18);
        p_To.colonna19 = copyAndCast(p_From.colonna19);
        p_To.colonna20 = copyAndCast(p_From.colonna20);
        p_To.colonna21 = copyAndCast(p_From.colonna21);
        p_To.colonna22 = copyAndCast(p_From.colonna22);
        p_To.colonna23 = copyAndCast(p_From.colonna23);
        p_To.colonna24 = copyAndCast(p_From.colonna24);
        p_To.colonna25 = copyAndCast(p_From.colonna25);
        p_To.colonna26 = copyAndCast(p_From.colonna26);
        p_To.colonna27 = copyAndCast(p_From.colonna27);
        p_To.colonna28 = copyAndCast(p_From.colonna28);
        p_To.colonna29 = copyAndCast(p_From.colonna29);
        p_To.colonna30 = copyAndCast(p_From.colonna30);
        p_To.colonna31 = copyAndCast(p_From.colonna31);
        p_To.colonna32 = copyAndCast(p_From.colonna32);
        p_To.colonna33 = copyAndCast(p_From.colonna33);
        p_To.colonna34 = copyAndCast(p_From.colonna34);
        p_To.flgforza = copyAndCast(p_From.flgforza);
        p_To.Errore = copyAndCast(p_From.Errore);
        p_To.colonna35 = copyAndCast(p_From.colonna35);
        p_To.colonna36 = copyAndCast(p_From.colonna36);
        p_To.colonna37 = copyAndCast(p_From.colonna37);
        p_To.colonna38 = copyAndCast(p_From.colonna38);
        p_To.colonna39 = copyAndCast(p_From.colonna39);
        p_To.colonna40 = copyAndCast(p_From.colonna40);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"colonna01","colonna02","colonna03","colonna04","colonna05","colonna06","colonna07","colonna08","colonna09","colonna10","colonna11","colonna12","colonna13","colonna14","colonna15","colonna16","colonna17","colonna18","colonna19","colonna20","colonna21","colonna22","colonna23","colonna24","colonna25","colonna26","colonna27","colonna28","colonna29","colonna30","colonna31","colonna32","colonna33","colonna34","flgforza","Errore","colonna35","colonna36","colonna37","colonna38","colonna39","colonna40"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","N","C","N","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","M","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","Forza l'import","Lista Errori","","","","","",""};
    return l_names;
  }
}
