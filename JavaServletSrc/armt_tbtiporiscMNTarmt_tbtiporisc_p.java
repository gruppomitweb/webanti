public class armt_tbtiporiscMNTarmt_tbtiporisc_p {
  public static String[][] m_Fkd={
    {"CODICE","CODICE"}
  };
  public static int order = 0;
  public static void CopyKeys(armt_tbtiporiscBO parent,armt_tbtiporisc_pBO child) {
    child.w_CODICE = parent.w_CODICE;
  }
  public static String PageTitle() {
    return "Nuovo Rischio";
  }
  public static String IncludeParentFunctions() {
    return "";
  }
  public static String CopyWorkVar() {
    return " if (!(ChildToLoad(FrameRef('armt_tbtiporisc_p'))) && typeof(FrameRef('armt_tbtiporisc_p').DoUpdate)!='undefined'){\n  if (typeof(FrameRef('armt_tbtiporisc_p').m_oTrs)!='undefined'){\n   FrameRef('armt_tbtiporisc_p').EnableEntity(false)\n  }\n  CopyWorkVar(FrameRef('armt_tbtiporisc_p'),['oldris'],['RISCHIO'],true);\n }\n";
  }
  public static String CopyWorkVarInit() {
    return "function SetChildVariables_armt_tbtiporisc_p(){\n if (!(ChildToLoad(FrameRef('armt_tbtiporisc_p'))) && typeof(FrameRef('armt_tbtiporisc_p').DoUpdate)!='undefined'){\n  if (typeof(FrameRef('armt_tbtiporisc_p').m_oTrs)!='undefined'){\n   FrameRef('armt_tbtiporisc_p').EnableEntity(false)\n  }\n  CopyWorkVar(FrameRef('armt_tbtiporisc_p'),['oldris'],['RISCHIO'],false);\n }\n}\n";
  }
  public static String DoQueryFromChild() {
    return "function DoQueryFrom_tbtiporisc_p(firstAlias){\n return m_cVirtName+'.CODICE = '+firstAlias+'.CODICE '\n}\n";
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
