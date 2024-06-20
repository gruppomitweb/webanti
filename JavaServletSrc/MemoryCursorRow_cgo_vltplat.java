public class MemoryCursorRow_cgo_vltplat extends CPMemoryCursorRow {
  public MemoryCursorRow_cgo_vltplat() {
  }
  public MemoryCursorRow_cgo_vltplat(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_cgo_vltplat toBuild = new MemoryCursor_cgo_vltplat(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_cgo_vltplat toBuild = new MemoryCursor_cgo_vltplat();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String VPCODICE = "";
  String VPDESCRI = "";
  String VPFLGATT = "";
  String VPIDAAMS = "";
  double VPCODPIAT = 0;
  String VPSIGLAPIAT = "";
  String VPPROVENIENZA = "";
  double VPVLTCODPLAT = 0;
  String VPFLGCRYPTO = "";
  String VFPKAYCRYPTO = "";
  String VPDIRFILE = "";
  String VPFILEINTESTA1 = "";
  String VPFFILESPERATOR1 = "";
  String VPFILEFORDATA1 = "";
  String VPPREFFILE1 = "";
  String VPFILEINTESTA2 = "";
  String VPFFILESPERATOR2 = "";
  String VPFILEFORDATA2 = "";
  String VPPREFFILE2 = "";
  String VPFILEINTESTA3 = "";
  String VPFFILESPERATOR3 = "";
  String VPFILEFORDATA3 = "";
  String VPPREFFILE3 = "";
  String VPFLGPRESUF1 = "";
  String VPFLGPRESUF2 = "";
  String VPFLGPRESUF3 = "";
  String VPFLGCONVERSION = "";
  String VFPFLAGIMPORT = "";
  String VFPTIPOFILE1 = "";
  String VFPTIPOFILE2 = "";
  String VFPTIPOFILE3 = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(VPCODICE))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPDESCRI))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPFLGATT))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPIDAAMS))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPCODPIAT))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPSIGLAPIAT))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPPROVENIENZA))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPVLTCODPLAT))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPFLGCRYPTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(VFPKAYCRYPTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPDIRFILE))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPFILEINTESTA1))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPFFILESPERATOR1))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPFILEFORDATA1))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPPREFFILE1))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPFILEINTESTA2))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPFFILESPERATOR2))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPFILEFORDATA2))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPPREFFILE2))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPFILEINTESTA3))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPFFILESPERATOR3))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPFILEFORDATA3))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPPREFFILE3))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPFLGPRESUF1))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPFLGPRESUF2))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPFLGPRESUF3))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPFLGCONVERSION))) {
      return false;
    }
    if ( ! (CPLib.Empty(VFPFLAGIMPORT))) {
      return false;
    }
    if ( ! (CPLib.Empty(VFPTIPOFILE1))) {
      return false;
    }
    if ( ! (CPLib.Empty(VFPTIPOFILE2))) {
      return false;
    }
    if ( ! (CPLib.Empty(VFPTIPOFILE3))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_cgo_vltplat p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_cgo_vltplat.this.VPCODICE = copyAndCast(p_row.VPCODICE);
      MemoryCursorRow_cgo_vltplat.this.VPDESCRI = copyAndCast(p_row.VPDESCRI);
      MemoryCursorRow_cgo_vltplat.this.VPFLGATT = copyAndCast(p_row.VPFLGATT);
      MemoryCursorRow_cgo_vltplat.this.VPIDAAMS = copyAndCast(p_row.VPIDAAMS);
      MemoryCursorRow_cgo_vltplat.this.VPCODPIAT = copyAndCast(p_row.VPCODPIAT);
      MemoryCursorRow_cgo_vltplat.this.VPSIGLAPIAT = copyAndCast(p_row.VPSIGLAPIAT);
      MemoryCursorRow_cgo_vltplat.this.VPPROVENIENZA = copyAndCast(p_row.VPPROVENIENZA);
      MemoryCursorRow_cgo_vltplat.this.VPVLTCODPLAT = copyAndCast(p_row.VPVLTCODPLAT);
      MemoryCursorRow_cgo_vltplat.this.VPFLGCRYPTO = copyAndCast(p_row.VPFLGCRYPTO);
      MemoryCursorRow_cgo_vltplat.this.VFPKAYCRYPTO = copyAndCast(p_row.VFPKAYCRYPTO);
      MemoryCursorRow_cgo_vltplat.this.VPDIRFILE = copyAndCast(p_row.VPDIRFILE);
      MemoryCursorRow_cgo_vltplat.this.VPFILEINTESTA1 = copyAndCast(p_row.VPFILEINTESTA1);
      MemoryCursorRow_cgo_vltplat.this.VPFFILESPERATOR1 = copyAndCast(p_row.VPFFILESPERATOR1);
      MemoryCursorRow_cgo_vltplat.this.VPFILEFORDATA1 = copyAndCast(p_row.VPFILEFORDATA1);
      MemoryCursorRow_cgo_vltplat.this.VPPREFFILE1 = copyAndCast(p_row.VPPREFFILE1);
      MemoryCursorRow_cgo_vltplat.this.VPFILEINTESTA2 = copyAndCast(p_row.VPFILEINTESTA2);
      MemoryCursorRow_cgo_vltplat.this.VPFFILESPERATOR2 = copyAndCast(p_row.VPFFILESPERATOR2);
      MemoryCursorRow_cgo_vltplat.this.VPFILEFORDATA2 = copyAndCast(p_row.VPFILEFORDATA2);
      MemoryCursorRow_cgo_vltplat.this.VPPREFFILE2 = copyAndCast(p_row.VPPREFFILE2);
      MemoryCursorRow_cgo_vltplat.this.VPFILEINTESTA3 = copyAndCast(p_row.VPFILEINTESTA3);
      MemoryCursorRow_cgo_vltplat.this.VPFFILESPERATOR3 = copyAndCast(p_row.VPFFILESPERATOR3);
      MemoryCursorRow_cgo_vltplat.this.VPFILEFORDATA3 = copyAndCast(p_row.VPFILEFORDATA3);
      MemoryCursorRow_cgo_vltplat.this.VPPREFFILE3 = copyAndCast(p_row.VPPREFFILE3);
      MemoryCursorRow_cgo_vltplat.this.VPFLGPRESUF1 = copyAndCast(p_row.VPFLGPRESUF1);
      MemoryCursorRow_cgo_vltplat.this.VPFLGPRESUF2 = copyAndCast(p_row.VPFLGPRESUF2);
      MemoryCursorRow_cgo_vltplat.this.VPFLGPRESUF3 = copyAndCast(p_row.VPFLGPRESUF3);
      MemoryCursorRow_cgo_vltplat.this.VPFLGCONVERSION = copyAndCast(p_row.VPFLGCONVERSION);
      MemoryCursorRow_cgo_vltplat.this.VFPFLAGIMPORT = copyAndCast(p_row.VFPFLAGIMPORT);
      MemoryCursorRow_cgo_vltplat.this.VFPTIPOFILE1 = copyAndCast(p_row.VFPTIPOFILE1);
      MemoryCursorRow_cgo_vltplat.this.VFPTIPOFILE2 = copyAndCast(p_row.VFPTIPOFILE2);
      MemoryCursorRow_cgo_vltplat.this.VFPTIPOFILE3 = copyAndCast(p_row.VFPTIPOFILE3);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"VPCODICE","VPDESCRI","VPFLGATT","VPIDAAMS","VPCODPIAT","VPSIGLAPIAT","VPPROVENIENZA","VPVLTCODPLAT","VPFLGCRYPTO","VFPKAYCRYPTO","VPDIRFILE","VPFILEINTESTA1","VPFFILESPERATOR1","VPFILEFORDATA1","VPPREFFILE1","VPFILEINTESTA2","VPFFILESPERATOR2","VPFILEFORDATA2","VPPREFFILE2","VPFILEINTESTA3","VPFFILESPERATOR3","VPFILEFORDATA3","VPPREFFILE3","VPFLGPRESUF1","VPFLGPRESUF2","VPFLGPRESUF3","VPFLGCONVERSION","VFPFLAGIMPORT","VFPTIPOFILE1","VFPTIPOFILE2","VFPTIPOFILE3"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","N","C","C","N","C","M","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice","Descrizione","Piattaforma Attiva","ID AAMS","Codice Piasttaforma (da CSV)","Sigla Piattaforma","Provenienza","Codice Piattaforma VLT","File Crittografati","Chiave Crittografazione","Cartella File Import","Presenza riga intestazioni","Separatore campi","Formato Data","Prefisso file","Presenza riga intestazioni","Separatore campi","Formato Data","Prefisso file","Presenza riga intestazioni","Separatore campi","Formato Data","Prefisso file","Prefisso o Suffisso","Prefisso o Suffisso ","Prefisso o suffisso","File richiedono conversione campi","Piattaforma per import","Tipo File 1 (Struttura)","Tipo File 2 (Struttura)","Tipo File 3 (Struttura)"};
    return l_names;
  }
}
