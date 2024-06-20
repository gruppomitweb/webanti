public class spadministration_usersMNTarmt_cpusers_add {
  public static String[][] m_Fkd={
    {"code","CODE"}
  };
  public static int order = 0;
  public static void CopyKeys(spadministration_usersBO parent,armt_cpusers_addBO child) {
    child.w_CODE = parent.w_code;
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
    return "function SetChildVariables_armt_cpusers_add(){\n}\n";
  }
  public static String DoQueryFromChild() {
    return "function DoQueryFrom_cpusers_add(firstAlias){\n return m_cVirtName+'.code = '+firstAlias+'.CODE '\n}\n";
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
