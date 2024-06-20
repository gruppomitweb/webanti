public class armt_tbspecieMNTarmt_tbspecie_p {
  public static String[][] m_Fkd={
    {"CODSPE","CODSPE"}
  };
  public static int order = 0;
  public static void CopyKeys(armt_tbspecieBO parent,armt_tbspecie_pBO child) {
    child.w_CODSPE = parent.w_CODSPE;
  }
  public static String PageTitle() {
    return "Nuovo Rischio";
  }
  public static String IncludeParentFunctions() {
    return "";
  }
  public static String CopyWorkVar() {
    return " if (!(ChildToLoad(FrameRef('armt_tbspecie_p'))) && typeof(FrameRef('armt_tbspecie_p').DoUpdate)!='undefined'){\n  if (typeof(FrameRef('armt_tbspecie_p').m_oTrs)!='undefined'){\n   FrameRef('armt_tbspecie_p').EnableEntity(false)\n  }\n  CopyWorkVar(FrameRef('armt_tbspecie_p'),['oldris'],['RISCHIO'],true);\n }\n";
  }
  public static String CopyWorkVarInit() {
    return "function SetChildVariables_armt_tbspecie_p(){\n if (!(ChildToLoad(FrameRef('armt_tbspecie_p'))) && typeof(FrameRef('armt_tbspecie_p').DoUpdate)!='undefined'){\n  if (typeof(FrameRef('armt_tbspecie_p').m_oTrs)!='undefined'){\n   FrameRef('armt_tbspecie_p').EnableEntity(false)\n  }\n  CopyWorkVar(FrameRef('armt_tbspecie_p'),['oldris'],['RISCHIO'],false);\n }\n}\n";
  }
  public static String DoQueryFromChild() {
    return "function DoQueryFrom_tbspecie_p(firstAlias){\n return m_cVirtName+'.CODSPE = '+firstAlias+'.CODSPE '\n}\n";
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
