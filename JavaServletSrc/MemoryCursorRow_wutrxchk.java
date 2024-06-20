public class MemoryCursorRow_wutrxchk extends CPMemoryCursorRow {
  public MemoryCursorRow_wutrxchk() {
  }
  public MemoryCursorRow_wutrxchk(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_wutrxchk toBuild = new MemoryCursor_wutrxchk(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_wutrxchk toBuild = new MemoryCursor_wutrxchk();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  double TRXCODPRG = 0;
  String TRXCOGNOM = "";
  String TRXNOME = "";
  String TRXDOMICI = "";
  String TRXFLGCF = "";
  String TRXCODFIS = "";
  String TRXLUONAS = "";
  String TRXNUMDOC = "";
  java.sql.Date TRXDATSCA = CPLib.NullDate();
  java.sql.Date TRXDATRIL = CPLib.NullDate();
  String TRXAUTRIL = "";
  String TRXNAZRES = "";
  String TRXCITRES = "";
  String TRXTIPDOC = "";
  java.sql.Date TRXDATOPE = CPLib.NullDate();
  String TRXFLGCON = "";
  String TRSSEGNO = "";
  double TRXIMPORTO = 0;
  double TRXCONTAN = 0;
  String TRXUNIQUE = "";
  String TRXCODDIP = "";
  String TRXCOGCON = "";
  String TRXNOMCON = "";
  String TRXDESTIN = "";
  String TRXMTCN = "";
  java.sql.Date TRXDATNAS = CPLib.NullDate();
  String TRXSESSO = "";
  String TRXCODCAS = "";
  String TRXRECTYPE = "";
  String TRXCODMAG = "";
  String TRXCODUNI = "";
  String TRXERROR01 = "";
  String TRXERROR02 = "";
  String TRXERROR03 = "";
  String TRXERROR04 = "";
  String TRXERROR05 = "";
  String TRXERROR06 = "";
  String TRXERROR07 = "";
  String TRXERROR08 = "";
  String TRXERROR09 = "";
  String TRXERROR10 = "";
  String TRXERROR11 = "";
  String TRXERROR12 = "";
  String TRXERROR13 = "";
  String TRXERROR14 = "";
  String TRXERROR15 = "";
  String TRXERROR16 = "";
  String TRXERROR17 = "";
  String TRXERROR18 = "";
  String TRXERROR19 = "";
  String TRXERROR20 = "";
  String TRXERROR21 = "";
  String TRXERROR22 = "";
  String TRXERROR23 = "";
  String TRXERROR24 = "";
  String TRXERROR25 = "";
  String TRXERROR26 = "";
  String TRXERROR27 = "";
  String TRXERROR28 = "";
  String TRXERROR29 = "";
  String TRXERROR30 = "";
  String TRXERROR31 = "";
  String TRXERROR32 = "";
  String TRXERROR33 = "";
  String TRXERROR34 = "";
  String TRXERROR35 = "";
  String TRXERROR36 = "";
  String TRXERROR37 = "";
  String TRXERROR38 = "";
  String TRXERROR39 = "";
  String TRXERROR40 = "";
  String TRXERROR41 = "";
  String TRXERROR42 = "";
  String TRXERROR43 = "";
  String TRXERROR44 = "";
  String TRXERROR45 = "";
  String TRXERROR46 = "";
  String TRXERROR47 = "";
  String TRXERROR48 = "";
  String TRXERROR49 = "";
  String TRXERROR50 = "";
  String TRXERRAUA01 = "";
  String TRXERRAUA02 = "";
  String TRXERRAUA03 = "";
  String TRXERRAUA04 = "";
  String TRXERRAUA05 = "";
  String TRXERRAUA06 = "";
  String TRXERRAUA07 = "";
  String TRXERRAUA08 = "";
  String TRXERRAUA09 = "";
  String TRXERRAUA10 = "";
  String TRXFLGAUI = "";
  String TRXFLGAUA = "";
  String TRXFLGFOR = "";
  String TRXAUICHK = "";
  String TRXAUACHK = "";
  String TRXNOTEOPER = "";
  String TRXFORCE = "";
  String TRXNASSTATO = "";
  String TRXNASCOMUN = "";
  String TRXFLGAUAQ1 = "";
  String TRXFLGAUAQ2 = "";
  String TRXFLGAUAQ3 = "";
  String TRXFLGAUAQ4 = "";
  String TRXFLGAUAQ5 = "";
  java.sql.Date TRXDATRICERCA = CPLib.NullDate();
  double TRXUTENTE = 0;
  java.sql.Timestamp TRXTINILAV = CPLib.NullDateTime();
  java.sql.Timestamp TRXTFINLAV = CPLib.NullDateTime();
  java.sql.Date TRXDINILAV = CPLib.NullDate();
  java.sql.Date TRDFINLAV = CPLib.NullDate();
  String TRFLGINLAV = "";
  double TRXNUMRIL = 0;
  java.sql.Date TRXSCAEDT = CPLib.NullDate();
  String TRXESITO = "";
  String TRXDERIVATA = "";
  String TRXGALACTIC = "";
  String TRXNAZRIL = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(TRXCODPRG))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXCOGNOM))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXNOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXDOMICI))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXFLGCF))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXCODFIS))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXLUONAS))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXNUMDOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXDATSCA))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXDATRIL))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXAUTRIL))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXNAZRES))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXCITRES))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXTIPDOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXDATOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXFLGCON))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRSSEGNO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXIMPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXCONTAN))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXUNIQUE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXCODDIP))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXCOGCON))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXNOMCON))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXDESTIN))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXMTCN))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXDATNAS))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXSESSO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXCODCAS))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXRECTYPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXCODMAG))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXCODUNI))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR01))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR02))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR03))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR04))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR05))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR06))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR07))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR08))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR09))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR10))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR11))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR12))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR13))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR14))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR15))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR16))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR17))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR18))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR19))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR20))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR21))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR22))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR23))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR24))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR25))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR26))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR27))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR28))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR29))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR30))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR31))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR32))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR33))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR34))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR35))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR36))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR37))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR38))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR39))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR40))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR41))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR42))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR43))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR44))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR45))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR46))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR47))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR48))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR49))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERROR50))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERRAUA01))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERRAUA02))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERRAUA03))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERRAUA04))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERRAUA05))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERRAUA06))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERRAUA07))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERRAUA08))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERRAUA09))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXERRAUA10))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXFLGAUI))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXFLGAUA))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXFLGFOR))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXAUICHK))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXAUACHK))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXNOTEOPER))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXFORCE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXNASSTATO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXNASCOMUN))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXFLGAUAQ1))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXFLGAUAQ2))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXFLGAUAQ3))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXFLGAUAQ4))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXFLGAUAQ5))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXDATRICERCA))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXUTENTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXTINILAV))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXTFINLAV))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXDINILAV))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRDFINLAV))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRFLGINLAV))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXNUMRIL))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXSCAEDT))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXESITO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXDERIVATA))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXGALACTIC))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXNAZRIL))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_wutrxchk p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_wutrxchk.this.TRXCODPRG = copyAndCast(p_row.TRXCODPRG);
      MemoryCursorRow_wutrxchk.this.TRXCOGNOM = copyAndCast(p_row.TRXCOGNOM);
      MemoryCursorRow_wutrxchk.this.TRXNOME = copyAndCast(p_row.TRXNOME);
      MemoryCursorRow_wutrxchk.this.TRXDOMICI = copyAndCast(p_row.TRXDOMICI);
      MemoryCursorRow_wutrxchk.this.TRXFLGCF = copyAndCast(p_row.TRXFLGCF);
      MemoryCursorRow_wutrxchk.this.TRXCODFIS = copyAndCast(p_row.TRXCODFIS);
      MemoryCursorRow_wutrxchk.this.TRXLUONAS = copyAndCast(p_row.TRXLUONAS);
      MemoryCursorRow_wutrxchk.this.TRXNUMDOC = copyAndCast(p_row.TRXNUMDOC);
      MemoryCursorRow_wutrxchk.this.TRXDATSCA = copyAndCast(p_row.TRXDATSCA);
      MemoryCursorRow_wutrxchk.this.TRXDATRIL = copyAndCast(p_row.TRXDATRIL);
      MemoryCursorRow_wutrxchk.this.TRXAUTRIL = copyAndCast(p_row.TRXAUTRIL);
      MemoryCursorRow_wutrxchk.this.TRXNAZRES = copyAndCast(p_row.TRXNAZRES);
      MemoryCursorRow_wutrxchk.this.TRXCITRES = copyAndCast(p_row.TRXCITRES);
      MemoryCursorRow_wutrxchk.this.TRXTIPDOC = copyAndCast(p_row.TRXTIPDOC);
      MemoryCursorRow_wutrxchk.this.TRXDATOPE = copyAndCast(p_row.TRXDATOPE);
      MemoryCursorRow_wutrxchk.this.TRXFLGCON = copyAndCast(p_row.TRXFLGCON);
      MemoryCursorRow_wutrxchk.this.TRSSEGNO = copyAndCast(p_row.TRSSEGNO);
      MemoryCursorRow_wutrxchk.this.TRXIMPORTO = copyAndCast(p_row.TRXIMPORTO);
      MemoryCursorRow_wutrxchk.this.TRXCONTAN = copyAndCast(p_row.TRXCONTAN);
      MemoryCursorRow_wutrxchk.this.TRXUNIQUE = copyAndCast(p_row.TRXUNIQUE);
      MemoryCursorRow_wutrxchk.this.TRXCODDIP = copyAndCast(p_row.TRXCODDIP);
      MemoryCursorRow_wutrxchk.this.TRXCOGCON = copyAndCast(p_row.TRXCOGCON);
      MemoryCursorRow_wutrxchk.this.TRXNOMCON = copyAndCast(p_row.TRXNOMCON);
      MemoryCursorRow_wutrxchk.this.TRXDESTIN = copyAndCast(p_row.TRXDESTIN);
      MemoryCursorRow_wutrxchk.this.TRXMTCN = copyAndCast(p_row.TRXMTCN);
      MemoryCursorRow_wutrxchk.this.TRXDATNAS = copyAndCast(p_row.TRXDATNAS);
      MemoryCursorRow_wutrxchk.this.TRXSESSO = copyAndCast(p_row.TRXSESSO);
      MemoryCursorRow_wutrxchk.this.TRXCODCAS = copyAndCast(p_row.TRXCODCAS);
      MemoryCursorRow_wutrxchk.this.TRXRECTYPE = copyAndCast(p_row.TRXRECTYPE);
      MemoryCursorRow_wutrxchk.this.TRXCODMAG = copyAndCast(p_row.TRXCODMAG);
      MemoryCursorRow_wutrxchk.this.TRXCODUNI = copyAndCast(p_row.TRXCODUNI);
      MemoryCursorRow_wutrxchk.this.TRXERROR01 = copyAndCast(p_row.TRXERROR01);
      MemoryCursorRow_wutrxchk.this.TRXERROR02 = copyAndCast(p_row.TRXERROR02);
      MemoryCursorRow_wutrxchk.this.TRXERROR03 = copyAndCast(p_row.TRXERROR03);
      MemoryCursorRow_wutrxchk.this.TRXERROR04 = copyAndCast(p_row.TRXERROR04);
      MemoryCursorRow_wutrxchk.this.TRXERROR05 = copyAndCast(p_row.TRXERROR05);
      MemoryCursorRow_wutrxchk.this.TRXERROR06 = copyAndCast(p_row.TRXERROR06);
      MemoryCursorRow_wutrxchk.this.TRXERROR07 = copyAndCast(p_row.TRXERROR07);
      MemoryCursorRow_wutrxchk.this.TRXERROR08 = copyAndCast(p_row.TRXERROR08);
      MemoryCursorRow_wutrxchk.this.TRXERROR09 = copyAndCast(p_row.TRXERROR09);
      MemoryCursorRow_wutrxchk.this.TRXERROR10 = copyAndCast(p_row.TRXERROR10);
      MemoryCursorRow_wutrxchk.this.TRXERROR11 = copyAndCast(p_row.TRXERROR11);
      MemoryCursorRow_wutrxchk.this.TRXERROR12 = copyAndCast(p_row.TRXERROR12);
      MemoryCursorRow_wutrxchk.this.TRXERROR13 = copyAndCast(p_row.TRXERROR13);
      MemoryCursorRow_wutrxchk.this.TRXERROR14 = copyAndCast(p_row.TRXERROR14);
      MemoryCursorRow_wutrxchk.this.TRXERROR15 = copyAndCast(p_row.TRXERROR15);
      MemoryCursorRow_wutrxchk.this.TRXERROR16 = copyAndCast(p_row.TRXERROR16);
      MemoryCursorRow_wutrxchk.this.TRXERROR17 = copyAndCast(p_row.TRXERROR17);
      MemoryCursorRow_wutrxchk.this.TRXERROR18 = copyAndCast(p_row.TRXERROR18);
      MemoryCursorRow_wutrxchk.this.TRXERROR19 = copyAndCast(p_row.TRXERROR19);
      MemoryCursorRow_wutrxchk.this.TRXERROR20 = copyAndCast(p_row.TRXERROR20);
      MemoryCursorRow_wutrxchk.this.TRXERROR21 = copyAndCast(p_row.TRXERROR21);
      MemoryCursorRow_wutrxchk.this.TRXERROR22 = copyAndCast(p_row.TRXERROR22);
      MemoryCursorRow_wutrxchk.this.TRXERROR23 = copyAndCast(p_row.TRXERROR23);
      MemoryCursorRow_wutrxchk.this.TRXERROR24 = copyAndCast(p_row.TRXERROR24);
      MemoryCursorRow_wutrxchk.this.TRXERROR25 = copyAndCast(p_row.TRXERROR25);
      MemoryCursorRow_wutrxchk.this.TRXERROR26 = copyAndCast(p_row.TRXERROR26);
      MemoryCursorRow_wutrxchk.this.TRXERROR27 = copyAndCast(p_row.TRXERROR27);
      MemoryCursorRow_wutrxchk.this.TRXERROR28 = copyAndCast(p_row.TRXERROR28);
      MemoryCursorRow_wutrxchk.this.TRXERROR29 = copyAndCast(p_row.TRXERROR29);
      MemoryCursorRow_wutrxchk.this.TRXERROR30 = copyAndCast(p_row.TRXERROR30);
      MemoryCursorRow_wutrxchk.this.TRXERROR31 = copyAndCast(p_row.TRXERROR31);
      MemoryCursorRow_wutrxchk.this.TRXERROR32 = copyAndCast(p_row.TRXERROR32);
      MemoryCursorRow_wutrxchk.this.TRXERROR33 = copyAndCast(p_row.TRXERROR33);
      MemoryCursorRow_wutrxchk.this.TRXERROR34 = copyAndCast(p_row.TRXERROR34);
      MemoryCursorRow_wutrxchk.this.TRXERROR35 = copyAndCast(p_row.TRXERROR35);
      MemoryCursorRow_wutrxchk.this.TRXERROR36 = copyAndCast(p_row.TRXERROR36);
      MemoryCursorRow_wutrxchk.this.TRXERROR37 = copyAndCast(p_row.TRXERROR37);
      MemoryCursorRow_wutrxchk.this.TRXERROR38 = copyAndCast(p_row.TRXERROR38);
      MemoryCursorRow_wutrxchk.this.TRXERROR39 = copyAndCast(p_row.TRXERROR39);
      MemoryCursorRow_wutrxchk.this.TRXERROR40 = copyAndCast(p_row.TRXERROR40);
      MemoryCursorRow_wutrxchk.this.TRXERROR41 = copyAndCast(p_row.TRXERROR41);
      MemoryCursorRow_wutrxchk.this.TRXERROR42 = copyAndCast(p_row.TRXERROR42);
      MemoryCursorRow_wutrxchk.this.TRXERROR43 = copyAndCast(p_row.TRXERROR43);
      MemoryCursorRow_wutrxchk.this.TRXERROR44 = copyAndCast(p_row.TRXERROR44);
      MemoryCursorRow_wutrxchk.this.TRXERROR45 = copyAndCast(p_row.TRXERROR45);
      MemoryCursorRow_wutrxchk.this.TRXERROR46 = copyAndCast(p_row.TRXERROR46);
      MemoryCursorRow_wutrxchk.this.TRXERROR47 = copyAndCast(p_row.TRXERROR47);
      MemoryCursorRow_wutrxchk.this.TRXERROR48 = copyAndCast(p_row.TRXERROR48);
      MemoryCursorRow_wutrxchk.this.TRXERROR49 = copyAndCast(p_row.TRXERROR49);
      MemoryCursorRow_wutrxchk.this.TRXERROR50 = copyAndCast(p_row.TRXERROR50);
      MemoryCursorRow_wutrxchk.this.TRXERRAUA01 = copyAndCast(p_row.TRXERRAUA01);
      MemoryCursorRow_wutrxchk.this.TRXERRAUA02 = copyAndCast(p_row.TRXERRAUA02);
      MemoryCursorRow_wutrxchk.this.TRXERRAUA03 = copyAndCast(p_row.TRXERRAUA03);
      MemoryCursorRow_wutrxchk.this.TRXERRAUA04 = copyAndCast(p_row.TRXERRAUA04);
      MemoryCursorRow_wutrxchk.this.TRXERRAUA05 = copyAndCast(p_row.TRXERRAUA05);
      MemoryCursorRow_wutrxchk.this.TRXERRAUA06 = copyAndCast(p_row.TRXERRAUA06);
      MemoryCursorRow_wutrxchk.this.TRXERRAUA07 = copyAndCast(p_row.TRXERRAUA07);
      MemoryCursorRow_wutrxchk.this.TRXERRAUA08 = copyAndCast(p_row.TRXERRAUA08);
      MemoryCursorRow_wutrxchk.this.TRXERRAUA09 = copyAndCast(p_row.TRXERRAUA09);
      MemoryCursorRow_wutrxchk.this.TRXERRAUA10 = copyAndCast(p_row.TRXERRAUA10);
      MemoryCursorRow_wutrxchk.this.TRXFLGAUI = copyAndCast(p_row.TRXFLGAUI);
      MemoryCursorRow_wutrxchk.this.TRXFLGAUA = copyAndCast(p_row.TRXFLGAUA);
      MemoryCursorRow_wutrxchk.this.TRXFLGFOR = copyAndCast(p_row.TRXFLGFOR);
      MemoryCursorRow_wutrxchk.this.TRXAUICHK = copyAndCast(p_row.TRXAUICHK);
      MemoryCursorRow_wutrxchk.this.TRXAUACHK = copyAndCast(p_row.TRXAUACHK);
      MemoryCursorRow_wutrxchk.this.TRXNOTEOPER = copyAndCast(p_row.TRXNOTEOPER);
      MemoryCursorRow_wutrxchk.this.TRXFORCE = copyAndCast(p_row.TRXFORCE);
      MemoryCursorRow_wutrxchk.this.TRXNASSTATO = copyAndCast(p_row.TRXNASSTATO);
      MemoryCursorRow_wutrxchk.this.TRXNASCOMUN = copyAndCast(p_row.TRXNASCOMUN);
      MemoryCursorRow_wutrxchk.this.TRXFLGAUAQ1 = copyAndCast(p_row.TRXFLGAUAQ1);
      MemoryCursorRow_wutrxchk.this.TRXFLGAUAQ2 = copyAndCast(p_row.TRXFLGAUAQ2);
      MemoryCursorRow_wutrxchk.this.TRXFLGAUAQ3 = copyAndCast(p_row.TRXFLGAUAQ3);
      MemoryCursorRow_wutrxchk.this.TRXFLGAUAQ4 = copyAndCast(p_row.TRXFLGAUAQ4);
      MemoryCursorRow_wutrxchk.this.TRXFLGAUAQ5 = copyAndCast(p_row.TRXFLGAUAQ5);
      MemoryCursorRow_wutrxchk.this.TRXDATRICERCA = copyAndCast(p_row.TRXDATRICERCA);
      MemoryCursorRow_wutrxchk.this.TRXUTENTE = copyAndCast(p_row.TRXUTENTE);
      MemoryCursorRow_wutrxchk.this.TRXTINILAV = copyAndCast(p_row.TRXTINILAV);
      MemoryCursorRow_wutrxchk.this.TRXTFINLAV = copyAndCast(p_row.TRXTFINLAV);
      MemoryCursorRow_wutrxchk.this.TRXDINILAV = copyAndCast(p_row.TRXDINILAV);
      MemoryCursorRow_wutrxchk.this.TRDFINLAV = copyAndCast(p_row.TRDFINLAV);
      MemoryCursorRow_wutrxchk.this.TRFLGINLAV = copyAndCast(p_row.TRFLGINLAV);
      MemoryCursorRow_wutrxchk.this.TRXNUMRIL = copyAndCast(p_row.TRXNUMRIL);
      MemoryCursorRow_wutrxchk.this.TRXSCAEDT = copyAndCast(p_row.TRXSCAEDT);
      MemoryCursorRow_wutrxchk.this.TRXESITO = copyAndCast(p_row.TRXESITO);
      MemoryCursorRow_wutrxchk.this.TRXDERIVATA = copyAndCast(p_row.TRXDERIVATA);
      MemoryCursorRow_wutrxchk.this.TRXGALACTIC = copyAndCast(p_row.TRXGALACTIC);
      MemoryCursorRow_wutrxchk.this.TRXNAZRIL = copyAndCast(p_row.TRXNAZRIL);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"TRXCODPRG","TRXCOGNOM","TRXNOME","TRXDOMICI","TRXFLGCF","TRXCODFIS","TRXLUONAS","TRXNUMDOC","TRXDATSCA","TRXDATRIL","TRXAUTRIL","TRXNAZRES","TRXCITRES","TRXTIPDOC","TRXDATOPE","TRXFLGCON","TRSSEGNO","TRXIMPORTO","TRXCONTAN","TRXUNIQUE","TRXCODDIP","TRXCOGCON","TRXNOMCON","TRXDESTIN","TRXMTCN","TRXDATNAS","TRXSESSO","TRXCODCAS","TRXRECTYPE","TRXCODMAG","TRXCODUNI","TRXERROR01","TRXERROR02","TRXERROR03","TRXERROR04","TRXERROR05","TRXERROR06","TRXERROR07","TRXERROR08","TRXERROR09","TRXERROR10","TRXERROR11","TRXERROR12","TRXERROR13","TRXERROR14","TRXERROR15","TRXERROR16","TRXERROR17","TRXERROR18","TRXERROR19","TRXERROR20","TRXERROR21","TRXERROR22","TRXERROR23","TRXERROR24","TRXERROR25","TRXERROR26","TRXERROR27","TRXERROR28","TRXERROR29","TRXERROR30","TRXERROR31","TRXERROR32","TRXERROR33","TRXERROR34","TRXERROR35","TRXERROR36","TRXERROR37","TRXERROR38","TRXERROR39","TRXERROR40","TRXERROR41","TRXERROR42","TRXERROR43","TRXERROR44","TRXERROR45","TRXERROR46","TRXERROR47","TRXERROR48","TRXERROR49","TRXERROR50","TRXERRAUA01","TRXERRAUA02","TRXERRAUA03","TRXERRAUA04","TRXERRAUA05","TRXERRAUA06","TRXERRAUA07","TRXERRAUA08","TRXERRAUA09","TRXERRAUA10","TRXFLGAUI","TRXFLGAUA","TRXFLGFOR","TRXAUICHK","TRXAUACHK","TRXNOTEOPER","TRXFORCE","TRXNASSTATO","TRXNASCOMUN","TRXFLGAUAQ1","TRXFLGAUAQ2","TRXFLGAUAQ3","TRXFLGAUAQ4","TRXFLGAUAQ5","TRXDATRICERCA","TRXUTENTE","TRXTINILAV","TRXTFINLAV","TRXDINILAV","TRDFINLAV","TRFLGINLAV","TRXNUMRIL","TRXSCAEDT","TRXESITO","TRXDERIVATA","TRXGALACTIC","TRXNAZRIL"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"N","C","C","C","C","C","C","C","D","D","C","C","C","C","D","C","C","N","N","C","C","C","C","C","C","D","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","M","C","C","C","C","C","C","C","C","D","N","T","T","D","D","C","N","D","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"ID Transazione","Cognome","Nome","Domicilio","Flag Codice Fiscale","Codice Ficale (reale)","Luogo di nascita","Numero Documento","Data Scadenza Documento","Data Rilascio Documento","Autorità Rilascio Documento","Nazione di Residenza","Città Di residenza","Tipo Documento","Data Operazione","Flag Contanti","Segno (A=Send,D=Receive)","Importo","Contante","Unique ID","Codice Agenzia","Cognome Controparte","Nome Controparte","Stato Controparte","MTCN Operazione","Data Di Nascita","Sesso","Codice Catastale","Tipo Record","Codice MacroAgente","Codice Univoco","Errore 1","Errore 2","Errore 3","Errore 4","Errore 5","Errore 6","Errore 7","Errore 8","Errore 9","Errore 10","Errore 11","Errore 12","Errore 13","Errore 14","Errore 15","Errore 16","Errore 17","Errore 18","Errore 19","Errore 20","Errore 21","Errore 22","Errore 23","Errore 24","Errore 25","Errore 26","Errore27","Errore 28","Errore 29","Errore 30","Errore 31","Errore 32","Errore 33","Errore 34","Errore 35","Errore 36","Errore 37","Errore 38","Errore 39","Errore 40","Errore 41","Errore 42","Errore 43","Errore 44","Errore 45","Errore 46","Errore 47","Errore 48","Errore 49","Errore 50","Errore AUA 1","Errore AUA 2","Errore AUA 3","Errore AUA 4","Errore AUA 5","Errore AUA 6","Errore AUA 7","Errore AUA 8","Errore AUA 9","Errore AUA 10","OPERAZIONE CORRETTA AUI","OPERAZIONE CORRETTA AUA","FORZATURA INSERIMENTO","Check AUI Passato","Check AUA Passato","Note operative","Motivazione Forzatura","Stato Nascita da Codice Fiscale","Comune Nascita da Codice Fiscale","Errori su Query 1","Errori su Query 2","Errori su Query 3","Errori su Query 4","Errori su Query 3bis","Data Filtro 12 Mesi","Codice Utente che lavora la transazione","Ora Inizio Lavorazione","Ora Fine Lavorazione","Data Inizio Lavorazione","Data Fine Lavorazione","IN lavorazione","Numero di rilievi presenti","Scadenza Transazione","Tipo Esito","Correzione Derivata","Galactic ID (Se funziona)","Nazione Rilascio Documento"};
    return l_names;
  }
}
