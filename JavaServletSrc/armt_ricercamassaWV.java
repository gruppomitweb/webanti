public class armt_ricercamassaWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public double w_attsel;
  public String w_G11;
  public String w_G13;
  public String w_G14A;
  public String w_G14B;
  public String w_G14C;
  public String w_G15;
  public String w_G16;
  public String w_G17;
  public java.sql.Date w_G18;
  public String w_G19A;
  public String w_G19B;
  public String w_G41;
  public String w_G42;
  public java.sql.Date w_G43;
  public String w_G44;
  public String w_F11;
  public String w_F13;
  public String w_F14A;
  public String w_F14B;
  public String w_F14C;
  public String w_F15;
  public String w_F16;
  public String w_F17;
  public String w_E11;
  public String w_E13;
  public String w_E14A;
  public String w_E14B;
  public String w_E14C;
  public String w_E15;
  public String w_E16;
  public String w_E17;
  public java.sql.Date w_E18;
  public String w_E19A;
  public String w_E19B;
  public String w_E41;
  public String w_E42;
  public java.sql.Date w_E43;
  public String w_E44;
  public String w_D11;
  public String w_D13;
  public String w_D14A;
  public String w_D14B;
  public String w_D14C;
  public String w_D15;
  public String w_D16;
  public String w_D17;
  public java.sql.Date w_D18;
  public String w_D19A;
  public String w_D19B;
  public String w_D21;
  public String w_D22;
  public String w_D23;
  public String w_D41;
  public String w_D42;
  public java.sql.Date w_D43;
  public String w_D44;
  public String w_C11;
  public String w_C21;
  public String w_C31;
  public String w_B11;
  public String w_B12;
  public String w_B13;
  public double w_B14;
  public double w_B15;
  public String w_X_B14_OP;
  public String w_X_B15_OP;
  public String w_A01A;
  public String w_A01B;
  public String w_A03;
  public String w_A11;
  public String w_A12A;
  public String w_A12B;
  public String w_A12C;
  public java.sql.Date w_A21;
  public double w_A22;
  public String w_A23;
  public String w_A24;
  public String w_A25;
  public String w_A31A;
  public String w_A31B;
  public String w_A32;
  public String w_A33A;
  public String w_A33B;
  public String w_A33C;
  public String w_A34;
  public String w_A41;
  public String w_A42;
  public String w_A43;
  public java.sql.Date w_A51;
  public String w_A52B;
  public String w_A53;
  public String w_A54A;
  public java.sql.Date w_A54B;
  public String w_A54C;
  public String w_IDBASE;
  //   variabile per il progressivo
  public String op_IDBASE;
  public String w_archivio;
  public String w_C41;
  public String w_C51;
  public String w_H11;
  public String w_H13;
  public String w_H14A;
  public String w_H14B;
  public String w_H14C;
  public String w_H15;
  public String w_H16;
  public String w_H17;
  public java.sql.Date w_H18;
  public String w_H19A;
  public String w_H19B;
  public String w_H41;
  public String w_H42;
  public java.sql.Date w_H43;
  public String w_H44;
  public String w_D45;
  public String w_E45;
  public String w_G45;
  public String w_H45;
  public double w_richieste;
  public String w_xdestipdoct;
  public String w_xdestipdocsg;
  public String w_xdessoteco;
  public String w_xdesramgrp;
  public String w_xdessetsin;
  public String w_xdestipdoc;
  public String w_xragintes;
  public String w_xragsogope;
  public String w_xragbenef;
  public String w_xdesval;
  public String w_xraginter;
  public String w_xdesdip;
  public String w_xdescittab;
  public String w_xtipleg;
  public String w_xdesrap;
  public String w_oldval;
  public String w_xragsecond;
  public String w_xragterzo;
  public String w_xdestipdoct1;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabili per DependsOn
  public String o_A01A;
  public String o_A01B;
  public String o_A03;
  public String o_A11;
  public String o_A12A;
  public String o_A12B;
  public String o_A12C;
  public java.sql.Date o_A21;
  public double o_A22;
  public String o_A23;
  public String o_A24;
  public String o_A25;
  public String o_A31A;
  public String o_A31B;
  public String o_A32;
  public String o_A33A;
  public String o_A33B;
  public String o_A33C;
  public String o_A34;
  public String o_A41;
  public String o_A42;
  public String o_A43;
  public java.sql.Date o_A51;
  public String o_A52B;
  public String o_A53;
  public String o_A54A;
  public java.sql.Date o_A54B;
  public String o_A54C;
  public String o_B11;
  public String o_B12;
  public String o_B13;
  public double o_B14;
  public double o_B15;
  public String o_C11;
  public String o_C21;
  public String o_C31;
  public String o_D11;
  public String o_D13;
  public String o_D14A;
  public String o_D14B;
  public String o_D14C;
  public String o_D15;
  public String o_D16;
  public String o_D17;
  public java.sql.Date o_D18;
  public String o_D19A;
  public String o_D19B;
  public String o_D21;
  public String o_D22;
  public String o_D23;
  public String o_D41;
  public String o_D42;
  public java.sql.Date o_D43;
  public String o_D44;
  public String o_D45;
  public String o_E11;
  public String o_E13;
  public String o_E14A;
  public String o_E14B;
  public String o_E14C;
  public String o_E15;
  public String o_E16;
  public String o_E17;
  public java.sql.Date o_E18;
  public String o_E19A;
  public String o_E19B;
  public String o_E41;
  public String o_E42;
  public java.sql.Date o_E43;
  public String o_E44;
  public String o_E45;
  public String o_F11;
  public String o_F13;
  public String o_F14A;
  public String o_F14B;
  public String o_F14C;
  public String o_F15;
  public String o_F16;
  public String o_F17;
  public String o_G11;
  public String o_G13;
  public String o_G14A;
  public String o_G14B;
  public String o_G14C;
  public String o_G15;
  public String o_G16;
  public String o_G17;
  public java.sql.Date o_G18;
  public String o_G19A;
  public String o_G19B;
  public String o_G41;
  public String o_G42;
  public java.sql.Date o_G43;
  public String o_G44;
  public String o_G45;
  public String o_H11;
  public String o_H13;
  public String o_H14A;
  public String o_H14B;
  public String o_H14C;
  public String o_H15;
  public String o_H16;
  public String o_H17;
  public java.sql.Date o_H18;
  public String o_H19A;
  public String o_H19B;
  public String o_H41;
  public String o_H42;
  public java.sql.Date o_H43;
  public String o_H44;
  public String o_H45;
  // variabile contenente i valori per i campi aggiunti e le propriet� dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}