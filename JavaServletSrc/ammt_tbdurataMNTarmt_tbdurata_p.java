public class ammt_tbdurataMNTarmt_tbdurata_p {
  public static String[][] m_Fkd={
    {"CODICE","CODICE"}
  };
  public static int order = 0;
  public static void CopyKeys(ammt_tbdurataBO parent,armt_tbdurata_pBO child) {
    child.w_CODICE = parent.w_CODICE;
  }
  public static String PageTitle() {
    return "Nuovo Indice";
  }
  public static String IncludeParentFunctions() {
    return "";
  }
  public static String CopyWorkVar() {
    return " if (!(ChildToLoad(FrameRef('armt_tbdurata_p'))) && typeof(FrameRef('armt_tbdurata_p').DoUpdate)!='undefined'){\n  if (typeof(FrameRef('armt_tbdurata_p').m_oTrs)!='undefined'){\n   FrameRef('armt_tbdurata_p').EnableEntity(false)\n  }\n  CopyWorkVar(FrameRef('armt_tbdurata_p'),['oldris'],['RISCHIO'],true);\n }\n";
  }
  public static String CopyWorkVarInit() {
    return "function SetChildVariables_armt_tbdurata_p(){\n if (!(ChildToLoad(FrameRef('armt_tbdurata_p'))) && typeof(FrameRef('armt_tbdurata_p').DoUpdate)!='undefined'){\n  if (typeof(FrameRef('armt_tbdurata_p').m_oTrs)!='undefined'){\n   FrameRef('armt_tbdurata_p').EnableEntity(false)\n  }\n  CopyWorkVar(FrameRef('armt_tbdurata_p'),['oldris'],['RISCHIO'],false);\n }\n}\n";
  }
  public static String DoQueryFromChild() {
    return "function DoQueryFrom_tbdurata_p(firstAlias){\n return m_cVirtName+'.CODICE = '+firstAlias+'.CODICE '\n}\n";
  }
  public static String MountingMode() {
    return "cbox";
  }
  public static String MountingModeBoxState() {
    return "";
  }
  public static String MountingBoxOnPage() {
    return "";
  }
  public static String MountingBoxOnTabbedGroup() {
    return "";
  }
  public static boolean RepeatedChild() {
    return false;
  }
  public static boolean CreateOnDemand() {
    return true;
  }
}
