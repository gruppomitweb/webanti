public class spadministration_companiesMNTarmt_cpazi_add {
  public static String[][] m_Fkd={
    {"codazi","codazi"}
  };
  public static int order = 0;
  public static void CopyKeys(spadministration_companiesBO parent,armt_cpazi_addBO child) {
    child.w_codazi = parent.w_codazi;
  }
  public static String PageTitle() {
    return "Dati Aggiuntivi";
  }
  public static String IncludeParentFunctions() {
    return "";
  }
  public static String CopyWorkVar() {
    return "";
  }
  public static String CopyWorkVarInit() {
    return "function SetChildVariables_armt_cpazi_add(){\n}\n";
  }
  public static String DoQueryFromChild() {
    return "function DoQueryFrom_cpazi_add(firstAlias){\n return m_cVirtName+'.codazi = '+firstAlias+'.codazi '\n}\n";
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
    return false;
  }
}
